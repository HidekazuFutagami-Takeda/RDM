/*
 * $Id: AppConstant.java,v 1.4 2014/03/04 05:01:55 terui Exp $
 *******************************************************************************
 * <改訂履歴>
 * 200x/xx/xx 日立：all：1.0
 *   新規作成
 * YYYY/MM/DD 改訂者名：[フィールド名｜メソッド名]：[リビジョン番号]
 *   [改訂内容]
 *******************************************************************************
 * <既知のバグ情報>
 * YYYY/MM/DD バグ発見者名：[メソッド名]：[リビジョン番号]
 *   [バグ内容]
 */

/* パッケージ名 */
package jp.co.takeda.rdm.util;


/**
 * <pre>
 * コンスタント値を管理します。
 * 現在テスト的に、競合回避用みんなでマージ領域を作ってますので注意
 * </pre>
 * @author
 * @version $Revision: 1.4 $
 * @since 1.0
 */

public interface AppConstant {
    /*
     * リビジョン
     */
    public static final String getRevision = "$Revision: 1.4 $";

    /** ホーム */
    public static final String HOMEPAGE_URL = "http://inteig01.takeda.co.jp";



    /***** データソース名 *****/
    public static final String DATASOURCE_PERSONNEL = "Personnel";  //医営本人事

    /*画面表示や受渡し用施設区分*/
    public static final String INSTYPE_U            = "U";
    public static final String INSTYPE_H1           = "H1";
    public static final String INSTYPE_H2           = "H2";
    public static final String INSTYPE_P            = "P";
    /*施設対象区分*/
    public static final String HOINSTYPE_U      = "1";
    public static final String HOINSTYPE_H      = "2";
    public static final String HOINSTYPE_P      = "3";
    /*施設重点対象区分*/
    //public static final String IMPINSTYPE_U       = "1";
    public static final String IMPINSTYPE_H1    = "2";
    //public static final String IMPINSTYPE_P       = "3";
    /*施設区分*/
    public static final String PHARMTYPE_B      = "5";  //B調剤 ちなみに"5"以外なら本院かA調剤
    /*施設内部サブコード*/
    public static final int RELNINSCODE_HONIN = 0;      //本院  ちなみに1～9ならA調剤
    /*画面表示や受渡し用調剤区分*/
    public static final String DSP_PHARMTYPE_A  = "A";  //A調剤
    public static final String DSP_PHARMTYPE_B  = "B";  //B調剤
    public static final String DSP_PHARMTYPE_R  = "R";  //本院

    //外勤活動、詳細画面と変更(承認)画面間のセッションキー
    public static final String SESKEY_ACR_BASE10            = "AcrBaseTableData10";                     //基本情報
    public static final String SESKEY_ACR_ACTION10      = "AcrActionTableData10";                   //外勤活動先
    public static final String SESKEY_ACR_REFERUSE10    = "ActivityReportReferUseData10"; //参考情報
    public static final String SESKEY_ACR_FILE10            = "AcrFileTableData10";                     //外勤添付ファイル
    public static final String SESKEY_ACR_ADDR10            = "AcrAddrTableData10";                     //宛先(進行状況)
    public static final String SESKEY_ACR_MYJOKEN10     = "AcrMyJokenSetCd10";                      //自分自身の条件セットコード

    //外勤活動詳細画面 詳細データ add 2005/09/29 S.Nakamura
    public static final String SESKEY_ACR_REFERDATA = "ActivityReportReferData";    //詳細データ

    // Navi-BoardのＡＰ間セッションキー
    public static final String SESKEY_NVB_BASE  = "NaviBoardComBaseData";    //基本情報

    //更に追加
    public static final String SESKEY_NVB_ADDR  = "NaviBoardComAddrData";    //宛先情報
    public static final String SESKEY_NVB_FILE  = "NaviBoardComFileData";    //ファイル情報

    //更に更に追加-ナビ坊
    public static final String AUTHORITY_NVB_ALL            = "NaviBoard";       //権限チェック用画面ID
    public static final String AUTHORITY_NVB_REGISTER = "RegisterInit";  //権限チェック用機能ID

    // AttentionのＡＰ間セッションキー
    public static final String SESKEY_ATT_BASE  = "AttentionComBaseData";    //基本情報

    //更に追加
    public static final String SESKEY_ATT_ADDR  = "AttentionComAddrData";    //宛先情報
    public static final String SESKEY_ATT_FILE  = "AttentionComFileData";    //ファイル情報

    //更に更に追加-アテン
    public static final String AUTHORITY_ATT_ALL            = "Attention";       //権限チェック用画面ID
    public static final String AUTHORITY_ATT_REGISTER = "RegisterInit";  //権限チェック用機能ID

    // Navi-Board詳細画面セッションキー
    public static final String SESKEY_ATT_SCR            = "attScreenId";       //Navi-Board詳細画面から一覧画面へ戻るときの戻り先画面ID
    public static final String SESKEY_ATT_FUNC       = "attFunctionId"; //Navi-Board詳細画面から一覧画面へ戻るときの戻り先機能ID
    public static final String SESKEY_ATT_LINK_TOP = "attLinkTop";      //Navi-Board詳細画面からトップへ戻るときの戻り先Link
    public static final String SESKEY_ATT_TAB            = "attPushTab";        //Attention詳細画面を表示するときのタブ情報(ボタンの出し分けに使用)

    //外勤情報 未読・既読 add 2002/07/15 T.Minamide
    public static final String REQKEY_ACR_END_READ = "acrEndReadKb"; //外勤情報 未読・既読

    // ---------------------久野の追加領域 開始 担当:久野-------------------------

    // ---------------------藤井の追加領域 開始 担当:藤井-------------------------
    public static final String PMT_PROD                         = "prod";                            //市販直後調査　左フレーム　品目
    public static final String PMT_ALL_PROD                 = "allProd";                     //市販直後調査　左フレーム　全品目
    public static final String PMT_SEL_PROD                 = "selProd";                     //市販直後調査　左フレーム　品目選択
    public static final String PMT_TL_SEL_PROD          = "tlSelProd";               //市販直後調査　左フレーム　ＴＬ品目選択
    public static final String PMT_DIST_SEL_PROD        = "distSelProd";                 //市販直後調査　左フレーム　所長品目選択
    public static final String PMT_MR                               = "mr";                              //市販直後調査　左フレーム　ＭＲ
    public static final String PMT_ALL_MR                       = "allMr";                       //市販直後調査　左フレーム　全ＭＲ
    public static final String PMT_SEL_MR                       = "selMr";                       //市販直後調査　左フレーム　ＭＲ選択
    public static final String PMT_INS                          = "ins";                             //市販直後調査　左フレーム　施設
    public static final String PMT_ALL_INS                  = "allIns";                      //市販直後調査　左フレーム　全施設
    public static final String PMT_ACTIVE_INS               = "activeIns";               //市販直後調査　左フレーム　活動対象施設
    public static final String PMT_ALL_ACTIVE_INS       = "allActiveIns";            //市販直後調査　左フレーム　活動対象全施設
    public static final String PMT_SEL_INS                  = "selIns";                      //市販直後調査　左フレーム　活動対象施設選択
    public static final String PMT_SUSPEND_INS          = "suspendIns";              //市販直後調査　左フレーム　活動保留施設
    public static final String PMT_ALL_SUSPEND_INS  = "allSuspendIns";       //市販直後調査　左フレーム　活動保留全施設

    public static final String PMT_OFFICE_APM               = "1";                               //市販直後調査　職制　ＡＰＭ
    public static final String PMT_OFFICE_BRANCH        = "2";                               //市販直後調査　職制　支店長
    public static final String PMT_OFFICE_DIST          = "3";                               //市販直後調査　職制　営業所長
    public static final String PMT_OFFICE_TL                = "4";                               //市販直後調査　職制　チームリーダー
    public static final String PMT_OFFICE_MR                = "5";                               //市販直後調査　職制　ＭＲ

    public static final String SESKEY_ALL_PROD_DATA      = "pmtAllProdData";        //市販直後調査　全品目データ
    public static final String SESKEY_ALL_MR_DATA            = "pmtAllMrData";          //市販直後調査　ＭＲデータ
    public static final String SESKEY_ALL_INS_DATA       = "pmtAllInsData";         //市販直後調査　全施設データ
    public static final String SESKEY_ACTIVE_INS_DATA    = "pmtActiveInsData";  //市販直後調査　活動対象施設データ
    public static final String SESKEY_SUSPEND_INS_DATA = "pmtSuspendInsData"; //市販直後調査　活動保留施設データ
    public static final String SESKEY_PMT_CONTROL_DATA = "pmtControlData";      //市販直後調査　制御データ

    //条件セットメンテ 2002/11/15 add
    public static final String SESKEY_JMC_VIEWDATA = "JokenMntCategoriesViewData"; //条件セットメンテナンス一覧制御データ
    public static final String REQKEY_JMC_DATA = "JokenMntCategoriesData"; //条件セットメンテナンス一覧データ

    //宛先グループメンテ 2002/11/15 add
    public static final String SESKEY_ANC_VIEWDATA = "AddressMntCategoriesViewData"; //宛先グループメンテナンス一覧制御データ
    public static final String REQKEY_ANC_DATA = "AddressMntCategoriesData"; //宛先グループメンテナンス一覧データ

    //外勤情報  add 2002/12/18 K.Fujii
    public static final String SESKEY_ACR_ADDRMST10 = "acrAddrMstTableData10"; //外勤情報 宛先マスタ



    //品質情報ワクチン一覧 add 2003/01/08 K.Fujii
    public static final String SESKEY_QIV_QAL_VIEWDATA = "QivQualityViewData"; //品質情報ワクチン一覧一覧制御データ
    public static final String REQKEY_QIV_QAL_DATA = "QivQualityData"; //品質情報ワクチン一覧一覧データ

    //品質情報ワクチン品目ポップアップ add 2003/01/08 K.Fujii
    public static final String SESKEY_QIV_QPC_VIEWDATA = "QivProdCategoriesViewData"; //品質情報ワクチン品目ポップアップ一覧制御データ
    public static final String REQKEY_QIV_QPC_DATA = "QivProdCategoriesData"; //品質情報ワクチン品目ポップアップ一覧データ

    //品質情報ワクチン報告書詳細 add 2003/01/08 K.Fujii
    public static final String SESKEY_QIV_QAL_REFERDATA = "QivQualityReferData"; //品質情報ワクチン報告書詳細詳細データ

    //品質情報ワクチン報告書編集 add 2003/01/08 K.Fujii
    public static final String SESKEY_QIV_QAL_REGISTERDATA = "QivQualityRegisterData"; //品質情報ワクチン報告書編集登録データ

    //品質情報ワクチン処置報告書詳細 add 2003/01/08 K.Fujii
    public static final String SESKEY_QIV_DIS_REFERDATA = "QivDisposalReferData"; //品質情報ワクチン処置報告書詳細詳細データ

    //品質情報ワクチン処置報告書編集 add 2003/01/08 K.Fujii
    public static final String SESKEY_QIV_DIS_REGISTERDATA = "QivDisposalRegisterData"; //品質情報ワクチン処置報告書編集登録データ

    //品質情報ワクチン承認 add 2003/01/08 K.Fujii
    public static final String SESKEY_QIV_AMI_MODIFYDATA = "QivAdmissionModifyData"; //品質情報ワクチン承認編集データ

    //品質情報ワクチン回答日 add 2003/01/08 K.Fujii
    public static final String SESKEY_QIV_ANS_MODIFYDATA = "QivAnswerModifyData"; //品質情報ワクチン回答日編集データ



    //医師基本情報新規登録 add 2003/01/08 K.Fujii
    public static final String SESKEY_DDN_REGISTERDATA = "DmcDocNewRegisterData";   //医師基本情報新規登録データ


    //コンテンツ add 2003/11/18 K.Fujii
    public static final String REQKEY_CON_DATA = "ContentsData";   //コンテンツ用データ

    //複数組織選択 add 2003/12/29 K.Fujii
    public static final String SESKEY_CMS_VIEWDATA = "CatMultiSosViewData";         //複数組織選択一覧制御データ
    public static final String REQKEY_CMS_DATA = "CatMultiSosData";                 //複数組織選択一覧データ

    //外勤活動詳細 add 2003/12/29 K.Fujii
    public static final String SESKEY_ACR_MJGI = "mJgiTableData";                  //従業員データ

    //外勤活動詳細 add 2004/1/28 K.Fujii
    public static final String SESKEY_ACR_CIR_BRANCH = "AcrCirBranchReferData";           //支店長個別回覧先データ
    public static final String SESKEY_ACR_CIR_DIST = "AcrCirDistReferData";           //支店長個別回覧先データ

    //NaviBoard　リンク add 2004/6/24 K.Fujii
    public static final String SESKEY_NVB_IN_LINK  = "NaviBoardInLinksData";      //NaviBoard内部リンクデータ
    //NaviBoard　リンク add 2004/6/24 K.Fujii
    public static final String SESKEY_NVB_OUT_LINK = "NaviBoardOutLinksData";     //NaviBoard外部リンクデータ

    //共通HN内リンク選択 add 2004/6/24 K.Fujii
    public static final String SESKEY_CIL_VIEWDATA = "CatInsideLinksViewData";     //リンク選択制御データ
    public static final String REQKEY_CIL_DATA = "CatInsideLinksData";             //リンク選択データ



    // ---------------------竹中の追加領域 開始 担当:竹中-------------------------
    public static final String SESKEY_RELATION_SET_TBL          = "relationSetTbl";      //関連情報追加ＴＢＬ
    public static final String SESKEY_ACD_VIEW          = "AcademyViewData1";        //ＭＯＮＪＵ一覧・画面制御データクラス

    //新製品速報（営業所別） add 2002/04/03 K.Takenaka
    public static final String SESKEY_NPS_VIEWDATA = "NewProdSalesViewData"; //新製品速報（営業所別）一覧制御データ
    public static final String REQKEY_NPS_DATA = "NewProdSalesData"; //新製品速報（営業所別）一覧データ
    //新製品速報（営業所別） add 2002/04/04 K.Takenaka
    public static final String REQKEY_NPS_DATA_SUM = "NewProdSalesDataSum"; //新製品速報（営業所別）集計データ

    //新製品情報（担当者別） add 2002/04/05 K.Takenaka
    public static final String SESKEY_NPJ_VIEWDATA = "NewProdJgiViewData"; //新製品情報（担当者別）一覧制御データ
    public static final String REQKEY_NPJ_DATA = "NewProdJgiData"; //新製品情報（担当者別）一覧データ
    //新製品速報（担当者別） add 2002/04/08 K.Takenaka
    public static final String REQKEY_NPJ_DATA_SUM = "NewProdJgiDataSum"; //新製品速報（担当者別）集計データ

    //市場情報 add 2002/04/08 K.Takenaka
    public static final String REQKEY_MRC_ARG_PARAM1 = "argParam1"; //画面遷移引数1(品目コード)
    public static final String REQKEY_MRC_ARG_PARAM2 = "argParam2"; //画面遷移引数2(支店コード)
    public static final String REQKEY_MRC_ARG_PARAM3 = "argParam3"; //画面遷移引数3(営業所コード)
    public static final String REQKEY_MRC_ARG_PARAM4 = "argParam4"; //画面遷移引数4(チームコード)
    public static final String REQKEY_MRC_ARG_PARAM5 = "argParam5"; //画面遷移引数5(従業員コード)
    public static final String REQKEY_MRC_ARG_PARAM6 = "argParam6"; //画面遷移引数6(権限フラグ)
    public static final String REQKEY_MRC_ARG_PARAM7 = "argParam7"; //画面遷移引数7(品目名)
    public static final String REQKEY_MRC_ARG_PARAM8 = "argParam8"; //画面遷移引数8(ログイン者支店名)
    public static final String REQKEY_MRC_ARG_PARAM9 = "argParam9"; //画面遷移引数9(ログイン者営業所名)
    public static final String REQKEY_MRC_ARG_PARAM10 = "argParam10"; //画面遷移引数10(ログイン者従業員名)
    public static final String REQKEY_MRC_ARG_PARAM11 = "argParam11"; //画面遷移引数11(ログイン者支店コード)
    public static final String REQKEY_MRC_ARG_PARAM12 = "argParam12"; //画面遷移引数12(ログイン者営業所コード)
    public static final String REQKEY_MRC_ARG_PARAM13 = "argParam13"; //画面遷移引数13(ログイン者チームコード)

    //新製品速報（その他雑） add 2002/04/08 K.Takenaka
    public static final String SESKEY_NPE_VIEWDATA = "NewProdElsViewData"; //新製品速報（その他雑）一覧制御データ
    public static final String REQKEY_NPE_DATA = "NewProdElsData"; //新製品速報（その他雑）一覧データ
    public static final String REQKEY_NPE_DATA_SUM = "NewProdJgiDataSum"; //新製品速報（その他雑）集計データ

    //市場情報(画面遷移) add 2002/04/10 K.Takenaka
    public static final String SESKEY_MRC_MOVE_DATA = "MarketResearchMoveData"; //データクラス
    public static final String REQKEY_MRC_MOVE_LEVEL = "level"; //遷移レベル
    public static final String REQKEY_MRC_MOVE_SCREENID = "nowScreenId"; //現在画面ＩＤ
    public static final String REQKEY_MRC_MOVE_PRAMTEXT = "pramText"; //パラメータテキスト
    public static final String REQKEY_MRC_MOVE_PRAMLINKTEXT = "pramLinkText"; //パラメータリンクテキスト


    //医師基本詳細 add 2003/01/08 K.Takenaka
    public static final String SESKEY_DDR_REFERDATA = "DmcDoctorReferData"; //医師基本詳細詳細データ

    //医師基本編集 add 2003/01/31 K.Takenaka
    public static final String SESKEY_DDR_MODIFYDATA = "DmcDoctorModifyData"; //医師基本編集データ

    //医師基本編集 add 2003/01/31 K.Takenaka
    public static final String SESKEY_DDR_MODIFY_PRES_LIST = "DmcDoctorModifyDataPresList"; //医師基本編集データ処方影響力リスト
    public static final String SESKEY_DDR_MODIFY_PRES_LIST_ADD = "DmcDoctorModifyDataPresListAdd"; //医師基本編集データ処方影響力リスト追加



    // ---------------------草場の追加領域 開始 担当:草場-------------------------

    // ---------------------南出の追加領域 開始 担当:南出-------------------------
    // Navi-Board詳細画面セッションキー
    public static final String SESKEY_NVB_SCR            = "nvbScreenId";       //Navi-Board詳細画面から一覧画面へ戻るときの戻り先画面ID
    public static final String SESKEY_NVB_FUNC       = "nvbFunctionId"; //Navi-Board詳細画面から一覧画面へ戻るときの戻り先機能ID
    public static final String SESKEY_NVB_LINK_TOP = "nvbLinkTop";      //Navi-Board詳細画面からトップへ戻るときの戻り先Link
    public static final String SESKEY_NVB_TAB            = "nvbPushTab";        //Navi-Board詳細画面を表示するときのタブ情報(ボタンの出し分けに使用)

    // 文献複写受付一覧セッションキー
    public static final String SESKEY_ADC_VIEW  = "AdminDocCopyViewData1";//文献複写受付一覧・画面制御データクラス

    // 関連情報追加全文検索一覧
    public static final String SESKEY_RELATION_SET_ACD_VIEW = "RelationSetAcademyViewData1"; //画面制御データクラス

    // 異動・昇降格一覧
    public static final String SESKEY_PRSCHANGE_VIEW    = "changeViewData"; //画面制御データクラス
    // 異動・昇降格詳細
    public static final String SESKEY_PRSCHANGE_REFER_VIEW  = "changeReferViewData"; //画面制御データクラス
    // 異動・昇降格詳細
    public static final String SESKEY_PRSCHANGE_REFER   = "changeReferData"; //画面制御データクラス
    //ファイル受け渡し add 2002/03/11 T.Minamide
    public static final String SESKEY_FDL_VIEWDATA = "FileDeliveryViewData"; //ファイル受け渡し一覧制御データ
    public static final String REQKEY_FDL_DATA = "FileDeliveryData"; //ファイル受け渡し一覧データ

    public static final String REQKEY_JKM_MODIFYDATA = "JokenMaintenanceModifyData"; //条件セットメンテナンス編集データ
    public static final String REQKEY_ADM_MODIFYDATA = "AddressMaintenanceModifyData"; //宛先グループメンテナンス編集データ
    public static final String REQKEY_SOM_MODIFYDATA = "SosMaintenanceModifyData"; //組織グループメンテナンス編集データ
    public static final String REQKEY_JGM_MODIFYDATA = "JgiMaintenanceModifyData"; //従業員グループメンテナンス編集データ
    //組織グループ選択 add 2002/04/05 T.Minamide
    public static final String SESKEY_SGC_VIEWDATA = "SosGrCategoriesViewData"; //組織グループ選択一覧制御データ
    public static final String REQKEY_SGC_DATA = "SosGrCategoriesData"; //組織グループ選択一覧データ
    //宛先選択メンテナンス add 2002/04/09 T.Minamide
    public static final String SESKEY_ASM_VIEWDATA = "AddressSetMaintenanceViewData"; //宛先選択メンテナンス一覧制御データ
    public static final String REQKEY_ASM_DATA = "AddressSetMaintenanceData"; //宛先選択メンテナンス一覧データ
    public static final String REQKEY_ASM_REGISTERDATA = "AddressSetMaintenanceRegisterDataReq"; //宛先選択メンテナンス登録データ

    public static final String REQKEY_MRG_DATA = "MarketGraphRivalData"; //ぐらふ

    public static final String REQKEY_PRL_DATA_RANK = "PersonnelListDownLoadInitDataRank"; //人事台帳取込 部門ランク
    public static final String REQKEY_PRL_DATA_BRNAME = "PersonnelListDownLoadInitDataBrName"; //人事台帳取込 支店名
    public static final String REQKEY_PRL_DATA_BRCODE = "PersonnelListDownLoadInitDataBrCode"; //人事台帳取込 支店コード

    public static final String REQKEY_SCD_DATA_RANK = "ScoreCardDownLoadInitDataRank"; //担当施設遂行率ダウンロード依頼 部門ランク
    public static final String REQKEY_SCD_DATA_BRNAME = "ScoreCardDownLoadInitDataBrName"; //担当施設遂行率ダウンロード依頼 支店名
    public static final String REQKEY_SCD_DATA_BRCODE = "ScoreCardDownLoadInitDataBrCode"; //担当施設遂行率ダウンロード依頼 支店コード

    //安全性情報関連(登録) add 2002/06/05 T.Minamide
    public static final String SESKEY_SDI_VIEWDATA = "SafeInfoDayInputViewData"; //安全性情報関連(登録)一覧制御データ
    public static final String REQKEY_SDI_DATA = "SafeInfoDayInputData"; //安全性情報関連(登録)一覧データ

    //社内教育用資料 add 2002/07/23 T.Minamide
    public static final String SESKEY_HTD_REFERDATA = "HouseTrainingDocReferData"; //社内教育用資料詳細データ
    public static final String REQKEY_HTD_ERASE_SCR = "HouseTrainingDocEraseScreenId"; //社内教育用資料削除完了後 戻り先
    //社内教育用資料 add 2002/07/26 T.Minamide
    public static final String SESKEY_HTD_VIEWDATA = "HouseTrainingDocViewData"; //社内教育用資料一覧制御データ
    public static final String REQKEY_HTD_DATA = "HouseTrainingDocData"; //社内教育用資料一覧データ

    //関連情報追加 社内教育用資料 add 2002/07/30 T.Minamide
    public static final String SESKEY_RLS_HTD_VIEWDATA = "RlsHouseTrainingDocViewData"; //社内教育用資料一覧制御データ

    //社内教育用資料 プロダクトニュース管理用画面 add 2002/08/05 T.Minamide
    public static final String SESKEY_APN_REGISTERDATA = "AdminPnewsRegisterData"; //社内教育用資料 プロダクトニュース管理用画面登録データ

    //市場情報 施設別詳細情報検索初期表示 add 2002/08/10 T.Minamide
    public static final String SESKEY_SMR_REFER_INIT_DATA = "SearchMakerRankingReferInitData"; //市場情報 施設別詳細情報検索初期表示 一覧制御データ

    //納入品目選択 add 2002/08/18 T.Minamide
    public static final String SESKEY_NPC_VIEWDATA = "NonyuProdCategoriesViewData"; //納入品目選択一覧制御データ
    public static final String REQKEY_NPC_DATA = "NonyuProdCategoriesData"; //納入品目選択一覧データ

    //納入特約店選択 add 2002/08/20 T.Minamide
    public static final String SESKEY_NWC_VIEWDATA = "NonyuWsCategoriesViewData"; //納入特約店選択一覧制御データ
    public static final String REQKEY_NWC_DATA = "NonyuWsCategoriesData"; //納入特約店選択一覧データ
    public static final String SESKEY_NUC_VIEWDATA = "NonyuWsUnderCategoriesViewData"; //納入特約店選択一覧制御データ
    public static final String REQKEY_NUC_DATA = "NonyuWsUnderCategoriesData"; //納入特約店選択一覧データ

    //特約店別品目別実績表 add 2002/08/23 T.Minamide
    public static final String SESKEY_WPN_VIEWDATA = "WsProductNmlViewData"; //特約店別品目別実績表一覧制御データ
    public static final String REQKEY_WPN_DATA = "WsProductNmlData"; //特約店別品目別実績表一覧データ

    //施設基本参照 add 2002/10/08 T.Minamide
    public static final String SESKEY_IMT_MST_REFERDATA = "ImtMstReferData"; //施設基本参照詳細データ(マスタ)
    public static final String SESKEY_IM1_MST_REFERDATA = "ImtMstReferData"; //施設基本参照詳細データ(マスタ)
    public static final String SESKEY_IMT_TMP_REFERDATA = "ImtTmpReferData"; //施設基本参照詳細データ(仮受け)
    public static final String SESKEY_IM1_TMP_REFERDATA = "ImtTmpReferData"; //施設基本参照詳細データ(仮受け)

    //施設基本タブID add 2002/11/06 T.Minamide
    public static final String IMT_TAB_ID_001 = "001"; //施設基本情報タブ
    public static final String IMT_TAB_ID_002 = "002"; //ベッド・処方箋タブ
    public static final String IMT_TAB_ID_003 = "003"; //診療科目タブ
    public static final String IMT_TAB_ID_004 = "004"; //医療法・診療報酬関連情報タブ
    public static final String IMT_TAB_ID_005 = "005"; //その他機能・設備タブ
    public static final String IMT_TAB_ID_006 = "006"; //実績関連タブ
    public static final String IMT_TAB_ID_007 = "007"; //ノート情報タブ
    public static final String IMT_TAB_ID_008 = "008"; //本院-調剤・医療連携・グループタブ
    public static final String IMT_TAB_ID_009 = "009"; //武田関連情報タブ
    public static final String IMT_TAB_ID_010 = "010"; //ユーザー用コードタブ
    public static final String IMT_TAB_ID_011 = "011"; //所属医師・薬剤師情報タブ
    public static final String IMT_TAB_ID_012 = "012"; //関係会社管理情報タブ

    //施設基本タブID add 2002/12/10 T.Minamide
    public static final String IM1_TAB_ID_001 = "001"; //基本情報タブ
    public static final String IM1_TAB_ID_002 = "002"; //医療法・診療報酬関連情報タブ
    public static final String IM1_TAB_ID_003 = "003"; //その他機能・設備タブ
    public static final String IM1_TAB_ID_004 = "004"; //本院-調剤・医療連携タブ
    public static final String IM1_TAB_ID_005 = "005"; //市場規模・実績把握タブ
    public static final String IM1_TAB_ID_006 = "006"; //ユーザ用コードタブ

    //施設基本新規項目登録結果 add 2002/11/28 T.Minamide
    public static final String SESKEY_IMT_COMPLETEDATA = "ImtMstReferDataComplete"; //施設基本詳細データ(結果画面)
    //施設基本新規項目登録結果 add 2002/12/10 T.Minamide
    public static final String SESKEY_IM1_COMPLETEDATA = "Im1MstReferDataComplete"; //施設基本詳細データ(結果画面)

    public static final String SESKEY_IMT_RECOGNIZEDATA = "ImtMstReferDataRecognize"; //施設基本詳細データ(承認画面)
    public static final String SESKEY_IMT_RECOGNIZE_SCRNDATA = "Recognize_HashMap";     //施設基本画面利用権限データ(承認)
    public static final String SESKEY_IMT_RECOGNIZE_TABDATA = "Recognize_ArrayList";    //施設基本タブ利用権限データ(承認)

    //ユーザー用コードの変更 add 2003/02/25 T.Minamide
    public static final String SESKEY_IUR_VIEWDATA = "ImtUsercdRegisterViewData"; //ユーザー用コードの変更一覧制御データ
    public static final String REQKEY_IUR_DATA = "ImtUsercdRegisterData"; //ユーザー用コードの変更一覧データ

    //一括登録(市場規模) aadd 2003/03/05 T.Minamide
    public static final String SESKEY_IMR_VIEWDATA = "ImtMarketRegisterViewData"; //一括登録(市場規模)一覧制御データ
    public static final String REQKEY_IMR_DATA = "ImtMarketRegisterData"; //一括登録(市場規模)一覧データ

    // ---------------------川口の追加領域 開始 担当:川口-------------------------

    // ---------------------諸道の追加領域 開始 担当:諸道-------------------------
    public static final String SESKEY_TDC_SCR        = "tdcScreenId";               //文献複写依頼詳細画面から一覧画面へ戻るときの戻り先画面ID[武サ用]
    public static final String SESKEY_TDC_FUNC       = "tdcFunctionId";             //文献複写依頼詳細画面から一覧画面へ戻るときの戻り先機能ID[武サ用]
    public static final String SESKEY_TDC_LINK_TOP   = "tdcLinkTop";                //文献複写依頼詳細画面からトップへ戻るときの戻り先Link[武サ用]
    public static final String SESKEY_TDC_TAB        = "tdcPushTab";                //文献複写依頼詳細画面を表示するときのタブ情報(ボタンの出し分けに使用)[武サ用]
    public static final String SESKEY_TDC_BASE       = "TkServiceDocCopyComBaseData";   //文献複写依頼詳細情報(基本情報テーブル)[武サ用]
    public static final String SESKEY_TDC_FILES      = "TkServiceDocCopyAtchFiles";  //文献複写依頼 添付ファイル

