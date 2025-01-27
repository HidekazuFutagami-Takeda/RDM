/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.exception;

/**
 * select for update文実行時に、更新日付が異なった場合に返される実行時例外クラス。<br/>
 * 既に該当データが他に処理により変更されていた場合に発生する。
 * @generated
 */
public class DataExclusiveException extends RuntimeException  {

    /**
     * serialVersionUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ。<br>
     * @generated
     */
    public DataExclusiveException() {
        super();
    }

    /**
     * コンストラクタ。<br>
     * @param message メッセージ
     * @generated
     */
    public DataExclusiveException(String message) {
        super(message);
    }

    /**
     * コンストラクタ。<br>
     * @param message メッセージ
     * @param cause 原因例外
     * @generated
     */
    public DataExclusiveException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * コンストラクタ。<br>
     * @param cause 原因例外
     * @generated
     */
    public DataExclusiveException(Throwable cause) {
        super(cause);
    }

}
