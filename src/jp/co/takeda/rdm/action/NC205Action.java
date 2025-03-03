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
import jp.co.takeda.rdm.dto.NC205DTO;
import jp.co.takeda.rdm.service.NC205Service;
import jp.co.takeda.rdm.util.AppConstant;

import org.springframework.context.annotation.Scope;

/**
 * Actionクラス
 * @generated
 */
@Named("nC205Action")
@Scope("request")
public class NC205Action extends BaseAction<NC205DTO> {

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
    private NC205Service nC205Service;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NC205Action() {
        dto = new NC205DTO();
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
        BaseDTO outdto = nC205Service.init(dto);
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
    	sessionMap.put(AppConstant.SESKEY_NC205_SEARCHKEY, outdto);
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
        BaseDTO outdto = nC205Service.search(dto);
        if (outdto instanceof NC205DTO) {
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
    	sessionMap.put(AppConstant.SESKEY_NC205_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

	/**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
//    public String page() throws Exception {
//        pageSetup();
//        // F層呼び出し
//        BaseDTO outdto = nC205Service.page(dto);
//        if (outdto instanceof NC205DTO) {            // START UOC
////        	// チェック済み再設定
////        	NC205DTO dto = (NC205DTO)outdto;
////        	String[] cdcCheckedCodes = dto.getCdcCheckedCodes();
////        	for (String data : cdcCheckedCodes) {
////        		String depCd = data.split(",", -1)[0];
////        		for (CatDeptsComboDataList catDeptsComboDataList : dto.getCatDeptsComboDataList()) {
////        			if (catDeptsComboDataList.getDeptCode().equals(depCd)) {
////        				catDeptsComboDataList.setCheckers(true);
////        			}
////        		}
////            }
//
//            // END UOC
//        }
//        return pageNext(outdto);
//    }

	/**
     * 前処理
     * @customizable
     */
    protected void pageSetup() throws Exception {
        // START UOC

        NC205DTO searchKey = (NC205DTO)sessionMap.get(AppConstant.SESKEY_NC205_SEARCHKEY);
       // 郵便番号....今回の入力はこれだけ..↓全部いらないかも？
        dto.setPostCode(searchKey.getPostCode());
        // JIS府県名
        dto.setAddrNamePref(searchKey.getAddrNamePref());
        // JIS市区町村名
        dto.setAddrNameCity(searchKey.getAddrNameCity());
        // 大字／町域名
        dto.setAddrNameArea(searchKey.getAddrNameArea());
        // JIS府県コード
        dto.setAddrCodePref(searchKey.getAddrCodePref());
        // JIS市区町村コード
        dto.setAddrCodeCity(searchKey.getAddrCodeCity());
        // 武田府県コード
        dto.setTkPrefCd(searchKey.getTkPrefCd());
        // 武田市区郡コード
        dto.setTkCityCd(searchKey.getTkCityCd());
        // 武田市区郡名
        dto.setTkCityName(searchKey.getTkCityName());
        // JIS府県カナ
        dto.setAddrKanaPref(searchKey.getAddrKanaPref());
        // JIS市区町村名カナ
        dto.setAddrKanaCity(searchKey.getAddrKanaCity());
        // 大字／町域名カナ
        dto.setAddrKanaArea(searchKey.getAddrNamePref());

//        // END UOC
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
