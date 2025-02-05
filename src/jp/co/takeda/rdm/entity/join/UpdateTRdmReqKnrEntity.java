/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * 結合Entityクラス
 * テーブル物理名 : T_RDM_REQ_KNR
 * SQLID : updateShn,updateND11
 * @generated
 */
public class UpdateTRdmReqKnrEntity extends BaseEntity implements Serializable {

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
    private boolean reqIdNullFlag;

    /**
     * 申請チャネル
     * @generated
     */
    private String reqChl;
    private boolean reqChlNullFlag;

    /**
     * 申請区分
     * @generated
     */
    private String reqType;
    private boolean reqTypeNullFlag;

    /**
     * 申請ステータス
     * @generated
     */
    private String reqStsCd;
    private boolean reqStsCdNullFlag;

    /**
     * 適用開始日
     * @generated
     */
    private String tekiyoYmd;
    private boolean tekiyoYmdNullFlag;

    /**
     * 申請者所属リージョン
     * @generated
     */
    private String reqBrCd;
    private boolean reqBrCdNullFlag;

    /**
     * 申請者所属エリア
     * @generated
     */
    private String reqDistCd;
    private boolean reqDistCdNullFlag;

    /**
     * 申請者所属
     * @generated
     */
    private String reqShzNm;
    private boolean reqShzNmNullFlag;

    /**
     * 申請者従業員番号
     * @generated
     */
    private Integer reqJgiNo;
    private boolean reqJgiNoNullFlag;

    /**
     * 申請者氏名
     * @generated
     */
    private String reqJgiName;
    private boolean reqJgiNameNullFlag;

    /**
     * 申請日時
     * @generated
     */
    private String reqYmdhms;
    private boolean reqYmdhmsNullFlag;

    /**
     * 申請者メモ
     * @generated
     */
    private String reqMemo;
    private boolean reqMemoNullFlag;

    /**
     * 申請コメント
     * @generated
     */
    private String reqComment;
    private boolean reqCommentNullFlag;

    /**
     * 申請者権限区分
     * @generated
     */
    private String reqKngKbn;
    private boolean reqKngKbnNullFlag;

    /**
     * 審査済みフラグ
     * @generated
     */
    private String shnFlg;
    private boolean shnFlgNullFlag;

    /**
     * 審査者所属リージョン
     * @generated
     */
    private String shnBrCode;
    private boolean shnBrCodeNullFlag;

    /**
     * 審査者所属エリア
     * @generated
     */
    private String shnDistCode;
    private boolean shnDistCodeNullFlag;

    /**
     * 審査者所属
     * @generated
     */
    private String shnShz;
    private boolean shnShzNullFlag;

    /**
     * 審査者従業員番号
     * @generated
     */
    private Integer shnJgiNo;
    private boolean shnJgiNoNullFlag;

    /**
     * 審査者氏名
     * @generated
     */
    private String shnShaName;
    private boolean shnShaNameNullFlag;

    /**
     * 審査日時
     * @generated
     */
    private String shnYmdhms;
    private boolean shnYmdhmsNullFlag;

    /**
     * 承認者所属リージョン
     * @generated
     */
    private String aprBrCode;
    private boolean aprBrCodeNullFlag;

    /**
     * 承認者所属エリア
     * @generated
     */
    private String aprDistCode;
    private boolean aprDistCodeNullFlag;

    /**
     * 承認者所属
     * @generated
     */
    private String aprShz;
    private boolean aprShzNullFlag;

    /**
     * 承認者従業員番号
     * @generated
     */
    private Integer aprJgiNo;
    private boolean aprJgiNoNullFlag;

    /**
     * 承認者氏名
     * @generated
     */
    private String aprShaName;
    private boolean aprShaNameNullFlag;

    /**
     * 承認日時
     * @generated
     */
    private String aprYmdhms;
    private boolean aprYmdhmsNullFlag;

    /**
     * 承認者保留フラグ
     * @generated
     */
    private String aprHryFlg;
    private boolean aprHryFlgNullFlag;

