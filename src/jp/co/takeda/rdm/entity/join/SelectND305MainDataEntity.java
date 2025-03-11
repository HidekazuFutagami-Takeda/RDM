/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2305, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_M_MDB_HCP_MST,T_RDM_REQ_KNR,T_RDM_HCP_REQ
 * SQLID : selectND305TKDData,selectND013REQData
 * @generated
 */
public class SelectND305MainDataEntity extends BaseEntity implements Serializable {

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
	 * 削除理由
	 * @generated
	 */
	private String delReason;

	/**
	 * 削除理由名
	 * @generated
	 */
	private String delReasonNm;

	/**
	 * 復活理由
	 * @generated
	 */
	private String rstReason;

	/**
	 * 復活理由名
	 * @generated
	 */
	private String rstReasonNm;

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
	 * 大学職位(名称)
	 * @generated
	 */
	private String skUnivPosNm;

	/**
	 * 役職(名称)
	 * @generated
	 */
	private String skTitleNm;

	/**
	 * 勤務形態(名称)
	 * @generated
	 */
	private String skJobFormNm;

	/**
	 * 薬審メンバー区分(名称)
	 * @generated
	 */
	private String skDcctypeNm;

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
    public SelectND305MainDataEntity() {
        super("t_rdm_hcp_req" , "selectND305REQData");
    }

	/**
	 * SelectND305MainDataEntity.javainReqIdを設定
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
	 * SelectND305MainDataEntity.javainDocNoを設定
	 * @return inDocNo
	 */
	public String getInDocNo() {
		return inDocNo;
	}


	/**
	 * @param inDocNo セットする inDocNo
	 */
	public void setInDocNo(String inDocNo) {
		this.inDocNo = inDocNo;
	}


	/**
	 * SelectND305MainDataEntity.javareqIdを設定
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
	 * SelectND305MainDataEntity.javareqShzNmを設定
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
	 * SelectND305MainDataEntity.javareqStsNmを設定
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
	 * SelectND305MainDataEntity.javareqJgiNameを設定
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
	 * SelectND305MainDataEntity.javareqYmdhmsを設定
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
	 * SelectND305MainDataEntity.javashnShaNameを設定
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
	 * SelectND305MainDataEntity.javashnYmdhmsを設定
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
	 * SelectND305MainDataEntity.javaaprShaNameを設定
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
	 * SelectND305MainDataEntity.javaaprYmdhmsを設定
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
	 * SelectND305MainDataEntity.javareqJgiNoを設定
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
	 * SelectND305MainDataEntity.javareqBrCdを設定
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
	 * SelectND305MainDataEntity.javareqDistCdを設定
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
	 * SelectND305MainDataEntity.javareqStsCdを設定
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
	 * SelectND305MainDataEntity.javashnJgiNoを設定
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
	 * SelectND305MainDataEntity.javaaprJgiNoを設定
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
	 * SelectND305MainDataEntity.javaupdShaYmdを設定
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
	 * SelectND305MainDataEntity.javatkdDocNoを設定
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
	 * SelectND305MainDataEntity.javatkdDocNmを設定
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
	 * SelectND305MainDataEntity.javatkdDocKanaを設定
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
	 * SelectND305MainDataEntity.javadocKanjiSeiを設定
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
	 * SelectND305MainDataEntity.javadocKanjiMeiを設定
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
	 * SelectND305MainDataEntity.javadelReasonを設定
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
	 * SelectND305MainDataEntity.javadelReasonNmを設定
	 * @return delReasonNm
	 */
	public String getDelReasonNm() {
		return delReasonNm;
	}


	/**
	 * @param delReasonNm セットする delReasonNm
	 */
	public void setDelReasonNm(String delReasonNm) {
		this.delReasonNm = delReasonNm;
	}


	/**
	 * SelectND305MainDataEntity.javarstReasonを設定
	 * @return rstReason
	 */
	public String getRstReason() {
		return rstReason;
	}


	/**
	 * @param rstReason セットする rstReason
	 */
	public void setRstReason(String rstReason) {
		this.rstReason = rstReason;
	}


	/**
	 * SelectND305MainDataEntity.javarstReasonNmを設定
	 * @return rstReasonNm
	 */
	public String getRstReasonNm() {
		return rstReasonNm;
	}


	/**
	 * @param rstReasonNm セットする rstReasonNm
	 */
	public void setRstReasonNm(String rstReasonNm) {
		this.rstReasonNm = rstReasonNm;
	}


	/**
	 * SelectND305MainDataEntity.javaskInsNmを設定
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
	 * SelectND305MainDataEntity.javaskUnivPosCdを設定
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
	 * SelectND305MainDataEntity.javaskDeptNmを設定
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
	 * SelectND305MainDataEntity.javaskTitleCdを設定
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
	 * SelectND305MainDataEntity.javaskJobFormを設定
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
	 * SelectND305MainDataEntity.javaskDcctypeを設定
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
	 * SelectND305MainDataEntity.javaskInsNoを設定
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
	 * SelectND305MainDataEntity.javaskDeptCdを設定
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
	 * SelectND305MainDataEntity.javareqCommentを設定
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
	 * SelectND305MainDataEntity.javaaprMemoを設定
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
	 * SelectND305MainDataEntity.javaaprCommentを設定
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
	 * SelectND305MainDataEntity.javashnFlgを設定
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
	 * SelectND305MainDataEntity.javafbReqFlgを設定
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
	 * SelectND305MainDataEntity.javareqChlを設定
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
	 * SelectND305MainDataEntity.javaskUnivPosNmを設定
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
	 * SelectND305MainDataEntity.javaskTitleNmを設定
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
	 * SelectND305MainDataEntity.javaskJobFormNmを設定
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
	 * SelectND305MainDataEntity.javaskDcctypeNmを設定
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
	 * SelectND305MainDataEntity.javaskInsHoInsTypeを設定
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
	 * SelectND305MainDataEntity.javaskInsInsClassを設定
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
