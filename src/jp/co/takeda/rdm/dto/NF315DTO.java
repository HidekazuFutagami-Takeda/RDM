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
public class NF315DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String NF315 = "NF315";

	/**
	 * メッセージID
	 * @generated
	 */
	private String msgId;

	/**
	 * ユーザ権限
	 * @generated
	 */
	private String loginJokenSetCd;

	/**
	 * ユーザ従業員番号
	 * @generated
	 */
	private String loginJgiNo;

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
	 * 武田紐領域別区分
	 * @generated
	 */
	private String tkdTrtKbn;

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
	 * 親施設種別
	 * @generated
	 */
	private String mainInsSbt;

	/**
	 * 施設担当者
	 * @generated
	 */
	private String insTanto;

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
	 * @generated
	 */
	private String displayKbn;

	/**
	 * 次画面分岐用
	 * 0:一時保存、1:申請画面へ
	 * @generated
	 */
	private String funcId;

	/**
	 * コンボボックス_領域・品目グループ
	 * @generated
	 */
	private LinkedHashMap<String,String> trtPrdGrpCombo = new LinkedHashMap<String,String>();

	/**
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

	/**
	 * 編集可能フラグ
	 * 0:不可、1:可
	 * @generated
	 */
	private String editApprFlg;

	/**
	 * 申請ボタン活性フラグ
	 * 0：非活性、1:活性
	 * @generated
	 */
	private String btnEnableFlg;

	/**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NF315DTO() {
        setForward(NF315);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNF315(String screenID){
        this.NF315 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNF315(){
        return NF315;
    }

	/**
	 * NF315DTO.javamsgIdを設定
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
	 * NF315DTO.javaloginJokenSetCdを設定
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
	 * NF315DTO.javaloginJgiNoを設定
	 * @return loginJgiNo
	 */
	public String getLoginJgiNo() {
		return loginJgiNo;
	}

	/**
	 * @param loginJgiNo セットする loginJgiNo
	 */
	public void setLoginJgiNo(String loginJgiNo) {
		this.loginJgiNo = loginJgiNo;
	}

	/**
	 * NF315DTO.javaloginNmを設定
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
	 * NF315DTO.javaloginBrCdを設定
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
	 * NF315DTO.javaloginDistCdを設定
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
	 * NF315DTO.javaloginShzNmを設定
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
	 * NF315DTO.javaloginTrtCdを設定
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
	 * NF315DTO.javagamenIdを設定
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
	 * NF315DTO.javatitleを設定
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
	 * NF315DTO.javareqIdを設定
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
	 * NF315DTO.javareqChlを設定
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
	 * NF315DTO.javareqShzNmを設定
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
	 * NF315DTO.javareqStsNmを設定
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
	 * NF315DTO.javareqJgiNameを設定
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
	 * NF315DTO.javareqYmdhmsを設定
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
	 * NF315DTO.javashnShaNameを設定
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
	 * NF315DTO.javashnYmdhmsを設定
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
	 * NF315DTO.javaaprShaNameを設定
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
	 * NF315DTO.javaaprYmdhmsを設定
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
	 * NF315DTO.javareqJgiNoを設定
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
	 * NF315DTO.javareqBrCdを設定
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
	 * NF315DTO.javareqDistCdを設定
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
	 * NF315DTO.javareqStsCdを設定
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
	 * NF315DTO.javashnJgiNoを設定
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
	 * NF315DTO.javaaprJgiNoを設定
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
	 * NF315DTO.javaupdShaYmdを設定
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
	 * NF315DTO.javatkdTrtKbnを設定
	 * @return tkdTrtKbn
	 */
	public String getTkdTrtKbn() {
		return tkdTrtKbn;
	}

	/**
	 * @param tkdTrtKbn セットする tkdTrtKbn
	 */
	public void setTkdTrtKbn(String tkdTrtKbn) {
		this.tkdTrtKbn = tkdTrtKbn;
	}

	/**
	 * NF315DTO.javainsNoを設定
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
	 * NF315DTO.javainsAbbrNameを設定
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
	 * NF315DTO.javainsAddrを設定
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
	 * NF315DTO.javatrtPrdGrpを設定
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
	 * NF315DTO.javatrtPrdGrpNmを設定
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
	 * NF315DTO.javatrtCdを設定
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
	 * NF315DTO.javahinGCdを設定
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
	 * NF315DTO.javatekiyoYmdを設定
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
	 * NF315DTO.javamainInsCdを設定
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
	 * NF315DTO.javamainInsNmを設定
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
	 * NF315DTO.javamainInsAddrを設定
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
	 * NF315DTO.javamainInsSbtを設定
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
	 * NF315DTO.javainsTantoを設定
	 * @return insTanto
	 */
	public String getInsTanto() {
		return insTanto;
	}

	/**
	 * @param insTanto セットする insTanto
	 */
	public void setInsTanto(String insTanto) {
		this.insTanto = insTanto;
	}

	/**
	 * NF315DTO.javareqCommentを設定
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
	 * NF315DTO.javaaprMemoを設定
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
	 * NF315DTO.javaaprCommentを設定
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
	 * NF315DTO.javadisplayKbnを設定
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
	 * NF315DTO.javafuncIdを設定
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
	 * NF315DTO.javatrtPrdGrpComboを設定
	 * @return trtPrdGrpCombo
	 */
	public LinkedHashMap<String,String> getTrtPrdGrpCombo() {
		return trtPrdGrpCombo;
	}

	/**
	 * @param trtPrdGrpCombo セットする trtPrdGrpCombo
	 */
	public void setTrtPrdGrpCombo(LinkedHashMap<String,String> trtPrdGrpCombo) {
		this.trtPrdGrpCombo = trtPrdGrpCombo;
	}

	/**
	 * NF315DTO.javashnFlgを設定
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
	 * NF315DTO.javaeditApprFlgを設定
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
	 * NF315DTO.javabtnEnableFlgを設定
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
	 * NF315DTO.javamsgStrを設定
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
	 * このDTOの値を返す
	 * @return DTOの値
	 * @generated
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
