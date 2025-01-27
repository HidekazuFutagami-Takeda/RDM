/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * ベースDTOクラス
 * @generated
 */
@Getter
@Setter
public abstract class BaseDTO implements Serializable {

    /**
     * シリアルバージョンID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 遷移先画面ID
     * @generated
     */
    private String forward;

    /**
     * メッセージリスト
     * @generated
     */
    private List<String> messageList = new ArrayList<String>();

    /**
     * エラーメッセージリスト
     * @generated
     */
    private List<String> errorMessageList = new ArrayList<String>();

    /**
     * メッセージの追加
     * @param message メッセージ
     * @generated
     */
    public void addMessage(String message) {
        messageList.add(message);
    }

    /**
     * エラーメッセージの追加
     * @param errorMessage エラーメッセージ
     * @generated
     */
    public void addErrorMessage(String errorMessage) {
        errorMessageList.add(errorMessage);
    }

    /**
     * ページャー_全ページ数
     * @generated
     */
    private Integer pageCntAll;

    /**
     * ページャー_現在ページ番号
     * @generated
     */
    private Integer pageCntCur;

    /**
     * ページャー_基準ページ(ページ番号リンクの左端ページ番号)
     * @generated
     */
    private Integer pageCntBase;

    /**
     * ページャー_明細行番号(開始)
     * @generated
     */
    private Integer lineCntStart;

    /**
     * ページャー_明細行番号(終了)
     * @generated
     */
    private Integer lineCntEnd;

    /**
     * ページャー_全明細行数
     * @generated
     */
    private Integer lineCntAll;

    /**
     * 前画面ID
     * @generated
     */
    private String backScreenId;

	/**
	 * 前画面ＩＤ
	 * @generated
	 */
	private String preScreenId;

    /**
     * 改ページ機能の情報設定共通メソッド
     * @param pageCntCur 現在のページ数
     * @param lineCntAll 全明細行数
     */
    public void initPageInfo(Integer pageCntCur, Integer lineCntAll) {
        initPageInfo(pageCntCur, lineCntAll, 50);
    }

    /**
     * 改ページ機能の情報設定共通メソッド
     * @param pageCntCur 現在のページ数
     * @param lineCntAll 全明細行数
     * @param onePageLineCnt１ページ表示件数
     */
    public void initPageInfo(Integer pageCntCur, Integer lineCntAll, Integer onePageLineCnt) {

        if (pageCntCur == null || pageCntCur == 0) {
            if (lineCntAll > 0) {
                pageCntCur = 1;
            } else {
                pageCntCur = 0;
            }
        }

        if (lineCntAll ==0) {
            this.pageCntCur = 0;
            this.lineCntAll = 0;
            this.pageCntAll = 0;
            this.lineCntStart = 0;
            this.lineCntEnd = 0;
            this.pageCntBase = 0;
            return;
        }

        //指定ページのデータが取れない場合（指定ページのデータが削除されたなどの場合）
        if ((pageCntCur-1) * onePageLineCnt >= lineCntAll) {
            //１ページ目に戻る
            pageCntCur = 1;
        }

        // 明細行数(全て)を生成
        this.pageCntCur = pageCntCur;
        this.lineCntAll = lineCntAll;

        // ページ数(全て)の生成
        this.pageCntAll = (lineCntAll % onePageLineCnt == 0 )?( lineCntAll / onePageLineCnt ):( lineCntAll / onePageLineCnt ) + 1 ;

        // 明細行番号(開始)を生成
        this.lineCntStart = (pageCntCur - 1) * onePageLineCnt + 1;

        // 明細行番号(終了)を生成
        this.lineCntEnd = (pageCntCur * onePageLineCnt) <= lineCntAll ? pageCntCur * onePageLineCnt : lineCntAll;

        // 基準ページ(ページ番号リンクの左端ページ番号)を生成
        this.pageCntBase = (pageCntCur / 10) * 10 + 1;
    }

}
