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
 * テーブル物理名 : T_RDM_REQ_KNR, M_RDM_HCO_MST, M_RDM_HCO_OYAKO, T_RDM_HCO_LNK_NXT_REQ, T_RDM_HCO_LNK_REQ
 * SQLID : selectNF213InsTkdData,selectNF213InsTrtData,selectNF213ReqTkdData,selectNF213ReqTrtData
 * @generated
 */
public class SelectNF213MainDataEntity extends BaseEntity implements Serializable {

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
     * 入力_施設固定コード (パラメータ2)
     * @generated
     */
    private String inInsNo;

    /**
     * 入力_領域コード (パラメータ3)
     * @generated
     */
    private String inTrtCd;

    /**
     * 入力_品目グループコード (パラメータ4)
     * @generated
     */
    private String inHinGCd;

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
	 * 固定施設コード
	 * @generated
	 */
	private String insNo;

	/**
	 * 施設略式漢字名
	 * @generated
	 */
	private String insAbbrName;

	/**
	 * 施設住所
	 * @generated
	 */
	private String insAddr;

	/**
	 * 領域・品目グループ
	 * @generated
	 */
	private String trtPrdGrp;

	/**
	 * 領域・品目グループ
	 * @generated
	 */
	private String trtPrdGrpNm;

	/**
	 * 領域コード
	 * @generated
	 */
	private String trtCd;

	/**
	 * 品目グループコード
	 * @generated
	 */
	private String hinGCd;

	/**
	 * 適用日
	 * @generated
	 */
	private String tekiyoYmd;

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
	 * 親施設住所
	 * @generated
	 */
	private String mainInsAddr;

	/**
	 * 施設担当者
	 * @generated
	 */
	private String jgiName;

