/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;
import jxl.write.DateTime;


/**
 * 結合Entityクラス
 * テーブル物理名 :
 * SQLID : selectHcoUpdHstList
 * @generated
 */
public class SelectHenkanListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 変換系_区分
     */
    private String henkanType;

    /**
     * 変換系_値
     */
    private String searchHenkan;

    /**
	 * SelectHenkanListEntity.javasearchHenkanを設定
	 * @return searchHenkan
	 */
	public String getSearchHenkan() {
		return searchHenkan;
	}

	/**
	 * @param searchHenkan セットする searchHenkan
	 */
	public void setSearchHenkan(String searchHenkan) {
		this.searchHenkan = searchHenkan;
	}

    /**
     * コンストラクタ
     * @generated
     */
    public SelectHenkanListEntity() {
        super("", "");
    }

    /**
     * コンストラクタ_変換系
     * @generated
     */
    public SelectHenkanListEntity(String henkanType) {
        super("m_rdm_henkan" , "selectHenkan");
        this.henkanType = henkanType;
    }

    public String getHenkanType() {
		return henkanType;
	}

	public void setHenkanType(String henkanType) {
		this.henkanType = henkanType;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
