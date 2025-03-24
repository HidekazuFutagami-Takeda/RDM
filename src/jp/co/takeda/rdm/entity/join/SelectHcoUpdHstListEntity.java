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
public class SelectHcoUpdHstListEntity extends BaseEntity implements Serializable {

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
     * ソートID
     * @generated
     */
    private int sortId;

    /**
     * 変換系_結果
     * @generated
     */
    private String searchHenkan;

    /**
     * 変換系_区分
     * @generated
     */
    private String henkanType;

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

    /* 領域別 ここから */
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
    /* 領域別 ここまで */

    /**
     * 施設正式漢字名
     * @generated
     */
    private String insFormalName;

    /**
     * 郵便番号
     * @generated
     */
    private String insPcode;

    /**
     * 施設住所（漢字）
     * @generated
     */
    private String insAddr;

    /**
     * 電話番号1
     * @generated
     */
    private String insPhone1;

    /**
     * FAX番号1
     * @generated
     */
    private String insFax1;

    /**
     * （来期）項目変更フラグ
     * @generated
     */
    private String hcoNxt;

    //来季用項目ここから
    /**
     * 対象区分更新フラグ
     * @generated
     */
    private String hoInsTypeUpdFlg;

    /**
     * 施設区分更新フラグ
     * @generated
     */
    private String pharmTypeUpdFlg;

    /**
     * 階級区分更新フラグ
     * @generated
     */
    private String insRankUpdFlg;

    /**
     * 経営主体コード更新フラグ
     * @generated
     */
    private String ManageCdUpdFlg;

    /**
     * 定訪先区分更新フラグ
     * @generated
     */
    private String regVisTypeUpdFlg;

    /**
     * 重点病院区分更新フラグ
     * @generated
     */
    private String impHosTypeUpdFlg;

    /**
     * ワクチン対象区分(当期)更新フラグ
     * @generated
     */
    private String vacInsTypeUpdFlg;

    /**
     * ワクチン定訪先区分(当期)更新フラグ
     * @generated
     */
    private String vacVisitTypeUpdFlg;

    /**
     * 病床(基準)更新フラグ
     * @generated
     */
    private String bedcntBaseUpdFlg;

    /**
     * ベッド数計更新フラグ
     * @generated
     */
    private String bedsTotUpdFlg;

    /**
     * 医療ベッド数計更新フラグ
     * @generated
     */
    private String medBedsTotUpdFlg;

    /**
     * 病床数(一般)更新フラグ
     * @generated
     */
    private String bedcnt01UpdFlg;

    /**
     * 病床数(医療療養)更新フラグ
     * @generated
     */
    private String bedcnt02UpdFlg;

    /**
     * 病床数(精神)更新フラグ
     * @generated
     */
    private String bedcnt03UpdFlg;

    /**
     * 病床数(結核)更新フラグ
     * @generated
     */
    private String bedcnt04UpdFlg;

    /**
     * 病床数(感染症)更新フラグ
     * @generated
     */
    private String bedcnt05UpdFlg;

    /**
     * 病床数(介護療養)更新フラグ
     * @generated
     */
    private String bedcnt06UpdFlg;

    /**
     * 病床数(療養)更新フラグ
     * @generated
     */
    private String bedcnt07UpdFlg;
  //来季用項目ここまで


    /**
     * その他項目の変更フラグ
     * @generated
     */
    private String otherChanges;

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
     * ULT施設コード
     * @generated
     */
    private String ultInsNo;

    /**
     * ULT施設名称
     * @generated
     */
    private String shisetsuNmRyaku;

    /**
     * 施設契約漢字名
     * @generated
     */
    private String insContName;

    /**
     * 施設区分
     * @generated
     */
    private String pharmType;

    /**
     * 階級区分
     * @generated
     */
    private String insRank;

    /**
     * 経営主体
     * @generated
     */
    private String ManageCd;

