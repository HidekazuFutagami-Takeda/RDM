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
public class ND403DTO extends BaseDTO implements Serializable {

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
    private String ND403 = "ND403";

	/**
	 * 表示分岐
	 * 0:完全新規、1:申請データあり
	 */
	private String displayKbn;

	/**
     * タイトル
     */
    private String Title;

	/**
	 * ND403遷移元画面
	 * 申請破棄ボタン押下時の遷移先保持用
	 *
	 */
	private String nd401PreScreenId;
	/**
     * 条件セット
     */
    private String jokenSetCd;

    /**
	 * ユーザ権限
	 * @generated
	 */
	private String loginJokenSetCd;

	/**
     * MR権限/管理者権限判定
     */
    private String mrAdminFlg;

	/**
     * 遷移元画面
     */
    private String preScreenId;

    /**
     * 検索結果表示
     */
    private String searchType;

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
     * 検索条件_所属部科名
     * @generated
     */
    private String kensakuDeptKj;

    /**
     * 検索条件_組織コード
     * @generated
     */
    private String kensakuSosCd;

    /**
     * 検索条件_組織名
     * @generated
     */
    private String kensakuSosName;

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
     * 検索条件_担当者名
     * @generated
     */
    private String kensakuJgiName;

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
     * 大学職位(先)
     */
    private String postUnivPosCode;

    /**
     * 施設分類(先)
     */
    private String postInsClass;

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
	 * 押下ボタンフラグ
	 * @generated
	 */
	private String tempButtonExecuted;

    /**
     * 申請画面へボタン活性非活性フラグ
     */
	private String reqBtnActiveFlg;

    /**
     * 申請区分
     */
	private String reqType;

    /**
     * 検索済かの判定用フラグ
     */
    private String pageFlag;

    /**
     * 最大表示件数（エラーチェック用）
     */
    private Integer maxPageCnt;

    /**
     * 検索結果件数（エラーチェック用）
     */
    private Integer pageCnt;

    /**
     * @役職_ドロップダウンリスト
     */
	private LinkedHashMap<String,String> titleMap = new LinkedHashMap<String,String>();

    /**
     * @generated
     */
    private List<KmuIkkatsuData> kmuIkkatsuDataList = new ArrayList<KmuIkkatsuData>();

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND403DTO() {
        setForward(ND403);
    }

	/**
	 * ND403DTO.javagamenJgiNoを設定
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
	 * ND403DTO.javaND403を設定
	 * @return nD401
	 */
	public String getND403() {
		return ND403;
	}

	/**
	 * @param nD401 セットする nD401
	 */
	public void setND403(String nD401) {
		ND403 = nD401;
	}

	/**
	 * ND403DTO.javadisplayKbnを設定
	 * @return displayKbn
	 */
	public String getDisplayKbn() {
		return displayKbn;
	}

	/**
	 * @param displayKbn セットする displayKbn
	 */
	public void setDisplayKbn(String displayKbn) {
		this.displayKbn = displayKbn;
	}

	/**
	 * ND403DTO.javaTitleを設定
	 * @return title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * ND403DTO.javand401PreScreenIdを設定
	 * @return nd401PreScreenId
	 */
	public String getNd401PreScreenId() {
		return nd401PreScreenId;
	}

	/**
	 * @param nd401PreScreenId セットする nd401PreScreenId
	 */
	public void setNd401PreScreenId(String nd401PreScreenId) {
		this.nd401PreScreenId = nd401PreScreenId;
	}

	/**
	 * ND403DTO.javajokenSetCdを設定
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
	 * ND403DTO.javaloginJokenSetCdを設定
	 * @return loginJokenSetCd
	 */
	public String getLoginJokenSetCd() {
		return loginJokenSetCd;
	}

	/**
	 * @param loginJokenSetCd セットする loginJokenSetCd
	 */
	public void setLoginJokenSetCd(String loginJokenSetCd) {
		this.loginJokenSetCd = loginJokenSetCd;
	}

