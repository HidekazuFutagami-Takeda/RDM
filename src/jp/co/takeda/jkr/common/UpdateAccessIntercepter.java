/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.takeda.jkr.exception.DataExclusiveException;
import jp.co.takeda.jkr.exception.UpdateAccessException;

/**
 * DAO呼び出し前に、select for update文を実行し、更新系処理（更新、削除）が可能か
 * 判断するクラス。更新日付がDAO実行時に指定した引数のDTOとselect for update文実行結果と
 * 同じであるかチェックする。同じであれば、DAOを呼び出す。異なる場合、例外(RuntimeException)を返す。<br>
 * SelectForUpdateのSQLを実行するDAOのメソッド名は、アプリケーション全体で同一である必要がある。
 * また、DAOの引数は、１つのDTO（引数の1番目）で、且つ、DTOが保持する更新日付の属性名は、 アプリケーション全体で同一である必要がある。<br>
 * select for update文の実行結果の更新日付を保持するEntityの属性名は、
 * アプリケーション全体で同一である必要がある（DTOと合わせる）。<br>
 * 以下に本クラスの指定方法を示す。<br>
 * SpringFrameworkの定義ファイルに以下のように指定する。（以下はサンプル）<br>
 * 
 * <pre>
 * &lt;bean id="updateInterceptor" class="jp.co.takeda.jkr.common.UpdateAccessIntercepter"&gt;
 *   &lt;property name="selectForUpdateMethodName" value="SelectForUpdateを行うDAOのメソッドの名前"/&gt;
 *   &lt;property name="updateDateGetterName" value="DTO,Entityクラスから更新日付を取得するメソッドの名前"/&gt;
 * &lt;/bean&gt;
 * </pre>
 * 
 * <br>
 * 本クラスを適用するDAOクラスを指定する。<br>
 * 
 * <pre>
 * &lt;aop:advisor pointcut="execution(* jp.co.XXXX.dao..*.update*(..))"  advice-ref="updateInterceptor"/&gt;
 * &lt;aop:advisor pointcut="execution(* jp.co.XXXX.dao..*.delete*(..))"  advice-ref="updateInterceptor"/&gt;
 * </pre>
 * 
 * <br>
 * @generated
 */
public class UpdateAccessIntercepter implements MethodInterceptor {

    /**
     * ロガー
     * @generated
     */
    protected final Log logger = LogFactory.getLog(this.getClass());
    
    /**
     * SelectForUpdateのSQLを実行するDAOのメソッド名(applicationContextで設定する。）
     * @generated
     */
    private String selectForUpdateMethodName;
    
    /**
     * 更新日付を取得する際のメソッド名(applicationContextで設定する。）
     * @generated
     */
    private String updateDateGetterName;

    /**
     * SelectForUpdateのSQLを実行するDAOのメソッド名を取得する (値は、applicationContextで設定する。）
     * 
     * @return DAOでSelectForUpdateのSQLを実行するメソッド名
     * @generated
     */
    public String getSelectForUpdateMethodName() {
        return selectForUpdateMethodName;
    }

    /**
     * SelectForUpdateのSQLを実行するDAOのメソッド名を格納する （値は、applicationContextで設定する。）
     * 
     * @param selectForUpdateMethodName SelectForUpdateのSQLを実行するDAOのメソッド名
     * @generated
     */
    public void setSelectForUpdateMethodName(String selectForUpdateMethodName) {
        this.selectForUpdateMethodName = selectForUpdateMethodName;
    }

    /**
     * 更新日付を取得する際のメソッド名を取得する (値は、applicationContextで設定する。）
     * 
     * @return 更新日付を取得する際のメソッド名
     * @generated
     */
    public String getUpdateDateGetterName() {
        return updateDateGetterName;
    }

    /**
     * 更新日付を取得する際のメソッド名を格納する （値は、applicationContextで設定する。）
     * 
     * @param updateDateGetterName 更新日付を取得する際のメソッド名
     * @generated
     */
    public void setUpdateDateGetterName(String updateDateGetterName) {
        this.updateDateGetterName = updateDateGetterName;
    }

