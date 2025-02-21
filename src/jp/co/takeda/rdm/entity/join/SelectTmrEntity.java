/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;
import java.util.Date;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_COM_CAL_USR
 * SQLID :
 * @generated
 */
public class SelectTmrEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 年月日（翌日）
     * @generated
     */
    private Date calDate;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectTmrEntity() {
		super("m_rdm_com_cal_usr" , "selectTmr");
    }


	/**
	 * SelectTmrEntity.javacalDateを設定
	 * @return calDate
	 */
	public Date getCalDate() {
		return calDate;
	}


	/**
	 * @param calDate セットする calDate
	 */
	public void setCalDate(Date calDate) {
		this.calDate = calDate;
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
