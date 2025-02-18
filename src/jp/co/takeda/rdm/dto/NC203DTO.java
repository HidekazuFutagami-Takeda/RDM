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
public class NC203DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NC203 = "NC203";

    /**
	 * 画面タイトル
	 * @generated
	 */
	private String title;

    /**
     * searchInput
     * @generated
     */
    private String searchInput;

    /**
     * inSearchInput
     * @generated
     */
    private String inSearchInput;

	/**
     * イベントID
     * @generated
     */
    private String functionId;

	/**
     * 親画面コールバックメソッド名
     * @generated
     */
    private String callBack;

    /**
     * 最大表示件数（エラーチェック用）
     */
    private Integer maxPageCnt;

    /**
     * 検索結果件数（エラーチェック用）
     */
    private Integer pageCnt;

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
     * 検索条件_施設名(全角)
     * @generated
     */
    private String insKanjiSrch;
    /**
     * 検索用＿施設名半角カナ
     * @generated
     */
    private String insKanaSrch;

    /**
     * 検索用＿廃院区分
     * @generated
     */
    private String kensakuHaiinKbn;

    /**
     * 検索用＿廃院区分
     * @generated
     */
    private String kensakuManageCd;

    /**
     * 検索用＿削除フラグ
     * @generated
     */
    private String kensakuDelFlg;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNoSrch;

    /**
     * 検索用＿ULTコード
     * @generated
     */
    private String ultNo;

    /**
     * 検索条件_対象区分
     * @generated
     */
    private String kensakuHoInsType;

    /**
     * 施設種別
     * @generated
     */
    private String kensakuInsSbt;

    /**
     * 検索条件_施設区分
     * @generated
     */
    private String pharmType;

    /**
     * 検索条件_電話番号(半角)
     * @generated
     */
    private String phone1;

    /**
     * 検索条件_郵便番号(半角)
     * @generated
     */
    private String insPcode;

    /**
     * 検索条件_都道府県
     * @generated
     */
    private String codeCity;

    /**
     * 検索条件_JIS市区町村
     * @generated
     */
    private String addrCodeCity;

    /**
     * 検索条件_子施設を除く
     * @generated
     */
    private boolean koshisetsuCheck;

    /**
     * 検索条件_子施設を除く
     * @generated
     */
    private boolean kensakuBool;

    /**
     * 住所
     * @generated
     */
    private String address;

	/**
     * 検索条件_施設名(全角)
     * @generated
     */
    private String kensakuAddrCodePref;

	/**
     * 検索条件_施設名(全角)
     * @generated
     */
    private String kensakuAddrCodeCity;

    /**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

	/**
     * 検索条件_test
     * @generated
     */
    private List<InsData> insData = new ArrayList<InsData>();

    /**
     * @経営主体_ドロップダウンリスト
     */
    private String hcoKeieitaiCd;
	private LinkedHashMap<String,String> hcoKeieitaiMap = new LinkedHashMap<String,String>();

	/**
     * @施設区分_ドロップダウンリスト
     */
    private String pharmTypeCd;
	private LinkedHashMap<String,String> pharmTypeMap = new LinkedHashMap<String,String>();

    /**
     * @対象区分_ドロップダウンリスト
     */
	private String hoInsTypeCd;
	private LinkedHashMap<String,String> hoInsTypeMap = new LinkedHashMap<String,String>();


    /**
     * @施設種別_ドロップダウンリスト
     */
	private String insTypeCd;
	private LinkedHashMap<String,String> insTypeMap = new LinkedHashMap<String,String>();

    /**
     * @都道府県_組織担当地区情報_ドロップダウンリスト
     */
	private String jkrSosAddrCd;
	private LinkedHashMap<String,String> jkrSosAddrMap = new LinkedHashMap<String,String>();

    /**
     * @市区町村_組織担当地区情報_ドロップダウンリスト
     */
	private String haiinKbnCd;
	private LinkedHashMap<String,String> haiinKbnMap = new LinkedHashMap<String,String>();

    /**
     * @市区町村_組織担当地区情報_ドロップダウンリスト
     */
	private String delFlgCd;
	private LinkedHashMap<String,String> delFlgMap = new LinkedHashMap<String,String>();

    /**
     * @市区町村_組織担当地区情報_ドロップダウンリスト
     */
	private String jkrCityNameCd;
	private LinkedHashMap<String,String> mapCityName = new LinkedHashMap<String,String>();

    /**
     * @generated
     */
    private String test;

	/**
     * ソートID
     */
    private String sortCondition;

	/**
     * ソートID
     */
    private String inSortId;

    /**
     * ヘッダ表示フラグ
     * @generated
     */
    private int pageFlg;

    /**
     * 表示区分
     * 0:ULTなし、1:ULTあり、2:来期用
     * @generated
     */
    private String viewKbn;


	/**
	 * NC203DTO.javapageFlgを設定
	 * @return pageFlg
	 */
	public int getPageFlg() {
		return pageFlg;
	}

	/**
	 * @param pageFlg セットする pageFlg
	 */
	public void setPageFlg(int pageFlg) {
		this.pageFlg = pageFlg;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC203DTO() {
        setForward(NC203);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNC203(String screenID){
        this.NC203 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNC203(){
        return NC203;
    }

	/**
	 * NC203DTO.javatitleを設定
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
     * イベントIDの取得
     * @return イベントID
     * @generated
     */
	public String getFunctionId() {
		return functionId;
	}

    public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

	public String getInSearchInput() {
		return inSearchInput;
	}

	public void setInSearchInput(String inSearchInput) {
		this.inSearchInput = inSearchInput;
	}

	/**
     * イベントIDの設定
     * @return イベントID
     * @generated
     */
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
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



    public String getInsKanjiSrch() {
		return insKanjiSrch;
	}



	public void setInsKanjiSrch(String insKanjiSrch) {
		this.insKanjiSrch = insKanjiSrch;
	}


	/**
	 * NC203DTO.javainsKanaSrchを設定
	 * @return insKanaSrch
	 */
	public String getInsKanaSrch() {
		return insKanaSrch;
	}

	/**
	 * @param insKanaSrch セットする insKanaSrch
	 */
	public void setInsKanaSrch(String insKanaSrch) {
		this.insKanaSrch = insKanaSrch;
	}

	/**
	 * NC203DTO.javahaiinKbnを設定
	 * @return haiinKbn
	 */
	public String getKensakuHaiinKbn() {
		return kensakuHaiinKbn;
	}

	/**
	 * @param haiinKbn セットする haiinKbn
	 */
	public void setKensakuHaiinKbn(String kensakuHaiinKbn) {
		this.kensakuHaiinKbn = kensakuHaiinKbn;
	}

	/**
	 * NC203DTO.javakensakuDelFlgを設定
	 * @return kensakuDelFlg
	 */
	public String getKensakuDelFlg() {
		return kensakuDelFlg;
	}

	/**
	 * @param kensakuDelFlg セットする kensakuDelFlg
	 */
	public void setKensakuDelFlg(String kensakuDelFlg) {
		this.kensakuDelFlg = kensakuDelFlg;
	}

	/**
	 * @param koshisetsuCheck セットする koshisetsuCheck
	 */
	public void setKoshisetsuCheck(boolean koshisetsuCheck) {
		this.koshisetsuCheck = koshisetsuCheck;
	}

	/**
	 * NC203DTO.javainsNoを設定
	 * @return insNo
	 */
	public String getInsNo() {
		return insNo;
	}

	/**
	 * @param insNo セットする insNo
	 */
	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}

	/**
	 * NC203DTO.javainsNoSrchを設定
	 * @return insNoSrch
	 */
	public String getInsNoSrch() {
		return insNoSrch;
	}

	/**
	 * @param insNoSrch セットする insNoSrch
	 */
	public void setInsNoSrch(String insNoSrch) {
		this.insNoSrch = insNoSrch;
	}

	/**
	 * NC203DTO.javaultNoを設定
	 * @return ultNo
	 */
	public String getUltNo() {
		return ultNo;
	}

	/**
	 * @param ultNo セットする ultNo
	 */
	public void setUltNo(String ultNo) {
		this.ultNo = ultNo;
	}

	/**
	 * NC203DTO.javakensakuHoInsTypeを設定
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
	 * NC203DTO.javakensakuInsSbtを設定
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
	 * NC203DTO.javapharmTypeを設定
	 * @return pharmType
	 */
	public String getPharmType() {
		return pharmType;
	}

	/**
	 * @param pharmType セットする pharmType
	 */
	public void setPharmType(String pharmType) {
		this.pharmType = pharmType;
	}

	/**
	 * NC203DTO.javaphone1を設定
	 * @return phone1
	 */
	public String getPhone1() {
		return phone1;
	}

	/**
	 * @param phone1 セットする phone1
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	/**
	 * NC203DTO.javainsPcodeを設定
	 * @return insPcode
	 */
	public String getInsPcode() {
		return insPcode;
	}

	/**
	 * NC203DTO.javakoshisetsuCheckを設定
	 * @return koshisetsuCheck
	 */
	public Boolean getKoshisetsuCheck() {
		return koshisetsuCheck;
	}

	/**
	 * @param koshisetsuCheck セットする koshisetsuCheck
	 */
	public void setKoshisetsuCheck(Boolean koshisetsuCheck) {
		this.koshisetsuCheck = koshisetsuCheck;
	}

	/**
	 * @param insPcode セットする insPcode
	 */
	public void setInsPcode(String insPcode) {
		this.insPcode = insPcode;
	}

	/**
	 * NC203DTO.javakensakuManageCdを設定
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
	 * NC203DTO.javacodeCityを設定
	 * @return codeCity
	 */
	public String getCodeCity() {
		return codeCity;
	}

	/**
	 * @param codeCity セットする codeCity
	 */
	public void setCodeCity(String codeCity) {
		this.codeCity = codeCity;
	}

	/**
	 * NC203DTO.javaaddrCodeCityを設定
	 * @return addrCodeCity
	 */
	public String getAddrCodeCity() {
		return addrCodeCity;
	}

	/**
	 * @param addrCodeCity セットする addrCodeCity
	 */
	public void setAddrCodeCity(String addrCodeCity) {
		this.addrCodeCity = addrCodeCity;
	}

	/**
	 * NC203DTO.javakensakuAddrCodeCityを設定
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
	 * NC203DTO.javainsAddrを設定
	 * @return insAddr
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param insAddr セットする insAddr
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getKensakuAddrCodePref() {
		return kensakuAddrCodePref;
	}

	public void setKensakuAddrCodePref(String kensakuAddrCodePref) {
		this.kensakuAddrCodePref = kensakuAddrCodePref;
	}

	/**
	 * NC203DTO.javainsDataを設定
	 * @return insData
	 */
	public List<InsData> getInsData() {
		return insData;
	}

	/**
	 * @param insData セットする insData
	 */
	public void setInsData(List<InsData> insData) {
		this.insData = insData;
	}

	public String getHcoKeieitaiCd() {
		return hcoKeieitaiCd;
	}

	public void setHcoKeieitaiCd(String hcoKeieitaiCd) {
		this.hcoKeieitaiCd = hcoKeieitaiCd;
	}

	public LinkedHashMap<String, String> getHcoKeieitaiMap() {
		return hcoKeieitaiMap;
	}

	public void setHcoKeieitaiMap(LinkedHashMap<String, String> hcoKeieitaiMap) {
		this.hcoKeieitaiMap = hcoKeieitaiMap;
	}

	public String getPharmTypeCd() {
		return pharmTypeCd;
	}

	public void setPharmTypeCd(String pharmTypeCd) {
		this.pharmTypeCd = pharmTypeCd;
	}

	public LinkedHashMap<String, String> getPharmTypeMap() {
		return pharmTypeMap;
	}

	public void setPharmTypeMap(LinkedHashMap<String, String> pharmTypeMap) {
		this.pharmTypeMap = pharmTypeMap;
	}

	public String getHoInsTypeCd() {
		return hoInsTypeCd;
	}

	public void setHoInsTypeCd(String hoInsTypeCd) {
		this.hoInsTypeCd = hoInsTypeCd;
	}

	public LinkedHashMap<String, String> getHoInsTypeMap() {
		return hoInsTypeMap;
	}

	public void setHoInsTypeMap(LinkedHashMap<String, String> hoInsTypeMap) {
		this.hoInsTypeMap = hoInsTypeMap;
	}

	public String getInsTypeCd() {
		return insTypeCd;
	}

	public void setInsTypeCd(String insTypeCd) {
		this.insTypeCd = insTypeCd;
	}

	public LinkedHashMap<String, String> getInsTypeMap() {
		return insTypeMap;
	}

	public void setInsTypeMap(LinkedHashMap<String, String> insTypeMap) {
		this.insTypeMap = insTypeMap;
	}

	public String getJkrSosAddrCd() {
		return jkrSosAddrCd;
	}

	public void setJkrSosAddrCd(String jkrSosAddrCd) {
		this.jkrSosAddrCd = jkrSosAddrCd;
	}

	public LinkedHashMap<String, String> getJkrSosAddrMap() {
		return jkrSosAddrMap;
	}

	public void setJkrSosAddrMap(LinkedHashMap<String, String> jkrSosAddrMap) {
		this.jkrSosAddrMap = jkrSosAddrMap;
	}

	public String getJkrCityNameCd() {
		return jkrCityNameCd;
	}

	public void setJkrCityNameCd(String jkrCityNameCd) {
		this.jkrCityNameCd = jkrCityNameCd;
	}

	public LinkedHashMap<String, String> getMapCityName() {
		return mapCityName;
	}

	public void setMapCityName(LinkedHashMap<String, String> mapCityName) {
		this.mapCityName = mapCityName;
	}

	public String getHaiinKbnCd() {
		return haiinKbnCd;
	}

	public void setHaiinKbnCd(String haiinKbnCd) {
		this.haiinKbnCd = haiinKbnCd;
	}

	public LinkedHashMap<String, String> getHaiinKbnMap() {
		return haiinKbnMap;
	}

	public void setHaiinKbnMap(LinkedHashMap<String, String> haiinKbnMap) {
		this.haiinKbnMap = haiinKbnMap;
	}

	public String getDelFlgCd() {
		return delFlgCd;
	}

	public void setDelFlgCd(String delFlgCd) {
		this.delFlgCd = delFlgCd;
	}

	public LinkedHashMap<String, String> getDelFlgMap() {
		return delFlgMap;
	}

	public void setDelFlgMap(LinkedHashMap<String, String> delFlgMap) {
		this.delFlgMap = delFlgMap;
	}

	/**
	 * ND011DTO.javamsgStrを設定
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
	 * NC203DTO.javasortConditionを設定
	 * @return sortCondition
	 */
	public String getSortCondition() {
		return sortCondition;
	}

	/**
	 * @param sortCondition セットする sortCondition
	 */
	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}

	/**
	 * NC203DTO.javainSortIdを設定
	 * @return inSortId
	 */
	public String getInSortId() {
		return inSortId;
	}

	/**
	 * @param inSortId セットする inSortId
	 */
	public void setInSortId(String inSortId) {
		this.inSortId = inSortId;
	}

	/**
	 * NC203DTO.javakensakuBoolを設定
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
	 * NC203DTO.javamaxPageCntを設定
	 * @return maxPageCnt
	 */
	public Integer getMaxPageCnt() {
		return maxPageCnt;
	}

	/**
	 * @param maxPageCnt セットする maxPageCnt
	 */
	public void setMaxPageCnt(Integer maxPageCnt) {
		this.maxPageCnt = maxPageCnt;
	}

	/**
	 * NC203DTO.javapageCntを設定
	 * @return pageCnt
	 */
	public Integer getPageCnt() {
		return pageCnt;
	}

	/**
	 * @param pageCnt セットする pageCnt
	 */
	public void setPageCnt(Integer pageCnt) {
		this.pageCnt = pageCnt;
	}

	/**
	 * NC203DTO.javaviewKbnを設定
	 * @return viewKbn
	 */
	public String getViewKbn() {
		return viewKbn;
	}

	/**
	 * @param viewKbn セットする viewKbn
	 */
	public void setViewKbn(String viewKbn) {
		this.viewKbn = viewKbn;
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
