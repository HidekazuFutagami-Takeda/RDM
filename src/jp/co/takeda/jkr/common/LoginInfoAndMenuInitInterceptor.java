/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import jp.co.takeda.jkr.service.CommonControlService;
import jp.co.takeda.rdm.util.AppConstant;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.ExceptionHolder;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * ログインユーザ関連情報取得＆メニューデータ初期化クラス
 * @author 日立　花
 *
 */
public class LoginInfoAndMenuInitInterceptor extends AbstractInterceptor {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    protected static final Logger LOG = LoggerFactory.getLogger(LoginInfoAndMenuInitInterceptor.class);


    /**
     * 共通処理Serviceオブジェクト<br/>
     *   従業員情報取得<br/>
     *   動的メニュー情報取得<br/>
     *   権限チェック<br/>
     *   時間帯チェック<br/>
     *   など
     *
     * @generated
     */
    @javax.inject.Inject
    private CommonControlService commonControlService;

    /**
     * ログインユーザ関連情報取得＆メニューデータ初期化。<br/>
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
        // スタックのインスタンスにExceptionHolderがあるかチェック。
        for (Iterator<?> iterator = invocation.getStack().getRoot().iterator(); iterator.hasNext();) {
            Object obj = iterator.next();
            if (obj instanceof ExceptionHolder) {
                return invocation.invoke();
            }
        }

        //ログインユーザ情報取得
        LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute(BaseInfoHolder.USERINFO_KEY);
        commonControlService.setUserInfo(loginInfo);
        //ユーザ情報管理
        request.getSession().setAttribute(BaseInfoHolder.USERINFO_KEY, loginInfo);
        BaseInfoHolder.setUserInfo(loginInfo);

        return invocation.invoke();

    }
}

