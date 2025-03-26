/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseDTO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * DTOクラス
 * @generated
 */
public class NC201DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NC201 = "NC201";

    /**
     * パラメタ選択区分
     * @generated
     */
    private String selectFlgPop;

    /**
     * パラメタ初期表示組織
     * @generated
     */
    private String initSosCdPop;

    /**
     * パラメタ組織コード
     * @generated
     */
    private String sosCdPop;

    /**
     * パラメタ部門ランク
     * @generated
     */
    private Integer bumonRankPop;

    /**
     * パラメタ領域コード
     * @generated
     */
    private String trtCdPop;

	/**
     * 親画面コールバックメソッド名
     * @generated
     */
    private String callBack;

	/**
     * 親画面名
     * @generated
     */
    private String winVarName;

	/**
     * 呼び出し元のClear処理メソッド名
     * @generated
     */
    private String parentClearProc;

    /**
     * @generated
     */
    private List<SosInitData> sosInitData = new ArrayList<SosInitData>();

    /**
     * @generated
     */
    private List<SosData> sosData = new ArrayList<SosData>();

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC201DTO() {
        setForward(NC201);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNC201(String screenID){
        this.NC201 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNC201(){
        return NC201;
    }

    /**
     * パラメタ選択区分の取得
     * @return パラメタ選択区分
     * @generated
     */
    public String getSelectFlgPop() {
        return selectFlgPop;
    }

    /**
     * パラメタ選択区分の設定
     * @param selectFlgPop パラメタ選択区分
     * @generated
     */
    public void setSelectFlgPop(String selectFlgPop) {
        this.selectFlgPop = selectFlgPop;
    }

    /**
     * パラメタ初期表示組織の取得
     * @return パラメタ初期表示組織
     * @generated
     */
    public String getInitSosCdPop() {
        return initSosCdPop;
    }

    /**
     * パラメタ初期表示組織の設定
     * @param initSosCdPop パラメタ初期表示組織
     * @generated
     */
    public void setInitSosCdPop(String initSosCdPop) {
        this.initSosCdPop = initSosCdPop;
    }

    /**
     * パラメタ組織コードの取得
     * @return パラメタ組織コード
     * @generated
     */
    public String getSosCdPop() {
        return sosCdPop;
    }

    /**
     * パラメタ組織コードの設定
     * @param sosCdPop パラメタ組織コード
     * @generated
     */
    public void setSosCdPop(String sosCdPop) {
        this.sosCdPop = sosCdPop;
    }

    /**
     * パラメタ部門ランクの取得
     * @return パラメタ部門ランク
     * @generated
     */
    public String getTrtCdPop() {
        return trtCdPop;
    }

    /**
     * パラメタ部門ランクの設定
     * @param trtCdPop パラメタ部門ランク
     * @generated
     */
    public void setTrtCdPop(String trtCdPop) {
        this.trtCdPop = trtCdPop;
    }

    /**
     * パラメタ領域コードの取得
     * @return パラメタ領域コード
     * @generated
     */
    public Integer getBumonRankPop() {
        return bumonRankPop;
    }

    /**
     * パラメタ領域コードの設定
     * @param bumonRankPop パラメタ領域コード
     * @generated
     */
    public void setBumonRankPop(Integer bumonRankPop) {
        this.bumonRankPop = bumonRankPop;
    }


	/**
     * 親画面コールバックメソッド名の取得
     * @return 親画面コールバックメソッド名
     * @generated
     */
    public String getCallBack() {
        return callBack;
    }

	/**
     * 親画面コールバックメソッド名の設定
     * @param callBack 親画面コールバックメソッド名
     * @generated
     */
    public void setCallBack(String callBack) {
        this.callBack = callBack;
    }

	/**
     * 親画面名の取得
     * @return 親画面名
     * @generated
     */
    public String getWinVarName() {
        return winVarName;
    }

	/**
     * 親画面名の設定
     * @param winVarName 親画面名
     * @generated
     */
    public void setWinVarName(String winVarName) {
        this.winVarName = winVarName;
    }

	/**
     * 呼び出し元のClear処理メソッド名の取得
     * @return 呼び出し元のClear処理メソッド名
     * @generated
     */
    public String getParentClearProc() {
        return parentClearProc;
    }

	/**
     * 呼び出し元のClear処理メソッド名の設定
     * @param parentClearProc 呼び出し元のClear処理メソッド名
     * @generated
     */
    public void setParentClearProc(String parentClearProc) {
        this.parentClearProc = parentClearProc;
    }

    /**
	 * 繰返リストの取得
	 * @return 繰返リスト
	 * @generated
	 */
	public List<SosInitData> getSosInitData() {
		return sosInitData;
	}

	/**
	 * 繰返リストの設定
	　* @param sosInitSosData 繰返リスト
	 *　@generated
	 */
	public void setSosInitData(List<SosInitData> sosInitData) {
		this.sosInitData = sosInitData;
	}

    /**
	 * 繰返リストの取得
	 * @return 繰返リスト
	 * @generated
	 */
	public List<SosData> getSosData() {
		return sosData;
	}

	/**
	 * 繰返リストの設定
	　* @param sosInitSosData 繰返リスト
	 *　@generated
	 */
	public void setSosData(List<SosData> sosData) {
		this.sosData = sosData;
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
