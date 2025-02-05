package jp.co.takeda.rdm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_HCO_KEIEITAI
 * テーブル論理名 : 施設_経営主体マスタ
 * @generated
 */
public class MRdmHcoKeieitaiEntiry extends BaseEntity implements Serializable {

	/**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 武田経営主体コード
     * @generated
     */
    private String setDtCd;
    private boolean setDtCdNullFlag;

    /**
     * 武田経営主体名
     * @generated
     */
    private String keieitaiKj;
    private boolean keieitaiKjNullFlag;

	 /**
     * コンストラクタ
     * @generated
     */
    public MRdmHcoKeieitaiEntiry() {
        super("m_rdm_hco_keieitai", "selectMRdmHcoKeieitaiEntiry");
    }


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getSetDtCd() {
		return setDtCd;
	}


	public void setSetDtCd(String setDtCd) {
		this.setDtCd = setDtCd;
	}


	public boolean isSetDtCdNullFlag() {
		return setDtCdNullFlag;
	}


	public void setSetDtCdNullFlag(boolean setDtCdNullFlag) {
		this.setDtCdNullFlag = setDtCdNullFlag;
	}


	public String getKeieitaiKj() {
		return keieitaiKj;
	}


	public void setKeieitaiKj(String keieitaiKj) {
		this.keieitaiKj = keieitaiKj;
	}


	public boolean isKeieitaiKjNullFlag() {
		return keieitaiKjNullFlag;
	}


	public void setKeieitaiKjNullFlag(boolean keieitaiKjNullFlag) {
		this.keieitaiKjNullFlag = keieitaiKjNullFlag;
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
