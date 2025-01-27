/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

/**
 * メッセージ管理クラス
 * @generated
 */
@Named
public final class MessageUtil {
    
    /**
     * ログメッセージの格納クラス
     * @generated
     */
    @Inject
    private MessageSource messageSource;

    /**
     * メッセージを取得する
     * @param messageId メッセージID
     * @return メッセージ本文
     * @generated
     */
    public String getMessage(String messageId) {
        return getMessage(messageId, null);
    }

    /**
     * メッセージの置換文字列を置き換えて取得する
     * @param messageId メッセージID
     * @param args 置換する文字列
     * @return メッセージ本文
     * @generated
     */
    public String getMessage(String messageId, String[] args) {
        MessageSourceAccessor accessor = new MessageSourceAccessor(messageSource);
        String message = accessor.getMessage(messageId, args);
        return message;
    }
}

