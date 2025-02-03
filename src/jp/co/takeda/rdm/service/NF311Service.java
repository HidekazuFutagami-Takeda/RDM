/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NF311DTO;
import jp.co.takeda.rdm.entity.join.MRdmHcoOyakoEntity;
import jp.co.takeda.rdm.entity.join.RdmCommonEntity;
import jp.co.takeda.rdm.entity.join.SelectLnkTrtDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF211MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF311MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoLnkNxtReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoLnkReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF311)
 * @generated
 */
@Named
public class NF311Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF311Service.class);

    //20150303 ST-B-367対応 HISOL鈴木 ADD START
    /**
     * 共通処理Serviceオブジェクト
     *   新組織名称(変更前)取得処理
     */
    @javax.inject.Inject
    private CommonControlService commonControlService;
    //20150303 ST-B-367対応 HISOL鈴木 ADD END

    /**
     * イベント処理
     * @param indto NF311DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF311DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        // DropDownList作成
        createCombo(indto);
        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);

        String reqId = indto.getReqId();
        boolean errFlg = false;
        String errMsg = "";

        // 保存処理
        // 必須入力チェック
        if(indto.getTrtPrdGrp() == null || indto.getTrtPrdGrp().isEmpty()) {
        	// 必須項目にデータを入力してください。（領域）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "領域") + "\n";
			errFlg = true;
        }
        if(indto.getMainInsCd() == null || indto.getMainInsCd().isEmpty()) {
        	// 必須項目にデータを入力してください。（親施設）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "親施設") + "\n";
			errFlg = true;
        }
        if(indto.getTekiyoYmd() == null || indto.getTekiyoYmd().isEmpty()) {
        	// 必須項目にデータを入力してください。（適用日）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "適用日") + "\n";
			errFlg = true;
        }

        // レングスチェック
        if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
        	// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
        }
        if(indto.getAprMemo() != null && indto.getAprMemo().length() > 300) {
        	// 最大文字数を超えています。（審査・承認メモ）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "審査・承認メモ") + "\n";
			errFlg = true;
        }

        // 整合性チェック
        // 適用日が翌営業日以降ではない場合
        if(indto.getTekiyoYmd() != null && !indto.getTekiyoYmd().isEmpty()) {
        	// 翌営業日を取得
	        RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getNextBizday");
	    	rdmCommonEntity.setInVBatDate(sysDate.replace("-", ""));
	    	List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);

	    	Integer nextBizDay = Integer.parseInt(rdmCommonEntityList.get(0).getNextBizday());
	    	Integer tekiyoYmd = Integer.parseInt(indto.getTekiyoYmd().replace("-", ""));

	    	if (tekiyoYmd < nextBizDay) {
	    		// 適用日は翌営業日以降を指定してください。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W007) + "\n";
				errFlg = true;
	    	}
        }

        // 同じ施設固定コードに紐づく施設削除申請がすでに存在している場合
        TRdmHcoReqEntity tRdmHcoReqchkEntity = new TRdmHcoReqEntity("selectNF211InsChkData");
        tRdmHcoReqchkEntity.setInsNo(indto.getInsNo());
        List<TRdmHcoReqEntity> tRdmHcoReqchkEntityList = dao.select(tRdmHcoReqchkEntity);

        if(tRdmHcoReqchkEntityList.size() > 0) {
        	// 重複する申請が行われています。（施設コード）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "施設コード") + "\n";
        	errFlg = true;
        }

        // 同じ施設固定コード＋領域コード＋品目グループコードで申請されている
        if("0".equals(indto.getTkdTrtKbn())) {
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity("selectNF211TrtChkData");
        	tRdmHcoLnkNxtReqEntity.setInsNo(indto.getInsNo());
        	tRdmHcoLnkNxtReqEntity.setReqId(reqId);
        	List<TRdmHcoLnkNxtReqEntity> tRdmHcoLnkNxtReqEntityList = dao.select(tRdmHcoLnkNxtReqEntity);

        	if(tRdmHcoLnkNxtReqEntityList.size() > 0) {
        		// 申請する領域が重複しています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W021) + "\n";
            	errFlg = true;
        	}

        } else if(indto.getTrtPrdGrp() != null && !indto.getTrtPrdGrp().isEmpty()) {
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity("selectNF211TrtChkData");
        	tRdmHcoLnkReqEntity.setInsNo(indto.getInsNo());
        	tRdmHcoLnkReqEntity.setReqId(reqId);
        	tRdmHcoLnkReqEntity.setTrtCd(indto.getTrtPrdGrp().substring(0,2));
        	tRdmHcoLnkReqEntity.setHinGCd(indto.getTrtPrdGrp().substring(2));
        	List<TRdmHcoLnkReqEntity> tRdmHcoLnkReqEntityList = dao.select(tRdmHcoLnkReqEntity);

        	if(tRdmHcoLnkReqEntityList.size() > 0) {
        		// 申請する領域が重複しています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W021) + "\n";
            	errFlg = true;
        	}
        }

        // 親施設として設定している施設が、申請しようとしている領域で子施設として登録されていないこと
        if("0".equals(indto.getTkdTrtKbn())) {
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity("selectNF211TrtChkData");
        	tRdmHcoLnkNxtReqEntity.setInsNo(indto.getMainInsCd());
        	List<TRdmHcoLnkNxtReqEntity> tRdmHcoLnkNxtReqEntityList = dao.select(tRdmHcoLnkNxtReqEntity);

        	MRdmHcoOyakoEntity mRdmHcoOyakoEntity = new MRdmHcoOyakoEntity();
        	mRdmHcoOyakoEntity.setInsNo(indto.getMainInsCd());
        	mRdmHcoOyakoEntity.setTrtCd("00");

        	List<MRdmHcoOyakoEntity> mRdmHcoOyakoEntityList = dao.selectByValue(mRdmHcoOyakoEntity);

        	if(tRdmHcoLnkNxtReqEntityList.size() > 0 || mRdmHcoOyakoEntityList.size() > 0) {
        		// 親施設に選択した施設が同じ領域で子施設となっています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W022) + "\n";
            	errFlg = true;
        	}

        } else if(indto.getTrtPrdGrp() != null && !indto.getTrtPrdGrp().isEmpty()) {
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity("selectNF211TrtChkData");
        	tRdmHcoLnkReqEntity.setInsNo(indto.getMainInsCd());
        	tRdmHcoLnkReqEntity.setTrtCd(indto.getTrtPrdGrp().substring(0,2));
        	tRdmHcoLnkReqEntity.setHinGCd(indto.getTrtPrdGrp().substring(2));
        	List<TRdmHcoLnkReqEntity> tRdmHcoLnkReqEntityList = dao.select(tRdmHcoLnkReqEntity);

        	MRdmHcoOyakoEntity mRdmHcoOyakoEntity = new MRdmHcoOyakoEntity();
        	mRdmHcoOyakoEntity.setInsNo(indto.getMainInsCd());
        	mRdmHcoOyakoEntity.setTrtCd(indto.getTrtPrdGrp().substring(0,2));
        	mRdmHcoOyakoEntity.setHinGCd(indto.getTrtPrdGrp().substring(2));

        	List<MRdmHcoOyakoEntity> mRdmHcoOyakoEntityList = dao.selectByValue(mRdmHcoOyakoEntity);

        	if(tRdmHcoLnkReqEntityList.size() > 0 || mRdmHcoOyakoEntityList.size() > 0) {
        		// 親施設に選択した施設が同じ領域で子施設となっています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W022) + "\n";
            	errFlg = true;
        	}
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
        	tRdmReqKnrChkEntity.setReqId(reqId);

        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

        	if(tRdmReqKnrEntityList.size() > 0) {
        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(indto.getUpdShaYmd())) {
        			// 既に他のユーザーによってデータが処理されています。
        			errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
        			errFlg = true;
        		}
        	}
        }

        // エラー時処理
        if(errFlg) {
        	indto.setMsgStr(errMsg);
        	outdto.setForward("NF211");
        	return outdto;
        }

        // 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
        // 申請管理
        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
        tRdmReqKnrEntity.setReqId(indto.getReqId());
        TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

        if(tRdmReqKnrData == null) {
        	// 新規登録
        	// 新規にIDを取得
        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
        	reqId = seqRdmReqIdDate.get(0).getReqId();

        	// レコードを登録
        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
        	tRdmReqKnrInsData.setReqId(reqId);
        	if("JKN0813".equals(indto.getLoginJokenSetCd())) {
        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
        		tRdmReqKnrInsData.setReqChl("2");
        		tRdmReqKnrInsData.setReqKngKbn("2");
        	} else {
        		// "MRが申請の場合、'1'(MR起因)
        		tRdmReqKnrInsData.setReqChl("1");
        		tRdmReqKnrInsData.setReqKngKbn("1");
        	}
        	tRdmReqKnrInsData.setReqType("11");
        	tRdmReqKnrInsData.setReqStsCd("01");

        	String tekiyoYmd = indto.getTekiyoYmd();
        	if(tekiyoYmd != null) {
        		tekiyoYmd = tekiyoYmd.replace("-", "");
        	}
        	tRdmReqKnrInsData.setTekiyoYmd(tekiyoYmd);

        	tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
        	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
        	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
        	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
        	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
        	tRdmReqKnrInsData.setInsShaYmd(sysDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(sysDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

        } else {
        	// 更新
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF211Data");
        	tRdmReqKnrUpdData.setReqId(reqId);

        	if("13".equals(indto.getReqStsCd())) {
        		tRdmReqKnrUpdData.setReqStsCd("11");
        	} else {
        		tRdmReqKnrUpdData.setReqStsCd("01");
        	}
        	String tekiyoYmd = indto.getTekiyoYmd();
        	if(tekiyoYmd != null) {
        		tekiyoYmd = tekiyoYmd.replace("-", "");
        	}
        	tRdmReqKnrUpdData.setTekiyoYmd(tekiyoYmd);
        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
        	tRdmReqKnrUpdData.setUpdShaYmd(sysDate);
        	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrUpdData);
        }

        // 武田紐親子_来期用_申請管理
        TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity();
        tRdmHcoLnkNxtReqEntity.setReqId(reqId);
        TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqData = dao.selectByPK(tRdmHcoLnkNxtReqEntity);

        if(tRdmHcoLnkNxtReqData == null) {
        	// 新規登録
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqInsData = new TRdmHcoLnkNxtReqEntity();
        	tRdmHcoLnkNxtReqInsData.setReqId(reqId);
        	tRdmHcoLnkNxtReqInsData.setTrtCd("00");
        	tRdmHcoLnkNxtReqInsData.setInsNo(indto.getInsNo());
        	tRdmHcoLnkNxtReqInsData.setMainInsFlgBf("1");
        	tRdmHcoLnkNxtReqInsData.setMainInsNoAf(indto.getMainInsCd());
        	tRdmHcoLnkNxtReqInsData.setMainInsFlgAf("0");
        	tRdmHcoLnkNxtReqInsData.setInsSbtAf(indto.getMainInsSbt());
        	tRdmHcoLnkNxtReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoLnkNxtReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoLnkNxtReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoLnkNxtReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoLnkNxtReqInsData);

        } else {
        	// 更新
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqUpdData = new TRdmHcoLnkNxtReqEntity("updateNF211Data");
        	tRdmHcoLnkNxtReqUpdData.setReqId(reqId);
        	tRdmHcoLnkNxtReqUpdData.setMainInsNoAf(indto.getMainInsCd());
        	tRdmHcoLnkNxtReqUpdData.setInsSbtAf(indto.getMainInsSbt());
        	tRdmHcoLnkNxtReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoLnkNxtReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmHcoLnkNxtReqUpdData);
        }

        // 領域品目グループ別親子_申請管理
        TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity();
        tRdmHcoLnkReqEntity.setReqId(reqId);
        TRdmHcoLnkReqEntity tRdmHcoLnkReqData = dao.selectByPK(tRdmHcoLnkReqEntity);

        if(tRdmHcoLnkReqData == null) {
        	// 新規登録
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqInsData = new TRdmHcoLnkReqEntity();
        	tRdmHcoLnkReqInsData.setReqId(reqId);

        	String trtPrdCd = indto.getTrtPrdGrp();
        	if(trtPrdCd != null && trtPrdCd.length() > 1) {
        		tRdmHcoLnkReqInsData.setTrtCd(trtPrdCd.substring(0,2));
        	}
        	if(trtPrdCd != null && trtPrdCd.length() > 2) {
        		tRdmHcoLnkReqInsData.setHinGCd(trtPrdCd.substring(2));
        	}

        	tRdmHcoLnkReqInsData.setInsNo(indto.getInsNo());
        	tRdmHcoLnkReqInsData.setMainInsFlgBf("1");
        	tRdmHcoLnkReqInsData.setMainInsNoAf(indto.getMainInsCd());
        	tRdmHcoLnkReqInsData.setMainInsFlgAf("0");
        	tRdmHcoLnkReqInsData.setInsSbtAf(indto.getMainInsSbt());
        	tRdmHcoLnkReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoLnkReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoLnkReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoLnkReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoLnkReqInsData);

        } else {
        	// 更新
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqUpdData = new TRdmHcoLnkReqEntity("updateNF211Data");
        	tRdmHcoLnkReqUpdData.setReqId(reqId);

        	String trtPrdCd = indto.getTrtPrdGrp();
        	if(trtPrdCd != null && trtPrdCd.length() > 1) {
        		tRdmHcoLnkReqUpdData.setTrtCd(trtPrdCd.substring(0,2));
        	}
        	if(trtPrdCd != null && trtPrdCd.length() > 2) {
        		tRdmHcoLnkReqUpdData.setHinGCd(trtPrdCd.substring(2));
        	}

        	tRdmHcoLnkReqUpdData.setMainInsNoAf(indto.getMainInsCd());
        	tRdmHcoLnkReqUpdData.setInsSbtAf(indto.getMainInsSbt());
        	tRdmHcoLnkReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoLnkReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmHcoLnkReqUpdData);
        }

    	indto.setReqId(reqId);

        // 初期表示検索
    	if ("0".equals(indto.getTkdTrtKbn())) {
        	// 申請データ（一時保存含む）を参照
        	// 武田紐領域別区分が'0'（来期用紐付け(武田紐)）
        	SelectNF211MainDataEntity paramEntity = new SelectNF211MainDataEntity();
    		paramEntity.setInReqId(indto.getReqId());
    		List<SelectNF211MainDataEntity> mainDataEntityList = dao.select(paramEntity);
    		SelectNF211MainDataEntity mainDataEntity = mainDataEntityList.get(0);

    		// 申請情報
    		indto.setReqShzNm(StringUtils.nvl(mainDataEntity.getReqShzNm(), ""));
    		indto.setReqStsNm(StringUtils.nvl(mainDataEntity.getReqStsNm(), ""));
    		indto.setReqJgiName(StringUtils.nvl(mainDataEntity.getReqJgiName(), ""));
    		indto.setShnShaName(StringUtils.nvl(mainDataEntity.getShnShaName(), ""));
    		indto.setAprShaName(StringUtils.nvl(mainDataEntity.getAprShaName(), ""));

    		SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
    		SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    		if(mainDataEntity.getReqYmdhms() != null && mainDataEntity.getReqYmdhms().length() == 14) {
				try {
					Date reqYmd = sdfDateTime.parse(mainDataEntity.getReqYmdhms());
					String strReqYmd = sdfDateTime2.format(reqYmd);
					indto.setReqYmdhms(strReqYmd);
				} catch (ParseException e) {
					e.printStackTrace();
					indto.setReqYmdhms(StringUtils.nvl(mainDataEntity.getReqYmdhms(), ""));
				}
    		} else {
    			indto.setReqYmdhms(StringUtils.nvl(mainDataEntity.getReqYmdhms(), ""));
    		}

    		if(mainDataEntity.getShnYmdhms() != null && mainDataEntity.getShnYmdhms().length() == 14) {
				try {
					Date shnYmd = sdfDateTime.parse(mainDataEntity.getShnYmdhms());
					String strShnYmd = sdfDateTime2.format(shnYmd);
					indto.setShnYmdhms(strShnYmd);
				} catch (ParseException e) {
					e.printStackTrace();
					indto.setShnYmdhms(StringUtils.nvl(mainDataEntity.getShnYmdhms(), ""));
				}
    		} else {
    			indto.setShnYmdhms(StringUtils.nvl(mainDataEntity.getShnYmdhms(), ""));
    		}

    		if(mainDataEntity.getAprYmdhms() != null && mainDataEntity.getAprYmdhms().length() == 14) {
				try {
					Date aprYmd = sdfDateTime.parse(mainDataEntity.getAprYmdhms());
					String strAprYmd = sdfDateTime2.format(aprYmd);
					indto.setAprYmdhms(strAprYmd);
				} catch (ParseException e) {
					e.printStackTrace();
					indto.setAprYmdhms(StringUtils.nvl(mainDataEntity.getAprYmdhms(), ""));
				}
    		} else {
    			indto.setAprYmdhms(StringUtils.nvl(mainDataEntity.getAprYmdhms(), ""));
    		}

    		indto.setReqJgiNo(mainDataEntity.getReqJgiNo());
    		indto.setReqBrCd(StringUtils.nvl(mainDataEntity.getReqBrCd(), ""));
    		indto.setReqDistCd(StringUtils.nvl(mainDataEntity.getReqDistCd(), ""));
    		indto.setReqStsCd(StringUtils.nvl(mainDataEntity.getReqStsCd(), ""));
    		indto.setShnJgiNo(mainDataEntity.getShnJgiNo());
    		indto.setAprJgiNo(mainDataEntity.getAprJgiNo());
    		indto.setUpdShaYmd(StringUtils.nvl(mainDataEntity.getUpdShaYmd(), ""));

    		// 施設情報
    		indto.setInsNo(StringUtils.nvl(mainDataEntity.getInsNo(), ""));
        	indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
        	indto.setInsAddr(StringUtils.nvl(mainDataEntity.getInsAddr(), ""));
        	indto.setInsSbt(StringUtils.nvl(mainDataEntity.getInsSbt(), ""));

        	// 施設紐付け情報
        	indto.setTrtPrdGrp("00Z");

        	// 適用日を"yyyy-MM-dd"に変換
    		if(mainDataEntity.getTekiyoYmd() != null && mainDataEntity.getTekiyoYmd().length() == 8) {
    			StringBuilder sbTekiyoYmd = new StringBuilder();
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(0,4));
    			sbTekiyoYmd.append("-");
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(4,6));
    			sbTekiyoYmd.append("-");
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(6,8));
    			indto.setTekiyoYmd(sbTekiyoYmd.toString());
    		}

    		indto.setMainInsCd(StringUtils.nvl(mainDataEntity.getMainInsCd(), ""));
    		indto.setMainInsNm(StringUtils.nvl(mainDataEntity.getMainInsNm(), ""));
        	indto.setMainInsAddr(StringUtils.nvl(mainDataEntity.getMainInsAddr(), ""));
        	indto.setMainInsSbt(StringUtils.nvl(mainDataEntity.getMainInsSbt(), ""));
        	indto.setInsSbtAf(StringUtils.nvl(mainDataEntity.getInsSbtAf(), ""));

        	indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
        	indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
        	indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), ""));

        } else {
    		// 申請データ（一時保存含む）を参照
        	// 武田紐領域別区分が'1'（領域別紐付け）
    		SelectNF311MainDataEntity paramEntity = new SelectNF311MainDataEntity();
    		paramEntity.setInReqId(indto.getReqId());
    		List<SelectNF311MainDataEntity> mainDataEntityList = dao.select(paramEntity);
    		SelectNF311MainDataEntity mainDataEntity = mainDataEntityList.get(0);

    		// 申請情報
    		indto.setReqShzNm(StringUtils.nvl(mainDataEntity.getReqShzNm(), ""));
    		indto.setReqStsNm(StringUtils.nvl(mainDataEntity.getReqStsNm(), ""));
    		indto.setReqJgiName(StringUtils.nvl(mainDataEntity.getReqJgiName(), ""));
    		indto.setShnShaName(StringUtils.nvl(mainDataEntity.getShnShaName(), ""));
    		indto.setAprShaName(StringUtils.nvl(mainDataEntity.getAprShaName(), ""));

    		SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
    		SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    		if(mainDataEntity.getReqYmdhms() != null && mainDataEntity.getReqYmdhms().length() == 14) {
				try {
					Date reqYmd = sdfDateTime.parse(mainDataEntity.getReqYmdhms());
					String strReqYmd = sdfDateTime2.format(reqYmd);
					indto.setReqYmdhms(strReqYmd);
				} catch (ParseException e) {
					e.printStackTrace();
					indto.setReqYmdhms(StringUtils.nvl(mainDataEntity.getReqYmdhms(), ""));
				}
    		} else {
    			indto.setReqYmdhms(StringUtils.nvl(mainDataEntity.getReqYmdhms(), ""));
    		}

    		if(mainDataEntity.getShnYmdhms() != null && mainDataEntity.getShnYmdhms().length() == 14) {
				try {
					Date shnYmd = sdfDateTime.parse(mainDataEntity.getShnYmdhms());
					String strShnYmd = sdfDateTime2.format(shnYmd);
					indto.setShnYmdhms(strShnYmd);
				} catch (ParseException e) {
					e.printStackTrace();
					indto.setShnYmdhms(StringUtils.nvl(mainDataEntity.getShnYmdhms(), ""));
				}
    		} else {
    			indto.setShnYmdhms(StringUtils.nvl(mainDataEntity.getShnYmdhms(), ""));
    		}

    		if(mainDataEntity.getAprYmdhms() != null && mainDataEntity.getAprYmdhms().length() == 14) {
				try {
					Date aprYmd = sdfDateTime.parse(mainDataEntity.getAprYmdhms());
					String strAprYmd = sdfDateTime2.format(aprYmd);
					indto.setAprYmdhms(strAprYmd);
				} catch (ParseException e) {
					e.printStackTrace();
					indto.setAprYmdhms(StringUtils.nvl(mainDataEntity.getAprYmdhms(), ""));
				}
    		} else {
    			indto.setAprYmdhms(StringUtils.nvl(mainDataEntity.getAprYmdhms(), ""));
    		}

    		indto.setReqJgiNo(mainDataEntity.getReqJgiNo());
    		indto.setReqBrCd(StringUtils.nvl(mainDataEntity.getReqBrCd(), ""));
    		indto.setReqDistCd(StringUtils.nvl(mainDataEntity.getReqDistCd(), ""));
    		indto.setReqStsCd(StringUtils.nvl(mainDataEntity.getReqStsCd(), ""));
    		indto.setShnJgiNo(mainDataEntity.getShnJgiNo());
    		indto.setAprJgiNo(mainDataEntity.getAprJgiNo());
    		indto.setUpdShaYmd(StringUtils.nvl(mainDataEntity.getUpdShaYmd(), ""));

    		// 施設情報
    		indto.setInsNo(StringUtils.nvl(mainDataEntity.getInsNo(), ""));
        	indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
        	indto.setInsAddr(StringUtils.nvl(mainDataEntity.getInsAddr(), ""));
        	indto.setInsSbt(StringUtils.nvl(mainDataEntity.getInsSbt(), ""));

        	// 施設紐付け情報
        	indto.setTrtPrdGrp(mainDataEntity.getTrtCd() + mainDataEntity.getHinGCd());
        	if(!"・".equals(mainDataEntity.getTrtPrdGrpNm())) {
        		indto.setTrtPrdGrpNm(mainDataEntity.getTrtPrdGrpNm());
        	} else {
        		indto.setTrtPrdGrpNm("");
        	}

        	// 適用日を"yyyy/MM/dd"に変換
    		if(mainDataEntity.getTekiyoYmd() != null && mainDataEntity.getTekiyoYmd().length() == 8) {
    			StringBuilder sbTekiyoYmd = new StringBuilder();
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(0,4));
    			sbTekiyoYmd.append("/");
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(4,6));
    			sbTekiyoYmd.append("/");
    			sbTekiyoYmd.append(mainDataEntity.getTekiyoYmd().substring(6,8));
    			indto.setTekiyoYmd(sbTekiyoYmd.toString());
    		}

    		indto.setMainInsCd(StringUtils.nvl(mainDataEntity.getMainInsCd(), ""));
    		indto.setMainInsNm(StringUtils.nvl(mainDataEntity.getMainInsNm(), ""));
        	indto.setMainInsAddr(StringUtils.nvl(mainDataEntity.getMainInsAddr(), ""));
        	indto.setInsTanto(StringUtils.nvl(mainDataEntity.getJgiName(), ""));
        	indto.setMainInsSbt(StringUtils.nvl(mainDataEntity.getMainInsSbt(), ""));
        	indto.setInsSbtAf(StringUtils.nvl(mainDataEntity.getInsSbtAf(), ""));

        	indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
        	indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
        	indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
        	indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), ""));
        }

		// 申請ボタン活性フラグ取得

        // END UOC
		outdto.setForward("NF311");
        return outdto;
    }

    /**
     * コンボ作成
     * @param indto NF311DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF311DTO indto){
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
    	// 領域・品目グループ
    	SelectLnkTrtDataEntity inEntityCmb = new SelectLnkTrtDataEntity("selectTrtPrdComboData");
    	inEntityCmb.setInInsNo(indto.getInsNo());
    	if("JKN0023".equals(indto.getLoginJokenSetCd())) {
    		// ※MR権限の場合のみ ログインユーザ情報.領域コード
    		inEntityCmb.setInTrtCd(indto.getLoginTrtCd());
    	}
        List<SelectLnkTrtDataEntity> outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapTrtPrdGrp = new LinkedHashMap<String, String>();
        mapTrtPrdGrp.put("", "--選択してください--");
        for (SelectLnkTrtDataEntity outEntity : outMainList) {
        	if(outEntity != null) {
	        	mapTrtPrdGrp.put(outEntity.getTrtCd() + outEntity.getHinGCd(),
	        				outEntity.getTrtNm()+"・"+outEntity.getHinGName());
        	}
        }
        indto.setTrtPrdGrpCombo(mapTrtPrdGrp);
    }

    /**
     * イベント処理
     * @param indto NF311DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF311DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        outdto.setForward("NF311");

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";

//        if("3".equals(indto.getFuncId())) {
//			if(indto.getAprComment() != null && indto.getAprComment().isEmpty()) {
//	        	// 却下の場合はコメントを入力してください。
//				errMsg += loginInfo.getMsgData(RdmConstantsData.W026) + "\n";
//				errFlg = true;
//	        }
//        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
		if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
			TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
			tRdmReqKnrChkEntity.setReqId(indto.getReqId());

			List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

			if(tRdmReqKnrEntityList.size() > 0) {
				if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(indto.getUpdShaYmd())) {
					// 既に他のユーザーによってデータが処理されています。
					errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
					errFlg = true;
				}
			}
		}

        // エラー時処理
        if(errFlg) {
        	indto.setMsgStr(errMsg);
        	return outdto;
        }


		// END UOC
		return outdto;
    }

	/**
     * イベント処理
     * @param indto NF311DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO apprRej(NF311DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        // DropDownList作成
        createCombo(indto);
        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);

        String reqId = indto.getReqId();

        boolean errFlg = false;
        String errMsg = "";

        // 保存処理
        // 必須入力チェック
        if(indto.getTrtPrdGrp() == null || indto.getTrtPrdGrp().isEmpty()) {
        	// 必須項目にデータを入力してください。（領域）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "領域") + "\n";
			errFlg = true;
        }
        if(indto.getMainInsCd() == null || indto.getMainInsCd().isEmpty()) {
        	// 必須項目にデータを入力してください。（親施設）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "親施設") + "\n";
			errFlg = true;
        }
        if(indto.getTekiyoYmd() == null || indto.getTekiyoYmd().isEmpty()) {
        	// 必須項目にデータを入力してください。（適用日）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "適用日") + "\n";
			errFlg = true;
        }

        // レングスチェック
        if(indto.getReqComment() != null && indto.getReqComment().length() > 300) {
        	// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
        }
        if(indto.getAprMemo() != null && indto.getAprMemo().length() > 300) {
        	// 最大文字数を超えています。（審査・承認メモ）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "審査・承認メモ") + "\n";
			errFlg = true;
        }

        // 整合性チェック
        // 適用日が翌営業日以降ではない場合
        if(indto.getTekiyoYmd() != null && !indto.getTekiyoYmd().isEmpty()) {
        	// 翌営業日を取得
	        RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getNextBizday");
	    	rdmCommonEntity.setInVBatDate(sysDate.replace("-", ""));
	    	List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);

	    	Integer nextBizDay = Integer.parseInt(rdmCommonEntityList.get(0).getNextBizday());
	    	Integer tekiyoYmd = Integer.parseInt(indto.getTekiyoYmd().replace("-", ""));

	    	if (tekiyoYmd < nextBizDay) {
	    		// 適用日は翌営業日以降を指定してください。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W007) + "\n";
				errFlg = true;
	    	}
        }

        // 同じ施設固定コードに紐づく施設削除申請がすでに存在している場合
        TRdmHcoReqEntity tRdmHcoReqchkEntity = new TRdmHcoReqEntity("selectNF211InsChkData");
        tRdmHcoReqchkEntity.setInsNo(indto.getInsNo());
        List<TRdmHcoReqEntity> tRdmHcoReqchkEntityList = dao.select(tRdmHcoReqchkEntity);

        if(tRdmHcoReqchkEntityList.size() > 0) {
        	// 重複する申請が行われています。（施設コード）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "施設コード") + "\n";
        	errFlg = true;
        }

        // 同じ施設固定コード＋領域コード＋品目グループコードで申請されている
        if("0".equals(indto.getTkdTrtKbn())) {
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity("selectNF211TrtChkData");
        	tRdmHcoLnkNxtReqEntity.setInsNo(indto.getInsNo());
        	tRdmHcoLnkNxtReqEntity.setReqId(reqId);
        	List<TRdmHcoLnkNxtReqEntity> tRdmHcoLnkNxtReqEntityList = dao.select(tRdmHcoLnkNxtReqEntity);

        	if(tRdmHcoLnkNxtReqEntityList.size() > 0) {
        		// 申請する領域が重複しています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W021) + "\n";
            	errFlg = true;
        	}

        } else if(indto.getTrtPrdGrp() != null && !indto.getTrtPrdGrp().isEmpty()) {
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity("selectNF211TrtChkData");
        	tRdmHcoLnkReqEntity.setInsNo(indto.getInsNo());
        	tRdmHcoLnkReqEntity.setReqId(reqId);
        	tRdmHcoLnkReqEntity.setTrtCd(indto.getTrtPrdGrp().substring(0,2));
        	tRdmHcoLnkReqEntity.setHinGCd(indto.getTrtPrdGrp().substring(2));
        	List<TRdmHcoLnkReqEntity> tRdmHcoLnkReqEntityList = dao.select(tRdmHcoLnkReqEntity);

        	if(tRdmHcoLnkReqEntityList.size() > 0) {
        		// 申請する領域が重複しています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W021) + "\n";
            	errFlg = true;
        	}
        }

        // 親施設として設定している施設が、申請しようとしている領域で子施設として登録されていないこと
        if("0".equals(indto.getTkdTrtKbn())) {
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity("selectNF211TrtChkData");
        	tRdmHcoLnkNxtReqEntity.setInsNo(indto.getMainInsCd());
        	List<TRdmHcoLnkNxtReqEntity> tRdmHcoLnkNxtReqEntityList = dao.select(tRdmHcoLnkNxtReqEntity);

        	MRdmHcoOyakoEntity mRdmHcoOyakoEntity = new MRdmHcoOyakoEntity();
        	mRdmHcoOyakoEntity.setInsNo(indto.getMainInsCd());
        	mRdmHcoOyakoEntity.setTrtCd("00");

        	List<MRdmHcoOyakoEntity> mRdmHcoOyakoEntityList = dao.selectByValue(mRdmHcoOyakoEntity);

        	if(tRdmHcoLnkNxtReqEntityList.size() > 0 || mRdmHcoOyakoEntityList.size() > 0) {
        		// 親施設に選択した施設が同じ領域で子施設となっています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W022) + "\n";
            	errFlg = true;
        	}

        } else if(indto.getTrtPrdGrp() != null && !indto.getTrtPrdGrp().isEmpty()) {
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity("selectNF211TrtChkData");
        	tRdmHcoLnkReqEntity.setInsNo(indto.getMainInsCd());
        	tRdmHcoLnkReqEntity.setTrtCd(indto.getTrtPrdGrp().substring(0,2));
        	tRdmHcoLnkReqEntity.setHinGCd(indto.getTrtPrdGrp().substring(2));
        	List<TRdmHcoLnkReqEntity> tRdmHcoLnkReqEntityList = dao.select(tRdmHcoLnkReqEntity);

        	MRdmHcoOyakoEntity mRdmHcoOyakoEntity = new MRdmHcoOyakoEntity();
        	mRdmHcoOyakoEntity.setInsNo(indto.getMainInsCd());
        	mRdmHcoOyakoEntity.setTrtCd(indto.getTrtPrdGrp().substring(0,2));
        	mRdmHcoOyakoEntity.setHinGCd(indto.getTrtPrdGrp().substring(2));

        	List<MRdmHcoOyakoEntity> mRdmHcoOyakoEntityList = dao.selectByValue(mRdmHcoOyakoEntity);

        	if(tRdmHcoLnkReqEntityList.size() > 0 || mRdmHcoOyakoEntityList.size() > 0) {
        		// 親施設に選択した施設が同じ領域で子施設となっています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W022) + "\n";
            	errFlg = true;
        	}
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
        	tRdmReqKnrChkEntity.setReqId(reqId);

        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

        	if(tRdmReqKnrEntityList.size() > 0) {
        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(indto.getUpdShaYmd())) {
        			// 既に他のユーザーによってデータが処理されています。
        			errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
        			errFlg = true;
        		}
        	}
        }

        // エラー時処理
        if(errFlg) {
        	indto.setMsgStr(errMsg);
        	outdto.setForward("NF211");
        	return outdto;
        }

        // 申請管理
    	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateTRdmReqKnrData");
    	tRdmReqKnrUpdData.setReqId(reqId);
    	String tekiyoYmd = indto.getTekiyoYmd();
    	if(tekiyoYmd != null) {
    		tekiyoYmd = tekiyoYmd.replace("-", "");
    	}
    	tRdmReqKnrUpdData.setTekiyoYmd(tekiyoYmd);
    	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
    	tRdmReqKnrUpdData.setAprMemo(indto.getAprMemo());
    	tRdmReqKnrUpdData.setUpdShaYmd(sysDate);
    	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

    	dao.update(tRdmReqKnrUpdData);

        // 武田紐親子_来期用_申請管理
    	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqUpdData = new TRdmHcoLnkNxtReqEntity("updateNF211Data");
    	tRdmHcoLnkNxtReqUpdData.setReqId(reqId);
    	tRdmHcoLnkNxtReqUpdData.setMainInsNoAf(indto.getMainInsCd());
    	tRdmHcoLnkNxtReqUpdData.setInsSbtAf(indto.getMainInsSbt());
    	tRdmHcoLnkNxtReqUpdData.setUpdShaYmd(sysDate);
    	tRdmHcoLnkNxtReqUpdData.setUpdShaId(indto.getLoginJgiNo());

    	dao.update(tRdmHcoLnkNxtReqUpdData);

        // 領域品目グループ別親子_申請管理
    	TRdmHcoLnkReqEntity tRdmHcoLnkReqUpdData = new TRdmHcoLnkReqEntity("updateNF211Data");
    	tRdmHcoLnkReqUpdData.setReqId(reqId);

    	String trtPrdCd = indto.getTrtPrdGrp();
    	if(trtPrdCd != null && trtPrdCd.length() > 1) {
    		tRdmHcoLnkReqUpdData.setTrtCd(trtPrdCd.substring(0,2));
    	}
    	if(trtPrdCd != null && trtPrdCd.length() > 2) {
    		tRdmHcoLnkReqUpdData.setHinGCd(trtPrdCd.substring(2));
    	}

    	tRdmHcoLnkReqUpdData.setMainInsNoAf(indto.getMainInsCd());
    	tRdmHcoLnkReqUpdData.setInsSbtAf(indto.getMainInsSbt());
    	tRdmHcoLnkReqUpdData.setUpdShaYmd(sysDate);
    	tRdmHcoLnkReqUpdData.setUpdShaId(indto.getLoginJgiNo());

    	dao.update(tRdmHcoLnkReqUpdData);

    	indto.setReqId(reqId);

		// 申請ボタン活性フラグ取得
//		indto.setBtnEnableFlg("0");
//		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
//		mRdmParamMstEntity.setParamName("MN_FAC");
//		mRdmParamMstEntity.setDelFlg("0");
//
//		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
//		if(mRdmParamMstEntityList.size() > 0) {
//			// valueの左一桁
//			String value = mRdmParamMstEntityList.get(0).getValue().substring(0,1);
//			if("1".equals(value)) {
//				// 申請ボタン活性
//				indto.setBtnEnableFlg("1");
//			}
//		}

        // END UOC
        outdto.setForward("NF311");
        return outdto;
    }
}
