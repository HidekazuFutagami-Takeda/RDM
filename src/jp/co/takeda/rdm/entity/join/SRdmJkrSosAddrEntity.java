/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : S_RDM_JKR_SOS_ADDR
 * テーブル論理名 : 組織担当地区情報
 * @generated
 */
public class SRdmJkrSosAddrEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @generated
     */
    private String addrCodePref;

	/**
	 *
	 * @generated
	 */
	private String tkCityCd;

	/**
	 *
	 * @generated
	 */
	private String addrNamePref;

	/**
	 *
	 * @generated
	 */
	private String tkCityName;

	/**
	 *
	 * @generated
	 */
	private String trtCd;

	/**
	 *
	 * @generated
	 */
	private String sosCd;

	/**
	 *
	 * @generated
	 */
	private String upJgiNo;

	/**
	 *
	 * @generated
	 */
	private String isDate;

	/**
	 *
	 * @generated
	 */
	private String upDate;

	/**
	 *
	 * @generated
	 */
	private String upScrnId;

	/**
	 *
	 * @generated
	 */
	private String upFuncId;

    /**
     * コンストラクタ
     * @generated
     */
    public SRdmJkrSosAddrEntity() {
        super("s_rdm_jkr_sos_addr");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public SRdmJkrSosAddrEntity(String sqlId) {
        super("s_rdm_jkr_sos_addr", sqlId);
    }

	/**
	 * SRdmJkrSosAddrEntity.javaaddrCodePrefを設定
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
	 * SRdmJkrSosAddrEntity.javatkCityCdを設定
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
	 * SRdmJkrSosAddrEntity.javaaddrNamePrefを設定
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
	 * SRdmJkrSosAddrEntity.javatkCityNameを設定
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
	 * SRdmJkrSosAddrEntity.javatrtCdを設定
	 * @return trtCd
	 */
	public String getTrtCd() {
		return trtCd;
	}

	/**
	 * @param trtCd セットする trtCd
	 */
	public void setTrtCd(String trtCd) {
		this.trtCd = trtCd;
	}

	/**
	 * SRdmJkrSosAddrEntity.javasosCdを設定
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
	 * SRdmJkrSosAddrEntity.javaupJgiNoを設定
	 * @return upJgiNo
	 */
	public String getUpJgiNo() {
		return upJgiNo;
	}

	/**
	 * @param upJgiNo セットする upJgiNo
	 */
	public void setUpJgiNo(String upJgiNo) {
		this.upJgiNo = upJgiNo;
	}

	/**
	 * SRdmJkrSosAddrEntity.javaisDateを設定
	 * @return isDate
	 */
	public String getIsDate() {
		return isDate;
	}

	/**
	 * @param isDate セットする isDate
	 */
	public void setIsDate(String isDate) {
		this.isDate = isDate;
	}

	/**
	 * SRdmJkrSosAddrEntity.javaupDateを設定
	 * @return upDate
	 */
	public String getUpDate() {
		return upDate;
	}

	/**
	 * @param upDate セットする upDate
	 */
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}

	/**
	 * SRdmJkrSosAddrEntity.javaupScrnIdを設定
	 * @return upScrnId
	 */
	public String getUpScrnId() {
		return upScrnId;
	}

	/**
	 * @param upScrnId セットする upScrnId
	 */
	public void setUpScrnId(String upScrnId) {
		this.upScrnId = upScrnId;
	}

	/**
	 * SRdmJkrSosAddrEntity.javaupFuncIdを設定
	 * @return upFuncId
	 */
	public String getUpFuncId() {
		return upFuncId;
	}

	/**
	 * @param upFuncId セットする upFuncId
	 */
	public void setUpFuncId(String upFuncId) {
		this.upFuncId = upFuncId;
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