    //ファイル受け渡し add 2002/04/01 E.Moromichi
    public static final String SESKEY_FRV_VIEWDATA   = "FileReceiveViewData";   //ファイル受け渡し一覧制御データ
    public static final String REQKEY_FRV_DATA       = "FileReceiveData";       //ファイル受け渡し一覧データ
    public static final String SESKEY_FRV_SCR        = "frvScreenId";           //ファイル受け渡し画面切り替え

    //業務分担 add 2002/04/08 E.Moromichi
    public static final String SESKEY_ASS_REFERDATA = "AssignReferData"; //業務分担詳細データ

    //府県市区郡選択 add 2002/04/19 E.Moromichi
    public static final String REQKEY_PCC_DATA  = "PrefCityCategoriesData"; //府県市区郡選択一覧データ
    public static final String SESKEY_PCC_VIEWDATA  = "PrefCityCategoriesViewData"; //府県市区郡選択一覧制御データ

    //文献複写受付 add 2002/05/02 E.Moromichi
    public static final String REQKEY_ADC_JKN   = "AdminDocCopyJKN";    //条件セットコード
    public static final String SESKEY_ADC_JKN   = "AdminDocCopyJKN";    //条件セットコード

    //品目選択 add 2002/07/23 E.Moromichi
    public static final String SESKEY_PRC_VIEWDATA = "ProdCategoriesViewData"; //品目選択一覧制御データ
    public static final String REQKEY_PRC_DATA = "ProdCategoriesData"; //品目選択一覧データ

    //ワクチンニュース管理用画面 add 2002/07/25 E.Moromichi
    public static final String SESKEY_AWN_REGISTERDATA = "AdminWnewsRegisterData"; //ワクチンニュース管理用画面登録データ

    //社内教育用資料品名マスターメンテナンス管理用画面 add 2002/08/08 E.Moromichi
    public static final String SESKEY_HPM_VIEWDATA = "HtdProdMaintenanceViewData"; //社内教育用資料品名マスターメンテナンス管理用画面一覧制御データ
    public static final String REQKEY_HPM_DATA = "HtdProdMaintenanceData"; //社内教育用資料品名マスターメンテナンス管理用画面一覧データ

    //情報活動材料管理用画面 add 2002/08/20 E.Moromichi
    public static final String SESKEY_AAS_VIEWDATA = "AdminActivitySupportViewData"; //情報活動材料管理用画面一覧制御データ
    public static final String REQKEY_AAS_DATA = "AdminActivitySupportData"; //情報活動材料管理用画面一覧データ

    //施設登録チェック add 2002/08/23 E.Moromichi
    public static final String REQKEY_IEI_REFERDATA = "ImtErrorInformationReferData"; //施設登録チェック詳細データ

    //府県市区郡選択 add 2002/09/10 E.Moromichi
    public static final String SESKEY_IPC_VIEWDATA = "ImtPrefCityCategoriesViewData"; //府県市区郡選択一覧制御データ
    public static final String REQKEY_IPC_DATA = "ImtPrefCityCategoriesData"; //府県市区郡選択一覧データ

    //施設基本 add 2002/09/06 E.Moromichi
    public static final String SESKEY_IMT_MENUDATA = "InsMaintenanceMenuData"; //施設基本メニューデータ

    //暫定施設データ表示画面 add 2002/09/24 E.Moromichi
    public static final String SESKEY_IPN_REFERDATA = "ImtProvisionalReferData"; //暫定施設データ表示画面詳細データ
    public static final String SESKEY_IPN_OPTIONDATA = "ImtProvisionalOptionData"; //暫定施設データ表示ラジオボタンデータ

    //施設基本画面項目表示 add 2002/09/26 E.Moromichi
    public static final String SESKEY_IMT_GETITEMLISTDATA = "InsMaintenanceGetItemListData"; //施設基本画面項目表示詳細データ
    public static final String SESKEY_IM1_GETITEMLISTDATA = "InsMaintenance1GetItemListData"; //施設基本画面項目表示詳細データ

    //施設基本登録 add 2002/09/30 E.Moromichi
    public static final String SESKEY_IMT_REGISTERDATA = "InsMaintenanceRegisterData"; //病院・診療所登録データ
    public static final String SESKEY_IM1_REGISTERDATA = "InsMaintenanceRegisterData"; //病院・診療所登録データ

    //施設基本－業務代行画面 add 2002/09/12 E.Moromichi
    public static final String REQKEY_IPO_PROXYDATA = "ImtProxyOrganizationProxyData"; //業務代行データ

    //医師基本情報 add 2002/11/11 E.Moromichi
    public static final String SESKEY_DRF_REFERDATA = "DmtReferenceReferData"; //医師基本情報詳細データ

    //医師基本フリー項目ID add 2002/11/18 E.Moromichi
    public static final String DMT_FREE_ID_HO1 = "FreeHonbu1";  //本部フリー項目1
    public static final String DMT_FREE_ID_HO2 = "FreeHonbu2";  //本部フリー項目2
    public static final String DMT_FREE_ID_HO3 = "FreeHonbu3";  //本部フリー項目3
    public static final String DMT_FREE_ID_HO4 = "FreeHonbu4";  //本部フリー項目4
    public static final String DMT_FREE_ID_HO5 = "FreeHonbu5";  //本部フリー項目5
    public static final String DMT_FREE_ID_HO6 = "FreeHonbu6";  //本部フリー項目6
    public static final String DMT_FREE_ID_BR1 = "FreeBranch1"; //支店フリー項目1
    public static final String DMT_FREE_ID_BR2 = "FreeBranch2"; //支店フリー項目2
    public static final String DMT_FREE_ID_BR3 = "FreeBranch3"; //支店フリー項目3
    public static final String DMT_FREE_ID_BR4 = "FreeBranch4"; //支店フリー項目4
    public static final String DMT_FREE_ID_BR5 = "FreeBranch5"; //支店フリー項目5
    public static final String DMT_FREE_ID_BR6 = "FreeBranch6"; //支店フリー項目6
    public static final String DMT_FREE_ID_SA1 = "FreeSales1";  //営業所フリー項目1
    public static final String DMT_FREE_ID_SA2 = "FreeSales2";  //営業所フリー項目2
    public static final String DMT_FREE_ID_SA3 = "FreeSales3";  //営業所フリー項目3
    public static final String DMT_FREE_ID_SA4 = "FreeSales4";  //営業所フリー項目4
    public static final String DMT_FREE_ID_SA5 = "FreeSales5";  //営業所フリー項目5
    public static final String DMT_FREE_ID_SA6 = "FreeSales6";  //営業所フリー項目6

    //新規項目 add 2002/11/20 E.Moromichi
    public static final String SESKEY_DMN_REFERDATA = "DmtMaintenanceNewItemReferData"; //新規項目詳細データ
    public static final String SESKEY_DMN_REGISTERDATA = "DmtMaintenanceNewItemRegisterData"; //新規項目登録データ

    //全組織選択 add 2002/12/02 E.Moromichi
    public static final String SESKEY_CAS_VIEWDATA = "CatAllSosViewData"; //全組織選択一覧制御データ
    public static final String REQKEY_CAS_DATA = "CatAllSosData"; //全組織選択一覧データ

    //全従業員選択 add 2002/12/09 E.Moromichi
    public static final String SESKEY_CAJ_VIEWDATA = "CatAllJgiViewData"; //全従業員選択一覧制御データ
    public static final String REQKEY_CAJ_DATA_SOS = "CatAllJgiDataSos"; //全従業員選択一覧データ(組織)
    public static final String REQKEY_CAJ_DATA_JGI = "CatAllJgiDataJgi"; //全従業員選択一覧データ(従業員)

    //施設分類選択 add 2003/01/21 E.Moromichi
    public static final String SESKEY_ICD_VIEWDATA = "ImtInsClassDeterminationViewData"; //施設分類選択一覧制御データ

    //ワクチン関連項目メンテナンス add 2003/03/05 E.Moromichi
    public static final String SESKEY_IVM_VIEWDATA = "ImtVacMaintenanceViewData"; //ワクチン関連項目メンテナンス一覧制御データ
    public static final String REQKEY_IVM_DATA = "ImtVacMaintenanceData"; //ワクチン関連項目メンテナンス一覧データ

    //所属医師情報 add 2003/03/10 E.Moromichi
    public static final String SESKEY_IBD_VIEWDATA = "ImtBelongDoctorViewData"; //所属医師情報一覧制御データ
    public static final String REQKEY_IBD_DATA = "ImtBelongDoctorData"; //所属医師情報一覧データ

    //グループ登録（グループ情報詳細） add 2003/03/12 E.Moromichi
    public static final String SESKEY_IGD_VIEWDATA = "ImtGrpDtViewData"; //グループ登録（グループ情報詳細）一覧制御データ
    public static final String REQKEY_IGD_DATA = "ImtGrpDtData"; //グループ登録（グループ情報詳細）一覧データ

    //グループ登録(施設登録) add 2003/03/18 E.Moromichi
    public static final String SESKEY_IGT_VIEWDATA = "ImtGrpDtMstViewData"; //グループ登録(施設登録)一覧制御データ
    public static final String REQKEY_IGT_DATA = "ImtGrpDtMstData"; //グループ登録(施設登録)一覧データ

    //グループ登録(施設登録) add 2003/03/19 E.Moromichi
    public static final String REQKEY_IGT_ADDDATA = "ImtGrpDtMstAddData"; //グループ登録(施設登録)追加データ
    public static final String REQKEY_IGT_DELDATA = "ImtGrpDtMstDelData"; //グループ登録(施設登録)削除データ

    //日次変更チェックリスト add 2003/04/22 E.Moromichi
    public static final String REQKEY_ICC_HEADERDATA = "ImtChangeCheckListHeaderData"; //日次変更チェックリスト一覧データ(ヘッダー)
    public static final String REQKEY_ICC_HASHDATA = "ImtChangeCheckListHashData"; //日次変更チェックリスト一覧データ(ハッシュ)

    //期末チェックリスト add 2003/05/13 E.Moromichi
    public static final String SESKEY_ITC_VIEWDATA = "ImtTerminalCheckListViewData"; //期末チェックリスト一覧制御データ
    public static final String REQKEY_ITC_DATA = "ImtTerminalCheckListData"; //期末チェックリスト一覧データ

    //施設選択 add 2003/05/23 E.Moromichi
    public static final String SESKEY_IIC_VIEWDATA = "ImtInstitutionCategoriesViewData"; //施設選択一覧制御データ
    public static final String REQKEY_IIC_DATA = "ImtInstitutionCategoriesData"; //施設選択一覧データ

    //医師治験研究情報登録画面（医開本用） add 2003/07/02 E.Moromichi
    public static final String SESKEY_MDI_VIEWDATA = "DocClinicalResearchIViewData"; //医師治験研究情報登録画面（医開本用）一覧制御データ
    public static final String SESKEY_MDI_MODIFYDATA = "DocClinicalResearchIModifyData"; //医師治験研究情報登録画面（医開本用）編集データ
    public static final String SESKEY_MDI_REFERDATA = "DocClinicalResearchIReferData"; //医師治験研究情報登録結果画面（医開本用）データ

    //施設基本詳細画面(治験研究情報参照タブ) add 2003/07/17 E.Moromichi
    public static final String REQKEY_IMT_REFER_ITEMDATA = "InsMaintenanceReferItemData";   //参照権限データ

    //全社検索用外部参照施設基本詳細(治験研究情報参照タブ) add 2003/07/22 E.Moromichi
    public static final String REQKEY_IIA_REFER_ITEMDATA = "ImtInstitutionAllSearchRefeItemData";   //参照権限データ

    //施設基本編集画面(治験研究情報編集タブ) add 2003/07/23 E.Moromichi
    public static final String REQKEY_IMT_MODIFY_ITEMDATA = "InsMaintenanceModifyItemData"; //編集権限データ

    //医師治験研究情報登録画面（研究本部用） add 2003/07/31 E.Moromichi
    public static final String SESKEY_MDK_VIEWDATA = "DocClinicalResearchKViewData"; //医師治験研究情報登録画面（研究本部用）一覧制御データ
    public static final String SESKEY_MDK_MODIFYDATA = "DocClinicalResearchKModifyData"; //医師治験研究情報登録画面（研究本部用）編集データ
    public static final String SESKEY_MDK_REFERDATA = "DocClinicalResearchKReferData"; //医師治験研究情報登録画面（研究本部用）登録結果データ

    //メニュー画面 (新着情報) add 2004/01/23 E.Moromichi
    public static final String REQKEY_MNU_NEWINFODATA = "MenuNewInfoData";  //メニュー新着表示情報データ

    //ULT施設情報 add 2004/08/05 E.Moromichi
    public static final String SESKEY_UIS_VIEWDATA = "UltInsSearchViewData"; //ULT施設情報一覧制御データ
    public static final String REQKEY_UIS_DATA = "UltInsSearchData"; //ULT施設情報一覧データ

    //ULT施設情報 add 2004/08/10 E.Moromichi
    public static final String SESKEY_UIS_REFERDATA = "UltInsSearchReferData"; //ULT施設情報詳細データ

    //ULT施設情報 add 2004/08/16 E.Moromichi
    public static final String REQKEY_UIS_CONNECTDATA = "UltInsSearchConnectData"; //ULT施設情報接続データ

    //全組織・従業員選択 add 2004/09/08 E.Moromichi
    public static final String SESKEY_CSJ_VIEWDATA = "CatAllSosJgiViewData"; //全組織・従業員選択一覧制御データ
    public static final String REQKEY_CSJ_DATA_SOS = "CatAllSosJgiDataSos"; //全組織・従業員選択一覧データ(組織)
    public static final String REQKEY_CSJ_DATA_JGI = "CatAllSosJgiDataJgi"; //全組織・従業員選択一覧データ(従業員)

    //アルトマーク共通 add 2004/09/10 E.Moromichi
    public static final String SESKEY_ULT_COMMONDATA = "UltmarcCommonData"; //アルトマーク共通データ
    public static final String REQKEY_ULT_TIMECTRL_DATA = "UltmarcTimeLimitData"; //アルトマーク利用可能時間データ

    //未接続ULT情報組織別 add 2004/09/10 E.Moromichi
    public static final String SESKEY_UUS_VIEWDATA = "UltUnConnectSosViewData"; //未接続ULT情報組織別一覧制御データ
    public static final String REQKEY_UUS_DATA = "UltUnConnectSosData"; //未接続ULT情報組織別一覧データ

    //コンテンツメール登録(管理) add 2004/09/28 E.Moromichi
    public static final String SESKEY_EAD_REGISTERDATA = "EdtAdminContentsRegisterData"; //コンテンツメール登録(管理)登録データ

    //ULT医師情報検索 add 2004/10/05 E.Moromichi
    public static final String SESKEY_UDS_VIEWDATA = "UltDocSearchViewData"; //ULT医師情報検索一覧制御データ
    public static final String REQKEY_UDS_DATA = "UltDocSearchData"; //ULT医師情報検索一覧データ

    // ---------------------羽田の追加領域 開始 担当:羽田-------------------------

    public static final String SESKEY_DCC_BASE      = "DocumentCopyComBaseData"; //文献複写依頼詳細情報(基本情報テーブル)
    public static final String SESKEY_DCC_FILES     = "DocumentCopyAtchFiles";   //文献複写依頼 添付ファイル

    public static final String SESKEY_MDC_CONS      = "mdcConsKbList";          //くすり相談相談者リスト
    public static final String SESKEY_MDC_BASE          ="AdminMedicalBaseData";        //くすり相談詳細基本テーブル
    public static final String SESKEY_MDC_CAT               ="CatReferData";                        //くすり相談詳細内容区分
    public static final String SESKEY_MDC_PROD          ="ProdReferData";                       //くすり相談詳細品目
    public static final String SESKEY_MDC_RES               ="ResReferData";                        //くすり相談詳細定型回答
    public static final String SESKEY_MDC_FILE          ="AcdAtchFilesTableData";       //くすり相談詳細添付ファイル

    // ---------------------松井の追加領域 開始 担当:松井-------------------------
    public static final String SESKEY_ACS_SCR            = "acsScreenId";       //活動情報詳細画面から一覧画面へ戻るときの戻り先画面ID
    public static final String SESKEY_ACS_FUNC       = "acsFunctionId"; //活動情報詳細画面から一覧画面へ戻るときの戻り先機能ID
    public static final String SESKEY_ACS_LINK_TOP = "acsLinkTop";      //活動情報詳細画面からトップへ戻るときの戻り先Link
    public static final String SESKEY_ACS_TAB            = "acsPushTab";        //活動情報詳細画面を表示するときのタブ情報(ボタンの出し分けに使用)
    public static final String SESKEY_DCC_SCR            = "dccScreenId";       //文献複写依頼詳細画面から一覧画面へ戻るときの戻り先画面ID
    public static final String SESKEY_DCC_FUNC       = "dccFunctionId"; //文献複写依頼詳細画面から一覧画面へ戻るときの戻り先機能ID
    public static final String SESKEY_DCC_LINK_TOP = "dccLinkTop";      //文献複写依頼詳細画面からトップへ戻るときの戻り先Link
    public static final String SESKEY_DCC_TAB            = "dccPushTab";        //文献複写依頼詳細画面を表示するときのタブ情報(ボタンの出し分けに使用)
    public static final String SESKEY_AMC_SCR            = "amcScreenId";       //くすり相談詳細画面から一覧画面へ戻るときの戻り先画面ID
    public static final String SESKEY_AMC_FUNC       = "amcFunctionId"; //くすり相談詳細画面から一覧画面へ戻るときの戻り先機能ID
    public static final String SESKEY_AMC_LINK_TOP = "amcLinkTop";      //くすり相談詳細画面からトップへ戻るときの戻り先Link
    public static final String SESKEY_AMC_TAB            = "amcPushTab";        //くすり相談詳細画面を表示するときのタブ情報(ボタンの出し分けに使用)
    public static final String SESKEY_SRB_IMG_SCR            = "imgScreenId";       //イメージ参照画面から一覧画面へ戻るときの戻り先画面ID
    public static final String SESKEY_SRB_IMG_FUNC       = "imgFunctionId"; //イメージ参照画面から一覧画面へ戻るときの戻り先機能ID
    // ---------------------成田の追加領域 開始 担当:成田-------------------------

    // ---------------------受本の追加領域 開始 担当:受本-------------------------

    // ---------------------植田の追加領域 開始 担当:植田-------------------------

    public static final String SESKEY_SRB_PROD10            = "ShirubeiMarkData1";      //知る兵衛品目データ

    //文献検索 add 2002/03/07 Y.Ueda
    public static final String SESKEY_DCS_VIEWDATA = "DocumentSearchViewData"; //文献検索一覧制御データ
    public static final String REQKEY_DCS_DATA = "DocumentSearchData"; //文献検索一覧データ
    public static final String REQKEY_DCS_JGINO_DATA = "DocumentSearchJgiNoData";       //文献検索従業員番号データ

    //文献複写依頼（武サ用） add 2002/03/18 Y.Ueda
    public static final String SESKEY_TDC_VIEWDATA = "TkServiceDocCopyViewData"; //文献複写依頼（武サ用）一覧制御データ
    public static final String REQKEY_TDC_DATA = "TkServiceDocCopyData"; //文献複写依頼（武サ用）一覧データ
    public static final String REQKEY_TDC_SOS_DATA = "TkServiceDocCopySosData"; //文献複写依頼（武サ用）所属一覧データ

    // ---------------------坂井の追加領域 開始 担当:坂井-------------------------

    public static final String SESKEY_KWG_REFER         = "KnowledgeReferData";     //ナレッジ詳細データ

    public static final String SESKEY_SRB_REFER         = "ShirubeiReferData";      //ＭＯＮＪＵ・知る兵衛詳細データ

    public static final String SESKEY_RETURN            = "ReturnData";         //戻り先情報データ

    public static final String SESKEY_BSC_VIEW          = "BusinessCalendarViewData";   //医営本カレンダーデータ

    public static final String SESKEY_ABC_REGISTER      = "ABCRegisterData";    //医営本カレンダー登録データ

    public static final String SESKEY_ABC_DATA              = "AbcData";                    //医営本カレンダー登録データ

    public static final String SESKEY_BKM                       = "BookMarkData";           //しおり情報データ

    //評価者テーブルメンテ（組織） add 2002/04/09 N.Sakai
    public static final String SESKEY_VLM_SOS_REFERDATA = "ValuationSosReferData"; //評価者テーブルメンテ（組織）詳細データ
    //評価者テーブルメンテ（組織） add 2002/04/09 N.Sakai
    public static final String SESKEY_VLM_SOS_REGISTERDATA = "ValuationSosRegisterData"; //評価者テーブルメンテ（組織）登録データ

    //PS納入実績 品目別表 add 2002/06/04 N.Sakai
    public static final String SESKEY_PDN_VIEWDATA = "ProductNmlViewData"; //PS納入実績 品目別表一覧制御データ
    public static final String REQKEY_PDN_DATA = "ProductNmlData"; //PS納入実績 品目別表一覧データ

    //PS納入実績 品目別表 add 2002/06/17 N.Sakai
    public static final String SESKEY_PDI_VIEWDATA = "ProductInsViewData"; //PS納入実績 品目別表(施設選択)一覧制御データ
    public static final String REQKEY_PDI_DATA = "ProductInsData"; //PS納入実績 品目別表(施設選択)一覧データ

    //戻り先情報履歴 add 2002/06/28 N.Sakai
    public static final String SESKEY_RETURN_LIST = "ReturnDataList"; //戻り先情報のリストデータ
    public static final String REQKEY_RETURN_LAST = "LastReturnData"; //最後の戻り先情報データ
    public static final String REQKEY_RETURN_HISTORY = "ReturnHistoryData"; //戻り先情報履歴データ



    // ---------------------北脇の追加領域 開始 担当:北脇-------------------------
    public static final String SESKEY_ACR_PRODUCT10             = "AcrProductTableData10";      //外勤選択分類
    public static final String SESKEY_ACR_OTHERS10              = "AcrOthersTableData10";           //外勤選択その他分類
    public static final String SESKEY_ACR_KEEP10                    = "AcrKeepTableData10";             //外勤保管場所
    public static final String SESKEY_ACR_CIRCULATION10     = "AcrCirculationTableData10";//外勤回覧先
    public static final String REQKEY_ACR_SCR                           = "AcrScreenId";                            //自画面を呼び出した画面ID
    public static final String REQKEY_ACR_FUNC                      = "AcrFunctionId";                      //自画面を呼び出した機能ID
    public static final String REQKEY_ACR_PRE_SCR                   = "PreAcrScreenId";                     //前の画面を呼び出した画面ID
    public static final String REQKEY_ACR_PRE_FUNC              = "PreAcrFunctionId";                   //前の画面を呼び出した機能ID

    // ---------------------清水の追加領域 開始 担当:清水-------------------------
    public static final int MDCNPRODNAME_MDC_COLUMN     = 10;                                                            //くすり相談－連絡一覧　品目カラム長
    public static final String SESKEY_MDC_VIEW       = "MedicalConsultationViewData1";   //くすり相談詳細画面から一覧画面へ戻るときの戻り先画面ID

    // ---------------------伊藤の追加領域 開始 担当:伊藤-------------------------


    // ---------------------秋山の追加領域 開始 担当:秋山-------------------------
    public static final String SESKEY_ADD_VIEWDATA = "AdminDocSearchViewData"; //管理用文献検索一覧制御データ
    public static final String REQKEY_ADD_DATA = "AdminDocSearchData"; //管理用文献検索一覧データ
    public static final String REQKEY_ADD_JGI_DATA = "AdminDocSearchJgiData"; //管理文献検索検索キー用担当者データ

    //業務分担一覧 add 2002/04/08 T.Akiyama
    public static final String SESKEY_ASS_VIEWDATA = "AssignViewData"; //業務分担一覧一覧制御データ
    public static final String REQKEY_ASS_DATA = "AssignData"; //業務分担一覧一覧データ
    // 文献検索アテンション書き込み件名
    public static final String DOC_SEARCH_ATT_SUBJECT = "文献検索から";

    // 文献検索詳細アテンションから遷移ようセッションキー
    public static final String SESKEY_DCS_ATTINFO = "dcsAttInfo";

    //市場情報施設別薬効市場ﾗﾝｷﾝｸﾞ（残市場） add 2002/04/22 T.Akiyama
    public static final String SESKEY_WMR_VIEWDATA = "WholeMarketRankingViewData"; //市場情報施設別薬効市場ﾗﾝｷﾝｸﾞ（残市場）一覧制御データ
    public static final String REQKEY_WMR_DATA = "WholeMarketRankingData"; //市場情報施設別薬効市場ﾗﾝｷﾝｸﾞ（残市場）一覧データ
    public static final String REQKEY_MRC_MKT = "MRC_MKT"; // 施設・市場別累計
    public static final String SESKEY_WMG_VIEWDATA = "WholeMarketGraphViewData"; //市場情報施設別薬効市場ﾗﾝｷﾝｸﾞ（残市場）グラフ
    public static final String REQKEY_WMG_DATA = "WholeMarketGraphData"; //市場情報施設別薬効市場ﾗﾝｷﾝｸﾞ（残市場）グラフ

    // ---------------------細川の追加領域 開始 担当:細川-------------------------
    public static final String SESKEY_JKM_VIEWDATA = "JokenMaintenanceViewData"; //条件セットメンテナンス一覧制御データ
    public static final String REQKEY_JKM_DATA = "JokenMaintenanceData"; //条件セットメンテナンス一覧データ

    //宛先グループメンテナンス add 2002/03/29 S.Hosokawa
    public static final String SESKEY_ADM_VIEWDATA = "AddressMaintenanceViewData"; //宛先グループメンテナンス一覧制御データ
    public static final String REQKEY_ADM_DATA = "AddressMaintenanceData"; //宛先グループメンテナンス一覧データ

    //組織グループメンテナンス add 2002/04/02 S.Hosokawa
    public static final String SESKEY_SOM_VIEWDATA = "SosMaintenanceViewData"; //組織グループメンテナンス一覧制御データ
    public static final String REQKEY_SOM_DATA = "SosMaintenanceData"; //組織グループメンテナンス一覧データ

    //従業員グループメンテナンス add 2002/04/02 S.Hosokawa
    public static final String SESKEY_JGM_VIEWDATA = "JgiMaintenanceViewData"; //従業員グループメンテナンス一覧制御データ
    public static final String REQKEY_JGM_DATA = "JgiMaintenanceData"; //従業員グループメンテナンス一覧データ

    //宛先グループ選択 add 2002/04/05 S.Hosokawa
    public static final String SESKEY_AGC_VIEWDATA = "AddressGrCategoriesViewData"; //宛先グループ選択一覧制御データ
    public static final String REQKEY_AGC_DATA = "AddressGrCategoriesData"; //宛先グループ選択一覧データ

    //従業員グループ選択 add 2002/04/07 S.Hosokawa
    public static final String SESKEY_JGC_VIEWDATA = "JgiGrCategoriesViewData"; //従業員グループ選択一覧制御データ
    public static final String REQKEY_JGC_DATA = "JgiGrCategoriesData"; //従業員グループ選択一覧データ
    //宛先選択メンテナンス add 2002/04/09 S.Hosokawa
    public static final String SESKEY_ASM_REGISTERDATA = "AddressSetMaintenanceRegisterData"; //宛先選択メンテナンス登録データ
    //評価者テーブルメンテ（従業員） add 2002/04/17 S.Hosokawa
    public static final String SESKEY_VLM_JGI_REFERDATA = "ValuationJgiReferData"; //評価者テーブルメンテ（従業員）詳細データ
    //評価者テーブルメンテ（従業員） add 2002/04/17 S.Hosokawa
    public static final String SESKEY_VLM_JGI_REGISTERDATA = "ValuationJgiRegisterData"; //評価者テーブルメンテ（従業員）登録データ
    //納入状況表 add 2002/06/21 S.Hosokawa
    public static final String SESKEY_DTL_VIEWDATA = "NjyDetailViewData"; //納入状況表一覧制御データ
    public static final String REQKEY_DTL_DATA = "NjyDetailData"; //納入状況表一覧データ
    public static final String SESKEY_DTL_GBL = "grpBeforeList"; //納入状況表grpBeforeリスト

    //特約店参照制限メンテナンス add 2002/12/16 S.Hosokawa
    public static final String SESKEY_NSM_VIEWDATA = "NjySosWsMaintenanceViewData"; //特約店参照制限メンテナンス一覧制御データ
    public static final String REQKEY_NSM_DATA = "NjySosWsMaintenanceData"; //特約店参照制限メンテナンス一覧データ

    //【出身校】選択画面 add 2003/01/08 S.Hosokawa
    public static final String SESKEY_DMD_VIEWDATA = "DmcMedSchCategoriesViewData"; //【出身校】選択画面一覧制御データ
    public static final String REQKEY_DMD_DATA = "DmcMedSchCategoriesData"; //【出身校】選択画面一覧データ

    //【出身所属部科】選択画面 add 2003/01/08 S.Hosokawa
    public static final String SESKEY_DSH_VIEWDATA = "DmcSchDeptsCategoriesViewData"; //【出身所属部科】選択画面一覧制御データ
    public static final String REQKEY_DSH_DATA = "DmcSchDeptsCategoriesData"; //【出身所属部科】選択画面一覧データ

    //【専門臓器】選択画面 add 2003/01/08 S.Hosokawa
    public static final String SESKEY_DSL_VIEWDATA = "DmcSpLiverCategoriesViewData"; //【専門臓器】選択画面一覧制御データ
    public static final String REQKEY_DSL_DATA = "DmcSpLiverCategoriesData"; //【専門臓器】選択画面一覧データ

