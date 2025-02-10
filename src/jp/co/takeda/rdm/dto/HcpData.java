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
public class HcpData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 氏名（漢字）
     */
    private String docKanj;

    /**
     * 氏名カナ
     */
    private String docKana;

    /**
     * 医師固定C
     */
    private String docNo;

    /**
     * 生年月日
     */
    private String dob;

    /**
     * 出身校
     */
    private String univKj;

    /**
     * 卒年
     */
    private String grdaYear;

    /**
     * 医師／薬剤師区分
     */
    private String docKbn;

    /**
     * 出身医局校
     */
    private String ikyokuKj;


    /**
     * 施設略式漢字名（所属部科名：役職名）
     */
    private String insName;

    /**
     * 旧姓
     */
    private String oldKanjSei;

    /**
     * 医師名
     */
    private String ishiNm;

    /**
     * ULT医師名カナ
     */
    private String ishiNmKana;

    /**
     * DCF医師コード
     */
    private String dcfIshiCd;

    /**
     * ULT生年月日
     */
    private String ultDob;

    /**
     * ULT出身校
     */
    private String ultUnivKj;

    /**
     * ULT卒年
     */
    private String sotsunenSr;

    /**
     * ULT施設名（所属部科名：役職名）
     */
    private String ultInsName;


    /**
     * 新規作成フラグ
     */
    private String gamenShinkiFlg;

    /**
     * 情報更新フラグ
     */
    private String gamenKoushinFlg;

    /**
     * 勤務先情報更新フラグ
     */
    private String gamenKinmuKoushinFlg;

    /**
     * 復活フラグ
     */
    private String gamenFukkatsuFlg;

    /**
     * MR新規判定フラグ
     */
    private String mrShinkiFlg;

    /**
     * MR更新判定フラグ
     */
    private String mrKoushinFlg;

    /**
     * コンストラクタ
     * @customizable
     */
    public HcpData() {
        // START UOC

        // END UOC
    }


	/**
	 * HcpData.javadocKanjを設定
	 * @return docKanj
	 */
	public String getDocKanj() {
		return docKanj;
	}


	/**
	 * @param docKanj セットする docKanj
	 */
	public void setDocKanj(String docKanj) {
		this.docKanj = docKanj;
	}


	/**
	 * HcpData.javadocKanaを設定
	 * @return docKana
	 */
	public String getDocKana() {
		return docKana;
	}


	/**
	 * @param docKana セットする docKana
	 */
	public void setDocKana(String docKana) {
		this.docKana = docKana;
	}


	/**
	 * HcpData.javadocNoを設定
	 * @return docNo
	 */
	public String getDocNo() {
		return docNo;
	}


	/**
	 * @param docNo セットする docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}


	/**
	 * HcpData.javadobを設定
	 * @return dob
	 */
	public String getDob() {
		return dob;
	}


	/**
	 * @param dob セットする dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}


	/**
	 * HcpData.javaunivKjを設定
	 * @return univKj
	 */
	public String getUnivKj() {
		return univKj;
	}


	/**
	 * @param univKj セットする univKj
	 */
	public void setUnivKj(String univKj) {
		this.univKj = univKj;
	}


	/**
	 * HcpData.javagrdaYearを設定
	 * @return grdaYear
	 */
	public String getGrdaYear() {
		return grdaYear;
	}


	/**
	 * @param grdaYear セットする grdaYear
	 */
	public void setGrdaYear(String grdaYear) {
		this.grdaYear = grdaYear;
	}


	/**
	 * HcpData.javadocKbnを設定
	 * @return docKbn
	 */
	public String getDocKbn() {
		return docKbn;
	}


	/**
	 * @param docKbn セットする docKbn
	 */
	public void setDocKbn(String docKbn) {
		this.docKbn = docKbn;
	}


	/**
	 * HcpData.javaikyokuKjを設定
	 * @return ikyokuKj
	 */
	public String getIkyokuKj() {
		return ikyokuKj;
	}


	/**
	 * @param ikyokuKj セットする ikyokuKj
	 */
	public void setIkyokuKj(String ikyokuKj) {
		this.ikyokuKj = ikyokuKj;
	}


	/**
	 * HcpData.javainsNameを設定
	 * @return insName
	 */
	public String getInsName() {
		return insName;
	}


	/**
	 * @param insName セットする insName
	 */
	public void setInsName(String insName) {
		this.insName = insName;
	}


	/**
	 * HcpData.javaoldKanjSeiを設定
	 * @return oldKanjSei
	 */
	public String getOldKanjSei() {
		return oldKanjSei;
	}


	/**
	 * @param oldKanjSei セットする oldKanjSei
	 */
	public void setOldKanjSei(String oldKanjSei) {
		this.oldKanjSei = oldKanjSei;
	}


	/**
	 * HcpData.javaishiNmを設定
	 * @return ishiNm
	 */
	public String getIshiNm() {
		return ishiNm;
	}


	/**
	 * @param ishiNm セットする ishiNm
	 */
	public void setIshiNm(String ishiNm) {
		this.ishiNm = ishiNm;
	}


	/**
	 * HcpData.javaishiNmKanaを設定
	 * @return ishiNmKana
	 */
	public String getIshiNmKana() {
		return ishiNmKana;
	}


	/**
	 * @param ishiNmKana セットする ishiNmKana
	 */
	public void setIshiNmKana(String ishiNmKana) {
		this.ishiNmKana = ishiNmKana;
	}


	/**
	 * HcpData.javadcfIshiCdを設定
	 * @return dcfIshiCd
	 */
	public String getDcfIshiCd() {
		return dcfIshiCd;
	}


	/**
	 * @param dcfIshiCd セットする dcfIshiCd
	 */
	public void setDcfIshiCd(String dcfIshiCd) {
		this.dcfIshiCd = dcfIshiCd;
	}


	/**
	 * HcpData.javaultDobを設定
	 * @return ultDob
	 */
	public String getUltDob() {
		return ultDob;
	}


	/**
	 * @param ultDob セットする ultDob
	 */
	public void setUltDob(String ultDob) {
		this.ultDob = ultDob;
	}


	/**
	 * HcpData.javaultUnivKjを設定
	 * @return ultUnivKj
	 */
	public String getUltUnivKj() {
		return ultUnivKj;
	}


	/**
	 * @param ultUnivKj セットする ultUnivKj
	 */
	public void setUltUnivKj(String ultUnivKj) {
		this.ultUnivKj = ultUnivKj;
	}


	/**
	 * HcpData.javasotsunenSrを設定
	 * @return sotsunenSr
	 */
	public String getSotsunenSr() {
		return sotsunenSr;
	}


	/**
	 * @param sotsunenSr セットする sotsunenSr
	 */
	public void setSotsunenSr(String sotsunenSr) {
		this.sotsunenSr = sotsunenSr;
	}


	/**
	 * HcpData.javaultInsNameを設定
	 * @return ultInsName
	 */
	public String getUltInsName() {
		return ultInsName;
	}


	/**
	 * @param ultInsName セットする ultInsName
	 */
	public void setUltInsName(String ultInsName) {
		this.ultInsName = ultInsName;
	}

	/**
	 * HcpData.javagamenShinkiFlgを設定
	 * @return gamenShinkiFlg
	 */
	public String getGamenShinkiFlg() {
		return gamenShinkiFlg;
	}


	/**
	 * @param gamenShinkiFlg セットする gamenShinkiFlg
	 */
	public void setGamenShinkiFlg(String gamenShinkiFlg) {
		this.gamenShinkiFlg = gamenShinkiFlg;
	}


	/**
	 * HcpData.javagamenKoushinFlgを設定
	 * @return gamenKoushinFlg
	 */
	public String getGamenKoushinFlg() {
		return gamenKoushinFlg;
	}


	/**
	 * @param gamenKoushinFlg セットする gamenKoushinFlg
	 */
	public void setGamenKoushinFlg(String gamenKoushinFlg) {
		this.gamenKoushinFlg = gamenKoushinFlg;
	}


	/**
	 * HcpData.javagamenKinmuKoushinFlgを設定
	 * @return gamenKinmuKoushinFlg
	 */
	public String getGamenKinmuKoushinFlg() {
		return gamenKinmuKoushinFlg;
	}


	/**
	 * @param gamenKinmuKoushinFlg セットする gamenKinmuKoushinFlg
	 */
	public void setGamenKinmuKoushinFlg(String gamenKinmuKoushinFlg) {
		this.gamenKinmuKoushinFlg = gamenKinmuKoushinFlg;
	}


	/**
	 * HcpData.javagamenFukkatsuFlgを設定
	 * @return gamenFukkatsuFlg
	 */
	public String getGamenFukkatsuFlg() {
		return gamenFukkatsuFlg;
	}


	/**
	 * @param gamenFukkatsuFlg セットする gamenFukkatsuFlg
	 */
	public void setGamenFukkatsuFlg(String gamenFukkatsuFlg) {
		this.gamenFukkatsuFlg = gamenFukkatsuFlg;
	}


	/**
	 * HcpData.javamrShinkiFlgを設定
	 * @return mrShinkiFlg
	 */
	public String getMrShinkiFlg() {
		return mrShinkiFlg;
	}


	/**
	 * @param mrShinkiFlg セットする mrShinkiFlg
	 */
	public void setMrShinkiFlg(String mrShinkiFlg) {
		this.mrShinkiFlg = mrShinkiFlg;
	}


	/**
	 * HcpData.javamrKoushinFlgを設定
	 * @return mrKoushinFlg
	 */
	public String getMrKoushinFlg() {
		return mrKoushinFlg;
	}


	/**
	 * @param mrKoushinFlg セットする mrKoushinFlg
	 */
	public void setMrKoushinFlg(String mrKoushinFlg) {
		this.mrKoushinFlg = mrKoushinFlg;
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

