/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.action;

import java.text.SimpleDateFormat;
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
//import jp.co.takeda.rdm.dto.JKR040C010DTO;
import jp.co.takeda.rdm.dto.NM001DTO;
import jp.co.takeda.rdm.exception.InvalidRequestException;
import jp.co.takeda.rdm.service.NM001Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;

import org.springframework.context.annotation.Scope;

/**
 * Actionクラス
 * @generated
 */
@Named("nM001Action")
@Scope("request")
public class NM001Action extends BaseAction<NM001DTO> {

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
    private NM001Service NM001Service;

    // START UOC


  //ログインユーザ情報取得
      LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

      boolean errChk = false;
  	String msgStr = "";
  	String tmpMsgStr = "";
  	int len = 0;
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public NM001Action() {
        dto = new NM001DTO();
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
//    public String before() throws Exception {
//        // START UOC
//    	dto.setMsgId(null);
//dto.setMsgStr(null);
//        return null;
//        // END UOC
//        // START UOC
//    }


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
        BaseDTO outdto = NM001Service.init(dto);
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
//            ND011DTO searchKey = (ND011DTO)sessionMap.get(AppConstant.SESKEY_ND011_SEARCHKEY);
//            BeanUtils.copyProperties(dto, searchKey);
//
//        } else if (!dto.getBackScreenId().startsWith("JKR030C0")) {
//            //前画面から組織関連パラメータ設定
//            setSosInfo(sessionMap, dto);
//        }

//        dto.setStatus("FirstTab");

//        dto.setActionMtKbn("1");
      //画面タイト制御処理
        String title = "NM001_申請サマリ";
        //ユーザ権限
//        String jokenSetCd = dto.getLoginJokenSetCd();
//
        dto.setTitle(title);

        String preScreenId = loginInfo.getPreScreenId();
//        String reqId = dto.getReqId();
//        String ultNo = dto.getUltDocNo();
//TODO
        //モック
        //preScreenId = "NC011";
        preScreenId = dto.getPreScreenId();

        dto.setPreScreenId(preScreenId);

        // 遷移パターン　0:完全新規、1:ULTから作成、2：申請データあり
        // ULTT医師コード　ありなしで分岐
        // ND001_医師検索
        //管理者：0　MR：１
        if ("ND001".equals(preScreenId)||loginInfo.getJokenFlg().equals("1")) {
        	//何もしない
        }else {
        		throw new InvalidRequestException();
        }

//        dto.setMsgId(null);

        // END UOC
    }
    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String sort() throws Exception {
        pageSetup();
        // F層呼び出し
        BaseDTO outdto = NM001Service.sort(dto);
//        if (outdto instanceof JKR040C010DTO) {
//            // START UOC
//
//            // END UOC
//        }
        return sortNext(outdto);
    }

    /**
     * 後処理
     * @customizable
     */
    protected String sortNext(BaseDTO outdto) throws Exception {
        // START UOC
        sessionMap.put(AppConstant.SESKEY_NM001_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 後処理
     * @customizable
     */
    protected String initNext(BaseDTO outdto) throws Exception {
        // START UOC
    	// 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_NM001_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

    /**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String search() throws Exception {
    	BaseDTO outdto = dto;
    	searchSetup();
        // F層呼び出し
    	outdto = NM001Service.search(dto);

    	//日付チェック
    	if (Objects.equals(dto.getBoolKnb(), "1")) {
    		errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);// 終了日は開始日以降を選択してください。
    		if(errChk) {//エラーありなのでメッセージをセットする
    			dto.setMsgStr(tmpMsgStr);
    		}
    		//入力された日付を保持
    		dto.setInreqYmdhmsFrom(dto.getReqYmdhmsFrom());
    		dto.setInreqYmdhmsTo(dto.getReqYmdhmsTo());

    		//return searchNext(dto);
    		//return outdto.getForward();
    	}

    	//検索結果にエラーがある場合
    	if (Objects.equals(dto.getBoolKnb(), "2")){//エラーありなのでメッセージをセットする
    		tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);// 検索結果が表示上限を超えています。検索条件を絞って再検索してください。。
    		//エラーメッセージをdtoに格納
    		dto.setMsgStr(tmpMsgStr);
    		//return outdto.getForward();
    	}


        if (outdto instanceof NM001DTO) {
            // START UOC

            // END UOC
        }
        return searchNext(outdto);
    }

    /**
     * 前処理
     * @customizable
     */
    protected void searchSetup() throws Exception {
        // START UOC

        // END UOC
    }

    /**
     * 後処理
     * @customizable
     */
    protected String searchNext(BaseDTO outdto) throws Exception {
        // START UOC
        // 検索条件をセッションに格納する（ページャ押下時に使用）
    	sessionMap.put(AppConstant.SESKEY_NM001_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

	/**
     * 業務処理
     * @customizable
     */
    @InputConfig(methodName="validationError")
    public String page() throws Exception {
        pageSetup();
        // F層呼び出し
        BaseDTO outdto = NM001Service.page(dto);
        if (outdto instanceof NM001DTO) {            // START UOC
//        	// チェック済み再設定
//        	NM001DTO dto = (NM001DTO)outdto;
//        	String[] cdcCheckedCodes = dto.getCdcCheckedCodes();
//        	for (String data : cdcCheckedCodes) {
//        		String depCd = data.split(",", -1)[0];
//        		for (CatDeptsComboDataList catDeptsComboDataList : dto.getCatDeptsComboDataList()) {
//        			if (catDeptsComboDataList.getDeptCode().equals(depCd)) {
//        				catDeptsComboDataList.setCheckers(true);
//        			}
//        		}
//            }

            // END UOC
        }
        return pageNext(outdto);
    }

	/**
     * 前処理
     * @customizable
     */
    protected void pageSetup() throws Exception {
        // START UOC
    	this.setSearchCon();
        NM001DTO searchKey = (NM001DTO)sessionMap.get(AppConstant.SESKEY_NM001_SEARCHKEY);
        // 所属部科名カナ
//        dto.setKensakuKana(searchKey.getKensakuKana());
//        // 入力_所属部科名漢字
//        dto.setKensakuKanj(searchKey.getKensakuKanj());
//
//        // END UOC
    }

	/**
     * 後処理
     * @customizable
     */
    protected String pageNext(BaseDTO outdto) throws Exception {
        // START UOC
    	sessionMap.put(AppConstant.SESKEY_NM001_SEARCHKEY, outdto);
        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }
    private void setSearchCon() {

    }
}
