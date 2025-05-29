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
public class ND305DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String ND305 = "ND305";

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
	 * 勤務先施設不明
	 * @generated
	 */
	private Boolean unknownFlg;

	/**
	 * 施設
	 * @generated
	 */
	private String skInsNm;

	/**
	 * 大学職位
	 * @generated
	 */
	private String skUnivPosCd;

	/**
	 * 大学職位(名称)
	 * @generated
	 */
	private String skUnivPosNm;

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
	 * 役職(名称)
	 * @generated
	 */
	private String skTitleNm;

	/**
	 * 勤務形態
	 * @generated
	 */
	private String skJobForm;

	/**
	 * 勤務形態(名称)
	 * @generated
	 */
	private String skJobFormNm;

	/**
	 * 薬審メンバー区分
	 * @generated
	 */
	private String skDcctype;

	/**
	 * 薬審メンバー区分(名称)
	 * @generated
	 */
	private String skDcctypeNm;

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
	 * 表示分岐
	 * 0:完全新規、1:ULTから作成、2：申請データあり
	 * @generated
	 */
	private String displayKbn;


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
	 * 処理結果フラグ
	 * 9:完了
	 * @generated
	 */
	private String returnFlg;

	/**
	 * アルトマークへの情報連携
	 * @generated
	 */
	private Boolean fbReqFlg;

	/**
	 * 処理分岐用
	 * 1:申請、2:承認、3:却下
	 * @generated
	 */
	private String funcId;

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
	 * ULT医師C
	 * @generated
	 */
	private String ultDocNo;

	/**
	 * コンボボックス_復活理由
	 * @generated
	 */
	private LinkedHashMap<String,String> rstReasonCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_大学職位
	 * @generated
	 */
	private LinkedHashMap<String,String> skUnivPosCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_役職
	 * @generated
	 */
	private LinkedHashMap<String,String> skTitleCdCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_勤務形態
	 * @generated
	 */
	private LinkedHashMap<String,String> skJobFormCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_薬審メンバー区分
	 * @generated
	 */
	private LinkedHashMap<String,String> skDcctypeCombo = new LinkedHashMap<String,String>();

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND305DTO() {
        setForward(ND305);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setND305(String screenID){
        this.ND305 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getND305(){
        return ND305;
    }



	/**
	 * ND305DTO.javamsgIdを設定
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
	 * ND305DTO.javamsgStrを設定
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
	 * ND305DTO.javaloginJokenSetCdを設定
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
	 * ND305DTO.javaloginJgiNoを設定
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
	 * ND305DTO.javaloginNmを設定
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
	 * ND305DTO.javaloginBrCdを設定
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
	 * ND305DTO.javaloginDistCdを設定
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
	 * ND305DTO.javaloginShzNmを設定
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
	 * ND305DTO.javaloginTrtCdを設定
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
	 * ND305DTO.javagamenIdを設定
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
	 * ND305DTO.javatitleを設定
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
	 * ND305DTO.javareqIdを設定
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
	 * ND305DTO.javareqShzNmを設定
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
	 * ND305DTO.javareqStsNmを設定
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
	 * ND305DTO.javareqJgiNameを設定
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
	 * ND305DTO.javareqYmdhmsを設定
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
	 * ND305DTO.javashnShaNameを設定
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
	 * ND305DTO.javashnYmdhmsを設定
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
	 * ND305DTO.javaaprShaNameを設定
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
	 * ND305DTO.javaaprYmdhmsを設定
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
	 * ND305DTO.javareqJgiNoを設定
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
	 * ND305DTO.javareqBrCdを設定
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
	 * ND305DTO.javareqDistCdを設定
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
	 * ND305DTO.javareqStsCdを設定
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
	 * ND305DTO.javashnJgiNoを設定
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
	 * ND305DTO.javaaprJgiNoを設定
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
	 * ND305DTO.javaupdShaYmdを設定
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
	 * ND305DTO.javatkdDocNoを設定
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
	 * ND305DTO.javatkdDocNmを設定
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
	 * ND305DTO.javatkdDocKanaを設定
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
	 * ND305DTO.javadocKanjiSeiを設定
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
	 * ND305DTO.javadocKanjiMeiを設定
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
	 * ND305DTO.javadelReasonを設定
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
	 * ND305DTO.javadelReasonNmを設定
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
	 * ND305DTO.javarstReasonを設定
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
	 * ND305DTO.javarstReasonNmを設定
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
	 * ND305DTO.javaunknownFlgを設定
	 * @return unknownFlg
	 */
	public Boolean getUnknownFlg() {
		return unknownFlg;
	}

	/**
	 * @param unknownFlg セットする unknownFlg
	 */
	public void setUnknownFlg(Boolean unknownFlg) {
		this.unknownFlg = unknownFlg;
	}

	/**
	 * ND305DTO.javaskInsNmを設定
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
	 * ND305DTO.javaskUnivPosCdを設定
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
	 * ND305DTO.javaskUnivPosNmを設定
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
	 * ND305DTO.javaskDeptNmを設定
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
	 * ND305DTO.javaskTitleCdを設定
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
	 * ND305DTO.javaskTitleNmを設定
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
	 * ND305DTO.javaskJobFormを設定
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
	 * ND305DTO.javaskJobFormNmを設定
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
	 * ND305DTO.javaskDcctypeを設定
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
	 * ND305DTO.javaskDcctypeNmを設定
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
	 * ND305DTO.javaskInsNoを設定
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
	 * ND305DTO.javaskDeptCdを設定
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
	 * ND305DTO.javareqCommentを設定
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
	 * ND305DTO.javaaprMemoを設定
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
	 * ND305DTO.javaaprCommentを設定
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
	 * ND305DTO.javadisplayKbnを設定
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
	 * ND305DTO.javashnFlgを設定
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
	 * ND305DTO.javareqChlを設定
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
	 * ND305DTO.javabuttonFlgを設定
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
	 * ND305DTO.javaeditApprFlgを設定
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
	 * ND305DTO.javabtnEnableFlgを設定
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
	 * ND305DTO.javareturnFlgを設定
	 * @return returnFlg
	 */
	public String getReturnFlg() {
		return returnFlg;
	}

	/**
	 * @param returnFlg セットする returnFlg
	 */
	public void setReturnFlg(String returnFlg) {
		this.returnFlg = returnFlg;
	}

	/**
	 * ND305DTO.javafbReqFlgを設定
	 * @return fbReqFlg
	 */
	public Boolean getFbReqFlg() {
		return fbReqFlg;
	}

	/**
	 * @param fbReqFlg セットする fbReqFlg
	 */
	public void setFbReqFlg(Boolean fbReqFlg) {
		this.fbReqFlg = fbReqFlg;
	}

	/**
	 * ND305DTO.javafuncIdを設定
	 * @return funcId
	 */
	public String getFuncId() {
		return funcId;
	}

	/**
	 * @param funcId セットする funcId
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	/**
	 * ND305DTO.javaskInsHoInsTypeを設定
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
	 * ND305DTO.javaskInsInsClassを設定
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
	 * ND305DTO.javaultDocNoを設定
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
	 * ND305DTO.javarstReasonComboを設定
	 * @return rstReasonCombo
	 */
	public LinkedHashMap<String, String> getRstReasonCombo() {
		return rstReasonCombo;
	}

	/**
	 * @param rstReasonCombo セットする rstReasonCombo
	 */
	public void setRstReasonCombo(LinkedHashMap<String, String> rstReasonCombo) {
		this.rstReasonCombo = rstReasonCombo;
	}

	/**
	 * ND305DTO.javaskUnivPosCdComboを設定
	 * @return skUnivPosCdCombo
	 */
	public LinkedHashMap<String, String> getSkUnivPosCdCombo() {
		return skUnivPosCdCombo;
	}

	/**
	 * @param skUnivPosCdCombo セットする skUnivPosCdCombo
	 */
	public void setSkUnivPosCdCombo(LinkedHashMap<String, String> skUnivPosCdCombo) {
		this.skUnivPosCdCombo = skUnivPosCdCombo;
	}

	/**
	 * ND305DTO.javaskTitleCdComboを設定
	 * @return skTitleCdCombo
	 */
	public LinkedHashMap<String, String> getSkTitleCdCombo() {
		return skTitleCdCombo;
	}

	/**
	 * @param skTitleCdCombo セットする skTitleCdCombo
	 */
	public void setSkTitleCdCombo(LinkedHashMap<String, String> skTitleCdCombo) {
		this.skTitleCdCombo = skTitleCdCombo;
	}

	/**
	 * ND305DTO.javaskJobFormComboを設定
	 * @return skJobFormCombo
	 */
	public LinkedHashMap<String, String> getSkJobFormCombo() {
		return skJobFormCombo;
	}

	/**
	 * @param skJobFormCombo セットする skJobFormCombo
	 */
	public void setSkJobFormCombo(LinkedHashMap<String, String> skJobFormCombo) {
		this.skJobFormCombo = skJobFormCombo;
	}

	/**
	 * ND305DTO.javaskDcctypeComboを設定
	 * @return skDcctypeCombo
	 */
	public LinkedHashMap<String, String> getSkDcctypeCombo() {
		return skDcctypeCombo;
	}

	/**
	 * @param skDcctypeCombo セットする skDcctypeCombo
	 */
	public void setSkDcctypeCombo(LinkedHashMap<String, String> skDcctypeCombo) {
		this.skDcctypeCombo = skDcctypeCombo;
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
