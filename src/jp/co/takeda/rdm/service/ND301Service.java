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
import jp.co.takeda.rdm.dto.ND301DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpShusshinkoEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpDiseaseEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpLiverEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpYakushokuEntity;
import jp.co.takeda.rdm.entity.join.MRdmParamMstEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpPublicDataEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpSocietyDataEntity;
import jp.co.takeda.rdm.entity.join.SelectND301MainDataEntity;
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
 * Serviceクラス（ND301)
 * @generated
 */
@Named
public class ND301Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(ND301Service.class);

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
	 * @param indto ND301DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(ND301DTO indto) {
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
			SelectND301MainDataEntity paramEntity = new SelectND301MainDataEntity();
			paramEntity.setInReqId(indto.getReqId());
			List<SelectND301MainDataEntity> mainDataEntityList = dao.select(paramEntity);
			SelectND301MainDataEntity mainDataEntity = mainDataEntityList.get(0);
			indto.setReqShzNm(StringUtils.nvl(mainDataEntity.getReqShzNm(), ""));
			indto.setReqStsNm(StringUtils.nvl(mainDataEntity.getReqStsNm(), ""));
			indto.setReqJgiName(StringUtils.nvl(mainDataEntity.getReqJgiName(), ""));
			indto.setReqYmdhms(StringUtils.nvl(mainDataEntity.getReqYmdhms(), ""));
			indto.setShnShaName(StringUtils.nvl(mainDataEntity.getShnShaName(), ""));
			indto.setShnYmdhms(StringUtils.nvl(mainDataEntity.getShnYmdhms(), ""));
			indto.setAprShaName(StringUtils.nvl(mainDataEntity.getAprShaName(), ""));
			indto.setAprYmdhms(StringUtils.nvl(mainDataEntity.getAprYmdhms(), ""));
			indto.setReqJgiNo(mainDataEntity.getReqJgiNo());
			indto.setReqBrCd(StringUtils.nvl(mainDataEntity.getReqBrCd(), ""));
			indto.setReqDistCd(StringUtils.nvl(mainDataEntity.getReqDistCd(), ""));
			indto.setReqStsCd(StringUtils.nvl(mainDataEntity.getReqStsCd(), ""));
			indto.setShnJgiNo(mainDataEntity.getShnJgiNo());
			indto.setAprJgiNo(mainDataEntity.getAprJgiNo());
			indto.setUpdShaYmd(StringUtils.nvl(mainDataEntity.getUpdShaYmd(), ""));
			indto.setUltDocNo(StringUtils.nvl(mainDataEntity.getUltDocNo(), ""));
			indto.setUltDocNm(StringUtils.nvl(mainDataEntity.getUltDocNm(), ""));
			indto.setUltDocKana(StringUtils.nvl(mainDataEntity.getUltDocKana(), ""));
			indto.setDocType(StringUtils.nvl(mainDataEntity.getDocType(), ""));
			indto.setDocTypeNm(StringUtils.nvl(mainDataEntity.getDocTypeNm(), ""));
			indto.setSexCd(StringUtils.nvl(mainDataEntity.getSexCd(), ""));
			indto.setSexNm(StringUtils.nvl(mainDataEntity.getSexNm(), ""));
			indto.setDocKanjiSei(StringUtils.nvl(mainDataEntity.getDocKanjiSei(), ""));
			indto.setDocKanjiMei(StringUtils.nvl(mainDataEntity.getDocKanjiMei(), ""));
			indto.setDocKanaSei(StringUtils.nvl(mainDataEntity.getDocKanaSei(), ""));
			indto.setDocKanaMei(StringUtils.nvl(mainDataEntity.getDocKanaMei(), ""));
			indto.setOldKanjSei(StringUtils.nvl(mainDataEntity.getOldKanjSei(), ""));
			indto.setOldKanaSei(StringUtils.nvl(mainDataEntity.getOldKanaSei(), ""));
			indto.setNewNameStYear(StringUtils.nvl(mainDataEntity.getNewNameStYear(), ""));
			indto.setNewNameStMonth(StringUtils.nvl(mainDataEntity.getNewNameStMonth(), ""));
			indto.setNewNameStDay(StringUtils.nvl(mainDataEntity.getNewNameStDay(), ""));
			indto.setDobYear(StringUtils.nvl(mainDataEntity.getDobYear(), ""));
			indto.setDobMonth(StringUtils.nvl(mainDataEntity.getDobMonth(), ""));
			indto.setDobDay(StringUtils.nvl(mainDataEntity.getDobDay(), ""));
			indto.setHomeTownCd(StringUtils.nvl(mainDataEntity.getHomeTownCd(), ""));
			indto.setHomeTownNm(StringUtils.nvl(mainDataEntity.getHomeTownNm(), ""));
			indto.setMedSchoolCd(StringUtils.nvl(mainDataEntity.getMedSchoolCd(), ""));
			indto.setMedSchoolNm(StringUtils.nvl(mainDataEntity.getMedSchoolNm(), ""));
			indto.setGradYear(StringUtils.nvl(mainDataEntity.getGradYear(), ""));
			indto.setEmplYear(StringUtils.nvl(mainDataEntity.getEmplYear(), ""));
			indto.setHomeUnivCd(StringUtils.nvl(mainDataEntity.getHomeUnivCd(), ""));
			indto.setHomeUnivNm(StringUtils.nvl(mainDataEntity.getHomeUnivNm(), ""));
			indto.setHomeDeptNm(StringUtils.nvl(mainDataEntity.getHomeDeptNm(), ""));
			indto.setSpLiverCd(StringUtils.nvl(mainDataEntity.getSpLiverCd(), ""));
			indto.setSpLiverNm(StringUtils.nvl(mainDataEntity.getSpLiverNm(), ""));
			indto.setSpDiseaseCd(StringUtils.nvl(mainDataEntity.getSpDiseaseCd(), ""));
			indto.setSpDiseaseNm(StringUtils.nvl(mainDataEntity.getSpDiseaseNm(), ""));
			indto.setSpCom(StringUtils.nvl(mainDataEntity.getSpCom(), ""));
			indto.setHomeDeptCd(StringUtils.nvl(mainDataEntity.getHomeDeptCd(), ""));
			indto.setSkInsNm(StringUtils.nvl(mainDataEntity.getSkInsNm(), ""));
			indto.setSkUnivPosCd(StringUtils.nvl(mainDataEntity.getSkUnivPosCd(), ""));
			indto.setSkUnivPosNm(StringUtils.nvl(mainDataEntity.getSkUnivPosNm(), ""));
			indto.setSkDeptNm(StringUtils.nvl(mainDataEntity.getSkDeptNm(), ""));
			indto.setSkTitleCd(StringUtils.nvl(mainDataEntity.getSkTitleCd(), ""));
			indto.setSkTitleNm(StringUtils.nvl(mainDataEntity.getSkTitleNm(), ""));
			indto.setSkJobForm(StringUtils.nvl(mainDataEntity.getSkJobForm(), ""));
			indto.setSkJobFormNm(StringUtils.nvl(mainDataEntity.getSkJobFormNm(), ""));
			indto.setSkDcctype(StringUtils.nvl(mainDataEntity.getSkDcctype(), ""));
			indto.setSkDcctypeNm(StringUtils.nvl(mainDataEntity.getSkDcctypeNm(), ""));
			indto.setSkInsNo(StringUtils.nvl(mainDataEntity.getSkInsNo(), ""));
			indto.setSkDeptCd(StringUtils.nvl(mainDataEntity.getSkDeptCd(), ""));
			indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
			indto.setAprComment(StringUtils.nvl(mainDataEntity.getAprComment(), ""));
			indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
			indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));

			// 所属学会リスト
			SelectHcpSocietyDataEntity societyParamEntity = new SelectHcpSocietyDataEntity();
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
			// valueの左一桁（新規）
			String value = mRdmParamMstEntityList.get(0).getValue().substring(0,1);
			if("1".equals(value)) {
				// 申請・承認・却下ボタン活性
				indto.setBtnEnableFlg("1");
			}
		}

