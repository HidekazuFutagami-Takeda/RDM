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
 * SQLID : selectND012ULTData,selectND012REQData
 * @generated
 */
public class SelectND012MainDataEntity extends BaseEntity implements Serializable {

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
     * 入力_医師コード (パラメータ2)
     * @generated
     */
    private String inDocNo;

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
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

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
     * コンストラクタ
     * @generated
     */
    public SelectND012MainDataEntity() {
        super("t_rdm_hcp_req" , "selectND012REQData");
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
     * 入力_医師コードの取得
     * @return 入力_医師コード
     * @generated
     */
    public String getInDocNo() {
        return inDocNo;
    }

    /**
     * 入力_医師コードの設定
     * @param inDocNo 入力_医師コード
     * @generated
     */
    public void setInDocNo(String inDocNo) {
        this.inDocNo = inDocNo;
    }



    /**
	 * SelectND012MainDataEntity.javareqIdを設定
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
	 * SelectND012MainDataEntity.javareqShzNmを設定
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
	 * SelectND012MainDataEntity.javareqStsNmを設定
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
	 * SelectND012MainDataEntity.javareqJgiNameを設定
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
	 * SelectND012MainDataEntity.javareqYmdhmsを設定
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
	 * SelectND012MainDataEntity.javashnShaNameを設定
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
	 * SelectND012MainDataEntity.javashnYmdhmsを設定
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
	 * SelectND012MainDataEntity.javaaprShaNameを設定
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
	 * SelectND012MainDataEntity.javaaprYmdhmsを設定
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
	 * SelectND012MainDataEntity.javareqJgiNoを設定
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
	 * SelectND012MainDataEntity.javareqBrCdを設定
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
	 * SelectND012MainDataEntity.javareqDistCdを設定
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
	 * SelectND012MainDataEntity.javareqStsCdを設定
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
	 * SelectND012MainDataEntity.javashnJgiNoを設定
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
	 * SelectND012MainDataEntity.javaaprJgiNoを設定
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
	 * SelectND012MainDataEntity.javaupdShaYmdを設定
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
	 * SelectND012MainDataEntity.javaultDocNoを設定
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
	 * SelectND012MainDataEntity.javaultDocNmを設定
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
	 * SelectND012MainDataEntity.javaultDocKanaを設定
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
	 * SelectND012MainDataEntity.javadocTypeを設定
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
	 * SelectND012MainDataEntity.javasexCdを設定
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
	 * SelectND012MainDataEntity.javadocKanjiSeiを設定
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
	 * SelectND012MainDataEntity.javadocKanjiMeiを設定
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
	 * SelectND012MainDataEntity.javadocKanaSeiを設定
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
	 * SelectND012MainDataEntity.javadocKanaMeiを設定
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
	 * SelectND012MainDataEntity.javaoldKanjSeiを設定
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
	 * SelectND012MainDataEntity.javaoldKanaSeiを設定
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
	 * SelectND012MainDataEntity.javanewNameStYearを設定
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
	 * SelectND012MainDataEntity.javanewNameStMonthを設定
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
	 * SelectND012MainDataEntity.javanewNameStDayを設定
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
	 * SelectND012MainDataEntity.javadobYearを設定
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
	 * SelectND012MainDataEntity.javadobMonthを設定
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
	 * SelectND012MainDataEntity.javadobDayを設定
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
	 * SelectND012MainDataEntity.javahomeTownCdを設定
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
	 * SelectND012MainDataEntity.javamedSchoolCdを設定
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
	 * SelectND012MainDataEntity.javagradYearを設定
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
	 * SelectND012MainDataEntity.javaemplYearを設定
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
	 * SelectND012MainDataEntity.javahomeUnivCdを設定
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
	 * SelectND012MainDataEntity.javahomeDeptNmを設定
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
	 * SelectND012MainDataEntity.javaspLiverCdを設定
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
	 * SelectND012MainDataEntity.javaspDiseaseCdを設定
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
	 * SelectND012MainDataEntity.javaspComを設定
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
	 * SelectND012MainDataEntity.javahomeDeptCdを設定
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
	 * SelectND012MainDataEntity.javaskInsNmを設定
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
	 * SelectND012MainDataEntity.javaskUnivPosCdを設定
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
	 * SelectND012MainDataEntity.javaskDeptNmを設定
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
	 * SelectND012MainDataEntity.javaskTitleCdを設定
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
	 * SelectND012MainDataEntity.javaskJobFormを設定
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
	 * SelectND012MainDataEntity.javaskDcctypeを設定
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
	 * SelectND012MainDataEntity.javaskInsNoを設定
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
	 * SelectND012MainDataEntity.javaskDeptCdを設定
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
	 * SelectND012MainDataEntity.javareqCommentを設定
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
	 * SelectND012MainDataEntity.javaaprMemoを設定
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
	 * SelectND012MainDataEntity.javaaprCommentを設定
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
	 * SelectND012MainDataEntity.javashnFlgを設定
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
	 * SelectND012MainDataEntity.javamstDocTypeを設定
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
	 * SelectND012MainDataEntity.javamstDocTypeNmを設定
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
	 * SelectND012MainDataEntity.javamstSexCdを設定
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
	 * SelectND012MainDataEntity.javamstSexNmを設定
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
	 * SelectND012MainDataEntity.javamstDocKanjiSeiを設定
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
	 * SelectND012MainDataEntity.javamstDocKanjiMeiを設定
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
	 * SelectND012MainDataEntity.javamstDocKanaSeiを設定
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
	 * SelectND012MainDataEntity.javamstDocKanaMeiを設定
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
	 * SelectND012MainDataEntity.javamstOldKanjSeiを設定
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
	 * SelectND012MainDataEntity.javamstOldKanaSeiを設定
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
	 * SelectND012MainDataEntity.javamstNewNameStYearを設定
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
	 * SelectND012MainDataEntity.javamstNewNameStMonthを設定
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
	 * SelectND012MainDataEntity.javamstNewNameStDayを設定
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
	 * SelectND012MainDataEntity.javamstDobYearを設定
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
	 * SelectND012MainDataEntity.javamstDobMonthを設定
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
	 * SelectND012MainDataEntity.javamstDobDayを設定
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
	 * SelectND012MainDataEntity.javamstHomeTownCdを設定
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
	 * SelectND012MainDataEntity.javamstHomeTownNmを設定
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
	 * SelectND012MainDataEntity.javamstMedSchoolCdを設定
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
	 * SelectND012MainDataEntity.javamstMedSchoolNmを設定
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
	 * SelectND012MainDataEntity.javamstGradYearを設定
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
	 * SelectND012MainDataEntity.javamstEmplYearを設定
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
	 * SelectND012MainDataEntity.javamstHomeUnivCdを設定
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
	 * SelectND012MainDataEntity.javamstHomeUnivNmを設定
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
	 * SelectND012MainDataEntity.javamstHomeDeptCdを設定
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
	 * SelectND012MainDataEntity.javamstHomeDeptNmを設定
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
	 * SelectND012MainDataEntity.javamstSpLiverCdを設定
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
	 * SelectND012MainDataEntity.javamstSpLiverNmを設定
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
	 * SelectND012MainDataEntity.javamstSpDiseaseCdを設定
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
	 * SelectND012MainDataEntity.javamstSpDiseaseNmを設定
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
	 * SelectND012MainDataEntity.javamstSpComを設定
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
	 * SelectND012MainDataEntity.javatkdDocNoを設定
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
	 * SelectND012MainDataEntity.javatkdDocNmを設定
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
	 * SelectND012MainDataEntity.javatkdDocKanaを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
