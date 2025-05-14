/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス
 * @generated
 */
public class SosJgiInitData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 組織コード
     * @generated
     */
    private String sosCd;

    /**
     * 上位組織コード
     * @generated
     */
    private String upSosCd;

    /**
     * 部門ランク
     * @generated
     */
    private Integer bumonRank;

    /**
     * コンストラクタ
     * @customizable
     */
    public SosJgiInitData() {
        // START UOC

        // END UOC
    }

    /**
	 * SosJgiInitData.javasosCdを設定
	 * @return sosCd
	 */
	public String getSosCd() {
		return sosCd;
	}

	/**
	 * @param sosCd セットする sosCd
	 */
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

	/**
	 * SosJgiInitData.javaupSosCdを設定
	 * @return upSosCd
	 */
	public String getUpSosCd() {
		return upSosCd;
	}

	/**
	 * @param upSosCd セットする upSosCd
	 */
	public void setUpSosCd(String upSosCd) {
		this.upSosCd = upSosCd;
	}

	/**
	 * SosJgiInitData.javabumonRankを設定
	 * @return bumonRank
	 */
	public Integer getBumonRank() {
		return bumonRank;
	}

	/**
	 * @param bumonRank セットする bumonRank
	 */
	public void setBumonRank(Integer bumonRank) {
		this.bumonRank = bumonRank;
	}

	/**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

