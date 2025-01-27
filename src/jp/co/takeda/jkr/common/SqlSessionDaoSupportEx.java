/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;

/**
 * SpringとMyBatisとの連携クラス。
 * @generated
 */
public class SqlSessionDaoSupportEx extends DaoSupport {

    /**
     * @generated
     */
    private SqlSession sqlSession;

    /**
     * @generated
     */
    private boolean externalSqlSession;


    /**
     * @generated
     */
    @Autowired(required = false)
    public final void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        if (!this.externalSqlSession) {
            this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    /**
     * @generated
     */
    @Autowired(required = false)
    @Qualifier("sqlSession")
    public final void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSession = sqlSessionTemplate;
        this.externalSqlSession = true;
    }

    /**
     * @generated
     */
    public final SqlSession getSqlSession() {
        return this.sqlSession;
    }

    /**
     * @generated
     */
    protected void checkDaoConfig() {
        Assert.notNull(this.sqlSession, "Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
    }
}
