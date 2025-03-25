/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_SOS_MST
 * SQLID : selectInitSos
 * @generated
 */
public class SelectInitSosEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 部門ランク (パラメータ)
     * @generated
     */
    private Integer inBumonRank;

    /**
     * 領域コード (パラメータ)
     * @generated
     */
    private String inTrtCd;


	/**
     * 部門ランク
     * @generated
     */
    private Integer bumonRank;

    /**
     * 組織コード
     * @generated
     */
    private String sosCd;

    /**
     * 組織名称
     * @generated
     */
    private String bumonSeiName;

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
     * 医薬営業所配列
     * @generated
     */
    private String distSeq;

    /**
     * 上位組織コード
     * @generated
     */
    private String upSosCode;

    /**
     * 組織名称※上位組織コードに紐づく
     * @generated
     */
    private Integer upBumonRank;

    /**
     * 医薬支店C※上位組織コードに紐づく
     * @generated
     */
    private String upBrCode;

    /**
     * 医薬営業所C※上位組織コードに紐づく
     * @generated
     */
    private String upDistCode;
    /**
     * コンストラクタ
     * @generated
     */
    public SelectInitSosEntity() {
        super("m_rdm_sos_mst" , "selectInitSos");
    }

    /**
     * 部門ランク (パラメータ)の取得
     * @return 部門ランク (パラメータ)
     * @generated
     */
    public Integer getInBumonRank() {
        return inBumonRank;
    }

    /**
     * 部門ランク (パラメータ)の設定
     * @param inBumonRank 部門ランク (パラメータ)
     * @generated
     */
    public void setInBumonRank(Integer inBumonRank) {
        this.inBumonRank = inBumonRank;
    }

    /**
     * 領域コード (パラメータ)の取得
     * @return 領域コード (パラメータ)
     * @generated
     */
	public String getInTrtCd() {
		return inTrtCd;
	}

    /**
     * 領域コード (パラメータ)の設定
     * @param inTrtCd 領域コード (パラメータ)
     * @generated
     */
	public void setInTrtCd(String inTrtCd) {
		this.inTrtCd = inTrtCd;
	}

    /**
     * 部門ランクの取得
     * @param bumonRank 部門ランク
     * @generated
     */
    public Integer getBumonRank() {
		return bumonRank;
	}

    /**
     * 部門ランクの設定
     * @param bumonRank 部門ランク
     * @generated
     */
	public void setBumonRank(Integer bumonRank) {
		this.bumonRank = bumonRank;
	}

    /**
     * 組織コードの取得
     * @param sosCd 組織コード
     * @generated
     */
	public String getSosCd() {
		return sosCd;
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
     * 組織名称の取得
     * @param bumonSeiName 組織名称
     * @generated
     */
	public String getBumonSeiName() {
		return bumonSeiName;
	}

    /**
     * 組織名称の設定
     * @param bumonSeiName 組織名称
     * @generated
     */
	public void setBumonSeiName(String bumonSeiName) {
		this.bumonSeiName = bumonSeiName;
	}

    /**
     * 医薬支店Cの取得
     * @param brCode 医薬支店C
     * @generated
     */
	public String getBrCode() {
		return brCode;
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
     * @param distCode 医薬営業所C
     * @generated
     */
	public String getDistCode() {
		return distCode;
	}

	/**
	 * 医薬営業所配列の取得
	 * @return　医薬営業所配列
	 * @generated
	 */
	public String getDistSeq() {
		return distSeq;
	}

	/**
	 * 医薬営業所配列の設定
	　* @param distSeq　医薬営業所配列
	 *　@generated
	 */
	public void setDistSeq(String distSeq) {
		this.distSeq = distSeq;
	}

	/**
	 * 医薬営業所Cの設定
	　* @param distCode　医薬営業所C
	 *　@generated
	 */
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

    /**
     * 上位組織コードの取得
     * @param upSosCode 上位組織コード
     * @generated
     */
	public String getUpSosCode() {
		return upSosCode;
	}

    /**
     * 上位組織コードの設定
     * @param upSosCode 上位組織コード
     * @generated
     */
	public void setUpSosCode(String upSosCode) {
		this.upSosCode = upSosCode;
	}

    /**
     * 組織名称※上位組織コードに紐づくの取得
     * @param upBumonRank 組織名称※上位組織コードに紐づく
     * @generated
     */
	public Integer getUpBumonRank() {
		return upBumonRank;
	}

    /**
     * 組織名称※上位組織コードに紐づくの設定
     * @param upBumonRank 組織名称※上位組織コードに紐づく
     * @generated
     */
	public void setUpBumonRank(Integer upBumonRank) {
		this.upBumonRank = upBumonRank;
	}

    /**
     * 医薬支店C※上位組織コードに紐づくの取得
     * @param upBrCode 医薬支店C※上位組織コードに紐づく
     * @generated
     */
	public String getUpBrCode() {
		return upBrCode;
	}

    /**
     * 医薬支店C※上位組織コードに紐づくの設定
     * @param upBrCode 医薬支店C※上位組織コードに紐づく
     * @generated
     */
	public void setUpBrCode(String upBrCode) {
		this.upBrCode = upBrCode;
	}

    /**
     * 医薬営業所C※上位組織コードに紐づくの取得
     * @param upDistCode 医薬営業所C※上位組織コードに紐づく
     * @generated
     */
	public String getUpDistCode() {
		return upDistCode;
	}

    /**
     * 医薬営業所C※上位組織コードに紐づくの設定
     * @param upDistCode 医薬営業所C※上位組織コードに紐づく
     * @generated
     */
	public void setUpDistCode(String upDistCode) {
		this.upDistCode = upDistCode;
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
