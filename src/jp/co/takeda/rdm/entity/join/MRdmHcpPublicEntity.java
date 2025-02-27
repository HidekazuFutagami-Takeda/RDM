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
 * テーブル物理名 : M_RDM_HCP_PUBLIC
 * テーブル論理名 : 医師_公的機関情報
 * @generated
 */
public class MRdmHcpPublicEntity extends BaseEntity implements Serializable {

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
     * 分類区分
     * @generated
     */
    private String classCategoryCd;
    private boolean classCategoryCdNullFlag;

    /**
     * 公的機関
     * @generated
     */
    private String pubInstitutionCd;
    private boolean pubInstitutionCdNullFlag;

    /**
     * 公的機関開始年月日(年)
     * @generated
     */
    private String pubInstStYYYY;
    private boolean pubInstStYYYYNullFlag;

    /**
     * 公的機関開始年月日(月)
     * @generated
     */
    private String pubInstStMM;
    private boolean pubInstStMMNullFlag;

    /**
     * 公的機関開始年月日(日)
     * @generated
     */
    private String pubInstStDD;
    private boolean pubInstStDDNullFlag;

    /**
     * 公的機関終了年月日(年)
     * @generated
     */
    private String pubInstEdYYYY;
    private boolean pubInstEdYYYYNullFlag;

    /**
     * 公的機関終了年月日(月)
     * @generated
     */
    private String pubInstEdMM;
    private boolean pubInstEdMMNullFlag;

    /**
     * 公的機関終了年月日(日)
     * @generated
     */
    private String pubInstEdDD;
    private boolean pubInstEdDDNullFlag;

    /**
     * 公的機関役職コード
     * @generated
     */
    private String pubInstPositionCd;
    private boolean pubInstPositionCdNullFlag;

    /**
     * 公的機関役職開始年月日(年)
     * @generated
     */
    private String pubInstposStYYYY;
    private boolean pubInstposStYYYYNullFlag;

    /**
     * 公的機関役職開始年月日(月)
     * @generated
     */
    private String pubInstposStMM;
    private boolean pubInstposStMMNullFlag;

    /**
     * 公的機関役職開始年月日(日)
     * @generated
     */
    private String pubInstposStDD;
    private boolean pubInstposStDDNullFlag;

    /**
     * 公的機関役職終了年月日(年)
     * @generated
     */
    private String pubInstposEdYYYY;
    private boolean pubInstposEdYYYYNullFlag;

    /**
     * 公的機関役職終了年月日(月)
     * @generated
     */
    private String pubInstposEdMM;
    private boolean pubInstposEdMMNullFlag;

    /**
     * 公的機関役職終了年月日(日)
     * @generated
     */
    private String pubInstposEdDD;
    private boolean pubInstposEdDDNullFlag;

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
    public MRdmHcpPublicEntity() {
        super("m_rdm_hcp_public");
    }




	/**
	 * TRdmHcpPublicReqEntity.javadocNoを設定
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
	 * TRdmHcpPublicReqEntity.javadocNoNullFlagを設定
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
	 * TRdmHcpPublicReqEntity.javaclassCategoryCdを設定
	 * @return classCategoryCd
	 */
	public String getClassCategoryCd() {
		return classCategoryCd;
	}




	/**
	 * @param classCategoryCd セットする classCategoryCd
	 */
	public void setClassCategoryCd(String classCategoryCd) {
		this.classCategoryCd = classCategoryCd;
	}




	/**
	 * TRdmHcpPublicReqEntity.javaclassCategoryCdNullFlagを設定
	 * @return classCategoryCdNullFlag
	 */
	public boolean isClassCategoryCdNullFlag() {
		return classCategoryCdNullFlag;
	}




