/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseDTO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * DTOクラス
 * @generated
 */
public class NM011DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NM011 = "NM011";

    private String boolKnb;
	/**
     * 親画面コールバックメソッド名
     * @generated
     */
    private String callBack;

    /**
     * 遷移元画面ID
     */
	private String preScreenId;

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
     * 検索-JIS都道府県
     * @generated
     */
    private String aDdrCodePref;
	/**
     * 検索-種別
     * @generated
     */
    private String sbt;
    /**
     * 検索-連携種別
     * @generated
     */
    private String reqSbt;
    /**
     * 検索-種別
     * @generated
     */
    private String reqType;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosNtySubject;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosNtyPri;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosAddrMap;

	/**
     * @generated
     */
    private LinkedHashMap jkrSosReqSbtMap;

	/**
     * @generated
     */
    private LinkedHashMap jkrSosSbtMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosReqTypeMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosReqStsMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosInsClassMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosInsSbtMap;

	/**
     * @generated
     */
    private LinkedHashMap jkrSosDocTypeMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosJobFormMap;

	/**
     * @generated
     */
    private LinkedHashMap jkrSosReqChlMap;


	/**
     * @generated
     */
    private LinkedHashMap jkrSosHoInsTypeMap;
    /**
     * 担当先コンボ
     * @generated
     */
    private LinkedHashMap searchInsChgCombo;

    /**
     * FB申請要否
     */
    private LinkedHashMap JkrSosFbReqFlgMap;

    /**
     * FB処理区分
     */
    private LinkedHashMap JkrSosFbPrcTypeMap;

	/**
	 * ソート部の宣言 + get,set
	 */
	private String sortCondition;
    private String ntyIdAscClass;
    private String ntyIdDescClass;
    private String hisYmdhmsAscClass;
    private String hisYmdhmsDescClass;
    private String reqIdAscClass;
    private String reqIdDescClass;
    private String reqYmdhmsAscClass;
    private String reqYmdhmsDescClass;
    private String reqSbtAscClass;
    private String reqSbtDescClass;
    private String reqTypeAscClass;
    private String reqTypeDescClass;
	private String reqStsAscClass;
    private String reqStsDescClass;
    private String sbtAscClass;
    private String sbtDescClass;
    private String reqJgiNameAscClass;
    private String reqJgiNameDescClass;

	/**
     * 親画面名
     * @generated
     */
    private String winVarName;

    private String title;

	/**
     * 呼び出し元のClear処理メソッド名
     * @generated
     */
    private String parentClearProc;

    /**
     * 親画面から受け取るMR/管理者のflag
     */
    private String mrAdminCd;

	/**
     * 従業員番号
     */
    private String jgiNo;
    /**
     * 従業員名
     */
    private String jgiName;




	/**
     * @generated
     */
    private List<CatTuuchiComboDataList> catTuuchiComboDataList = new ArrayList<CatTuuchiComboDataList>();
    /**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;


    /**
	 * メッセージ中身
	 * @generated
	 */
	private String msgData;


	/**
	 * @generated
	 */
	private String test;


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
	 * knYmdhmsFrom
	 * @generated
	 */

	private String knYmdhmsFrom;


	/**
	 * knYmdhmsTo
	 * @generated
	 */

	private String knYmdhmsTo;

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
	 * reqJgiName --申請者氏名
	 * @generated
	 */

	private String reqJgiName;

	    /**
	 * reqJgiNo
	 * @generated
	 */

	private String reqJgiNo;


	private boolean isKensakuBool;

	private String pageFlag;

	public String getBoolKnb() {
		return boolKnb;
	}
	public void setBoolKnb(String boolKnb) {
		this.boolKnb = boolKnb;
	}

	/**
	 * NM011DTO.javatitleを設定
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPreScreenId() {
		return preScreenId;
	}

	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

    /**
	 * NM011DTO.javantyIdを設定
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
	 * NM011DTO.javantyBriを設定
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
	 * NM011DTO.javantyStsを設定
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
	 * NM011DTO.javantyPriを設定
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
	 * NM011DTO.javassUpdYmdhmsを設定
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
	 * NM011DTO.javantySubjectを設定
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
	 * NM011DTO.javantyDataを設定
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
	 * NM011DTO.javantyMemoを設定
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
	 * NM011DTO.javayouFlgを設定
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
	 * NM011DTO.javainhisYmdhmsFromを設定
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
	 * NM011DTO.javainhisYmdhmsToを設定
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
	 * NM011DTO.javahisYmdhmsFromを設定
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
	 * NM011DTO.javahisYmdhmsToを設定
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

	public LinkedHashMap getJkrSosFbReqFlgMap() {
		return JkrSosFbReqFlgMap;
	}
	public void setJkrSosFbReqFlgMap(LinkedHashMap jkrSosFbReqFlgMap) {
		JkrSosFbReqFlgMap = jkrSosFbReqFlgMap;
	}
	public LinkedHashMap getJkrSosFbPrcTypeMap() {
		return JkrSosFbPrcTypeMap;
	}
	public void setJkrSosFbPrcTypeMap(LinkedHashMap jkrSosFbPrcTypeMap) {
		JkrSosFbPrcTypeMap = jkrSosFbPrcTypeMap;
	}

	/**
	 * 担当先コンボを取得します。
	 * @return 担当先コンボ
	 */
	public LinkedHashMap getSearchInsChgCombo() {
	    return searchInsChgCombo;
	}

    public String getSortCondition() {
		return sortCondition;
	}
	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}

	/**
	 * NM011DTO.javantyIdAscClassを設定
	 * @return ntyIdAscClass
	 */
	public String getNtyIdAscClass() {
		return ntyIdAscClass;
	}
	/**
	 * @param ntyIdAscClass セットする ntyIdAscClass
	 */
	public void setNtyIdAscClass(String ntyIdAscClass) {
		this.ntyIdAscClass = ntyIdAscClass;
	}
	/**
	 * NM011DTO.javantyIdDescClassを設定
	 * @return ntyIdDescClass
	 */
	public String getNtyIdDescClass() {
		return ntyIdDescClass;
	}
	/**
	 * @param ntyIdDescClass セットする ntyIdDescClass
	 */
	public void setNtyIdDescClass(String ntyIdDescClass) {
		this.ntyIdDescClass = ntyIdDescClass;
	}
	/**
	 * NM011DTO.javahisYmdhmsAscClassを設定
	 * @return hisYmdhmsAscClass
	 */
	public String getHisYmdhmsAscClass() {
		return hisYmdhmsAscClass;
	}
	/**
	 * @param hisYmdhmsAscClass セットする hisYmdhmsAscClass
	 */
	public void setHisYmdhmsAscClass(String hisYmdhmsAscClass) {
		this.hisYmdhmsAscClass = hisYmdhmsAscClass;
	}
	/**
	 * NM011DTO.javahisYmdhmsDescClassを設定
	 * @return hisYmdhmsDescClass
	 */
	public String getHisYmdhmsDescClass() {
		return hisYmdhmsDescClass;
	}
	/**
	 * @param hisYmdhmsDescClass セットする hisYmdhmsDescClass
	 */
	public void setHisYmdhmsDescClass(String hisYmdhmsDescClass) {
		this.hisYmdhmsDescClass = hisYmdhmsDescClass;
	}
	public String getReqIdAscClass() {
		return reqIdAscClass;
	}
	public void setReqIdAscClass(String reqIdAscClass) {
		this.reqIdAscClass = reqIdAscClass;
	}
	public String getReqIdDescClass() {
		return reqIdDescClass;
	}
	public void setReqIdDescClass(String reqIdDescClass) {
		this.reqIdDescClass = reqIdDescClass;
	}
	public String getReqYmdhmsAscClass() {
		return reqYmdhmsAscClass;
	}
	public void setReqYmdhmsAscClass(String reqYmdhmsAscClass) {
		this.reqYmdhmsAscClass = reqYmdhmsAscClass;
	}
	public String getReqYmdhmsDescClass() {
		return reqYmdhmsDescClass;
	}
	public void setReqYmdhmsDescClass(String reqYmdhmsDescClass) {
		this.reqYmdhmsDescClass = reqYmdhmsDescClass;
	}
	public String getReqSbtAscClass() {
		return reqSbtAscClass;
	}
	public void setReqSbtAscClass(String reqSbtAscClass) {
		this.reqSbtAscClass = reqSbtAscClass;
	}
	public String getReqSbtDescClass() {
		return reqSbtDescClass;
	}
	public void setReqSbtDescClass(String reqSbtDescClass) {
		this.reqSbtDescClass = reqSbtDescClass;
	}
	public String getReqTypeAscClass() {
		return reqTypeAscClass;
	}
	public void setReqTypeAscClass(String reqTypeAscClass) {
		this.reqTypeAscClass = reqTypeAscClass;
	}
	public String getReqTypeDescClass() {
		return reqTypeDescClass;
	}
	public void setReqTypeDescClass(String reqTypeDescClass) {
		this.reqTypeDescClass = reqTypeDescClass;
	}
	public String getReqStsAscClass() {
		return reqStsAscClass;
	}
	public void setReqStsAscClass(String reqStsAscClass) {
		this.reqStsAscClass = reqStsAscClass;
	}
	public String getReqStsDescClass() {
		return reqStsDescClass;
	}
	public void setReqStsDescClass(String reqStsDescClass) {
		this.reqStsDescClass = reqStsDescClass;
	}
	public String getSbtAscClass() {
		return sbtAscClass;
	}
	public void setSbtAscClass(String sbtAscClass) {
		this.sbtAscClass = sbtAscClass;
	}
	public String getSbtDescClass() {
		return sbtDescClass;
	}
	public void setSbtDescClass(String sbtDescClass) {
		this.sbtDescClass = sbtDescClass;
	}
	public String getReqJgiNameAscClass() {
		return reqJgiNameAscClass;
	}
	public void setReqJgiNameAscClass(String reqJgiNameAscClass) {
		this.reqJgiNameAscClass = reqJgiNameAscClass;
	}
	public String getReqJgiNameDescClass() {
		return reqJgiNameDescClass;
	}
	public void setReqJgiNameDescClass(String reqJgiNameDescClass) {
		this.reqJgiNameDescClass = reqJgiNameDescClass;
	}

    /**
	 * 担当先コンボを設定します。
	 * @param searchInsChgCombo 担当先コンボ
	 */
	public void setSearchInsChgCombo(LinkedHashMap searchInsChgCombo) {
	    this.searchInsChgCombo = searchInsChgCombo;
	}


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
	 * 管理者/MR判定
	 */
    private String mrAdminFlg;

    /**
	 * 管理者/MR判定を取得します。
	 * @return 管理者/MR判定
	 */
	public String getMrAdminFlg() {
		return mrAdminFlg;
	}
	/**
	 * 管理者/MR判定を設定します。
	 * @param mrAdminFlg 管理者/MR判定
	 */
	public void setMrAdminFlg(String mrAdminFlg) {
		this.mrAdminFlg = mrAdminFlg;
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
	 * メッセージ中身を取得します。
	 * @return メッセージ中身
	 */
	public String getMsgStr() {
		return msgStr;
	}
	/**
	 * メッセージ中身を設定します。
	 * @param msgStr メッセージ中身
	 */
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	/**
	 * メッセージ中身を取得します。
	 * @param w009
	 * @param
	 * @return メッセージ中身
	 */
	public String getMsgData(String w009) {
		return msgData;
	}
	/**
	 * メッセージ中身を設定します。
	 * @param msgStr メッセージ中身
	 */
	public void setMsgData(String msgData) {
		this.msgData = msgData;
	}



    public String getKnYmdhmsFrom() {
		return knYmdhmsFrom;
	}
	public void setKnYmdhmsFrom(String knYmdhmsFrom) {
		this.knYmdhmsFrom = knYmdhmsFrom;
	}
	public String getKnYmdhmsTo() {
		return knYmdhmsTo;
	}
	public void setKnYmdhmsTo(String knYmdhmsTo) {
		this.knYmdhmsTo = knYmdhmsTo;
	}

	/**
	 * NM011DTO.javaaDdrCodePrefを設定
	 * @return aDdrCodePref
	 */
	public String getaDdrCodePref() {
		return aDdrCodePref;
	}
	/**
	 * @param aDdrCodePref セットする aDdrCodePref
	 */
	public void setaDdrCodePref(String aDdrCodePref) {
		this.aDdrCodePref = aDdrCodePref;
	}
	/**
	 * NM011DTO.javadataDupCheckを設定
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
	 * NM011DTO.javaultRnkCheckを設定
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
	 * NM011DTO.javafbResCheckを設定
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
	 * NM011DTO.javaconsCheckを設定
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
	 * NM011DTO.javaothersCheckを設定
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
	 * NM011DTO.javaonlyCheckを設定
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
	 * NM011DTO.javaunconCheckを設定
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
	 * NM011DTO.javaubderCheckを設定
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
	 * NM011DTO.javaresolvCheckを設定
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
	 * NM011DTO.javamsgDataを設定
	 * @return msgData
	 */
	public String getMsgData() {
		return msgData;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public String getTest() {
		return test;
	}
	/**
	 * @generatedを設定します。
	 * @param test @generated
	 */
	public void setTest(String test) {
		this.test = test;
	}


	/**
	 * 検索-種別を取得します。
	 * @return 検索-種別
	 */
	public String getReqType() {
	    return reqType;
	}
	/**
	 * 検索-種別を設定します。
	 * @param reqType 検索-種別
	 */
	public void setReqType(String reqType) {
	   this.reqType = reqType;
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
	 * @return reqJgiNo
	 */
	public String getReqJgiNo() {
		return reqJgiNo;
	}
	/**
	 * reqJgiNoを設定します。
	 * @param reqJgiNo reqJgiNo
	 */
	public void setReqJgiNo(String reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NM011DTO() {
        setForward(NM011);
    }

    // START UOC

    // END UOC

    /**
     * JIS府県-検索をセットする
     * @param JIS府県-検索
     * @generated
     */
    public void setADdrCodePref(String aDdrCodePref){
        this.aDdrCodePref = aDdrCodePref;
    }

    /**
     * JIS府県-検索を返す
     * @return JIS府県-検索
     * @generated
     */
    public String getADdrCodePref(){
        return aDdrCodePref;
    }
    /**
	 * 検索-種別を設定します。
	 * @param sbt 検索-種別
	 */
	public void setSbt(String sbt){
	    this.sbt = sbt;
	}
	/**
	 * 検索-種別を取得します。
	 * @return 検索-種別
	 */
	public String getSbt(){
	    return sbt;
	}
	/**
	 * 検索-連携種別を設定します。
	 * @param reqSbt 検索-連携種別
	 */
	public void setReqSbt(String reqSbt){
	    this.reqSbt = reqSbt;
	}
	/**
	 * 検索-連携種別を取得します。
	 * @return 検索-連携種別
	 */
	public String getReqSbt(){
	    return reqSbt;
	}
	/**
	 * このDTOが関連付けられている画面IDを設定します。
	 * @param screenID このDTOが関連付けられている画面ID
	 */
	public void setNM011(String screenID){
	    this.NM011 = screenID;
	}
	/**
	 * このDTOが関連付けられている画面IDを取得します。
	 * @return このDTOが関連付けられている画面ID
	 */
	public String getNM011(){
	    return NM011;
	}
	/**
	 * 親画面コールバックメソッド名を取得します。
	 * @return 親画面コールバックメソッド名
	 */
	public String getCallBack() {
	    return callBack;
	}
	/**
	 * 親画面コールバックメソッド名を設定します。
	 * @param callBack 親画面コールバックメソッド名
	 */
	public void setCallBack(String callBack) {
	    this.callBack = callBack;
	}
	/**
	 * 親画面名を取得します。
	 * @return 親画面名
	 */
	public String getWinVarName() {
	    return winVarName;
	}
	/**
	 * 親画面名を設定します。
	 * @param winVarName 親画面名
	 */
	public void setWinVarName(String winVarName) {
	    this.winVarName = winVarName;
	}
	/**
	 * 呼び出し元のClear処理メソッド名を取得します。
	 * @return 呼び出し元のClear処理メソッド名
	 */
	public String getParentClearProc() {
	    return parentClearProc;
	}
	/**
	 * 呼び出し元のClear処理メソッド名を設定します。
	 * @param parentClearProc 呼び出し元のClear処理メソッド名
	 */
	public void setParentClearProc(String parentClearProc) {
	    this.parentClearProc = parentClearProc;
	}
	/**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



    /**
	 * NM011DTO.javajkrSosNtySubjectを設定
	 * @return jkrSosNtySubject
	 */
	public LinkedHashMap getJkrSosNtySubject() {
		return jkrSosNtySubject;
	}
	/**
	 * @param jkrSosNtySubject セットする jkrSosNtySubject
	 */
	public void setJkrSosNtySubject(LinkedHashMap jkrSosNtySubject) {
		this.jkrSosNtySubject = jkrSosNtySubject;
	}
	/**
	 * NM011DTO.javajkrSosNtyPriを設定
	 * @return jkrSosNtyPri
	 */
	public LinkedHashMap getJkrSosNtyPri() {
		return jkrSosNtyPri;
	}
	/**
	 * @param jkrSosNtyPri セットする jkrSosNtyPri
	 */
	public void setJkrSosNtyPri(LinkedHashMap jkrSosNtyPri) {
		this.jkrSosNtyPri = jkrSosNtyPri;
	}
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
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosReqSbtMap() {
	    return jkrSosReqSbtMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosReqSbtMap @generated
	 */
	public void setJkrSosReqSbtMap(LinkedHashMap jkrSosReqSbtMap) {
	    this.jkrSosReqSbtMap = jkrSosReqSbtMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosSbtMap() {
	    return jkrSosSbtMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosSbtMap @generated
	 */
	public void setJkrSosSbtMap(LinkedHashMap jkrSosSbtMap) {
	    this.jkrSosSbtMap = jkrSosSbtMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosReqTypeMap() {
	    return jkrSosReqTypeMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosReqTypeMap @generated
	 */
	public void setJkrSosReqTypeMap(LinkedHashMap jkrSosReqTypeMap) {
	    this.jkrSosReqTypeMap = jkrSosReqTypeMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosReqStsMap() {
	    return jkrSosReqStsMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosReqStsMap @generated
	 */
	public void setJkrSosReqStsMap(LinkedHashMap jkrSosReqStsMap) {
	    this.jkrSosReqStsMap = jkrSosReqStsMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosInsClassMap() {
	    return jkrSosInsClassMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosInsClassMap @generated
	 */
	public void setJkrSosInsClassMap(LinkedHashMap jkrSosInsClassMap) {
	    this.jkrSosInsClassMap = jkrSosInsClassMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosInsSbtMap() {
	    return jkrSosInsSbtMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosInsSbtMap @generated
	 */
	public void setJkrSosInsSbtMap(LinkedHashMap jkrSosInsSbtMap) {
	    this.jkrSosInsSbtMap = jkrSosInsSbtMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosDocTypeMap() {
		return jkrSosDocTypeMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosDocTypeMap @generated
	 */
	public void setJkrSosDocTypeMap(LinkedHashMap jkrSosDocTypeMap) {
		this.jkrSosDocTypeMap = jkrSosDocTypeMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosJobFormMap() {
		return jkrSosJobFormMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosJobFormMap @generated
	 */
	public void setJkrSosJobFormMap(LinkedHashMap jkrSosJobFormMap) {
		this.jkrSosJobFormMap = jkrSosJobFormMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosReqChlMap() {
		return jkrSosReqChlMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosReqChlMap @generated
	 */
	public void setJkrSosReqChlMap(LinkedHashMap jkrSosReqChlMap) {
		this.jkrSosReqChlMap = jkrSosReqChlMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosHoInsTypeMap() {
	    return jkrSosHoInsTypeMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosHoInsTypeMap @generated
	 */
	public void setJkrSosHoInsTypeMap(LinkedHashMap jkrSosHoInsTypeMap) {
	    this.jkrSosHoInsTypeMap = jkrSosHoInsTypeMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public List<CatTuuchiComboDataList> getCatTuuchiComboDataList() {
	return catTuuchiComboDataList;
	//catTuuchiComboDataList
	}
	/**
	 * @generatedを設定します。
	 * @param catTuuchiComboDataList @generated
	 */
	public void setCatTuuchiComboDataList(List<CatTuuchiComboDataList> catTuuchiComboDataList) {
	this.catTuuchiComboDataList = catTuuchiComboDataList;
	}

	/*
	 * */


	public boolean isKensakuBool() {
		return isKensakuBool;
	}
	public void setKensakuBool(boolean isKensakuBool) {
		this.isKensakuBool = isKensakuBool;
	}



	public String getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}

}
