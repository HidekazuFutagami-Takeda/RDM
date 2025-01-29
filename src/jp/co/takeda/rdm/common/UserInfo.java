/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * ユーザ情報クラス
 * @generated
 */
public class UserInfo implements Serializable {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = -7774149326751366209L;

    /**
     * ユーザーID
     * @generated
     */
    private String userId;

    /**
     * ユーザー名
     * @generated
     */
    private String userName;

    /**
     * 権限
     * @generated
     */
    private String roles;

    /**
     * ユーザーIDの取得
     * @return ユーザーID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザーIDの設定
     * @param userId ユーザーID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザー名の取得
     * @return ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名の設定
     * @param userName ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 権限の取得
     * @return 権限
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 権限の設定
     * @param roles 権限
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    /**
     * このユーザー情報の値を返す
     * @return ユーザー情報の値
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
