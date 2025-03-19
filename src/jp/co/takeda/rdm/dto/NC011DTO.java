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
import java.util.LinkedHashMap;
import java.util.List;

/**
 * DTOクラス
 * @generated
 */
public class NC011DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NC011 = "NC011";

    private String boolKnb;
	/**
     * 親画面コールバックメソッド名
     * @generated
     */
    private String callBack;

    /**
     * 遷移元画面ID
     */
	private String preScreenId;

    /**
     * 管理者・MR権限判定
     */
	private String jokenFlg;

    /**
     * 申請ID有無判定
     */
	private String reqFlg;

	/**
	 * 画面タイトル
	 * @generated
	 */
	private String title;

	/**
     * Offset値
     * @generated
     */
    private Integer inOffset;

    /**
     * Limit値
     * @generated
     */
    private Integer inLimit;

	/**
     * 検索-JIS都道府県
     * @generated
     */
    private String aDdrCodePref;
	/**
     * 検索-種別
     * @generated
     */
    private String sbt;
    /**
     * 検索-連携種別
     * @generated
     */
    private String reqSbt;
    /**
     * 検索-種別
     * @generated
     */
    private String reqType;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosAddrMap;

	/**
     * @generated
     */
    private LinkedHashMap jkrSosReqSbtMap;

	/**
     * @generated
     */
    private LinkedHashMap jkrSosSbtMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosReqTypeMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosReqStsMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosInsClassMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosInsSbtMap;

	/**
     * @generated
     */
    private LinkedHashMap jkrSosDocTypeMap;
	/**
     * @generated
     */
    private LinkedHashMap jkrSosJobFormMap;

	/**
     * @generated
     */
    private LinkedHashMap jkrSosReqChlMap;


	/**
     * @generated
     */
    private LinkedHashMap jkrSosHoInsTypeMap;
    /**
     * 担当先コンボ
     * @generated
     */
    private LinkedHashMap searchInsChgCombo;

    /**
     * FB申請要否
     */
    private LinkedHashMap JkrSosFbReqFlgMap;

    /**
     * FB処理区分
     */
    private LinkedHashMap JkrSosFbPrcTypeMap;

	/**
	 * ソート部の宣言 + get,set
	 */
	private String sortCondition;
    private String reqIdAscClass;
    private String reqIdDescClass;
    private String reqYmdhmsAscClass;
    private String reqYmdhmsDescClass;
    private String reqSbtAscClass;
    private String reqSbtDescClass;
    private String reqTypeAscClass;
    private String reqTypeDescClass;
	private String reqStsAscClass;
    private String reqStsDescClass;
    private String sbtAscClass;
    private String sbtDescClass;
    private String reqJgiNameAscClass;
    private String reqJgiNameDescClass;

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
     * 親画面から受け取るMR/管理者のflag
     */
    private String mrAdminCd;

	/**
     * 従業員番号
     */
    private String jgiNo;
    /**
     * 従業員名
     */
    private String jgiName;

	/**
	 * 審査flag
	 */
	private String shnFlg;

	/**
	 * 審査者名
	 */
	private String shnShaId;


	/**
	 * FB申請要否
	 */
	private String fbReqFlg;


	/**
	 * 審査日時
	 */
	private String shnYmdhms;

	/**
	 * FB回答ID
	 *
	 */
	private String fbAnsId;


	/**
	 * FB処理区分
	 */
	private String fbPrcType;


	/**
     * @generated
     */
    private List<CatSnseiComboDataList> catSnseiComboDataList = new ArrayList<CatSnseiComboDataList>();
    /**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;


    /**
	 * メッセージ中身
	 * @generated
	 */
	private String msgData;

	    /**
	 * reqChl
	 * @generated
	 */

	private String reqChl;


	    /**
	 * reqSts
	 * @generated
	 */

	private String reqSts;

	    /**
	 * insNo
	 * @generated
	 */

	private String insNo;
	    /**
	 * docNo
	 * @generated
	 */

	private String docNo;
	 /**
	 * insClass
	 * @generated
	 */

	private String insClass;


		/**
	 * insSbt
	 * @generated
	 */

	private String insSbt;

	    /**
	 * reqSts
	 * @generated
	 */

	private String docType;
	    /**
	 * jobForm 勤務形態
	 * @generated
	 */

	private String jobForm;
	    /**
	 * hoInsType
	 * @generated
	 */

	private String hoInsType;

	    /**
	 * insFormalName
	 * @generated
	 */

	private String insFormalName;

	/**
	 * 施設名-検索用
	 */
	private String insKanjiSrch;

	/**
	 * @generated
	 */
	private String test;
	/**
	 * rEQ_ID
	 * @generated
	 */

	private String reqIdCell;
	/**
	 * rEQ_ID
	 * @generated
	 */

	private String reqTypeCell;

	/**
	 * rEQ_ID
	 * @generated
	 */

	private String reqId;

	/**
	 * 検索-申請日時
	 * inreqYmdhmsFrom
	 * @generated
	 */

	private String inreqYmdhmsFrom;
	/**
	 * 検索-申請日時
	 * inreqYmdhmsTo
	 * @generated
	 */

	private String inreqYmdhmsTo;

	/**
	 * reqYmdhmsFrom
	 * @generated
	 */

	private String reqYmdhmsFrom;
	/**
	 * reqYmdhmsTo
	 * @generated
	 */

	private String reqYmdhmsTo;

	/**
	 * knYmdhmsFrom
	 * @generated
	 */

	private String knYmdhmsFrom;


	/**
	 * knYmdhmsTo
	 * @generated
	 */

	private String knYmdhmsTo;

		/**
	 * docKanj
	 * @generated
	 */

	private String docKanj;



	    /**
	 * reqJgiName --申請者氏名
	 * @generated
	 */

	private String reqJgiName;

	    /**
	 * reqJgiNo
	 * @generated
	 */

	private String reqJgiNo;

	/**
	 *部門ランク
	 */
	private String bumonRank;


	/**
	 *組織コード
	 */
	private String sosCd;

	/**
	 *組織名称
	 */
	private String bumonRyakuName;



	    /**
	 * brCode
	 * @generated
	 */

	/**
	 * 医薬支店Cとの比較
	 */
	private String brCode;


		/**
	 * distCode
	 * @generated
	 */

	private String distCode;


		/**
	 * reqShz
	 * @generated
	 */

	private String reqShz;
	    /**
	 * reqComment
	 * 申請コメント
	 * @generated
	 */

	private String reqComment;

	    /**
	 * aPR_YMDHMS
	 * @generated
	 */

	private String aPR_YMDHMS;

	    /**
	 * aPR_SHA_ID
	 * @generated
	 */

	private String aPR_SHA_ID;

	    /**
	 * aPR_MEMO
	 * @generated
	 */

	private String aPR_MEMO;

	    /**
	 * aPR_COMMNET
	 * @generated
	 */

	private String aprComment;

	private boolean isKensakuBool;

	private String pageFlag;

	public String getBoolKnb() {
		return boolKnb;
	}
	public void setBoolKnb(String boolKnb) {
		this.boolKnb = boolKnb;
	}

	public String getPreScreenId() {
		return preScreenId;
	}

	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

    /**
	 * NC011DTO.javatitleを設定
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
	public LinkedHashMap getJkrSosFbReqFlgMap() {
		return JkrSosFbReqFlgMap;
	}
	public void setJkrSosFbReqFlgMap(LinkedHashMap jkrSosFbReqFlgMap) {
		JkrSosFbReqFlgMap = jkrSosFbReqFlgMap;
	}
	public LinkedHashMap getJkrSosFbPrcTypeMap() {
		return JkrSosFbPrcTypeMap;
	}
	public void setJkrSosFbPrcTypeMap(LinkedHashMap jkrSosFbPrcTypeMap) {
		JkrSosFbPrcTypeMap = jkrSosFbPrcTypeMap;
	}

	/**
	 * 担当先コンボを取得します。
	 * @return 担当先コンボ
	 */
	public LinkedHashMap getSearchInsChgCombo() {
	    return searchInsChgCombo;
	}

    public String getSortCondition() {
		return sortCondition;
	}
	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}


	/**
	 * NC011DTO.javareqIdCellを設定
	 * @return reqIdCell
	 */
	public String getReqIdCell() {
		return reqIdCell;
	}
	/**
	 * @param reqIdCell セットする reqIdCell
	 */
	public void setReqIdCell(String reqIdCell) {
		this.reqIdCell = reqIdCell;
	}
	/**
	 * NC011DTO.javareqTypeCellを設定
	 * @return reqTypeCell
	 */
	public String getReqTypeCell() {
		return reqTypeCell;
	}
	/**
	 * @param reqTypeCell セットする reqTypeCell
	 */
	public void setReqTypeCell(String reqTypeCell) {
		this.reqTypeCell = reqTypeCell;
	}
	public String getReqIdAscClass() {
		return reqIdAscClass;
	}
	public void setReqIdAscClass(String reqIdAscClass) {
		this.reqIdAscClass = reqIdAscClass;
	}
	public String getReqIdDescClass() {
		return reqIdDescClass;
	}
	public void setReqIdDescClass(String reqIdDescClass) {
		this.reqIdDescClass = reqIdDescClass;
	}
	public String getReqYmdhmsAscClass() {
		return reqYmdhmsAscClass;
	}
	public void setReqYmdhmsAscClass(String reqYmdhmsAscClass) {
		this.reqYmdhmsAscClass = reqYmdhmsAscClass;
	}
	public String getReqYmdhmsDescClass() {
		return reqYmdhmsDescClass;
	}
	public void setReqYmdhmsDescClass(String reqYmdhmsDescClass) {
		this.reqYmdhmsDescClass = reqYmdhmsDescClass;
	}
	public String getReqSbtAscClass() {
		return reqSbtAscClass;
	}
	public void setReqSbtAscClass(String reqSbtAscClass) {
		this.reqSbtAscClass = reqSbtAscClass;
	}
	public String getReqSbtDescClass() {
		return reqSbtDescClass;
	}
	public void setReqSbtDescClass(String reqSbtDescClass) {
		this.reqSbtDescClass = reqSbtDescClass;
	}
	public String getReqTypeAscClass() {
		return reqTypeAscClass;
	}
	public void setReqTypeAscClass(String reqTypeAscClass) {
		this.reqTypeAscClass = reqTypeAscClass;
	}
	public String getReqTypeDescClass() {
		return reqTypeDescClass;
	}
	public void setReqTypeDescClass(String reqTypeDescClass) {
		this.reqTypeDescClass = reqTypeDescClass;
	}
	public String getReqStsAscClass() {
		return reqStsAscClass;
	}
	public void setReqStsAscClass(String reqStsAscClass) {
		this.reqStsAscClass = reqStsAscClass;
	}
	public String getReqStsDescClass() {
		return reqStsDescClass;
	}
	public void setReqStsDescClass(String reqStsDescClass) {
		this.reqStsDescClass = reqStsDescClass;
	}
	public String getSbtAscClass() {
		return sbtAscClass;
	}
	public void setSbtAscClass(String sbtAscClass) {
		this.sbtAscClass = sbtAscClass;
	}
	public String getSbtDescClass() {
		return sbtDescClass;
	}
	public void setSbtDescClass(String sbtDescClass) {
		this.sbtDescClass = sbtDescClass;
	}
	public String getReqJgiNameAscClass() {
		return reqJgiNameAscClass;
	}
	public void setReqJgiNameAscClass(String reqJgiNameAscClass) {
		this.reqJgiNameAscClass = reqJgiNameAscClass;
	}
	public String getReqJgiNameDescClass() {
		return reqJgiNameDescClass;
	}
	public void setReqJgiNameDescClass(String reqJgiNameDescClass) {
		this.reqJgiNameDescClass = reqJgiNameDescClass;
	}

    /**
	 * 担当先コンボを設定します。
	 * @param searchInsChgCombo 担当先コンボ
	 */
	public void setSearchInsChgCombo(LinkedHashMap searchInsChgCombo) {
	    this.searchInsChgCombo = searchInsChgCombo;
	}

    /**
	 * NC011DTO.javareqFlgを設定
	 * @return reqFlg
	 */
	public String getReqFlg() {
		return reqFlg;
	}
	/**
	 * @param reqFlg セットする reqFlg
	 */
	public void setReqFlg(String reqFlg) {
		this.reqFlg = reqFlg;
	}
	/**
	 * NC011DTO.javajokenFlgを設定
	 * @return jokenFlg
	 */
	public String getJokenFlg() {
		return jokenFlg;
	}
	/**
	 * @param jokenFlg セットする jokenFlg
	 */
	public void setJokenFlg(String jokenFlg) {
		this.jokenFlg = jokenFlg;
	}

	public String getJgiNo() {
		return jgiNo;
	}
	public void setJgiNo(String jgiNo) {
		this.jgiNo = jgiNo;
	}
	public String getJgiName() {
		return jgiName;
	}
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	/**
	 * 親画面から受け取るMR/管理者のflagを取得します。
	 * @return 親画面から受け取るMR/管理者のflag
	 */
	public String getMrAdminCd() {
		return mrAdminCd;
	}
	/**
	 * 親画面から受け取るMR/管理者のflagを設定します。
	 * @param mrAdminCd 親画面から受け取るMR/管理者のflag
	 */
	public void setMrAdminCd(String mrAdminCd) {
		this.mrAdminCd = mrAdminCd;
	}

	/**
	 * 管理者/MR判定
	 */
    private String mrAdminFlg;

    /**
	 * 管理者/MR判定を取得します。
	 * @return 管理者/MR判定
	 */
	public String getMrAdminFlg() {
		return mrAdminFlg;
	}
	/**
	 * 管理者/MR判定を設定します。
	 * @param mrAdminFlg 管理者/MR判定
	 */
	public void setMrAdminFlg(String mrAdminFlg) {
		this.mrAdminFlg = mrAdminFlg;
	}
	/**
	 * Offset値を取得します。
	 * @return Offset値
	 */
	public Integer getInOffset
	() {
	    return this.inOffset;
	}
	/**
	 * Offset値を設定します。
	 * @param inOffset Offset値
	 */
	public void setInOffset(Integer inOffset) {
	    this.inOffset = inOffset;
	}
	/**
	 * Limit値を取得します。
	 * @return Limit値
	 */
	public Integer getInLimit
	() {
	    return this.inLimit;
	}
	/**
	 * Limit値を設定します。
	 * @param inLimit Limit値
	 */
	public void setInLimit(Integer inLimit) {
	    this.inLimit = inLimit;
	}

	/**
	 * 審査flagを取得します。
	 * @return 審査flag
	 */
	public String getShnFlg() {
		return shnFlg;
	}
	/**
	 * 審査flagを設定します。
	 * @param shnFlg 審査flag
	 */
	public void setShnFlg(String shnFlg) {
		this.shnFlg = shnFlg;
	}

	/**
	 * 審査日時を取得します。
	 * @return 審査日時
	 */
	public String getShnYmdhms() {
		return shnYmdhms;
	}
	/**
	 * 審査日時を設定します。
	 * @param shnYmdhms 審査日時
	 */
	public void setShnYmdhms(String shnYmdhms) {
		this.shnYmdhms = shnYmdhms;
	}
	/**
	 * 審査者名を取得します。
	 * @return 審査者名
	 */
	public String getShnShaId() {
		return shnShaId;
	}
	/**
	 * 審査者名を設定します。
	 * @param shnShaId 審査者名
	 */
	public void setShnShaId(String shnShaId) {
		this.shnShaId = shnShaId;
	}

	/**
	 * FB申請要否を取得します。
	 * @return FB申請要否
	 */
	public String getFbReqFlg() {
		return fbReqFlg;
	}
	/**
	 * FB申請要否を設定します。
	 * @param fbReqFlg FB申請要否
	 */
	public void setFbReqFlg(String fbReqFlg) {
		this.fbReqFlg = fbReqFlg;
	}

	/**
	 * FB回答IDを取得します。
	 * @return FB回答ID
	 */
	public String getFbAnsId() {
		return fbAnsId;
	}
	/**
	 * FB回答IDを設定します。
	 * @param fbAnsId FB回答ID
	 */
	public void setFbAnsId(String fbAnsId) {
		this.fbAnsId = fbAnsId;
	}

	/**
	 * FB処理区分を取得します。
	 * @return FB処理区分
	 */
	public String getFbPrcType() {
		return fbPrcType;
	}
	/**
	 * FB処理区分を設定します。
	 * @param fbPrcType FB処理区分
	 */
	public void setFbPrcType(String fbPrcType) {
		this.fbPrcType = fbPrcType;
	}

	/**
	 * メッセージ中身を取得します。
	 * @return メッセージ中身
	 */
	public String getMsgStr() {
		return msgStr;
	}
	/**
	 * メッセージ中身を設定します。
	 * @param msgStr メッセージ中身
	 */
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	/**
	 * メッセージ中身を取得します。
	 * @param w009
	 * @param
	 * @return メッセージ中身
	 */
	public String getMsgData(String w009) {
		return msgData;
	}
	/**
	 * メッセージ中身を設定します。
	 * @param msgStr メッセージ中身
	 */
	public void setMsgData(String msgData) {
		this.msgData = msgData;
	}



    public String getKnYmdhmsFrom() {
		return knYmdhmsFrom;
	}
	public void setKnYmdhmsFrom(String knYmdhmsFrom) {
		this.knYmdhmsFrom = knYmdhmsFrom;
	}
	public String getKnYmdhmsTo() {
		return knYmdhmsTo;
	}
	public void setKnYmdhmsTo(String knYmdhmsTo) {
		this.knYmdhmsTo = knYmdhmsTo;
	}



	    /**
		 * 施設名-検索用を取得します。
		 * @return 施設名-検索用
		 */
		public String getInsKanjiSrch() {
			return insKanjiSrch;
		}
	/**
	 * 施設名-検索用を設定します。
	 * @param insKanjiSrch 施設名-検索用
	 */
	public void setInsKanjiSrch(String insKanjiSrch) {
		this.insKanjiSrch = insKanjiSrch;
	}



    public String getBumonRank() {
		return bumonRank;
	}
	public void setBumonRank(String bumonRank) {
		this.bumonRank = bumonRank;
	}


	public String getSosCd() {
		return sosCd;
	}
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}



	public String getBumonRyakuName() {
		return bumonRyakuName;
	}
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
	}

    /**
	 * brCodeを取得します。
	 * @return brCode
	 */
	public String getBrCode() {
		return brCode;
	}
	/**
	 * brCodeを設定します。
	 * @param brCode reqBrCode
	 */
	public void setReqBrCode(String brCode) {
		this.brCode = brCode;
	}
	/**
	 * distCodeを取得します。
	 * @return distCode
	 */
	public String getDistCode() {
		return distCode;
	}
	/**
	 * distCodeを設定します。
	 * @param distCode distCode
	 */
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}


	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public String getTest() {
		return test;
	}
	/**
	 * @generatedを設定します。
	 * @param test @generated
	 */
	public void setTest(String test) {
		this.test = test;
	}
	/**
	 * rEQ_IDを取得します。
	 * @return rEQ_ID
	 */
	public String getReqId() {
	    return reqId;
	}
	/**
	 * rEQ_IDを設定します。
	 * @param reqId rEQ_ID
	 */
	public void setReqId(String reqId) {
	    this.reqId = reqId;
	}
	/**
	 * 検索-申請日時を取得します。
	 * @return 検索-申請日時
	 */
	public String getInreqYmdhmsFrom() {
	   return inreqYmdhmsFrom;
	}
	/**
	 * 検索-申請日時を設定します。
	 * @param inreqYmdhmsFrom 検索-申請日時
	 */
	public void setInreqYmdhmsFrom(String inreqYmdhmsFrom) {
	   this.inreqYmdhmsFrom = inreqYmdhmsFrom;
	}
	/**
	 * 検索-申請日時を取得します。
	 * @return 検索-申請日時
	 */
	public String getInreqYmdhmsTo() {
	   return inreqYmdhmsTo;
	}
	/**
	 * 検索-申請日時を設定します。
	 * @param inreqYmdhmsTo 検索-申請日時
	 */
	public void setInreqYmdhmsTo(String inreqYmdhmsTo) {
	   this.inreqYmdhmsTo = inreqYmdhmsTo;
	}
	/**
	 * reqYmdhmsFromを取得します。
	 * @return reqYmdhmsFrom
	 */
	public String getReqYmdhmsFrom() {
	    return reqYmdhmsFrom;
	}
	/**
	 * reqYmdhmsFromを設定します。
	 * @param reqYmdhmsFrom reqYmdhmsFrom
	 */
	public void setReqYmdhmsFrom(String reqYmdhmsFrom) {
	    this.reqYmdhmsFrom = reqYmdhmsFrom;
	}
	/**
	 * reqYmdhmsToを取得します。
	 * @return reqYmdhmsTo
	 */
	public String getReqYmdhmsTo() {
	    return reqYmdhmsTo;
	}
	/**
	 * reqYmdhmsToを設定します。
	 * @param reqYmdhmsTo reqYmdhmsTo
	 */
	public void setReqYmdhmsTo(String reqYmdhmsTo) {
	    this.reqYmdhmsTo = reqYmdhmsTo;
	}
	/**
	 * reqChlを取得します。
	 * @return reqChl
	 */
	public String getReqChl() {
	    return reqChl;
	}
	/**
	 * reqChlを設定します。
	 * @param reqChl reqChl
	 */
	public void setReqChl(String reqChl) {
	    this.reqChl = reqChl;
	}
	/**
	 * 検索-種別を取得します。
	 * @return 検索-種別
	 */
	public String getReqType() {
	    return reqType;
	}
	/**
	 * 検索-種別を設定します。
	 * @param reqType 検索-種別
	 */
	public void setReqType(String reqType) {
	   this.reqType = reqType;
	}
	/**
	 * reqStsを取得します。
	 * @return reqSts
	 */
	public String getReqSts() {
	    return reqSts;
	}
	/**
	 * reqStsを設定します。
	 * @param reqSts reqSts
	 */
	public void setReqSts(String reqSts) {
	   this.reqSts = reqSts;
	}
	/**
	 * insNoを取得します。
	 * @return insNo
	 */
	public String getInsNo() {
	    return insNo;
	}
	/**
	 * insNoを設定します。
	 * @param insNo insNo
	 */
	public void setInsNo(String insNo) {
	   this.insNo = insNo;
	}
	/**
	 * docNoを取得します。
	 * @return docNo
	 */
	public String getDocNo() {
		return docNo;
	}
	/**
	 * docNoを設定します。
	 * @param docNo docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	/**
	 * insClassを取得します。
	 * @return insClass
	 */
	public String getInsClass() {
	  return insClass;
	}
	/**
	 * insClassを設定します。
	 * @param insClass insClass
	 */
	public void setInsClass(String insClass) {
	 this.insClass = insClass;
	}
	/**
	 * insSbtを取得します。
	 * @return insSbt
	 */
	public String getInsSbt() {
	   return insSbt;
	}
	/**
	 * insSbtを設定します。
	 * @param insSbt insSbt
	 */
	public void setInsSbt(String insSbt) {
	  this.insSbt = insSbt;
	}
	/**
	 * reqStsを取得します。
	 * @return reqSts
	 */
	public String getDocType() {
		return docType;
	}
	/**
	 * reqStsを設定します。
	 * @param docType reqSts
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}
	/**
	 * hoInsTypeを取得します。
	 * @return hoInsType
	 */
	public String getHoInsType() {
	    return hoInsType;
	}
	/**
	 * hoInsTypeを設定します。
	 * @param hoInsType hoInsType
	 */
	public void setHoInsType(String hoInsType) {
	   this.hoInsType = hoInsType;
	}
	/**
	 * insFormalNameを取得します。
	 * @return insFormalName
	 */
	public String getInsFormalName() {
	    return insFormalName;
	}
	/**
	 * insFormalNameを設定します。
	 * @param insFormalName insFormalName
	 */
	public void setInsFormalName(String insFormalName) {
	   this.insFormalName = insFormalName;
	}
	/**
	 * docKanjを取得します。
	 * @return docKanj
	 */
	public String getDocKanj() {
		return docKanj;
	}
	/**
	 * docKanjを設定します。
	 * @param docKanj docKanj
	 */
	public void setDocKanj(String docKanj) {
		this.docKanj = docKanj;
	}
	/**
	 * jobForm 勤務形態を取得します。
	 * @return jobForm 勤務形態
	 */
	public String getJobForm() {
		return jobForm;
	}
	/**
	 * jobForm 勤務形態を設定します。
	 * @param jobForm jobForm 勤務形態
	 */
	public void setJobForm(String jobForm) {
		this.jobForm = jobForm;
	}
	/**
	 * reqJgiNameを取得します。
	 * @return reqJgiName
	 */
	public String getReqJgiName() {
	    return reqJgiName;
	}
	/**
	 * reqJgiNameを設定します。
	 * @param reqJgiName reqJgiName
	 */
	public void setReqJgiName(String reqJgiName) {
	   this.reqJgiName = reqJgiName;
	}
	/**
	 * reqJgiNoを取得します。
	 * @return reqJgiNo
	 */
	public String getReqJgiNo() {
		return reqJgiNo;
	}
	/**
	 * reqJgiNoを設定します。
	 * @param reqJgiNo reqJgiNo
	 */
	public void setReqJgiNo(String reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}
	/**
	 * reqShzを取得します。
	 * @return reqShz
	 */
	public String getReqShz() {
	    return reqShz;
	}
	/**
	 * reqShzを設定します。
	 * @param reqShz reqShz
	 */
	public void setReqShz(String reqShz) {
	   this.reqShz = reqShz;
	}
	/**
	 * reqCommentを設定します。
	 * @param reqComment reqComment
	 */
	public void setReqComment(String reqComment) {
	  this.reqComment = reqComment;
	}
	/**
	 * reqCommentを取得します。
	 * @return reqComment
	 */
	public String getReqComment() {
	  return reqComment;
	}
	/**
     * 検索条件_承認日時
     */
    public String getAPR_YMDHMS() {
        return aPR_YMDHMS;
    }
    /**
    * 承認日時の設定
    * @param sysCd 承認日時
    */
   public void setAPR_YMDHMS(String aPR_YMDHMS) {
       this.aPR_YMDHMS = aPR_YMDHMS;
   }
    /**
     * 検索条件_承認者
     */
    public String getAPR_SHA_ID() {
        return aPR_SHA_ID;
    }
    /**
    * 承認者の設定
    * @param sysCd 承認者
    */
   public void setAPR_SHA_ID(String aPR_SHA_ID) {
       this.aPR_SHA_ID = aPR_SHA_ID;
   }
    /**
     * 検索条件_審査・承認メモ
     */
    public String getAPR_MEMO() {
        return aPR_MEMO;
    }
    /**
    * 審査・承認メモの設定
    * @param sysCd 審査・承認メモ
    */
   public void setAPR_MEMO(String aPR_MEMO) {
       this.aPR_MEMO = aPR_MEMO;
   }
    /**
	 * aPR_COMMNETを取得します。
	 * @return aPR_COMMNET
	 */
	public String getAprComment() {
	    return aprComment;
	}
	/**
	 * aPR_COMMNETを設定します。
	 * @param aprComment aPR_COMMNET
	 */
	public void setAprComment(String aprComment) {
	   this.aprComment = aprComment;
	}
	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NC011DTO() {
        setForward(NC011);
    }

    // START UOC

    // END UOC

    /**
     * JIS府県-検索をセットする
     * @param JIS府県-検索
     * @generated
     */
    public void setADdrCodePref(String aDdrCodePref){
        this.aDdrCodePref = aDdrCodePref;
    }

    /**
     * JIS府県-検索を返す
     * @return JIS府県-検索
     * @generated
     */
    public String getADdrCodePref(){
        return aDdrCodePref;
    }
    /**
	 * 検索-種別を設定します。
	 * @param sbt 検索-種別
	 */
	public void setSbt(String sbt){
	    this.sbt = sbt;
	}
	/**
	 * 検索-種別を取得します。
	 * @return 検索-種別
	 */
	public String getSbt(){
	    return sbt;
	}
	/**
	 * 検索-連携種別を設定します。
	 * @param reqSbt 検索-連携種別
	 */
	public void setReqSbt(String reqSbt){
	    this.reqSbt = reqSbt;
	}
	/**
	 * 検索-連携種別を取得します。
	 * @return 検索-連携種別
	 */
	public String getReqSbt(){
	    return reqSbt;
	}
	/**
	 * このDTOが関連付けられている画面IDを設定します。
	 * @param screenID このDTOが関連付けられている画面ID
	 */
	public void setNC011(String screenID){
	    this.NC011 = screenID;
	}
	/**
	 * このDTOが関連付けられている画面IDを取得します。
	 * @return このDTOが関連付けられている画面ID
	 */
	public String getNC011(){
	    return NC011;
	}
	/**
	 * 親画面コールバックメソッド名を取得します。
	 * @return 親画面コールバックメソッド名
	 */
	public String getCallBack() {
	    return callBack;
	}
	/**
	 * 親画面コールバックメソッド名を設定します。
	 * @param callBack 親画面コールバックメソッド名
	 */
	public void setCallBack(String callBack) {
	    this.callBack = callBack;
	}
	/**
	 * 親画面名を取得します。
	 * @return 親画面名
	 */
	public String getWinVarName() {
	    return winVarName;
	}
	/**
	 * 親画面名を設定します。
	 * @param winVarName 親画面名
	 */
	public void setWinVarName(String winVarName) {
	    this.winVarName = winVarName;
	}
	/**
	 * 呼び出し元のClear処理メソッド名を取得します。
	 * @return 呼び出し元のClear処理メソッド名
	 */
	public String getParentClearProc() {
	    return parentClearProc;
	}
	/**
	 * 呼び出し元のClear処理メソッド名を設定します。
	 * @param parentClearProc 呼び出し元のClear処理メソッド名
	 */
	public void setParentClearProc(String parentClearProc) {
	    this.parentClearProc = parentClearProc;
	}
	/**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    /**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosAddrMap() {
	    return jkrSosAddrMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosAddrMap @generated
	 */
	public void setJkrSosAddrMap(LinkedHashMap jkrSosAddrMap) {
	    this.jkrSosAddrMap = jkrSosAddrMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosReqSbtMap() {
	    return jkrSosReqSbtMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosReqSbtMap @generated
	 */
	public void setJkrSosReqSbtMap(LinkedHashMap jkrSosReqSbtMap) {
	    this.jkrSosReqSbtMap = jkrSosReqSbtMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosSbtMap() {
	    return jkrSosSbtMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosSbtMap @generated
	 */
	public void setJkrSosSbtMap(LinkedHashMap jkrSosSbtMap) {
	    this.jkrSosSbtMap = jkrSosSbtMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosReqTypeMap() {
	    return jkrSosReqTypeMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosReqTypeMap @generated
	 */
	public void setJkrSosReqTypeMap(LinkedHashMap jkrSosReqTypeMap) {
	    this.jkrSosReqTypeMap = jkrSosReqTypeMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosReqStsMap() {
	    return jkrSosReqStsMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosReqStsMap @generated
	 */
	public void setJkrSosReqStsMap(LinkedHashMap jkrSosReqStsMap) {
	    this.jkrSosReqStsMap = jkrSosReqStsMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosInsClassMap() {
	    return jkrSosInsClassMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosInsClassMap @generated
	 */
	public void setJkrSosInsClassMap(LinkedHashMap jkrSosInsClassMap) {
	    this.jkrSosInsClassMap = jkrSosInsClassMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosInsSbtMap() {
	    return jkrSosInsSbtMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosInsSbtMap @generated
	 */
	public void setJkrSosInsSbtMap(LinkedHashMap jkrSosInsSbtMap) {
	    this.jkrSosInsSbtMap = jkrSosInsSbtMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosDocTypeMap() {
		return jkrSosDocTypeMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosDocTypeMap @generated
	 */
	public void setJkrSosDocTypeMap(LinkedHashMap jkrSosDocTypeMap) {
		this.jkrSosDocTypeMap = jkrSosDocTypeMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosJobFormMap() {
		return jkrSosJobFormMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosJobFormMap @generated
	 */
	public void setJkrSosJobFormMap(LinkedHashMap jkrSosJobFormMap) {
		this.jkrSosJobFormMap = jkrSosJobFormMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosReqChlMap() {
		return jkrSosReqChlMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosReqChlMap @generated
	 */
	public void setJkrSosReqChlMap(LinkedHashMap jkrSosReqChlMap) {
		this.jkrSosReqChlMap = jkrSosReqChlMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public LinkedHashMap getJkrSosHoInsTypeMap() {
	    return jkrSosHoInsTypeMap;
	}
	/**
	 * @generatedを設定します。
	 * @param jkrSosHoInsTypeMap @generated
	 */
	public void setJkrSosHoInsTypeMap(LinkedHashMap jkrSosHoInsTypeMap) {
	    this.jkrSosHoInsTypeMap = jkrSosHoInsTypeMap;
	}
	/**
	 * @generatedを取得します。
	 * @return @generated
	 */
	public List<CatSnseiComboDataList> getCatSnseiComboDataList() {
	return catSnseiComboDataList;
	}
	/**
	 * @generatedを設定します。
	 * @param catSnseiComboDataList @generated
	 */
	public void setCatSnseiComboDataList(List<CatSnseiComboDataList> catSnseiComboDataList) {
	this.catSnseiComboDataList = catSnseiComboDataList;
	}

	/*
	 * */


	public boolean isKensakuBool() {
		return isKensakuBool;
	}
	public void setKensakuBool(boolean isKensakuBool) {
		this.isKensakuBool = isKensakuBool;
	}



	public String getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}
}
