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
import jp.co.takeda.rdm.dto.ND105DTO;
import jp.co.takeda.rdm.dto.ND315DTO;
import jp.co.takeda.rdm.exception.InvalidRequestException;
import jp.co.takeda.rdm.service.ND105Service;
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
@Named("nD105Action")
@Scope("request")
public class ND105Action extends BaseAction<ND105DTO> {

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
    private ND105Service nD105Service;
    // 確認画面用にする
    private ND315DTO paramDto;
    // START UOC
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND105Action() {
        dto = new ND105DTO();
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
        BaseDTO outdto = nD105Service.init(dto);
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
//            ND105DTO searchKey = (ND105DTO)sessionMap.get(AppConstant.SESKEY_ND105_SEARCHKEY);
//            BeanUtils.copyProperties(dto, searchKey);
//
//        } else if (!dto.getBackScreenId().startsWith("JKR030C0")) {
//            //前画面から組織関連パラメータ設定
//            setSosInfo(sessionMap, dto);
//        }

//        dto.setStatus("FirstTab");

//        dto.setActionMtKbn("1");
      //画面タイト制御処理
        String title = "ND105_医師削除";
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

        // 遷移パターン　0:完全新規、1:ULTから作成、2：申請データあり
        // ULTT医師コード　ありなしで分岐
        // ND013_医師勤務先情報更新
        if ("ND013".equals(preScreenId)) {
        	if (docNo != null && docNo.length() > 0) {
        		// 医師コードで初期データ作成
        		dto.setDisplayKbn("1");
        	} else { //遷移エラー
        		throw new InvalidRequestException();
        	}
        }else {
        	// 申請ID
        	// NC011_申請一覧
        	// ND315_医師削除 - 申請内容確認
        	// NM101_通知内容詳細
        	if ("NC011".equals(preScreenId) || "ND315".equals(preScreenId) || "NM101".equals(preScreenId)) {
        		if (reqId != null && reqId.length() > 0) {
        			// 申請データ（一時保存含む）を参照
        			dto.setDisplayKbn("2");
        		} else {
        			if("ND315".equals(preScreenId)) {
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
        sessionMap.put(AppConstant.SESKEY_ND105_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD105Service.register(dto);
        if (outdto instanceof ND105DTO) {
            // START UOC
//            outdto = nD105Service.register(dto);
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
            setJumpInfo(dto.getMsgId());
//            outdto.setForward("JKR090C020Init");
        }
        // END UOC
        // buttonflgで初期表示＋メッセージ表示の処理か、確認画面遷移の処理する
        //"9" = 登録完了
        if ("9".equals(dto.getButtonFlg())) {
            // 登録完了画面へ遷移
            setJumpInfo();
            outdto.setForward("ND315Init");
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

        paramDto = new ND315DTO();
        // ブラウザタイトルと画面タイトル
//        paramDto.setBrowerTitle("ND315_医師削除 - 申請内容確認");
        paramDto.setTitle("ND315_医師削除 - 申請内容確認");
        paramDto.setReqId(dto.getReqId());
//        // 戻るリンク1(表示文言)
//        paramDto.setReturnLinkNm1("ND105_医師削除画面へ戻る");
//        // 戻るリンク1(遷移先URL)
//        paramDto.setReturnLinkURL1("ND105Init");

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
        paramDto = new ND315DTO();
//        // ブラウザタイトル
//        paramDto.setBrowerTitle ("担当引継ぎ"+ subTitle);
//        // 画面タイトル
//        paramDto.setTitle("担当引継ぎ"+ subTitle);
//        // 戻るリンク(表示文言)
//        paramDto.setReturnLinkNm1("戻る");
//        // 戻るリンク(遷移先URL)
//        paramDto.setReturnLinkURL1("ND105Init");
//        // メッセージ１
//        paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I0122706));
//        paramDto.setMessage3(loginInfo.getMsgEntity(msgId));

        ND105DTO searchKey = (ND105DTO)sessionMap.get(AppConstant.SESKEY_ND105_SEARCHKEY);
        searchKey.setReqId(dto.getReqId());
        sessionMap.put(AppConstant.SESKEY_ND105_SEARCHKEY, searchKey);
    }

}
