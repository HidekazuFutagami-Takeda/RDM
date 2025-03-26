/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseDTO;

/**
 * DTOクラス
 * @generated
 */
public class NC208DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NC208 = "NC208";

    /**
     * 施設固定コード(親画面から)
     * @generated
     */
    private String insNoKakusi;

    /**
     * 施設固定C
     * @generated
     */
    private String insNo;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 検索条件_施設略式漢字名
     * @generated
     */
    private String kensakuAbbrName;

    /**
     * 検索条件_所属
     * @generated
     */
    private String kensakuBumon;

    /**
     * 検索条件_領域
     * @generated
     */
    private String kensakuTrtNm;

    /**
     * 検索条件_担当者
     * @generated
     */
    private String kensakuJgiName;

    /**
     * 検索条件_メールアドレス
     * @generated
     */
    private String kensakuMailAddress;

    /**
     * 検索条件_主副担当区分
     * @generated
     */
    private String kensakuValue1;

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
     * 親画面施設固定コード
     * @generated
     */
    private String paramInsNo;

    /**
     * @generated
     */
    private List<InsTrtDataList> insTrtDataList = new ArrayList<InsTrtDataList>();

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC208DTO() {
        setForward(NC208);
    }

    // START UOC

    // END UOC

    /**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
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

	public String getNC208() {
		return NC208;
	}

	public void setNC208(String nC208) {
		NC208 = nC208;
	}

	public String getKensakuAbbrName() {
		return kensakuAbbrName;
	}

	public void setKensakuAbbrName(String kensakuAbbrName) {
		this.kensakuAbbrName = kensakuAbbrName;
	}

	public String getKensakuBumon() {
		return kensakuBumon;
	}

	public void setKensakuBumon(String kensakuBumon) {
		this.kensakuBumon = kensakuBumon;
	}

	public String getKensakuTrtNm() {
		return kensakuTrtNm;
	}

	public void setKensakuTrtNm(String kensakuTrtNm) {
		this.kensakuTrtNm = kensakuTrtNm;
	}

	public String getKensakuJgiName() {
		return kensakuJgiName;
	}

	public void setKensakuJgiName(String kensakuJgiName) {
		this.kensakuJgiName = kensakuJgiName;
	}

	public String getKensakuMailAddress() {
		return kensakuMailAddress;
	}

	public void setKensakuMailAddress(String kensakuMailAddress) {
		this.kensakuMailAddress = kensakuMailAddress;
	}

	public String getKensakuValue1() {
		return kensakuValue1;
	}

	public void setKensakuValue1(String kensakuValue1) {
		this.kensakuValue1 = kensakuValue1;
	}

	public String getCallBack() {
		return callBack;
	}

	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}

	public String getWinVarName() {
		return winVarName;
	}

	public void setWinVarName(String winVarName) {
		this.winVarName = winVarName;
	}

	public String getParamInsNo() {
		return paramInsNo;
	}

	public void setParamInsNo(String paramInsNo) {
		this.paramInsNo = paramInsNo;
	}

	public List<InsTrtDataList> getInsTrtDataList() {
		return insTrtDataList;
	}

	public void setInsTrtDataList(List<InsTrtDataList> insTrtDataList) {
		this.insTrtDataList = insTrtDataList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * NC208DTO.javainsNoKakusiを設定
	 * @return insNoKakusi
	 */
	public String getInsNoKakusi() {
		return insNoKakusi;
	}

	/**
	 * @param insNoKakusi セットする insNoKakusi
	 */
	public void setInsNoKakusi(String insNoKakusi) {
		this.insNoKakusi = insNoKakusi;
	}
}
