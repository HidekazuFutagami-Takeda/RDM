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
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.ND001DTO;
import jp.co.takeda.rdm.dto.ND403DTO;
import jp.co.takeda.rdm.service.ND403Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.exception.InvalidRequestException;

/**
 * Actionクラス
 * @generated
 */
@Named("nD403Action")
@Scope("request")
public class ND403Action extends BaseAction<ND403DTO> {

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
    private ND403Service nD403Service;
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
    public ND403Action() {
        dto = new ND403DTO();
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
        BaseDTO outdto = nD403Service.init(dto);
        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC
    	LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

		String title = "ND403_医師勤務先情報一括更新 - 申請内容確認";

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
        sessionMap.put(AppConstant.SESKEY_ND403_SEARCHKEY, outdto);
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
    public String register() throws Exception {
    	BaseDTO outdto = dto;
        registerSetup();
        // F層呼び出し
        outdto = nD403Service.register(dto);
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

    	if("NC101".equals(dto.getForward())) {
        	setJumpInfo("1");
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
        paramDto.setTitle("医師勤務先情報一括更新");
        // メッセージ１
        if (event.equals("1")) {//I002	申請が完了しました。
            paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I002));
        }
    }
}
