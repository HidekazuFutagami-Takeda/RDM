package jp.co.takeda.jkr.common;

import java.io.Serializable;
import java.util.Map;

import jp.co.takeda.rdm.entity.RdmMsgMstEntity;
import jp.co.takeda.rdm.util.DateUtils;

/**
 * タイトル:  武田薬品工業株式会社
 *
 */
public class LoginInfo extends UserInfo implements Serializable{

    /**
     * 従業員番号
     */
    private int jgiNo;

    /**
     * 氏名
     */
    private String jgiName;

    /**
     * 組織コード
     * @generated
     */
    private String sosCd;

    /**
     * 医薬支店C
     * @generated
     */
    private String brCode;

    /**
     * 医薬営業所C
     * @generated
     */
    private String distCode;

    /**
     * 部門名略式
     * @generated
     */
    private String bumonRyakuName;

    /**
     * 部門ランク
     * @generated
     */
    private String bumonRank;

    /**
     * 上位組織コード
     * @generated
     */
    private String upSosCd;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * 担当変更システムメッセージ格納マップ
     */
    private Map<String, RdmMsgMstEntity> msgMap;

    /**
     * 条件セット
     * @generated
     */
    private String jokenSetCd;

    /**
     * MR権限/管理者権限判定(0：MR権限、1：管理者権限)
     * @generated
     */
    private String jokenFlg;

    /**
     * LoginInfo.javajgiNoを設定
     * @return jgiNo
     */
    public int getJgiNo() {
        return jgiNo;
    }

    /**
     * @param jgiNo セットする jgiNo
     */
    public void setJgiNo(int jgiNo) {
        this.jgiNo = jgiNo;
    }

    /**
     * LoginInfo.javajgiNameを設定
     * @return jgiName
     */
    public String getJgiName() {
        return jgiName;
    }

    /**
     * @param jgiName セットする jgiName
     */
    public void setJgiName(String jgiName) {
        this.jgiName = jgiName;
    }

    /**
     * 組織コードの取得
     * @return 組織コード
     * @generated
     */
    public String getSosCd() {
        return this.sosCd;
    }

    /**
     * 組織コードの設定
     * @param sosCd 組織コード
     * @generated
     */
    public void setSosCd(String sosCd) {
        this.sosCd = sosCd;
    }

    /**
     * 医薬支店Cの取得
     * @return 医薬支店C
     * @generated
     */
    public String getBrCode() {
        return this.brCode;
    }

    /**
     * 医薬支店Cの設定
     * @param brCode 医薬支店C
     * @generated
     */
    public void setBrCode(String brCode) {
        this.brCode = brCode;
    }

    /**
     * 医薬営業所Cの取得
     * @return 医薬営業所C
     * @generated
     */
    public String getDistCode() {
        return this.distCode;
    }

