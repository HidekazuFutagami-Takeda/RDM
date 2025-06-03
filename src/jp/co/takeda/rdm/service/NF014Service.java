/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import jp.co.takeda.rdm.dto.HcoJkrData;
import jp.co.takeda.rdm.dto.NF014DTO;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectNF014MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF014)
 *
 * @generated
 */
@Named
public class NF014Service extends BaseService {

	/**
	 * ログインスタンス
	 *
	 * @generated
	 */
	private static Log log = LogFactory.getLog(NF014Service.class);

	// 20150303 ST-B-367対応 HISOL鈴木 ADD START
	/**
	 * 共通処理Serviceオブジェクト 新組織名称(変更前)取得処理
	 */
	@javax.inject.Inject
	private CommonControlService commonControlService;
	// 20150303 ST-B-367対応 HISOL鈴木 ADD END

	/**
	 * イベント処理
	 *
	 * @param indto NF014DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(NF014DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		if ("0".equals(indto.getDisplayKbn())) {
			// 施設固定コードで初期データ作成
			SelectNF014MainDataEntity paramEntity = new SelectNF014MainDataEntity();
			paramEntity.setSqlId("selectNF014INSData");
			paramEntity.setInInsNo(indto.getInsNo());
			List<SelectNF014MainDataEntity> mainDataEntityList = dao.select(paramEntity);
			SelectNF014MainDataEntity mainDataEntity = mainDataEntityList.get(0);

			// 施設
			indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
			indto.setInsFormalName(StringUtils.nvl(mainDataEntity.getInsFormalName(), ""));

			String insPcode = StringUtils.nvl(mainDataEntity.getInsPcode(), "");
    		if(insPcode.length() == 7) {
    			insPcode = insPcode.substring(0,3) + "-"
    								+ insPcode.substring(3);
    		}
			indto.setInsPcode(insPcode);
			indto.setInsAddr(StringUtils.nvl(mainDataEntity.getInsAddr(), ""));
			indto.setDelReason(StringUtils.nvl(mainDataEntity.getDelReason(), ""));
			indto.setPreDelKbn(StringUtils.nvl(mainDataEntity.getPreDelKbn(), ""));
			indto.setDelKbn("");
			indto.setRstReason("");

			indto.setReqShzNm(loginInfo.getBumonRyakuName());
			indto.setReqJgiName(loginInfo.getJgiName());
			indto.setReqJgiNo(loginInfo.getJgiNo());
    		indto.setReqBrCd(loginInfo.getBrCode());
    		indto.setReqDistCd(loginInfo.getDistCode());

			indto.setReqId("");
			indto.setReqYmdhms("");
			indto.setReqStsNm("");

			indto.setUltInsNo(StringUtils.nvl(mainDataEntity.getUltInsNo(), ""));

		} else if ("1".equals(indto.getDisplayKbn())) {
			// 申請データ（一時保存含む）を参照
			SelectNF014MainDataEntity paramEntity = new SelectNF014MainDataEntity();
			paramEntity.setInReqId(indto.getReqId());
			List<SelectNF014MainDataEntity> mainDataEntityList = dao.select(paramEntity);
			SelectNF014MainDataEntity mainDataEntity = mainDataEntityList.get(0);

			// 申請情報
			indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));
			indto.setReqShzNm(StringUtils.nvl(mainDataEntity.getReqShzNm(), ""));
			indto.setReqStsNm(StringUtils.nvl(mainDataEntity.getReqStsNm(), ""));
			indto.setReqJgiName(StringUtils.nvl(mainDataEntity.getReqJgiName(), ""));
			indto.setShnShaName(StringUtils.nvl(mainDataEntity.getShnShaName(), ""));
			indto.setAprShaName(StringUtils.nvl(mainDataEntity.getAprShaName(), ""));

			SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat sdfDateTime2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			if (mainDataEntity.getReqYmdhms() != null && mainDataEntity.getReqYmdhms().length() == 14) {
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

			if (mainDataEntity.getShnYmdhms() != null && mainDataEntity.getShnYmdhms().length() == 14) {
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

			if (mainDataEntity.getAprYmdhms() != null && mainDataEntity.getAprYmdhms().length() == 14) {
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

			// 施設
			indto.setInsNo(StringUtils.nvl(mainDataEntity.getInsNo(), ""));
			indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getInsAbbrName(), ""));
			indto.setInsFormalName(StringUtils.nvl(mainDataEntity.getInsFormalName(), ""));

			String insPcode = StringUtils.nvl(mainDataEntity.getInsPcode(), "");
    		if(insPcode.length() == 7) {
    			insPcode = insPcode.substring(0,3) + "-"
    								+ insPcode.substring(3);
    		}
			indto.setInsPcode(insPcode);
			indto.setInsAddr(StringUtils.nvl(mainDataEntity.getInsAddr(), ""));
			indto.setDelReason(StringUtils.nvl(mainDataEntity.getDelReason(), ""));
			indto.setPreDelKbn(StringUtils.nvl(mainDataEntity.getPreDelKbn(), ""));
			indto.setDelKbn(StringUtils.nvl(mainDataEntity.getDelKbn(), ""));
			indto.setRstReason(StringUtils.nvl(mainDataEntity.getRstReason(), ""));

			indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
			indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));

			indto.setUltInsNo(StringUtils.nvl(mainDataEntity.getUltInsNo(), ""));
		}

		// DropDownList作成
		createCombo(indto);

		// 編集可能判定
		if ("".equals(indto.getReqStsCd()) || indto.getReqStsCd() == null) {
			// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
			indto.setEditApprFlg("1");
		} else if (!RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd()) && !"01".equals(indto.getReqStsCd())) {
			// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
			indto.setEditApprFlg("0");
		} else if (RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd()) && !"01".equals(indto.getReqStsCd()) && !"11".equals(indto.getReqStsCd())
				&& !"03".equals(indto.getReqStsCd()) && !"13".equals(indto.getReqStsCd())) {
			// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'11'、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
			indto.setEditApprFlg("0");
		} else {
			indto.setEditApprFlg("1");
		}

		// END UOC
		return outdto;
	}

	/**
	 * コンボ作成
	 *
	 * @param indto NF014DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(NF014DTO indto) {
		// 削除区分
    	SelectComboListEntity inEntityCmb = new SelectComboListEntity();
    	inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DEL_KBN);
        List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
        LinkedHashMap<String, String> mapDelKbn = new LinkedHashMap<String, String>();
        mapDelKbn.put("", "--選択してください--");
        for (SelectComboListEntity outEntity : outMainList) {
        	if(!"3".equals(outEntity.getValue())) {
        		mapDelKbn.put(outEntity.getValue(), outEntity.getValue()+":"+outEntity.getValueKanji());
        	}
        }
        indto.setDelKbnCombo(mapDelKbn);

		// 復活理由
		inEntityCmb = new SelectComboListEntity();
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HCO_RST_REASON);
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapRstReason = new LinkedHashMap<String, String>();
		mapRstReason.put("", "--選択してください--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapRstReason.put(outEntity.getValue(), outEntity.getValueKanji());
		}
		indto.setRstReasonCombo(mapRstReason);
	}

	/**
	 *
	 * @param indto
	 * @return
	 */
	@Transactional
	public BaseDTO cancel(NF014DTO indto) {
		BaseDTO outdto = indto;
		// DropDownList作成
		createCombo(indto);

		// START UOC
		// 申請管理を物理削除
		TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
		tRdmReqKnrEntity.setReqId(indto.getReqId());
		dao.deleteByPK(tRdmReqKnrEntity);

		// 施設_申請管理を物理削除
		TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
		tRdmHcoReqEntity.setReqId(indto.getReqId());
		dao.deleteByPK(tRdmHcoReqEntity);

		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param indto NF014DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(NF014DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
		// DropDownList作成
		createCombo(indto);
		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = fmtDate.format(systemDate);
		SimpleDateFormat fmtDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String sysDateTime = fmtDateTime.format(systemDate);

		String reqId = indto.getReqId();
		boolean errFlg = false;
		String errMsg = "";

		// レングスチェック
		if (indto.getReqComment() != null && StringUtils.getByteLength(indto.getReqComment()) > 300) {
			// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
		}

		if (indto.getAprMemo() != null && StringUtils.getByteLength(indto.getAprMemo()) > 300) {
			// 最大文字数を超えています。（審査・承認メモ）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "審査・承認メモ") + "\n";
			errFlg = true;
		}

		// エラー時処理
		if (errFlg) {
			indto.setMsgStr(errMsg);
			return outdto;
		}

		// 申請ステータスを「01：保存済」として各テーブルに画面の申請情報を登録
		// 申請管理
		TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity();
		tRdmReqKnrEntity.setReqId(indto.getReqId());
		TRdmReqKnrEntity tRdmReqKnrData = dao.selectByPK(tRdmReqKnrEntity);

		if (tRdmReqKnrData == null) {
			// 新規登録
			// 新規にIDを取得
			SeqRdmReqIdEntity seqRdmReqIdEntity = new SeqRdmReqIdEntity();
			List<SeqRdmReqIdEntity> seqRdmReqIdDate = dao.select(seqRdmReqIdEntity);
			reqId = seqRdmReqIdDate.get(0).getReqId();

			// レコードを登録
			TRdmReqKnrEntity tRdmReqKnrInsData = new TRdmReqKnrEntity();
			tRdmReqKnrInsData.setReqId(reqId);
			if (RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd())) {
				// 承認者（管理者権限）が申請の場合、'2'(DSG起因)
				tRdmReqKnrInsData.setReqChl("2");
				tRdmReqKnrInsData.setReqKngKbn("2");
			} else {
				// "MRが申請の場合、'1'(MR起因)
				tRdmReqKnrInsData.setReqChl("1");
				tRdmReqKnrInsData.setReqKngKbn("1");
			}
			tRdmReqKnrInsData.setReqType("04");
			tRdmReqKnrInsData.setReqStsCd("01");
			indto.setReqStsCd("01");
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
			if(StringUtils.isEmpty(indto.getUltInsNo())) {
        		tRdmReqKnrInsData.setFbReqFlg("0");	//FB申請要否フラグ
        	} else {
        		tRdmReqKnrInsData.setFbReqFlg("1");	//FB申請要否フラグ
        	}

			dao.insertByValue(tRdmReqKnrInsData);

		} else {
			// 更新
			TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF013Data");
			tRdmReqKnrUpdData.setReqId(reqId);
			if("11".equals(indto.getReqStsCd())) {
				tRdmReqKnrUpdData.setReqStsCd("11");
			} else if("03".equals(indto.getReqStsCd()) || "13".equals(indto.getReqStsCd())) {
				tRdmReqKnrUpdData.setReqStsCd(indto.getReqStsCd());
			} else {
				tRdmReqKnrUpdData.setReqStsCd("01");
			}
			tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
			tRdmReqKnrUpdData.setReqYmdhms(sysDateTime);
			tRdmReqKnrUpdData.setAprMemo(indto.getAprMemo());
			tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
			tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());
			if(StringUtils.isEmpty(indto.getUltInsNo())) {
				tRdmReqKnrUpdData.setFbReqFlg("0");	//FB申請要否フラグ
        	} else {
        		tRdmReqKnrUpdData.setFbReqFlg("1");	//FB申請要否フラグ
        	}

			dao.update(tRdmReqKnrUpdData);
		}

