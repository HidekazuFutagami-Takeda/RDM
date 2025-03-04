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
 * Entityクラス
 * テーブル物理名 : T_RDM_HCO_NXT_REQ
 * テーブル論理名 : 施設_来期用_申請管理
 * @generated
 */
public class TRdmHcoNxtReqEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 申請ID
     * @generated
     */
    private String reqId;
    private boolean reqIdNullFlag;

/**
     * 施設固定コード
     * @generated
     */
    private String insNo;
    private boolean insNoNullFlag;

/**
     * 施設区分
     * @generated
     */
    private String pharmType;
    private boolean pharmTypeNullFlag;

/**
     * 対象区分
     * @generated
     */
    private String hoInsType;
    private boolean hoInsTypeNullFlag;

/**
     * 定訪先区分
     * @generated
     */
    private String regVisType;
    private boolean regVisTypeNullFlag;

/**
     * 階級区分
     * @generated
     */
    private String insRank;
    private boolean insRankNullFlag;

/**
     * 重点病院区分
     * @generated
     */
    private String impHosType;
    private boolean impHosTypeNullFlag;

/**
     * 経営主体コード
     * @generated
     */
    private String manageCd;
    private boolean manageCdNullFlag;

/**
     * ワクチン対象区分
     * @generated
     */
    private String vacInsType;
    private boolean vacInsTypeNullFlag;

/**
     * ワクチン定訪先区分
     * @generated
     */
    private String vacVisitType;
    private boolean vacVisitTypeNullFlag;

/**
     * 病床（基準）
     * @generated
     */
    private String bedcntBase;
    private boolean bedcntBaseNullFlag;

/**
     * 結核
     * @generated
     */
    private String bedcnt04;
    private boolean bedcnt04NullFlag;

/**
     * 一般
     * @generated
     */
    private String bedcnt01;
    private boolean bedcnt01NullFlag;

/**
     * 感染症
     * @generated
     */
    private String bedcnt05;
    private boolean bedcnt05NullFlag;

/**
     * 療養
     * @generated
     */
    private String bedcnt07;
    private boolean bedcnt07NullFlag;

/**
     * 医療療養
     * @generated
     */
    private String bedcnt02;
    private boolean bedcnt02NullFlag;

/**
     * 精神
     * @generated
     */
    private String bedcnt03;
    private boolean bedcnt03NullFlag;

/**
     * 介護医療
     * @generated
     */
    private String bedcnt06;
    private boolean bedcnt06NullFlag;

/**
     * ベッド数計
     * @generated
     */
    private String bedsTot;
    private boolean bedsTotNullFlag;

/**
     * 医療ベッド数計
     * @generated
     */
    private String medBedsTot;
    private boolean medBedsTotNullFlag;

/**
     * 作成日
     * @generated
     */
    private String insShaYmd;
    private boolean insShaYmdNullFlag;

/**
     * 作成者
     * @generated
     */
    private String insShaId;
    private boolean insShaIdNullFlag;

/**
     * 更新日
     * @generated
     */
    private String updShaYmd;
    private boolean updShaYmdNullFlag;