    //【専門詳細】選択画面 add 2003/01/08 S.Hosokawa
    public static final String SESKEY_DSD_VIEWDATA = "DmcSpDiseaseCategoriesViewData"; //【専門詳細】選択画面一覧制御データ
    public static final String REQKEY_DSD_DATA = "DmcSpDiseaseCategoriesData"; //【専門詳細】選択画面一覧データ

    //【研究会名称】選択画面 add 2003/01/23 S.Hosokawa
    public static final String SESKEY_DSN_VIEWDATA = "DmcStudyNameCategoriesViewData"; //【研究会名称】選択画面一覧制御データ
    public static final String REQKEY_DSN_DATA = "DmcStudyNameCategoriesData"; //【研究会名称】選択画面一覧データ

    //【役職】選択画面 add 2003/01/23 S.Hosokawa
    public static final String SESKEY_DDT_VIEWDATA = "DmcDocTitleCategoriesViewData"; //【役職】選択画面一覧制御データ
    public static final String REQKEY_DDT_DATA = "DmcDocTitleCategoriesData"; //【役職】選択画面一覧データ

    //【研究会品目】選択画面 add 2003/01/23 S.Hosokawa
    public static final String SESKEY_DSP_VIEWDATA = "DmcStudyProdCategoriesViewData"; //【研究会品目】選択画面一覧制御データ
    public static final String REQKEY_DSP_DATA = "DmcStudyProdCategoriesData"; //【研究会品目】選択画面一覧データ

    //【施設-所属部科】選択画面 add 2003/01/29 S.Hosokawa
    public static final String SESKEY_DID_VIEWDATA = "DmcInsDeptsCategoriesViewData"; //【施設-所属部科】選択画面一覧制御データ
    public static final String SESKEY_DID_DATA = "DmcInsDeptsCategoriesData"; //【施設-所属部科】選択画面施設一覧データ
    public static final String SESKEY_DID_TYPELISTDATA = "DmcInsDeptsCategoriesTypeListData"; //【施設-所属部科】選択画面リストボックスデータ
    public static final String REQKEY_DID_DEPTDATA = "DmcInsDeptsCategoriesDeptData"; //【施設-所属部科】選択画面所属部科一覧データ
    public static final String SESKEY_DID_MRINSDATA = "DmcMrInsCommonData"; //【医師共通】施設担当データ   add 2014/01/29 M.Terui J14-0002 2014年4月期末期首対応

    //【学会名称】選択画面 add 2003/02/06 S.Hosokawa
    public static final String SESKEY_DML_VIEWDATA = "DmcLearnedCategoriesViewData"; //【学会名称】選択画面一覧制御データ
    public static final String REQKEY_DML_DATA = "DmcLearnedCategoriesData"; //【学会名称】選択画面一覧データ

    //医師ネーベン一覧 add 2003/02/10 S.Hosokawa
    public static final String SESKEY_DIV_VIEWDATA = "DmcDocInsVViewData"; //医師ネーベン一覧制御データ
    public static final String REQKEY_DIV_DATA = "DmcDocInsVData"; //医師ネーベン一覧データ
    public static final String REQKEY_DIV_DOCDATA = "DmcDocInsVDocData"; //医師ネーベン一覧医師データ

    //医師ネーベン登録 add 2003/02/19 S.Hosokawa
    public static final String REQKEY_DDI_REGISTERDATA = "DmcDocInsRRegisterData";   //医師ネーベン登録データ
    public static final String REQKEY_DDI_DOCDATA = "DmcDocInsVDocData"; //医師ネーベン一覧医師データ

    //医師ネーベン送出し add 2003/02/24 S.Hosokawa
    public static final String REQKEY_DIO_REGISTERDATA = "DmcDocInsOutData";   //医師ネーベン送出しデータ

    //代行ユーザー切替 add 2003/06/25 S.Hosokawa
    public static final String REQKEY_ACC_MODIFYDATA = "AcwChangeModifyData"; //代行ユーザー切替データ

    //特担ワクチン外勤活動フロー add 2003/10/28 S.Hosokawa
    public static final String SESKEY_VRF_REFERDATA = "VarReportFlowReferData"; //活動フロー詳細データ
    //public static final String SESKEY_VRF_FILEDATA = "VarFileTableData"; //特担ワクチン添付ファイルデータ

    //文献検索アンケート編集 add 2003/12/16 S.Hosokawa
    public static final String SESKEY_DCS_ENQUETE_MODIFYDATA = "DocumentSearchEnqueteModifyData"; //文献検索アンケート編集データ
    //文献検索アンケート詳細 add 2003/12/16 S.Hosokawa
    public static final String REQKEY_DCS_ENQUETE_REFERDATA = "DocumentSearchEnqueteReferData"; //文献検索アンケート詳細データ

    // ---------------------久保の追加領域 開始 担当:久保-------------------------
    public static final String SESKEY_DCS_SCR            = "dcsScreenId";       //文献検索詳細画面から一覧画面へ戻るときの戻り先画面ID
    public static final String SESKEY_DCS_FUNC       = "dcsFunctionId"; //文献検索細画面から一覧画面へ戻るときの戻り先機能ID
    //評価者メンテナンス add 2002/04/10 S.Kubo
    public static final String SESKEY_VLM_VIEWDATA = "ValuationViewData"; //評価者メンテナンス一覧制御データ
    public static final String REQKEY_VLM_DATA = "ValuationData"; //評価者メンテナンス一覧データ

    //検索市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー） add 2002/08/10 S.Kubo
    public static final String SESKEY_SMR_VIEWDATA = "SearchMakerRankingViewData"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー）一覧制御データ
    public static final String REQKEY_SMR_DATA = "SearchtMakerRankingData"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー）一覧データ

    public static final String REQKEY_SMR_MKT = "SearchMakerRankingMkt"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー）Mktデータ
    public static final String REQKEY_SMR_MAKER = "SearchtMakerRankingMaker"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー）Makerデータ

    //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（品目） add 2002/08/10 S.Kubo
    public static final String SESKEY_SRP_VIEWDATA = "SearchRankingProductViewData"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（品目）一覧制御データ
    public static final String REQKEY_SRP_DATA = "SearchRankingProductData"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（品目）一覧データ
    public static final String REQKEY_SRP_PROD = "SearchRankingProductProd"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（品目）品名データ

    //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別） add 2002/08/10 S.Kubo
    public static final String SESKEY_SRM_VIEWDATA = "SearchRankingMarketchoiceViewData"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）一覧制御データ
    public static final String REQKEY_SRM_DATA = "SearchRankingMarketchoiceData"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）一覧データ
    public static final String REQKEY_SRM_CHOICE = "SearchRankingMarketchoiceChoice"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）薬効市場データ
    public static final String REQKEY_SRM_MARKET = "MarketRankingMarketchoiceMarket"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）薬効データ
    public static final String REQKEY_SRM_SEK = "SearchRankingMarketchoiceSek"; //検索用市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）薬効データ
    //JIS市区町村選択 add 2002/08/10 S.Kubo
    public static final String REQKEY_IJC_DATA  = "ImtJIsPrefCityCategoriesData";   //JIS市区町村選択一覧データ
    public static final String SESKEY_IJC_VIEWDATA  = "ImtJisPrefCityCategoriesViewData";   //JIS市区町村選択一覧制御データ
    public static final String SESKEY_IJC_FLGDATA   = "ImtJisPrefCityCategoriesFigData";    //JIS市区町村選択Flgデータ
    //依頼状況一覧 add 2002/09/26 S.Kubo
    public static final String SESKEY_IRQ_VIEWDATA = "ImtRequestViewData"; //依頼状況一覧一覧制御データ
    public static final String REQKEY_IRQ_DATA = "ImtRequestData"; //依頼状況一覧一覧データ

    public static final String SESKEY_IRQ_CONFIRMFLGLIST = "ImtRequestconfirmFlgList"; //依頼状況一覧
    public static final String SESKEY_IRQ_STATELIST = "ImtRequestViewDataState"; //依頼状況一覧リストボックスデータ
    public static final String SESKEY_IRQ_CLASSIFICATIONLIST = "ImtRequestViewDataClass"; //依頼状況一覧リストボックスデータ
    public static final String SESKEY_IRQ_CONTENTSTYPE1LIST = "ImtRequestViewDataContens1"; //依頼状況一覧リストボックスデータ
    public static final String SESKEY_IRQ_CONTENTSTYPE2LIST = "ImtRequestViewDataContens2"; //依頼状況一覧リストボックスデータ
    public static final String SESKEY_IRQ_CONTENTSTYPE3LIST = "ImtRequestViewDataContens3"; //依頼状況一覧リストボックスデータ
    public static final String SESKEY_IRQ_CONTENTSTYPE4LIST = "ImtRequestViewDataContens4"; //依頼状況一覧リストボックスデータ
    //研究会品目選択 add 2002/11/13 S.Kubo
    public static final String SESKEY_DSC_VIEWDATA = "DmtDocStudyCategoriesViewData";   //研究会品目選択一覧制御データ
    public static final String REQKEY_DSC_DATA = "DmtDocStudyCategoriesData";           //研究会品目選択一覧データ
    //施設選択 add 2002/11/14 S.Kubo
    public static final String SESKEY_CII_VIEWDATA = "CatInstitutionViewData";          //施設選択一覧制御データ
    public static final String SESKEY_CII_INSTYPELIST = "CatInstitutionInsTypeList";    //施設選択施設区分リスト
    public static final String SESKEY_CII_PREFfJISLIST = "CatInstitutionPrefJisList";   //施設選択JIS府県リスト
    public static final String REQKEY_CII_DATA = "CatInstitutionData";                  //施設選択一覧データ
    //Add Start 2012/06/08 K.Yoshida J12-0006 Step2対応
    public static final String SESKEY_CAI_VIEWDATA = "CatAddrInfoViewData";					//宛先詳細ポップアップ一覧制御データ
    public static final String REQKEY_CAI_DATA = "CatAddrInfoData";						//宛先詳細ポップアップデータ
    //Add End   2012/06/08 K.Yoshida J12-0006 Step2対応
    //施設固定コード複数入力 add 2003/01/21 S.Kubo
    public static final String SESKEY_III_REGISTERDATA = "ImtInsInputCategoresRegisterData";    //施設固定コード複数入力一覧制御データ
    public static final String REQKEY_III_DATA = "ImtInsInputCategoresData";                    //施設固定コード複数入力一覧データ
    //外部参照施設基本詳細 add 2003/02/03 S.Kubo
    public static final String SESKEY_ICR_REFERDATA = "ImtClinicalReferenceReferData";      //外部参照施設基本詳細詳細データ
    public static final String SESKEY_ICR_REFER_SCRNDATA = "ImtClinicalReferenceScrnData";  //外部参照施設基本画面データ
    //領域選択 add 2003/02/17 S.Kubo
    public static final String SESKEY_ITS_VIEWDATA = "ImtTerritoryCategoriesViewData";  //領域選択一覧制御データ
    public static final String REQKEY_ITS_DATA = "ImtTerritoryCategoriesData";          //領域選択一覧データ

    //外部参照施設基本詳細 add 2003/02/03 S.Kubo
    public static final String SESKEY_IIA_REFERDATA = "ImtInstitutionAllSearchReferData";       //全社検索用外部参照施設基本詳細詳細データ
    public static final String SESKEY_IIA_REFER_SCRNDATA = "ImtInstitutionAllSearchScrnData";   //全社検索用外部参照施設基本画面データ

    //施設情報利用可能時間 add 2003/02/21 S.Kubo
    public static final String REQKEY_IMT_TIMECTRL_DATA = "InsMaintenanceTimeLimitData"; //施設情報利用可能時間データ

    //一括登録(実績把握区分) add 2003/02/24 S.Kubo
    public static final String SESKEY_IRR_VIEWDATA = "ImtResultRegisterViewData";   //一括変更(実績把握区分)一覧制御データ
    public static final String REQKEY_IRR_DATA = "ImtResultRegisterData";           //一括変更(実績把握区分)一覧データ

    //一括登録共通登録結果完了データ add 2003/02/28 S.Kubo
    public static final String SESKEY_LUMP_COMPDATA = "ImtLumpCompleteData";        //一括変更共通登録結果データ

    //関係会社関連項目メンテナンス add 2003/03/06 S.Kubo
    public static final String SESKEY_IAM_VIEWDATA = "ImtAffilMaintenanceViewData"; //関係会社関連項目メンテナンス一覧制御データ
    public static final String REQKEY_IAM_DATA = "ImtAffilMaintenanceData";         //関係会社関連項目メンテナンス一覧データ

    //施設グループ add 2003/03/10 S.Kubo
    public static final String SESKEY_IGM_VIEWDATA = "ImtGrpMstViewData";           //施設グループ一覧制御データ
    public static final String REQKEY_IGM_DATA = "ImtGrpMstData";                   //施設グループ一覧データ
    public static final String SESKEY_IGM_REGISTERDATA = "ImtGrpMstRegisterData";   //施設グループ登録データ
    public static final String SESKEY_IGM_MODIFYDATA = "ImtGrpMstModifyData";       //施設グループ編集データ

    //一括変更(MD区分) add 2003/04/18 S.Kubo
    public static final String SESKEY_IMD_VIEWDATA = "ImtMdRegisterViewData";       //一括変更(MD区分)一覧制御データ
    public static final String REQKEY_IMD_DATA = "ImtMdRegisterData";               //一括変更(MD区分)一覧データ

    //一括変更(来期用区分) add 2003/05/20 S.Kubo
    public static final String SESKEY_IIN_VIEWDATA = "ImtItemNextRegisterViewData"; //一括変更(来期用区分)一覧制御データ
    //modify start 2003/05/29 S.Kubo
    //関連チェック時に入力データを保持しておかなければならないのでリクエストからセッションに変更
    //public static final String REQKEY_IIN_DATA = "ImtItemNextRegisterData";           //一括変更(来期用区分)一覧データ
    public static final String SESKEY_IIN_DATA = "ImtItemNextRegisterData";         //一括変更(来期用区分)一覧データ
    public static final String SESKEY_IIN_DEFAULTDATA = "ImtItemNextRegisterDefaultData";           //一括変更(来期用区分)デフォルト一覧データ
    //modify end 2003/05/29 S.Kubo

    //add 2003/05/30 S.Kubo
    public static final String REQKEY_IIN_ERRDATA = "ImtItemNextRegisterErrorInformationReferData"; //一括変更(来期用区分)関連チェックエラー

    //変更パターン選択 add 2003/06/03 S.Kubo
    public static final String SESKEY_ICP_VIEWDATA = "ImtChangePatternCategoriesViewData"; //変更パターン選択一覧制御データ

    //施設治験研究情報登録 add 2003/07/03 S.Kubo
    public static final String SESKEY_MIC_MODIFYDATA = "InsClinicalResearchModifyData"; //施設治験研究情報登録編集データ
    public static final String SESKEY_MIC_VIEWDATA = "InsClinicalResearchViewData"; //施設治験研究情報登録一覧制御データ

    //宛先選択メンテナンス add 2003/09/01 S.Kubo
    public static final String SESKEY_ACM_VIEWDATA = "AddressChoiceMaintenanceViewData"; //宛先選択メンテナンス一覧制御データ
    public static final String REQKEY_ACM_DATA = "AddressChoiceMaintenanceData"; //宛先選択メンテナンス一覧データ

    //宛先選択メンテナンス add 2003/09/03 S.Kubo
    public static final String SESKEY_ACM_SOSVIEWDATA = "AddressChoiceMaintenanceSosViewData"; //宛先選択メンテナンス組織登録データ
    public static final String REQKEY_ACM_SOSREGISTERDATA = "AddressChoiceMaintenanceSosRegisterData"; //宛先選択メンテナンス組織登録データ
    public static final String REQKEY_ACM_SOSSUBREGISTERDATA = "AddressChoiceMaintenanceSosSubRegisterData"; //宛先選択メンテナンス組織登録データ

    //活動フロー add 2003/10/28 S.Kubo
    public static final String SESKEY_VRF_VIEWDATA = "VarReportFlowViewData"; //活動フロー一覧制御データ
    public static final String REQKEY_VRF_DATA = "VarReportFlowData"; //活動フロー一覧データ

    //活動フロー add 2003/11/01 S.Kubo
    public static final String SESKEY_VRF_REGISTERDATA = "VarReportFlowRegisterData"; //活動フロー登録データ
    public static final String REQKEY_VRF_COMPLETEDATA = "VarReportFlowRegisterCompleteData"; //活動フロー登録結果遷移用
    //製剤情報品目ポップアップ add 2004/02/23 S.Kubo
    public static final String SESKEY_PPC_VIEWDATA = "PifProductCategoriesViewData"; //製剤情報品目ポップアップ一覧制御データ
    public static final String REQKEY_PPC_DATA = "PifProductCategoriesData"; //製剤情報品目ポップアップ一覧データ
    //製剤写真情報 add 2004/02/23 S.Kubo
    public static final String SESKEY_PIL_VIEWDATA = "PifPicListViewData"; //製剤写真情報一覧制御データ
    public static final String REQKEY_PIL_DATA = "PifPicListData"; //製剤写真情報一覧データ
    //製剤写真旧包装情報 add 2004/02/24 S.Kubo
    public static final String SESKEY_PLL_VIEWDATA = "PifOldPicListViewData"; //製剤写真旧包装情報一覧制御データ
    public static final String REQKEY_PLL_DATA = "PifOldPicListData"; //製剤写真急包装情報一覧データ
    //製剤写真情報一覧 add 2004/02/24 S.Kubo
    public static final String SESKEY_PIL_REFERDATA = "PifPicListReferData"; //製剤写真情報一覧詳細データ
    //製品基本一覧 add 2004/02/25 S.Kubo
    public static final String SESKEY_PDL_VIEWDATA = "PifProdListViewData"; //製品基本一覧制御データ
    public static final String REQKEY_PDL_DATA = "PifProdListData"; //製品基本データ
    //人気情報ランキング
    public static final String REQKEY_PPL_SASDATA = "PplSasData"; //sasデータ
    public static final String REQKEY_PPL_JGIDATA = "PplJgiData"; //従業員データ
    //成績フォロー従業員履歴 add 2004/03/08 S.Kubo
    public static final String SESKEY_CJR_VIEWDATA = "CefJgiRecordViewData"; //成績フォロー従業員履歴一覧制御データ
    public static final String REQKEY_CJR_DATA = "CefJgiRecordData"; //成績フォロー従業員履歴一覧データ
    //成績フォロー従業員履歴 add 2004/03/09 S.Kubo
    public static final String SESKEY_CJR_MODIFYDATA = "CefJgiRecordModifyData"; //成績フォロー従業員履歴編集データ

    //使用の安全情報 add 2004/04/12 S.Kubo
    public static final String SESKEY_PSL_REGISTERDATA = "PifSafeListRegisterData"; //使用の安全情報登録データ
    public static final String REQKEY_PSL_COMPLETEDATA = "PifSafeListCompleteData"; //使用の安全情報画面完了データ

    //包装変更案内 add 2004/04/14 S.Kubo
    public static final String SESKEY_PCL_REGISTERDATA = "PifPackChangeListRegisterData"; //包装変更案内登録データ
    public static final String REQKEY_PCL_COMPLETEDATA = "PifPackChangeListCompleteData"; //包装変更案内画面完了データ

    //品名選択 add 2004/04/16 S.Kubo
    public static final String SESKEY_PAC_VIEWDATA = "PifPackCategoriesViewData"; //品名選択一覧制御データ
    public static final String REQKEY_PAC_DATA = "PifPackCategoriesData"; //品名選択一覧データ

    //製品基本 add 2004/04/19 S.Kubo
    public static final String SESKEY_PDL_REGISTERDATA = "PifProdListRegisterData"; //製品基本登録データ
    public static final String SESKEY_PDL_REFERDATA = "PifProdListReferData"; //製品基本データ
    public static final String REQKEY_PDL_COMPLETEDATA = "PifProdListCompleteData"; //包装変更案内画面完了データ

    //納入４次  担当者別表 add 2004/06/08 S.Kubo
    public static final String PSN_PACK_MODEL       = "model";  //change constant of access object：剤型
    public static final String PSN_PACK_CAPA        = "capa";   //change constant of access object：容量
    public static final String PSN_PACK_WRAP        = "wrap";   //change constant of access object：包装

    //コンテンツメール add 2004/06/24 S.Kubo
    public static final String SESKEY_ECA_VIEWDATA = "EdtContentsMailViewData"; //コンテンツメール一覧制御データ
    public static final String REQKEY_ECA_DATA = "EdtContentsMailData"; //コンテンツメール一覧データ
    //コンテンツメール add 2004/06/28 S.Kubo
    public static final String SESKEY_ECA_REFERDATA = "EdtContentsMailReferData"; //コンテンツメール詳細データ
    public static final String SESKEY_EDT_HTMLDATA = "EdtHtmlData"; //HTMLデータ
    public static final String REQKEY_ECM_ERRDATA = "EcmEcomErrDataList"; //eコミュニケーション送付一覧データ
    //未接続ＵＬＴ情報 add 2004/09/13 S.Kubo
    public static final String SESKEY_UUC_VIEWDATA = "UltUnConnectViewData"; //未接続ＵＬＴ情報一覧制御データ
    public static final String REQKEY_UUC_DATA = "UltUnConnectData"; //未接続ＵＬＴ情報一覧データ

    //未接続ＵＬＴ情報 add 2004/09/30 S.Kubo
    public static final String SESKEY_UUC_REFERDATA = "UltUnConnectReferData"; //未接続ＵＬＴ情報詳細データ
    //未接続ＵＬＴ情報 add 2004/10/04 S.Kubo
    public static final String SESKEY_UUI_REFERDATA = "UltUnConnectInfoReferData"; //未接続ＵＬＴ情報詳細データ
    public static final String SESKEY_UUI_VIEWDATA = "UltUnConnectInfoViewData"; //未接続ＵＬＴ情報一覧制御データ
    public static final String REQKEY_UUI_DATA = "UltUnConnectInfoData"; //未接続ＵＬＴ情報一覧データ
    public static final String SESKEY_UUI_REGISTERDATA = "UltUnConnectInfoRegisterData"; //未接続ＵＬＴ情報登録データ

    // ---------------------山田の追加領域 開始 担当:山田-------------------------
    //削除・復活対象施設検索 add 2002/10/02 Y.Yamada
    public static final String SESKEY_IID_VIEWDATA = "ImtInstitutionDelSearchViewData"; //削除・復活対象施設検索一覧制御データ
    public static final String REQKEY_IID_DATA = "ImtInstitutionDelSearchData"; //削除・復活対象施設検索一覧データ
    public static final String REQKEY_IID_CLASS = "ImtInstitutionDelSearchClass"; //施設分類リスト
    public static final String REQKEY_IID_TYPE = "ImtInstitutionDelSearchTypeList"; //対象区分リスト
    public static final String REQKEY_IID_JIS = "ImtInstitutionDelSearchJISList"; //JIS府県リスト

    //調剤薬局登録 add 2002/10/09 Y.Yamada
    public static final String SESKEY_IDI_REGISTERDATA = "ImtDispensaryRegisterData"; //調剤薬局登録データ

    //病院・診療所変更 add 2002/10/15 Y.Yamada
    public static final String SESKEY_ICL_MODIFYDATA = "ImtClinicalModifyData"; //病院・診療所変更編集データ

    //施設検索 add 2002/12/10 Y.Yamada
    public static final String SESKEY_IIS_1_VIEWDATA = "Im1InstitutionSearchViewData"; //施設検索一覧制御データ
    public static final String REQKEY_IIS_1_DATA = "Im1InstitutionSearchData"; //施設検索一覧データ
    public static final String REQKEY_IIS_1_TYPE = "Im1InstitutionSearchTypeList"; //対象区分リスト
    public static final String REQKEY_IIS_1_INS_CLASS = "Im1InstitutionSearchInsClassList"; //施設分類リスト
    public static final String REQKEY_IIS_1_BEDS_TOT = "Im1InstitutionSearchBedsTotList"; //病床数リスト

    //施設基本 add 2002/12/10 Y.Yamada
    public static final String SESKEY_IM1_MENUDATA = "InsMaintenance1MenuData"; //施設基本メニューデータ

    //施設基本 add 2002/10/24 Y.Ueda
    public static final String REQKEY_IM1_AUTHDATA = "HashMap"; //施設基本メニュー権限データ

    //全社施設検索 add 2002/12/25 Y.Yamada
    public static final String SESKEY_IIA_VIEWDATA = "ImtInstitutionAllSearchViewData"; //施設検索一覧制御データ
    public static final String REQKEY_IIA_DATA = "ImtInstitutionAllSearchData"; //施設検索一覧データ
    public static final String REQKEY_IIA_TYPE = "ImtInstitutionAllSearchTypeList"; //対象区分リスト
    public static final String REQKEY_IIA_INS_CLASS = "ImtInstitutionAllSearchInsClassList"; //施設分類リスト
    public static final String REQKEY_IIA_BEDS_TOT = "ImtInstitutionAllSearchBedsTotList"; //病床数リスト
    public static final String REQKEY_IIA_PREF = "ImtInstitutionAllSearchPrefList"; //都道府県リスト
    public static final String REQKEY_IIA_MANAGE = "ImtInstitutionAllSearchManageList"; //経営主体リスト
    public static final String REQKEY_IIA_ULTINSKIND = "ImtInstitutionAllSearchUltInsKindList"; //施設種類リスト J12-0006 2012/6/20 uchida

    //施設タブ項目取得 add 2003/01/15 Y.Yamada
    public static final String SESKEY_IMT_TABCTRL_DATA = "Tab_ArrayList";  //施設基本タブ項目管理データ(参照)
    public static final String SESKEY_IMT_REF_TABDATA = "Ref_ArrayList";   //施設基本タブ項目管理データ(参照)
    public static final String SESKEY_IMT_REG_TABDATA = "Reg_ArrayList";   //施設基本タブ項目管理データ(新規登録)
    public static final String SESKEY_IMT_MOD_TABDATA = "Mod_ArrayList";   //施設基本タブ項目管理データ(変更)
    public static final String SESKEY_IMT_RECG_TABDATA = "Recg_ArrayList"; //施設基本タブ項目管理データ(承認)

    public static final String REQKEY_IMT_TABID = "Tab_ID";                //施設基本初期表示時のタブID

    // ---------------------関の追加領域 開始 担当:関-------------------------
    //市場情報 add 2002/04/03 T.Seki
    public static final String SESKEY_MRC_VIEWDATA = "MarketResearchViewData"; //市場情報一覧制御データ
    public static final String REQKEY_MRC_DATA = "MarketResearchData"; //市場情報一覧データ
        //seki
    public static final String REQKEY_MRC_DISPDATE = "MarketResearchDispDate"; //日付表示データ
    public static final String REQKEY_MRC_JGI = "MarketResearchJgi"; //条件セットデータ
        //seki

    //市場情報　新製品速報（支店別） add 2002/04/05 T.Seki
    public static final String SESKEY_NPB_VIEWDATA = "NewProdBranchViewData"; //市場情報　新製品速報（支店別）一覧制御データ
    public static final String REQKEY_NPB_DATA = "NewProdBranchData"; //市場情報　新製品速報（支店別）一覧データ
        //seki
    public static final String REQKEY_NPB_DATA_SUM = "NewProdBranchDataSum"; //新製品速報（営業所別）集計データ
        //seki

    //市場情報 新製品速報（担当施設別） add 2002/04/10 T.Seki
    public static final String SESKEY_NPI_VIEWDATA = "NewProdInsViewData"; //市場情報 新製品速報（担当施設別）一覧制御データ
    public static final String REQKEY_NPI_DATA = "NewProdInsData"; //市場情報 新製品速報（担当施設別）一覧データ

        //seki
    public static final String REQKEY_NPI_DATA_SUM = "NewProdInsDataSum"; //新製品速報（担当施設別）集計データ
        //seki


    //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー） add 2002/04/16 T.Seki
    public static final String SESKEY_MMR_VIEWDATA = "MarketMakerRankingViewData"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー）一覧制御データ
    public static final String REQKEY_MMR_DATA = "MarketMakerRankingData"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー）一覧データ

    public static final String REQKEY_MMR_MKT = "MarketMakerRankingMkt"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー）Mktデータ
    public static final String REQKEY_MMR_MAKER = "MarketMakerRankingMaker"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効メーカー）Makerデータ

    //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（品目） add 2002/04/17 T.Seki
    public static final String SESKEY_MRP_VIEWDATA = "MarketRankingProductViewData"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（品目）一覧制御データ
    public static final String REQKEY_MRP_DATA = "MarketRankingProductData"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（品目）一覧データ
    public static final String REQKEY_MRP_PROD = "MarketRankingProductProd"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（品目）品名データ

    //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別） add 2002/04/18 T.Seki
    public static final String SESKEY_MRM_VIEWDATA = "MarketRankingMarketchoiceViewData"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）一覧制御データ
    public static final String REQKEY_MRM_DATA = "MarketRankingMarketchoiceData"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）一覧データ
    public static final String REQKEY_MRM_CHOICE = "MarketRankingMarketchoiceChoice"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）薬効市場データ
    public static final String REQKEY_MRM_MARKET = "MarketRankingMarketchoiceMarket"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）薬効データ
    public static final String REQKEY_MRM_SEK = "MarketRankingMarketchoiceSek"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（薬効市場別）薬効データ

    //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（対抗品目） add 2002/04/20 T.Seki
    public static final String SESKEY_MRR_VIEWDATA = "MarketRankingRivalViewData"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（対抗品目）一覧制御データ
    public static final String REQKEY_MRR_DATA = "MarketRankingRivalData"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（対抗品目）一覧データ
    public static final String REQKEY_MRR_PROD = "MarketRankingRivalProd"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（対抗品目）PRODデータ


    //seki 0512
    public static final String REQKEY_MRR_SHARE1 = "MarketRankingRivalShare1Data"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（対抗品目）SHARE1データ
    public static final String REQKEY_MRR_SHARE2 = "MarketRankingRivalShare2Data"; //市場情報 施設別薬効市場ﾗﾝｷﾝｸﾞ（対抗品目）SHARE2データ
    public static final String REQKEY_WMR_SHARE1 = "WholeMarketShareData1"; //市場情報施設別薬効市場ﾗﾝｷﾝｸﾞ（残市場）SHARE1
    public static final String REQKEY_WMR_SHARE2 = "WholeMarketShareData2"; //市場情報施設別薬効市場ﾗﾝｷﾝｸﾞ（残市場）SHARE2

