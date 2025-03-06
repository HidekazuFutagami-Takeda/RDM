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
 * テーブル物理名 : M_RDM_HCP_WORK
 * テーブル論理名 : 医師_勤務先
 * @generated
 */
public class SelectHcpWorkEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師固定コード(入力)
     * @generated
     */
    private String inDocNo;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;

    /**
     * 勤務形態
     * @generated
     */
    private String jobForm;

    /**
     * 所属部科コード
     * @generated
     */
    private String deptCode;

    /**
     * 所属部科名（漢字）
     * @generated
     */
    private String deptKanji;

    /**
     * 所属部科名（カナ）
     * @generated
     */
    private String deptKana;

    /**
     * 大学職位コード
     * @generated
     */
    private String univPosCode;

    /**
     * 役職コード
     * @generated
     */
    private String titleCode;

    /**
     * 薬審メンバー区分
     * @generated
     */
    private String dccType;

    /**
     * ULT医師コード
     * @generated
     */
    private String ultDocNo;

    /**
     * 翌営業日(varchar8)
     * @generated
     */
    private String nextBizday;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectHcpWorkEntity() {
        super("m_rdm_hcp_work", "selectND315WorkData");
    }

	/**
	 * SelectHcpWorkEntity.javainDocNoを設定
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
	 * SelectHcpWorkEntity.javainsNoを設定
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
	 * SelectHcpWorkEntity.javadocNoを設定
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
	 * SelectHcpWorkEntity.javajobFormを設定
	 * @return jobForm
	 */
	public String getJobForm() {
		return jobForm;
	}


	/**
	 * @param jobForm セットする jobForm
	 */
	public void setJobForm(String jobForm) {
		this.jobForm = jobForm;
	}


	/**
	 * SelectHcpWorkEntity.javadeptCodeを設定
	 * @return deptCode
	 */
	public String getDeptCode() {
		return deptCode;
	}


	/**
	 * @param deptCode セットする deptCode
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}


	/**
	 * SelectHcpWorkEntity.javadeptKanjiを設定
	 * @return deptKanji
	 */
	public String getDeptKanji() {
		return deptKanji;
	}


	/**
	 * @param deptKanji セットする deptKanji
	 */
	public void setDeptKanji(String deptKanji) {
		this.deptKanji = deptKanji;
	}


	/**
	 * SelectHcpWorkEntity.javadeptKanaを設定
	 * @return deptKana
	 */
	public String getDeptKana() {
		return deptKana;
	}


	/**
	 * @param deptKana セットする deptKana
	 */
	public void setDeptKana(String deptKana) {
		this.deptKana = deptKana;
	}


	/**
	 * SelectHcpWorkEntity.javaunivPosCodeを設定
	 * @return univPosCode
	 */
	public String getUnivPosCode() {
		return univPosCode;
	}


	/**
	 * @param univPosCode セットする univPosCode
	 */
	public void setUnivPosCode(String univPosCode) {
		this.univPosCode = univPosCode;
	}


	/**
	 * SelectHcpWorkEntity.javatitleCodeを設定
	 * @return titleCode
	 */
	public String getTitleCode() {
		return titleCode;
	}


	/**
	 * @param titleCode セットする titleCode
	 */
	public void setTitleCode(String titleCode) {
		this.titleCode = titleCode;
	}


	/**
	 * SelectHcpWorkEntity.javadccTypeを設定
	 * @return dccType
	 */
	public String getDccType() {
		return dccType;
	}


	/**
	 * @param dccType セットする dccType
	 */
	public void setDccType(String dccType) {
		this.dccType = dccType;
	}


	/**
	 * SelectHcpWorkEntity.javaultDocNoを設定
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
	 * SelectHcpWorkEntity.javanextBizdayを設定
	 * @return nextBizday
	 */
	public String getNextBizday() {
		return nextBizday;
	}


	/**
	 * @param nextBizday セットする nextBizday
	 */
	public void setNextBizday(String nextBizday) {
		this.nextBizday = nextBizday;
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
