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
public class KmuIkkatsuData implements Serializable {

    /**
    * 施設固定コード
    * @generated
    */
   private String insNo;

   /**
    * 施設略式漢字名
    * @generated
    */
   private String insAbbrName;

   /**
    * 医師固定コード
    * @generated
    */
   private String docNo;

   /**
    * 氏名（漢字）
    * @generated
    */
   private String docKanj;

   /**
    * 役職漢字名（変更前）
    * @generated
    */
   private String preTitleKj;

   /**
    * 役職漢字名（変更後）
    * @generated
    */
   private String postTitleKj;

   /**
    * 所属部科名（漢字）（変更前）
    * @generated
    */
   private String preDeptKanji;

   /**
    * 所属部科名（漢字）（変更後）
    * @generated
    */
   private String postDeptKanji;

   /**
    * 役職コード（変更前）
    * @generated
    */
   private String preTitleCode;

   /**
    * 役職コード（変更後）
    * @generated
    */
   private String postTitleCode;

   /**
    * 所属部科コード（変更前）
    * @generated
    */
   private String preDeptCode;

   /**
    * 所属部科コード（変更後）
    * @generated
    */
   private String postDeptCode;

   /**
    * 所属部科名（カナ）（変更前）
    * @generated
    */
   private String preDeptKana;

   /**
    * 所属部科名（カナ）（変更後）
    * @generated
    */
   private String postDeptKana;

   /**
    * 勤務形態
    * @generated
    */
   private String jobForm;

   /**
    * 大学職位コード
    * @generated
    */
   private String univPosCode;

   /**
    * 薬審メンバー区分
    * @generated
    */
   private String dcc;

   /**
    * ULT施設コード
    * @generated
    */
   private String ultInsNo;

   /**
    * ULT医師コード
    * @generated
    */
   private String ultDocNo;

   /**
    * 所属部科ソート1
    * @generated
    */
   private String sortNum1;

   /**
    * 所属部科ソート2
    * @generated
    */
   private String sortNum2;

   /**
    * 所属部科ソート3
    * @generated
    */
   private String sortNum3;

   /**
    * 役職ソート
    * @generated
    */
   private String sortNum;

   /**
    * 更新日
    * @generated
    */
   private String updShaYmd;

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;


    /**
     * コンストラクタ
     * @customizable
     */
    public KmuIkkatsuData() {
        // START UOC

        // END UOC
    }

	/**
	 * KmuIkkatsuData.javainsNoを設定
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
	 * KmuIkkatsuData.javainsAbbrNameを設定
	 * @return insAbbrName
	 */
	public String getInsAbbrName() {
		return insAbbrName;
	}

	/**
	 * @param insAbbrName セットする insAbbrName
	 */
	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

	/**
	 * KmuIkkatsuData.javadocNoを設定
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
	 * KmuIkkatsuData.javadocKanjを設定
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
	 * KmuIkkatsuData.javapreTitleKjを設定
	 * @return preTitleKj
	 */
	public String getPreTitleKj() {
		return preTitleKj;
	}

	/**
	 * @param preTitleKj セットする preTitleKj
	 */
	public void setPreTitleKj(String preTitleKj) {
		this.preTitleKj = preTitleKj;
	}

	/**
	 * KmuIkkatsuData.javapostTitleKjを設定
	 * @return postTitleKj
	 */
	public String getPostTitleKj() {
		return postTitleKj;
	}

	/**
	 * @param postTitleKj セットする postTitleKj
	 */
	public void setPostTitleKj(String postTitleKj) {
		this.postTitleKj = postTitleKj;
	}

	/**
	 * KmuIkkatsuData.javapreDeptKanjiを設定
	 * @return preDeptKanji
	 */
	public String getPreDeptKanji() {
		return preDeptKanji;
	}

	/**
	 * @param preDeptKanji セットする preDeptKanji
	 */
	public void setPreDeptKanji(String preDeptKanji) {
		this.preDeptKanji = preDeptKanji;
	}

	/**
	 * KmuIkkatsuData.javapostDeptKanjiを設定
	 * @return postDeptKanji
	 */
	public String getPostDeptKanji() {
		return postDeptKanji;
	}

	/**
	 * @param postDeptKanji セットする postDeptKanji
	 */
	public void setPostDeptKanji(String postDeptKanji) {
		this.postDeptKanji = postDeptKanji;
	}

