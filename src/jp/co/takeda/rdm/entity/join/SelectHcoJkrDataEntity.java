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
 * テーブル物理名 : M_RDM_HCO_JKR_WK
 * SQLID : selectHcoJkrData
 * @generated
 */
public class SelectHcoJkrDataEntity extends BaseEntity implements Serializable {

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
     * 入力_施設コード (パラメータ2)
     * @generated
     */
    private String inInsNo;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * 領域名
     * @generated
     */
    private String trtNm;

    /**
     * 従業員番号
     * @generated
     */
    private String jgiNo;

    /**
     * 従業員名
     * @generated
     */
    private String jgiNm;

    /**
     * 領域グループコード
     * @generated
     */
    private String trtGrpCd;

    /**
     * MR種類
     * @generated
     */
    private String mrCat;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectHcoJkrDataEntity() {
        super("m_rdm_hco_jkr_wk" , "selectHcoJkrData");
    }

	/**
	 * SelectHcoJkrDataEntity.javainReqIdを設定
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
	 * SelectHcoJkrDataEntity.javaininsNoを設定
	 * @return ininsNo
	 */
	public String getIninsNo() {
		return inInsNo;
	}

	/**
	 * @param ininsNo セットする ininsNo
	 */
	public void setIninsNo(String ininsNo) {
		this.inInsNo = ininsNo;
	}

	/**
	 * SelectHcoJkrDataEntity.javatrtCdを設定
	 * @return trtCd
	 */
	public String getTrtCd() {
		return trtCd;
	}

	/**
	 * @param trtCd セットする trtCd
	 */
	public void setTrtCd(String trtCd) {
		this.trtCd = trtCd;
	}

	/**
	 * SelectHcoJkrDataEntity.javatrtNmを設定
	 * @return trtNm
	 */
	public String getTrtNm() {
		return trtNm;
	}

	/**
	 * @param trtNm セットする trtNm
	 */
	public void setTrtNm(String trtNm) {
		this.trtNm = trtNm;
	}

	/**
	 * SelectHcoJkrDataEntity.javajgiNoを設定
	 * @return jgiNo
	 */
	public String getJgiNo() {
		return jgiNo;
	}

	/**
	 * @param jgiNo セットする jgiNo
	 */
	public void setJgiNo(String jgiNo) {
		this.jgiNo = jgiNo;
	}

	/**
	 * SelectHcoJkrDataEntity.javajgiNmを設定
	 * @return jgiNm
	 */
	public String getJgiNm() {
		return jgiNm;
	}

	/**
	 * @param jgiNm セットする jgiNm
	 */
	public void setJgiNm(String jgiNm) {
		this.jgiNm = jgiNm;
	}

	/**
	 * SelectHcoJkrDataEntity.javatrtGrpCdを設定
	 * @return trtGrpCd
	 */
	public String getTrtGrpCd() {
		return trtGrpCd;
	}

	/**
	 * @param trtGrpCd セットする trtGrpCd
	 */
	public void setTrtGrpCd(String trtGrpCd) {
		this.trtGrpCd = trtGrpCd;
	}

	/**
	 * SelectHcoJkrDataEntity.javamrCatを設定
	 * @return mrCat
	 */
	public String getMrCat() {
		return mrCat;
	}

	/**
	 * @param mrCat セットする mrCat
	 */
	public void setMrCat(String mrCat) {
		this.mrCat = mrCat;
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