    //ＡＣＥ要素別評価アップロード add 2002/05/14 T.Seki
    public static final String SESKEY_ACE_VIEWDATA = "AceUpLoadRegisterData"; //ＡＣＥ要素別評価アップロード一覧制御データ
    public static final String REQKEY_ACE_DATA = "AceUpLoadData"; //ＡＣＥ要素別評価アップロード一覧データ

    //安全性情報関連 月間累計参照画面 add 2002/06/05 T.Seki
    public static final String SESKEY_SMS_VIEWDATA = "SafeInfoMonthSumViewData"; //安全性情報関連 月間累計参照画面一覧制御データ
    public static final String REQKEY_SMS_DATA = "SafeInfoMonthSumData"; //安全性情報関連 月間累計参照画面一覧データ

    //納入 PS納入実績 施設別表 add 2002/06/10 T.Seki
    public static final String SESKEY_INS_VIEWDATA = "InstitutionViewData"; //納入 PS納入実績 施設別表一覧制御データ
    public static final String REQKEY_INS_DATA = "InstitutionData"; //納入 PS納入実績 施設別表一覧データ

    //PS納入実績 担当者組織別表 add 2002/06/19 T.Seki
    public static final String SESKEY_PSN_VIEWDATA = "PersonViewData"; //PS納入実績 担当者組織別表一覧制御データ
    public static final String REQKEY_PSN_DATA = "PersonData"; //PS納入実績 担当者組織別表一覧データ


    //社内教育用資料 プロダクトニュース管理用画面 add 2002/07/23 T.Seki
    public static final String SESKEY_APN_VIEWDATA = "AdminPnewsViewData"; //社内教育用資料 プロダクトニュース管理用画面一覧制御データ
    public static final String REQKEY_APN_DATA = "AdminPnewsData"; //社内教育用資料 プロダクトニュース管理用画面一覧データ

    //社内教育用資料 医薬情報管理用画面 add 2002/07/23 T.Seki
    public static final String SESKEY_ADI_VIEWDATA = "AdminDinfoViewData"; //社内教育用資料 医薬情報管理用画面一覧制御データ
    public static final String REQKEY_ADI_DATA = "AdminDinfoData"; //社内教育用資料 医薬情報管理用画面一覧データ


    //社内教育用資料 ワクチンニュース管理用画面 add 2002/07/23 T.Seki
    public static final String SESKEY_AWN_VIEWDATA = "AdminWnewsViewData"; //社内教育用資料 ワクチンニュース管理用画面一覧制御データ
    public static final String REQKEY_AWN_DATA = "AdminWnewsData"; //社内教育用資料 ワクチンニュース管理用画面一覧データ


    //社内教育用資料 医薬情報管理用画面 add 2002/08/05 T.Seki
    public static final String SESKEY_ADI_REGISTERDATA = "AdminDinfoRegisterData"; //社内教育用資料 医薬情報管理用画面登録データ


    //情報活動材料 管理用画面 add 2002/08/20 T.Seki
    public static final String SESKEY_AAS_REGISTERDATA = "AdminActivitySupportRegisterData"; //情報活動材料 管理用画面登録データ

    //品目別特約店別実績表 add 2002/08/28 T.Seki
    public static final String SESKEY_PWN_VIEWDATA = "ProductWsNmlViewData"; //品目別特約店別実績表一覧制御データ
    public static final String REQKEY_PWN_DATA = "ProductWsNmlData"; //品目別特約店別実績表一覧データ


    //品目別特約店別実績表（施設別展開） add 2002/08/28 T.Seki
    public static final String SESKEY_PWI_VIEWDATA = "ProductWsInsViewData"; //品目別特約店別実績表（施設別展開）一覧制御データ
    public static final String REQKEY_PWI_DATA = "ProductWsInsData"; //品目別特約店別実績表（施設別展開）一覧データ


    //品質情報一覧 add 2002/10/24 T.Seki
    public static final String SESKEY_QAL_VIEWDATA = "QualityViewData"; //品質情報一覧一覧制御データ
    public static final String REQKEY_QAL_DATA = "QualityData"; //品質情報一覧一覧データ


    //品質情報品目ポップアップ add 2002/10/24 T.Seki
    public static final String SESKEY_QPC_VIEWDATA = "QicProdCategoriesViewData"; //品質情報品目ポップアップ一覧制御データ
    public static final String REQKEY_QPC_DATA = "QicProdCategoriesData"; //品質情報品目ポップアップ一覧データ

    //品質情報報告書詳細 add 2002/10/24 T.Seki
    public static final String SESKEY_QAL_REFERDATA = "QualityReferData"; //品質情報報告書詳細詳細データ

    //品質情報報告書編集 add 2002/10/24 T.Seki
    public static final String SESKEY_QAL_REGISTERDATA = "QualityRegisterData"; //品質情報報告書編集登録データ

    //品質情報処置報告書詳細 add 2002/10/25 T.Seki
    public static final String SESKEY_DIS_REFERDATA = "DisposalReferData"; //品質情報処置報告書詳細詳細データ



    //品質情報処置報告書編集 add 2002/10/25 T.Seki
    public static final String SESKEY_DIS_REGISTERDATA = "DisposalRegisterData"; //品質情報処置報告書編集登録データ

    //品質情報承認 add 2002/11/05 T.Seki
    public static final String SESKEY_AMI_MODIFYDATA = "AdmissionModifyData"; //品質情報承認編集データ

    //品質情報回答日 add 2002/11/05 T.Seki
    public static final String SESKEY_ANS_MODIFYDATA = "AnswerModifyData"; //品質情報回答日編集データ




    // ---------------------植田の追加領域 開始 担当:植田-------------------------
    //特約店別品目別実績表（施設別展開） add 2002/09/02 Y.Ueda
    public static final String SESKEY_WPI_VIEWDATA = "WsProductInsViewData"; //特約店別品目別実績表（施設別展開）一覧制御データ
    public static final String REQKEY_WPI_DATA = "WsProductInsData"; //特約店別品目別実績表（施設別展開）一覧データ

    //代行組織選択 add 2002/09/17 Y.Ueda
    public static final String SESKEY_IRC_VIEWDATA = "ImtRepSosCategoriesViewData"; //代行組織選択一覧制御データ
    public static final String REQKEY_IRC_ALL = "ImtRepSosCategoriesDataAll"; //代行組織選択一覧データ
    public static final String REQKEY_IRC_REP = "ImtRepSosCategoriesDataRepCnt"; //未処理件数データ
    public static final String REQKEY_IRC_TYPE = "ImtRepSosCategoriesDataType"; //組織区分データ
    public static final String REQKEY_IRC_TITLE = "ImtRepSosCategoriesDataTitleName"; //履歴データ(名称)
    public static final String REQKEY_IRC_CODE = "ImtRepSosCategoriesDataTitleCode"; //履歴データ(コード)
    public static final String REQKEY_IRC_RECG = "ImtRepSosCategoriesDataTitleRecg"; //承認グループ
    //add 2003/06/26 S.Kubo 支店表示用
    public static final String REQKEY_IRC_BR = "ImtRepSosCategoriesDataBrRepCnt"; //未処理件数(営業所合計)の設定

    //施設検索 add 2002/09/25 Y.Ueda
    public static final String SESKEY_IIS_VIEWDATA = "ImtInstitutionSearchViewData"; //施設検索一覧制御データ
    public static final String REQKEY_IIS_DATA = "ImtInstitutionSearchData"; //施設検索一覧データ
    public static final String REQKEY_IIS_TYPE = "ImtInstitutionSearchTypeList"; //対象区分リスト
    public static final String REQKEY_IIS_DIS_TYPE = "ImtInstitutionSearchDispensaryTypeList"; //調剤薬局区分リスト
    public static final String REQKEY_IIS_INS_CLASS = "ImtInstitutionSearchInsClassList"; //施設分類リスト
    public static final String REQKEY_IIS_BEDS_TOT = "ImtInstitutionSearchBedsTotList"; //病床数リスト

    //調剤薬局変更 add 2002/10/07 Y.Ueda
    public static final String SESKEY_IDI_MODIFYDATA = "ImtDispensaryModifyData"; //調剤薬局変更編集データ

    //住所選択 add 2002/10/16 Y.Ueda
    public static final String SESKEY_IAC_VIEWDATA = "ImtAddrCategoriesViewData"; //住所選択一覧制御データ
    public static final String REQKEY_IAC_DATA = "ImtAddrCategoriesData"; //住所選択一覧データ

    //施設基本 add 2002/10/24 Y.Ueda
    public static final String REQKEY_IMT_AUTHDATA = "HashMap"; //施設基本メニュー権限データ

    //施設基本 add 2002/10/25 Y.Ueda
    public static final String SESKEY_IMT_REGISTER_SCRNDATA = "Register_ArrayList"; //施設基本画面利用権限データ(登録)
    public static final String SESKEY_IM1_REGISTER_SCRNDATA = "Register_HashMap"; //施設基本画面利用権限データ(登録)
    public static final String SESKEY_IMT_REGISTER_TABDATA = "Register_ArrayList"; //施設基本タブ利用権限データ(登録)
    public static final String SESKEY_IM1_REGISTER_TABDATA = "Register_ArrayList"; //施設基本タブ利用権限データ(登録)
    //public static final String SESKEY_IMT_REFER_SCRNDATA = "Refer_HashMap"; //施設基本画面利用権限データ(参照)
    public static final String SESKEY_IMT_REFER_SCRNDATA = "Refer_ArrayList"; //施設基本画面利用権限データ(参照)
    public static final String SESKEY_IM1_REFER_SCRNDATA = "Refer_HashMap"; //施設基本画面利用権限データ(参照)
    public static final String SESKEY_IMT_REFER_TABDATA = "Refer_ArrayList"; //施設基本タブ利用権限データ(参照)
    public static final String SESKEY_IM1_REFER_TABDATA = "Refer_ArrayList"; //施設基本タブ利用権限データ(参照)
    public static final String SESKEY_IMT_SCRNDATA = "HashMap"; //施設基本画面利用権限データ(ダミー)
    public static final String SESKEY_IM1_SCRNDATA = "HashMap"; //施設基本画面利用権限データ(ダミー)
    public static final String SESKEY_IMT_TABDATA = "ArrayList"; //施設基本タブ利用権限データ(ダミー)
    public static final String SESKEY_IM1_TABDATA = "ArrayList"; //施設基本タブ利用権限データ(ダミー)
    public static final String SESKEY_IMT_PARENT_REFERDATA = "InsMaintenanceParentReferData"; //施設基本親施設用参照データ(登録)

    //施設基本 add 2003/02/06 Y.Ueda
    public static final String SESKEY_IMT_PASS_COMPLETEDATA = "InsMaintenanceCompleteData"; //登録結果渡し用データ

    //施設基本 add 2003/02/13 Y.Ueda
    public static final String SESKEY_IMT_MODIFY_SCRNDATA = "Modify_ArrayList"; //施設基本画面利用権限データ(変更)
    public static final String SESKEY_IMT_MODIFYDATA = "InsMaintenanceModifyData"; //施設基本画面利用権限データ(変更)
    public static final String SESKEY_IMT_MODIFY_REFERDATA = "InsMaintenanceModifyReferData"; //施設基本画面利用権限データ(変更)

    //日次変更チェックリスト add 2003/02/21 Y.Ueda
    public static final String SESKEY_ICC_VIEWDATA = "ImtChangeCheckListViewData"; //日次変更チェックリスト一覧制御データ
    public static final String REQKEY_ICC_DATA = "ImtChangeCheckListData"; //日次変更チェックリスト一覧データ

    //全件表示ポップアップ（治験２） add 2003/07/03 Y.Ueda
    public static final String SESKEY_DSV_VIEWDATA = "DocCrSecondViewData"; //全件表示ポップアップ（治験２）一覧制御データ
    public static final String REQKEY_DSV_DATA = "DocCrSecondData"; //全件表示ポップアップ（治験２）一覧データ

    //グループ編集 add 2003/08/19 Y.Ueda
    public static final String SESKEY_DGM_MODIFYDATA = "DmcGrpModifyModifyData"; //グループ編集データ

    //グループ詳細 add 2003/08/21 Y.Ueda
    public static final String SESKEY_DGD_VIEWDATA = "DmcGrpDocSearchViewData"; //グループ詳細一覧制御データ
    public static final String REQKEY_DGD_DATA = "DmcGrpDocSearchData"; //グループ詳細一覧データ

    // ---------------------鞆の追加領域 開始 担当:鞆-------------------------

    //納入 PS納入実績 施設別表 add 2002/06/10 T.Seki
    public static final String SESKEY_QIG_VIEWDATA = "QicInstitutionViewData"; //納入 PS納入実績 施設別表一覧制御データ
    public static final String REQKEY_QIG_DATA = "QicInstitutionData"; //納入 PS納入実績 施設別表一覧データ
    //医師基本検索２一覧画面 add 2002/11/19 M.Tomo
    public static final String SESKEY_DMV_VIEWDATA = "DmtMaintenanceViewViewData"; //医師基本検索２一覧画面一覧制御データ
    public static final String REQKEY_DMV_DATA = "DmtMaintenanceViewData"; //医師基本検索２一覧画面一覧データ
    //特約店参照メンテナンス add 2002/12/18 M.Tomo
    public static final String SESKEY_NSM_REGISTERDATA = "NjySosWsMaintenanceRegisterData"; //特約店参照メンテナンス登録データ

    //担当内外医師検索（検索1） add 2003/01/07 M.Tomo
    public static final String SESKEY_DDA_VIEWDATA = "DmcDoctorAllSearchViewData"; //担当内外医師検索（検索1）一覧制御データ
    public static final String REQKEY_DDA_DATA = "DmcDoctorAllSearchData"; //担当内外医師検索（検索1）一覧データ
    //担当医師検索 add 2003/01/17 M.Tomo
    public static final String SESKEY_DDM_VIEWDATA = "DmcDoctorMrSearchViewData"; //担当医師検索一覧制御データ
    public static final String REQKEY_DDM_DATA = "DmcDoctorMrSearchData"; //担当医師検索一覧データ

    //リクエスト状況 add 2003/02/19 M.Tomo
    public static final String SESKEY_DRS_VIEWDATA = "DmcRequestSearchViewData"; //リクエスト状況一覧制御データ
    public static final String REQKEY_DRS_DATA = "DmcRequestSearchData"; //リクエスト状況一覧データ

    //受入れ add 2003/02/25 M.Tomo
    public static final String SESKEY_DDC_REFERDATA = "DmcDocInsChangeReferData"; //参照データ 登録時にも使用するのでセッションに格納

    //医師情報一括編集 add 2003/03/05 M.Tomo
    public static final String SESKEY_DTM_VIEWDATA = "DmcDocTblViewData"; // 医師情報一括編集一覧制御データ
    public static final String SESKEY_DTM_DATA     = "DmcDocTblData";     // 医師情報一括編集表示編集対象データ

    //新製品情報 add 2003/03/17 M.Tomo
    public static final String SESKEY_MMP_VIEWDATA = "MarketMainProdViewData"; //新製品情報一覧制御データ
    public static final String REQKEY_MMP_DATA = "MarketMainProdData"; //新製品情報一覧データ

    //医師情報一括編集２ add 2003/06/25 M.Tomo
    public static final String SESKEY_DTN_VIEWDATA = "DmcDocTblTwoViewData"; //医師情報一括編集２一覧制御データ
    public static final String SESKEY_DTN_DATA = "DmcDocTblTwoData"; //医師情報一括編集２一覧/編集データ

    //医師グループ新規登録 add 2003/08/05 M.Tomo
    public static final String REQKEY_DGI_REGISTERDATA = "DmcGrpInsItemData"; //グループ種別一覧データ

    //医師グループ検索 add 2003/08/11 M.Tomo
    public static final String SESKEY_DGS_VIEWDATA = "DmcGrpSearchViewData"; //医師グループ検索一覧制御データ
    public static final String REQKEY_DGS_DATA = "DmcGrpSearchData"; //医師グループ検索一覧データ
    public static final String SESKEY_DGS_TYPEDATA = "DmcGrpSeachTypeData"; // グループ種別アイテムデータ

    //医師グループ登録 add 2003/08/14 M.Tomo
    public static final String SESKEY_DGT_SESSIONDATA = "DmcGrpDocInsSessionData"; //医師グループ登録/検索条件/詳細データ
    public static final String REQKEY_DGT_REQUESTDATA = "DmcGrpDocInsRequestData"; //医師グループ登録検索結果データ

    //Ae情報報告書一覧 add 2003/09/08 M.Tomo
    public static final String SESKEY_AER_VIEWDATA = "AeiInfoReportViewData"; //Ae情報報告書一覧一覧制御データ
    public static final String REQKEY_AER_DATA = "AeiInfoReportData"; //Ae情報報告書一覧一覧データ

    //AE情報品目選択 add 2003/09/11 M.Tomo
    public static final String SESKEY_AEC_VIEWDATA = "AeiInfoCategoriesViewData"; //AE情報品目選択一覧制御データ
    public static final String REQKEY_AEC_DATA = "AeiInfoCategoriesData"; //AE情報品目選択一覧データ

    //AE情報報告書詳細 add 2003/09/12 M.Tomo
    public static final String SESKEY_AED_REFERDATA = "AeiInfoDetailReferData"; //AE情報報告書詳細現在表示中データID
    public static final String REQKEY_AED_DATA = "AeiInfoDetailData"; //AE情報報告書詳細データ

    //AE情報報告書承認 add 2003/09/18 M.Tomo
    public static final String REQKEY_AEA_DATA = "AeiInfoAdmissionModifyData"; //AE情報報告書承認編集データ

    //AE情報報告書承認 add 2003/09/18 M.Tomo
    public static final String SESKEY_AEM_DATA = "AeiInfoCommentTimestamp";  //AE情報報告書コメント編集最終変更時刻
    public static final String REQKEY_AEM_DATA = "AeiInfoCommentModifyData"; //AE情報報告書コメント編集データ

    //AE情報管理一覧 add 2003/09/30 M.Tomo
    public static final String SESKEY_AAL_VIEWDATA = "AeiAdminListViewData"; //AE情報管理一覧制御データ
    public static final String REQKEY_AAL_DATA = "AeiAdminListData"; //AE情報管理一覧データ

    //AE情報管理詳細 add 2003/09/30 M.Tomo
    public static final String SESKEY_AAD_REFERDATA = "AeiAdminReferData"; //AE情報管理詳細現在表示中データID
    public static final String REQKEY_AAD_DATA = "AeiAdminData"; //AE情報管理詳細データ

    //継続教育メニュー add 2004/01/30 M.Tomo
    public static final String SESKEY_CEF_INQUIRY = "CefUserRightInquiry"; //継続教育フォロー共通の権限問い合わせオブジェクト

    //継続教育 管理：計画作成 add 2004/02/03 M.Tomo
    public static final String REQKEY_CDR_DATA = "CefDistInfoRegisterData"; // 計画作成登録情報
    public static final String SESKEY_CDR_LASTUPDATE   = "CefLastUpdate"; // 営業所フォーム最終更新時刻

    //継続教育　継続教育フォロー要承認一覧 2004/02/09 M.TOMO
    public static final String REQKEY_CDL_DIST_DATA    = "CdlDistData";                      //  営業所データ
    public static final String REQKEY_CDL_PERSON_DATA  = "CdlPersonData";                    //  担当者データ
    public static final String REQKEY_CDL_SUBJECT_LIST = "CdlSubjectList";                   //  科目リスト
    public static final String REQKEY_CDL_DIST_LIST    = "CdlDistList";                      //  営業所リスト
    public static final String REQKEY_CDL_PERSON_LIST  = "CdlPersonList";                    //  担当書リスト
    public static final String SESKEY_CDL_VIEWDATA     = "CefAdmissionRegisterListViewData"; //  営業所一覧用ViewData

    //継続教育　営業所詳細 M.TOMO
    public static final String REQKEY_CDI_WORKDATA     = "CefDistInformWorkData";            //  営業所詳細作業データ

    //継続教育　月別科目展開 M.TOMO
    public static final String REQKEY_CML_DIST_DATA    = "CmlDistData";            //  営業所データ
    public static final String REQKEY_CML_PERSON_DATA  = "CmlPersonData";          //  担当者データ
    public static final String REQKEY_CML_SUBJECT_LIST = "CmlSubjectList";         //  科目リスト
    public static final String REQKEY_CML_DIST_LIST    = "CmlDistList";            //  営業所リスト
    public static final String REQKEY_CML_PERSON_LIST  = "CmlPersonList";          //  担当書リスト
    public static final String SESKEY_CML_VIEWDATA     = "CefMonthlyListViewData"; //  営業所一覧用ViewData

    //継続教育　担当者／営業所情報 M.TOMO
    public static final String SESKEY_CPL_VIEWDATA     = "CefPersonDistListViewData";
    public static final String REQKEY_CPL_DATA         = "CefPersonDistListData";
    public static final String REQKEY_CPL_SUBJECT_LIST = "CefPersonDistListSubjectList";

    // ---------------------成瀬の追加領域 開始 担当:成瀬-------------------------

    //研究会情報検索 add 2003/01/22 I.Naruse
    public static final String SESKEY_DSS_VIEWDATA = "DmcStudySearchViewData"; //研究会情報検索一覧制御データ
    public static final String REQKEY_DSS_DATA = "DmcStudySearchData"; //研究会情報検索一覧データ

    //医師基本メニュー add 2003/02/05 I.Naruse
    public static final String SESKEY_DBM_VIEWDATA = "DmcBasicMenuViewData"; //医師基本メニュー一覧制御データ
    public static final String REQKEY_DBM_DATA = "DmcBasicMenuData"; //医師基本メニュー一覧データ

    //研究会登録 add 2003/02/17 I.Naruse
    public static final String SESKEY_DSR_REGISTERDATA = "DmcStudyRRegisterData"; //研究会登録登録データ

    //研究会編集 add 2003/02/21 I.Naruse
    public static final String SESKEY_DSM_MODIFYDATA = "DmcStudyMModifyData"; //研究会編集データ

    //Dr参加状況一覧 add 2003/02/26 I.Naruse
    public static final String SESKEY_DPT_VIEWDATA = "DmcDocPartVViewData"; //Dr参加状況一覧一覧制御データ
    public static final String REQKEY_DPT_DATA = "DmcDocPartVData"; //Dr参加状況一覧一覧データ

    //代行権限 add 2003/07/02 I.Naruse
    public static final String SESKEY_ACR_VIEWDATA = "RightViewData"; //代行権限一覧制御データ
    public static final String REQKEY_ACR_DATA = "RightData"; //代行権限一覧データ
    public static final String REQKEY_ACR_MODIFYDATA = "RightModifyData"; //代行権限編集データ

    //医師送出し依頼情報 add 2003/08/12 I.Naruse
    public static final String SESKEY_DCO_MODIFYDATA = "DmcDocInsOutCancelModifyData"; //医師送出し依頼情報編集データ

    //同行指導:一覧タブ add 2004/02/03 I.Naruse
    public static final String SESKEY_CKL_VIEWDATA = "CefDokoListViewData"; //同行指導:一覧タブ一覧制御データ
    public static final String REQKEY_CKL_DATA = "CefDokoListData"; //同行指導:一覧タブ一覧データ

    //同行指導:月別一覧タブ add 2004/02/08 I.Naruse
    public static final String SESKEY_CKM_VIEWDATA = "CefDokoMonthlyListViewData"; //同行指導:月別一覧タブ一覧制御データ
    public static final String REQKEY_CKM_DATA = "CefDokoMonthlyListData"; //同行指導:月別一覧タブ一覧データ

    //管理:担当者　MR一覧 add 2004/02/11 I.Naruse
    public static final String SESKEY_CMR_VIEWDATA = "CefMrRegisterListViewData"; //管理:担当者　MR一覧一覧制御データ
    public static final String REQKEY_CMR_DATA = "CefMrRegisterListData"; //管理:担当者　MR一覧一覧データ

    //管理:担当者　内勤者一覧 add 2004/02/17 I.Naruse
    public static final String SESKEY_CWR_VIEWDATA = "CefWorkerRegisterListViewData"; //管理:担当者　内勤者一覧一覧制御データ
    public static final String REQKEY_CWR_DATA = "CefWorkerRegisterListData"; //管理:担当者　内勤者一覧一覧データ

    //出欠状況 add 2004/02/19 I.Naruse
    public static final String SESKEY_CAD_REFERDATA = "CefAttendanceReferData"; //出欠状況詳細データ

    //使用の安全情報一覧 add 2004/02/23 I.Naruse
    public static final String SESKEY_PSL_VIEWDATA = "PifSafeListViewData"; //使用の安全情報一覧一覧制御データ
    public static final String REQKEY_PSL_DATA = "PifSafeListData"; //使用の安全情報一覧一覧データ

    //使用の安全情報詳細 add 2004/02/24 I.Naruse
    public static final String SESKEY_PSL_REFERDATA = "PifSafeListReferData"; //使用の安全情報詳細詳細データ

    //包装変更一覧 add 2004/02/25 I.Naruse
    public static final String SESKEY_PCL_VIEWDATA = "PifPackChangeListViewData"; //包装変更一覧一覧制御データ
    public static final String REQKEY_PCL_DATA = "PifPackChangeListData"; //包装変更一覧一覧データ

    //包装変更詳細 add 2004/02/25 I.Naruse
    public static final String SESKEY_PCL_REFERDATA = "PifPackChangeListReferData"; //包装変更詳細詳細データ

    //同行指導詳細 add 2004/03/01 I.Naruse
    public static final String SESKEY_CKI_REGISTERDATA = "CefDokoInfoRegisterData"; //同行指導詳細登録データ

    //ミシュランコメント振り分け add 2004/10/10 I.Naruse
    public static final String SESKEY_AKM_VIEWDATA = "AdminKnowledgeMichelinViewData"; //ミシュランコメント振り分け一覧制御データ
    public static final String REQKEY_AKM_DATA = "AdminKnowledgeMichelinData"; //ミシュランコメント振り分け一覧データ

    //勝敗表施設別登録 add 2004/10/19 I.Naruse
    public static final String SESKEY_MRI_VIEWDATA = "MrvInsViewData"; //勝敗表施設別登録一覧制御データ
    public static final String REQKEY_MRI_DATA = "MrvInsData"; //勝敗表施設別登録一覧データ

    //宝島 IS情報 add 2004/10/25 I.Naruse
    public static final String SESKEY_TKI_REGISTERDATA = "TkrIsRegisterData"; //宝島 IS情報登録データ

    //活動履歴 add 2005/03/23 I.Naruse
    public static final String SESKEY_AAH_VIEWDATA = "AseActHistViewData"; //活動履歴一覧制御データ
    public static final String REQKEY_AAH_DATA = "AseActHistData"; //活動履歴一覧データ

    //活動判定 add 2005/03/29 I.Naruse
    public static final String SESKEY_AAJ_MODIFYDATA = "AseActJudgModifyData"; //活動判定編集データ

    //医営本目安箱 add 2005/08/29 I.Naruse
    public static final String SESKEY_MAV_VIEWDATA = "MysAnsViewData"; //医営本目安箱一覧制御データ
    public static final String REQKEY_MAV_DATA = "MysAnsData"; //医営本目安箱一覧データ

    //担当メンテナンス（LMR） add 2005/09/09 I.Naruse
    public static final String SESKEY_LCH_SELECT_VIEWDATA = "LmmChargeSelectViewData"; //LMR選択 制御データ
    public static final String REQKEY_LCH_SELECT_DATA = "LmmChargeSelectData"; //LMR担当メンテナンス 一覧データ
    public static final String SESKEY_LCH_VIEWDATA = "LmmChargeViewData"; //LMR担当メンテナンス一覧 制御データ
    public static final String SESKEY_LCH_DATA = "LmmChargeData"; //LMR担当メンテナンス 一覧データ（あえてSESにしています）
    public static final String SESKEY_LCH_REGISTERDATA = "LmmChargeRegisterData"; //LMR担当メンテナンス登録 制御データ

    // ---------------------世古の追加領域 開始 担当:世古-------------------------
    //医師異動情報検索 add 2003/01/22 J.Seko
    public static final String SESKEY_DCI_VIEWDATA = "DmcChangeInfSearchViewData"; //医師異動情報検索一覧制御データ
    public static final String REQKEY_DCI_DATA = "DmcChangeInfSearchData"; //医師異動情報検索一覧データ

        //処方影響力編集 add 2003/02/12 J.Seko
    public static final String SESKEY_DDP_VIEWDATA = "DmcDoctorPresViewData"; //処方影響力編集一覧制御データ
    public static final String REQKEY_DDP_DATA = "DmcDoctorPresData"; //処方影響力編集一覧データ

    //医師送出し情報 add 2003/02/20 J.Seko
    public static final String SESKEY_DIL_MODIFYDATA = "DmcDocInsCancelModifyData"; //医師送出し情報編集データ

    //医師送出しの要求アテンション add 2003/02/24 J.Seko
    public static final String SESKEY_DAO_REGISTERDATA = "DmcDocInsOutAttentionRegisterData"; //医師送出しの要求アテンション登録データ

    //eコミュニケーション送付 add 2004/06/22 J.Seko
    public static final String SESKEY_ECM_VIEWDATA = "EcmEcomSendViewData"; //eコミュニケーション送付一覧制御データ
    public static final String SESKEY_ECM_ADDR_DATA = "EcmEcomSendData"; //eコミュニケーション宛先一覧データ
    public static final String SESKEY_ECM_PROD_DATA = "DcmProdTableData"; //eコミュニケーション品目一覧データ
    public static final String REQKEY_ECM_DATA = "EcmEcomSendData"; //eコミュニケーション送付一覧データ

