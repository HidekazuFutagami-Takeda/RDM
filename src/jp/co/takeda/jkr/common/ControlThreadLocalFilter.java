/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * ユーザ情報をThreadLocalに設定するクラス。<br>
 * @generated
 */
public class ControlThreadLocalFilter implements Filter {

    /**
     * ServletContext
     * @generated
     */
    private ServletContext servletContext = null;
    
    /**
     * ユーザ情報をThreadLocalに設定する。<br>
     * @param request ServletRequest
     * @param response ServletResponse
     * @param filterChain FilterChain
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     * @generated
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        // Sessionの取得
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session != null) {
            // Sessionに保持しているユーザ情報を取得する
            UserInfo user = (UserInfo) session.getAttribute(BaseInfoHolder.USERINFO_KEY);
            BaseInfoHolder.setUserInfo(user);
        }

        try {
            // 後続の処理実行
            filterChain.doFilter(request, response);
        } finally {
            BaseInfoHolder.clearUserInfo();
        }
    }

    /**
     * 初期処理。<br>
     * ServletContextを属性に設定する。
     * 
     * @param filterConfig FilterConfig
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     * @generated
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
    }

    /**
     * 終了処理。<br>
     * 
     * @see javax.servlet.Filter#destroy()
     * @generated
     */
    public void destroy() {
        servletContext = null;
    }
}
