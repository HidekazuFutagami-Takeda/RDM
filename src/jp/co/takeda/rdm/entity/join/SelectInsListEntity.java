/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * 結合Entityクラス
 * テーブル物理名 : S_JKR_COM_INS_MST_USR
 * SQLID : selectInsList
 * @generated
 */
public class SelectInsListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

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
     * searchInput
     * @generated
     */
    private String searchInput;

    /**
     * inSearchInput
     * @generated
     */
    private String inSearchInput;

    /**
     * 検索用＿施設名全角
     * @generated
     */
    private String insKanjiSrch;

    /**
     * 検索用＿施設名半角カナ
     * @generated
     */
    private String insKanaSrch;

    /**
     * 検索用＿廃院区分
     * @generated
     */
    private String kensakuHaiinKbn;


    /**
     * 廃院区分 IS NULL 判定用
     * @generated
     */
    private String kensakuHaiinKbnNullFlg;

    /**
     * 検索用＿廃院区分
     * @generated
     */
    private String kensakuDelFlg;

    /**
     * 検索用＿ULTコード
     * @generated
     */
    private String insNoSrch;

    /**
     * 検索用＿ULTコード
     * @generated
     */
    private String ultNo;

    /**
     * 検索用＿廃院区分
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
    private String pharmType;

    /**
     * 検索条件_電話番号(半角)
     * @generated
     */
    private String phone1;

    /**
     * 検索条件_郵便番号(半角)
     * @generated
     */
    private String insPcode;

	/**
     * 検索条件_施設名(全角)
     * @generated
     */
    private String kensakuAddrCodePref;

	/**
     * 検索条件_施設名(全角)
     * @generated
     */
    private String kensakuAddrCodeCity;

    /**
     * 検索条件_JIS市区町村
     * @generated
     */
    private boolean koshisetsuCheck;


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
     * 施設略式漢字名
     * @generated
     */
    private String insFormalName;

    /**
     * 住所
     * @generated
     */
    private String insAddr;

    /**
     * 施設種別
     * @generated
     */
    private String insSbt;

    /**
     * 施設種別名
     * @generated
     */
    private String insSbtNm;

    /**
     * 経営主体
     * @generated
     */
    private String manageCd;

    /**
     * 経営主体
     * @generated
     */
    private String manageNm;

    /**
     * 病床数
     * @generated
     */
    private int bedsTot;

    /**
     * 施設名略
     * @generated
     */
    private String shisetsuNmRyaku;

    /**
     * 施設名
     * @generated
     */
    private String shisetsuNm;

    /**
     * DCF施設コード
     * @generated
     */
    private String dcfShisetsuCd;

    /**
     * 住所
     * @generated
     */
    private String address;

    /**
     * 電話番号
     * @generated
     */
    private String shisetsuTel;

    /**
     * 施設区分
     * @generated
     */
    private String shisetsuKbn;

    /**
     * 施設区分
     * @generated
     */
    private String shisetsuKbnNm;

    /**
     * 経営主体
     * @generated
     */
    private String keieitaiCd;

    /**
     * 経営主体
     * @generated
     */
    private String keieitaiNm;

    /**
     * 病床数
     * @generated
     */
    private int byoshoSu;

    /**
     * ソートID(パラメータ)
     */
    private String inSortId;

	/**
     * ソートID
     */
    private String sortCondition;

    /**
     * 表示区分
     */
    private String viewKbn;

    /**
     * 管理者権限フラグ
     */
    private boolean knrFlg;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * 武田紐領域別区分
     * @generated
     */
    private String tkdTrtKbn;

    /**
     * 従業員番号
     * @generated
     */
    private String jgiNo;

    /**
     * 氏名
     * @generated
     */
    private String jgiName;

    /**
     * 医薬支店C
     * @generated
     */
    private String BrCd;

    /**
     * 医薬営業所C
     * @generated
     */
    private String DistCd;

    /**
     * 組織コード
     * @generated
     */
    private String sosCd;

    /**
     * 組織ランク
     * @generated
     */
    private String sosRank;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * 施設分類
     * @generated
     */
    private String insClass;

    /**
     * 施設名カナ
     * @generated
     */
    private String shisetsuNmKana;

    /**
     * 郵便番号
     * @generated
     */
    private String yubinNo;

    /**
     * 都道府県コード
     * @generated
     */
    private String todofukenCd;

    /**
     * 都道府県名
     * @generated
     */
    private String addrNamePref;

    /**
     * 市区町村コード
     * @generated
     */
    private String shikuchosonCd;

    /**
     * 市区町村名
     * @generated
     */
    private String addrNameCity;

    /**
     * 武田市区郡コード
     * @generated
     */
    private String tkCityCd;

    /**
     * 武田市区郡名
     * @generated
     */
    private String tkCityName;


    /**
     * コンストラクタ
     * @generated
     */
    public SelectInsListEntity() {
        super("m_rdm_hco_mst" , "selectInsListUlt");

    }
    public SelectInsListEntity(String searchInput) {
        super("m_rdm_hco_mst" , "kanziHenkan");
    }

    public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

	public String getInSearchInput() {
		return inSearchInput;
	}

	public void setInSearchInput(String inSearchInput) {
		this.inSearchInput = inSearchInput;
	}

	public String getInsKanjiSrch() {
		return insKanjiSrch;
	}

	public Integer getInOffset() {
		return inOffset;
	}


	public void setInOffset(Integer inOffset) {
		this.inOffset = inOffset;
	}


	public Integer getInLimit() {
		return inLimit;
	}


	public void setInLimit(Integer inLimit) {
		this.inLimit = inLimit;
	}


	public void setInsKanjiSrch(String insKanjiSrch) {
		this.insKanjiSrch = insKanjiSrch;
	}



    /**
	 * SelectInsListEntity.javainsKanaSrchを設定
	 * @return insKanaSrch
	 */
	public String getInsKanaSrch() {
		return insKanaSrch;
	}
	/**
	 * @param insKanaSrch セットする insKanaSrch
	 */
	public void setInsKanaSrch(String insKanaSrch) {
		this.insKanaSrch = insKanaSrch;
	}

	/**
	 * SelectInsListEntity.javakensakuHaiinKbnを設定
	 * @return kensakuHaiinKbn
	 */
	public String getKensakuHaiinKbn() {
		return kensakuHaiinKbn;
	}
	/**
	 * @param kensakuHaiinKbn セットする kensakuHaiinKbn
	 */
	public void setKensakuHaiinKbn(String kensakuHaiinKbn) {
		this.kensakuHaiinKbn = kensakuHaiinKbn;
	}


	/**
	 * SelectInsListEntity.javakensakuHaiinKbnNullFlgを設定
	 * @return kensakuHaiinKbnNullFlg
	 */
	public String getKensakuHaiinKbnNullFlg() {
		return kensakuHaiinKbnNullFlg;
	}
	/**
	 * @param kensakuHaiinKbnNullFlg セットする kensakuHaiinKbnNullFlg
	 */
	public void setKensakuHaiinKbnNullFlg(String kensakuHaiinKbnNullFlg) {
		this.kensakuHaiinKbnNullFlg = kensakuHaiinKbnNullFlg;
	}
	/**
	 * SelectInsListEntity.javakensakuDelFlgを設定
	 * @return kensakuDelFlg
	 */
	public String getKensakuDelFlg() {
		return kensakuDelFlg;
	}
	/**
	 * @param kensakuDelFlg セットする kensakuDelFlg
	 */
	public void setKensakuDelFlg(String kensakuDelFlg) {
		this.kensakuDelFlg = kensakuDelFlg;
	}
	/**
	 * SelectInsListEntity.javainsNoSrchを設定
	 * @return insNoSrch
	 */
	public String getInsNoSrch() {
		return insNoSrch;
	}

	/**
	 * @param insNoSrch セットする insNoSrch
	 */
	public void setInsNoSrch(String insNoSrch) {
		this.insNoSrch = insNoSrch;
	}

	/**
	 * SelectInsListEntity.javaultNoを設定
	 * @return ultNo
	 */
	public String getUltNo() {
		return ultNo;
	}
	/**
	 * @param ultNo セットする ultNo
	 */
	public void setUltNo(String ultNo) {
		this.ultNo = ultNo;
	}

	/**
	 * SelectInsListEntity.javakensakuManageCdを設定
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
	 * SelectInsListEntity.javakensakuHoInsTypeを設定
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
	 * SelectInsListEntity.javakensakuInsSbtを設定
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
	 * SelectInsListEntity.javapharmTypeを設定
	 * @return pharmType
	 */
	public String getPharmType() {
		return pharmType;
	}
	/**
	 * @param pharmType セットする pharmType
	 */
	public void setPharmType(String pharmType) {
		this.pharmType = pharmType;
	}
	/**
	 * SelectInsListEntity.javaphone1を設定
	 * @return phone1
	 */
	public String getPhone1() {
		return phone1;
	}
	/**
	 * @param phone1 セットする phone1
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	/**
	 * SelectInsListEntity.javainsPcodeを設定
	 * @return insPcode
	 */
	public String getInsPcode() {
		return insPcode;
	}
	/**
	 * @param insPcode セットする insPcode
	 */
	public void setInsPcode(String insPcode) {
		this.insPcode = insPcode;
	}

	/**
	 * SelectInsListEntity.javakoshisetsuCheckを設定
	 * @return koshisetsuCheck
	 */
	public boolean isKoshisetsuCheck() {
		return koshisetsuCheck;
	}
	/**
	 * @param koshisetsuCheck セットする koshisetsuCheck
	 */
	public void setKoshisetsuCheck(boolean koshisetsuCheck) {
		this.koshisetsuCheck = koshisetsuCheck;
	}

	/**
	 * SelectInsListEntity.javakensakuAddrCodePrefを設定
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
	 * SelectInsListEntity.javakensakuAddrCodeCityを設定
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
     * 施設固定コードの取得
     * @return 施設固定コード
     * @generated
     */
    public String getInsNo() {
        return insNo;
    }

	/**
     * 施設固定コードの設定
     * @param insNo 施設固定コード
     * @generated
     */
    public void setInsNo(String insNo) {
        this.insNo = insNo;
    }

    /**
     * 施設略式漢字名の取得
     * @return 施設略式漢字名
     * @generated
     */
    public String getInsAbbrName() {
        return insAbbrName;
    }

    /**
     * 施設略式漢字名の設定
     * @param insAbbrName 施設略式漢字名
     * @generated
     */
    public void setInsAbbrName(String insAbbrName) {
        this.insAbbrName = insAbbrName;
    }

    /**
     * 住所の取得
     * @return 住所
     * @generated
     */
    public String getInsAddr() {
        return insAddr;
    }

    /**
     * 住所の設定
     * @param insAddr 住所
     * @generated
     */
    public void setInsAddr(String insAddr) {
        this.insAddr = insAddr;
    }



    public String getInsFormalName() {
		return insFormalName;
	}

	public void setInsFormalName(String insFormalName) {
		this.insFormalName = insFormalName;
	}

	public String getInsSbt() {
		return insSbt;
	}

	public void setInsSbt(String insSbt) {
		this.insSbt = insSbt;
	}

	public String getManageCd() {
		return manageCd;
	}

	public void setManageCd(String manageCd) {
		this.manageCd = manageCd;
	}

	public int getBedsTot() {
		return bedsTot;
	}

	public void setBedsTot(int bedsTot) {
		this.bedsTot = bedsTot;
	}

	public String getShisetsuNmRyaku() {
		return shisetsuNmRyaku;
	}

	public void setShisetsuNmRyaku(String shisetsuNmRyaku) {
		this.shisetsuNmRyaku = shisetsuNmRyaku;
	}

	public String getShisetsuNm() {
		return shisetsuNm;
	}

	public void setShisetsuNm(String shisetsuNm) {
		this.shisetsuNm = shisetsuNm;
	}

	public String getDcfShisetsuCd() {
		return dcfShisetsuCd;
	}

	public void setDcfShisetsuCd(String dcfShisetsuCd) {
		this.dcfShisetsuCd = dcfShisetsuCd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShisetsuTel() {
		return shisetsuTel;
	}

	public void setShisetsuTel(String shisetsuTel) {
		this.shisetsuTel = shisetsuTel;
	}

	public String getShisetsuKbn() {
		return shisetsuKbn;
	}

	public void setShisetsuKbn(String shisetsuKbn) {
		this.shisetsuKbn = shisetsuKbn;
	}

	public String getKeieitaiCd() {
		return keieitaiCd;
	}

	public void setKeieitaiCd(String keieitaiCd) {
		this.keieitaiCd = keieitaiCd;
	}

	public int getByoshoSu() {
		return byoshoSu;
	}

	public void setByoshoSu(int byoshoSu) {
		this.byoshoSu = byoshoSu;
	}

	/**
	 * SelectInsListEntity.javainSortIdを設定
	 * @return inSortId
	 */
	public String getInSortId() {
		return inSortId;
	}
	/**
	 * @param inSortId セットする inSortId
	 */
	public void setInSortId(String inSortId) {
		this.inSortId = inSortId;
	}

	/**
	 * SelectInsListEntity.javasortConditionを設定
	 * @return sortCondition
	 */
	public String getSortCondition() {
		return sortCondition;
	}
	/**
	 * @param sortCondition セットする sortCondition
	 */
	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}
	/**
	 * SelectInsListEntity.javaviewKbnを設定
	 * @return viewKbn
	 */
	public String getViewKbn() {
		return viewKbn;
	}
	/**
	 * @param viewKbn セットする viewKbn
	 */
	public void setViewKbn(String viewKbn) {
		this.viewKbn = viewKbn;
	}
	/**
	 * SelectInsListEntity.javaknrFlgを設定
	 * @return knrFlg
	 */
	public boolean isKnrFlg() {
		return knrFlg;
	}
	/**
	 * @param knrFlg セットする knrFlg
	 */
	public void setKnrFlg(boolean knrFlg) {
		this.knrFlg = knrFlg;
	}
	/**
	 * SelectInsListEntity.javatrtCdを設定
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
	 * SelectInsListEntity.javatkdTrtKbnを設定
	 * @return tkdTrtKbn
	 */
	public String getTkdTrtKbn() {
		return tkdTrtKbn;
	}
	/**
	 * @param tkdTrtKbn セットする tkdTrtKbn
	 */
	public void setTkdTrtKbn(String tkdTrtKbn) {
		this.tkdTrtKbn = tkdTrtKbn;
	}
	/**
	 * SelectInsListEntity.javajgiNoを設定
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
	 * SelectInsListEntity.javajgiNameを設定
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
	 * SelectInsListEntity.javaBrCdを設定
	 * @return brCd
	 */
	public String getBrCd() {
		return BrCd;
	}
	/**
	 * @param brCd セットする brCd
	 */
	public void setBrCd(String brCd) {
		BrCd = brCd;
	}
	/**
	 * SelectInsListEntity.javaDistCdを設定
	 * @return distCd
	 */
	public String getDistCd() {
		return DistCd;
	}
	/**
	 * @param distCd セットする distCd
	 */
	public void setDistCd(String distCd) {
		DistCd = distCd;
	}
	/**
	 * SelectInsListEntity.javasosCdを設定
	 * @return sosCd
	 */
	public String getSosCd() {
		return sosCd;
	}
	/**
	 * @param sosCd セットする sosCd
	 */
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}
	/**
	 * SelectInsListEntity.javasosRankを設定
	 * @return sosRank
	 */
	public String getSosRank() {
		return sosRank;
	}
	/**
	 * @param sosRank セットする sosRank
	 */
	public void setSosRank(String sosRank) {
		this.sosRank = sosRank;
	}
	/**
	 * SelectInsListEntity.javahoInsTypeを設定
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
	 * SelectInsListEntity.javainsClassを設定
	 * @return insClass
	 */
	public String getInsClass() {
		return insClass;
	}
	/**
	 * @param insClass セットする insClass
	 */
	public void setInsClass(String insClass) {
		this.insClass = insClass;
	}
	/**
	 * SelectInsListEntity.javainsSbtNmを設定
	 * @return insSbtNm
	 */
	public String getInsSbtNm() {
		return insSbtNm;
	}
	/**
	 * @param insSbtNm セットする insSbtNm
	 */
	public void setInsSbtNm(String insSbtNm) {
		this.insSbtNm = insSbtNm;
	}
	/**
	 * SelectInsListEntity.javamanageNmを設定
	 * @return manageNm
	 */
	public String getManageNm() {
		return manageNm;
	}
	/**
	 * @param manageNm セットする manageNm
	 */
	public void setManageNm(String manageNm) {
		this.manageNm = manageNm;
	}
	/**
	 * SelectInsListEntity.javashisetsuKbnNmを設定
	 * @return shisetsuKbnNm
	 */
	public String getShisetsuKbnNm() {
		return shisetsuKbnNm;
	}
	/**
	 * @param shisetsuKbnNm セットする shisetsuKbnNm
	 */
	public void setShisetsuKbnNm(String shisetsuKbnNm) {
		this.shisetsuKbnNm = shisetsuKbnNm;
	}
	/**
	 * SelectInsListEntity.javakeieitaiNmを設定
	 * @return keieitaiNm
	 */
	public String getKeieitaiNm() {
		return keieitaiNm;
	}
	/**
	 * @param keieitaiNm セットする keieitaiNm
	 */
	public void setKeieitaiNm(String keieitaiNm) {
		this.keieitaiNm = keieitaiNm;
	}
	/**
	 * SelectInsListEntity.javashisetsuNmKanaを設定
	 * @return shisetsuNmKana
	 */
	public String getShisetsuNmKana() {
		return shisetsuNmKana;
	}
	/**
	 * @param shisetsuNmKana セットする shisetsuNmKana
	 */
	public void setShisetsuNmKana(String shisetsuNmKana) {
		this.shisetsuNmKana = shisetsuNmKana;
	}
	/**
	 * SelectInsListEntity.javayubinNoを設定
	 * @return yubinNo
	 */
	public String getYubinNo() {
		return yubinNo;
	}
	/**
	 * @param yubinNo セットする yubinNo
	 */
	public void setYubinNo(String yubinNo) {
		this.yubinNo = yubinNo;
	}
	/**
	 * SelectInsListEntity.javatodofukenCdを設定
	 * @return todofukenCd
	 */
	public String getTodofukenCd() {
		return todofukenCd;
	}
	/**
	 * @param todofukenCd セットする todofukenCd
	 */
	public void setTodofukenCd(String todofukenCd) {
		this.todofukenCd = todofukenCd;
	}
	/**
	 * SelectInsListEntity.javaaddrNamePrefを設定
	 * @return addrNamePref
	 */
	public String getAddrNamePref() {
		return addrNamePref;
	}
	/**
	 * @param addrNamePref セットする addrNamePref
	 */
	public void setAddrNamePref(String addrNamePref) {
		this.addrNamePref = addrNamePref;
	}
	/**
	 * SelectInsListEntity.javashikuchosonCdを設定
	 * @return shikuchosonCd
	 */
	public String getShikuchosonCd() {
		return shikuchosonCd;
	}
	/**
	 * @param shikuchosonCd セットする shikuchosonCd
	 */
	public void setShikuchosonCd(String shikuchosonCd) {
		this.shikuchosonCd = shikuchosonCd;
	}
	/**
	 * SelectInsListEntity.javaaddrNameCityを設定
	 * @return addrNameCity
	 */
	public String getAddrNameCity() {
		return addrNameCity;
	}
	/**
	 * @param addrNameCity セットする addrNameCity
	 */
	public void setAddrNameCity(String addrNameCity) {
		this.addrNameCity = addrNameCity;
	}
	/**
	 * SelectInsListEntity.javatkCityCdを設定
	 * @return tkCityCd
	 */
	public String getTkCityCd() {
		return tkCityCd;
	}
	/**
	 * @param tkCityCd セットする tkCityCd
	 */
	public void setTkCityCd(String tkCityCd) {
		this.tkCityCd = tkCityCd;
	}
	/**
	 * SelectInsListEntity.javatkCityNameを設定
	 * @return tkCityName
	 */
	public String getTkCityName() {
		return tkCityName;
	}
	/**
	 * @param tkCityName セットする tkCityName
	 */
	public void setTkCityName(String tkCityName) {
		this.tkCityName = tkCityName;
	}
	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
