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
public class ND011DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String ND011 = "ND011";

	/**
	 * メッセージID
	 * @generated
	 */
	private String msgId;

	/**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

	/**
	 * ユーザ権限
	 * @generated
	 */
	private String loginJokenSetCd;

	/**
	 * ユーザ従業員番号
	 * @generated
	 */
	private Integer loginJgiNo;

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
	 * ULT医師C
	 * @generated
	 */
	private String ultDocNo;

	/**
	 * ULT医師名(漢字)
	 * @generated
	 */
	private String ultDocNm;

	/**
	 * ULT医師名(半角カナ)
	 * @generated
	 */
	private String ultDocKana;

	/**
	 * 医師／薬剤師区分
	 * @generated
	 */
	private String docType;

	/**
	 * 性別
	 * @generated
	 */
	private String sexCd;

	/**
	 * 医師名(漢字)姓
	 * @generated
	 */
	private String docKanjiSei;

	/**
	 * 医師名(漢字)名
	 * @generated
	 */
	private String docKanjiMei;

	/**
	 * 医師名(半角カナ)姓
	 * @generated
	 */
	private String docKanaSei;

	/**
	 * 医師名(半角カナ)名
	 * @generated
	 */
	private String docKanaMei;

	/**
	 * 旧姓(漢字)姓
	 * @generated
	 */
	private String oldKanjSei;

	/**
	 * 旧姓(半角カナ)姓
	 * @generated
	 */
	private String oldKanaSei;

	/**
	 * 改姓日（年）
	 * @generated
	 */
	private String newNameStYear;

	/**
	 * 改姓日（月）
	 * @generated
	 */
	private String newNameStMonth;

	/**
	 * 改姓日（日）
	 * @generated
	 */
	private String newNameStDay;

	/**
	 * 生年月日（年）
	 * @generated
	 */
	private String dobYear;

	/**
	 * 生年月日（月）
	 * @generated
	 */
	private String dobMonth;

	/**
	 * 生年月日（日）
	 * @generated
	 */
	private String dobDay;

	/**
	 * 出身地
	 * @generated
	 */
	private String homeTownCd;

	/**
	 * 出身校
	 * @generated
	 */
	private String medSchoolCd;

	/**
	 * 卒年（西暦）
	 * @generated
	 */
	private String gradYear;

	/**
	 * 臨床研修年（西暦）
	 * @generated
	 */
	private String emplYear;

	/**
	 * 出身医局校
	 * @generated
	 */
	private String homeUnivCd;

	/**
	 * 出身所属部科
	 * @generated
	 */
	private String homeDeptNm;

	/**
	 * 専門臓器
	 * @generated
	 */
	private String spLiverCd;

	/**
	 * 専門詳細
	 * @generated
	 */
	private String spDiseaseCd;

	/**
	 * 専門追加情報
	 * @generated
	 */
	private String spCom;

	/**
	 * 出身所属部科コード
	 * @generated
	 */
	private String homeDeptCd;

	/**
	 * 所属学会リスト変更前
	 * @generated
	 */
	private List<HcpSocietyData> beforeHcpSocietyDataList = new ArrayList<HcpSocietyData>();

	/**
	 * 所属学会リスト
	 * @generated
	 */
	private List<HcpSocietyData> hcpSocietyDataList = new ArrayList<HcpSocietyData>();

	/**
	 * 所属学会リスト更新フラグ
	 * @generated
	 */
	private String hcpSocietyDataChgFlg;

	/**
	 * 公的機関リスト変更前
	 * @generated
	 */
	private List<HcpPublicData> beforeHcpPublicDataList = new ArrayList<HcpPublicData>();

	/**
	 * 公的機関リスト
	 * @generated
	 */
	private List<HcpPublicData> hcpPublicDataList = new ArrayList<HcpPublicData>();

	/**
	 * 公的機関リスト更新フラグ
	 * @generated
	 */
	private String hcpPublicDataChgFlg;

	/**
	 * 施設
	 * @generated
	 */
	private String skInsNm;

	/**
	 * 大学職位
	 * @generated
	 */
	private String skUnivPosCd;

	/**
	 * 所属部科
	 * @generated
	 */
	private String skDeptNm;

	/**
	 * 役職
	 * @generated
	 */
	private String skTitleCd;

	/**
	 * 勤務形態
	 * @generated
	 */
	private String skJobForm;

	/**
	 * 薬審メンバー区分
	 * @generated
	 */
	private String skDcctype;

	/**
	 * 施設コード
	 * @generated
	 */
	private String skInsNo;

	/**
	 * 所属部科コード
	 * @generated
	 */
	private String skDeptCd;

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
	 * コンボボックス_医師／薬剤師区分
	 * @generated
	 */
	private LinkedHashMap<String,String> docTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_性別
	 * @generated
	 */
	private LinkedHashMap<String,String> sexCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_改姓日（年）
	 * @generated
	 */
	private LinkedHashMap<String,String> newNameStYearCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_改姓日（月）
	 * @generated
	 */
	private LinkedHashMap<String,String> newNameStMonthCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_改姓日（日）
	 * @generated
	 */
	private LinkedHashMap<String,String> newNameStDayCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_生年月日（年）
	 * @generated
	 */
	private LinkedHashMap<String,String> dobYearCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_生年月日（月）
	 * @generated
	 */
	private LinkedHashMap<String,String> dobMonthCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_生年月日（日）
	 * @generated
	 */
	private LinkedHashMap<String,String> dobDayCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_出身地
	 * @generated
	 */
	private LinkedHashMap<String,String> homeTownCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_出身校
	 * @generated
	 */
	private LinkedHashMap<String,String> medSchoolCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_卒年（西暦）
	 * @generated
	 */
	private LinkedHashMap<String,String> gradYearCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_臨床研修年（西暦）
	 * @generated
	 */
	private LinkedHashMap<String,String> emplYearCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_出身医局校
	 * @generated
	 */
	private LinkedHashMap<String,String> homeUnivCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_専門臓器
	 * @generated
	 */
	private LinkedHashMap<String,String> spLiverCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_専門詳細
	 * @generated
	 */
	private LinkedHashMap<String,String> spDiseaseCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_大学職位
	 * @generated
	 */
	private LinkedHashMap<String,String> skUnivPosCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_役職
	 * @generated
	 */
	private LinkedHashMap<String,String> skTitleCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_勤務形態
	 * @generated
	 */
	private LinkedHashMap<String,String> skJobFormCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_薬審メンバー区分
	 * @generated
	 */
	private LinkedHashMap<String,String> skDcctypeCombo = new LinkedHashMap<String,String>();

	/**
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

    /**
     * ボタンフラグ
     * @generated
     */
    private String buttonFlg;

	/**
	 * 編集可能フラグ
	 * 0:不可、1:可
	 * @generated
	 */
	private String editApprFlg;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND011DTO() {
        setForward(ND011);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setND011(String screenID){
        this.ND011 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getND011(){
        return ND011;
    }

	/**
	 * ND011DTO.javaloginJokenSetCdを設定
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
	 * ND011DTO.javaloginJgiNoを設定
	 * @return loginJgiNo
	 */
	public Integer getLoginJgiNo() {
		return loginJgiNo;
	}

	/**
	 * @param loginJgiNo セットする loginJgiNo
	 */
	public void setLoginJgiNo(Integer loginJgiNo) {
		this.loginJgiNo = loginJgiNo;
	}

	/**
	 * ND011DTO.javaloginNmを設定
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
	 * ND011DTO.javaloginBrCdを設定
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
	 * ND011DTO.javaloginDistCdを設定
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
	 * ND011DTO.javaloginShzNmを設定
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
	 * ND011DTO.javaloginTrtCdを設定
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
	 * ND011DTO.javagamenIdを設定
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
	 * ND011DTO.javatitleを設定
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
	 * ND011DTO.javareqIdを設定
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
	 * ND011DTO.javareqShzNmを設定
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
	 * ND011DTO.javareqStsNmを設定
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
	 * ND011DTO.javareqJgiNameを設定
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
	 * ND011DTO.javareqYmdhmsを設定
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
	 * ND011DTO.javashnShaNameを設定
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
	 * ND011DTO.javashnYmdhmsを設定
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
	 * ND011DTO.javaaprShaNameを設定
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
	 * ND011DTO.javaaprYmdhmsを設定
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
	 * ND011DTO.javareqJgiNoを設定
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
	 * ND011DTO.javareqBrCdを設定
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
	 * ND011DTO.javareqDistCdを設定
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
	 * ND011DTO.javareqStsCdを設定
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
	 * ND011DTO.javashnJgiNoを設定
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
	 * ND011DTO.javaaprJgiNoを設定
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
	 * ND011DTO.javaupdShaYmdを設定
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
	 * ND011DTO.javaultDocNoを設定
	 * @return ultDocNo
	 */
	public String getUltDocNo() {
		return ultDocNo;
	}

	/**
	 * @param ultDocNo セットする ultDocNo
	 */
	public void setUltDocNo(String ultDocNo) {
		this.ultDocNo = ultDocNo;
	}

	/**
	 * ND011DTO.javaultDocNmを設定
	 * @return ultDocNm
	 */
	public String getUltDocNm() {
		return ultDocNm;
	}

	/**
	 * @param ultDocNm セットする ultDocNm
	 */
	public void setUltDocNm(String ultDocNm) {
		this.ultDocNm = ultDocNm;
	}

	/**
	 * ND011DTO.javaultDocKanaを設定
	 * @return ultDocKana
	 */
	public String getUltDocKana() {
		return ultDocKana;
	}

	/**
	 * @param ultDocKana セットする ultDocKana
	 */
	public void setUltDocKana(String ultDocKana) {
		this.ultDocKana = ultDocKana;
	}

	/**
	 * ND011DTO.javadocTypeを設定
	 * @return docType
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * @param docType セットする docType
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/**
	 * ND011DTO.javasexCdを設定
	 * @return sexCd
	 */
	public String getSexCd() {
		return sexCd;
	}

	/**
	 * @param sexCd セットする sexCd
	 */
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}

	/**
	 * ND011DTO.javadocKanjiSeiを設定
	 * @return docKanjiSei
	 */
	public String getDocKanjiSei() {
		return docKanjiSei;
	}

	/**
	 * @param docKanjiSei セットする docKanjiSei
	 */
	public void setDocKanjiSei(String docKanjiSei) {
		this.docKanjiSei = docKanjiSei;
	}

	/**
	 * ND011DTO.javadocKanjiMeiを設定
	 * @return docKanjiMei
	 */
	public String getDocKanjiMei() {
		return docKanjiMei;
	}

	/**
	 * @param docKanjiMei セットする docKanjiMei
	 */
	public void setDocKanjiMei(String docKanjiMei) {
		this.docKanjiMei = docKanjiMei;
	}

	/**
	 * ND011DTO.javadocKanaSeiを設定
	 * @return docKanaSei
	 */
	public String getDocKanaSei() {
		return docKanaSei;
	}

	/**
	 * @param docKanaSei セットする docKanaSei
	 */
	public void setDocKanaSei(String docKanaSei) {
		this.docKanaSei = docKanaSei;
	}

	/**
	 * ND011DTO.javadocKanaMeiを設定
	 * @return docKanaMei
	 */
	public String getDocKanaMei() {
		return docKanaMei;
	}

	/**
	 * @param docKanaMei セットする docKanaMei
	 */
	public void setDocKanaMei(String docKanaMei) {
		this.docKanaMei = docKanaMei;
	}

	/**
	 * ND011DTO.javaoldKanjSeiを設定
	 * @return oldKanjSei
	 */
	public String getOldKanjSei() {
		return oldKanjSei;
	}

	/**
	 * @param oldKanjSei セットする oldKanjSei
	 */
	public void setOldKanjSei(String oldKanjSei) {
		this.oldKanjSei = oldKanjSei;
	}

	/**
	 * ND011DTO.javaoldKanaSeiを設定
	 * @return oldKanaSei
	 */
	public String getOldKanaSei() {
		return oldKanaSei;
	}

	/**
	 * @param oldKanaSei セットする oldKanaSei
	 */
	public void setOldKanaSei(String oldKanaSei) {
		this.oldKanaSei = oldKanaSei;
	}

	/**
	 * ND011DTO.javanewNameStYearを設定
	 * @return newNameStYear
	 */
	public String getNewNameStYear() {
		return newNameStYear;
	}

	/**
	 * @param newNameStYear セットする newNameStYear
	 */
	public void setNewNameStYear(String newNameStYear) {
		this.newNameStYear = newNameStYear;
	}

	/**
	 * ND011DTO.javanewNameStMonthを設定
	 * @return newNameStMonth
	 */
	public String getNewNameStMonth() {
		return newNameStMonth;
	}

	/**
	 * @param newNameStMonth セットする newNameStMonth
	 */
	public void setNewNameStMonth(String newNameStMonth) {
		this.newNameStMonth = newNameStMonth;
	}

	/**
	 * ND011DTO.javanewNameStDayを設定
	 * @return newNameStDay
	 */
	public String getNewNameStDay() {
		return newNameStDay;
	}

	/**
	 * @param newNameStDay セットする newNameStDay
	 */
	public void setNewNameStDay(String newNameStDay) {
		this.newNameStDay = newNameStDay;
	}

	/**
	 * ND011DTO.javadobYearを設定
	 * @return dobYear
	 */
	public String getDobYear() {
		return dobYear;
	}

	/**
	 * @param dobYear セットする dobYear
	 */
	public void setDobYear(String dobYear) {
		this.dobYear = dobYear;
	}

	/**
	 * ND011DTO.javadobMonthを設定
	 * @return dobMonth
	 */
	public String getDobMonth() {
		return dobMonth;
	}

	/**
	 * @param dobMonth セットする dobMonth
	 */
	public void setDobMonth(String dobMonth) {
		this.dobMonth = dobMonth;
	}

	/**
	 * ND011DTO.javadobDayを設定
	 * @return dobDay
	 */
	public String getDobDay() {
		return dobDay;
	}

	/**
	 * @param dobDay セットする dobDay
	 */
	public void setDobDay(String dobDay) {
		this.dobDay = dobDay;
	}

	/**
	 * ND011DTO.javahomeTownCdを設定
	 * @return homeTownCd
	 */
	public String getHomeTownCd() {
		return homeTownCd;
	}

	/**
	 * @param homeTownCd セットする homeTownCd
	 */
	public void setHomeTownCd(String homeTownCd) {
		this.homeTownCd = homeTownCd;
	}

	/**
	 * ND011DTO.javamedSchoolCdを設定
	 * @return medSchoolCd
	 */
	public String getMedSchoolCd() {
		return medSchoolCd;
	}

	/**
	 * @param medSchoolCd セットする medSchoolCd
	 */
	public void setMedSchoolCd(String medSchoolCd) {
		this.medSchoolCd = medSchoolCd;
	}

	/**
	 * ND011DTO.javagradYearを設定
	 * @return gradYear
	 */
	public String getGradYear() {
		return gradYear;
	}

	/**
	 * @param gradYear セットする gradYear
	 */
	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}

	/**
	 * ND011DTO.javaemplYearを設定
	 * @return emplYear
	 */
	public String getEmplYear() {
		return emplYear;
	}

	/**
	 * @param emplYear セットする emplYear
	 */
	public void setEmplYear(String emplYear) {
		this.emplYear = emplYear;
	}

	/**
	 * ND011DTO.javahomeUnivCdを設定
	 * @return homeUnivCd
	 */
	public String getHomeUnivCd() {
		return homeUnivCd;
	}

	/**
	 * @param homeUnivCd セットする homeUnivCd
	 */
	public void setHomeUnivCd(String homeUnivCd) {
		this.homeUnivCd = homeUnivCd;
	}

	/**
	 * ND011DTO.javahomeDeptNmを設定
	 * @return homeDeptNm
	 */
	public String getHomeDeptNm() {
		return homeDeptNm;
	}

	/**
	 * @param homeDeptNm セットする homeDeptNm
	 */
	public void setHomeDeptNm(String homeDeptNm) {
		this.homeDeptNm = homeDeptNm;
	}

	/**
	 * ND011DTO.javaspLiverCdを設定
	 * @return spLiverCd
	 */
	public String getSpLiverCd() {
		return spLiverCd;
	}

	/**
	 * @param spLiverCd セットする spLiverCd
	 */
	public void setSpLiverCd(String spLiverCd) {
		this.spLiverCd = spLiverCd;
	}

	/**
	 * ND011DTO.javaspDiseaseCdを設定
	 * @return spDiseaseCd
	 */
	public String getSpDiseaseCd() {
		return spDiseaseCd;
	}

	/**
	 * @param spDiseaseCd セットする spDiseaseCd
	 */
	public void setSpDiseaseCd(String spDiseaseCd) {
		this.spDiseaseCd = spDiseaseCd;
	}

	/**
	 * ND011DTO.javaspComを設定
	 * @return spCom
	 */
	public String getSpCom() {
		return spCom;
	}

	/**
	 * @param spCom セットする spCom
	 */
	public void setSpCom(String spCom) {
		this.spCom = spCom;
	}

	/**
	 * ND011DTO.javahomeDeptCdを設定
	 * @return homeDeptCd
	 */
	public String getHomeDeptCd() {
		return homeDeptCd;
	}

	/**
	 * @param homeDeptCd セットする homeDeptCd
	 */
	public void setHomeDeptCd(String homeDeptCd) {
		this.homeDeptCd = homeDeptCd;
	}

	/**
	 * ND011DTO.javaBeforeHcpSocietyDataListを設定
	 * @return beforeHcpSocietyDataList
	 */
	public List<HcpSocietyData> getBeforeHcpSocietyDataList() {
		return beforeHcpSocietyDataList;
	}

	/**
	 * @param beforeHcpSocietyDataList セットする beforeHcpSocietyDataList
	 */
	public void setBeforeHcpSocietyDataList(List<HcpSocietyData> beforeHcpSocietyDataList) {
		this.beforeHcpSocietyDataList = beforeHcpSocietyDataList;
	}

	/**
	 * ND011DTO.javaHcpSocietyDataListを設定
	 * @return hcpSocietyDataList
	 */
	public List<HcpSocietyData> getHcpSocietyDataList() {
		return hcpSocietyDataList;
	}

	/**
	 * @param hcpSocietyDataList セットする hcpSocietyDataList
	 */
	public void setHcpSocietyDataList(List<HcpSocietyData> hcpSocietyDataList) {
		this.hcpSocietyDataList = hcpSocietyDataList;
	}

	/**
	 * ND011DTO.javaHcpSocietyDataChgFlgを設定
	 * @return hcpSocietyDataChgFlg
	 */
	public String getHcpSocietyDataChgFlg() {
		return hcpSocietyDataChgFlg;
	}

	/**
	 * @param hcpSocietyDataChgFlg セットする hcpSocietyDataChgFlg
	 */
	public void setHcpSocietyDataChgFlg(String hcpSocietyDataChgFlg) {
		this.hcpSocietyDataChgFlg = hcpSocietyDataChgFlg;
	}

	/**
	 * ND011DTO.javaBeforeHcpPublicDataListを設定
	 * @return beforeHcpPublicDataList
	 */
	public List<HcpPublicData> getBeforeHcpPublicDataList() {
		return beforeHcpPublicDataList;
	}

	/**
	 * @param beforeHcpPublicDataList セットする beforeHcpPublicDataList
	 */
	public void setBeforeHcpPublicDataList(List<HcpPublicData> beforeHcpPublicDataList) {
		this.beforeHcpPublicDataList = beforeHcpPublicDataList;
	}

	/**
	 * ND011DTO.javaHcpPublicDataListを設定
	 * @return hcpPublicDataList
	 */
	public List<HcpPublicData> getHcpPublicDataList() {
		return hcpPublicDataList;
	}

	/**
	 * @param hcpPublicDataList セットする hcpPublicDataList
	 */
	public void setHcpPublicDataList(List<HcpPublicData> hcpPublicDataList) {
		this.hcpPublicDataList = hcpPublicDataList;
	}

	/**
	 * ND011DTO.javaHcpPublicDataChgFlgを設定
	 * @return hcpPublicDataChgFlg
	 */
	public String getHcpPublicDataChgFlg() {
		return hcpPublicDataChgFlg;
	}

	/**
	 * @param hcpPublicDataChgFlg セットする hcpPublicDataChgFlg
	 */
	public void setHcpPublicDataChgFlg(String hcpPublicDataChgFlg) {
		this.hcpPublicDataChgFlg = hcpPublicDataChgFlg;
	}

	/**
	 * ND011DTO.javaskInsNmを設定
	 * @return skInsNm
	 */
	public String getSkInsNm() {
		return skInsNm;
	}

	/**
	 * @param skInsNm セットする skInsNm
	 */
	public void setSkInsNm(String skInsNm) {
		this.skInsNm = skInsNm;
	}

	/**
	 * ND011DTO.javaskUnivPosCdを設定
	 * @return skUnivPosCd
	 */
	public String getSkUnivPosCd() {
		return skUnivPosCd;
	}

	/**
	 * @param skUnivPosCd セットする skUnivPosCd
	 */
	public void setSkUnivPosCd(String skUnivPosCd) {
		this.skUnivPosCd = skUnivPosCd;
	}

	/**
	 * ND011DTO.javaskDeptNmを設定
	 * @return skDeptNm
	 */
	public String getSkDeptNm() {
		return skDeptNm;
	}

	/**
	 * @param skDeptNm セットする skDeptNm
	 */
	public void setSkDeptNm(String skDeptNm) {
		this.skDeptNm = skDeptNm;
	}

	/**
	 * ND011DTO.javaskTitleCdを設定
	 * @return skTitleCd
	 */
	public String getSkTitleCd() {
		return skTitleCd;
	}

	/**
	 * @param skTitleCd セットする skTitleCd
	 */
	public void setSkTitleCd(String skTitleCd) {
		this.skTitleCd = skTitleCd;
	}

	/**
	 * ND011DTO.javaskJobFormを設定
	 * @return skJobForm
	 */
	public String getSkJobForm() {
		return skJobForm;
	}

	/**
	 * @param skJobForm セットする skJobForm
	 */
	public void setSkJobForm(String skJobForm) {
		this.skJobForm = skJobForm;
	}

	/**
	 * ND011DTO.javaskDcctypeを設定
	 * @return skDcctype
	 */
	public String getSkDcctype() {
		return skDcctype;
	}

	/**
	 * @param skDcctype セットする skDcctype
	 */
	public void setSkDcctype(String skDcctype) {
		this.skDcctype = skDcctype;
	}

	/**
	 * ND011DTO.javaskInsNoを設定
	 * @return skInsNo
	 */
	public String getSkInsNo() {
		return skInsNo;
	}

	/**
	 * @param skInsNo セットする skInsNo
	 */
	public void setSkInsNo(String skInsNo) {
		this.skInsNo = skInsNo;
	}

	/**
	 * ND011DTO.javaskDeptCdを設定
	 * @return skDeptCd
	 */
	public String getSkDeptCd() {
		return skDeptCd;
	}

	/**
	 * @param skDeptCd セットする skDeptCd
	 */
	public void setSkDeptCd(String skDeptCd) {
		this.skDeptCd = skDeptCd;
	}

	/**
	 * ND011DTO.javareqCommentを設定
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
	 * ND011DTO.javaaprMemoを設定
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
	 * ND011DTO.javamsgIdを設定
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
	 * ND011DTO.javadisplayKbnを設定
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
	 * ND011DTO.javadocTypeComboを設定
	 * @return docTypeCombo
	 */
	public LinkedHashMap<String, String> getDocTypeCombo() {
		return docTypeCombo;
	}

	/**
	 * @param docTypeCombo セットする docTypeCombo
	 */
	public void setDocTypeCombo(LinkedHashMap<String, String> docTypeCombo) {
		this.docTypeCombo = docTypeCombo;
	}

	/**
	 * ND011DTO.javasexCdComboを設定
	 * @return sexCdCombo
	 */
	public LinkedHashMap<String, String> getSexCdCombo() {
		return sexCdCombo;
	}

	/**
	 * @param sexCdCombo セットする sexCdCombo
	 */
	public void setSexCdCombo(LinkedHashMap<String, String> sexCdCombo) {
		this.sexCdCombo = sexCdCombo;
	}

	/**
	 * ND011DTO.javanewNameStYearComboを設定
	 * @return newNameStYearCombo
	 */
	public LinkedHashMap<String, String> getNewNameStYearCombo() {
		return newNameStYearCombo;
	}

	/**
	 * @param newNameStYearCombo セットする newNameStYearCombo
	 */
	public void setNewNameStYearCombo(LinkedHashMap<String, String> newNameStYearCombo) {
		this.newNameStYearCombo = newNameStYearCombo;
	}

	/**
	 * ND011DTO.javanewNameStMonthComboを設定
	 * @return newNameStMonthCombo
	 */
	public LinkedHashMap<String, String> getNewNameStMonthCombo() {
		return newNameStMonthCombo;
	}

	/**
	 * @param newNameStMonthCombo セットする newNameStMonthCombo
	 */
	public void setNewNameStMonthCombo(LinkedHashMap<String, String> newNameStMonthCombo) {
		this.newNameStMonthCombo = newNameStMonthCombo;
	}

	/**
	 * ND011DTO.javanewNameStDayComboを設定
	 * @return newNameStDayCombo
	 */
	public LinkedHashMap<String, String> getNewNameStDayCombo() {
		return newNameStDayCombo;
	}

	/**
	 * @param newNameStDayCombo セットする newNameStDayCombo
	 */
	public void setNewNameStDayCombo(LinkedHashMap<String, String> newNameStDayCombo) {
		this.newNameStDayCombo = newNameStDayCombo;
	}

	/**
	 * ND011DTO.javadobYearComboを設定
	 * @return dobYearCombo
	 */
	public LinkedHashMap<String, String> getDobYearCombo() {
		return dobYearCombo;
	}

	/**
	 * @param dobYearCombo セットする dobYearCombo
	 */
	public void setDobYearCombo(LinkedHashMap<String, String> dobYearCombo) {
		this.dobYearCombo = dobYearCombo;
	}

	/**
	 * ND011DTO.javadobMonthComboを設定
	 * @return dobMonthCombo
	 */
	public LinkedHashMap<String, String> getDobMonthCombo() {
		return dobMonthCombo;
	}

	/**
	 * @param dobMonthCombo セットする dobMonthCombo
	 */
	public void setDobMonthCombo(LinkedHashMap<String, String> dobMonthCombo) {
		this.dobMonthCombo = dobMonthCombo;
	}

	/**
	 * ND011DTO.javadobDayComboを設定
	 * @return dobDayCombo
	 */
	public LinkedHashMap<String, String> getDobDayCombo() {
		return dobDayCombo;
	}

	/**
	 * @param dobDayCombo セットする dobDayCombo
	 */
	public void setDobDayCombo(LinkedHashMap<String, String> dobDayCombo) {
		this.dobDayCombo = dobDayCombo;
	}

	/**
	 * ND011DTO.javahomeTownCdComboを設定
	 * @return homeTownCdCombo
	 */
	public LinkedHashMap<String, String> getHomeTownCdCombo() {
		return homeTownCdCombo;
	}

	/**
	 * @param homeTownCdCombo セットする homeTownCdCombo
	 */
	public void setHomeTownCdCombo(LinkedHashMap<String, String> homeTownCdCombo) {
		this.homeTownCdCombo = homeTownCdCombo;
	}

	/**
	 * ND011DTO.javamedSchoolCdComboを設定
	 * @return medSchoolCdCombo
	 */
	public LinkedHashMap<String, String> getMedSchoolCdCombo() {
		return medSchoolCdCombo;
	}

	/**
	 * @param medSchoolCdCombo セットする medSchoolCdCombo
	 */
	public void setMedSchoolCdCombo(LinkedHashMap<String, String> medSchoolCdCombo) {
		this.medSchoolCdCombo = medSchoolCdCombo;
	}

	/**
	 * ND011DTO.javagradYearComboを設定
	 * @return gradYearCombo
	 */
	public LinkedHashMap<String, String> getGradYearCombo() {
		return gradYearCombo;
	}

	/**
	 * @param gradYearCombo セットする gradYearCombo
	 */
	public void setGradYearCombo(LinkedHashMap<String, String> gradYearCombo) {
		this.gradYearCombo = gradYearCombo;
	}

	/**
	 * ND011DTO.javaemplYearComboを設定
	 * @return emplYearCombo
	 */
	public LinkedHashMap<String, String> getEmplYearCombo() {
		return emplYearCombo;
	}

	/**
	 * @param emplYearCombo セットする emplYearCombo
	 */
	public void setEmplYearCombo(LinkedHashMap<String, String> emplYearCombo) {
		this.emplYearCombo = emplYearCombo;
	}

	/**
	 * ND011DTO.javahomeUnivCdComboを設定
	 * @return homeUnivCdCombo
	 */
	public LinkedHashMap<String, String> getHomeUnivCdCombo() {
		return homeUnivCdCombo;
	}

	/**
	 * @param homeUnivCdCombo セットする homeUnivCdCombo
	 */
	public void setHomeUnivCdCombo(LinkedHashMap<String, String> homeUnivCdCombo) {
		this.homeUnivCdCombo = homeUnivCdCombo;
	}

	/**
	 * ND011DTO.javaspLiverCdComboを設定
	 * @return spLiverCdCombo
	 */
	public LinkedHashMap<String, String> getSpLiverCdCombo() {
		return spLiverCdCombo;
	}

	/**
	 * @param spLiverCdCombo セットする spLiverCdCombo
	 */
	public void setSpLiverCdCombo(LinkedHashMap<String, String> spLiverCdCombo) {
		this.spLiverCdCombo = spLiverCdCombo;
	}

	/**
	 * ND011DTO.javaspDiseaseCdComboを設定
	 * @return spDiseaseCdCombo
	 */
	public LinkedHashMap<String, String> getSpDiseaseCdCombo() {
		return spDiseaseCdCombo;
	}

	/**
	 * @param spDiseaseCdCombo セットする spDiseaseCdCombo
	 */
	public void setSpDiseaseCdCombo(LinkedHashMap<String, String> spDiseaseCdCombo) {
		this.spDiseaseCdCombo = spDiseaseCdCombo;
	}

	/**
	 * ND011DTO.javaskUnivPosCdComboを設定
	 * @return skUnivPosCdCombo
	 */
	public LinkedHashMap<String, String> getSkUnivPosCdCombo() {
		return skUnivPosCdCombo;
	}

	/**
	 * @param skUnivPosCdCombo セットする skUnivPosCdCombo
	 */
	public void setSkUnivPosCdCombo(LinkedHashMap<String, String> skUnivPosCdCombo) {
		this.skUnivPosCdCombo = skUnivPosCdCombo;
	}

	/**
	 * ND011DTO.javaskTitleCdComboを設定
	 * @return skTitleCdCombo
	 */
	public LinkedHashMap<String, String> getSkTitleCdCombo() {
		return skTitleCdCombo;
	}

	/**
	 * @param skTitleCdCombo セットする skTitleCdCombo
	 */
	public void setSkTitleCdCombo(LinkedHashMap<String, String> skTitleCdCombo) {
		this.skTitleCdCombo = skTitleCdCombo;
	}

	/**
	 * ND011DTO.javaskJobFormComboを設定
	 * @return skJobFormCombo
	 */
	public LinkedHashMap<String, String> getSkJobFormCombo() {
		return skJobFormCombo;
	}

	/**
	 * @param skJobFormCombo セットする skJobFormCombo
	 */
	public void setSkJobFormCombo(LinkedHashMap<String, String> skJobFormCombo) {
		this.skJobFormCombo = skJobFormCombo;
	}

	/**
	 * ND011DTO.javaskDcctypeComboを設定
	 * @return skDcctypeCombo
	 */
	public LinkedHashMap<String, String> getSkDcctypeCombo() {
		return skDcctypeCombo;
	}

	/**
	 * @param skDcctypeCombo セットする skDcctypeCombo
	 */
	public void setSkDcctypeCombo(LinkedHashMap<String, String> skDcctypeCombo) {
		this.skDcctypeCombo = skDcctypeCombo;
	}

	/**
	 * ND011DTO.javashnFlgを設定
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
	 * ND011DTO.javabuttonFlgを設定
	 * @return buttonFlg
	 */
	public String getButtonFlg() {
		return buttonFlg;
	}

	/**
	 * @param buttonFlg セットする buttonFlg
	 */
	public void setButtonFlg(String buttonFlg) {
		this.buttonFlg = buttonFlg;
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
	 * ND011DTO.javaeditApprFlgを設定
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
	 * このDTOの値を返す
	 * @return DTOの値
	 * @generated
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