    /**
     * DAO実行前に、該当するselect for update文のDAOを呼び出し、更新日付が同じかチェックする。<br>
     * 同じ場合、指定したDAOを呼び出す。<br>
     * 
     * @param methodInvocation MethodInvocation
     * @return DAO実行結果
     * @throws DataExclusiveException 更新日付が不一致時の実行時例外。
     * @throws Throwable MethodInvocation.proceed()実行時の例外(DAO実行時の例外)。
     * @throws UpdateAccessException 更新日付チェック時の実行時例外。
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     * @generated
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (logger.isDebugEnabled()) {
            logger.debug("Start SelectForUpdate Method before Update or Delete Action.");
        }
        try {
            Object daoClass = methodInvocation.getThis();
            Object[] argList = methodInvocation.getArguments();
            Object dtoData = null;
            if (argList.length == 2) {
                dtoData = argList[1];
            } else {
                dtoData = argList[0];
            }
            if (logger.isDebugEnabled()) {
                logger.debug("ParameterDTO: className=" + dtoData.getClass().getName());
                logger.debug("preparing SelectForUpdate:" + selectForUpdateMethodName);
            }
            Method selectForUpdateMethod = null;
            Method excuteMethod = null;
            Object ret = null;
            try {
                selectForUpdateMethod = daoClass.getClass().getMethod(
                        selectForUpdateMethodName,
                        new Class[] { dtoData.getClass().getSuperclass() });
                excuteMethod = methodInvocation.getMethod();
                ret = (Object) selectForUpdateMethod.invoke(daoClass, dtoData);
            } catch (SecurityException e) {
                throw new UpdateAccessException(e);
            } catch (NoSuchMethodException e) {
                throw new UpdateAccessException(e);
            } catch (IllegalArgumentException e) {
                throw new UpdateAccessException(e);
            } catch (IllegalAccessException e) {
                throw new UpdateAccessException(e);
            } catch (InvocationTargetException e) {
                throw new UpdateAccessException(e);
            }
            if (null == ret) {
                throw new DataExclusiveException(
                        "selectForUpdate Faild:methodName"
                                + methodInvocation.getMethod().getName());
            }
            if (!(ret instanceof Object)) {
                throw new IllegalArgumentException(
                        "SelectForUpdate Access Method is invaild or have no data.:methodName"
                                + methodInvocation.getMethod().getName());
            }
            Object resultDto = ret;
            boolean result = compareDto(dtoData, resultDto);
            if (!result) {
                throw new DataExclusiveException(
                        "selectForUpdate Faild:methodName"
                                + methodInvocation.getMethod().getName());
            }
            if (logger.isDebugEnabled()) {
                logger.debug("compareing propertyDTO:OK");
                logger.debug("start SQL(Update or Delete)");
                logger.debug("MethodName:" + excuteMethod.getName());
            }
            Object retVal;
            retVal = methodInvocation.proceed();
            return retVal;
        } finally {
            if (logger.isDebugEnabled()) {
                logger.debug("finish Select For Update Method.");
            }
        }
    }

    /**
     * 引数で渡されたDTOの情報とテーブルから取得したDTOとを比較する。 （実際に動作するメソッドは、データのデータ型により異なる。）
     * 
     * @param parameterDto 引数で渡されたDTO
     * @param resultDto テーブルから取得したDTO
     * @return true：更新日付が同じ。false：更新日付が同じではない。
     * @throws UpdateAccessException 実行時例外
     * @generated
     */
    public boolean compareDto(Object parameterDto, Object resultDto) throws UpdateAccessException {
        boolean sameUpdateDateGetter = compareDtoProperty(parameterDto, resultDto, updateDateGetterName);
        if (sameUpdateDateGetter) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 引数で渡されたDTOの情報とテーブルから取得したDTOとを比較する。 （データ型の振り分けメソッド）
     * 
     * @param parameterDto 引数で渡されたDTO
     * @param resultDto テーブルから取得したDTO
     * @param propertyGetterName DTOからデータを取得する際のメソッド
     * @return true：更新日付が同じ。false：更新日付が同じではない。
     * @throws UpdateAccessException 実行時例外
     * @generated
     */
    protected boolean compareDtoProperty(Object parameterDto, Object resultDto, String propertyGetterName) {
        Method parameterDtoParameterGetter = null;
        Object parameterDtodata = null;
        try {
            parameterDtoParameterGetter = parameterDto.getClass().getMethod(propertyGetterName, (Class[]) null);
            parameterDtodata = parameterDtoParameterGetter.invoke(parameterDto, (Object[]) null);
        } catch (SecurityException e) {
            throw new UpdateAccessException(e);
        } catch (NoSuchMethodException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalArgumentException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalAccessException e) {
            throw new UpdateAccessException(e);
        } catch (InvocationTargetException e) {
            throw new UpdateAccessException(e);
        }
        if (parameterDtodata instanceof Timestamp) {
            if (logger.isDebugEnabled()) {
                logger.debug("comparing Dto(" + propertyGetterName + "):Type=Timestamp");
            }
            return compareDtoPropertyForTimestamp(parameterDto, resultDto, propertyGetterName);
        } else if (parameterDtodata instanceof java.util.Date) {
            if (logger.isDebugEnabled()) {
                logger.debug("comparing Dto(" + propertyGetterName + "):Type=Date");
            }
            return compareDtoPropertyForDate(parameterDto, resultDto, propertyGetterName);
        } else if (parameterDtodata instanceof String) {
            if (logger.isDebugEnabled()) {
                logger.debug("comparing Dto(" + propertyGetterName + "):Type=String");
            }
            return compareDtoPropertyForString(parameterDto, resultDto, propertyGetterName);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("comparing Dto(" + propertyGetterName + "):Type=Object");
            }
            return compareDtoPropertyForObject(parameterDto, resultDto, propertyGetterName);
        }
    }

