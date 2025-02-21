/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.LinkedHashMap;

/**
 * Entityクラス
 * テーブル物理名 : S_JKR_T_PSS_CHOHYO_KIHON
 * テーブル論理名 : 帳票基本情報
 * @generated
 */
public class SRdmReqSamariEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * test
     * @generated
     */

    private String test;

    /**
     * ソートID(パラメータ)
     */
    private String inSortId;


    public String getInSortId() {
		return inSortId;
	}
	public void setInSortId(String inSortId) {
		this.inSortId = inSortId;
	}
	/**
     * コンストラクタ
     *
     */

    public SRdmReqSamariEntity() {
        super("t-rdm-req-smr","selectReqSmr");
    }

    /**
     * 親画面から受け取るMR/管理者のflag
     */
    private String mrAdminCd;

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

	private String mrAdminFlg;

	/**
	 * mrAdminFlgを取得します。
	 * @return mrAdminFlg
	 */
	public String getMrAdminFlg() {
		return mrAdminFlg;
	}
	/**
	 * mrAdminFlgを設定します。
	 * @param mrAdminFlg mrAdminFlg
	 */
	public void setMrAdminFlg(String mrAdminFlg) {
		this.mrAdminFlg = mrAdminFlg;
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

	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
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

	/**
     * @generated
     */
    private LinkedHashMap jkrSosAddrMap;
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
     * reqChl
     * @generated
     */

    private String reqChl;


        /**
     * reqType
     * @generated
     */
    private String reqType;

        /**
     * reqSts
     * @generated
     */

    private String reqSts;


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
	 * reqTypeを取得します。
	 * @return reqType
	 */
	public String getReqType() {
	    return reqType;
	}
	/**
	 * reqTypeを設定します。
	 * @param reqType reqType
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
