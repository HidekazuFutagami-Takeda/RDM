/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2014, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.entity.join;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import jp.co.takeda.rdm.common.BaseEntity;

/**
 * Entityクラス
 * テーブル物理名 : T_RDM_HCO_REQ
 * テーブル論理名 : 施設_申請管理
 * @generated
 */
public class TRdmHcoReqEntity extends BaseEntity implements Serializable {

    /**
     * シリアルバージョンUID
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 申請ID
     * @generated
     */
    private String reqId;
    private boolean reqIdNullFlag;

    /**
     * 施設固定コード
     * @generated
     */
    private String insNo;
    private boolean insNoNullFlag;

    /**
     * 施設分類
     * @generated
     */
    private String insClass;
    private boolean insClassNullFlag;

    /**
     * 施設種別
     * @generated
     */
    private String insSbt;
    private boolean insSbtNullFlag;

    /**
     * 施設カナ名
     * @generated
     */
    private String insKana;
    private boolean insKanaNullFlag;

    /**
     * 施設略式漢字名
     * @generated
     */
    private String insAbbrName;
    private boolean insAbbrNameNullFlag;

    /**
     * 施設正式漢字名
     * @generated
     */
    private String insFormalName;
    private boolean insFormalNameNullFlag;

    /**
     * 契約用正式漢字名
     * @generated
     */
    private String insContName;
    private boolean insContNameNullFlag;

    /**
     * 郵便番号
     * @generated
     */
    private String insPcode;
    private boolean insPcodeNullFlag;

    /**
     * JIS府県コード
     * @generated
     */
    private String addrCodePref;
    private boolean addrCodePrefNullFlag;

    /**
     * JIS市区町村コード
     * @generated
     */
    private String addrCodeCity;
    private boolean addrCodeCityNullFlag;

    /**
     * 武田市区郡コード
     * @generated
     */
    private String tkCityCd;
    private boolean tkCityCdNullFlag;

    /**
     * 町名地番
     * @generated
     */
    private String insAddrDt;
    private boolean insAddrDtNullFlag;

    /**
     * 施設住所（漢字）
     * @generated
     */
    private String insAddr;
    private boolean insAddrNullFlag;

    /**
     * 施設住所（カナ）
     * @generated
     */
    private String insAddrKana;
    private boolean insAddrKanaNullFlag;

    /**
     * 電話番号1
     * @generated
     */
    private String insPhone1;
    private boolean insPhone1NullFlag;

    /**
     * FAX番号1
     * @generated
     */
    private String insFax1;
    private boolean insFax1NullFlag;

    /**
     * 電話番号2
     * @generated
     */
    private String insPhone2;
    private boolean insPhone2NullFlag;

    /**
     * FAX番号2
     * @generated
     */
    private String insFax2;
    private boolean insFax2NullFlag;

    /**
     * ホームページアドレス
     * @generated
     */
    private String insUrl;
    private boolean insUrlNullFlag;

    /**
     * ホームページアドレス最終更新日
     * @generated
     */
    private String insUrlYmd;
    private boolean insUrlYmdNullFlag;

    /**
     * 取引区分
     * @generated
     */
    private String tradeType;
    private boolean tradeTypeNullFlag;

    /**
     * 卸色区分
     * @generated
     */
    private String wsType;
    private boolean wsTypeNullFlag;

    /**
     * 本部一括購入
     * @generated
     */
    private String basketPurchase;
    private boolean basketPurchaseNullFlag;

    /**
     * 対象区分
     * @generated
     */
    private String hoInsType;
    private boolean hoInsTypeNullFlag;

    /**
     * 施設区分
     * @generated
     */
    private String pharmType;
    private boolean pharmTypeNullFlag;

    /**
     * 階級区分
     * @generated
     */
    private String insRank;
    private boolean insRankNullFlag;

    /**
     * 経営主体コード
     * @generated
     */
    private String manageCd;
    private boolean manageCdNullFlag;

    /**
     * 定訪先区分
     * @generated
     */
    private String regVisType;
    private boolean regVisTypeNullFlag;

    /**
     * 重点病院区分
     * @generated
     */
    private String impHosType;
    private boolean impHosTypeNullFlag;

    /**
     * 重点対象区分
     * @generated
     */
    private String impInsType;
    private boolean impInsTypeNullFlag;

    /**
     * 大学細分類
     * @generated
     */
    private String univSubdiv;
    private boolean univSubdivNullFlag;

    /**
     * 開業年
     * @generated
     */
    private String insOpenYear;
    private boolean insOpenYearNullFlag;

    /**
     * 開業月
     * @generated
     */
    private String insOpenMonth;
    private boolean insOpenMonthNullFlag;

    /**
     * 開業日
     * @generated
     */
    private String insOpenDay;
    private boolean insOpenDayNullFlag;

    /**
     * 救急指定病院区分
     * @generated
     */
    private String hosEmerg;
    private boolean hosEmergNullFlag;

    /**
     * 容量別実績把握病院区分
     * @generated
     */
    private String capaType;
    private boolean capaTypeNullFlag;

    /**
     * 診療科目
     * @generated
     */
    private String clitemList;
    private boolean clitemListNullFlag;

    /**
     * ワクチン対象区分(当期)
     * @generated
     */
    private String vacInsType;
    private boolean vacInsTypeNullFlag;

    /**
     * ワクチン定訪先区分(当期)
     * @generated
     */
    private String vacVisitType;
    private boolean vacVisitTypeNullFlag;

    /**
     * 病床(基準)
     * @generated
     */
    private String bedcntBase;
    private boolean bedcntBaseNullFlag;

    /**
     * ベッド数計
     * @generated
     */
    private String bedsTot;
    private boolean bedsTotNullFlag;

    /**
     * 医療ベッド数計
     * @generated
     */
    private String medBedsTot;
    private boolean medBedsTotNullFlag;

    /**
     * 入所定員数
     * @generated
     */
    private String entcapaNum;
    private boolean entcapaNumNullFlag;

    /**
     * 親施設コード
     * @generated
     */
    private String mainInsNo;
    private boolean mainInsNoNullFlag;

    /**
     * 特二次店区分
     * @generated
     */
    private String insSecondType;
    private boolean insSecondTypeNullFlag;

    /**
     * ULT施設コード
     * @generated
     */
    private String ultInsNo;
    private boolean ultInsNoNullFlag;

    /**
     * MDM_ID
     * @generated
     */
    private String mdmId;
    private boolean mdmIdNullFlag;

    /**
     * 病床数(一般)
     * @generated
     */
    private String bedcnt01;
    private boolean bedcnt01NullFlag;

    /**
     * 病床数(医療療養)
     * @generated
     */
    private String bedcnt02;
    private boolean bedcnt02NullFlag;

    /**
     * 病床数(精神)
     * @generated
     */
    private String bedcnt03;
    private boolean bedcnt03NullFlag;

    /**
     * 病床数(結核)
     * @generated
     */
    private String bedcnt04;
    private boolean bedcnt04NullFlag;

    /**
     * 病床数(感染症)
     * @generated
     */
    private String bedcnt05;
    private boolean bedcnt05NullFlag;

    /**
     * 病床数(介護療養)
     * @generated
     */
    private String bedcnt06;
    private boolean bedcnt06NullFlag;

    /**
     * 病床数(療養)
     * @generated
     */
    private String bedcnt07;
    private boolean bedcnt07NullFlag;

    /**
     * フリー項目1(A)
     * @generated
     */
    private String free0001;
    private boolean free0001NullFlag;

    /**
     * フリー項目1(B)
     * @generated
     */
    private String free0002;
    private boolean free0002NullFlag;

    /**
     * フリー項目1(C)
     * @generated
     */
    private String free0003;
    private boolean free0003NullFlag;

    /**
     * フリー項目1(D)
     * @generated
     */
    private String free0004;
    private boolean free0004NullFlag;

    /**
     * フリー項目1(E)
     * @generated
     */
    private String free0005;
    private boolean free0005NullFlag;

    /**
     * フリー項目1(F)
     * @generated
     */
    private String free0006;
    private boolean free0006NullFlag;

    /**
     * フリー項目1(G)
     * @generated
     */
    private String free0007;
    private boolean free0007NullFlag;

    /**
     * フリー項目1(H)
     * @generated
     */
    private String free0008;
    private boolean free0008NullFlag;

    /**
     * フリー項目1(I)
     * @generated
     */
    private String free0009;
    private boolean free0009NullFlag;

    /**
     * フリー項目1(J)
     * @generated
     */
    private String free0010;
    private boolean free0010NullFlag;

    /**
     * フリー項目1(K)
     * @generated
     */
    private String free0011;
    private boolean free0011NullFlag;

    /**
     * フリー項目1(L)
     * @generated
     */
    private String free0012;
    private boolean free0012NullFlag;

    /**
     * フリー項目1(M)
     * @generated
     */
    private String free0013;
    private boolean free0013NullFlag;

    /**
     * フリー項目1(N)
     * @generated
     */
    private String free0014;
    private boolean free0014NullFlag;

    /**
     * フリー項目1(O)
     * @generated
     */
    private String free0015;
    private boolean free0015NullFlag;

    /**
     * フリー項目2(A)
     * @generated
     */
    private String free0101;
    private boolean free0101NullFlag;

    /**
     * 老人福祉法施設区分(老人短期入所施設)
     * @generated
     */
    private String welfare02;
    private boolean welfare02NullFlag;

    /**
     * 老人福祉法施設区分(その他)
     * @generated
     */
    private String welfare08;
    private boolean welfare08NullFlag;

    /**
     * 実績把握区分(A)
     * @generated
     */
    private String result01;
    private boolean result01NullFlag;

    /**
     * 実績把握区分(B)
     * @generated
     */
    private String result02;
    private boolean result02NullFlag;

    /**
     * 実績把握区分(C)
     * @generated
     */
    private String result03;
    private boolean result03NullFlag;

    /**
     * 実績把握区分(D)
     * @generated
     */
    private String result04;
    private boolean result04NullFlag;

    /**
     * 実績把握区分(E)
     * @generated
     */
    private String result05;
    private boolean result05NullFlag;

    /**
     * 実績把握区分(F)
     * @generated
     */
    private String result06;
    private boolean result06NullFlag;

    /**
     * 実績把握区分(G)
     * @generated
     */
    private String result07;
    private boolean result07NullFlag;

    /**
     * 実績把握区分(H)
     * @generated
     */
    private String result08;
    private boolean result08NullFlag;

    /**
     * 実績把握区分(I)
     * @generated
     */
    private String result09;
    private boolean result09NullFlag;

    /**
     * 実績把握区分(J)
     * @generated
     */
    private String result10;
    private boolean result10NullFlag;

    /**
     * 実績把握区分(K)
     * @generated
     */
    private String result11;
    private boolean result11NullFlag;

    /**
     * 実績把握区分(L)
     * @generated
     */
    private String result12;
    private boolean result12NullFlag;

    /**
     * 実績把握区分(M)
     * @generated
     */
    private String result13;
    private boolean result13NullFlag;

    /**
     * 実績把握区分(N)
     * @generated
     */
    private String result14;
    private boolean result14NullFlag;

    /**
     * 実績把握区分(O)
     * @generated
     */
    private String result15;
    private boolean result15NullFlag;

    /**
     * 実績把握区分(P)
     * @generated
     */
    private String result16;
    private boolean result16NullFlag;

    /**
     * 実績把握区分(Q)
     * @generated
     */
    private String result17;
    private boolean result17NullFlag;

    /**
     * 実績把握区分(R)
     * @generated
     */
    private String result18;
    private boolean result18NullFlag;

    /**
     * 実績把握区分(S)
     * @generated
     */
    private String result19;
    private boolean result19NullFlag;

    /**
     * 実績把握区分(T)
     * @generated
     */
    private String result20;
    private boolean result20NullFlag;

    /**
     * 実績把握区分(U)
     * @generated
     */
    private String result21;
    private boolean result21NullFlag;

    /**
     * 実績把握区分(V)
     * @generated
     */
    private String result22;
    private boolean result22NullFlag;

    /**
     * 実績把握区分(W)
     * @generated
     */
    private String result23;
    private boolean result23NullFlag;

    /**
     * 実績把握区分(X)
     * @generated
     */
    private String result24;
    private boolean result24NullFlag;

    /**
     * 実績把握区分(Y)
     * @generated
     */
    private String result25;
    private boolean result25NullFlag;

    /**
     * 実績把握区分(Z)
     * @generated
     */
    private String result26;
    private boolean result26NullFlag;

    /**
     * 実績把握区分(1)
     * @generated
     */
    private String result27;
    private boolean result27NullFlag;

    /**
     * 実績把握区分(2)
     * @generated
     */
    private String result28;
    private boolean result28NullFlag;

    /**
     * 実績把握区分(3)
     * @generated
     */
    private String result29;
    private boolean result29NullFlag;

    /**
     * 実績把握区分(4)
     * @generated
     */
    private String result30;
    private boolean result30NullFlag;

    /**
     * 実績把握区分(5)
     * @generated
     */
    private String result31;
    private boolean result31NullFlag;

    /**
     * 実績把握区分(6)
     * @generated
     */
    private String result32;
    private boolean result32NullFlag;

    /**
     * 実績把握区分(7)
     * @generated
     */
    private String result33;
    private boolean result33NullFlag;

    /**
     * 実績把握区分(8)
     * @generated
     */
    private String result34;
    private boolean result34NullFlag;

    /**
     * 実績把握区分(9)
     * @generated
     */
    private String result35;
    private boolean result35NullFlag;

    /**
     * 実績把握区分(10)
     * @generated
     */
    private String result36;
    private boolean result36NullFlag;

    /**
     * 病院設備(内視鏡)
     * @generated
     */
    private String equip01;
    private boolean equip01NullFlag;

    /**
     * 病院設備(骨量測定器)
     * @generated
     */
    private String equip02;
    private boolean equip02NullFlag;

    /**
     * 病院設備(ICD)
     * @generated
     */
    private String equip03;
    private boolean equip03NullFlag;

    /**
     * 病院設備(CCU)
     * @generated
     */
    private String equip07;
    private boolean equip07NullFlag;

    /**
     * 病院設備(NCU)
     * @generated
     */
    private String equip09;
    private boolean equip09NullFlag;

    /**
     * 市場規模(Ｔ先)
     * @generated
     */
    private String market01;
    private boolean market01NullFlag;

    /**
     * 市場規模(酸抑制剤)
     * @generated
     */
    private String market02;
    private boolean market02NullFlag;

    /**
     * 市場規模(高脂血症)
     * @generated
     */
    private String market03;
    private boolean market03NullFlag;

    /**
     * 市場規模(高血圧)
     * @generated
     */
    private String market04;
    private boolean market04NullFlag;

    /**
     * 市場規模(糖尿病)
     * @generated
     */
    private String market06;
    private boolean market06NullFlag;

    /**
     * 市場規模(骨粗鬆症)
     * @generated
     */
    private String market07;
    private boolean market07NullFlag;

    /**
     * 市場規模(予備1)
     * @generated
     */
    private String market09;
    private boolean market09NullFlag;

    /**
     * 医療法区分(社会医療法人)
     * @generated
     */
    private String medical12;
    private boolean medical12NullFlag;

    /**
     * 特別な機能(入院包括化実施病院)
     * @generated
     */
    private String spfunc01;
    private boolean spfunc01NullFlag;

    /**
     * 特別な機能(人間ドック実施)
     * @generated
     */
    private String spfunc02;
    private boolean spfunc02NullFlag;

    /**
     * 特別な機能(救命救急センター)
     * @generated
     */
    private String spfunc03;
    private boolean spfunc03NullFlag;

    /**
     * 特別な機能(大学院大学)
     * @generated
     */
    private String spfunc04;
    private boolean spfunc04NullFlag;

    /**
     * 特別な機能(救急告示診療所区分)
     * @generated
     */
    private String spfunc05;
    private boolean spfunc05NullFlag;

    /**
     * 特別な機能(予備1)
     * @generated
     */
    private String spfunc06;
    private boolean spfunc06NullFlag;

    /**
     * 医療連携関係(医療評価機能)
     * @generated
     */
    private String tieup05;
    private boolean tieup05NullFlag;

