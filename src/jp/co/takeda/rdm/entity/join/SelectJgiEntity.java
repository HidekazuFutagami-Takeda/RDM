/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_JGI_SOS_MST
 * SQLID : selectInitJgi
 * @generated
 */
public class SelectJgiEntity extends BaseEntity implements Serializable {

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
     * 上位組織コード (パラメータ)
     * @generated
     */
    private String inUpSosCd;

    /**
     * 画面フラグ (パラメータ)
     * @generated
     */
    private Integer inGmnFlg;

    /**
     * 組織コード (パラメータ)
     * @generated
     */
    private String inSosCd;

    /**
     * 領域コード (パラメータ)
     * @generated
     */
    private String inTrtCd;

    /**
     * JIS府県コード (パラメータ)
     * @generated
     */
    private String inAddrCodePref;

    /**
     * 武田市区町村コード (パラメータ)
     * @generated
     */
    private String inTkCityCd;

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
     * 部門ランク
     * @generated
     */
    private Integer jgiNo;


    /**
     * 従業員名
     * @generated
     */
    private String jgiName;

    public SelectJgiEntity() {
        super("m_rdm_jgi_sos_mst","selectJgi");
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
     * 上位組織コード (パラメータ)の取得
     * @return 上位組織コード (パラメータ)
     * @generated
     */
	public String getInUpSosCd() {
		return inUpSosCd;
	}

    /**
     * 上位組織コード (パラメータ)の設定
     * @param inUpSosCd 上位組織コード (パラメータ)
     * @generated
     */
	public void setInUpSosCd(String inUpSosCd) {
		this.inUpSosCd = inUpSosCd;
	}

    /**
     * 画面フラグ (パラメータ)の取得
     * @return 画面フラグ (パラメータ)
     * @generated
     */
    public Integer getInGmnFlg() {
        return inGmnFlg;
    }

    /**
     * 画面フラグ(パラメータ)の設定
     * @param inGmnFlg 画面フラグ (パラメータ)
     * @generated
     */
    public void setInGmnFlg(Integer inGmnFlg) {
        this.inGmnFlg = inGmnFlg;
    }

    /**
     * 組織コード (パラメータ)の取得
     * @return 組織コード (パラメータ)
     * @generated
     */
	public String getInSosCd() {
		return inSosCd;
	}

    /**
     * 組織コード (パラメータ)の設定
     * @param inSosCd 組織コード (パラメータ)
     * @generated
     */
	public void setInSosCd(String inSosCd) {
		this.inSosCd = inSosCd;
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
     * JIS府県コード (パラメータ)の取得
     * @return JIS府県コード (パラメータ)
     * @generated
     */
	public String getInAddrCodePref() {
		return inAddrCodePref;
	}

    /**
     * JIS府県コード (パラメータ)の設定
     * @param inAddrCodePref JIS府県コード (パラメータ)
     * @generated
     */
	public void setInAddrCodePref(String inAddrCodePref) {
		this.inAddrCodePref = inAddrCodePref;
	}

    /**
     * 武田市区町村コード (パラメータ)の取得
     * @return 武田市区町村コード (パラメータ)
     * @generated
     */
	public String getInTkCityCd() {
		return inTkCityCd;
	}

    /**
     * 武田市区町村コード (パラメータ)の設定
     * @param inTkCityCd 武田市区町村コードド (パラメータ)
     * @generated
     */
	public void setInTkCityCd(String inTkCityCd) {
		this.inTkCityCd = inTkCityCd;
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
     * 医薬営業所Cの設定
     * @param distCode 医薬営業所C
     * @generated
     */
	public void setDistCode(String distCode) {
		this.distCode = distCode;
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
     * 従業員番号の取得
     * @param jgiNo 従業員番号
     * @generated
     */
    public Integer getJgiNo() {
		return jgiNo;
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
     * @param jgiName 氏名
     * @generated
     */
    public String getJgiName() {
		return jgiName;
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
