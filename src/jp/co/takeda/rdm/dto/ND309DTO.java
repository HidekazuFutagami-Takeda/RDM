/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;

import jp.co.takeda.rdm.common.BaseDTO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * DTOクラス
 */
public class ND309DTO extends BaseDTO implements Serializable {

    /**
     * テスト用JgiNo 製造終ったら消すこと
     */
    private String gamenJgiNo;


    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     */
    private String ND309 = "ND309";

	/**
	 * ND102遷移元画面
	 * 申請破棄ボタン押下時の遷移先保持用
	 *
	 */
	private String nd102PreScreenId;

	/**
     * タイトル
     */
    private String title;
	/**
     * 条件セット
     */
    private String jokenSetCd;

	/**
     * MR権限/管理者権限判定
     */
    private String mrAdminFlg;

	/**
     * 遷移元画面
     */
    private String preScreenId;

	/**
     * 申請フラグ
     */
    private String reqFlg;

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
     * 対象区分(先)
     */
    private String postHoInsType;

    /**
     * 施設分類(先)
     */
    private String postInsClass;

    /**
     * 大学職位(先)
     */
    private String postUnivPosCode;

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
     * 対象区分(元)
     */
    private String preHoInsType;

    /**
     * 施設分類(元)
     */
    private String preInsClass;

    /**
     * ULT医師コード
     */
    private String ultDocNo;

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
     * 変更後-異動区分
     */
    private String postTrnKbn;

    /**
     * 申請コメント
     */
    private String reqComment;

    /**
     * 却下コメント
     */
    private String aprComment;

    /**
     * 医師固定コード
     */
    private String docNo;

    /**
     * 施設固定コード
     */
    private String insNo;

    /**
     * 異動・更新フラグ
     */
    private String movemedEditFlg;

    /**
     * 入力項目活性不活性フラグ　活性:1 不活性:0
     */
    private String inputFlg;

    /**
     * 申請コメント活性不活性フラグ　活性:1 不活性:0
     */
    private String reqCommentFlg;

    /**
     * 役職
     */
    private String yakushoku;

    /**
     * 役職リスト
     */
    private LinkedHashMap<String, String> yakushokuCombo;

    /**
     * 勤務形態
     */
    private String jobForm;

    /**
     * 勤務形態リスト
     */
    private LinkedHashMap<String, String> jobFormCombo;

    /**
     * 薬審メンバー区分
     */
    private String dcc;

    /**
     * 薬審メンバー区分リスト
     */
    private LinkedHashMap<String, String> dccCombo;

    /**
     * 大学職位
     */
    private String digakuShokui;

    /**
     * 大学職位リスト
     */
    private LinkedHashMap<String, String> digakuShokuiCombo;

    /**
     * 異動区分
     */
    private String trnKbnCd;

    /**
     * 異動区分リスト
     */
    private LinkedHashMap<String, String> trnKbnCombo;

    /**
     * 異動区分（施設コード）
     */
    private String trnKbnInsNo;

    /**
     * 異動区分（施設コード）リスト
     */
    private LinkedHashMap<String, String> trnKbnInsNoCombo;

    /**
     * 申請破棄ボタンフラグ
     */
    private String reqDestBtnFlg;

    /**
     * 一時保存ボタンフラグ
     */
    private String tempReqBtnFlg;

    /**
     * 申請画面へボタンフラグ
     */
    private String reqBtnFlg;

    /**
     * 適用日付
     */
    private String dispTekiyoYmd;

    /**
     * 適用日付初期値
     */
    private String tekiyoInitDay;

    /**
     * 適用日付選択値
     */
    private String selectDay;

	/**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

	/**
	 * アラートメッセージ中身
	 * @generated
	 */
	private String AlertMsgStr;

	/**
	 * アラートメッセージ中身2
	 * @generated
	 */
	private String alertMsgStr2;

	/**
	 * 警告無視フラグ 1の場合、廃業・死亡の警告を無視
	 * @generated
	 */
	private String alertIgnore;