	/**
	 * ND403DTO.javamrAdminFlgを設定
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
	 * ND403DTO.javapreScreenIdを設定
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
	 * ND403DTO.javareqFlgを設定
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
	 * ND403DTO.javareqIdを設定
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
	 * ND403DTO.javareqShzを設定
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
	 * ND403DTO.javareqStsNmを設定
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
	 * ND403DTO.javareqStsを設定
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
	 * ND403DTO.javareqJgiNameを設定
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
	 * ND403DTO.javareqJgiNoを設定
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
	 * ND403DTO.javareqYmdhmsを設定
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
	 * ND403DTO.javareqBrCodeを設定
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
	 * ND403DTO.javareqDistCodeを設定
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
	 * ND403DTO.javaupdShaYmdを設定
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
	 * ND403DTO.javapostInsNoを設定
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
	 * ND403DTO.javapostUltInsNoを設定
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
	 * ND403DTO.javapostDeptCodeを設定
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
	 * ND403DTO.javapostDeptKnを設定
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
	 * ND403DTO.javapostTitleCodeを設定
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
	 * ND403DTO.javapostJobFormを設定
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
	 * ND403DTO.javapostDccを設定
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
	 * ND403DTO.javapostHoInsTypeを設定
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
	 * ND403DTO.javapostUnivPosCodeを設定
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
	 * ND403DTO.javapostInsClassを設定
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
	 * ND403DTO.javapreInsNoを設定
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
	 * ND403DTO.javapreUltInsNoを設定
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
	 * ND403DTO.javapreDeptCodeを設定
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
	 * ND403DTO.javapreDeptKnを設定
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
	 * ND403DTO.javapreTitleCodeを設定
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
	 * ND403DTO.javapreJobFormを設定
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
	 * ND403DTO.javapreDccを設定
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
	 * ND403DTO.javapreUnivPosCodeを設定
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
	 * ND403DTO.javapreHoInsTypeを設定
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
	 * ND403DTO.javapreInsClassを設定
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
	 * ND403DTO.javaultDocNoを設定
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
	 * ND403DTO.javadocKanjを設定
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
	 * ND403DTO.javapreInsAbbrNameを設定
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
	 * ND403DTO.javapreDeptKjを設定
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
	 * ND403DTO.javatitlePreTitleKjを設定
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
	 * ND403DTO.javakmuPreCodeKanjを設定
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
	 * ND403DTO.javayakushinPreCodeKanjを設定
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
	 * ND403DTO.javaunivPreTitleKjを設定
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
	 * ND403DTO.javatrnKbnを設定
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
	 * ND403DTO.javapostInsAbbrNameを設定
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
	 * ND403DTO.javapostDeptKjを設定
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
	 * ND403DTO.javatitlePostTitleKjを設定
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
	 * ND403DTO.javakmuPostCodeKanjを設定
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
	 * ND403DTO.javayakushinPostCodeKanjを設定
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
	 * ND403DTO.javaunivPostTitleKjを設定
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
	 * ND403DTO.javareqCommentを設定
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
	 * ND403DTO.javaaprCommentを設定
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
	 * ND403DTO.javadocNoを設定
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
	 * ND403DTO.javainsNoを設定
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
	 * ND403DTO.javamovemedEditFlgを設定
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
	 * ND403DTO.javainputFlgを設定
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
	 * ND403DTO.javareqCommentFlgを設定
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
	 * ND403DTO.javayakushokuを設定
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
	 * ND403DTO.javayakushokuComboを設定
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
	 * ND403DTO.javajobFormを設定
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
	 * ND403DTO.javajobFormComboを設定
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
	 * ND403DTO.javadccを設定
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
	 * ND403DTO.javadccComboを設定
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
	 * ND403DTO.javadigakuShokuiを設定
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
	 * ND403DTO.javadigakuShokuiComboを設定
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
	 * ND403DTO.javareqDestBtnFlgを設定
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
	 * ND403DTO.javatempReqBtnFlgを設定
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
	 * ND403DTO.javareqBtnFlgを設定
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
	 * ND403DTO.javadispTekiyoYmdを設定
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
	 * ND403DTO.javatekiyoInitDayを設定
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
	 * ND403DTO.javaselectDayを設定
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
	 * ND403DTO.javamsgStrを設定
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
	 * ND403DTO.javatempButtonExecutedを設定
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
	 * ND403DTO.javareqBtnActiveFlgを設定
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
	 * ND403DTO.javareqTypeを設定
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
	 * ND403DTO.javapageFlagを設定
	 * @return pageFlag
	 */
	public String getPageFlag() {
		return pageFlag;
	}

