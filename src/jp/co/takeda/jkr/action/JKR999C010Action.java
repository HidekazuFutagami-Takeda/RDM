/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.action;

import javax.inject.Inject;
import javax.inject.Named;

import jp.co.takeda.jkr.common.BaseAction;
import jp.co.takeda.jkr.common.BaseDTO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import jp.co.takeda.jkr.service.JKR999C010Service;
import org.springframework.context.annotation.Scope;

import jp.co.takeda.jkr.dto.JKR999C010DTO;

/**
 * Actionクラス
 * @generated
 */
@Named("jKR999C010Action")
@Scope("request")
public class JKR999C010Action extends BaseAction<JKR999C010DTO> {

    /**
     * シリアルバージョンID
     * @generated
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Serviceオブジェクト
     * @generated
     */
    @Inject
    private JKR999C010Service jKR999C010Service;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public JKR999C010Action() {
        dto = new JKR999C010DTO();
    }

    /**
     * イベント毎のメソッド実行前に共通後処理。<br/>
     * 但し、validationエラー時は実行されない。
     * @return 遷移先（nullの場合、イベントのメソッドを呼び出す）
     * @customizable
     */
    @Before
    public String before() throws Exception {
        // START UOC
        return null;
        // END UOC
    }

    /**
     * イベント毎のメソッド実行前に共通後処理。<br/>
     * 但し、validationエラー時は実行されない。
     * @customizable
     */
    @BeforeResult
    public void beforeResult() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * validationエラー時に実行する処理。<br/>
     * @customizable
     */
    @InputConfig
    public String validationError() {
        // START UOC
        return "input";
        // END UOC
    }
    /**
     * 業務処理
     * @customizable
     */
    public String init() throws Exception {
        initSetup();
        // F層呼び出し
        BaseDTO outdto = jKR999C010Service.init(dto);
        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
        outdto.setForward("exception");
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

}
