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
 * テーブル論理名 : 所属部科マスタ
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
	 * SRdmDmcMstDeptEntity.javadeptCodeを設定
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
	 * SRdmDmcMstDeptEntity.javakanaNameを設定
	 * @return kanaName
	 */
	public String getKanaName() {
		return kanaName;
	}

	/**
	 * @param kanaName セットする kanaName
	 */
	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}

	/**
	 * SRdmDmcMstDeptEntity.javakanaNameNullFlagを設定
	 * @return kanaNameNullFlag
	 */
	public boolean isKanaNameNullFlag() {
		return kanaNameNullFlag;
	}

	/**
	 * @param kanaNameNullFlag セットする kanaNameNullFlag
	 */
	public void setKanaNameNullFlag(boolean kanaNameNullFlag) {
		this.kanaNameNullFlag = kanaNameNullFlag;
	}

	/**
	 * SRdmDmcMstDeptEntity.javakanjNameを設定
	 * @return kanjName
	 */
	public String getKanjName() {
		return kanjName;
	}

	/**
	 * @param kanjName セットする kanjName
	 */
	public void setKanjName(String kanjName) {
		this.kanjName = kanjName;
	}

	/**
	 * SRdmDmcMstDeptEntity.javakanjNameNullFlagを設定
	 * @return kanjNameNullFlag
	 */
	public boolean isKanjNameNullFlag() {
		return kanjNameNullFlag;
	}

	/**
	 * @param kanjNameNullFlag セットする kanjNameNullFlag
	 */
	public void setKanjNameNullFlag(boolean kanjNameNullFlag) {
		this.kanjNameNullFlag = kanjNameNullFlag;
	}

	/**
	 * SRdmDmcMstDeptEntity.javainAllCheckを設定
	 * @return inAllCheck
	 */
	public boolean isInAllCheck() {
		return inAllCheck;
	}

	/**
	 * @param inAllCheck セットする inAllCheck
	 */
	public void setInAllCheck(boolean inAllCheck) {
		this.inAllCheck = inAllCheck;
	}

	/**
	 * SRdmDmcMstDeptEntity.javainSearchInputを設定
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
	 * SRdmDmcMstDeptEntity.javasearchInputを設定
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
	 * SRdmDmcMstDeptEntity.javaisJgiNoを設定
	 * @return isJgiNo
	 */
	public Integer getIsJgiNo() {
		return isJgiNo;
	}

	/**
	 * @param isJgiNo セットする isJgiNo
	 */
	public void setIsJgiNo(Integer isJgiNo) {
		this.isJgiNo = isJgiNo;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaisJgiNoNullFlagを設定
	 * @return isJgiNoNullFlag
	 */
	public boolean isJgiNoNullFlag() {
		return isJgiNoNullFlag;
	}

	/**
	 * @param isJgiNoNullFlag セットする isJgiNoNullFlag
	 */
	public void setJgiNoNullFlag(boolean isJgiNoNullFlag) {
		this.isJgiNoNullFlag = isJgiNoNullFlag;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaupJgiNoを設定
	 * @return upJgiNo
	 */
	public Integer getUpJgiNo() {
		return upJgiNo;
	}

	/**
	 * @param upJgiNo セットする upJgiNo
	 */
	public void setUpJgiNo(Integer upJgiNo) {
		this.upJgiNo = upJgiNo;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaupJgiNoNullFlagを設定
	 * @return upJgiNoNullFlag
	 */
	public boolean isUpJgiNoNullFlag() {
		return upJgiNoNullFlag;
	}

	/**
	 * @param upJgiNoNullFlag セットする upJgiNoNullFlag
	 */
	public void setUpJgiNoNullFlag(boolean upJgiNoNullFlag) {
		this.upJgiNoNullFlag = upJgiNoNullFlag;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaisDateを設定
	 * @return isDate
	 */
	public Date getIsDate() {
		return isDate;
	}

	/**
	 * @param isDate セットする isDate
	 */
	public void setIsDate(Date isDate) {
		this.isDate = isDate;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaisDateNullFlagを設定
	 * @return isDateNullFlag
	 */
	public boolean isDateNullFlag() {
		return isDateNullFlag;
	}

	/**
	 * @param isDateNullFlag セットする isDateNullFlag
	 */
	public void setDateNullFlag(boolean isDateNullFlag) {
		this.isDateNullFlag = isDateNullFlag;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaupDateを設定
	 * @return upDate
	 */
	public Date getUpDate() {
		return upDate;
	}

	/**
	 * @param upDate セットする upDate
	 */
	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaupDateNullFlagを設定
	 * @return upDateNullFlag
	 */
	public boolean isUpDateNullFlag() {
		return upDateNullFlag;
	}

	/**
	 * @param upDateNullFlag セットする upDateNullFlag
	 */
	public void setUpDateNullFlag(boolean upDateNullFlag) {
		this.upDateNullFlag = upDateNullFlag;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaupScrnIdを設定
	 * @return upScrnId
	 */
	public String getUpScrnId() {
		return upScrnId;
	}

	/**
	 * @param upScrnId セットする upScrnId
	 */
	public void setUpScrnId(String upScrnId) {
		this.upScrnId = upScrnId;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaupScrnIdNullFlagを設定
	 * @return upScrnIdNullFlag
	 */
	public boolean isUpScrnIdNullFlag() {
		return upScrnIdNullFlag;
	}

	/**
	 * @param upScrnIdNullFlag セットする upScrnIdNullFlag
	 */
	public void setUpScrnIdNullFlag(boolean upScrnIdNullFlag) {
		this.upScrnIdNullFlag = upScrnIdNullFlag;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaupFuncIdを設定
	 * @return upFuncId
	 */
	public String getUpFuncId() {
		return upFuncId;
	}

	/**
	 * @param upFuncId セットする upFuncId
	 */
	public void setUpFuncId(String upFuncId) {
		this.upFuncId = upFuncId;
	}

	/**
	 * SRdmDmcMstDeptEntity.javaupFuncIdNullFlagを設定
	 * @return upFuncIdNullFlag
	 */
	public boolean isUpFuncIdNullFlag() {
		return upFuncIdNullFlag;
	}

	/**
	 * @param upFuncIdNullFlag セットする upFuncIdNullFlag
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