	/**
	 * 押下ボタンフラグ
	 * @generated
	 */
	private String tempButtonExecuted;

	/**
	 * 承認ボタン表示フラグ 0　非表示　1　表示
	 * @generated
	 */
	private String nd309AppdFlg;

	/**
	 * 却下ボタン表示フラグ 0　非表示　1  表示
	 * @generated
	 */
	private String nd309RejectFlg;

	/**
	 * 承認活性不活性フラグ 0　非活性　1　活性
	 * @generated
	 */
	private String nd309AppdActiveFlg;

	/**
	 * 承認活性不活性フラグ 0　非活性　1  活性
	 * @generated
	 */
	private String nd309RejectActiveFlg;

    /**
     * 申請チャネル
     */
    private String reqChl;

	/**
	 * ボタン押下時の処理フラグ
	 * @generated
	 */
	private String funcId;


    /**
     * 申請画面へボタン活性非活性フラグ
     */
	private String reqBtnActiveFlg;

    /**
     * 申請区分
     */
	private String reqType;

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND309DTO() {
        setForward(ND309);
    }

	/**
	 * ND309DTO.javagamenJgiNoを設定
	 * @return gamenJgiNo
	 */
	public String getGamenJgiNo() {
		return gamenJgiNo;
	}

	/**
	 * @param gamenJgiNo セットする gamenJgiNo
	 */
	public void setGamenJgiNo(String gamenJgiNo) {
		this.gamenJgiNo = gamenJgiNo;
	}

	/**
	 * ND309DTO.javaND309を設定
	 * @return nD309
	 */
	public String getND309() {
		return ND309;
	}

	/**
	 * @param nD309 セットする nD309
	 */
	public void setND309(String nD309) {
		ND309 = nD309;
	}

	/**
	 * ND309DTO.javand102PreScreenIdを設定
	 * @return nd102PreScreenId
	 */
	public String getNd102PreScreenId() {
		return nd102PreScreenId;
	}

	/**
	 * @param nd102PreScreenId セットする nd102PreScreenId
	 */
	public void setNd102PreScreenId(String nd102PreScreenId) {
		this.nd102PreScreenId = nd102PreScreenId;
	}

	/**
	 * ND309DTO.javatitleを設定
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ND309DTO.javajokenSetCdを設定
	 * @return jokenSetCd
	 */
	public String getJokenSetCd() {
		return jokenSetCd;
	}

	/**
	 * @param jokenSetCd セットする jokenSetCd
	 */
	public void setJokenSetCd(String jokenSetCd) {
		this.jokenSetCd = jokenSetCd;
	}

	/**
	 * ND309DTO.javamrAdminFlgを設定
	 * @return mrAdminFlg
	 */
	public String getMrAdminFlg() {
		return mrAdminFlg;
	}

	/**
	 * @param mrAdminFlg セットする mrAdminFlg
	 */
	public void setMrAdminFlg(String mrAdminFlg) {
		this.mrAdminFlg = mrAdminFlg;
	}

	/**
	 * ND309DTO.javapreScreenIdを設定
	 * @return preScreenId
	 */
	public String getPreScreenId() {
		return preScreenId;
	}

	/**
	 * @param preScreenId セットする preScreenId
	 */
	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

	/**
	 * ND309DTO.javareqFlgを設定
	 * @return reqFlg
	 */
	public String getReqFlg() {
		return reqFlg;
	}

	/**
	 * @param reqFlg セットする reqFlg
	 */
	public void setReqFlg(String reqFlg) {
		this.reqFlg = reqFlg;
	}

