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
	 * 画面タイトル
	 * @generated
	 */
	private String title;
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
	 * NM001DTO.javatitleを設定
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
     * 検索-申請区分
     * @generated
     */
    private String reqType;
        /**
     * reqChl　申請チャネル
     * @generated
     */

    private String reqChl;

        /**
     * reqSts　申請ステータス
     * @generated
     */

    private String reqSts;


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

    private String reqType1;
    private String reqType2;
    private String reqType3;
    private String reqType4;
    private String reqType5;
    private String reqType6;
    private String reqType7;
    private String reqType8;
    private String reqType9;
    private String reqType10;
    private String reqType11;
    private String reqType12;
    private String reqType13;
    private String reqType14;
    private String reqType15;
    private String reqType16;
    private String reqType17;
    private String reqType18;
    private String reqType19;
    private String reqType20;
    private String reqType21;
    private String reqType22;
    private String reqType23;
    private String reqType24;
    private String reqType25;
    private String reqType26;
    private String reqType27;
    private String reqType28;
    private String reqType29;
    private String reqType30;
    private String reqType31;
    private String reqType32;
    private String reqType33;
    private String reqType34;
    private String reqChl1;
    private String reqChl2;
    private String reqChl3;
    private String reqChl4;
    private String reqChl5;
    private String reqChl6;
    private String reqChl7;
    private String reqChl8;
    private String reqChl9;
    private String reqChl10;
    private String reqChl11;
    private String reqChl12;
    private String reqChl13;
    private String reqChl14;
    private String reqChl15;
    private String reqChl16;
    private String reqChl17;
    private String reqChl18;
    private String reqChl19;
    private String reqChl20;
    private String reqChl21;
    private String reqChl22;
    private String reqChl23;
    private String reqChl24;
    private String reqChl25;
    private String reqChl26;
    private String reqChl27;
    private String reqChl28;
    private String reqChl29;
    private String reqChl30;
    private String reqChl31;
    private String reqChl32;
    private String reqChl33;
    private String reqChl34;
    private String reqSts1;
    private String reqSts2;
    private String reqSts3;
    private String reqSts4;
    private String reqSts5;
    private String reqSts6;
    private String reqSts7;
    private String reqSts8;
    private String reqSts9;
    private String reqSts10;
    private String reqSts11;
    private String reqSts12;
    private String reqSts13;
    private String reqSts14;
    private String reqSts15;
    private String reqSts16;
    private String reqSts17;
    private String reqSts18;
    private String reqSts19;
    private String reqSts20;
    private String reqSts21;
    private String reqSts22;
    private String reqSts23;
    private String reqSts24;
    private String reqSts25;
    private String reqSts26;
    private String reqSts27;
    private String reqSts28;
    private String reqSts29;
    private String reqSts30;
    private String reqSts31;
    private String reqSts32;
    private String reqSts33;
    private String reqSts34;


	public String getReqType1() {
		return reqType1;
	}
	public void setReqType1(String reqType1) {
		this.reqType1 = reqType1;
	}
	public String getReqType2() {
		return reqType2;
	}
	public void setReqType2(String reqType2) {
		this.reqType2 = reqType2;
	}
	public String getReqType3() {
		return reqType3;
	}
	public void setReqType3(String reqType3) {
		this.reqType3 = reqType3;
	}
	public String getReqType4() {
		return reqType4;
	}
	public void setReqType4(String reqType4) {
		this.reqType4 = reqType4;
	}
	public String getReqType5() {
		return reqType5;
	}
	public void setReqType5(String reqType5) {
		this.reqType5 = reqType5;
	}
	public String getReqType6() {
		return reqType6;
	}
	public void setReqType6(String reqType6) {
		this.reqType6 = reqType6;
	}
	public String getReqType7() {
		return reqType7;
	}
	public void setReqType7(String reqType7) {
		this.reqType7 = reqType7;
	}
	public String getReqType8() {
		return reqType8;
	}
	public void setReqType8(String reqType8) {
		this.reqType8 = reqType8;
	}
	public String getReqType9() {
		return reqType9;
	}
	public void setReqType9(String reqType9) {
		this.reqType9 = reqType9;
	}
	public String getReqType10() {
		return reqType10;
	}
	public void setReqType10(String reqType10) {
		this.reqType10 = reqType10;
	}
	public String getReqType11() {
		return reqType11;
	}
	public void setReqType11(String reqType11) {
		this.reqType11 = reqType11;
	}
	public String getReqType12() {
		return reqType12;
	}
	public void setReqType12(String reqType12) {
		this.reqType12 = reqType12;
	}
	public String getReqType13() {
		return reqType13;
	}
	public void setReqType13(String reqType13) {
		this.reqType13 = reqType13;
	}
	public String getReqType14() {
		return reqType14;
	}
	public void setReqType14(String reqType14) {
		this.reqType14 = reqType14;
	}
	public String getReqType15() {
		return reqType15;
	}
	public void setReqType15(String reqType15) {
		this.reqType15 = reqType15;
	}
	public String getReqType16() {
		return reqType16;
	}
	public void setReqType16(String reqType16) {
		this.reqType16 = reqType16;
	}
	public String getReqType17() {
		return reqType17;
	}
	public void setReqType17(String reqType17) {
		this.reqType17 = reqType17;
	}
	public String getReqType18() {
		return reqType18;
	}
	public void setReqType18(String reqType18) {
		this.reqType18 = reqType18;
	}
	public String getReqType19() {
		return reqType19;
	}
	public void setReqType19(String reqType19) {
		this.reqType19 = reqType19;
	}
	public String getReqType20() {
		return reqType20;
	}
	public void setReqType20(String reqType20) {
		this.reqType20 = reqType20;
	}
	public String getReqType21() {
		return reqType21;
	}
	public void setReqType21(String reqType21) {
		this.reqType21 = reqType21;
	}
	public String getReqType22() {
		return reqType22;
	}
	public void setReqType22(String reqType22) {
		this.reqType22 = reqType22;
	}
	public String getReqType23() {
		return reqType23;
	}
	public void setReqType23(String reqType23) {
		this.reqType23 = reqType23;
	}
	public String getReqType24() {
		return reqType24;
	}
	public void setReqType24(String reqType24) {
		this.reqType24 = reqType24;
	}
	public String getReqType25() {
		return reqType25;
	}
	public void setReqType25(String reqType25) {
		this.reqType25 = reqType25;
	}
	public String getReqType26() {
		return reqType26;
	}
	public void setReqType26(String reqType26) {
		this.reqType26 = reqType26;
	}
	public String getReqType27() {
		return reqType27;
	}
	public void setReqType27(String reqType27) {
		this.reqType27 = reqType27;
	}
	public String getReqType28() {
		return reqType28;
	}
	public void setReqType28(String reqType28) {
		this.reqType28 = reqType28;
	}
	public String getReqType29() {
		return reqType29;
	}
	public void setReqType29(String reqType29) {
		this.reqType29 = reqType29;
	}
	public String getReqType30() {
		return reqType30;
	}
	public void setReqType30(String reqType30) {
		this.reqType30 = reqType30;
	}
	public String getReqType31() {
		return reqType31;
	}
	public void setReqType31(String reqType31) {
		this.reqType31 = reqType31;
	}
	public String getReqType32() {
		return reqType32;
	}
	public void setReqType32(String reqType32) {
		this.reqType32 = reqType32;
	}
	public String getReqType33() {
		return reqType33;
	}
	public void setReqType33(String reqType33) {
		this.reqType33 = reqType33;
	}
	public String getReqType34() {
		return reqType34;
	}
	public void setReqType34(String reqType34) {
		this.reqType34 = reqType34;
	}
	public String getReqChl1() {
		return reqChl1;
	}
	public void setReqChl1(String reqChl1) {
		this.reqChl1 = reqChl1;
	}
	public String getReqChl2() {
		return reqChl2;
	}
	public void setReqChl2(String reqChl2) {
		this.reqChl2 = reqChl2;
	}
	public String getReqChl3() {
		return reqChl3;
	}
	public void setReqChl3(String reqChl3) {
		this.reqChl3 = reqChl3;
	}
	public String getReqChl4() {
		return reqChl4;
	}
	public void setReqChl4(String reqChl4) {
		this.reqChl4 = reqChl4;
	}
	public String getReqChl5() {
		return reqChl5;
	}
	public void setReqChl5(String reqChl5) {
		this.reqChl5 = reqChl5;
	}
	public String getReqChl6() {
		return reqChl6;
	}
	public void setReqChl6(String reqChl6) {
		this.reqChl6 = reqChl6;
	}
	public String getReqChl7() {
		return reqChl7;
	}
	public void setReqChl7(String reqChl7) {
		this.reqChl7 = reqChl7;
	}
	public String getReqChl8() {
		return reqChl8;
	}
	public void setReqChl8(String reqChl8) {
		this.reqChl8 = reqChl8;
	}
	public String getReqChl9() {
		return reqChl9;
	}
	public void setReqChl9(String reqChl9) {
		this.reqChl9 = reqChl9;
	}
	public String getReqChl10() {
		return reqChl10;
	}
	public void setReqChl10(String reqChl10) {
		this.reqChl10 = reqChl10;
	}
	public String getReqChl11() {
		return reqChl11;
	}
	public void setReqChl11(String reqChl11) {
		this.reqChl11 = reqChl11;
	}
	public String getReqChl12() {
		return reqChl12;
	}
	public void setReqChl12(String reqChl12) {
		this.reqChl12 = reqChl12;
	}
	public String getReqChl13() {
		return reqChl13;
	}
	public void setReqChl13(String reqChl13) {
		this.reqChl13 = reqChl13;
	}
	public String getReqChl14() {
		return reqChl14;
	}
	public void setReqChl14(String reqChl14) {
		this.reqChl14 = reqChl14;
	}
	public String getReqChl15() {
		return reqChl15;
	}
	public void setReqChl15(String reqChl15) {
		this.reqChl15 = reqChl15;
	}
	public String getReqChl16() {
		return reqChl16;
	}
	public void setReqChl16(String reqChl16) {
		this.reqChl16 = reqChl16;
	}
	public String getReqChl17() {
		return reqChl17;
	}
	public void setReqChl17(String reqChl17) {
		this.reqChl17 = reqChl17;
	}
	public String getReqChl18() {
		return reqChl18;
	}
	public void setReqChl18(String reqChl18) {
		this.reqChl18 = reqChl18;
	}
	public String getReqChl19() {
		return reqChl19;
	}
	public void setReqChl19(String reqChl19) {
		this.reqChl19 = reqChl19;
	}
	public String getReqChl20() {
		return reqChl20;
	}
	public void setReqChl20(String reqChl20) {
		this.reqChl20 = reqChl20;
	}
	public String getReqChl21() {
		return reqChl21;
	}
	public void setReqChl21(String reqChl21) {
		this.reqChl21 = reqChl21;
	}
	public String getReqChl22() {
		return reqChl22;
	}
	public void setReqChl22(String reqChl22) {
		this.reqChl22 = reqChl22;
	}
	public String getReqChl23() {
		return reqChl23;
	}
	public void setReqChl23(String reqChl23) {
		this.reqChl23 = reqChl23;
	}
	public String getReqChl24() {
		return reqChl24;
	}
	public void setReqChl24(String reqChl24) {
		this.reqChl24 = reqChl24;
	}
	public String getReqChl25() {
		return reqChl25;
	}
	public void setReqChl25(String reqChl25) {
		this.reqChl25 = reqChl25;
	}
	public String getReqChl26() {
		return reqChl26;
	}
	public void setReqChl26(String reqChl26) {
		this.reqChl26 = reqChl26;
	}
	public String getReqChl27() {
		return reqChl27;
	}
	public void setReqChl27(String reqChl27) {
		this.reqChl27 = reqChl27;
	}
	public String getReqChl28() {
		return reqChl28;
	}
	public void setReqChl28(String reqChl28) {
		this.reqChl28 = reqChl28;
	}
	public String getReqChl29() {
		return reqChl29;
	}
	public void setReqChl29(String reqChl29) {
		this.reqChl29 = reqChl29;
	}
	public String getReqChl30() {
		return reqChl30;
	}
	public void setReqChl30(String reqChl30) {
		this.reqChl30 = reqChl30;
	}
	public String getReqChl31() {
		return reqChl31;
	}
	public void setReqChl31(String reqChl31) {
		this.reqChl31 = reqChl31;
	}
	public String getReqChl32() {
		return reqChl32;
	}
	public void setReqChl32(String reqChl32) {
		this.reqChl32 = reqChl32;
	}
	public String getReqChl33() {
		return reqChl33;
	}
	public void setReqChl33(String reqChl33) {
		this.reqChl33 = reqChl33;
	}
	public String getReqChl34() {
		return reqChl34;
	}
	public void setReqChl34(String reqChl34) {
		this.reqChl34 = reqChl34;
	}
	public String getReqSts1() {
		return reqSts1;
	}
	public void setReqSts1(String reqSts1) {
		this.reqSts1 = reqSts1;
	}
	public String getReqSts2() {
		return reqSts2;
	}
	public void setReqSts2(String reqSts2) {
		this.reqSts2 = reqSts2;
	}
	public String getReqSts3() {
		return reqSts3;
	}
	public void setReqSts3(String reqSts3) {
		this.reqSts3 = reqSts3;
	}
	public String getReqSts4() {
		return reqSts4;
	}
	public void setReqSts4(String reqSts4) {
		this.reqSts4 = reqSts4;
	}
	public String getReqSts5() {
		return reqSts5;
	}
	public void setReqSts5(String reqSts5) {
		this.reqSts5 = reqSts5;
	}
	public String getReqSts6() {
		return reqSts6;
	}
	public void setReqSts6(String reqSts6) {
		this.reqSts6 = reqSts6;
	}
	public String getReqSts7() {
		return reqSts7;
	}
	public void setReqSts7(String reqSts7) {
		this.reqSts7 = reqSts7;
	}
	public String getReqSts8() {
		return reqSts8;
	}
	public void setReqSts8(String reqSts8) {
		this.reqSts8 = reqSts8;
	}
	public String getReqSts9() {
		return reqSts9;
	}
	public void setReqSts9(String reqSts9) {
		this.reqSts9 = reqSts9;
	}
	public String getReqSts10() {
		return reqSts10;
	}
	public void setReqSts10(String reqSts10) {
		this.reqSts10 = reqSts10;
	}
	public String getReqSts11() {
		return reqSts11;
	}
	public void setReqSts11(String reqSts11) {
		this.reqSts11 = reqSts11;
	}
	public String getReqSts12() {
		return reqSts12;
	}
	public void setReqSts12(String reqSts12) {
		this.reqSts12 = reqSts12;
	}
	public String getReqSts13() {
		return reqSts13;
	}
	public void setReqSts13(String reqSts13) {
		this.reqSts13 = reqSts13;
	}
	public String getReqSts14() {
		return reqSts14;
	}
	public void setReqSts14(String reqSts14) {
		this.reqSts14 = reqSts14;
	}
	public String getReqSts15() {
		return reqSts15;
	}
	public void setReqSts15(String reqSts15) {
		this.reqSts15 = reqSts15;
	}
	public String getReqSts16() {
		return reqSts16;
	}
	public void setReqSts16(String reqSts16) {
		this.reqSts16 = reqSts16;
	}
	public String getReqSts17() {
		return reqSts17;
	}
	public void setReqSts17(String reqSts17) {
		this.reqSts17 = reqSts17;
	}
	public String getReqSts18() {
		return reqSts18;
	}
	public void setReqSts18(String reqSts18) {
		this.reqSts18 = reqSts18;
	}
	public String getReqSts19() {
		return reqSts19;
	}
	public void setReqSts19(String reqSts19) {
		this.reqSts19 = reqSts19;
	}
	public String getReqSts20() {
		return reqSts20;
	}
	public void setReqSts20(String reqSts20) {
		this.reqSts20 = reqSts20;
	}
	public String getReqSts21() {
		return reqSts21;
	}
	public void setReqSts21(String reqSts21) {
		this.reqSts21 = reqSts21;
	}
	public String getReqSts22() {
		return reqSts22;
	}
	public void setReqSts22(String reqSts22) {
		this.reqSts22 = reqSts22;
	}
	public String getReqSts23() {
		return reqSts23;
	}
	public void setReqSts23(String reqSts23) {
		this.reqSts23 = reqSts23;
	}
	public String getReqSts24() {
		return reqSts24;
	}
	public void setReqSts24(String reqSts24) {
		this.reqSts24 = reqSts24;
	}
	public String getReqSts25() {
		return reqSts25;
	}
	public void setReqSts25(String reqSts25) {
		this.reqSts25 = reqSts25;
	}
	public String getReqSts26() {
		return reqSts26;
	}
	public void setReqSts26(String reqSts26) {
		this.reqSts26 = reqSts26;
	}
	public String getReqSts27() {
		return reqSts27;
	}
	public void setReqSts27(String reqSts27) {
		this.reqSts27 = reqSts27;
	}
	public String getReqSts28() {
		return reqSts28;
	}
	public void setReqSts28(String reqSts28) {
		this.reqSts28 = reqSts28;
	}
	public String getReqSts29() {
		return reqSts29;
	}
	public void setReqSts29(String reqSts29) {
		this.reqSts29 = reqSts29;
	}
	public String getReqSts30() {
		return reqSts30;
	}
	public void setReqSts30(String reqSts30) {
		this.reqSts30 = reqSts30;
	}
	public String getReqSts31() {
		return reqSts31;
	}
	public void setReqSts31(String reqSts31) {
		this.reqSts31 = reqSts31;
	}
	public String getReqSts32() {
		return reqSts32;
	}
	public void setReqSts32(String reqSts32) {
		this.reqSts32 = reqSts32;
	}
	public String getReqSts33() {
		return reqSts33;
	}
	public void setReqSts33(String reqSts33) {
		this.reqSts33 = reqSts33;
	}
	public String getReqSts34() {
		return reqSts34;
	}
	public void setReqSts34(String reqSts34) {
		this.reqSts34 = reqSts34;
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

private String reqFlg;

/**
 * NM001DTO.javareqFlgを設定
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
