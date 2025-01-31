/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import jp.co.takeda.rdm.dto.NC109DTO;

/**
 * Serviceクラス（NC109)
 * @generated
 */
@Named
public class NC109Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC109Service.class);

    /**
     * イベント処理
     * @param indto NC109DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC109DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto NC109DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO execute(NC109DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        // END UOC
        return outdto;
    }

}
