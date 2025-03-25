/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.entity.SRdmJkrSosAddrEntiry;


/**
 * DTOクラス_市区町村_組織担当地区情報
 * @generated
 */
public class JkrCityNameDataList extends SRdmJkrSosAddrEntiry implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * JIS府県コード
     * @generated
     */
    private String addrCodePref;

    /**
     * 武田市区町村コード
     * @generated
     */
    private String tkCityCd;

    /**
     * JIS府県名
     * @generated
     */
    private String addrNamePref;

    /**
     * 武田市区町村名
     * @generated
     */
    private String tkCityName;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * 組織C
     * @generated
     */
    private String sosCd;

    /**
     * 最終更新者
     * @generated
     */
    private String upJgiNo;

    /**
     * 登録日
     * @generated
     */
    private String isDate;

    /**
     * 更新日
     * @generated
     */
    private String upDate;

    /**
     * 更新画面ID
     * @generated
     */
    private String upScrnId;

    /**
     * 更新機能ID
     * @generated
     */
    private String upFuncId;

    /**
     * コンストラクタ
     * @customizable
     */
    public JkrCityNameDataList() {
        // START UOC

        // END UOC
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAddrCodePref() {
		return addrCodePref;
	}

	public void setAddrCodePref(String addrCodePref) {
		this.addrCodePref = addrCodePref;
	}

	public String getTkCityCd() {
		return tkCityCd;
	}

	public void setTkCityCd(String tkCityCd) {
		this.tkCityCd = tkCityCd;
	}

	public String getAddrNamePref() {
		return addrNamePref;
	}

	public void setAddrNamePref(String addrNamePref) {
		this.addrNamePref = addrNamePref;
	}

	public String getTkCityName() {
		return tkCityName;
	}

	public void setTkCityName(String tkCityName) {
		this.tkCityName = tkCityName;
	}

	public String getTrtCd() {
		return trtCd;
	}

	public void setTrtCd(String trtCd) {
		this.trtCd = trtCd;
	}

	public String getSosCd() {
		return sosCd;
	}

	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

	public String getUpJgiNo() {
		return upJgiNo;
	}

	public void setUpJgiNo(String upJgiNo) {
		this.upJgiNo = upJgiNo;
	}

	public String getIsDate() {
		return isDate;
	}

	public void setIsDate(String isDate) {
		this.isDate = isDate;
	}

	public String getUpDate() {
		return upDate;
	}

	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}

	public String getUpScrnId() {
		return upScrnId;
	}

	public void setUpScrnId(String upScrnId) {
		this.upScrnId = upScrnId;
	}

	public String getUpFuncId() {
		return upFuncId;
	}

	public void setUpFuncId(String upFuncId) {
		this.upFuncId = upFuncId;
	}

}

