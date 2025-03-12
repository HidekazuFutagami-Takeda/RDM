/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス
 * @generated
 */
public class JgiData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

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
    private String bumonRyakuName;

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
     * 領域コード
     * @generated
     */
    private String trtCode;

    /**
     * 従業員番号
     * @generated
     */
    private String jgiNo;

    /**
     * 氏名
     * @generated
     */
    private String jgiName;

    /**
     * 領域グループコードコード
     * @generated
     */
    private String trtGrpCd;

    /**
     * 領域名
     * @generated
     */
    private String trtNm;

    /**
     * MR種類
     * @generated
     */
    private String mrCat;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * コンストラクタ
     * @customizable
     */
    public JgiData() {
        // START UOC

        // END UOC
    }

    /**
	 * 部門ランクの取得
	 * @return　部門ランク
	 * @generated
	 */
	public Integer getBumonRank() {
		return bumonRank;
	}

	/**
	 * 部門ランクの設定
	　* @param bumonRank　部門ランク
	 *　@generated
	 */
	public void setBumonRank(Integer bumonRank) {
		this.bumonRank = bumonRank;
	}

	/**
	 * 組織コードの取得
	 * @return　組織コード
	 * @generated
	 */
	public String getSosCd() {
		return sosCd;
	}

	/**
	 * 組織コードの設定
	　* @param sosCd　組織コード
	 *　@generated
	 */
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

	/**
	 * JgiData.javabumonRyakuNameを設定
	 * @return bumonRyakuName
	 */
	public String getBumonRyakuName() {
		return bumonRyakuName;
	}

	/**
	 * @param bumonRyakuName セットする bumonRyakuName
	 */
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
	}

	/**
	 * 医薬支店Cの取得
	 * @return　医薬支店C
	 * @generated
	 */
	public String getBrCode() {
		return brCode;
	}

	/**
	 * 医薬支店Cの設定
	　* @param brCode　医薬支店C
	 *　@generated
	 */
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	/**
	 * 医薬営業所Cの取得
	 * @return　医薬営業所C
	 * @generated
	 */
	public String getDistCode() {
		return distCode;
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
	 * @return　上位組織コード
	 * @generated
	 */
	public String getUpSosCode() {
		return upSosCode;
	}

	/**
	 * 上位組織コードの設定
	　* @param upSosCode　上位組織コード
	 *　@generated
	 */
	public void setUpSosCode(String upSosCode) {
		this.upSosCode = upSosCode;
	}

	/**
	 * 組織名称※上位組織コードに紐づくの取得
	 * @return　組織名称※上位組織コードに紐づく
	 * @generated
	 */
	public Integer getUpBumonRank() {
		return upBumonRank;
	}

	/**
	 * 組織名称※上位組織コードに紐づくの設定
	　* @param upBumonRank　組織名称※上位組織コードに紐づく
	 *　@generated
	 */
	public void setUpBumonRank(Integer upBumonRank) {
		this.upBumonRank = upBumonRank;
	}

	/**
	 * 医薬支店C※上位組織コードに紐づくの取得
	 * @return　医薬支店C※上位組織コードに紐づく
	 * @generated
	 */
	public String getUpBrCode() {
		return upBrCode;
	}

	/**
	 * 医薬支店C※上位組織コードに紐づくの設定
	　* @param upBrCode　医薬支店C※上位組織コードに紐づく
	 *　@generated
	 */
	public void setUpBrCode(String upBrCode) {
		this.upBrCode = upBrCode;
	}

	/**
	 * 医薬営業所C※上位組織コードに紐づくの取得
	 * @return　医薬営業所C※上位組織コードに紐づく
	 * @generated
	 */
	public String getUpDistCode() {
		return upDistCode;
	}

	/**
	 * 医薬営業所C※上位組織コードに紐づくの設定
	　* @param upDistCode　医薬営業所C※上位組織コードに紐づく
	 *　@generated
	 */
	public void setUpDistCode(String upDistCode) {
		this.upDistCode = upDistCode;
	}

	/**
	 * 領域コード
	 * @return　trtCode
	 * @generated
	 */
	public String getTrtCode() {
		return trtCode;
	}

	/**
	 * 領域コード
	　* @param trtCode　領域コードに紐づく
	 *　@generated
	 */
	public void setTrtCode(String trtCode) {
		this.trtCode = trtCode;
	}


	/**
	 * 従業員番号
	 * @return　jgiNo
	 * @generated
	 */
	public String getJgiNo() {
		return jgiNo;
	}

	/**
	 * 従業員番号
	　* @param trtCode　領域コードに紐づく
	 *　@generated
	 */
	public void setJgiNo(String jgiNo) {
		this.jgiNo = jgiNo;
	}


	/**
	 * 氏名
	 * @return　jgiName
	 * @generated
	 */
	public String getJgiName() {
		return jgiName;
	}

	/**
	 * 氏名
	　* @param jgiName　氏名に紐づく
	 *　@generated
	 */
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

    /**
	 * JgiData.javatrtGrpCdを設定
	 * @return trtGrpCd
	 */
	public String getTrtGrpCd() {
		return trtGrpCd;
	}

	/**
	 * @param trtGrpCd セットする trtGrpCd
	 */
	public void setTrtGrpCd(String trtGrpCd) {
		this.trtGrpCd = trtGrpCd;
	}

	/**
	 * JgiData.javatrtNmを設定
	 * @return trtNm
	 */
	public String getTrtNm() {
		return trtNm;
	}

	/**
	 * @param trtNm セットする trtNm
	 */
	public void setTrtNm(String trtNm) {
		this.trtNm = trtNm;
	}

	/**
	 * JgiData.javamrCatを設定
	 * @return mrCat
	 */
	public String getMrCat() {
		return mrCat;
	}

	/**
	 * @param mrCat セットする mrCat
	 */
	public void setMrCat(String mrCat) {
		this.mrCat = mrCat;
	}

	/**
	 * JgiData.javatrtCdを設定
	 * @return trtCd
	 */
	public String getTrtCd() {
		return trtCd;
	}

	/**
	 * @param trtCd セットする trtCd
	 */
	public void setTrtCd(String trtCd) {
		this.trtCd = trtCd;
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
