/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

import java.util.List;

/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_HCP_MST
 * SQLID : selectCntHco
 */
public class SelectCntSelectHcoEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師検索表示件数
     */
    private Integer cntHco;

    /**
     * 施設略式漢字名
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
     * 検索用＿廃院区分
     * @generated
     */
    private String kensakuDelFlg;

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
     * 検索条件_施設区分
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
     * 施設固定コード
     * @generated
     */
    private String insNoSrch;

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
     * JIS府県名
     * @generated
     */
    private String insSbt;

    /**
     * 武田市区郡コード
     * @generated
     */
    private String manageCd;

    /**
     * 武田市区郡名
     * @generated
     */
    private int bedsTot;

    /**
     * レコード件数
     * @generated
     */
    private String shisetsuNmRyaku;

    /**
     * レコード件数
     * @generated
     */
    private String shisetsuNm;

    /**
     * レコード件数
     * @generated
     */
    private String dcfShisetsuCd;

    /**
     * レコード件数
     * @generated
     */
    private String address;

    /**
     * レコード件数
     * @generated
     */
    private String shisetsuTel;

    /**
     * レコード件数
     * @generated
     */
    private String shisetsuKbn;

    /**
     * レコード件数
     * @generated
     */
    private String keieitaiCd;

    /**
     * レコード件数
     * @generated
     */
    private int byoshoSu;

	/**
     * ソートID
     */
    private String sortCondition;

    /**
     * ソートID(パラメータ)
     */
    private String inSortId;


    /**
     * コンストラクタ
     */
    public SelectCntSelectHcoEntity() {
        super("m_rdm_hco_mst" , "selectCntHco");
    }

	/**
	 * SelectParamSelectHcoEntity.javaCntHcoを設定
	 * @return cntHco
	 */
	public Integer getCntHco() {
		return cntHco;
	}

	/**
	 * @param cntHco セットする cntHco
	 */
	public void setCntHco(Integer cntHco) {
		this.cntHco = cntHco;
	}


	/**
	 * SelectCntSelectHcoEntity.javainsKanjiSrchを設定
	 * @return insKanjiSrch
	 */
	public String getInsKanjiSrch() {
		return insKanjiSrch;
	}

	/**
	 * @param insKanjiSrch セットする insKanjiSrch
	 */
	public void setInsKanjiSrch(String insKanjiSrch) {
		this.insKanjiSrch = insKanjiSrch;
	}

	/**
	 * SelectCntSelectHcoEntity.javainsKanaSrchを設定
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
	 * SelectCntSelectHcoEntity.javainsNoSrchを設定
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
	 * SelectCntSelectHcoEntity.javakensakuHaiinKbnを設定
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
	 * SelectCntSelectHcoEntity.javakensakuDelFlgを設定
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
	 * SelectCntSelectHcoEntity.javaultNoを設定
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
	 * SelectCntSelectHcoEntity.javakensakuManageCdを設定
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
	 * SelectCntSelectHcoEntity.javakensakuHoInsTypeを設定
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
	 * SelectCntSelectHcoEntity.javakensakuInsSbtを設定
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
	 * SelectCntSelectHcoEntity.javapharmTypeを設定
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
	 * SelectCntSelectHcoEntity.javaphone1を設定
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
	 * SelectCntSelectHcoEntity.javainsPcodeを設定
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
	 * SelectCntSelectHcoEntity.javakoshisetsuCheckを設定
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
	 * SelectCntSelectHcoEntity.javakensakuAddrCodePrefを設定
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
	 * SelectCntSelectHcoEntity.javakensakuAddrCodeCityを設定
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
	 * SelectCntSelectHcoEntity.javabyoshoSuを設定
	 * @return byoshoSu
	 */
	public int getByoshoSu() {
		return byoshoSu;
	}

	/**
	 * @param byoshoSu セットする byoshoSu
	 */
	public void setByoshoSu(int byoshoSu) {
		this.byoshoSu = byoshoSu;
	}

	/**
	 * SelectCntSelectHcoEntity.javainsNoを設定
	 * @return insNo
	 */
	public String getInsNo() {
		return insNo;
	}

	/**
	 * @param insNo セットする insNo
	 */
	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	/**
	 * SelectCntSelectHcoEntity.javainsAbbrNameを設定
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
	 * SelectCntSelectHcoEntity.javainsFormalNameを設定
	 * @return insFormalName
	 */
	public String getInsFormalName() {
		return insFormalName;
	}

	/**
	 * @param insFormalName セットする insFormalName
	 */
	public void setInsFormalName(String insFormalName) {
		this.insFormalName = insFormalName;
	}

	/**
	 * SelectCntSelectHcoEntity.javainsAddrを設定
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
	 * SelectCntSelectHcoEntity.javainsSbtを設定
	 * @return insSbt
	 */
	public String getInsSbt() {
		return insSbt;
	}

	/**
	 * @param insSbt セットする insSbt
	 */
	public void setInsSbt(String insSbt) {
		this.insSbt = insSbt;
	}

	/**
	 * SelectCntSelectHcoEntity.javamanageCdを設定
	 * @return manageCd
	 */
	public String getManageCd() {
		return manageCd;
	}

	/**
	 * @param manageCd セットする manageCd
	 */
	public void setManageCd(String manageCd) {
		this.manageCd = manageCd;
	}

	/**
	 * SelectCntSelectHcoEntity.javabedsTotを設定
	 * @return bedsTot
	 */
	public int getBedsTot() {
		return bedsTot;
	}

	/**
	 * @param bedsTot セットする bedsTot
	 */
	public void setBedsTot(int bedsTot) {
		this.bedsTot = bedsTot;
	}

	/**
	 * SelectCntSelectHcoEntity.javashisetsuNmRyakuを設定
	 * @return shisetsuNmRyaku
	 */
	public String getShisetsuNmRyaku() {
		return shisetsuNmRyaku;
	}

	/**
	 * @param shisetsuNmRyaku セットする shisetsuNmRyaku
	 */
	public void setShisetsuNmRyaku(String shisetsuNmRyaku) {
		this.shisetsuNmRyaku = shisetsuNmRyaku;
	}

	/**
	 * SelectCntSelectHcoEntity.javashisetsuNmを設定
	 * @return shisetsuNm
	 */
	public String getShisetsuNm() {
		return shisetsuNm;
	}

	/**
	 * @param shisetsuNm セットする shisetsuNm
	 */
	public void setShisetsuNm(String shisetsuNm) {
		this.shisetsuNm = shisetsuNm;
	}

	/**
	 * SelectCntSelectHcoEntity.javadcfShisetsuCdを設定
	 * @return dcfShisetsuCd
	 */
	public String getDcfShisetsuCd() {
		return dcfShisetsuCd;
	}

	/**
	 * @param dcfShisetsuCd セットする dcfShisetsuCd
	 */
	public void setDcfShisetsuCd(String dcfShisetsuCd) {
		this.dcfShisetsuCd = dcfShisetsuCd;
	}

	/**
	 * SelectCntSelectHcoEntity.javaaddressを設定
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * SelectCntSelectHcoEntity.javashisetsuTelを設定
	 * @return shisetsuTel
	 */
	public String getShisetsuTel() {
		return shisetsuTel;
	}

	/**
	 * @param shisetsuTel セットする shisetsuTel
	 */
	public void setShisetsuTel(String shisetsuTel) {
		this.shisetsuTel = shisetsuTel;
	}

	/**
	 * SelectCntSelectHcoEntity.javashisetsuKbnを設定
	 * @return shisetsuKbn
	 */
	public String getShisetsuKbn() {
		return shisetsuKbn;
	}

	/**
	 * @param shisetsuKbn セットする shisetsuKbn
	 */
	public void setShisetsuKbn(String shisetsuKbn) {
		this.shisetsuKbn = shisetsuKbn;
	}

	/**
	 * SelectCntSelectHcoEntity.javakeieitaiCdを設定
	 * @return keieitaiCd
	 */
	public String getKeieitaiCd() {
		return keieitaiCd;
	}

	/**
	 * @param keieitaiCd セットする keieitaiCd
	 */
	public void setKeieitaiCd(String keieitaiCd) {
		this.keieitaiCd = keieitaiCd;
	}

	/**
	 * SelectCntSelectHcoEntity.javabyoshoSuを設定
	 * @return byoshoSu
	 */
	public int getByosyoSu() {
		return byoshoSu;
	}

	/**
	 * @param byoshoSu セットする byoshoSu
	 */
	public void setByosyoSu(int byoshoSu) {
		this.byoshoSu = byoshoSu;
	}

	/**
	 * SelectCntSelectHcoEntity.javainSortIdを設定
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
	 * SelectCntSelectHcoEntity.javasortConditionを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
