/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * リソースファイルの読み込みクラス。
 * 但し、JavaSE1.6以上でないと動作しないので注意すること。
 * @generated
 */
public class ResourceBundleControl extends ResourceBundle.Control {

    /**
     * javaSE6の実装の変更。文字コードを指定して読み込めるように修正。
     * @param baseName
     *        the base bundle name of the resource bundle, a fully
     *        qualified class name
     * @param locale
     *        the locale for which the resource bundle should be
     *        instantiated
     * @param format
     *        the resource bundle format to be loaded
     * @param loader
     *        the <code>ClassLoader</code> to use to load the bundle
     * @param reload
     *        the flag to indicate bundle reloading; <code>true</code>
     *        if reloading an expired resource bundle,
     *        <code>false</code> otherwise
     * @return the resource bundle instance,
     *        or <code>null</code> if none could be found.
     * @exception NullPointerException
     *        if <code>bundleName</code>, <code>locale</code>,
     *        <code>format</code>, or <code>loader</code> is
     *        <code>null</code>, or if <code>null</code> is returned by
     *        {@link #toBundleName(String, Locale) toBundleName}
     * @exception IllegalArgumentException
     *        if <code>format</code> is unknown, or if the resource
     *        found for the given parameters contains malformed data.
     * @exception ClassCastException
     *        if the loaded class cannot be cast to <code>ResourceBundle</code>
     * @exception IllegalAccessException
     *        if the class or its nullary constructor is not
     *        accessible.
     * @exception InstantiationException
     *        if the instantiation of a class fails for some other
     *        reason.
     * @exception ExceptionInInitializerError
     *        if the initialization provoked by this method fails.
     * @exception SecurityException
     *        If a security manager is present and creation of new
     *        instances is denied. See {@link Class#newInstance()}
     *        for details.
     * @exception IOException
     *        if an error occurred when reading resources using
     *        any I/O operations
     * @see java.util.ResourceBundle.Control#newBundle(java.lang.String, java.util.Locale, java.lang.String, java.lang.ClassLoader, boolean)
     * @generated
     */
    public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
        throws IllegalAccessException, InstantiationException, IOException {
        String bundleName = toBundleName(baseName, locale);
        ResourceBundle bundle = null;
        if (format.equals("java.class")) {
            try {
                Class<? extends ResourceBundle> bundleClass
                = (Class<? extends ResourceBundle>)loader.loadClass(bundleName);

                // If the class isn't a ResourceBundle subclass, throw a
                // ClassCastException.
                if (ResourceBundle.class.isAssignableFrom(bundleClass)) {
                    bundle = bundleClass.newInstance();
                } else {
                    throw new ClassCastException(bundleClass.getName()
                        + " cannot be cast to ResourceBundle");
                }
            } catch (ClassNotFoundException e) {
            }
        } else if (format.equals("java.properties")) {
            final String resourceName = toResourceName(bundleName, "properties");
            final ClassLoader classLoader = loader;
            final boolean reloadFlag = reload;
            InputStream stream = null;
            try {
                stream = AccessController.doPrivileged(
                    new PrivilegedExceptionAction<InputStream>() {
                        public InputStream run() throws IOException {
                            InputStream is = null;
                            if (reloadFlag) {
                                URL url = classLoader.getResource(resourceName);
                                if (url != null) {
                                    URLConnection connection = url.openConnection();
                                    if (connection != null) {
                                        // Disable caches to get fresh data for
                                        // reloading.
                                        connection.setUseCaches(false);
                                        is = connection.getInputStream();
                                    }
                                }
                            } else {
                                is = classLoader.getResourceAsStream(resourceName);
                            }
                            return is;
                        }
                    });
            } catch (PrivilegedActionException e) {
                throw (IOException) e.getException();
            }
            if (stream != null) {
                try {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(stream, "UTF-8"));
                    bundle = new PropertyResourceBundle(br);
                    br.close();
                } finally {
                    stream.close();
                }
            }
        } else {
            throw new IllegalArgumentException("unknown format: " + format);
        }
        return bundle;
    }
}
