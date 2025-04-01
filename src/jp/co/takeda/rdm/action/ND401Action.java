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
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.dto.ND001DTO;
import jp.co.takeda.rdm.dto.ND401DTO;
import jp.co.takeda.rdm.service.ND401Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.StringUtils;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.exception.InvalidRequestException;

/**
 * Actionクラス
 * @generated
 */
@Named("nD401Action")
@Scope("request")
public class ND401Action extends BaseAction<ND401DTO> {

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
    private ND401Service nD401Service;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND401Action() {
        dto = new ND401DTO();
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
        BaseDTO outdto = nD401Service.init(dto);
        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC
    	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

    	dto.setLoginJgiNo(Integer.toString(loginInfo.getJgiNo()));
        dto.setLoginJokenSetCd(loginInfo.getJokenSetCd());
        dto.setLoginBrCd(loginInfo.getBrCode());
        dto.setLoginDistCd(loginInfo.getDistCode());
        dto.setLoginNm(loginInfo.getJgiName());
        dto.setLoginShzNm(loginInfo.getBumonRyakuName());
        dto.setLoginTrtCd(loginInfo.getTrtCd());

    	String title = "ND401_医師勤務先情報一括更新";

		dto.setTitle(title);

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
        // 検索条件をセッションに格納する（更新やソートリンク押下時に使用）
        sessionMap.put(AppConstant.SESKEY_ND401_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD401Service.search(dto);
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
        sessionMap.put(AppConstant.SESKEY_ND401_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD401Service.page(dto);
        if (outdto instanceof ND401DTO) {
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
        sessionMap.put(AppConstant.SESKEY_ND401_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String req() throws Exception {
        reqSetup();
        // F層呼び出し
        BaseDTO outdto = nD401Service.req(dto);
        return reqNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void reqSetup() throws Exception {
        // START UOC
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String reqNext(BaseDTO outdto) throws Exception {
        // START UOC
        sessionMap.put(AppConstant.SESKEY_ND401_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    private void setSearchCon() {

    }
}
