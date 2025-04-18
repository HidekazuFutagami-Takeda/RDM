/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseDTO;

/**
 * DTOクラス
 * @generated
 */
public class NF501DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NF501 = "NF501";

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
     * ポップアップ用判別
     * @generated
     */
    private String loginJokenSetCd;

    /**
     * 権限_条件セット
     * @generated
     */
    private String jokenSetCd;

    /**
     * 画面名
     * @generated
     */
    private String title;

    /**
	 * エラーメッセージ中身
	 * @generated
	 */
	private String msgStr;

    /**
     * ページ送り
     * @generated
     */
    private Integer pageCntCur;


    /**
     * イベントID
     * @generated
     */
    private String functionId;

    /**
     * 親画面施設固定コード
     * @generated
     */
    private String paramInsNo;

    /**
     * ソートID
     * @generated
     */
    private int sortId;


    /**
     * 検索区分
     * @generated
     */
    private String searchType;

    /**
     * 検索結果切り替えリスト
     * 施設一覧・領域別担当者
     * @generated
     */
    private String selectListChange;

    /**
     * 検索成功・失敗判定
     * @generated
     */
    private boolean kensakuBool;

    /**
     * 検索条件_従業員番号(管理者)
     * @generated
     */
    private int kensakuJgiNo;

    /**
     * 検索条件_申請者組織コード
     * @generated
     */
    private String kensakuShinseiSosCd;

    /**
     * 検索条件_申請者組織名
     * @generated
     */
    private String reqSosName;

    /**
     * 検索条件_申請者部門ランク
     * @generated
     */
    private String kensakuShinseiBumonRank;

    /**
     * 検索条件_医薬支店C_申請者所属リージョン(管理者)
     * @generated
     */
    private String kensakuShinseiBrCode;

    /**
     * 検索条件_医薬営業所C_申請者所属エリア(管理者)
     * @generated
     */
    private String kensakuShinseiDistCode;

    /**
     * 検索条件_担当者組織コード
     * @generated
     */
    private String tantoSosCd;

    /**
     * 検索条件_担当者組織名
     * @generated
     */
    private String tantoSosName;

    /**
     * 検索条件_担当者上位組織コード
     * @generated
     */
    private String tantoUpSosCd;

    /**
     * 検索条件_担当者組織部門ランク
     * @generated
     */
    private String tantoBumonRank;

    /**
     * 検索条件_医薬支店C_担当者所属リージョン(管理者)
     * @generated
     */
    private String kensakuSTantouBrCode;

    /**
     * 検索条件_医薬営業所C_担当者所属エリア(管理者)
     * @generated
     */
    private String kensakuTantouDistCode;

    /**
     * 検索条件_申請者(管理者)
     * @generated
     */
    private String kensakuReqJgiName;

    /**
     * 従業員番号(MR)
     * @generated
     */
    private int mrJgiNo;

    /**
     * 医薬支店C_申請者所属リージョン(MR)
     * @generated
     */
    private String mrBrCode;

    /**
     * 医薬営業所C_申請者所属エリア(MR)
     * @generated
     */
    private String mrDistCode;

    /**
     * 領域コード(MR)
     * @generated
     */
    private String mrTrtCd;


    /**
     * 検索条件_施設名（全角）
     * @generated
     */
    private String kensakuInsKanj;

    /**
     * 検索条件_施設名カナ(半角カナ)
     * @generated
     */
    private String kensakuInsKana;

    /**
     * 検索条件_施設固定C
     * @generated
     */
    private String kensakuInsNo;

    /**
     * 検索条件_領域コード
     * @generated
     */
    private String kensakuTrtCd;

    /**
     * 検索条件_ULTコード
     * @generated
     */
    private String kensakuUltInsNo;

    /**
     * 検索条件_経営主体
     * @generated
     */
    private String kensakuManageCd;

    /**
     * 検索条件_対象区分
     * @generated
     */
    private String kensakuHoInsType;

    /**
     * 検索条件_施設種別
     * @generated
     */
    private String kensakuInsSbt;

    /**
     * 検索条件_施設区分
     * @generated
     */
    private String kensakuPharmType;

    /**検索条件_電話番号(半角)
     * @generated
     */
    private String kensakuInsPhone;

    /**
     * 検索条件_郵便番号(半角)
     * @generated
     */
    private String kensakuInsPcode;

    /**
     * 検索条件_都道府県
     * @generated
     */
    private String kensakuAddrCodePref;

    /**
     * 検索条件_JIS市区町村
     * @generated
     */
    private String kensakuAddrCodeCity;

    /**
     * 検索条件_住所(全角)
     * @generated
     */
    private String kensakuInsAddr;



    /**
     * 検索条件_更新日(開始日)
     * @generated
     */
    private String kensakuUpdMstFrom;

    /**
     * 初期値_更新日(終了日)
     * @generated
     */
    private String kensakuUpdMstTo;

    /**
     * 設定値_更新日(開始日)
     * @generated
     */
    private String updMstFrom;

    /**
     * 設定値_更新日(終了日)
     * @generated
     */
    private String updMstTo;

    /**
     * クリア_更新日(開始日)
     * @generated
     */
    private String clearUpdMstFrom;

    /**
     * クリア_更新日(終了日)
     * @generated
     */
    private String clearUpdMstTo;