    /**
     * 承認者メモ
     * @generated
     */
    private String aprMemo;
    private boolean aprMemoNullFlag;

    /**
     * 却下コメント
     * @generated
     */
    private String aprComment;
    private boolean aprCommentNullFlag;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;
    private boolean insNoNullFlag;

    /**
     * 医師固定コード
     * @generated
     */
    private String docNo;
    private boolean docNoNullFlag;

    /**
     * マスタ更新日
     * @generated
     */
    private String updMstYmd;
    private boolean updMstYmdNullFlag;

    /**
     * FB申請要否フラグ
     * @generated
     */
    private String fbReqFlg;
    private boolean fbReqFlgNullFlag;

    /**
     * FB申請ID
     * @generated
     */
    private String fbReqId;
    private boolean fbReqIdNullFlag;

    /**
     * FB回答ID
     * @generated
     */
    private String fbAnsId;
    private boolean fbAnsIdNullFlag;

    /**
     * FBデータ区分
     * @generated
     */
    private String fbDataType;
    private boolean fbDataTypeNullFlag;

    /**
     * FBレコードID
     * @generated
     */
    private String fbRecId;
    private boolean fbRecIdNullFlag;

    /**
     * FB更新区分
     * @generated
     */
    private String fbUpdKbn;
    private boolean fbUpdKbnNullFlag;

    /**
     * FB処理区分
     * @generated
     */
    private String fbPrcType;
    private boolean fbPrcTypeNullFlag;

    /**
     * 作成日
     * @generated
     */
    private Date insShaYmd;
    private boolean insShaYmdNullFlag;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;
    private boolean insShaIdNullFlag;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;
    private boolean updShaYmdNullFlag;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;
    private boolean updShaIdNullFlag;



    /**
     * コンストラクタ
     * @generated
     */
    public UpdateTRdmReqKnrEntity() {
        super("t_rdm_req_knr" , "updateShn");
    }


    /**
	 * UpdateTRdmReqKnrEntity.javareqIdを設定
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
	 * UpdateTRdmReqKnrEntity.javareqIdNullFlagを設定
	 * @return reqIdNullFlag
	 */
	public boolean isReqIdNullFlag() {
		return reqIdNullFlag;
	}


