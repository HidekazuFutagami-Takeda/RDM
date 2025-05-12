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

import jp.co.takeda.rdm.common.BaseDTO;

/**
 * DTOクラス
 * @generated
 */
public class ND501DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String ND501 = "ND501";

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
     * 権限_条件セット
     * @generated
     */
    private String jokenSetCd;

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
    private String sortId = "0";

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
     * ポップアップ用判別
     * @generated
     */
    private String loginJokenSetCd;


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
     * 検索条件_従業員名
     *
     * @generated
     */
    private String jgiName;

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
     * 検索条件_担当者組織名
     *
     * @generated
     */
    private String sosName;

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
     * 検索条件_申請者組織
     * @generated
     */
    private String kensakuReqShz;

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
     * 検索条件_施設固定C
     * @generated
     */
    private String kensakuInsNo;



    /**
     * 検索条件_氏名漢字(全角)
     * @generated
     */
    private String kensakuDocKanj;

    /**
     * 検索条件_氏名カナ(半角カナ)
     * @generated
     */
    private String kensakuDocKana;

    /**
     * 検索条件_医師／薬剤師区分
     * @generated
     */
    private String kensakuDocType;

    /**
     * 検索条件_医師固定C
     * @generated
     */
    private String kensakuDocNo;

    /**
     * 検索条件_ULT医師コード
     * @generated
     */
    private String kensakuUltDocNo;

    /**
     * 検索条件_医師属性
     * @generated
     */
    private String kensakuDocAttribute;

    /**
     * 検索条件_出身校
     * @generated
     */
    private String kensakuMedSch;

    /**
     * 検索条件_卒年(西暦)
     * @generated
     */
    private String kensakuGradYear;

    /**
     * 検索条件_出身医局校
     * @generated
     */
    private String kensakuHuniv;

    /**
     * 検索条件_施設名
     * @generated
     */
    private String kensakuInsKanj;

    /**
     * 検索条件_更新日(開始日)
     * @generated
     */
    private String kensakuUpdMstFrom;

    /**
     * 検索条件_更新日(終了日)
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

    /**
     * 親画面名
     * @generated
     */
    private String title;

    /**
     * @医師変更履歴
     */
     private List<HcpUpdHstDataList> hcpUpdHstDataList = new ArrayList<HcpUpdHstDataList>();


    /**
     * @医師／薬剤師区分_ドロップダウンリスト
     */
    private String docTypeCd;
	private LinkedHashMap<String,String> docTypeMap = new LinkedHashMap<String,String>();


    /**
     * @医師属性_ドロップダウンリスト
     */
	private String docAttributeCd;
	private LinkedHashMap<String,String> docAttributeMap = new LinkedHashMap<String,String>();

	/**
     * @出身校_ドロップダウンリスト
     */
    private String medSchCd;
	private LinkedHashMap<String,String> medSchMap = new LinkedHashMap<String,String>();

    /**
     * @卒年(西暦)_ドロップダウンリスト
     */
	private String gradYearCd;
	private LinkedHashMap<String,String> gradYearMap = new LinkedHashMap<String,String>();


    /**
     * @出身医局校_ドロップダウンリスト
     */
	private String hunivCd;
	private LinkedHashMap<String,String> hunivMap = new LinkedHashMap<String,String>();

	/**
     * @検索結果切り替えリスト_ドロップダウンリスト
     */
	private String selectListChangeCd;
	private LinkedHashMap<String,String> selectListChangeMap = new LinkedHashMap<String,String>();
	/**
	 * ND501DTO.javaND501を設定
	 * @return nD501
	 */
	public String getND501() {
		return ND501;
	}

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND501DTO() {
        setForward(ND501);
    }

	/**
	 * @param nD501 セットする nD501
	 */
	public void setND501(String nD501) {
		ND501 = nD501;
	}
	/**
	 * ND501DTO.javacallBackを設定
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
	 * ND501DTO.javawinVarNameを設定
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
	 * ND501DTO.javajokenSetCdを設定
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
	 * ND501DTO.javamsgStrを設定
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
	 * ND501DTO.javapageCntCurを設定
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
	 * ND501DTO.javafunctionIdを設定
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
	 * ND501DTO.javaparamInsNoを設定
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
	 * ND501DTO.javasearchTypeを設定
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
	 * ND501DTO.javaselectListChangeを設定
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
	 * ND501DTO.javakensakuBoolを設定
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
	 * ND501DTO.javakensakuReqJgiNameを設定
	 * @return kensakuReqJgiName
	 */
	public String getKensakuReqJgiName() {
		return kensakuReqJgiName;
	}
	/**
	 * @param kensakuReqJgiName セットする kensakuReqJgiName
	 */
	public void setKensakuReqJgiName(String kensakuReqJgiName) {
		this.kensakuReqJgiName = kensakuReqJgiName;
	}

	/**
	 * ND501DTO.javakensakuReqShzを設定
	 * @return kensakuReqShz
	 */
	public String getKensakuReqShz() {
		return kensakuReqShz;
	}

	/**
	 * @param kensakuReqShz セットする kensakuReqShz
	 */
	public void setKensakuReqShz(String kensakuReqShz) {
		this.kensakuReqShz = kensakuReqShz;
	}

	/**
	 * ND501DTO.javakensakuInsNoを設定
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
	 * ND501DTO.javakensakuDocKanjを設定
	 * @return kensakuDocKanj
	 */
	public String getKensakuDocKanj() {
		return kensakuDocKanj;
	}
	/**
	 * @param kensakuDocKanj セットする kensakuDocKanj
	 */
	public void setKensakuDocKanj(String kensakuDocKanj) {
		this.kensakuDocKanj = kensakuDocKanj;
	}
	/**
	 * ND501DTO.javakensakuDocKanaを設定
	 * @return kensakuDocKana
	 */
	public String getKensakuDocKana() {
		return kensakuDocKana;
	}
	/**
	 * @param kensakuDocKana セットする kensakuDocKana
	 */
	public void setKensakuDocKana(String kensakuDocKana) {
		this.kensakuDocKana = kensakuDocKana;
	}
	/**
	 * ND501DTO.javakensakuDocTypeを設定
	 * @return kensakuDocType
	 */
	public String getKensakuDocType() {
		return kensakuDocType;
	}
	/**
	 * @param kensakuDocType セットする kensakuDocType
	 */
	public void setKensakuDocType(String kensakuDocType) {
		this.kensakuDocType = kensakuDocType;
	}
	/**
	 * ND501DTO.javakensakuDocNoを設定
	 * @return kensakuDocNo
	 */
	public String getKensakuDocNo() {
		return kensakuDocNo;
	}
	/**
	 * @param kensakuDocNo セットする kensakuDocNo
	 */
	public void setKensakuDocNo(String kensakuDocNo) {
		this.kensakuDocNo = kensakuDocNo;
	}
	/**
	 * ND501DTO.javakensakuUltDocNoを設定
	 * @return kensakuUltDocNo
	 */
	public String getKensakuUltDocNo() {
		return kensakuUltDocNo;
	}
	/**
	 * @param kensakuUltDocNo セットする kensakuUltDocNo
	 */
	public void setKensakuUltDocNo(String kensakuUltDocNo) {
		this.kensakuUltDocNo = kensakuUltDocNo;
	}

	/**
	 * ND501DTO.javakensakuMedSchを設定
	 * @return kensakuMedSch
	 */
	public String getKensakuMedSch() {
		return kensakuMedSch;
	}
	/**
	 * @param kensakuMedSch セットする kensakuMedSch
	 */
	public void setKensakuMedSch(String kensakuMedSch) {
		this.kensakuMedSch = kensakuMedSch;
	}
	/**
	 * ND501DTO.javakensakuGradYearを設定
	 * @return kensakuGradYear
	 */
	public String getKensakuGradYear() {
		return kensakuGradYear;
	}
	/**
	 * @param kensakuGradYear セットする kensakuGradYear
	 */
	public void setKensakuGradYear(String kensakuGradYear) {
		this.kensakuGradYear = kensakuGradYear;
	}
	/**
	 * ND501DTO.javakensakuInsKanjを設定
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
	 * ND501DTO.javakensakuUpdMstFromを設定
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
	 * ND501DTO.javakensakuUpdMstToを設定
	 * @return kensakuUpdMstTo
	 */
	public String getKensakuUpdMstTo() {
		return kensakuUpdMstTo;
	}
	/**
	 * @param kensakuUpdMstTo セットする kensakuUpdMstTo
	 */
	public void setKensakuUpdMstTo(String kensakuUpdMstTo) {
		this.kensakuUpdMstTo = kensakuUpdMstTo;
	}
	/**
	 * ND501DTO.javaupdMstFromを設定
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
	 * ND501DTO.javaupdMstToを設定
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
	 * ND501DTO.javaselectListChangeCdを設定
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
	 * ND501DTO.javaselectListChangeMapを設定
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
	 * ND501DTO.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * ND501DTO.javakensakuDocAttributeを設定
	 * @return kensakuDocAttribute
	 */
	public String getKensakuDocAttribute() {
		return kensakuDocAttribute;
	}
	/**
	 * @param kensakuDocAttribute セットする kensakuDocAttribute
	 */
	public void setKensakuDocAttribute(String kensakuDocAttribute) {
		this.kensakuDocAttribute = kensakuDocAttribute;
	}
	/**
	 * ND501DTO.javadocTypeCdを設定
	 * @return docTypeCd
	 */
	public String getDocTypeCd() {
		return docTypeCd;
	}
	/**
	 * @param docTypeCd セットする docTypeCd
	 */
	public void setDocTypeCd(String docTypeCd) {
		this.docTypeCd = docTypeCd;
	}
	/**
	 * ND501DTO.javadocTypeMapを設定
	 * @return docTypeMap
	 */
	public LinkedHashMap<String, String> getDocTypeMap() {
		return docTypeMap;
	}
	/**
	 * @param docTypeMap セットする docTypeMap
	 */
	public void setDocTypeMap(LinkedHashMap<String, String> docTypeMap) {
		this.docTypeMap = docTypeMap;
	}
	/**
	 * ND501DTO.javadocAttributeCdを設定
	 * @return docAttributeCd
	 */
	public String getDocAttributeCd() {
		return docAttributeCd;
	}
	/**
	 * @param docAttributeCd セットする docAttributeCd
	 */
	public void setDocAttributeCd(String docAttributeCd) {
		this.docAttributeCd = docAttributeCd;
	}
	/**
	 * ND501DTO.javadocAttributeMapを設定
	 * @return docAttributeMap
	 */
	public LinkedHashMap<String, String> getDocAttributeMap() {
		return docAttributeMap;
	}
	/**
	 * @param docAttributeMap セットする docAttributeMap
	 */
	public void setDocAttributeMap(LinkedHashMap<String, String> docAttributeMap) {
		this.docAttributeMap = docAttributeMap;
	}
	/**
	 * ND501DTO.javamedSchCdを設定
	 * @return medSchCd
	 */
	public String getMedSchCd() {
		return medSchCd;
	}
	/**
	 * @param medSchCd セットする medSchCd
	 */
	public void setMedSchCd(String medSchCd) {
		this.medSchCd = medSchCd;
	}
	/**
	 * ND501DTO.javamedSchMapを設定
	 * @return medSchMap
	 */
	public LinkedHashMap<String, String> getMedSchMap() {
		return medSchMap;
	}
	/**
	 * @param medSchMap セットする medSchMap
	 */
	public void setMedSchMap(LinkedHashMap<String, String> medSchMap) {
		this.medSchMap = medSchMap;
	}
	/**
	 * ND501DTO.javagradYearCdを設定
	 * @return gradYearCd
	 */
	public String getGradYearCd() {
		return gradYearCd;
	}
	/**
	 * @param gradYearCd セットする gradYearCd
	 */
	public void setGradYearCd(String gradYearCd) {
		this.gradYearCd = gradYearCd;
	}
	/**
	 * ND501DTO.javagradYearMapを設定
	 * @return gradYearMap
	 */
	public LinkedHashMap<String, String> getGradYearMap() {
		return gradYearMap;
	}
	/**
	 * @param gradYearMap セットする gradYearMap
	 */
	public void setGradYearMap(LinkedHashMap<String, String> gradYearMap) {
		this.gradYearMap = gradYearMap;
	}


	/**
	 * ND501DTO.javatitleを設定
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
	 * ND501DTO.javahunivCdを設定
	 * @return hunivCd
	 */
	public String getHunivCd() {
		return hunivCd;
	}

	/**
	 * @param hunivCd セットする hunivCd
	 */
	public void setHunivCd(String hunivCd) {
		this.hunivCd = hunivCd;
	}

	/**
	 * ND501DTO.javahunivMapを設定
	 * @return hunivMap
	 */
	public LinkedHashMap<String, String> getHunivMap() {
		return hunivMap;
	}

	/**
	 * @param hunivMap セットする hunivMap
	 */
	public void setHunivMap(LinkedHashMap<String, String> hunivMap) {
		this.hunivMap = hunivMap;
	}

	/**
	 * ND501DTO.javahcpUpdHstDataListを設定
	 * @return hcpUpdHstDataList
	 */
	public List<HcpUpdHstDataList> getHcpUpdHstDataList() {
		return hcpUpdHstDataList;
	}

	/**
	 * @param hcpUpdHstDataList セットする hcpUpdHstDataList
	 */
	public void setHcpUpdHstDataList(List<HcpUpdHstDataList> hcpUpdHstDataList) {
		this.hcpUpdHstDataList = hcpUpdHstDataList;
	}

	/**
	 * ND501DTO.javakensakuHunivを設定
	 * @return kensakuHuniv
	 */
	public String getKensakuHuniv() {
		return kensakuHuniv;
	}

	/**
	 * @param kensakuHuniv セットする kensakuHuniv
	 */
	public void setKensakuHuniv(String kensakuHuniv) {
		this.kensakuHuniv = kensakuHuniv;
	}

	/**
	 * ND501DTO.javaloginJokenSetCdを設定
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
	 * ND501DTO.javamrJgiNoを設定
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
	 * ND501DTO.javamrBrCodeを設定
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
	 * ND501DTO.javamrDistCodeを設定
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
	 * ND501DTO.javamrTrtCdを設定
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
	 * ND501DTO.javakensakuJgiNoを設定
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
	 * ND501DTO.javajgiNameを設定
	 * @return jgiName
	 */
	public String getJgiName() {
		return jgiName;
	}

	/**
	 * @param jgiName セットする jgiName
	 */
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	/**
	 * ND501DTO.javakensakuShinseiBrCodeを設定
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
	 * ND501DTO.javakensakuShinseiDistCodeを設定
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
	 * ND501DTO.javakensakuSTantouBrCodeを設定
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
	 * ND501DTO.javakensakuTantouDistCodeを設定
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
	 * ND501DTO.javasosNameを設定
	 * @return sosName
	 */
	public String getSosName() {
		return sosName;
	}

	/**
	 * @param sosName セットする sosName
	 */
	public void setSosName(String sosName) {
		this.sosName = sosName;
	}

	/**
	 * ND501DTO.javasortIdを設定
	 * @return sortId
	 */
	public String getSortId() {
		return sortId;
	}

	/**
	 * @param sortId セットする sortId
	 */
	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	/**
	 * ND501DTO.javaclearUpdMstFromを設定
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
	 * ND501DTO.javaclearUpdMstToを設定
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
