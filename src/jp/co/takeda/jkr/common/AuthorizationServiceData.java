package jp.co.takeda.jkr.common;

import java.io.Serializable;

import jp.co.takeda.jkr.exception.InvalidServiceException;
import jp.co.takeda.jkr.exception.OverTimeServiceException;
import jp.co.takeda.jkr.exception.PauseServiceException;
import jp.co.takeda.jkr.exception.UnauthorizedException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <pre>
 * プログラム認証と利用時間帯チェック情報受渡しデータです。
 * </pre>
 * @author 
 * @version $Revision: 1.1 $
 * @since 1.0
 */
public class AuthorizationServiceData extends BaseDTO implements Serializable {

    /**
     * <pre>
     * セッションレプリケーション
     * <pre>
     */
    private static final long serialVersionUID = 42L;

    private static final transient Log log = LogFactory.getLog(AuthorizationServiceData.class);

    public static final int AUTH_TRUE     = 1;   //利用可能
    public static final int AUTH_FALSE    = 0;   //利用不可能

    public static final int STOP_TRUE     = 1;   //停止中、時間外、未登録
    public static final int STOP_FALSE    = 0;   //停止中でない

    public static final String REQKEY     = "AuthorizationServiceData";   //リクエストへ保存するときのキー
    public static final String ERROR_TRANSITION     = "REQUEST_ERROR_TRANSITION";   //リクエストへ保存するときのキー(エラー遷移先)

    public AuthorizationServiceData() {
    }
    public void initialize() {
        this.authStatus			= AUTH_FALSE;
        this.utilityTimeStatus	= AUTH_FALSE;
        this.unregisteredScrn	= STOP_TRUE;
        this.stopServiceScrn	= STOP_TRUE;
        this.overTimeService	= STOP_TRUE;
        this.unregisteredFunc   = STOP_TRUE;
        this.stopServiceFunc	= STOP_TRUE;
        this.stopMsgScrn		= "";
        this.stopMsgFunc		= "";
        this.scrnName			= "";
        this.funcName			= "";
        this.startTime			= "";
        this.endTime			= "";
    }

    /**
     * <pre>
     * --- メイン情報 ---
     *  プログラム認証情報(画面ID、機能IDチェック)
     *    1:利用可能  0:利用不可能
     * </pre>
     * @since 1.0
     */
    private int authStatus = AUTH_FALSE;

  /**
   * <pre>
   * --- メイン情報 ---
   *  プログラム認証情報(利用時間チェック)
   *    1:利用可能  0:利用不可能
   *    利用不可能の場合は、詳細情報でその理由をチェックします。
   * </pre>
   * @since 1.0
   */
    private int utilityTimeStatus = AUTH_FALSE;

  /**
   * <pre>
   * --- 詳細情報 ---
   *  該当画面ID未登録フラグ
   *    該当画面IDが画面管理テーブルに存在しない場合：1
   *                              存在する場合  ：0
   * </pre>
   * @since 1.0
   */
    private int unregisteredScrn = STOP_TRUE;

  /**
   * <pre>
   * --- 詳細情報 ---
   *  サービス停止中フラグ(画面管理テーブル.画面ID)
   *    サービス停止中の場合：1
   *    サービス開始中の場合：0
   * </pre>
   * @since 1.0
   */
    private int stopServiceScrn = STOP_TRUE;

  /**
   * <pre>
   * --- 詳細情報 ---
   *  サービス時間外フラグ(画面管理テーブル)
   *    サービス時間外の場合：1
   *    サービス時間内の場合：0
   * </pre>
   * @since 1.0
   */
    private int overTimeService = STOP_TRUE;

  /**
   * <pre>
   * --- 詳細情報 ---
   *  該当画面ID機能ID未登録フラグ
   *    該当画面IDが機能管理テーブルに存在しない場合：1
   *                              存在する場合  ：0
   * </pre>
   * @since 1.0
   */
    private int unregisteredFunc = STOP_TRUE;

  /**
   * <pre>
   * --- 詳細情報 ---
   *  サービス停止中フラグ(画面ID、機能ID)
   *    サービス時間外の場合：1
   *    サービス時間内の場合：0
   * </pre>
   * @since 1.0
   */
    private int stopServiceFunc = STOP_TRUE;

