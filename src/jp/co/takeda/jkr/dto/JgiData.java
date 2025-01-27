/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス
 * @generated
 */
public class JgiData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 担当者名
     * @generated
     */
    private String jgiName;

    /**
     * 担当者所属名
     * @generated
     */
    private String shokushuName;

    /**
     * コンストラクタ
     * @customizable
     */
    public JgiData() {
        // START UOC

        // END UOC
    }

    // START UOC
    
    // END UOC

     /**
     * 担当者名の取得
     * @return 担当者名
     * @generated
     */
    public String getJgiName() {
        return jgiName;
    }

    /**
     * 担当者名の設定
     * @param jgiName 担当者名
     * @generated
     */
    public void setJgiName(String jgiName) {
        this.jgiName = jgiName;
    }

     /**
     * 担当者所属名の取得
     * @return 担当者所属名
     * @generated
     */
    public String getShokushuName() {
        return shokushuName;
    }

    /**
     * 担当者所属名の設定
     * @param shokushuName 担当者所属名
     * @generated
     */
    public void setShokushuName(String shokushuName) {
        this.shokushuName = shokushuName;
    }

    /**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

