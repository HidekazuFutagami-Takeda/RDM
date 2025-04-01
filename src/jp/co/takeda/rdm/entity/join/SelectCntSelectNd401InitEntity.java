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
     * 検索条件_施設名
     * @generated
     */
    private String kensakuInsKanj;

    /**
     * 検索条件_施設固定C
     * @generated
     */
    private String kensakuInsNo;

    /**
     * 検索条件_医師名
     * @generated
     */
    private String kensakuDocKanj;

    /**
     * 検索条件_医師固定C
     * @generated
     */
    private String kensakuDocNo;

    /**
     * 検索条件_所属部科コード
     * @generated
     */
    private String kensakuDeptCode;

    /**
     * 検索条件_組織コード
     * @generated
     */
    private String kensakuSosCd;

    /**
     * 検索条件_部門ランク
     * @generated
     */
    private String kensakuBumonRank;

    /**
     * 検索条件_医薬支店C
     * @generated
     */
    private String kensakuBrCode;

    /**
     * 検索条件_医薬営業所C
     * @generated
     */
    private String kensakuDistCode;

    /**
     * 検索条件_担当者コード(従業員番号)
     * @generated
     */
    private String kensakuJgiNo;


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

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuInsKanjを設定
	 * @return kensakuInsKanj
	 */
	public String getKensakuInsKanj() {
		return kensakuInsKanj;
	}

	/**
	 * @param kensakuInsKanj セットする kensakuInsKanj
	 */
	public void setKensakuInsKanj(String kensakuInsKanj) {
		this.kensakuInsKanj = kensakuInsKanj;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuInsNoを設定
	 * @return kensakuInsNo
	 */
	public String getKensakuInsNo() {
		return kensakuInsNo;
	}

	/**
	 * @param kensakuInsNo セットする kensakuInsNo
	 */
	public void setKensakuInsNo(String kensakuInsNo) {
		this.kensakuInsNo = kensakuInsNo;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuDocKanjを設定
	 * @return kensakuDocKanj
	 */
	public String getKensakuDocKanj() {
		return kensakuDocKanj;
	}

	/**
	 * @param kensakuDocKanj セットする kensakuDocKanj
	 */
	public void setKensakuDocKanj(String kensakuDocKanj) {
		this.kensakuDocKanj = kensakuDocKanj;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuDocNoを設定
	 * @return kensakuDocNo
	 */
	public String getKensakuDocNo() {
		return kensakuDocNo;
	}

	/**
	 * @param kensakuDocNo セットする kensakuDocNo
	 */
	public void setKensakuDocNo(String kensakuDocNo) {
		this.kensakuDocNo = kensakuDocNo;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuDeptCodeを設定
	 * @return kensakuDeptCode
	 */
	public String getKensakuDeptCode() {
		return kensakuDeptCode;
	}

	/**
	 * @param kensakuDeptCode セットする kensakuDeptCode
	 */
	public void setKensakuDeptCode(String kensakuDeptCode) {
		this.kensakuDeptCode = kensakuDeptCode;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuSosCdを設定
	 * @return kensakuSosCd
	 */
	public String getKensakuSosCd() {
		return kensakuSosCd;
	}

	/**
	 * @param kensakuSosCd セットする kensakuSosCd
	 */
	public void setKensakuSosCd(String kensakuSosCd) {
		this.kensakuSosCd = kensakuSosCd;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuBumonRankを設定
	 * @return kensakuBumonRank
	 */
	public String getKensakuBumonRank() {
		return kensakuBumonRank;
	}

	/**
	 * @param kensakuBumonRank セットする kensakuBumonRank
	 */
	public void setKensakuBumonRank(String kensakuBumonRank) {
		this.kensakuBumonRank = kensakuBumonRank;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuBrCodeを設定
	 * @return kensakuBrCode
	 */
	public String getKensakuBrCode() {
		return kensakuBrCode;
	}

	/**
	 * @param kensakuBrCode セットする kensakuBrCode
	 */
	public void setKensakuBrCode(String kensakuBrCode) {
		this.kensakuBrCode = kensakuBrCode;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuDistCodeを設定
	 * @return kensakuDistCode
	 */
	public String getKensakuDistCode() {
		return kensakuDistCode;
	}

	/**
	 * @param kensakuDistCode セットする kensakuDistCode
	 */
	public void setKensakuDistCode(String kensakuDistCode) {
		this.kensakuDistCode = kensakuDistCode;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javakensakuJgiNoを設定
	 * @return kensakuJgiNo
	 */
	public String getKensakuJgiNo() {
		return kensakuJgiNo;
	}

	/**
	 * @param kensakuJgiNo セットする kensakuJgiNo
	 */
	public void setKensakuJgiNo(String kensakuJgiNo) {
		this.kensakuJgiNo = kensakuJgiNo;
	}

	/**
	 * SelectCntSelectNd401InitEntity.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
