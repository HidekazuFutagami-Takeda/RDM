/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import javax.inject.Inject;
import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.dto.NC203DTO;
import jp.co.takeda.rdm.service.NC203Service;

import org.springframework.context.annotation.Scope;

/**
 * Actionクラス
 * @generated
 */
@Named("nC203Action")
@Scope("request")
public class NC203Action extends BaseAction<NC203DTO> {

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
    private NC203Service nC203Service;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NC203Action() {
        dto = new NC203DTO();
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
        dto.setFunctionId("Init");
        BaseDTO outdto = nC203Service.init(dto);
        //都道府県取得
        if (dto.getKensakuAddrCodePref() != null) {
        	String sosAddrCode = dto.getKensakuAddrCodePref().substring(0, 2);
            if (sosAddrCode.isEmpty()) {

            }
            dto.setKensakuAddrCodePref(sosAddrCode);
            //住所検索
            outdto = nC203Service.searchCityName(dto);
        }

        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC
    	// 画面タイトル制御処理
        String title = "NC203_施設検索ポップアップ";
        dto.setTitle(title);

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
    	sessionMap.put(AppConstant.SESKEY_NC203_SEARCHKEY, outdto);
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
        dto.setFunctionId("Search");
        BaseDTO outdto = nC203Service.search(dto);
        if (outdto instanceof NC203DTO) {
            // START UOC

            // END UOC
        }
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
        // 検索条件をセッションに格納する（更新やソートリンク押下時に使用）
        sessionMap.put(AppConstant.SESKEY_NC203_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String sort() throws Exception {
        pageSetup();
        // F層呼び出し
        BaseDTO outdto = nC203Service.sort(dto);
        if (outdto instanceof NC203DTO) {
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
        sessionMap.put(AppConstant.SESKEY_NC203_SEARCHKEY, outdto);
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
        BaseDTO outdto = nC203Service.page(dto);
        if (outdto instanceof NC203DTO) {
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
        sessionMap.put(AppConstant.SESKEY_NC203_SEARCHKEY, outdto);
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
    public String reset() throws Exception {
        resetSetup();
        // F層呼び出し
        BaseDTO outdto = nC203Service.reset(dto);
        if (outdto instanceof NC203DTO) {
            // START UOC

            // END UOC
        }
        return resetNext(outdto);
    }

	/**
     * 前処理
     * @customizable
     */
    protected void resetSetup() throws Exception {
        // START UOC

        // END UOC
    }

	/**
     * 後処理
     * @customizable
     */
    protected String resetNext(BaseDTO outdto) throws Exception {
        // START UOC

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

}
