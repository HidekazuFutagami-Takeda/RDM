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
 * SQLID : selectCntHcp
 */
public class SelectCntSelectHcpEntity extends BaseEntity implements Serializable {

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
     * 医師検索表示件数
     */
    private Integer cntHcp;




    /**
     * コンストラクタ
     */
    public SelectCntSelectHcpEntity() {
        super("m_rdm_hcp_mst" , "selectCntHcp");
    }

	/**
	 * SelectParamSelectHcpEntity.javaCntHcpを設定
	 * @return cntHcp
	 */
	public Integer getCntHcp() {
		return cntHcp;
	}

	/**
	 * @param cntHcp セットする cntHcp
	 */
	public void setCntHcp(Integer cntHcp) {
		this.cntHcp = cntHcp;
	}


	/**
	 * SelectCntSelectHcpEntity.javainSosCdを設定
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
	 * SelectCntSelectHcpEntity.javainJgiNoを設定
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
	 * SelectCntSelectHcpEntity.javainKanjiSrchを設定
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
	 * SelectCntSelectHcpEntity.javainKanaSrchを設定
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
	 * SelectCntSelectHcpEntity.javainDocTypeを設定
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
	 * SelectCntSelectHcpEntity.javainDocNoを設定
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
	 * SelectCntSelectHcpEntity.javainDcfIshiCdを設定
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
	 * SelectCntSelectHcpEntity.javainDocAttributeを設定
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
	 * SelectCntSelectHcpEntity.javainMedSchを設定
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
	 * SelectCntSelectHcpEntity.javainGradYearを設定
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
	 * SelectCntSelectHcpEntity.javainHUnivを設定
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
	 * SelectCntSelectHcpEntity.javainSetsuzokuを設定
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
	 * SelectCntSelectHcpEntity.javainGmnBumonRankを設定
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
	 * SelectCntSelectHcpEntity.javainGmnSosCdを設定
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
	 * SelectCntSelectHcpEntity.javainGmnJgiNoを設定
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
	 * SelectCntSelectHcpEntity.javainGmnBrCodeを設定
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
	 * SelectCntSelectHcpEntity.javainGmnDistCodeを設定
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
	 * SelectCntSelectHcpEntity.javainInsNoを設定
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
	 * SelectCntSelectHcpEntity.javainDeptCodeを設定
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
	 * SelectCntSelectHcpEntity.javainSortIdを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
