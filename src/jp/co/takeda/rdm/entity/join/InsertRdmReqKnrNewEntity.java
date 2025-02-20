/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;


/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_REQ_KNR REQ_KNR
 * SQLID : selectCtrlFlg
 * @generated
 */
public class InsertRdmReqKnrNewEntity extends BaseEntity implements Serializable {

	 /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

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
     * 申請区分
     * @generated
     */
    private String reqType;

    /**
     * 申請ステータス
     * @generated
     */
    private String reqSts;

    /**
     * 適用開始日
     * @generated
     */
    private String tekiyoYmd;

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
     * 申請者所属
     * @generated
     */
    private String reqShz;

    /**
     * 申請者従業員番号
     * @generated
     */
    private Integer reqJgiNo;

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
     * 申請者メモ
     * @generated
     */
    private String reqMemo;

    /**
     * 申請コメント
     * @generated
     */
    private String reqComment;

    /**
     * 申請者権限区分
     * @generated
     */
    private String reqKngKbn;

    /**
     * 審査済みフラグ
     * @generated
     */
    private String shnFlg;

    /**
     * 審査者所属リージョン
     * @generated
     */
    private String shnBrCode;

    /**
     * 審査者所属エリア
     * @generated
     */
    private String shnDistCode;

    /**
     * 審査者所属
     * @generated
     */
    private String shnShz;

    /**
     * 審査者従業員番号
     * @generated
     */
    private Integer shnJgiNo;

    /**
     * 審査者氏名
     * @generated
     */
    private String shnShaId;

    /**
     * 審査日時
     * @generated
     */
    private String shnYmdHms;

    /**
     * 承認者所属リージョン
     * @generated
     */
    private String aprBrCode;

    /**
     * 承認者所属エリア
     * @generated
     */
    private String aprDistCode;

    /**
     * 承認者所属
     * @generated
     */
    private String aprShz;

    /**
     * 承認者従業員番号
     * @generated
     */
    private Integer aprJgiNo;

    /**
     * 承認者氏名
     * @generated
     */
    private String aprShaId;

    /**
     * 承認日時
     * @generated
     */
    private String aprYmdhms;

    /**
     * 承認者保留フラグ
     * @generated
     */
    private String aprHryFlg;

    /**
     * 承認者メモ
     * @generated
     */
    private String aprMemo;

    /**
     * 却下コメント
     * @generated
     */
    private String aprComment;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;

    /**
     * マスタ更新日
     * @generated
     */
    private String updMstYmd;

    /**
     * FB申請要否フラグ
     * @generated
     */
    private String fbReqFlg;

    /**
     * FB申請ID
     * @generated
     */
    private String fbReqId;

    /**
     * FB回答ID
     * @generated
     */
    private String fbAnsId;

    /**
     * FBデータ区分
     * @generated
     */
    private String fbDataType;

    /**
     * FBレコードID
     * @generated
     */
    private String fbRecId;

    /**
     * FB更新区分
     * @generated
     */
    private String fbUpdKbn;

    /**
     * FB処理区分
     * @generated
     */
    private String fbPrcType;

    /**
     * 作成日
     * @generated
     */
    private Date insShaYmd;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;


    /**
     * コンストラクタ
     * @generated
     */
    public InsertRdmReqKnrNewEntity() {
        super("hcp_kmu_req_new" , "insertRdmReqKnr");
    }


    /**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }




	/**
	 * SelectHcpKmuReqNewEntity.javareqStsを設定
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
	 * SelectHcpKmuReqNewEntity.javareqYmdhmsを設定
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
	 * SelectHcpKmuReqNewEntity.javabrCodeを設定
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
	 * SelectHcpKmuReqNewEntity.javareqDistCodeを設定
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
	 * InsertRdmReqKnrNewEntity.javareqIdを設定
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
	 * InsertRdmReqKnrNewEntity.javareqChlを設定
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
	 * InsertRdmReqKnrNewEntity.javareqTypeを設定
	 * @return reqType
	 */
	public String getReqType() {
		return reqType;
	}


