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
public class ND103DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String ND103 = "ND103";

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
    private String msgStr = "";

    /**
     * 親画面 医師固定コード
     * @generated
     */
    private String paramDocNo;

    /**
     * 親画面申請ID
     * @generated
     */
    private String reqId;

    /**
     * 親画面申請ID
     * @generated
     */
    private String paramReqId;

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
     * 申請画面ボタン押下フラグ
     * 0:押下前
     * 1:押下済み
     * @generated
     */
    private String shinseiButtonFlg = "0";

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
     * ダイアログメッセージ
     * @generated
     */
    private String dialogMst = "";


    /**
     * 申請者所属
     * @generated
     */
    private String reqShz;

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
     * 申請ステータス(名称)
     * @generated
     */
    private String reqSts;

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
     * 申請ボタン　活性・非活性
     * @generated
     */
    private String shinseiButtonEdit;

    /**
     * 一時保存ボタン　活性・非活性
     * @generated
     */
    private String saveButtonEdit;

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
     * 作成日
     * @generated
     */
    private String insShaYmd;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;

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
     * 勤務形態(異動先)
     * @generated
     */
    private String jobFormAf;

    /**
     * 薬審メンバー区分(異動先)
     * @generated
     */
    private String dccTypeAf;

    /**
     * 大学職位コード(異動先)
     * @generated
     */
    private String univPosCodeAf;

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
     * 施設固定コード(所属部課　渡し)
     * @generated
     */
    private String paramInsNo;


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
     * 承認者メモ
     * @generated
     */
    private String aprMemo;

    /**
     * 承認却下コメント
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
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND103DTO() {
        setForward(ND103);
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
	 * ND103DTO.javaparamReqIdを設定
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
	 * ND103DTO.javareqShzを設定
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
	 * ND103DTO.javareqStsを設定
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
	 * ND103DTO.javajgiNameを設定
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
	 * ND103DTO.javareqYmdhmsを設定
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
	 * ND103DTO.javareqJgiNoを設定
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
	 * ND103DTO.javabrCodeを設定
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
	 * ND103DTO.javareqDistCodeを設定
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
	 * ND103DTO.javaupdShaYmdを設定
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
	 * ND103DTO.javadocKanjを設定
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
	 * ND103DTO.javadocNoを設定
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
	 * ND103DTO.javaurlDocNoを設定
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
	 * ND103DTO.javainsAbbrNameを設定
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
	 * ND103DTO.javadeptKjを設定
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
	 * ND103DTO.javatitleCodeAfを設定
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
	 * ND103DTO.javajobFormAfを設定
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
	 * ND103DTO.javadccTypeAfを設定
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
	 * ND103DTO.javatekiyoYmdを設定
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
	 * ND103DTO.javainsNoSkを設定
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
	 * ND103DTO.javaultInsNoを設定
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
	 * ND103DTO.javadeptCodeAfを設定
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
	 * ND103DTO.javadeptKnを設定
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
	 * ND103DTO.javareqCommentを設定
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
	 * ND103DTO.javaaprCommentを設定
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
	 * ND103DTO.javareqStsCdを設定
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
	 * ND103DTO.javaunivPosCodeAfを設定
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
	 * ND103DTO.javajokenSetCdを設定
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
	 * ND103DTO.javafunctionIdを設定
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
	 * ND103DTO.javaparamDocNoを設定
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
	 * ND103DTO.javaND103を設定
	 * @return nD103
	 */
	public String getND103() {
		return ND103;
	}

	/**
	 * @param nD103 セットする nD103
	 */
	public void setND103(String nD103) {
		ND103 = nD103;
	}

	/**
	 * ND103DTO.javayakusyokuCdを設定
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
	 * ND103DTO.javayakusyokuMapを設定
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
	 * ND103DTO.javadaigakuSyokuiCdを設定
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
	 * ND103DTO.javadaigakuSyokuiMapを設定
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
	 * ND103DTO.javakinmuKeitaiCdを設定
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
	 * ND103DTO.javakinmuKeitaiMapを設定
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
	 * ND103DTO.javayakushinCdを設定
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
	 * ND103DTO.javayakushinMapを設定
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
	 * ND103DTO.javasaveButtonFlgを設定
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
	 * ND103DTO.javaloginJokenSetCdを設定
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
	 * ND103DTO.javaloginNmを設定
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
	 * ND103DTO.javaloginBrCdを設定
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
	 * ND103DTO.javaloginDistCdを設定
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
	 * ND103DTO.javaloginShzNmを設定
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
	 * ND103DTO.javaloginTrtCdを設定
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
	 * ND103DTO.javaloginJgiNoを設定
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
	 * ND103DTO.javamsgStrを設定
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
	 * ND103DTO.javadeleteButtonFlgを設定
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
	 * ND103DTO.javaformTekiyoYmdを設定
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
	 * ND103DTO.javashinseiButtonFlgを設定
	 * @return shinseiButtonFlg
	 */
	public String getShinseiButtonFlg() {
		return shinseiButtonFlg;
	}

	/**
	 * @param shinseiButtonFlg セットする shinseiButtonFlg
	 */
	public void setShinseiButtonFlg(String shinseiButtonFlg) {
		this.shinseiButtonFlg = shinseiButtonFlg;
	}

	/**
	 * ND103DTO.javaerrorCheckFlgを設定
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
	 * ND103DTO.javadialogMstを設定
	 * @return dialogMst
	 */
	public String getDialogMst() {
		return dialogMst;
	}

	/**
	 * @param dialogMst セットする dialogMst
	 */
	public void setDialogMst(String dialogMst) {
		this.dialogMst = dialogMst;
	}

	/**
	 * ND103DTO.javaaprMemoを設定
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
	 * ND103DTO.javashinseiButtonEditを設定
	 * @return shinseiButtonEdit
	 */
	public String getShinseiButtonEdit() {
		return shinseiButtonEdit;
	}

	/**
	 * @param shinseiButtonEdit セットする shinseiButtonEdit
	 */
	public void setShinseiButtonEdit(String shinseiButtonEdit) {
		this.shinseiButtonEdit = shinseiButtonEdit;
	}

	/**
	 * ND103DTO.javasaveButtonEditを設定
	 * @return saveButtonEdit
	 */
	public String getSaveButtonEdit() {
		return saveButtonEdit;
	}

	/**
	 * @param saveButtonEdit セットする saveButtonEdit
	 */
	public void setSaveButtonEdit(String saveButtonEdit) {
		this.saveButtonEdit = saveButtonEdit;
	}

	/**
	 * ND103DTO.javainsShaYmdを設定
	 * @return insShaYmd
	 */
	public String getInsShaYmd() {
		return insShaYmd;
	}

	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(String insShaYmd) {
		this.insShaYmd = insShaYmd;
	}

	/**
	 * ND103DTO.javainsShaIdを設定
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
	 * ND103DTO.javaupdShaIdを設定
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
	 * ND103DTO.javareqIdを設定
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
	 * ND103DTO.javaparamInsNoを設定
	 * @return paramInsNo
	 */
	public String getParamInsNo() {
		return paramInsNo;
	}

	/**
	 * @param paramInsNo セットする paramInsNo
	 */
	public void setParamInsNo(String paramInsNo) {
		this.paramInsNo = paramInsNo;
	}

	/**
	 * ND103DTO.javainsClassを設定
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
	 * ND103DTO.javahoInsTypeを設定
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


}
