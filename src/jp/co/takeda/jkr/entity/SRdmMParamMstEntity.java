/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.entity;

import java.io.Serializable;

import jp.co.takeda.jkr.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * Entityクラス
 * テーブル物理名 : M_RDM_PARAM_MST
 * テーブル論理名 : パラメタ情報
 * @generated
 */
public class SRdmMParamMstEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * パラメタ名（漢字）
     * @generated
     */
    private String paramKanj;

    /**
     * パラメタ名
     * @generated
     */
    private String paramName;

    /**
     * 値（漢字）
     * @generated
     */
    private String valueKanj;

    /**
     * 値
     * @generated
     */
    private String value;

    /**
     * 備考
     * @generated
     */
    private String biko;

    /**
     * コンストラクタ
     * @generated
     */
    public SRdmMParamMstEntity() {
        super("m_rdm_param_mst");
    }

    /**
     * パラメタ名（漢字）の取得
     * @return パラメタ名（漢字）
     * @generated
	 */
	public String getParamKanj() {
		return paramKanj;
	}

	/**
     * パラメタ名（漢字）の設定
     * @param paramKanj パラメタ名（漢字）
     * @generated
	 */
	public void setParamKanj(String paramKanj) {
		this.paramKanj = paramKanj;
	}

    /**
    * パラメタ名
    * @return パラメタ名
    * @generated
	 */
	public String getParamName() {
		return paramName;
	}

	/**
     * パラメタ名
     * @param paramName パラメタ名
     * @generated
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

    /**
    * 値（漢字）の取得
    * @return 値（漢字）
    * @generated
	 */
	public String getValueKanj() {
		return valueKanj;
	}

	/**
     * 値（漢字）の設定
     * @param valueKanj 値（漢字）
     * @generated
	 */
	public void setValueKanj(String valueKanj) {
		this.valueKanj = valueKanj;
	}

    /**
    * 値の取得
    * @return 値
    * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
     * 値の設定
     * @param value 値
     * @generated
	 */
	public void setValue(String value) {
		this.value = value;
	}

    /**
    * 備考の取得
    * @return 備考
    * @generated
	 */
	public String getBiko() {
		return biko;
	}

	/**
     * パラメタ名（漢字）の設定
     * @param paramKanj パラメタ名（漢字）
     * @generated
	 */
	public void setBiko(String biko) {
		this.biko = biko;
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
