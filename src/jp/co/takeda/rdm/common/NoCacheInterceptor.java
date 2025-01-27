/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * ノーキャッシュをレスポンスに追加する。<br/>
 * @generated
 */
public class NoCacheInterceptor extends MethodFilterInterceptor {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = -850709645115130279L;

    /**
     * ノーキャッシュをレスポンスに付与するか。<br/>
     * true指定時、ノーキャッシュをレスポンスに付与しない（デフォルト：false。ノーキャッシュをレスポンスに付与する）
     * @generated
     */
    protected boolean cancel = false;

    /**
     * ノーキャッシュをレスポンスに付与するか指定する。
     * @param cancel ノーキャッシュをレスポンスに付与するか(true指定時、ノーキャッシュをレスポンスに付与しない)
     * @generated
     */
    public void setCancel(String cancel) {
        if(cancel!=null && !"".equals(cancel) && "TRUE".equalsIgnoreCase(cancel)) {
            this.cancel = true;
        }
    }

    /**
     * ノーキャッシュをレスポンスに付与するかのフラグを取得する。
     * @return ノーキャッシュをレスポンスに付与するか(true指定時、ノーキャッシュをレスポンスに付与しない)
     * @generated
     */
    public boolean isCancel() {
        return cancel;
    }

    /**
     * ノーキャッシュをレスポンスに付与する処理実行。
     * @param actioninvocation ActionInvocation
     * @return 次のインターセプター処理
     * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
     * @generated
     */
    @Override
    protected String doIntercept(ActionInvocation actioninvocation)
            throws Exception {
        if(!isCancel()) {
            ActionContext context=(ActionContext)actioninvocation.getInvocationContext();
            HttpServletResponse response=(HttpServletResponse)context.get(StrutsStatics.HTTP_RESPONSE);
            if(response!=null) {
                response.setHeader("Cache-Control", "no-store, no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", -1);
            }
        }
        return actioninvocation.invoke();
    }

}
