package jp.co.takeda.jkr.exception;

/**
 * <pre>
 * サービス利用時間外例外
 * 利用時間帯チェックで利用時間外となった場合に発生します。
 * </pre>
 * @author 
 * @version $Revision: 1.1 $
 * @since 1.0
 */
public class OverTimeServiceException extends Exception {

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
     * Constructs a <code>OverTimeServiceException</code> with no detail message.
     */
    public OverTimeServiceException() {
    }

    /**
     * Constructs a <code>OverTimeServiceException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */

    public OverTimeServiceException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>OverTimeServiceException</code> with the
     * cause exception.
     *
     * @param t cause exception.
     */
    public OverTimeServiceException(Throwable t) {
        super(t.getMessage());
    }
}
