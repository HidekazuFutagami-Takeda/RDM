/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.entity;

import java.io.Serializable;

import jp.co.takeda.jkr.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : RDM_MSG_MST
 * テーブル論理名 : 担当変更システムメッセージマスタ
 * @generated
 */
public class RdmMsgMstEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * メッセージコード (PK)
     * @generated
     */
    private String msgCd;

    /**
     * メッセージ
     * @generated
     */
    private String msgData;
    private boolean msgDataNullFlag;

    /**
     * 値
     * @generated
     */
    private Integer dataValue;
    private boolean dataValueNullFlag;

    /**
     * フォントサイズ
     * @generated
     */
    private Integer fontSize;

	private boolean fontSizeNullFlag;

	/**
     * 文字色
     * @generated
     */
    private String color;

	private boolean colorNullFlag;

	/**
     * 太字
     * @generated
     */
    private String bold;

	private boolean boldNullFlag;

	/**
     * 斜体
     * @generated
     */
    private String italic;

	private boolean italicNullFlag;

	/**
     * 下線
     * @generated
     */
    private String underLine;

	private boolean underLineNullFlag;

	/**
     * テキスト配置
     * @generated
     */
    private String textAlign;

	private boolean textAlignNullFlag;

	/**
     * 最終更新者
     * @generated
     */
    private Integer upJgiNo;
    private boolean upJgiNoNullFlag;

    /**
     * 作成日
     * @generated
     */
    private Date insShaYmd;

	/**
     * 作成者
     * @generated
     */
    private String insShaId;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;

	/**
     * 更新者
     * @generated
     */
    private String updShaId;

    /**
     * コンストラクタ
     * @generated
     */
    public RdmMsgMstEntity() {
        super("rdm_msg_mst");
    }

    /**
     * コンストラクタ
     * @param msgCd メッセージコード
     * @generated
     */
    public RdmMsgMstEntity(String msgCd) {
        super("rdm_msg_mst");
        this.msgCd = msgCd;
    }

    /**
     * メッセージコードの取得
     * @return メッセージコード
     * @generated
     */
    public String getMsgCd() {
        return this.msgCd;
    }

    /**
     * メッセージコードの設定
     * @param msgCd メッセージコード
     * @generated
     */
    public void setMsgCd(String msgCd) {
        this.msgCd = msgCd;
    }

    /**
     * メッセージの取得
     * @return メッセージ
     * @generated
     */
    public String getMsgData() {
        return this.msgData;
    }

    /**
     * メッセージの設定
     * @param msgData メッセージ
     * @generated
     */
    public void setMsgData(String msgData) {
        this.msgData = msgData;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isMsgDataNullFlag() {
        return this.msgDataNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param msgDataNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setMsgDataNullFlag(boolean msgDataNullFlag) {
        this.msgDataNullFlag = msgDataNullFlag;
    }

    /**
     * 値の取得
     * @return 値
     * @generated
     */
    public Integer getDataValue() {
        return this.dataValue;
    }

    /**
     * 値の設定
     * @param dataValue 値
     * @generated
     */
    public void setDataValue(Integer dataValue) {
        this.dataValue = dataValue;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isDataValueNullFlag() {
        return this.dataValueNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param dataValueNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setDataValueNullFlag(boolean dataValueNullFlag) {
        this.dataValueNullFlag = dataValueNullFlag;
    }

    /**
     * フォントサイズの取得
     * @return フォントサイズ
     * @generated
     */
    public Integer getFontSize() {
        return this.fontSize;
    }

	/**
     * フォントサイズの設定
     * @param fontSize フォントサイズ
     * @generated
     */
    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

	/**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isFontSizeNullFlag() {
        return this.fontSizeNullFlag;
    }

	/**
     * NULL更新するかのフラグの設定
     * @param fontSizeNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setFontSizeNullFlag(boolean fontSizeNullFlag) {
        this.fontSizeNullFlag = fontSizeNullFlag;
    }

	/**
     * 文字色の取得
     * @return 文字色
     * @generated
     */
    public String getColor() {
        return this.color;
    }

	/**
     * 文字色の設定
     * @param color 文字色
     * @generated
     */
    public void setColor(String color) {
        this.color = color;
    }

	/**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isColorNullFlag() {
        return this.colorNullFlag;
    }

	/**
     * NULL更新するかのフラグの設定
     * @param colorNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setColorNullFlag(boolean colorNullFlag) {
        this.colorNullFlag = colorNullFlag;
    }

	/**
     * 太字の取得
     * @return 太字
     * @generated
     */
    public String getBold() {
        return this.bold;
    }

	/**
     * 太字の設定
     * @param bold 太字
     * @generated
     */
    public void setBold(String bold) {
        this.bold = bold;
    }

	/**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBoldNullFlag() {
        return this.boldNullFlag;
    }

	/**
     * NULL更新するかのフラグの設定
     * @param boldNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBoldNullFlag(boolean boldNullFlag) {
        this.boldNullFlag = boldNullFlag;
    }

	/**
     * 斜体の取得
     * @return 斜体
     * @generated
     */
    public String getItalic() {
        return this.italic;
    }

	/**
     * 斜体の設定
     * @param italic 斜体
     * @generated
     */
    public void setItalic(String italic) {
        this.italic = italic;
    }

	/**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isItalicNullFlag() {
        return this.italicNullFlag;
    }

	/**
     * NULL更新するかのフラグの設定
     * @param italicNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setItalicNullFlag(boolean italicNullFlag) {
        this.italicNullFlag = italicNullFlag;
    }

	/**
     * 下線の取得
     * @return 下線
     * @generated
     */
    public String getUnderLine() {
        return this.underLine;
    }

	/**
     * 下線の設定
     * @param underLine 下線
     * @generated
     */
    public void setUnderLine(String underLine) {
        this.underLine = underLine;
    }

	/**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isUnderLineNullFlag() {
        return this.underLineNullFlag;
    }

	/**
     * NULL更新するかのフラグの設定
     * @param underLineNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setUnderLineNullFlag(boolean underLineNullFlag) {
        this.underLineNullFlag = underLineNullFlag;
    }

	/**
     * テキスト配置の取得
     * @return テキスト配置
     * @generated
     */
    public String getTextAlign() {
        return this.textAlign;
    }

	/**
     * テキスト配置の設定
     * @param textAlign テキスト配置
     * @generated
     */
    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

	/**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isTextAlignNullFlag() {
        return this.textAlignNullFlag;
    }

	/**
     * NULL更新するかのフラグの設定
     * @param textAlignNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setTextAlignNullFlag(boolean textAlignNullFlag) {
        this.textAlignNullFlag = textAlignNullFlag;
    }

	/**
     * 最終更新者の取得
     * @return 最終更新者
     * @generated
     */
    public Integer getUpJgiNo() {
        return this.upJgiNo;
    }

    /**
     * 最終更新者の設定
     * @param upJgiNo 最終更新者
     * @generated
     */
    public void setUpJgiNo(Integer upJgiNo) {
        this.upJgiNo = upJgiNo;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isUpJgiNoNullFlag() {
        return this.upJgiNoNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param upJgiNoNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setUpJgiNoNullFlag(boolean upJgiNoNullFlag) {
        this.upJgiNoNullFlag = upJgiNoNullFlag;
    }

    /**
     * 作成日の取得
     * @return 作成日
     * @generated
     */
    public Date getInsShaYmd() {
        return this.insShaYmd;
    }

    /**
     * 作成日の設定
     * @param insShaYmd 作成日
     * @generated
     */
    public void setInsShaYmd(Date insShaYmd) {
        this.insShaYmd = insShaYmd;
    }

	/**
     * 作成者の取得
     * @return 作成者
     * @generated
     */
    public String getInsShaId() {
        return this.insShaId;
    }

	/**
     * 作成者の設定
     * @param insShaId 作成者
     * @generated
     */
    public void setInsShaId(String insShaId) {
        this.insShaId = insShaId;
    }

    /**
     * 更新日の取得
     * @return 作成日
     * @generated
     */
    public Date getUpdShaYmd() {
        return this.updShaYmd;
    }

    /**
     * 更新日の設定
     * @param updShaYmd 更新日
     * @generated
     */
    public void setUpdShaYmd(Date updShaYmd) {
        this.updShaYmd = updShaYmd;
    }

	/**
     * 更新者の取得
     * @return 更新者
     * @generated
     */
    public String getUpdShaId() {
        return this.updShaId;
    }

	/**
     * 更新者の設定
     * @param updShaId 更新者
     * @generated
     */
    public void setUpdShaId(String updShaId) {
        this.updShaId = updShaId;
    }

    /**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
