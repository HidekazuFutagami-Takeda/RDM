/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * Entityクラス
 * テーブル物理名 : S_JKR_M_JGI_MST
 * テーブル論理名 : 提供用従業員基本
 * @generated
 */
public class SJkrMJgiMstEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 従業員番号 (PK)
     * @generated
     */
    private Integer jgiNo;

    /**
     * 氏名
     * @generated
     */
    private String jgiName;
    private boolean jgiNameNullFlag;

    /**
     * カナ氏名
     * @generated
     */
    private String jgiNameKana;
    private boolean jgiNameKanaNullFlag;

    /**
     * 性別Ｃ
     * @generated
     */
    private String sexCd;
    private boolean sexCdNullFlag;

    /**
     * 性別
     * @generated
     */
    private String sexName;
    private boolean sexNameNullFlag;

    /**
     * 雇用区分
     * @generated
     */
    private String koyouKb;
    private boolean koyouKbNullFlag;

    /**
     * 雇用区分名
     * @generated
     */
    private String koyouName;
    private boolean koyouNameNullFlag;

    /**
     * 入社年月日
     * @generated
     */
    private Date nyuusyaDay;
    private boolean nyuusyaDayNullFlag;

    /**
     * 生年月日
     * @generated
     */
    private Date birthDay;
    private boolean birthDayNullFlag;

    /**
     * 退職区分
     * @generated
     */
    private String taishokuKb;
    private boolean taishokuKbNullFlag;

    /**
     * 退職理由Ｃ
     * @generated
     */
    private String taishokuCd;
    private boolean taishokuCdNullFlag;

    /**
     * 退職理由
     * @generated
     */
    private String taishokuName;
    private boolean taishokuNameNullFlag;

    /**
     * 退職年月日
     * @generated
     */
    private Date taishokuDay;
    private boolean taishokuDayNullFlag;

    /**
     * 発令日
     * @generated
     */
    private Date hatureiDay;
    private boolean hatureiDayNullFlag;

    /**
     * 兼務区分 (PK)
     * @generated
     */
    private Integer kenmuKb;

    /**
     * 所属名正式
     * @generated
     */
    private String shozokuSeiName;
    private boolean shozokuSeiNameNullFlag;

    /**
     * 所属名略式
     * @generated
     */
    private String shozokuRyakuName;
    private boolean shozokuRyakuNameNullFlag;

    /**
     * 標準組織名
     * @generated
     */
    private String sosName;
    private boolean sosNameNullFlag;

    /**
     * 部門名正式１
     * @generated
     */
    private String bumonSeiName1;
    private boolean bumonSeiName1NullFlag;

    /**
     * 部門名正式２
     * @generated
     */
    private String bumonSeiName2;
    private boolean bumonSeiName2NullFlag;

    /**
     * 部門名正式３
     * @generated
     */
    private String bumonSeiName3;
    private boolean bumonSeiName3NullFlag;

    /**
     * 部門名正式４
     * @generated
     */
    private String bumonSeiName4;
    private boolean bumonSeiName4NullFlag;

    /**
     * 部門名正式５
     * @generated
     */
    private String bumonSeiName5;
    private boolean bumonSeiName5NullFlag;

    /**
     * 部門名正式６
     * @generated
     */
    private String bumonSeiName6;
    private boolean bumonSeiName6NullFlag;

    /**
     * 部門名略式１
     * @generated
     */
    private String bumonRyakuName1;
    private boolean bumonRyakuName1NullFlag;

    /**
     * 部門名略式２
     * @generated
     */
    private String bumonRyakuName2;
    private boolean bumonRyakuName2NullFlag;

    /**
     * 部門名略式３
     * @generated
     */
    private String bumonRyakuName3;
    private boolean bumonRyakuName3NullFlag;

    /**
     * 部門名略式４
     * @generated
     */
    private String bumonRyakuName4;
    private boolean bumonRyakuName4NullFlag;

    /**
     * 部門名略式５
     * @generated
     */
    private String bumonRyakuName5;
    private boolean bumonRyakuName5NullFlag;

    /**
     * 部門名略式６
     * @generated
     */
    private String bumonRyakuName6;
    private boolean bumonRyakuName6NullFlag;

    /**
     * 標準組織背番号Ｃ１
     * @generated
     */
    private String sosCd1;
    private boolean sosCd1NullFlag;

    /**
     * 標準組織背番号Ｃ２
     * @generated
     */
    private String sosCd2;
    private boolean sosCd2NullFlag;

    /**
     * 標準組織背番号Ｃ３
     * @generated
     */
    private String sosCd3;
    private boolean sosCd3NullFlag;

    /**
     * 標準組織背番号Ｃ４
     * @generated
     */
    private String sosCd4;
    private boolean sosCd4NullFlag;

    /**
     * 標準組織背番号Ｃ５
     * @generated
     */
    private String sosCd5;
    private boolean sosCd5NullFlag;

    /**
     * 標準組織背番号Ｃ６
     * @generated
     */
    private String sosCd6;
    private boolean sosCd6NullFlag;

    /**
     * ラインスタッフ区分
     * @generated
     */
    private String lineStaffKb;
    private boolean lineStaffKbNullFlag;

    /**
     * 職制名Ｃ
     * @generated
     */
    private String shokuseiCd;
    private boolean shokuseiCdNullFlag;

    /**
     * 職制名
     * @generated
     */
    private String shokuseiName;
    private boolean shokuseiNameNullFlag;

    /**
     * 出向先Ｃ
     * @generated
     */
    private String shukkouCd;
    private boolean shukkouCdNullFlag;

    /**
     * 出向先名
     * @generated
     */
    private String shukkouName;
    private boolean shukkouNameNullFlag;

    /**
     * 出向先担当名
     * @generated
     */
    private String shukkouTanName;
    private boolean shukkouTanNameNullFlag;

    /**
     * 勤務場所勤務状況名
     * @generated
     */
    private String kinmuBaJouName;
    private boolean kinmuBaJouNameNullFlag;

    /**
     * 労組区分
     * @generated
     */
    private String rousoKb;
    private boolean rousoKbNullFlag;

    /**
     * 勤務区分
     * @generated
     */
    private String kinmuKb;
    private boolean kinmuKbNullFlag;

    /**
     * 職種Ｃ
     * @generated
     */
    private String shokushuCd;
    private boolean shokushuCdNullFlag;

    /**
     * 職種名称
     * @generated
     */
    private String shokushuName;
    private boolean shokushuNameNullFlag;

    /**
     * 事業場Ｃ
     * @generated
     */
    private String jigyoJoCd;
    private boolean jigyoJoCdNullFlag;

    /**
     * 事業場名正式
     * @generated
     */
    private String jigyoJoSeiName;
    private boolean jigyoJoSeiNameNullFlag;

    /**
     * 事業場名略式
     * @generated
     */
    private String jigyoJoRyakuName;
    private boolean jigyoJoRyakuNameNullFlag;

    /**
     * 事業所＿海外勤務地Ｃ
     * @generated
     */
    private String kaigaiKinmuCd;
    private boolean kaigaiKinmuCdNullFlag;

    /**
     * 事業所＿海外勤務地名
     * @generated
     */
    private String kaigaiKinmuName;
    private boolean kaigaiKinmuNameNullFlag;

    /**
     * カンパニーＣ
     * @generated
     */
    private String companyCd;
    private boolean companyCdNullFlag;

    /**
     * カンパニー名
     * @generated
     */
    private String companyName;
    private boolean companyNameNullFlag;

    /**
     * 勤務地都道府県Ｃ
     * @generated
     */
    private String kinmuTdfknCd;
    private boolean kinmuTdfknCdNullFlag;

    /**
     * 勤務地都道府県名
     * @generated
     */
    private String kinmuTdfknName;
    private boolean kinmuTdfknNameNullFlag;

    /**
     * 勤務地市区郡町村Ｃ
     * @generated
     */
    private String kinmuScsnCd;
    private boolean kinmuScsnCdNullFlag;

    /**
     * 勤務地市区郡町村名
     * @generated
     */
    private String kinmuScsnName;
    private boolean kinmuScsnNameNullFlag;

    /**
     * 標準組織背番号Ｃ
     * @generated
     */
    private String sosCd;
    private boolean sosCdNullFlag;

    /**
     * 標準組織体系Ｃ
     * @generated
     */
    private String sosTaikeiCd;
    private boolean sosTaikeiCdNullFlag;

    /**
     * 世話標準組織体系Ｃ
     * @generated
     */
    private String sewaSosTaikeiCd;
    private boolean sewaSosTaikeiCdNullFlag;

    /**
     * 世話標準組織体系Ｃ補足
     * @generated
     */
    private String sewaSosTaikeiHosoku;
    private boolean sewaSosTaikeiHosokuNullFlag;

    /**
     * 世話標準組織背番号Ｃ
     * @generated
     */
    private String sewaSosCd;
    private boolean sewaSosCdNullFlag;

    /**
     * 旧従業員番号
     * @generated
     */
    private Integer oldJgiNo;
    private boolean oldJgiNoNullFlag;

    /**
     * 旧雇用区分
     * @generated
     */
    private String oldKoyouKb;
    private boolean oldKoyouKbNullFlag;

    /**
     * 旧雇用区分名
     * @generated
     */
    private String oldKoyouName;
    private boolean oldKoyouNameNullFlag;

    /**
     * 職位Ｃ
     * @generated
     */
    private String shokuiCd;
    private boolean shokuiCdNullFlag;

    /**
     * 職位名
     * @generated
     */
    private String shokuiName;
    private boolean shokuiNameNullFlag;

    /**
     * 部門ランク
     * @generated
     */
    private Integer bumonRank;
    private boolean bumonRankNullFlag;

    /**
     * 世話部門ランク
     * @generated
     */
    private Integer sewaBumonRank;
    private boolean sewaBumonRankNullFlag;

    /**
     * 基本情報更新日
     * @generated
     */
    private Date kihonUpDate;
    private boolean kihonUpDateNullFlag;

    /**
     * 所属更新日
     * @generated
     */
    private Date syozokuUpDate;
    private boolean syozokuUpDateNullFlag;

    /**
     * 従業員区分
     * @generated
     */
    private String jgiKb;
    private boolean jgiKbNullFlag;

    /**
     * コンストラクタ
     * @generated
     */
    public SJkrMJgiMstEntity() {
        super("s_jkr_m_jgi_mst");
    }

    /**
     * コンストラクタ
     * @param jgiNo 従業員番号
     * @param kenmuKb 兼務区分
     * @generated
     */
    public SJkrMJgiMstEntity(Integer jgiNo, Integer kenmuKb) {
        super("s_jkr_m_jgi_mst");
        this.jgiNo = jgiNo;
        this.kenmuKb = kenmuKb;
    }

    /**
     * 従業員番号の取得
     * @return 従業員番号
     * @generated
     */
    public Integer getJgiNo() {
        return this.jgiNo;
    }

    /**
     * 従業員番号の設定
     * @param jgiNo 従業員番号
     * @generated
     */
    public void setJgiNo(Integer jgiNo) {
        this.jgiNo = jgiNo;
    }

    /**
     * 氏名の取得
     * @return 氏名
     * @generated
     */
    public String getJgiName() {
        return this.jgiName;
    }

    /**
     * 氏名の設定
     * @param jgiName 氏名
     * @generated
     */
    public void setJgiName(String jgiName) {
        this.jgiName = jgiName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isJgiNameNullFlag() {
        return this.jgiNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param jgiNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setJgiNameNullFlag(boolean jgiNameNullFlag) {
        this.jgiNameNullFlag = jgiNameNullFlag;
    }
    
    /**
     * カナ氏名の取得
     * @return カナ氏名
     * @generated
     */
    public String getJgiNameKana() {
        return this.jgiNameKana;
    }

    /**
     * カナ氏名の設定
     * @param jgiNameKana カナ氏名
     * @generated
     */
    public void setJgiNameKana(String jgiNameKana) {
        this.jgiNameKana = jgiNameKana;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isJgiNameKanaNullFlag() {
        return this.jgiNameKanaNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param jgiNameKanaNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setJgiNameKanaNullFlag(boolean jgiNameKanaNullFlag) {
        this.jgiNameKanaNullFlag = jgiNameKanaNullFlag;
    }
    
    /**
     * 性別Ｃの取得
     * @return 性別Ｃ
     * @generated
     */
    public String getSexCd() {
        return this.sexCd;
    }

    /**
     * 性別Ｃの設定
     * @param sexCd 性別Ｃ
     * @generated
     */
    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSexCdNullFlag() {
        return this.sexCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sexCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSexCdNullFlag(boolean sexCdNullFlag) {
        this.sexCdNullFlag = sexCdNullFlag;
    }
    
    /**
     * 性別の取得
     * @return 性別
     * @generated
     */
    public String getSexName() {
        return this.sexName;
    }

    /**
     * 性別の設定
     * @param sexName 性別
     * @generated
     */
    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSexNameNullFlag() {
        return this.sexNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sexNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSexNameNullFlag(boolean sexNameNullFlag) {
        this.sexNameNullFlag = sexNameNullFlag;
    }
    
    /**
     * 雇用区分の取得
     * @return 雇用区分
     * @generated
     */
    public String getKoyouKb() {
        return this.koyouKb;
    }

    /**
     * 雇用区分の設定
     * @param koyouKb 雇用区分
     * @generated
     */
    public void setKoyouKb(String koyouKb) {
        this.koyouKb = koyouKb;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKoyouKbNullFlag() {
        return this.koyouKbNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param koyouKbNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKoyouKbNullFlag(boolean koyouKbNullFlag) {
        this.koyouKbNullFlag = koyouKbNullFlag;
    }
    
    /**
     * 雇用区分名の取得
     * @return 雇用区分名
     * @generated
     */
    public String getKoyouName() {
        return this.koyouName;
    }

    /**
     * 雇用区分名の設定
     * @param koyouName 雇用区分名
     * @generated
     */
    public void setKoyouName(String koyouName) {
        this.koyouName = koyouName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKoyouNameNullFlag() {
        return this.koyouNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param koyouNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKoyouNameNullFlag(boolean koyouNameNullFlag) {
        this.koyouNameNullFlag = koyouNameNullFlag;
    }
    
    /**
     * 入社年月日の取得
     * @return 入社年月日
     * @generated
     */
    public Date getNyuusyaDay() {
        return this.nyuusyaDay;
    }

    /**
     * 入社年月日の設定
     * @param nyuusyaDay 入社年月日
     * @generated
     */
    public void setNyuusyaDay(Date nyuusyaDay) {
        this.nyuusyaDay = nyuusyaDay;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isNyuusyaDayNullFlag() {
        return this.nyuusyaDayNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param nyuusyaDayNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setNyuusyaDayNullFlag(boolean nyuusyaDayNullFlag) {
        this.nyuusyaDayNullFlag = nyuusyaDayNullFlag;
    }
    
    /**
     * 生年月日の取得
     * @return 生年月日
     * @generated
     */
    public Date getBirthDay() {
        return this.birthDay;
    }

    /**
     * 生年月日の設定
     * @param birthDay 生年月日
     * @generated
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBirthDayNullFlag() {
        return this.birthDayNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param birthDayNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBirthDayNullFlag(boolean birthDayNullFlag) {
        this.birthDayNullFlag = birthDayNullFlag;
    }
    
    /**
     * 退職区分の取得
     * @return 退職区分
     * @generated
     */
    public String getTaishokuKb() {
        return this.taishokuKb;
    }

    /**
     * 退職区分の設定
     * @param taishokuKb 退職区分
     * @generated
     */
    public void setTaishokuKb(String taishokuKb) {
        this.taishokuKb = taishokuKb;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isTaishokuKbNullFlag() {
        return this.taishokuKbNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param taishokuKbNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setTaishokuKbNullFlag(boolean taishokuKbNullFlag) {
        this.taishokuKbNullFlag = taishokuKbNullFlag;
    }
    
    /**
     * 退職理由Ｃの取得
     * @return 退職理由Ｃ
     * @generated
     */
    public String getTaishokuCd() {
        return this.taishokuCd;
    }

    /**
     * 退職理由Ｃの設定
     * @param taishokuCd 退職理由Ｃ
     * @generated
     */
    public void setTaishokuCd(String taishokuCd) {
        this.taishokuCd = taishokuCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isTaishokuCdNullFlag() {
        return this.taishokuCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param taishokuCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setTaishokuCdNullFlag(boolean taishokuCdNullFlag) {
        this.taishokuCdNullFlag = taishokuCdNullFlag;
    }
    
    /**
     * 退職理由の取得
     * @return 退職理由
     * @generated
     */
    public String getTaishokuName() {
        return this.taishokuName;
    }

    /**
     * 退職理由の設定
     * @param taishokuName 退職理由
     * @generated
     */
    public void setTaishokuName(String taishokuName) {
        this.taishokuName = taishokuName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isTaishokuNameNullFlag() {
        return this.taishokuNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param taishokuNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setTaishokuNameNullFlag(boolean taishokuNameNullFlag) {
        this.taishokuNameNullFlag = taishokuNameNullFlag;
    }
    
    /**
     * 退職年月日の取得
     * @return 退職年月日
     * @generated
     */
    public Date getTaishokuDay() {
        return this.taishokuDay;
    }

    /**
     * 退職年月日の設定
     * @param taishokuDay 退職年月日
     * @generated
     */
    public void setTaishokuDay(Date taishokuDay) {
        this.taishokuDay = taishokuDay;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isTaishokuDayNullFlag() {
        return this.taishokuDayNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param taishokuDayNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setTaishokuDayNullFlag(boolean taishokuDayNullFlag) {
        this.taishokuDayNullFlag = taishokuDayNullFlag;
    }
    
    /**
     * 発令日の取得
     * @return 発令日
     * @generated
     */
    public Date getHatureiDay() {
        return this.hatureiDay;
    }

    /**
     * 発令日の設定
     * @param hatureiDay 発令日
     * @generated
     */
    public void setHatureiDay(Date hatureiDay) {
        this.hatureiDay = hatureiDay;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isHatureiDayNullFlag() {
        return this.hatureiDayNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param hatureiDayNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setHatureiDayNullFlag(boolean hatureiDayNullFlag) {
        this.hatureiDayNullFlag = hatureiDayNullFlag;
    }
    
    /**
     * 兼務区分の取得
     * @return 兼務区分
     * @generated
     */
    public Integer getKenmuKb() {
        return this.kenmuKb;
    }

    /**
     * 兼務区分の設定
     * @param kenmuKb 兼務区分
     * @generated
     */
    public void setKenmuKb(Integer kenmuKb) {
        this.kenmuKb = kenmuKb;
    }

    /**
     * 所属名正式の取得
     * @return 所属名正式
     * @generated
     */
    public String getShozokuSeiName() {
        return this.shozokuSeiName;
    }

    /**
     * 所属名正式の設定
     * @param shozokuSeiName 所属名正式
     * @generated
     */
    public void setShozokuSeiName(String shozokuSeiName) {
        this.shozokuSeiName = shozokuSeiName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShozokuSeiNameNullFlag() {
        return this.shozokuSeiNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shozokuSeiNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShozokuSeiNameNullFlag(boolean shozokuSeiNameNullFlag) {
        this.shozokuSeiNameNullFlag = shozokuSeiNameNullFlag;
    }
    
    /**
     * 所属名略式の取得
     * @return 所属名略式
     * @generated
     */
    public String getShozokuRyakuName() {
        return this.shozokuRyakuName;
    }

    /**
     * 所属名略式の設定
     * @param shozokuRyakuName 所属名略式
     * @generated
     */
    public void setShozokuRyakuName(String shozokuRyakuName) {
        this.shozokuRyakuName = shozokuRyakuName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShozokuRyakuNameNullFlag() {
        return this.shozokuRyakuNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shozokuRyakuNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShozokuRyakuNameNullFlag(boolean shozokuRyakuNameNullFlag) {
        this.shozokuRyakuNameNullFlag = shozokuRyakuNameNullFlag;
    }
    
    /**
     * 標準組織名の取得
     * @return 標準組織名
     * @generated
     */
    public String getSosName() {
        return this.sosName;
    }

    /**
     * 標準組織名の設定
     * @param sosName 標準組織名
     * @generated
     */
    public void setSosName(String sosName) {
        this.sosName = sosName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosNameNullFlag() {
        return this.sosNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosNameNullFlag(boolean sosNameNullFlag) {
        this.sosNameNullFlag = sosNameNullFlag;
    }
    
    /**
     * 部門名正式１の取得
     * @return 部門名正式１
     * @generated
     */
    public String getBumonSeiName1() {
        return this.bumonSeiName1;
    }

    /**
     * 部門名正式１の設定
     * @param bumonSeiName1 部門名正式１
     * @generated
     */
    public void setBumonSeiName1(String bumonSeiName1) {
        this.bumonSeiName1 = bumonSeiName1;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonSeiName1NullFlag() {
        return this.bumonSeiName1NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonSeiName1NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonSeiName1NullFlag(boolean bumonSeiName1NullFlag) {
        this.bumonSeiName1NullFlag = bumonSeiName1NullFlag;
    }
    
    /**
     * 部門名正式２の取得
     * @return 部門名正式２
     * @generated
     */
    public String getBumonSeiName2() {
        return this.bumonSeiName2;
    }

    /**
     * 部門名正式２の設定
     * @param bumonSeiName2 部門名正式２
     * @generated
     */
    public void setBumonSeiName2(String bumonSeiName2) {
        this.bumonSeiName2 = bumonSeiName2;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonSeiName2NullFlag() {
        return this.bumonSeiName2NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonSeiName2NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonSeiName2NullFlag(boolean bumonSeiName2NullFlag) {
        this.bumonSeiName2NullFlag = bumonSeiName2NullFlag;
    }
    
    /**
     * 部門名正式３の取得
     * @return 部門名正式３
     * @generated
     */
    public String getBumonSeiName3() {
        return this.bumonSeiName3;
    }

    /**
     * 部門名正式３の設定
     * @param bumonSeiName3 部門名正式３
     * @generated
     */
    public void setBumonSeiName3(String bumonSeiName3) {
        this.bumonSeiName3 = bumonSeiName3;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonSeiName3NullFlag() {
        return this.bumonSeiName3NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonSeiName3NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonSeiName3NullFlag(boolean bumonSeiName3NullFlag) {
        this.bumonSeiName3NullFlag = bumonSeiName3NullFlag;
    }
    
    /**
     * 部門名正式４の取得
     * @return 部門名正式４
     * @generated
     */
    public String getBumonSeiName4() {
        return this.bumonSeiName4;
    }

    /**
     * 部門名正式４の設定
     * @param bumonSeiName4 部門名正式４
     * @generated
     */
    public void setBumonSeiName4(String bumonSeiName4) {
        this.bumonSeiName4 = bumonSeiName4;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonSeiName4NullFlag() {
        return this.bumonSeiName4NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonSeiName4NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonSeiName4NullFlag(boolean bumonSeiName4NullFlag) {
        this.bumonSeiName4NullFlag = bumonSeiName4NullFlag;
    }
    
    /**
     * 部門名正式５の取得
     * @return 部門名正式５
     * @generated
     */
    public String getBumonSeiName5() {
        return this.bumonSeiName5;
    }

    /**
     * 部門名正式５の設定
     * @param bumonSeiName5 部門名正式５
     * @generated
     */
    public void setBumonSeiName5(String bumonSeiName5) {
        this.bumonSeiName5 = bumonSeiName5;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonSeiName5NullFlag() {
        return this.bumonSeiName5NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonSeiName5NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonSeiName5NullFlag(boolean bumonSeiName5NullFlag) {
        this.bumonSeiName5NullFlag = bumonSeiName5NullFlag;
    }
    
    /**
     * 部門名正式６の取得
     * @return 部門名正式６
     * @generated
     */
    public String getBumonSeiName6() {
        return this.bumonSeiName6;
    }

    /**
     * 部門名正式６の設定
     * @param bumonSeiName6 部門名正式６
     * @generated
     */
    public void setBumonSeiName6(String bumonSeiName6) {
        this.bumonSeiName6 = bumonSeiName6;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonSeiName6NullFlag() {
        return this.bumonSeiName6NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonSeiName6NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonSeiName6NullFlag(boolean bumonSeiName6NullFlag) {
        this.bumonSeiName6NullFlag = bumonSeiName6NullFlag;
    }
    
    /**
     * 部門名略式１の取得
     * @return 部門名略式１
     * @generated
     */
    public String getBumonRyakuName1() {
        return this.bumonRyakuName1;
    }

    /**
     * 部門名略式１の設定
     * @param bumonRyakuName1 部門名略式１
     * @generated
     */
    public void setBumonRyakuName1(String bumonRyakuName1) {
        this.bumonRyakuName1 = bumonRyakuName1;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonRyakuName1NullFlag() {
        return this.bumonRyakuName1NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonRyakuName1NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonRyakuName1NullFlag(boolean bumonRyakuName1NullFlag) {
        this.bumonRyakuName1NullFlag = bumonRyakuName1NullFlag;
    }
    
    /**
     * 部門名略式２の取得
     * @return 部門名略式２
     * @generated
     */
    public String getBumonRyakuName2() {
        return this.bumonRyakuName2;
    }

    /**
     * 部門名略式２の設定
     * @param bumonRyakuName2 部門名略式２
     * @generated
     */
    public void setBumonRyakuName2(String bumonRyakuName2) {
        this.bumonRyakuName2 = bumonRyakuName2;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonRyakuName2NullFlag() {
        return this.bumonRyakuName2NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonRyakuName2NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonRyakuName2NullFlag(boolean bumonRyakuName2NullFlag) {
        this.bumonRyakuName2NullFlag = bumonRyakuName2NullFlag;
    }
    
    /**
     * 部門名略式３の取得
     * @return 部門名略式３
     * @generated
     */
    public String getBumonRyakuName3() {
        return this.bumonRyakuName3;
    }

    /**
     * 部門名略式３の設定
     * @param bumonRyakuName3 部門名略式３
     * @generated
     */
    public void setBumonRyakuName3(String bumonRyakuName3) {
        this.bumonRyakuName3 = bumonRyakuName3;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonRyakuName3NullFlag() {
        return this.bumonRyakuName3NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonRyakuName3NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonRyakuName3NullFlag(boolean bumonRyakuName3NullFlag) {
        this.bumonRyakuName3NullFlag = bumonRyakuName3NullFlag;
    }
    
    /**
     * 部門名略式４の取得
     * @return 部門名略式４
     * @generated
     */
    public String getBumonRyakuName4() {
        return this.bumonRyakuName4;
    }

    /**
     * 部門名略式４の設定
     * @param bumonRyakuName4 部門名略式４
     * @generated
     */
    public void setBumonRyakuName4(String bumonRyakuName4) {
        this.bumonRyakuName4 = bumonRyakuName4;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonRyakuName4NullFlag() {
        return this.bumonRyakuName4NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonRyakuName4NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonRyakuName4NullFlag(boolean bumonRyakuName4NullFlag) {
        this.bumonRyakuName4NullFlag = bumonRyakuName4NullFlag;
    }
    
    /**
     * 部門名略式５の取得
     * @return 部門名略式５
     * @generated
     */
    public String getBumonRyakuName5() {
        return this.bumonRyakuName5;
    }

    /**
     * 部門名略式５の設定
     * @param bumonRyakuName5 部門名略式５
     * @generated
     */
    public void setBumonRyakuName5(String bumonRyakuName5) {
        this.bumonRyakuName5 = bumonRyakuName5;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonRyakuName5NullFlag() {
        return this.bumonRyakuName5NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonRyakuName5NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonRyakuName5NullFlag(boolean bumonRyakuName5NullFlag) {
        this.bumonRyakuName5NullFlag = bumonRyakuName5NullFlag;
    }
    
    /**
     * 部門名略式６の取得
     * @return 部門名略式６
     * @generated
     */
    public String getBumonRyakuName6() {
        return this.bumonRyakuName6;
    }

    /**
     * 部門名略式６の設定
     * @param bumonRyakuName6 部門名略式６
     * @generated
     */
    public void setBumonRyakuName6(String bumonRyakuName6) {
        this.bumonRyakuName6 = bumonRyakuName6;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonRyakuName6NullFlag() {
        return this.bumonRyakuName6NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonRyakuName6NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonRyakuName6NullFlag(boolean bumonRyakuName6NullFlag) {
        this.bumonRyakuName6NullFlag = bumonRyakuName6NullFlag;
    }
    
    /**
     * 標準組織背番号Ｃ１の取得
     * @return 標準組織背番号Ｃ１
     * @generated
     */
    public String getSosCd1() {
        return this.sosCd1;
    }

    /**
     * 標準組織背番号Ｃ１の設定
     * @param sosCd1 標準組織背番号Ｃ１
     * @generated
     */
    public void setSosCd1(String sosCd1) {
        this.sosCd1 = sosCd1;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosCd1NullFlag() {
        return this.sosCd1NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosCd1NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosCd1NullFlag(boolean sosCd1NullFlag) {
        this.sosCd1NullFlag = sosCd1NullFlag;
    }
    
    /**
     * 標準組織背番号Ｃ２の取得
     * @return 標準組織背番号Ｃ２
     * @generated
     */
    public String getSosCd2() {
        return this.sosCd2;
    }

    /**
     * 標準組織背番号Ｃ２の設定
     * @param sosCd2 標準組織背番号Ｃ２
     * @generated
     */
    public void setSosCd2(String sosCd2) {
        this.sosCd2 = sosCd2;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosCd2NullFlag() {
        return this.sosCd2NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosCd2NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosCd2NullFlag(boolean sosCd2NullFlag) {
        this.sosCd2NullFlag = sosCd2NullFlag;
    }
    
    /**
     * 標準組織背番号Ｃ３の取得
     * @return 標準組織背番号Ｃ３
     * @generated
     */
    public String getSosCd3() {
        return this.sosCd3;
    }

    /**
     * 標準組織背番号Ｃ３の設定
     * @param sosCd3 標準組織背番号Ｃ３
     * @generated
     */
    public void setSosCd3(String sosCd3) {
        this.sosCd3 = sosCd3;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosCd3NullFlag() {
        return this.sosCd3NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosCd3NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosCd3NullFlag(boolean sosCd3NullFlag) {
        this.sosCd3NullFlag = sosCd3NullFlag;
    }
    
    /**
     * 標準組織背番号Ｃ４の取得
     * @return 標準組織背番号Ｃ４
     * @generated
     */
    public String getSosCd4() {
        return this.sosCd4;
    }

    /**
     * 標準組織背番号Ｃ４の設定
     * @param sosCd4 標準組織背番号Ｃ４
     * @generated
     */
    public void setSosCd4(String sosCd4) {
        this.sosCd4 = sosCd4;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosCd4NullFlag() {
        return this.sosCd4NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosCd4NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosCd4NullFlag(boolean sosCd4NullFlag) {
        this.sosCd4NullFlag = sosCd4NullFlag;
    }
    
    /**
     * 標準組織背番号Ｃ５の取得
     * @return 標準組織背番号Ｃ５
     * @generated
     */
    public String getSosCd5() {
        return this.sosCd5;
    }

    /**
     * 標準組織背番号Ｃ５の設定
     * @param sosCd5 標準組織背番号Ｃ５
     * @generated
     */
    public void setSosCd5(String sosCd5) {
        this.sosCd5 = sosCd5;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosCd5NullFlag() {
        return this.sosCd5NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosCd5NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosCd5NullFlag(boolean sosCd5NullFlag) {
        this.sosCd5NullFlag = sosCd5NullFlag;
    }
    
    /**
     * 標準組織背番号Ｃ６の取得
     * @return 標準組織背番号Ｃ６
     * @generated
     */
    public String getSosCd6() {
        return this.sosCd6;
    }

    /**
     * 標準組織背番号Ｃ６の設定
     * @param sosCd6 標準組織背番号Ｃ６
     * @generated
     */
    public void setSosCd6(String sosCd6) {
        this.sosCd6 = sosCd6;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosCd6NullFlag() {
        return this.sosCd6NullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosCd6NullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosCd6NullFlag(boolean sosCd6NullFlag) {
        this.sosCd6NullFlag = sosCd6NullFlag;
    }
    
    /**
     * ラインスタッフ区分の取得
     * @return ラインスタッフ区分
     * @generated
     */
    public String getLineStaffKb() {
        return this.lineStaffKb;
    }

    /**
     * ラインスタッフ区分の設定
     * @param lineStaffKb ラインスタッフ区分
     * @generated
     */
    public void setLineStaffKb(String lineStaffKb) {
        this.lineStaffKb = lineStaffKb;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isLineStaffKbNullFlag() {
        return this.lineStaffKbNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param lineStaffKbNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setLineStaffKbNullFlag(boolean lineStaffKbNullFlag) {
        this.lineStaffKbNullFlag = lineStaffKbNullFlag;
    }
    
    /**
     * 職制名Ｃの取得
     * @return 職制名Ｃ
     * @generated
     */
    public String getShokuseiCd() {
        return this.shokuseiCd;
    }

    /**
     * 職制名Ｃの設定
     * @param shokuseiCd 職制名Ｃ
     * @generated
     */
    public void setShokuseiCd(String shokuseiCd) {
        this.shokuseiCd = shokuseiCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShokuseiCdNullFlag() {
        return this.shokuseiCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shokuseiCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShokuseiCdNullFlag(boolean shokuseiCdNullFlag) {
        this.shokuseiCdNullFlag = shokuseiCdNullFlag;
    }
    
    /**
     * 職制名の取得
     * @return 職制名
     * @generated
     */
    public String getShokuseiName() {
        return this.shokuseiName;
    }

    /**
     * 職制名の設定
     * @param shokuseiName 職制名
     * @generated
     */
    public void setShokuseiName(String shokuseiName) {
        this.shokuseiName = shokuseiName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShokuseiNameNullFlag() {
        return this.shokuseiNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shokuseiNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShokuseiNameNullFlag(boolean shokuseiNameNullFlag) {
        this.shokuseiNameNullFlag = shokuseiNameNullFlag;
    }
    
    /**
     * 出向先Ｃの取得
     * @return 出向先Ｃ
     * @generated
     */
    public String getShukkouCd() {
        return this.shukkouCd;
    }

    /**
     * 出向先Ｃの設定
     * @param shukkouCd 出向先Ｃ
     * @generated
     */
    public void setShukkouCd(String shukkouCd) {
        this.shukkouCd = shukkouCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShukkouCdNullFlag() {
        return this.shukkouCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shukkouCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShukkouCdNullFlag(boolean shukkouCdNullFlag) {
        this.shukkouCdNullFlag = shukkouCdNullFlag;
    }
    
    /**
     * 出向先名の取得
     * @return 出向先名
     * @generated
     */
    public String getShukkouName() {
        return this.shukkouName;
    }

    /**
     * 出向先名の設定
     * @param shukkouName 出向先名
     * @generated
     */
    public void setShukkouName(String shukkouName) {
        this.shukkouName = shukkouName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShukkouNameNullFlag() {
        return this.shukkouNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shukkouNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShukkouNameNullFlag(boolean shukkouNameNullFlag) {
        this.shukkouNameNullFlag = shukkouNameNullFlag;
    }
    
    /**
     * 出向先担当名の取得
     * @return 出向先担当名
     * @generated
     */
    public String getShukkouTanName() {
        return this.shukkouTanName;
    }

    /**
     * 出向先担当名の設定
     * @param shukkouTanName 出向先担当名
     * @generated
     */
    public void setShukkouTanName(String shukkouTanName) {
        this.shukkouTanName = shukkouTanName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShukkouTanNameNullFlag() {
        return this.shukkouTanNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shukkouTanNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShukkouTanNameNullFlag(boolean shukkouTanNameNullFlag) {
        this.shukkouTanNameNullFlag = shukkouTanNameNullFlag;
    }
    
    /**
     * 勤務場所勤務状況名の取得
     * @return 勤務場所勤務状況名
     * @generated
     */
    public String getKinmuBaJouName() {
        return this.kinmuBaJouName;
    }

    /**
     * 勤務場所勤務状況名の設定
     * @param kinmuBaJouName 勤務場所勤務状況名
     * @generated
     */
    public void setKinmuBaJouName(String kinmuBaJouName) {
        this.kinmuBaJouName = kinmuBaJouName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKinmuBaJouNameNullFlag() {
        return this.kinmuBaJouNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kinmuBaJouNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKinmuBaJouNameNullFlag(boolean kinmuBaJouNameNullFlag) {
        this.kinmuBaJouNameNullFlag = kinmuBaJouNameNullFlag;
    }
    
    /**
     * 労組区分の取得
     * @return 労組区分
     * @generated
     */
    public String getRousoKb() {
        return this.rousoKb;
    }

    /**
     * 労組区分の設定
     * @param rousoKb 労組区分
     * @generated
     */
    public void setRousoKb(String rousoKb) {
        this.rousoKb = rousoKb;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isRousoKbNullFlag() {
        return this.rousoKbNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param rousoKbNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setRousoKbNullFlag(boolean rousoKbNullFlag) {
        this.rousoKbNullFlag = rousoKbNullFlag;
    }
    
    /**
     * 勤務区分の取得
     * @return 勤務区分
     * @generated
     */
    public String getKinmuKb() {
        return this.kinmuKb;
    }

    /**
     * 勤務区分の設定
     * @param kinmuKb 勤務区分
     * @generated
     */
    public void setKinmuKb(String kinmuKb) {
        this.kinmuKb = kinmuKb;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKinmuKbNullFlag() {
        return this.kinmuKbNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kinmuKbNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKinmuKbNullFlag(boolean kinmuKbNullFlag) {
        this.kinmuKbNullFlag = kinmuKbNullFlag;
    }
    
    /**
     * 職種Ｃの取得
     * @return 職種Ｃ
     * @generated
     */
    public String getShokushuCd() {
        return this.shokushuCd;
    }

    /**
     * 職種Ｃの設定
     * @param shokushuCd 職種Ｃ
     * @generated
     */
    public void setShokushuCd(String shokushuCd) {
        this.shokushuCd = shokushuCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShokushuCdNullFlag() {
        return this.shokushuCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shokushuCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShokushuCdNullFlag(boolean shokushuCdNullFlag) {
        this.shokushuCdNullFlag = shokushuCdNullFlag;
    }
    
    /**
     * 職種名称の取得
     * @return 職種名称
     * @generated
     */
    public String getShokushuName() {
        return this.shokushuName;
    }

    /**
     * 職種名称の設定
     * @param shokushuName 職種名称
     * @generated
     */
    public void setShokushuName(String shokushuName) {
        this.shokushuName = shokushuName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShokushuNameNullFlag() {
        return this.shokushuNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shokushuNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShokushuNameNullFlag(boolean shokushuNameNullFlag) {
        this.shokushuNameNullFlag = shokushuNameNullFlag;
    }
    
    /**
     * 事業場Ｃの取得
     * @return 事業場Ｃ
     * @generated
     */
    public String getJigyoJoCd() {
        return this.jigyoJoCd;
    }

    /**
     * 事業場Ｃの設定
     * @param jigyoJoCd 事業場Ｃ
     * @generated
     */
    public void setJigyoJoCd(String jigyoJoCd) {
        this.jigyoJoCd = jigyoJoCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isJigyoJoCdNullFlag() {
        return this.jigyoJoCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param jigyoJoCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setJigyoJoCdNullFlag(boolean jigyoJoCdNullFlag) {
        this.jigyoJoCdNullFlag = jigyoJoCdNullFlag;
    }
    
    /**
     * 事業場名正式の取得
     * @return 事業場名正式
     * @generated
     */
    public String getJigyoJoSeiName() {
        return this.jigyoJoSeiName;
    }

    /**
     * 事業場名正式の設定
     * @param jigyoJoSeiName 事業場名正式
     * @generated
     */
    public void setJigyoJoSeiName(String jigyoJoSeiName) {
        this.jigyoJoSeiName = jigyoJoSeiName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isJigyoJoSeiNameNullFlag() {
        return this.jigyoJoSeiNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param jigyoJoSeiNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setJigyoJoSeiNameNullFlag(boolean jigyoJoSeiNameNullFlag) {
        this.jigyoJoSeiNameNullFlag = jigyoJoSeiNameNullFlag;
    }
    
    /**
     * 事業場名略式の取得
     * @return 事業場名略式
     * @generated
     */
    public String getJigyoJoRyakuName() {
        return this.jigyoJoRyakuName;
    }

    /**
     * 事業場名略式の設定
     * @param jigyoJoRyakuName 事業場名略式
     * @generated
     */
    public void setJigyoJoRyakuName(String jigyoJoRyakuName) {
        this.jigyoJoRyakuName = jigyoJoRyakuName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isJigyoJoRyakuNameNullFlag() {
        return this.jigyoJoRyakuNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param jigyoJoRyakuNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setJigyoJoRyakuNameNullFlag(boolean jigyoJoRyakuNameNullFlag) {
        this.jigyoJoRyakuNameNullFlag = jigyoJoRyakuNameNullFlag;
    }
    
    /**
     * 事業所＿海外勤務地Ｃの取得
     * @return 事業所＿海外勤務地Ｃ
     * @generated
     */
    public String getKaigaiKinmuCd() {
        return this.kaigaiKinmuCd;
    }

    /**
     * 事業所＿海外勤務地Ｃの設定
     * @param kaigaiKinmuCd 事業所＿海外勤務地Ｃ
     * @generated
     */
    public void setKaigaiKinmuCd(String kaigaiKinmuCd) {
        this.kaigaiKinmuCd = kaigaiKinmuCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKaigaiKinmuCdNullFlag() {
        return this.kaigaiKinmuCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kaigaiKinmuCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKaigaiKinmuCdNullFlag(boolean kaigaiKinmuCdNullFlag) {
        this.kaigaiKinmuCdNullFlag = kaigaiKinmuCdNullFlag;
    }
    
    /**
     * 事業所＿海外勤務地名の取得
     * @return 事業所＿海外勤務地名
     * @generated
     */
    public String getKaigaiKinmuName() {
        return this.kaigaiKinmuName;
    }

    /**
     * 事業所＿海外勤務地名の設定
     * @param kaigaiKinmuName 事業所＿海外勤務地名
     * @generated
     */
    public void setKaigaiKinmuName(String kaigaiKinmuName) {
        this.kaigaiKinmuName = kaigaiKinmuName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKaigaiKinmuNameNullFlag() {
        return this.kaigaiKinmuNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kaigaiKinmuNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKaigaiKinmuNameNullFlag(boolean kaigaiKinmuNameNullFlag) {
        this.kaigaiKinmuNameNullFlag = kaigaiKinmuNameNullFlag;
    }
    
    /**
     * カンパニーＣの取得
     * @return カンパニーＣ
     * @generated
     */
    public String getCompanyCd() {
        return this.companyCd;
    }

    /**
     * カンパニーＣの設定
     * @param companyCd カンパニーＣ
     * @generated
     */
    public void setCompanyCd(String companyCd) {
        this.companyCd = companyCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isCompanyCdNullFlag() {
        return this.companyCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param companyCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setCompanyCdNullFlag(boolean companyCdNullFlag) {
        this.companyCdNullFlag = companyCdNullFlag;
    }
    
    /**
     * カンパニー名の取得
     * @return カンパニー名
     * @generated
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * カンパニー名の設定
     * @param companyName カンパニー名
     * @generated
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isCompanyNameNullFlag() {
        return this.companyNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param companyNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setCompanyNameNullFlag(boolean companyNameNullFlag) {
        this.companyNameNullFlag = companyNameNullFlag;
    }
    
    /**
     * 勤務地都道府県Ｃの取得
     * @return 勤務地都道府県Ｃ
     * @generated
     */
    public String getKinmuTdfknCd() {
        return this.kinmuTdfknCd;
    }

    /**
     * 勤務地都道府県Ｃの設定
     * @param kinmuTdfknCd 勤務地都道府県Ｃ
     * @generated
     */
    public void setKinmuTdfknCd(String kinmuTdfknCd) {
        this.kinmuTdfknCd = kinmuTdfknCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKinmuTdfknCdNullFlag() {
        return this.kinmuTdfknCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kinmuTdfknCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKinmuTdfknCdNullFlag(boolean kinmuTdfknCdNullFlag) {
        this.kinmuTdfknCdNullFlag = kinmuTdfknCdNullFlag;
    }
    
    /**
     * 勤務地都道府県名の取得
     * @return 勤務地都道府県名
     * @generated
     */
    public String getKinmuTdfknName() {
        return this.kinmuTdfknName;
    }

    /**
     * 勤務地都道府県名の設定
     * @param kinmuTdfknName 勤務地都道府県名
     * @generated
     */
    public void setKinmuTdfknName(String kinmuTdfknName) {
        this.kinmuTdfknName = kinmuTdfknName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKinmuTdfknNameNullFlag() {
        return this.kinmuTdfknNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kinmuTdfknNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKinmuTdfknNameNullFlag(boolean kinmuTdfknNameNullFlag) {
        this.kinmuTdfknNameNullFlag = kinmuTdfknNameNullFlag;
    }
    
    /**
     * 勤務地市区郡町村Ｃの取得
     * @return 勤務地市区郡町村Ｃ
     * @generated
     */
    public String getKinmuScsnCd() {
        return this.kinmuScsnCd;
    }

    /**
     * 勤務地市区郡町村Ｃの設定
     * @param kinmuScsnCd 勤務地市区郡町村Ｃ
     * @generated
     */
    public void setKinmuScsnCd(String kinmuScsnCd) {
        this.kinmuScsnCd = kinmuScsnCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKinmuScsnCdNullFlag() {
        return this.kinmuScsnCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kinmuScsnCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKinmuScsnCdNullFlag(boolean kinmuScsnCdNullFlag) {
        this.kinmuScsnCdNullFlag = kinmuScsnCdNullFlag;
    }
    
    /**
     * 勤務地市区郡町村名の取得
     * @return 勤務地市区郡町村名
     * @generated
     */
    public String getKinmuScsnName() {
        return this.kinmuScsnName;
    }

    /**
     * 勤務地市区郡町村名の設定
     * @param kinmuScsnName 勤務地市区郡町村名
     * @generated
     */
    public void setKinmuScsnName(String kinmuScsnName) {
        this.kinmuScsnName = kinmuScsnName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKinmuScsnNameNullFlag() {
        return this.kinmuScsnNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kinmuScsnNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKinmuScsnNameNullFlag(boolean kinmuScsnNameNullFlag) {
        this.kinmuScsnNameNullFlag = kinmuScsnNameNullFlag;
    }
    
    /**
     * 標準組織背番号Ｃの取得
     * @return 標準組織背番号Ｃ
     * @generated
     */
    public String getSosCd() {
        return this.sosCd;
    }

    /**
     * 標準組織背番号Ｃの設定
     * @param sosCd 標準組織背番号Ｃ
     * @generated
     */
    public void setSosCd(String sosCd) {
        this.sosCd = sosCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosCdNullFlag() {
        return this.sosCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosCdNullFlag(boolean sosCdNullFlag) {
        this.sosCdNullFlag = sosCdNullFlag;
    }
    
    /**
     * 標準組織体系Ｃの取得
     * @return 標準組織体系Ｃ
     * @generated
     */
    public String getSosTaikeiCd() {
        return this.sosTaikeiCd;
    }

    /**
     * 標準組織体系Ｃの設定
     * @param sosTaikeiCd 標準組織体系Ｃ
     * @generated
     */
    public void setSosTaikeiCd(String sosTaikeiCd) {
        this.sosTaikeiCd = sosTaikeiCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSosTaikeiCdNullFlag() {
        return this.sosTaikeiCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sosTaikeiCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSosTaikeiCdNullFlag(boolean sosTaikeiCdNullFlag) {
        this.sosTaikeiCdNullFlag = sosTaikeiCdNullFlag;
    }
    
    /**
     * 世話標準組織体系Ｃの取得
     * @return 世話標準組織体系Ｃ
     * @generated
     */
    public String getSewaSosTaikeiCd() {
        return this.sewaSosTaikeiCd;
    }

    /**
     * 世話標準組織体系Ｃの設定
     * @param sewaSosTaikeiCd 世話標準組織体系Ｃ
     * @generated
     */
    public void setSewaSosTaikeiCd(String sewaSosTaikeiCd) {
        this.sewaSosTaikeiCd = sewaSosTaikeiCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSewaSosTaikeiCdNullFlag() {
        return this.sewaSosTaikeiCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sewaSosTaikeiCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSewaSosTaikeiCdNullFlag(boolean sewaSosTaikeiCdNullFlag) {
        this.sewaSosTaikeiCdNullFlag = sewaSosTaikeiCdNullFlag;
    }
    
    /**
     * 世話標準組織体系Ｃ補足の取得
     * @return 世話標準組織体系Ｃ補足
     * @generated
     */
    public String getSewaSosTaikeiHosoku() {
        return this.sewaSosTaikeiHosoku;
    }

    /**
     * 世話標準組織体系Ｃ補足の設定
     * @param sewaSosTaikeiHosoku 世話標準組織体系Ｃ補足
     * @generated
     */
    public void setSewaSosTaikeiHosoku(String sewaSosTaikeiHosoku) {
        this.sewaSosTaikeiHosoku = sewaSosTaikeiHosoku;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSewaSosTaikeiHosokuNullFlag() {
        return this.sewaSosTaikeiHosokuNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sewaSosTaikeiHosokuNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSewaSosTaikeiHosokuNullFlag(boolean sewaSosTaikeiHosokuNullFlag) {
        this.sewaSosTaikeiHosokuNullFlag = sewaSosTaikeiHosokuNullFlag;
    }
    
    /**
     * 世話標準組織背番号Ｃの取得
     * @return 世話標準組織背番号Ｃ
     * @generated
     */
    public String getSewaSosCd() {
        return this.sewaSosCd;
    }

    /**
     * 世話標準組織背番号Ｃの設定
     * @param sewaSosCd 世話標準組織背番号Ｃ
     * @generated
     */
    public void setSewaSosCd(String sewaSosCd) {
        this.sewaSosCd = sewaSosCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSewaSosCdNullFlag() {
        return this.sewaSosCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sewaSosCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSewaSosCdNullFlag(boolean sewaSosCdNullFlag) {
        this.sewaSosCdNullFlag = sewaSosCdNullFlag;
    }
    
    /**
     * 旧従業員番号の取得
     * @return 旧従業員番号
     * @generated
     */
    public Integer getOldJgiNo() {
        return this.oldJgiNo;
    }

    /**
     * 旧従業員番号の設定
     * @param oldJgiNo 旧従業員番号
     * @generated
     */
    public void setOldJgiNo(Integer oldJgiNo) {
        this.oldJgiNo = oldJgiNo;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isOldJgiNoNullFlag() {
        return this.oldJgiNoNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param oldJgiNoNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setOldJgiNoNullFlag(boolean oldJgiNoNullFlag) {
        this.oldJgiNoNullFlag = oldJgiNoNullFlag;
    }
    
    /**
     * 旧雇用区分の取得
     * @return 旧雇用区分
     * @generated
     */
    public String getOldKoyouKb() {
        return this.oldKoyouKb;
    }

    /**
     * 旧雇用区分の設定
     * @param oldKoyouKb 旧雇用区分
     * @generated
     */
    public void setOldKoyouKb(String oldKoyouKb) {
        this.oldKoyouKb = oldKoyouKb;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isOldKoyouKbNullFlag() {
        return this.oldKoyouKbNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param oldKoyouKbNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setOldKoyouKbNullFlag(boolean oldKoyouKbNullFlag) {
        this.oldKoyouKbNullFlag = oldKoyouKbNullFlag;
    }
    
    /**
     * 旧雇用区分名の取得
     * @return 旧雇用区分名
     * @generated
     */
    public String getOldKoyouName() {
        return this.oldKoyouName;
    }

    /**
     * 旧雇用区分名の設定
     * @param oldKoyouName 旧雇用区分名
     * @generated
     */
    public void setOldKoyouName(String oldKoyouName) {
        this.oldKoyouName = oldKoyouName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isOldKoyouNameNullFlag() {
        return this.oldKoyouNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param oldKoyouNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setOldKoyouNameNullFlag(boolean oldKoyouNameNullFlag) {
        this.oldKoyouNameNullFlag = oldKoyouNameNullFlag;
    }
    
    /**
     * 職位Ｃの取得
     * @return 職位Ｃ
     * @generated
     */
    public String getShokuiCd() {
        return this.shokuiCd;
    }

    /**
     * 職位Ｃの設定
     * @param shokuiCd 職位Ｃ
     * @generated
     */
    public void setShokuiCd(String shokuiCd) {
        this.shokuiCd = shokuiCd;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShokuiCdNullFlag() {
        return this.shokuiCdNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shokuiCdNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShokuiCdNullFlag(boolean shokuiCdNullFlag) {
        this.shokuiCdNullFlag = shokuiCdNullFlag;
    }
    
    /**
     * 職位名の取得
     * @return 職位名
     * @generated
     */
    public String getShokuiName() {
        return this.shokuiName;
    }

    /**
     * 職位名の設定
     * @param shokuiName 職位名
     * @generated
     */
    public void setShokuiName(String shokuiName) {
        this.shokuiName = shokuiName;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isShokuiNameNullFlag() {
        return this.shokuiNameNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param shokuiNameNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setShokuiNameNullFlag(boolean shokuiNameNullFlag) {
        this.shokuiNameNullFlag = shokuiNameNullFlag;
    }
    
    /**
     * 部門ランクの取得
     * @return 部門ランク
     * @generated
     */
    public Integer getBumonRank() {
        return this.bumonRank;
    }

    /**
     * 部門ランクの設定
     * @param bumonRank 部門ランク
     * @generated
     */
    public void setBumonRank(Integer bumonRank) {
        this.bumonRank = bumonRank;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isBumonRankNullFlag() {
        return this.bumonRankNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param bumonRankNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setBumonRankNullFlag(boolean bumonRankNullFlag) {
        this.bumonRankNullFlag = bumonRankNullFlag;
    }
    
    /**
     * 世話部門ランクの取得
     * @return 世話部門ランク
     * @generated
     */
    public Integer getSewaBumonRank() {
        return this.sewaBumonRank;
    }

    /**
     * 世話部門ランクの設定
     * @param sewaBumonRank 世話部門ランク
     * @generated
     */
    public void setSewaBumonRank(Integer sewaBumonRank) {
        this.sewaBumonRank = sewaBumonRank;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSewaBumonRankNullFlag() {
        return this.sewaBumonRankNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param sewaBumonRankNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSewaBumonRankNullFlag(boolean sewaBumonRankNullFlag) {
        this.sewaBumonRankNullFlag = sewaBumonRankNullFlag;
    }
    
    /**
     * 基本情報更新日の取得
     * @return 基本情報更新日
     * @generated
     */
    public Date getKihonUpDate() {
        return this.kihonUpDate;
    }

    /**
     * 基本情報更新日の設定
     * @param kihonUpDate 基本情報更新日
     * @generated
     */
    public void setKihonUpDate(Date kihonUpDate) {
        this.kihonUpDate = kihonUpDate;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isKihonUpDateNullFlag() {
        return this.kihonUpDateNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param kihonUpDateNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setKihonUpDateNullFlag(boolean kihonUpDateNullFlag) {
        this.kihonUpDateNullFlag = kihonUpDateNullFlag;
    }
    
    /**
     * 所属更新日の取得
     * @return 所属更新日
     * @generated
     */
    public Date getSyozokuUpDate() {
        return this.syozokuUpDate;
    }

    /**
     * 所属更新日の設定
     * @param syozokuUpDate 所属更新日
     * @generated
     */
    public void setSyozokuUpDate(Date syozokuUpDate) {
        this.syozokuUpDate = syozokuUpDate;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isSyozokuUpDateNullFlag() {
        return this.syozokuUpDateNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param syozokuUpDateNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setSyozokuUpDateNullFlag(boolean syozokuUpDateNullFlag) {
        this.syozokuUpDateNullFlag = syozokuUpDateNullFlag;
    }
    
    /**
     * 従業員区分の取得
     * @return 従業員区分
     * @generated
     */
    public String getJgiKb() {
        return this.jgiKb;
    }

    /**
     * 従業員区分の設定
     * @param jgiKb 従業員区分
     * @generated
     */
    public void setJgiKb(String jgiKb) {
        this.jgiKb = jgiKb;
    }

    /**
     * NULL更新するかのフラグの取得
     * @return true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public boolean isJgiKbNullFlag() {
        return this.jgiKbNullFlag;
    }

    /**
     * NULL更新するかのフラグの設定
     * @param jgiKbNullFlag true：NULL更新する、false：NULL更新しない
     * @generated
     */
    public void setJgiKbNullFlag(boolean jgiKbNullFlag) {
        this.jgiKbNullFlag = jgiKbNullFlag;
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
