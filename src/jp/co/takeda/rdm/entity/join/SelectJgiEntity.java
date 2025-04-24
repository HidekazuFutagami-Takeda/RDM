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
 * SQLID : selectJgi
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
     * 上位組織コード親画面 (パラメータ)
     * @generated
     */
    private String inUpSosCdPop;

    /**
     * 組織コード親画面 (パラメータ)
     * @generated
     */
    private String inSosCdPop;

    /**
     * 組織コード親画面 (パラメータ)
     * @generated
     */
    private String inSosCdSearch;

    /**
     * 部門ランク親画面 (パラメータ)
     * @generated
     */
    private Integer inBumonRankPop;

    /**
     * 条件セット(パラメータ)
     * @generated
     */
    private String inJokenSetCd;

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
     * 部門ランク
     * @generated
     */
    private Integer jgiNo;


    /**
     * 従業員名
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
     * 従業員名 ポップアップ表示用
     * @generated
     */
    private String gmnJgiName;

    /**
     * 下部組織件数
     * @generated
     */
    private String underSosCnt;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    public SelectJgiEntity() {
        super("m_rdm_jgi_sos_mst","selectJgi");
    }

	/**
	 * SelectJgiEntity.javainBumonRankを設定
	 * @return inBumonRank
	 */
	public Integer getInBumonRank() {
		return inBumonRank;
	}

	/**
	 * @param inBumonRank セットする inBumonRank
	 */
	public void setInBumonRank(Integer inBumonRank) {
		this.inBumonRank = inBumonRank;
	}

	/**
	 * SelectJgiEntity.javainUpSosCdを設定
	 * @return inUpSosCd
	 */
	public String getInUpSosCd() {
		return inUpSosCd;
	}

	/**
	 * @param inUpSosCd セットする inUpSosCd
	 */
	public void setInUpSosCd(String inUpSosCd) {
		this.inUpSosCd = inUpSosCd;
	}

	/**
	 * SelectJgiEntity.javainGmnFlgを設定
	 * @return inGmnFlg
	 */
	public Integer getInGmnFlg() {
		return inGmnFlg;
	}

	/**
	 * @param inGmnFlg セットする inGmnFlg
	 */
	public void setInGmnFlg(Integer inGmnFlg) {
		this.inGmnFlg = inGmnFlg;
	}

	/**
	 * SelectJgiEntity.javainSosCdを設定
	 * @return inSosCd
	 */
	public String getInSosCd() {
		return inSosCd;
	}

	/**
	 * @param inSosCd セットする inSosCd
	 */
	public void setInSosCd(String inSosCd) {
		this.inSosCd = inSosCd;
	}

	/**
	 * SelectJgiEntity.javainTrtCdを設定
	 * @return inTrtCd
	 */
	public String getInTrtCd() {
		return inTrtCd;
	}

	/**
	 * @param inTrtCd セットする inTrtCd
	 */
	public void setInTrtCd(String inTrtCd) {
		this.inTrtCd = inTrtCd;
	}

	/**
	 * SelectJgiEntity.javainAddrCodePrefを設定
	 * @return inAddrCodePref
	 */
	public String getInAddrCodePref() {
		return inAddrCodePref;
	}

	/**
	 * @param inAddrCodePref セットする inAddrCodePref
	 */
	public void setInAddrCodePref(String inAddrCodePref) {
		this.inAddrCodePref = inAddrCodePref;
	}

	/**
	 * SelectJgiEntity.javainTkCityCdを設定
	 * @return inTkCityCd
	 */
	public String getInTkCityCd() {
		return inTkCityCd;
	}

	/**
	 * @param inTkCityCd セットする inTkCityCd
	 */
	public void setInTkCityCd(String inTkCityCd) {
		this.inTkCityCd = inTkCityCd;
	}

	/**
	 * SelectJgiEntity.javainUpSosCdPopを設定
	 * @return inUpSosCdPop
	 */
	public String getInUpSosCdPop() {
		return inUpSosCdPop;
	}

	/**
	 * @param inUpSosCdPop セットする inUpSosCdPop
	 */
	public void setInUpSosCdPop(String inUpSosCdPop) {
		this.inUpSosCdPop = inUpSosCdPop;
	}

	/**
	 * SelectJgiEntity.javainSosCdPopを設定
	 * @return inSosCdPop
	 */
	public String getInSosCdPop() {
		return inSosCdPop;
	}

	/**
	 * @param inSosCdPop セットする inSosCdPop
	 */
	public void setInSosCdPop(String inSosCdPop) {
		this.inSosCdPop = inSosCdPop;
	}

	/**
	 * SelectJgiEntity.javainBumonRankPopを設定
	 * @return inBumonRankPop
	 */
	public Integer getInBumonRankPop() {
		return inBumonRankPop;
	}

	/**
	 * @param inBumonRankPop セットする inBumonRankPop
	 */
	public void setInBumonRankPop(Integer inBumonRankPop) {
		this.inBumonRankPop = inBumonRankPop;
	}

	/**
	 * SelectJgiEntity.javabumonRankを設定
	 * @return bumonRank
	 */
	public Integer getBumonRank() {
		return bumonRank;
	}

	/**
	 * @param bumonRank セットする bumonRank
	 */
	public void setBumonRank(Integer bumonRank) {
		this.bumonRank = bumonRank;
	}

	/**
	 * SelectJgiEntity.javasosCdを設定
	 * @return sosCd
	 */
	public String getSosCd() {
		return sosCd;
	}

	/**
	 * @param sosCd セットする sosCd
	 */
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

	/**
	 * SelectJgiEntity.javabumonRyakuNameを設定
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
	 * SelectJgiEntity.javabrCodeを設定
	 * @return brCode
	 */
	public String getBrCode() {
		return brCode;
	}

	/**
	 * @param brCode セットする brCode
	 */
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	/**
	 * SelectJgiEntity.javadistCodeを設定
	 * @return distCode
	 */
	public String getDistCode() {
		return distCode;
	}

	/**
	 * @param distCode セットする distCode
	 */
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	/**
	 * SelectJgiEntity.javadistSeqを設定
	 * @return distSeq
	 */
	public String getDistSeq() {
		return distSeq;
	}

	/**
	 * @param distSeq セットする distSeq
	 */
	public void setDistSeq(String distSeq) {
		this.distSeq = distSeq;
	}

	/**
	 * SelectJgiEntity.javaupSosCodeを設定
	 * @return upSosCode
	 */
	public String getUpSosCode() {
		return upSosCode;
	}

	/**
	 * @param upSosCode セットする upSosCode
	 */
	public void setUpSosCode(String upSosCode) {
		this.upSosCode = upSosCode;
	}

	/**
	 * SelectJgiEntity.javajgiNoを設定
	 * @return jgiNo
	 */
	public Integer getJgiNo() {
		return jgiNo;
	}

	/**
	 * @param jgiNo セットする jgiNo
	 */
	public void setJgiNo(Integer jgiNo) {
		this.jgiNo = jgiNo;
	}

	/**
	 * SelectJgiEntity.javajgiNameを設定
	 * @return jgiName
	 */
	public String getJgiName() {
		return jgiName;
	}

	/**
	 * @param jgiName セットする jgiName
	 */
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	/**
	 * SelectJgiEntity.javatrtGrpCdを設定
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
	 * SelectJgiEntity.javatrtNmを設定
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
	 * SelectJgiEntity.javamrCatを設定
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
	 * SelectJgiEntity.javatrtCdを設定
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
	 * SelectJgiEntity.javagmnJgiNameを設定
	 * @return gmnJgiName
	 */
	public String getGmnJgiName() {
		return gmnJgiName;
	}

	/**
	 * @param gmnJgiName セットする gmnJgiName
	 */
	public void setGmnJgiName(String gmnJgiName) {
		this.gmnJgiName = gmnJgiName;
	}

	/**
	 * SelectJgiEntity.javainJokenSetCdを設定
	 * @return inJokenSetCd
	 */
	public String getInJokenSetCd() {
		return inJokenSetCd;
	}

	/**
	 * @param inJokenSetCd セットする inJokenSetCd
	 */
	public void setInJokenSetCd(String inJokenSetCd) {
		this.inJokenSetCd = inJokenSetCd;
	}

	/**
	 * SelectJgiEntity.javaunderSosCntを設定
	 * @return underSosCnt
	 */
	public String getUnderSosCnt() {
		return underSosCnt;
	}

	/**
	 * @param underSosCnt セットする underSosCnt
	 */
	public void setUnderSosCnt(String underSosCnt) {
		this.underSosCnt = underSosCnt;
	}

	/**
	 * SelectJgiEntity.javainSosCdSearchを設定
	 * @return inSosCdSearch
	 */
	public String getInSosCdSearch() {
		return inSosCdSearch;
	}

	/**
	 * @param inSosCdSearch セットする inSosCdSearch
	 */
	public void setInSosCdSearch(String inSosCdSearch) {
		this.inSosCdSearch = inSosCdSearch;
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