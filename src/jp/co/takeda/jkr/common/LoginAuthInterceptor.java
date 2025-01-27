/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.ExceptionHolder;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import jp.co.takeda.jkr.exception.LoginAuthException;

public class LoginAuthInterceptor extends AbstractInterceptor {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    protected static final Logger LOG = LoggerFactory.getLogger(LoginAuthInterceptor.class);

    /**
     * ユーザ情報格納キー名(Session)
     * @generated
     */
    public static final String USERINFO_KEY = "UserInfoKey";

    protected String excludePath;

    /**
     * ログイン済みかチェックする。<br/>
     * 
     * @param actioninvocation ActionInvocation
     * @return 次のインターセプター処理
     * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
     * @generated
     */
    @SuppressWarnings("rawtypes")
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ac = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
        // スタックのインスタンスにExceptionHolderがあるかチェック。
        for (Iterator iterator = invocation.getStack().getRoot().iterator(); iterator.hasNext();) {
            Object obj = iterator.next();
            if (obj instanceof ExceptionHolder) {
                return invocation.invoke();
            }
        }
        // 現在のクライアントからの要求パス
        String currentRequestPath = ((HttpServletRequest) request).getServletPath();
        String pathInfo = ((HttpServletRequest) request).getPathInfo();
        if (pathInfo != null && !"".equals(pathInfo)) {
            currentRequestPath = currentRequestPath + pathInfo;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("currentRequestPath " + currentRequestPath, new String[0]);
        }
        // true:チェックOK
        boolean checkFlag = false;
        if (currentRequestPath != null && !"".equals(currentRequestPath)) {
            // チェック対象のパスの場合
            if (!checkExcludePath(excludePath, currentRequestPath)) {
                HttpSession session = ((HttpServletRequest) request).getSession(false);
                if (session == null) {
                    throw new LoginAuthException("not login.");
                }
                // ユーザ情報の取得
                Object userObj = session.getAttribute(USERINFO_KEY);
                // ユーザ情報存在時、既にログインしていることになる。
                if (userObj != null) {
                    checkFlag = true;
                // 未ログイン時。
                } else {
                    throw new LoginAuthException("not login.");
                }
            // チェック対象外のパスの場合
            } else {
                checkFlag = true;
            }
        }
        // ログイン認証チェックエラー時に遷移する
        if (!checkFlag) {
            throw new LoginAuthException("not login.");
        }
        return invocation.invoke();
    }

    /**
     * チェックしないパスかチェックする。<br>
     * 
     * @param excludePaths チェックしないパス
     * @param currentRequestPath 現在のパス
     * @return true：チェックしないパス。false：チェックするパス。
     * @generated
     */
    protected boolean checkExcludePath(String excludePaths, String currentRequestPath) {
        boolean returnFlag = false;
        if (excludePaths != null && !"".equals(excludePaths)) {
            StringTokenizer st = new StringTokenizer(excludePaths, ",");
            while (st.hasMoreTokens()) {
                String excludePat = st.nextToken().trim();
                if (currentRequestPath.matches(excludePat)) {
                    returnFlag = true;
                    break;
                }
            }
        }
        return returnFlag;
    }
}

