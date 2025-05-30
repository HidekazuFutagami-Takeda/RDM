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
public class ND313DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String ND313 = "ND313";

    /**
     * 親画面名
     * @generated
     */
    private String winVarName;

    /**
     * 親画面名
     * @generated
     */
    private String title;

    /**
     * 従業員番号
     */
    private int jgiNo;

    /**
     * 氏名
     */
    private String jgiName;

    /**
     * 組織コード
     * @generated
     */
    private String sosCd;

    /**
     * 医薬支店C
     * @generated
     */
    private String brCode;

    /**
     * 医薬営業所C
     * @generated
     */
    private String distCode;

    /**
     * 部門名略式
     * @generated
     */
    private String bumonRyakuName;

    /**
     * 部門ランク
     * @generated
     */
    private String bumonRank;

    /**
     * 上位組織コード
     * @generated
     */
    private String upSosCd;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;


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
     * 医師メニュースイッチ
     * @generated
     */
    private String actionEdit;

    /**
     * 申請ステータス(コード)
     * @generated
     */
    private String reqStsCd;

    /**
     * 処理フラグ
     * 0:申請処理
     * 1:却下処理
     * @generated
     */
    private String processFlg;

    /**
     * 申請チャネル
     * @generated
     */
    private String reqChl;

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
     * 役職コード(異動元)
     * @generated
     */
    private String titleCodeBf;

    /**
     * 役職名称(異動元)名称
     * @generated
     */
    private String titleCodeName;

    /**
     * 勤務形態(異動元)
     * @generated
     */
    private String jobFormBf;

    /**
     * 勤務形態(異動元)名称
     * @generated
     */
    private String jobFormBfName;

    /**
     * 薬審メンバー区分(異動元)
     * @generated
     */
    private String dccTypeBf;

    /**
     * 薬審メンバー区分(異動元)名称
     * @generated
     */
    private String dccTypeBfName;

    /**
     * 大学職位コード(異動元)
     * @generated
     */
    private String univPosCodeBf;

    /**
     * 大学職位コード(異動元)名称
     * @generated
     */
    private String univPosCodeBfName;

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
     * 施設固定コード(異動元)
     * @generated
     */
    private String insNoMt;

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
     * 所属部科コード(異動元)
     * @generated
     */
    private String deptCodeBf;

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
	 * アルトマークへの情報連携
	 * @generated
	 */
	private Boolean fbReqFlg;

	/**
	 * ULT医師C
	 * @generated
	 */
	private String ultDocNo;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND313DTO() {
        setForward(ND313);
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

	/**
	 * ND313DTO.javaND313を設定
	 * @return nD313
	 */
	public String getND313() {
		return ND313;
	}

	/**
	 * @param nD313 セットする nD313
	 */
	public void setND313(String nD313) {
		ND313 = nD313;
	}

	/**
	 * ND313DTO.javawinVarNameを設定
	 * @return winVarName
	 */
	public String getWinVarName() {
		return winVarName;
	}

	/**
	 * @param winVarName セットする winVarName
	 */
	public void setWinVarName(String winVarName) {
		this.winVarName = winVarName;
	}

	/**
	 * ND313DTO.javatitleを設定
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
	 * ND313DTO.javajokenSetCdを設定
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
	 * ND313DTO.javaloginJokenSetCdを設定
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
	 * ND313DTO.javaloginJgiNoを設定
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
	 * ND313DTO.javaloginNmを設定
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
	 * ND313DTO.javaloginBrCdを設定
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
	 * ND313DTO.javaloginDistCdを設定
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
	 * ND313DTO.javaloginShzNmを設定
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
	 * ND313DTO.javaloginTrtCdを設定
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
	 * ND313DTO.javafunctionIdを設定
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
	 * ND313DTO.javamsgStrを設定
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
	 * ND313DTO.javaparamDocNoを設定
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
	 * ND313DTO.javareqIdを設定
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
	 * ND313DTO.javaparamReqIdを設定
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
	 * ND313DTO.javasaveButtonFlgを設定
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
	 * ND313DTO.javadeleteButtonFlgを設定
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
	 * ND313DTO.javashinseiButtonFlgを設定
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
	 * ND313DTO.javaerrorCheckFlgを設定
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
	 * ND313DTO.javadialogMstを設定
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
	 * ND313DTO.javareqShzを設定
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
	 * ND313DTO.javainsClassを設定
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
	 * ND313DTO.javahoInsTypeを設定
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
	 * ND313DTO.javareqStsを設定
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
	 * ND313DTO.javajgiNameを設定
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
	 * ND313DTO.javareqYmdhmsを設定
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
	 * ND313DTO.javareqJgiNoを設定
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
	 * ND313DTO.javabrCodeを設定
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
	 * ND313DTO.javareqDistCodeを設定
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
	 * ND313DTO.javashinseiButtonEditを設定
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
	 * ND313DTO.javasaveButtonEditを設定
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
	 * ND313DTO.javareqStsCdを設定
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
	 * ND313DTO.javaupdShaYmdを設定
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
	 * ND313DTO.javainsShaYmdを設定
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
	 * ND313DTO.javainsShaIdを設定
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
	 * ND313DTO.javaupdShaIdを設定
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
	 * ND313DTO.javadocKanjを設定
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
	 * ND313DTO.javadocNoを設定
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
	 * ND313DTO.javaurlDocNoを設定
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
	 * ND313DTO.javainsAbbrNameを設定
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
	 * ND313DTO.javadeptKjを設定
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
	 * ND313DTO.javatitleCodeBfを設定
	 * @return titleCodeBf
	 */
	public String getTitleCodeBf() {
		return titleCodeBf;
	}

	/**
	 * @param titleCodeBf セットする titleCodeBf
	 */
	public void setTitleCodeBf(String titleCodeBf) {
		this.titleCodeBf = titleCodeBf;
	}

	/**
	 * ND313DTO.javajobFormBfを設定
	 * @return jobFormBf
	 */
	public String getJobFormBf() {
		return jobFormBf;
	}

	/**
	 * @param jobFormBf セットする jobFormBf
	 */
	public void setJobFormBf(String jobFormBf) {
		this.jobFormBf = jobFormBf;
	}

	/**
	 * ND313DTO.javadccTypeBfを設定
	 * @return dccTypeBf
	 */
	public String getDccTypeBf() {
		return dccTypeBf;
	}

	/**
	 * @param dccTypeBf セットする dccTypeBf
	 */
	public void setDccTypeBf(String dccTypeBf) {
		this.dccTypeBf = dccTypeBf;
	}

	/**
	 * ND313DTO.javaunivPosCodeBfを設定
	 * @return univPosCodeBf
	 */
	public String getUnivPosCodeBf() {
		return univPosCodeBf;
	}

	/**
	 * @param univPosCodeBf セットする univPosCodeBf
	 */
	public void setUnivPosCodeBf(String univPosCodeBf) {
		this.univPosCodeBf = univPosCodeBf;
	}

	/**
	 * ND313DTO.javatekiyoYmdを設定
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
	 * ND313DTO.javaformTekiyoYmdを設定
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
	 * ND313DTO.javainsNoMtを設定
	 * @return insNoMt
	 */
	public String getInsNoMt() {
		return insNoMt;
	}

	/**
	 * @param insNoMt セットする insNoMt
	 */
	public void setInsNoMt(String insNoMt) {
		this.insNoMt = insNoMt;
	}

	/**
	 * ND313DTO.javaparamInsNoを設定
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
	 * ND313DTO.javaultInsNoを設定
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
	 * ND313DTO.javadeptCodeBfを設定
	 * @return deptCodeBf
	 */
	public String getDeptCodeBf() {
		return deptCodeBf;
	}

	/**
	 * @param deptCodeBf セットする deptCodeBf
	 */
	public void setDeptCodeBf(String deptCodeBf) {
		this.deptCodeBf = deptCodeBf;
	}

	/**
	 * ND313DTO.javadeptKnを設定
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
	 * ND313DTO.javareqCommentを設定
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
	 * ND313DTO.javaaprMemoを設定
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
	 * ND313DTO.javaaprCommentを設定
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
	 * ND313DTO.javayakusyokuCdを設定
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
	 * ND313DTO.javayakusyokuMapを設定
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
	 * ND313DTO.javadaigakuSyokuiCdを設定
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
	 * ND313DTO.javadaigakuSyokuiMapを設定
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
	 * ND313DTO.javakinmuKeitaiCdを設定
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
	 * ND313DTO.javakinmuKeitaiMapを設定
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
	 * ND313DTO.javayakushinCdを設定
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
	 * ND313DTO.javayakushinMapを設定
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
	 * ND313DTO.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * ND313DTO.javatitleCodeNameを設定
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
	 * ND313DTO.javajobFormBfNameを設定
	 * @return jobFormBfName
	 */
	public String getJobFormBfName() {
		return jobFormBfName;
	}

	/**
	 * @param jobFormBfName セットする jobFormBfName
	 */
	public void setJobFormBfName(String jobFormBfName) {
		this.jobFormBfName = jobFormBfName;
	}

	/**
	 * ND313DTO.javadccTypeBfNameを設定
	 * @return dccTypeBfName
	 */
	public String getDccTypeBfName() {
		return dccTypeBfName;
	}

	/**
	 * @param dccTypeBfName セットする dccTypeBfName
	 */
	public void setDccTypeBfName(String dccTypeBfName) {
		this.dccTypeBfName = dccTypeBfName;
	}

	/**
	 * ND313DTO.javaunivPosCodeBfNameを設定
	 * @return univPosCodeBfName
	 */
	public String getUnivPosCodeBfName() {
		return univPosCodeBfName;
	}

	/**
	 * @param univPosCodeBfName セットする univPosCodeBfName
	 */
	public void setUnivPosCodeBfName(String univPosCodeBfName) {
		this.univPosCodeBfName = univPosCodeBfName;
	}

	/**
	 * ND313DTO.javajgiNoを設定
	 * @return jgiNo
	 */
	public int getJgiNo() {
		return jgiNo;
	}

	/**
	 * @param jgiNo セットする jgiNo
	 */
	public void setJgiNo(int jgiNo) {
		this.jgiNo = jgiNo;
	}

	/**
	 * ND313DTO.javasosCdを設定
	 * @return sosCd
	 */
	public String getSosCd() {
		return sosCd;
	}

	/**
	 * @param sosCd セットする sosCd
	 */
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

	/**
	 * ND313DTO.javadistCodeを設定
	 * @return distCode
	 */
	public String getDistCode() {
		return distCode;
	}

	/**
	 * @param distCode セットする distCode
	 */
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	/**
	 * ND313DTO.javabumonRyakuNameを設定
	 * @return bumonRyakuName
	 */
	public String getBumonRyakuName() {
		return bumonRyakuName;
	}

	/**
	 * @param bumonRyakuName セットする bumonRyakuName
	 */
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
	}

	/**
	 * ND313DTO.javabumonRankを設定
	 * @return bumonRank
	 */
	public String getBumonRank() {
		return bumonRank;
	}

	/**
	 * @param bumonRank セットする bumonRank
	 */
	public void setBumonRank(String bumonRank) {
		this.bumonRank = bumonRank;
	}

	/**
	 * ND313DTO.javaupSosCdを設定
	 * @return upSosCd
	 */
	public String getUpSosCd() {
		return upSosCd;
	}

	/**
	 * @param upSosCd セットする upSosCd
	 */
	public void setUpSosCd(String upSosCd) {
		this.upSosCd = upSosCd;
	}

	/**
	 * ND313DTO.javatrtCdを設定
	 * @return trtCd
	 */
	public String getTrtCd() {
		return trtCd;
	}

	/**
	 * @param trtCd セットする trtCd
	 */
	public void setTrtCd(String trtCd) {
		this.trtCd = trtCd;
	}

	/**
	 * ND313DTO.javareqChlを設定
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
	 * ND313DTO.javaprocessFlgを設定
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
	 * ND313DTO.javaactionEditを設定
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
	 * ND313DTO.javafbReqFlgを設定
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
	 * ND313DTO.javaultDocNoを設定
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


}
