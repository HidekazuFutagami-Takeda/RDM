/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_HCO_REQ
 * SQLID : selectNC203MainData
 */
public class SelectNC203MainDataEntity extends BaseEntity implements Serializable {

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

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * 施設分類
     * @generated
     */
    private String insClass;

    /**
     * 施設種別
     * @generated
     */
    private String insSbt;

    /**
     * 施設カナ名
     * @generated
     */
    private String insKana;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 施設正式漢字名
     * @generated
     */
    private String insFormalName;

    /**
     * 契約用正式漢字名
     * @generated
     */
    private String insContName;

    /**
     * 郵便番号
     * @generated
     */
    private String insPcode;

    /**
     * JIS府県コード
     * @generated
     */
    private String addrCodePref;

    /**
     * JIS市区町村コード
     * @generated
     */
    private String addrCodeCity;

    /**
     * 武田市区郡コード
     * @generated
     */
    private String tkCityCd;

    /**
     * 町名地番
     * @generated
     */
    private String insAddrDt;

    /**
     * 施設住所（漢字）
     * @generated
     */
    private String insAddr;

    /**
     * 施設住所（カナ）
     * @generated
     */
    private String insAddrKana;

    /**
     * 電話番号1
     * @generated
     */
    private String insPhone1;

    /**
     * FAX番号1
     * @generated
     */
    private String insFax1;

    /**
     * 電話番号2
     * @generated
     */
    private String insPhone2;

    /**
     * FAX番号2
     * @generated
     */
    private String insFax2;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * 施設区分
     * @generated
     */
    private String pharmType;

    /**
     * 経営主体コード
     * @generated
     */
    private String manageCd;

    /**
     * ベッド数計
     * @generated
     */
    private String bedsTot;

    /**
     * 削除区分
     * @generated
     */
    private Integer delKbn;

    /**
     * 削除理由
     * @generated
     */
    private String delReason;

    /**
     * 削除年月日
     * @generated
     */
    private String delYmd;

    /**
     * 作成日
     * @generated
     */
    private Date insShaYmd;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;

    /**
     * ソートID(パラメータ)
     */
    private String inSortId;

    /**
     * 医師検索表示件数
     */
    private Integer cntHco;

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
     * コンストラクタ
     */
    public SelectNC203MainDataEntity() {
        super("t_rdm_hco_req" , "selectNC203InsREQData");
    }

    /**
     * コンストラクタ
     */
    public SelectNC203MainDataEntity(String sqlId) {
        super("t_rdm_hco_req" , sqlId);
    }

    /**
	 * SelectNC203MainDataEntity.reqIdを設定
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
	 * SelectNC203MainDataEntity.insNoを設定
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
	 * SelectNC203MainDataEntity.insClassを設定
	 * @return insClass
	 */
	public String getInsClass() {
		return insClass;
	}

	/**
	 * @param insClass セットする insClass
	 */
	public void setInsClass(String insClass) {
		this.insClass = insClass;
	}

	/**
	 * SelectNC203MainDataEntity.insSbtを設定
	 * @return insSbt
	 */
	public String getInsSbt() {
		return insSbt;
	}

	/**
	 * @param insSbt セットする insSbt
	 */
	public void setInsSbt(String insSbt) {
		this.insSbt = insSbt;
	}

	/**
	 * SelectNC203MainDataEntity.insKanaを設定
	 * @return insKana
	 */
	public String getInsKana() {
		return insKana;
	}

	/**
	 * @param insKana セットする insKana
	 */
	public void setInsKana(String insKana) {
		this.insKana = insKana;
	}

	/**
	 * SelectNC203MainDataEntity.insAbbrNameを設定
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
	 * SelectNC203MainDataEntity.insFormalNameを設定
	 * @return insFormalName
	 */
	public String getInsFormalName() {
		return insFormalName;
	}

	/**
	 * @param insFormalName セットする insFormalName
	 */
	public void setInsFormalName(String insFormalName) {
		this.insFormalName = insFormalName;
	}

	/**
	 * SelectNC203MainDataEntity.insContNameを設定
	 * @return insContName
	 */
	public String getInsContName() {
		return insContName;
	}

	/**
	 * @param insContName セットする insContName
	 */
	public void setInsContName(String insContName) {
		this.insContName = insContName;
	}

	/**
	 * SelectNC203MainDataEntity.insPcodeを設定
	 * @return insPcode
	 */
	public String getInsPcode() {
		return insPcode;
	}

	/**
	 * @param insPcode セットする insPcode
	 */
	public void setInsPcode(String insPcode) {
		this.insPcode = insPcode;
	}

	/**
	 * SelectNC203MainDataEntity.addrCodePrefを設定
	 * @return addrCodePref
	 */
	public String getAddrCodePref() {
		return addrCodePref;
	}

	/**
	 * @param addrCodePref セットする addrCodePref
	 */
	public void setAddrCodePref(String addrCodePref) {
		this.addrCodePref = addrCodePref;
	}

	/**
	 * SelectNC203MainDataEntity.addrCodeCityを設定
	 * @return addrCodeCity
	 */
	public String getAddrCodeCity() {
		return addrCodeCity;
	}

	/**
	 * @param addrCodeCity セットする addrCodeCity
	 */
	public void setAddrCodeCity(String addrCodeCity) {
		this.addrCodeCity = addrCodeCity;
	}

	/**
	 * SelectNC203MainDataEntity.tkCityCdを設定
	 * @return tkCityCd
	 */
	public String getTkCityCd() {
		return tkCityCd;
	}

