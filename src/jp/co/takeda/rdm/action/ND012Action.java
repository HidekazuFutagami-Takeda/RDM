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
import jp.co.takeda.rdm.dto.ND012DTO;
import jp.co.takeda.rdm.dto.ND303DTO;
import jp.co.takeda.rdm.exception.InvalidRequestException;
import jp.co.takeda.rdm.service.ND012Service;
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
@Named("nD012Action")
@Scope("request")
public class ND012Action extends BaseAction<ND012DTO> {

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
    private ND012Service nD012Service;
    // 確認画面用にする
    private ND303DTO paramDto;
    // START UOC
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND012Action() {
        dto = new ND012DTO();
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
        BaseDTO outdto = nD012Service.init(dto);
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
        String title = "ND012_医師情報更新";
        //ユーザ権限
        String jokenSetCd = dto.getLoginJokenSetCd();

        dto.setTitle(title);

        String preScreenId = loginInfo.getPreScreenId();
        String reqId = dto.getReqId();
        String docNo = dto.getTkdDocNo();
//TODO
        //モック
        //preScreenId = "NC011";
        preScreenId = dto.getPreScreenId();

        dto.setPreScreenId(preScreenId);

        // 遷移パターン　1:武田医師から作成、2：申請データあり
        // 武田医師コード　ありなしで分岐
        // ND001_医師検索
        if ("ND001".equals(preScreenId)) {
        	if (docNo != null && docNo.length() > 0) {
        		// ULT医師コードで初期データ作成
        		dto.setDisplayKbn("1");
        	} else { //遷移エラー
        		throw new InvalidRequestException();
        	}
        }else {
        	// 申請ID
        	// NC011_申請一覧
        	// ND303_医師情報更新 - 申請内容確認
        	// NM101_通知内容詳細
        	if ("NC011".equals(preScreenId) || "ND303".equals(preScreenId) || "NM101".equals(preScreenId)) {
        		if (reqId != null && reqId.length() > 0) {
        			// 申請データ（一時保存含む）を参照
        			dto.setDisplayKbn("2");
        		} else {
        			if("ND303".equals(preScreenId)) {
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
        sessionMap.put(AppConstant.SESKEY_ND012_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD012Service.register(dto);
//        if (outdto instanceof ND012DTO) {
//            // START UOC
////            outdto = nD012Service.register(dto);
//            // END UOC
//        }
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
            setJumpInfo(dto.getMsgId());
        }
        // END UOC
        // buttonflgで初期表示＋メッセージ表示の処理か、確認画面遷移の処理する
        //"9" = 登録完了
        if ("9".equals(dto.getButtonFlg())) {
            // 登録完了画面へ遷移
            setJumpInfo();
            outdto.setForward("ND303Init");
            //画面状況フラグを初期化
            dto.setMsgId("");
            dto.setButtonFlg("");
        }
        if ("8".equals(dto.getButtonFlg())) {
            // どうにかして画面を閉じる

        }
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 登録終了画面へ遷移用パラメータ設定。
     * @param dto 登録完了画面DTO
     */
    private void setJumpInfo() {
        // メッセージオブジェクト取得
//        LoginInfo loginInfo = (LoginInfo) BaseInfoHolder.getUserInfo();

        paramDto = new ND303DTO();
        // ブラウザタイトルと画面タイトル
//        paramDto.setBrowerTitle("ND303_医師情報更新 - 申請内容確認");
        paramDto.setTitle("ND303_医師情報更新 - 申請内容確認");
        paramDto.setReqId(dto.getReqId());
//        // 戻るリンク1(表示文言)
//        paramDto.setReturnLinkNm1("ND012_医師新規作成画面へ戻る");
//        // 戻るリンク1(遷移先URL)
//        paramDto.setReturnLinkURL1("ND012Init");

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
        paramDto = new ND303DTO();
        paramDto.setTitle("ND303_医師情報更新 - 申請内容確認");
        paramDto.setReqId(dto.getReqId());


        ND012DTO searchKey = (ND012DTO)sessionMap.get(AppConstant.SESKEY_ND012_SEARCHKEY);
        searchKey.setReqId(dto.getReqId());
        sessionMap.put(AppConstant.SESKEY_ND012_SEARCHKEY, searchKey);
    }

}
