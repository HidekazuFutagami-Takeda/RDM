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

import jp.co.takeda.jkr.dto.JKR090C020DTO;
import jp.co.takeda.rdm.common.BaseAction;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.dto.ND301DTO;
import jp.co.takeda.rdm.service.ND301Service;
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
@Named("nD301Action")
@Scope("request")
public class ND301Action extends BaseAction<ND301DTO> {

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
    private ND301Service nD301Service;
    // 確認画面用にする
    private JKR090C020DTO paramDto;
    // START UOC
    // END UOC

    /**
     * コンストラクタ
     * @generated
     */
    public ND301Action() {
        dto = new ND301DTO();
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
        BaseDTO outdto = nD301Service.init(dto);
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
//            ND301DTO searchKey = (ND301DTO)sessionMap.get(AppConstant.SESKEY_ND301_SEARCHKEY);
//            BeanUtils.copyProperties(dto, searchKey);
//
//        } else if (!dto.getBackScreenId().startsWith("JKR030C0")) {
//            //前画面から組織関連パラメータ設定
//            setSosInfo(sessionMap, dto);
//        }

//        dto.setStatus("FirstTab");

//        dto.setActionMtKbn("1");
      //画面タイト制御処理
        String title = "ND301_医師新規作成 - 申請内容確認";
        //ユーザ権限
        String jokenSetCd = dto.getLoginJokenSetCd();

        dto.setTitle(title);

        String preScreenId = loginInfo.getPreScreenId();
        dto.setBackScreenId(preScreenId);
        String reqId = dto.getReqId();
        String ultNo = dto.getUltDocNo();

        //モック
        preScreenId = "ND301";

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
        sessionMap.put(AppConstant.SESKEY_ND301_SEARCHKEY, outdto);
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
        BaseDTO outdto = nD301Service.register(dto);
        if (outdto instanceof ND301DTO) {
            // START UOC
//            outdto = nD301Service.register(dto);
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
    }

    /**
     * 後処理
     * @customizable
     */
    protected String registerNext(BaseDTO outdto) throws Exception {
        // START UOC
        if (!RdmConstantsData.M0122740.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !RdmConstantsData.M0001102.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !RdmConstantsData.M0001101.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !RdmConstantsData.E003.equals(StringUtils.nvl(dto.getMsgId(),""))
                && !"exception".equals(outdto.getForward())){
            setJumpInfo(dto.getMsgId());
//            outdto.setForward("JKR090C020Init");
        }
        // END UOC
        //TODO buttonflgで初期表示＋メッセージ表示の処理か、確認画面遷移の処理する
        setNextDTO(outdto);
        return outdto.getForward();
    }

//    /**
//     * 業務処理
//     * @customizable
//     */
//    @InputConfig(methodName="validationError")
//    public String downLoad() throws Exception {
//        downLoadSetup();
//        // F層呼び出し
//        BaseDTO outdto = nD301Service.downLoad(dto);
//        return downLoadNext(outdto);
//    }

//    /**
//     * 前処理
//     * @customizable
//     */
//    protected void downLoadSetup() throws Exception {
//        // START UOC
//
//        // END UOC
//    }
//
//    /**
//     * 後処理
//     * @customizable
//     */
//    protected String downLoadNext(BaseDTO outdto) throws Exception {
//        // START UOC
//        outdto.setForward("stream");
//        // END UOC
//        setNextDTO(outdto);
//        return outdto.getForward();
//    }

//    /**
//     * 業務処理
//     * @customizable
//     */
//    @InputConfig(methodName="validationError")
//    public String sort() throws Exception {
//        sortSetup();
//        // F層呼び出し
//        BaseDTO outdto = nD301Service.sort(dto);
//        if (outdto instanceof ND301DTO) {
//            // START UOC
//
//            // END UOC
//        }
//        return sortNext(outdto);
//    }

//    /**
//     * 前処理
//     * @customizable
//     */
//    protected void sortSetup() throws Exception {
//        // START UOC
//
//        // END UOC
//    }
//
//    /**
//     * 後処理
//     * @customizable
//     */
//    protected String sortNext(BaseDTO outdto) throws Exception {
//        // START UOC
//        // 検索条件をセッションに格納する（リンク押下時に使用）
//        sessionMap.put(AppConstant.SESKEY_ND301_SEARCHKEY, outdto);
//        // END UOC
//        setNextDTO(outdto);
//        return outdto.getForward();
//    }


//    /**
//     * 業務処理
//     * @customizable
//     */
//    @InputConfig(methodName="validationError")
//    public String page() throws Exception {
//        pageSetup();
//        // F層呼び出し
//        BaseDTO outdto = nD301Service.page(dto);
//        if (outdto instanceof ND301DTO) {
//            // START UOC
//
//            // END UOC
//        }
//        return pageNext(outdto);
//    }

//    /**
//     * 前処理
//     * @customizable
//     */
//    protected void pageSetup() throws Exception {
//        // START UOC
//
//        // END UOC
//    }
//
//    /**
//     * 後処理
//     * @customizable
//     */
//    protected String pageNext(BaseDTO outdto) throws Exception {
//        // START UOC
//        // 検索条件をセッションに格納する（リンク押下時に使用）
//        sessionMap.put(AppConstant.SESKEY_ND301_SEARCHKEY, outdto);
//        // END UOC
//        setNextDTO(outdto);
//        return outdto.getForward();
//    }

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
        paramDto = new JKR090C020DTO();
        // ブラウザタイトル
        paramDto.setBrowerTitle ("担当引継ぎ"+ subTitle);
        // 画面タイトル
        paramDto.setTitle("担当引継ぎ"+ subTitle);
        // 戻るリンク(表示文言)
        paramDto.setReturnLinkNm1("戻る");
        // 戻るリンク(遷移先URL)
        paramDto.setReturnLinkURL1("ND301Init");
        // メッセージ１
        paramDto.setMessage1(loginInfo.getMsgEntity(RdmConstantsData.I0122706));
        paramDto.setMessage3(loginInfo.getMsgEntity(msgId));

        ND301DTO searchKey = (ND301DTO)sessionMap.get(AppConstant.SESKEY_ND301_SEARCHKEY);
//        searchKey.setActionMtKbn("2");
        sessionMap.put(AppConstant.SESKEY_ND301_SEARCHKEY, searchKey);
    }

