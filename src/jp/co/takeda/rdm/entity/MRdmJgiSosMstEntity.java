/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_JGI_SOS_MST
 * テーブル論理名 : RDM用組織従業員情報
 * @generated
 */
public class MRdmJgiSosMstEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 従業員番号
     * @generated
     */
    private Integer jgiNo;

    /**
     * 氏名
     * @generated
     */
    private String jgiName;

    /**
     * 組織コード
     * @generated
     */
    private String sosCd;

    /**
     * 医薬支店C
     * @generated
     */
    private String brCode;

    /**
     * 医薬営業所C
     * @generated
     */
    private String distCode;

    /**
     * 部門名略式
     * @generated
     */
    private String bumonRyakuName;

    /**
     * 部門ランク
     * @generated
     */
    private String bumonRank;

    /**
     * 上位組織コード
     * @generated
     */
    private String upSosCd;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * コンストラクタ
     * @generated
     */
    public MRdmJgiSosMstEntity() {
        super("m_rdm_jgi_sos_mst");
    }

    /**
     * 従業員番号の取得
     * @return 従業員番号
     * @generated
     */
    public Integer getJgiNo() {
        return this.jgiNo;
    }

    /**
     * 従業員番号の設定
     * @param jgiNo 従業員番号
     * @generated
     */
    public void setJgiNo(Integer jgiNo) {
        this.jgiNo = jgiNo;
    }

    /**
     * 氏名の取得
     * @return 氏名
     * @generated
     */
    public String getJgiName() {
        return this.jgiName;
    }

    /**
     * 氏名の設定
     * @param jgiName 氏名
     * @generated
     */
    public void setJgiName(String jgiName) {
        this.jgiName = jgiName;
    }

    /**
     * 組織コードの取得
     * @return 組織コード
     * @generated
     */
    public String getSosCd() {
        return this.sosCd;
    }

    /**
     * 組織コードの設定
     * @param sosCd 組織コード
     * @generated
     */
    public void setSosCd(String sosCd) {
        this.sosCd = sosCd;
    }

    /**
     * 医薬支店Cの取得
     * @return 医薬支店C
     * @generated
     */
    public String getBrCode() {
        return this.brCode;
    }

    /**
     * 医薬支店Cの設定
     * @param brCode 医薬支店C
     * @generated
     */
    public void setBrCode(String brCode) {
        this.brCode = brCode;
    }

    /**
     * 医薬営業所Cの取得
     * @return 医薬営業所C
     * @generated
     */
    public String getDistCode() {
        return this.distCode;
    }

    /**
     * 医薬営業所Cの設定
     * @param distCode 医薬営業所C
     * @generated
     */
    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }

    /**
     * 部門名略式の取得
     * @return 部門名略式
     * @generated
     */
    public String getBumonRyakuName() {
        return this.bumonRyakuName;
    }

    /**
     * 部門名略式の設定
     * @param bumonRyakuName 部門名略式
     * @generated
     */
    public void setBumonRyakuName(String bumonRyakuName) {
        this.bumonRyakuName = bumonRyakuName;
    }

    /**
     * 部門ランクの取得
     * @return 部門ランク
     * @generated
     */
    public String getBumonRank() {
        return this.bumonRank;
    }

    /**
     * 部門ランクの設定
     * @param bumonRank 部門ランク
     * @generated
     */
    public void setBumonRank(String bumonRank) {
        this.bumonRank = bumonRank;
    }

    /**
     * 上位組織コードの取得
     * @return 上位組織コード
     * @generated
     */
    public String getUpSosCd() {
        return this.upSosCd;
    }

    /**
     * 上位組織コードの設定
     * @param upSosCd 上位組織コード
     * @generated
     */
    public void setUpSosCd(String upSosCd) {
        this.upSosCd = upSosCd;
    }

    /**
     * 領域コードの取得
     * @return 領域コード
     * @generated
     */
    public String getTrtCd() {
        return this.trtCd;
    }

    /**
     * 領域コードの設定
     * @param trtCd 領域コード
     * @generated
     */
    public void setTrtCd(String trtCd) {
        this.trtCd = trtCd;
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
