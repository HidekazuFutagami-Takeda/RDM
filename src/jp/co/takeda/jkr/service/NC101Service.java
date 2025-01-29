/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.service;

import javax.inject.Named;

import jp.co.takeda.jkr.common.BaseDTO;
import jp.co.takeda.jkr.common.BaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.jkr.dto.NC101DTO;

/**
 * Serviceクラス（NC101)
 * @generated
 */
@Named
public class NC101Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC101Service.class);

    /**
     * イベント処理
     * @param indto NC101DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC101DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        // END UOC
        return outdto;
    }

}
