package jp.co.takeda.jkr.exception;

/**
 * <pre>
 * サービス停止例外
 * 利用時間帯チェックでサービス停止となった場合に発生します。
 * </pre>
 * @author 
 * @version $Revision: 1.1 $
 * @since 1.0
 */
public class PauseServiceException extends Exception {

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
     * Constructs a <code>PauseServiceException</code> with no detail message.
     */
    public PauseServiceException() {
    }

    /**
     * Constructs a <code>PauseServiceException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */

    public PauseServiceException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>PauseServiceException</code> with the
     * cause exception.
     *
     * @param t cause exception.
     */
    public PauseServiceException(Throwable t) {
        super(t.getMessage());
    }
}
