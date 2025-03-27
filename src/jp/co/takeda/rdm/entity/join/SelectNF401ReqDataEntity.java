/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_HCO_NXT_REQ
 * SQLID : selectNF401ReqDataList, selectNF401ReqData
 * @generated
 */
public class SelectNF401ReqDataEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 施設固定コード(パラメータ1)
     * @generated
     */
    private List<String> inInsNoList;

    /**
     * 施設固定コード(パラメータ2)
     * @generated
     */
    private String inInsNo;

    /**
     * 申請ID
     * @generated
     */
    private String reqId;

    /**
     * 申請チャネル
     * @generated
     */
    private String reqChl;

    /**
     * 施設固定コード
     * @generated
     */
    private String InsNo;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;


    /**
     * コンストラクタ
     * @generated
     */
    public SelectNF401ReqDataEntity() {
        super("t_rdm_hco_nxt_req" , "selectNF401ReqDataList");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNF401ReqDataEntity(String sqlId) {
        super("t_rdm_hco_nxt_req" , sqlId);
    }

	/**
	 * SelectNF401ReqDataEntity.javainInsNoListを設定
	 * @return inInsNoList
	 */
	public List<String> getInInsNoList() {
		return inInsNoList;
	}

	/**
	 * @param inInsNoList セットする inInsNoList
	 */
	public void setInInsNoList(List<String> inInsNoList) {
		this.inInsNoList = inInsNoList;
	}

	/**
	 * SelectNF401ReqDataEntity.javainInsNoを設定
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
	 * SelectNF401ReqDataEntity.javareqIdを設定
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
	 * SelectNF401ReqDataEntity.javareqChlを設定
	 * @return reqChl
	 */
	public String getReqChl() {
		return reqChl;
	}

	/**
	 * @param reqChl セットする reqChl
	 */
	public void setReqChl(String reqChl) {
		this.reqChl = reqChl;
	}

	/**
	 * SelectNF401ReqDataEntity.javaInsNoを設定
	 * @return insNo
	 */
	public String getInsNo() {
		return InsNo;
	}

	/**
	 * @param insNo セットする insNo
	 */
	public void setInsNo(String insNo) {
		InsNo = insNo;
	}

	/**
	 * SelectNF401ReqDataEntity.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public Date getUpdShaYmd() {
		return updShaYmd;
	}

	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(Date updShaYmd) {
		this.updShaYmd = updShaYmd;
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
