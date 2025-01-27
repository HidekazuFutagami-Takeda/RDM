package jp.co.takeda.rdm.exception;

/**
 * <pre>
 * 無効なサービス例外
 * 画面権限チェック及び利用時間帯チェックでサービスが存在しない場合に発生します。
 * </pre>
 * @author
 * @version $Revision: 1.1 $
 * @since 1.0
 */
public class InvalidServiceException extends Exception {

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
     * Constructs a <code>InvalidServiceException</code> with no detail message.
     */
    public InvalidServiceException() {
    }

    /**
     * Constructs a <code>InvalidServiceException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */

    public InvalidServiceException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>InvalidServiceException</code> with the
     * cause exception.
     *
     * @param t cause exception.
     */
    public InvalidServiceException(Throwable t) {
        super(t.getMessage());
    }
}