  /**
   * <pre>
   *  サービス停止メッセージ(画面管理テーブル)
   * </pre>
   * @since 1.0
   */
    private String  stopMsgScrn = "";

  /**
   * <pre>
   *  サービス停止メッセージ(機能管理テーブル)
   * </pre>
   * @since 1.0
   */
    private String  stopMsgFunc = "";

  /**
   * <pre>
   * 画面名称
   * </pre>
   * @since 1.0
   */
  private String	  scrnName = "";

  /**
   * <pre>
   * 機能名称
   * </pre>
   * @since 1.0
   */
  private String	  funcName = "";

  /**
   * <pre>
   * サービス開始時刻
   * </pre>
   * @since 1.0
   */
  private String	  startTime = "";

  /**
   * <pre>
   * サービス終了時刻
   * </pre>
   * @since 1.0
   */
  private String	  endTime = "";

  /**
   * <pre>
   *  プログラム認証情報(画面ID、機能IDチェック)を設定します。
   * </pre>
   * @param authStatus プログラム認証情報(画面ID、機能IDチェック)
   * @since 1.0
   */
  public int getAuthStatus() {
    return authStatus;
  }

  /**
   * <pre>
   * プログラム認証情報(画面ID、機能IDチェック)を取得します。
   * </pre>
   * @return int - プログラム認証情報(画面ID、機能IDチェック)
   * @since 1.0
   */
  public void setAuthStatus(int authStatus) {
    this.authStatus = authStatus;
  }

  /**
   * <pre>
   * プログラム認証情報(利用時間チェック)を取得します。
   * </pre>
   * @return int プログラム認証情報(利用時間チェック)
   * @since 1.0
   */
    public int getUtilityTimeStatus() {
        return utilityTimeStatus;
    }

  /**
   * <pre>
   * プログラム認証情報(利用時間チェック)を設定します。
   * </pre>
   * @param utilityTimeStatus プログラム認証情報(利用時間チェック)
   * @since 1.0
   */
    public void setUtilityTimeStatus(int utilityTimeStatus) {
        this.utilityTimeStatus = utilityTimeStatus;
    }

  /**
   * <pre>
   * 該当画面ID未登録フラグを取得します。
   * </pre>
   * @return int 該当画面ID未登録フラグ
   * @since 1.0
   */
    public int getUnregisteredScrn() {
        return unregisteredScrn;
    }

  /**
   * <pre>
   * 該当画面ID未登録フラグを設定します。
   * </pre>
   * @param unregisteredScrn 該当画面ID未登録フラグ
   * @since 1.0
   */
    public void setUnregisteredScrn(int unregisteredScrn) {
        this.unregisteredScrn = unregisteredScrn;
    }

  /**
   * <pre>
   * サービス停止中フラグ(画面ID)を取得します。
   * </pre>
   * @return int サービス停止中フラグ(画面ID)
   * @since 1.0
   */
    public int getStopServiceScrn() {
        return stopServiceScrn;
    }

  /**
   * <pre>
   * サービス停止中フラグ(画面ID)を設定します。
   * </pre>
   * @param stopServiceScrn サービス停止中フラグ(画面ID)
   * @since 1.0
   */
    public void setStopServiceScrn(int stopServiceScrn) {
        this.stopServiceScrn = stopServiceScrn;
    }

  /**
   * <pre>
   * サービス時間外フラグを取得します。
   * </pre>
   * @return int サービス時間外フラグ
   * @since 1.0
   */
    public int getOverTimeService() {
        return overTimeService;
    }

  /**
   * <pre>
   * サービス時間外フラグを設定します。
   * </pre>
   * @param overTimeService サービス時間外フラグ
   * @since 1.0
   */
    public void setOverTimeService(int overTimeService) {
        this.overTimeService = overTimeService;
    }

  /**
   * <pre>
   * 該当画面ID機能ID未登録フラグを取得します。
   * </pre>
   * @return int 該当画面ID機能ID未登録フラグ
   * @since 1.0
   */
    public int getUnregisteredFunc() {
        return unregisteredFunc;
    }

