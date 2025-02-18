/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

/**
 * DTOクラス
 * @generated
 */
public class InsData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 検索用＿施設名全角
     * @generated
     */
    private String insKanjiSrch;

    /**
     * 検索用＿施設名半角カナ
     * @generated
     */
    private String insKanaSrch;

    /**
     * 検索用＿廃院区分
     * @generated
     */
    private String haiinKbn;

    /**
     * 検索用＿廃院区分
     * @generated
     */
    private String delFlg;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNoSrch;

    /**
     * 検索用＿ULTコード
     * @generated
     */
    private String ultNo;

    /**
     * 検索条件_対象区分
     * @generated
     */
    private String insType;

    /**
     * 検索条件_施設区分
     * @generated
     */
    private String insKbn;

    /**
     * 検索条件_電話番号(半角)
     * @generated
     */
    private String phone1;

    /**
     * 検索条件_郵便番号(半角)
     * @generated
     */
    private String insPcode;

    /**
     * 検索条件_都道府県
     * @generated
     */
    private String codeCity;

    /**
     * 検索条件_JIS市区町村
     * @generated
     */
    private String addrCodeCity;


    /**
     * 施設名
     * @generated
     */
    private String insAbbrName;

    /**
     * 施設名
     * @generated
     */
    private String insFormalName;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;

    /**
     * 住所
     * @generated
     */
    private String insAddr;

    /**
     * 電話番号
     * @generated
     */
    private String insSbt;

    /**
     * 電話番号
     * @generated
     */
    private String manageCd;

    /**
     * 電話番号
     * @generated
     */
    private int bedsTot;

    /**
     *　ULT施設略式漢字名
     * @generated
     */
    private String shisetsuNmRyaku;

    /**
     * ULT施設正式漢字名
     * @generated
     */
    private String shisetsuNm;

    /**
     * ULT施設固定コード
     * @generated
     */
    private String dcfShisetsuCd;

    /**
     * ULT住所
     * @generated
     */
    private String address;

    /**
     * ULT住所
     * @generated
     */
    private String shisetsuTel;


    /**
     * ULT住所
     * @generated
     */
    private String shisetsuKbn;


    /**
     * ULT住所
     * @generated
     */
    private String keieitaiCd;


    /**
     * ULT住所
     * @generated
     */
    private int byoshoSu;

    /**
     * JIS府県コード
     * @generated
     */
    private String addrCodePref;

    /**
     * 武田市区郡コード
     * @generated
     */
    private String tkCityCd;

    /**
     * 氏名
     * @generated
     */
    private String jgiName;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * コンストラクタ
     * @customizable
     */
    public InsData() {
        // START UOC

        // END UOC
    }



     /**
	 * InsData.javainsKanjiSrchを設定
	 * @return insKanjiSrch
	 */
	public String getInsKanjiSrch() {
		return insKanjiSrch;
	}



	/**
	 * @param insKanjiSrch セットする insKanjiSrch
	 */
	public void setInsKanjiSrch(String insKanjiSrch) {
		this.insKanjiSrch = insKanjiSrch;
	}



	/**
	 * InsData.javainsKanaSrchを設定
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
	 * InsData.javahaiinKbnを設定
	 * @return haiinKbn
	 */
	public String getHaiinKbn() {
		return haiinKbn;
	}



	/**
	 * @param haiinKbn セットする haiinKbn
	 */
	public void setHaiinKbn(String haiinKbn) {
		this.haiinKbn = haiinKbn;
	}



	/**
	 * InsData.javadelFlgを設定
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
	 * InsData.javainsNoSrchを設定
	 * @return insNoSrch
	 */
	public String getInsNoSrch() {
		return insNoSrch;
	}



	/**
	 * @param insNoSrch セットする insNoSrch
	 */
	public void setInsNoSrch(String insNoSrch) {
		this.insNoSrch = insNoSrch;
	}



	/**
	 * InsData.javaultNoを設定
	 * @return ultNo
	 */
	public String getUltNo() {
		return ultNo;
	}



	/**
	 * @param ultNo セットする ultNo
	 */
	public void setUltNo(String ultNo) {
		this.ultNo = ultNo;
	}



	/**
	 * InsData.javainsTypeを設定
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
	 * InsData.javainsKbnを設定
	 * @return insKbn
	 */
	public String getInsKbn() {
		return insKbn;
	}



	/**
	 * @param insKbn セットする insKbn
	 */
	public void setInsKbn(String insKbn) {
		this.insKbn = insKbn;
	}



	/**
	 * InsData.javaphone1を設定
	 * @return phone1
	 */
	public String getPhone1() {
		return phone1;
	}



	/**
	 * @param phone1 セットする phone1
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}



	/**
	 * InsData.javainsPcodeを設定
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
	 * InsData.javacodeCityを設定
	 * @return codeCity
	 */
	public String getCodeCity() {
		return codeCity;
	}



	/**
	 * @param codeCity セットする codeCity
	 */
	public void setCodeCity(String codeCity) {
		this.codeCity = codeCity;
	}



	/**
	 * InsData.javaaddrCodeCityを設定
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
     * 施設名の取得
     * @return 施設名
     * @generated
     */
    public String getInsAbbrName() {
        return insAbbrName;
    }

    /**
     * 施設名の設定
     * @param insAbbrName 施設名
     * @generated
     */
    public void setInsAbbrName(String insAbbrName) {
        this.insAbbrName = insAbbrName;
    }

    /**
    * 施設名の取得
    * @return 施設名
    * @generated
    */
     public String getInsFormalName() {
		return insFormalName;
	}


     /**
      * 施設名の設定
      * @param insAbbrName 施設名
      * @generated
      */
	public void setInsFormalName(String insFormalName) {
		this.insFormalName = insFormalName;
	}

     /**
     * 施設固定コードの取得
     * @return 施設固定コード
     * @generated
     */
    public String getInsNo() {
        return insNo;
    }

    /**
     * 施設固定コードの設定
     * @param insNo 施設固定コード
     * @generated
     */
    public void setInsNo(String insNo) {
        this.insNo = insNo;
    }

     /**
     * 住所の取得
     * @return 住所
     * @generated
     */
    public String getInsAddr() {
        return insAddr;
    }

    /**
     * 住所の設定
     * @param insAddr 住所
     * @generated
     */
    public void setInsAddr(String insAddr) {
        this.insAddr = insAddr;
    }

    /**
    * 住所の取得
    * @return 施設種別
    * @generated
    */
	public String getInsSbt() {
		return insSbt;
	}

    /**
     * 住所の設定
     * @param insSbt 施設種別
     * @generated
     */
	public void setInsSbt(String insSbt) {
		this.insSbt = insSbt;
	}

	public String getManageCd() {
		return manageCd;
	}

	public void setManageCd(String manageCd) {
		this.manageCd = manageCd;
	}

	public int getBedsTot() {
		return bedsTot;
	}

	public void setBedsTot(int bedsTot) {
		this.bedsTot = bedsTot;
	}

	public String getShisetsuNmRyaku() {
		return shisetsuNmRyaku;
	}

	public void setShisetsuNmRyaku(String shisetsuNmRyaku) {
		this.shisetsuNmRyaku = shisetsuNmRyaku;
	}

	public String getShisetsuNm() {
		return shisetsuNm;
	}

	public void setShisetsuNm(String shisetsuNm) {
		this.shisetsuNm = shisetsuNm;
	}

	public String getDcfShisetsuCd() {
		return dcfShisetsuCd;
	}

	public void setDcfShisetsuCd(String dcfShisetsuCd) {
		this.dcfShisetsuCd = dcfShisetsuCd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShisetsuTel() {
		return shisetsuTel;
	}

	public void setShisetsuTel(String shisetsuTel) {
		this.shisetsuTel = shisetsuTel;
	}

	public String getShisetsuKbn() {
		return shisetsuKbn;
	}

	public void setShisetsuKbn(String shisetsuKbn) {
		this.shisetsuKbn = shisetsuKbn;
	}

	public String getKeieitaiCd() {
		return keieitaiCd;
	}

	public void setKeieitaiCd(String keieitaiCd) {
		this.keieitaiCd = keieitaiCd;
	}

	public int getByoshoSu() {
		return byoshoSu;
	}

	public void setByoshoSu(int byoshoSu) {
		this.byoshoSu = byoshoSu;
	}

     /**
     * JIS府県コードの取得
     * @return JIS府県コード
     * @generated
     */
    public String getAddrCodePref() {
        return addrCodePref;
    }

    /**
     * JIS府県コードの設定
     * @param addrCodePref JIS府県コード
     * @generated
     */
    public void setAddrCodePref(String addrCodePref) {
        this.addrCodePref = addrCodePref;
    }

     /**
     * 武田市区郡コードの取得
     * @return 武田市区郡コード
     * @generated
     */
    public String getTkCityCd() {
        return tkCityCd;
    }

    /**
     * 武田市区郡コードの設定
     * @param tkCityCd 武田市区郡コード
     * @generated
     */
    public void setTkCityCd(String tkCityCd) {
        this.tkCityCd = tkCityCd;
    }

    /**
	 * InsData.javajgiNameを設定
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
	 * InsData.javahoInsTypeを設定
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
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