		// 施設_申請管理
		TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
		tRdmHcoReqEntity.setReqId(reqId);
		TRdmHcoReqEntity tRdmHcoReqData = dao.selectByPK(tRdmHcoReqEntity);

		if (tRdmHcoReqData == null) {
			// 新規登録
			TRdmHcoReqEntity tRdmHcoReqInsData = new TRdmHcoReqEntity();
			tRdmHcoReqInsData.setReqId(reqId);
			tRdmHcoReqInsData.setInsNo(indto.getInsNo());

			// 施設名
			String insAbbrName = indto.getInsAbbrName();
			String insFormalName = indto.getInsFormalName();
			if("1".equals(indto.getPreDelKbn())) {
				// 廃院/閉院予定→通常の場合'○'を除去
				if(insAbbrName != null && insAbbrName.length() > 0 && "○".equals(insAbbrName.substring(0,1))) {
					insAbbrName = insAbbrName.substring(1);
				}
				if(insFormalName != null && insFormalName.length() > 0 && "○".equals(insFormalName.substring(0,1))) {
					insFormalName = insFormalName.substring(1);
				}
			} else if("2".equals(indto.getPreDelKbn()) && "0".equals(indto.getDelKbn())) {
				// 廃院/閉院済み→通常の場合'●'を除去
				if(insAbbrName != null && insAbbrName.length() > 0 && "●".equals(insAbbrName.substring(0,1))) {
					insAbbrName = insAbbrName.substring(1);
				}
				if(insFormalName != null && insFormalName.length() > 0 && "●".equals(insFormalName.substring(0,1))) {
					insFormalName = insFormalName.substring(1);
				}
			} else if("2".equals(indto.getPreDelKbn()) && "1".equals(indto.getDelKbn())) {
				// 廃院/閉院済み→廃院/閉院予定の場合'●'を除去、'○'を付与
				if(insAbbrName != null && insAbbrName.length() > 0 && "●".equals(insAbbrName.substring(0,1))) {
					insAbbrName = insAbbrName.substring(1);
				}
				insAbbrName = "○" + insAbbrName;
				if(insFormalName != null && insFormalName.length() > 0 && "●".equals(insFormalName.substring(0,1))) {
					insFormalName = insFormalName.substring(1);
				}
				insFormalName = "○" + insFormalName;
			}
			tRdmHcoReqInsData.setInsAbbrName(insAbbrName);
			tRdmHcoReqInsData.setInsFormalName(insFormalName);

			tRdmHcoReqInsData.setRstReason(indto.getRstReason());

			if(!StringUtils.isEmpty(indto.getDelKbn())) {
				tRdmHcoReqInsData.setDelKbn(Integer.parseInt(indto.getDelKbn()));
			}

			tRdmHcoReqInsData.setInsShaYmd(systemDate);
			tRdmHcoReqInsData.setInsShaId(indto.getLoginJgiNo());
			tRdmHcoReqInsData.setUpdShaYmd(systemDate);
			tRdmHcoReqInsData.setUpdShaId(indto.getLoginJgiNo());

			dao.insertByValue(tRdmHcoReqInsData);

		} else {
			// 更新
			TRdmHcoReqEntity tRdmHcoReqUpdData = new TRdmHcoReqEntity("updateNF014Data");
			tRdmHcoReqUpdData.setReqId(reqId);

			// 施設名
			String insAbbrName = indto.getInsAbbrName();
			String insFormalName = indto.getInsFormalName();
			if("1".equals(indto.getPreDelKbn())) {
				// 廃院/閉院予定→通常の場合'○'を除去
				if(insAbbrName != null && insAbbrName.length() > 0 && "○".equals(insAbbrName.substring(0,1))) {
					insAbbrName = insAbbrName.substring(1);
				}
				if(insFormalName != null && insFormalName.length() > 0 && "○".equals(insFormalName.substring(0,1))) {
					insFormalName = insFormalName.substring(1);
				}
			} else if("2".equals(indto.getPreDelKbn()) && "0".equals(indto.getDelKbn())) {
				// 廃院/閉院済み→通常の場合'●'を除去
				if(insAbbrName != null && insAbbrName.length() > 0 && "●".equals(insAbbrName.substring(0,1))) {
					insAbbrName = insAbbrName.substring(1);
				}
				if(insFormalName != null && insFormalName.length() > 0 && "●".equals(insFormalName.substring(0,1))) {
					insFormalName = insFormalName.substring(1);
				}
			} else if("2".equals(indto.getPreDelKbn()) && "1".equals(indto.getDelKbn())) {
				// 廃院/閉院済み→廃院/閉院予定の場合'●'を除去、'○'を付与
				if(insAbbrName != null && insAbbrName.length() > 0 && "●".equals(insAbbrName.substring(0,1))) {
					insAbbrName = insAbbrName.substring(1);
				}
				insAbbrName = "○" + insAbbrName;
				if(insFormalName != null && insFormalName.length() > 0 && "●".equals(insFormalName.substring(0,1))) {
					insFormalName = insFormalName.substring(1);
				}
				insFormalName = "○" + insFormalName;
			}
			tRdmHcoReqUpdData.setInsAbbrName(insAbbrName);
			tRdmHcoReqUpdData.setInsFormalName(insFormalName);

			tRdmHcoReqUpdData.setRstReason(indto.getRstReason());

			if(!StringUtils.isEmpty(indto.getDelKbn())) {
				tRdmHcoReqUpdData.setDelKbn(Integer.parseInt(indto.getDelKbn()));
			}

			tRdmHcoReqUpdData.setUpdShaYmd(systemDate);
			tRdmHcoReqUpdData.setUpdShaId(indto.getLoginJgiNo());

			dao.update(tRdmHcoReqUpdData);
		}

