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
 * テーブル物理名 : M_RDM_HCO_MST,T_RDM_REQ_KNR,T_RDM_HCP_REQ
 * SQLID : selectNF011ULTData,selectNF011REQData
 * @generated
 */
public class SelectNF011MainDataEntity extends BaseEntity implements Serializable {

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
     * 入力_ULT施設コード (パラメータ2)
     * @generated
     */
    private String inUltInsNo;

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
     * DCF施設コード
     * @generated
     */
    private String dcfShisetsuCd;

    /**
     * 施設名
     * @generated
     */
    private String shisetsuNm;

    /**
     * 施設名カナ
     * @generated
     */
    private String shisetsuNmKana;

    /**
     * 施設名略名
     * @generated
     */
    private String shisetsuNmRyaku;

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
	 * 取引区分
	 * @generated
	 */
	private String tradeType;

    /**
     * 開業予定年月
     * @generated
     */
    private String kaigyoYm;

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
     * 郵便番号
     * @generated
     */
    private String yubinNo;

    /**
     * 都道府県コード
     * @generated
     */
    private String todofukenCd;

    /**
     * 都道府県コード
     * @generated
     */
    private String todofukenNm;

    /**
     * 市区町村コード
     * @generated
     */
    private String shikuchosonCd;

    /**
     * 市区町村名
     * @generated
     */
    private String shikuchosonNm;

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
	 * 武田市区郡コード
	 * @generated
	 */
	private String tkCityNm;

    /**
     * 住所
     * @generated
     */
    private String address;

    /**
     *　住所カナ
     * @generated
     */
    private String addressKana;

    /**
     *　施設電話番号
     * @generated
     */
    private String shisetsuTel;

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
     *　許可病床数合計
     * @generated
     */
    private String kyokabyoshosuSum;

	/**
	 * 医療ベッド数計
	 * @generated
	 */
	private String medBedsTot;

    /**
     *　許可病床数結核
     * @generated
     */
    private String kyokabyoshosuKekkaku;

    /**
     *　許可病床数一般病床
     * @generated
     */
    private String kyokabyoshosuIppan;

    /**
     *　許可病床数感染症
     * @generated
     */
    private String kyokabyoshosuKansen;

    /**
     *　許可病床数精神
     * @generated
     */
    private String kyokabyoshosuSeishin;

    /**
     *　許可病床数療養病床
     * @generated
     */
    private String kyokabyoshosuRyoyo;

	/**
	 * 病床数(医療療養)
	 * @generated
	 */
	private String bedCnt02;

