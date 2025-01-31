/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_FW_HELPER_MATRIX
 * テーブル論理名 : FWヘルパー対応表
 * @generated
 */
public class MRdmFwHelperMatrixEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 画面ID (PK)
     * @generated
     */
    private String screenId;

    /**
     * 機能ID (PK)
     * @generated
     */
    private String functionId;

    /**
     * 初期画面フラグ
     * @generated
     */
    private String initialKbn;
    private boolean initialKbnNullFlag;

    /**
     * ポータル外部アプリの区別
     * @generated
     */
    private String typeKbn;
    private boolean typeKbnNullFlag;

    /**
     * ヘルパークラス
     * @generated
     */
    private String helperName;
    private boolean helperNameNullFlag;

    /**
     * 利用権限新旧チェック用
     * @generated
     */
    private String generation;
    private boolean generationNullFlag;

    /**
     * 接続するデータソース
     * @generated
     */
    private String dataSource;
    private boolean dataSourceNullFlag;

    /**
     * コメント
     * @generated
     */
    private String comments;
    private boolean commentsNullFlag;

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
    public MRdmFwHelperMatrixEntity() {
        super("m_rdm_fw_helper_matrix");
    }

    /**
     * コンストラクタ
     * @param screenId 画面ID
     * @param functionId 機能ID
     * @generated
     */
    public MRdmFwHelperMatrixEntity(String screenId, String functionId) {
        super("m_rdm_fw_helper_matrix");
        this.screenId = screenId;
        this.functionId = functionId;
    }

    /**
     * 画面IDの取得
     * @return 画面ID
     * @generated
     */
    public String getScreenId() {
        return this.screenId;
    }

    /**
     * 画面IDの設定
     * @param screenId 画面ID
     * @generated
     */
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    /**
     * 機能IDの取得
     * @return 機能ID
     * @generated
     */
    public String getFunctionId() {
        return this.functionId;
    }

    /**
     * 機能IDの設定
     * @param functionId 機能ID
     * @generated
     */
    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    /**
     * 初期画面フラグの取得
     * @return 初期画面フラグ
     * @generated
     */
    public String getInitialKbn() {
        return this.initialKbn;
    }

    /**
     * 初期画面フラグの設定
     * @param initialKbn 初期画面フラグ
     * @generated
     */
    public void setInitialKbn(String initialKbn) {
        this.initialKbn = initialKbn;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isInitialKbnNullFlag() {
        return this.initialKbnNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param initialKbnNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setInitialKbnNullFlag(boolean initialKbnNullFlag) {
        this.initialKbnNullFlag = initialKbnNullFlag;
    }

    /**
     * ポータル外部アプリの区別の取得
     * @return ポータル外部アプリの区別
     * @generated
     */
    public String getTypeKbn() {
        return this.typeKbn;
    }

    /**
     * ポータル外部アプリの区別の設定
     * @param typeKbn ポータル外部アプリの区別
     * @generated
     */
    public void setTypeKbn(String typeKbn) {
        this.typeKbn = typeKbn;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isTypeKbnNullFlag() {
        return this.typeKbnNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param typeKbnNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setTypeKbnNullFlag(boolean typeKbnNullFlag) {
        this.typeKbnNullFlag = typeKbnNullFlag;
    }

    /**
     * ヘルパークラスの取得
     * @return ヘルパークラス
     * @generated
     */
    public String getHelperName() {
        return this.helperName;
    }

    /**
     * ヘルパークラスの設定
     * @param helperName ヘルパークラス
     * @generated
     */
    public void setHelperName(String helperName) {
        this.helperName = helperName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isHelperNameNullFlag() {
        return this.helperNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param helperNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setHelperNameNullFlag(boolean helperNameNullFlag) {
        this.helperNameNullFlag = helperNameNullFlag;
    }

    /**
     * 利用権限新旧チェック用の取得
     * @return 利用権限新旧チェック用
     * @generated
     */
    public String getGeneration() {
        return this.generation;
    }

    /**
     * 利用権限新旧チェック用の設定
     * @param generation 利用権限新旧チェック用
     * @generated
     */
    public void setGeneration(String generation) {
        this.generation = generation;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isGenerationNullFlag() {
        return this.generationNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param generationNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setGenerationNullFlag(boolean generationNullFlag) {
        this.generationNullFlag = generationNullFlag;
    }

    /**
     * 接続するデータソースの取得
     * @return 接続するデータソース
     * @generated
     */
    public String getDataSource() {
        return this.dataSource;
    }

    /**
     * 接続するデータソースの設定
     * @param dataSource 接続するデータソース
     * @generated
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isDataSourceNullFlag() {
        return this.dataSourceNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param dataSourceNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setDataSourceNullFlag(boolean dataSourceNullFlag) {
        this.dataSourceNullFlag = dataSourceNullFlag;
    }

    /**
     * コメントの取得
     * @return コメント
     * @generated
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * コメントの設定
     * @param comments コメント
     * @generated
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isCommentsNullFlag() {
        return this.commentsNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param commentsNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setCommentsNullFlag(boolean commentsNullFlag) {
        this.commentsNullFlag = commentsNullFlag;
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
}
