/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * BeanUtilクラス
 * @generated
 */
public class BeanUtil {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(BeanUtil.class);

    static {
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
        ConvertUtils.register(new SqlDateConverter(null), java.util.Date.class);
    }
    
    /**
     * Beanのコピー
     * @param to コピー先Bean
     * @param from コピー元Bean
     * @generated
     */
    public static void copyProperties(Object to, Object from) {
        try {
            BeanUtils.copyProperties(to, from);
        } catch (IllegalAccessException e) {
            log.error("Beanのコピーに失敗しました", e);
        } catch (InvocationTargetException e) {
            log.error("Beanのコピーに失敗しました", e);
        }
    }

}