  /**
   * <pre>
   * 該当画面ID機能ID未登録フラグを設定します。
   * </pre>
   * @param unregisteredFunc 該当画面ID機能ID未登録フラグ
   * @since 1.0
   */
    public void setUnregisteredFunc(int unregisteredFunc) {
        this.unregisteredFunc = unregisteredFunc;
    }

  /**
   * <pre>
   * サービス停止中フラグ(画面ID、機能ID)を取得します。
   * </pre>
   * @return int サービス停止中フラグ(画面ID、機能ID)
   * @since 1.0
   */
    public int getStopServiceFunc() {
        return stopServiceFunc;
    }

  /**
   * <pre>
   * サービス停止中フラグ(画面ID、機能ID)を設定します。
   * </pre>
   * @param stopServiceFunc サービス停止中フラグ(画面ID、機能ID)
   * @since 1.0
   */
    public void setStopServiceFunc(int stopServiceFunc) {
        this.stopServiceFunc = stopServiceFunc;
    }

  /**
   * <pre>
   * サービス停止メッセージを取得します。
   * </pre>
   * @return String サービス停止メッセージ
   * @since 1.0
   */
    public String getStopMsgScrn() {
        return stopMsgScrn;
    }

  /**
   * <pre>
   * サービス停止メッセージを設定します。
   * </pre>
   * @param stopMsgScrn サービス停止メッセージ
   * @since 1.0
   */
    public void setStopMsgScrn(String stopMsgScrn) {
        this.stopMsgScrn = stopMsgScrn;
    }

  /**
   * <pre>
   * サービス停止メッセージを取得します。
   * </pre>
   * @return String サービス停止メッセージ
   * @since 1.0
   */
    public String getStopMsgFunc() {
        return stopMsgFunc;
    }

  /**
   * <pre>
   * サービス停止メッセージを設定します。
   * </pre>
   * @param stopMsgFunc サービス停止メッセージ
   * @since 1.0
   */
    public void setStopMsgFunc(String stopMsgFunc) {
        this.stopMsgFunc = stopMsgFunc;
    }

    /**
     * <pre>
     * 画面名称取得 - 画面名称を取得します。
     * 機能：
     *     １．画面名称を返す。
     * </pre>
     * @rerurn String 画面名称
     * @since 1.0
     */
    final public String getScrnName() {

        return scrnName;

    }

    /**
     * <pre>
     * 画面名称格納 - 画面名称を格納します。
     * 機能：
     *     １．画面名称を格納する。
     * </pre>
     * @param scrnName 画面名称
     * @since 1.0
     */
    final public void setScrnName(String scrnName) {

        this.scrnName = scrnName;

    }

    /**
     * <pre>
     *         名称取得 - 機能名称を取得します。
     * 機能：
     *     １．機能名称を返す。
     * </pre>
     * @rerurn String 機能名称
     * @since 1.0
     */
    final public String getFuncName() {

        return funcName;

    }

    /**
     * <pre>
     * 機能名称格納 - 機能名称を格納します。
     * 機能：
     *     １．機能名称を格納する。
     * </pre>
     * @param funcName 機能名称
     * @since 1.0
     */
    final public void setFuncName(String funcName) {

        this.funcName = funcName;

    }

    /**
     * <pre>
     * サービス開始時刻取得 - サービス開始時刻を取得します。
     * 機能：
     *     １．サービス開始時刻を返す。
     * </pre>
     * @rerurn String サービス開始時刻
     * @since 1.0
     */
    final public String getStartTime() {

        return startTime;

    }

    /**
     * <pre>
     * サービス開始時刻格納 - サービス開始時刻を格納します。
     * 機能：
     *     １．サービス開始時刻を格納する。
     * </pre>
     * @param startTime サービス開始時刻
     * @since 1.0
     */
    final public void setStartTime(String startTime) {

        this.startTime = startTime;

    }

    /**
     * <pre>
     * サービス終了時刻取得 - サービス終了時刻を取得します。
     * 機能：
     *     １．サービス終了時刻を返す。
     * </pre>
     * @rerurn String サービス終了時刻
     * @since 1.0
     */
    final public String getEndTime() {

        return endTime;

    }