	/**
	 * 病床数(介護療養)
	 * @generated
	 */
	private String bedCnt06;

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
     * コンストラクタ
     * @generated
     */
    public SelectNF011MainDataEntity() {
        super("t_rdm_hco_req" , "selectNF011REQData");
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
	 * SelectNF011MainDataEntity.javainUltInsNoを設定
	 * @return inUltInsNo
	 */
	public String getInUltInsNo() {
		return inUltInsNo;
	}

	/**
	 * @param inUltInsNo セットする inUltInsNo
	 */
	public void setInUltInsNo(String inUltInsNo) {
		this.inUltInsNo = inUltInsNo;
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
	 * SelectNF011MainDataEntity.javareqChlを設定
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
	 * SelectNF011MainDataEntity.javadcfShisetsuCdを設定
	 * @return dcfShisetsuCd
	 */
	public String getDcfShisetsuCd() {
		return dcfShisetsuCd;
	}

	/**
	 * @param dcfShisetsuCd セットする dcfShisetsuCd
	 */
	public void setDcfShisetsuCd(String dcfShisetsuCd) {
		this.dcfShisetsuCd = dcfShisetsuCd;
	}

	/**
	 * SelectNF011MainDataEntity.javashisetsuNmを設定
	 * @return shisetsuNm
	 */
	public String getShisetsuNm() {
		return shisetsuNm;
	}

	/**
	 * @param shisetsuNm セットする shisetsuNm
	 */
	public void setShisetsuNm(String shisetsuNm) {
		this.shisetsuNm = shisetsuNm;
	}

	/**
	 * SelectNF011MainDataEntity.javashisetsuNmKanaを設定
	 * @return shisetsuNmKana
	 */
	public String getShisetsuNmKana() {
		return shisetsuNmKana;
	}

	/**
	 * @param shisetsuNmKana セットする shisetsuNmKana
	 */
	public void setShisetsuNmKana(String shisetsuNmKana) {
		this.shisetsuNmKana = shisetsuNmKana;
	}

	/**
	 * SelectNF011MainDataEntity.javashisetsuNmRyakuを設定
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
	 * SelectNF011MainDataEntity.javainsFormalNameを設定
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
	 * SelectNF011MainDataEntity.javainsContNameを設定
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
	 * SelectNF011MainDataEntity.javainsTypeを設定
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
	 * SelectNF011MainDataEntity.javamainInsCdを設定
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
	 * SelectNF011MainDataEntity.javamainInsNmを設定
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
	 * SelectNF011MainDataEntity.javatradeTypeを設定
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
	 * SelectNF011MainDataEntity.javakaigyoYmを設定
	 * @return kaigyoYm
	 */
	public String getKaigyoYm() {
		return kaigyoYm;
	}

	/**
	 * @param kaigyoYm セットする kaigyoYm
	 */
	public void setKaigyoYm(String kaigyoYm) {
		this.kaigyoYm = kaigyoYm;
	}

	/**
	 * SelectNF011MainDataEntity.javainsOpenYearを設定
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
	 * SelectNF011MainDataEntity.javainsOpenMonthを設定
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
	 * SelectNF011MainDataEntity.javainsOpenDayを設定
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
	 * SelectNF011MainDataEntity.javayubinNoを設定
	 * @return yubinNo
	 */
	public String getYubinNo() {
		return yubinNo;
	}

	/**
	 * @param yubinNo セットする yubinNo
	 */
	public void setYubinNo(String yubinNo) {
		this.yubinNo = yubinNo;
	}

	/**
	 * SelectNF011MainDataEntity.javatodofukenCdを設定
	 * @return todofukenCd
	 */
	public String getTodofukenCd() {
		return todofukenCd;
	}

	/**
	 * @param todofukenCd セットする todofukenCd
	 */
	public void setTodofukenCd(String todofukenCd) {
		this.todofukenCd = todofukenCd;
	}

	/**
	 * SelectNF011MainDataEntity.javatodofukenNmを設定
	 * @return todofukenNm
	 */
	public String getTodofukenNm() {
		return todofukenNm;
	}

	/**
	 * @param todofukenNm セットする todofukenNm
	 */
	public void setTodofukenNm(String todofukenNm) {
		this.todofukenNm = todofukenNm;
	}

	/**
	 * SelectNF011MainDataEntity.javashikuchosonCdを設定
	 * @return shikuchosonCd
	 */
	public String getShikuchosonCd() {
		return shikuchosonCd;
	}

	/**
	 * @param shikuchosonCd セットする shikuchosonCd
	 */
	public void setShikuchosonCd(String shikuchosonCd) {
		this.shikuchosonCd = shikuchosonCd;
	}

	/**
	 * SelectNF011MainDataEntity.javashikuchosonNmを設定
	 * @return shikuchosonNm
	 */
	public String getShikuchosonNm() {
		return shikuchosonNm;
	}

	/**
	 * @param shikuchosonNm セットする shikuchosonNm
	 */
	public void setShikuchosonNm(String shikuchosonNm) {
		this.shikuchosonNm = shikuchosonNm;
	}

	/**
	 * SelectNF011MainDataEntity.javainsAddrDtを設定
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
	 * SelectNF011MainDataEntity.javatkCityCdを設定
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
	 * SelectNF011MainDataEntity.javatkCityNmを設定
	 * @return tkCityNm
	 */
	public String getTkCityNm() {
		return tkCityNm;
	}

	/**
	 * @param tkCityNm セットする tkCityNm
	 */
	public void setTkCityNm(String tkCityNm) {
		this.tkCityNm = tkCityNm;
	}

	/**
	 * SelectNF011MainDataEntity.javaaddressを設定
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * SelectNF011MainDataEntity.javaaddressKanaを設定
	 * @return addressKana
	 */
	public String getAddressKana() {
		return addressKana;
	}

	/**
	 * @param addressKana セットする addressKana
	 */
	public void setAddressKana(String addressKana) {
		this.addressKana = addressKana;
	}

	/**
	 * SelectNF011MainDataEntity.javashisetsuTelを設定
	 * @return shisetsuTel
	 */
	public String getShisetsuTel() {
		return shisetsuTel;
	}

	/**
	 * @param shisetsuTel セットする shisetsuTel
	 */
	public void setShisetsuTel(String shisetsuTel) {
		this.shisetsuTel = shisetsuTel;
	}

	/**
	 * SelectNF011MainDataEntity.javainsPhone1を設定
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
	 * SelectNF011MainDataEntity.javainsPhone2を設定
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
	 * SelectNF011MainDataEntity.javainsFax1を設定
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
	 * SelectNF011MainDataEntity.javainsFax2を設定
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
	 * SelectNF011MainDataEntity.javainsUrlを設定
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
	 * SelectNF011MainDataEntity.javainsUrlYmdを設定
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
	 * SelectNF011MainDataEntity.javapharmTypeを設定
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
	 * SelectNF011MainDataEntity.javainsRankを設定
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
	 * SelectNF011MainDataEntity.javaregVisTypeを設定
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
	 * SelectNF011MainDataEntity.javaimpHosTypeを設定
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
	 * SelectNF011MainDataEntity.javaunivSubdivを設定
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
	 * SelectNF011MainDataEntity.javahoInsTypeを設定
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
	 * SelectNF011MainDataEntity.javamanageCdを設定
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
	 * SelectNF011MainDataEntity.javabedCntBaseを設定
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
	 * SelectNF011MainDataEntity.javakyokabyoshosuSumを設定
	 * @return kyokabyoshosuSum
	 */
	public String getKyokabyoshosuSum() {
		return kyokabyoshosuSum;
	}

	/**
	 * @param kyokabyoshosuSum セットする kyokabyoshosuSum
	 */
	public void setKyokabyoshosuSum(String kyokabyoshosuSum) {
		this.kyokabyoshosuSum = kyokabyoshosuSum;
	}

	/**
	 * SelectNF011MainDataEntity.javamedBedsTotを設定
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
	 * SelectNF011MainDataEntity.javakyokabyoshosuKekkakuを設定
	 * @return kyokabyoshosuKekkaku
	 */
	public String getKyokabyoshosuKekkaku() {
		return kyokabyoshosuKekkaku;
	}

	/**
	 * @param kyokabyoshosuKekkaku セットする kyokabyoshosuKekkaku
	 */
	public void setKyokabyoshosuKekkaku(String kyokabyoshosuKekkaku) {
		this.kyokabyoshosuKekkaku = kyokabyoshosuKekkaku;
	}

	/**
	 * SelectNF011MainDataEntity.javakyokabyoshosuIppanを設定
	 * @return kyokabyoshosuIppan
	 */
	public String getKyokabyoshosuIppan() {
		return kyokabyoshosuIppan;
	}

	/**
	 * @param kyokabyoshosuIppan セットする kyokabyoshosuIppan
	 */
	public void setKyokabyoshosuIppan(String kyokabyoshosuIppan) {
		this.kyokabyoshosuIppan = kyokabyoshosuIppan;
	}

	/**
	 * SelectNF011MainDataEntity.javakyokabyoshosuKansenを設定
	 * @return kyokabyoshosuKansen
	 */
	public String getKyokabyoshosuKansen() {
		return kyokabyoshosuKansen;
	}

	/**
	 * @param kyokabyoshosuKansen セットする kyokabyoshosuKansen
	 */
	public void setKyokabyoshosuKansen(String kyokabyoshosuKansen) {
		this.kyokabyoshosuKansen = kyokabyoshosuKansen;
	}

	/**
	 * SelectNF011MainDataEntity.javakyokabyoshosuSeishinを設定
	 * @return kyokabyoshosuSeishin
	 */
	public String getKyokabyoshosuSeishin() {
		return kyokabyoshosuSeishin;
	}

	/**
	 * @param kyokabyoshosuSeishin セットする kyokabyoshosuSeishin
	 */
	public void setKyokabyoshosuSeishin(String kyokabyoshosuSeishin) {
		this.kyokabyoshosuSeishin = kyokabyoshosuSeishin;
	}

	/**
	 * SelectNF011MainDataEntity.javakyokabyoshosuRyoyoを設定
	 * @return kyokabyoshosuRyoyo
	 */
	public String getKyokabyoshosuRyoyo() {
		return kyokabyoshosuRyoyo;
	}

	/**
	 * @param kyokabyoshosuRyoyo セットする kyokabyoshosuRyoyo
	 */
	public void setKyokabyoshosuRyoyo(String kyokabyoshosuRyoyo) {
		this.kyokabyoshosuRyoyo = kyokabyoshosuRyoyo;
	}

	/**
	 * SelectNF011MainDataEntity.javabedCnt02を設定
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
	 * SelectNF011MainDataEntity.javabedCnt06を設定
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
	 * SelectNF011MainDataEntity.javaentcapaNumを設定
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
	 * SelectNF011MainDataEntity.javavacInsTypeを設定
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
	 * SelectNF011MainDataEntity.javavacVisitTypeを設定
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
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
