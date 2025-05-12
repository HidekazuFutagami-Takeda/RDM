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
import jp.co.takeda.rdm.dto.ND105DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpPublicDataEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpSocietyDataEntity;
import jp.co.takeda.rdm.entity.join.SelectND105MainDataEntity;
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
 * Serviceクラス（ND105)
 * @generated
 */
@Named
public class ND105Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(ND105Service.class);

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
	 * @param indto ND105DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND105DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		if ("1".equals(indto.getDisplayKbn())) {
			if (indto.getTkdDocNo() != null) {
				// 医師コードで初期データ作成
				SelectND105MainDataEntity paramEntity = new SelectND105MainDataEntity();
				paramEntity.setSqlId("selectND105TKDData");
				paramEntity.setInDocNo(indto.getTkdDocNo());
				List<SelectND105MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectND105MainDataEntity mainDataEntity = mainDataEntityList.get(0);
				indto.setTkdDocNo(StringUtils.nvl(mainDataEntity.getTkdDocNo(), ""));
				indto.setTkdDocNm(StringUtils.nvl(mainDataEntity.getTkdDocNm(), ""));
				indto.setTkdDocKana(StringUtils.nvl(mainDataEntity.getTkdDocKana(), ""));

				indto.setDocKanjiSei(StringUtils.nvl(mainDataEntity.getDocKanjiSei(), ""));
				indto.setDocKanjiMei(StringUtils.nvl(mainDataEntity.getDocKanjiMei(), ""));
				indto.setDocAttribute(StringUtils.nvl(mainDataEntity.getDocAttribute(), ""));
				indto.setDocAttributeNm(StringUtils.nvl(mainDataEntity.getDocAttributeNm(), ""));

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
				SelectND105MainDataEntity paramEntity = new SelectND105MainDataEntity();
				paramEntity.setInReqId(indto.getReqId());
				List<SelectND105MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectND105MainDataEntity mainDataEntity = mainDataEntityList.get(0);
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
				indto.setDocAttribute(StringUtils.nvl(mainDataEntity.getDocAttribute(), ""));
				indto.setDocAttributeNm(StringUtils.nvl(mainDataEntity.getDocAttributeNm(), ""));
				indto.setDelReason(StringUtils.nvl(mainDataEntity.getDelReason(), ""));
				indto.setDupDocNo(StringUtils.nvl(mainDataEntity.getDupDocNo(), ""));
				indto.setDupDocNm(StringUtils.nvl(mainDataEntity.getDupDocNm(), ""));
				indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));
				indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
				indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
				indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
				indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));

			} else {
			}
		} else if ("0".equals(indto.getDisplayKbn())) {
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
	 * @param indto ND105DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(ND105DTO indto){
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
	/**
	 * イベント処理
	 * @param indto ND105DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(ND105DTO indto) {
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
				SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
		        String sysDateTime = fmtDateTime.format(currentDt);

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
				updateEntity1.setReqYmdhms(sysDateTime);//申請日時
				updateEntity1.setAprMemo(indto.getAprMemo());//承認者メモ
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
				updateEntity2.setDelReason(indto.getDelReason());//削除理由
				updateEntity2.setDupDocNo(StringUtils.setEmptyToNull(indto.getDupDocNo()));//重複医師コード
				if(!indto.getDocKanjiMei().endsWith("●")) {
					updateEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei() + "●");//氏名（漢字）
					updateEntity2.setDocKanjiMei(indto.getDocKanjiMei() + "●");//氏名（漢字）名
				}

				updateEntity2.setUpdShaYmd(currentDt);//更新日
				updateEntity2.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				updateEntity2.checkSetNull();
				dao.update(updateEntity2);

				indto.setUpdShaYmd(strDate);

				SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				if (sysDateTime != null ) {
					try {
						Date reqYmd = sdfDateTime.parse(sysDateTime);
						String strReqYmd = sdfDateTime2.format(reqYmd);
						indto.setReqYmdhms(strReqYmd);
					} catch (ParseException e) {
						e.printStackTrace();
						indto.setReqYmdhms(StringUtils.nvl(sysDateTime, ""));
					}
				} else {
					indto.setReqYmdhms(StringUtils.nvl(sysDateTime, ""));
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
				insEntity1.setReqType("33");//申請区分
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

				SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
		        String sysDateTime = fmtDateTime.format(currentDt);

				insEntity1.setReqYmdhms(sysDateTime);//申請日時

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
				indto.setReqStsCd("01");
				indto.setReqStsNm("保存済み");

				SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				if (sysDateTime != null ) {
					try {
						Date reqYmd = sdfDateTime.parse(sysDateTime);
						String strReqYmd = sdfDateTime2.format(reqYmd);
						indto.setReqYmdhms(strReqYmd);
					} catch (ParseException e) {
						e.printStackTrace();
						indto.setReqYmdhms(StringUtils.nvl(sysDateTime, ""));
					}
				} else {
					indto.setReqYmdhms(StringUtils.nvl(sysDateTime, ""));
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
			//TODO 物理削除
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
	private boolean checkInput(LoginInfo loginInfo, ND105DTO indto, boolean fullchkFlg) {
		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";
		if(fullchkFlg) {
			//	１：必須入力チェック
			//	項目
			//	削除理由
			if(StringUtils.isEmpty(indto.getDelReason())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "削除理由");
				msgStr = msgStr + tmpMsgStr + "\n";
			} else {
				//	申請コメント
				// 削除理由が「その他（削除理由コメント・必須）」の場合、必須項目に値が入力されているか確認
				if(indto.getDelReason().equals("04") && StringUtils.isEmpty(indto.getReqComment())) {
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
					msgStr = msgStr + tmpMsgStr + "\n";
				}
				//	重複医師コード
				// 削除理由が「医師の重複登録」の場合、必須項目に値が入力されているか確認
				if(indto.getDelReason().equals("02") && StringUtils.isEmpty(indto.getDupDocNo())) {
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "重複医師コード");
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
			SelectND105MainDataEntity paramChkEntity = new SelectND105MainDataEntity();
			paramChkEntity.setSqlId("selectND105CheckDelData");
			paramChkEntity.setInDocNo(indto.getTkdDocNo());
			paramChkEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
			List<SelectND105MainDataEntity> chkEntityList1 = dao.select(paramChkEntity);
			if(chkEntityList1.size() > 0) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008);//重複する申請が行われています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師固定C");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
//TODO
			// 整合性チェック 削除理由が「医師免許返納・死亡」以外で、所属施設が2つの以上の場合    W033    勤務先が2件以上存在するため申請できません。
			if(!StringUtils.isEmpty(indto.getDelReason())) {
				if(!indto.getDelReason().equals("01") && !indto.getDelReason().equals("03")) {
					paramChkEntity.setSqlId("selectND105CheckKinmuData");
					paramChkEntity.setInDocNo(indto.getTkdDocNo());
					List<SelectND105MainDataEntity> chkEntityList2 = dao.select(paramChkEntity);
					if(chkEntityList2.size() > 1){
						errChk = true;
						tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W056);//勤務先が2件以上存在するため申請できません。
						msgStr = msgStr + tmpMsgStr + "\n";
					}
				}
			}
			// 整合性チェック MR権限で医師の所属施設がダミー施設の場合    W034     医療機関外へ異動されている医師は削除できません。
			if(RdmConstantsData.RDM_JKN_MR.equals(loginInfo.getJokenSetCd())){
				paramChkEntity.setSqlId("selectND105CheckKinmuDummyData");
				paramChkEntity.setInDocNo(indto.getTkdDocNo());
				List<SelectND105MainDataEntity> chkEntityList3 = dao.select(paramChkEntity);
				if(chkEntityList3.size() > 0){
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W057);// 医療機関外へ異動されている医師は削除できません。
					msgStr = msgStr + tmpMsgStr + "\n";
				}

			}
			// 適用日チェック 勤務先変更の申請（承認済みで適用日が未来日）が1件以上存在する場合    W035    医師は異動が予定されています。
			paramChkEntity.setSqlId("selectND105CheckKinmuChangeData");
			paramChkEntity.setInDocNo(indto.getTkdDocNo());
			List<SelectND105MainDataEntity> chkEntityList4 = dao.select(paramChkEntity);
			if(chkEntityList4.size() > 0){
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W058);//  医師は異動が予定されています。
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

}
