/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2103, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.ND103DTO;

import jp.co.takeda.rdm.service.ND103Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

import org.springframework.context.annotation.Scope;

/**
 * Actionクラス
 * @generated
 */
@Named("ND103Action")
@Scope("request")
public class ND103Action extends BaseAction<ND103DTO> {

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
    private ND103Service nD103Service;

    //ログインユーザ情報取得
    LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

    boolean errChk = false;
	String msgStr = "";
	String tmpMsgStr = "";
	int len = 0;

    // START UOC

    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND103Action() {
        dto = new ND103DTO();
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

        //【仮】権限判別
      //ログインユーザー情報格納
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

//        loginInfo.setJokenFlg(1);//ユーザー権限
//        //ユーザー
//        if (loginInfo.getJokenSetCd() == 0) {
//        	dto.setJokenSetCd("0");
//        }
//        //管理者
//        if (loginInfo.getJokenSetCd() == 1) {
//        	dto.setJokenSetCd("1");
//        	dto.setLoginJgiNo(loginInfo.getJgiNo());
//        }

        //一時保存押下の場合
        if (Objects.deepEquals(dto.getSaveButtonFlg(), "1")) {
        	//申請IDがある場合
        	//更新処理へ
        	if (!Objects.equals(dto.getParamReqId(), "-") ) {

        		//エラーチェック
        		int i = dto.getReqComment().length();
        		if (i >= 300) {//申請コメント文字数が300文字以上の場合
        			errChk = true;
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W013);// 検索条件を入力してください。

            		if(errChk) {//エラーありなのでメッセージをセットする
            			dto.setMsgStr(tmpMsgStr);
            			dto.setSaveButtonFlg("0");
            		}
        		}
        		else {//エラーがない場合更新処理へ
        			nD103Service.update(dto);
        			dto.setMsgStr("保存が完了しました。");
        			dto.setSaveButtonFlg("0");
        		}


        	}
        	//申請IDがない場合
        	//保存処理へ
        	else {
        		//エラーチェック
        		int i = dto.getReqComment().length();
        		if (i >= 300) {//申請コメント文字数が300文字以上の場合
        			errChk = true;
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W013);// 検索条件を入力してください。

            		if(errChk) {//エラーありなのでメッセージをセットする
            			dto.setMsgStr(tmpMsgStr);
            			dto.setSaveButtonFlg("0");
            		}
        		}
        		else {//エラーがない場合更新処理へ
        			nD103Service.save(dto);
        			dto.setMsgStr("保存が完了しました。");
        			dto.setSaveButtonFlg("0");
        		}
        	}
        }
        //申請破棄ボタンが押下後の場合
        if (Objects.deepEquals(dto.getDeleteButtonFlg(),"1")) {
        	nD103Service.delete(dto);
        }

        BaseDTO outdto = dto;
        //親画面 申請ID　空チェック
        if (!StringUtils.isEmpty(dto.getParamReqId())) {
        	dto.setParamDocNo(null);
        	// F層呼び出し
           outdto = nD103Service.initReq(dto);
        }

        //親画面 医師固定コード　空チェック
        if (!StringUtils.isEmpty(dto.getParamDocNo())) {
        	dto.setParamReqId(null);
        	// F層呼び出し
            outdto = nD103Service.initDoc(dto);
        }



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
    	sessionMap.put(AppConstant.SESKEY_ND103_SEARCHKEY, outdto);

        // END UOC
         setNextDTO(outdto);
        return outdto.getForward();
    }



}
