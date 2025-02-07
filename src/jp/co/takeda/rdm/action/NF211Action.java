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
import jp.co.takeda.rdm.dto.NF211DTO;
import jp.co.takeda.rdm.service.NF211Service;
import jp.co.takeda.rdm.util.AppConstant;

/**
 * Actionクラス
 * @generated
 */
@Named("nF211Action")
@Scope("request")
public class NF211Action extends BaseAction<NF211DTO> {

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
    private NF211Service nF211Service;
    // START UOC
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NF211Action() {
        dto = new NF211DTO();
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
        // START UOC
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
        BaseDTO outdto = nF211Service.init(dto);
        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC
        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

    	//改ページ設定
        dto.setPageCntCur(1);

        // 画面タイトル制御処理
        String title = "NF211_施設紐付け新規";
        dto.setTitle(title);

        //モック
//        //dto.setInsNo("101108001");
//        dto.setInsNo("101110001");
//        //dto.setReqId("250131-000178");
//        dto.setReqId("250203-000187");
//        dto.setTkdTrtKbn("1");

        String preScreenId = loginInfo.getPreScreenId();
        String reqId = dto.getReqId();
        String insNo = dto.getInsNo();
        String tkdTrtKbn = dto.getTkdTrtKbn();
        dto.setPreScreenId(preScreenId);

        //モック
//        String kbn = "1";
//        if(kbn.equals("0")) {
//	        preScreenId = "NF201";
//	        dto.setLoginJgiNo("8830034");
//	        dto.setLoginJokenSetCd("JKN0813");	// 管理者
//	        //dto.setLoginJokenSetCd("JKN0023");	// MR
//	        dto.setReqId("");
//        } else {
//	        preScreenId = "NC011";
//	        dto.setLoginJgiNo("8830034");
//	        //dto.setLoginJgiNo("0");
//	        dto.setLoginJokenSetCd("JKN0813");	// 管理者
//	        //dto.setLoginJokenSetCd("JKN0023");	// MR
//	        dto.setInsNo("");
//        }

        // 遷移パターン　0:完全新規、1:施設固定コードから作成、2：申請データあり
        // 施設固定コード　ありなしで分岐
        // NF201_親子紐付け一覧
        if ("NF201".equals(preScreenId)) {
        	if (insNo != null && insNo.length() > 0) {
        		// 施設固定コードで初期データ作成
        		if("0".equals(tkdTrtKbn)) {
        			dto.setDisplayKbn("0");
        		} else {
        			dto.setDisplayKbn("1");
        		}
        	} else { //遷移エラー
        	}
        }
        // 申請ID
        // NC011_申請一覧
        if ("NC011".equals(preScreenId)) {
        	if (reqId != null && reqId.length() > 0) {
        		// 申請データ（一時保存含む）を参照
        		if("0".equals(tkdTrtKbn)) {
        			dto.setDisplayKbn("2");
        		} else {
        			dto.setDisplayKbn("3");
        		}
        	} else { //遷移エラー
        	}
        }

        dto.setMsgId(null);

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
        // 検索条件をセッションに格納する（リンク押下時に使用）
        sessionMap.put(AppConstant.SESKEY_NF211_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String register() throws Exception {
        registerSetup();
        // F層呼び出し
        BaseDTO outdto = nF211Service.register(dto);
        return registerNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void registerSetup() throws Exception {
        // START UOC
        dto.setMsgId(null);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String registerNext(BaseDTO outdto) throws Exception {
        // START UOC
        // END UOC
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		// 本画面を再表示
		outdto.setForward("NF211");

        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String cancel() throws Exception {
        cancelSetup();
        // F層呼び出し
        BaseDTO outdto = nF211Service.cancel(dto);
        outdto = nF211Service.init(dto);
        return cancelNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void cancelSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String cancelNext(BaseDTO outdto) throws Exception {
        // START UOC

    	// 前画面に遷移
        outdto.setForward(outdto.getPreScreenId());

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String shnComp() throws Exception {
        registerSetup();
        // F層呼び出し
        BaseDTO outdto = nF211Service.shnComp(dto);
        outdto = nF211Service.init(dto);
        return shnCompNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void shnCompSetup() throws Exception {
        // START UOC
        dto.setMsgId(null);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String shnCompNext(BaseDTO outdto) throws Exception {
    	// START UOC
    	LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

    	// END UOC
    	outdto.setForward("NF211");
        setNextDTO(outdto);
        return outdto.getForward();
    }
}
