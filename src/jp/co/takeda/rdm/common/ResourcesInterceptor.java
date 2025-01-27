/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.LocalizedTextUtil;

/**
 * リソースファイルの読み込みクラス。
 * 但し、JavaSE1.6以上でないと動作しないので注意すること。
 * @generated
 */
public class ResourcesInterceptor extends AbstractInterceptor {

    /**
     * シリアルバージョンID
     * @generated
     */
    private static final long serialVersionUID = 1815472222893418314L;

    @Inject("struts.custom.i18n.resources")
    protected String resourceKeyName;

    /**
     * struts.xmlで指定したリソースファイルを読み込む。
     * リソースファイルをnative2asciiを用いなくても読み込めるようにする。
     * 但し、JavaSE1.6以上でないと動作しないので注意すること。
     * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
     * @generated
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Field f;
        ConcurrentMap<String, ResourceBundle> bundlesMap = null;
        try {
            f = LocalizedTextUtil.class.getDeclaredField("bundlesMap");
            f.setAccessible(true);
            bundlesMap = (ConcurrentMap<String, ResourceBundle>)f.get(null);
        } catch (SecurityException e) {
            throw new RuntimeException("リソースファイルの読み込みに失敗しました。",e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("リソースファイルの読み込みに失敗しました。",e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("リソースファイルの読み込みに失敗しました。",e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("リソースファイルの読み込みに失敗しました。",e);
        }
        ActionContext ac = invocation.getInvocationContext();
        Locale locale = ac.getLocale();
        String[] resourceKeyNames = getResourceKeyNames();
        if (resourceKeyNames != null) {
            for (String keyName : resourceKeyNames) {
                keyName = keyName.trim();
                String key = createMissesKey(keyName, locale);
                if (!bundlesMap.containsKey(key)) {
                    ResourceBundle bundle = ResourceBundle.getBundle(keyName, ac.getLocale(), Thread.currentThread().getContextClassLoader(),
                            new ResourceBundleControl());
                    bundlesMap.put(key, bundle);
                }
            }
        }
        return invocation.invoke();
    }

    /**
     * Creates a key to used for lookup/storing in the bundle misses cache.
     *
     * @param aBundleName the name of the bundle (usually it's FQN classname).
     * @param locale      the locale.
     * @return the key to use for lookup/storing in the bundle misses cache.
     * @generated
     */
    protected String createMissesKey(String aBundleName, Locale locale) {
        return aBundleName + "_" + locale.toString();
    }

    /**
     * メッセージリソースをカンマ区切りで定義していた場合に、分割してメッセージリソース一覧を返す。
     * @return メッセージリソース一覧
     * @generated
     */
    protected String[] getResourceKeyNames() {
        if (resourceKeyName != null && !"".equals(resourceKeyName)) {
            return resourceKeyName.split(",");
        } else {
            return null;
        }
    }
}
