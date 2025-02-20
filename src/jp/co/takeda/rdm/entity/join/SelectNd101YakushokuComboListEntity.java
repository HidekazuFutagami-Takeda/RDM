/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : m_rdm_hcp_yakushoku
 * SQLID : selectNd101YakushokuComboList
 * @generated
 */
public class SelectNd101YakushokuComboListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_データ区分 (パラメータ)
     * @generated
     */
    private String inDataKbn;

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
     * コンストラクタ
     * @generated
     */
    public SelectNd101YakushokuComboListEntity() {
		super("m_rdm_hcp_yakushoku" , "selectNd101YakushokuComboList");
    }

	/**
	 * SelectNd101YakushokuComboListEntity.javainDataKbnを設定
	 * @return inDataKbn
	 */
	public String getInDataKbn() {
		return inDataKbn;
	}

	/**
	 * @param inDataKbn セットする inDataKbn
	 */
	public void setInDataKbn(String inDataKbn) {
		this.inDataKbn = inDataKbn;
	}

	/**
	 * SelectNd101YakushokuComboListEntity.javatitleCodeを設定
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
	 * SelectNd101YakushokuComboListEntity.javatitleKjを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
