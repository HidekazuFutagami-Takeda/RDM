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

import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.ND501DTO;
import jp.co.takeda.rdm.service.ND501Service;
import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.RdmConstantsData;

/**
 * Actionクラス
 * @generated
 */
@Named("ND501Action")
@Scope("request")
public class ND501Action extends BaseAction<ND501DTO> {

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
    private ND501Service nD501Service;

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
    public ND501Action() {
        dto = new ND501DTO();
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

        dto.setTitle("ND501_医師変更履歴");

        //ログインユーザー情報
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

        //権限判別
        if (Objects.equals(loginInfo.getJokenSetCd(), "JKN0023")) {//ユーザー権限の場合
        	dto.setJokenSetCd("0");
        	dto.setMrTrtCd(loginInfo.getTrtCd());//従業員番号
        	dto.setMrJgiNo(loginInfo.getJgiNo());//領域コード
        	dto.setMrBrCode(loginInfo.getBrCode());//医薬支店C(申請者所属リージョン)
        	dto.setMrDistCode(loginInfo.getDistCode());//医薬営業所コード(申請者所属エリア)
        	dto.setLoginJokenSetCd("JKN0023");
        }
        else {//管理者権限の場合
        	dto.setJokenSetCd("1");
        	dto.setLoginJokenSetCd("JKN0850");
        }

        // F層呼び出し
        dto.setFunctionId("Init");
        BaseDTO outdto = nD501Service.init(dto);

//        dto.setSelectListChange("0");
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
    	sessionMap.put(AppConstant.SESKEY_ND501_SEARCHKEY, outdto);
    	//検索一覧非表示
    	dto.setSearchType("0");
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

    	BaseDTO outdto;

    	dto.setFunctionId("Search");
        searchSetup();

      //プルダウン・日付データ一覧取得
        outdto = nD501Service.pharmTypeList(dto);

        //ログインユーザ情報取得
        LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

      //入力された日付を保持
		dto.setUpdMstFrom(dto.getKensakuUpdMstFrom());
		dto.setUpdMstTo(dto.getKensakuUpdMstTo());

        //必須検索条件が未入力の場合
        if (StringUtils.isEmpty(dto.getKensakuDocKanj()) &&
        		StringUtils.isEmpty(dto.getKensakuDocKana()) &&
        		StringUtils.isEmpty(dto.getKensakuDocType()) &&
        		StringUtils.isEmpty(dto.getKensakuDocNo()) &&
        		StringUtils.isEmpty(dto.getKensakuUltDocNo()) &&
        		StringUtils.isEmpty(dto.getKensakuDocAttribute()) &&
        		StringUtils.isEmpty(dto.getKensakuMedSch()) &&
        		StringUtils.isEmpty(dto.getKensakuGradYear()) &&
        		StringUtils.isEmpty(dto.getKensakuHuniv()) &&
        		StringUtils.isEmpty(dto.getKensakuSTantouBrCode()) &&
        		dto.getKensakuJgiNo() == 0 &&
        		StringUtils.isEmpty(dto.getKensakuShinseiBrCode()) &&
        		StringUtils.isEmpty(dto.getKensakuInsNo()) &&
        		StringUtils.isEmpty(dto.getKensakuInsKanj()) &&
        		StringUtils.isEmpty(dto.getKensakuReqJgiName()) &&
        		StringUtils.isEmpty(dto.getKensakuUpdMstFrom()) &&
        		StringUtils.isEmpty(dto.getKensakuUpdMstTo())
        		) {

			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W001);// 検索条件を入力してください。
    		if(errChk) {//エラーありなのでメッセージをセットする
    			dto.setMsgStr(tmpMsgStr);
    		}

    		dto.setSearchType("0");
    		return outdto.getForward();
        }


        // SimpleDateFormatで日付フォーマット設定
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //日付チェック 開始日が終了日より後の場合
        if (!StringUtils.isEmpty(dto.getKensakuUpdMstFrom()) &&
        		!StringUtils.isEmpty(dto.getKensakuUpdMstTo()) &&
        		!sdf.parse(dto.getKensakuUpdMstFrom()).before(sdf.parse(dto.getKensakuUpdMstTo()))) {
        	errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);// 終了日は開始日以降を選択してください。
    		if(errChk) {//エラーありなのでメッセージをセットする
    			dto.setMsgStr(tmpMsgStr);
    		}
    		//検索部を非表示
    		dto.setSearchType("0");
    		return outdto.getForward();
		}

        //リストがnullの場合
        if (dto.getSelectListChange() == null) {
        	dto.setSelectListChange("0");
        }

        dto.setKensakuBool(true);

    	//検索処理
    	outdto = nD501Service.search(dto);

        //検索結果にエラーがある場合
		if(!dto.isKensakuBool()) {//エラーありなのでメッセージをセットする
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W002);// 検索結果が表示上限を超えています。検索条件を絞って再検索してください。。
			//エラーメッセージをdtoに格納
			dto.setMsgStr(tmpMsgStr);
			dto.setSearchType("0");
			return outdto.getForward();
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
    	sessionMap.put(AppConstant.SESKEY_ND501_SEARCHKEY, outdto);
    	//検索一覧非表示
    	dto.setSearchType("1");
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
        BaseDTO outdto = nD501Service.page(dto);
        outdto = nD501Service.search(dto);
        if (outdto instanceof ND501DTO) {
        	// START UOC
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



        // END UOC
    }

	/**
     * 後処理
     * @customizable
     */
    protected String pageNext(BaseDTO outdto) throws Exception {
        // START UOC

        // END UOC
        setNextDTO(outdto);
        return outdto.getForward();
    }

}
