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
public class NM001DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NM001 = "NM001";

    private String boolKnb;



	public String getBoolKnb() {
		return boolKnb;
	}
	public void setBoolKnb(String boolKnb) {
		this.boolKnb = boolKnb;
	}

	/**
     * 親画面コールバックメソッド名
     * @generated
     */
    private String callBack;

    /**
     * 遷移元画面ID
     */
	private String preScreenId;
	public String getPreScreenId() {
		return preScreenId;
	}

	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

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
     * 検索-種別
     * @generated
     */
    private String reqType;






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
     * 検索-JIS都道府県コード
     * @generated
     */
    private String addrCodePref;
	/**
     * 検索-JIS都道府県名
     * @generated
     */
    private String addrNamePref;
	/**
     * 検索-列キー
     * @generated
     */
    private String key;
	/**
     * 検索-並び順
     * @generated
     */
    private String sort;
	/**
     * 検索-申請カウント
     * @generated
     */
    private String reqCount;
	/**
     * 検索-申請カウント施設新規承認待ち（管理者）
     * @generated
     */
    private String reqCountSsAd;
	/**
     * 検索-申請カウント施設新規承認待ち（MR）
     * @generated
     */
    private String reqCountSsMr;
	/**
     * 検索-申請カウント施設新規ULT申請待ち（管理者）
     * @generated
     */
    private String reqCountSsUr;
	/**
     * 検索-申請カウント施設新規ULT承認待ち（管理者）
     * @generated
     */
    private String reqCountSsUs;
	/**
     * 検索-申請カウント施設更新承認待ち（管理者）
     * @generated
     */
    private String reqCountScAd;
	/**
     * 検索-申請カウント施設更新承認待ち（MR）
     * @generated
     */
    private String reqCountScMr;
	/**
     * 検索-申請カウント施設更新ULT申請待ち（管理者）
     * @generated
     */
    private String reqCountScUr;
	/**
     * 検索-申請カウント施設更新ULT承認待ち（管理者）
     * @generated
     */
    private String reqCountScUs;
	/**
     * 検索-申請カウント施設削除承認待ち（管理者）
     * @generated
     */
    private String reqCountSdAd;
	/**
     * 検索-申請カウント施設削除承認待ち（MR）
     * @generated
     */
    private String reqCountSdMr;
	/**
     * 検索-申請カウント施設削除ULT申請待ち（管理者）
     * @generated
     */
    private String reqCountSdUr;
	/**
     * 検索-申請カウント施設削除ULT承認待ち（管理者）
     * @generated
     */
    private String reqCountSdUs;
	/**
     * 検索-申請カウント施設領域別親子紐付け(当期)承認待ち（管理者）
     * @generated
     */
    private String reqCountRnAd;
	/**
     * 検索-申請カウント施設領域別親子紐付け(当期)承認待ち（MR）
     * @generated
     */
    private String reqCountRnMr;
	/**
     * 検索-申請カウント施設復活承認待ち（管理者）
     * @generated
     */
    private String reqCountShAd;
	/**
     * 検索-申請カウント施設復活承認待ち（MR）
     * @generated
     */
    private String reqCountShMr;
	/**
     * 検索-申請カウント医師新規承認待ち（管理者）
     * @generated
     */
    private String reqCountDsAd;
	/**
     * 検索-申請カウント医師新規承認待ち（MR）
     * @generated
     */
    private String reqCountDsMr;
	/**
     * 検索-申請カウント医師新規ULT申請待ち（管理者）
     * @generated
     */
    private String reqCountDsUr;
	/**
     * 検索-申請カウント医師新規ULT承認待ち（管理者）
     * @generated
     */
    private String reqCountDsUs;
	/**
     * 検索-申請カウント医師削除承認待ち（管理者）
     * @generated
     */
    private String reqCountDdAd;
	/**
     * 検索-申請カウント医師削除承認待ち（MR）
     * @generated
     */
    private String reqCountDdMr;
	/**
     * 検索-申請カウント医師削除ULT申請待ち（管理者）
     * @generated
     */
    private String reqCountDdUr;
	/**
     * 検索-申請カウント医師削除ULT承認待ち（管理者）
     * @generated
     */
    private String reqCountDdUs;
	/**
     * 検索-申請カウント医師復活承認待ち（管理者）
     * @generated
     */
    private String reqCountDhAd;
	/**
     * 検索-申請カウント医師復活承認待ち（MR）
     * @generated
     */
    private String reqCountDhMr;
	/**
     * 検索-申請カウント　医師復活ULT承認待ち（管理者）
     * @generated
     */
    private String reqCountDhUr;
	/**
     * 検索-申請カウント　医師復活ULT承認待ち（MR）
     * @generated
     */
    private String reqCountDhUs;
	/**
     * 検索-申請カウント　施設更新（来期）承認待ち（管理者）
     * @generated
     */
    private String reqCountSuAd;
	/**
     * 検索-申請カウント　施設更新（来期）承認待ち（MR）
     * @generated
     */
    private String reqCountSuMr;
	/**
     * 検索-申請カウント　施設更新（来期）ULT申請待ち（管理者）
     * @generated
     */
    private String reqCountSuUr;
	/**
     * 検索-申請カウント　施設更新（来期）ULT承認待ち（管理者）
     * @generated
     */
    private String reqCountSuUs;
	/**
     * 検索-申請カウント　施設武田紐親子紐付け(来期)承認待ち（管理者）
     * @generated
     */
    private String reqCountTsAd;
	/**
     * 検索-申請カウント　施設武田紐親子紐付け(来期)承認待ち（MR）
     * @generated
     */
    private String reqCountTsMr;

	public String getAddrCodePref() {
		return addrCodePref;
	}
	public void setAddrCodePref(String addrCodePref) {
		this.addrCodePref = addrCodePref;
	}
	public String getAddrNamePref() {
		return addrNamePref;
	}
	public void setAddrNamePref(String addrNamePref) {
		this.addrNamePref = addrNamePref;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getReqCount() {
		return reqCount;
	}
	public void setReqCount(String reqCount) {
		this.reqCount = reqCount;
	}


	public String getReqCountSsAd() {
		return reqCountSsAd;
	}
	public void setReqCountSsAd(String reqCountSsAd) {
		this.reqCountSsAd = reqCountSsAd;
	}
	public String getReqCountSsMr() {
		return reqCountSsMr;
	}
	public void setReqCountSsMr(String reqCountSsMr) {
		this.reqCountSsMr = reqCountSsMr;
	}
	public String getReqCountSsUr() {
		return reqCountSsUr;
	}
	public void setReqCountSsUr(String reqCountSsUr) {
		this.reqCountSsUr = reqCountSsUr;
	}
	public String getReqCountSsUs() {
		return reqCountSsUs;
	}
	public void setReqCountSsUs(String reqCountSsUs) {
		this.reqCountSsUs = reqCountSsUs;
	}
	public String getReqCountScAd() {
		return reqCountScAd;
	}
	public void setReqCountScAd(String reqCountScAd) {
		this.reqCountScAd = reqCountScAd;
	}
	public String getReqCountScMr() {
		return reqCountScMr;
	}
	public void setReqCountScMr(String reqCountScMr) {
		this.reqCountScMr = reqCountScMr;
	}
	public String getReqCountScUr() {
		return reqCountScUr;
	}
	public void setReqCountScUr(String reqCountScUr) {
		this.reqCountScUr = reqCountScUr;
	}
	public String getReqCountScUs() {
		return reqCountScUs;
	}
	public void setReqCountScUs(String reqCountScUs) {
		this.reqCountScUs = reqCountScUs;
	}
	public String getReqCountSdAd() {
		return reqCountSdAd;
	}
	public void setReqCountSdAd(String reqCountSdAd) {
		this.reqCountSdAd = reqCountSdAd;
	}
	public String getReqCountSdMr() {
		return reqCountSdMr;
	}
	public void setReqCountSdMr(String reqCountSdMr) {
		this.reqCountSdMr = reqCountSdMr;
	}
	public String getReqCountSdUr() {
		return reqCountSdUr;
	}
	public void setReqCountSdUr(String reqCountSdUr) {
		this.reqCountSdUr = reqCountSdUr;
	}
	public String getReqCountSdUs() {
		return reqCountSdUs;
	}
	public void setReqCountSdUs(String reqCountSdUs) {
		this.reqCountSdUs = reqCountSdUs;
	}
	public String getReqCountRnAd() {
		return reqCountRnAd;
	}
	public void setReqCountRnAd(String reqCountRnAd) {
		this.reqCountRnAd = reqCountRnAd;
	}
	public String getReqCountRnMr() {
		return reqCountRnMr;
	}
	public void setReqCountRnMr(String reqCountRnMr) {
		this.reqCountRnMr = reqCountRnMr;
	}
	public String getReqCountShAd() {
		return reqCountShAd;
	}
	public void setReqCountShAd(String reqCountShAd) {
		this.reqCountShAd = reqCountShAd;
	}
	public String getReqCountShMr() {
		return reqCountShMr;
	}
	public void setReqCountShMr(String reqCountShMr) {
		this.reqCountShMr = reqCountShMr;
	}
	public String getReqCountDsAd() {
		return reqCountDsAd;
	}
	public void setReqCountDsAd(String reqCountDsAd) {
		this.reqCountDsAd = reqCountDsAd;
	}
	public String getReqCountDsMr() {
		return reqCountDsMr;
	}
	public void setReqCountDsMr(String reqCountDsMr) {
		this.reqCountDsMr = reqCountDsMr;
	}
	public String getReqCountDsUr() {
		return reqCountDsUr;
	}
	public void setReqCountDsUr(String reqCountDsUr) {
		this.reqCountDsUr = reqCountDsUr;
	}
	public String getReqCountDsUs() {
		return reqCountDsUs;
	}
	public void setReqCountDsUs(String reqCountDsUs) {
		this.reqCountDsUs = reqCountDsUs;
	}
	public String getReqCountDdAd() {
		return reqCountDdAd;
	}
	public void setReqCountDdAd(String reqCountDdAd) {
		this.reqCountDdAd = reqCountDdAd;
	}
	public String getReqCountDdMr() {
		return reqCountDdMr;
	}
	public void setReqCountDdMr(String reqCountDdMr) {
		this.reqCountDdMr = reqCountDdMr;
	}
	public String getReqCountDdUr() {
		return reqCountDdUr;
	}
	public void setReqCountDdUr(String reqCountDdUr) {
		this.reqCountDdUr = reqCountDdUr;
	}
	public String getReqCountDdUs() {
		return reqCountDdUs;
	}
	public void setReqCountDdUs(String reqCountDdUs) {
		this.reqCountDdUs = reqCountDdUs;
	}
	public String getReqCountDhAd() {
		return reqCountDhAd;
	}
	public void setReqCountDhAd(String reqCountDhAd) {
		this.reqCountDhAd = reqCountDhAd;
	}
	public String getReqCountDhMr() {
		return reqCountDhMr;
	}
	public void setReqCountDhMr(String reqCountDhMr) {
		this.reqCountDhMr = reqCountDhMr;
	}
	public String getReqCountDhUr() {
		return reqCountDhUr;
	}
	public void setReqCountDhUr(String reqCountDhUr) {
		this.reqCountDhUr = reqCountDhUr;
	}
	public String getReqCountDhUs() {
		return reqCountDhUs;
	}
	public void setReqCountDhUs(String reqCountDhUs) {
		this.reqCountDhUs = reqCountDhUs;
	}
	public String getReqCountSuAd() {
		return reqCountSuAd;
	}
	public void setReqCountSuAd(String reqCountSuAd) {
		this.reqCountSuAd = reqCountSuAd;
	}
	public String getReqCountSuMr() {
		return reqCountSuMr;
	}
	public void setReqCountSuMr(String reqCountSuMr) {
		this.reqCountSuMr = reqCountSuMr;
	}
	public String getReqCountSuUr() {
		return reqCountSuUr;
	}
	public void setReqCountSuUr(String reqCountSuUr) {
		this.reqCountSuUr = reqCountSuUr;
	}
	public String getReqCountSuUs() {
		return reqCountSuUs;
	}
	public void setReqCountSuUs(String reqCountSuUs) {
		this.reqCountSuUs = reqCountSuUs;
	}
	public String getReqCountTsAd() {
		return reqCountTsAd;
	}
	public void setReqCountTsAd(String reqCountTsAd) {
		this.reqCountTsAd = reqCountTsAd;
	}
	public String getReqCountTsMr() {
		return reqCountTsMr;
	}
	public void setReqCountTsMr(String reqCountTsMr) {
		this.reqCountTsMr = reqCountTsMr;
	}

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
	 * メッセージ中身
	 * @generated
	 */
	private String msgData;
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
     * 施設名-検索用
     */
    private String insKanjiSrch;

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

    public String getBumonRank() {
		return bumonRank;
	}
	public void setBumonRank(String bumonRank) {
		this.bumonRank = bumonRank;
	}

    /**
     *組織コード
     */
	private String sosCd;

	public String getSosCd() {
		return sosCd;
	}
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

    /**
     *組織名称
     */
	private String bumonRyakuName;

	public String getBumonRyakuName() {
		return bumonRyakuName;
	}
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
	}


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
     * reqShz
     * @generated
     */

    private String reqShz;


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
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NM001DTO() {
        setForward(NM001);
    }

    // START UOC

    // END UOC


	/**
	 * このDTOが関連付けられている画面IDを設定します。
	 * @param screenID このDTOが関連付けられている画面ID
	 */
	public void setNM001(String screenID){
	    this.NM001 = screenID;
	}
	/**
	 * このDTOが関連付けられている画面IDを取得します。
	 * @return このDTOが関連付けられている画面ID
	 */
	public String getNM001(){
	    return NM001;
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
private boolean isKensakuBool;


public boolean isKensakuBool() {
	return isKensakuBool;
}
public void setKensakuBool(boolean isKensakuBool) {
	this.isKensakuBool = isKensakuBool;
}

private String pageFlag;

public String getPageFlag() {
	return pageFlag;
}
public void setPageFlag(String pageFlag) {
	this.pageFlag = pageFlag;
}

/**
 * @generated
 */
private List<NM001DTO> NM001DTO = new ArrayList<NM001DTO>();

public List<NM001DTO> getNM001DTO() {
	return NM001DTO;
}
public void setNM001DTO(List<NM001DTO> nM001DTO) {
	NM001DTO = nM001DTO;
}
}
