/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス 申請状況一覧
 * @generated
 */
public class HcoOyakoNextDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 適用日
     * @generated
     */
    private String tekiyoYmd;

    /**
     * アクション
     * @generated
     */
    private String action;

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
     * 住所
     * @generated
     */
    private String insAddr;

    /**
     * 親施設コード
     * @generated
     */
    private String mainInsNo;

    /**
     * コンストラクタ
     * @customizable
     */
    public HcoOyakoNextDataList() {
        // START UOC

        // END UOC
    }

	/**
	 * HcoOyakoNextDataList.javatekiyoYmdを設定
	 * @return tekiyoYmd
	 */
	public String getTekiyoYmd() {
		return tekiyoYmd;
	}

	/**
	 * @param tekiyoYmd セットする tekiyoYmd
	 */
	public void setTekiyoYmd(String tekiyoYmd) {
		this.tekiyoYmd = tekiyoYmd;
	}

	/**
	 * HcoOyakoNextDataList.javaactionを設定
	 * @return action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action セットする action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * HcoOyakoNextDataList.javatrtCdを設定
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
	 * HcoOyakoNextDataList.javatrtNmを設定
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
	 * HcoOyakoNextDataList.javahinGCdを設定
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
	 * HcoOyakoNextDataList.javahinGNmを設定
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
	 * HcoOyakoNextDataList.javainsAbbrNameを設定
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
	 * HcoOyakoNextDataList.javainsAddrを設定
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
	 * HcoOyakoNextDataList.javamainInsNoを設定
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