	/**
	 * ND309DTO.javareqIdを設定
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
	 * ND309DTO.javareqShzを設定
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
	 * ND309DTO.javareqStsNmを設定
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
	 * ND309DTO.javareqStsを設定
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
	 * ND309DTO.javareqJgiNameを設定
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
	 * ND309DTO.javareqJgiNoを設定
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
	 * ND309DTO.javareqYmdhmsを設定
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
	 * ND309DTO.javareqBrCodeを設定
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
	 * ND309DTO.javareqDistCodeを設定
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
	 * ND309DTO.javaupdShaYmdを設定
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
	 * ND309DTO.javapostInsNoを設定
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
	 * ND309DTO.javapostUltInsNoを設定
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
	 * ND309DTO.javapostDeptCodeを設定
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
	 * ND309DTO.javapostDeptKnを設定
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
	 * ND309DTO.javapostTitleCodeを設定
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
	 * ND309DTO.javapostJobFormを設定
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
	 * ND309DTO.javapostDccを設定
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
	 * ND309DTO.javapostHoInsTypeを設定
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
	 * ND309DTO.javapostInsClassを設定
	 * @return postInsClass
	 */
	public String getPostInsClass() {
		return postInsClass;
	}

	/**
	 * @param postInsClass セットする postInsClass
	 */
	public void setPostInsClass(String postInsClass) {
		this.postInsClass = postInsClass;
	}

	/**
	 * ND309DTO.javapostUnivPosCodeを設定
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
	 * ND309DTO.javapreInsNoを設定
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
	 * ND309DTO.javapreUltInsNoを設定
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
	 * ND309DTO.javapreDeptCodeを設定
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
	 * ND309DTO.javapreDeptKnを設定
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
	 * ND309DTO.javapreTitleCodeを設定
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
	 * ND309DTO.javapreJobFormを設定
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
	 * ND309DTO.javapreDccを設定
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
	 * ND309DTO.javapreUnivPosCodeを設定
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
	 * ND309DTO.javapreHoInsTypeを設定
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
	 * ND309DTO.javapreInsClassを設定
	 * @return preInsClass
	 */
	public String getPreInsClass() {
		return preInsClass;
	}

	/**
	 * @param preInsClass セットする preInsClass
	 */
	public void setPreInsClass(String preInsClass) {
		this.preInsClass = preInsClass;
	}

	/**
	 * ND309DTO.javaultDocNoを設定
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
	 * ND309DTO.javadocKanjを設定
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
	 * ND309DTO.javapreInsAbbrNameを設定
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
	 * ND309DTO.javapreDeptKjを設定
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
	 * ND309DTO.javatitlePreTitleKjを設定
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
	 * ND309DTO.javakmuPreCodeKanjを設定
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
	 * ND309DTO.javayakushinPreCodeKanjを設定
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
	 * ND309DTO.javaunivPreTitleKjを設定
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
	 * ND309DTO.javatrnKbnを設定
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
	 * ND309DTO.javapostInsAbbrNameを設定
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
	 * ND309DTO.javapostDeptKjを設定
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
	 * ND309DTO.javatitlePostTitleKjを設定
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
	 * ND309DTO.javakmuPostCodeKanjを設定
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
	 * ND309DTO.javayakushinPostCodeKanjを設定
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
	 * ND309DTO.javaunivPostTitleKjを設定
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
	 * ND309DTO.javapostTrnKbnを設定
	 * @return postTrnKbn
	 */
	public String getPostTrnKbn() {
		return postTrnKbn;
	}

	/**
	 * @param postTrnKbn セットする postTrnKbn
	 */
	public void setPostTrnKbn(String postTrnKbn) {
		this.postTrnKbn = postTrnKbn;
	}

	/**
	 * ND309DTO.javareqCommentを設定
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
	 * ND309DTO.javaaprCommentを設定
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
	 * ND309DTO.javadocNoを設定
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
	 * ND309DTO.javainsNoを設定
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
	 * ND309DTO.javamovemedEditFlgを設定
	 * @return movemedEditFlg
	 */
	public String getMovemedEditFlg() {
		return movemedEditFlg;
	}

	/**
	 * @param movemedEditFlg セットする movemedEditFlg
	 */
	public void setMovemedEditFlg(String movemedEditFlg) {
		this.movemedEditFlg = movemedEditFlg;
	}

