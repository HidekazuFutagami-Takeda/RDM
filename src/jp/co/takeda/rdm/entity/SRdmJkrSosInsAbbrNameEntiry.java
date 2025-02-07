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
public class SRdmJkrSosInsAbbrNameEntiry extends BaseEntity implements Serializable {

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
    private String insNo;

    private String paramInsNo;


    public String getParamInsNo() {
		return paramInsNo;
	}



	public void setParamInsNo(String paramInsNo) {
		this.paramInsNo = paramInsNo;
	}

	/**
     * 略式漢字施設名
     * @generated
     */
    private String insAbbrName;




	 /**
     * コンストラクタ
     * @generated
     */
    public SRdmJkrSosInsAbbrNameEntiry() {
        super("s_rdm_jkr_sos_ins_abbr_name", "selectSRdmJkrSosInsAbrrNameEntiry");
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

	public String getInsNo() {
		return insNo;
	}


	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}


	public String getInsAbbrName() {
		return insAbbrName;
	}


	public void setInsAbbrName(String insAbbrName) {
		this.insAbbrName = insAbbrName;
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
