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
import jp.co.takeda.rdm.dto.ND012DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpPublicEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpShusshinkoEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSocietyEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpDiseaseEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpLiverEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpYakushokuEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpPublicDataEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpSocietyDataEntity;
import jp.co.takeda.rdm.entity.join.SelectND012MainDataEntity;
import jp.co.takeda.rdm.entity.join.SeqRdmReqIdEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpPublicReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmHcpSocietyReqEntity;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.entity.join.UpdateTRdmHcpPublicReqEntity;
import jp.co.takeda.rdm.entity.join.UpdateTRdmHcpReqEntity;
import jp.co.takeda.rdm.entity.join.UpdateTRdmHcpSocietyReqEntity;
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
 * Serviceクラス（ND012)
 * @generated
 */
@Named
public class ND012Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(ND012Service.class);

	/**
	 * 共通処理Serviceオブジェクト
	 *   新組織名称(変更前)取得処理
	 */
	@javax.inject.Inject
	private CommonControlService commonControlService;

	/**
	 * イベント処理
	 * @param indto ND012DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND012DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		List<HcpSocietyData> hcpSocietyDataList = new ArrayList<HcpSocietyData>();
		List<HcpSocietyData> beforeHcpSocietyDataList = new ArrayList<HcpSocietyData>();
		List<HcpPublicData> hcpPublicDataList = new ArrayList<HcpPublicData>();
		List<HcpPublicData> beforeHcpPublicDataList = new ArrayList<HcpPublicData>();

		if ("1".equals(indto.getDisplayKbn())) {
			if (indto.getTkdDocNo() != null) {
				// 武田医師コードで初期データ作成
				SelectND012MainDataEntity paramEntity = new SelectND012MainDataEntity();
				paramEntity.setSqlId("selectND012TKDData");
				paramEntity.setInDocNo(indto.getTkdDocNo());
				List<SelectND012MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectND012MainDataEntity mainDataEntity = mainDataEntityList.get(0);
				indto.setTkdDocNo(StringUtils.nvl(mainDataEntity.getTkdDocNo(), ""));
				indto.setTkdDocNm(StringUtils.nvl(mainDataEntity.getTkdDocNm(), ""));
				indto.setTkdDocKana(StringUtils.nvl(mainDataEntity.getTkdDocKana(), ""));
				indto.setUltDocNo(StringUtils.nvl(mainDataEntity.getUltDocNo(), ""));
				indto.setUltDocNm(StringUtils.nvl(mainDataEntity.getUltDocNm(), ""));
				indto.setUltDocKana(StringUtils.nvl(mainDataEntity.getUltDocKana(), ""));
//				初期値はマスタ値からセット
				indto.setDocType(StringUtils.nvl(mainDataEntity.getMstDocType(), ""));
				indto.setSexCd(StringUtils.nvl(mainDataEntity.getMstSexCd(), ""));
				indto.setDocKanjiSei(StringUtils.nvl(mainDataEntity.getMstDocKanjiSei(), ""));
				indto.setDocKanjiMei(StringUtils.nvl(mainDataEntity.getMstDocKanjiMei(), ""));
				indto.setDocKanaSei(StringUtils.nvl(mainDataEntity.getMstDocKanaSei(), ""));
				indto.setDocKanaMei(StringUtils.nvl(mainDataEntity.getMstDocKanaMei(), ""));
				indto.setOldKanjSei(StringUtils.nvl(mainDataEntity.getMstOldKanjSei(), ""));
				indto.setOldKanaSei(StringUtils.nvl(mainDataEntity.getMstOldKanaSei(), ""));
				indto.setNewNameStYear(StringUtils.nvl(mainDataEntity.getMstNewNameStYear(), ""));
				indto.setNewNameStMonth(StringUtils.nvl(mainDataEntity.getMstNewNameStMonth(), ""));
				indto.setNewNameStDay(StringUtils.nvl(mainDataEntity.getMstNewNameStDay(), ""));
				indto.setDobYear(StringUtils.nvl(mainDataEntity.getMstDobYear(), ""));
				indto.setDobMonth(StringUtils.nvl(mainDataEntity.getMstDobMonth(), ""));
				indto.setDobDay(StringUtils.nvl(mainDataEntity.getMstDobDay(), ""));
				indto.setHomeTownCd(StringUtils.nvl(mainDataEntity.getMstHomeTownCd(), ""));
				indto.setMedSchoolCd(StringUtils.nvl(mainDataEntity.getMstMedSchoolCd(), ""));
				indto.setGradYear(StringUtils.nvl(mainDataEntity.getMstGradYear(), ""));
				indto.setEmplYear(StringUtils.nvl(mainDataEntity.getMstEmplYear(), ""));
				indto.setHomeUnivCd(StringUtils.nvl(mainDataEntity.getMstHomeUnivCd(), ""));
				indto.setHomeDeptCd(StringUtils.nvl(mainDataEntity.getMstHomeDeptCd(), ""));
				indto.setHomeDeptNm(StringUtils.nvl(mainDataEntity.getMstHomeDeptNm(), ""));
				indto.setSpLiverCd(StringUtils.nvl(mainDataEntity.getMstSpLiverCd(), ""));
				indto.setSpDiseaseCd(StringUtils.nvl(mainDataEntity.getMstSpDiseaseCd(), ""));
				indto.setSpCom(StringUtils.nvl(mainDataEntity.getMstSpCom(), ""));
				// 変更前
				indto.setMstDocType(StringUtils.nvl(mainDataEntity.getMstDocType(), ""));
				indto.setMstDocTypeNm(StringUtils.nvl(mainDataEntity.getMstDocTypeNm(), ""));
				indto.setMstSexCd(StringUtils.nvl(mainDataEntity.getMstSexCd(), ""));
				indto.setMstSexNm(StringUtils.nvl(mainDataEntity.getMstSexNm(), ""));
				indto.setMstDocKanjiSei(StringUtils.nvl(mainDataEntity.getMstDocKanjiSei(), ""));
				indto.setMstDocKanjiMei(StringUtils.nvl(mainDataEntity.getMstDocKanjiMei(), ""));
				indto.setMstDocKanaSei(StringUtils.nvl(mainDataEntity.getMstDocKanaSei(), ""));
				indto.setMstDocKanaMei(StringUtils.nvl(mainDataEntity.getMstDocKanaMei(), ""));
				indto.setMstOldKanjSei(StringUtils.nvl(mainDataEntity.getMstOldKanjSei(), ""));
				indto.setMstOldKanaSei(StringUtils.nvl(mainDataEntity.getMstOldKanaSei(), ""));
				indto.setMstNewNameStYear(StringUtils.nvl(mainDataEntity.getMstNewNameStYear(), ""));
				indto.setMstNewNameStMonth(StringUtils.nvl(mainDataEntity.getMstNewNameStMonth(), ""));
				indto.setMstNewNameStDay(StringUtils.nvl(mainDataEntity.getMstNewNameStDay(), ""));
				indto.setMstDobYear(StringUtils.nvl(mainDataEntity.getMstDobYear(), ""));
				indto.setMstDobMonth(StringUtils.nvl(mainDataEntity.getMstDobMonth(), ""));
				indto.setMstDobDay(StringUtils.nvl(mainDataEntity.getMstDobDay(), ""));
				indto.setMstHomeTownCd(StringUtils.nvl(mainDataEntity.getMstHomeTownCd(), ""));
				indto.setMstHomeTownNm(StringUtils.nvl(mainDataEntity.getMstHomeTownNm(), ""));
				indto.setMstMedSchoolCd(StringUtils.nvl(mainDataEntity.getMstMedSchoolCd(), ""));
				indto.setMstMedSchoolNm(StringUtils.nvl(mainDataEntity.getMstMedSchoolNm(), ""));
				indto.setMstGradYear(StringUtils.nvl(mainDataEntity.getMstGradYear(), ""));
				indto.setMstHomeUnivCd(StringUtils.nvl(mainDataEntity.getMstHomeUnivCd(), ""));
				indto.setMstHomeUnivNm(StringUtils.nvl(mainDataEntity.getMstHomeUnivNm(), ""));
				indto.setMstEmplYear(StringUtils.nvl(mainDataEntity.getMstEmplYear(), ""));
				indto.setMstHomeDeptCd(StringUtils.nvl(mainDataEntity.getMstHomeDeptCd(), ""));
				indto.setMstHomeDeptNm(StringUtils.nvl(mainDataEntity.getMstHomeDeptNm(), ""));
				indto.setMstSpLiverCd(StringUtils.nvl(mainDataEntity.getMstSpLiverCd(), ""));
				indto.setMstSpLiverNm(StringUtils.nvl(mainDataEntity.getMstSpLiverNm(), ""));
				indto.setMstSpDiseaseCd(StringUtils.nvl(mainDataEntity.getMstSpDiseaseCd(), ""));
				indto.setMstSpDiseaseNm(StringUtils.nvl(mainDataEntity.getMstSpDiseaseNm(), ""));
				indto.setMstSpCom(StringUtils.nvl(mainDataEntity.getMstSpCom(), ""));

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

				// マスタから取得
				// 所属学会リスト
				SelectHcpSocietyDataEntity societyParamEntity = new SelectHcpSocietyDataEntity();
				societyParamEntity.setSqlId("selectHcpSocietyDataFromMst");
				societyParamEntity.setInDocNo(indto.getTkdDocNo());
				List<SelectHcpSocietyDataEntity> societyDataEntityList = dao.select(societyParamEntity);
				for (SelectHcpSocietyDataEntity sEntity : societyDataEntityList) {
					HcpSocietyData sData = new HcpSocietyData();
					HcpSocietyData sbData = new HcpSocietyData();
					setHcpSocietyData(sEntity,sData);
					setHcpSocietyData(sEntity,sbData);
					hcpSocietyDataList.add(sData);
					beforeHcpSocietyDataList.add(sbData);
				}
				indto.setHcpSocietyDataList(hcpSocietyDataList);
				indto.setBeforeHcpSocietyDataList(beforeHcpSocietyDataList);
				// 公的機関リスト
				SelectHcpPublicDataEntity publicParamEntity = new SelectHcpPublicDataEntity();
				publicParamEntity.setSqlId("selectHcpPublicDataFromMst");
				publicParamEntity.setInDocNo(indto.getTkdDocNo());
				List<SelectHcpPublicDataEntity> publicDataEntityList = dao.select(publicParamEntity);
				for (SelectHcpPublicDataEntity sEntity : publicDataEntityList) {
					HcpPublicData pData = new HcpPublicData();
					HcpPublicData pbData = new HcpPublicData();
					setHcpPublicData(sEntity,pData);
					setHcpPublicData(sEntity,pbData);
					hcpPublicDataList.add(pData);
					beforeHcpPublicDataList.add(pbData);
				}
				indto.setHcpPublicDataList(hcpPublicDataList);
				indto.setBeforeHcpPublicDataList(beforeHcpPublicDataList);
			} else {
//				// 完全新規 ログイン情報から申請者セット
//				indto.setReqShzNm(loginInfo.getBumonRyakuName());
//				indto.setReqJgiName(loginInfo.getJgiName());
//				indto.setReqJgiNo(loginInfo.getJgiNo());
//				indto.setReqBrCd(loginInfo.getBrCode());
//				indto.setReqDistCd(loginInfo.getDistCode());
//				indto.setReqStsNm("");
//				indto.setReqYmdhms("");
//				indto.setUltDocNm("");
//				indto.setUltDocKana("");
			}
		} else if ("2".equals(indto.getDisplayKbn())) {
			if (indto.getReqId() != null) {
				// 申請データ（一時保存含む）を参照
				SelectND012MainDataEntity paramEntity = new SelectND012MainDataEntity();
				paramEntity.setInReqId(indto.getReqId());
				List<SelectND012MainDataEntity> mainDataEntityList = dao.select(paramEntity);
				SelectND012MainDataEntity mainDataEntity = mainDataEntityList.get(0);
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
				indto.setUltDocNo(StringUtils.nvl(mainDataEntity.getUltDocNo(), ""));
				indto.setUltDocNm(StringUtils.nvl(mainDataEntity.getUltDocNm(), ""));
				indto.setUltDocKana(StringUtils.nvl(mainDataEntity.getUltDocKana(), ""));
				indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
				indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
				indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
				indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));
				// NULLは変更前と同値、Zは空文字に変換して表示する nvlUpd
				indto.setDocType(StringUtils.nvlUpd(mainDataEntity.getDocType(), mainDataEntity.getMstDocType()));
				indto.setSexCd(StringUtils.nvlUpd(mainDataEntity.getSexCd(), mainDataEntity.getMstSexCd()));
				indto.setDocKanjiSei(StringUtils.nvlUpd(mainDataEntity.getDocKanjiSei(), mainDataEntity.getMstDocKanjiSei()));
				indto.setDocKanjiMei(StringUtils.nvlUpd(mainDataEntity.getDocKanjiMei(), mainDataEntity.getMstDocKanjiMei()));
				indto.setDocKanaSei(StringUtils.nvlUpd(mainDataEntity.getDocKanaSei(), mainDataEntity.getMstDocKanaSei()));
				indto.setDocKanaMei(StringUtils.nvlUpd(mainDataEntity.getDocKanaMei(), mainDataEntity.getMstDocKanaMei()));
				indto.setOldKanjSei(StringUtils.nvlUpd(mainDataEntity.getOldKanjSei(), mainDataEntity.getMstOldKanjSei()));
				indto.setOldKanaSei(StringUtils.nvlUpd(mainDataEntity.getOldKanaSei(), mainDataEntity.getMstOldKanaSei()));
				indto.setNewNameStYear(StringUtils.nvlUpd(mainDataEntity.getNewNameStYear(), mainDataEntity.getMstNewNameStYear()));
				indto.setNewNameStMonth(StringUtils.nvlUpd(mainDataEntity.getNewNameStMonth(), mainDataEntity.getMstNewNameStMonth()));
				indto.setNewNameStDay(StringUtils.nvlUpd(mainDataEntity.getNewNameStDay(), mainDataEntity.getMstNewNameStDay()));
				indto.setDobYear(StringUtils.nvlUpd(mainDataEntity.getDobYear(), mainDataEntity.getMstDobYear()));
				indto.setDobMonth(StringUtils.nvlUpd(mainDataEntity.getDobMonth(), mainDataEntity.getMstDobMonth()));
				indto.setDobDay(StringUtils.nvlUpd(mainDataEntity.getDobDay(), mainDataEntity.getMstDobDay()));
				indto.setHomeTownCd(StringUtils.nvlUpd(mainDataEntity.getHomeTownCd(), mainDataEntity.getMstHomeTownCd()));
				indto.setMedSchoolCd(StringUtils.nvlUpd(mainDataEntity.getMedSchoolCd(), mainDataEntity.getMstMedSchoolCd()));
				indto.setGradYear(StringUtils.nvlUpd(mainDataEntity.getGradYear(), mainDataEntity.getMstGradYear()));
				indto.setEmplYear(StringUtils.nvlUpd(mainDataEntity.getEmplYear(), mainDataEntity.getMstEmplYear()));
				indto.setHomeUnivCd(StringUtils.nvlUpd(mainDataEntity.getHomeUnivCd(), mainDataEntity.getMstHomeUnivCd()));
				indto.setHomeDeptCd(StringUtils.nvlUpd(mainDataEntity.getHomeDeptCd(), mainDataEntity.getMstHomeDeptCd()));
				if(StringUtils.isZ(mainDataEntity.getHomeDeptCd())) {
					indto.setHomeDeptNm("");
				}else {
					indto.setHomeDeptNm(StringUtils.nvlUpd(mainDataEntity.getHomeDeptNm(), mainDataEntity.getMstHomeDeptNm()));
				}
				indto.setSpLiverCd(StringUtils.nvlUpd(mainDataEntity.getSpLiverCd(), mainDataEntity.getMstSpLiverCd()));
				indto.setSpDiseaseCd(StringUtils.nvlUpd(mainDataEntity.getSpDiseaseCd(), mainDataEntity.getMstSpDiseaseCd()));
				indto.setSpCom(StringUtils.nvlUpd(mainDataEntity.getSpCom(), mainDataEntity.getMstSpCom()));

				// 変更前
				indto.setMstDocType(StringUtils.nvl(mainDataEntity.getMstDocType(), ""));
				indto.setMstDocTypeNm(StringUtils.nvl(mainDataEntity.getMstDocTypeNm(), ""));
				indto.setMstSexCd(StringUtils.nvl(mainDataEntity.getMstSexCd(), ""));
				indto.setMstSexNm(StringUtils.nvl(mainDataEntity.getMstSexNm(), ""));
				indto.setMstDocKanjiSei(StringUtils.nvl(mainDataEntity.getMstDocKanjiSei(), ""));
				indto.setMstDocKanjiMei(StringUtils.nvl(mainDataEntity.getMstDocKanjiMei(), ""));
				indto.setMstDocKanaSei(StringUtils.nvl(mainDataEntity.getMstDocKanaSei(), ""));
				indto.setMstDocKanaMei(StringUtils.nvl(mainDataEntity.getMstDocKanaMei(), ""));
				indto.setMstOldKanjSei(StringUtils.nvl(mainDataEntity.getMstOldKanjSei(), ""));
				indto.setMstOldKanaSei(StringUtils.nvl(mainDataEntity.getMstOldKanaSei(), ""));
				indto.setMstNewNameStYear(StringUtils.nvl(mainDataEntity.getMstNewNameStYear(), ""));
				indto.setMstNewNameStMonth(StringUtils.nvl(mainDataEntity.getMstNewNameStMonth(), ""));
				indto.setMstNewNameStDay(StringUtils.nvl(mainDataEntity.getMstNewNameStDay(), ""));
				indto.setMstDobYear(StringUtils.nvl(mainDataEntity.getMstDobYear(), ""));
				indto.setMstDobMonth(StringUtils.nvl(mainDataEntity.getMstDobMonth(), ""));
				indto.setMstDobDay(StringUtils.nvl(mainDataEntity.getMstDobDay(), ""));
				indto.setMstHomeTownCd(StringUtils.nvl(mainDataEntity.getMstHomeTownCd(), ""));
				indto.setMstHomeTownNm(StringUtils.nvl(mainDataEntity.getMstHomeTownNm(), ""));
				indto.setMstMedSchoolCd(StringUtils.nvl(mainDataEntity.getMstMedSchoolCd(), ""));
				indto.setMstMedSchoolNm(StringUtils.nvl(mainDataEntity.getMstMedSchoolNm(), ""));
				indto.setMstGradYear(StringUtils.nvl(mainDataEntity.getMstGradYear(), ""));
				indto.setMstHomeUnivCd(StringUtils.nvl(mainDataEntity.getMstHomeUnivCd(), ""));
				indto.setMstHomeUnivNm(StringUtils.nvl(mainDataEntity.getMstHomeUnivNm(), ""));
				indto.setMstEmplYear(StringUtils.nvl(mainDataEntity.getMstEmplYear(), ""));
				indto.setMstHomeDeptCd(StringUtils.nvl(mainDataEntity.getMstHomeDeptCd(), ""));
				indto.setMstHomeDeptNm(StringUtils.nvl(mainDataEntity.getMstHomeDeptNm(), ""));
				indto.setMstSpLiverCd(StringUtils.nvl(mainDataEntity.getMstSpLiverCd(), ""));
				indto.setMstSpLiverNm(StringUtils.nvl(mainDataEntity.getMstSpLiverNm(), ""));
				indto.setMstSpDiseaseCd(StringUtils.nvl(mainDataEntity.getMstSpDiseaseCd(), ""));
				indto.setMstSpDiseaseNm(StringUtils.nvl(mainDataEntity.getMstSpDiseaseNm(), ""));
				indto.setMstSpCom(StringUtils.nvl(mainDataEntity.getMstSpCom(), ""));
				indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));

				// 申請データは変更新規追加分しかないのでマージして出す
				// 所属学会リスト
				SelectHcpSocietyDataEntity societyParamEntity = new SelectHcpSocietyDataEntity();
				societyParamEntity.setSqlId("selectHcpSocietyDataMarge");
				societyParamEntity.setInDocNo(indto.getTkdDocNo());
				societyParamEntity.setInReqId(indto.getReqId());
				List<SelectHcpSocietyDataEntity> societyDataEntityList = dao.select(societyParamEntity);
				for (SelectHcpSocietyDataEntity sEntity : societyDataEntityList) {
					HcpSocietyData sData = new HcpSocietyData();
					HcpSocietyData sbData = new HcpSocietyData();
					// Z変換追加すること
					setHcpSocietyData(sEntity,sData);
					setHcpSocietyData(sEntity,sbData);
					hcpSocietyDataList.add(sData);
					beforeHcpSocietyDataList.add(sbData);
				}
				indto.setHcpSocietyDataList(hcpSocietyDataList);
				indto.setBeforeHcpSocietyDataList(beforeHcpSocietyDataList);
				// 公的機関リスト
				SelectHcpPublicDataEntity publicParamEntity = new SelectHcpPublicDataEntity();
				publicParamEntity.setSqlId("selectHcpPublicDataMarge");
				publicParamEntity.setInDocNo(indto.getTkdDocNo());
				publicParamEntity.setInReqId(indto.getReqId());
				List<SelectHcpPublicDataEntity> publicDataEntityList = dao.select(publicParamEntity);
				for (SelectHcpPublicDataEntity sEntity : publicDataEntityList) {
					HcpPublicData pData = new HcpPublicData();
					HcpPublicData pbData = new HcpPublicData();
					// Z変換追加すること
					setHcpPublicData(sEntity,pData);
					setHcpPublicData(sEntity,pbData);
					hcpPublicDataList.add(pData);
					beforeHcpPublicDataList.add(pbData);
				}
				indto.setHcpPublicDataList(hcpPublicDataList);
				indto.setBeforeHcpPublicDataList(beforeHcpPublicDataList);
			} else {
//				// 完全新規
//				indto.setReqShzNm(loginInfo.getBumonRyakuName());
//				indto.setReqJgiName(loginInfo.getJgiName());
//				indto.setReqJgiNo(loginInfo.getJgiNo());
//				indto.setReqBrCd(loginInfo.getBrCode());
//				indto.setReqDistCd(loginInfo.getDistCode());
//				indto.setReqStsNm("");
//				indto.setReqYmdhms("");
//				indto.setUltDocNm("");
//				indto.setUltDocKana("");
			}
		}

		indto.setHcpSocietyDataChgFlg("0");
		indto.setHcpPublicDataChgFlg("0");
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

		// パラメタ医師勤務先メニュー取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName(jp.co.takeda.rdm.util.RdmConstantsData.PARAM_NAME_MN_KMU);
		mRdmParamMstEntity.setDelFlg("0");
		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			String value = mRdmParamMstEntityList.get(0).getValue();
			if(!"000".equals(value)) {
				// 申請・承認・却下ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}
		// END UOC
		return outdto;
	}

	private void setHcpPublicData(SelectHcpPublicDataEntity pEntity, HcpPublicData pData) {
		pData.setClassCategoryCd(StringUtils.nvlUpd(pEntity.getClassCategoryCd(), ""));
		pData.setClassCategoryNm(StringUtils.nvlUpd(pEntity.getClassCategoryNm(), ""));
		pData.setPubInstitutionCd(StringUtils.nvl(pEntity.getPubInstitutionCd(), ""));
		pData.setPubInstitutionNm(StringUtils.nvl(pEntity.getPubInstitutionNm(), ""));
		pData.setPubInstStYYYY(StringUtils.nvlUpd(pEntity.getPubInstStYYYY(), ""));
		pData.setPubInstStMM(StringUtils.nvlUpd(pEntity.getPubInstStMM(), ""));
		pData.setPubInstStDD(StringUtils.nvlUpd(pEntity.getPubInstStDD(), ""));
		String pubInstStYMD = "";
		if(!StringUtils.isEmpty(pData.getPubInstStYYYY())) {
			pubInstStYMD += pData.getPubInstStYYYY();
		}
		if(!StringUtils.isEmpty(pData.getPubInstStMM())) {
			pubInstStYMD += ("/" + pData.getPubInstStMM());
		}
		if(!StringUtils.isEmpty(pData.getPubInstStDD())) {
			pubInstStYMD += ("/" + pData.getPubInstStDD());
		}
		pData.setPubInstStYMD(pubInstStYMD);
		pData.setPubInstEdYYYY(StringUtils.nvlUpd(pEntity.getPubInstEdYYYY(), ""));
		pData.setPubInstEdMM(StringUtils.nvlUpd(pEntity.getPubInstEdMM(), ""));
		pData.setPubInstEdDD(StringUtils.nvlUpd(pEntity.getPubInstEdDD(), ""));
		String pubInstEdYMD = "";
		if(!StringUtils.isEmpty(pData.getPubInstEdYYYY())) {
			pubInstEdYMD += pData.getPubInstEdYYYY();
		}
		if(!StringUtils.isEmpty(pData.getPubInstEdMM())) {
			pubInstEdYMD += ("/" + pData.getPubInstEdMM());
		}
		if(!StringUtils.isEmpty(pData.getPubInstEdDD())) {
			pubInstEdYMD += ("/" + pData.getPubInstEdDD());
		}
		pData.setPubInstEdYMD(pubInstEdYMD);
		pData.setPubInstPositionCd(StringUtils.nvlUpd(pEntity.getPubInstPositionCd(), ""));
		pData.setPubInstPositionNm(StringUtils.nvlUpd(pEntity.getPubInstPositionNm(), ""));
		pData.setPubInstposStYYYY(StringUtils.nvlUpd(pEntity.getPubInstposStYYYY(), ""));
		pData.setPubInstposStMM(StringUtils.nvlUpd(pEntity.getPubInstposStMM(), ""));
		pData.setPubInstposStDD(StringUtils.nvlUpd(pEntity.getPubInstposStDD(), ""));
		String pubInstposStYMD = "";
		if(!StringUtils.isEmpty(pData.getPubInstposStYYYY())) {
			pubInstposStYMD += pData.getPubInstposStYYYY();
		}
		if(!StringUtils.isEmpty(pData.getPubInstposStMM())) {
			pubInstposStYMD += ("/" + pData.getPubInstposStMM());
		}
		if(!StringUtils.isEmpty(pData.getPubInstposStDD())) {
			pubInstposStYMD += ("/" + pData.getPubInstposStDD());
		}
		pData.setPubInstposStYMD(pubInstposStYMD);
		pData.setPubInstposEdYYYY(StringUtils.nvlUpd(pEntity.getPubInstposEdYYYY(), ""));
		pData.setPubInstposEdMM(StringUtils.nvlUpd(pEntity.getPubInstposEdMM(), ""));
		pData.setPubInstposEdDD(StringUtils.nvlUpd(pEntity.getPubInstposEdDD(), ""));
		String pubInstposEdYMD = "";
		if(!StringUtils.isEmpty(pData.getPubInstposEdYYYY())) {
			pubInstposEdYMD += pData.getPubInstposEdYYYY();
		}
		if(!StringUtils.isEmpty(pData.getPubInstposEdMM())) {
			pubInstposEdYMD += ("/" + pData.getPubInstposEdMM());
		}
		if(!StringUtils.isEmpty(pData.getPubInstposEdDD())) {
			pubInstposEdYMD += ("/" + pData.getPubInstposEdDD());
		}
		pData.setPubInstposEdYMD(pubInstposEdYMD);
	}

	private void setHcpSocietyData(SelectHcpSocietyDataEntity sEntity, HcpSocietyData sData) {
		sData.setMedicalSocietyNm(StringUtils.nvl(sEntity.getMedicalSocietyNm(), ""));
		sData.setAdmissionYYYY(StringUtils.nvlUpd(sEntity.getAdmissionYYYY(), ""));
		sData.setAdmissionMM(StringUtils.nvlUpd(sEntity.getAdmissionMM(), ""));
		sData.setAdmissionDD(StringUtils.nvlUpd(sEntity.getAdmissionDD(), ""));
		String admissionYMD = "";
		if(!StringUtils.isEmpty(sData.getAdmissionYYYY())) {
			admissionYMD += sData.getAdmissionYYYY();
		}
		if(!StringUtils.isEmpty(sData.getAdmissionMM())) {
			admissionYMD += ("/" + sData.getAdmissionMM());
		}
		if(!StringUtils.isEmpty(sData.getAdmissionDD())) {
			admissionYMD += ("/" + sData.getAdmissionDD());
		}
		sData.setAdmissionYMD(admissionYMD);
		sData.setQuitYYYY(StringUtils.nvlUpd(sEntity.getQuitYYYY(), ""));
		sData.setQuitMM(StringUtils.nvlUpd(sEntity.getQuitMM(), ""));
		sData.setQuitDD(StringUtils.nvlUpd(sEntity.getQuitDD(), ""));
		String quitYMD = "";
		if(!StringUtils.isEmpty(sData.getQuitYYYY())) {
			quitYMD += sData.getQuitYYYY();
		}
		if(!StringUtils.isEmpty(sData.getQuitMM())) {
			quitYMD += ("/" + sData.getQuitMM());
		}
		if(!StringUtils.isEmpty(sData.getQuitDD())) {
			quitYMD += ("/" + sData.getQuitDD());
		}
		sData.setQuitYMD(quitYMD);
		sData.setPositionCode(StringUtils.nvlUpd(sEntity.getPositionCode(), ""));
		sData.setPositionName(StringUtils.nvlUpd(sEntity.getPositionName(), ""));
		sData.setSocietyPosiStYYYY(StringUtils.nvlUpd(sEntity.getSocietyPosiStYYYY(), ""));
		sData.setSocietyPosiStMM(StringUtils.nvlUpd(sEntity.getSocietyPosiStMM(), ""));
		sData.setSocietyPosiStDD(StringUtils.nvlUpd(sEntity.getSocietyPosiStDD(), ""));
		String societyPosiStYMD = "";
		if(!StringUtils.isEmpty(sData.getSocietyPosiStYYYY())) {
			societyPosiStYMD += sData.getSocietyPosiStYYYY();
		}
		if(!StringUtils.isEmpty(sData.getSocietyPosiStMM())) {
			societyPosiStYMD += ("/" + sData.getSocietyPosiStMM());
		}
		if(!StringUtils.isEmpty(sData.getSocietyPosiStDD())) {
			societyPosiStYMD += ("/" + sData.getSocietyPosiStDD());
		}
		sData.setSocietyPosiStYMD(societyPosiStYMD);
		sData.setSocietyPosiEdYYYY(StringUtils.nvlUpd(sEntity.getSocietyPosiEdYYYY(), ""));
		sData.setSocietyPosiEdMM(StringUtils.nvlUpd(sEntity.getSocietyPosiEdMM(), ""));
		sData.setSocietyPosiEdDD(StringUtils.nvlUpd(sEntity.getSocietyPosiEdDD(), ""));
		String societyPosiEdYMD = "";
		if(!StringUtils.isEmpty(sData.getSocietyPosiEdYYYY())) {
			societyPosiEdYMD += sData.getSocietyPosiEdYYYY();
		}
		if(!StringUtils.isEmpty(sData.getSocietyPosiEdMM())) {
			societyPosiEdYMD += ("/" + sData.getSocietyPosiEdMM());
		}
		if(!StringUtils.isEmpty(sData.getSocietyPosiEdDD())) {
			societyPosiEdYMD += ("/" + sData.getSocietyPosiEdDD());
		}
		sData.setSocietyPosiEdYMD(societyPosiEdYMD);
		sData.setAdvisingDoctorCd(StringUtils.nvlUpd(sEntity.getAdvisingDoctorCd(), ""));
		sData.setAdvisingDoctorNm(StringUtils.nvlUpd(sEntity.getAdvisingDoctorNm(), ""));
		sData.setCoachingAcquisiYYYY(StringUtils.nvlUpd(sEntity.getCoachingAcquisiYYYY(), ""));
		sData.setCoachingAcquisiMM(StringUtils.nvlUpd(sEntity.getCoachingAcquisiMM(), ""));
		sData.setCoachingAcquisiDD(StringUtils.nvlUpd(sEntity.getCoachingAcquisiDD(), ""));
		String coachingAcquisiYMD = "";
		if(!StringUtils.isEmpty(sData.getCoachingAcquisiYYYY())) {
			coachingAcquisiYMD += sData.getCoachingAcquisiYYYY();
		}
		if(!StringUtils.isEmpty(sData.getCoachingAcquisiMM())) {
			coachingAcquisiYMD += ("/" + sData.getCoachingAcquisiMM());
		}
		if(!StringUtils.isEmpty(sData.getCoachingAcquisiDD())) {
			coachingAcquisiYMD += ("/" + sData.getCoachingAcquisiDD());
		}
		sData.setCoachingAcquisiYMD(coachingAcquisiYMD);
		sData.setCoachingStYYYY(StringUtils.nvlUpd(sEntity.getCoachingStYYYY(), ""));
		sData.setCoachingStMM(StringUtils.nvlUpd(sEntity.getCoachingStMM(), ""));
		sData.setCoachingStDD(StringUtils.nvlUpd(sEntity.getCoachingStDD(), ""));
		String coachingStYMD = "";
		if(!StringUtils.isEmpty(sData.getCoachingStYYYY())) {
			coachingStYMD += sData.getCoachingStYYYY();
		}
		if(!StringUtils.isEmpty(sData.getCoachingStMM())) {
			coachingStYMD += ("/" + sData.getCoachingStMM());
		}
		if(!StringUtils.isEmpty(sData.getCoachingStDD())) {
			coachingStYMD += ("/" + sData.getCoachingStDD());
		}
		sData.setCoachingStYMD(coachingStYMD);
		sData.setCoachingEdYYYY(StringUtils.nvlUpd(sEntity.getCoachingEdYYYY(), ""));
		sData.setCoachingEdMM(StringUtils.nvlUpd(sEntity.getCoachingEdMM(), ""));
		sData.setCoachingEdDD(StringUtils.nvlUpd(sEntity.getCoachingEdDD(), ""));
		String coachingEdYMD = "";
		if(!StringUtils.isEmpty(sData.getCoachingEdYYYY())) {
			coachingEdYMD += sData.getCoachingEdYYYY();
		}
		if(!StringUtils.isEmpty(sData.getCoachingEdMM())) {
			coachingEdYMD += ("/" + sData.getCoachingEdMM());
		}
		if(!StringUtils.isEmpty(sData.getCoachingEdDD())) {
			coachingEdYMD += ("/" + sData.getCoachingEdDD());
		}
		sData.setCoachingEdYMD(coachingEdYMD);
		sData.setCertifyingPhysicianCd(StringUtils.nvlUpd(sEntity.getCertifyingPhysicianCd(), ""));
		sData.setCertifyingPhysicianNm(StringUtils.nvlUpd(sEntity.getCertifyingPhysicianNm(), ""));
		sData.setCertifyStYYYY(StringUtils.nvlUpd(sEntity.getCertifyStYYYY(), ""));
		sData.setCertifyStMM(StringUtils.nvlUpd(sEntity.getCertifyStMM(), ""));
		sData.setCertifyStDD(StringUtils.nvlUpd(sEntity.getCertifyStDD(), ""));
		String certifyStYMD = "";
		if(!StringUtils.isEmpty(sData.getCertifyStYYYY())) {
			certifyStYMD += sData.getCertifyStYYYY();
		}
		if(!StringUtils.isEmpty(sData.getCertifyStMM())) {
			certifyStYMD += ("/" + sData.getCertifyStMM());
		}
		if(!StringUtils.isEmpty(sData.getCertifyStDD())) {
			certifyStYMD += ("/" + sData.getCertifyStDD());
		}
		sData.setCertifyStYMD(certifyStYMD);
		sData.setCertifyEdYYYY(StringUtils.nvlUpd(sEntity.getCertifyEdYYYY(), ""));
		sData.setCertifyEdMM(StringUtils.nvlUpd(sEntity.getCertifyEdMM(), ""));
		sData.setCertifyEdDD(StringUtils.nvlUpd(sEntity.getCertifyEdDD(), ""));
		String certifyEdYMD = "";
		if(!StringUtils.isEmpty(sData.getCertifyEdYYYY())) {
			certifyEdYMD += sData.getCertifyEdYYYY();
		}
		if(!StringUtils.isEmpty(sData.getCertifyEdMM())) {
			certifyEdYMD += ("/" + sData.getCertifyEdMM());
		}
		if(!StringUtils.isEmpty(sData.getCertifyEdDD())) {
			certifyEdYMD += ("/" + sData.getCertifyEdDD());
		}
		sData.setCertifyEdYMD(certifyEdYMD);
	}

	/**
	 * コンボ作成
	 * @param indto ND012DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(ND012DTO indto){
		//1-2-1     医師／薬剤師区分
		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//            コード名＝DOC_TYPE（医師／薬剤師区分）
		//            削除フラグ=0
		SelectComboListEntity inEntityCmb = new SelectComboListEntity();
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DOC_TYPE);
		List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapDocType = new LinkedHashMap<String, String>();
		mapDocType.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapDocType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setDocTypeCombo(mapDocType);

		//1-2-2     性別
		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//            コード名＝MF（性別）
		//            削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MF);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapMF = new LinkedHashMap<String, String>();
		mapMF.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapMF.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
		}
		indto.setSexCdCombo(mapMF);
		//1-2-3     改姓日
		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
		//            年      現在日付の年+1年～－100年
		//            月      01～12
		//            日      01～31
		MRdmComCalUsrEntity inEntityYearCmb = new MRdmComCalUsrEntity();
		inEntityYearCmb.setToday("1");
		MRdmComCalUsrEntity outCalUsr = dao.selectByValue(inEntityYearCmb).get(0);
		int yearInt = Integer.parseInt(outCalUsr.getCalYear());
		LinkedHashMap<String, String> mapYear = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> mapYearNow = new LinkedHashMap<String, String>();
		mapYear.put("", "");
		mapYearNow.put("", "");
		for (int i = 0; i < 101; i++) {
			String yearStr = Integer.toString(yearInt + 1 - i);
			String yearStrNow = Integer.toString(yearInt - i);
			mapYear.put(yearStr, yearStr);
			mapYearNow.put(yearStrNow, yearStrNow);
		}
		indto.setNewNameStYearCombo(mapYear);

		LinkedHashMap<String, String> mapMonth = new LinkedHashMap<String, String>();
		mapMonth.put("", "");
		for (int i = 0; i < 12; i++) {
			String monthStr = String.format("%02d", (i+1));
			mapMonth.put(monthStr, monthStr);
		}
		indto.setNewNameStMonthCombo(mapMonth);

		LinkedHashMap<String, String> mapDay = new LinkedHashMap<String, String>();
		mapDay.put("", "");
		for (int i = 0; i < 31; i++) {
			String dayStr = String.format("%02d", (i+1));
			mapDay.put(dayStr, dayStr);
		}
		indto.setNewNameStDayCombo(mapDay);

		//1-2-4     生年月日
		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
		//            年      現在日付の年+1年～－100年
		//            月      01～12
		//            日      01～31
		indto.setDobYearCombo(mapYear);
		indto.setDobMonthCombo(mapMonth);
		indto.setDobDayCombo(mapDay);

		//1-2-5     出身地
		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//            コード名＝HOME_TOWN（出身地）
		//            削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HOME_TOWN);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapHomeTown = new LinkedHashMap<String, String>();
		mapHomeTown.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapHomeTown.put(outEntity.getValue(), outEntity.getValueKanji());
		}
		indto.setHomeTownCdCombo(mapHomeTown);
		//1-2-6     出身校              「補足_出身医局校_出身校リスト」シート参照
		//医師_出身大学マスタから下記条件で「武田出身大学コード：出身大学漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
		//        出身校利用フラグ=1
		//        削除フラグ=0
		MRdmHcpShusshinkoEntity inEntitySskCmb = new MRdmHcpShusshinkoEntity();
		inEntitySskCmb.setUnivFlg(1);
		inEntitySskCmb.setDelFlg(0);
		List<MRdmHcpShusshinkoEntity> outMainSskList = dao.selectByValue(inEntitySskCmb);
		LinkedHashMap<String, String> mapMedSchoolCd = new LinkedHashMap<String, String>();
		mapMedSchoolCd.put("", "--なし--");
		for (MRdmHcpShusshinkoEntity outEntity : outMainSskList) {
			mapMedSchoolCd.put(outEntity.getUnivCode(), outEntity.getUnivKj());
		}
		indto.setMedSchoolCdCombo(mapMedSchoolCd);

		//1-2-7     卒年（西暦）
		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
		//            年      現在日付の年+1年～－100年
		indto.setGradYearCombo(mapYearNow);

		//1-2-8     臨床研修年（西暦）
		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
		//            年      現在日付の年+1年～－100年
		indto.setEmplYearCombo(mapYearNow);

		//1-2-9     出身医局校                  「補足_出身医局校_出身校リスト」シート参照
		//医師_出身大学マスタから下記条件で「武田出身大学コード：出身大学漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
		//        出身医局校利用フラグ=1
		//        削除フラグ=0
		inEntitySskCmb.setUnivIkkFlg(1);
		inEntitySskCmb.setDelFlg(0);
		outMainSskList.clear();
		outMainSskList = dao.selectByValue(inEntitySskCmb);
		LinkedHashMap<String, String> mapHomeUnivCd = new LinkedHashMap<String, String>();
		mapHomeUnivCd.put("", "--なし--");
		for (MRdmHcpShusshinkoEntity outEntity : outMainSskList) {
			mapHomeUnivCd.put(outEntity.getUnivCode(), outEntity.getUnivKj());
		}
		indto.setHomeUnivCdCombo(mapHomeUnivCd);
		//1-2-10    専門臓器                「専門臓器一覧」シート参照
		//医師_専門臓器マスタから下記条件で「専門臓器コード：専門臓器漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
		//        削除フラグ=0
		MRdmHcpSpLiverEntity inEntitySLiCmb = new MRdmHcpSpLiverEntity();
		inEntitySLiCmb.setDelFlg(0);
		List<MRdmHcpSpLiverEntity> outMainSLiList = dao.selectByValue(inEntitySLiCmb);
		LinkedHashMap<String, String> mapSpLiverCd = new LinkedHashMap<String, String>();
		mapSpLiverCd.put("", "--なし--");
		for (MRdmHcpSpLiverEntity outEntity : outMainSLiList) {
			mapSpLiverCd.put(outEntity.getSpLiver(), outEntity.getSpLiverKj());
		}
		indto.setSpLiverCdCombo(mapSpLiverCd);

		//1-2-11    専門詳細                「専門詳細一覧」シート参照
		//医師_専門詳細マスタから下記条件で「専門詳細コード：専門詳細漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
		//        削除フラグ=0
		MRdmHcpSpDiseaseEntity inEntitySDiCmb = new MRdmHcpSpDiseaseEntity();
		inEntitySDiCmb.setDelFlg(0);
		List<MRdmHcpSpDiseaseEntity> outMainSDiList = dao.selectByValue(inEntitySDiCmb);
		LinkedHashMap<String, String> mapSpDiseaseCd = new LinkedHashMap<String, String>();
		mapSpDiseaseCd.put("", "--なし--");
		for (MRdmHcpSpDiseaseEntity outEntity : outMainSDiList) {
			mapSpDiseaseCd.put(outEntity.getSpDisease(), outEntity.getSpDiseaseKj());
		}
		indto.setSpDiseaseCdCombo(mapSpDiseaseCd);

//		//1-2-12    大学職位
//		//医師_役職マスタから下記条件で「武田役職コード：役職漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
//		//        大学職位利用フラグ=1
//		//        削除フラグ=0
//		MRdmHcpYakushokuEntity inEntityPosCmb = new MRdmHcpYakushokuEntity();
//		inEntityPosCmb.setUnivTitleFlg(1);
//		inEntityPosCmb.setDelFlg(0);
//		List<MRdmHcpYakushokuEntity> outMainPosList = dao.selectByValue(inEntityPosCmb);
//		LinkedHashMap<String, String> mapSkUnivPosCd = new LinkedHashMap<String, String>();
//		mapSkUnivPosCd.put("", "--なし--");
//		for (MRdmHcpYakushokuEntity outEntity : outMainPosList) {
//			mapSkUnivPosCd.put(outEntity.getTitleCode(), outEntity.getTitleKj());
//		}
//		indto.setSkUnivPosCdCombo(mapSkUnivPosCd);
//
//		//1-2-13    役職
//		//医師_役職マスタから下記条件で「武田役職コード：役職漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
//		//        大学職位利用フラグ=0
//		//        削除フラグ=0
//		inEntityPosCmb.setUnivTitleFlg(0);
//		inEntityPosCmb.setDelFlg(0);
//		outMainPosList.clear();
//		outMainPosList = dao.selectByValue(inEntityPosCmb);
//		LinkedHashMap<String, String> mapSkTitleCd = new LinkedHashMap<String, String>();
//		mapSkTitleCd.put("", "--なし--");
//		for (MRdmHcpYakushokuEntity outEntity : outMainPosList) {
//			mapSkTitleCd.put(outEntity.getTitleCode(), outEntity.getTitleKj());
//		}
//		indto.setSkTitleCdCombo(mapSkTitleCd);
//
//		//1-2-14    勤務形態
//		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
//		//            コード名＝JOB_FORM（勤務形態）
//		//            削除フラグ=0
//		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_JOB_FORM);
//		outMainList.clear();
//		outMainList = dao.select(inEntityCmb);
//		LinkedHashMap<String, String> mapJobForm = new LinkedHashMap<String, String>();
//		mapJobForm.put("", "--なし--");
//		for (SelectComboListEntity outEntity : outMainList) {
//			mapJobForm.put(outEntity.getValue(), outEntity.getValueKanji());
//		}
//		indto.setSkJobFormCombo(mapJobForm);
//
//		//1-2-15    薬審メンバー区分
//		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
//		//            コード名＝DCC（薬審メンバー区分）
//		//            削除フラグ=0
//		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DCC);
//		outMainList.clear();
//		outMainList = dao.select(inEntityCmb);
//		LinkedHashMap<String, String> mapDCC = new LinkedHashMap<String, String>();
//		mapDCC.put("", "--なし--");
//		for (SelectComboListEntity outEntity : outMainList) {
//			mapDCC.put(outEntity.getValue(), outEntity.getValueKanji());
//		}
//		indto.setSkDcctypeCombo(mapDCC);
	}
	/**
	 * イベント処理
	 * @param indto ND012DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(ND012DTO indto) {
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
				// パラメタ医師勤務先メニュー取得
				indto.setBtnEnableFlg("0");
				MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
				mRdmParamMstEntity.setParamName(jp.co.takeda.rdm.util.RdmConstantsData.PARAM_NAME_MN_KMU);
				mRdmParamMstEntity.setDelFlg("0");
				List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
				if(mRdmParamMstEntityList.size() > 0) {
					String value = mRdmParamMstEntityList.get(0).getValue();
					if(!"000".equals(value)) {
						// 申請・承認・却下ボタン活性
						indto.setBtnEnableFlg("1");
					}
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
				// パラメタ医師勤務先メニュー取得
				indto.setBtnEnableFlg("0");
				MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
				mRdmParamMstEntity.setParamName(jp.co.takeda.rdm.util.RdmConstantsData.PARAM_NAME_MN_KMU);
				mRdmParamMstEntity.setDelFlg("0");
				List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
				if(mRdmParamMstEntityList.size() > 0) {
					String value = mRdmParamMstEntityList.get(0).getValue();
					if(!"000".equals(value)) {
						// 申請・承認・却下ボタン活性
						indto.setBtnEnableFlg("1");
					}
				}
				return outdto;
			}
		}
//		if ("0".equals(indto.getButtonFlg()) || "1".equals(indto.getButtonFlg()) ) {
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
				// 変更前と比較し同一ならNULL、""に変更なら"Z"、それ以外に変更なら変更後の値をセット
				updateEntity2.setDocType(getUpdStr(indto.getDocType(),indto.getMstDocType()));//医師／薬剤師区分
				updateEntity2.setDocKanj(getUpdStr((indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei()), (indto.getMstDocKanjiSei() + "　" + indto.getMstDocKanjiMei())));//氏名（漢字）
				updateEntity2.setDocKana(getUpdStr((indto.getDocKanaSei()  + " " + indto.getDocKanaMei()), (indto.getMstDocKanaSei()  + " " + indto.getMstDocKanaMei())));//氏名（カナ）
				updateEntity2.setDocKanjiSei(getUpdStr(indto.getDocKanjiSei(), indto.getMstDocKanjiSei()));//氏名（漢字）姓
				updateEntity2.setDocKanjiMei(getUpdStr(indto.getDocKanjiMei(), indto.getMstDocKanjiMei()));//氏名（漢字）名
				updateEntity2.setDocKanaSei(getUpdStr(indto.getDocKanaSei(), indto.getMstDocKanaSei()));//氏名（カナ）姓
				updateEntity2.setDocKanaMei(getUpdStr(indto.getDocKanaMei(), indto.getMstDocKanaMei()));//氏名（カナ）名
				updateEntity2.setOldKanjSei(getUpdStr(indto.getOldKanjSei(), indto.getMstOldKanjSei()));//氏名（漢字）旧姓
				updateEntity2.setOldKanaSei(getUpdStr(indto.getOldKanaSei(), indto.getMstOldKanaSei()));//氏名（カナ）旧姓
				updateEntity2.setNewNameStYear(getUpdStr(indto.getNewNameStYear(), indto.getMstNewNameStYear()));//改姓日（年）
				updateEntity2.setNewNameStMonth(getUpdStr(indto.getNewNameStMonth(), indto.getMstNewNameStMonth()));//改姓日（月）
				updateEntity2.setNewNameStDay(getUpdStr(indto.getNewNameStDay(), indto.getMstNewNameStDay()));//改姓日（日）
				updateEntity2.setDobYear(getUpdStr(indto.getDobYear(), indto.getMstDobYear()));//生年月日（年）
				updateEntity2.setDobMonth(getUpdStr(indto.getDobMonth(), indto.getMstDobMonth()));//生年月日（月）
				updateEntity2.setDobDay(getUpdStr(indto.getDobDay(), indto.getMstDobDay()));//生年月日（日）
				updateEntity2.setSexCd(getUpdStr(indto.getSexCd(), indto.getMstSexCd()));//性別区分
				updateEntity2.setHomeTownCd(getUpdStr(indto.getHomeTownCd(), indto.getMstHomeTownCd()));//出身地コード
				updateEntity2.setMedSchoolCd(getUpdStr(indto.getMedSchoolCd(), indto.getMstMedSchoolCd()));//出身校コード
				updateEntity2.setGradYear(getUpdStr(indto.getGradYear(), indto.getMstGradYear()));//卒年
				updateEntity2.setHomeDeptCd(getUpdStr(indto.getHomeDeptCd(), indto.getMstHomeDeptCd()));//出身所属コード
				updateEntity2.setHomeUnivCd(getUpdStr(indto.getHomeUnivCd(), indto.getMstHomeUnivCd()));//出身医局校コード
				updateEntity2.setEmplYear(getUpdStr(indto.getEmplYear(), indto.getMstEmplYear()));//臨床研修年
				updateEntity2.setSpLiverCd(getUpdStr(indto.getSpLiverCd(), indto.getMstSpLiverCd()));//専門臓器コード
				updateEntity2.setSpDiseaseCd(getUpdStr(indto.getSpDiseaseCd(), indto.getMstSpDiseaseCd()));//専門詳細コード
				updateEntity2.setSpCom(getUpdStr(indto.getSpCom(), indto.getMstSpCom()));//専門追加情報

				updateEntity2.setUpdShaYmd(currentDt);//更新日
				updateEntity2.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				updateEntity2.checkSetNull();
				dao.update(updateEntity2);

				////所属学会//////////////////////////////////////////////////////////////////////////////////////////////
				List<HcpSocietyData> societyDataList = indto.getHcpSocietyDataList();
				UpdateTRdmHcpSocietyReqEntity updateEntity3 = new UpdateTRdmHcpSocietyReqEntity();
				updateEntity3.setReqId(indto.getReqId());//申請ID
				updateEntity3.setUpdShaYmd(currentDt);//更新日
				updateEntity3.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者

				TRdmHcpSocietyReqEntity ketEntity1 = new TRdmHcpSocietyReqEntity();
				MRdmHcpSocietyEntity mstEntity1 = new MRdmHcpSocietyEntity();
				MRdmHcpSocietyEntity mstOutEntity1 = new MRdmHcpSocietyEntity();
				ketEntity1.setReqId(indto.getReqId());//申請ID
				mstEntity1.setDocNo(indto.getTkdDocNo());
				for (HcpSocietyData sData : societyDataList) {
					//キーで検索
					if(sData.getMedicalSocietyNm() != null) {//iteratorの影響か1行nullのデータが入っているのではじく
						ketEntity1.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
						mstEntity1.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
						TRdmHcpSocietyReqEntity keyOutEntity1 = new TRdmHcpSocietyReqEntity();
						keyOutEntity1 = dao.selectByPK(ketEntity1);
						if(keyOutEntity1 == null) {
							//データなしは新規登録
							TRdmHcpSocietyReqEntity insEntity3 = new TRdmHcpSocietyReqEntity();
							insEntity3.setReqId(indto.getReqId());//申請ID
							insEntity3.setInsShaYmd(currentDt);//作成日
							insEntity3.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
							insEntity3.setUpdShaYmd(currentDt);//更新日
							insEntity3.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
							insEntity3.setDocNo(StringUtils.setEmptyToNull(indto.getTkdDocNo()));//医師固定コード
							insEntity3.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
							//マスタにあるか判定
							mstOutEntity1 = dao.selectByPK(mstEntity1);
							if(mstOutEntity1 == null) {
								insEntity3.setAdmissionYYYY(StringUtils.setEmptyToNull(sData.getAdmissionYYYY()));//入会年月日(年)
								insEntity3.setAdmissionMM(StringUtils.setEmptyToNull(sData.getAdmissionMM()));//入会年月日(月)
								insEntity3.setAdmissionDD(StringUtils.setEmptyToNull(sData.getAdmissionDD()));//入会年月日(日)
								insEntity3.setQuitYYYY(StringUtils.setEmptyToNull(sData.getQuitYYYY()));//脱会年月日(年)
								insEntity3.setQuitMM(StringUtils.setEmptyToNull(sData.getQuitMM()));//脱会年月日(月)
								insEntity3.setQuitDD(StringUtils.setEmptyToNull(sData.getQuitDD()));//脱会年月日(日)
								insEntity3.setPositionCode(StringUtils.setEmptyToNull(sData.getPositionCode()));//所属役職
								insEntity3.setSocietyPosiStYYYY(StringUtils.setEmptyToNull(sData.getSocietyPosiStYYYY()));//役職開始年月日(年)
								insEntity3.setSocietyPosiStMM(StringUtils.setEmptyToNull(sData.getSocietyPosiStMM()));//役職開始年月日(月)
								insEntity3.setSocietyPosiStDD(StringUtils.setEmptyToNull(sData.getSocietyPosiStDD()));//役職開始年月日(日)
								insEntity3.setSocietyPosiEdYYYY(StringUtils.setEmptyToNull(sData.getSocietyPosiEdYYYY()));//役職終了年月日(年)
								insEntity3.setSocietyPosiEdMM(StringUtils.setEmptyToNull(sData.getSocietyPosiEdMM()));//役職終了年月日(月)
								insEntity3.setSocietyPosiEdDD(StringUtils.setEmptyToNull(sData.getSocietyPosiEdDD()));//役職終了年月日(日)
								insEntity3.setAdvisingDoctorCd(StringUtils.setEmptyToNull(sData.getAdvisingDoctorCd()));//所属学会指導医区分
								insEntity3.setCoachingAcquisiYYYY(StringUtils.setEmptyToNull(sData.getCoachingAcquisiYYYY()));//指導医取得年月日(年)
								insEntity3.setCoachingAcquisiMM(StringUtils.setEmptyToNull(sData.getCoachingAcquisiMM()));//指導医取得年月日(月)
								insEntity3.setCoachingAcquisiDD(StringUtils.setEmptyToNull(sData.getCoachingAcquisiDD()));//指導医取得年月日(日)
								insEntity3.setCoachingStYYYY(StringUtils.setEmptyToNull(sData.getCoachingStYYYY()));//指導医開始年月日(年)
								insEntity3.setCoachingStMM(StringUtils.setEmptyToNull(sData.getCoachingStMM()));//指導医開始年月日(月)
								insEntity3.setCoachingStDD(StringUtils.setEmptyToNull(sData.getCoachingStDD()));//指導医開始年月日(日)
								insEntity3.setCoachingEdYYYY(StringUtils.setEmptyToNull(sData.getCoachingEdYYYY()));//指導医終了年月日(年)
								insEntity3.setCoachingEdMM(StringUtils.setEmptyToNull(sData.getCoachingEdMM()));//指導医終了年月日(月)
								insEntity3.setCoachingEdDD(StringUtils.setEmptyToNull(sData.getCoachingEdDD()));//指導医終了年月日(日)
								insEntity3.setCertifyingPhysicianCd(StringUtils.setEmptyToNull(sData.getCertifyingPhysicianCd()));//所属学会認定医区分
								insEntity3.setCertifyStYYYY(StringUtils.setEmptyToNull(sData.getCertifyStYYYY()));//認定医開始年月日(年)
								insEntity3.setCertifyStMM(StringUtils.setEmptyToNull(sData.getCertifyStMM()));//認定医開始年月日(月)
								insEntity3.setCertifyStDD(StringUtils.setEmptyToNull(sData.getCertifyStDD()));//認定医開始年月日(日)
								insEntity3.setCertifyEdYYYY(StringUtils.setEmptyToNull(sData.getCertifyEdYYYY()));//認定医終了年月日(年)
								insEntity3.setCertifyEdMM(StringUtils.setEmptyToNull(sData.getCertifyEdMM()));//認定医終了年月日(月)
								insEntity3.setCertifyEdDD(StringUtils.setEmptyToNull(sData.getCertifyEdDD()));//認定医終了年月日(日)
							}else {
								//マスタ値ありなら変更判定して入れる
								insEntity3.setAdmissionYYYY(getUpdStr(sData.getAdmissionYYYY(),StringUtils.nvl(mstOutEntity1.getAdmissionYYYY(), "")));//入会年月日(年)
								insEntity3.setAdmissionMM(getUpdStr(sData.getAdmissionMM(),StringUtils.nvl(mstOutEntity1.getAdmissionMM(), "")));//入会年月日(月)
								insEntity3.setAdmissionDD(getUpdStr(sData.getAdmissionDD(),StringUtils.nvl(mstOutEntity1.getAdmissionDD(), "")));//入会年月日(日)
								insEntity3.setQuitYYYY(getUpdStr(sData.getQuitYYYY(),StringUtils.nvl(mstOutEntity1.getQuitYYYY(), "")));//脱会年月日(年)
								insEntity3.setQuitMM(getUpdStr(sData.getQuitMM(),StringUtils.nvl(mstOutEntity1.getQuitMM(), "")));//脱会年月日(月)
								insEntity3.setQuitDD(getUpdStr(sData.getQuitDD(),StringUtils.nvl(mstOutEntity1.getQuitDD(), "")));//脱会年月日(日)
								insEntity3.setPositionCode(getUpdStr(sData.getPositionCode(),StringUtils.nvl(mstOutEntity1.getPositionCode(), "")));//所属役職
								insEntity3.setSocietyPosiStYYYY(getUpdStr(sData.getSocietyPosiStYYYY(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStYYYY(), "")));//役職開始年月日(年)
								insEntity3.setSocietyPosiStMM(getUpdStr(sData.getSocietyPosiStMM(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStMM(), "")));//役職開始年月日(月)
								insEntity3.setSocietyPosiStDD(getUpdStr(sData.getSocietyPosiStDD(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStDD(), "")));//役職開始年月日(日)
								insEntity3.setSocietyPosiEdYYYY(getUpdStr(sData.getSocietyPosiEdYYYY(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdYYYY(), "")));//役職終了年月日(年)
								insEntity3.setSocietyPosiEdMM(getUpdStr(sData.getSocietyPosiEdMM(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdMM(), "")));//役職終了年月日(月)
								insEntity3.setSocietyPosiEdDD(getUpdStr(sData.getSocietyPosiEdDD(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdDD(), "")));//役職終了年月日(日)
								insEntity3.setAdvisingDoctorCd(getUpdStr(sData.getAdvisingDoctorCd(),StringUtils.nvl(mstOutEntity1.getAdvisingDoctorCd(), "")));//所属学会指導医区分
								insEntity3.setCoachingAcquisiYYYY(getUpdStr(sData.getCoachingAcquisiYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiYYYY(), "")));//指導医取得年月日(年)
								insEntity3.setCoachingAcquisiMM(getUpdStr(sData.getCoachingAcquisiMM(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiMM(), "")));//指導医取得年月日(月)
								insEntity3.setCoachingAcquisiDD(getUpdStr(sData.getCoachingAcquisiDD(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiDD(), "")));//指導医取得年月日(日)
								insEntity3.setCoachingStYYYY(getUpdStr(sData.getCoachingStYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingStYYYY(), "")));//指導医開始年月日(年)
								insEntity3.setCoachingStMM(getUpdStr(sData.getCoachingStMM(),StringUtils.nvl(mstOutEntity1.getCoachingStMM(), "")));//指導医開始年月日(月)
								insEntity3.setCoachingStDD(getUpdStr(sData.getCoachingStDD(),StringUtils.nvl(mstOutEntity1.getCoachingStDD(), "")));//指導医開始年月日(日)
								insEntity3.setCoachingEdYYYY(getUpdStr(sData.getCoachingEdYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingEdYYYY(), "")));//指導医終了年月日(年)
								insEntity3.setCoachingEdMM(getUpdStr(sData.getCoachingEdMM(),StringUtils.nvl(mstOutEntity1.getCoachingEdMM(), "")));//指導医終了年月日(月)
								insEntity3.setCoachingEdDD(getUpdStr(sData.getCoachingEdDD(),StringUtils.nvl(mstOutEntity1.getCoachingEdDD(), "")));//指導医終了年月日(日)
								insEntity3.setCertifyingPhysicianCd(getUpdStr(sData.getCertifyingPhysicianCd(),StringUtils.nvl(mstOutEntity1.getCertifyingPhysicianCd(), "")));//所属学会認定医区分
								insEntity3.setCertifyStYYYY(getUpdStr(sData.getCertifyStYYYY(),StringUtils.nvl(mstOutEntity1.getCertifyStYYYY(), "")));//認定医開始年月日(年)
								insEntity3.setCertifyStMM(getUpdStr(sData.getCertifyStMM(),StringUtils.nvl(mstOutEntity1.getCertifyStMM(), "")));//認定医開始年月日(月)
								insEntity3.setCertifyStDD(getUpdStr(sData.getCertifyStDD(),StringUtils.nvl(mstOutEntity1.getCertifyStDD(), "")));//認定医開始年月日(日)
								insEntity3.setCertifyEdYYYY(getUpdStr(sData.getCertifyEdYYYY(),StringUtils.nvl(mstOutEntity1.getCertifyEdYYYY(), "")));//認定医終了年月日(年)
								insEntity3.setCertifyEdMM(getUpdStr(sData.getCertifyEdMM(),StringUtils.nvl(mstOutEntity1.getCertifyEdMM(), "")));//認定医終了年月日(月)
								insEntity3.setCertifyEdDD(getUpdStr(sData.getCertifyEdDD(),StringUtils.nvl(mstOutEntity1.getCertifyEdDD(), "")));//認定医終了年月日(日)
							}
							dao.insertByValue(insEntity3);
						}else {
							//ありなら変更チェック
							boolean checkSoc = checkSocietyData(sData,keyOutEntity1);
							if(checkSoc == false) {
								//変更ありなら排他チェック
								UpdateTRdmHcpSocietyReqEntity selectUpdateEntity3 = new UpdateTRdmHcpSocietyReqEntity();
								selectUpdateEntity3.setSqlId("selectUpDate");
								selectUpdateEntity3.setReqId(indto.getReqId());
								selectUpdateEntity3.setMedicalSocietyNm(sData.getMedicalSocietyNm());
								//ロック処理
								List<UpdateTRdmHcpSocietyReqEntity> outEntity3 = new ArrayList<UpdateTRdmHcpSocietyReqEntity>();
								try {
									//SQL実行
									outEntity3 = dao.select(selectUpdateEntity3);
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

								if (outEntity3 == null || outEntity3.size() == 0){
									//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
									indto.setMsgId(RdmConstantsData.E003);
									indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
									return outdto;
								} else {
									if (outEntity3.get(0).getUpdShaYmd().compareTo(dtoUpdShaYmddate) > 0) {
										//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
										indto.setMsgId(RdmConstantsData.E003);
										indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
										return outdto;
									}
								}
								//エラーなしなら更新
								updateEntity3.setSqlId("updateData");
								updateEntity3.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
								updateEntity3.setUpdShaYmd(currentDt);//更新日
								updateEntity3.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
								//マスタにあるか判定
								mstOutEntity1 = dao.selectByPK(mstEntity1);
								if(mstOutEntity1 == null) {
									//マスタ値なしならそのまま画面の値いれる
									updateEntity3.setAdmissionYYYY(StringUtils.setEmptyToNull(sData.getAdmissionYYYY()));//入会年月日(年)
									updateEntity3.setAdmissionMM(StringUtils.setEmptyToNull(sData.getAdmissionMM()));//入会年月日(月)
									updateEntity3.setAdmissionDD(StringUtils.setEmptyToNull(sData.getAdmissionDD()));//入会年月日(日)
									updateEntity3.setQuitYYYY(StringUtils.setEmptyToNull(sData.getQuitYYYY()));//脱会年月日(年)
									updateEntity3.setQuitMM(StringUtils.setEmptyToNull(sData.getQuitMM()));//脱会年月日(月)
									updateEntity3.setQuitDD(StringUtils.setEmptyToNull(sData.getQuitDD()));//脱会年月日(日)
									updateEntity3.setPositionCode(StringUtils.setEmptyToNull(sData.getPositionCode()));//所属役職
									updateEntity3.setSocietyPosiStYYYY(StringUtils.setEmptyToNull(sData.getSocietyPosiStYYYY()));//役職開始年月日(年)
									updateEntity3.setSocietyPosiStMM(StringUtils.setEmptyToNull(sData.getSocietyPosiStMM()));//役職開始年月日(月)
									updateEntity3.setSocietyPosiStDD(StringUtils.setEmptyToNull(sData.getSocietyPosiStDD()));//役職開始年月日(日)
									updateEntity3.setSocietyPosiEdYYYY(StringUtils.setEmptyToNull(sData.getSocietyPosiEdYYYY()));//役職終了年月日(年)
									updateEntity3.setSocietyPosiEdMM(StringUtils.setEmptyToNull(sData.getSocietyPosiEdMM()));//役職終了年月日(月)
									updateEntity3.setSocietyPosiEdDD(StringUtils.setEmptyToNull(sData.getSocietyPosiEdDD()));//役職終了年月日(日)
									updateEntity3.setAdvisingDoctorCd(StringUtils.setEmptyToNull(sData.getAdvisingDoctorCd()));//所属学会指導医区分
									updateEntity3.setCoachingAcquisiYYYY(StringUtils.setEmptyToNull(sData.getCoachingAcquisiYYYY()));//指導医取得年月日(年)
									updateEntity3.setCoachingAcquisiMM(StringUtils.setEmptyToNull(sData.getCoachingAcquisiMM()));//指導医取得年月日(月)
									updateEntity3.setCoachingAcquisiDD(StringUtils.setEmptyToNull(sData.getCoachingAcquisiDD()));//指導医取得年月日(日)
									updateEntity3.setCoachingStYYYY(StringUtils.setEmptyToNull(sData.getCoachingStYYYY()));//指導医開始年月日(年)
									updateEntity3.setCoachingStMM(StringUtils.setEmptyToNull(sData.getCoachingStMM()));//指導医開始年月日(月)
									updateEntity3.setCoachingStDD(StringUtils.setEmptyToNull(sData.getCoachingStDD()));//指導医開始年月日(日)
									updateEntity3.setCoachingEdYYYY(StringUtils.setEmptyToNull(sData.getCoachingEdYYYY()));//指導医終了年月日(年)
									updateEntity3.setCoachingEdMM(StringUtils.setEmptyToNull(sData.getCoachingEdMM()));//指導医終了年月日(月)
									updateEntity3.setCoachingEdDD(StringUtils.setEmptyToNull(sData.getCoachingEdDD()));//指導医終了年月日(日)
									updateEntity3.setCertifyingPhysicianCd(StringUtils.setEmptyToNull(sData.getCertifyingPhysicianCd()));//所属学会認定医区分
									updateEntity3.setCertifyStYYYY(StringUtils.setEmptyToNull(sData.getCertifyStYYYY()));//認定医開始年月日(年)
									updateEntity3.setCertifyStMM(StringUtils.setEmptyToNull(sData.getCertifyStMM()));//認定医開始年月日(月)
									updateEntity3.setCertifyStDD(StringUtils.setEmptyToNull(sData.getCertifyStDD()));//認定医開始年月日(日)
									updateEntity3.setCertifyEdYYYY(StringUtils.setEmptyToNull(sData.getCertifyEdYYYY()));//認定医終了年月日(年)
									updateEntity3.setCertifyEdMM(StringUtils.setEmptyToNull(sData.getCertifyEdMM()));//認定医終了年月日(月)
									updateEntity3.setCertifyEdDD(StringUtils.setEmptyToNull(sData.getCertifyEdDD()));//認定医終了年月日(日)
								} else {
									//マスタ値ありなら変更判定して入れる
									updateEntity3.setAdmissionYYYY(getUpdStr(sData.getAdmissionYYYY(),StringUtils.nvl(mstOutEntity1.getAdmissionYYYY(), "")));//入会年月日(年)
									updateEntity3.setAdmissionMM(getUpdStr(sData.getAdmissionMM(),StringUtils.nvl(mstOutEntity1.getAdmissionMM(), "")));//入会年月日(月)
									updateEntity3.setAdmissionDD(getUpdStr(sData.getAdmissionDD(),StringUtils.nvl(mstOutEntity1.getAdmissionDD(), "")));//入会年月日(日)
									updateEntity3.setQuitYYYY(getUpdStr(sData.getQuitYYYY(),StringUtils.nvl(mstOutEntity1.getQuitYYYY(), "")));//脱会年月日(年)
									updateEntity3.setQuitMM(getUpdStr(sData.getQuitMM(),StringUtils.nvl(mstOutEntity1.getQuitMM(), "")));//脱会年月日(月)
									updateEntity3.setQuitDD(getUpdStr(sData.getQuitDD(),StringUtils.nvl(mstOutEntity1.getQuitDD(), "")));//脱会年月日(日)
									updateEntity3.setPositionCode(getUpdStr(sData.getPositionCode(),StringUtils.nvl(mstOutEntity1.getPositionCode(), "")));//所属役職
									updateEntity3.setSocietyPosiStYYYY(getUpdStr(sData.getSocietyPosiStYYYY(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStYYYY(), "")));//役職開始年月日(年)
									updateEntity3.setSocietyPosiStMM(getUpdStr(sData.getSocietyPosiStMM(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStMM(), "")));//役職開始年月日(月)
									updateEntity3.setSocietyPosiStDD(getUpdStr(sData.getSocietyPosiStDD(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStDD(), "")));//役職開始年月日(日)
									updateEntity3.setSocietyPosiEdYYYY(getUpdStr(sData.getSocietyPosiEdYYYY(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdYYYY(), "")));//役職終了年月日(年)
									updateEntity3.setSocietyPosiEdMM(getUpdStr(sData.getSocietyPosiEdMM(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdMM(), "")));//役職終了年月日(月)
									updateEntity3.setSocietyPosiEdDD(getUpdStr(sData.getSocietyPosiEdDD(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdDD(), "")));//役職終了年月日(日)
									updateEntity3.setAdvisingDoctorCd(getUpdStr(sData.getAdvisingDoctorCd(),StringUtils.nvl(mstOutEntity1.getAdvisingDoctorCd(), "")));//所属学会指導医区分
									updateEntity3.setCoachingAcquisiYYYY(getUpdStr(sData.getCoachingAcquisiYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiYYYY(), "")));//指導医取得年月日(年)
									updateEntity3.setCoachingAcquisiMM(getUpdStr(sData.getCoachingAcquisiMM(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiMM(), "")));//指導医取得年月日(月)
									updateEntity3.setCoachingAcquisiDD(getUpdStr(sData.getCoachingAcquisiDD(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiDD(), "")));//指導医取得年月日(日)
									updateEntity3.setCoachingStYYYY(getUpdStr(sData.getCoachingStYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingStYYYY(), "")));//指導医開始年月日(年)
									updateEntity3.setCoachingStMM(getUpdStr(sData.getCoachingStMM(),StringUtils.nvl(mstOutEntity1.getCoachingStMM(), "")));//指導医開始年月日(月)
									updateEntity3.setCoachingStDD(getUpdStr(sData.getCoachingStDD(),StringUtils.nvl(mstOutEntity1.getCoachingStDD(), "")));//指導医開始年月日(日)
									updateEntity3.setCoachingEdYYYY(getUpdStr(sData.getCoachingEdYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingEdYYYY(), "")));//指導医終了年月日(年)
									updateEntity3.setCoachingEdMM(getUpdStr(sData.getCoachingEdMM(),StringUtils.nvl(mstOutEntity1.getCoachingEdMM(), "")));//指導医終了年月日(月)
									updateEntity3.setCoachingEdDD(getUpdStr(sData.getCoachingEdDD(),StringUtils.nvl(mstOutEntity1.getCoachingEdDD(), "")));//指導医終了年月日(日)
									updateEntity3.setCertifyingPhysicianCd(getUpdStr(sData.getCertifyingPhysicianCd(),StringUtils.nvl(mstOutEntity1.getCertifyingPhysicianCd(), "")));//所属学会認定医区分
									updateEntity3.setCertifyStYYYY(getUpdStr(sData.getCertifyStYYYY(),StringUtils.nvl(mstOutEntity1.getCertifyStYYYY(), "")));//認定医開始年月日(年)
									updateEntity3.setCertifyStMM(getUpdStr(sData.getCertifyStMM(),StringUtils.nvl(mstOutEntity1.getCertifyStMM(), "")));//認定医開始年月日(月)
									updateEntity3.setCertifyStDD(getUpdStr(sData.getCertifyStDD(),StringUtils.nvl(mstOutEntity1.getCertifyStDD(), "")));//認定医開始年月日(日)
									updateEntity3.setCertifyEdYYYY(getUpdStr(sData.getCertifyEdYYYY(),StringUtils.nvl(mstOutEntity1.getCertifyEdYYYY(), "")));//認定医終了年月日(年)
									updateEntity3.setCertifyEdMM(getUpdStr(sData.getCertifyEdMM(),StringUtils.nvl(mstOutEntity1.getCertifyEdMM(), "")));//認定医終了年月日(月)
									updateEntity3.setCertifyEdDD(getUpdStr(sData.getCertifyEdDD(),StringUtils.nvl(mstOutEntity1.getCertifyEdDD(), "")));//認定医終了年月日(日)
								}
								updateEntity3.checkSetNull();
								dao.update(updateEntity3);
							}
						}
					}

				}
				////公的機関//////////////////////////////////////////////////////////////////////////////////////////////
				List<HcpPublicData> publicDataList = indto.getHcpPublicDataList();
				UpdateTRdmHcpPublicReqEntity updateEntity4 = new UpdateTRdmHcpPublicReqEntity();
				updateEntity4.setReqId(indto.getReqId());//申請ID
				updateEntity4.setUpdShaYmd(currentDt);//更新日
				updateEntity4.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者

				TRdmHcpPublicReqEntity ketEntity2 = new TRdmHcpPublicReqEntity();
				MRdmHcpPublicEntity mstEntity2 = new MRdmHcpPublicEntity();
				MRdmHcpPublicEntity mstOutEntity2 = new MRdmHcpPublicEntity();
				ketEntity2.setReqId(indto.getReqId());//申請ID
				mstEntity2.setDocNo(indto.getTkdDocNo());
				for (HcpPublicData pData : publicDataList) {
					if(pData.getPubInstitutionCd() != null) {
						//キーで検索
						ketEntity2.setPubInstitutionCd(StringUtils.setEmptyToNull(pData.getPubInstitutionCd()));//公的機関
						mstEntity2.setPubInstitutionCd(StringUtils.setEmptyToNull(pData.getPubInstitutionCd()));//公的機関
						TRdmHcpPublicReqEntity keyOutEntity2 = new TRdmHcpPublicReqEntity();
						keyOutEntity2 = dao.selectByPK(ketEntity2);
						if(keyOutEntity2 == null) {
							//データなしは新規登録
							TRdmHcpPublicReqEntity insEntity4 = new TRdmHcpPublicReqEntity();
							insEntity4.setReqId(indto.getReqId());//申請ID
							insEntity4.setInsShaYmd(currentDt);//作成日
							insEntity4.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
							insEntity4.setUpdShaYmd(currentDt);//更新日
							insEntity4.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
							insEntity4.setDocNo(StringUtils.setEmptyToNull(indto.getTkdDocNo()));//医師固定コード
							insEntity4.setPubInstitutionCd(pData.getPubInstitutionCd());//公的機関
							//マスタにあるか判定
							mstOutEntity2 = dao.selectByPK(mstEntity2);
							if(mstOutEntity2 == null) {
								//マスタ値なしならそのまま画面の値いれる
								insEntity4.setClassCategoryCd(StringUtils.setEmptyToNull(pData.getClassCategoryCd()));//分類区分
								insEntity4.setPubInstStYYYY(StringUtils.setEmptyToNull(pData.getPubInstStYYYY()));//公的機関開始年月日(年)
								insEntity4.setPubInstStMM(StringUtils.setEmptyToNull(pData.getPubInstStMM()));//公的機関開始年月日(月)
								insEntity4.setPubInstStDD(StringUtils.setEmptyToNull(pData.getPubInstStDD()));//公的機関開始年月日(日)
								insEntity4.setPubInstEdYYYY(StringUtils.setEmptyToNull(pData.getPubInstEdYYYY()));//公的機関終了年月日(年)
								insEntity4.setPubInstEdMM(StringUtils.setEmptyToNull(pData.getPubInstEdMM()));//公的機関終了年月日(月)
								insEntity4.setPubInstEdDD(StringUtils.setEmptyToNull(pData.getPubInstEdDD()));//公的機関終了年月日(日)
								insEntity4.setPubInstPositionCd(StringUtils.setEmptyToNull(pData.getPubInstPositionCd()));//公的機関役職コード
								insEntity4.setPubInstposStYYYY(StringUtils.setEmptyToNull(pData.getPubInstposStYYYY()));//公的機関役職開始年月日(年)
								insEntity4.setPubInstposStMM(StringUtils.setEmptyToNull(pData.getPubInstposStMM()));//公的機関役職開始年月日(月)
								insEntity4.setPubInstposStDD(StringUtils.setEmptyToNull(pData.getPubInstposStDD()));//公的機関役職開始年月日(日)
								insEntity4.setPubInstposEdYYYY(StringUtils.setEmptyToNull(pData.getPubInstposEdYYYY()));//公的機関役職終了年月日(年)
								insEntity4.setPubInstposEdMM(StringUtils.setEmptyToNull(pData.getPubInstposEdMM()));//公的機関役職終了年月日(月)
								insEntity4.setPubInstposEdDD(StringUtils.setEmptyToNull(pData.getPubInstposEdDD()));//公的機関役職終了年月日(日)
							} else {
								//マスタ値ありなら変更判定して入れる
								insEntity4.setClassCategoryCd(getUpdStr(pData.getClassCategoryCd(), StringUtils.nvl(mstOutEntity2.getClassCategoryCd(), "")));//分類区分
								insEntity4.setPubInstStYYYY(getUpdStr(pData.getPubInstStYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstStYYYY(), "")));//公的機関開始年月日(年)
								insEntity4.setPubInstStMM(getUpdStr(pData.getPubInstStMM(), StringUtils.nvl(mstOutEntity2.getPubInstStMM(), "")));//公的機関開始年月日(月)
								insEntity4.setPubInstStDD(getUpdStr(pData.getPubInstStDD(), StringUtils.nvl(mstOutEntity2.getPubInstStDD(), "")));//公的機関開始年月日(日)
								insEntity4.setPubInstEdYYYY(getUpdStr(pData.getPubInstEdYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstEdYYYY(), "")));//公的機関終了年月日(年)
								insEntity4.setPubInstEdMM(getUpdStr(pData.getPubInstEdMM(), StringUtils.nvl(mstOutEntity2.getPubInstEdMM(), "")));//公的機関終了年月日(月)
								insEntity4.setPubInstEdDD(getUpdStr(pData.getPubInstEdDD(), StringUtils.nvl(mstOutEntity2.getPubInstEdDD(), "")));//公的機関終了年月日(日)
								insEntity4.setPubInstPositionCd(getUpdStr(pData.getPubInstPositionCd(), StringUtils.nvl(mstOutEntity2.getPubInstPositionCd(), "")));//公的機関役職コード
								insEntity4.setPubInstposStYYYY(getUpdStr(pData.getPubInstposStYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstposStYYYY(), "")));//公的機関役職開始年月日(年)
								insEntity4.setPubInstposStMM(getUpdStr(pData.getPubInstposStMM(), StringUtils.nvl(mstOutEntity2.getPubInstposStMM(), "")));//公的機関役職開始年月日(月)
								insEntity4.setPubInstposStDD(getUpdStr(pData.getPubInstposStDD(), StringUtils.nvl(mstOutEntity2.getPubInstposStDD(), "")));//公的機関役職開始年月日(日)
								insEntity4.setPubInstposEdYYYY(getUpdStr(pData.getPubInstposEdYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstposEdYYYY(), "")));//公的機関役職終了年月日(年)
								insEntity4.setPubInstposEdMM(getUpdStr(pData.getPubInstposEdMM(), StringUtils.nvl(mstOutEntity2.getPubInstposEdMM(), "")));//公的機関役職終了年月日(月)
								insEntity4.setPubInstposEdDD(getUpdStr(pData.getPubInstposEdDD(), StringUtils.nvl(mstOutEntity2.getPubInstposEdDD(), "")));//公的機関役職終了年月日(日)
							}
							dao.insertByValue(insEntity4);
						}else {
							//ありなら変更チェック
							boolean checkPub = checkPublicData(pData,keyOutEntity2);
							if(checkPub == false) {
								//変更ありなら排他チェック
								UpdateTRdmHcpPublicReqEntity selectUpdateEntity4 = new UpdateTRdmHcpPublicReqEntity();
								selectUpdateEntity4.setSqlId("selectUpDate");
								selectUpdateEntity4.setReqId(indto.getReqId());
								selectUpdateEntity4.setPubInstitutionCd(pData.getPubInstitutionCd());//公的機関
								//ロック処理
								List<UpdateTRdmHcpPublicReqEntity> outEntity4 = new ArrayList<UpdateTRdmHcpPublicReqEntity>();
								try {
									//SQL実行
									outEntity4 = dao.select(selectUpdateEntity4);
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

								if (outEntity4 == null || outEntity4.size() == 0){
									//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
									indto.setMsgId(RdmConstantsData.E003);
									indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
									return outdto;
								} else {
									if (outEntity4.get(0).getUpdShaYmd().compareTo(dtoUpdShaYmddate) > 0) {
										//MSG_CODE	既に他のユーザーによってデータが処理されています。	E003
										indto.setMsgId(RdmConstantsData.E003);
										indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.E003));
										return outdto;
									}
								}
								//エラーなしなら更新
								updateEntity4.setSqlId("updateData");
								updateEntity4.setPubInstitutionCd(pData.getPubInstitutionCd());//公的機関
								updateEntity4.setUpdShaYmd(currentDt);//更新日
								updateEntity4.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
								//マスタにあるか判定
								mstOutEntity2 = dao.selectByPK(mstEntity2);
								if(mstOutEntity2 == null) {
									//マスタ値なしならそのまま画面の値いれる
									updateEntity4.setClassCategoryCd(StringUtils.setEmptyToNull(pData.getClassCategoryCd()));//分類区分
									updateEntity4.setPubInstStYYYY(StringUtils.setEmptyToNull(pData.getPubInstStYYYY()));//公的機関開始年月日(年)
									updateEntity4.setPubInstStMM(StringUtils.setEmptyToNull(pData.getPubInstStMM()));//公的機関開始年月日(月)
									updateEntity4.setPubInstStDD(StringUtils.setEmptyToNull(pData.getPubInstStDD()));//公的機関開始年月日(日)
									updateEntity4.setPubInstEdYYYY(StringUtils.setEmptyToNull(pData.getPubInstEdYYYY()));//公的機関終了年月日(年)
									updateEntity4.setPubInstEdMM(StringUtils.setEmptyToNull(pData.getPubInstEdMM()));//公的機関終了年月日(月)
									updateEntity4.setPubInstEdDD(StringUtils.setEmptyToNull(pData.getPubInstEdDD()));//公的機関終了年月日(日)
									updateEntity4.setPubInstPositionCd(StringUtils.setEmptyToNull(pData.getPubInstPositionCd()));//公的機関役職コード
									updateEntity4.setPubInstposStYYYY(StringUtils.setEmptyToNull(pData.getPubInstposStYYYY()));//公的機関役職開始年月日(年)
									updateEntity4.setPubInstposStMM(StringUtils.setEmptyToNull(pData.getPubInstposStMM()));//公的機関役職開始年月日(月)
									updateEntity4.setPubInstposStDD(StringUtils.setEmptyToNull(pData.getPubInstposStDD()));//公的機関役職開始年月日(日)
									updateEntity4.setPubInstposEdYYYY(StringUtils.setEmptyToNull(pData.getPubInstposEdYYYY()));//公的機関役職終了年月日(年)
									updateEntity4.setPubInstposEdMM(StringUtils.setEmptyToNull(pData.getPubInstposEdMM()));//公的機関役職終了年月日(月)
									updateEntity4.setPubInstposEdDD(StringUtils.setEmptyToNull(pData.getPubInstposEdDD()));//公的機関役職終了年月日(日)
								}else {
									//マスタ値ありなら変更判定して入れる
									updateEntity4.setClassCategoryCd(getUpdStr(pData.getClassCategoryCd(), StringUtils.nvl(mstOutEntity2.getClassCategoryCd(), "")));//分類区分
									updateEntity4.setPubInstStYYYY(getUpdStr(pData.getPubInstStYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstStYYYY(), "")));//公的機関開始年月日(年)
									updateEntity4.setPubInstStMM(getUpdStr(pData.getPubInstStMM(), StringUtils.nvl(mstOutEntity2.getPubInstStMM(), "")));//公的機関開始年月日(月)
									updateEntity4.setPubInstStDD(getUpdStr(pData.getPubInstStDD(), StringUtils.nvl(mstOutEntity2.getPubInstStDD(), "")));//公的機関開始年月日(日)
									updateEntity4.setPubInstEdYYYY(getUpdStr(pData.getPubInstEdYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstEdYYYY(), "")));//公的機関終了年月日(年)
									updateEntity4.setPubInstEdMM(getUpdStr(pData.getPubInstEdMM(), StringUtils.nvl(mstOutEntity2.getPubInstEdMM(), "")));//公的機関終了年月日(月)
									updateEntity4.setPubInstEdDD(getUpdStr(pData.getPubInstEdDD(), StringUtils.nvl(mstOutEntity2.getPubInstEdDD(), "")));//公的機関終了年月日(日)
									updateEntity4.setPubInstPositionCd(getUpdStr(pData.getPubInstPositionCd(), StringUtils.nvl(mstOutEntity2.getPubInstPositionCd(), "")));//公的機関役職コード
									updateEntity4.setPubInstposStYYYY(getUpdStr(pData.getPubInstposStYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstposStYYYY(), "")));//公的機関役職開始年月日(年)
									updateEntity4.setPubInstposStMM(getUpdStr(pData.getPubInstposStMM(), StringUtils.nvl(mstOutEntity2.getPubInstposStMM(), "")));//公的機関役職開始年月日(月)
									updateEntity4.setPubInstposStDD(getUpdStr(pData.getPubInstposStDD(), StringUtils.nvl(mstOutEntity2.getPubInstposStDD(), "")));//公的機関役職開始年月日(日)
									updateEntity4.setPubInstposEdYYYY(getUpdStr(pData.getPubInstposEdYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstposEdYYYY(), "")));//公的機関役職終了年月日(年)
									updateEntity4.setPubInstposEdMM(getUpdStr(pData.getPubInstposEdMM(), StringUtils.nvl(mstOutEntity2.getPubInstposEdMM(), "")));//公的機関役職終了年月日(月)
									updateEntity4.setPubInstposEdDD(getUpdStr(pData.getPubInstposEdDD(), StringUtils.nvl(mstOutEntity2.getPubInstposEdDD(), "")));//公的機関役職終了年月日(日)
								}
								updateEntity4.checkSetNull();
								dao.update(updateEntity4);
							}
						}
					}
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
				insEntity1.setReqType("32");//申請区分
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
//				Date dtoUpdShaYmddate;
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

				dao.insertByValue(insEntity1);

				// 医師_申請管理
				TRdmHcpReqEntity insEntity2 = new TRdmHcpReqEntity();
				insEntity2.setReqId(reqId);//申請ID
				insEntity2.setDocNo(indto.getTkdDocNo());//医師固定コード
				insEntity2.setInsShaYmd(currentDt);//作成日
				insEntity2.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity2.setUpdShaYmd(currentDt);//更新日
				insEntity2.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
//				変更前と判定した結果をセット
				insEntity2.setDocType(getUpdStr(indto.getDocType(),indto.getMstDocType()));//医師／薬剤師区分
				insEntity2.setDocKanj(getUpdStr((indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei()), (indto.getMstDocKanjiSei() + "　" + indto.getMstDocKanjiMei())));//氏名（漢字）
				insEntity2.setDocKana(getUpdStr((indto.getDocKanaSei()  + " " + indto.getDocKanaMei()), (indto.getMstDocKanaSei()  + " " + indto.getMstDocKanaMei())));//氏名（カナ）
				insEntity2.setDocKanjiSei(getUpdStr(indto.getDocKanjiSei(), indto.getMstDocKanjiSei()));//氏名（漢字）姓
				insEntity2.setDocKanjiMei(getUpdStr(indto.getDocKanjiMei(), indto.getMstDocKanjiMei()));//氏名（漢字）名
				insEntity2.setDocKanaSei(getUpdStr(indto.getDocKanaSei(), indto.getMstDocKanaSei()));//氏名（カナ）姓
				insEntity2.setDocKanaMei(getUpdStr(indto.getDocKanaMei(), indto.getMstDocKanaMei()));//氏名（カナ）名
				insEntity2.setOldKanjSei(getUpdStr(indto.getOldKanjSei(), indto.getMstOldKanjSei()));//氏名（漢字）旧姓
				insEntity2.setOldKanaSei(getUpdStr(indto.getOldKanaSei(), indto.getMstOldKanaSei()));//氏名（カナ）旧姓
				insEntity2.setNewNameStYear(getUpdStr(indto.getNewNameStYear(), indto.getMstNewNameStYear()));//改姓日（年）
				insEntity2.setNewNameStMonth(getUpdStr(indto.getNewNameStMonth(), indto.getMstNewNameStMonth()));//改姓日（月）
				insEntity2.setNewNameStDay(getUpdStr(indto.getNewNameStDay(), indto.getMstNewNameStDay()));//改姓日（日）
				insEntity2.setDobYear(getUpdStr(indto.getDobYear(), indto.getMstDobYear()));//生年月日（年）
				insEntity2.setDobMonth(getUpdStr(indto.getDobMonth(), indto.getMstDobMonth()));//生年月日（月）
				insEntity2.setDobDay(getUpdStr(indto.getDobDay(), indto.getMstDobDay()));//生年月日（日）
				insEntity2.setSexCd(getUpdStr(indto.getSexCd(), indto.getMstSexCd()));//性別区分
				insEntity2.setHomeTownCd(getUpdStr(indto.getHomeTownCd(), indto.getMstHomeTownCd()));//出身地コード
				insEntity2.setMedSchoolCd(getUpdStr(indto.getMedSchoolCd(), indto.getMstMedSchoolCd()));//出身校コード
				insEntity2.setGradYear(getUpdStr(indto.getGradYear(), indto.getMstGradYear()));//卒年
				insEntity2.setHomeDeptCd(getUpdStr(indto.getHomeDeptCd(), indto.getMstHomeDeptCd()));//出身所属コード
				insEntity2.setHomeUnivCd(getUpdStr(indto.getHomeUnivCd(), indto.getMstHomeUnivCd()));//出身医局校コード
				insEntity2.setEmplYear(getUpdStr(indto.getEmplYear(), indto.getMstEmplYear()));//臨床研修年
				insEntity2.setSpLiverCd(getUpdStr(indto.getSpLiverCd(), indto.getMstSpLiverCd()));//専門臓器コード
				insEntity2.setSpDiseaseCd(getUpdStr(indto.getSpDiseaseCd(), indto.getMstSpDiseaseCd()));//専門詳細コード
				insEntity2.setSpCom(getUpdStr(indto.getSpCom(), indto.getMstSpCom()));//専門追加情報
				dao.insertByValue(insEntity2);

				//所属学会
				List<HcpSocietyData> societyDataList = indto.getHcpSocietyDataList();
				TRdmHcpSocietyReqEntity insEntity3 = new TRdmHcpSocietyReqEntity();
				insEntity3.setReqId(reqId);//申請ID
				insEntity3.setDocNo(indto.getTkdDocNo());//医師固定コード
				insEntity3.setInsShaYmd(currentDt);//作成日
				insEntity3.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity3.setUpdShaYmd(currentDt);//更新日
				insEntity3.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				MRdmHcpSocietyEntity mstEntity1 = new MRdmHcpSocietyEntity();
				MRdmHcpSocietyEntity mstOutEntity1 = new MRdmHcpSocietyEntity();
				mstEntity1.setDocNo(indto.getTkdDocNo());

				for (HcpSocietyData sData : societyDataList) {
					insEntity3.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
					mstEntity1.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
					//マスタにあるか判定
					mstOutEntity1 = dao.selectByPK(mstEntity1);
					if(mstOutEntity1 == null) {
						insEntity3.setAdmissionYYYY(StringUtils.setEmptyToNull(sData.getAdmissionYYYY()));//入会年月日(年)
						insEntity3.setAdmissionMM(StringUtils.setEmptyToNull(sData.getAdmissionMM()));//入会年月日(月)
						insEntity3.setAdmissionDD(StringUtils.setEmptyToNull(sData.getAdmissionDD()));//入会年月日(日)
						insEntity3.setQuitYYYY(StringUtils.setEmptyToNull(sData.getQuitYYYY()));//脱会年月日(年)
						insEntity3.setQuitMM(StringUtils.setEmptyToNull(sData.getQuitMM()));//脱会年月日(月)
						insEntity3.setQuitDD(StringUtils.setEmptyToNull(sData.getQuitDD()));//脱会年月日(日)
						insEntity3.setPositionCode(StringUtils.setEmptyToNull(sData.getPositionCode()));//所属役職
						insEntity3.setSocietyPosiStYYYY(StringUtils.setEmptyToNull(sData.getSocietyPosiStYYYY()));//役職開始年月日(年)
						insEntity3.setSocietyPosiStMM(StringUtils.setEmptyToNull(sData.getSocietyPosiStMM()));//役職開始年月日(月)
						insEntity3.setSocietyPosiStDD(StringUtils.setEmptyToNull(sData.getSocietyPosiStDD()));//役職開始年月日(日)
						insEntity3.setSocietyPosiEdYYYY(StringUtils.setEmptyToNull(sData.getSocietyPosiEdYYYY()));//役職終了年月日(年)
						insEntity3.setSocietyPosiEdMM(StringUtils.setEmptyToNull(sData.getSocietyPosiEdMM()));//役職終了年月日(月)
						insEntity3.setSocietyPosiEdDD(StringUtils.setEmptyToNull(sData.getSocietyPosiEdDD()));//役職終了年月日(日)
						insEntity3.setAdvisingDoctorCd(StringUtils.setEmptyToNull(sData.getAdvisingDoctorCd()));//所属学会指導医区分
						insEntity3.setCoachingAcquisiYYYY(StringUtils.setEmptyToNull(sData.getCoachingAcquisiYYYY()));//指導医取得年月日(年)
						insEntity3.setCoachingAcquisiMM(StringUtils.setEmptyToNull(sData.getCoachingAcquisiMM()));//指導医取得年月日(月)
						insEntity3.setCoachingAcquisiDD(StringUtils.setEmptyToNull(sData.getCoachingAcquisiDD()));//指導医取得年月日(日)
						insEntity3.setCoachingStYYYY(StringUtils.setEmptyToNull(sData.getCoachingStYYYY()));//指導医開始年月日(年)
						insEntity3.setCoachingStMM(StringUtils.setEmptyToNull(sData.getCoachingStMM()));//指導医開始年月日(月)
						insEntity3.setCoachingStDD(StringUtils.setEmptyToNull(sData.getCoachingStDD()));//指導医開始年月日(日)
						insEntity3.setCoachingEdYYYY(StringUtils.setEmptyToNull(sData.getCoachingEdYYYY()));//指導医終了年月日(年)
						insEntity3.setCoachingEdMM(StringUtils.setEmptyToNull(sData.getCoachingEdMM()));//指導医終了年月日(月)
						insEntity3.setCoachingEdDD(StringUtils.setEmptyToNull(sData.getCoachingEdDD()));//指導医終了年月日(日)
						insEntity3.setCertifyingPhysicianCd(StringUtils.setEmptyToNull(sData.getCertifyingPhysicianCd()));//所属学会認定医区分
						insEntity3.setCertifyStYYYY(StringUtils.setEmptyToNull(sData.getCertifyStYYYY()));//認定医開始年月日(年)
						insEntity3.setCertifyStMM(StringUtils.setEmptyToNull(sData.getCertifyStMM()));//認定医開始年月日(月)
						insEntity3.setCertifyStDD(StringUtils.setEmptyToNull(sData.getCertifyStDD()));//認定医開始年月日(日)
						insEntity3.setCertifyEdYYYY(StringUtils.setEmptyToNull(sData.getCertifyEdYYYY()));//認定医終了年月日(年)
						insEntity3.setCertifyEdMM(StringUtils.setEmptyToNull(sData.getCertifyEdMM()));//認定医終了年月日(月)
						insEntity3.setCertifyEdDD(StringUtils.setEmptyToNull(sData.getCertifyEdDD()));//認定医終了年月日(日)
						dao.insertByValue(insEntity3);
					} else {
						//マスタ値ありなら変更判定して入れる
						//ありなら変更チェック
						boolean checkSoc = checkSocietyDataMst(sData,mstOutEntity1);
						if(checkSoc == false) {
							//　変更あり
							insEntity3.setAdmissionYYYY(getUpdStr(sData.getAdmissionYYYY(),StringUtils.nvl(mstOutEntity1.getAdmissionYYYY(), "")));//入会年月日(年)
							insEntity3.setAdmissionMM(getUpdStr(sData.getAdmissionMM(),StringUtils.nvl(mstOutEntity1.getAdmissionMM(), "")));//入会年月日(月)
							insEntity3.setAdmissionDD(getUpdStr(sData.getAdmissionDD(),StringUtils.nvl(mstOutEntity1.getAdmissionDD(), "")));//入会年月日(日)
							insEntity3.setQuitYYYY(getUpdStr(sData.getQuitYYYY(),StringUtils.nvl(mstOutEntity1.getQuitYYYY(), "")));//脱会年月日(年)
							insEntity3.setQuitMM(getUpdStr(sData.getQuitMM(),StringUtils.nvl(mstOutEntity1.getQuitMM(), "")));//脱会年月日(月)
							insEntity3.setQuitDD(getUpdStr(sData.getQuitDD(),StringUtils.nvl(mstOutEntity1.getQuitDD(), "")));//脱会年月日(日)
							insEntity3.setPositionCode(getUpdStr(sData.getPositionCode(),StringUtils.nvl(mstOutEntity1.getPositionCode(), "")));//所属役職
							insEntity3.setSocietyPosiStYYYY(getUpdStr(sData.getSocietyPosiStYYYY(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStYYYY(), "")));//役職開始年月日(年)
							insEntity3.setSocietyPosiStMM(getUpdStr(sData.getSocietyPosiStMM(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStMM(), "")));//役職開始年月日(月)
							insEntity3.setSocietyPosiStDD(getUpdStr(sData.getSocietyPosiStDD(),StringUtils.nvl(mstOutEntity1.getSocietyPosiStDD(), "")));//役職開始年月日(日)
							insEntity3.setSocietyPosiEdYYYY(getUpdStr(sData.getSocietyPosiEdYYYY(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdYYYY(), "")));//役職終了年月日(年)
							insEntity3.setSocietyPosiEdMM(getUpdStr(sData.getSocietyPosiEdMM(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdMM(), "")));//役職終了年月日(月)
							insEntity3.setSocietyPosiEdDD(getUpdStr(sData.getSocietyPosiEdDD(),StringUtils.nvl(mstOutEntity1.getSocietyPosiEdDD(), "")));//役職終了年月日(日)
							insEntity3.setAdvisingDoctorCd(getUpdStr(sData.getAdvisingDoctorCd(),StringUtils.nvl(mstOutEntity1.getAdvisingDoctorCd(), "")));//所属学会指導医区分
							insEntity3.setCoachingAcquisiYYYY(getUpdStr(sData.getCoachingAcquisiYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiYYYY(), "")));//指導医取得年月日(年)
							insEntity3.setCoachingAcquisiMM(getUpdStr(sData.getCoachingAcquisiMM(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiMM(), "")));//指導医取得年月日(月)
							insEntity3.setCoachingAcquisiDD(getUpdStr(sData.getCoachingAcquisiDD(),StringUtils.nvl(mstOutEntity1.getCoachingAcquisiDD(), "")));//指導医取得年月日(日)
							insEntity3.setCoachingStYYYY(getUpdStr(sData.getCoachingStYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingStYYYY(), "")));//指導医開始年月日(年)
							insEntity3.setCoachingStMM(getUpdStr(sData.getCoachingStMM(),StringUtils.nvl(mstOutEntity1.getCoachingStMM(), "")));//指導医開始年月日(月)
							insEntity3.setCoachingStDD(getUpdStr(sData.getCoachingStDD(),StringUtils.nvl(mstOutEntity1.getCoachingStDD(), "")));//指導医開始年月日(日)
							insEntity3.setCoachingEdYYYY(getUpdStr(sData.getCoachingEdYYYY(),StringUtils.nvl(mstOutEntity1.getCoachingEdYYYY(), "")));//指導医終了年月日(年)
							insEntity3.setCoachingEdMM(getUpdStr(sData.getCoachingEdMM(),StringUtils.nvl(mstOutEntity1.getCoachingEdMM(), "")));//指導医終了年月日(月)
							insEntity3.setCoachingEdDD(getUpdStr(sData.getCoachingEdDD(),StringUtils.nvl(mstOutEntity1.getCoachingEdDD(), "")));//指導医終了年月日(日)
							insEntity3.setCertifyingPhysicianCd(getUpdStr(sData.getCertifyingPhysicianCd(),StringUtils.nvl(mstOutEntity1.getCertifyingPhysicianCd(), "")));//所属学会認定医区分
							insEntity3.setCertifyStYYYY(getUpdStr(sData.getCertifyStYYYY(),StringUtils.nvl(mstOutEntity1.getCertifyStYYYY(), "")));//認定医開始年月日(年)
							insEntity3.setCertifyStMM(getUpdStr(sData.getCertifyStMM(),StringUtils.nvl(mstOutEntity1.getCertifyStMM(), "")));//認定医開始年月日(月)
							insEntity3.setCertifyStDD(getUpdStr(sData.getCertifyStDD(),StringUtils.nvl(mstOutEntity1.getCertifyStDD(), "")));//認定医開始年月日(日)
							insEntity3.setCertifyEdYYYY(getUpdStr(sData.getCertifyEdYYYY(),StringUtils.nvl(mstOutEntity1.getCertifyEdYYYY(), "")));//認定医終了年月日(年)
							insEntity3.setCertifyEdMM(getUpdStr(sData.getCertifyEdMM(),StringUtils.nvl(mstOutEntity1.getCertifyEdMM(), "")));//認定医終了年月日(月)
							insEntity3.setCertifyEdDD(getUpdStr(sData.getCertifyEdDD(),StringUtils.nvl(mstOutEntity1.getCertifyEdDD(), "")));//認定医終了年月日(日)
							dao.insertByValue(insEntity3);
						}
					}
				}
				//公的機関
				List<HcpPublicData> publicDataList = indto.getHcpPublicDataList();
				TRdmHcpPublicReqEntity insEntity4 = new TRdmHcpPublicReqEntity();
				insEntity4.setReqId(reqId);//申請ID
				insEntity4.setDocNo(indto.getTkdDocNo());//医師固定コード
				insEntity4.setInsShaYmd(currentDt);//作成日
				insEntity4.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity4.setUpdShaYmd(currentDt);//更新日
				insEntity4.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				MRdmHcpPublicEntity mstEntity2 = new MRdmHcpPublicEntity();
				MRdmHcpPublicEntity mstOutEntity2 = new MRdmHcpPublicEntity();
				mstEntity2.setDocNo(indto.getTkdDocNo());
				for (HcpPublicData pData : publicDataList) {
					insEntity4.setPubInstitutionCd(pData.getPubInstitutionCd());//公的機関
					mstEntity2.setPubInstitutionCd(pData.getPubInstitutionCd());//公的機関
					//マスタにあるか判定
					mstOutEntity2 = dao.selectByPK(mstEntity2);
					if(mstOutEntity2 == null) {
						//マスタ値なしならそのまま画面の値いれる
						insEntity4.setClassCategoryCd(StringUtils.setEmptyToNull(pData.getClassCategoryCd()));//分類区分
						insEntity4.setPubInstStYYYY(StringUtils.setEmptyToNull(pData.getPubInstStYYYY()));//公的機関開始年月日(年)
						insEntity4.setPubInstStMM(StringUtils.setEmptyToNull(pData.getPubInstStMM()));//公的機関開始年月日(月)
						insEntity4.setPubInstStDD(StringUtils.setEmptyToNull(pData.getPubInstStDD()));//公的機関開始年月日(日)
						insEntity4.setPubInstEdYYYY(StringUtils.setEmptyToNull(pData.getPubInstEdYYYY()));//公的機関終了年月日(年)
						insEntity4.setPubInstEdMM(StringUtils.setEmptyToNull(pData.getPubInstEdMM()));//公的機関終了年月日(月)
						insEntity4.setPubInstEdDD(StringUtils.setEmptyToNull(pData.getPubInstEdDD()));//公的機関終了年月日(日)
						insEntity4.setPubInstPositionCd(StringUtils.setEmptyToNull(pData.getPubInstPositionCd()));//公的機関役職コード
						insEntity4.setPubInstposStYYYY(StringUtils.setEmptyToNull(pData.getPubInstposStYYYY()));//公的機関役職開始年月日(年)
						insEntity4.setPubInstposStMM(StringUtils.setEmptyToNull(pData.getPubInstposStMM()));//公的機関役職開始年月日(月)
						insEntity4.setPubInstposStDD(StringUtils.setEmptyToNull(pData.getPubInstposStDD()));//公的機関役職開始年月日(日)
						insEntity4.setPubInstposEdYYYY(StringUtils.setEmptyToNull(pData.getPubInstposEdYYYY()));//公的機関役職終了年月日(年)
						insEntity4.setPubInstposEdMM(StringUtils.setEmptyToNull(pData.getPubInstposEdMM()));//公的機関役職終了年月日(月)
						insEntity4.setPubInstposEdDD(StringUtils.setEmptyToNull(pData.getPubInstposEdDD()));//公的機関役職終了年月日(日)
						dao.insertByValue(insEntity4);
					} else {
						//マスタ値ありなら変更判定して入れる
						//ありなら変更チェック
						boolean checkPub = checkPublicDataMst(pData,mstOutEntity2);
						if(checkPub == false) {
							//　変更あり
							insEntity4.setClassCategoryCd(getUpdStr(pData.getClassCategoryCd(), StringUtils.nvl(mstOutEntity2.getClassCategoryCd(), "")));//分類区分
							insEntity4.setPubInstStYYYY(getUpdStr(pData.getPubInstStYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstStYYYY(), "")));//公的機関開始年月日(年)
							insEntity4.setPubInstStMM(getUpdStr(pData.getPubInstStMM(), StringUtils.nvl(mstOutEntity2.getPubInstStMM(), "")));//公的機関開始年月日(月)
							insEntity4.setPubInstStDD(getUpdStr(pData.getPubInstStDD(), StringUtils.nvl(mstOutEntity2.getPubInstStDD(), "")));//公的機関開始年月日(日)
							insEntity4.setPubInstEdYYYY(getUpdStr(pData.getPubInstEdYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstEdYYYY(), "")));//公的機関終了年月日(年)
							insEntity4.setPubInstEdMM(getUpdStr(pData.getPubInstEdMM(), StringUtils.nvl(mstOutEntity2.getPubInstEdMM(), "")));//公的機関終了年月日(月)
							insEntity4.setPubInstEdDD(getUpdStr(pData.getPubInstEdDD(), StringUtils.nvl(mstOutEntity2.getPubInstEdDD(), "")));//公的機関終了年月日(日)
							insEntity4.setPubInstPositionCd(getUpdStr(pData.getPubInstPositionCd(), StringUtils.nvl(mstOutEntity2.getPubInstPositionCd(), "")));//公的機関役職コード
							insEntity4.setPubInstposStYYYY(getUpdStr(pData.getPubInstposStYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstposStYYYY(), "")));//公的機関役職開始年月日(年)
							insEntity4.setPubInstposStMM(getUpdStr(pData.getPubInstposStMM(), StringUtils.nvl(mstOutEntity2.getPubInstposStMM(), "")));//公的機関役職開始年月日(月)
							insEntity4.setPubInstposStDD(getUpdStr(pData.getPubInstposStDD(), StringUtils.nvl(mstOutEntity2.getPubInstposStDD(), "")));//公的機関役職開始年月日(日)
							insEntity4.setPubInstposEdYYYY(getUpdStr(pData.getPubInstposEdYYYY(), StringUtils.nvl(mstOutEntity2.getPubInstposEdYYYY(), "")));//公的機関役職終了年月日(年)
							insEntity4.setPubInstposEdMM(getUpdStr(pData.getPubInstposEdMM(), StringUtils.nvl(mstOutEntity2.getPubInstposEdMM(), "")));//公的機関役職終了年月日(月)
							insEntity4.setPubInstposEdDD(getUpdStr(pData.getPubInstposEdDD(), StringUtils.nvl(mstOutEntity2.getPubInstposEdDD(), "")));//公的機関役職終了年月日(日)
							dao.insertByValue(insEntity4);
						}
					}
				}
				indto.setUpdShaYmd(strDate);
				indto.setReqId(reqId);
				indto.setReqStsCd("01");
				indto.setReqStsNm("保存済み");
			}
		}
		//審査ボタン押下の場合
		if ("2".equals(indto.getButtonFlg())) {
			//TODO ステータス更新
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
			TRdmHcpSocietyReqEntity deleteEntity3 = new TRdmHcpSocietyReqEntity();
			deleteEntity3.setReqId(indto.getReqId());
			dao.deleteByValue(deleteEntity3);
			TRdmHcpPublicReqEntity deleteEntity4 = new TRdmHcpPublicReqEntity();
			deleteEntity4.setReqId(indto.getReqId());
			dao.deleteByValue(deleteEntity4);
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
		// パラメタ医師勤務先メニュー取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName(jp.co.takeda.rdm.util.RdmConstantsData.PARAM_NAME_MN_KMU);
		mRdmParamMstEntity.setDelFlg("0");
		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			String value = mRdmParamMstEntityList.get(0).getValue();
			if(!"000".equals(value)) {
				// 申請・承認・却下ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}
		// END UOC
		return outdto;
	}

	private boolean checkPublicDataMst(HcpPublicData pData, MRdmHcpPublicEntity pEntity) {
		HcpPublicData pdData = new HcpPublicData();
		pdData.setClassCategoryCd(StringUtils.nvl(pEntity.getClassCategoryCd(), ""));
		pdData.setPubInstitutionCd(StringUtils.nvl(pEntity.getPubInstitutionCd(), ""));
		pdData.setPubInstStYYYY(StringUtils.nvl(pEntity.getPubInstStYYYY(), ""));
		pdData.setPubInstStMM(StringUtils.nvl(pEntity.getPubInstStMM(), ""));
		pdData.setPubInstStDD(StringUtils.nvl(pEntity.getPubInstStDD(), ""));
		pdData.setPubInstEdYYYY(StringUtils.nvl(pEntity.getPubInstEdYYYY(), ""));
		pdData.setPubInstEdMM(StringUtils.nvl(pEntity.getPubInstEdMM(), ""));
		pdData.setPubInstEdDD(StringUtils.nvl(pEntity.getPubInstEdDD(), ""));
		pdData.setPubInstPositionCd(StringUtils.nvl(pEntity.getPubInstPositionCd(), ""));
		pdData.setPubInstposStYYYY(StringUtils.nvl(pEntity.getPubInstposStYYYY(), ""));
		pdData.setPubInstposStMM(StringUtils.nvl(pEntity.getPubInstposStMM(), ""));
		pdData.setPubInstposStDD(StringUtils.nvl(pEntity.getPubInstposStDD(), ""));
		pdData.setPubInstposEdYYYY(StringUtils.nvl(pEntity.getPubInstposEdYYYY(), ""));
		pdData.setPubInstposEdMM(StringUtils.nvl(pEntity.getPubInstposEdMM(), ""));
		pdData.setPubInstposEdDD(StringUtils.nvl(pEntity.getPubInstposEdDD(), ""));
		String pd = pData.toChkString();
		String pe = pdData.toChkString();
		if(pd.equals(pe)) {
			return true;
		}
		return false;
	}

	private boolean checkSocietyDataMst(HcpSocietyData sData, MRdmHcpSocietyEntity sEntity) {
		HcpSocietyData sdData = new HcpSocietyData();
		sdData.setMedicalSocietyNm(StringUtils.nvl(sEntity.getMedicalSocietyNm(), ""));
		sdData.setAdmissionYYYY(StringUtils.nvl(sEntity.getAdmissionYYYY(), ""));
		sdData.setAdmissionMM(StringUtils.nvl(sEntity.getAdmissionMM(), ""));
		sdData.setAdmissionDD(StringUtils.nvl(sEntity.getAdmissionDD(), ""));
		sdData.setQuitYYYY(StringUtils.nvl(sEntity.getQuitYYYY(), ""));
		sdData.setQuitMM(StringUtils.nvl(sEntity.getQuitMM(), ""));
		sdData.setQuitDD(StringUtils.nvl(sEntity.getQuitDD(), ""));
		sdData.setPositionCode(StringUtils.nvl(sEntity.getPositionCode(), ""));
		sdData.setSocietyPosiStYYYY(StringUtils.nvl(sEntity.getSocietyPosiStYYYY(), ""));
		sdData.setSocietyPosiStMM(StringUtils.nvl(sEntity.getSocietyPosiStMM(), ""));
		sdData.setSocietyPosiStDD(StringUtils.nvl(sEntity.getSocietyPosiStDD(), ""));
		sdData.setSocietyPosiEdYYYY(StringUtils.nvl(sEntity.getSocietyPosiEdYYYY(), ""));
		sdData.setSocietyPosiEdMM(StringUtils.nvl(sEntity.getSocietyPosiEdMM(), ""));
		sdData.setSocietyPosiEdDD(StringUtils.nvl(sEntity.getSocietyPosiEdDD(), ""));
		sdData.setAdvisingDoctorCd(StringUtils.nvl(sEntity.getAdvisingDoctorCd(), ""));
		sdData.setCoachingAcquisiYYYY(StringUtils.nvl(sEntity.getCoachingAcquisiYYYY(), ""));
		sdData.setCoachingAcquisiMM(StringUtils.nvl(sEntity.getCoachingAcquisiMM(), ""));
		sdData.setCoachingAcquisiDD(StringUtils.nvl(sEntity.getCoachingAcquisiDD(), ""));
		sdData.setCoachingStYYYY(StringUtils.nvl(sEntity.getCoachingStYYYY(), ""));
		sdData.setCoachingStMM(StringUtils.nvl(sEntity.getCoachingStMM(), ""));
		sdData.setCoachingStDD(StringUtils.nvl(sEntity.getCoachingStDD(), ""));
		sdData.setCoachingEdYYYY(StringUtils.nvl(sEntity.getCoachingEdYYYY(), ""));
		sdData.setCoachingEdMM(StringUtils.nvl(sEntity.getCoachingEdMM(), ""));
		sdData.setCoachingEdDD(StringUtils.nvl(sEntity.getCoachingEdDD(), ""));
		sdData.setCertifyingPhysicianCd(StringUtils.nvl(sEntity.getCertifyingPhysicianCd(), ""));
		sdData.setCertifyStYYYY(StringUtils.nvl(sEntity.getCertifyStYYYY(), ""));
		sdData.setCertifyStMM(StringUtils.nvl(sEntity.getCertifyStMM(), ""));
		sdData.setCertifyStDD(StringUtils.nvl(sEntity.getCertifyStDD(), ""));
		sdData.setCertifyEdYYYY(StringUtils.nvl(sEntity.getCertifyEdYYYY(), ""));
		sdData.setCertifyEdMM(StringUtils.nvl(sEntity.getCertifyEdMM(), ""));
		sdData.setCertifyEdDD(StringUtils.nvl(sEntity.getCertifyEdDD(), ""));

		String sd = sData.toChkString();
		String se = sdData.toChkString();
		if(sd.equals(se)) {
			return true;
		}
		return false;
	}

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND012DTO indto, boolean fullchkFlg) {
		boolean errChk = false;
		String msgStr = "";
		String tmpMsgStr = "";
		int len = 0;
		if(fullchkFlg) {
			//	１：必須入力チェック
			//	項目
			//	医師／薬剤師区分
			if(StringUtils.isEmpty(indto.getDocType())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師／薬剤師区分");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		if(fullchkFlg) {
			//	性別
			if(StringUtils.isEmpty(indto.getSexCd())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "性別");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		if(fullchkFlg) {
			//	医師名(漢字)姓
			if(StringUtils.isEmpty(indto.getDocKanjiSei())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(漢字)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      医師名(漢字)姓                              ５文字を超えている場合
		if(!StringUtils.isEmpty(indto.getDocKanjiSei())) {
			len = indto.getDocKanjiSei().length();
			if(len > 5) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(漢字)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//		医師名(漢字)姓                              半角文字が含まれている場合
		if(!StringUtils.isEmpty(indto.getDocKanjiSei())) {
			if(!StringUtils.isMultiByte(indto.getDocKanjiSei())){
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W015);//全角で入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(漢字)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		if(fullchkFlg) {
			//	医師名(漢字)名
			if(StringUtils.isEmpty(indto.getDocKanjiMei())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(漢字)名");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      医師名(漢字)名                              ５文字を超えている場合
		if(!StringUtils.isEmpty(indto.getDocKanjiMei())) {
			len = indto.getDocKanjiMei().length();
			if(len > 5) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(漢字)名");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//		医師名(漢字)名                              半角文字が含まれている場合
		if(!StringUtils.isEmpty(indto.getDocKanjiMei())) {
			if(!StringUtils.isMultiByte(indto.getDocKanjiMei())){
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W015);//全角で入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(漢字)名");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		if(fullchkFlg) {
			//	医師名(半角カナ)姓
			if(StringUtils.isEmpty(indto.getDocKanaSei())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(半角カナ)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      医師名(半角カナ)姓                              １０文字を超えている場合
		if(!StringUtils.isEmpty(indto.getDocKanaSei())) {
			len = indto.getDocKanaSei().length();
			if(len > 10) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(半角カナ)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//		医師名(半角カナ)姓                              全角文字が含まれている場合
		if(!StringUtils.isEmpty(indto.getDocKanaSei())) {
			if(StringUtils.checkMultiByte(indto.getDocKanaSei())){
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W014);//半角で入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(半角カナ)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		if(fullchkFlg) {
			//	医師名(半角カナ)名
			if(StringUtils.isEmpty(indto.getDocKanaMei())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(半角カナ)名");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      医師名(半角カナ)名                              １０文字を超えている場合
		if(!StringUtils.isEmpty(indto.getDocKanaMei())) {
			len = indto.getDocKanaMei().length();
			if(len > 10) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(半角カナ)名");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//		医師名(半角カナ)名                              全角文字が含まれている場合
		if(!StringUtils.isEmpty(indto.getDocKanaMei())) {
			if(StringUtils.checkMultiByte(indto.getDocKanaMei())){
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W014);//半角で入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "医師名(半角カナ)名");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      旧姓(漢字)姓                                ５文字を超えている場合
		if(!StringUtils.isEmpty(indto.getOldKanaSei())) {
			len = indto.getOldKanjSei().length();
			if(len > 5) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "旧姓(漢字)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//		旧姓(漢字)姓                                半角文字が含まれている場合
		if(!StringUtils.isEmpty(indto.getOldKanjSei())) {
			if(!StringUtils.isMultiByte(indto.getOldKanjSei())){
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W015);//全角で入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "旧姓(漢字)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      旧姓(半角カナ)姓                                １０文字を超えている場合
		if(!StringUtils.isEmpty(indto.getOldKanaSei())) {
			len = indto.getOldKanaSei().length();
			if(len > 10) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "旧姓(半角カナ)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//		旧姓(半角カナ)姓                                全角文字が含まれている場合
		if(!StringUtils.isEmpty(indto.getOldKanaSei())) {
			if(StringUtils.checkMultiByte(indto.getOldKanaSei())){
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W014);//半角で入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "旧姓(半角カナ)姓");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		if(fullchkFlg) {
			//改姓日
			if(!StringUtils.isEmpty(indto.getNewNameStYear()) || !StringUtils.isEmpty(indto.getNewNameStMonth()) || !StringUtils.isEmpty(indto.getNewNameStDay())) {
				if(!DateUtils.isDate(indto.getNewNameStYear() + indto.getNewNameStMonth() + indto.getNewNameStDay())) {
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "改姓日");
					msgStr = msgStr + tmpMsgStr + "\n";
				}
			}
		}
		if(fullchkFlg) {
			//W022	有効な年月日を入力してください。（項目名）
			//生年月日
			if(!StringUtils.isEmpty(indto.getDobYear()) || !StringUtils.isEmpty(indto.getDobMonth()) || !StringUtils.isEmpty(indto.getDobDay())) {
				if(!DateUtils.isDate(indto.getDobYear() + indto.getDobMonth() + indto.getDobDay())) {
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "生年月日");
					msgStr = msgStr + tmpMsgStr + "\n";
				}
			}
		}
		if(fullchkFlg) {
			//		整合性チェック                              下記の全てが未設定ならエラー
			//		- 生年月日(年月日のすべて指定)
			//		- 出身校
			//		- 卒年
			if((StringUtils.isEmpty(indto.getDobYear()) && StringUtils.isEmpty(indto.getDobMonth()) && StringUtils.isEmpty(indto.getDobDay()))
					&& StringUtils.isEmpty(indto.getMedSchoolCd())
					&& StringUtils.isEmpty(indto.getGradYear())) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W028);//下記のいずれかが登録してください。- 生年月日(年月日のすべて指定)- 出身校- 卒年
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      専門追加情報                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getSpCom())) {
			len = StringUtils.getByteLength(indto.getSpCom());
			if(len > 300) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "専門追加情報");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		if(fullchkFlg) {
//			//		整合性チェック                              "医師／薬剤師区分が「医師」の場合
//			//		役職まで登録されているか確認。"
//			if(indto.getDocType().equals("1") && StringUtils.isEmpty(indto.getSkTitleCd())){
//				errChk = true;
//				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W029);//医師／薬剤師区分に医師を設定する場合は役職を指定してください。
//				msgStr = msgStr + tmpMsgStr + "\n";
//			}
		}
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

		if(fullchkFlg) {
			//TODO
			// 勤務先変更の申請（承認済みで適用日が未来日）が1件以上存在する場合
			// W035							医師は異動が予定されています。
			SelectND012MainDataEntity paramChkEntity = new SelectND012MainDataEntity();
			paramChkEntity.setSqlId("selectND012CheckTkdData");
			paramChkEntity.setInDocNo(indto.getTkdDocNo());
			paramChkEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
			List<SelectND012MainDataEntity> chkEntityList1 = dao.select(paramChkEntity);
			if(chkEntityList1.size() > 0) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W035);//医師は異動が予定されています。
				msgStr = msgStr + tmpMsgStr + "\n";
			}

		}

		//		整合性チェック                              所属学会一覧内で所属学会名が重複しているデータが存在する場合
		List<HcpSocietyData> societyDataList = indto.getHcpSocietyDataList();
		if (societyDataList.size() > 1) {
			String[] medicalSocietyNmArray = new String[societyDataList.size()];
			int i = 0;
			for (HcpSocietyData sData : societyDataList) {
				medicalSocietyNmArray[i] = sData.getMedicalSocietyNm();
				i++;
			}
			int duplicate = 0;
			for (int j = 0; j < medicalSocietyNmArray.length; j++) {
				for (int k = 0; k < medicalSocietyNmArray.length; k++) {
					if (k != j && medicalSocietyNmArray[k].equals(medicalSocietyNmArray[j])) {
						duplicate++;
					}
				}
			}
			if(duplicate >= 2) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W047);//同一名称の所属学会が設定されています。所属学会の編集で名称を変更するか、戻るボタンで本画面を閉じてから再度申請を行ってください。
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//		整合性チェック                              公的機関一覧内で公的機関が重複しているデータが存在する場合
		List<HcpPublicData> publicDataList = indto.getHcpPublicDataList();
		if (publicDataList.size() > 1) {
			String[] pubInstitutionCdArray = new String[publicDataList.size()];
			int i = 0;
			for (HcpPublicData pData : publicDataList) {
				pubInstitutionCdArray[i] = pData.getPubInstitutionCd();
				i++;
			}
			int duplicate = 0;
			for (int j = 0; j < pubInstitutionCdArray.length; j++) {
				for (int k = 0; k < pubInstitutionCdArray.length; k++) {
					if (k != j && pubInstitutionCdArray[k].equals(pubInstitutionCdArray[j])) {
						duplicate++;
					}
				}
			}
			if(duplicate >= 2) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W048);//同一の公的機関が設定されています。公的機関の編集で公的機関を変更するか、戻るボタンで本画面を閉じてから再度申請を行ってください。
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

	private boolean checkPublicData(HcpPublicData pData, TRdmHcpPublicReqEntity pEntity) {
		HcpPublicData pdData = new HcpPublicData();
		pdData.setClassCategoryCd(StringUtils.nvl(pEntity.getClassCategoryCd(), ""));
		pdData.setPubInstitutionCd(StringUtils.nvl(pEntity.getPubInstitutionCd(), ""));
		pdData.setPubInstStYYYY(StringUtils.nvl(pEntity.getPubInstStYYYY(), ""));
		pdData.setPubInstStMM(StringUtils.nvl(pEntity.getPubInstStMM(), ""));
		pdData.setPubInstStDD(StringUtils.nvl(pEntity.getPubInstStDD(), ""));
		pdData.setPubInstEdYYYY(StringUtils.nvl(pEntity.getPubInstEdYYYY(), ""));
		pdData.setPubInstEdMM(StringUtils.nvl(pEntity.getPubInstEdMM(), ""));
		pdData.setPubInstEdDD(StringUtils.nvl(pEntity.getPubInstEdDD(), ""));
		pdData.setPubInstPositionCd(StringUtils.nvl(pEntity.getPubInstPositionCd(), ""));
		pdData.setPubInstposStYYYY(StringUtils.nvl(pEntity.getPubInstposStYYYY(), ""));
		pdData.setPubInstposStMM(StringUtils.nvl(pEntity.getPubInstposStMM(), ""));
		pdData.setPubInstposStDD(StringUtils.nvl(pEntity.getPubInstposStDD(), ""));
		pdData.setPubInstposEdYYYY(StringUtils.nvl(pEntity.getPubInstposEdYYYY(), ""));
		pdData.setPubInstposEdMM(StringUtils.nvl(pEntity.getPubInstposEdMM(), ""));
		pdData.setPubInstposEdDD(StringUtils.nvl(pEntity.getPubInstposEdDD(), ""));
		String pd = pData.toChkString();
		String pe = pdData.toChkString();
		if(pd.equals(pe)) {
			return true;
		}
		return false;
	}

	private boolean checkSocietyData(HcpSocietyData sData, TRdmHcpSocietyReqEntity sEntity) {
		HcpSocietyData sdData = new HcpSocietyData();
		sdData.setMedicalSocietyNm(StringUtils.nvl(sEntity.getMedicalSocietyNm(), ""));
		sdData.setAdmissionYYYY(StringUtils.nvl(sEntity.getAdmissionYYYY(), ""));
		sdData.setAdmissionMM(StringUtils.nvl(sEntity.getAdmissionMM(), ""));
		sdData.setAdmissionDD(StringUtils.nvl(sEntity.getAdmissionDD(), ""));
		sdData.setQuitYYYY(StringUtils.nvl(sEntity.getQuitYYYY(), ""));
		sdData.setQuitMM(StringUtils.nvl(sEntity.getQuitMM(), ""));
		sdData.setQuitDD(StringUtils.nvl(sEntity.getQuitDD(), ""));
		sdData.setPositionCode(StringUtils.nvl(sEntity.getPositionCode(), ""));
		sdData.setSocietyPosiStYYYY(StringUtils.nvl(sEntity.getSocietyPosiStYYYY(), ""));
		sdData.setSocietyPosiStMM(StringUtils.nvl(sEntity.getSocietyPosiStMM(), ""));
		sdData.setSocietyPosiStDD(StringUtils.nvl(sEntity.getSocietyPosiStDD(), ""));
		sdData.setSocietyPosiEdYYYY(StringUtils.nvl(sEntity.getSocietyPosiEdYYYY(), ""));
		sdData.setSocietyPosiEdMM(StringUtils.nvl(sEntity.getSocietyPosiEdMM(), ""));
		sdData.setSocietyPosiEdDD(StringUtils.nvl(sEntity.getSocietyPosiEdDD(), ""));
		sdData.setAdvisingDoctorCd(StringUtils.nvl(sEntity.getAdvisingDoctorCd(), ""));
		sdData.setCoachingAcquisiYYYY(StringUtils.nvl(sEntity.getCoachingAcquisiYYYY(), ""));
		sdData.setCoachingAcquisiMM(StringUtils.nvl(sEntity.getCoachingAcquisiMM(), ""));
		sdData.setCoachingAcquisiDD(StringUtils.nvl(sEntity.getCoachingAcquisiDD(), ""));
		sdData.setCoachingStYYYY(StringUtils.nvl(sEntity.getCoachingStYYYY(), ""));
		sdData.setCoachingStMM(StringUtils.nvl(sEntity.getCoachingStMM(), ""));
		sdData.setCoachingStDD(StringUtils.nvl(sEntity.getCoachingStDD(), ""));
		sdData.setCoachingEdYYYY(StringUtils.nvl(sEntity.getCoachingEdYYYY(), ""));
		sdData.setCoachingEdMM(StringUtils.nvl(sEntity.getCoachingEdMM(), ""));
		sdData.setCoachingEdDD(StringUtils.nvl(sEntity.getCoachingEdDD(), ""));
		sdData.setCertifyingPhysicianCd(StringUtils.nvl(sEntity.getCertifyingPhysicianCd(), ""));
		sdData.setCertifyStYYYY(StringUtils.nvl(sEntity.getCertifyStYYYY(), ""));
		sdData.setCertifyStMM(StringUtils.nvl(sEntity.getCertifyStMM(), ""));
		sdData.setCertifyStDD(StringUtils.nvl(sEntity.getCertifyStDD(), ""));
		sdData.setCertifyEdYYYY(StringUtils.nvl(sEntity.getCertifyEdYYYY(), ""));
		sdData.setCertifyEdMM(StringUtils.nvl(sEntity.getCertifyEdMM(), ""));
		sdData.setCertifyEdDD(StringUtils.nvl(sEntity.getCertifyEdDD(), ""));

		String sd = sData.toChkString();
		String se = sdData.toChkString();
		if(sd.equals(se)) {
			return true;
		}
		return false;
	}

    /**
     * 変更前文字列と変更後文字列を比較し、同一なら空文字、
     * 不一致かつ変更後文字列が空文字ならZ、不一致かつ変更後が空文字以外なら変更後文字列を返す
     * @return
     */
    public static String getUpdStr(String strNew, String strOld) {
        if (strNew.equals(strOld)) {
            return null;
        } else {
        	if(StringUtils.isEmpty(strNew)) {
        		return "Z";
        	}else {
        		return strNew;
        	}
        }
    }
}
