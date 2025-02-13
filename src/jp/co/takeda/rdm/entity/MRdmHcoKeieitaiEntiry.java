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
     * 並び順
     * @generated
     */
    private String sortNum;
    private boolean sortNumNullFlag;

    /**
     * 国公立区分
     * @generated
     */
    private String natlPubKbn;
    private boolean natlPubKbnNullFlag;

    /**
     * 削除フラグ
     * @generated
     */
    private String delFlg;
    private boolean delFlgNullFlag;

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
    public MRdmHcoKeieitaiEntiry() {
        super("m_rdm_hco_keieitai", "selectMRdmHcoKeieitaiEntiry");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public MRdmHcoKeieitaiEntiry(String sqlId) {
        super("m_rdm_hco_keieitai", sqlId);
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
	 * MRdmHcoKeieitaiEntiry.javasortNumを設定
	 * @return sortNum
	 */
	public String getSortNum() {
		return sortNum;
	}


	/**
	 * @param sortNum セットする sortNum
	 */
	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}


	/**
	 * MRdmHcoKeieitaiEntiry.javasortNumNullFlagを設定
	 * @return sortNumNullFlag
	 */
	public boolean isSortNumNullFlag() {
		return sortNumNullFlag;
	}


	/**
	 * @param sortNumNullFlag セットする sortNumNullFlag
	 */
	public void setSortNumNullFlag(boolean sortNumNullFlag) {
		this.sortNumNullFlag = sortNumNullFlag;
	}


	/**
	 * MRdmHcoKeieitaiEntiry.javanatlPubKbnを設定
	 * @return natlPubKbn
	 */
	public String getNatlPubKbn() {
		return natlPubKbn;
	}


	/**
	 * @param natlPubKbn セットする natlPubKbn
	 */
	public void setNatlPubKbn(String natlPubKbn) {
		this.natlPubKbn = natlPubKbn;
	}


	/**
	 * MRdmHcoKeieitaiEntiry.javanatlPubKbnNullFlagを設定
	 * @return natlPubKbnNullFlag
	 */
	public boolean isNatlPubKbnNullFlag() {
		return natlPubKbnNullFlag;
	}


	/**
	 * @param natlPubKbnNullFlag セットする natlPubKbnNullFlag
	 */
	public void setNatlPubKbnNullFlag(boolean natlPubKbnNullFlag) {
		this.natlPubKbnNullFlag = natlPubKbnNullFlag;
	}


	/**
	 * MRdmHcoKeieitaiEntiry.javadelFlgを設定
	 * @return delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}


	/**
	 * @param delFlg セットする delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}


	/**
	 * MRdmHcoKeieitaiEntiry.javadelFlgNullFlagを設定
	 * @return delFlgNullFlag
	 */
	public boolean isDelFlgNullFlag() {
		return delFlgNullFlag;
	}


	/**
	 * @param delFlgNullFlag セットする delFlgNullFlag
	 */
	public void setDelFlgNullFlag(boolean delFlgNullFlag) {
		this.delFlgNullFlag = delFlgNullFlag;
	}


	/**
	 * MRdmHcoKeieitaiEntiry.javainsShaYmdを設定
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
	 * MRdmHcoKeieitaiEntiry.javainsShaYmdNullFlagを設定
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
	 * MRdmHcoKeieitaiEntiry.javainsShaIdを設定
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
	 * MRdmHcoKeieitaiEntiry.javainsShaIdNullFlagを設定
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
	 * MRdmHcoKeieitaiEntiry.javaupdShaYmdを設定
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
	 * MRdmHcoKeieitaiEntiry.javaupdShaYmdNullFlagを設定
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
	 * MRdmHcoKeieitaiEntiry.javaupdShaIdを設定
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
	 * MRdmHcoKeieitaiEntiry.javaupdShaIdNullFlagを設定
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
