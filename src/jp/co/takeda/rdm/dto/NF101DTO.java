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
public class NF101DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String NF101 = "NF101";

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
	 * 固定施設C
	 * @generated
	 */
	private String insNo;

	/**
	 * 施設略式漢字名
	 * @generated
	 */
	private String insAbbrName;

	/**
	 * ULT施設C
	 * @generated
	 */
	private String ultInsNo;

	/**
	 * ULT施設略名
	 * @generated
	 */
	private String shisetsuNmRyaku;

	/**
	 * 施設種別
	 * @generated
	 */
	private String insType;

	/**
	 * 施設区分
	 * @generated
	 */
	private String pharmType;

	/**
	 * ULT施設区分
	 * @generated
	 */
	private String shisetsuKbn;

	/**
	 * 施設区分
	 * @generated
	 */
	private String nextPharmType;

	/**
	 * 階級区分
	 * @generated
	 */
	private String insRank;

	/**
	 * 階級区分
	 * @generated
	 */
	private String nextInsRank;

	/**
	 * 定訪先区分
	 * @generated
	 */
	private String regVisType;

	/**
	 * 定訪先区分
	 * @generated
	 */
	private String nextRegVisType;

	/**
	 * 重点病院区分
	 * @generated
	 */
	private String impHosType;

	/**
	 * 重点病院区分
	 * @generated
	 */
	private String nextImpHosType;

	/**
	 * 対象区分
	 * @generated
	 */
	private String hoInsType;

	/**
	 * 対象区分
	 * @generated
	 */
	private String nextHoInsType;

	/**
	 * 経営主体
	 * @generated
	 */
	private String manageCd;

	/**
	 * 経営主体
	 * @generated
	 */
	private String manageNm;

	/**
	 * ULT経営主体
	 * @generated
	 */
	private String keieitaiNm;

	/**
	 * 経営主体
	 * @generated
	 */
	private String nextManageCd;

	/**
	 * ワクチン対象区分
	 * @generated
	 */
	private String vacInsType;

	/**
	 * ワクチン対象区分
	 * @generated
	 */
	private String nextVacInsType;

	/**
	 * ワクチン定訪先区分
	 * @generated
	 */
	private String vacVisitType;

	/**
	 * ワクチン定訪先区分
	 * @generated
	 */
	private String nextVacVisitType;

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
	 * 病床(基準)
	 * @generated
	 */
	private String ultBedCntBase;

	/**
	 * 病床数(一般)
	 * @generated
	 */
	private String ultBedCnt01;

	/**
	 * 病床数(医療療養)
	 * @generated
	 */
	private String ultBedCnt02;

	/**
	 * 病床数(精神)
	 * @generated
	 */
	private String ultBedCnt03;

	/**
	 * 病床数(結核)
	 * @generated
	 */
	private String ultBedCnt04;

	/**
	 * 病床数(感染症)
	 * @generated
	 */
	private String ultBedCnt05;

	/**
	 * 病床数(介護療養)
	 * @generated
	 */
	private String ultBedCnt06;

	/**
	 * 病床数(療養)
	 * @generated
	 */
	private String ultBedCnt07;

	/**
	 * ベッド数計
	 * @generated
	 */
	private String ultBedsTot;

	/**
	 * 医療ベッド数計
	 * @generated
	 */
	private String ultMedBedsTot;

	/**
	 * 病床(基準)
	 * @generated
	 */
	private String nextBedCntBase;

	/**
	 * 病床数(一般)
	 * @generated
	 */
	private String nextBedCnt01;

	/**
	 * 病床数(医療療養)
	 * @generated
	 */
	private String nextBedCnt02;

	/**
	 * 病床数(精神)
	 * @generated
	 */
	private String nextBedCnt03;

	/**
	 * 病床数(結核)
	 * @generated
	 */
	private String nextBedCnt04;

	/**
	 * 病床数(感染症)
	 * @generated
	 */
	private String nextBedCnt05;

	/**
	 * 病床数(介護療養)
	 * @generated
	 */
	private String nextBedCnt06;

	/**
	 * 病床数(療養)
	 * @generated
	 */
	private String nextBedCnt07;

	/**
	 * ベッド数計
	 * @generated
	 */
	private String nextBedsTot;

	/**
	 * 医療ベッド数計
	 * @generated
	 */
	private String nextMedBedsTot;

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
	 * 1:固定施設から作成、2：申請データあり
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
	 * コンボボックス_ワクチン対象区分
	 * @generated
	 */
	private LinkedHashMap<String,String> vacInsTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ワクチン定訪先区分
	 * @generated
	 */
	private LinkedHashMap<String,String> vacVisitTypeCombo = new LinkedHashMap<String,String>();

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
	 * カラーフラグ(施設区分)
	 * @generated
	 */
	private String pharmTypeFlg;

	/**
	 * カラーフラグ(階級区分)
	 * @generated
	 */
	private String insRankFlg;

	/**
	 * カラーフラグ(定訪先区分)
	 * @generated
	 */
	private String regVisTypeFlg;

	/**
	 * カラーフラグ(重点病院区分)
	 * @generated
	 */
	private String impHosTypeFlg;

	/**
	 * カラーフラグ(経営主体)
	 * @generated
	 */
	private String manageCdFlg;

	/**
	 * カラーフラグ(ワクチン対象区分)
	 * @generated
	 */
	private String vacInsTypeFlg;

	/**
	 * カラーフラグ(ワクチン定訪先区分)
	 * @generated
	 */
	private String vacVisitTypeFlg;

	/**
	 * カラーフラグ(病床(基準)
	 * @generated
	 */
	private String bedCntBaseFlg;

	/**
	 * カラーフラグ(病床数(一般))
	 * @generated
	 */
	private String bedCnt01Flg;

	/**
	 * カラーフラグ(病床数(医療療養))
	 * @generated
	 */
	private String bedCnt02Flg;

	/**
	 * カラーフラグ(病床数(精神))
	 * @generated
	 */
	private String bedCnt03Flg;

	/**
	 * カラーフラグ(病床数(結核))
	 * @generated
	 */
	private String bedCnt04Flg;

	/**
	 * カラーフラグ(病床数(感染症))
	 * @generated
	 */
	private String bedCnt05Flg;

	/**
	 * カラーフラグ(病床数(介護療養))
	 * @generated
	 */
	private String bedCnt06Flg;

	/**
	 * カラーフラグ(病床数(療養))
	 * @generated
	 */
	private String bedCnt07Flg;

	/**
	 * カラーフラグ(ベッド数計)
	 * @generated
	 */
	private String bedsTotFlg;

	/**
	 * カラーフラグ(医療ベッド数計)
	 * @generated
	 */
	private String medBedsTotFlg;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NF101DTO() {
        setForward(NF101);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNF101(String screenID){
        this.NF101 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNF101(){
        return NF101;
    }

	/**
	 * NF101DTO.javamsgIdを設定
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
	 * NF101DTO.javaloginJokenSetCdを設定
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
	 * NF101DTO.javaloginJgiNoを設定
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
	 * NF101DTO.javaloginNmを設定
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
	 * NF101DTO.javaloginBrCdを設定
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
	 * NF101DTO.javaloginDistCdを設定
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
	 * NF101DTO.javaloginShzNmを設定
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
	 * NF101DTO.javaloginTrtCdを設定
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
	 * NF101DTO.javagamenIdを設定
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
	 * NF101DTO.javatitleを設定
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
	 * NF101DTO.javareqIdを設定
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
	 * NF101DTO.javareqShzNmを設定
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
	 * NF101DTO.javareqStsNmを設定
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
	 * NF101DTO.javareqJgiNameを設定
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
	 * NF101DTO.javareqYmdhmsを設定
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
	 * NF101DTO.javashnShaNameを設定
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
	 * NF101DTO.javashnYmdhmsを設定
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
	 * NF101DTO.javaaprShaNameを設定
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
	 * NF101DTO.javaaprYmdhmsを設定
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
	 * NF101DTO.javareqJgiNoを設定
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
	 * NF101DTO.javareqBrCdを設定
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
	 * NF101DTO.javareqDistCdを設定
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
	 * NF101DTO.javareqStsCdを設定
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
	 * NF101DTO.javashnJgiNoを設定
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
	 * NF101DTO.javaaprJgiNoを設定
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
	 * NF101DTO.javaupdShaYmdを設定
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
	 * NF101DTO.javainsNoを設定
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
	 * NF101DTO.javainsAbbrNameを設定
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
	 * NF101DTO.javaultInsNoを設定
	 * @return ultInsNo
	 */
	public String getUltInsNo() {
		return ultInsNo;
	}

	/**
	 * @param ultInsNo セットする ultInsNo
	 */
	public void setUltInsNo(String ultInsNo) {
		this.ultInsNo = ultInsNo;
	}

	/**
	 * NF101DTO.javashisetsuNmRyakuを設定
	 * @return shisetsuNmRyaku
	 */
	public String getShisetsuNmRyaku() {
		return shisetsuNmRyaku;
	}

	/**
	 * @param shisetsuNmRyaku セットする shisetsuNmRyaku
	 */
	public void setShisetsuNmRyaku(String shisetsuNmRyaku) {
		this.shisetsuNmRyaku = shisetsuNmRyaku;
	}

	/**
	 * NF101DTO.javainsTypeを設定
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
	 * NF101DTO.javapharmTypeを設定
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
	 * NF101DTO.javashisetsuKbnを設定
	 * @return shisetsuKbn
	 */
	public String getShisetsuKbn() {
		return shisetsuKbn;
	}

	/**
	 * @param shisetsuKbn セットする shisetsuKbn
	 */
	public void setShisetsuKbn(String shisetsuKbn) {
		this.shisetsuKbn = shisetsuKbn;
	}

	/**
	 * NF101DTO.javanextPharmTypeを設定
	 * @return nextPharmType
	 */
	public String getNextPharmType() {
		return nextPharmType;
	}

	/**
	 * @param nextPharmType セットする nextPharmType
	 */
	public void setNextPharmType(String nextPharmType) {
		this.nextPharmType = nextPharmType;
	}

	/**
	 * NF101DTO.javainsRankを設定
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
	 * NF101DTO.javanextInsRankを設定
	 * @return nextInsRank
	 */
	public String getNextInsRank() {
		return nextInsRank;
	}

	/**
	 * @param nextInsRank セットする nextInsRank
	 */
	public void setNextInsRank(String nextInsRank) {
		this.nextInsRank = nextInsRank;
	}

	/**
	 * NF101DTO.javaregVisTypeを設定
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
	 * NF101DTO.javanextRegVisTypeを設定
	 * @return nextRegVisType
	 */
	public String getNextRegVisType() {
		return nextRegVisType;
	}

	/**
	 * @param nextRegVisType セットする nextRegVisType
	 */
	public void setNextRegVisType(String nextRegVisType) {
		this.nextRegVisType = nextRegVisType;
	}

	/**
	 * NF101DTO.javaimpHosTypeを設定
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
	 * NF101DTO.javanextImpHosTypeを設定
	 * @return nextImpHosType
	 */
	public String getNextImpHosType() {
		return nextImpHosType;
	}

	/**
	 * @param nextImpHosType セットする nextImpHosType
	 */
	public void setNextImpHosType(String nextImpHosType) {
		this.nextImpHosType = nextImpHosType;
	}

	/**
	 * NF101DTO.javahoInsTypeを設定
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
	 * NF101DTO.javanextHoInsTypeを設定
	 * @return nextHoInsType
	 */
	public String getNextHoInsType() {
		return nextHoInsType;
	}

	/**
	 * @param nextHoInsType セットする nextHoInsType
	 */
	public void setNextHoInsType(String nextHoInsType) {
		this.nextHoInsType = nextHoInsType;
	}

	/**
	 * NF101DTO.javamanageCdを設定
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
	 * NF101DTO.javamanageNmを設定
	 * @return manageNm
	 */
	public String getManageNm() {
		return manageNm;
	}

	/**
	 * @param manageNm セットする manageNm
	 */
	public void setManageNm(String manageNm) {
		this.manageNm = manageNm;
	}

	/**
	 * NF101DTO.javakeieitaiNmを設定
	 * @return keieitaiNm
	 */
	public String getKeieitaiNm() {
		return keieitaiNm;
	}

	/**
	 * @param keieitaiNm セットする keieitaiNm
	 */
	public void setKeieitaiNm(String keieitaiNm) {
		this.keieitaiNm = keieitaiNm;
	}

	/**
	 * NF101DTO.javanextManageCdを設定
	 * @return nextManageCd
	 */
	public String getNextManageCd() {
		return nextManageCd;
	}

	/**
	 * @param nextManageCd セットする nextManageCd
	 */
	public void setNextManageCd(String nextManageCd) {
		this.nextManageCd = nextManageCd;
	}

	/**
	 * NF101DTO.javavacInsTypeを設定
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
	 * NF101DTO.javanextVacInsTypeを設定
	 * @return nextVacInsType
	 */
	public String getNextVacInsType() {
		return nextVacInsType;
	}

	/**
	 * @param nextVacInsType セットする nextVacInsType
	 */
	public void setNextVacInsType(String nextVacInsType) {
		this.nextVacInsType = nextVacInsType;
	}

	/**
	 * NF101DTO.javavacVisitTypeを設定
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
	 * NF101DTO.javanextVacVisitTypeを設定
	 * @return nextVacVisitType
	 */
	public String getNextVacVisitType() {
		return nextVacVisitType;
	}

	/**
	 * @param nextVacVisitType セットする nextVacVisitType
	 */
	public void setNextVacVisitType(String nextVacVisitType) {
		this.nextVacVisitType = nextVacVisitType;
	}

	/**
	 * NF101DTO.javabedCntBaseを設定
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
	 * NF101DTO.javabedCnt01を設定
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
	 * NF101DTO.javabedCnt02を設定
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
	 * NF101DTO.javabedCnt03を設定
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
	 * NF101DTO.javabedCnt04を設定
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
	 * NF101DTO.javabedCnt05を設定
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
	 * NF101DTO.javabedCnt06を設定
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
	 * NF101DTO.javabedCnt07を設定
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
	 * NF101DTO.javabedsTotを設定
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
	 * NF101DTO.javamedBedsTotを設定
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
	 * NF101DTO.javaultBedCntBaseを設定
	 * @return ultBedCntBase
	 */
	public String getUltBedCntBase() {
		return ultBedCntBase;
	}

	/**
	 * @param ultBedCntBase セットする ultBedCntBase
	 */
	public void setUltBedCntBase(String ultBedCntBase) {
		this.ultBedCntBase = ultBedCntBase;
	}

	/**
	 * NF101DTO.javaultBedCnt01を設定
	 * @return ultBedCnt01
	 */
	public String getUltBedCnt01() {
		return ultBedCnt01;
	}

	/**
	 * @param ultBedCnt01 セットする ultBedCnt01
	 */
	public void setUltBedCnt01(String ultBedCnt01) {
		this.ultBedCnt01 = ultBedCnt01;
	}

	/**
	 * NF101DTO.javaultBedCnt02を設定
	 * @return ultBedCnt02
	 */
	public String getUltBedCnt02() {
		return ultBedCnt02;
	}

	/**
	 * @param ultBedCnt02 セットする ultBedCnt02
	 */
	public void setUltBedCnt02(String ultBedCnt02) {
		this.ultBedCnt02 = ultBedCnt02;
	}

	/**
	 * NF101DTO.javaultBedCnt03を設定
	 * @return ultBedCnt03
	 */
	public String getUltBedCnt03() {
		return ultBedCnt03;
	}

	/**
	 * @param ultBedCnt03 セットする ultBedCnt03
	 */
	public void setUltBedCnt03(String ultBedCnt03) {
		this.ultBedCnt03 = ultBedCnt03;
	}

	/**
	 * NF101DTO.javaultBedCnt04を設定
	 * @return ultBedCnt04
	 */
	public String getUltBedCnt04() {
		return ultBedCnt04;
	}

	/**
	 * @param ultBedCnt04 セットする ultBedCnt04
	 */
	public void setUltBedCnt04(String ultBedCnt04) {
		this.ultBedCnt04 = ultBedCnt04;
	}

	/**
	 * NF101DTO.javaultBedCnt05を設定
	 * @return ultBedCnt05
	 */
	public String getUltBedCnt05() {
		return ultBedCnt05;
	}

	/**
	 * @param ultBedCnt05 セットする ultBedCnt05
	 */
	public void setUltBedCnt05(String ultBedCnt05) {
		this.ultBedCnt05 = ultBedCnt05;
	}

	/**
	 * NF101DTO.javaultBedCnt06を設定
	 * @return ultBedCnt06
	 */
	public String getUltBedCnt06() {
		return ultBedCnt06;
	}

	/**
	 * @param ultBedCnt06 セットする ultBedCnt06
	 */
	public void setUltBedCnt06(String ultBedCnt06) {
		this.ultBedCnt06 = ultBedCnt06;
	}

	/**
	 * NF101DTO.javaultBedCnt07を設定
	 * @return ultBedCnt07
	 */
	public String getUltBedCnt07() {
		return ultBedCnt07;
	}

	/**
	 * @param ultBedCnt07 セットする ultBedCnt07
	 */
	public void setUltBedCnt07(String ultBedCnt07) {
		this.ultBedCnt07 = ultBedCnt07;
	}

	/**
	 * NF101DTO.javaultBedsTotを設定
	 * @return ultBedsTot
	 */
	public String getUltBedsTot() {
		return ultBedsTot;
	}

	/**
	 * @param ultBedsTot セットする ultBedsTot
	 */
	public void setUltBedsTot(String ultBedsTot) {
		this.ultBedsTot = ultBedsTot;
	}

	/**
	 * NF101DTO.javaultMedBedsTotを設定
	 * @return ultMedBedsTot
	 */
	public String getUltMedBedsTot() {
		return ultMedBedsTot;
	}

	/**
	 * @param ultMedBedsTot セットする ultMedBedsTot
	 */
	public void setUltMedBedsTot(String ultMedBedsTot) {
		this.ultMedBedsTot = ultMedBedsTot;
	}

	/**
	 * NF101DTO.javanextBedCntBaseを設定
	 * @return nextBedCntBase
	 */
	public String getNextBedCntBase() {
		return nextBedCntBase;
	}

	/**
	 * @param nextBedCntBase セットする nextBedCntBase
	 */
	public void setNextBedCntBase(String nextBedCntBase) {
		this.nextBedCntBase = nextBedCntBase;
	}

	/**
	 * NF101DTO.javanextBedCnt01を設定
	 * @return nextBedCnt01
	 */
	public String getNextBedCnt01() {
		return nextBedCnt01;
	}

	/**
	 * @param nextBedCnt01 セットする nextBedCnt01
	 */
	public void setNextBedCnt01(String nextBedCnt01) {
		this.nextBedCnt01 = nextBedCnt01;
	}

	/**
	 * NF101DTO.javanextBedCnt02を設定
	 * @return nextBedCnt02
	 */
	public String getNextBedCnt02() {
		return nextBedCnt02;
	}

	/**
	 * @param nextBedCnt02 セットする nextBedCnt02
	 */
	public void setNextBedCnt02(String nextBedCnt02) {
		this.nextBedCnt02 = nextBedCnt02;
	}

	/**
	 * NF101DTO.javanextBedCnt03を設定
	 * @return nextBedCnt03
	 */
	public String getNextBedCnt03() {
		return nextBedCnt03;
	}

	/**
	 * @param nextBedCnt03 セットする nextBedCnt03
	 */
	public void setNextBedCnt03(String nextBedCnt03) {
		this.nextBedCnt03 = nextBedCnt03;
	}

	/**
	 * NF101DTO.javanextBedCnt04を設定
	 * @return nextBedCnt04
	 */
	public String getNextBedCnt04() {
		return nextBedCnt04;
	}

	/**
	 * @param nextBedCnt04 セットする nextBedCnt04
	 */
	public void setNextBedCnt04(String nextBedCnt04) {
		this.nextBedCnt04 = nextBedCnt04;
	}

	/**
	 * NF101DTO.javanextBedCnt05を設定
	 * @return nextBedCnt05
	 */
	public String getNextBedCnt05() {
		return nextBedCnt05;
	}

	/**
	 * @param nextBedCnt05 セットする nextBedCnt05
	 */
	public void setNextBedCnt05(String nextBedCnt05) {
		this.nextBedCnt05 = nextBedCnt05;
	}

	/**
	 * NF101DTO.javanextBedCnt06を設定
	 * @return nextBedCnt06
	 */
	public String getNextBedCnt06() {
		return nextBedCnt06;
	}

	/**
	 * @param nextBedCnt06 セットする nextBedCnt06
	 */
	public void setNextBedCnt06(String nextBedCnt06) {
		this.nextBedCnt06 = nextBedCnt06;
	}

	/**
	 * NF101DTO.javanextBedCnt07を設定
	 * @return nextBedCnt07
	 */
	public String getNextBedCnt07() {
		return nextBedCnt07;
	}

	/**
	 * @param nextBedCnt07 セットする nextBedCnt07
	 */
	public void setNextBedCnt07(String nextBedCnt07) {
		this.nextBedCnt07 = nextBedCnt07;
	}

	/**
	 * NF101DTO.javanextBedsTotを設定
	 * @return nextBedsTot
	 */
	public String getNextBedsTot() {
		return nextBedsTot;
	}

	/**
	 * @param nextBedsTot セットする nextBedsTot
	 */
	public void setNextBedsTot(String nextBedsTot) {
		this.nextBedsTot = nextBedsTot;
	}

	/**
	 * NF101DTO.javanextMedBedsTotを設定
	 * @return nextMedBedsTot
	 */
	public String getNextMedBedsTot() {
		return nextMedBedsTot;
	}

	/**
	 * @param nextMedBedsTot セットする nextMedBedsTot
	 */
	public void setNextMedBedsTot(String nextMedBedsTot) {
		this.nextMedBedsTot = nextMedBedsTot;
	}

	/**
	 * NF101DTO.javareqCommentを設定
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
	 * NF101DTO.javaaprMemoを設定
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
	 * NF101DTO.javadisplayKbnを設定
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
	 * NF101DTO.javafuncIdを設定
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
	 * NF101DTO.javapharmTypeComboを設定
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
	 * NF101DTO.javainsRankComboを設定
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
	 * NF101DTO.javaregVisTypeComboを設定
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
	 * NF101DTO.javaimpHosTypeComboを設定
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
	 * NF101DTO.javahoInsTypeComboを設定
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
	 * NF101DTO.javamanageCdComboを設定
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
	 * NF101DTO.javavacInsTypeComboを設定
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
	 * NF101DTO.javavacVisitTypeComboを設定
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
	 * NF101DTO.javashnFlgを設定
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
	 * NF101DTO.javaeditApprFlgを設定
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
	 * NF101DTO.javamsgStrを設定
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
	 * NF101DTO.javapharmTypeFlgを設定
	 * @return pharmTypeFlg
	 */
	public String getPharmTypeFlg() {
		return pharmTypeFlg;
	}

	/**
	 * @param pharmTypeFlg セットする pharmTypeFlg
	 */
	public void setPharmTypeFlg(String pharmTypeFlg) {
		this.pharmTypeFlg = pharmTypeFlg;
	}

	/**
	 * NF101DTO.javainsRankFlgを設定
	 * @return insRankFlg
	 */
	public String getInsRankFlg() {
		return insRankFlg;
	}

	/**
	 * @param insRankFlg セットする insRankFlg
	 */
	public void setInsRankFlg(String insRankFlg) {
		this.insRankFlg = insRankFlg;
	}

	/**
	 * NF101DTO.javaregVisTypeFlgを設定
	 * @return regVisTypeFlg
	 */
	public String getRegVisTypeFlg() {
		return regVisTypeFlg;
	}

	/**
	 * @param regVisTypeFlg セットする regVisTypeFlg
	 */
	public void setRegVisTypeFlg(String regVisTypeFlg) {
		this.regVisTypeFlg = regVisTypeFlg;
	}

	/**
	 * NF101DTO.javaimpHosTypeFlgを設定
	 * @return impHosTypeFlg
	 */
	public String getImpHosTypeFlg() {
		return impHosTypeFlg;
	}

	/**
	 * @param impHosTypeFlg セットする impHosTypeFlg
	 */
	public void setImpHosTypeFlg(String impHosTypeFlg) {
		this.impHosTypeFlg = impHosTypeFlg;
	}

	/**
	 * NF101DTO.javamanageCdFlgを設定
	 * @return manageCdFlg
	 */
	public String getManageCdFlg() {
		return manageCdFlg;
	}

	/**
	 * @param manageCdFlg セットする manageCdFlg
	 */
	public void setManageCdFlg(String manageCdFlg) {
		this.manageCdFlg = manageCdFlg;
	}

	/**
	 * NF101DTO.javavacInsTypeFlgを設定
	 * @return vacInsTypeFlg
	 */
	public String getVacInsTypeFlg() {
		return vacInsTypeFlg;
	}

	/**
	 * @param vacInsTypeFlg セットする vacInsTypeFlg
	 */
	public void setVacInsTypeFlg(String vacInsTypeFlg) {
		this.vacInsTypeFlg = vacInsTypeFlg;
	}

	/**
	 * NF101DTO.javavacVisitTypeFlgを設定
	 * @return vacVisitTypeFlg
	 */
	public String getVacVisitTypeFlg() {
		return vacVisitTypeFlg;
	}

	/**
	 * @param vacVisitTypeFlg セットする vacVisitTypeFlg
	 */
	public void setVacVisitTypeFlg(String vacVisitTypeFlg) {
		this.vacVisitTypeFlg = vacVisitTypeFlg;
	}

	/**
	 * NF101DTO.javabedCntBaseFlgを設定
	 * @return bedCntBaseFlg
	 */
	public String getBedCntBaseFlg() {
		return bedCntBaseFlg;
	}

	/**
	 * @param bedCntBaseFlg セットする bedCntBaseFlg
	 */
	public void setBedCntBaseFlg(String bedCntBaseFlg) {
		this.bedCntBaseFlg = bedCntBaseFlg;
	}

	/**
	 * NF101DTO.javabedCnt01Flgを設定
	 * @return bedCnt01Flg
	 */
	public String getBedCnt01Flg() {
		return bedCnt01Flg;
	}

	/**
	 * @param bedCnt01Flg セットする bedCnt01Flg
	 */
	public void setBedCnt01Flg(String bedCnt01Flg) {
		this.bedCnt01Flg = bedCnt01Flg;
	}

	/**
	 * NF101DTO.javabedCnt02Flgを設定
	 * @return bedCnt02Flg
	 */
	public String getBedCnt02Flg() {
		return bedCnt02Flg;
	}

	/**
	 * @param bedCnt02Flg セットする bedCnt02Flg
	 */
	public void setBedCnt02Flg(String bedCnt02Flg) {
		this.bedCnt02Flg = bedCnt02Flg;
	}

	/**
	 * NF101DTO.javabedCnt03Flgを設定
	 * @return bedCnt03Flg
	 */
	public String getBedCnt03Flg() {
		return bedCnt03Flg;
	}

	/**
	 * @param bedCnt03Flg セットする bedCnt03Flg
	 */
	public void setBedCnt03Flg(String bedCnt03Flg) {
		this.bedCnt03Flg = bedCnt03Flg;
	}

	/**
	 * NF101DTO.javabedCnt04Flgを設定
	 * @return bedCnt04Flg
	 */
	public String getBedCnt04Flg() {
		return bedCnt04Flg;
	}

	/**
	 * @param bedCnt04Flg セットする bedCnt04Flg
	 */
	public void setBedCnt04Flg(String bedCnt04Flg) {
		this.bedCnt04Flg = bedCnt04Flg;
	}

	/**
	 * NF101DTO.javabedCnt05Flgを設定
	 * @return bedCnt05Flg
	 */
	public String getBedCnt05Flg() {
		return bedCnt05Flg;
	}

	/**
	 * @param bedCnt05Flg セットする bedCnt05Flg
	 */
	public void setBedCnt05Flg(String bedCnt05Flg) {
		this.bedCnt05Flg = bedCnt05Flg;
	}

	/**
	 * NF101DTO.javabedCnt06Flgを設定
	 * @return bedCnt06Flg
	 */
	public String getBedCnt06Flg() {
		return bedCnt06Flg;
	}

	/**
	 * @param bedCnt06Flg セットする bedCnt06Flg
	 */
	public void setBedCnt06Flg(String bedCnt06Flg) {
		this.bedCnt06Flg = bedCnt06Flg;
	}

	/**
	 * NF101DTO.javabedCnt07Flgを設定
	 * @return bedCnt07Flg
	 */
	public String getBedCnt07Flg() {
		return bedCnt07Flg;
	}

	/**
	 * @param bedCnt07Flg セットする bedCnt07Flg
	 */
	public void setBedCnt07Flg(String bedCnt07Flg) {
		this.bedCnt07Flg = bedCnt07Flg;
	}

	/**
	 * NF101DTO.javabedsTotFlgを設定
	 * @return bedsTotFlg
	 */
	public String getBedsTotFlg() {
		return bedsTotFlg;
	}

	/**
	 * @param bedsTotFlg セットする bedsTotFlg
	 */
	public void setBedsTotFlg(String bedsTotFlg) {
		this.bedsTotFlg = bedsTotFlg;
	}

	/**
	 * NF101DTO.javamedBedsTotFlgを設定
	 * @return medBedsTotFlg
	 */
	public String getMedBedsTotFlg() {
		return medBedsTotFlg;
	}

	/**
	 * @param medBedsTotFlg セットする medBedsTotFlg
	 */
	public void setMedBedsTotFlg(String medBedsTotFlg) {
		this.medBedsTotFlg = medBedsTotFlg;
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
