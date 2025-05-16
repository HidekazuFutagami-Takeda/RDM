/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.dto.ND014DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpYakushokuEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectND014MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.entity.join.UpdateTRdmHcpReqEntity;
import jp.co.takeda.rdm.entity.join.UpdateTRdmReqKnrEntity;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（ND014)
 * @generated
 */
@Named
public class ND014Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(ND014Service.class);

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
	 * @param indto ND014DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND014DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		if ("1".equals(indto.getDisplayKbn())) {
			if (indto.getTkdDocNo() != null) {
				// 医師コードで初期データ作成
				SelectND014MainDataEntity paramEntity = new SelectND014MainDataEntity();
				paramEntity.setSqlId("selectND014TKDData");
				paramEntity.setInDocNo(indto.getTkdDocNo());
				List<SelectND014MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectND014MainDataEntity mainDataEntity = mainDataEntityList.get(0);
				indto.setTkdDocNo(StringUtils.nvl(mainDataEntity.getTkdDocNo(), ""));
				indto.setTkdDocNm(StringUtils.nvl(mainDataEntity.getTkdDocNm(), ""));
				indto.setTkdDocKana(StringUtils.nvl(mainDataEntity.getTkdDocKana(), ""));

				indto.setDocKanjiSei(StringUtils.nvl(mainDataEntity.getDocKanjiSei(), ""));
				indto.setDocKanjiMei(StringUtils.nvl(mainDataEntity.getDocKanjiMei(), ""));
				indto.setDelReason(StringUtils.nvl(mainDataEntity.getDelReason(), ""));
				indto.setDelReasonNm(StringUtils.nvl(mainDataEntity.getDelReasonNm(), ""));

				indto.setReqShzNm(StringUtils.nvl(mainDataEntity.getReqShzNm(),loginInfo.getBumonRyakuName()));
				indto.setReqJgiName(StringUtils.nvl(mainDataEntity.getReqJgiName(),loginInfo.getJgiName()));
				if(mainDataEntity.getReqJgiNo() == null) {
					indto.setReqJgiNo(loginInfo.getJgiNo());
				}else {
					indto.setReqJgiNo(mainDataEntity.getReqJgiNo());
				}
				indto.setReqBrCd(StringUtils.nvl(mainDataEntity.getReqBrCd(),loginInfo.getBrCode()));
				indto.setReqDistCd(StringUtils.nvl(mainDataEntity.getReqDistCd(),loginInfo.getDistCode()));
				indto.setReqStsNm(StringUtils.nvl(mainDataEntity.getReqStsNm(),""));
				indto.setReqYmdhms(StringUtils.dispYmdhms(mainDataEntity.getReqYmdhms()));
			} else {

			}
		} else if ("2".equals(indto.getDisplayKbn())) {
			if (indto.getReqId() != null) {
				// 申請データ（一時保存含む）を参照
				SelectND014MainDataEntity paramEntity = new SelectND014MainDataEntity();
				paramEntity.setInReqId(indto.getReqId());
				List<SelectND014MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectND014MainDataEntity mainDataEntity = mainDataEntityList.get(0);
				indto.setReqShzNm(StringUtils.nvl(mainDataEntity.getReqShzNm(), ""));
				indto.setReqStsNm(StringUtils.nvl(mainDataEntity.getReqStsNm(), ""));
				indto.setReqJgiName(StringUtils.nvl(mainDataEntity.getReqJgiName(), ""));
				indto.setReqYmdhms(StringUtils.dispYmdhms(mainDataEntity.getReqYmdhms()));
				indto.setShnShaName(StringUtils.nvl(mainDataEntity.getShnShaName(), ""));
				indto.setShnYmdhms(StringUtils.dispYmdhms(mainDataEntity.getShnYmdhms()));
				indto.setAprShaName(StringUtils.nvl(mainDataEntity.getAprShaName(), ""));
				indto.setAprYmdhms(StringUtils.dispYmdhms(mainDataEntity.getAprYmdhms()));
				indto.setReqJgiNo(mainDataEntity.getReqJgiNo());
				indto.setReqBrCd(StringUtils.nvl(mainDataEntity.getReqBrCd(), ""));
				indto.setReqDistCd(StringUtils.nvl(mainDataEntity.getReqDistCd(), ""));
				indto.setReqStsCd(StringUtils.nvl(mainDataEntity.getReqStsCd(), ""));
				indto.setShnJgiNo(mainDataEntity.getShnJgiNo());
				indto.setAprJgiNo(mainDataEntity.getAprJgiNo());
				indto.setUpdShaYmd(StringUtils.nvl(mainDataEntity.getUpdShaYmd(), ""));
				indto.setTkdDocNo(StringUtils.nvl(mainDataEntity.getTkdDocNo(), ""));
				indto.setTkdDocNm(StringUtils.nvl(mainDataEntity.getTkdDocNm(), ""));
				indto.setTkdDocKana(StringUtils.nvl(mainDataEntity.getTkdDocKana(), ""));

				indto.setDocKanjiSei(StringUtils.nvl(mainDataEntity.getDocKanjiSei(), ""));
				indto.setDocKanjiMei(StringUtils.nvl(mainDataEntity.getDocKanjiMei(), ""));

				indto.setDelReason(StringUtils.nvl(mainDataEntity.getDelReason(), ""));
				indto.setDelReasonNm(StringUtils.nvl(mainDataEntity.getDelReasonNm(), ""));
				indto.setRstReason(StringUtils.nvl(mainDataEntity.getRstReason(), ""));
				indto.setSkInsNm(StringUtils.nvl(mainDataEntity.getSkInsNm(), ""));
				indto.setSkUnivPosCd(StringUtils.nvlUpd(mainDataEntity.getSkUnivPosCd(), ""));
				indto.setSkDeptNm(StringUtils.nvl(mainDataEntity.getSkDeptNm(), ""));
				indto.setSkTitleCd(StringUtils.nvlUpd(mainDataEntity.getSkTitleCd(), ""));
				indto.setSkJobForm(StringUtils.nvlUpd(mainDataEntity.getSkJobForm(), ""));
				indto.setSkDcctype(StringUtils.nvlUpd(mainDataEntity.getSkDcctype(), ""));
				indto.setSkInsNo(StringUtils.nvl(mainDataEntity.getSkInsNo(), ""));
				indto.setSkDeptCd(StringUtils.nvl(mainDataEntity.getSkDeptCd(), ""));
				indto.setSkInsHoInsType(StringUtils.nvl(mainDataEntity.getSkInsHoInsType(), ""));
				indto.setSkInsInsClass(StringUtils.nvl(mainDataEntity.getSkInsInsClass(), ""));
				indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));
				indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
				indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
				indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
				indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));
				if(indto.getSkInsNo().equals(RdmConstantsData.CODE_VALUE_DUMMY_HCO_9)) {
					indto.setUnknownFlg(true);
					indto.setSkInsNm(RdmConstantsData.CODE_VALUENM_DUMMY_HCO_9);
				}else {
					indto.setUnknownFlg(false);
				}
			} else {
				//ここには来ない
			}
		} else if ("0".equals(indto.getDisplayKbn())) {
			//ここには来ない
		}

		indto.setLoginJokenSetCd(loginInfo.getJokenSetCd());//MDM管理者：JKN0850 全MR：JKN0023
		indto.setLoginJgiNo(loginInfo.getJgiNo());
		// DropDownList作成
		createCombo(indto);

        // 編集可能判定
        if("".equals(indto.getReqStsCd()) || indto.getReqStsCd() == null) {
        	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        	indto.setEditApprFlg("1");
        } else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqStsCd())) {
        	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	indto.setEditApprFlg("0");
        } else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqStsCd()) && !"11".equals(indto.getReqStsCd())
        			&& !"03".equals(indto.getReqStsCd()) && !"13".equals(indto.getReqStsCd())) {
        	// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	indto.setEditApprFlg("0");
        } else {
        	indto.setEditApprFlg("1");
        }

		// END UOC
		return outdto;
	}

	/**
	 * コンボ作成
	 * @param indto ND014DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(ND014DTO indto){
		//1-2-1    大学職位
		//医師_役職マスタから下記条件で「武田役職コード：役職漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
		//        大学職位利用フラグ=1
		//        削除フラグ=0
		MRdmHcpYakushokuEntity inEntityPosCmb = new MRdmHcpYakushokuEntity();
		inEntityPosCmb.setUnivTitleFlg(1);
		inEntityPosCmb.setDelFlg(0);
		List<MRdmHcpYakushokuEntity> outMainPosList = dao.selectByValue(inEntityPosCmb);
		LinkedHashMap<String, String> mapSkUnivPosCd = new LinkedHashMap<String, String>();
		mapSkUnivPosCd.put("", "--なし--");
		for (MRdmHcpYakushokuEntity outEntity : outMainPosList) {
			mapSkUnivPosCd.put(outEntity.getTitleCode(), outEntity.getTitleKj());
		}
		indto.setSkUnivPosCdCombo(mapSkUnivPosCd);

		//1-2-2    役職
		//医師_役職マスタから下記条件で「武田役職コード：役職漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
		//        大学職位利用フラグ=0
		//        削除フラグ=0
		inEntityPosCmb.setUnivTitleFlg(0);
		inEntityPosCmb.setDelFlg(0);
		outMainPosList.clear();
		outMainPosList = dao.selectByValue(inEntityPosCmb);
		LinkedHashMap<String, String> mapSkTitleCd = new LinkedHashMap<String, String>();
		mapSkTitleCd.put("", "--なし--");
		for (MRdmHcpYakushokuEntity outEntity : outMainPosList) {
			mapSkTitleCd.put(outEntity.getTitleCode(), outEntity.getTitleKj());
		}
		indto.setSkTitleCdCombo(mapSkTitleCd);

		//1-2-3    勤務形態
		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//            コード名＝JOB_FORM（勤務形態）
		//            削除フラグ=0
		SelectComboListEntity inEntityCmb = new SelectComboListEntity();
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_JOB_FORM);
		List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapJobForm = new LinkedHashMap<String, String>();
		mapJobForm.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapJobForm.put(outEntity.getValue(), outEntity.getValueKanji());
		}
		indto.setSkJobFormCombo(mapJobForm);

		//1-2-4    薬審メンバー区分
		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//            コード名＝DCC（薬審メンバー区分）
		//            削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DCC);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapDCC = new LinkedHashMap<String, String>();
		mapDCC.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapDCC.put(outEntity.getValue(), outEntity.getValueKanji());
		}
		indto.setSkDcctypeCombo(mapDCC);

		//1-2-5     医師復活理由
		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//            コード名＝HCP_RST_REASON（医師復活理由）
		//            削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HCP_RST_REASON);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapRstReason = new LinkedHashMap<String, String>();
		mapRstReason.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapRstReason.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setRstReasonCombo(mapRstReason);

	}
	/**
	 * イベント処理
	 * @param indto ND014DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(ND014DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		// DropDownList作成
		createCombo(indto);
		// START UOC
		//一時保存ボタン押下の場合
		if ("0".equals(indto.getButtonFlg())) {
			// チェック処理（簡易）
			if(checkInput(loginInfo,indto,false)) {
		        // 編集可能判定
		        if("".equals(indto.getReqStsCd()) || indto.getReqStsCd() == null) {
		        	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
		        	indto.setEditApprFlg("1");
		        } else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqStsCd())) {
		        	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
		        	indto.setEditApprFlg("0");
		        } else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqStsCd()) && !"11".equals(indto.getReqStsCd())
		        			&& !"03".equals(indto.getReqStsCd()) && !"13".equals(indto.getReqStsCd())) {
		        	// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
		        	indto.setEditApprFlg("0");
		        } else {
		        	indto.setEditApprFlg("1");
		        }
				return outdto;
			}
		}
		//申請ボタン押下の場合または承認ボタン押下の場合
		if ("1".equals(indto.getButtonFlg()) || "3".equals(indto.getButtonFlg())) {
			// チェック処理（FULL）
			if(checkInput(loginInfo,indto,true)) {
		        // 編集可能判定
		        if("".equals(indto.getReqStsCd()) || indto.getReqStsCd() == null) {
		        	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
		        	indto.setEditApprFlg("1");
		        } else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqStsCd())) {
		        	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
		        	indto.setEditApprFlg("0");
		        } else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqStsCd()) && !"11".equals(indto.getReqStsCd())
		        			&& !"03".equals(indto.getReqStsCd()) && !"13".equals(indto.getReqStsCd())) {
		        	// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
		        	indto.setEditApprFlg("0");
		        } else {
		        	indto.setEditApprFlg("1");
		        }
				return outdto;
			}
		}
//		if ("0".equals(indto.getButtonFlg()) || "1".equals(indto.getButtonFlg()) || "3".equals(indto.getButtonFlg())) {
		if ("0".equals(indto.getButtonFlg())) {
		// 登録か更新か申請IDで判定
			if(indto.getReqId() != null && !StringUtils.isEmpty(indto.getReqId())) {
				// 更新処理
				// 現在日付を取得する
				Date currentDt = DateUtils.getNowDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String strDate = sdf.format(currentDt);
				Date dtoUpdShaYmddate = null;
				try {
					dtoUpdShaYmddate = sdf.parse(indto.getUpdShaYmd());
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//申請管理/////////////////////////////////////////////////////////////////////////////////////
				UpdateTRdmReqKnrEntity selectUpdateEntity = new UpdateTRdmReqKnrEntity();
				selectUpdateEntity.setSqlId("selectUpDate");
				selectUpdateEntity.setReqId(indto.getReqId());
				//ロック処理
				List<UpdateTRdmReqKnrEntity> outEntity1 = new ArrayList<UpdateTRdmReqKnrEntity>();
				try {
					//SQL実行
					outEntity1 = dao.select(selectUpdateEntity);
				} catch (Exception pe) {
					log.error(pe.toString());
					Throwable cause = pe.getCause();
					if (cause instanceof SQLException) {
						SQLException sqle = (SQLException)cause;
						//SQLエラーの場合はエラーコードをチェックし、業務的なエラー以外は InternalException をスローする
						int sqlCode = sqle.getErrorCode();
						//SQL業務エラーのチェック
						if (sqlCode == AppConstant.ORA_ROWLOCK_ERROR) {
							//追加、更新、削除の行ロック(for update nowait)時に発生するエラー
							//メッセージ(M0001101:他のユーザによって使用されています。)
							//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
							indto.setMsgId(RdmConstantsData.E003);
							indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
						} else {
							indto.setForward("exception");
						}
					} else {
						indto.setForward("exception");
					}
					return outdto;
				}

				if (outEntity1 == null || outEntity1.size() == 0){
					//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
					indto.setMsgId(RdmConstantsData.E003);
					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
					return outdto;
				} else {
					if (outEntity1.get(0).getUpdShaYmd().compareTo(dtoUpdShaYmddate) > 0) {
						//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
						indto.setMsgId(RdmConstantsData.E003);
						indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
						return outdto;
					}
				}

				UpdateTRdmReqKnrEntity updateEntity1 = new UpdateTRdmReqKnrEntity();
				updateEntity1.setSqlId("updateData");
				updateEntity1.setReqId(indto.getReqId());
//				if ("0".equals(indto.getButtonFlg())) {//一時保存の場合01固定、申請・承認時は更新なしで確認画面で更新
//					updateEntity1.setReqStsCd("01");//申請ステータス
//				}
	        	if("11".equals(indto.getReqStsCd())) {
	        		updateEntity1.setReqStsCd("11");
	        	} else if("03".equals(indto.getReqStsCd()) || "13".equals(indto.getReqStsCd())) {
	        		updateEntity1.setReqStsCd(indto.getReqStsCd());
	        	} else {
	        		updateEntity1.setReqStsCd("01");
	        	}
				updateEntity1.setReqComment(indto.getReqComment());//申請コメント
				updateEntity1.setAprMemo(indto.getAprMemo());//承認者メモ
				updateEntity1.setUpdShaYmd(currentDt);//更新日
				updateEntity1.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				updateEntity1.setReqYmdhms(strDate);//申請日時
				dao.update(updateEntity1);

				//医師申請管理/////////////////////////////////////////////////////////////////////////
				UpdateTRdmHcpReqEntity selectUpdateEntity2 = new UpdateTRdmHcpReqEntity();
				selectUpdateEntity2.setSqlId("selectUpDate");
				selectUpdateEntity2.setReqId(indto.getReqId());
				//ロック処理
				List<UpdateTRdmHcpReqEntity> outEntity2 = new ArrayList<UpdateTRdmHcpReqEntity>();
				try {
					//SQL実行
					outEntity2 = dao.select(selectUpdateEntity2);
				} catch (Exception pe) {
					log.error(pe.toString());
					Throwable cause = pe.getCause();
					if (cause instanceof SQLException) {
						SQLException sqle = (SQLException)cause;
						//SQLエラーの場合はエラーコードをチェックし、業務的なエラー以外は InternalException をスローする
						int sqlCode = sqle.getErrorCode();
						//SQL業務エラーのチェック
						if (sqlCode == AppConstant.ORA_ROWLOCK_ERROR) {
							//追加、更新、削除の行ロック(for update nowait)時に発生するエラー
							//メッセージ(M0001101:他のユーザによって使用されています。)
							//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
							indto.setMsgId(RdmConstantsData.E003);
							indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
						} else {
							indto.setForward("exception");
						}
					} else {
						indto.setForward("exception");
					}
					return outdto;
				}

				if (outEntity2 == null || outEntity2.size() == 0){
					//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
					indto.setMsgId(RdmConstantsData.E003);
					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
					return outdto;
				} else {
					if (outEntity2.get(0).getUpdShaYmd().compareTo(dtoUpdShaYmddate) > 0) {
						//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
						indto.setMsgId(RdmConstantsData.E003);
						indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
						return outdto;
					}
				}
				UpdateTRdmHcpReqEntity updateEntity2 = new UpdateTRdmHcpReqEntity();
				updateEntity2.setSqlId("updateData");
				updateEntity2.setReqId(indto.getReqId());
				updateEntity2.setRstReason(indto.getRstReason());//復活理由

				updateEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei().replace( "●", ""));//氏名（漢字）
				updateEntity2.setDocKanjiMei(indto.getDocKanjiMei().replace( "●", ""));//氏名（漢字）名

				if(indto.getUnknownFlg()) {
					updateEntity2.setSkInsNo(RdmConstantsData.CODE_VALUE_DUMMY_HCO_9);//勤務先施設固定コード
					updateEntity2.setSkJobForm("Z");//勤務形態
					updateEntity2.setSkDeptCd(RdmConstantsData.CODE_VALUE_DUMMY_DEPT_CODE);//所属部科コード
					updateEntity2.setSkUnivPosCd("Z");//大学職位コード
					updateEntity2.setSkTitleCd("Z");//役職コード
					updateEntity2.setSkDcctype("Z");//薬審メンバー区分
				}else {
					updateEntity2.setSkInsNo(indto.getSkInsNo());//勤務先施設固定コード
					updateEntity2.setSkJobForm(StringUtils.setEmptyToNull(indto.getSkJobForm()));//勤務形態
					updateEntity2.setSkDeptCd(indto.getSkDeptCd());//所属部科コード
					updateEntity2.setSkUnivPosCd(StringUtils.setEmptyToNull(indto.getSkUnivPosCd()));//大学職位コード
					updateEntity2.setSkTitleCd(indto.getSkTitleCd());//役職コード
					updateEntity2.setSkDcctype(StringUtils.setEmptyToNull(indto.getSkDcctype()));//薬審メンバー区分
				}
				updateEntity2.setUpdShaYmd(currentDt);//更新日
				updateEntity2.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				updateEntity2.checkSetNull();
				dao.update(updateEntity2);

				indto.setUpdShaYmd(strDate);

				SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				try {
					Date reqYmd = sdfDateTime.parse(strDate);
					String strReqYmd = sdfDateTime2.format(reqYmd);
					indto.setReqYmdhms(strReqYmd);
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}else {
				//　登録
				// 申請ID発行
				SeqRdmReqIdEntity idEntity = new SeqRdmReqIdEntity();
				List<SeqRdmReqIdEntity> outIdList = dao.select(idEntity);
				String reqId = outIdList.get(0).getReqId();
				// 登録処理
				// 申請管理
				TRdmReqKnrEntity insEntity1 =  new TRdmReqKnrEntity();
				insEntity1.setReqId(reqId); //申請ID
				if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {//MDM管理者：JKN0850 全MR：JKN0023)
					insEntity1.setReqChl("2");//申請チャネル
					insEntity1.setReqKngKbn("2");//申請者権限区分
				} else {
					insEntity1.setReqChl("1");//申請チャネル
					insEntity1.setReqKngKbn("1");//申請者権限区分
				}
				insEntity1.setReqType("34");//申請区分
				insEntity1.setReqStsCd("01");//申請ステータス
				insEntity1.setReqBrCd(loginInfo.getBrCode());//申請者所属リージョン
				insEntity1.setReqDistCd(loginInfo.getDistCode());//申請者所属エリア
				insEntity1.setReqShzNm(loginInfo.getBumonRyakuName());//申請者所属
				insEntity1.setReqJgiNo(loginInfo.getJgiNo());//申請者従業員番号
				insEntity1.setReqJgiName(loginInfo.getJgiName());//申請者氏名
				insEntity1.setReqComment(indto.getReqComment());//申請コメント
				insEntity1.setDocNo(indto.getTkdDocNo());//医師固定コード

				// 現在日付を取得する
				Date currentDt = DateUtils.getNowDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Date dtoUpdShaYmddate;
				String strDate = sdf.format(currentDt);
//				try {
//					dtoUpdShaYmddate = sdf.parse(indto.getUpdShaYmd());
//				} catch (ParseException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}

				insEntity1.setInsShaYmd(currentDt);//作成日
				insEntity1.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity1.setUpdShaYmd(currentDt);//更新日
				insEntity1.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				insEntity1.setReqYmdhms(strDate);//申請日時

				dao.insertByValue(insEntity1);

				// 医師_申請管理
				TRdmHcpReqEntity insEntity2 = new TRdmHcpReqEntity();
				insEntity2.setReqId(reqId);//申請ID
				insEntity2.setDocNo(indto.getTkdDocNo());//医師固定コード
				insEntity2.setRstReason(indto.getRstReason());//復活理由

				insEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei().replace( "●", ""));//氏名（漢字）
				insEntity2.setDocKanjiMei(indto.getDocKanjiMei().replace( "●", ""));//氏名（漢字）名

				if(indto.getUnknownFlg()) {
					insEntity2.setSkInsNo(RdmConstantsData.CODE_VALUE_DUMMY_HCO_9);//勤務先施設固定コード
					insEntity2.setSkJobForm("Z");//勤務形態
					insEntity2.setSkDeptCd(RdmConstantsData.CODE_VALUE_DUMMY_DEPT_CODE);//所属部科コード
					insEntity2.setSkUnivPosCd("Z");//大学職位コード
					insEntity2.setSkTitleCd("Z");//役職コード
					insEntity2.setSkDcctype("Z");//薬審メンバー区分
				}else {
					insEntity2.setSkInsNo(indto.getSkInsNo());//勤務先施設固定コード
					insEntity2.setSkJobForm(StringUtils.setEmptyToNull(indto.getSkJobForm()));//勤務形態
					insEntity2.setSkDeptCd(indto.getSkDeptCd());//所属部科コード
					insEntity2.setSkUnivPosCd(StringUtils.setEmptyToNull(indto.getSkUnivPosCd()));//大学職位コード
					insEntity2.setSkTitleCd(indto.getSkTitleCd());//役職コード
					insEntity2.setSkDcctype(StringUtils.setEmptyToNull(indto.getSkDcctype()));//薬審メンバー区分

				}

				insEntity2.setInsShaYmd(currentDt);//作成日
				insEntity2.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity2.setUpdShaYmd(currentDt);//更新日
				insEntity2.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				dao.insertByValue(insEntity2);

				indto.setUpdShaYmd(strDate);
				indto.setReqId(reqId);
				indto.setReqStsCd("01");
				indto.setReqStsNm("保存済み");

				SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				try {
					Date reqYmd = sdfDateTime.parse(strDate);
					String strReqYmd = sdfDateTime2.format(reqYmd);
					indto.setReqYmdhms(strReqYmd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

		}
		//審査ボタン押下の場合
		if ("2".equals(indto.getButtonFlg())) {
			// ステータス更新
			UpdateTRdmReqKnrEntity updateEntity = new UpdateTRdmReqKnrEntity();
			//        	updateEntity.setSqlId("updateShn");
			updateEntity.setReqId(indto.getReqId());
			updateEntity.setShnFlg("1");
			updateEntity.setShnBrCode(loginInfo.getBrCode());
			updateEntity.setShnDistCode(loginInfo.getDistCode());
			updateEntity.setShnShz(loginInfo.getBumonRyakuName());
			updateEntity.setShnJgiNo(loginInfo.getJgiNo());
			updateEntity.setShnShaName(loginInfo.getJgiName());
			// 現在日付を取得する
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String strDate = sdf.format(date);
			updateEntity.setShnYmdhms(strDate);
			//        	updateEntity.setAprMemo(indto.getAprMemo());

			dao.update(updateEntity);
		}
		//破棄ボタン押下の場合（申請IDがあり、本人しか操作できない状態なのでそのまま削除）
		if ("4".equals(indto.getButtonFlg())) {
			// 物理削除
			TRdmReqKnrEntity deleteEntity1 = new TRdmReqKnrEntity();
			deleteEntity1.setReqId(indto.getReqId());
			dao.deleteByPK(deleteEntity1);
			TRdmHcpReqEntity deleteEntity2 = new TRdmHcpReqEntity();
			deleteEntity2.setReqId(indto.getReqId());
			dao.deleteByPK(deleteEntity2);

		}
		// 後処理
		if ("0".equals(indto.getButtonFlg())) {
			// 一時保存の場合完了メッセージセット
			indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.I005)); // 保存が完了しました。
		}
		if ("2".equals(indto.getButtonFlg())) {
			// 審査の場合完了メッセージセット
			indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.I008)); // ステータスを審査済みに変更しました。
			indto.setShnFlg("1");
		}
		if ("1".equals(indto.getButtonFlg()) || "3".equals(indto.getButtonFlg())) {
		// 申請または承認ボタン押下でエラーなしならボタンフラグを9完了にする
			indto.setButtonFlg("9");
		}
		if ("4".equals(indto.getButtonFlg())) {
		// 削除ボタン押下でエラーなしならボタンフラグを8閉じるにする
			indto.setButtonFlg("8");
		}
        // 編集可能判定
        if("".equals(indto.getReqStsCd()) || indto.getReqStsCd() == null) {
        	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
        	indto.setEditApprFlg("1");
        } else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqStsCd())) {
        	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	indto.setEditApprFlg("0");
        } else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(indto.getReqStsCd()) && !"11".equals(indto.getReqStsCd())
        			&& !"03".equals(indto.getReqStsCd()) && !"13".equals(indto.getReqStsCd())) {
        	// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
        	indto.setEditApprFlg("0");
        } else {
        	indto.setEditApprFlg("1");
        }
		// END UOC
		return outdto;
	}

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND014DTO indto, boolean fullchkFlg) {
		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";
		if(fullchkFlg) {
			//	１：必須入力チェック
			//	項目
			if(!indto.getUnknownFlg()){
				//	勤務先情報．施設
				if(StringUtils.isEmpty(indto.getSkInsNo())) {
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "勤務先情報．施設");
					msgStr = msgStr + tmpMsgStr + "\n";
				} else {
//					勤務先情報．大学職位
					if(indto.getSkInsHoInsType().equals(RdmConstantsData.HCO_HO_INS_TYPE_1)
							&& indto.getSkInsInsClass().equals(RdmConstantsData.HCO_INS_CLASS_01)) {
						if(StringUtils.isEmpty(indto.getSkUnivPosCd())) {
							errChk = true;
							tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W031);//勤務先が大学附属病院の場合、大学職位を入力してください。
							msgStr = msgStr + tmpMsgStr + "\n";
						}
					}
				}
				//	勤務先情報．所属部科
				if(StringUtils.isEmpty(indto.getSkDeptCd())) {
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "勤務先情報．所属部科");
					msgStr = msgStr + tmpMsgStr + "\n";
				}
				//	勤務先情報．役職
				if(StringUtils.isEmpty(indto.getSkTitleCd())) {
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "勤務先情報．役職");
					msgStr = msgStr + tmpMsgStr + "\n";
				}

			}
			//	復活理由
			if(StringUtils.isEmpty(indto.getRstReason())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "復活理由");
				msgStr = msgStr + tmpMsgStr + "\n";
			}else {
				// 削除理由が「その他（復活理由コメント・必須）」の場合、必須項目に値が入力されているか確認
				if(indto.getRstReason().equals("02") && StringUtils.isEmpty(indto.getReqComment())) {
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
					msgStr = msgStr + tmpMsgStr + "\n";
				}
			}
		}
		//      ２：レングスチェック
		//      項目                                チェック内容
		int len = 0;

		//      申請コメント                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getReqComment())) {
			//len = StringUtils.getByteLength(indto.getReqComment());
			len = indto.getReqComment().length();
			if(len > 100) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      審査・承認メモ                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getAprMemo())) {
			//len = StringUtils.getByteLength(indto.getAprMemo());
			len = indto.getAprMemo().length();
			if(len > 100) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "審査・承認メモ");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//		７：整合性チェック
		if(fullchkFlg) {

			//		項目                                チェック内容
			//		重複申請チェック 同じ医師固定コードに紐づく医師削除申請がすでに存在している場合    W008     重複する申請が行われています。（医師固定C）
			SelectND014MainDataEntity paramChkEntity = new SelectND014MainDataEntity();
			paramChkEntity.setSqlId("selectND014CheckRstData");
			paramChkEntity.setInDocNo(indto.getTkdDocNo());
			paramChkEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
			List<SelectND014MainDataEntity> chkEntityList1 = dao.select(paramChkEntity);
			if(chkEntityList1.size() > 0) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008);//重複する申請が行われています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師固定C");
				msgStr = msgStr + tmpMsgStr + "\n";
			}

			//		整合性チェック                              廃院を勤務先施設に選択して申請している場合
			paramChkEntity.setSqlId("selectND014CheckDelInsData");
			paramChkEntity.setSkInsNo(indto.getSkInsNo());
			List<SelectND014MainDataEntity> chkEntityList2 = dao.select(paramChkEntity);
			if(!chkEntityList2.isEmpty()) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W062);//勤務先に廃院が選択されています。
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

}
