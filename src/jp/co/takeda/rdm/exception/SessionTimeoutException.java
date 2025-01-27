package jp.co.takeda.rdm.exception;

/**
 * <pre>
 * セッションタイムアウト例外
 * セッションタイムアウトの際に発生します。
 * 実際にはHelperMatrixでinitial=falseの場合でセッションが存在しないときです。
 * </pre>
 * @author
 * @version $Revision: 1.1 $
 * @since 1.0
 */
public class SessionTimeoutException extends Exception {

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
     * @since 1.2
     */
    public static String getRevision(){
        return "$Revision: 1.1 $";
    }

    /**
     * Constructs a <code>SessionTimeoutException</code> with no detail message.
     */
    public SessionTimeoutException() {
    }

    /**
     * Constructs a <code>SessionTimeoutException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */

    public SessionTimeoutException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>SessionTimeoutException</code> with the
     * cause exception.
     *
     * @param t cause exception.
     */
    public SessionTimeoutException(Throwable t) {
        super(t.getMessage());
    }
}