    /**
     * JIS府県名
     * @generated
     */
    private String addrCodePref;

    /**
     * JIS市区町村名
     * @generated
     */
    private String addrCodeCity;

    /**
     * 武田市区郡名
     * @generated
     */
    private String tkCityCd;

    /**
     * 電話番号2
     * @generated
     */
    private String insPhone2;

    /**
     * FAX番号2
     * @generated
     */
    private String insFax2;

    /**
     * ホームページアドレス
     * @generated
     */
    private String insUrl;

    /**
     * ホームページアドレス最終更新日
     * @generated
     */
    private String insUrlYmd;

    /**
     * ワクチン対象区分(当期)
     * @generated
     */
    private String vacInsType;

    /**
     * ワクチン定訪先区分(当期)
     * @generated
     */
    private String vacVisitType;

    /**
     * 病床(基準)
     * @generated
     */
    private String bedcntBase;

    /**
     * ベッド数計
     * @generated
     */
    private String bedsTot;

    /**
     * 医療ベッド数計
     * @generated
     */
    private String medBedsTot;

    /**
     * 病床数(一般)
     * @generated
     */
    private String bedcnt01;

    /**
     * 病床数(医療療養)
     * @generated
     */
    private String bedcnt02;

    /**
     * 病床数(精神)
     * @generated
     */
    private String bedcnt03;

    /**
     * 病床数(結核)
     * @generated
     */
    private String bedcnt04;

    /**
     * 病床数(感染症)
     * @generated
     */
    private String bedcnt05;

    /**
     * 病床数(介護療養)
     * @generated
     */
    private String bedcnt06;

    /**
     * 病床数(療養)
     * @generated
     */
    private String bedcnt07;

    /**
     * 開業年
     * @generated
     */
    private String insOpenYear;

    /**
     * 開業月
     * @generated
     */
    private String insOpenMonth;

    /**
     * 開業日
     * @generated
     */
    private String insOpenDay;

    /**
     * 診療科目
     * @generated
     */
    private String clitemList;

    /**
     * 申請者所属リージョン
     * @generated
     */
    private String reqBrCod;

    /**
     * 申請者所属エリア
     * @generated
     */
    private String reqDistCode;

    /**
     * 承認者所属
     * @generated
     */
    private String aprShz;

  //更新フラグここまで

    /**
     * 施設略式漢字名更新フラグ
     * @generated
     */
    private String insAbbrNameUpdFlg;

    /**
     * 施設正式漢字名更新フラグ
     * @generated
     */
    private String insFormalNameUpdFlg;

    /**
     * 郵便番号更新フラグ
     * @generated
     */
    private String insPcodeUpdFlg;

    /**
     * 施設住所（漢字）更新フラグ
     * @generated
     */
    private String insAddrUpdFlg;

    /**
     * 電話番号1更新フラグ
     * @generated
     */
    private String insPhone1UpdFlg;

    /**
     * FAX番号1更新フラグ
     * @generated
     */
    private String insFax1UpdFlg;

    /**
     * ULT施設更新フラグ
     * @generated
     */
    private String ultInsNoUpdFlg;

    /**
     * 施設契約漢字名更新フラグ
     * @generated
     */
    private String insContNameUpdFlg;

    /**
     * 経営主体更新フラグ
     * @generated
     */
    private String manageCdUpdFlg;

    /**
     * JIS府県名更新フラグ
     * @generated
     */
    private String addrCodePrefUpdFlg;

    /**
     * JIS市区町村名更新フラグ
     * @generated
     */
    private String addrCodeCityUpdFlg;

    /**
     * 武田市区郡名更新フラグ
     * @generated
     */
    private String tkCityCdUpdFlg;

    /**
     * 電話番号2更新フラグ
     * @generated
     */
    private String insPhone2UpdFlg;

    /**
     * FAX番号2更新フラグ
     * @generated
     */
    private String insFax2UpdFlg;

