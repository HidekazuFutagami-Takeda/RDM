/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_M_MDB_HCP_MST,T_RDM_REQ_KNR,T_RDM_HCP_REQ
 * SQLID : selectND301REQData
 * @generated
 */
public class SelectND301MainDataEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_申請ID(パラメータ1)
     * @generated
     */
    private String inReqId;

    /**
     * 入力_ULT医師コード (パラメータ2)
     * @generated
     */
    private String inUltDocNo;

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
	 * 医師／薬剤師区分(名称)
	 * @generated
	 */
	private String docTypeNm;

    /**
     * 性別
     * @generated
     */
    private String sexCd;

	/**
	 * 性別(名称)
	 * @generated
	 */
	private String sexNm;

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
	 * 出身地(名称)
	 * @generated
	 */
	private String homeTownNm;

    /**
     * 出身校
     * @generated
     */
    private String medSchoolCd;

	/**
	 * 出身校(名称)
	 * @generated
	 */
	private String medSchoolNm;

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
	 * 出身医局校(名称)
	 * @generated
	 */
	private String homeUnivNm;

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
	 * 専門臓器(名称)
	 * @generated
	 */
	private String spLiverNm;

    /**
     * 専門詳細
     * @generated
     */
    private String spDiseaseCd;

	/**
	 * 専門詳細(名称)
	 * @generated
	 */
	private String spDiseaseNm;

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
     * 勤務先施設名
     * @generated
     */
    private String skInsNm;

    /**
     * 大学職位
     * @generated
     */
    private String skUnivPosCd;

	/**
	 * 大学職位(名称)
	 * @generated
	 */
	private String skUnivPosNm;

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
	 * 役職(名称)
	 * @generated
	 */
	private String skTitleNm;

    /**
     * 勤務形態
     * @generated
     */
    private String skJobForm;

	/**
	 * 勤務形態(名称)
	 * @generated
	 */
	private String skJobFormNm;

    /**
     * 薬審メンバー区分
     * @generated
     */
    private String skDcctype;

	/**
	 * 薬審メンバー区分(名称)
	 * @generated
	 */
	private String skDcctypeNm;

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
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

	/**
     * 却下コメント
     * @generated
     */
    private String aprComment;

	/**
	 * アルトマークへの情報連携
	 * @generated
	 */
	private String fbReqFlg;

	/**
	 * 申請チャネル
	 * @generated
	 */
	private String reqChl;

	/**
	 * 施設_対象区分
	 * @generated
	 */
	private String skInsHoInsType;

	/**
	 * 施設_施設分類
	 * @generated
	 */
	private String skInsInsClass;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectND301MainDataEntity() {
        super("t_rdm_hcp_req" , "selectND301REQData");
    }

    /**
     * 入力_申請IDの取得
     * @return 入力_申請ID
     * @generated
     */
    public String getInReqId() {
        return inReqId;
    }

    /**
     * 入力_申請IDの設定
     * @param inInsNo 入力_申請ID
     * @generated
     */
    public void setInReqId(String inReqId) {
        this.inReqId = inReqId;
    }


    /**
	 * SelectND301MainDataEntity.javainUltDocNoを設定
	 * @return inUltDocNo
	 */
	public String getInUltDocNo() {
		return inUltDocNo;
	}

	/**
	 * @param inUltDocNo セットする inUltDocNo
	 */
	public void setInUltDocNo(String inUltDocNo) {
		this.inUltDocNo = inUltDocNo;
	}

	/**
	 * SelectND011MainDataEntity.javareqIdを設定
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
	 * SelectND011MainDataEntity.javareqShzNmを設定
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
	 * SelectND011MainDataEntity.javareqStsNmを設定
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
	 * SelectND011MainDataEntity.javareqJgiNameを設定
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
	 * SelectND011MainDataEntity.javareqYmdhmsを設定
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
	 * SelectND011MainDataEntity.javashnShaNameを設定
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
	 * SelectND011MainDataEntity.javashnYmdhmsを設定
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
	 * SelectND011MainDataEntity.javaaprShaNameを設定
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
	 * SelectND011MainDataEntity.javaaprYmdhmsを設定
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
	 * SelectND011MainDataEntity.javareqJgiNoを設定
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
	 * SelectND011MainDataEntity.javareqBrCdを設定
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
	 * SelectND011MainDataEntity.javareqDistCdを設定
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
	 * SelectND011MainDataEntity.javareqStsCdを設定
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
	 * SelectND011MainDataEntity.javashnJgiNoを設定
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
	 * SelectND011MainDataEntity.javaaprJgiNoを設定
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
	 * SelectND011MainDataEntity.javaupdShaYmdを設定
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
	 * SelectND011MainDataEntity.javaultDocNoを設定
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
	 * SelectND011MainDataEntity.javaultDocNmを設定
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
	 * SelectND011MainDataEntity.javaultDocKanaを設定
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
	 * SelectND011MainDataEntity.javadocTypeを設定
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
	 * SelectND011MainDataEntity.javasexCdを設定
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
	 * SelectND011MainDataEntity.javadocKanjiSeiを設定
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
	 * SelectND011MainDataEntity.javadocKanjiMeiを設定
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
	 * SelectND011MainDataEntity.javadocKanaSeiを設定
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
	 * SelectND011MainDataEntity.javadocKanaMeiを設定
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
	 * SelectND011MainDataEntity.javaoldKanjSeiを設定
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
	 * SelectND011MainDataEntity.javaoldKanaSeiを設定
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
	 * SelectND011MainDataEntity.javanewNameStYearを設定
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
	 * SelectND011MainDataEntity.javanewNameStMonthを設定
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
	 * SelectND011MainDataEntity.javanewNameStDayを設定
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
	 * SelectND011MainDataEntity.javadobYearを設定
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
	 * SelectND011MainDataEntity.javadobMonthを設定
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
	 * SelectND011MainDataEntity.javadobDayを設定
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
	 * SelectND011MainDataEntity.javahomeTownCdを設定
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
	 * SelectND011MainDataEntity.javamedSchoolCdを設定
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
	 * SelectND011MainDataEntity.javagradYearを設定
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
	 * SelectND011MainDataEntity.javaemplYearを設定
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
	 * SelectND011MainDataEntity.javahomeUnivCdを設定
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
	 * SelectND011MainDataEntity.javahomeDeptNmを設定
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
	 * SelectND011MainDataEntity.javaspLiverCdを設定
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
	 * SelectND011MainDataEntity.javaspDiseaseCdを設定
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
	 * SelectND011MainDataEntity.javaspComを設定
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
	 * SelectND011MainDataEntity.javahomeDeptCdを設定
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
	 * SelectND011MainDataEntity.javaskInsNmを設定
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
	 * SelectND011MainDataEntity.javaskUnivPosCdを設定
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
	 * SelectND011MainDataEntity.javaskDeptNmを設定
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
	 * SelectND011MainDataEntity.javaskTitleCdを設定
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
	 * SelectND011MainDataEntity.javaskJobFormを設定
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
	 * SelectND011MainDataEntity.javaskDcctypeを設定
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
	 * SelectND011MainDataEntity.javaskInsNoを設定
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
	 * SelectND011MainDataEntity.javaskDeptCdを設定
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
	 * SelectND011MainDataEntity.javareqCommentを設定
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
	 * SelectND011MainDataEntity.javaaprMemoを設定
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
	 * SelectND011MainDataEntity.javashnFlgを設定
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
	 * SelectND301MainDataEntity.javadocTypeNmを設定
	 * @return docTypeNm
	 */
	public String getDocTypeNm() {
		return docTypeNm;
	}

	/**
	 * @param docTypeNm セットする docTypeNm
	 */
	public void setDocTypeNm(String docTypeNm) {
		this.docTypeNm = docTypeNm;
	}

	/**
	 * SelectND301MainDataEntity.javasexNmを設定
	 * @return sexNm
	 */
	public String getSexNm() {
		return sexNm;
	}

	/**
	 * @param sexNm セットする sexNm
	 */
	public void setSexNm(String sexNm) {
		this.sexNm = sexNm;
	}

	/**
	 * SelectND301MainDataEntity.javahomeTownNmを設定
	 * @return homeTownNm
	 */
	public String getHomeTownNm() {
		return homeTownNm;
	}

	/**
	 * @param homeTownNm セットする homeTownNm
	 */
	public void setHomeTownNm(String homeTownNm) {
		this.homeTownNm = homeTownNm;
	}

	/**
	 * SelectND301MainDataEntity.javamedSchoolNmを設定
	 * @return medSchoolNm
	 */
	public String getMedSchoolNm() {
		return medSchoolNm;
	}

	/**
	 * @param medSchoolNm セットする medSchoolNm
	 */
	public void setMedSchoolNm(String medSchoolNm) {
		this.medSchoolNm = medSchoolNm;
	}

	/**
	 * SelectND301MainDataEntity.javahomeUnivNmを設定
	 * @return homeUnivNm
	 */
	public String getHomeUnivNm() {
		return homeUnivNm;
	}

	/**
	 * @param homeUnivNm セットする homeUnivNm
	 */
	public void setHomeUnivNm(String homeUnivNm) {
		this.homeUnivNm = homeUnivNm;
	}

	/**
	 * SelectND301MainDataEntity.javaspLiverNmを設定
	 * @return spLiverNm
	 */
	public String getSpLiverNm() {
		return spLiverNm;
	}

	/**
	 * @param spLiverNm セットする spLiverNm
	 */
	public void setSpLiverNm(String spLiverNm) {
		this.spLiverNm = spLiverNm;
	}

	/**
	 * SelectND301MainDataEntity.javaspDiseaseNmを設定
	 * @return spDiseaseNm
	 */
	public String getSpDiseaseNm() {
		return spDiseaseNm;
	}

	/**
	 * @param spDiseaseNm セットする spDiseaseNm
	 */
	public void setSpDiseaseNm(String spDiseaseNm) {
		this.spDiseaseNm = spDiseaseNm;
	}

	/**
	 * SelectND301MainDataEntity.javaskUnivPosNmを設定
	 * @return skUnivPosNm
	 */
	public String getSkUnivPosNm() {
		return skUnivPosNm;
	}

	/**
	 * @param skUnivPosNm セットする skUnivPosNm
	 */
	public void setSkUnivPosNm(String skUnivPosNm) {
		this.skUnivPosNm = skUnivPosNm;
	}

	/**
	 * SelectND301MainDataEntity.javaskTitleNmを設定
	 * @return skTitleNm
	 */
	public String getSkTitleNm() {
		return skTitleNm;
	}

	/**
	 * @param skTitleNm セットする skTitleNm
	 */
	public void setSkTitleNm(String skTitleNm) {
		this.skTitleNm = skTitleNm;
	}

	/**
	 * SelectND301MainDataEntity.javaskJobFormNmを設定
	 * @return skJobFormNm
	 */
	public String getSkJobFormNm() {
		return skJobFormNm;
	}

	/**
	 * @param skJobFormNm セットする skJobFormNm
	 */
	public void setSkJobFormNm(String skJobFormNm) {
		this.skJobFormNm = skJobFormNm;
	}

	/**
	 * SelectND301MainDataEntity.javaskDcctypeNmを設定
	 * @return skDcctypeNm
	 */
	public String getSkDcctypeNm() {
		return skDcctypeNm;
	}

	/**
	 * @param skDcctypeNm セットする skDcctypeNm
	 */
	public void setSkDcctypeNm(String skDcctypeNm) {
		this.skDcctypeNm = skDcctypeNm;
	}

	/**
	 * SelectND301MainDataEntity.javaaprCommentを設定
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
	 * SelectND301MainDataEntity.javafbReqFlgを設定
	 * @return fbReqFlg
	 */
	public String getFbReqFlg() {
		return fbReqFlg;
	}

	/**
	 * @param fbReqFlg セットする fbReqFlg
	 */
	public void setFbReqFlg(String fbReqFlg) {
		this.fbReqFlg = fbReqFlg;
	}

	/**
	 * SelectND301MainDataEntity.javareqChlを設定
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
	 * SelectND301MainDataEntity.javaskInsHoInsTypeを設定
	 * @return skInsHoInsType
	 */
	public String getSkInsHoInsType() {
		return skInsHoInsType;
	}

	/**
	 * @param skInsHoInsType セットする skInsHoInsType
	 */
	public void setSkInsHoInsType(String skInsHoInsType) {
		this.skInsHoInsType = skInsHoInsType;
	}

	/**
	 * SelectND301MainDataEntity.javaskInsInsClassを設定
	 * @return skInsInsClass
	 */
	public String getSkInsInsClass() {
		return skInsInsClass;
	}

	/**
	 * @param skInsInsClass セットする skInsInsClass
	 */
	public void setSkInsInsClass(String skInsInsClass) {
		this.skInsInsClass = skInsInsClass;
	}

	/**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
