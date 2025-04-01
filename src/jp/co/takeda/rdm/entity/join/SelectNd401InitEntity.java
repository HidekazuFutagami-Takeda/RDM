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
 * テーブル物理名 : M_RDM_HCP_WORK
 * SQLID : selectDocReqKnrInsChange
 */
public class SelectNd401InitEntity extends BaseEntity implements Serializable {

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
     * 検索条件_施設名
     * @generated
     */
    private String kensakuInsKanj;

    /**
     * 検索条件_施設固定C
     * @generated
     */
    private String kensakuInsNo;

    /**
     * 検索条件_医師名
     * @generated
     */
    private String kensakuDocKanj;

    /**
     * 検索条件_医師固定C
     * @generated
     */
    private String kensakuDocNo;

    /**
     * 検索条件_所属部科コード
     * @generated
     */
    private String kensakuDeptCode;

    /**
     * 検索条件_組織コード
     * @generated
     */
    private String kensakuSosCd;

    /**
     * 検索条件_部門ランク
     * @generated
     */
    private String kensakuBumonRank;

    /**
     * 検索条件_医薬支店C
     * @generated
     */
    private String kensakuBrCode;

    /**
     * 検索条件_医薬営業所C
     * @generated
     */
    private String kensakuDistCode;

    /**
     * 検索条件_担当者コード(従業員番号)
     * @generated
     */
    private String kensakuJgiNo;

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
    * 役職漢字名
    * @generated
    */
   private String preTitleKj;

   /**
    * 役職漢字名
    * @generated
    */
   private String postTitleKj;

   /**
    * 所属部科名（漢字）
    * @generated
    */
   private String preDeptKanji;

   /**
    * 所属部科名（漢字）
    * @generated
    */
   private String postDeptKanji;

   /**
    * 役職コード
    * @generated
    */
   private String preTitleCode;

   /**
    * 役職コード
    * @generated
    */
   private String postTitleCode;

   /**
    * 所属部科コード
    * @generated
    */
   private String preDeptCode;

   /**
    * 所属部科コード
    * @generated
    */
   private String postDeptCode;

   /**
    * 所属部科名（カナ）
    * @generated
    */
   private String preDeptKana;

   /**
    * 所属部科名（カナ）
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
    * プルダウン_役職コード
    * @generated
    */
   private String puldownTitleCode;

   /**
    * プルダウン_役職名称
    * @generated
    */
   private String puldownTitleKj;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNd401InitEntity() {
        super("m_rdm_hcp_work" , "selectNd401Init");
    }

	/**
	 * SelectNd401InitEntity.javainsNoを設定
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
	 * SelectNd401InitEntity.javainsAbbrNameを設定
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
	 * SelectNd401InitEntity.javadocNoを設定
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
	 * SelectNd401InitEntity.javadocKanjを設定
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
	 * SelectNd401InitEntity.javapreTitleKjを設定
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
	 * SelectNd401InitEntity.javapostTitleKjを設定
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
	 * SelectNd401InitEntity.javapreDeptKanjiを設定
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
	 * SelectNd401InitEntity.javapostDeptKanjiを設定
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
	 * SelectNd401InitEntity.javapreTitleCodeを設定
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
	 * SelectNd401InitEntity.javapostTitleCodeを設定
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
	 * SelectNd401InitEntity.javapreDeptCodeを設定
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
	 * SelectNd401InitEntity.javapostDeptCodeを設定
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
	 * SelectNd401InitEntity.javapreDeptKanaを設定
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
	 * SelectNd401InitEntity.javapostDeptKanaを設定
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
	 * SelectNd401InitEntity.javajobFormを設定
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
	 * SelectNd401InitEntity.javaunivPosCodeを設定
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
	 * SelectNd401InitEntity.javadccを設定
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
	 * SelectNd401InitEntity.javaultInsNoを設定
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
	 * SelectNd401InitEntity.javaultDocNoを設定
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
	 * SelectNd401InitEntity.javasortNum1を設定
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
	 * SelectNd401InitEntity.javasortNum2を設定
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
	 * SelectNd401InitEntity.javasortNum3を設定
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
	 * SelectNd401InitEntity.javasortNumを設定
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
	 * SelectNd401InitEntity.javainOffsetを設定
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
	 * SelectNd401InitEntity.javainLimitを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	/**
	 * SelectNd401InitEntity.javapuldownTitleCodeを設定
	 * @return puldownTitleCode
	 */
	public String getPuldownTitleCode() {
		return puldownTitleCode;
	}

	/**
	 * @param puldownTitleCode セットする puldownTitleCode
	 */
	public void setPuldownTitleCode(String puldownTitleCode) {
		this.puldownTitleCode = puldownTitleCode;
	}

