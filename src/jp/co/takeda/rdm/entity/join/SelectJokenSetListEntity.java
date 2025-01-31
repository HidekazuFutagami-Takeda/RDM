/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : S_JKR_M_JGI_JOKEN
 * SQLID : selectJokenSetList
 * @generated
 */
public class SelectJokenSetListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_従業員番号 (パラメータ3)
     * @generated
     */
    private Integer inJgiNo;

    /**
     * 条件セット
     * @generated
     */
    private String jokenSetCd;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectJokenSetListEntity() {
        super("s_jkr_m_jgi_joken" , "selectJokenSetList");
    }

    /**
     * 入力_従業員番号の取得
     * @return 入力_従業員番号
     * @generated
     */
    public Integer getInJgiNo() {
        return inJgiNo;
    }

    /**
     * 入力_従業員番号の設定
     * @param inJgiNo 入力_従業員番号
     * @generated
     */
    public void setInJgiNo(Integer inJgiNo) {
        this.inJgiNo = inJgiNo;
    }

    /**
     * 条件セットの取得
     * @return 条件セット
     * @generated
     */
    public String getJokenSetCd() {
        return jokenSetCd;
    }

    /**
     * 条件セットの設定
     * @param jokenSetCd 条件セット
     * @generated
     */
    public void setJokenSetCd(String jokenSetCd) {
        this.jokenSetCd = jokenSetCd;
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
