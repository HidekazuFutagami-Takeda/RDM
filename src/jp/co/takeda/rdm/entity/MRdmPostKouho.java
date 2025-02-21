/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス   MRdmPostKouho
 * テーブル物理名 : S_JKR_T_PSS_CHOHYO_KIHON
 * テーブル論理名 : 帳票基本情報
 * @generated
 */
public class MRdmPostKouho extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * test
     * @generated
     */
    /**
     * 入力_セッションID
     * @generated
     */
    private String seshonId;
    /**
     * 入力_スクリーンID
     * @generated
     */
    private String screenId;
    /**
     * 遷移元画面ID
     * @generated
     */
    private String preScreenId;
    /**
     * 入力_郵便番号
     * @generated
     */
    private String inPostCode;


	/**
     * 検索条件_郵便番号
     * @generated
     */
    private String postCode;

    /**
     * 検索条件_JIS府県名
     * @generated
     */
    private String addrNamePref;

    /**
     * 検索条件_JIS市区町村名
     * @generated
     */
    private String addrNameCity;

    /**
     * 検索条件_大字/町域名
     * @generated
     */
    private String addrNameArea;

    /**
     * 検索条件_JIS府県コード
     * @generated
     */
    private String addrCodePref;

    /**
     * 検索条件_JIS市区町村コード
     * @generated
     */
    private String addrCodeCity;

    /**
     * 検索条件_武田府県コード
     * @generated
     */
    private String tkPrefCd;

    /**
     * 検索条件_武田市区郡コード
     * @generated
     */
    private String tkCityCd;
    /**
     * 検索条件_武田市区郡名
     * @generated
     */
    private String tkCityName;

    /**
     * 検索条件_JIS府県カナ
     * @generated
     */
    private String addrKanaPref;

    /**
     * 検索条件_JIS市区町村名カナ
     * @generated
     */
    private String addrKanaCity;

    /**
     * 検索条件_大字／町域名カナ
     * @generated
     */
    private String addrKanaArea;

    private String test;
    public MRdmPostKouho() {
        super("postKouho","selectPost");
    }

    /**
	 * MRdmPostKouho.javaseshonIdを設定
	 * @return seshonId
	 */
	public String getSeshonId() {
		return seshonId;
	}

	/**
	 * @param seshonId セットする seshonId
	 */
	public void setSeshonId(String seshonId) {
		this.seshonId = seshonId;
	}

	/**
	 * MRdmPostKouho.javapreScreenIdを設定
	 * @return preScreenId
	 */
	public String getPreScreenId() {
		return preScreenId;
	}

	/**
	 * @param preScreenId セットする preScreenId
	 */
	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

	/**
	 * MRdmPostKouho.javascreenIdを設定
	 * @return screenId
	 */
	public String getScreenId() {
		return screenId;
	}

	/**
	 * @param screenId セットする screenId
	 */
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	/**
	 * MRdmPostKouho.javainPostCodeを設定
	 * @return inPostCode
	 */
	public String getInPostCode() {
		return inPostCode;
	}

	/**
	 * @param inPostCode セットする inPostCode
	 */
	public void setInPostCode(String inPostCode) {
		this.inPostCode = inPostCode;
	}

	/**
	 * MRdmPostKouho.javapostCodeを設定
	 * @return postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode セットする postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * MRdmPostKouho.javaaddrNamePrefを設定
	 * @return addrNamePref
	 */
	public String getAddrNamePref() {
		return addrNamePref;
	}

	/**
	 * @param addrNamePref セットする addrNamePref
	 */
	public void setAddrNamePref(String addrNamePref) {
		this.addrNamePref = addrNamePref;
	}

	/**
	 * MRdmPostKouho.javaaddrNameCityを設定
	 * @return addrNameCity
	 */
	public String getAddrNameCity() {
		return addrNameCity;
	}

	/**
	 * @param addrNameCity セットする addrNameCity
	 */
	public void setAddrNameCity(String addrNameCity) {
		this.addrNameCity = addrNameCity;
	}

	/**
	 * MRdmPostKouho.javaaddrNameAreaを設定
	 * @return addrNameArea
	 */
	public String getAddrNameArea() {
		return addrNameArea;
	}

	/**
	 * @param addrNameArea セットする addrNameArea
	 */
	public void setAddrNameArea(String addrNameArea) {
		this.addrNameArea = addrNameArea;
	}

	/**
	 * MRdmPostKouho.javaaddrCodePrefを設定
	 * @return addrCodePref
	 */
	public String getAddrCodePref() {
		return addrCodePref;
	}

	/**
	 * @param addrCodePref セットする addrCodePref
	 */
	public void setAddrCodePref(String addrCodePref) {
		this.addrCodePref = addrCodePref;
	}

	/**
	 * MRdmPostKouho.javaaddrCodeCityを設定
	 * @return addrCodeCity
	 */
	public String getAddrCodeCity() {
		return addrCodeCity;
	}

	/**
	 * @param addrCodeCity セットする addrCodeCity
	 */
	public void setAddrCodeCity(String addrCodeCity) {
		this.addrCodeCity = addrCodeCity;
	}

	/**
	 * MRdmPostKouho.javatkPrefCdを設定
	 * @return tkPrefCd
	 */
	public String getTkPrefCd() {
		return tkPrefCd;
	}

	/**
	 * @param tkPrefCd セットする tkPrefCd
	 */
	public void setTkPrefCd(String tkPrefCd) {
		this.tkPrefCd = tkPrefCd;
	}

	/**
	 * MRdmPostKouho.javatkCityCdを設定
	 * @return tkCityCd
	 */
	public String getTkCityCd() {
		return tkCityCd;
	}

	/**
	 * @param tkCityCd セットする tkCityCd
	 */
	public void setTkCityCd(String tkCityCd) {
		this.tkCityCd = tkCityCd;
	}

	/**
	 * MRdmPostKouho.javatkCityNameを設定
	 * @return tkCityName
	 */
	public String getTkCityName() {
		return tkCityName;
	}

	/**
	 * @param tkCityName セットする tkCityName
	 */
	public void setTkCityName(String tkCityName) {
		this.tkCityName = tkCityName;
	}

	/**
	 * MRdmPostKouho.javaaddrKanaPrefを設定
	 * @return addrKanaPref
	 */
	public String getAddrKanaPref() {
		return addrKanaPref;
	}

	/**
	 * @param addrKanaPref セットする addrKanaPref
	 */
	public void setAddrKanaPref(String addrKanaPref) {
		this.addrKanaPref = addrKanaPref;
	}

	/**
	 * MRdmPostKouho.javaaddrKanaCityを設定
	 * @return addrKanaCity
	 */
	public String getAddrKanaCity() {
		return addrKanaCity;
	}

	/**
	 * @param addrKanaCity セットする addrKanaCity
	 */
	public void setAddrKanaCity(String addrKanaCity) {
		this.addrKanaCity = addrKanaCity;
	}

	/**
	 * MRdmPostKouho.javaaddrKanaAreaを設定
	 * @return addrKanaArea
	 */
	public String getAddrKanaArea() {
		return addrKanaArea;
	}

	/**
	 * @param addrKanaArea セットする addrKanaArea
	 */
	public void setAddrKanaArea(String addrKanaArea) {
		this.addrKanaArea = addrKanaArea;
	}

	/**
	 * MRdmPostKouho.javatestを設定
	 * @return test
	 */
	public String getTest() {
		return test;
	}

	/**
	 * @param test セットする test
	 */
	public void setTest(String test) {
		this.test = test;
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
	public void setInSelectKbn(String string) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
