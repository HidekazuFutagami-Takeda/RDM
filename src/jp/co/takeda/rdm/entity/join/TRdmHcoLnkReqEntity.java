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
 * テーブル物理名 : T_RDM_HCO_LNK_REQ
 * テーブル論理名 : 領域品目グループ別親子_申請管理
 * @generated
 */
public class TRdmHcoLnkReqEntity extends BaseEntity implements Serializable {

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
     * 領域コード
     * @generated
     */
    private String trtCd;
    private boolean trtCdNullFlag;

    /**
     * 品目グループコード
     * @generated
     */
    private String hinGCd;
    private boolean hinGCdNullFlag;

    /**
     * 子施設コード
     * @generated
     */
    private String insNo;
    private boolean insNoNullFlag;

    /**
     * 親施設コード(変更前)
     * @generated
     */
    private String mainInsNoBf;
    private boolean mainInsNoBfNullFlag;

    /**
     * 親施設フラグ(変更前)
     * @generated
     */
    private String mainInsFlgBf;
    private boolean mainInsFlgBfNullFlag;

    /**
     * 施設種別(変更前)
     * @generated
     */
    private String insSbtBf;
    private boolean insSbtBfNullFlag;

    /**
     * 親施設コード(変更後)
     * @generated
     */
    private String mainInsNoAf;
    private boolean mainInsNoAfNullFlag;

    /**
     * 親施設フラグ(変更後)
     * @generated
     */
    private String mainInsFlgAf;
    private boolean mainInsFlgAfNullFlag;

