/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

import java.util.List;

/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_PARAM_MST
 * SQLID : selectParamNd001
 */
public class SelectParamNd401Entity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師検索表示件数
     */
    private String paramName;

    /**
     * 医師検索表示件数
     */
    private Integer value;

    /**
     * 検索条件_施設名
     * @generated
     */
    private String kensakuInsKanj;

    /**
     * 検索条件_施設固定C
     * @generated
     */
    private String kensakuInsNo;

    /**
     * 検索条件_医師名
     * @generated
     */
    private String kensakuDocKanj;

    /**
     * 検索条件_医師固定C
     * @generated
     */
    private String kensakuDocNo;

    /**
     * 検索条件_所属部科コード
     * @generated
     */
    private String kensakuDeptCode;

    /**
     * 検索条件_組織コード
     * @generated
     */
    private String kensakuSosCd;

    /**
     * 検索条件_医薬支店C
     * @generated
     */
    private String kensakuBrCode;

    /**
     * 検索条件_医薬営業所C
     * @generated
     */
    private String kensakuDistCode;

    /**
     * 検索条件_担当者コード(従業員番号)
     * @generated
     */
    private String kensakuJgiNo;


    /**
     * コンストラクタ
     */
    public SelectParamNd401Entity() {
        super("m_rdm_param_mst" , "selectParamND401");
    }

	/**
	 * SelectParamNd001Entity.javaparamNameを設定
	 * @return paramName
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * @param paramName セットする paramName
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * SelectParamNd001Entity.javavalueを設定
	 * @return value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value セットする value
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	/**
	 * SelectParamNd401Entity.javakensakuInsKanjを設定
	 * @return kensakuInsKanj
	 */
	public String getKensakuInsKanj() {
		return kensakuInsKanj;
	}

	/**
	 * @param kensakuInsKanj セットする kensakuInsKanj
	 */
	public void setKensakuInsKanj(String kensakuInsKanj) {
		this.kensakuInsKanj = kensakuInsKanj;
	}

	/**
	 * SelectParamNd401Entity.javakensakuInsNoを設定
	 * @return kensakuInsNo
	 */
	public String getKensakuInsNo() {
		return kensakuInsNo;
	}

	/**
	 * @param kensakuInsNo セットする kensakuInsNo
	 */
	public void setKensakuInsNo(String kensakuInsNo) {
		this.kensakuInsNo = kensakuInsNo;
	}

	/**
	 * SelectParamNd401Entity.javakensakuDocKanjを設定
	 * @return kensakuDocKanj
	 */
	public String getKensakuDocKanj() {
		return kensakuDocKanj;
	}

	/**
	 * @param kensakuDocKanj セットする kensakuDocKanj
	 */
	public void setKensakuDocKanj(String kensakuDocKanj) {
		this.kensakuDocKanj = kensakuDocKanj;
	}

	/**
	 * SelectParamNd401Entity.javakensakuDocNoを設定
	 * @return kensakuDocNo
	 */
	public String getKensakuDocNo() {
		return kensakuDocNo;
	}

	/**
	 * @param kensakuDocNo セットする kensakuDocNo
	 */
	public void setKensakuDocNo(String kensakuDocNo) {
		this.kensakuDocNo = kensakuDocNo;
	}

	/**
	 * SelectParamNd401Entity.javakensakuDeptCodeを設定
	 * @return kensakuDeptCode
	 */
	public String getKensakuDeptCode() {
		return kensakuDeptCode;
	}

	/**
	 * @param kensakuDeptCode セットする kensakuDeptCode
	 */
	public void setKensakuDeptCode(String kensakuDeptCode) {
		this.kensakuDeptCode = kensakuDeptCode;
	}

	/**
	 * SelectParamNd401Entity.javakensakuSosCdを設定
	 * @return kensakuSosCd
	 */
	public String getKensakuSosCd() {
		return kensakuSosCd;
	}

	/**
	 * @param kensakuSosCd セットする kensakuSosCd
	 */
	public void setKensakuSosCd(String kensakuSosCd) {
		this.kensakuSosCd = kensakuSosCd;
	}

	/**
	 * SelectParamNd401Entity.javakensakuBrCodeを設定
	 * @return kensakuBrCode
	 */
	public String getKensakuBrCode() {
		return kensakuBrCode;
	}

	/**
	 * @param kensakuBrCode セットする kensakuBrCode
	 */
	public void setKensakuBrCode(String kensakuBrCode) {
		this.kensakuBrCode = kensakuBrCode;
	}

	/**
	 * SelectParamNd401Entity.javakensakuDistCodeを設定
	 * @return kensakuDistCode
	 */
	public String getKensakuDistCode() {
		return kensakuDistCode;
	}

	/**
	 * @param kensakuDistCode セットする kensakuDistCode
	 */
	public void setKensakuDistCode(String kensakuDistCode) {
		this.kensakuDistCode = kensakuDistCode;
	}

	/**
	 * SelectParamNd401Entity.javakensakuJgiNoを設定
	 * @return kensakuJgiNo
	 */
	public String getKensakuJgiNo() {
		return kensakuJgiNo;
	}

	/**
	 * @param kensakuJgiNo セットする kensakuJgiNo
	 */
	public void setKensakuJgiNo(String kensakuJgiNo) {
		this.kensakuJgiNo = kensakuJgiNo;
	}

	/**
	 * SelectParamNd401Entity.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