	/**
	 * ND309DTO.javainputFlgを設定
	 * @return inputFlg
	 */
	public String getInputFlg() {
		return inputFlg;
	}

	/**
	 * @param inputFlg セットする inputFlg
	 */
	public void setInputFlg(String inputFlg) {
		this.inputFlg = inputFlg;
	}

	/**
	 * ND309DTO.javareqCommentFlgを設定
	 * @return reqCommentFlg
	 */
	public String getReqCommentFlg() {
		return reqCommentFlg;
	}

	/**
	 * @param reqCommentFlg セットする reqCommentFlg
	 */
	public void setReqCommentFlg(String reqCommentFlg) {
		this.reqCommentFlg = reqCommentFlg;
	}

	/**
	 * ND309DTO.javayakushokuを設定
	 * @return yakushoku
	 */
	public String getYakushoku() {
		return yakushoku;
	}

	/**
	 * @param yakushoku セットする yakushoku
	 */
	public void setYakushoku(String yakushoku) {
		this.yakushoku = yakushoku;
	}

	/**
	 * ND309DTO.javayakushokuComboを設定
	 * @return yakushokuCombo
	 */
	public LinkedHashMap<String, String> getYakushokuCombo() {
		return yakushokuCombo;
	}

	/**
	 * @param yakushokuCombo セットする yakushokuCombo
	 */
	public void setYakushokuCombo(LinkedHashMap<String, String> yakushokuCombo) {
		this.yakushokuCombo = yakushokuCombo;
	}

	/**
	 * ND309DTO.javajobFormを設定
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
	 * ND309DTO.javajobFormComboを設定
	 * @return jobFormCombo
	 */
	public LinkedHashMap<String, String> getJobFormCombo() {
		return jobFormCombo;
	}

	/**
	 * @param jobFormCombo セットする jobFormCombo
	 */
	public void setJobFormCombo(LinkedHashMap<String, String> jobFormCombo) {
		this.jobFormCombo = jobFormCombo;
	}

	/**
	 * ND309DTO.javadccを設定
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
	 * ND309DTO.javadccComboを設定
	 * @return dccCombo
	 */
	public LinkedHashMap<String, String> getDccCombo() {
		return dccCombo;
	}

	/**
	 * @param dccCombo セットする dccCombo
	 */
	public void setDccCombo(LinkedHashMap<String, String> dccCombo) {
		this.dccCombo = dccCombo;
	}

	/**
	 * ND309DTO.javadigakuShokuiを設定
	 * @return digakuShokui
	 */
	public String getDigakuShokui() {
		return digakuShokui;
	}

	/**
	 * @param digakuShokui セットする digakuShokui
	 */
	public void setDigakuShokui(String digakuShokui) {
		this.digakuShokui = digakuShokui;
	}

	/**
	 * ND309DTO.javadigakuShokuiComboを設定
	 * @return digakuShokuiCombo
	 */
	public LinkedHashMap<String, String> getDigakuShokuiCombo() {
		return digakuShokuiCombo;
	}

	/**
	 * @param digakuShokuiCombo セットする digakuShokuiCombo
	 */
	public void setDigakuShokuiCombo(LinkedHashMap<String, String> digakuShokuiCombo) {
		this.digakuShokuiCombo = digakuShokuiCombo;
	}

	/**
	 * ND309DTO.javatrnKbnCdを設定
	 * @return trnKbnCd
	 */
	public String getTrnKbnCd() {
		return trnKbnCd;
	}

	/**
	 * @param trnKbnCd セットする trnKbnCd
	 */
	public void setTrnKbnCd(String trnKbnCd) {
		this.trnKbnCd = trnKbnCd;
	}

	/**
	 * ND309DTO.javatrnKbnComboを設定
	 * @return trnKbnCombo
	 */
	public LinkedHashMap<String, String> getTrnKbnCombo() {
		return trnKbnCombo;
	}

	/**
	 * @param trnKbnCombo セットする trnKbnCombo
	 */
	public void setTrnKbnCombo(LinkedHashMap<String, String> trnKbnCombo) {
		this.trnKbnCombo = trnKbnCombo;
	}

