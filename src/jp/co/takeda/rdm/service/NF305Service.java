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
import jp.co.takeda.rdm.dto.NF305DTO;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF305MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF305)
 * @generated
 */
@Named
public class NF305Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF305Service.class);

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
     * @param indto NF305DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF305DTO indto) {
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

        // 必須入力チェック
        if(indto.getDelKbn() == null || indto.getDelKbn().isEmpty()) {
        	// 必須項目にデータを入力してください。（削除区分）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "削除区分") + "\n";
			errFlg = true;

        } else {
        	if(!"0".equals(indto.getDelKbn())) {
        		if(indto.getDelYmd() == null || indto.getDelYmd().isEmpty()) {
        			// 必須項目にデータを入力してください。（廃院日）
        			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "廃院日") + "\n";
        			errFlg = true;
        		}
        		if(indto.getDelReason() == null || indto.getDelReason().isEmpty()) {
        			// 必須項目にデータを入力してください。（削除理由）
        			errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "削除理由") + "\n";
        			errFlg = true;
        		} else {
        			if("03".equals(indto.getDelReason()) && (indto.getDupInsNo() == null || indto.getDupInsNo().isEmpty())) {
        				// 必須項目にデータを入力してください。（重複施設コード）
        				errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "重複施設コード") + "\n";
        				errFlg = true;
        			}
        		}
        	}
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

        // 削除理由にその他が選択されている状態で、申請コメントに値が入力されていない
        if("05".equals(indto.getDelReason()) && (indto.getReqComment() == null || indto.getReqComment().isEmpty())) {
        	// 申請理由がその他の場合、申請コメントを入力してください。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W005) + "\n";
			errFlg = true;
        }

        // 同じ施設固定コードに紐づく施設削除申請がすでに存在している場合
        TRdmHcoReqEntity tRdmHcoReqchkEntity = new TRdmHcoReqEntity("selectNF013InsChkData");
        tRdmHcoReqchkEntity.setInsNo(indto.getInsNo());
        if(indto.getReqId() != null && !indto.getReqId().isEmpty()) {
        	tRdmHcoReqchkEntity.setReqId(indto.getReqId());
        }
        List<TRdmHcoReqEntity> tRdmHcoReqchkEntityList = dao.select(tRdmHcoReqchkEntity);

        if(tRdmHcoReqchkEntityList.size() > 0) {
        	// 重複する申請が行われています。（施設コード）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "施設コード") + "\n";
        	errFlg = true;
        }

        // 削除理由＝重複登録で、施設固定C＝重複施設コード　の場合
        if("03".equals(indto.getDelReason()) && indto.getInsNo().equals(indto.getDupInsNo())) {
        	// 同一の施設が重複先に指定されています。
			errMsg += loginInfo.getMsgData(RdmConstantsData.W059) + "\n";
			errFlg = true;
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
        if(indto.getUpdShaYmd() != null && !indto.getUpdShaYmd().equals("")) {
        	TRdmReqKnrEntity tRdmReqKnrChkEntity = new TRdmReqKnrEntity("selectNF011DateChkData");
        	tRdmReqKnrChkEntity.setReqId(reqId);

        	List<TRdmReqKnrEntity> tRdmReqKnrEntityList = dao.select(tRdmReqKnrChkEntity);

        	if(tRdmReqKnrEntityList.size() > 0) {
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmss");
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
        	String title = "NF013_施設削除";
            indto.setTitle(title);
        	indto.setMsgStr(errMsg);
			outdto.setForward("NF013");
        	return outdto;
        }

        // 廃院日表示設定
        if(indto.getDelYmd() != null) {
        	indto.setDelYmd(indto.getDelYmd().replace("-", "/"));
        }

		// 申請ボタン活性フラグ取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName("MN_FAC");
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// valueの左から3桁目
			String value = mRdmParamMstEntityList.get(0).getValue().substring(2,3);
			if("1".equals(value)) {
				// 申請ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}

        // END UOC
		outdto.setForward("NF305");
        return outdto;
    }

    /**
     * コンボ作成
     * @param indto NF305DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF305DTO indto){
    	// 削除区分
    	SelectComboListEntity inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DEL_KBN);
        List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapDelKbn = new LinkedHashMap<String, String>();
        mapDelKbn.put("", "--選択してください--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapDelKbn.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setDelKbnCombo(mapDelKbn);

        // 削除理由
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HCO_DEL_REASON);
        outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapDelReason = new LinkedHashMap<String, String>();
        mapDelReason.put("", "--選択してください--");
        for (SelectComboListEntity outEntity : outMainList) {
        	mapDelReason.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        }
        indto.setDelReasonCombo(mapDelReason);
    }

    /**
     * イベント処理
     * @param indto NF305DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF305DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        outdto.setForward("NF305");

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";


        // 同じ施設固定コードに紐づく施設削除申請がすでに存在している場合
        TRdmHcoReqEntity tRdmHcoReqchkEntity = new TRdmHcoReqEntity("selectNF013InsChkData");
        tRdmHcoReqchkEntity.setInsNo(indto.getInsNo());
        if(indto.getReqId() != null && !indto.getReqId().isEmpty()) {
        	tRdmHcoReqchkEntity.setReqId(indto.getReqId());
        }
        List<TRdmHcoReqEntity> tRdmHcoReqchkEntityList = dao.select(tRdmHcoReqchkEntity);

        if(tRdmHcoReqchkEntityList.size() > 0) {
        	// 重複する申請が行われています。（施設コード）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "施設コード") + "\n";
        	errFlg = true;
        }

        // 承認時のみチェック
        if("2".equals(indto.getFuncId())) {
        	// 削除対象施設に勤務している医師、および、勤務先登録申請中の医師のいずれか1名以上存在している場合
        	if((!"".equals(indto.getDocCount()) && !"0".equals(indto.getDocCount()))
        			|| (!"".equals(indto.getReqDocCount()) && !"0".equals(indto.getReqDocCount()))) {
        		// 所属医師、または、申請中の医師が存在します。
        		errMsg += loginInfo.getMsgData(RdmConstantsData.W010) + "\n";
				errFlg = true;
        	}

        	// 削除対象施設に勤務している医師、および、勤務先登録申請中の医師のいずれか1名以上存在している場合
        	if((!"".equals(indto.getInsCount()) && !"0".equals(indto.getInsCount()))
        			|| (!"".equals(indto.getNextInsCount()) && !"0".equals(indto.getNextInsCount()))) {
        		// 子施設が存在します。
        		errMsg += loginInfo.getMsgData(RdmConstantsData.W035) + "\n";
				errFlg = true;
        	}

        	// 削除対象施設に対する実績データが存在している場合
        	if("あり".equals(indto.getJskValue())) {
        		// 過去実績が存在します。
        		errMsg += loginInfo.getMsgData(RdmConstantsData.W036) + "\n";
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
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmss");
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

        	tRdmReqKnrInsData.setReqType("03");

        	if("1".equals(indto.getFuncId())) {
        		tRdmReqKnrInsData.setReqStsCd("03");

        		tRdmReqKnrInsData.setReqBrCd(indto.getLoginBrCd());
            	tRdmReqKnrInsData.setReqDistCd(indto.getLoginDistCd());
            	tRdmReqKnrInsData.setReqShzNm(indto.getLoginShzNm());
            	tRdmReqKnrInsData.setReqJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrInsData.setReqJgiName(indto.getLoginNm());
            	tRdmReqKnrInsData.setReqYmdhms(sysDateTime);
        	} else if("2".equals(indto.getFuncId())) {
        		tRdmReqKnrInsData.setReqStsCd("04");

        		tRdmReqKnrInsData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrInsData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrInsData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrInsData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrInsData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrInsData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrInsData.setAprComment(indto.getAprComment());

            	if("on".equals(indto.getFbReqFlg())) {
            		tRdmReqKnrInsData.setFbReqFlg("1");
            	} else {
            		tRdmReqKnrInsData.setFbReqFlg("0");
            	}
        	} else if("3".equals(indto.getFuncId())) {
        		tRdmReqKnrInsData.setReqStsCd("02");

        		tRdmReqKnrInsData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrInsData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrInsData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrInsData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrInsData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrInsData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrInsData.setAprComment(indto.getAprComment());
        	}

        	tRdmReqKnrInsData.setReqComment(indto.getReqComment());
        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

        } else {
        	// 更新
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF305Data");
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

            	if("on".equals(indto.getFbReqFlg())) {
            		tRdmReqKnrUpdData.setFbReqFlg("1");
            	} else {
            		tRdmReqKnrUpdData.setFbReqFlg("0");
            	}
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

        	tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
        	tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
        	tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmReqKnrUpdData);
        }

        // 施設_申請管理
        TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
        tRdmHcoReqEntity.setReqId(reqId);
        TRdmHcoReqEntity tRdmHcoReqData = dao.selectByPK(tRdmHcoReqEntity);

        if(tRdmHcoReqData == null) {
        	// 新規登録
        	TRdmHcoReqEntity tRdmHcoReqInsData = new TRdmHcoReqEntity();
        	tRdmHcoReqInsData.setReqId(reqId);
        	tRdmHcoReqInsData.setInsNo(indto.getInsNo());

        	String insAbbrName = indto.getInsAbbrName();
        	if(insAbbrName.length() > 0 && ("○".equals(insAbbrName.substring(0,1)) || "●".equals(insAbbrName.substring(0,1)))) {
        		insAbbrName = insAbbrName.substring(1);
        	}
        	if("1".equals(indto.getDelKbn())) {
        		// 削除区分が1：廃院／閉店予定（○付与）の場合、'○'＋画面．施設略式漢字名(全角)
        		insAbbrName = "○" + insAbbrName;
        	} else if("2".equals(indto.getDelKbn()) || "3".equals(indto.getDelKbn())) {
        		// 削除区分が2：廃院／閉店済み（●付与）または3：削除済みの場合、'●'＋画面．施設略式漢字名(全角)
        		insAbbrName = "●" + insAbbrName;
        	}
        	if(insAbbrName.length() > 60) {
        		insAbbrName = insAbbrName.substring(0,60);
        	}
        	tRdmHcoReqInsData.setInsAbbrName(insAbbrName);

        	String insFormalName = indto.getInsFormalName();
        	if(insFormalName.length() > 0 && ("○".equals(insFormalName.substring(0,1)) || "●".equals(insFormalName.substring(0,1)))) {
        		insFormalName = insFormalName.substring(1);
        	}
        	if("1".equals(indto.getDelKbn())) {
        		// 削除区分が1：廃院／閉店予定（○付与）の場合、'○'＋画面．施設略式漢字名(全角)
        		insFormalName = "○" + insFormalName;
        	} else if("2".equals(indto.getDelKbn()) || "3".equals(indto.getDelKbn())) {
        		// 削除区分が2：廃院／閉店済み（●付与）または3：削除済みの場合、'●'＋画面．施設略式漢字名(全角)
        		insFormalName = "●" + insFormalName;
        	}
        	if(insFormalName.length() > 240) {
        		insFormalName = insFormalName.substring(0,240);
        	}
        	tRdmHcoReqInsData.setInsFormalName(insFormalName);

        	tRdmHcoReqInsData.setDelKbn(Integer.parseInt(indto.getDelKbn()));

        	if(!indto.getDelKbn().isEmpty() && !"0".equals(indto.getDelKbn())) {
        		tRdmHcoReqInsData.setDelReason(indto.getDelReason());
        		tRdmHcoReqInsData.setDelYmd(indto.getDelYmd().replace("/", ""));
        	}
        	if(!indto.getDelKbn().isEmpty() && !"0".equals(indto.getDelKbn()) && "03".equals(indto.getDelReason())) {
        		tRdmHcoReqInsData.setDupInsNo(indto.getDupInsNo());
        	}

        	tRdmHcoReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoReqInsData);

        } else {
        	// 更新
        	TRdmHcoReqEntity tRdmHcoReqUpdData = new TRdmHcoReqEntity("updateNF013Data");
        	tRdmHcoReqUpdData.setReqId(reqId);
        	String insAbbrName = indto.getInsAbbrName();
        	if(insAbbrName.length() > 0 && ("○".equals(insAbbrName.substring(0,1)) || "●".equals(insAbbrName.substring(0,1)))) {
        		insAbbrName = insAbbrName.substring(1);
        	}
        	if("1".equals(indto.getDelKbn())) {
        		// 削除区分が1：廃院／閉店予定（○付与）の場合、'○'＋画面．施設略式漢字名(全角)
        		insAbbrName = "○" + insAbbrName;
        	} else if("2".equals(indto.getDelKbn()) || "3".equals(indto.getDelKbn())) {
        		// 削除区分が2：廃院／閉店済み（●付与）または3：削除済みの場合、'●'＋画面．施設略式漢字名(全角)
        		insAbbrName = "●" + insAbbrName;
        	}
        	if(insAbbrName.length() > 60) {
        		insAbbrName = insAbbrName.substring(0,60);
        	}
        	tRdmHcoReqUpdData.setInsAbbrName(insAbbrName);

        	String insFormalName = indto.getInsFormalName();
        	if(insFormalName.length() > 0 && ("○".equals(insFormalName.substring(0,1)) || "●".equals(insFormalName.substring(0,1)))) {
        		insFormalName = insFormalName.substring(1);
        	}
        	if("1".equals(indto.getDelKbn())) {
        		// 削除区分が1：廃院／閉店予定（○付与）の場合、'○'＋画面．施設略式漢字名(全角)
        		insFormalName = "○" + insFormalName;
        	} else if("2".equals(indto.getDelKbn()) || "3".equals(indto.getDelKbn())) {
        		// 削除区分が2：廃院／閉店済み（●付与）または3：削除済みの場合、'●'＋画面．施設略式漢字名(全角)
        		insFormalName = "●" + insFormalName;
        	}
        	if(insFormalName.length() > 240) {
        		insFormalName = insFormalName.substring(0,240);
        	}
        	tRdmHcoReqUpdData.setInsFormalName(insFormalName);

        	if(!indto.getDelKbn().isEmpty()) {
        		tRdmHcoReqUpdData.setDelKbn(Integer.parseInt(indto.getDelKbn()));
        	}

        	if(!indto.getDelKbn().isEmpty() && !"0".equals(indto.getDelKbn())) {
        		tRdmHcoReqUpdData.setDelReason(indto.getDelReason());
        		tRdmHcoReqUpdData.setDelYmd(indto.getDelYmd().replace("/", ""));
        	}
        	if(!indto.getDelKbn().isEmpty() && !"0".equals(indto.getDelKbn()) && "03".equals(indto.getDelReason())) {
        		tRdmHcoReqUpdData.setDupInsNo(indto.getDupInsNo());
        	}

        	tRdmHcoReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmHcoReqUpdData);
        }

    	outdto.setForward("NC101");
		// END UOC
		return outdto;
    }
}
