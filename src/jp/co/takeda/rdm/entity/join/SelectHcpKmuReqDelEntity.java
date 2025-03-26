/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_HCP_KMU_REQ KMU_REQ
 * SQLID : selectCtrlFlg
 * @generated
 */
public class SelectHcpKmuReqDelEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 親画面 医師固定コード
     * @generated
     */
    private String paramDocNo;

    /**
     * 親画面 施設固定コード
     * @generated
     */
    private String paramInsNo;

    /**
     * 親画面申請ID
     * @generated
     */
    private String paramReqId;

    /**
     * 申請者所属
     * @generated
     */
    private String reqShz;

    /**
     * エラーチェックフラグ
     * 0:エラー処理実行前
     * 1:エラーなし
     * @generated
     */
    private String errorCheckFlg = "0";

    /**
     * 医師メニュースイッチ
     * @generated
     */
    private String ishiMenu;

    /**
     * 医師勤務元メニュースイッチ
     * @generated
     */
    private String ishiKinmu;

    /**
     * 申請チャネル
     * @generated
     */
    private String reqChl;


    /**
     * 申請ステータス(名称)
     * @generated
     */
    private String reqSts;

    /**
     * 申請者氏名
     * @generated
     */
    private String jgiName;

    /**
     * 申請日時
     * @generated
     */
    private String reqYmdhms;

    /**
     * 申請者従業員番号
     * @generated
     */
    private String reqJgiNo;

    /**
     * 申請者所属リージョン
     * @generated
     */
    private String brCode;

    /**
     * 申請者所属エリア
     * @generated
     */
    private String reqDistCode;

    /**
     * 申請ステータス(コード)
     * @generated
     */
    private String reqStsCd;

    /**
     * 更新日
     * @generated
     */
    private String updShaYmd;

    /**
     * 氏名（漢字）
     * @generated
     */
    private String docKanj;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;

    /**
     * ULT医師コード
     * @generated
     */
    private String urlDocNo;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 所属部科漢字名
     * @generated
     */
    private String deptKj;

    /**
     * 役職コード(異動元)
     * @generated
     */
    private String titleCodeBf;

    /**
     * 役職名称(異動元)名称
     * @generated
     */
    private String titleCodeName;

    /**
     * 勤務形態(異動元)
     * @generated
     */
    private String jobFormBf;

    /**
     * 勤務形態(異動元)名称
     * @generated
     */
    private String jobFormBfName;

    /**
     * 薬審メンバー区分(異動元)
     * @generated
     */
    private String dccTypeBf;

    /**
     * 薬審メンバー区分(異動元)名称
     * @generated
     */
    private String dccTypeBfName;

    /**
     * 大学職位コード(異動元)
     * @generated
     */
    private String univPosCodeBf;

    /**
     * 大学職位コード(異動元)名称
     * @generated
     */
    private String univPosCodeBfName;

    /**
     * 適用開始日
     * @generated
     */
    private String tekiyoYmd;

    /**
     * 施設固定コード(異動元)
     * @generated
     */
    private String insNoMt;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * ULT施設コード
     * @generated
     */
    private String ultInsNo;

    /**
     * 所属部科コード(異動元)
     * @generated
     */
    private String deptCodeBf;

    /**
     * 所属部科カナ名
     * @generated
     */
    private String deptKn;

    /**
     * 申請コメント
     * @generated
     */
    private String reqComment;

    /**
     * 承認者メモ
     * @generated
     */
    private String aprMemo;

    /**
     * 承認却下コメント
     * @generated
     */
    private String aprComment;

    /**
     * 作成日
     * @generated
     */
    private String insShaYmd;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;

    /**
     * 施設分類
     * @generated
     */
    private String insClass;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectHcpKmuReqDelEntity() {
        super("hcp_kmu_req_del" , "selectHcpKmuReqDel");
    }

	/**
	 * SelectHcpKmuReqDelEntity.javaparamDocNoを設定
	 * @return paramDocNo
	 */
	public String getParamDocNo() {
		return paramDocNo;
	}

	/**
	 * @param paramDocNo セットする paramDocNo
	 */
	public void setParamDocNo(String paramDocNo) {
		this.paramDocNo = paramDocNo;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaparamInsNoを設定
	 * @return paramInsNo
	 */
	public String getParamInsNo() {
		return paramInsNo;
	}

	/**
	 * @param paramInsNo セットする paramInsNo
	 */
	public void setParamInsNo(String paramInsNo) {
		this.paramInsNo = paramInsNo;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaparamReqIdを設定
	 * @return paramReqId
	 */
	public String getParamReqId() {
		return paramReqId;
	}

	/**
	 * @param paramReqId セットする paramReqId
	 */
	public void setParamReqId(String paramReqId) {
		this.paramReqId = paramReqId;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javareqShzを設定
	 * @return reqShz
	 */
	public String getReqShz() {
		return reqShz;
	}

	/**
	 * @param reqShz セットする reqShz
	 */
	public void setReqShz(String reqShz) {
		this.reqShz = reqShz;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaerrorCheckFlgを設定
	 * @return errorCheckFlg
	 */
	public String getErrorCheckFlg() {
		return errorCheckFlg;
	}

	/**
	 * @param errorCheckFlg セットする errorCheckFlg
	 */
	public void setErrorCheckFlg(String errorCheckFlg) {
		this.errorCheckFlg = errorCheckFlg;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaishiMenuを設定
	 * @return ishiMenu
	 */
	public String getIshiMenu() {
		return ishiMenu;
	}

	/**
	 * @param ishiMenu セットする ishiMenu
	 */
	public void setIshiMenu(String ishiMenu) {
		this.ishiMenu = ishiMenu;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaishiKinmuを設定
	 * @return ishiKinmu
	 */
	public String getIshiKinmu() {
		return ishiKinmu;
	}

	/**
	 * @param ishiKinmu セットする ishiKinmu
	 */
	public void setIshiKinmu(String ishiKinmu) {
		this.ishiKinmu = ishiKinmu;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javareqChlを設定
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
	 * SelectHcpKmuReqDelEntity.javareqStsを設定
	 * @return reqSts
	 */
	public String getReqSts() {
		return reqSts;
	}

	/**
	 * @param reqSts セットする reqSts
	 */
	public void setReqSts(String reqSts) {
		this.reqSts = reqSts;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javajgiNameを設定
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
	 * SelectHcpKmuReqDelEntity.javareqYmdhmsを設定
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
	 * SelectHcpKmuReqDelEntity.javareqJgiNoを設定
	 * @return reqJgiNo
	 */
	public String getReqJgiNo() {
		return reqJgiNo;
	}

	/**
	 * @param reqJgiNo セットする reqJgiNo
	 */
	public void setReqJgiNo(String reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javabrCodeを設定
	 * @return brCode
	 */
	public String getBrCode() {
		return brCode;
	}

	/**
	 * @param brCode セットする brCode
	 */
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javareqDistCodeを設定
	 * @return reqDistCode
	 */
	public String getReqDistCode() {
		return reqDistCode;
	}

	/**
	 * @param reqDistCode セットする reqDistCode
	 */
	public void setReqDistCode(String reqDistCode) {
		this.reqDistCode = reqDistCode;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javareqStsCdを設定
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
	 * SelectHcpKmuReqDelEntity.javaupdShaYmdを設定
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
	 * SelectHcpKmuReqDelEntity.javadocKanjを設定
	 * @return docKanj
	 */
	public String getDocKanj() {
		return docKanj;
	}

	/**
	 * @param docKanj セットする docKanj
	 */
	public void setDocKanj(String docKanj) {
		this.docKanj = docKanj;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javadocNoを設定
	 * @return docNo
	 */
	public String getDocNo() {
		return docNo;
	}

	/**
	 * @param docNo セットする docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaurlDocNoを設定
	 * @return urlDocNo
	 */
	public String getUrlDocNo() {
		return urlDocNo;
	}

	/**
	 * @param urlDocNo セットする urlDocNo
	 */
	public void setUrlDocNo(String urlDocNo) {
		this.urlDocNo = urlDocNo;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javainsAbbrNameを設定
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
	 * SelectHcpKmuReqDelEntity.javadeptKjを設定
	 * @return deptKj
	 */
	public String getDeptKj() {
		return deptKj;
	}

	/**
	 * @param deptKj セットする deptKj
	 */
	public void setDeptKj(String deptKj) {
		this.deptKj = deptKj;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javatitleCodeBfを設定
	 * @return titleCodeBf
	 */
	public String getTitleCodeBf() {
		return titleCodeBf;
	}

	/**
	 * @param titleCodeBf セットする titleCodeBf
	 */
	public void setTitleCodeBf(String titleCodeBf) {
		this.titleCodeBf = titleCodeBf;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javajobFormBfを設定
	 * @return jobFormBf
	 */
	public String getJobFormBf() {
		return jobFormBf;
	}

	/**
	 * @param jobFormBf セットする jobFormBf
	 */
	public void setJobFormBf(String jobFormBf) {
		this.jobFormBf = jobFormBf;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javadccTypeBfを設定
	 * @return dccTypeBf
	 */
	public String getDccTypeBf() {
		return dccTypeBf;
	}

	/**
	 * @param dccTypeBf セットする dccTypeBf
	 */
	public void setDccTypeBf(String dccTypeBf) {
		this.dccTypeBf = dccTypeBf;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaunivPosCodeBfを設定
	 * @return univPosCodeBf
	 */
	public String getUnivPosCodeBf() {
		return univPosCodeBf;
	}

	/**
	 * @param univPosCodeBf セットする univPosCodeBf
	 */
	public void setUnivPosCodeBf(String univPosCodeBf) {
		this.univPosCodeBf = univPosCodeBf;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javatekiyoYmdを設定
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
	 * SelectHcpKmuReqDelEntity.javainsNoMtを設定
	 * @return insNoMt
	 */
	public String getInsNoMt() {
		return insNoMt;
	}

	/**
	 * @param insNoMt セットする insNoMt
	 */
	public void setInsNoMt(String insNoMt) {
		this.insNoMt = insNoMt;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaultInsNoを設定
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
	 * SelectHcpKmuReqDelEntity.javadeptCodeBfを設定
	 * @return deptCodeBf
	 */
	public String getDeptCodeBf() {
		return deptCodeBf;
	}

	/**
	 * @param deptCodeBf セットする deptCodeBf
	 */
	public void setDeptCodeBf(String deptCodeBf) {
		this.deptCodeBf = deptCodeBf;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javadeptKnを設定
	 * @return deptKn
	 */
	public String getDeptKn() {
		return deptKn;
	}

	/**
	 * @param deptKn セットする deptKn
	 */
	public void setDeptKn(String deptKn) {
		this.deptKn = deptKn;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javareqCommentを設定
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
	 * SelectHcpKmuReqDelEntity.javaaprMemoを設定
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
	 * SelectHcpKmuReqDelEntity.javaaprCommentを設定
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
	 * SelectHcpKmuReqDelEntity.javainsShaYmdを設定
	 * @return insShaYmd
	 */
	public String getInsShaYmd() {
		return insShaYmd;
	}

	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(String insShaYmd) {
		this.insShaYmd = insShaYmd;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javainsShaIdを設定
	 * @return insShaId
	 */
	public String getInsShaId() {
		return insShaId;
	}

	/**
	 * @param insShaId セットする insShaId
	 */
	public void setInsShaId(String insShaId) {
		this.insShaId = insShaId;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaupdShaIdを設定
	 * @return updShaId
	 */
	public String getUpdShaId() {
		return updShaId;
	}

	/**
	 * @param updShaId セットする updShaId
	 */
	public void setUpdShaId(String updShaId) {
		this.updShaId = updShaId;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javainsClassを設定
	 * @return insClass
	 */
	public String getInsClass() {
		return insClass;
	}

	/**
	 * @param insClass セットする insClass
	 */
	public void setInsClass(String insClass) {
		this.insClass = insClass;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javahoInsTypeを設定
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
	 * SelectHcpKmuReqDelEntity.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javaunivPosCodeBfNameを設定
	 * @return univPosCodeBfName
	 */
	public String getUnivPosCodeBfName() {
		return univPosCodeBfName;
	}

	/**
	 * @param univPosCodeBfName セットする univPosCodeBfName
	 */
	public void setUnivPosCodeBfName(String univPosCodeBfName) {
		this.univPosCodeBfName = univPosCodeBfName;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javatitleCodeNameを設定
	 * @return titleCodeName
	 */
	public String getTitleCodeName() {
		return titleCodeName;
	}

	/**
	 * @param titleCodeName セットする titleCodeName
	 */
	public void setTitleCodeName(String titleCodeName) {
		this.titleCodeName = titleCodeName;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javajobFormBfNameを設定
	 * @return jobFormBfName
	 */
	public String getJobFormBfName() {
		return jobFormBfName;
	}

	/**
	 * @param jobFormBfName セットする jobFormBfName
	 */
	public void setJobFormBfName(String jobFormBfName) {
		this.jobFormBfName = jobFormBfName;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javadccTypeBfNameを設定
	 * @return dccTypeBfName
	 */
	public String getDccTypeBfName() {
		return dccTypeBfName;
	}

	/**
	 * @param dccTypeBfName セットする dccTypeBfName
	 */
	public void setDccTypeBfName(String dccTypeBfName) {
		this.dccTypeBfName = dccTypeBfName;
	}

	/**
	 * SelectHcpKmuReqDelEntity.javainsNoを設定
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


}
