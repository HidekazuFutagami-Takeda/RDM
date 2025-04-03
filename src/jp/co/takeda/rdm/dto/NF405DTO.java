/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseDTO;

/**
 * DTOクラス
 * @generated
 */
public class NF405DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NF405 = "NF405";

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
	 * 組織
	 * @generated
	 */
	private String sosCd;

	/**
	 * 組織
	 * @generated
	 */
	private String sosNm;

	/**
	 * 医薬支店C
	 * @generated
	 */
	private String brCode;

	/**
	 * 医薬営業所C
	 * @generated
	 */
	private String distCode;

	/**
	 * 部門ランク
	 * @generated
	 */
	private String bumonRank;

	/**
	 * 担当者
	 * @generated
	 */
	private String jgiNo;

	/**
	 * 担当者
	 * @generated
	 */
	private String jgiNm;

	/**
	 * 施設名
	 * @generated
	 */
	private String insNm;

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
	 * 施設略式漢字名
	 * @generated
	 */
	private String insKanjSrch;

	/**
	 * ULT施設名
	 * @generated
	 */
	private String shisetsuNmSrch;

	/**
	 * 施設分類
	 * @generated
	 */
	private String insClass;

	/**
	 * 施設種別
	 * @generated
	 */
	private String insType;

	/**
	 * 対象区分
	 * @generated
	 */
	private String hoInsType;

	/**
	 * ULT差分
	 * @generated
	 */
	private String ultDif;

	/**
	 * 申請ボタン活性フラグ
	 * @generated
	 */
	private String btnEnableFlg;

	/**
	 * 一覧表示
     * @generated
     */
    private List<HcoBlkReqDataList> hcoBlkReqDataList = new ArrayList<HcoBlkReqDataList>();

    /**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NF405DTO() {
        setForward(NF405);
    }

	/**
	 * NF405DTO.javaNF405を設定
	 * @return nF405
	 */
	public String getNF405() {
		return NF405;
	}

	/**
	 * @param nF405 セットする nF405
	 */
	public void setNF405(String nF405) {
		NF405 = nF405;
	}

	/**
	 * NF405DTO.javamsgIdを設定
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
	 * NF405DTO.javaloginJokenSetCdを設定
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
	 * NF405DTO.javaloginJgiNoを設定
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
	 * NF405DTO.javaloginNmを設定
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
	 * NF405DTO.javaloginBrCdを設定
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
	 * NF405DTO.javaloginDistCdを設定
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
	 * NF405DTO.javaloginShzNmを設定
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
	 * NF405DTO.javaloginTrtCdを設定
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
	 * NF405DTO.javagamenIdを設定
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
	 * NF405DTO.javatitleを設定
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
	 * NF405DTO.javasosCdを設定
	 * @return sosCd
	 */
	public String getSosCd() {
		return sosCd;
	}

	/**
	 * @param sosCd セットする sosCd
	 */
	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}

	/**
	 * NF405DTO.javasosNmを設定
	 * @return sosNm
	 */
	public String getSosNm() {
		return sosNm;
	}

	/**
	 * @param sosNm セットする sosNm
	 */
	public void setSosNm(String sosNm) {
		this.sosNm = sosNm;
	}

	/**
	 * NF405DTO.javabrCodeを設定
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
	 * NF405DTO.javadistCodeを設定
	 * @return distCode
	 */
	public String getDistCode() {
		return distCode;
	}

	/**
	 * @param distCode セットする distCode
	 */
	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	/**
	 * NF405DTO.javabumonRankを設定
	 * @return bumonRank
	 */
	public String getBumonRank() {
		return bumonRank;
	}

	/**
	 * @param bumonRank セットする bumonRank
	 */
	public void setBumonRank(String bumonRank) {
		this.bumonRank = bumonRank;
	}

	/**
	 * NF405DTO.javajgiNoを設定
	 * @return jgiNo
	 */
	public String getJgiNo() {
		return jgiNo;
	}

	/**
	 * @param jgiNo セットする jgiNo
	 */
	public void setJgiNo(String jgiNo) {
		this.jgiNo = jgiNo;
	}

	/**
	 * NF405DTO.javajgiNmを設定
	 * @return jgiNm
	 */
	public String getJgiNm() {
		return jgiNm;
	}

	/**
	 * @param jgiNm セットする jgiNm
	 */
	public void setJgiNm(String jgiNm) {
		this.jgiNm = jgiNm;
	}

	/**
	 * NF405DTO.javainsNmを設定
	 * @return insNm
	 */
	public String getInsNm() {
		return insNm;
	}

	/**
	 * @param insNm セットする insNm
	 */
	public void setInsNm(String insNm) {
		this.insNm = insNm;
	}

	/**
	 * NF405DTO.javainsNoを設定
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
	 * NF405DTO.javaultInsNoを設定
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
	 * NF405DTO.javainsKanjSrchを設定
	 * @return insKanjSrch
	 */
	public String getInsKanjSrch() {
		return insKanjSrch;
	}

	/**
	 * @param insKanjSrch セットする insKanjSrch
	 */
	public void setInsKanjSrch(String insKanjSrch) {
		this.insKanjSrch = insKanjSrch;
	}

	/**
	 * NF405DTO.javashisetsuNmSrchを設定
	 * @return shisetsuNmSrch
	 */
	public String getShisetsuNmSrch() {
		return shisetsuNmSrch;
	}

	/**
	 * @param shisetsuNmSrch セットする shisetsuNmSrch
	 */
	public void setShisetsuNmSrch(String shisetsuNmSrch) {
		this.shisetsuNmSrch = shisetsuNmSrch;
	}

	/**
	 * NF405DTO.javainsClassを設定
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
	 * NF405DTO.javainsTypeを設定
	 * @return insType
	 */
	public String getInsType() {
		return insType;
	}

	/**
	 * @param insType セットする insType
	 */
	public void setInsType(String insType) {
		this.insType = insType;
	}

	/**
	 * NF405DTO.javahoInsTypeを設定
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
	 * NF405DTO.javaultDifを設定
	 * @return ultDif
	 */
	public String getUltDif() {
		return ultDif;
	}

	/**
	 * @param ultDif セットする ultDif
	 */
	public void setUltDif(String ultDif) {
		this.ultDif = ultDif;
	}

	/**
	 * NF405DTO.javabtnEnableFlgを設定
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
	 * NF405DTO.javahcoBlkReqDataListを設定
	 * @return hcoBlkReqDataList
	 */
	public List<HcoBlkReqDataList> getHcoBlkReqDataList() {
		return hcoBlkReqDataList;
	}

	/**
	 * @param hcoBlkReqDataList セットする hcoBlkReqDataList
	 */
	public void setHcoBlkReqDataList(List<HcoBlkReqDataList> hcoBlkReqDataList) {
		this.hcoBlkReqDataList = hcoBlkReqDataList;
	}

	/**
	 * NF405DTO.javamsgStrを設定
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
