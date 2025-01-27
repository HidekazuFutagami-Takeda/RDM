/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.dto;

import java.io.Serializable;

import jp.co.takeda.jkr.common.BaseDTO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス
 * @generated
 */
public class JKR999C010DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String JKR999C010 = "JKR999C010";

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public JKR999C010DTO() {
        setForward(JKR999C010);
    }

    // START UOC
    
    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setJKR999C010(String screenID){
        this.JKR999C010 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getJKR999C010(){
        return JKR999C010;
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
