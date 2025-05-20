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
public class ND104DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String ND104 = "ND104";

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
     * 医師メニュースイッチ
     * @generated
     */
    private String actionEdit;

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
     * 審査完了ボタン押下フラグ
     * 0:押下前
     * 1:押下済み
     * @generated
     */
    private String shnCompButtonFlg = "0";

	/**
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

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
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND104DTO() {
        setForward(ND104);
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
	 * ND104DTO.javaND104を設定
	 * @return nD104
	 */
	public String getND104() {
		return ND104;
	}

	/**
	 * @param nD104 セットする nD104
	 */
	public void setND104(String nD104) {
		ND104 = nD104;
	}

	/**
	 * ND104DTO.javawinVarNameを設定
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
	 * ND104DTO.javatitleを設定
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
	 * ND104DTO.javajokenSetCdを設定
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
	 * ND104DTO.javaloginJokenSetCdを設定
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
	 * ND104DTO.javaloginJgiNoを設定
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
	 * ND104DTO.javaloginNmを設定
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
	 * ND104DTO.javaloginBrCdを設定
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
	 * ND104DTO.javaloginDistCdを設定
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
	 * ND104DTO.javaloginShzNmを設定
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
	 * ND104DTO.javaloginTrtCdを設定
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
	 * ND104DTO.javafunctionIdを設定
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
	 * ND104DTO.javamsgStrを設定
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
	 * ND104DTO.javaparamDocNoを設定
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
	 * ND104DTO.javareqIdを設定
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
	 * ND104DTO.javaparamReqIdを設定
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
	 * ND104DTO.javasaveButtonFlgを設定
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
	 * ND104DTO.javadeleteButtonFlgを設定
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
	 * ND104DTO.javashinseiButtonFlgを設定
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
	 * ND104DTO.javaerrorCheckFlgを設定
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
	 * ND104DTO.javadialogMstを設定
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
	 * ND104DTO.javareqShzを設定
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
	 * ND104DTO.javainsClassを設定
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
	 * ND104DTO.javahoInsTypeを設定
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
	 * ND104DTO.javareqStsを設定
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
	 * ND104DTO.javajgiNameを設定
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
	 * ND104DTO.javareqYmdhmsを設定
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
	 * ND104DTO.javareqJgiNoを設定
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
	 * ND104DTO.javabrCodeを設定
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
	 * ND104DTO.javareqDistCodeを設定
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
	 * ND104DTO.javashinseiButtonEditを設定
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
	 * ND104DTO.javasaveButtonEditを設定
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
	 * ND104DTO.javareqStsCdを設定
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
	 * ND104DTO.javaupdShaYmdを設定
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
	 * ND104DTO.javainsShaYmdを設定
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
	 * ND104DTO.javainsShaIdを設定
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
	 * ND104DTO.javaupdShaIdを設定
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
	 * ND104DTO.javadocKanjを設定
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
	 * ND104DTO.javadocNoを設定
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
	 * ND104DTO.javaurlDocNoを設定
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
	 * ND104DTO.javainsAbbrNameを設定
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
	 * ND104DTO.javadeptKjを設定
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
	 * ND104DTO.javatitleCodeBfを設定
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
	 * ND104DTO.javajobFormBfを設定
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
	 * ND104DTO.javadccTypeBfを設定
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
	 * ND104DTO.javaunivPosCodeBfを設定
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
	 * ND104DTO.javatekiyoYmdを設定
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
	 * ND104DTO.javaformTekiyoYmdを設定
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
	 * ND104DTO.javainsNoMtを設定
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
	 * ND104DTO.javaparamInsNoを設定
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
	 * ND104DTO.javaultInsNoを設定
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
	 * ND104DTO.javadeptCodeBfを設定
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
	 * ND104DTO.javadeptKnを設定
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
	 * ND104DTO.javareqCommentを設定
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
	 * ND104DTO.javaaprMemoを設定
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
	 * ND104DTO.javaaprCommentを設定
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
	 * ND104DTO.javaactionEditを設定
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
	 * ND104DTO.javayakusyokuCdを設定
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
	 * ND104DTO.javayakusyokuMapを設定
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
	 * ND104DTO.javadaigakuSyokuiCdを設定
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
	 * ND104DTO.javadaigakuSyokuiMapを設定
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
	 * ND104DTO.javakinmuKeitaiCdを設定
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
	 * ND104DTO.javakinmuKeitaiMapを設定
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
	 * ND104DTO.javayakushinCdを設定
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
	 * ND104DTO.javayakushinMapを設定
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
	 * ND104DTO.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * ND104DTO.javatitleCodeNameを設定
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
	 * ND104DTO.javajobFormBfNameを設定
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
	 * ND104DTO.javadccTypeBfNameを設定
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
	 * ND104DTO.javaunivPosCodeBfNameを設定
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
	 * ND104DTO.javajgiNoを設定
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
	 * ND104DTO.javasosCdを設定
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
	 * ND104DTO.javadistCodeを設定
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
	 * ND104DTO.javabumonRyakuNameを設定
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
	 * ND104DTO.javabumonRankを設定
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
	 * ND104DTO.javaupSosCdを設定
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
	 * ND104DTO.javatrtCdを設定
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
	 * ND104DTO.javashnCompButtonFlgを設定
	 * @return shnCompButtonFlg
	 */
	public String getShnCompButtonFlg() {
		return shnCompButtonFlg;
	}

	/**
	 * @param shnCompButtonFlg セットする shnCompButtonFlg
	 */
	public void setShnCompButtonFlg(String shnCompButtonFlg) {
		this.shnCompButtonFlg = shnCompButtonFlg;
	}

	/**
	 * ND104DTO.javashnFlgを設定
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
	 * ND104DTO.javashnShaNameを設定
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
	 * ND104DTO.javashnYmdhmsを設定
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
	 * ND104DTO.javaaprShaNameを設定
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
	 * ND104DTO.javaaprYmdhmsを設定
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
	 * ND104DTO.javashnJgiNoを設定
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
	 * ND104DTO.javaaprJgiNoを設定
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


}
