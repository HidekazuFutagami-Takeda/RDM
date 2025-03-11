/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_HCP_MST
 * SQLID : selectCntHcp
 */
public class SelectCntSelectNtyListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師検索表示件数
     */
    private Integer CntHcp;
    /**
     * 申請一覧検索表示件数
     */
    private Integer CntReq;


    /**
     * コンストラクタ
     */
    public SelectCntSelectNtyListEntity() {
        super("t-rdm-nty-knr" , "countNtyKnr");
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
     * 従業員番号
     */
    private String jgiNo;
    /**
     * 従業員名
     */
    private String jgiName;

	private String ntyId;

	private String ntyBri;

	private String ntySts;

	private String ntyPri;

	private String ssUpdYmdhms;

	private String ntySubject;

	private String ntyData;

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
	 * SelectCntSelectNtyListEntity.javantyIdを設定
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
	 * SelectCntSelectNtyListEntity.javantyBriを設定
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
	 * SelectCntSelectNtyListEntity.javantyStsを設定
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
	 * SelectCntSelectNtyListEntity.javantyPriを設定
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
	 * SelectCntSelectNtyListEntity.javassUpdYmdhmsを設定
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
	 * SelectCntSelectNtyListEntity.javantySubjectを設定
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
	 * SelectCntSelectNtyListEntity.javantyDataを設定
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
	 * SelectCntSelectNtyListEntity.javantyMemoを設定
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
	 * SelectCntSelectNtyListEntity.javayouFlgを設定
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
	 * SelectCntSelectNtyListEntity.javainhisYmdhmsFromを設定
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
	 * SelectCntSelectNtyListEntity.javainhisYmdhmsToを設定
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
	 * SelectCntSelectNtyListEntity.javahisYmdhmsFromを設定
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
	 * SelectCntSelectNtyListEntity.javahisYmdhmsToを設定
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
	 * SelectCntSelectNtyListEntity.javaknYmdhmsFromを設定
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
	 * SelectCntSelectNtyListEntity.javaknYmdhmsToを設定
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
	 * SelectCntSelectNtyListEntity.javadataDupCheckを設定
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
	 * SelectCntSelectNtyListEntity.javaultRnkCheckを設定
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
	 * SelectCntSelectNtyListEntity.javafbResCheckを設定
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
	 * SelectCntSelectNtyListEntity.javaconsCheckを設定
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
	 * SelectCntSelectNtyListEntity.javaothersCheckを設定
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
	 * SelectCntSelectNtyListEntity.javaonlyCheckを設定
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
	 * SelectCntSelectNtyListEntity.javaunconCheckを設定
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
	 * SelectCntSelectNtyListEntity.javaubderCheckを設定
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
	 * SelectCntSelectNtyListEntity.javaresolvCheckを設定
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


	public Integer getCntHcp() {
			return CntHcp;
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */


	public void setCntHcp(Integer cntHcp) {
		CntHcp = cntHcp;
	}
	/**
	 * SelectParamSelectHcpEntity.javaCntHcpを設定
	 * @return cntHcp
	 */
	public Integer getCntReq() {
		return CntReq;
	}

	/**
	 * @param cntHcp セットする cntHcp
	 */
	public void setCntReq(Integer cntReq) {
		CntHcp = cntReq;
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
