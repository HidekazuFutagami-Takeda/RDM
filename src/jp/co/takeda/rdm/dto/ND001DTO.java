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
public class ND001DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 1L;

	/**
     * タイトル
     */
    private String Title;

    /**
     * このDTOが関連付けられている画面ID
     */
    private String ND001 = "ND001";

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
     * 検索済かの判定用フラグ
     */
    private String pageFlag;

    /**
     * メッセージ中身
     */
    private String msgStr;

    /**
     * 最大表示件数（エラーチェック用）
     */
    private Integer maxPageCnt;

    /**
     * 検索結果件数（エラーチェック用）
     */
    private Integer pageCnt;

	/**
	 * 部門ランク
	 * @generated
	 */
	private String bumonRank;

	/**
	 * 上位組織
	 * @generated
	 */
	private String upSosCd;

	/**
	 * 組織
	 * @generated
	 */
	private String sosCd;

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
     * ULT医師コード
     */
    private String searchDcfIshiCd;

	/**
     * 施設固定C
     */
    private String searchInsNo;

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
     * ULT接続
     */
    private String searchSetsuzoku;

	/**
     * ULT接続リスト
     */
    private LinkedHashMap<String, String> searchSetsuzokuCombo;

	/**
     * 組織名
     */
    private String bumonSeiName;

	/**
     * 担当者名
     */
    private String jgiName;

	/**
	 * 担当者
	 * @generated
	 */
	private String jgiNo;


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

//    /**
//     * @generated
//     */
//    private List<JgiInitData> jgiInitData = new ArrayList<JgiInitData>();

    /**
     * @generated
     */
    private List<HcpData> hcpDataList = new ArrayList<HcpData>();


	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND001DTO() {
        setForward(ND001);
    }

    // START UOC

    // END UOC

    /**
	 * 繰返リストの取得
	 * @return 繰返リスト
	 */
	public List<HcpData> getHcpDataList() {
		return hcpDataList;
	}

	/**
	 * ND001DTO.javaND001を設定
	 * @return nD001
	 */
	public String getND001() {
		return ND001;
	}

	/**
	 * @param nD001 セットする nD001
	 */
	public void setND001(String nD001) {
		ND001 = nD001;
	}

	/**
	 * ND001DTO.javacallBackを設定
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
	 * ND001DTO.javawinVarNameを設定
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
	 * ND001DTO.javaparentClearProcを設定
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
	 * ND001DTO.javajokenSetCdを設定
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
	 * ND001DTO.javamrAdminFlgを設定
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
	 * ND001DTO.javasortConditionを設定
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
	 * ND001DTO.javapageFlagを設定
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
	 * ND001DTO.javamsgStrを設定
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
	 * ND001DTO.javamaxPageCntを設定
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
	 * ND001DTO.javapageCntを設定
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
	 * ND001DTO.javasearchDocNameを設定
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
	 * ND001DTO.javasearchDocKanaを設定
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
	 * ND001DTO.javasearchDocNoを設定
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
	 * ND001DTO.javasearchDcfIshiCdを設定
	 * @return searchDcfIshiCd
	 */
	public String getSearchDcfIshiCd() {
		return searchDcfIshiCd;
	}

	/**
	 * @param searchDcfIshiCd セットする searchDcfIshiCd
	 */
	public void setSearchDcfIshiCd(String searchDcfIshiCd) {
		this.searchDcfIshiCd = searchDcfIshiCd;
	}

	/**
	 * ND001DTO.javasearchInsNoを設定
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
	 * ND001DTO.javasearchDocAttributeを設定
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
	 * ND001DTO.javasearchDocAttributeComboを設定
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
	 * ND001DTO.javasearchDocTypeを設定
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
	 * ND001DTO.javasearchDocTypeComboを設定
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
	 * ND001DTO.javasearchMedSchを設定
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
	 * ND001DTO.javasearchMedSchComboを設定
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
	 * ND001DTO.javasearchGradYearを設定
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
	 * ND001DTO.javasearchGradYearComboを設定
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
	 * ND001DTO.javasearchHUnivを設定
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
	 * ND001DTO.javasearchHUnivComboを設定
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
	 * ND001DTO.javasearchSetsuzokuを設定
	 * @return searchSetsuzoku
	 */
	public String getSearchSetsuzoku() {
		return searchSetsuzoku;
	}

	/**
	 * @param searchSetsuzoku セットする searchSetsuzoku
	 */
	public void setSearchSetsuzoku(String searchSetsuzoku) {
		this.searchSetsuzoku = searchSetsuzoku;
	}

	/**
	 * ND001DTO.javasearchSetsuzokuComboを設定
	 * @return searchSetsuzokuCombo
	 */
	public LinkedHashMap<String, String> getSearchSetsuzokuCombo() {
		return searchSetsuzokuCombo;
	}

	/**
	 * @param searchSetsuzokuCombo セットする searchSetsuzokuCombo
	 */
	public void setSearchSetsuzokuCombo(LinkedHashMap<String, String> searchSetsuzokuCombo) {
		this.searchSetsuzokuCombo = searchSetsuzokuCombo;
	}

	/**
	 * ND001DTO.javabumonSeiNameを設定
	 * @return bumonSeiName
	 */
	public String getBumonSeiName() {
		return bumonSeiName;
	}

	/**
	 * @param bumonSeiName セットする bumonSeiName
	 */
	public void setBumonSeiName(String bumonSeiName) {
		this.bumonSeiName = bumonSeiName;
	}

	/**
	 * ND001DTO.javajgiNameを設定
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
	 * 繰返リストの設定
	　* @param sosInitSosData 繰返リスト
	 */
	public void setHcpDataList(List<HcpData> hcpDataList) {
		this.hcpDataList = hcpDataList;
	}

    /**
	 * ND001DTO.javaTitleを設定
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
	 * ND001DTO.javabumonRankを設定
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
	 * ND001DTO.javaupSosCdを設定
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
	 * ND001DTO.javasosCdを設定
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
	 * ND001DTO.javajgiNoを設定
	 * @return jgiNo
	 */
	public String getJgiNo() {
		return jgiNo;
	}

	/**
	 * @param jgiNo セットする jgiNo
	 */
	public void setJgiNo(String jgiNo) {
		this.jgiNo = jgiNo;
	}

	/**
	 * ND001DTO.javabrCodeを設定
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
	 * ND001DTO.javadistCodeを設定
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
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
