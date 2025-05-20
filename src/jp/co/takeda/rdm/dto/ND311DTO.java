/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseDTO;

/**
 * DTOクラス
 * @generated
 */
public class ND311DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String ND311 = "ND311";

    /**
     * 親画面名
     * @generated
     */
    private String title;

    /**
     * 親画面コールバックメソッド名
     * @generated
     */
    private String callBack;

    /**
     * 親画面名
     * @generated
     */
    private String winVarName;

    /**
     * 権限_条件セット
     * @generated
     */
    private String jokenSetCd;

    /**
	 * ユーザ権限
	 * @generated
	 */
	private String loginJokenSetCd;

	/**
	 * ユーザ従業員番号
	 * @generated
	 */
	private Integer loginJgiNo;

	/**
	 * ユーザ氏名
	 * @generated
	 */
	private String loginNm;

	/**
	 * ユーザ医薬支店C
	 * @generated
	 */
	private String loginBrCd;

	/**
	 * ユーザ医薬営業所C
	 * @generated
	 */
	private String loginDistCd;

	/**
	 * ユーザ所属組織名
	 * @generated
	 */
	private String loginShzNm;

	/**
	 * ユーザ領域コード
	 * @generated
	 */
	private String loginTrtCd;

    /**
     * イベントID
     * @generated
     */
    private String functionId;

    /**
     * メッセージ定義
     * @generated
     */
    private String msgStr;

    /**
     * 親画面 医師固定コード
     * @generated
     */
    private String paramDocNo;


    /**
     * 親画面申請ID
     * @generated
     */
    private String paramReqId;

    /**
     * 親画面申請ID
     * @generated
     */
    private String reqId;

    /**
     * 申請ボタン　活性・非活性
     * @generated
     */
    private String actionEdit;

    /**
     * エラーチェックフラグ
     * 0:エラー処理実行前
     * 1:エラーなし
     * 2:重複チェックエラー
     * 3:整合性チェックエラー
     * @generated
     */
    private String errorCheckFlg = "0";

    /**
     * 一時保存ボタン押下フラグ
     * 0:押下前
     * 1:押下済み
     * @generated
     */
    private String saveButtonFlg = "0";

    /**
     * 申請破棄ボタン押下フラグ
     * 0:押下前
     * 1:押下済み
     * @generated
     */
    private String deleteButtonFlg = "0";

    /**
     * 処理フラグ
     * 0:申請処理
     * 1:却下処理
     * @generated
     */
    private String processFlg;

    /**
     * 申請者所属
     * @generated
     */
    private String reqShz;

    /**
     * 申請ステータス(名称)
     * @generated
     */
    private String reqSts;

    /**
     * 申請チャネル
     * @generated
     */
    private String reqChl;

    /**
     * 申請者氏名
     * @generated
     */
    private String jgiName;

    /**
     * 申請日時
     * @generated
     */
    private String reqYmdhms;

    /**
     * 施設分類
     * @generated
     */
    private String insClass;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * 申請者従業員番号
     * @generated
     */
    private String reqJgiNo;

    /**
     * 申請者所属リージョン
     * @generated
     */
    private String brCode;

    /**
     * 申請者所属エリア
     * @generated
     */
    private String reqDistCode;

    /**
     * 申請ステータス(コード)
     * @generated
     */
    private String reqStsCd;

    /**
     * 更新日
     * @generated
     */
    private String updShaYmd;

    /**
     * 氏名（漢字）
     * @generated
     */
    private String docKanj;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;

    /**
     * ULT医師コード
     * @generated
     */
    private String urlDocNo;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 所属部科漢字名
     * @generated
     */
    private String deptKj;

    /**
     * 役職コード(異動先)
     * @generated
     */
    private String titleCodeAf;

    /**
     * 役職名称(異動先)名称
     * @generated
     */
    private String titleCodeName;

    /**
     * 勤務形態(異動先)
     * @generated
     */
    private String jobFormAf;

    /**
     * 勤務形態(異動先)名称
     * @generated
     */
    private String jobFormAfName;

    /**
     * 薬審メンバー区分(異動先)
     * @generated
     */
    private String dccTypeAf;

    /**
     * 薬審メンバー区分(異動先)名称
     * @generated
     */
    private String dccTypeAfName;

    /**
     * 大学職位コード(異動先)
     * @generated
     */
    private String univPosCodeAf;

    /**
     * 大学職位コード(異動先)名称
     * @generated
     */
    private String univPosCodeAfName;

    /**
     * 適用開始日
     * @generated
     */
    private String tekiyoYmd;

    /**
     * 適用開始日_画面入力日付
     * @generated
     */
    private String formTekiyoYmd;

    /**
     * 施設固定コード(異動先)
     * @generated
     */
    private String insNoSk;

    /**
     * ULT施設コード
     * @generated
     */
    private String ultInsNo;

    /**
     * 所属部科コード(異動先)
     * @generated
     */
    private String deptCodeAf;

    /**
     * 所属部科カナ名
     * @generated
     */
    private String deptKn;

    /**
     * 申請コメント
     * @generated
     */
    private String reqComment;

    /**
     * 却下コメント
     * @generated
     */
    private String aprComment;

    /**
     * @役職_ドロップダウンリスト
     */
    private String yakusyokuCd;
	private LinkedHashMap<String,String> yakusyokuMap = new LinkedHashMap<String,String>();

	/**
     * @大学職位_ドロップダウンリスト
     */
    private String daigakuSyokuiCd;
	private LinkedHashMap<String,String> daigakuSyokuiMap = new LinkedHashMap<String,String>();

	/**
     * @勤務形態_ドロップダウンリスト
     */
    private String kinmuKeitaiCd;
	private LinkedHashMap<String,String> kinmuKeitaiMap = new LinkedHashMap<String,String>();

	/**
     * @薬審メンバー区分ドロップダウンリスト
     */
    private String yakushinCd;
	private LinkedHashMap<String,String> yakushinMap = new LinkedHashMap<String,String>();

	/**
	 * アルトマークへの情報連携
	 * @generated
	 */
	private Boolean fbReqFlg;

	/**
	 * 編集可能フラグ
	 * 0:不可、1:可
	 * @generated
	 */
	private String editApprFlg;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND311DTO() {
        setForward(ND311);
    }

    // START UOC

    // END UOC

    /**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	public String getWinVarName() {
		return winVarName;
	}

	public void setWinVarName(String winVarName) {
		this.winVarName = winVarName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * ND311DTO.javaparamReqIdを設定
	 * @return paramReqId
	 */
	public String getParamReqId() {
		return paramReqId;
	}

	/**
	 * @param paramReqId セットする paramReqId
	 */
	public void setParamReqId(String paramReqId) {
		this.paramReqId = paramReqId;
	}

	/**
	 * ND311DTO.javareqShzを設定
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
	 * ND311DTO.javareqStsを設定
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
	 * ND311DTO.javajgiNameを設定
	 * @return jgiName
	 */
	public String getJgiName() {
		return jgiName;
	}

	/**
	 * @param jgiName セットする jgiName
	 */
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	/**
	 * ND311DTO.javareqYmdhmsを設定
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
	 * ND311DTO.javareqJgiNoを設定
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
	 * ND311DTO.javabrCodeを設定
	 * @return brCode
	 */
	public String getBrCode() {
		return brCode;
	}

	/**
	 * @param brCode セットする brCode
	 */
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	/**
	 * ND311DTO.javareqDistCodeを設定
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
	 * ND311DTO.javaupdShaYmdを設定
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
	 * ND311DTO.javadocKanjを設定
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
	 * ND311DTO.javadocNoを設定
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
	 * ND311DTO.javaurlDocNoを設定
	 * @return urlDocNo
	 */
	public String getUrlDocNo() {
		return urlDocNo;
	}

	/**
	 * @param urlDocNo セットする urlDocNo
	 */
	public void setUrlDocNo(String urlDocNo) {
		this.urlDocNo = urlDocNo;
	}

	/**
	 * ND311DTO.javainsAbbrNameを設定
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
	 * ND311DTO.javadeptKjを設定
	 * @return deptKj
	 */
	public String getDeptKj() {
		return deptKj;
	}

	/**
	 * @param deptKj セットする deptKj
	 */
	public void setDeptKj(String deptKj) {
		this.deptKj = deptKj;
	}

	/**
	 * ND311DTO.javatitleCodeAfを設定
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
	 * ND311DTO.javajobFormAfを設定
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
	 * ND311DTO.javadccTypeAfを設定
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
	 * ND311DTO.javatekiyoYmdを設定
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
	 * ND311DTO.javainsNoSkを設定
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
	 * ND311DTO.javaultInsNoを設定
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
	 * ND311DTO.javadeptCodeAfを設定
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
	 * ND311DTO.javadeptKnを設定
	 * @return deptKn
	 */
	public String getDeptKn() {
		return deptKn;
	}

	/**
	 * @param deptKn セットする deptKn
	 */
	public void setDeptKn(String deptKn) {
		this.deptKn = deptKn;
	}

	/**
	 * ND311DTO.javareqCommentを設定
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
	 * ND311DTO.javaaprCommentを設定
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
	 * ND311DTO.javareqStsCdを設定
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
	 * ND311DTO.javaunivPosCodeAfを設定
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
	 * ND311DTO.javajokenSetCdを設定
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
	 * ND311DTO.javafunctionIdを設定
	 * @return functionId
	 */
	public String getFunctionId() {
		return functionId;
	}

	/**
	 * @param functionId セットする functionId
	 */
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	/**
	 * ND311DTO.javaparamDocNoを設定
	 * @return paramDocNo
	 */
	public String getParamDocNo() {
		return paramDocNo;
	}

	/**
	 * @param paramDocNo セットする paramDocNo
	 */
	public void setParamDocNo(String paramDocNo) {
		this.paramDocNo = paramDocNo;
	}

	/**
	 * ND311DTO.javaND311を設定
	 * @return nD103
	 */
	public String getND311() {
		return ND311;
	}

	/**
	 * @param nD103 セットする nD103
	 */
	public void setND311(String nD103) {
		ND311 = nD103;
	}

	/**
	 * ND311DTO.javayakusyokuCdを設定
	 * @return yakusyokuCd
	 */
	public String getYakusyokuCd() {
		return yakusyokuCd;
	}

	/**
	 * @param yakusyokuCd セットする yakusyokuCd
	 */
	public void setYakusyokuCd(String yakusyokuCd) {
		this.yakusyokuCd = yakusyokuCd;
	}

	/**
	 * ND311DTO.javayakusyokuMapを設定
	 * @return yakusyokuMap
	 */
	public LinkedHashMap<String, String> getYakusyokuMap() {
		return yakusyokuMap;
	}

	/**
	 * @param yakusyokuMap セットする yakusyokuMap
	 */
	public void setYakusyokuMap(LinkedHashMap<String, String> yakusyokuMap) {
		this.yakusyokuMap = yakusyokuMap;
	}

	/**
	 * ND311DTO.javadaigakuSyokuiCdを設定
	 * @return daigakuSyokuiCd
	 */
	public String getDaigakuSyokuiCd() {
		return daigakuSyokuiCd;
	}

	/**
	 * @param daigakuSyokuiCd セットする daigakuSyokuiCd
	 */
	public void setDaigakuSyokuiCd(String daigakuSyokuiCd) {
		this.daigakuSyokuiCd = daigakuSyokuiCd;
	}

	/**
	 * ND311DTO.javadaigakuSyokuiMapを設定
	 * @return daigakuSyokuiMap
	 */
	public LinkedHashMap<String, String> getDaigakuSyokuiMap() {
		return daigakuSyokuiMap;
	}

	/**
	 * @param daigakuSyokuiMap セットする daigakuSyokuiMap
	 */
	public void setDaigakuSyokuiMap(LinkedHashMap<String, String> daigakuSyokuiMap) {
		this.daigakuSyokuiMap = daigakuSyokuiMap;
	}

	/**
	 * ND311DTO.javakinmuKeitaiCdを設定
	 * @return kinmuKeitaiCd
	 */
	public String getKinmuKeitaiCd() {
		return kinmuKeitaiCd;
	}

	/**
	 * @param kinmuKeitaiCd セットする kinmuKeitaiCd
	 */
	public void setKinmuKeitaiCd(String kinmuKeitaiCd) {
		this.kinmuKeitaiCd = kinmuKeitaiCd;
	}

	/**
	 * ND311DTO.javakinmuKeitaiMapを設定
	 * @return kinmuKeitaiMap
	 */
	public LinkedHashMap<String, String> getKinmuKeitaiMap() {
		return kinmuKeitaiMap;
	}

	/**
	 * @param kinmuKeitaiMap セットする kinmuKeitaiMap
	 */
	public void setKinmuKeitaiMap(LinkedHashMap<String, String> kinmuKeitaiMap) {
		this.kinmuKeitaiMap = kinmuKeitaiMap;
	}

	/**
	 * ND311DTO.javayakushinCdを設定
	 * @return yakushinCd
	 */
	public String getYakushinCd() {
		return yakushinCd;
	}

	/**
	 * @param yakushinCd セットする yakushinCd
	 */
	public void setYakushinCd(String yakushinCd) {
		this.yakushinCd = yakushinCd;
	}

	/**
	 * ND311DTO.javayakushinMapを設定
	 * @return yakushinMap
	 */
	public LinkedHashMap<String, String> getYakushinMap() {
		return yakushinMap;
	}

	/**
	 * @param yakushinMap セットする yakushinMap
	 */
	public void setYakushinMap(LinkedHashMap<String, String> yakushinMap) {
		this.yakushinMap = yakushinMap;
	}

	/**
	 * ND311DTO.javasaveButtonFlgを設定
	 * @return saveButtonFlg
	 */
	public String getSaveButtonFlg() {
		return saveButtonFlg;
	}

	/**
	 * @param saveButtonFlg セットする saveButtonFlg
	 */
	public void setSaveButtonFlg(String saveButtonFlg) {
		this.saveButtonFlg = saveButtonFlg;
	}

	/**
	 * ND311DTO.javaloginJokenSetCdを設定
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
	 * ND311DTO.javaloginNmを設定
	 * @return loginNm
	 */
	public String getLoginNm() {
		return loginNm;
	}

	/**
	 * @param loginNm セットする loginNm
	 */
	public void setLoginNm(String loginNm) {
		this.loginNm = loginNm;
	}

	/**
	 * ND311DTO.javaloginBrCdを設定
	 * @return loginBrCd
	 */
	public String getLoginBrCd() {
		return loginBrCd;
	}

	/**
	 * @param loginBrCd セットする loginBrCd
	 */
	public void setLoginBrCd(String loginBrCd) {
		this.loginBrCd = loginBrCd;
	}

	/**
	 * ND311DTO.javaloginDistCdを設定
	 * @return loginDistCd
	 */
	public String getLoginDistCd() {
		return loginDistCd;
	}

	/**
	 * @param loginDistCd セットする loginDistCd
	 */
	public void setLoginDistCd(String loginDistCd) {
		this.loginDistCd = loginDistCd;
	}

	/**
	 * ND311DTO.javaloginShzNmを設定
	 * @return loginShzNm
	 */
	public String getLoginShzNm() {
		return loginShzNm;
	}

	/**
	 * @param loginShzNm セットする loginShzNm
	 */
	public void setLoginShzNm(String loginShzNm) {
		this.loginShzNm = loginShzNm;
	}

	/**
	 * ND311DTO.javaloginTrtCdを設定
	 * @return loginTrtCd
	 */
	public String getLoginTrtCd() {
		return loginTrtCd;
	}

	/**
	 * @param loginTrtCd セットする loginTrtCd
	 */
	public void setLoginTrtCd(String loginTrtCd) {
		this.loginTrtCd = loginTrtCd;
	}

	/**
	 * ND311DTO.javaloginJgiNoを設定
	 * @return loginJgiNo
	 */
	public Integer getLoginJgiNo() {
		return loginJgiNo;
	}

	/**
	 * @param loginJgiNo セットする loginJgiNo
	 */
	public void setLoginJgiNo(Integer loginJgiNo) {
		this.loginJgiNo = loginJgiNo;
	}

	/**
	 * ND311DTO.javamsgStrを設定
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
	 * ND311DTO.javadeleteButtonFlgを設定
	 * @return deleteButtonFlg
	 */
	public String getDeleteButtonFlg() {
		return deleteButtonFlg;
	}

	/**
	 * @param deleteButtonFlg セットする deleteButtonFlg
	 */
	public void setDeleteButtonFlg(String deleteButtonFlg) {
		this.deleteButtonFlg = deleteButtonFlg;
	}

	/**
	 * ND311DTO.javaformTekiyoYmdを設定
	 * @return formTekiyoYmd
	 */
	public String getFormTekiyoYmd() {
		return formTekiyoYmd;
	}

	/**
	 * @param formTekiyoYmd セットする formTekiyoYmd
	 */
	public void setFormTekiyoYmd(String formTekiyoYmd) {
		this.formTekiyoYmd = formTekiyoYmd;
	}

	/**
	 * ND311DTO.javacallBackを設定
	 * @return callBack
	 */
	public String getCallBack() {
		return callBack;
	}

	/**
	 * @param callBack セットする callBack
	 */
	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}

	/**
	 * ND311DTO.javatitleCodeNameを設定
	 * @return titleCodeName
	 */
	public String getTitleCodeName() {
		return titleCodeName;
	}

	/**
	 * @param titleCodeName セットする titleCodeName
	 */
	public void setTitleCodeName(String titleCodeName) {
		this.titleCodeName = titleCodeName;
	}

	/**
	 * ND311DTO.javajobFormAfNameを設定
	 * @return jobFormAfName
	 */
	public String getJobFormAfName() {
		return jobFormAfName;
	}

	/**
	 * @param jobFormAfName セットする jobFormAfName
	 */
	public void setJobFormAfName(String jobFormAfName) {
		this.jobFormAfName = jobFormAfName;
	}

	/**
	 * ND311DTO.javadccTypeAfNameを設定
	 * @return dccTypeAfName
	 */
	public String getDccTypeAfName() {
		return dccTypeAfName;
	}

	/**
	 * @param dccTypeAfName セットする dccTypeAfName
	 */
	public void setDccTypeAfName(String dccTypeAfName) {
		this.dccTypeAfName = dccTypeAfName;
	}

	/**
	 * ND311DTO.javaunivPosCodeAfNameを設定
	 * @return univPosCodeAfName
	 */
	public String getUnivPosCodeAfName() {
		return univPosCodeAfName;
	}

	/**
	 * @param univPosCodeAfName セットする univPosCodeAfName
	 */
	public void setUnivPosCodeAfName(String univPosCodeAfName) {
		this.univPosCodeAfName = univPosCodeAfName;
	}

	/**
	 * ND311DTO.javaactionEditを設定
	 * @return actionEdit
	 */
	public String getActionEdit() {
		return actionEdit;
	}

	/**
	 * @param actionEdit セットする actionEdit
	 */
	public void setActionEdit(String actionEdit) {
		this.actionEdit = actionEdit;
	}

	/**
	 * ND311DTO.javaerrorCheckFlgを設定
	 * @return errorCheckFlg
	 */
	public String getErrorCheckFlg() {
		return errorCheckFlg;
	}

	/**
	 * @param errorCheckFlg セットする errorCheckFlg
	 */
	public void setErrorCheckFlg(String errorCheckFlg) {
		this.errorCheckFlg = errorCheckFlg;
	}

	/**
	 * ND311DTO.javareqChlを設定
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
	 * ND311DTO.javareqIdを設定
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
	 * ND311DTO.javaprocessFlgを設定
	 * @return processFlg
	 */
	public String getProcessFlg() {
		return processFlg;
	}

	/**
	 * @param processFlg セットする processFlg
	 */
	public void setProcessFlg(String processFlg) {
		this.processFlg = processFlg;
	}

	/**
	 * ND311DTO.javainsClassを設定
	 * @return insClass
	 */
	public String getInsClass() {
		return insClass;
	}

	/**
	 * @param insClass セットする insClass
	 */
	public void setInsClass(String insClass) {
		this.insClass = insClass;
	}

	/**
	 * ND311DTO.javahoInsTypeを設定
	 * @return hoInsType
	 */
	public String getHoInsType() {
		return hoInsType;
	}

	/**
	 * @param hoInsType セットする hoInsType
	 */
	public void setHoInsType(String hoInsType) {
		this.hoInsType = hoInsType;
	}

	/**
	 * ND311DTO.javatitleを設定
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
	 * ND311DTO.javafbReqFlgを設定
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
	 * ND311DTO.javaeditApprFlgを設定
	 * @return editApprFlg
	 */
	public String getEditApprFlg() {
		return editApprFlg;
	}

	/**
	 * @param editApprFlg セットする editApprFlg
	 */
	public void setEditApprFlg(String editApprFlg) {
		this.editApprFlg = editApprFlg;
	}


}
