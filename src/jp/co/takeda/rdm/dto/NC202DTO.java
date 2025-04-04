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
public class NC202DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NC202 = "NC202";

    /**
     * パラメタ選択区分
     * @generated
     */
    private String selectFlgPop;

    /**
     * パラメタ部門ランク
     * @generated
     */
    private Integer bumonRankPop;

    /**
     * パラメタ上位組織コード
     * @generated
     */
    private String sosCdPop;

    /**
     * パラメタ領域コード
     * @generated
     */
    private String upSosCdPop;

    /**
     * パラメタ領域コード
     * @generated
     */
    private String trtCdPop;

    /**
     * JIS府県コード
     * @generated
     */
    private String addrCodePrefPop;

    /**
     * パラメタ武田市区町村コード
     * @generated
     */
    private String tkCityCdPop;

    /**
     * 従業員表示フラグ
     * @generated
     */
    private Integer jgiFlg;

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
    private String jgiName;

    /**
     * @generated
     */
    private String bumonSeiName;


    /**
     * @generated
     */
    private List<JgiInitData> jgiInitData = new ArrayList<JgiInitData>();

    /**
     * @generated
     */
    private List<JgiData> jgiData = new ArrayList<JgiData>();

    /**
     * @generated
     */
    private List<JgiJgiData> jgiJgiData = new ArrayList<JgiJgiData>();
	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC202DTO() {
        setForward(NC202);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNC202(String screenID){
        this.NC202 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNC202(){
        return NC202;
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
     * パラメタ上位組織コードの取得
     * @return パラメタ上位組織コード
     * @generated
     */
    public String getUpSosCdPop() {
        return upSosCdPop;
    }

    /**
     * パラメタ上位組織コードの設定
     * @param upSosCdPop パラメタ上位組織コード
     * @generated
     */
    public void setUpSosCdPop(String upSosCdPop) {
        this.upSosCdPop = upSosCdPop;
    }

    /**
     * パラメタ領域コードの取得
     * @return パラメタ組織コード
     * @generated
     */
    public String getTrtCdPop() {
        return trtCdPop;
    }

    /**
     * パラメタ領域コードの設定
     * @param trtCdPop パラメタ領域コード
     * @generated
     */
    public void setTrtCdPop(String trtCdPop) {
        this.trtCdPop = trtCdPop;
    }

    /**
     * パラメタJIS府県コードの取得
     * @return パラメタJIS府県コード
     * @generated
     */
    public String getAddrCodePrefPop() {
        return addrCodePrefPop;
    }

    /**
     * パラメタJIS府県コードの設定
     * @param addrCodePrefPop パラメタJIS府県コード
     * @generated
     */
    public void setAddrCodePrefPop(String addrCodePrefPop) {
        this.addrCodePrefPop = addrCodePrefPop;
    }

    /**
     * パラメタ武田市区町村コードの取得
     * @return パラメタ武田市区町村コード
     * @generated
     */
    public String getTkCityCdPop() {
        return tkCityCdPop;
    }

    /**
     * パラメタ武田市区町村コードの設定
     * @param tkCityCdPop パラメタ武田市区町村コード
     * @generated
     */
    public void setTkCityCdPop(String tkCityCdPop) {
        this.tkCityCdPop = tkCityCdPop;
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
     * 氏名の取得
     * @return 氏名
     * @generated
     */
	public String getJgiName() {
		return jgiName;
	}

    /**
     * 氏名の設定
     * @param jgiName 氏名
     * @generated
     */
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

    /**
     * 部門名正式の取得
     * @return 部門名正式
     * @generated
     */
	public String getBumonSeiName() {
		return bumonSeiName;
	}

    /**
     * 部門名正式の設定
     * @param bumonSeiName 部門名正式
     * @generated
     */
	public void setBumonSeiName(String bumonSeiName) {
		this.bumonSeiName = bumonSeiName;
	}


    /**
     * 部門名正式の取得
     * @return 部門名正式
     * @generated
     */
	public Integer getJgiFlg() {
		return jgiFlg;
	}

    /**
     * 部門名正式の設定
     * @param bumonSeiName 部門名正式
     * @generated
     */
	public void setJgiFlg(Integer jgiFlg) {
		this.jgiFlg = jgiFlg;
	}



    /**
	 * 繰返リストの取得
	 * @return 繰返リスト
	 * @generated
	 */
	public List<JgiInitData> getJgiInitData() {
		return jgiInitData;
	}

	/**
	 * 繰返リストの設定
	　* @param jgiInitData 繰返リスト
	 *　@generated
	 */
	public void setJgiInitData(List<JgiInitData> jgiInitData) {
		this.jgiInitData = jgiInitData;
	}

    /**
	 * 繰返リストの取得
	 * @return 繰返リスト
	 * @generated
	 */
	public List<JgiData> getJgiData() {
		return jgiData;
	}

	/**
	 * 繰返リストの設定
	　* @param sosInitSosData 繰返リスト
	 *　@generated
	 */
	public void setJgiData(List<JgiData> jgiData) {
		this.jgiData = jgiData;
	}

    /**
	 * NC202DTO.javajgiJgiDataを設定
	 * @return jgiJgiData
	 */
	public List<JgiJgiData> getJgiJgiData() {
		return jgiJgiData;
	}

	/**
	 * @param jgiJgiData セットする jgiJgiData
	 */
	public void setJgiJgiData(List<JgiJgiData> jgiJgiData) {
		this.jgiJgiData = jgiJgiData;
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