	/**
	 * SelectNd401InitEntity.javapuldownTitleKjを設定
	 * @return puldownTitleKj
	 */
	public String getPuldownTitleKj() {
		return puldownTitleKj;
	}

	/**
	 * @param puldownTitleKj セットする puldownTitleKj
	 */
	public void setPuldownTitleKj(String puldownTitleKj) {
		this.puldownTitleKj = puldownTitleKj;
	}

	/**
	 * SelectNd401InitEntity.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * SelectNd401InitEntity.javakensakuInsKanjを設定
	 * @return kensakuInsKanj
	 */
	public String getKensakuInsKanj() {
		return kensakuInsKanj;
	}

	/**
	 * @param kensakuInsKanj セットする kensakuInsKanj
	 */
	public void setKensakuInsKanj(String kensakuInsKanj) {
		this.kensakuInsKanj = kensakuInsKanj;
	}

	/**
	 * SelectNd401InitEntity.javakensakuInsNoを設定
	 * @return kensakuInsNo
	 */
	public String getKensakuInsNo() {
		return kensakuInsNo;
	}

	/**
	 * @param kensakuInsNo セットする kensakuInsNo
	 */
	public void setKensakuInsNo(String kensakuInsNo) {
		this.kensakuInsNo = kensakuInsNo;
	}

	/**
	 * SelectNd401InitEntity.javakensakuDocKanjを設定
	 * @return kensakuDocKanj
	 */
	public String getKensakuDocKanj() {
		return kensakuDocKanj;
	}

	/**
	 * @param kensakuDocKanj セットする kensakuDocKanj
	 */
	public void setKensakuDocKanj(String kensakuDocKanj) {
		this.kensakuDocKanj = kensakuDocKanj;
	}

	/**
	 * SelectNd401InitEntity.javakensakuDocNoを設定
	 * @return kensakuDocNo
	 */
	public String getKensakuDocNo() {
		return kensakuDocNo;
	}

	/**
	 * @param kensakuDocNo セットする kensakuDocNo
	 */
	public void setKensakuDocNo(String kensakuDocNo) {
		this.kensakuDocNo = kensakuDocNo;
	}

	/**
	 * SelectNd401InitEntity.javakensakuDeptCodeを設定
	 * @return kensakuDeptCode
	 */
	public String getKensakuDeptCode() {
		return kensakuDeptCode;
	}

	/**
	 * @param kensakuDeptCode セットする kensakuDeptCode
	 */
	public void setKensakuDeptCode(String kensakuDeptCode) {
		this.kensakuDeptCode = kensakuDeptCode;
	}

	/**
	 * SelectNd401InitEntity.javakensakuSosCdを設定
	 * @return kensakuSosCd
	 */
	public String getKensakuSosCd() {
		return kensakuSosCd;
	}

	/**
	 * @param kensakuSosCd セットする kensakuSosCd
	 */
	public void setKensakuSosCd(String kensakuSosCd) {
		this.kensakuSosCd = kensakuSosCd;
	}

	/**
	 * SelectNd401InitEntity.javakensakuBumonRankを設定
	 * @return kensakuBumonRank
	 */
	public String getKensakuBumonRank() {
		return kensakuBumonRank;
	}

	/**
	 * @param kensakuBumonRank セットする kensakuBumonRank
	 */
	public void setKensakuBumonRank(String kensakuBumonRank) {
		this.kensakuBumonRank = kensakuBumonRank;
	}

	/**
	 * SelectNd401InitEntity.javakensakuBrCodeを設定
	 * @return kensakuBrCode
	 */
	public String getKensakuBrCode() {
		return kensakuBrCode;
	}

	/**
	 * @param kensakuBrCode セットする kensakuBrCode
	 */
	public void setKensakuBrCode(String kensakuBrCode) {
		this.kensakuBrCode = kensakuBrCode;
	}

	/**
	 * SelectNd401InitEntity.javakensakuDistCodeを設定
	 * @return kensakuDistCode
	 */
	public String getKensakuDistCode() {
		return kensakuDistCode;
	}

	/**
	 * @param kensakuDistCode セットする kensakuDistCode
	 */
	public void setKensakuDistCode(String kensakuDistCode) {
		this.kensakuDistCode = kensakuDistCode;
	}

	/**
	 * SelectNd401InitEntity.javakensakuJgiNoを設定
	 * @return kensakuJgiNo
	 */
	public String getKensakuJgiNo() {
		return kensakuJgiNo;
	}

	/**
	 * @param kensakuJgiNo セットする kensakuJgiNo
	 */
	public void setKensakuJgiNo(String kensakuJgiNo) {
		this.kensakuJgiNo = kensakuJgiNo;
	}
}
