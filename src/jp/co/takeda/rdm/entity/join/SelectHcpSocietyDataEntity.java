/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_HCP_SOCIETY_REQ
 * SQLID : selectHcpSocietyData
 * @generated
 */
public class SelectHcpSocietyDataEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_申請ID(パラメータ1)
     * @generated
     */
    private String inReqId;

    /**
     * 入力_医師コード (パラメータ2)
     * @generated
     */
    private String inDocNo;

    /**
     * 入力_所属学会名 (パラメータ3)
     * @generated
     */
    private String inMedicalSocietyNm;

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
     * 更新有フラグ
     * @generated
     */
    private String updFlg;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectHcpSocietyDataEntity() {
        super("t_rdm_hcp_society_req" , "selectHcpSocietyData");
    }

	/**
	 * SelectHcpSocietyDataEntity.javainReqIdを設定
	 * @return inReqId
	 */
	public String getInReqId() {
		return inReqId;
	}

	/**
	 * @param inReqId セットする inReqId
	 */
	public void setInReqId(String inReqId) {
		this.inReqId = inReqId;
	}

	/**
	 * SelectHcpSocietyDataEntity.javainDocNoを設定
	 * @return inDocNo
	 */
	public String getInDocNo() {
		return inDocNo;
	}

	/**
	 * @param inDocNo セットする inDocNo
	 */
	public void setInDocNo(String inDocNo) {
		this.inDocNo = inDocNo;
	}

	/**
	 * SelectHcpSocietyDataEntity.javainMedicalSocietyNmを設定
	 * @return inMedicalSocietyNm
	 */
	public String getInMedicalSocietyNm() {
		return inMedicalSocietyNm;
	}

	/**
	 * @param inMedicalSocietyNm セットする inMedicalSocietyNm
	 */
	public void setInMedicalSocietyNm(String inMedicalSocietyNm) {
		this.inMedicalSocietyNm = inMedicalSocietyNm;
	}

	/**
	 * SelectHcpSocietyDataEntity.javamedicalSocietyNmを設定
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
	 * SelectHcpSocietyDataEntity.javaadmissionYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javaadmissionMMを設定
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
	 * SelectHcpSocietyDataEntity.javaadmissionDDを設定
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
	 * SelectHcpSocietyDataEntity.javaquitYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javaquitMMを設定
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
	 * SelectHcpSocietyDataEntity.javaquitDDを設定
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
	 * SelectHcpSocietyDataEntity.javapositionCodeを設定
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
	 * SelectHcpSocietyDataEntity.javapositionNameを設定
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
	 * SelectHcpSocietyDataEntity.javasocietyPosiStYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javasocietyPosiStMMを設定
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
	 * SelectHcpSocietyDataEntity.javasocietyPosiStDDを設定
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
	 * SelectHcpSocietyDataEntity.javasocietyPosiEdYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javasocietyPosiEdMMを設定
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
	 * SelectHcpSocietyDataEntity.javasocietyPosiEdDDを設定
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
	 * SelectHcpSocietyDataEntity.javaadvisingDoctorCdを設定
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
	 * SelectHcpSocietyDataEntity.javaadvisingDoctorNmを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingAcquisiYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingAcquisiMMを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingAcquisiDDを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingStYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingStMMを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingStDDを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingEdYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingEdMMを設定
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
	 * SelectHcpSocietyDataEntity.javacoachingEdDDを設定
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
	 * SelectHcpSocietyDataEntity.javacertifyingPhysicianCdを設定
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
	 * SelectHcpSocietyDataEntity.javacertifyingPhysicianNmを設定
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
	 * SelectHcpSocietyDataEntity.javacertifyStYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javacertifyStMMを設定
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
	 * SelectHcpSocietyDataEntity.javacertifyStDDを設定
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
	 * SelectHcpSocietyDataEntity.javacertifyEdYYYYを設定
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
	 * SelectHcpSocietyDataEntity.javacertifyEdMMを設定
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
	 * SelectHcpSocietyDataEntity.javacertifyEdDDを設定
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
	 * SelectHcpSocietyDataEntity.javaupdFlgを設定
	 * @return updFlg
	 */
	public String getUpdFlg() {
		return updFlg;
	}

	/**
	 * @param updFlg セットする updFlg
	 */
	public void setUpdFlg(String updFlg) {
		this.updFlg = updFlg;
	}

	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
