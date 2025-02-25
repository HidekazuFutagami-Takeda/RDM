/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * DTOクラス
 * @generated
 */
public class NC204DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NC204 = "NC204";

    private String preScreenId;



	/**
     * 検索条件_所属部科名(全角カナ)
     * @generated
     */
    private String kensakuKana;

    /**
     * 検索条件_所属部科名(漢字)
     * @generated
     */
    private String kensakuKanj;
    /**
     * 所属部科名(漢字)
     * @generated
     */
    private String deptCode;
    /**
     * 所属部科名(漢字)
     * @generated
     */
    private String DeptKj;
    /**
     * 所属部科名(漢字)
     * @generated
     */
    private String DeptKn;

    /**
     * 選択済所属部科名
     * @generated
     */
    private String display;
    /**
     * 全所属部科チェックボックス
     * @generated
     */
    private boolean allCheck;
    /**
     * 検索文字列
     * @generated
     */
    private String searchInput;

    private String selectCntEntity2;

    /**
     * 検索文字列
     * @generated
     */
    private String inSearchInput;
    /**
     * 選択済所属部科コード
     * @generated
     */
    private String[] cdcCheckedCodes;

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
     * 親画面施設固定コード
     * @generated
     */
    private String paramInsNo;

    /**
    * 施設略式漢字名
    * @generated
    */
   private String insAbbrName;

   /**
   * カウント
   * @generated
   */
  private String Count;


	/**
     * @generated
     */
    private List<CatDeptsComboDataList> catDeptsComboDataList = new ArrayList<CatDeptsComboDataList>();

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC204DTO() {
        setForward(NC204);
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
	 * NC204DTO.javaNC204を設定
	 * @return nC204
	 */
	public String getNC204() {
		return NC204;
	}

	/**
	 * @param nC204 セットする nC204
	 */
	public void setNC204(String nC204) {
		NC204 = nC204;
	}

	/**
	 * NC204DTO.javapreScreenIdを設定
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
	 * NC204DTO.javakensakuKanaを設定
	 * @return kensakuKana
	 */
	public String getKensakuKana() {
		return kensakuKana;
	}

	/**
	 * @param kensakuKana セットする kensakuKana
	 */
	public void setKensakuKana(String kensakuKana) {
		this.kensakuKana = kensakuKana;
	}

	/**
	 * NC204DTO.javakensakuKanjを設定
	 * @return kensakuKanj
	 */
	public String getKensakuKanj() {
		return kensakuKanj;
	}

	/**
	 * @param kensakuKanj セットする kensakuKanj
	 */
	public void setKensakuKanj(String kensakuKanj) {
		this.kensakuKanj = kensakuKanj;
	}

	/**
	 * NC204DTO.javadeptCodeを設定
	 * @return deptCode
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * @param deptCode セットする deptCode
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * NC204DTO.javaDeptKjを設定
	 * @return deptKj
	 */
	public String getDeptKj() {
		return DeptKj;
	}

	/**
	 * @param deptKj セットする deptKj
	 */
	public void setDeptKj(String deptKj) {
		DeptKj = deptKj;
	}

	/**
	 * NC204DTO.javaDeptKnを設定
	 * @return deptKn
	 */
	public String getDeptKn() {
		return DeptKn;
	}

	/**
	 * @param deptKn セットする deptKn
	 */
	public void setDeptKn(String deptKn) {
		DeptKn = deptKn;
	}

	/**
	 * NC204DTO.javadisplayを設定
	 * @return display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display セットする display
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/**
	 * NC204DTO.javaallCheckを設定
	 * @return allCheck
	 */
	public boolean isAllCheck() {
		return allCheck;
	}

	/**
	 * @param allCheck セットする allCheck
	 */
	public void setAllCheck(boolean allCheck) {
		this.allCheck = allCheck;
	}

	/**
	 * NC204DTO.javasearchInputを設定
	 * @return searchInput
	 */
	public String getSearchInput() {
		return searchInput;
	}

	/**
	 * @param searchInput セットする searchInput
	 */
	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

	/**
	 * NC204DTO.javaselectCntEntity2を設定
	 * @return selectCntEntity2
	 */
	public String getSelectCntEntity2() {
		return selectCntEntity2;
	}

	/**
	 * @param selectCntEntity2 セットする selectCntEntity2
	 */
	public void setSelectCntEntity2(String selectCntEntity2) {
		this.selectCntEntity2 = selectCntEntity2;
	}

	/**
	 * NC204DTO.javainSearchInputを設定
	 * @return inSearchInput
	 */
	public String getInSearchInput() {
		return inSearchInput;
	}

	/**
	 * @param inSearchInput セットする inSearchInput
	 */
	public void setInSearchInput(String inSearchInput) {
		this.inSearchInput = inSearchInput;
	}

	/**
	 * NC204DTO.javacdcCheckedCodesを設定
	 * @return cdcCheckedCodes
	 */
	public String[] getCdcCheckedCodes() {
		return cdcCheckedCodes;
	}

	/**
	 * @param cdcCheckedCodes セットする cdcCheckedCodes
	 */
	public void setCdcCheckedCodes(String[] cdcCheckedCodes) {
		this.cdcCheckedCodes = cdcCheckedCodes;
	}

	/**
	 * NC204DTO.javacallBackを設定
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
	 * NC204DTO.javawinVarNameを設定
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
	 * NC204DTO.javaparamInsNoを設定
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
	 * NC204DTO.javainsAbbrNameを設定
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
	 * NC204DTO.javaCountを設定
	 * @return count
	 */
	public String getCount() {
		return Count;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(String count) {
		Count = count;
	}

	/**
	 * NC204DTO.javacatDeptsComboDataListを設定
	 * @return catDeptsComboDataList
	 */
	public List<CatDeptsComboDataList> getCatDeptsComboDataList() {
		return catDeptsComboDataList;
	}

	/**
	 * @param catDeptsComboDataList セットする catDeptsComboDataList
	 */
	public void setCatDeptsComboDataList(List<CatDeptsComboDataList> catDeptsComboDataList) {
		this.catDeptsComboDataList = catDeptsComboDataList;
	}

	public void setJkrSosInsAbbrNameMap(List<CatDeptsComboDataList> catDeptsComboDataList2) {
		// TODO 自動生成されたメソッド・スタブ

	}




}