		indto.setReqId(reqId);
		indto.setDisplayKbn("1");

		outdto = init(indto);

		// エラーメッセージ表示エリアに（I005）「保存が完了しました。」完了メッセージを表示
		String infoMsg = loginInfo.getMsgData(RdmConstantsData.I005) + "\n";
		indto.setMsgStr(infoMsg);

		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param indto NF014DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO shnComp(NF014DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
		// DropDownList作成
		createCombo(indto);
		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		String sysDate = fmtDate.format(systemDate);

		// 申請管理の更新を行う
		TRdmReqKnrEntity tRdmReqKnrEntity = new TRdmReqKnrEntity("updateTRdmReqKnrData");
		tRdmReqKnrEntity.setReqId(indto.getReqId());
		tRdmReqKnrEntity.setShnFlg("1");
		tRdmReqKnrEntity.setShnBrCode(indto.getLoginBrCd());
		tRdmReqKnrEntity.setShnDistCode(indto.getLoginDistCd());
		tRdmReqKnrEntity.setShnShz(indto.getLoginShzNm());
		tRdmReqKnrEntity.setShnJgiNo(Integer.parseInt(indto.getLoginJgiNo()));
		tRdmReqKnrEntity.setShnShaName(indto.getLoginNm());
		tRdmReqKnrEntity.setAprMemo(indto.getAprMemo());
		tRdmReqKnrEntity.setShnYmdhms(sysDate);

		dao.update(tRdmReqKnrEntity);

		indto.setShnFlg("1");

		outdto = init(indto);

		// エラーメッセージ表示エリアに（I008）「ステータスを審査済みに変更しました。」完了メッセージを表示
		String infoMsg = loginInfo.getMsgData(RdmConstantsData.I008) + "\n";
		indto.setMsgStr(infoMsg);

		// END UOC
		return outdto;
	}
}