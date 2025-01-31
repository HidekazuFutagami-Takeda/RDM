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

import jp.co.takeda.rdm.dto.JKR999C010DTO;

/**
 * Serviceクラス（JKR999C010)
 * @generated
 */
@Named
public class JKR999C010Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(JKR999C010Service.class);

    /**
     * イベント処理
     * @param indto JKR999C010DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(JKR999C010DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        // END UOC
        return outdto;
    }

    /**
     * イベント処理
     * @param indto JKR999C010DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO execute(JKR999C010DTO indto) {
        BaseDTO outdto = indto;
        // START UOC

        // END UOC
        return outdto;
    }

}
