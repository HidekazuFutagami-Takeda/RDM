/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2103, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.DAO;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.NC101DTO;
import jp.co.takeda.rdm.dto.ND103DTO;
import jp.co.takeda.rdm.service.ND103Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import lombok.Getter;
import lombok.Setter;

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
 // 確認画面用
    @Getter
    @Setter
    private NC101DTO paramDto;

    /**
     * DAOインスタンス
     * @generated
     */
    @Inject
    protected DAO dao;

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

        BaseDTO outdto = dto;

        dto.setTitle("ND103_医師勤務先追加");

        String preScreenId = dto.getBackScreenId();
        if("ND103".equals(preScreenId) || "ND311".equals(preScreenId)) {
        	preScreenId = dto.getPreScreenId();
        } else {
        	dto.setPreScreenId(preScreenId);
        }

        //エラーメッセージが定義されている場合
//        if (!StringUtils.isEmpty(dto.getMsgStr())) {
//        	outdto = nD103Service.pullDown(dto);
//            return initNext(outdto);
//        }

        if(!"ND311".equals(dto.getBackScreenId())) {
		    //【仮】権限判別
		    //ログインユーザー情報格納
		    LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		    // 現在日付を取得
		    Date systemDate = DateUtils.getNowDate();
		    SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		    String sysDate = fmtDate.format(systemDate);

		    dto.setLoginJgiNo(loginInfo.getJgiNo());
	        dto.setLoginJokenSetCd(loginInfo.getJokenSetCd());
	        dto.setLoginBrCd(loginInfo.getBrCode());
	        dto.setLoginDistCd(loginInfo.getDistCode());
	        dto.setLoginNm(loginInfo.getJgiName());
	        dto.setLoginShzNm(loginInfo.getBumonRyakuName());
	        dto.setLoginTrtCd(loginInfo.getTrtCd());

		    //ユーザー
		    if (loginInfo.getJokenSetCd() == "0") {
		    	dto.setJokenSetCd("0");
		    }
		    //管理者
		    if (loginInfo.getJokenSetCd() == "1") {
		    	dto.setJokenSetCd("1");
		    }

		    dto.setLoginJgiNo(loginInfo.getJgiNo());
		    //申請者所属エリアセット
			dto.setReqDistCode(loginInfo.getDistCode());
			//申請者所属リージョンセット
			dto.setBrCode(loginInfo.getBrCode());
			//申請者セット
			dto.setJgiName(loginInfo.getJgiName());

			dto.setMsgStr(null);

			if(StringUtils.isEmpty(dto.getParamReqId())) {
				dto.setParamReqId(dto.getReqId());
			}

		    //一時保存押下の場合
		     if (Objects.deepEquals(dto.getSaveButtonFlg(), "1")) {
		    	 dto.setSaveButtonFlg("0");

				//エラーチェック
				int i = dto.getReqComment().length();
				if (i > 100) {//申請コメント文字数が300文字以上の場合
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);// 最大文字数を超えています。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "申請コメント");

		    		if(errChk) {//エラーありなのでメッセージをセットする
		    			dto.setMsgStr(tmpMsgStr);
		    		}
				}
				else {//エラーがない場合更新処理へ
					nD103Service.save(dto);
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.I005);//保存メッセージ
					dto.setSaveButtonFlg("0");
					dto.setMsgStr(tmpMsgStr);
				}
		    }

			    //審査完了押下の場合
		     if (Objects.deepEquals(dto.getShnCompButtonFlg(), "1")) {
		    	 dto.setShnCompButtonFlg("0");

				//エラーチェック
				int i = dto.getAprMemo().length();
				if (i > 100) {//申請メモ文字数が300文字以上の場合
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);// 最大文字数を超えています。（項目名）
					tmpMsgStr = tmpMsgStr.replace("項目名", "審査・承認メモ");

		    		if(errChk) {//エラーありなのでメッセージをセットする
		    			dto.setMsgStr(tmpMsgStr);
		    		}
				}
				else {//エラーがない場合更新処理へ
					nD103Service.shnComp(dto);
					dto.setShnFlg("1");
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.I008);//保存メッセージ
					dto.setShnCompButtonFlg("0");
					dto.setMsgStr(tmpMsgStr);
				}
		    }
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
        } else {
        	dto.setFormTekiyoYmd(dto.getFormTekiyoYmd().replace("/", "-"));

    		// 編集可能判定
            if("".equals(dto.getReqStsCd()) || dto.getReqStsCd() == null) {
            	// 完全新規(申請管理．申請ステータスが取得できない)の場合は活性
            	dto.setEditApprFlg("1");
            } else if(!RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(dto.getReqStsCd())) {
            	// MR権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)以外の場合は、入力項目はすべて変更不可（非活性）とする
            	dto.setEditApprFlg("0");
            } else if(RdmConstantsData.RDM_JKN_ADMIN.equals(loginInfo.getJokenSetCd()) && !"01".equals(dto.getReqStsCd()) && !"11".equals(dto.getReqStsCd())
            			&& !"03".equals(dto.getReqStsCd()) && !"13".equals(dto.getReqStsCd())) {
            	// 管理者権限の場合、取得した申請管理．申請ステータスが'01'(保存済み)、'03'(承認待ち)、'13'(ULT承認待ち)以外の場合は、入力項目はすべて変更不可（非活性）とする
            	dto.setEditApprFlg("0");
            } else {
            	dto.setEditApprFlg("1");
            }
        }

        outdto = nD103Service.pullDown(dto);
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

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String cancel() throws Exception {
        cancelSetup();
        // F層呼び出し
        BaseDTO outdto = nD103Service.cancel(dto);
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

        // END UOC
        setNextDTO(outdto);

        setJumpInfo(RdmConstantsData.I016);
        //完了画面へ遷移
        outdto.setForward("NC101");
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
		paramDto.setTitle("医師勤務先追加");
		// メッセージ１
		if (msgId.equals(RdmConstantsData.I016)) {//I016	一時保存データを破棄しました。
			paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I016));
		}
	}
}
