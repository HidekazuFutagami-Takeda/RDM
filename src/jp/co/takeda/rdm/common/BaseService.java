/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import javax.inject.Inject;


/**
 * ベースServiceクラス
 * @generated
 */
public abstract class BaseService {

    /**
     * DAOインスタンス
     * @generated
     */
    @Inject
    protected DAO dao;

    /**
     * メッセージ管理クラス
     */
    @Inject
    protected MessageUtil messageUtil;

}
