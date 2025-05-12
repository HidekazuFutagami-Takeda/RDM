/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.ND014DTO;
import jp.co.takeda.rdm.dto.ND305DTO;
import jp.co.takeda.rdm.service.ND305Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * Actionクラス
 * @generated
 */
@Named("nD305Action")
@Scope("request")
public class ND305Action extends BaseAction<ND305DTO> {

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
    private ND305Service nD305Service;
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
    public ND305Action() {
        dto = new ND305DTO();
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
    	dto.setMsgId(null);
    	dto.setMsgStr(null);
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
        BaseDTO outdto = nD305Service.init(dto);
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

      //画面タイト制御処理
        String title = "ND305_医師復活 - 申請内容確認";
        //ユーザ権限
        String jokenSetCd = dto.getLoginJokenSetCd();

        dto.setTitle(title);

        String preScreenId = loginInfo.getPreScreenId();
        dto.setBackScreenId(preScreenId);
        //ND014DTO searchKey = (ND014DTO)sessionMap.get(AppConstant.SESKEY_ND014_SEARCHKEY);
        //String reqId = searchKey.getReqId();
        //dto.setReqId(reqId);
		if("ND014".equals(preScreenId)) {
			//一時保存なし申請後に確認画面から遷移
			dto.setDisplayKbn("9");
		}
        //モック
        preScreenId = "ND305";

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
        sessionMap.put(AppConstant.SESKEY_ND305_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD305Service.register(dto);
        if (outdto instanceof ND305DTO) {
            // START UOC
//            outdto = nD305Service.register(dto);
            // END UOC
        }
        return registerNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void registerSetup() throws Exception {
        // START UOC
        dto.setMsgId(null);
        dto.setMsgStr(null);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String registerNext(BaseDTO outdto) throws Exception {
        // START UOC
        if (!RdmConstantsData.E003.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !"exception".equals(outdto.getForward())){

        }
        // END UOC
        //TODO buttonflgで初期表示＋メッセージ表示の処理か、確認画面遷移の処理する
        //"9" = 登録完了
        if ("9".equals(dto.getReturnFlg())) {
            // 登録完了画面へ遷移
            setJumpInfo(dto.getButtonFlg());

            outdto.setForward("NC101Init");
        }
        setNextDTO(outdto);
        return outdto.getForward();
    }

    // START UOC
    /**
     * 終了画面へ遷移用パラメータ設定。
     * @param dto 登録完了画面DTO
     * @param msgId メッセージID
     */
    private void setJumpInfo(String event) {
        // メッセージオブジェクト取得
        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

        //画面タイトル内容設定
        paramDto = new NC101DTO();
//        // ブラウザタイトル
//        paramDto.setBrowerTitle ("ND014_医師復活");
        // 画面タイトル
        paramDto.setTitle("医師復活");
//        // 戻るリンク(表示文言)
//        paramDto.setReturnLinkNm1("医師検索画面へ");
//        // 戻るリンク(遷移先URL)
//        paramDto.setReturnLinkURL1("ND001Init");
        // メッセージ１
        if (event.equals("0")) {//I002	申請が完了しました。
            paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I002));
        }
        if (event.equals("1")) {//I003	承認が完了しました。
            paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I003));
        }
        if (event.equals("2")) {//I004	却下が完了しました。
            paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I004));
        }

//        ND305DTO searchKey = (ND305DTO)sessionMap.get(AppConstant.SESKEY_ND305_SEARCHKEY);
//        sessionMap.put(AppConstant.SESKEY_ND305_SEARCHKEY, searchKey);
    }

}
