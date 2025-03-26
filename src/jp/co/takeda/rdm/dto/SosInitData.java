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
public class SosInitData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

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
     * 組織名称
     * @generated
     */
    private String bumonSeiName;

    /**
     * 医薬支店C
     * @generated
     */
    private String brCode;

    /**
     * 医薬営業所C
     * @generated
     */
    private String distCode;

    /**
     * 上位組織コード
     * @generated
     */
    private String upSosCode;

    /**
     * 組織名称※上位組織コードに紐づく
     * @generated
     */
    private Integer upBumonRank;

    /**
     * 医薬支店C※上位組織コードに紐づく
     * @generated
     */
    private String upBrCode;

    /**
     * 医薬営業所C※上位組織コードに紐づく
     * @generated
     */
    private String upDistCode;

    /**
     * 領域コード
     * @generated
     */
    private String trtCode;

	/**
     * 部門ランクポップアップ用
     * @generated
     */
    private Integer bumonRankPop;

    /**
     * コンストラクタ
     * @customizable
     */
    public SosInitData() {
        // START UOC

        // END UOC
    }

    /**
	 * 部門ランクの取得
	 * @return　部門ランク
	 * @generated
	 */
	public Integer getBumonRank() {
		return bumonRank;
	}

	/**
	 * 部門ランクの設定
	　* @param bumonRank　部門ランク
	 *　@generated
	 */
	public void setBumonRank(Integer bumonRank) {
		this.bumonRank = bumonRank;
	}

	/**
	 * 組織コードの取得
	 * @return　組織コード
	 * @generated
	 */
	public String getSosCd() {
		return sosCd;
	}

	/**
	 * 組織コードの設定
	　* @param sosCd　組織コード
	 *　@generated
	 */
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

	/**
	 * 組織名称の取得
	 * @return　組織名称
	 * @generated
	 */
	public String getBumonSeiName() {
		return bumonSeiName;
	}

	/**
	 * 組織名称の設定
	　* @param bumonSeiName　組織名称
	 *　@generated
	 */
	public void setBumonSeiName(String bumonSeiName) {
		this.bumonSeiName = bumonSeiName;
	}

	/**
	 * 医薬支店Cの取得
	 * @return　医薬支店C
	 * @generated
	 */
	public String getBrCode() {
		return brCode;
	}

	/**
	 * 医薬支店Cの設定
	　* @param brCode　医薬支店C
	 *　@generated
	 */
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	/**
	 * 医薬営業所Cの取得
	 * @return　医薬営業所C
	 * @generated
	 */
	public String getDistCode() {
		return distCode;
	}

	/**
	 * 医薬営業所Cの設定
	　* @param distCode　医薬営業所C
	 *　@generated
	 */
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	/**
	 * 上位組織コードの取得
	 * @return　上位組織コード
	 * @generated
	 */
	public String getUpSosCode() {
		return upSosCode;
	}

	/**
	 * 上位組織コードの設定
	　* @param upSosCode　上位組織コード
	 *　@generated
	 */
	public void setUpSosCode(String upSosCode) {
		this.upSosCode = upSosCode;
	}

	/**
	 * 組織名称※上位組織コードに紐づくの取得
	 * @return　組織名称※上位組織コードに紐づく
	 * @generated
	 */
	public Integer getUpBumonRank() {
		return upBumonRank;
	}

	/**
	 * 組織名称※上位組織コードに紐づくの設定
	　* @param upBumonRank　組織名称※上位組織コードに紐づく
	 *　@generated
	 */
	public void setUpBumonRank(Integer upBumonRank) {
		this.upBumonRank = upBumonRank;
	}

	/**
	 * 医薬支店C※上位組織コードに紐づくの取得
	 * @return　医薬支店C※上位組織コードに紐づく
	 * @generated
	 */
	public String getUpBrCode() {
		return upBrCode;
	}

	/**
	 * 医薬支店C※上位組織コードに紐づくの設定
	　* @param upBrCode　医薬支店C※上位組織コードに紐づく
	 *　@generated
	 */
	public void setUpBrCode(String upBrCode) {
		this.upBrCode = upBrCode;
	}

	/**
	 * 医薬営業所C※上位組織コードに紐づくの取得
	 * @return　医薬営業所C※上位組織コードに紐づく
	 * @generated
	 */
	public String getUpDistCode() {
		return upDistCode;
	}

	/**
	 * 医薬営業所C※上位組織コードに紐づくの設定
	　* @param upDistCode　医薬営業所C※上位組織コードに紐づく
	 *　@generated
	 */
	public void setUpDistCode(String upDistCode) {
		this.upDistCode = upDistCode;
	}

    /**
	 * SosInitData.javatrtCodeを設定
	 * @return trtCode
	 */
	public String getTrtCode() {
		return trtCode;
	}

	/**
	 * @param trtCode セットする trtCode
	 */
	public void setTrtCode(String trtCode) {
		this.trtCode = trtCode;
	}

	/**
	 * SosInitData.javabumonRankPopを設定
	 * @return bumonRankPop
	 */
	public Integer getBumonRankPop() {
		return bumonRankPop;
	}

	/**
	 * @param bumonRankPop セットする bumonRankPop
	 */
	public void setBumonRankPop(Integer bumonRankPop) {
		this.bumonRankPop = bumonRankPop;
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

