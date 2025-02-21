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
 * SQLID : selectNd102TrnList
 * @generated
 */
public class SelectNd102TrnListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 値１（漢字）
     * @generated
     */
    private String value1Kanj;

    /**
     * 異動区分値１
     * @generated
     */
    private String trnValue1;

    /**
     * ダミー施設コード値１
     * @generated
     */
    private String dummyValue1;


    /**
     * コンストラクタ
     * @generated
     */
    public SelectNd102TrnListEntity() {
        super("m_rdm_code_mst" , "selectNd102TrnList");
    }

	/**
	 * SelectNd102TrnListEntity.javavalue1Kanjを設定
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
	 * SelectNd102TrnListEntity.javatrnValue1を設定
	 * @return trnValue1
	 */
	public String getTrnValue1() {
		return trnValue1;
	}

	/**
	 * @param trnValue1 セットする trnValue1
	 */
	public void setTrnValue1(String trnValue1) {
		this.trnValue1 = trnValue1;
	}

	/**
	 * SelectNd102TrnListEntity.javadummyValue1を設定
	 * @return dummyValue1
	 */
	public String getDummyValue1() {
		return dummyValue1;
	}

	/**
	 * @param dummyValue1 セットする dummyValue1
	 */
	public void setDummyValue1(String dummyValue1) {
		this.dummyValue1 = dummyValue1;
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
