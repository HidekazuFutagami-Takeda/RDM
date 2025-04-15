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
public class ND307DTO extends BaseDTO implements Serializable {

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
    private String ND307 = "ND307";

	/**
	 * ND101遷移元画面
	 * 申請破棄ボタン押下時の遷移先保持用
	 *
	 */
	private String nd101PreScreenId;

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
	private String nd307AppdFlg;

	/**
	 * 却下ボタン表示フラグ 0　非表示　1  表示
	 * @generated
	 */
	private String nd307RejectFlg;

	/**
	 * 承認活性不活性フラグ 0　非活性　1　活性
	 * @generated
	 */
	private String nd307AppdActiveFlg;

	/**
	 * 承認活性不活性フラグ 0　非活性　1  活性
	 * @generated
	 */
	private String nd307RejectActiveFlg;

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
	 * 審査・承認メモ
	 * @generated
	 */
	private String aprMemo;

	/**
	 * 処理結果フラグ
	 * 9:完了
	 * @generated
	 */
	private String returnFlg;

	/**
	 * アルトマークへの情報連携
	 * @generated
	 */
	private Boolean fbReqFlg;

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND307DTO() {
        setForward(ND307);
    }

	/**
	 * ND307DTO.javagamenJgiNoを設定
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
	 * ND307DTO.javaND307を設定
	 * @return nD307
	 */
	public String getND307() {
		return ND307;
	}

	/**
	 * @param nD307 セットする nD307
	 */
	public void setND307(String nD307) {
		ND307 = nD307;
	}

	/**
	 * ND307DTO.javand101PreScreenIdを設定
	 * @return nd101PreScreenId
	 */
	public String getNd101PreScreenId() {
		return nd101PreScreenId;
	}

	/**
	 * @param nd101PreScreenId セットする nd101PreScreenId
	 */
	public void setNd101PreScreenId(String nd101PreScreenId) {
		this.nd101PreScreenId = nd101PreScreenId;
	}

	/**
	 * ND307DTO.javatitleを設定
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
	 * ND307DTO.javajokenSetCdを設定
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
	 * ND307DTO.javamrAdminFlgを設定
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
	 * ND307DTO.javapreScreenIdを設定
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
	 * ND307DTO.javareqFlgを設定
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
	 * ND307DTO.javareqIdを設定
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
	 * ND307DTO.javareqShzを設定
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
	 * ND307DTO.javareqStsNmを設定
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
	 * ND307DTO.javareqStsを設定
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
	 * ND307DTO.javareqJgiNameを設定
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
	 * ND307DTO.javareqJgiNoを設定
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
	 * ND307DTO.javareqYmdhmsを設定
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
	 * ND307DTO.javareqBrCodeを設定
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
	 * ND307DTO.javareqDistCodeを設定
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
	 * ND307DTO.javaupdShaYmdを設定
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
	 * ND307DTO.javapostInsNoを設定
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
	 * ND307DTO.javapostUltInsNoを設定
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
	 * ND307DTO.javapostDeptCodeを設定
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
	 * ND307DTO.javapostDeptKnを設定
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
	 * ND307DTO.javapostTitleCodeを設定
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
	 * ND307DTO.javapostJobFormを設定
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
	 * ND307DTO.javapostDccを設定
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
	 * ND307DTO.javapostHoInsTypeを設定
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
	 * ND307DTO.javapostInsClassを設定
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
	 * ND307DTO.javapostUnivPosCodeを設定
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
	 * ND307DTO.javapreInsNoを設定
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
	 * ND307DTO.javapreUltInsNoを設定
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
	 * ND307DTO.javapreDeptCodeを設定
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
	 * ND307DTO.javapreDeptKnを設定
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
	 * ND307DTO.javapreTitleCodeを設定
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
	 * ND307DTO.javapreJobFormを設定
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
	 * ND307DTO.javapreDccを設定
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
	 * ND307DTO.javapreUnivPosCodeを設定
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
	 * ND307DTO.javapreHoInsTypeを設定
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
	 * ND307DTO.javapreInsClassを設定
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
	 * ND307DTO.javaultDocNoを設定
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
	 * ND307DTO.javadocKanjを設定
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
	 * ND307DTO.javapreInsAbbrNameを設定
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
	 * ND307DTO.javapreDeptKjを設定
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
	 * ND307DTO.javatitlePreTitleKjを設定
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
	 * ND307DTO.javakmuPreCodeKanjを設定
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
	 * ND307DTO.javayakushinPreCodeKanjを設定
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
	 * ND307DTO.javaunivPreTitleKjを設定
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
	 * ND307DTO.javatrnKbnを設定
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
	 * ND307DTO.javapostInsAbbrNameを設定
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
	 * ND307DTO.javapostDeptKjを設定
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
	 * ND307DTO.javatitlePostTitleKjを設定
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
	 * ND307DTO.javakmuPostCodeKanjを設定
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
	 * ND307DTO.javayakushinPostCodeKanjを設定
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
	 * ND307DTO.javaunivPostTitleKjを設定
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
	 * ND307DTO.javareqCommentを設定
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
	 * ND307DTO.javaaprCommentを設定
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
	 * ND307DTO.javadocNoを設定
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
	 * ND307DTO.javainsNoを設定
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
	 * ND307DTO.javamovemedEditFlgを設定
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
	 * ND307DTO.javainputFlgを設定
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
	 * ND307DTO.javareqCommentFlgを設定
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
	 * ND307DTO.javayakushokuを設定
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
	 * ND307DTO.javayakushokuComboを設定
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
	 * ND307DTO.javajobFormを設定
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
	 * ND307DTO.javajobFormComboを設定
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
	 * ND307DTO.javadccを設定
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
	 * ND307DTO.javadccComboを設定
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
	 * ND307DTO.javadigakuShokuiを設定
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
	 * ND307DTO.javadigakuShokuiComboを設定
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
	 * ND307DTO.javareqDestBtnFlgを設定
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
	 * ND307DTO.javatempReqBtnFlgを設定
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
	 * ND307DTO.javareqBtnFlgを設定
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
	 * ND307DTO.javadispTekiyoYmdを設定
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
	 * ND307DTO.javatekiyoInitDayを設定
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
	 * ND307DTO.javaselectDayを設定
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
	 * ND307DTO.javamsgStrを設定
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
	 * ND307DTO.javaAlertMsgStrを設定
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
	 * ND307DTO.javaalertMsgStr2を設定
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
	 * ND307DTO.javaalertIgnoreを設定
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
	 * ND307DTO.javatempButtonExecutedを設定
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
	 * ND307DTO.javand307AppdFlgを設定
	 * @return nd307AppdFlg
	 */
	public String getNd307AppdFlg() {
		return nd307AppdFlg;
	}

