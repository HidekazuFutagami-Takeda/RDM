/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.jkr.common.BaseEntity;

import java.util.List;

/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_PARAM_MST
 * SQLID : selectParamSwitch
 */
public class SelectParamSwitchEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;


    /**
     * パラム名 (パラメータ)
     */
    private Integer inParamName;

    /**
     * 新規フラグ
     */
    private String shinkiFlg;

    /**
     * 編集フラグ
     */
    private String henshuFlg;

    /**
     * 削除フラグ
     */
    private String sakujoFlg;

    /**
     * 復活フラグ
     */
    private String fukkatsuFlg;

    /**
     * コンストラクタ
     */
    public SelectParamSwitchEntity() {
        super("m_rdm_param_mst" , "selectParamSwitch");
    }

	/**
	 * SelectParamSwitchEntity.javainParamNameを設定
	 * @return inParamName
	 */
	public Integer getInParamName() {
		return inParamName;
	}

	/**
	 * @param inParamName セットする inParamName
	 */
	public void setInParamName(Integer inParamName) {
		this.inParamName = inParamName;
	}

	/**
	 * SelectParamSwitchEntity.javashinkiFlgを設定
	 * @return shinkiFlg
	 */
	public String getShinkiFlg() {
		return shinkiFlg;
	}


	/**
	 * @param shinkiFlg セットする shinkiFlg
	 */
	public void setShinkiFlg(String shinkiFlg) {
		this.shinkiFlg = shinkiFlg;
	}


	/**
	 * SelectParamSwitchEntity.javahenshuFlgを設定
	 * @return henshuFlg
	 */
	public String getHenshuFlg() {
		return henshuFlg;
	}


	/**
	 * @param henshuFlg セットする henshuFlg
	 */
	public void setHenshuFlg(String henshuFlg) {
		this.henshuFlg = henshuFlg;
	}


	/**
	 * SelectParamSwitchEntity.javasakujoFlgを設定
	 * @return sakujoFlg
	 */
	public String getSakujoFlg() {
		return sakujoFlg;
	}


	/**
	 * @param sakujoFlg セットする sakujoFlg
	 */
	public void setSakujoFlg(String sakujoFlg) {
		this.sakujoFlg = sakujoFlg;
	}


	/**
	 * SelectParamSwitchEntity.javafukkatsuFlgを設定
	 * @return fukkatsuFlg
	 */
	public String getFukkatsuFlg() {
		return fukkatsuFlg;
	}


	/**
	 * @param fukkatsuFlg セットする fukkatsuFlg
	 */
	public void setFukkatsuFlg(String fukkatsuFlg) {
		this.fukkatsuFlg = fukkatsuFlg;
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
