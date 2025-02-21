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
 * SQLID : selectNd102MrDummyCheck
 * @generated
 */
public class SelectNd102MrDummyCheckEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師固定コード (パラメータ)
     * @generated
     */
    private String inInsNo;

    /**
     * 値１（漢字）
     * @generated
     */
    private String codeKanj;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNd102MrDummyCheckEntity() {
        super("m_rdm_code_mst" , "selectNd102MrDummyCheck");
    }

	/**
	 * SelectNd102MrDummyCheckEntity.javainInsNoを設定
	 * @return inInsNo
	 */
	public String getInInsNo() {
		return inInsNo;
	}

	/**
	 * @param inInsNo セットする inInsNo
	 */
	public void setInInsNo(String inInsNo) {
		this.inInsNo = inInsNo;
	}

	/**
	 * SelectNd102MrDummyCheckEntity.javacodeKanjを設定
	 * @return codeKanj
	 */
	public String getCodeKanj() {
		return codeKanj;
	}

	/**
	 * @param codeKanj セットする codeKanj
	 */
	public void setCodeKanj(String codeKanj) {
		this.codeKanj = codeKanj;
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
