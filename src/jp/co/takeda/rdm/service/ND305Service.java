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
import jp.co.takeda.rdm.dto.ND305DTO;
import jp.co.takeda.rdm.entity.join.MRdmHcpYakushokuEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectND305MainDataEntity;
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
 * Serviceクラス（ND305)
 * @generated
 */
@Named
public class ND305Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(ND305Service.class);

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
	 * @param indto ND305DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND305DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		if("9".equals(indto.getDisplayKbn())) {
			createCombo(indto);
			indto.setRstReasonNm(StringUtils.nvl(indto.getRstReasonCombo().get(indto.getRstReason()), ""));
			indto.setSkUnivPosNm(StringUtils.nvl(indto.getSkUnivPosCdCombo().get(indto.getSkUnivPosCd()), ""));
			indto.setSkTitleNm(StringUtils.nvl(indto.getSkTitleCdCombo().get(indto.getSkTitleCd()), ""));
			indto.setSkJobFormNm(StringUtils.nvl(indto.getSkJobFormCombo().get(indto.getSkJobForm()), ""));
			indto.setSkDcctypeNm(StringUtils.nvl(indto.getSkDcctypeCombo().get(indto.getSkDcctype()), ""));
		} else {
			//		登録画面から申請IDを連携
			if (indto.getReqId() != null) {
				// 申請データ（一時保存含む）を参照
				SelectND305MainDataEntity paramEntity = new SelectND305MainDataEntity();
				paramEntity.setInReqId(indto.getReqId());
				List<SelectND305MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectND305MainDataEntity mainDataEntity = mainDataEntityList.get(0);
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
				indto.setRstReasonNm(StringUtils.nvl(mainDataEntity.getRstReasonNm(), ""));
				indto.setSkInsNm(StringUtils.nvl(mainDataEntity.getSkInsNm(), ""));
				indto.setSkUnivPosCd(StringUtils.nvlUpd(mainDataEntity.getSkUnivPosCd(), ""));
				indto.setSkDeptNm(StringUtils.nvl(mainDataEntity.getSkDeptNm(), ""));
				indto.setSkTitleCd(StringUtils.nvlUpd(mainDataEntity.getSkTitleCd(), ""));
				indto.setSkJobForm(StringUtils.nvlUpd(mainDataEntity.getSkJobForm(), ""));
				indto.setSkDcctype(StringUtils.nvlUpd(mainDataEntity.getSkDcctype(), ""));
				indto.setSkInsNo(StringUtils.nvl(mainDataEntity.getSkInsNo(), ""));
				indto.setSkDeptCd(StringUtils.nvl(mainDataEntity.getSkDeptCd(), ""));

				indto.setSkUnivPosNm(StringUtils.nvl(mainDataEntity.getSkUnivPosNm(), ""));
				indto.setSkTitleNm(StringUtils.nvl(mainDataEntity.getSkTitleNm(), ""));
				indto.setSkJobFormNm(StringUtils.nvl(mainDataEntity.getSkJobFormNm(), ""));
				indto.setSkDcctypeNm(StringUtils.nvl(mainDataEntity.getSkDcctypeNm(), ""));
				indto.setSkInsHoInsType(StringUtils.nvl(mainDataEntity.getSkInsHoInsType(), ""));
				indto.setSkInsInsClass(StringUtils.nvl(mainDataEntity.getSkInsInsClass(), ""));

				if(indto.getSkInsNo().equals(RdmConstantsData.CODE_VALUE_DUMMY_HCO_9)) {
					indto.setSkInsNm(RdmConstantsData.CODE_VALUENM_DUMMY_HCO_9);
				}
				indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
				indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
				indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));
				indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
				indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));

				if(indto.getReqStsCd().equals("01")) {
					//申請者の初期操作では申請者情報が無いのでログイン情報をセットしておく
					indto.setReqShzNm(loginInfo.getBumonRyakuName());
					indto.setReqJgiName(loginInfo.getJgiName());
					indto.setReqJgiNo(loginInfo.getJgiNo());
					indto.setReqBrCd(loginInfo.getBrCode());
					indto.setReqDistCd(loginInfo.getDistCode());
				}
			} else {
				//TODO 遷移エラー
			}
		}
		// パラメタ医師メニュー取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName(jp.co.takeda.rdm.util.RdmConstantsData.PARAM_NAME_MN_DOC);
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// valueの左一桁（新規）
			String value = mRdmParamMstEntityList.get(0).getValue().substring(0,1);
			if("1".equals(value)) {
				// 申請・承認・却下ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}
		if(loginInfo.getJokenSetCd().equals(RdmConstantsData.RDM_JKN_ADMIN)) {
			indto.setFbReqFlg(true);//初期値はチェックON
		}
		indto.setLoginJokenSetCd(loginInfo.getJokenSetCd());//MDM管理者：JKN0850 全MR：JKN0023
		indto.setLoginJgiNo(loginInfo.getJgiNo());
//		// DropDownList作成
//		createCombo(indto);

		// END UOC
		return outdto;
	}


	/**
	 * イベント処理
	 * @param indto ND305DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(ND305DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		// パラメタ医師メニュー取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName(jp.co.takeda.rdm.util.RdmConstantsData.PARAM_NAME_MN_DOC);
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// valueの左一桁（新規）
			String value = mRdmParamMstEntityList.get(0).getValue().substring(0,1);
			if("1".equals(value)) {
				// 申請・承認・却下ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}
		// START UOC
		//却下ボタン押下の場合
		if ("2".equals(indto.getButtonFlg())) {
			// チェック処理（FULL）
			if(checkInput(loginInfo,indto,true)) {
				indto.setReturnFlg("0");
				return outdto;
			}
		}
		//申請ボタン押下の場合または承認ボタン押下の場合
		if ("0".equals(indto.getButtonFlg()) || "1".equals(indto.getButtonFlg())) {
			// チェック処理（簡易）
			if(checkInput(loginInfo,indto,false)) {
				indto.setReturnFlg("0");
				return outdto;
			}
		}
		if ("0".equals(indto.getButtonFlg()) || "1".equals(indto.getButtonFlg()) || "2".equals(indto.getButtonFlg())) {
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
					indto.setReturnFlg("0");
					return outdto;
				}

				if (outEntity1 == null || outEntity1.size() == 0){
					//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
					indto.setMsgId(RdmConstantsData.E003);
					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
					indto.setReturnFlg("0");
					return outdto;
				} else {
					if (outEntity1.get(0).getUpdShaYmd().compareTo(dtoUpdShaYmddate) > 0) {
						//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
						indto.setMsgId(RdmConstantsData.E003);
						indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
						indto.setReturnFlg("0");
						return outdto;
					}
				}

				UpdateTRdmReqKnrEntity updateEntity1 = new UpdateTRdmReqKnrEntity();
				updateEntity1.setSqlId("updateData");
				updateEntity1.setReqId(indto.getReqId());
				String reqChl = indto.getReqChl();
				if ("0".equals(indto.getButtonFlg())) {//申請
					if(reqChl.equals("3")) {//ULT起因
						updateEntity1.setReqStsCd("13");//　申請ステータス
					}else {
						updateEntity1.setReqStsCd("03");//　申請ステータス
						// 申請者権限区分
						if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {
							//MDM管理者：JKN0850 全MR：JKN0023)
							updateEntity1.setReqKngKbn("2");
							updateEntity1.setReqChl("2");
						}else {
							updateEntity1.setReqKngKbn("1");
							updateEntity1.setReqChl("1");
						}
					}
					updateEntity1.setReqBrCd(loginInfo.getBrCode());// 申請者所属リージョン
					updateEntity1.setReqDistCd(loginInfo.getDistCode());// 申請者所属エリア
					updateEntity1.setReqShzNm(loginInfo.getBumonRyakuName());// 申請者所属
					updateEntity1.setReqJgiNo(loginInfo.getJgiNo());// 申請者従業員番号
					updateEntity1.setReqJgiName(loginInfo.getJgiName());// 申請者氏名
					updateEntity1.setReqYmdhms(strDate); // 申請日時
					updateEntity1.setReqComment(indto.getReqComment());//　申請コメント
				}
				if ("1".equals(indto.getButtonFlg())) {//承認
					if(reqChl.equals("3")) {//ULT起因
						updateEntity1.setReqStsCd("14");//　申請ステータス
					}else {
						updateEntity1.setReqStsCd("04");//　申請ステータス
					}
					updateEntity1.setAprBrCode(loginInfo.getBrCode());// 承認者所属リージョン
					updateEntity1.setAprDistCode(loginInfo.getDistCode());// 承認者所属エリア
					updateEntity1.setAprShz(loginInfo.getBumonRyakuName());// 承認者所属
					updateEntity1.setAprJgiNo(loginInfo.getJgiNo());// 承認者従業員番号
					updateEntity1.setAprShaName(loginInfo.getJgiName());// 承認者氏名
					updateEntity1.setAprYmdhms(strDate);// 承認日時
					if(indto.getFbReqFlg()) {
						updateEntity1.setFbReqFlg("1");//FB申請要否フラグ
					}else {
						updateEntity1.setFbReqFlg("0");//FB申請要否フラグ
					}
					updateEntity1.setAprComment(indto.getAprComment());//承認者コメント
					updateEntity1.setAprMemo(indto.getAprMemo());//承認者メモ
				}
				if ("2".equals(indto.getButtonFlg())) {//却下
					if(reqChl.equals("3")) {//ULT起因
						updateEntity1.setReqStsCd("12");//　申請ステータス
					}else {
						updateEntity1.setReqStsCd("02");//　申請ステータス
					}
					updateEntity1.setAprBrCode(loginInfo.getBrCode());// 承認者所属リージョン
					updateEntity1.setAprDistCode(loginInfo.getDistCode());// 承認者所属エリア
					updateEntity1.setAprShz(loginInfo.getBumonRyakuName());// 承認者所属
					updateEntity1.setAprJgiNo(loginInfo.getJgiNo());// 承認者従業員番号
					updateEntity1.setAprShaName(loginInfo.getJgiName());// 承認者氏名
					updateEntity1.setAprYmdhms(strDate);// 承認日時
					updateEntity1.setAprComment(indto.getAprComment());//承認者コメント
					updateEntity1.setAprMemo(indto.getAprMemo());//承認者メモ
				}
				updateEntity1.setUpdShaYmd(currentDt);//更新日
				updateEntity1.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
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
				if ("0".equals(indto.getButtonFlg()) || "1".equals(indto.getButtonFlg())) {
					updateEntity2.setRstReason(indto.getRstReason());//復活理由
					if(indto.getDocKanjiMei().endsWith("●")) {
						updateEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei().replace( "●", ""));//氏名（漢字）
						updateEntity2.setDocKanjiMei(indto.getDocKanjiMei().replace( "●", ""));//氏名（漢字）名
					}

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
				}
				if ("2".equals(indto.getButtonFlg())) {
					updateEntity2.setDocKanj(null);
					updateEntity2.setDocKanjiMei(null);
					updateEntity2.setDocKanjNullFlag(true);
					updateEntity2.setDocKanjiMeiNullFlag(true);
				}
				updateEntity2.setUpdShaYmd(currentDt);//更新日
				updateEntity2.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				updateEntity2.checkSetNull();
				dao.update(updateEntity2);

				indto.setUpdShaYmd(strDate);
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
				insEntity1.setReqStsCd("03");//申請ステータス
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

				insEntity1.setReqYmdhms(strDate); // 申請日時
				insEntity1.setInsShaYmd(currentDt);//作成日
				insEntity1.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity1.setUpdShaYmd(currentDt);//更新日
				insEntity1.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者

				dao.insertByValue(insEntity1);

				// 医師_申請管理
				TRdmHcpReqEntity insEntity2 = new TRdmHcpReqEntity();
				insEntity2.setReqId(reqId);//申請ID
				insEntity2.setDocNo(indto.getTkdDocNo());//医師固定コード
				insEntity2.setRstReason(indto.getRstReason());//復活理由
				if(indto.getDocKanjiMei().endsWith("●")) {
					insEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei().replace( "●", ""));//氏名（漢字）
					insEntity2.setDocKanjiMei(indto.getDocKanjiMei().replace( "●", ""));//氏名（漢字）名
				}

				//TODO
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
				indto.setReqStsCd("03");
				indto.setReqStsNm("承認待ち");
			}
//				if ("0".equals(indto.getButtonFlg())) {
//					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.I005));
//					return outdto;
//				}
//				if ("1".equals(indto.getButtonFlg())) {
//					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.I015));
//					return outdto;
//				}
//				if ("3".equals(indto.getButtonFlg())) {
//					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.I012));
//					return outdto;
//				}
				indto.setReturnFlg("9");
		}
		//TODO 後処理
		// END UOC
		return outdto;
	}

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND305DTO indto, boolean fullchkFlg) {
		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";
		if(fullchkFlg) {
			//	１：必須入力チェック
			//	項目
			//	却下コメント
			if(StringUtils.isEmpty(indto.getAprComment())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W026);//却下の場合はコメントを入力してください。
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      ２：レングスチェック
		//      項目                                チェック内容
		int len = 0;

		//      申請コメント                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getReqComment())) {
			len = StringUtils.getByteLength(indto.getReqComment());
			if(len > 300) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      申請コメント                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getAprComment())) {
			len = StringUtils.getByteLength(indto.getAprComment());
			if(len > 300) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "却下コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		//		項目                                チェック内容
		//		重複申請チェック 同じ医師固定コードに紐づく医師削除申請がすでに存在している場合    W008     重複する申請が行われています。（医師固定C）
		SelectND305MainDataEntity paramChkEntity = new SelectND305MainDataEntity();
		paramChkEntity.setSqlId("selectND305CheckRstData");
		paramChkEntity.setInDocNo(indto.getTkdDocNo());
		paramChkEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
		List<SelectND305MainDataEntity> chkEntityList1 = dao.select(paramChkEntity);
		if(chkEntityList1.size() > 0) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008);//重複する申請が行われています。（項目名）
			tmpMsgStr = tmpMsgStr.replace("項目名", "医師固定C");
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

	/**
	 * コンボ作成
	 * @param indto ND305DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(ND305DTO indto){
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
}
