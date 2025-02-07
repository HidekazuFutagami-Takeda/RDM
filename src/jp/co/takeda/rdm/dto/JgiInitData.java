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
public class JgiInitData implements Serializable {

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
    private String bumonRyakuName;

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
     * コンストラクタ
     * @customizable
     */
    public JgiInitData() {
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
	 * JgiInitData.javabumonRyakuNameを設定
	 * @return bumonRyakuName
	 */
	public String getBumonRyakuName() {
		return bumonRyakuName;
	}

	/**
	 * @param bumonRyakuName セットする bumonRyakuName
	 */
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
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
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
