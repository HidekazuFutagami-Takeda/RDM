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
import jp.co.takeda.rdm.service.ND307Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import lombok.Getter;
import lombok.Setter;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.ND307DTO;

/**
 * Actionクラス
 * @generated
 */
@Named("nD307Action")
@Scope("request")
public class ND307Action extends BaseAction<ND307DTO> {

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
    private ND307Service nD307Service;
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
    public ND307Action() {
        dto = new ND307DTO();
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
        BaseDTO outdto = nD307Service.init(dto);
        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC
    	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

        String preScreenId = loginInfo.getPreScreenId();
        dto.setPreScreenId(preScreenId);

		String title = "ND307_医療機関への異動 - 申請内容確認";

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
        sessionMap.put(AppConstant.SESKEY_ND307_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD307Service.register(dto);
        return registerNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void registerSetup() throws Exception {
        // START UOC
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
        //"9" = 登録完了
        if ("9".equals(dto.getReturnFlg())) {
            // 登録完了画面へ遷移
            setJumpInfo(dto.getFuncId());

            outdto.setForward("NC101Init");
        }
        setNextDTO(outdto);
        return outdto.getForward();
    }

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
        // 画面タイトル
        paramDto.setTitle("医療機関への異動");
        // メッセージ１
        if (event.equals("0")) {//I002	申請が完了しました。
            paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I002));
        }
        if (event.equals("2")) {//I003	承認が完了しました。
            paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I003));
        }
        if (event.equals("1")) {//I004	却下が完了しました。
            paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I004));
        }
    }

}
