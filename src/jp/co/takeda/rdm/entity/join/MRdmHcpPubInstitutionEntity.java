/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_HCP_PUB_INSTITUTION
 * テーブル論理名 : 医師_公的機関マスタ
 * @generated
 */
public class MRdmHcpPubInstitutionEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 公的機関コード
     * @generated
     */
    private String pubInstitutionCd;
    private boolean pubInstitutionCdNullFlag;

    /**
     * 公的機関名
     * @generated
     */
    private String pubInstitutionNm;
    private boolean pubInstitutionNmNullFlag;

    /**
     * 並び順
     * @generated
     */
    private Integer sortNum;
    private boolean sortNumNullFlag;

    /**
     * 削除フラグ
     * @generated
     */
    private Integer delFlg;
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
    public MRdmHcpPubInstitutionEntity() {
        super("m_rdm_hcp_pub_institution");
    }





	/**
	 * MRdmHcpPubInstitutionEntity.javapubInstitutionCdを設定
	 * @return pubInstitutionCd
	 */
	public String getPubInstitutionCd() {
		return pubInstitutionCd;
	}





	/**
	 * @param pubInstitutionCd セットする pubInstitutionCd
	 */
	public void setPubInstitutionCd(String pubInstitutionCd) {
		this.pubInstitutionCd = pubInstitutionCd;
	}





	/**
	 * MRdmHcpPubInstitutionEntity.javapubInstitutionCdNullFlagを設定
	 * @return pubInstitutionCdNullFlag
	 */
	public boolean isPubInstitutionCdNullFlag() {
		return pubInstitutionCdNullFlag;
	}





	/**
	 * @param pubInstitutionCdNullFlag セットする pubInstitutionCdNullFlag
	 */
	public void setPubInstitutionCdNullFlag(boolean pubInstitutionCdNullFlag) {
		this.pubInstitutionCdNullFlag = pubInstitutionCdNullFlag;
	}





	/**
	 * MRdmHcpPubInstitutionEntity.javapubInstitutionNmを設定
	 * @return pubInstitutionNm
	 */
	public String getPubInstitutionNm() {
		return pubInstitutionNm;
	}





	/**
	 * @param pubInstitutionNm セットする pubInstitutionNm
	 */
	public void setPubInstitutionNm(String pubInstitutionNm) {
		this.pubInstitutionNm = pubInstitutionNm;
	}





	/**
	 * MRdmHcpPubInstitutionEntity.javapubInstitutionNmNullFlagを設定
	 * @return pubInstitutionNmNullFlag
	 */
	public boolean isPubInstitutionNmNullFlag() {
		return pubInstitutionNmNullFlag;
	}





	/**
	 * @param pubInstitutionNmNullFlag セットする pubInstitutionNmNullFlag
	 */
	public void setPubInstitutionNmNullFlag(boolean pubInstitutionNmNullFlag) {
		this.pubInstitutionNmNullFlag = pubInstitutionNmNullFlag;
	}





	/**
	 * sortNumを設定
	 * @return sortNum
	 */
	public Integer getSortNum() {
		return sortNum;
	}



	/**
	 * @param sortNum セットする sortNum
	 */
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}



	/**
	 * sortNumNullFlagを設定
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
	 * delFlgを設定
	 * @return delFlg
	 */
	public Integer getDelFlg() {
		return delFlg;
	}



	/**
	 * @param delFlg セットする delFlg
	 */
	public void setDelFlg(Integer delFlg) {
		this.delFlg = delFlg;
	}



	/**
	 * delFlgNullFlagを設定
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
	 * insShaYmdを設定
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
	 * insShaYmdNullFlagを設定
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
	 * insShaIdを設定
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
	 * insShaIdNullFlagを設定
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
	 * updShaYmdを設定
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
	 * updShaYmdNullFlagを設定
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
	 * updShaIdを設定
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
	 * updShaIdNullFlagを設定
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
