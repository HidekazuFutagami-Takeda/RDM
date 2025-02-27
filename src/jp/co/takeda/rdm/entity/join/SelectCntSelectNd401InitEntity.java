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
 * テーブル物理名 : M_RDM_HCP_MST
 * SQLID : selectCntHcp
 */
public class SelectCntSelectNd401InitEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師勤務先検索表示件数
     */
    private Integer cntKmu;

    /**
     * コンストラクタ
     */
    public SelectCntSelectNd401InitEntity() {
        super("m_rdm_hcp_work" , "selectCntNd401Init");
    }

	/**
	 * SelectCntSelectNd401InitEntity.javacntKmuを設定
	 * @return cntKmu
	 */
	public Integer getCntKmu() {
		return cntKmu;
	}

	/**
	 * @param cntKmu セットする cntKmu
	 */
	public void setCntKmu(Integer cntKmu) {
		this.cntKmu = cntKmu;
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
