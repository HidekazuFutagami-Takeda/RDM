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
 * SQLID : selectNd307ParamSwitch
 */
public class SelectNd307ParamSwitchEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師勤務先メニュースイッチ
     */
    private String kmuFlg;

    /**
     * 医師メニュースイッチ
     */
    private String docFlg;

    /**
     * コンストラクタ
     */
    public SelectNd307ParamSwitchEntity() {
        super("m_rdm_param_mst" , "selectNd307ParamSwitch");
    }

	/**
	 * SelectNd307ParamSwitchEntity.javakmuFlgを設定
	 * @return kmuFlg
	 */
	public String getKmuFlg() {
		return kmuFlg;
	}

	/**
	 * @param kmuFlg セットする kmuFlg
	 */
	public void setKmuFlg(String kmuFlg) {
		this.kmuFlg = kmuFlg;
	}

	/**
	 * SelectNd307ParamSwitchEntity.javadocFlgを設定
	 * @return docFlg
	 */
	public String getDocFlg() {
		return docFlg;
	}

	/**
	 * @param docFlg セットする docFlg
	 */
	public void setDocFlg(String docFlg) {
		this.docFlg = docFlg;
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
