/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : T_RDM_HCP_KMU_REQ
 * テーブル論理名 : 勤務先_申請管理
 * @generated
 */
public class TRdmHcpKmuReqEntity extends BaseEntity implements Serializable {

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
    private boolean reqIdNullFlag;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;
    private boolean docNoNullFlag;

    /**
     * 施設固定コード(異動元)
     * @generated
     */
    private String insNoMt;
    private boolean insNoMtNullFlag;

    /**
     * 異動区分
     * @generated
     */
    private String trnKbn;
    private boolean trnKbnNullFlag;

    /**
     * 施設固定コード(異動先)
     * @generated
     */
    private String insNoSk;
    private boolean insNoSkNullFlag;

    /**
     * 勤務形態(異動元)
     * @generated
     */
    private String jobFormBf;
    private boolean jobFormBfNullFlag;

    /**
     * 所属部科コード(異動元)
     * @generated
     */
    private String deptCodeBf;
    private boolean deptCodeBfNullFlag;

    /**
     * 所属部科名（漢字）(異動元)
     * @generated
     */
    private String deptKanjiBf;
    private boolean deptKanjiBfNullFlag;

    /**
     * 所属部科名（カナ）(異動元)
     * @generated
     */
    private String deptKanaBf;
    private boolean deptKanaBfNullFlag;

    /**
     * 大学職位コード(異動元)
     * @generated
     */
    private String univPosCodeBf;
    private boolean univPosCodeBfNullFlag;

    /**
     * 役職コード(異動元)
     * @generated
     */
    private String titleCodeBf;
    private boolean titleCodeBfNullFlag;

    /**
     * 薬審メンバー区分(異動元)
     * @generated
     */
    private String dccTypeBf;
    private boolean dccTypeBfNullFlag;

    /**
     * 勤務形態(異動先)
     * @generated
     */
    private String jobFormAf;
    private boolean jobFormAfNullFlag;

    /**
     * 所属部科コード(異動先)
     * @generated
     */
    private String deptCodeAf;
    private boolean deptCodeAfNullFlag;

    /**
     * 所属部科名（漢字）(異動先)
     * @generated
     */
    private String deptKanjiAf;
    private boolean deptKanjiAfNullFlag;

    /**
     * 所属部科名（カナ）(異動先)
     * @generated
     */
    private String deptKanaAf;
    private boolean deptKanaAfNullFlag;

    /**
     * 大学職位コード(異動先)
     * @generated
     */
    private String univPosCodeAf;
    private boolean univPosCodeAfNullFlag;

    /**
     * 役職コード(異動先)
     * @generated
     */
    private String titleCodeAf;
    private boolean titleCodeAfNullFlag;

    /**
     * 薬審メンバー区分(異動先)
     * @generated
     */
    private String dccTypeAf;
    private boolean dccTypeAfNullFlag;

    /**
     * ULT医師コード
     * @generated
     */
    private String ultDocNo;
    private boolean ultDocNoNullFlag;

    /**
     * ULT施設コード
     * @generated
     */
    private String ultInsNo;
    private boolean ultInsNoNullFlag;

    /**
     * 作成日
     * @generated
     */
    private Date insShaYmd;
    private boolean insShaYmdNullFlag;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;
    private boolean insShaIdNullFlag;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;
    private boolean updShaYmdNullFlag;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;
    private boolean updShaIdNullFlag;

