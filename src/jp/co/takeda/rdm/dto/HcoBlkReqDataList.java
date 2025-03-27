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
public class HcoBlkReqDataList implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 申請ステータス
     * @generated
     */
    private String reqSts;

    /**
     * 申請チェック
     * @generated
     */
    private String reqChk;

    /**
     * 施設固定C
     * @generated
     */
    private String insNo;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 施設区分
     * @generated
     */
    private String pharmType;

    /**
     * 階級区分
     * @generated
     */
    private String insRank;

    /**
     * 定訪先区分
     * @generated
     */
    private String regVisType;

    /**
     * 重点病院区分
     * @generated
     */
    private String impHosType;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * 経営主体
     * @generated
     */
    private String manageNm;

    /**
     * ワクチン対象区分
     * @generated
     */
    private String vacInsType;

    /**
     * ワクチン定訪先区分
     * @generated
     */
    private String vacVisitType;

    /**
     * 基準
     * @generated
     */
    private String bedCntBase;

    /**
     * 結核
     * @generated
     */
    private String bedCnt04;

    /**
     * 一般
     * @generated
     */
    private String bedCnt01;

    /**
     * 感染症
     * @generated
     */
    private String bedCnt05;

    /**
     * 精神
     * @generated
     */
    private String bedCnt03;

    /**
     * 療養
     * @generated
     */
    private String bedCnt07;

    /**
     * 医療療養
     * @generated
     */
    private String bedCnt02;

    /**
     * 介護療養
     * @generated
     */
    private String bedCnt06;

    /**
     * ベッド数計
     * @generated
     */
    private String bedsTot;

    /**
     * 医療ベッド数計
     * @generated
     */
    private String medBedsTot;

    /**
     * 施設区分
     * @generated
     */
    private String shisetsuKbn;

    /**
     * 経営主体
     * @generated
     */
    private String keieitai;

    /**
     * 基準
     * @generated
     */
    private String ultBedCntBase;

    /**
     * 結核
     * @generated
     */
    private String ultBedCnt04;

    /**
     * 一般
     * @generated
     */
    private String ultBedCnt01;

    /**
     * 感染症
     * @generated
     */
    private String ultBedCnt05;

    /**
     * 精神
     * @generated
     */
    private String ultBedCnt03;

    /**
     * 療養
     * @generated
     */
    private String ultBedCnt07;

    /**
     * 医療療養
     * @generated
     */
    private String ultBedCnt02;

    /**
     * 介護療養
     * @generated
     */
    private String ultBedCnt06;

    /**
     * ベッド数計
     * @generated
     */
    private String ultBedsTot;

    /**
     * 医療ベッド数計
     * @generated
     */
    private String ultMedBedsTot;

    /**
     * 施設区分
     * @generated
     */
    private String nextPharmType;

    /**
     * 階級区分
     * @generated
     */
    private String nextInsRank;

    /**
     * 定訪先区分
     * @generated
     */
    private String nextRegVisType;

    /**
     * 重点病院区分
     * @generated
     */
    private String nextImpHosType;

    /**
     * 対象区分
     * @generated
     */
    private String nextHoInsType;

    /**
     * 経営主体
     * @generated
     */
    private String nextManageNm;

    /**
     * ワクチン対象区分
     * @generated
     */
    private String nextVacInsType;

    /**
     * ワクチン定訪先区分
     * @generated
     */
    private String nextVacVisitType;

    /**
     * 基準
     * @generated
     */
    private String nextBedCntBase;

    /**
     * 結核
     * @generated
     */
    private String nextBedCnt04;

    /**
     * 一般
     * @generated
     */
    private String nextBedCnt01;

    /**
     * 感染症
     * @generated
     */
    private String nextBedCnt05;

    /**
     * 精神
     * @generated
     */
    private String nextBedCnt03;

    /**
     * 療養
     * @generated
     */
    private String nextBedCnt07;

    /**
     * 医療療養
     * @generated
     */
    private String nextBedCnt02;

    /**
     * 介護療養
     * @generated
     */
    private String nextBedCnt06;

    /**
     * ベッド数計
     * @generated
     */
    private String nextBedsTot;

    /**
     * 医療ベッド数計
     * @generated
     */
    private String nextMedBedsTot;

    /**
     * ULT差分
     *
     * @generated
     */
    private Integer ultDif;

    /**
     * 申請コメント
     * @generated
     */
    private String reqComment;


    /**
     * コンストラクタ
     * @customizable
     */
    public HcoBlkReqDataList() {
    }


	/**
	 * HcoBlkReqDataList.javareqStsを設定
	 * @return reqSts
	 */
	public String getReqSts() {
		return reqSts;
	}


	/**
	 * @param reqSts セットする reqSts
	 */
	public void setReqSts(String reqSts) {
		this.reqSts = reqSts;
	}


	/**
	 * HcoBlkReqDataList.javareqChkを設定
	 * @return reqChk
	 */
	public String getReqChk() {
		return reqChk;
	}


	/**
	 * @param reqChk セットする reqChk
	 */
	public void setReqChk(String reqChk) {
		this.reqChk = reqChk;
	}


	/**
	 * HcoBlkReqDataList.javainsNoを設定
	 * @return insNo
	 */
	public String getInsNo() {
		return insNo;
	}


	/**
	 * @param insNo セットする insNo
	 */
	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}


	/**
	 * HcoBlkReqDataList.javainsAbbrNameを設定
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
	 * HcoBlkReqDataList.javapharmTypeを設定
	 * @return pharmType
	 */
	public String getPharmType() {
		return pharmType;
	}


	/**
	 * @param pharmType セットする pharmType
	 */
	public void setPharmType(String pharmType) {
		this.pharmType = pharmType;
	}


	/**
	 * HcoBlkReqDataList.javainsRankを設定
	 * @return insRank
	 */
	public String getInsRank() {
		return insRank;
	}


	/**
	 * @param insRank セットする insRank
	 */
	public void setInsRank(String insRank) {
		this.insRank = insRank;
	}


	/**
	 * HcoBlkReqDataList.javaregVisTypeを設定
	 * @return regVisType
	 */
	public String getRegVisType() {
		return regVisType;
	}


	/**
	 * @param regVisType セットする regVisType
	 */
	public void setRegVisType(String regVisType) {
		this.regVisType = regVisType;
	}


	/**
	 * HcoBlkReqDataList.javaimpHosTypeを設定
	 * @return impHosType
	 */
	public String getImpHosType() {
		return impHosType;
	}


	/**
	 * @param impHosType セットする impHosType
	 */
	public void setImpHosType(String impHosType) {
		this.impHosType = impHosType;
	}


	/**
	 * HcoBlkReqDataList.javahoInsTypeを設定
	 * @return hoInsType
	 */
	public String getHoInsType() {
		return hoInsType;
	}


	/**
	 * @param hoInsType セットする hoInsType
	 */
	public void setHoInsType(String hoInsType) {
		this.hoInsType = hoInsType;
	}


	/**
	 * HcoBlkReqDataList.javamanageNmを設定
	 * @return manageNm
	 */
	public String getManageNm() {
		return manageNm;
	}


	/**
	 * @param manageNm セットする manageNm
	 */
	public void setManageNm(String manageNm) {
		this.manageNm = manageNm;
	}


	/**
	 * HcoBlkReqDataList.javavacInsTypeを設定
	 * @return vacInsType
	 */
	public String getVacInsType() {
		return vacInsType;
	}


	/**
	 * @param vacInsType セットする vacInsType
	 */
	public void setVacInsType(String vacInsType) {
		this.vacInsType = vacInsType;
	}


	/**
	 * HcoBlkReqDataList.javavacVisitTypeを設定
	 * @return vacVisitType
	 */
	public String getVacVisitType() {
		return vacVisitType;
	}


	/**
	 * @param vacVisitType セットする vacVisitType
	 */
	public void setVacVisitType(String vacVisitType) {
		this.vacVisitType = vacVisitType;
	}


	/**
	 * HcoBlkReqDataList.javabedCntBaseを設定
	 * @return bedCntBase
	 */
	public String getBedCntBase() {
		return bedCntBase;
	}


	/**
	 * @param bedCntBase セットする bedCntBase
	 */
	public void setBedCntBase(String bedCntBase) {
		this.bedCntBase = bedCntBase;
	}


	/**
	 * HcoBlkReqDataList.javabedCnt04を設定
	 * @return bedCnt04
	 */
	public String getBedCnt04() {
		return bedCnt04;
	}


	/**
	 * @param bedCnt04 セットする bedCnt04
	 */
	public void setBedCnt04(String bedCnt04) {
		this.bedCnt04 = bedCnt04;
	}


	/**
	 * HcoBlkReqDataList.javabedCnt01を設定
	 * @return bedCnt01
	 */
	public String getBedCnt01() {
		return bedCnt01;
	}


	/**
	 * @param bedCnt01 セットする bedCnt01
	 */
	public void setBedCnt01(String bedCnt01) {
		this.bedCnt01 = bedCnt01;
	}


	/**
	 * HcoBlkReqDataList.javabedCnt05を設定
	 * @return bedCnt05
	 */
	public String getBedCnt05() {
		return bedCnt05;
	}


	/**
	 * @param bedCnt05 セットする bedCnt05
	 */
	public void setBedCnt05(String bedCnt05) {
		this.bedCnt05 = bedCnt05;
	}


	/**
	 * HcoBlkReqDataList.javabedCnt03を設定
	 * @return bedCnt03
	 */
	public String getBedCnt03() {
		return bedCnt03;
	}


	/**
	 * @param bedCnt03 セットする bedCnt03
	 */
	public void setBedCnt03(String bedCnt03) {
		this.bedCnt03 = bedCnt03;
	}


	/**
	 * HcoBlkReqDataList.javabedCnt07を設定
	 * @return bedCnt07
	 */
	public String getBedCnt07() {
		return bedCnt07;
	}


	/**
	 * @param bedCnt07 セットする bedCnt07
	 */
	public void setBedCnt07(String bedCnt07) {
		this.bedCnt07 = bedCnt07;
	}


	/**
	 * HcoBlkReqDataList.javabedCnt02を設定
	 * @return bedCnt02
	 */
	public String getBedCnt02() {
		return bedCnt02;
	}


	/**
	 * @param bedCnt02 セットする bedCnt02
	 */
	public void setBedCnt02(String bedCnt02) {
		this.bedCnt02 = bedCnt02;
	}


	/**
	 * HcoBlkReqDataList.javabedCnt06を設定
	 * @return bedCnt06
	 */
	public String getBedCnt06() {
		return bedCnt06;
	}


	/**
	 * @param bedCnt06 セットする bedCnt06
	 */
	public void setBedCnt06(String bedCnt06) {
		this.bedCnt06 = bedCnt06;
	}


	/**
	 * HcoBlkReqDataList.javabedsTotを設定
	 * @return bedsTot
	 */
	public String getBedsTot() {
		return bedsTot;
	}


	/**
	 * @param bedsTot セットする bedsTot
	 */
	public void setBedsTot(String bedsTot) {
		this.bedsTot = bedsTot;
	}


	/**
	 * HcoBlkReqDataList.javamedBedsTotを設定
	 * @return medBedsTot
	 */
	public String getMedBedsTot() {
		return medBedsTot;
	}


	/**
	 * @param medBedsTot セットする medBedsTot
	 */
	public void setMedBedsTot(String medBedsTot) {
		this.medBedsTot = medBedsTot;
	}


	/**
	 * HcoBlkReqDataList.javashisetsuKbnを設定
	 * @return shisetsuKbn
	 */
	public String getShisetsuKbn() {
		return shisetsuKbn;
	}


	/**
	 * @param shisetsuKbn セットする shisetsuKbn
	 */
	public void setShisetsuKbn(String shisetsuKbn) {
		this.shisetsuKbn = shisetsuKbn;
	}


	/**
	 * HcoBlkReqDataList.javakeieitaiを設定
	 * @return keieitai
	 */
	public String getKeieitai() {
		return keieitai;
	}


	/**
	 * @param keieitai セットする keieitai
	 */
	public void setKeieitai(String keieitai) {
		this.keieitai = keieitai;
	}


	/**
	 * HcoBlkReqDataList.javaultBedCntBaseを設定
	 * @return ultBedCntBase
	 */
	public String getUltBedCntBase() {
		return ultBedCntBase;
	}


	/**
	 * @param ultBedCntBase セットする ultBedCntBase
	 */
	public void setUltBedCntBase(String ultBedCntBase) {
		this.ultBedCntBase = ultBedCntBase;
	}


	/**
	 * HcoBlkReqDataList.javaultBedCnt04を設定
	 * @return ultBedCnt04
	 */
	public String getUltBedCnt04() {
		return ultBedCnt04;
	}


	/**
	 * @param ultBedCnt04 セットする ultBedCnt04
	 */
	public void setUltBedCnt04(String ultBedCnt04) {
		this.ultBedCnt04 = ultBedCnt04;
	}


	/**
	 * HcoBlkReqDataList.javaultBedCnt01を設定
	 * @return ultBedCnt01
	 */
	public String getUltBedCnt01() {
		return ultBedCnt01;
	}


	/**
	 * @param ultBedCnt01 セットする ultBedCnt01
	 */
	public void setUltBedCnt01(String ultBedCnt01) {
		this.ultBedCnt01 = ultBedCnt01;
	}


	/**
	 * HcoBlkReqDataList.javaultBedCnt05を設定
	 * @return ultBedCnt05
	 */
	public String getUltBedCnt05() {
		return ultBedCnt05;
	}


	/**
	 * @param ultBedCnt05 セットする ultBedCnt05
	 */
	public void setUltBedCnt05(String ultBedCnt05) {
		this.ultBedCnt05 = ultBedCnt05;
	}


	/**
	 * HcoBlkReqDataList.javaultBedCnt03を設定
	 * @return ultBedCnt03
	 */
	public String getUltBedCnt03() {
		return ultBedCnt03;
	}


	/**
	 * @param ultBedCnt03 セットする ultBedCnt03
	 */
	public void setUltBedCnt03(String ultBedCnt03) {
		this.ultBedCnt03 = ultBedCnt03;
	}


	/**
	 * HcoBlkReqDataList.javaultBedCnt07を設定
	 * @return ultBedCnt07
	 */
	public String getUltBedCnt07() {
		return ultBedCnt07;
	}


	/**
	 * @param ultBedCnt07 セットする ultBedCnt07
	 */
	public void setUltBedCnt07(String ultBedCnt07) {
		this.ultBedCnt07 = ultBedCnt07;
	}


	/**
	 * HcoBlkReqDataList.javaultBedCnt02を設定
	 * @return ultBedCnt02
	 */
	public String getUltBedCnt02() {
		return ultBedCnt02;
	}


	/**
	 * @param ultBedCnt02 セットする ultBedCnt02
	 */
	public void setUltBedCnt02(String ultBedCnt02) {
		this.ultBedCnt02 = ultBedCnt02;
	}


	/**
	 * HcoBlkReqDataList.javaultBedCnt06を設定
	 * @return ultBedCnt06
	 */
	public String getUltBedCnt06() {
		return ultBedCnt06;
	}


	/**
	 * @param ultBedCnt06 セットする ultBedCnt06
	 */
	public void setUltBedCnt06(String ultBedCnt06) {
		this.ultBedCnt06 = ultBedCnt06;
	}


	/**
	 * HcoBlkReqDataList.javaultBedsTotを設定
	 * @return ultBedsTot
	 */
	public String getUltBedsTot() {
		return ultBedsTot;
	}


	/**
	 * @param ultBedsTot セットする ultBedsTot
	 */
	public void setUltBedsTot(String ultBedsTot) {
		this.ultBedsTot = ultBedsTot;
	}


	/**
	 * HcoBlkReqDataList.javaultMedBedsTotを設定
	 * @return ultMedBedsTot
	 */
	public String getUltMedBedsTot() {
		return ultMedBedsTot;
	}


	/**
	 * @param ultMedBedsTot セットする ultMedBedsTot
	 */
	public void setUltMedBedsTot(String ultMedBedsTot) {
		this.ultMedBedsTot = ultMedBedsTot;
	}


	/**
	 * HcoBlkReqDataList.javanextPharmTypeを設定
	 * @return nextPharmType
	 */
	public String getNextPharmType() {
		return nextPharmType;
	}


	/**
	 * @param nextPharmType セットする nextPharmType
	 */
	public void setNextPharmType(String nextPharmType) {
		this.nextPharmType = nextPharmType;
	}


	/**
	 * HcoBlkReqDataList.javanextInsRankを設定
	 * @return nextInsRank
	 */
	public String getNextInsRank() {
		return nextInsRank;
	}


	/**
	 * @param nextInsRank セットする nextInsRank
	 */
	public void setNextInsRank(String nextInsRank) {
		this.nextInsRank = nextInsRank;
	}


	/**
	 * HcoBlkReqDataList.javanextRegVisTypeを設定
	 * @return nextRegVisType
	 */
	public String getNextRegVisType() {
		return nextRegVisType;
	}


	/**
	 * @param nextRegVisType セットする nextRegVisType
	 */
	public void setNextRegVisType(String nextRegVisType) {
		this.nextRegVisType = nextRegVisType;
	}


	/**
	 * HcoBlkReqDataList.javanextImpHosTypeを設定
	 * @return nextImpHosType
	 */
	public String getNextImpHosType() {
		return nextImpHosType;
	}


	/**
	 * @param nextImpHosType セットする nextImpHosType
	 */
	public void setNextImpHosType(String nextImpHosType) {
		this.nextImpHosType = nextImpHosType;
	}


	/**
	 * HcoBlkReqDataList.javanextHoInsTypeを設定
	 * @return nextHoInsType
	 */
	public String getNextHoInsType() {
		return nextHoInsType;
	}


	/**
	 * @param nextHoInsType セットする nextHoInsType
	 */
	public void setNextHoInsType(String nextHoInsType) {
		this.nextHoInsType = nextHoInsType;
	}


	/**
	 * HcoBlkReqDataList.javanextManageNmを設定
	 * @return nextManageNm
	 */
	public String getNextManageNm() {
		return nextManageNm;
	}


	/**
	 * @param nextManageNm セットする nextManageNm
	 */
	public void setNextManageNm(String nextManageNm) {
		this.nextManageNm = nextManageNm;
	}


	/**
	 * HcoBlkReqDataList.javanextVacInsTypeを設定
	 * @return nextVacInsType
	 */
	public String getNextVacInsType() {
		return nextVacInsType;
	}


	/**
	 * @param nextVacInsType セットする nextVacInsType
	 */
	public void setNextVacInsType(String nextVacInsType) {
		this.nextVacInsType = nextVacInsType;
	}


	/**
	 * HcoBlkReqDataList.javanextVacVisitTypeを設定
	 * @return nextVacVisitType
	 */
	public String getNextVacVisitType() {
		return nextVacVisitType;
	}


	/**
	 * @param nextVacVisitType セットする nextVacVisitType
	 */
	public void setNextVacVisitType(String nextVacVisitType) {
		this.nextVacVisitType = nextVacVisitType;
	}


	/**
	 * HcoBlkReqDataList.javanextBedCntBaseを設定
	 * @return nextBedCntBase
	 */
	public String getNextBedCntBase() {
		return nextBedCntBase;
	}


	/**
	 * @param nextBedCntBase セットする nextBedCntBase
	 */
	public void setNextBedCntBase(String nextBedCntBase) {
		this.nextBedCntBase = nextBedCntBase;
	}


	/**
	 * HcoBlkReqDataList.javanextBedCnt04を設定
	 * @return nextBedCnt04
	 */
	public String getNextBedCnt04() {
		return nextBedCnt04;
	}


	/**
	 * @param nextBedCnt04 セットする nextBedCnt04
	 */
	public void setNextBedCnt04(String nextBedCnt04) {
		this.nextBedCnt04 = nextBedCnt04;
	}


	/**
	 * HcoBlkReqDataList.javanextBedCnt01を設定
	 * @return nextBedCnt01
	 */
	public String getNextBedCnt01() {
		return nextBedCnt01;
	}


	/**
	 * @param nextBedCnt01 セットする nextBedCnt01
	 */
	public void setNextBedCnt01(String nextBedCnt01) {
		this.nextBedCnt01 = nextBedCnt01;
	}


	/**
	 * HcoBlkReqDataList.javanextBedCnt05を設定
	 * @return nextBedCnt05
	 */
	public String getNextBedCnt05() {
		return nextBedCnt05;
	}


	/**
	 * @param nextBedCnt05 セットする nextBedCnt05
	 */
	public void setNextBedCnt05(String nextBedCnt05) {
		this.nextBedCnt05 = nextBedCnt05;
	}


	/**
	 * HcoBlkReqDataList.javanextBedCnt03を設定
	 * @return nextBedCnt03
	 */
	public String getNextBedCnt03() {
		return nextBedCnt03;
	}


	/**
	 * @param nextBedCnt03 セットする nextBedCnt03
	 */
	public void setNextBedCnt03(String nextBedCnt03) {
		this.nextBedCnt03 = nextBedCnt03;
	}


	/**
	 * HcoBlkReqDataList.javanextBedCnt07を設定
	 * @return nextBedCnt07
	 */
	public String getNextBedCnt07() {
		return nextBedCnt07;
	}


	/**
	 * @param nextBedCnt07 セットする nextBedCnt07
	 */
	public void setNextBedCnt07(String nextBedCnt07) {
		this.nextBedCnt07 = nextBedCnt07;
	}


	/**
	 * HcoBlkReqDataList.javanextBedCnt02を設定
	 * @return nextBedCnt02
	 */
	public String getNextBedCnt02() {
		return nextBedCnt02;
	}


	/**
	 * @param nextBedCnt02 セットする nextBedCnt02
	 */
	public void setNextBedCnt02(String nextBedCnt02) {
		this.nextBedCnt02 = nextBedCnt02;
	}


	/**
	 * HcoBlkReqDataList.javanextBedCnt06を設定
	 * @return nextBedCnt06
	 */
	public String getNextBedCnt06() {
		return nextBedCnt06;
	}


	/**
	 * @param nextBedCnt06 セットする nextBedCnt06
	 */
	public void setNextBedCnt06(String nextBedCnt06) {
		this.nextBedCnt06 = nextBedCnt06;
	}


	/**
	 * HcoBlkReqDataList.javanextBedsTotを設定
	 * @return nextBedsTot
	 */
	public String getNextBedsTot() {
		return nextBedsTot;
	}


	/**
	 * @param nextBedsTot セットする nextBedsTot
	 */
	public void setNextBedsTot(String nextBedsTot) {
		this.nextBedsTot = nextBedsTot;
	}


	/**
	 * HcoBlkReqDataList.javanextMedBedsTotを設定
	 * @return nextMedBedsTot
	 */
	public String getNextMedBedsTot() {
		return nextMedBedsTot;
	}


	/**
	 * @param nextMedBedsTot セットする nextMedBedsTot
	 */
	public void setNextMedBedsTot(String nextMedBedsTot) {
		this.nextMedBedsTot = nextMedBedsTot;
	}


	/**
	 * HcoBlkReqDataList.javaultDifを設定
	 * @return ultDif
	 */
	public Integer getUltDif() {
		return ultDif;
	}


	/**
	 * @param ultDif セットする ultDif
	 */
	public void setUltDif(Integer ultDif) {
		this.ultDif = ultDif;
	}


	/**
	 * HcoBlkReqDataList.javareqCommentを設定
	 * @return reqComment
	 */
	public String getReqComment() {
		return reqComment;
	}


	/**
	 * @param reqComment セットする reqComment
	 */
	public void setReqComment(String reqComment) {
		this.reqComment = reqComment;
	}
}

