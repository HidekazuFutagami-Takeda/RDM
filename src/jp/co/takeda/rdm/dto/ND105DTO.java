/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseDTO;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * DTOクラス
 * @generated
 */
public class ND105DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String ND105 = "ND105";

	/**
	 * メッセージID
	 * @generated
	 */
	private String msgId;

	/**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

	/**
	 * ユーザ権限
	 * @generated
	 */
	private String loginJokenSetCd;

	/**
	 * ユーザ従業員番号
	 * @generated
	 */
	private Integer loginJgiNo;

	/**
	 * ユーザ氏名
	 * @generated
	 */
	private String loginNm;

	/**
	 * ユーザ医薬支店C
	 * @generated
	 */
	private String loginBrCd;

	/**
	 * ユーザ医薬営業所C
	 * @generated
	 */
	private String loginDistCd;

	/**
	 * ユーザ所属組織名
	 * @generated
	 */
	private String loginShzNm;

	/**
	 * ユーザ領域コード
	 * @generated
	 */
	private String loginTrtCd;

	/**
	 * 画面ＩＤ（共通部分判定用）
	 * @generated
	 */
	private String gamenId;

	/**
	 * 画面タイトル
	 * @generated
	 */
	private String title;

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
	 * ULT医師C
	 * @generated
	 */
	private String ultDocNo;

	/**
	 * 表示分岐
	 * 0:完全新規、1:ULTから作成、2：申請データあり
	 * @generated
	 */
	private String displayKbn;

	/**
	 * コンボボックス_削除理由
	 * @generated
	 */
	private LinkedHashMap<String,String> delReasonCombo = new LinkedHashMap<String,String>();

	/**
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

    /**
     * ボタンフラグ
     * @generated
     */
    private String buttonFlg;

	/**
	 * 編集可能フラグ
	 * 0:不可、1:可
	 * @generated
	 */
	private String editApprFlg;

	/**
	 * 勤務ボタン可否フラグ
	 * 0:不可、1:可
	 * @generated
	 */
	private String btnEnableFlg;

	/**
	 * 申請チャネル
	 * @generated
	 */
	private String reqChl;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND105DTO() {
        setForward(ND105);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setND105(String screenID){
        this.ND105 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getND105(){
        return ND105;
    }

	/**
	 * ND105DTO.javaloginJokenSetCdを設定
	 * @return loginJokenSetCd
	 */
	public String getLoginJokenSetCd() {
		return loginJokenSetCd;
	}

	/**
	 * @param loginJokenSetCd セットする loginJokenSetCd
	 */
	public void setLoginJokenSetCd(String loginJokenSetCd) {
		this.loginJokenSetCd = loginJokenSetCd;
	}

	/**
	 * ND105DTO.javaloginJgiNoを設定
	 * @return loginJgiNo
	 */
	public Integer getLoginJgiNo() {
		return loginJgiNo;
	}

	/**
	 * @param loginJgiNo セットする loginJgiNo
	 */
	public void setLoginJgiNo(Integer loginJgiNo) {
		this.loginJgiNo = loginJgiNo;
	}

	/**
	 * ND105DTO.javaloginNmを設定
	 * @return loginNm
	 */
	public String getLoginNm() {
		return loginNm;
	}

	/**
	 * @param loginNm セットする loginNm
	 */
	public void setLoginNm(String loginNm) {
		this.loginNm = loginNm;
	}

	/**
	 * ND105DTO.javaloginBrCdを設定
	 * @return loginBrCd
	 */
	public String getLoginBrCd() {
		return loginBrCd;
	}

	/**
	 * @param loginBrCd セットする loginBrCd
	 */
	public void setLoginBrCd(String loginBrCd) {
		this.loginBrCd = loginBrCd;
	}

	/**
	 * ND105DTO.javaloginDistCdを設定
	 * @return loginDistCd
	 */
	public String getLoginDistCd() {
		return loginDistCd;
	}

	/**
	 * @param loginDistCd セットする loginDistCd
	 */
	public void setLoginDistCd(String loginDistCd) {
		this.loginDistCd = loginDistCd;
	}

	/**
	 * ND105DTO.javaloginShzNmを設定
	 * @return loginShzNm
	 */
	public String getLoginShzNm() {
		return loginShzNm;
	}

	/**
	 * @param loginShzNm セットする loginShzNm
	 */
	public void setLoginShzNm(String loginShzNm) {
		this.loginShzNm = loginShzNm;
	}

	/**
	 * ND105DTO.javaloginTrtCdを設定
	 * @return loginTrtCd
	 */
	public String getLoginTrtCd() {
		return loginTrtCd;
	}

	/**
	 * @param loginTrtCd セットする loginTrtCd
	 */
	public void setLoginTrtCd(String loginTrtCd) {
		this.loginTrtCd = loginTrtCd;
	}

	/**
	 * ND105DTO.javagamenIdを設定
	 * @return gamenId
	 */
	public String getGamenId() {
		return gamenId;
	}

	/**
	 * @param gamenId セットする gamenId
	 */
	public void setGamenId(String gamenId) {
		this.gamenId = gamenId;
	}

	/**
	 * ND105DTO.javatitleを設定
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ND105DTO.javareqIdを設定
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
	 * ND105DTO.javareqShzNmを設定
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
	 * ND105DTO.javareqStsNmを設定
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
	 * ND105DTO.javareqJgiNameを設定
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
	 * ND105DTO.javareqYmdhmsを設定
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
	 * ND105DTO.javashnShaNameを設定
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
	 * ND105DTO.javashnYmdhmsを設定
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
	 * ND105DTO.javaaprShaNameを設定
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
	 * ND105DTO.javaaprYmdhmsを設定
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
	 * ND105DTO.javareqJgiNoを設定
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
	 * ND105DTO.javareqBrCdを設定
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
	 * ND105DTO.javareqDistCdを設定
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
	 * ND105DTO.javareqStsCdを設定
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
	 * ND105DTO.javashnJgiNoを設定
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
	 * ND105DTO.javaaprJgiNoを設定
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
	 * ND105DTO.javaupdShaYmdを設定
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
	 * ND105DTO.javamsgIdを設定
	 * @return msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId セットする msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * ND105DTO.javamsgStrを設定
	 * @return msgStr
	 */
	public String getMsgStr() {
		return msgStr;
	}

	/**
	 * @param msgStr セットする msgStr
	 */
	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	/**
	 * ND105DTO.javatkdDocNoを設定
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
	 * ND105DTO.javatkdDocNmを設定
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
	 * ND105DTO.javatkdDocKanaを設定
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
	 * ND105DTO.javadocKanjiSeiを設定
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
	 * ND105DTO.javadocKanjiMeiを設定
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
	 * ND105DTO.javadocAttributeを設定
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
	 * ND105DTO.javadocAttributeNmを設定
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
	 * ND105DTO.javadelReasonを設定
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
	 * ND105DTO.javadupDocNoを設定
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
	 * ND105DTO.javadupDocNmを設定
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
	 * ND105DTO.javareqCommentを設定
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
	 * ND105DTO.javaaprMemoを設定
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
	 * ND105DTO.javaaprCommentを設定
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

	public String getUltDocNo() {
		return ultDocNo;
	}

	public void setUltDocNo(String ultDocNo) {
		this.ultDocNo = ultDocNo;
	}

	/**
	 * ND105DTO.javadisplayKbnを設定
	 * @return displayKbn
	 */
	public String getDisplayKbn() {
		return displayKbn;
	}

	/**
	 * @param displayKbn セットする displayKbn
	 */
	public void setDisplayKbn(String displayKbn) {
		this.displayKbn = displayKbn;
	}

	/**
	 * ND105DTO.javadelReasonComboを設定
	 * @return delReasonCombo
	 */
	public LinkedHashMap<String, String> getDelReasonCombo() {
		return delReasonCombo;
	}

	/**
	 * @param delReasonCombo セットする delReasonCombo
	 */
	public void setDelReasonCombo(LinkedHashMap<String, String> delReasonCombo) {
		this.delReasonCombo = delReasonCombo;
	}

	/**
	 * ND105DTO.javashnFlgを設定
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
	 * ND105DTO.javabuttonFlgを設定
	 * @return buttonFlg
	 */
	public String getButtonFlg() {
		return buttonFlg;
	}

	/**
	 * @param buttonFlg セットする buttonFlg
	 */
	public void setButtonFlg(String buttonFlg) {
		this.buttonFlg = buttonFlg;
	}

	/**
	 * ND105DTO.javaeditApprFlgを設定
	 * @return editApprFlg
	 */
	public String getEditApprFlg() {
		return editApprFlg;
	}

	/**
	 * @param editApprFlg セットする editApprFlg
	 */
	public void setEditApprFlg(String editApprFlg) {
		this.editApprFlg = editApprFlg;
	}

	/**
	 * ND105DTO.javabtnEnableFlgを設定
	 * @return btnEnableFlg
	 */
	public String getBtnEnableFlg() {
		return btnEnableFlg;
	}

	/**
	 * @param btnEnableFlg セットする btnEnableFlg
	 */
	public void setBtnEnableFlg(String btnEnableFlg) {
		this.btnEnableFlg = btnEnableFlg;
	}

	/**
	 * ND105DTO.javareqChlを設定
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
	 * このDTOの値を返す
	 * @return DTOの値
	 * @generated
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
