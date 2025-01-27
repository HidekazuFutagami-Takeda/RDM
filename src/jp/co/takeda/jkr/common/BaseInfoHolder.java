/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import java.io.Serializable;


/**
 * ThreadLocalへの値設定を管理するクラス。<BR>
 * @generated
 */
public class BaseInfoHolder implements Serializable {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * ユーザ情報格納場所
     * @generated
     */
    private static final ThreadLocal<UserInfo> USERINFO = new ThreadLocal<UserInfo>();
    
    /**
     * ユーザ情報格納キー名(Session)
     * @generated
     */
    public static final String USERINFO_KEY = "UserInfoKey";

    /**
     * ThreadLocalへユーザ情報を設定する。<BR>
     * 
     * @param userInfo ユーザ情報
     * @generated
     */
    public static void setUserInfo(UserInfo userInfo) {
        USERINFO.set(userInfo);
    }

    /**
     * ThreadLocalからユーザ情報を取得する。<BR>
     * 
     * @return ユーザ情報
     * @generated
     */
    public static UserInfo getUserInfo() {
        return (UserInfo) USERINFO.get();
    }

    /**
     * ThreadLocalからユーザ情報をクリアする。<BR>
     * @generated
     */
    public static void clearUserInfo() {
        USERINFO.remove();
    }
}
