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
 * テーブル物理名 : T_RDM_HCP_KMU_REQ
 * SQLID : selectDocReqKnrInsChange
 */
public class SelectDocReqKnrInsChangeEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 申請フラグ(パラメータ)
     */
    private Integer inReqFlg;

    /**
     * 申請ID(パラメータ)
     */
    private String inReqId;

    /**
     * 申請ID(パラメータ)
     */
    private String inDocNo;

    /**
     * 申請ID(パラメータ)
     */
    private String inInsNo;

    /**
     * 申請ID
     */
    private String reqId;

    /**
     * 申請者所属
     */
    private String reqShz;

    /**
     * 申請ステータス名
     */
    private String reqStsNm;

    /**
     * 申請ステータス
     */
    private String reqSts;

    /**
     * 申請者氏名
     */
    private String reqJgiName;

    /**
     * 申請者従業員番号
     */
    private String reqJgiNo;

    /**
     * 申請日時
     */
    private String reqYmdhms;

    /**
     * 変更前-医師・コメディカル名
     */
    private String docKanj;

    /**
     * 変更前-所属施設
     */
    private String preInsAbbrName;

    /**
     * 変更前-所属部科
     */
    private String preDeptKj;

    /**
     * 変更前-役職
     */
    private String titlePreTitleKj;

    /**
     * 変更前-勤務形態
     */
    private String kmuPreCodeKanj;

    /**
     * 変更前-薬審メンバー区分
     */
    private String yakushinPreCodeKanj;

    /**
     * 変更前-大学職位
     */
    private String univPreTitleKj;

    /**
     * 変更前-異動区分
     */
    private String trnKbn;

    /**
     * 変更後-所属施設
     */
    private String postInsAbbrName;

    /**
     * 変更後-所属部科
     */
    private String postDeptKj;

    /**
     * 変更後-役職
     */
    private String titlePostTitleKj;

    /**
     * 変更後-勤務形態
     */
    private String kmuPostCodeKanj;

    /**
     * 変更後-薬審メンバー区分
     */
    private String yakushinPostCodeKanj;

    /**
     * 変更後-大学職位
     */
    private String univPostTitleKj;


    /**
     * 変更後-大学職位
     */
    private String aprYmdhms;

    /**
     * 申請コメント
     */
    private String reqComment;

    /**
     * 申請者医薬支店C
     */
    private String reqBrCode;

    /**
     * 申請者医薬支店C
     */
    private String reqDistCode;

    /**
     * 更新日時
     */
    private String updShaYmd;

    /**
     * 医師固定C
     */
    private String docNo;

    /**
     * ULT医師コード
     */
    private String ultDocNo;

    /**
     * 所属施設コード(元)
     */
    private String preInsNo;

    /**
     * 所属施設ULTコード(元)
     */
    private String preUltInsNo;

    /**
     * 所属部科コード(元)
     */
    private String preDeptCode;

    /**
     * 所属部科カナ(元)
     */
    private String preDeptKn;

    /**
     * 役職コード(元)
     */
    private String preTitleCode;

    /**
     * 勤務形態コード(元)
     */
    private String preJobForm;

    /**
     * 薬審メンバー区分(元)
     */
    private String preDcc;

    /**
     * 大学職位(元)
     */
    private String preUnivPosCode;

    /**
     * 所属施設コード(先)
     */
    private String postInsNo;

    /**
     * 所属施設ULTコード(先)
     */
    private String postUltInsNo;

    /**
     * 所属部科(先)
     */
    private String postDeptCode;

    /**
     * 所属部科カナ(先)
     */
    private String postDeptKn;

    /**
     * 役職コード(先)
     */
    private String postTitleCode;

    /**
     * 勤務形態コード(先)
     */
    private String postJobForm;

    /**
     * 薬審メンバー区分(先)
     */
    private String postDcc;

    /**
     * 大学職位(先)
     */
    private String postUnivPosCode;

    /**
     * 適用開始日
     */
    private String tekiyoYmd;

    /**
     * 却下コメント
     */
    private String aprComment;

    /**
     * 対象区分(元)
     */
    private String preHoInsType;

    /**
     * 対象区分(先)
     */
    private String postHoInsType;

    /**
     * 申請区分
     */
    private String reqType;
    /**
     * コンストラクタ
     * @generated
     */
    public SelectDocReqKnrInsChangeEntity() {
        super("t_rdm_hcp_kmu_req" , "selectDocReqKnrInsChange");
    }

	/**
	 * SelectDocReqKnrInsChangeEntity.javainReqFlgを設定
	 * @return inReqFlg
	 */
	public Integer getInReqFlg() {
		return inReqFlg;
	}

	/**
	 * @param inReqFlg セットする inReqFlg
	 */
	public void setInReqFlg(Integer inReqFlg) {
		this.inReqFlg = inReqFlg;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javainReqIdを設定
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
	 * SelectDocReqKnrInsChangeEntity.javainDocNoを設定
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
	 * SelectDocReqKnrInsChangeEntity.javainInsNoを設定
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
	 * SelectDocReqKnrInsChangeEntity.javareqIdを設定
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
	 * SelectDocReqKnrInsChangeEntity.javareqShzを設定
	 * @return reqShz
	 */
	public String getReqShz() {
		return reqShz;
	}

	/**
	 * @param reqShz セットする reqShz
	 */
	public void setReqShz(String reqShz) {
		this.reqShz = reqShz;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javareqStsNmを設定
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
	 * SelectDocReqKnrInsChangeEntity.javareqStsを設定
	 * @return reqSts
	 */
	public String getReqSts() {
		return reqSts;
	}

	/**
	 * @param reqSts セットする reqSts
	 */
	public void setReqSts(String reqSts) {
		this.reqSts = reqSts;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javareqJgiNameを設定
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
	 * SelectDocReqKnrInsChangeEntity.javareqJgiNoを設定
	 * @return reqJgiNo
	 */
	public String getReqJgiNo() {
		return reqJgiNo;
	}

	/**
	 * @param reqJgiNo セットする reqJgiNo
	 */
	public void setReqJgiNo(String reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javareqYmdhmsを設定
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
	 * SelectDocReqKnrInsChangeEntity.javadocKanjを設定
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
	 * SelectDocReqKnrInsChangeEntity.javapreInsAbbrNameを設定
	 * @return preInsAbbrName
	 */
	public String getPreInsAbbrName() {
		return preInsAbbrName;
	}

	/**
	 * @param preInsAbbrName セットする preInsAbbrName
	 */
	public void setPreInsAbbrName(String preInsAbbrName) {
		this.preInsAbbrName = preInsAbbrName;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapreDeptKjを設定
	 * @return preDeptKj
	 */
	public String getPreDeptKj() {
		return preDeptKj;
	}

	/**
	 * @param preDeptKj セットする preDeptKj
	 */
	public void setPreDeptKj(String preDeptKj) {
		this.preDeptKj = preDeptKj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javatitlePreTitleKjを設定
	 * @return titlePreTitleKj
	 */
	public String getTitlePreTitleKj() {
		return titlePreTitleKj;
	}

	/**
	 * @param titlePreTitleKj セットする titlePreTitleKj
	 */
	public void setTitlePreTitleKj(String titlePreTitleKj) {
		this.titlePreTitleKj = titlePreTitleKj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javakmuPreCodeKanjを設定
	 * @return kmuPreCodeKanj
	 */
	public String getKmuPreCodeKanj() {
		return kmuPreCodeKanj;
	}

	/**
	 * @param kmuPreCodeKanj セットする kmuPreCodeKanj
	 */
	public void setKmuPreCodeKanj(String kmuPreCodeKanj) {
		this.kmuPreCodeKanj = kmuPreCodeKanj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javayakushinPreCodeKanjを設定
	 * @return yakushinPreCodeKanj
	 */
	public String getYakushinPreCodeKanj() {
		return yakushinPreCodeKanj;
	}

	/**
	 * @param yakushinPreCodeKanj セットする yakushinPreCodeKanj
	 */
	public void setYakushinPreCodeKanj(String yakushinPreCodeKanj) {
		this.yakushinPreCodeKanj = yakushinPreCodeKanj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javaunivPreTitleKjを設定
	 * @return univPreTitleKj
	 */
	public String getUnivPreTitleKj() {
		return univPreTitleKj;
	}

	/**
	 * @param univPreTitleKj セットする univPreTitleKj
	 */
	public void setUnivPreTitleKj(String univPreTitleKj) {
		this.univPreTitleKj = univPreTitleKj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javatrnKbnを設定
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
	 * SelectDocReqKnrInsChangeEntity.javapostInsAbbrNameを設定
	 * @return postInsAbbrName
	 */
	public String getPostInsAbbrName() {
		return postInsAbbrName;
	}

	/**
	 * @param postInsAbbrName セットする postInsAbbrName
	 */
	public void setPostInsAbbrName(String postInsAbbrName) {
		this.postInsAbbrName = postInsAbbrName;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapostDeptKjを設定
	 * @return postDeptKj
	 */
	public String getPostDeptKj() {
		return postDeptKj;
	}

	/**
	 * @param postDeptKj セットする postDeptKj
	 */
	public void setPostDeptKj(String postDeptKj) {
		this.postDeptKj = postDeptKj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javatitlePostTitleKjを設定
	 * @return titlePostTitleKj
	 */
	public String getTitlePostTitleKj() {
		return titlePostTitleKj;
	}

	/**
	 * @param titlePostTitleKj セットする titlePostTitleKj
	 */
	public void setTitlePostTitleKj(String titlePostTitleKj) {
		this.titlePostTitleKj = titlePostTitleKj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javakmuPostCodeKanjを設定
	 * @return kmuPostCodeKanj
	 */
	public String getKmuPostCodeKanj() {
		return kmuPostCodeKanj;
	}

	/**
	 * @param kmuPostCodeKanj セットする kmuPostCodeKanj
	 */
	public void setKmuPostCodeKanj(String kmuPostCodeKanj) {
		this.kmuPostCodeKanj = kmuPostCodeKanj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javayakushinPostCodeKanjを設定
	 * @return yakushinPostCodeKanj
	 */
	public String getYakushinPostCodeKanj() {
		return yakushinPostCodeKanj;
	}

	/**
	 * @param yakushinPostCodeKanj セットする yakushinPostCodeKanj
	 */
	public void setYakushinPostCodeKanj(String yakushinPostCodeKanj) {
		this.yakushinPostCodeKanj = yakushinPostCodeKanj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javaunivPostTitleKjを設定
	 * @return univPostTitleKj
	 */
	public String getUnivPostTitleKj() {
		return univPostTitleKj;
	}

	/**
	 * @param univPostTitleKj セットする univPostTitleKj
	 */
	public void setUnivPostTitleKj(String univPostTitleKj) {
		this.univPostTitleKj = univPostTitleKj;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javaaprYmdhmsを設定
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
	 * SelectDocReqKnrInsChangeEntity.javareqCommentを設定
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
	 * SelectDocReqKnrInsChangeEntity.javareqBrCodeを設定
	 * @return reqBrCode
	 */
	public String getReqBrCode() {
		return reqBrCode;
	}

	/**
	 * @param reqBrCode セットする reqBrCode
	 */
	public void setReqBrCode(String reqBrCode) {
		this.reqBrCode = reqBrCode;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javareqDistCodeを設定
	 * @return reqDistCode
	 */
	public String getReqDistCode() {
		return reqDistCode;
	}

	/**
	 * @param reqDistCode セットする reqDistCode
	 */
	public void setReqDistCode(String reqDistCode) {
		this.reqDistCode = reqDistCode;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javaupdShaYmdを設定
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
	 * SelectDocReqKnrInsChangeEntity.javadocNoを設定
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
	 * SelectDocReqKnrInsChangeEntity.javaultDocNoを設定
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
	 * SelectDocReqKnrInsChangeEntity.javapreInsNoを設定
	 * @return preInsNo
	 */
	public String getPreInsNo() {
		return preInsNo;
	}

	/**
	 * @param preInsNo セットする preInsNo
	 */
	public void setPreInsNo(String preInsNo) {
		this.preInsNo = preInsNo;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapreUltInsNoを設定
	 * @return preUltInsNo
	 */
	public String getPreUltInsNo() {
		return preUltInsNo;
	}

	/**
	 * @param preUltInsNo セットする preUltInsNo
	 */
	public void setPreUltInsNo(String preUltInsNo) {
		this.preUltInsNo = preUltInsNo;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapreDeptCodeを設定
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
	 * SelectDocReqKnrInsChangeEntity.javapreDeptKnを設定
	 * @return preDeptKn
	 */
	public String getPreDeptKn() {
		return preDeptKn;
	}

	/**
	 * @param preDeptKn セットする preDeptKn
	 */
	public void setPreDeptKn(String preDeptKn) {
		this.preDeptKn = preDeptKn;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapreTitleCodeを設定
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
	 * SelectDocReqKnrInsChangeEntity.javapreJobFormを設定
	 * @return preJobForm
	 */
	public String getPreJobForm() {
		return preJobForm;
	}

	/**
	 * @param preJobForm セットする preJobForm
	 */
	public void setPreJobForm(String preJobForm) {
		this.preJobForm = preJobForm;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapreDccを設定
	 * @return preDcc
	 */
	public String getPreDcc() {
		return preDcc;
	}

	/**
	 * @param preDcc セットする preDcc
	 */
	public void setPreDcc(String preDcc) {
		this.preDcc = preDcc;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapreUnivPosCodeを設定
	 * @return preUnivPosCode
	 */
	public String getPreUnivPosCode() {
		return preUnivPosCode;
	}

	/**
	 * @param preUnivPosCode セットする preUnivPosCode
	 */
	public void setPreUnivPosCode(String preUnivPosCode) {
		this.preUnivPosCode = preUnivPosCode;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapostInsNoを設定
	 * @return postInsNo
	 */
	public String getPostInsNo() {
		return postInsNo;
	}

	/**
	 * @param postInsNo セットする postInsNo
	 */
	public void setPostInsNo(String postInsNo) {
		this.postInsNo = postInsNo;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapostUltInsNoを設定
	 * @return postUltInsNo
	 */
	public String getPostUltInsNo() {
		return postUltInsNo;
	}

	/**
	 * @param postUltInsNo セットする postUltInsNo
	 */
	public void setPostUltInsNo(String postUltInsNo) {
		this.postUltInsNo = postUltInsNo;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapostDeptCodeを設定
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
	 * SelectDocReqKnrInsChangeEntity.javapostDeptKnを設定
	 * @return postDeptKn
	 */
	public String getPostDeptKn() {
		return postDeptKn;
	}

	/**
	 * @param postDeptKn セットする postDeptKn
	 */
	public void setPostDeptKn(String postDeptKn) {
		this.postDeptKn = postDeptKn;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapostTitleCodeを設定
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
	 * SelectDocReqKnrInsChangeEntity.javapostJobFormを設定
	 * @return postJobForm
	 */
	public String getPostJobForm() {
		return postJobForm;
	}

	/**
	 * @param postJobForm セットする postJobForm
	 */
	public void setPostJobForm(String postJobForm) {
		this.postJobForm = postJobForm;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapostDccを設定
	 * @return postDcc
	 */
	public String getPostDcc() {
		return postDcc;
	}

	/**
	 * @param postDcc セットする postDcc
	 */
	public void setPostDcc(String postDcc) {
		this.postDcc = postDcc;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapostUnivPosCodeを設定
	 * @return postUnivPosCode
	 */
	public String getPostUnivPosCode() {
		return postUnivPosCode;
	}

	/**
	 * @param postUnivPosCode セットする postUnivPosCode
	 */
	public void setPostUnivPosCode(String postUnivPosCode) {
		this.postUnivPosCode = postUnivPosCode;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javatekiyoYmdを設定
	 * @return tekiyoYmd
	 */
	public String getTekiyoYmd() {
		return tekiyoYmd;
	}

	/**
	 * @param tekiyoYmd セットする tekiyoYmd
	 */
	public void setTekiyoYmd(String tekiyoYmd) {
		this.tekiyoYmd = tekiyoYmd;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javaaprCommentを設定
	 * @return aprComment
	 */
	public String getAprComment() {
		return aprComment;
	}

	/**
	 * @param aprComment セットする aprComment
	 */
	public void setAprComment(String aprComment) {
		this.aprComment = aprComment;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapreHoInsTypeを設定
	 * @return preHoInsType
	 */
	public String getPreHoInsType() {
		return preHoInsType;
	}

	/**
	 * @param preHoInsType セットする preHoInsType
	 */
	public void setPreHoInsType(String preHoInsType) {
		this.preHoInsType = preHoInsType;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javapostHoInsTypeを設定
	 * @return postHoInsType
	 */
	public String getPostHoInsType() {
		return postHoInsType;
	}

	/**
	 * @param postHoInsType セットする postHoInsType
	 */
	public void setPostHoInsType(String postHoInsType) {
		this.postHoInsType = postHoInsType;
	}

	/**
	 * SelectDocReqKnrInsChangeEntity.javareqTypeを設定
	 * @return reqType
	 */
	public String getReqType() {
		return reqType;
	}

	/**
	 * @param reqType セットする reqType
	 */
	public void setReqType(String reqType) {
		this.reqType = reqType;
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