    /**
     * 引数で渡されたDTOの情報とテーブルから取得したDTOとを比較する。 （データ型がString型の場合）
     * 
     * @param parameterDto 引数で渡されたDTO
     * @param resultDto テーブルから取得したDTO
     * @param propertyGetterName DTOからデータを取得する際のメソッド
     * @return true：更新日付が同じ。false：更新日付が同じではない。
     * @throws UpdateAccessException 実行時例外
     * @generated
     */
    protected boolean compareDtoPropertyForString(Object parameterDto,
            Object resultDto, String propertyGetterName)
            throws UpdateAccessException {
        String parameterDtodata = null;
        String resultDtodata = null;
        try {
            Method parameterDtoParameterGetter = parameterDto.getClass()
                    .getMethod(propertyGetterName, (Class[]) null);
            parameterDtodata = (String) parameterDtoParameterGetter.invoke(
                    parameterDto, (Object[]) null);
            Method resultDtoParameterGetter = resultDto.getClass().getMethod(
                    propertyGetterName, (Class[]) null);
            resultDtodata = (String) resultDtoParameterGetter.invoke(resultDto,
                    (Object[]) null);
        } catch (SecurityException e) {
            throw new UpdateAccessException(e);
        } catch (NoSuchMethodException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalArgumentException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalAccessException e) {
            throw new UpdateAccessException(e);
        } catch (InvocationTargetException e) {
            throw new UpdateAccessException(e);
        }
        if (null == parameterDtodata || null == resultDtodata) {
            throw new UpdateAccessException("Data NotFound Error");
        }
        if (!parameterDtodata.equals(resultDtodata)) {
            if (logger.isDebugEnabled()) {
                logger.debug("parameterDtodata:" + parameterDtodata + " resultDtodata:" + resultDtodata);
                logger.debug("Parameter DTO data is NOT same as data on DB.");
            }
            return false;
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("parameterDtodata:" + parameterDtodata + " resultDtodata:" + resultDtodata);
                logger.debug("Parameter DTO data is same as data on DB.");
            }
            return true;
        }
    }

    /**
     * 引数で渡されたDTOの情報とテーブルから取得したDTOとを比較する。 （データ型がDate型の場合）
     * 
     * @param parameterDto 引数で渡されたDTO
     * @param resultDto テーブルから取得したDTO
     * @param propertyGetterName DTOからデータを取得する際のメソッド
     * @return true：更新日付が同じ。false：更新日付が同じではない。
     * @throws UpdateAccessException 実行時例外
     * @generated
     */
    protected boolean compareDtoPropertyForDate(Object parameterDto,
            Object resultDto, String propertyGetterName)
            throws UpdateAccessException {
        Date parameterDtodata = null;
        Date resultDtodata = null;
        try {
            Method parameterDtoParameterGetter = parameterDto.getClass()
                    .getMethod(propertyGetterName, (Class[]) null);
            parameterDtodata = (Date) parameterDtoParameterGetter.invoke(
                    parameterDto, (Object[]) null);
            Method resultDtoParameterGetter = resultDto.getClass().getMethod(
                    propertyGetterName, (Class[]) null);
            resultDtodata = (Date) resultDtoParameterGetter.invoke(resultDto,
                    (Object[]) null);
        } catch (SecurityException e) {
            throw new UpdateAccessException(e);
        } catch (NoSuchMethodException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalArgumentException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalAccessException e) {
            throw new UpdateAccessException(e);
        } catch (InvocationTargetException e) {
            throw new UpdateAccessException(e);
        }
        if (null == parameterDtodata || null == resultDtodata) {
            throw new UpdateAccessException("DataNotFound Error");
        }
        if (parameterDtodata.compareTo(resultDtodata) != 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("parameterDtodata:" + parameterDtodata + " resultDtodata:" + resultDtodata);
                logger.debug("Parameter DTO data is NOT same as data on DB.");
            }
            return false;
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("parameterDtodata:" + parameterDtodata + " resultDtodata:" + resultDtodata);
                logger.debug("Parameter DTO data is same as data on DB.");
            }
            return true;
        }
    }

    /**
     * 引数で渡されたDTOの情報とテーブルから取得したDTOとを比較する。 （データ型がTimestamp型の場合）
     * 
     * @param parameterDto 引数で渡されたDTO
     * @param resultDto テーブルから取得したDTO
     * @param propertyGetterName DTOからデータを取得する際のメソッド
     * @return true：更新日付が同じ。false：更新日付が同じではない。
     * @throws UpdateAccessException 実行時例外
     * @generated
     */
    protected boolean compareDtoPropertyForTimestamp(Object parameterDto,
            Object resultDto, String propertyGetterName)
            throws UpdateAccessException {
        Timestamp parameterDtodata = null;
        Timestamp resultDtodata = null;
        try {
            Method parameterDtoParameterGetter = parameterDto.getClass()
                    .getMethod(propertyGetterName, (Class[]) null);
            parameterDtodata = (Timestamp) parameterDtoParameterGetter.invoke(
                    parameterDto, (Object[]) null);
            Method resultDtoParameterGetter = resultDto.getClass().getMethod(
                    propertyGetterName, (Class[]) null);
            resultDtodata = (Timestamp) resultDtoParameterGetter.invoke(
                    resultDto, (Object[]) null);
        } catch (SecurityException e) {
            throw new UpdateAccessException(e);
        } catch (NoSuchMethodException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalArgumentException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalAccessException e) {
            throw new UpdateAccessException(e);
        } catch (InvocationTargetException e) {
            throw new UpdateAccessException(e);
        }
        if (null == parameterDtodata || null == resultDtodata) {
            throw new UpdateAccessException("DataNotFound Error");
        }
        if (parameterDtodata.compareTo(resultDtodata) != 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("parameterDtodata:" + parameterDtodata
                        + " resultDtodata:" + resultDtodata);
                logger.debug("Parameter DTO data is NOT same as data on DB.");
            }
            return false;
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("parameterDtodata:" + parameterDtodata
                        + " resultDtodata:" + resultDtodata);
                logger.debug("Parameter DTO data is same as data on DB.");
            }
            return true;
        }
    }

    /**
     * 引数で渡されたDTOの情報とテーブルから取得したDTOとを比較する。 （データ型がString型・Date型以外の場合）
     * 
     * @param parameterDto 引数で渡されたDTO
     * @param resultDto テーブルから取得したDTO
     * @param propertyGetterName DTOからデータを取得する際のメソッド
     * @return true：更新日付が同じ。false：更新日付が同じではない。
     * @throws UpdateAccessException 実行時例外
     * @generated
     */
    protected boolean compareDtoPropertyForObject(Object parameterDto,
            Object resultDto, String propertyGetterName)
            throws UpdateAccessException {
        Object parameterDtodata = null;
        Object resultDtodata = null;

        try {
            Method parameterDtoParameterGetter = parameterDto.getClass()
                    .getMethod(propertyGetterName, (Class[]) null);
            parameterDtodata = parameterDtoParameterGetter.invoke(parameterDto,
                    (Object[]) null);
            Method resultDtoParameterGetter = resultDto.getClass().getMethod(
                    propertyGetterName, (Class[]) null);
            resultDtodata = resultDtoParameterGetter.invoke(resultDto,
                    (Object[]) null);
        } catch (SecurityException e) {
            throw new UpdateAccessException(e);
        } catch (NoSuchMethodException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalArgumentException e) {
            throw new UpdateAccessException(e);
        } catch (IllegalAccessException e) {
            throw new UpdateAccessException(e);
        } catch (InvocationTargetException e) {
            throw new UpdateAccessException(e);
        }
        if (null == parameterDtodata || null == resultDtodata) {
            throw new UpdateAccessException("DataNotFound Error");
        }
        if (!parameterDtodata.equals(resultDtodata)) {
            if (logger.isDebugEnabled()) {
                logger.debug("parameterDtodata:" + parameterDtodata
                        + " resultDtodata:" + resultDtodata);
                logger.debug("Parameter DTO data is NOT same as data on DB.");
            }
            return false;
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("parameterDtodata:" + parameterDtodata
                        + " resultDtodata:" + resultDtodata);
                logger.debug("Parameter DTO data is same as data on DB.");
            }
            return true;
        }
    }
}