    /**
     * 医療連携関係(大腿骨頸部骨折連携パス)
     * @generated
     */
    private String tieup08;
    private boolean tieup08NullFlag;

    /**
     * 医療連携関係(脳卒中連携パス)
     * @generated
     */
    private String tieup09;
    private boolean tieup09NullFlag;

    /**
     * 医療連携関係(がん連携パス)
     * @generated
     */
    private String tieup10;
    private boolean tieup10NullFlag;

    /**
     * 医療連携関係(心疾患連携パス)
     * @generated
     */
    private String tieup11;
    private boolean tieup11NullFlag;

    /**
     * 医療連携関係(糖尿病連携パス)
     * @generated
     */
    private String tieup12;
    private boolean tieup12NullFlag;

    /**
     * 医療連携関係(予備1)
     * @generated
     */
    private String tieup13;
    private boolean tieup13NullFlag;

    /**
     * フリー項目(本部A)
     * @generated
     */
    private String usercd0001;
    private boolean usercd0001NullFlag;

    /**
     * フリー項目(本部B)
     * @generated
     */
    private String usercd0002;
    private boolean usercd0002NullFlag;

    /**
     * フリー項目(本部C)
     * @generated
     */
    private String usercd0003;
    private boolean usercd0003NullFlag;

    /**
     * フリー項目(本部D)
     * @generated
     */
    private String usercd0004;
    private boolean usercd0004NullFlag;

    /**
     * フリー項目(本部E)
     * @generated
     */
    private String usercd0005;
    private boolean usercd0005NullFlag;

    /**
     * フリー項目(本部F)
     * @generated
     */
    private String usercd0006;
    private boolean usercd0006NullFlag;

    /**
     * フリー項目(本部G)
     * @generated
     */
    private String usercd0007;
    private boolean usercd0007NullFlag;

    /**
     * フリー項目(本部H)
     * @generated
     */
    private String usercd0008;
    private boolean usercd0008NullFlag;

    /**
     * フリー項目(本部I)
     * @generated
     */
    private String usercd0009;
    private boolean usercd0009NullFlag;

    /**
     * フリー項目(本部J)
     * @generated
     */
    private String usercd0010;
    private boolean usercd0010NullFlag;

    /**
     * フリー項目(本部K)
     * @generated
     */
    private String usercd0011;
    private boolean usercd0011NullFlag;

    /**
     * フリー項目(本部L)
     * @generated
     */
    private String usercd0012;
    private boolean usercd0012NullFlag;

    /**
     * フリー項目(本部M)
     * @generated
     */
    private String usercd0013;
    private boolean usercd0013NullFlag;

    /**
     * フリー項目(本部N)
     * @generated
     */
    private String usercd0014;
    private boolean usercd0014NullFlag;

    /**
     * フリー項目(本部O)
     * @generated
     */
    private String usercd0015;
    private boolean usercd0015NullFlag;

    /**
     * フリー項目(本部P)
     * @generated
     */
    private String usercd0016;
    private boolean usercd0016NullFlag;

    /**
     * フリー項目(本部Q)
     * @generated
     */
    private String usercd0017;
    private boolean usercd0017NullFlag;

    /**
     * フリー項目(本部R)
     * @generated
     */
    private String usercd0018;
    private boolean usercd0018NullFlag;

    /**
     * フリー項目(本部S)
     * @generated
     */
    private String usercd0019;
    private boolean usercd0019NullFlag;

    /**
     * フリー項目(本部T)
     * @generated
     */
    private String usercd0020;
    private boolean usercd0020NullFlag;

    /**
     * フリー項目(本部U)
     * @generated
     */
    private String usercd0021;
    private boolean usercd0021NullFlag;

    /**
     * フリー項目(本部V)
     * @generated
     */
    private String usercd0022;
    private boolean usercd0022NullFlag;

    /**
     * フリー項目(本部W)
     * @generated
     */
    private String usercd0023;
    private boolean usercd0023NullFlag;

    /**
     * フリー項目(本部X)
     * @generated
     */
    private String usercd0024;
    private boolean usercd0024NullFlag;

    /**
     * フリー項目(本部Y)
     * @generated
     */
    private String usercd0025;
    private boolean usercd0025NullFlag;

    /**
     * フリー項目(本部Z)
     * @generated
     */
    private String usercd0026;
    private boolean usercd0026NullFlag;

    /**
     * フリー項目(本部1)
     * @generated
     */
    private String usercd0027;
    private boolean usercd0027NullFlag;

    /**
     * フリー項目(本部2)
     * @generated
     */
    private String usercd0028;
    private boolean usercd0028NullFlag;

    /**
     * フリー項目(本部3)
     * @generated
     */
    private String usercd0029;
    private boolean usercd0029NullFlag;

    /**
     * フリー項目(本部4)
     * @generated
     */
    private String usercd0030;
    private boolean usercd0030NullFlag;

    /**
     * フリー項目(本部5)
     * @generated
     */
    private String usercd0031;
    private boolean usercd0031NullFlag;

    /**
     * フリー項目(本部6)
     * @generated
     */
    private String usercd0032;
    private boolean usercd0032NullFlag;

    /**
     * フリー項目(本部7)
     * @generated
     */
    private String usercd0033;
    private boolean usercd0033NullFlag;

    /**
     * フリー項目(本部8)
     * @generated
     */
    private String usercd0034;
    private boolean usercd0034NullFlag;

    /**
     * フリー項目(本部9)
     * @generated
     */
    private String usercd0035;
    private boolean usercd0035NullFlag;

    /**
     * フリー項目(本部10)
     * @generated
     */
    private String usercd0036;
    private boolean usercd0036NullFlag;

    /**
     * フリー項目(支店A)
     * @generated
     */
    private String usercd0101;
    private boolean usercd0101NullFlag;

    /**
     * フリー項目(支店B)
     * @generated
     */
    private String usercd0102;
    private boolean usercd0102NullFlag;

    /**
     * フリー項目(支店C)
     * @generated
     */
    private String usercd0103;
    private boolean usercd0103NullFlag;

    /**
     * フリー項目(支店D)
     * @generated
     */
    private String usercd0104;
    private boolean usercd0104NullFlag;

    /**
     * フリー項目(支店E)
     * @generated
     */
    private String usercd0105;
    private boolean usercd0105NullFlag;

    /**
     * フリー項目(支店F)
     * @generated
     */
    private String usercd0106;
    private boolean usercd0106NullFlag;

    /**
     * フリー項目(支店G)
     * @generated
     */
    private String usercd0107;
    private boolean usercd0107NullFlag;

    /**
     * フリー項目(支店H)
     * @generated
     */
    private String usercd0108;
    private boolean usercd0108NullFlag;

    /**
     * フリー項目(支店I)
     * @generated
     */
    private String usercd0109;
    private boolean usercd0109NullFlag;

    /**
     * フリー項目(営業所A)
     * @generated
     */
    private String usercd0201;
    private boolean usercd0201NullFlag;

    /**
     * フリー項目(営業所B)
     * @generated
     */
    private String usercd0202;
    private boolean usercd0202NullFlag;

    /**
     * フリー項目(営業所C)
     * @generated
     */
    private String usercd0203;
    private boolean usercd0203NullFlag;

    /**
     * フリー項目(営業所D)
     * @generated
     */
    private String usercd0204;
    private boolean usercd0204NullFlag;

    /**
     * フリー項目(営業所E)
     * @generated
     */
    private String usercd0205;
    private boolean usercd0205NullFlag;

    /**
     * フリー項目(営業所F)
     * @generated
     */
    private String usercd0206;
    private boolean usercd0206NullFlag;

    /**
     * 診療報酬項目(入院診療計画)
     * @generated
     */
    private String reward04;
    private boolean reward04NullFlag;

    /**
     * 診療報酬項目(院内感染防止対策)
     * @generated
     */
    private String reward05;
    private boolean reward05NullFlag;

    /**
     * 診療報酬項目(地域連携小児夜間・休日診療料)
     * @generated
     */
    private String reward08;
    private boolean reward08NullFlag;

    /**
     * 診療報酬項目(小児入院医療管理料)
     * @generated
     */
    private String reward09;
    private boolean reward09NullFlag;

    /**
     * 診療報酬項目(急性期入院加算)
     * @generated
     */
    private String reward16;
    private boolean reward16NullFlag;

    /**
     * 診療報酬項目(急性期特定入院加算)
     * @generated
     */
    private String reward17;
    private boolean reward17NullFlag;

    /**
     * 診療報酬項目(緩和ケア診療加算)
     * @generated
     */
    private String reward18;
    private boolean reward18NullFlag;

    /**
     * 診療報酬項目(短期滞在手術基本料)
     * @generated
     */
    private String reward21;
    private boolean reward21NullFlag;

    /**
     * 診療報酬項目(在宅患者訪問診療料又は在総診)
     * @generated
     */
    private String reward23;
    private boolean reward23NullFlag;

    /**
     * 診療報酬項目(生活習慣病指導管理料)
     * @generated
     */
    private String reward25;
    private boolean reward25NullFlag;

    /**
     * 診療報酬項目(慢性疼痛疾患管理料)
     * @generated
     */
    private String reward26;
    private boolean reward26NullFlag;

    /**
     * 診療報酬項目(看護配置(有床診療所))
     * @generated
     */
    private String reward27;
    private boolean reward27NullFlag;

    /**
     * 診療報酬項目(老人入院基本料)
     * @generated
     */
    private String reward29;
    private boolean reward29NullFlag;

    /**
     * 診療報酬項目(地域連携時間外(有無))
     * @generated
     */
    private String reward35;
    private boolean reward35NullFlag;

    /**
     * 診療報酬項目(地域連携計画管理料)
     * @generated
     */
    private String reward36;
    private boolean reward36NullFlag;

    /**
     * 診療報酬項目(地域連携計画退院時指導料)
     * @generated
     */
    private String reward37;
    private boolean reward37NullFlag;

    /**
     * 診療報酬項目(病理診療料)
     * @generated
     */
    private String reward44;
    private boolean reward44NullFlag;

    /**
     * 削除区分
     * @generated
     */
    private Integer delKbn;
    private boolean delKbnNullFlag;

    /**
     * 削除理由
     * @generated
     */
    private String delReason;
    private boolean delReasonNullFlag;

    /**
     * 削除年月日
     * @generated
     */
    private String delYmd;
    private boolean delYmdNullFlag;

    /**
     * 重複先施設固定コード
     * @generated
     */
    private String dupInsNo;
    private boolean dupInsNoNullFlag;

    /**
     * 復活理由
     * @generated
     */
    private String rstReason;
    private boolean rstReasonNullFlag;

    /**
     * 作成日
     * @generated
     */
    private Date insShaYmd;
    private boolean insShaYmdNullFlag;

    /**
     * 作成者
     * @generated
     */
    private String insShaId;
    private boolean insShaIdNullFlag;

    /**
     * 更新日
     * @generated
     */
    private Date updShaYmd;
    private boolean updShaYmdNullFlag;

    /**
     * 更新者
     * @generated
     */
    private String updShaId;
    private boolean updShaIdNullFlag;

    /**
     * 管理者フラグ
     * @generated
     */
    private String knrFlg;


    /**
     * コンストラクタ
     * @generated
     */
    public TRdmHcoReqEntity() {
        super("t_rdm_hco_req");
    }

    /**
     * コンストラクタ
     * @generated
     */
    public TRdmHcoReqEntity(String sqlId) {
        super("t_rdm_hco_req", sqlId);
    }


	/**
	 * TRdmHcoReqEntity.javareqIdを設定
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
	 * TRdmHcoReqEntity.javareqIdNullFlagを設定
	 * @return reqIdNullFlag
	 */
	public boolean isReqIdNullFlag() {
		return reqIdNullFlag;
	}


