package jp.co.takeda.rdm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

/**
 * Entityクラス
 * テーブル物理名 : S_RDM_JKR_SOS_ADDR
 * テーブル論理名 : 組織担当地区情報
 * @generated
 */
public class SRdmJkrSosAddrEntiry extends BaseEntity implements Serializable {

	/**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 市区町村フラグ
     * @generated
     */
    private int cityFlg;

    /**
     * JIS府県コード
     * @generated
     */
    private String addrCodePref;
    private boolean addrCodePrefNullFlag;

    /**
     * 武田市区町村コード
     * @generated
     */
    private String addrCodeCity;
    private boolean addrCodeCityNullFlag;

    /**
     * JIS府県名
     * @generated
     */
    private String addrNamePref;
    private boolean addrNamePrefNullFlag;

    /**
     * 武田市区町村名
     * @generated
     */
    private String addrNameCity;
    private boolean addrNameCityNullFlag;

    /**
     * 領域コード
     * @generated
     */
    private String trtCd;
    private boolean trtCdNullFlag;

    /**
     * 組織C
     * @generated
     */
    private String sosCd;
    private boolean sosCdNullFlag;

    /**
     * 最終更新者
     * @generated
     */
    private String upJgiNo;
    private boolean upJgiNoNullFlag;

    /**
     * 登録日
     * @generated
     */
    private String isDate;
    private boolean isDateNullFlag;

    /**
     * 更新日
     * @generated
     */
    private String upDate;
    private boolean upDateNullFlag;

    /**
     * 更新画面ID
     * @generated
     */
    private String upScrnId;
    private boolean upScrnIdNullFlag;

    /**
     * 更新機能ID
     * @generated
     */
    private String upFuncId;
    private boolean upFuncIdNullFlag;

	/**
	 * 検索条件．組織
	 * @generated
	 */
    private String inSosCd;

	/**
	 * 検索条件．組織ランク
	 * @generated
	 */
    private String inSosRank;

