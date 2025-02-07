package jp.co.takeda.rdm.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

/**
 * Entityクラス
 * テーブル物理名 : S_RDM_JKR_SOS_REQ_KBN
 * テーブル論理名 : 組織担当地区情報
 * @generated
 */
public class SRdmJkrSosFbPrcTypeEntiry extends BaseEntity implements Serializable {

	/**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;


    /**
     * 申請タイプ
     * @generated
     */
    private String value1;

    /**
     * 申請タイプ名
     * @generated
     */
    private String value1Kanj;

    /**
     *施設/医者flag
     **/
	private int idFlg;



	 /**
     * コンストラクタ
     * @generated
     */
    public SRdmJkrSosFbPrcTypeEntiry() {
        super("s_rdm_jkr_sos_fb-prc-type", "selectSRdmJkrSosFbPrcTypeAllEntiry");
    }

	public int getIdflg() {
		return idFlg;
	}


	public void setIdflg(int idFlg) {
		this.idFlg = idFlg;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getValue1() {
		return value1;
	}


	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue1Kanj() {
		return value1Kanj;
	}


	public void setValue1Kanj(String value1Kanj) {
		this.value1Kanj = value1Kanj;
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
