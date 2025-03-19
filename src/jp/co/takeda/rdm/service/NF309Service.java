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
import jp.co.takeda.rdm.dto.NF309DTO;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoNxtReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF309)
 * @generated
 */
@Named
public class NF309Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NF309Service.class);

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
     * @param indto NF309DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NF309DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        // DropDownList作成
        createCombo(indto);

        boolean errFlg = false;
        String errMsg = "";

        // 必須入力チェック
        if(indto.getNextPharmType() == null || indto.getNextPharmType().isEmpty()) {
        	// 必須項目にデータを入力してください。（施設区分）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "施設区分") + "\n";
        	errFlg = true;
        }
        if(indto.getNextInsRank() == null || indto.getNextInsRank().isEmpty()) {
        	// 必須項目にデータを入力してください。（階級区分）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "階級区分") + "\n";
        	errFlg = true;
        }
        if(indto.getNextRegVisType() == null || indto.getNextRegVisType().isEmpty()) {
        	// 必須項目にデータを入力してください。（定訪先区分）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "定訪先区分") + "\n";
        	errFlg = true;
        }
        if(indto.getNextImpHosType() == null || indto.getNextImpHosType().isEmpty()) {
        	// 必須項目にデータを入力してください。（重点病院区分）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "重点病院区分") + "\n";
        	errFlg = true;
        }
        if(indto.getNextManageCd() == null || indto.getNextManageCd().isEmpty()) {
        	// 必須項目にデータを入力してください。（経営主体）
        	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "経営主体") + "\n";
        	errFlg = true;
        }

        if("01".equals(indto.getInsType()) || "02".equals(indto.getInsType())) {
	        if("01".equals(indto.getNextInsRank()) || "02".equals(indto.getNextInsRank()) ||
	        		"04".equals(indto.getNextInsRank()) || "05".equals(indto.getNextInsRank()) || "07".equals(indto.getNextInsRank())) {
	        	if(indto.getNextBedCntBase() == null || indto.getNextBedCntBase().isEmpty()) {
	            	// 必須項目にデータを入力してください。（基準）
	            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "基準") + "\n";
	            	errFlg = true;
	            }
	        	if(indto.getNextBedCnt04() == null || indto.getNextBedCnt04().isEmpty()) {
	            	// 必須項目にデータを入力してください。（結核）
	            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "結核") + "\n";
	            	errFlg = true;
	            }
	        	if(indto.getNextBedCnt01() == null || indto.getNextBedCnt01().isEmpty()) {
	            	// 必須項目にデータを入力してください。（一般）
	            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "一般") + "\n";
	            	errFlg = true;
	            }
	        	if(indto.getNextBedCnt05() == null || indto.getNextBedCnt05().isEmpty()) {
	            	// 必須項目にデータを入力してください。（感染症）
	            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "感染症") + "\n";
	            	errFlg = true;
	            }
	        	if(indto.getNextBedCnt03() == null || indto.getNextBedCnt03().isEmpty()) {
	            	// 必須項目にデータを入力してください。（精神）
	            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "精神") + "\n";
	            	errFlg = true;
	            }
	        	if(indto.getNextBedCnt07() == null || indto.getNextBedCnt07().isEmpty()) {
	            	// 必須項目にデータを入力してください。（療養）
	            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "療養") + "\n";
	            	errFlg = true;
	            }
	        	if(indto.getNextBedCnt02() == null || indto.getNextBedCnt02().isEmpty()) {
	            	// 必須項目にデータを入力してください。（医療療養）
	            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "医療療養") + "\n";
	            	errFlg = true;
	            }
	        	if(indto.getNextBedCnt06() == null || indto.getNextBedCnt06().isEmpty()) {
	            	// 必須項目にデータを入力してください。（介護療養）
	            	errMsg += loginInfo.getMsgData(RdmConstantsData.W004).replace("項目名", "介護療養") + "\n";
	            	errFlg = true;
	            }
	        }
        }

        // レングスチェック
        if("01".equals(indto.getInsType()) || "02".equals(indto.getInsType())) {
	        if(indto.getNextBedCntBase() != null && indto.getNextBedCntBase().length() > 4) {
	        	// 最大文字数を超えています。（病床（基準））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（基準）") + "\n";
				errFlg = true;
	        }
	        if(indto.getNextBedCnt04() != null && indto.getNextBedCnt04().length() > 4) {
	        	// 最大文字数を超えています。（病床（結核））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（結核）") + "\n";
				errFlg = true;
	        }
	        if (indto.getNextBedCnt01() != null && indto.getNextBedCnt01().length() > 4) {
				// 最大文字数を超えています。（病床（一般））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（一般）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt05() != null && indto.getNextBedCnt05().length() > 4) {
				// 最大文字数を超えています。（病床（感染症））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（感染症）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt03() != null && indto.getNextBedCnt03().length() > 4) {
				// 最大文字数を超えています。（病床（精神））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（精神）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt07() != null && indto.getNextBedCnt07().length() > 4) {
				// 最大文字数を超えています。（病床（療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（療養）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt02() != null && indto.getNextBedCnt02().length() > 4) {
				// 最大文字数を超えています。（病床（医療療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（医療療養）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedCnt06() != null && indto.getNextBedCnt06().length() > 4) {
				// 最大文字数を超えています。（病床（介護療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（介護療養）") + "\n";
				errFlg = true;
			}
			if (indto.getNextBedsTot() != null && indto.getNextBedsTot().length() > 5) {
				// 最大文字数を超えています。（病床（ベッド数計））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（ベッド数計）") + "\n";
				errFlg = true;
			}
			if (indto.getMedBedsTot() != null && indto.getNextMedBedsTot().length() > 5) {
				// 最大文字数を超えています。（病床（医療ベッド数計））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "病床（医療ベッド数計）") + "\n";
				errFlg = true;
			}
        }
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

        // 文字種チェック
        if("01".equals(indto.getInsType()) || "02".equals(indto.getInsType())) {
	        if (!StringUtils.isNumeric(indto.getNextBedCntBase())) {
				// 入力文字種が不正です。（病床（基準））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（基準）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt04())) {
				// 入力文字種が不正です。（病床（結核））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（結核）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt01())) {
				// 入力文字種が不正です。（病床（一般））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（一般）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt05())) {
				// 入力文字種が不正です。（病床（感染症））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（感染症）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt03())) {
				// 入力文字種が不正です。（病床（精神））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（精神）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt07())) {
				// 入力文字種が不正です。（病床（療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（療養）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt02())) {
				// 入力文字種が不正です。（病床（医療療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（医療療養）") + "\n";
				errFlg = true;
			}
			if (!StringUtils.isNumeric(indto.getNextBedCnt06())) {
				// 入力文字種が不正です。（病床（介護療養））
				errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "病床（介護療養）") + "\n";
				errFlg = true;
			}
        }

        // 整合性チェック
        if("01".equals(indto.getInsType()) || "02".equals(indto.getInsType())) {
			if(("01".equals(indto.getNextInsRank()) || "02".equals(indto.getNextInsRank()) || "03".equals(indto.getNextInsRank())
					 || "04".equals(indto.getNextInsRank()) || "05".equals(indto.getNextInsRank()) || "06".equals(indto.getNextInsRank()))
					 && !chkNumRange(indto.getNextBedsTot(), 0, 9999)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if(("12".equals(indto.getNextInsRank()) || "13".equals(indto.getNextInsRank()) || "15".equals(indto.getNextInsRank()))
					 && !"0".equals(indto.getNextBedsTot())){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if(("11".equals(indto.getNextInsRank()) || "14".equals(indto.getNextInsRank()))
					 && !chkNumRange(indto.getNextBedsTot(), 1, 19)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("07".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 100, 9999)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("08".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 200, 9999)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("09".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 20, 99)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("10".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 20, 199)){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			} else if("16".equals(indto.getNextInsRank()) && !chkNumRange(indto.getNextBedsTot(), 20, 199)
						&& !("0".equals(indto.getNextBedCnt01()) && "0".equals(indto.getNextBedCnt07()) && "0".equals(indto.getNextBedCnt04())
								&& "0".equals(indto.getNextBedCnt05()) &&chkNumRange(indto.getNextBedCnt03(), 1, 9999))){
				// 階級区分の範囲とベッド数計が一致するよう入力して下さい。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W023) + "\n";
				errFlg = true;
			}
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
        if(indto.getUpdShaYmd() != null && !"".equals(indto.getUpdShaYmd())
        		&& indto.getReqId() != null && !"".equals(indto.getReqId())) {
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
        	String title = "NF101_施設来期情報更新";
            indto.setTitle(title);
        	indto.setMsgStr(errMsg);
			outdto.setForward("NF101");
        	return outdto;
        }

		// 申請ボタン活性フラグ取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName("MN_FAC");
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// valueの左から二桁目
			String value = mRdmParamMstEntityList.get(0).getValue().substring(1,2);
			if("1".equals(value)) {
				// 申請ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}

        // END UOC
		outdto.setForward("NF309");
        return outdto;
    }

    /**
     * コンボ作成
     * @param indto NF309DTO
     * @return なし
     * @customizable
     */
    private void createCombo(NF309DTO indto){
        // 対象区分
        SelectComboListEntity inEntityCmb = new SelectComboListEntity();
        inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HO_INS_TYPE);
    	List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapHoInsType = new LinkedHashMap<String, String>();
		mapHoInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapHoInsType.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
		}
		indto.setHoInsTypeCombo(mapHoInsType);

		// ワクチン対象区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_INS_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacInsType = new LinkedHashMap<String, String>();
		mapVacInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacInsType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setVacInsTypeCombo(mapVacInsType);

		// ワクチン定訪先区分
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_VISIT_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacVisitType = new LinkedHashMap<String, String>();
		mapVacVisitType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacVisitType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setVacVisitTypeCombo(mapVacVisitType);
    }

    /**
     * イベント処理
     * @param indto NF309DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(NF309DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
        outdto.setForward("NF309");

        // 現在日付を取得
        Date systemDate = DateUtils.getNowDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = fmtDate.format(systemDate);
        SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDateTime = fmtDateTime.format(systemDate);

        boolean errFlg = false;
        String errMsg = "";

        if("3".equals(indto.getFuncId())) {
			if(indto.getAprComment() != null && indto.getAprComment().isEmpty()) {
	        	// 却下の場合はコメントを入力してください。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W026) + "\n";
				errFlg = true;
	        }
        }

        // 最終更新日時が、画面OPEN時とボタン押下時で異なっていた場合
		if(indto.getUpdShaYmd() != null && !"".equals(indto.getUpdShaYmd())
				&& indto.getReqId() != null && !"".equals(indto.getReqId())) {
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

        // 管理者権限
        boolean knr = RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd());

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
        	if(knr) {
        		// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
        		tRdmReqKnrInsData.setReqChl("2");
        		tRdmReqKnrInsData.setReqKngKbn("2");
        	} else {
        		// "MRが申請の場合、'1'(MR起因)
        		tRdmReqKnrInsData.setReqChl("1");
        		tRdmReqKnrInsData.setReqKngKbn("1");
        	}
        	tRdmReqKnrInsData.setReqType("21");

        	if("1".equals(indto.getFuncId())) {
        		// 申請
        		tRdmReqKnrInsData.setReqStsCd("03");
        		tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
            	tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
            	tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
            	tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
            	tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
            	tRdmReqKnrInsData.setReqYmdhms(sysDateTime);
            	tRdmReqKnrInsData.setReqComment(indto.getReqComment());

        	} else if("2".equals(indto.getFuncId())) {
        		// 承認
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
        		// 却下
        		tRdmReqKnrInsData.setReqStsCd("02");

        		tRdmReqKnrInsData.setAprBrCode(indto.getLoginBrCd());
            	tRdmReqKnrInsData.setAprDistCode(indto.getLoginDistCd());
            	tRdmReqKnrInsData.setAprShz(indto.getLoginShzNm());
            	tRdmReqKnrInsData.setAprJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
            	tRdmReqKnrInsData.setAprShaName(indto.getLoginNm());
            	tRdmReqKnrInsData.setAprYmdhms(sysDateTime);
            	tRdmReqKnrInsData.setAprComment(indto.getAprComment());
        	}

        	tRdmReqKnrInsData.setInsNo(indto.getInsNo());
        	tRdmReqKnrInsData.setInsShaYmd(systemDate);
        	tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmReqKnrInsData.setUpdShaYmd(systemDate);
        	tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmReqKnrInsData);

        } else {
        	// 更新
        	TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF309Data");
        	tRdmReqKnrUpdData.setReqId(reqId);

        	if("1".equals(indto.getFuncId())) {
        		// 申請
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

            	if(knr) {
            		tRdmReqKnrUpdData.setReqKngKbn("2");
            	} else {
            		tRdmReqKnrUpdData.setReqKngKbn("1");
            	}

        	} else if("2".equals(indto.getFuncId())) {
        		// 承認
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
        		// 却下
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

        // 施設_来期用_申請管理
        TRdmHcoNxtReqEntity tRdmHcoNxtReqEntity = new TRdmHcoNxtReqEntity();
        tRdmHcoNxtReqEntity.setReqId(reqId);
        TRdmHcoNxtReqEntity tRdmHcoNxtReqData = dao.selectByPK(tRdmHcoNxtReqEntity);

        if(tRdmHcoNxtReqData == null) {
        	// 新規登録
        	TRdmHcoNxtReqEntity tRdmHcoNxtReqInsData = new TRdmHcoNxtReqEntity();
        	tRdmHcoNxtReqInsData.setReqId(reqId);
        	tRdmHcoNxtReqInsData.setInsNo(indto.getInsNo());
        	tRdmHcoNxtReqInsData.setPharmType(getUpdValue(indto.getPharmType(), indto.getNextPharmType()));
        	tRdmHcoNxtReqInsData.setHoInsType(getUpdValue(indto.getHoInsType(), indto.getNextHoInsType()));
        	tRdmHcoNxtReqInsData.setRegVisType(getUpdValue(indto.getRegVisType(), indto.getNextRegVisType()));
        	tRdmHcoNxtReqInsData.setInsRank(getUpdValue(indto.getInsRank(), indto.getNextInsRank()));
        	tRdmHcoNxtReqInsData.setImpHosType(getUpdValue(indto.getImpHosType(), indto.getNextImpHosType()));
        	tRdmHcoNxtReqInsData.setManageCd(getUpdValue(indto.getManageCd(), indto.getNextManageCd()));
        	tRdmHcoNxtReqInsData.setVacInsType(getUpdValue(indto.getVacInsType(), indto.getNextVacInsType()));
        	tRdmHcoNxtReqInsData.setVacVisitType(getUpdValue(indto.getVacVisitType(), indto.getNextVacVisitType()));

        	if(!"01".equals(indto.getInsType()) && !"02".equals(indto.getInsType())) {
        		// 病床数非表示、0扱い
        		tRdmHcoNxtReqInsData.setBedcntBase(getUpdValue(indto.getBedCntBase(), "0"));
	        	tRdmHcoNxtReqInsData.setBedcnt04(getUpdValue(indto.getBedCnt04(), "0"));
	        	tRdmHcoNxtReqInsData.setBedcnt01(getUpdValue(indto.getBedCnt01(), "0"));
	        	tRdmHcoNxtReqInsData.setBedcnt05(getUpdValue(indto.getBedCnt05(), "0"));
	        	tRdmHcoNxtReqInsData.setBedcnt07(getUpdValue(indto.getBedCnt07(), "0"));
	        	tRdmHcoNxtReqInsData.setBedcnt02(getUpdValue(indto.getBedCnt02(), "0"));
	        	tRdmHcoNxtReqInsData.setBedcnt03(getUpdValue(indto.getBedCnt03(), "0"));
	        	tRdmHcoNxtReqInsData.setBedcnt06(getUpdValue(indto.getBedCnt06(), "0"));
	        	tRdmHcoNxtReqInsData.setBedsTot(getUpdValue(indto.getBedsTot(), "0"));
	        	tRdmHcoNxtReqInsData.setMedBedsTot(getUpdValue(indto.getMedBedsTot(), "0"));
        	} else {
	        	tRdmHcoNxtReqInsData.setBedcntBase(getUpdValue(indto.getBedCntBase(), indto.getNextBedCntBase()));
	        	tRdmHcoNxtReqInsData.setBedcnt04(getUpdValue(indto.getBedCnt04(), indto.getNextBedCnt04()));
	        	tRdmHcoNxtReqInsData.setBedcnt01(getUpdValue(indto.getBedCnt01(), indto.getNextBedCnt01()));
	        	tRdmHcoNxtReqInsData.setBedcnt05(getUpdValue(indto.getBedCnt05(), indto.getNextBedCnt05()));
	        	tRdmHcoNxtReqInsData.setBedcnt07(getUpdValue(indto.getBedCnt07(), indto.getNextBedCnt07()));
	        	tRdmHcoNxtReqInsData.setBedcnt02(getUpdValue(indto.getBedCnt02(), indto.getNextBedCnt02()));
	        	tRdmHcoNxtReqInsData.setBedcnt03(getUpdValue(indto.getBedCnt03(), indto.getNextBedCnt03()));
	        	tRdmHcoNxtReqInsData.setBedcnt06(getUpdValue(indto.getBedCnt06(), indto.getNextBedCnt06()));
	        	tRdmHcoNxtReqInsData.setBedsTot(getUpdValue(indto.getBedsTot(), indto.getNextBedsTot()));
	        	tRdmHcoNxtReqInsData.setMedBedsTot(getUpdValue(indto.getMedBedsTot(), indto.getNextMedBedsTot()));
        	}

        	tRdmHcoNxtReqInsData.setInsShaYmd(sysDate);
        	tRdmHcoNxtReqInsData.setInsShaId(indto.getLoginJgiNo());
        	tRdmHcoNxtReqInsData.setUpdShaYmd(sysDate);
        	tRdmHcoNxtReqInsData.setUpdShaId(indto.getLoginJgiNo());

        	dao.insertByValue(tRdmHcoNxtReqInsData);

        } else {
        	// 更新
        	TRdmHcoNxtReqEntity tRdmHcoNxtReqUpdData = new TRdmHcoNxtReqEntity("updateNF101Data");
        	tRdmHcoNxtReqUpdData.setReqId(reqId);

        	tRdmHcoNxtReqUpdData.setPharmType(getUpdValue(indto.getPharmType(), indto.getNextPharmType()));
        	tRdmHcoNxtReqUpdData.setHoInsType(getUpdValue(indto.getHoInsType(), indto.getNextHoInsType()));
        	tRdmHcoNxtReqUpdData.setRegVisType(getUpdValue(indto.getRegVisType(), indto.getNextRegVisType()));
        	tRdmHcoNxtReqUpdData.setInsRank(getUpdValue(indto.getInsRank(), indto.getNextInsRank()));
        	tRdmHcoNxtReqUpdData.setImpHosType(getUpdValue(indto.getImpHosType(), indto.getNextImpHosType()));
        	tRdmHcoNxtReqUpdData.setManageCd(getUpdValue(indto.getManageCd(), indto.getNextManageCd()));
        	tRdmHcoNxtReqUpdData.setVacInsType(getUpdValue(indto.getVacInsType(), indto.getNextVacInsType()));
        	tRdmHcoNxtReqUpdData.setVacVisitType(getUpdValue(indto.getVacVisitType(), indto.getNextVacVisitType()));

        	if(!"01".equals(indto.getInsType()) && !"02".equals(indto.getInsType())) {
        		// 病床数非表示、0扱い
        		tRdmHcoNxtReqUpdData.setBedcntBase(getUpdValue(indto.getBedCntBase(), "0"));
	        	tRdmHcoNxtReqUpdData.setBedcnt04(getUpdValue(indto.getBedCnt04(), "0"));
	        	tRdmHcoNxtReqUpdData.setBedcnt01(getUpdValue(indto.getBedCnt01(), "0"));
	        	tRdmHcoNxtReqUpdData.setBedcnt05(getUpdValue(indto.getBedCnt05(), "0"));
	        	tRdmHcoNxtReqUpdData.setBedcnt07(getUpdValue(indto.getBedCnt07(), "0"));
	        	tRdmHcoNxtReqUpdData.setBedcnt02(getUpdValue(indto.getBedCnt02(), "0"));
	        	tRdmHcoNxtReqUpdData.setBedcnt03(getUpdValue(indto.getBedCnt03(), "0"));
	        	tRdmHcoNxtReqUpdData.setBedcnt06(getUpdValue(indto.getBedCnt06(), "0"));
	        	tRdmHcoNxtReqUpdData.setBedsTot(getUpdValue(indto.getBedsTot(), "0"));
	        	tRdmHcoNxtReqUpdData.setMedBedsTot(getUpdValue(indto.getMedBedsTot(), "0"));
        	} else {
        		tRdmHcoNxtReqUpdData.setBedcntBase(getUpdValue(indto.getBedCntBase(), indto.getNextBedCntBase()));
	        	tRdmHcoNxtReqUpdData.setBedcnt04(getUpdValue(indto.getBedCnt04(), indto.getNextBedCnt04()));
	        	tRdmHcoNxtReqUpdData.setBedcnt01(getUpdValue(indto.getBedCnt01(), indto.getNextBedCnt01()));
	        	tRdmHcoNxtReqUpdData.setBedcnt05(getUpdValue(indto.getBedCnt05(), indto.getNextBedCnt05()));
	        	tRdmHcoNxtReqUpdData.setBedcnt07(getUpdValue(indto.getBedCnt07(), indto.getNextBedCnt07()));
	        	tRdmHcoNxtReqUpdData.setBedcnt02(getUpdValue(indto.getBedCnt02(), indto.getNextBedCnt02()));
	        	tRdmHcoNxtReqUpdData.setBedcnt03(getUpdValue(indto.getBedCnt03(), indto.getNextBedCnt03()));
	        	tRdmHcoNxtReqUpdData.setBedcnt06(getUpdValue(indto.getBedCnt06(), indto.getNextBedCnt06()));
	        	tRdmHcoNxtReqUpdData.setBedsTot(getUpdValue(indto.getBedsTot(), indto.getNextBedsTot()));
	        	tRdmHcoNxtReqUpdData.setMedBedsTot(getUpdValue(indto.getMedBedsTot(), indto.getNextMedBedsTot()));
        	}

        	tRdmHcoNxtReqUpdData.setUpdShaYmd(sysDate);
        	tRdmHcoNxtReqUpdData.setUpdShaId(indto.getLoginJgiNo());

        	dao.update(tRdmHcoNxtReqUpdData);
        }

    	outdto.setForward("NC101");

		// END UOC
		return outdto;
    }

    /**
     * 数値範囲チェック
     * @return n = "", min <= n <= max ならtrue
     */
	public static boolean chkNumRange(String n, int min, int max){
		if(n == null || "".equals(n)){
			return true;
		} else if(!StringUtils.isNumeric(n)){
			return false;
		} else if(Integer.parseInt(n) >= min && Integer.parseInt(n) <= max){
			return true;
		}
		return false;
	}

	/**
     * 変更前と値が同一の場合はNULL、値無の場合は'Z'を返却
     * @param preValue
     * @param value
     * @return
     */
    public String getUpdValue(String preValue, String value){
    	String rtnValue = value;

    	if(value != null && value.equals(preValue)
    			|| (value == null && (preValue == null || preValue.isEmpty()))) {
    		rtnValue = null;
    	} else if(value == null || value.equals("")) {
    		rtnValue = "Z";
    	}

    	return rtnValue;
    }
}