//		indto.setHcpSocietyDataChgFlg("0");
//		indto.setHcpPublicDataChgFlg("0");
		indto.setLoginJokenSetCd("JKN0813");//MDM管理者：JKN0813 全MR：JKN0023
		indto.setLoginJgiNo(loginInfo.getJgiNo());
//		// DropDownList作成
//		createCombo(indto);

		// END UOC
		return outdto;
	}

	private void setHcpPublicData(SelectHcpPublicDataEntity pEntity, HcpPublicData pData) {
		pData.setClassCategoryCd(StringUtils.nvl(pEntity.getClassCategoryCd(), ""));
		pData.setClassCategoryNm(StringUtils.nvl(pEntity.getClassCategoryNm(), ""));
		pData.setPubInstitutionCd(StringUtils.nvl(pEntity.getPubInstitutionCd(), ""));
		pData.setPubInstitutionNm(StringUtils.nvl(pEntity.getPubInstitutionNm(), ""));
		pData.setPubInstStYYYY(StringUtils.nvl(pEntity.getPubInstStYYYY(), ""));
		pData.setPubInstStMM(StringUtils.nvl(pEntity.getPubInstStMM(), ""));
		pData.setPubInstStDD(StringUtils.nvl(pEntity.getPubInstStDD(), ""));
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
		pData.setPubInstEdYYYY(StringUtils.nvl(pEntity.getPubInstEdYYYY(), ""));
		pData.setPubInstEdMM(StringUtils.nvl(pEntity.getPubInstEdMM(), ""));
		pData.setPubInstEdDD(StringUtils.nvl(pEntity.getPubInstEdDD(), ""));
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
		pData.setPubInstPositionCd(StringUtils.nvl(pEntity.getPubInstPositionCd(), ""));
		pData.setPubInstPositionNm(StringUtils.nvl(pEntity.getPubInstPositionNm(), ""));
		pData.setPubInstposStYYYY(StringUtils.nvl(pEntity.getPubInstposStYYYY(), ""));
		pData.setPubInstposStMM(StringUtils.nvl(pEntity.getPubInstposStMM(), ""));
		pData.setPubInstposStDD(StringUtils.nvl(pEntity.getPubInstposStDD(), ""));
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
		pData.setPubInstposEdYYYY(StringUtils.nvl(pEntity.getPubInstposEdYYYY(), ""));
		pData.setPubInstposEdMM(StringUtils.nvl(pEntity.getPubInstposEdMM(), ""));
		pData.setPubInstposEdDD(StringUtils.nvl(pEntity.getPubInstposEdDD(), ""));
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
		sData.setAdmissionYYYY(StringUtils.nvl(sEntity.getAdmissionYYYY(), ""));
		sData.setAdmissionMM(StringUtils.nvl(sEntity.getAdmissionMM(), ""));
		sData.setAdmissionDD(StringUtils.nvl(sEntity.getAdmissionDD(), ""));
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
		sData.setQuitYYYY(StringUtils.nvl(sEntity.getQuitYYYY(), ""));
		sData.setQuitMM(StringUtils.nvl(sEntity.getQuitMM(), ""));
		sData.setQuitDD(StringUtils.nvl(sEntity.getQuitDD(), ""));
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
		sData.setPositionCode(StringUtils.nvl(sEntity.getPositionCode(), ""));
		sData.setPositionName(StringUtils.nvl(sEntity.getPositionName(), ""));
		sData.setSocietyPosiStYYYY(StringUtils.nvl(sEntity.getSocietyPosiStYYYY(), ""));
		sData.setSocietyPosiStMM(StringUtils.nvl(sEntity.getSocietyPosiStMM(), ""));
		sData.setSocietyPosiStDD(StringUtils.nvl(sEntity.getSocietyPosiStDD(), ""));
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
		sData.setSocietyPosiEdYYYY(StringUtils.nvl(sEntity.getSocietyPosiEdYYYY(), ""));
		sData.setSocietyPosiEdMM(StringUtils.nvl(sEntity.getSocietyPosiEdMM(), ""));
		sData.setSocietyPosiEdDD(StringUtils.nvl(sEntity.getSocietyPosiEdDD(), ""));
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
		sData.setAdvisingDoctorCd(StringUtils.nvl(sEntity.getAdvisingDoctorCd(), ""));
		sData.setAdvisingDoctorNm(StringUtils.nvl(sEntity.getAdvisingDoctorNm(), ""));
		sData.setCoachingAcquisiYYYY(StringUtils.nvl(sEntity.getCoachingAcquisiYYYY(), ""));
		sData.setCoachingAcquisiMM(StringUtils.nvl(sEntity.getCoachingAcquisiMM(), ""));
		sData.setCoachingAcquisiDD(StringUtils.nvl(sEntity.getCoachingAcquisiDD(), ""));
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
		sData.setCoachingStYYYY(StringUtils.nvl(sEntity.getCoachingStYYYY(), ""));
		sData.setCoachingStMM(StringUtils.nvl(sEntity.getCoachingStMM(), ""));
		sData.setCoachingStDD(StringUtils.nvl(sEntity.getCoachingStDD(), ""));
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
		sData.setCoachingEdYYYY(StringUtils.nvl(sEntity.getCoachingEdYYYY(), ""));
		sData.setCoachingEdMM(StringUtils.nvl(sEntity.getCoachingEdMM(), ""));
		sData.setCoachingEdDD(StringUtils.nvl(sEntity.getCoachingEdDD(), ""));
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
		sData.setCertifyingPhysicianCd(StringUtils.nvl(sEntity.getCertifyingPhysicianCd(), ""));
		sData.setCertifyingPhysicianNm(StringUtils.nvl(sEntity.getCertifyingPhysicianNm(), ""));
		sData.setCertifyStYYYY(StringUtils.nvl(sEntity.getCertifyStYYYY(), ""));
		sData.setCertifyStMM(StringUtils.nvl(sEntity.getCertifyStMM(), ""));
		sData.setCertifyStDD(StringUtils.nvl(sEntity.getCertifyStDD(), ""));
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
		sData.setCertifyEdYYYY(StringUtils.nvl(sEntity.getCertifyEdYYYY(), ""));
		sData.setCertifyEdMM(StringUtils.nvl(sEntity.getCertifyEdMM(), ""));
		sData.setCertifyEdDD(StringUtils.nvl(sEntity.getCertifyEdDD(), ""));
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

//	/**
//	 * コンボ作成
//	 * @param indto ND301DTO
//	 * @return なし
//	 * @customizable
//	 */
//	private void createCombo(ND301DTO indto){
//		//1-2-1     医師／薬剤師区分
//		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
//		//            コード名＝DOC_TYPE（医師／薬剤師区分）
//		//            削除フラグ=0
//		SelectComboListEntity inEntityCmb = new SelectComboListEntity();
//		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_DOC_TYPE);
//		List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
//		LinkedHashMap<String, String> mapDocType = new LinkedHashMap<String, String>();
//		mapDocType.put("", "--なし--");
//		for (SelectComboListEntity outEntity : outMainList) {
//			mapDocType.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
//		}
//		indto.setDocTypeCombo(mapDocType);
//
//		//1-2-2     性別
//		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
//		//            コード名＝MF（性別）
//		//            削除フラグ=0
//		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_MF);
//		outMainList.clear();
//		outMainList = dao.select(inEntityCmb);
//		LinkedHashMap<String, String> mapMF = new LinkedHashMap<String, String>();
//		mapMF.put("", "--なし--");
//		for (SelectComboListEntity outEntity : outMainList) {
//			mapMF.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
//		}
//		indto.setSexCdCombo(mapMF);
//		//1-2-3     改姓日
//		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
//		//            年      現在日付の年+1年～－100年
//		//            月      01～12
//		//            日      01～31
//		MRdmComCalUsrEntity inEntityYearCmb = new MRdmComCalUsrEntity();
//		inEntityYearCmb.setToday("1");
//		MRdmComCalUsrEntity outCalUsr = dao.selectByValue(inEntityYearCmb).get(0);
//		int yearInt = Integer.parseInt(outCalUsr.getCalYear());
//		LinkedHashMap<String, String> mapYear = new LinkedHashMap<String, String>();
//		mapYear.put("", "");
//		for (int i = 0; i < 101; i++) {
//			String yearStr = Integer.toString(yearInt + 1 - i);
//			mapYear.put(yearStr, yearStr);
//		}
//		indto.setNewNameStYearCombo(mapYear);
//
//		LinkedHashMap<String, String> mapMonth = new LinkedHashMap<String, String>();
//		mapMonth.put("", "");
//		for (int i = 0; i < 12; i++) {
//			String monthStr = String.format("%02d", (i+1));
//			mapMonth.put(monthStr, monthStr);
//		}
//		indto.setNewNameStMonthCombo(mapMonth);
//
//		LinkedHashMap<String, String> mapDay = new LinkedHashMap<String, String>();
//		mapDay.put("", "");
//		for (int i = 0; i < 31; i++) {
//			String dayStr = String.format("%02d", (i+1));
//			mapDay.put(dayStr, dayStr);
//		}
//		indto.setNewNameStDayCombo(mapDay);
//
//		//1-2-4     生年月日
//		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
//		//            年      現在日付の年+1年～－100年
//		//            月      01～12
//		//            日      01～31
//		indto.setDobYearCombo(mapYear);
//		indto.setDobMonthCombo(mapMonth);
//		indto.setDobDayCombo(mapDay);
//
//		//1-2-5     出身地
//		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
//		//            コード名＝HOME_TOWN（出身地）
//		//            削除フラグ=0
//		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_HOME_TOWN);
//		outMainList.clear();
//		outMainList = dao.select(inEntityCmb);
//		LinkedHashMap<String, String> mapHomeTown = new LinkedHashMap<String, String>();
//		mapHomeTown.put("", "--なし--");
//		for (SelectComboListEntity outEntity : outMainList) {
//			mapHomeTown.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
//		}
//		indto.setHomeTownCdCombo(mapHomeTown);
//		//1-2-6     出身校              「補足_出身医局校_出身校リスト」シート参照
//		//医師_出身大学マスタから下記条件で「武田出身大学コード：出身大学漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
//		//        出身校利用フラグ=1
//		//        削除フラグ=0
//		MRdmHcpShusshinkoEntity inEntitySskCmb = new MRdmHcpShusshinkoEntity();
//		inEntitySskCmb.setUnivFlg(1);
//		inEntitySskCmb.setDelFlg(0);
//		List<MRdmHcpShusshinkoEntity> outMainSskList = dao.selectByValue(inEntitySskCmb);
//		LinkedHashMap<String, String> mapMedSchoolCd = new LinkedHashMap<String, String>();
//		mapMedSchoolCd.put("", "--なし--");
//		for (MRdmHcpShusshinkoEntity outEntity : outMainSskList) {
//			mapMedSchoolCd.put(outEntity.getUnivCode(), outEntity.getUnivKj());
//		}
//		indto.setMedSchoolCdCombo(mapMedSchoolCd);
//
//		//1-2-7     卒年（西暦）
//		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
//		//            年      現在日付の年+1年～－100年
//		indto.setGradYearCombo(mapYear);
//
//		//1-2-8     臨床研修年（西暦）
//		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
//		//            年      現在日付の年+1年～－100年
//		indto.setEmplYearCombo(mapYear);
//
//		//1-2-9     出身医局校                  「補足_出身医局校_出身校リスト」シート参照
//		//医師_出身大学マスタから下記条件で「武田出身大学コード：出身大学漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
//		//        出身医局校利用フラグ=1
//		//        削除フラグ=0
//		inEntitySskCmb.setUnivIkkFlg(1);
//		inEntitySskCmb.setDelFlg(0);
//		outMainSskList.clear();
//		outMainSskList = dao.selectByValue(inEntitySskCmb);
//		LinkedHashMap<String, String> mapHomeUnivCd = new LinkedHashMap<String, String>();
//		mapHomeUnivCd.put("", "--なし--");
//		for (MRdmHcpShusshinkoEntity outEntity : outMainSskList) {
//			mapHomeUnivCd.put(outEntity.getUnivCode(), outEntity.getUnivKj());
//		}
//		indto.setHomeUnivCdCombo(mapHomeUnivCd);
//		//1-2-10    専門臓器                「専門臓器一覧」シート参照
//		//医師_専門臓器マスタから下記条件で「専門臓器コード：専門臓器漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
//		//        削除フラグ=0
//		MRdmHcpSpLiverEntity inEntitySLiCmb = new MRdmHcpSpLiverEntity();
//		inEntitySLiCmb.setDelFlg(0);
//		List<MRdmHcpSpLiverEntity> outMainSLiList = dao.selectByValue(inEntitySLiCmb);
//		LinkedHashMap<String, String> mapSpLiverCd = new LinkedHashMap<String, String>();
//		mapSpLiverCd.put("", "--なし--");
//		for (MRdmHcpSpLiverEntity outEntity : outMainSLiList) {
//			mapSpLiverCd.put(outEntity.getSpLiver(), outEntity.getSpLiverKj());
//		}
//		indto.setSpLiverCdCombo(mapSpLiverCd);
//
//		//1-2-11    専門詳細                「専門詳細一覧」シート参照
//		//医師_専門詳細マスタから下記条件で「専門詳細コード：専門詳細漢字名」を並び順の昇順に取得しドロップダウンリストを作成する
//		//        削除フラグ=0
//		MRdmHcpSpDiseaseEntity inEntitySDiCmb = new MRdmHcpSpDiseaseEntity();
//		inEntitySDiCmb.setDelFlg(0);
//		List<MRdmHcpSpDiseaseEntity> outMainSDiList = dao.selectByValue(inEntitySDiCmb);
//		LinkedHashMap<String, String> mapSpDiseaseCd = new LinkedHashMap<String, String>();
//		mapSpDiseaseCd.put("", "--なし--");
//		for (MRdmHcpSpDiseaseEntity outEntity : outMainSDiList) {
//			mapSpDiseaseCd.put(outEntity.getSpDisease(), outEntity.getSpDiseaseKj());
//		}
//		indto.setSpDiseaseCdCombo(mapSpDiseaseCd);
//
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
//	}
	/**
	 * イベント処理
	 * @param indto ND301DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(ND301DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		// START UOC
		//却下ボタン押下の場合
		if ("2".equals(indto.getButtonFlg())) {
			// チェック処理（FULL）
			if(checkInput(loginInfo,indto,true)) {
				return outdto;
			}
		}
		//申請ボタン押下の場合または承認ボタン押下の場合
		if ("0".equals(indto.getButtonFlg()) || "1".equals(indto.getButtonFlg())) {
			// チェック処理（簡易）
			if(checkInput(loginInfo,indto,false)) {
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
				String reqChl = indto.getReqChl();
				if ("0".equals(indto.getButtonFlg())) {//申請
					if(reqChl.equals("3")) {//ULT起因
						updateEntity1.setReqStsCd("13");//　申請ステータス
					}else {
						updateEntity1.setReqStsCd("03");//　申請ステータス
					}
					updateEntity1.setReqBrCd(reqBrCd);// 申請者所属リージョン
					updateEntity1.setReqDistCd(reqDistCd);// 申請者所属エリア
					updateEntity1.setReqShzNm(reqShzNm);// 申請者所属
					updateEntity1.setReqJgiNo(loginInfo.getJgiNo());// 申請者従業員番号
					updateEntity1.setReqJgiName(loginInfo.getJgiName());// 申請者氏名
					updateEntity1.setReqYmdhms(strDate); // 申請日時
					// 申請者権限区分
					if("JKN0813".equals(indto.getLoginJokenSetCd())) {
						//MDM管理者：JKN0813 全MR：JKN0023)
						updateEntity1.setReqKngKbn("2");
					}else {
						updateEntity1.setReqKngKbn("1");
					}
					updateEntity1.setReqComment(indto.getReqComment());//　申請コメント
				}
				if ("1".equals(indto.getButtonFlg())) {//承認
					if(reqChl.equals("3")) {//ULT起因
						updateEntity1.setReqStsCd("14");//　申請ステータス
					}else {
						updateEntity1.setReqStsCd("04");//　申請ステータス
					}
					// 承認者所属リージョン
					// 承認者所属エリア
					// 承認者所属
					updateEntity1.setAprJgiNo(loginInfo.getJgiNo());// 承認者従業員番号
					// 承認者氏名
					updateEntity1.setAprYmdhms(strDate);// 承認日時
					updateEntity1.setFbReqFlg(indto.getFbReqFlg());//FB申請要否フラグ
					updateEntity1.setAprCommnet(indto.getAprComment());//承認者コメント
				}
				if ("2".equals(indto.getButtonFlg())) {//却下
					if(reqChl.equals("3")) {//ULT起因
						updateEntity1.setReqStsCd("12");//　申請ステータス
					}else {
						updateEntity1.setReqStsCd("02");//　申請ステータス
					}
					// 承認者所属リージョン
					// 承認者所属エリア
					// 承認者所属
					updateEntity1.setAprJgiNo(loginInfo.getJgiNo());// 承認者従業員番号
					// 承認者氏名
					updateEntity1.setAprYmdhms(strDate);// 承認日時
					updateEntity1.setAprCommnet(indto.getAprComment());//承認者コメント
				}
				updateEntity1.setUpdShaYmd(currentDt);//更新日
				updateEntity1.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				dao.update(updateEntity1);

				if ("0".equals(indto.getButtonFlg())) {
					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.I005));
					return outdto;
				}
//				if ("1".equals(indto.getButtonFlg())) {
//					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.I015));
//					return outdto;
//				}
//				if ("3".equals(indto.getButtonFlg())) {
//					indto.setMsgStr(loginInfo.getMsgData(RdmConstantsData.I012));
//					return outdto;
//				}
		}
		//TODO 後処理
		// END UOC
		return outdto;
	}

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, ND301DTO indto, boolean fullchkFlg) {
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
		if(StringUtils.isEmpty(indto.getReqComment())) {
			len = StringUtils.getByteLength(indto.getReqComment());
			if(len > 300) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//      申請コメント                                ３００文字を超えている場合
		if(StringUtils.isEmpty(indto.getAprComment())) {
			len = StringUtils.getByteLength(indto.getAprComment());
			if(len > 300) {
				errChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "却下コメント");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		//		項目                                チェック内容
		//		重複申請チェック                                同じULTコードに紐づく医師新規作成申請がすでに存在している場合
		SelectND301MainDataEntity paramChkEntity = new SelectND301MainDataEntity();
		paramChkEntity.setSqlId("selectND301CheckUltData");
		paramChkEntity.setInUltDocNo(indto.getUltDocNo());
		List<SelectND301MainDataEntity> chkEntityList1 = dao.select(paramChkEntity);
		if(!chkEntityList1.isEmpty()) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008);//重複する申請が行われています。（項目名）
			tmpMsgStr = tmpMsgStr.replace("項目名", "ULT医師");
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		//		整合性チェック                              廃院を勤務先施設に選択して申請している場合
		paramChkEntity.setSqlId("selectND301CheckDelInsData");
		paramChkEntity.setSkInsNo(indto.getSkInsNo());
		List<SelectND301MainDataEntity> chkEntityList2 = dao.select(paramChkEntity);
		if(!chkEntityList2.isEmpty()) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W040);//廃業・死亡状態で、申請できません。
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

}
