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
public class NC209DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     */
    private String NC209 = "NC209";

	/**
     * イベントID
     * @generated
     */
    private String functionId;

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
     * 呼び出し元のClear処理メソッド名
     * @generated
     */
    private String parentClearProc;

	/**
     * 条件セット
     */
    private String jokenSetCd;

	/**
     * MR権限/管理者権限判定
     */
    private String mrAdminFlg;

	/**
     * ソートID
     */
    private String sortCondition;

    /**
     * ヘッダ表示フラグ
     * @generated
     */
    private int pageFlg;

    /**
     * メッセージ中身
     */
    private String msgStr;

    /**
     * 最大表示件数（エラーチェック用）
     */
    private Integer maxPageCnt;

    /**
     * 最大表示件数（ページング用）
     */
    private Integer pageRowNum;

    /**
     * ソート順序区分
     * @generated
     */
    private Integer orderKbn;

    /**
     * 検索結果件数（エラーチェック用）
     */
    private Integer pageCnt;

    /**
	 * 画面タイトル
	 * @generated
	 */
	private String title;

	/**
     * 氏名漢字(全角)※
     */
    private String searchDocName;

	/**
     * 氏名カナ(半角カナ)※
     */
    private String searchDocKana;

	/**
     * 医師固定C
     */
    private String searchDocNo;

	/**
     * 医師属性
     */
    private String searchDocAttribute;

	/**
     * 医師属性リスト
     */
    private LinkedHashMap<String, String> searchDocAttributeCombo;

	/**
     * 医師／薬剤師区分
     */
    private String searchDocType;

	/**
     * 医師／薬剤師区分リスト
     */
    private LinkedHashMap<String, String> searchDocTypeCombo;

	/**
     * 出身校
     */
    private String searchMedSch;

	/**
     * 出身校リスト
     */
    private LinkedHashMap<String, String> searchMedSchCombo;

	/**
     * 卒年(西暦)
     */
    private String searchGradYear;

	/**
     * 卒年(西暦)リスト
     */
    private LinkedHashMap<String, String> searchGradYearCombo;

	/**
     * 出身医局校
     */
    private String searchHUniv;

	/**
     * 出身医局校リスト
     */
    private LinkedHashMap<String, String> searchHUnivCombo;

	/**
     * 組織コード
     */
    private String searchSosCd;

	/**
     * 組織名
     */
    private String searchSosNm;

	/**
     * 組織部門ランク
     */
    private String searchSosRank;

    /**
     * 担当者コード
     */
    private Integer searchTantoCd;

    /**
     * 担当者名
     */
    private String searchTantoNm;

	/**
     * 施設固定C
     */
    private String searchInsNo;

	/**
     * 施設名
     */
    private String searchInsNm;

	/**
     * 所属部科コード
     */
    private String searchDeptCd;

	/**
     * 所属部科名
     */
    private String searchDeptNm;

	/**
	 * 上位組織
	 * @generated
	 */
	private String upSosCd;

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

    /*ログインユーザ情報*/
    private String loginBrCode;
    private String loginBumonRank;
    private String loginBumonRyakuName;
    private String loginDistCode;
    private String loginJgiName;
    private String loginJgiNo;
    private String loginSosCd;
    private String loginUpSosCode  ;

    /**
     * @generated
     */
    private List<HcpData> hcpDataList = new ArrayList<HcpData>();


	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC209DTO() {
        setForward(NC209);
    }



    /**
	 * NC209DTO.javaNC209を設定
	 * @return nC209
	 */
	public String getNC209() {
		return NC209;
	}



	/**
	 * @param nC209 セットする nC209
	 */
	public void setNC209(String nC209) {
		NC209 = nC209;
	}



	/**
	 * NC209DTO.javafunctionIdを設定
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
	 * NC209DTO.javacallBackを設定
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
	 * NC209DTO.javawinVarNameを設定
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
	 * NC209DTO.javaparentClearProcを設定
	 * @return parentClearProc
	 */
	public String getParentClearProc() {
		return parentClearProc;
	}



	/**
	 * @param parentClearProc セットする parentClearProc
	 */
	public void setParentClearProc(String parentClearProc) {
		this.parentClearProc = parentClearProc;
	}



	/**
	 * NC209DTO.javajokenSetCdを設定
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
	 * NC209DTO.javamrAdminFlgを設定
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
	 * NC209DTO.javasortConditionを設定
	 * @return sortCondition
	 */
	public String getSortCondition() {
		return sortCondition;
	}



	/**
	 * @param sortCondition セットする sortCondition
	 */
	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}





	/**
	 * NC209DTO.javapageFlgを設定
	 * @return pageFlg
	 */
	public int getPageFlg() {
		return pageFlg;
	}



	/**
	 * @param pageFlg セットする pageFlg
	 */
	public void setPageFlg(int pageFlg) {
		this.pageFlg = pageFlg;
	}



	/**
	 * NC209DTO.javamsgStrを設定
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
	 * NC209DTO.javamaxPageCntを設定
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
	 * NC209DTO.javapageRowNumを設定
	 * @return pageRowNum
	 */
	public Integer getPageRowNum() {
		return pageRowNum;
	}



	/**
	 * @param pageRowNum セットする pageRowNum
	 */
	public void setPageRowNum(Integer pageRowNum) {
		this.pageRowNum = pageRowNum;
	}



	/**
	 * NC209DTO.javaorderKbnを設定
	 * @return orderKbn
	 */
	public Integer getOrderKbn() {
		return orderKbn;
	}



	/**
	 * @param orderKbn セットする orderKbn
	 */
	public void setOrderKbn(Integer orderKbn) {
		this.orderKbn = orderKbn;
	}



	/**
	 * NC209DTO.javapageCntを設定
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
	 * NC209DTO.javatitleを設定
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
	 * NC209DTO.javasearchDocNameを設定
	 * @return searchDocName
	 */
	public String getSearchDocName() {
		return searchDocName;
	}



	/**
	 * @param searchDocName セットする searchDocName
	 */
	public void setSearchDocName(String searchDocName) {
		this.searchDocName = searchDocName;
	}



	/**
	 * NC209DTO.javasearchDocKanaを設定
	 * @return searchDocKana
	 */
	public String getSearchDocKana() {
		return searchDocKana;
	}



	/**
	 * @param searchDocKana セットする searchDocKana
	 */
	public void setSearchDocKana(String searchDocKana) {
		this.searchDocKana = searchDocKana;
	}



	/**
	 * NC209DTO.javasearchDocNoを設定
	 * @return searchDocNo
	 */
	public String getSearchDocNo() {
		return searchDocNo;
	}



	/**
	 * @param searchDocNo セットする searchDocNo
	 */
	public void setSearchDocNo(String searchDocNo) {
		this.searchDocNo = searchDocNo;
	}



	/**
	 * NC209DTO.javasearchDocAttributeを設定
	 * @return searchDocAttribute
	 */
	public String getSearchDocAttribute() {
		return searchDocAttribute;
	}



	/**
	 * @param searchDocAttribute セットする searchDocAttribute
	 */
	public void setSearchDocAttribute(String searchDocAttribute) {
		this.searchDocAttribute = searchDocAttribute;
	}



	/**
	 * NC209DTO.javasearchDocAttributeComboを設定
	 * @return searchDocAttributeCombo
	 */
	public LinkedHashMap<String, String> getSearchDocAttributeCombo() {
		return searchDocAttributeCombo;
	}



	/**
	 * @param searchDocAttributeCombo セットする searchDocAttributeCombo
	 */
	public void setSearchDocAttributeCombo(LinkedHashMap<String, String> searchDocAttributeCombo) {
		this.searchDocAttributeCombo = searchDocAttributeCombo;
	}



	/**
	 * NC209DTO.javasearchDocTypeを設定
	 * @return searchDocType
	 */
	public String getSearchDocType() {
		return searchDocType;
	}



	/**
	 * @param searchDocType セットする searchDocType
	 */
	public void setSearchDocType(String searchDocType) {
		this.searchDocType = searchDocType;
	}



	/**
	 * NC209DTO.javasearchDocTypeComboを設定
	 * @return searchDocTypeCombo
	 */
	public LinkedHashMap<String, String> getSearchDocTypeCombo() {
		return searchDocTypeCombo;
	}



	/**
	 * @param searchDocTypeCombo セットする searchDocTypeCombo
	 */
	public void setSearchDocTypeCombo(LinkedHashMap<String, String> searchDocTypeCombo) {
		this.searchDocTypeCombo = searchDocTypeCombo;
	}



	/**
	 * NC209DTO.javasearchMedSchを設定
	 * @return searchMedSch
	 */
	public String getSearchMedSch() {
		return searchMedSch;
	}



	/**
	 * @param searchMedSch セットする searchMedSch
	 */
	public void setSearchMedSch(String searchMedSch) {
		this.searchMedSch = searchMedSch;
	}



	/**
	 * NC209DTO.javasearchMedSchComboを設定
	 * @return searchMedSchCombo
	 */
	public LinkedHashMap<String, String> getSearchMedSchCombo() {
		return searchMedSchCombo;
	}



	/**
	 * @param searchMedSchCombo セットする searchMedSchCombo
	 */
	public void setSearchMedSchCombo(LinkedHashMap<String, String> searchMedSchCombo) {
		this.searchMedSchCombo = searchMedSchCombo;
	}



	/**
	 * NC209DTO.javasearchGradYearを設定
	 * @return searchGradYear
	 */
	public String getSearchGradYear() {
		return searchGradYear;
	}



	/**
	 * @param searchGradYear セットする searchGradYear
	 */
	public void setSearchGradYear(String searchGradYear) {
		this.searchGradYear = searchGradYear;
	}



	/**
	 * NC209DTO.javasearchGradYearComboを設定
	 * @return searchGradYearCombo
	 */
	public LinkedHashMap<String, String> getSearchGradYearCombo() {
		return searchGradYearCombo;
	}



	/**
	 * @param searchGradYearCombo セットする searchGradYearCombo
	 */
	public void setSearchGradYearCombo(LinkedHashMap<String, String> searchGradYearCombo) {
		this.searchGradYearCombo = searchGradYearCombo;
	}



	/**
	 * NC209DTO.javasearchHUnivを設定
	 * @return searchHUniv
	 */
	public String getSearchHUniv() {
		return searchHUniv;
	}



	/**
	 * @param searchHUniv セットする searchHUniv
	 */
	public void setSearchHUniv(String searchHUniv) {
		this.searchHUniv = searchHUniv;
	}



	/**
	 * NC209DTO.javasearchHUnivComboを設定
	 * @return searchHUnivCombo
	 */
	public LinkedHashMap<String, String> getSearchHUnivCombo() {
		return searchHUnivCombo;
	}



	/**
	 * @param searchHUnivCombo セットする searchHUnivCombo
	 */
	public void setSearchHUnivCombo(LinkedHashMap<String, String> searchHUnivCombo) {
		this.searchHUnivCombo = searchHUnivCombo;
	}



	/**
	 * NC209DTO.javasearchSosCdを設定
	 * @return searchSosCd
	 */
	public String getSearchSosCd() {
		return searchSosCd;
	}



	/**
	 * @param searchSosCd セットする searchSosCd
	 */
	public void setSearchSosCd(String searchSosCd) {
		this.searchSosCd = searchSosCd;
	}



	/**
	 * NC209DTO.javasearchSosNmを設定
	 * @return searchSosNm
	 */
	public String getSearchSosNm() {
		return searchSosNm;
	}



	/**
	 * @param searchSosNm セットする searchSosNm
	 */
	public void setSearchSosNm(String searchSosNm) {
		this.searchSosNm = searchSosNm;
	}



	/**
	 * NC209DTO.javasearchSosRankを設定
	 * @return searchSosRank
	 */
	public String getSearchSosRank() {
		return searchSosRank;
	}



	/**
	 * @param searchSosRank セットする searchSosRank
	 */
	public void setSearchSosRank(String searchSosRank) {
		this.searchSosRank = searchSosRank;
	}



	/**
	 * NC209DTO.javasearchTantoCdを設定
	 * @return searchTantoCd
	 */
	public Integer getSearchTantoCd() {
		return searchTantoCd;
	}



	/**
	 * @param searchTantoCd セットする searchTantoCd
	 */
	public void setSearchTantoCd(Integer searchTantoCd) {
		this.searchTantoCd = searchTantoCd;
	}



	/**
	 * NC209DTO.javasearchTantoNmを設定
	 * @return searchTantoNm
	 */
	public String getSearchTantoNm() {
		return searchTantoNm;
	}



	/**
	 * @param searchTantoNm セットする searchTantoNm
	 */
	public void setSearchTantoNm(String searchTantoNm) {
		this.searchTantoNm = searchTantoNm;
	}



	/**
	 * NC209DTO.javasearchInsNoを設定
	 * @return searchInsNo
	 */
	public String getSearchInsNo() {
		return searchInsNo;
	}



	/**
	 * @param searchInsNo セットする searchInsNo
	 */
	public void setSearchInsNo(String searchInsNo) {
		this.searchInsNo = searchInsNo;
	}



	/**
	 * NC209DTO.javasearchInsNmを設定
	 * @return searchInsNm
	 */
	public String getSearchInsNm() {
		return searchInsNm;
	}



	/**
	 * @param searchInsNm セットする searchInsNm
	 */
	public void setSearchInsNm(String searchInsNm) {
		this.searchInsNm = searchInsNm;
	}



	/**
	 * NC209DTO.javasearchDeptCdを設定
	 * @return searchDeptCd
	 */
	public String getSearchDeptCd() {
		return searchDeptCd;
	}



	/**
	 * @param searchDeptCd セットする searchDeptCd
	 */
	public void setSearchDeptCd(String searchDeptCd) {
		this.searchDeptCd = searchDeptCd;
	}



	/**
	 * NC209DTO.javasearchDeptNmを設定
	 * @return searchDeptNm
	 */
	public String getSearchDeptNm() {
		return searchDeptNm;
	}



	/**
	 * @param searchDeptNm セットする searchDeptNm
	 */
	public void setSearchDeptNm(String searchDeptNm) {
		this.searchDeptNm = searchDeptNm;
	}



	/**
	 * NC209DTO.javahcpDataListを設定
	 * @return hcpDataList
	 */
	public List<HcpData> getHcpDataList() {
		return hcpDataList;
	}



	/**
	 * @param hcpDataList セットする hcpDataList
	 */
	public void setHcpDataList(List<HcpData> hcpDataList) {
		this.hcpDataList = hcpDataList;
	}



	/**
	 * NC209DTO.javaupSosCdを設定
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
	 * NC209DTO.javabrCodeを設定
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
	 * NC209DTO.javadistCodeを設定
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
	 * NC209DTO.javaloginBrCodeを設定
	 * @return loginBrCode
	 */
	public String getLoginBrCode() {
		return loginBrCode;
	}



	/**
	 * @param loginBrCode セットする loginBrCode
	 */
	public void setLoginBrCode(String loginBrCode) {
		this.loginBrCode = loginBrCode;
	}



	/**
	 * NC209DTO.javaloginBumonRankを設定
	 * @return loginBumonRank
	 */
	public String getLoginBumonRank() {
		return loginBumonRank;
	}



	/**
	 * @param loginBumonRank セットする loginBumonRank
	 */
	public void setLoginBumonRank(String loginBumonRank) {
		this.loginBumonRank = loginBumonRank;
	}



	/**
	 * NC209DTO.javaloginBumonRyakuNameを設定
	 * @return loginBumonRyakuName
	 */
	public String getLoginBumonRyakuName() {
		return loginBumonRyakuName;
	}



	/**
	 * @param loginBumonRyakuName セットする loginBumonRyakuName
	 */
	public void setLoginBumonRyakuName(String loginBumonRyakuName) {
		this.loginBumonRyakuName = loginBumonRyakuName;
	}



	/**
	 * NC209DTO.javaloginDistCodeを設定
	 * @return loginDistCode
	 */
	public String getLoginDistCode() {
		return loginDistCode;
	}



	/**
	 * @param loginDistCode セットする loginDistCode
	 */
	public void setLoginDistCode(String loginDistCode) {
		this.loginDistCode = loginDistCode;
	}



	/**
	 * NC209DTO.javaloginJgiNameを設定
	 * @return loginJgiName
	 */
	public String getLoginJgiName() {
		return loginJgiName;
	}



	/**
	 * @param loginJgiName セットする loginJgiName
	 */
	public void setLoginJgiName(String loginJgiName) {
		this.loginJgiName = loginJgiName;
	}



	/**
	 * NC209DTO.javaloginJgiNoを設定
	 * @return loginJgiNo
	 */
	public String getLoginJgiNo() {
		return loginJgiNo;
	}



	/**
	 * @param loginJgiNo セットする loginJgiNo
	 */
	public void setLoginJgiNo(String loginJgiNo) {
		this.loginJgiNo = loginJgiNo;
	}



	/**
	 * NC209DTO.javaloginSosCdを設定
	 * @return loginSosCd
	 */
	public String getLoginSosCd() {
		return loginSosCd;
	}



	/**
	 * @param loginSosCd セットする loginSosCd
	 */
	public void setLoginSosCd(String loginSosCd) {
		this.loginSosCd = loginSosCd;
	}



	/**
	 * NC209DTO.javaloginUpSosCodeを設定
	 * @return loginUpSosCode
	 */
	public String getLoginUpSosCode() {
		return loginUpSosCode;
	}



	/**
	 * @param loginUpSosCode セットする loginUpSosCode
	 */
	public void setLoginUpSosCode(String loginUpSosCode) {
		this.loginUpSosCode = loginUpSosCode;
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
