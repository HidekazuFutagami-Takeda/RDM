package jp.co.takeda.jkr.exception;

/**
 * <pre>
 * 利用権限無し例外
 * 画面権限チェック及び利用時間帯チェックで利用権限がない場合に発生します。
 * </pre>
 * @author 
 * @since 1.0
 */
public class UnauthorizedException extends Exception {

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
     * Constructs a <code>UnauthorizedException</code> with no detail message.
     */
    public UnauthorizedException() {
    }

    /**
     * Constructs a <code>UnauthorizedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */

    public UnauthorizedException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>UnauthorizedException</code> with the
     * cause exception.
     *
     * @param t cause exception.
     */
    public UnauthorizedException(Throwable t) {
        super(t.getMessage());
    }
}
