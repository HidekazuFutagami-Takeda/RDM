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
public class MainInsDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 更新日
     * @generated
     */
    private String updShaYmd;


    /**
     * 申請ID
     * @generated
     */
    private String reqId;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 親施設コード
     * @generated
     */
    private String mainInsNo;

    /**
     * 対象区分更新フラグ
     * @generated
     */
    private String hoInsTypeUpdFlg;

    /**
     * 施設略式漢字名更新フラグ
     * @generated
     */
    private String insAbbrNameUpdFlg;

    /**
     * 親施設コード更新フラグ
     * @generated
     */
    private String mainInsNoUpdFlg;

    /**
     * 親施設名更新フラグ
     * @generated
     */
    private String mainInsNmUpdFlg;

    /**
     * 親施設名
     * @generated
     */
    private String mainInsNm;

    /**
     * 領域名（親子）
     * @generated
     */
    private String trtNm;

    /**
     * 申請者氏名
     * @generated
     */
    private String reqJgiName;

    /**
     * 承認者氏名
     * @generated
     */
    private String aprShaId;

    /**
     * 申請者所属エリア
     * @generated
     */
    private String reqDistCode;

    /**
     * 申請者所属
     * @generated
     */
    private String reqShz;

    /**
     * 承認者所属
     * @generated
     */
    private String aprShz;

    /**
     * 削除フラグ更新フラグ
     * @generated
     */
    private String delFlgUpdFlg;

    /**
     * レコード件数
     * @generated
     */
    private Integer recCnt;

    /**
     * コンストラクタ
     * @customizable
     */
    public MainInsDataList() {
        // START UOC

        // END UOC
    }

	public String getReqJgiName() {
		return reqJgiName;
	}

	public void setReqJgiName(String reqJgiName) {
		this.reqJgiName = reqJgiName;
	}

	public String getAprShaId() {
		return aprShaId;
	}

	public void setAprShaId(String aprShaId) {
		this.aprShaId = aprShaId;
	}

	public String getMainInsNo() {
		return mainInsNo;
	}

	public void setMainInsNo(String mainInsNo) {
		this.mainInsNo = mainInsNo;
	}

	public String getMainInsNm() {
		return mainInsNm;
	}

	/**
	 * MainInsDataList.javahoInsTypeUpdFlgを設定
	 * @return hoInsTypeUpdFlg
	 */
	public String getHoInsTypeUpdFlg() {
		return hoInsTypeUpdFlg;
	}

	/**
	 * @param hoInsTypeUpdFlg セットする hoInsTypeUpdFlg
	 */
	public void setHoInsTypeUpdFlg(String hoInsTypeUpdFlg) {
		this.hoInsTypeUpdFlg = hoInsTypeUpdFlg;
	}

	/**
	 * MainInsDataList.javainsAbbrNameUpdFlgを設定
	 * @return insAbbrNameUpdFlg
	 */
	public String getInsAbbrNameUpdFlg() {
		return insAbbrNameUpdFlg;
	}

	/**
	 * @param insAbbrNameUpdFlg セットする insAbbrNameUpdFlg
	 */
	public void setInsAbbrNameUpdFlg(String insAbbrNameUpdFlg) {
		this.insAbbrNameUpdFlg = insAbbrNameUpdFlg;
	}

	/**
	 * MainInsDataList.javamainInsNoUpdFlgを設定
	 * @return mainInsNoUpdFlg
	 */
	public String getMainInsNoUpdFlg() {
		return mainInsNoUpdFlg;
	}

	/**
	 * @param mainInsNoUpdFlg セットする mainInsNoUpdFlg
	 */
	public void setMainInsNoUpdFlg(String mainInsNoUpdFlg) {
		this.mainInsNoUpdFlg = mainInsNoUpdFlg;
	}

	/**
	 * MainInsDataList.javamainInsNmUpdFlgを設定
	 * @return mainInsNmUpdFlg
	 */
	public String getMainInsNmUpdFlg() {
		return mainInsNmUpdFlg;
	}

	/**
	 * @param mainInsNmUpdFlg セットする mainInsNmUpdFlg
	 */
	public void setMainInsNmUpdFlg(String mainInsNmUpdFlg) {
		this.mainInsNmUpdFlg = mainInsNmUpdFlg;
	}

	public void setMainInsNm(String mainInsNm) {
		this.mainInsNm = mainInsNm;
	}

	public String getTrtNm() {
		return trtNm;
	}

	public void setTrtNm(String trtNm) {
		this.trtNm = trtNm;
	}

	public String getUpdShaYmd() {
		return updShaYmd;
	}


	public void setUpdShaYmd(String updShaYmd) {
		this.updShaYmd = updShaYmd;
	}


	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getHoInsType() {
		return hoInsType;
	}



	public void setHoInsType(String hoInsType) {
		this.hoInsType = hoInsType;
	}



	public String getInsAbbrName() {
		return insAbbrName;
	}



	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}



	public String getReqDistCode() {
		return reqDistCode;
	}



	public void setReqDistCode(String reqDistCode) {
		this.reqDistCode = reqDistCode;
	}



	/**
	 * MainInsDataList.javareqShzを設定
	 * @return reqShz
	 */
	public String getReqShz() {
		return reqShz;
	}

	/**
	 * @param reqShz セットする reqShz
	 */
	public void setReqShz(String reqShz) {
		this.reqShz = reqShz;
	}

	public String getAprShz() {
		return aprShz;
	}



	public void setAprShz(String aprShz) {
		this.aprShz = aprShz;
	}



	public Integer getRecCnt() {
		return recCnt;
	}



	public void setRecCnt(Integer recCnt) {
		this.recCnt = recCnt;
	}



	public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}


	public String getDelFlgUpdFlg() {
		return delFlgUpdFlg;
	}

	public void setDelFlgUpdFlg(String delFlgUpdFlg) {
		this.delFlgUpdFlg = delFlgUpdFlg;
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

