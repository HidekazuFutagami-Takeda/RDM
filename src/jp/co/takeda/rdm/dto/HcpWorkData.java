/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


/**
 * DTOクラス
 * @generated
 */
public class HcpWorkData implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 医師勤務先メニュースイッチ
     * @generated
     */
    private String ishiKinmu;

    /**
     * 医師メニュースイッチ
     * @generated
     */
    private String ishiMenu;

    /**
     * アクション申請A
     * @generated
     */
    private int reqA = 0;

    /**
     * アクション申請B
     * @generated
     */
    private int reqB = 0;

    /**
     * 異動・更新フラグ
     * 0:「医療機関への異動」画面
     * 1:「医療機関以外への異動」画面
     * @generated
     */
    private String movemedEditFlg;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;

    /**
     * 施設住所
     * @generated
     */
    private String insAddr;

    /**
     * 所属部科
     * @generated
     */
    private String deptKj;

    /**
     * 役職
     * @generated
     */
    private String TitleKj;

    /**
     * 勤務形態
     * @generated
     */
    private String jobForm;

    /**
     * 大学職位
     * @generated
     */
    private String univTitle;

    /**
     * 施設固定コード(隠し)
     * @generated
     */
    private String insNoKakusi;

    /**
     * 実勤務先判定(ダミー施設コード)
     * @generated
     */
    private String dummyHco;


    /**
     * 勤務先_件数
     * @generated
     */
    private int kinmuCount = 0;

    /**
     * アクション編集
     * 0 or 1
     * @generated
     */
    private String actionEdit;

    /**
     * アクション削除
     * @generated
     * 0 or 1
     */
    private String actionDel;

    /**
     * コンストラクタ
     * @customizable
     */
    public HcpWorkData() {
        // START UOC

        // END UOC
    }

	/**
     * このDTOの値を返す
     * @return DTOの値
     * @generated
     */
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	/**
	 * HcpWorkData.javaishiKinmuを設定
	 * @return ishiKinmu
	 */
	public String getIshiKinmu() {
		return ishiKinmu;
	}

	/**
	 * @param ishiKinmu セットする ishiKinmu
	 */
	public void setIshiKinmu(String ishiKinmu) {
		this.ishiKinmu = ishiKinmu;
	}


	/**
	 * HcpWorkData.javareqAを設定
	 * @return reqA
	 */
	public int getReqA() {
		return reqA;
	}

	/**
	 * @param reqA セットする reqA
	 */
	public void setReqA(int reqA) {
		this.reqA = reqA;
	}

	/**
	 * HcpWorkData.javareqBを設定
	 * @return reqB
	 */
	public int getReqB() {
		return reqB;
	}

	/**
	 * @param reqB セットする reqB
	 */
	public void setReqB(int reqB) {
		this.reqB = reqB;
	}

	/**
	 * HcpWorkData.javainsAbbrNameを設定
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
	 * HcpWorkData.javahoInsTypeを設定
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
	 * HcpWorkData.javainsAddrを設定
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
	 * HcpWorkData.javadeptKjを設定
	 * @return deptKj
	 */
	public String getDeptKj() {
		return deptKj;
	}

	/**
	 * @param deptKj セットする deptKj
	 */
	public void setDeptKj(String deptKj) {
		this.deptKj = deptKj;
	}

	/**
	 * HcpWorkData.javaTitleKjを設定
	 * @return titleKj
	 */
	public String getTitleKj() {
		return TitleKj;
	}

	/**
	 * @param titleKj セットする titleKj
	 */
	public void setTitleKj(String titleKj) {
		TitleKj = titleKj;
	}

	/**
	 * HcpWorkData.javajobFormを設定
	 * @return jobForm
	 */
	public String getJobForm() {
		return jobForm;
	}

	/**
	 * @param jobForm セットする jobForm
	 */
	public void setJobForm(String jobForm) {
		this.jobForm = jobForm;
	}

	/**
	 * HcpWorkData.javaunivTitleを設定
	 * @return univTitle
	 */
	public String getUnivTitle() {
		return univTitle;
	}

	/**
	 * @param univTitle セットする univTitle
	 */
	public void setUnivTitle(String univTitle) {
		this.univTitle = univTitle;
	}


	/**
	 * HcpWorkData.javadummyHcoを設定
	 * @return dummyHco
	 */
	public String getDummyHco() {
		return dummyHco;
	}

	/**
	 * @param dummyHco セットする dummyHco
	 */
	public void setDummyHco(String dummyHco) {
		this.dummyHco = dummyHco;
	}

	/**
	 * HcpWorkData.javaserialVersionUIDを設定
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * HcpWorkData.javaishiMenuを設定
	 * @return ishiMenu
	 */
	public String getIshiMenu() {
		return ishiMenu;
	}

	/**
	 * @param ishiMenu セットする ishiMenu
	 */
	public void setIshiMenu(String ishiMenu) {
		this.ishiMenu = ishiMenu;
	}

	/**
	 * HcpWorkData.javaactionEditを設定
	 * @return actionEdit
	 */
	public String getActionEdit() {
		return actionEdit;
	}

	/**
	 * @param actionEdit セットする actionEdit
	 */
	public void setActionEdit(String actionEdit) {
		this.actionEdit = actionEdit;
	}

	/**
	 * HcpWorkData.javaactionDelを設定
	 * @return actionDel
	 */
	public String getActionDel() {
		return actionDel;
	}

	/**
	 * @param actionDel セットする actionDel
	 */
	public void setActionDel(String actionDel) {
		this.actionDel = actionDel;
	}

	/**
	 * HcpWorkData.javakinmuCountを設定
	 * @return kinmuCount
	 */
	public int getKinmuCount() {
		return kinmuCount;
	}

	/**
	 * @param kinmuCount セットする kinmuCount
	 */
	public void setKinmuCount(int kinmuCount) {
		this.kinmuCount = kinmuCount;
	}

	/**
	 * HcpWorkData.javamovemedEditFlgを設定
	 * @return movemedEditFlg
	 */
	public String getMovemedEditFlg() {
		return movemedEditFlg;
	}

	/**
	 * @param movemedEditFlg セットする movemedEditFlg
	 */
	public void setMovemedEditFlg(String movemedEditFlg) {
		this.movemedEditFlg = movemedEditFlg;
	}

	/**
	 * HcpWorkData.javainsNoKakusiを設定
	 * @return insNoKakusi
	 */
	public String getInsNoKakusi() {
		return insNoKakusi;
	}

	/**
	 * @param insNoKakusi セットする insNoKakusi
	 */
	public void setInsNoKakusi(String insNoKakusi) {
		this.insNoKakusi = insNoKakusi;
	}
}