	/**
	 * @param pageFlag セットする pageFlag
	 */
	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}

	/**
	 * ND403DTO.javamaxPageCntを設定
	 * @return maxPageCnt
	 */
	public Integer getMaxPageCnt() {
		return maxPageCnt;
	}

	/**
	 * @param maxPageCnt セットする maxPageCnt
	 */
	public void setMaxPageCnt(Integer maxPageCnt) {
		this.maxPageCnt = maxPageCnt;
	}

	/**
	 * ND403DTO.javapageCntを設定
	 * @return pageCnt
	 */
	public Integer getPageCnt() {
		return pageCnt;
	}

	/**
	 * @param pageCnt セットする pageCnt
	 */
	public void setPageCnt(Integer pageCnt) {
		this.pageCnt = pageCnt;
	}

	/**
	 * ND403DTO.javakmuIkkatsuDataListを設定
	 * @return kmuIkkatsuDataList
	 */
	public List<KmuIkkatsuData> getKmuIkkatsuDataList() {
		return kmuIkkatsuDataList;
	}

	/**
	 * @param kmuIkkatsuDataList セットする kmuIkkatsuDataList
	 */
	public void setKmuIkkatsuDataList(List<KmuIkkatsuData> kmuIkkatsuDataList) {
		this.kmuIkkatsuDataList = kmuIkkatsuDataList;
	}

	/**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	/**
	 * ND403DTO.javakensakuInsKanjを設定
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
	 * ND403DTO.javakensakuInsNoを設定
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
	 * ND403DTO.javakensakuDocKanjを設定
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
	 * ND403DTO.javakensakuDocNoを設定
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
	 * ND403DTO.javakensakuDeptCodeを設定
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
	 * ND403DTO.javakensakuDeptKjを設定
	 * @return kensakuDeptKj
	 */
	public String getKensakuDeptKj() {
		return kensakuDeptKj;
	}

	/**
	 * @param kensakuDeptKj セットする kensakuDeptKj
	 */
	public void setKensakuDeptKj(String kensakuDeptKj) {
		this.kensakuDeptKj = kensakuDeptKj;
	}

	/**
	 * ND403DTO.javakensakuSosCdを設定
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
	 * ND403DTO.javakensakuSosNameを設定
	 * @return kensakuSosName
	 */
	public String getKensakuSosName() {
		return kensakuSosName;
	}

	/**
	 * @param kensakuSosName セットする kensakuSosName
	 */
	public void setKensakuSosName(String kensakuSosName) {
		this.kensakuSosName = kensakuSosName;
	}

	/**
	 * ND403DTO.javakensakuBrCodeを設定
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
	 * ND403DTO.javakensakuDistCodeを設定
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
	 * ND403DTO.javakensakuJgiNoを設定
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

	/**
	 * ND403DTO.javakensakuJgiNameを設定
	 * @return kensakuJgiName
	 */
	public String getKensakuJgiName() {
		return kensakuJgiName;
	}

	/**
	 * @param kensakuJgiName セットする kensakuJgiName
	 */
	public void setKensakuJgiName(String kensakuJgiName) {
		this.kensakuJgiName = kensakuJgiName;
	}

	/**
	 * ND403DTO.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * ND403DTO.javasearchTypeを設定
	 * @return searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType セットする searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * ND403DTO.javatitleMapを設定
	 * @return titleMap
	 */
	public LinkedHashMap<String, String> getTitleMap() {
		return titleMap;
	}

	/**
	 * @param titleMap セットする titleMap
	 */
	public void setTitleMap(LinkedHashMap<String, String> titleMap) {
		this.titleMap = titleMap;
	}
}
