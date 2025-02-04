/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス 所属学会
 * @generated
 */
public class HcpSocietyData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属学会名称
     * @generated
     */
    private String medicalSocietyNm;

    /**
     * 入会年月日(年)
     * @generated
     */
    private String admissionYYYY;

    /**
     * 入会年月日(月)
     * @generated
     */
    private String admissionMM;

    /**
     * 入会年月日(日)
     * @generated
     */
    private String admissionDD;

    /**
     * 入会年月日(ラベル用)
     * @generated
     */
    private String admissionYMD;

    /**
     * 脱会年月日(年)
     * @generated
     */
    private String quitYYYY;

    /**
     * 脱会年月日(月)
     * @generated
     */
    private String quitMM;

    /**
     * 脱会年月日(日)
     * @generated
     */
    private String quitDD;

    /**
     * 脱会年月日(ラベル用)
     * @generated
     */
    private String quitYMD;

    /**
     * 所属役職コード
     * @generated
     */
    private String positionCode;

    /**
     * 所属役職名称
     * @generated
     */
    private String positionName;

    /**
     * 役職開始年月日(年)
     * @generated
     */
    private String societyPosiStYYYY;

    /**
     * 役職開始年月日(月)
     * @generated
     */
    private String societyPosiStMM;

    /**
     * 役職開始年月日(日)
     * @generated
     */
    private String societyPosiStDD;

    /**
     * 役職開始年月日(ラベル用)
     * @generated
     */
    private String societyPosiStYMD;

    /**
     * 役職終了年月日(年)
     * @generated
     */
    private String societyPosiEdYYYY;

    /**
     * 役職終了年月日(月)
     * @generated
     */
    private String societyPosiEdMM;

    /**
     * 役職終了年月日(日)
     * @generated
     */
    private String societyPosiEdDD;

    /**
     * 役職終了年月日(ラベル用)
     * @generated
     */
    private String societyPosiEdYMD;

    /**
     * 所属学会指導医区分コード
     * @generated
     */
    private String advisingDoctorCd;

    /**
     * 所属学会指導医区分名称
     * @generated
     */
    private String advisingDoctorNm;

    /**
     * 指導医取得年月日(年)
     * @generated
     */
    private String coachingAcquisiYYYY;

    /**
     * 指導医取得年月日(月)
     * @generated
     */
    private String coachingAcquisiMM;

    /**
     * 指導医取得年月日(日)
     * @generated
     */
    private String coachingAcquisiDD;

    /**
     * 指導医取得年月日(ラベル用)
     * @generated
     */
    private String coachingAcquisiYMD;

    /**
     * 指導医開始年月日(年)
     * @generated
     */
    private String coachingStYYYY;

    /**
     * 指導医開始年月日(月)
     * @generated
     */
    private String coachingStMM;

    /**
     * 指導医開始年月日(日)
     * @generated
     */
    private String coachingStDD;

    /**
     * 指導医開始年月日(ラベル用)
     * @generated
     */
    private String coachingStYMD;

    /**
     * 指導医終了年月日(年)
     * @generated
     */
    private String coachingEdYYYY;

    /**
     * 指導医終了年月日(月)
     * @generated
     */
    private String coachingEdMM;

    /**
     * 指導医終了年月日(日)
     * @generated
     */
    private String coachingEdDD;

    /**
     * 指導医終了年月日(ラベル用)
     * @generated
     */
    private String coachingEdYMD;

    /**
     * 所属学会認定医区分コード
     * @generated
     */
    private String certifyingPhysicianCd;

    /**
     * 所属学会認定医区分名称
     * @generated
     */
    private String certifyingPhysicianNm;

    /**
     * 認定医開始年月日(年)
     * @generated
     */
    private String certifyStYYYY;

    /**
     * 認定医開始年月日(月)
     * @generated
     */
    private String certifyStMM;

    /**
     * 認定医開始年月日(日)
     * @generated
     */
    private String certifyStDD;

    /**
     * 認定医開始年月日(ラベル用)
     * @generated
     */
    private String certifyStYMD;

    /**
     * 認定医終了年月日(年)
     * @generated
     */
    private String certifyEdYYYY;

    /**
     * 認定医終了年月日(月)
     * @generated
     */
    private String certifyEdMM;

    /**
     * 認定医終了年月日(日)
     * @generated
     */
    private String certifyEdDD;

    /**
     * 認定医終了年月日(ラベル用)
     * @generated
     */
    private String certifyEdYMD;


    /**
     * コンストラクタ
     * @customizable
     */
    public HcpSocietyData() {
        // START UOC

        // END UOC
    }





	/**
	 * HcpSocietyData.javamedicalSocietyNmを設定
	 * @return medicalSocietyNm
	 */
	public String getMedicalSocietyNm() {
		return medicalSocietyNm;
	}





	/**
	 * @param medicalSocietyNm セットする medicalSocietyNm
	 */
	public void setMedicalSocietyNm(String medicalSocietyNm) {
		this.medicalSocietyNm = medicalSocietyNm;
	}





	/**
	 * HcpSocietyData.javaadmissionYYYYを設定
	 * @return admissionYYYY
	 */
	public String getAdmissionYYYY() {
		return admissionYYYY;
	}





	/**
	 * @param admissionYYYY セットする admissionYYYY
	 */
	public void setAdmissionYYYY(String admissionYYYY) {
		this.admissionYYYY = admissionYYYY;
	}





	/**
	 * HcpSocietyData.javaadmissionMMを設定
	 * @return admissionMM
	 */
	public String getAdmissionMM() {
		return admissionMM;
	}





	/**
	 * @param admissionMM セットする admissionMM
	 */
	public void setAdmissionMM(String admissionMM) {
		this.admissionMM = admissionMM;
	}





	/**
	 * HcpSocietyData.javaadmissionDDを設定
	 * @return admissionDD
	 */
	public String getAdmissionDD() {
		return admissionDD;
	}





	/**
	 * @param admissionDD セットする admissionDD
	 */
	public void setAdmissionDD(String admissionDD) {
		this.admissionDD = admissionDD;
	}





	/**
	 * HcpSocietyData.javaquitYYYYを設定
	 * @return quitYYYY
	 */
	public String getQuitYYYY() {
		return quitYYYY;
	}





	/**
	 * @param quitYYYY セットする quitYYYY
	 */
	public void setQuitYYYY(String quitYYYY) {
		this.quitYYYY = quitYYYY;
	}





	/**
	 * HcpSocietyData.javaquitMMを設定
	 * @return quitMM
	 */
	public String getQuitMM() {
		return quitMM;
	}





	/**
	 * @param quitMM セットする quitMM
	 */
	public void setQuitMM(String quitMM) {
		this.quitMM = quitMM;
	}





	/**
	 * HcpSocietyData.javaquitDDを設定
	 * @return quitDD
	 */
	public String getQuitDD() {
		return quitDD;
	}





	/**
	 * @param quitDD セットする quitDD
	 */
	public void setQuitDD(String quitDD) {
		this.quitDD = quitDD;
	}





	/**
	 * HcpSocietyData.javapositionCodeを設定
	 * @return positionCode
	 */
	public String getPositionCode() {
		return positionCode;
	}





	/**
	 * @param positionCode セットする positionCode
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}





	/**
	 * HcpSocietyData.javapositionNameを設定
	 * @return positionName
	 */
	public String getPositionName() {
		return positionName;
	}





	/**
	 * @param positionName セットする positionName
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}





	/**
	 * HcpSocietyData.javasocietyPosiStYYYYを設定
	 * @return societyPosiStYYYY
	 */
	public String getSocietyPosiStYYYY() {
		return societyPosiStYYYY;
	}





	/**
	 * @param societyPosiStYYYY セットする societyPosiStYYYY
	 */
	public void setSocietyPosiStYYYY(String societyPosiStYYYY) {
		this.societyPosiStYYYY = societyPosiStYYYY;
	}





	/**
	 * HcpSocietyData.javasocietyPosiStMMを設定
	 * @return societyPosiStMM
	 */
	public String getSocietyPosiStMM() {
		return societyPosiStMM;
	}





	/**
	 * @param societyPosiStMM セットする societyPosiStMM
	 */
	public void setSocietyPosiStMM(String societyPosiStMM) {
		this.societyPosiStMM = societyPosiStMM;
	}





	/**
	 * HcpSocietyData.javasocietyPosiStDDを設定
	 * @return societyPosiStDD
	 */
	public String getSocietyPosiStDD() {
		return societyPosiStDD;
	}





	/**
	 * @param societyPosiStDD セットする societyPosiStDD
	 */
	public void setSocietyPosiStDD(String societyPosiStDD) {
		this.societyPosiStDD = societyPosiStDD;
	}





	/**
	 * HcpSocietyData.javasocietyPosiEdYYYYを設定
	 * @return societyPosiEdYYYY
	 */
	public String getSocietyPosiEdYYYY() {
		return societyPosiEdYYYY;
	}





	/**
	 * @param societyPosiEdYYYY セットする societyPosiEdYYYY
	 */
	public void setSocietyPosiEdYYYY(String societyPosiEdYYYY) {
		this.societyPosiEdYYYY = societyPosiEdYYYY;
	}





	/**
	 * HcpSocietyData.javasocietyPosiEdMMを設定
	 * @return societyPosiEdMM
	 */
	public String getSocietyPosiEdMM() {
		return societyPosiEdMM;
	}





	/**
	 * @param societyPosiEdMM セットする societyPosiEdMM
	 */
	public void setSocietyPosiEdMM(String societyPosiEdMM) {
		this.societyPosiEdMM = societyPosiEdMM;
	}





	/**
	 * HcpSocietyData.javasocietyPosiEdDDを設定
	 * @return societyPosiEdDD
	 */
	public String getSocietyPosiEdDD() {
		return societyPosiEdDD;
	}





	/**
	 * @param societyPosiEdDD セットする societyPosiEdDD
	 */
	public void setSocietyPosiEdDD(String societyPosiEdDD) {
		this.societyPosiEdDD = societyPosiEdDD;
	}





	/**
	 * HcpSocietyData.javaadvisingDoctorCdを設定
	 * @return advisingDoctorCd
	 */
	public String getAdvisingDoctorCd() {
		return advisingDoctorCd;
	}





	/**
	 * @param advisingDoctorCd セットする advisingDoctorCd
	 */
	public void setAdvisingDoctorCd(String advisingDoctorCd) {
		this.advisingDoctorCd = advisingDoctorCd;
	}





	/**
	 * HcpSocietyData.javaadvisingDoctorNmを設定
	 * @return advisingDoctorNm
	 */
	public String getAdvisingDoctorNm() {
		return advisingDoctorNm;
	}





	/**
	 * @param advisingDoctorNm セットする advisingDoctorNm
	 */
	public void setAdvisingDoctorNm(String advisingDoctorNm) {
		this.advisingDoctorNm = advisingDoctorNm;
	}





	/**
	 * HcpSocietyData.javacoachingAcquisiYYYYを設定
	 * @return coachingAcquisiYYYY
	 */
	public String getCoachingAcquisiYYYY() {
		return coachingAcquisiYYYY;
	}





	/**
	 * @param coachingAcquisiYYYY セットする coachingAcquisiYYYY
	 */
	public void setCoachingAcquisiYYYY(String coachingAcquisiYYYY) {
		this.coachingAcquisiYYYY = coachingAcquisiYYYY;
	}





	/**
	 * HcpSocietyData.javacoachingAcquisiMMを設定
	 * @return coachingAcquisiMM
	 */
	public String getCoachingAcquisiMM() {
		return coachingAcquisiMM;
	}





	/**
	 * @param coachingAcquisiMM セットする coachingAcquisiMM
	 */
	public void setCoachingAcquisiMM(String coachingAcquisiMM) {
		this.coachingAcquisiMM = coachingAcquisiMM;
	}





	/**
	 * HcpSocietyData.javacoachingAcquisiDDを設定
	 * @return coachingAcquisiDD
	 */
	public String getCoachingAcquisiDD() {
		return coachingAcquisiDD;
	}





	/**
	 * @param coachingAcquisiDD セットする coachingAcquisiDD
	 */
	public void setCoachingAcquisiDD(String coachingAcquisiDD) {
		this.coachingAcquisiDD = coachingAcquisiDD;
	}





	/**
	 * HcpSocietyData.javacoachingStYYYYを設定
	 * @return coachingStYYYY
	 */
	public String getCoachingStYYYY() {
		return coachingStYYYY;
	}





	/**
	 * @param coachingStYYYY セットする coachingStYYYY
	 */
	public void setCoachingStYYYY(String coachingStYYYY) {
		this.coachingStYYYY = coachingStYYYY;
	}





	/**
	 * HcpSocietyData.javacoachingStMMを設定
	 * @return coachingStMM
	 */
	public String getCoachingStMM() {
		return coachingStMM;
	}





	/**
	 * @param coachingStMM セットする coachingStMM
	 */
	public void setCoachingStMM(String coachingStMM) {
		this.coachingStMM = coachingStMM;
	}





	/**
	 * HcpSocietyData.javacoachingStDDを設定
	 * @return coachingStDD
	 */
	public String getCoachingStDD() {
		return coachingStDD;
	}





	/**
	 * @param coachingStDD セットする coachingStDD
	 */
	public void setCoachingStDD(String coachingStDD) {
		this.coachingStDD = coachingStDD;
	}





	/**
	 * HcpSocietyData.javacoachingEdYYYYを設定
	 * @return coachingEdYYYY
	 */
	public String getCoachingEdYYYY() {
		return coachingEdYYYY;
	}





	/**
	 * @param coachingEdYYYY セットする coachingEdYYYY
	 */
	public void setCoachingEdYYYY(String coachingEdYYYY) {
		this.coachingEdYYYY = coachingEdYYYY;
	}





	/**
	 * HcpSocietyData.javacoachingEdMMを設定
	 * @return coachingEdMM
	 */
	public String getCoachingEdMM() {
		return coachingEdMM;
	}





	/**
	 * @param coachingEdMM セットする coachingEdMM
	 */
	public void setCoachingEdMM(String coachingEdMM) {
		this.coachingEdMM = coachingEdMM;
	}





	/**
	 * HcpSocietyData.javacoachingEdDDを設定
	 * @return coachingEdDD
	 */
	public String getCoachingEdDD() {
		return coachingEdDD;
	}





	/**
	 * @param coachingEdDD セットする coachingEdDD
	 */
	public void setCoachingEdDD(String coachingEdDD) {
		this.coachingEdDD = coachingEdDD;
	}





	/**
	 * HcpSocietyData.javacertifyingPhysicianCdを設定
	 * @return certifyingPhysicianCd
	 */
	public String getCertifyingPhysicianCd() {
		return certifyingPhysicianCd;
	}





	/**
	 * @param certifyingPhysicianCd セットする certifyingPhysicianCd
	 */
	public void setCertifyingPhysicianCd(String certifyingPhysicianCd) {
		this.certifyingPhysicianCd = certifyingPhysicianCd;
	}





	/**
	 * HcpSocietyData.javacertifyingPhysicianNmを設定
	 * @return certifyingPhysicianNm
	 */
	public String getCertifyingPhysicianNm() {
		return certifyingPhysicianNm;
	}





	/**
	 * @param certifyingPhysicianNm セットする certifyingPhysicianNm
	 */
	public void setCertifyingPhysicianNm(String certifyingPhysicianNm) {
		this.certifyingPhysicianNm = certifyingPhysicianNm;
	}





	/**
	 * HcpSocietyData.javacertifyStYYYYを設定
	 * @return certifyStYYYY
	 */
	public String getCertifyStYYYY() {
		return certifyStYYYY;
	}





	/**
	 * @param certifyStYYYY セットする certifyStYYYY
	 */
	public void setCertifyStYYYY(String certifyStYYYY) {
		this.certifyStYYYY = certifyStYYYY;
	}





	/**
	 * HcpSocietyData.javacertifyStMMを設定
	 * @return certifyStMM
	 */
	public String getCertifyStMM() {
		return certifyStMM;
	}





	/**
	 * @param certifyStMM セットする certifyStMM
	 */
	public void setCertifyStMM(String certifyStMM) {
		this.certifyStMM = certifyStMM;
	}





	/**
	 * HcpSocietyData.javacertifyStDDを設定
	 * @return certifyStDD
	 */
	public String getCertifyStDD() {
		return certifyStDD;
	}





	/**
	 * @param certifyStDD セットする certifyStDD
	 */
	public void setCertifyStDD(String certifyStDD) {
		this.certifyStDD = certifyStDD;
	}





	/**
	 * HcpSocietyData.javacertifyEdYYYYを設定
	 * @return certifyEdYYYY
	 */
	public String getCertifyEdYYYY() {
		return certifyEdYYYY;
	}





	/**
	 * @param certifyEdYYYY セットする certifyEdYYYY
	 */
	public void setCertifyEdYYYY(String certifyEdYYYY) {
		this.certifyEdYYYY = certifyEdYYYY;
	}





	/**
	 * HcpSocietyData.javacertifyEdMMを設定
	 * @return certifyEdMM
	 */
	public String getCertifyEdMM() {
		return certifyEdMM;
	}





	/**
	 * @param certifyEdMM セットする certifyEdMM
	 */
	public void setCertifyEdMM(String certifyEdMM) {
		this.certifyEdMM = certifyEdMM;
	}





	/**
	 * HcpSocietyData.javacertifyEdDDを設定
	 * @return certifyEdDD
	 */
	public String getCertifyEdDD() {
		return certifyEdDD;
	}





	/**
	 * @param certifyEdDD セットする certifyEdDD
	 */
	public void setCertifyEdDD(String certifyEdDD) {
		this.certifyEdDD = certifyEdDD;
	}