    //eプロモーション送付(確認) add 2004/06/29 J.Seko
    public static final String SESKEY_ECM_REFERDATA = "EcmEcomSendReferData"; //eプロモーション送付(確認)詳細データ
    public static final String SESKEY_ECM_ADDR_REFERDATA = "EcmEcomSendDataRefer"; //宛先一覧データ
    public static final String SESKEY_ECM_PROD_REFERDATA = "DcmProdTableDataRefer"; //品目

    // ---------------------薮田の追加領域 開始 担当:薮田-------------------------
    //組織選択 add 2003/02/14 M.Yabuta
    public static final String SESKEY_DIC_VIEWDATA = "DmcInsCategoriesViewData"; //組織選択一覧制御データ
    public static final String REQKEY_DIC_DATA = "DmcInsCategoriesData"; //組織選択一覧データ

    //医師選択ポップアップ add 2003/02/18 M.Yabuta
    public static final String SESKEY_DRT_VIEWDATA = "DmcDoctorCategoriesViewData"; //医師選択ポップアップ一覧制御データ
    public static final String REQKEY_DRT_DATA = "DmcDoctorCategoriesData"; //医師選択ポップアップ一覧データ

    //研究会詳細 add 2003/02/21 M.Yabuta
    public static final String SESKEY_DST_MODIFYDATA = "DmcDocStudyModifyData"; //研究会詳細編集データ


    // ---------------------西川の追加領域 開始 担当:西川-------------------------
    //全件表示ポップアップ（他社治験情報） add 2003/07/03 K.Nishikawa
    public static final String SESKEY_IOT_VIEWDATA = "InsCrOtherViewViewData"; //全件表示ポップアップ（他社治験情報）一覧制御データ
    public static final String REQKEY_IOT_DATA = "InsCrOtherViewData"; //全件表示ポップアップ（他社治験情報）一覧データ

    //履歴表示ポップアップ（治験への興味） add 2003/07/07 K.Nishikawa
    public static final String SESKEY_DCV_VIEWDATA = "DocCrHistViewViewData"; //履歴表示ポップアップ（治験への興味）一覧制御データ
    public static final String REQKEY_DCV_DATA = "DocCrHistViewData"; //履歴表示ポップアップ（治験への興味）一覧データ

    //履歴表示ポップアップ（治験関連情報） add 2003/07/09 K.Nishikawa
    public static final String SESKEY_ICV_VIEWDATA = "InsCrHistViewViewData"; //履歴表示ポップアップ（治験関連情報）一覧制御データ
    public static final String REQKEY_ICV_DATA = "InsCrHistViewData"; //履歴表示ポップアップ（治験関連情報）一覧データ

    //全件表示ポップアップ（自社治験情報） add 2003/07/11 K.Nishikawa
    public static final String SESKEY_IOW_VIEWDATA = "InsCrOwnViewViewData"; //全件表示ポップアップ（自社治験情報）一覧制御データ
    public static final String REQKEY_IOW_DATA = "InsCrOwnViewData"; //全件表示ポップアップ（自社治験情報）一覧データ

    //全件表示ポップアップ（治験１） add 2003/07/15 K.Nishikawa
    public static final String SESKEY_DFV_VIEWDATA = "DocCrFirstViewViewData"; //全件表示ポップアップ（治験１）一覧制御データ
    public static final String REQKEY_DFV_DATA = "DocCrFirstViewData"; //全件表示ポップアップ（治験１）一覧データ

    //特約店選択 add 2003/07/24 K.Nishikawa
    public static final String SESKEY_NBC_VIEWDATA = "NonyuBrWsCategoriesViewData"; //特約店選択一覧制御データ
    public static final String REQKEY_NBC_DATA = "NonyuBrWsCategoriesData"; //特約店選択一覧データ

    //特約店選択 add 2003/07/24 K.Nishikawa
    public static final String SESKEY_NBU_VIEWDATA = "NonyuBrWsUnderCategoriesViewData"; //特約店選択一覧制御データ
    public static final String REQKEY_NBU_DATA = "NonyuBrWsUnderCategoriesData"; //特約店選択一覧データ

    //旧姓履歴 add 2003/08/11 K.Nishikawa
    public static final String SESKEY_DHO_VIEWDATA = "DmcHistOldNameViewData"; //旧姓履歴一覧制御データ
    public static final String REQKEY_DHO_DATA = "DmcHistOldNameData"; //旧姓履歴一覧データ

    //専門臓器履歴 add 2003/08/12 K.Nishikawa
    public static final String SESKEY_DHL_VIEWDATA = "DmcHistLiverViewData"; //専門臓器履歴一覧制御データ
    public static final String REQKEY_DHL_DATA = "DmcHistLiverData"; //専門臓器履歴一覧データ

    //専門詳細履歴 add 2003/08/13 K.Nishikawa
    public static final String SESKEY_DHD_VIEWDATA = "DmcHistDiseaseViewData"; //専門詳細履歴一覧制御データ
    public static final String REQKEY_DHD_DATA = "DmcHistDiseaseData"; //専門詳細履歴一覧データ

    //武田への信頼度履歴 add 2003/08/14 K.Nishikawa
    public static final String SESKEY_DHT_VIEWDATA = "DmcHistTakedaViewData"; //武田への信頼度履歴一覧制御データ
    public static final String REQKEY_DHT_DATA = "DmcHistTakedaData"; //武田への信頼度履歴一覧データ

    //自宅住所履歴 add 2003/08/14 K.Nishikawa
    public static final String SESKEY_DHH_VIEWDATA = "DmcHistHomeAddressViewData"; //自宅住所履歴一覧制御データ
    public static final String REQKEY_DHH_DATA = "DmcHistHomeAddressData"; //自宅住所履歴一覧データ

    //寮・官舎住所履歴 add 2003/08/15 K.Nishikawa
    public static final String SESKEY_DHC_VIEWDATA = "DmcHistComAddressViewData"; //勤務先住所履歴一覧制御データ
    public static final String REQKEY_DHC_DATA = "DmcHistComAddressData"; //勤務先住所履歴一覧データ

    //担当履歴 add 2003/08/15 K.Nishikawa
    public static final String SESKEY_DHP_VIEWDATA = "DmcHistProfViewData"; //担当履歴一覧制御データ
    public static final String REQKEY_DHP_DATA = "DmcHistProfData"; //担当履歴一覧データ

    // ---------------------彦坂の追加領域 開始 担当:彦坂-------------------------
    //品名容量選択 add 2003/07/18 T.Hikosaka
    public static final String SESKEY_NKC_VIEWDATA = "NonyuPackCategoriesViewData"; //品名容量選択一覧制御データ
    public static final String REQKEY_NKC_DATA = "NonyuPackCategoriesData"; //品名容量選択一覧データ
    public static final String REQKEY_NKC_DATA_PCAT = "NonyuPackCategoriesDataPcat"; //品目データ
    public static final String REQKEY_NKC_DATA_MODEL = "NonyuPackCategoriesDataModel"; //剤型データ
    public static final String REQKEY_NKC_DATA_CAPA = "NonyuPackCategoriesDataCapa"; //容量データ
    public static final String REQKEY_NKC_DATA_WRAP = "NonyuPackCategoriesDataWrap"; //包装データ

    //特約店選択 add 2003/07/24 T.Hikosaka
    public static final String SESKEY_NBT_VIEWDATA = "NonyuBrWsTopCategoriesViewData"; //特約店選択一覧制御データ
    public static final String REQKEY_NBT_DATA = "NonyuBrWsTopCategoriesData"; //特約店選択一覧データ

    //特約店選択（特担ワクチン用） add 2003/11/04 T.Hikosaka
    public static final String SESKEY_VWT_VIEWDATA = "VarWsTopCategoriesViewData"; //特約店選択一覧制御データ
    public static final String REQKEY_VWT_DATA = "VarWsTopCategoriesData"; //特約店選択一覧データ

    //特約店選択（特担ワクチン用） add 2003/11/04 T.Hikosaka
    public static final String SESKEY_VWC_VIEWDATA = "VarWsCategoriesViewData"; //特約店選択一覧制御データ
    public static final String REQKEY_VWC_DATA = "VarWsCategoriesData"; //特約店選択一覧データ

    //特約店選択（特担ワクチン用） add 2003/11/04 T.Hikosaka
    public static final String SESKEY_VWU_VIEWDATA = "VarWsUnderCategoriesViewData"; //特約店選択一覧制御データ
    public static final String REQKEY_VWU_DATA = "VarWsUnderCategoriesData"; //特約店選択一覧データ

    //管理用文献検索（アンケート集計） add 2003/12/17 T.Hikosaka
    public static final String SESKEY_ADE_VIEWDATA = "AdminDocSearchEnqeteViewData"; //管理用文献検索（アンケート集計）制御データ
    public static final String REQKEY_ADE_DATA = "AdminDocSearchEnqeteData"; //管理用文献検索（アンケート集計）データ
    public static final String REQKEY_ADE_LOGINDATA = "AdminDocSearchEnqeteLoginData"; //管理用文献検索（アンケート集計）データ

    // ---------------------福山の追加領域 開始 担当:福山-------------------------
    //特約店複数選択編集 add 2003/07/28 T.Fukuyama
    public static final String SESKEY_NUM_REGISTERDATA = "NjoUserWsMaintenanceRegisterData"; //特約店複数選択編集データ

    public static final String SESKEY_NUM_VIEWDATA = "NjoUserWsMaintenanceViewData"; //特約店複数選択編集制御データ
    public static final String REQKEY_NUM_DATA = "NjoUserWsMaintenanceData"; //特約店複数選択編集データ

    // ---------------------河村の追加領域 開始 担当:河村-------------------------
    //特約店別品目別実績表（３次） add 2003/07/24 k.kawamura
    public static final String SESKEY_NWP_VIEWDATA = "NjoWsProductNmlViewData"; //特約店別品目別実績表一覧制御データ
    public static final String REQKEY_NWP_DATA = "NjoWsProductNmlData"; //特約店別品目別実績表一覧データ
    //施設別表 （３次）             add 2003/07/24 k.kawamura
    public static final String SESKEY_NIN_VIEWDATA  = "NjoInstitutionViewData"; //納入 PS納入実績 施設別表一覧制御データ
    public static final String REQKEY_NIN_DATA      = "NjoInstitutionData";     //納入 PS納入実績 施設別表一覧データ
    public static final String NIN_PACK_MODEL       = "model";  //change constant of access object：剤型
    public static final String NIN_PACK_CAPA        = "capa";   //change constant of access object：容量
    public static final String NIN_PACK_WRAP        = "wrap";   //change constant of access object：包装
    //PDF作成                       add 2003/09/02
    public static final String SESKEY_PDF_VIEWDATA  = "NjoPdfCreationViewData"; //PDF 作成 制御データ


    // ---------------------井城の追加領域 開始 担当:井城-------------------------
    //特約店別品目別実績表（３次） add 2003/07/30 y.iki
    public static final String SESKEY_NPW_VIEWDATA = "NjoProductWsNmlViewData"; //特約店別品目別実績表一覧制御データ
    public static final String REQKEY_NPW_DATA = "NjoProductWsNmlData"; //特約店別品目別実績表一覧データ
    public static final String NPW_PACK_MODEL = "model"; // 剤型
    public static final String NPW_PACK_CAPA = "capa"; // 容量
    public static final String NPW_PACK_WRAP = "wrap"; // 包装

    //品目別表　指定施設（３次） add 2003/08/06 y.iki
    public static final String SESKEY_NPR_VIEWDATA = "NjoProductInsViewData"; //品目別表一覧制御データ
    public static final String REQKEY_NPR_DATA = "NjoProductInsData"; //品目別表一覧データ

    //品目別表　指定組織（３次） add 2003/08/18 y.iki
    public static final String SESKEY_NPN_VIEWDATA = "NjoProductNmlViewData"; //品目別表一覧制御データ
    public static final String REQKEY_NPN_DATA = "NjoProductNmlData"; //品目別表一覧データ

    //タグリブ ClassTag add 2003/08/11 y.iki
    public static final String NJO_TABLE_ITEM0 = "njoTableItem0";//行スタイル０のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM1 = "njoTableItem1";//行スタイル１のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM2 = "njoTableItem2";//行スタイル２のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM3 = "njoTableItem3";//行スタイル３のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM4 = "njoTableItem4";//行スタイル４のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM5 = "njoTableItem5";//行スタイル５のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM6 = "njoTableItem6";//行スタイル６のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM7 = "njoTableItem7";//行スタイル７のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM8 = "njoTableItem8";//行スタイル８のクラス（スタイルシート）
    public static final String NJO_TABLE_ITEM9 = "njoTableItem9";//行スタイル９のクラス（スタイルシート）

    //帳票一覧　 add 2003/09/16 y.iki
    public static final String SESKEY_PLT_VIEWDATA = "PdfReportListViewData";   //帳票一覧制御データ
    public static final String REQKEY_PLT_DATA = "PdfReportListData";           //帳票一覧データ

    //eプロモーション実績（詳細履歴） add 2004/09/10 Y.Iki
    public static final String SESKEY_ERD_VIEWDATA = "EdtResultDetailViewData"; //eプロモーション実績（詳細履歴）一覧制御データ
    public static final String REQKEY_ERD_DATA = "EdtResultDetailData"; //eプロモーション実績（詳細履歴）一覧データ

    //活動進捗－施設 add 2005/03/17 Y.Iki
    public static final String SESKEY_AAI_VIEWDATA = "AseActProgInsViewData"; //活動進捗－施設一覧制御データ
    public static final String REQKEY_AAI_DATA = "AseActProgInsData"; //活動進捗－施設一覧データ

    //活動進捗－医師 add 2005/03/29 Y.Iki
    public static final String SESKEY_AAC_VIEWDATA = "AseActProgDocViewData"; //活動進捗－医師一覧制御データ
    public static final String REQKEY_AAC_DATA = "AseActProgDocData"; //活動進捗－医師一覧データ

    // ---------------------松本の追加領域 開始 担当:松本-------------------------
    public static final String SESKEY_MNU_VIEWDATA = "MenuViewData"; //メニュー一覧制御データ

    // ---------------------横井の追加領域 開始 担当:横井-------------------------
    //外勤報告分類選択 add 2003/10/28 H.Yokoi
    public static final String SESKEY_VCC_VIEWDATA = "VarCatCategoriesViewData"; //外勤報告分類選択一覧制御データ
    public static final String REQKEY_VCC_DATA = "VarCatCategoriesData"; //外勤報告分類選択一覧データ

    // ---------------------藤原の追加領域 開始 担当:藤原-------------------------
    //個人別履歴一覧 add 2004/03/02 K.Fujiwara
    public static final String SESKEY_CKJ_VIEWDATA = "CefDokoJgiListViewData"; //個人別履歴一覧一覧制御データ
    public static final String REQKEY_CKJ_DATA = "CefDokoJgiListData"; //個人別履歴一覧一覧データ
    //管理:成績取り込み add 2004/03/08 K.Fujiwara
    public static final String SESKEY_CRI_REGISTERDATA = "CefRecordImportRegisterData"; //管理:成績取り込み登録データ
    //ワクチン品質情報一覧 add 2003/03/23 K.Fujiwara
    public static final String SESKEY_VQL_VIEWDATA = "VaccineQualityViewData"; //ワクチン品質情報一覧一覧制御データ
    public static final String REQKEY_VQL_DATA = "VaccineQualityData"; //ワクチン品質情報一覧一覧データ
    //ワクチン品質情報処置報告書詳細 add 2003/03/23 K.Fujiwara
    public static final String SESKEY_VQD_REFERDATA = "VaccineQualityDisposalReferData"; //品質情報処置報告書詳細詳細データ
    //ワクチン品質情報処置報告書編集 add 2003/03/23 K.Fujiwara
    public static final String SESKEY_VQD_REGISTERDATA = "VaccineQualityDisposalRegisterData"; //品質情報処置報告書編集登録データ
    //ワクチン品質情報承認 add 2003/03/23 K.Fujiwara
    public static final String SESKEY_VQA_MODIFYDATA = "VaccineQualityAdmissionModifyData"; //品質情報承認編集データ

    // ---------------------井上の追加領域 開始 担当:井上-------------------------
    //管理：成績取込（結果参照） add 2004/03/08 Y.Inoue
    public static final String SESKEY_CRL_VIEWDATA = "CefRecordImportListViewData"; //管理：成績取込（結果参照）一覧制御データ
    public static final String REQKEY_CRL_DATA = "CefRecordImportListData"; //管理：成績取込（結果参照）一覧データ

    //成績フォロー：担当者 add 2004/03/12 Y.Inoue
    public static final String SESKEY_CIR_VIEWDATA = "CefIndivRecordListViewData"; //成績フォロー：担当者一覧制御データ
    public static final String REQKEY_CIR_DATA = "CefIndivRecordListData"; //成績フォロー：担当者一覧データ

    //成績フォロー：営業所平均 add 2004/03/16 Y.Inoue
    public static final String SESKEY_CDA_VIEWDATA = "CefDistAverageListViewData"; //成績フォロー：営業所平均一覧制御データ
    public static final String REQKEY_CDA_DATA = "CefDistAverageListData"; //成績フォロー：営業所平均一覧データ

    //ワクチン品質情報 add 2004/03/23 Y.Inoue
    public static final String SESKEY_VQL_REFERDATA = "VaccineQualityReferData"; //ワクチン品質情報報告書詳細データ
    public static final String SESKEY_VQL_REGISTERDATA = "VaccineQualityRegisterData"; //ワクチン品質情報報告書登録データ
    public static final String SESKEY_VQS_MODIFYDATA = "VaccineQualityAnswerModifyData"; //ワクチン品質情報回答日入力編集データ

    //製剤写真一覧(管理用) add 2004/04/19 Y.Inoue
    public static final String SESKEY_PAL_VIEWDATA = "PifAdminPicListViewData"; //製剤写真一覧(管理用)一覧制御データ
    public static final String REQKEY_PAL_DATA = "PifAdminPicListData"; //製剤写真一覧(管理用)一覧データ
    public static final String SESKEY_PAL_REFERDATA = "PifAdminPicListReferData"; //製剤写真一覧(管理用)詳細データ
    public static final String SESKEY_PAL_REGISTERDATA = "PifAdminPicListRegisterData"; //製剤写真一覧(管理用)登録データ

    //宝島 IS情報 add 2004/08/09 Y.Inoue
    public static final String SESKEY_TKI_VIEWDATA = "TkrIsViewData"; //宝島 IS情報一覧制御データ
    public static final String REQKEY_TKI_DATA = "TkrIsData"; //宝島 IS情報一覧データ

    //宝島 導入トーク情報 add 2004/08/09 Y.Inoue
    public static final String SESKEY_TKD_VIEWDATA = "TkrDounyuViewData"; //宝島 導入トーク情報一覧制御データ
    public static final String REQKEY_TKD_DATA = "TkrDounyuData"; //宝島 導入トーク情報一覧データ
    //宝島 導入トーク情報【登録】 add 2004/10/26 Y.Inoue
    public static final String SESKEY_TKD_REGISTERDATA = "TkrDounyuRegisterData"; //宝島 導入トーク情報【登録】登録データ

    //宝島 次の一手情報 add 2004/08/09 Y.Inoue
    public static final String SESKEY_TKN_VIEWDATA = "TkrNextViewData"; //宝島 次の一手情報一覧制御データ
    public static final String REQKEY_TKN_OK_DATA = "TkrNextOkData"; //宝島 次の一手情報OK一覧データ
    public static final String REQKEY_TKN_NG_DATA = "TkrNextNgData"; //宝島 次の一手情報NG一覧データ

    //宝島 共通 add 2004/08/11 Y.Inoue
    public static final String SESKEY_TKR_AUTHDATA = "TkrAuthData"; //宝島 ユーザー情報データ

    //勝敗表市区郡別 add 2004/10/18 Y.Inoue
    public static final String SESKEY_MVC_VIEWDATA = "MrvCityViewData"; //勝敗表 市区郡別一覧制御データ
    public static final String REQKEY_MVC_DATA = "MrvCityData"; //勝敗表 市区郡別一覧データ


    // ---------------------田村の追加領域 開始 担当:田村-------------------------
    //研修ポイント取得状況 add 2004/09/15 T.Tamura
    public static final String SESKEY_PPS_VIEWDATA = "PspPointStatusViewData"; //研修ポイント取得状況一覧制御データ
    public static final String REQKEY_PPS_DATA = "PspPointStatusData"; //研修ポイント取得状況一覧データ

    //製品情報コードマスタ.item_kb add start 2011/12/20 T.Tamura B11-0335 H&N製品基本情報　公開区分の変更等
    public static final String PIFICDMSTIEMKEYCAP = "cap_cd"; 				//製品情報コードマスタ.アイテムコード「容量」
    public static final String PIFICDMSTIEMKEYCATD = "catd_kb"; 			//製品情報コードマスタ.アイテムコード「小分類」
// add start 2013/01/25 M.Terui J12-0008 ファイル公開区分追加
    public static final String PIFCDMSTITEMKBPUBNM = "pdl_file_pub_kb_nm";		//製品情報コードマスタ.アイテムコード「製品基本添付ファイル公開区分名称」
    public static final String PIFCDMSTITEMKBPUBJKN = "pdl_file_pub_kb_jkn";	//製品情報コードマスタ.アイテムコード「製品基本添付ファイル公開区分条件セット」
// add end   2013/01/25 M.Terui J12-0008 ファイル公開区分追加

    // ---------------------平田の追加領域 開始 担当:平田-------------------------
    //キャリアプラン情報検索
    public static final String SESKEY_PCS_VIEWDATA = "PspCPlanSearchViewData"; //キャリアプラン情報検索一覧制御データ
    //研修受講歴 add 2004/09/28 K.Hirata
    public static final String REQKEY_PCK_DATA = "CPlanKensyuData"; //研修受講歴一覧データ
    public static final String SESKEY_PCK_REGISTERDATA = "PspCPlanKensyuRegisterData"; //キャリアプラン研修受講歴登録データ
    //MR認定証登録画面 add 2004/09/06 K.Hirata
    public static final String REQKEY_PCN_DATA = "PspCPlanMRData"; //MR認定証一覧データ
    public static final String SESKEY_PCN_MODIFYDATA = "PspCPlanMRModifyData"; //MR認定証編集データ
    //プレマネジメントA・M結果登録 add 2004/09/09 K.Hirata
    public static final String REQKEY_PCP_DATA = "PspCPlanPremanageData"; //プレマネジメントA・M結果一覧データ
    public static final String SESKEY_PCP_REGISTERDATA = "PspCPlanPremanageRegisterData"; //プレマネジメントA・M結果登録データ
    //コンピテンシー登録 add 2004/09/09 K.Hirata
    public static final String SESKEY_PCC_REGISTERDATA = "PspCPlanCompeRegisterData"; //コンピテンシー登録データ
    //職務履歴 add 2004/09/17 K.Hirata
    public static final String REQKEY_PCH_DATA = "PspCPlanHistoryData"; //職務履歴一覧データ
    //ワクチンAE情報 add 2004/12/24 K.Hirata
    public static final String REQKEY_VAE_DATA = "VaeInfoData";             //ワクチンAE情報一覧データ
    public static final String SESKEY_VAE_VIEWDATA = "VaeInfoViewData";     //ワクチンAE情報一覧制御データ
    public static final String REQKEY_VAE_DETAILDATA = "VaeInfoModifyDetailData";//ワクチンAE情報詳細画面表示データ
    public static final String SESKEY_VAE_MODIFYDATA = "VaeInfoModifyData"; //ワクチンAE情報編集制御データ
    //キャリアプラン(研修コード選択ポップアップ) add 2005/01/24 K.Hirata
    public static final String REQKEY_PCR_DATA = "PspCPlanCrsMstData";             //研修コード選択ポップアップ一覧データ
    public static final String SESKEY_PCR_VIEWDATA = "PspCPlanCrsMstViewData";     //研修コード選択ポップアップ一覧制御データ
    //キャリアプラン(研修行事計画) add 2005/01/25 K.Hirata
    public static final String REQKEY_PLI_DATA = "PspCPlanListData";                //研修行事計画一覧データ
    public static final String SESKEY_PLI_VIEWDATA = "PspCPlanListViewData";        //研修行事計画一覧制御データ
    public static final String SESKEY_PLI_REGISTERDATA = "PspCPlanListRegisterData"; //研修行事計画登録データ
    //キャリアプラン(研修参加予定者) add 2005/01/25 K.Hirata
    public static final String REQKEY_PJL_DATA = "PspCPlanJgiListData";                //研修参加予定者一覧データ
    public static final String SESKEY_PJL_VIEWDATA = "PspCPlanJgiListViewData";        //研修参加予定者一覧制御データ
    public static final String SESKEY_PJL_REGISTERDATA = "PspCPlanJgiListRegisterData"; //研修参加予定者登録データ


    // ---------------------中村の追加領域 開始 担当:中村-------------------------
    //eプロモーション実績(コンテンツ別) add 2004/09/15 S.Nakamura
    public static final String SESKEY_ERN_VIEWDATA = "EdtResultContentsViewData"; //コンテンツ一覧制御データ
    public static final String REQKEY_ERN_DATA = "EdtResultContentsData";         //コンテンツ一覧データ
    //eプロモーション実績(コンテンツ別) add 2005/06/15 Y.asano
    public static final String SESKEY_ERN_TOTALVIEWDATA = "EdtResultContentsTotalViewData"; //コンテンツ総合計データの設定

    //eプロモーション実績(コンテンツポップアップ) add 2004/09/15 S.Nakamura
    public static final String SESKEY_ECC_VIEWDATA = "EdtContentsCategoriesViewData"; //コンテンツポップアップ一覧制御データ
    public static final String REQKEY_ECC_DATA = "EdtContentsCategoriesData";          //コンテンツポップアップ一覧データ

    //eプロモーション実績（担当組織・担当者別） add 2004/09/21 S.Nakamura
    public static final String SESKEY_ERO_VIEWDATA = "EdtResultOrgViewData"; //eプロモーション実績（担当組織・担当者別）一覧制御データ
    public static final String REQKEY_ERO_DATA = "EdtResultOrgData";
    //eプロモーション実績（担当組織・担当者別)  add 2005/06/16 Y.asano
    public static final String SESKEY_ERO_TOTALVIEWDATA = "EdtResultOrgTotalViewData";	//eプロモーション実績（担当組織・担当者別）総合計データ

    //管理：コンテンツメール登録 add 2004/09/28 S.Nakamura
    public static final String SESKEY_EAD_VIEWDATA = "EdtAdminContentsViewData"; //管理：コンテンツメール登録一覧制御データ
    public static final String REQKEY_EAD_DATA = "EdtAdminContentsData"; //管理：コンテンツメール登録一覧データ

    //ULT医師情報詳細 add 2004/10/12 S.Nakamura
    public static final String REQKEY_UDS_REFERDATA = "UltDocSearchReferData"; //ULT医師情報詳細データ
    public static final String SESKEY_UDS_REFERDATA = "UltDocSearchReferData"; //ULT医師情報詳細データ

    //ULT医師情報詳細 add 2004/10/14 S.Nakamura
    public static final String SESKEY_UDS_CONNECTDATA = "UltDocSearchConnectData"; //ULT医師情報接続データ

    //医師異動選択(ULT削除拒否) add 2004/12/09 S.Nakamura
    public static final String SESKEY_DIV_MODIFYDATA = "DmcDocInsVModifyData"; //医師異動選択編集データ

    //外勤活動一覧 add 2005/01/28 S.Nakamura
    public static final String SESKEY_DAC_VIEWDATA = "DmcAcrCategoriesViewData"; //外勤活動一覧一覧制御データ
    public static final String REQKEY_DAC_DATA = "DmcAcrCategoriesData"; //外勤活動一覧一覧データ

    //外勤活動詳細 add 2005/01/31 S.Nakamura
    public static final String SESKEY_DAC_REFERDATA = "DmcAcrCategoriesReferData"; //外勤活動詳細データ

    //DDD品目別・月別表（金額・シェア） add 2005/03/25 S.Nakamura
    public static final String SESKEY_DPM_VIEWDATA = "DddProdMonthViewData"; //DDD品目別・月別表（金額・シェア）一覧制御データ
    public static final String REQKEY_DPM_DATA = "DddProdMonthData"; //DDD品目別・月別表（金額・シェア）一覧データ

    //JIS府県・武田市区群選択 add 2005/05/30 S.Nakamura
    public static final String SESKEY_IPT_VIEWDATA = "ImtPrefTkCityCategoriesViewData"; //JIS府県・武田市区群選択一覧制御データ
    public static final String REQKEY_IPT_DATA = "ImtPrefTkCityCategoriesData"; //JIS府県・武田市区群選択一覧データ

    //雑誌選択（文献コード） add 2005/10/05 S.Nakamura
    public static final String SESKEY_DMZ_VIEWDATA = "DcdMagazineCategoriesViewData"; //雑誌選択一覧制御データ
    public static final String REQKEY_DMZ_DATA = "DcdMagazineCategoriesData"; //雑誌選択一覧データ

    //MAPS関連稼動スケジュール add 2006/01/17 S.Nakamura
    public static final String SESKEY_BMS_VIEWDATA = "BscMapsScheduleViewData"; //MAPS関連稼動スケジュール一覧制御データ
    public static final String REQKEY_BMS_DATA = "BscMapsScheduleData"; //MAPS関連稼動スケジュール一覧データ

    //MAPS関連稼動スケジュール add 2006/01/19 S.Nakamura
    public static final String SESKEY_BMS_REGISTERDATA = "BscMapsScheduleRegisterData"; //MAPS関連稼動スケジュール登録データ
    public static final String SESKEY_BMS_ERASEDATA = "BscMapsScheduleEraseData"; //MAPS関連稼動スケジュール削除データ

    //組織従業員展開選択 add 2006/03/28 S.Nakamura
    public static final String SESKEY_CSE_VIEWDATA = "CatSosJgiExpandViewData"; //組織従業員展開選択制御データ
    public static final String REQKEY_CSE_DATA = "CatSosJgiExpandData"; //組織従業員展開選択データ
    public static final String REQKEY_CSE_AJAX = "CatSosJgiExpandAjax"; //組織従業員展開選択非同期データ

