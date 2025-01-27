/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.entity;

import java.io.Serializable;

import jp.co.takeda.jkr.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * Entityクラス
 * テーブル物理名 : S_RDM_M_JGI_JOKEN
 * テーブル論理名 : 従業員別条件テーブル当月
 * @generated
 */
public class SRdmMJgiJokenEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 従業員番号 (PK)
     * @generated
     */
    private Integer jgiNo;

    /**
     * 条件セット (PK)
     * @generated
     */
    private String jokenSetCd;

    /**
     * コンストラクタ
     * @generated
     */
    public SRdmMJgiJokenEntity() {
        super("s_rdm_m_jgi_joken");
    }

    /**
     * コンストラクタ
     * @param jgiNo 従業員番号
     * @param jokenSetCd 条件セット
     * @generated
     */
    public SRdmMJgiJokenEntity(Integer jgiNo, String jokenSetCd) {
        super("s_rdm_m_jgi_joken");
        this.jgiNo = jgiNo;
        this.jokenSetCd = jokenSetCd;
    }

    /**
     * 従業員番号の取得
     * @return 従業員番号
     * @generated
     */
    public Integer getJgiNo() {
        return this.jgiNo;
    }

    /**
     * 従業員番号の設定
     * @param jgiNo 従業員番号
     * @generated
     */
    public void setJgiNo(Integer jgiNo) {
        this.jgiNo = jgiNo;
    }

    /**
     * 条件セットの取得
     * @return 条件セット
     * @generated
     */
    public String getJokenSetCd() {
        return this.jokenSetCd;
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
