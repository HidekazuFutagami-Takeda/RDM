/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * ベースEntityクラス
 * @generated
 */
public class BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * テーブル名
     * @generated
     */
    private String tableName;

    /**
     * SQL ID
     * @generated
     */
    private String sqlId;

    /**
     * コンストラクタ
     * @param tableName テーブル名
     * @generated
     */
    public BaseEntity(String tableName) {
        this.tableName = tableName;
    }

    /**
     * コンストラクタ
     * @param tableName テーブル名
     * @param sqlId SQL ID
     * @generated
     */
    public BaseEntity(String tableName, String sqlId) {
        this.tableName = tableName;
        this.sqlId = sqlId;
    }

    /**
     * テーブル名の取得
     * @return テーブル名
     * @generated
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * テーブル名の設定
     * @param tableName テーブル名
     * @generated
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * SQL IDの取得
     * @return SQL ID
     * @generated
     */
    public String getSqlId() {
        return sqlId;
    }

    /**
     * SQL IDの設定
     * @param sqlId SQL ID
     * @generated
     */
    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
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
