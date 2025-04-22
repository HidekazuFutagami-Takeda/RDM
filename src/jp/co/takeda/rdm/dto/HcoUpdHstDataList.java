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
public class HcoUpdHstDataList implements Serializable {

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
    private String manageCd;

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
     * 申請者所属
     * @generated
     */
    private String reqShz;

    /**
     * 承認者所属
     * @generated
     */
    private String aprShz;

  //更新フラグここから
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

    /**
     * 開業年月日更新フラグ
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
     * @customizable
     */
    public HcoUpdHstDataList() {
        // START UOC

        // END UOC
    }

	public String getMainInsNo() {
		return mainInsNo;
	}

	public void setMainInsNo(String mainInsNo) {
		this.mainInsNo = mainInsNo;
	}

	/**
	 * HcoUpdHstDataList.javahoInsTypeUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsAbbrNameUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsFormalNameUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsPcodeUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsAddrUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsPhone1UpdFlgを設定
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
	 * HcoUpdHstDataList.javainsFax1UpdFlgを設定
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
	 * HcoUpdHstDataList.javaultInsNoUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsContNameUpdFlgを設定
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
	 * HcoUpdHstDataList.javapharmTypeUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsRankUpdFlgを設定
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
	 * HcoUpdHstDataList.javamanageCdUpdFlgを設定
	 * @return manageCdUpdFlg
	 */
	public String getManageCdUpdFlg() {
		return manageCdUpdFlg;
	}

	/**
	 * @param manageCdUpdFlg セットする manageCdUpdFlg
	 */
	public void setManageCdUpdFlg(String manageCdUpdFlg) {
		this.manageCdUpdFlg = manageCdUpdFlg;
	}

	/**
	 * HcoUpdHstDataList.javaaddrCodePrefUpdFlgを設定
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
	 * HcoUpdHstDataList.javaaddrCodeCityUpdFlgを設定
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
	 * HcoUpdHstDataList.javatkCityCdUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsPhone2UpdFlgを設定
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
	 * HcoUpdHstDataList.javainsFax2UpdFlgを設定
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
	 * HcoUpdHstDataList.javainsUrlUpdFlgを設定
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
	 * HcoUpdHstDataList.javainsUrlYmdUpdFlgを設定
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
	 * HcoUpdHstDataList.javavacInsTypeUpdFlgを設定
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
	 * HcoUpdHstDataList.javavacVisitTypeUpdFlgを設定
	 * @return vacVisitTypeUpdFlg
	 */
	public String getVacVisitTypeUpdFlg() {
		return vacVisitTypeUpdFlg;
	}

	/**
	 * @param vacVisitTypeUpdFlg セットする vacVisitTypeUpdFlg
	 */
	public void setVacVisitTypeUpdFlg(String vacVisitTypeUpdFlg) {
		this.vacVisitTypeUpdFlg = vacVisitTypeUpdFlg;
	}

	/**
	 * HcoUpdHstDataList.javabedcntBaseUpdFlgを設定
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
	 * HcoUpdHstDataList.javabedsTotUpdFlgを設定
	 * @return bedsTotUpdFlg
	 */
	public String getBedsTotUpdFlg() {
		return bedsTotUpdFlg;
	}

	/**
	 * @param bedsTotUpdFlg セットする bedsTotUpdFlg
	 */
	public void setBedsTotUpdFlg(String bedsTotUpdFlg) {
		this.bedsTotUpdFlg = bedsTotUpdFlg;
	}

	/**
	 * HcoUpdHstDataList.javamedBedsTotUpdFlgを設定
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
	 * HcoUpdHstDataList.javabedcnt01UpdFlgを設定
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
	 * HcoUpdHstDataList.javabedcnt02UpdFlgを設定
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
	 * HcoUpdHstDataList.javabedcnt03UpdFlgを設定
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
	 * HcoUpdHstDataList.javabedcnt04UpdFlgを設定
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
	 * HcoUpdHstDataList.javabedcnt05UpdFlgを設定
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
	 * HcoUpdHstDataList.javabedcnt06UpdFlgを設定
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
	 * HcoUpdHstDataList.javabedcnt07UpdFlgを設定
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
	 * HcoUpdHstDataList.javainsOpenYmdUpdFlgを設定
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
	 * HcoUpdHstDataList.javaclitemListUpdFlgを設定
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
		return manageCd;
	}



	public void setManageCd(String manageCd) {
		this.manageCd = manageCd;
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



	/**
	 * HcoUpdHstDataList.javareqShzを設定
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

