/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2313, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.ND313DTO;
import jp.co.takeda.rdm.entity.join.TRdmReqKnrEntity;
import jp.co.takeda.rdm.service.ND313Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * Actionクラス
 * @generated
 */
@Named("ND313Action")
@Scope("request")
public class ND313Action extends BaseAction<ND313DTO> {

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
    private ND313Service nD313Service;
    // 確認画面用
    @Getter
    @Setter
    private NC101DTO paramDto;

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
    public ND313Action() {
        dto = new ND313DTO();
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

        BaseDTO outdto = dto;

        dto.setTitle("ND313_医師勤務先追加 - 申請内容確認");

        dto.setMsgStr(null);

      	 String tmpMsgStr = null;

        //【仮】権限判別
      //ログインユーザー情報格納
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        //ユーザー
        if (loginInfo.getJokenSetCd() == "0") {
        	dto.setJokenSetCd("0");
        }
        //管理者
        if (loginInfo.getJokenSetCd() == "1") {
        	dto.setJokenSetCd("1");
        	dto.setLoginJgiNo(loginInfo.getJgiNo());
        }

        //申請者所属エリアセット
    	dto.setReqDistCode(loginInfo.getBrCode());
    	//申請者所属リージョンセット
    	dto.setBrCode(loginInfo.getBrCode());
    	//申請者セット
    	dto.setJgiName(loginInfo.getJgiName());

    	dto.setMsgStr(null);

		if(loginInfo.getJokenFlg() == "1") {
			if(StringUtils.isEmpty(dto.getUltDocNo())) {
				dto.setFbReqFlg(false);//ULTと紐付けが無い場合は初期値OFF
			} else {
				dto.setFbReqFlg(true);//ULTありは初期値ON
			}
		}
        String reqSts = dto.getReqStsCd();
      //申請ステータスが保存済み、初回登録以外の場合
        if (!Objects.equals(reqSts,"01")) {
        	if (!StringUtils.isEmpty(reqSts)) {
        		outdto = nD313Service.init(dto);
                return initNext(outdto);
        	}
        }

        if (!StringUtils.isEmpty(reqSts)) {
        	if (!Objects.equals(reqSts,"01")) {
        		outdto = nD313Service.init(dto);
                return initNext(outdto);
        	}
        }


    	// F層呼び出し
       outdto = nD313Service.initReq(dto);
       outdto = nD313Service.init(dto);

       dto.setReqId(dto.getParamReqId());
       dto.setParamDocNo(null);

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
    	sessionMap.put(AppConstant.SESKEY_ND313_SEARCHKEY, outdto);

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
        BaseDTO outdto = nD313Service.register(dto);

        if (Objects.deepEquals(dto.getErrorCheckFlg(), "1")) {
      		 tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W008).replace("項目名", "医師コード、施設コード") + "\n";//重複する申請が行われています。（施設名）
      	}
        if (Objects.deepEquals(dto.getErrorCheckFlg(), "2")) {
     		 tmpMsgStr += loginInfo.getMsgData(RdmConstantsData.W026) + "\n";//却下の場合はコメントを入力してください。
     	}
        dto.setMsgStr(tmpMsgStr);
		// エラーがある場合親画面へ遷移.
		if (!StringUtils.isEmpty(dto.getMsgStr())) {
			dto.setTitle("ND313_医師勤務先削除-申請内容確認");
			outdto.setForward("ND313");
			dto.setErrorCheckFlg("");
			return initNext(outdto);
		}
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

    	if("NC101".equals(dto.getForward())) {
        	setJumpInfo(dto.getProcessFlg());
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
        paramDto.setTitle("医師勤務先削除");
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