	/**
	 * @param tkCityCd セットする tkCityCd
	 */
	public void setTkCityCd(String tkCityCd) {
		this.tkCityCd = tkCityCd;
	}

	/**
	 * SelectNC203MainDataEntity.insAddrDtを設定
	 * @return insAddrDt
	 */
	public String getInsAddrDt() {
		return insAddrDt;
	}

	/**
	 * @param insAddrDt セットする insAddrDt
	 */
	public void setInsAddrDt(String insAddrDt) {
		this.insAddrDt = insAddrDt;
	}

	/**
	 * SelectNC203MainDataEntity.insAddrを設定
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
	 * SelectNC203MainDataEntity.insAddrKanaを設定
	 * @return insAddrKana
	 */
	public String getInsAddrKana() {
		return insAddrKana;
	}

	/**
	 * @param insAddrKana セットする insAddrKana
	 */
	public void setInsAddrKana(String insAddrKana) {
		this.insAddrKana = insAddrKana;
	}

	/**
	 * SelectNC203MainDataEntity.insPhone1を設定
	 * @return insPhone1
	 */
	public String getInsPhone1() {
		return insPhone1;
	}

	/**
	 * @param insPhone1 セットする insPhone1
	 */
	public void setInsPhone1(String insPhone1) {
		this.insPhone1 = insPhone1;
	}

	/**
	 * SelectNC203MainDataEntity.insFax1を設定
	 * @return insFax1
	 */
	public String getInsFax1() {
		return insFax1;
	}

	/**
	 * @param insFax1 セットする insFax1
	 */
	public void setInsFax1(String insFax1) {
		this.insFax1 = insFax1;
	}

	/**
	 * SelectNC203MainDataEntity.insPhone2を設定
	 * @return insPhone2
	 */
	public String getInsPhone2() {
		return insPhone2;
	}

	/**
	 * @param insPhone2 セットする insPhone2
	 */
	public void setInsPhone2(String insPhone2) {
		this.insPhone2 = insPhone2;
	}

	/**
	 * SelectNC203MainDataEntity.insFax2を設定
	 * @return insFax2
	 */
	public String getInsFax2() {
		return insFax2;
	}

	/**
	 * @param insFax2 セットする insFax2
	 */
	public void setInsFax2(String insFax2) {
		this.insFax2 = insFax2;
	}

	/**
	 * SelectNC203MainDataEntity.hoInsTypeを設定
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
	 * SelectNC203MainDataEntity.pharmTypeを設定
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
	 * SelectNC203MainDataEntity.manageCdを設定
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
	 * SelectNC203MainDataEntity.bedsTotを設定
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
	 * SelectNC203MainDataEntity.delKbnを設定
	 * @return delKbn
	 */
	public Integer getDelKbn() {
		return delKbn;
	}

	/**
	 * @param delKbn セットする delKbn
	 */
	public void setDelKbn(Integer delKbn) {
		this.delKbn = delKbn;
	}

	/**
	 * SelectNC203MainDataEntity.delReasonを設定
	 * @return delReason
	 */
	public String getDelReason() {
		return delReason;
	}

	/**
	 * @param delReason セットする delReason
	 */
	public void setDelReason(String delReason) {
		this.delReason = delReason;
	}

	/**
	 * SelectNC203MainDataEntity.delYmdを設定
	 * @return delYmd
	 */
	public String getDelYmd() {
		return delYmd;
	}

	/**
	 * @param delYmd セットする delYmd
	 */
	public void setDelYmd(String delYmd) {
		this.delYmd = delYmd;
	}

	/**
	 * SelectNC203MainDataEntity.insShaYmdを設定
	 * @return insShaYmd
	 */
	public Date getInsShaYmd() {
		return insShaYmd;
	}

	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(Date insShaYmd) {
		this.insShaYmd = insShaYmd;
	}

	/**
	 * SelectNC203MainDataEntity.insShaIdを設定
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
	 * SelectNC203MainDataEntity.updShaYmdを設定
	 * @return updShaYmd
	 */
	public Date getUpdShaYmd() {
		return updShaYmd;
	}

	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(Date updShaYmd) {
		this.updShaYmd = updShaYmd;
	}

	/**
	 * SelectNC203MainDataEntity.updShaIdを設定
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
	 * SelectNC203MainDataEntity.inSortIdを設定
	 * @return inSortId
	 */
	public String getInSortId() {
		return inSortId;
	}

	/**
	 * @param inSortId セットする inSortId
	 */
	public void setInSortId(String inSortId) {
		this.inSortId = inSortId;
	}

	/**
	 * SelectNC203MainDataEntity.cntHcoを設定
	 * @return cntHco
	 */
	public Integer getCntHco() {
		return cntHco;
	}

	/**
	 * @param cntHco セットする cntHco
	 */
	public void setCntHco(Integer cntHco) {
		this.cntHco = cntHco;
	}

	/**
	 * SelectNC203MainDataEntity.inOffsetを設定
	 * @return inOffset
	 */
	public Integer getInOffset() {
		return inOffset;
	}

	/**
	 * @param inOffset セットする inOffset
	 */
	public void setInOffset(Integer inOffset) {
		this.inOffset = inOffset;
	}

	/**
	 * SelectNC203MainDataEntity.inLimitを設定
	 * @return inLimit
	 */
	public Integer getInLimit() {
		return inLimit;
	}

	/**
	 * @param inLimit セットする inLimit
	 */
	public void setInLimit(Integer inLimit) {
		this.inLimit = inLimit;
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
