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
 * SQLID : selectNC209MainData
 */
public class SelectNC209MainDataEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

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
     * Offset値
     */
    private Integer inOffset;

    /**
     * Limit値
     */
    private Integer inLimit;

    /**
     * カウント、データ取得切り替え
     */
    private Integer inSelectKbn;


    /**
     * 取得データ件数
     */
    private Integer cntRow;


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
     * コンストラクタ
     */
    public SelectNC209MainDataEntity() {
        super("m_rdm_hcp_mst" , "selectNC209MainData");
    }


	/**
	 * SelectNC209MainDataEntity.javainSosCdを設定
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
	 * SelectNC209MainDataEntity.javainJgiNoを設定
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
	 * SelectNC209MainDataEntity.javainKanjiSrchを設定
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
	 * SelectNC209MainDataEntity.javainKanaSrchを設定
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
	 * SelectNC209MainDataEntity.javainDocTypeを設定
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
	 * SelectNC209MainDataEntity.javainDocNoを設定
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
	 * SelectNC209MainDataEntity.javainDocAttributeを設定
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
	 * SelectNC209MainDataEntity.javainMedSchを設定
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
	 * SelectNC209MainDataEntity.javainGradYearを設定
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
	 * SelectNC209MainDataEntity.javainHUnivを設定
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
	 * SelectNC209MainDataEntity.javainGmnBumonRankを設定
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
	 * SelectNC209MainDataEntity.javainGmnSosCdを設定
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
	 * SelectNC209MainDataEntity.javainGmnJgiNoを設定
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
	 * SelectNC209MainDataEntity.javainGmnBrCodeを設定
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
	 * SelectNC209MainDataEntity.javainGmnDistCodeを設定
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
	 * SelectNC209MainDataEntity.javainInsNoを設定
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
	 * SelectNC209MainDataEntity.javainDeptCodeを設定
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
	 * SelectNC209MainDataEntity.javainSortIdを設定
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
	 * SelectNC209MainDataEntity.javainOffsetを設定
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
	 * SelectNC209MainDataEntity.javainLimitを設定
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
	 * SelectNC209MainDataEntity.javainSelectKbnを設定
	 * @return inCntFlg
	 */
	public Integer isInSelectKbn() {
		return inSelectKbn;
	}


	/**
	 * @param inSelectKbn セットする inSelectKbn
	 */
	public void setInSelectKbn(Integer inSelectKbn) {
		this.inSelectKbn = inSelectKbn;
	}


	/**
	 * SelectNC209MainDataEntity.javacntRowを設定
	 * @return cntRow
	 */
	public Integer getCntRow() {
		return cntRow;
	}


	/**
	 * @param cntRow セットする cntRow
	 */
	public void setCntRow(Integer cntRow) {
		this.cntRow = cntRow;
	}


	/**
	 * SelectNC209MainDataEntity.javadocKanjを設定
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
	 * SelectNC209MainDataEntity.javadocKanaを設定
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
	 * SelectNC209MainDataEntity.javadocNoを設定
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
	 * SelectNC209MainDataEntity.javadobを設定
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
	 * SelectNC209MainDataEntity.javaunivKjを設定
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
	 * SelectNC209MainDataEntity.javagrdaYearを設定
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
	 * SelectNC209MainDataEntity.javadocKbnを設定
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
	 * SelectNC209MainDataEntity.javaikyokuKjを設定
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
	 * SelectNC209MainDataEntity.javainsNameを設定
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
	 * SelectNC209MainDataEntity.javaoldKanjSeiを設定
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
	 * SelectNC209MainDataEntity.javaishiNmを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
