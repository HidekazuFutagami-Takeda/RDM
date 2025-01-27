/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.entity.join;

import java.io.Serializable;

import jp.co.takeda.jkr.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : S_JKR_M_JGI_MST
 * SQLID : selectCodeMst
 * @generated
 */
public class SelectCodeMstEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * データ区分 (パラメータ1)
     * @generated
     */
    private String inDataKbn;

    /**
     * コード (パラメータ2)
     * @generated
     */
    private String inDataCd;

    /**
     * データ区分
     * @generated
     */
    private String dataKbn;

    /**
     * コード
     * @generated
     */
    private String dataCd;

    /**
     * 名称
     * @generated
     */
    private String dataName;

    /**
     * 値
     * @generated
     */
    private int dataValue;

    /**
     * 表示順
     * @generated
     */
    private int dataSeq;

    /**
     * デフォルトフラグ
     * @generated
     */
    private int defFlg;

    /**
     * 備考
     * @generated
     */
    private String biko;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectCodeMstEntity() {
        super("s_jkr_m_jgi_mst" , "selectCodeMst");
    }

    /**
     * データ区分の取得
     * @return データ区分
     * @generated
     */
    public String getInDataKbn() {
        return inDataKbn;
    }

    /**
     * データ区分の設定
     * @param inDataKbn データ区分
     * @generated
     */
    public void setInDataKbn(String inDataKbn) {
        this.inDataKbn = inDataKbn;
    }

    /**
     * コードの取得
     * @return コード
     * @generated
     */
    public String getInDataCd() {
        return inDataCd;
    }

    /**
     * コードの設定
     * @param inDataCd コード
     * @generated
     */
    public void setInDataCd(String inDataCd) {
        this.inDataCd = inDataCd;
    }

    /**
     * データ区分の取得
     * @return データ区分
     * @generated
     */
    public String getDataKbn() {
        return dataKbn;
    }

    /**
     * データ区分の設定
     * @param dataKbn データ区分
     * @generated
     */
    public void setDataKbn(String dataKbn) {
        this.dataKbn = dataKbn;
    }

    /**
     * コードの取得
     * @return コード
     * @generated
     */
    public String getDataCd() {
        return dataCd;
    }

    /**
     * コードの設定
     * @param dataCd コード
     * @generated
     */
    public void setDataCd(String dataCd) {
        this.dataCd = dataCd;
    }

    /**
     * 名称の取得
     * @return 名称
     * @generated
     */
    public String getDataName() {
        return dataName;
    }

    /**
     * 名称の設定
     * @param dataName 名称
     * @generated
     */
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    /**
     * 値の取得
     * @return 値
     * @generated
     */
    public int getDataValue() {
        return dataValue;
    }

    /**
     * 値の設定
     * @param dataValue 値
     * @generated
     */
    public void setDataValue(int dataValue) {
        this.dataValue = dataValue;
    }

    /**
     * 表示順の取得
     * @return 表示順
     * @generated
     */
    public int getDataSeq() {
        return dataSeq;
    }

    /**
     * 表示順の設定
     * @param dataSeq 表示順
     * @generated
     */
    public void setDataSeq(int dataSeq) {
        this.dataSeq = dataSeq;
    }

    /**
     * デフォルトフラグの取得
     * @return デフォルトフラグ
     * @generated
     */
    public int getDefFlg() {
        return defFlg;
    }

    /**
     * デフォルトフラグの設定
     * @param defFlg デフォルトフラグ
     * @generated
     */
    public void setDefFlg(int defFlg) {
        this.defFlg = defFlg;
    }

    /**
     * 備考の取得
     * @return 備考
     * @generated
     */
    public String getBiko() {
        return biko;
    }

    /**
     * 備考の設定
     * @param biko 備考
     * @generated
     */
    public void setBiko(String biko) {
        this.biko = biko;
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
