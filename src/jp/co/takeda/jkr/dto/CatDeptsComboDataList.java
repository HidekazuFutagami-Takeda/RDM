/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス
 * @generated
 */
public class CatDeptsComboDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 選択
     * @generated
     */
    private boolean checkers;

    /**
     * 所属部科漢字名称
     * @generated
     */
    private String kanaName;

    /**
     * 所属部科カナ名称
     * @generated
     */
    private String kanjName;

    private String deptKj;

    private String deptKn;
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
     * 所属部科コード
     * @generated
     */
    private String deptCode;

    /**
     * コンストラクタ
     * @customizable
     */
    public CatDeptsComboDataList() {
        // START UOC

        // END UOC
    }

    // START UOC

    // END UOC

     /**
     * 選択の取得
     * @return 選択
     * @generated
     */
    public boolean getCheckers() {
        return checkers;
    }

    /**
     * 選択の設定
     * @param checkers 選択
     * @generated
     */
    public void setCheckers(boolean checkers) {
        this.checkers = checkers;
    }

     /**
     * 所属部科漢字名称の取得
     * @return 所属部科漢字名称
     * @generated
     */
    public String getKanaName() {
        return kanaName;
    }

    /**
     * 所属部科漢字名称の設定
     * @param kanaName 所属部科漢字名称
     * @generated
     */
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

     /**
     * 所属部科カナ名称の取得
     * @return 所属部科カナ名称
     * @generated
     */
    public String getKanjName() {
        return kanjName;
    }

    /**
     * 所属部科カナ名称の設定
     * @param kanjName 所属部科カナ名称
     * @generated
     */
    public void setKanjName(String kanjName) {
        this.kanjName = kanjName;
    }

     /**
     * 所属部科コードの取得
     * @return 所属部科コード
     * @generated
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 所属部科コードの設定
     * @param deptCode 所属部科コード
     * @generated
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    /**
    * 所属部科漢字名称の取得
    * @return 所属部科カナ名称
    * @generated
    */
   public String getDeptKj() {
       return deptKj;
   }
	public void setDeptKj(String deptKj) {
		// TODO 自動生成されたメソッド・スタブ
		this.deptKj = deptKj;
	}
	   public String getDeptKn() {
	       return deptKn;
	   }

	public void setDeptKn(String deptKn) {
		// TODO 自動生成されたメソッド・スタブ
		this.deptKn = deptKn;
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
     * 検索条件_武田市区郡名の取得
     * @return 検索条件_武田市区郡名
     * @generated
     */
    public String getTkCityName() {
        return tkCityName;
    }

    /**
     * 検索条件_武田市区郡名の設定
     * @param kensakuKana 検索条件_武田市区郡名
     * @generated
     */
    public void setTkCityName(String tkCityName) {
        this.tkCityName = tkCityName;
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

}

