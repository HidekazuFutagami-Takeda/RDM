/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;
import java.util.Date;

import jp.co.takeda.rdm.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_HCP_KMU_REQ
 * SQLID : selectCtrlFlg
 * @generated
 */
public class UpdateRdmHcpKmuNewEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 申請ID
     * @generated
     */
    private String reqId;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;

    /**
     * 施設固定コード(異動元)
     * @generated
     */
    private String insNoMt;

    /**
     * 異動区分
     * @generated
     */
    private String trnKbn;

    /**
     * 施設固定コード(異動先)
     * @generated
     */
    private String insNoSk;

    /**
     * 勤務形態(異動元)
     * @generated
     */
    private String jobFromBf;

    /**
     * 所属部科コード(異動元)
     * @generated
     */
    private String deptCodeBf;

    /**
     * 所属部科名（漢字）(異動元)
     * @generated
     */
    private String deotKanjiBf;

    /**
     * 所属部科名（カナ）(異動元)
     * @generated
     */
    private String deptKanaBf;

    /**
     * 大学職位コード(異動元)
     * @generated
     */
    private String univPosCodeBf;

    /**
     * 役職コード(異動元)
     * @generated
     */
    private String titleCodeBf;

    /**
     * 薬審メンバー区分(異動元)
     * @generated
     */
    private String dccTypeBf;

    /**
     * 勤務形態(異動先)
     * @generated
     */
    private String jobFromAf;

    /**
     * 所属部科コード(異動先)
     * @generated
     */
    private String deptCodeAf;

    /**
     * 所属部科名（漢字）(異動先)
     * @generated
     */
    private String deptKanjiAf;

    /**
     * 所属部科名（カナ）(異動先)
     * @generated
     */
    private String deptKanaAf;

    /**
     * 大学職位コード(異動先)
     * @generated
     */
    private String univPosCodeAf;

    /**
     * 役職コード(異動先)
     * @generated
     */
    private String titleCodeAf;

    /**
     * 薬審メンバー区分(異動先)
     * @generated
     */
    private String dccTypeAf;

    /**
     * ULT医師コード
     * @generated
     */
    private String ultDocNo;

    /**
     * ULT施設コード
     * @generated
     */
    private String ultInsNo;

    /**
     * 作成日
     * @generated
     */
    private Date insShaYmd;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;


    /**
     * コンストラクタ
     * @generated
     */
    public UpdateRdmHcpKmuNewEntity() {
        super("hcp_kmu_req_new" , "updateRdmHcpKmu");
    }


	/**
	 * InsertRdmHcpKmuNewEntity.javareqIdを設定
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
	 * InsertRdmHcpKmuNewEntity.javadocNoを設定
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
	 * InsertRdmHcpKmuNewEntity.javainsNoMtを設定
	 * @return insNoMt
	 */
	public String getInsNoMt() {
		return insNoMt;
	}


	/**
	 * @param insNoMt セットする insNoMt
	 */
	public void setInsNoMt(String insNoMt) {
		this.insNoMt = insNoMt;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javatrnKbnを設定
	 * @return trnKbn
	 */
	public String getTrnKbn() {
		return trnKbn;
	}


	/**
	 * @param trnKbn セットする trnKbn
	 */
	public void setTrnKbn(String trnKbn) {
		this.trnKbn = trnKbn;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javainsNoSkを設定
	 * @return insNoSk
	 */
	public String getInsNoSk() {
		return insNoSk;
	}


	/**
	 * @param insNoSk セットする insNoSk
	 */
	public void setInsNoSk(String insNoSk) {
		this.insNoSk = insNoSk;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javajobFromBfを設定
	 * @return jobFromBf
	 */
	public String getJobFromBf() {
		return jobFromBf;
	}


	/**
	 * @param jobFromBf セットする jobFromBf
	 */
	public void setJobFromBf(String jobFromBf) {
		this.jobFromBf = jobFromBf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javadeptCodeBfを設定
	 * @return deptCodeBf
	 */
	public String getDeptCodeBf() {
		return deptCodeBf;
	}


	/**
	 * @param deptCodeBf セットする deptCodeBf
	 */
	public void setDeptCodeBf(String deptCodeBf) {
		this.deptCodeBf = deptCodeBf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javadeotKanjiBfを設定
	 * @return deotKanjiBf
	 */
	public String getDeotKanjiBf() {
		return deotKanjiBf;
	}


	/**
	 * @param deotKanjiBf セットする deotKanjiBf
	 */
	public void setDeotKanjiBf(String deotKanjiBf) {
		this.deotKanjiBf = deotKanjiBf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javadeptKanaBfを設定
	 * @return deptKanaBf
	 */
	public String getDeptKanaBf() {
		return deptKanaBf;
	}


	/**
	 * @param deptKanaBf セットする deptKanaBf
	 */
	public void setDeptKanaBf(String deptKanaBf) {
		this.deptKanaBf = deptKanaBf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javaunivPosCodeBfを設定
	 * @return univPosCodeBf
	 */
	public String getUnivPosCodeBf() {
		return univPosCodeBf;
	}


	/**
	 * @param univPosCodeBf セットする univPosCodeBf
	 */
	public void setUnivPosCodeBf(String univPosCodeBf) {
		this.univPosCodeBf = univPosCodeBf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javatitleCodeBfを設定
	 * @return titleCodeBf
	 */
	public String getTitleCodeBf() {
		return titleCodeBf;
	}


	/**
	 * @param titleCodeBf セットする titleCodeBf
	 */
	public void setTitleCodeBf(String titleCodeBf) {
		this.titleCodeBf = titleCodeBf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javadccTypeBfを設定
	 * @return dccTypeBf
	 */
	public String getDccTypeBf() {
		return dccTypeBf;
	}


	/**
	 * @param dccTypeBf セットする dccTypeBf
	 */
	public void setDccTypeBf(String dccTypeBf) {
		this.dccTypeBf = dccTypeBf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javajobFromAfを設定
	 * @return jobFromAf
	 */
	public String getJobFromAf() {
		return jobFromAf;
	}


	/**
	 * @param jobFromAf セットする jobFromAf
	 */
	public void setJobFromAf(String jobFromAf) {
		this.jobFromAf = jobFromAf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javadeptCodeAfを設定
	 * @return deptCodeAf
	 */
	public String getDeptCodeAf() {
		return deptCodeAf;
	}


	/**
	 * @param deptCodeAf セットする deptCodeAf
	 */
	public void setDeptCodeAf(String deptCodeAf) {
		this.deptCodeAf = deptCodeAf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javadeptKanjiAfを設定
	 * @return deptKanjiAf
	 */
	public String getDeptKanjiAf() {
		return deptKanjiAf;
	}


	/**
	 * @param deptKanjiAf セットする deptKanjiAf
	 */
	public void setDeptKanjiAf(String deptKanjiAf) {
		this.deptKanjiAf = deptKanjiAf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javadeptKanaAfを設定
	 * @return deptKanaAf
	 */
	public String getDeptKanaAf() {
		return deptKanaAf;
	}


	/**
	 * @param deptKanaAf セットする deptKanaAf
	 */
	public void setDeptKanaAf(String deptKanaAf) {
		this.deptKanaAf = deptKanaAf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javaunivPosCodeAfを設定
	 * @return univPosCodeAf
	 */
	public String getUnivPosCodeAf() {
		return univPosCodeAf;
	}


	/**
	 * @param univPosCodeAf セットする univPosCodeAf
	 */
	public void setUnivPosCodeAf(String univPosCodeAf) {
		this.univPosCodeAf = univPosCodeAf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javatitleCodeAfを設定
	 * @return titleCodeAf
	 */
	public String getTitleCodeAf() {
		return titleCodeAf;
	}


	/**
	 * @param titleCodeAf セットする titleCodeAf
	 */
	public void setTitleCodeAf(String titleCodeAf) {
		this.titleCodeAf = titleCodeAf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javadccTypeAfを設定
	 * @return dccTypeAf
	 */
	public String getDccTypeAf() {
		return dccTypeAf;
	}


	/**
	 * @param dccTypeAf セットする dccTypeAf
	 */
	public void setDccTypeAf(String dccTypeAf) {
		this.dccTypeAf = dccTypeAf;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javaultInsNoを設定
	 * @return ultInsNo
	 */
	public String getUltInsNo() {
		return ultInsNo;
	}


	/**
	 * @param ultInsNo セットする ultInsNo
	 */
	public void setUltInsNo(String ultInsNo) {
		this.ultInsNo = ultInsNo;
	}

	/**
	 * InsertRdmHcpKmuNewEntity.javainsShaIdを設定
	 * @return insShaId
	 */
	public String getInsShaId() {
		return insShaId;
	}


	/**
	 * @param insShaId セットする insShaId
	 */
	public void setInsShaId(String insShaId) {
		this.insShaId = insShaId;
	}

	/**
	 * InsertRdmHcpKmuNewEntity.javaupdShaIdを設定
	 * @return updShaId
	 */
	public String getUpdShaId() {
		return updShaId;
	}


	/**
	 * @param updShaId セットする updShaId
	 */
	public void setUpdShaId(String updShaId) {
		this.updShaId = updShaId;
	}


	/**
	 * InsertRdmHcpKmuNewEntity.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * UpdateRdmHcpKmuNewEntity.javaultDocNoを設定
	 * @return ultDocNo
	 */
	public String getUltDocNo() {
		return ultDocNo;
	}


	/**
	 * @param ultDocNo セットする ultDocNo
	 */
	public void setUltDocNo(String ultDocNo) {
		this.ultDocNo = ultDocNo;
	}


	/**
	 * UpdateRdmHcpKmuNewEntity.javainsShaYmdを設定
	 * @return insShaYmd
	 */
	public Date getInsShaYmd() {
		return insShaYmd;
	}


	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(Date insShaYmd) {
		this.insShaYmd = insShaYmd;
	}


	/**
	 * UpdateRdmHcpKmuNewEntity.javaupdShaYmdを設定
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

}
