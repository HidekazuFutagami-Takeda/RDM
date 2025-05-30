/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.util.Objects;

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
import jp.co.takeda.rdm.dto.ND013DTO;
import jp.co.takeda.rdm.service.ND013Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;

/**
 * Actionクラス
 * @generated
 */
@Named("ND013Action")
@Scope("request")
public class ND013Action extends BaseAction<ND013DTO> {

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
    private ND013Service nD013Service;

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
    public ND013Action() {
        dto = new ND013DTO();
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
        dto.setTabFlg("X");
        //【仮】権限判別
      //ログインユーザー情報格納
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        //親画面から医師固定Cを受け取る

        if (RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd())) {
        	//管理者
        	dto.setJokenSetCd("1");
        } else {
        	//MR権限
        	dto.setJokenSetCd("0");
        }

        dto.setMsgStr(null);
        //エラーチェック フラグが立っていいる場合
        if (!Objects.equals(dto.getErrorCheckFlg(), "0")) {
        	// F層呼び出し

            BaseDTO outdto = nD013Service.errorCheck(dto);

            if (!dto.isErrorBool()) {
            	//メッセージを定義
        		errChk = true;

        		//「勤務先追加」のエラーの場合
        		if (Objects.equals(dto.getErrorCheckFlg(), "1")) {
        			dto.setButtonFlg("1");
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W038);//
        			//ダイアログメッセージ定義
//        			dto.setDialog(tmpMsgStr);
//        			dto.setTabFlg(dto.getErrorCheckFlg());
           			dto.setMsgStr(tmpMsgStr);
        		}
        		//「医師の廃業・死亡」のエラーの場合
        		if (Objects.equals(dto.getErrorCheckFlg(), "2")) {
        			//dto.setButtonFlg("1");
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W038);//
//        			//ダイアログメッセージ定義
//        			dto.setDialog(tmpMsgStr);
//        			//エラーなしならタブ遷移フラグをセットしonloadに渡す
//                	dto.setTabFlg(dto.getErrorCheckFlg());
        			dto.setMsgStr(tmpMsgStr);
        		}

        		//「勤務先削除」の重複申請チェックエラーの場合
        		if (Objects.equals(dto.getErrorCheckFlg(), "31")) {
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード");// 重複する申請が行われています。（医師コード）
        			dto.setMsgStr(tmpMsgStr);
        		}
        		//「勤務先削除」の勤務先0件チェックエラーの場合
        		if (Objects.equals(dto.getErrorCheckFlg(), "32")) {
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W030);// 勤務先が0件になるため申請できません。
        			dto.setMsgStr(tmpMsgStr);
        		}

        		//「勤務先情報更新」のエラーの場合
        		if (Objects.equals(dto.getErrorCheckFlg(), "4")) {
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード");// 重複する申請が行われています。（医師コード）。
        			dto.setMsgStr(tmpMsgStr);
        		}
        		//「医療機関への異動」のエラーの場合
        		if (Objects.equals(dto.getErrorCheckFlg(), "5")) {
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード");// 重複する申請が行われています。（医師コード）
        			dto.setMsgStr(tmpMsgStr);
        		}
        		//「医療機関以外への異動」のエラーの場合
        		if (Objects.equals(dto.getErrorCheckFlg(), "6")) {
        			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード");// 重複する申請が行われています。（医師コード）
        			dto.setMsgStr(tmpMsgStr);
        		}
            } else {
            	//エラーなしならタブ遷移フラグをセットしonloadに渡す
            	dto.setTabFlg(dto.getErrorCheckFlg());
            }
        }

        // F層呼び出し
        BaseDTO outdto = nD013Service.init(dto);

        return initNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void initSetup() throws Exception {
        // START UOC
    	String title = "ND013_医師勤務先情報更新";
        dto.setTitle(title);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
    	// 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_ND013_SEARCHKEY, outdto);
    	//検索一覧非表示
    	dto.setSearchType("0");
        // END UOC
         setNextDTO(outdto);
        return outdto.getForward();
    }



}