//    /**
//     * @経営主体
//     */
//    private List<HcoKeieitaiDataList> hcoKeieitaiList = new ArrayList<HcoKeieitaiDataList>();

    /**
    * @市区町村リスト
    */
    private List<JkrCityNameDataList> jkrCityNameDataList = new ArrayList<JkrCityNameDataList>();

    /**
     * @経営主体_ドロップダウンリスト
     */
    private String hcoKeieitaiCd;
	private LinkedHashMap<String,String> hcoKeieitaiMap = new LinkedHashMap<String,String>();

    /**
     * @施設一覧リスト
     */
    private List<HcoUpdHstDataList> hcoUpdHstDataList = new ArrayList<HcoUpdHstDataList>();

    /**
     * @領域別担当者リスト
     */
    private List<MainInsDataList> mainInsDataList = new ArrayList<MainInsDataList>();

    /**
     * @施設区分_ドロップダウンリスト
     */
    private String pharmTypeCd;
	private LinkedHashMap<String,String> pharmTypeMap = new LinkedHashMap<String,String>();

	/**
     * @階級区分_ドロップダウンリスト
     */
    private String InsRankCd;
	private LinkedHashMap<String,String> insRankMap = new LinkedHashMap<String,String>();

    /**
     * @対象区分_ドロップダウンリスト
     */
	private String hoInsTypeCd;
	private LinkedHashMap<String,String> hoInsTypeMap = new LinkedHashMap<String,String>();


    /**
     * @施設種別_ドロップダウンリスト
     */
	private String insTypeCd;
	private LinkedHashMap<String,String> insSbtMap = new LinkedHashMap<String,String>();

    /**
     * @都道府県_組織担当地区情報_ドロップダウンリスト
     */
	private String jkrSosAddrCd;
	private LinkedHashMap<String,String> jkrSosAddrMap = new LinkedHashMap<String,String>();

    /**
     * @市区町村_組織担当地区情報_ドロップダウンリスト
     */
	private String jkrCityNameCd;
	private LinkedHashMap<String,String> jkrCityNameMap = new LinkedHashMap<String,String>();

	/**
     * @検索結果切り替えリスト_ドロップダウンリスト
     */
	private String selectListChangeCd;
	private LinkedHashMap<String,String> selectListChangeMap = new LinkedHashMap<String,String>();



    public int getSortId() {
		return sortId;
	}


	/**
	 * NF501DTO.javapageCntCurを設定
	 * @return pageCntCur
	 */
	public Integer getPageCntCur() {
		return pageCntCur;
	}

	/**
	 * @param pageCntCur セットする pageCntCur
	 */
	public void setPageCntCur(Integer pageCntCur) {
		this.pageCntCur = pageCntCur;
	}

	/**
	 * NF501DTO.javamsgStrを設定
	 * @return msgStr
	 */
	public String getMsgStr() {
		return msgStr;
	}

	/**
	 * @param msgStr セットする msgStr
	 */
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	/**
	 * NF501DTO.javaInsRankCdを設定
	 * @return insRankCd
	 */
	public String getInsRankCd() {
		return InsRankCd;
	}

	/**
	 * @param insRankCd セットする insRankCd
	 */
	public void setInsRankCd(String insRankCd) {
		InsRankCd = insRankCd;
	}

	/**
	 * NF501DTO.javaselectListChangeCdを設定
	 * @return selectListChangeCd
	 */
	public String getSelectListChangeCd() {
		return selectListChangeCd;
	}

	/**
	 * @param selectListChangeCd セットする selectListChangeCd
	 */
	public void setSelectListChangeCd(String selectListChangeCd) {
		this.selectListChangeCd = selectListChangeCd;
	}

	/**
	 * NF501DTO.javaselectListChangeMapを設定
	 * @return selectListChangeMap
	 */
	public LinkedHashMap<String, String> getSelectListChangeMap() {
		return selectListChangeMap;
	}

	/**
	 * @param selectListChangeMap セットする selectListChangeMap
	 */
	public void setSelectListChangeMap(LinkedHashMap<String, String> selectListChangeMap) {
		this.selectListChangeMap = selectListChangeMap;
	}

	/**
	 * NF501DTO.javainsRankMapを設定
	 * @return insRankMap
	 */
	public LinkedHashMap<String, String> getInsRankMap() {
		return insRankMap;
	}

	/**
	 * @param insRankMap セットする insRankMap
	 */
	public void setInsRankMap(LinkedHashMap<String, String> insRankMap) {
		this.insRankMap = insRankMap;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NF501DTO() {
        setForward(NF501);
    }

    // START UOC

    // END UOC

    /**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



	/**
	 * NF501DTO.javakensakuBoolを設定
	 * @return kensakuBool
	 */
	public boolean isKensakuBool() {
		return kensakuBool;
	}

	/**
	 * @param kensakuBool セットする kensakuBool
	 */
	public void setKensakuBool(boolean kensakuBool) {
		this.kensakuBool = kensakuBool;
	}


	/**
	 * NF501DTO.javakensakupharmTypeを設定
	 * @return kensakupharmType
	 */
	public String getKensakuPharmType() {
		return kensakuPharmType;
	}

	/**
	 * @param kensakupharmType セットする kensakupharmType
	 */
	public void setKensakuPharmType(String kensakuPharmType) {
		this.kensakuPharmType = kensakuPharmType;
	}

	public void setKensakuReqJgiName(String kensakuReqJgiName) {
		this.kensakuReqJgiName = kensakuReqJgiName;
	}


	public void setKensakuUpdMstTo(String kensakuUpdMstTo) {
		this.kensakuUpdMstTo = kensakuUpdMstTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * NF501DTO.javaNF501を設定
	 * @return nF501
	 */
	public String getNF501() {
		return NF501;
	}


	/**
	 * @param nF501 セットする nF501
	 */
	public void setNF501(String nF501) {
		NF501 = nF501;
	}


	/**
	 * NF501DTO.javacallBackを設定
	 * @return callBack
	 */
	public String getCallBack() {
		return callBack;
	}


	/**
	 * @param callBack セットする callBack
	 */
	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}


	/**
	 * NF501DTO.javawinVarNameを設定
	 * @return winVarName
	 */
	public String getWinVarName() {
		return winVarName;
	}


	/**
	 * @param winVarName セットする winVarName
	 */
	public void setWinVarName(String winVarName) {
		this.winVarName = winVarName;
	}


	/**
	 * NF501DTO.javaloginJokenSetCdを設定
	 * @return loginJokenSetCd
	 */
	public String getLoginJokenSetCd() {
		return loginJokenSetCd;
	}


	/**
	 * @param loginJokenSetCd セットする loginJokenSetCd
	 */
	public void setLoginJokenSetCd(String loginJokenSetCd) {
		this.loginJokenSetCd = loginJokenSetCd;
	}


	/**
	 * NF501DTO.javajokenSetCdを設定
	 * @return jokenSetCd
	 */
	public String getJokenSetCd() {
		return jokenSetCd;
	}


	/**
	 * @param jokenSetCd セットする jokenSetCd
	 */
	public void setJokenSetCd(String jokenSetCd) {
		this.jokenSetCd = jokenSetCd;
	}


	/**
	 * NF501DTO.javafunctionIdを設定
	 * @return functionId
	 */
	public String getFunctionId() {
		return functionId;
	}


	/**
	 * @param functionId セットする functionId
	 */
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}


	/**
	 * NF501DTO.javaparamInsNoを設定
	 * @return paramInsNo
	 */
	public String getParamInsNo() {
		return paramInsNo;
	}


	/**
	 * @param paramInsNo セットする paramInsNo
	 */
	public void setParamInsNo(String paramInsNo) {
		this.paramInsNo = paramInsNo;
	}


	/**
	 * NF501DTO.javasearchTypeを設定
	 * @return searchType
	 */
	public String getSearchType() {
		return searchType;
	}


	/**
	 * @param searchType セットする searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	/**
	 * NF501DTO.javaselectListChangeを設定
	 * @return selectListChange
	 */
	public String getSelectListChange() {
		return selectListChange;
	}


	/**
	 * @param selectListChange セットする selectListChange
	 */
	public void setSelectListChange(String selectListChange) {
		this.selectListChange = selectListChange;
	}


	/**
	 * NF501DTO.javakensakuJgiNoを設定
	 * @return kensakuJgiNo
	 */
	public int getKensakuJgiNo() {
		return kensakuJgiNo;
	}


	/**
	 * @param kensakuJgiNo セットする kensakuJgiNo
	 */
	public void setKensakuJgiNo(int kensakuJgiNo) {
		this.kensakuJgiNo = kensakuJgiNo;
	}


	/**
	 * NF501DTO.javakensakuShinseiSosCdを設定
	 * @return kensakuShinseiSosCd
	 */
	public String getKensakuShinseiSosCd() {
		return kensakuShinseiSosCd;
	}


	/**
	 * @param kensakuShinseiSosCd セットする kensakuShinseiSosCd
	 */
	public void setKensakuShinseiSosCd(String kensakuShinseiSosCd) {
		this.kensakuShinseiSosCd = kensakuShinseiSosCd;
	}


	/**
	 * NF501DTO.javareqSosNameを設定
	 * @return reqSosName
	 */
	public String getReqSosName() {
		return reqSosName;
	}


	/**
	 * @param reqSosName セットする reqSosName
	 */
	public void setReqSosName(String reqSosName) {
		this.reqSosName = reqSosName;
	}


	/**
	 * NF501DTO.javakensakuShinseiBumonRankを設定
	 * @return kensakuShinseiBumonRank
	 */
	public String getKensakuShinseiBumonRank() {
		return kensakuShinseiBumonRank;
	}


	/**
	 * @param kensakuShinseiBumonRank セットする kensakuShinseiBumonRank
	 */
	public void setKensakuShinseiBumonRank(String kensakuShinseiBumonRank) {
		this.kensakuShinseiBumonRank = kensakuShinseiBumonRank;
	}


	/**
	 * NF501DTO.javakensakuShinseiBrCodeを設定
	 * @return kensakuShinseiBrCode
	 */
	public String getKensakuShinseiBrCode() {
		return kensakuShinseiBrCode;
	}


	/**
	 * @param kensakuShinseiBrCode セットする kensakuShinseiBrCode
	 */
	public void setKensakuShinseiBrCode(String kensakuShinseiBrCode) {
		this.kensakuShinseiBrCode = kensakuShinseiBrCode;
	}


	/**
	 * NF501DTO.javakensakuShinseiDistCodeを設定
	 * @return kensakuShinseiDistCode
	 */
	public String getKensakuShinseiDistCode() {
		return kensakuShinseiDistCode;
	}


	/**
	 * @param kensakuShinseiDistCode セットする kensakuShinseiDistCode
	 */
	public void setKensakuShinseiDistCode(String kensakuShinseiDistCode) {
		this.kensakuShinseiDistCode = kensakuShinseiDistCode;
	}


	/**
	 * NF501DTO.javatantoSosCdを設定
	 * @return tantoSosCd
	 */
	public String getTantoSosCd() {
		return tantoSosCd;
	}


	/**
	 * @param tantoSosCd セットする tantoSosCd
	 */
	public void setTantoSosCd(String tantoSosCd) {
		this.tantoSosCd = tantoSosCd;
	}


	/**
	 * NF501DTO.javatantoSosNameを設定
	 * @return tantoSosName
	 */
	public String getTantoSosName() {
		return tantoSosName;
	}


	/**
	 * @param tantoSosName セットする tantoSosName
	 */
	public void setTantoSosName(String tantoSosName) {
		this.tantoSosName = tantoSosName;
	}


	/**
	 * NF501DTO.javatantoUpSosCdを設定
	 * @return tantoUpSosCd
	 */
	public String getTantoUpSosCd() {
		return tantoUpSosCd;
	}


	/**
	 * @param tantoUpSosCd セットする tantoUpSosCd
	 */
	public void setTantoUpSosCd(String tantoUpSosCd) {
		this.tantoUpSosCd = tantoUpSosCd;
	}


	/**
	 * NF501DTO.javatantoBumonRankを設定
	 * @return tantoBumonRank
	 */
	public String getTantoBumonRank() {
		return tantoBumonRank;
	}


	/**
	 * @param tantoBumonRank セットする tantoBumonRank
	 */
	public void setTantoBumonRank(String tantoBumonRank) {
		this.tantoBumonRank = tantoBumonRank;
	}


	/**
	 * NF501DTO.javakensakuSTantouBrCodeを設定
	 * @return kensakuSTantouBrCode
	 */
	public String getKensakuSTantouBrCode() {
		return kensakuSTantouBrCode;
	}


	/**
	 * @param kensakuSTantouBrCode セットする kensakuSTantouBrCode
	 */
	public void setKensakuSTantouBrCode(String kensakuSTantouBrCode) {
		this.kensakuSTantouBrCode = kensakuSTantouBrCode;
	}


	/**
	 * NF501DTO.javakensakuTantouDistCodeを設定
	 * @return kensakuTantouDistCode
	 */
	public String getKensakuTantouDistCode() {
		return kensakuTantouDistCode;
	}


	/**
	 * @param kensakuTantouDistCode セットする kensakuTantouDistCode
	 */
	public void setKensakuTantouDistCode(String kensakuTantouDistCode) {
		this.kensakuTantouDistCode = kensakuTantouDistCode;
	}


	/**
	 * NF501DTO.javamrJgiNoを設定
	 * @return mrJgiNo
	 */
	public int getMrJgiNo() {
		return mrJgiNo;
	}


	/**
	 * @param mrJgiNo セットする mrJgiNo
	 */
	public void setMrJgiNo(int mrJgiNo) {
		this.mrJgiNo = mrJgiNo;
	}


	/**
	 * NF501DTO.javamrBrCodeを設定
	 * @return mrBrCode
	 */
	public String getMrBrCode() {
		return mrBrCode;
	}


	/**
	 * @param mrBrCode セットする mrBrCode
	 */
	public void setMrBrCode(String mrBrCode) {
		this.mrBrCode = mrBrCode;
	}


	/**
	 * NF501DTO.javamrDistCodeを設定
	 * @return mrDistCode
	 */
	public String getMrDistCode() {
		return mrDistCode;
	}


	/**
	 * @param mrDistCode セットする mrDistCode
	 */
	public void setMrDistCode(String mrDistCode) {
		this.mrDistCode = mrDistCode;
	}


	/**
	 * NF501DTO.javamrTrtCdを設定
	 * @return mrTrtCd
	 */
	public String getMrTrtCd() {
		return mrTrtCd;
	}


	/**
	 * @param mrTrtCd セットする mrTrtCd
	 */
	public void setMrTrtCd(String mrTrtCd) {
		this.mrTrtCd = mrTrtCd;
	}


	/**
	 * NF501DTO.javakensakuInsKanjを設定
	 * @return kensakuInsKanj
	 */
	public String getKensakuInsKanj() {
		return kensakuInsKanj;
	}


	/**
	 * @param kensakuInsKanj セットする kensakuInsKanj
	 */
	public void setKensakuInsKanj(String kensakuInsKanj) {
		this.kensakuInsKanj = kensakuInsKanj;
	}


	/**
	 * NF501DTO.javakensakuInsKanaを設定
	 * @return kensakuInsKana
	 */
	public String getKensakuInsKana() {
		return kensakuInsKana;
	}


	/**
	 * @param kensakuInsKana セットする kensakuInsKana
	 */
	public void setKensakuInsKana(String kensakuInsKana) {
		this.kensakuInsKana = kensakuInsKana;
	}


	/**
	 * NF501DTO.javakensakuInsNoを設定
	 * @return kensakuInsNo
	 */
	public String getKensakuInsNo() {
		return kensakuInsNo;
	}


	/**
	 * @param kensakuInsNo セットする kensakuInsNo
	 */
	public void setKensakuInsNo(String kensakuInsNo) {
		this.kensakuInsNo = kensakuInsNo;
	}


	/**
	 * NF501DTO.javakensakuTrtCdを設定
	 * @return kensakuTrtCd
	 */
	public String getKensakuTrtCd() {
		return kensakuTrtCd;
	}


	/**
	 * @param kensakuTrtCd セットする kensakuTrtCd
	 */
	public void setKensakuTrtCd(String kensakuTrtCd) {
		this.kensakuTrtCd = kensakuTrtCd;
	}


	/**
	 * NF501DTO.javakensakuUltInsNoを設定
	 * @return kensakuUltInsNo
	 */
	public String getKensakuUltInsNo() {
		return kensakuUltInsNo;
	}


	/**
	 * @param kensakuUltInsNo セットする kensakuUltInsNo
	 */
	public void setKensakuUltInsNo(String kensakuUltInsNo) {
		this.kensakuUltInsNo = kensakuUltInsNo;
	}


	/**
	 * NF501DTO.javakensakuManageCdを設定
	 * @return kensakuManageCd
	 */
	public String getKensakuManageCd() {
		return kensakuManageCd;
	}


	/**
	 * @param kensakuManageCd セットする kensakuManageCd
	 */
	public void setKensakuManageCd(String kensakuManageCd) {
		this.kensakuManageCd = kensakuManageCd;
	}


	/**
	 * NF501DTO.javakensakuHoInsTypeを設定
	 * @return kensakuHoInsType
	 */
	public String getKensakuHoInsType() {
		return kensakuHoInsType;
	}


	/**
	 * @param kensakuHoInsType セットする kensakuHoInsType
	 */
	public void setKensakuHoInsType(String kensakuHoInsType) {
		this.kensakuHoInsType = kensakuHoInsType;
	}


	/**
	 * NF501DTO.javakensakuInsSbtを設定
	 * @return kensakuInsSbt
	 */
	public String getKensakuInsSbt() {
		return kensakuInsSbt;
	}


	/**
	 * @param kensakuInsSbt セットする kensakuInsSbt
	 */
	public void setKensakuInsSbt(String kensakuInsSbt) {
		this.kensakuInsSbt = kensakuInsSbt;
	}


	/**
	 * NF501DTO.javakensakuInsPhoneを設定
	 * @return kensakuInsPhone
	 */
	public String getKensakuInsPhone() {
		return kensakuInsPhone;
	}


	/**
	 * @param kensakuInsPhone セットする kensakuInsPhone
	 */
	public void setKensakuInsPhone(String kensakuInsPhone) {
		this.kensakuInsPhone = kensakuInsPhone;
	}


	/**
	 * NF501DTO.javakensakuInsPcodeを設定
	 * @return kensakuInsPcode
	 */
	public String getKensakuInsPcode() {
		return kensakuInsPcode;
	}


	/**
	 * @param kensakuInsPcode セットする kensakuInsPcode
	 */
	public void setKensakuInsPcode(String kensakuInsPcode) {
		this.kensakuInsPcode = kensakuInsPcode;
	}


	/**
	 * NF501DTO.javakensakuAddrCodePrefを設定
	 * @return kensakuAddrCodePref
	 */
	public String getKensakuAddrCodePref() {
		return kensakuAddrCodePref;
	}


	/**
	 * @param kensakuAddrCodePref セットする kensakuAddrCodePref
	 */
	public void setKensakuAddrCodePref(String kensakuAddrCodePref) {
		this.kensakuAddrCodePref = kensakuAddrCodePref;
	}


	/**
	 * NF501DTO.javakensakuAddrCodeCityを設定
	 * @return kensakuAddrCodeCity
	 */
	public String getKensakuAddrCodeCity() {
		return kensakuAddrCodeCity;
	}


	/**
	 * @param kensakuAddrCodeCity セットする kensakuAddrCodeCity
	 */
	public void setKensakuAddrCodeCity(String kensakuAddrCodeCity) {
		this.kensakuAddrCodeCity = kensakuAddrCodeCity;
	}


	/**
	 * NF501DTO.javakensakuInsAddrを設定
	 * @return kensakuInsAddr
	 */
	public String getKensakuInsAddr() {
		return kensakuInsAddr;
	}


	/**
	 * @param kensakuInsAddr セットする kensakuInsAddr
	 */
	public void setKensakuInsAddr(String kensakuInsAddr) {
		this.kensakuInsAddr = kensakuInsAddr;
	}


	/**
	 * NF501DTO.javakensakuUpdMstFromを設定
	 * @return kensakuUpdMstFrom
	 */
	public String getKensakuUpdMstFrom() {
		return kensakuUpdMstFrom;
	}


	/**
	 * @param kensakuUpdMstFrom セットする kensakuUpdMstFrom
	 */
	public void setKensakuUpdMstFrom(String kensakuUpdMstFrom) {
		this.kensakuUpdMstFrom = kensakuUpdMstFrom;
	}


	/**
	 * NF501DTO.javaupdMstFromを設定
	 * @return updMstFrom
	 */
	public String getUpdMstFrom() {
		return updMstFrom;
	}


	/**
	 * @param updMstFrom セットする updMstFrom
	 */
	public void setUpdMstFrom(String updMstFrom) {
		this.updMstFrom = updMstFrom;
	}


	/**
	 * NF501DTO.javaupdMstToを設定
	 * @return updMstTo
	 */
	public String getUpdMstTo() {
		return updMstTo;
	}


	/**
	 * @param updMstTo セットする updMstTo
	 */
	public void setUpdMstTo(String updMstTo) {
		this.updMstTo = updMstTo;
	}


	/**
	 * NF501DTO.javajkrCityNameDataListを設定
	 * @return jkrCityNameDataList
	 */
	public List<JkrCityNameDataList> getJkrCityNameDataList() {
		return jkrCityNameDataList;
	}


	/**
	 * @param jkrCityNameDataList セットする jkrCityNameDataList
	 */
	public void setJkrCityNameDataList(List<JkrCityNameDataList> jkrCityNameDataList) {
		this.jkrCityNameDataList = jkrCityNameDataList;
	}


	/**
	 * NF501DTO.javahcoKeieitaiCdを設定
	 * @return hcoKeieitaiCd
	 */
	public String getHcoKeieitaiCd() {
		return hcoKeieitaiCd;
	}


	/**
	 * @param hcoKeieitaiCd セットする hcoKeieitaiCd
	 */
	public void setHcoKeieitaiCd(String hcoKeieitaiCd) {
		this.hcoKeieitaiCd = hcoKeieitaiCd;
	}


	/**
	 * NF501DTO.javahcoKeieitaiMapを設定
	 * @return hcoKeieitaiMap
	 */
	public LinkedHashMap<String, String> getHcoKeieitaiMap() {
		return hcoKeieitaiMap;
	}


	/**
	 * @param hcoKeieitaiMap セットする hcoKeieitaiMap
	 */
	public void setHcoKeieitaiMap(LinkedHashMap<String, String> hcoKeieitaiMap) {
		this.hcoKeieitaiMap = hcoKeieitaiMap;
	}


	/**
	 * NF501DTO.javahcoUpdHstDataListを設定
	 * @return hcoUpdHstDataList
	 */
	public List<HcoUpdHstDataList> getHcoUpdHstDataList() {
		return hcoUpdHstDataList;
	}


	/**
	 * @param hcoUpdHstDataList セットする hcoUpdHstDataList
	 */
	public void setHcoUpdHstDataList(List<HcoUpdHstDataList> hcoUpdHstDataList) {
		this.hcoUpdHstDataList = hcoUpdHstDataList;
	}


	/**
	 * NF501DTO.javamainInsDataListを設定
	 * @return mainInsDataList
	 */
	public List<MainInsDataList> getMainInsDataList() {
		return mainInsDataList;
	}


	/**
	 * @param mainInsDataList セットする mainInsDataList
	 */
	public void setMainInsDataList(List<MainInsDataList> mainInsDataList) {
		this.mainInsDataList = mainInsDataList;
	}


	/**
	 * NF501DTO.javapharmTypeCdを設定
	 * @return pharmTypeCd
	 */
	public String getPharmTypeCd() {
		return pharmTypeCd;
	}


	/**
	 * @param pharmTypeCd セットする pharmTypeCd
	 */
	public void setPharmTypeCd(String pharmTypeCd) {
		this.pharmTypeCd = pharmTypeCd;
	}


	/**
	 * NF501DTO.javapharmTypeMapを設定
	 * @return pharmTypeMap
	 */
	public LinkedHashMap<String, String> getPharmTypeMap() {
		return pharmTypeMap;
	}


	/**
	 * @param pharmTypeMap セットする pharmTypeMap
	 */
	public void setPharmTypeMap(LinkedHashMap<String, String> pharmTypeMap) {
		this.pharmTypeMap = pharmTypeMap;
	}


	/**
	 * NF501DTO.javahoInsTypeCdを設定
	 * @return hoInsTypeCd
	 */
	public String getHoInsTypeCd() {
		return hoInsTypeCd;
	}


	/**
	 * @param hoInsTypeCd セットする hoInsTypeCd
	 */
	public void setHoInsTypeCd(String hoInsTypeCd) {
		this.hoInsTypeCd = hoInsTypeCd;
	}


	/**
	 * NF501DTO.javahoInsTypeMapを設定
	 * @return hoInsTypeMap
	 */
	public LinkedHashMap<String, String> getHoInsTypeMap() {
		return hoInsTypeMap;
	}


	/**
	 * @param hoInsTypeMap セットする hoInsTypeMap
	 */
	public void setHoInsTypeMap(LinkedHashMap<String, String> hoInsTypeMap) {
		this.hoInsTypeMap = hoInsTypeMap;
	}


	/**
	 * NF501DTO.javainsTypeCdを設定
	 * @return insTypeCd
	 */
	public String getInsTypeCd() {
		return insTypeCd;
	}


	/**
	 * @param insTypeCd セットする insTypeCd
	 */
	public void setInsTypeCd(String insTypeCd) {
		this.insTypeCd = insTypeCd;
	}


	/**
	 * NF501DTO.javainsSbtMapを設定
	 * @return insSbtMap
	 */
	public LinkedHashMap<String, String> getInsSbtMap() {
		return insSbtMap;
	}


	/**
	 * @param insSbtMap セットする insSbtMap
	 */
	public void setInsSbtMap(LinkedHashMap<String, String> insSbtMap) {
		this.insSbtMap = insSbtMap;
	}


	/**
	 * NF501DTO.javajkrSosAddrCdを設定
	 * @return jkrSosAddrCd
	 */
	public String getJkrSosAddrCd() {
		return jkrSosAddrCd;
	}


	/**
	 * @param jkrSosAddrCd セットする jkrSosAddrCd
	 */
	public void setJkrSosAddrCd(String jkrSosAddrCd) {
		this.jkrSosAddrCd = jkrSosAddrCd;
	}


	/**
	 * NF501DTO.javajkrSosAddrMapを設定
	 * @return jkrSosAddrMap
	 */
	public LinkedHashMap<String, String> getJkrSosAddrMap() {
		return jkrSosAddrMap;
	}


	/**
	 * @param jkrSosAddrMap セットする jkrSosAddrMap
	 */
	public void setJkrSosAddrMap(LinkedHashMap<String, String> jkrSosAddrMap) {
		this.jkrSosAddrMap = jkrSosAddrMap;
	}


	/**
	 * NF501DTO.javajkrCityNameCdを設定
	 * @return jkrCityNameCd
	 */
	public String getJkrCityNameCd() {
		return jkrCityNameCd;
	}


	/**
	 * @param jkrCityNameCd セットする jkrCityNameCd
	 */
	public void setJkrCityNameCd(String jkrCityNameCd) {
		this.jkrCityNameCd = jkrCityNameCd;
	}


	/**
	 * NF501DTO.javajkrCityNameMapを設定
	 * @return jkrCityNameMap
	 */
	public LinkedHashMap<String, String> getJkrCityNameMap() {
		return jkrCityNameMap;
	}


	/**
	 * @param jkrCityNameMap セットする jkrCityNameMap
	 */
	public void setJkrCityNameMap(LinkedHashMap<String, String> jkrCityNameMap) {
		this.jkrCityNameMap = jkrCityNameMap;
	}


	/**
	 * NF501DTO.javakensakuReqJgiNameを設定
	 * @return kensakuReqJgiName
	 */
	public String getKensakuReqJgiName() {
		return kensakuReqJgiName;
	}


	/**
	 * NF501DTO.javakensakuUpdMstToを設定
	 * @return kensakuUpdMstTo
	 */
	public String getKensakuUpdMstTo() {
		return kensakuUpdMstTo;
	}


	/**
	 * NF501DTO.javatitleを設定
	 * @return title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * NF501DTO.javaclearUpdMstFromを設定
	 * @return clearUpdMstFrom
	 */
	public String getClearUpdMstFrom() {
		return clearUpdMstFrom;
	}


	/**
	 * @param clearUpdMstFrom セットする clearUpdMstFrom
	 */
	public void setClearUpdMstFrom(String clearUpdMstFrom) {
		this.clearUpdMstFrom = clearUpdMstFrom;
	}


	/**
	 * NF501DTO.javaclearUpdMstToを設定
	 * @return clearUpdMstTo
	 */
	public String getClearUpdMstTo() {
		return clearUpdMstTo;
	}


	/**
	 * @param clearUpdMstTo セットする clearUpdMstTo
	 */
	public void setClearUpdMstTo(String clearUpdMstTo) {
		this.clearUpdMstTo = clearUpdMstTo;
	}


}
