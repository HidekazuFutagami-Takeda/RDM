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
public class NF401DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NF401 = "NF401";

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
	 * 未審査申請数0のみ対象
	 * @generated
	 */
	private String shnFlgChk;

	/**
	 * 一覧表示
     * @generated
     */
    private List<HcoReqDataList> hcoReqDataList = new ArrayList<HcoReqDataList>();

    /**
	 * コンボボックス_施設分類
	 *
	 * @generated
	 */
	private LinkedHashMap<String,String> insClassCombo = new LinkedHashMap<String,String>();

    /**
     * コンボボックス_施設種別
     * @generated
     */
    private LinkedHashMap<String,String> insTypeCombo = new LinkedHashMap<String,String>();

    /**
	 * コンボボックス_対象区分
	 * @generated
	 */
	private LinkedHashMap<String,String> hoInsTypeCombo = new LinkedHashMap<String,String>();

    /**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

	/**
	 * 検索フラグ
	 * @generated
	 */
	private String srchFlg;

	/**
	 * ページフラグ
	 * @generated
	 */
	private String pageFlag;

	/**
	 * 一括承認ボタン活性フラグ
	 * @generated
	 */
	private String btnEnableFlg;

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NF401DTO() {
        setForward(NF401);
    }

	/**
	 * NF401DTO.javaNF401を設定
	 * @return nF401
	 */
	public String getNF401() {
		return NF401;
	}

	/**
	 * @param nF401 セットする nF401
	 */
	public void setNF401(String nF401) {
		NF401 = nF401;
	}

	/**
	 * NF401DTO.javamsgIdを設定
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
	 * NF401DTO.javaloginJokenSetCdを設定
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
	 * NF401DTO.javaloginJgiNoを設定
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
	 * NF401DTO.javaloginNmを設定
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
	 * NF401DTO.javaloginBrCdを設定
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
	 * NF401DTO.javaloginDistCdを設定
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
	 * NF401DTO.javaloginShzNmを設定
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
	 * NF401DTO.javaloginTrtCdを設定
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
	 * NF401DTO.javagamenIdを設定
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
	 * NF401DTO.javatitleを設定
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
	 * NF401DTO.javasosCdを設定
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
	 * NF401DTO.javasosNmを設定
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
	 * NF401DTO.javabrCodeを設定
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
	 * NF401DTO.javadistCodeを設定
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
	 * NF401DTO.javabumonRankを設定
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
	 * NF401DTO.javajgiNoを設定
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
	 * NF401DTO.javajgiNmを設定
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
	 * NF401DTO.javainsNmを設定
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
	 * NF401DTO.javainsNoを設定
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
	 * NF401DTO.javaultInsNoを設定
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
	 * NF401DTO.javainsKanjSrchを設定
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
	 * NF401DTO.javashisetsuNmSrchを設定
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
	 * NF401DTO.javainsClassを設定
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
	 * NF401DTO.javainsTypeを設定
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
	 * NF401DTO.javahoInsTypeを設定
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
	 * NF401DTO.javashnFlgChkを設定
	 * @return shnFlgChk
	 */
	public String getShnFlgChk() {
		return shnFlgChk;
	}

	/**
	 * @param shnFlgChk セットする shnFlgChk
	 */
	public void setShnFlgChk(String shnFlgChk) {
		this.shnFlgChk = shnFlgChk;
	}

	/**
	 * NF401DTO.javahcoReqDataListを設定
	 * @return hcoReqDataList
	 */
	public List<HcoReqDataList> getHcoReqDataList() {
		return hcoReqDataList;
	}

	/**
	 * @param hcoReqDataList セットする hcoReqDataList
	 */
	public void setHcoReqDataList(List<HcoReqDataList> hcoReqDataList) {
		this.hcoReqDataList = hcoReqDataList;
	}

	/**
	 * NF401DTO.javainsClassComboを設定
	 * @return insClassCombo
	 */
	public LinkedHashMap<String, String> getInsClassCombo() {
		return insClassCombo;
	}

	/**
	 * @param insClassCombo セットする insClassCombo
	 */
	public void setInsClassCombo(LinkedHashMap<String, String> insClassCombo) {
		this.insClassCombo = insClassCombo;
	}

	/**
	 * NF401DTO.javainsTypeComboを設定
	 * @return insTypeCombo
	 */
	public LinkedHashMap<String, String> getInsTypeCombo() {
		return insTypeCombo;
	}

	/**
	 * @param insTypeCombo セットする insTypeCombo
	 */
	public void setInsTypeCombo(LinkedHashMap<String, String> insTypeCombo) {
		this.insTypeCombo = insTypeCombo;
	}

	/**
	 * NF401DTO.javahoInsTypeComboを設定
	 * @return hoInsTypeCombo
	 */
	public LinkedHashMap<String, String> getHoInsTypeCombo() {
		return hoInsTypeCombo;
	}

	/**
	 * @param hoInsTypeCombo セットする hoInsTypeCombo
	 */
	public void setHoInsTypeCombo(LinkedHashMap<String, String> hoInsTypeCombo) {
		this.hoInsTypeCombo = hoInsTypeCombo;
	}

	/**
	 * NF401DTO.javamsgStrを設定
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
	 * NF401DTO.javasrchFlgを設定
	 * @return srchFlg
	 */
	public String getSrchFlg() {
		return srchFlg;
	}

	/**
	 * @param srchFlg セットする srchFlg
	 */
	public void setSrchFlg(String srchFlg) {
		this.srchFlg = srchFlg;
	}

	/**
	 * NF401DTO.javapageFlagを設定
	 * @return pageFlag
	 */
	public String getPageFlag() {
		return pageFlag;
	}

	/**
	 * @param pageFlag セットする pageFlag
	 */
	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}

	/**
	 * NF401DTO.javabtnEnableFlgを設定
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
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
