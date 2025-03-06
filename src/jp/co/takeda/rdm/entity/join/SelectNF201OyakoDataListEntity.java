/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_HCO_OYAKO
 * SQLID : selectNF201TkdDataList, selectNF201TrtDataList
 * @generated
 */
public class SelectNF201OyakoDataListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_施設固定コード(パラメータ1)
     * @generated
     */
    private String inInsNo;

    /**
     * パラメタ情報(親子紐づけ(来期)メニュースイッチ)
     * @generated
     */
    private String ntValue;

    /**
     * パラメタ情報(施設メニュースイッチ)．値(左から2桁目）
     * @generated
     */
    private String facValue;

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
     * @generated
     */
    public SelectNF201OyakoDataListEntity() {
        super("m_rdm_hco_oyako" , "selectNF201TkdDataList");
    }

	/**
	 * SelectNF201OyakoDataListEntity.javainInsNoを設定
	 * @return inInsNo
	 */
	public String getInInsNo() {
		return inInsNo;
	}

	/**
	 * @param inInsNo セットする inInsNo
	 */
	public void setInInsNo(String inInsNo) {
		this.inInsNo = inInsNo;
	}

	/**
	 * SelectNF201OyakoDataListEntity.javantValueを設定
	 * @return ntValue
	 */
	public String getNtValue() {
		return ntValue;
	}

	/**
	 * @param ntValue セットする ntValue
	 */
	public void setNtValue(String ntValue) {
		this.ntValue = ntValue;
	}

	/**
	 * SelectNF201OyakoDataListEntity.javafacValueを設定
	 * @return facValue
	 */
	public String getFacValue() {
		return facValue;
	}

	/**
	 * @param facValue セットする facValue
	 */
	public void setFacValue(String facValue) {
		this.facValue = facValue;
	}

	/**
	 * SelectNF201OyakoDataListEntity.javatrtCdを設定
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
	 * SelectNF201OyakoDataListEntity.javatrtNmを設定
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
	 * SelectNF201OyakoDataListEntity.javahinGCdを設定
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
	 * SelectNF201OyakoDataListEntity.javahinGNmを設定
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
	 * SelectNF201OyakoDataListEntity.javainsAbbrNameを設定
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
	 * SelectNF201OyakoDataListEntity.javahoInsTypeを設定
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
	 * SelectNF201OyakoDataListEntity.javainsAddrを設定
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
	 * SelectNF201OyakoDataListEntity.javajgiNoを設定
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
	 * SelectNF201OyakoDataListEntity.javajgiNameを設定
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
	 * SelectNF201OyakoDataListEntity.javamainInsNoを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