/**
     * 更新者
     * @generated
     */
    private String updShaId;
    private boolean updShaIdNullFlag;

    /**
     * コンストラクタ
     * @generated
     */
    public TRdmHcoNxtReqEntity() {
        super("t_rdm_hco_nxt_req");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public TRdmHcoNxtReqEntity(String sqlId) {
        super("t_rdm_hco_nxt_req", sqlId);
    }

	/**
	 * TRdmHcoNxtReqEntity.javareqIdを設定
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
	 * TRdmHcoNxtReqEntity.javareqIdNullFlagを設定
	 * @return reqIdNullFlag
	 */
	public boolean isReqIdNullFlag() {
		return reqIdNullFlag;
	}

	/**
	 * @param reqIdNullFlag セットする reqIdNullFlag
	 */
	public void setReqIdNullFlag(boolean reqIdNullFlag) {
		this.reqIdNullFlag = reqIdNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javainsNoを設定
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
	 * TRdmHcoNxtReqEntity.javainsNoNullFlagを設定
	 * @return insNoNullFlag
	 */
	public boolean isInsNoNullFlag() {
		return insNoNullFlag;
	}

	/**
	 * @param insNoNullFlag セットする insNoNullFlag
	 */
	public void setInsNoNullFlag(boolean insNoNullFlag) {
		this.insNoNullFlag = insNoNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javapharmTypeを設定
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
	 * TRdmHcoNxtReqEntity.javapharmTypeNullFlagを設定
	 * @return pharmTypeNullFlag
	 */
	public boolean isPharmTypeNullFlag() {
		return pharmTypeNullFlag;
	}

	/**
	 * @param pharmTypeNullFlag セットする pharmTypeNullFlag
	 */
	public void setPharmTypeNullFlag(boolean pharmTypeNullFlag) {
		this.pharmTypeNullFlag = pharmTypeNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javahoInsTypeを設定
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
	 * TRdmHcoNxtReqEntity.javahoInsTypeNullFlagを設定
	 * @return hoInsTypeNullFlag
	 */
	public boolean isHoInsTypeNullFlag() {
		return hoInsTypeNullFlag;
	}

	/**
	 * @param hoInsTypeNullFlag セットする hoInsTypeNullFlag
	 */
	public void setHoInsTypeNullFlag(boolean hoInsTypeNullFlag) {
		this.hoInsTypeNullFlag = hoInsTypeNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javaregVisTypeを設定
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
	 * TRdmHcoNxtReqEntity.javaregVisTypeNullFlagを設定
	 * @return regVisTypeNullFlag
	 */
	public boolean isRegVisTypeNullFlag() {
		return regVisTypeNullFlag;
	}

	/**
	 * @param regVisTypeNullFlag セットする regVisTypeNullFlag
	 */
	public void setRegVisTypeNullFlag(boolean regVisTypeNullFlag) {
		this.regVisTypeNullFlag = regVisTypeNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javainsRankを設定
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
	 * TRdmHcoNxtReqEntity.javainsRankNullFlagを設定
	 * @return insRankNullFlag
	 */
	public boolean isInsRankNullFlag() {
		return insRankNullFlag;
	}

	/**
	 * @param insRankNullFlag セットする insRankNullFlag
	 */
	public void setInsRankNullFlag(boolean insRankNullFlag) {
		this.insRankNullFlag = insRankNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javaimpHosTypeを設定
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
	 * TRdmHcoNxtReqEntity.javaimpHosTypeNullFlagを設定
	 * @return impHosTypeNullFlag
	 */
	public boolean isImpHosTypeNullFlag() {
		return impHosTypeNullFlag;
	}

	/**
	 * @param impHosTypeNullFlag セットする impHosTypeNullFlag
	 */
	public void setImpHosTypeNullFlag(boolean impHosTypeNullFlag) {
		this.impHosTypeNullFlag = impHosTypeNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javamanageCdを設定
	 * @return manageCd
	 */
	public String getManageCd() {
		return manageCd;
	}

	/**
	 * @param manageCd セットする manageCd
	 */
	public void setManageCd(String manageCd) {
		this.manageCd = manageCd;
	}

	/**
	 * TRdmHcoNxtReqEntity.javamanageCdNullFlagを設定
	 * @return manageCdNullFlag
	 */
	public boolean isManageCdNullFlag() {
		return manageCdNullFlag;
	}

	/**
	 * @param manageCdNullFlag セットする manageCdNullFlag
	 */
	public void setManageCdNullFlag(boolean manageCdNullFlag) {
		this.manageCdNullFlag = manageCdNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javavacInsTypeを設定
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
	 * TRdmHcoNxtReqEntity.javavacInsTypeNullFlagを設定
	 * @return vacInsTypeNullFlag
	 */
	public boolean isVacInsTypeNullFlag() {
		return vacInsTypeNullFlag;
	}

	/**
	 * @param vacInsTypeNullFlag セットする vacInsTypeNullFlag
	 */
	public void setVacInsTypeNullFlag(boolean vacInsTypeNullFlag) {
		this.vacInsTypeNullFlag = vacInsTypeNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javavacVisitTypeを設定
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
	 * TRdmHcoNxtReqEntity.javavacVisitTypeNullFlagを設定
	 * @return vacVisitTypeNullFlag
	 */
	public boolean isVacVisitTypeNullFlag() {
		return vacVisitTypeNullFlag;
	}

	/**
	 * @param vacVisitTypeNullFlag セットする vacVisitTypeNullFlag
	 */
	public void setVacVisitTypeNullFlag(boolean vacVisitTypeNullFlag) {
		this.vacVisitTypeNullFlag = vacVisitTypeNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcntBaseを設定
	 * @return bedcntBase
	 */
	public String getBedcntBase() {
		return bedcntBase;
	}

	/**
	 * @param bedcntBase セットする bedcntBase
	 */
	public void setBedcntBase(String bedcntBase) {
		this.bedcntBase = bedcntBase;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcntBaseNullFlagを設定
	 * @return bedcntBaseNullFlag
	 */
	public boolean isBedcntBaseNullFlag() {
		return bedcntBaseNullFlag;
	}

	/**
	 * @param bedcntBaseNullFlag セットする bedcntBaseNullFlag
	 */
	public void setBedcntBaseNullFlag(boolean bedcntBaseNullFlag) {
		this.bedcntBaseNullFlag = bedcntBaseNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt04を設定
	 * @return bedcnt04
	 */
	public String getBedcnt04() {
		return bedcnt04;
	}

	/**
	 * @param bedcnt04 セットする bedcnt04
	 */
	public void setBedcnt04(String bedcnt04) {
		this.bedcnt04 = bedcnt04;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt04NullFlagを設定
	 * @return bedcnt04NullFlag
	 */
	public boolean isBedcnt04NullFlag() {
		return bedcnt04NullFlag;
	}

	/**
	 * @param bedcnt04NullFlag セットする bedcnt04NullFlag
	 */
	public void setBedcnt04NullFlag(boolean bedcnt04NullFlag) {
		this.bedcnt04NullFlag = bedcnt04NullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt01を設定
	 * @return bedcnt01
	 */
	public String getBedcnt01() {
		return bedcnt01;
	}

	/**
	 * @param bedcnt01 セットする bedcnt01
	 */
	public void setBedcnt01(String bedcnt01) {
		this.bedcnt01 = bedcnt01;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt01NullFlagを設定
	 * @return bedcnt01NullFlag
	 */
	public boolean isBedcnt01NullFlag() {
		return bedcnt01NullFlag;
	}

	/**
	 * @param bedcnt01NullFlag セットする bedcnt01NullFlag
	 */
	public void setBedcnt01NullFlag(boolean bedcnt01NullFlag) {
		this.bedcnt01NullFlag = bedcnt01NullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt05を設定
	 * @return bedcnt05
	 */
	public String getBedcnt05() {
		return bedcnt05;
	}

	/**
	 * @param bedcnt05 セットする bedcnt05
	 */
	public void setBedcnt05(String bedcnt05) {
		this.bedcnt05 = bedcnt05;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt05NullFlagを設定
	 * @return bedcnt05NullFlag
	 */
	public boolean isBedcnt05NullFlag() {
		return bedcnt05NullFlag;
	}

	/**
	 * @param bedcnt05NullFlag セットする bedcnt05NullFlag
	 */
	public void setBedcnt05NullFlag(boolean bedcnt05NullFlag) {
		this.bedcnt05NullFlag = bedcnt05NullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt07を設定
	 * @return bedcnt07
	 */
	public String getBedcnt07() {
		return bedcnt07;
	}

	/**
	 * @param bedcnt07 セットする bedcnt07
	 */
	public void setBedcnt07(String bedcnt07) {
		this.bedcnt07 = bedcnt07;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt07NullFlagを設定
	 * @return bedcnt07NullFlag
	 */
	public boolean isBedcnt07NullFlag() {
		return bedcnt07NullFlag;
	}

	/**
	 * @param bedcnt07NullFlag セットする bedcnt07NullFlag
	 */
	public void setBedcnt07NullFlag(boolean bedcnt07NullFlag) {
		this.bedcnt07NullFlag = bedcnt07NullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt02を設定
	 * @return bedcnt02
	 */
	public String getBedcnt02() {
		return bedcnt02;
	}

	/**
	 * @param bedcnt02 セットする bedcnt02
	 */
	public void setBedcnt02(String bedcnt02) {
		this.bedcnt02 = bedcnt02;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt02NullFlagを設定
	 * @return bedcnt02NullFlag
	 */
	public boolean isBedcnt02NullFlag() {
		return bedcnt02NullFlag;
	}

	/**
	 * @param bedcnt02NullFlag セットする bedcnt02NullFlag
	 */
	public void setBedcnt02NullFlag(boolean bedcnt02NullFlag) {
		this.bedcnt02NullFlag = bedcnt02NullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt03を設定
	 * @return bedcnt03
	 */
	public String getBedcnt03() {
		return bedcnt03;
	}

	/**
	 * @param bedcnt03 セットする bedcnt03
	 */
	public void setBedcnt03(String bedcnt03) {
		this.bedcnt03 = bedcnt03;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt03NullFlagを設定
	 * @return bedcnt03NullFlag
	 */
	public boolean isBedcnt03NullFlag() {
		return bedcnt03NullFlag;
	}

	/**
	 * @param bedcnt03NullFlag セットする bedcnt03NullFlag
	 */
	public void setBedcnt03NullFlag(boolean bedcnt03NullFlag) {
		this.bedcnt03NullFlag = bedcnt03NullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt06を設定
	 * @return bedcnt06
	 */
	public String getBedcnt06() {
		return bedcnt06;
	}

	/**
	 * @param bedcnt06 セットする bedcnt06
	 */
	public void setBedcnt06(String bedcnt06) {
		this.bedcnt06 = bedcnt06;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedcnt06NullFlagを設定
	 * @return bedcnt06NullFlag
	 */
	public boolean isBedcnt06NullFlag() {
		return bedcnt06NullFlag;
	}

	/**
	 * @param bedcnt06NullFlag セットする bedcnt06NullFlag
	 */
	public void setBedcnt06NullFlag(boolean bedcnt06NullFlag) {
		this.bedcnt06NullFlag = bedcnt06NullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javabedsTotを設定
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
	 * TRdmHcoNxtReqEntity.javabedsTotNullFlagを設定
	 * @return bedsTotNullFlag
	 */
	public boolean isBedsTotNullFlag() {
		return bedsTotNullFlag;
	}

	/**
	 * @param bedsTotNullFlag セットする bedsTotNullFlag
	 */
	public void setBedsTotNullFlag(boolean bedsTotNullFlag) {
		this.bedsTotNullFlag = bedsTotNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javamedBedsTotを設定
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
	 * TRdmHcoNxtReqEntity.javamedBedsTotNullFlagを設定
	 * @return medBedsTotNullFlag
	 */
	public boolean isMedBedsTotNullFlag() {
		return medBedsTotNullFlag;
	}

	/**
	 * @param medBedsTotNullFlag セットする medBedsTotNullFlag
	 */
	public void setMedBedsTotNullFlag(boolean medBedsTotNullFlag) {
		this.medBedsTotNullFlag = medBedsTotNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javainsShaYmdを設定
	 * @return insShaYmd
	 */
	public String getInsShaYmd() {
		return insShaYmd;
	}

	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(String insShaYmd) {
		this.insShaYmd = insShaYmd;
	}

	/**
	 * TRdmHcoNxtReqEntity.javainsShaYmdNullFlagを設定
	 * @return insShaYmdNullFlag
	 */
	public boolean isInsShaYmdNullFlag() {
		return insShaYmdNullFlag;
	}

	/**
	 * @param insShaYmdNullFlag セットする insShaYmdNullFlag
	 */
	public void setInsShaYmdNullFlag(boolean insShaYmdNullFlag) {
		this.insShaYmdNullFlag = insShaYmdNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javainsShaIdを設定
	 * @return insShaId
	 */
	public String getInsShaId() {
		return insShaId;
	}

	/**
	 * @param insShaId セットする insShaId
	 */
	public void setInsShaId(String insShaId) {
		this.insShaId = insShaId;
	}

	/**
	 * TRdmHcoNxtReqEntity.javainsShaIdNullFlagを設定
	 * @return insShaIdNullFlag
	 */
	public boolean isInsShaIdNullFlag() {
		return insShaIdNullFlag;
	}

	/**
	 * @param insShaIdNullFlag セットする insShaIdNullFlag
	 */
	public void setInsShaIdNullFlag(boolean insShaIdNullFlag) {
		this.insShaIdNullFlag = insShaIdNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public String getUpdShaYmd() {
		return updShaYmd;
	}

	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(String updShaYmd) {
		this.updShaYmd = updShaYmd;
	}

	/**
	 * TRdmHcoNxtReqEntity.javaupdShaYmdNullFlagを設定
	 * @return updShaYmdNullFlag
	 */
	public boolean isUpdShaYmdNullFlag() {
		return updShaYmdNullFlag;
	}

	/**
	 * @param updShaYmdNullFlag セットする updShaYmdNullFlag
	 */
	public void setUpdShaYmdNullFlag(boolean updShaYmdNullFlag) {
		this.updShaYmdNullFlag = updShaYmdNullFlag;
	}

	/**
	 * TRdmHcoNxtReqEntity.javaupdShaIdを設定
	 * @return updShaId
	 */
	public String getUpdShaId() {
		return updShaId;
	}

	/**
	 * @param updShaId セットする updShaId
	 */
	public void setUpdShaId(String updShaId) {
		this.updShaId = updShaId;
	}

	/**
	 * TRdmHcoNxtReqEntity.javaupdShaIdNullFlagを設定
	 * @return updShaIdNullFlag
	 */
	public boolean isUpdShaIdNullFlag() {
		return updShaIdNullFlag;
	}

	/**
	 * @param updShaIdNullFlag セットする updShaIdNullFlag
	 */
	public void setUpdShaIdNullFlag(boolean updShaIdNullFlag) {
		this.updShaIdNullFlag = updShaIdNullFlag;
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