	/**
	 * @param reqType セットする reqType
	 */
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javatekiyoYmdを設定
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
	 * InsertRdmReqKnrNewEntity.javareqJgiNameを設定
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
	 * InsertRdmReqKnrNewEntity.javareqMemoを設定
	 * @return reqMemo
	 */
	public String getReqMemo() {
		return reqMemo;
	}


	/**
	 * @param reqMemo セットする reqMemo
	 */
	public void setReqMemo(String reqMemo) {
		this.reqMemo = reqMemo;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javareqCommentを設定
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
	 * InsertRdmReqKnrNewEntity.javareqKngKbnを設定
	 * @return reqKngKbn
	 */
	public String getReqKngKbn() {
		return reqKngKbn;
	}


	/**
	 * @param reqKngKbn セットする reqKngKbn
	 */
	public void setReqKngKbn(String reqKngKbn) {
		this.reqKngKbn = reqKngKbn;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javashnFlgを設定
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
	 * InsertRdmReqKnrNewEntity.javashnBrCodeを設定
	 * @return shnBrCode
	 */
	public String getShnBrCode() {
		return shnBrCode;
	}


	/**
	 * @param shnBrCode セットする shnBrCode
	 */
	public void setShnBrCode(String shnBrCode) {
		this.shnBrCode = shnBrCode;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javashnDistCodeを設定
	 * @return shnDistCode
	 */
	public String getShnDistCode() {
		return shnDistCode;
	}


	/**
	 * @param shnDistCode セットする shnDistCode
	 */
	public void setShnDistCode(String shnDistCode) {
		this.shnDistCode = shnDistCode;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javashnShzを設定
	 * @return shnShz
	 */
	public String getShnShz() {
		return shnShz;
	}


	/**
	 * @param shnShz セットする shnShz
	 */
	public void setShnShz(String shnShz) {
		this.shnShz = shnShz;
	}

	/**
	 * InsertRdmReqKnrNewEntity.javashnShaIdを設定
	 * @return shnShaId
	 */
	public String getShnShaId() {
		return shnShaId;
	}


	/**
	 * @param shnShaId セットする shnShaId
	 */
	public void setShnShaId(String shnShaId) {
		this.shnShaId = shnShaId;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javashnYmdHmsを設定
	 * @return shnYmdHms
	 */
	public String getShnYmdHms() {
		return shnYmdHms;
	}


	/**
	 * @param shnYmdHms セットする shnYmdHms
	 */
	public void setShnYmdHms(String shnYmdHms) {
		this.shnYmdHms = shnYmdHms;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javaaprBrCodeを設定
	 * @return aprBrCode
	 */
	public String getAprBrCode() {
		return aprBrCode;
	}


	/**
	 * @param aprBrCode セットする aprBrCode
	 */
	public void setAprBrCode(String aprBrCode) {
		this.aprBrCode = aprBrCode;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javaaprDistCodeを設定
	 * @return aprDistCode
	 */
	public String getAprDistCode() {
		return aprDistCode;
	}


	/**
	 * @param aprDistCode セットする aprDistCode
	 */
	public void setAprDistCode(String aprDistCode) {
		this.aprDistCode = aprDistCode;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javaaprShzを設定
	 * @return aprShz
	 */
	public String getAprShz() {
		return aprShz;
	}


	/**
	 * @param aprShz セットする aprShz
	 */
	public void setAprShz(String aprShz) {
		this.aprShz = aprShz;
	}

	/**
	 * InsertRdmReqKnrNewEntity.javaaprShaIdを設定
	 * @return aprShaId
	 */
	public String getAprShaId() {
		return aprShaId;
	}


	/**
	 * @param aprShaId セットする aprShaId
	 */
	public void setAprShaId(String aprShaId) {
		this.aprShaId = aprShaId;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javaaprYmdhmsを設定
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
	 * InsertRdmReqKnrNewEntity.javaaprHryFlgを設定
	 * @return aprHryFlg
	 */
	public String getAprHryFlg() {
		return aprHryFlg;
	}


	/**
	 * @param aprHryFlg セットする aprHryFlg
	 */
	public void setAprHryFlg(String aprHryFlg) {
		this.aprHryFlg = aprHryFlg;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javaaprMemoを設定
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
	 * InsertRdmReqKnrNewEntity.javaaprCommentを設定
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
	 * InsertRdmReqKnrNewEntity.javainsNoを設定
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
	 * InsertRdmReqKnrNewEntity.javadocNoを設定
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
	 * InsertRdmReqKnrNewEntity.javaupdMstYmdを設定
	 * @return updMstYmd
	 */
	public String getUpdMstYmd() {
		return updMstYmd;
	}


	/**
	 * @param updMstYmd セットする updMstYmd
	 */
	public void setUpdMstYmd(String updMstYmd) {
		this.updMstYmd = updMstYmd;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javafbReqFlgを設定
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
	 * InsertRdmReqKnrNewEntity.javafbReqIdを設定
	 * @return fbReqId
	 */
	public String getFbReqId() {
		return fbReqId;
	}


	/**
	 * @param fbReqId セットする fbReqId
	 */
	public void setFbReqId(String fbReqId) {
		this.fbReqId = fbReqId;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javafbAnsIdを設定
	 * @return fbAnsId
	 */
	public String getFbAnsId() {
		return fbAnsId;
	}


	/**
	 * @param fbAnsId セットする fbAnsId
	 */
	public void setFbAnsId(String fbAnsId) {
		this.fbAnsId = fbAnsId;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javafbDataTypeを設定
	 * @return fbDataType
	 */
	public String getFbDataType() {
		return fbDataType;
	}


	/**
	 * @param fbDataType セットする fbDataType
	 */
	public void setFbDataType(String fbDataType) {
		this.fbDataType = fbDataType;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javafbRecIdを設定
	 * @return fbRecId
	 */
	public String getFbRecId() {
		return fbRecId;
	}


	/**
	 * @param fbRecId セットする fbRecId
	 */
	public void setFbRecId(String fbRecId) {
		this.fbRecId = fbRecId;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javafbUpdKbnを設定
	 * @return fbUpdKbn
	 */
	public String getFbUpdKbn() {
		return fbUpdKbn;
	}


	/**
	 * @param fbUpdKbn セットする fbUpdKbn
	 */
	public void setFbUpdKbn(String fbUpdKbn) {
		this.fbUpdKbn = fbUpdKbn;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javafbPrcTypeを設定
	 * @return fbPrcType
	 */
	public String getFbPrcType() {
		return fbPrcType;
	}


	/**
	 * @param fbPrcType セットする fbPrcType
	 */
	public void setFbPrcType(String fbPrcType) {
		this.fbPrcType = fbPrcType;
	}

	/**
	 * InsertRdmReqKnrNewEntity.javainsShaIdを設定
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
	 * InsertRdmReqKnrNewEntity.javaupdShaIdを設定
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
	 * InsertRdmReqKnrNewEntity.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}







	/**
	 * @param shnJgiNo セットする shnJgiNo
	 */
	public void setShnJgiNo(Integer shnJgiNo) {
		this.shnJgiNo = shnJgiNo;
	}



	/**
	 * @param aprJgiNo セットする aprJgiNo
	 */
	public void setAprJgiNo(Integer aprJgiNo) {
		this.aprJgiNo = aprJgiNo;
	}


	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(Date insShaYmd) {
		this.insShaYmd = insShaYmd;
	}


	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(Date updShaYmd) {
		this.updShaYmd = updShaYmd;
	}

	/**
	 * @param reqJgiNo セットする reqJgiNo
	 */
	public void setReqJgiNo(Integer reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}


	/**
	 * @param reqShz セットする reqShz
	 */
	public void setReqShz(String reqShz) {
		this.reqShz = reqShz;
	}


	/**
	 * InsertRdmReqKnrNewEntity.javareqShzを設定
	 * @return reqShz
	 */
	public String getReqShz() {
		return reqShz;
	}

}
