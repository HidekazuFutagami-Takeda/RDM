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
 * テーブル物理名 : M_RDM_HCO_MST,T_RDM_REQ_KNR,T_RDM_HCP_REQ
 * SQLID : selectNF011ULTData,selectNF011REQData
 * @generated
 */
public class SelectNF013MainDataEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_申請ID(パラメータ1)
     * @generated
     */
    private String inReqId;

    /**
     * 入力_施設コード (パラメータ2)
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
     * 申請者所属名称
     * @generated
     */
    private String reqShzNm;

    /**
     * 申請ステータス名称
     * @generated
     */
    private String reqStsNm;

    /**
     * 申請者氏名
     * @generated
     */
    private String reqJgiName;

    /**
     * 申請日時
     * @generated
     */
    private String reqYmdhms;

    /**
     * 審査者氏名
     * @generated
     */
    private String shnShaName;

    /**
     * 審査日時
     * @generated
     */
    private String shnYmdhms;

    /**
     * 承認者氏名
     * @generated
     */
    private String aprShaName;

    /**
     * 承認日時
     * @generated
     */
    private String aprYmdhms;

    /**
     * 申請者従業員番号
     * @generated
     */
    private Integer reqJgiNo;

    /**
     * 申請者医薬支店C
     * @generated
     */
    private String reqBrCd;

    /**
     * 申請者医薬営業所C
     * @generated
     */
    private String reqDistCd;

    /**
     * 申請ステータスコード
     * @generated
     */
    private String reqStsCd;

    /**
     * 審査者従業員番号
     * @generated
     */
    private Integer shnJgiNo;

    /**
     * 承認者従業員番号
     * @generated
     */
    private Integer aprJgiNo;

    /**
     * 更新日時
     * @generated
     */
    private String updShaYmd;

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
	 * 施設正式漢字名
	 * @generated
	 */
	private String insFormalName;

	/**
	 * 郵便番号
	 * @generated
	 */
	private String insPcode;

	/**
	 * 医師数(勤務中)
	 * @generated
	 */
	private String docCount;

	/**
	 * 医師数(申請中)
	 * @generated
	 */
	private String reqDocCount;

	/**
	 * 当期子施設数
	 * @generated
	 */
	private String insCount;

	/**
	 * 来期子施設数
	 * @generated
	 */
	private String nextInsCount;

	/**
	 * 納入実績金額（当期）T価ベース
	 * @generated
	 */
	private Integer jskValueTk;

	/**
	 * 納入実績金額（前期）T価ベース
	 * @generated
	 */
	private Integer jskValueZk;

	/**
	 * 納入実績金額（前々期）T価ベース
	 * @generated
	 */
	private Integer jskValueZzk;

	/**
	 * 施設住所
	 * @generated
	 */
	private String insAddr;

	/**
	 * 変更前削除区分
	 * @generated
	 */
	private String preDelKbn;

	/**
	 * 削除区分
	 * @generated
	 */
	private String delKbn;

	/**
	 * 廃院日
	 * @generated
	 */
	private String delYmd;

	/**
	 * 削除理由
	 * @generated
	 */
	private String delReason;

	/**
	 * 重複施設固定コード
	 * @generated
	 */
	private String dupInsNo;

	/**
	 * 重複施設略式漢字名
	 * @generated
	 */
	private String dupInsAbbrName;

	/**
	 * 重複施設住所
	 * @generated
	 */
	private String dupInsAddr;

    /**
     * 申請コメント
     * @generated
     */
    private String reqComment;

    /**
     * 審査・承認メモ
     * @generated
     */
    private String aprMemo;

	/**
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNF013MainDataEntity() {
        super("t_rdm_hco_req" , "selectNF013REQData");
    }

	/**
	 * SelectNF013MainDataEntity.javainReqIdを設定
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
	 * SelectNF013MainDataEntity.javainInsNoを設定
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
	 * SelectNF013MainDataEntity.javareqIdを設定
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
	 * SelectNF013MainDataEntity.javareqChlを設定
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
	 * SelectNF013MainDataEntity.javareqShzNmを設定
	 * @return reqShzNm
	 */
	public String getReqShzNm() {
		return reqShzNm;
	}

	/**
	 * @param reqShzNm セットする reqShzNm
	 */
	public void setReqShzNm(String reqShzNm) {
		this.reqShzNm = reqShzNm;
	}

	/**
	 * SelectNF013MainDataEntity.javareqStsNmを設定
	 * @return reqStsNm
	 */
	public String getReqStsNm() {
		return reqStsNm;
	}

	/**
	 * @param reqStsNm セットする reqStsNm
	 */
	public void setReqStsNm(String reqStsNm) {
		this.reqStsNm = reqStsNm;
	}

	/**
	 * SelectNF013MainDataEntity.javareqJgiNameを設定
	 * @return reqJgiName
	 */
	public String getReqJgiName() {
		return reqJgiName;
	}

	/**
	 * @param reqJgiName セットする reqJgiName
	 */
	public void setReqJgiName(String reqJgiName) {
		this.reqJgiName = reqJgiName;
	}

	/**
	 * SelectNF013MainDataEntity.javareqYmdhmsを設定
	 * @return reqYmdhms
	 */
	public String getReqYmdhms() {
		return reqYmdhms;
	}

	/**
	 * @param reqYmdhms セットする reqYmdhms
	 */
	public void setReqYmdhms(String reqYmdhms) {
		this.reqYmdhms = reqYmdhms;
	}

	/**
	 * SelectNF013MainDataEntity.javashnShaNameを設定
	 * @return shnShaName
	 */
	public String getShnShaName() {
		return shnShaName;
	}

	/**
	 * @param shnShaName セットする shnShaName
	 */
	public void setShnShaName(String shnShaName) {
		this.shnShaName = shnShaName;
	}

	/**
	 * SelectNF013MainDataEntity.javashnYmdhmsを設定
	 * @return shnYmdhms
	 */
	public String getShnYmdhms() {
		return shnYmdhms;
	}

	/**
	 * @param shnYmdhms セットする shnYmdhms
	 */
	public void setShnYmdhms(String shnYmdhms) {
		this.shnYmdhms = shnYmdhms;
	}

	/**
	 * SelectNF013MainDataEntity.javaaprShaNameを設定
	 * @return aprShaName
	 */
	public String getAprShaName() {
		return aprShaName;
	}

	/**
	 * @param aprShaName セットする aprShaName
	 */
	public void setAprShaName(String aprShaName) {
		this.aprShaName = aprShaName;
	}

	/**
	 * SelectNF013MainDataEntity.javaaprYmdhmsを設定
	 * @return aprYmdhms
	 */
	public String getAprYmdhms() {
		return aprYmdhms;
	}

	/**
	 * @param aprYmdhms セットする aprYmdhms
	 */
	public void setAprYmdhms(String aprYmdhms) {
		this.aprYmdhms = aprYmdhms;
	}

	/**
	 * SelectNF013MainDataEntity.javareqJgiNoを設定
	 * @return reqJgiNo
	 */
	public Integer getReqJgiNo() {
		return reqJgiNo;
	}

	/**
	 * @param reqJgiNo セットする reqJgiNo
	 */
	public void setReqJgiNo(Integer reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}

	/**
	 * SelectNF013MainDataEntity.javareqBrCdを設定
	 * @return reqBrCd
	 */
	public String getReqBrCd() {
		return reqBrCd;
	}

	/**
	 * @param reqBrCd セットする reqBrCd
	 */
	public void setReqBrCd(String reqBrCd) {
		this.reqBrCd = reqBrCd;
	}

	/**
	 * SelectNF013MainDataEntity.javareqDistCdを設定
	 * @return reqDistCd
	 */
	public String getReqDistCd() {
		return reqDistCd;
	}

	/**
	 * @param reqDistCd セットする reqDistCd
	 */
	public void setReqDistCd(String reqDistCd) {
		this.reqDistCd = reqDistCd;
	}

	/**
	 * SelectNF013MainDataEntity.javareqStsCdを設定
	 * @return reqStsCd
	 */
	public String getReqStsCd() {
		return reqStsCd;
	}

	/**
	 * @param reqStsCd セットする reqStsCd
	 */
	public void setReqStsCd(String reqStsCd) {
		this.reqStsCd = reqStsCd;
	}

	/**
	 * SelectNF013MainDataEntity.javashnJgiNoを設定
	 * @return shnJgiNo
	 */
	public Integer getShnJgiNo() {
		return shnJgiNo;
	}

	/**
	 * @param shnJgiNo セットする shnJgiNo
	 */
	public void setShnJgiNo(Integer shnJgiNo) {
		this.shnJgiNo = shnJgiNo;
	}

	/**
	 * SelectNF013MainDataEntity.javaaprJgiNoを設定
	 * @return aprJgiNo
	 */
	public Integer getAprJgiNo() {
		return aprJgiNo;
	}

	/**
	 * @param aprJgiNo セットする aprJgiNo
	 */
	public void setAprJgiNo(Integer aprJgiNo) {
		this.aprJgiNo = aprJgiNo;
	}

	/**
	 * SelectNF013MainDataEntity.javaupdShaYmdを設定
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
	 * SelectNF013MainDataEntity.javainsNoを設定
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
	 * SelectNF013MainDataEntity.javainsAbbrNameを設定
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
	 * SelectNF013MainDataEntity.javainsFormalNameを設定
	 * @return insFormalName
	 */
	public String getInsFormalName() {
		return insFormalName;
	}

	/**
	 * @param insFormalName セットする insFormalName
	 */
	public void setInsFormalName(String insFormalName) {
		this.insFormalName = insFormalName;
	}

	/**
	 * SelectNF013MainDataEntity.javainsPcodeを設定
	 * @return insPcode
	 */
	public String getInsPcode() {
		return insPcode;
	}

	/**
	 * @param insPcode セットする insPcode
	 */
	public void setInsPcode(String insPcode) {
		this.insPcode = insPcode;
	}

	/**
	 * SelectNF013MainDataEntity.javadocCountを設定
	 * @return docCount
	 */
	public String getDocCount() {
		return docCount;
	}

	/**
	 * @param docCount セットする docCount
	 */
	public void setDocCount(String docCount) {
		this.docCount = docCount;
	}

	/**
	 * SelectNF013MainDataEntity.javareqDocCountを設定
	 * @return reqDocCount
	 */
	public String getReqDocCount() {
		return reqDocCount;
	}

	/**
	 * @param reqDocCount セットする reqDocCount
	 */
	public void setReqDocCount(String reqDocCount) {
		this.reqDocCount = reqDocCount;
	}

	/**
	 * SelectNF013MainDataEntity.javainsCountを設定
	 * @return insCount
	 */
	public String getInsCount() {
		return insCount;
	}

	/**
	 * @param insCount セットする insCount
	 */
	public void setInsCount(String insCount) {
		this.insCount = insCount;
	}

	/**
	 * SelectNF013MainDataEntity.javanextInsCountを設定
	 * @return nextInsCount
	 */
	public String getNextInsCount() {
		return nextInsCount;
	}

	/**
	 * @param nextInsCount セットする nextInsCount
	 */
	public void setNextInsCount(String nextInsCount) {
		this.nextInsCount = nextInsCount;
	}

	/**
	 * SelectNF013MainDataEntity.javajskValueTkを設定
	 * @return jskValueTk
	 */
	public Integer getJskValueTk() {
		return jskValueTk;
	}

	/**
	 * @param jskValueTk セットする jskValueTk
	 */
	public void setJskValueTk(Integer jskValueTk) {
		this.jskValueTk = jskValueTk;
	}

	/**
	 * SelectNF013MainDataEntity.javajskValueZkを設定
	 * @return jskValueZk
	 */
	public Integer getJskValueZk() {
		return jskValueZk;
	}

	/**
	 * @param jskValueZk セットする jskValueZk
	 */
	public void setJskValueZk(Integer jskValueZk) {
		this.jskValueZk = jskValueZk;
	}

	/**
	 * SelectNF013MainDataEntity.javajskValueZzkを設定
	 * @return jskValueZzk
	 */
	public Integer getJskValueZzk() {
		return jskValueZzk;
	}

	/**
	 * @param jskValueZzk セットする jskValueZzk
	 */
	public void setJskValueZzk(Integer jskValueZzk) {
		this.jskValueZzk = jskValueZzk;
	}

	/**
	 * SelectNF013MainDataEntity.javainsAddrを設定
	 * @return insAddr
	 */
	public String getInsAddr() {
		return insAddr;
	}

	/**
	 * @param insAddr セットする insAddr
	 */
	public void setInsAddr(String insAddr) {
		this.insAddr = insAddr;
	}

	/**
	 * SelectNF013MainDataEntity.javapreDelKbnを設定
	 * @return preDelKbn
	 */
	public String getPreDelKbn() {
		return preDelKbn;
	}

	/**
	 * @param preDelKbn セットする preDelKbn
	 */
	public void setPreDelKbn(String preDelKbn) {
		this.preDelKbn = preDelKbn;
	}

	/**
	 * SelectNF013MainDataEntity.javadelKbnを設定
	 * @return delKbn
	 */
	public String getDelKbn() {
		return delKbn;
	}

	/**
	 * @param delKbn セットする delKbn
	 */
	public void setDelKbn(String delKbn) {
		this.delKbn = delKbn;
	}

	/**
	 * SelectNF013MainDataEntity.javadelYmdを設定
	 * @return delYmd
	 */
	public String getDelYmd() {
		return delYmd;
	}

	/**
	 * @param delYmd セットする delYmd
	 */
	public void setDelYmd(String delYmd) {
		this.delYmd = delYmd;
	}

	/**
	 * SelectNF013MainDataEntity.javadelReasonを設定
	 * @return delReason
	 */
	public String getDelReason() {
		return delReason;
	}

	/**
	 * @param delReason セットする delReason
	 */
	public void setDelReason(String delReason) {
		this.delReason = delReason;
	}

	/**
	 * SelectNF013MainDataEntity.javadupInsNoを設定
	 * @return dupInsNo
	 */
	public String getDupInsNo() {
		return dupInsNo;
	}

	/**
	 * @param dupInsNo セットする dupInsNo
	 */
	public void setDupInsNo(String dupInsNo) {
		this.dupInsNo = dupInsNo;
	}

	/**
	 * SelectNF013MainDataEntity.javadupInsAbbrNameを設定
	 * @return dupInsAbbrName
	 */
	public String getDupInsAbbrName() {
		return dupInsAbbrName;
	}

	/**
	 * @param dupInsAbbrName セットする dupInsAbbrName
	 */
	public void setDupInsAbbrName(String dupInsAbbrName) {
		this.dupInsAbbrName = dupInsAbbrName;
	}

	/**
	 * SelectNF013MainDataEntity.javadupInsAddrを設定
	 * @return dupInsAddr
	 */
	public String getDupInsAddr() {
		return dupInsAddr;
	}

	/**
	 * @param dupInsAddr セットする dupInsAddr
	 */
	public void setDupInsAddr(String dupInsAddr) {
		this.dupInsAddr = dupInsAddr;
	}

	/**
	 * SelectNF013MainDataEntity.javareqCommentを設定
	 * @return reqComment
	 */
	public String getReqComment() {
		return reqComment;
	}

	/**
	 * @param reqComment セットする reqComment
	 */
	public void setReqComment(String reqComment) {
		this.reqComment = reqComment;
	}

	/**
	 * SelectNF013MainDataEntity.javaaprMemoを設定
	 * @return aprMemo
	 */
	public String getAprMemo() {
		return aprMemo;
	}

	/**
	 * @param aprMemo セットする aprMemo
	 */
	public void setAprMemo(String aprMemo) {
		this.aprMemo = aprMemo;
	}

	/**
	 * SelectNF013MainDataEntity.javashnFlgを設定
	 * @return shnFlg
	 */
	public String getShnFlg() {
		return shnFlg;
	}

	/**
	 * @param shnFlg セットする shnFlg
	 */
	public void setShnFlg(String shnFlg) {
		this.shnFlg = shnFlg;
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
