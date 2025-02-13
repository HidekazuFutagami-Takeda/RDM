/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;


/**
 * ログイン者の権限をチェックする（roleによるアクセス制御機能）ように HttpServletRequestインターフェースを実装したクラス。
 * @generated
 */
public class AuthenticateHttpServletRequest extends HttpServletRequestWrapper {

    /**
     * コンストラクタ
     * 
     * @param req HttpServletRequest
     * @generated
     */
    public AuthenticateHttpServletRequest(HttpServletRequest req) {
        super(req);
    }

    /**
     * ログイン者が指定した権限を保持しているかチェックする。<br>
     * 
     * @param role 権限
     * @return ログイン者が指定した権限を保持しているか(true:保持している。false:保持していない)
     * @see javax.servlet.http.HttpServletRequestWrapper#isUserInRole(java.lang.String)
     * @generated
     */
    public boolean isUserInRole(String role) {
        if (role == null) {
            return false;
        }
        HttpSession session = this.getSession(false);
        if (session == null) {
            return false;
        }
        // スレッドローカルから取得する
        String userRole = BaseInfoHolder.getUserInfo().getRoles();
        String[] userRoles = userRole.split(",");
        if (userRoles.length > 1) {
            for (int i = 0; i < userRoles.length; i++) {
                if (role.equals(userRoles[i])) {
                    return true;
                }
            }
            return false;
        } else {
            // 権限判定（現在のユーザの権限と一致すればtrue）
            return (role.equals(userRole));
        }
    }
}