	/**
	 * ND309DTO.javatrnKbnInsNoを設定
	 * @return trnKbnInsNo
	 */
	public String getTrnKbnInsNo() {
		return trnKbnInsNo;
	}

	/**
	 * @param trnKbnInsNo セットする trnKbnInsNo
	 */
	public void setTrnKbnInsNo(String trnKbnInsNo) {
		this.trnKbnInsNo = trnKbnInsNo;
	}

	/**
	 * ND309DTO.javatrnKbnInsNoComboを設定
	 * @return trnKbnInsNoCombo
	 */
	public LinkedHashMap<String, String> getTrnKbnInsNoCombo() {
		return trnKbnInsNoCombo;
	}

	/**
	 * @param trnKbnInsNoCombo セットする trnKbnInsNoCombo
	 */
	public void setTrnKbnInsNoCombo(LinkedHashMap<String, String> trnKbnInsNoCombo) {
		this.trnKbnInsNoCombo = trnKbnInsNoCombo;
	}

	/**
	 * ND309DTO.javareqDestBtnFlgを設定
	 * @return reqDestBtnFlg
	 */
	public String getReqDestBtnFlg() {
		return reqDestBtnFlg;
	}

	/**
	 * @param reqDestBtnFlg セットする reqDestBtnFlg
	 */
	public void setReqDestBtnFlg(String reqDestBtnFlg) {
		this.reqDestBtnFlg = reqDestBtnFlg;
	}

	/**
	 * ND309DTO.javatempReqBtnFlgを設定
	 * @return tempReqBtnFlg
	 */
	public String getTempReqBtnFlg() {
		return tempReqBtnFlg;
	}

	/**
	 * @param tempReqBtnFlg セットする tempReqBtnFlg
	 */
	public void setTempReqBtnFlg(String tempReqBtnFlg) {
		this.tempReqBtnFlg = tempReqBtnFlg;
	}

	/**
	 * ND309DTO.javareqBtnFlgを設定
	 * @return reqBtnFlg
	 */
	public String getReqBtnFlg() {
		return reqBtnFlg;
	}

	/**
	 * @param reqBtnFlg セットする reqBtnFlg
	 */
	public void setReqBtnFlg(String reqBtnFlg) {
		this.reqBtnFlg = reqBtnFlg;
	}

	/**
	 * ND309DTO.javadispTekiyoYmdを設定
	 * @return dispTekiyoYmd
	 */
	public String getDispTekiyoYmd() {
		return dispTekiyoYmd;
	}

	/**
	 * @param dispTekiyoYmd セットする dispTekiyoYmd
	 */
	public void setDispTekiyoYmd(String dispTekiyoYmd) {
		this.dispTekiyoYmd = dispTekiyoYmd;
	}

	/**
	 * ND309DTO.javatekiyoInitDayを設定
	 * @return tekiyoInitDay
	 */
	public String getTekiyoInitDay() {
		return tekiyoInitDay;
	}

	/**
	 * @param tekiyoInitDay セットする tekiyoInitDay
	 */
	public void setTekiyoInitDay(String tekiyoInitDay) {
		this.tekiyoInitDay = tekiyoInitDay;
	}

	/**
	 * ND309DTO.javaselectDayを設定
	 * @return selectDay
	 */
	public String getSelectDay() {
		return selectDay;
	}

	/**
	 * @param selectDay セットする selectDay
	 */
	public void setSelectDay(String selectDay) {
		this.selectDay = selectDay;
	}

	/**
	 * ND309DTO.javamsgStrを設定
	 * @return msgStr
	 */
	public String getMsgStr() {
		return msgStr;
	}

	/**
	 * @param msgStr セットする msgStr
	 */
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	/**
	 * ND309DTO.javaAlertMsgStrを設定
	 * @return alertMsgStr
	 */
	public String getAlertMsgStr() {
		return AlertMsgStr;
	}

