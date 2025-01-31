/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.jkr.dto;

import java.io.Serializable;

import jp.co.takeda.rdm.common.BaseDTO;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.InputStream;
import java.util.List;

import jp.co.takeda.rdm.entity.join.SelectTopMenuDispDataEntity;

/**
 * DTOクラス
 * @generated
 */
public class ND001DTO extends BaseDTO implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * このDTOが関連付けられている画面ID
     * @generated
     */
    private String ND001 = "ND001";

    /**
     * 施設一括更新メニュースイッチ
     * @generated
     */
    private String menuMnIktFac;

    /**
     * 医師一括更新メニュースイッチ
     * @generated
     */
    private String menuMnIktDoc;

    /**
     * 来期用項目メニュースイッチ
     * @generated
     */
    private String menuMnNtFac;

	/**
     * 施設一括更新メニュースイッチの取得
     * @return 施設一括更新メニュースイッチ
     * @generated
     */
    public String getMenuMnIktFac() {
        return menuMnIktFac;
    }

	/**
     * 施設一括更新メニュースイッチの設定
     * @param menuMnIktFac 施設一括更新メニュースイッチ
     * @generated
     */
    public void setMenuMnIktFac(String menuMnIktFac) {
        this.menuMnIktFac = menuMnIktFac;
    }

	/**
     * 医師一括更新メニュースイッチの取得
     * @return 医師一括更新メニュースイッチ
     * @generated
     */
    public String getMenuMnIktDoc() {
        return menuMnIktDoc;
    }

	/**
     * 医師一括更新メニュースイッチの設定
     * @param menuMnIktDoc 医師一括更新メニュースイッチ
     * @generated
     */
    public void setMenuMnIktDoc(String menuMnIktDoc) {
        this.menuMnIktDoc = menuMnIktDoc;
    }

	/**
     * 来期用項目メニュースイッチの取得
     * @return 来期用項目メニュースイッチ
     * @generated
     */
    public String getMenuMnNtFac() {
        return menuMnNtFac;
    }

	/**
     * 来期用項目メニュースイッチの設定
     * @param menuMnNtFac 来期用項目メニュースイッチ
     * @generated
     */
    public void setMenuMnNtFac(String menuMnNtFac) {
        this.menuMnNtFac = menuMnNtFac;
    }









    /**
     * 担当変更選択
     * @generated
     */
    private String catsel;

    /**
     * 本部業務
     * @generated
     */
    private String honbuPldn;

    /**
     * 本部業務選択リスト
     * @generated
     */
    private List honbuPldnList;

    /**
     * 支店業務・支店代行
     * @generated
     */
    private String sitenPldn;

    /**
     * 支店業務・支店代行選択リスト
     * @generated
     */
    private List sitenPldnList;

    /**
     * 営業所業務・営業所代行
     * @generated
     */
    private String eigyouPldn;

    /**
     * 営業所業務・営業所代行選択リスト
     * @generated
     */
    private List eigyouPldnList;

    /**
     * 施設の担当組織変更
     * @generated
     */
    private String sisetuPldn;

    /**
     * 施設の担当組織変更選択リスト
     * @generated
     */
    private List sisetuPldnList;

    /**
     * 条件設定
     * @generated
     */
    private String jokenSetCd;

    /**
     * 業務種類
     * @generated
     */
    private String wkCat;

    /**
     * 領域グループコード
     * @generated
     */
    private String trtGrpCd;

	/**
     * 適用日更新可否フラグ１
     * @generated
     */
    private String tekiyoYmdUpdateFlg1;

	/**
     * 適用日更新可否フラグ
     * @generated
     */
    private String tekiyoYmdUpdateFlg;

	/**
     * 選択部門ランク
     * @generated
     */
    private String selectedBumonRank;

	/**
     * 検索条件「条件設定」
     * @generated
     */
    private String selectedJgiJoken;

	/**
     * 担当変更状況（新組織）用入り口判定フラグ
     * @generated
     */
    private String gateFlg;

	/**
     * 施設表示範囲表示フラグ
     * @generated
     */
    private String selectedInsDispRngFlg;

	/**
     * 組織適用済みフラグ
     * @generated
     */
    private String selectedSosTkyFlg;

	/**
     * 組織選択可能フラグ
     * @generated
     */
    private String sosSelectDisableFlg;

	/**
     * 検索条件「組織」支店名称
     * @generated
     */
    private String selectedSosNm2;

	/**
     * 検索条件「組織」支店コード
     * @generated
     */
    private String selectedSosCd2;

	/**
     * 検索条件「組織」営業所名称
     * @generated
     */
    private String selectedSosNm3;

	/**
     * 検索条件「組織」営業所コード
     * @generated
     */
    private String selectedSosCd3;

	/**
     * 施設責任者表示フラグ
     * @generated
     */
    private String insSkninDispFlg;

	/**
     * TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    private String topChangedSosCd;

	/**
     * TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    private String topChangedSosNm;

	/**
     * TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    private String topChangedSosCd2;

	/**
     * TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    private String topChangedSosNm2;

	/**
     * TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    private String topChangedSosCd3;

	/**
     * TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    private String topChangedSosNm3;

	/**
     * 施設責任者更新可能フラグ
     * @generated
     */
    private String insSkninUpFlg;

	/**
     * 施設表示範囲設定フラグ
     * @generated
     */
    private String insDispRngFlg;

	/**
     * 施設責任者表示範囲
     * @generated
     */
    private String dispRng;

	/**
     * 検索条件_（隠し）組織コード（現）_ポップアップ用
     * @generated
     */
    private String searchFromSosCdPop;

	/**
     * 検索条件_（隠し）組織コード（新）_ポップアップ用
     * @generated
     */
    private String searchToSosCdPop;

	/** ダウンロードファイル
     * @generated
     */
    private InputStream inputStream;

	/**
     * Content-Type
     * @generated
     */
    private String contentType;

	/**
     * Content-Lengthn
     * @generated
     */
    private Long contentLength;

	/**
     * Content-Disposition
     * @generated
     */
    private String contentDisposition;

	/**
      * バッファサイズ
     * @generated
     */
    private String bufferSize = "1024";

	/**
     * 選択「組織名称」（現)
     * @generated
     */
    private String selectedSosName;

    /**
     * 検索条件「組織」名称
     * @generated
     */
    private String selectedSosNm;

	/**
     * 検索条件「組織」コード
     * @generated
     */
    private String selectedSosCd;

    /**
     * 検索条件「組織（新）」名称
     * @generated
     */
    private String selectedPlanSosName;

    /**
     * 検索条件「組織（新）」コード
     * @generated
     */
    private String planSosCd;

    /**
     * 適用日
     * @generated
     */
    private String execdate;

    /**
     * 変更画面へ選択ラジオ
     * @generated
     */
    private String mod;

	/**
     * Ｐ担当者市区群軒数
     * @generated
     */
    private String report2;

	/**
     * 複数担当先所属部科別担当者別医師数
     * @generated
     */
    private String report3;

	/**
     * 担当状況総括表
     * @generated
     */
    private String report4;

	/**
     * 担当者別重点先施設一覧
     * @generated
     */
    private String report5;

	/**
     * 担当者別市区群軒数
     * @generated
     */
    private String report6;

	/**
     * 医師別担当変更関連項目表示フラグ
     * @generated
     */
    private String docChgLinkFlg;

	/**
     * 適用日更新可否フラグ２
     * @generated
     */
    private String tekiyoYmdUpdateFlg2;

	/**
     * 組織コード
     * @generated
     */
    private String sosCd;

    /**
     * 組織名称
     * @generated
     */
    private String sosName;

    /**
     * 表示組織名称
     * @generated
     */
    private String dispSosName;

    /**
     * 代行ユーザ権限有無フラグ
     * @generated
     */
    private boolean jgiActUmuFlg;

    /**
     * 代行ユーザ組織コード
     * @generated
     */
    private String jgiActSosCd;

    /**
     * 代行ユーザ表示組織名称
     * @generated
     */
    private String jgiActDispSosName;

    /**
     * 代行ユーザ上位組織コード
     * @generated
     */
    private String jgiActUpSosCd;

    /**
     * 担当変更状況テーブルデータ
     * @generated
     */
    private SelectTopMenuDispDataEntity jkrSosStsTableData;

    /**
     * 組織コードリスト
     * @generated
     */
    private List sosCdList;

    /**
     * 組織コード配列
     * @generated
     */
    private String sosCdHairetu;

    /**
     * 部門ランク
     * @generated
     */
    private Integer bumonRank;

    /**
     * 新現組織フラグ
     * @generated
     */
    private String sosSelFlg;

    /**
     * 新組織リスト
     * @generated
     */
    private List planSosList;

    /**
     * 新組織コード配列
     * @generated
     */
    private String planSosCdHairetu;

    /**
     * 適用日
     * @generated
     */
    private String tekiyoYmd;

    /**選択適用日
     * @generated
     */
    private String selectedTekiyoYmd;

	/**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public ND001DTO() {
        setForward(ND001);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setND001(String screenID){
        this.ND001 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getND001(){
        return ND001;
    }

    /**
     * 担当変更選択の取得
     * @return 担当変更選択
     * @generated
     */
    public String getCatsel() {
        return catsel;
    }

    /**
     * 担当変更選択の設定
     * @param catsel 担当変更選択
     * @generated
     */
    public void setCatsel(String catsel) {
        this.catsel = catsel;
    }

    /**
     * 本部業務の取得
     * @return 本部業務
     * @generated
     */
    public String getHonbuPldn() {
        return honbuPldn;
    }

    /**
     * 本部業務の設定
     * @param honbuPldn 本部業務
     * @generated
     */
    public void setHonbuPldn(String honbuPldn) {
        this.honbuPldn = honbuPldn;
    }

    /**
     * 本部業務選択リストの取得
     * @return 本部業務選択リスト
     * @generated
     */
    public List getHonbuPldnList() {
        return honbuPldnList;
    }

    /**
     * 本部業務選択リストの設定
     * @param honbuPldnList 本部業務選択リスト
     * @generated
     */
    public void setHonbuPldnList(List honbuPldnList) {
        this.honbuPldnList = honbuPldnList;
    }

    /**
     * 支店業務・支店代行の取得
     * @return 支店業務・支店代行
     * @generated
     */
    public String getSitenPldn() {
        return sitenPldn;
    }

    /**
     * 支店業務・支店代行の設定
     * @param sitenPldn 支店業務・支店代行
     * @generated
     */
    public void setSitenPldn(String sitenPldn) {
        this.sitenPldn = sitenPldn;
    }

    /**
     * 支店業務・支店代行選択リストの取得
     * @return 支店業務・支店代行選択リスト
     * @generated
     */
    public List getSitenPldnList() {
        return sitenPldnList;
    }

    /**
     * 支店業務・支店代行選択リストの設定
     * @param sitenPldnList 支店業務・支店代行選択リスト
     * @generated
     */
    public void setSitenPldnList(List sitenPldnList) {
        this.sitenPldnList = sitenPldnList;
    }

    /**
     * 営業所業務・営業所代行の取得
     * @return 営業所業務・営業所代行
     * @generated
     */
    public String getEigyouPldn() {
        return eigyouPldn;
    }

    /**
     * 営業所業務・営業所代行の設定
     * @param eigyouPldn 営業所業務・営業所代行
     * @generated
     */
    public void setEigyouPldn(String eigyouPldn) {
        this.eigyouPldn = eigyouPldn;
    }

    /**
     * 営業所業務・営業所代行選択リストの取得
     * @return 営業所業務・営業所代行選択リスト
     * @generated
     */
    public List getEigyouPldnList() {
        return eigyouPldnList;
    }

    /**
     * 営業所業務・営業所代行選択リストの設定
     * @param eigyouPldnList 営業所業務・営業所代行選択リスト
     * @generated
     */
    public void setEigyouPldnList(List eigyouPldnList) {
        this.eigyouPldnList = eigyouPldnList;
    }

    /**
     * 施設の担当組織変更の取得
     * @return 施設の担当組織変更
     * @generated
     */
    public String getSisetuPldn() {
        return sisetuPldn;
    }

    /**
     * 施設の担当組織変更の設定
     * @param sisetuPldn 施設の担当組織変更
     * @generated
     */
    public void setSisetuPldn(String sisetuPldn) {
        this.sisetuPldn = sisetuPldn;
    }

    /**
     * 施設の担当組織変更選択リストの取得
     * @return 施設の担当組織変更選択リスト
     * @generated
     */
    public List getSisetuPldnList() {
        return sisetuPldnList;
    }

    /**
     * 施設の担当組織変更選択リストの設定
     * @param sisetuPldnList 施設の担当組織変更選択リスト
     * @generated
     */
    public void setSisetuPldnList(List sisetuPldnList) {
        this.sisetuPldnList = sisetuPldnList;
    }

    /**
     * 条件設定の取得
     * @return 条件設定
     * @generated
     */
    public String getJokenSetCd() {
        return jokenSetCd;
    }

    /**
     * 条件設定の設定
     * @param jokenSetCd 条件設定
     * @generated
     */
    public void setJokenSetCd(String jokenSetCd) {
        this.jokenSetCd = jokenSetCd;
    }

    /**
     * 業務種類の取得
     * @return 業務種類
     * @generated
     */
    public String getWkCat() {
        return wkCat;
    }

    /**
     * 業務種類の設定
     * @param wkCat 業務種類
     * @generated
     */
    public void setWkCat(String wkCat) {
        this.wkCat = wkCat;
    }

    /**
     * 領域グループコードの取得
     * @return 領域グループコード
     * @generated
     */
    public String getTrtGrpCd() {
        return trtGrpCd;
    }

	/**
     * 領域グループコードの設定
     * @param trtGrpCd 領域グループコード
     * @generated
     */
    public void setTrtGrpCd(String trtGrpCd) {
        this.trtGrpCd = trtGrpCd;
    }

	/**
     * 適用日更新可否フラグ１の取得
     * @return 適用日更新可否フラグ１
     * @generated
     */
    public String getTekiyoYmdUpdateFlg1() {
        return tekiyoYmdUpdateFlg1;
    }

	/**
     * 適用日更新可否フラグ１の設定
     * @param tekiyoYmdUpdateFlg1 適用日更新可否フラグ１
     * @generated
     */
    public void setTekiyoYmdUpdateFlg1(String tekiyoYmdUpdateFlg1) {
        this.tekiyoYmdUpdateFlg1 = tekiyoYmdUpdateFlg1;
    }

	/**
     * 適用日更新可否フラグの取得
     * @return 適用日更新可否フラグ
     * @generated
     */
    public String getTekiyoYmdUpdateFlg() {
        return tekiyoYmdUpdateFlg;
    }

	/**
     * 適用日更新可否フラグの設定
     * @param tekiyoYmdUpdateFlg 適用日更新可否フラグ
     * @generated
     */
    public void setTekiyoYmdUpdateFlg(String tekiyoYmdUpdateFlg) {
        this.tekiyoYmdUpdateFlg = tekiyoYmdUpdateFlg;
    }

	/**
     * 選択部門ランクの取得
     * @return 選択部門ランク
     * @generated
     */
    public String getSelectedBumonRank() {
        return selectedBumonRank;
    }

	/**
     * 選択部門ランクの設定
     * @param selectedBumonRank 選択部門ランク
     * @generated
     */
    public void setSelectedBumonRank(String selectedBumonRank) {
        this.selectedBumonRank = selectedBumonRank;
    }

	/**
     * 検索条件「条件設定」の取得
     * @return 検索条件「条件設定」
     * @generated
     */
    public String getSelectedJgiJoken() {
        return selectedJgiJoken;
    }

	/**
     * 検索条件「条件設定」の設定
     * @param selectedJgiJoken 検索条件「条件設定」
     * @generated
     */
    public void setSelectedJgiJoken(String selectedJgiJoken) {
        this.selectedJgiJoken = selectedJgiJoken;
    }

	/**
     * 担当変更状況（新組織）用入り口判定フラグの取得
     * @return 担当変更状況（新組織）用入り口判定フラグ
     * @generated
     */
    public String getGateFlg() {
        return gateFlg;
    }

	/**
     * 担当変更状況（新組織）用入り口判定フラグの設定
     * @param gateFlg 担当変更状況（新組織）用入り口判定フラグ
     * @generated
     */
    public void setGateFlg(String gateFlg) {
        this.gateFlg = gateFlg;
    }

	/**
     * 施設表示範囲表示フラグの取得
     * @return 施設表示範囲表示フラグ
     * @generated
     */
    public String getSelectedInsDispRngFlg() {
        return selectedInsDispRngFlg;
    }

	/**
     * 施設表示範囲表示フラグの設定
     * @param selectedInsDispRngFlg 施設表示範囲表示フラグ
     * @generated
     */
    public void setSelectedInsDispRngFlg(String selectedInsDispRngFlg) {
        this.selectedInsDispRngFlg = selectedInsDispRngFlg;
    }

	/**
     * 組織適用済みフラグの取得
     * @return 組織適用済みフラグ
     * @generated
     */
    public String getSelectedSosTkyFlg() {
        return selectedSosTkyFlg;
    }

	/**
     * 組織適用済みフラグの設定
     * @param selectedSosTkyFlg 組織適用済みフラグ
     * @generated
     */
    public void setSelectedSosTkyFlg(String selectedSosTkyFlg) {
        this.selectedSosTkyFlg = selectedSosTkyFlg;
    }

	/**
     * 組織選択可能フラグの取得
     * @return 組織選択可能フラグ
     * @generated
     */
    public String getSosSelectDisableFlg() {
        return sosSelectDisableFlg;
    }

	/**
     * 組織選択可能フラグの設定
     * @param sosSelectDisableFlg 組織選択可能フラグ
     * @generated
     */
    public void setSosSelectDisableFlg(String sosSelectDisableFlg) {
        this.sosSelectDisableFlg = sosSelectDisableFlg;
    }

	/**
     * 検索条件「組織」支店名称の取得
     * @return 検索条件「組織」支店名称
     * @generated
     */
    public String getSelectedSosNm2() {
        return selectedSosNm2;
    }

	/**
     * 検索条件「組織」支店名称の設定
     * @param selectedSosNm2 検索条件「組織」支店名称
     * @generated
     */
    public void setSelectedSosNm2(String selectedSosNm2) {
        this.selectedSosNm2 = selectedSosNm2;
    }

	/**
     * 検索条件「組織」支店コードの取得
     * @return 検索条件「組織」支店コード
     * @generated
     */
    public String getSelectedSosCd2() {
        return selectedSosCd2;
    }

	/**
     * 検索条件「組織」支店コードの設定
     * @param selectedSosCd2 検索条件「組織」支店コード
     * @generated
     */
    public void setSelectedSosCd2(String selectedSosCd2) {
        this.selectedSosCd2 = selectedSosCd2;
    }

	/**
     * 検索条件「組織」営業所名称の取得
     * @return 検索条件「組織」営業所名称
     * @generated
     */
    public String getSelectedSosNm3() {
        return selectedSosNm3;
    }

	/**
     * 検索条件「組織」営業所名称の設定
     * @param selectedSosNm3 検索条件「組織」営業所名称
     * @generated
     */
    public void setSelectedSosNm3(String selectedSosNm3) {
        this.selectedSosNm3 = selectedSosNm3;
    }

	/**
     * 検索条件「組織」営業所コードの取得
     * @return 検索条件「組織」営業所コード
     * @generated
     */
    public String getSelectedSosCd3() {
        return selectedSosCd3;
    }

	/**
     * 検索条件「組織」営業所コードの設定
     * @param selectedSosCd3 検索条件「組織」営業所コード
     * @generated
     */
    public void setSelectedSosCd3(String selectedSosCd3) {
        this.selectedSosCd3 = selectedSosCd3;
    }

	/**
     * 施設責任者表示フラグの取得
     * @return 施設責任者表示フラグ
     * @generated
     */
    public String getInsSkninDispFlg() {
        return insSkninDispFlg;
    }

	/**
     * 施設責任者表示フラグの設定
     * @param insSkninDispFlg 施設責任者表示フラグ
     * @generated
     */
    public void setInsSkninDispFlg(String insSkninDispFlg) {
        this.insSkninDispFlg = insSkninDispFlg;
    }

	/**
     * TopMenuへ反映する組織コード（表示押下後）の取得
     * @return TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    public String getTopChangedSosCd() {
        return topChangedSosCd;
    }

	/**
     * TopMenuへ反映する組織コード（表示押下後）の設定
     * @param topChangedSosCd TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    public void setTopChangedSosCd(String topChangedSosCd) {
        this.topChangedSosCd = topChangedSosCd;
    }

	/**
     * TopMenuへ反映する組織名称（表示押下後）の取得
     * @return TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    public String getTopChangedSosNm() {
        return topChangedSosNm;
    }

	/**
     * TopMenuへ反映する組織名称（表示押下後）の設定
     * @param topChangedSosNm TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    public void setTopChangedSosNm(String topChangedSosNm) {
        this.topChangedSosNm = topChangedSosNm;
    }

	/**
     * TopMenuへ反映する組織コード（表示押下後）の取得
     * @return TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    public String getTopChangedSosCd2() {
        return topChangedSosCd2;
    }

	/**
     * TopMenuへ反映する組織コード（表示押下後）の設定
     * @param topChangedSosCd2 TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    public void setTopChangedSosCd2(String topChangedSosCd2) {
        this.topChangedSosCd2 = topChangedSosCd2;
    }

	/**
     * TopMenuへ反映する組織名称（表示押下後）の取得
     * @return TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    public String getTopChangedSosNm2() {
        return topChangedSosNm2;
    }

	/**
     * TopMenuへ反映する組織名称（表示押下後）の設定
     * @param topChangedSosNm2 TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    public void setTopChangedSosNm2(String topChangedSosNm2) {
        this.topChangedSosNm2 = topChangedSosNm2;
    }

	/**
     * TopMenuへ反映する組織コード（表示押下後）の取得
     * @return TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    public String getTopChangedSosCd3() {
        return topChangedSosCd3;
    }

	/**
     * TopMenuへ反映する組織コード（表示押下後）の設定
     * @param topChangedSosCd3 TopMenuへ反映する組織コード（表示押下後）
     * @generated
     */
    public void setTopChangedSosCd3(String topChangedSosCd3) {
        this.topChangedSosCd3 = topChangedSosCd3;
    }

	/**
     * TopMenuへ反映する組織名称（表示押下後）の取得
     * @return TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    public String getTopChangedSosNm3() {
        return topChangedSosNm3;
    }

	/**
     * TopMenuへ反映する組織名称（表示押下後）の設定
     * @param topChangedSosNm3 TopMenuへ反映する組織名称（表示押下後）
     * @generated
     */
    public void setTopChangedSosNm3(String topChangedSosNm3) {
        this.topChangedSosNm3 = topChangedSosNm3;
    }

	/**
     * 施設責任者更新可能フラグの取得
     * @return 施設責任者更新可能フラグ
     * @generated
     */
    public String getInsSkninUpFlg() {
        return insSkninUpFlg;
    }

	/**
     * 施設責任者更新可能フラグの設定
     * @param insSkninUpFlg 施設責任者更新可能フラグ
     * @generated
     */
    public void setInsSkninUpFlg(String insSkninUpFlg) {
        this.insSkninUpFlg = insSkninUpFlg;
    }

	/**
     * 施設表示範囲設定フラグの取得
     * @return 施設表示範囲設定フラグ
     * @generated
     */
    public String getInsDispRngFlg() {
        return insDispRngFlg;
    }

	/**
     * 施設表示範囲設定フラグの設定
     * @param insDispRngFlg 施設表示範囲設定フラグ
     * @generated
     */
    public void setInsDispRngFlg(String insDispRngFlg) {
        this.insDispRngFlg = insDispRngFlg;
    }

	/**
     * 施設責任者表示範囲の取得
     * @return 施設責任者表示範囲
     * @generated
     */
    public String getDispRng() {
        return dispRng;
    }

	/**
     * 施設責任者表示範囲の設定
     * @param dispRng 施設責任者表示範囲
     * @generated
     */
    public void setDispRng(String dispRng) {
        this.dispRng = dispRng;
    }

	/**
     * 検索条件_（隠し）組織コード（現）_ポップアップ用の取得
     * @return 検索条件_（隠し）組織コード（現）_ポップアップ用
     * @generated
     */
    public String getSearchFromSosCdPop() {
        return searchFromSosCdPop;
    }

	/**
     * 検索条件_（隠し）組織コード（現）_ポップアップ用の設定
     * @param searchFromSosCdPop 検索条件_（隠し）組織コード（現）_ポップアップ用
     * @generated
     */
    public void setSearchFromSosCdPop(String searchFromSosCdPop) {
        this.searchFromSosCdPop = searchFromSosCdPop;
    }

	/**
     * 検索条件_（隠し）組織コード（新）_ポップアップ用の取得
     * @return 検索条件_（隠し）組織コード（新）_ポップアップ用
     * @generated
     */
    public String getSearchToSosCdPop() {
        return searchToSosCdPop;
    }

	/**
     * 検索条件_（隠し）組織コード（新）_ポップアップ用の設定
     * @param searchToSosCdPop 検索条件_（隠し）組織コード（新）_ポップアップ用
     * @generated
     */
    public void setSearchToSosCdPop(String searchToSosCdPop) {
        this.searchToSosCdPop = searchToSosCdPop;
    }

	/**
     * ダウンロードファイルの取得
     * @return ダウンロードファイル
     * @generated
     */
    public InputStream getInputStream() {
        return inputStream;
    }

	/**
     * ダウンロードファイルの設定
     * @param inputStream ダウンロードファイル
     * @generated
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

	/**
     * Content-Typeの取得
     * @return Content-Type
     * @generated
     */
    public String getContentType() {
        return contentType;
    }

	/**
     * Content-Typeの設定
     * @param contentType Content-Type
     * @generated
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

	/**
     * Content-Lengthの取得
     * @return Content-Length
     * @generated
     */
    public Long getContentLength() {
        return contentLength;
    }

	/**
     * Content-Lengthの設定
     * @param contentLength Content-Length
     * @generated
     */
    public void setContentLength(Long contentLength) {
        this.contentLength = contentLength;
    }

	/**
     * Content-Dispositionの取得
     * @return Content-Disposition
     * @generated
     */
    public String getContentDisposition() {
        return contentDisposition;
    }

	/**
     * Content-Dispositionの設定
     * @param contentDisposition Content-Disposition
     * @generated
     */
    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

	/**
     * バッファサイズの取得
     * @return バッファサイズ
     * @generated
     */
    public String getBufferSize() {
        return bufferSize;
    }

	/**
     * バッファサイズの設定
     * @param bufferSize バッファサイズ
     * @generated
     */
    public void setBufferSize(String bufferSize) {
        this.bufferSize = bufferSize;
    }

	/**
     * 選択「組織名称」（現)の取得
     * @return 選択「組織名称」（現)
     * @generated
     */
    public String getSelectedSosName() {
        return selectedSosName;
    }

    /**
     * 選択「組織名称」（現)の設定
     * @param selectedSosName 選択「組織名称」（現)
     * @generated
     */
    public void setSelectedSosName(String selectedSosName) {
        this.selectedSosName = selectedSosName;
    }

    /**
     * 検索条件「組織」名称の取得
     * @return 検索条件「組織」名称
     * @generated
     */
    public String getSelectedSosNm() {
        return selectedSosNm;
    }

	/**
     * 検索条件「組織」名称の設定
     * @param selectedSosNm 検索条件「組織」名称
     * @generated
     */
    public void setSelectedSosNm(String selectedSosNm) {
        this.selectedSosNm = selectedSosNm;
    }

	/**
     * 検索条件「組織」コードの取得
     * @return 検索条件「組織」コード
     * @generated
     */
    public String getSelectedSosCd() {
        return selectedSosCd;
    }

    /**
     * 検索条件「組織」コードの設定
     * @param selectedSosCd 検索条件「組織」コード
     * @generated
     */
    public void setSelectedSosCd(String selectedSosCd) {
        this.selectedSosCd = selectedSosCd;
    }

    /**
     * 検索条件「組織（新）」名称の取得
     * @return 検索条件「組織（新）」名称
     * @generated
     */
    public String getSelectedPlanSosName() {
        return selectedPlanSosName;
    }

    /**
     * 検索条件「組織（新）」名称の設定
     * @param selectedPlanSosName 検索条件「組織（新）」名称
     * @generated
     */
    public void setSelectedPlanSosName(String selectedPlanSosName) {
        this.selectedPlanSosName = selectedPlanSosName;
    }

    /**
     * 検索条件「組織（新）」コードの取得
     * @return 検索条件「組織（新）」コード
     * @generated
     */
    public String getPlanSosCd() {
        return planSosCd;
    }

    /**
     * 検索条件「組織（新）」コードの設定
     * @param planSosCd 検索条件「組織（新）」コード
     * @generated
     */
    public void setPlanSosCd(String planSosCd) {
        this.planSosCd = planSosCd;
    }

    /**
     * 適用日の取得
     * @return 適用日
     * @generated
     */
    public String getExecdate() {
        return execdate;
    }

    /**
     * 適用日の設定
     * @param execdate 適用日
     * @generated
     */
    public void setExecdate(String execdate) {
        this.execdate = execdate;
    }

    /**
     * 変更画面へ選択ラジオの取得
     * @return 変更画面へ選択ラジオ
     * @generated
     */
    public String getMod() {
        return mod;
    }

	/**
     * 変更画面へ選択ラジオの設定
     * @param mod 変更画面へ選択ラジオ
     * @generated
     */
    public void setMod(String mod) {
        this.mod = mod;
    }

	/**
     * Ｐ担当者市区群軒数の取得
     * @return Ｐ担当者市区群軒数
     * @generated
     */
    public String getReport2() {
        return report2;
    }

	/**
     * Ｐ担当者市区群軒数の設定
     * @param report2 Ｐ担当者市区群軒数
     * @generated
     */
    public void setReport2(String report2) {
        this.report2 = report2;
    }

	/**
     * 複数担当先所属部科別担当者別医師数の取得
     * @return 複数担当先所属部科別担当者別医師数
     * @generated
     */
    public String getReport3() {
        return report3;
    }

	/**
     * 複数担当先所属部科別担当者別医師数の設定
     * @param report3 複数担当先所属部科別担当者別医師数
     * @generated
     */
    public void setReport3(String report3) {
        this.report3 = report3;
    }

	/**
     * 担当状況総括表の取得
     * @return 担当状況総括表
     * @generated
     */
    public String getReport4() {
        return report4;
    }

	/**
     * 担当状況総括表の設定
     * @param report4 担当状況総括表
     * @generated
     */
    public void setReport4(String report4) {
        this.report4 = report4;
    }

	/**
     * 担当者別重点先施設一覧の取得
     * @return 担当者別重点先施設一覧
     * @generated
     */
    public String getReport5() {
        return report5;
    }

	/**
     * 担当者別重点先施設一覧の設定
     * @param report5 担当者別重点先施設一覧
     * @generated
     */
    public void setReport5(String report5) {
        this.report5 = report5;
    }

	/**
     * 担当者別市区群軒数の取得
     * @return 担当者別市区群軒数
     * @generated
     */
    public String getReport6() {
        return report6;
    }

	/**
     * 担当者別市区群軒数の設定
     * @param report6 担当者別市区群軒数
     * @generated
     */
    public void setReport6(String report6) {
        this.report6 = report6;
    }

	/**
     * 医師別担当変更関連項目表示フラグの取得
     * @return 医師別担当変更関連項目表示フラグ
     * @generated
     */
    public String getDocChgLinkFlg() {
        return docChgLinkFlg;
    }

	/**
     * 医師別担当変更関連項目表示フラグの設定
     * @param docChgLinkFlg 医師別担当変更関連項目表示フラグ
     * @generated
     */
    public void setDocChgLinkFlg(String docChgLinkFlg) {
        this.docChgLinkFlg = docChgLinkFlg;
    }

	/**
     * 適用日更新可否フラグ２の取得
     * @return 適用日更新可否フラグ２
     * @generated
     */
    public String getTekiyoYmdUpdateFlg2() {
        return tekiyoYmdUpdateFlg2;
    }

	/**
     * 適用日更新可否フラグ２の設定
     * @param tekiyoYmdUpdateFlg2 適用日更新可否フラグ２
     * @generated
     */
    public void setTekiyoYmdUpdateFlg2(String tekiyoYmdUpdateFlg2) {
        this.tekiyoYmdUpdateFlg2 = tekiyoYmdUpdateFlg2;
    }

	/**
     * 組織コードの取得
     * @return 組織コード
     * @generated
     */
    public String getSosCd() {
        return sosCd;
    }

    /**
     * 組織コードの設定
     * @param sosCd 組織コード
     * @generated
     */
    public void setSosCd(String sosCd) {
        this.sosCd = sosCd;
    }

    /**
     * 組織名称の取得
     * @return 組織名称
     * @generated
     */
    public String getSosName() {
        return sosName;
    }

    /**
     * 組織名称の設定
     * @param sosName 組織名称
     * @generated
     */
    public void setSosName(String sosName) {
        this.sosName = sosName;
    }

    /**
     * 表示組織名称の取得
     * @return 表示組織名称
     * @generated
     */
    public String getDispSosName() {
        return dispSosName;
    }

    /**
     * 表示組織名称の設定
     * @param dispSosName 表示組織名称
     * @generated
     */
    public void setDispSosName(String dispSosName) {
        this.dispSosName = dispSosName;
    }

    /**
     * 代行ユーザ権限有無フラグの取得
     * @return 代行ユーザ権限有無フラグ
     * @generated
     */
    public boolean getJgiActUmuFlg() {
        return jgiActUmuFlg;
    }

    /**
     * 代行ユーザ権限有無フラグの設定
     * @param jgiActUmuFlg 代行ユーザ権限有無フラグ
     * @generated
     */
    public void setJgiActUmuFlg(boolean jgiActUmuFlg) {
        this.jgiActUmuFlg = jgiActUmuFlg;
    }

    /**
     * 代行ユーザ組織コードの取得
     * @return 代行ユーザ組織コード
     * @generated
     */
    public String getJgiActSosCd() {
        return jgiActSosCd;
    }

    /**
     * 代行ユーザ組織コードの設定
     * @param jgiActSosCd 代行ユーザ組織コード
     * @generated
     */
    public void setJgiActSosCd(String jgiActSosCd) {
        this.jgiActSosCd = jgiActSosCd;
    }

    /**
     * 代行ユーザ表示組織名称の取得
     * @return 代行ユーザ表示組織名称
     * @generated
     */
    public String getJgiActDispSosName() {
        return jgiActDispSosName;
    }

    /**
     * 代行ユーザ表示組織名称の設定
     * @param jgiActDispSosName 代行ユーザ表示組織名称
     * @generated
     */
    public void setJgiActDispSosName(String jgiActDispSosName) {
        this.jgiActDispSosName = jgiActDispSosName;
    }

    /**
     * 代行ユーザ上位組織コードの取得
     * @return 代行ユーザ上位組織コード
     * @generated
     */
    public String getJgiActUpSosCd() {
        return jgiActUpSosCd;
    }

    /**
     * 代行ユーザ上位組織コードの設定
     * @param jgiActUpSosCd 代行ユーザ上位組織コード
     * @generated
     */
    public void setJgiActUpSosCd(String jgiActUpSosCd) {
        this.jgiActUpSosCd = jgiActUpSosCd;
    }

    /**
     * 担当変更状況テーブルデータの取得
     * @return 担当変更状況テーブルデータ
     * @generated
     */
    public SelectTopMenuDispDataEntity getJkrSosStsTableData() {
        return jkrSosStsTableData;
    }

	/**
     * 組織コードリストの取得
     * @return 組織コードリスト
     * @generated
     */
    public List getSosCdList() {
        return sosCdList;
    }

    /**
     * 組織コードリストの設定
     * @param sosCdList 組織コードリスト
     * @generated
     */
    public void setSosCdList(List sosCdList) {
        this.sosCdList = sosCdList;
    }

    /**
     * 組織コード配列の取得
     * @return 組織コード配列
     * @generated
     */
    public String getSosCdHairetu() {
        return sosCdHairetu;
    }

    /**
     * 組織コード配列の設定
     * @param sosCdHairetu 組織コード配列
     * @generated
     */
    public void setSosCdHairetu(String sosCdHairetu) {
        this.sosCdHairetu = sosCdHairetu;
    }

    /**
     * 部門ランクの取得
     * @return 部門ランク
     * @generated
     */
    public Integer getBumonRank() {
        return bumonRank;
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
     * 新現組織フラグの取得
     * @return 新現組織フラグ
     * @generated
     */
    public String getSosSelFlg() {
        return sosSelFlg;
    }

    /**
     * 新現組織フラグの設定
     * @param sosSelFlg 新現組織フラグ
     * @generated
     */
    public void setSosSelFlg(String sosSelFlg) {
        this.sosSelFlg = sosSelFlg;
    }

    /**
     * 新組織リストの取得
     * @return 新組織リスト
     * @generated
     */
    public List getPlanSosList() {
        return planSosList;
    }

    /**
     * 新組織リストの設定
     * @param planSosList 新組織リスト
     * @generated
     */
    public void setPlanSosList(List planSosList) {
        this.planSosList = planSosList;
    }

    /**
     * 新組織コード配列の取得
     * @return 新組織コード配列
     * @generated
     */
    public String getPlanSosCdHairetu() {
        return planSosCdHairetu;
    }

    /**
     * 新組織コード配列の設定
     * @param planSosCdHairetu 新組織コード配列
     * @generated
     */
    public void setPlanSosCdHairetu(String planSosCdHairetu) {
        this.planSosCdHairetu = planSosCdHairetu;
    }

    /**
     * 適用日の取得
     * @return 適用日
     * @generated
     */
    public String getTekiyoYmd() {
        return tekiyoYmd;
    }

	/**
     * 適用日の設定
     * @param tekiyoYmd 適用日
     * @generated
     */
    public void setTekiyoYmd(String tekiyoYmd) {
        this.tekiyoYmd = tekiyoYmd;
    }

    /**
     * 選択適用日の取得
     * @return 選択適用日
     */
    public String getSelectedTekiyoYmd() {
        return selectedTekiyoYmd;
    }

    /**
     * 選択適用日の設定
     * @param selectedTekiyoYmd 選択適用日
     */
    public void setSelectedTekiyoYmd(String selectedTekiyoYmd) {
        this.selectedTekiyoYmd = selectedTekiyoYmd;
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
