/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * 画面遷移時の権限チェッククラス
 * @author 日立　花
 *
 */
public class TransitionAuthInterceptor extends AbstractInterceptor {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    protected static final Logger LOG = LoggerFactory.getLogger(TransitionAuthInterceptor.class);

    /**
     * ログイン済みかチェックする。<br/>
     * 
     * @param actioninvocation ActionInvocation
     * @return 次のインターセプター処理
     * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
     * @generated
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        
        //Action 呼出しの前処理が
        ActionContext ac = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
        
        //この前の処理でエラーが発生したかチェックする
        Exception e = (Exception)request.getAttribute(AuthorizationServiceData.ERROR_TRANSITION);
        if (e != null) {
            request.removeAttribute(AuthorizationServiceData.ERROR_TRANSITION);
            throw e;
        }
        
        return invocation.invoke();
    }
}

