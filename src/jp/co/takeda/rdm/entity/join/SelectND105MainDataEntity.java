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
 * SQLID : selectND105TKDData,selectND105REQData
 * @generated
 */
public class SelectND105MainDataEntity extends BaseEntity implements Serializable {

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
	 * 医師属性
	 * @generated
	 */
	private String docAttribute;

	/**
	 * 医師属性名
	 * @generated
	 */
	private String docAttributeNm;

	/**
	 * 削除理由
	 * @generated
	 */
	private String delReason;

	/**
	 * 重複医師コード
	 * @generated
	 */
	private String dupDocNo;

	/**
	 * 重複医師名
	 * @generated
	 */
	private String dupDocNm;

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
	 * 申請チャネル
	 * @generated
	 */
	private String reqChl;

	/**
	 * ULT医師C
	 * @generated
	 */
	private String ultDocNo;


    /**
     * コンストラクタ
     * @generated
     */
    public SelectND105MainDataEntity() {
        super("t_rdm_hcp_req" , "selectND105REQData");
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
	 * SelectND105MainDataEntity.javareqIdを設定
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
	 * SelectND105MainDataEntity.javareqShzNmを設定
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
	 * SelectND105MainDataEntity.javareqStsNmを設定
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
	 * SelectND105MainDataEntity.javareqJgiNameを設定
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
	 * SelectND105MainDataEntity.javareqYmdhmsを設定
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
	 * SelectND105MainDataEntity.javashnShaNameを設定
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
	 * SelectND105MainDataEntity.javashnYmdhmsを設定
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
	 * SelectND105MainDataEntity.javaaprShaNameを設定
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
	 * SelectND105MainDataEntity.javaaprYmdhmsを設定
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
	 * SelectND105MainDataEntity.javareqJgiNoを設定
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
	 * SelectND105MainDataEntity.javareqBrCdを設定
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
	 * SelectND105MainDataEntity.javareqDistCdを設定
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
	 * SelectND105MainDataEntity.javareqStsCdを設定
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
	 * SelectND105MainDataEntity.javashnJgiNoを設定
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
	 * SelectND105MainDataEntity.javaaprJgiNoを設定
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
	 * SelectND105MainDataEntity.javaupdShaYmdを設定
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
	 * SelectND105MainDataEntity.javatkdDocNoを設定
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
	 * SelectND105MainDataEntity.javatkdDocNmを設定
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
	 * SelectND105MainDataEntity.javatkdDocKanaを設定
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
	 * SelectND105MainDataEntity.javadocKanjiSeiを設定
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
	 * SelectND105MainDataEntity.javadocKanjiMeiを設定
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
	 * SelectND105MainDataEntity.javadocAttributeを設定
	 * @return docAttribute
	 */
	public String getDocAttribute() {
		return docAttribute;
	}

	/**
	 * @param docAttribute セットする docAttribute
	 */
	public void setDocAttribute(String docAttribute) {
		this.docAttribute = docAttribute;
	}

	/**
	 * SelectND105MainDataEntity.javadocAttributeNmを設定
	 * @return docAttributeNm
	 */
	public String getDocAttributeNm() {
		return docAttributeNm;
	}

	/**
	 * @param docAttributeNm セットする docAttributeNm
	 */
	public void setDocAttributeNm(String docAttributeNm) {
		this.docAttributeNm = docAttributeNm;
	}

	/**
	 * SelectND105MainDataEntity.javadelReasonを設定
	 * @return delReason
	 */
	public String getDelReason() {
		return delReason;
	}

	/**
	 * @param delReason セットする delReason
	 */
	public void setDelReason(String delReason) {
		this.delReason = delReason;
	}

	/**
	 * SelectND105MainDataEntity.javadupDocNoを設定
	 * @return dupDocNo
	 */
	public String getDupDocNo() {
		return dupDocNo;
	}

	/**
	 * @param dupDocNo セットする dupDocNo
	 */
	public void setDupDocNo(String dupDocNo) {
		this.dupDocNo = dupDocNo;
	}

	/**
	 * SelectND105MainDataEntity.javadupDocNmを設定
	 * @return dupDocNm
	 */
	public String getDupDocNm() {
		return dupDocNm;
	}

	/**
	 * @param dupDocNm セットする dupDocNm
	 */
	public void setDupDocNm(String dupDocNm) {
		this.dupDocNm = dupDocNm;
	}

	/**
	 * SelectND105MainDataEntity.javareqCommentを設定
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
	 * SelectND105MainDataEntity.javaaprMemoを設定
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
	 * SelectND105MainDataEntity.javaaprCommentを設定
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
	 * SelectND105MainDataEntity.javashnFlgを設定
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
	 * SelectND105MainDataEntity.javareqChlを設定
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

	public String getUltDocNo() {
		return ultDocNo;
	}

	public void setUltDocNo(String ultDocNo) {
		this.ultDocNo = ultDocNo;
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
