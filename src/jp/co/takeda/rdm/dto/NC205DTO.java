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

	private String backScreenId;

    /**
     * 遷移元画面ID
     * @generated
     */
	private String preScreenId;

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
	 * NC205DTO.javaNC205を設定
	 * @return nC205
	 */
	public String getNC205() {
		return NC205;
	}

	/**
	 * @param nC205 セットする nC205
	 */
	public void setNC205(String nC205) {
		NC205 = nC205;
	}

	/**
	 * NC205DTO.javascreenIdを設定
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
	 * NC205DTO.javabackScreenIdを設定
	 * @return backScreenId
	 */
	public String getBackScreenId() {
		return backScreenId;
	}

	/**
	 * @param backScreenId セットする backScreenId
	 */
	public void setBackScreenId(String backScreenId) {
		this.backScreenId = backScreenId;
	}

	/**
	 * NC205DTO.javapreScreenIdを設定
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
	 * NC205DTO.javapostCodeを設定
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
	 * NC205DTO.javaaddrNamePrefを設定
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
	 * NC205DTO.javaaddrNameCityを設定
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
	 * NC205DTO.javaaddrNameAreaを設定
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
	 * NC205DTO.javaaddrCodePrefを設定
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
	 * NC205DTO.javaaddrCodeCityを設定
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
	 * NC205DTO.javatkPrefCdを設定
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
	 * NC205DTO.javatkCityCdを設定
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
	 * NC205DTO.javatkCityNameを設定
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
	 * NC205DTO.javaaddrKanaPrefを設定
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
	 * NC205DTO.javaaddrKanaCityを設定
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
	 * NC205DTO.javaaddrKanaAreaを設定
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
	 * NC205DTO.javaseshonIdを設定
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
	 * NC205DTO.javacallBackを設定
	 * @return callBack
	 */
	public String getCallBack() {
		return callBack;
	}

	/**
	 * @param callBack セットする callBack
	 */
	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}

	/**
	 * NC205DTO.javawinVarNameを設定
	 * @return winVarName
	 */
	public String getWinVarName() {
		return winVarName;
	}

	/**
	 * @param winVarName セットする winVarName
	 */
	public void setWinVarName(String winVarName) {
		this.winVarName = winVarName;
	}

	/**
	 * NC205DTO.javaparentClearProcを設定
	 * @return parentClearProc
	 */
	public String getParentClearProc() {
		return parentClearProc;
	}

	/**
	 * @param parentClearProc セットする parentClearProc
	 */
	public void setParentClearProc(String parentClearProc) {
		this.parentClearProc = parentClearProc;
	}

	/**
	 * NC205DTO.javatestを設定
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
	 * NC205DTO.javacatDeptsComboDataListを設定
	 * @return catDeptsComboDataList
	 */
	public List<CatDeptsComboDataList> getCatDeptsComboDataList() {
		return catDeptsComboDataList;
	}

	/**
	 * @param catDeptsComboDataList セットする catDeptsComboDataList
	 */
	public void setCatDeptsComboDataList(List<CatDeptsComboDataList> catDeptsComboDataList) {
		this.catDeptsComboDataList = catDeptsComboDataList;
	}

	/**
	 * NC205DTO.javasetPostCodeを設定
	 * @return setPostCode
	 */
	public Object getSetPostCode() {
		return setPostCode;
	}

	/**
	 * @param setPostCode セットする setPostCode
	 */
	public void setSetPostCode(Object setPostCode) {
		this.setPostCode = setPostCode;
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
