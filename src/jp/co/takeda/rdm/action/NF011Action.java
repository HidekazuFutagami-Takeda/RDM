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
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.NF011DTO;
import jp.co.takeda.rdm.exception.InvalidRequestException;
import jp.co.takeda.rdm.service.NF011Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import lombok.Getter;
import lombok.Setter;

/**
 * Actionクラス
 * @generated
 */
@Named("nF011Action")
@Scope("request")
public class NF011Action extends BaseAction<NF011DTO> {

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
    private NF011Service nF011Service;
    // 確認画面用
    @Getter
    @Setter
    private NC101DTO paramDto;
    // START UOC
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NF011Action() {
        dto = new NF011DTO();
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
        BaseDTO outdto = nF011Service.init(dto);
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
        String title = "NF011_施設新規作成";

        dto.setTitle(title);

        String reqId = dto.getReqId();
        String ultCd = dto.getUltInsCd();

        String preScreenId = dto.getBackScreenId();
        String backScreenId = dto.getBackScreenId();
        if("NF301".equals(preScreenId)) {
        	preScreenId = dto.getPreScreenId();
        } else {
        	dto.setPreScreenId(preScreenId);
        }

        dto.setLoginJgiNo(Integer.toString(loginInfo.getJgiNo()));
        dto.setLoginJokenSetCd(loginInfo.getJokenSetCd());
        dto.setLoginBrCd(loginInfo.getBrCode());
        dto.setLoginDistCd(loginInfo.getDistCode());
        dto.setLoginNm(loginInfo.getJgiName());
        dto.setLoginShzNm(loginInfo.getBumonRyakuName());
        dto.setLoginTrtCd(loginInfo.getTrtCd());

        // 遷移パターン　0:完全新規、1:ULTから作成、2：申請データあり
        // ULT施設コード　ありなしで分岐
        // NF001_施設検索
        if ("NF001".equals(backScreenId)) {
        	if (ultCd != null && ultCd.length() > 0) {
        		// ULT施設コードで初期データ作成
        		dto.setDisplayKbn("1");
        	} else if(ultCd == null || ultCd.length() == 0){
        		// 完全新規
        		dto.setDisplayKbn("0");
        	} else { //遷移エラー
        		throw new InvalidRequestException();
        	}
        }
        // 申請ID
        // NC011_申請一覧
        // NF301_施設新規作成 - 申請内容確認
        // NM101_通知内容詳細
        if ("NC011".equals(backScreenId) || "NF301".equals(backScreenId) || "NM101".equals(backScreenId)) {
        	if (reqId != null && reqId.length() > 0) {
        		// 申請データ（一時保存含む）を参照
        		dto.setDisplayKbn("2");
        	} else if("NF301".equals(backScreenId)) {
				// 一時保存なし申請後に確認画面から遷移
				dto.setDisplayKbn("9");
        	} else { //遷移エラー
        		throw new InvalidRequestException();
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
        sessionMap.put(AppConstant.SESKEY_NF011_SEARCHKEY, outdto);
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
        BaseDTO outdto = nF011Service.register(dto);
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
		// 本画面を再表示
		outdto.setForward("NF011");

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
        BaseDTO outdto = nF011Service.cancel(dto);
        outdto = nF011Service.init(dto);
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

    	// 完了画面に遷移
        outdto.setForward("NC101");
        setJumpInfo(RdmConstantsData.I016);

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
        BaseDTO outdto = nF011Service.shnComp(dto);
        outdto = nF011Service.init(dto);
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

    	// END UOC
    	outdto.setForward("NF011");
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 終了画面へ遷移用パラメータ設定。
     * @param dto 登録完了画面DTO
     * @param msgId メッセージID
     */
    private void setJumpInfo(String msgId) {
        // メッセージオブジェクト取得
        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

        //画面タイトル内容設定
        paramDto = new NC101DTO();
		// 画面タイトル
		paramDto.setTitle("施設新規作成");
		// メッセージ１
		if (msgId.equals(RdmConstantsData.I016)) {//I016	一時保存データを破棄しました。
			paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I016));
		}
	}
}
