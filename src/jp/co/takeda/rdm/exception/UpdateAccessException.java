/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.exception;

/**
 * select for update文実行時に、更新日付が異なった場合に返される実行時例外クラス。<br/>
 * 実行中に意図しない例外が発生した場合（続行不可能な例外）
 * @generated
 */
public class UpdateAccessException extends RuntimeException {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ。<br>
     * @generated
     */
    public UpdateAccessException() {
        super();
    }

    /**
     * コンストラクタ。<br>
     * @param message メッセージ
     * @generated
     */
    public UpdateAccessException(String message) {
        super(message);
    }

    /**
     * コンストラクタ。<br>
     * @param message メッセージ
     * @param cause 原因例外
     */
    public UpdateAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * コンストラクタ。<br>
     * @param cause 原因例外
     * @generated
     */
    public UpdateAccessException(Throwable cause) {
        super(cause);
    }

}
