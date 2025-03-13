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
public class NF011DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String NF011 = "NF011";

	/**
	 * メッセージID
	 * @generated
	 */
	private String msgId;

	/**
	 * ユーザ権限
	 * @generated
	 */
	private String loginJokenSetCd;

	/**
	 * ユーザ従業員番号
	 * @generated
	 */
	private String loginJgiNo;

	/**
	 * ユーザ氏名
	 * @generated
	 */
	private String loginNm;

	/**
	 * ユーザ医薬支店C
	 * @generated
	 */
	private String loginBrCd;

	/**
	 * ユーザ医薬営業所C
	 * @generated
	 */
	private String loginDistCd;

	/**
	 * ユーザ所属組織名
	 * @generated
	 */
	private String loginShzNm;

	/**
	 * ユーザ領域コード
	 * @generated
	 */
	private String loginTrtCd;

	/**
	 * 画面ＩＤ（共通部分判定用）
	 * @generated
	 */
	private String gamenId;

	/**
	 * 画面タイトル
	 * @generated
	 */
	private String title;

	/**
	 * 申請ID
	 * @generated
	 */
	private String reqId;

	/**
	 * 申請チャネル
	 * @generated
	 */
	private String reqChl;

	/**
	 * 申請者所属名称
	 * @generated
	 */
	private String reqShzNm;

	/**
	 * 申請ステータス名称
	 * @generated
	 */
	private String reqStsNm;

	/**
	 * 申請者氏名
	 * @generated
	 */
	private String reqJgiName;

	/**
	 * 申請日時
	 * @generated
	 */
	private String reqYmdhms;

	/**
	 * 審査者氏名
	 * @generated
	 */
	private String shnShaName;

	/**
	 * 審査日時
	 * @generated
	 */
	private String shnYmdhms;

	/**
	 * 承認者氏名
	 * @generated
	 */
	private String aprShaName;

	/**
	 * 承認日時
	 * @generated
	 */
	private String aprYmdhms;

	/**
	 * 申請者従業員番号
	 * @generated
	 */
	private Integer reqJgiNo;

	/**
	 * 申請者医薬支店C
	 * @generated
	 */
	private String reqBrCd;

	/**
	 * 申請者医薬営業所C
	 * @generated
	 */
	private String reqDistCd;

	/**
	 * 申請ステータスコード
	 * @generated
	 */
	private String reqStsCd;

	/**
	 * 審査者従業員番号
	 * @generated
	 */
	private Integer shnJgiNo;

	/**
	 * 承認者従業員番号
	 * @generated
	 */
	private Integer aprJgiNo;

	/**
	 * 更新日時
	 * @generated
	 */
	private String updShaYmd;

	/**
	 * ULT施設C
	 * @generated
	 */
	private String ultInsCd;

	/**
	 * ULT施設名
	 * @generated
	 */
	private String ultInsNm;

	/**
	 * 施設種別
	 * @generated
	 */
	private String insType;

	/**
	 * 親施設
	 * @generated
	 */
	private String mainInsCd;

	/**
	 * 親施設名
	 * @generated
	 */
	private String mainInsNm;

	/**
	 * 施設略式漢字名
	 * @generated
	 */
	private String insAbbrName;

	/**
	 * 施設カナ名
	 * @generated
	 */
	private String insKana;

	/**
	 * 施設正式漢字名
	 * @generated
	 */
	private String insFormalName;

	/**
	 * 契約用正式漢字名
	 * @generated
	 */
	private String insContName;

	/**
	 * 取引区分
	 * @generated
	 */
	private String tradeType;

	/**
	 * 開業年月日(年)
	 * @generated
	 */
	private String insOpenYear;

	/**
	 * 開業年月日(月)
	 * @generated
	 */
	private String insOpenMonth;

	/**
	 * 開業年月日(日)
	 * @generated
	 */
	private String insOpenDay;

	/**
	 * 施設住所
	 * @generated
	 */
	private String insAddr;

	/**
	 * 施設住所カナ
	 * @generated
	 */
	private String insAddrKana;

	/**
	 * 郵便番号
	 * @generated
	 */
	private String insPcode;

	/**
	 * JIS府県コード
	 * @generated
	 */
	private String addrCodePref;

	/**
	 * JIS府県名
	 * @generated
	 */
	private String addrCodePrefName;

	/**
	 * JIS市区町村コード
	 * @generated
	 */
	private String addrCodeCity;

	/**
	 * JIS市区町村名
	 * @generated
	 */
	private String addrCodeCityName;

	/**
	 * 町名地番
	 * @generated
	 */
	private String insAddrDt;

	/**
	 * 武田市区郡コード
	 * @generated
	 */
	private String tkCityCd;

	/**
	 * 武田市区郡名
	 * @generated
	 */
	private String tkCityName;

	/**
	 * 電話番号1
	 * @generated
	 */
	private String insPhone1;

	/**
	 * 電話番号2
	 * @generated
	 */
	private String insPhone2;

	/**
	 * FAX番号1
	 * @generated
	 */
	private String insFax1;

	/**
	 * FAX番号2
	 * @generated
	 */
	private String insFax2;

	/**
	 * ホームページアドレス
	 * @generated
	 */
	private String insUrl;

	/**
	 * ホームページアドレス最終更新日
	 * @generated
	 */
	private String insUrlYmd;

	/**
	 * 施設区分
	 * @generated
	 */
	private String pharmType;

	/**
	 * 階級区分
	 * @generated
	 */
	private String insRank;

	/**
	 * 定訪先区分
	 * @generated
	 */
	private String regVisType;

	/**
	 * 重点病院区分
	 * @generated
	 */
	private String impHosType;

	/**
	 * 大学細分類
	 * @generated
	 */
	private String univSubdiv;

	/**
	 * 対象区分
	 * @generated
	 */
	private String hoInsType;

	/**
	 * 経営主体
	 * @generated
	 */
	private String manageCd;

	/**
	 * 病床(基準)
	 * @generated
	 */
	private String bedCntBase;

	/**
	 * 病床数(一般)
	 * @generated
	 */
	private String bedCnt01;

	/**
	 * 病床数(医療療養)
	 * @generated
	 */
	private String bedCnt02;

	/**
	 * 病床数(精神)
	 * @generated
	 */
	private String bedCnt03;

	/**
	 * 病床数(結核)
	 * @generated
	 */
	private String bedCnt04;

	/**
	 * 病床数(感染症)
	 * @generated
	 */
	private String bedCnt05;

	/**
	 * 病床数(介護療養)
	 * @generated
	 */
	private String bedCnt06;

	/**
	 * 病床数(療養)
	 * @generated
	 */
	private String bedCnt07;

	/**
	 * ベッド数計
	 * @generated
	 */
	private String bedsTot;

	/**
	 * 医療ベッド数計
	 * @generated
	 */
	private String medBedsTot;

	/**
	 * 入所定員数
	 * @generated
	 */
	private String entcapaNum;

	/**
	 * ワクチン対象区分(当期)
	 * @generated
	 */
	private String vacInsType;

	/**
	 * ワクチン定訪先区分(当期)
	 * @generated
	 */
	private String vacVisitType;

	/**
	 * 領域
	 * @generated
	 */
	private String trtCd;

	/**
	 * 領域担当者リスト変更前
	 * @generated
	 */
	private List<HcoJkrData> beforeHcoJkrDataList = new ArrayList<HcoJkrData>();

	/**
	 * 領域担当者リスト
	 * @generated
	 */
	private List<HcoJkrData> hcoJkrDataList = new ArrayList<HcoJkrData>();

	/**
	 * 領域担当者リスト更新フラグ
	 * @generated
	 */
	private String hcoJkrDataChgFlg;

	/**
	 * 申請コメント
	 * @generated
	 */
	private String reqComment;

	/**
	 * 審査・承認メモ
	 * @generated
	 */
	private String aprMemo;

	/**
	 * 表示分岐
	 * 0:完全新規、1:ULTから作成、2：申請データあり
	 * @generated
	 */
	private String displayKbn;

	/**
	 * 次画面分岐用
	 * 0:一時保存、1:申請画面へ
	 * @generated
	 */
	private String funcId;

	/**
	 * コンボボックス_施設種別
	 * @generated
	 */
	private LinkedHashMap<String,String> insTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_取引区分
	 * @generated
	 */
	private LinkedHashMap<String,String> tradeTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_開業年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> insOpenYearCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_開業年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> insOpenMonthCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_開業年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> insOpenDayCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_施設区分
	 * @generated
	 */
	private LinkedHashMap<String,String> pharmTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_階級区分
	 * @generated
	 */
	private LinkedHashMap<String,String> insRankCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_定訪先区分
	 * @generated
	 */
	private LinkedHashMap<String,String> regVisTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_重点病院区分
	 * @generated
	 */
	private LinkedHashMap<String,String> impHosTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_大学細分類
	 * @generated
	 */
	private LinkedHashMap<String,String> univSubdivCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_対象区分
	 * @generated
	 */
	private LinkedHashMap<String,String> hoInsTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_経営主体
	 * @generated
	 */
	private LinkedHashMap<String,String> manageCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ワクチン対象区分(当期)
	 * @generated
	 */
	private LinkedHashMap<String,String> vacInsTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ワクチン定訪先区分(当期)
	 * @generated
	 */
	private LinkedHashMap<String,String> vacVisitTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_領域
	 * @generated
	 */
	private LinkedHashMap<String,String> trtCdCombo = new LinkedHashMap<String,String>();

	/**
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

	/**
	 * 編集可能フラグ
	 * 0:不可、1:可
	 * @generated
	 */
	private String editApprFlg;

	/**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NF011DTO() {
        setForward(NF011);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNF011(String screenID){
        this.NF011 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNF011(){
        return NF011;
    }

	/**
	 * NF011DTO.javaloginJokenSetCdを設定
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
	 * NF011DTO.javaloginJgiNoを設定
	 * @return loginJgiNo
	 */
	public String getLoginJgiNo() {
		return loginJgiNo;
	}

	/**
	 * @param loginJgiNo セットする loginJgiNo
	 */
	public void setLoginJgiNo(String loginJgiNo) {
		this.loginJgiNo = loginJgiNo;
	}

	/**
	 * NF011DTO.javaloginNmを設定
	 * @return loginNm
	 */
	public String getLoginNm() {
		return loginNm;
	}

	/**
	 * @param loginNm セットする loginNm
	 */
	public void setLoginNm(String loginNm) {
		this.loginNm = loginNm;
	}

	/**
	 * NF011DTO.javaloginBrCdを設定
	 * @return loginBrCd
	 */
	public String getLoginBrCd() {
		return loginBrCd;
	}

	/**
	 * @param loginBrCd セットする loginBrCd
	 */
	public void setLoginBrCd(String loginBrCd) {
		this.loginBrCd = loginBrCd;
	}

	/**
	 * NF011DTO.javaloginDistCdを設定
	 * @return loginDistCd
	 */
	public String getLoginDistCd() {
		return loginDistCd;
	}

	/**
	 * @param loginDistCd セットする loginDistCd
	 */
	public void setLoginDistCd(String loginDistCd) {
		this.loginDistCd = loginDistCd;
	}

	/**
	 * NF011DTO.javaloginShzNmを設定
	 * @return loginShzNm
	 */
	public String getLoginShzNm() {
		return loginShzNm;
	}

	/**
	 * @param loginShzNm セットする loginShzNm
	 */
	public void setLoginShzNm(String loginShzNm) {
		this.loginShzNm = loginShzNm;
	}

	/**
	 * NF011DTO.javaloginTrtCdを設定
	 * @return loginTrtCd
	 */
	public String getLoginTrtCd() {
		return loginTrtCd;
	}

	/**
	 * @param loginTrtCd セットする loginTrtCd
	 */
	public void setLoginTrtCd(String loginTrtCd) {
		this.loginTrtCd = loginTrtCd;
	}

	/**
	 * NF011DTO.javagamenIdを設定
	 * @return gamenId
	 */
	public String getGamenId() {
		return gamenId;
	}

	/**
	 * @param gamenId セットする gamenId
	 */
	public void setGamenId(String gamenId) {
		this.gamenId = gamenId;
	}

	/**
	 * NF011DTO.javatitleを設定
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
	 * NF011DTO.javareqIdを設定
	 * @return reqId
	 */
	public String getReqId() {
		return reqId;
	}

	/**
	 * @param reqId セットする reqId
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	/**
	 * NF011DTO.javareqChlを設定
	 * @return reqChl
	 */
	public String getReqChl() {
		return reqChl;
	}

	/**
	 * @param reqChl セットする reqChl
	 */
	public void setReqChl(String reqChl) {
		this.reqChl = reqChl;
	}

	/**
	 * NF011DTO.javareqShzNmを設定
	 * @return reqShzNm
	 */
	public String getReqShzNm() {
		return reqShzNm;
	}

	/**
	 * @param reqShzNm セットする reqShzNm
	 */
	public void setReqShzNm(String reqShzNm) {
		this.reqShzNm = reqShzNm;
	}

	/**
	 * NF011DTO.javareqStsNmを設定
	 * @return reqStsNm
	 */
	public String getReqStsNm() {
		return reqStsNm;
	}

	/**
	 * @param reqStsNm セットする reqStsNm
	 */
	public void setReqStsNm(String reqStsNm) {
		this.reqStsNm = reqStsNm;
	}

	/**
	 * NF011DTO.javareqJgiNameを設定
	 * @return reqJgiName
	 */
	public String getReqJgiName() {
		return reqJgiName;
	}

	/**
	 * @param reqJgiName セットする reqJgiName
	 */
	public void setReqJgiName(String reqJgiName) {
		this.reqJgiName = reqJgiName;
	}

	/**
	 * NF011DTO.javareqYmdhmsを設定
	 * @return reqYmdhms
	 */
	public String getReqYmdhms() {
		return reqYmdhms;
	}

	/**
	 * @param reqYmdhms セットする reqYmdhms
	 */
	public void setReqYmdhms(String reqYmdhms) {
		this.reqYmdhms = reqYmdhms;
	}

	/**
	 * NF011DTO.javashnShaNameを設定
	 * @return shnShaName
	 */
	public String getShnShaName() {
		return shnShaName;
	}

	/**
	 * @param shnShaName セットする shnShaName
	 */
	public void setShnShaName(String shnShaName) {
		this.shnShaName = shnShaName;
	}

	/**
	 * NF011DTO.javashnYmdhmsを設定
	 * @return shnYmdhms
	 */
	public String getShnYmdhms() {
		return shnYmdhms;
	}

	/**
	 * @param shnYmdhms セットする shnYmdhms
	 */
	public void setShnYmdhms(String shnYmdhms) {
		this.shnYmdhms = shnYmdhms;
	}

	/**
	 * NF011DTO.javaaprShaNameを設定
	 * @return aprShaName
	 */
	public String getAprShaName() {
		return aprShaName;
	}

	/**
	 * @param aprShaName セットする aprShaName
	 */
	public void setAprShaName(String aprShaName) {
		this.aprShaName = aprShaName;
	}

	/**
	 * NF011DTO.javaaprYmdhmsを設定
	 * @return aprYmdhms
	 */
	public String getAprYmdhms() {
		return aprYmdhms;
	}

	/**
	 * @param aprYmdhms セットする aprYmdhms
	 */
	public void setAprYmdhms(String aprYmdhms) {
		this.aprYmdhms = aprYmdhms;
	}

	/**
	 * NF011DTO.javareqJgiNoを設定
	 * @return reqJgiNo
	 */
	public Integer getReqJgiNo() {
		return reqJgiNo;
	}

	/**
	 * @param reqJgiNo セットする reqJgiNo
	 */
	public void setReqJgiNo(Integer reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}

	/**
	 * NF011DTO.javareqBrCdを設定
	 * @return reqBrCd
	 */
	public String getReqBrCd() {
		return reqBrCd;
	}

	/**
	 * @param reqBrCd セットする reqBrCd
	 */
	public void setReqBrCd(String reqBrCd) {
		this.reqBrCd = reqBrCd;
	}

	/**
	 * NF011DTO.javareqDistCdを設定
	 * @return reqDistCd
	 */
	public String getReqDistCd() {
		return reqDistCd;
	}

	/**
	 * @param reqDistCd セットする reqDistCd
	 */
	public void setReqDistCd(String reqDistCd) {
		this.reqDistCd = reqDistCd;
	}

	/**
	 * NF011DTO.javareqStsCdを設定
	 * @return reqStsCd
	 */
	public String getReqStsCd() {
		return reqStsCd;
	}

	/**
	 * @param reqStsCd セットする reqStsCd
	 */
	public void setReqStsCd(String reqStsCd) {
		this.reqStsCd = reqStsCd;
	}

	/**
	 * NF011DTO.javashnJgiNoを設定
	 * @return shnJgiNo
	 */
	public Integer getShnJgiNo() {
		return shnJgiNo;
	}

	/**
	 * @param shnJgiNo セットする shnJgiNo
	 */
	public void setShnJgiNo(Integer shnJgiNo) {
		this.shnJgiNo = shnJgiNo;
	}

	/**
	 * NF011DTO.javaaprJgiNoを設定
	 * @return aprJgiNo
	 */
	public Integer getAprJgiNo() {
		return aprJgiNo;
	}

	/**
	 * @param aprJgiNo セットする aprJgiNo
	 */
	public void setAprJgiNo(Integer aprJgiNo) {
		this.aprJgiNo = aprJgiNo;
	}

	/**
	 * NF011DTO.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public String getUpdShaYmd() {
		return updShaYmd;
	}

	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(String updShaYmd) {
		this.updShaYmd = updShaYmd;
	}

	/**
	 * NF011DTO.javabeforeHcoJkrDataListを設定
	 * @return beforeHcoJkrDataList
	 */
	public List<HcoJkrData> getBeforeHcoJkrDataList() {
		return beforeHcoJkrDataList;
	}

	/**
	 * @param beforeHcoJkrDataList セットする beforeHcoJkrDataList
	 */
	public void setBeforeHcoJkrDataList(List<HcoJkrData> beforeHcoJkrDataList) {
		this.beforeHcoJkrDataList = beforeHcoJkrDataList;
	}

	/**
	 * NF011DTO.javahcoJkrDataListを設定
	 * @return hcoJkrDataList
	 */
	public List<HcoJkrData> getHcoJkrDataList() {
		return hcoJkrDataList;
	}

	/**
	 * @param hcoJkrDataList セットする hcoJkrDataList
	 */
	public void setHcoJkrDataList(List<HcoJkrData> hcoJkrDataList) {
		this.hcoJkrDataList = hcoJkrDataList;
	}

	/**
	 * NF011DTO.javahcoJkrDataChgFlgを設定
	 * @return hcoJkrDataChgFlg
	 */
	public String getHcoJkrDataChgFlg() {
		return hcoJkrDataChgFlg;
	}

	/**
	 * @param hcoJkrDataChgFlg セットする hcoJkrDataChgFlg
	 */
	public void setHcoJkrDataChgFlg(String hcoJkrDataChgFlg) {
		this.hcoJkrDataChgFlg = hcoJkrDataChgFlg;
	}

	/**
	 * NF011DTO.javareqCommentを設定
	 * @return reqComment
	 */
	public String getReqComment() {
		return reqComment;
	}

	/**
	 * @param reqComment セットする reqComment
	 */
	public void setReqComment(String reqComment) {
		this.reqComment = reqComment;
	}

	/**
	 * NF011DTO.javaaprMemoを設定
	 * @return aprMemo
	 */
	public String getAprMemo() {
		return aprMemo;
	}

	/**
	 * @param aprMemo セットする aprMemo
	 */
	public void setAprMemo(String aprMemo) {
		this.aprMemo = aprMemo;
	}

	/**
	 * NF011DTO.javamsgIdを設定
	 * @return msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId セットする msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * NF011DTO.javadisplayKbnを設定
	 * @return displayKbn
	 */
	public String getDisplayKbn() {
		return displayKbn;
	}

	/**
	 * @param displayKbn セットする displayKbn
	 */
	public void setDisplayKbn(String displayKbn) {
		this.displayKbn = displayKbn;
	}

	/**
	 * NF011DTO.javafuncIdを設定
	 * @return funcId
	 */
	public String getFuncId() {
		return funcId;
	}

	/**
	 * @param funcId セットする funcId
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	/**
	 * NF011DTO.javashnFlgを設定
	 * @return shnFlg
	 */
	public String getShnFlg() {
		return shnFlg;
	}

	/**
	 * @param shnFlg セットする shnFlg
	 */
	public void setShnFlg(String shnFlg) {
		this.shnFlg = shnFlg;
	}

	/**
	 * NF011DTO.javaultInsCdを設定
	 * @return ultInsCd
	 */
	public String getUltInsCd() {
		return ultInsCd;
	}

	/**
	 * @param ultInsCd セットする ultInsCd
	 */
	public void setUltInsCd(String ultInsCd) {
		this.ultInsCd = ultInsCd;
	}

	/**
	 * NF011DTO.javaultInsNmを設定
	 * @return ultInsNm
	 */
	public String getUltInsNm() {
		return ultInsNm;
	}

	/**
	 * @param ultInsNm セットする ultInsNm
	 */
	public void setUltInsNm(String ultInsNm) {
		this.ultInsNm = ultInsNm;
	}

	/**
	 * NF011DTO.javainsTypeを設定
	 * @return insType
	 */
	public String getInsType() {
		return insType;
	}

	/**
	 * @param insType セットする insType
	 */
	public void setInsType(String insType) {
		this.insType = insType;
	}

	/**
	 * NF011DTO.javamainInsCdを設定
	 * @return mainInsCd
	 */
	public String getMainInsCd() {
		return mainInsCd;
	}

	/**
	 * @param mainInsCd セットする mainInsCd
	 */
	public void setMainInsCd(String mainInsCd) {
		this.mainInsCd = mainInsCd;
	}

	/**
	 * NF011DTO.javamainInsNmを設定
	 * @return mainInsNm
	 */
	public String getMainInsNm() {
		return mainInsNm;
	}

	/**
	 * @param mainInsNm セットする mainInsNm
	 */
	public void setMainInsNm(String mainInsNm) {
		this.mainInsNm = mainInsNm;
	}

	/**
	 * NF011DTO.javainsAbbrNameを設定
	 * @return insAbbrName
	 */
	public String getInsAbbrName() {
		return insAbbrName;
	}

	/**
	 * @param insAbbrName セットする insAbbrName
	 */
	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
	}

	/**
	 * NF011DTO.javainsKanaを設定
	 * @return insKana
	 */
	public String getInsKana() {
		return insKana;
	}

	/**
	 * @param insKana セットする insKana
	 */
	public void setInsKana(String insKana) {
		this.insKana = insKana;
	}

	/**
	 * NF011DTO.javainsFormalNameを設定
	 * @return insFormalName
	 */
	public String getInsFormalName() {
		return insFormalName;
	}

	/**
	 * @param insFormalName セットする insFormalName
	 */
	public void setInsFormalName(String insFormalName) {
		this.insFormalName = insFormalName;
	}

	/**
	 * NF011DTO.javainsContNameを設定
	 * @return insContName
	 */
	public String getInsContName() {
		return insContName;
	}

	/**
	 * @param insContName セットする insContName
	 */
	public void setInsContName(String insContName) {
		this.insContName = insContName;
	}

	/**
	 * NF011DTO.javatradeTypeを設定
	 * @return tradeType
	 */
	public String getTradeType() {
		return tradeType;
	}

	/**
	 * @param tradeType セットする tradeType
	 */
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * NF011DTO.javainsOpenYearを設定
	 * @return insOpenYear
	 */
	public String getInsOpenYear() {
		return insOpenYear;
	}

	/**
	 * @param insOpenYear セットする insOpenYear
	 */
	public void setInsOpenYear(String insOpenYear) {
		this.insOpenYear = insOpenYear;
	}

	/**
	 * NF011DTO.javainsOpenMonthを設定
	 * @return insOpenMonth
	 */
	public String getInsOpenMonth() {
		return insOpenMonth;
	}

	/**
	 * @param insOpenMonth セットする insOpenMonth
	 */
	public void setInsOpenMonth(String insOpenMonth) {
		this.insOpenMonth = insOpenMonth;
	}

	/**
	 * NF011DTO.javainsOpenDayを設定
	 * @return insOpenDay
	 */
	public String getInsOpenDay() {
		return insOpenDay;
	}

	/**
	 * @param insOpenDay セットする insOpenDay
	 */
	public void setInsOpenDay(String insOpenDay) {
		this.insOpenDay = insOpenDay;
	}

	/**
	 * NF011DTO.javainsAddrを設定
	 * @return insAddr
	 */
	public String getInsAddr() {
		return insAddr;
	}

	/**
	 * @param insAddr セットする insAddr
	 */
	public void setInsAddr(String insAddr) {
		this.insAddr = insAddr;
	}

	/**
	 * NF011DTO.javainsAddrKanaを設定
	 * @return insAddrKana
	 */
	public String getInsAddrKana() {
		return insAddrKana;
	}

	/**
	 * @param insAddrKana セットする insAddrKana
	 */
	public void setInsAddrKana(String insAddrKana) {
		this.insAddrKana = insAddrKana;
	}

	/**
	 * NF011DTO.javainsPcodeを設定
	 * @return insPcode
	 */
	public String getInsPcode() {
		return insPcode;
	}

	/**
	 * @param insPcode セットする insPcode
	 */
	public void setInsPcode(String insPcode) {
		this.insPcode = insPcode;
	}

	/**
	 * NF011DTO.javaaddrCodePrefを設定
	 * @return addrCodePref
	 */
	public String getAddrCodePref() {
		return addrCodePref;
	}

	/**
	 * @param addrCodePref セットする addrCodePref
	 */
	public void setAddrCodePref(String addrCodePref) {
		this.addrCodePref = addrCodePref;
	}

	/**
	 * NF011DTO.javaaddrCodePrefNameを設定
	 * @return addrCodePrefName
	 */
	public String getAddrCodePrefName() {
		return addrCodePrefName;
	}

	/**
	 * @param addrCodePrefName セットする addrCodePrefName
	 */
	public void setAddrCodePrefName(String addrCodePrefName) {
		this.addrCodePrefName = addrCodePrefName;
	}

	/**
	 * NF011DTO.javaaddrCodeCityを設定
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
	 * NF011DTO.javaaddrCodeCityNameを設定
	 * @return addrCodeCityName
	 */
	public String getAddrCodeCityName() {
		return addrCodeCityName;
	}

	/**
	 * @param addrCodeCityName セットする addrCodeCityName
	 */
	public void setAddrCodeCityName(String addrCodeCityName) {
		this.addrCodeCityName = addrCodeCityName;
	}

	/**
	 * NF011DTO.javainsAddrDtを設定
	 * @return insAddrDt
	 */
	public String getInsAddrDt() {
		return insAddrDt;
	}

	/**
	 * @param insAddrDt セットする insAddrDt
	 */
	public void setInsAddrDt(String insAddrDt) {
		this.insAddrDt = insAddrDt;
	}

	/**
	 * NF011DTO.javatkCityCdを設定
	 * @return tkCityCd
	 */
	public String getTkCityCd() {
		return tkCityCd;
	}

	/**
	 * @param tkCityCd セットする tkCityCd
	 */
	public void setTkCityCd(String tkCityCd) {
		this.tkCityCd = tkCityCd;
	}

	/**
	 * NF011DTO.javatkCityNameを設定
	 * @return tkCityName
	 */
	public String getTkCityName() {
		return tkCityName;
	}

	/**
	 * @param tkCityName セットする tkCityName
	 */
	public void setTkCityName(String tkCityName) {
		this.tkCityName = tkCityName;
	}

	/**
	 * NF011DTO.javainsPhone1を設定
	 * @return insPhone1
	 */
	public String getInsPhone1() {
		return insPhone1;
	}

	/**
	 * @param insPhone1 セットする insPhone1
	 */
	public void setInsPhone1(String insPhone1) {
		this.insPhone1 = insPhone1;
	}

	/**
	 * NF011DTO.javainsPhone2を設定
	 * @return insPhone2
	 */
	public String getInsPhone2() {
		return insPhone2;
	}

	/**
	 * @param insPhone2 セットする insPhone2
	 */
	public void setInsPhone2(String insPhone2) {
		this.insPhone2 = insPhone2;
	}

	/**
	 * NF011DTO.javainsFax1を設定
	 * @return insFax1
	 */
	public String getInsFax1() {
		return insFax1;
	}

	/**
	 * @param insFax1 セットする insFax1
	 */
	public void setInsFax1(String insFax1) {
		this.insFax1 = insFax1;
	}

	/**
	 * NF011DTO.javainsFax2を設定
	 * @return insFax2
	 */
	public String getInsFax2() {
		return insFax2;
	}

	/**
	 * @param insFax2 セットする insFax2
	 */
	public void setInsFax2(String insFax2) {
		this.insFax2 = insFax2;
	}

	/**
	 * NF011DTO.javainsUrlを設定
	 * @return insUrl
	 */
	public String getInsUrl() {
		return insUrl;
	}

	/**
	 * @param insUrl セットする insUrl
	 */
	public void setInsUrl(String insUrl) {
		this.insUrl = insUrl;
	}

	/**
	 * NF011DTO.javainsUrlYmdを設定
	 * @return insUrlYmd
	 */
	public String getInsUrlYmd() {
		return insUrlYmd;
	}

	/**
	 * @param insUrlYmd セットする insUrlYmd
	 */
	public void setInsUrlYmd(String insUrlYmd) {
		this.insUrlYmd = insUrlYmd;
	}

	/**
	 * NF011DTO.javapharmTypeを設定
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
	 * NF011DTO.javainsRankを設定
	 * @return insRank
	 */
	public String getInsRank() {
		return insRank;
	}

	/**
	 * @param insRank セットする insRank
	 */
	public void setInsRank(String insRank) {
		this.insRank = insRank;
	}

	/**
	 * NF011DTO.javaregVisTypeを設定
	 * @return regVisType
	 */
	public String getRegVisType() {
		return regVisType;
	}

	/**
	 * @param regVisType セットする regVisType
	 */
	public void setRegVisType(String regVisType) {
		this.regVisType = regVisType;
	}

	/**
	 * NF011DTO.javaimpHosTypeを設定
	 * @return impHosType
	 */
	public String getImpHosType() {
		return impHosType;
	}

	/**
	 * @param impHosType セットする impHosType
	 */
	public void setImpHosType(String impHosType) {
		this.impHosType = impHosType;
	}

	/**
	 * NF011DTO.javaunivSubdivを設定
	 * @return univSubdiv
	 */
	public String getUnivSubdiv() {
		return univSubdiv;
	}

	/**
	 * @param univSubdiv セットする univSubdiv
	 */
	public void setUnivSubdiv(String univSubdiv) {
		this.univSubdiv = univSubdiv;
	}

	/**
	 * NF011DTO.javahoInsTypeを設定
	 * @return hoInsType
	 */
	public String getHoInsType() {
		return hoInsType;
	}

	/**
	 * @param hoInsType セットする hoInsType
	 */
	public void setHoInsType(String hoInsType) {
		this.hoInsType = hoInsType;
	}

	/**
	 * NF011DTO.javamanageCdを設定
	 * @return manageCd
	 */
	public String getManageCd() {
		return manageCd;
	}

	/**
	 * @param manageCd セットする manageCd
	 */
	public void setManageCd(String manageCd) {
		this.manageCd = manageCd;
	}

	/**
	 * NF011DTO.javabedCntBaseを設定
	 * @return bedCntBase
	 */
	public String getBedCntBase() {
		return bedCntBase;
	}

	/**
	 * @param bedCntBase セットする bedCntBase
	 */
	public void setBedCntBase(String bedCntBase) {
		this.bedCntBase = bedCntBase;
	}

	/**
	 * NF011DTO.javabedCnt01を設定
	 * @return bedCnt01
	 */
	public String getBedCnt01() {
		return bedCnt01;
	}

	/**
	 * @param bedCnt01 セットする bedCnt01
	 */
	public void setBedCnt01(String bedCnt01) {
		this.bedCnt01 = bedCnt01;
	}

	/**
	 * NF011DTO.javabedCnt02を設定
	 * @return bedCnt02
	 */
	public String getBedCnt02() {
		return bedCnt02;
	}

	/**
	 * @param bedCnt02 セットする bedCnt02
	 */
	public void setBedCnt02(String bedCnt02) {
		this.bedCnt02 = bedCnt02;
	}

	/**
	 * NF011DTO.javabedCnt03を設定
	 * @return bedCnt03
	 */
	public String getBedCnt03() {
		return bedCnt03;
	}

	/**
	 * @param bedCnt03 セットする bedCnt03
	 */
	public void setBedCnt03(String bedCnt03) {
		this.bedCnt03 = bedCnt03;
	}

	/**
	 * NF011DTO.javabedCnt04を設定
	 * @return bedCnt04
	 */
	public String getBedCnt04() {
		return bedCnt04;
	}

	/**
	 * @param bedCnt04 セットする bedCnt04
	 */
	public void setBedCnt04(String bedCnt04) {
		this.bedCnt04 = bedCnt04;
	}

	/**
	 * NF011DTO.javabedCnt05を設定
	 * @return bedCnt05
	 */
	public String getBedCnt05() {
		return bedCnt05;
	}

	/**
	 * @param bedCnt05 セットする bedCnt05
	 */
	public void setBedCnt05(String bedCnt05) {
		this.bedCnt05 = bedCnt05;
	}

	/**
	 * NF011DTO.javabedCnt06を設定
	 * @return bedCnt06
	 */
	public String getBedCnt06() {
		return bedCnt06;
	}

	/**
	 * @param bedCnt06 セットする bedCnt06
	 */
	public void setBedCnt06(String bedCnt06) {
		this.bedCnt06 = bedCnt06;
	}

	/**
	 * NF011DTO.javabedCnt07を設定
	 * @return bedCnt07
	 */
	public String getBedCnt07() {
		return bedCnt07;
	}

	/**
	 * @param bedCnt07 セットする bedCnt07
	 */
	public void setBedCnt07(String bedCnt07) {
		this.bedCnt07 = bedCnt07;
	}

	/**
	 * NF011DTO.javabedsTotを設定
	 * @return bedsTot
	 */
	public String getBedsTot() {
		return bedsTot;
	}

	/**
	 * @param bedsTot セットする bedsTot
	 */
	public void setBedsTot(String bedsTot) {
		this.bedsTot = bedsTot;
	}

	/**
	 * NF011DTO.javamedBedsTotを設定
	 * @return medBedsTot
	 */
	public String getMedBedsTot() {
		return medBedsTot;
	}

	/**
	 * @param medBedsTot セットする medBedsTot
	 */
	public void setMedBedsTot(String medBedsTot) {
		this.medBedsTot = medBedsTot;
	}

	/**
	 * NF011DTO.javaentcapaNumを設定
	 * @return entcapaNum
	 */
	public String getEntcapaNum() {
		return entcapaNum;
	}

	/**
	 * @param entcapaNum セットする entcapaNum
	 */
	public void setEntcapaNum(String entcapaNum) {
		this.entcapaNum = entcapaNum;
	}

	/**
	 * NF011DTO.javavacInsTypeを設定
	 * @return vacInsType
	 */
	public String getVacInsType() {
		return vacInsType;
	}

	/**
	 * @param vacInsType セットする vacInsType
	 */
	public void setVacInsType(String vacInsType) {
		this.vacInsType = vacInsType;
	}

	/**
	 * NF011DTO.javavacVisitTypeを設定
	 * @return vacVisitType
	 */
	public String getVacVisitType() {
		return vacVisitType;
	}

	/**
	 * @param vacVisitType セットする vacVisitType
	 */
	public void setVacVisitType(String vacVisitType) {
		this.vacVisitType = vacVisitType;
	}

	/**
	 * NF011DTO.javatrtCdを設定
	 * @return trtCd
	 */
	public String getTrtCd() {
		return trtCd;
	}

	/**
	 * @param trtCd セットする trtCd
	 */
	public void setTrtCd(String trtCd) {
		this.trtCd = trtCd;
	}

	/**
	 * NF011DTO.javainsTypeComboを設定
	 * @return insTypeCombo
	 */
	public LinkedHashMap<String, String> getInsTypeCombo() {
		return insTypeCombo;
	}

	/**
	 * @param insTypeCombo セットする insTypeCombo
	 */
	public void setInsTypeCombo(LinkedHashMap<String, String> insTypeCombo) {
		this.insTypeCombo = insTypeCombo;
	}

	/**
	 * NF011DTO.javatradeTypeComboを設定
	 * @return tradeTypeCombo
	 */
	public LinkedHashMap<String, String> getTradeTypeCombo() {
		return tradeTypeCombo;
	}

	/**
	 * @param tradeTypeCombo セットする tradeTypeCombo
	 */
	public void setTradeTypeCombo(LinkedHashMap<String, String> tradeTypeCombo) {
		this.tradeTypeCombo = tradeTypeCombo;
	}

	/**
	 * NF011DTO.javainsOpenYearComboを設定
	 * @return insOpenYearCombo
	 */
	public LinkedHashMap<String, String> getInsOpenYearCombo() {
		return insOpenYearCombo;
	}

	/**
	 * @param insOpenYearCombo セットする insOpenYearCombo
	 */
	public void setInsOpenYearCombo(LinkedHashMap<String, String> insOpenYearCombo) {
		this.insOpenYearCombo = insOpenYearCombo;
	}

	/**
	 * NF011DTO.javainsOpenMonthComboを設定
	 * @return insOpenMonthCombo
	 */
	public LinkedHashMap<String, String> getInsOpenMonthCombo() {
		return insOpenMonthCombo;
	}

	/**
	 * @param insOpenMonthCombo セットする insOpenMonthCombo
	 */
	public void setInsOpenMonthCombo(LinkedHashMap<String, String> insOpenMonthCombo) {
		this.insOpenMonthCombo = insOpenMonthCombo;
	}

	/**
	 * NF011DTO.javainsOpenDayComboを設定
	 * @return insOpenDayCombo
	 */
	public LinkedHashMap<String, String> getInsOpenDayCombo() {
		return insOpenDayCombo;
	}

	/**
	 * @param insOpenDayCombo セットする insOpenDayCombo
	 */
	public void setInsOpenDayCombo(LinkedHashMap<String, String> insOpenDayCombo) {
		this.insOpenDayCombo = insOpenDayCombo;
	}

	/**
	 * NF011DTO.javapharmTypeComboを設定
	 * @return pharmTypeCombo
	 */
	public LinkedHashMap<String, String> getPharmTypeCombo() {
		return pharmTypeCombo;
	}

	/**
	 * @param pharmTypeCombo セットする pharmTypeCombo
	 */
	public void setPharmTypeCombo(LinkedHashMap<String, String> pharmTypeCombo) {
		this.pharmTypeCombo = pharmTypeCombo;
	}

	/**
	 * NF011DTO.javainsRankComboを設定
	 * @return insRankCombo
	 */
	public LinkedHashMap<String, String> getInsRankCombo() {
		return insRankCombo;
	}

	/**
	 * @param insRankCombo セットする insRankCombo
	 */
	public void setInsRankCombo(LinkedHashMap<String, String> insRankCombo) {
		this.insRankCombo = insRankCombo;
	}

	/**
	 * NF011DTO.javaregVisTypeComboを設定
	 * @return regVisTypeCombo
	 */
	public LinkedHashMap<String, String> getRegVisTypeCombo() {
		return regVisTypeCombo;
	}

	/**
	 * @param regVisTypeCombo セットする regVisTypeCombo
	 */
	public void setRegVisTypeCombo(LinkedHashMap<String, String> regVisTypeCombo) {
		this.regVisTypeCombo = regVisTypeCombo;
	}

	/**
	 * NF011DTO.javaimpHosTypeComboを設定
	 * @return impHosTypeCombo
	 */
	public LinkedHashMap<String, String> getImpHosTypeCombo() {
		return impHosTypeCombo;
	}

	/**
	 * @param impHosTypeCombo セットする impHosTypeCombo
	 */
	public void setImpHosTypeCombo(LinkedHashMap<String, String> impHosTypeCombo) {
		this.impHosTypeCombo = impHosTypeCombo;
	}

	/**
	 * NF011DTO.javaunivSubdivComboを設定
	 * @return univSubdivCombo
	 */
	public LinkedHashMap<String, String> getUnivSubdivCombo() {
		return univSubdivCombo;
	}

	/**
	 * @param univSubdivCombo セットする univSubdivCombo
	 */
	public void setUnivSubdivCombo(LinkedHashMap<String, String> univSubdivCombo) {
		this.univSubdivCombo = univSubdivCombo;
	}

	/**
	 * NF011DTO.javahoInsTypeComboを設定
	 * @return hoInsTypeCombo
	 */
	public LinkedHashMap<String, String> getHoInsTypeCombo() {
		return hoInsTypeCombo;
	}

	/**
	 * @param hoInsTypeCombo セットする hoInsTypeCombo
	 */
	public void setHoInsTypeCombo(LinkedHashMap<String, String> hoInsTypeCombo) {
		this.hoInsTypeCombo = hoInsTypeCombo;
	}

	/**
	 * NF011DTO.javamanageCdComboを設定
	 * @return manageCdCombo
	 */
	public LinkedHashMap<String, String> getManageCdCombo() {
		return manageCdCombo;
	}

	/**
	 * @param manageCdCombo セットする manageCdCombo
	 */
	public void setManageCdCombo(LinkedHashMap<String, String> manageCdCombo) {
		this.manageCdCombo = manageCdCombo;
	}

	/**
	 * NF011DTO.javavacInsTypeComboを設定
	 * @return vacInsTypeCombo
	 */
	public LinkedHashMap<String, String> getVacInsTypeCombo() {
		return vacInsTypeCombo;
	}

	/**
	 * @param vacInsTypeCombo セットする vacInsTypeCombo
	 */
	public void setVacInsTypeCombo(LinkedHashMap<String, String> vacInsTypeCombo) {
		this.vacInsTypeCombo = vacInsTypeCombo;
	}

	/**
	 * NF011DTO.javavacVisitTypeComboを設定
	 * @return vacVisitTypeCombo
	 */
	public LinkedHashMap<String, String> getVacVisitTypeCombo() {
		return vacVisitTypeCombo;
	}

	/**
	 * @param vacVisitTypeCombo セットする vacVisitTypeCombo
	 */
	public void setVacVisitTypeCombo(LinkedHashMap<String, String> vacVisitTypeCombo) {
		this.vacVisitTypeCombo = vacVisitTypeCombo;
	}

	/**
	 * NF011DTO.javatrtCdComboを設定
	 * @return trtCdCombo
	 */
	public LinkedHashMap<String, String> getTrtCdCombo() {
		return trtCdCombo;
	}

	/**
	 * @param trtCdCombo セットする trtCdCombo
	 */
	public void setTrtCdCombo(LinkedHashMap<String, String> trtCdCombo) {
		this.trtCdCombo = trtCdCombo;
	}

	/**
	 * NF011DTO.javaeditApprFlgを設定
	 * @return editApprFlg
	 */
	public String getEditApprFlg() {
		return editApprFlg;
	}

	/**
	 * @param editApprFlg セットする editApprFlg
	 */
	public void setEditApprFlg(String editApprFlg) {
		this.editApprFlg = editApprFlg;
	}

	/**
	 * NF011DTO.javamsgStrを設定
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
	 * このDTOの値を返す
	 * @return DTOの値
	 * @generated
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