	/**
	 * @param nd307AppdFlg セットする nd307AppdFlg
	 */
	public void setNd307AppdFlg(String nd307AppdFlg) {
		this.nd307AppdFlg = nd307AppdFlg;
	}

	/**
	 * ND307DTO.javand307RejectFlgを設定
	 * @return nd307RejectFlg
	 */
	public String getNd307RejectFlg() {
		return nd307RejectFlg;
	}

	/**
	 * @param nd307RejectFlg セットする nd307RejectFlg
	 */
	public void setNd307RejectFlg(String nd307RejectFlg) {
		this.nd307RejectFlg = nd307RejectFlg;
	}

	/**
	 * ND307DTO.javand307AppdActiveFlgを設定
	 * @return nd307AppdActiveFlg
	 */
	public String getNd307AppdActiveFlg() {
		return nd307AppdActiveFlg;
	}

	/**
	 * @param nd307AppdActiveFlg セットする nd307AppdActiveFlg
	 */
	public void setNd307AppdActiveFlg(String nd307AppdActiveFlg) {
		this.nd307AppdActiveFlg = nd307AppdActiveFlg;
	}

	/**
	 * ND307DTO.javand307RejectActiveFlgを設定
	 * @return nd307RejectActiveFlg
	 */
	public String getNd307RejectActiveFlg() {
		return nd307RejectActiveFlg;
	}

	/**
	 * @param nd307RejectActiveFlg セットする nd307RejectActiveFlg
	 */
	public void setNd307RejectActiveFlg(String nd307RejectActiveFlg) {
		this.nd307RejectActiveFlg = nd307RejectActiveFlg;
	}

	/**
	 * ND307DTO.javareqChlを設定
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
	 * ND307DTO.javafuncIdを設定
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
	 * ND307DTO.javareqBtnActiveFlgを設定
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
	 * ND307DTO.javareqTypeを設定
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
	 * ND307DTO.javaaprMemoを設定
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
	 * ND307DTO.javareturnFlgを設定
	 * @return returnFlg
	 */
	public String getReturnFlg() {
		return returnFlg;
	}

	/**
	 * @param returnFlg セットする returnFlg
	 */
	public void setReturnFlg(String returnFlg) {
		this.returnFlg = returnFlg;
	}

	/**
	 * ND307DTO.javafbReqFlgを設定
	 * @return fbReqFlg
	 */
	public Boolean getFbReqFlg() {
		return fbReqFlg;
	}

	/**
	 * @param fbReqFlg セットする fbReqFlg
	 */
	public void setFbReqFlg(Boolean fbReqFlg) {
		this.fbReqFlg = fbReqFlg;
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