	/**
	 * @param alertMsgStr セットする alertMsgStr
	 */
	public void setAlertMsgStr(String alertMsgStr) {
		AlertMsgStr = alertMsgStr;
	}

	/**
	 * ND309DTO.javaalertMsgStr2を設定
	 * @return alertMsgStr2
	 */
	public String getAlertMsgStr2() {
		return alertMsgStr2;
	}

	/**
	 * @param alertMsgStr2 セットする alertMsgStr2
	 */
	public void setAlertMsgStr2(String alertMsgStr2) {
		this.alertMsgStr2 = alertMsgStr2;
	}

	/**
	 * ND309DTO.javaalertIgnoreを設定
	 * @return alertIgnore
	 */
	public String getAlertIgnore() {
		return alertIgnore;
	}

	/**
	 * @param alertIgnore セットする alertIgnore
	 */
	public void setAlertIgnore(String alertIgnore) {
		this.alertIgnore = alertIgnore;
	}

	/**
	 * ND309DTO.javatempButtonExecutedを設定
	 * @return tempButtonExecuted
	 */
	public String getTempButtonExecuted() {
		return tempButtonExecuted;
	}

	/**
	 * @param tempButtonExecuted セットする tempButtonExecuted
	 */
	public void setTempButtonExecuted(String tempButtonExecuted) {
		this.tempButtonExecuted = tempButtonExecuted;
	}

	/**
	 * ND309DTO.javand309AppdFlgを設定
	 * @return nd309AppdFlg
	 */
	public String getNd309AppdFlg() {
		return nd309AppdFlg;
	}

	/**
	 * @param nd309AppdFlg セットする nd309AppdFlg
	 */
	public void setNd309AppdFlg(String nd309AppdFlg) {
		this.nd309AppdFlg = nd309AppdFlg;
	}

	/**
	 * ND309DTO.javand309RejectFlgを設定
	 * @return nd309RejectFlg
	 */
	public String getNd309RejectFlg() {
		return nd309RejectFlg;
	}

	/**
	 * @param nd309RejectFlg セットする nd309RejectFlg
	 */
	public void setNd309RejectFlg(String nd309RejectFlg) {
		this.nd309RejectFlg = nd309RejectFlg;
	}

	/**
	 * ND309DTO.javand309AppdActiveFlgを設定
	 * @return nd309AppdActiveFlg
	 */
	public String getNd309AppdActiveFlg() {
		return nd309AppdActiveFlg;
	}

	/**
	 * @param nd309AppdActiveFlg セットする nd309AppdActiveFlg
	 */
	public void setNd309AppdActiveFlg(String nd309AppdActiveFlg) {
		this.nd309AppdActiveFlg = nd309AppdActiveFlg;
	}

	/**
	 * ND309DTO.javand309RejectActiveFlgを設定
	 * @return nd309RejectActiveFlg
	 */
	public String getNd309RejectActiveFlg() {
		return nd309RejectActiveFlg;
	}

	/**
	 * @param nd309RejectActiveFlg セットする nd309RejectActiveFlg
	 */
	public void setNd309RejectActiveFlg(String nd309RejectActiveFlg) {
		this.nd309RejectActiveFlg = nd309RejectActiveFlg;
	}

	/**
	 * ND309DTO.javareqChlを設定
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
	 * ND309DTO.javafuncIdを設定
	 * @return funcId
	 */
	public String getFuncId() {
		return funcId;
	}

	/**
	 * @param funcId セットする funcId
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	/**
	 * ND309DTO.javareqBtnActiveFlgを設定
	 * @return reqBtnActiveFlg
	 */
	public String getReqBtnActiveFlg() {
		return reqBtnActiveFlg;
	}

	/**
	 * @param reqBtnActiveFlg セットする reqBtnActiveFlg
	 */
	public void setReqBtnActiveFlg(String reqBtnActiveFlg) {
		this.reqBtnActiveFlg = reqBtnActiveFlg;
	}

	/**
	 * ND309DTO.javareqTypeを設定
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
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
