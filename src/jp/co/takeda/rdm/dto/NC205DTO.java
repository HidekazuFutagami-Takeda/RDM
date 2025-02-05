/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseDTO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * DTOクラス
 * @generated
 */
public class NC205DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NC205 = "NC205";

    /**
     * 画面ID
     * @generated
     */
    private String screenId;
    public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	private String backScreenId;
	public String getBackScreenId() {
		return backScreenId;
	}

	public void setBackScreenId(String backScreenId) {
		this.backScreenId = backScreenId;
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
     * セッションID
     * @generated
     */
    private String seshonId;


	/**
     * 親画面コールバックメソッド名
     * @generated
     */
    private String callBack;

	/**
     * 親画面名
     * @generated
     */
    private String winVarName;

	/**
     * 呼び出し元のClear処理メソッド名
     * @generated
     */
    private String parentClearProc;

    /**
     * @generated
     */
    private String test;



	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	/**
     * @generated
     */
    private List<CatDeptsComboDataList> catDeptsComboDataList = new ArrayList<CatDeptsComboDataList>();

	public Object setPostCode;

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC205DTO() {
        setForward(NC205);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNC205(String screenId){
        this.NC205 = screenId;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNC205(){
        return NC205;
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
	/**
     * 親画面コールバックメソッド名の取得
     * @return 親画面コールバックメソッド名
     * @generated
     */
    public String getCallBack() {
        return callBack;
    }

	/**
     * 親画面コールバックメソッド名の設定
     * @param callBack 親画面コールバックメソッド名
     * @generated
     */
    public void setCallBack(String callBack) {
        this.callBack = callBack;
    }
	/**
     * 親画面コールバックメソッド名の取得
     * @return 親画面コールバックメソッド名
     * @generated
     */
    public String getSeshonId() {
        return seshonId;
    }

	/**
     * 親画面コールバックメソッド名の設定
     * @param callBack 親画面コールバックメソッド名
     * @generated
     */
    public void setSeshonId(String seshonId) {
        this.seshonId = seshonId;
    }

	/**
     * 親画面名の取得
     * @return 親画面名
     * @generated
     */
    public String getWinVarName() {
        return winVarName;
    }

	/**
     * 親画面名の設定
     * @param winVarName 親画面名
     * @generated
     */
    public void setWinVarName(String winVarName) {
        this.winVarName = winVarName;
    }

	/**
     * 呼び出し元のClear処理メソッド名の取得
     * @return 呼び出し元のClear処理メソッド名
     * @generated
     */
    public String getParentClearProc() {
        return parentClearProc;
    }

	/**
     * 呼び出し元のClear処理メソッド名の設定
     * @param parentClearProc 呼び出し元のClear処理メソッド名
     * @generated
     */
    public void setParentClearProc(String parentClearProc) {
        this.parentClearProc = parentClearProc;
    }
    /**
     * 繰返リストの取得
     * @return 繰返リスト
     * @generated
     */
    public List<CatDeptsComboDataList> getCatDeptsComboDataList() {
        return catDeptsComboDataList;
    }

    /**
     * 繰返リストの設定
     * @param catDeptsComboDataList 繰返リスト
     * @generated
     */
    public void setCatDeptsComboDataList(List<CatDeptsComboDataList> catDeptsComboDataList) {
        this.catDeptsComboDataList = catDeptsComboDataList;
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
