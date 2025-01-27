package jp.co.takeda.rdm.exception;

/**
 * 不正リクエスト例外
 * 不正画面遷移やセッション無しリクエスト等の場合に発生します。
 * @author
 * @version 0.0.1
 */

public class InvalidRequestException extends Exception {

    /**
     * <pre>
     * セッションレプリケーション
     * <pre>
     */
     private static final long serialVersionUID = 42L;


    /**
     * <pre>
     *  リビジョンの取得
     * 自クラスのリビジョンを返却する。
     * </pre>
     * @return String - リビジョン
     * @since 1.x
     */
    public static String getRevision(){
        return "$Revision: 1.1 $";
    }

  /**
   * Constructs a <code>InvalidRequestException</code> with no detail message.
   */
  public InvalidRequestException() {
  }
  /**
   * Constructs a <code>InvalidRequestException</code> with the
   * specified detail message.
   *
   * @param   msg   the detail message.
   */
  public InvalidRequestException(String msg) {
    super(msg);
  }
  /**
   * Constructs a <code>InvalidRequestException</code> with the
   * cause exception.
   *
   * @param   t   cause exception.
   */
  public InvalidRequestException(Throwable t) {
    super(t.getMessage());
  }
}
