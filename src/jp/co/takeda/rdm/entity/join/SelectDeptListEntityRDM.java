/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.jkr.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : S_JKR_DMC_MST_DEPT
 * SQLID : selectDeptList
 * @generated
 */
public class SelectDeptListEntityRDM extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    private String preScreenId;

    public String getPreScreenId() {
		return preScreenId;
	}

	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}


    /**
     * 入力_SELECT区分 (パラメータ1)
     * @generated
     */
    private Integer inSelectKbn;

    /**
     * 入力_施設固定コード (パラメータ2)_rdm流用
     * @generated
     */
    private String inInsNo;
    /**
     * 施設固定コード (パラメータ2)_rdm流用
     * @generated
     */
    private String insNo;
    /**
     * 入力_セッションID
     * @generated
     */
    private String inSeshonId;
    /**
     * 入力_スクリーンID
     * @generated
     */
    private String screenId;
    /**
     * 入力_所属部科名カナ (パラメータ3)
     * @generated
     */
    private String inKanaName;
    /**
     * 所属部科名カナ
     * @generated
     */
    private String kanaName;
    /**
     * 元 KanaName
     * 入力_所属部科名カナ (パラメータ3)
     * @generated
     */
    private String inDeptKn;

    /**
     * KanjName
     * 入力_所属部科名漢字 (パラメータ4)
     * @generated
     */
    private String inDeptKj;
    /**
     * 入力_全所属部科チェックボックス(パラメータ5)
     * @generated
     */
    private boolean inAllCheck;
    /**
     * 入力_全所属部科チェックボックス(パラメータ5)
     * @generated
     */
    private boolean allCheck;
    /**
     * 入力_検索文字列(パラメータ6)
     * @generated
     */
    private String inSearchInput;
    /**
     * 入力_検索文字列(パラメータ6)
     * @generated
     */
    private String searchInput;

    /**
     * 所属部科コード_rdm流用
     * @generated
     */
    private String deptCode;
    /**
     * 所属部科名カナ
     * @generated
     */
    private String DeptKn;

    /**
     * 所属部科名漢字
     * @generated
     */
    private String DeptKj;
    /**
     * 所属部科名漢字_rdm
     * @generated
     */
   // private String deptKj;

    /**
     * レコード件数
     * @generated
     */
    private Integer recCnt;

	public Object paramEntity2;

	 private String selectCntEntity2;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectDeptListEntityRDM() {
        super("m_rdm_hcp_shozoku_buka" , "selectDeptList");
    }
    public SelectDeptListEntityRDM(String inSelectKbn,String searchInput) {
        super("m_rdm_hcp_shozoku_buka" , "selectDeptListCount");
    }
    public SelectDeptListEntityRDM(String searchInput) {
        super("m_rdm_hcp_shozoku_buka" , "kanziHenkan");
    }

    /**
     * 入力_SELECT区分の取得
     * @return 入力_SELECT区分
     * @generated
     */
    public Integer getInSelectKbn() {
        return inSelectKbn;
    }

    /**
     * 入力_SELECT区分の設定
     * @param inSelectKbn 入力_SELECT区分
     * @generated
     */
    public void setInSelectKbn(Integer inSelectKbn) {
        this.inSelectKbn = inSelectKbn;
    }
    /**
     * 入力_スクリーンIDの取得
     * @return 入力_スクリーンID
     * @generated
     */
    public String getScreenId() {
        return screenId;
    }
    /**
     * 入力_スクリーンIDの設定
     * @param スクリーンID
     * @generated
     */
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }
    /**
     * 入力_施設固定コードの取得
     * @return 入力_施設固定コード_rdm流用
     * @generated
     */
    public String getInInsNo() {
        return inInsNo;
    }
    /**
     * 施設固定コードの取得
     * @return 施設固定コード_rdm流用
     * @generated
     */
    public String getInsNo() {
        return insNo;
    }

    /**
     * 入力_施設固定コードの設定
     * @param inInsNo 入力_施設固定コード_rdm流用
     * @generated
     */
    public void setInInsNo(String inInsNo) {
        this.inInsNo = inInsNo;
    }
    /**
     * 施設固定コードの設定
     * @param inInsNo 施設固定コード_rdm流用
     * @generated
     */
    public void setInsNo(String insNo) {
        this.insNo = insNo;
    }
    /**
     * 入力_セッションIDの取得
     * @return 入力_セッションID
     * @generated
     */
    public String getInSeshonId() {
        return inSeshonId;
    }
    /**
     * 入力_セッションIDの設定
     * @param セッションID
     * @generated
     */
    public void setInSeshonId(String inSeshonId) {
        this.inSeshonId = inSeshonId;
    }

    /**
     * 入力_所属部科名カナの取得
     * @return 入力_所属部科名カナ
     * @generated
     */
    public String getInDeptKn() {
        return inDeptKn;
    }
    /**
     * 入力_所属部科名カナの取得
     * @return 入力_所属部科名カナ
     * @generated
     */
    public String getInSearchInput() {
        return inSearchInput;
    }
    /**
     * 入力_所属部科名カナの取得
     * @return 入力_所属部科名カナ
     * @generated
     */
    public String getSearchInput() {
        return searchInput;
    }

    /**
     * 入力_所属部科名カナの設定
     * @param inDeptKn 入力_所属部科名カナ
     * @generated
     */
    public void setInDeptKn(String inDeptKn) {
        this.inDeptKn = inDeptKn;
    }

    /**
     * 入力_所属部科名漢字の取得
     * @return 入力_所属部科名漢字
     * @generated
     */
    public String getInDeptKj() {
        return inDeptKj;
    }

    /**
     * 入力_所属部科名漢字の設定
     * @param inDeptKj 入力_所属部科名漢字
     * @generated
     */
    public void setInDeptKj(String inDeptKj) {
        this.inDeptKj = inDeptKj;
    }
    /**
     * 入力_全所属部科チェックボックスの設定
     * @param inDeptKj 入力_全所属部科チェックボックスの
     * @generated
     */
    public void setInAllCheck(boolean inAllCheck) {
       this.inAllCheck = inAllCheck;
   }

	public void setAllCheck(Boolean allCheck) {
		this.allCheck = allCheck;
	}
    /**
     * 入力_検索文字列の設定
     * @param inDeptKj 入力_検索文字列
     * @generated
     */
    public void setInSearchInput(String inSearchInput) {
        this.inSearchInput = inSearchInput;
    }
    /**
     * 検索文字列の設定
     * @param inDeptKj 入力_検索文字列
     * @generated
     */
    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
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
     * 所属部科コードの取得
     * @return 所属部科コード
     * @generated
     */
    public String getDeptCode() {
        return deptCode;
    }
    /**
     * 入力_全所属部科チェックボックスの設定
     * @param inDeptKj 入力_全所属部科チェックボックスの
     * @generated
     */
    public Boolean getInAllCheck() {
        return inAllCheck;
    }

    /**
     * 所属部科コードの設定
     * @param deptCode 所属部科コード
     * @generated
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 所属部科名カナの取得
     * @return 所属部科名カナ
     * @generated
     */
    public String getDeptKn() {
        return DeptKn;
    }

    /**
     * 所属部科名カナの設定
     * @param DeptKn 所属部科名カナ
     * @generated
     */
    public void setDeptKn(String DeptKn) {
        this.DeptKn = DeptKn;
    }

    /**
     * 所属部科名漢字の取得
     * @return 所属部科名漢字
     * @generated
     */
    public String getDeptKj() {
        return DeptKj;
    }

    /**
     * 所属部科名漢字の設定
     * @param DeptKj 所属部科名漢字
     * @generated
     */
    public void setDeptKj(String DeptKj) {
        this.DeptKj = DeptKj;
    }
    /**
     * 所属部科名漢字の取得
     * @return 所属部科名漢字_rdm
     * @generated
     */
 //   public String getdeptKj() {
   //     return deptKj;
    //}

    /**
     * 所属部科名漢字の設定
     * @param DeptKj 所属部科名漢字_rdm
     * @generated
     */
    //public void setdeptKj(String deptKj) {
     //   this.deptKj = deptKj;
   // }

    /**
     * レコード件数の取得
     * @return レコード件数
     * @generated
     */
    public Integer getRecCnt() {
        return recCnt;
    }

    /**
     * レコード件数の設定
     * @param recCnt レコード件数
     * @generated
     */
    public void setRecCnt(Integer recCnt) {
        this.recCnt = recCnt;
    }

    /**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
