/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import jp.co.takeda.rdm.exception.InvalidRequestException;
import jp.co.takeda.rdm.service.CommonControlService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.util.ValueStack;


/**
 * ベースActionクラス
 * @generated
 */
public abstract class BaseAction<DTO extends BaseDTO> extends ActionSupport
    implements ServletRequestAware, SessionAware, ModelDriven<DTO> {

    /**
     * シリアルバージョンID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ログインスタンス
     * @generated
     */
    protected final Log log = LogFactory.getLog(this.getClass());

    /**
     * リクエスト情報
     * @generated
     */
    protected HttpServletRequest request;

    /**
     * セッション情報
     * @generated
     */
    protected Map<String, Object> sessionMap;

    /**
     * DTO
     * @generated
     */
    protected DTO dto;

    /**
     * 共通処理Serviceオブジェクト<br/>
     *   従業員情報取得<br/>
     *   動的メニュー情報取得<br/>
     *   権限チェック<br/>
     *   時間帯チェック<br/>
     *   など
     *
     * @generated
     */
    @javax.inject.Inject
    private CommonControlService commonControlService;

    /**
     * 画面利用権限チェック
     * TRUE:行う、FALSE:行わない
     */
    @Inject("authorization.screen.check")
    protected String screenCheck;

    /**
     * 利用時間帯チェック
     */
    @Inject("authorization.time.check")
    protected String timeCheck;

    /**
     * リクエスト情報の設定
     * @param request リクエスト情報
     * @generated
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * セッション情報の設定
     * @param sessionMap セッション情報
     * @generated
     */
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * DTOの取得
     * @param DTO
     * @generated
     */
    public DTO getModel() {
        return dto;
    }

    /**
     * 後処理(次画面のDTOをスタックに格納する)<br/>
     * @param outdto 次画面のDTO
     * @generated
     */
    public void setNextDTO(BaseDTO outdto) throws Exception {
        for (String message : outdto.getMessageList()) {
            addActionMessage(message);
        }
        for (String errorMessage : outdto.getErrorMessageList()) {
            addActionError(errorMessage);
        }
        ValueStack stack = (ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
        stack.push(outdto);
    }

    /**
     * 全Actionの共通前処理。<br/>
     * 各業務のActionが呼ばれる前に実行する。
     * 但し、validationエラー時は実行されない。
     * @return 遷移先（nullの場合、業務のActionを呼び出す）
     * @customizable
     */
    @Before
    public String baseBefore() throws Exception {
        // START UOC
        log.info("BaseAction Run!!!!!!!!!!!!!!!!!!!!!!!!--screenCheck:" + screenCheck + "--timeCheck:" + timeCheck);
        //ログインユーザ情報取得
        LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute(BaseInfoHolder.USERINFO_KEY);
        //ログイン情報がない場合（URL直打などのアクセス）
        if (loginInfo == null) {
            return null;
        }

        if (hasActionErrors()) {
            return null;
        }

        int screenCheckFlg = 0; //画面認証チェック 0:なし 1:あり
        int timeCheckFlg   = 0; //利用時間チェック 0:なし 1:あり
        //チェック判定 trueならチェックを行います。struts.xmlに設定がないかtureでなければチェックを行いません。
        if (screenCheck != null && screenCheck.equalsIgnoreCase("true")){
            screenCheckFlg = 1;
        }
        if (timeCheck != null && timeCheck.equalsIgnoreCase("true")){
            timeCheckFlg = 1;
        }
        //画面利用権限チェックフラグ設定
        loginInfo.setScreenCheckFlg(screenCheckFlg);
        //利用時間帯チェックフラグ設定
        loginInfo.setTimeCheckFlg(timeCheckFlg);

        // 画面ID、イベントIDの取得
        String actionStr = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1).replace(".action", "");
        //TODO 二神　後日変更する
        String screenId = "";
        String functionId = "";
        String sysChk = actionStr.substring(0,1);
        if(!sysChk.equals("N")) {
        	screenId = actionStr.substring(0, 10);
        	functionId = actionStr.substring(10);
        }else {
        	screenId = actionStr.substring(0, 5);
        	functionId = actionStr.substring(5);
        }

        functionId = functionId.contains(";") ? functionId.substring(0, functionId.indexOf(";")) : functionId;
        log.info("画面ID====" + screenId + ":::::イベントID===" + functionId);

        //プログラム認証と利用時間帯チェック情報受渡しデータ
        AuthorizationServiceData authData;
        LoginInfo paramLoginTemp = new LoginInfo();
        BeanUtil.copyProperties(paramLoginTemp, loginInfo);
        //今回情報を前回情報に変換
        paramLoginTemp.changePreInfo();
        //画面IDの設定
        paramLoginTemp.setScreenId(screenId);
        //イベントIDの設定
        paramLoginTemp.setFunctionId(functionId);


        //画面遷移チェック処理を行います。
        boolean check = commonControlService.checkTransition(paramLoginTemp);
        //エラーが発生した場合、「struts.xml」に定義したエラー「<global-results>」を戻す
        if (!check) {
            return InvalidRequestException.class.getSimpleName();
        }

        //利用時間帯及び画面利用権限チェックを行います。
        authData = commonControlService.checkAuthorization(paramLoginTemp);
        //権限データがnull(xmlでチェックなしを設定されている場合)はチェックを行いません。
        if (authData != null) {
            //リクエストに権限データを格納します。
            request.setAttribute(AuthorizationServiceData.REQKEY,authData);
            //チェックを行います。OKなら、戻り値がNULL。
            String checkResult = authData.checkAuthResult();
            //エラーが発生した場合、「struts.xml」に定義したエラー「<global-results>」を戻す
            if (checkResult != null && checkResult.trim().length() > 0) {
                return checkResult;
            }
        }

        //権限チェックなどがOKとなった後、画面操作情報を設定する
        //今回情報を前回情報に変換
        loginInfo.changePreInfo();
        //画面IDの設定
        loginInfo.setScreenId(screenId);
        //イベントIDの設定
        loginInfo.setFunctionId(functionId);

        //ユーザ情報管理
        request.getSession().setAttribute(BaseInfoHolder.USERINFO_KEY, loginInfo);
        //セッションにユーザ情報を登録する
        putSession(loginInfo);

        return null;
        // END UOC
    }

    /**
     * 全Actionの共通後処理。<br/>
     * 各業務のActionが呼ばれた後に実行する。
     * 但し、validationエラー時は実行されない。
     * @customizable
     */
    @BeforeResult
    public void baseBeforeResult() throws Exception {
        // START UOC
        //ログインユーザ情報取得
        LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute(BaseInfoHolder.USERINFO_KEY);

        //ログイン情報がない場合（URL直打などのアクセス）
        if (loginInfo == null) {
            return;
        }

        if (hasActionErrors()) {
            return;
        }

        // 画面ID、イベントIDの取得
        String actionStr = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1).replace(".action", "");

        //TODO二神
        String screenId = "";
        if(actionStr.length() < 10) {
        	screenId = actionStr.substring(0, 5);
        }else {
        	screenId = actionStr.substring(0, 10);
        }

        //遷移先画面ID取得
        ValueStack stack = (ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
        boolean isGettedNextScreen = false;
        String nextScreenForward = null;;
        if (stack.peek() instanceof BaseDTO) {
            BaseDTO outdto = (BaseDTO)stack.peek();
            nextScreenForward = outdto != null ? outdto.getForward() : "";
            isGettedNextScreen = (nextScreenForward.length() == 10);
        }

        //遷移元画面IDが取れる場合、該当画面IDの権限をチェックする
        if (isGettedNextScreen && !nextScreenForward.equals(screenId)) {

            //プログラム認証と利用時間帯チェック情報受渡しデータ
            AuthorizationServiceData authData;
            LoginInfo paramLoginTemp = new LoginInfo();
            BeanUtil.copyProperties(paramLoginTemp, loginInfo);
             //画面IDの設定
            paramLoginTemp.setScreenId(nextScreenForward);
            //イベントIDの設定
            paramLoginTemp.setFunctionId("Init");

            //利用時間帯及び画面利用権限チェックを行います。
            authData = commonControlService.checkAuthorization(paramLoginTemp);
            //権限データがnull(xmlでチェックなしを設定されている場合)はチェックを行いません。
            if (authData != null) {
                //リクエストに権限データを格納します。
                request.setAttribute(AuthorizationServiceData.REQKEY,authData);
                String checkAuthResutl = authData.checkAuthResult();
                if (checkAuthResutl != null) {
                    try {
                        //チェックを行います。権限や利用時間帯チェックエラーの場合に該当する例外を発行します。
                        authData.checkAuth();
                    } catch (Exception e) {
                        //エラー情報をリクエストに格納し、「TransitionAuthInterceptor」で処理する
                        request.setAttribute(AuthorizationServiceData.ERROR_TRANSITION, e);

                        //前回情報を今回情報に戻す。
                        loginInfo.returnPreInfo();
                        //ユーザ情報管理
                        request.getSession().setAttribute(BaseInfoHolder.USERINFO_KEY, loginInfo);
                        //セッションにユーザ情報を登録する
                        putSession(loginInfo);
                        throw e;
                    }
                }
            }
        }

        // END UOC
    }

    /**
     * セッションを再生成する（セッションの中身はコピーする）。<br/>
     * @generated
     */
    protected void renewSession() {
        Set<Entry<String, Object>> tmpSet = sessionMap.entrySet();
        // セッションの無効化
        ((SessionMap<String, Object>) sessionMap).invalidate();

        // セッションの格納内容のコピー
        for (Entry<String, Object> tmp : tmpSet) {
          sessionMap.put(tmp.getKey(), tmp.getValue());
        }
    }

    /**
     * セッションにユーザ情報を登録する。<br/>
     * @generated
     */
    protected void putSession(UserInfo user) {
        sessionMap.put(BaseInfoHolder.USERINFO_KEY, user);
        //ThreadLocalへも追加する。
        BaseInfoHolder.setUserInfo(user);
    }

}