	/**
	 * @param classCategoryCdNullFlag セットする classCategoryCdNullFlag
	 */
	public void setClassCategoryCdNullFlag(boolean classCategoryCdNullFlag) {
		this.classCategoryCdNullFlag = classCategoryCdNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstitutionCdを設定
	 * @return pubInstitutionCd
	 */
	public String getPubInstitutionCd() {
		return pubInstitutionCd;
	}




	/**
	 * @param pubInstitutionCd セットする pubInstitutionCd
	 */
	public void setPubInstitutionCd(String pubInstitutionCd) {
		this.pubInstitutionCd = pubInstitutionCd;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstitutionCdNullFlagを設定
	 * @return pubInstitutionCdNullFlag
	 */
	public boolean isPubInstitutionCdNullFlag() {
		return pubInstitutionCdNullFlag;
	}




	/**
	 * @param pubInstitutionCdNullFlag セットする pubInstitutionCdNullFlag
	 */
	public void setPubInstitutionCdNullFlag(boolean pubInstitutionCdNullFlag) {
		this.pubInstitutionCdNullFlag = pubInstitutionCdNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstStYYYYを設定
	 * @return pubInstStYYYY
	 */
	public String getPubInstStYYYY() {
		return pubInstStYYYY;
	}




	/**
	 * @param pubInstStYYYY セットする pubInstStYYYY
	 */
	public void setPubInstStYYYY(String pubInstStYYYY) {
		this.pubInstStYYYY = pubInstStYYYY;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstStYYYYNullFlagを設定
	 * @return pubInstStYYYYNullFlag
	 */
	public boolean isPubInstStYYYYNullFlag() {
		return pubInstStYYYYNullFlag;
	}




	/**
	 * @param pubInstStYYYYNullFlag セットする pubInstStYYYYNullFlag
	 */
	public void setPubInstStYYYYNullFlag(boolean pubInstStYYYYNullFlag) {
		this.pubInstStYYYYNullFlag = pubInstStYYYYNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstStMMを設定
	 * @return pubInstStMM
	 */
	public String getPubInstStMM() {
		return pubInstStMM;
	}




	/**
	 * @param pubInstStMM セットする pubInstStMM
	 */
	public void setPubInstStMM(String pubInstStMM) {
		this.pubInstStMM = pubInstStMM;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstStMMNullFlagを設定
	 * @return pubInstStMMNullFlag
	 */
	public boolean isPubInstStMMNullFlag() {
		return pubInstStMMNullFlag;
	}




	/**
	 * @param pubInstStMMNullFlag セットする pubInstStMMNullFlag
	 */
	public void setPubInstStMMNullFlag(boolean pubInstStMMNullFlag) {
		this.pubInstStMMNullFlag = pubInstStMMNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstStDDを設定
	 * @return pubInstStDD
	 */
	public String getPubInstStDD() {
		return pubInstStDD;
	}




	/**
	 * @param pubInstStDD セットする pubInstStDD
	 */
	public void setPubInstStDD(String pubInstStDD) {
		this.pubInstStDD = pubInstStDD;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstStDDNullFlagを設定
	 * @return pubInstStDDNullFlag
	 */
	public boolean isPubInstStDDNullFlag() {
		return pubInstStDDNullFlag;
	}




	/**
	 * @param pubInstStDDNullFlag セットする pubInstStDDNullFlag
	 */
	public void setPubInstStDDNullFlag(boolean pubInstStDDNullFlag) {
		this.pubInstStDDNullFlag = pubInstStDDNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstEdYYYYを設定
	 * @return pubInstEdYYYY
	 */
	public String getPubInstEdYYYY() {
		return pubInstEdYYYY;
	}




	/**
	 * @param pubInstEdYYYY セットする pubInstEdYYYY
	 */
	public void setPubInstEdYYYY(String pubInstEdYYYY) {
		this.pubInstEdYYYY = pubInstEdYYYY;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstEdYYYYNullFlagを設定
	 * @return pubInstEdYYYYNullFlag
	 */
	public boolean isPubInstEdYYYYNullFlag() {
		return pubInstEdYYYYNullFlag;
	}




	/**
	 * @param pubInstEdYYYYNullFlag セットする pubInstEdYYYYNullFlag
	 */
	public void setPubInstEdYYYYNullFlag(boolean pubInstEdYYYYNullFlag) {
		this.pubInstEdYYYYNullFlag = pubInstEdYYYYNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstEdMMを設定
	 * @return pubInstEdMM
	 */
	public String getPubInstEdMM() {
		return pubInstEdMM;
	}




	/**
	 * @param pubInstEdMM セットする pubInstEdMM
	 */
	public void setPubInstEdMM(String pubInstEdMM) {
		this.pubInstEdMM = pubInstEdMM;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstEdMMNullFlagを設定
	 * @return pubInstEdMMNullFlag
	 */
	public boolean isPubInstEdMMNullFlag() {
		return pubInstEdMMNullFlag;
	}




	/**
	 * @param pubInstEdMMNullFlag セットする pubInstEdMMNullFlag
	 */
	public void setPubInstEdMMNullFlag(boolean pubInstEdMMNullFlag) {
		this.pubInstEdMMNullFlag = pubInstEdMMNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstEdDDを設定
	 * @return pubInstEdDD
	 */
	public String getPubInstEdDD() {
		return pubInstEdDD;
	}




	/**
	 * @param pubInstEdDD セットする pubInstEdDD
	 */
	public void setPubInstEdDD(String pubInstEdDD) {
		this.pubInstEdDD = pubInstEdDD;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstEdDDNullFlagを設定
	 * @return pubInstEdDDNullFlag
	 */
	public boolean isPubInstEdDDNullFlag() {
		return pubInstEdDDNullFlag;
	}




	/**
	 * @param pubInstEdDDNullFlag セットする pubInstEdDDNullFlag
	 */
	public void setPubInstEdDDNullFlag(boolean pubInstEdDDNullFlag) {
		this.pubInstEdDDNullFlag = pubInstEdDDNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstPositionCdを設定
	 * @return pubInstPositionCd
	 */
	public String getPubInstPositionCd() {
		return pubInstPositionCd;
	}




	/**
	 * @param pubInstPositionCd セットする pubInstPositionCd
	 */
	public void setPubInstPositionCd(String pubInstPositionCd) {
		this.pubInstPositionCd = pubInstPositionCd;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstPositionCdNullFlagを設定
	 * @return pubInstPositionCdNullFlag
	 */
	public boolean isPubInstPositionCdNullFlag() {
		return pubInstPositionCdNullFlag;
	}




	/**
	 * @param pubInstPositionCdNullFlag セットする pubInstPositionCdNullFlag
	 */
	public void setPubInstPositionCdNullFlag(boolean pubInstPositionCdNullFlag) {
		this.pubInstPositionCdNullFlag = pubInstPositionCdNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposStYYYYを設定
	 * @return pubInstposStYYYY
	 */
	public String getPubInstposStYYYY() {
		return pubInstposStYYYY;
	}




	/**
	 * @param pubInstposStYYYY セットする pubInstposStYYYY
	 */
	public void setPubInstposStYYYY(String pubInstposStYYYY) {
		this.pubInstposStYYYY = pubInstposStYYYY;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposStYYYYNullFlagを設定
	 * @return pubInstposStYYYYNullFlag
	 */
	public boolean isPubInstposStYYYYNullFlag() {
		return pubInstposStYYYYNullFlag;
	}




	/**
	 * @param pubInstposStYYYYNullFlag セットする pubInstposStYYYYNullFlag
	 */
	public void setPubInstposStYYYYNullFlag(boolean pubInstposStYYYYNullFlag) {
		this.pubInstposStYYYYNullFlag = pubInstposStYYYYNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposStMMを設定
	 * @return pubInstposStMM
	 */
	public String getPubInstposStMM() {
		return pubInstposStMM;
	}




	/**
	 * @param pubInstposStMM セットする pubInstposStMM
	 */
	public void setPubInstposStMM(String pubInstposStMM) {
		this.pubInstposStMM = pubInstposStMM;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposStMMNullFlagを設定
	 * @return pubInstposStMMNullFlag
	 */
	public boolean isPubInstposStMMNullFlag() {
		return pubInstposStMMNullFlag;
	}




	/**
	 * @param pubInstposStMMNullFlag セットする pubInstposStMMNullFlag
	 */
	public void setPubInstposStMMNullFlag(boolean pubInstposStMMNullFlag) {
		this.pubInstposStMMNullFlag = pubInstposStMMNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposStDDを設定
	 * @return pubInstposStDD
	 */
	public String getPubInstposStDD() {
		return pubInstposStDD;
	}




	/**
	 * @param pubInstposStDD セットする pubInstposStDD
	 */
	public void setPubInstposStDD(String pubInstposStDD) {
		this.pubInstposStDD = pubInstposStDD;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposStDDNullFlagを設定
	 * @return pubInstposStDDNullFlag
	 */
	public boolean isPubInstposStDDNullFlag() {
		return pubInstposStDDNullFlag;
	}




	/**
	 * @param pubInstposStDDNullFlag セットする pubInstposStDDNullFlag
	 */
	public void setPubInstposStDDNullFlag(boolean pubInstposStDDNullFlag) {
		this.pubInstposStDDNullFlag = pubInstposStDDNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposEdYYYYを設定
	 * @return pubInstposEdYYYY
	 */
	public String getPubInstposEdYYYY() {
		return pubInstposEdYYYY;
	}




	/**
	 * @param pubInstposEdYYYY セットする pubInstposEdYYYY
	 */
	public void setPubInstposEdYYYY(String pubInstposEdYYYY) {
		this.pubInstposEdYYYY = pubInstposEdYYYY;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposEdYYYYNullFlagを設定
	 * @return pubInstposEdYYYYNullFlag
	 */
	public boolean isPubInstposEdYYYYNullFlag() {
		return pubInstposEdYYYYNullFlag;
	}




	/**
	 * @param pubInstposEdYYYYNullFlag セットする pubInstposEdYYYYNullFlag
	 */
	public void setPubInstposEdYYYYNullFlag(boolean pubInstposEdYYYYNullFlag) {
		this.pubInstposEdYYYYNullFlag = pubInstposEdYYYYNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposEdMMを設定
	 * @return pubInstposEdMM
	 */
	public String getPubInstposEdMM() {
		return pubInstposEdMM;
	}




	/**
	 * @param pubInstposEdMM セットする pubInstposEdMM
	 */
	public void setPubInstposEdMM(String pubInstposEdMM) {
		this.pubInstposEdMM = pubInstposEdMM;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposEdMMNullFlagを設定
	 * @return pubInstposEdMMNullFlag
	 */
	public boolean isPubInstposEdMMNullFlag() {
		return pubInstposEdMMNullFlag;
	}




	/**
	 * @param pubInstposEdMMNullFlag セットする pubInstposEdMMNullFlag
	 */
	public void setPubInstposEdMMNullFlag(boolean pubInstposEdMMNullFlag) {
		this.pubInstposEdMMNullFlag = pubInstposEdMMNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposEdDDを設定
	 * @return pubInstposEdDD
	 */
	public String getPubInstposEdDD() {
		return pubInstposEdDD;
	}




	/**
	 * @param pubInstposEdDD セットする pubInstposEdDD
	 */
	public void setPubInstposEdDD(String pubInstposEdDD) {
		this.pubInstposEdDD = pubInstposEdDD;
	}




	/**
	 * TRdmHcpPublicReqEntity.javapubInstposEdDDNullFlagを設定
	 * @return pubInstposEdDDNullFlag
	 */
	public boolean isPubInstposEdDDNullFlag() {
		return pubInstposEdDDNullFlag;
	}




	/**
	 * @param pubInstposEdDDNullFlag セットする pubInstposEdDDNullFlag
	 */
	public void setPubInstposEdDDNullFlag(boolean pubInstposEdDDNullFlag) {
		this.pubInstposEdDDNullFlag = pubInstposEdDDNullFlag;
	}




	/**
	 * TRdmHcpPublicReqEntity.javainsShaYmdを設定
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
	 * TRdmHcpPublicReqEntity.javainsShaYmdNullFlagを設定
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
	 * TRdmHcpPublicReqEntity.javainsShaIdを設定
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
	 * TRdmHcpPublicReqEntity.javainsShaIdNullFlagを設定
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
	 * TRdmHcpPublicReqEntity.javaupdShaYmdを設定
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
	 * TRdmHcpPublicReqEntity.javaupdShaYmdNullFlagを設定
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
	 * TRdmHcpPublicReqEntity.javaupdShaIdを設定
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
	 * TRdmHcpPublicReqEntity.javaupdShaIdNullFlagを設定
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
