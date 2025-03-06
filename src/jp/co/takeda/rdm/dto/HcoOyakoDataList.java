/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス 当期親施設情報
 * @generated
 */
public class HcoOyakoDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 編集処理フラグ
     * @generated
     */
    private String editFlg;

    /**
     * 削除処理フラグ
     * @generated
     */
    private String deleteFlg;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * 領域名
     * @generated
     */
    private String trtNm;

    /**
     * 品目グループコード
     * @generated
     */
    private String hinGCd;

    /**
     * 品目グループ名
     * @generated
     */
    private String hinGNm;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * 住所
     * @generated
     */
    private String insAddr;

    /**
     * 従業員番号
     * @generated
     */
    private String jgiNo;

    /**
     * 従業員名
     * @generated
     */
    private String jgiName;

    /**
     * 親施設コード
     * @generated
     */
    private String mainInsNo;

    /**
     * コンストラクタ
     * @customizable
     */
    public HcoOyakoDataList() {
        // START UOC

        // END UOC
    }

	/**
	 * HcoOyakoDataList.javaeditFlgを設定
	 * @return editFlg
	 */
	public String getEditFlg() {
		return editFlg;
	}

	/**
	 * @param editFlg セットする editFlg
	 */
	public void setEditFlg(String editFlg) {
		this.editFlg = editFlg;
	}

	/**
	 * HcoOyakoDataList.javadeleteFlgを設定
	 * @return deleteFlg
	 */
	public String getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * @param deleteFlg セットする deleteFlg
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * HcoOyakoDataList.javatrtCdを設定
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
	 * HcoOyakoDataList.javatrtNmを設定
	 * @return trtNm
	 */
	public String getTrtNm() {
		return trtNm;
	}

	/**
	 * @param trtNm セットする trtNm
	 */
	public void setTrtNm(String trtNm) {
		this.trtNm = trtNm;
	}

	/**
	 * HcoOyakoDataList.javahinGCdを設定
	 * @return hinGCd
	 */
	public String getHinGCd() {
		return hinGCd;
	}

	/**
	 * @param hinGCd セットする hinGCd
	 */
	public void setHinGCd(String hinGCd) {
		this.hinGCd = hinGCd;
	}

	/**
	 * HcoOyakoDataList.javahinGNmを設定
	 * @return hinGNm
	 */
	public String getHinGNm() {
		return hinGNm;
	}

	/**
	 * @param hinGNm セットする hinGNm
	 */
	public void setHinGNm(String hinGNm) {
		this.hinGNm = hinGNm;
	}

	/**
	 * HcoOyakoDataList.javainsAbbrNameを設定
	 * @return insAbbrName
	 */
	public String getInsAbbrName() {
		return insAbbrName;
	}

	/**
	 * @param insAbbrName セットする insAbbrName
	 */
	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

	/**
	 * HcoOyakoDataList.javahoInsTypeを設定
	 * @return hoInsType
	 */
	public String getHoInsType() {
		return hoInsType;
	}

	/**
	 * @param hoInsType セットする hoInsType
	 */
	public void setHoInsType(String hoInsType) {
		this.hoInsType = hoInsType;
	}

	/**
	 * HcoOyakoDataList.javainsAddrを設定
	 * @return insAddr
	 */
	public String getInsAddr() {
		return insAddr;
	}

	/**
	 * @param insAddr セットする insAddr
	 */
	public void setInsAddr(String insAddr) {
		this.insAddr = insAddr;
	}

	/**
	 * HcoOyakoDataList.javajgiNoを設定
	 * @return jgiNo
	 */
	public String getJgiNo() {
		return jgiNo;
	}

	/**
	 * @param jgiNo セットする jgiNo
	 */
	public void setJgiNo(String jgiNo) {
		this.jgiNo = jgiNo;
	}

	/**
	 * HcoOyakoDataList.javajgiNameを設定
	 * @return jgiName
	 */
	public String getJgiName() {
		return jgiName;
	}

	/**
	 * @param jgiName セットする jgiName
	 */
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	/**
	 * HcoOyakoDataList.javamainInsNoを設定
	 * @return mainInsNo
	 */
	public String getMainInsNo() {
		return mainInsNo;
	}

	/**
	 * @param mainInsNo セットする mainInsNo
	 */
	public void setMainInsNo(String mainInsNo) {
		this.mainInsNo = mainInsNo;
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

