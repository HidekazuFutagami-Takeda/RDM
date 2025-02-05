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
     * 入力_郵便番号
     * @generated
     */
    private String inPostCode;

    private String test;
    public MRdmPostKouho() {
        super("postKouho","selectPost");
    }

    /**
     * 遷移元画面ID
     * @generated
     */
    private String preScreenId;
    public String getPreScreenId() {
		return preScreenId;
	}
	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

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
    /**
     * 入力_セッションIDの取得
     * @return 入力_セッションID
     * @generated
     */
    public String getSeshonId() {
        return seshonId;
    }
    /**
     * 入力_セッションIDの設定
     * @param セッションID
     * @generated
     */
    public void setSeshonId(String seshonId) {
        this.seshonId = seshonId;
    }
    /**
     * 入力_スクリーンIDの取得
     * @return 入力_スクリーンID
     * @generated
     */
    public String getScreenId() {
        return screenId;
    }
    /**
     * 入力_スクリーンIDの設定
     * @param スクリーンID
     * @generated
     */
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }
    /**
     * 入力_郵便番号の取得
     * @return 入力_郵便番号
     * @generated
     */
    public String getInPostCode() {
        return inPostCode;
    }

    /**
     * 入力_郵便番号の設定
     * @param inInsNo 入力_郵便番号
     * @generated
     */
    public void setInPostCode(String inPostCode) {
        this.inPostCode = inPostCode;
    }
    /**
     * 検索条件_郵便番号の取得
     * @return 検索条件_郵便番号
     * @generated
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 検索条件_郵便番号の設定
     * @param 検索条件_郵便番号
     * @generated
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 検索条件_JIS府県名の取得
     * @return 検索条件_JIS府県名
     * @generated
     */
    public String getAddrNamePref() {
        return addrNamePref;
    }

    /**
     * 検索条件_JIS府県名の設定
     * @param  検索条件_JIS府県名
     * @generated
     */
    public void setAddrNamePref(String addrNamePref) {
        this.addrNamePref = addrNamePref;
    }

    /**
     * 検索条件_JIS市区町村名の取得
     * @return 検索条件_JIS市区町村名
     * @generated
     */
    public String getAddrNameCity() {
        return addrNameCity;
    }

    /**
     * 検索条件_JIS市区町村名の設定
     * @param 検索条件_JIS市区町村名
     * @generated
     */
    public void setAddrNameCity(String addrNameCity) {
        this.addrNameCity = addrNameCity;
    }

    /**
     * 検索条件_大字／町域名の取得
     * @return 検索条件_大字／町域名
     * @generated
     */
    public String getAddrNameArea() {
        return addrNameArea;
    }

    /**
     * 検索条件_大字／町域名の設定
     * @param  検索条件_大字／町域名
     * @generated
     */
    public void setAddrNameArea(String addrNameArea) {
        this.addrNameArea = addrNameArea;
    }

    /**
     * 検索条件_JIS府県コードの取得
     * @return 検索条件_JIS府県コード
     * @generated
     */
    public String getAddrCodePref() {
        return addrCodePref;
    }

    /**
     * 検索条件_JIS府県コードの設定
     * @param 検索条件_JIS府県コード
     * @generated
     */
    public void setAddrCodePref(String addrCodePref) {
        this.addrCodePref = addrCodePref;
    }

    /**
     * 検索条件_JIS市区町村コードの取得
     * @return 検索条件_JIS市区町村コード
     * @generated
     */
    public String getAddrCodeCity() {
        return addrCodeCity;
    }

    /**
     * 検索条件_JIS市区町村コードの設定
     * @param 検索条件_JIS市区町村コード
     * @generated
     */
    public void setAddrCodeCity(String addrCodeCity) {
        this.addrCodeCity = addrCodeCity;
    }

    /**
     * 検索条件_武田府県コードの取得
     * @return 検索条件_武田府県コード
     * @generated
     */
    public String getTkPrefCd() {
        return tkPrefCd;
    }

    /**
     * 検索条件_武田府県コードの設定
     * @param 検索条件_武田府県コード
     * @generated
     */
    public void setTkPrefCd(String tkPrefCd) {
        this.tkPrefCd = tkPrefCd;
    }

    /**
     * 検索条件_武田市区郡コードの取得
     * @return 検索条件_武田市区郡コード
     * @generated
     */
    public String getTkCityCd() {
        return tkCityCd;
    }

    /**
     * 検索条件_武田市区郡コードの設定
     * @param kensakuKana 検索条件_武田市区郡コード
     * @generated
     */
    public void setTkCityCd(String tkCityCd) {
        this.tkCityCd = tkCityCd;
    }
    /**
     * 検索条件_武田市区郡コードの取得
     * @return 検索条件_武田市区郡コード
     * @generated
     */
    public String getTkCityName() {
        return tkCityName;
    }

    /**
     * 検索条件_武田市区郡コードの設定
     * @param kensakuKana 検索条件_武田市区郡コード
     * @generated
     */
    public void setTkCityName(String tkCityName) {
        this.tkCityCd = tkCityName;
    }

    /**
     * 検索条件_JIS府県カナ
     * @return 検索条件_JIS府県カナ
     * @generated
     */
    public String getAddrKanaPref() {
        return addrKanaPref;
    }

    /**
     * 検索条件_JIS府県カナの設定
     * @param kensakuKana 検索条件_JIS府県カナ
     * @generated
     */
    public void setAddrKanaPref(String addrKanaPref) {
        this.addrKanaPref = addrKanaPref;
    }

    /**
     * 検索条件_JIS市区町村名カナの取得
     * @return 検索条件_JIS市区町村名カナ
     * @generated
     */
    public String getAddrKanaCity() {
        return addrKanaCity;
    }

    /**
     * 検索条件_JIS市区町村名カナの設定
     * @param 検索条件_JIS市区町村名カナ
     * @generated
     */
    public void setAddrKanaCity(String addrKanaCity) {
        this.addrKanaCity = addrKanaCity;
    }

    /**
     * 検索条件_大字／町域名カナの取得
     * @return 検索条件_大字／町域名カナ
     * @generated
     */
    public String getAddrKanaArea() {
        return addrKanaArea;
    }
    /**
     * 検索条件_大字／町域名カナの設定
     * @param 検索条件_大字／町域名カナ
     * @generated
     */
    public void setAddrKanaArea(String addrKanaArea) {
        this.addrKanaArea = addrKanaArea;
    }

    /**
     * システムコードの取得
     * @return システムコード
     * @generated
     */
    public String getTest() {
        return this.test;
    }

    /**
     * システムコードの設定
     * @param sysCd システムコード
     * @generated
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
