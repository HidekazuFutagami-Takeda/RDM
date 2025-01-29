/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.dto;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseDTO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import jp.co.takeda.jkr.entity.RdmMsgMstEntity;


/**
 * DTOクラス
 * @generated
 */
public class NC101DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NC101 = "NC101";

    /**
     * ブラウザタイトル
     * @generated
     */
    private String browerTitle;

    /**
     * 画面タイトル
     * @generated
     */
    private String title;

    /**
     * 完了メッセージ１
     * @generated
     */
    private RdmMsgMstEntity message1;

    /**
     * 完了メッセージ２
     * @generated
     */
    private String message2;

    /**
     * 完了メッセージ３
     * @generated
     */
    private RdmMsgMstEntity message3;

    /**
     * 完了メッセージ４
     * @generated
     */
    private String message4;

    /**
     * 戻るリンク名称１
     * @generated
     */
    private String returnLinkNm1;

    /**
     * 戻るリンクアクション１
     * @generated
     */
    private String returnLinkURL1;

    /**
     * 戻るリンク名称２
     * @generated
     */
    private String returnLinkNm2;

    /**
     * 戻るリンクアクション２
     * @generated
     */
    private String returnLinkURL2;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC101DTO() {
        setForward(NC101);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNC101(String screenID){
        this.NC101 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNC101(){
        return NC101;
    }

    /**
     * ブラウザタイトルの取得
     * @return ブラウザタイトル
     * @generated
     */
    public String getBrowerTitle() {
        return browerTitle;
    }

    /**
     * ブラウザタイトルの設定
     * @param browerTitle ブラウザタイトル
     * @generated
     */
    public void setBrowerTitle(String browerTitle) {
        this.browerTitle = browerTitle;
    }

    /**
     * 画面タイトルの取得
     * @return 画面タイトル
     * @generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 画面タイトルの設定
     * @param title 画面タイトル
     * @generated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 完了メッセージ１の取得
     * @return 完了メッセージ１
     * @generated
     */
    public RdmMsgMstEntity getMessage1() {
        return message1;
    }

    /**
     * 完了メッセージ１の設定
     * @param message1 完了メッセージ１
     * @generated
     */
    public void setMessage1(RdmMsgMstEntity message1) {
        this.message1 = message1;
    }

	/**
     * 完了メッセージ２の取得
     * @return 完了メッセージ２
     * @generated
     */
    public String getMessage2() {
        return message2;
    }

    /**
     * 完了メッセージ２の設定
     * @param message2 完了メッセージ２
     * @generated
     */
    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    /**
     * 完了メッセージ３の取得
     * @return 完了メッセージ３
     * @generated
     */
    public RdmMsgMstEntity getMessage3() {
        return message3;
    }

    /**
     * 完了メッセージ３の設定
     * @param message3 完了メッセージ３
     * @generated
     */
    public void setMessage3(RdmMsgMstEntity message3) {
        this.message3 = message3;
    }

	/**
     * 完了メッセージ４の取得
     * @return 完了メッセージ４
     * @generated
     */
    public String getMessage4() {
        return message4;
    }

    /**
     * 完了メッセージ４の設定
     * @param message4 完了メッセージ４
     * @generated
     */
    public void setMessage4(String message4) {
        this.message4 = message4;
    }

    /**
     * 戻るリンク名称１の取得
     * @return 戻るリンク名称１
     * @generated
     */
    public String getReturnLinkNm1() {
        return returnLinkNm1;
    }

    /**
     * 戻るリンク名称１の設定
     * @param returnLinkNm1 戻るリンク名称１
     * @generated
     */
    public void setReturnLinkNm1(String returnLinkNm1) {
        this.returnLinkNm1 = returnLinkNm1;
    }

    /**
     * 戻るリンクアクション１の取得
     * @return 戻るリンクアクション１
     * @generated
     */
    public String getReturnLinkURL1() {
        return returnLinkURL1;
    }

    /**
     * 戻るリンクアクション１の設定
     * @param returnLinkURL1 戻るリンクアクション１
     * @generated
     */
    public void setReturnLinkURL1(String returnLinkURL1) {
        this.returnLinkURL1 = returnLinkURL1;
    }

    /**
     * 戻るリンク名称２の取得
     * @return 戻るリンク名称２
     * @generated
     */
    public String getReturnLinkNm2() {
        return returnLinkNm2;
    }

    /**
     * 戻るリンク名称２の設定
     * @param returnLinkNm2 戻るリンク名称２
     * @generated
     */
    public void setReturnLinkNm2(String returnLinkNm2) {
        this.returnLinkNm2 = returnLinkNm2;
    }

    /**
     * 戻るリンクアクション２の取得
     * @return 戻るリンクアクション２
     * @generated
     */
    public String getReturnLinkURL2() {
        return returnLinkURL2;
    }

    /**
     * 戻るリンクアクション２の設定
     * @param returnLinkURL2 戻るリンクアクション２
     * @generated
     */
    public void setReturnLinkURL2(String returnLinkURL2) {
        this.returnLinkURL2 = returnLinkURL2;
    }

    /**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
