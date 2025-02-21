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
 * テーブル物理名 : m_rdm_hcp_shussinko
 * SQLID : selectNd001ShussinkoComboList
 * @generated
 */
public class SelectNd001ShusshinkoComboListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 武田出身大学コード
     * @generated
     */
    private String univCode;

    /**
     * 出身大学漢字名
     * @generated
     */
    private String univKj;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNd001ShusshinkoComboListEntity() {
        super("m_rdm_hcp_shusshinko" , "selectNd001ShussinkoComboList");
    }

	/**
	 * SelectNd001ShussinkoComboListEntity.javaunivCodeを設定
	 * @return univCode
	 */
	public String getUnivCode() {
		return univCode;
	}

	/**
	 * @param univCode セットする univCode
	 */
	public void setUnivCode(String univCode) {
		this.univCode = univCode;
	}

	/**
	 * SelectNd001ShussinkoComboListEntity.javaunivKjを設定
	 * @return univKj
	 */
	public String getUnivKj() {
		return univKj;
	}

	/**
	 * @param univKj セットする univKj
	 */
	public void setUnivKj(String univKj) {
		this.univKj = univKj;
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