    //JIS府県武田市区郡複数選択 add 2006/03/28 S.Nakamura
    public static final String SESKEY_CTC_VIEWDATA = "CatTkCityComboViewData";      //JIS府県武田市区郡複数選択一覧制御データ
    public static final String REQKEY_CTC_ADDR_DATA = "CatTkCityComboAddrData";     //JIS府県武田市区郡複数選択都道府県一覧データ
    public static final String REQKEY_CTC_TKCITY_DATA = "CatTkCityComboTkCityData"; //JIS府県武田市区郡複数選択武田市区郡一覧データ

    //所属部科複数選択 add 2006/03/28 S.Nakamura
    public static final String SESKEY_CDC_VIEWDATA = "CatDeptsComboViewData"; //所属部科複数選択一覧制御データ
    public static final String REQKEY_CDC_DATA = "CatDeptsComboData"; //所属部科複数選択一覧データ

    // ---------------------増田の追加領域 開始 担当:増田-------------------------

    //研修支援制度メニュー add 2004/08/31 D.Masuda
    public static final String SESKEY_PSM_MENUDATA = "PrsMenuAuthData"; //研修支援制度メニュー詳細データ

    //公開日登録 add 2004/08/31 D.Masuda
    public static final String SESKEY_PAR_REGISTERDATA = "PspApsEntryRegisterData"; //公開日登録データ

    //APS評価情報登録 add 2004/09/03 D.Masuda
    public static final String SESKEY_PAR_FILEUPLOADDATA = "PspApsEntryFileUpLoadData"; //APS評価情報登録データ

    //APS評価登録エラー add 2004/09/06 D.Masuda
    public static final String SESKEY_PAE_VIEWDATA = "PspApsErrViewData"; //APS評価登録エラー一覧制御データ
    public static final String REQKEY_PAE_DATA = "PspApsErrData"; //APS評価登録エラー一覧データ

    //研修参加申込み一括登録初期画面 add 2004/09/13 D.Masuda
    public static final String SESKEY_PTS_REGISTERDATA = "PspPetEntryRegisterData"; //研修参加申込み一括登録初期画面データ

    //研修参加申込み一括登録 add 2004/09/13 D.Masuda
    public static final String SESKEY_PTS_FILEUPLOADDATA = "PspPetEntryFileUpLoadData"; //研修参加申込み一括登録データ

    //研修参加申込み一括登録エラー add 2004/09/13 D.Masuda
    public static final String SESKEY_PTE_VIEWDATA = "PspPetErrViewData"; //研修参加申込み一括登録エラー一覧制御データ
    public static final String REQKEY_PTE_DATA = "PspPetErrData"; //研修参加申込み一括登録エラー一覧データ

    //キャリアプラン情報登録初期画面 add 2004/09/21 D.Masuda
    public static final String SESKEY_PCI_REGISTERDATA = "PspCPlanIkkatsuRegisterData"; //キャリアプラン情報登録初期画面データ

    //キャリアプラン研修受講歴データ登録 add 2004/09/21 D.Masuda
    public static final String SESKEY_PCI_KEN_FILEUPLOADDATA = "PspCPlanIkkatsuKenFileUpLoadData"; //研修受講歴データ登録データ

    //キャリアプランMR認定試験データ登録 add 2004/09/21 D.Masuda
    public static final String SESKEY_PCI_MR_FILEUPLOADDATA = "PspCPlanIkkatsuMRFileUpLoadData"; //MR認定試験データ登録データ

    //キャリアプラン研修受講歴データ登録エラー add 2004/09/21 D.Masuda
    public static final String SESKEY_PKE_VIEWDATA = "PspCPlanKensyuErrViewData"; //研修受講歴データ登録エラー一覧制御データ
    public static final String REQKEY_PKE_DATA = "PspCPlanKensyuErrData"; //研修受講歴データ登録エラー一覧データ

    //キャリアプランMR認定試験データ登録エラー add 2004/09/21 D.Masuda
    public static final String SESKEY_PME_VIEWDATA = "PspCPlanMRErrViewData"; //MR認定試験データ登録エラー一覧制御データ
    public static final String REQKEY_PME_DATA = "PspCPlanMRErrData"; //MR認定試験データ登録エラー一覧データ

    //新IJINシステム 共通 add 2004/09/13 D.Masuda
    public static final String REQKEY_PSP_REQUESTDATA = "PspCommonRequestData"; //新IJINシステム リクエストデータ

    //ULT施設分類選択機能 add 2004/10/06 D.Masuda
    public static final String SESKEY_UIC_REFERDATA = "UltInsClassReferData"; //ULT施設分類選択画面詳細データ
    public static final String SESKEY_UIC_OPTIONDATA = "UltInsClassOptionData"; //ULT施設分類選択ラジオボタンデータ
    public static final String SESKEY_UIC_CONNECTDATA = "UltInsClassConnectData"; //ULT施設分類選択遷移データ

    //施設検索 add 2004/12/20 D.Masuda
    public static final String REQKEY_IIS_ULT_STATUS = "ImtInstitutionSearchUltConStatuList"; //ULT接続状況リスト

    //担当メンテナンス（EMR） add 2005/01/31 D.Masuda
    public static final String SESKEY_ECH_SELECT_VIEWDATA = "EmmChargeSelectViewData"; //EMR選択 制御データ
    public static final String REQKEY_ECH_SELECT_DATA = "EmmChargeSelectData"; //担当メンテナンス 一覧データ
    public static final String SESKEY_ECH_VIEWDATA = "EmmChargeViewData"; //担当メンテナンス一覧 制御データ
    public static final String SESKEY_ECH_DATA = "EmmChargeData"; //担当メンテナンス 一覧データ（あえてSESにしています）
    public static final String SESKEY_ECH_REGISTERDATA = "EmmChargeRegisterData"; //担当メンテナンス登録 制御データ

    //【施設-所属部科】選択画面（EMR） add 2005/01/31 D.Masuda
    public static final String SESKEY_EID_VIEWDATA = "EmmInsDeptsCategoriesViewData"; //【施設-所属部科】選択画面一覧制御データ
    public static final String SESKEY_EID_DATA = "EmmInsDeptsCategoriesData"; //【施設-所属部科】選択画面施設一覧データ
    public static final String SESKEY_EID_TYPELISTDATA = "EmmInsDeptsCategoriesTypeListData"; //【施設-所属部科】選択画面リストボックスデータ
    public static final String REQKEY_EID_DEPTDATA = "EmmInsDeptsCategoriesDeptData"; //【施設-所属部科】選択画面所属部科一覧データ

    //研修参加予定者一括登録初期画面 add 2005/02/10 D.Masuda
    public static final String SESKEY_PJR_REGISTERDATA = "PspCPlanJgiEntryRegisterData"; //研修参加予定者一括登録初期画面データ

    //研修参加予定者一括登録 add 2005/02/10 D.Masuda
    public static final String SESKEY_PJR_FILEUPLOADDATA = "PspCPlanJgiEntryFileUpLoadData"; //研修参加予定者一括登録データ

    //研修参加予定者一括登録エラー 2005/02/10 D.Masuda
    public static final String SESKEY_PJE_VIEWDATA = "PspCPlanJgiErrViewData"; //研修参加予定者一括登録エラー一覧制御データ
    public static final String REQKEY_PJE_DATA = "PspCPlanJgiErrData"; //研修参加予定者一括登録エラー一覧データ

    //施設医師フラグメンテナンス add 2005/02/14 D.Masuda
    //施設医師フラグメンテナンス modify 2010/03/11 N.Murakami
    public static final String REQKEY_IDF_SELECT_DATA = "InsDocFlgMntSelectData"; //施設医師フラグメンテナンス 一覧データ
    public static final String SESKEY_IDF_VIEWDATA = "InsDocFlgMntViewData"; //施設医師フラグメンテナンス一覧 制御データ
    public static final String SESKEY_IDF_DATA = "InsDocFlgMntData"; //施設医師フラグメンテナンス 一覧データ（あえてSESにしています）
    public static final String SESKEY_IDF_REGISTERDATA = "InsDocFlgMntRegisterData"; //施設医師フラグメンテナンス登録 制御データ

    //品質情報 報告書編集更新 add 2005/03/04 D.Masuda
    public static final String REQKEY_QAL_MODIFYDATA = "QualityModifyData"; //品質情報 報告書編集データ

    //DDD施設別・品目別表（金額・シェア） add 2005/03/09 D.Masuda
    public static final String SESKEY_DIP_VIEWDATA = "DddInsProdViewData"; //DDD施設別・品目別表（金額・シェア）一覧制御データ
    public static final String REQKEY_DIP_DATA = "DddInsProdData"; //DDD施設別・品目別表（金額・シェア）一覧データ

    //DDD品目（メーカー）選択 add 2005/03/23 D.Masuda
    public static final String SESKEY_DPC_VIEWDATA = "DddProdMakerCategoriesViewData"; //DDD品目（メーカー）選択一覧制御データ
    public static final String REQKEY_DPC_DATA = "DddProdMakerCategoriesData"; //DDD品目（メーカー）選択一覧データ

    //DDDブリック内施設一覧 add 2005/03/25 D.Masuda
    public static final String SESKEY_DBL_VIEWDATA = "DddBrickInsListViewData"; //DDDブリック内施設一覧 一覧制御データ
    public static final String REQKEY_DBL_DATA = "DddBrickInsListData"; //DDDブリック内施設一覧 一覧データ

    //中止保留履歴一覧 add 2005/05/06 D.Masuda
    public static final String SESKEY_ASH_VIEWDATA = "AseSspHistViewData"; //中止保留履歴一覧一覧制御データ
    public static final String REQKEY_ASH_DATA = "AseSspHistData"; //中止保留履歴一覧一覧データ

    //エラー施設 add 2005/05/10 D.Masuda
    public static final String SESKEY_AIE_VIEWDATA = "AseInsErrViewData"; //エラー施設一覧制御データ
    public static final String REQKEY_AIE_DATA = "AseInsErrData"; //エラー施設一覧データ

    //エラー施設 add 2005/05/10 D.Masuda
    public static final String SESKEY_AIE_REFERDATA = "AseInsErrReferData"; //エラー施設詳細データ

    //文献コード検索 add 2005/10/04 D.Masuda
    public static final String SESKEY_DSE_VIEWDATA = "DcdSearchCategoriesViewData"; //文献コード検索一覧制御データ
    public static final String REQKEY_DSE_DATA = "DcdSearchCategoriesData"; //文献コード検索一覧データ

    //継続教育フォロー：未受講者 add 2005/10/25 D.Masuda
    public static final String SESKEY_CNL_VIEWDATA = "CefNonLectPersonListViewData"; //継続教育フォロー：未受講者一覧制御データ
    public static final String REQKEY_CNL_DATA = "CefNonLectPersonListData"; //継続教育フォロー：未受講者一覧データ

    // ---------------------久保（崇）の追加領域 開始 担当:久保（崇）-------------------------
    //宝島 次の一手情報【登録】 add 2004/10/26 T.Kubo
    public static final String SESKEY_TKN_REGISTERDATA = "TkrNextRegisterData"; //宝島 次の一手情報【登録】登録データ

    //経費使用届フォロー品目別一覧 add 2005/02/07 T.Kubo
    public static final String SESKEY_KIP_VIEWDATA = "KihProdViewData"; //経費使用届フォロー品目別一覧制御データ
    public static final String REQKEY_KIP_DATA = "KihProdData";  //経費使用届フォロー品目別一覧データ
    public static final String REQKEY_KIPH_DATA = "KipProdData"; //経費使用届フォロー品目別一覧品目データ
    public static final String REQKEY_KIPS_DATA = "KisProdData"; //経費使用届フォロー品目別一覧合計データ

    //経費使用届フォロー月別一覧 add 2005/02/17 T.Kubo
    public static final String SESKEY_KIM_VIEWDATA = "KihMonViewData"; //経費使用届フォロー月別一覧一覧制御データ
    public static final String REQKEY_KIM_DATA = "KihMonData"; //経費使用届フォロー月別一覧一覧データ
    public static final String REQKEY_KIMH_DATA = "KipProdData"; //経費使用届フォロー月別一覧品目データ
    public static final String REQKEY_KIMS_DATA = "KisMonData"; //経費使用届フォロー月別一覧合計データ

    //医営本カレンダー add 2005/03/01 T.Kubo
    public static final String SESKEY_BSC_REFERDATA = "BusinessCalendarReferData"; //医営本カレンダー詳細データ
    // --------------------- 玉川の追加領域 開始 担当：玉川 -------------------------
    //外勤活動詳細 add 2004/12/16 A.Tamagawa
    public static final String SESKEY_ACR_EMR_CHECK = "acrCheckKbn";    //EMR対応

    // --------------------- 谷の追加領域 開始 担当：谷 -------------------------
    //新市場データ対応 add 2005/03/10 T.Tani
    public static final String SESKEY_DBC_VIEWDATA = "DddInsBrickCategoriesViewData"; //新市場データ対応一覧制御データ
    public static final String REQKEY_DBC_DATA = "DddInsBrickCategoriesData"; //新市場データ対応一覧データ

    //医営本目安箱回答文登録 add 2005/08/29 T.Tani
    public static final String SESKEY_MAG_REGISTERDATA = "MysAnsRegisterData"; //医営本目安箱回答文登録登録データ


    //---------------------- 浅野の追加領域 開始 担当 : 浅野 ---------------------
    //スケジュール詳細 add 2005/04/12 Y.asano
    public static final String SESKEY_BSD_REFERDATA = "BscScheduleDetailReferData"; //スケジュール詳細詳細データ
    //スケジュール詳細 add 2005/04/14 S.Nakamura
    public static final String SESKEY_BSD_REGISTERDATA = "BscScheduleDetailRegisterData"; //スケジュール詳細登録データ
    //スケジュール詳細 add 2005/04/18 Y.asano
    public static final String SESKEY_BSD_MODIFY_JGINAME = "BscScheduleDetailModifyJgiName"; //従業員名（スケジュール詳細で使用）

    //---------------------- 藤井（隆）の追加領域 開始 担当 : 藤井（隆） ---------------------
    //スケジュール一覧 add 2005/04/13 T.Fujii
    public static final String SESKEY_BSH_DRAW_DATA = "BshScheduleDrawData"; // 医営本カレンダースケジュール下書きデータ
    //スケジュール一覧 add 2005/04/13 T.Fujii
    public static final String SESKEY_BSH_REGISTERDATA = "BscScheduleRegisterData"; //スケジュール一覧登録データ
    //スケジュール一覧 add 2005/04/13 T.Fujii
    public static final String REQKEY_BSH_REGISTERDATA = "BscScheduleRegisterData"; //スケジュール一覧登録データ
    //スケジュール一覧 add 2005/04/13 T.Fujii
    public static final String SESKEY_BSH_BSRDATA = "bsrRegisterData";         //スケジュール一覧登録データ
    // *************************** 終了 *********************************

    //---------------------- 藤井（隆）の追加領域 開始 担当 : 藤井（隆） ---------------------
    //目安箱参照 add 2005/05/30 T.Fujii
    public static final String SESKEY_MBV_VIEWDATA = "MysBoxViewData"; //目安箱参照一覧制御データ
    //目安箱参照 add 2005/05/30 T.Fujii
    public static final String REQKEY_MBV_DATA = "MysBoxData";          //目安箱参照一覧データ
    //目安箱詳細 add 2005/05/30 T.Fujii
    public static final String SESKEY_MBF_REFERDATA = "MysBoxReferData"; //目安箱詳細データ
    //目安箱入力 add 2005/05/30 T.Fujii
    public static final String SESKEY_MBG_REGISTERDATA = "MysBoxRegisterData"; //目安箱入力登録データ
    //目安箱入力 add 2005/05/30 T.Fujii
    public static final String SESKEY_MBG_FILEDATA = "MysBoxFileData"; //目安箱ファイルデータ
    // *************************** 終了 *********************************

    //---------------------- 星野　の追加領域 開始 担当 : 星野 -----------------------------
    //目安箱回答 add 2005/08/29 M.Hoshino
    public static final String SESKEY_MAF_REFERDATA = "MysAnsReferData"; //目安箱回答データ

    //文献コード検索 add 2005/10/17 M.Hoshino
    public static final String SESKEY_DMA_VIEWDATA = "DcdMaintenanceViewData"; //文献コード検索一覧制御データ
    public static final String REQKEY_DMA_DATA = "DcdMaintenanceData"; //文献コード検索一覧データ
    //文献コード詳細 add 2005/10/17 M.Hoshino
    public static final String SESKEY_DMA_REFERDATA = "DcdMaintenanceReferData"; //文献コード詳細データ
    //文献コード登録 add 2005/10/17 M.Hoshino
    public static final String SESKEY_DMA_REGISTERDATA = "DcdMaintenanceRegisterData"; //文献コード登録データ
    //コンテンツメール add 2006/01/23 M.Hoshino
    public static final String SESKEY_EDT_TEXTDATA = "EdtTextData"; //TEXTデータ

    //担当変更状況 add 2006/04/12 M.Hoshino
    public static final String SESKEY_JMR_VIEWDATA = "JkrSosStatusViewData"; //担当変更状況一覧制御データ
    public static final String REQKEY_JMR_DATA = "JkrSosStatusData"; //担当変更状況一覧データ
    //従業員関連 add 2006/04/12 M.Hoshino
    public static final String SESKEY_JKR_MENUDATA = "JkrSetMenuParamData"; //メニューpramデータ
    //担当変更状況 add 2006/04/20 M.Hoshino
    public static final String SESKEY_JMR_REGISTERDATA = "JkrSosStatusRegisterData"; //担当変更状況登録データ

    //医師別担当変更 add 2006/05/10 M.Hoshino
    public static final String SESKEY_JDM_VIEWDATA = "JkrDocMrChangeViewData"; //医師別担当変更一覧制御データ
    public static final String REQKEY_JDM_DATA = "JkrDocMrChangeData"; //医師別担当変更一覧データ
    public static final String SESKEY_JDM_REGISTERDATA = "JkrDocMrChangeRegisterData"; //医師別担当変更登録データ
    public static final String SESKEY_JDM_EXECMAP = "JkrDocMrChangeExecMap"; //医師別担当変更適用日マップ

    //担当引継ぎ add 2006/06/07 M.Hoshino
    public static final String SESKEY_JMS_VIEWDATA = "JkrMrChangeViewData"; //担当引継ぎ一覧制御データ
    public static final String REQKEY_JMS_DATA = "JkrMrChangeData"; //担当引継ぎ一覧データ
    //担当引継ぎ add 2006/06/08 M.Hoshino
    public static final String SESKEY_JMS_REGISTERDATA = "JkrMrChangeRegisterData"; //担当引継ぎ登録データ

    //MS別計画メニュー add 2006/07/31 M.Hoshino
    public static final String SESKEY_MPL_VIEWDATA = "MplmenuViewData"; //MS別計画メニュー一覧制御データ

    //MS別積上げ計画入力 add 2006/07/31 M.Hoshino
    public static final String SESKEY_MPLR_VIEWDATA = "MplPlanRegViewData"; //MS別積上げ計画入力一覧制御データ
    public static final String REQKEY_MPLR_DATA = "MplPlanRegData"; //MS別積上げ計画入力一覧データ

    //MS別積上げ計画入力 add 2006/08/02 M.Hoshino
    public static final String SESKEY_MPLR_REGISTERDATA = "MplPlanRegRegisterData"; //MS別積上げ計画入力登録データ

    //MS別品目分類選択 add 2006/08/17 M.Hoshino
    public static final String SESKEY_MPPC_VIEWDATA = "MplPcatCategoriesViewData"; //MS別品目分類選択一覧制御データ
    public static final String REQKEY_MPPC_DATA = "MplPcatCategoriesData"; //MS別品目分類選択一覧データ

    //ＭＳ別施設別品目別計画 add 2006/08/21 M.Hoshino
    public static final String SESKEY_MPLL_VIEWDATA = "MplPlanListViewData"; //ＭＳ別施設別品目別計画一覧制御データ
    public static final String REQKEY_MPLL_DATA = "MplPlanListData"; //ＭＳ別施設別品目別計画一覧データ

    //納入用条件リスト add 2006/09/12 M.Hoshino
    public static final String SESKEY_NJO_JOKENLIST = "NjoCommonJokenList"; //納入用条件リスト

    //本社一斉メール送信スケジュール add 2006/09/13 M.Hoshino
    public static final String SESKEY_ESS_VIEWDATA = "EdtSendScheduleViewData"; //本社一斉メール送信スケジュール一覧制御データ
    public static final String REQKEY_ESS_DATA = "EdtSendScheduleData"; //本社一斉メール送信スケジュール一覧データ

    //掲示板登録 add 2006/09/15 M.Hoshino
    public static final String SESKEY_CCB_REGISTERDATA = "CcjBbsRegisterData"; //掲示板登録登録データ
    //ClusCaseJ掲示板一覧 add 2006/09/19 M.Hoshino
    public static final String SESKEY_CCB_VIEWDATA = "CcjBbsViewData"; //ClusCaseJ掲示板一覧制御データ
    public static final String REQKEY_CCB_DATA = "CcjBbsData"; //ClusCaseJ掲示板一覧データ
    //ClusCaseJ掲示板 add 2006/09/20 M.Hoshino
    public static final String SESKEY_CCB_REFERDATA = "CcjBbsReferData"; //ClusCaseJ掲示板詳細データ

    //ナレッジ(静的) add 2006/09/26 M.Hoshino
    public static final String SESKEY_CKS_VIEWDATA = "CcjKnowledgeStaticViewData"; //ナレッジ(静的)一覧制御データ
    public static final String REQKEY_CKS_DATA = "CcjKnowledgeStaticData"; //ナレッジ(静的)一覧データ
    //ナレッジ(静的) add 2006/09/26 M.Hoshino
    public static final String SESKEY_CKS_REFERDATA = "CcjKnowledgeStaticReferData"; //ナレッジ(静的)詳細データ

    //ClusCaseJナレッジ・本部資料集 add 2006/09/27 M.Hoshino
    public static final String SESKEY_CCK_REGISTERDATA = "CcjKnowledgeRegisterData"; //ClusCaseJナレッジ・本部資料集登録データ
    //ClusCaseJナレッジ・本部資料集 add 2006/09/29 M.Hoshino
    public static final String SESKEY_CCK_REFERDATA = "CcjKnowledgeReferData"; //ClusCaseJナレッジ・本部資料集詳細データ

    //チエダス発言 add 2006/10/19 M.Hoshino
    public static final String SESKEY_CDT_VIEWDATA = "CdsTopicViewData"; //チエダス発言一覧制御データ
    public static final String REQKEY_CDT_DATA = "CdsTopicData"; //チエダス発言一覧データ

    //チエダス発言 add 2006/10/20 M.Hoshino
    public static final String SESKEY_CDT_REFERDATA = "CdsTopicReferData"; //チエダス発言詳細データ
    //チエダス発言 add 2006/10/20 M.Hoshino
    public static final String SESKEY_CDT_REGISTERDATA = "CdsTopicRegisterData"; //チエダス発言登録データ

    //MSマスタメンテナンス add 2006/10/31 M.Hoshino
    public static final String SESKEY_MMCR_REGISTERDATA = "MplMsCatRegRegisterData"; //MSマスタメンテナンス登録データ

    //CASE-J全社共通Q&A add 2006/11/07 M.Hoshino
    public static final String SESKEY_CQP_VIEWDATA = "CcjQaPublicViewData"; //CASE-J全社共通Q&A一覧制御データ
    public static final String REQKEY_CQP_DATA = "CcjQaPublicData"; //CASE-J全社共通Q&A一覧データ
    //CASE-J全社共通Q&A add 2006/11/09 M.Hoshino
    public static final String SESKEY_CQP_REFERDATA = "CcjQaPublicReferData"; //CASE-J全社共通Q&A詳細データ

    //講演会登録 add 2007/01/25 M.Hoshino
    public static final String SESKEY_TLE_REGISTERDATA = "TplLectureRegisterData"; //講演会登録登録データ

    //講演会マスタ add 2007/01/31 M.Hoshino
    public static final String SESKEY_TLM_TABLEDATA = "TplLctMstTableData"; //講演会マスタテーブルデータ

    //医師選択 add 2007/02/05 M.Hoshino
    public static final String SESKEY_TCD_VIEWDATA = "TplDocCategoriesViewData"; //医師選択一覧制御データ
    public static final String REQKEY_TCD_DATA = "TplDocCategoriesData"; //医師選択一覧データ

    //TVPC組織従業員展開選択 add 2007/02/13 M.Hoshino
    public static final String SESKEY_TSC_VIEWDATA = "TplSosCategoriesViewData"; //TVPC組織従業員展開選択制御データ
    public static final String REQKEY_TSC_DATA = "TplSosCategoriesData"; //TVPC組織従業員展開選択データ
    public static final String REQKEY_TSC_AJAX = "TplSosCategoriesAjax"; //TVPC組織従業員展開選択非同期データ

    //講演会参加医師 add 2007/02/21 M.Hoshino
    public static final String SESKEY_TED_VIEWDATA = "TplEnterDocViewData"; //講演会参加医師一覧制御データ
    public static final String REQKEY_TED_DATA = "TplEnterDocData"; //講演会参加医師一覧データ
    //講演会参加医師 add 2007/02/23 M.Hoshino
    public static final String SESKEY_TED_REGISTERDATA = "TplEnterDocRegisterData"; //講演会参加医師登録データ

    //講演会別PHS番号 add 2007/03/02 M.Hoshino
    public static final String SESKEY_TLP_VIEWDATA = "TplLecturePhsViewData"; //講演会別PHS番号一覧制御データ
    public static final String REQKEY_TLP_DATA = "TplLecturePhsData"; //講演会別PHS番号一覧データ

    //出席者名簿 add 2007/03/06 M.Hoshino
    public static final String SESKEY_TAD_VIEWDATA = "TplAttendDocViewData"; //出席者名簿一覧制御データ
    public static final String REQKEY_TAD_DATA = "TplAttendDocData"; //出席者名簿一覧データ

    public static final String SESKEY_TMD_VIEWDATA = "TplMailListViewData"; //メール一覧制御データ
    public static final String REQKEY_TMD_DATA = "TplMailListData"; //メール一覧データ

    //組織変更対応 add 2007/03/08 M.Hoshino
    public static final String C_DIST_MGR = "505"; //営業所長の職制コード
    public static final String C_RM = "515"; //リージョナルマネージャー(RM)の職制コード
    public static final String C_BR_MGR = "225"; //支店長の職制コード
    public static final String C_HOS_MGR = "435"; //病院部長の職制コード
    public static final String C_AL = "575"; //エリアチームリーダーの職制コード

    //講演会参加医師 add 2007/03/09 M.Hoshino
    public static final String REQKEY_TED_REPEATLIST = "TplEnterDocRepeatList"; //講演会参加医師重複データ

    //休暇予定入力 add 2007/05/16 M.Hoshino
    public static final String SESKEY_VTE_VIEWDATA = "VtsEntryViewData"; //休暇予定入力一覧制御データ
    public static final String REQKEY_VTE_DATA = "VtsEntryData"; //休暇予定入力一覧データ
    //休暇予定入力 add 2007/05/18 M.Hoshino
    public static final String SESKEY_VTE_REGISTERDATA = "VtsEntryRegisterData"; //休暇予定入力登録データ

    //活動対象施設 add 2007/08/17 M.Hoshino
    public static final String SESKEY_JTI_VIEWDATA = "JkrTargetInsViewData"; //活動対象施設一覧制御データ
    public static final String REQKEY_JTI_DATA = "JkrTargetInsData"; //活動対象施設一覧データ
    public static final String SESKEY_JTI_REGISTERDATA = "JkrTargetInsRegisterData"; //活動対象施設登録データ

    // *************************** 終了 *************************************************

    //---------------------- 片山　の追加領域 開始 担当 : 片山 -----------------------------
    //従業員関連メニュー add 2006/04/19 S.Katayama
    public static final String SESKEY_JMN_VIEWDATA = "JkrMenuViewData"; //従業員関連メニュー一覧制御データ
    public static final String REQKEY_JMN_DATA = "JkrMenuData"; //従業員関連メニュー一覧データ
    public static final String SESKEY_JMN_LISTOUTDATA = "JkrMenuListoutData"; //従業員関連メニューリストアウトデータ
    public static final String SESKEY_JMN_LOGINDATA = "LoginData"; //従業員関連メニューログインデータ

    //Ｐ担当者別市区郡別施設別一覧 add 2006/05/19 S.Katayama
    public static final String SESKEY_JPC_VIEWDATA = "JkrPmrCityInsViewData"; //Ｐ担当者別市区郡別施設別一覧一覧制御データ
    public static final String REQKEY_JPC_DATA = "JkrPmrCityInsData"; //Ｐ担当者別市区郡別施設別一覧一覧データ

    //複数担当先所属部科別担当者別医師一覧 add 2006/05/19 S.Katayama
    public static final String SESKEY_JCD_VIEWDATA = "JkrMultiChargeDocViewData"; //複数担当先所属部科別担当者別医師一覧一覧制御データ
    public static final String REQKEY_JCD_DATA = "JkrMultiChargeDocData"; //複数担当先所属部科別担当者別医師一覧一覧データ


    //帳票作成依頼（ポップアップ） add 2006/05/22 S.Katayama
    public static final String SESKEY_JPR_VIEWDATA = "JkrPdfReportCategoresViewData"; //帳票作成依頼（ポップアップ）一覧制御データ
    public static final String REQKEY_JPR_DATA = "JkrPdfReportCategoresData"; //帳票作成依頼（ポップアップ）一覧データ


    // *************************** 終了 *************************************************

    //---------------------- 飯田　の追加領域 開始 担当 : 飯田  -----------------------------
    //施設複数選択 add 2006/04/13 A.Iida
    public static final String SESKEY_CIM_VIEWDATA		= "CatInstitutionMltViewData";		//施設複数選択一覧制御データ
    public static final String REQKEY_CIM_DATA			= "CatInstitutionMltData";			//施設複数選択一覧データ
    public static final String SESKEY_CIM_INSTYPELIST	= "CatInstitutionMltInsTypeList";	//施設選択施設区分リスト
    public static final String SESKEY_CIM_PREFfJISLIST	= "CatInstitutionMltPrefJisList";	//施設選択JIS府県リスト