	/**
	 * 親施設種別
	 * @generated
	 */
	private String mainInsSbt;

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
    public SelectNF213MainDataEntity() {
        super("m_rdm_hco_mst", "selectNF213ReqTkdData");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNF213MainDataEntity(String sqlId) {
        super("m_rdm_hco_mst", sqlId);
    }

	/**
	 * SelectNF211MainDataEntity.javainReqIdを設定
	 * @return inReqId
	 */
	public String getInReqId() {
		return inReqId;
	}

	/**
	 * @param inReqId セットする inReqId
	 */
	public void setInReqId(String inReqId) {
		this.inReqId = inReqId;
	}

	/**
	 * SelectNF211MainDataEntity.javainInsNoを設定
	 * @return inInsNo
	 */
	public String getInInsNo() {
		return inInsNo;
	}

	/**
	 * @param inInsNo セットする inInsNo
	 */
	public void setInInsNo(String inInsNo) {
		this.inInsNo = inInsNo;
	}

	/**
	 * SelectNF213MainDataEntity.javainTrtCdを設定
	 * @return inTrtCd
	 */
	public String getInTrtCd() {
		return inTrtCd;
	}

	/**
	 * @param inTrtCd セットする inTrtCd
	 */
	public void setInTrtCd(String inTrtCd) {
		this.inTrtCd = inTrtCd;
	}

	/**
	 * SelectNF213MainDataEntity.javainHinGCdを設定
	 * @return inHinGCd
	 */
	public String getInHinGCd() {
		return inHinGCd;
	}

	/**
	 * @param inHinGCd セットする inHinGCd
	 */
	public void setInHinGCd(String inHinGCd) {
		this.inHinGCd = inHinGCd;
	}

	/**
	 * SelectNF211MainDataEntity.javareqIdを設定
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
	 * SelectNF211MainDataEntity.javareqChlを設定
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
	 * SelectNF211MainDataEntity.javareqShzNmを設定
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
	 * SelectNF211MainDataEntity.javareqStsNmを設定
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
	 * SelectNF211MainDataEntity.javareqJgiNameを設定
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
	 * SelectNF211MainDataEntity.javareqYmdhmsを設定
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
	 * SelectNF211MainDataEntity.javashnShaNameを設定
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
	 * SelectNF211MainDataEntity.javashnYmdhmsを設定
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
	 * SelectNF211MainDataEntity.javaaprShaNameを設定
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
	 * SelectNF211MainDataEntity.javaaprYmdhmsを設定
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
	 * SelectNF211MainDataEntity.javareqJgiNoを設定
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
	 * SelectNF211MainDataEntity.javareqBrCdを設定
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
	 * SelectNF211MainDataEntity.javareqDistCdを設定
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
	 * SelectNF211MainDataEntity.javareqStsCdを設定
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
	 * SelectNF211MainDataEntity.javashnJgiNoを設定
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
	 * SelectNF211MainDataEntity.javaaprJgiNoを設定
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
	 * SelectNF211MainDataEntity.javaupdShaYmdを設定
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
	 * SelectNF211MainDataEntity.javainsNoを設定
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
	 * SelectNF211MainDataEntity.javainsAbbrNameを設定
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
	 * SelectNF211MainDataEntity.javainsAddrを設定
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
	 * SelectNF211MainDataEntity.javatrtPrdGrpを設定
	 * @return trtPrdGrp
	 */
	public String getTrtPrdGrp() {
		return trtPrdGrp;
	}

	/**
	 * @param trtPrdGrp セットする trtPrdGrp
	 */
	public void setTrtPrdGrp(String trtPrdGrp) {
		this.trtPrdGrp = trtPrdGrp;
	}

	/**
	 * SelectNF213MainDataEntity.javatrtPrdGrpNmを設定
	 * @return trtPrdGrpNm
	 */
	public String getTrtPrdGrpNm() {
		return trtPrdGrpNm;
	}

	/**
	 * @param trtPrdGrpNm セットする trtPrdGrpNm
	 */
	public void setTrtPrdGrpNm(String trtPrdGrpNm) {
		this.trtPrdGrpNm = trtPrdGrpNm;
	}

	/**
	 * SelectNF211MainDataEntity.javatrtCdを設定
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
	 * SelectNF211MainDataEntity.javahinGCdを設定
	 * @return hinGCd
	 */
	public String getHinGCd() {
		return hinGCd;
	}

	/**
	 * @param hinGCd セットする hinGCd
	 */
	public void setHinGCd(String hinGCd) {
		this.hinGCd = hinGCd;
	}

	/**
	 * SelectNF211MainDataEntity.javatekiyoYmdを設定
	 * @return tekiyoYmd
	 */
	public String getTekiyoYmd() {
		return tekiyoYmd;
	}

	/**
	 * @param tekiyoYmd セットする tekiyoYmd
	 */
	public void setTekiyoYmd(String tekiyoYmd) {
		this.tekiyoYmd = tekiyoYmd;
	}

	/**
	 * SelectNF211MainDataEntity.javamainInsCdを設定
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
	 * SelectNF211MainDataEntity.javamainInsNmを設定
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
	 * SelectNF211MainDataEntity.javamainInsAddrを設定
	 * @return mainInsAddr
	 */
	public String getMainInsAddr() {
		return mainInsAddr;
	}

	/**
	 * @param mainInsAddr セットする mainInsAddr
	 */
	public void setMainInsAddr(String mainInsAddr) {
		this.mainInsAddr = mainInsAddr;
	}

	/**
	 * SelectNF211MainDataEntity.javajgiNameを設定
	 * @return jgiName
	 */
	public String getJgiName() {
		return jgiName;
	}

	/**
	 * @param jgiName セットする jgiName
	 */
	public void setJgiName(String jgiName) {
		this.jgiName = jgiName;
	}

	/**
	 * SelectNF211MainDataEntity.javamainInsSbtを設定
	 * @return mainInsSbt
	 */
	public String getMainInsSbt() {
		return mainInsSbt;
	}

	/**
	 * @param mainInsSbt セットする mainInsSbt
	 */
	public void setMainInsSbt(String mainInsSbt) {
		this.mainInsSbt = mainInsSbt;
	}

	/**
	 * SelectNF211MainDataEntity.javareqCommentを設定
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
	 * SelectNF211MainDataEntity.javaaprMemoを設定
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
	 * SelectNF211MainDataEntity.javashnFlgを設定
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
