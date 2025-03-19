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
public class NF001DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String NF001 = "NF001";

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
	 * ソート部の宣言
	 */
	private String sortCondition;

	/**
	 * 領域区分
	 * @generated
	 */
	private String trtCd;

	/**
	 * 廃院区分
	 * @generated
	 */
	private String delKbn;

	/**
	 * 施設名(全角)
	 * @generated
	 */
	private String insKanjSrch;

	/**
	 * 施設名カナ(半角カナ)
	 * @generated
	 */
	private String insKanaSrch;

	/**
	 * 削除フラグ
	 * @generated
	 */
	private String delFlg;

	/**
	 * 施設固定コード
	 * @generated
	 */
	private String insNo;

	/**
	 * 経営主体コード
	 * @generated
	 */
	private String keieitai;

	/**
	 * 対象区分
	 * @generated
	 */
	private String hoInsType;

	/**
	 * 施設種別
	 * @generated
	 */
	private String insType;

	/**
	 * 施設区分
	 * @generated
	 */
	private String pharmType;

	/**
	 * 電話番号(半角)
	 * @generated
	 */
	private String insPhoneSrch;

	/**
	 * 郵便番号(半角)
	 * @generated
	 */
	private String insPcode;

	/**
	 * 都道府県
	 * @generated
	 */
	private String addrCodePref;

	/**
	 * JIS市区町村
	 * @generated
	 */
	private String addrCodeCity;

	/**
	 * JIS市区町村
	 * @generated
	 */
	private String tmpAddrCodeCity;

	/**
	 * 住所(全角)
	 * @generated
	 */
	private String insAddrSrch;

	/**
	 * ULT施設コード
	 * @generated
	 */
	private String ultInsNo;

	/**
	 * 部門ランク
	 * @generated
	 */
	private String bumonRank;

	/**
	 * 上位組織
	 * @generated
	 */
	private String upSosCd;

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
	 * 一覧表示
     * @generated
     */
    private List<HcoSearchDataList> hcoSearchDataList = new ArrayList<HcoSearchDataList>();

    /**
	 * コンボボックス_廃院区分
	 * @generated
	 */
	private LinkedHashMap<String,String> delKbnCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_削除フラグ
	 * @generated
	 */
	private LinkedHashMap<String,String> delFlgCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_経営主体
	 * @generated
	 */
	private LinkedHashMap<String,String> keieitaiCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_対象区分
	 * @generated
	 */
	private LinkedHashMap<String,String> hoInsTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_施設種別
	 * @generated
	 */
	private LinkedHashMap<String,String> insTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_施設区分
	 * @generated
	 */
	private LinkedHashMap<String,String> pharmTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_都道府県
	 * @generated
	 */
	private LinkedHashMap<String,String> addrPrefCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_市区町村
	 * @generated
	 */
	private LinkedHashMap<String,String> addrCityCombo = new LinkedHashMap<String,String>();

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
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NF001DTO() {
        setForward(NF001);
    }

	/**
	 * NF001DTO.javaNF001を設定
	 * @return nF001
	 */
	public String getNF001() {
		return NF001;
	}

	/**
	 * @param nF001 セットする nF001
	 */
	public void setNF001(String nF001) {
		NF001 = nF001;
	}

	/**
	 * NF001DTO.javamsgIdを設定
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
	 * NF001DTO.javaloginJokenSetCdを設定
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
	 * NF001DTO.javaloginJgiNoを設定
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
	 * NF001DTO.javaloginNmを設定
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
	 * NF001DTO.javaloginBrCdを設定
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
	 * NF001DTO.javaloginDistCdを設定
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
	 * NF001DTO.javaloginShzNmを設定
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
	 * NF001DTO.javaloginTrtCdを設定
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
	 * NF001DTO.javagamenIdを設定
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
	 * NF001DTO.javatitleを設定
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
	 * NF001DTO.javasortConditionを設定
	 * @return sortCondition
	 */
	public String getSortCondition() {
		return sortCondition;
	}

	/**
	 * @param sortCondition セットする sortCondition
	 */
	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}

	/**
	 * NF001DTO.javatrtCdを設定
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
	 * NF001DTO.javadelKbnを設定
	 * @return delKbn
	 */
	public String getDelKbn() {
		return delKbn;
	}

	/**
	 * @param delKbn セットする delKbn
	 */
	public void setDelKbn(String delKbn) {
		this.delKbn = delKbn;
	}

	/**
	 * NF001DTO.javainsKanjSrchを設定
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
	 * NF001DTO.javainsKanaSrchを設定
	 * @return insKanaSrch
	 */
	public String getInsKanaSrch() {
		return insKanaSrch;
	}

	/**
	 * @param insKanaSrch セットする insKanaSrch
	 */
	public void setInsKanaSrch(String insKanaSrch) {
		this.insKanaSrch = insKanaSrch;
	}

	/**
	 * NF001DTO.javadelFlgを設定
	 * @return delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg セットする delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * NF001DTO.javainsNoを設定
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
	 * NF001DTO.javakeieitaiを設定
	 * @return keieitai
	 */
	public String getKeieitai() {
		return keieitai;
	}

	/**
	 * @param keieitai セットする keieitai
	 */
	public void setKeieitai(String keieitai) {
		this.keieitai = keieitai;
	}

	/**
	 * NF001DTO.javahoInsTypeを設定
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
	 * NF001DTO.javainsTypeを設定
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
	 * NF001DTO.javapharmTypeを設定
	 * @return pharmType
	 */
	public String getPharmType() {
		return pharmType;
	}

	/**
	 * @param pharmType セットする pharmType
	 */
	public void setPharmType(String pharmType) {
		this.pharmType = pharmType;
	}

	/**
	 * NF001DTO.javainsPhoneSrchを設定
	 * @return insPhoneSrch
	 */
	public String getInsPhoneSrch() {
		return insPhoneSrch;
	}

	/**
	 * @param insPhoneSrch セットする insPhoneSrch
	 */
	public void setInsPhoneSrch(String insPhoneSrch) {
		this.insPhoneSrch = insPhoneSrch;
	}

	/**
	 * NF001DTO.javainsPcodeを設定
	 * @return insPcode
	 */
	public String getInsPcode() {
		return insPcode;
	}

	/**
	 * @param insPcode セットする insPcode
	 */
	public void setInsPcode(String insPcode) {
		this.insPcode = insPcode;
	}

	/**
	 * NF001DTO.javaaddrCodePrefを設定
	 * @return addrCodePref
	 */
	public String getAddrCodePref() {
		return addrCodePref;
	}

	/**
	 * @param addrCodePref セットする addrCodePref
	 */
	public void setAddrCodePref(String addrCodePref) {
		this.addrCodePref = addrCodePref;
	}

	/**
	 * NF001DTO.javaaddrCodeCityを設定
	 * @return addrCodeCity
	 */
	public String getAddrCodeCity() {
		return addrCodeCity;
	}

	/**
	 * @param addrCodeCity セットする addrCodeCity
	 */
	public void setAddrCodeCity(String addrCodeCity) {
		this.addrCodeCity = addrCodeCity;
	}

	/**
	 * NF001DTO.javatmpAddrCodeCityを設定
	 * @return tmpAddrCodeCity
	 */
	public String getTmpAddrCodeCity() {
		return tmpAddrCodeCity;
	}

	/**
	 * @param tmpAddrCodeCity セットする tmpAddrCodeCity
	 */
	public void setTmpAddrCodeCity(String tmpAddrCodeCity) {
		this.tmpAddrCodeCity = tmpAddrCodeCity;
	}

	/**
	 * NF001DTO.javainsAddrSrchを設定
	 * @return insAddrSrch
	 */
	public String getInsAddrSrch() {
		return insAddrSrch;
	}

	/**
	 * @param insAddrSrch セットする insAddrSrch
	 */
	public void setInsAddrSrch(String insAddrSrch) {
		this.insAddrSrch = insAddrSrch;
	}

	/**
	 * NF001DTO.javaultInsNoを設定
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
	 * NF001DTO.javabumonRankを設定
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
	 * NF001DTO.javaupSosCdを設定
	 * @return upSosCd
	 */
	public String getUpSosCd() {
		return upSosCd;
	}

	/**
	 * @param upSosCd セットする upSosCd
	 */
	public void setUpSosCd(String upSosCd) {
		this.upSosCd = upSosCd;
	}

	/**
	 * NF001DTO.javasosCdを設定
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
	 * NF001DTO.javasosNmを設定
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
	 * NF001DTO.javabrCodeを設定
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
	 * NF001DTO.javadistCodeを設定
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
	 * NF001DTO.javajgiNoを設定
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
	 * NF001DTO.javajgiNmを設定
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
	 * NF001DTO.javahcoSearchDataListを設定
	 * @return hcoSearchDataList
	 */
	public List<HcoSearchDataList> getHcoSearchDataList() {
		return hcoSearchDataList;
	}

	/**
	 * @param hcoSearchDataList セットする hcoSearchDataList
	 */
	public void setHcoSearchDataList(List<HcoSearchDataList> hcoSearchDataList) {
		this.hcoSearchDataList = hcoSearchDataList;
	}

	/**
	 * NF001DTO.javadelKbnComboを設定
	 * @return delKbnCombo
	 */
	public LinkedHashMap<String, String> getDelKbnCombo() {
		return delKbnCombo;
	}

	/**
	 * @param delKbnCombo セットする delKbnCombo
	 */
	public void setDelKbnCombo(LinkedHashMap<String, String> delKbnCombo) {
		this.delKbnCombo = delKbnCombo;
	}

	/**
	 * NF001DTO.javadelFlgComboを設定
	 * @return delFlgCombo
	 */
	public LinkedHashMap<String, String> getDelFlgCombo() {
		return delFlgCombo;
	}

	/**
	 * @param delFlgCombo セットする delFlgCombo
	 */
	public void setDelFlgCombo(LinkedHashMap<String, String> delFlgCombo) {
		this.delFlgCombo = delFlgCombo;
	}

	/**
	 * NF001DTO.javakeieitaiComboを設定
	 * @return keieitaiCombo
	 */
	public LinkedHashMap<String,String> getKeieitaiCombo() {
		return keieitaiCombo;
	}

	/**
	 * @param keieitaiCombo セットする keieitaiCombo
	 */
	public void setKeieitaiCombo(LinkedHashMap<String,String> keieitaiCombo) {
		this.keieitaiCombo = keieitaiCombo;
	}

	/**
	 * NF001DTO.javahoInsTypeComboを設定
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
	 * NF001DTO.javainsTypeComboを設定
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
	 * NF001DTO.javapharmTypeComboを設定
	 * @return pharmTypeCombo
	 */
	public LinkedHashMap<String, String> getPharmTypeCombo() {
		return pharmTypeCombo;
	}

	/**
	 * @param pharmTypeCombo セットする pharmTypeCombo
	 */
	public void setPharmTypeCombo(LinkedHashMap<String, String> pharmTypeCombo) {
		this.pharmTypeCombo = pharmTypeCombo;
	}

	/**
	 * NF001DTO.javaaddrPrefComboを設定
	 * @return addrPrefCombo
	 */
	public LinkedHashMap<String, String> getAddrPrefCombo() {
		return addrPrefCombo;
	}

	/**
	 * @param addrPrefCombo セットする addrPrefCombo
	 */
	public void setAddrPrefCombo(LinkedHashMap<String, String> addrPrefCombo) {
		this.addrPrefCombo = addrPrefCombo;
	}

	/**
	 * NF001DTO.javaaddrCityComboを設定
	 * @return addrCityCombo
	 */
	public LinkedHashMap<String, String> getAddrCityCombo() {
		return addrCityCombo;
	}

	/**
	 * @param addrCityCombo セットする addrCityCombo
	 */
	public void setAddrCityCombo(LinkedHashMap<String, String> addrCityCombo) {
		this.addrCityCombo = addrCityCombo;
	}

	/**
	 * NF001DTO.javamsgStrを設定
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
	 * NF001DTO.javasrchFlgを設定
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
	 * NF001DTO.javapageFlagを設定
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
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
