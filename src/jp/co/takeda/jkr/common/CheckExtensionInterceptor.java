/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import jp.co.takeda.rdm.exception.CheckExtentionException;
/**
 *
 * @generated
 */
public class CheckExtensionInterceptor extends AbstractInterceptor {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @generated
     */
    protected static final Logger LOG = LoggerFactory.getLogger(CheckExtensionInterceptor.class);

    /**
     * @generated
     */
    protected String excludeExtentions;

    /**
     * @generated
     */
    @Inject("struts.custom.include.extension")
    protected String includeExtentions;

    /**
     * URLの直打ち防止処理を実行する。<br/>
     *
     * @param actioninvocation ActionInvocation
     * @return 次のインターセプター処理
     * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
     * @generated
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ac = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
        String requestMethod = ((HttpServletRequest) request).getMethod();
        String currentRequestPath = ((HttpServletRequest) request).getServletPath();
        String pathInfo = ((HttpServletRequest) request).getPathInfo();
        if (pathInfo != null && !"".equals(pathInfo)) {
            currentRequestPath = currentRequestPath + pathInfo;
        }
        // GET時のみ実行
        if ("GET".equals(requestMethod)) {
            if (currentRequestPath != null && !"".equals(currentRequestPath)) {
                // true：アクセス拒否するパスである
                if (checkExcludURLExtention(excludeExtentions, currentRequestPath)) {
                    throw new CheckExtentionException("Not Allow.");

                // true：許可するパスでない
                } else if (!checkIncludURLExtention(includeExtentions, currentRequestPath)) {
                    throw new CheckExtentionException("Not Allow.");
                }
            }
        }
        return invocation.invoke();
    }

    /**
     * アクセス拒否するパスをカンマ区切りで指定する。<br>
     * 正規表現で指定可能。
     *
     * @param excludeExtentions 拒否するパス
     * @param currentRequestPath 現在のパス
     * @return true：アクセス拒否のパス。false：アクセスを許可するパス。
     * @generated
     */
    protected boolean checkExcludURLExtention(String excludeExtentions, String currentRequestPath) {
        boolean returnFlag = false;
        if (excludeExtentions != null && !"".equals(excludeExtentions)) {
            StringTokenizer st = new StringTokenizer(excludeExtentions, ",");
            while (st.hasMoreTokens()) {
                String excludeExtention = st.nextToken().trim();
                if (currentRequestPath.matches(excludeExtention)) {
                    returnFlag = true;
                    break;
                }
            }
        }
        return returnFlag;
    }

    /**
     * アクセス許可するパスをカンマ区切りで指定する。<br>
     * 正規表現で指定可能。
     *
     * @param includeExtentions 許可するパス
     * @param currentRequestPath 現在のパス
     * @return true：アクセス許可のパス。false：アクセスを許可するパスの可能性がある。
     * @generated
     */
    protected boolean checkIncludURLExtention(String includeExtentions, String currentRequestPath) {
        boolean returnFlag = false;
        if (includeExtentions != null && !"".equals(includeExtentions)) {
            StringTokenizer st = new StringTokenizer(includeExtentions, ",");
            while (st.hasMoreTokens()) {
                String includeExtention = st.nextToken().trim();
                if (currentRequestPath.matches(includeExtention)) {
                    returnFlag = true;
                    break;
                }
            }
        } else {
            returnFlag = true;
        }
        return returnFlag;
    }
}

