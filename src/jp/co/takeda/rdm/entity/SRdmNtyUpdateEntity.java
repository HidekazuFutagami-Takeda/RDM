/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.LinkedHashMap;

/**
 * Entityクラス
 * テーブル物理名 : S_JKR_T_PSS_CHOHYO_KIHON
 * テーブル論理名 : 帳票基本情報
 * @generated
 */
public class SRdmNtyUpdateEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * test
     * @generated
     */

    private String test;

    /**
     * ソートID(パラメータ)
     */
    private String inSortId;

	private String ntyId;

	private String reqId;

	private String ntyBri;

	private String ntySts;

	private String ntyPri;

	private String ssUpdYmdhms;

	private String ntySubject;

	private String ntyData;

	private String ntyData2;

	private String ntyData3;

	private String ntyData4;

	private String ntyData5;

	private String ntyMemo;

	private String youFlg;

	private String inhisYmdhmsFrom;

	private String inhisYmdhmsTo;

	private String hisYmdhmsFrom;

	private String hisYmdhmsTo;

	private boolean dataDupCheck;

	private boolean ultRnkCheck;

	private boolean fbResCheck;

	private boolean consCheck;

	private boolean othersCheck;

	private boolean onlyCheck;

	private boolean unconCheck;

	private boolean ubderCheck;

	private boolean resolvCheck;

	/**
	 * knYmdhmsFrom
	 * @generated
	 */

	private String knYmdhmsFrom;


	/**
	 * knYmdhmsTo
	 * @generated
	 */

	private String knYmdhmsTo;



    public String getInSortId() {
		return inSortId;
	}
	public void setInSortId(String inSortId) {
		this.inSortId = inSortId;
	}
	/**
     * コンストラクタ
     *
     */

    public SRdmNtyUpdateEntity() {
        super("t-rdm-nty-knr","selectNtyKnrId");
    }

    /**
     * 親画面から受け取るMR/管理者のflag
     */
    private String mrAdminCd;

	/**
	 * 親画面から受け取るMR/管理者のflagを取得します。
	 * @return 親画面から受け取るMR/管理者のflag
	 */
	public String getMrAdminCd() {
		return mrAdminCd;
	}
	/**
	 * 親画面から受け取るMR/管理者のflagを設定します。
	 * @param mrAdminCd 親画面から受け取るMR/管理者のflag
	 */
	public void setMrAdminCd(String mrAdminCd) {
		this.mrAdminCd = mrAdminCd;
	}

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
     * 従業員番号
     */
    private String jgiNo;
    /**
     * 従業員名
     */
    private String jgiName;

    public String getJgiNo() {
		return jgiNo;
	}
	public void setJgiNo(String jgiNo) {
		this.jgiNo = jgiNo;
	}
	public String getJgiName() {
		return jgiName;
	}
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	private String mrAdminFlg;

	/**
	 * mrAdminFlgを取得します。
	 * @return mrAdminFlg
	 */
	public String getMrAdminFlg() {
		return mrAdminFlg;
	}
	/**
	 * mrAdminFlgを設定します。
	 * @param mrAdminFlg mrAdminFlg
	 */
	public void setMrAdminFlg(String mrAdminFlg) {
		this.mrAdminFlg = mrAdminFlg;
	}


    /**
	 * SRdmNtyListEntity.javantyIdを設定
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
	 * SRdmNtyUpdateEntity.javareqIdを設定
	 * @return reqId
	 */
	public String getReqId() {
		return reqId;
	}
	/**
	 * @param reqId セットする reqId
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	/**
	 * SRdmNtyListEntity.javantyBriを設定
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
	 * SRdmNtyListEntity.javantyStsを設定
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
	 * SRdmNtyListEntity.javantyPriを設定
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
	 * SRdmNtyListEntity.javassUpdYmdhmsを設定
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
	 * SRdmNtyListEntity.javantySubjectを設定
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
	 * SRdmNtyListEntity.javantyDataを設定
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
	 * SRdmNtyUpdateEntity.javantyData2を設定
	 * @return ntyData2
	 */
	public String getNtyData2() {
		return ntyData2;
	}
	/**
	 * @param ntyData2 セットする ntyData2
	 */
	public void setNtyData2(String ntyData2) {
		this.ntyData2 = ntyData2;
	}
	/**
	 * SRdmNtyUpdateEntity.javantyData3を設定
	 * @return ntyData3
	 */
	public String getNtyData3() {
		return ntyData3;
	}
	/**
	 * @param ntyData3 セットする ntyData3
	 */
	public void setNtyData3(String ntyData3) {
		this.ntyData3 = ntyData3;
	}
	/**
	 * SRdmNtyUpdateEntity.javantyData4を設定
	 * @return ntyData4
	 */
	public String getNtyData4() {
		return ntyData4;
	}
	/**
	 * @param ntyData4 セットする ntyData4
	 */
	public void setNtyData4(String ntyData4) {
		this.ntyData4 = ntyData4;
	}
	/**
	 * SRdmNtyUpdateEntity.javantyData5を設定
	 * @return ntyData5
	 */
	public String getNtyData5() {
		return ntyData5;
	}
	/**
	 * @param ntyData5 セットする ntyData5
	 */
	public void setNtyData5(String ntyData5) {
		this.ntyData5 = ntyData5;
	}
	/**
	 * SRdmNtyListEntity.javantyMemoを設定
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
	 * SRdmNtyListEntity.javayouFlgを設定
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
	 * SRdmNtyListEntity.javainhisYmdhmsFromを設定
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
	 * SRdmNtyListEntity.javainhisYmdhmsToを設定
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
	 * SRdmNtyListEntity.javahisYmdhmsFromを設定
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
	 * SRdmNtyListEntity.javahisYmdhmsToを設定
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
	/**
	 * SRdmNtyListEntity.javaknYmdhmsFromを設定
	 * @return knYmdhmsFrom
	 */
	public String getKnYmdhmsFrom() {
		return knYmdhmsFrom;
	}
	/**
	 * @param knYmdhmsFrom セットする knYmdhmsFrom
	 */
	public void setKnYmdhmsFrom(String knYmdhmsFrom) {
		this.knYmdhmsFrom = knYmdhmsFrom;
	}
	/**
	 * SRdmNtyListEntity.javaknYmdhmsToを設定
	 * @return knYmdhmsTo
	 */
	public String getKnYmdhmsTo() {
		return knYmdhmsTo;
	}
	/**
	 * @param knYmdhmsTo セットする knYmdhmsTo
	 */
	public void setKnYmdhmsTo(String knYmdhmsTo) {
		this.knYmdhmsTo = knYmdhmsTo;
	}

	/**
	 * SRdmNtyListEntity.javadataDupCheckを設定
	 * @return dataDupCheck
	 */
	public boolean isDataDupCheck() {
		return dataDupCheck;
	}
	/**
	 * @param dataDupCheck セットする dataDupCheck
	 */
	public void setDataDupCheck(boolean dataDupCheck) {
		this.dataDupCheck = dataDupCheck;
	}
	/**
	 * SRdmNtyListEntity.javaultRnkCheckを設定
	 * @return ultRnkCheck
	 */
	public boolean isUltRnkCheck() {
		return ultRnkCheck;
	}
	/**
	 * @param ultRnkCheck セットする ultRnkCheck
	 */
	public void setUltRnkCheck(boolean ultRnkCheck) {
		this.ultRnkCheck = ultRnkCheck;
	}
	/**
	 * SRdmNtyListEntity.javafbResCheckを設定
	 * @return fbResCheck
	 */
	public boolean isFbResCheck() {
		return fbResCheck;
	}
	/**
	 * @param fbResCheck セットする fbResCheck
	 */
	public void setFbResCheck(boolean fbResCheck) {
		this.fbResCheck = fbResCheck;
	}
	/**
	 * SRdmNtyListEntity.javaconsCheckを設定
	 * @return consCheck
	 */
	public boolean isConsCheck() {
		return consCheck;
	}
	/**
	 * @param consCheck セットする consCheck
	 */
	public void setConsCheck(boolean consCheck) {
		this.consCheck = consCheck;
	}
	/**
	 * SRdmNtyListEntity.javaothersCheckを設定
	 * @return othersCheck
	 */
	public boolean isOthersCheck() {
		return othersCheck;
	}
	/**
	 * @param othersCheck セットする othersCheck
	 */
	public void setOthersCheck(boolean othersCheck) {
		this.othersCheck = othersCheck;
	}
	/**
	 * SRdmNtyListEntity.javaonlyCheckを設定
	 * @return onlyCheck
	 */
	public boolean isOnlyCheck() {
		return onlyCheck;
	}
	/**
	 * @param onlyCheck セットする onlyCheck
	 */
	public void setOnlyCheck(boolean onlyCheck) {
		this.onlyCheck = onlyCheck;
	}
	/**
	 * SRdmNtyListEntity.javaunconCheckを設定
	 * @return unconCheck
	 */
	public boolean isUnconCheck() {
		return unconCheck;
	}
	/**
	 * @param unconCheck セットする unconCheck
	 */
	public void setUnconCheck(boolean unconCheck) {
		this.unconCheck = unconCheck;
	}
	/**
	 * SRdmNtyListEntity.javaubderCheckを設定
	 * @return ubderCheck
	 */
	public boolean isUbderCheck() {
		return ubderCheck;
	}
	/**
	 * @param ubderCheck セットする ubderCheck
	 */
	public void setUbderCheck(boolean ubderCheck) {
		this.ubderCheck = ubderCheck;
	}
	/**
	 * SRdmNtyListEntity.javaresolvCheckを設定
	 * @return resolvCheck
	 */
	public boolean isResolvCheck() {
		return resolvCheck;
	}
	/**
	 * @param resolvCheck セットする resolvCheck
	 */
	public void setResolvCheck(boolean resolvCheck) {
		this.resolvCheck = resolvCheck;
	}

	/**
     * @generated
     */
    private LinkedHashMap jkrSosAddrMap;
    /**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosAddrMap() {
	    return jkrSosAddrMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosAddrMap @generated
	 */
	public void setJkrSosAddrMap(LinkedHashMap jkrSosAddrMap) {
	    this.jkrSosAddrMap = jkrSosAddrMap;
	}

	/**
     * Offset値
     * @generated
     */
    private Integer inOffset;

    /**
     * Limit値
     * @generated
     */
    private Integer inLimit;

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
	 * testを取得します。
	 * @return test
	 */
	public String getTest() {
	    return this.test;
	}
	/**
	 * testを設定します。
	 * @param test test
	 */
	public void setTest(String test) {
	    this.test = test;
	}
	/**
	 * Offset値を取得します。
	 * @return Offset値
	 */
	public Integer getInOffset
	() {
	    return this.inOffset;
	}
	/**
	 * Offset値を設定します。
	 * @param inOffset Offset値
	 */
	public void setInOffset(Integer inOffset) {
	    this.inOffset = inOffset;
	}
	/**
	 * Limit値を取得します。
	 * @return Limit値
	 */
	public Integer getInLimit
	() {
	    return this.inLimit;
	}
	/**
	 * Limit値を設定します。
	 * @param inLimit Limit値
	 */
	public void setInLimit(Integer inLimit) {
	    this.inLimit = inLimit;
	}

	/**
	 * reqJgiNameを取得します。
	 * @return reqJgiName
	 */
	public String getReqJgiName() {
	    return reqJgiName;
	}
	/**
	 * reqJgiNameを設定します。
	 * @param reqJgiName reqJgiName
	 */
	public void setReqJgiName(String reqJgiName) {
	   this.reqJgiName = reqJgiName;
	}
	/**
	 * reqJgiNoを取得します。
	 * @return reqJgiName
	 */
    public String getReqJgiNo() {
		return reqJgiNo;
	}
	public void setReqJgiNo(String reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}
	/**
     *部門ランク
     */
	private String bumonRank;

    public String getBumonRank() {
		return bumonRank;
	}
	public void setBumonRank(String bumonRank) {
		this.bumonRank = bumonRank;
	}

    /**
     *組織コード
     */
	private String sosCd;

	public String getSosCd() {
		return sosCd;
	}
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

    /**
     *組織名称
     */
	private String bumonRyakuName;

	public String getBumonRyakuName() {
		return bumonRyakuName;
	}
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
	}
	private String reqType;
	/**
	 * SRdmNtyUpdateEntity.javareqTypeを設定
	 * @return reqType
	 */
	public String getReqType() {
		return reqType;
	}
	/**
	 * @param reqType セットする reqType
	 */
	public void setReqType(String reqType) {
		this.reqType = reqType;
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
