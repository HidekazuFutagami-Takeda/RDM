/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;


/**
 * DTOクラス
 * @generated
 */
public class HcoSearchDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 施設正式漢字名
     * @generated
     */
    private String insFormalName;

    /**
     * 施設固定C
     * @generated
     */
    private String insNo;

    /**
     * 施設住所
     * @generated
     */
    private String insAddr;

    /**
     * 電話番号
     * @generated
     */
    private String insPhone1;

    /**
     * 施設種別
     * @generated
     */
    private String insType;

    /**
     * 経営主体
     * @generated
     */
    private String keieitaiKj;

    /**
     * ベッド数計
     * @generated
     */
    private String bedsTot;

    /**
     * 医師数
     * @generated
     */
    private String docCount;

    /**
     * 当期納入計画
     * @generated
     */
    private String plnValue;

    /**
     * 当期納入実績
     * @generated
     */
    private String jskValueTk;

    /**
     * 前期納入実績
     * @generated
     */
    private String jskValueZk;

    /**
     * 前々期納入実績
     * @generated
     */
    private String jskValueZzk;

    /**
     * 廃院区分
     * @generated
     */
    private String delKbn;

    /**
     * 削除フラグ
     * @generated
     */
    private String delFlg;

    /**
     * 施設責任者組織
     * @generated
     */
    private String bumonRyakuName;

    /**
     * 施設責任者
     * @generated
     */
    private String jgiName;

    /**
     * ULT施設略名
     * @generated
     */
    private String shisetsuNmRyaku;

    /**
     * ULT施設名正式名
     * @generated
     */
    private String shisetsuNm;

    /**
     * ULT施設コード
     * @generated
     */
    private String dcfShisetsuCd;

    /**
     * ULT住所
     * @generated
     */
    private String address;

    /**
     * ULT電話番号
     * @generated
     */
    private String shisetsuTel;

    /**
     * ULT施設区分
     * @generated
     */
    private String ultPharmType;

    /**
     * ULT経営主体
     * @generated
     */
    private String ultKeieitaiKj;

    /**
     * ULTベッド数計
     * @generated
     */
    private String byoshoSu;

    /**
     * 機能フラグ1 新規作成
     * @generated
     */
    private String funcFlg1;

    /**
     * 機能フラグ2 編集
     * @generated
     */
    private String funcFlg2;

    /**
     * 機能フラグ3 削除
     * @generated
     */
    private String funcFlg3;

    /**
     * 機能フラグ4 復活
     * @generated
     */
    private String funcFlg4;

    /**
     * 機能フラグ5 親子紐づけ
     * @generated
     */
    private String funcFlg5;

    /**
     * 機能フラグ6 来期用項目更新
     * @generated
     */
    private String funcFlg6;

    /**
     * 機能フラグ7 親子紐付け（来期）
     * @generated
     */
    private String funcFlg7;

    /**
     * MR新規判定フラグ
     * @generated
     */
    private String MrNewFlg;

    /**
     * MR更新判定フラグ
     * @generated
     */
    private String MrUpdFlg;

    /**
     * コンストラクタ
     * @customizable
     */
    public HcoSearchDataList() {
    }

	/**
	 * HcoSearchDataList.javainsAbbrNameを設定
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
	 * HcoSearchDataList.javainsFormalNameを設定
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
	 * HcoSearchDataList.javainsNoを設定
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
	 * HcoSearchDataList.javainsAddrを設定
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
	 * HcoSearchDataList.javainsPhone1を設定
	 * @return insPhone1
	 */
	public String getInsPhone1() {
		return insPhone1;
	}

	/**
	 * @param insPhone1 セットする insPhone1
	 */
	public void setInsPhone1(String insPhone1) {
		this.insPhone1 = insPhone1;
	}

	/**
	 * HcoSearchDataList.javainsTypeを設定
	 * @return insType
	 */
	public String getInsType() {
		return insType;
	}

	/**
	 * @param insType セットする insType
	 */
	public void setInsType(String insType) {
		this.insType = insType;
	}

	/**
	 * HcoSearchDataList.javakeieitaiKjを設定
	 * @return keieitaiKj
	 */
	public String getKeieitaiKj() {
		return keieitaiKj;
	}

	/**
	 * @param keieitaiKj セットする keieitaiKj
	 */
	public void setKeieitaiKj(String keieitaiKj) {
		this.keieitaiKj = keieitaiKj;
	}

	/**
	 * HcoSearchDataList.javabedsTotを設定
	 * @return bedsTot
	 */
	public String getBedsTot() {
		return bedsTot;
	}

	/**
	 * @param bedsTot セットする bedsTot
	 */
	public void setBedsTot(String bedsTot) {
		this.bedsTot = bedsTot;
	}

	/**
	 * HcoSearchDataList.javadocCountを設定
	 * @return docCount
	 */
	public String getDocCount() {
		return docCount;
	}

	/**
	 * @param docCount セットする docCount
	 */
	public void setDocCount(String docCount) {
		this.docCount = docCount;
	}

	/**
	 * HcoSearchDataList.javaplnValueを設定
	 * @return plnValue
	 */
	public String getPlnValue() {
		return plnValue;
	}

	/**
	 * @param plnValue セットする plnValue
	 */
	public void setPlnValue(String plnValue) {
		this.plnValue = plnValue;
	}

	/**
	 * HcoSearchDataList.javajskValueTkを設定
	 * @return jskValueTk
	 */
	public String getJskValueTk() {
		return jskValueTk;
	}

	/**
	 * @param jskValueTk セットする jskValueTk
	 */
	public void setJskValueTk(String jskValueTk) {
		this.jskValueTk = jskValueTk;
	}

	/**
	 * HcoSearchDataList.javajskValueZkを設定
	 * @return jskValueZk
	 */
	public String getJskValueZk() {
		return jskValueZk;
	}

	/**
	 * @param jskValueZk セットする jskValueZk
	 */
	public void setJskValueZk(String jskValueZk) {
		this.jskValueZk = jskValueZk;
	}

	/**
	 * HcoSearchDataList.javajskValueZzkを設定
	 * @return jskValueZzk
	 */
	public String getJskValueZzk() {
		return jskValueZzk;
	}

	/**
	 * @param jskValueZzk セットする jskValueZzk
	 */
	public void setJskValueZzk(String jskValueZzk) {
		this.jskValueZzk = jskValueZzk;
	}

	/**
	 * HcoSearchDataList.javadelKbnを設定
	 * @return delKbn
	 */
	public String getDelKbn() {
		return delKbn;
	}

	/**
	 * @param delKbn セットする delKbn
	 */
	public void setDelKbn(String delKbn) {
		this.delKbn = delKbn;
	}

	/**
	 * HcoSearchDataList.javadelFlgを設定
	 * @return delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg セットする delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * HcoSearchDataList.javabumonRyakuNameを設定
	 * @return bumonRyakuName
	 */
	public String getBumonRyakuName() {
		return bumonRyakuName;
	}

	/**
	 * @param bumonRyakuName セットする bumonRyakuName
	 */
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
	}

	/**
	 * HcoSearchDataList.javajgiNameを設定
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
	 * HcoSearchDataList.javashisetsuNmRyakuを設定
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
	 * HcoSearchDataList.javashisetsuNmを設定
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
	 * HcoSearchDataList.javadcfShisetsuCdを設定
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
	 * HcoSearchDataList.javaaddressを設定
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
	 * HcoSearchDataList.javashisetsuTelを設定
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
	 * HcoSearchDataList.javaultPharmTypeを設定
	 * @return ultPharmType
	 */
	public String getUltPharmType() {
		return ultPharmType;
	}

	/**
	 * @param ultPharmType セットする ultPharmType
	 */
	public void setUltPharmType(String ultPharmType) {
		this.ultPharmType = ultPharmType;
	}

	/**
	 * HcoSearchDataList.javaultKeieitaiKjを設定
	 * @return ultKeieitaiKj
	 */
	public String getUltKeieitaiKj() {
		return ultKeieitaiKj;
	}

	/**
	 * @param ultKeieitaiKj セットする ultKeieitaiKj
	 */
	public void setUltKeieitaiKj(String ultKeieitaiKj) {
		this.ultKeieitaiKj = ultKeieitaiKj;
	}

	/**
	 * HcoSearchDataList.javabyoshoSuを設定
	 * @return byoshoSu
	 */
	public String getByoshoSu() {
		return byoshoSu;
	}

	/**
	 * @param byoshoSu セットする byoshoSu
	 */
	public void setByoshoSu(String byoshoSu) {
		this.byoshoSu = byoshoSu;
	}

	/**
	 * HcoSearchDataList.javafuncFlg1を設定
	 * @return funcFlg1
	 */
	public String getFuncFlg1() {
		return funcFlg1;
	}

	/**
	 * @param funcFlg1 セットする funcFlg1
	 */
	public void setFuncFlg1(String funcFlg1) {
		this.funcFlg1 = funcFlg1;
	}

	/**
	 * HcoSearchDataList.javafuncFlg2を設定
	 * @return funcFlg2
	 */
	public String getFuncFlg2() {
		return funcFlg2;
	}

	/**
	 * @param funcFlg2 セットする funcFlg2
	 */
	public void setFuncFlg2(String funcFlg2) {
		this.funcFlg2 = funcFlg2;
	}

	/**
	 * HcoSearchDataList.javafuncFlg3を設定
	 * @return funcFlg3
	 */
	public String getFuncFlg3() {
		return funcFlg3;
	}

	/**
	 * @param funcFlg3 セットする funcFlg3
	 */
	public void setFuncFlg3(String funcFlg3) {
		this.funcFlg3 = funcFlg3;
	}

	/**
	 * HcoSearchDataList.javafuncFlg4を設定
	 * @return funcFlg4
	 */
	public String getFuncFlg4() {
		return funcFlg4;
	}

	/**
	 * @param funcFlg4 セットする funcFlg4
	 */
	public void setFuncFlg4(String funcFlg4) {
		this.funcFlg4 = funcFlg4;
	}

	/**
	 * HcoSearchDataList.javafuncFlg5を設定
	 * @return funcFlg5
	 */
	public String getFuncFlg5() {
		return funcFlg5;
	}

	/**
	 * @param funcFlg5 セットする funcFlg5
	 */
	public void setFuncFlg5(String funcFlg5) {
		this.funcFlg5 = funcFlg5;
	}

	/**
	 * HcoSearchDataList.javafuncFlg6を設定
	 * @return funcFlg6
	 */
	public String getFuncFlg6() {
		return funcFlg6;
	}

	/**
	 * @param funcFlg6 セットする funcFlg6
	 */
	public void setFuncFlg6(String funcFlg6) {
		this.funcFlg6 = funcFlg6;
	}

	/**
	 * HcoSearchDataList.javafuncFlg7を設定
	 * @return funcFlg7
	 */
	public String getFuncFlg7() {
		return funcFlg7;
	}

	/**
	 * @param funcFlg7 セットする funcFlg7
	 */
	public void setFuncFlg7(String funcFlg7) {
		this.funcFlg7 = funcFlg7;
	}

	/**
	 * HcoSearchDataList.javaMrNewFlgを設定
	 * @return mrNewFlg
	 */
	public String getMrNewFlg() {
		return MrNewFlg;
	}

	/**
	 * @param mrNewFlg セットする mrNewFlg
	 */
	public void setMrNewFlg(String mrNewFlg) {
		MrNewFlg = mrNewFlg;
	}

	/**
	 * HcoSearchDataList.javaMrUpdFlgを設定
	 * @return mrUpdFlg
	 */
	public String getMrUpdFlg() {
		return MrUpdFlg;
	}

	/**
	 * @param mrUpdFlg セットする mrUpdFlg
	 */
	public void setMrUpdFlg(String mrUpdFlg) {
		MrUpdFlg = mrUpdFlg;
	}
}

