/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_JGI_SOS_MST
 * SQLID : selectCntUnderSos
 * @generated
 */
public class SelectCntUnderSosEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;
    /**
     * 配下組織数
     * @generated
     */
    private String cntSos;

    /**
     * 組織コード (パラメータ)
     * @generated
     */
    private String inSosCd;

    public SelectCntUnderSosEntity() {
        super("m_rdm_jgi_sos_mst","selectCntUnderSos");
    }

	/**
	 * SelectCntUnderSosEntity.javacntSosを設定
	 * @return cntSos
	 */
	public String getCntSos() {
		return cntSos;
	}

	/**
	 * @param cntSos セットする cntSos
	 */
	public void setCntSos(String cntSos) {
		this.cntSos = cntSos;
	}

	/**
	 * SelectCntUnderSosEntity.javainSosCdを設定
	 * @return inSosCd
	 */
	public String getInSosCd() {
		return inSosCd;
	}

	/**
	 * @param inSosCd セットする inSosCd
	 */
	public void setInSosCd(String inSosCd) {
		this.inSosCd = inSosCd;
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