/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import javax.inject.Inject;
import javax.inject.Named;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.dto.ND001DTO;
import jp.co.takeda.rdm.service.ND001Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.JkrConstantsData;

/**
 * Actionクラス
 * @generated
 */
@Named("nD001Action")
@Scope("request")
public class ND001Action extends BaseAction<ND001DTO> {

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
    private ND001Service nD001Service;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND001Action() {
        dto = new ND001DTO();
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
     * 業務処理
     * @customizable
     */
    public String init() throws Exception {
        initSetup();
        // F層呼び出し
        BaseDTO outdto = nD001Service.init(dto);
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
        // 検索条件をセッションに格納する（更新やソートリンク押下時に使用）
        sessionMap.put(AppConstant.SESKEY_ND001_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String search() throws Exception {
        searchSetup();
        // F層呼び出し
        BaseDTO outdto = nD001Service.search(dto);
//        if (outdto instanceof ND001DTO) {
            // START UOC

            // END UOC
//        }
        return searchNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void searchSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String searchNext(BaseDTO outdto) throws Exception {
        // START UOC
        // 検索条件をセッションに格納する（ページャ押下時に使用）
        sessionMap.put(AppConstant.SESKEY_ND001_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }


    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String page() throws Exception {
        pageSetup();
        // F層呼び出し
        BaseDTO outdto = nD001Service.page(dto);
        if (outdto instanceof ND001DTO) {
            // START UOC

            // END UOC
        }
        return pageNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void pageSetup() throws Exception {
        // START UOC
        this.setSearchCon();
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String pageNext(BaseDTO outdto) throws Exception {
        // START UOC
        sessionMap.put(AppConstant.SESKEY_ND001_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    private void setSearchCon() {

    }


    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String sort() throws Exception {
        pageSetup();
        // F層呼び出し
        BaseDTO outdto = nD001Service.sort(dto);
        if (outdto instanceof ND001DTO) {
            // START UOC

            // END UOC
        }
        return sortNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void sortSetup() throws Exception {
        // START UOC
        this.setSearchCon();
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String sortNext(BaseDTO outdto) throws Exception {
        // START UOC
        sessionMap.put(AppConstant.SESKEY_ND001_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

}
