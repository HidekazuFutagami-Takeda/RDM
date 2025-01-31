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
 * テーブル物理名 : T_RDM_HCP_PUBLIC_REQ
 * SQLID : selectHcpPublicData
 * @generated
 */
public class SelectHcpPublicDataEntity extends BaseEntity implements Serializable {

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
     * 入力_公的機関名 (パラメータ3)
     * @generated
     */
    private String inPubInstitutionCd;

    /**
     * 分類区分コード
     * @generated
     */
    private String classCategoryCd;

    /**
     * 分類区分名称
     * @generated
     */
    private String classCategoryNm;

    /**
     * 公的機関コード
     * @generated
     */
    private String pubInstitutionCd;

    /**
     * 公的機関名称
     * @generated
     */
    private String pubInstitutionNm;

    /**
     * 公的機関開始年月日(年)
     * @generated
     */
    private String pubInstStYYYY;

    /**
     * 公的機関開始年月日(月)
     * @generated
     */
    private String pubInstStMM;

    /**
     * 公的機関開始年月日(日)
     * @generated
     */
    private String pubInstStDD;

    /**
     * 公的機関終了年月日(年)
     * @generated
     */
    private String pubInstEdYYYY;

    /**
     * 公的機関終了年月日(月)
     * @generated
     */
    private String pubInstEdMM;

    /**
     * 公的機関終了年月日(日)
     * @generated
     */
    private String pubInstEdDD;

    /**
     * 公的機関役職コード
     * @generated
     */
    private String pubInstPositionCd;

    /**
     * 公的機関役職名称
     * @generated
     */
    private String pubInstPositionNm;

    /**
     * 公的機関役職開始年月日(年)
     * @generated
     */
    private String pubInstposStYYYY;

    /**
     * 公的機関役職開始年月日(月)
     * @generated
     */
    private String pubInstposStMM;

    /**
     * 公的機関役職開始年月日(日)
     * @generated
     */
    private String pubInstposStDD;

    /**
     * 公的機関役職終了年月日(年)
     * @generated
     */
    private String pubInstposEdYYYY;

    /**
     * 公的機関役職終了年月日(月)
     * @generated
     */
    private String pubInstposEdMM;

    /**
     * 公的機関役職終了年月日(日)
     * @generated
     */
    private String pubInstposEdDD;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectHcpPublicDataEntity() {
        super("t_rdm_hcp_public_req" , "selectHcpPublicData");
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
	 * SelectHcpPublicDataEntity.javainPubInstitutionCdを設定
	 * @return inPubInstitutionCd
	 */
	public String getInPubInstitutionCd() {
		return inPubInstitutionCd;
	}

	/**
	 * @param inPubInstitutionCd セットする inPubInstitutionCd
	 */
	public void setInPubInstitutionCd(String inPubInstitutionCd) {
		this.inPubInstitutionCd = inPubInstitutionCd;
	}

	/**
	 * SelectHcpPublicDataEntity.javaclassCategoryCdを設定
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
	 * SelectHcpPublicDataEntity.javaclassCategoryNmを設定
	 * @return classCategoryNm
	 */
	public String getClassCategoryNm() {
		return classCategoryNm;
	}

	/**
	 * @param classCategoryNm セットする classCategoryNm
	 */
	public void setClassCategoryNm(String classCategoryNm) {
		this.classCategoryNm = classCategoryNm;
	}

	/**
	 * SelectHcpPublicDataEntity.javapubInstitutionCdを設定
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
	 * SelectHcpPublicDataEntity.javapubInstitutionNmを設定
	 * @return pubInstitutionNm
	 */
	public String getPubInstitutionNm() {
		return pubInstitutionNm;
	}

	/**
	 * @param pubInstitutionNm セットする pubInstitutionNm
	 */
	public void setPubInstitutionNm(String pubInstitutionNm) {
		this.pubInstitutionNm = pubInstitutionNm;
	}

	/**
	 * SelectHcpPublicDataEntity.javapubInstStYYYYを設定
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
	 * SelectHcpPublicDataEntity.javapubInstStMMを設定
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
	 * SelectHcpPublicDataEntity.javapubInstStDDを設定
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
	 * SelectHcpPublicDataEntity.javapubInstEdYYYYを設定
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
	 * SelectHcpPublicDataEntity.javapubInstEdMMを設定
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
	 * SelectHcpPublicDataEntity.javapubInstEdDDを設定
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
	 * SelectHcpPublicDataEntity.javapubInstPositionCdを設定
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
	 * SelectHcpPublicDataEntity.javapubInstPositionNmを設定
	 * @return pubInstPositionNm
	 */
	public String getPubInstPositionNm() {
		return pubInstPositionNm;
	}

	/**
	 * @param pubInstPositionNm セットする pubInstPositionNm
	 */
	public void setPubInstPositionNm(String pubInstPositionNm) {
		this.pubInstPositionNm = pubInstPositionNm;
	}

	/**
	 * SelectHcpPublicDataEntity.javapubInstposStYYYYを設定
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
	 * SelectHcpPublicDataEntity.javapubInstposStMMを設定
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
	 * SelectHcpPublicDataEntity.javapubInstposStDDを設定
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
	 * SelectHcpPublicDataEntity.javapubInstposEdYYYYを設定
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
	 * SelectHcpPublicDataEntity.javapubInstposEdMMを設定
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
	 * SelectHcpPublicDataEntity.javapubInstposEdDDを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