    /**
     * ホームページアドレス更新フラグ
     * @generated
     */
    private String insUrlUpdFlg;

    /**
     * ホームページアドレス最終更新日更新フラグ
     * @generated
     */
    private String insUrlYmdUpdFlg;


    /**
     * 開業年月日
     * @generated
     */
    private String insOpenYmdUpdFlg;

    /**
     * 診療科目更新フラグ
     * @generated
     */
    private String clitemListUpdFlg;
    //更新フラグここまで

    /**
     * レコード件数
     * @generated
     */
    private Integer recCnt;


    /**
     * コンストラクタ
     * @generated
     */
    public SelectHcoUpdHstListEntity() {
        super("m_rdm_hco_upd_hst_mst" , "selectHcoUpdHstListEntity");
    }

    /**
     * コンストラクタ_変換系
     * @generated
     */
    public SelectHcoUpdHstListEntity(String henkanType) {
        super("m_rdm_hco_upd_hst_mst" , "searchHenkanHcoUpd");
        this.henkanType = henkanType;
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

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
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

	/**
	 * SelectHcoUpdHstListEntity.javainOffsetを設定
	 * @return inOffset
	 */
	public Integer getInOffset() {
		return inOffset;
	}

	/**
	 * SelectHcoUpdHstListEntity.javahoInsTypeUpdFlgを設定
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
	 * SelectHcoUpdHstListEntity.javapharmTypeUpdFlgを設定
	 * @return pharmTypeUpdFlg
	 */
	public String getPharmTypeUpdFlg() {
		return pharmTypeUpdFlg;
	}

	/**
	 * @param pharmTypeUpdFlg セットする pharmTypeUpdFlg
	 */
	public void setPharmTypeUpdFlg(String pharmTypeUpdFlg) {
		this.pharmTypeUpdFlg = pharmTypeUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsRankUpdFlgを設定
	 * @return insRankUpdFlg
	 */
	public String getInsRankUpdFlg() {
		return insRankUpdFlg;
	}

	/**
	 * @param insRankUpdFlg セットする insRankUpdFlg
	 */
	public void setInsRankUpdFlg(String insRankUpdFlg) {
		this.insRankUpdFlg = insRankUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javaManageCdUpdFlgを設定
	 * @return manageCdUpdFlg
	 */
	public String getManageCdUpdFlg() {
		return ManageCdUpdFlg;
	}

	/**
	 * @param manageCdUpdFlg セットする manageCdUpdFlg
	 */
	public void setManageCdUpdFlg(String manageCdUpdFlg) {
		ManageCdUpdFlg = manageCdUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javaregVisTypeUpdFlgを設定
	 * @return regVisTypeUpdFlg
	 */
	public String getRegVisTypeUpdFlg() {
		return regVisTypeUpdFlg;
	}

	/**
	 * @param regVisTypeUpdFlg セットする regVisTypeUpdFlg
	 */
	public void setRegVisTypeUpdFlg(String regVisTypeUpdFlg) {
		this.regVisTypeUpdFlg = regVisTypeUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javaimpHosTypeUpdFlgを設定
	 * @return impHosTypeUpdFlg
	 */
	public String getImpHosTypeUpdFlg() {
		return impHosTypeUpdFlg;
	}

	/**
	 * @param impHosTypeUpdFlg セットする impHosTypeUpdFlg
	 */
	public void setImpHosTypeUpdFlg(String impHosTypeUpdFlg) {
		this.impHosTypeUpdFlg = impHosTypeUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javavacInsTypeUpdFlgを設定
	 * @return vacInsTypeUpdFlg
	 */
	public String getVacInsTypeUpdFlg() {
		return vacInsTypeUpdFlg;
	}

	/**
	 * @param vacInsTypeUpdFlg セットする vacInsTypeUpdFlg
	 */
	public void setVacInsTypeUpdFlg(String vacInsTypeUpdFlg) {
		this.vacInsTypeUpdFlg = vacInsTypeUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javavacVisitTypeUpdFlgを設定
	 * @return vacVisitTypeUpdFlg
	 */
	public String getVacVisitTypeUpdFlg() {
		return vacVisitTypeUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsAbbrNameUpdFlgを設定
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
	 * SelectHcoUpdHstListEntity.javainsFormalNameUpdFlgを設定
	 * @return insFormalNameUpdFlg
	 */
	public String getInsFormalNameUpdFlg() {
		return insFormalNameUpdFlg;
	}

	/**
	 * @param insFormalNameUpdFlg セットする insFormalNameUpdFlg
	 */
	public void setInsFormalNameUpdFlg(String insFormalNameUpdFlg) {
		this.insFormalNameUpdFlg = insFormalNameUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsPcodeUpdFlgを設定
	 * @return insPcodeUpdFlg
	 */
	public String getInsPcodeUpdFlg() {
		return insPcodeUpdFlg;
	}

	/**
	 * @param insPcodeUpdFlg セットする insPcodeUpdFlg
	 */
	public void setInsPcodeUpdFlg(String insPcodeUpdFlg) {
		this.insPcodeUpdFlg = insPcodeUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsAddrUpdFlgを設定
	 * @return insAddrUpdFlg
	 */
	public String getInsAddrUpdFlg() {
		return insAddrUpdFlg;
	}

	/**
	 * @param insAddrUpdFlg セットする insAddrUpdFlg
	 */
	public void setInsAddrUpdFlg(String insAddrUpdFlg) {
		this.insAddrUpdFlg = insAddrUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsPhone1UpdFlgを設定
	 * @return insPhone1UpdFlg
	 */
	public String getInsPhone1UpdFlg() {
		return insPhone1UpdFlg;
	}

	/**
	 * @param insPhone1UpdFlg セットする insPhone1UpdFlg
	 */
	public void setInsPhone1UpdFlg(String insPhone1UpdFlg) {
		this.insPhone1UpdFlg = insPhone1UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsFax1UpdFlgを設定
	 * @return insFax1UpdFlg
	 */
	public String getInsFax1UpdFlg() {
		return insFax1UpdFlg;
	}

	/**
	 * @param insFax1UpdFlg セットする insFax1UpdFlg
	 */
	public void setInsFax1UpdFlg(String insFax1UpdFlg) {
		this.insFax1UpdFlg = insFax1UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javaultInsNoUpdFlgを設定
	 * @return ultInsNoUpdFlg
	 */
	public String getUltInsNoUpdFlg() {
		return ultInsNoUpdFlg;
	}

	/**
	 * @param ultInsNoUpdFlg セットする ultInsNoUpdFlg
	 */
	public void setUltInsNoUpdFlg(String ultInsNoUpdFlg) {
		this.ultInsNoUpdFlg = ultInsNoUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsContNameUpdFlgを設定
	 * @return insContNameUpdFlg
	 */
	public String getInsContNameUpdFlg() {
		return insContNameUpdFlg;
	}

	/**
	 * @param insContNameUpdFlg セットする insContNameUpdFlg
	 */
	public void setInsContNameUpdFlg(String insContNameUpdFlg) {
		this.insContNameUpdFlg = insContNameUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javaaddrCodePrefUpdFlgを設定
	 * @return addrCodePrefUpdFlg
	 */
	public String getAddrCodePrefUpdFlg() {
		return addrCodePrefUpdFlg;
	}

	/**
	 * @param addrCodePrefUpdFlg セットする addrCodePrefUpdFlg
	 */
	public void setAddrCodePrefUpdFlg(String addrCodePrefUpdFlg) {
		this.addrCodePrefUpdFlg = addrCodePrefUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javaaddrCodeCityUpdFlgを設定
	 * @return addrCodeCityUpdFlg
	 */
	public String getAddrCodeCityUpdFlg() {
		return addrCodeCityUpdFlg;
	}

	/**
	 * @param addrCodeCityUpdFlg セットする addrCodeCityUpdFlg
	 */
	public void setAddrCodeCityUpdFlg(String addrCodeCityUpdFlg) {
		this.addrCodeCityUpdFlg = addrCodeCityUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javatkCityCdUpdFlgを設定
	 * @return tkCityCdUpdFlg
	 */
	public String getTkCityCdUpdFlg() {
		return tkCityCdUpdFlg;
	}

	/**
	 * @param tkCityCdUpdFlg セットする tkCityCdUpdFlg
	 */
	public void setTkCityCdUpdFlg(String tkCityCdUpdFlg) {
		this.tkCityCdUpdFlg = tkCityCdUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsPhone2UpdFlgを設定
	 * @return insPhone2UpdFlg
	 */
	public String getInsPhone2UpdFlg() {
		return insPhone2UpdFlg;
	}

	/**
	 * @param insPhone2UpdFlg セットする insPhone2UpdFlg
	 */
	public void setInsPhone2UpdFlg(String insPhone2UpdFlg) {
		this.insPhone2UpdFlg = insPhone2UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsFax2UpdFlgを設定
	 * @return insFax2UpdFlg
	 */
	public String getInsFax2UpdFlg() {
		return insFax2UpdFlg;
	}

	/**
	 * @param insFax2UpdFlg セットする insFax2UpdFlg
	 */
	public void setInsFax2UpdFlg(String insFax2UpdFlg) {
		this.insFax2UpdFlg = insFax2UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsUrlUpdFlgを設定
	 * @return insUrlUpdFlg
	 */
	public String getInsUrlUpdFlg() {
		return insUrlUpdFlg;
	}

	/**
	 * @param insUrlUpdFlg セットする insUrlUpdFlg
	 */
	public void setInsUrlUpdFlg(String insUrlUpdFlg) {
		this.insUrlUpdFlg = insUrlUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsUrlYmdUpdFlgを設定
	 * @return insUrlYmdUpdFlg
	 */
	public String getInsUrlYmdUpdFlg() {
		return insUrlYmdUpdFlg;
	}

	/**
	 * @param insUrlYmdUpdFlg セットする insUrlYmdUpdFlg
	 */
	public void setInsUrlYmdUpdFlg(String insUrlYmdUpdFlg) {
		this.insUrlYmdUpdFlg = insUrlYmdUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainsOpenYmdUpdFlgを設定
	 * @return insOpenYmdUpdFlg
	 */
	public String getInsOpenYmdUpdFlg() {
		return insOpenYmdUpdFlg;
	}

	/**
	 * @param insOpenYmdUpdFlg セットする insOpenYmdUpdFlg
	 */
	public void setInsOpenYmdUpdFlg(String insOpenYmdUpdFlg) {
		this.insOpenYmdUpdFlg = insOpenYmdUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javaclitemListUpdFlgを設定
	 * @return clitemListUpdFlg
	 */
	public String getClitemListUpdFlg() {
		return clitemListUpdFlg;
	}

	/**
	 * @param clitemListUpdFlg セットする clitemListUpdFlg
	 */
	public void setClitemListUpdFlg(String clitemListUpdFlg) {
		this.clitemListUpdFlg = clitemListUpdFlg;
	}

	/**
	 * @param vacVisitTypeUpdFlg セットする vacVisitTypeUpdFlg
	 */
	public void setVacVisitTypeUpdFlg(String vacVisitTypeUpdFlg) {
		this.vacVisitTypeUpdFlg = vacVisitTypeUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedcntBaseUpdFlgを設定
	 * @return bedcntBaseUpdFlg
	 */
	public String getBedcntBaseUpdFlg() {
		return bedcntBaseUpdFlg;
	}

	/**
	 * @param bedcntBaseUpdFlg セットする bedcntBaseUpdFlg
	 */
	public void setBedcntBaseUpdFlg(String bedcntBaseUpdFlg) {
		this.bedcntBaseUpdFlg = bedcntBaseUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedsTotUpdFlgを設定
	 * @return bedsTotUpdFlg
	 */
	public String getBedsTotUpdFlg() {
		return bedsTotUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javakensakuPharmTypeを設定
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
	 * @param bedsTotUpdFlg セットする bedsTotUpdFlg
	 */
	public void setBedsTotUpdFlg(String bedsTotUpdFlg) {
		this.bedsTotUpdFlg = bedsTotUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javamedBedsTotUpdFlgを設定
	 * @return medBedsTotUpdFlg
	 */
	public String getMedBedsTotUpdFlg() {
		return medBedsTotUpdFlg;
	}

	/**
	 * @param medBedsTotUpdFlg セットする medBedsTotUpdFlg
	 */
	public void setMedBedsTotUpdFlg(String medBedsTotUpdFlg) {
		this.medBedsTotUpdFlg = medBedsTotUpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedcnt01UpdFlgを設定
	 * @return bedcnt01UpdFlg
	 */
	public String getBedcnt01UpdFlg() {
		return bedcnt01UpdFlg;
	}

	/**
	 * @param bedcnt01UpdFlg セットする bedcnt01UpdFlg
	 */
	public void setBedcnt01UpdFlg(String bedcnt01UpdFlg) {
		this.bedcnt01UpdFlg = bedcnt01UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedcnt02UpdFlgを設定
	 * @return bedcnt02UpdFlg
	 */
	public String getBedcnt02UpdFlg() {
		return bedcnt02UpdFlg;
	}

	/**
	 * @param bedcnt02UpdFlg セットする bedcnt02UpdFlg
	 */
	public void setBedcnt02UpdFlg(String bedcnt02UpdFlg) {
		this.bedcnt02UpdFlg = bedcnt02UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedcnt03UpdFlgを設定
	 * @return bedcnt03UpdFlg
	 */
	public String getBedcnt03UpdFlg() {
		return bedcnt03UpdFlg;
	}

	/**
	 * @param bedcnt03UpdFlg セットする bedcnt03UpdFlg
	 */
	public void setBedcnt03UpdFlg(String bedcnt03UpdFlg) {
		this.bedcnt03UpdFlg = bedcnt03UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedcnt04UpdFlgを設定
	 * @return bedcnt04UpdFlg
	 */
	public String getBedcnt04UpdFlg() {
		return bedcnt04UpdFlg;
	}

	/**
	 * @param bedcnt04UpdFlg セットする bedcnt04UpdFlg
	 */
	public void setBedcnt04UpdFlg(String bedcnt04UpdFlg) {
		this.bedcnt04UpdFlg = bedcnt04UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedcnt05UpdFlgを設定
	 * @return bedcnt05UpdFlg
	 */
	public String getBedcnt05UpdFlg() {
		return bedcnt05UpdFlg;
	}

	/**
	 * @param bedcnt05UpdFlg セットする bedcnt05UpdFlg
	 */
	public void setBedcnt05UpdFlg(String bedcnt05UpdFlg) {
		this.bedcnt05UpdFlg = bedcnt05UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedcnt06UpdFlgを設定
	 * @return bedcnt06UpdFlg
	 */
	public String getBedcnt06UpdFlg() {
		return bedcnt06UpdFlg;
	}

	/**
	 * @param bedcnt06UpdFlg セットする bedcnt06UpdFlg
	 */
	public void setBedcnt06UpdFlg(String bedcnt06UpdFlg) {
		this.bedcnt06UpdFlg = bedcnt06UpdFlg;
	}

	/**
	 * SelectHcoUpdHstListEntity.javabedcnt07UpdFlgを設定
	 * @return bedcnt07UpdFlg
	 */
	public String getBedcnt07UpdFlg() {
		return bedcnt07UpdFlg;
	}

	/**
	 * @param bedcnt07UpdFlg セットする bedcnt07UpdFlg
	 */
	public void setBedcnt07UpdFlg(String bedcnt07UpdFlg) {
		this.bedcnt07UpdFlg = bedcnt07UpdFlg;
	}

	/**
	 * @param inOffset セットする inOffset
	 */
	public void setInOffset(Integer inOffset) {
		this.inOffset = inOffset;
	}

	/**
	 * SelectHcoUpdHstListEntity.javainLimitを設定
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

	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

	public String getInsFormalName() {
		return insFormalName;
	}

	public void setInsFormalName(String insFormalName) {
		this.insFormalName = insFormalName;
	}

	public String getInsPcode() {
		return insPcode;
	}

	public void setInsPcode(String insPcode) {
		this.insPcode = insPcode;
	}

	public String getInsAddr() {
		return insAddr;
	}

	public void setInsAddr(String insAddr) {
		this.insAddr = insAddr;
	}

	public String getInsPhone1() {
		return insPhone1;
	}

	public void setInsPhone1(String insPhone1) {
		this.insPhone1 = insPhone1;
	}

	public String getInsFax1() {
		return insFax1;
	}

	public void setInsFax1(String insFax1) {
		this.insFax1 = insFax1;
	}

	public String getHcoNxt() {
		return hcoNxt;
	}

	public void setHcoNxt(String hcoNxt) {
		this.hcoNxt = hcoNxt;
	}

	public String getOtherChanges() {
		return otherChanges;
	}

	public void setOtherChanges(String otherChanges) {
		this.otherChanges = otherChanges;
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

	public String getUltInsNo() {
		return ultInsNo;
	}

	public void setUltInsNo(String ultInsNo) {
		this.ultInsNo = ultInsNo;
	}

	public String getShisetsuNmRyaku() {
		return shisetsuNmRyaku;
	}

	public void setShisetsuNmRyaku(String shisetsuNmRyaku) {
		this.shisetsuNmRyaku = shisetsuNmRyaku;
	}

	public String getInsContName() {
		return insContName;
	}

	public void setInsContName(String insContName) {
		this.insContName = insContName;
	}

	public String getPharmType() {
		return pharmType;
	}

	public void setPharmType(String pharmType) {
		this.pharmType = pharmType;
	}

	public String getInsRank() {
		return insRank;
	}

	public void setInsRank(String insRank) {
		this.insRank = insRank;
	}

	public String getManageCd() {
		return ManageCd;
	}

	public void setManageCd(String manageCd) {
		ManageCd = manageCd;
	}

	public String getAddrCodePref() {
		return addrCodePref;
	}

	public void setAddrCodePref(String addrCodePref) {
		this.addrCodePref = addrCodePref;
	}

	public String getAddrCodeCity() {
		return addrCodeCity;
	}

	public void setAddrCodeCity(String addrCodeCity) {
		this.addrCodeCity = addrCodeCity;
	}

	public String getTkCityCd() {
		return tkCityCd;
	}

	public void setTkCityCd(String tkCityCd) {
		this.tkCityCd = tkCityCd;
	}

	public String getInsPhone2() {
		return insPhone2;
	}

	public void setInsPhone2(String insPhone2) {
		this.insPhone2 = insPhone2;
	}

	public String getInsFax2() {
		return insFax2;
	}

	public void setInsFax2(String insFax2) {
		this.insFax2 = insFax2;
	}

	public String getInsUrl() {
		return insUrl;
	}

	public void setInsUrl(String insUrl) {
		this.insUrl = insUrl;
	}
	/**
	 * SelectHcoUpdHstListEntity.javakensakuReqJgiNameを設定
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

	public String getInsUrlYmd() {
		return insUrlYmd;
	}

	public void setInsUrlYmd(String insUrlYmd) {
		this.insUrlYmd = insUrlYmd;
	}

	public String getVacInsType() {
		return vacInsType;
	}

	public void setVacInsType(String vacInsType) {
		this.vacInsType = vacInsType;
	}

	public String getVacVisitType() {
		return vacVisitType;
	}

	public void setVacVisitType(String vacVisitType) {
		this.vacVisitType = vacVisitType;
	}

	public String getBedcntBase() {
		return bedcntBase;
	}

	public void setBedcntBase(String bedcntBase) {
		this.bedcntBase = bedcntBase;
	}

	public String getBedsTot() {
		return bedsTot;
	}

	public void setBedsTot(String bedsTot) {
		this.bedsTot = bedsTot;
	}

	public String getMedBedsTot() {
		return medBedsTot;
	}

	public void setMedBedsTot(String medBedsTot) {
		this.medBedsTot = medBedsTot;
	}

	public String getBedcnt01() {
		return bedcnt01;
	}

	public void setBedcnt01(String bedcnt01) {
		this.bedcnt01 = bedcnt01;
	}

	public String getBedcnt02() {
		return bedcnt02;
	}

	public void setBedcnt02(String bedcnt02) {
		this.bedcnt02 = bedcnt02;
	}

	public String getBedcnt03() {
		return bedcnt03;
	}

	public void setBedcnt03(String bedcnt03) {
		this.bedcnt03 = bedcnt03;
	}

	public String getBedcnt04() {
		return bedcnt04;
	}

	public void setBedcnt04(String bedcnt04) {
		this.bedcnt04 = bedcnt04;
	}

	public String getBedcnt05() {
		return bedcnt05;
	}

	public void setBedcnt05(String bedcnt05) {
		this.bedcnt05 = bedcnt05;
	}

	public String getBedcnt06() {
		return bedcnt06;
	}

	public void setBedcnt06(String bedcnt06) {
		this.bedcnt06 = bedcnt06;
	}

	public String getBedcnt07() {
		return bedcnt07;
	}

	public void setBedcnt07(String bedcnt07) {
		this.bedcnt07 = bedcnt07;
	}

	public String getInsOpenYear() {
		return insOpenYear;
	}

	public void setInsOpenYear(String insOpenYear) {
		this.insOpenYear = insOpenYear;
	}

	public String getInsOpenMonth() {
		return insOpenMonth;
	}

	public void setInsOpenMonth(String insOpenMonth) {
		this.insOpenMonth = insOpenMonth;
	}

	public String getInsOpenDay() {
		return insOpenDay;
	}

	public void setInsOpenDay(String insOpenDay) {
		this.insOpenDay = insOpenDay;
	}

	public String getClitemList() {
		return clitemList;
	}

	public void setClitemList(String clitemList) {
		this.clitemList = clitemList;
	}

	public String getReqBrCod() {
		return reqBrCod;
	}

	public void setReqBrCod(String reqBrCod) {
		this.reqBrCod = reqBrCod;
	}

	public String getReqDistCode() {
		return reqDistCode;
	}

	public void setReqDistCode(String reqDistCode) {
		this.reqDistCode = reqDistCode;
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
	 * SelectHcoUpdHstListEntity.javakensakuJgiNoを設定
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
	 * SelectHcoUpdHstListEntity.javakensakuShinseiBrCodeを設定
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
	 * SelectHcoUpdHstListEntity.javakensakuShinseiDistCodeを設定
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
	 * SelectHcoUpdHstListEntity.javakensakuSTantouBrCodeを設定
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
	 * SelectHcoUpdHstListEntity.javakensakuTantouDistCodeを設定
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
	 * SelectHcoUpdHstListEntity.javamrJgiNoを設定
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
	 * SelectHcoUpdHstListEntity.javamrBrCodeを設定
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
	 * SelectHcoUpdHstListEntity.javamrDistCodeを設定
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
	 * SelectHcoUpdHstListEntity.javajokenSetCdを設定
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

}
