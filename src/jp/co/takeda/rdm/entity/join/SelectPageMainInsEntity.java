/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_HCP_MST
 * SQLID : selectPageMainIns
 */
public class SelectPageMainInsEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 領域別担当者検索_表示件数
     */
    private Integer CntHcp;

    /**
     * 検索条件_医薬支店C
     * @generated
     */
    private String kensakuBrCode;

    /**
     * 検索条件_医薬営業所C
     * @generated
     */
    private String kensakuDistCode;

    /**
     * 検索条件_申請者所属リージョン
     * @generated
     */
    private String kensakuReqBrCode;

    /**
     * 検索条件_申請者所属エリア
     * @generated
     */
    private String kensakuReqDistCode;

    /**
     * 検索条件_従業員番号
     * @generated
     */
    private String kensakuJgiNo;

    /**
     * 検索条件_申請者
     * @generated
     */
    private String kensakuReqJgiName;

    /**
     * 申請者組織
     * @generated
     */
    private String kensakuReqDist;

    /**
     * 検索条件_施設名（全角）
     * @generated
     */
    private String kensakuInsKanj;

    /**
     * 検索条件_施設名カナ(半角カナ)
     * @generated
     */
    private String kensakuInsKana;

    /**
     * 検索条件_施設固定C
     * @generated
     */
    private String kensakuInsNo;

    /**
     * 検索条件_領域コード
     * @generated
     */
    private String kensakuTrtCd;

    /**
     * 検索条件_ULTコード
     * @generated
     */
    private String kensakuUltInsNo;

    /**
     * 検索条件_経営主体
     * @generated
     */
    private String kensakuManageCd;

    /**
     * 検索条件_対象区分
     * @generated
     */
    private String kensakuHoInsType;

    /**
     * 検索条件_施設種別
     * @generated
     */
    private String kensakuInsSbt;

    /**
     * 検索条件_施設区分
     * @generated
     */
    private String kensakuPharmType;

    /**検索条件_電話番号(半角)
     * @generated
     */
    private String kensakuInsPhone;

    /**
     * 検索条件_郵便番号(半角)
     * @generated
     */
    private String kensakuInsPcode;

    /**
     * 検索条件_都道府県
     * @generated
     */
    private String kensakuAddrCodePref;

    /**
     * 検索条件_JIS市区町村
     * @generated
     */
    private String kensakuAddrCodeCity;

    /**
     * 検索条件_住所(全角)
     * @generated
     */
    private String kensakuInsAddr;

    /**
     * 検索条件_更新日(FROM)
     * @generated
     */
    private Date kensakuUpdMstFrom;

    /**
     * 検索条件_更新日(TO)
     * @generated
     */
    private Date kensakuUpdMstTo;

    /**
     * コンストラクタ
     */
    public SelectPageMainInsEntity() {
        super("m_rdm_hco_upd_hst_mst" , "selectPageMainIns");
    }

	/**
	 * SelectParamSelectHcpEntity.javaCntHcpを設定
	 * @return cntHcp
	 */
	public Integer getCntHcp() {
		return CntHcp;
	}

	/**
	 * @param cntHcp セットする cntHcp
	 */
	public void setCntHcp(Integer cntHcp) {
		CntHcp = cntHcp;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuBrCodeを設定
	 * @return kensakuBrCode
	 */
	public String getKensakuBrCode() {
		return kensakuBrCode;
	}

	/**
	 * @param kensakuBrCode セットする kensakuBrCode
	 */
	public void setKensakuBrCode(String kensakuBrCode) {
		this.kensakuBrCode = kensakuBrCode;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuDistCodeを設定
	 * @return kensakuDistCode
	 */
	public String getKensakuDistCode() {
		return kensakuDistCode;
	}

	/**
	 * @param kensakuDistCode セットする kensakuDistCode
	 */
	public void setKensakuDistCode(String kensakuDistCode) {
		this.kensakuDistCode = kensakuDistCode;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuReqBrCodeを設定
	 * @return kensakuReqBrCode
	 */
	public String getKensakuReqBrCode() {
		return kensakuReqBrCode;
	}

	/**
	 * @param kensakuReqBrCode セットする kensakuReqBrCode
	 */
	public void setKensakuReqBrCode(String kensakuReqBrCode) {
		this.kensakuReqBrCode = kensakuReqBrCode;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuReqDistCodeを設定
	 * @return kensakuReqDistCode
	 */
	public String getKensakuReqDistCode() {
		return kensakuReqDistCode;
	}

	/**
	 * @param kensakuReqDistCode セットする kensakuReqDistCode
	 */
	public void setKensakuReqDistCode(String kensakuReqDistCode) {
		this.kensakuReqDistCode = kensakuReqDistCode;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuJgiNoを設定
	 * @return kensakuJgiNo
	 */
	public String getKensakuJgiNo() {
		return kensakuJgiNo;
	}

	/**
	 * @param kensakuJgiNo セットする kensakuJgiNo
	 */
	public void setKensakuJgiNo(String kensakuJgiNo) {
		this.kensakuJgiNo = kensakuJgiNo;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuReqJgiNameを設定
	 * @return kensakuReqJgiName
	 */
	public String getKensakuReqJgiName() {
		return kensakuReqJgiName;
	}

	/**
	 * @param kensakuReqJgiName セットする kensakuReqJgiName
	 */
	public void setKensakuReqJgiName(String kensakuReqJgiName) {
		this.kensakuReqJgiName = kensakuReqJgiName;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuReqDistを設定
	 * @return kensakuReqDist
	 */
	public String getKensakuReqDist() {
		return kensakuReqDist;
	}

	/**
	 * @param kensakuReqDist セットする kensakuReqDist
	 */
	public void setKensakuReqDist(String kensakuReqDist) {
		this.kensakuReqDist = kensakuReqDist;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuInsKanjを設定
	 * @return kensakuInsKanj
	 */
	public String getKensakuInsKanj() {
		return kensakuInsKanj;
	}

	/**
	 * @param kensakuInsKanj セットする kensakuInsKanj
	 */
	public void setKensakuInsKanj(String kensakuInsKanj) {
		this.kensakuInsKanj = kensakuInsKanj;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuInsKanaを設定
	 * @return kensakuInsKana
	 */
	public String getKensakuInsKana() {
		return kensakuInsKana;
	}

	/**
	 * @param kensakuInsKana セットする kensakuInsKana
	 */
	public void setKensakuInsKana(String kensakuInsKana) {
		this.kensakuInsKana = kensakuInsKana;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuInsNoを設定
	 * @return kensakuInsNo
	 */
	public String getKensakuInsNo() {
		return kensakuInsNo;
	}

	/**
	 * @param kensakuInsNo セットする kensakuInsNo
	 */
	public void setKensakuInsNo(String kensakuInsNo) {
		this.kensakuInsNo = kensakuInsNo;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuTrtCdを設定
	 * @return kensakuTrtCd
	 */
	public String getKensakuTrtCd() {
		return kensakuTrtCd;
	}

	/**
	 * @param kensakuTrtCd セットする kensakuTrtCd
	 */
	public void setKensakuTrtCd(String kensakuTrtCd) {
		this.kensakuTrtCd = kensakuTrtCd;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuUltInsNoを設定
	 * @return kensakuUltInsNo
	 */
	public String getKensakuUltInsNo() {
		return kensakuUltInsNo;
	}

	/**
	 * @param kensakuUltInsNo セットする kensakuUltInsNo
	 */
	public void setKensakuUltInsNo(String kensakuUltInsNo) {
		this.kensakuUltInsNo = kensakuUltInsNo;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuManageCdを設定
	 * @return kensakuManageCd
	 */
	public String getKensakuManageCd() {
		return kensakuManageCd;
	}

	/**
	 * @param kensakuManageCd セットする kensakuManageCd
	 */
	public void setKensakuManageCd(String kensakuManageCd) {
		this.kensakuManageCd = kensakuManageCd;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuHoInsTypeを設定
	 * @return kensakuHoInsType
	 */
	public String getKensakuHoInsType() {
		return kensakuHoInsType;
	}

	/**
	 * @param kensakuHoInsType セットする kensakuHoInsType
	 */
	public void setKensakuHoInsType(String kensakuHoInsType) {
		this.kensakuHoInsType = kensakuHoInsType;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuInsSbtを設定
	 * @return kensakuInsSbt
	 */
	public String getKensakuInsSbt() {
		return kensakuInsSbt;
	}

	/**
	 * @param kensakuInsSbt セットする kensakuInsSbt
	 */
	public void setKensakuInsSbt(String kensakuInsSbt) {
		this.kensakuInsSbt = kensakuInsSbt;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuPharmTypeを設定
	 * @return kensakuPharmType
	 */
	public String getKensakuPharmType() {
		return kensakuPharmType;
	}

	/**
	 * @param kensakuPharmType セットする kensakuPharmType
	 */
	public void setKensakuPharmType(String kensakuPharmType) {
		this.kensakuPharmType = kensakuPharmType;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuInsPhoneを設定
	 * @return kensakuInsPhone
	 */
	public String getKensakuInsPhone() {
		return kensakuInsPhone;
	}

	/**
	 * @param kensakuInsPhone セットする kensakuInsPhone
	 */
	public void setKensakuInsPhone(String kensakuInsPhone) {
		this.kensakuInsPhone = kensakuInsPhone;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuInsPcodeを設定
	 * @return kensakuInsPcode
	 */
	public String getKensakuInsPcode() {
		return kensakuInsPcode;
	}

	/**
	 * @param kensakuInsPcode セットする kensakuInsPcode
	 */
	public void setKensakuInsPcode(String kensakuInsPcode) {
		this.kensakuInsPcode = kensakuInsPcode;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuAddrCodePrefを設定
	 * @return kensakuAddrCodePref
	 */
	public String getKensakuAddrCodePref() {
		return kensakuAddrCodePref;
	}

	/**
	 * @param kensakuAddrCodePref セットする kensakuAddrCodePref
	 */
	public void setKensakuAddrCodePref(String kensakuAddrCodePref) {
		this.kensakuAddrCodePref = kensakuAddrCodePref;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuAddrCodeCityを設定
	 * @return kensakuAddrCodeCity
	 */
	public String getKensakuAddrCodeCity() {
		return kensakuAddrCodeCity;
	}

	/**
	 * @param kensakuAddrCodeCity セットする kensakuAddrCodeCity
	 */
	public void setKensakuAddrCodeCity(String kensakuAddrCodeCity) {
		this.kensakuAddrCodeCity = kensakuAddrCodeCity;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuInsAddrを設定
	 * @return kensakuInsAddr
	 */
	public String getKensakuInsAddr() {
		return kensakuInsAddr;
	}

	/**
	 * @param kensakuInsAddr セットする kensakuInsAddr
	 */
	public void setKensakuInsAddr(String kensakuInsAddr) {
		this.kensakuInsAddr = kensakuInsAddr;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuUpdMstFromを設定
	 * @return kensakuUpdMstFrom
	 */
	public Date getKensakuUpdMstFrom() {
		return kensakuUpdMstFrom;
	}

	/**
	 * @param kensakuUpdMstFrom セットする kensakuUpdMstFrom
	 */
	public void setKensakuUpdMstFrom(Date kensakuUpdMstFrom) {
		this.kensakuUpdMstFrom = kensakuUpdMstFrom;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javakensakuUpdMstToを設定
	 * @return kensakuUpdMstTo
	 */
	public Date getKensakuUpdMstTo() {
		return kensakuUpdMstTo;
	}

	/**
	 * @param kensakuUpdMstTo セットする kensakuUpdMstTo
	 */
	public void setKensakuUpdMstTo(Date kensakuUpdMstTo) {
		this.kensakuUpdMstTo = kensakuUpdMstTo;
	}

	/**
	 * SelectPageHcoUpdHstEntity.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
