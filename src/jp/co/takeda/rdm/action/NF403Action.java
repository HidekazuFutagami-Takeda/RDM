/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NF403DTO;
import jp.co.takeda.rdm.service.NF403Service;
import jp.co.takeda.rdm.util.AppConstant;

/**
 * Actionクラス
 * @generated
 */
@Named("nF403Action")
@Scope("request")
public class NF403Action extends BaseAction<NF403DTO> {

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
    private NF403Service NF403Service;

    // START UOC


  //ログインユーザ情報取得
      LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

      boolean errChk = false;
  	String msgStr = "";
  	String tmpMsgStr = "";
  	int len = 0;
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NF403Action() {
        dto = new NF403DTO();
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
        BaseDTO outdto = NF403Service.init(dto);
        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC
    	// 画面タイトル制御処理

        String title = "NF403_施設来期項目一括申請";

        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        dto.setLoginJgiNo(Integer.toString(loginInfo.getJgiNo()));
        dto.setLoginJokenSetCd(loginInfo.getJokenSetCd());
        dto.setLoginBrCd(loginInfo.getBrCode());
        dto.setLoginDistCd(loginInfo.getDistCode());
        dto.setLoginNm(loginInfo.getJgiName());
        dto.setLoginShzNm(loginInfo.getBumonRyakuName());
        dto.setLoginTrtCd(loginInfo.getTrtCd());

        dto.setTitle(title);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
    	// 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_NF403_SEARCHKEY, outdto);
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
    	BaseDTO outdto = dto;
    	searchSetup();
        // F層呼び出し
    	outdto = NF403Service.search(dto);

        return searchNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void searchSetup() throws Exception {
        // START UOC
    	String title = "NF403_施設来期項目一括申請";
    	dto.setTitle(title);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String searchNext(BaseDTO outdto) throws Exception {
        // START UOC
        // 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_NF403_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String request() throws Exception {
    	BaseDTO outdto = dto;
    	requestSetup();
        // F層呼び出し
    	outdto = NF403Service.request(dto);

        return requestNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void requestSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String requestNext(BaseDTO outdto) throws Exception {
        // START UOC
        // 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_NF403_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }
}
