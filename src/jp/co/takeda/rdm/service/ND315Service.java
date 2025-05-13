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
import jp.co.takeda.rdm.dto.HcpPublicData;
import jp.co.takeda.rdm.dto.HcpSocietyData;
import jp.co.takeda.rdm.dto.ND315DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;

import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.RdmCommonEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpWorkEntity;
import jp.co.takeda.rdm.entity.join.SelectND315MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpKmuReqEntity;
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
 * Serviceクラス（ND315)
 * @generated
 */
@Named
public class ND315Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(ND315Service.class);

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
	 * @param indto ND315DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND315DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		if("9".equals(indto.getDisplayKbn())) {
			createCombo(indto);
			indto.setDelReasonNm(StringUtils.nvl(indto.getDelReasonCombo().get(indto.getDelReason()), ""));
		} else {
			//		登録画面から申請IDを連携
			if (indto.getReqId() != null) {
				// 申請データ（一時保存含む）を参照
				SelectND315MainDataEntity paramEntity = new SelectND315MainDataEntity();
				paramEntity.setInReqId(indto.getReqId());
				List<SelectND315MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectND315MainDataEntity mainDataEntity = mainDataEntityList.get(0);
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
				indto.setDocAttribute(StringUtils.nvl(mainDataEntity.getDocAttribute(), ""));
				indto.setDocAttributeNm(StringUtils.nvl(mainDataEntity.getDocAttributeNm(), ""));
				indto.setDelReason(StringUtils.nvl(mainDataEntity.getDelReason(), ""));
				indto.setDelReasonNm(StringUtils.nvl(mainDataEntity.getDelReasonNm(), ""));
				indto.setDocKanjiSei(StringUtils.nvl(mainDataEntity.getDocKanjiSei(), ""));
				indto.setDocKanjiMei(StringUtils.nvl(mainDataEntity.getDocKanjiMei(), ""));
				indto.setDupDocNo(StringUtils.nvl(mainDataEntity.getDupDocNo(), ""));
				indto.setDupDocNm(StringUtils.nvl(mainDataEntity.getDupDocNm(), ""));

				indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
				indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
				indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));
				indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
				indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));

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
			// valueの左3桁（削除）
			String value = mRdmParamMstEntityList.get(0).getValue().substring(2,3);
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

		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 * @param indto ND315DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(ND315DTO indto) {
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
			// valueの左3桁（削除）
			String value = mRdmParamMstEntityList.get(0).getValue().substring(2,3);
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
			String reqChl = indto.getReqChl();

			// 登録か更新か申請IDで判定
			if(indto.getReqId() != null && !StringUtils.isEmpty(indto.getReqId())) {
				// 更新処理
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

				if ("0".equals(indto.getButtonFlg())) {//申請
					if(reqChl.equals("3")) {//ULT起因
						updateEntity1.setReqStsCd("13");//　申請ステータス
					}else {
						updateEntity1.setReqStsCd("03");//　申請ステータス
						// 申請者権限区分
						if(!indto.getReqChl().equals("3")) {
							if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {
								//MDM管理者：JKN0850 全MR：JKN0023)
								updateEntity1.setReqKngKbn("2");
								updateEntity1.setReqChl("2");
							}else {
								updateEntity1.setReqKngKbn("1");
								updateEntity1.setReqChl("1");
							}
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
//					//※削除理由が'01'(医療従事者の死亡)の場合、申請時に'1'を設定
//					if(indto.getDelReason().equals("01")) {
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
					updateEntity2.setDelReason(indto.getDelReason());//削除理由
					updateEntity2.setDupDocNo(StringUtils.setEmptyToNull(indto.getDupDocNo()));//重複医師コード
					if(StringUtils.isEmpty(updateEntity2.getDupDocNo())) {
						updateEntity2.setDupDocNoNullFlag(true);
					}
					if(!indto.getDocKanjiMei().endsWith("●")) {
						updateEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei() + "●");//氏名（漢字）
						updateEntity2.setDocKanjiMei(indto.getDocKanjiMei() + "●");//氏名（漢字）名
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
				insEntity1.setReqType("33");//申請区分
				insEntity1.setReqStsCd("03");//申請ステータス
				insEntity1.setReqBrCd(loginInfo.getBrCode());//申請者所属リージョン
				insEntity1.setReqDistCd(loginInfo.getDistCode());//申請者所属エリア
				insEntity1.setReqShzNm(loginInfo.getBumonRyakuName());//申請者所属
				insEntity1.setReqJgiNo(loginInfo.getJgiNo());//申請者従業員番号
				insEntity1.setReqJgiName(loginInfo.getJgiName());//申請者氏名
				insEntity1.setReqComment(indto.getReqComment());//申請コメント
				insEntity1.setDocNo(indto.getTkdDocNo());//医師固定コード
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
				insEntity2.setDelReason(indto.getDelReason());//削除理由
				insEntity2.setDupDocNo(StringUtils.setEmptyToNull(indto.getDupDocNo()));//重複医師コード
				if(!indto.getDocKanjiMei().endsWith("●")) {
					insEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei() + "●");//氏名（漢字）
					insEntity2.setDocKanjiMei(indto.getDocKanjiMei() + "●");//氏名（漢字）名
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
			//勤務先の削除申請の発行
			if ("0".equals(indto.getButtonFlg())) {//申請
				//未削除の削除申請の取得(一緒に翌営業日取得)
				SelectHcpWorkEntity wkEntity = new SelectHcpWorkEntity();
				wkEntity.setInDocNo(indto.getTkdDocNo());
				List<SelectHcpWorkEntity> outWorkList = dao.select(wkEntity);
				for (SelectHcpWorkEntity wData : outWorkList) {
					// 申請ID発行
					SeqRdmReqIdEntity idEntity = new SeqRdmReqIdEntity();
					List<SeqRdmReqIdEntity> outIdList = dao.select(idEntity);
					String reqId = outIdList.get(0).getReqId();

					//申請管理
					TRdmReqKnrEntity insEntity1 =  new TRdmReqKnrEntity();
					insEntity1.setReqId(reqId); //申請ID
					if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {//MDM管理者：JKN0850 全MR：JKN0023)
						insEntity1.setReqChl("2");//申請チャネル
						insEntity1.setReqKngKbn("2");//申請者権限区分
					} else {
						insEntity1.setReqChl("1");//申請チャネル
						insEntity1.setReqKngKbn("1");//申請者権限区分
					}
					insEntity1.setReqType("44");//申請区分
					insEntity1.setReqStsCd("03");//申請ステータス
					insEntity1.setReqBrCd(loginInfo.getBrCode());//申請者所属リージョン
					insEntity1.setReqDistCd(loginInfo.getDistCode());//申請者所属エリア
					insEntity1.setReqShzNm(loginInfo.getBumonRyakuName());//申請者所属
					insEntity1.setReqJgiNo(loginInfo.getJgiNo());//申請者従業員番号
					insEntity1.setReqJgiName(loginInfo.getJgiName());//申請者氏名
					insEntity1.setReqComment(indto.getReqComment());//申請コメント
					insEntity1.setDocNo(indto.getTkdDocNo());//医師固定コード

					insEntity1.setReqMemo(indto.getReqId());
					insEntity1.setTekiyoYmd(wData.getNextBizday());
					insEntity1.setFbReqFlg("1");//FB申請要否フラグ
					insEntity1.setReqYmdhms(strDate); // 申請日時
					insEntity1.setInsShaYmd(currentDt);//作成日
					insEntity1.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
					insEntity1.setUpdShaYmd(currentDt);//更新日
					insEntity1.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者

					dao.insertByValue(insEntity1);

					// 勤務先_申請管理
					TRdmHcpKmuReqEntity insEntity2 = new TRdmHcpKmuReqEntity();
					insEntity2.setReqId(reqId);
					insEntity2.setDocNo(indto.getTkdDocNo());
					insEntity2.setInsNoMt(wData.getInsNo());
					insEntity2.setInsNoSk("Z");
					insEntity2.setJobFormBf(StringUtils.setEmptyToNull(wData.getJobForm()));
					insEntity2.setDeptCodeBf(StringUtils.setEmptyToNull(wData.getDeptCode()));
					insEntity2.setDeptKanjiBf(StringUtils.setEmptyToNull(wData.getDeptKanji()));
					insEntity2.setDeptKanaBf(StringUtils.setEmptyToNull(wData.getDeptKana()));
					insEntity2.setUnivPosCodeBf(StringUtils.setEmptyToNull(wData.getUnivPosCode()));
					insEntity2.setTitleCodeBf(StringUtils.setEmptyToNull(wData.getTitleCode()));
					insEntity2.setDccTypeBf(StringUtils.setEmptyToNull(wData.getDccType()));
					insEntity2.setJobFormAf("Z");
					insEntity2.setDeptCodeAf("Z");
					insEntity2.setDeptKanjiAf("Z");
					insEntity2.setDeptKanaAf("Z");
					insEntity2.setUltDocNo(StringUtils.setEmptyToNull(wData.getUltDocNo()));
					insEntity2.setInsShaYmd(currentDt);//作成日
					insEntity2.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
					insEntity2.setUpdShaYmd(currentDt);//更新日
					insEntity2.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
					dao.insertByValue(insEntity2);
				}

				// 医師免許返納・死亡のダミー施設への勤務先追加の申請を作成する
				// 申請ID発行
				SeqRdmReqIdEntity idEntity = new SeqRdmReqIdEntity();
				List<SeqRdmReqIdEntity> outIdList = dao.select(idEntity);
				String reqId = outIdList.get(0).getReqId();

				// 翌営業日を取得
				// 現在日付を取得
		        Date systemDate = DateUtils.getNowDate();
		        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMdd");
		        String sysDate = fmtDate.format(systemDate);

		    	RdmCommonEntity rdmCommonEntity = new RdmCommonEntity("getNextBizday");
		    	rdmCommonEntity.setInVBatDate(sysDate);
		    	List<RdmCommonEntity> rdmCommonEntityList = dao.select(rdmCommonEntity);

		    	String tekiyoYmd = null;
		    	if(rdmCommonEntityList.size() > 0) {
		        	tekiyoYmd = rdmCommonEntityList.get(0).getNextBizday();
	    		}

				// 申請管理
				TRdmReqKnrEntity tRdmReqKnrEntity =  new TRdmReqKnrEntity();
				tRdmReqKnrEntity.setReqId(reqId); //申請ID
				if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {
					tRdmReqKnrEntity.setReqChl("2");//申請チャネル
					tRdmReqKnrEntity.setReqKngKbn("2");//申請者権限区分
				} else {
					tRdmReqKnrEntity.setReqChl("1");//申請チャネル
					tRdmReqKnrEntity.setReqKngKbn("1");//申請者権限区分
				}
				tRdmReqKnrEntity.setReqType("41");//申請区分
				tRdmReqKnrEntity.setReqStsCd("03");//申請ステータス
				tRdmReqKnrEntity.setReqBrCd(loginInfo.getBrCode());//申請者所属リージョン
				tRdmReqKnrEntity.setReqDistCd(loginInfo.getDistCode());//申請者所属エリア
				tRdmReqKnrEntity.setReqShzNm(loginInfo.getBumonRyakuName());//申請者所属
				tRdmReqKnrEntity.setReqJgiNo(loginInfo.getJgiNo());//申請者従業員番号
				tRdmReqKnrEntity.setReqJgiName(loginInfo.getJgiName());//申請者氏名
				tRdmReqKnrEntity.setReqComment(indto.getReqComment());//申請コメント
				tRdmReqKnrEntity.setDocNo(indto.getTkdDocNo());//医師固定コード

				tRdmReqKnrEntity.setReqMemo(indto.getReqId());
				tRdmReqKnrEntity.setTekiyoYmd(tekiyoYmd);
				tRdmReqKnrEntity.setFbReqFlg("1");//FB申請要否フラグ
				tRdmReqKnrEntity.setReqYmdhms(strDate); // 申請日時
				tRdmReqKnrEntity.setInsShaYmd(currentDt);//作成日
				tRdmReqKnrEntity.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				tRdmReqKnrEntity.setUpdShaYmd(currentDt);//更新日
				tRdmReqKnrEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者

				dao.insertByValue(tRdmReqKnrEntity);

				// 勤務先_申請管理
				TRdmHcpKmuReqEntity tRdmHcpKmuReqEntity = new TRdmHcpKmuReqEntity();
				tRdmHcpKmuReqEntity.setReqId(reqId);
				tRdmHcpKmuReqEntity.setDocNo(indto.getTkdDocNo());

				tRdmHcpKmuReqEntity.setInsNoSk("953000000");
				tRdmHcpKmuReqEntity.setJobFormAf("0");
				tRdmHcpKmuReqEntity.setDeptCodeAf("9999");
				tRdmHcpKmuReqEntity.setDeptKanjiAf("未登録");
				tRdmHcpKmuReqEntity.setDeptKanaAf("ﾐﾄｳﾛｸ");
				tRdmHcpKmuReqEntity.setTitleCodeAf("999");
				tRdmHcpKmuReqEntity.setDccTypeAf("0");

				tRdmHcpKmuReqEntity.setUltDocNo(indto.getUltDocNo());
				tRdmHcpKmuReqEntity.setInsShaYmd(currentDt);//作成日
				tRdmHcpKmuReqEntity.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				tRdmHcpKmuReqEntity.setUpdShaYmd(currentDt);//更新日
				tRdmHcpKmuReqEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				dao.insertByValue(tRdmHcpKmuReqEntity);

			}
			//TODO
			//自申請IDに紐づく勤務先削除も却下
			if ("1".equals(indto.getButtonFlg()) || "2".equals(indto.getButtonFlg())) {
				UpdateTRdmReqKnrEntity selectLinkEntity = new UpdateTRdmReqKnrEntity();
				selectLinkEntity.setSqlId("selectLinkDate");
				selectLinkEntity.setReqId(indto.getReqId());
				List<UpdateTRdmReqKnrEntity> linkList = dao.select(selectLinkEntity);
				for (UpdateTRdmReqKnrEntity lData : linkList) {
					UpdateTRdmReqKnrEntity selectLinkUpdateEntity = new UpdateTRdmReqKnrEntity();
					selectLinkUpdateEntity.setSqlId("selectUpDate");
					selectLinkUpdateEntity.setReqId(lData.getReqId());
					//ロック処理
					List<UpdateTRdmReqKnrEntity> outLinkEntity = new ArrayList<UpdateTRdmReqKnrEntity>();
					try {
						//SQL実行
						outLinkEntity = dao.select(selectLinkUpdateEntity);
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

					if (outLinkEntity == null || outLinkEntity.size() == 0){
						//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
						indto.setMsgId(RdmConstantsData.E003);
						indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
						indto.setReturnFlg("0");
						return outdto;
					} else {
						if (outLinkEntity.get(0).getUpdShaYmd().compareTo(dtoUpdShaYmddate) > 0) {
							//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
							indto.setMsgId(RdmConstantsData.E003);
							indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
							indto.setReturnFlg("0");
							return outdto;
						}
					}

					UpdateTRdmReqKnrEntity updateLinkEntity = new UpdateTRdmReqKnrEntity();
					updateLinkEntity.setSqlId("updateData");
					updateLinkEntity.setReqId(lData.getReqId());
					if ("1".equals(indto.getButtonFlg())) {//承認
						if(reqChl.equals("3")) {//ULT起因
							updateLinkEntity.setReqStsCd("14");//　申請ステータス
						}else {
							updateLinkEntity.setReqStsCd("04");//　申請ステータス
						}
						updateLinkEntity.setAprBrCode(loginInfo.getBrCode());// 承認者所属リージョン
						updateLinkEntity.setAprDistCode(loginInfo.getDistCode());// 承認者所属エリア
						updateLinkEntity.setAprShz(loginInfo.getBumonRyakuName());// 承認者所属
						updateLinkEntity.setAprJgiNo(loginInfo.getJgiNo());// 承認者従業員番号
						updateLinkEntity.setAprShaName(loginInfo.getJgiName());// 承認者氏名
						updateLinkEntity.setAprYmdhms(strDate);// 承認日時
						updateLinkEntity.setAprComment(indto.getAprComment());//承認者コメント

					}
					if ("2".equals(indto.getButtonFlg())) {//却下
						if(reqChl.equals("3")) {//ULT起因
							updateLinkEntity.setReqStsCd("12");//　申請ステータス
						}else {
							updateLinkEntity.setReqStsCd("02");//　申請ステータス
						}
						updateLinkEntity.setAprBrCode(loginInfo.getBrCode());// 承認者所属リージョン
						updateLinkEntity.setAprDistCode(loginInfo.getDistCode());// 承認者所属エリア
						updateLinkEntity.setAprShz(loginInfo.getBumonRyakuName());// 承認者所属
						updateLinkEntity.setAprJgiNo(loginInfo.getJgiNo());// 承認者従業員番号
						updateLinkEntity.setAprShaName(loginInfo.getJgiName());// 承認者氏名
						updateLinkEntity.setAprYmdhms(strDate);// 承認日時
						updateLinkEntity.setAprComment(indto.getAprComment());//承認者コメント
					}
					updateLinkEntity.setUpdShaYmd(currentDt);//更新日
					updateLinkEntity.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
					dao.update(updateLinkEntity);
				}
			}
				indto.setReturnFlg("9");
		}
		//TODO 後処理
		// END UOC
		return outdto;
	}

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND315DTO indto, boolean fullchkFlg) {
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

		//	申請コメント
		// 削除理由が「その他（削除理由コメント・必須）」の場合、必須項目に値が入力されているか確認
		if(indto.getDelReason().equals("04") && StringUtils.isEmpty(indto.getReqComment())) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
			tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
			msgStr = msgStr + tmpMsgStr + "\n";
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
		//      申請コメント                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getAprComment())) {
			//len = StringUtils.getByteLength(indto.getAprComment());
			len = indto.getAprComment().length();
			if(len > 100) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "却下コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		//		項目                                チェック内容
		//		重複申請チェック 同じ医師固定コードに紐づく医師削除申請がすでに存在している場合    W008     重複する申請が行われています。（医師固定C）
		SelectND315MainDataEntity paramChkEntity = new SelectND315MainDataEntity();
		paramChkEntity.setSqlId("selectND315CheckDelData");
		paramChkEntity.setInDocNo(indto.getTkdDocNo());
		paramChkEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
		List<SelectND315MainDataEntity> chkEntityList1 = dao.select(paramChkEntity);
		if(chkEntityList1.size() > 0) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008);//重複する申請が行われています。（項目名）
			tmpMsgStr = tmpMsgStr.replace("項目名", "医師固定C");
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		// 整合性チェック 削除理由が「医師免許返納・死亡」以外で、所属施設が2つの以上の場合    W033    勤務先が2件以上存在するため申請できません。
		if(!StringUtils.isEmpty(indto.getDelReason())) {
			if(!indto.getDelReason().equals("01") && !indto.getDelReason().equals("03")) {
				paramChkEntity.setSqlId("selectND315CheckKinmuData");
				paramChkEntity.setInDocNo(indto.getTkdDocNo());
				List<SelectND315MainDataEntity> chkEntityList2 = dao.select(paramChkEntity);
				if(chkEntityList2.size() > 1){
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W056);//勤務先が2件以上存在するため申請できません。
					msgStr = msgStr + tmpMsgStr + "\n";
				}
			}
		}
		// 整合性チェック MR権限で医師の所属施設がダミー施設の場合    W034     医療機関外へ異動されている医師は削除できません。
		if(RdmConstantsData.RDM_JKN_MR.equals(loginInfo.getJokenSetCd())){
			paramChkEntity.setSqlId("selectND315CheckKinmuDummyData");
			paramChkEntity.setInDocNo(indto.getTkdDocNo());
			List<SelectND315MainDataEntity> chkEntityList3 = dao.select(paramChkEntity);
			if(chkEntityList3.size() > 0){
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W057);// 医療機関外へ異動されている医師は削除できません。
				msgStr = msgStr + tmpMsgStr + "\n";
			}

		}
		// 適用日チェック 勤務先変更の申請（承認済みで適用日が未来日）が1件以上存在する場合    W035    医師は異動が予定されています。
		paramChkEntity.setSqlId("selectND315CheckKinmuChangeData");
		paramChkEntity.setInDocNo(indto.getTkdDocNo());
		List<SelectND315MainDataEntity> chkEntityList4 = dao.select(paramChkEntity);
		if(chkEntityList4.size() > 0){
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W058);//  医師は異動が予定されています。
			msgStr = msgStr + tmpMsgStr + "\n";
		}
		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

	/**
	 * コンボ作成
	 * @param indto ND315DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(ND315DTO indto){
		//1-2-1     医師削除理由
		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//            コード名＝HCP_DEL_REASON（医師削除理由）
		//            削除フラグ=0
		SelectComboListEntity inEntityCmb = new SelectComboListEntity();
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HCP_DEL_REASON);
		List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapDelReason = new LinkedHashMap<String, String>();
		mapDelReason.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapDelReason.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setDelReasonCombo(mapDelReason);
	}
}
