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
 * テーブル物理名 : T_RDM_HCO_UPD_HST
 * SQLID : selectHcoUpdHstList
 * @generated
 */
public class SelectMainInsListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_SELECT区分 (パラメータ1)
     * @generated
     */
    private Integer inSelectKbn;

    /**
     * Offset値
     * @generated
     */
    private Integer inOffset;

    /**
     * Limit値
     * @generated
     */
    private Integer inLimit;

    /**
     * 変換系_値
     * @generated
     */
    private String searchHenkan;

    /**
     * 変換系_区分
     * @generated
     */
    private String henkanType;

    /**
     * ソートID
     * @generated
     */
    private int sortId;


    /**
     * 権限_条件セット
     * @generated
     */
    private String jokenSetCd;

    /**
     * 検索条件_従業員番号(管理者)
     * @generated
     */
    private int kensakuJgiNo;

    /**
     * 検索条件_医薬支店C_申請者所属リージョン(管理者)
     * @generated
     */
    private String kensakuShinseiBrCode;

    /**
     * 検索条件_医薬営業所C_申請者所属エリア(管理者)
     * @generated
     */
    private String kensakuShinseiDistCode;

    /**
     * 検索条件_医薬支店C_担当者所属リージョン(管理者)
     * @generated
     */
    private String kensakuSTantouBrCode;

    /**
     * 検索条件_医薬営業所C_担当者所属エリア(管理者)
     * @generated
     */
    private String kensakuTantouDistCode;

    /**
     * 検索条件_申請者(管理者)
     * @generated
     */
    private String kensakuReqJgiName;

    /**
     * 従業員番号(MR)
     * @generated
     */
    private int mrJgiNo;

    /**
     * 医薬支店C_申請者所属リージョン(MR)
     * @generated
     */
    private String mrBrCode;

    /**
     * 医薬営業所C_申請者所属エリア(MR)
     * @generated
     */
    private String mrDistCode;

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
     * 検索条件_施設区分
     * @generated
     */
    private String kensakuPharmType;

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

    /**検索条件_電話番号(半角)
     * @generated
     */
    private String KensakuInsPhone;

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
     * 更新日
     * @generated
     */
    private Date updShaYmd;


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
     * 親施設コード
     * @generated
     */
    private String mainInsNo;

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
     * レコード件数
     * @generated
     */
    private Integer recCnt;


    /**
     * コンストラクタ
     * @generated
     */
    public SelectMainInsListEntity() {
        super("m_rdm_hco_upd_hst_mst" , "selectMainInsListEntity");
    }

    /**
     * 変換系
     * @generated
     */
    public SelectMainInsListEntity(String henkanType) {
        super("m_rdm_hco_upd_hst_mst" , "searchHenkanMainIns");
        this.henkanType = henkanType;
    }

	public int getSortId() {
		return sortId;
	}

	/**
	 * SelectMainInsListEntity.javahoInsTypeUpdFlgを設定
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
	 * SelectMainInsListEntity.javainsAbbrNameUpdFlgを設定
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
	 * SelectMainInsListEntity.javamainInsNoUpdFlgを設定
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
	 * SelectMainInsListEntity.javamainInsNmUpdFlgを設定
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

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public String getHenkanType() {
		return henkanType;
	}

	public void setHenkanType(String henkanType) {
		this.henkanType = henkanType;
	}

	public String getSearchHenkan() {
		return searchHenkan;
	}

	public void setSearchHenkan(String searchHenkan) {
		this.searchHenkan = searchHenkan;
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

	public void setMainInsNm(String mainInsNm) {
		this.mainInsNm = mainInsNm;
	}

	public String getTrtNm() {
		return trtNm;
	}

	public void setTrtNm(String trtNm) {
		this.trtNm = trtNm;
	}

	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	public Date getUpdShaYmd() {
		return updShaYmd;
	}

	public void setUpdShaYmd(Date updShaYmd) {
		this.updShaYmd = updShaYmd;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getInsNo() {
		return insNo;
	}

	public void setInsNo(String insNo) {
		this.insNo = insNo;
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

	/**
	 * SelectMainInsListEntity.javainOffsetを設定
	 * @return inOffset
	 */
	public Integer getInOffset() {
		return inOffset;
	}

	/**
	 * @param inOffset セットする inOffset
	 */
	public void setInOffset(Integer inOffset) {
		this.inOffset = inOffset;
	}

	/**
	 * SelectMainInsListEntity.javainLimitを設定
	 * @return inLimit
	 */
	public Integer getInLimit() {
		return inLimit;
	}

	/**
	 * @param inLimit セットする inLimit
	 */
	public void setInLimit(Integer inLimit) {
		this.inLimit = inLimit;
	}

	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
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

	public String getReqDistCode() {
		return reqDistCode;
	}

	public void setReqDistCode(String reqDistCode) {
		this.reqDistCode = reqDistCode;
	}

	/**
	 * SelectMainInsListEntity.javareqShzを設定
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

	public String getKensakuInsKanj() {
		return kensakuInsKanj;
	}

	public void setKensakuInsKanj(String kensakuInsKanj) {
		this.kensakuInsKanj = kensakuInsKanj;
	}

	public String getKensakuInsKana() {
		return kensakuInsKana;
	}

	public void setKensakuInsKana(String kensakuInsKana) {
		this.kensakuInsKana = kensakuInsKana;
	}

	public String getKensakuInsNo() {
		return kensakuInsNo;
	}

	public void setKensakuInsNo(String kensakuInsNo) {
		this.kensakuInsNo = kensakuInsNo;
	}

	public String getKensakuUltInsNo() {
		return kensakuUltInsNo;
	}

	public void setKensakuUltInsNo(String kensakuUltInsNo) {
		this.kensakuUltInsNo = kensakuUltInsNo;
	}

	public String getKensakuManageCd() {
		return kensakuManageCd;
	}

	public void setKensakuManageCd(String kensakuManageCd) {
		this.kensakuManageCd = kensakuManageCd;
	}

	public String getKensakuHoInsType() {
		return kensakuHoInsType;
	}

	public void setKensakuHoInsType(String kensakuHoInsType) {
		this.kensakuHoInsType = kensakuHoInsType;
	}

	public String getKensakuInsSbt() {
		return kensakuInsSbt;
	}

	public void setKensakuInsSbt(String kensakuInsSbt) {
		this.kensakuInsSbt = kensakuInsSbt;
	}

	public String getKensakuInsPhone() {
		return KensakuInsPhone;
	}

	public void setKensakuInsPhone(String kensakuInsPhone) {
		KensakuInsPhone = kensakuInsPhone;
	}

	public String getKensakuInsPcode() {
		return kensakuInsPcode;
	}

	public void setKensakuInsPcode(String kensakuInsPcode) {
		this.kensakuInsPcode = kensakuInsPcode;
	}

	public String getKensakuAddrCodePref() {
		return kensakuAddrCodePref;
	}

	public void setKensakuAddrCodePref(String kensakuAddrCodePref) {
		this.kensakuAddrCodePref = kensakuAddrCodePref;
	}

	public String getKensakuAddrCodeCity() {
		return kensakuAddrCodeCity;
	}

	public void setKensakuAddrCodeCity(String kensakuAddrCodeCity) {
		this.kensakuAddrCodeCity = kensakuAddrCodeCity;
	}

	public String getKensakuInsAddr() {
		return kensakuInsAddr;
	}

	public void setKensakuInsAddr(String kensakuInsAddr) {
		this.kensakuInsAddr = kensakuInsAddr;
	}

	public Date getKensakuUpdMstFrom() {
		return kensakuUpdMstFrom;
	}

	public void setKensakuUpdMstFrom(Date kensakuUpdMstFrom) {
		this.kensakuUpdMstFrom = kensakuUpdMstFrom;
	}

	public Date getKensakuUpdMstTo() {
		return kensakuUpdMstTo;
	}

	public void setKensakuUpdMstTo(Date kensakuUpdMstTo) {
		this.kensakuUpdMstTo = kensakuUpdMstTo;
	}

	public Integer getInSelectKbn() {
		return inSelectKbn;
	}

	public void setInSelectKbn(Integer inSelectKbn) {
		this.inSelectKbn = inSelectKbn;
	}


	public Integer getRecCnt() {
		return recCnt;
	}


	public void setRecCnt(Integer recCnt) {
		this.recCnt = recCnt;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * SelectMainInsListEntity.javakensakuReqJgiNameを設定
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
	 * SelectMainInsListEntity.javajokenSetCdを設定
	 * @return jokenSetCd
	 */
	public String getJokenSetCd() {
		return jokenSetCd;
	}

	/**
	 * @param jokenSetCd セットする jokenSetCd
	 */
	public void setJokenSetCd(String jokenSetCd) {
		this.jokenSetCd = jokenSetCd;
	}

	/**
	 * SelectMainInsListEntity.javakensakuJgiNoを設定
	 * @return kensakuJgiNo
	 */
	public int getKensakuJgiNo() {
		return kensakuJgiNo;
	}

	/**
	 * @param kensakuJgiNo セットする kensakuJgiNo
	 */
	public void setKensakuJgiNo(int kensakuJgiNo) {
		this.kensakuJgiNo = kensakuJgiNo;
	}

	/**
	 * SelectMainInsListEntity.javakensakuShinseiBrCodeを設定
	 * @return kensakuShinseiBrCode
	 */
	public String getKensakuShinseiBrCode() {
		return kensakuShinseiBrCode;
	}

	/**
	 * @param kensakuShinseiBrCode セットする kensakuShinseiBrCode
	 */
	public void setKensakuShinseiBrCode(String kensakuShinseiBrCode) {
		this.kensakuShinseiBrCode = kensakuShinseiBrCode;
	}

	/**
	 * SelectMainInsListEntity.javakensakuShinseiDistCodeを設定
	 * @return kensakuShinseiDistCode
	 */
	public String getKensakuShinseiDistCode() {
		return kensakuShinseiDistCode;
	}

	/**
	 * @param kensakuShinseiDistCode セットする kensakuShinseiDistCode
	 */
	public void setKensakuShinseiDistCode(String kensakuShinseiDistCode) {
		this.kensakuShinseiDistCode = kensakuShinseiDistCode;
	}

	/**
	 * SelectMainInsListEntity.javakensakuSTantouBrCodeを設定
	 * @return kensakuSTantouBrCode
	 */
	public String getKensakuSTantouBrCode() {
		return kensakuSTantouBrCode;
	}

	/**
	 * @param kensakuSTantouBrCode セットする kensakuSTantouBrCode
	 */
	public void setKensakuSTantouBrCode(String kensakuSTantouBrCode) {
		this.kensakuSTantouBrCode = kensakuSTantouBrCode;
	}

	/**
	 * SelectMainInsListEntity.javakensakuTantouDistCodeを設定
	 * @return kensakuTantouDistCode
	 */
	public String getKensakuTantouDistCode() {
		return kensakuTantouDistCode;
	}

	/**
	 * @param kensakuTantouDistCode セットする kensakuTantouDistCode
	 */
	public void setKensakuTantouDistCode(String kensakuTantouDistCode) {
		this.kensakuTantouDistCode = kensakuTantouDistCode;
	}

	/**
	 * SelectMainInsListEntity.javamrJgiNoを設定
	 * @return mrJgiNo
	 */
	public int getMrJgiNo() {
		return mrJgiNo;
	}

	/**
	 * @param mrJgiNo セットする mrJgiNo
	 */
	public void setMrJgiNo(int mrJgiNo) {
		this.mrJgiNo = mrJgiNo;
	}

	/**
	 * SelectMainInsListEntity.javamrBrCodeを設定
	 * @return mrBrCode
	 */
	public String getMrBrCode() {
		return mrBrCode;
	}

	/**
	 * @param mrBrCode セットする mrBrCode
	 */
	public void setMrBrCode(String mrBrCode) {
		this.mrBrCode = mrBrCode;
	}

	/**
	 * SelectMainInsListEntity.javamrDistCodeを設定
	 * @return mrDistCode
	 */
	public String getMrDistCode() {
		return mrDistCode;
	}

	/**
	 * @param mrDistCode セットする mrDistCode
	 */
	public void setMrDistCode(String mrDistCode) {
		this.mrDistCode = mrDistCode;
	}

	/**
	 * SelectMainInsListEntity.javakensakuPharmTypeを設定
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

}
