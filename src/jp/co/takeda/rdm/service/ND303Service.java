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
import jp.co.takeda.rdm.dto.ND303DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpShusshinkoEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpDiseaseEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpLiverEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpYakushokuEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpPublicDataEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpSocietyDataEntity;
import jp.co.takeda.rdm.entity.join.SelectND012MainDataEntity;
import jp.co.takeda.rdm.entity.join.SelectND303MainDataEntity;
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
 * Serviceクラス（ND303)
 * @generated
 */
@Named
public class ND303Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(ND303Service.class);

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
	 * @param indto ND303DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND303DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		List<HcpSocietyData> hcpSocietyDataList = new ArrayList<HcpSocietyData>();
		List<HcpSocietyData> beforeHcpSocietyDataList = new ArrayList<HcpSocietyData>();
		List<HcpPublicData> hcpPublicDataList = new ArrayList<HcpPublicData>();
		List<HcpPublicData> beforeHcpPublicDataList = new ArrayList<HcpPublicData>();
//		登録画面から申請IDを連携
		if (indto.getReqId() != null) {
			// 申請データ（一時保存含む）を参照
			SelectND303MainDataEntity paramEntity = new SelectND303MainDataEntity();
			paramEntity.setInReqId(indto.getReqId());
			List<SelectND303MainDataEntity> mainDataEntityList = dao.select(paramEntity);
			SelectND303MainDataEntity mainDataEntity = mainDataEntityList.get(0);
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

			// NULLは変更前と同値、Zは空文字に変換して表示する nvlUpd
			indto.setDocType(StringUtils.nvlUpd(mainDataEntity.getDocType(), mainDataEntity.getMstDocType()));
			if(StringUtils.isZ(mainDataEntity.getDocType())) {
				indto.setDocTypeNm("");
			}else {
				indto.setDocTypeNm(StringUtils.nvlUpd(mainDataEntity.getDocTypeNm(), mainDataEntity.getMstDocTypeNm()));
			}
			indto.setSexCd(StringUtils.nvlUpd(mainDataEntity.getSexCd(), mainDataEntity.getMstSexCd()));
			if(StringUtils.isZ(mainDataEntity.getSexCd())) {
				indto.setSexNm("");
			}else {
				indto.setSexNm(StringUtils.nvlUpd(mainDataEntity.getSexNm(), mainDataEntity.getMstSexNm()));
			}
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
			if(StringUtils.isZ(mainDataEntity.getHomeTownCd())) {
				indto.setHomeTownNm("");
			}else {
				indto.setHomeTownNm(StringUtils.nvlUpd(mainDataEntity.getHomeTownNm(), mainDataEntity.getMstHomeTownNm()));
			}
			indto.setMedSchoolCd(StringUtils.nvlUpd(mainDataEntity.getMedSchoolCd(), mainDataEntity.getMstMedSchoolCd()));
			if(StringUtils.isZ(mainDataEntity.getMedSchoolCd())) {
				indto.setMedSchoolNm("");
			}else {
				indto.setMedSchoolNm(StringUtils.nvlUpd(mainDataEntity.getMedSchoolNm(), mainDataEntity.getMstMedSchoolNm()));
			}
			indto.setGradYear(StringUtils.nvlUpd(mainDataEntity.getGradYear(), mainDataEntity.getMstGradYear()));
			indto.setEmplYear(StringUtils.nvlUpd(mainDataEntity.getEmplYear(), mainDataEntity.getMstEmplYear()));
			indto.setHomeUnivCd(StringUtils.nvlUpd(mainDataEntity.getHomeUnivCd(), mainDataEntity.getMstHomeUnivCd()));
			if(StringUtils.isZ(mainDataEntity.getHomeUnivCd())) {
				indto.setHomeUnivNm("");
			}else {
				indto.setHomeUnivNm(StringUtils.nvlUpd(mainDataEntity.getHomeUnivNm(), mainDataEntity.getMstHomeUnivNm()));
			}
			indto.setHomeDeptCd(StringUtils.nvlUpd(mainDataEntity.getHomeDeptCd(), mainDataEntity.getMstHomeDeptCd()));
			if(StringUtils.isZ(mainDataEntity.getHomeDeptCd())) {
				indto.setHomeDeptNm("");
			}else {
				indto.setHomeDeptNm(StringUtils.nvlUpd(mainDataEntity.getHomeDeptNm(), mainDataEntity.getMstHomeDeptNm()));
			}
			indto.setSpLiverCd(StringUtils.nvlUpd(mainDataEntity.getSpLiverCd(), mainDataEntity.getMstSpLiverCd()));
			if(StringUtils.isZ(mainDataEntity.getSpLiverCd())) {
				indto.setSpLiverNm("");
			}else {
				indto.setSpLiverNm(StringUtils.nvlUpd(mainDataEntity.getSpLiverNm(), mainDataEntity.getMstSpLiverNm()));
			}
			indto.setSpDiseaseCd(StringUtils.nvlUpd(mainDataEntity.getSpDiseaseCd(), mainDataEntity.getMstSpDiseaseCd()));
			if(StringUtils.isZ(mainDataEntity.getSpDiseaseCd())) {
				indto.setSpDiseaseNm("");
			}else {
				indto.setSpDiseaseNm(StringUtils.nvlUpd(mainDataEntity.getSpDiseaseNm(), mainDataEntity.getMstSpDiseaseNm()));
			}
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

			indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
			indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
			indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));
			indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
			indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));

			// 所属学会リスト
			SelectHcpSocietyDataEntity societyParamEntity = new SelectHcpSocietyDataEntity();
			societyParamEntity.setSqlId("selectHcpSocietyDataMarge");
			societyParamEntity.setInDocNo(indto.getTkdDocNo());
			societyParamEntity.setInReqId(indto.getReqId());
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
			// 公的機関リスト
			SelectHcpPublicDataEntity publicParamEntity = new SelectHcpPublicDataEntity();
			publicParamEntity.setSqlId("selectHcpPublicDataMarge");
			publicParamEntity.setInDocNo(indto.getTkdDocNo());
			publicParamEntity.setInReqId(indto.getReqId());
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
			if(indto.getReqStsCd().equals("01")) {
				//申請者の操作では申請者情報にログイン情報をセットしておく
				indto.setReqShzNm(loginInfo.getBumonRyakuName());
				indto.setReqJgiName(loginInfo.getJgiName());
				indto.setReqJgiNo(loginInfo.getJgiNo());
				indto.setReqBrCd(loginInfo.getBrCode());
				indto.setReqDistCd(loginInfo.getDistCode());
			}
		} else {
			//TODO 遷移エラー
		}

		// パラメタ医師メニュー取得
		indto.setBtnEnableFlg("0");
		MRdmParamMstEntity mRdmParamMstEntity = new MRdmParamMstEntity();
		mRdmParamMstEntity.setParamName(jp.co.takeda.rdm.util.RdmConstantsData.PARAM_NAME_MN_DOC);
		mRdmParamMstEntity.setDelFlg("0");

		List<MRdmParamMstEntity> mRdmParamMstEntityList = dao.selectByValue(mRdmParamMstEntity);
		if(mRdmParamMstEntityList.size() > 0) {
			// valueの左2桁（更新）
			String value = mRdmParamMstEntityList.get(0).getValue().substring(1,2);
			if("1".equals(value)) {
				// 申請・承認・却下ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}
//		if(loginInfo.getJokenSetCd().equals(RdmConstantsData.RDM_JKN_ADMIN)) {
//			indto.setFbReqFlg(true);//初期値はチェックON
//		}
//		indto.setHcpSocietyDataChgFlg("0");
//		indto.setHcpPublicDataChgFlg("0");
		indto.setLoginJokenSetCd(loginInfo.getJokenSetCd());//MDM管理者：JKN0850 全MR：JKN0023
		indto.setLoginJgiNo(loginInfo.getJgiNo());
//		// DropDownList作成
//		createCombo(indto);

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
	 * イベント処理
	 * @param indto ND303DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(ND303DTO indto) {
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
			// valueの左2桁（更新）
			String value = mRdmParamMstEntityList.get(0).getValue().substring(1,2);
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
//			if(indto.getReqId() != null && !StringUtils.isEmpty(indto.getReqId())) {
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
//				if ("1".equals(indto.getButtonFlg())) {//承認
//					if(reqChl.equals("3")) {//ULT起因
//						updateEntity1.setReqStsCd("14");//　申請ステータス
//					}else {
//						updateEntity1.setReqStsCd("04");//　申請ステータス
//					}
//					updateEntity1.setAprBrCode(loginInfo.getBrCode());// 承認者所属リージョン
//					updateEntity1.setAprDistCode(loginInfo.getDistCode());// 承認者所属エリア
//					updateEntity1.setAprShz(loginInfo.getBumonRyakuName());// 承認者所属
//					updateEntity1.setAprJgiNo(loginInfo.getJgiNo());// 承認者従業員番号
//					updateEntity1.setAprShaName(loginInfo.getJgiName());// 承認者氏名
//					updateEntity1.setAprYmdhms(strDate);// 承認日時
//					if(indto.getFbReqFlg()) {
//						updateEntity1.setFbReqFlg("1");//FB申請要否フラグ
//					}else {
//						updateEntity1.setFbReqFlg("0");//FB申請要否フラグ
//					}
//					updateEntity1.setAprComment(indto.getAprComment());//承認者コメント
//				}
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
				}
				updateEntity1.setUpdShaYmd(currentDt);//更新日
				updateEntity1.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				dao.update(updateEntity1);

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
	private boolean checkInput(LoginInfo loginInfo, ND303DTO indto, boolean fullchkFlg) {
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
		//      却下コメント                                ３００文字を超えている場合
		if(!StringUtils.isEmpty(indto.getAprComment())) {
			len = StringUtils.getByteLength(indto.getAprComment());
			if(len > 300) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "却下コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		// 勤務先変更の申請（承認済みで適用日が未来日）が1件以上存在する場合
		// W035							医師は異動が予定されています。
		SelectND012MainDataEntity paramChkEntity = new SelectND012MainDataEntity();
		paramChkEntity.setSqlId("selectND303CheckTkdData");
		paramChkEntity.setInDocNo(indto.getTkdDocNo());
		paramChkEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
		List<SelectND012MainDataEntity> chkEntityList1 = dao.select(paramChkEntity);
		if(chkEntityList1.size() > 0) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W035);//医師は異動が予定されています。
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

}