    /**
     * 医薬営業所Cの設定
     * @param distCode 医薬営業所C
     * @generated
     */
    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }

    /**
     * 部門名略式の取得
     * @return 部門名略式
     * @generated
     */
    public String getBumonRyakuName() {
        return this.bumonRyakuName;
    }

    /**
     * 部門名略式の設定
     * @param bumonRyakuName 部門名略式
     * @generated
     */
    public void setBumonRyakuName(String bumonRyakuName) {
        this.bumonRyakuName = bumonRyakuName;
    }

    /**
     * 部門ランクの取得
     * @return 部門ランク
     * @generated
     */
    public String getBumonRank() {
        return this.bumonRank;
    }

    /**
     * 部門ランクの設定
     * @param bumonRank 部門ランク
     * @generated
     */
    public void setBumonRank(String bumonRank) {
        this.bumonRank = bumonRank;
    }

    /**
     * 上位組織コードの取得
     * @return 上位組織コード
     * @generated
     */
    public String getUpSosCd() {
        return this.upSosCd;
    }

    /**
     * 上位組織コードの設定
     * @param upSosCd 上位組織コード
     * @generated
     */
    public void setUpSosCd(String upSosCd) {
        this.upSosCd = upSosCd;
    }

    /**
     * 領域コードの取得
     * @return 領域コード
     * @generated
     */
    public String getTrtCd() {
        return this.trtCd;
    }

    /**
     * 領域コードの設定
     * @param trtCd 領域コード
     * @generated
     */
    public void setTrtCd(String trtCd) {
        this.trtCd = trtCd;
    }

    /**
     * LoginInfo.javamsgMapを設定
     * @return msgMap
     */
    public Map<String, RdmMsgMstEntity> getMsgMap() {
        return msgMap;
    }

    /**
     * @param msgMap セットする msgMap
     */
    public void setMsgMap(Map<String, RdmMsgMstEntity> msgMap) {
        this.msgMap = msgMap;
    }

    /**
     * 条件セットの取得
     * @return 条件セット
     * @generated
     */
    public String getJokenSetCd() {
        return jokenSetCd;
    }

    /**
     * 条件セットの設定
     * @param jokenSetCd 条件セット
     * @generated
     */
    public void setJokenSetCd(String jokenSetCd) {
        this.jokenSetCd = jokenSetCd;
    }

    /**
     * MR権限/管理者権限判定(0：MR権限、1：管理者権限)の取得
     * @return MR権限/管理者権限判定(0：MR権限、1：管理者権限)
     * @generated
     */
    public String getJokenFlg() {
        return jokenFlg;
    }

    /**
     * MR権限/管理者権限判定(0：MR権限、1：管理者権限)の設定
     * @param jokenFlg MR権限/管理者権限判定(0：MR権限、1：管理者権限)
     * @generated
     */
    public void setJokenFlg(String jokenFlg) {
        this.jokenFlg = jokenFlg;
    }

    /*TODO二神  以下を後で削除する*/







    /**
     * <pre>
     * セッションレプリケーション
     * <pre>
     */
     private static final long serialVersionUID = 42L;

    /**
     * <pre>
     * 初期化処理
     * </pre>
     */
    public void initialize() {
        this.jgiNameGetFlag = false;
        this.jgiNo = -1;
        setUserId(null);
        this.jgiName = null;
        this.sessionId = null;
        this.screenId = null;
        this.functionId = null;
        this.preScreenId = null;
        this.preFunctionId = null;
        this.status = null;
        this.preStatus = null;
        this.jsp = null;
        this.preJsp = null;
        this.referer = null;
        this.windowName = null;
        this.openerName = null;
    }
    /**
     * 従業員名取得有無
     */
    private boolean jgiNameGetFlag = false;


    /**
     * セッションID
     */
    private String sessionId;
    /**
     * 今回アクセスしたScreenId
     */
    private String screenId;
    /**
     * 今回アクセスしたfunctionId
     */
    private String functionId;
    /**
     * 前回アクセスしたScreenId
     */
    private String preScreenId;
    /**
     * 前回アクセスしたfunctionId
     */
    private String preFunctionId;
    /**
     * 今回のstatus
     */
    private String status;
    /**
     * 前回のstatus
     */
    private String preStatus;
    /**
     * 今回のjsp
     */
    private String jsp;
    /**
     * 前回のjsp
     */
    private String preJsp;
    /**
     * 呼び出し元のURL
     */
    private String referer;
    /**
     * window名
     */
    private String windowName;
    /**
     * 親window名
     */
    private String openerName;

    /**
     * 画面認証チェックフラグ
     */
    private int screenCheckFlg;

    /**
     * 利用時間チェックフラグ
     */
    private int timeCheckFlg;

    /**
     * ジョブ管理時刻
     */
    private String timeData;

    /**
     * ジョブ管理時刻チェックフラグ
     */
    private int timeDataFlg;


    // ----- コンストラクタ
    public LoginInfo() {
    }

    /**
     * <pre>
     * 今回情報を設定します。
     * </pre>
     */
    public void setCurrentInfo(String screenId,String functionId){
        this.setScreenId(screenId);
        this.setFunctionId(functionId);
    }
    /**
     * <pre>
     * 今回情報を更新します。
     * </pre>
     */
    public void updateInfo(String screenId,String functionId,String status,String jsp){
        //this.setScreenId(screenId);
        //this.setFunctionId(functionId);
        this.setStatus(status);
        this.setJsp(jsp);
    }

    /**
     * <pre>
     * 今回情報を前回情報に変換し、不要な情報は値をクリアします。
     * BaseActionの頭で処理を行います。
     * </pre>
     */
    public void changePreInfo(){
      this.setPreScreenId(this.getScreenId());
      this.setPreFunctionId(this.getFunctionId());
      this.setPreStatus(this.getStatus());
      this.setPreJsp(this.getJsp());
      this.setStatus(null);
      this.setJsp(null);
    }

    /**
     * <pre>
     * 前回情報を今回情報に戻す。
     * BaseActionのエラー時に処理を行います。
     * </pre>
     */
    public void returnPreInfo(){
      this.setScreenId(this.getPreScreenId());
      this.setFunctionId(this.getPreFunctionId());
      this.setStatus(this.getPreStatus());
      this.setJsp(this.getPreJsp());
    }

    /**
     * 代行機能用
     */
    private int     actorJgiNo;     //本ユーザ格納用
    private String  actorJgiName;   //本ユーザ格納用
    private String  actorUserId;    //本ユーザ格納用
    private boolean acting = false;
    private String  actContinueFlg = "0"; //0:継続チェックなし 1:継続チェックあり
                                    //DB側 ログイン時のユーザ切替
                                    //クラス側(このクラス) 画面制御用


    /**
     * 代行終了
     */
    public void actOff(){
        if(acting){
            jgiNo = actorJgiNo;
            jgiName = actorJgiName;
            setUserName(actorJgiName);
            setUserId(actorUserId);
            acting = false;
        }
    }

    /**
     * 代行開始
     */
    public void actOn(int _jgiNo, String _jgiName, String _userId){
        if(!acting){
            actorJgiNo = jgiNo;
            actorJgiName = jgiName;
            actorUserId = getUserId();
            jgiNo = _jgiNo;
            jgiName = _jgiName;
            setUserName(_jgiName);
            setUserId(_userId);
            acting = true;
        }
    }

    /**
     * 代行中かどうかのチェック
     */
    public boolean isActing(){
        return acting;
    }

    /**
     * 代行中をオフ状態にする
     * ※ログイン時、代行機能対応
     */
    public void setActingOff(){
        this.acting = false;
    }

    /**
     * 代行中をオン状態にする
     * ※ログイン時、代行機能対応
     */
    public void setActingOn(){
        this.acting = true;
    }

    /**
     * 代行している従業員番号を設定
     */
    public void setActorJgiNo(int actorJgiNo) {
       this.actorJgiNo = actorJgiNo;
    }
    /**
     * 代行している従業員番号を取得
     */
    public int getActorJgiNo(){
        return actorJgiNo;
    }

    /**
     * 代行している従業員名を設定
     */
    public void setActorJgiName(String actorJgiName) {
       this.actorJgiName = actorJgiName;
    }
    /**
     * 代行している従業員名を取得
     */
    public String getActorJgiName(){
        return actorJgiName;
    }

    /**
     * 代行しているユーザIDを取得
     */
    public String getActorUserId() {
      return actorUserId;
    }

    /**
     * 継続かどうかのチェック
     */
    public String isActContinueFlg(){
        return actContinueFlg;
    }

    /**
     * 継続チェックをオフ(なし)状態にする
     * ※ログイン時、代行機能対応
     */
    public void setActContinueFlgOff(){
        this.actContinueFlg = "0";
    }

    /**
     * 継続チェックをオン(あり)状態にする
     * ※ログイン時、代行機能対応
     */
    public void setActContinueFlgOn(){
        this.actContinueFlg = "1";
    }

    /**
     * 別サーバー、別インスタンスから呼び出し時の戻り先URL
     */
    private String returnUrl;
     public void setReturnUrl(String returnUrl) {
         this.returnUrl = returnUrl;
    }
    public String getReturnUrl() {
        return this.returnUrl;
    }

    /**
     * 別サーバー、別インスタンスから呼び出し時の実行タイプ
     * ※１：同一画面起動 ２：別画面起動
     */
    private String directExecType;
     public void setDirectExecType(String directExecType) {
         this.directExecType = directExecType;
    }
    public String getDirectExecType() {
        return this.directExecType;
    }



    /**
     * LoginInfo.javajgiNameGetFlagを設定
     * @return jgiNameGetFlag
     */
    public boolean isJgiNameGetFlag() {
        return jgiNameGetFlag;
    }



    /**
     * @param jgiNameGetFlag セットする jgiNameGetFlag
     */
    public void setJgiNameGetFlag(boolean jgiNameGetFlag) {
        this.jgiNameGetFlag = jgiNameGetFlag;
    }







    /**
     * LoginInfo.javasessionIdを設定
     * @return sessionId
     */
    public String getSessionId() {
        return sessionId;
    }



    /**
     * @param sessionId セットする sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }



    /**
     * LoginInfo.javascreenIdを設定
     * @return screenId
     */
    public String getScreenId() {
        return screenId;
    }



    /**
     * @param screenId セットする screenId
     */
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }



    /**
     * LoginInfo.javafunctionIdを設定
     * @return functionId
     */
    public String getFunctionId() {
        return functionId;
    }



    /**
     * @param functionId セットする functionId
     */
    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }



    /**
     * LoginInfo.javapreScreenIdを設定
     * @return preScreenId
     */
    public String getPreScreenId() {
        return preScreenId;
    }



    /**
     * @param preScreenId セットする preScreenId
     */
    public void setPreScreenId(String preScreenId) {
        this.preScreenId = preScreenId;
    }



    /**
     * LoginInfo.javapreFunctionIdを設定
     * @return preFunctionId
     */
    public String getPreFunctionId() {
        return preFunctionId;
    }



    /**
     * @param preFunctionId セットする preFunctionId
     */
    public void setPreFunctionId(String preFunctionId) {
        this.preFunctionId = preFunctionId;
    }



    /**
     * LoginInfo.javastatusを設定
     * @return status
     */
    public String getStatus() {
        return status;
    }



    /**
     * @param status セットする status
     */
    public void setStatus(String status) {
        this.status = status;
    }



    /**
     * LoginInfo.javapreStatusを設定
     * @return preStatus
     */
    public String getPreStatus() {
        return preStatus;
    }



    /**
     * @param preStatus セットする preStatus
     */
    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus;
    }



    /**
     * LoginInfo.javajspを設定
     * @return jsp
     */
    public String getJsp() {
        return jsp;
    }



    /**
     * @param jsp セットする jsp
     */
    public void setJsp(String jsp) {
        this.jsp = jsp;
    }



    /**
     * LoginInfo.javapreJspを設定
     * @return preJsp
     */
    public String getPreJsp() {
        return preJsp;
    }



    /**
     * @param preJsp セットする preJsp
     */
    public void setPreJsp(String preJsp) {
        this.preJsp = preJsp;
    }



    /**
     * LoginInfo.javarefererを設定
     * @return referer
     */
    public String getReferer() {
        return referer;
    }



    /**
     * @param referer セットする referer
     */
    public void setReferer(String referer) {
        this.referer = referer;
    }



    /**
     * LoginInfo.javawindowNameを設定
     * @return windowName
     */
    public String getWindowName() {
        return windowName;
    }



    /**
     * @param windowName セットする windowName
     */
    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }



    /**
     * LoginInfo.javaopenerNameを設定
     * @return openerName
     */
    public String getOpenerName() {
        return openerName;
    }



    /**
     * @param openerName セットする openerName
     */
    public void setOpenerName(String openerName) {
        this.openerName = openerName;
    }



    /**
     * LoginInfo.javaactContinueFlgを設定
     * @return actContinueFlg
     */
    public String getActContinueFlg() {
        return actContinueFlg;
    }



    /**
     * @param actContinueFlg セットする actContinueFlg
     */
    public void setActContinueFlg(String actContinueFlg) {
        this.actContinueFlg = actContinueFlg;
    }



    /**
     * LoginInfo.javaserialVersionUIDを設定
     * @return serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @param actorUserId セットする actorUserId
     */
    public void setActorUserId(String actorUserId) {
        this.actorUserId = actorUserId;
    }



    /**
     * @param acting セットする acting
     */
    public void setActing(boolean acting) {
        this.acting = acting;
    }

    /**
     * LoginInfo.javainScreenCheckFlgを設定
     * @return screenCheckFlg
     */
    public int getScreenCheckFlg() {
        return screenCheckFlg;
    }

    /**
     * @param screenCheckFlg セットする screenCheckFlg
     */
    public void setScreenCheckFlg(int screenCheckFlg) {
        this.screenCheckFlg = screenCheckFlg;
    }

    /**
     * LoginInfo.javatimeCheckFlgを設定
     * @return timeCheckFlg
     */
    public int getTimeCheckFlg() {
        return timeCheckFlg;
    }

    /**
     * @param timeCheckFlg セットする timeCheckFlg
     */
    public void setTimeCheckFlg(int timeCheckFlg) {
        this.timeCheckFlg = timeCheckFlg;
    }

    /**
     * LoginInfo.javatimeDataを設定
     * @return timeData
     */
    public String getTimeData() {
        return timeData;
    }

    /**
     * @param timeData セットする timeData
     */
    public void setTimeData(String timeData) {
        this.timeData = timeData;
    }

    /**
     * LoginInfo.javatimeDataFlgを設定
     * @return timeDataFlg
     */
    public int getTimeDataFlg() {
        //ジョブ管理時刻チェックフラグ
        // 現在時刻
        String time = DateUtils.getSysDate("HHmmss");

        int flg = 0;
        // 現在時刻がジョブ管理時刻以降の場合はメッセージを表示
        if (timeData != null && Integer.parseInt(time) >= Integer.parseInt(timeData)) {
            flg = 1;
        }
        this.timeDataFlg = flg;
        return this.timeDataFlg;
    }

    /**
     * @param timeDataFlg セットする timeDataFlg
     */
    public void setTimeDataFlg(int timeDataFlg) {
        this.timeDataFlg = timeDataFlg;
    }



    /**
     * 指定メッセージコードのメッセージを取得
     */
    public String getMsgData(String msgCd) {
        if (msgMap != null && msgMap.get(msgCd) != null) {
            return msgMap.get(msgCd).getMsgData();
        } else {
            return "該当メッセージが定義されていません！（" + msgCd + "）";
        }
    }

    /**
     * 指定メッセージコードのメッセージを取得
     */
    public RdmMsgMstEntity getMsgEntity(String msgCd) {
        return msgMap.get(msgCd);
    }
}
