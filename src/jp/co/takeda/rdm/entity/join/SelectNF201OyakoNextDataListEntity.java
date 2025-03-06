/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_HCO_LNK_NXT_REQ
 * SQLID : selectNF201TkdDataList, selectNF201TrtDataList
 * @generated
 */
public class SelectNF201OyakoNextDataListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_施設固定コード(パラメータ1)
     * @generated
     */
    private String inInsNo;

    /**
     * 適用日
     * @generated
     */
    private String tekiyoYmd;

    /**
     * アクション
     * @generated
     */
    private String action;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;

    /**
     * 領域名
     * @generated
     */
    private String trtNm;

    /**
     * 品目グループコード
     * @generated
     */
    private String hinGCd;

    /**
     * 品目グループ名
     * @generated
     */
    private String hinGNm;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 住所
     * @generated
     */
    private String insAddr;

    /**
     * 親施設コード
     * @generated
     */
    private String mainInsNo;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNF201OyakoNextDataListEntity() {
        super("t_rdm_hco_lnk_nxt_req" , "selectNF201TkdDataList");
    }

	/**
	 * SelectNF201OyakoNextDataListEntity.javainInsNoを設定
	 * @return inInsNo
	 */
	public String getInInsNo() {
		return inInsNo;
	}

	/**
	 * @param inInsNo セットする inInsNo
	 */
	public void setInInsNo(String inInsNo) {
		this.inInsNo = inInsNo;
	}

	/**
	 * SelectNF201OyakoNextDataListEntity.javatekiyoYmdを設定
	 * @return tekiyoYmd
	 */
	public String getTekiyoYmd() {
		return tekiyoYmd;
	}

	/**
	 * @param tekiyoYmd セットする tekiyoYmd
	 */
	public void setTekiyoYmd(String tekiyoYmd) {
		this.tekiyoYmd = tekiyoYmd;
	}

	/**
	 * SelectNF201OyakoNextDataListEntity.javaactionを設定
	 * @return action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action セットする action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * SelectNF201OyakoNextDataListEntity.javatrtCdを設定
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
	 * SelectNF201OyakoNextDataListEntity.javatrtNmを設定
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
	 * SelectNF201OyakoNextDataListEntity.javahinGCdを設定
	 * @return hinGCd
	 */
	public String getHinGCd() {
		return hinGCd;
	}

	/**
	 * @param hinGCd セットする hinGCd
	 */
	public void setHinGCd(String hinGCd) {
		this.hinGCd = hinGCd;
	}

	/**
	 * SelectNF201OyakoNextDataListEntity.javahinGNmを設定
	 * @return hinGNm
	 */
	public String getHinGNm() {
		return hinGNm;
	}

	/**
	 * @param hinGNm セットする hinGNm
	 */
	public void setHinGNm(String hinGNm) {
		this.hinGNm = hinGNm;
	}

	/**
	 * SelectNF201OyakoNextDataListEntity.javainsAbbrNameを設定
	 * @return insAbbrName
	 */
	public String getInsAbbrName() {
		return insAbbrName;
	}

	/**
	 * @param insAbbrName セットする insAbbrName
	 */
	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

	/**
	 * SelectNF201OyakoNextDataListEntity.javainsAddrを設定
	 * @return insAddr
	 */
	public String getInsAddr() {
		return insAddr;
	}

	/**
	 * @param insAddr セットする insAddr
	 */
	public void setInsAddr(String insAddr) {
		this.insAddr = insAddr;
	}

	/**
	 * SelectNF201OyakoNextDataListEntity.javamainInsNoを設定
	 * @return mainInsNo
	 */
	public String getMainInsNo() {
		return mainInsNo;
	}

	/**
	 * @param mainInsNo セットする mainInsNo
	 */
	public void setMainInsNo(String mainInsNo) {
		this.mainInsNo = mainInsNo;
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
