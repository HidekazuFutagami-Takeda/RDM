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
 * SQLID : selectParamNF001
 */
public class SelectParamNF001Entity extends BaseEntity implements Serializable {

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
     * コンストラクタ
     */
    public SelectParamNF001Entity() {
    	 super("m_rdm_param_mst" , "selectParamNF001");
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
}
