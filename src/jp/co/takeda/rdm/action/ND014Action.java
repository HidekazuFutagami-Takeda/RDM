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

import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.ND014DTO;
import jp.co.takeda.rdm.dto.ND305DTO;
import jp.co.takeda.rdm.exception.InvalidRequestException;
import jp.co.takeda.rdm.service.ND014Service;
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
@Named("nD014Action")
@Scope("request")
public class ND014Action extends BaseAction<ND014DTO> {

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
    private ND014Service nD014Service;
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
    public ND014Action() {
        dto = new ND014DTO();
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
        BaseDTO outdto = nD014Service.init(dto);
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
        String title = "ND014_医師復活";
        //ユーザ権限
        String jokenSetCd = dto.getLoginJokenSetCd();

        dto.setTitle(title);

        String preScreenId = dto.getBackScreenId();
        String reqId = dto.getReqId();
        String docNo = dto.getTkdDocNo();
//TODO
        //モック
        if(preScreenId.equals("NC001")) {
        	preScreenId = dto.getPreScreenId();
        }

        dto.setPreScreenId(preScreenId);

        // 遷移パターン　0:完全新規、1:ULTから作成、2：申請データあり
        // ULTT医師コード　ありなしで分岐
        // ND001_医師検索
        if ("ND001".equals(preScreenId)) {
        	if (docNo != null && docNo.length() > 0) {
        		// 医師コードで初期データ作成
        		dto.setReqId("");
        		dto.setDisplayKbn("1");
        	} else { //遷移エラー
        		throw new InvalidRequestException();
        	}
        }else {
        	// 申請ID
        	// NC011_申請一覧
        	// ND305_医師復活 - 申請内容確認
        	// NM101_通知内容詳細
        	if ("NC011".equals(preScreenId) || "ND305".equals(preScreenId) || "NM101".equals(preScreenId)) {
        		if (reqId != null && reqId.length() > 0) {
        			// 申請データ（一時保存含む）を参照
        			dto.setDisplayKbn("2");
        		} else {
        			if("ND305".equals(preScreenId)) {
        				//一時保存なし申請後に確認画面から遷移
        				dto.setDisplayKbn("9");
        			}else {//遷移エラー
        				throw new InvalidRequestException();
        			}
        		}
        	}else {//遷移エラー
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
        sessionMap.put(AppConstant.SESKEY_ND014_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD014Service.register(dto);
        if (outdto instanceof ND014DTO) {
            // START UOC
//            outdto = nD014Service.register(dto);
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
//        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();
//        String preScreenId = loginInfo.getPreScreenId();
//
//        dto.setPreScreenId(preScreenId);
    }

    /**
     * 後処理
     * @customizable
     */
    protected String registerNext(BaseDTO outdto) throws Exception {
        // START UOC
        if (!RdmConstantsData.E003.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !"exception".equals(outdto.getForward())){
//            setJumpInfo(dto.getMsgId());
        }
        // END UOC
        // buttonflgで初期表示＋メッセージ表示の処理か、確認画面遷移の処理する
        //"9" = 登録完了
        if ("9".equals(dto.getButtonFlg())) {
            // 登録完了画面へ遷移
            setJumpInfo();
            outdto.setForward("ND305Init");
            //画面状況フラグを初期化
            dto.setMsgId("");
            dto.setButtonFlg("");
        }
        if ("8".equals(dto.getButtonFlg())) {//破棄の場合
            // 完了画面へ遷移
        	setJumpInfo(RdmConstantsData.I016);
        	outdto.setForward("NC101Init");
        }
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 登録終了画面へ遷移用パラメータ設定。
     * @param dto 登録完了画面DTO
     */
    private void setJumpInfo() {

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

        //画面タイトル内容設定
        paramDto = new NC101DTO();
//      // ブラウザタイトル
//      paramDto.setBrowerTitle ("ND014_医師復活");
      // 画面タイトル
      paramDto.setTitle("医師復活");
//      // 戻るリンク(表示文言)
//      paramDto.setReturnLinkNm1("医師検索画面へ");
//      // 戻るリンク(遷移先URL)
//      paramDto.setReturnLinkURL1("ND001Init");
      // メッセージ１
      if (msgId.equals(RdmConstantsData.I016)) {//I016	一時保存データを破棄しました。
          paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I016));
      }

//        ND014DTO searchKey = (ND014DTO)sessionMap.get(AppConstant.SESKEY_ND014_SEARCHKEY);
//        searchKey.setReqId(dto.getReqId());
//        sessionMap.put(AppConstant.SESKEY_ND014_SEARCHKEY, searchKey);
    }

}