    /**
     * 施設種別(変更後)
     * @generated
     */
    private String insSbtAf;
    private boolean insSbtAfNullFlag;

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
    public TRdmHcoLnkReqEntity() {
        super("t_rdm_hco_lnk_req");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public TRdmHcoLnkReqEntity(String sqlId) {
        super("t_rdm_hco_lnk_req", sqlId);
    }

	/**
	 * TRdmHcoLnkReqEntity.javareqIdを設定
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
	 * TRdmHcoLnkReqEntity.javareqIdNullFlagを設定
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
	 * TRdmHcoLnkReqEntity.javatrtCdを設定
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
	 * TRdmHcoLnkReqEntity.javatrtCdNullFlagを設定
	 * @return trtCdNullFlag
	 */
	public boolean isTrtCdNullFlag() {
		return trtCdNullFlag;
	}

	/**
	 * @param trtCdNullFlag セットする trtCdNullFlag
	 */
	public void setTrtCdNullFlag(boolean trtCdNullFlag) {
		this.trtCdNullFlag = trtCdNullFlag;
	}

	/**
	 * TRdmHcoLnkReqEntity.javahinGCdを設定
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
	 * TRdmHcoLnkReqEntity.javahinGCdNullFlagを設定
	 * @return hinGCdNullFlag
	 */
	public boolean isHinGCdNullFlag() {
		return hinGCdNullFlag;
	}

	/**
	 * @param hinGCdNullFlag セットする hinGCdNullFlag
	 */
	public void setHinGCdNullFlag(boolean hinGCdNullFlag) {
		this.hinGCdNullFlag = hinGCdNullFlag;
	}

	/**
	 * TRdmHcoLnkReqEntity.javainsNoを設定
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
	 * TRdmHcoLnkReqEntity.javainsNoNullFlagを設定
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
	 * TRdmHcoLnkReqEntity.javamainInsNoBfを設定
	 * @return mainInsNoBf
	 */
	public String getMainInsNoBf() {
		return mainInsNoBf;
	}

	/**
	 * @param mainInsNoBf セットする mainInsNoBf
	 */
	public void setMainInsNoBf(String mainInsNoBf) {
		this.mainInsNoBf = mainInsNoBf;
	}

	/**
	 * TRdmHcoLnkReqEntity.javamainInsNoBfNullFlagを設定
	 * @return mainInsNoBfNullFlag
	 */
	public boolean isMainInsNoBfNullFlag() {
		return mainInsNoBfNullFlag;
	}

	/**
	 * @param mainInsNoBfNullFlag セットする mainInsNoBfNullFlag
	 */
	public void setMainInsNoBfNullFlag(boolean mainInsNoBfNullFlag) {
		this.mainInsNoBfNullFlag = mainInsNoBfNullFlag;
	}

	/**
	 * TRdmHcoLnkReqEntity.javamainInsFlgBfを設定
	 * @return mainInsFlgBf
	 */
	public String getMainInsFlgBf() {
		return mainInsFlgBf;
	}

	/**
	 * @param mainInsFlgBf セットする mainInsFlgBf
	 */
	public void setMainInsFlgBf(String mainInsFlgBf) {
		this.mainInsFlgBf = mainInsFlgBf;
	}

	/**
	 * TRdmHcoLnkReqEntity.javamainInsFlgBfNullFlagを設定
	 * @return mainInsFlgBfNullFlag
	 */
	public boolean isMainInsFlgBfNullFlag() {
		return mainInsFlgBfNullFlag;
	}

	/**
	 * @param mainInsFlgBfNullFlag セットする mainInsFlgBfNullFlag
	 */
	public void setMainInsFlgBfNullFlag(boolean mainInsFlgBfNullFlag) {
		this.mainInsFlgBfNullFlag = mainInsFlgBfNullFlag;
	}

	/**
	 * TRdmHcoLnkReqEntity.javainsSbtBfを設定
	 * @return insSbtBf
	 */
	public String getInsSbtBf() {
		return insSbtBf;
	}

	/**
	 * @param insSbtBf セットする insSbtBf
	 */
	public void setInsSbtBf(String insSbtBf) {
		this.insSbtBf = insSbtBf;
	}

	/**
	 * TRdmHcoLnkReqEntity.javainsSbtBfNullFlagを設定
	 * @return insSbtBfNullFlag
	 */
	public boolean isInsSbtBfNullFlag() {
		return insSbtBfNullFlag;
	}

	/**
	 * @param insSbtBfNullFlag セットする insSbtBfNullFlag
	 */
	public void setInsSbtBfNullFlag(boolean insSbtBfNullFlag) {
		this.insSbtBfNullFlag = insSbtBfNullFlag;
	}

	/**
	 * TRdmHcoLnkReqEntity.javamainInsNoAfを設定
	 * @return mainInsNoAf
	 */
	public String getMainInsNoAf() {
		return mainInsNoAf;
	}

	/**
	 * @param mainInsNoAf セットする mainInsNoAf
	 */
	public void setMainInsNoAf(String mainInsNoAf) {
		this.mainInsNoAf = mainInsNoAf;
	}

	/**
	 * TRdmHcoLnkReqEntity.javamainInsNoAfNullFlagを設定
	 * @return mainInsNoAfNullFlag
	 */
	public boolean isMainInsNoAfNullFlag() {
		return mainInsNoAfNullFlag;
	}

	/**
	 * @param mainInsNoAfNullFlag セットする mainInsNoAfNullFlag
	 */
	public void setMainInsNoAfNullFlag(boolean mainInsNoAfNullFlag) {
		this.mainInsNoAfNullFlag = mainInsNoAfNullFlag;
	}

	/**
	 * TRdmHcoLnkReqEntity.javamainInsFlgAfを設定
	 * @return mainInsFlgAf
	 */
	public String getMainInsFlgAf() {
		return mainInsFlgAf;
	}

	/**
	 * @param mainInsFlgAf セットする mainInsFlgAf
	 */
	public void setMainInsFlgAf(String mainInsFlgAf) {
		this.mainInsFlgAf = mainInsFlgAf;
	}

	/**
	 * TRdmHcoLnkReqEntity.javamainInsFlgAfNullFlagを設定
	 * @return mainInsFlgAfNullFlag
	 */
	public boolean isMainInsFlgAfNullFlag() {
		return mainInsFlgAfNullFlag;
	}

	/**
	 * @param mainInsFlgAfNullFlag セットする mainInsFlgAfNullFlag
	 */
	public void setMainInsFlgAfNullFlag(boolean mainInsFlgAfNullFlag) {
		this.mainInsFlgAfNullFlag = mainInsFlgAfNullFlag;
	}

	/**
	 * TRdmHcoLnkReqEntity.javainsSbtAfを設定
	 * @return insSbtAf
	 */
	public String getInsSbtAf() {
		return insSbtAf;
	}

	/**
	 * @param insSbtAf セットする insSbtAf
	 */
	public void setInsSbtAf(String insSbtAf) {
		this.insSbtAf = insSbtAf;
	}

	/**
	 * TRdmHcoLnkReqEntity.javainsSbtAfNullFlagを設定
	 * @return insSbtAfNullFlag
	 */
	public boolean isInsSbtAfNullFlag() {
		return insSbtAfNullFlag;
	}

	/**
	 * @param insSbtAfNullFlag セットする insSbtAfNullFlag
	 */
	public void setInsSbtAfNullFlag(boolean insSbtAfNullFlag) {
		this.insSbtAfNullFlag = insSbtAfNullFlag;
	}

	/**
	 * TRdmHcoLnkReqEntity.javainsShaYmdを設定
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
	 * TRdmHcoLnkReqEntity.javainsShaYmdNullFlagを設定
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
	 * TRdmHcoLnkReqEntity.javainsShaIdを設定
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
	 * TRdmHcoLnkReqEntity.javainsShaIdNullFlagを設定
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
	 * TRdmHcoLnkReqEntity.javaupdShaYmdを設定
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
	 * TRdmHcoLnkReqEntity.javaupdShaYmdNullFlagを設定
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
	 * TRdmHcoLnkReqEntity.javaupdShaIdを設定
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
	 * TRdmHcoLnkReqEntity.javaupdShaIdNullFlagを設定
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