    /**
     * <pre>
     * サービス終了時刻格納 - サービス終了時刻を格納します。
     * 機能：
     *     １．サービス終了時刻を格納する。
     * </pre>
     * @param endTime サービス終了時刻
     * @since 1.0
     */
    final public void setEndTime(String endTime) {

        this.endTime = endTime;

    }

    // ----- 業務ロジック

    /**
     * <pre>
     * 権限、利用時間帯チェックを行います。
     * </pre>
     * @exception Exception 権限や利用時間帯チェックエラーの場合に該当する例外を発行します。
     * @since 1.0
     */
    public final void checkAuth() throws Exception{
        //権限チェックOK
        if(this.authStatus != AUTH_FALSE && this.utilityTimeStatus != AUTH_FALSE){
            return;
        }

        //画面登録がないチェック
        if(this.utilityTimeStatus == AUTH_FALSE && this.unregisteredScrn == STOP_TRUE){
            log.debug("InvalidServiceExceptionが発生しました。エラーページを表示します。[unregisterd ScreenId]");
            throw new InvalidServiceException("unregisterd ScreenId");
        }
        //利用権限チェック
        if(this.authStatus == AUTH_FALSE){
            log.debug("UnauthorizedExceptionが発生しました。エラーページを表示します。[unauthorized]");
            throw new UnauthorizedException("unauthorized");
        }
        //利用時間帯チェック
        if(this.utilityTimeStatus == AUTH_FALSE){
            //画面サービス停止中
            if(this.stopServiceScrn == STOP_TRUE){
                log.debug("PauseServiceExceptionが発生しました。エラーページを表示します。[stop service screenId]");
                throw new PauseServiceException("stop service screenId");
            }
            //画面利用時間外
            if(this.overTimeService == STOP_TRUE){
                log.debug("OverTimeServiceExceptionが発生しました。エラーページを表示します。[overtime service start="+this.startTime+" end="+this.endTime + "]");
                throw new OverTimeServiceException("overtime service start="+this.startTime+" end="+this.endTime);
            }
            //機能サービス停止中
            if(this.stopServiceFunc == STOP_TRUE){
                log.debug("PauseServiceExceptionが発生しました。エラーページを表示します。[stop service functionId]");
                throw new PauseServiceException("stop service functionId");
            }
        }
    }
    
    /**
     * <pre>
     * 権限、利用時間帯チェックを行います。
     * </pre>
     * @exception Exception 権限や利用時間帯チェックエラーの場合に該当する例外を発行します。
     * @since 1.0
     */
    public final String checkAuthResult() {
        //権限チェックOK
        if(this.authStatus != AUTH_FALSE && this.utilityTimeStatus != AUTH_FALSE){
            return null;
        }

        //画面登録がないチェック
        if(this.utilityTimeStatus == AUTH_FALSE && this.unregisteredScrn == STOP_TRUE){
            log.debug("InvalidServiceExceptionが発生しました。エラーページを表示します。[unregisterd ScreenId]");
            return InvalidServiceException.class.getSimpleName();
        }
        //利用権限チェック
        if(this.authStatus == AUTH_FALSE){
            log.debug("UnauthorizedExceptionが発生しました。エラーページを表示します。[unauthorized]");
            return UnauthorizedException.class.getSimpleName();
        }
        //利用時間帯チェック
        if(this.utilityTimeStatus == AUTH_FALSE){
            //画面サービス停止中
            if(this.stopServiceScrn == STOP_TRUE){
                log.debug("PauseServiceExceptionが発生しました。エラーページを表示します。[stop service screenId]");
                return PauseServiceException.class.getSimpleName();
            }
            //画面利用時間外
            if(this.overTimeService == STOP_TRUE){
                log.debug("OverTimeServiceExceptionが発生しました。エラーページを表示します。[overtime service start="+this.startTime+" end="+this.endTime + "]");
                return OverTimeServiceException.class.getSimpleName();
            }
            //機能サービス停止中
            if(this.stopServiceFunc == STOP_TRUE){
                log.debug("PauseServiceExceptionが発生しました。エラーページを表示します。[stop service functionId]");
                return PauseServiceException.class.getSimpleName();
            }
        }
        return null;
    }
}
