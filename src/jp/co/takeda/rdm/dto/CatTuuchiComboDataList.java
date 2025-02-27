/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;


/**
 * DTOクラス
 * @generated
 */
public class CatTuuchiComboDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 選択
     * @generated
     */
    private boolean checkers;


	private String ntyId;

	private String ntyBri;

	private String ntySts;

	private String ntyPri;

	private String ssUpdYmdhms;

	private String ntySubject;

	private String ntyData;

	private String ntyMemo;

	private String youFlg;


	/**
	 * 検索-申請日時
	 * inreqYmdhmsFrom
	 * @generated
	 */

	private String inhisYmdhmsFrom;
	/**
	 * 検索-申請日時
	 * inreqYmdhmsTo
	 * @generated
	 */

	private String inhisYmdhmsTo;

	/**
	 * reqYmdhmsFrom
	 * @generated
	 */

	private String hisYmdhmsFrom;
	/**
	 * reqYmdhmsTo
	 * @generated
	 */

	private String hisYmdhmsTo;



        /**
     * reqJgiName
     * @generated
     */

    private String reqJgiName;

	    /**
	 * reqJgiNo
	 * @generated
	 */

	private String reqJgiNo;


    /**
     * 遷移元画面ID
     */
	private String preScreenId;
	public String getPreScreenId() {
		return preScreenId;
	}

	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

    /**
     * コンストラクタ
     * @customizable
     */
    public CatTuuchiComboDataList() {
        // START UOC

        // END UOC
    }

    // START UOC

    // END UOC

     /**
     * 選択の取得
     * @return 選択
     * @generated
     */
    public boolean getCheckers() {
        return checkers;
    }

    /**
     * 選択の設定
     * @param checkers 選択
     * @generated
     */
    public void setCheckers(boolean checkers) {
        this.checkers = checkers;
    }


    /**
     * 検索条件_申請者名
     */
    public String getReqJgiName() {
        return reqJgiName;
    }
    /**
    * 申請者名の設定
    * @param sysCd 申請者名
    */
   public void setReqJgiName(String reqJgiName) {
       this.reqJgiName = reqJgiName;
   }

	/**
	 * 申請者従業員番号を取得します。
	 * @return reqJgiName
	 */
   public String getReqJgiNo() {
		return reqJgiNo;
	}
	public void setReqJgiNo(String reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}

	/**
	 * CatTuuchiComboDataList.javantyIdを設定
	 * @return ntyId
	 */
	public String getNtyId() {
		return ntyId;
	}

	/**
	 * @param ntyId セットする ntyId
	 */
	public void setNtyId(String ntyId) {
		this.ntyId = ntyId;
	}

	/**
	 * CatTuuchiComboDataList.javantyBriを設定
	 * @return ntyBri
	 */
	public String getNtyBri() {
		return ntyBri;
	}

	/**
	 * @param ntyBri セットする ntyBri
	 */
	public void setNtyBri(String ntyBri) {
		this.ntyBri = ntyBri;
	}

	/**
	 * CatTuuchiComboDataList.javantyStsを設定
	 * @return ntySts
	 */
	public String getNtySts() {
		return ntySts;
	}

	/**
	 * @param ntySts セットする ntySts
	 */
	public void setNtySts(String ntySts) {
		this.ntySts = ntySts;
	}

	/**
	 * CatTuuchiComboDataList.javantyPriを設定
	 * @return ntyPri
	 */
	public String getNtyPri() {
		return ntyPri;
	}

	/**
	 * @param ntyPri セットする ntyPri
	 */
	public void setNtyPri(String ntyPri) {
		this.ntyPri = ntyPri;
	}

	/**
	 * CatTuuchiComboDataList.javassUpdYmdhmsを設定
	 * @return ssUpdYmdhms
	 */
	public String getSsUpdYmdhms() {
		return ssUpdYmdhms;
	}

	/**
	 * @param ssUpdYmdhms セットする ssUpdYmdhms
	 */
	public void setSsUpdYmdhms(String ssUpdYmdhms) {
		this.ssUpdYmdhms = ssUpdYmdhms;
	}

	/**
	 * CatTuuchiComboDataList.javantySubjectを設定
	 * @return ntySubject
	 */
	public String getNtySubject() {
		return ntySubject;
	}

	/**
	 * @param ntySubject セットする ntySubject
	 */
	public void setNtySubject(String ntySubject) {
		this.ntySubject = ntySubject;
	}

	/**
	 * CatTuuchiComboDataList.javantyDataを設定
	 * @return ntyData
	 */
	public String getNtyData() {
		return ntyData;
	}

	/**
	 * @param ntyData セットする ntyData
	 */
	public void setNtyData(String ntyData) {
		this.ntyData = ntyData;
	}

	/**
	 * CatTuuchiComboDataList.javantyMemoを設定
	 * @return ntyMemo
	 */
	public String getNtyMemo() {
		return ntyMemo;
	}

	/**
	 * @param ntyMemo セットする ntyMemo
	 */
	public void setNtyMemo(String ntyMemo) {
		this.ntyMemo = ntyMemo;
	}

	/**
	 * CatTuuchiComboDataList.javayouFlgを設定
	 * @return youFlg
	 */
	public String getYouFlg() {
		return youFlg;
	}

	/**
	 * @param youFlg セットする youFlg
	 */
	public void setYouFlg(String youFlg) {
		this.youFlg = youFlg;
	}

	/**
	 * CatTuuchiComboDataList.javainhisYmdhmsFromを設定
	 * @return inhisYmdhmsFrom
	 */
	public String getInhisYmdhmsFrom() {
		return inhisYmdhmsFrom;
	}

	/**
	 * @param inhisYmdhmsFrom セットする inhisYmdhmsFrom
	 */
	public void setInhisYmdhmsFrom(String inhisYmdhmsFrom) {
		this.inhisYmdhmsFrom = inhisYmdhmsFrom;
	}

	/**
	 * CatTuuchiComboDataList.javainhisYmdhmsToを設定
	 * @return inhisYmdhmsTo
	 */
	public String getInhisYmdhmsTo() {
		return inhisYmdhmsTo;
	}

	/**
	 * @param inhisYmdhmsTo セットする inhisYmdhmsTo
	 */
	public void setInhisYmdhmsTo(String inhisYmdhmsTo) {
		this.inhisYmdhmsTo = inhisYmdhmsTo;
	}

	/**
	 * CatTuuchiComboDataList.javahisYmdhmsFromを設定
	 * @return hisYmdhmsFrom
	 */
	public String getHisYmdhmsFrom() {
		return hisYmdhmsFrom;
	}

	/**
	 * @param hisYmdhmsFrom セットする hisYmdhmsFrom
	 */
	public void setHisYmdhmsFrom(String hisYmdhmsFrom) {
		this.hisYmdhmsFrom = hisYmdhmsFrom;
	}

	/**
	 * CatTuuchiComboDataList.javahisYmdhmsToを設定
	 * @return hisYmdhmsTo
	 */
	public String getHisYmdhmsTo() {
		return hisYmdhmsTo;
	}

	/**
	 * @param hisYmdhmsTo セットする hisYmdhmsTo
	 */
	public void setHisYmdhmsTo(String hisYmdhmsTo) {
		this.hisYmdhmsTo = hisYmdhmsTo;
	}

}

