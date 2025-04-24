/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * 結合Entityクラス
 * テーブル物理名 : M_RDM_HCO_MST
 * SQLID : selectNF001DataList
 * @generated
 */
public class SelectNF001MainDataEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 件数
     * @generated
     */
    private Integer cnt;

    /**
     * 入力_ソートID(パラメータ1)
     * @generated
     */
    private String inSortId;

    /**
     * 入力_開始件数(パラメータ2)
     * @generated
     */
    private Integer inOffset;

    /**
     * 入力_表示件数(パラメータ3)
     * @generated
     */
    private Integer inLimit;

    /**
     * 入力_ログイン組織コード(パラメータ4)
     * @generated
     */
    private String loginSosCd;

    /**
     * 入力_ログイン従業員番号(パラメータ5)
     * @generated
     */
    private String loginJgiNo;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 施設正式漢字名
     * @generated
     */
    private String insFormalName;

    /**
     * 施設固定C
     * @generated
     */
    private String insNo;

    /**
     * 施設住所
     * @generated
     */
    private String insAddr;

    /**
     * 電話番号
     * @generated
     */
    private String insPhone1;

    /**
     * 郵便番号
     * @generated
     */
    private String insPcode;

    /**
     * 施設種別
     * @generated
     */
    private String insType;

    /**
     * 経営主体
     * @generated
     */
    private String keieitaiKj;

    /**
     * ベッド数計
     * @generated
     */
    private String bedsTot;

    /**
     * 医師数
     * @generated
     */
    private String docCount;

    /**
     * 当期納入計画
     * @generated
     */
    private String plnValue;

    /**
     * 当期納入実績
     * @generated
     */
    private String jskValueTk;

    /**
     * 前期納入実績
     * @generated
     */
    private String jskValueZk;

    /**
     * 前々期納入実績
     * @generated
     */
    private String jskValueZzk;

    /**
     * 廃院区分
     * @generated
     */
    private String delKbn;

    /**
     * 廃院区分名
     * @generated
     */
    private String delKbnNm;

    /**
     * 削除フラグ
     * @generated
     */
    private String delFlg;

    /**
     * 削除フラグ名
     * @generated
     */
    private String delFlgNm;

    /**
     * 施設責任者組織
     * @generated
     */
    private String bumonRyakuName;

    /**
     * 施設責任者
     * @generated
     */
    private String jgiName;

    /**
     * ULT施設略名
     * @generated
     */
    private String shisetsuNmRyaku;

    /**
     * ULT施設名正式名
     * @generated
     */
    private String shisetsuNm;

    /**
     * ULT施設コード
     * @generated
     */
    private String dcfShisetsuCd;

    /**
     * ULT住所
     * @generated
     */
    private String address;

    /**
     * ULT電話番号
     * @generated
     */
    private String shisetsuTel;

    /**
     * ULT施設区分
     * @generated
     */
    private String ultPharmType;

    /**
     * ULT経営主体
     * @generated
     */
    private String ultKeieitaiKj;

    /**
     * ULTベッド数計
     * @generated
     */
    private String byoshoSu;

    /**
     * 施設分類
     * @generated
     */
    private String insClass;

    /**
	 * 部門ランク
	 * @generated
	 */
	private String bumonRank;

    /**
     * 組織コード(MR新規判定フラグ用)
     * @generated
     */
    private String sosCd;

    /**
     * 従業員番号(MR新規判定フラグ用)
     * @generated
     */
    private String jgiNo;

    /**
     * 施設名(全角)
     * @generated
     */
    private String insKanjSrch;

    /**
     * 施設名(半角カナ)
     * @generated
     */
    private String insKanaSrch;

    /**
     * 経営主体
     * @generated
     */
    private String keieitai;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

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
     * 都道府県
     * @generated
     */
    private String addrCodePref;

    /**
     * 市区町村
     * @generated
     */
    private String addrCodeCity;

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
     * パラメタ情報（親子紐当期）．値
     * @generated
     */
    private String valueCt;

    /**
     * パラメタ情報（来期項目）．値
     * @generated
     */
    private String valueFac;

    /**
     * パラメタ情報（親子紐来期）．値
     * @generated
     */
    private String valueNt;

    /**
     * MR更新管轄判定用組織コード
     * @generated
     */
    private String tkdSosCd;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNF001MainDataEntity() {
        super("m_rdm_hco_mst" , "selectNF001DataList");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public SelectNF001MainDataEntity(String sqlId) {
        super("m_rdm_hco_mst" , sqlId);
    }

	/**
	 * SelectNF001MainDataEntity.javacntを設定
	 * @return cnt
	 */
	public Integer getCnt() {
		return cnt;
	}

	/**
	 * @param cnt セットする cnt
	 */
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	/**
	 * SelectNF001MainDataEntity.javainSortIdを設定
	 * @return inSortId
	 */
	public String getInSortId() {
		return inSortId;
	}

	/**
	 * @param inSortId セットする inSortId
	 */
	public void setInSortId(String inSortId) {
		this.inSortId = inSortId;
	}

	/**
	 * SelectNF001MainDataEntity.javainOffsetを設定
	 * @return inOffset
	 */
	public Integer getInOffset() {
		return inOffset;
	}

	/**
	 * @param inOffset セットする inOffset
	 */
	public void setInOffset(Integer inOffset) {
		this.inOffset = inOffset;
	}

	/**
	 * SelectNF001MainDataEntity.javainLimitを設定
	 * @return inLimit
	 */
	public Integer getInLimit() {
		return inLimit;
	}

	/**
	 * @param inLimit セットする inLimit
	 */
	public void setInLimit(Integer inLimit) {
		this.inLimit = inLimit;
	}

	/**
	 * SelectNF001MainDataEntity.javaloginSosCdを設定
	 * @return loginSosCd
	 */
	public String getLoginSosCd() {
		return loginSosCd;
	}

	/**
	 * @param loginSosCd セットする loginSosCd
	 */
	public void setLoginSosCd(String loginSosCd) {
		this.loginSosCd = loginSosCd;
	}

	/**
	 * SelectNF001MainDataEntity.javaloginJgiNoを設定
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
	 * SelectNF001MainDataEntity.javainsAbbrNameを設定
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
	 * SelectNF001MainDataEntity.javainsFormalNameを設定
	 * @return insFormalName
	 */
	public String getInsFormalName() {
		return insFormalName;
	}

	/**
	 * @param insFormalName セットする insFormalName
	 */
	public void setInsFormalName(String insFormalName) {
		this.insFormalName = insFormalName;
	}

	/**
	 * SelectNF001MainDataEntity.javainsNoを設定
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
	 * SelectNF001MainDataEntity.javainsAddrを設定
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
	 * SelectNF001MainDataEntity.javainsPhone1を設定
	 * @return insPhone1
	 */
	public String getInsPhone1() {
		return insPhone1;
	}

	/**
	 * @param insPhone1 セットする insPhone1
	 */
	public void setInsPhone1(String insPhone1) {
		this.insPhone1 = insPhone1;
	}

	/**
	 * SelectNF001MainDataEntity.javainsPcodeを設定
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
	 * SelectNF001MainDataEntity.javainsTypeを設定
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
	 * SelectNF001MainDataEntity.javakeieitaiKjを設定
	 * @return keieitaiKj
	 */
	public String getKeieitaiKj() {
		return keieitaiKj;
	}

	/**
	 * @param keieitaiKj セットする keieitaiKj
	 */
	public void setKeieitaiKj(String keieitaiKj) {
		this.keieitaiKj = keieitaiKj;
	}

	/**
	 * SelectNF001MainDataEntity.javabedsTotを設定
	 * @return bedsTot
	 */
	public String getBedsTot() {
		return bedsTot;
	}

	/**
	 * @param bedsTot セットする bedsTot
	 */
	public void setBedsTot(String bedsTot) {
		this.bedsTot = bedsTot;
	}

	/**
	 * SelectNF001MainDataEntity.javadocCountを設定
	 * @return docCount
	 */
	public String getDocCount() {
		return docCount;
	}

	/**
	 * @param docCount セットする docCount
	 */
	public void setDocCount(String docCount) {
		this.docCount = docCount;
	}

	/**
	 * SelectNF001MainDataEntity.javaplnValueを設定
	 * @return plnValue
	 */
	public String getPlnValue() {
		return plnValue;
	}

	/**
	 * @param plnValue セットする plnValue
	 */
	public void setPlnValue(String plnValue) {
		this.plnValue = plnValue;
	}

	/**
	 * SelectNF001MainDataEntity.javajskValueTkを設定
	 * @return jskValueTk
	 */
	public String getJskValueTk() {
		return jskValueTk;
	}

	/**
	 * @param jskValueTk セットする jskValueTk
	 */
	public void setJskValueTk(String jskValueTk) {
		this.jskValueTk = jskValueTk;
	}

	/**
	 * SelectNF001MainDataEntity.javajskValueZkを設定
	 * @return jskValueZk
	 */
	public String getJskValueZk() {
		return jskValueZk;
	}

	/**
	 * @param jskValueZk セットする jskValueZk
	 */
	public void setJskValueZk(String jskValueZk) {
		this.jskValueZk = jskValueZk;
	}

	/**
	 * SelectNF001MainDataEntity.javajskValueZzkを設定
	 * @return jskValueZzk
	 */
	public String getJskValueZzk() {
		return jskValueZzk;
	}

	/**
	 * @param jskValueZzk セットする jskValueZzk
	 */
	public void setJskValueZzk(String jskValueZzk) {
		this.jskValueZzk = jskValueZzk;
	}

	/**
	 * SelectNF001MainDataEntity.javadelKbnを設定
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
	 * SelectNF001MainDataEntity.javadelKbnNmを設定
	 * @return delKbnNm
	 */
	public String getDelKbnNm() {
		return delKbnNm;
	}

	/**
	 * @param delKbnNm セットする delKbnNm
	 */
	public void setDelKbnNm(String delKbnNm) {
		this.delKbnNm = delKbnNm;
	}

	/**
	 * SelectNF001MainDataEntity.javadelFlgを設定
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
	 * SelectNF001MainDataEntity.javadelFlgNmを設定
	 * @return delFlgNm
	 */
	public String getDelFlgNm() {
		return delFlgNm;
	}

	/**
	 * @param delFlgNm セットする delFlgNm
	 */
	public void setDelFlgNm(String delFlgNm) {
		this.delFlgNm = delFlgNm;
	}

	/**
	 * SelectNF001MainDataEntity.javabumonRyakuNameを設定
	 * @return bumonRyakuName
	 */
	public String getBumonRyakuName() {
		return bumonRyakuName;
	}

	/**
	 * @param bumonRyakuName セットする bumonRyakuName
	 */
	public void setBumonRyakuName(String bumonRyakuName) {
		this.bumonRyakuName = bumonRyakuName;
	}

	/**
	 * SelectNF001MainDataEntity.javajgiNameを設定
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
	 * SelectNF001MainDataEntity.javashisetsuNmRyakuを設定
	 * @return shisetsuNmRyaku
	 */
	public String getShisetsuNmRyaku() {
		return shisetsuNmRyaku;
	}

	/**
	 * @param shisetsuNmRyaku セットする shisetsuNmRyaku
	 */
	public void setShisetsuNmRyaku(String shisetsuNmRyaku) {
		this.shisetsuNmRyaku = shisetsuNmRyaku;
	}

	/**
	 * SelectNF001MainDataEntity.javashisetsuNmを設定
	 * @return shisetsuNm
	 */
	public String getShisetsuNm() {
		return shisetsuNm;
	}

	/**
	 * @param shisetsuNm セットする shisetsuNm
	 */
	public void setShisetsuNm(String shisetsuNm) {
		this.shisetsuNm = shisetsuNm;
	}

	/**
	 * SelectNF001MainDataEntity.javadcfShisetsuCdを設定
	 * @return dcfShisetsuCd
	 */
	public String getDcfShisetsuCd() {
		return dcfShisetsuCd;
	}

	/**
	 * @param dcfShisetsuCd セットする dcfShisetsuCd
	 */
	public void setDcfShisetsuCd(String dcfShisetsuCd) {
		this.dcfShisetsuCd = dcfShisetsuCd;
	}

	/**
	 * SelectNF001MainDataEntity.javaaddressを設定
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * SelectNF001MainDataEntity.javashisetsuTelを設定
	 * @return shisetsuTel
	 */
	public String getShisetsuTel() {
		return shisetsuTel;
	}

	/**
	 * @param shisetsuTel セットする shisetsuTel
	 */
	public void setShisetsuTel(String shisetsuTel) {
		this.shisetsuTel = shisetsuTel;
	}

	/**
	 * SelectNF001MainDataEntity.javaultPharmTypeを設定
	 * @return ultPharmType
	 */
	public String getUltPharmType() {
		return ultPharmType;
	}

	/**
	 * @param ultPharmType セットする ultPharmType
	 */
	public void setUltPharmType(String ultPharmType) {
		this.ultPharmType = ultPharmType;
	}

	/**
	 * SelectNF001MainDataEntity.javaultKeieitaiKjを設定
	 * @return ultKeieitaiKj
	 */
	public String getUltKeieitaiKj() {
		return ultKeieitaiKj;
	}

	/**
	 * @param ultKeieitaiKj セットする ultKeieitaiKj
	 */
	public void setUltKeieitaiKj(String ultKeieitaiKj) {
		this.ultKeieitaiKj = ultKeieitaiKj;
	}

	/**
	 * SelectNF001MainDataEntity.javabyoshoSuを設定
	 * @return byoshoSu
	 */
	public String getByoshoSu() {
		return byoshoSu;
	}

	/**
	 * @param byoshoSu セットする byoshoSu
	 */
	public void setByoshoSu(String byoshoSu) {
		this.byoshoSu = byoshoSu;
	}

	/**
	 * SelectNF001MainDataEntity.javainsClassを設定
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
	 * SelectNF001MainDataEntity.javabumonRankを設定
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
	 * SelectNF001MainDataEntity.javasosCdを設定
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
	 * SelectNF001MainDataEntity.javajgiNoを設定
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
	 * SelectNF001MainDataEntity.javainsKanjSrchを設定
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
	 * SelectNF001MainDataEntity.javainsKanaSrchを設定
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
	 * SelectNF001MainDataEntity.javakeieitaiを設定
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
	 * SelectNF001MainDataEntity.javahoInsTypeを設定
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
	 * SelectNF001MainDataEntity.javapharmTypeを設定
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
	 * SelectNF001MainDataEntity.javainsPhoneSrchを設定
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
	 * SelectNF001MainDataEntity.javaaddrCodePrefを設定
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
	 * SelectNF001MainDataEntity.javaaddrCodeCityを設定
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
	 * SelectNF001MainDataEntity.javainsAddrSrchを設定
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
	 * SelectNF001MainDataEntity.javaultInsNoを設定
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
	 * SelectNF001MainDataEntity.javabrCodeを設定
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
	 * SelectNF001MainDataEntity.javadistCodeを設定
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
	 * SelectNF001MainDataEntity.javavalueCtを設定
	 * @return valueCt
	 */
	public String getValueCt() {
		return valueCt;
	}

	/**
	 * @param valueCt セットする valueCt
	 */
	public void setValueCt(String valueCt) {
		this.valueCt = valueCt;
	}

	/**
	 * SelectNF001MainDataEntity.javavalueFacを設定
	 * @return valueFac
	 */
	public String getValueFac() {
		return valueFac;
	}

	/**
	 * @param valueFac セットする valueFac
	 */
	public void setValueFac(String valueFac) {
		this.valueFac = valueFac;
	}

	/**
	 * SelectNF001MainDataEntity.javavalueNtを設定
	 * @return valueNt
	 */
	public String getValueNt() {
		return valueNt;
	}

	/**
	 * @param valueNt セットする valueNt
	 */
	public void setValueNt(String valueNt) {
		this.valueNt = valueNt;
	}

	/**
	 * SelectNF001MainDataEntity.javatkdSosCdを設定
	 * @return tkdSosCd
	 */
	public String getTkdSosCd() {
		return tkdSosCd;
	}

	/**
	 * @param tkdSosCd セットする tkdSosCd
	 */
	public void setTkdSosCd(String tkdSosCd) {
		this.tkdSosCd = tkdSosCd;
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
