/*
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_HCP_SHOZOKU_BUKA
 * テーブル論理名 : 医師_所属部科マスタ
 * @generated
 */
public class SRdmDmcMstDeptEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属部科コード (PK)
     * @generated
     */
    private String deptCode;

    private String paramInsNo;

    public String getParamInsNo() {
		return paramInsNo;
	}

	public void setParamInsNo(String paramInsNo) {
		this.paramInsNo = paramInsNo;
	}

	/**
     * 所属部科カナ名
     * @generated
     */
    private String kanaName;
    private boolean kanaNameNullFlag;

    /**
     * 所属部科漢字名
     * @generated
     */
    private String kanjName;
    private boolean kanjNameNullFlag;
    /**　　追加箇所
     * 入力_全所属部科チェックボックス(パラメータ5)
     * @generated
     */
    private boolean inAllCheck;
    /**　　追加箇所
     * 入力_検索文字列(パラメータ6)
     * @generated
     */
    private String inSearchInput;
    /**　　追加箇所
     * 検索文字列(パラメータ6)
     * @generated
     */
    private String searchInput;
    /**
     * 新規登録者
     * @generated
     */
    private Integer isJgiNo;
    private boolean isJgiNoNullFlag;

    /**
     * 最終更新者
     * @generated
     */
    private Integer upJgiNo;
    private boolean upJgiNoNullFlag;

    /**
     * 登録日
     * @generated
     */
    private Date isDate;
    private boolean isDateNullFlag;

    /**
     * 更新日
     * @generated
     */
    private Date upDate;
    private boolean upDateNullFlag;

    /**
     * 更新画面ID
     * @generated
     */
    private String upScrnId;
    private boolean upScrnIdNullFlag;

    /**
     * 更新機能ID
     * @generated
     */
    private String upFuncId;
    private boolean upFuncIdNullFlag;

    /**
     * コンストラクタ
     * @generated
     */
    public SRdmDmcMstDeptEntity() {
        super("m_rdm_hcp_shozoku_buka");
    }

    /**
     * コンストラクタ
     * @param deptCode 所属部科コード
     * @generated
     */
    public SRdmDmcMstDeptEntity(String deptCode) {
        super("m_rdm_hcp_shozoku_buka");
        this.deptCode = deptCode;
    }

    /**
     * 所属部科コードの取得
     * @return 所属部科コード
     * @generated
     */
    public String getDeptCode() {
        return this.deptCode;
    }
    /**
     * 所属部科コードの取得
     * @return 所属部科コード
     * @generated
     */
    public String getSearchInput() {
        return this.searchInput;
    }

    /**
     * 所属部科コードの設定
     * @param deptCode 所属部科コード
     * @generated
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
    /**  追加箇所
     * 入力_全所属部科チェックボックスの設定
     * @param inKanjName 入力_全所属部科チェックボックスの
     * @generated
     */
    public void setInAllCheck(boolean inAllCheck) {
        this.inAllCheck = inAllCheck;
    }
    /**　追加箇所
     * 入力_検索文字列の設定
     * @param inKanjName 入力_検索文字列
     * @generated
     */
    public void setInSearchInput(String inSearchInput) {
        this.inSearchInput = inSearchInput;
    }
    /**　追加箇所
     * 入力_検索文字列の設定
     * @param inKanjName 入力_検索文字列
     * @generated
     */
    public void setsearchInput(String searchInput) {
        this.searchInput = searchInput;
    }
    /**
     * 所属部科カナ名の取得
     * @return 所属部科カナ名
     * @generated
     */
    public String getKanaName() {
        return this.kanaName;
    }

    /**
     * 所属部科カナ名の設定
     * @param kanaName 所属部科カナ名
     * @generated
     */
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKanaNameNullFlag() {
        return this.kanaNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kanaNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKanaNameNullFlag(boolean kanaNameNullFlag) {
        this.kanaNameNullFlag = kanaNameNullFlag;
    }

    /**
     * 所属部科漢字名の取得
     * @return 所属部科漢字名
     * @generated
     */
    public String getKanjName() {
        return this.kanjName;
    }

    /**
     * 所属部科漢字名の設定
     * @param kanjName 所属部科漢字名
     * @generated
     */
    public void setKanjName(String kanjName) {
        this.kanjName = kanjName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKanjNameNullFlag() {
        return this.kanjNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kanjNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKanjNameNullFlag(boolean kanjNameNullFlag) {
        this.kanjNameNullFlag = kanjNameNullFlag;
    }

    /**
     * 新規登録者の取得
     * @return 新規登録者
     * @generated
     */
    public Integer getIsJgiNo() {
        return this.isJgiNo;
    }

    /**
     * 新規登録者の設定
     * @param isJgiNo 新規登録者
     * @generated
     */
    public void setIsJgiNo(Integer isJgiNo) {
        this.isJgiNo = isJgiNo;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isIsJgiNoNullFlag() {
        return this.isJgiNoNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param isJgiNoNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setIsJgiNoNullFlag(boolean isJgiNoNullFlag) {
        this.isJgiNoNullFlag = isJgiNoNullFlag;
    }

    /**
     * 最終更新者の取得
     * @return 最終更新者
     * @generated
     */
    public Integer getUpJgiNo() {
        return this.upJgiNo;
    }

    /**
     * 最終更新者の設定
     * @param upJgiNo 最終更新者
     * @generated
     */
    public void setUpJgiNo(Integer upJgiNo) {
        this.upJgiNo = upJgiNo;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isUpJgiNoNullFlag() {
        return this.upJgiNoNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param upJgiNoNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setUpJgiNoNullFlag(boolean upJgiNoNullFlag) {
        this.upJgiNoNullFlag = upJgiNoNullFlag;
    }

    /**
     * 登録日の取得
     * @return 登録日
     * @generated
     */
    public Date getIsDate() {
        return this.isDate;
    }

    /**
     * 登録日の設定
     * @param isDate 登録日
     * @generated
     */
    public void setIsDate(Date isDate) {
        this.isDate = isDate;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isIsDateNullFlag() {
        return this.isDateNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param isDateNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setIsDateNullFlag(boolean isDateNullFlag) {
        this.isDateNullFlag = isDateNullFlag;
    }

    /**
     * 更新日の取得
     * @return 更新日
     * @generated
     */
    public Date getUpDate() {
        return this.upDate;
    }

    /**
     * 更新日の設定
     * @param upDate 更新日
     * @generated
     */
    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isUpDateNullFlag() {
        return this.upDateNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param upDateNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setUpDateNullFlag(boolean upDateNullFlag) {
        this.upDateNullFlag = upDateNullFlag;
    }

    /**
     * 更新画面IDの取得
     * @return 更新画面ID
     * @generated
     */
    public String getUpScrnId() {
        return this.upScrnId;
    }

    /**
     * 更新画面IDの設定
     * @param upScrnId 更新画面ID
     * @generated
     */
    public void setUpScrnId(String upScrnId) {
        this.upScrnId = upScrnId;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isUpScrnIdNullFlag() {
        return this.upScrnIdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param upScrnIdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setUpScrnIdNullFlag(boolean upScrnIdNullFlag) {
        this.upScrnIdNullFlag = upScrnIdNullFlag;
    }

    /**
     * 更新機能IDの取得
     * @return 更新機能ID
     * @generated
     */
    public String getUpFuncId() {
        return this.upFuncId;
    }

    /**
     * 更新機能IDの設定
     * @param upFuncId 更新機能ID
     * @generated
     */
    public void setUpFuncId(String upFuncId) {
        this.upFuncId = upFuncId;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isUpFuncIdNullFlag() {
        return this.upFuncIdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param upFuncIdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setUpFuncIdNullFlag(boolean upFuncIdNullFlag) {
        this.upFuncIdNullFlag = upFuncIdNullFlag;
    }

    /**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	public void setInSelectKbn(int i) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