    //施設別担当変更 add 2006/05/17 A.Iida
    public static final String SESKEY_JIM_VIEWDATA		= "JkrInsMrChangeViewData";			//施設別担当変更一覧制御データ
    public static final String REQKEY_JIM_DATA			= "JkrInsMrChangeData";				//施設別担当変更一覧データ
    public static final String SESKEY_JIM_REGISTERDATA	= "JkrInsMrChangeRegisterData";		//施設別担当変更登録データ

    //施設別担当変更エラー一覧 add 2006/06/12 A.Iida
    public static final String SESKEY_JIE_VIEWDATA		= "JkrInsMrChangeViewData";			//施設別担当変更エラー一覧制御データ
    public static final String REQKEY_JIE_DATA			= "JkrInsMrChangeData";				//施設別担当変更エラー一覧データ

    //従業員関連MSGマスタ add 2006/05/24 A.Iida
    public static final String SESKEY_JMM_DATA			= "JkrMsgMstTableData";				//従業員関連MSGデータ

    //従業員基本接続規則 add 2006/08/07 A.Iida
    public static final String SESKEY_SJC_VIEWDATA		= "SjmJgiConnectRuleViewData";		//従業員基本接続規則一覧制御データ
    public static final String REQKEY_SJC_DATA			= "SjmJgiConnectRuleData";			//従業員基本接続規則一覧データ

    //従業員基本接続規則 add 2006/08/09 A.Iida
    public static final String SESKEY_SJC_REGISTERDATA	= "SjmJgiConnectRuleRegisterData"; 	//従業員基本接続規則登録データ

    //従業員関連利用可能状態取得 add 2006/09/20 A.Iida
    public static final String REQKEY_JKR_TIMECTRL_DATA	= "JgiKanrenTimeLimitData"; 		//従業員関連利用可能時間データ

    // *************************** 終了 *************************************************

    //---------------------- 山中　の追加領域 開始 担当 : 山中  -----------------------------
    //分類ポッップアップ add 2006/05/24 S.Yamanaka
    public static final String SESKEY_PIFPRODSELECT_VIEWDATA = "PifProdSelectViewData"; //分類ポッップアップ一覧制御データ
    public static final String REQKEY_PIFPRODSELECT_DATA = "PifProdSelectData"; //分類ポッップアップ一覧データ

    //仮従業員登録一覧画面 add 2006/06/06 S.Yamanaka
    public static final String SESKEY_JPJ_VIEWDATA = "JkrProvJgiViewData"; //仮従業員登録一覧画面一覧制御データ
    public static final String REQKEY_JPJ_DATA = "JkrProvJgiData"; //仮従業員登録一覧画面一覧データ

    //仮従業員登録画面 add 2006/06/10 S.Yamanaka
    public static final String SESKEY_JPJ_REGISTERDATA = "JkrProvJgiRegisterData"; //仮従業員登録画面登録データ

    //従業員フラグメンテナンス add 2006/08/07 S.Yamanaka
    public static final String SESKEY_SJF_VIEWDATA = "SjmJgiFlgMainteViewData"; //従業員フラグメンテナンス一覧制御データ
    public static final String REQKEY_SJF_DATA = "SjmJgiFlgMainteData"; //従業員フラグメンテナンス一覧データ

    //従業員フラグメンテナンス add 2006/08/14 S.Yamanaka
    public static final String SESKEY_SJF_REGISTERDATA = "SjmJgiFlgMainteRegisterData"; //従業員フラグメンテナンス登録データ

    //MS計画PDF作成ポップアップ add 2006/08/31 S.Yamanaka
    public static final String SESKEY_MPC_VIEWDATA = "MplPdfCreationViewData"; //MS計画PDF作成ポップアップ一覧制御データ
    public static final String REQKEY_MPC_DATA = "MplPdfCreationData"; //MS計画PDF作成ポップアップ一覧データ


    //組織従業員PDF作成ポップアップ add 2006/09/06 S.Yamanaka
    public static final String SESKEY_SJM_VIEWDATA = "SjmPdfCreationViewData"; //組織従業員PDF作成ポップアップ一覧制御データ
    public static final String REQKEY_SJM_DATA = "SjmPdfCreationData"; //組織従業員PDF作成ポップアップ一覧データ

    //ワクチン品質情報コメント一覧 add 2006/09/28 S.Yamanaka
    public static final String SESKEY_VQI_VIEWDATA = "VqiCommListViewData"; //ワクチン品質情報コメント一覧制御データ
    public static final String REQKEY_VQI_DATA = "VqiCommListData"; //ワクチン品質情報コメント一覧データ

    //ワクチン品質情報コメント一覧 add 2006/09/29 S.Yamanaka
    public static final String SESKEY_VQI_REGISTERDATA = "VqiCommentRegisterData"; //ワクチン品質情報コメント一覧登録データ
    public static final String SESKEY_VQI_REFERDATA = "VqiCommentReferData"; //ワクチン品質情報コメント一覧詳細データ

    //サテライト選択ポップアップ add 2006/10/16 S.Yamanaka
    public static final String SESKEY_SOC_VIEWDATA = "SjmOfficeCategoriesViewData"; //サテライト選択ポップアップ一覧制御データ
    public static final String REQKEY_SOC_DATA = "SjmOfficeCategoriesData"; //サテライト選択ポップアップ一覧データ

    // *************************** 終了 *************************************************

    //---------------------- 加茂　の追加領域 開始 担当 : 加茂  -----------------------------
    //施設複数選択 add 2006/04/13 M.Kamo
    public static final String SESKEY_JTD_VIEWDATA    	  = "JkrTargetDocViewData";      		//活動対象医師一覧制御データ
    public static final String SESKEY_JTD_DATA	          ="JkrTargetDocData";				    //活動対象医師一覧データ(あえてSESにしています)

    //活動対象医師登録 add 2006/06/01 M.Kamo
    public static final String SESKEY_JTD_REGISTERDATA 	  = "JkrTargetDocRegisterData"; 		//活動対象医師登録登録データ

    //活動対象医師一括登録 add 2006/05/27 M.Kamo
    public static final String SESKEY_JTI_ERRVIEWDATA 	  = "JkrTargetDocIkkatsuErrViewData";		//活動対象医師一括エラー一覧制御データ
    public static final String REQKEY_JTI_ERRDATA 		      = "JkrTargetDocIkkatsuErrData"; 		//活動対象医師一括エラーデータ
    public static final String REQKEY_JTI_CSVDATA 		      = "JkrTargetDocIkkatsuCsvData"; 		//活動対象医師CSV一覧出力データ
    public static final String SESKEY_JTI_FILEUPLOADDATA  = "JkrTargetDocIkkatsuFileUpLoadData"; //活動対象医師一括登録登録デー

    //品質情報コメント一覧 add 2006/07/17 M.Kamo
    public static final String SESKEY_QCL_VIEWDATA       = "QicCommListViewData";   //品質情報コメント一覧制御データ
    public static final String REQKEY_QCL_DATA           = "QicCommListData";       //品質情報コメント一覧データ
    public static final String SESKEY_QCL_REFERDATA      = "QualityReferData";      //品質情報コメント 上段品質情報表示部詳細データ

    //QA add 2006/08/23 M.Kamo
    public static final String SESKEY_CCQ_REGISTERDATA    = "CcjQaRegisterData";     //QA登録データ

    // *************************** 終了 *************************************************

    //---------------------- 坂口　の追加領域 開始 担当 : 坂口  -----------------------------
    //品質情報コメント add 2006/07/13 K.Sakaguchi
    public static final String SESKEY_QCM_REFERDATA = "QicCommentReferData"; //品質情報コメント詳細データ
    //品質情報コメント add 2006/07/14 K.Sakaguchi
    public static final String SESKEY_QCM_REGISTERDATA = "QicCommentRegisterData"; //品質情報コメント登録データ

    //組織基本一覧 add 2006/06/28 K.Sakaguchi
    public static final String SESKEY_SSL_VIEWDATA = "SjmSosListViewData"; //組織基本一覧一覧制御データ
    public static final String REQKEY_SSL_DATA = "SjmSosListData"; //組織基本一覧一覧データ
    //組織基本情報更新 add 2006/07/04 K.Sakaguchi
    public static final String SESKEY_SSD_REFERDATA = "SjmSosMstDetailData"; //組織基本情報データ
    public static final String SESKEY_SSD_REFERLISTDATA = "SjmSosMstDetailListData"; //組織基本情報データ
    //組織基本情報更新 add 2006/07/06 K.Sakaguchi
    public static final String SESKEY_SSD_REGISTERDATA = "SjmSosMstDetailRegisterData"; //組織基本情報更新登録データ
    //従業員基本一覧 add 2006/08/01 K.Sakaguchi
    public static final String SESKEY_SJL_VIEWDATA = "SjmJgiListViewData"; //従業員基本一覧制御データ
    public static final String REQKEY_SJL_DATA = "SjmJgiListData"; //従業員基本一覧データ
    //従業員基本 add 2006/08/11 K.Sakaguchi
    public static final String SESKEY_SJD_REGISTERDATA = "SjmJgiMstDetailRegisterData";       //従業員基本更新登録データ

    //教えてCASE-J add 2006/09/15 K.Sakaguchi
    public static final String SESKEY_CCQ_REFERDATA = "CcjQaReferData"; //教えてCASE-J詳細データ
    //教えてCASE-J add 2006/09/22 K.Sakaguchi
    public static final String SESKEY_CCQ_VIEWDATA = "CcjQaViewData"; //教えてCASE-J一覧制御データ
    public static final String REQKEY_CCQ_DATA = "CcjQaData"; //教えてCASE-J一覧データ
    //CASE-J 動画一覧 add 2006/09/26 K.Sakaguchi
    public static final String SESKEY_CSA_VIEWDATA = "CcjAnimationStaticViewData"; //CASE-J 動画一覧一覧制御データ
    public static final String REQKEY_CSA_DATA = "CcjAnimationStaticData"; //CASE-J 動画一覧一覧データ
    //CASE-J ナレッジ本部資料集 add 2006/09/27 K.Sakaguchi
    public static final String SESKEY_CCK_VIEWDATA = "CcjKnowledgeViewData"; //CASE-J ナレッジ本部資料集一覧制御データ
    public static final String REQKEY_CCK_DATA = "CcjKnowledgeData"; //CASE-J ナレッジ本部資料集一覧データ
    // *************************** 終了 *************************************************

    //---------------------- 田中　の追加領域 開始 担当 : 田中  -----------------------------
    //掲示板(静的) add 2006/08/16 Y.Tanaka
    public static final String SESKEY_CBS_VIEWDATA = "CcjBbsStaticViewData"; //掲示板(静的)一覧制御データ
    public static final String REQKEY_CBS_DATA = "CcjBbsStaticData"; //掲示板(静的)一覧データ
    //QA(静的) add 2006/08/23 Y.Tanaka
    public static final String SESKEY_CQS_VIEWDATA = "CcjQaStaticViewData"; //QA(静的)一覧制御データ
    public static final String REQKEY_CQS_DATA = "CcjQaStaticData"; //QA(静的)一覧データ
    //CASE-Jメニュー add 2006/08/18 Y.Tanaka
    public static final String SESKEY_CMN_VIEWDATA = "CcjMenuViewData"; //CASE-Jメニュー一覧制御データ
    public static final String REQKEY_CMN_DATA = "CcjMenuData"; //CASE-Jメニュー一覧データ
    //本部PPT(静的) add 2006/08/25 Y.Tanaka
    public static final String SESKEY_CPS_VIEWDATA = "CcjPptStaticViewData"; //本部PPT(静的)一覧制御データ
    public static final String REQKEY_CPS_DATA = "CcjPptStaticData"; //本部PPT(静的)一覧データ
    //講演会一覧 add 2007/01/29 Y.Tanaka
    public static final String SESKEY_TLC_VIEWDATA = "TplLectureCountViewData"; //講演会一覧一覧制御データ
    public static final String REQKEY_TLC_DATA = "TplLectureCountData"; //講演会一覧一覧データ
    //講演会VCube一覧 // add 2013/02/06 T.Tamura J13-0001_TV・Web会議システム_VCube連携+その他要件対応
    public static final String SESKEY_TLV_VIEWDATA = "TplLectureVCubeViewData"; //講演会VCube一覧制御データ
    public static final String REQKEY_TLV_DATA = "TplLectureVCubeDspData"; //講演会VCube一覧データ(画面表示用)
    public static final String REQKEY_TLV_FREEID_DATA = "TplLectureVCubeFreeIdData"; //講演会VCube一覧空ID情報
    public static final String SESKEY_TLV_LOGINDATA = "LoginData"; //講演会VCubeログインデータ
    public static final String SESKEY_TLV_SCLMST = "TplCdMstVKbn"; //規模マスターデータ
    //講演会VCube詳細（Web会議予約用ID発行） // add 2013/03/05 I.Oda J13-0001_TV・Web会議システム_VCube連携+その他要件対応
    public static final String REQKEY_TLV_REFERDATA = "TplLectureVCubeReferData"; //講演会VCube詳細データ

    //講演会参加状況 add 2007/02/22 Y.Tanaka
    public static final String SESKEY_TES_VIEWDATA = "TplEnterStatusViewData"; //講演会参加状況一覧制御データ
    public static final String REQKEY_TES_DATA = "TplEnterStatusData"; //講演会参加状況一覧データ
    //講演会参加状況 add 2007/02/22 Y.Tanaka
    public static final String SESKEY_TES_REGISTERDATA = "TplEnterStatusRegisterData"; //講演会参加状況登録データ
    //講演会別端末No add 2007/03/08 Y.Tanaka
    public static final String SESKEY_TLM_VIEWDATA = "TplLectureMcsViewData"; //講演会別端末No一覧制御データ
    public static final String REQKEY_TLM_DATA = "TplLectureMcsData"; //講演会別端末No一覧データ
    //外部リンク（アクセスログ出力付） add 2007/04/16 Y.Tanaka
    public static final String SESKEY_CTL_VIEWDATA = "CatExternalLinkViewData"; //外部リンク（アクセスログ出力付）一覧制御データ
    public static final String REQKEY_CTL_DATA = "CatExternalLinkData"; //外部リンク（アクセスログ出力付）一覧データ
    //組織選択（組織従業員用） add 2007/05/28 Y.Tanaka
    public static final String SESKEY_SSC_VIEWDATA = "SjmSosCategoriesViewData"; //組織選択（組織従業員用）一覧制御データ
    public static final String REQKEY_SSC_DATA = "SjmSosCategoriesData"; //組織選択（組織従業員用）一覧データ
    // *************************** 終了 *************************************************

    //---------------------- 若杉　の追加領域 開始 担当 : 若杉  -----------------------------
    //本社一斉メール送信情報 add 2006/09/01 Y.Wakasugi
    public static final String SESKEY_EAS_VIEWDATA = "EdtAdminScheduleViewData"; //本社一斉メール送信情報一覧制御データ
    public static final String REQKEY_EAS_DATA = "EdtAdminScheduleData"; //本社一斉メール送信情報一覧データ


    //組織基本情報更新 add 2006/07/06 K.Sakaguchi
    public static final String SESKEY_SSD_REGISTERDATA_PRE = "SjmSosMstDetailRegisterDataPre"; //組織基本情報更新登録データ

    //---------------------- 中村(喜)　の追加領域 開始 担当 : 中村(喜)  ----------------------------------------------------
    //組織従業員メニュー add 2006/10/16 Yo.Nakamura
    public static final String SESKEY_SMN_VIEWDATA	= "SjmMenuViewData";	//組織従業員メニュー一覧制御データ
    public static final String REQKEY_SMN_DATA		= "SjmMenuData";		//組織従業員メニュー一覧データ
    //休暇予定一覧（年単位） add 2007/05/16 Yo.Nakamura
    public static final String SESKEY_VYL_VIEWDATA	= "VtsYearlyListViewData";	//休暇予定一覧（年単位）一覧制御データ
    public static final String REQKEY_VYL_DATA		= "VtsYearlyListData";		//休暇予定一覧（年単位）一覧データ
    //休暇予定管理システム add 2007/05/18 Yo.Nakamura
    public static final String SESKEY_VTS_VIEWDATA = "vacationscheduleViewData";//休暇予定管理システム一覧制御データ
    public static final String REQKEY_VTS_DATA		= "vacationscheduleData";	//休暇予定管理システム一覧データ
    //休暇予定一覧（月単位） add 2007/05/25 Yo.Nakamura
    public static final String SESKEY_VML_VIEWDATA	= "VtsMonthlyListViewData";	//休暇予定一覧（月単位）一覧制御データ
    public static final String REQKEY_VML_DATA		= "VtsMonthlyListData";		//休暇予定一覧（月単位）一覧データ
    public static final String REQKEY_VML_CALDATA	= "VtsMonthlyListCalData";	//休暇予定一覧（月単位）日付リスト

    //医薬営業本部 標準組織背番号 add 2007/05/17 Yo.Nakamura
    public static final String COM_IEIHON_CD		= "01050";					//医薬営業本部 標準組織背番号

    //市販直後調査左フレーム
    public static final String PMT_ATL_SEL_PROD		= "atlSelProd";				//市販直後調査　左フレーム　チームリーダ品目選択

    //製品情報-包装変更ポップアップ用
    public static final String SESKEY_PIF_PPC_VIEWDATA	= "PifPackChangeCategoriesViewData";	//製品情報　品名選択ポップアップ
    public static final String REQKEY_PIF_PPC_DATA = "PifPackChangeCategoriesData"; //製品情報　品名選択ポップアップ一覧データ

    //メモ add 2010/09/04 Yo.Nakamura
    public static final String SESKEY_MEM_VIEWDATA	= "memoViewData";	//メモ一覧制御データ
    public static final String REQKEY_MEM_DATA		= "memoData";		//メモ一覧データ
    public static final String SESKEY_MEM_STARTROW	= "startRow";		//開始行
    // ********************* 中村(喜)　の追加領域 終了 担当 : 中村(喜)  ****************************************************

    //---------------------- 遠藤　の追加領域 開始 担当 : 遠藤  -----------------------------
    //全社共有Ｑ＆Ａ登録更新 add 2006/11/09 Y.Endo
    public static final String SESKEY_CQP_REGISTERDATA = "CcjQaPublicRegisterData"; //全社共有Ｑ＆Ａ登録更新登録データ

    //---------------------- 森川　の追加領域 開始 担当 : 森川  -----------------------------
    //医師固定コード複数入力 add 2007/05/24 K.Morikawa
    public static final String SESKEY_DCA_REGISTERDATA	= "DmcDocInputCategoriesRegisterData";	//医師固定コード複数入力一覧制御データ
    public static final String REQKEY_DCA_DATA			= "DmcDocInputCategoriesData";			//医師固定コード複数入力一覧データ

    //書籍 add 2007/09/19 K.Morikawa
    public static final String SESKEY_PRB_VIEWDATA		= "PrctcBookViewData";		//書籍一覧制御データ
    public static final String REQKEY_PRB_DATA			= "PrctcBookData";			//書籍一覧データ
    public static final String SESKEY_PRB_REFERDATA		= "PrctcBookReferData";		//書籍詳細データ
    public static final String SESKEY_PRB_REGISTERDATA	= "PrctcBookRegisterData";	//書籍登録データ

    //---------------------- 山元　の追加領域 開始 担当 : 山元  -----------------------------

    //おすすめ情報活動材料 add 2007/06/04 S.Yamamoto
    public static final String SESKEY_CCS_REGISTERDATA = "CcjSasRegisterData"; //おすすめ情報活動材料登録データ

    //SSG特約店テーブル add 2008/09/04 S.Yamamoto
    public static final String SESKEY_SWT_VIEWDATA 		= "SgWsTblViewData"; 		//SSG特約店テーブル一覧制御データ
    public static final String REQKEY_SWT_DATA 			= "SgWsTblData"; 			//SSG特約店テーブル一覧データ
    public static final String SESKEY_SWT_REFERDATA 	= "SgWsTblReferData"; 		//SSG特約店テーブル詳細データ
    public static final String SESKEY_SWT_REGISTERDATA 	= "SgWsTblRegisterData";	//SSG特約店テーブル登録データ

    //帳票出力要求 add 2008/10/23 S.Yamamoto
    public static final String SESKEY_SPD_VIEWDATA	= "SgPdfOutputDemandViewData"; //帳票出力要求一覧制御データ
    public static final String REQKEY_SPD_DATA		= "SgPdfOutputDemandData"; //帳票出力要求一覧データ
    // ********************* 山元　の追加領域 終了 担当 : 山元  ****************************************************

    //---------------------- 才野　の追加領域 開始 担当 : 才野  -----------------------------
    //CASE-Jおすすめ情報活動材料 add 2007/06/01 T.Saino
    public static final String SESKEY_CCS_VIEWDATA = "ccjSasViewData"; //CASE-Jおすすめ情報活動材料一覧制御データ
    public static final String REQKEY_CCS_DATA = "ccjSasData"; //CASE-Jおすすめ情報活動材料一覧データ

    //組織選択ポップアップ add 2007/09/18 Yo.Nakamura
    public static final String	SESKEY_SPU_VIEWDATA	= "SosPopUpViewData";		// 組織選択ポップアップ一覧制御データ
    public static final String	REQKEY_SPU_DATA		= "SosPopUpData";			// 組織選択ポップアップ一覧データ
    public static final String	REQKEY_SPU_HISTDATA	= "histResultList";			// 組織選択ポップアップ組織履歴一覧データ
    public static final String	REQKEY_SPU_SOSDATA	= "sosResultList";			// 組織選択ポップアップ組織情報一覧データ
    public static final int		INIT_OPEN_RANK		= 4;						// 初期展開部門ランク
    public static final String	INIT_SEL_TYPE_FLG	= "1";						// 初期選択フラグ
    public static final String	INIT_DSP_DATA_KB	= "1";						// 初期対象データ区分
    public static final String	INIT_MULTI_SEL_FLG	= "1";						// 初期複数選択
    public static final String	INIT_DMY_SOS_KB		= "1";						// 初期ダミー組織区分
    public static final String	INIT_SOS_SORT_KB	= "1";						// 初期組織並び順区分
    public static final String	INIT_TOP_RANK		= "1";						// 初期先頭部門ランク
    public static final String	SESKEY_SPU_HISTLIST	= "historyList";			// 組織選択ポップアップ組織履歴一覧

    //組織従業員 add 2007/09/11 T.Saino
    public static final String SESKEY_SJP_VIEWDATA = "SosJgiPopUpViewControlData";	//組織従業員一覧制御データ
    public static final String REQKEY_SJP_DATA = "SosJgiPopUpData";	//組織従業員一覧データ

    //組織従業員複数選択ポップアップ add 2010/08/23 uchida
    public static final String SESKEY_SJMP_VIEWDATA = "SosJgiMultiPopUpViewControlData";	//組織従業員複数選択一覧制御データ
    public static final String REQKEY_SJMP_DATA = "SosJgiMultiPopUpData";					//組織従業員複数選択一覧データ

    //---------------------- 照井　の追加領域 開始 担当 : 照井  -----------------------------
    //PMS教材変更 add 2008/07/25 M.Terui
    public static final String SESKEY_CPR_VIEWDATA 	= "CefPmsRegisterViewData"; //PMS教材変更一覧制御データ
    public static final String REQKEY_CPR_DATA		 	= "CefPmsRegisterData"; //PMS教材変更一覧データ

    public static final String SESKEY_CPR_MODIFYDATA 	= "CefPmsRegisterModifyData"; //PMS教材変更編集データ

    public static final String SESKEY_AYU_IMAGEDATA 	= "AyuImageData"; //QlikView画像格納場所データ

    // add 2013/04/25 M.Terui J13-0004 2013年4月期末期首 本部組織変更対応（DB化）
    public static final String SESKEY_DMC_HONBUNAMEDATA 	= "DmcHonbuSosNameData"; //医師基本 本部組織名称データ
    // ********************* 照井　の追加領域 終了 担当 : 照井  ****************************************************

    //---------------------- 林　の追加領域 開始 担当 : 林  -----------------------------
    //本部長メッセージコメント add 2008/06/30 S.Hayashi
    public static final String SESKEY_HMC_VIEWDATA = "HmsCommentViewData"; //本部長メッセージコメント一覧制御データ
    public static final String REQKEY_HMC_DATA = "HmsCommentData"; //本部長メッセージコメント一覧データ
    public static final String SESKEY_HMC_REFERDATA = "HmsCommentReferData"; //本部長メッセージコメント詳細データ
    public static final String SESKEY_HMC_REGISTERDATA = "HmsCommentRegisterData"; //本部長メッセージコメント登録データ
    public static final String SESKEY_HMC_FILEDATA = "HmsCommentFileData"; //本部長メッセージコメント添付ファイルデータ
    //市販直後調査軒数表 add 2010/03/26 S.Hayashi
    public static final String SESKEY_PIC_VIEWDATA = "PmmInsCntViewData"; //市販直後調査軒数表一覧制御データ
    public static final String REQKEY_PIC_DATA = "PmmInsCntData"; //市販直後調査軒数表一覧データ
    //市販直後調査医療機関追加画面 add 2010/04/20 S.Hayashi
    public static final String SESKEY_PAI_REFERDATA = "PmmAddInsReferData"; //医療機関追加画面詳細データ
    public static final String SESKEY_PAI_REGISTERDATA = "PmmAddInsRegisterData"; //医療機関追加画面登録データ
    //********************* 林　の追加領域 終了 担当 : 林 ****************************************************

    // ********************* 林　の追加領域 終了 担当 : 林  ****************************************************

    //---------------------- 大西　の追加領域 開始 担当 : 大西  -----------------------------
    public static final String SESKEY_DHY_VIEWDATA = "DmcHistPayAddressViewData";	//支払調書履歴一覧制御データ
    public static final String REQKEY_DHY_DATA = "DmcHistPayAddressData";	//支払調書履歴一覧データ
    // add start 2009/03/04 T.Oonisi
    public static final String SESKEY_JPM_VIEWDATA = "JstProdMonthViewData";	//JSTR-3品目別・月別表（金額・シェア）一覧制御データ
    public static final String REQKEY_JPM_DATA = "JstProdMonthData";	//JSTR-3品目別・月別表（金額・シェア）一覧データ
    public static final String SESKEY_JBC_VIEWDATA = "JstInsBrickCategoriesViewData"; //新市場データ対応一覧制御データ
    public static final String REQKEY_JBC_DATA = "JstInsBrickCategoriesData"; //新市場データ対応一覧データ
    public static final String SESKEY_JBI_VIEWDATA = "JstBrickInsListViewData"; //JSTR-3ブリック内施設一覧一覧制御データ
    public static final String REQKEY_JBI_DATA = "JstBrickInsListData"; //JSTR-3ブリック内施設一覧一覧データ
    public static final String SESKEY_JHP_VIEWDATA = "jstHelpViewData"; //JSTR-3ヘルプ一覧制御データ
    public static final String REQKEY_JHP_DATA = "jstHelpData"; //JSTR-3ヘルプ一覧データ
    // add end   2009/03/04 T.Oonisi

    //精算データ一覧 add 2009/10/09 T.Oonishi
    public static final String SESKEY_DCPC_VIEWDATA = "DmcPayCategoriesViewData"; //精算データ一覧一覧制御データ
    public static final String REQKEY_DCPC_DATA = "DmcPayCategoriesData"; //精算データ一覧一覧データ
    public static final String SESKEY_DPD_VIEWDATA = "DmcPayDepartmentViewData"; //源泉支払先一覧_精算部門別制御データ
    public static final String REQKEY_DPD_DATA = "DmcPayDepartmentData"; //源泉支払先一覧_精算部門別一覧データ

    //市販直後調査 add 2010/03/19 T.Oonishi
    public static final String SESKEY_PIF_VIEWDATA = "PmmInsFollowViewData"; //市販直後調査一覧制御データ
    public static final String REQKEY_PIF_DATA = "PmmInsFollowData"; //市販直後調査一覧データ

    //医師別明細 add 2010/03/31 T.Oonishi
    public static final String SESKEY_PDFV_VIEWDATA = "PmmDocFollowViewData"; //医師別明細一覧制御データ
    public static final String REQKEY_PDF_DATA = "PmmDocFollowData"; //医師別明細一覧データ

    //活動進捗報告 add 2010/04/12 T.Oonishi
    public static final String SESKEY_PSMA_REFERDATA = "PmmStateMaintReferData"; //活動進捗報告詳細データ

    //メインメニュー add 2010/04/23 T.Oonishi
    public static final String SESKEY_MENU_DATA = "mainMenuData"; //メインメニューデータ
    //QV画像リンク先DB化対応 add 2010/11/15 T.Oonishi
    public static final String REQKEY_GADGET_DATA1 = "gadgetData1"; //ガジェットリンクデータ1
    public static final String REQKEY_GADGET_DATA2 = "gadgetData2"; //ガジェットリンクデータ2
    public static final String REQKEY_GADGET_DATA3 = "gadgetData3"; //ガジェットリンクデータ3
    public static final String REQKEY_GADGET_DATA4 = "gadgetData4"; //ガジェットリンクデータ4

    //施設検索ポップアップ add 2011/11/18 T.Oonishi
    public static final String SESKEY_CIT_VIEWDATA = "CatInsTelephoneViewControlData";	//支払調書履歴一覧制御データ
    public static final String REQKEY_CIT_DATA = "CatInsTelephoneData";	//支払調書履歴一覧データ

    // ********************* 大西　の追加領域 終了 担当 : 大西  ****************************************************

    //e-プロモーション add 2008/04/01 T.Saino
    public static final String SESKEY_EDT_CTL_DATA = "EdtControlData";	            //eプロモーション制御データ
    public static final String SESKEY_ECM_PRE_VIEWDATA = "EcmEcomSendPreViewData";	//eコミュニケーション前回送付一覧制御データ

