/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

/**
 * Entityクラス
 * テーブル物理名 : M_RDM_HCP_YAKUSHOKU
 * テーブル論理名 : 医師_役職マスタ
 * @generated
 */
public class MRdmHcpYakusyokuEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 武田役職コード
     * @generated
     */
    private String titleCode;

    /**
     * 役職漢字名
     * @generated
     */
    private String titleKj;

    /**
     * 役職カナ名
     * @generated
     */
    private String titleKn;

    /**
     * 大学職位利用フラグ
     * @generated
     */
    private String univTitleFlg;

    /**
     * 並び順
     * @generated
     */
    private String sortNum;

    /**
     * 削除フラグ
     * @generated
     */
    private String delFlg;

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
     * コンストラクタ
     * @generated
     */
    public MRdmHcpYakusyokuEntity() {
        super("m_rdm_hcp-yakusyoku", "selectYakusyoku");
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



	/**
	 * MRdmHcpYakusyokuEntity.javatitleCodeを設定
	 * @return titleCode
	 */
	public String getTitleCode() {
		return titleCode;
	}



	/**
	 * @param titleCode セットする titleCode
	 */
	public void setTitleCode(String titleCode) {
		this.titleCode = titleCode;
	}



	/**
	 * MRdmHcpYakusyokuEntity.javatitleKjを設定
	 * @return titleKj
	 */
	public String getTitleKj() {
		return titleKj;
	}



	/**
	 * @param titleKj セットする titleKj
	 */
	public void setTitleKj(String titleKj) {
		this.titleKj = titleKj;
	}



	/**
	 * MRdmHcpYakusyokuEntity.javatitleKnを設定
	 * @return titleKn
	 */
	public String getTitleKn() {
		return titleKn;
	}



	/**
	 * @param titleKn セットする titleKn
	 */
	public void setTitleKn(String titleKn) {
		this.titleKn = titleKn;
	}



	/**
	 * MRdmHcpYakusyokuEntity.javaunivTitleFlgを設定
	 * @return univTitleFlg
	 */
	public String getUnivTitleFlg() {
		return univTitleFlg;
	}



	/**
	 * @param univTitleFlg セットする univTitleFlg
	 */
	public void setUnivTitleFlg(String univTitleFlg) {
		this.univTitleFlg = univTitleFlg;
	}



	/**
	 * MRdmHcpYakusyokuEntity.javasortNumを設定
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
	 * MRdmHcpYakusyokuEntity.javadelFlgを設定
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
	 * MRdmHcpYakusyokuEntity.javainsShaYmdを設定
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
	 * MRdmHcpYakusyokuEntity.javainsShaIdを設定
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
	 * MRdmHcpYakusyokuEntity.javaupdShaYmdを設定
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
	 * MRdmHcpYakusyokuEntity.javaupdShaIdを設定
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
	 * MRdmHcpYakusyokuEntity.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
