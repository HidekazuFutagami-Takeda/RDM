/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_HCO_OYAKO
 * SQLID : selectNF201ChkData
 * @generated
 */
public class SelectNF201ChkDataEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_施設固定コード(パラメータ1)
     * @generated
     */
    private String inInsNo;

    /**
     * 入力_領域コード(パラメータ2)
     * @generated
     */
    private String inTrtCd;

    /**
     * 領域・品目グループ件数
     * @generated
     */
    private String trtPrdCnt;

    /**
     * 親施設設定件数
     * @generated
     */
    private String mainInsCnt;


    /**
     * コンストラクタ
     * @generated
     */
    public SelectNF201ChkDataEntity() {
        super("m_rdm_hco_oyako" , "selectNF201ChkData");
    }

	/**
	 * SelectNF201ChkDataEntity.javainInsNoを設定
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
	 * SelectNF201ChkDataEntity.javainTrtCdを設定
	 * @return inTrtCd
	 */
	public String getInTrtCd() {
		return inTrtCd;
	}

	/**
	 * @param inTrtCd セットする inTrtCd
	 */
	public void setInTrtCd(String inTrtCd) {
		this.inTrtCd = inTrtCd;
	}

	/**
	 * SelectNF201ChkDataEntity.javatrtPrdCntを設定
	 * @return trtPrdCnt
	 */
	public String getTrtPrdCnt() {
		return trtPrdCnt;
	}

	/**
	 * @param trtPrdCnt セットする trtPrdCnt
	 */
	public void setTrtPrdCnt(String trtPrdCnt) {
		this.trtPrdCnt = trtPrdCnt;
	}

	/**
	 * SelectNF201ChkDataEntity.javamainInsCntを設定
	 * @return mainInsCnt
	 */
	public String getMainInsCnt() {
		return mainInsCnt;
	}

	/**
	 * @param mainInsCnt セットする mainInsCnt
	 */
	public void setMainInsCnt(String mainInsCnt) {
		this.mainInsCnt = mainInsCnt;
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
