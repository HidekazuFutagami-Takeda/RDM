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
 * テーブル物理名 : M_RDM_CODE_MST
 * SQLID : selectComboList
 * @generated
 */
public class SelectNd001ComboListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_データ区分 (パラメータ)
     * @generated
     */
    private String inDataKbn;

    /**
     * 値
     * @generated
     */
    private String value1;

    /**
     * 値１（漢字）
     * @generated
     */
    private String value1Kanj;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNd001ComboListEntity() {
        super("m_rdm_code_mst" , "selectNd001ComboList");
    }

    /**
     * 入力_データ区分の取得
     * @return 入力_データ区分
     * @generated
     */
    public String getInDataKbn() {
        return inDataKbn;
    }

    /**
     * 入力_データ区分の設定
     * @param inDataKbn 入力_データ区分
     * @generated
     */
    public void setInDataKbn(String inDataKbn) {
        this.inDataKbn = inDataKbn;
    }

	/**
	 * SelectNd001ComboListEntity.javavalue1を設定
	 * @return value1
	 */
	public String getValue1() {
		return value1;
	}

	/**
	 * @param value1 セットする value1
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
	}

	/**
	 * SelectNd001ComboListEntity.javavalue1Kanjを設定
	 * @return value1Kanj
	 */
	public String getValue1Kanj() {
		return value1Kanj;
	}

	/**
	 * @param value1Kanj セットする value1Kanj
	 */
	public void setValue1Kanj(String value1Kanj) {
		this.value1Kanj = value1Kanj;
	}

	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
