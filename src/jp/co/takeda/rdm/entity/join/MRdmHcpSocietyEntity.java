/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_HCP_SOCIETY
 * テーブル論理名 : 医師_所属学会情報
 * @generated
 */
public class MRdmHcpSocietyEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;
    private boolean docNoNullFlag;

    /**
     * 所属学会名称
     * @generated
     */
    private String medicalSocietyNm;
    private boolean medicalSocietyNmNullFlag;

    /**
     * 入会年月日(年)
     * @generated
     */
    private String admissionYYYY;
    private boolean admissionYYYYNullFlag;

    /**
     * 入会年月日(月)
     * @generated
     */
    private String admissionMM;
    private boolean admissionMMNullFlag;

    /**
     * 入会年月日(日)
     * @generated
     */
    private String admissionDD;
    private boolean admissionDDNullFlag;

    /**
     * 脱会年月日(年)
     * @generated
     */
    private String quitYYYY;
    private boolean quitYYYYNullFlag;

    /**
     * 脱会年月日(月)
     * @generated
     */
    private String quitMM;
    private boolean quitMMNullFlag;

    /**
     * 脱会年月日(日)
     * @generated
     */
    private String quitDD;
    private boolean quitDDNullFlag;

    /**
     * 所属役職
     * @generated
     */
    private String positionCode;
    private boolean positionCodeNullFlag;

    /**
     * 役職開始年月日(年)
     * @generated
     */
    private String societyPosiStYYYY;
    private boolean societyPosiStYYYYNullFlag;

    /**
     * 役職開始年月日(月)
     * @generated
     */
    private String societyPosiStMM;
    private boolean societyPosiStMMNullFlag;

    /**
     * 役職開始年月日(日)
     * @generated
     */
    private String societyPosiStDD;
    private boolean societyPosiStDDNullFlag;

    /**
     * 役職終了年月日(年)
     * @generated
     */
    private String societyPosiEdYYYY;
    private boolean societyPosiEdYYYYNullFlag;

    /**
     * 役職終了年月日(月)
     * @generated
     */
    private String societyPosiEdMM;
    private boolean societyPosiEdMMNullFlag;

    /**
     * 役職終了年月日(日)
     * @generated
     */
    private String societyPosiEdDD;
    private boolean societyPosiEdDDNullFlag;

    /**
     * 所属学会指導医区分
     * @generated
     */
    private String advisingDoctorCd;
    private boolean advisingDoctorCdNullFlag;

    /**
     * 指導医取得年月日(年)
     * @generated
     */
    private String coachingAcquisiYYYY;
    private boolean coachingAcquisiYYYYNullFlag;

    /**
     * 指導医取得年月日(月)
     * @generated
     */
    private String coachingAcquisiMM;
    private boolean coachingAcquisiMMNullFlag;

    /**
     * 指導医取得年月日(日)
     * @generated
     */
    private String coachingAcquisiDD;
    private boolean coachingAcquisiDDNullFlag;

    /**
     * 指導医開始年月日(年)
     * @generated
     */
    private String coachingStYYYY;
    private boolean coachingStYYYYNullFlag;

    /**
     * 指導医開始年月日(月)
     * @generated
     */
    private String coachingStMM;
    private boolean coachingStMMNullFlag;

    /**
     * 指導医開始年月日(日)
     * @generated
     */
    private String coachingStDD;
    private boolean coachingStDDNullFlag;

    /**
     * 指導医終了年月日(年)
     * @generated
     */
    private String coachingEdYYYY;
    private boolean coachingEdYYYYNullFlag;

    /**
     * 指導医終了年月日(月)
     * @generated
     */
    private String coachingEdMM;
    private boolean coachingEdMMNullFlag;

    /**
     * 指導医終了年月日(日)
     * @generated
     */
    private String coachingEdDD;
    private boolean coachingEdDDNullFlag;

    /**
     * 所属学会認定医区分
     * @generated
     */
    private String certifyingPhysicianCd;
    private boolean certifyingPhysicianCdNullFlag;

    /**
     * 認定医開始年月日(年)
     * @generated
     */
    private String certifyStYYYY;
    private boolean certifyStYYYYNullFlag;

    /**
     * 認定医開始年月日(月)
     * @generated
     */
    private String certifyStMM;
    private boolean certifyStMMNullFlag;

    /**
     * 認定医開始年月日(日)
     * @generated
     */
    private String certifyStDD;
    private boolean certifyStDDNullFlag;

    /**
     * 認定医終了年月日(年)
     * @generated
     */
    private String certifyEdYYYY;
    private boolean certifyEdYYYYNullFlag;

    /**
     * 認定医終了年月日(月)
     * @generated
     */
    private String certifyEdMM;
    private boolean certifyEdMMNullFlag;

    /**
     * 認定医終了年月日(日)
     * @generated
     */
    private String certifyEdDD;
    private boolean certifyEdDDNullFlag;

    /**
     * 作成日
     * @generated
     */
    private Date insShaYmd;
    private boolean insShaYmdNullFlag;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;
    private boolean insShaIdNullFlag;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;
    private boolean updShaYmdNullFlag;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;
    private boolean updShaIdNullFlag;

    /**
     * コンストラクタ
     * @generated
     */
    public MRdmHcpSocietyEntity() {
        super("m_rdm_hcp_society");
    }









	/**
	 * MRdmHcpSocietyEntity.javadocNoを設定
	 * @return docNo
	 */
	public String getDocNo() {
		return docNo;
	}





	/**
	 * @param docNo セットする docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}





	/**
	 * MRdmHcpSocietyEntity.javadocNoNullFlagを設定
	 * @return docNoNullFlag
	 */
	public boolean isDocNoNullFlag() {
		return docNoNullFlag;
	}





	/**
	 * @param docNoNullFlag セットする docNoNullFlag
	 */
	public void setDocNoNullFlag(boolean docNoNullFlag) {
		this.docNoNullFlag = docNoNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javamedicalSocietyNmを設定
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
	 * MRdmHcpSocietyEntity.javamedicalSocietyNmNullFlagを設定
	 * @return medicalSocietyNmNullFlag
	 */
	public boolean isMedicalSocietyNmNullFlag() {
		return medicalSocietyNmNullFlag;
	}





	/**
	 * @param medicalSocietyNmNullFlag セットする medicalSocietyNmNullFlag
	 */
	public void setMedicalSocietyNmNullFlag(boolean medicalSocietyNmNullFlag) {
		this.medicalSocietyNmNullFlag = medicalSocietyNmNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaadmissionYYYYを設定
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
	 * MRdmHcpSocietyEntity.javaadmissionYYYYNullFlagを設定
	 * @return admissionYYYYNullFlag
	 */
	public boolean isAdmissionYYYYNullFlag() {
		return admissionYYYYNullFlag;
	}





	/**
	 * @param admissionYYYYNullFlag セットする admissionYYYYNullFlag
	 */
	public void setAdmissionYYYYNullFlag(boolean admissionYYYYNullFlag) {
		this.admissionYYYYNullFlag = admissionYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaadmissionMMを設定
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
	 * MRdmHcpSocietyEntity.javaadmissionMMNullFlagを設定
	 * @return admissionMMNullFlag
	 */
	public boolean isAdmissionMMNullFlag() {
		return admissionMMNullFlag;
	}





	/**
	 * @param admissionMMNullFlag セットする admissionMMNullFlag
	 */
	public void setAdmissionMMNullFlag(boolean admissionMMNullFlag) {
		this.admissionMMNullFlag = admissionMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaadmissionDDを設定
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
	 * MRdmHcpSocietyEntity.javaadmissionDDNullFlagを設定
	 * @return admissionDDNullFlag
	 */
	public boolean isAdmissionDDNullFlag() {
		return admissionDDNullFlag;
	}





	/**
	 * @param admissionDDNullFlag セットする admissionDDNullFlag
	 */
	public void setAdmissionDDNullFlag(boolean admissionDDNullFlag) {
		this.admissionDDNullFlag = admissionDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaquitYYYYを設定
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
	 * MRdmHcpSocietyEntity.javaquitYYYYNullFlagを設定
	 * @return quitYYYYNullFlag
	 */
	public boolean isQuitYYYYNullFlag() {
		return quitYYYYNullFlag;
	}





	/**
	 * @param quitYYYYNullFlag セットする quitYYYYNullFlag
	 */
	public void setQuitYYYYNullFlag(boolean quitYYYYNullFlag) {
		this.quitYYYYNullFlag = quitYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaquitMMを設定
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
	 * MRdmHcpSocietyEntity.javaquitMMNullFlagを設定
	 * @return quitMMNullFlag
	 */
	public boolean isQuitMMNullFlag() {
		return quitMMNullFlag;
	}





	/**
	 * @param quitMMNullFlag セットする quitMMNullFlag
	 */
	public void setQuitMMNullFlag(boolean quitMMNullFlag) {
		this.quitMMNullFlag = quitMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaquitDDを設定
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
	 * MRdmHcpSocietyEntity.javaquitDDNullFlagを設定
	 * @return quitDDNullFlag
	 */
	public boolean isQuitDDNullFlag() {
		return quitDDNullFlag;
	}





	/**
	 * @param quitDDNullFlag セットする quitDDNullFlag
	 */
	public void setQuitDDNullFlag(boolean quitDDNullFlag) {
		this.quitDDNullFlag = quitDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javapositionCodeを設定
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
	 * MRdmHcpSocietyEntity.javapositionCodeNullFlagを設定
	 * @return positionCodeNullFlag
	 */
	public boolean isPositionCodeNullFlag() {
		return positionCodeNullFlag;
	}





	/**
	 * @param positionCodeNullFlag セットする positionCodeNullFlag
	 */
	public void setPositionCodeNullFlag(boolean positionCodeNullFlag) {
		this.positionCodeNullFlag = positionCodeNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javasocietyPosiStYYYYを設定
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
	 * MRdmHcpSocietyEntity.javasocietyPosiStYYYYNullFlagを設定
	 * @return societyPosiStYYYYNullFlag
	 */
	public boolean isSocietyPosiStYYYYNullFlag() {
		return societyPosiStYYYYNullFlag;
	}





	/**
	 * @param societyPosiStYYYYNullFlag セットする societyPosiStYYYYNullFlag
	 */
	public void setSocietyPosiStYYYYNullFlag(boolean societyPosiStYYYYNullFlag) {
		this.societyPosiStYYYYNullFlag = societyPosiStYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javasocietyPosiStMMを設定
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
	 * MRdmHcpSocietyEntity.javasocietyPosiStMMNullFlagを設定
	 * @return societyPosiStMMNullFlag
	 */
	public boolean isSocietyPosiStMMNullFlag() {
		return societyPosiStMMNullFlag;
	}





	/**
	 * @param societyPosiStMMNullFlag セットする societyPosiStMMNullFlag
	 */
	public void setSocietyPosiStMMNullFlag(boolean societyPosiStMMNullFlag) {
		this.societyPosiStMMNullFlag = societyPosiStMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javasocietyPosiStDDを設定
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
	 * MRdmHcpSocietyEntity.javasocietyPosiStDDNullFlagを設定
	 * @return societyPosiStDDNullFlag
	 */
	public boolean isSocietyPosiStDDNullFlag() {
		return societyPosiStDDNullFlag;
	}





	/**
	 * @param societyPosiStDDNullFlag セットする societyPosiStDDNullFlag
	 */
	public void setSocietyPosiStDDNullFlag(boolean societyPosiStDDNullFlag) {
		this.societyPosiStDDNullFlag = societyPosiStDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javasocietyPosiEdYYYYを設定
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
	 * MRdmHcpSocietyEntity.javasocietyPosiEdYYYYNullFlagを設定
	 * @return societyPosiEdYYYYNullFlag
	 */
	public boolean isSocietyPosiEdYYYYNullFlag() {
		return societyPosiEdYYYYNullFlag;
	}





	/**
	 * @param societyPosiEdYYYYNullFlag セットする societyPosiEdYYYYNullFlag
	 */
	public void setSocietyPosiEdYYYYNullFlag(boolean societyPosiEdYYYYNullFlag) {
		this.societyPosiEdYYYYNullFlag = societyPosiEdYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javasocietyPosiEdMMを設定
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
	 * MRdmHcpSocietyEntity.javasocietyPosiEdMMNullFlagを設定
	 * @return societyPosiEdMMNullFlag
	 */
	public boolean isSocietyPosiEdMMNullFlag() {
		return societyPosiEdMMNullFlag;
	}





	/**
	 * @param societyPosiEdMMNullFlag セットする societyPosiEdMMNullFlag
	 */
	public void setSocietyPosiEdMMNullFlag(boolean societyPosiEdMMNullFlag) {
		this.societyPosiEdMMNullFlag = societyPosiEdMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javasocietyPosiEdDDを設定
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
	 * MRdmHcpSocietyEntity.javasocietyPosiEdDDNullFlagを設定
	 * @return societyPosiEdDDNullFlag
	 */
	public boolean isSocietyPosiEdDDNullFlag() {
		return societyPosiEdDDNullFlag;
	}





	/**
	 * @param societyPosiEdDDNullFlag セットする societyPosiEdDDNullFlag
	 */
	public void setSocietyPosiEdDDNullFlag(boolean societyPosiEdDDNullFlag) {
		this.societyPosiEdDDNullFlag = societyPosiEdDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaadvisingDoctorCdを設定
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
	 * MRdmHcpSocietyEntity.javaadvisingDoctorCdNullFlagを設定
	 * @return advisingDoctorCdNullFlag
	 */
	public boolean isAdvisingDoctorCdNullFlag() {
		return advisingDoctorCdNullFlag;
	}





	/**
	 * @param advisingDoctorCdNullFlag セットする advisingDoctorCdNullFlag
	 */
	public void setAdvisingDoctorCdNullFlag(boolean advisingDoctorCdNullFlag) {
		this.advisingDoctorCdNullFlag = advisingDoctorCdNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingAcquisiYYYYを設定
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
	 * MRdmHcpSocietyEntity.javacoachingAcquisiYYYYNullFlagを設定
	 * @return coachingAcquisiYYYYNullFlag
	 */
	public boolean isCoachingAcquisiYYYYNullFlag() {
		return coachingAcquisiYYYYNullFlag;
	}





	/**
	 * @param coachingAcquisiYYYYNullFlag セットする coachingAcquisiYYYYNullFlag
	 */
	public void setCoachingAcquisiYYYYNullFlag(boolean coachingAcquisiYYYYNullFlag) {
		this.coachingAcquisiYYYYNullFlag = coachingAcquisiYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingAcquisiMMを設定
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
	 * MRdmHcpSocietyEntity.javacoachingAcquisiMMNullFlagを設定
	 * @return coachingAcquisiMMNullFlag
	 */
	public boolean isCoachingAcquisiMMNullFlag() {
		return coachingAcquisiMMNullFlag;
	}





	/**
	 * @param coachingAcquisiMMNullFlag セットする coachingAcquisiMMNullFlag
	 */
	public void setCoachingAcquisiMMNullFlag(boolean coachingAcquisiMMNullFlag) {
		this.coachingAcquisiMMNullFlag = coachingAcquisiMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingAcquisiDDを設定
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
	 * MRdmHcpSocietyEntity.javacoachingAcquisiDDNullFlagを設定
	 * @return coachingAcquisiDDNullFlag
	 */
	public boolean isCoachingAcquisiDDNullFlag() {
		return coachingAcquisiDDNullFlag;
	}





	/**
	 * @param coachingAcquisiDDNullFlag セットする coachingAcquisiDDNullFlag
	 */
	public void setCoachingAcquisiDDNullFlag(boolean coachingAcquisiDDNullFlag) {
		this.coachingAcquisiDDNullFlag = coachingAcquisiDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingStYYYYを設定
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
	 * MRdmHcpSocietyEntity.javacoachingStYYYYNullFlagを設定
	 * @return coachingStYYYYNullFlag
	 */
	public boolean isCoachingStYYYYNullFlag() {
		return coachingStYYYYNullFlag;
	}





	/**
	 * @param coachingStYYYYNullFlag セットする coachingStYYYYNullFlag
	 */
	public void setCoachingStYYYYNullFlag(boolean coachingStYYYYNullFlag) {
		this.coachingStYYYYNullFlag = coachingStYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingStMMを設定
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
	 * MRdmHcpSocietyEntity.javacoachingStMMNullFlagを設定
	 * @return coachingStMMNullFlag
	 */
	public boolean isCoachingStMMNullFlag() {
		return coachingStMMNullFlag;
	}





	/**
	 * @param coachingStMMNullFlag セットする coachingStMMNullFlag
	 */
	public void setCoachingStMMNullFlag(boolean coachingStMMNullFlag) {
		this.coachingStMMNullFlag = coachingStMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingStDDを設定
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
	 * MRdmHcpSocietyEntity.javacoachingStDDNullFlagを設定
	 * @return coachingStDDNullFlag
	 */
	public boolean isCoachingStDDNullFlag() {
		return coachingStDDNullFlag;
	}





	/**
	 * @param coachingStDDNullFlag セットする coachingStDDNullFlag
	 */
	public void setCoachingStDDNullFlag(boolean coachingStDDNullFlag) {
		this.coachingStDDNullFlag = coachingStDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingEdYYYYを設定
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
	 * MRdmHcpSocietyEntity.javacoachingEdYYYYNullFlagを設定
	 * @return coachingEdYYYYNullFlag
	 */
	public boolean isCoachingEdYYYYNullFlag() {
		return coachingEdYYYYNullFlag;
	}





	/**
	 * @param coachingEdYYYYNullFlag セットする coachingEdYYYYNullFlag
	 */
	public void setCoachingEdYYYYNullFlag(boolean coachingEdYYYYNullFlag) {
		this.coachingEdYYYYNullFlag = coachingEdYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingEdMMを設定
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
	 * MRdmHcpSocietyEntity.javacoachingEdMMNullFlagを設定
	 * @return coachingEdMMNullFlag
	 */
	public boolean isCoachingEdMMNullFlag() {
		return coachingEdMMNullFlag;
	}





	/**
	 * @param coachingEdMMNullFlag セットする coachingEdMMNullFlag
	 */
	public void setCoachingEdMMNullFlag(boolean coachingEdMMNullFlag) {
		this.coachingEdMMNullFlag = coachingEdMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacoachingEdDDを設定
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
	 * MRdmHcpSocietyEntity.javacoachingEdDDNullFlagを設定
	 * @return coachingEdDDNullFlag
	 */
	public boolean isCoachingEdDDNullFlag() {
		return coachingEdDDNullFlag;
	}





	/**
	 * @param coachingEdDDNullFlag セットする coachingEdDDNullFlag
	 */
	public void setCoachingEdDDNullFlag(boolean coachingEdDDNullFlag) {
		this.coachingEdDDNullFlag = coachingEdDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacertifyingPhysicianCdを設定
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
	 * MRdmHcpSocietyEntity.javacertifyingPhysicianCdNullFlagを設定
	 * @return certifyingPhysicianCdNullFlag
	 */
	public boolean isCertifyingPhysicianCdNullFlag() {
		return certifyingPhysicianCdNullFlag;
	}





	/**
	 * @param certifyingPhysicianCdNullFlag セットする certifyingPhysicianCdNullFlag
	 */
	public void setCertifyingPhysicianCdNullFlag(boolean certifyingPhysicianCdNullFlag) {
		this.certifyingPhysicianCdNullFlag = certifyingPhysicianCdNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacertifyStYYYYを設定
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
	 * MRdmHcpSocietyEntity.javacertifyStYYYYNullFlagを設定
	 * @return certifyStYYYYNullFlag
	 */
	public boolean isCertifyStYYYYNullFlag() {
		return certifyStYYYYNullFlag;
	}





	/**
	 * @param certifyStYYYYNullFlag セットする certifyStYYYYNullFlag
	 */
	public void setCertifyStYYYYNullFlag(boolean certifyStYYYYNullFlag) {
		this.certifyStYYYYNullFlag = certifyStYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacertifyStMMを設定
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
	 * MRdmHcpSocietyEntity.javacertifyStMMNullFlagを設定
	 * @return certifyStMMNullFlag
	 */
	public boolean isCertifyStMMNullFlag() {
		return certifyStMMNullFlag;
	}





	/**
	 * @param certifyStMMNullFlag セットする certifyStMMNullFlag
	 */
	public void setCertifyStMMNullFlag(boolean certifyStMMNullFlag) {
		this.certifyStMMNullFlag = certifyStMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacertifyStDDを設定
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
	 * MRdmHcpSocietyEntity.javacertifyStDDNullFlagを設定
	 * @return certifyStDDNullFlag
	 */
	public boolean isCertifyStDDNullFlag() {
		return certifyStDDNullFlag;
	}





	/**
	 * @param certifyStDDNullFlag セットする certifyStDDNullFlag
	 */
	public void setCertifyStDDNullFlag(boolean certifyStDDNullFlag) {
		this.certifyStDDNullFlag = certifyStDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacertifyEdYYYYを設定
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
	 * MRdmHcpSocietyEntity.javacertifyEdYYYYNullFlagを設定
	 * @return certifyEdYYYYNullFlag
	 */
	public boolean isCertifyEdYYYYNullFlag() {
		return certifyEdYYYYNullFlag;
	}





	/**
	 * @param certifyEdYYYYNullFlag セットする certifyEdYYYYNullFlag
	 */
	public void setCertifyEdYYYYNullFlag(boolean certifyEdYYYYNullFlag) {
		this.certifyEdYYYYNullFlag = certifyEdYYYYNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacertifyEdMMを設定
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
	 * MRdmHcpSocietyEntity.javacertifyEdMMNullFlagを設定
	 * @return certifyEdMMNullFlag
	 */
	public boolean isCertifyEdMMNullFlag() {
		return certifyEdMMNullFlag;
	}





	/**
	 * @param certifyEdMMNullFlag セットする certifyEdMMNullFlag
	 */
	public void setCertifyEdMMNullFlag(boolean certifyEdMMNullFlag) {
		this.certifyEdMMNullFlag = certifyEdMMNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javacertifyEdDDを設定
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
	 * MRdmHcpSocietyEntity.javacertifyEdDDNullFlagを設定
	 * @return certifyEdDDNullFlag
	 */
	public boolean isCertifyEdDDNullFlag() {
		return certifyEdDDNullFlag;
	}





	/**
	 * @param certifyEdDDNullFlag セットする certifyEdDDNullFlag
	 */
	public void setCertifyEdDDNullFlag(boolean certifyEdDDNullFlag) {
		this.certifyEdDDNullFlag = certifyEdDDNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javainsShaYmdを設定
	 * @return insShaYmd
	 */
	public Date getInsShaYmd() {
		return insShaYmd;
	}





	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(Date insShaYmd) {
		this.insShaYmd = insShaYmd;
	}





	/**
	 * MRdmHcpSocietyEntity.javainsShaYmdNullFlagを設定
	 * @return insShaYmdNullFlag
	 */
	public boolean isInsShaYmdNullFlag() {
		return insShaYmdNullFlag;
	}





	/**
	 * @param insShaYmdNullFlag セットする insShaYmdNullFlag
	 */
	public void setInsShaYmdNullFlag(boolean insShaYmdNullFlag) {
		this.insShaYmdNullFlag = insShaYmdNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javainsShaIdを設定
	 * @return insShaId
	 */
	public String getInsShaId() {
		return insShaId;
	}





	/**
	 * @param insShaId セットする insShaId
	 */
	public void setInsShaId(String insShaId) {
		this.insShaId = insShaId;
	}





	/**
	 * MRdmHcpSocietyEntity.javainsShaIdNullFlagを設定
	 * @return insShaIdNullFlag
	 */
	public boolean isInsShaIdNullFlag() {
		return insShaIdNullFlag;
	}





	/**
	 * @param insShaIdNullFlag セットする insShaIdNullFlag
	 */
	public void setInsShaIdNullFlag(boolean insShaIdNullFlag) {
		this.insShaIdNullFlag = insShaIdNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public Date getUpdShaYmd() {
		return updShaYmd;
	}





	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(Date updShaYmd) {
		this.updShaYmd = updShaYmd;
	}





	/**
	 * MRdmHcpSocietyEntity.javaupdShaYmdNullFlagを設定
	 * @return updShaYmdNullFlag
	 */
	public boolean isUpdShaYmdNullFlag() {
		return updShaYmdNullFlag;
	}





	/**
	 * @param updShaYmdNullFlag セットする updShaYmdNullFlag
	 */
	public void setUpdShaYmdNullFlag(boolean updShaYmdNullFlag) {
		this.updShaYmdNullFlag = updShaYmdNullFlag;
	}





	/**
	 * MRdmHcpSocietyEntity.javaupdShaIdを設定
	 * @return updShaId
	 */
	public String getUpdShaId() {
		return updShaId;
	}





	/**
	 * @param updShaId セットする updShaId
	 */
	public void setUpdShaId(String updShaId) {
		this.updShaId = updShaId;
	}





	/**
	 * MRdmHcpSocietyEntity.javaupdShaIdNullFlagを設定
	 * @return updShaIdNullFlag
	 */
	public boolean isUpdShaIdNullFlag() {
		return updShaIdNullFlag;
	}





	/**
	 * @param updShaIdNullFlag セットする updShaIdNullFlag
	 */
	public void setUpdShaIdNullFlag(boolean updShaIdNullFlag) {
		this.updShaIdNullFlag = updShaIdNullFlag;
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
