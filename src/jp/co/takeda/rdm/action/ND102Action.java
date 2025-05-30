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
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.ND102DTO;
import jp.co.takeda.rdm.exception.InvalidRequestException;
import jp.co.takeda.rdm.service.ND102Service;

/**
 * Actionクラス
 * @generated
 */
@Named("nD102Action")
@Scope("request")
public class ND102Action extends BaseAction<ND102DTO> {

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
    private ND102Service nD102Service;
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
    public ND102Action() {
        dto = new ND102DTO();
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
        BaseDTO outdto = nD102Service.init(dto);
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
    	String reqId = dto.getReqId();
    	//モック
//    	loginInfo.setJokenFlg("1");
//    	loginInfo.setJgiNo(8830034);
//    	loginInfo.setJgiName("テスト");
    	preScreenId = dto.getBackScreenId();
    	if(preScreenId == null) {
    		preScreenId = dto.getPreScreenId();
    	}
    	//検証用 TODO
    	if(preScreenId.equals("NC001")) {
    		preScreenId = dto.getPreScreenId();
    	}

    	dto.setPreScreenId(preScreenId);
        dto.setLoginJgiNo(loginInfo.getJgiNo());
        dto.setLoginJokenSetCd(loginInfo.getJokenSetCd());

		// 遷移パターン 0:施設-医師コードから作成、1:申請データあり
		// 医師勤務先情報更新
		if ("ND013".equals(preScreenId)) {
			dto.setDisplayKbn("0");
			// 申請一覧
		} else if("ND309".equals(preScreenId)) {
			//確認画面から遷移
			dto.setDisplayKbn("9");
		} else if ("NC011".equals(preScreenId)) {
			if (StringUtils.isEmpty(reqId) || reqId.equals("-")) {
			 	dto.setDisplayKbn("0");
			} else {
				dto.setDisplayKbn("1");
			}
		} else {
			throw new InvalidRequestException();
		}

		String title = "ND102_医療機関以外への異動";

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
        sessionMap.put(AppConstant.SESKEY_ND102_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD102Service.register(dto);
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
        if ("9".equals(dto.getButtonFlg())) {
            // 確認画面へ遷移
            outdto.setForward("ND309Init");
            //画面状況フラグを初期化
            dto.setButtonFlg("");
        }
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
        BaseDTO outdto = nD102Service.cancel(dto);
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
    	setJumpInfo(RdmConstantsData.I016);
    	outdto.setForward("NC101");
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
        BaseDTO outdto = nD102Service.shnComp(dto);
        outdto = nD102Service.init(dto);
        return shnCompNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void shnCompSetup() throws Exception {
        // START UOC
//        dto.setMsgId(null);
        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String shnCompNext(BaseDTO outdto) throws Exception {
    	// START UOC

    	// END UOC
    	outdto.setForward("ND102");
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
      paramDto.setTitle("医療機関以外への異動");
      // メッセージ１
      if (msgId.equals(RdmConstantsData.I016)) {//I016	一時保存データを破棄しました。
          paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I016));
      }

    }
}