	 /**
     * コンストラクタ
     * @generated
     */
    public SRdmJkrSosAddrEntiry() {
        super("s_rdm_jkr_sos_addr", "selectSRdmJkrSosAddrEntiry");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public SRdmJkrSosAddrEntiry(int cityFlg) {
        super("s_rdm_jkr_sos_addr", "selectSRdmJkrCityNameEntiry");
        this.cityFlg = cityFlg;
    }

    /**
     * コンストラクタ
     * @generated
     */
    public SRdmJkrSosAddrEntiry(String addrCodePref) {
        super("s_rdm_jkr_sos_addr", "selectSRdmJkrCityNameEntiry");
        this.addrCodePref = addrCodePref;
    }


	public int getCityFlg() {
		return cityFlg;
	}


	public void setCityFlg(int cityFlg) {
		this.cityFlg = cityFlg;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAddrCodePref() {
		return addrCodePref;
	}


	public void setAddrCodePref(String addrCodePref) {
		this.addrCodePref = addrCodePref;
	}


	public boolean isAddrCodePrefNullFlag() {
		return addrCodePrefNullFlag;
	}


	public void setAddrCodePrefNullFlag(boolean addrCodePrefNullFlag) {
		this.addrCodePrefNullFlag = addrCodePrefNullFlag;
	}

	/**
	 * SRdmJkrSosAddrEntiry.javaaddrCodeCityを設定
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
	 * SRdmJkrSosAddrEntiry.javaaddrCodeCityNullFlagを設定
	 * @return addrCodeCityNullFlag
	 */
	public boolean isAddrCodeCityNullFlag() {
		return addrCodeCityNullFlag;
	}

	/**
	 * @param addrCodeCityNullFlag セットする addrCodeCityNullFlag
	 */
	public void setAddrCodeCityNullFlag(boolean addrCodeCityNullFlag) {
		this.addrCodeCityNullFlag = addrCodeCityNullFlag;
	}

	public String getAddrNamePref() {
		return addrNamePref;
	}


	public void setAddrNamePref(String addrNamePref) {
		this.addrNamePref = addrNamePref;
	}


	public boolean isAddrNamePrefNullFlag() {
		return addrNamePrefNullFlag;
	}


	public void setAddrNamePrefNullFlag(boolean addrNamePrefNullFlag) {
		this.addrNamePrefNullFlag = addrNamePrefNullFlag;
	}

	/**
	 * SRdmJkrSosAddrEntiry.javaaddrNameCityを設定
	 * @return addrNameCity
	 */
	public String getAddrNameCity() {
		return addrNameCity;
	}

	/**
	 * @param addrNameCity セットする addrNameCity
	 */
	public void setAddrNameCity(String addrNameCity) {
		this.addrNameCity = addrNameCity;
	}

	/**
	 * SRdmJkrSosAddrEntiry.javaaddrNameCityNullFlagを設定
	 * @return addrNameCityNullFlag
	 */
	public boolean isAddrNameCityNullFlag() {
		return addrNameCityNullFlag;
	}

	/**
	 * @param addrNameCityNullFlag セットする addrNameCityNullFlag
	 */
	public void setAddrNameCityNullFlag(boolean addrNameCityNullFlag) {
		this.addrNameCityNullFlag = addrNameCityNullFlag;
	}

	public String getTrtCd() {
		return trtCd;
	}


	public void setTrtCd(String trtCd) {
		this.trtCd = trtCd;
	}


	public boolean isTrtCdNullFlag() {
		return trtCdNullFlag;
	}


	public void setTrtCdNullFlag(boolean trtCdNullFlag) {
		this.trtCdNullFlag = trtCdNullFlag;
	}


	public String getSosCd() {
		return sosCd;
	}


	public void setSosCd(String sosCd) {
		this.sosCd = sosCd;
	}


	public boolean isSosCdNullFlag() {
		return sosCdNullFlag;
	}


	public void setSosCdNullFlag(boolean sosCdNullFlag) {
		this.sosCdNullFlag = sosCdNullFlag;
	}


	public String getUpJgiNo() {
		return upJgiNo;
	}


	public void setUpJgiNo(String upJgiNo) {
		this.upJgiNo = upJgiNo;
	}


	public boolean isUpJgiNoNullFlag() {
		return upJgiNoNullFlag;
	}


	public void setUpJgiNoNullFlag(boolean upJgiNoNullFlag) {
		this.upJgiNoNullFlag = upJgiNoNullFlag;
	}


	public String getIsDate() {
		return isDate;
	}


	public void setIsDate(String isDate) {
		this.isDate = isDate;
	}


	public boolean isDateNullFlag() {
		return isDateNullFlag;
	}


	public void setDateNullFlag(boolean isDateNullFlag) {
		this.isDateNullFlag = isDateNullFlag;
	}


	public String getUpDate() {
		return upDate;
	}


	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}


	public boolean isUpDateNullFlag() {
		return upDateNullFlag;
	}


	public void setUpDateNullFlag(boolean upDateNullFlag) {
		this.upDateNullFlag = upDateNullFlag;
	}


	public String getUpScrnId() {
		return upScrnId;
	}


	public void setUpScrnId(String upScrnId) {
		this.upScrnId = upScrnId;
	}


	public boolean isUpScrnIdNullFlag() {
		return upScrnIdNullFlag;
	}


	public void setUpScrnIdNullFlag(boolean upScrnIdNullFlag) {
		this.upScrnIdNullFlag = upScrnIdNullFlag;
	}


	public String getUpFuncId() {
		return upFuncId;
	}


	public void setUpFuncId(String upFuncId) {
		this.upFuncId = upFuncId;
	}


	public boolean isUpFuncIdNullFlag() {
		return upFuncIdNullFlag;
	}


	public void setUpFuncIdNullFlag(boolean upFuncIdNullFlag) {
		this.upFuncIdNullFlag = upFuncIdNullFlag;
	}


	/**
	 * SRdmJkrSosAddrEntiry.javainSosCdを設定
	 * @return inSosCd
	 */
	public String getInSosCd() {
		return inSosCd;
	}

	/**
	 * @param inSosCd セットする inSosCd
	 */
	public void setInSosCd(String inSosCd) {
		this.inSosCd = inSosCd;
	}

	/**
	 * SRdmJkrSosAddrEntiry.javainSosRankを設定
	 * @return inSosRank
	 */
	public String getInSosRank() {
		return inSosRank;
	}

	/**
	 * @param inSosRank セットする inSosRank
	 */
	public void setInSosRank(String inSosRank) {
		this.inSosRank = inSosRank;
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
