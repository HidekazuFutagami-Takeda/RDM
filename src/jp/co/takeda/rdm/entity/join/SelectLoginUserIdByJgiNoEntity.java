/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.jkr.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : S_JKR_M_JGI_MST
 * SQLID : selectLoginUserIdByJgiNo
 * @generated
 */
public class SelectLoginUserIdByJgiNoEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 従業員番号 (パラメータ1)
     * @generated
     */
    private int inJgiNo;

    /**
     * ユーザID
     * @generated
     */
    private String userId;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectLoginUserIdByJgiNoEntity() {
        super("s_jkr_m_jgi_mst" , "selectLoginUserIdByJgiNo");
    }

    /**
     * 従業員番号の取得
     * @return 従業員番号
     * @generated
     */
    public int getInJgiNo() {
        return inJgiNo;
    }

    /**
     * 従業員番号の設定
     * @param inJgiNo 従業員番号
     * @generated
     */
    public void setInJgiNo(int inJgiNo) {
        this.inJgiNo = inJgiNo;
    }

    /**
     * ユーザIDの取得
     * @return ユーザID
     * @generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDの設定
     * @param userId ユーザID
     * @generated
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