    //--------------------- 中(武)　の追加領域 開始 担当 : 中(武)  -------------------------------------------
    public static final String SESKEY_EDD_VIEWDATA  = "EdtDeliveryDocViewData"  ;	//eプロ送付医師登録一覧データ
    public static final String REQKEY_EDD_DATA      = "EdtDeliveryDocData" ;    	//eプロ送付医師登録更新データ
    public static final String REQKEY_EDD_REGISTERDATA = "EdtDeliveryDocSearchRegisterData" ;    	//eプロ送付医師登録更新データ
    //********************* 中(武)　の追加領域 終了 担当 : 中(武) ****************************************************

    //--------------------- 山元  の追加領域 開始 担当：山元 ---------------------------------------------------------
    public static final String SESKEY_JTS_VIEWDATA = "JkrToSosStatusViewData"; //担当変更状況（新組織）一覧制御データ
    public static final String REQKEY_JTS_DATA = "JkrToSosStatusData"; //担当変更状況（新組織）一覧データ
    public static final String SESKEY_JTS_REGISTERDATA = "JkrToSosStatusRegisterData"; //担当変更状況（新組織）登録データ
    //********************* 山元  の追加領域 終了 担当：山元 *********************************************************


    // add start 2008/10/7 T.Fukushima TODO: 代行機能が新サーバへ移行した場合は必ず削除すること！
    public static final String COOKIE_ACT_JGI_NO = "CookieActJgino";
    public static final String REQKEY_QLV_DATA = "QlvRequestAuthData";
    //AE進捗(管理画面)
    public static final String SESKEY_AAD_AERNO = "aerNo";
    public static final String SESKEY_AAD_EDANO = "edaNo";
    public static final String SESKEY_AAD_SEQ = "seq";
    // add end   2008/10/7 T.Fukushima

    //\\\\\\\\\\\\\\\\\\\\\ 圓地　の追加領域 開始 担当 : 圓地 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    // ADD START 圓地 20008/11/12　納入速報
    public static final String SESKEY_NJY_MENU_VIEWDATA = "NjyMenuViewData"; //納入実績メニュー制御データ
    public static final String SESKEY_NJY_MENU_DATA = "NjyMenuData"; //納入実績メニューデータ

    public static final String SESKEY_NJO_FLASH_SCR            = "NjoFlash";       //納入速報の画面ID
    // ADD E N D 圓地 20008/11/12　納入速報　
    //\\\\\\\\\\\\\\\\\\\\\ 圓地　の追加領域 開始 担当 : 圓地 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //--------------------- 仁賀  の追加領域 開始 担当：仁賀 ---------------------------------------------------------
    //割戻金計算システム
    public static final String SESKEY_RBC_LOGINDATA = "RcLoginData"; //割戻金計算システムログイン情報

    //割戻金計算システムメニュー add 2008/10/03 A.Fujii
    public static final String SESKEY_RCM_VIEWDATA = "RcMenuViewData"; //割戻金計算システムメニュー一覧制御データ

    //BLOBアップロードダウンロード用
    public static final String SESKEY_RTB_VIEWDATA = "RcTestBlobFileViewData"; //BLOBファイル操作一覧制御データ
    public static final String REQKEY_RTB_DATA = "RcTestBlobFileData"; //BLOBファイル操作一覧データ

    //割戻金BLOBアップロードダウンロード用
    public static final String SESKEY_RTR_VIEWDATA = "RcTestRebateBlobFileViewData"; //割戻金BLOBファイル操作一覧制御データ
    public static final String REQKEY_RTR_DATA = "RcTestRebateBlobFileData"; //割戻金BLOBファイル操作一覧データ

    //ファイルダウンロード add 2008/10/15 A.Fujii
    public static final String SESKEY_RFD_VIEWDATA    = "RcFileDownLoadViewData"; //ファイルダウンロード一覧制御データ
    public static final String REQKEY_RFD_DATA_KIHON  = "RcFileDownLoadData_Kihon"; //ファイルダウンロード一覧データ(基本情報）
    public static final String REQKEY_RFD_DATA_HOSYO  = "RcFileDownLoadData_Hosyo"; //ファイルダウンロード一覧データ（報奨率）
    public static final String REQKEY_RFD_DATA_REVATE = "RcFileDownLoadData_Wari"; //ファイルダウンロード一覧データ（割戻金）
    public static final String REQKEY_RFD_DATA_FILEKEY = "RcFileDownLoadData_FileKey"; //ファイルダウンロード画面遷移データ
    //ファイルアップロード add 2008/10/28 A.Fujii
    public static final String SESKEY_RFU_VIEWDATA    = "RcFileUpLoadViewData"; //ファイルアップロード一覧制御データ
    public static final String REQKEY_RFU_DATA_KIHON  = "RcFileUpLoadData_Kihon"; //ファイルアップロード一覧データ(基本情報）
    public static final String REQKEY_RFU_DATA_HOSYO  = "RcFileUpLoadData_Hosyo"; //ファイルアップロード一覧データ（報奨率）
    public static final String REQKEY_RFU_DATA_REVATE = "RcFileUpLoadData_Wari"; //ファイルアップロード一覧データ（割戻金）
    public static final String REQKEY_RFU_DATA_FILEKEY = "RcFileUpLoadData_FileKey"; //ファイルアップロード画面遷移データ
    //四半期支払確認依頼一覧 add 2008/10/17 A.Umezawa
    public static final String SESKEY_RQC_REGISTERDATA = "RcQtrPaymentCheckReqRegisterData"; //四半期支払確認依頼一覧登録データ
    //四半期支払承認依頼 add 2008/10/21 K.Nakamoto
    public static final String SESKEY_RQR_VIEWDATA = "RcQtrPaymentApprovalReqViewData"; //四半期支払承認依頼一覧制御データ
    public static final String REQKEY_RQR_DATA = "RcQtrPaymentApprovalReqData"; //四半期支払承認依頼一覧データ
    //割戻金承認依頼 add 2008/11/12 K.Nakamoto
    public static final String SESKEY_RAR_VIEWDATA = "RcRebateApprovalReqViewData"; //割戻金承認依頼一覧制御データ
    public static final String REQKEY_RAR_DATA = "RcRebateApprovalReqData"; //割戻金承認依頼一覧データ
    //割戻金確定依頼 add 2008/11/17 k.Nakamoto
    public static final String SESKEY_RDN_VIEWDATA = "RcRebateDecisionViewData"; //割戻金確定依頼一覧制御データ
    public static final String REQKEY_RDN_DATA = "RcRebateDecisionData"; //割戻金確定依頼一覧データ
    //割戻金作成状況一覧 add 2008/11/06 K.Nakamoto
    public static final String SESKEY_RCT_VIEWDATA = "RcRebateCreateViewData"; //割戻金作成状況一覧制御データ
    public static final String REQKEY_RCT_DATA = "RcRebateCreateData"; //割戻金作成状況一覧データ
    public static final String REQKEY_RCT_DATA_TOTAL = "RcRebateCreateTotalData"; //割戻金作成状況一覧データ（合計）
    //四半期支払確認依頼 add 2008/10/21 T.Niga
    public static final String SESKEY_RQC_VIEWDATA = "RcQtrPaymentCheckReqViewData"; //四半期支払確認依頼一覧制御データ
    public static final String REQKEY_RQC_DATA = "RcQtrPaymentCheckReqData"; //四半期支払確認依頼一覧データ
    //四半期支払確定依頼 add 2008/10/29 A.Umezawa
    public static final String SESKEY_RQD_VIEWDATA = "RcQtrPaymentDecisionViewData"; //四半期支払確定依頼一覧制御データ
    public static final String REQKEY_RQD_DATA = "RcQtrPaymentDecisionData"; //四半期支払確定依頼一覧データ
    //四半期支払承認 add 2008/10/21 T.Niga
    public static final String SESKEY_RQA_VIEWDATA = "RcQtrPaymentApprovalViewData"; //四半期支払承認一覧制御データ
    public static final String REQKEY_RQA_DATA = "RcQtrPaymentApprovalData"; //四半期支払承認一覧データ
    public static final String REQKEY_RQA_DATA_TOTAL = "RcQtrPaymentApprovalTotalData"; //四半期支払承認一覧データ（合計）
    public static final String REQKEY_RQA_DATA_REFER = "RcQtrPaymentApprovalReferData"; //四半期支払承認詳細データ
    //割戻金承認 add 2008/11/07 A.Umezawa
    public static final String SESKEY_RAL_VIEWDATA = "RcRebateApprovalViewData"; //割戻金承認一覧制御データ
    public static final String REQKEY_RAL_DATA = "RcRebateApprovalData"; //割戻金承認一覧データ
    public static final String REQKEY_RAL_DATA_TOTAL = "RcRebateApprovalTotalData"; //割戻金承認一覧データ（合計）
    public static final String REQKEY_RAL_DATA_REFER = "RcRebateApprovalReferData"; //割戻金承認詳細データ
    //分割先割戻金一覧 add 2008/11/07 H.Tomomori
    public static final String SESKEY_RDL_VIEWDATA = "RcRebateDivisionListViewData"; //分割先割戻金一覧制御データ
    public static final String REQKEY_RDL_DATA = "RcRebateDivisionListData"; //分割先割戻金一覧データ
    //四半期支払確認依頼 add 2008/11/08 T.Niga
    public static final String SESKEY_RCR_VIEWDATA = "RcRebateCheckReqViewData"; //割戻金確認依頼一覧制御データ
    public static final String REQKEY_RCR_DATA = "RcRebateCheckReqData"; //割戻金確認依頼一覧データ
    // PDF出力
    public static final String SESKEY_TESTPDF_VIEWDATA = "TestPdfOutputBlobFileViewData"; //PDF出力用
    public static final String REQKEY_TESTPDF_DATA = "TestPdfOutputBlobFileData"; //BLOBファイル操作一覧データ

    //割戻金確認状況一覧 add 2008/11/10 sya
    public static final String SESKEY_RCK_VIEWDATA = "RcRebateCheckViewData"; //割戻金確認状況一覧制御データ
    public static final String REQKEY_RCK_DATA = "RcRebateCheckData"; //割戻金確認状況一覧データ
    public static final String REQKEY_RCK_DATA_TOTAL = "RcRebateCheckTotalData"; //割戻金確認状況一覧データ（合計）
    //割戻金計算資料アップロード add 2008/11/10 T.Nishigaki
    public static final String SESKEY_RCU_REGISTERDATA = "RcRebateCalcDocUploadRegisterData"; //割戻金計算資料アップロード登録データ
    //ワイス社向請求書承認 add 2008/11/12 H.Tomomori
    public static final String SESKEY_RBA_VIEWDATA = "RcBillApprovalViewData"; //ワイス社向請求書承認制御データ
    public static final String REQKEY_RBA_FILEDATA = "RcBillApprovalFileData"; //ワイス社向請求書承認ダウンロードファイルデータ
    public static final String REQKEY_RBA_DATA = "RcBillApprovalData"; //ワイス社向請求書承認データ
    public static final String SESKEY_RBA_REGISTERDATA = "RcBillApprovalRegisterData"; //ワイス社向請求書承認登録データ
    //割戻金計算資料一覧
    public static final String REQKEY_RCL_DATA = "RcRebateCalcDocListData";
    //ワイス社向請求書承認依頼 add 2008/11/18 A.Umezawa
    public static final String SESKEY_RBR_VIEWDATA = "RcBillApprovalReqViewData"; //ワイス社向請求書承認依頼制御データ
    public static final String REQKEY_RBR_FILEDATA = "RcBillApprovalReqFileData"; //ワイス社向請求書承認依頼ダウンロードファイルデータ
    public static final String REQKEY_RBR_DATA = "RcBillApprovalReqData"; //ワイス社向請求書承認依頼データ
    public static final String SESKEY_RBR_REGISTERDATA = "RcBillApprovalReqRegisterData"; //ワイス社向請求書承認依頼登録データ

    public static final String SESKEY_COM_VIEWDATA = "SgComSearchViewData"; // SSG検索一覧制御データ
    // メーカー別売上一覧 add 2008/10/08 H.Tomomori
    public static final String SESKEY_SMU_VIEWDATA = "SgMakerSalesViewData"; // メーカー別売上一覧制御データ
    public static final String REQKEY_SMU_DATA = "SgMakerSalesData"; // メーカー別売上一覧データ

    //主要メーカー別売上詳細 add 2008/10/15 H.Tomomori
    public static final String SESKEY_SMM_REFERDATA = "SgMainMakerSalesReferData"; // 主要メーカー別売上制御データ
    public static final String REQKEY_SMM_DATA = "SgMainMakerSalesTableData"; // 主要メーカー別売上一覧データ

    //主要メーカー別売上登録 add 2008/10/22 H.Tomomori
    public static final String SESKEY_SMM_REGISTERDATA = "SgMainMakerSalesRegisterData"; // 主要メーカー別売上登録データ
    //その他メーカー別売上詳細 add 2008/10/22 Sya
    public static final String SESKEY_SOS_REFERDATA = "SgOtherMakerSalesReferData"; //その他メーカー別売上詳細データ
    public static final String REQKEY_SOS_DATA = "SgOtherMakerSalesTableData"; // その他メーカー別売上一覧データ
    public static final String SESKEY_SOS_REFEINITDATA = "SgOtherMakerSalesReferInitData"; //その他メーカー別売上詳細初期データ

    //その他メーカー別売上詳細 add 2008/10/28 Sya
    public static final String SESKEY_SOS_REGISTERDATA = "SgOtherMakerSalesRegisterData"; //その他メーカー別売上詳細登録データ

    //特約店売上状況把握システムメニュー add 2008/10/15 T.Nishigaki
    public static final String SESKEY_SGM_DATA = "SgMenuData"; //特約店売上状況把握システムメニュー制御データ

    //総売・武田売一覧 add 2008/10/20 T.Nishigaki
    public static final String SESKEY_STT_VIEWDATA = "SgTotalTakedaSalesViewData"; //総売・武田売一覧制御データ
    public static final String REQKEY_STT_DATA = "SgTotalTakedaSalesData"; //総売・武田売一覧データ

    //総売・武田売詳細 add 2008/10/23 T.Nishigaki
    public static final String SESKEY_STT_REFERDATA = "SgTotalTakedaSalesReferData"; //総売・武田売詳細制御データ
    public static final String REQKEY_STT_REFERDATA = "SgTotalTakedaSalesTableData"; //総売・武田売詳細データ
    //総売・武田売 add 2008/10/28 T.Nishigaki
    public static final String SESKEY_STT_REGISTERDATA = "SgTotalTakedaSalesRegisterData"; //総売・武田売登録データ

    //特約店合併指示登録チェック add 2008/11/13 T.Nishigaki
    public static final String SESKEY_SWC_REGISTERCHECKDATA = "SgWsCombIndicateRegisterCheckData"; //特約店合併指示登録チェックデータ
    //特約店合併指示確認 add 2008/11/13 T.Nishigaki
    public static final String SESKEY_SWC_REGISTERDATA = "SgWsCombIndicateRegisterData"; //特約店合併指示確認データ
    //特約店合併指示詳細 add 2008/11/18 T.Nishigaki
    public static final String SESKEY_SWC_REFERDATA = "SgWsCombIndicateReferData"; //特約店合併指示詳細データ

    //SSGメーカーテーブル一覧 add 2008/09/18 T.Shimizu
    public static final String SESKEY_SMT_VIEWDATA = "SgMakerTblViewData"; //SSGメーカーテーブル一覧一覧制御データ
    public static final String REQKEY_SMT_DATA = "SgMakerTblData"; //SSGメーカーテーブル一覧一覧データ

    //帳票出力依頼 add 2008/10/23 T.Shimizu
    public static final String SESKEY_SPQ_VIEWDATA = "SgPdfOutputReqViewData"; //帳票出力依頼一覧制御データ
    public static final String REQKEY_SPQ_DATA = "SgPdfOutputReqData"; //帳票出力依頼一覧データ

    //特約店売上入力状況一覧 add 2008/10/23 T.Shimizu
    public static final String SESKEY_SWS_VIEWDATA = "SgWsSalesInputConditionViewData"; //特約店売上入力状況一覧一覧制御データ
    public static final String REQKEY_SWS_DATA = "SgWsSalesInputConditionData"; //特約店売上入力状況一覧一覧データ

    //特約店合併指示一覧 add 2008/11/19 T.Shimizu
    public static final String SESKEY_SWC_VIEWDATA = "SgWsCombIndicateViewData"; //特約店合併指示一覧一覧制御データ
    public static final String REQKEY_SWC_DATA = "SgWsCombIndicateData"; //特約店合併指示一覧一覧データ
    //SSGメーカーテーブル詳細 add 2008/11/20 sya
    public static final String SESKEY_SMT_REGISTERDATA 	= "SgMakerTblRegisterData";	//SSGメーカーテーブル登録データ
    public static final String SESKEY_SMT_REFERDATA 	= "SgMakerTblReferData"; 		//SSGメーカーテーブル詳細データ
    //********************* 仁賀  の追加領域 終了 担当：仁賀 *********************************************************


    // --------------------- 河本　の追加領域 開始 担当：河本 -----------------------------------------------------
    //JSTR-3品目（メーカー）選択 add 2009/03/02 T.Koumoto
    public static final String SESKEY_JPMC_VIEWDATA = "JstProdMakerCategoriesViewData"; //JSTR-3品目（メーカー）選択一覧制御データ
    public static final String REQKEY_JPMC_DATA = "JstProdMakerCategoriesData"; //JSTR-3品目（メーカー）選択一覧データ
    //JSTR-3薬効市場別・施設（ブリック）別・品目別表 add 2009/03/02 T.Koumoto
    public static final String SESKEY_JIP_VIEWDATA = "JstInsProdViewData"; //JSTR-3施設別・品目別表（金額・シェア）一覧制御データ
    public static final String REQKEY_JIP_DATA = "JstInsProdData"; //JSTR-3施設別・品目別表（金額・シェア）一覧データ
    //医師検索（2008年源泉支払先一覧） add 2009/05/07 T.Oonisi
    public static final String SESKEY_DPA_VIEWDATA = "DmcPayAddressViewData"; //医師検索（2008年源泉支払先一覧）一覧制御データ
    public static final String REQKEY_DPA_DATA = "DmcPayAddressData"; //医師検索（2008年源泉支払先一覧）一覧データ

    // ********************* 河本　の追加領域 終了 担当 : 河本  ****************************************************

    //--------------------- 森田　の追加領域 開始 担当 : 森田  -------------------------------------------
    public static final String SESKEY_NPM_LIST  = "NpmJokenList"  ;	//納入計画JOKEN_SET_CDをリストに
    //********************* 森田　の追加領域 終了 担当 : 森田 ****************************************************

    //--------------------- 森田　の追加領域 開始 担当 : 森田  -------------------------------------------
    public static final String SESKEY_ACR_LIST = "RightJokneSetList"; //代行権限JOKENSETリスト
    //********************* 森田　の追加領域 終了 担当 : 森田 ****************************************************

    // add start 2010/03/19 T.Fukushima 医療関係HPへのリンク画面追加対応
    public static final String REQKEY_MED_RTN_HPLINK_VIEWDATA = "MedRtnHPLinkData";
    // add start 2010/09/10 T.Fukushima NaviBoardページ保持用セッションキー
    public static final String SESKEY_NVB_START_PAGE = "NvbStartPage";
    // add start 2010/09/03 T.Fukushima iPhone対応個人スケジュールセッションキー
    public static final String SESSKEY_BSC_PERSONAL_VIEWDATA = "BscMobileScheduleData";

    //--------------------- 高橋　の追加領域 開始 担当 : 高橋  -------------------------------------------
    //TS結果報告 add 2011/03/29 K.Takahashi
    public static final String SESKEY_TSF_REPORT_VIEWDATA = "TsfReportViewData"; //TS結果報告一覧制御データ
    public static final String REQKEY_TSF_REPORT_DATA = "TsfReportData"; //TS結果報告一覧データ
    public static final String SESKEY_TSF_REPORT_REFERDATA = "TsfReportReferData";
    public static final String REQKEY_TSF_REPORT_ATTACHEDDATA = "TsfReportReferAttachedFileData"; //添付ファイル
    public static final String REQKEY_TSF_REPORT_ADDRESSDDATA = "TsfReportReferAddressFileData"; //宛先データ
    public static final String SESKEY_TSF_FLOWDATA = "TsApprovalFlowData";//承認フォーロー共通データ
    public static final String SESKEY_TSF_REPORT_REGISTERDATA = "TsfReportRegisterData"; //TS結果報告登録データ
    //TS結果報告詳細データ	//
    //TS承認フォロー add 2011/04/07 T.Oonishi
    public static final String SESKEY_TSF_REQUEST_VIEWDATA = "TsfRequestViewData"; //TS承認フォロー一覧制御データ
    public static final String REQKEY_TSF_REQUEST_DATA = "TsfRequestData"; //TS承認フォロー一覧データ
    public static final String SESKEY_TSF_REQUEST_REFERDATA = "TsfRequestReferData"; //TS承認フォロー詳細データ
    public static final String SESKEY_TSF_REQUEST_REGISTERDATA = "TsfRequestRegisterData"; //TS承認フォロー登録データ

    //********************* 高橋　の追加領域 終了 担当 : 高橋 ****************************************************


    //--------------------- 村上　の追加領域 開始 担当 : 村上  -------------------------------------------
    //研究材料選択ポップアップ add 2011/04/07 N.Murakami
    public static final String SESKEY_TSF_VIEWDATA = "TsfMaterialsViewData"; //研究材料選択ポップアップ一覧制御データ
    public static final String REQKEY_TSF_DATA = "TsfMaterialsData"; //研究材料選択ポップアップ一覧データ
    // add start 2012/05/24 N.Murakami J12-0006  トップメニュ_品目別遂行率
    public static final String SESKEY_NNT_VIEWDATA = "NjoNaviTopCompViewData"; //Naviメニュー品目別遂行率画面一覧制御データ
    public static final String REQKEY_NNT_DATA = "NjoNaviTopCompData"; //Naviメニュー品目別遂行率画面一覧データ
    // add end   2012/05/24 N.Murakami J12-0006  トップメニュ_品目別遂行率
    //********************* 村上　の追加領域 終了 担当 : 村上 ****************************************************

    //お知らせ add 2012/05/15 T.Yoshida J12-0006 2012年上期Home&Navi改善対応(Step2+Step1追加要件)
    public static final String SESKEY_OSH_VIEWDATA = "OshiraseViewData"; //お知らせ一覧制御データ
    public static final String REQKEY_OSH_DATA = "OshiraseData"; //お知らせ一覧データ

    //Topメニュー施設検索 add 2012/06/06 I.Oda J12-0006 2012年上期Home&Navi改善対応(Step2+Step1追加要件)
    public static final String SESKEY_IMT_VIEWDATA = "ImtTopMnuSearchViewData"; //Topメニュー施設検索一覧制御データ
    public static final String SESKEY_IMT_DATA = "ImtTopMnuSearchData"; //Topメニュー施設検索一覧データ

    //B12-0088 2012/7/17 uchida add start Topメニュー検索統合
    //--------------------- 内田の追加領域 開始 担当 : 内田  -------------------------------------------
    public static final String SESKEY_MENU_TOPSEARCH_CTRLDATA = "MenuTopSearchCtrlData"; //Topメニュー検索制御データ
    public static final String SESKEY_DMC_VIEWDATA = "DmcTopMnuSearchViewData"; //Topメニュー医師検索一覧制御データ
    public static final String SESKEY_DMC_DATA = "DmcTopMnuSearchData"; //Topメニュー医師検索一覧データ
    //--------------------- 内田の追加領域 終了 担当 : 内田  -------------------------------------------
    //B12-0088 2012/7/17 uchida add end   Topメニュー検索統合

    //ワクチン実績メニュー add 2012/08/06 T.Yoshida B12-0146
    public static final String SESKEY_VMN_VIEWDATA = "VaccineMenuViewData"; //ワクチン実績メニュー一覧制御データ

    //品目選択ポップアップ add 2013/03/07 T.Yoshida J13-0003
    public static final String SESKEY_NJY_CAT_VIEWDATA = "njyDetailProdCategoriesViewData"; //納入状況表・速報用品目選択一覧制御データ
    public static final String REQKEY_NJY_CAT_DATA = "njyDetailProdCategoriesData"; //納入状況表・速報用品目選択一覧データ

    /** 仮従業員登録 */
    public static final String SESKEY_JKR010C010_SEARCHKEY = "JKR010C010_SEARCHKEY";
    /** 担当変更状況設定・確認での検索条件 */
    public static final String SESKEY_JKR020C010_SEARCHKEY = "JKR020C010_SEARCHKEY";
    /** 担当変更状況（新組織）確認 */
    public static final String SESKEY_JKR020C020_SEARCHKEY = "JKR020C020_SEARCHKEY";
    /** 担当引継ぎ */
    public static final String SESKEY_JKR030C010_SEARCHKEY = "JKR030C010_SEARCHKEY";
    /** 担当引継ぎ(エラー) */
    public static final String SESKEY_JKR030C020_SEARCHKEY = "JKR030C020_SEARCHKEY";
    /** 施設・領域別担当変更 */
    public static final String SESKEY_JKR040C010_SEARCHKEY = "JKR040C010_SEARCHKEY";
    /** 施設・特定品目別担当変更 */
    public static final String SESKEY_JKR040C020_SEARCHKEY = "JKR040C020_SEARCHKEY";
    /** 市区郡・領域別担当変更_詳細設計書 */
    public static final String SESKEY_JKR040C030_SEARCHKEY = "JKR040C030_SEARCHKEY";
    /** 施設別・地区別（施設）担当変更エラー一覧 */
    public static final String SESKEY_JKR040C040_SEARCHKEY = "JKR040C040_SEARCHKEY";
    /** 医師・領域別担当変更 */
    public static final String SESKEY_JKR050C010_SEARCHKEY = "JKR050C010_SEARCHKEY";
    /** 所属部科・領域別担当変更 */
    public static final String SESKEY_JKR050C020_SEARCHKEY = "JKR050C020_SEARCHKEY";
    /** 複数担当先施設の医師担当変更エラー一覧 */
    public static final String SESKEY_JKR050C030_SEARCHKEY = "JKR050C030_SEARCHKEY";
    /** 帳票一覧画面での検索条件 */
    public static final String SESKEY_JKR090C010_SEARCHKEY = "JKR090C010_SEARCHKEY";
    /** 施設選択 */
    public static final String SESKEY_JKR100C060_SEARCHKEY = "JKR100C060_SEARCHKEY";
    /** 所属部課選択 */
    public static final String SESKEY_JKR100C070_SEARCHKEY = "JKR100C070_SEARCHKEY";
    /** 組織,従業員,組織従業員での初期結果 */
    public static final String SESKEY_JKR100C010_SEARCHKEY = "JKR100C010_SEARCHKEY";

    /** 所属学会編集ポップアップでの初期結果 */
    public static final String SESKEY_NC206_SEARCHKEY = "NC206_SEARCHKEY";
    /** 公的機関編集ポップアップでの初期結果 */
    public static final String SESKEY_NC207_SEARCHKEY = "NC207_SEARCHKEY";
    /** RDM医師検索 */
    public static final String SESKEY_ND001_SEARCHKEY = "ND001_SEARCHKEY";
    /** 医師新規での初期結果 */
    public static final String SESKEY_ND011_SEARCHKEY = "ND011_SEARCHKEY";
    /** 医師新規確認での初期結果 */
    public static final String SESKEY_ND301_SEARCHKEY = "ND301_SEARCHKEY";
    /** 施設新規での初期結果 */
    public static final String SESKEY_NF011_SEARCHKEY = "NF011_SEARCHKEY";
    /** 施設更新での初期結果 */
    public static final String SESKEY_NF012_SEARCHKEY = "NF012_SEARCHKEY";
    /** 施設削除での初期結果 */
    public static final String SESKEY_NF013_SEARCHKEY = "NF013_SEARCHKEY";
    /** 施設紐付け新規での初期結果 */
    public static final String SESKEY_NF211_SEARCHKEY = "NF211_SEARCHKEY";
    /** 施設紐付け変更での初期結果 */
    public static final String SESKEY_NF212_SEARCHKEY = "NF212_SEARCHKEY";
    /** 施設紐付け削除での初期結果 */
    public static final String SESKEY_NF213_SEARCHKEY = "NF213_SEARCHKEY";
    /** 施設新規 - 申請内容確認での初期結果 */
    public static final String SESKEY_NF301_SEARCHKEY = "NF301_SEARCHKEY";
    /** 施設更新 - 申請内容確認での初期結果 */
    public static final String SESKEY_NF303_SEARCHKEY = "NF303_SEARCHKEY";
    /** 施設紐付け新規 - 申請内容確認での初期結果 */
    public static final String SESKEY_NF311_SEARCHKEY = "NF311_SEARCHKEY";
    /** 施設紐付け変更 - 申請内容確認での初期結果 */
    public static final String SESKEY_NF313_SEARCHKEY = "NF313_SEARCHKEY";
    /** 施設紐付け削除 - 申請内容確認での初期結果 */
    public static final String SESKEY_NF315_SEARCHKEY = "NF315_SEARCHKEY";

    public static final String SESKEY_NC011_SEARCHKEY = "NC011_SEARCHKEY";
    public static final String SESKEY_NC202_SEARCHKEY = "NC202_SEARCHKEY";
    public static final String SESKEY_NC203_SEARCHKEY = "NC203_SEARCHKEY";
    public static final String SESKEY_NC204_SEARCHKEY = "NC204_SEARCHKEY";
    public static final String SESKEY_NC205_SEARCHKEY = "NC205_SEARCHKEY";

    /** １ページで表示されるレコード件数 */
    public static final Integer SHOW_COUNT = 50;

    //JDBCでは、コードはプラス？
    public static final int ORA_DUPLICATE_ERROR = 1;         //でるで
    public static final int ORA_ROWLOCK_ERROR   = 54;        //でるで
    public static final int ORA_NOTNULL_COLUMN_NULL = 1400;  //でるで
    public static final int ORA_VALUE_LARGER_ERROR = 1438;   //でるで
    public static final int SQL_MANY_ROWS = 2112;    //into句で読んだときの話




}
