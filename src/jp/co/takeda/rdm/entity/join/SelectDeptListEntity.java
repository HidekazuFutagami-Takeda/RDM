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
 * テーブル物理名 : S_JKR_DMC_MST_DEPT
 * SQLID : selectDeptList
 * @generated
 */
public class SelectDeptListEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 入力_SELECT区分 (パラメータ1)
     * @generated
     */
    private Integer inSelectKbn;

    /**
     * 入力_施設固定コード (パラメータ2)
     * @generated
     */
    private String inInsNo;

    /**
     * 入力_所属部科名カナ (パラメータ3)
     * @generated
     */
    private String inKanaName;

    /**
     * 入力_所属部科名漢字 (パラメータ4)
     * @generated
     */
    private String inKanjName;

    /**
     * 所属部科コード
     * @generated
     */
    private String deptCode;

    /**
     * 所属部科名カナ
     * @generated
     */
    private String kanaName;

    /**
     * 所属部科名漢字
     * @generated
     */
    private String kanjName;

    /**
     * レコード件数
     * @generated
     */
    private Integer recCnt;

    /**
     * コンストラクタ
     * @generated
     */
    public SelectDeptListEntity() {
        super("s_jkr_dmc_mst_dept" , "selectDeptList");
    }

    /**
     * 入力_SELECT区分の取得
     * @return 入力_SELECT区分
     * @generated
     */
    public Integer getInSelectKbn() {
        return inSelectKbn;
    }

    /**
     * 入力_SELECT区分の設定
     * @param inSelectKbn 入力_SELECT区分
     * @generated
     */
    public void setInSelectKbn(Integer inSelectKbn) {
        this.inSelectKbn = inSelectKbn;
    }

    /**
     * 入力_施設固定コードの取得
     * @return 入力_施設固定コード
     * @generated
     */
    public String getInInsNo() {
        return inInsNo;
    }

    /**
     * 入力_施設固定コードの設定
     * @param inInsNo 入力_施設固定コード
     * @generated
     */
    public void setInInsNo(String inInsNo) {
        this.inInsNo = inInsNo;
    }

    /**
     * 入力_所属部科名カナの取得
     * @return 入力_所属部科名カナ
     * @generated
     */
    public String getInKanaName() {
        return inKanaName;
    }

    /**
     * 入力_所属部科名カナの設定
     * @param inKanaName 入力_所属部科名カナ
     * @generated
     */
    public void setInKanaName(String inKanaName) {
        this.inKanaName = inKanaName;
    }

    /**
     * 入力_所属部科名漢字の取得
     * @return 入力_所属部科名漢字
     * @generated
     */
    public String getInKanjName() {
        return inKanjName;
    }

    /**
     * 入力_所属部科名漢字の設定
     * @param inKanjName 入力_所属部科名漢字
     * @generated
     */
    public void setInKanjName(String inKanjName) {
        this.inKanjName = inKanjName;
    }

    /**
     * 所属部科コードの取得
     * @return 所属部科コード
     * @generated
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 所属部科コードの設定
     * @param deptCode 所属部科コード
     * @generated
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 所属部科名カナの取得
     * @return 所属部科名カナ
     * @generated
     */
    public String getKanaName() {
        return kanaName;
    }

    /**
     * 所属部科名カナの設定
     * @param kanaName 所属部科名カナ
     * @generated
     */
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * 所属部科名漢字の取得
     * @return 所属部科名漢字
     * @generated
     */
    public String getKanjName() {
        return kanjName;
    }

    /**
     * 所属部科名漢字の設定
     * @param kanjName 所属部科名漢字
     * @generated
     */
    public void setKanjName(String kanjName) {
        this.kanjName = kanjName;
    }

    /**
     * レコード件数の取得
     * @return レコード件数
     * @generated
     */
    public Integer getRecCnt() {
        return recCnt;
    }

    /**
     * レコード件数の設定
     * @param recCnt レコード件数
     * @generated
     */
    public void setRecCnt(Integer recCnt) {
        this.recCnt = recCnt;
    }

    /**
     * このEntityの値を返す
     * @return DTOの値
     * @generated
     */
    @Override
	public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
