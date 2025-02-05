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

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.dto.NC204DTO;
import jp.co.takeda.rdm.service.NC204Service;
import jp.co.takeda.rdm.util.AppConstant;

import org.springframework.context.annotation.Scope;

/**
 * Actionクラス
 * @generated
 */
@Named("nC204Action")
@Scope("request")
public class NC204Action extends BaseAction<NC204DTO> {

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
    private NC204Service nC204Service;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NC204Action() {
        dto = new NC204DTO();
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
        BaseDTO outdto = nC204Service.init(dto);
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
    	// 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_NC204_SEARCHKEY, outdto);
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
        BaseDTO outdto = nC204Service.search(dto);
        if (outdto instanceof NC204DTO) {
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
        // 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_NC204_SEARCHKEY, outdto);
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
        BaseDTO outdto = nC204Service.page(dto);
        if (outdto instanceof NC204DTO) {            // START UOC
//        	// チェック済み再設定
//        	NC204DTO dto = (NC204DTO)outdto;
//        	String[] cdcCheckedCodes = dto.getCdcCheckedCodes();
//        	for (String data : cdcCheckedCodes) {
//        		String depCd = data.split(",", -1)[0];
//        		for (CatDeptsComboDataList catDeptsComboDataList : dto.getCatDeptsComboDataList()) {
//        			if (catDeptsComboDataList.getDeptCode().equals(depCd)) {
//        				catDeptsComboDataList.setCheckers(true);
//        			}
//        		}
//            }

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

        NC204DTO searchKey = (NC204DTO)sessionMap.get(AppConstant.SESKEY_NC204_SEARCHKEY);
        // 所属部科名カナ
        dto.setKensakuKana(searchKey.getKensakuKana());
        // 入力_所属部科名漢字
        dto.setKensakuKanj(searchKey.getKensakuKanj());

        // END UOC
    }

	/**
     * 後処理
     * @customizable
     */
    protected String pageNext(BaseDTO outdto) throws Exception {
        // START UOC

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

}
