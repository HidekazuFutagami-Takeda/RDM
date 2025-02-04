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
 * Entityクラス
 * テーブル物理名 : T_RDM_REQ_KNR
 * テーブル論理名 : 申請管理
 * @generated
 */
public class TRdmReqKnrEntity extends BaseEntity implements Serializable {

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
    private String aprCommnet;
    private boolean aprCommnetNullFlag;

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
    public TRdmReqKnrEntity() {
        super("t_rdm_req_knr");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public TRdmReqKnrEntity(String sqlId) {
        super("t_rdm_req_knr", sqlId);
    }

	/**
	 * TRdmReqKnrEntity.javareqIdを設定
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
	 * TRdmReqKnrEntity.javareqIdNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqChlを設定
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
	 * TRdmReqKnrEntity.javareqChlNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqTypeを設定
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
	 * TRdmReqKnrEntity.javareqTypeNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqStsCdを設定
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
	 * TRdmReqKnrEntity.javareqStsCdNullFlagを設定
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
	 * TRdmReqKnrEntity.javatekiyoYmdを設定
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
	 * TRdmReqKnrEntity.javatekiyoYmdNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqBrCdを設定
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
	 * TRdmReqKnrEntity.javareqBrCdNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqDistCdを設定
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
	 * TRdmReqKnrEntity.javareqDistCdNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqShzNmを設定
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
	 * TRdmReqKnrEntity.javareqShzNmNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqJgiNoを設定
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
	 * TRdmReqKnrEntity.javareqJgiNoNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqJgiNameを設定
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
	 * TRdmReqKnrEntity.javareqJgiNameNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqYmdhmsを設定
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
	 * TRdmReqKnrEntity.javareqYmdhmsNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqMemoを設定
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
	 * TRdmReqKnrEntity.javareqMemoNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqCommentを設定
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
	 * TRdmReqKnrEntity.javareqCommentNullFlagを設定
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
	 * TRdmReqKnrEntity.javareqKngKbnを設定
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
	 * TRdmReqKnrEntity.javareqKngKbnNullFlagを設定
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
	 * TRdmReqKnrEntity.javashnFlgを設定
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
	 * TRdmReqKnrEntity.javashnFlgNullFlagを設定
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
	 * TRdmReqKnrEntity.javashnBrCodeを設定
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
	 * TRdmReqKnrEntity.javashnBrCodeNullFlagを設定
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
	 * TRdmReqKnrEntity.javashnDistCodeを設定
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
	 * TRdmReqKnrEntity.javashnDistCodeNullFlagを設定
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
	 * TRdmReqKnrEntity.javashnShzを設定
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
	 * TRdmReqKnrEntity.javashnShzNullFlagを設定
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
	 * TRdmReqKnrEntity.javashnJgiNoを設定
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
	 * TRdmReqKnrEntity.javashnJgiNoNullFlagを設定
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
	 * TRdmReqKnrEntity.javashnShaNameを設定
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
	 * TRdmReqKnrEntity.javashnShaNameNullFlagを設定
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
	 * TRdmReqKnrEntity.javashnYmdhmsを設定
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
	 * TRdmReqKnrEntity.javashnYmdhmsNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprBrCodeを設定
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
	 * TRdmReqKnrEntity.javaaprBrCodeNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprDistCodeを設定
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
	 * TRdmReqKnrEntity.javaaprDistCodeNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprShzを設定
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
	 * TRdmReqKnrEntity.javaaprShzNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprJgiNoを設定
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
	 * TRdmReqKnrEntity.javaaprJgiNoNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprShaNameを設定
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
	 * TRdmReqKnrEntity.javaaprShaNameNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprYmdhmsを設定
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
	 * TRdmReqKnrEntity.javaaprYmdhmsNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprHryFlgを設定
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
	 * TRdmReqKnrEntity.javaaprHryFlgNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprMemoを設定
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
	 * TRdmReqKnrEntity.javaaprMemoNullFlagを設定
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
	 * TRdmReqKnrEntity.javaaprCommnetを設定
	 * @return aprCommnet
	 */
	public String getAprCommnet() {
		return aprCommnet;
	}


	/**
	 * @param aprCommnet セットする aprCommnet
	 */
	public void setAprCommnet(String aprCommnet) {
		this.aprCommnet = aprCommnet;
	}


	/**
	 * TRdmReqKnrEntity.javaaprCommnetNullFlagを設定
	 * @return aprCommnetNullFlag
	 */
	public boolean isAprCommnetNullFlag() {
		return aprCommnetNullFlag;
	}


	/**
	 * @param aprCommnetNullFlag セットする aprCommnetNullFlag
	 */
	public void setAprCommnetNullFlag(boolean aprCommnetNullFlag) {
		this.aprCommnetNullFlag = aprCommnetNullFlag;
	}


	/**
	 * TRdmReqKnrEntity.javainsNoを設定
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
	 * TRdmReqKnrEntity.javainsNoNullFlagを設定
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
	 * TRdmReqKnrEntity.javadocNoを設定
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
	 * TRdmReqKnrEntity.javadocNoNullFlagを設定
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
	 * TRdmReqKnrEntity.javaupdMstYmdを設定
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
	 * TRdmReqKnrEntity.javaupdMstYmdNullFlagを設定
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
	 * TRdmReqKnrEntity.javafbReqFlgを設定
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
	 * TRdmReqKnrEntity.javafbReqFlgNullFlagを設定
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
	 * TRdmReqKnrEntity.javafbReqIdを設定
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
	 * TRdmReqKnrEntity.javafbReqIdNullFlagを設定
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
	 * TRdmReqKnrEntity.javafbAnsIdを設定
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
	 * TRdmReqKnrEntity.javafbAnsIdNullFlagを設定
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
	 * TRdmReqKnrEntity.javafbDataTypeを設定
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
	 * TRdmReqKnrEntity.javafbDataTypeNullFlagを設定
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
	 * TRdmReqKnrEntity.javafbRecIdを設定
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
	 * TRdmReqKnrEntity.javafbRecIdNullFlagを設定
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
	 * TRdmReqKnrEntity.javafbUpdKbnを設定
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
	 * TRdmReqKnrEntity.javafbUpdKbnNullFlagを設定
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
	 * TRdmReqKnrEntity.javafbPrcTypeを設定
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
	 * TRdmReqKnrEntity.javafbPrcTypeNullFlagを設定
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
	 * TRdmReqKnrEntity.javainsShaYmdを設定
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
	 * TRdmReqKnrEntity.javainsShaYmdNullFlagを設定
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
	 * TRdmReqKnrEntity.javainsShaIdを設定
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
	 * TRdmReqKnrEntity.javainsShaIdNullFlagを設定
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
	 * TRdmReqKnrEntity.javaupdShaYmdを設定
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
	 * TRdmReqKnrEntity.javaupdShaYmdNullFlagを設定
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
	 * TRdmReqKnrEntity.javaupdShaIdを設定
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
	 * TRdmReqKnrEntity.javaupdShaIdNullFlagを設定
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
