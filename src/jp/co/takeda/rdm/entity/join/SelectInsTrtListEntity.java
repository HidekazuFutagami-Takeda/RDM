/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_HCO_MST
 * SQLID : selectInsTrtList
 * @generated
 */
public class SelectInsTrtListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_SELECT区分 (パラメータ1)
     * @generated
     */
    private Integer inSelectKbn;

    /**
     * 施設固定コード (パラメータ2)
     * @generated
     */
    private String insNo;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 領域
     * @generated
     */
    private String trtNm;

    /**
     * 所属
     * @generated
     */
    private String bumon;

    /**
     * 担当者
     * @generated
     */
    private String jgiName;

    /**
     * メールアドレス
     * @generated
     */
    private String jgiMailAddress;

    /**
     * 主副担当区分
     * @generated
     */
    private String value1Kanj;

    /**
     * レコード件数
     * @generated
     */
    private Integer recCnt;

	/**
     * コンストラクタ
     * @generated
     */
    public SelectInsTrtListEntity() {
        super("m_rdm_hco_mst" , "selectInsTrtListEntity");
    }

    /**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}


	public Integer getInSelectKbn() {
		return inSelectKbn;
	}


	public void setInSelectKbn(Integer inSelectKbn) {
		this.inSelectKbn = inSelectKbn;
	}


	public String getInsAbbrName() {
		return insAbbrName;
	}


	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}


	public String getTrtNm() {
		return trtNm;
	}


	public void setTrtNm(String trtNm) {
		this.trtNm = trtNm;
	}


	public String getBumon() {
		return bumon;
	}


	public void setBumon(String bumon) {
		this.bumon = bumon;
	}


	public String getJgiName() {
		return jgiName;
	}


	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}


	public String getJgiMailAddress() {
		return jgiMailAddress;
	}


	public void setJgiMailAddress(String jgiMailAddress) {
		this.jgiMailAddress = jgiMailAddress;
	}


	public String getValue1Kanj() {
		return value1Kanj;
	}


	public void setValue1Kanj(String value1Kanj) {
		this.value1Kanj = value1Kanj;
	}


	public Integer getRecCnt() {
		return recCnt;
	}


	public void setRecCnt(Integer recCnt) {
		this.recCnt = recCnt;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
