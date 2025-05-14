/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_SOS_MST
 * SQLID : selectInitSos
 * @generated
 */
public class SelectInitSosAutoEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 組織コード(パラメータ)
     * @generated
     */
    private Integer inSosCd;


	/**
     * 部門ランク
     * @generated
     */
    private Integer bumonRank;

    /**
     * 組織コード
     * @generated
     */
    private String sosCd;

    /**
     * 上位組織コード
     * @generated
     */
    private String upSosCode;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectInitSosAutoEntity() {
        super("m_rdm_sos_mst" , "selectInitSosAuto");
    }

    /**
	 * SelectInitSosAutoEntity.javainSosCdを設定
	 * @return inSosCd
	 */
	public Integer getInSosCd() {
		return inSosCd;
	}

	/**
	 * @param inSosCd セットする inSosCd
	 */
	public void setInSosCd(Integer inSosCd) {
		this.inSosCd = inSosCd;
	}

	/**
	 * SelectInitSosAutoEntity.javabumonRankを設定
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
	 * SelectInitSosAutoEntity.javasosCdを設定
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
	 * SelectInitSosAutoEntity.javaupSosCodeを設定
	 * @return upSosCode
	 */
	public String getUpSosCode() {
		return upSosCode;
	}

	/**
	 * @param upSosCode セットする upSosCode
	 */
	public void setUpSosCode(String upSosCode) {
		this.upSosCode = upSosCode;
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