/**
	 * HcpSocietyData.javaadmissionYMDを設定
	 * @return admissionYMD
	 */
	public String getAdmissionYMD() {
		return admissionYMD;
	}





	/**
	 * @param admissionYMD セットする admissionYMD
	 */
	public void setAdmissionYMD(String admissionYMD) {
		this.admissionYMD = admissionYMD;
	}





	/**
	 * HcpSocietyData.javaquitYMDを設定
	 * @return quitYMD
	 */
	public String getQuitYMD() {
		return quitYMD;
	}





	/**
	 * @param quitYMD セットする quitYMD
	 */
	public void setQuitYMD(String quitYMD) {
		this.quitYMD = quitYMD;
	}





	/**
	 * HcpSocietyData.javasocietyPosiStYMDを設定
	 * @return societyPosiStYMD
	 */
	public String getSocietyPosiStYMD() {
		return societyPosiStYMD;
	}





	/**
	 * @param societyPosiStYMD セットする societyPosiStYMD
	 */
	public void setSocietyPosiStYMD(String societyPosiStYMD) {
		this.societyPosiStYMD = societyPosiStYMD;
	}





	/**
	 * HcpSocietyData.javasocietyPosiEdYMDを設定
	 * @return societyPosiEdYMD
	 */
	public String getSocietyPosiEdYMD() {
		return societyPosiEdYMD;
	}





	/**
	 * @param societyPosiEdYMD セットする societyPosiEdYMD
	 */
	public void setSocietyPosiEdYMD(String societyPosiEdYMD) {
		this.societyPosiEdYMD = societyPosiEdYMD;
	}





	/**
	 * HcpSocietyData.javacoachingAcquisiYMDを設定
	 * @return coachingAcquisiYMD
	 */
	public String getCoachingAcquisiYMD() {
		return coachingAcquisiYMD;
	}





	/**
	 * @param coachingAcquisiYMD セットする coachingAcquisiYMD
	 */
	public void setCoachingAcquisiYMD(String coachingAcquisiYMD) {
		this.coachingAcquisiYMD = coachingAcquisiYMD;
	}





	/**
	 * HcpSocietyData.javacoachingStYMDを設定
	 * @return coachingStYMD
	 */
	public String getCoachingStYMD() {
		return coachingStYMD;
	}





	/**
	 * @param coachingStYMD セットする coachingStYMD
	 */
	public void setCoachingStYMD(String coachingStYMD) {
		this.coachingStYMD = coachingStYMD;
	}





	/**
	 * HcpSocietyData.javacoachingEdYMDを設定
	 * @return coachingEdYMD
	 */
	public String getCoachingEdYMD() {
		return coachingEdYMD;
	}





	/**
	 * @param coachingEdYMD セットする coachingEdYMD
	 */
	public void setCoachingEdYMD(String coachingEdYMD) {
		this.coachingEdYMD = coachingEdYMD;
	}





	/**
	 * HcpSocietyData.javacertifyStYMDを設定
	 * @return certifyStYMD
	 */
	public String getCertifyStYMD() {
		return certifyStYMD;
	}





	/**
	 * @param certifyStYMD セットする certifyStYMD
	 */
	public void setCertifyStYMD(String certifyStYMD) {
		this.certifyStYMD = certifyStYMD;
	}





	/**
	 * HcpSocietyData.javacertifyEdYMDを設定
	 * @return certifyEdYMD
	 */
	public String getCertifyEdYMD() {
		return certifyEdYMD;
	}





	/**
	 * @param certifyEdYMD セットする certifyEdYMD
	 */
	public void setCertifyEdYMD(String certifyEdYMD) {
		this.certifyEdYMD = certifyEdYMD;
	}





	/*
 * * @return 比較用文字列
 */
	public String toChkString() {
		return medicalSocietyNm +
				admissionYYYY +
				admissionMM +
				admissionDD +
				quitYYYY +
				quitMM +
				quitDD +
				positionCode +
				societyPosiStYYYY +
				societyPosiStMM +
				societyPosiStDD +
				societyPosiEdYYYY +
				societyPosiEdMM +
				societyPosiEdDD +
				advisingDoctorCd +
				coachingAcquisiYYYY +
				coachingAcquisiMM +
				coachingAcquisiDD +
				coachingStYYYY +
				coachingStMM +
				coachingStDD +
				coachingEdYYYY +
				coachingEdMM +
				coachingEdDD +
				certifyingPhysicianCd +
				certifyStYYYY +
				certifyStMM +
				certifyStDD +
				certifyEdYYYY +
				certifyEdMM +
				certifyEdDD ;
	}

	/**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

