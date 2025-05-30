/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NF315DTO;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.RdmCommonEntity;
import jp.co.takeda.rdm.entity.join.SelectNF213MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF315MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoLnkNxtReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoLnkReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF315)
 * @generated
 */
@Named
public class NF315Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF315Service.class);

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
     * @param indto NF315DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF315DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);

        String reqId = indto.getReqId();
        if(StringUtils.isEmpty(reqId)) {
        	reqId = null;
        }
        boolean errFlg = false;
        String errMsg = "";

        // 保存処理
        // 必須入力チェック
        if(indto.getTekiyoYmd() == null || indto.getTekiyoYmd().isEmpty()) {
        	// 必須項目にデータを入力してください。（適用日）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "適用日") + "\n";
			errFlg = true;
        }

        // レングスチェック
        if(indto.getReqComment() != null && StringUtils.getByteLength(indto.getReqComment()) > 300) {
        	// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
        }
        if(indto.getAprMemo() != null && StringUtils.getByteLength(indto.getAprMemo()) > 300) {
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
	    	Integer tekiyoYmd = Integer.parseInt(indto.getTekiyoYmd().replace("-", "").replace("/", ""));

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

        // 同じ施設固定コード＋領域コード＋品目グループで施設紐付け削除申請されている
        if("0".equals(indto.getTkdTrtKbn())) {
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity("selectNF212TrtChkData");
        	tRdmHcoLnkNxtReqEntity.setInsNo(indto.getInsNo());
        	tRdmHcoLnkNxtReqEntity.setReqId(reqId);
        	List<TRdmHcoLnkNxtReqEntity> tRdmHcoLnkNxtReqEntityList = dao.select(tRdmHcoLnkNxtReqEntity);

        	if(tRdmHcoLnkNxtReqEntityList.size() > 0) {
        		// 申請する領域が重複しています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W021) + "\n";
            	errFlg = true;
        	}

        } else {
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity("selectNF212TrtChkData");
        	tRdmHcoLnkReqEntity.setInsNo(indto.getInsNo());
        	tRdmHcoLnkReqEntity.setReqId(reqId);
        	tRdmHcoLnkReqEntity.setTrtCd(indto.getTrtCd());
        	tRdmHcoLnkReqEntity.setHinGCd(indto.getHinGCd());
        	List<TRdmHcoLnkReqEntity> tRdmHcoLnkReqEntityList = dao.select(tRdmHcoLnkReqEntity);

        	if(tRdmHcoLnkReqEntityList.size() > 0) {
        		// 申請する領域が重複しています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W021) + "\n";
            	errFlg = true;
        	}
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
        	tRdmReqKnrChkEntity.setReqId(reqId);

        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

        	if(tRdmReqKnrEntityList.size() > 0) {
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        		Date updDate = null;
                try {
					updDate = sdFormat.parse(indto.getUpdShaYmd());
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
        			// 既に他のユーザーによってデータが処理されています。
        			errMsg += loginInfo.getMsgData(RdmConstantsData.E003) + "\n";
    	        	errFlg = true;

        		}
        	}
        }

        // エラー時処理
        if(errFlg) {
        	String title = "NF213_施設紐付け削除";
            indto.setTitle(title);
        	indto.setMsgStr(errMsg);
        	outdto.setForward("NF213");
        	return outdto;
        }

        if(indto.getTekiyoYmd() != null) {
    		indto.setTekiyoYmd(indto.getTekiyoYmd().replace("-", "/"));
    	}

    	// 申請ボタン活性フラグ取得
    	String mnFac = "0";
    	String mnOya = "0";

		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName("MN_FAC");
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// valueの左から三桁目
			mnFac = mRdmParamMstEntityList.get(0).getValue().substring(2,3);
		}

		MRdmParamMstEntity mRdmParamMstOyaEntity = new MRdmParamMstEntity();
		if("0".equals(indto.getTkdTrtKbn())) {
			mRdmParamMstOyaEntity.setParamName("MN_NT_OYA");
		} else {
			mRdmParamMstOyaEntity.setParamName("MN_CT_OYA");
		}
		mRdmParamMstOyaEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstOyaEntityList = dao.selectByValue(mRdmParamMstOyaEntity);
		if(mRdmParamMstOyaEntityList.size() > 0) {
			// value
			mnOya = mRdmParamMstOyaEntityList.get(0).getValue();
		}

		if(mnFac.equals("1") && mnOya.equals("1")) {
			indto.setBtnEnableFlg("1");
		} else {
			indto.setBtnEnableFlg("0");
		}

        // END UOC
		outdto.setForward("NF315");
        return outdto;
    }

    /**
     * イベント処理
     * @param indto NF315DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF315DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        outdto.setForward("NF315");

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";

        // 同じ施設固定コード＋領域コード＋品目グループで施設紐付け削除申請されている
        if("0".equals(indto.getTkdTrtKbn())) {
        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqEntity = new TRdmHcoLnkNxtReqEntity("selectNF212TrtChkData");
        	tRdmHcoLnkNxtReqEntity.setInsNo(indto.getInsNo());
        	tRdmHcoLnkNxtReqEntity.setReqId(indto.getReqId());
        	List<TRdmHcoLnkNxtReqEntity> tRdmHcoLnkNxtReqEntityList = dao.select(tRdmHcoLnkNxtReqEntity);

        	if(tRdmHcoLnkNxtReqEntityList.size() > 0) {
        		// 申請する領域が重複しています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W021) + "\n";
            	errFlg = true;
        	}

        } else {
        	TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity("selectNF212TrtChkData");
        	tRdmHcoLnkReqEntity.setInsNo(indto.getInsNo());
        	tRdmHcoLnkReqEntity.setReqId(indto.getReqId());
        	tRdmHcoLnkReqEntity.setTrtCd(indto.getTrtCd());
        	tRdmHcoLnkReqEntity.setHinGCd(indto.getHinGCd());
        	List<TRdmHcoLnkReqEntity> tRdmHcoLnkReqEntityList = dao.select(tRdmHcoLnkReqEntity);

        	if(tRdmHcoLnkReqEntityList.size() > 0) {
        		// 申請する領域が重複しています。
            	errMsg += loginInfo.getMsgData(RdmConstantsData.W021) + "\n";
            	errFlg = true;
        	}
        }

        if("3".equals(indto.getFuncId())) {
			if(indto.getAprComment() != null && indto.getAprComment().isEmpty()) {
	        	// 却下の場合はコメントを入力してください。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W026) + "\n";
				errFlg = true;
	        }
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
		if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
			TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
			tRdmReqKnrChkEntity.setReqId(indto.getReqId());

			List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

			if(tRdmReqKnrEntityList.size() > 0) {
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        		Date updDate = null;
                try {
					updDate = sdFormat.parse(indto.getUpdShaYmd());
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
        		if(!tRdmReqKnrEntityList.get(0).getUpdShaYmd().equals(updDate)) {
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

        // 申請管理
        TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
        tRdmReqKnrEntity.setReqId(indto.getReqId());
        TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

        String reqId = indto.getReqId();

        if(tRdmReqKnrData == null) {
        	// 新規登録
        	// 新規にIDを取得
        	SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
        	List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
        	reqId = seqRdmReqIdDate.get(0).getReqId();

        	// レコードを登録
        	TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
        	tRdmReqKnrInsData.setReqId(reqId);
        	if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
        		tRdmReqKnrInsData.setReqChl("2");
        		tRdmReqKnrInsData.setReqKngKbn("2");
        	} else {
        		// "MRが申請の場合、'1'(MR起因)
        		tRdmReqKnrInsData.setReqChl("1");
        		tRdmReqKnrInsData.setReqKngKbn("1");
        	}
        	tRdmReqKnrInsData.setReqType("13");
        	tRdmReqKnrInsData.setReqStsCd("03");

        	String tekiyoYmd = indto.getTekiyoYmd();
        	if(tekiyoYmd != null) {
        		tekiyoYmd = tekiyoYmd.replace("/", "");
        	}
        	tRdmReqKnrInsData.setTekiyoYmd(tekiyoYmd);

        	tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
        	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
        	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
        	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
        	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	tRdmReqKnrInsData.setReqYmdhms(sysDateTime);
        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

        } else {
        	// 更新
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF315Data");
        	tRdmReqKnrUpdData.setReqId(reqId);

        	if("1".equals(indto.getFuncId())) {
        		if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("03");
    			} else if("3".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("13");
    			}

        		tRdmReqKnrUpdData.setReqBrCd(indto.getLoginBrCd());
            	tRdmReqKnrUpdData.setReqDistCd(indto.getLoginDistCd());
            	tRdmReqKnrUpdData.setReqShzNm(indto.getLoginShzNm());
            	tRdmReqKnrUpdData.setReqJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrUpdData.setReqJgiName(indto.getLoginNm());
            	tRdmReqKnrUpdData.setReqYmdhms(sysDateTime);

            	if(RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
            		tRdmReqKnrUpdData.setReqKngKbn("2");
            	} else {
            		tRdmReqKnrUpdData.setReqKngKbn("1");
            	}

        	} else if("2".equals(indto.getFuncId())) {
            	if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("04");
    			} else if("3".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("14");
    			}

    			tRdmReqKnrUpdData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrUpdData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrUpdData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrUpdData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrUpdData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrUpdData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrUpdData.setAprComment(indto.getAprComment());

        	} else if("3".equals(indto.getFuncId())) {
        		if("1".equals(indto.getReqChl()) || "2".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("02");
    			} else if("3".equals(indto.getReqChl())) {
    				tRdmReqKnrUpdData.setReqStsCd("12");
    			}

    			tRdmReqKnrUpdData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrUpdData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrUpdData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrUpdData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrUpdData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrUpdData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrUpdData.setAprComment(indto.getAprComment());

        	}

        	String tekiyoYmd = indto.getTekiyoYmd();
        	if(tekiyoYmd != null) {
        		tekiyoYmd = tekiyoYmd.replace("/", "");
        	}
        	tRdmReqKnrUpdData.setTekiyoYmd(tekiyoYmd);
        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
        	tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
        	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrUpdData);
        }

        if("0".equals(indto.getTkdTrtKbn())) {
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
	        	tRdmHcoLnkNxtReqInsData.setMainInsNoBf(indto.getMainInsCd());
	        	tRdmHcoLnkNxtReqInsData.setMainInsFlgBf("0");
	        	tRdmHcoLnkNxtReqInsData.setInsSbtBf(indto.getMainInsSbt());
	        	tRdmHcoLnkNxtReqInsData.setMainInsNoAf("Z");
	        	tRdmHcoLnkNxtReqInsData.setMainInsFlgAf("1");
	        	tRdmHcoLnkNxtReqInsData.setInsSbtAf(null);
	        	tRdmHcoLnkNxtReqInsData.setInsShaYmd(systemDate);
	        	tRdmHcoLnkNxtReqInsData.setInsShaId(indto.getLoginJgiNo());
	        	tRdmHcoLnkNxtReqInsData.setUpdShaYmd(systemDate);
	        	tRdmHcoLnkNxtReqInsData.setUpdShaId(indto.getLoginJgiNo());

	        	dao.insertByValue(tRdmHcoLnkNxtReqInsData);

	        } else {
	        	// 更新
	        	TRdmHcoLnkNxtReqEntity tRdmHcoLnkNxtReqUpdData = new TRdmHcoLnkNxtReqEntity("updateNF213Data");
	        	tRdmHcoLnkNxtReqUpdData.setReqId(reqId);
	        	tRdmHcoLnkNxtReqUpdData.setMainInsNoAf("Z");
	        	tRdmHcoLnkNxtReqUpdData.setInsSbtAf(null);
	        	tRdmHcoLnkNxtReqUpdData.setUpdShaYmd(systemDate);
	        	tRdmHcoLnkNxtReqUpdData.setUpdShaId(indto.getLoginJgiNo());

	        	dao.update(tRdmHcoLnkNxtReqUpdData);
	        }

        } else {
	        // 領域品目グループ別親子_申請管理
	        TRdmHcoLnkReqEntity tRdmHcoLnkReqEntity = new TRdmHcoLnkReqEntity();
	        tRdmHcoLnkReqEntity.setReqId(reqId);
	        TRdmHcoLnkReqEntity tRdmHcoLnkReqData = dao.selectByPK(tRdmHcoLnkReqEntity);

	        if(tRdmHcoLnkReqData == null) {
	        	// 新規登録
	        	TRdmHcoLnkReqEntity tRdmHcoLnkReqInsData = new TRdmHcoLnkReqEntity();
	        	tRdmHcoLnkReqInsData.setReqId(reqId);

        		tRdmHcoLnkReqInsData.setTrtCd(indto.getTrtCd());
        		tRdmHcoLnkReqInsData.setHinGCd(indto.getHinGCd());

	        	tRdmHcoLnkReqInsData.setInsNo(indto.getInsNo());
	        	tRdmHcoLnkReqInsData.setMainInsNoBf(indto.getMainInsCd());
	        	tRdmHcoLnkReqInsData.setMainInsFlgBf("0");
	        	tRdmHcoLnkReqInsData.setInsSbtBf(indto.getMainInsSbt());
	        	tRdmHcoLnkReqInsData.setMainInsNoAf("Z");
	        	tRdmHcoLnkReqInsData.setMainInsFlgAf("1");
	        	tRdmHcoLnkReqInsData.setInsSbtAf(null);
	        	tRdmHcoLnkReqInsData.setInsShaYmd(systemDate);
	        	tRdmHcoLnkReqInsData.setInsShaId(indto.getLoginJgiNo());
	        	tRdmHcoLnkReqInsData.setUpdShaYmd(systemDate);
	        	tRdmHcoLnkReqInsData.setUpdShaId(indto.getLoginJgiNo());

	        	dao.insertByValue(tRdmHcoLnkReqInsData);

	        } else {
	        	// 更新
	        	TRdmHcoLnkReqEntity tRdmHcoLnkReqUpdData = new TRdmHcoLnkReqEntity("updateNF213Data");
	        	tRdmHcoLnkReqUpdData.setReqId(reqId);

	        	tRdmHcoLnkReqUpdData.setTrtCd(indto.getTrtCd());
        		tRdmHcoLnkReqUpdData.setHinGCd(indto.getHinGCd());

	        	tRdmHcoLnkReqUpdData.setMainInsNoAf("Z");
	        	tRdmHcoLnkReqUpdData.setInsSbtAf(null);
	        	tRdmHcoLnkReqUpdData.setUpdShaYmd(systemDate);
	        	tRdmHcoLnkReqUpdData.setUpdShaId(indto.getLoginJgiNo());

	        	dao.update(tRdmHcoLnkReqUpdData);
	        }
        }

    	outdto.setForward("NC101");
		// END UOC
		return outdto;
    }
}