    /**
     * 前画面から組織関連パラメータ設定
     * @param Dto301
     */
    public void setSosInfo(Map<String, Object> sessionMap, ND301DTO Dto301) {

//        //トップメニューで組織(現)を選択した場合
//        if ("0".equals(Dto301.getSosSelFlg())) {
//
//            // 検索条件_組織・担当（新）_テキスト
//            Dto301.setDispToSosJgiName("");
//            // 検索条件_新組織コード
//            Dto301.setSearchToSosCd("");
//            // 検索条件_組織（新）_テキスト
//            Dto301.setSearchToSosName("");
//            //検索条件_組織コード（新）（営業所）
//            Dto301.setSearchToSosCd3("");
//
//
//        //トップメニューで組織(新)を選択した場合
//        } else {
//
//            // 検索条件_組織・担当（現）_テキスト
//            Dto301.setDispFromSosJgiName("");
//            // 検索条件_現組織コード
//            Dto301.setSearchFromSosCd("");
//            // 検索条件_組織（現）_テキスト
//            Dto301.setSearchFromSosName("");
//            // 検索条件_現組織支店コード
//            Dto301.setSearchFromSosCd2("");
//            // 検索条件_現組織支店名称
//            Dto301.setSearchFromSosNm2("");
//            // 検索条件_現組織の組織コード３
//            Dto301.setSearchFromSosCd3("");
//            // 検索条件_現組織の組織コード４
//            Dto301.setSearchFromSosCd4("");
//        }
//
//        // 検索条件_現従業員番号
//        Dto301.setSearchFromJgiNo("");
//        // 検索条件_現従業員
//        Dto301.setSearchFromJgiName("");
//        // 検索条件_新従業員番号
//        Dto301.setSearchToJgiNo("");
//        // 検索条件_新従業員
//        Dto301.setSearchToJgiName("");

       if ((Dto301.getBackScreenId().startsWith("JKR040C0") || Dto301.getBackScreenId().startsWith("JKR050C0"))
//            && !StringUtils.isEmpty(Dto301.getTopChangedSosCd())
            ) {

//            //トップメニューで組織(現)を選択した場合
//            if ("0".equals(Dto301.getSosSelFlg())) {
//                // 検索条件_組織・担当（現）_テキスト
//                Dto301.setDispFromSosJgiName(Dto301.getTopChangedSosNm());
//                // 検索条件_現組織コード
//                Dto301.setSearchFromSosCd(Dto301.getTopChangedSosCd());
//                // 検索条件_組織（現）_テキスト
//                Dto301.setSearchFromSosName(Dto301.getTopChangedSosNm());
//                // 検索条件_現組織支店コード
//                Dto301.setSearchFromSosCd2(Dto301.getTopChangedSosCd2());
//                // 検索条件_現組織支店名称
//                Dto301.setSearchFromSosNm2(Dto301.getTopChangedSosNm2());
//                // 検索条件_現組織の組織コード３
//                Dto301.setSearchFromSosCd3(Dto301.getTopChangedSosCd3());
//                // 検索条件_現組織の組織コード４
//                Dto301.setSearchFromSosCd4("");
//
//            //トップメニューで組織(新)を選択した場合
//            } else {
//
//                // 検索条件_組織・担当（新）_テキスト
//                Dto301.setDispToSosJgiName(Dto301.getTopChangedSosNm());
//                // 検索条件_新組織コード
//                Dto301.setSearchToSosCd(Dto301.getTopChangedSosCd());
//                // 検索条件_組織（新）_テキスト
//                Dto301.setSearchToSosName(Dto301.getTopChangedSosNm());
//                //検索条件_組織コード（新）（営業所）
//                Dto301.setSearchToSosCd3(Dto301.getTopChangedSosCd3());
//
//            }
        } else {

//            //トップメニューで組織(現)を選択した場合
//            if ("0".equals(Dto301.getSosSelFlg())) {
//                // 検索条件_現組織コード
//                Dto301.setSearchFromSosCd(Dto301.getSelectedSosCd());
//                // 検索条件_組織・担当（現）_テキスト
//                Dto301.setDispFromSosJgiName(Dto301.getSelectedSosNm());
//                // 検索条件_組織（現）_テキスト
//                Dto301.setSearchFromSosName(Dto301.getSelectedSosNm());
//                // 検索条件_現組織支店コード
//                Dto301.setSearchFromSosCd2(Dto301.getSelectedSosCd2());
//                // 検索条件_現組織支店名称
//                Dto301.setSearchFromSosNm2(Dto301.getSelectedSosNm2());
//                // 検索条件_現組織の組織コード３
//                Dto301.setSearchFromSosCd3(Dto301.getSelectedSosCd3());
//                // 検索条件_現組織の組織コード４
//                Dto301.setSearchFromSosCd4("");
//
//            //トップメニューで組織(新)を選択した場合
//            } else {
//
//                // 検索条件_新組織コード
//                Dto301.setSearchToSosCd(Dto301.getSelectedSosCd());
//                // 検索条件_組織・担当（新）_テキスト
//                Dto301.setDispToSosJgiName(Dto301.getSelectedSosNm());
//                // 検索条件_組織（新）_テキスト
//                Dto301.setSearchToSosName(Dto301.getSelectedSosNm());
//                // 検索条件_新組織コード(営業所）
//                Dto301.setSearchToSosCd3(Dto301.getSelectedSosCd3());
//            }
        }
//       // 検索条件_現組織コード(ポップアップ用）
//       Dto301.setSearchFromSosCdPop(Dto301.getSearchFromSosCd());
//       // 検索条件_新組織コード(ポップアップ用）
//       Dto301.setSearchToSosCdPop(Dto301.getSearchToSosCd());
    }