	/**
	 * KmuIkkatsuData.javapreTitleCodeを設定
	 * @return preTitleCode
	 */
	public String getPreTitleCode() {
		return preTitleCode;
	}

	/**
	 * @param preTitleCode セットする preTitleCode
	 */
	public void setPreTitleCode(String preTitleCode) {
		this.preTitleCode = preTitleCode;
	}

	/**
	 * KmuIkkatsuData.javapostTitleCodeを設定
	 * @return postTitleCode
	 */
	public String getPostTitleCode() {
		return postTitleCode;
	}

	/**
	 * @param postTitleCode セットする postTitleCode
	 */
	public void setPostTitleCode(String postTitleCode) {
		this.postTitleCode = postTitleCode;
	}

	/**
	 * KmuIkkatsuData.javapreDeptCodeを設定
	 * @return preDeptCode
	 */
	public String getPreDeptCode() {
		return preDeptCode;
	}

	/**
	 * @param preDeptCode セットする preDeptCode
	 */
	public void setPreDeptCode(String preDeptCode) {
		this.preDeptCode = preDeptCode;
	}

	/**
	 * KmuIkkatsuData.javapostDeptCodeを設定
	 * @return postDeptCode
	 */
	public String getPostDeptCode() {
		return postDeptCode;
	}

	/**
	 * @param postDeptCode セットする postDeptCode
	 */
	public void setPostDeptCode(String postDeptCode) {
		this.postDeptCode = postDeptCode;
	}

	/**
	 * KmuIkkatsuData.javapreDeptKanaを設定
	 * @return preDeptKana
	 */
	public String getPreDeptKana() {
		return preDeptKana;
	}

	/**
	 * @param preDeptKana セットする preDeptKana
	 */
	public void setPreDeptKana(String preDeptKana) {
		this.preDeptKana = preDeptKana;
	}

	/**
	 * KmuIkkatsuData.javapostDeptKanaを設定
	 * @return postDeptKana
	 */
	public String getPostDeptKana() {
		return postDeptKana;
	}

	/**
	 * @param postDeptKana セットする postDeptKana
	 */
	public void setPostDeptKana(String postDeptKana) {
		this.postDeptKana = postDeptKana;
	}

	/**
	 * KmuIkkatsuData.javajobFormを設定
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
	 * KmuIkkatsuData.javaunivPosCodeを設定
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
	 * KmuIkkatsuData.javadccを設定
	 * @return dcc
	 */
	public String getDcc() {
		return dcc;
	}

	/**
	 * @param dcc セットする dcc
	 */
	public void setDcc(String dcc) {
		this.dcc = dcc;
	}

	/**
	 * KmuIkkatsuData.javaultInsNoを設定
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
	 * KmuIkkatsuData.javaultDocNoを設定
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
	 * KmuIkkatsuData.javasortNum1を設定
	 * @return sortNum1
	 */
	public String getSortNum1() {
		return sortNum1;
	}

	/**
	 * @param sortNum1 セットする sortNum1
	 */
	public void setSortNum1(String sortNum1) {
		this.sortNum1 = sortNum1;
	}

	/**
	 * KmuIkkatsuData.javasortNum2を設定
	 * @return sortNum2
	 */
	public String getSortNum2() {
		return sortNum2;
	}

	/**
	 * @param sortNum2 セットする sortNum2
	 */
	public void setSortNum2(String sortNum2) {
		this.sortNum2 = sortNum2;
	}

	/**
	 * KmuIkkatsuData.javasortNum3を設定
	 * @return sortNum3
	 */
	public String getSortNum3() {
		return sortNum3;
	}

	/**
	 * @param sortNum3 セットする sortNum3
	 */
	public void setSortNum3(String sortNum3) {
		this.sortNum3 = sortNum3;
	}

	/**
	 * KmuIkkatsuData.javasortNumを設定
	 * @return sortNum
	 */
	public String getSortNum() {
		return sortNum;
	}

	/**
	 * @param sortNum セットする sortNum
	 */
	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}

	/**
	 * KmuIkkatsuData.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public String getUpdShaYmd() {
		return updShaYmd;
	}

	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(String updShaYmd) {
		this.updShaYmd = updShaYmd;
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