	/**
	 * @param reqIdNullFlag セットする reqIdNullFlag
	 */
	public void setReqIdNullFlag(boolean reqIdNullFlag) {
		this.reqIdNullFlag = reqIdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsNoを設定
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
	 * TRdmHcoReqEntity.javainsNoNullFlagを設定
	 * @return insNoNullFlag
	 */
	public boolean isInsNoNullFlag() {
		return insNoNullFlag;
	}


	/**
	 * @param insNoNullFlag セットする insNoNullFlag
	 */
	public void setInsNoNullFlag(boolean insNoNullFlag) {
		this.insNoNullFlag = insNoNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsClassを設定
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
	 * TRdmHcoReqEntity.javainsClassNullFlagを設定
	 * @return insClassNullFlag
	 */
	public boolean isInsClassNullFlag() {
		return insClassNullFlag;
	}


	/**
	 * @param insClassNullFlag セットする insClassNullFlag
	 */
	public void setInsClassNullFlag(boolean insClassNullFlag) {
		this.insClassNullFlag = insClassNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsSbtを設定
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
	 * TRdmHcoReqEntity.javainsSbtNullFlagを設定
	 * @return insSbtNullFlag
	 */
	public boolean isInsSbtNullFlag() {
		return insSbtNullFlag;
	}


	/**
	 * @param insSbtNullFlag セットする insSbtNullFlag
	 */
	public void setInsSbtNullFlag(boolean insSbtNullFlag) {
		this.insSbtNullFlag = insSbtNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsKanaを設定
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
	 * TRdmHcoReqEntity.javainsKanaNullFlagを設定
	 * @return insKanaNullFlag
	 */
	public boolean isInsKanaNullFlag() {
		return insKanaNullFlag;
	}


	/**
	 * @param insKanaNullFlag セットする insKanaNullFlag
	 */
	public void setInsKanaNullFlag(boolean insKanaNullFlag) {
		this.insKanaNullFlag = insKanaNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsAbbrNameを設定
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
	 * TRdmHcoReqEntity.javainsAbbrNameNullFlagを設定
	 * @return insAbbrNameNullFlag
	 */
	public boolean isInsAbbrNameNullFlag() {
		return insAbbrNameNullFlag;
	}


	/**
	 * @param insAbbrNameNullFlag セットする insAbbrNameNullFlag
	 */
	public void setInsAbbrNameNullFlag(boolean insAbbrNameNullFlag) {
		this.insAbbrNameNullFlag = insAbbrNameNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsFormalNameを設定
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
	 * TRdmHcoReqEntity.javainsFormalNameNullFlagを設定
	 * @return insFormalNameNullFlag
	 */
	public boolean isInsFormalNameNullFlag() {
		return insFormalNameNullFlag;
	}


	/**
	 * @param insFormalNameNullFlag セットする insFormalNameNullFlag
	 */
	public void setInsFormalNameNullFlag(boolean insFormalNameNullFlag) {
		this.insFormalNameNullFlag = insFormalNameNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsContNameを設定
	 * @return insContName
	 */
	public String getInsContName() {
		return insContName;
	}


	/**
	 * @param insContName セットする insContName
	 */
	public void setInsContName(String insContName) {
		this.insContName = insContName;
	}


	/**
	 * TRdmHcoReqEntity.javainsContNameNullFlagを設定
	 * @return insContNameNullFlag
	 */
	public boolean isInsContNameNullFlag() {
		return insContNameNullFlag;
	}


	/**
	 * @param insContNameNullFlag セットする insContNameNullFlag
	 */
	public void setInsContNameNullFlag(boolean insContNameNullFlag) {
		this.insContNameNullFlag = insContNameNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsPcodeを設定
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
	 * TRdmHcoReqEntity.javainsPcodeNullFlagを設定
	 * @return insPcodeNullFlag
	 */
	public boolean isInsPcodeNullFlag() {
		return insPcodeNullFlag;
	}


	/**
	 * @param insPcodeNullFlag セットする insPcodeNullFlag
	 */
	public void setInsPcodeNullFlag(boolean insPcodeNullFlag) {
		this.insPcodeNullFlag = insPcodeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaaddrCodePrefを設定
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
	 * TRdmHcoReqEntity.javaaddrCodePrefNullFlagを設定
	 * @return addrCodePrefNullFlag
	 */
	public boolean isAddrCodePrefNullFlag() {
		return addrCodePrefNullFlag;
	}


	/**
	 * @param addrCodePrefNullFlag セットする addrCodePrefNullFlag
	 */
	public void setAddrCodePrefNullFlag(boolean addrCodePrefNullFlag) {
		this.addrCodePrefNullFlag = addrCodePrefNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaaddrCodeCityを設定
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
	 * TRdmHcoReqEntity.javaaddrCodeCityNullFlagを設定
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


	/**
	 * TRdmHcoReqEntity.javatkCityCdを設定
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
	 * TRdmHcoReqEntity.javatkCityCdNullFlagを設定
	 * @return tkCityCdNullFlag
	 */
	public boolean isTkCityCdNullFlag() {
		return tkCityCdNullFlag;
	}


	/**
	 * @param tkCityCdNullFlag セットする tkCityCdNullFlag
	 */
	public void setTkCityCdNullFlag(boolean tkCityCdNullFlag) {
		this.tkCityCdNullFlag = tkCityCdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsAddrDtを設定
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
	 * TRdmHcoReqEntity.javainsAddrDtNullFlagを設定
	 * @return insAddrDtNullFlag
	 */
	public boolean isInsAddrDtNullFlag() {
		return insAddrDtNullFlag;
	}


	/**
	 * @param insAddrDtNullFlag セットする insAddrDtNullFlag
	 */
	public void setInsAddrDtNullFlag(boolean insAddrDtNullFlag) {
		this.insAddrDtNullFlag = insAddrDtNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsAddrを設定
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
	 * TRdmHcoReqEntity.javainsAddrNullFlagを設定
	 * @return insAddrNullFlag
	 */
	public boolean isInsAddrNullFlag() {
		return insAddrNullFlag;
	}


	/**
	 * @param insAddrNullFlag セットする insAddrNullFlag
	 */
	public void setInsAddrNullFlag(boolean insAddrNullFlag) {
		this.insAddrNullFlag = insAddrNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsAddrKanaを設定
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
	 * TRdmHcoReqEntity.javainsAddrKanaNullFlagを設定
	 * @return insAddrKanaNullFlag
	 */
	public boolean isInsAddrKanaNullFlag() {
		return insAddrKanaNullFlag;
	}


	/**
	 * @param insAddrKanaNullFlag セットする insAddrKanaNullFlag
	 */
	public void setInsAddrKanaNullFlag(boolean insAddrKanaNullFlag) {
		this.insAddrKanaNullFlag = insAddrKanaNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsPhone1を設定
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
	 * TRdmHcoReqEntity.javainsPhone1NullFlagを設定
	 * @return insPhone1NullFlag
	 */
	public boolean isInsPhone1NullFlag() {
		return insPhone1NullFlag;
	}


	/**
	 * @param insPhone1NullFlag セットする insPhone1NullFlag
	 */
	public void setInsPhone1NullFlag(boolean insPhone1NullFlag) {
		this.insPhone1NullFlag = insPhone1NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsFax1を設定
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
	 * TRdmHcoReqEntity.javainsFax1NullFlagを設定
	 * @return insFax1NullFlag
	 */
	public boolean isInsFax1NullFlag() {
		return insFax1NullFlag;
	}


	/**
	 * @param insFax1NullFlag セットする insFax1NullFlag
	 */
	public void setInsFax1NullFlag(boolean insFax1NullFlag) {
		this.insFax1NullFlag = insFax1NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsPhone2を設定
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
	 * TRdmHcoReqEntity.javainsPhone2NullFlagを設定
	 * @return insPhone2NullFlag
	 */
	public boolean isInsPhone2NullFlag() {
		return insPhone2NullFlag;
	}


	/**
	 * @param insPhone2NullFlag セットする insPhone2NullFlag
	 */
	public void setInsPhone2NullFlag(boolean insPhone2NullFlag) {
		this.insPhone2NullFlag = insPhone2NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsFax2を設定
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
	 * TRdmHcoReqEntity.javainsFax2NullFlagを設定
	 * @return insFax2NullFlag
	 */
	public boolean isInsFax2NullFlag() {
		return insFax2NullFlag;
	}


	/**
	 * @param insFax2NullFlag セットする insFax2NullFlag
	 */
	public void setInsFax2NullFlag(boolean insFax2NullFlag) {
		this.insFax2NullFlag = insFax2NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsUrlを設定
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
	 * TRdmHcoReqEntity.javainsUrlNullFlagを設定
	 * @return insUrlNullFlag
	 */
	public boolean isInsUrlNullFlag() {
		return insUrlNullFlag;
	}


	/**
	 * @param insUrlNullFlag セットする insUrlNullFlag
	 */
	public void setInsUrlNullFlag(boolean insUrlNullFlag) {
		this.insUrlNullFlag = insUrlNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsUrlYmdを設定
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
	 * TRdmHcoReqEntity.javainsUrlYmdNullFlagを設定
	 * @return insUrlYmdNullFlag
	 */
	public boolean isInsUrlYmdNullFlag() {
		return insUrlYmdNullFlag;
	}


	/**
	 * @param insUrlYmdNullFlag セットする insUrlYmdNullFlag
	 */
	public void setInsUrlYmdNullFlag(boolean insUrlYmdNullFlag) {
		this.insUrlYmdNullFlag = insUrlYmdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javatradeTypeを設定
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
	 * TRdmHcoReqEntity.javatradeTypeNullFlagを設定
	 * @return tradeTypeNullFlag
	 */
	public boolean isTradeTypeNullFlag() {
		return tradeTypeNullFlag;
	}


	/**
	 * @param tradeTypeNullFlag セットする tradeTypeNullFlag
	 */
	public void setTradeTypeNullFlag(boolean tradeTypeNullFlag) {
		this.tradeTypeNullFlag = tradeTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javawsTypeを設定
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
	 * TRdmHcoReqEntity.javawsTypeNullFlagを設定
	 * @return wsTypeNullFlag
	 */
	public boolean isWsTypeNullFlag() {
		return wsTypeNullFlag;
	}


	/**
	 * @param wsTypeNullFlag セットする wsTypeNullFlag
	 */
	public void setWsTypeNullFlag(boolean wsTypeNullFlag) {
		this.wsTypeNullFlag = wsTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabasketPurchaseを設定
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
	 * TRdmHcoReqEntity.javabasketPurchaseNullFlagを設定
	 * @return basketPurchaseNullFlag
	 */
	public boolean isBasketPurchaseNullFlag() {
		return basketPurchaseNullFlag;
	}


	/**
	 * @param basketPurchaseNullFlag セットする basketPurchaseNullFlag
	 */
	public void setBasketPurchaseNullFlag(boolean basketPurchaseNullFlag) {
		this.basketPurchaseNullFlag = basketPurchaseNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javahoInsTypeを設定
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
	 * TRdmHcoReqEntity.javahoInsTypeNullFlagを設定
	 * @return hoInsTypeNullFlag
	 */
	public boolean isHoInsTypeNullFlag() {
		return hoInsTypeNullFlag;
	}


	/**
	 * @param hoInsTypeNullFlag セットする hoInsTypeNullFlag
	 */
	public void setHoInsTypeNullFlag(boolean hoInsTypeNullFlag) {
		this.hoInsTypeNullFlag = hoInsTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javapharmTypeを設定
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
	 * TRdmHcoReqEntity.javapharmTypeNullFlagを設定
	 * @return pharmTypeNullFlag
	 */
	public boolean isPharmTypeNullFlag() {
		return pharmTypeNullFlag;
	}


	/**
	 * @param pharmTypeNullFlag セットする pharmTypeNullFlag
	 */
	public void setPharmTypeNullFlag(boolean pharmTypeNullFlag) {
		this.pharmTypeNullFlag = pharmTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsRankを設定
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
	 * TRdmHcoReqEntity.javainsRankNullFlagを設定
	 * @return insRankNullFlag
	 */
	public boolean isInsRankNullFlag() {
		return insRankNullFlag;
	}


	/**
	 * @param insRankNullFlag セットする insRankNullFlag
	 */
	public void setInsRankNullFlag(boolean insRankNullFlag) {
		this.insRankNullFlag = insRankNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamanageCdを設定
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
	 * TRdmHcoReqEntity.javamanageCdNullFlagを設定
	 * @return manageCdNullFlag
	 */
	public boolean isManageCdNullFlag() {
		return manageCdNullFlag;
	}


	/**
	 * @param manageCdNullFlag セットする manageCdNullFlag
	 */
	public void setManageCdNullFlag(boolean manageCdNullFlag) {
		this.manageCdNullFlag = manageCdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaregVisTypeを設定
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
	 * TRdmHcoReqEntity.javaregVisTypeNullFlagを設定
	 * @return regVisTypeNullFlag
	 */
	public boolean isRegVisTypeNullFlag() {
		return regVisTypeNullFlag;
	}


	/**
	 * @param regVisTypeNullFlag セットする regVisTypeNullFlag
	 */
	public void setRegVisTypeNullFlag(boolean regVisTypeNullFlag) {
		this.regVisTypeNullFlag = regVisTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaimpHosTypeを設定
	 * @return impHosType
	 */
	public String getImpHosType() {
		return impHosType;
	}


	/**
	 * @param impHosType セットする impHosType
	 */
	public void setImpHosType(String impHosType) {
		this.impHosType = impHosType;
	}


	/**
	 * TRdmHcoReqEntity.javaimpHosTypeNullFlagを設定
	 * @return impHosTypeNullFlag
	 */
	public boolean isImpHosTypeNullFlag() {
		return impHosTypeNullFlag;
	}


	/**
	 * @param impHosTypeNullFlag セットする impHosTypeNullFlag
	 */
	public void setImpHosTypeNullFlag(boolean impHosTypeNullFlag) {
		this.impHosTypeNullFlag = impHosTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaimpInsTypeを設定
	 * @return impInsType
	 */
	public String getImpInsType() {
		return impInsType;
	}


	/**
	 * @param impInsType セットする impInsType
	 */
	public void setImpInsType(String impInsType) {
		this.impInsType = impInsType;
	}


	/**
	 * TRdmHcoReqEntity.javaimpInsTypeNullFlagを設定
	 * @return impInsTypeNullFlag
	 */
	public boolean isImpInsTypeNullFlag() {
		return impInsTypeNullFlag;
	}


	/**
	 * @param impInsTypeNullFlag セットする impInsTypeNullFlag
	 */
	public void setImpInsTypeNullFlag(boolean impInsTypeNullFlag) {
		this.impInsTypeNullFlag = impInsTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaunivSubdivを設定
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
	 * TRdmHcoReqEntity.javaunivSubdivNullFlagを設定
	 * @return univSubdivNullFlag
	 */
	public boolean isUnivSubdivNullFlag() {
		return univSubdivNullFlag;
	}


	/**
	 * @param univSubdivNullFlag セットする univSubdivNullFlag
	 */
	public void setUnivSubdivNullFlag(boolean univSubdivNullFlag) {
		this.univSubdivNullFlag = univSubdivNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsOpenYearを設定
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
	 * TRdmHcoReqEntity.javainsOpenYearNullFlagを設定
	 * @return insOpenYearNullFlag
	 */
	public boolean isInsOpenYearNullFlag() {
		return insOpenYearNullFlag;
	}


	/**
	 * @param insOpenYearNullFlag セットする insOpenYearNullFlag
	 */
	public void setInsOpenYearNullFlag(boolean insOpenYearNullFlag) {
		this.insOpenYearNullFlag = insOpenYearNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsOpenMonthを設定
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
	 * TRdmHcoReqEntity.javainsOpenMonthNullFlagを設定
	 * @return insOpenMonthNullFlag
	 */
	public boolean isInsOpenMonthNullFlag() {
		return insOpenMonthNullFlag;
	}


	/**
	 * @param insOpenMonthNullFlag セットする insOpenMonthNullFlag
	 */
	public void setInsOpenMonthNullFlag(boolean insOpenMonthNullFlag) {
		this.insOpenMonthNullFlag = insOpenMonthNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsOpenDayを設定
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
	 * TRdmHcoReqEntity.javainsOpenDayNullFlagを設定
	 * @return insOpenDayNullFlag
	 */
	public boolean isInsOpenDayNullFlag() {
		return insOpenDayNullFlag;
	}


	/**
	 * @param insOpenDayNullFlag セットする insOpenDayNullFlag
	 */
	public void setInsOpenDayNullFlag(boolean insOpenDayNullFlag) {
		this.insOpenDayNullFlag = insOpenDayNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javahosEmergを設定
	 * @return hosEmerg
	 */
	public String getHosEmerg() {
		return hosEmerg;
	}


	/**
	 * @param hosEmerg セットする hosEmerg
	 */
	public void setHosEmerg(String hosEmerg) {
		this.hosEmerg = hosEmerg;
	}


	/**
	 * TRdmHcoReqEntity.javahosEmergNullFlagを設定
	 * @return hosEmergNullFlag
	 */
	public boolean isHosEmergNullFlag() {
		return hosEmergNullFlag;
	}


	/**
	 * @param hosEmergNullFlag セットする hosEmergNullFlag
	 */
	public void setHosEmergNullFlag(boolean hosEmergNullFlag) {
		this.hosEmergNullFlag = hosEmergNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javacapaTypeを設定
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
	 * TRdmHcoReqEntity.javacapaTypeNullFlagを設定
	 * @return capaTypeNullFlag
	 */
	public boolean isCapaTypeNullFlag() {
		return capaTypeNullFlag;
	}


	/**
	 * @param capaTypeNullFlag セットする capaTypeNullFlag
	 */
	public void setCapaTypeNullFlag(boolean capaTypeNullFlag) {
		this.capaTypeNullFlag = capaTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaclitemListを設定
	 * @return clitemList
	 */
	public String getClitemList() {
		return clitemList;
	}


	/**
	 * @param clitemList セットする clitemList
	 */
	public void setClitemList(String clitemList) {
		this.clitemList = clitemList;
	}


	/**
	 * TRdmHcoReqEntity.javaclitemListNullFlagを設定
	 * @return clitemListNullFlag
	 */
	public boolean isClitemListNullFlag() {
		return clitemListNullFlag;
	}


	/**
	 * @param clitemListNullFlag セットする clitemListNullFlag
	 */
	public void setClitemListNullFlag(boolean clitemListNullFlag) {
		this.clitemListNullFlag = clitemListNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javavacInsTypeを設定
	 * @return vacInsType
	 */
	public String getVacInsType() {
		return vacInsType;
	}


	/**
	 * @param vacInsType セットする vacInsType
	 */
	public void setVacInsType(String vacInsType) {
		this.vacInsType = vacInsType;
	}


	/**
	 * TRdmHcoReqEntity.javavacInsTypeNullFlagを設定
	 * @return vacInsTypeNullFlag
	 */
	public boolean isVacInsTypeNullFlag() {
		return vacInsTypeNullFlag;
	}


	/**
	 * @param vacInsTypeNullFlag セットする vacInsTypeNullFlag
	 */
	public void setVacInsTypeNullFlag(boolean vacInsTypeNullFlag) {
		this.vacInsTypeNullFlag = vacInsTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javavacVisitTypeを設定
	 * @return vacVisitType
	 */
	public String getVacVisitType() {
		return vacVisitType;
	}


	/**
	 * @param vacVisitType セットする vacVisitType
	 */
	public void setVacVisitType(String vacVisitType) {
		this.vacVisitType = vacVisitType;
	}


	/**
	 * TRdmHcoReqEntity.javavacVisitTypeNullFlagを設定
	 * @return vacVisitTypeNullFlag
	 */
	public boolean isVacVisitTypeNullFlag() {
		return vacVisitTypeNullFlag;
	}


	/**
	 * @param vacVisitTypeNullFlag セットする vacVisitTypeNullFlag
	 */
	public void setVacVisitTypeNullFlag(boolean vacVisitTypeNullFlag) {
		this.vacVisitTypeNullFlag = vacVisitTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedcntBaseを設定
	 * @return bedcntBase
	 */
	public String getBedcntBase() {
		return bedcntBase;
	}


	/**
	 * @param bedcntBase セットする bedcntBase
	 */
	public void setBedcntBase(String bedcntBase) {
		this.bedcntBase = bedcntBase;
	}


	/**
	 * TRdmHcoReqEntity.javabedcntBaseNullFlagを設定
	 * @return bedcntBaseNullFlag
	 */
	public boolean isBedcntBaseNullFlag() {
		return bedcntBaseNullFlag;
	}


	/**
	 * @param bedcntBaseNullFlag セットする bedcntBaseNullFlag
	 */
	public void setBedcntBaseNullFlag(boolean bedcntBaseNullFlag) {
		this.bedcntBaseNullFlag = bedcntBaseNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedsTotを設定
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
	 * TRdmHcoReqEntity.javabedsTotNullFlagを設定
	 * @return bedsTotNullFlag
	 */
	public boolean isBedsTotNullFlag() {
		return bedsTotNullFlag;
	}


	/**
	 * @param bedsTotNullFlag セットする bedsTotNullFlag
	 */
	public void setBedsTotNullFlag(boolean bedsTotNullFlag) {
		this.bedsTotNullFlag = bedsTotNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamedBedsTotを設定
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
	 * TRdmHcoReqEntity.javamedBedsTotNullFlagを設定
	 * @return medBedsTotNullFlag
	 */
	public boolean isMedBedsTotNullFlag() {
		return medBedsTotNullFlag;
	}


	/**
	 * @param medBedsTotNullFlag セットする medBedsTotNullFlag
	 */
	public void setMedBedsTotNullFlag(boolean medBedsTotNullFlag) {
		this.medBedsTotNullFlag = medBedsTotNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaentcapaNumを設定
	 * @return entcapaNum
	 */
	public String getEntcapaNum() {
		return entcapaNum;
	}


	/**
	 * @param entcapaNum セットする entcapaNum
	 */
	public void setEntcapaNum(String entcapaNum) {
		this.entcapaNum = entcapaNum;
	}


	/**
	 * TRdmHcoReqEntity.javaentcapaNumNullFlagを設定
	 * @return entcapaNumNullFlag
	 */
	public boolean isEntcapaNumNullFlag() {
		return entcapaNumNullFlag;
	}


	/**
	 * @param entcapaNumNullFlag セットする entcapaNumNullFlag
	 */
	public void setEntcapaNumNullFlag(boolean entcapaNumNullFlag) {
		this.entcapaNumNullFlag = entcapaNumNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamainInsNoを設定
	 * @return mainInsNo
	 */
	public String getMainInsNo() {
		return mainInsNo;
	}


	/**
	 * @param mainInsNo セットする mainInsNo
	 */
	public void setMainInsNo(String mainInsNo) {
		this.mainInsNo = mainInsNo;
	}


	/**
	 * TRdmHcoReqEntity.javamainInsNoNullFlagを設定
	 * @return mainInsNoNullFlag
	 */
	public boolean isMainInsNoNullFlag() {
		return mainInsNoNullFlag;
	}


	/**
	 * @param mainInsNoNullFlag セットする mainInsNoNullFlag
	 */
	public void setMainInsNoNullFlag(boolean mainInsNoNullFlag) {
		this.mainInsNoNullFlag = mainInsNoNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsSecondTypeを設定
	 * @return insSecondType
	 */
	public String getInsSecondType() {
		return insSecondType;
	}


	/**
	 * @param insSecondType セットする insSecondType
	 */
	public void setInsSecondType(String insSecondType) {
		this.insSecondType = insSecondType;
	}


	/**
	 * TRdmHcoReqEntity.javainsSecondTypeNullFlagを設定
	 * @return insSecondTypeNullFlag
	 */
	public boolean isInsSecondTypeNullFlag() {
		return insSecondTypeNullFlag;
	}


	/**
	 * @param insSecondTypeNullFlag セットする insSecondTypeNullFlag
	 */
	public void setInsSecondTypeNullFlag(boolean insSecondTypeNullFlag) {
		this.insSecondTypeNullFlag = insSecondTypeNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaultInsNoを設定
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
	 * TRdmHcoReqEntity.javaultInsNoNullFlagを設定
	 * @return ultInsNoNullFlag
	 */
	public boolean isUltInsNoNullFlag() {
		return ultInsNoNullFlag;
	}


	/**
	 * @param ultInsNoNullFlag セットする ultInsNoNullFlag
	 */
	public void setUltInsNoNullFlag(boolean ultInsNoNullFlag) {
		this.ultInsNoNullFlag = ultInsNoNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamdmIdを設定
	 * @return mdmId
	 */
	public String getMdmId() {
		return mdmId;
	}


	/**
	 * @param mdmId セットする mdmId
	 */
	public void setMdmId(String mdmId) {
		this.mdmId = mdmId;
	}


	/**
	 * TRdmHcoReqEntity.javamdmIdNullFlagを設定
	 * @return mdmIdNullFlag
	 */
	public boolean isMdmIdNullFlag() {
		return mdmIdNullFlag;
	}


	/**
	 * @param mdmIdNullFlag セットする mdmIdNullFlag
	 */
	public void setMdmIdNullFlag(boolean mdmIdNullFlag) {
		this.mdmIdNullFlag = mdmIdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt01を設定
	 * @return bedcnt01
	 */
	public String getBedcnt01() {
		return bedcnt01;
	}


	/**
	 * @param bedcnt01 セットする bedcnt01
	 */
	public void setBedcnt01(String bedcnt01) {
		this.bedcnt01 = bedcnt01;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt01NullFlagを設定
	 * @return bedcnt01NullFlag
	 */
	public boolean isBedcnt01NullFlag() {
		return bedcnt01NullFlag;
	}


	/**
	 * @param bedcnt01NullFlag セットする bedcnt01NullFlag
	 */
	public void setBedcnt01NullFlag(boolean bedcnt01NullFlag) {
		this.bedcnt01NullFlag = bedcnt01NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt02を設定
	 * @return bedcnt02
	 */
	public String getBedcnt02() {
		return bedcnt02;
	}


	/**
	 * @param bedcnt02 セットする bedcnt02
	 */
	public void setBedcnt02(String bedcnt02) {
		this.bedcnt02 = bedcnt02;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt02NullFlagを設定
	 * @return bedcnt02NullFlag
	 */
	public boolean isBedcnt02NullFlag() {
		return bedcnt02NullFlag;
	}


	/**
	 * @param bedcnt02NullFlag セットする bedcnt02NullFlag
	 */
	public void setBedcnt02NullFlag(boolean bedcnt02NullFlag) {
		this.bedcnt02NullFlag = bedcnt02NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt03を設定
	 * @return bedcnt03
	 */
	public String getBedcnt03() {
		return bedcnt03;
	}


	/**
	 * @param bedcnt03 セットする bedcnt03
	 */
	public void setBedcnt03(String bedcnt03) {
		this.bedcnt03 = bedcnt03;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt03NullFlagを設定
	 * @return bedcnt03NullFlag
	 */
	public boolean isBedcnt03NullFlag() {
		return bedcnt03NullFlag;
	}


	/**
	 * @param bedcnt03NullFlag セットする bedcnt03NullFlag
	 */
	public void setBedcnt03NullFlag(boolean bedcnt03NullFlag) {
		this.bedcnt03NullFlag = bedcnt03NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt04を設定
	 * @return bedcnt04
	 */
	public String getBedcnt04() {
		return bedcnt04;
	}


	/**
	 * @param bedcnt04 セットする bedcnt04
	 */
	public void setBedcnt04(String bedcnt04) {
		this.bedcnt04 = bedcnt04;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt04NullFlagを設定
	 * @return bedcnt04NullFlag
	 */
	public boolean isBedcnt04NullFlag() {
		return bedcnt04NullFlag;
	}


	/**
	 * @param bedcnt04NullFlag セットする bedcnt04NullFlag
	 */
	public void setBedcnt04NullFlag(boolean bedcnt04NullFlag) {
		this.bedcnt04NullFlag = bedcnt04NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt05を設定
	 * @return bedcnt05
	 */
	public String getBedcnt05() {
		return bedcnt05;
	}


	/**
	 * @param bedcnt05 セットする bedcnt05
	 */
	public void setBedcnt05(String bedcnt05) {
		this.bedcnt05 = bedcnt05;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt05NullFlagを設定
	 * @return bedcnt05NullFlag
	 */
	public boolean isBedcnt05NullFlag() {
		return bedcnt05NullFlag;
	}


	/**
	 * @param bedcnt05NullFlag セットする bedcnt05NullFlag
	 */
	public void setBedcnt05NullFlag(boolean bedcnt05NullFlag) {
		this.bedcnt05NullFlag = bedcnt05NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt06を設定
	 * @return bedcnt06
	 */
	public String getBedcnt06() {
		return bedcnt06;
	}


	/**
	 * @param bedcnt06 セットする bedcnt06
	 */
	public void setBedcnt06(String bedcnt06) {
		this.bedcnt06 = bedcnt06;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt06NullFlagを設定
	 * @return bedcnt06NullFlag
	 */
	public boolean isBedcnt06NullFlag() {
		return bedcnt06NullFlag;
	}


	/**
	 * @param bedcnt06NullFlag セットする bedcnt06NullFlag
	 */
	public void setBedcnt06NullFlag(boolean bedcnt06NullFlag) {
		this.bedcnt06NullFlag = bedcnt06NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt07を設定
	 * @return bedcnt07
	 */
	public String getBedcnt07() {
		return bedcnt07;
	}


	/**
	 * @param bedcnt07 セットする bedcnt07
	 */
	public void setBedcnt07(String bedcnt07) {
		this.bedcnt07 = bedcnt07;
	}


	/**
	 * TRdmHcoReqEntity.javabedcnt07NullFlagを設定
	 * @return bedcnt07NullFlag
	 */
	public boolean isBedcnt07NullFlag() {
		return bedcnt07NullFlag;
	}


	/**
	 * @param bedcnt07NullFlag セットする bedcnt07NullFlag
	 */
	public void setBedcnt07NullFlag(boolean bedcnt07NullFlag) {
		this.bedcnt07NullFlag = bedcnt07NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0001を設定
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
	 * TRdmHcoReqEntity.javafree0001NullFlagを設定
	 * @return free0001NullFlag
	 */
	public boolean isFree0001NullFlag() {
		return free0001NullFlag;
	}


	/**
	 * @param free0001NullFlag セットする free0001NullFlag
	 */
	public void setFree0001NullFlag(boolean free0001NullFlag) {
		this.free0001NullFlag = free0001NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0002を設定
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
	 * TRdmHcoReqEntity.javafree0002NullFlagを設定
	 * @return free0002NullFlag
	 */
	public boolean isFree0002NullFlag() {
		return free0002NullFlag;
	}


	/**
	 * @param free0002NullFlag セットする free0002NullFlag
	 */
	public void setFree0002NullFlag(boolean free0002NullFlag) {
		this.free0002NullFlag = free0002NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0003を設定
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
	 * TRdmHcoReqEntity.javafree0003NullFlagを設定
	 * @return free0003NullFlag
	 */
	public boolean isFree0003NullFlag() {
		return free0003NullFlag;
	}


	/**
	 * @param free0003NullFlag セットする free0003NullFlag
	 */
	public void setFree0003NullFlag(boolean free0003NullFlag) {
		this.free0003NullFlag = free0003NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0004を設定
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
	 * TRdmHcoReqEntity.javafree0004NullFlagを設定
	 * @return free0004NullFlag
	 */
	public boolean isFree0004NullFlag() {
		return free0004NullFlag;
	}


	/**
	 * @param free0004NullFlag セットする free0004NullFlag
	 */
	public void setFree0004NullFlag(boolean free0004NullFlag) {
		this.free0004NullFlag = free0004NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0005を設定
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
	 * TRdmHcoReqEntity.javafree0005NullFlagを設定
	 * @return free0005NullFlag
	 */
	public boolean isFree0005NullFlag() {
		return free0005NullFlag;
	}


	/**
	 * @param free0005NullFlag セットする free0005NullFlag
	 */
	public void setFree0005NullFlag(boolean free0005NullFlag) {
		this.free0005NullFlag = free0005NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0006を設定
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
	 * TRdmHcoReqEntity.javafree0006NullFlagを設定
	 * @return free0006NullFlag
	 */
	public boolean isFree0006NullFlag() {
		return free0006NullFlag;
	}


	/**
	 * @param free0006NullFlag セットする free0006NullFlag
	 */
	public void setFree0006NullFlag(boolean free0006NullFlag) {
		this.free0006NullFlag = free0006NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0007を設定
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
	 * TRdmHcoReqEntity.javafree0007NullFlagを設定
	 * @return free0007NullFlag
	 */
	public boolean isFree0007NullFlag() {
		return free0007NullFlag;
	}


	/**
	 * @param free0007NullFlag セットする free0007NullFlag
	 */
	public void setFree0007NullFlag(boolean free0007NullFlag) {
		this.free0007NullFlag = free0007NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0008を設定
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
	 * TRdmHcoReqEntity.javafree0008NullFlagを設定
	 * @return free0008NullFlag
	 */
	public boolean isFree0008NullFlag() {
		return free0008NullFlag;
	}


	/**
	 * @param free0008NullFlag セットする free0008NullFlag
	 */
	public void setFree0008NullFlag(boolean free0008NullFlag) {
		this.free0008NullFlag = free0008NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0009を設定
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
	 * TRdmHcoReqEntity.javafree0009NullFlagを設定
	 * @return free0009NullFlag
	 */
	public boolean isFree0009NullFlag() {
		return free0009NullFlag;
	}


	/**
	 * @param free0009NullFlag セットする free0009NullFlag
	 */
	public void setFree0009NullFlag(boolean free0009NullFlag) {
		this.free0009NullFlag = free0009NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0010を設定
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
	 * TRdmHcoReqEntity.javafree0010NullFlagを設定
	 * @return free0010NullFlag
	 */
	public boolean isFree0010NullFlag() {
		return free0010NullFlag;
	}


	/**
	 * @param free0010NullFlag セットする free0010NullFlag
	 */
	public void setFree0010NullFlag(boolean free0010NullFlag) {
		this.free0010NullFlag = free0010NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0011を設定
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
	 * TRdmHcoReqEntity.javafree0011NullFlagを設定
	 * @return free0011NullFlag
	 */
	public boolean isFree0011NullFlag() {
		return free0011NullFlag;
	}


	/**
	 * @param free0011NullFlag セットする free0011NullFlag
	 */
	public void setFree0011NullFlag(boolean free0011NullFlag) {
		this.free0011NullFlag = free0011NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0012を設定
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
	 * TRdmHcoReqEntity.javafree0012NullFlagを設定
	 * @return free0012NullFlag
	 */
	public boolean isFree0012NullFlag() {
		return free0012NullFlag;
	}


	/**
	 * @param free0012NullFlag セットする free0012NullFlag
	 */
	public void setFree0012NullFlag(boolean free0012NullFlag) {
		this.free0012NullFlag = free0012NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0013を設定
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
	 * TRdmHcoReqEntity.javafree0013NullFlagを設定
	 * @return free0013NullFlag
	 */
	public boolean isFree0013NullFlag() {
		return free0013NullFlag;
	}


	/**
	 * @param free0013NullFlag セットする free0013NullFlag
	 */
	public void setFree0013NullFlag(boolean free0013NullFlag) {
		this.free0013NullFlag = free0013NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0014を設定
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
	 * TRdmHcoReqEntity.javafree0014NullFlagを設定
	 * @return free0014NullFlag
	 */
	public boolean isFree0014NullFlag() {
		return free0014NullFlag;
	}


	/**
	 * @param free0014NullFlag セットする free0014NullFlag
	 */
	public void setFree0014NullFlag(boolean free0014NullFlag) {
		this.free0014NullFlag = free0014NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0015を設定
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
	 * TRdmHcoReqEntity.javafree0015NullFlagを設定
	 * @return free0015NullFlag
	 */
	public boolean isFree0015NullFlag() {
		return free0015NullFlag;
	}


	/**
	 * @param free0015NullFlag セットする free0015NullFlag
	 */
	public void setFree0015NullFlag(boolean free0015NullFlag) {
		this.free0015NullFlag = free0015NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javafree0101を設定
	 * @return free0101
	 */
	public String getFree0101() {
		return free0101;
	}


	/**
	 * @param free0101 セットする free0101
	 */
	public void setFree0101(String free0101) {
		this.free0101 = free0101;
	}


	/**
	 * TRdmHcoReqEntity.javafree0101NullFlagを設定
	 * @return free0101NullFlag
	 */
	public boolean isFree0101NullFlag() {
		return free0101NullFlag;
	}


	/**
	 * @param free0101NullFlag セットする free0101NullFlag
	 */
	public void setFree0101NullFlag(boolean free0101NullFlag) {
		this.free0101NullFlag = free0101NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javawelfare02を設定
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
	 * TRdmHcoReqEntity.javawelfare02NullFlagを設定
	 * @return welfare02NullFlag
	 */
	public boolean isWelfare02NullFlag() {
		return welfare02NullFlag;
	}


	/**
	 * @param welfare02NullFlag セットする welfare02NullFlag
	 */
	public void setWelfare02NullFlag(boolean welfare02NullFlag) {
		this.welfare02NullFlag = welfare02NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javawelfare08を設定
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
	 * TRdmHcoReqEntity.javawelfare08NullFlagを設定
	 * @return welfare08NullFlag
	 */
	public boolean isWelfare08NullFlag() {
		return welfare08NullFlag;
	}


	/**
	 * @param welfare08NullFlag セットする welfare08NullFlag
	 */
	public void setWelfare08NullFlag(boolean welfare08NullFlag) {
		this.welfare08NullFlag = welfare08NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult01を設定
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
	 * TRdmHcoReqEntity.javaresult01NullFlagを設定
	 * @return result01NullFlag
	 */
	public boolean isResult01NullFlag() {
		return result01NullFlag;
	}


	/**
	 * @param result01NullFlag セットする result01NullFlag
	 */
	public void setResult01NullFlag(boolean result01NullFlag) {
		this.result01NullFlag = result01NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult02を設定
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
	 * TRdmHcoReqEntity.javaresult02NullFlagを設定
	 * @return result02NullFlag
	 */
	public boolean isResult02NullFlag() {
		return result02NullFlag;
	}


	/**
	 * @param result02NullFlag セットする result02NullFlag
	 */
	public void setResult02NullFlag(boolean result02NullFlag) {
		this.result02NullFlag = result02NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult03を設定
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
	 * TRdmHcoReqEntity.javaresult03NullFlagを設定
	 * @return result03NullFlag
	 */
	public boolean isResult03NullFlag() {
		return result03NullFlag;
	}


	/**
	 * @param result03NullFlag セットする result03NullFlag
	 */
	public void setResult03NullFlag(boolean result03NullFlag) {
		this.result03NullFlag = result03NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult04を設定
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
	 * TRdmHcoReqEntity.javaresult04NullFlagを設定
	 * @return result04NullFlag
	 */
	public boolean isResult04NullFlag() {
		return result04NullFlag;
	}


	/**
	 * @param result04NullFlag セットする result04NullFlag
	 */
	public void setResult04NullFlag(boolean result04NullFlag) {
		this.result04NullFlag = result04NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult05を設定
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
	 * TRdmHcoReqEntity.javaresult05NullFlagを設定
	 * @return result05NullFlag
	 */
	public boolean isResult05NullFlag() {
		return result05NullFlag;
	}


	/**
	 * @param result05NullFlag セットする result05NullFlag
	 */
	public void setResult05NullFlag(boolean result05NullFlag) {
		this.result05NullFlag = result05NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult06を設定
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
	 * TRdmHcoReqEntity.javaresult06NullFlagを設定
	 * @return result06NullFlag
	 */
	public boolean isResult06NullFlag() {
		return result06NullFlag;
	}


	/**
	 * @param result06NullFlag セットする result06NullFlag
	 */
	public void setResult06NullFlag(boolean result06NullFlag) {
		this.result06NullFlag = result06NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult07を設定
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
	 * TRdmHcoReqEntity.javaresult07NullFlagを設定
	 * @return result07NullFlag
	 */
	public boolean isResult07NullFlag() {
		return result07NullFlag;
	}


	/**
	 * @param result07NullFlag セットする result07NullFlag
	 */
	public void setResult07NullFlag(boolean result07NullFlag) {
		this.result07NullFlag = result07NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult08を設定
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
	 * TRdmHcoReqEntity.javaresult08NullFlagを設定
	 * @return result08NullFlag
	 */
	public boolean isResult08NullFlag() {
		return result08NullFlag;
	}


	/**
	 * @param result08NullFlag セットする result08NullFlag
	 */
	public void setResult08NullFlag(boolean result08NullFlag) {
		this.result08NullFlag = result08NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult09を設定
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
	 * TRdmHcoReqEntity.javaresult09NullFlagを設定
	 * @return result09NullFlag
	 */
	public boolean isResult09NullFlag() {
		return result09NullFlag;
	}


	/**
	 * @param result09NullFlag セットする result09NullFlag
	 */
	public void setResult09NullFlag(boolean result09NullFlag) {
		this.result09NullFlag = result09NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult10を設定
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
	 * TRdmHcoReqEntity.javaresult10NullFlagを設定
	 * @return result10NullFlag
	 */
	public boolean isResult10NullFlag() {
		return result10NullFlag;
	}


	/**
	 * @param result10NullFlag セットする result10NullFlag
	 */
	public void setResult10NullFlag(boolean result10NullFlag) {
		this.result10NullFlag = result10NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult11を設定
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
	 * TRdmHcoReqEntity.javaresult11NullFlagを設定
	 * @return result11NullFlag
	 */
	public boolean isResult11NullFlag() {
		return result11NullFlag;
	}


	/**
	 * @param result11NullFlag セットする result11NullFlag
	 */
	public void setResult11NullFlag(boolean result11NullFlag) {
		this.result11NullFlag = result11NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult12を設定
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
	 * TRdmHcoReqEntity.javaresult12NullFlagを設定
	 * @return result12NullFlag
	 */
	public boolean isResult12NullFlag() {
		return result12NullFlag;
	}


	/**
	 * @param result12NullFlag セットする result12NullFlag
	 */
	public void setResult12NullFlag(boolean result12NullFlag) {
		this.result12NullFlag = result12NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult13を設定
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
	 * TRdmHcoReqEntity.javaresult13NullFlagを設定
	 * @return result13NullFlag
	 */
	public boolean isResult13NullFlag() {
		return result13NullFlag;
	}


	/**
	 * @param result13NullFlag セットする result13NullFlag
	 */
	public void setResult13NullFlag(boolean result13NullFlag) {
		this.result13NullFlag = result13NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult14を設定
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
	 * TRdmHcoReqEntity.javaresult14NullFlagを設定
	 * @return result14NullFlag
	 */
	public boolean isResult14NullFlag() {
		return result14NullFlag;
	}


	/**
	 * @param result14NullFlag セットする result14NullFlag
	 */
	public void setResult14NullFlag(boolean result14NullFlag) {
		this.result14NullFlag = result14NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult15を設定
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
	 * TRdmHcoReqEntity.javaresult15NullFlagを設定
	 * @return result15NullFlag
	 */
	public boolean isResult15NullFlag() {
		return result15NullFlag;
	}


	/**
	 * @param result15NullFlag セットする result15NullFlag
	 */
	public void setResult15NullFlag(boolean result15NullFlag) {
		this.result15NullFlag = result15NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult16を設定
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
	 * TRdmHcoReqEntity.javaresult16NullFlagを設定
	 * @return result16NullFlag
	 */
	public boolean isResult16NullFlag() {
		return result16NullFlag;
	}


	/**
	 * @param result16NullFlag セットする result16NullFlag
	 */
	public void setResult16NullFlag(boolean result16NullFlag) {
		this.result16NullFlag = result16NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult17を設定
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
	 * TRdmHcoReqEntity.javaresult17NullFlagを設定
	 * @return result17NullFlag
	 */
	public boolean isResult17NullFlag() {
		return result17NullFlag;
	}


	/**
	 * @param result17NullFlag セットする result17NullFlag
	 */
	public void setResult17NullFlag(boolean result17NullFlag) {
		this.result17NullFlag = result17NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult18を設定
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
	 * TRdmHcoReqEntity.javaresult18NullFlagを設定
	 * @return result18NullFlag
	 */
	public boolean isResult18NullFlag() {
		return result18NullFlag;
	}


	/**
	 * @param result18NullFlag セットする result18NullFlag
	 */
	public void setResult18NullFlag(boolean result18NullFlag) {
		this.result18NullFlag = result18NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult19を設定
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
	 * TRdmHcoReqEntity.javaresult19NullFlagを設定
	 * @return result19NullFlag
	 */
	public boolean isResult19NullFlag() {
		return result19NullFlag;
	}


	/**
	 * @param result19NullFlag セットする result19NullFlag
	 */
	public void setResult19NullFlag(boolean result19NullFlag) {
		this.result19NullFlag = result19NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult20を設定
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
	 * TRdmHcoReqEntity.javaresult20NullFlagを設定
	 * @return result20NullFlag
	 */
	public boolean isResult20NullFlag() {
		return result20NullFlag;
	}


	/**
	 * @param result20NullFlag セットする result20NullFlag
	 */
	public void setResult20NullFlag(boolean result20NullFlag) {
		this.result20NullFlag = result20NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult21を設定
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
	 * TRdmHcoReqEntity.javaresult21NullFlagを設定
	 * @return result21NullFlag
	 */
	public boolean isResult21NullFlag() {
		return result21NullFlag;
	}


	/**
	 * @param result21NullFlag セットする result21NullFlag
	 */
	public void setResult21NullFlag(boolean result21NullFlag) {
		this.result21NullFlag = result21NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult22を設定
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
	 * TRdmHcoReqEntity.javaresult22NullFlagを設定
	 * @return result22NullFlag
	 */
	public boolean isResult22NullFlag() {
		return result22NullFlag;
	}


	/**
	 * @param result22NullFlag セットする result22NullFlag
	 */
	public void setResult22NullFlag(boolean result22NullFlag) {
		this.result22NullFlag = result22NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult23を設定
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
	 * TRdmHcoReqEntity.javaresult23NullFlagを設定
	 * @return result23NullFlag
	 */
	public boolean isResult23NullFlag() {
		return result23NullFlag;
	}


	/**
	 * @param result23NullFlag セットする result23NullFlag
	 */
	public void setResult23NullFlag(boolean result23NullFlag) {
		this.result23NullFlag = result23NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult24を設定
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
	 * TRdmHcoReqEntity.javaresult24NullFlagを設定
	 * @return result24NullFlag
	 */
	public boolean isResult24NullFlag() {
		return result24NullFlag;
	}


	/**
	 * @param result24NullFlag セットする result24NullFlag
	 */
	public void setResult24NullFlag(boolean result24NullFlag) {
		this.result24NullFlag = result24NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult25を設定
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
	 * TRdmHcoReqEntity.javaresult25NullFlagを設定
	 * @return result25NullFlag
	 */
	public boolean isResult25NullFlag() {
		return result25NullFlag;
	}


	/**
	 * @param result25NullFlag セットする result25NullFlag
	 */
	public void setResult25NullFlag(boolean result25NullFlag) {
		this.result25NullFlag = result25NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult26を設定
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
	 * TRdmHcoReqEntity.javaresult26NullFlagを設定
	 * @return result26NullFlag
	 */
	public boolean isResult26NullFlag() {
		return result26NullFlag;
	}


	/**
	 * @param result26NullFlag セットする result26NullFlag
	 */
	public void setResult26NullFlag(boolean result26NullFlag) {
		this.result26NullFlag = result26NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult27を設定
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
	 * TRdmHcoReqEntity.javaresult27NullFlagを設定
	 * @return result27NullFlag
	 */
	public boolean isResult27NullFlag() {
		return result27NullFlag;
	}


	/**
	 * @param result27NullFlag セットする result27NullFlag
	 */
	public void setResult27NullFlag(boolean result27NullFlag) {
		this.result27NullFlag = result27NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult28を設定
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
	 * TRdmHcoReqEntity.javaresult28NullFlagを設定
	 * @return result28NullFlag
	 */
	public boolean isResult28NullFlag() {
		return result28NullFlag;
	}


	/**
	 * @param result28NullFlag セットする result28NullFlag
	 */
	public void setResult28NullFlag(boolean result28NullFlag) {
		this.result28NullFlag = result28NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult29を設定
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
	 * TRdmHcoReqEntity.javaresult29NullFlagを設定
	 * @return result29NullFlag
	 */
	public boolean isResult29NullFlag() {
		return result29NullFlag;
	}


	/**
	 * @param result29NullFlag セットする result29NullFlag
	 */
	public void setResult29NullFlag(boolean result29NullFlag) {
		this.result29NullFlag = result29NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult30を設定
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
	 * TRdmHcoReqEntity.javaresult30NullFlagを設定
	 * @return result30NullFlag
	 */
	public boolean isResult30NullFlag() {
		return result30NullFlag;
	}


	/**
	 * @param result30NullFlag セットする result30NullFlag
	 */
	public void setResult30NullFlag(boolean result30NullFlag) {
		this.result30NullFlag = result30NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult31を設定
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
	 * TRdmHcoReqEntity.javaresult31NullFlagを設定
	 * @return result31NullFlag
	 */
	public boolean isResult31NullFlag() {
		return result31NullFlag;
	}


	/**
	 * @param result31NullFlag セットする result31NullFlag
	 */
	public void setResult31NullFlag(boolean result31NullFlag) {
		this.result31NullFlag = result31NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult32を設定
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
	 * TRdmHcoReqEntity.javaresult32NullFlagを設定
	 * @return result32NullFlag
	 */
	public boolean isResult32NullFlag() {
		return result32NullFlag;
	}


	/**
	 * @param result32NullFlag セットする result32NullFlag
	 */
	public void setResult32NullFlag(boolean result32NullFlag) {
		this.result32NullFlag = result32NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult33を設定
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
	 * TRdmHcoReqEntity.javaresult33NullFlagを設定
	 * @return result33NullFlag
	 */
	public boolean isResult33NullFlag() {
		return result33NullFlag;
	}


	/**
	 * @param result33NullFlag セットする result33NullFlag
	 */
	public void setResult33NullFlag(boolean result33NullFlag) {
		this.result33NullFlag = result33NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult34を設定
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
	 * TRdmHcoReqEntity.javaresult34NullFlagを設定
	 * @return result34NullFlag
	 */
	public boolean isResult34NullFlag() {
		return result34NullFlag;
	}


	/**
	 * @param result34NullFlag セットする result34NullFlag
	 */
	public void setResult34NullFlag(boolean result34NullFlag) {
		this.result34NullFlag = result34NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult35を設定
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
	 * TRdmHcoReqEntity.javaresult35NullFlagを設定
	 * @return result35NullFlag
	 */
	public boolean isResult35NullFlag() {
		return result35NullFlag;
	}


	/**
	 * @param result35NullFlag セットする result35NullFlag
	 */
	public void setResult35NullFlag(boolean result35NullFlag) {
		this.result35NullFlag = result35NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaresult36を設定
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
	 * TRdmHcoReqEntity.javaresult36NullFlagを設定
	 * @return result36NullFlag
	 */
	public boolean isResult36NullFlag() {
		return result36NullFlag;
	}


	/**
	 * @param result36NullFlag セットする result36NullFlag
	 */
	public void setResult36NullFlag(boolean result36NullFlag) {
		this.result36NullFlag = result36NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaequip01を設定
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
	 * TRdmHcoReqEntity.javaequip01NullFlagを設定
	 * @return equip01NullFlag
	 */
	public boolean isEquip01NullFlag() {
		return equip01NullFlag;
	}


	/**
	 * @param equip01NullFlag セットする equip01NullFlag
	 */
	public void setEquip01NullFlag(boolean equip01NullFlag) {
		this.equip01NullFlag = equip01NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaequip02を設定
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
	 * TRdmHcoReqEntity.javaequip02NullFlagを設定
	 * @return equip02NullFlag
	 */
	public boolean isEquip02NullFlag() {
		return equip02NullFlag;
	}


	/**
	 * @param equip02NullFlag セットする equip02NullFlag
	 */
	public void setEquip02NullFlag(boolean equip02NullFlag) {
		this.equip02NullFlag = equip02NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaequip03を設定
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
	 * TRdmHcoReqEntity.javaequip03NullFlagを設定
	 * @return equip03NullFlag
	 */
	public boolean isEquip03NullFlag() {
		return equip03NullFlag;
	}


	/**
	 * @param equip03NullFlag セットする equip03NullFlag
	 */
	public void setEquip03NullFlag(boolean equip03NullFlag) {
		this.equip03NullFlag = equip03NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaequip07を設定
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
	 * TRdmHcoReqEntity.javaequip07NullFlagを設定
	 * @return equip07NullFlag
	 */
	public boolean isEquip07NullFlag() {
		return equip07NullFlag;
	}


	/**
	 * @param equip07NullFlag セットする equip07NullFlag
	 */
	public void setEquip07NullFlag(boolean equip07NullFlag) {
		this.equip07NullFlag = equip07NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaequip09を設定
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
	 * TRdmHcoReqEntity.javaequip09NullFlagを設定
	 * @return equip09NullFlag
	 */
	public boolean isEquip09NullFlag() {
		return equip09NullFlag;
	}


	/**
	 * @param equip09NullFlag セットする equip09NullFlag
	 */
	public void setEquip09NullFlag(boolean equip09NullFlag) {
		this.equip09NullFlag = equip09NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamarket01を設定
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
	 * TRdmHcoReqEntity.javamarket01NullFlagを設定
	 * @return market01NullFlag
	 */
	public boolean isMarket01NullFlag() {
		return market01NullFlag;
	}


	/**
	 * @param market01NullFlag セットする market01NullFlag
	 */
	public void setMarket01NullFlag(boolean market01NullFlag) {
		this.market01NullFlag = market01NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamarket02を設定
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
	 * TRdmHcoReqEntity.javamarket02NullFlagを設定
	 * @return market02NullFlag
	 */
	public boolean isMarket02NullFlag() {
		return market02NullFlag;
	}


	/**
	 * @param market02NullFlag セットする market02NullFlag
	 */
	public void setMarket02NullFlag(boolean market02NullFlag) {
		this.market02NullFlag = market02NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamarket03を設定
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
	 * TRdmHcoReqEntity.javamarket03NullFlagを設定
	 * @return market03NullFlag
	 */
	public boolean isMarket03NullFlag() {
		return market03NullFlag;
	}


	/**
	 * @param market03NullFlag セットする market03NullFlag
	 */
	public void setMarket03NullFlag(boolean market03NullFlag) {
		this.market03NullFlag = market03NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamarket04を設定
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
	 * TRdmHcoReqEntity.javamarket04NullFlagを設定
	 * @return market04NullFlag
	 */
	public boolean isMarket04NullFlag() {
		return market04NullFlag;
	}


	/**
	 * @param market04NullFlag セットする market04NullFlag
	 */
	public void setMarket04NullFlag(boolean market04NullFlag) {
		this.market04NullFlag = market04NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamarket06を設定
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
	 * TRdmHcoReqEntity.javamarket06NullFlagを設定
	 * @return market06NullFlag
	 */
	public boolean isMarket06NullFlag() {
		return market06NullFlag;
	}


	/**
	 * @param market06NullFlag セットする market06NullFlag
	 */
	public void setMarket06NullFlag(boolean market06NullFlag) {
		this.market06NullFlag = market06NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamarket07を設定
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
	 * TRdmHcoReqEntity.javamarket07NullFlagを設定
	 * @return market07NullFlag
	 */
	public boolean isMarket07NullFlag() {
		return market07NullFlag;
	}


	/**
	 * @param market07NullFlag セットする market07NullFlag
	 */
	public void setMarket07NullFlag(boolean market07NullFlag) {
		this.market07NullFlag = market07NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamarket09を設定
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
	 * TRdmHcoReqEntity.javamarket09NullFlagを設定
	 * @return market09NullFlag
	 */
	public boolean isMarket09NullFlag() {
		return market09NullFlag;
	}


	/**
	 * @param market09NullFlag セットする market09NullFlag
	 */
	public void setMarket09NullFlag(boolean market09NullFlag) {
		this.market09NullFlag = market09NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javamedical12を設定
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
	 * TRdmHcoReqEntity.javamedical12NullFlagを設定
	 * @return medical12NullFlag
	 */
	public boolean isMedical12NullFlag() {
		return medical12NullFlag;
	}


	/**
	 * @param medical12NullFlag セットする medical12NullFlag
	 */
	public void setMedical12NullFlag(boolean medical12NullFlag) {
		this.medical12NullFlag = medical12NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc01を設定
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
	 * TRdmHcoReqEntity.javaspfunc01NullFlagを設定
	 * @return spfunc01NullFlag
	 */
	public boolean isSpfunc01NullFlag() {
		return spfunc01NullFlag;
	}


	/**
	 * @param spfunc01NullFlag セットする spfunc01NullFlag
	 */
	public void setSpfunc01NullFlag(boolean spfunc01NullFlag) {
		this.spfunc01NullFlag = spfunc01NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc02を設定
	 * @return spfunc02
	 */
	public String getSpfunc02() {
		return spfunc02;
	}


	/**
	 * @param spfunc02 セットする spfunc02
	 */
	public void setSpfunc02(String spfunc02) {
		this.spfunc02 = spfunc02;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc02NullFlagを設定
	 * @return spfunc02NullFlag
	 */
	public boolean isSpfunc02NullFlag() {
		return spfunc02NullFlag;
	}


	/**
	 * @param spfunc02NullFlag セットする spfunc02NullFlag
	 */
	public void setSpfunc02NullFlag(boolean spfunc02NullFlag) {
		this.spfunc02NullFlag = spfunc02NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc03を設定
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
	 * TRdmHcoReqEntity.javaspfunc03NullFlagを設定
	 * @return spfunc03NullFlag
	 */
	public boolean isSpfunc03NullFlag() {
		return spfunc03NullFlag;
	}


	/**
	 * @param spfunc03NullFlag セットする spfunc03NullFlag
	 */
	public void setSpfunc03NullFlag(boolean spfunc03NullFlag) {
		this.spfunc03NullFlag = spfunc03NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc04を設定
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
	 * TRdmHcoReqEntity.javaspfunc04NullFlagを設定
	 * @return spfunc04NullFlag
	 */
	public boolean isSpfunc04NullFlag() {
		return spfunc04NullFlag;
	}


	/**
	 * @param spfunc04NullFlag セットする spfunc04NullFlag
	 */
	public void setSpfunc04NullFlag(boolean spfunc04NullFlag) {
		this.spfunc04NullFlag = spfunc04NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc05を設定
	 * @return spfunc05
	 */
	public String getSpfunc05() {
		return spfunc05;
	}


	/**
	 * @param spfunc05 セットする spfunc05
	 */
	public void setSpfunc05(String spfunc05) {
		this.spfunc05 = spfunc05;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc05NullFlagを設定
	 * @return spfunc05NullFlag
	 */
	public boolean isSpfunc05NullFlag() {
		return spfunc05NullFlag;
	}


	/**
	 * @param spfunc05NullFlag セットする spfunc05NullFlag
	 */
	public void setSpfunc05NullFlag(boolean spfunc05NullFlag) {
		this.spfunc05NullFlag = spfunc05NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc06を設定
	 * @return spfunc06
	 */
	public String getSpfunc06() {
		return spfunc06;
	}


	/**
	 * @param spfunc06 セットする spfunc06
	 */
	public void setSpfunc06(String spfunc06) {
		this.spfunc06 = spfunc06;
	}


	/**
	 * TRdmHcoReqEntity.javaspfunc06NullFlagを設定
	 * @return spfunc06NullFlag
	 */
	public boolean isSpfunc06NullFlag() {
		return spfunc06NullFlag;
	}


	/**
	 * @param spfunc06NullFlag セットする spfunc06NullFlag
	 */
	public void setSpfunc06NullFlag(boolean spfunc06NullFlag) {
		this.spfunc06NullFlag = spfunc06NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javatieup05を設定
	 * @return tieup05
	 */
	public String getTieup05() {
		return tieup05;
	}


	/**
	 * @param tieup05 セットする tieup05
	 */
	public void setTieup05(String tieup05) {
		this.tieup05 = tieup05;
	}


	/**
	 * TRdmHcoReqEntity.javatieup05NullFlagを設定
	 * @return tieup05NullFlag
	 */
	public boolean isTieup05NullFlag() {
		return tieup05NullFlag;
	}


	/**
	 * @param tieup05NullFlag セットする tieup05NullFlag
	 */
	public void setTieup05NullFlag(boolean tieup05NullFlag) {
		this.tieup05NullFlag = tieup05NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javatieup08を設定
	 * @return tieup08
	 */
	public String getTieup08() {
		return tieup08;
	}


	/**
	 * @param tieup08 セットする tieup08
	 */
	public void setTieup08(String tieup08) {
		this.tieup08 = tieup08;
	}


	/**
	 * TRdmHcoReqEntity.javatieup08NullFlagを設定
	 * @return tieup08NullFlag
	 */
	public boolean isTieup08NullFlag() {
		return tieup08NullFlag;
	}


	/**
	 * @param tieup08NullFlag セットする tieup08NullFlag
	 */
	public void setTieup08NullFlag(boolean tieup08NullFlag) {
		this.tieup08NullFlag = tieup08NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javatieup09を設定
	 * @return tieup09
	 */
	public String getTieup09() {
		return tieup09;
	}


	/**
	 * @param tieup09 セットする tieup09
	 */
	public void setTieup09(String tieup09) {
		this.tieup09 = tieup09;
	}


	/**
	 * TRdmHcoReqEntity.javatieup09NullFlagを設定
	 * @return tieup09NullFlag
	 */
	public boolean isTieup09NullFlag() {
		return tieup09NullFlag;
	}


	/**
	 * @param tieup09NullFlag セットする tieup09NullFlag
	 */
	public void setTieup09NullFlag(boolean tieup09NullFlag) {
		this.tieup09NullFlag = tieup09NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javatieup10を設定
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
	 * TRdmHcoReqEntity.javatieup10NullFlagを設定
	 * @return tieup10NullFlag
	 */
	public boolean isTieup10NullFlag() {
		return tieup10NullFlag;
	}


	/**
	 * @param tieup10NullFlag セットする tieup10NullFlag
	 */
	public void setTieup10NullFlag(boolean tieup10NullFlag) {
		this.tieup10NullFlag = tieup10NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javatieup11を設定
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
	 * TRdmHcoReqEntity.javatieup11NullFlagを設定
	 * @return tieup11NullFlag
	 */
	public boolean isTieup11NullFlag() {
		return tieup11NullFlag;
	}


	/**
	 * @param tieup11NullFlag セットする tieup11NullFlag
	 */
	public void setTieup11NullFlag(boolean tieup11NullFlag) {
		this.tieup11NullFlag = tieup11NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javatieup12を設定
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
	 * TRdmHcoReqEntity.javatieup12NullFlagを設定
	 * @return tieup12NullFlag
	 */
	public boolean isTieup12NullFlag() {
		return tieup12NullFlag;
	}


	/**
	 * @param tieup12NullFlag セットする tieup12NullFlag
	 */
	public void setTieup12NullFlag(boolean tieup12NullFlag) {
		this.tieup12NullFlag = tieup12NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javatieup13を設定
	 * @return tieup13
	 */
	public String getTieup13() {
		return tieup13;
	}


	/**
	 * @param tieup13 セットする tieup13
	 */
	public void setTieup13(String tieup13) {
		this.tieup13 = tieup13;
	}


	/**
	 * TRdmHcoReqEntity.javatieup13NullFlagを設定
	 * @return tieup13NullFlag
	 */
	public boolean isTieup13NullFlag() {
		return tieup13NullFlag;
	}


	/**
	 * @param tieup13NullFlag セットする tieup13NullFlag
	 */
	public void setTieup13NullFlag(boolean tieup13NullFlag) {
		this.tieup13NullFlag = tieup13NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0001を設定
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
	 * TRdmHcoReqEntity.javausercd0001NullFlagを設定
	 * @return usercd0001NullFlag
	 */
	public boolean isUsercd0001NullFlag() {
		return usercd0001NullFlag;
	}


	/**
	 * @param usercd0001NullFlag セットする usercd0001NullFlag
	 */
	public void setUsercd0001NullFlag(boolean usercd0001NullFlag) {
		this.usercd0001NullFlag = usercd0001NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0002を設定
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
	 * TRdmHcoReqEntity.javausercd0002NullFlagを設定
	 * @return usercd0002NullFlag
	 */
	public boolean isUsercd0002NullFlag() {
		return usercd0002NullFlag;
	}


	/**
	 * @param usercd0002NullFlag セットする usercd0002NullFlag
	 */
	public void setUsercd0002NullFlag(boolean usercd0002NullFlag) {
		this.usercd0002NullFlag = usercd0002NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0003を設定
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
	 * TRdmHcoReqEntity.javausercd0003NullFlagを設定
	 * @return usercd0003NullFlag
	 */
	public boolean isUsercd0003NullFlag() {
		return usercd0003NullFlag;
	}


	/**
	 * @param usercd0003NullFlag セットする usercd0003NullFlag
	 */
	public void setUsercd0003NullFlag(boolean usercd0003NullFlag) {
		this.usercd0003NullFlag = usercd0003NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0004を設定
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
	 * TRdmHcoReqEntity.javausercd0004NullFlagを設定
	 * @return usercd0004NullFlag
	 */
	public boolean isUsercd0004NullFlag() {
		return usercd0004NullFlag;
	}


	/**
	 * @param usercd0004NullFlag セットする usercd0004NullFlag
	 */
	public void setUsercd0004NullFlag(boolean usercd0004NullFlag) {
		this.usercd0004NullFlag = usercd0004NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0005を設定
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
	 * TRdmHcoReqEntity.javausercd0005NullFlagを設定
	 * @return usercd0005NullFlag
	 */
	public boolean isUsercd0005NullFlag() {
		return usercd0005NullFlag;
	}


	/**
	 * @param usercd0005NullFlag セットする usercd0005NullFlag
	 */
	public void setUsercd0005NullFlag(boolean usercd0005NullFlag) {
		this.usercd0005NullFlag = usercd0005NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0006を設定
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
	 * TRdmHcoReqEntity.javausercd0006NullFlagを設定
	 * @return usercd0006NullFlag
	 */
	public boolean isUsercd0006NullFlag() {
		return usercd0006NullFlag;
	}


	/**
	 * @param usercd0006NullFlag セットする usercd0006NullFlag
	 */
	public void setUsercd0006NullFlag(boolean usercd0006NullFlag) {
		this.usercd0006NullFlag = usercd0006NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0007を設定
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
	 * TRdmHcoReqEntity.javausercd0007NullFlagを設定
	 * @return usercd0007NullFlag
	 */
	public boolean isUsercd0007NullFlag() {
		return usercd0007NullFlag;
	}


	/**
	 * @param usercd0007NullFlag セットする usercd0007NullFlag
	 */
	public void setUsercd0007NullFlag(boolean usercd0007NullFlag) {
		this.usercd0007NullFlag = usercd0007NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0008を設定
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
	 * TRdmHcoReqEntity.javausercd0008NullFlagを設定
	 * @return usercd0008NullFlag
	 */
	public boolean isUsercd0008NullFlag() {
		return usercd0008NullFlag;
	}


	/**
	 * @param usercd0008NullFlag セットする usercd0008NullFlag
	 */
	public void setUsercd0008NullFlag(boolean usercd0008NullFlag) {
		this.usercd0008NullFlag = usercd0008NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0009を設定
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
	 * TRdmHcoReqEntity.javausercd0009NullFlagを設定
	 * @return usercd0009NullFlag
	 */
	public boolean isUsercd0009NullFlag() {
		return usercd0009NullFlag;
	}


	/**
	 * @param usercd0009NullFlag セットする usercd0009NullFlag
	 */
	public void setUsercd0009NullFlag(boolean usercd0009NullFlag) {
		this.usercd0009NullFlag = usercd0009NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0010を設定
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
	 * TRdmHcoReqEntity.javausercd0010NullFlagを設定
	 * @return usercd0010NullFlag
	 */
	public boolean isUsercd0010NullFlag() {
		return usercd0010NullFlag;
	}


	/**
	 * @param usercd0010NullFlag セットする usercd0010NullFlag
	 */
	public void setUsercd0010NullFlag(boolean usercd0010NullFlag) {
		this.usercd0010NullFlag = usercd0010NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0011を設定
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
	 * TRdmHcoReqEntity.javausercd0011NullFlagを設定
	 * @return usercd0011NullFlag
	 */
	public boolean isUsercd0011NullFlag() {
		return usercd0011NullFlag;
	}


	/**
	 * @param usercd0011NullFlag セットする usercd0011NullFlag
	 */
	public void setUsercd0011NullFlag(boolean usercd0011NullFlag) {
		this.usercd0011NullFlag = usercd0011NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0012を設定
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
	 * TRdmHcoReqEntity.javausercd0012NullFlagを設定
	 * @return usercd0012NullFlag
	 */
	public boolean isUsercd0012NullFlag() {
		return usercd0012NullFlag;
	}


	/**
	 * @param usercd0012NullFlag セットする usercd0012NullFlag
	 */
	public void setUsercd0012NullFlag(boolean usercd0012NullFlag) {
		this.usercd0012NullFlag = usercd0012NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0013を設定
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
	 * TRdmHcoReqEntity.javausercd0013NullFlagを設定
	 * @return usercd0013NullFlag
	 */
	public boolean isUsercd0013NullFlag() {
		return usercd0013NullFlag;
	}


	/**
	 * @param usercd0013NullFlag セットする usercd0013NullFlag
	 */
	public void setUsercd0013NullFlag(boolean usercd0013NullFlag) {
		this.usercd0013NullFlag = usercd0013NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0014を設定
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
	 * TRdmHcoReqEntity.javausercd0014NullFlagを設定
	 * @return usercd0014NullFlag
	 */
	public boolean isUsercd0014NullFlag() {
		return usercd0014NullFlag;
	}


	/**
	 * @param usercd0014NullFlag セットする usercd0014NullFlag
	 */
	public void setUsercd0014NullFlag(boolean usercd0014NullFlag) {
		this.usercd0014NullFlag = usercd0014NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0015を設定
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
	 * TRdmHcoReqEntity.javausercd0015NullFlagを設定
	 * @return usercd0015NullFlag
	 */
	public boolean isUsercd0015NullFlag() {
		return usercd0015NullFlag;
	}


	/**
	 * @param usercd0015NullFlag セットする usercd0015NullFlag
	 */
	public void setUsercd0015NullFlag(boolean usercd0015NullFlag) {
		this.usercd0015NullFlag = usercd0015NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0016を設定
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
	 * TRdmHcoReqEntity.javausercd0016NullFlagを設定
	 * @return usercd0016NullFlag
	 */
	public boolean isUsercd0016NullFlag() {
		return usercd0016NullFlag;
	}


	/**
	 * @param usercd0016NullFlag セットする usercd0016NullFlag
	 */
	public void setUsercd0016NullFlag(boolean usercd0016NullFlag) {
		this.usercd0016NullFlag = usercd0016NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0017を設定
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
	 * TRdmHcoReqEntity.javausercd0017NullFlagを設定
	 * @return usercd0017NullFlag
	 */
	public boolean isUsercd0017NullFlag() {
		return usercd0017NullFlag;
	}


	/**
	 * @param usercd0017NullFlag セットする usercd0017NullFlag
	 */
	public void setUsercd0017NullFlag(boolean usercd0017NullFlag) {
		this.usercd0017NullFlag = usercd0017NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0018を設定
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
	 * TRdmHcoReqEntity.javausercd0018NullFlagを設定
	 * @return usercd0018NullFlag
	 */
	public boolean isUsercd0018NullFlag() {
		return usercd0018NullFlag;
	}


	/**
	 * @param usercd0018NullFlag セットする usercd0018NullFlag
	 */
	public void setUsercd0018NullFlag(boolean usercd0018NullFlag) {
		this.usercd0018NullFlag = usercd0018NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0019を設定
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
	 * TRdmHcoReqEntity.javausercd0019NullFlagを設定
	 * @return usercd0019NullFlag
	 */
	public boolean isUsercd0019NullFlag() {
		return usercd0019NullFlag;
	}


	/**
	 * @param usercd0019NullFlag セットする usercd0019NullFlag
	 */
	public void setUsercd0019NullFlag(boolean usercd0019NullFlag) {
		this.usercd0019NullFlag = usercd0019NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0020を設定
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
	 * TRdmHcoReqEntity.javausercd0020NullFlagを設定
	 * @return usercd0020NullFlag
	 */
	public boolean isUsercd0020NullFlag() {
		return usercd0020NullFlag;
	}


	/**
	 * @param usercd0020NullFlag セットする usercd0020NullFlag
	 */
	public void setUsercd0020NullFlag(boolean usercd0020NullFlag) {
		this.usercd0020NullFlag = usercd0020NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0021を設定
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
	 * TRdmHcoReqEntity.javausercd0021NullFlagを設定
	 * @return usercd0021NullFlag
	 */
	public boolean isUsercd0021NullFlag() {
		return usercd0021NullFlag;
	}


	/**
	 * @param usercd0021NullFlag セットする usercd0021NullFlag
	 */
	public void setUsercd0021NullFlag(boolean usercd0021NullFlag) {
		this.usercd0021NullFlag = usercd0021NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0022を設定
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
	 * TRdmHcoReqEntity.javausercd0022NullFlagを設定
	 * @return usercd0022NullFlag
	 */
	public boolean isUsercd0022NullFlag() {
		return usercd0022NullFlag;
	}


	/**
	 * @param usercd0022NullFlag セットする usercd0022NullFlag
	 */
	public void setUsercd0022NullFlag(boolean usercd0022NullFlag) {
		this.usercd0022NullFlag = usercd0022NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0023を設定
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
	 * TRdmHcoReqEntity.javausercd0023NullFlagを設定
	 * @return usercd0023NullFlag
	 */
	public boolean isUsercd0023NullFlag() {
		return usercd0023NullFlag;
	}


	/**
	 * @param usercd0023NullFlag セットする usercd0023NullFlag
	 */
	public void setUsercd0023NullFlag(boolean usercd0023NullFlag) {
		this.usercd0023NullFlag = usercd0023NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0024を設定
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
	 * TRdmHcoReqEntity.javausercd0024NullFlagを設定
	 * @return usercd0024NullFlag
	 */
	public boolean isUsercd0024NullFlag() {
		return usercd0024NullFlag;
	}


	/**
	 * @param usercd0024NullFlag セットする usercd0024NullFlag
	 */
	public void setUsercd0024NullFlag(boolean usercd0024NullFlag) {
		this.usercd0024NullFlag = usercd0024NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0025を設定
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
	 * TRdmHcoReqEntity.javausercd0025NullFlagを設定
	 * @return usercd0025NullFlag
	 */
	public boolean isUsercd0025NullFlag() {
		return usercd0025NullFlag;
	}


	/**
	 * @param usercd0025NullFlag セットする usercd0025NullFlag
	 */
	public void setUsercd0025NullFlag(boolean usercd0025NullFlag) {
		this.usercd0025NullFlag = usercd0025NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0026を設定
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
	 * TRdmHcoReqEntity.javausercd0026NullFlagを設定
	 * @return usercd0026NullFlag
	 */
	public boolean isUsercd0026NullFlag() {
		return usercd0026NullFlag;
	}


	/**
	 * @param usercd0026NullFlag セットする usercd0026NullFlag
	 */
	public void setUsercd0026NullFlag(boolean usercd0026NullFlag) {
		this.usercd0026NullFlag = usercd0026NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0027を設定
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
	 * TRdmHcoReqEntity.javausercd0027NullFlagを設定
	 * @return usercd0027NullFlag
	 */
	public boolean isUsercd0027NullFlag() {
		return usercd0027NullFlag;
	}


	/**
	 * @param usercd0027NullFlag セットする usercd0027NullFlag
	 */
	public void setUsercd0027NullFlag(boolean usercd0027NullFlag) {
		this.usercd0027NullFlag = usercd0027NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0028を設定
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
	 * TRdmHcoReqEntity.javausercd0028NullFlagを設定
	 * @return usercd0028NullFlag
	 */
	public boolean isUsercd0028NullFlag() {
		return usercd0028NullFlag;
	}


	/**
	 * @param usercd0028NullFlag セットする usercd0028NullFlag
	 */
	public void setUsercd0028NullFlag(boolean usercd0028NullFlag) {
		this.usercd0028NullFlag = usercd0028NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0029を設定
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
	 * TRdmHcoReqEntity.javausercd0029NullFlagを設定
	 * @return usercd0029NullFlag
	 */
	public boolean isUsercd0029NullFlag() {
		return usercd0029NullFlag;
	}


	/**
	 * @param usercd0029NullFlag セットする usercd0029NullFlag
	 */
	public void setUsercd0029NullFlag(boolean usercd0029NullFlag) {
		this.usercd0029NullFlag = usercd0029NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0030を設定
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
	 * TRdmHcoReqEntity.javausercd0030NullFlagを設定
	 * @return usercd0030NullFlag
	 */
	public boolean isUsercd0030NullFlag() {
		return usercd0030NullFlag;
	}


	/**
	 * @param usercd0030NullFlag セットする usercd0030NullFlag
	 */
	public void setUsercd0030NullFlag(boolean usercd0030NullFlag) {
		this.usercd0030NullFlag = usercd0030NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0031を設定
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
	 * TRdmHcoReqEntity.javausercd0031NullFlagを設定
	 * @return usercd0031NullFlag
	 */
	public boolean isUsercd0031NullFlag() {
		return usercd0031NullFlag;
	}


	/**
	 * @param usercd0031NullFlag セットする usercd0031NullFlag
	 */
	public void setUsercd0031NullFlag(boolean usercd0031NullFlag) {
		this.usercd0031NullFlag = usercd0031NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0032を設定
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
	 * TRdmHcoReqEntity.javausercd0032NullFlagを設定
	 * @return usercd0032NullFlag
	 */
	public boolean isUsercd0032NullFlag() {
		return usercd0032NullFlag;
	}


	/**
	 * @param usercd0032NullFlag セットする usercd0032NullFlag
	 */
	public void setUsercd0032NullFlag(boolean usercd0032NullFlag) {
		this.usercd0032NullFlag = usercd0032NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0033を設定
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
	 * TRdmHcoReqEntity.javausercd0033NullFlagを設定
	 * @return usercd0033NullFlag
	 */
	public boolean isUsercd0033NullFlag() {
		return usercd0033NullFlag;
	}


	/**
	 * @param usercd0033NullFlag セットする usercd0033NullFlag
	 */
	public void setUsercd0033NullFlag(boolean usercd0033NullFlag) {
		this.usercd0033NullFlag = usercd0033NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0034を設定
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
	 * TRdmHcoReqEntity.javausercd0034NullFlagを設定
	 * @return usercd0034NullFlag
	 */
	public boolean isUsercd0034NullFlag() {
		return usercd0034NullFlag;
	}


	/**
	 * @param usercd0034NullFlag セットする usercd0034NullFlag
	 */
	public void setUsercd0034NullFlag(boolean usercd0034NullFlag) {
		this.usercd0034NullFlag = usercd0034NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0035を設定
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
	 * TRdmHcoReqEntity.javausercd0035NullFlagを設定
	 * @return usercd0035NullFlag
	 */
	public boolean isUsercd0035NullFlag() {
		return usercd0035NullFlag;
	}


	/**
	 * @param usercd0035NullFlag セットする usercd0035NullFlag
	 */
	public void setUsercd0035NullFlag(boolean usercd0035NullFlag) {
		this.usercd0035NullFlag = usercd0035NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0036を設定
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
	 * TRdmHcoReqEntity.javausercd0036NullFlagを設定
	 * @return usercd0036NullFlag
	 */
	public boolean isUsercd0036NullFlag() {
		return usercd0036NullFlag;
	}


	/**
	 * @param usercd0036NullFlag セットする usercd0036NullFlag
	 */
	public void setUsercd0036NullFlag(boolean usercd0036NullFlag) {
		this.usercd0036NullFlag = usercd0036NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0101を設定
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
	 * TRdmHcoReqEntity.javausercd0101NullFlagを設定
	 * @return usercd0101NullFlag
	 */
	public boolean isUsercd0101NullFlag() {
		return usercd0101NullFlag;
	}


	/**
	 * @param usercd0101NullFlag セットする usercd0101NullFlag
	 */
	public void setUsercd0101NullFlag(boolean usercd0101NullFlag) {
		this.usercd0101NullFlag = usercd0101NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0102を設定
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
	 * TRdmHcoReqEntity.javausercd0102NullFlagを設定
	 * @return usercd0102NullFlag
	 */
	public boolean isUsercd0102NullFlag() {
		return usercd0102NullFlag;
	}


	/**
	 * @param usercd0102NullFlag セットする usercd0102NullFlag
	 */
	public void setUsercd0102NullFlag(boolean usercd0102NullFlag) {
		this.usercd0102NullFlag = usercd0102NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0103を設定
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
	 * TRdmHcoReqEntity.javausercd0103NullFlagを設定
	 * @return usercd0103NullFlag
	 */
	public boolean isUsercd0103NullFlag() {
		return usercd0103NullFlag;
	}


	/**
	 * @param usercd0103NullFlag セットする usercd0103NullFlag
	 */
	public void setUsercd0103NullFlag(boolean usercd0103NullFlag) {
		this.usercd0103NullFlag = usercd0103NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0104を設定
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
	 * TRdmHcoReqEntity.javausercd0104NullFlagを設定
	 * @return usercd0104NullFlag
	 */
	public boolean isUsercd0104NullFlag() {
		return usercd0104NullFlag;
	}


	/**
	 * @param usercd0104NullFlag セットする usercd0104NullFlag
	 */
	public void setUsercd0104NullFlag(boolean usercd0104NullFlag) {
		this.usercd0104NullFlag = usercd0104NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0105を設定
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
	 * TRdmHcoReqEntity.javausercd0105NullFlagを設定
	 * @return usercd0105NullFlag
	 */
	public boolean isUsercd0105NullFlag() {
		return usercd0105NullFlag;
	}


	/**
	 * @param usercd0105NullFlag セットする usercd0105NullFlag
	 */
	public void setUsercd0105NullFlag(boolean usercd0105NullFlag) {
		this.usercd0105NullFlag = usercd0105NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0106を設定
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
	 * TRdmHcoReqEntity.javausercd0106NullFlagを設定
	 * @return usercd0106NullFlag
	 */
	public boolean isUsercd0106NullFlag() {
		return usercd0106NullFlag;
	}


	/**
	 * @param usercd0106NullFlag セットする usercd0106NullFlag
	 */
	public void setUsercd0106NullFlag(boolean usercd0106NullFlag) {
		this.usercd0106NullFlag = usercd0106NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0107を設定
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
	 * TRdmHcoReqEntity.javausercd0107NullFlagを設定
	 * @return usercd0107NullFlag
	 */
	public boolean isUsercd0107NullFlag() {
		return usercd0107NullFlag;
	}


	/**
	 * @param usercd0107NullFlag セットする usercd0107NullFlag
	 */
	public void setUsercd0107NullFlag(boolean usercd0107NullFlag) {
		this.usercd0107NullFlag = usercd0107NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0108を設定
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
	 * TRdmHcoReqEntity.javausercd0108NullFlagを設定
	 * @return usercd0108NullFlag
	 */
	public boolean isUsercd0108NullFlag() {
		return usercd0108NullFlag;
	}


	/**
	 * @param usercd0108NullFlag セットする usercd0108NullFlag
	 */
	public void setUsercd0108NullFlag(boolean usercd0108NullFlag) {
		this.usercd0108NullFlag = usercd0108NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0109を設定
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
	 * TRdmHcoReqEntity.javausercd0109NullFlagを設定
	 * @return usercd0109NullFlag
	 */
	public boolean isUsercd0109NullFlag() {
		return usercd0109NullFlag;
	}


	/**
	 * @param usercd0109NullFlag セットする usercd0109NullFlag
	 */
	public void setUsercd0109NullFlag(boolean usercd0109NullFlag) {
		this.usercd0109NullFlag = usercd0109NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0201を設定
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
	 * TRdmHcoReqEntity.javausercd0201NullFlagを設定
	 * @return usercd0201NullFlag
	 */
	public boolean isUsercd0201NullFlag() {
		return usercd0201NullFlag;
	}


	/**
	 * @param usercd0201NullFlag セットする usercd0201NullFlag
	 */
	public void setUsercd0201NullFlag(boolean usercd0201NullFlag) {
		this.usercd0201NullFlag = usercd0201NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0202を設定
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
	 * TRdmHcoReqEntity.javausercd0202NullFlagを設定
	 * @return usercd0202NullFlag
	 */
	public boolean isUsercd0202NullFlag() {
		return usercd0202NullFlag;
	}


	/**
	 * @param usercd0202NullFlag セットする usercd0202NullFlag
	 */
	public void setUsercd0202NullFlag(boolean usercd0202NullFlag) {
		this.usercd0202NullFlag = usercd0202NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0203を設定
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
	 * TRdmHcoReqEntity.javausercd0203NullFlagを設定
	 * @return usercd0203NullFlag
	 */
	public boolean isUsercd0203NullFlag() {
		return usercd0203NullFlag;
	}


	/**
	 * @param usercd0203NullFlag セットする usercd0203NullFlag
	 */
	public void setUsercd0203NullFlag(boolean usercd0203NullFlag) {
		this.usercd0203NullFlag = usercd0203NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0204を設定
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
	 * TRdmHcoReqEntity.javausercd0204NullFlagを設定
	 * @return usercd0204NullFlag
	 */
	public boolean isUsercd0204NullFlag() {
		return usercd0204NullFlag;
	}


	/**
	 * @param usercd0204NullFlag セットする usercd0204NullFlag
	 */
	public void setUsercd0204NullFlag(boolean usercd0204NullFlag) {
		this.usercd0204NullFlag = usercd0204NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0205を設定
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
	 * TRdmHcoReqEntity.javausercd0205NullFlagを設定
	 * @return usercd0205NullFlag
	 */
	public boolean isUsercd0205NullFlag() {
		return usercd0205NullFlag;
	}


	/**
	 * @param usercd0205NullFlag セットする usercd0205NullFlag
	 */
	public void setUsercd0205NullFlag(boolean usercd0205NullFlag) {
		this.usercd0205NullFlag = usercd0205NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javausercd0206を設定
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
	 * TRdmHcoReqEntity.javausercd0206NullFlagを設定
	 * @return usercd0206NullFlag
	 */
	public boolean isUsercd0206NullFlag() {
		return usercd0206NullFlag;
	}


	/**
	 * @param usercd0206NullFlag セットする usercd0206NullFlag
	 */
	public void setUsercd0206NullFlag(boolean usercd0206NullFlag) {
		this.usercd0206NullFlag = usercd0206NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward04を設定
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
	 * TRdmHcoReqEntity.javareward04NullFlagを設定
	 * @return reward04NullFlag
	 */
	public boolean isReward04NullFlag() {
		return reward04NullFlag;
	}


	/**
	 * @param reward04NullFlag セットする reward04NullFlag
	 */
	public void setReward04NullFlag(boolean reward04NullFlag) {
		this.reward04NullFlag = reward04NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward05を設定
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
	 * TRdmHcoReqEntity.javareward05NullFlagを設定
	 * @return reward05NullFlag
	 */
	public boolean isReward05NullFlag() {
		return reward05NullFlag;
	}


	/**
	 * @param reward05NullFlag セットする reward05NullFlag
	 */
	public void setReward05NullFlag(boolean reward05NullFlag) {
		this.reward05NullFlag = reward05NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward08を設定
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
	 * TRdmHcoReqEntity.javareward08NullFlagを設定
	 * @return reward08NullFlag
	 */
	public boolean isReward08NullFlag() {
		return reward08NullFlag;
	}


	/**
	 * @param reward08NullFlag セットする reward08NullFlag
	 */
	public void setReward08NullFlag(boolean reward08NullFlag) {
		this.reward08NullFlag = reward08NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward09を設定
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
	 * TRdmHcoReqEntity.javareward09NullFlagを設定
	 * @return reward09NullFlag
	 */
	public boolean isReward09NullFlag() {
		return reward09NullFlag;
	}


	/**
	 * @param reward09NullFlag セットする reward09NullFlag
	 */
	public void setReward09NullFlag(boolean reward09NullFlag) {
		this.reward09NullFlag = reward09NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward16を設定
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
	 * TRdmHcoReqEntity.javareward16NullFlagを設定
	 * @return reward16NullFlag
	 */
	public boolean isReward16NullFlag() {
		return reward16NullFlag;
	}


	/**
	 * @param reward16NullFlag セットする reward16NullFlag
	 */
	public void setReward16NullFlag(boolean reward16NullFlag) {
		this.reward16NullFlag = reward16NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward17を設定
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
	 * TRdmHcoReqEntity.javareward17NullFlagを設定
	 * @return reward17NullFlag
	 */
	public boolean isReward17NullFlag() {
		return reward17NullFlag;
	}


	/**
	 * @param reward17NullFlag セットする reward17NullFlag
	 */
	public void setReward17NullFlag(boolean reward17NullFlag) {
		this.reward17NullFlag = reward17NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward18を設定
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
	 * TRdmHcoReqEntity.javareward18NullFlagを設定
	 * @return reward18NullFlag
	 */
	public boolean isReward18NullFlag() {
		return reward18NullFlag;
	}


	/**
	 * @param reward18NullFlag セットする reward18NullFlag
	 */
	public void setReward18NullFlag(boolean reward18NullFlag) {
		this.reward18NullFlag = reward18NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward21を設定
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
	 * TRdmHcoReqEntity.javareward21NullFlagを設定
	 * @return reward21NullFlag
	 */
	public boolean isReward21NullFlag() {
		return reward21NullFlag;
	}


	/**
	 * @param reward21NullFlag セットする reward21NullFlag
	 */
	public void setReward21NullFlag(boolean reward21NullFlag) {
		this.reward21NullFlag = reward21NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward23を設定
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
	 * TRdmHcoReqEntity.javareward23NullFlagを設定
	 * @return reward23NullFlag
	 */
	public boolean isReward23NullFlag() {
		return reward23NullFlag;
	}


	/**
	 * @param reward23NullFlag セットする reward23NullFlag
	 */
	public void setReward23NullFlag(boolean reward23NullFlag) {
		this.reward23NullFlag = reward23NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward25を設定
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
	 * TRdmHcoReqEntity.javareward25NullFlagを設定
	 * @return reward25NullFlag
	 */
	public boolean isReward25NullFlag() {
		return reward25NullFlag;
	}


	/**
	 * @param reward25NullFlag セットする reward25NullFlag
	 */
	public void setReward25NullFlag(boolean reward25NullFlag) {
		this.reward25NullFlag = reward25NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward26を設定
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
	 * TRdmHcoReqEntity.javareward26NullFlagを設定
	 * @return reward26NullFlag
	 */
	public boolean isReward26NullFlag() {
		return reward26NullFlag;
	}


	/**
	 * @param reward26NullFlag セットする reward26NullFlag
	 */
	public void setReward26NullFlag(boolean reward26NullFlag) {
		this.reward26NullFlag = reward26NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward27を設定
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
	 * TRdmHcoReqEntity.javareward27NullFlagを設定
	 * @return reward27NullFlag
	 */
	public boolean isReward27NullFlag() {
		return reward27NullFlag;
	}


	/**
	 * @param reward27NullFlag セットする reward27NullFlag
	 */
	public void setReward27NullFlag(boolean reward27NullFlag) {
		this.reward27NullFlag = reward27NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward29を設定
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
	 * TRdmHcoReqEntity.javareward29NullFlagを設定
	 * @return reward29NullFlag
	 */
	public boolean isReward29NullFlag() {
		return reward29NullFlag;
	}


	/**
	 * @param reward29NullFlag セットする reward29NullFlag
	 */
	public void setReward29NullFlag(boolean reward29NullFlag) {
		this.reward29NullFlag = reward29NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward35を設定
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
	 * TRdmHcoReqEntity.javareward35NullFlagを設定
	 * @return reward35NullFlag
	 */
	public boolean isReward35NullFlag() {
		return reward35NullFlag;
	}


	/**
	 * @param reward35NullFlag セットする reward35NullFlag
	 */
	public void setReward35NullFlag(boolean reward35NullFlag) {
		this.reward35NullFlag = reward35NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward36を設定
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
	 * TRdmHcoReqEntity.javareward36NullFlagを設定
	 * @return reward36NullFlag
	 */
	public boolean isReward36NullFlag() {
		return reward36NullFlag;
	}


	/**
	 * @param reward36NullFlag セットする reward36NullFlag
	 */
	public void setReward36NullFlag(boolean reward36NullFlag) {
		this.reward36NullFlag = reward36NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward37を設定
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
	 * TRdmHcoReqEntity.javareward37NullFlagを設定
	 * @return reward37NullFlag
	 */
	public boolean isReward37NullFlag() {
		return reward37NullFlag;
	}


	/**
	 * @param reward37NullFlag セットする reward37NullFlag
	 */
	public void setReward37NullFlag(boolean reward37NullFlag) {
		this.reward37NullFlag = reward37NullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javareward44を設定
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
	 * TRdmHcoReqEntity.javareward44NullFlagを設定
	 * @return reward44NullFlag
	 */
	public boolean isReward44NullFlag() {
		return reward44NullFlag;
	}


	/**
	 * @param reward44NullFlag セットする reward44NullFlag
	 */
	public void setReward44NullFlag(boolean reward44NullFlag) {
		this.reward44NullFlag = reward44NullFlag;
	}

	/**
	 * TRdmHcoReqEntity.javadelKbnを設定
	 * @return delKbn
	 */
	public Integer getDelKbn() {
		return delKbn;
	}


	/**
	 * @param delKbn セットする delKbn
	 */
	public void setDelKbn(Integer delKbn) {
		this.delKbn = delKbn;
	}


	/**
	 * TRdmHcoReqEntity.javadelKbnNullFlagを設定
	 * @return delKbnNullFlag
	 */
	public boolean isDelKbnNullFlag() {
		return delKbnNullFlag;
	}


	/**
	 * @param delKbnNullFlag セットする delKbnNullFlag
	 */
	public void setDelKbnNullFlag(boolean delKbnNullFlag) {
		this.delKbnNullFlag = delKbnNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javadelReasonを設定
	 * @return delReason
	 */
	public String getDelReason() {
		return delReason;
	}


	/**
	 * @param delReason セットする delReason
	 */
	public void setDelReason(String delReason) {
		this.delReason = delReason;
	}


	/**
	 * TRdmHcoReqEntity.javadelReasonNullFlagを設定
	 * @return delReasonNullFlag
	 */
	public boolean isDelReasonNullFlag() {
		return delReasonNullFlag;
	}


	/**
	 * @param delReasonNullFlag セットする delReasonNullFlag
	 */
	public void setDelReasonNullFlag(boolean delReasonNullFlag) {
		this.delReasonNullFlag = delReasonNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javadelYmdを設定
	 * @return delYmd
	 */
	public String getDelYmd() {
		return delYmd;
	}


	/**
	 * @param delYmd セットする delYmd
	 */
	public void setDelYmd(String delYmd) {
		this.delYmd = delYmd;
	}


	/**
	 * TRdmHcoReqEntity.javadelYmdNullFlagを設定
	 * @return delYmdNullFlag
	 */
	public boolean isDelYmdNullFlag() {
		return delYmdNullFlag;
	}


	/**
	 * @param delYmdNullFlag セットする delYmdNullFlag
	 */
	public void setDelYmdNullFlag(boolean delYmdNullFlag) {
		this.delYmdNullFlag = delYmdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javadupInsNoを設定
	 * @return dupInsNo
	 */
	public String getDupInsNo() {
		return dupInsNo;
	}


	/**
	 * @param dupInsNo セットする dupInsNo
	 */
	public void setDupInsNo(String dupInsNo) {
		this.dupInsNo = dupInsNo;
	}


	/**
	 * TRdmHcoReqEntity.javadupInsNoNullFlagを設定
	 * @return dupInsNoNullFlag
	 */
	public boolean isDupInsNoNullFlag() {
		return dupInsNoNullFlag;
	}


	/**
	 * @param dupInsNoNullFlag セットする dupInsNoNullFlag
	 */
	public void setDupInsNoNullFlag(boolean dupInsNoNullFlag) {
		this.dupInsNoNullFlag = dupInsNoNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javarstReasonを設定
	 * @return rstReason
	 */
	public String getRstReason() {
		return rstReason;
	}


	/**
	 * @param rstReason セットする rstReason
	 */
	public void setRstReason(String rstReason) {
		this.rstReason = rstReason;
	}


	/**
	 * TRdmHcoReqEntity.javarstReasonNullFlagを設定
	 * @return rstReasonNullFlag
	 */
	public boolean isRstReasonNullFlag() {
		return rstReasonNullFlag;
	}


	/**
	 * @param rstReasonNullFlag セットする rstReasonNullFlag
	 */
	public void setRstReasonNullFlag(boolean rstReasonNullFlag) {
		this.rstReasonNullFlag = rstReasonNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsShaYmdを設定
	 * @return insShaYmd
	 */
	public Date getInsShaYmd() {
		return insShaYmd;
	}


	/**
	 * @param insShaYmd セットする insShaYmd
	 */
	public void setInsShaYmd(Date insShaYmd) {
		this.insShaYmd = insShaYmd;
	}


	/**
	 * TRdmHcoReqEntity.javainsShaYmdNullFlagを設定
	 * @return insShaYmdNullFlag
	 */
	public boolean isInsShaYmdNullFlag() {
		return insShaYmdNullFlag;
	}


	/**
	 * @param insShaYmdNullFlag セットする insShaYmdNullFlag
	 */
	public void setInsShaYmdNullFlag(boolean insShaYmdNullFlag) {
		this.insShaYmdNullFlag = insShaYmdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javainsShaIdを設定
	 * @return insShaId
	 */
	public String getInsShaId() {
		return insShaId;
	}


	/**
	 * @param insShaId セットする insShaId
	 */
	public void setInsShaId(String insShaId) {
		this.insShaId = insShaId;
	}


	/**
	 * TRdmHcoReqEntity.javainsShaIdNullFlagを設定
	 * @return insShaIdNullFlag
	 */
	public boolean isInsShaIdNullFlag() {
		return insShaIdNullFlag;
	}


	/**
	 * @param insShaIdNullFlag セットする insShaIdNullFlag
	 */
	public void setInsShaIdNullFlag(boolean insShaIdNullFlag) {
		this.insShaIdNullFlag = insShaIdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaupdShaYmdを設定
	 * @return updShaYmd
	 */
	public Date getUpdShaYmd() {
		return updShaYmd;
	}


	/**
	 * @param updShaYmd セットする updShaYmd
	 */
	public void setUpdShaYmd(Date updShaYmd) {
		this.updShaYmd = updShaYmd;
	}


	/**
	 * TRdmHcoReqEntity.javaupdShaYmdNullFlagを設定
	 * @return updShaYmdNullFlag
	 */
	public boolean isUpdShaYmdNullFlag() {
		return updShaYmdNullFlag;
	}


	/**
	 * @param updShaYmdNullFlag セットする updShaYmdNullFlag
	 */
	public void setUpdShaYmdNullFlag(boolean updShaYmdNullFlag) {
		this.updShaYmdNullFlag = updShaYmdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaupdShaIdを設定
	 * @return updShaId
	 */
	public String getUpdShaId() {
		return updShaId;
	}


	/**
	 * @param updShaId セットする updShaId
	 */
	public void setUpdShaId(String updShaId) {
		this.updShaId = updShaId;
	}


	/**
	 * TRdmHcoReqEntity.javaupdShaIdNullFlagを設定
	 * @return updShaIdNullFlag
	 */
	public boolean isUpdShaIdNullFlag() {
		return updShaIdNullFlag;
	}


	/**
	 * @param updShaIdNullFlag セットする updShaIdNullFlag
	 */
	public void setUpdShaIdNullFlag(boolean updShaIdNullFlag) {
		this.updShaIdNullFlag = updShaIdNullFlag;
	}


	/**
	 * TRdmHcoReqEntity.javaknrFlgを設定
	 * @return knrFlg
	 */
	public String getKnrFlg() {
		return knrFlg;
	}

	/**
	 * @param knrFlg セットする knrFlg
	 */
	public void setKnrFlg(String knrFlg) {
		this.knrFlg = knrFlg;
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