    /**
     * 前画面から組織関連パラメータをコピーする
     * @param objectTo コピー先
     * @param objectFrom コピー元
     */
    public void copySosInfo(Object objectTo, Object objectFrom) {
        // 検索条件_組織・担当（現）_テキスト
        StringUtils.copyValue(objectTo, objectFrom, "dispFromSosJgiName");
        // 検索条件_現組織コード
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosCd");
        // 検索条件_組織（現）_テキスト
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosName");
        // 検索条件_現組織支店コード
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosCd2");
        // 検索条件_現組織支店名称
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosNm2");
        // 検索条件_現組織の組織コード３
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosCd3");
        // 検索条件_現組織の組織コード４
        StringUtils.copyValue(objectTo, objectFrom, "searchFromSosCd4");

        // 検索条件_組織・担当（新）_テキスト
        StringUtils.copyValue(objectTo, objectFrom, "dispToSosJgiName");
        // 検索条件_新組織コード
        StringUtils.copyValue(objectTo, objectFrom, "searchToSosCd");
        // 検索条件_組織（新）_テキスト
        StringUtils.copyValue(objectTo, objectFrom, "searchToSosName");
        //検索条件_組織コード（新）（営業所）
        StringUtils.copyValue(objectTo, objectFrom, "searchToSosCd3");

        // 検索条件_現従業員番号
        StringUtils.copyValue(objectTo, objectFrom, "searchFromJgiNo");
        // 検索条件_現従業員
        StringUtils.copyValue(objectTo, objectFrom, "searchFromJgiName");
        // 検索条件_新従業員番号
        StringUtils.copyValue(objectTo, objectFrom, "searchToJgiNo");
        // 検索条件_新従業員
        StringUtils.copyValue(objectTo, objectFrom, "searchToJgiName");

        // 施設表示範囲設定フラグ
        StringUtils.copyValue(objectTo, objectFrom, "insDispRngFlg");
    }
    // END UOC
}