    /**
     * コンストラクタ
     * @generated
     */
    public TRdmHcpKmuReqEntity() {
        super("t_rdm_hcp_kmu_req");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public TRdmHcpKmuReqEntity(String sqlId) {
        super("t_rdm_hcp_kmu_req", sqlId);
    }

	/**
	 * TRdmHcpKmuReqEntity.javareqIdを設定
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
	 * TRdmHcpKmuReqEntity.javareqIdNullFlagを設定
	 * @return reqIdNullFlag
	 */
	public boolean isReqIdNullFlag() {
		return reqIdNullFlag;
	}

	/**
	 * @param reqIdNullFlag セットする reqIdNullFlag
	 */
	public void setReqIdNullFlag(boolean reqIdNullFlag) {
		this.reqIdNullFlag = reqIdNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadocNoを設定
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
	 * TRdmHcpKmuReqEntity.javadocNoNullFlagを設定
	 * @return docNoNullFlag
	 */
	public boolean isDocNoNullFlag() {
		return docNoNullFlag;
	}

	/**
	 * @param docNoNullFlag セットする docNoNullFlag
	 */
	public void setDocNoNullFlag(boolean docNoNullFlag) {
		this.docNoNullFlag = docNoNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javainsNoMtを設定
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
	 * TRdmHcpKmuReqEntity.javainsNoMtNullFlagを設定
	 * @return insNoMtNullFlag
	 */
	public boolean isInsNoMtNullFlag() {
		return insNoMtNullFlag;
	}

	/**
	 * @param insNoMtNullFlag セットする insNoMtNullFlag
	 */
	public void setInsNoMtNullFlag(boolean insNoMtNullFlag) {
		this.insNoMtNullFlag = insNoMtNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javatrnKbnを設定
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
	 * TRdmHcpKmuReqEntity.javatrnKbnNullFlagを設定
	 * @return trnKbnNullFlag
	 */
	public boolean isTrnKbnNullFlag() {
		return trnKbnNullFlag;
	}

	/**
	 * @param trnKbnNullFlag セットする trnKbnNullFlag
	 */
	public void setTrnKbnNullFlag(boolean trnKbnNullFlag) {
		this.trnKbnNullFlag = trnKbnNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javainsNoSkを設定
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
	 * TRdmHcpKmuReqEntity.javainsNoSkNullFlagを設定
	 * @return insNoSkNullFlag
	 */
	public boolean isInsNoSkNullFlag() {
		return insNoSkNullFlag;
	}

	/**
	 * @param insNoSkNullFlag セットする insNoSkNullFlag
	 */
	public void setInsNoSkNullFlag(boolean insNoSkNullFlag) {
		this.insNoSkNullFlag = insNoSkNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javajobFormBfを設定
	 * @return jobFormBf
	 */
	public String getJobFormBf() {
		return jobFormBf;
	}

	/**
	 * @param jobFormBf セットする jobFormBf
	 */
	public void setJobFormBf(String jobFormBf) {
		this.jobFormBf = jobFormBf;
	}

	/**
	 * TRdmHcpKmuReqEntity.javajobFormBfNullFlagを設定
	 * @return jobFormBfNullFlag
	 */
	public boolean isJobFormBfNullFlag() {
		return jobFormBfNullFlag;
	}

	/**
	 * @param jobFormBfNullFlag セットする jobFormBfNullFlag
	 */
	public void setJobFormBfNullFlag(boolean jobFormBfNullFlag) {
		this.jobFormBfNullFlag = jobFormBfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadeptCodeBfを設定
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
	 * TRdmHcpKmuReqEntity.javadeptCodeBfNullFlagを設定
	 * @return deptCodeBfNullFlag
	 */
	public boolean isDeptCodeBfNullFlag() {
		return deptCodeBfNullFlag;
	}

	/**
	 * @param deptCodeBfNullFlag セットする deptCodeBfNullFlag
	 */
	public void setDeptCodeBfNullFlag(boolean deptCodeBfNullFlag) {
		this.deptCodeBfNullFlag = deptCodeBfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadeptKanjiBfを設定
	 * @return deptKanjiBf
	 */
	public String getDeptKanjiBf() {
		return deptKanjiBf;
	}

	/**
	 * @param deptKanjiBf セットする deptKanjiBf
	 */
	public void setDeptKanjiBf(String deptKanjiBf) {
		this.deptKanjiBf = deptKanjiBf;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadeptKanjiBfNullFlagを設定
	 * @return deptKanjiBfNullFlag
	 */
	public boolean isDeptKanjiBfNullFlag() {
		return deptKanjiBfNullFlag;
	}

	/**
	 * @param deptKanjiBfNullFlag セットする deptKanjiBfNullFlag
	 */
	public void setDeptKanjiBfNullFlag(boolean deptKanjiBfNullFlag) {
		this.deptKanjiBfNullFlag = deptKanjiBfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadeptKanaBfを設定
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
	 * TRdmHcpKmuReqEntity.javadeptKanaBfNullFlagを設定
	 * @return deptKanaBfNullFlag
	 */
	public boolean isDeptKanaBfNullFlag() {
		return deptKanaBfNullFlag;
	}

	/**
	 * @param deptKanaBfNullFlag セットする deptKanaBfNullFlag
	 */
	public void setDeptKanaBfNullFlag(boolean deptKanaBfNullFlag) {
		this.deptKanaBfNullFlag = deptKanaBfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javaunivPosCodeBfを設定
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
	 * TRdmHcpKmuReqEntity.javaunivPosCodeBfNullFlagを設定
	 * @return univPosCodeBfNullFlag
	 */
	public boolean isUnivPosCodeBfNullFlag() {
		return univPosCodeBfNullFlag;
	}

	/**
	 * @param univPosCodeBfNullFlag セットする univPosCodeBfNullFlag
	 */
	public void setUnivPosCodeBfNullFlag(boolean univPosCodeBfNullFlag) {
		this.univPosCodeBfNullFlag = univPosCodeBfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javatitleCodeBfを設定
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
	 * TRdmHcpKmuReqEntity.javatitleCodeBfNullFlagを設定
	 * @return titleCodeBfNullFlag
	 */
	public boolean isTitleCodeBfNullFlag() {
		return titleCodeBfNullFlag;
	}

	/**
	 * @param titleCodeBfNullFlag セットする titleCodeBfNullFlag
	 */
	public void setTitleCodeBfNullFlag(boolean titleCodeBfNullFlag) {
		this.titleCodeBfNullFlag = titleCodeBfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadccTypeBfを設定
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
	 * TRdmHcpKmuReqEntity.javadccTypeBfNullFlagを設定
	 * @return dccTypeBfNullFlag
	 */
	public boolean isDccTypeBfNullFlag() {
		return dccTypeBfNullFlag;
	}

	/**
	 * @param dccTypeBfNullFlag セットする dccTypeBfNullFlag
	 */
	public void setDccTypeBfNullFlag(boolean dccTypeBfNullFlag) {
		this.dccTypeBfNullFlag = dccTypeBfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javajobFormAfを設定
	 * @return jobFormAf
	 */
	public String getJobFormAf() {
		return jobFormAf;
	}

	/**
	 * @param jobFormAf セットする jobFormAf
	 */
	public void setJobFormAf(String jobFormAf) {
		this.jobFormAf = jobFormAf;
	}

	/**
	 * TRdmHcpKmuReqEntity.javajobFormAfNullFlagを設定
	 * @return jobFormAfNullFlag
	 */
	public boolean isJobFormAfNullFlag() {
		return jobFormAfNullFlag;
	}

	/**
	 * @param jobFormAfNullFlag セットする jobFormAfNullFlag
	 */
	public void setJobFormAfNullFlag(boolean jobFormAfNullFlag) {
		this.jobFormAfNullFlag = jobFormAfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadeptCodeAfを設定
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
	 * TRdmHcpKmuReqEntity.javadeptCodeAfNullFlagを設定
	 * @return deptCodeAfNullFlag
	 */
	public boolean isDeptCodeAfNullFlag() {
		return deptCodeAfNullFlag;
	}

	/**
	 * @param deptCodeAfNullFlag セットする deptCodeAfNullFlag
	 */
	public void setDeptCodeAfNullFlag(boolean deptCodeAfNullFlag) {
		this.deptCodeAfNullFlag = deptCodeAfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadeptKanjiAfを設定
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
	 * TRdmHcpKmuReqEntity.javadeptKanjiAfNullFlagを設定
	 * @return deptKanjiAfNullFlag
	 */
	public boolean isDeptKanjiAfNullFlag() {
		return deptKanjiAfNullFlag;
	}

	/**
	 * @param deptKanjiAfNullFlag セットする deptKanjiAfNullFlag
	 */
	public void setDeptKanjiAfNullFlag(boolean deptKanjiAfNullFlag) {
		this.deptKanjiAfNullFlag = deptKanjiAfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadeptKanaAfを設定
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
	 * TRdmHcpKmuReqEntity.javadeptKanaAfNullFlagを設定
	 * @return deptKanaAfNullFlag
	 */
	public boolean isDeptKanaAfNullFlag() {
		return deptKanaAfNullFlag;
	}

	/**
	 * @param deptKanaAfNullFlag セットする deptKanaAfNullFlag
	 */
	public void setDeptKanaAfNullFlag(boolean deptKanaAfNullFlag) {
		this.deptKanaAfNullFlag = deptKanaAfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javaunivPosCodeAfを設定
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
	 * TRdmHcpKmuReqEntity.javaunivPosCodeAfNullFlagを設定
	 * @return univPosCodeAfNullFlag
	 */
	public boolean isUnivPosCodeAfNullFlag() {
		return univPosCodeAfNullFlag;
	}

	/**
	 * @param univPosCodeAfNullFlag セットする univPosCodeAfNullFlag
	 */
	public void setUnivPosCodeAfNullFlag(boolean univPosCodeAfNullFlag) {
		this.univPosCodeAfNullFlag = univPosCodeAfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javatitleCodeAfを設定
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
	 * TRdmHcpKmuReqEntity.javatitleCodeAfNullFlagを設定
	 * @return titleCodeAfNullFlag
	 */
	public boolean isTitleCodeAfNullFlag() {
		return titleCodeAfNullFlag;
	}

	/**
	 * @param titleCodeAfNullFlag セットする titleCodeAfNullFlag
	 */
	public void setTitleCodeAfNullFlag(boolean titleCodeAfNullFlag) {
		this.titleCodeAfNullFlag = titleCodeAfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javadccTypeAfを設定
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
	 * TRdmHcpKmuReqEntity.javadccTypeAfNullFlagを設定
	 * @return dccTypeAfNullFlag
	 */
	public boolean isDccTypeAfNullFlag() {
		return dccTypeAfNullFlag;
	}

	/**
	 * @param dccTypeAfNullFlag セットする dccTypeAfNullFlag
	 */
	public void setDccTypeAfNullFlag(boolean dccTypeAfNullFlag) {
		this.dccTypeAfNullFlag = dccTypeAfNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javaultDocNoを設定
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
	 * TRdmHcpKmuReqEntity.javaultDocNoNullFlagを設定
	 * @return ultDocNoNullFlag
	 */
	public boolean isUltDocNoNullFlag() {
		return ultDocNoNullFlag;
	}

	/**
	 * @param ultDocNoNullFlag セットする ultDocNoNullFlag
	 */
	public void setUltDocNoNullFlag(boolean ultDocNoNullFlag) {
		this.ultDocNoNullFlag = ultDocNoNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javaultInsNoを設定
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
	 * TRdmHcpKmuReqEntity.javaultInsNoNullFlagを設定
	 * @return ultInsNoNullFlag
	 */
	public boolean isUltInsNoNullFlag() {
		return ultInsNoNullFlag;
	}

	/**
	 * @param ultInsNoNullFlag セットする ultInsNoNullFlag
	 */
	public void setUltInsNoNullFlag(boolean ultInsNoNullFlag) {
		this.ultInsNoNullFlag = ultInsNoNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javainsShaYmdを設定
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
	 * TRdmHcpKmuReqEntity.javainsShaYmdNullFlagを設定
	 * @return insShaYmdNullFlag
	 */
	public boolean isInsShaYmdNullFlag() {
		return insShaYmdNullFlag;
	}

	/**
	 * @param insShaYmdNullFlag セットする insShaYmdNullFlag
	 */
	public void setInsShaYmdNullFlag(boolean insShaYmdNullFlag) {
		this.insShaYmdNullFlag = insShaYmdNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javainsShaIdを設定
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
	 * TRdmHcpKmuReqEntity.javainsShaIdNullFlagを設定
	 * @return insShaIdNullFlag
	 */
	public boolean isInsShaIdNullFlag() {
		return insShaIdNullFlag;
	}

	/**
	 * @param insShaIdNullFlag セットする insShaIdNullFlag
	 */
	public void setInsShaIdNullFlag(boolean insShaIdNullFlag) {
		this.insShaIdNullFlag = insShaIdNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javaupdShaYmdを設定
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
	 * TRdmHcpKmuReqEntity.javaupdShaYmdNullFlagを設定
	 * @return updShaYmdNullFlag
	 */
	public boolean isUpdShaYmdNullFlag() {
		return updShaYmdNullFlag;
	}

	/**
	 * @param updShaYmdNullFlag セットする updShaYmdNullFlag
	 */
	public void setUpdShaYmdNullFlag(boolean updShaYmdNullFlag) {
		this.updShaYmdNullFlag = updShaYmdNullFlag;
	}

	/**
	 * TRdmHcpKmuReqEntity.javaupdShaIdを設定
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
	 * TRdmHcpKmuReqEntity.javaupdShaIdNullFlagを設定
	 * @return updShaIdNullFlag
	 */
	public boolean isUpdShaIdNullFlag() {
		return updShaIdNullFlag;
	}

	/**
	 * @param updShaIdNullFlag セットする updShaIdNullFlag
	 */
	public void setUpdShaIdNullFlag(boolean updShaIdNullFlag) {
		this.updShaIdNullFlag = updShaIdNullFlag;
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
