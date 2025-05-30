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
 * テーブル物理名 : T_RDM_M_MDB_HCP_MST,T_RDM_REQ_KNR,T_RDM_HCP_REQ
 * SQLID : selectND011ULTData,selectND011REQData
 * @generated
 */
public class SelectNd101MainDataEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_医師固定コード
     * @generated
     */
    private String inDocNo;

    /**
     * 入力_施設固定コード
     * @generated
     */
    private String inInsNo;

    /**
     * 入力_申請ID(パラメータ1)
     * @generated
     */
    private String inReqId;

    /**
     * 入力_施設固定コード(変更前)
     * @generated
     */
    private String inPreInsNo;

    /**
     * 入力_施設固定コード(変更後)
     * @generated
     */
    private String inPostInsNo;

    /**
     * 入力_組織コード
     * @generated
     */
    private String inSosCd;

    /**
     * 申請ID
     * @generated
     */
    private String reqId;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNd101MainDataEntity() {
        super("t_rdm_hcp_kmu_req" , "selectNd101REQData");
    }

	/**
	 * SelectND101MainDataEntity.javareqIdを設定
	 * @return reqId
	 */
	public String getReqId() {
		return reqId;
	}

	/**
	 * @param reqId セットする reqId
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	/**
	 * SelectND101MainDataEntity.javainDocNoを設定
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
	 * SelectND101MainDataEntity.javainInsNoを設定
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
	 * SelectNd101MainDataEntity.javainPreInsNoを設定
	 * @return inPreInsNo
	 */
	public String getInPreInsNo() {
		return inPreInsNo;
	}

	/**
	 * @param inPreInsNo セットする inPreInsNo
	 */
	public void setInPreInsNo(String inPreInsNo) {
		this.inPreInsNo = inPreInsNo;
	}

	/**
	 * SelectNd101MainDataEntity.javainPostInsNoを設定
	 * @return inPostInsNo
	 */
	public String getInPostInsNo() {
		return inPostInsNo;
	}

	/**
	 * @param inPostInsNo セットする inPostInsNo
	 */
	public void setInPostInsNo(String inPostInsNo) {
		this.inPostInsNo = inPostInsNo;
	}

	/**
	 * SelectNd101MainDataEntity.javainSosCdを設定
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
	 * SelectNd101MainDataEntity.javainReqIdを設定
	 * @return inReqId
	 */
	public String getInReqId() {
		return inReqId;
	}

	/**
	 * @param inReqId セットする inReqId
	 */
	public void setInReqId(String inReqId) {
		this.inReqId = inReqId;
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
