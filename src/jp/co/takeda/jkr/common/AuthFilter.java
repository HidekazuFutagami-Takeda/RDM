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
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 権限情報を追加したAuthenticateHttpServletRequestを生成するクラス。<br>
 * @generated
 */
public class AuthFilter implements Filter {

    /**
     * 初期処理。今回は処理なし。<br>
     * 
     * @param config FilterConfig
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     * @generated
     */
    public void init(FilterConfig config) throws ServletException {
        // 処理なし
    }

    /**
     * 終了処理。今回は処理なし。<br>
     * 
     * @see javax.servlet.Filter#destroy()
     * @generated
     */
    public void destroy() {
        // 処理なし
    }

    /**
     * AuthenticateHttpServletRequestを生成し、リクエスト情報をラッピングさせる。<br>
     * 
     * @param req ServletRequest
     * @param res ServletResponse
     * @param chain FilterChain
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     * @generated
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new AuthenticateHttpServletRequest((HttpServletRequest) req), res);
    }
}