	/**
	 * @param reqIdNullFlag セットする reqIdNullFlag
	 */
	public void setReqIdNullFlag(boolean reqIdNullFlag) {
		this.reqIdNullFlag = reqIdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqChlを設定
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
	 * UpdateTRdmReqKnrEntity.javareqChlNullFlagを設定
	 * @return reqChlNullFlag
	 */
	public boolean isReqChlNullFlag() {
		return reqChlNullFlag;
	}


	/**
	 * @param reqChlNullFlag セットする reqChlNullFlag
	 */
	public void setReqChlNullFlag(boolean reqChlNullFlag) {
		this.reqChlNullFlag = reqChlNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqTypeを設定
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
	 * UpdateTRdmReqKnrEntity.javareqTypeNullFlagを設定
	 * @return reqTypeNullFlag
	 */
	public boolean isReqTypeNullFlag() {
		return reqTypeNullFlag;
	}


	/**
	 * @param reqTypeNullFlag セットする reqTypeNullFlag
	 */
	public void setReqTypeNullFlag(boolean reqTypeNullFlag) {
		this.reqTypeNullFlag = reqTypeNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqStsCdを設定
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
	 * UpdateTRdmReqKnrEntity.javareqStsCdNullFlagを設定
	 * @return reqStsCdNullFlag
	 */
	public boolean isReqStsCdNullFlag() {
		return reqStsCdNullFlag;
	}


	/**
	 * @param reqStsCdNullFlag セットする reqStsCdNullFlag
	 */
	public void setReqStsCdNullFlag(boolean reqStsCdNullFlag) {
		this.reqStsCdNullFlag = reqStsCdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javatekiyoYmdを設定
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
	 * UpdateTRdmReqKnrEntity.javatekiyoYmdNullFlagを設定
	 * @return tekiyoYmdNullFlag
	 */
	public boolean isTekiyoYmdNullFlag() {
		return tekiyoYmdNullFlag;
	}


	/**
	 * @param tekiyoYmdNullFlag セットする tekiyoYmdNullFlag
	 */
	public void setTekiyoYmdNullFlag(boolean tekiyoYmdNullFlag) {
		this.tekiyoYmdNullFlag = tekiyoYmdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqBrCdを設定
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
	 * UpdateTRdmReqKnrEntity.javareqBrCdNullFlagを設定
	 * @return reqBrCdNullFlag
	 */
	public boolean isReqBrCdNullFlag() {
		return reqBrCdNullFlag;
	}


	/**
	 * @param reqBrCdNullFlag セットする reqBrCdNullFlag
	 */
	public void setReqBrCdNullFlag(boolean reqBrCdNullFlag) {
		this.reqBrCdNullFlag = reqBrCdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqDistCdを設定
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
	 * UpdateTRdmReqKnrEntity.javareqDistCdNullFlagを設定
	 * @return reqDistCdNullFlag
	 */
	public boolean isReqDistCdNullFlag() {
		return reqDistCdNullFlag;
	}


	/**
	 * @param reqDistCdNullFlag セットする reqDistCdNullFlag
	 */
	public void setReqDistCdNullFlag(boolean reqDistCdNullFlag) {
		this.reqDistCdNullFlag = reqDistCdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqShzNmを設定
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
	 * UpdateTRdmReqKnrEntity.javareqShzNmNullFlagを設定
	 * @return reqShzNmNullFlag
	 */
	public boolean isReqShzNmNullFlag() {
		return reqShzNmNullFlag;
	}


	/**
	 * @param reqShzNmNullFlag セットする reqShzNmNullFlag
	 */
	public void setReqShzNmNullFlag(boolean reqShzNmNullFlag) {
		this.reqShzNmNullFlag = reqShzNmNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqJgiNoを設定
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
	 * UpdateTRdmReqKnrEntity.javareqJgiNoNullFlagを設定
	 * @return reqJgiNoNullFlag
	 */
	public boolean isReqJgiNoNullFlag() {
		return reqJgiNoNullFlag;
	}


	/**
	 * @param reqJgiNoNullFlag セットする reqJgiNoNullFlag
	 */
	public void setReqJgiNoNullFlag(boolean reqJgiNoNullFlag) {
		this.reqJgiNoNullFlag = reqJgiNoNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqJgiNameを設定
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
	 * UpdateTRdmReqKnrEntity.javareqJgiNameNullFlagを設定
	 * @return reqJgiNameNullFlag
	 */
	public boolean isReqJgiNameNullFlag() {
		return reqJgiNameNullFlag;
	}


	/**
	 * @param reqJgiNameNullFlag セットする reqJgiNameNullFlag
	 */
	public void setReqJgiNameNullFlag(boolean reqJgiNameNullFlag) {
		this.reqJgiNameNullFlag = reqJgiNameNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqYmdhmsを設定
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
	 * UpdateTRdmReqKnrEntity.javareqYmdhmsNullFlagを設定
	 * @return reqYmdhmsNullFlag
	 */
	public boolean isReqYmdhmsNullFlag() {
		return reqYmdhmsNullFlag;
	}


	/**
	 * @param reqYmdhmsNullFlag セットする reqYmdhmsNullFlag
	 */
	public void setReqYmdhmsNullFlag(boolean reqYmdhmsNullFlag) {
		this.reqYmdhmsNullFlag = reqYmdhmsNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqMemoを設定
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
	 * UpdateTRdmReqKnrEntity.javareqMemoNullFlagを設定
	 * @return reqMemoNullFlag
	 */
	public boolean isReqMemoNullFlag() {
		return reqMemoNullFlag;
	}


	/**
	 * @param reqMemoNullFlag セットする reqMemoNullFlag
	 */
	public void setReqMemoNullFlag(boolean reqMemoNullFlag) {
		this.reqMemoNullFlag = reqMemoNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqCommentを設定
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
	 * UpdateTRdmReqKnrEntity.javareqCommentNullFlagを設定
	 * @return reqCommentNullFlag
	 */
	public boolean isReqCommentNullFlag() {
		return reqCommentNullFlag;
	}


	/**
	 * @param reqCommentNullFlag セットする reqCommentNullFlag
	 */
	public void setReqCommentNullFlag(boolean reqCommentNullFlag) {
		this.reqCommentNullFlag = reqCommentNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javareqKngKbnを設定
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
	 * UpdateTRdmReqKnrEntity.javareqKngKbnNullFlagを設定
	 * @return reqKngKbnNullFlag
	 */
	public boolean isReqKngKbnNullFlag() {
		return reqKngKbnNullFlag;
	}


	/**
	 * @param reqKngKbnNullFlag セットする reqKngKbnNullFlag
	 */
	public void setReqKngKbnNullFlag(boolean reqKngKbnNullFlag) {
		this.reqKngKbnNullFlag = reqKngKbnNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javashnFlgを設定
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
	 * UpdateTRdmReqKnrEntity.javashnFlgNullFlagを設定
	 * @return shnFlgNullFlag
	 */
	public boolean isShnFlgNullFlag() {
		return shnFlgNullFlag;
	}


	/**
	 * @param shnFlgNullFlag セットする shnFlgNullFlag
	 */
	public void setShnFlgNullFlag(boolean shnFlgNullFlag) {
		this.shnFlgNullFlag = shnFlgNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javashnBrCodeを設定
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
	 * UpdateTRdmReqKnrEntity.javashnBrCodeNullFlagを設定
	 * @return shnBrCodeNullFlag
	 */
	public boolean isShnBrCodeNullFlag() {
		return shnBrCodeNullFlag;
	}


	/**
	 * @param shnBrCodeNullFlag セットする shnBrCodeNullFlag
	 */
	public void setShnBrCodeNullFlag(boolean shnBrCodeNullFlag) {
		this.shnBrCodeNullFlag = shnBrCodeNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javashnDistCodeを設定
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
	 * UpdateTRdmReqKnrEntity.javashnDistCodeNullFlagを設定
	 * @return shnDistCodeNullFlag
	 */
	public boolean isShnDistCodeNullFlag() {
		return shnDistCodeNullFlag;
	}


	/**
	 * @param shnDistCodeNullFlag セットする shnDistCodeNullFlag
	 */
	public void setShnDistCodeNullFlag(boolean shnDistCodeNullFlag) {
		this.shnDistCodeNullFlag = shnDistCodeNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javashnShzを設定
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
	 * UpdateTRdmReqKnrEntity.javashnShzNullFlagを設定
	 * @return shnShzNullFlag
	 */
	public boolean isShnShzNullFlag() {
		return shnShzNullFlag;
	}


	/**
	 * @param shnShzNullFlag セットする shnShzNullFlag
	 */
	public void setShnShzNullFlag(boolean shnShzNullFlag) {
		this.shnShzNullFlag = shnShzNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javashnJgiNoを設定
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
	 * UpdateTRdmReqKnrEntity.javashnJgiNoNullFlagを設定
	 * @return shnJgiNoNullFlag
	 */
	public boolean isShnJgiNoNullFlag() {
		return shnJgiNoNullFlag;
	}


	/**
	 * @param shnJgiNoNullFlag セットする shnJgiNoNullFlag
	 */
	public void setShnJgiNoNullFlag(boolean shnJgiNoNullFlag) {
		this.shnJgiNoNullFlag = shnJgiNoNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javashnShaNameを設定
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
	 * UpdateTRdmReqKnrEntity.javashnShaNameNullFlagを設定
	 * @return shnShaNameNullFlag
	 */
	public boolean isShnShaNameNullFlag() {
		return shnShaNameNullFlag;
	}


	/**
	 * @param shnShaNameNullFlag セットする shnShaNameNullFlag
	 */
	public void setShnShaNameNullFlag(boolean shnShaNameNullFlag) {
		this.shnShaNameNullFlag = shnShaNameNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javashnYmdhmsを設定
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
	 * UpdateTRdmReqKnrEntity.javashnYmdhmsNullFlagを設定
	 * @return shnYmdhmsNullFlag
	 */
	public boolean isShnYmdhmsNullFlag() {
		return shnYmdhmsNullFlag;
	}


	/**
	 * @param shnYmdhmsNullFlag セットする shnYmdhmsNullFlag
	 */
	public void setShnYmdhmsNullFlag(boolean shnYmdhmsNullFlag) {
		this.shnYmdhmsNullFlag = shnYmdhmsNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprBrCodeを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprBrCodeNullFlagを設定
	 * @return aprBrCodeNullFlag
	 */
	public boolean isAprBrCodeNullFlag() {
		return aprBrCodeNullFlag;
	}


	/**
	 * @param aprBrCodeNullFlag セットする aprBrCodeNullFlag
	 */
	public void setAprBrCodeNullFlag(boolean aprBrCodeNullFlag) {
		this.aprBrCodeNullFlag = aprBrCodeNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprDistCodeを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprDistCodeNullFlagを設定
	 * @return aprDistCodeNullFlag
	 */
	public boolean isAprDistCodeNullFlag() {
		return aprDistCodeNullFlag;
	}


	/**
	 * @param aprDistCodeNullFlag セットする aprDistCodeNullFlag
	 */
	public void setAprDistCodeNullFlag(boolean aprDistCodeNullFlag) {
		this.aprDistCodeNullFlag = aprDistCodeNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprShzを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprShzNullFlagを設定
	 * @return aprShzNullFlag
	 */
	public boolean isAprShzNullFlag() {
		return aprShzNullFlag;
	}


	/**
	 * @param aprShzNullFlag セットする aprShzNullFlag
	 */
	public void setAprShzNullFlag(boolean aprShzNullFlag) {
		this.aprShzNullFlag = aprShzNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprJgiNoを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprJgiNoNullFlagを設定
	 * @return aprJgiNoNullFlag
	 */
	public boolean isAprJgiNoNullFlag() {
		return aprJgiNoNullFlag;
	}


	/**
	 * @param aprJgiNoNullFlag セットする aprJgiNoNullFlag
	 */
	public void setAprJgiNoNullFlag(boolean aprJgiNoNullFlag) {
		this.aprJgiNoNullFlag = aprJgiNoNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprShaNameを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprShaNameNullFlagを設定
	 * @return aprShaNameNullFlag
	 */
	public boolean isAprShaNameNullFlag() {
		return aprShaNameNullFlag;
	}


	/**
	 * @param aprShaNameNullFlag セットする aprShaNameNullFlag
	 */
	public void setAprShaNameNullFlag(boolean aprShaNameNullFlag) {
		this.aprShaNameNullFlag = aprShaNameNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprYmdhmsを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprYmdhmsNullFlagを設定
	 * @return aprYmdhmsNullFlag
	 */
	public boolean isAprYmdhmsNullFlag() {
		return aprYmdhmsNullFlag;
	}


	/**
	 * @param aprYmdhmsNullFlag セットする aprYmdhmsNullFlag
	 */
	public void setAprYmdhmsNullFlag(boolean aprYmdhmsNullFlag) {
		this.aprYmdhmsNullFlag = aprYmdhmsNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprHryFlgを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprHryFlgNullFlagを設定
	 * @return aprHryFlgNullFlag
	 */
	public boolean isAprHryFlgNullFlag() {
		return aprHryFlgNullFlag;
	}


	/**
	 * @param aprHryFlgNullFlag セットする aprHryFlgNullFlag
	 */
	public void setAprHryFlgNullFlag(boolean aprHryFlgNullFlag) {
		this.aprHryFlgNullFlag = aprHryFlgNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprMemoを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprMemoNullFlagを設定
	 * @return aprMemoNullFlag
	 */
	public boolean isAprMemoNullFlag() {
		return aprMemoNullFlag;
	}


	/**
	 * @param aprMemoNullFlag セットする aprMemoNullFlag
	 */
	public void setAprMemoNullFlag(boolean aprMemoNullFlag) {
		this.aprMemoNullFlag = aprMemoNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaaprCommentを設定
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
	 * UpdateTRdmReqKnrEntity.javaaprCommentNullFlagを設定
	 * @return aprCommentNullFlag
	 */
	public boolean isAprCommentNullFlag() {
		return aprCommentNullFlag;
	}


	/**
	 * @param aprCommentNullFlag セットする aprCommentNullFlag
	 */
	public void setAprCommentNullFlag(boolean aprCommentNullFlag) {
		this.aprCommentNullFlag = aprCommentNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javainsNoを設定
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
	 * UpdateTRdmReqKnrEntity.javainsNoNullFlagを設定
	 * @return insNoNullFlag
	 */
	public boolean isInsNoNullFlag() {
		return insNoNullFlag;
	}


	/**
	 * @param insNoNullFlag セットする insNoNullFlag
	 */
	public void setInsNoNullFlag(boolean insNoNullFlag) {
		this.insNoNullFlag = insNoNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javadocNoを設定
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
	 * UpdateTRdmReqKnrEntity.javadocNoNullFlagを設定
	 * @return docNoNullFlag
	 */
	public boolean isDocNoNullFlag() {
		return docNoNullFlag;
	}


	/**
	 * @param docNoNullFlag セットする docNoNullFlag
	 */
	public void setDocNoNullFlag(boolean docNoNullFlag) {
		this.docNoNullFlag = docNoNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaupdMstYmdを設定
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
	 * UpdateTRdmReqKnrEntity.javaupdMstYmdNullFlagを設定
	 * @return updMstYmdNullFlag
	 */
	public boolean isUpdMstYmdNullFlag() {
		return updMstYmdNullFlag;
	}


	/**
	 * @param updMstYmdNullFlag セットする updMstYmdNullFlag
	 */
	public void setUpdMstYmdNullFlag(boolean updMstYmdNullFlag) {
		this.updMstYmdNullFlag = updMstYmdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javafbReqFlgを設定
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
	 * UpdateTRdmReqKnrEntity.javafbReqFlgNullFlagを設定
	 * @return fbReqFlgNullFlag
	 */
	public boolean isFbReqFlgNullFlag() {
		return fbReqFlgNullFlag;
	}


	/**
	 * @param fbReqFlgNullFlag セットする fbReqFlgNullFlag
	 */
	public void setFbReqFlgNullFlag(boolean fbReqFlgNullFlag) {
		this.fbReqFlgNullFlag = fbReqFlgNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javafbReqIdを設定
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
	 * UpdateTRdmReqKnrEntity.javafbReqIdNullFlagを設定
	 * @return fbReqIdNullFlag
	 */
	public boolean isFbReqIdNullFlag() {
		return fbReqIdNullFlag;
	}


	/**
	 * @param fbReqIdNullFlag セットする fbReqIdNullFlag
	 */
	public void setFbReqIdNullFlag(boolean fbReqIdNullFlag) {
		this.fbReqIdNullFlag = fbReqIdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javafbAnsIdを設定
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
	 * UpdateTRdmReqKnrEntity.javafbAnsIdNullFlagを設定
	 * @return fbAnsIdNullFlag
	 */
	public boolean isFbAnsIdNullFlag() {
		return fbAnsIdNullFlag;
	}


	/**
	 * @param fbAnsIdNullFlag セットする fbAnsIdNullFlag
	 */
	public void setFbAnsIdNullFlag(boolean fbAnsIdNullFlag) {
		this.fbAnsIdNullFlag = fbAnsIdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javafbDataTypeを設定
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
	 * UpdateTRdmReqKnrEntity.javafbDataTypeNullFlagを設定
	 * @return fbDataTypeNullFlag
	 */
	public boolean isFbDataTypeNullFlag() {
		return fbDataTypeNullFlag;
	}


	/**
	 * @param fbDataTypeNullFlag セットする fbDataTypeNullFlag
	 */
	public void setFbDataTypeNullFlag(boolean fbDataTypeNullFlag) {
		this.fbDataTypeNullFlag = fbDataTypeNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javafbRecIdを設定
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
	 * UpdateTRdmReqKnrEntity.javafbRecIdNullFlagを設定
	 * @return fbRecIdNullFlag
	 */
	public boolean isFbRecIdNullFlag() {
		return fbRecIdNullFlag;
	}


	/**
	 * @param fbRecIdNullFlag セットする fbRecIdNullFlag
	 */
	public void setFbRecIdNullFlag(boolean fbRecIdNullFlag) {
		this.fbRecIdNullFlag = fbRecIdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javafbUpdKbnを設定
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
	 * UpdateTRdmReqKnrEntity.javafbUpdKbnNullFlagを設定
	 * @return fbUpdKbnNullFlag
	 */
	public boolean isFbUpdKbnNullFlag() {
		return fbUpdKbnNullFlag;
	}


	/**
	 * @param fbUpdKbnNullFlag セットする fbUpdKbnNullFlag
	 */
	public void setFbUpdKbnNullFlag(boolean fbUpdKbnNullFlag) {
		this.fbUpdKbnNullFlag = fbUpdKbnNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javafbPrcTypeを設定
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
	 * UpdateTRdmReqKnrEntity.javafbPrcTypeNullFlagを設定
	 * @return fbPrcTypeNullFlag
	 */
	public boolean isFbPrcTypeNullFlag() {
		return fbPrcTypeNullFlag;
	}


	/**
	 * @param fbPrcTypeNullFlag セットする fbPrcTypeNullFlag
	 */
	public void setFbPrcTypeNullFlag(boolean fbPrcTypeNullFlag) {
		this.fbPrcTypeNullFlag = fbPrcTypeNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javainsShaYmdを設定
	 * @return insShaYmd
	 */
	public Date getInsShaYmd() {
		return insShaYmd;
	}


	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(Date insShaYmd) {
		this.insShaYmd = insShaYmd;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javainsShaYmdNullFlagを設定
	 * @return insShaYmdNullFlag
	 */
	public boolean isInsShaYmdNullFlag() {
		return insShaYmdNullFlag;
	}


	/**
	 * @param insShaYmdNullFlag セットする insShaYmdNullFlag
	 */
	public void setInsShaYmdNullFlag(boolean insShaYmdNullFlag) {
		this.insShaYmdNullFlag = insShaYmdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javainsShaIdを設定
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
	 * UpdateTRdmReqKnrEntity.javainsShaIdNullFlagを設定
	 * @return insShaIdNullFlag
	 */
	public boolean isInsShaIdNullFlag() {
		return insShaIdNullFlag;
	}


	/**
	 * @param insShaIdNullFlag セットする insShaIdNullFlag
	 */
	public void setInsShaIdNullFlag(boolean insShaIdNullFlag) {
		this.insShaIdNullFlag = insShaIdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public Date getUpdShaYmd() {
		return updShaYmd;
	}


	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(Date updShaYmd) {
		this.updShaYmd = updShaYmd;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaupdShaYmdNullFlagを設定
	 * @return updShaYmdNullFlag
	 */
	public boolean isUpdShaYmdNullFlag() {
		return updShaYmdNullFlag;
	}


	/**
	 * @param updShaYmdNullFlag セットする updShaYmdNullFlag
	 */
	public void setUpdShaYmdNullFlag(boolean updShaYmdNullFlag) {
		this.updShaYmdNullFlag = updShaYmdNullFlag;
	}


	/**
	 * UpdateTRdmReqKnrEntity.javaupdShaIdを設定
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
	 * UpdateTRdmReqKnrEntity.javaupdShaIdNullFlagを設定
	 * @return updShaIdNullFlag
	 */
	public boolean isUpdShaIdNullFlag() {
		return updShaIdNullFlag;
	}


	/**
	 * @param updShaIdNullFlag セットする updShaIdNullFlag
	 */
	public void setUpdShaIdNullFlag(boolean updShaIdNullFlag) {
		this.updShaIdNullFlag = updShaIdNullFlag;
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
