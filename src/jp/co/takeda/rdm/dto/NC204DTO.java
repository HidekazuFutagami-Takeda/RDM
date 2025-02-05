/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.jkr.common.BaseDTO;

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

    public String getPreScreenId() {
		return preScreenId;
	}

	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

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
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNC204(String screenID){
        this.NC204 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNC204(){
        return NC204;
    }

    /**
     * 検索条件_所属部科名(全角カナ)の取得
     * @return 検索条件_所属部科名(全角カナ)
     * @generated
     */
    public String getKensakuKana() {
        return kensakuKana;
    }

    /**
     * 検索条件_所属部科名(全角カナ)の設定
     * @param kensakuKana 検索条件_所属部科名(全角カナ)
     * @generated
     */
    public void setKensakuKana(String kensakuKana) {
        this.kensakuKana = kensakuKana;
    }
    /**
     * 武田所属部科コードの取得
     * @return  武田所属部科コード
     * @generated
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     *  武田所属部科コードの設定
     * @param kensakuKanj  武田所属部科コード
     * @generated
     */
    public void setDeptCode(String deptCode) {
        this.deptCode= deptCode;
    }
    /**
     * 所属部科名(漢字)の取得
     * @return 所属部科名(漢字)
     * @generated
     */
    public String getDeptKj() {
        return DeptKj;
    }

    /**
     * 所属部科名(漢字)の設定
     * @param kensakuKanj 所属部科名(漢字)
     * @generated
     */
    public void setDeptKj(String DeptKj) {
        this.DeptKj= DeptKj;
    }
    /**
     * 所属部科名(カナ)の取得
     * @return 所属部科名(カナ)
     * @generated
     */
    public String getDeptKn() {
        return DeptKn;
    }

    /**
     * 所属部科名(カナ)の設定
     * @param kensakuKanj 所属部科名(カナ)
     * @generated
     */
    public void setDeptKn(String DeptKn) {
        this.DeptKn= DeptKn;
    }
    /**
     * 検索条件_所属部科名(漢字)の取得
     * @return 検索条件_所属部科名(漢字)
     * @generated
     */
    public String getKensakuKanj() {
        return kensakuKanj;
    }

    /**
     * 検索条件_所属部科名(漢字)の設定
     * @param kensakuKanj 検索条件_所属部科名(漢字)
     * @generated
     */
    public void setKensakuKanj(String kensakuKanj) {
        this.kensakuKanj = kensakuKanj;
    }

    /**
     * 選択済所属部科名の取得
     * @return 選択済所属部科名
     * @generated
     */
    public String getDisplay() {
        return display;
    }

    /**
     * 選択済所属部科名の設定
     * @param display 選択済所属部科名
     * @generated
     */
    public void setDisplay(String display) {
        this.display = display;
    }
    /**
     * カウント用
     */
    public String getCount() {
        return Count;
    }

    /**
     * カウント用
     * @generated
     */
    public void setCount(String Count) {
        this.Count = Count;
    }

    /**
     * 選択済所属部科コードの取得
     * @return 選択済所属部科コード
     * @generated
     */
    public String[] getCdcCheckedCodes() {
        return cdcCheckedCodes;
    }
    /**
     * 全所属部科チェックボックスの取得
     * @return 全所属部科チェックボックス
     * @generated
     */
    public Boolean getAllCheck() {
        return allCheck;
    }
    /**
     * 全所属部科チェックボックスの設定
     * @param cdcCheckedCodes 全所属部科チェックボックス
     * @generated
     */
    public void setAllCheck(Boolean allCheck) {
        this.allCheck = allCheck;
    }
	public String getInSearchInput() {

		return inSearchInput;
	}
    /**
     * 検索文字列の取得
     * @return 検索文字列
     * @generated
     */
    public String getSearchInput() {
        return searchInput;
    }
    /**
     * 選択済所属部科コードの設定
     * @param cdcCheckedCodes 選択済所属部科コード
     * @generated
     */
    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }
    /**
     * 選択済所属部科コードの設定
     * @param cdcCheckedCodes 選択済所属部科コード
     * @generated
     */
    public void setCdcCheckedCodes(String[] cdcCheckedCodes) {
        this.cdcCheckedCodes = cdcCheckedCodes;
    }

    public String getSelectCntEntity2() {
        return selectCntEntity2;
    }

    /**
     * selectCntEntity2の設定
     * @param deptCode 所属部科コード
     * @generated
     */
    public void setSelectCntEntity2(String selectCntEntity2) {
        this.selectCntEntity2 = selectCntEntity2;
    }
    /**
     * 親画面コールバックメソッド名の取得
     * @return 親画面コールバックメソッド名
     * @generated
     */
    public String getCallBack() {
        return callBack;
    }

    /**
     * 親画面コールバックメソッド名の設定
     * @param callBack 親画面コールバックメソッド名
     * @generated
     */
    public void setCallBack(String callBack) {
        this.callBack = callBack;
    }

    /**
     * 親画面名の取得
     * @return 親画面名
     * @generated
     */
    public String getWinVarName() {
        return winVarName;
    }

    /**
     * 親画面名の設定
     * @param winVarName 親画面名
     * @generated
     */
    public void setWinVarName(String winVarName) {
        this.winVarName = winVarName;
    }

    /**
     * 親画面施設固定コードの取得
     * @return 親画面施設固定コード
     * @generated
     */
    public String getParamInsNo() {
        return paramInsNo;
    }

    /**
     * 親画面施設固定コードの設定
     * @param paramInsNo 親画面施設固定コード
     * @generated
     */
    public void setParamInsNo(String paramInsNo) {
        this.paramInsNo = paramInsNo;
    }

    /**
     * 施設略式漢字名の取得
     * @return 施設略式漢字名
     * @generated
     */
    public String getInsAbbrName() {
		return insAbbrName;
	}

    /**
     * 施設略式漢字名の設定
     * @param insAbbrName 施設略式漢字名
     * @generated
     */
	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

    /**
     * 繰返リストの取得
     * @return 繰返リスト
     * @generated
     */
    public List<CatDeptsComboDataList> getCatDeptsComboDataList() {
        return catDeptsComboDataList;
    }

    /**
     * 繰返リストの設定
     * @param catDeptsComboDataList 繰返リスト
     * @generated
     */
    public void setCatDeptsComboDataList(List<CatDeptsComboDataList> catDeptsComboDataList) {
        this.catDeptsComboDataList = catDeptsComboDataList;
    }

    /**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	public void setJkrSosInsAbbrNameMap(List<CatDeptsComboDataList> catDeptsComboDataList2) {
		// TODO 自動生成されたメソッド・スタブ

	}




}
