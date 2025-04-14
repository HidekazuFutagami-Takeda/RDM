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
public class ND012DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String ND012 = "ND012";

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
	 * 武田医師C
	 * @generated
	 */
	private String tkdDocNo;

	/**
	 * 武田医師名(漢字)
	 * @generated
	 */
	private String tkdDocNm;

	/**
	 * 武田医師名(半角カナ)
	 * @generated
	 */
	private String tkdDocKana;

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
	 * (変更前)医師／薬剤師区分
	 * @generated
	 */
	private String mstDocType;

	/**
	 * (変更前)医師／薬剤師区分名
	 * @generated
	 */
	private String mstDocTypeNm;

	/**
	 * (変更前)性別コード
	 * @generated
	 */
	private String mstSexCd;

	/**
	 * (変更前)性別名
	 * @generated
	 */
	private String mstSexNm;

	/**
	 * (変更前)医師名(漢字)姓
	 * @generated
	 */
	private String mstDocKanjiSei;

	/**
	 * (変更前)医師名(漢字)名
	 * @generated
	 */
	private String mstDocKanjiMei;

	/**
	 * (変更前)医師名(半角カナ)姓
	 * @generated
	 */
	private String mstDocKanaSei;

	/**
	 * (変更前)医師名(半角カナ)名
	 * @generated
	 */
	private String mstDocKanaMei;

	/**
	 * (変更前)旧姓(漢字)姓
	 * @generated
	 */
	private String mstOldKanjSei;

	/**
	 * (変更前)旧姓(半角カナ)姓
	 * @generated
	 */
	private String mstOldKanaSei;

	/**
	 * (変更前)改姓日（年）
	 * @generated
	 */
	private String mstNewNameStYear;

	/**
	 * (変更前)改姓日（月）
	 * @generated
	 */
	private String mstNewNameStMonth;

	/**
	 * (変更前)改姓日（日）
	 * @generated
	 */
	private String mstNewNameStDay;

	/**
	 * (変更前)生年月日（年）
	 * @generated
	 */
	private String mstDobYear;

	/**
	 * (変更前)生年月日（月）
	 * @generated
	 */
	private String mstDobMonth;

	/**
	 * (変更前)生年月日（日）
	 * @generated
	 */
	private String mstDobDay;

	/**
	 * (変更前)出身地コード
	 * @generated
	 */
	private String mstHomeTownCd;

	/**
	 * (変更前)出身地名
	 * @generated
	 */
	private String mstHomeTownNm;

	/**
	 * (変更前)出身校コード
	 * @generated
	 */
	private String mstMedSchoolCd;

	/**
	 * (変更前)出身校名
	 * @generated
	 */
	private String mstMedSchoolNm;

	/**
	 * (変更前)卒年（西暦）
	 * @generated
	 */
	private String mstGradYear;

	/**
	 * (変更前)臨床研修年（西暦）
	 * @generated
	 */
	private String mstEmplYear;

	/**
	 * (変更前)出身医局校コード
	 * @generated
	 */
	private String mstHomeUnivCd;

	/**
	 * (変更前)出身医局校名称
	 * @generated
	 */
	private String mstHomeUnivNm;

	/**
	 * (変更前)出身所属部科コード
	 * @generated
	 */
	private String mstHomeDeptCd;

	/**
	 * (変更前)出身所属部科名称
	 * @generated
	 */
	private String mstHomeDeptNm;

	/**
	 * (変更前)専門臓器コード
	 * @generated
	 */
	private String mstSpLiverCd;

	/**
	 * (変更前)専門臓器名称
	 * @generated
	 */
	private String mstSpLiverNm;

	/**
	 * (変更前)専門詳細コード
	 * @generated
	 */
	private String mstSpDiseaseCd;

	/**
	 * (変更前)専門詳細名称
	 * @generated
	 */
	private String mstSpDiseaseNm;

	/**
	 * (変更前)専門追加情報
	 * @generated
	 */
	private String mstSpCom;
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
	 * 承認・却下コメント
	 * @generated
	 */
	private String aprComment;

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
	 * 勤務ボタン可否フラグ
	 * 0:不可、1:可
	 * @generated
	 */
	private String btnEnableFlg;

	/**
	 * 申請チャネル
	 * @generated
	 */
	private String reqChl;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND012DTO() {
        setForward(ND012);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setND012(String screenID){
        this.ND012 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getND012(){
        return ND012;
    }

	/**
	 * ND012DTO.javaloginJokenSetCdを設定
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
	 * ND012DTO.javaloginJgiNoを設定
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
	 * ND012DTO.javaloginNmを設定
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
	 * ND012DTO.javaloginBrCdを設定
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
	 * ND012DTO.javaloginDistCdを設定
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
	 * ND012DTO.javaloginShzNmを設定
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
	 * ND012DTO.javaloginTrtCdを設定
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
	 * ND012DTO.javagamenIdを設定
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
	 * ND012DTO.javatitleを設定
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
	 * ND012DTO.javareqIdを設定
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
	 * ND012DTO.javareqShzNmを設定
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
	 * ND012DTO.javareqStsNmを設定
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
	 * ND012DTO.javareqJgiNameを設定
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
	 * ND012DTO.javareqYmdhmsを設定
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
	 * ND012DTO.javashnShaNameを設定
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
	 * ND012DTO.javashnYmdhmsを設定
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
	 * ND012DTO.javaaprShaNameを設定
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
	 * ND012DTO.javaaprYmdhmsを設定
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
	 * ND012DTO.javareqJgiNoを設定
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
	 * ND012DTO.javareqBrCdを設定
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
	 * ND012DTO.javareqDistCdを設定
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
	 * ND012DTO.javareqStsCdを設定
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
	 * ND012DTO.javashnJgiNoを設定
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
	 * ND012DTO.javaaprJgiNoを設定
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
	 * ND012DTO.javaupdShaYmdを設定
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
	 * ND012DTO.javaultDocNoを設定
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
	 * ND012DTO.javaultDocNmを設定
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
	 * ND012DTO.javaultDocKanaを設定
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
	 * ND012DTO.javadocTypeを設定
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
	 * ND012DTO.javasexCdを設定
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
	 * ND012DTO.javadocKanjiSeiを設定
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
	 * ND012DTO.javadocKanjiMeiを設定
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
	 * ND012DTO.javadocKanaSeiを設定
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
	 * ND012DTO.javadocKanaMeiを設定
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
	 * ND012DTO.javaoldKanjSeiを設定
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
	 * ND012DTO.javaoldKanaSeiを設定
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
	 * ND012DTO.javanewNameStYearを設定
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
	 * ND012DTO.javanewNameStMonthを設定
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
	 * ND012DTO.javanewNameStDayを設定
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
	 * ND012DTO.javadobYearを設定
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
	 * ND012DTO.javadobMonthを設定
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
	 * ND012DTO.javadobDayを設定
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
	 * ND012DTO.javahomeTownCdを設定
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
	 * ND012DTO.javamedSchoolCdを設定
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
	 * ND012DTO.javagradYearを設定
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
	 * ND012DTO.javaemplYearを設定
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
	 * ND012DTO.javahomeUnivCdを設定
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
	 * ND012DTO.javahomeDeptNmを設定
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
	 * ND012DTO.javaspLiverCdを設定
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
	 * ND012DTO.javaspDiseaseCdを設定
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
	 * ND012DTO.javaspComを設定
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
	 * ND012DTO.javahomeDeptCdを設定
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
	 * ND012DTO.javaBeforeHcpSocietyDataListを設定
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
	 * ND012DTO.javaHcpSocietyDataListを設定
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
	 * ND012DTO.javaHcpSocietyDataChgFlgを設定
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
	 * ND012DTO.javaBeforeHcpPublicDataListを設定
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
	 * ND012DTO.javaHcpPublicDataListを設定
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
	 * ND012DTO.javaHcpPublicDataChgFlgを設定
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
	 * ND012DTO.javaskInsNmを設定
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
	 * ND012DTO.javaskUnivPosCdを設定
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
	 * ND012DTO.javaskDeptNmを設定
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
	 * ND012DTO.javaskTitleCdを設定
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
	 * ND012DTO.javaskJobFormを設定
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
	 * ND012DTO.javaskDcctypeを設定
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
	 * ND012DTO.javaskInsNoを設定
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
	 * ND012DTO.javaskDeptCdを設定
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
	 * ND012DTO.javareqCommentを設定
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
	 * ND012DTO.javaaprMemoを設定
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
	 * ND012DTO.javaaprCommentを設定
	 * @return aprComment
	 */
	public String getAprComment() {
		return aprComment;
	}

	/**
	 * @param aprComment セットする aprComment
	 */
	public void setAprComment(String aprComment) {
		this.aprComment = aprComment;
	}

	/**
	 * ND012DTO.javamsgIdを設定
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
	 * ND012DTO.javadisplayKbnを設定
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
	 * ND012DTO.javadocTypeComboを設定
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
	 * ND012DTO.javasexCdComboを設定
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
	 * ND012DTO.javanewNameStYearComboを設定
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
	 * ND012DTO.javanewNameStMonthComboを設定
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
	 * ND012DTO.javanewNameStDayComboを設定
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
	 * ND012DTO.javadobYearComboを設定
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
	 * ND012DTO.javadobMonthComboを設定
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
	 * ND012DTO.javadobDayComboを設定
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
	 * ND012DTO.javahomeTownCdComboを設定
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
	 * ND012DTO.javamedSchoolCdComboを設定
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
	 * ND012DTO.javagradYearComboを設定
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
	 * ND012DTO.javaemplYearComboを設定
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
	 * ND012DTO.javahomeUnivCdComboを設定
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
	 * ND012DTO.javaspLiverCdComboを設定
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
	 * ND012DTO.javaspDiseaseCdComboを設定
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
	 * ND012DTO.javaskUnivPosCdComboを設定
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
	 * ND012DTO.javaskTitleCdComboを設定
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
	 * ND012DTO.javaskJobFormComboを設定
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
	 * ND012DTO.javaskDcctypeComboを設定
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
	 * ND012DTO.javashnFlgを設定
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
	 * ND012DTO.javabuttonFlgを設定
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
	 * ND012DTO.javamsgStrを設定
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
	 * ND012DTO.javaeditApprFlgを設定
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
	 * ND012DTO.javatkdDocNoを設定
	 * @return tkdDocNo
	 */
	public String getTkdDocNo() {
		return tkdDocNo;
	}

	/**
	 * @param tkdDocNo セットする tkdDocNo
	 */
	public void setTkdDocNo(String tkdDocNo) {
		this.tkdDocNo = tkdDocNo;
	}

	/**
	 * ND012DTO.javatkdDocNmを設定
	 * @return tkdDocNm
	 */
	public String getTkdDocNm() {
		return tkdDocNm;
	}

	/**
	 * @param tkdDocNm セットする tkdDocNm
	 */
	public void setTkdDocNm(String tkdDocNm) {
		this.tkdDocNm = tkdDocNm;
	}

	/**
	 * ND012DTO.javatkdDocKanaを設定
	 * @return tkdDocKana
	 */
	public String getTkdDocKana() {
		return tkdDocKana;
	}

	/**
	 * @param tkdDocKana セットする tkdDocKana
	 */
	public void setTkdDocKana(String tkdDocKana) {
		this.tkdDocKana = tkdDocKana;
	}

	/**
	 * ND012DTO.javamstDocTypeを設定
	 * @return mstDocType
	 */
	public String getMstDocType() {
		return mstDocType;
	}

	/**
	 * @param mstDocType セットする mstDocType
	 */
	public void setMstDocType(String mstDocType) {
		this.mstDocType = mstDocType;
	}

	/**
	 * ND012DTO.javamstDocTypeNmを設定
	 * @return mstDocTypeNm
	 */
	public String getMstDocTypeNm() {
		return mstDocTypeNm;
	}

	/**
	 * @param mstDocTypeNm セットする mstDocTypeNm
	 */
	public void setMstDocTypeNm(String mstDocTypeNm) {
		this.mstDocTypeNm = mstDocTypeNm;
	}

	/**
	 * ND012DTO.javamstSexCdを設定
	 * @return mstSexCd
	 */
	public String getMstSexCd() {
		return mstSexCd;
	}

	/**
	 * @param mstSexCd セットする mstSexCd
	 */
	public void setMstSexCd(String mstSexCd) {
		this.mstSexCd = mstSexCd;
	}

	/**
	 * ND012DTO.javamstSexNmを設定
	 * @return mstSexNm
	 */
	public String getMstSexNm() {
		return mstSexNm;
	}

	/**
	 * @param mstSexNm セットする mstSexNm
	 */
	public void setMstSexNm(String mstSexNm) {
		this.mstSexNm = mstSexNm;
	}

	/**
	 * ND012DTO.javamstDocKanjiSeiを設定
	 * @return mstDocKanjiSei
	 */
	public String getMstDocKanjiSei() {
		return mstDocKanjiSei;
	}

	/**
	 * @param mstDocKanjiSei セットする mstDocKanjiSei
	 */
	public void setMstDocKanjiSei(String mstDocKanjiSei) {
		this.mstDocKanjiSei = mstDocKanjiSei;
	}

	/**
	 * ND012DTO.javamstDocKanjiMeiを設定
	 * @return mstDocKanjiMei
	 */
	public String getMstDocKanjiMei() {
		return mstDocKanjiMei;
	}

	/**
	 * @param mstDocKanjiMei セットする mstDocKanjiMei
	 */
	public void setMstDocKanjiMei(String mstDocKanjiMei) {
		this.mstDocKanjiMei = mstDocKanjiMei;
	}

	/**
	 * ND012DTO.javamstDocKanaSeiを設定
	 * @return mstDocKanaSei
	 */
	public String getMstDocKanaSei() {
		return mstDocKanaSei;
	}

	/**
	 * @param mstDocKanaSei セットする mstDocKanaSei
	 */
	public void setMstDocKanaSei(String mstDocKanaSei) {
		this.mstDocKanaSei = mstDocKanaSei;
	}

	/**
	 * ND012DTO.javamstDocKanaMeiを設定
	 * @return mstDocKanaMei
	 */
	public String getMstDocKanaMei() {
		return mstDocKanaMei;
	}

	/**
	 * @param mstDocKanaMei セットする mstDocKanaMei
	 */
	public void setMstDocKanaMei(String mstDocKanaMei) {
		this.mstDocKanaMei = mstDocKanaMei;
	}

	/**
	 * ND012DTO.javamstOldKanjSeiを設定
	 * @return mstOldKanjSei
	 */
	public String getMstOldKanjSei() {
		return mstOldKanjSei;
	}

	/**
	 * @param mstOldKanjSei セットする mstOldKanjSei
	 */
	public void setMstOldKanjSei(String mstOldKanjSei) {
		this.mstOldKanjSei = mstOldKanjSei;
	}

	/**
	 * ND012DTO.javamstOldKanaSeiを設定
	 * @return mstOldKanaSei
	 */
	public String getMstOldKanaSei() {
		return mstOldKanaSei;
	}

	/**
	 * @param mstOldKanaSei セットする mstOldKanaSei
	 */
	public void setMstOldKanaSei(String mstOldKanaSei) {
		this.mstOldKanaSei = mstOldKanaSei;
	}

	/**
	 * ND012DTO.javamstNewNameStYearを設定
	 * @return mstNewNameStYear
	 */
	public String getMstNewNameStYear() {
		return mstNewNameStYear;
	}

	/**
	 * @param mstNewNameStYear セットする mstNewNameStYear
	 */
	public void setMstNewNameStYear(String mstNewNameStYear) {
		this.mstNewNameStYear = mstNewNameStYear;
	}

	/**
	 * ND012DTO.javamstNewNameStMonthを設定
	 * @return mstNewNameStMonth
	 */
	public String getMstNewNameStMonth() {
		return mstNewNameStMonth;
	}

	/**
	 * @param mstNewNameStMonth セットする mstNewNameStMonth
	 */
	public void setMstNewNameStMonth(String mstNewNameStMonth) {
		this.mstNewNameStMonth = mstNewNameStMonth;
	}

	/**
	 * ND012DTO.javamstNewNameStDayを設定
	 * @return mstNewNameStDay
	 */
	public String getMstNewNameStDay() {
		return mstNewNameStDay;
	}

	/**
	 * @param mstNewNameStDay セットする mstNewNameStDay
	 */
	public void setMstNewNameStDay(String mstNewNameStDay) {
		this.mstNewNameStDay = mstNewNameStDay;
	}

	/**
	 * ND012DTO.javamstDobYearを設定
	 * @return mstDobYear
	 */
	public String getMstDobYear() {
		return mstDobYear;
	}

	/**
	 * @param mstDobYear セットする mstDobYear
	 */
	public void setMstDobYear(String mstDobYear) {
		this.mstDobYear = mstDobYear;
	}

	/**
	 * ND012DTO.javamstDobMonthを設定
	 * @return mstDobMonth
	 */
	public String getMstDobMonth() {
		return mstDobMonth;
	}

	/**
	 * @param mstDobMonth セットする mstDobMonth
	 */
	public void setMstDobMonth(String mstDobMonth) {
		this.mstDobMonth = mstDobMonth;
	}

	/**
	 * ND012DTO.javamstDobDayを設定
	 * @return mstDobDay
	 */
	public String getMstDobDay() {
		return mstDobDay;
	}

	/**
	 * @param mstDobDay セットする mstDobDay
	 */
	public void setMstDobDay(String mstDobDay) {
		this.mstDobDay = mstDobDay;
	}

	/**
	 * ND012DTO.javamstHomeTownCdを設定
	 * @return mstHomeTownCd
	 */
	public String getMstHomeTownCd() {
		return mstHomeTownCd;
	}

	/**
	 * @param mstHomeTownCd セットする mstHomeTownCd
	 */
	public void setMstHomeTownCd(String mstHomeTownCd) {
		this.mstHomeTownCd = mstHomeTownCd;
	}

	/**
	 * ND012DTO.javamstHomeTownNmを設定
	 * @return mstHomeTownNm
	 */
	public String getMstHomeTownNm() {
		return mstHomeTownNm;
	}

	/**
	 * @param mstHomeTownNm セットする mstHomeTownNm
	 */
	public void setMstHomeTownNm(String mstHomeTownNm) {
		this.mstHomeTownNm = mstHomeTownNm;
	}

	/**
	 * ND012DTO.javamstMedSchoolCdを設定
	 * @return mstMedSchoolCd
	 */
	public String getMstMedSchoolCd() {
		return mstMedSchoolCd;
	}

	/**
	 * @param mstMedSchoolCd セットする mstMedSchoolCd
	 */
	public void setMstMedSchoolCd(String mstMedSchoolCd) {
		this.mstMedSchoolCd = mstMedSchoolCd;
	}

	/**
	 * ND012DTO.javamstMedSchoolNmを設定
	 * @return mstMedSchoolNm
	 */
	public String getMstMedSchoolNm() {
		return mstMedSchoolNm;
	}

	/**
	 * @param mstMedSchoolNm セットする mstMedSchoolNm
	 */
	public void setMstMedSchoolNm(String mstMedSchoolNm) {
		this.mstMedSchoolNm = mstMedSchoolNm;
	}

	/**
	 * ND012DTO.javamstGradYearを設定
	 * @return mstGradYear
	 */
	public String getMstGradYear() {
		return mstGradYear;
	}

	/**
	 * @param mstGradYear セットする mstGradYear
	 */
	public void setMstGradYear(String mstGradYear) {
		this.mstGradYear = mstGradYear;
	}

	/**
	 * ND012DTO.javamstEmplYearを設定
	 * @return mstEmplYear
	 */
	public String getMstEmplYear() {
		return mstEmplYear;
	}

	/**
	 * @param mstEmplYear セットする mstEmplYear
	 */
	public void setMstEmplYear(String mstEmplYear) {
		this.mstEmplYear = mstEmplYear;
	}

	/**
	 * ND012DTO.javamstHomeUnivCdを設定
	 * @return mstHomeUnivCd
	 */
	public String getMstHomeUnivCd() {
		return mstHomeUnivCd;
	}

	/**
	 * @param mstHomeUnivCd セットする mstHomeUnivCd
	 */
	public void setMstHomeUnivCd(String mstHomeUnivCd) {
		this.mstHomeUnivCd = mstHomeUnivCd;
	}

	/**
	 * ND012DTO.javamstHomeUnivNmを設定
	 * @return mstHomeUnivNm
	 */
	public String getMstHomeUnivNm() {
		return mstHomeUnivNm;
	}

	/**
	 * @param mstHomeUnivNm セットする mstHomeUnivNm
	 */
	public void setMstHomeUnivNm(String mstHomeUnivNm) {
		this.mstHomeUnivNm = mstHomeUnivNm;
	}

	/**
	 * ND012DTO.javamstHomeDeptCdを設定
	 * @return mstHomeDeptCd
	 */
	public String getMstHomeDeptCd() {
		return mstHomeDeptCd;
	}

	/**
	 * @param mstHomeDeptCd セットする mstHomeDeptCd
	 */
	public void setMstHomeDeptCd(String mstHomeDeptCd) {
		this.mstHomeDeptCd = mstHomeDeptCd;
	}

	/**
	 * ND012DTO.javamstHomeDeptNmを設定
	 * @return mstHomeDeptNm
	 */
	public String getMstHomeDeptNm() {
		return mstHomeDeptNm;
	}

	/**
	 * @param mstHomeDeptNm セットする mstHomeDeptNm
	 */
	public void setMstHomeDeptNm(String mstHomeDeptNm) {
		this.mstHomeDeptNm = mstHomeDeptNm;
	}

	/**
	 * ND012DTO.javamstSpLiverCdを設定
	 * @return mstSpLiverCd
	 */
	public String getMstSpLiverCd() {
		return mstSpLiverCd;
	}

	/**
	 * @param mstSpLiverCd セットする mstSpLiverCd
	 */
	public void setMstSpLiverCd(String mstSpLiverCd) {
		this.mstSpLiverCd = mstSpLiverCd;
	}

	/**
	 * ND012DTO.javamstSpLiverNmを設定
	 * @return mstSpLiverNm
	 */
	public String getMstSpLiverNm() {
		return mstSpLiverNm;
	}

	/**
	 * @param mstSpLiverNm セットする mstSpLiverNm
	 */
	public void setMstSpLiverNm(String mstSpLiverNm) {
		this.mstSpLiverNm = mstSpLiverNm;
	}

	/**
	 * ND012DTO.javamstSpDiseaseCdを設定
	 * @return mstSpDiseaseCd
	 */
	public String getMstSpDiseaseCd() {
		return mstSpDiseaseCd;
	}

	/**
	 * @param mstSpDiseaseCd セットする mstSpDiseaseCd
	 */
	public void setMstSpDiseaseCd(String mstSpDiseaseCd) {
		this.mstSpDiseaseCd = mstSpDiseaseCd;
	}

	/**
	 * ND012DTO.javamstSpDiseaseNmを設定
	 * @return mstSpDiseaseNm
	 */
	public String getMstSpDiseaseNm() {
		return mstSpDiseaseNm;
	}

	/**
	 * @param mstSpDiseaseNm セットする mstSpDiseaseNm
	 */
	public void setMstSpDiseaseNm(String mstSpDiseaseNm) {
		this.mstSpDiseaseNm = mstSpDiseaseNm;
	}

	/**
	 * ND012DTO.javamstSpComを設定
	 * @return mstSpCom
	 */
	public String getMstSpCom() {
		return mstSpCom;
	}

	/**
	 * @param mstSpCom セットする mstSpCom
	 */
	public void setMstSpCom(String mstSpCom) {
		this.mstSpCom = mstSpCom;
	}

	/**
	 * ND012DTO.javabtnEnableFlgを設定
	 * @return btnEnableFlg
	 */
	public String getBtnEnableFlg() {
		return btnEnableFlg;
	}

	/**
	 * @param btnEnableFlg セットする btnEnableFlg
	 */
	public void setBtnEnableFlg(String btnEnableFlg) {
		this.btnEnableFlg = btnEnableFlg;
	}

	/**
	 * ND012DTO.javareqChlを設定
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
	 * このDTOの値を返す
	 * @return DTOの値
	 * @generated
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
