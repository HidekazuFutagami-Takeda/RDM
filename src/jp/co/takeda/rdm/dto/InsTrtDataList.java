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
public class InsTrtDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 領域
     * @generated
     */
    private String trtNm;

    /**
     * 所属
     * @generated
     */
    private String bumon;

    /**
     * 担当者
     * @generated
     */
    private String jgiName;

    /**
     * メールアドレス
     * @generated
     */
    private String jgiMailAddress;


	/**
     * 主副担当区分
     * @generated
     */
    private String value1Kanj;

    /**
     * コンストラクタ
     * @customizable
     */
    public InsTrtDataList() {
        // START UOC

        // END UOC
    }

	public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	public String getInsAbbrName() {
		return insAbbrName;
	}

	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

	public String getTrtNm() {
		return trtNm;
	}

	public void setTrtNm(String trtNm) {
		this.trtNm = trtNm;
	}

	public String getBumon() {
		return bumon;
	}

	public void setBumon(String bumon) {
		this.bumon = bumon;
	}

	public String getJgiName() {
		return jgiName;
	}

	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	public String getJgiMailAddress() {
		return jgiMailAddress;
	}

	public void setJgiMailAddress(String jgiMailAddress) {
		this.jgiMailAddress = jgiMailAddress;
	}

	public String getValue1Kanj() {
		return value1Kanj;
	}

	public void setValue1Kanj(String value1Kanj) {
		this.value1Kanj = value1Kanj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
}

