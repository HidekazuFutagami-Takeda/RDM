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
import java.util.HashSet;
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
import jp.co.takeda.rdm.dto.NF011DTO;
import jp.co.takeda.rdm.entity.join.MRdmCodeMstEntity;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcoJkrWkEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHcoJkrDataEntity;
import jp.co.takeda.rdm.entity.join.SelectNF011MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectRdmComTrtgrpDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcoReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmMMdbHcoMstEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

/**
 * Serviceクラス（NF011)
 *
 * @generated
 */
@Named
public class NF011Service extends BaseService {

	/**
	 * ログインスタンス
	 *
	 * @generated
	 */
	private static Log log = LogFactory.getLog(NF011Service.class);

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
	 * @param indto NF011DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(NF011DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
		List<HcoJkrData> hcoJkrDataList = new ArrayList<HcoJkrData>();
		List<HcoJkrData> beforeHcoJkrDataList = new ArrayList<HcoJkrData>();

		if ("1".equals(indto.getDisplayKbn())) {
			if (indto.getUltInsCd() != null && indto.getUltInsCd() != "") {
				// ULT施設コードで初期データ作成
				SelectNF011MainDataEntity paramEntity = new SelectNF011MainDataEntity();
				paramEntity.setSqlId("selectNF011ULTData");
				paramEntity.setInUltInsNo(indto.getUltInsCd());
				List<SelectNF011MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectNF011MainDataEntity mainDataEntity = mainDataEntityList.get(0);

				// 施設名
				indto.setUltInsNm(StringUtils.nvl(mainDataEntity.getShisetsuNm(), ""));
				indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getShisetsuNmRyaku(), ""));
				indto.setInsKana(StringUtils.nvl(mainDataEntity.getShisetsuNmKana(), ""));
				indto.setInsFormalName(StringUtils.nvl(mainDataEntity.getShisetsuNm(), ""));
				indto.setInsContName(StringUtils.nvl(mainDataEntity.getShisetsuNm(), ""));

				// 開業年月
				if (StringUtils.nvl(mainDataEntity.getKaigyoYm(), "").length() > 5) {
					indto.setInsOpenYear(StringUtils.nvl(mainDataEntity.getKaigyoYm(), "").substring(0, 2));
					indto.setInsOpenMonth(StringUtils.nvl(mainDataEntity.getKaigyoYm(), "").substring(2));
				}

				// 住所
				if(mainDataEntity.getYubinNo() != null && mainDataEntity.getYubinNo().length() == 7) {
					String yubinNo = mainDataEntity.getYubinNo().substring(0,3) + "-"
										+ mainDataEntity.getYubinNo().substring(3);
					indto.setInsPcode(yubinNo);
				} else {
					indto.setInsPcode(StringUtils.nvl(mainDataEntity.getYubinNo(), ""));
				}

				indto.setAddrCodePref(StringUtils.nvl(mainDataEntity.getTodofukenCd(), ""));
				indto.setAddrCodePrefName(StringUtils.nvl(mainDataEntity.getTodofukenNm(), ""));
				indto.setAddrCodeCity(StringUtils.nvl(mainDataEntity.getShikuchosonCd(), ""));
				indto.setAddrCodeCityName(StringUtils.nvl(mainDataEntity.getShikuchosonNm(), ""));
				indto.setTkCityCd(StringUtils.nvl(mainDataEntity.getTkCityCd(), ""));
				indto.setTkCityName(StringUtils.nvl(mainDataEntity.getTkCityNm(), ""));
				indto.setInsPhone1(StringUtils.nvl(mainDataEntity.getShisetsuTel(), ""));

				if(!StringUtils.isEmpty(mainDataEntity.getAddress())) {
					indto.setInsAddrDt(mainDataEntity.getAddress().replace(StringUtils.nvl(mainDataEntity.getTodofukenNm(), ""), "").replace(StringUtils.nvl(mainDataEntity.getShikuchosonNm(), ""),""));
				}

				// 経営主体
				indto.setManageCd(StringUtils.nvl(mainDataEntity.getManageCd(), ""));

				// 病床数
				indto.setBedCntBase(StringUtils.nvl(mainDataEntity.getKyokabyoshosuSum(), ""));
				indto.setBedCnt01(StringUtils.nvl(mainDataEntity.getKyokabyoshosuIppan(), ""));
				indto.setBedCnt03(StringUtils.nvl(mainDataEntity.getKyokabyoshosuSeishin(), ""));
				indto.setBedCnt04(StringUtils.nvl(mainDataEntity.getKyokabyoshosuKekkaku(), ""));
				indto.setBedCnt05(StringUtils.nvl(mainDataEntity.getKyokabyoshosuKansen(), ""));
				indto.setBedCnt07(StringUtils.nvl(mainDataEntity.getKyokabyoshosuRyoyo(), ""));

				int bedsTot = Integer.parseInt(StringUtils.nvl(mainDataEntity.getKyokabyoshosuIppan(), "0"))
						+ Integer.parseInt(StringUtils.nvl(mainDataEntity.getKyokabyoshosuSeishin(), "0"))
						+ Integer.parseInt(StringUtils.nvl(mainDataEntity.getKyokabyoshosuKansen(), "0"))
						+ Integer.parseInt(StringUtils.nvl(mainDataEntity.getKyokabyoshosuRyoyo(), "0"));
				indto.setBedsTot(Integer.toString(bedsTot));
				indto.setMedBedsTot(Integer.toString(bedsTot));

        		indto.setReqShzNm(loginInfo.getBumonRyakuName());
				indto.setReqJgiName(loginInfo.getJgiName());
				indto.setReqJgiNo(loginInfo.getJgiNo());
        		indto.setReqBrCd(loginInfo.getBrCode());
        		indto.setReqDistCd(loginInfo.getDistCode());

				indto.setReqId("");
				indto.setReqYmdhms("");
				indto.setReqStsNm("");
			} else {
				// 完全新規 ログイン情報から申請者セット
				indto.setReqShzNm(loginInfo.getBumonRyakuName());
				indto.setReqJgiName(loginInfo.getJgiName());
				indto.setReqJgiNo(loginInfo.getJgiNo());
        		indto.setReqBrCd(loginInfo.getBrCode());
        		indto.setReqDistCd(loginInfo.getDistCode());

				indto.setReqId("");
				indto.setUltInsCd("");
				indto.setUltInsNm("");
				indto.setReqYmdhms("");
				indto.setReqStsNm("");
			}
		} else if ("2".equals(indto.getDisplayKbn())) {
			if (indto.getReqId() != null) {
				// 申請データ（一時保存含む）を参照
				SelectNF011MainDataEntity paramEntity = new SelectNF011MainDataEntity();
				paramEntity.setInReqId(indto.getReqId());
				List<SelectNF011MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectNF011MainDataEntity mainDataEntity = mainDataEntityList.get(0);

				// 申請情報
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

				indto.setReqChl(mainDataEntity.getReqChl());
				indto.setReqJgiNo(mainDataEntity.getReqJgiNo());
				indto.setReqBrCd(StringUtils.nvl(mainDataEntity.getReqBrCd(), ""));
				indto.setReqDistCd(StringUtils.nvl(mainDataEntity.getReqDistCd(), ""));
				indto.setReqStsCd(StringUtils.nvl(mainDataEntity.getReqStsCd(), ""));
				indto.setShnJgiNo(mainDataEntity.getShnJgiNo());
				indto.setAprJgiNo(mainDataEntity.getAprJgiNo());
				indto.setUpdShaYmd(StringUtils.nvl(mainDataEntity.getUpdShaYmd(), ""));

				// 基本情報
				indto.setUltInsCd(StringUtils.nvl(mainDataEntity.getDcfShisetsuCd(), ""));
				indto.setUltInsNm(StringUtils.nvl(mainDataEntity.getShisetsuNm(), ""));
				indto.setInsType(StringUtils.nvl(mainDataEntity.getInsType(), ""));
				indto.setMainInsCd(StringUtils.nvl(mainDataEntity.getMainInsCd(), ""));
				indto.setMainInsNm(StringUtils.nvl(mainDataEntity.getMainInsNm(), ""));
				indto.setInsAbbrName(StringUtils.nvl(mainDataEntity.getShisetsuNmRyaku(), ""));
				indto.setInsKana(StringUtils.nvl(mainDataEntity.getShisetsuNmKana(), ""));
				indto.setInsFormalName(StringUtils.nvl(mainDataEntity.getInsFormalName(), ""));
				indto.setInsContName(StringUtils.nvl(mainDataEntity.getInsContName(), ""));
				indto.setTradeType(StringUtils.nvl(mainDataEntity.getTradeType(), ""));
				indto.setInsOpenYear(StringUtils.nvl(mainDataEntity.getInsOpenYear(), ""));
				indto.setInsOpenMonth(StringUtils.nvl(mainDataEntity.getInsOpenMonth(), ""));
				indto.setInsOpenDay(StringUtils.nvl(mainDataEntity.getInsOpenDay(), ""));

				// 住所詳細
				if(mainDataEntity.getYubinNo() != null && mainDataEntity.getYubinNo().length() == 7) {
					String yubinNo = mainDataEntity.getYubinNo().substring(0,3) + "-"
										+ mainDataEntity.getYubinNo().substring(3);
					indto.setInsPcode(yubinNo);
				} else {
					indto.setInsPcode(StringUtils.nvl(mainDataEntity.getYubinNo(), ""));
				}

				indto.setAddrCodePref(StringUtils.nvl(mainDataEntity.getTodofukenCd(), ""));
				indto.setAddrCodePrefName(StringUtils.nvl(mainDataEntity.getTodofukenNm(), ""));
				indto.setAddrCodeCity(StringUtils.nvl(mainDataEntity.getShikuchosonCd(), ""));
				indto.setAddrCodeCityName(StringUtils.nvl(mainDataEntity.getShikuchosonNm(), ""));
				indto.setInsAddrDt(StringUtils.nvl(mainDataEntity.getInsAddrDt(), ""));
				indto.setTkCityCd(StringUtils.nvl(mainDataEntity.getTkCityCd(), ""));
				indto.setTkCityName(StringUtils.nvl(mainDataEntity.getTkCityNm(), ""));
				indto.setInsPhone1(StringUtils.nvl(mainDataEntity.getInsPhone1(), ""));
				indto.setInsPhone2(StringUtils.nvl(mainDataEntity.getInsPhone2(), ""));
				indto.setInsFax1(StringUtils.nvl(mainDataEntity.getInsFax1(), ""));
				indto.setInsFax2(StringUtils.nvl(mainDataEntity.getInsFax2(), ""));
				indto.setInsUrl(StringUtils.nvl(mainDataEntity.getInsUrl(), ""));

				// ホームページアドレス更新日を"yyyy-MM-dd"に変換
				if (!"".equals(StringUtils.nvl(mainDataEntity.getInsUrlYmd(), ""))) {
					StringBuilder sbUrlYmd = new StringBuilder();
					sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(0, 4));
					sbUrlYmd.append("-");
					sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(4, 6));
					sbUrlYmd.append("-");
					sbUrlYmd.append(mainDataEntity.getInsUrlYmd().substring(6, 8));
					indto.setInsUrlYmd(sbUrlYmd.toString());
				}

				indto.setInsAddrKana(StringUtils.nvl(mainDataEntity.getAddressKana(), ""));

				// 区分情報
				indto.setPharmType(StringUtils.nvl(mainDataEntity.getPharmType(), ""));
				indto.setInsRank(StringUtils.nvl(mainDataEntity.getInsRank(), ""));
				indto.setRegVisType(StringUtils.nvl(mainDataEntity.getRegVisType(), ""));
				indto.setImpHosType(StringUtils.nvl(mainDataEntity.getImpHosType(), ""));
				indto.setUnivSubdiv(StringUtils.nvl(mainDataEntity.getUnivSubdiv(), ""));
				indto.setHoInsType(StringUtils.nvl(mainDataEntity.getHoInsType(), ""));

				// 経営主体
				indto.setManageCd(StringUtils.nvl(mainDataEntity.getManageCd(), ""));

				// 病床数
				indto.setBedCntBase(StringUtils.nvl(mainDataEntity.getBedCntBase(), ""));
				indto.setBedCnt01(StringUtils.nvl(mainDataEntity.getKyokabyoshosuIppan(), ""));
				indto.setBedCnt02(StringUtils.nvl(mainDataEntity.getBedCnt02(), ""));
				indto.setBedCnt03(StringUtils.nvl(mainDataEntity.getKyokabyoshosuSeishin(), ""));
				indto.setBedCnt04(StringUtils.nvl(mainDataEntity.getKyokabyoshosuKekkaku(), ""));
				indto.setBedCnt05(StringUtils.nvl(mainDataEntity.getKyokabyoshosuKansen(), ""));
				indto.setBedCnt06(StringUtils.nvl(mainDataEntity.getBedCnt06(), ""));
				indto.setBedCnt07(StringUtils.nvl(mainDataEntity.getKyokabyoshosuRyoyo(), ""));
				indto.setBedsTot(StringUtils.nvl(mainDataEntity.getKyokabyoshosuSum(), ""));
				indto.setMedBedsTot(StringUtils.nvl(mainDataEntity.getMedBedsTot(), ""));
				indto.setEntcapaNum(StringUtils.nvl(mainDataEntity.getEntcapaNum(), ""));

				// ワクチン情報
				indto.setVacInsType(StringUtils.nvl(mainDataEntity.getVacInsType(), ""));
				indto.setVacVisitType(StringUtils.nvl(mainDataEntity.getVacVisitType(), ""));
				indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
				indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
				indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));

				// 領域担当者リスト
				SelectHcoJkrDataEntity jkrParamEntity = new SelectHcoJkrDataEntity();
				jkrParamEntity.setInReqId(indto.getReqId());
				List<SelectHcoJkrDataEntity> jkrDataEntityList = dao.select(jkrParamEntity);
				for (SelectHcoJkrDataEntity sEntity : jkrDataEntityList) {
					if (sEntity != null) {
						HcoJkrData sData = new HcoJkrData();
						HcoJkrData sbData = new HcoJkrData();
						setHcoJkrData(sEntity, sData);
						setHcoJkrData(sEntity, sbData);
						hcoJkrDataList.add(sData);
						beforeHcoJkrDataList.add(sbData);
					}
				}
				indto.setHcoJkrDataList(hcoJkrDataList);
				indto.setBeforeHcoJkrDataList(beforeHcoJkrDataList);

			} else {
				// 完全新規
				indto.setReqShzNm(loginInfo.getBumonRyakuName());
				indto.setReqJgiName(loginInfo.getJgiName());
				indto.setReqJgiNo(loginInfo.getJgiNo());
        		indto.setReqBrCd(loginInfo.getBrCode());
        		indto.setReqDistCd(loginInfo.getDistCode());

        		indto.setBedsTot("0");
				indto.setMedBedsTot("0");

				indto.setUltInsCd("");
				indto.setUltInsNm("");
				indto.setReqYmdhms("");
				indto.setReqStsNm("");
			}
		} else if ("0".equals(indto.getDisplayKbn())) {
			// 完全新規
			indto.setReqShzNm(loginInfo.getBumonRyakuName());
			indto.setReqJgiName(loginInfo.getJgiName());
			indto.setReqJgiNo(loginInfo.getJgiNo());
    		indto.setReqBrCd(loginInfo.getBrCode());
    		indto.setReqDistCd(loginInfo.getDistCode());

    		indto.setBedsTot("0");
			indto.setMedBedsTot("0");

			indto.setReqId("");
			indto.setUltInsCd("");
			indto.setUltInsNm("");
			indto.setReqYmdhms("");
			indto.setReqStsNm("");

		}
		indto.setHcoJkrDataChgFlg("0");
		// DropDownList作成
		createCombo(indto);

		// 編集可能判定
		if ("".equals(indto.getReqStsCd()) || indto.getReqStsCd() == null) {
			// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
			indto.setEditApprFlg("1");
		} else if (!RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd()) && !"01".equals(indto.getReqStsCd())) {
			// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
			indto.setEditApprFlg("0");
		} else if (RdmConstantsData.RDM_JKN_ADMIN.equals(indto.getLoginJokenSetCd()) && !"01".equals(indto.getReqStsCd())
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
	 * 領域担当者リストセット
	 *
	 * @param sEntity
	 * @param sData
	 */
	private void setHcoJkrData(SelectHcoJkrDataEntity sEntity, HcoJkrData sData) {

		sData.setTrtCd(StringUtils.nvl(sEntity.getTrtCd(), ""));
		sData.setTrtNm(StringUtils.nvl(sEntity.getTrtNm(), ""));
		sData.setJgiNo(StringUtils.nvl(sEntity.getJgiNo(), ""));
		sData.setJgiNm(StringUtils.nvl(sEntity.getJgiNm(), ""));
		sData.setTrtGrpCd(StringUtils.nvl(sEntity.getTrtGrpCd(), ""));
		sData.setMrCat(StringUtils.nvl(sEntity.getMrCat(), ""));
		sData.setAddFlg("0");
		sData.setDeleteFlg("0");
	}

	/**
	 * コンボ作成
	 *
	 * @param indto NF011DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(NF011DTO indto) {
		// 1-2-1 施設種別
		// コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		// コード名＝INS_TYPE（施設種別）
		// 削除フラグ=0
		SelectComboListEntity inEntityCmb = new SelectComboListEntity();
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_INS_TYPE);
		List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapInsType = new LinkedHashMap<String, String>();
		mapInsType.put("", "--選択してください--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapInsType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setInsTypeCombo(mapInsType);

		// 1-2-2 取引区分
		// コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		// コード名＝TRADE_TYPE（取引区分）
		// 削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_TRADE_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapTradeType = new LinkedHashMap<String, String>();
		mapTradeType.put("", "--選択してください--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapTradeType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setTradeTypeCombo(mapTradeType);

		// 1-2-7 大学細分類
		// コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		// コード名＝UNIV_SUBDIV（大学細分類）
		// 削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_UNIV_SUBDIV);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapUnivSubdiv = new LinkedHashMap<String, String>();
		mapUnivSubdiv.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapUnivSubdiv.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setUnivSubdivCombo(mapUnivSubdiv);

		// 1-2-8 対象区分
		// コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		// コード名＝HO_INS_TYPE（対象区分）
		// 削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HO_INS_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapHoInsType = new LinkedHashMap<String, String>();
		mapHoInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapHoInsType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setHoInsTypeCombo(mapHoInsType);

		// 1-2-10 ワクチン対象区分
		// コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		// コード名＝VAC_INS_TYPE（ワクチン対象区分）
		// 削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_INS_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacInsType = new LinkedHashMap<String, String>();
		mapVacInsType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacInsType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setVacInsTypeCombo(mapVacInsType);

		// 1-2-11 ワクチン定訪先区分
		// コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		// コード名＝VAC_VISIT_TYPE（ワクチン定訪先区分）
		// 削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_VAC_VISIT_TYPE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapVacVisitType = new LinkedHashMap<String, String>();
		mapVacVisitType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapVacVisitType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setVacVisitTypeCombo(mapVacVisitType);

		// 開業年月日
		MRdmComCalUsrEntity inEntityYearCmb = new MRdmComCalUsrEntity();
		inEntityYearCmb.setToday("1");
		MRdmComCalUsrEntity outCalUsr = dao.selectByValue(inEntityYearCmb).get(0);
		int yearInt = Integer.parseInt(outCalUsr.getCalYear());
		LinkedHashMap<String, String> mapYear = new LinkedHashMap<String, String>();
		mapYear.put("", "");
		for (int i = 0; i < 101; i++) {
			String yearStr = Integer.toString(yearInt + 1 - i);
			mapYear.put(yearStr, yearStr);
		}
		indto.setInsOpenYearCombo(mapYear);

		LinkedHashMap<String, String> mapMonth = new LinkedHashMap<String, String>();
		mapMonth.put("", "");
		for (int i = 0; i < 12; i++) {
			String monthStr = String.format("%02d", (i + 1));
			mapMonth.put(monthStr, monthStr);
		}
		indto.setInsOpenMonthCombo(mapMonth);

		LinkedHashMap<String, String> mapDay = new LinkedHashMap<String, String>();
		mapDay.put("", "");
		for (int i = 0; i < 31; i++) {
			String dayStr = String.format("%02d", (i + 1));
			mapDay.put(dayStr, dayStr);
		}
		indto.setInsOpenDayCombo(mapDay);

		// 領域
		SelectRdmComTrtgrpDataEntity inTrtEntityCmb = new SelectRdmComTrtgrpDataEntity();
		if (RdmConstantsData.RDM_JKN_MR.equals(indto.getLoginJokenSetCd())) {
			inTrtEntityCmb.setTrtCd(indto.getLoginTrtCd());
		}
		List<SelectRdmComTrtgrpDataEntity> outTrtList = dao.select(inTrtEntityCmb);
		LinkedHashMap<String, String> mapTrt = new LinkedHashMap<String, String>();
		mapTrt.put("", "--なし--");
		for (SelectRdmComTrtgrpDataEntity outEntity : outTrtList) {
			mapTrt.put(outEntity.getTrtCd(), outEntity.getTrtCd() + ":" + outEntity.getTrtNm());
		}
		indto.setTrtCdCombo(mapTrt);
	}

	/**
	 *
	 * @param indto
	 * @return
	 */
	@Transactional
	public BaseDTO cancel(NF011DTO indto) {
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

		// 施設_領域担当者ワークを物理削除
		MRdmHcoJkrWkEntity mRdmHcoJkrWkEntity = new MRdmHcoJkrWkEntity();
		mRdmHcoJkrWkEntity.setReqId(indto.getReqId());
		dao.deleteByPK(mRdmHcoJkrWkEntity);

		// END UOC
		return outdto;
	}

	/**
	 * イベント処理
	 *
	 * @param indto NF011DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(NF011DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
		// DropDownList作成
		createCombo(indto);
		// 現在日付を取得
		Date systemDate = DateUtils.getNowDate();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = fmtDate.format(systemDate);

		String reqId = indto.getReqId();
		boolean errFlg = false;
		String errMsg = "";

		// レングスチェック
		if (indto.getInsAbbrName() != null && indto.getInsAbbrName().length() > 10) {
			// 最大文字数を超えています。（施設略式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設略式漢字名") + "\n";
			errFlg = true;
		}
		if (indto.getInsKana() != null && indto.getInsKana().length() > 15) {
			// 最大文字数を超えています。（施設カナ名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設カナ名") + "\n";
			errFlg = true;
		}
		if (indto.getInsFormalName() != null && indto.getInsFormalName().length() > 40) {
			// 最大文字数を超えています。（施設正式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "施設正式漢字名") + "\n";
			errFlg = true;
		}
		if (indto.getEntcapaNum() != null && indto.getEntcapaNum().length() > 4) {
			// 最大文字数を超えています。（入所定員情報）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "入所定員情報") + "\n";
			errFlg = true;
		}
		if (indto.getInsPcode() != null && indto.getInsPcode().length() > 8) {
			// 最大文字数を超えています。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
		}
		if (indto.getInsPhone1() != null && indto.getInsPhone1().length() > 13) {
			// 最大文字数を超えています。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
		}
		if (indto.getInsFax1() != null && indto.getInsFax1().length() > 13) {
			// 最大文字数を超えています。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
		}
		if (indto.getInsPhone2() != null && indto.getInsPhone2().length() > 13) {
			// 最大文字数を超えています。（電話番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "電話番号(薬局/DI室)") + "\n";
			errFlg = true;
		}
		if (indto.getInsFax2() != null && indto.getInsFax2().length() > 13) {
			// 最大文字数を超えています。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
		}
		if (indto.getBedCntBase() != null && indto.getBedCntBase().length() > 4) {
			// 最大文字数を超えています。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "基準") + "\n";
			errFlg = true;
		}
		if (indto.getBedCnt04() != null && indto.getBedCnt04().length() > 4) {
			// 最大文字数を超えています。（結核）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "結核") + "\n";
			errFlg = true;
		}
		if (indto.getBedCnt01() != null && indto.getBedCnt01().length() > 4) {
			// 最大文字数を超えています。（一般）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "一般") + "\n";
			errFlg = true;
		}
		if (indto.getBedCnt05() != null && indto.getBedCnt05().length() > 4) {
			// 最大文字数を超えています。（感染症）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "感染症") + "\n";
			errFlg = true;
		}
		if (indto.getBedCnt03() != null && indto.getBedCnt03().length() > 4) {
			// 最大文字数を超えています。（精神）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "精神") + "\n";
			errFlg = true;
		}
		if (indto.getBedCnt07() != null && indto.getBedCnt07().length() > 4) {
			// 最大文字数を超えています。（療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "療養") + "\n";
			errFlg = true;
		}
		if (indto.getBedCnt02() != null && indto.getBedCnt02().length() > 4) {
			// 最大文字数を超えています。（医療療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "医療療養") + "\n";
			errFlg = true;
		}
		if (indto.getBedCnt06() != null && indto.getBedCnt06().length() > 4) {
			// 最大文字数を超えています。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "介護療養") + "\n";
			errFlg = true;
		}
		if (indto.getReqComment() != null && StringUtils.getByteLength(indto.getReqComment()) > 300) {
			// 最大文字数を超えています。（申請コメント）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W009).replace("項目名", "申請コメント") + "\n";
			errFlg = true;
		}

		// 文字種チェック
		if (!isNumHyph(indto.getInsPcode())) {
			// 入力文字種が不正です。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
		}
		if (!isNumHyph(indto.getInsPhone1())) {
			// 入力文字種が不正です。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
		}
		if (!isNumHyph(indto.getInsFax1())) {
			// 入力文字種が不正です。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
		}
		if (!isNumHyph(indto.getInsPhone2())) {
			// 入力文字種が不正です。（電話番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "電話番号(薬局/DI室)") + "\n";
			errFlg = true;
		}
		if (!isNumHyph(indto.getInsFax2())) {
			// 入力文字種が不正です。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedCntBase())) {
			// 入力文字種が不正です。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "基準") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedCnt04())) {
			// 入力文字種が不正です。（結核）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "結核") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedCnt01())) {
			// 入力文字種が不正です。（一般）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "一般") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedCnt05())) {
			// 入力文字種が不正です。（感染症）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "感染症") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedCnt03())) {
			// 入力文字種が不正です。（精神）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "精神") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedCnt07())) {
			// 入力文字種が不正です。（療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "療養") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedCnt02())) {
			// 入力文字種が不正です。（医療療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "医療療養") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedCnt06())) {
			// 入力文字種が不正です。（介護療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "介護療養") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getBedsTot())) {
			// 入力文字種が不正です。（ベッド数計）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "ベッド数計") + "\n";
			errFlg = true;
		}
		if (!StringUtils.isNumeric(indto.getMedBedsTot())) {
			// 入力文字種が不正です。（医療ベッド数計）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W013).replace("項目名", "医療ベッド数計") + "\n";
			errFlg = true;
		}

		// 半角全角チェック
		if (StringUtils.checkMultiByte(indto.getInsPcode())) {
			// 半角で入力してください。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
		}
		if (StringUtils.checkMultiByte(indto.getInsPhone1())) {
			// 半角で入力してください。（電話番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "電話番号(代表)") + "\n";
			errFlg = true;
		}
		if (StringUtils.checkMultiByte(indto.getInsFax1())) {
			// 半角で入力してください。（FAX番号(代表)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "FAX番号(代表)") + "\n";
			errFlg = true;
		}
		if (StringUtils.checkMultiByte(indto.getInsPhone2())) {
			// 半角で入力してください。（電話番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "電話番号(薬局/DI室)") + "\n";
			errFlg = true;
		}
		if (StringUtils.checkMultiByte(indto.getInsFax2())) {
			// 半角で入力してください。（FAX番号(薬局/DI室)）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "FAX番号(薬局/DI室)") + "\n";
			errFlg = true;
		}
		if (StringUtils.checkSingleByte(indto.getInsAbbrName())) {
			// 全角で入力してください。（施設略式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "施設略式漢字名") + "\n";
			errFlg = true;
		}
		if (StringUtils.checkMultiByte(indto.getInsKana())) {
			// 半角で入力してください。（施設カナ名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W014).replace("項目名", "施設カナ名") + "\n";
			errFlg = true;
		}
		if (StringUtils.checkSingleByte(indto.getInsFormalName())) {
			// 全角で入力してください。（施設正式漢字名）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "施設正式漢字名") + "\n";
			errFlg = true;
		}
		if (StringUtils.checkSingleByte(indto.getInsAddrDt())) {
			// 全角で入力してください。（町名地番）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W015).replace("項目名", "町名地番") + "\n";
			errFlg = true;
		}

		// 書式チェック
		if (indto.getInsPcode() != null && ((indto.getInsPcode().length() != 0 && indto.getInsPcode().length() != 7
				&& indto.getInsPcode().length() != 8)
				|| (indto.getInsPcode().length() == 8 && !chkPostcode(indto.getInsPcode())
						|| (indto.getInsPcode().length() == 7 && !StringUtils.isNumeric(indto.getInsPcode()))))) {
			// 正しい書式で入力してください。（郵便番号）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W016).replace("項目名", "郵便番号") + "\n";
			errFlg = true;
		}

		// 範囲チェック
		if (!chkNumRange(indto.getBedCntBase(), 0, 9999)) {
			// 入力可能範囲外です。（基準）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "基準") + "\n";
			errFlg = true;
		}
		if (!chkNumRange(indto.getBedCnt04(), 0, 9999)) {
			// 入力可能範囲外です。（結核）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "結核") + "\n";
			errFlg = true;
		}
		if (!chkNumRange(indto.getBedCnt01(), 0, 9999)) {
			// 入力可能範囲外です。（一般）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "一般") + "\n";
			errFlg = true;
		}
		if (!chkNumRange(indto.getBedCnt05(), 0, 9999)) {
			// 入力可能範囲外です。（感染症）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "感染症") + "\n";
			errFlg = true;
		}
		if (!chkNumRange(indto.getBedCnt03(), 0, 9999)) {
			// 入力可能範囲外です。（精神）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "精神") + "\n";
			errFlg = true;
		}
		if (!chkNumRange(indto.getBedCnt07(), 0, 9999)) {
			// 入力可能範囲外です。（療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "療養") + "\n";
			errFlg = true;
		}
		if (!chkNumRange(indto.getBedCnt02(), 0, 9999)) {
			// 入力可能範囲外です。（医療療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "医療療養") + "\n";
			errFlg = true;
		}
		if (!chkNumRange(indto.getBedCnt06(), 0, 9999)) {
			// 入力可能範囲外です。（介護療養）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "介護療養") + "\n";
			errFlg = true;
		}
		if (!chkNumRange(indto.getEntcapaNum(), 0, 9999)) {
			// 入力可能範囲外です。（入所定員情報）
			errMsg += loginInfo.getMsgData(RdmConstantsData.W018).replace("項目名", "入所定員情報") + "\n";
			errFlg = true;
		}

		// 整合性チェック
		// 主担当重複チェック
		indto.setHcoJkrDataList(delDeleteFlgRow(indto.getHcoJkrDataList()));

		List<HcoJkrData> hcoJkrDataList = indto.getHcoJkrDataList();
		HashSet<String> trtSet = new HashSet<>();

		for (int i = 0; i < hcoJkrDataList.size(); i++) {
			HcoJkrData hcoJkrData = hcoJkrDataList.get(i);
			if (!trtSet.add(hcoJkrData.getTrtCd())) {
				// 領域に対して担当者は1名のみ設定してください。
				errMsg += loginInfo.getMsgData(RdmConstantsData.W034) + "\n";
				errFlg = true;
				break;
			}
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
			tRdmReqKnrInsData.setReqType("01");
			tRdmReqKnrInsData.setReqStsCd("01");
			tRdmReqKnrInsData.setReqBrCd(indto.getReqBrCd());
			tRdmReqKnrInsData.setReqDistCd(indto.getReqDistCd());
			tRdmReqKnrInsData.setReqShzNm(indto.getReqShzNm());
			tRdmReqKnrInsData.setReqJgiNo(indto.getReqJgiNo());
			tRdmReqKnrInsData.setReqJgiName(indto.getReqJgiName());
			tRdmReqKnrInsData.setReqComment(indto.getReqComment());
			tRdmReqKnrInsData.setInsShaYmd(systemDate);
			tRdmReqKnrInsData.setInsShaId(indto.getLoginJgiNo());
			tRdmReqKnrInsData.setUpdShaYmd(systemDate);
			tRdmReqKnrInsData.setUpdShaId(indto.getLoginJgiNo());

			dao.insertByValue(tRdmReqKnrInsData);

		} else {
			// 更新
			TRdmReqKnrEntity tRdmReqKnrUpdData = new TRdmReqKnrEntity("updateNF011Data");
			tRdmReqKnrUpdData.setReqId(reqId);
			tRdmReqKnrUpdData.setReqStsCd("01");
			tRdmReqKnrUpdData.setReqComment(indto.getReqComment());
			tRdmReqKnrUpdData.setUpdShaYmd(systemDate);
			tRdmReqKnrUpdData.setUpdShaId(indto.getLoginJgiNo());

			dao.update(tRdmReqKnrUpdData);
		}

		// 施設_申請管理
		TRdmHcoReqEntity tRdmHcoReqEntity = new TRdmHcoReqEntity();
		tRdmHcoReqEntity.setReqId(reqId);
		TRdmHcoReqEntity tRdmHcoReqData = dao.selectByPK(tRdmHcoReqEntity);

		// 施設分類取得
		String insClass = null;
		MRdmCodeMstEntity mRdmCodeMstEntity = new MRdmCodeMstEntity();
		mRdmCodeMstEntity.setCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_INS_TYPE);
		mRdmCodeMstEntity.setValue1(indto.getInsType());
		List<MRdmCodeMstEntity> mRdmCodeMstDate = dao.selectByValue(mRdmCodeMstEntity);
		if (mRdmCodeMstDate.size() > 0) {
			insClass = mRdmCodeMstDate.get(0).getValue2();
		}

		if (tRdmHcoReqData == null) {
			// 新規登録
			TRdmHcoReqEntity tRdmHcoReqInsData = new TRdmHcoReqEntity();
			tRdmHcoReqInsData.setReqId(reqId);
			tRdmHcoReqInsData.setInsClass(insClass);
			tRdmHcoReqInsData.setInsSbt(indto.getInsType());
			tRdmHcoReqInsData.setInsKana(indto.getInsKana());
			tRdmHcoReqInsData.setInsAbbrName(indto.getInsAbbrName());
			tRdmHcoReqInsData.setInsFormalName(indto.getInsFormalName());
			tRdmHcoReqInsData.setInsContName(indto.getInsContName());
			tRdmHcoReqInsData.setInsPcode(indto.getInsPcode().replace("-", ""));
			tRdmHcoReqInsData.setAddrCodePref(indto.getAddrCodePref());
			tRdmHcoReqInsData.setAddrCodeCity(indto.getAddrCodeCity());
			tRdmHcoReqInsData.setTkCityCd(indto.getTkCityCd());
			tRdmHcoReqInsData.setInsAddrDt(indto.getInsAddrDt());
			tRdmHcoReqInsData.setInsAddr(StringUtils.nvl(indto.getInsAddr(), ""));
			tRdmHcoReqInsData.setInsAddrKana(StringUtils.nvl(indto.getInsAddrKana(), ""));
			tRdmHcoReqInsData.setInsPhone1(indto.getInsPhone1());
			tRdmHcoReqInsData.setInsFax1(indto.getInsFax1());
			tRdmHcoReqInsData.setInsPhone2(indto.getInsPhone2());
			tRdmHcoReqInsData.setInsFax2(indto.getInsFax2());
			tRdmHcoReqInsData.setInsUrl(indto.getInsUrl());
			tRdmHcoReqInsData.setInsUrlYmd(indto.getInsUrlYmd().replace("-", ""));
			tRdmHcoReqInsData.setTradeType(indto.getTradeType());
			tRdmHcoReqInsData.setHoInsType(indto.getHoInsType());
			tRdmHcoReqInsData.setPharmType(indto.getPharmType());
			tRdmHcoReqInsData.setInsRank(indto.getInsRank());
			tRdmHcoReqInsData.setManageCd(indto.getManageCd());
			tRdmHcoReqInsData.setRegVisType(indto.getRegVisType());
			tRdmHcoReqInsData.setImpHosType(indto.getImpHosType());
			tRdmHcoReqInsData.setUnivSubdiv(indto.getUnivSubdiv());
			tRdmHcoReqInsData.setInsOpenYear(indto.getInsOpenYear());
			tRdmHcoReqInsData.setInsOpenMonth(indto.getInsOpenMonth());
			tRdmHcoReqInsData.setInsOpenDay(indto.getInsOpenDay());

			// 診療科目セットする
			if (indto.getUltInsCd() != null && indto.getUltInsCd() != "") {
				// T_RDM_M_MDB_HCO_MSTから取得、セミコロン区切りで登録
				List<String> shinryoList = new ArrayList<String>();
				TRdmMMdbHcoMstEntity tRdmMMdbHcoMstEntity = new TRdmMMdbHcoMstEntity();
				tRdmMMdbHcoMstEntity.setMdbKbn("DCF");
				tRdmMMdbHcoMstEntity.setDcfShisetsuCd(indto.getUltInsCd());

				List<TRdmMMdbHcoMstEntity> tRdmMMdbHcoMstData = dao.selectByValue(tRdmMMdbHcoMstEntity);

				if (tRdmMMdbHcoMstData.size() > 0) {
					TRdmMMdbHcoMstEntity tRdmMMdbHcoMstSinryoData = tRdmMMdbHcoMstData.get(0);
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd1() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd1());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd2() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd2());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd3() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd3());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd4() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd4());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd5() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd5());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd6() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd6());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd7() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd7());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd8() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd8());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd9() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd9());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd10() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd10());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd11() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd11());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd12() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd12());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd13() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd13());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd14() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd14());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd15() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd15());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd16() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd16());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd17() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd17());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd18() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd18());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd19() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd19());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd20() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd20());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd21() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd21());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd22() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd22());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd23() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd23());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd24() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd24());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd25() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd25());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd26() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd26());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd27() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd27());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd28() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd28());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd29() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd29());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd30() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd30());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd31() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd31());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd32() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd32());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd33() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd33());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd34() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd34());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd35() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd35());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd36() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd36());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd37() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd37());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd38() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd38());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd39() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd39());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd40() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd40());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd41() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd41());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd42() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd42());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd43() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd43());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd44() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd44());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd45() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd45());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd46() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd46());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd47() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd47());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd48() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd48());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd49() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd49());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd50() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd50());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd51() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd51());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd52() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd52());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd53() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd53());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd54() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd54());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd55() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd55());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd56() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd56());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd57() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd57());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd58() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd58());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd59() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd59());
					}
					if (tRdmMMdbHcoMstSinryoData.getShinryokamokuCd60() != null) {
						shinryoList.add(tRdmMMdbHcoMstSinryoData.getShinryokamokuCd60());
					}
				}

				tRdmHcoReqInsData.setClitemList(String.join(";", shinryoList));
			}

			tRdmHcoReqInsData.setVacInsType(indto.getVacInsType());
			tRdmHcoReqInsData.setVacVisitType(indto.getVacVisitType());
			tRdmHcoReqInsData.setBedcntBase(indto.getBedCntBase());
			tRdmHcoReqInsData.setBedsTot(indto.getBedsTot());
			tRdmHcoReqInsData.setMedBedsTot(indto.getMedBedsTot());
			tRdmHcoReqInsData.setEntcapaNum(indto.getEntcapaNum());
			tRdmHcoReqInsData.setMainInsNo(indto.getMainInsCd());
			tRdmHcoReqInsData.setUltInsNo(indto.getUltInsCd());
			tRdmHcoReqInsData.setBedcnt01(indto.getBedCnt01());
			tRdmHcoReqInsData.setBedcnt02(indto.getBedCnt02());
			tRdmHcoReqInsData.setBedcnt03(indto.getBedCnt03());
			tRdmHcoReqInsData.setBedcnt04(indto.getBedCnt04());
			tRdmHcoReqInsData.setBedcnt05(indto.getBedCnt05());
			tRdmHcoReqInsData.setBedcnt06(indto.getBedCnt06());
			tRdmHcoReqInsData.setBedcnt07(indto.getBedCnt07());
			tRdmHcoReqInsData.setInsShaYmd(sysDate);
			tRdmHcoReqInsData.setInsShaId(indto.getLoginJgiNo());
			tRdmHcoReqInsData.setUpdShaYmd(sysDate);
			tRdmHcoReqInsData.setUpdShaId(indto.getLoginJgiNo());

			dao.insertByValue(tRdmHcoReqInsData);

		} else {
			// 更新
			TRdmHcoReqEntity tRdmHcoReqUpdData = new TRdmHcoReqEntity("updateNF011Data");
			tRdmHcoReqUpdData.setReqId(reqId);
			tRdmHcoReqUpdData.setInsClass(insClass);
			tRdmHcoReqUpdData.setInsSbt(indto.getInsType());
			tRdmHcoReqUpdData.setInsKana(indto.getInsKana());
			tRdmHcoReqUpdData.setInsAbbrName(indto.getInsAbbrName());
			tRdmHcoReqUpdData.setInsFormalName(indto.getInsFormalName());
			tRdmHcoReqUpdData.setInsContName(indto.getInsContName());
			tRdmHcoReqUpdData.setInsPcode(indto.getInsPcode().replace("-", ""));
			tRdmHcoReqUpdData.setAddrCodePref(indto.getAddrCodePref());
			tRdmHcoReqUpdData.setAddrCodeCity(indto.getAddrCodeCity());
			tRdmHcoReqUpdData.setTkCityCd(indto.getTkCityCd());
			tRdmHcoReqUpdData.setInsAddrDt(indto.getInsAddrDt());
			tRdmHcoReqUpdData.setInsAddr(StringUtils.nvl(indto.getInsAddr(), ""));
			tRdmHcoReqUpdData.setInsAddrKana(StringUtils.nvl(indto.getInsAddrKana(), ""));
			tRdmHcoReqUpdData.setInsPhone1(indto.getInsPhone1());
			tRdmHcoReqUpdData.setInsFax1(indto.getInsFax1());
			tRdmHcoReqUpdData.setInsPhone2(indto.getInsPhone2());
			tRdmHcoReqUpdData.setInsFax2(indto.getInsFax2());
			tRdmHcoReqUpdData.setInsUrl(indto.getInsUrl());
			tRdmHcoReqUpdData.setInsUrlYmd(indto.getInsUrlYmd().replace("-", ""));
			tRdmHcoReqUpdData.setTradeType(indto.getTradeType());
			tRdmHcoReqUpdData.setHoInsType(indto.getHoInsType());
			tRdmHcoReqUpdData.setPharmType(indto.getPharmType());
			tRdmHcoReqUpdData.setInsRank(indto.getInsRank());
			tRdmHcoReqUpdData.setManageCd(indto.getManageCd());
			tRdmHcoReqUpdData.setRegVisType(indto.getRegVisType());
			tRdmHcoReqUpdData.setImpHosType(indto.getImpHosType());
			tRdmHcoReqUpdData.setUnivSubdiv(indto.getUnivSubdiv());
			tRdmHcoReqUpdData.setInsOpenYear(indto.getInsOpenYear());
			tRdmHcoReqUpdData.setInsOpenMonth(indto.getInsOpenMonth());
			tRdmHcoReqUpdData.setInsOpenDay(indto.getInsOpenDay());
			tRdmHcoReqUpdData.setVacInsType(indto.getVacInsType());
			tRdmHcoReqUpdData.setVacVisitType(indto.getVacVisitType());
			tRdmHcoReqUpdData.setBedcntBase(indto.getBedCntBase());
			tRdmHcoReqUpdData.setBedsTot(indto.getBedsTot());
			tRdmHcoReqUpdData.setMedBedsTot(indto.getMedBedsTot());
			tRdmHcoReqUpdData.setEntcapaNum(indto.getEntcapaNum());
			tRdmHcoReqUpdData.setMainInsNo(indto.getMainInsCd());
			tRdmHcoReqUpdData.setBedcnt01(indto.getBedCnt01());
			tRdmHcoReqUpdData.setBedcnt02(indto.getBedCnt02());
			tRdmHcoReqUpdData.setBedcnt03(indto.getBedCnt03());
			tRdmHcoReqUpdData.setBedcnt04(indto.getBedCnt04());
			tRdmHcoReqUpdData.setBedcnt05(indto.getBedCnt05());
			tRdmHcoReqUpdData.setBedcnt06(indto.getBedCnt06());
			tRdmHcoReqUpdData.setBedcnt07(indto.getBedCnt07());
			tRdmHcoReqUpdData.setUpdShaYmd(sysDate);
			tRdmHcoReqUpdData.setUpdShaId(indto.getLoginJgiNo());

			dao.update(tRdmHcoReqUpdData);
		}

		// 施設_領域担当者ワーク
		List<HcoJkrData> hcoJkrDataEntity = indto.getHcoJkrDataList();

		// 削除処理
		MRdmHcoJkrWkEntity mRdmHcoJkrWkdata = new MRdmHcoJkrWkEntity();
		mRdmHcoJkrWkdata.setReqId(reqId);

		dao.deleteByPK(mRdmHcoJkrWkdata);

		for (int i = 0; i < hcoJkrDataEntity.size(); i++) {
			// 登録処理
			HcoJkrData hcoJkrData = hcoJkrDataEntity.get(i);

			if (!"1".equals(hcoJkrData.getDeleteFlg())) {
				MRdmHcoJkrWkEntity mRdmHcoJkrWkData = new MRdmHcoJkrWkEntity();
				mRdmHcoJkrWkData.setReqId(reqId);
				mRdmHcoJkrWkData.setTrtCd(hcoJkrData.getTrtCd());
				mRdmHcoJkrWkData.setJgiNo(hcoJkrData.getJgiNo());
				mRdmHcoJkrWkData.setMrCat(hcoJkrData.getMrCat());
				mRdmHcoJkrWkData.setMainMr("0");
				mRdmHcoJkrWkData.setRkiFlg("0");
				mRdmHcoJkrWkData.setInsShaYmd(sysDate);
				mRdmHcoJkrWkData.setInsShaId(indto.getLoginJgiNo());
				mRdmHcoJkrWkData.setUpdShaYmd(sysDate);
				mRdmHcoJkrWkData.setUpdShaId(indto.getLoginJgiNo());

				dao.insertByValue(mRdmHcoJkrWkData);
			}
		}

		indto.setReqId(reqId);
		indto.setReqStsCd("01");
		indto.setDisplayKbn("2");

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
	 * @param indto NF011DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO shnComp(NF011DTO indto) {
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

	/**
	 * 数字ハイフンチェック
	 */
	public static boolean isNumHyph(String s) {
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (!Character.isDigit(c) && !(c == '-')) {
				// 数字ハイフンでなければfalse
				return false;
			}
		}
		return true;
	}

	/**
	 * 郵便番号形式チェック
	 *
	 * @param pcode
	 * @return
	 */
	public static boolean chkPostcode(String pcode) {
		char Letter;

		for (int i = 0; i < pcode.length(); i++) {
			Letter = pcode.charAt(i);
			if (i == 3) {
				if (Letter != '-') {
					return false;
				}
			} else {
				if (Letter < '0' || Letter > '9') {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 数値範囲チェック
	 *
	 * @return n = "", min <= n <= max ならtrue
	 */
	public static boolean chkNumRange(String n, int min, int max) {
		if (n == null || "".equals(n)) {
			return true;
		} else if (!StringUtils.isNumeric(n)) {
			return false;
		} else if (Integer.parseInt(n) >= min && Integer.parseInt(n) <= max) {
			return true;
		}
		return false;
	}

	/**
	 * hcoJkrDataからDeleteFlg=1のデータを削除
	 */
	public static List<HcoJkrData> delDeleteFlgRow(List<HcoJkrData> hcoJkrDataList){
		int i = 0;
		int j = hcoJkrDataList.size();

		while(i < j) {
			if("1".equals(hcoJkrDataList.get(i).getDeleteFlg())) {
				hcoJkrDataList.remove(i);
				j--;
			} else {
				i++;
			}
		}

		return hcoJkrDataList;
	}
}