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
		if("9".equals(indto.getDisplayKbn())) {
			createCombo(indto);
			indto.setDocTypeNm(StringUtils.nvl(indto.getDocTypeCombo().get(indto.getDocType()), ""));
			indto.setSexNm(StringUtils.nvl(indto.getSexCdCombo().get(indto.getSexCd()), ""));
			indto.setHomeTownNm(StringUtils.nvl(indto.getHomeTownCdCombo().get(indto.getHomeTownCd()), ""));
			indto.setMedSchoolNm(StringUtils.nvl(indto.getMedSchoolCdCombo().get(indto.getMedSchoolCd()), ""));
			indto.setHomeUnivNm(StringUtils.nvl(indto.getHomeUnivCdCombo().get(indto.getHomeUnivCd()), ""));
			indto.setSpLiverNm(StringUtils.nvl(indto.getSpLiverCdCombo().get(indto.getSpLiverCd()), ""));
			indto.setSpDiseaseNm(StringUtils.nvl(indto.getSpDiseaseCdCombo().get(indto.getSpDiseaseCd()), ""));
			indto.setSkUnivPosNm(StringUtils.nvl(indto.getSkUnivPosCdCombo().get(indto.getSkUnivPosCd()), ""));
			indto.setSkTitleNm(StringUtils.nvl(indto.getSkTitleCdCombo().get(indto.getSkTitleCd()), ""));
			indto.setSkJobFormNm(StringUtils.nvl(indto.getSkJobFormCombo().get(indto.getSkJobForm()), ""));
			indto.setSkDcctypeNm(StringUtils.nvl(indto.getSkDcctypeCombo().get(indto.getSkDcctype()), ""));

		} else {
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
				indto.setReqChl(StringUtils.nvl(mainDataEntity.getReqChl(), ""));
				indto.setAprMemo(StringUtils.nvl(mainDataEntity.getAprMemo(), ""));
				indto.setShnFlg(StringUtils.nvl(mainDataEntity.getShnFlg(), "0"));
				indto.setSkInsHoInsType(StringUtils.nvl(mainDataEntity.getSkInsHoInsType(), ""));
				indto.setSkInsInsClass(StringUtils.nvl(mainDataEntity.getSkInsInsClass(), ""));

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

				if ("0".equals(indto.getButtonFlg()) || "1".equals(indto.getButtonFlg())) {
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
					updateEntity2.setDocType(indto.getDocType());//医師／薬剤師区分
					updateEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei() );//氏名（漢字）
					updateEntity2.setDocKana(indto.getDocKanaSei()  + " " + indto.getDocKanaMei());//氏名（カナ）
					updateEntity2.setDocKanjiSei(indto.getDocKanjiSei());//氏名（漢字）姓
					updateEntity2.setDocKanjiMei(indto.getDocKanjiMei());//氏名（漢字）名
					updateEntity2.setDocKanaSei(indto.getDocKanaSei());//氏名（カナ）姓
					updateEntity2.setDocKanaMei(indto.getDocKanaMei());//氏名（カナ）名
					updateEntity2.setOldKanjSei(StringUtils.setEmptyToNull(indto.getOldKanjSei()));//氏名（漢字）旧姓
					updateEntity2.setOldKanaSei(StringUtils.setEmptyToNull(indto.getOldKanaSei()));//氏名（カナ）旧姓
					updateEntity2.setNewNameStYear(StringUtils.setEmptyToNull(indto.getNewNameStYear()));//改姓日（年）
					updateEntity2.setNewNameStMonth(StringUtils.setEmptyToNull(indto.getNewNameStMonth()));//改姓日（月）
					updateEntity2.setNewNameStDay(StringUtils.setEmptyToNull(indto.getNewNameStDay()));//改姓日（日）
					updateEntity2.setDobYear(StringUtils.setEmptyToNull(indto.getDobYear()));//生年月日（年）
					updateEntity2.setDobMonth(StringUtils.setEmptyToNull(indto.getDobMonth()));//生年月日（月）
					updateEntity2.setDobDay(StringUtils.setEmptyToNull(indto.getDobDay()));//生年月日（日）
					updateEntity2.setSexCd(StringUtils.setEmptyToNull(indto.getSexCd()));//性別区分
					updateEntity2.setHomeTownCd(StringUtils.setEmptyToNull(indto.getHomeTownCd()));//出身地コード
					updateEntity2.setMedSchoolCd(StringUtils.setEmptyToNull(indto.getMedSchoolCd()));//出身校コード
					updateEntity2.setGradYear(StringUtils.setEmptyToNull(indto.getGradYear()));//卒年
					updateEntity2.setHomeDeptCd(StringUtils.setEmptyToNull(indto.getHomeDeptCd()));//出身所属コード
					updateEntity2.setHomeUnivCd(StringUtils.setEmptyToNull(indto.getHomeUnivCd()));//出身医局校コード
					updateEntity2.setEmplYear(StringUtils.setEmptyToNull(indto.getEmplYear()));//臨床研修年
					updateEntity2.setSpLiverCd(StringUtils.setEmptyToNull(indto.getSpLiverCd()));//専門臓器コード
					updateEntity2.setSpDiseaseCd(StringUtils.setEmptyToNull(indto.getSpDiseaseCd()));//専門詳細コード
					updateEntity2.setSpCom(StringUtils.setEmptyToNull(indto.getSpCom()));//専門追加情報
					updateEntity2.setSkInsNo(indto.getSkInsNo());//勤務先施設固定コード
					updateEntity2.setSkJobForm(StringUtils.setEmptyToNull(indto.getSkJobForm()));//勤務形態
					updateEntity2.setSkDeptCd(indto.getSkDeptCd());//所属部科コード
					updateEntity2.setSkUnivPosCd(StringUtils.setEmptyToNull(indto.getSkUnivPosCd()));//大学職位コード
					updateEntity2.setSkTitleCd(indto.getSkTitleCd());//役職コード
					updateEntity2.setSkDcctype(StringUtils.setEmptyToNull(indto.getSkDcctype()));//薬審メンバー区分
					updateEntity2.setUltDocNo(indto.getUltDocNo());//ULT医師コード
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
					ketEntity1.setReqId(indto.getReqId());//申請ID
					for (HcpSocietyData sData : societyDataList) {
						//キーで検索
						if(sData.getMedicalSocietyNm() != null) {//iteratorの影響か1行nullのデータが入っているのではじく
							ketEntity1.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
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
								insEntity3.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
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
									updateEntity3.setUpdShaYmd(currentDt);//更新日
									updateEntity3.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
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
					ketEntity2.setReqId(indto.getReqId());//申請ID
					for (HcpPublicData pData : publicDataList) {
						if(pData.getPubInstitutionCd() != null) {
							//キーで検索
							ketEntity2.setPubInstitutionCd(StringUtils.setEmptyToNull(pData.getPubInstitutionCd()));//公的機関
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
								insEntity4.setClassCategoryCd(StringUtils.setEmptyToNull(pData.getClassCategoryCd()));//分類区分
								insEntity4.setPubInstitutionCd(pData.getPubInstitutionCd());//公的機関
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
									updateEntity4.setClassCategoryCd(StringUtils.setEmptyToNull(pData.getClassCategoryCd()));//分類区分
									updateEntity4.setPubInstitutionCd(pData.getPubInstitutionCd());//公的機関
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
									updateEntity4.setUpdShaYmd(currentDt);//更新日
									updateEntity4.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
									updateEntity4.checkSetNull();
									dao.update(updateEntity4);
								}
							}
						}
					}
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
				insEntity1.setReqType("31");//申請区分
				insEntity1.setReqStsCd("03");//申請ステータス(新規申請)
				insEntity1.setReqBrCd(loginInfo.getBrCode());//申請者所属リージョン
				insEntity1.setReqDistCd(loginInfo.getDistCode());//申請者所属エリア
				insEntity1.setReqShzNm(loginInfo.getBumonRyakuName());//申請者所属
				insEntity1.setReqJgiNo(loginInfo.getJgiNo());//申請者従業員番号
				insEntity1.setReqJgiName(loginInfo.getJgiName());//申請者氏名
				insEntity1.setReqComment(indto.getReqComment());//申請コメント

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
				insEntity2.setDocType(indto.getDocType());//医師／薬剤師区分
				insEntity2.setDocKanj(indto.getDocKanjiSei() + "　" + indto.getDocKanjiMei() );//氏名（漢字）
				insEntity2.setDocKana(indto.getDocKanaSei()  + " " + indto.getDocKanaMei());//氏名（カナ）
				insEntity2.setDocKanjiSei(indto.getDocKanjiSei());//氏名（漢字）姓
				insEntity2.setDocKanjiMei(indto.getDocKanjiMei());//氏名（漢字）名
				insEntity2.setDocKanaSei(indto.getDocKanaSei());//氏名（カナ）姓
				insEntity2.setDocKanaMei(indto.getDocKanaMei());//氏名（カナ）名
				insEntity2.setOldKanjSei(StringUtils.setEmptyToNull(indto.getOldKanjSei()));//氏名（漢字）旧姓
				insEntity2.setOldKanaSei(StringUtils.setEmptyToNull(indto.getOldKanaSei()));//氏名（カナ）旧姓
				insEntity2.setNewNameStYear(StringUtils.setEmptyToNull(indto.getNewNameStYear()));//改姓日（年）
				insEntity2.setNewNameStMonth(StringUtils.setEmptyToNull(indto.getNewNameStMonth()));//改姓日（月）
				insEntity2.setNewNameStDay(StringUtils.setEmptyToNull(indto.getNewNameStDay()));//改姓日（日）
				insEntity2.setDobYear(StringUtils.setEmptyToNull(indto.getDobYear()));//生年月日（年）
				insEntity2.setDobMonth(StringUtils.setEmptyToNull(indto.getDobMonth()));//生年月日（月）
				insEntity2.setDobDay(StringUtils.setEmptyToNull(indto.getDobDay()));//生年月日（日）
				insEntity2.setSexCd(StringUtils.setEmptyToNull(indto.getSexCd()));//性別区分
				insEntity2.setHomeTownCd(StringUtils.setEmptyToNull(indto.getHomeTownCd()));//出身地コード
				insEntity2.setMedSchoolCd(StringUtils.setEmptyToNull(indto.getMedSchoolCd()));//出身校コード
				insEntity2.setGradYear(StringUtils.setEmptyToNull(indto.getGradYear()));//卒年
				insEntity2.setHomeDeptCd(StringUtils.setEmptyToNull(indto.getHomeDeptCd()));//出身所属コード
				insEntity2.setHomeUnivCd(StringUtils.setEmptyToNull(indto.getHomeUnivCd()));//出身医局校コード
				insEntity2.setEmplYear(StringUtils.setEmptyToNull(indto.getEmplYear()));//臨床研修年
				insEntity2.setSpLiverCd(StringUtils.setEmptyToNull(indto.getSpLiverCd()));//専門臓器コード
				insEntity2.setSpDiseaseCd(StringUtils.setEmptyToNull(indto.getSpDiseaseCd()));//専門詳細コード
				insEntity2.setSpCom(StringUtils.setEmptyToNull(indto.getSpCom()));//専門追加情報
				insEntity2.setSkInsNo(indto.getSkInsNo());//勤務先施設固定コード
				insEntity2.setSkJobForm(StringUtils.setEmptyToNull(indto.getSkJobForm()));//勤務形態
				insEntity2.setSkDeptCd(indto.getSkDeptCd());//所属部科コード
				insEntity2.setSkUnivPosCd(StringUtils.setEmptyToNull(indto.getSkUnivPosCd()));//大学職位コード
				insEntity2.setSkTitleCd(indto.getSkTitleCd());//役職コード
				insEntity2.setSkDcctype(StringUtils.setEmptyToNull(indto.getSkDcctype()));//薬審メンバー区分
				insEntity2.setUltDocNo(indto.getUltDocNo());//ULT医師コード
				insEntity2.setInsShaYmd(currentDt);//作成日
				insEntity2.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity2.setUpdShaYmd(currentDt);//更新日
				insEntity2.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				dao.insertByValue(insEntity2);

				//所属学会
				List<HcpSocietyData> societyDataList = indto.getHcpSocietyDataList();
				TRdmHcpSocietyReqEntity insEntity3 = new TRdmHcpSocietyReqEntity();
				insEntity3.setReqId(reqId);//申請ID
				insEntity3.setInsShaYmd(currentDt);//作成日
				insEntity3.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity3.setUpdShaYmd(currentDt);//更新日
				insEntity3.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				for (HcpSocietyData sData : societyDataList) {
					insEntity3.setMedicalSocietyNm(StringUtils.setEmptyToNull(sData.getMedicalSocietyNm()));//所属学会名称
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
				}
				//公的機関
				List<HcpPublicData> publicDataList = indto.getHcpPublicDataList();
				TRdmHcpPublicReqEntity insEntity4 = new TRdmHcpPublicReqEntity();
				insEntity4.setReqId(reqId);//申請ID
				insEntity4.setInsShaYmd(currentDt);//作成日
				insEntity4.setInsShaId(Integer.toString(loginInfo.getJgiNo()));//作成者
				insEntity4.setUpdShaYmd(currentDt);//更新日
				insEntity4.setUpdShaId(Integer.toString(loginInfo.getJgiNo()));//更新者
				for (HcpPublicData pData : publicDataList) {
					insEntity4.setClassCategoryCd(StringUtils.setEmptyToNull(pData.getClassCategoryCd()));//分類区分
					insEntity4.setPubInstitutionCd(pData.getPubInstitutionCd());//公的機関
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
				}
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
		//		重複申請チェック                                同じULTコードに紐づく医師新規作成申請がすでに存在している場合
		SelectND301MainDataEntity paramChkEntity = new SelectND301MainDataEntity();
		paramChkEntity.setSqlId("selectND301CheckUltData");
		paramChkEntity.setInUltDocNo(indto.getUltDocNo());
		paramChkEntity.setInReqId(StringUtils.setEmptyToNull(indto.getReqId()));
		List<SelectND301MainDataEntity> chkEntityList1 = dao.select(paramChkEntity);
		if(chkEntityList1.size() > 0) {
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
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W062);//勤務先に廃院が選択されています。
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

	/**
	 * コンボ作成
	 * @param indto ND301DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(ND301DTO indto){
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
			mapHomeTown.put(outEntity.getValue(), outEntity.getValue() + ":" + outEntity.getValueKanji());
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

		//1-2-12    大学職位
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

		//1-2-13    役職
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

		//1-2-14    勤務形態
		//    コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//            コード名＝JOB_FORM（勤務形態）
		//            削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_JOB_FORM);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapJobForm = new LinkedHashMap<String, String>();
		mapJobForm.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapJobForm.put(outEntity.getValue(), outEntity.getValueKanji());
		}
		indto.setSkJobFormCombo(mapJobForm);

		//1-2-15    薬審メンバー区分
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
}
