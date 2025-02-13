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
import jp.co.takeda.rdm.dto.ND301DTO;
import jp.co.takeda.rdm.service.ND301Service;
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
@Named("nD301Action")
@Scope("request")
public class ND301Action extends BaseAction<ND301DTO> {

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
    private ND301Service nD301Service;
    // 確認画面用にする
    private NC101DTO paramDto;
    // START UOC
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND301Action() {
        dto = new ND301DTO();
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
        BaseDTO outdto = nD301Service.init(dto);
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

//        // 登録完了画面から戻る場合、遷移前の検索条件をセッションから取得する。
//        //　遷移元画面IDを取得
//        String finishFlg = (String)request.getParameter(RdmConstantsData.JKR090C020_FINISH_FLG);
//        // 遷移元画面が登録完了画面の場合
//        if (RdmConstantsData.JKR090C020_FINISH_VALUE.equals(finishFlg)) {
//            ND301DTO searchKey = (ND301DTO)sessionMap.get(AppConstant.SESKEY_ND301_SEARCHKEY);
//            BeanUtils.copyProperties(dto, searchKey);
//
//        } else if (!dto.getBackScreenId().startsWith("JKR030C0")) {
//            //前画面から組織関連パラメータ設定
//            setSosInfo(sessionMap, dto);
//        }

//        dto.setStatus("FirstTab");

//        dto.setActionMtKbn("1");
      //画面タイト制御処理
        String title = "ND301_医師新規作成 - 申請内容確認";
        //ユーザ権限
        String jokenSetCd = dto.getLoginJokenSetCd();

        dto.setTitle(title);

        String preScreenId = loginInfo.getPreScreenId();
        dto.setBackScreenId(preScreenId);
        String reqId = dto.getReqId();
        String ultNo = dto.getUltDocNo();

        //モック
        preScreenId = "ND301";

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
        sessionMap.put(AppConstant.SESKEY_ND301_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD301Service.register(dto);
        if (outdto instanceof ND301DTO) {
            // START UOC
//            outdto = nD301Service.register(dto);
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
        if (!RdmConstantsData.M0122740.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !RdmConstantsData.M0001102.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !RdmConstantsData.M0001101.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !RdmConstantsData.E003.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !"exception".equals(outdto.getForward())){
            setJumpInfo(dto.getMsgId());
//            outdto.setForward("JKR090C020Init");
        }
        // END UOC
        //TODO buttonflgで初期表示＋メッセージ表示の処理か、確認画面遷移の処理する
        setNextDTO(outdto);
        return outdto.getForward();
    }

    // START UOC
    /**
     * 終了画面へ遷移用パラメータ設定。
     * @param dto 登録完了画面DTO
     * @param msgId メッセージID
     */
    private void setJumpInfo(String msgId) {
        // メッセージオブジェクト取得
        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

        String subTitle = "";
        String jokenSetCd = dto.getLoginJokenSetCd();
//TODO
        //画面タイトル内容設定
        paramDto = new NC101DTO();
        // ブラウザタイトル
        paramDto.setBrowerTitle ("ND301_医師新規作成 - 申請内容確認");
        // 画面タイトル
        paramDto.setTitle("ND301_医師新規作成 - 申請内容確認");
        // 戻るリンク(表示文言)
        paramDto.setReturnLinkNm1("戻る");
        // 戻るリンク(遷移先URL)
        paramDto.setReturnLinkURL1("ND301Init");

        ND301DTO searchKey = (ND301DTO)sessionMap.get(AppConstant.SESKEY_ND301_SEARCHKEY);
//        searchKey.setActionMtKbn("2");
        sessionMap.put(AppConstant.SESKEY_ND301_SEARCHKEY, searchKey);
    }

}
