/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.takeda.rdm.common.BaseDTO;

/**
 * DTOクラス
 * @generated
 */
public class ND013DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String ND013 = "ND013";

    /**
	 * 画面タイトル
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
     * イベントID
     * @generated
     */
    private String functionId;

    /**
     * 親画面施設固定コード
     * @generated
     */
    private String paramDocNo;

    /**
     * 検索区分
     * @generated
     */
    private String searchType;

    /**
     * エラー判定
     * @generated
     */
    private boolean errorBool = true;

    /**
     * ボタンフラグ
     * 1：ボタン押下済み
     * @generated
     */
    private String buttonFlg ="";


    /**
     * エラーメッセージ
     * @generated
     */
    private String msgStr = "";

    /**
     * ダイアログメッセージ
     * @generated
     */
    private String dialog = "";

    /**
     * 武田医師名（漢字）
     * @generated
     */
    private String docKanj;

    /**
     * 武田医師名（ｶﾅ）
     * @generated
     */
    private String docKana;

    /**
     * 医師固定C
     * @generated
     */
    private String docNo;

    /**
     * 施設固定コード(隠し)
     * @generated
     */
    private String insNoKakusi;

    /**
     * 異動・更新フラグ
     * 0:「医療機関への異動」画面
     * 1:「医療機関以外への異動」画面
     * @generated
     */
    private String movemedEditFlg;


    /**
     * 医師薬剤師区分
     * @generated
     */
    private String docType;

    /**
     * ULT医師名（漢字）
     * @generated
     */
    private String ultKanj;

    /**
     * ULT医師名（ｶﾅ）
     * @generated
     */
    private String ultKana;

    /**
     * 勤務先_件数
     * @generated
     */
    private int kinmuCount = 0;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * 医師勤務先追加ボタン
     * 0:非表示
     * 1:非活性
     * 2:活性
     * @generated
     */
    private String ishiNewKinmu;

    /**
     * 医師の廃業・死亡ボタン
     * 0:非活性
     * 1:活性
     * @generated
     */
    private String ishiHaigyou;


    /**
     * 施設固定コード
     * @generated
     */
    private Integer dummyHcoCount;
    /**
     * エラーチェックフラグ
     * 0:チェックなし
     * 1:「勤務先追加」ボタン押下
     * 2:「医師の廃業・死亡」ボタン押下
     * 3:「勤務先削除」リンククリック
     * 4:「勤務先情報更新」リンククリック
     * 5:「医療機関への異動」リンククリック
     * 6:「医療機関以外への異動」リンククリック
     * @generated
     */
    private String errorCheckFlg = "0";

    /**
     * @施設一覧リスト
     */
    private List<HcpWorkData> hcpWorkData = new ArrayList<HcpWorkData>();

    /**
     * 削除フラグ
     * @generated
     */
    private String delFlg;

	/**
	 * ULT医師C
	 * @generated
	 */
	private String ultDocNo;

    /**
     * 遷移用
     *
     */
    private String tabFlg;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * ND013DTO.javaND013を設定
	 * @return nD013
	 */
	public String getND013() {
		return ND013;
	}

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND013DTO() {
        setForward(ND013);
    }

	/**
	 * @param nD013 セットする nD013
	 */
	public void setND013(String nD013) {
		ND013 = nD013;
	}

	/**
	 * ND013DTO.javatitleを設定
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
	 * ND013DTO.javacallBackを設定
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
	 * ND013DTO.javawinVarNameを設定
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
	 * ND013DTO.javajokenSetCdを設定
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
	 * ND013DTO.javafunctionIdを設定
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
	 * ND013DTO.javasearchTypeを設定
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
	 * ND013DTO.javadocKanjを設定
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
	 * ND013DTO.javadocKanaを設定
	 * @return docKana
	 */
	public String getDocKana() {
		return docKana;
	}

	/**
	 * @param docKana セットする docKana
	 */
	public void setDocKana(String docKana) {
		this.docKana = docKana;
	}

	/**
	 * ND013DTO.javadocNoを設定
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
	 * ND013DTO.javadocTypeを設定
	 * @return docType
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * @param docType セットする docType
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/**
	 * ND013DTO.javaultKanjを設定
	 * @return ultKanj
	 */
	public String getUltKanj() {
		return ultKanj;
	}

	/**
	 * @param ultKanj セットする ultKanj
	 */
	public void setUltKanj(String ultKanj) {
		this.ultKanj = ultKanj;
	}

	/**
	 * ND013DTO.javaultKanaを設定
	 * @return ultKana
	 */
	public String getUltKana() {
		return ultKana;
	}

	/**
	 * @param ultKana セットする ultKana
	 */
	public void setUltKana(String ultKana) {
		this.ultKana = ultKana;
	}

	/**
	 * ND013DTO.javadelFlgを設定
	 * @return delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg セットする delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * ND013DTO.javaparamDocNoを設定
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
	 * ND013DTO.javahcpWorkDataを設定
	 * @return hcpWorkData
	 */
	public List<HcpWorkData> getHcpWorkData() {
		return hcpWorkData;
	}

	/**
	 * @param hcpWorkData セットする hcpWorkData
	 */
	public void setHcpWorkData(List<HcpWorkData> hcpWorkData) {
		this.hcpWorkData = hcpWorkData;
	}

	/**
	 * ND013DTO.javakinmuCountを設定
	 * @return kinmuCount
	 */
	public int getKinmuCount() {
		return kinmuCount;
	}

	/**
	 * @param kinmuCount セットする kinmuCount
	 */
	public void setKinmuCount(int kinmuCount) {
		this.kinmuCount = kinmuCount;
	}

	/**
	 * ND013DTO.javaishiNewKinmuを設定
	 * @return ishiNewKinmu
	 */
	public String getIshiNewKinmu() {
		return ishiNewKinmu;
	}

	/**
	 * @param ishiNewKinmu セットする ishiNewKinmu
	 */
	public void setIshiNewKinmu(String ishiNewKinmu) {
		this.ishiNewKinmu = ishiNewKinmu;
	}

	/**
	 * ND013DTO.javaishiHaigyouを設定
	 * @return ishiHaigyou
	 */
	public String getIshiHaigyou() {
		return ishiHaigyou;
	}

	/**
	 * @param ishiHaigyou セットする ishiHaigyou
	 */
	public void setIshiHaigyou(String ishiHaigyou) {
		this.ishiHaigyou = ishiHaigyou;
	}

	/**
	 * ND013DTO.javamovemedEditFlgを設定
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
	 * ND013DTO.javaerrorCheckFlgを設定
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
	 * ND013DTO.javainsNoを設定
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
	 * ND013DTO.javamsgStrを設定
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
	 * ND013DTO.javaerrorBoolを設定
	 * @return errorBool
	 */
	public boolean isErrorBool() {
		return errorBool;
	}

	/**
	 * @param errorBool セットする errorBool
	 */
	public void setErrorBool(boolean errorBool) {
		this.errorBool = errorBool;
	}

	/**
	 * ND013DTO.javabuttonFlgを設定
	 * @return buttonFlg
	 */
	public String getButtonFlg() {
		return buttonFlg;
	}

	/**
	 * @param buttonFlg セットする buttonFlg
	 */
	public void setButtonFlg(String buttonFlg) {
		this.buttonFlg = buttonFlg;
	}

	/**
	 * ND013DTO.javadialogを設定
	 * @return dialog
	 */
	public String getDialog() {
		return dialog;
	}

	/**
	 * @param dialog セットする dialog
	 */
	public void setDialog(String dialog) {
		this.dialog = dialog;
	}

	/**
	 * ND013DTO.javainsNoKakusiを設定
	 * @return insNoKakusi
	 */
	public String getInsNoKakusi() {
		return insNoKakusi;
	}

	/**
	 * @param insNoKakusi セットする insNoKakusi
	 */
	public void setInsNoKakusi(String insNoKakusi) {
		this.insNoKakusi = insNoKakusi;
	}

	/**
	 * ND013DTO.javadummyHcoCountを設定
	 * @return dummyHcoCount
	 */
	public Integer getDummyHcoCount() {
		return dummyHcoCount;
	}

	/**
	 * @param dummyHcoCount セットする dummyHcoCount
	 */
	public void setDummyHcoCount(Integer dummyHcoCount) {
		this.dummyHcoCount = dummyHcoCount;
	}

	/**
	 * ND013DTO.javatabFlgを設定
	 * @return tabFlg
	 */
	public String getTabFlg() {
		return tabFlg;
	}

	/**
	 * @param tabFlg セットする tabFlg
	 */
	public void setTabFlg(String tabFlg) {
		this.tabFlg = tabFlg;
	}

	/**
	 * ND013DTO.javaultDocNoを設定
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
