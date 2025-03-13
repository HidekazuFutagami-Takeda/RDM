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
public class NF012DTO extends BaseDTO implements Serializable {

	/**
	 * シリアルバージョンUID
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * このDTOが関連付けられている画面ID
	 * @generated
	 */
	private String NF012 = "NF012";

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
	 * 申請ID
	 * @generated
	 */
	private String reqId;

	/**
     * 申請チャネル
     * @generated
     */
    private String reqChl;

	/**
	 * 申請者所属名称
	 * @generated
	 */
	private String reqShzNm;

	/**
	 * 申請ステータス名称
	 * @generated
	 */
	private String reqStsNm;

	/**
	 * 申請者氏名
	 * @generated
	 */
	private String reqJgiName;

	/**
	 * 申請日時
	 * @generated
	 */
	private String reqYmdhms;

	/**
	 * 審査者氏名
	 * @generated
	 */
	private String shnShaName;

	/**
	 * 審査日時
	 * @generated
	 */
	private String shnYmdhms;

	/**
	 * 承認者氏名
	 * @generated
	 */
	private String aprShaName;

	/**
	 * 承認日時
	 * @generated
	 */
	private String aprYmdhms;

	/**
	 * 申請者従業員番号
	 * @generated
	 */
	private Integer reqJgiNo;

	/**
	 * 申請者医薬支店C
	 * @generated
	 */
	private String reqBrCd;

	/**
	 * 申請者医薬営業所C
	 * @generated
	 */
	private String reqDistCd;

	/**
	 * 申請ステータスコード
	 * @generated
	 */
	private String reqStsCd;

	/**
	 * 審査者従業員番号
	 * @generated
	 */
	private Integer shnJgiNo;

	/**
	 * 承認者従業員番号
	 * @generated
	 */
	private Integer aprJgiNo;

	/**
	 * 更新日時
	 * @generated
	 */
	private String updShaYmd;

	/**
	 * 固定施設C
	 * @generated
	 */
	private String insNo;

	/**
	 * 施設分類
	 * @generated
	 */
	private String insClass;

	/**
	 * 施設種別
	 * @generated
	 */
	private String insSbt;

	/**
	 * 施設略式漢字名
	 * @generated
	 */
	private String insAbbrName;

	/**
	 * 施設カナ名
	 * @generated
	 */
	private String insKana;

	/**
	 * 施設正式漢字名
	 * @generated
	 */
	private String insFormalName;

	/**
	 * 取引区分
	 * @generated
	 */
	private String tradeType;

	/**
	 * 取引区分
	 * @generated
	 */
	private String tradeTypeNm;

	/**
	 * 開業年月日(年)
	 * @generated
	 */
	private String insOpenYear;

	/**
	 * 開業年月日(月)
	 * @generated
	 */
	private String insOpenMonth;

	/**
	 * 開業年月日(日)
	 * @generated
	 */
	private String insOpenDay;

	/**
	 * 施設略式漢字名
	 * @generated
	 */
	private String preInsAbbrName;

	/**
	 * 施設カナ名
	 * @generated
	 */
	private String preInsKana;

	/**
	 * 施設正式漢字名
	 * @generated
	 */
	private String preInsFormalName;

	/**
	 * 取引区分
	 * @generated
	 */
	private String preTradeType;

	/**
	 * 取引区分
	 * @generated
	 */
	private String preTradeTypeNm;

	/**
	 * 開業年月日(年)
	 * @generated
	 */
	private String preInsOpenYear;

	/**
	 * 開業年月日(月)
	 * @generated
	 */
	private String preInsOpenMonth;

	/**
	 * 開業年月日(日)
	 * @generated
	 */
	private String preInsOpenDay;

	/**
	 * 施設区分
	 * @generated
	 */
	private String prePharmType;

	/**
	 * 施設区分
	 * @generated
	 */
	private String prePharmTypeNm;

	/**
	 * 施設区分(来期用)
	 * @generated
	 */
	private String pharmType;

	/**
	 * 施設区分(来期用)
	 * @generated
	 */
	private String pharmTypeNm;

	/**
	 * 階級区分
	 * @generated
	 */
	private String preInsRank;

	/**
	 * 階級区分
	 * @generated
	 */
	private String preInsRankNm;

	/**
	 * 階級区分(来期用)
	 * @generated
	 */
	private String insRank;

	/**
	 * 階級区分(来期用)
	 * @generated
	 */
	private String insRankNm;

	/**
	 * 定訪先区分
	 * @generated
	 */
	private String preRegVisType;

	/**
	 * 定訪先区分
	 * @generated
	 */
	private String preRegVisTypeNm;

	/**
	 * 定訪先区分(来期用)
	 * @generated
	 */
	private String regVisType;

	/**
	 * 定訪先区分(来期用)
	 * @generated
	 */
	private String regVisTypeNm;

	/**
	 * 経営主体
	 * @generated
	 */
	private String preManageCd;

	/**
	 * 経営主体
	 * @generated
	 */
	private String preManageNm;

	/**
	 * 経営主体(来期用)
	 * @generated
	 */
	private String manageCd;

	/**
	 * 経営主体(来期用)
	 * @generated
	 */
	private String manageNm;

	/**
	 * 卸色区分
	 * @generated
	 */
	private String wsType;

	/**
	 * 卸色区分
	 * @generated
	 */
	private String wsTypeNm;

	/**
	 * 本部一括購入
	 * @generated
	 */
	private String basketPurchase;

	/**
	 * 本部一括購入
	 * @generated
	 */
	private String basketPurchaseNm;

	/**
	 * 大学細分類
	 * @generated
	 */
	private String univSubdiv;

	/**
	 * 大学細分類
	 * @generated
	 */
	private String univSubdivNm;

	/**
	 * 容量別実績把握病院区分
	 * @generated
	 */
	private String capaType;

	/**
	 * 容量別実績把握病院区分
	 * @generated
	 */
	private String capaTypeNm;

	/**
	 * 卸色区分
	 * @generated
	 */
	private String preWsType;

	/**
	 * 卸色区分
	 * @generated
	 */
	private String preWsTypeNm;

	/**
	 * 本部一括購入
	 * @generated
	 */
	private String preBasketPurchase;

	/**
	 * 本部一括購入
	 * @generated
	 */
	private String preBasketPurchaseNm;

	/**
	 * 大学細分類
	 * @generated
	 */
	private String preUnivSubdiv;

	/**
	 * 大学細分類
	 * @generated
	 */
	private String preUnivSubdivNm;

	/**
	 * 容量別実績把握病院区分
	 * @generated
	 */
	private String preCapaType;

	/**
	 * 容量別実績把握病院区分
	 * @generated
	 */
	private String preCapaTypeNm;

	/**
	 * ULT施設C
	 * @generated
	 */
	private String ultInsCd;

	/**
	 * ULT施設C
	 * @generated
	 */
	private String preUltInsCd;

	/**
	 * ULT施設略名
	 * @generated
	 */
	private String shisetsuNmRyaku;

	/**
	 * ULT施設略名
	 * @generated
	 */
	private String preShisetsuNmRyaku;

	/**
	 * ULT施設名
	 * @generated
	 */
	private String shisetsuNm;

	/**
	 * ULT施設名
	 * @generated
	 */
	private String preShisetsuNm;

	/**
	 * 病床(基準)
	 * @generated
	 */
	private String bedCntBase;

	/**
	 * 病床数(一般)
	 * @generated
	 */
	private String bedCnt01;

	/**
	 * 病床数(医療療養)
	 * @generated
	 */
	private String bedCnt02;

	/**
	 * 病床数(精神)
	 * @generated
	 */
	private String bedCnt03;

	/**
	 * 病床数(結核)
	 * @generated
	 */
	private String bedCnt04;

	/**
	 * 病床数(感染症)
	 * @generated
	 */
	private String bedCnt05;

	/**
	 * 病床数(介護療養)
	 * @generated
	 */
	private String bedCnt06;

	/**
	 * 病床数(療養)
	 * @generated
	 */
	private String bedCnt07;

	/**
	 * ベッド数計
	 * @generated
	 */
	private String bedsTot;

	/**
	 * 医療ベッド数計
	 * @generated
	 */
	private String medBedsTot;

	/**
	 * 病床(基準)
	 * @generated
	 */
	private String ultBedCntBase;

	/**
	 * 病床数(一般)
	 * @generated
	 */
	private String ultBedCnt01;

	/**
	 * 病床数(医療療養)
	 * @generated
	 */
	private String ultBedCnt02;

	/**
	 * 病床数(精神)
	 * @generated
	 */
	private String ultBedCnt03;

	/**
	 * 病床数(結核)
	 * @generated
	 */
	private String ultBedCnt04;

	/**
	 * 病床数(感染症)
	 * @generated
	 */
	private String ultBedCnt05;

	/**
	 * 病床数(介護療養)
	 * @generated
	 */
	private String ultBedCnt06;

	/**
	 * 病床数(療養)
	 * @generated
	 */
	private String ultBedCnt07;

	/**
	 * ベッド数計
	 * @generated
	 */
	private String ultBedsTot;

	/**
	 * 医療ベッド数計
	 * @generated
	 */
	private String ultMedBedsTot;

	/**
	 * 病床(基準)
	 * @generated
	 */
	private String nextBedCntBase;

	/**
	 * 病床数(一般)
	 * @generated
	 */
	private String nextBedCnt01;

	/**
	 * 病床数(医療療養)
	 * @generated
	 */
	private String nextBedCnt02;

	/**
	 * 病床数(精神)
	 * @generated
	 */
	private String nextBedCnt03;

	/**
	 * 病床数(結核)
	 * @generated
	 */
	private String nextBedCnt04;

	/**
	 * 病床数(感染症)
	 * @generated
	 */
	private String nextBedCnt05;

	/**
	 * 病床数(介護療養)
	 * @generated
	 */
	private String nextBedCnt06;

	/**
	 * 病床数(療養)
	 * @generated
	 */
	private String nextBedCnt07;

	/**
	 * ベッド数計
	 * @generated
	 */
	private String nextBedsTot;

	/**
	 * 医療ベッド数計
	 * @generated
	 */
	private String nextMedBedsTot;

	/**
	 * 郵便番号
	 * @generated
	 */
	private String insPcode;

	/**
	 * 施設住所
	 * @generated
	 */
	private String insAddr;

	/**
	 * 施設住所カナ
	 * @generated
	 */
	private String insAddrKana;

	/**
	 * JIS府県コード
	 * @generated
	 */
	private String addrCodePref;

	/**
	 * JIS府県名
	 * @generated
	 */
	private String addrCodePrefName;

	/**
	 * JIS市区町村コード
	 * @generated
	 */
	private String addrCodeCity;

	/**
	 * JIS市区町村名
	 * @generated
	 */
	private String addrCodeCityName;

	/**
	 * 町名地番
	 * @generated
	 */
	private String insAddrDt;

	/**
	 * 武田市区郡コード
	 * @generated
	 */
	private String tkCityCd;

	/**
	 * 武田市区郡名
	 * @generated
	 */
	private String tkCityName;

	/**
	 * 電話番号1
	 * @generated
	 */
	private String insPhone1;

	/**
	 * 電話番号2
	 * @generated
	 */
	private String insPhone2;

	/**
	 * FAX番号1
	 * @generated
	 */
	private String insFax1;

	/**
	 * FAX番号2
	 * @generated
	 */
	private String insFax2;

	/**
	 * ホームページアドレス
	 * @generated
	 */
	private String insUrl;

	/**
	 * ホームページアドレス最終更新日
	 * @generated
	 */
	private String insUrlYmd;

	/**
	 * DM先(TKP-LDA)
	 * @generated
	 */
	private String free0001;

	/**
	 * LEUあすか
	 * @generated
	 */
	private String free0002;

	/**
	 * DM先(TKP-NSAID)
	 * @generated
	 */
	private String free0003;

	/**
	 * (O:未使用)
	 * @generated
	 */
	private String free0015;

	/**
	 * TRIアロ登録(当期)
	 * @generated
	 */
	private String free0008;

	/**
	 TRIアロ登録(来期)
	 * @generated
	 */
	private String free0009;

	/**
	 * REMアロ登録(当期)
	 * @generated
	 */
	private String free0004;

	/**
	 * REMアロ登録(来期)
	 * @generated
	 */
	private String free0005;

	/**
	 * ENBアロ登録(当期)
	 * @generated
	 */
	private String free0006;

	/**
	 * ENBアロ登録(来期)
	 * @generated
	 */
	private String free0007;

	/**
	 * XELアロ登録(当期)
	 * @generated
	 */
	private String free0010;

	/**
	 * XELアロ登録(来期)
	 * @generated
	 */
	private String free0011;

	/**
	 * ROZアロ登録(当期)
	 * @generated
	 */
	private String free0013;

	/**
	 * ROZアロ登録(来期)
	 * @generated
	 */
	private String free0014;

	/**
	 * 振替先1310
	 * @generated
	 */
	private String free0012;

	/**
	 * 老人福祉法施設区分(老人短期入所施設)
	 * @generated
	 */
	private String welfare02;

	/**
	 * 老人福祉法施設区分(老人短期入所施設)
	 * @generated
	 */
	private String welfare02Nm;

	/**
	 * 老人福祉法施設区分(その他)
	 * @generated
	 */
	private String welfare08Nm;

	/**
	 * 老人福祉法施設区分(その他)
	 * @generated
	 */
	private String welfare08;

	/**
	 * En-T ARB ('18.11)
	 * @generated
	 */
	private String result01;

	/**
	 * En-T DPP4 ('18.11)
	 * @generated
	 */
	private String result02;

	/**
	 * En-T ω3 ('18.11)
	 * @generated
	 */
	private String result03;

	/**
	 * En-T PPI ('18.11)
	 * @generated
	 */
	private String result04;

	/**
	 * En-T 睡眠 ('18.11)
	 * @generated
	 */
	private String result05;

	/**
	 * En-T アルツハイマー ('18.11)
	 * @generated
	 */
	private String result06;

	/**
	 * En-T 骨粗鬆症 ('18.11)
	 * @generated
	 */
	private String result07;

	/**
	 * REMターゲット
	 * @generated
	 */
	private String result08;

	/**
	 * BLP未獲得市場区分
	 * @generated
	 */
	private String result09;

	/**
	 * 整形育成先
	 * @generated
	 */
	private String result10;

	/**
	 * TKP・MSコールUP
	 * @generated
	 */
	private String result11;

	/**
	 * ALC Core1・2('19.10)
	 * @generated
	 */
	private String result12;

	/**
	 * ENT Tier1-4('19.4)
	 * @generated
	 */
	private String result13;

	/**
	 * JIA厚労省施設
	 * @generated
	 */
	private String result14;

	/**
	 * 注力先('18.12)
	 * @generated
	 */
	private String result15;

	/**
	 * ENBターゲット先('19.4)
	 * @generated
	 */
	private String result16;

	/**
	 * 骨G
	 * @generated
	 */
	private String result17;

	/**
	 * ナテグリニド繁用先
	 * @generated
	 */
	private String result18;

	/**
	 * GLUターゲット先
	 * @generated
	 */
	private String result19;

	/**
	 * 骨G2
	 * @generated
	 */
	private String result20;

	/**
	 * (U:未使用)
	 * @generated
	 */
	private String result21;

	/**
	 * DOIT3
	 * @generated
	 */
	private String result22;

	/**
	 * PCI300
	 * @generated
	 */
	private String result23;

	/**
	 * JDEsART
	 * @generated
	 */
	private String result24;

	/**
	 * (Y:未使用)
	 * @generated
	 */
	private String result25;

	/**
	 * TAP先
	 * @generated
	 */
	private String result26;

	/**
	 * QOL2005TKP
	 * @generated
	 */
	private String result27;

	/**
	 * TKP未獲得市場区分
	 * @generated
	 */
	private String result28;

	/**
	 * ACT未獲得市場区分
	 * @generated
	 */
	private String result29;

	/**
	 * (4:未使用)
	 * @generated
	 */
	private String result30;

	/**
	 * 旧LMR
	 * @generated
	 */
	private String result31;

	/**
	 * (6:未使用)
	 * @generated
	 */
	private String result32;

	/**
	 * LEU乳癌
	 * @generated
	 */
	private String result33;

	/**
	 * ONC担当区分
	 * @generated
	 */
	private String result34;

	/**
	 * RPL(CVM)担当区分
	 * @generated
	 */
	private String result35;

	/**
	 * (10:未使用)
	 * @generated
	 */
	private String result36;

	/**
	 * En-T ARB ('18.11)
	 * @generated
	 */
	private String result01Nm;

	/**
	 * En-T DPP4 ('18.11)
	 * @generated
	 */
	private String result02Nm;

	/**
	 * En-T ω3 ('18.11)
	 * @generated
	 */
	private String result03Nm;

	/**
	 * En-T PPI ('18.11)
	 * @generated
	 */
	private String result04Nm;

	/**
	 * En-T 睡眠 ('18.11)
	 * @generated
	 */
	private String result05Nm;

	/**
	 * En-T アルツハイマー ('18.11)
	 * @generated
	 */
	private String result06Nm;

	/**
	 * En-T 骨粗鬆症 ('18.11)
	 * @generated
	 */
	private String result07Nm;

	/**
	 * REMターゲット
	 * @generated
	 */
	private String result08Nm;

	/**
	 * BLP未獲得市場区分
	 * @generated
	 */
	private String result09Nm;

	/**
	 * 整形育成先
	 * @generated
	 */
	private String result10Nm;

	/**
	 * TKP・MSコールUP
	 * @generated
	 */
	private String result11Nm;

	/**
	 * ALC Core1・2('19.10)
	 * @generated
	 */
	private String result12Nm;

	/**
	 * ENT Tier1-4('19.4)
	 * @generated
	 */
	private String result13Nm;

	/**
	 * JIA厚労省施設
	 * @generated
	 */
	private String result14Nm;

	/**
	 * 注力先('18.12)
	 * @generated
	 */
	private String result15Nm;

	/**
	 * ENBターゲット先('19.4)
	 * @generated
	 */
	private String result16Nm;

	/**
	 * 骨G
	 * @generated
	 */
	private String result17Nm;

	/**
	 * ナテグリニド繁用先
	 * @generated
	 */
	private String result18Nm;

	/**
	 * GLUターゲット先
	 * @generated
	 */
	private String result19Nm;

	/**
	 * 骨G2
	 * @generated
	 */
	private String result20Nm;

	/**
	 * (U:未使用)
	 * @generated
	 */
	private String result21Nm;

	/**
	 * DOIT3
	 * @generated
	 */
	private String result22Nm;

	/**
	 * PCI300
	 * @generated
	 */
	private String result23Nm;

	/**
	 * JDEsART
	 * @generated
	 */
	private String result24Nm;

	/**
	 * (Y:未使用)
	 * @generated
	 */
	private String result25Nm;

	/**
	 * TAP先
	 * @generated
	 */
	private String result26Nm;

	/**
	 * QOL2005TKP
	 * @generated
	 */
	private String result27Nm;

	/**
	 * TKP未獲得市場区分
	 * @generated
	 */
	private String result28Nm;

	/**
	 * ACT未獲得市場区分
	 * @generated
	 */
	private String result29Nm;

	/**
	 * (4:未使用)
	 * @generated
	 */
	private String result30Nm;

	/**
	 * 旧LMR
	 * @generated
	 */
	private String result31Nm;

	/**
	 * (6:未使用)
	 * @generated
	 */
	private String result32Nm;

	/**
	 * LEU乳癌
	 * @generated
	 */
	private String result33Nm;

	/**
	 * ONC担当区分
	 * @generated
	 */
	private String result34Nm;

	/**
	 * RPL(CVM)担当区分
	 * @generated
	 */
	private String result35Nm;

	/**
	 * (10:未使用)
	 * @generated
	 */
	private String result36Nm;

	/**
	 * 内視鏡
	 * @generated
	 */
	private String equip01;

	/**
	 * 骨量測定器
	 * @generated
	 */
	private String equip02;

	/**
	 * ICD
	 * @generated
	 */
	private String equip03;

	/**
	 * CCU
	 * @generated
	 */
	private String equip07;

	/**
	 * NCU
	 * @generated
	 */
	private String equip09;

	/**
	 * 内視鏡
	 * @generated
	 */
	private String equip01Nm;

	/**
	 * 骨量測定器
	 * @generated
	 */
	private String equip02Nm;

	/**
	 * ICD
	 * @generated
	 */
	private String equip03Nm;

	/**
	 * CCU
	 * @generated
	 */
	private String equip07Nm;

	/**
	 * NCU
	 * @generated
	 */
	private String equip09Nm;

	/**
	 * T先
	 * @generated
	 */
	private String market01;

	/**
	 * 酸抑制剤
	 * @generated
	 */
	private String market02;

	/**
	 * 高脂血症
	 * @generated
	 */
	private String market03;

	/**
	 * 高血圧
	 * @generated
	 */
	private String market04;

	/**
	 * 糖尿病
	 * @generated
	 */
	private String market06;

	/**
	 * 骨粗鬆症
	 * @generated
	 */
	private String market07;

	/**
	 * CVMターゲット
	 * @generated
	 */
	private String market09;

	/**
	 * T先
	 * @generated
	 */
	private String market01Nm;

	/**
	 * 酸抑制剤
	 * @generated
	 */
	private String market02Nm;

	/**
	 * 高脂血症
	 * @generated
	 */
	private String market03Nm;

	/**
	 * 高血圧
	 * @generated
	 */
	private String market04Nm;

	/**
	 * 糖尿病
	 * @generated
	 */
	private String market06Nm;

	/**
	 * 骨粗鬆症
	 * @generated
	 */
	private String market07Nm;

	/**
	 * CVMターゲット
	 * @generated
	 */
	private String market09Nm;

	/**
	 * 社会医療法人
	 * @generated
	 */
	private String medical12;

	/**
	 * 社会医療法人
	 * @generated
	 */
	private String medical12Nm;

	/**
	 * 入院包括化実施病院
	 * @generated
	 */
	private String spfunc01;

	/**
	 * 救命救急センター
	 * @generated
	 */
	private String spfunc03;

	/**
	 * 大学院大学
	 * @generated
	 */
	private String spfunc04;

	/**
	 * 入院包括化実施病院
	 * @generated
	 */
	private String spfunc01Nm;

	/**
	 * 救命救急センター
	 * @generated
	 */
	private String spfunc03Nm;

	/**
	 * 大学院大学
	 * @generated
	 */
	private String spfunc04Nm;

	/**
	 * がん連携パス
	 * @generated
	 */
	private String tieup10;

	/**
	 * 心疾患連携パス
	 * @generated
	 */
	private String tieup11;

	/**
	 * 糖尿病連携パス
	 * @generated
	 */
	private String tieup12;

	/**
	 * がん連携パス
	 * @generated
	 */
	private String tieup10Nm;

	/**
	 * 心疾患連携パス
	 * @generated
	 */
	private String tieup11Nm;

	/**
	 * 糖尿病連携パス
	 * @generated
	 */
	private String tieup12Nm;

	/**
	 * (A:未使用)
	 * @generated
	 */
	private String usercd0001;

	/**
	 * VCT・V先
	 * @generated
	 */
	private String usercd0002;

	/**
	 * (C:未使用)
	 * @generated
	 */
	private String usercd0003;

	/**
	 * NEXアーリーアダプタ
	 * @generated
	 */
	private String usercd0004;

	/**
	 * (E:未使用)
	 * @generated
	 */
	private String usercd0005;

	/**
	 * テルモ・コプロ
	 * @generated
	 */
	private String usercd0006;

	/**
	 * (G:未使用)
	 * @generated
	 */
	private String usercd0007;

	/**
	 * リュープリン・コプロ12/10
	 * @generated
	 */
	private String usercd0008;

	/**
	 * アクトス・コプロ
	 * @generated
	 */
	private String usercd0009;

	/**
	 * ベネット・コプロ
	 * @generated
	 */
	private String usercd0010;

	/**
	 * グルファスト
	 * @generated
	 */
	private String usercd0011;

	/**
	 * リュープリンコプロ08/10
	 * @generated
	 */
	private String usercd0012;

	/**
	 * (M:未使用)
	 * @generated
	 */
	private String usercd0013;

	/**
	 * COP活動先
	 * @generated
	 */
	private String usercd0014;

	/**
	 * ω3製剤市場
	 * @generated
	 */
	private String usercd0015;

	/**
	 * TCB RW在籍施設
	 * @generated
	 */
	private String usercd0016;

	/**
	 * DPP4アーリーアダプタ
	 * @generated
	 */
	private String usercd0017;

	/**
	 * DPP4阻害薬('16.2)
	 * @generated
	 */
	private String usercd0018;

	/**
	 * DPP4阻害薬市場
	 * @generated
	 */
	private String usercd0019;

	/**
	 * ARB/CCB配合剤市場
	 * @generated
	 */
	private String usercd0020;

	/**
	 * 抗潰瘍(PPI)市場
	 * @generated
	 */
	private String usercd0021;

	/**
	 * 骨粗鬆症市場
	 * @generated
	 */
	private String usercd0022;

	/**
	 * 睡眠市場
	 * @generated
	 */
	private String usercd0023;

	/**
	 * X雑・災害
	 * @generated
	 */
	private String usercd0024;

	/**
	 * アルツハイマー市場
	 * @generated
	 */
	private String usercd0025;

	/**
	 * ARB総市場
	 * @generated
	 */
	private String usercd0026;

	/**
	 * 施設責任者
	 * @generated
	 */
	private String usercd0027;

	/**
	 * タケプロン・コプロ
	 * @generated
	 */
	private String usercd0028;

	/**
	 * 抗潰瘍(PPI)市場('16.6)
	 * @generated
	 */
	private String usercd0029;

	/**
	 * (4:未使用)
	 * @generated
	 */
	private String usercd0030;

	/**
	 * インフル・セオリア
	 * @generated
	 */
	private String usercd0031;

	/**
	 * インフル・あすか
	 * @generated
	 */
	private String usercd0032;

	/**
	 * マーケティングG・T
	 * @generated
	 */
	private String usercd0033;

	/**
	 * (8:未使用)
	 * @generated
	 */
	private String usercd0034;

	/**
	 * セルタッチ・ベネット
	 * @generated
	 */
	private String usercd0035;

	/**
	 * (10:未使用)
	 * @generated
	 */
	private String usercd0036;

	/**
	 * (A:未使用)
	 * @generated
	 */
	private String usercd0001Nm;

	/**
	 * VCT・V先
	 * @generated
	 */
	private String usercd0002Nm;

	/**
	 * (C:未使用)
	 * @generated
	 */
	private String usercd0003Nm;

	/**
	 * NEXアーリーアダプタ
	 * @generated
	 */
	private String usercd0004Nm;

	/**
	 * (E:未使用)
	 * @generated
	 */
	private String usercd0005Nm;

	/**
	 * テルモ・コプロ
	 * @generated
	 */
	private String usercd0006Nm;

	/**
	 * (G:未使用)
	 * @generated
	 */
	private String usercd0007Nm;

	/**
	 * リュープリン・コプロ12/10
	 * @generated
	 */
	private String usercd0008Nm;

	/**
	 * アクトス・コプロ
	 * @generated
	 */
	private String usercd0009Nm;

	/**
	 * ベネット・コプロ
	 * @generated
	 */
	private String usercd0010Nm;

	/**
	 * グルファスト
	 * @generated
	 */
	private String usercd0011Nm;

	/**
	 * リュープリンコプロ08/10
	 * @generated
	 */
	private String usercd0012Nm;

	/**
	 * (M:未使用)
	 * @generated
	 */
	private String usercd0013Nm;

	/**
	 * COP活動先
	 * @generated
	 */
	private String usercd0014Nm;

	/**
	 * ω3製剤市場
	 * @generated
	 */
	private String usercd0015Nm;

	/**
	 * TCB RW在籍施設
	 * @generated
	 */
	private String usercd0016Nm;

	/**
	 * DPP4アーリーアダプタ
	 * @generated
	 */
	private String usercd0017Nm;

	/**
	 * DPP4阻害薬('16.2)
	 * @generated
	 */
	private String usercd0018Nm;

	/**
	 * DPP4阻害薬市場
	 * @generated
	 */
	private String usercd0019Nm;

	/**
	 * ARB/CCB配合剤市場
	 * @generated
	 */
	private String usercd0020Nm;

	/**
	 * 抗潰瘍(PPI)市場
	 * @generated
	 */
	private String usercd0021Nm;

	/**
	 * 骨粗鬆症市場
	 * @generated
	 */
	private String usercd0022Nm;

	/**
	 * 睡眠市場
	 * @generated
	 */
	private String usercd0023Nm;

	/**
	 * X雑・災害
	 * @generated
	 */
	private String usercd0024Nm;

	/**
	 * アルツハイマー市場
	 * @generated
	 */
	private String usercd0025Nm;

	/**
	 * ARB総市場
	 * @generated
	 */
	private String usercd0026Nm;

	/**
	 * 施設責任者
	 * @generated
	 */
	private String usercd0027Nm;

	/**
	 * タケプロン・コプロ
	 * @generated
	 */
	private String usercd0028Nm;

	/**
	 * 抗潰瘍(PPI)市場('16.6)
	 * @generated
	 */
	private String usercd0029Nm;

	/**
	 * (4:未使用)
	 * @generated
	 */
	private String usercd0030Nm;

	/**
	 * インフル・セオリア
	 * @generated
	 */
	private String usercd0031Nm;

	/**
	 * インフル・あすか
	 * @generated
	 */
	private String usercd0032Nm;

	/**
	 * マーケティングG・T
	 * @generated
	 */
	private String usercd0033Nm;

	/**
	 * (8:未使用)
	 * @generated
	 */
	private String usercd0034Nm;

	/**
	 * セルタッチ・ベネット
	 * @generated
	 */
	private String usercd0035Nm;

	/**
	 * (10:未使用)
	 * @generated
	 */
	private String usercd0036Nm;

	/**
	 * A(支店)
	 * @generated
	 */
	private String usercd0101;

	/**
	 * B(支店)
	 * @generated
	 */
	private String usercd0102;

	/**
	 * C(支店)
	 * @generated
	 */
	private String usercd0103;

	/**
	 * D(支店)
	 * @generated
	 */
	private String usercd0104;

	/**
	 * E(支店)
	 * @generated
	 */
	private String usercd0105;

	/**
	 * F(支店)
	 * @generated
	 */
	private String usercd0106;

	/**
	 * G(支店)
	 * @generated
	 */
	private String usercd0107;

	/**
	 * H(支店)
	 * @generated
	 */
	private String usercd0108;

	/**
	 * I(支店)
	 * @generated
	 */
	private String usercd0109;

	/**
	 * A(営業所)
	 * @generated
	 */
	private String usercd0201;

	/**
	 * LEUターゲット先
	 * @generated
	 */
	private String usercd0202;

	/**
	 * C(営業所)
	 * @generated
	 */
	private String usercd0203;

	/**
	 * 次期院長ターゲット先
	 * @generated
	 */
	private String usercd0204;

	/**
	 * E(営業所)
	 * @generated
	 */
	private String usercd0205;

	/**
	 * F:なんでもフォロー表
	 * @generated
	 */
	private String usercd0206;

	/**
	 * 入院診療計画
	 * @generated
	 */
	private String reward04;

	/**
	 * 院内感染防止対策
	 * @generated
	 */
	private String reward05;

	/**
	 * 地域連携小児夜間・休日診療料1
	 * @generated
	 */
	private String reward08;

	/**
	 * 小児入院医療管理料
	 * @generated
	 */
	private String reward09;

	/**
	 * 緩和ケア診療加算
	 * @generated
	 */
	private String reward18;

	/**
	 * 短期滞在手術基本料
	 * @generated
	 */
	private String reward21;

	/**
	 * 在宅患者訪問診療料又は在総診
	 * @generated
	 */
	private String reward23;

	/**
	 * 生活習慣病指導管理料
	 * @generated
	 */
	private String reward25;

	/**
	 * 慢性疼痛疾患管理料
	 * @generated
	 */
	private String reward26;

	/**
	 * 看護配置(有床診療所)
	 * @generated
	 */
	private String reward27;

	/**
	 * 老人入院基本料
	 * @generated
	 */
	private String reward29;

	/**
	 * 地域連携時間外診療(有無)
	 * @generated
	 */
	private String reward35;

	/**
	 * 地域連携診療計画管理料
	 * @generated
	 */
	private String reward36;

	/**
	 * 地域連携診療計画退院時指導料
	 * @generated
	 */
	private String reward37;

	/**
	 * 病理診断料
	 * @generated
	 */
	private String reward44;

	/**
	 * 急性期入院加算
	 * @generated
	 */
	private String reward16;

	/**
	 * 急性期特定入院加算
	 * @generated
	 */
	private String reward17;

	/**
	 * 入院診療計画
	 * @generated
	 */
	private String reward04Nm;

	/**
	 * 院内感染防止対策
	 * @generated
	 */
	private String reward05Nm;

	/**
	 * 地域連携小児夜間・休日診療料1
	 * @generated
	 */
	private String reward08Nm;

	/**
	 * 小児入院医療管理料
	 * @generated
	 */
	private String reward09Nm;

	/**
	 * 緩和ケア診療加算
	 * @generated
	 */
	private String reward18Nm;

	/**
	 * 短期滞在手術基本料
	 * @generated
	 */
	private String reward21Nm;

	/**
	 * 在宅患者訪問診療料又は在総診
	 * @generated
	 */
	private String reward23Nm;

	/**
	 * 生活習慣病指導管理料
	 * @generated
	 */
	private String reward25Nm;

	/**
	 * 慢性疼痛疾患管理料
	 * @generated
	 */
	private String reward26Nm;

	/**
	 * 看護配置(有床診療所)
	 * @generated
	 */
	private String reward27Nm;

	/**
	 * 老人入院基本料
	 * @generated
	 */
	private String reward29Nm;

	/**
	 * 地域連携時間外診療(有無)
	 * @generated
	 */
	private String reward35Nm;

	/**
	 * 地域連携診療計画管理料
	 * @generated
	 */
	private String reward36Nm;

	/**
	 * 地域連携診療計画退院時指導料
	 * @generated
	 */
	private String reward37Nm;

	/**
	 * 病理診断料
	 * @generated
	 */
	private String reward44Nm;

	/**
	 * 急性期入院加算
	 * @generated
	 */
	private String reward16Nm;

	/**
	 * 急性期特定入院加算
	 * @generated
	 */
	private String reward17Nm;

	/**
	 * 郵便番号
	 * @generated
	 */
	private String preInsPcode;

	/**
	 * 施設住所
	 * @generated
	 */
	private String preInsAddr;

	/**
	 * 施設住所カナ
	 * @generated
	 */
	private String preInsAddrKana;

	/**
	 * JIS府県コード
	 * @generated
	 */
	private String preAddrCodePref;

	/**
	 * JIS府県名
	 * @generated
	 */
	private String preAddrCodePrefName;

	/**
	 * JIS市区町村コード
	 * @generated
	 */
	private String preAddrCodeCity;

	/**
	 * JIS市区町村名
	 * @generated
	 */
	private String preAddrCodeCityName;

	/**
	 * 町名地番
	 * @generated
	 */
	private String preInsAddrDt;

	/**
	 * 武田市区郡コード
	 * @generated
	 */
	private String preTkCityCd;

	/**
	 * 武田市区郡名
	 * @generated
	 */
	private String preTkCityName;

	/**
	 * 電話番号1
	 * @generated
	 */
	private String preInsPhone1;

	/**
	 * 電話番号2
	 * @generated
	 */
	private String preInsPhone2;

	/**
	 * FAX番号1
	 * @generated
	 */
	private String preInsFax1;

	/**
	 * FAX番号2
	 * @generated
	 */
	private String preInsFax2;

	/**
	 * ホームページアドレス
	 * @generated
	 */
	private String preInsUrl;

	/**
	 * ホームページアドレス最終更新日
	 * @generated
	 */
	private String preInsUrlYmd;

	/**
	 * DM先(TKP-LDA)
	 * @generated
	 */
	private String preFree0001;

	/**
	 * LEUあすか
	 * @generated
	 */
	private String preFree0002;

	/**
	 * DM先(TKP-NSAID)
	 * @generated
	 */
	private String preFree0003;

	/**
	 * (O:未使用)
	 * @generated
	 */
	private String preFree0015;

	/**
	 * TRIアロ登録(当期)
	 * @generated
	 */
	private String preFree0008;

	/**
	 TRIアロ登録(来期)
	 * @generated
	 */
	private String preFree0009;

	/**
	 * REMアロ登録(当期)
	 * @generated
	 */
	private String preFree0004;

	/**
	 * REMアロ登録(来期)
	 * @generated
	 */
	private String preFree0005;

	/**
	 * ENBアロ登録(当期)
	 * @generated
	 */
	private String preFree0006;

	/**
	 * ENBアロ登録(来期)
	 * @generated
	 */
	private String preFree0007;

	/**
	 * XELアロ登録(当期)
	 * @generated
	 */
	private String preFree0010;

	/**
	 * XELアロ登録(来期)
	 * @generated
	 */
	private String preFree0011;

	/**
	 * ROZアロ登録(当期)
	 * @generated
	 */
	private String preFree0013;

	/**
	 * ROZアロ登録(来期)
	 * @generated
	 */
	private String preFree0014;

	/**
	 * 振替先1310
	 * @generated
	 */
	private String preFree0012;

	/**
	 * 老人福祉法施設区分(老人短期入所施設)
	 * @generated
	 */
	private String preWelfare02;

	/**
	 * 老人福祉法施設区分(老人短期入所施設)
	 * @generated
	 */
	private String preWelfare02Nm;

	/**
	 * 老人福祉法施設区分(その他)
	 * @generated
	 */
	private String preWelfare08Nm;

	/**
	 * 老人福祉法施設区分(その他)
	 * @generated
	 */
	private String preWelfare08;

	/**
	 * En-T ARB ('18.11)
	 * @generated
	 */
	private String preResult01;

	/**
	 * En-T DPP4 ('18.11)
	 * @generated
	 */
	private String preResult02;

	/**
	 * En-T ω3 ('18.11)
	 * @generated
	 */
	private String preResult03;

	/**
	 * En-T PPI ('18.11)
	 * @generated
	 */
	private String preResult04;

	/**
	 * En-T 睡眠 ('18.11)
	 * @generated
	 */
	private String preResult05;

	/**
	 * En-T アルツハイマー ('18.11)
	 * @generated
	 */
	private String preResult06;

	/**
	 * En-T 骨粗鬆症 ('18.11)
	 * @generated
	 */
	private String preResult07;

	/**
	 * REMターゲット
	 * @generated
	 */
	private String preResult08;

	/**
	 * BLP未獲得市場区分
	 * @generated
	 */
	private String preResult09;

	/**
	 * 整形育成先
	 * @generated
	 */
	private String preResult10;

	/**
	 * TKP・MSコールUP
	 * @generated
	 */
	private String preResult11;

	/**
	 * ALC Core1・2('19.10)
	 * @generated
	 */
	private String preResult12;

	/**
	 * ENT Tier1-4('19.4)
	 * @generated
	 */
	private String preResult13;

	/**
	 * JIA厚労省施設
	 * @generated
	 */
	private String preResult14;

	/**
	 * 注力先('18.12)
	 * @generated
	 */
	private String preResult15;

	/**
	 * ENBターゲット先('19.4)
	 * @generated
	 */
	private String preResult16;

	/**
	 * 骨G
	 * @generated
	 */
	private String preResult17;

	/**
	 * ナテグリニド繁用先
	 * @generated
	 */
	private String preResult18;

	/**
	 * GLUターゲット先
	 * @generated
	 */
	private String preResult19;

	/**
	 * 骨G2
	 * @generated
	 */
	private String preResult20;

	/**
	 * (U:未使用)
	 * @generated
	 */
	private String preResult21;

	/**
	 * DOIT3
	 * @generated
	 */
	private String preResult22;

	/**
	 * PCI300
	 * @generated
	 */
	private String preResult23;

	/**
	 * JDEsART
	 * @generated
	 */
	private String preResult24;

	/**
	 * (Y:未使用)
	 * @generated
	 */
	private String preResult25;

	/**
	 * TAP先
	 * @generated
	 */
	private String preResult26;

	/**
	 * QOL2005TKP
	 * @generated
	 */
	private String preResult27;

	/**
	 * TKP未獲得市場区分
	 * @generated
	 */
	private String preResult28;

	/**
	 * ACT未獲得市場区分
	 * @generated
	 */
	private String preResult29;

	/**
	 * (4:未使用)
	 * @generated
	 */
	private String preResult30;

	/**
	 * 旧LMR
	 * @generated
	 */
	private String preResult31;

	/**
	 * (6:未使用)
	 * @generated
	 */
	private String preResult32;

	/**
	 * LEU乳癌
	 * @generated
	 */
	private String preResult33;

	/**
	 * ONC担当区分
	 * @generated
	 */
	private String preResult34;

	/**
	 * RPL(CVM)担当区分
	 * @generated
	 */
	private String preResult35;

	/**
	 * (10:未使用)
	 * @generated
	 */
	private String preResult36;

	/**
	 * En-T ARB ('18.11)
	 * @generated
	 */
	private String preResult01Nm;

	/**
	 * En-T DPP4 ('18.11)
	 * @generated
	 */
	private String preResult02Nm;

	/**
	 * En-T ω3 ('18.11)
	 * @generated
	 */
	private String preResult03Nm;

	/**
	 * En-T PPI ('18.11)
	 * @generated
	 */
	private String preResult04Nm;

	/**
	 * En-T 睡眠 ('18.11)
	 * @generated
	 */
	private String preResult05Nm;

	/**
	 * En-T アルツハイマー ('18.11)
	 * @generated
	 */
	private String preResult06Nm;

	/**
	 * En-T 骨粗鬆症 ('18.11)
	 * @generated
	 */
	private String preResult07Nm;

	/**
	 * REMターゲット
	 * @generated
	 */
	private String preResult08Nm;

	/**
	 * BLP未獲得市場区分
	 * @generated
	 */
	private String preResult09Nm;

	/**
	 * 整形育成先
	 * @generated
	 */
	private String preResult10Nm;

	/**
	 * TKP・MSコールUP
	 * @generated
	 */
	private String preResult11Nm;

	/**
	 * ALC Core1・2('19.10)
	 * @generated
	 */
	private String preResult12Nm;

	/**
	 * ENT Tier1-4('19.4)
	 * @generated
	 */
	private String preResult13Nm;

	/**
	 * JIA厚労省施設
	 * @generated
	 */
	private String preResult14Nm;

	/**
	 * 注力先('18.12)
	 * @generated
	 */
	private String preResult15Nm;

	/**
	 * ENBターゲット先('19.4)
	 * @generated
	 */
	private String preResult16Nm;

	/**
	 * 骨G
	 * @generated
	 */
	private String preResult17Nm;

	/**
	 * ナテグリニド繁用先
	 * @generated
	 */
	private String preResult18Nm;

	/**
	 * GLUターゲット先
	 * @generated
	 */
	private String preResult19Nm;

	/**
	 * 骨G2
	 * @generated
	 */
	private String preResult20Nm;

	/**
	 * (U:未使用)
	 * @generated
	 */
	private String preResult21Nm;

	/**
	 * DOIT3
	 * @generated
	 */
	private String preResult22Nm;

	/**
	 * PCI300
	 * @generated
	 */
	private String preResult23Nm;

	/**
	 * JDEsART
	 * @generated
	 */
	private String preResult24Nm;

	/**
	 * (Y:未使用)
	 * @generated
	 */
	private String preResult25Nm;

	/**
	 * TAP先
	 * @generated
	 */
	private String preResult26Nm;

	/**
	 * QOL2005TKP
	 * @generated
	 */
	private String preResult27Nm;

	/**
	 * TKP未獲得市場区分
	 * @generated
	 */
	private String preResult28Nm;

	/**
	 * ACT未獲得市場区分
	 * @generated
	 */
	private String preResult29Nm;

	/**
	 * (4:未使用)
	 * @generated
	 */
	private String preResult30Nm;

	/**
	 * 旧LMR
	 * @generated
	 */
	private String preResult31Nm;

	/**
	 * (6:未使用)
	 * @generated
	 */
	private String preResult32Nm;

	/**
	 * LEU乳癌
	 * @generated
	 */
	private String preResult33Nm;

	/**
	 * ONC担当区分
	 * @generated
	 */
	private String preResult34Nm;

	/**
	 * RPL(CVM)担当区分
	 * @generated
	 */
	private String preResult35Nm;

	/**
	 * (10:未使用)
	 * @generated
	 */
	private String preResult36Nm;

	/**
	 * 内視鏡
	 * @generated
	 */
	private String preEquip01;

	/**
	 * 骨量測定器
	 * @generated
	 */
	private String preEquip02;

	/**
	 * ICD
	 * @generated
	 */
	private String preEquip03;

	/**
	 * CCU
	 * @generated
	 */
	private String preEquip07;

	/**
	 * NCU
	 * @generated
	 */
	private String preEquip09;

	/**
	 * 内視鏡
	 * @generated
	 */
	private String preEquip01Nm;

	/**
	 * 骨量測定器
	 * @generated
	 */
	private String preEquip02Nm;

	/**
	 * ICD
	 * @generated
	 */
	private String preEquip03Nm;

	/**
	 * CCU
	 * @generated
	 */
	private String preEquip07Nm;

	/**
	 * NCU
	 * @generated
	 */
	private String preEquip09Nm;

	/**
	 * T先
	 * @generated
	 */
	private String preMarket01;

	/**
	 * 酸抑制剤
	 * @generated
	 */
	private String preMarket02;

	/**
	 * 高脂血症
	 * @generated
	 */
	private String preMarket03;

	/**
	 * 高血圧
	 * @generated
	 */
	private String preMarket04;

	/**
	 * 糖尿病
	 * @generated
	 */
	private String preMarket06;

	/**
	 * 骨粗鬆症
	 * @generated
	 */
	private String preMarket07;

	/**
	 * CVMターゲット
	 * @generated
	 */
	private String preMarket09;

	/**
	 * T先
	 * @generated
	 */
	private String preMarket01Nm;

	/**
	 * 酸抑制剤
	 * @generated
	 */
	private String preMarket02Nm;

	/**
	 * 高脂血症
	 * @generated
	 */
	private String preMarket03Nm;

	/**
	 * 高血圧
	 * @generated
	 */
	private String preMarket04Nm;

	/**
	 * 糖尿病
	 * @generated
	 */
	private String preMarket06Nm;

	/**
	 * 骨粗鬆症
	 * @generated
	 */
	private String preMarket07Nm;

	/**
	 * CVMターゲット
	 * @generated
	 */
	private String preMarket09Nm;

	/**
	 * 社会医療法人
	 * @generated
	 */
	private String preMedical12;

	/**
	 * 社会医療法人
	 * @generated
	 */
	private String preMedical12Nm;

	/**
	 * 入院包括化実施病院
	 * @generated
	 */
	private String preSpfunc01;

	/**
	 * 救命救急センター
	 * @generated
	 */
	private String preSpfunc03;

	/**
	 * 大学院大学
	 * @generated
	 */
	private String preSpfunc04;

	/**
	 * 入院包括化実施病院
	 * @generated
	 */
	private String preSpfunc01Nm;

	/**
	 * 救命救急センター
	 * @generated
	 */
	private String preSpfunc03Nm;

	/**
	 * 大学院大学
	 * @generated
	 */
	private String preSpfunc04Nm;

	/**
	 * がん連携パス
	 * @generated
	 */
	private String preTieup10;

	/**
	 * 心疾患連携パス
	 * @generated
	 */
	private String preTieup11;

	/**
	 * 糖尿病連携パス
	 * @generated
	 */
	private String preTieup12;

	/**
	 * がん連携パス
	 * @generated
	 */
	private String preTieup10Nm;

	/**
	 * 心疾患連携パス
	 * @generated
	 */
	private String preTieup11Nm;

	/**
	 * 糖尿病連携パス
	 * @generated
	 */
	private String preTieup12Nm;

	/**
	 * (A:未使用)
	 * @generated
	 */
	private String preUsercd0001;

	/**
	 * VCT・V先
	 * @generated
	 */
	private String preUsercd0002;

	/**
	 * (C:未使用)
	 * @generated
	 */
	private String preUsercd0003;

	/**
	 * NEXアーリーアダプタ
	 * @generated
	 */
	private String preUsercd0004;

	/**
	 * (E:未使用)
	 * @generated
	 */
	private String preUsercd0005;

	/**
	 * テルモ・コプロ
	 * @generated
	 */
	private String preUsercd0006;

	/**
	 * (G:未使用)
	 * @generated
	 */
	private String preUsercd0007;

	/**
	 * リュープリン・コプロ12/10
	 * @generated
	 */
	private String preUsercd0008;

	/**
	 * アクトス・コプロ
	 * @generated
	 */
	private String preUsercd0009;

	/**
	 * ベネット・コプロ
	 * @generated
	 */
	private String preUsercd0010;

	/**
	 * グルファスト
	 * @generated
	 */
	private String preUsercd0011;

	/**
	 * リュープリンコプロ08/10
	 * @generated
	 */
	private String preUsercd0012;

	/**
	 * (M:未使用)
	 * @generated
	 */
	private String preUsercd0013;

	/**
	 * COP活動先
	 * @generated
	 */
	private String preUsercd0014;

	/**
	 * ω3製剤市場
	 * @generated
	 */
	private String preUsercd0015;

	/**
	 * TCB RW在籍施設
	 * @generated
	 */
	private String preUsercd0016;

	/**
	 * DPP4アーリーアダプタ
	 * @generated
	 */
	private String preUsercd0017;

	/**
	 * DPP4阻害薬('16.2)
	 * @generated
	 */
	private String preUsercd0018;

	/**
	 * DPP4阻害薬市場
	 * @generated
	 */
	private String preUsercd0019;

	/**
	 * ARB/CCB配合剤市場
	 * @generated
	 */
	private String preUsercd0020;

	/**
	 * 抗潰瘍(PPI)市場
	 * @generated
	 */
	private String preUsercd0021;

	/**
	 * 骨粗鬆症市場
	 * @generated
	 */
	private String preUsercd0022;

	/**
	 * 睡眠市場
	 * @generated
	 */
	private String preUsercd0023;

	/**
	 * X雑・災害
	 * @generated
	 */
	private String preUsercd0024;

	/**
	 * アルツハイマー市場
	 * @generated
	 */
	private String preUsercd0025;

	/**
	 * ARB総市場
	 * @generated
	 */
	private String preUsercd0026;

	/**
	 * 施設責任者
	 * @generated
	 */
	private String preUsercd0027;

	/**
	 * タケプロン・コプロ
	 * @generated
	 */
	private String preUsercd0028;

	/**
	 * 抗潰瘍(PPI)市場('16.6)
	 * @generated
	 */
	private String preUsercd0029;

	/**
	 * (4:未使用)
	 * @generated
	 */
	private String preUsercd0030;

	/**
	 * インフル・セオリア
	 * @generated
	 */
	private String preUsercd0031;

	/**
	 * インフル・あすか
	 * @generated
	 */
	private String preUsercd0032;

	/**
	 * マーケティングG・T
	 * @generated
	 */
	private String preUsercd0033;

	/**
	 * (8:未使用)
	 * @generated
	 */
	private String preUsercd0034;

	/**
	 * セルタッチ・ベネット
	 * @generated
	 */
	private String preUsercd0035;

	/**
	 * (10:未使用)
	 * @generated
	 */
	private String preUsercd0036;

	/**
	 * (A:未使用)
	 * @generated
	 */
	private String preUsercd0001Nm;

	/**
	 * VCT・V先
	 * @generated
	 */
	private String preUsercd0002Nm;

	/**
	 * (C:未使用)
	 * @generated
	 */
	private String preUsercd0003Nm;

	/**
	 * NEXアーリーアダプタ
	 * @generated
	 */
	private String preUsercd0004Nm;

	/**
	 * (E:未使用)
	 * @generated
	 */
	private String preUsercd0005Nm;

	/**
	 * テルモ・コプロ
	 * @generated
	 */
	private String preUsercd0006Nm;

	/**
	 * (G:未使用)
	 * @generated
	 */
	private String preUsercd0007Nm;

	/**
	 * リュープリン・コプロ12/10
	 * @generated
	 */
	private String preUsercd0008Nm;

	/**
	 * アクトス・コプロ
	 * @generated
	 */
	private String preUsercd0009Nm;

	/**
	 * ベネット・コプロ
	 * @generated
	 */
	private String preUsercd0010Nm;

	/**
	 * グルファスト
	 * @generated
	 */
	private String preUsercd0011Nm;

	/**
	 * リュープリンコプロ08/10
	 * @generated
	 */
	private String preUsercd0012Nm;

	/**
	 * (M:未使用)
	 * @generated
	 */
	private String preUsercd0013Nm;

	/**
	 * COP活動先
	 * @generated
	 */
	private String preUsercd0014Nm;

	/**
	 * ω3製剤市場
	 * @generated
	 */
	private String preUsercd0015Nm;

	/**
	 * TCB RW在籍施設
	 * @generated
	 */
	private String preUsercd0016Nm;

	/**
	 * DPP4アーリーアダプタ
	 * @generated
	 */
	private String preUsercd0017Nm;

	/**
	 * DPP4阻害薬('16.2)
	 * @generated
	 */
	private String preUsercd0018Nm;

	/**
	 * DPP4阻害薬市場
	 * @generated
	 */
	private String preUsercd0019Nm;

	/**
	 * ARB/CCB配合剤市場
	 * @generated
	 */
	private String preUsercd0020Nm;

	/**
	 * 抗潰瘍(PPI)市場
	 * @generated
	 */
	private String preUsercd0021Nm;

	/**
	 * 骨粗鬆症市場
	 * @generated
	 */
	private String preUsercd0022Nm;

	/**
	 * 睡眠市場
	 * @generated
	 */
	private String preUsercd0023Nm;

	/**
	 * X雑・災害
	 * @generated
	 */
	private String preUsercd0024Nm;

	/**
	 * アルツハイマー市場
	 * @generated
	 */
	private String preUsercd0025Nm;

	/**
	 * ARB総市場
	 * @generated
	 */
	private String preUsercd0026Nm;

	/**
	 * 施設責任者
	 * @generated
	 */
	private String preUsercd0027Nm;

	/**
	 * タケプロン・コプロ
	 * @generated
	 */
	private String preUsercd0028Nm;

	/**
	 * 抗潰瘍(PPI)市場('16.6)
	 * @generated
	 */
	private String preUsercd0029Nm;

	/**
	 * (4:未使用)
	 * @generated
	 */
	private String preUsercd0030Nm;

	/**
	 * インフル・セオリア
	 * @generated
	 */
	private String preUsercd0031Nm;

	/**
	 * インフル・あすか
	 * @generated
	 */
	private String preUsercd0032Nm;

	/**
	 * マーケティングG・T
	 * @generated
	 */
	private String preUsercd0033Nm;

	/**
	 * (8:未使用)
	 * @generated
	 */
	private String preUsercd0034Nm;

	/**
	 * セルタッチ・ベネット
	 * @generated
	 */
	private String preUsercd0035Nm;

	/**
	 * (10:未使用)
	 * @generated
	 */
	private String preUsercd0036Nm;

	/**
	 * A(支店)
	 * @generated
	 */
	private String preUsercd0101;

	/**
	 * B(支店)
	 * @generated
	 */
	private String preUsercd0102;

	/**
	 * C(支店)
	 * @generated
	 */
	private String preUsercd0103;

	/**
	 * D(支店)
	 * @generated
	 */
	private String preUsercd0104;

	/**
	 * E(支店)
	 * @generated
	 */
	private String preUsercd0105;

	/**
	 * F(支店)
	 * @generated
	 */
	private String preUsercd0106;

	/**
	 * G(支店)
	 * @generated
	 */
	private String preUsercd0107;

	/**
	 * H(支店)
	 * @generated
	 */
	private String preUsercd0108;

	/**
	 * I(支店)
	 * @generated
	 */
	private String preUsercd0109;

	/**
	 * A(営業所)
	 * @generated
	 */
	private String preUsercd0201;

	/**
	 * LEUターゲット先
	 * @generated
	 */
	private String preUsercd0202;

	/**
	 * C(営業所)
	 * @generated
	 */
	private String preUsercd0203;

	/**
	 * 次期院長ターゲット先
	 * @generated
	 */
	private String preUsercd0204;

	/**
	 * E(営業所)
	 * @generated
	 */
	private String preUsercd0205;

	/**
	 * F:なんでもフォロー表
	 * @generated
	 */
	private String preUsercd0206;

	/**
	 * 入院診療計画
	 * @generated
	 */
	private String preReward04;

	/**
	 * 院内感染防止対策
	 * @generated
	 */
	private String preReward05;

	/**
	 * 地域連携小児夜間・休日診療料1
	 * @generated
	 */
	private String preReward08;

	/**
	 * 小児入院医療管理料
	 * @generated
	 */
	private String preReward09;

	/**
	 * 緩和ケア診療加算
	 * @generated
	 */
	private String preReward18;

	/**
	 * 短期滞在手術基本料
	 * @generated
	 */
	private String preReward21;

	/**
	 * 在宅患者訪問診療料又は在総診
	 * @generated
	 */
	private String preReward23;

	/**
	 * 生活習慣病指導管理料
	 * @generated
	 */
	private String preReward25;

	/**
	 * 慢性疼痛疾患管理料
	 * @generated
	 */
	private String preReward26;

	/**
	 * 看護配置(有床診療所)
	 * @generated
	 */
	private String preReward27;

	/**
	 * 老人入院基本料
	 * @generated
	 */
	private String preReward29;

	/**
	 * 地域連携時間外診療(有無)
	 * @generated
	 */
	private String preReward35;

	/**
	 * 地域連携診療計画管理料
	 * @generated
	 */
	private String preReward36;

	/**
	 * 地域連携診療計画退院時指導料
	 * @generated
	 */
	private String preReward37;

	/**
	 * 病理診断料
	 * @generated
	 */
	private String preReward44;

	/**
	 * 急性期入院加算
	 * @generated
	 */
	private String preReward16;

	/**
	 * 急性期特定入院加算
	 * @generated
	 */
	private String preReward17;

	/**
	 * 入院診療計画
	 * @generated
	 */
	private String preReward04Nm;

	/**
	 * 院内感染防止対策
	 * @generated
	 */
	private String preReward05Nm;

	/**
	 * 地域連携小児夜間・休日診療料1
	 * @generated
	 */
	private String preReward08Nm;

	/**
	 * 小児入院医療管理料
	 * @generated
	 */
	private String preReward09Nm;

	/**
	 * 緩和ケア診療加算
	 * @generated
	 */
	private String preReward18Nm;

	/**
	 * 短期滞在手術基本料
	 * @generated
	 */
	private String preReward21Nm;

	/**
	 * 在宅患者訪問診療料又は在総診
	 * @generated
	 */
	private String preReward23Nm;

	/**
	 * 生活習慣病指導管理料
	 * @generated
	 */
	private String preReward25Nm;

	/**
	 * 慢性疼痛疾患管理料
	 * @generated
	 */
	private String preReward26Nm;

	/**
	 * 看護配置(有床診療所)
	 * @generated
	 */
	private String preReward27Nm;

	/**
	 * 老人入院基本料
	 * @generated
	 */
	private String preReward29Nm;

	/**
	 * 地域連携時間外診療(有無)
	 * @generated
	 */
	private String preReward35Nm;

	/**
	 * 地域連携診療計画管理料
	 * @generated
	 */
	private String preReward36Nm;

	/**
	 * 地域連携診療計画退院時指導料
	 * @generated
	 */
	private String preReward37Nm;

	/**
	 * 病理診断料
	 * @generated
	 */
	private String preReward44Nm;

	/**
	 * 急性期入院加算
	 * @generated
	 */
	private String preReward16Nm;

	/**
	 * 急性期特定入院加算
	 * @generated
	 */
	private String preReward17Nm;

	/**
	 * 申請コメント
	 * @generated
	 */
	private String reqComment;

	/**
	 * 審査・承認メモ
	 * @generated
	 */
	private String aprMemo;

	/**
	 * 表示分岐
	 * 1:固定施設から作成、2：申請データあり
	 * @generated
	 */
	private String displayKbn;

	/**
	 * 次画面分岐用
	 * 0:一時保存、1:申請画面へ
	 * @generated
	 */
	private String funcId;

	/**
	 * コンボボックス_取引区分
	 * @generated
	 */
	private LinkedHashMap<String,String> tradeTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_開業年月日(年)
	 * @generated
	 */
	private LinkedHashMap<String,String> insOpenYearCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_開業年月日(月)
	 * @generated
	 */
	private LinkedHashMap<String,String> insOpenMonthCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_開業年月日(日)
	 * @generated
	 */
	private LinkedHashMap<String,String> insOpenDayCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_大学細分類
	 * @generated
	 */
	private LinkedHashMap<String,String> univSubdivCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_卸色区分
	 * @generated
	 */
	private LinkedHashMap<String,String> wsTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_本部一括購入
	 * @generated
	 */
	private LinkedHashMap<String,String> basketPurchaseCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_DM先(TKP-LDA)
	 * @generated
	 */
	private LinkedHashMap<String,String> free0001Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_LEUあすか
	 * @generated
	 */
	private LinkedHashMap<String,String> free0002Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_DM先(TKP-NSAID)
	 * @generated
	 */
	private LinkedHashMap<String,String> free0003Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_（O：未使用）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0015Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_TRIアロ登録（当期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0008Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_TRIアロ登録（来期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0009Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_REMアロ登録（当期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0004Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_REMアロ登録（来期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0005Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ENBアロ登録（当期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0006Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ENBアロ登録（来期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0007Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_XELアロ登録（当期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0010Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_XELアロ登録（来期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0011Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ROZアロ登録（当期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0013Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ROZアロ登録（来期）
	 * @generated
	 */
	private LinkedHashMap<String,String> free0014Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_振替先1310
	 * @generated
	 */
	private LinkedHashMap<String,String> free0012Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_容量別実績把握病院区分
	 * @generated
	 */
	private LinkedHashMap<String,String> capaTypeCombo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_老人福祉法施設区分(老人短期入所施設)
	 * @generated
	 */
	private LinkedHashMap<String,String> welfare02Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_老人福祉法施設区分(その他)
	 * @generated
	 */
	private LinkedHashMap<String,String> welfare08Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_En-T ARB ('18.11)
	 * @generated
	 */
	private LinkedHashMap<String,String> result01Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_En-T DPP4 ('18.11)
	 * @generated
	 */
	private LinkedHashMap<String,String> result02Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_En-T ω3 ('18.11)
	 * @generated
	 */
	private LinkedHashMap<String,String> result03Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_En-T PPI ('18.11)
	 * @generated
	 */
	private LinkedHashMap<String,String> result04Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_En-T 睡眠 ('18.11)
	 * @generated
	 */
	private LinkedHashMap<String,String> result05Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_En-T アルツハイマー ('18.11)
	 * @generated
	 */
	private LinkedHashMap<String,String> result06Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_En-T 骨粗鬆症 ('18.11)
	 * @generated
	 */
	private LinkedHashMap<String,String> result07Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_REMターゲット
	 * @generated
	 */
	private LinkedHashMap<String,String> result08Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_BLP未獲得市場区分
	 * @generated
	 */
	private LinkedHashMap<String,String> result09Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_整形育成先
	 * @generated
	 */
	private LinkedHashMap<String,String> result10Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_TKP・MSコールUP
	 * @generated
	 */
	private LinkedHashMap<String,String> result11Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ALC Core1・2('19.10)
	 * @generated
	 */
	private LinkedHashMap<String,String> result12Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ENT Tier1-4('19.4)
	 * @generated
	 */
	private LinkedHashMap<String,String> result13Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_JIA厚労省施設
	 * @generated
	 */
	private LinkedHashMap<String,String> result14Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_注力先('18.12)
	 * @generated
	 */
	private LinkedHashMap<String,String> result15Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ENBターゲット先('19.4)
	 * @generated
	 */
	private LinkedHashMap<String,String> result16Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_骨G
	 * @generated
	 */
	private LinkedHashMap<String,String> result17Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ナテグリニド繁用先
	 * @generated
	 */
	private LinkedHashMap<String,String> result18Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_GLUターゲット先
	 * @generated
	 */
	private LinkedHashMap<String,String> result19Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_骨G2
	 * @generated
	 */
	private LinkedHashMap<String,String> result20Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(U:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> result21Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_DOIT3
	 * @generated
	 */
	private LinkedHashMap<String,String> result22Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_PCI300
	 * @generated
	 */
	private LinkedHashMap<String,String> result23Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_JDEsART
	 * @generated
	 */
	private LinkedHashMap<String,String> result24Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(Y:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> result25Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_TAP先
	 * @generated
	 */
	private LinkedHashMap<String,String> result26Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_QOL2005TKP
	 * @generated
	 */
	private LinkedHashMap<String,String> result27Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_TKP未獲得市場区分
	 * @generated
	 */
	private LinkedHashMap<String,String> result28Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ACT未獲得市場区分
	 * @generated
	 */
	private LinkedHashMap<String,String> result29Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(4:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> result30Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_旧LMR
	 * @generated
	 */
	private LinkedHashMap<String,String> result31Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(6:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> result32Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_LEU乳癌
	 * @generated
	 */
	private LinkedHashMap<String,String> result33Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ONC担当区分
	 * @generated
	 */
	private LinkedHashMap<String,String> result34Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_RPL(CVM)担当区分
	 * @generated
	 */
	private LinkedHashMap<String,String> result35Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(10:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> result36Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_内視鏡
	 * @generated
	 */
	private LinkedHashMap<String,String> equip01Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_骨量測定器
	 * @generated
	 */
	private LinkedHashMap<String,String> equip02Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ICD
	 * @generated
	 */
	private LinkedHashMap<String,String> equip03Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_CCU
	 * @generated
	 */
	private LinkedHashMap<String,String> equip07Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_NCU
	 * @generated
	 */
	private LinkedHashMap<String,String> equip09Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_T先
	 * @generated
	 */
	private LinkedHashMap<String,String> market01Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_酸抑制剤
	 * @generated
	 */
	private LinkedHashMap<String,String> market02Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_高脂血症
	 * @generated
	 */
	private LinkedHashMap<String,String> market03Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_高血圧
	 * @generated
	 */
	private LinkedHashMap<String,String> market04Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_糖尿病
	 * @generated
	 */
	private LinkedHashMap<String,String> market06Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_骨粗鬆症
	 * @generated
	 */
	private LinkedHashMap<String,String> market07Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_CVMターゲット
	 * @generated
	 */
	private LinkedHashMap<String,String> market09Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_社会医療法人
	 * @generated
	 */
	private LinkedHashMap<String,String> medical12Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_入院包括化実施病院
	 * @generated
	 */
	private LinkedHashMap<String,String> spfunc01Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_救命救急センター
	 * @generated
	 */
	private LinkedHashMap<String,String> spfunc03Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_大学院大学
	 * @generated
	 */
	private LinkedHashMap<String,String> spfunc04Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_がん連携パス
	 * @generated
	 */
	private LinkedHashMap<String,String> tieup10Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_心疾患連携パス
	 * @generated
	 */
	private LinkedHashMap<String,String> tieup11Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_糖尿病連携パス
	 * @generated
	 */
	private LinkedHashMap<String,String> tieup12Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(A:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0001Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_VCT・V先
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0002Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(C:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0003Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_NEXアーリーアダプタ
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0004Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(E:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0005Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_テルモ・コプロ
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0006Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(G:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0007Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_リュープリン・コプロ12/10
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0008Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_アクトス・コプロ
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0009Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ベネット・コプロ
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0010Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_グルファスト
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0011Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_リュープリンコプロ08/10
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0012Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(M:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0013Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_COP活動先
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0014Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ω3製剤市場
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0015Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_TCB RW在籍施設
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0016Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_DPP4アーリーアダプタ
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0017Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_DPP4阻害薬('16.2)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0018Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_DPP4阻害薬市場
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0019Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ARB/CCB配合剤市場
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0020Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_抗潰瘍(PPI)市場
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0021Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_骨粗鬆症市場
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0022Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_睡眠市場
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0023Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_X雑・災害
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0024Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_アルツハイマー市場
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0025Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_ARB総市場
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0026Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_施設責任者
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0027Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_タケプロン・コプロ
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0028Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_抗潰瘍(PPI)市場('16.6)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0029Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(4:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0030Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_インフル・セオリア
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0031Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_インフル・あすか
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0032Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_マーケティングG・T
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0033Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(8:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0034Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_セルタッチ・ベネット
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0035Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_(10:未使用)
	 * @generated
	 */
	private LinkedHashMap<String,String> usercd0036Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_入院診療計画
	 * @generated
	 */
	private LinkedHashMap<String,String> reward04Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_院内感染防止対策
	 * @generated
	 */
	private LinkedHashMap<String,String> reward05Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_地域連携小児夜間・休日診療料1
	 * @generated
	 */
	private LinkedHashMap<String,String> reward08Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_小児入院医療管理料
	 * @generated
	 */
	private LinkedHashMap<String,String> reward09Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_緩和ケア診療加算
	 * @generated
	 */
	private LinkedHashMap<String,String> reward18Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_短期滞在手術基本料
	 * @generated
	 */
	private LinkedHashMap<String,String> reward21Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_在宅患者訪問診療料又は在総診
	 * @generated
	 */
	private LinkedHashMap<String,String> reward23Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_生活習慣病指導管理料
	 * @generated
	 */
	private LinkedHashMap<String,String> reward25Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_慢性疼痛疾患管理料
	 * @generated
	 */
	private LinkedHashMap<String,String> reward26Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_看護配置(有床診療所)
	 * @generated
	 */
	private LinkedHashMap<String,String> reward27Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_老人入院基本料
	 * @generated
	 */
	private LinkedHashMap<String,String> reward29Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_地域連携時間外診療(有無)
	 * @generated
	 */
	private LinkedHashMap<String,String> reward35Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_地域連携診療計画管理料
	 * @generated
	 */
	private LinkedHashMap<String,String> reward36Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_地域連携診療計画退院時指導料
	 * @generated
	 */
	private LinkedHashMap<String,String> reward37Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_病理診断料
	 * @generated
	 */
	private LinkedHashMap<String,String> reward44Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_急性期入院加算
	 * @generated
	 */
	private LinkedHashMap<String,String> reward16Combo = new LinkedHashMap<String,String>();

	/**
	 * コンボボックス_急性期特定入院加算
	 * @generated
	 */
	private LinkedHashMap<String,String> reward17Combo = new LinkedHashMap<String,String>();


	/**
	 * 審査済みフラグ
	 * 0:未審査、1:審査済
	 * @generated
	 */
	private String shnFlg;

	/**
	 * 編集可能フラグ
	 * 0:不可、1:可
	 * @generated
	 */
	private String editApprFlg;

	/**
	 * メッセージ中身
	 * @generated
	 */
	private String msgStr;

    /**
     * デフォルトのコンストラクタ。
     * @generated
     */
    public NF012DTO() {
        setForward(NF012);
    }

    // START UOC

    // END UOC

    /**
     * この画面の画面IDをセットする
     * @param screenID 画面ID
     * @generated
     */
    public void setNF012(String screenID){
        this.NF012 = screenID;
    }

    /**
     * この画面の画面IDを返す
     * @return 画面ID名
     * @generated
     */
    public String getNF012(){
        return NF012;
    }

	/**
	 * NF012DTO.javamsgIdを設定
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
	 * NF012DTO.javaloginJokenSetCdを設定
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
	 * NF012DTO.javaloginJgiNoを設定
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
	 * NF012DTO.javaloginNmを設定
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
	 * NF012DTO.javaloginBrCdを設定
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
	 * NF012DTO.javaloginDistCdを設定
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
	 * NF012DTO.javaloginShzNmを設定
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
	 * NF012DTO.javaloginTrtCdを設定
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
	 * NF012DTO.javagamenIdを設定
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
	 * NF012DTO.javatitleを設定
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
	 * NF012DTO.javareqIdを設定
	 * @return reqId
	 */
	public String getReqId() {
		return reqId;
	}

	/**
	 * @param reqId セットする reqId
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	/**
	 * NF012DTO.javareqChlを設定
	 * @return reqChl
	 */
	public String getReqChl() {
		return reqChl;
	}

	/**
	 * @param reqChl セットする reqChl
	 */
	public void setReqChl(String reqChl) {
		this.reqChl = reqChl;
	}

	/**
	 * NF012DTO.javareqShzNmを設定
	 * @return reqShzNm
	 */
	public String getReqShzNm() {
		return reqShzNm;
	}

	/**
	 * @param reqShzNm セットする reqShzNm
	 */
	public void setReqShzNm(String reqShzNm) {
		this.reqShzNm = reqShzNm;
	}

	/**
	 * NF012DTO.javareqStsNmを設定
	 * @return reqStsNm
	 */
	public String getReqStsNm() {
		return reqStsNm;
	}

	/**
	 * @param reqStsNm セットする reqStsNm
	 */
	public void setReqStsNm(String reqStsNm) {
		this.reqStsNm = reqStsNm;
	}

	/**
	 * NF012DTO.javareqJgiNameを設定
	 * @return reqJgiName
	 */
	public String getReqJgiName() {
		return reqJgiName;
	}

	/**
	 * @param reqJgiName セットする reqJgiName
	 */
	public void setReqJgiName(String reqJgiName) {
		this.reqJgiName = reqJgiName;
	}

	/**
	 * NF012DTO.javareqYmdhmsを設定
	 * @return reqYmdhms
	 */
	public String getReqYmdhms() {
		return reqYmdhms;
	}

	/**
	 * @param reqYmdhms セットする reqYmdhms
	 */
	public void setReqYmdhms(String reqYmdhms) {
		this.reqYmdhms = reqYmdhms;
	}

	/**
	 * NF012DTO.javashnShaNameを設定
	 * @return shnShaName
	 */
	public String getShnShaName() {
		return shnShaName;
	}

	/**
	 * @param shnShaName セットする shnShaName
	 */
	public void setShnShaName(String shnShaName) {
		this.shnShaName = shnShaName;
	}

	/**
	 * NF012DTO.javashnYmdhmsを設定
	 * @return shnYmdhms
	 */
	public String getShnYmdhms() {
		return shnYmdhms;
	}

	/**
	 * @param shnYmdhms セットする shnYmdhms
	 */
	public void setShnYmdhms(String shnYmdhms) {
		this.shnYmdhms = shnYmdhms;
	}

	/**
	 * NF012DTO.javaaprShaNameを設定
	 * @return aprShaName
	 */
	public String getAprShaName() {
		return aprShaName;
	}

	/**
	 * @param aprShaName セットする aprShaName
	 */
	public void setAprShaName(String aprShaName) {
		this.aprShaName = aprShaName;
	}

	/**
	 * NF012DTO.javaaprYmdhmsを設定
	 * @return aprYmdhms
	 */
	public String getAprYmdhms() {
		return aprYmdhms;
	}

	/**
	 * @param aprYmdhms セットする aprYmdhms
	 */
	public void setAprYmdhms(String aprYmdhms) {
		this.aprYmdhms = aprYmdhms;
	}

	/**
	 * NF012DTO.javareqJgiNoを設定
	 * @return reqJgiNo
	 */
	public Integer getReqJgiNo() {
		return reqJgiNo;
	}

	/**
	 * @param reqJgiNo セットする reqJgiNo
	 */
	public void setReqJgiNo(Integer reqJgiNo) {
		this.reqJgiNo = reqJgiNo;
	}

	/**
	 * NF012DTO.javareqBrCdを設定
	 * @return reqBrCd
	 */
	public String getReqBrCd() {
		return reqBrCd;
	}

	/**
	 * @param reqBrCd セットする reqBrCd
	 */
	public void setReqBrCd(String reqBrCd) {
		this.reqBrCd = reqBrCd;
	}

	/**
	 * NF012DTO.javareqDistCdを設定
	 * @return reqDistCd
	 */
	public String getReqDistCd() {
		return reqDistCd;
	}

	/**
	 * @param reqDistCd セットする reqDistCd
	 */
	public void setReqDistCd(String reqDistCd) {
		this.reqDistCd = reqDistCd;
	}

	/**
	 * NF012DTO.javareqStsCdを設定
	 * @return reqStsCd
	 */
	public String getReqStsCd() {
		return reqStsCd;
	}

	/**
	 * @param reqStsCd セットする reqStsCd
	 */
	public void setReqStsCd(String reqStsCd) {
		this.reqStsCd = reqStsCd;
	}

	/**
	 * NF012DTO.javashnJgiNoを設定
	 * @return shnJgiNo
	 */
	public Integer getShnJgiNo() {
		return shnJgiNo;
	}

	/**
	 * @param shnJgiNo セットする shnJgiNo
	 */
	public void setShnJgiNo(Integer shnJgiNo) {
		this.shnJgiNo = shnJgiNo;
	}

	/**
	 * NF012DTO.javaaprJgiNoを設定
	 * @return aprJgiNo
	 */
	public Integer getAprJgiNo() {
		return aprJgiNo;
	}

	/**
	 * @param aprJgiNo セットする aprJgiNo
	 */
	public void setAprJgiNo(Integer aprJgiNo) {
		this.aprJgiNo = aprJgiNo;
	}

	/**
	 * NF012DTO.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public String getUpdShaYmd() {
		return updShaYmd;
	}

	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(String updShaYmd) {
		this.updShaYmd = updShaYmd;
	}

	/**
	 * NF012DTO.javainsNoを設定
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
	 * NF012DTO.javainsClassを設定
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
	 * NF012DTO.javainsSbtを設定
	 * @return insSbt
	 */
	public String getInsSbt() {
		return insSbt;
	}

	/**
	 * @param insSbt セットする insSbt
	 */
	public void setInsSbt(String insSbt) {
		this.insSbt = insSbt;
	}

	/**
	 * NF012DTO.javainsAbbrNameを設定
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
	 * NF012DTO.javainsKanaを設定
	 * @return insKana
	 */
	public String getInsKana() {
		return insKana;
	}

	/**
	 * @param insKana セットする insKana
	 */
	public void setInsKana(String insKana) {
		this.insKana = insKana;
	}

	/**
	 * NF012DTO.javainsFormalNameを設定
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
	 * NF012DTO.javatradeTypeを設定
	 * @return tradeType
	 */
	public String getTradeType() {
		return tradeType;
	}

	/**
	 * @param tradeType セットする tradeType
	 */
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * NF012DTO.javatradeTypeNmを設定
	 * @return tradeTypeNm
	 */
	public String getTradeTypeNm() {
		return tradeTypeNm;
	}

	/**
	 * @param tradeTypeNm セットする tradeTypeNm
	 */
	public void setTradeTypeNm(String tradeTypeNm) {
		this.tradeTypeNm = tradeTypeNm;
	}

	/**
	 * NF012DTO.javainsOpenYearを設定
	 * @return insOpenYear
	 */
	public String getInsOpenYear() {
		return insOpenYear;
	}

	/**
	 * @param insOpenYear セットする insOpenYear
	 */
	public void setInsOpenYear(String insOpenYear) {
		this.insOpenYear = insOpenYear;
	}

	/**
	 * NF012DTO.javainsOpenMonthを設定
	 * @return insOpenMonth
	 */
	public String getInsOpenMonth() {
		return insOpenMonth;
	}

	/**
	 * @param insOpenMonth セットする insOpenMonth
	 */
	public void setInsOpenMonth(String insOpenMonth) {
		this.insOpenMonth = insOpenMonth;
	}

	/**
	 * NF012DTO.javainsOpenDayを設定
	 * @return insOpenDay
	 */
	public String getInsOpenDay() {
		return insOpenDay;
	}

	/**
	 * @param insOpenDay セットする insOpenDay
	 */
	public void setInsOpenDay(String insOpenDay) {
		this.insOpenDay = insOpenDay;
	}

	/**
	 * NF012DTO.javapreInsAbbrNameを設定
	 * @return preInsAbbrName
	 */
	public String getPreInsAbbrName() {
		return preInsAbbrName;
	}

	/**
	 * @param preInsAbbrName セットする preInsAbbrName
	 */
	public void setPreInsAbbrName(String preInsAbbrName) {
		this.preInsAbbrName = preInsAbbrName;
	}

	/**
	 * NF012DTO.javapreInsKanaを設定
	 * @return preInsKana
	 */
	public String getPreInsKana() {
		return preInsKana;
	}

	/**
	 * @param preInsKana セットする preInsKana
	 */
	public void setPreInsKana(String preInsKana) {
		this.preInsKana = preInsKana;
	}

	/**
	 * NF012DTO.javapreInsFormalNameを設定
	 * @return preInsFormalName
	 */
	public String getPreInsFormalName() {
		return preInsFormalName;
	}

	/**
	 * @param preInsFormalName セットする preInsFormalName
	 */
	public void setPreInsFormalName(String preInsFormalName) {
		this.preInsFormalName = preInsFormalName;
	}

	/**
	 * NF012DTO.javapreTradeTypeを設定
	 * @return preTradeType
	 */
	public String getPreTradeType() {
		return preTradeType;
	}

	/**
	 * @param preTradeType セットする preTradeType
	 */
	public void setPreTradeType(String preTradeType) {
		this.preTradeType = preTradeType;
	}

	/**
	 * NF012DTO.javapreTradeTypeNmを設定
	 * @return preTradeTypeNm
	 */
	public String getPreTradeTypeNm() {
		return preTradeTypeNm;
	}

	/**
	 * @param preTradeTypeNm セットする preTradeTypeNm
	 */
	public void setPreTradeTypeNm(String preTradeTypeNm) {
		this.preTradeTypeNm = preTradeTypeNm;
	}

	/**
	 * NF012DTO.javapreInsOpenYearを設定
	 * @return preInsOpenYear
	 */
	public String getPreInsOpenYear() {
		return preInsOpenYear;
	}

	/**
	 * @param preInsOpenYear セットする preInsOpenYear
	 */
	public void setPreInsOpenYear(String preInsOpenYear) {
		this.preInsOpenYear = preInsOpenYear;
	}

	/**
	 * NF012DTO.javapreInsOpenMonthを設定
	 * @return preInsOpenMonth
	 */
	public String getPreInsOpenMonth() {
		return preInsOpenMonth;
	}

	/**
	 * @param preInsOpenMonth セットする preInsOpenMonth
	 */
	public void setPreInsOpenMonth(String preInsOpenMonth) {
		this.preInsOpenMonth = preInsOpenMonth;
	}

	/**
	 * NF012DTO.javapreInsOpenDayを設定
	 * @return preInsOpenDay
	 */
	public String getPreInsOpenDay() {
		return preInsOpenDay;
	}

	/**
	 * @param preInsOpenDay セットする preInsOpenDay
	 */
	public void setPreInsOpenDay(String preInsOpenDay) {
		this.preInsOpenDay = preInsOpenDay;
	}

	/**
	 * NF012DTO.javaprePharmTypeを設定
	 * @return prePharmType
	 */
	public String getPrePharmType() {
		return prePharmType;
	}

	/**
	 * @param prePharmType セットする prePharmType
	 */
	public void setPrePharmType(String prePharmType) {
		this.prePharmType = prePharmType;
	}

	/**
	 * NF012DTO.javaprePharmTypeNmを設定
	 * @return prePharmTypeNm
	 */
	public String getPrePharmTypeNm() {
		return prePharmTypeNm;
	}

	/**
	 * @param prePharmTypeNm セットする prePharmTypeNm
	 */
	public void setPrePharmTypeNm(String prePharmTypeNm) {
		this.prePharmTypeNm = prePharmTypeNm;
	}

	/**
	 * NF012DTO.javapharmTypeを設定
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
	 * NF012DTO.javapharmTypeNmを設定
	 * @return pharmTypeNm
	 */
	public String getPharmTypeNm() {
		return pharmTypeNm;
	}

	/**
	 * @param pharmTypeNm セットする pharmTypeNm
	 */
	public void setPharmTypeNm(String pharmTypeNm) {
		this.pharmTypeNm = pharmTypeNm;
	}

	/**
	 * NF012DTO.javapreInsRankを設定
	 * @return preInsRank
	 */
	public String getPreInsRank() {
		return preInsRank;
	}

	/**
	 * @param preInsRank セットする preInsRank
	 */
	public void setPreInsRank(String preInsRank) {
		this.preInsRank = preInsRank;
	}

	/**
	 * NF012DTO.javapreInsRankNmを設定
	 * @return preInsRankNm
	 */
	public String getPreInsRankNm() {
		return preInsRankNm;
	}

	/**
	 * @param preInsRankNm セットする preInsRankNm
	 */
	public void setPreInsRankNm(String preInsRankNm) {
		this.preInsRankNm = preInsRankNm;
	}

	/**
	 * NF012DTO.javainsRankを設定
	 * @return insRank
	 */
	public String getInsRank() {
		return insRank;
	}

	/**
	 * @param insRank セットする insRank
	 */
	public void setInsRank(String insRank) {
		this.insRank = insRank;
	}

	/**
	 * NF012DTO.javainsRankNmを設定
	 * @return insRankNm
	 */
	public String getInsRankNm() {
		return insRankNm;
	}

	/**
	 * @param insRankNm セットする insRankNm
	 */
	public void setInsRankNm(String insRankNm) {
		this.insRankNm = insRankNm;
	}

	/**
	 * NF012DTO.javapreRegVisTypeを設定
	 * @return preRegVisType
	 */
	public String getPreRegVisType() {
		return preRegVisType;
	}

	/**
	 * @param preRegVisType セットする preRegVisType
	 */
	public void setPreRegVisType(String preRegVisType) {
		this.preRegVisType = preRegVisType;
	}

	/**
	 * NF012DTO.javapreRegVisTypeNmを設定
	 * @return preRegVisTypeNm
	 */
	public String getPreRegVisTypeNm() {
		return preRegVisTypeNm;
	}

	/**
	 * @param preRegVisTypeNm セットする preRegVisTypeNm
	 */
	public void setPreRegVisTypeNm(String preRegVisTypeNm) {
		this.preRegVisTypeNm = preRegVisTypeNm;
	}

	/**
	 * NF012DTO.javaregVisTypeを設定
	 * @return regVisType
	 */
	public String getRegVisType() {
		return regVisType;
	}

	/**
	 * @param regVisType セットする regVisType
	 */
	public void setRegVisType(String regVisType) {
		this.regVisType = regVisType;
	}

	/**
	 * NF012DTO.javaregVisTypeNmを設定
	 * @return regVisTypeNm
	 */
	public String getRegVisTypeNm() {
		return regVisTypeNm;
	}

	/**
	 * @param regVisTypeNm セットする regVisTypeNm
	 */
	public void setRegVisTypeNm(String regVisTypeNm) {
		this.regVisTypeNm = regVisTypeNm;
	}

	/**
	 * NF012DTO.javapreManageCdを設定
	 * @return preManageCd
	 */
	public String getPreManageCd() {
		return preManageCd;
	}

	/**
	 * @param preManageCd セットする preManageCd
	 */
	public void setPreManageCd(String preManageCd) {
		this.preManageCd = preManageCd;
	}

	/**
	 * NF012DTO.javapreManageNmを設定
	 * @return preManageNm
	 */
	public String getPreManageNm() {
		return preManageNm;
	}

	/**
	 * @param preManageNm セットする preManageNm
	 */
	public void setPreManageNm(String preManageNm) {
		this.preManageNm = preManageNm;
	}

	/**
	 * NF012DTO.javamanageCdを設定
	 * @return manageCd
	 */
	public String getManageCd() {
		return manageCd;
	}

	/**
	 * @param manageCd セットする manageCd
	 */
	public void setManageCd(String manageCd) {
		this.manageCd = manageCd;
	}

	/**
	 * NF012DTO.javamanageNmを設定
	 * @return manageNm
	 */
	public String getManageNm() {
		return manageNm;
	}

	/**
	 * @param manageNm セットする manageNm
	 */
	public void setManageNm(String manageNm) {
		this.manageNm = manageNm;
	}

	/**
	 * NF012DTO.javawsTypeを設定
	 * @return wsType
	 */
	public String getWsType() {
		return wsType;
	}

	/**
	 * @param wsType セットする wsType
	 */
	public void setWsType(String wsType) {
		this.wsType = wsType;
	}

	/**
	 * NF012DTO.javawsTypeNmを設定
	 * @return wsTypeNm
	 */
	public String getWsTypeNm() {
		return wsTypeNm;
	}

	/**
	 * @param wsTypeNm セットする wsTypeNm
	 */
	public void setWsTypeNm(String wsTypeNm) {
		this.wsTypeNm = wsTypeNm;
	}

	/**
	 * NF012DTO.javabasketPurchaseを設定
	 * @return basketPurchase
	 */
	public String getBasketPurchase() {
		return basketPurchase;
	}

	/**
	 * @param basketPurchase セットする basketPurchase
	 */
	public void setBasketPurchase(String basketPurchase) {
		this.basketPurchase = basketPurchase;
	}

	/**
	 * NF012DTO.javabasketPurchaseNmを設定
	 * @return basketPurchaseNm
	 */
	public String getBasketPurchaseNm() {
		return basketPurchaseNm;
	}

	/**
	 * @param basketPurchaseNm セットする basketPurchaseNm
	 */
	public void setBasketPurchaseNm(String basketPurchaseNm) {
		this.basketPurchaseNm = basketPurchaseNm;
	}

	/**
	 * NF012DTO.javaunivSubdivを設定
	 * @return univSubdiv
	 */
	public String getUnivSubdiv() {
		return univSubdiv;
	}

	/**
	 * @param univSubdiv セットする univSubdiv
	 */
	public void setUnivSubdiv(String univSubdiv) {
		this.univSubdiv = univSubdiv;
	}

	/**
	 * NF012DTO.javaunivSubdivNmを設定
	 * @return univSubdivNm
	 */
	public String getUnivSubdivNm() {
		return univSubdivNm;
	}

	/**
	 * @param univSubdivNm セットする univSubdivNm
	 */
	public void setUnivSubdivNm(String univSubdivNm) {
		this.univSubdivNm = univSubdivNm;
	}

	/**
	 * NF012DTO.javacapaTypeを設定
	 * @return capaType
	 */
	public String getCapaType() {
		return capaType;
	}

	/**
	 * @param capaType セットする capaType
	 */
	public void setCapaType(String capaType) {
		this.capaType = capaType;
	}

	/**
	 * NF012DTO.javacapaTypeNmを設定
	 * @return capaTypeNm
	 */
	public String getCapaTypeNm() {
		return capaTypeNm;
	}

	/**
	 * @param capaTypeNm セットする capaTypeNm
	 */
	public void setCapaTypeNm(String capaTypeNm) {
		this.capaTypeNm = capaTypeNm;
	}

	/**
	 * NF012DTO.javapreWsTypeを設定
	 * @return preWsType
	 */
	public String getPreWsType() {
		return preWsType;
	}

	/**
	 * @param preWsType セットする preWsType
	 */
	public void setPreWsType(String preWsType) {
		this.preWsType = preWsType;
	}

	/**
	 * NF012DTO.javapreWsTypeNmを設定
	 * @return preWsTypeNm
	 */
	public String getPreWsTypeNm() {
		return preWsTypeNm;
	}

	/**
	 * @param preWsTypeNm セットする preWsTypeNm
	 */
	public void setPreWsTypeNm(String preWsTypeNm) {
		this.preWsTypeNm = preWsTypeNm;
	}

	/**
	 * NF012DTO.javapreBasketPurchaseを設定
	 * @return preBasketPurchase
	 */
	public String getPreBasketPurchase() {
		return preBasketPurchase;
	}

	/**
	 * @param preBasketPurchase セットする preBasketPurchase
	 */
	public void setPreBasketPurchase(String preBasketPurchase) {
		this.preBasketPurchase = preBasketPurchase;
	}

	/**
	 * NF012DTO.javapreBasketPurchaseNmを設定
	 * @return preBasketPurchaseNm
	 */
	public String getPreBasketPurchaseNm() {
		return preBasketPurchaseNm;
	}

	/**
	 * @param preBasketPurchaseNm セットする preBasketPurchaseNm
	 */
	public void setPreBasketPurchaseNm(String preBasketPurchaseNm) {
		this.preBasketPurchaseNm = preBasketPurchaseNm;
	}

	/**
	 * NF012DTO.javapreUnivSubdivを設定
	 * @return preUnivSubdiv
	 */
	public String getPreUnivSubdiv() {
		return preUnivSubdiv;
	}

	/**
	 * @param preUnivSubdiv セットする preUnivSubdiv
	 */
	public void setPreUnivSubdiv(String preUnivSubdiv) {
		this.preUnivSubdiv = preUnivSubdiv;
	}

	/**
	 * NF012DTO.javapreUnivSubdivNmを設定
	 * @return preUnivSubdivNm
	 */
	public String getPreUnivSubdivNm() {
		return preUnivSubdivNm;
	}

	/**
	 * @param preUnivSubdivNm セットする preUnivSubdivNm
	 */
	public void setPreUnivSubdivNm(String preUnivSubdivNm) {
		this.preUnivSubdivNm = preUnivSubdivNm;
	}

	/**
	 * NF012DTO.javapreCapaTypeを設定
	 * @return preCapaType
	 */
	public String getPreCapaType() {
		return preCapaType;
	}

	/**
	 * @param preCapaType セットする preCapaType
	 */
	public void setPreCapaType(String preCapaType) {
		this.preCapaType = preCapaType;
	}

	/**
	 * NF012DTO.javapreCapaTypeNmを設定
	 * @return preCapaTypeNm
	 */
	public String getPreCapaTypeNm() {
		return preCapaTypeNm;
	}

	/**
	 * @param preCapaTypeNm セットする preCapaTypeNm
	 */
	public void setPreCapaTypeNm(String preCapaTypeNm) {
		this.preCapaTypeNm = preCapaTypeNm;
	}

	/**
	 * NF012DTO.javaultInsCdを設定
	 * @return ultInsCd
	 */
	public String getUltInsCd() {
		return ultInsCd;
	}

	/**
	 * @param ultInsCd セットする ultInsCd
	 */
	public void setUltInsCd(String ultInsCd) {
		this.ultInsCd = ultInsCd;
	}

	/**
	 * NF012DTO.javapreUltInsCdを設定
	 * @return preUltInsCd
	 */
	public String getPreUltInsCd() {
		return preUltInsCd;
	}

	/**
	 * @param preUltInsCd セットする preUltInsCd
	 */
	public void setPreUltInsCd(String preUltInsCd) {
		this.preUltInsCd = preUltInsCd;
	}

	/**
	 * NF012DTO.javashisetsuNmRyakuを設定
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
	 * NF012DTO.javapreShisetsuNmRyakuを設定
	 * @return preShisetsuNmRyaku
	 */
	public String getPreShisetsuNmRyaku() {
		return preShisetsuNmRyaku;
	}

	/**
	 * @param preShisetsuNmRyaku セットする preShisetsuNmRyaku
	 */
	public void setPreShisetsuNmRyaku(String preShisetsuNmRyaku) {
		this.preShisetsuNmRyaku = preShisetsuNmRyaku;
	}

	/**
	 * NF012DTO.javashisetsuNmを設定
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
	 * NF012DTO.javapreShisetsuNmを設定
	 * @return preShisetsuNm
	 */
	public String getPreShisetsuNm() {
		return preShisetsuNm;
	}

	/**
	 * @param preShisetsuNm セットする preShisetsuNm
	 */
	public void setPreShisetsuNm(String preShisetsuNm) {
		this.preShisetsuNm = preShisetsuNm;
	}

	/**
	 * NF012DTO.javabedCntBaseを設定
	 * @return bedCntBase
	 */
	public String getBedCntBase() {
		return bedCntBase;
	}

	/**
	 * @param bedCntBase セットする bedCntBase
	 */
	public void setBedCntBase(String bedCntBase) {
		this.bedCntBase = bedCntBase;
	}

	/**
	 * NF012DTO.javabedCnt01を設定
	 * @return bedCnt01
	 */
	public String getBedCnt01() {
		return bedCnt01;
	}

	/**
	 * @param bedCnt01 セットする bedCnt01
	 */
	public void setBedCnt01(String bedCnt01) {
		this.bedCnt01 = bedCnt01;
	}

	/**
	 * NF012DTO.javabedCnt02を設定
	 * @return bedCnt02
	 */
	public String getBedCnt02() {
		return bedCnt02;
	}

	/**
	 * @param bedCnt02 セットする bedCnt02
	 */
	public void setBedCnt02(String bedCnt02) {
		this.bedCnt02 = bedCnt02;
	}

	/**
	 * NF012DTO.javabedCnt03を設定
	 * @return bedCnt03
	 */
	public String getBedCnt03() {
		return bedCnt03;
	}

	/**
	 * @param bedCnt03 セットする bedCnt03
	 */
	public void setBedCnt03(String bedCnt03) {
		this.bedCnt03 = bedCnt03;
	}

	/**
	 * NF012DTO.javabedCnt04を設定
	 * @return bedCnt04
	 */
	public String getBedCnt04() {
		return bedCnt04;
	}

	/**
	 * @param bedCnt04 セットする bedCnt04
	 */
	public void setBedCnt04(String bedCnt04) {
		this.bedCnt04 = bedCnt04;
	}

	/**
	 * NF012DTO.javabedCnt05を設定
	 * @return bedCnt05
	 */
	public String getBedCnt05() {
		return bedCnt05;
	}

	/**
	 * @param bedCnt05 セットする bedCnt05
	 */
	public void setBedCnt05(String bedCnt05) {
		this.bedCnt05 = bedCnt05;
	}

	/**
	 * NF012DTO.javabedCnt06を設定
	 * @return bedCnt06
	 */
	public String getBedCnt06() {
		return bedCnt06;
	}

	/**
	 * @param bedCnt06 セットする bedCnt06
	 */
	public void setBedCnt06(String bedCnt06) {
		this.bedCnt06 = bedCnt06;
	}

	/**
	 * NF012DTO.javabedCnt07を設定
	 * @return bedCnt07
	 */
	public String getBedCnt07() {
		return bedCnt07;
	}

	/**
	 * @param bedCnt07 セットする bedCnt07
	 */
	public void setBedCnt07(String bedCnt07) {
		this.bedCnt07 = bedCnt07;
	}

	/**
	 * NF012DTO.javabedsTotを設定
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
	 * NF012DTO.javamedBedsTotを設定
	 * @return medBedsTot
	 */
	public String getMedBedsTot() {
		return medBedsTot;
	}

	/**
	 * @param medBedsTot セットする medBedsTot
	 */
	public void setMedBedsTot(String medBedsTot) {
		this.medBedsTot = medBedsTot;
	}

	/**
	 * NF012DTO.javaultBedCntBaseを設定
	 * @return ultBedCntBase
	 */
	public String getUltBedCntBase() {
		return ultBedCntBase;
	}

	/**
	 * @param ultBedCntBase セットする ultBedCntBase
	 */
	public void setUltBedCntBase(String ultBedCntBase) {
		this.ultBedCntBase = ultBedCntBase;
	}

	/**
	 * NF012DTO.javaultBedCnt01を設定
	 * @return ultBedCnt01
	 */
	public String getUltBedCnt01() {
		return ultBedCnt01;
	}

	/**
	 * @param ultBedCnt01 セットする ultBedCnt01
	 */
	public void setUltBedCnt01(String ultBedCnt01) {
		this.ultBedCnt01 = ultBedCnt01;
	}

	/**
	 * NF012DTO.javaultBedCnt02を設定
	 * @return ultBedCnt02
	 */
	public String getUltBedCnt02() {
		return ultBedCnt02;
	}

	/**
	 * @param ultBedCnt02 セットする ultBedCnt02
	 */
	public void setUltBedCnt02(String ultBedCnt02) {
		this.ultBedCnt02 = ultBedCnt02;
	}

	/**
	 * NF012DTO.javaultBedCnt03を設定
	 * @return ultBedCnt03
	 */
	public String getUltBedCnt03() {
		return ultBedCnt03;
	}

	/**
	 * @param ultBedCnt03 セットする ultBedCnt03
	 */
	public void setUltBedCnt03(String ultBedCnt03) {
		this.ultBedCnt03 = ultBedCnt03;
	}

	/**
	 * NF012DTO.javaultBedCnt04を設定
	 * @return ultBedCnt04
	 */
	public String getUltBedCnt04() {
		return ultBedCnt04;
	}

	/**
	 * @param ultBedCnt04 セットする ultBedCnt04
	 */
	public void setUltBedCnt04(String ultBedCnt04) {
		this.ultBedCnt04 = ultBedCnt04;
	}

	/**
	 * NF012DTO.javaultBedCnt05を設定
	 * @return ultBedCnt05
	 */
	public String getUltBedCnt05() {
		return ultBedCnt05;
	}

	/**
	 * @param ultBedCnt05 セットする ultBedCnt05
	 */
	public void setUltBedCnt05(String ultBedCnt05) {
		this.ultBedCnt05 = ultBedCnt05;
	}

	/**
	 * NF012DTO.javaultBedCnt06を設定
	 * @return ultBedCnt06
	 */
	public String getUltBedCnt06() {
		return ultBedCnt06;
	}

	/**
	 * @param ultBedCnt06 セットする ultBedCnt06
	 */
	public void setUltBedCnt06(String ultBedCnt06) {
		this.ultBedCnt06 = ultBedCnt06;
	}

	/**
	 * NF012DTO.javaultBedCnt07を設定
	 * @return ultBedCnt07
	 */
	public String getUltBedCnt07() {
		return ultBedCnt07;
	}

	/**
	 * @param ultBedCnt07 セットする ultBedCnt07
	 */
	public void setUltBedCnt07(String ultBedCnt07) {
		this.ultBedCnt07 = ultBedCnt07;
	}

	/**
	 * NF012DTO.javaultBedsTotを設定
	 * @return ultBedsTot
	 */
	public String getUltBedsTot() {
		return ultBedsTot;
	}

	/**
	 * @param ultBedsTot セットする ultBedsTot
	 */
	public void setUltBedsTot(String ultBedsTot) {
		this.ultBedsTot = ultBedsTot;
	}

	/**
	 * NF012DTO.javaultMedBedsTotを設定
	 * @return ultMedBedsTot
	 */
	public String getUltMedBedsTot() {
		return ultMedBedsTot;
	}

	/**
	 * @param ultMedBedsTot セットする ultMedBedsTot
	 */
	public void setUltMedBedsTot(String ultMedBedsTot) {
		this.ultMedBedsTot = ultMedBedsTot;
	}

	/**
	 * NF012DTO.javanextBedCntBaseを設定
	 * @return nextBedCntBase
	 */
	public String getNextBedCntBase() {
		return nextBedCntBase;
	}

	/**
	 * @param nextBedCntBase セットする nextBedCntBase
	 */
	public void setNextBedCntBase(String nextBedCntBase) {
		this.nextBedCntBase = nextBedCntBase;
	}

	/**
	 * NF012DTO.javanextBedCnt01を設定
	 * @return nextBedCnt01
	 */
	public String getNextBedCnt01() {
		return nextBedCnt01;
	}

	/**
	 * @param nextBedCnt01 セットする nextBedCnt01
	 */
	public void setNextBedCnt01(String nextBedCnt01) {
		this.nextBedCnt01 = nextBedCnt01;
	}

	/**
	 * NF012DTO.javanextBedCnt02を設定
	 * @return nextBedCnt02
	 */
	public String getNextBedCnt02() {
		return nextBedCnt02;
	}

	/**
	 * @param nextBedCnt02 セットする nextBedCnt02
	 */
	public void setNextBedCnt02(String nextBedCnt02) {
		this.nextBedCnt02 = nextBedCnt02;
	}

	/**
	 * NF012DTO.javanextBedCnt03を設定
	 * @return nextBedCnt03
	 */
	public String getNextBedCnt03() {
		return nextBedCnt03;
	}

	/**
	 * @param nextBedCnt03 セットする nextBedCnt03
	 */
	public void setNextBedCnt03(String nextBedCnt03) {
		this.nextBedCnt03 = nextBedCnt03;
	}

	/**
	 * NF012DTO.javanextBedCnt04を設定
	 * @return nextBedCnt04
	 */
	public String getNextBedCnt04() {
		return nextBedCnt04;
	}

	/**
	 * @param nextBedCnt04 セットする nextBedCnt04
	 */
	public void setNextBedCnt04(String nextBedCnt04) {
		this.nextBedCnt04 = nextBedCnt04;
	}

	/**
	 * NF012DTO.javanextBedCnt05を設定
	 * @return nextBedCnt05
	 */
	public String getNextBedCnt05() {
		return nextBedCnt05;
	}

	/**
	 * @param nextBedCnt05 セットする nextBedCnt05
	 */
	public void setNextBedCnt05(String nextBedCnt05) {
		this.nextBedCnt05 = nextBedCnt05;
	}

	/**
	 * NF012DTO.javanextBedCnt06を設定
	 * @return nextBedCnt06
	 */
	public String getNextBedCnt06() {
		return nextBedCnt06;
	}

	/**
	 * @param nextBedCnt06 セットする nextBedCnt06
	 */
	public void setNextBedCnt06(String nextBedCnt06) {
		this.nextBedCnt06 = nextBedCnt06;
	}

	/**
	 * NF012DTO.javanextBedCnt07を設定
	 * @return nextBedCnt07
	 */
	public String getNextBedCnt07() {
		return nextBedCnt07;
	}

	/**
	 * @param nextBedCnt07 セットする nextBedCnt07
	 */
	public void setNextBedCnt07(String nextBedCnt07) {
		this.nextBedCnt07 = nextBedCnt07;
	}

	/**
	 * NF012DTO.javanextBedsTotを設定
	 * @return nextBedsTot
	 */
	public String getNextBedsTot() {
		return nextBedsTot;
	}

	/**
	 * @param nextBedsTot セットする nextBedsTot
	 */
	public void setNextBedsTot(String nextBedsTot) {
		this.nextBedsTot = nextBedsTot;
	}

	/**
	 * NF012DTO.javanextMedBedsTotを設定
	 * @return nextMedBedsTot
	 */
	public String getNextMedBedsTot() {
		return nextMedBedsTot;
	}

	/**
	 * @param nextMedBedsTot セットする nextMedBedsTot
	 */
	public void setNextMedBedsTot(String nextMedBedsTot) {
		this.nextMedBedsTot = nextMedBedsTot;
	}

	/**
	 * NF012DTO.javainsPcodeを設定
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
	 * NF012DTO.javainsAddrを設定
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
	 * NF012DTO.javainsAddrKanaを設定
	 * @return insAddrKana
	 */
	public String getInsAddrKana() {
		return insAddrKana;
	}

	/**
	 * @param insAddrKana セットする insAddrKana
	 */
	public void setInsAddrKana(String insAddrKana) {
		this.insAddrKana = insAddrKana;
	}

	/**
	 * NF012DTO.javaaddrCodePrefを設定
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
	 * NF012DTO.javaaddrCodePrefNameを設定
	 * @return addrCodePrefName
	 */
	public String getAddrCodePrefName() {
		return addrCodePrefName;
	}

	/**
	 * @param addrCodePrefName セットする addrCodePrefName
	 */
	public void setAddrCodePrefName(String addrCodePrefName) {
		this.addrCodePrefName = addrCodePrefName;
	}

	/**
	 * NF012DTO.javaaddrCodeCityを設定
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
	 * NF012DTO.javaaddrCodeCityNameを設定
	 * @return addrCodeCityName
	 */
	public String getAddrCodeCityName() {
		return addrCodeCityName;
	}

	/**
	 * @param addrCodeCityName セットする addrCodeCityName
	 */
	public void setAddrCodeCityName(String addrCodeCityName) {
		this.addrCodeCityName = addrCodeCityName;
	}

	/**
	 * NF012DTO.javainsAddrDtを設定
	 * @return insAddrDt
	 */
	public String getInsAddrDt() {
		return insAddrDt;
	}

	/**
	 * @param insAddrDt セットする insAddrDt
	 */
	public void setInsAddrDt(String insAddrDt) {
		this.insAddrDt = insAddrDt;
	}

	/**
	 * NF012DTO.javatkCityCdを設定
	 * @return tkCityCd
	 */
	public String getTkCityCd() {
		return tkCityCd;
	}

	/**
	 * @param tkCityCd セットする tkCityCd
	 */
	public void setTkCityCd(String tkCityCd) {
		this.tkCityCd = tkCityCd;
	}

	/**
	 * NF012DTO.javatkCityNameを設定
	 * @return tkCityName
	 */
	public String getTkCityName() {
		return tkCityName;
	}

	/**
	 * @param tkCityName セットする tkCityName
	 */
	public void setTkCityName(String tkCityName) {
		this.tkCityName = tkCityName;
	}

	/**
	 * NF012DTO.javainsPhone1を設定
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
	 * NF012DTO.javainsPhone2を設定
	 * @return insPhone2
	 */
	public String getInsPhone2() {
		return insPhone2;
	}

	/**
	 * @param insPhone2 セットする insPhone2
	 */
	public void setInsPhone2(String insPhone2) {
		this.insPhone2 = insPhone2;
	}

	/**
	 * NF012DTO.javainsFax1を設定
	 * @return insFax1
	 */
	public String getInsFax1() {
		return insFax1;
	}

	/**
	 * @param insFax1 セットする insFax1
	 */
	public void setInsFax1(String insFax1) {
		this.insFax1 = insFax1;
	}

	/**
	 * NF012DTO.javainsFax2を設定
	 * @return insFax2
	 */
	public String getInsFax2() {
		return insFax2;
	}

	/**
	 * @param insFax2 セットする insFax2
	 */
	public void setInsFax2(String insFax2) {
		this.insFax2 = insFax2;
	}

	/**
	 * NF012DTO.javainsUrlを設定
	 * @return insUrl
	 */
	public String getInsUrl() {
		return insUrl;
	}

	/**
	 * @param insUrl セットする insUrl
	 */
	public void setInsUrl(String insUrl) {
		this.insUrl = insUrl;
	}

	/**
	 * NF012DTO.javainsUrlYmdを設定
	 * @return insUrlYmd
	 */
	public String getInsUrlYmd() {
		return insUrlYmd;
	}

	/**
	 * @param insUrlYmd セットする insUrlYmd
	 */
	public void setInsUrlYmd(String insUrlYmd) {
		this.insUrlYmd = insUrlYmd;
	}

	/**
	 * NF012DTO.javafree0001を設定
	 * @return free0001
	 */
	public String getFree0001() {
		return free0001;
	}

	/**
	 * @param free0001 セットする free0001
	 */
	public void setFree0001(String free0001) {
		this.free0001 = free0001;
	}

	/**
	 * NF012DTO.javafree0002を設定
	 * @return free0002
	 */
	public String getFree0002() {
		return free0002;
	}

	/**
	 * @param free0002 セットする free0002
	 */
	public void setFree0002(String free0002) {
		this.free0002 = free0002;
	}

	/**
	 * NF012DTO.javafree0003を設定
	 * @return free0003
	 */
	public String getFree0003() {
		return free0003;
	}

	/**
	 * @param free0003 セットする free0003
	 */
	public void setFree0003(String free0003) {
		this.free0003 = free0003;
	}

	/**
	 * NF012DTO.javafree0015を設定
	 * @return free0015
	 */
	public String getFree0015() {
		return free0015;
	}

	/**
	 * @param free0015 セットする free0015
	 */
	public void setFree0015(String free0015) {
		this.free0015 = free0015;
	}

	/**
	 * NF012DTO.javafree0008を設定
	 * @return free0008
	 */
	public String getFree0008() {
		return free0008;
	}

	/**
	 * @param free0008 セットする free0008
	 */
	public void setFree0008(String free0008) {
		this.free0008 = free0008;
	}

	/**
	 * NF012DTO.javafree0009を設定
	 * @return free0009
	 */
	public String getFree0009() {
		return free0009;
	}

	/**
	 * @param free0009 セットする free0009
	 */
	public void setFree0009(String free0009) {
		this.free0009 = free0009;
	}

	/**
	 * NF012DTO.javafree0004を設定
	 * @return free0004
	 */
	public String getFree0004() {
		return free0004;
	}

	/**
	 * @param free0004 セットする free0004
	 */
	public void setFree0004(String free0004) {
		this.free0004 = free0004;
	}

	/**
	 * NF012DTO.javafree0005を設定
	 * @return free0005
	 */
	public String getFree0005() {
		return free0005;
	}

	/**
	 * @param free0005 セットする free0005
	 */
	public void setFree0005(String free0005) {
		this.free0005 = free0005;
	}

	/**
	 * NF012DTO.javafree0006を設定
	 * @return free0006
	 */
	public String getFree0006() {
		return free0006;
	}

	/**
	 * @param free0006 セットする free0006
	 */
	public void setFree0006(String free0006) {
		this.free0006 = free0006;
	}

	/**
	 * NF012DTO.javafree0007を設定
	 * @return free0007
	 */
	public String getFree0007() {
		return free0007;
	}

	/**
	 * @param free0007 セットする free0007
	 */
	public void setFree0007(String free0007) {
		this.free0007 = free0007;
	}

	/**
	 * NF012DTO.javafree0010を設定
	 * @return free0010
	 */
	public String getFree0010() {
		return free0010;
	}

	/**
	 * @param free0010 セットする free0010
	 */
	public void setFree0010(String free0010) {
		this.free0010 = free0010;
	}

	/**
	 * NF012DTO.javafree0011を設定
	 * @return free0011
	 */
	public String getFree0011() {
		return free0011;
	}

	/**
	 * @param free0011 セットする free0011
	 */
	public void setFree0011(String free0011) {
		this.free0011 = free0011;
	}

	/**
	 * NF012DTO.javafree0013を設定
	 * @return free0013
	 */
	public String getFree0013() {
		return free0013;
	}

	/**
	 * @param free0013 セットする free0013
	 */
	public void setFree0013(String free0013) {
		this.free0013 = free0013;
	}

	/**
	 * NF012DTO.javafree0014を設定
	 * @return free0014
	 */
	public String getFree0014() {
		return free0014;
	}

	/**
	 * @param free0014 セットする free0014
	 */
	public void setFree0014(String free0014) {
		this.free0014 = free0014;
	}

	/**
	 * NF012DTO.javafree0012を設定
	 * @return free0012
	 */
	public String getFree0012() {
		return free0012;
	}

	/**
	 * @param free0012 セットする free0012
	 */
	public void setFree0012(String free0012) {
		this.free0012 = free0012;
	}

	/**
	 * NF012DTO.javawelfare02を設定
	 * @return welfare02
	 */
	public String getWelfare02() {
		return welfare02;
	}

	/**
	 * @param welfare02 セットする welfare02
	 */
	public void setWelfare02(String welfare02) {
		this.welfare02 = welfare02;
	}

	/**
	 * NF012DTO.javawelfare02Nmを設定
	 * @return welfare02Nm
	 */
	public String getWelfare02Nm() {
		return welfare02Nm;
	}

	/**
	 * @param welfare02Nm セットする welfare02Nm
	 */
	public void setWelfare02Nm(String welfare02Nm) {
		this.welfare02Nm = welfare02Nm;
	}

	/**
	 * NF012DTO.javawelfare08Nmを設定
	 * @return welfare08Nm
	 */
	public String getWelfare08Nm() {
		return welfare08Nm;
	}

	/**
	 * @param welfare08Nm セットする welfare08Nm
	 */
	public void setWelfare08Nm(String welfare08Nm) {
		this.welfare08Nm = welfare08Nm;
	}

	/**
	 * NF012DTO.javawelfare08を設定
	 * @return welfare08
	 */
	public String getWelfare08() {
		return welfare08;
	}

	/**
	 * @param welfare08 セットする welfare08
	 */
	public void setWelfare08(String welfare08) {
		this.welfare08 = welfare08;
	}

	/**
	 * NF012DTO.javaresult01を設定
	 * @return result01
	 */
	public String getResult01() {
		return result01;
	}

	/**
	 * @param result01 セットする result01
	 */
	public void setResult01(String result01) {
		this.result01 = result01;
	}

	/**
	 * NF012DTO.javaresult02を設定
	 * @return result02
	 */
	public String getResult02() {
		return result02;
	}

	/**
	 * @param result02 セットする result02
	 */
	public void setResult02(String result02) {
		this.result02 = result02;
	}

	/**
	 * NF012DTO.javaresult03を設定
	 * @return result03
	 */
	public String getResult03() {
		return result03;
	}

	/**
	 * @param result03 セットする result03
	 */
	public void setResult03(String result03) {
		this.result03 = result03;
	}

	/**
	 * NF012DTO.javaresult04を設定
	 * @return result04
	 */
	public String getResult04() {
		return result04;
	}

	/**
	 * @param result04 セットする result04
	 */
	public void setResult04(String result04) {
		this.result04 = result04;
	}

	/**
	 * NF012DTO.javaresult05を設定
	 * @return result05
	 */
	public String getResult05() {
		return result05;
	}

	/**
	 * @param result05 セットする result05
	 */
	public void setResult05(String result05) {
		this.result05 = result05;
	}

	/**
	 * NF012DTO.javaresult06を設定
	 * @return result06
	 */
	public String getResult06() {
		return result06;
	}

	/**
	 * @param result06 セットする result06
	 */
	public void setResult06(String result06) {
		this.result06 = result06;
	}

	/**
	 * NF012DTO.javaresult07を設定
	 * @return result07
	 */
	public String getResult07() {
		return result07;
	}

	/**
	 * @param result07 セットする result07
	 */
	public void setResult07(String result07) {
		this.result07 = result07;
	}

	/**
	 * NF012DTO.javaresult08を設定
	 * @return result08
	 */
	public String getResult08() {
		return result08;
	}

	/**
	 * @param result08 セットする result08
	 */
	public void setResult08(String result08) {
		this.result08 = result08;
	}

	/**
	 * NF012DTO.javaresult09を設定
	 * @return result09
	 */
	public String getResult09() {
		return result09;
	}

	/**
	 * @param result09 セットする result09
	 */
	public void setResult09(String result09) {
		this.result09 = result09;
	}

	/**
	 * NF012DTO.javaresult10を設定
	 * @return result10
	 */
	public String getResult10() {
		return result10;
	}

	/**
	 * @param result10 セットする result10
	 */
	public void setResult10(String result10) {
		this.result10 = result10;
	}

	/**
	 * NF012DTO.javaresult11を設定
	 * @return result11
	 */
	public String getResult11() {
		return result11;
	}

	/**
	 * @param result11 セットする result11
	 */
	public void setResult11(String result11) {
		this.result11 = result11;
	}

	/**
	 * NF012DTO.javaresult12を設定
	 * @return result12
	 */
	public String getResult12() {
		return result12;
	}

	/**
	 * @param result12 セットする result12
	 */
	public void setResult12(String result12) {
		this.result12 = result12;
	}

	/**
	 * NF012DTO.javaresult13を設定
	 * @return result13
	 */
	public String getResult13() {
		return result13;
	}

	/**
	 * @param result13 セットする result13
	 */
	public void setResult13(String result13) {
		this.result13 = result13;
	}

	/**
	 * NF012DTO.javaresult14を設定
	 * @return result14
	 */
	public String getResult14() {
		return result14;
	}

	/**
	 * @param result14 セットする result14
	 */
	public void setResult14(String result14) {
		this.result14 = result14;
	}

	/**
	 * NF012DTO.javaresult15を設定
	 * @return result15
	 */
	public String getResult15() {
		return result15;
	}

	/**
	 * @param result15 セットする result15
	 */
	public void setResult15(String result15) {
		this.result15 = result15;
	}

	/**
	 * NF012DTO.javaresult16を設定
	 * @return result16
	 */
	public String getResult16() {
		return result16;
	}

	/**
	 * @param result16 セットする result16
	 */
	public void setResult16(String result16) {
		this.result16 = result16;
	}

	/**
	 * NF012DTO.javaresult17を設定
	 * @return result17
	 */
	public String getResult17() {
		return result17;
	}

	/**
	 * @param result17 セットする result17
	 */
	public void setResult17(String result17) {
		this.result17 = result17;
	}

	/**
	 * NF012DTO.javaresult18を設定
	 * @return result18
	 */
	public String getResult18() {
		return result18;
	}

	/**
	 * @param result18 セットする result18
	 */
	public void setResult18(String result18) {
		this.result18 = result18;
	}

	/**
	 * NF012DTO.javaresult19を設定
	 * @return result19
	 */
	public String getResult19() {
		return result19;
	}

	/**
	 * @param result19 セットする result19
	 */
	public void setResult19(String result19) {
		this.result19 = result19;
	}

	/**
	 * NF012DTO.javaresult20を設定
	 * @return result20
	 */
	public String getResult20() {
		return result20;
	}

	/**
	 * @param result20 セットする result20
	 */
	public void setResult20(String result20) {
		this.result20 = result20;
	}

	/**
	 * NF012DTO.javaresult21を設定
	 * @return result21
	 */
	public String getResult21() {
		return result21;
	}

	/**
	 * @param result21 セットする result21
	 */
	public void setResult21(String result21) {
		this.result21 = result21;
	}

	/**
	 * NF012DTO.javaresult22を設定
	 * @return result22
	 */
	public String getResult22() {
		return result22;
	}

	/**
	 * @param result22 セットする result22
	 */
	public void setResult22(String result22) {
		this.result22 = result22;
	}

	/**
	 * NF012DTO.javaresult23を設定
	 * @return result23
	 */
	public String getResult23() {
		return result23;
	}

	/**
	 * @param result23 セットする result23
	 */
	public void setResult23(String result23) {
		this.result23 = result23;
	}

	/**
	 * NF012DTO.javaresult24を設定
	 * @return result24
	 */
	public String getResult24() {
		return result24;
	}

	/**
	 * @param result24 セットする result24
	 */
	public void setResult24(String result24) {
		this.result24 = result24;
	}

	/**
	 * NF012DTO.javaresult25を設定
	 * @return result25
	 */
	public String getResult25() {
		return result25;
	}

	/**
	 * @param result25 セットする result25
	 */
	public void setResult25(String result25) {
		this.result25 = result25;
	}

	/**
	 * NF012DTO.javaresult26を設定
	 * @return result26
	 */
	public String getResult26() {
		return result26;
	}

	/**
	 * @param result26 セットする result26
	 */
	public void setResult26(String result26) {
		this.result26 = result26;
	}

	/**
	 * NF012DTO.javaresult27を設定
	 * @return result27
	 */
	public String getResult27() {
		return result27;
	}

	/**
	 * @param result27 セットする result27
	 */
	public void setResult27(String result27) {
		this.result27 = result27;
	}

	/**
	 * NF012DTO.javaresult28を設定
	 * @return result28
	 */
	public String getResult28() {
		return result28;
	}

	/**
	 * @param result28 セットする result28
	 */
	public void setResult28(String result28) {
		this.result28 = result28;
	}

	/**
	 * NF012DTO.javaresult29を設定
	 * @return result29
	 */
	public String getResult29() {
		return result29;
	}

	/**
	 * @param result29 セットする result29
	 */
	public void setResult29(String result29) {
		this.result29 = result29;
	}

	/**
	 * NF012DTO.javaresult30を設定
	 * @return result30
	 */
	public String getResult30() {
		return result30;
	}

	/**
	 * @param result30 セットする result30
	 */
	public void setResult30(String result30) {
		this.result30 = result30;
	}

	/**
	 * NF012DTO.javaresult31を設定
	 * @return result31
	 */
	public String getResult31() {
		return result31;
	}

	/**
	 * @param result31 セットする result31
	 */
	public void setResult31(String result31) {
		this.result31 = result31;
	}

	/**
	 * NF012DTO.javaresult32を設定
	 * @return result32
	 */
	public String getResult32() {
		return result32;
	}

	/**
	 * @param result32 セットする result32
	 */
	public void setResult32(String result32) {
		this.result32 = result32;
	}

	/**
	 * NF012DTO.javaresult33を設定
	 * @return result33
	 */
	public String getResult33() {
		return result33;
	}

	/**
	 * @param result33 セットする result33
	 */
	public void setResult33(String result33) {
		this.result33 = result33;
	}

	/**
	 * NF012DTO.javaresult34を設定
	 * @return result34
	 */
	public String getResult34() {
		return result34;
	}

	/**
	 * @param result34 セットする result34
	 */
	public void setResult34(String result34) {
		this.result34 = result34;
	}

	/**
	 * NF012DTO.javaresult35を設定
	 * @return result35
	 */
	public String getResult35() {
		return result35;
	}

	/**
	 * @param result35 セットする result35
	 */
	public void setResult35(String result35) {
		this.result35 = result35;
	}

	/**
	 * NF012DTO.javaresult36を設定
	 * @return result36
	 */
	public String getResult36() {
		return result36;
	}

	/**
	 * @param result36 セットする result36
	 */
	public void setResult36(String result36) {
		this.result36 = result36;
	}

	/**
	 * NF012DTO.javaresult01Nmを設定
	 * @return result01Nm
	 */
	public String getResult01Nm() {
		return result01Nm;
	}

	/**
	 * @param result01Nm セットする result01Nm
	 */
	public void setResult01Nm(String result01Nm) {
		this.result01Nm = result01Nm;
	}

	/**
	 * NF012DTO.javaresult02Nmを設定
	 * @return result02Nm
	 */
	public String getResult02Nm() {
		return result02Nm;
	}

	/**
	 * @param result02Nm セットする result02Nm
	 */
	public void setResult02Nm(String result02Nm) {
		this.result02Nm = result02Nm;
	}

	/**
	 * NF012DTO.javaresult03Nmを設定
	 * @return result03Nm
	 */
	public String getResult03Nm() {
		return result03Nm;
	}

	/**
	 * @param result03Nm セットする result03Nm
	 */
	public void setResult03Nm(String result03Nm) {
		this.result03Nm = result03Nm;
	}

	/**
	 * NF012DTO.javaresult04Nmを設定
	 * @return result04Nm
	 */
	public String getResult04Nm() {
		return result04Nm;
	}

	/**
	 * @param result04Nm セットする result04Nm
	 */
	public void setResult04Nm(String result04Nm) {
		this.result04Nm = result04Nm;
	}

	/**
	 * NF012DTO.javaresult05Nmを設定
	 * @return result05Nm
	 */
	public String getResult05Nm() {
		return result05Nm;
	}

	/**
	 * @param result05Nm セットする result05Nm
	 */
	public void setResult05Nm(String result05Nm) {
		this.result05Nm = result05Nm;
	}

	/**
	 * NF012DTO.javaresult06Nmを設定
	 * @return result06Nm
	 */
	public String getResult06Nm() {
		return result06Nm;
	}

	/**
	 * @param result06Nm セットする result06Nm
	 */
	public void setResult06Nm(String result06Nm) {
		this.result06Nm = result06Nm;
	}

	/**
	 * NF012DTO.javaresult07Nmを設定
	 * @return result07Nm
	 */
	public String getResult07Nm() {
		return result07Nm;
	}

	/**
	 * @param result07Nm セットする result07Nm
	 */
	public void setResult07Nm(String result07Nm) {
		this.result07Nm = result07Nm;
	}

	/**
	 * NF012DTO.javaresult08Nmを設定
	 * @return result08Nm
	 */
	public String getResult08Nm() {
		return result08Nm;
	}

	/**
	 * @param result08Nm セットする result08Nm
	 */
	public void setResult08Nm(String result08Nm) {
		this.result08Nm = result08Nm;
	}

	/**
	 * NF012DTO.javaresult09Nmを設定
	 * @return result09Nm
	 */
	public String getResult09Nm() {
		return result09Nm;
	}

	/**
	 * @param result09Nm セットする result09Nm
	 */
	public void setResult09Nm(String result09Nm) {
		this.result09Nm = result09Nm;
	}

	/**
	 * NF012DTO.javaresult10Nmを設定
	 * @return result10Nm
	 */
	public String getResult10Nm() {
		return result10Nm;
	}

	/**
	 * @param result10Nm セットする result10Nm
	 */
	public void setResult10Nm(String result10Nm) {
		this.result10Nm = result10Nm;
	}

	/**
	 * NF012DTO.javaresult11Nmを設定
	 * @return result11Nm
	 */
	public String getResult11Nm() {
		return result11Nm;
	}

	/**
	 * @param result11Nm セットする result11Nm
	 */
	public void setResult11Nm(String result11Nm) {
		this.result11Nm = result11Nm;
	}

	/**
	 * NF012DTO.javaresult12Nmを設定
	 * @return result12Nm
	 */
	public String getResult12Nm() {
		return result12Nm;
	}

	/**
	 * @param result12Nm セットする result12Nm
	 */
	public void setResult12Nm(String result12Nm) {
		this.result12Nm = result12Nm;
	}

	/**
	 * NF012DTO.javaresult13Nmを設定
	 * @return result13Nm
	 */
	public String getResult13Nm() {
		return result13Nm;
	}

	/**
	 * @param result13Nm セットする result13Nm
	 */
	public void setResult13Nm(String result13Nm) {
		this.result13Nm = result13Nm;
	}

	/**
	 * NF012DTO.javaresult14Nmを設定
	 * @return result14Nm
	 */
	public String getResult14Nm() {
		return result14Nm;
	}

	/**
	 * @param result14Nm セットする result14Nm
	 */
	public void setResult14Nm(String result14Nm) {
		this.result14Nm = result14Nm;
	}

	/**
	 * NF012DTO.javaresult15Nmを設定
	 * @return result15Nm
	 */
	public String getResult15Nm() {
		return result15Nm;
	}

	/**
	 * @param result15Nm セットする result15Nm
	 */
	public void setResult15Nm(String result15Nm) {
		this.result15Nm = result15Nm;
	}

	/**
	 * NF012DTO.javaresult16Nmを設定
	 * @return result16Nm
	 */
	public String getResult16Nm() {
		return result16Nm;
	}

	/**
	 * @param result16Nm セットする result16Nm
	 */
	public void setResult16Nm(String result16Nm) {
		this.result16Nm = result16Nm;
	}

	/**
	 * NF012DTO.javaresult17Nmを設定
	 * @return result17Nm
	 */
	public String getResult17Nm() {
		return result17Nm;
	}

	/**
	 * @param result17Nm セットする result17Nm
	 */
	public void setResult17Nm(String result17Nm) {
		this.result17Nm = result17Nm;
	}

	/**
	 * NF012DTO.javaresult18Nmを設定
	 * @return result18Nm
	 */
	public String getResult18Nm() {
		return result18Nm;
	}

	/**
	 * @param result18Nm セットする result18Nm
	 */
	public void setResult18Nm(String result18Nm) {
		this.result18Nm = result18Nm;
	}

	/**
	 * NF012DTO.javaresult19Nmを設定
	 * @return result19Nm
	 */
	public String getResult19Nm() {
		return result19Nm;
	}

	/**
	 * @param result19Nm セットする result19Nm
	 */
	public void setResult19Nm(String result19Nm) {
		this.result19Nm = result19Nm;
	}

	/**
	 * NF012DTO.javaresult20Nmを設定
	 * @return result20Nm
	 */
	public String getResult20Nm() {
		return result20Nm;
	}

	/**
	 * @param result20Nm セットする result20Nm
	 */
	public void setResult20Nm(String result20Nm) {
		this.result20Nm = result20Nm;
	}

	/**
	 * NF012DTO.javaresult21Nmを設定
	 * @return result21Nm
	 */
	public String getResult21Nm() {
		return result21Nm;
	}

	/**
	 * @param result21Nm セットする result21Nm
	 */
	public void setResult21Nm(String result21Nm) {
		this.result21Nm = result21Nm;
	}

	/**
	 * NF012DTO.javaresult22Nmを設定
	 * @return result22Nm
	 */
	public String getResult22Nm() {
		return result22Nm;
	}

	/**
	 * @param result22Nm セットする result22Nm
	 */
	public void setResult22Nm(String result22Nm) {
		this.result22Nm = result22Nm;
	}

	/**
	 * NF012DTO.javaresult23Nmを設定
	 * @return result23Nm
	 */
	public String getResult23Nm() {
		return result23Nm;
	}

	/**
	 * @param result23Nm セットする result23Nm
	 */
	public void setResult23Nm(String result23Nm) {
		this.result23Nm = result23Nm;
	}

	/**
	 * NF012DTO.javaresult24Nmを設定
	 * @return result24Nm
	 */
	public String getResult24Nm() {
		return result24Nm;
	}

	/**
	 * @param result24Nm セットする result24Nm
	 */
	public void setResult24Nm(String result24Nm) {
		this.result24Nm = result24Nm;
	}

	/**
	 * NF012DTO.javaresult25Nmを設定
	 * @return result25Nm
	 */
	public String getResult25Nm() {
		return result25Nm;
	}

	/**
	 * @param result25Nm セットする result25Nm
	 */
	public void setResult25Nm(String result25Nm) {
		this.result25Nm = result25Nm;
	}

	/**
	 * NF012DTO.javaresult26Nmを設定
	 * @return result26Nm
	 */
	public String getResult26Nm() {
		return result26Nm;
	}

	/**
	 * @param result26Nm セットする result26Nm
	 */
	public void setResult26Nm(String result26Nm) {
		this.result26Nm = result26Nm;
	}

	/**
	 * NF012DTO.javaresult27Nmを設定
	 * @return result27Nm
	 */
	public String getResult27Nm() {
		return result27Nm;
	}

	/**
	 * @param result27Nm セットする result27Nm
	 */
	public void setResult27Nm(String result27Nm) {
		this.result27Nm = result27Nm;
	}

	/**
	 * NF012DTO.javaresult28Nmを設定
	 * @return result28Nm
	 */
	public String getResult28Nm() {
		return result28Nm;
	}

	/**
	 * @param result28Nm セットする result28Nm
	 */
	public void setResult28Nm(String result28Nm) {
		this.result28Nm = result28Nm;
	}

	/**
	 * NF012DTO.javaresult29Nmを設定
	 * @return result29Nm
	 */
	public String getResult29Nm() {
		return result29Nm;
	}

	/**
	 * @param result29Nm セットする result29Nm
	 */
	public void setResult29Nm(String result29Nm) {
		this.result29Nm = result29Nm;
	}

	/**
	 * NF012DTO.javaresult30Nmを設定
	 * @return result30Nm
	 */
	public String getResult30Nm() {
		return result30Nm;
	}

	/**
	 * @param result30Nm セットする result30Nm
	 */
	public void setResult30Nm(String result30Nm) {
		this.result30Nm = result30Nm;
	}

	/**
	 * NF012DTO.javaresult31Nmを設定
	 * @return result31Nm
	 */
	public String getResult31Nm() {
		return result31Nm;
	}

	/**
	 * @param result31Nm セットする result31Nm
	 */
	public void setResult31Nm(String result31Nm) {
		this.result31Nm = result31Nm;
	}

	/**
	 * NF012DTO.javaresult32Nmを設定
	 * @return result32Nm
	 */
	public String getResult32Nm() {
		return result32Nm;
	}

	/**
	 * @param result32Nm セットする result32Nm
	 */
	public void setResult32Nm(String result32Nm) {
		this.result32Nm = result32Nm;
	}

	/**
	 * NF012DTO.javaresult33Nmを設定
	 * @return result33Nm
	 */
	public String getResult33Nm() {
		return result33Nm;
	}

	/**
	 * @param result33Nm セットする result33Nm
	 */
	public void setResult33Nm(String result33Nm) {
		this.result33Nm = result33Nm;
	}

	/**
	 * NF012DTO.javaresult34Nmを設定
	 * @return result34Nm
	 */
	public String getResult34Nm() {
		return result34Nm;
	}

	/**
	 * @param result34Nm セットする result34Nm
	 */
	public void setResult34Nm(String result34Nm) {
		this.result34Nm = result34Nm;
	}

	/**
	 * NF012DTO.javaresult35Nmを設定
	 * @return result35Nm
	 */
	public String getResult35Nm() {
		return result35Nm;
	}

	/**
	 * @param result35Nm セットする result35Nm
	 */
	public void setResult35Nm(String result35Nm) {
		this.result35Nm = result35Nm;
	}

	/**
	 * NF012DTO.javaresult36Nmを設定
	 * @return result36Nm
	 */
	public String getResult36Nm() {
		return result36Nm;
	}

	/**
	 * @param result36Nm セットする result36Nm
	 */
	public void setResult36Nm(String result36Nm) {
		this.result36Nm = result36Nm;
	}

	/**
	 * NF012DTO.javaequip01を設定
	 * @return equip01
	 */
	public String getEquip01() {
		return equip01;
	}

	/**
	 * @param equip01 セットする equip01
	 */
	public void setEquip01(String equip01) {
		this.equip01 = equip01;
	}

	/**
	 * NF012DTO.javaequip02を設定
	 * @return equip02
	 */
	public String getEquip02() {
		return equip02;
	}

	/**
	 * @param equip02 セットする equip02
	 */
	public void setEquip02(String equip02) {
		this.equip02 = equip02;
	}

	/**
	 * NF012DTO.javaequip03を設定
	 * @return equip03
	 */
	public String getEquip03() {
		return equip03;
	}

	/**
	 * @param equip03 セットする equip03
	 */
	public void setEquip03(String equip03) {
		this.equip03 = equip03;
	}

	/**
	 * NF012DTO.javaequip07を設定
	 * @return equip07
	 */
	public String getEquip07() {
		return equip07;
	}

	/**
	 * @param equip07 セットする equip07
	 */
	public void setEquip07(String equip07) {
		this.equip07 = equip07;
	}

	/**
	 * NF012DTO.javaequip09を設定
	 * @return equip09
	 */
	public String getEquip09() {
		return equip09;
	}

	/**
	 * @param equip09 セットする equip09
	 */
	public void setEquip09(String equip09) {
		this.equip09 = equip09;
	}

	/**
	 * NF012DTO.javaequip01Nmを設定
	 * @return equip01Nm
	 */
	public String getEquip01Nm() {
		return equip01Nm;
	}

	/**
	 * @param equip01Nm セットする equip01Nm
	 */
	public void setEquip01Nm(String equip01Nm) {
		this.equip01Nm = equip01Nm;
	}

	/**
	 * NF012DTO.javaequip02Nmを設定
	 * @return equip02Nm
	 */
	public String getEquip02Nm() {
		return equip02Nm;
	}

	/**
	 * @param equip02Nm セットする equip02Nm
	 */
	public void setEquip02Nm(String equip02Nm) {
		this.equip02Nm = equip02Nm;
	}

	/**
	 * NF012DTO.javaequip03Nmを設定
	 * @return equip03Nm
	 */
	public String getEquip03Nm() {
		return equip03Nm;
	}

	/**
	 * @param equip03Nm セットする equip03Nm
	 */
	public void setEquip03Nm(String equip03Nm) {
		this.equip03Nm = equip03Nm;
	}

	/**
	 * NF012DTO.javaequip07Nmを設定
	 * @return equip07Nm
	 */
	public String getEquip07Nm() {
		return equip07Nm;
	}

	/**
	 * @param equip07Nm セットする equip07Nm
	 */
	public void setEquip07Nm(String equip07Nm) {
		this.equip07Nm = equip07Nm;
	}

	/**
	 * NF012DTO.javaequip09Nmを設定
	 * @return equip09Nm
	 */
	public String getEquip09Nm() {
		return equip09Nm;
	}

	/**
	 * @param equip09Nm セットする equip09Nm
	 */
	public void setEquip09Nm(String equip09Nm) {
		this.equip09Nm = equip09Nm;
	}

	/**
	 * NF012DTO.javamarket01を設定
	 * @return market01
	 */
	public String getMarket01() {
		return market01;
	}

	/**
	 * @param market01 セットする market01
	 */
	public void setMarket01(String market01) {
		this.market01 = market01;
	}

	/**
	 * NF012DTO.javamarket02を設定
	 * @return market02
	 */
	public String getMarket02() {
		return market02;
	}

	/**
	 * @param market02 セットする market02
	 */
	public void setMarket02(String market02) {
		this.market02 = market02;
	}

	/**
	 * NF012DTO.javamarket03を設定
	 * @return market03
	 */
	public String getMarket03() {
		return market03;
	}

	/**
	 * @param market03 セットする market03
	 */
	public void setMarket03(String market03) {
		this.market03 = market03;
	}

	/**
	 * NF012DTO.javamarket04を設定
	 * @return market04
	 */
	public String getMarket04() {
		return market04;
	}

	/**
	 * @param market04 セットする market04
	 */
	public void setMarket04(String market04) {
		this.market04 = market04;
	}

	/**
	 * NF012DTO.javamarket06を設定
	 * @return market06
	 */
	public String getMarket06() {
		return market06;
	}

	/**
	 * @param market06 セットする market06
	 */
	public void setMarket06(String market06) {
		this.market06 = market06;
	}

	/**
	 * NF012DTO.javamarket07を設定
	 * @return market07
	 */
	public String getMarket07() {
		return market07;
	}

	/**
	 * @param market07 セットする market07
	 */
	public void setMarket07(String market07) {
		this.market07 = market07;
	}

	/**
	 * NF012DTO.javamarket09を設定
	 * @return market09
	 */
	public String getMarket09() {
		return market09;
	}

	/**
	 * @param market09 セットする market09
	 */
	public void setMarket09(String market09) {
		this.market09 = market09;
	}

	/**
	 * NF012DTO.javamarket01Nmを設定
	 * @return market01Nm
	 */
	public String getMarket01Nm() {
		return market01Nm;
	}

	/**
	 * @param market01Nm セットする market01Nm
	 */
	public void setMarket01Nm(String market01Nm) {
		this.market01Nm = market01Nm;
	}

	/**
	 * NF012DTO.javamarket02Nmを設定
	 * @return market02Nm
	 */
	public String getMarket02Nm() {
		return market02Nm;
	}

	/**
	 * @param market02Nm セットする market02Nm
	 */
	public void setMarket02Nm(String market02Nm) {
		this.market02Nm = market02Nm;
	}

	/**
	 * NF012DTO.javamarket03Nmを設定
	 * @return market03Nm
	 */
	public String getMarket03Nm() {
		return market03Nm;
	}

	/**
	 * @param market03Nm セットする market03Nm
	 */
	public void setMarket03Nm(String market03Nm) {
		this.market03Nm = market03Nm;
	}

	/**
	 * NF012DTO.javamarket04Nmを設定
	 * @return market04Nm
	 */
	public String getMarket04Nm() {
		return market04Nm;
	}

	/**
	 * @param market04Nm セットする market04Nm
	 */
	public void setMarket04Nm(String market04Nm) {
		this.market04Nm = market04Nm;
	}

	/**
	 * NF012DTO.javamarket06Nmを設定
	 * @return market06Nm
	 */
	public String getMarket06Nm() {
		return market06Nm;
	}

	/**
	 * @param market06Nm セットする market06Nm
	 */
	public void setMarket06Nm(String market06Nm) {
		this.market06Nm = market06Nm;
	}

	/**
	 * NF012DTO.javamarket07Nmを設定
	 * @return market07Nm
	 */
	public String getMarket07Nm() {
		return market07Nm;
	}

	/**
	 * @param market07Nm セットする market07Nm
	 */
	public void setMarket07Nm(String market07Nm) {
		this.market07Nm = market07Nm;
	}

	/**
	 * NF012DTO.javamarket09Nmを設定
	 * @return market09Nm
	 */
	public String getMarket09Nm() {
		return market09Nm;
	}

	/**
	 * @param market09Nm セットする market09Nm
	 */
	public void setMarket09Nm(String market09Nm) {
		this.market09Nm = market09Nm;
	}

	/**
	 * NF012DTO.javamedical12を設定
	 * @return medical12
	 */
	public String getMedical12() {
		return medical12;
	}

	/**
	 * @param medical12 セットする medical12
	 */
	public void setMedical12(String medical12) {
		this.medical12 = medical12;
	}

	/**
	 * NF012DTO.javamedical12Nmを設定
	 * @return medical12Nm
	 */
	public String getMedical12Nm() {
		return medical12Nm;
	}

	/**
	 * @param medical12Nm セットする medical12Nm
	 */
	public void setMedical12Nm(String medical12Nm) {
		this.medical12Nm = medical12Nm;
	}

	/**
	 * NF012DTO.javaspfunc01を設定
	 * @return spfunc01
	 */
	public String getSpfunc01() {
		return spfunc01;
	}

	/**
	 * @param spfunc01 セットする spfunc01
	 */
	public void setSpfunc01(String spfunc01) {
		this.spfunc01 = spfunc01;
	}

	/**
	 * NF012DTO.javaspfunc03を設定
	 * @return spfunc03
	 */
	public String getSpfunc03() {
		return spfunc03;
	}

	/**
	 * @param spfunc03 セットする spfunc03
	 */
	public void setSpfunc03(String spfunc03) {
		this.spfunc03 = spfunc03;
	}

	/**
	 * NF012DTO.javaspfunc04を設定
	 * @return spfunc04
	 */
	public String getSpfunc04() {
		return spfunc04;
	}

	/**
	 * @param spfunc04 セットする spfunc04
	 */
	public void setSpfunc04(String spfunc04) {
		this.spfunc04 = spfunc04;
	}

	/**
	 * NF012DTO.javaspfunc01Nmを設定
	 * @return spfunc01Nm
	 */
	public String getSpfunc01Nm() {
		return spfunc01Nm;
	}

	/**
	 * @param spfunc01Nm セットする spfunc01Nm
	 */
	public void setSpfunc01Nm(String spfunc01Nm) {
		this.spfunc01Nm = spfunc01Nm;
	}

	/**
	 * NF012DTO.javaspfunc03Nmを設定
	 * @return spfunc03Nm
	 */
	public String getSpfunc03Nm() {
		return spfunc03Nm;
	}

	/**
	 * @param spfunc03Nm セットする spfunc03Nm
	 */
	public void setSpfunc03Nm(String spfunc03Nm) {
		this.spfunc03Nm = spfunc03Nm;
	}

	/**
	 * NF012DTO.javaspfunc04Nmを設定
	 * @return spfunc04Nm
	 */
	public String getSpfunc04Nm() {
		return spfunc04Nm;
	}

	/**
	 * @param spfunc04Nm セットする spfunc04Nm
	 */
	public void setSpfunc04Nm(String spfunc04Nm) {
		this.spfunc04Nm = spfunc04Nm;
	}

	/**
	 * NF012DTO.javatieup10を設定
	 * @return tieup10
	 */
	public String getTieup10() {
		return tieup10;
	}

	/**
	 * @param tieup10 セットする tieup10
	 */
	public void setTieup10(String tieup10) {
		this.tieup10 = tieup10;
	}

	/**
	 * NF012DTO.javatieup11を設定
	 * @return tieup11
	 */
	public String getTieup11() {
		return tieup11;
	}

	/**
	 * @param tieup11 セットする tieup11
	 */
	public void setTieup11(String tieup11) {
		this.tieup11 = tieup11;
	}

	/**
	 * NF012DTO.javatieup12を設定
	 * @return tieup12
	 */
	public String getTieup12() {
		return tieup12;
	}

	/**
	 * @param tieup12 セットする tieup12
	 */
	public void setTieup12(String tieup12) {
		this.tieup12 = tieup12;
	}

	/**
	 * NF012DTO.javatieup10Nmを設定
	 * @return tieup10Nm
	 */
	public String getTieup10Nm() {
		return tieup10Nm;
	}

	/**
	 * @param tieup10Nm セットする tieup10Nm
	 */
	public void setTieup10Nm(String tieup10Nm) {
		this.tieup10Nm = tieup10Nm;
	}

	/**
	 * NF012DTO.javatieup11Nmを設定
	 * @return tieup11Nm
	 */
	public String getTieup11Nm() {
		return tieup11Nm;
	}

	/**
	 * @param tieup11Nm セットする tieup11Nm
	 */
	public void setTieup11Nm(String tieup11Nm) {
		this.tieup11Nm = tieup11Nm;
	}

	/**
	 * NF012DTO.javatieup12Nmを設定
	 * @return tieup12Nm
	 */
	public String getTieup12Nm() {
		return tieup12Nm;
	}

	/**
	 * @param tieup12Nm セットする tieup12Nm
	 */
	public void setTieup12Nm(String tieup12Nm) {
		this.tieup12Nm = tieup12Nm;
	}

	/**
	 * NF012DTO.javausercd0001を設定
	 * @return usercd0001
	 */
	public String getUsercd0001() {
		return usercd0001;
	}

	/**
	 * @param usercd0001 セットする usercd0001
	 */
	public void setUsercd0001(String usercd0001) {
		this.usercd0001 = usercd0001;
	}

	/**
	 * NF012DTO.javausercd0002を設定
	 * @return usercd0002
	 */
	public String getUsercd0002() {
		return usercd0002;
	}

	/**
	 * @param usercd0002 セットする usercd0002
	 */
	public void setUsercd0002(String usercd0002) {
		this.usercd0002 = usercd0002;
	}

	/**
	 * NF012DTO.javausercd0003を設定
	 * @return usercd0003
	 */
	public String getUsercd0003() {
		return usercd0003;
	}

	/**
	 * @param usercd0003 セットする usercd0003
	 */
	public void setUsercd0003(String usercd0003) {
		this.usercd0003 = usercd0003;
	}

	/**
	 * NF012DTO.javausercd0004を設定
	 * @return usercd0004
	 */
	public String getUsercd0004() {
		return usercd0004;
	}

	/**
	 * @param usercd0004 セットする usercd0004
	 */
	public void setUsercd0004(String usercd0004) {
		this.usercd0004 = usercd0004;
	}

	/**
	 * NF012DTO.javausercd0005を設定
	 * @return usercd0005
	 */
	public String getUsercd0005() {
		return usercd0005;
	}

	/**
	 * @param usercd0005 セットする usercd0005
	 */
	public void setUsercd0005(String usercd0005) {
		this.usercd0005 = usercd0005;
	}

	/**
	 * NF012DTO.javausercd0006を設定
	 * @return usercd0006
	 */
	public String getUsercd0006() {
		return usercd0006;
	}

	/**
	 * @param usercd0006 セットする usercd0006
	 */
	public void setUsercd0006(String usercd0006) {
		this.usercd0006 = usercd0006;
	}

	/**
	 * NF012DTO.javausercd0007を設定
	 * @return usercd0007
	 */
	public String getUsercd0007() {
		return usercd0007;
	}

	/**
	 * @param usercd0007 セットする usercd0007
	 */
	public void setUsercd0007(String usercd0007) {
		this.usercd0007 = usercd0007;
	}

	/**
	 * NF012DTO.javausercd0008を設定
	 * @return usercd0008
	 */
	public String getUsercd0008() {
		return usercd0008;
	}

	/**
	 * @param usercd0008 セットする usercd0008
	 */
	public void setUsercd0008(String usercd0008) {
		this.usercd0008 = usercd0008;
	}

	/**
	 * NF012DTO.javausercd0009を設定
	 * @return usercd0009
	 */
	public String getUsercd0009() {
		return usercd0009;
	}

	/**
	 * @param usercd0009 セットする usercd0009
	 */
	public void setUsercd0009(String usercd0009) {
		this.usercd0009 = usercd0009;
	}

	/**
	 * NF012DTO.javausercd0010を設定
	 * @return usercd0010
	 */
	public String getUsercd0010() {
		return usercd0010;
	}

	/**
	 * @param usercd0010 セットする usercd0010
	 */
	public void setUsercd0010(String usercd0010) {
		this.usercd0010 = usercd0010;
	}

	/**
	 * NF012DTO.javausercd0011を設定
	 * @return usercd0011
	 */
	public String getUsercd0011() {
		return usercd0011;
	}

	/**
	 * @param usercd0011 セットする usercd0011
	 */
	public void setUsercd0011(String usercd0011) {
		this.usercd0011 = usercd0011;
	}

	/**
	 * NF012DTO.javausercd0012を設定
	 * @return usercd0012
	 */
	public String getUsercd0012() {
		return usercd0012;
	}

	/**
	 * @param usercd0012 セットする usercd0012
	 */
	public void setUsercd0012(String usercd0012) {
		this.usercd0012 = usercd0012;
	}

	/**
	 * NF012DTO.javausercd0013を設定
	 * @return usercd0013
	 */
	public String getUsercd0013() {
		return usercd0013;
	}

	/**
	 * @param usercd0013 セットする usercd0013
	 */
	public void setUsercd0013(String usercd0013) {
		this.usercd0013 = usercd0013;
	}

	/**
	 * NF012DTO.javausercd0014を設定
	 * @return usercd0014
	 */
	public String getUsercd0014() {
		return usercd0014;
	}

	/**
	 * @param usercd0014 セットする usercd0014
	 */
	public void setUsercd0014(String usercd0014) {
		this.usercd0014 = usercd0014;
	}

	/**
	 * NF012DTO.javausercd0015を設定
	 * @return usercd0015
	 */
	public String getUsercd0015() {
		return usercd0015;
	}

	/**
	 * @param usercd0015 セットする usercd0015
	 */
	public void setUsercd0015(String usercd0015) {
		this.usercd0015 = usercd0015;
	}

	/**
	 * NF012DTO.javausercd0016を設定
	 * @return usercd0016
	 */
	public String getUsercd0016() {
		return usercd0016;
	}

	/**
	 * @param usercd0016 セットする usercd0016
	 */
	public void setUsercd0016(String usercd0016) {
		this.usercd0016 = usercd0016;
	}

	/**
	 * NF012DTO.javausercd0017を設定
	 * @return usercd0017
	 */
	public String getUsercd0017() {
		return usercd0017;
	}

	/**
	 * @param usercd0017 セットする usercd0017
	 */
	public void setUsercd0017(String usercd0017) {
		this.usercd0017 = usercd0017;
	}

	/**
	 * NF012DTO.javausercd0018を設定
	 * @return usercd0018
	 */
	public String getUsercd0018() {
		return usercd0018;
	}

	/**
	 * @param usercd0018 セットする usercd0018
	 */
	public void setUsercd0018(String usercd0018) {
		this.usercd0018 = usercd0018;
	}

	/**
	 * NF012DTO.javausercd0019を設定
	 * @return usercd0019
	 */
	public String getUsercd0019() {
		return usercd0019;
	}

	/**
	 * @param usercd0019 セットする usercd0019
	 */
	public void setUsercd0019(String usercd0019) {
		this.usercd0019 = usercd0019;
	}

	/**
	 * NF012DTO.javausercd0020を設定
	 * @return usercd0020
	 */
	public String getUsercd0020() {
		return usercd0020;
	}

	/**
	 * @param usercd0020 セットする usercd0020
	 */
	public void setUsercd0020(String usercd0020) {
		this.usercd0020 = usercd0020;
	}

	/**
	 * NF012DTO.javausercd0021を設定
	 * @return usercd0021
	 */
	public String getUsercd0021() {
		return usercd0021;
	}

	/**
	 * @param usercd0021 セットする usercd0021
	 */
	public void setUsercd0021(String usercd0021) {
		this.usercd0021 = usercd0021;
	}

	/**
	 * NF012DTO.javausercd0022を設定
	 * @return usercd0022
	 */
	public String getUsercd0022() {
		return usercd0022;
	}

	/**
	 * @param usercd0022 セットする usercd0022
	 */
	public void setUsercd0022(String usercd0022) {
		this.usercd0022 = usercd0022;
	}

	/**
	 * NF012DTO.javausercd0023を設定
	 * @return usercd0023
	 */
	public String getUsercd0023() {
		return usercd0023;
	}

	/**
	 * @param usercd0023 セットする usercd0023
	 */
	public void setUsercd0023(String usercd0023) {
		this.usercd0023 = usercd0023;
	}

	/**
	 * NF012DTO.javausercd0024を設定
	 * @return usercd0024
	 */
	public String getUsercd0024() {
		return usercd0024;
	}

	/**
	 * @param usercd0024 セットする usercd0024
	 */
	public void setUsercd0024(String usercd0024) {
		this.usercd0024 = usercd0024;
	}

	/**
	 * NF012DTO.javausercd0025を設定
	 * @return usercd0025
	 */
	public String getUsercd0025() {
		return usercd0025;
	}

	/**
	 * @param usercd0025 セットする usercd0025
	 */
	public void setUsercd0025(String usercd0025) {
		this.usercd0025 = usercd0025;
	}

	/**
	 * NF012DTO.javausercd0026を設定
	 * @return usercd0026
	 */
	public String getUsercd0026() {
		return usercd0026;
	}

	/**
	 * @param usercd0026 セットする usercd0026
	 */
	public void setUsercd0026(String usercd0026) {
		this.usercd0026 = usercd0026;
	}

	/**
	 * NF012DTO.javausercd0027を設定
	 * @return usercd0027
	 */
	public String getUsercd0027() {
		return usercd0027;
	}

	/**
	 * @param usercd0027 セットする usercd0027
	 */
	public void setUsercd0027(String usercd0027) {
		this.usercd0027 = usercd0027;
	}

	/**
	 * NF012DTO.javausercd0028を設定
	 * @return usercd0028
	 */
	public String getUsercd0028() {
		return usercd0028;
	}

	/**
	 * @param usercd0028 セットする usercd0028
	 */
	public void setUsercd0028(String usercd0028) {
		this.usercd0028 = usercd0028;
	}

	/**
	 * NF012DTO.javausercd0029を設定
	 * @return usercd0029
	 */
	public String getUsercd0029() {
		return usercd0029;
	}

	/**
	 * @param usercd0029 セットする usercd0029
	 */
	public void setUsercd0029(String usercd0029) {
		this.usercd0029 = usercd0029;
	}

	/**
	 * NF012DTO.javausercd0030を設定
	 * @return usercd0030
	 */
	public String getUsercd0030() {
		return usercd0030;
	}

	/**
	 * @param usercd0030 セットする usercd0030
	 */
	public void setUsercd0030(String usercd0030) {
		this.usercd0030 = usercd0030;
	}

	/**
	 * NF012DTO.javausercd0031を設定
	 * @return usercd0031
	 */
	public String getUsercd0031() {
		return usercd0031;
	}

	/**
	 * @param usercd0031 セットする usercd0031
	 */
	public void setUsercd0031(String usercd0031) {
		this.usercd0031 = usercd0031;
	}

	/**
	 * NF012DTO.javausercd0032を設定
	 * @return usercd0032
	 */
	public String getUsercd0032() {
		return usercd0032;
	}

	/**
	 * @param usercd0032 セットする usercd0032
	 */
	public void setUsercd0032(String usercd0032) {
		this.usercd0032 = usercd0032;
	}

	/**
	 * NF012DTO.javausercd0033を設定
	 * @return usercd0033
	 */
	public String getUsercd0033() {
		return usercd0033;
	}

	/**
	 * @param usercd0033 セットする usercd0033
	 */
	public void setUsercd0033(String usercd0033) {
		this.usercd0033 = usercd0033;
	}

	/**
	 * NF012DTO.javausercd0034を設定
	 * @return usercd0034
	 */
	public String getUsercd0034() {
		return usercd0034;
	}

	/**
	 * @param usercd0034 セットする usercd0034
	 */
	public void setUsercd0034(String usercd0034) {
		this.usercd0034 = usercd0034;
	}

	/**
	 * NF012DTO.javausercd0035を設定
	 * @return usercd0035
	 */
	public String getUsercd0035() {
		return usercd0035;
	}

	/**
	 * @param usercd0035 セットする usercd0035
	 */
	public void setUsercd0035(String usercd0035) {
		this.usercd0035 = usercd0035;
	}

	/**
	 * NF012DTO.javausercd0036を設定
	 * @return usercd0036
	 */
	public String getUsercd0036() {
		return usercd0036;
	}

	/**
	 * @param usercd0036 セットする usercd0036
	 */
	public void setUsercd0036(String usercd0036) {
		this.usercd0036 = usercd0036;
	}

	/**
	 * NF012DTO.javausercd0001Nmを設定
	 * @return usercd0001Nm
	 */
	public String getUsercd0001Nm() {
		return usercd0001Nm;
	}

	/**
	 * @param usercd0001Nm セットする usercd0001Nm
	 */
	public void setUsercd0001Nm(String usercd0001Nm) {
		this.usercd0001Nm = usercd0001Nm;
	}

	/**
	 * NF012DTO.javausercd0002Nmを設定
	 * @return usercd0002Nm
	 */
	public String getUsercd0002Nm() {
		return usercd0002Nm;
	}

	/**
	 * @param usercd0002Nm セットする usercd0002Nm
	 */
	public void setUsercd0002Nm(String usercd0002Nm) {
		this.usercd0002Nm = usercd0002Nm;
	}

	/**
	 * NF012DTO.javausercd0003Nmを設定
	 * @return usercd0003Nm
	 */
	public String getUsercd0003Nm() {
		return usercd0003Nm;
	}

	/**
	 * @param usercd0003Nm セットする usercd0003Nm
	 */
	public void setUsercd0003Nm(String usercd0003Nm) {
		this.usercd0003Nm = usercd0003Nm;
	}

	/**
	 * NF012DTO.javausercd0004Nmを設定
	 * @return usercd0004Nm
	 */
	public String getUsercd0004Nm() {
		return usercd0004Nm;
	}

	/**
	 * @param usercd0004Nm セットする usercd0004Nm
	 */
	public void setUsercd0004Nm(String usercd0004Nm) {
		this.usercd0004Nm = usercd0004Nm;
	}

	/**
	 * NF012DTO.javausercd0005Nmを設定
	 * @return usercd0005Nm
	 */
	public String getUsercd0005Nm() {
		return usercd0005Nm;
	}

	/**
	 * @param usercd0005Nm セットする usercd0005Nm
	 */
	public void setUsercd0005Nm(String usercd0005Nm) {
		this.usercd0005Nm = usercd0005Nm;
	}

	/**
	 * NF012DTO.javausercd0006Nmを設定
	 * @return usercd0006Nm
	 */
	public String getUsercd0006Nm() {
		return usercd0006Nm;
	}

	/**
	 * @param usercd0006Nm セットする usercd0006Nm
	 */
	public void setUsercd0006Nm(String usercd0006Nm) {
		this.usercd0006Nm = usercd0006Nm;
	}

	/**
	 * NF012DTO.javausercd0007Nmを設定
	 * @return usercd0007Nm
	 */
	public String getUsercd0007Nm() {
		return usercd0007Nm;
	}

	/**
	 * @param usercd0007Nm セットする usercd0007Nm
	 */
	public void setUsercd0007Nm(String usercd0007Nm) {
		this.usercd0007Nm = usercd0007Nm;
	}

	/**
	 * NF012DTO.javausercd0008Nmを設定
	 * @return usercd0008Nm
	 */
	public String getUsercd0008Nm() {
		return usercd0008Nm;
	}

	/**
	 * @param usercd0008Nm セットする usercd0008Nm
	 */
	public void setUsercd0008Nm(String usercd0008Nm) {
		this.usercd0008Nm = usercd0008Nm;
	}

	/**
	 * NF012DTO.javausercd0009Nmを設定
	 * @return usercd0009Nm
	 */
	public String getUsercd0009Nm() {
		return usercd0009Nm;
	}

	/**
	 * @param usercd0009Nm セットする usercd0009Nm
	 */
	public void setUsercd0009Nm(String usercd0009Nm) {
		this.usercd0009Nm = usercd0009Nm;
	}

	/**
	 * NF012DTO.javausercd0010Nmを設定
	 * @return usercd0010Nm
	 */
	public String getUsercd0010Nm() {
		return usercd0010Nm;
	}

	/**
	 * @param usercd0010Nm セットする usercd0010Nm
	 */
	public void setUsercd0010Nm(String usercd0010Nm) {
		this.usercd0010Nm = usercd0010Nm;
	}

	/**
	 * NF012DTO.javausercd0011Nmを設定
	 * @return usercd0011Nm
	 */
	public String getUsercd0011Nm() {
		return usercd0011Nm;
	}

	/**
	 * @param usercd0011Nm セットする usercd0011Nm
	 */
	public void setUsercd0011Nm(String usercd0011Nm) {
		this.usercd0011Nm = usercd0011Nm;
	}

	/**
	 * NF012DTO.javausercd0012Nmを設定
	 * @return usercd0012Nm
	 */
	public String getUsercd0012Nm() {
		return usercd0012Nm;
	}

	/**
	 * @param usercd0012Nm セットする usercd0012Nm
	 */
	public void setUsercd0012Nm(String usercd0012Nm) {
		this.usercd0012Nm = usercd0012Nm;
	}

	/**
	 * NF012DTO.javausercd0013Nmを設定
	 * @return usercd0013Nm
	 */
	public String getUsercd0013Nm() {
		return usercd0013Nm;
	}

	/**
	 * @param usercd0013Nm セットする usercd0013Nm
	 */
	public void setUsercd0013Nm(String usercd0013Nm) {
		this.usercd0013Nm = usercd0013Nm;
	}

	/**
	 * NF012DTO.javausercd0014Nmを設定
	 * @return usercd0014Nm
	 */
	public String getUsercd0014Nm() {
		return usercd0014Nm;
	}

	/**
	 * @param usercd0014Nm セットする usercd0014Nm
	 */
	public void setUsercd0014Nm(String usercd0014Nm) {
		this.usercd0014Nm = usercd0014Nm;
	}

	/**
	 * NF012DTO.javausercd0015Nmを設定
	 * @return usercd0015Nm
	 */
	public String getUsercd0015Nm() {
		return usercd0015Nm;
	}

	/**
	 * @param usercd0015Nm セットする usercd0015Nm
	 */
	public void setUsercd0015Nm(String usercd0015Nm) {
		this.usercd0015Nm = usercd0015Nm;
	}

	/**
	 * NF012DTO.javausercd0016Nmを設定
	 * @return usercd0016Nm
	 */
	public String getUsercd0016Nm() {
		return usercd0016Nm;
	}

	/**
	 * @param usercd0016Nm セットする usercd0016Nm
	 */
	public void setUsercd0016Nm(String usercd0016Nm) {
		this.usercd0016Nm = usercd0016Nm;
	}

	/**
	 * NF012DTO.javausercd0017Nmを設定
	 * @return usercd0017Nm
	 */
	public String getUsercd0017Nm() {
		return usercd0017Nm;
	}

	/**
	 * @param usercd0017Nm セットする usercd0017Nm
	 */
	public void setUsercd0017Nm(String usercd0017Nm) {
		this.usercd0017Nm = usercd0017Nm;
	}

	/**
	 * NF012DTO.javausercd0018Nmを設定
	 * @return usercd0018Nm
	 */
	public String getUsercd0018Nm() {
		return usercd0018Nm;
	}

	/**
	 * @param usercd0018Nm セットする usercd0018Nm
	 */
	public void setUsercd0018Nm(String usercd0018Nm) {
		this.usercd0018Nm = usercd0018Nm;
	}

	/**
	 * NF012DTO.javausercd0019Nmを設定
	 * @return usercd0019Nm
	 */
	public String getUsercd0019Nm() {
		return usercd0019Nm;
	}

	/**
	 * @param usercd0019Nm セットする usercd0019Nm
	 */
	public void setUsercd0019Nm(String usercd0019Nm) {
		this.usercd0019Nm = usercd0019Nm;
	}

	/**
	 * NF012DTO.javausercd0020Nmを設定
	 * @return usercd0020Nm
	 */
	public String getUsercd0020Nm() {
		return usercd0020Nm;
	}

	/**
	 * @param usercd0020Nm セットする usercd0020Nm
	 */
	public void setUsercd0020Nm(String usercd0020Nm) {
		this.usercd0020Nm = usercd0020Nm;
	}

	/**
	 * NF012DTO.javausercd0021Nmを設定
	 * @return usercd0021Nm
	 */
	public String getUsercd0021Nm() {
		return usercd0021Nm;
	}

	/**
	 * @param usercd0021Nm セットする usercd0021Nm
	 */
	public void setUsercd0021Nm(String usercd0021Nm) {
		this.usercd0021Nm = usercd0021Nm;
	}

	/**
	 * NF012DTO.javausercd0022Nmを設定
	 * @return usercd0022Nm
	 */
	public String getUsercd0022Nm() {
		return usercd0022Nm;
	}

	/**
	 * @param usercd0022Nm セットする usercd0022Nm
	 */
	public void setUsercd0022Nm(String usercd0022Nm) {
		this.usercd0022Nm = usercd0022Nm;
	}

	/**
	 * NF012DTO.javausercd0023Nmを設定
	 * @return usercd0023Nm
	 */
	public String getUsercd0023Nm() {
		return usercd0023Nm;
	}

	/**
	 * @param usercd0023Nm セットする usercd0023Nm
	 */
	public void setUsercd0023Nm(String usercd0023Nm) {
		this.usercd0023Nm = usercd0023Nm;
	}

	/**
	 * NF012DTO.javausercd0024Nmを設定
	 * @return usercd0024Nm
	 */
	public String getUsercd0024Nm() {
		return usercd0024Nm;
	}

	/**
	 * @param usercd0024Nm セットする usercd0024Nm
	 */
	public void setUsercd0024Nm(String usercd0024Nm) {
		this.usercd0024Nm = usercd0024Nm;
	}

	/**
	 * NF012DTO.javausercd0025Nmを設定
	 * @return usercd0025Nm
	 */
	public String getUsercd0025Nm() {
		return usercd0025Nm;
	}

	/**
	 * @param usercd0025Nm セットする usercd0025Nm
	 */
	public void setUsercd0025Nm(String usercd0025Nm) {
		this.usercd0025Nm = usercd0025Nm;
	}

	/**
	 * NF012DTO.javausercd0026Nmを設定
	 * @return usercd0026Nm
	 */
	public String getUsercd0026Nm() {
		return usercd0026Nm;
	}

	/**
	 * @param usercd0026Nm セットする usercd0026Nm
	 */
	public void setUsercd0026Nm(String usercd0026Nm) {
		this.usercd0026Nm = usercd0026Nm;
	}

	/**
	 * NF012DTO.javausercd0027Nmを設定
	 * @return usercd0027Nm
	 */
	public String getUsercd0027Nm() {
		return usercd0027Nm;
	}

	/**
	 * @param usercd0027Nm セットする usercd0027Nm
	 */
	public void setUsercd0027Nm(String usercd0027Nm) {
		this.usercd0027Nm = usercd0027Nm;
	}

	/**
	 * NF012DTO.javausercd0028Nmを設定
	 * @return usercd0028Nm
	 */
	public String getUsercd0028Nm() {
		return usercd0028Nm;
	}

	/**
	 * @param usercd0028Nm セットする usercd0028Nm
	 */
	public void setUsercd0028Nm(String usercd0028Nm) {
		this.usercd0028Nm = usercd0028Nm;
	}

	/**
	 * NF012DTO.javausercd0029Nmを設定
	 * @return usercd0029Nm
	 */
	public String getUsercd0029Nm() {
		return usercd0029Nm;
	}

	/**
	 * @param usercd0029Nm セットする usercd0029Nm
	 */
	public void setUsercd0029Nm(String usercd0029Nm) {
		this.usercd0029Nm = usercd0029Nm;
	}

	/**
	 * NF012DTO.javausercd0030Nmを設定
	 * @return usercd0030Nm
	 */
	public String getUsercd0030Nm() {
		return usercd0030Nm;
	}

	/**
	 * @param usercd0030Nm セットする usercd0030Nm
	 */
	public void setUsercd0030Nm(String usercd0030Nm) {
		this.usercd0030Nm = usercd0030Nm;
	}

	/**
	 * NF012DTO.javausercd0031Nmを設定
	 * @return usercd0031Nm
	 */
	public String getUsercd0031Nm() {
		return usercd0031Nm;
	}

	/**
	 * @param usercd0031Nm セットする usercd0031Nm
	 */
	public void setUsercd0031Nm(String usercd0031Nm) {
		this.usercd0031Nm = usercd0031Nm;
	}

	/**
	 * NF012DTO.javausercd0032Nmを設定
	 * @return usercd0032Nm
	 */
	public String getUsercd0032Nm() {
		return usercd0032Nm;
	}

	/**
	 * @param usercd0032Nm セットする usercd0032Nm
	 */
	public void setUsercd0032Nm(String usercd0032Nm) {
		this.usercd0032Nm = usercd0032Nm;
	}

	/**
	 * NF012DTO.javausercd0033Nmを設定
	 * @return usercd0033Nm
	 */
	public String getUsercd0033Nm() {
		return usercd0033Nm;
	}

	/**
	 * @param usercd0033Nm セットする usercd0033Nm
	 */
	public void setUsercd0033Nm(String usercd0033Nm) {
		this.usercd0033Nm = usercd0033Nm;
	}

	/**
	 * NF012DTO.javausercd0034Nmを設定
	 * @return usercd0034Nm
	 */
	public String getUsercd0034Nm() {
		return usercd0034Nm;
	}

	/**
	 * @param usercd0034Nm セットする usercd0034Nm
	 */
	public void setUsercd0034Nm(String usercd0034Nm) {
		this.usercd0034Nm = usercd0034Nm;
	}

	/**
	 * NF012DTO.javausercd0035Nmを設定
	 * @return usercd0035Nm
	 */
	public String getUsercd0035Nm() {
		return usercd0035Nm;
	}

	/**
	 * @param usercd0035Nm セットする usercd0035Nm
	 */
	public void setUsercd0035Nm(String usercd0035Nm) {
		this.usercd0035Nm = usercd0035Nm;
	}

	/**
	 * NF012DTO.javausercd0036Nmを設定
	 * @return usercd0036Nm
	 */
	public String getUsercd0036Nm() {
		return usercd0036Nm;
	}

	/**
	 * @param usercd0036Nm セットする usercd0036Nm
	 */
	public void setUsercd0036Nm(String usercd0036Nm) {
		this.usercd0036Nm = usercd0036Nm;
	}

	/**
	 * NF012DTO.javausercd0101を設定
	 * @return usercd0101
	 */
	public String getUsercd0101() {
		return usercd0101;
	}

	/**
	 * @param usercd0101 セットする usercd0101
	 */
	public void setUsercd0101(String usercd0101) {
		this.usercd0101 = usercd0101;
	}

	/**
	 * NF012DTO.javausercd0102を設定
	 * @return usercd0102
	 */
	public String getUsercd0102() {
		return usercd0102;
	}

	/**
	 * @param usercd0102 セットする usercd0102
	 */
	public void setUsercd0102(String usercd0102) {
		this.usercd0102 = usercd0102;
	}

	/**
	 * NF012DTO.javausercd0103を設定
	 * @return usercd0103
	 */
	public String getUsercd0103() {
		return usercd0103;
	}

	/**
	 * @param usercd0103 セットする usercd0103
	 */
	public void setUsercd0103(String usercd0103) {
		this.usercd0103 = usercd0103;
	}

	/**
	 * NF012DTO.javausercd0104を設定
	 * @return usercd0104
	 */
	public String getUsercd0104() {
		return usercd0104;
	}

	/**
	 * @param usercd0104 セットする usercd0104
	 */
	public void setUsercd0104(String usercd0104) {
		this.usercd0104 = usercd0104;
	}

	/**
	 * NF012DTO.javausercd0105を設定
	 * @return usercd0105
	 */
	public String getUsercd0105() {
		return usercd0105;
	}

	/**
	 * @param usercd0105 セットする usercd0105
	 */
	public void setUsercd0105(String usercd0105) {
		this.usercd0105 = usercd0105;
	}

	/**
	 * NF012DTO.javausercd0106を設定
	 * @return usercd0106
	 */
	public String getUsercd0106() {
		return usercd0106;
	}

	/**
	 * @param usercd0106 セットする usercd0106
	 */
	public void setUsercd0106(String usercd0106) {
		this.usercd0106 = usercd0106;
	}

	/**
	 * NF012DTO.javausercd0107を設定
	 * @return usercd0107
	 */
	public String getUsercd0107() {
		return usercd0107;
	}

	/**
	 * @param usercd0107 セットする usercd0107
	 */
	public void setUsercd0107(String usercd0107) {
		this.usercd0107 = usercd0107;
	}

	/**
	 * NF012DTO.javausercd0108を設定
	 * @return usercd0108
	 */
	public String getUsercd0108() {
		return usercd0108;
	}

	/**
	 * @param usercd0108 セットする usercd0108
	 */
	public void setUsercd0108(String usercd0108) {
		this.usercd0108 = usercd0108;
	}

	/**
	 * NF012DTO.javausercd0109を設定
	 * @return usercd0109
	 */
	public String getUsercd0109() {
		return usercd0109;
	}

	/**
	 * @param usercd0109 セットする usercd0109
	 */
	public void setUsercd0109(String usercd0109) {
		this.usercd0109 = usercd0109;
	}

	/**
	 * NF012DTO.javausercd0201を設定
	 * @return usercd0201
	 */
	public String getUsercd0201() {
		return usercd0201;
	}

	/**
	 * @param usercd0201 セットする usercd0201
	 */
	public void setUsercd0201(String usercd0201) {
		this.usercd0201 = usercd0201;
	}

	/**
	 * NF012DTO.javausercd0202を設定
	 * @return usercd0202
	 */
	public String getUsercd0202() {
		return usercd0202;
	}

	/**
	 * @param usercd0202 セットする usercd0202
	 */
	public void setUsercd0202(String usercd0202) {
		this.usercd0202 = usercd0202;
	}

	/**
	 * NF012DTO.javausercd0203を設定
	 * @return usercd0203
	 */
	public String getUsercd0203() {
		return usercd0203;
	}

	/**
	 * @param usercd0203 セットする usercd0203
	 */
	public void setUsercd0203(String usercd0203) {
		this.usercd0203 = usercd0203;
	}

	/**
	 * NF012DTO.javausercd0204を設定
	 * @return usercd0204
	 */
	public String getUsercd0204() {
		return usercd0204;
	}

	/**
	 * @param usercd0204 セットする usercd0204
	 */
	public void setUsercd0204(String usercd0204) {
		this.usercd0204 = usercd0204;
	}

	/**
	 * NF012DTO.javausercd0205を設定
	 * @return usercd0205
	 */
	public String getUsercd0205() {
		return usercd0205;
	}

	/**
	 * @param usercd0205 セットする usercd0205
	 */
	public void setUsercd0205(String usercd0205) {
		this.usercd0205 = usercd0205;
	}

	/**
	 * NF012DTO.javausercd0206を設定
	 * @return usercd0206
	 */
	public String getUsercd0206() {
		return usercd0206;
	}

	/**
	 * @param usercd0206 セットする usercd0206
	 */
	public void setUsercd0206(String usercd0206) {
		this.usercd0206 = usercd0206;
	}

	/**
	 * NF012DTO.javareward04を設定
	 * @return reward04
	 */
	public String getReward04() {
		return reward04;
	}

	/**
	 * @param reward04 セットする reward04
	 */
	public void setReward04(String reward04) {
		this.reward04 = reward04;
	}

	/**
	 * NF012DTO.javareward05を設定
	 * @return reward05
	 */
	public String getReward05() {
		return reward05;
	}

	/**
	 * @param reward05 セットする reward05
	 */
	public void setReward05(String reward05) {
		this.reward05 = reward05;
	}

	/**
	 * NF012DTO.javareward08を設定
	 * @return reward08
	 */
	public String getReward08() {
		return reward08;
	}

	/**
	 * @param reward08 セットする reward08
	 */
	public void setReward08(String reward08) {
		this.reward08 = reward08;
	}

	/**
	 * NF012DTO.javareward09を設定
	 * @return reward09
	 */
	public String getReward09() {
		return reward09;
	}

	/**
	 * @param reward09 セットする reward09
	 */
	public void setReward09(String reward09) {
		this.reward09 = reward09;
	}

	/**
	 * NF012DTO.javareward18を設定
	 * @return reward18
	 */
	public String getReward18() {
		return reward18;
	}

	/**
	 * @param reward18 セットする reward18
	 */
	public void setReward18(String reward18) {
		this.reward18 = reward18;
	}

	/**
	 * NF012DTO.javareward21を設定
	 * @return reward21
	 */
	public String getReward21() {
		return reward21;
	}

	/**
	 * @param reward21 セットする reward21
	 */
	public void setReward21(String reward21) {
		this.reward21 = reward21;
	}

	/**
	 * NF012DTO.javareward23を設定
	 * @return reward23
	 */
	public String getReward23() {
		return reward23;
	}

	/**
	 * @param reward23 セットする reward23
	 */
	public void setReward23(String reward23) {
		this.reward23 = reward23;
	}

	/**
	 * NF012DTO.javareward25を設定
	 * @return reward25
	 */
	public String getReward25() {
		return reward25;
	}

	/**
	 * @param reward25 セットする reward25
	 */
	public void setReward25(String reward25) {
		this.reward25 = reward25;
	}

	/**
	 * NF012DTO.javareward26を設定
	 * @return reward26
	 */
	public String getReward26() {
		return reward26;
	}

	/**
	 * @param reward26 セットする reward26
	 */
	public void setReward26(String reward26) {
		this.reward26 = reward26;
	}

	/**
	 * NF012DTO.javareward27を設定
	 * @return reward27
	 */
	public String getReward27() {
		return reward27;
	}

	/**
	 * @param reward27 セットする reward27
	 */
	public void setReward27(String reward27) {
		this.reward27 = reward27;
	}

	/**
	 * NF012DTO.javareward29を設定
	 * @return reward29
	 */
	public String getReward29() {
		return reward29;
	}

	/**
	 * @param reward29 セットする reward29
	 */
	public void setReward29(String reward29) {
		this.reward29 = reward29;
	}

	/**
	 * NF012DTO.javareward35を設定
	 * @return reward35
	 */
	public String getReward35() {
		return reward35;
	}

	/**
	 * @param reward35 セットする reward35
	 */
	public void setReward35(String reward35) {
		this.reward35 = reward35;
	}

	/**
	 * NF012DTO.javareward36を設定
	 * @return reward36
	 */
	public String getReward36() {
		return reward36;
	}

	/**
	 * @param reward36 セットする reward36
	 */
	public void setReward36(String reward36) {
		this.reward36 = reward36;
	}

	/**
	 * NF012DTO.javareward37を設定
	 * @return reward37
	 */
	public String getReward37() {
		return reward37;
	}

	/**
	 * @param reward37 セットする reward37
	 */
	public void setReward37(String reward37) {
		this.reward37 = reward37;
	}

	/**
	 * NF012DTO.javareward44を設定
	 * @return reward44
	 */
	public String getReward44() {
		return reward44;
	}

	/**
	 * @param reward44 セットする reward44
	 */
	public void setReward44(String reward44) {
		this.reward44 = reward44;
	}

	/**
	 * NF012DTO.javareward16を設定
	 * @return reward16
	 */
	public String getReward16() {
		return reward16;
	}

	/**
	 * @param reward16 セットする reward16
	 */
	public void setReward16(String reward16) {
		this.reward16 = reward16;
	}

	/**
	 * NF012DTO.javareward17を設定
	 * @return reward17
	 */
	public String getReward17() {
		return reward17;
	}

	/**
	 * @param reward17 セットする reward17
	 */
	public void setReward17(String reward17) {
		this.reward17 = reward17;
	}

	/**
	 * NF012DTO.javareward04Nmを設定
	 * @return reward04Nm
	 */
	public String getReward04Nm() {
		return reward04Nm;
	}

	/**
	 * @param reward04Nm セットする reward04Nm
	 */
	public void setReward04Nm(String reward04Nm) {
		this.reward04Nm = reward04Nm;
	}

	/**
	 * NF012DTO.javareward05Nmを設定
	 * @return reward05Nm
	 */
	public String getReward05Nm() {
		return reward05Nm;
	}

	/**
	 * @param reward05Nm セットする reward05Nm
	 */
	public void setReward05Nm(String reward05Nm) {
		this.reward05Nm = reward05Nm;
	}

	/**
	 * NF012DTO.javareward08Nmを設定
	 * @return reward08Nm
	 */
	public String getReward08Nm() {
		return reward08Nm;
	}

	/**
	 * @param reward08Nm セットする reward08Nm
	 */
	public void setReward08Nm(String reward08Nm) {
		this.reward08Nm = reward08Nm;
	}

	/**
	 * NF012DTO.javareward09Nmを設定
	 * @return reward09Nm
	 */
	public String getReward09Nm() {
		return reward09Nm;
	}

	/**
	 * @param reward09Nm セットする reward09Nm
	 */
	public void setReward09Nm(String reward09Nm) {
		this.reward09Nm = reward09Nm;
	}

	/**
	 * NF012DTO.javareward18Nmを設定
	 * @return reward18Nm
	 */
	public String getReward18Nm() {
		return reward18Nm;
	}

	/**
	 * @param reward18Nm セットする reward18Nm
	 */
	public void setReward18Nm(String reward18Nm) {
		this.reward18Nm = reward18Nm;
	}

	/**
	 * NF012DTO.javareward21Nmを設定
	 * @return reward21Nm
	 */
	public String getReward21Nm() {
		return reward21Nm;
	}

	/**
	 * @param reward21Nm セットする reward21Nm
	 */
	public void setReward21Nm(String reward21Nm) {
		this.reward21Nm = reward21Nm;
	}

	/**
	 * NF012DTO.javareward23Nmを設定
	 * @return reward23Nm
	 */
	public String getReward23Nm() {
		return reward23Nm;
	}

	/**
	 * @param reward23Nm セットする reward23Nm
	 */
	public void setReward23Nm(String reward23Nm) {
		this.reward23Nm = reward23Nm;
	}

	/**
	 * NF012DTO.javareward25Nmを設定
	 * @return reward25Nm
	 */
	public String getReward25Nm() {
		return reward25Nm;
	}

	/**
	 * @param reward25Nm セットする reward25Nm
	 */
	public void setReward25Nm(String reward25Nm) {
		this.reward25Nm = reward25Nm;
	}

	/**
	 * NF012DTO.javareward26Nmを設定
	 * @return reward26Nm
	 */
	public String getReward26Nm() {
		return reward26Nm;
	}

	/**
	 * @param reward26Nm セットする reward26Nm
	 */
	public void setReward26Nm(String reward26Nm) {
		this.reward26Nm = reward26Nm;
	}

	/**
	 * NF012DTO.javareward27Nmを設定
	 * @return reward27Nm
	 */
	public String getReward27Nm() {
		return reward27Nm;
	}

	/**
	 * @param reward27Nm セットする reward27Nm
	 */
	public void setReward27Nm(String reward27Nm) {
		this.reward27Nm = reward27Nm;
	}

	/**
	 * NF012DTO.javareward29Nmを設定
	 * @return reward29Nm
	 */
	public String getReward29Nm() {
		return reward29Nm;
	}

	/**
	 * @param reward29Nm セットする reward29Nm
	 */
	public void setReward29Nm(String reward29Nm) {
		this.reward29Nm = reward29Nm;
	}

	/**
	 * NF012DTO.javareward35Nmを設定
	 * @return reward35Nm
	 */
	public String getReward35Nm() {
		return reward35Nm;
	}

	/**
	 * @param reward35Nm セットする reward35Nm
	 */
	public void setReward35Nm(String reward35Nm) {
		this.reward35Nm = reward35Nm;
	}

	/**
	 * NF012DTO.javareward36Nmを設定
	 * @return reward36Nm
	 */
	public String getReward36Nm() {
		return reward36Nm;
	}

	/**
	 * @param reward36Nm セットする reward36Nm
	 */
	public void setReward36Nm(String reward36Nm) {
		this.reward36Nm = reward36Nm;
	}

	/**
	 * NF012DTO.javareward37Nmを設定
	 * @return reward37Nm
	 */
	public String getReward37Nm() {
		return reward37Nm;
	}

	/**
	 * @param reward37Nm セットする reward37Nm
	 */
	public void setReward37Nm(String reward37Nm) {
		this.reward37Nm = reward37Nm;
	}

	/**
	 * NF012DTO.javareward44Nmを設定
	 * @return reward44Nm
	 */
	public String getReward44Nm() {
		return reward44Nm;
	}

	/**
	 * @param reward44Nm セットする reward44Nm
	 */
	public void setReward44Nm(String reward44Nm) {
		this.reward44Nm = reward44Nm;
	}

	/**
	 * NF012DTO.javareward16Nmを設定
	 * @return reward16Nm
	 */
	public String getReward16Nm() {
		return reward16Nm;
	}

	/**
	 * @param reward16Nm セットする reward16Nm
	 */
	public void setReward16Nm(String reward16Nm) {
		this.reward16Nm = reward16Nm;
	}

	/**
	 * NF012DTO.javareward17Nmを設定
	 * @return reward17Nm
	 */
	public String getReward17Nm() {
		return reward17Nm;
	}

	/**
	 * @param reward17Nm セットする reward17Nm
	 */
	public void setReward17Nm(String reward17Nm) {
		this.reward17Nm = reward17Nm;
	}

	/**
	 * NF012DTO.javapreInsPcodeを設定
	 * @return preInsPcode
	 */
	public String getPreInsPcode() {
		return preInsPcode;
	}

	/**
	 * @param preInsPcode セットする preInsPcode
	 */
	public void setPreInsPcode(String preInsPcode) {
		this.preInsPcode = preInsPcode;
	}

	/**
	 * NF012DTO.javapreInsAddrを設定
	 * @return preInsAddr
	 */
	public String getPreInsAddr() {
		return preInsAddr;
	}

	/**
	 * @param preInsAddr セットする preInsAddr
	 */
	public void setPreInsAddr(String preInsAddr) {
		this.preInsAddr = preInsAddr;
	}

	/**
	 * NF012DTO.javapreInsAddrKanaを設定
	 * @return preInsAddrKana
	 */
	public String getPreInsAddrKana() {
		return preInsAddrKana;
	}

	/**
	 * @param preInsAddrKana セットする preInsAddrKana
	 */
	public void setPreInsAddrKana(String preInsAddrKana) {
		this.preInsAddrKana = preInsAddrKana;
	}

	/**
	 * NF012DTO.javapreAddrCodePrefを設定
	 * @return preAddrCodePref
	 */
	public String getPreAddrCodePref() {
		return preAddrCodePref;
	}

	/**
	 * @param preAddrCodePref セットする preAddrCodePref
	 */
	public void setPreAddrCodePref(String preAddrCodePref) {
		this.preAddrCodePref = preAddrCodePref;
	}

	/**
	 * NF012DTO.javapreAddrCodePrefNameを設定
	 * @return preAddrCodePrefName
	 */
	public String getPreAddrCodePrefName() {
		return preAddrCodePrefName;
	}

	/**
	 * @param preAddrCodePrefName セットする preAddrCodePrefName
	 */
	public void setPreAddrCodePrefName(String preAddrCodePrefName) {
		this.preAddrCodePrefName = preAddrCodePrefName;
	}

	/**
	 * NF012DTO.javapreAddrCodeCityを設定
	 * @return preAddrCodeCity
	 */
	public String getPreAddrCodeCity() {
		return preAddrCodeCity;
	}

	/**
	 * @param preAddrCodeCity セットする preAddrCodeCity
	 */
	public void setPreAddrCodeCity(String preAddrCodeCity) {
		this.preAddrCodeCity = preAddrCodeCity;
	}

	/**
	 * NF012DTO.javapreAddrCodeCityNameを設定
	 * @return preAddrCodeCityName
	 */
	public String getPreAddrCodeCityName() {
		return preAddrCodeCityName;
	}

	/**
	 * @param preAddrCodeCityName セットする preAddrCodeCityName
	 */
	public void setPreAddrCodeCityName(String preAddrCodeCityName) {
		this.preAddrCodeCityName = preAddrCodeCityName;
	}

	/**
	 * NF012DTO.javapreInsAddrDtを設定
	 * @return preInsAddrDt
	 */
	public String getPreInsAddrDt() {
		return preInsAddrDt;
	}

	/**
	 * @param preInsAddrDt セットする preInsAddrDt
	 */
	public void setPreInsAddrDt(String preInsAddrDt) {
		this.preInsAddrDt = preInsAddrDt;
	}

	/**
	 * NF012DTO.javapreTkCityCdを設定
	 * @return preTkCityCd
	 */
	public String getPreTkCityCd() {
		return preTkCityCd;
	}

	/**
	 * @param preTkCityCd セットする preTkCityCd
	 */
	public void setPreTkCityCd(String preTkCityCd) {
		this.preTkCityCd = preTkCityCd;
	}

	/**
	 * NF012DTO.javapreTkCityNameを設定
	 * @return preTkCityName
	 */
	public String getPreTkCityName() {
		return preTkCityName;
	}

	/**
	 * @param preTkCityName セットする preTkCityName
	 */
	public void setPreTkCityName(String preTkCityName) {
		this.preTkCityName = preTkCityName;
	}

	/**
	 * NF012DTO.javapreInsPhone1を設定
	 * @return preInsPhone1
	 */
	public String getPreInsPhone1() {
		return preInsPhone1;
	}

	/**
	 * @param preInsPhone1 セットする preInsPhone1
	 */
	public void setPreInsPhone1(String preInsPhone1) {
		this.preInsPhone1 = preInsPhone1;
	}

	/**
	 * NF012DTO.javapreInsPhone2を設定
	 * @return preInsPhone2
	 */
	public String getPreInsPhone2() {
		return preInsPhone2;
	}

	/**
	 * @param preInsPhone2 セットする preInsPhone2
	 */
	public void setPreInsPhone2(String preInsPhone2) {
		this.preInsPhone2 = preInsPhone2;
	}

	/**
	 * NF012DTO.javapreInsFax1を設定
	 * @return preInsFax1
	 */
	public String getPreInsFax1() {
		return preInsFax1;
	}

	/**
	 * @param preInsFax1 セットする preInsFax1
	 */
	public void setPreInsFax1(String preInsFax1) {
		this.preInsFax1 = preInsFax1;
	}

	/**
	 * NF012DTO.javapreInsFax2を設定
	 * @return preInsFax2
	 */
	public String getPreInsFax2() {
		return preInsFax2;
	}

	/**
	 * @param preInsFax2 セットする preInsFax2
	 */
	public void setPreInsFax2(String preInsFax2) {
		this.preInsFax2 = preInsFax2;
	}

	/**
	 * NF012DTO.javapreInsUrlを設定
	 * @return preInsUrl
	 */
	public String getPreInsUrl() {
		return preInsUrl;
	}

	/**
	 * @param preInsUrl セットする preInsUrl
	 */
	public void setPreInsUrl(String preInsUrl) {
		this.preInsUrl = preInsUrl;
	}

	/**
	 * NF012DTO.javapreInsUrlYmdを設定
	 * @return preInsUrlYmd
	 */
	public String getPreInsUrlYmd() {
		return preInsUrlYmd;
	}

	/**
	 * @param preInsUrlYmd セットする preInsUrlYmd
	 */
	public void setPreInsUrlYmd(String preInsUrlYmd) {
		this.preInsUrlYmd = preInsUrlYmd;
	}

	/**
	 * NF012DTO.javapreFree0001を設定
	 * @return preFree0001
	 */
	public String getPreFree0001() {
		return preFree0001;
	}

	/**
	 * @param preFree0001 セットする preFree0001
	 */
	public void setPreFree0001(String preFree0001) {
		this.preFree0001 = preFree0001;
	}

	/**
	 * NF012DTO.javapreFree0002を設定
	 * @return preFree0002
	 */
	public String getPreFree0002() {
		return preFree0002;
	}

	/**
	 * @param preFree0002 セットする preFree0002
	 */
	public void setPreFree0002(String preFree0002) {
		this.preFree0002 = preFree0002;
	}

	/**
	 * NF012DTO.javapreFree0003を設定
	 * @return preFree0003
	 */
	public String getPreFree0003() {
		return preFree0003;
	}

	/**
	 * @param preFree0003 セットする preFree0003
	 */
	public void setPreFree0003(String preFree0003) {
		this.preFree0003 = preFree0003;
	}

	/**
	 * NF012DTO.javapreFree0015を設定
	 * @return preFree0015
	 */
	public String getPreFree0015() {
		return preFree0015;
	}

	/**
	 * @param preFree0015 セットする preFree0015
	 */
	public void setPreFree0015(String preFree0015) {
		this.preFree0015 = preFree0015;
	}

	/**
	 * NF012DTO.javapreFree0008を設定
	 * @return preFree0008
	 */
	public String getPreFree0008() {
		return preFree0008;
	}

	/**
	 * @param preFree0008 セットする preFree0008
	 */
	public void setPreFree0008(String preFree0008) {
		this.preFree0008 = preFree0008;
	}

	/**
	 * NF012DTO.javapreFree0009を設定
	 * @return preFree0009
	 */
	public String getPreFree0009() {
		return preFree0009;
	}

	/**
	 * @param preFree0009 セットする preFree0009
	 */
	public void setPreFree0009(String preFree0009) {
		this.preFree0009 = preFree0009;
	}

	/**
	 * NF012DTO.javapreFree0004を設定
	 * @return preFree0004
	 */
	public String getPreFree0004() {
		return preFree0004;
	}

	/**
	 * @param preFree0004 セットする preFree0004
	 */
	public void setPreFree0004(String preFree0004) {
		this.preFree0004 = preFree0004;
	}

	/**
	 * NF012DTO.javapreFree0005を設定
	 * @return preFree0005
	 */
	public String getPreFree0005() {
		return preFree0005;
	}

	/**
	 * @param preFree0005 セットする preFree0005
	 */
	public void setPreFree0005(String preFree0005) {
		this.preFree0005 = preFree0005;
	}

	/**
	 * NF012DTO.javapreFree0006を設定
	 * @return preFree0006
	 */
	public String getPreFree0006() {
		return preFree0006;
	}

	/**
	 * @param preFree0006 セットする preFree0006
	 */
	public void setPreFree0006(String preFree0006) {
		this.preFree0006 = preFree0006;
	}

	/**
	 * NF012DTO.javapreFree0007を設定
	 * @return preFree0007
	 */
	public String getPreFree0007() {
		return preFree0007;
	}

	/**
	 * @param preFree0007 セットする preFree0007
	 */
	public void setPreFree0007(String preFree0007) {
		this.preFree0007 = preFree0007;
	}

	/**
	 * NF012DTO.javapreFree0010を設定
	 * @return preFree0010
	 */
	public String getPreFree0010() {
		return preFree0010;
	}

	/**
	 * @param preFree0010 セットする preFree0010
	 */
	public void setPreFree0010(String preFree0010) {
		this.preFree0010 = preFree0010;
	}

	/**
	 * NF012DTO.javapreFree0011を設定
	 * @return preFree0011
	 */
	public String getPreFree0011() {
		return preFree0011;
	}

	/**
	 * @param preFree0011 セットする preFree0011
	 */
	public void setPreFree0011(String preFree0011) {
		this.preFree0011 = preFree0011;
	}

	/**
	 * NF012DTO.javapreFree0013を設定
	 * @return preFree0013
	 */
	public String getPreFree0013() {
		return preFree0013;
	}

	/**
	 * @param preFree0013 セットする preFree0013
	 */
	public void setPreFree0013(String preFree0013) {
		this.preFree0013 = preFree0013;
	}

	/**
	 * NF012DTO.javapreFree0014を設定
	 * @return preFree0014
	 */
	public String getPreFree0014() {
		return preFree0014;
	}

	/**
	 * @param preFree0014 セットする preFree0014
	 */
	public void setPreFree0014(String preFree0014) {
		this.preFree0014 = preFree0014;
	}

	/**
	 * NF012DTO.javapreFree0012を設定
	 * @return preFree0012
	 */
	public String getPreFree0012() {
		return preFree0012;
	}

	/**
	 * @param preFree0012 セットする preFree0012
	 */
	public void setPreFree0012(String preFree0012) {
		this.preFree0012 = preFree0012;
	}

	/**
	 * NF012DTO.javapreWelfare02を設定
	 * @return preWelfare02
	 */
	public String getPreWelfare02() {
		return preWelfare02;
	}

	/**
	 * @param preWelfare02 セットする preWelfare02
	 */
	public void setPreWelfare02(String preWelfare02) {
		this.preWelfare02 = preWelfare02;
	}

	/**
	 * NF012DTO.javapreWelfare02Nmを設定
	 * @return preWelfare02Nm
	 */
	public String getPreWelfare02Nm() {
		return preWelfare02Nm;
	}

	/**
	 * @param preWelfare02Nm セットする preWelfare02Nm
	 */
	public void setPreWelfare02Nm(String preWelfare02Nm) {
		this.preWelfare02Nm = preWelfare02Nm;
	}

	/**
	 * NF012DTO.javapreWelfare08Nmを設定
	 * @return preWelfare08Nm
	 */
	public String getPreWelfare08Nm() {
		return preWelfare08Nm;
	}

	/**
	 * @param preWelfare08Nm セットする preWelfare08Nm
	 */
	public void setPreWelfare08Nm(String preWelfare08Nm) {
		this.preWelfare08Nm = preWelfare08Nm;
	}

	/**
	 * NF012DTO.javapreWelfare08を設定
	 * @return preWelfare08
	 */
	public String getPreWelfare08() {
		return preWelfare08;
	}

	/**
	 * @param preWelfare08 セットする preWelfare08
	 */
	public void setPreWelfare08(String preWelfare08) {
		this.preWelfare08 = preWelfare08;
	}

	/**
	 * NF012DTO.javapreResult01を設定
	 * @return preResult01
	 */
	public String getPreResult01() {
		return preResult01;
	}

	/**
	 * @param preResult01 セットする preResult01
	 */
	public void setPreResult01(String preResult01) {
		this.preResult01 = preResult01;
	}

	/**
	 * NF012DTO.javapreResult02を設定
	 * @return preResult02
	 */
	public String getPreResult02() {
		return preResult02;
	}

	/**
	 * @param preResult02 セットする preResult02
	 */
	public void setPreResult02(String preResult02) {
		this.preResult02 = preResult02;
	}

	/**
	 * NF012DTO.javapreResult03を設定
	 * @return preResult03
	 */
	public String getPreResult03() {
		return preResult03;
	}

	/**
	 * @param preResult03 セットする preResult03
	 */
	public void setPreResult03(String preResult03) {
		this.preResult03 = preResult03;
	}

	/**
	 * NF012DTO.javapreResult04を設定
	 * @return preResult04
	 */
	public String getPreResult04() {
		return preResult04;
	}

	/**
	 * @param preResult04 セットする preResult04
	 */
	public void setPreResult04(String preResult04) {
		this.preResult04 = preResult04;
	}

	/**
	 * NF012DTO.javapreResult05を設定
	 * @return preResult05
	 */
	public String getPreResult05() {
		return preResult05;
	}

	/**
	 * @param preResult05 セットする preResult05
	 */
	public void setPreResult05(String preResult05) {
		this.preResult05 = preResult05;
	}

	/**
	 * NF012DTO.javapreResult06を設定
	 * @return preResult06
	 */
	public String getPreResult06() {
		return preResult06;
	}

	/**
	 * @param preResult06 セットする preResult06
	 */
	public void setPreResult06(String preResult06) {
		this.preResult06 = preResult06;
	}

	/**
	 * NF012DTO.javapreResult07を設定
	 * @return preResult07
	 */
	public String getPreResult07() {
		return preResult07;
	}

	/**
	 * @param preResult07 セットする preResult07
	 */
	public void setPreResult07(String preResult07) {
		this.preResult07 = preResult07;
	}

	/**
	 * NF012DTO.javapreResult08を設定
	 * @return preResult08
	 */
	public String getPreResult08() {
		return preResult08;
	}

	/**
	 * @param preResult08 セットする preResult08
	 */
	public void setPreResult08(String preResult08) {
		this.preResult08 = preResult08;
	}

	/**
	 * NF012DTO.javapreResult09を設定
	 * @return preResult09
	 */
	public String getPreResult09() {
		return preResult09;
	}

	/**
	 * @param preResult09 セットする preResult09
	 */
	public void setPreResult09(String preResult09) {
		this.preResult09 = preResult09;
	}

	/**
	 * NF012DTO.javapreResult10を設定
	 * @return preResult10
	 */
	public String getPreResult10() {
		return preResult10;
	}

	/**
	 * @param preResult10 セットする preResult10
	 */
	public void setPreResult10(String preResult10) {
		this.preResult10 = preResult10;
	}

	/**
	 * NF012DTO.javapreResult11を設定
	 * @return preResult11
	 */
	public String getPreResult11() {
		return preResult11;
	}

	/**
	 * @param preResult11 セットする preResult11
	 */
	public void setPreResult11(String preResult11) {
		this.preResult11 = preResult11;
	}

	/**
	 * NF012DTO.javapreResult12を設定
	 * @return preResult12
	 */
	public String getPreResult12() {
		return preResult12;
	}

	/**
	 * @param preResult12 セットする preResult12
	 */
	public void setPreResult12(String preResult12) {
		this.preResult12 = preResult12;
	}

	/**
	 * NF012DTO.javapreResult13を設定
	 * @return preResult13
	 */
	public String getPreResult13() {
		return preResult13;
	}

	/**
	 * @param preResult13 セットする preResult13
	 */
	public void setPreResult13(String preResult13) {
		this.preResult13 = preResult13;
	}

	/**
	 * NF012DTO.javapreResult14を設定
	 * @return preResult14
	 */
	public String getPreResult14() {
		return preResult14;
	}

	/**
	 * @param preResult14 セットする preResult14
	 */
	public void setPreResult14(String preResult14) {
		this.preResult14 = preResult14;
	}

	/**
	 * NF012DTO.javapreResult15を設定
	 * @return preResult15
	 */
	public String getPreResult15() {
		return preResult15;
	}

	/**
	 * @param preResult15 セットする preResult15
	 */
	public void setPreResult15(String preResult15) {
		this.preResult15 = preResult15;
	}

	/**
	 * NF012DTO.javapreResult16を設定
	 * @return preResult16
	 */
	public String getPreResult16() {
		return preResult16;
	}

	/**
	 * @param preResult16 セットする preResult16
	 */
	public void setPreResult16(String preResult16) {
		this.preResult16 = preResult16;
	}

	/**
	 * NF012DTO.javapreResult17を設定
	 * @return preResult17
	 */
	public String getPreResult17() {
		return preResult17;
	}

	/**
	 * @param preResult17 セットする preResult17
	 */
	public void setPreResult17(String preResult17) {
		this.preResult17 = preResult17;
	}

	/**
	 * NF012DTO.javapreResult18を設定
	 * @return preResult18
	 */
	public String getPreResult18() {
		return preResult18;
	}

	/**
	 * @param preResult18 セットする preResult18
	 */
	public void setPreResult18(String preResult18) {
		this.preResult18 = preResult18;
	}

	/**
	 * NF012DTO.javapreResult19を設定
	 * @return preResult19
	 */
	public String getPreResult19() {
		return preResult19;
	}

	/**
	 * @param preResult19 セットする preResult19
	 */
	public void setPreResult19(String preResult19) {
		this.preResult19 = preResult19;
	}

	/**
	 * NF012DTO.javapreResult20を設定
	 * @return preResult20
	 */
	public String getPreResult20() {
		return preResult20;
	}

	/**
	 * @param preResult20 セットする preResult20
	 */
	public void setPreResult20(String preResult20) {
		this.preResult20 = preResult20;
	}

	/**
	 * NF012DTO.javapreResult21を設定
	 * @return preResult21
	 */
	public String getPreResult21() {
		return preResult21;
	}

	/**
	 * @param preResult21 セットする preResult21
	 */
	public void setPreResult21(String preResult21) {
		this.preResult21 = preResult21;
	}

	/**
	 * NF012DTO.javapreResult22を設定
	 * @return preResult22
	 */
	public String getPreResult22() {
		return preResult22;
	}

	/**
	 * @param preResult22 セットする preResult22
	 */
	public void setPreResult22(String preResult22) {
		this.preResult22 = preResult22;
	}

	/**
	 * NF012DTO.javapreResult23を設定
	 * @return preResult23
	 */
	public String getPreResult23() {
		return preResult23;
	}

	/**
	 * @param preResult23 セットする preResult23
	 */
	public void setPreResult23(String preResult23) {
		this.preResult23 = preResult23;
	}

	/**
	 * NF012DTO.javapreResult24を設定
	 * @return preResult24
	 */
	public String getPreResult24() {
		return preResult24;
	}

	/**
	 * @param preResult24 セットする preResult24
	 */
	public void setPreResult24(String preResult24) {
		this.preResult24 = preResult24;
	}

	/**
	 * NF012DTO.javapreResult25を設定
	 * @return preResult25
	 */
	public String getPreResult25() {
		return preResult25;
	}

	/**
	 * @param preResult25 セットする preResult25
	 */
	public void setPreResult25(String preResult25) {
		this.preResult25 = preResult25;
	}

	/**
	 * NF012DTO.javapreResult26を設定
	 * @return preResult26
	 */
	public String getPreResult26() {
		return preResult26;
	}

	/**
	 * @param preResult26 セットする preResult26
	 */
	public void setPreResult26(String preResult26) {
		this.preResult26 = preResult26;
	}

	/**
	 * NF012DTO.javapreResult27を設定
	 * @return preResult27
	 */
	public String getPreResult27() {
		return preResult27;
	}

	/**
	 * @param preResult27 セットする preResult27
	 */
	public void setPreResult27(String preResult27) {
		this.preResult27 = preResult27;
	}

	/**
	 * NF012DTO.javapreResult28を設定
	 * @return preResult28
	 */
	public String getPreResult28() {
		return preResult28;
	}

	/**
	 * @param preResult28 セットする preResult28
	 */
	public void setPreResult28(String preResult28) {
		this.preResult28 = preResult28;
	}

	/**
	 * NF012DTO.javapreResult29を設定
	 * @return preResult29
	 */
	public String getPreResult29() {
		return preResult29;
	}

	/**
	 * @param preResult29 セットする preResult29
	 */
	public void setPreResult29(String preResult29) {
		this.preResult29 = preResult29;
	}

	/**
	 * NF012DTO.javapreResult30を設定
	 * @return preResult30
	 */
	public String getPreResult30() {
		return preResult30;
	}

	/**
	 * @param preResult30 セットする preResult30
	 */
	public void setPreResult30(String preResult30) {
		this.preResult30 = preResult30;
	}

	/**
	 * NF012DTO.javapreResult31を設定
	 * @return preResult31
	 */
	public String getPreResult31() {
		return preResult31;
	}

	/**
	 * @param preResult31 セットする preResult31
	 */
	public void setPreResult31(String preResult31) {
		this.preResult31 = preResult31;
	}

	/**
	 * NF012DTO.javapreResult32を設定
	 * @return preResult32
	 */
	public String getPreResult32() {
		return preResult32;
	}

	/**
	 * @param preResult32 セットする preResult32
	 */
	public void setPreResult32(String preResult32) {
		this.preResult32 = preResult32;
	}

	/**
	 * NF012DTO.javapreResult33を設定
	 * @return preResult33
	 */
	public String getPreResult33() {
		return preResult33;
	}

	/**
	 * @param preResult33 セットする preResult33
	 */
	public void setPreResult33(String preResult33) {
		this.preResult33 = preResult33;
	}

	/**
	 * NF012DTO.javapreResult34を設定
	 * @return preResult34
	 */
	public String getPreResult34() {
		return preResult34;
	}

	/**
	 * @param preResult34 セットする preResult34
	 */
	public void setPreResult34(String preResult34) {
		this.preResult34 = preResult34;
	}

	/**
	 * NF012DTO.javapreResult35を設定
	 * @return preResult35
	 */
	public String getPreResult35() {
		return preResult35;
	}

	/**
	 * @param preResult35 セットする preResult35
	 */
	public void setPreResult35(String preResult35) {
		this.preResult35 = preResult35;
	}

	/**
	 * NF012DTO.javapreResult36を設定
	 * @return preResult36
	 */
	public String getPreResult36() {
		return preResult36;
	}

	/**
	 * @param preResult36 セットする preResult36
	 */
	public void setPreResult36(String preResult36) {
		this.preResult36 = preResult36;
	}

	/**
	 * NF012DTO.javapreResult01Nmを設定
	 * @return preResult01Nm
	 */
	public String getPreResult01Nm() {
		return preResult01Nm;
	}

	/**
	 * @param preResult01Nm セットする preResult01Nm
	 */
	public void setPreResult01Nm(String preResult01Nm) {
		this.preResult01Nm = preResult01Nm;
	}

	/**
	 * NF012DTO.javapreResult02Nmを設定
	 * @return preResult02Nm
	 */
	public String getPreResult02Nm() {
		return preResult02Nm;
	}

	/**
	 * @param preResult02Nm セットする preResult02Nm
	 */
	public void setPreResult02Nm(String preResult02Nm) {
		this.preResult02Nm = preResult02Nm;
	}

	/**
	 * NF012DTO.javapreResult03Nmを設定
	 * @return preResult03Nm
	 */
	public String getPreResult03Nm() {
		return preResult03Nm;
	}

	/**
	 * @param preResult03Nm セットする preResult03Nm
	 */
	public void setPreResult03Nm(String preResult03Nm) {
		this.preResult03Nm = preResult03Nm;
	}

	/**
	 * NF012DTO.javapreResult04Nmを設定
	 * @return preResult04Nm
	 */
	public String getPreResult04Nm() {
		return preResult04Nm;
	}

	/**
	 * @param preResult04Nm セットする preResult04Nm
	 */
	public void setPreResult04Nm(String preResult04Nm) {
		this.preResult04Nm = preResult04Nm;
	}

	/**
	 * NF012DTO.javapreResult05Nmを設定
	 * @return preResult05Nm
	 */
	public String getPreResult05Nm() {
		return preResult05Nm;
	}

	/**
	 * @param preResult05Nm セットする preResult05Nm
	 */
	public void setPreResult05Nm(String preResult05Nm) {
		this.preResult05Nm = preResult05Nm;
	}

	/**
	 * NF012DTO.javapreResult06Nmを設定
	 * @return preResult06Nm
	 */
	public String getPreResult06Nm() {
		return preResult06Nm;
	}

	/**
	 * @param preResult06Nm セットする preResult06Nm
	 */
	public void setPreResult06Nm(String preResult06Nm) {
		this.preResult06Nm = preResult06Nm;
	}

	/**
	 * NF012DTO.javapreResult07Nmを設定
	 * @return preResult07Nm
	 */
	public String getPreResult07Nm() {
		return preResult07Nm;
	}

	/**
	 * @param preResult07Nm セットする preResult07Nm
	 */
	public void setPreResult07Nm(String preResult07Nm) {
		this.preResult07Nm = preResult07Nm;
	}

	/**
	 * NF012DTO.javapreResult08Nmを設定
	 * @return preResult08Nm
	 */
	public String getPreResult08Nm() {
		return preResult08Nm;
	}

	/**
	 * @param preResult08Nm セットする preResult08Nm
	 */
	public void setPreResult08Nm(String preResult08Nm) {
		this.preResult08Nm = preResult08Nm;
	}

	/**
	 * NF012DTO.javapreResult09Nmを設定
	 * @return preResult09Nm
	 */
	public String getPreResult09Nm() {
		return preResult09Nm;
	}

	/**
	 * @param preResult09Nm セットする preResult09Nm
	 */
	public void setPreResult09Nm(String preResult09Nm) {
		this.preResult09Nm = preResult09Nm;
	}

	/**
	 * NF012DTO.javapreResult10Nmを設定
	 * @return preResult10Nm
	 */
	public String getPreResult10Nm() {
		return preResult10Nm;
	}

	/**
	 * @param preResult10Nm セットする preResult10Nm
	 */
	public void setPreResult10Nm(String preResult10Nm) {
		this.preResult10Nm = preResult10Nm;
	}

	/**
	 * NF012DTO.javapreResult11Nmを設定
	 * @return preResult11Nm
	 */
	public String getPreResult11Nm() {
		return preResult11Nm;
	}

	/**
	 * @param preResult11Nm セットする preResult11Nm
	 */
	public void setPreResult11Nm(String preResult11Nm) {
		this.preResult11Nm = preResult11Nm;
	}

	/**
	 * NF012DTO.javapreResult12Nmを設定
	 * @return preResult12Nm
	 */
	public String getPreResult12Nm() {
		return preResult12Nm;
	}

	/**
	 * @param preResult12Nm セットする preResult12Nm
	 */
	public void setPreResult12Nm(String preResult12Nm) {
		this.preResult12Nm = preResult12Nm;
	}

	/**
	 * NF012DTO.javapreResult13Nmを設定
	 * @return preResult13Nm
	 */
	public String getPreResult13Nm() {
		return preResult13Nm;
	}

	/**
	 * @param preResult13Nm セットする preResult13Nm
	 */
	public void setPreResult13Nm(String preResult13Nm) {
		this.preResult13Nm = preResult13Nm;
	}

	/**
	 * NF012DTO.javapreResult14Nmを設定
	 * @return preResult14Nm
	 */
	public String getPreResult14Nm() {
		return preResult14Nm;
	}

	/**
	 * @param preResult14Nm セットする preResult14Nm
	 */
	public void setPreResult14Nm(String preResult14Nm) {
		this.preResult14Nm = preResult14Nm;
	}

	/**
	 * NF012DTO.javapreResult15Nmを設定
	 * @return preResult15Nm
	 */
	public String getPreResult15Nm() {
		return preResult15Nm;
	}

	/**
	 * @param preResult15Nm セットする preResult15Nm
	 */
	public void setPreResult15Nm(String preResult15Nm) {
		this.preResult15Nm = preResult15Nm;
	}

	/**
	 * NF012DTO.javapreResult16Nmを設定
	 * @return preResult16Nm
	 */
	public String getPreResult16Nm() {
		return preResult16Nm;
	}

	/**
	 * @param preResult16Nm セットする preResult16Nm
	 */
	public void setPreResult16Nm(String preResult16Nm) {
		this.preResult16Nm = preResult16Nm;
	}

	/**
	 * NF012DTO.javapreResult17Nmを設定
	 * @return preResult17Nm
	 */
	public String getPreResult17Nm() {
		return preResult17Nm;
	}

	/**
	 * @param preResult17Nm セットする preResult17Nm
	 */
	public void setPreResult17Nm(String preResult17Nm) {
		this.preResult17Nm = preResult17Nm;
	}

	/**
	 * NF012DTO.javapreResult18Nmを設定
	 * @return preResult18Nm
	 */
	public String getPreResult18Nm() {
		return preResult18Nm;
	}

	/**
	 * @param preResult18Nm セットする preResult18Nm
	 */
	public void setPreResult18Nm(String preResult18Nm) {
		this.preResult18Nm = preResult18Nm;
	}

	/**
	 * NF012DTO.javapreResult19Nmを設定
	 * @return preResult19Nm
	 */
	public String getPreResult19Nm() {
		return preResult19Nm;
	}

	/**
	 * @param preResult19Nm セットする preResult19Nm
	 */
	public void setPreResult19Nm(String preResult19Nm) {
		this.preResult19Nm = preResult19Nm;
	}

	/**
	 * NF012DTO.javapreResult20Nmを設定
	 * @return preResult20Nm
	 */
	public String getPreResult20Nm() {
		return preResult20Nm;
	}

	/**
	 * @param preResult20Nm セットする preResult20Nm
	 */
	public void setPreResult20Nm(String preResult20Nm) {
		this.preResult20Nm = preResult20Nm;
	}

	/**
	 * NF012DTO.javapreResult21Nmを設定
	 * @return preResult21Nm
	 */
	public String getPreResult21Nm() {
		return preResult21Nm;
	}

	/**
	 * @param preResult21Nm セットする preResult21Nm
	 */
	public void setPreResult21Nm(String preResult21Nm) {
		this.preResult21Nm = preResult21Nm;
	}

	/**
	 * NF012DTO.javapreResult22Nmを設定
	 * @return preResult22Nm
	 */
	public String getPreResult22Nm() {
		return preResult22Nm;
	}

	/**
	 * @param preResult22Nm セットする preResult22Nm
	 */
	public void setPreResult22Nm(String preResult22Nm) {
		this.preResult22Nm = preResult22Nm;
	}

	/**
	 * NF012DTO.javapreResult23Nmを設定
	 * @return preResult23Nm
	 */
	public String getPreResult23Nm() {
		return preResult23Nm;
	}

	/**
	 * @param preResult23Nm セットする preResult23Nm
	 */
	public void setPreResult23Nm(String preResult23Nm) {
		this.preResult23Nm = preResult23Nm;
	}

	/**
	 * NF012DTO.javapreResult24Nmを設定
	 * @return preResult24Nm
	 */
	public String getPreResult24Nm() {
		return preResult24Nm;
	}

	/**
	 * @param preResult24Nm セットする preResult24Nm
	 */
	public void setPreResult24Nm(String preResult24Nm) {
		this.preResult24Nm = preResult24Nm;
	}

	/**
	 * NF012DTO.javapreResult25Nmを設定
	 * @return preResult25Nm
	 */
	public String getPreResult25Nm() {
		return preResult25Nm;
	}

	/**
	 * @param preResult25Nm セットする preResult25Nm
	 */
	public void setPreResult25Nm(String preResult25Nm) {
		this.preResult25Nm = preResult25Nm;
	}

	/**
	 * NF012DTO.javapreResult26Nmを設定
	 * @return preResult26Nm
	 */
	public String getPreResult26Nm() {
		return preResult26Nm;
	}

	/**
	 * @param preResult26Nm セットする preResult26Nm
	 */
	public void setPreResult26Nm(String preResult26Nm) {
		this.preResult26Nm = preResult26Nm;
	}

	/**
	 * NF012DTO.javapreResult27Nmを設定
	 * @return preResult27Nm
	 */
	public String getPreResult27Nm() {
		return preResult27Nm;
	}

	/**
	 * @param preResult27Nm セットする preResult27Nm
	 */
	public void setPreResult27Nm(String preResult27Nm) {
		this.preResult27Nm = preResult27Nm;
	}

	/**
	 * NF012DTO.javapreResult28Nmを設定
	 * @return preResult28Nm
	 */
	public String getPreResult28Nm() {
		return preResult28Nm;
	}

	/**
	 * @param preResult28Nm セットする preResult28Nm
	 */
	public void setPreResult28Nm(String preResult28Nm) {
		this.preResult28Nm = preResult28Nm;
	}

	/**
	 * NF012DTO.javapreResult29Nmを設定
	 * @return preResult29Nm
	 */
	public String getPreResult29Nm() {
		return preResult29Nm;
	}

	/**
	 * @param preResult29Nm セットする preResult29Nm
	 */
	public void setPreResult29Nm(String preResult29Nm) {
		this.preResult29Nm = preResult29Nm;
	}

	/**
	 * NF012DTO.javapreResult30Nmを設定
	 * @return preResult30Nm
	 */
	public String getPreResult30Nm() {
		return preResult30Nm;
	}

	/**
	 * @param preResult30Nm セットする preResult30Nm
	 */
	public void setPreResult30Nm(String preResult30Nm) {
		this.preResult30Nm = preResult30Nm;
	}

	/**
	 * NF012DTO.javapreResult31Nmを設定
	 * @return preResult31Nm
	 */
	public String getPreResult31Nm() {
		return preResult31Nm;
	}

	/**
	 * @param preResult31Nm セットする preResult31Nm
	 */
	public void setPreResult31Nm(String preResult31Nm) {
		this.preResult31Nm = preResult31Nm;
	}

	/**
	 * NF012DTO.javapreResult32Nmを設定
	 * @return preResult32Nm
	 */
	public String getPreResult32Nm() {
		return preResult32Nm;
	}

	/**
	 * @param preResult32Nm セットする preResult32Nm
	 */
	public void setPreResult32Nm(String preResult32Nm) {
		this.preResult32Nm = preResult32Nm;
	}

	/**
	 * NF012DTO.javapreResult33Nmを設定
	 * @return preResult33Nm
	 */
	public String getPreResult33Nm() {
		return preResult33Nm;
	}

	/**
	 * @param preResult33Nm セットする preResult33Nm
	 */
	public void setPreResult33Nm(String preResult33Nm) {
		this.preResult33Nm = preResult33Nm;
	}

	/**
	 * NF012DTO.javapreResult34Nmを設定
	 * @return preResult34Nm
	 */
	public String getPreResult34Nm() {
		return preResult34Nm;
	}

	/**
	 * @param preResult34Nm セットする preResult34Nm
	 */
	public void setPreResult34Nm(String preResult34Nm) {
		this.preResult34Nm = preResult34Nm;
	}

	/**
	 * NF012DTO.javapreResult35Nmを設定
	 * @return preResult35Nm
	 */
	public String getPreResult35Nm() {
		return preResult35Nm;
	}

	/**
	 * @param preResult35Nm セットする preResult35Nm
	 */
	public void setPreResult35Nm(String preResult35Nm) {
		this.preResult35Nm = preResult35Nm;
	}

	/**
	 * NF012DTO.javapreResult36Nmを設定
	 * @return preResult36Nm
	 */
	public String getPreResult36Nm() {
		return preResult36Nm;
	}

	/**
	 * @param preResult36Nm セットする preResult36Nm
	 */
	public void setPreResult36Nm(String preResult36Nm) {
		this.preResult36Nm = preResult36Nm;
	}

	/**
	 * NF012DTO.javapreEquip01を設定
	 * @return preEquip01
	 */
	public String getPreEquip01() {
		return preEquip01;
	}

	/**
	 * @param preEquip01 セットする preEquip01
	 */
	public void setPreEquip01(String preEquip01) {
		this.preEquip01 = preEquip01;
	}

	/**
	 * NF012DTO.javapreEquip02を設定
	 * @return preEquip02
	 */
	public String getPreEquip02() {
		return preEquip02;
	}

	/**
	 * @param preEquip02 セットする preEquip02
	 */
	public void setPreEquip02(String preEquip02) {
		this.preEquip02 = preEquip02;
	}

	/**
	 * NF012DTO.javapreEquip03を設定
	 * @return preEquip03
	 */
	public String getPreEquip03() {
		return preEquip03;
	}

	/**
	 * @param preEquip03 セットする preEquip03
	 */
	public void setPreEquip03(String preEquip03) {
		this.preEquip03 = preEquip03;
	}

	/**
	 * NF012DTO.javapreEquip07を設定
	 * @return preEquip07
	 */
	public String getPreEquip07() {
		return preEquip07;
	}

	/**
	 * @param preEquip07 セットする preEquip07
	 */
	public void setPreEquip07(String preEquip07) {
		this.preEquip07 = preEquip07;
	}

	/**
	 * NF012DTO.javapreEquip09を設定
	 * @return preEquip09
	 */
	public String getPreEquip09() {
		return preEquip09;
	}

	/**
	 * @param preEquip09 セットする preEquip09
	 */
	public void setPreEquip09(String preEquip09) {
		this.preEquip09 = preEquip09;
	}

	/**
	 * NF012DTO.javapreEquip01Nmを設定
	 * @return preEquip01Nm
	 */
	public String getPreEquip01Nm() {
		return preEquip01Nm;
	}

	/**
	 * @param preEquip01Nm セットする preEquip01Nm
	 */
	public void setPreEquip01Nm(String preEquip01Nm) {
		this.preEquip01Nm = preEquip01Nm;
	}

	/**
	 * NF012DTO.javapreEquip02Nmを設定
	 * @return preEquip02Nm
	 */
	public String getPreEquip02Nm() {
		return preEquip02Nm;
	}

	/**
	 * @param preEquip02Nm セットする preEquip02Nm
	 */
	public void setPreEquip02Nm(String preEquip02Nm) {
		this.preEquip02Nm = preEquip02Nm;
	}

	/**
	 * NF012DTO.javapreEquip03Nmを設定
	 * @return preEquip03Nm
	 */
	public String getPreEquip03Nm() {
		return preEquip03Nm;
	}

	/**
	 * @param preEquip03Nm セットする preEquip03Nm
	 */
	public void setPreEquip03Nm(String preEquip03Nm) {
		this.preEquip03Nm = preEquip03Nm;
	}

	/**
	 * NF012DTO.javapreEquip07Nmを設定
	 * @return preEquip07Nm
	 */
	public String getPreEquip07Nm() {
		return preEquip07Nm;
	}

	/**
	 * @param preEquip07Nm セットする preEquip07Nm
	 */
	public void setPreEquip07Nm(String preEquip07Nm) {
		this.preEquip07Nm = preEquip07Nm;
	}

	/**
	 * NF012DTO.javapreEquip09Nmを設定
	 * @return preEquip09Nm
	 */
	public String getPreEquip09Nm() {
		return preEquip09Nm;
	}

	/**
	 * @param preEquip09Nm セットする preEquip09Nm
	 */
	public void setPreEquip09Nm(String preEquip09Nm) {
		this.preEquip09Nm = preEquip09Nm;
	}

	/**
	 * NF012DTO.javapreMarket01を設定
	 * @return preMarket01
	 */
	public String getPreMarket01() {
		return preMarket01;
	}

	/**
	 * @param preMarket01 セットする preMarket01
	 */
	public void setPreMarket01(String preMarket01) {
		this.preMarket01 = preMarket01;
	}

	/**
	 * NF012DTO.javapreMarket02を設定
	 * @return preMarket02
	 */
	public String getPreMarket02() {
		return preMarket02;
	}

	/**
	 * @param preMarket02 セットする preMarket02
	 */
	public void setPreMarket02(String preMarket02) {
		this.preMarket02 = preMarket02;
	}

	/**
	 * NF012DTO.javapreMarket03を設定
	 * @return preMarket03
	 */
	public String getPreMarket03() {
		return preMarket03;
	}

	/**
	 * @param preMarket03 セットする preMarket03
	 */
	public void setPreMarket03(String preMarket03) {
		this.preMarket03 = preMarket03;
	}

	/**
	 * NF012DTO.javapreMarket04を設定
	 * @return preMarket04
	 */
	public String getPreMarket04() {
		return preMarket04;
	}

	/**
	 * @param preMarket04 セットする preMarket04
	 */
	public void setPreMarket04(String preMarket04) {
		this.preMarket04 = preMarket04;
	}

	/**
	 * NF012DTO.javapreMarket06を設定
	 * @return preMarket06
	 */
	public String getPreMarket06() {
		return preMarket06;
	}

	/**
	 * @param preMarket06 セットする preMarket06
	 */
	public void setPreMarket06(String preMarket06) {
		this.preMarket06 = preMarket06;
	}

	/**
	 * NF012DTO.javapreMarket07を設定
	 * @return preMarket07
	 */
	public String getPreMarket07() {
		return preMarket07;
	}

	/**
	 * @param preMarket07 セットする preMarket07
	 */
	public void setPreMarket07(String preMarket07) {
		this.preMarket07 = preMarket07;
	}

	/**
	 * NF012DTO.javapreMarket09を設定
	 * @return preMarket09
	 */
	public String getPreMarket09() {
		return preMarket09;
	}

	/**
	 * @param preMarket09 セットする preMarket09
	 */
	public void setPreMarket09(String preMarket09) {
		this.preMarket09 = preMarket09;
	}

	/**
	 * NF012DTO.javapreMarket01Nmを設定
	 * @return preMarket01Nm
	 */
	public String getPreMarket01Nm() {
		return preMarket01Nm;
	}

	/**
	 * @param preMarket01Nm セットする preMarket01Nm
	 */
	public void setPreMarket01Nm(String preMarket01Nm) {
		this.preMarket01Nm = preMarket01Nm;
	}

	/**
	 * NF012DTO.javapreMarket02Nmを設定
	 * @return preMarket02Nm
	 */
	public String getPreMarket02Nm() {
		return preMarket02Nm;
	}

	/**
	 * @param preMarket02Nm セットする preMarket02Nm
	 */
	public void setPreMarket02Nm(String preMarket02Nm) {
		this.preMarket02Nm = preMarket02Nm;
	}

	/**
	 * NF012DTO.javapreMarket03Nmを設定
	 * @return preMarket03Nm
	 */
	public String getPreMarket03Nm() {
		return preMarket03Nm;
	}

	/**
	 * @param preMarket03Nm セットする preMarket03Nm
	 */
	public void setPreMarket03Nm(String preMarket03Nm) {
		this.preMarket03Nm = preMarket03Nm;
	}

	/**
	 * NF012DTO.javapreMarket04Nmを設定
	 * @return preMarket04Nm
	 */
	public String getPreMarket04Nm() {
		return preMarket04Nm;
	}

	/**
	 * @param preMarket04Nm セットする preMarket04Nm
	 */
	public void setPreMarket04Nm(String preMarket04Nm) {
		this.preMarket04Nm = preMarket04Nm;
	}

	/**
	 * NF012DTO.javapreMarket06Nmを設定
	 * @return preMarket06Nm
	 */
	public String getPreMarket06Nm() {
		return preMarket06Nm;
	}

	/**
	 * @param preMarket06Nm セットする preMarket06Nm
	 */
	public void setPreMarket06Nm(String preMarket06Nm) {
		this.preMarket06Nm = preMarket06Nm;
	}

	/**
	 * NF012DTO.javapreMarket07Nmを設定
	 * @return preMarket07Nm
	 */
	public String getPreMarket07Nm() {
		return preMarket07Nm;
	}

	/**
	 * @param preMarket07Nm セットする preMarket07Nm
	 */
	public void setPreMarket07Nm(String preMarket07Nm) {
		this.preMarket07Nm = preMarket07Nm;
	}

	/**
	 * NF012DTO.javapreMarket09Nmを設定
	 * @return preMarket09Nm
	 */
	public String getPreMarket09Nm() {
		return preMarket09Nm;
	}

	/**
	 * @param preMarket09Nm セットする preMarket09Nm
	 */
	public void setPreMarket09Nm(String preMarket09Nm) {
		this.preMarket09Nm = preMarket09Nm;
	}

	/**
	 * NF012DTO.javapreMedical12を設定
	 * @return preMedical12
	 */
	public String getPreMedical12() {
		return preMedical12;
	}

	/**
	 * @param preMedical12 セットする preMedical12
	 */
	public void setPreMedical12(String preMedical12) {
		this.preMedical12 = preMedical12;
	}

	/**
	 * NF012DTO.javapreMedical12Nmを設定
	 * @return preMedical12Nm
	 */
	public String getPreMedical12Nm() {
		return preMedical12Nm;
	}

	/**
	 * @param preMedical12Nm セットする preMedical12Nm
	 */
	public void setPreMedical12Nm(String preMedical12Nm) {
		this.preMedical12Nm = preMedical12Nm;
	}

	/**
	 * NF012DTO.javapreSpfunc01を設定
	 * @return preSpfunc01
	 */
	public String getPreSpfunc01() {
		return preSpfunc01;
	}

	/**
	 * @param preSpfunc01 セットする preSpfunc01
	 */
	public void setPreSpfunc01(String preSpfunc01) {
		this.preSpfunc01 = preSpfunc01;
	}

	/**
	 * NF012DTO.javapreSpfunc03を設定
	 * @return preSpfunc03
	 */
	public String getPreSpfunc03() {
		return preSpfunc03;
	}

	/**
	 * @param preSpfunc03 セットする preSpfunc03
	 */
	public void setPreSpfunc03(String preSpfunc03) {
		this.preSpfunc03 = preSpfunc03;
	}

	/**
	 * NF012DTO.javapreSpfunc04を設定
	 * @return preSpfunc04
	 */
	public String getPreSpfunc04() {
		return preSpfunc04;
	}

	/**
	 * @param preSpfunc04 セットする preSpfunc04
	 */
	public void setPreSpfunc04(String preSpfunc04) {
		this.preSpfunc04 = preSpfunc04;
	}

	/**
	 * NF012DTO.javapreSpfunc01Nmを設定
	 * @return preSpfunc01Nm
	 */
	public String getPreSpfunc01Nm() {
		return preSpfunc01Nm;
	}

	/**
	 * @param preSpfunc01Nm セットする preSpfunc01Nm
	 */
	public void setPreSpfunc01Nm(String preSpfunc01Nm) {
		this.preSpfunc01Nm = preSpfunc01Nm;
	}

	/**
	 * NF012DTO.javapreSpfunc03Nmを設定
	 * @return preSpfunc03Nm
	 */
	public String getPreSpfunc03Nm() {
		return preSpfunc03Nm;
	}

	/**
	 * @param preSpfunc03Nm セットする preSpfunc03Nm
	 */
	public void setPreSpfunc03Nm(String preSpfunc03Nm) {
		this.preSpfunc03Nm = preSpfunc03Nm;
	}

	/**
	 * NF012DTO.javapreSpfunc04Nmを設定
	 * @return preSpfunc04Nm
	 */
	public String getPreSpfunc04Nm() {
		return preSpfunc04Nm;
	}

	/**
	 * @param preSpfunc04Nm セットする preSpfunc04Nm
	 */
	public void setPreSpfunc04Nm(String preSpfunc04Nm) {
		this.preSpfunc04Nm = preSpfunc04Nm;
	}

	/**
	 * NF012DTO.javapreTieup10を設定
	 * @return preTieup10
	 */
	public String getPreTieup10() {
		return preTieup10;
	}

	/**
	 * @param preTieup10 セットする preTieup10
	 */
	public void setPreTieup10(String preTieup10) {
		this.preTieup10 = preTieup10;
	}

	/**
	 * NF012DTO.javapreTieup11を設定
	 * @return preTieup11
	 */
	public String getPreTieup11() {
		return preTieup11;
	}

	/**
	 * @param preTieup11 セットする preTieup11
	 */
	public void setPreTieup11(String preTieup11) {
		this.preTieup11 = preTieup11;
	}

	/**
	 * NF012DTO.javapreTieup12を設定
	 * @return preTieup12
	 */
	public String getPreTieup12() {
		return preTieup12;
	}

	/**
	 * @param preTieup12 セットする preTieup12
	 */
	public void setPreTieup12(String preTieup12) {
		this.preTieup12 = preTieup12;
	}

	/**
	 * NF012DTO.javapreTieup10Nmを設定
	 * @return preTieup10Nm
	 */
	public String getPreTieup10Nm() {
		return preTieup10Nm;
	}

	/**
	 * @param preTieup10Nm セットする preTieup10Nm
	 */
	public void setPreTieup10Nm(String preTieup10Nm) {
		this.preTieup10Nm = preTieup10Nm;
	}

	/**
	 * NF012DTO.javapreTieup11Nmを設定
	 * @return preTieup11Nm
	 */
	public String getPreTieup11Nm() {
		return preTieup11Nm;
	}

	/**
	 * @param preTieup11Nm セットする preTieup11Nm
	 */
	public void setPreTieup11Nm(String preTieup11Nm) {
		this.preTieup11Nm = preTieup11Nm;
	}

	/**
	 * NF012DTO.javapreTieup12Nmを設定
	 * @return preTieup12Nm
	 */
	public String getPreTieup12Nm() {
		return preTieup12Nm;
	}

	/**
	 * @param preTieup12Nm セットする preTieup12Nm
	 */
	public void setPreTieup12Nm(String preTieup12Nm) {
		this.preTieup12Nm = preTieup12Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0001を設定
	 * @return preUsercd0001
	 */
	public String getPreUsercd0001() {
		return preUsercd0001;
	}

	/**
	 * @param preUsercd0001 セットする preUsercd0001
	 */
	public void setPreUsercd0001(String preUsercd0001) {
		this.preUsercd0001 = preUsercd0001;
	}

	/**
	 * NF012DTO.javapreUsercd0002を設定
	 * @return preUsercd0002
	 */
	public String getPreUsercd0002() {
		return preUsercd0002;
	}

	/**
	 * @param preUsercd0002 セットする preUsercd0002
	 */
	public void setPreUsercd0002(String preUsercd0002) {
		this.preUsercd0002 = preUsercd0002;
	}

	/**
	 * NF012DTO.javapreUsercd0003を設定
	 * @return preUsercd0003
	 */
	public String getPreUsercd0003() {
		return preUsercd0003;
	}

	/**
	 * @param preUsercd0003 セットする preUsercd0003
	 */
	public void setPreUsercd0003(String preUsercd0003) {
		this.preUsercd0003 = preUsercd0003;
	}

	/**
	 * NF012DTO.javapreUsercd0004を設定
	 * @return preUsercd0004
	 */
	public String getPreUsercd0004() {
		return preUsercd0004;
	}

	/**
	 * @param preUsercd0004 セットする preUsercd0004
	 */
	public void setPreUsercd0004(String preUsercd0004) {
		this.preUsercd0004 = preUsercd0004;
	}

	/**
	 * NF012DTO.javapreUsercd0005を設定
	 * @return preUsercd0005
	 */
	public String getPreUsercd0005() {
		return preUsercd0005;
	}

	/**
	 * @param preUsercd0005 セットする preUsercd0005
	 */
	public void setPreUsercd0005(String preUsercd0005) {
		this.preUsercd0005 = preUsercd0005;
	}

	/**
	 * NF012DTO.javapreUsercd0006を設定
	 * @return preUsercd0006
	 */
	public String getPreUsercd0006() {
		return preUsercd0006;
	}

	/**
	 * @param preUsercd0006 セットする preUsercd0006
	 */
	public void setPreUsercd0006(String preUsercd0006) {
		this.preUsercd0006 = preUsercd0006;
	}

	/**
	 * NF012DTO.javapreUsercd0007を設定
	 * @return preUsercd0007
	 */
	public String getPreUsercd0007() {
		return preUsercd0007;
	}

	/**
	 * @param preUsercd0007 セットする preUsercd0007
	 */
	public void setPreUsercd0007(String preUsercd0007) {
		this.preUsercd0007 = preUsercd0007;
	}

	/**
	 * NF012DTO.javapreUsercd0008を設定
	 * @return preUsercd0008
	 */
	public String getPreUsercd0008() {
		return preUsercd0008;
	}

	/**
	 * @param preUsercd0008 セットする preUsercd0008
	 */
	public void setPreUsercd0008(String preUsercd0008) {
		this.preUsercd0008 = preUsercd0008;
	}

	/**
	 * NF012DTO.javapreUsercd0009を設定
	 * @return preUsercd0009
	 */
	public String getPreUsercd0009() {
		return preUsercd0009;
	}

	/**
	 * @param preUsercd0009 セットする preUsercd0009
	 */
	public void setPreUsercd0009(String preUsercd0009) {
		this.preUsercd0009 = preUsercd0009;
	}

	/**
	 * NF012DTO.javapreUsercd0010を設定
	 * @return preUsercd0010
	 */
	public String getPreUsercd0010() {
		return preUsercd0010;
	}

	/**
	 * @param preUsercd0010 セットする preUsercd0010
	 */
	public void setPreUsercd0010(String preUsercd0010) {
		this.preUsercd0010 = preUsercd0010;
	}

	/**
	 * NF012DTO.javapreUsercd0011を設定
	 * @return preUsercd0011
	 */
	public String getPreUsercd0011() {
		return preUsercd0011;
	}

	/**
	 * @param preUsercd0011 セットする preUsercd0011
	 */
	public void setPreUsercd0011(String preUsercd0011) {
		this.preUsercd0011 = preUsercd0011;
	}

	/**
	 * NF012DTO.javapreUsercd0012を設定
	 * @return preUsercd0012
	 */
	public String getPreUsercd0012() {
		return preUsercd0012;
	}

	/**
	 * @param preUsercd0012 セットする preUsercd0012
	 */
	public void setPreUsercd0012(String preUsercd0012) {
		this.preUsercd0012 = preUsercd0012;
	}

	/**
	 * NF012DTO.javapreUsercd0013を設定
	 * @return preUsercd0013
	 */
	public String getPreUsercd0013() {
		return preUsercd0013;
	}

	/**
	 * @param preUsercd0013 セットする preUsercd0013
	 */
	public void setPreUsercd0013(String preUsercd0013) {
		this.preUsercd0013 = preUsercd0013;
	}

	/**
	 * NF012DTO.javapreUsercd0014を設定
	 * @return preUsercd0014
	 */
	public String getPreUsercd0014() {
		return preUsercd0014;
	}

	/**
	 * @param preUsercd0014 セットする preUsercd0014
	 */
	public void setPreUsercd0014(String preUsercd0014) {
		this.preUsercd0014 = preUsercd0014;
	}

	/**
	 * NF012DTO.javapreUsercd0015を設定
	 * @return preUsercd0015
	 */
	public String getPreUsercd0015() {
		return preUsercd0015;
	}

	/**
	 * @param preUsercd0015 セットする preUsercd0015
	 */
	public void setPreUsercd0015(String preUsercd0015) {
		this.preUsercd0015 = preUsercd0015;
	}

	/**
	 * NF012DTO.javapreUsercd0016を設定
	 * @return preUsercd0016
	 */
	public String getPreUsercd0016() {
		return preUsercd0016;
	}

	/**
	 * @param preUsercd0016 セットする preUsercd0016
	 */
	public void setPreUsercd0016(String preUsercd0016) {
		this.preUsercd0016 = preUsercd0016;
	}

	/**
	 * NF012DTO.javapreUsercd0017を設定
	 * @return preUsercd0017
	 */
	public String getPreUsercd0017() {
		return preUsercd0017;
	}

	/**
	 * @param preUsercd0017 セットする preUsercd0017
	 */
	public void setPreUsercd0017(String preUsercd0017) {
		this.preUsercd0017 = preUsercd0017;
	}

	/**
	 * NF012DTO.javapreUsercd0018を設定
	 * @return preUsercd0018
	 */
	public String getPreUsercd0018() {
		return preUsercd0018;
	}

	/**
	 * @param preUsercd0018 セットする preUsercd0018
	 */
	public void setPreUsercd0018(String preUsercd0018) {
		this.preUsercd0018 = preUsercd0018;
	}

	/**
	 * NF012DTO.javapreUsercd0019を設定
	 * @return preUsercd0019
	 */
	public String getPreUsercd0019() {
		return preUsercd0019;
	}

	/**
	 * @param preUsercd0019 セットする preUsercd0019
	 */
	public void setPreUsercd0019(String preUsercd0019) {
		this.preUsercd0019 = preUsercd0019;
	}

	/**
	 * NF012DTO.javapreUsercd0020を設定
	 * @return preUsercd0020
	 */
	public String getPreUsercd0020() {
		return preUsercd0020;
	}

	/**
	 * @param preUsercd0020 セットする preUsercd0020
	 */
	public void setPreUsercd0020(String preUsercd0020) {
		this.preUsercd0020 = preUsercd0020;
	}

	/**
	 * NF012DTO.javapreUsercd0021を設定
	 * @return preUsercd0021
	 */
	public String getPreUsercd0021() {
		return preUsercd0021;
	}

	/**
	 * @param preUsercd0021 セットする preUsercd0021
	 */
	public void setPreUsercd0021(String preUsercd0021) {
		this.preUsercd0021 = preUsercd0021;
	}

	/**
	 * NF012DTO.javapreUsercd0022を設定
	 * @return preUsercd0022
	 */
	public String getPreUsercd0022() {
		return preUsercd0022;
	}

	/**
	 * @param preUsercd0022 セットする preUsercd0022
	 */
	public void setPreUsercd0022(String preUsercd0022) {
		this.preUsercd0022 = preUsercd0022;
	}

	/**
	 * NF012DTO.javapreUsercd0023を設定
	 * @return preUsercd0023
	 */
	public String getPreUsercd0023() {
		return preUsercd0023;
	}

	/**
	 * @param preUsercd0023 セットする preUsercd0023
	 */
	public void setPreUsercd0023(String preUsercd0023) {
		this.preUsercd0023 = preUsercd0023;
	}

	/**
	 * NF012DTO.javapreUsercd0024を設定
	 * @return preUsercd0024
	 */
	public String getPreUsercd0024() {
		return preUsercd0024;
	}

	/**
	 * @param preUsercd0024 セットする preUsercd0024
	 */
	public void setPreUsercd0024(String preUsercd0024) {
		this.preUsercd0024 = preUsercd0024;
	}

	/**
	 * NF012DTO.javapreUsercd0025を設定
	 * @return preUsercd0025
	 */
	public String getPreUsercd0025() {
		return preUsercd0025;
	}

	/**
	 * @param preUsercd0025 セットする preUsercd0025
	 */
	public void setPreUsercd0025(String preUsercd0025) {
		this.preUsercd0025 = preUsercd0025;
	}

	/**
	 * NF012DTO.javapreUsercd0026を設定
	 * @return preUsercd0026
	 */
	public String getPreUsercd0026() {
		return preUsercd0026;
	}

	/**
	 * @param preUsercd0026 セットする preUsercd0026
	 */
	public void setPreUsercd0026(String preUsercd0026) {
		this.preUsercd0026 = preUsercd0026;
	}

	/**
	 * NF012DTO.javapreUsercd0027を設定
	 * @return preUsercd0027
	 */
	public String getPreUsercd0027() {
		return preUsercd0027;
	}

	/**
	 * @param preUsercd0027 セットする preUsercd0027
	 */
	public void setPreUsercd0027(String preUsercd0027) {
		this.preUsercd0027 = preUsercd0027;
	}

	/**
	 * NF012DTO.javapreUsercd0028を設定
	 * @return preUsercd0028
	 */
	public String getPreUsercd0028() {
		return preUsercd0028;
	}

	/**
	 * @param preUsercd0028 セットする preUsercd0028
	 */
	public void setPreUsercd0028(String preUsercd0028) {
		this.preUsercd0028 = preUsercd0028;
	}

	/**
	 * NF012DTO.javapreUsercd0029を設定
	 * @return preUsercd0029
	 */
	public String getPreUsercd0029() {
		return preUsercd0029;
	}

	/**
	 * @param preUsercd0029 セットする preUsercd0029
	 */
	public void setPreUsercd0029(String preUsercd0029) {
		this.preUsercd0029 = preUsercd0029;
	}

	/**
	 * NF012DTO.javapreUsercd0030を設定
	 * @return preUsercd0030
	 */
	public String getPreUsercd0030() {
		return preUsercd0030;
	}

	/**
	 * @param preUsercd0030 セットする preUsercd0030
	 */
	public void setPreUsercd0030(String preUsercd0030) {
		this.preUsercd0030 = preUsercd0030;
	}

	/**
	 * NF012DTO.javapreUsercd0031を設定
	 * @return preUsercd0031
	 */
	public String getPreUsercd0031() {
		return preUsercd0031;
	}

	/**
	 * @param preUsercd0031 セットする preUsercd0031
	 */
	public void setPreUsercd0031(String preUsercd0031) {
		this.preUsercd0031 = preUsercd0031;
	}

	/**
	 * NF012DTO.javapreUsercd0032を設定
	 * @return preUsercd0032
	 */
	public String getPreUsercd0032() {
		return preUsercd0032;
	}

	/**
	 * @param preUsercd0032 セットする preUsercd0032
	 */
	public void setPreUsercd0032(String preUsercd0032) {
		this.preUsercd0032 = preUsercd0032;
	}

	/**
	 * NF012DTO.javapreUsercd0033を設定
	 * @return preUsercd0033
	 */
	public String getPreUsercd0033() {
		return preUsercd0033;
	}

	/**
	 * @param preUsercd0033 セットする preUsercd0033
	 */
	public void setPreUsercd0033(String preUsercd0033) {
		this.preUsercd0033 = preUsercd0033;
	}

	/**
	 * NF012DTO.javapreUsercd0034を設定
	 * @return preUsercd0034
	 */
	public String getPreUsercd0034() {
		return preUsercd0034;
	}

	/**
	 * @param preUsercd0034 セットする preUsercd0034
	 */
	public void setPreUsercd0034(String preUsercd0034) {
		this.preUsercd0034 = preUsercd0034;
	}

	/**
	 * NF012DTO.javapreUsercd0035を設定
	 * @return preUsercd0035
	 */
	public String getPreUsercd0035() {
		return preUsercd0035;
	}

	/**
	 * @param preUsercd0035 セットする preUsercd0035
	 */
	public void setPreUsercd0035(String preUsercd0035) {
		this.preUsercd0035 = preUsercd0035;
	}

	/**
	 * NF012DTO.javapreUsercd0036を設定
	 * @return preUsercd0036
	 */
	public String getPreUsercd0036() {
		return preUsercd0036;
	}

	/**
	 * @param preUsercd0036 セットする preUsercd0036
	 */
	public void setPreUsercd0036(String preUsercd0036) {
		this.preUsercd0036 = preUsercd0036;
	}

	/**
	 * NF012DTO.javapreUsercd0001Nmを設定
	 * @return preUsercd0001Nm
	 */
	public String getPreUsercd0001Nm() {
		return preUsercd0001Nm;
	}

	/**
	 * @param preUsercd0001Nm セットする preUsercd0001Nm
	 */
	public void setPreUsercd0001Nm(String preUsercd0001Nm) {
		this.preUsercd0001Nm = preUsercd0001Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0002Nmを設定
	 * @return preUsercd0002Nm
	 */
	public String getPreUsercd0002Nm() {
		return preUsercd0002Nm;
	}

	/**
	 * @param preUsercd0002Nm セットする preUsercd0002Nm
	 */
	public void setPreUsercd0002Nm(String preUsercd0002Nm) {
		this.preUsercd0002Nm = preUsercd0002Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0003Nmを設定
	 * @return preUsercd0003Nm
	 */
	public String getPreUsercd0003Nm() {
		return preUsercd0003Nm;
	}

	/**
	 * @param preUsercd0003Nm セットする preUsercd0003Nm
	 */
	public void setPreUsercd0003Nm(String preUsercd0003Nm) {
		this.preUsercd0003Nm = preUsercd0003Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0004Nmを設定
	 * @return preUsercd0004Nm
	 */
	public String getPreUsercd0004Nm() {
		return preUsercd0004Nm;
	}

	/**
	 * @param preUsercd0004Nm セットする preUsercd0004Nm
	 */
	public void setPreUsercd0004Nm(String preUsercd0004Nm) {
		this.preUsercd0004Nm = preUsercd0004Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0005Nmを設定
	 * @return preUsercd0005Nm
	 */
	public String getPreUsercd0005Nm() {
		return preUsercd0005Nm;
	}

	/**
	 * @param preUsercd0005Nm セットする preUsercd0005Nm
	 */
	public void setPreUsercd0005Nm(String preUsercd0005Nm) {
		this.preUsercd0005Nm = preUsercd0005Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0006Nmを設定
	 * @return preUsercd0006Nm
	 */
	public String getPreUsercd0006Nm() {
		return preUsercd0006Nm;
	}

	/**
	 * @param preUsercd0006Nm セットする preUsercd0006Nm
	 */
	public void setPreUsercd0006Nm(String preUsercd0006Nm) {
		this.preUsercd0006Nm = preUsercd0006Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0007Nmを設定
	 * @return preUsercd0007Nm
	 */
	public String getPreUsercd0007Nm() {
		return preUsercd0007Nm;
	}

	/**
	 * @param preUsercd0007Nm セットする preUsercd0007Nm
	 */
	public void setPreUsercd0007Nm(String preUsercd0007Nm) {
		this.preUsercd0007Nm = preUsercd0007Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0008Nmを設定
	 * @return preUsercd0008Nm
	 */
	public String getPreUsercd0008Nm() {
		return preUsercd0008Nm;
	}

	/**
	 * @param preUsercd0008Nm セットする preUsercd0008Nm
	 */
	public void setPreUsercd0008Nm(String preUsercd0008Nm) {
		this.preUsercd0008Nm = preUsercd0008Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0009Nmを設定
	 * @return preUsercd0009Nm
	 */
	public String getPreUsercd0009Nm() {
		return preUsercd0009Nm;
	}

	/**
	 * @param preUsercd0009Nm セットする preUsercd0009Nm
	 */
	public void setPreUsercd0009Nm(String preUsercd0009Nm) {
		this.preUsercd0009Nm = preUsercd0009Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0010Nmを設定
	 * @return preUsercd0010Nm
	 */
	public String getPreUsercd0010Nm() {
		return preUsercd0010Nm;
	}

	/**
	 * @param preUsercd0010Nm セットする preUsercd0010Nm
	 */
	public void setPreUsercd0010Nm(String preUsercd0010Nm) {
		this.preUsercd0010Nm = preUsercd0010Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0011Nmを設定
	 * @return preUsercd0011Nm
	 */
	public String getPreUsercd0011Nm() {
		return preUsercd0011Nm;
	}

	/**
	 * @param preUsercd0011Nm セットする preUsercd0011Nm
	 */
	public void setPreUsercd0011Nm(String preUsercd0011Nm) {
		this.preUsercd0011Nm = preUsercd0011Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0012Nmを設定
	 * @return preUsercd0012Nm
	 */
	public String getPreUsercd0012Nm() {
		return preUsercd0012Nm;
	}

	/**
	 * @param preUsercd0012Nm セットする preUsercd0012Nm
	 */
	public void setPreUsercd0012Nm(String preUsercd0012Nm) {
		this.preUsercd0012Nm = preUsercd0012Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0013Nmを設定
	 * @return preUsercd0013Nm
	 */
	public String getPreUsercd0013Nm() {
		return preUsercd0013Nm;
	}

	/**
	 * @param preUsercd0013Nm セットする preUsercd0013Nm
	 */
	public void setPreUsercd0013Nm(String preUsercd0013Nm) {
		this.preUsercd0013Nm = preUsercd0013Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0014Nmを設定
	 * @return preUsercd0014Nm
	 */
	public String getPreUsercd0014Nm() {
		return preUsercd0014Nm;
	}

	/**
	 * @param preUsercd0014Nm セットする preUsercd0014Nm
	 */
	public void setPreUsercd0014Nm(String preUsercd0014Nm) {
		this.preUsercd0014Nm = preUsercd0014Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0015Nmを設定
	 * @return preUsercd0015Nm
	 */
	public String getPreUsercd0015Nm() {
		return preUsercd0015Nm;
	}

	/**
	 * @param preUsercd0015Nm セットする preUsercd0015Nm
	 */
	public void setPreUsercd0015Nm(String preUsercd0015Nm) {
		this.preUsercd0015Nm = preUsercd0015Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0016Nmを設定
	 * @return preUsercd0016Nm
	 */
	public String getPreUsercd0016Nm() {
		return preUsercd0016Nm;
	}

	/**
	 * @param preUsercd0016Nm セットする preUsercd0016Nm
	 */
	public void setPreUsercd0016Nm(String preUsercd0016Nm) {
		this.preUsercd0016Nm = preUsercd0016Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0017Nmを設定
	 * @return preUsercd0017Nm
	 */
	public String getPreUsercd0017Nm() {
		return preUsercd0017Nm;
	}

	/**
	 * @param preUsercd0017Nm セットする preUsercd0017Nm
	 */
	public void setPreUsercd0017Nm(String preUsercd0017Nm) {
		this.preUsercd0017Nm = preUsercd0017Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0018Nmを設定
	 * @return preUsercd0018Nm
	 */
	public String getPreUsercd0018Nm() {
		return preUsercd0018Nm;
	}

	/**
	 * @param preUsercd0018Nm セットする preUsercd0018Nm
	 */
	public void setPreUsercd0018Nm(String preUsercd0018Nm) {
		this.preUsercd0018Nm = preUsercd0018Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0019Nmを設定
	 * @return preUsercd0019Nm
	 */
	public String getPreUsercd0019Nm() {
		return preUsercd0019Nm;
	}

	/**
	 * @param preUsercd0019Nm セットする preUsercd0019Nm
	 */
	public void setPreUsercd0019Nm(String preUsercd0019Nm) {
		this.preUsercd0019Nm = preUsercd0019Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0020Nmを設定
	 * @return preUsercd0020Nm
	 */
	public String getPreUsercd0020Nm() {
		return preUsercd0020Nm;
	}

	/**
	 * @param preUsercd0020Nm セットする preUsercd0020Nm
	 */
	public void setPreUsercd0020Nm(String preUsercd0020Nm) {
		this.preUsercd0020Nm = preUsercd0020Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0021Nmを設定
	 * @return preUsercd0021Nm
	 */
	public String getPreUsercd0021Nm() {
		return preUsercd0021Nm;
	}

	/**
	 * @param preUsercd0021Nm セットする preUsercd0021Nm
	 */
	public void setPreUsercd0021Nm(String preUsercd0021Nm) {
		this.preUsercd0021Nm = preUsercd0021Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0022Nmを設定
	 * @return preUsercd0022Nm
	 */
	public String getPreUsercd0022Nm() {
		return preUsercd0022Nm;
	}

	/**
	 * @param preUsercd0022Nm セットする preUsercd0022Nm
	 */
	public void setPreUsercd0022Nm(String preUsercd0022Nm) {
		this.preUsercd0022Nm = preUsercd0022Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0023Nmを設定
	 * @return preUsercd0023Nm
	 */
	public String getPreUsercd0023Nm() {
		return preUsercd0023Nm;
	}

	/**
	 * @param preUsercd0023Nm セットする preUsercd0023Nm
	 */
	public void setPreUsercd0023Nm(String preUsercd0023Nm) {
		this.preUsercd0023Nm = preUsercd0023Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0024Nmを設定
	 * @return preUsercd0024Nm
	 */
	public String getPreUsercd0024Nm() {
		return preUsercd0024Nm;
	}

	/**
	 * @param preUsercd0024Nm セットする preUsercd0024Nm
	 */
	public void setPreUsercd0024Nm(String preUsercd0024Nm) {
		this.preUsercd0024Nm = preUsercd0024Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0025Nmを設定
	 * @return preUsercd0025Nm
	 */
	public String getPreUsercd0025Nm() {
		return preUsercd0025Nm;
	}

	/**
	 * @param preUsercd0025Nm セットする preUsercd0025Nm
	 */
	public void setPreUsercd0025Nm(String preUsercd0025Nm) {
		this.preUsercd0025Nm = preUsercd0025Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0026Nmを設定
	 * @return preUsercd0026Nm
	 */
	public String getPreUsercd0026Nm() {
		return preUsercd0026Nm;
	}

	/**
	 * @param preUsercd0026Nm セットする preUsercd0026Nm
	 */
	public void setPreUsercd0026Nm(String preUsercd0026Nm) {
		this.preUsercd0026Nm = preUsercd0026Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0027Nmを設定
	 * @return preUsercd0027Nm
	 */
	public String getPreUsercd0027Nm() {
		return preUsercd0027Nm;
	}

	/**
	 * @param preUsercd0027Nm セットする preUsercd0027Nm
	 */
	public void setPreUsercd0027Nm(String preUsercd0027Nm) {
		this.preUsercd0027Nm = preUsercd0027Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0028Nmを設定
	 * @return preUsercd0028Nm
	 */
	public String getPreUsercd0028Nm() {
		return preUsercd0028Nm;
	}

	/**
	 * @param preUsercd0028Nm セットする preUsercd0028Nm
	 */
	public void setPreUsercd0028Nm(String preUsercd0028Nm) {
		this.preUsercd0028Nm = preUsercd0028Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0029Nmを設定
	 * @return preUsercd0029Nm
	 */
	public String getPreUsercd0029Nm() {
		return preUsercd0029Nm;
	}

	/**
	 * @param preUsercd0029Nm セットする preUsercd0029Nm
	 */
	public void setPreUsercd0029Nm(String preUsercd0029Nm) {
		this.preUsercd0029Nm = preUsercd0029Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0030Nmを設定
	 * @return preUsercd0030Nm
	 */
	public String getPreUsercd0030Nm() {
		return preUsercd0030Nm;
	}

	/**
	 * @param preUsercd0030Nm セットする preUsercd0030Nm
	 */
	public void setPreUsercd0030Nm(String preUsercd0030Nm) {
		this.preUsercd0030Nm = preUsercd0030Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0031Nmを設定
	 * @return preUsercd0031Nm
	 */
	public String getPreUsercd0031Nm() {
		return preUsercd0031Nm;
	}

	/**
	 * @param preUsercd0031Nm セットする preUsercd0031Nm
	 */
	public void setPreUsercd0031Nm(String preUsercd0031Nm) {
		this.preUsercd0031Nm = preUsercd0031Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0032Nmを設定
	 * @return preUsercd0032Nm
	 */
	public String getPreUsercd0032Nm() {
		return preUsercd0032Nm;
	}

	/**
	 * @param preUsercd0032Nm セットする preUsercd0032Nm
	 */
	public void setPreUsercd0032Nm(String preUsercd0032Nm) {
		this.preUsercd0032Nm = preUsercd0032Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0033Nmを設定
	 * @return preUsercd0033Nm
	 */
	public String getPreUsercd0033Nm() {
		return preUsercd0033Nm;
	}

	/**
	 * @param preUsercd0033Nm セットする preUsercd0033Nm
	 */
	public void setPreUsercd0033Nm(String preUsercd0033Nm) {
		this.preUsercd0033Nm = preUsercd0033Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0034Nmを設定
	 * @return preUsercd0034Nm
	 */
	public String getPreUsercd0034Nm() {
		return preUsercd0034Nm;
	}

	/**
	 * @param preUsercd0034Nm セットする preUsercd0034Nm
	 */
	public void setPreUsercd0034Nm(String preUsercd0034Nm) {
		this.preUsercd0034Nm = preUsercd0034Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0035Nmを設定
	 * @return preUsercd0035Nm
	 */
	public String getPreUsercd0035Nm() {
		return preUsercd0035Nm;
	}

	/**
	 * @param preUsercd0035Nm セットする preUsercd0035Nm
	 */
	public void setPreUsercd0035Nm(String preUsercd0035Nm) {
		this.preUsercd0035Nm = preUsercd0035Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0036Nmを設定
	 * @return preUsercd0036Nm
	 */
	public String getPreUsercd0036Nm() {
		return preUsercd0036Nm;
	}

	/**
	 * @param preUsercd0036Nm セットする preUsercd0036Nm
	 */
	public void setPreUsercd0036Nm(String preUsercd0036Nm) {
		this.preUsercd0036Nm = preUsercd0036Nm;
	}

	/**
	 * NF012DTO.javapreUsercd0101を設定
	 * @return preUsercd0101
	 */
	public String getPreUsercd0101() {
		return preUsercd0101;
	}

	/**
	 * @param preUsercd0101 セットする preUsercd0101
	 */
	public void setPreUsercd0101(String preUsercd0101) {
		this.preUsercd0101 = preUsercd0101;
	}

	/**
	 * NF012DTO.javapreUsercd0102を設定
	 * @return preUsercd0102
	 */
	public String getPreUsercd0102() {
		return preUsercd0102;
	}

	/**
	 * @param preUsercd0102 セットする preUsercd0102
	 */
	public void setPreUsercd0102(String preUsercd0102) {
		this.preUsercd0102 = preUsercd0102;
	}

	/**
	 * NF012DTO.javapreUsercd0103を設定
	 * @return preUsercd0103
	 */
	public String getPreUsercd0103() {
		return preUsercd0103;
	}

	/**
	 * @param preUsercd0103 セットする preUsercd0103
	 */
	public void setPreUsercd0103(String preUsercd0103) {
		this.preUsercd0103 = preUsercd0103;
	}

	/**
	 * NF012DTO.javapreUsercd0104を設定
	 * @return preUsercd0104
	 */
	public String getPreUsercd0104() {
		return preUsercd0104;
	}

	/**
	 * @param preUsercd0104 セットする preUsercd0104
	 */
	public void setPreUsercd0104(String preUsercd0104) {
		this.preUsercd0104 = preUsercd0104;
	}

	/**
	 * NF012DTO.javapreUsercd0105を設定
	 * @return preUsercd0105
	 */
	public String getPreUsercd0105() {
		return preUsercd0105;
	}

	/**
	 * @param preUsercd0105 セットする preUsercd0105
	 */
	public void setPreUsercd0105(String preUsercd0105) {
		this.preUsercd0105 = preUsercd0105;
	}

	/**
	 * NF012DTO.javapreUsercd0106を設定
	 * @return preUsercd0106
	 */
	public String getPreUsercd0106() {
		return preUsercd0106;
	}

	/**
	 * @param preUsercd0106 セットする preUsercd0106
	 */
	public void setPreUsercd0106(String preUsercd0106) {
		this.preUsercd0106 = preUsercd0106;
	}

	/**
	 * NF012DTO.javapreUsercd0107を設定
	 * @return preUsercd0107
	 */
	public String getPreUsercd0107() {
		return preUsercd0107;
	}

	/**
	 * @param preUsercd0107 セットする preUsercd0107
	 */
	public void setPreUsercd0107(String preUsercd0107) {
		this.preUsercd0107 = preUsercd0107;
	}

	/**
	 * NF012DTO.javapreUsercd0108を設定
	 * @return preUsercd0108
	 */
	public String getPreUsercd0108() {
		return preUsercd0108;
	}

	/**
	 * @param preUsercd0108 セットする preUsercd0108
	 */
	public void setPreUsercd0108(String preUsercd0108) {
		this.preUsercd0108 = preUsercd0108;
	}

	/**
	 * NF012DTO.javapreUsercd0109を設定
	 * @return preUsercd0109
	 */
	public String getPreUsercd0109() {
		return preUsercd0109;
	}

	/**
	 * @param preUsercd0109 セットする preUsercd0109
	 */
	public void setPreUsercd0109(String preUsercd0109) {
		this.preUsercd0109 = preUsercd0109;
	}

	/**
	 * NF012DTO.javapreUsercd0201を設定
	 * @return preUsercd0201
	 */
	public String getPreUsercd0201() {
		return preUsercd0201;
	}

	/**
	 * @param preUsercd0201 セットする preUsercd0201
	 */
	public void setPreUsercd0201(String preUsercd0201) {
		this.preUsercd0201 = preUsercd0201;
	}

	/**
	 * NF012DTO.javapreUsercd0202を設定
	 * @return preUsercd0202
	 */
	public String getPreUsercd0202() {
		return preUsercd0202;
	}

	/**
	 * @param preUsercd0202 セットする preUsercd0202
	 */
	public void setPreUsercd0202(String preUsercd0202) {
		this.preUsercd0202 = preUsercd0202;
	}

	/**
	 * NF012DTO.javapreUsercd0203を設定
	 * @return preUsercd0203
	 */
	public String getPreUsercd0203() {
		return preUsercd0203;
	}

	/**
	 * @param preUsercd0203 セットする preUsercd0203
	 */
	public void setPreUsercd0203(String preUsercd0203) {
		this.preUsercd0203 = preUsercd0203;
	}

	/**
	 * NF012DTO.javapreUsercd0204を設定
	 * @return preUsercd0204
	 */
	public String getPreUsercd0204() {
		return preUsercd0204;
	}

	/**
	 * @param preUsercd0204 セットする preUsercd0204
	 */
	public void setPreUsercd0204(String preUsercd0204) {
		this.preUsercd0204 = preUsercd0204;
	}

	/**
	 * NF012DTO.javapreUsercd0205を設定
	 * @return preUsercd0205
	 */
	public String getPreUsercd0205() {
		return preUsercd0205;
	}

	/**
	 * @param preUsercd0205 セットする preUsercd0205
	 */
	public void setPreUsercd0205(String preUsercd0205) {
		this.preUsercd0205 = preUsercd0205;
	}

	/**
	 * NF012DTO.javapreUsercd0206を設定
	 * @return preUsercd0206
	 */
	public String getPreUsercd0206() {
		return preUsercd0206;
	}

	/**
	 * @param preUsercd0206 セットする preUsercd0206
	 */
	public void setPreUsercd0206(String preUsercd0206) {
		this.preUsercd0206 = preUsercd0206;
	}

	/**
	 * NF012DTO.javapreReward04を設定
	 * @return preReward04
	 */
	public String getPreReward04() {
		return preReward04;
	}

	/**
	 * @param preReward04 セットする preReward04
	 */
	public void setPreReward04(String preReward04) {
		this.preReward04 = preReward04;
	}

	/**
	 * NF012DTO.javapreReward05を設定
	 * @return preReward05
	 */
	public String getPreReward05() {
		return preReward05;
	}

	/**
	 * @param preReward05 セットする preReward05
	 */
	public void setPreReward05(String preReward05) {
		this.preReward05 = preReward05;
	}

	/**
	 * NF012DTO.javapreReward08を設定
	 * @return preReward08
	 */
	public String getPreReward08() {
		return preReward08;
	}

	/**
	 * @param preReward08 セットする preReward08
	 */
	public void setPreReward08(String preReward08) {
		this.preReward08 = preReward08;
	}

	/**
	 * NF012DTO.javapreReward09を設定
	 * @return preReward09
	 */
	public String getPreReward09() {
		return preReward09;
	}

	/**
	 * @param preReward09 セットする preReward09
	 */
	public void setPreReward09(String preReward09) {
		this.preReward09 = preReward09;
	}

	/**
	 * NF012DTO.javapreReward18を設定
	 * @return preReward18
	 */
	public String getPreReward18() {
		return preReward18;
	}

	/**
	 * @param preReward18 セットする preReward18
	 */
	public void setPreReward18(String preReward18) {
		this.preReward18 = preReward18;
	}

	/**
	 * NF012DTO.javapreReward21を設定
	 * @return preReward21
	 */
	public String getPreReward21() {
		return preReward21;
	}

	/**
	 * @param preReward21 セットする preReward21
	 */
	public void setPreReward21(String preReward21) {
		this.preReward21 = preReward21;
	}

	/**
	 * NF012DTO.javapreReward23を設定
	 * @return preReward23
	 */
	public String getPreReward23() {
		return preReward23;
	}

	/**
	 * @param preReward23 セットする preReward23
	 */
	public void setPreReward23(String preReward23) {
		this.preReward23 = preReward23;
	}

	/**
	 * NF012DTO.javapreReward25を設定
	 * @return preReward25
	 */
	public String getPreReward25() {
		return preReward25;
	}

	/**
	 * @param preReward25 セットする preReward25
	 */
	public void setPreReward25(String preReward25) {
		this.preReward25 = preReward25;
	}

	/**
	 * NF012DTO.javapreReward26を設定
	 * @return preReward26
	 */
	public String getPreReward26() {
		return preReward26;
	}

	/**
	 * @param preReward26 セットする preReward26
	 */
	public void setPreReward26(String preReward26) {
		this.preReward26 = preReward26;
	}

	/**
	 * NF012DTO.javapreReward27を設定
	 * @return preReward27
	 */
	public String getPreReward27() {
		return preReward27;
	}

	/**
	 * @param preReward27 セットする preReward27
	 */
	public void setPreReward27(String preReward27) {
		this.preReward27 = preReward27;
	}

	/**
	 * NF012DTO.javapreReward29を設定
	 * @return preReward29
	 */
	public String getPreReward29() {
		return preReward29;
	}

	/**
	 * @param preReward29 セットする preReward29
	 */
	public void setPreReward29(String preReward29) {
		this.preReward29 = preReward29;
	}

	/**
	 * NF012DTO.javapreReward35を設定
	 * @return preReward35
	 */
	public String getPreReward35() {
		return preReward35;
	}

	/**
	 * @param preReward35 セットする preReward35
	 */
	public void setPreReward35(String preReward35) {
		this.preReward35 = preReward35;
	}

	/**
	 * NF012DTO.javapreReward36を設定
	 * @return preReward36
	 */
	public String getPreReward36() {
		return preReward36;
	}

	/**
	 * @param preReward36 セットする preReward36
	 */
	public void setPreReward36(String preReward36) {
		this.preReward36 = preReward36;
	}

	/**
	 * NF012DTO.javapreReward37を設定
	 * @return preReward37
	 */
	public String getPreReward37() {
		return preReward37;
	}

	/**
	 * @param preReward37 セットする preReward37
	 */
	public void setPreReward37(String preReward37) {
		this.preReward37 = preReward37;
	}

	/**
	 * NF012DTO.javapreReward44を設定
	 * @return preReward44
	 */
	public String getPreReward44() {
		return preReward44;
	}

	/**
	 * @param preReward44 セットする preReward44
	 */
	public void setPreReward44(String preReward44) {
		this.preReward44 = preReward44;
	}

	/**
	 * NF012DTO.javapreReward16を設定
	 * @return preReward16
	 */
	public String getPreReward16() {
		return preReward16;
	}

	/**
	 * @param preReward16 セットする preReward16
	 */
	public void setPreReward16(String preReward16) {
		this.preReward16 = preReward16;
	}

	/**
	 * NF012DTO.javapreReward17を設定
	 * @return preReward17
	 */
	public String getPreReward17() {
		return preReward17;
	}

	/**
	 * @param preReward17 セットする preReward17
	 */
	public void setPreReward17(String preReward17) {
		this.preReward17 = preReward17;
	}

	/**
	 * NF012DTO.javapreReward04Nmを設定
	 * @return preReward04Nm
	 */
	public String getPreReward04Nm() {
		return preReward04Nm;
	}

	/**
	 * @param preReward04Nm セットする preReward04Nm
	 */
	public void setPreReward04Nm(String preReward04Nm) {
		this.preReward04Nm = preReward04Nm;
	}

	/**
	 * NF012DTO.javapreReward05Nmを設定
	 * @return preReward05Nm
	 */
	public String getPreReward05Nm() {
		return preReward05Nm;
	}

	/**
	 * @param preReward05Nm セットする preReward05Nm
	 */
	public void setPreReward05Nm(String preReward05Nm) {
		this.preReward05Nm = preReward05Nm;
	}

	/**
	 * NF012DTO.javapreReward08Nmを設定
	 * @return preReward08Nm
	 */
	public String getPreReward08Nm() {
		return preReward08Nm;
	}

	/**
	 * @param preReward08Nm セットする preReward08Nm
	 */
	public void setPreReward08Nm(String preReward08Nm) {
		this.preReward08Nm = preReward08Nm;
	}

	/**
	 * NF012DTO.javapreReward09Nmを設定
	 * @return preReward09Nm
	 */
	public String getPreReward09Nm() {
		return preReward09Nm;
	}

	/**
	 * @param preReward09Nm セットする preReward09Nm
	 */
	public void setPreReward09Nm(String preReward09Nm) {
		this.preReward09Nm = preReward09Nm;
	}

	/**
	 * NF012DTO.javapreReward18Nmを設定
	 * @return preReward18Nm
	 */
	public String getPreReward18Nm() {
		return preReward18Nm;
	}

	/**
	 * @param preReward18Nm セットする preReward18Nm
	 */
	public void setPreReward18Nm(String preReward18Nm) {
		this.preReward18Nm = preReward18Nm;
	}

	/**
	 * NF012DTO.javapreReward21Nmを設定
	 * @return preReward21Nm
	 */
	public String getPreReward21Nm() {
		return preReward21Nm;
	}

	/**
	 * @param preReward21Nm セットする preReward21Nm
	 */
	public void setPreReward21Nm(String preReward21Nm) {
		this.preReward21Nm = preReward21Nm;
	}

	/**
	 * NF012DTO.javapreReward23Nmを設定
	 * @return preReward23Nm
	 */
	public String getPreReward23Nm() {
		return preReward23Nm;
	}

	/**
	 * @param preReward23Nm セットする preReward23Nm
	 */
	public void setPreReward23Nm(String preReward23Nm) {
		this.preReward23Nm = preReward23Nm;
	}

	/**
	 * NF012DTO.javapreReward25Nmを設定
	 * @return preReward25Nm
	 */
	public String getPreReward25Nm() {
		return preReward25Nm;
	}

	/**
	 * @param preReward25Nm セットする preReward25Nm
	 */
	public void setPreReward25Nm(String preReward25Nm) {
		this.preReward25Nm = preReward25Nm;
	}

	/**
	 * NF012DTO.javapreReward26Nmを設定
	 * @return preReward26Nm
	 */
	public String getPreReward26Nm() {
		return preReward26Nm;
	}

	/**
	 * @param preReward26Nm セットする preReward26Nm
	 */
	public void setPreReward26Nm(String preReward26Nm) {
		this.preReward26Nm = preReward26Nm;
	}

	/**
	 * NF012DTO.javapreReward27Nmを設定
	 * @return preReward27Nm
	 */
	public String getPreReward27Nm() {
		return preReward27Nm;
	}

	/**
	 * @param preReward27Nm セットする preReward27Nm
	 */
	public void setPreReward27Nm(String preReward27Nm) {
		this.preReward27Nm = preReward27Nm;
	}

	/**
	 * NF012DTO.javapreReward29Nmを設定
	 * @return preReward29Nm
	 */
	public String getPreReward29Nm() {
		return preReward29Nm;
	}

	/**
	 * @param preReward29Nm セットする preReward29Nm
	 */
	public void setPreReward29Nm(String preReward29Nm) {
		this.preReward29Nm = preReward29Nm;
	}

	/**
	 * NF012DTO.javapreReward35Nmを設定
	 * @return preReward35Nm
	 */
	public String getPreReward35Nm() {
		return preReward35Nm;
	}

	/**
	 * @param preReward35Nm セットする preReward35Nm
	 */
	public void setPreReward35Nm(String preReward35Nm) {
		this.preReward35Nm = preReward35Nm;
	}

	/**
	 * NF012DTO.javapreReward36Nmを設定
	 * @return preReward36Nm
	 */
	public String getPreReward36Nm() {
		return preReward36Nm;
	}

	/**
	 * @param preReward36Nm セットする preReward36Nm
	 */
	public void setPreReward36Nm(String preReward36Nm) {
		this.preReward36Nm = preReward36Nm;
	}

	/**
	 * NF012DTO.javapreReward37Nmを設定
	 * @return preReward37Nm
	 */
	public String getPreReward37Nm() {
		return preReward37Nm;
	}

	/**
	 * @param preReward37Nm セットする preReward37Nm
	 */
	public void setPreReward37Nm(String preReward37Nm) {
		this.preReward37Nm = preReward37Nm;
	}

	/**
	 * NF012DTO.javapreReward44Nmを設定
	 * @return preReward44Nm
	 */
	public String getPreReward44Nm() {
		return preReward44Nm;
	}

	/**
	 * @param preReward44Nm セットする preReward44Nm
	 */
	public void setPreReward44Nm(String preReward44Nm) {
		this.preReward44Nm = preReward44Nm;
	}

	/**
	 * NF012DTO.javapreReward16Nmを設定
	 * @return preReward16Nm
	 */
	public String getPreReward16Nm() {
		return preReward16Nm;
	}

	/**
	 * @param preReward16Nm セットする preReward16Nm
	 */
	public void setPreReward16Nm(String preReward16Nm) {
		this.preReward16Nm = preReward16Nm;
	}

	/**
	 * NF012DTO.javapreReward17Nmを設定
	 * @return preReward17Nm
	 */
	public String getPreReward17Nm() {
		return preReward17Nm;
	}

	/**
	 * @param preReward17Nm セットする preReward17Nm
	 */
	public void setPreReward17Nm(String preReward17Nm) {
		this.preReward17Nm = preReward17Nm;
	}

	/**
	 * NF012DTO.javareqCommentを設定
	 * @return reqComment
	 */
	public String getReqComment() {
		return reqComment;
	}

	/**
	 * @param reqComment セットする reqComment
	 */
	public void setReqComment(String reqComment) {
		this.reqComment = reqComment;
	}

	/**
	 * NF012DTO.javaaprMemoを設定
	 * @return aprMemo
	 */
	public String getAprMemo() {
		return aprMemo;
	}

	/**
	 * @param aprMemo セットする aprMemo
	 */
	public void setAprMemo(String aprMemo) {
		this.aprMemo = aprMemo;
	}

	/**
	 * NF012DTO.javadisplayKbnを設定
	 * @return displayKbn
	 */
	public String getDisplayKbn() {
		return displayKbn;
	}

	/**
	 * @param displayKbn セットする displayKbn
	 */
	public void setDisplayKbn(String displayKbn) {
		this.displayKbn = displayKbn;
	}

	/**
	 * NF012DTO.javafuncIdを設定
	 * @return funcId
	 */
	public String getFuncId() {
		return funcId;
	}

	/**
	 * @param funcId セットする funcId
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	/**
	 * NF012DTO.javatradeTypeComboを設定
	 * @return tradeTypeCombo
	 */
	public LinkedHashMap<String, String> getTradeTypeCombo() {
		return tradeTypeCombo;
	}

	/**
	 * @param tradeTypeCombo セットする tradeTypeCombo
	 */
	public void setTradeTypeCombo(LinkedHashMap<String, String> tradeTypeCombo) {
		this.tradeTypeCombo = tradeTypeCombo;
	}

	/**
	 * NF012DTO.javainsOpenYearComboを設定
	 * @return insOpenYearCombo
	 */
	public LinkedHashMap<String, String> getInsOpenYearCombo() {
		return insOpenYearCombo;
	}

	/**
	 * @param insOpenYearCombo セットする insOpenYearCombo
	 */
	public void setInsOpenYearCombo(LinkedHashMap<String, String> insOpenYearCombo) {
		this.insOpenYearCombo = insOpenYearCombo;
	}

	/**
	 * NF012DTO.javainsOpenMonthComboを設定
	 * @return insOpenMonthCombo
	 */
	public LinkedHashMap<String, String> getInsOpenMonthCombo() {
		return insOpenMonthCombo;
	}

	/**
	 * @param insOpenMonthCombo セットする insOpenMonthCombo
	 */
	public void setInsOpenMonthCombo(LinkedHashMap<String, String> insOpenMonthCombo) {
		this.insOpenMonthCombo = insOpenMonthCombo;
	}

	/**
	 * NF012DTO.javainsOpenDayComboを設定
	 * @return insOpenDayCombo
	 */
	public LinkedHashMap<String, String> getInsOpenDayCombo() {
		return insOpenDayCombo;
	}

	/**
	 * @param insOpenDayCombo セットする insOpenDayCombo
	 */
	public void setInsOpenDayCombo(LinkedHashMap<String, String> insOpenDayCombo) {
		this.insOpenDayCombo = insOpenDayCombo;
	}

	/**
	 * NF012DTO.javaunivSubdivComboを設定
	 * @return univSubdivCombo
	 */
	public LinkedHashMap<String, String> getUnivSubdivCombo() {
		return univSubdivCombo;
	}

	/**
	 * @param univSubdivCombo セットする univSubdivCombo
	 */
	public void setUnivSubdivCombo(LinkedHashMap<String, String> univSubdivCombo) {
		this.univSubdivCombo = univSubdivCombo;
	}

	/**
	 * NF012DTO.javawsTypeComboを設定
	 * @return wsTypeCombo
	 */
	public LinkedHashMap<String, String> getWsTypeCombo() {
		return wsTypeCombo;
	}

	/**
	 * @param wsTypeCombo セットする wsTypeCombo
	 */
	public void setWsTypeCombo(LinkedHashMap<String, String> wsTypeCombo) {
		this.wsTypeCombo = wsTypeCombo;
	}

	/**
	 * NF012DTO.javabasketPurchaseComboを設定
	 * @return basketPurchaseCombo
	 */
	public LinkedHashMap<String, String> getBasketPurchaseCombo() {
		return basketPurchaseCombo;
	}

	/**
	 * @param basketPurchaseCombo セットする basketPurchaseCombo
	 */
	public void setBasketPurchaseCombo(LinkedHashMap<String, String> basketPurchaseCombo) {
		this.basketPurchaseCombo = basketPurchaseCombo;
	}

	/**
	 * NF012DTO.javafree0001Comboを設定
	 * @return free0001Combo
	 */
	public LinkedHashMap<String, String> getFree0001Combo() {
		return free0001Combo;
	}

	/**
	 * @param free0001Combo セットする free0001Combo
	 */
	public void setFree0001Combo(LinkedHashMap<String, String> free0001Combo) {
		this.free0001Combo = free0001Combo;
	}

	/**
	 * NF012DTO.javafree0002Comboを設定
	 * @return free0002Combo
	 */
	public LinkedHashMap<String, String> getFree0002Combo() {
		return free0002Combo;
	}

	/**
	 * @param free0002Combo セットする free0002Combo
	 */
	public void setFree0002Combo(LinkedHashMap<String, String> free0002Combo) {
		this.free0002Combo = free0002Combo;
	}

	/**
	 * NF012DTO.javafree0003Comboを設定
	 * @return free0003Combo
	 */
	public LinkedHashMap<String, String> getFree0003Combo() {
		return free0003Combo;
	}

	/**
	 * @param free0003Combo セットする free0003Combo
	 */
	public void setFree0003Combo(LinkedHashMap<String, String> free0003Combo) {
		this.free0003Combo = free0003Combo;
	}

	/**
	 * NF012DTO.javafree0015Comboを設定
	 * @return free0015Combo
	 */
	public LinkedHashMap<String, String> getFree0015Combo() {
		return free0015Combo;
	}

	/**
	 * @param free0015Combo セットする free0015Combo
	 */
	public void setFree0015Combo(LinkedHashMap<String, String> free0015Combo) {
		this.free0015Combo = free0015Combo;
	}

	/**
	 * NF012DTO.javafree0008Comboを設定
	 * @return free0008Combo
	 */
	public LinkedHashMap<String, String> getFree0008Combo() {
		return free0008Combo;
	}

	/**
	 * @param free0008Combo セットする free0008Combo
	 */
	public void setFree0008Combo(LinkedHashMap<String, String> free0008Combo) {
		this.free0008Combo = free0008Combo;
	}

	/**
	 * NF012DTO.javafree0009Comboを設定
	 * @return free0009Combo
	 */
	public LinkedHashMap<String, String> getFree0009Combo() {
		return free0009Combo;
	}

	/**
	 * @param free0009Combo セットする free0009Combo
	 */
	public void setFree0009Combo(LinkedHashMap<String, String> free0009Combo) {
		this.free0009Combo = free0009Combo;
	}

	/**
	 * NF012DTO.javafree0004Comboを設定
	 * @return free0004Combo
	 */
	public LinkedHashMap<String, String> getFree0004Combo() {
		return free0004Combo;
	}

	/**
	 * @param free0004Combo セットする free0004Combo
	 */
	public void setFree0004Combo(LinkedHashMap<String, String> free0004Combo) {
		this.free0004Combo = free0004Combo;
	}

	/**
	 * NF012DTO.javafree0005Comboを設定
	 * @return free0005Combo
	 */
	public LinkedHashMap<String, String> getFree0005Combo() {
		return free0005Combo;
	}

	/**
	 * @param free0005Combo セットする free0005Combo
	 */
	public void setFree0005Combo(LinkedHashMap<String, String> free0005Combo) {
		this.free0005Combo = free0005Combo;
	}

	/**
	 * NF012DTO.javafree0006Comboを設定
	 * @return free0006Combo
	 */
	public LinkedHashMap<String, String> getFree0006Combo() {
		return free0006Combo;
	}

	/**
	 * @param free0006Combo セットする free0006Combo
	 */
	public void setFree0006Combo(LinkedHashMap<String, String> free0006Combo) {
		this.free0006Combo = free0006Combo;
	}

	/**
	 * NF012DTO.javafree0007Comboを設定
	 * @return free0007Combo
	 */
	public LinkedHashMap<String, String> getFree0007Combo() {
		return free0007Combo;
	}

	/**
	 * @param free0007Combo セットする free0007Combo
	 */
	public void setFree0007Combo(LinkedHashMap<String, String> free0007Combo) {
		this.free0007Combo = free0007Combo;
	}

	/**
	 * NF012DTO.javafree0010Comboを設定
	 * @return free0010Combo
	 */
	public LinkedHashMap<String, String> getFree0010Combo() {
		return free0010Combo;
	}

	/**
	 * @param free0010Combo セットする free0010Combo
	 */
	public void setFree0010Combo(LinkedHashMap<String, String> free0010Combo) {
		this.free0010Combo = free0010Combo;
	}

	/**
	 * NF012DTO.javafree0011Comboを設定
	 * @return free0011Combo
	 */
	public LinkedHashMap<String, String> getFree0011Combo() {
		return free0011Combo;
	}

	/**
	 * @param free0011Combo セットする free0011Combo
	 */
	public void setFree0011Combo(LinkedHashMap<String, String> free0011Combo) {
		this.free0011Combo = free0011Combo;
	}

	/**
	 * NF012DTO.javafree0013Comboを設定
	 * @return free0013Combo
	 */
	public LinkedHashMap<String, String> getFree0013Combo() {
		return free0013Combo;
	}

	/**
	 * @param free0013Combo セットする free0013Combo
	 */
	public void setFree0013Combo(LinkedHashMap<String, String> free0013Combo) {
		this.free0013Combo = free0013Combo;
	}

	/**
	 * NF012DTO.javafree0014Comboを設定
	 * @return free0014Combo
	 */
	public LinkedHashMap<String, String> getFree0014Combo() {
		return free0014Combo;
	}

	/**
	 * @param free0014Combo セットする free0014Combo
	 */
	public void setFree0014Combo(LinkedHashMap<String, String> free0014Combo) {
		this.free0014Combo = free0014Combo;
	}

	/**
	 * NF012DTO.javafree0012Comboを設定
	 * @return free0012Combo
	 */
	public LinkedHashMap<String, String> getFree0012Combo() {
		return free0012Combo;
	}

	/**
	 * @param free0012Combo セットする free0012Combo
	 */
	public void setFree0012Combo(LinkedHashMap<String, String> free0012Combo) {
		this.free0012Combo = free0012Combo;
	}

	/**
	 * NF012DTO.javacapaTypeComboを設定
	 * @return capaTypeCombo
	 */
	public LinkedHashMap<String, String> getCapaTypeCombo() {
		return capaTypeCombo;
	}

	/**
	 * @param capaTypeCombo セットする capaTypeCombo
	 */
	public void setCapaTypeCombo(LinkedHashMap<String, String> capaTypeCombo) {
		this.capaTypeCombo = capaTypeCombo;
	}

	/**
	 * NF012DTO.javawelfare02Comboを設定
	 * @return welfare02Combo
	 */
	public LinkedHashMap<String, String> getWelfare02Combo() {
		return welfare02Combo;
	}

	/**
	 * @param welfare02Combo セットする welfare02Combo
	 */
	public void setWelfare02Combo(LinkedHashMap<String, String> welfare02Combo) {
		this.welfare02Combo = welfare02Combo;
	}

	/**
	 * NF012DTO.javawelfare08Comboを設定
	 * @return welfare08Combo
	 */
	public LinkedHashMap<String, String> getWelfare08Combo() {
		return welfare08Combo;
	}

	/**
	 * @param welfare08Combo セットする welfare08Combo
	 */
	public void setWelfare08Combo(LinkedHashMap<String, String> welfare08Combo) {
		this.welfare08Combo = welfare08Combo;
	}

	/**
	 * NF012DTO.javaresult01Comboを設定
	 * @return result01Combo
	 */
	public LinkedHashMap<String, String> getResult01Combo() {
		return result01Combo;
	}

	/**
	 * @param result01Combo セットする result01Combo
	 */
	public void setResult01Combo(LinkedHashMap<String, String> result01Combo) {
		this.result01Combo = result01Combo;
	}

	/**
	 * NF012DTO.javaresult02Comboを設定
	 * @return result02Combo
	 */
	public LinkedHashMap<String, String> getResult02Combo() {
		return result02Combo;
	}

	/**
	 * @param result02Combo セットする result02Combo
	 */
	public void setResult02Combo(LinkedHashMap<String, String> result02Combo) {
		this.result02Combo = result02Combo;
	}

	/**
	 * NF012DTO.javaresult03Comboを設定
	 * @return result03Combo
	 */
	public LinkedHashMap<String, String> getResult03Combo() {
		return result03Combo;
	}

	/**
	 * @param result03Combo セットする result03Combo
	 */
	public void setResult03Combo(LinkedHashMap<String, String> result03Combo) {
		this.result03Combo = result03Combo;
	}

	/**
	 * NF012DTO.javaresult04Comboを設定
	 * @return result04Combo
	 */
	public LinkedHashMap<String, String> getResult04Combo() {
		return result04Combo;
	}

	/**
	 * @param result04Combo セットする result04Combo
	 */
	public void setResult04Combo(LinkedHashMap<String, String> result04Combo) {
		this.result04Combo = result04Combo;
	}

	/**
	 * NF012DTO.javaresult05Comboを設定
	 * @return result05Combo
	 */
	public LinkedHashMap<String, String> getResult05Combo() {
		return result05Combo;
	}

	/**
	 * @param result05Combo セットする result05Combo
	 */
	public void setResult05Combo(LinkedHashMap<String, String> result05Combo) {
		this.result05Combo = result05Combo;
	}

	/**
	 * NF012DTO.javaresult06Comboを設定
	 * @return result06Combo
	 */
	public LinkedHashMap<String, String> getResult06Combo() {
		return result06Combo;
	}

	/**
	 * @param result06Combo セットする result06Combo
	 */
	public void setResult06Combo(LinkedHashMap<String, String> result06Combo) {
		this.result06Combo = result06Combo;
	}

	/**
	 * NF012DTO.javaresult07Comboを設定
	 * @return result07Combo
	 */
	public LinkedHashMap<String, String> getResult07Combo() {
		return result07Combo;
	}

	/**
	 * @param result07Combo セットする result07Combo
	 */
	public void setResult07Combo(LinkedHashMap<String, String> result07Combo) {
		this.result07Combo = result07Combo;
	}

	/**
	 * NF012DTO.javaresult08Comboを設定
	 * @return result08Combo
	 */
	public LinkedHashMap<String, String> getResult08Combo() {
		return result08Combo;
	}

	/**
	 * @param result08Combo セットする result08Combo
	 */
	public void setResult08Combo(LinkedHashMap<String, String> result08Combo) {
		this.result08Combo = result08Combo;
	}

	/**
	 * NF012DTO.javaresult09Comboを設定
	 * @return result09Combo
	 */
	public LinkedHashMap<String, String> getResult09Combo() {
		return result09Combo;
	}

	/**
	 * @param result09Combo セットする result09Combo
	 */
	public void setResult09Combo(LinkedHashMap<String, String> result09Combo) {
		this.result09Combo = result09Combo;
	}

	/**
	 * NF012DTO.javaresult10Comboを設定
	 * @return result10Combo
	 */
	public LinkedHashMap<String, String> getResult10Combo() {
		return result10Combo;
	}

	/**
	 * @param result10Combo セットする result10Combo
	 */
	public void setResult10Combo(LinkedHashMap<String, String> result10Combo) {
		this.result10Combo = result10Combo;
	}

	/**
	 * NF012DTO.javaresult11Comboを設定
	 * @return result11Combo
	 */
	public LinkedHashMap<String, String> getResult11Combo() {
		return result11Combo;
	}

	/**
	 * @param result11Combo セットする result11Combo
	 */
	public void setResult11Combo(LinkedHashMap<String, String> result11Combo) {
		this.result11Combo = result11Combo;
	}

	/**
	 * NF012DTO.javaresult12Comboを設定
	 * @return result12Combo
	 */
	public LinkedHashMap<String, String> getResult12Combo() {
		return result12Combo;
	}

	/**
	 * @param result12Combo セットする result12Combo
	 */
	public void setResult12Combo(LinkedHashMap<String, String> result12Combo) {
		this.result12Combo = result12Combo;
	}

	/**
	 * NF012DTO.javaresult13Comboを設定
	 * @return result13Combo
	 */
	public LinkedHashMap<String, String> getResult13Combo() {
		return result13Combo;
	}

	/**
	 * @param result13Combo セットする result13Combo
	 */
	public void setResult13Combo(LinkedHashMap<String, String> result13Combo) {
		this.result13Combo = result13Combo;
	}

	/**
	 * NF012DTO.javaresult14Comboを設定
	 * @return result14Combo
	 */
	public LinkedHashMap<String, String> getResult14Combo() {
		return result14Combo;
	}

	/**
	 * @param result14Combo セットする result14Combo
	 */
	public void setResult14Combo(LinkedHashMap<String, String> result14Combo) {
		this.result14Combo = result14Combo;
	}

	/**
	 * NF012DTO.javaresult15Comboを設定
	 * @return result15Combo
	 */
	public LinkedHashMap<String, String> getResult15Combo() {
		return result15Combo;
	}

	/**
	 * @param result15Combo セットする result15Combo
	 */
	public void setResult15Combo(LinkedHashMap<String, String> result15Combo) {
		this.result15Combo = result15Combo;
	}

	/**
	 * NF012DTO.javaresult16Comboを設定
	 * @return result16Combo
	 */
	public LinkedHashMap<String, String> getResult16Combo() {
		return result16Combo;
	}

	/**
	 * @param result16Combo セットする result16Combo
	 */
	public void setResult16Combo(LinkedHashMap<String, String> result16Combo) {
		this.result16Combo = result16Combo;
	}

	/**
	 * NF012DTO.javaresult17Comboを設定
	 * @return result17Combo
	 */
	public LinkedHashMap<String, String> getResult17Combo() {
		return result17Combo;
	}

	/**
	 * @param result17Combo セットする result17Combo
	 */
	public void setResult17Combo(LinkedHashMap<String, String> result17Combo) {
		this.result17Combo = result17Combo;
	}

	/**
	 * NF012DTO.javaresult18Comboを設定
	 * @return result18Combo
	 */
	public LinkedHashMap<String, String> getResult18Combo() {
		return result18Combo;
	}

	/**
	 * @param result18Combo セットする result18Combo
	 */
	public void setResult18Combo(LinkedHashMap<String, String> result18Combo) {
		this.result18Combo = result18Combo;
	}

	/**
	 * NF012DTO.javaresult19Comboを設定
	 * @return result19Combo
	 */
	public LinkedHashMap<String, String> getResult19Combo() {
		return result19Combo;
	}

	/**
	 * @param result19Combo セットする result19Combo
	 */
	public void setResult19Combo(LinkedHashMap<String, String> result19Combo) {
		this.result19Combo = result19Combo;
	}

	/**
	 * NF012DTO.javaresult20Comboを設定
	 * @return result20Combo
	 */
	public LinkedHashMap<String, String> getResult20Combo() {
		return result20Combo;
	}

	/**
	 * @param result20Combo セットする result20Combo
	 */
	public void setResult20Combo(LinkedHashMap<String, String> result20Combo) {
		this.result20Combo = result20Combo;
	}

	/**
	 * NF012DTO.javaresult21Comboを設定
	 * @return result21Combo
	 */
	public LinkedHashMap<String, String> getResult21Combo() {
		return result21Combo;
	}

	/**
	 * @param result21Combo セットする result21Combo
	 */
	public void setResult21Combo(LinkedHashMap<String, String> result21Combo) {
		this.result21Combo = result21Combo;
	}

	/**
	 * NF012DTO.javaresult22Comboを設定
	 * @return result22Combo
	 */
	public LinkedHashMap<String, String> getResult22Combo() {
		return result22Combo;
	}

	/**
	 * @param result22Combo セットする result22Combo
	 */
	public void setResult22Combo(LinkedHashMap<String, String> result22Combo) {
		this.result22Combo = result22Combo;
	}

	/**
	 * NF012DTO.javaresult23Comboを設定
	 * @return result23Combo
	 */
	public LinkedHashMap<String, String> getResult23Combo() {
		return result23Combo;
	}

	/**
	 * @param result23Combo セットする result23Combo
	 */
	public void setResult23Combo(LinkedHashMap<String, String> result23Combo) {
		this.result23Combo = result23Combo;
	}

	/**
	 * NF012DTO.javaresult24Comboを設定
	 * @return result24Combo
	 */
	public LinkedHashMap<String, String> getResult24Combo() {
		return result24Combo;
	}

	/**
	 * @param result24Combo セットする result24Combo
	 */
	public void setResult24Combo(LinkedHashMap<String, String> result24Combo) {
		this.result24Combo = result24Combo;
	}

	/**
	 * NF012DTO.javaresult25Comboを設定
	 * @return result25Combo
	 */
	public LinkedHashMap<String, String> getResult25Combo() {
		return result25Combo;
	}

	/**
	 * @param result25Combo セットする result25Combo
	 */
	public void setResult25Combo(LinkedHashMap<String, String> result25Combo) {
		this.result25Combo = result25Combo;
	}

	/**
	 * NF012DTO.javaresult26Comboを設定
	 * @return result26Combo
	 */
	public LinkedHashMap<String, String> getResult26Combo() {
		return result26Combo;
	}

	/**
	 * @param result26Combo セットする result26Combo
	 */
	public void setResult26Combo(LinkedHashMap<String, String> result26Combo) {
		this.result26Combo = result26Combo;
	}

	/**
	 * NF012DTO.javaresult27Comboを設定
	 * @return result27Combo
	 */
	public LinkedHashMap<String, String> getResult27Combo() {
		return result27Combo;
	}

	/**
	 * @param result27Combo セットする result27Combo
	 */
	public void setResult27Combo(LinkedHashMap<String, String> result27Combo) {
		this.result27Combo = result27Combo;
	}

	/**
	 * NF012DTO.javaresult28Comboを設定
	 * @return result28Combo
	 */
	public LinkedHashMap<String, String> getResult28Combo() {
		return result28Combo;
	}

	/**
	 * @param result28Combo セットする result28Combo
	 */
	public void setResult28Combo(LinkedHashMap<String, String> result28Combo) {
		this.result28Combo = result28Combo;
	}

	/**
	 * NF012DTO.javaresult29Comboを設定
	 * @return result29Combo
	 */
	public LinkedHashMap<String, String> getResult29Combo() {
		return result29Combo;
	}

	/**
	 * @param result29Combo セットする result29Combo
	 */
	public void setResult29Combo(LinkedHashMap<String, String> result29Combo) {
		this.result29Combo = result29Combo;
	}

	/**
	 * NF012DTO.javaresult30Comboを設定
	 * @return result30Combo
	 */
	public LinkedHashMap<String, String> getResult30Combo() {
		return result30Combo;
	}

	/**
	 * @param result30Combo セットする result30Combo
	 */
	public void setResult30Combo(LinkedHashMap<String, String> result30Combo) {
		this.result30Combo = result30Combo;
	}

	/**
	 * NF012DTO.javaresult31Comboを設定
	 * @return result31Combo
	 */
	public LinkedHashMap<String, String> getResult31Combo() {
		return result31Combo;
	}

	/**
	 * @param result31Combo セットする result31Combo
	 */
	public void setResult31Combo(LinkedHashMap<String, String> result31Combo) {
		this.result31Combo = result31Combo;
	}

	/**
	 * NF012DTO.javaresult32Comboを設定
	 * @return result32Combo
	 */
	public LinkedHashMap<String, String> getResult32Combo() {
		return result32Combo;
	}

	/**
	 * @param result32Combo セットする result32Combo
	 */
	public void setResult32Combo(LinkedHashMap<String, String> result32Combo) {
		this.result32Combo = result32Combo;
	}

	/**
	 * NF012DTO.javaresult33Comboを設定
	 * @return result33Combo
	 */
	public LinkedHashMap<String, String> getResult33Combo() {
		return result33Combo;
	}

	/**
	 * @param result33Combo セットする result33Combo
	 */
	public void setResult33Combo(LinkedHashMap<String, String> result33Combo) {
		this.result33Combo = result33Combo;
	}

	/**
	 * NF012DTO.javaresult34Comboを設定
	 * @return result34Combo
	 */
	public LinkedHashMap<String, String> getResult34Combo() {
		return result34Combo;
	}

	/**
	 * @param result34Combo セットする result34Combo
	 */
	public void setResult34Combo(LinkedHashMap<String, String> result34Combo) {
		this.result34Combo = result34Combo;
	}

	/**
	 * NF012DTO.javaresult35Comboを設定
	 * @return result35Combo
	 */
	public LinkedHashMap<String, String> getResult35Combo() {
		return result35Combo;
	}

	/**
	 * @param result35Combo セットする result35Combo
	 */
	public void setResult35Combo(LinkedHashMap<String, String> result35Combo) {
		this.result35Combo = result35Combo;
	}

	/**
	 * NF012DTO.javaresult36Comboを設定
	 * @return result36Combo
	 */
	public LinkedHashMap<String, String> getResult36Combo() {
		return result36Combo;
	}

	/**
	 * @param result36Combo セットする result36Combo
	 */
	public void setResult36Combo(LinkedHashMap<String, String> result36Combo) {
		this.result36Combo = result36Combo;
	}

	/**
	 * NF012DTO.javaequip01Comboを設定
	 * @return equip01Combo
	 */
	public LinkedHashMap<String, String> getEquip01Combo() {
		return equip01Combo;
	}

	/**
	 * @param equip01Combo セットする equip01Combo
	 */
	public void setEquip01Combo(LinkedHashMap<String, String> equip01Combo) {
		this.equip01Combo = equip01Combo;
	}

	/**
	 * NF012DTO.javaequip02Comboを設定
	 * @return equip02Combo
	 */
	public LinkedHashMap<String, String> getEquip02Combo() {
		return equip02Combo;
	}

	/**
	 * @param equip02Combo セットする equip02Combo
	 */
	public void setEquip02Combo(LinkedHashMap<String, String> equip02Combo) {
		this.equip02Combo = equip02Combo;
	}

	/**
	 * NF012DTO.javaequip03Comboを設定
	 * @return equip03Combo
	 */
	public LinkedHashMap<String, String> getEquip03Combo() {
		return equip03Combo;
	}

	/**
	 * @param equip03Combo セットする equip03Combo
	 */
	public void setEquip03Combo(LinkedHashMap<String, String> equip03Combo) {
		this.equip03Combo = equip03Combo;
	}

	/**
	 * NF012DTO.javaequip07Comboを設定
	 * @return equip07Combo
	 */
	public LinkedHashMap<String, String> getEquip07Combo() {
		return equip07Combo;
	}

	/**
	 * @param equip07Combo セットする equip07Combo
	 */
	public void setEquip07Combo(LinkedHashMap<String, String> equip07Combo) {
		this.equip07Combo = equip07Combo;
	}

	/**
	 * NF012DTO.javaequip09Comboを設定
	 * @return equip09Combo
	 */
	public LinkedHashMap<String, String> getEquip09Combo() {
		return equip09Combo;
	}

	/**
	 * @param equip09Combo セットする equip09Combo
	 */
	public void setEquip09Combo(LinkedHashMap<String, String> equip09Combo) {
		this.equip09Combo = equip09Combo;
	}

	/**
	 * NF012DTO.javamarket01Comboを設定
	 * @return market01Combo
	 */
	public LinkedHashMap<String, String> getMarket01Combo() {
		return market01Combo;
	}

	/**
	 * @param market01Combo セットする market01Combo
	 */
	public void setMarket01Combo(LinkedHashMap<String, String> market01Combo) {
		this.market01Combo = market01Combo;
	}

	/**
	 * NF012DTO.javamarket02Comboを設定
	 * @return market02Combo
	 */
	public LinkedHashMap<String, String> getMarket02Combo() {
		return market02Combo;
	}

	/**
	 * @param market02Combo セットする market02Combo
	 */
	public void setMarket02Combo(LinkedHashMap<String, String> market02Combo) {
		this.market02Combo = market02Combo;
	}

	/**
	 * NF012DTO.javamarket03Comboを設定
	 * @return market03Combo
	 */
	public LinkedHashMap<String, String> getMarket03Combo() {
		return market03Combo;
	}

	/**
	 * @param market03Combo セットする market03Combo
	 */
	public void setMarket03Combo(LinkedHashMap<String, String> market03Combo) {
		this.market03Combo = market03Combo;
	}

	/**
	 * NF012DTO.javamarket04Comboを設定
	 * @return market04Combo
	 */
	public LinkedHashMap<String, String> getMarket04Combo() {
		return market04Combo;
	}

	/**
	 * @param market04Combo セットする market04Combo
	 */
	public void setMarket04Combo(LinkedHashMap<String, String> market04Combo) {
		this.market04Combo = market04Combo;
	}

	/**
	 * NF012DTO.javamarket06Comboを設定
	 * @return market06Combo
	 */
	public LinkedHashMap<String, String> getMarket06Combo() {
		return market06Combo;
	}

	/**
	 * @param market06Combo セットする market06Combo
	 */
	public void setMarket06Combo(LinkedHashMap<String, String> market06Combo) {
		this.market06Combo = market06Combo;
	}

	/**
	 * NF012DTO.javamarket07Comboを設定
	 * @return market07Combo
	 */
	public LinkedHashMap<String, String> getMarket07Combo() {
		return market07Combo;
	}

	/**
	 * @param market07Combo セットする market07Combo
	 */
	public void setMarket07Combo(LinkedHashMap<String, String> market07Combo) {
		this.market07Combo = market07Combo;
	}

	/**
	 * NF012DTO.javamarket09Comboを設定
	 * @return market09Combo
	 */
	public LinkedHashMap<String, String> getMarket09Combo() {
		return market09Combo;
	}

	/**
	 * @param market09Combo セットする market09Combo
	 */
	public void setMarket09Combo(LinkedHashMap<String, String> market09Combo) {
		this.market09Combo = market09Combo;
	}

	/**
	 * NF012DTO.javamedical12Comboを設定
	 * @return medical12Combo
	 */
	public LinkedHashMap<String, String> getMedical12Combo() {
		return medical12Combo;
	}

	/**
	 * @param medical12Combo セットする medical12Combo
	 */
	public void setMedical12Combo(LinkedHashMap<String, String> medical12Combo) {
		this.medical12Combo = medical12Combo;
	}

	/**
	 * NF012DTO.javaspfunc01Comboを設定
	 * @return spfunc01Combo
	 */
	public LinkedHashMap<String, String> getSpfunc01Combo() {
		return spfunc01Combo;
	}

	/**
	 * @param spfunc01Combo セットする spfunc01Combo
	 */
	public void setSpfunc01Combo(LinkedHashMap<String, String> spfunc01Combo) {
		this.spfunc01Combo = spfunc01Combo;
	}

	/**
	 * NF012DTO.javaspfunc03Comboを設定
	 * @return spfunc03Combo
	 */
	public LinkedHashMap<String, String> getSpfunc03Combo() {
		return spfunc03Combo;
	}

	/**
	 * @param spfunc03Combo セットする spfunc03Combo
	 */
	public void setSpfunc03Combo(LinkedHashMap<String, String> spfunc03Combo) {
		this.spfunc03Combo = spfunc03Combo;
	}

	/**
	 * NF012DTO.javaspfunc04Comboを設定
	 * @return spfunc04Combo
	 */
	public LinkedHashMap<String, String> getSpfunc04Combo() {
		return spfunc04Combo;
	}

	/**
	 * @param spfunc04Combo セットする spfunc04Combo
	 */
	public void setSpfunc04Combo(LinkedHashMap<String, String> spfunc04Combo) {
		this.spfunc04Combo = spfunc04Combo;
	}

	/**
	 * NF012DTO.javatieup10Comboを設定
	 * @return tieup10Combo
	 */
	public LinkedHashMap<String, String> getTieup10Combo() {
		return tieup10Combo;
	}

	/**
	 * @param tieup10Combo セットする tieup10Combo
	 */
	public void setTieup10Combo(LinkedHashMap<String, String> tieup10Combo) {
		this.tieup10Combo = tieup10Combo;
	}

	/**
	 * NF012DTO.javatieup11Comboを設定
	 * @return tieup11Combo
	 */
	public LinkedHashMap<String, String> getTieup11Combo() {
		return tieup11Combo;
	}

	/**
	 * @param tieup11Combo セットする tieup11Combo
	 */
	public void setTieup11Combo(LinkedHashMap<String, String> tieup11Combo) {
		this.tieup11Combo = tieup11Combo;
	}

	/**
	 * NF012DTO.javatieup12Comboを設定
	 * @return tieup12Combo
	 */
	public LinkedHashMap<String, String> getTieup12Combo() {
		return tieup12Combo;
	}

	/**
	 * @param tieup12Combo セットする tieup12Combo
	 */
	public void setTieup12Combo(LinkedHashMap<String, String> tieup12Combo) {
		this.tieup12Combo = tieup12Combo;
	}

	/**
	 * NF012DTO.javausercd0001Comboを設定
	 * @return usercd0001Combo
	 */
	public LinkedHashMap<String, String> getUsercd0001Combo() {
		return usercd0001Combo;
	}

	/**
	 * @param usercd0001Combo セットする usercd0001Combo
	 */
	public void setUsercd0001Combo(LinkedHashMap<String, String> usercd0001Combo) {
		this.usercd0001Combo = usercd0001Combo;
	}

	/**
	 * NF012DTO.javausercd0002Comboを設定
	 * @return usercd0002Combo
	 */
	public LinkedHashMap<String, String> getUsercd0002Combo() {
		return usercd0002Combo;
	}

	/**
	 * @param usercd0002Combo セットする usercd0002Combo
	 */
	public void setUsercd0002Combo(LinkedHashMap<String, String> usercd0002Combo) {
		this.usercd0002Combo = usercd0002Combo;
	}

	/**
	 * NF012DTO.javausercd0003Comboを設定
	 * @return usercd0003Combo
	 */
	public LinkedHashMap<String, String> getUsercd0003Combo() {
		return usercd0003Combo;
	}

	/**
	 * @param usercd0003Combo セットする usercd0003Combo
	 */
	public void setUsercd0003Combo(LinkedHashMap<String, String> usercd0003Combo) {
		this.usercd0003Combo = usercd0003Combo;
	}

	/**
	 * NF012DTO.javausercd0004Comboを設定
	 * @return usercd0004Combo
	 */
	public LinkedHashMap<String, String> getUsercd0004Combo() {
		return usercd0004Combo;
	}

	/**
	 * @param usercd0004Combo セットする usercd0004Combo
	 */
	public void setUsercd0004Combo(LinkedHashMap<String, String> usercd0004Combo) {
		this.usercd0004Combo = usercd0004Combo;
	}

	/**
	 * NF012DTO.javausercd0005Comboを設定
	 * @return usercd0005Combo
	 */
	public LinkedHashMap<String, String> getUsercd0005Combo() {
		return usercd0005Combo;
	}

	/**
	 * @param usercd0005Combo セットする usercd0005Combo
	 */
	public void setUsercd0005Combo(LinkedHashMap<String, String> usercd0005Combo) {
		this.usercd0005Combo = usercd0005Combo;
	}

	/**
	 * NF012DTO.javausercd0006Comboを設定
	 * @return usercd0006Combo
	 */
	public LinkedHashMap<String, String> getUsercd0006Combo() {
		return usercd0006Combo;
	}

	/**
	 * @param usercd0006Combo セットする usercd0006Combo
	 */
	public void setUsercd0006Combo(LinkedHashMap<String, String> usercd0006Combo) {
		this.usercd0006Combo = usercd0006Combo;
	}

	/**
	 * NF012DTO.javausercd0007Comboを設定
	 * @return usercd0007Combo
	 */
	public LinkedHashMap<String, String> getUsercd0007Combo() {
		return usercd0007Combo;
	}

	/**
	 * @param usercd0007Combo セットする usercd0007Combo
	 */
	public void setUsercd0007Combo(LinkedHashMap<String, String> usercd0007Combo) {
		this.usercd0007Combo = usercd0007Combo;
	}

	/**
	 * NF012DTO.javausercd0008Comboを設定
	 * @return usercd0008Combo
	 */
	public LinkedHashMap<String, String> getUsercd0008Combo() {
		return usercd0008Combo;
	}

	/**
	 * @param usercd0008Combo セットする usercd0008Combo
	 */
	public void setUsercd0008Combo(LinkedHashMap<String, String> usercd0008Combo) {
		this.usercd0008Combo = usercd0008Combo;
	}

	/**
	 * NF012DTO.javausercd0009Comboを設定
	 * @return usercd0009Combo
	 */
	public LinkedHashMap<String, String> getUsercd0009Combo() {
		return usercd0009Combo;
	}

	/**
	 * @param usercd0009Combo セットする usercd0009Combo
	 */
	public void setUsercd0009Combo(LinkedHashMap<String, String> usercd0009Combo) {
		this.usercd0009Combo = usercd0009Combo;
	}

	/**
	 * NF012DTO.javausercd0010Comboを設定
	 * @return usercd0010Combo
	 */
	public LinkedHashMap<String, String> getUsercd0010Combo() {
		return usercd0010Combo;
	}

	/**
	 * @param usercd0010Combo セットする usercd0010Combo
	 */
	public void setUsercd0010Combo(LinkedHashMap<String, String> usercd0010Combo) {
		this.usercd0010Combo = usercd0010Combo;
	}

	/**
	 * NF012DTO.javausercd0011Comboを設定
	 * @return usercd0011Combo
	 */
	public LinkedHashMap<String, String> getUsercd0011Combo() {
		return usercd0011Combo;
	}

	/**
	 * @param usercd0011Combo セットする usercd0011Combo
	 */
	public void setUsercd0011Combo(LinkedHashMap<String, String> usercd0011Combo) {
		this.usercd0011Combo = usercd0011Combo;
	}

	/**
	 * NF012DTO.javausercd0012Comboを設定
	 * @return usercd0012Combo
	 */
	public LinkedHashMap<String, String> getUsercd0012Combo() {
		return usercd0012Combo;
	}

	/**
	 * @param usercd0012Combo セットする usercd0012Combo
	 */
	public void setUsercd0012Combo(LinkedHashMap<String, String> usercd0012Combo) {
		this.usercd0012Combo = usercd0012Combo;
	}

	/**
	 * NF012DTO.javausercd0013Comboを設定
	 * @return usercd0013Combo
	 */
	public LinkedHashMap<String, String> getUsercd0013Combo() {
		return usercd0013Combo;
	}

	/**
	 * @param usercd0013Combo セットする usercd0013Combo
	 */
	public void setUsercd0013Combo(LinkedHashMap<String, String> usercd0013Combo) {
		this.usercd0013Combo = usercd0013Combo;
	}

	/**
	 * NF012DTO.javausercd0014Comboを設定
	 * @return usercd0014Combo
	 */
	public LinkedHashMap<String, String> getUsercd0014Combo() {
		return usercd0014Combo;
	}

	/**
	 * @param usercd0014Combo セットする usercd0014Combo
	 */
	public void setUsercd0014Combo(LinkedHashMap<String, String> usercd0014Combo) {
		this.usercd0014Combo = usercd0014Combo;
	}

	/**
	 * NF012DTO.javausercd0015Comboを設定
	 * @return usercd0015Combo
	 */
	public LinkedHashMap<String, String> getUsercd0015Combo() {
		return usercd0015Combo;
	}

	/**
	 * @param usercd0015Combo セットする usercd0015Combo
	 */
	public void setUsercd0015Combo(LinkedHashMap<String, String> usercd0015Combo) {
		this.usercd0015Combo = usercd0015Combo;
	}

	/**
	 * NF012DTO.javausercd0016Comboを設定
	 * @return usercd0016Combo
	 */
	public LinkedHashMap<String, String> getUsercd0016Combo() {
		return usercd0016Combo;
	}

	/**
	 * @param usercd0016Combo セットする usercd0016Combo
	 */
	public void setUsercd0016Combo(LinkedHashMap<String, String> usercd0016Combo) {
		this.usercd0016Combo = usercd0016Combo;
	}

	/**
	 * NF012DTO.javausercd0017Comboを設定
	 * @return usercd0017Combo
	 */
	public LinkedHashMap<String, String> getUsercd0017Combo() {
		return usercd0017Combo;
	}

	/**
	 * @param usercd0017Combo セットする usercd0017Combo
	 */
	public void setUsercd0017Combo(LinkedHashMap<String, String> usercd0017Combo) {
		this.usercd0017Combo = usercd0017Combo;
	}

	/**
	 * NF012DTO.javausercd0018Comboを設定
	 * @return usercd0018Combo
	 */
	public LinkedHashMap<String, String> getUsercd0018Combo() {
		return usercd0018Combo;
	}

	/**
	 * @param usercd0018Combo セットする usercd0018Combo
	 */
	public void setUsercd0018Combo(LinkedHashMap<String, String> usercd0018Combo) {
		this.usercd0018Combo = usercd0018Combo;
	}

	/**
	 * NF012DTO.javausercd0019Comboを設定
	 * @return usercd0019Combo
	 */
	public LinkedHashMap<String, String> getUsercd0019Combo() {
		return usercd0019Combo;
	}

	/**
	 * @param usercd0019Combo セットする usercd0019Combo
	 */
	public void setUsercd0019Combo(LinkedHashMap<String, String> usercd0019Combo) {
		this.usercd0019Combo = usercd0019Combo;
	}

	/**
	 * NF012DTO.javausercd0020Comboを設定
	 * @return usercd0020Combo
	 */
	public LinkedHashMap<String, String> getUsercd0020Combo() {
		return usercd0020Combo;
	}

	/**
	 * @param usercd0020Combo セットする usercd0020Combo
	 */
	public void setUsercd0020Combo(LinkedHashMap<String, String> usercd0020Combo) {
		this.usercd0020Combo = usercd0020Combo;
	}

	/**
	 * NF012DTO.javausercd0021Comboを設定
	 * @return usercd0021Combo
	 */
	public LinkedHashMap<String, String> getUsercd0021Combo() {
		return usercd0021Combo;
	}

	/**
	 * @param usercd0021Combo セットする usercd0021Combo
	 */
	public void setUsercd0021Combo(LinkedHashMap<String, String> usercd0021Combo) {
		this.usercd0021Combo = usercd0021Combo;
	}

	/**
	 * NF012DTO.javausercd0022Comboを設定
	 * @return usercd0022Combo
	 */
	public LinkedHashMap<String, String> getUsercd0022Combo() {
		return usercd0022Combo;
	}

	/**
	 * @param usercd0022Combo セットする usercd0022Combo
	 */
	public void setUsercd0022Combo(LinkedHashMap<String, String> usercd0022Combo) {
		this.usercd0022Combo = usercd0022Combo;
	}

	/**
	 * NF012DTO.javausercd0023Comboを設定
	 * @return usercd0023Combo
	 */
	public LinkedHashMap<String, String> getUsercd0023Combo() {
		return usercd0023Combo;
	}

	/**
	 * @param usercd0023Combo セットする usercd0023Combo
	 */
	public void setUsercd0023Combo(LinkedHashMap<String, String> usercd0023Combo) {
		this.usercd0023Combo = usercd0023Combo;
	}

	/**
	 * NF012DTO.javausercd0024Comboを設定
	 * @return usercd0024Combo
	 */
	public LinkedHashMap<String, String> getUsercd0024Combo() {
		return usercd0024Combo;
	}

	/**
	 * @param usercd0024Combo セットする usercd0024Combo
	 */
	public void setUsercd0024Combo(LinkedHashMap<String, String> usercd0024Combo) {
		this.usercd0024Combo = usercd0024Combo;
	}

	/**
	 * NF012DTO.javausercd0025Comboを設定
	 * @return usercd0025Combo
	 */
	public LinkedHashMap<String, String> getUsercd0025Combo() {
		return usercd0025Combo;
	}

	/**
	 * @param usercd0025Combo セットする usercd0025Combo
	 */
	public void setUsercd0025Combo(LinkedHashMap<String, String> usercd0025Combo) {
		this.usercd0025Combo = usercd0025Combo;
	}

	/**
	 * NF012DTO.javausercd0026Comboを設定
	 * @return usercd0026Combo
	 */
	public LinkedHashMap<String, String> getUsercd0026Combo() {
		return usercd0026Combo;
	}

	/**
	 * @param usercd0026Combo セットする usercd0026Combo
	 */
	public void setUsercd0026Combo(LinkedHashMap<String, String> usercd0026Combo) {
		this.usercd0026Combo = usercd0026Combo;
	}

	/**
	 * NF012DTO.javausercd0027Comboを設定
	 * @return usercd0027Combo
	 */
	public LinkedHashMap<String, String> getUsercd0027Combo() {
		return usercd0027Combo;
	}

	/**
	 * @param usercd0027Combo セットする usercd0027Combo
	 */
	public void setUsercd0027Combo(LinkedHashMap<String, String> usercd0027Combo) {
		this.usercd0027Combo = usercd0027Combo;
	}

	/**
	 * NF012DTO.javausercd0028Comboを設定
	 * @return usercd0028Combo
	 */
	public LinkedHashMap<String, String> getUsercd0028Combo() {
		return usercd0028Combo;
	}

	/**
	 * @param usercd0028Combo セットする usercd0028Combo
	 */
	public void setUsercd0028Combo(LinkedHashMap<String, String> usercd0028Combo) {
		this.usercd0028Combo = usercd0028Combo;
	}

	/**
	 * NF012DTO.javausercd0029Comboを設定
	 * @return usercd0029Combo
	 */
	public LinkedHashMap<String, String> getUsercd0029Combo() {
		return usercd0029Combo;
	}

	/**
	 * @param usercd0029Combo セットする usercd0029Combo
	 */
	public void setUsercd0029Combo(LinkedHashMap<String, String> usercd0029Combo) {
		this.usercd0029Combo = usercd0029Combo;
	}

	/**
	 * NF012DTO.javausercd0030Comboを設定
	 * @return usercd0030Combo
	 */
	public LinkedHashMap<String, String> getUsercd0030Combo() {
		return usercd0030Combo;
	}

	/**
	 * @param usercd0030Combo セットする usercd0030Combo
	 */
	public void setUsercd0030Combo(LinkedHashMap<String, String> usercd0030Combo) {
		this.usercd0030Combo = usercd0030Combo;
	}

	/**
	 * NF012DTO.javausercd0031Comboを設定
	 * @return usercd0031Combo
	 */
	public LinkedHashMap<String, String> getUsercd0031Combo() {
		return usercd0031Combo;
	}

	/**
	 * @param usercd0031Combo セットする usercd0031Combo
	 */
	public void setUsercd0031Combo(LinkedHashMap<String, String> usercd0031Combo) {
		this.usercd0031Combo = usercd0031Combo;
	}

	/**
	 * NF012DTO.javausercd0032Comboを設定
	 * @return usercd0032Combo
	 */
	public LinkedHashMap<String, String> getUsercd0032Combo() {
		return usercd0032Combo;
	}

	/**
	 * @param usercd0032Combo セットする usercd0032Combo
	 */
	public void setUsercd0032Combo(LinkedHashMap<String, String> usercd0032Combo) {
		this.usercd0032Combo = usercd0032Combo;
	}

	/**
	 * NF012DTO.javausercd0033Comboを設定
	 * @return usercd0033Combo
	 */
	public LinkedHashMap<String, String> getUsercd0033Combo() {
		return usercd0033Combo;
	}

	/**
	 * @param usercd0033Combo セットする usercd0033Combo
	 */
	public void setUsercd0033Combo(LinkedHashMap<String, String> usercd0033Combo) {
		this.usercd0033Combo = usercd0033Combo;
	}

	/**
	 * NF012DTO.javausercd0034Comboを設定
	 * @return usercd0034Combo
	 */
	public LinkedHashMap<String, String> getUsercd0034Combo() {
		return usercd0034Combo;
	}

	/**
	 * @param usercd0034Combo セットする usercd0034Combo
	 */
	public void setUsercd0034Combo(LinkedHashMap<String, String> usercd0034Combo) {
		this.usercd0034Combo = usercd0034Combo;
	}

	/**
	 * NF012DTO.javausercd0035Comboを設定
	 * @return usercd0035Combo
	 */
	public LinkedHashMap<String, String> getUsercd0035Combo() {
		return usercd0035Combo;
	}

	/**
	 * @param usercd0035Combo セットする usercd0035Combo
	 */
	public void setUsercd0035Combo(LinkedHashMap<String, String> usercd0035Combo) {
		this.usercd0035Combo = usercd0035Combo;
	}

	/**
	 * NF012DTO.javausercd0036Comboを設定
	 * @return usercd0036Combo
	 */
	public LinkedHashMap<String, String> getUsercd0036Combo() {
		return usercd0036Combo;
	}

	/**
	 * @param usercd0036Combo セットする usercd0036Combo
	 */
	public void setUsercd0036Combo(LinkedHashMap<String, String> usercd0036Combo) {
		this.usercd0036Combo = usercd0036Combo;
	}

	/**
	 * NF012DTO.javareward04Comboを設定
	 * @return reward04Combo
	 */
	public LinkedHashMap<String, String> getReward04Combo() {
		return reward04Combo;
	}

	/**
	 * @param reward04Combo セットする reward04Combo
	 */
	public void setReward04Combo(LinkedHashMap<String, String> reward04Combo) {
		this.reward04Combo = reward04Combo;
	}

	/**
	 * NF012DTO.javareward05Comboを設定
	 * @return reward05Combo
	 */
	public LinkedHashMap<String, String> getReward05Combo() {
		return reward05Combo;
	}

	/**
	 * @param reward05Combo セットする reward05Combo
	 */
	public void setReward05Combo(LinkedHashMap<String, String> reward05Combo) {
		this.reward05Combo = reward05Combo;
	}

	/**
	 * NF012DTO.javareward08Comboを設定
	 * @return reward08Combo
	 */
	public LinkedHashMap<String, String> getReward08Combo() {
		return reward08Combo;
	}

	/**
	 * @param reward08Combo セットする reward08Combo
	 */
	public void setReward08Combo(LinkedHashMap<String, String> reward08Combo) {
		this.reward08Combo = reward08Combo;
	}

	/**
	 * NF012DTO.javareward09Comboを設定
	 * @return reward09Combo
	 */
	public LinkedHashMap<String, String> getReward09Combo() {
		return reward09Combo;
	}

	/**
	 * @param reward09Combo セットする reward09Combo
	 */
	public void setReward09Combo(LinkedHashMap<String, String> reward09Combo) {
		this.reward09Combo = reward09Combo;
	}

	/**
	 * NF012DTO.javareward18Comboを設定
	 * @return reward18Combo
	 */
	public LinkedHashMap<String, String> getReward18Combo() {
		return reward18Combo;
	}

	/**
	 * @param reward18Combo セットする reward18Combo
	 */
	public void setReward18Combo(LinkedHashMap<String, String> reward18Combo) {
		this.reward18Combo = reward18Combo;
	}

	/**
	 * NF012DTO.javareward21Comboを設定
	 * @return reward21Combo
	 */
	public LinkedHashMap<String, String> getReward21Combo() {
		return reward21Combo;
	}

	/**
	 * @param reward21Combo セットする reward21Combo
	 */
	public void setReward21Combo(LinkedHashMap<String, String> reward21Combo) {
		this.reward21Combo = reward21Combo;
	}

	/**
	 * NF012DTO.javareward23Comboを設定
	 * @return reward23Combo
	 */
	public LinkedHashMap<String, String> getReward23Combo() {
		return reward23Combo;
	}

	/**
	 * @param reward23Combo セットする reward23Combo
	 */
	public void setReward23Combo(LinkedHashMap<String, String> reward23Combo) {
		this.reward23Combo = reward23Combo;
	}

	/**
	 * NF012DTO.javareward25Comboを設定
	 * @return reward25Combo
	 */
	public LinkedHashMap<String, String> getReward25Combo() {
		return reward25Combo;
	}

	/**
	 * @param reward25Combo セットする reward25Combo
	 */
	public void setReward25Combo(LinkedHashMap<String, String> reward25Combo) {
		this.reward25Combo = reward25Combo;
	}

	/**
	 * NF012DTO.javareward26Comboを設定
	 * @return reward26Combo
	 */
	public LinkedHashMap<String, String> getReward26Combo() {
		return reward26Combo;
	}

	/**
	 * @param reward26Combo セットする reward26Combo
	 */
	public void setReward26Combo(LinkedHashMap<String, String> reward26Combo) {
		this.reward26Combo = reward26Combo;
	}

	/**
	 * NF012DTO.javareward27Comboを設定
	 * @return reward27Combo
	 */
	public LinkedHashMap<String, String> getReward27Combo() {
		return reward27Combo;
	}

	/**
	 * @param reward27Combo セットする reward27Combo
	 */
	public void setReward27Combo(LinkedHashMap<String, String> reward27Combo) {
		this.reward27Combo = reward27Combo;
	}

	/**
	 * NF012DTO.javareward29Comboを設定
	 * @return reward29Combo
	 */
	public LinkedHashMap<String, String> getReward29Combo() {
		return reward29Combo;
	}

	/**
	 * @param reward29Combo セットする reward29Combo
	 */
	public void setReward29Combo(LinkedHashMap<String, String> reward29Combo) {
		this.reward29Combo = reward29Combo;
	}

	/**
	 * NF012DTO.javareward35Comboを設定
	 * @return reward35Combo
	 */
	public LinkedHashMap<String, String> getReward35Combo() {
		return reward35Combo;
	}

	/**
	 * @param reward35Combo セットする reward35Combo
	 */
	public void setReward35Combo(LinkedHashMap<String, String> reward35Combo) {
		this.reward35Combo = reward35Combo;
	}

	/**
	 * NF012DTO.javareward36Comboを設定
	 * @return reward36Combo
	 */
	public LinkedHashMap<String, String> getReward36Combo() {
		return reward36Combo;
	}

	/**
	 * @param reward36Combo セットする reward36Combo
	 */
	public void setReward36Combo(LinkedHashMap<String, String> reward36Combo) {
		this.reward36Combo = reward36Combo;
	}

	/**
	 * NF012DTO.javareward37Comboを設定
	 * @return reward37Combo
	 */
	public LinkedHashMap<String, String> getReward37Combo() {
		return reward37Combo;
	}

	/**
	 * @param reward37Combo セットする reward37Combo
	 */
	public void setReward37Combo(LinkedHashMap<String, String> reward37Combo) {
		this.reward37Combo = reward37Combo;
	}

	/**
	 * NF012DTO.javareward44Comboを設定
	 * @return reward44Combo
	 */
	public LinkedHashMap<String, String> getReward44Combo() {
		return reward44Combo;
	}

	/**
	 * @param reward44Combo セットする reward44Combo
	 */
	public void setReward44Combo(LinkedHashMap<String, String> reward44Combo) {
		this.reward44Combo = reward44Combo;
	}

	/**
	 * NF012DTO.javareward16Comboを設定
	 * @return reward16Combo
	 */
	public LinkedHashMap<String, String> getReward16Combo() {
		return reward16Combo;
	}

	/**
	 * @param reward16Combo セットする reward16Combo
	 */
	public void setReward16Combo(LinkedHashMap<String, String> reward16Combo) {
		this.reward16Combo = reward16Combo;
	}

	/**
	 * NF012DTO.javareward17Comboを設定
	 * @return reward17Combo
	 */
	public LinkedHashMap<String, String> getReward17Combo() {
		return reward17Combo;
	}

	/**
	 * @param reward17Combo セットする reward17Combo
	 */
	public void setReward17Combo(LinkedHashMap<String, String> reward17Combo) {
		this.reward17Combo = reward17Combo;
	}

	/**
	 * NF012DTO.javashnFlgを設定
	 * @return shnFlg
	 */
	public String getShnFlg() {
		return shnFlg;
	}

	/**
	 * @param shnFlg セットする shnFlg
	 */
	public void setShnFlg(String shnFlg) {
		this.shnFlg = shnFlg;
	}

	/**
	 * NF012DTO.javaeditApprFlgを設定
	 * @return editApprFlg
	 */
	public String getEditApprFlg() {
		return editApprFlg;
	}

	/**
	 * @param editApprFlg セットする editApprFlg
	 */
	public void setEditApprFlg(String editApprFlg) {
		this.editApprFlg = editApprFlg;
	}

	/**
	 * NF012DTO.javamsgStrを設定
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
	 * このDTOの値を返す
	 * @return DTOの値
	 * @generated
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
