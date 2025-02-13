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
 * SQLID : selectHcp
 */
public class SelectHcpEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;


    /**
     * Offset値
     */
    private Integer inOffset;

    /**
     * Limit値
     */
    private Integer inLimit;

    /**
     * 組織(パラメータ)
     */
    private String inSosCd;

    /**
     * 担当者(パラメータ)
     */
    private String inJgiNo;

    /**
     * 氏名漢字(全角)(パラメータ)
     */
    private String inKanjiSrch;

    /**
     * 氏名カナ(半角カナ)(パラメータ)
     */
    private String inKanaSrch;

    /**
     * 医師／薬剤師区分(パラメータ)
     */
    private String inDocType;

    /**
     * 医師固定C(パラメータ)
     */
    private String inDocNo;

    /**
     * ULT医師コード(パラメータ)
     */
    private String inDcfIshiCd;

    /**
     * 医師属性(パラメータ)
     */
    private String inDocAttribute;

    /**
     * 出身校(パラメータ)
     */
    private String inMedSch;

    /**
     * 卒年(パラメータ)
     */
    private String inGradYear;

    /**
     * 出身医局校(パラメータ)
     */
    private String inHUniv;

    /**
     * 武田-ULT接続情報(パラメータ)
     */
    private String inSetsuzoku;

    /**
     * 部門ランク(パラメータ)
     */
    private String inGmnBumonRank;

    /**
     * 組織選択(パラメータ)
     */
    private String inGmnSosCd;

    /**
     * 担当者選択(パラメータ)
     */
    private String inGmnJgiNo;

    /**
     * 医薬支店C(パラメータ)
     */
    private String inGmnBrCode;

    /**
     * 医薬営業所C(パラメータ)
     */
    private String inGmnDistCode;

    /**
     * 施設固定C(パラメータ)
     */
    private String inInsNo;

    /**
     * 所属部科コード(パラメータ)
     */
    private String inDeptCode;

    /**
     * ソートID(パラメータ)
     */
    private String inSortId;

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
     * 機能フラグ１（新規作成）
     */
    private String shinkiFlg;

    /**
     * 機能フラグ２（編集）
     */
    private String henshuFlg;

    /**
     * 機能フラグ３（復活）
     */
    private String fukkatsuFlg;

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
     * @generated
     */
    public SelectHcpEntity() {
        super("m_rdm_hcp_mst" , "selectHcp");
    }

	/**
	 * SelectHcpEntity.javainOffsetを設定
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
	 * SelectHcpEntity.javainLimitを設定
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

	/**
	 * SelectHcpEntity.javainSosCdを設定
	 * @return inSosCd
	 */
	public String getInSosCd() {
		return inSosCd;
	}

	/**
	 * @param inSosCd セットする inSosCd
	 */
	public void setInSosCd(String inSosCd) {
		this.inSosCd = inSosCd;
	}

	/**
	 * SelectHcpEntity.javainJgiNoを設定
	 * @return inJgiNo
	 */
	public String getInJgiNo() {
		return inJgiNo;
	}

	/**
	 * @param inJgiNo セットする inJgiNo
	 */
	public void setInJgiNo(String inJgiNo) {
		this.inJgiNo = inJgiNo;
	}

	/**
	 * SelectHcpEntity.javainKanjiSrchを設定
	 * @return inKanjiSrch
	 */
	public String getInKanjiSrch() {
		return inKanjiSrch;
	}

	/**
	 * @param inKanjiSrch セットする inKanjiSrch
	 */
	public void setInKanjiSrch(String inKanjiSrch) {
		this.inKanjiSrch = inKanjiSrch;
	}

	/**
	 * SelectHcpEntity.javainKanaSrchを設定
	 * @return inKanaSrch
	 */
	public String getInKanaSrch() {
		return inKanaSrch;
	}

	/**
	 * @param inKanaSrch セットする inKanaSrch
	 */
	public void setInKanaSrch(String inKanaSrch) {
		this.inKanaSrch = inKanaSrch;
	}

	/**
	 * SelectHcpEntity.javainDocTypeを設定
	 * @return inDocType
	 */
	public String getInDocType() {
		return inDocType;
	}

	/**
	 * @param inDocType セットする inDocType
	 */
	public void setInDocType(String inDocType) {
		this.inDocType = inDocType;
	}

	/**
	 * SelectHcpEntity.javainDocNoを設定
	 * @return inDocNo
	 */
	public String getInDocNo() {
		return inDocNo;
	}

	/**
	 * @param inDocNo セットする inDocNo
	 */
	public void setInDocNo(String inDocNo) {
		this.inDocNo = inDocNo;
	}

	/**
	 * SelectHcpEntity.javainDcfIshiCdを設定
	 * @return inDcfIshiCd
	 */
	public String getInDcfIshiCd() {
		return inDcfIshiCd;
	}

	/**
	 * @param inDcfIshiCd セットする inDcfIshiCd
	 */
	public void setInDcfIshiCd(String inDcfIshiCd) {
		this.inDcfIshiCd = inDcfIshiCd;
	}

	/**
	 * SelectHcpEntity.javainDocAttributeを設定
	 * @return inDocAttribute
	 */
	public String getInDocAttribute() {
		return inDocAttribute;
	}

	/**
	 * @param inDocAttribute セットする inDocAttribute
	 */
	public void setInDocAttribute(String inDocAttribute) {
		this.inDocAttribute = inDocAttribute;
	}

	/**
	 * SelectHcpEntity.javainMedSchを設定
	 * @return inMedSch
	 */
	public String getInMedSch() {
		return inMedSch;
	}

	/**
	 * @param inMedSch セットする inMedSch
	 */
	public void setInMedSch(String inMedSch) {
		this.inMedSch = inMedSch;
	}

	/**
	 * SelectHcpEntity.javainGradYearを設定
	 * @return inGradYear
	 */
	public String getInGradYear() {
		return inGradYear;
	}

	/**
	 * @param inGradYear セットする inGradYear
	 */
	public void setInGradYear(String inGradYear) {
		this.inGradYear = inGradYear;
	}

	/**
	 * SelectHcpEntity.javainHUnivを設定
	 * @return inHUniv
	 */
	public String getInHUniv() {
		return inHUniv;
	}

	/**
	 * @param inHUniv セットする inHUniv
	 */
	public void setInHUniv(String inHUniv) {
		this.inHUniv = inHUniv;
	}

	/**
	 * SelectHcpEntity.javainSetsuzokuを設定
	 * @return inSetsuzoku
	 */
	public String getInSetsuzoku() {
		return inSetsuzoku;
	}

	/**
	 * @param inSetsuzoku セットする inSetsuzoku
	 */
	public void setInSetsuzoku(String inSetsuzoku) {
		this.inSetsuzoku = inSetsuzoku;
	}

	/**
	 * SelectHcpEntity.javainGmnBumonRankを設定
	 * @return inGmnBumonRank
	 */
	public String getInGmnBumonRank() {
		return inGmnBumonRank;
	}

	/**
	 * @param inGmnBumonRank セットする inGmnBumonRank
	 */
	public void setInGmnBumonRank(String inGmnBumonRank) {
		this.inGmnBumonRank = inGmnBumonRank;
	}

	/**
	 * SelectHcpEntity.javainGmnSosCdを設定
	 * @return inGmnSosCd
	 */
	public String getInGmnSosCd() {
		return inGmnSosCd;
	}

	/**
	 * @param inGmnSosCd セットする inGmnSosCd
	 */
	public void setInGmnSosCd(String inGmnSosCd) {
		this.inGmnSosCd = inGmnSosCd;
	}

	/**
	 * SelectHcpEntity.javainGmnJgiNoを設定
	 * @return inGmnJgiNo
	 */
	public String getInGmnJgiNo() {
		return inGmnJgiNo;
	}

	/**
	 * @param inGmnJgiNo セットする inGmnJgiNo
	 */
	public void setInGmnJgiNo(String inGmnJgiNo) {
		this.inGmnJgiNo = inGmnJgiNo;
	}

	/**
	 * SelectHcpEntity.javainGmnBrCodeを設定
	 * @return inGmnBrCode
	 */
	public String getInGmnBrCode() {
		return inGmnBrCode;
	}

	/**
	 * @param inGmnBrCode セットする inGmnBrCode
	 */
	public void setInGmnBrCode(String inGmnBrCode) {
		this.inGmnBrCode = inGmnBrCode;
	}

	/**
	 * SelectHcpEntity.javainGmnDistCodeを設定
	 * @return inGmnDistCode
	 */
	public String getInGmnDistCode() {
		return inGmnDistCode;
	}

	/**
	 * @param inGmnDistCode セットする inGmnDistCode
	 */
	public void setInGmnDistCode(String inGmnDistCode) {
		this.inGmnDistCode = inGmnDistCode;
	}

	/**
	 * SelectHcpEntity.javainInsNoを設定
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
	 * SelectHcpEntity.javainDeptCodeを設定
	 * @return inDeptCode
	 */
	public String getInDeptCode() {
		return inDeptCode;
	}

	/**
	 * @param inDeptCode セットする inDeptCode
	 */
	public void setInDeptCode(String inDeptCode) {
		this.inDeptCode = inDeptCode;
	}

	/**
	 * SelectHcpEntity.javainSortIdを設定
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
	 * SelectHcpEntity.javadocKanjを設定
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
	 * SelectHcpEntity.javadocKanaを設定
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
	 * SelectHcpEntity.javadocNoを設定
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
	 * SelectHcpEntity.javadobを設定
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
	 * SelectHcpEntity.javaunivKjを設定
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
	 * SelectHcpEntity.javagrdaYearを設定
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
	 * SelectHcpEntity.javadocKbnを設定
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
	 * SelectHcpEntity.javaikyokuKjを設定
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
	 * SelectHcpEntity.javainsNameを設定
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
	 * SelectHcpEntity.javaoldKanjSeiを設定
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
	 * SelectHcpEntity.javaishiNmを設定
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
	 * SelectHcpEntity.javaishiNmKanaを設定
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
	 * SelectHcpEntity.javadcfIshiCdを設定
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
	 * SelectHcpEntity.javaultDobを設定
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
	 * SelectHcpEntity.javaultUnivKjを設定
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
	 * SelectHcpEntity.javasotsunenSrを設定
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
	 * SelectHcpEntity.javaultInsNameを設定
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
	 * SelectHcpEntity.javashinkiFlgを設定
	 * @return shinkiFlg
	 */
	public String getShinkiFlg() {
		return shinkiFlg;
	}

	/**
	 * @param shinkiFlg セットする shinkiFlg
	 */
	public void setShinkiFlg(String shinkiFlg) {
		this.shinkiFlg = shinkiFlg;
	}

	/**
	 * SelectHcpEntity.javahenshuFlgを設定
	 * @return henshuFlg
	 */
	public String getHenshuFlg() {
		return henshuFlg;
	}

	/**
	 * @param henshuFlg セットする henshuFlg
	 */
	public void setHenshuFlg(String henshuFlg) {
		this.henshuFlg = henshuFlg;
	}

	/**
	 * SelectHcpEntity.javafukkatsuFlgを設定
	 * @return fukkatsuFlg
	 */
	public String getFukkatsuFlg() {
		return fukkatsuFlg;
	}

	/**
	 * @param fukkatsuFlg セットする fukkatsuFlg
	 */
	public void setFukkatsuFlg(String fukkatsuFlg) {
		this.fukkatsuFlg = fukkatsuFlg;
	}

	/**
	 * SelectHcpEntity.javamrShinkiFlgを設定
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
	 * SelectHcpEntity.javamrKoushinFlgを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
