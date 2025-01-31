/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
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
import jp.co.takeda.rdm.dto.ND011DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpShusshinkoEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpDiseaseEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpSpLiverEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpYakushokuEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpPublicDataEntity;
import jp.co.takeda.rdm.entity.join.SelectHcpSocietyDataEntity;
import jp.co.takeda.rdm.entity.join.SelectND011MainDataEntity;

import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（ND011)
 * @generated
 */
@Named
public class ND011Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(ND011Service.class);

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
     * @param indto ND011DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(ND011DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		List<HcpSocietyData> hcpSocietyDataList = new ArrayList<HcpSocietyData>();
		List<HcpSocietyData> beforeHcpSocietyDataList = new ArrayList<HcpSocietyData>();
		List<HcpPublicData> hcpPublicDataList = new ArrayList<HcpPublicData>();
		List<HcpPublicData> beforeHcpPublicDataList = new ArrayList<HcpPublicData>();

        if ("1".equals(indto.getDisplayKbn())) {
        	if (indto.getUltDocCd() != null) {
        		// ULT医師コードで初期データ作成
        		// 申請データ（一時保存含む）を参照
        		SelectND011MainDataEntity paramEntity = new SelectND011MainDataEntity();
        		paramEntity.setSqlId("selectND011ULTData");
        		paramEntity.setInUltDocNo(indto.getUltDocCd());
        		List<SelectND011MainDataEntity> mainDataEntityList = dao.select(paramEntity);
        		SelectND011MainDataEntity mainDataEntity = mainDataEntityList.get(0);
        		indto.setUltDocCd(StringUtils.nvl(mainDataEntity.getUltDocCd(), ""));
        		indto.setUltDocNm(StringUtils.nvl(mainDataEntity.getUltDocNm(), ""));
        		indto.setUltDocKana(StringUtils.nvl(mainDataEntity.getUltDocKana(), ""));
        		indto.setSexCd(StringUtils.nvl(mainDataEntity.getSexCd(), ""));
        		indto.setDocKanjiSei(StringUtils.nvl(mainDataEntity.getDocKanjiSei(), ""));
        		indto.setDocKanjiMei(StringUtils.nvl(mainDataEntity.getDocKanjiMei(), ""));
        		indto.setDocKanaSei(StringUtils.nvl(mainDataEntity.getDocKanaSei(), ""));
        		indto.setDocKanaMei(StringUtils.nvl(mainDataEntity.getDocKanaMei(), ""));
        		indto.setDobYear(StringUtils.nvl(mainDataEntity.getDobYear(), ""));
        		indto.setDobMonth(StringUtils.nvl(mainDataEntity.getDobMonth(), ""));
        		indto.setDobDay(StringUtils.nvl(mainDataEntity.getDobDay(), ""));
        		indto.setHomeTownCd(StringUtils.nvl(mainDataEntity.getHomeTownCd(), ""));
        		indto.setMedSchoolCd(StringUtils.nvl(mainDataEntity.getMedSchoolCd(), ""));
        		indto.setGradYear(StringUtils.nvl(mainDataEntity.getGradYear(), ""));
        		indto.setHomeUnivCd(StringUtils.nvl(mainDataEntity.getHomeUnivCd(), ""));
        		indto.setSkInsNm(StringUtils.nvl(mainDataEntity.getSkInsNm(), ""));
        		indto.setSkUnivPosCd(StringUtils.nvl(mainDataEntity.getSkUnivPosCd(), ""));
        		indto.setSkDeptNm(StringUtils.nvl(mainDataEntity.getSkDeptNm(), ""));
        		indto.setSkTitleCd(StringUtils.nvl(mainDataEntity.getSkTitleCd(), ""));
        		indto.setSkInsNo(StringUtils.nvl(mainDataEntity.getSkInsNo(), ""));
        		indto.setSkDeptCd(StringUtils.nvl(mainDataEntity.getSkDeptCd(), ""));

//        		indto.setReqShzNm(loginInfo.getShzNm());
        		indto.setReqJgiName(loginInfo.getJgiName());
        		indto.setReqJgiNo(loginInfo.getJgiNo());
//        		indto.setReqBrCd(loginInfo.getBrCd());
//        		indto.setReqDistCd(loginInfo.getDistCd());
        	} else {
        		// 完全新規 ログイン情報から申請者セット
//        		indto.setReqShzNm(loginInfo.getShzNm());
        		indto.setReqJgiName(loginInfo.getJgiName());
        		indto.setReqJgiNo(loginInfo.getJgiNo());
//        		indto.setReqBrCd(loginInfo.getBrCd());
//        		indto.setReqDistCd(loginInfo.getDistCd());
        	}
        } else if ("2".equals(indto.getDisplayKbn())) {
        	if (indto.getReqId() != null) {
        		// 申請データ（一時保存含む）を参照
        		SelectND011MainDataEntity paramEntity = new SelectND011MainDataEntity();
        		paramEntity.setInReqId(indto.getReqId());
        		List<SelectND011MainDataEntity> mainDataEntityList = dao.select(paramEntity);
        		SelectND011MainDataEntity mainDataEntity = mainDataEntityList.get(0);
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
        		indto.setUltDocCd(StringUtils.nvl(mainDataEntity.getUltDocCd(), ""));
        		indto.setUltDocNm(StringUtils.nvl(mainDataEntity.getUltDocNm(), ""));
        		indto.setUltDocKana(StringUtils.nvl(mainDataEntity.getUltDocKana(), ""));
        		indto.setDocType(StringUtils.nvl(mainDataEntity.getDocType(), ""));
        		indto.setSexCd(StringUtils.nvl(mainDataEntity.getSexCd(), ""));
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
        		indto.setMedSchoolCd(StringUtils.nvl(mainDataEntity.getMedSchoolCd(), ""));
        		indto.setGradYear(StringUtils.nvl(mainDataEntity.getGradYear(), ""));
        		indto.setEmplYear(StringUtils.nvl(mainDataEntity.getEmplYear(), ""));
        		indto.setHomeUnivCd(StringUtils.nvl(mainDataEntity.getHomeUnivCd(), ""));
        		indto.setHomeDeptNm(StringUtils.nvl(mainDataEntity.getHomeDeptNm(), ""));
        		indto.setSpLiverCd(StringUtils.nvl(mainDataEntity.getSpLiverCd(), ""));
        		indto.setSpDiseaseCd(StringUtils.nvl(mainDataEntity.getSpDiseaseCd(), ""));
        		indto.setSpComCd(StringUtils.nvl(mainDataEntity.getSpComCd(), ""));
        		indto.setHomeDeptCd(StringUtils.nvl(mainDataEntity.getHomeDeptCd(), ""));
        		indto.setSkInsNm(StringUtils.nvl(mainDataEntity.getSkInsNm(), ""));
        		indto.setSkUnivPosCd(StringUtils.nvl(mainDataEntity.getSkUnivPosCd(), ""));
        		indto.setSkDeptNm(StringUtils.nvl(mainDataEntity.getSkDeptNm(), ""));
        		indto.setSkTitleCd(StringUtils.nvl(mainDataEntity.getSkTitleCd(), ""));
        		indto.setSkJobFrom(StringUtils.nvl(mainDataEntity.getSkJobFrom(), ""));
        		indto.setSkDcctype(StringUtils.nvl(mainDataEntity.getSkDcctype(), ""));
        		indto.setSkInsNo(StringUtils.nvl(mainDataEntity.getSkInsNo(), ""));
        		indto.setSkDeptCd(StringUtils.nvl(mainDataEntity.getSkDeptCd(), ""));
        		indto.setReqComment(StringUtils.nvl(mainDataEntity.getReqComment(), ""));
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
        		indto.setBeforeHcpSocietyDataList(beforeHcpSocietyDataList);
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
        		indto.setBeforeHcpPublicDataList(beforeHcpPublicDataList);
        	} else {
        		// 完全新規
//        		indto.setReqShzNm(loginInfo.getShzNm());
        		indto.setReqJgiName(loginInfo.getJgiName());
        		indto.setReqJgiNo(loginInfo.getJgiNo());
//        		indto.setReqBrCd(loginInfo.getBrCd());
//        		indto.setReqDistCd(loginInfo.getDistCd());
        	}
        } else if ("0".equals(indto.getDisplayKbn())) {
    		// 完全新規
//    		indto.setReqShzNm(loginInfo.getShzNm());
    		indto.setReqJgiName(loginInfo.getJgiName());
    		indto.setReqJgiNo(loginInfo.getJgiNo());
//    		indto.setReqBrCd(loginInfo.getBrCd());
//    		indto.setReqDistCd(loginInfo.getDistCd());
        }
		indto.setHcpSocietyDataChgFlg("0");
		indto.setHcpPublicDataChgFlg("0");
        // DropDownList作成
        createCombo(indto);

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
    	pData.setPubInstEdYYYY(StringUtils.nvl(pEntity.getPubInstEdYYYY(), ""));
    	pData.setPubInstEdMM(StringUtils.nvl(pEntity.getPubInstEdMM(), ""));
    	pData.setPubInstEdDD(StringUtils.nvl(pEntity.getPubInstEdDD(), ""));
    	pData.setPubInstPositionCd(StringUtils.nvl(pEntity.getPubInstPositionCd(), ""));
    	pData.setPubInstPositionNm(StringUtils.nvl(pEntity.getPubInstPositionNm(), ""));
    	pData.setPubInstposStYYYY(StringUtils.nvl(pEntity.getPubInstposStYYYY(), ""));
    	pData.setPubInstposStMM(StringUtils.nvl(pEntity.getPubInstposStMM(), ""));
    	pData.setPubInstposStDD(StringUtils.nvl(pEntity.getPubInstposStDD(), ""));
    	pData.setPubInstposEdYYYY(StringUtils.nvl(pEntity.getPubInstposEdYYYY(), ""));
    	pData.setPubInstposEdMM(StringUtils.nvl(pEntity.getPubInstposEdMM(), ""));
    	pData.setPubInstposEdDD(StringUtils.nvl(pEntity.getPubInstposEdDD(), ""));
	}

	private void setHcpSocietyData(SelectHcpSocietyDataEntity sEntity, HcpSocietyData sData) {
    	sData.setMedicalSocietyNm(StringUtils.nvl(sEntity.getMedicalSocietyNm(), ""));
    	sData.setAdmissionYYYY(StringUtils.nvl(sEntity.getAdmissionYYYY(), ""));
    	sData.setAdmissionMM(StringUtils.nvl(sEntity.getAdmissionMM(), ""));
    	sData.setAdmissionDD(StringUtils.nvl(sEntity.getAdmissionDD(), ""));
    	sData.setQuitYYYY(StringUtils.nvl(sEntity.getQuitYYYY(), ""));
    	sData.setQuitMM(StringUtils.nvl(sEntity.getQuitMM(), ""));
    	sData.setQuitDD(StringUtils.nvl(sEntity.getQuitDD(), ""));
    	sData.setPositionCode(StringUtils.nvl(sEntity.getPositionCode(), ""));
    	sData.setPositionName(StringUtils.nvl(sEntity.getPositionName(), ""));
    	sData.setSocietyPosiStYYYY(StringUtils.nvl(sEntity.getSocietyPosiStYYYY(), ""));
    	sData.setSocietyPosiStMM(StringUtils.nvl(sEntity.getSocietyPosiStMM(), ""));
    	sData.setSocietyPosiStDD(StringUtils.nvl(sEntity.getSocietyPosiStDD(), ""));
    	sData.setSocietyPosiEdYYYY(StringUtils.nvl(sEntity.getSocietyPosiEdYYYY(), ""));
    	sData.setSocietyPosiEdMM(StringUtils.nvl(sEntity.getSocietyPosiEdMM(), ""));
    	sData.setSocietyPosiEdDD(StringUtils.nvl(sEntity.getSocietyPosiEdDD(), ""));
    	sData.setAdvisingDoctorCd(StringUtils.nvl(sEntity.getAdvisingDoctorCd(), ""));
    	sData.setAdvisingDoctorNm(StringUtils.nvl(sEntity.getAdvisingDoctorNm(), ""));
    	sData.setCoachingAcquisiYYYY(StringUtils.nvl(sEntity.getCoachingAcquisiYYYY(), ""));
    	sData.setCoachingAcquisiMM(StringUtils.nvl(sEntity.getCoachingAcquisiMM(), ""));
    	sData.setCoachingAcquisiDD(StringUtils.nvl(sEntity.getCoachingAcquisiDD(), ""));
    	sData.setCoachingStYYYY(StringUtils.nvl(sEntity.getCoachingStYYYY(), ""));
    	sData.setCoachingStMM(StringUtils.nvl(sEntity.getCoachingStMM(), ""));
    	sData.setCoachingStDD(StringUtils.nvl(sEntity.getCoachingStDD(), ""));
    	sData.setCoachingEdYYYY(StringUtils.nvl(sEntity.getCoachingEdYYYY(), ""));
    	sData.setCoachingEdMM(StringUtils.nvl(sEntity.getCoachingEdMM(), ""));
    	sData.setCoachingEdDD(StringUtils.nvl(sEntity.getCoachingEdDD(), ""));
    	sData.setCertifyingPhysicianCd(StringUtils.nvl(sEntity.getCertifyingPhysicianCd(), ""));
    	sData.setCertifyingPhysicianNm(StringUtils.nvl(sEntity.getCertifyingPhysicianNm(), ""));
    	sData.setCertifyStYYYY(StringUtils.nvl(sEntity.getCertifyStYYYY(), ""));
    	sData.setCertifyStMM(StringUtils.nvl(sEntity.getCertifyStMM(), ""));
    	sData.setCertifyStDD(StringUtils.nvl(sEntity.getCertifyStDD(), ""));
    	sData.setCertifyEdYYYY(StringUtils.nvl(sEntity.getCertifyEdYYYY(), ""));
    	sData.setCertifyEdMM(StringUtils.nvl(sEntity.getCertifyEdMM(), ""));
    	sData.setCertifyEdDD(StringUtils.nvl(sEntity.getCertifyEdDD(), ""));
	}

    /**
     * コンボ作成
     * @param indto ND011DTO
     * @return なし
     * @customizable
     */
    private void createCombo(ND011DTO indto){
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
        	mapDocType.put(outEntity.getValue(), outEntity.getValueKanji());
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
        	mapMF.put(outEntity.getValue(), outEntity.getValueKanji());
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
        mapYear.put("", "");
        for (int i = 0; i < 101; i++) {
        	String yearStr = Integer.toString(yearInt + 1 - i);
        	mapYear.put(yearStr, yearStr);
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
        indto.setGradYearCombo(mapYear);

        //1-2-8     臨床研修年（西暦）
    	//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
    	//            年      現在日付の年+1年～－100年
        indto.setEmplYearCombo(mapYear);

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
        indto.setSkJobFromCombo(mapJobForm);

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
	/**
     * イベント処理
     * @param indto ND011DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO register(ND011DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        // END UOC
        return outdto;
    }

}
