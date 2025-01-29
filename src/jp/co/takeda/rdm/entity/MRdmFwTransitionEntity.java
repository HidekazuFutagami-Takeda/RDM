/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import jp.co.takeda.jkr.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_FW_TRANSITION
 * テーブル論理名 : FW画面遷移可能設定
 * @generated
 */
public class MRdmFwTransitionEntity extends BaseEntity implements Serializable {

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
     * 連番 (PK)
     * @generated
     */
    private Integer subNo;

    /**
     * 許可遷移元の画面ID
     * @generated
     */
    private String preScreenId;
    private boolean preScreenIdNullFlag;

    /**
     * 許可遷移元の機能ID
     * @generated
     */
    private String preFunctionId;
    private boolean preFunctionIdNullFlag;

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
    public MRdmFwTransitionEntity() {
        super("m_rdm_fw_transition");
    }

    /**
     * コンストラクタ
     * @param screenId 画面ID
     * @param functionId 機能ID
     * @param subNo 連番
     * @generated
     */
    public MRdmFwTransitionEntity(String screenId, String functionId, Integer subNo) {
        super("m_rdm_fw_transition");
        this.screenId = screenId;
        this.functionId = functionId;
        this.subNo = subNo;
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
     * 連番の取得
     * @return 連番
     * @generated
     */
    public Integer getSubNo() {
        return this.subNo;
    }

    /**
     * 連番の設定
     * @param subNo 連番
     * @generated
     */
    public void setSubNo(Integer subNo) {
        this.subNo = subNo;
    }

    /**
     * 許可遷移元の画面IDの取得
     * @return 許可遷移元の画面ID
     * @generated
     */
    public String getPreScreenId() {
        return this.preScreenId;
    }

    /**
     * 許可遷移元の画面IDの設定
     * @param preScreenId 許可遷移元の画面ID
     * @generated
     */
    public void setPreScreenId(String preScreenId) {
        this.preScreenId = preScreenId;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isPreScreenIdNullFlag() {
        return this.preScreenIdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param preScreenIdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setPreScreenIdNullFlag(boolean preScreenIdNullFlag) {
        this.preScreenIdNullFlag = preScreenIdNullFlag;
    }

    /**
     * 許可遷移元の機能IDの取得
     * @return 許可遷移元の機能ID
     * @generated
     */
    public String getPreFunctionId() {
        return this.preFunctionId;
    }

    /**
     * 許可遷移元の機能IDの設定
     * @param preFunctionId 許可遷移元の機能ID
     * @generated
     */
    public void setPreFunctionId(String preFunctionId) {
        this.preFunctionId = preFunctionId;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isPreFunctionIdNullFlag() {
        return this.preFunctionIdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param preFunctionIdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setPreFunctionIdNullFlag(boolean preFunctionIdNullFlag) {
        this.preFunctionIdNullFlag = preFunctionIdNullFlag;
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
