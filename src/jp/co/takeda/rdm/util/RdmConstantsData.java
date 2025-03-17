package jp.co.takeda.rdm.util;

/**
 * <pre>
 *  従業員関連コンスタントクラス
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author 日立　二神
 */
public class RdmConstantsData {

    /***条件設定 : 適用日設定可能本部権限 */
//    public static final String RDM_JKN_HONBU_COMMIT = "JKN0163";

    /**条件設定 : MDM管理者権限 */
    public static final String RDM_JKN_ADMIN = "JKN0850";

    /**条件設定 : 全MR権限 */
    public static final String RDM_JKN_MR = "JKN0023";

    /**MR権限/管理者権限判定 : MDM管理者権限 */
    public static final String RDM_JKN_ADMIN_FLG = "1";

    /**MR権限/管理者権限判定 : 全MR権限 */
    public static final String RDM_JKN_MR_FLG = "0";

    /**メニュー権限 : 施設一括 */
    public static final String RDM_PARAM_MST_MENU_MN_IKT_FAC = "MN_IKT_FAC";

    /**メニュー権限 : 医師一括 */
    public static final String RDM_PARAM_MST_MENU_MN_IKT_DOC = "MN_IKT_DOC";

    /**メニュー権限 : 来期用項目メニュースイッチ */
    public static final String RDM_PARAM_MST_MENU_MN_NT_FAC = "MN_NT_FAC";

    /**条件設定 : ワクチンG権限 */
    public static final String RDM_JKN_VACCINE = "JKN0161";

    /**条件設定 : 支店権限 */
    public static final String RDM_JKN_SITEN = "JKN0160";

    /**条件設定 : 営業所権限 */
    public static final String RDM_JKN_EIGYOU = "JKN0159";

    /**条件設定 : ＯＮＣＧＭ権限 */
    public static final String RDM_JKN_ONCGM = "JKN0337";

    /**条件設定 : MR権限 */
    //public static final String RDM_JKN_MR = "JKN0164";













    //20180118 HISOL Kawamoto JKR-C-005 MOD START
    //20150127 HISOL Suzuki 期末期首 組織変更対応 ADD START
    ///**条件設定 : ONC営業部スタッフ権限 */
    //public static final String RDM_JKN_ONC = "JKN0349";
    /**条件設定 : 従業員関連・営業部Ｓ権限 */
    public static final String RDM_JKN_ONC = "JKN0501";
    //20150127 HISOL Suzuki 期末期首 組織変更対応 ADD END
    //20180118 HISOL Kawamoto JKR-C-005 MOD END

    //20150618 HISOL Oshita RDM_TOP_DISP_CTRL_組織グループ追加 ADD START
    /**条件設定 : ONC営業部長権限 */
    public static final String RDM_JKN_ONCM = "JKN0372";
    //20150618 HISOL Oshita RDM_TOP_DISP_CTRL_組織グループ追加 ADD END

    /**業務区分 : 本部権限 */
    public static final String BUS_TYPE_HONBU = "1";

    /**業務区分 : 支店権限(代行） */
    public static final String BUS_TYPE_SITEN = "2";

    /**業務区分 : 営業所権限(代行） */
    public static final String BUS_TYPE_EIGYOU = "3";

    /**業務区分 : 施設の担当組織変更 */
    public static final String BUS_TYPE_INS_CHG = "4";

    /**業務区分 : 仮従業員登録確認 */
    public static final String BUS_TYPE_MR_REG = "5";

    /**業務区分 : 変更状況確認 */
    public static final String BUS_TYPE_STS_CNF = "6";

    /**変更状況 : 初期状態 */
    public static final String STS_INITIAL = "00";

    /**変更状況 : 異動情報あり */
    public static final String STS_IDO = "10";

    /**変更状況 : 変更中 */
    public static final String STS_CHANGING = "20";

    /**変更状況 : チェック中 */
    public static final String STS_CHECKING = "30";

    /**変更状況 : チェック完了（エラーなし） */
    public static final String STS_CHK_NOERR = "40";

    /**変更状況 : チェック完了（エラーあり） */
    public static final String STS_CHK_ERR = "41";

    /**変更状況 : 確定 */
    public static final String STS_FIX = "50";

    /**変更状況 : 適用完了（エラーなし） */
    public static final String STS_COMMIT_NOERR = "60";

    /**変更状況 : 適用完了（エラーあり） */
    public static final String STS_COMMIT_ERR = "61";

    /**担当変更背景色 : 担当引継ぎ */
    public static final String COLOR_CHG_BYMR = "#AFEEEE";

    /**担当変更背景色 : 施設別担当変更 */
    public static final String COLOR_CHG_BYINS = "#FFFF66";

    /**担当変更背景色 : 施設別担当追加 */
    public static final String COLOR_ADD_BYINS = "#FFDEAD";

    /**担当変更背景色 : 医師別担当変更 */
    public static final String COLOR_CHG_BYDOC = "#A0FFAA";

    /**従業員基本状況 : 初期状態 */
    public static final String JGI_STS_INITIAL = "00";

    /**従業員基本状況 : 異動情報あり */
    public static final String JGI_STS_IDO = "10";

    /**従業員基本状況 : 承認済み */
    public static final String JGI_STS_APP = "20";

    /**従業員基本状況 : 異動なし */
    public static final String JGI_STS_NOIDO = "21";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_BR_MR_CAT = "br_mr_cat";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_BUS_TYPE = "bus_type";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_CHG_PRES = "chg_pres";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_DIST_MR_CAT = "dist_mr_cat";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_EBR_MR_CAT = "ebr_mr_cat";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_ERR_PRES = "err_pres";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_FIX_TYPE = "fix_type";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_HEAD_DEF_SOS = "head_def_sos";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_HO_INS_TYPE = "ho_ins_type";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_INS_CHG = "ins_chg";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_INS_DEVE = "ins_deve";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_DOC_DEVE = "doc_deve";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_MAIN_MR = "main_mr";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_MK_MR_CAT = "mk_mr_cat";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_MR_CAT = "mr_cat";

    /**汎用マスタデータ区分 :施設表示範囲  */
    public static final String DATA_KBN_INS_DISP_RNG = "ins_disp_rng";

    /**汎用マスタデータ区分 :施設表示範囲  */
    public static final String DATA_KBN_DOC_DISP_RNG = "doc_disp_rng";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_MR_CAT_FORM = "mr_cat_form";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_MR_CAT_SHOKUSHU = "mr_cat_shokushu";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_PHARM_TYPE = "pharm_type";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_VAC_VISIT_TYPE = "vac_visit_type";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_WG_MR_CAT = "wg_mr_cat";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_BG_COLOR_RNK = "bg_color_rnk";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_OPERATION_INS = "operation_ins";

    /**汎用マスタデータ区分 :  */
    public static final String DATA_KBN_OPERATION_DOC = "operation_doc";

    /**従業員関連テーブル名 : 担当引継ぎ情報 */
    public static final String RDM_CHG_BYMR = "RDM_chg_bymr";

    /**従業員関連テーブル名 : 医師別担当変更情報 */
    public static final String RDM_CHG_BYDOC = "RDM_chg_bydoc";

    /**従業員関連テーブル名 : 施設別担当変更情報 */
    public static final String RDM_CHG_BYINS = "RDM_chg_byins";

    /**従業員関連テーブル名 : 施設変更市区郡集約情報 */
    public static final String RDM_CHG_GRAD = "RDM_chg_grad";

    /**従業員関連テーブル名 : 医師変更所属部科集約情報 */
    public static final String RDM_CHG_GRDEPT = "RDM_chg_grdept";

    /**従業員関連テーブル名 : 従業員関連汎用マスタ */
    public static final String RDM_CD_MST  = "RDM_cd_mst ";

    /**従業員関連テーブル名 : MR担当地区情報 */
    public static final String RDM_MR_ADDR = "RDM_mr_addr";

    /**従業員関連テーブル名 : MR施設(従業員関連) */
    public static final String RDM_MR_INS = "RDM_mr_ins";

    /**従業員関連テーブル名 : MR施設医師(従業員関連) */
    public static final String RDM_MR_INS_DOC = "RDM_mr_ins_doc";

    /**従業員関連テーブル名 : 従業員関連MSGマスタ */
    public static final String RDM_MSG_MST = "RDM_msg_mst";

    /**従業員関連テーブル名 : 従業員関連PDFデータ */
    public static final String RDM_PDF_DATA = "RDM_pdf_data";

    /**従業員関連テーブル名 : 組織担当地区情報 */
    public static final String RDM_SOS_ADDR = "RDM_sos_addr";

    /**従業員関連テーブル名 : 専門MR営MR組織関連 */
    public static final String RDM_SOS_REL = "RDM_sos_rel";

    /**従業員関連テーブル名 : 担当変更状況 */
    public static final String RDM_SOS_STS = "RDM_sos_sts";

    /**従業員関連テーブル名 : MR所属組織 */
    public static final String COM_MR_SOS = "com_mr_sos";

    /**従業員関連テーブル名 : 従業員基本(所属情報)1確定 */
    public static final String M_JGI_SOS_FIX = "m_jgi_sos_fix";

    /**従業員関連テーブル名 : 従業員基本(所属情報)予定 */
    public static final String M_JGI_SOS_PLAN = "m_jgi_sos_plan";

    /**従業員関連テーブル名 : 担当変更エラー件数 */
    public static final String RDM_CHG_ERRCNT = "RDM_chg_errcnt";

    /**従業員関連パッケージ・プロシージャ名 : 担当引継ぎ作成プロシージャ名 */
    public static final String PROCEDURE_MAKE_CHG_BYMR = "RDM_common.make_chg_bymr";

    /**従業員関連パッケージ・プロシージャ名 : 施設武田市区郡集約作成プロシージャ名 */
    public static final String PROCEDURE_MAKE_CHG_GRAD = "RDM_common.make_chg_grad";

    /**従業員関連パッケージ・プロシージャ名 : 医師所属部科集約作成プロシージャ名 */
    public static final String PROCEDURE_MAKE_CHG_GRADEPT = "RDM_common.make_chg_grdept";

    /**従業員関連パッケージ・プロシージャ名 : 仮従業員登録　MR連番最大値取得プロシージャ名 */
    public static final String PROCEDURE_GET_MAX_KNO = "RDM_common.get_max_kno";

    /**MR種類コード : 営MRコード */
    public static final String RDM_MRCAT_EIGYOU = "01";

    /**MR種類コード : CVMコード */
    public static final String RDM_MRCAT_CVM = "08";

    /**MR種類コード : RSコード */
    public static final String RDM_MRCAT_RS = "09";

    /**MR種類コード : ワクチンMRコード */
    public static final String RDM_MRCAT_VAC = "02";

    /**MR種類コード : EMRコード */
    public static final String RDM_MRCAT_EMR = "04";

    /**MR種類コード : LMRコード */
    public static final String RDM_MRCAT_LMR = "05";

    /**MR種類コード : SCコード */
    public static final String RDM_MRCAT_SC = "06";

    /**MR種類コード : 整形MR */
    public static final String RDM_MRCAT_SEIKEI = "07";

    /**状況 : 変更中 */
    public static final String RDM_STATUS_CHANGE = "20";

    /**退避値 : String型 */
    public static final String RDM_ESCAPE_STR = "9999999";

    /**退避値 : int型 */
    public static final int RDM_ESCAPE_INT = 9999999;

    /**String型 */
    public static final String RDM_KONMA = ",";

    /**String型 */
    public static final String RDM_RN = "\r\n";

    /**従業員関連パッケージ・プロシージャ名 : 担当変更状況(新組織) */
    public static final String PROCEDURE_UPDATE_TOSOS_STS = "RDM_common.update_tosos_sts";

    /**従業員関連パッケージ・プロシージャ名 : 解除ボタン押下時の担当変更状況(新組織) */
    public static final String PROCEDURE_UPDATE_TOSOS_STS_REMOVE = "RDM_common.update_tosos_sts_remove";

    /**従業員関連パッケージ名 : 登録ボタン押下時(担当引継ぎ・施設別担当変更・医師別担当変更) */
    public static final String RDM_CHECK = "RDM_check.proc_main";

    public static final String RDM_CHECK_TOSOS = "RDM_check.proc_main_tosos";

    /***2014年4月医薬組織変更・期末期首対応（従業員関連）*/
    public static final String RDM_CHG_ATSET = "RDM_chg_atset.mkat_mrcyi";

    /**領域グループコード : 営業所（ＯＮＣＧ) */
    public static final String TRT_GRP_CD_001 = "001";
    /**領域グループコード : ＲＰＬ */
    public static final String TRT_GRP_CD_002 = "002";
    /**領域グループコード : ワクチン */
    public static final String TRT_GRP_CD_003 = "003";
    //20150127 HISOL Suzuki 期末期首 組織変更対応 ADD START
    /**領域グループコード : ＯＮＣ */
    public static final String TRT_GRP_CD_004 = "004";
    //20150127 HISOL Suzuki 期末期首 組織変更対応 ADD END


    /**領域グループ名称 : 営業所（ＯＮＣＧ) */
    public static final String TRT_GRP_NM_001 = "営業所領域グループ";
    /**領域グループ名称 : ＲＰＬ */
    public static final String TRT_GRP_NM_002 = "支店領域グループ";

    /** 担当変更システムトップメニュー[リスト作成依頼]ボタン押下 : ブラウザタイトル */
    public static final String RDM000C010_BROWER_TITLE = "施設・医師担当変更";
    /** 担当変更システムトップメニュー[リスト作成依頼]ボタン押下 : タイトル */
    public static final String RDM000C010_TITLE = "リスト作成依頼";
    /** 担当変更システムトップメニュー[リスト作成依頼]ボタン押下 : ボタン名称 */
    public static final String RDM000C010_BUTTON_NM = "戻る";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String RDM000C010_REPORT2_NM = "Ｐ担当者別市区郡軒数";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String RDM000C010_REPORT5_NM = "担当者別重点先施設一覧";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String RDM000C010_REPORT6_NM = "担当者別市区郡軒数";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String RDM000C010_REPORT3_NM = "複数担当先所属部科別担当者別医師数";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String RDM000C010_REPORT41_NM = "担当状況総括表";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String RDM000C010_REPORT42_NM = "（ワクチン）";


    /** 担当変更システムトップメニュー[リスト作成依頼]ボタン押下 : 戻るためのDTOセッション格納キー */
    public static final String RDM000C010_RETURN_DTO_KEY = "RDM000C010_RETURN_DTO_KEY";



    /** 担当変更システムトップメニュー[リスト作成依頼]ボタン押下 : ブラウザタイトル */
    public static final String JKR000C010_BROWER_TITLE = "施設・医師担当変更";
    /** 担当変更システムトップメニュー[リスト作成依頼]ボタン押下 : タイトル */
    public static final String JKR000C010_TITLE = "リスト作成依頼";
    /** 担当変更システムトップメニュー[リスト作成依頼]ボタン押下 : ボタン名称 */
    public static final String JKR000C010_BUTTON_NM = "戻る";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String JKR000C010_REPORT2_NM = "Ｐ担当者別市区郡軒数";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String JKR000C010_REPORT5_NM = "担当者別重点先施設一覧";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String JKR000C010_REPORT6_NM = "担当者別市区郡軒数";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String JKR000C010_REPORT3_NM = "複数担当先所属部科別担当者別医師数";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String JKR000C010_REPORT41_NM = "担当状況総括表";
    /** 担当変更システムトップメニュー:帳票名称 */
    public static final String JKR000C010_REPORT42_NM = "（ワクチン）";

    // 2020.04.22 fsz ADD_START
    /** jrxmlファイル格納場所 */
    public static final String XML_FILE_AREA = "/oracle/jasper/";

    /** jrxmlファイル名称 */
    public static final String JKR000_R010 = "JKR000-R010";
    public static final String JKR000_R020 = "JKR000-R020";
    public static final String JKR000_R030 = "JKR000-R030";
    public static final String JKR000_R040 = "JKR000-R040";
    public static final String JKR000_R050 = "JKR000-R050";
    public static final String JKR000_R060 = "JKR000-R060";

    /** pemファイル格納場所 */
    public static final String PEM_FILE_AREA = "/oracle/jasper/public.pem";
    /** コード：X509 */
    public static final String TYPE_X509 = "X509";
    /** 10分 */
    public static final int TEN_MINUTES = 10;
    /** JWT発行者 */
    public static final String CTSTAKEDA = "CTSTAKEDA";
    // 2020.04.22 fsz ADD_END


    /**メッセージＩＤエリア開始 */


    public static final String W0122748 = "W0122748";

    public static final String W0122749 = "W0122749";

    public static final String W0122750 = "W0122750";

    public static final String W0122763 = "W0122763";

    public static final String W0122764 = "W0122764";

    public static final String I0122723 = "I0122723";

    public static final String I0122724 = "I0122724";

    public static final String I0122701 = "I0122701";

    public static final String I0122702 = "I0122702";

    public static final String I0122703 = "I0122703";

    public static final String I0122717 = "I0122717";

    public static final String I0122704 = "I0122704";

    public static final String I0122705 = "I0122705";

    public static final String I0122709 = "I0122709";

    public static final String I0122710 = "I0122710";

    public static final String I0122726 = "I0122726";

    public static final String I0122727 = "I0122727";

    public static final String M0122717 = "M0122717";

    public static final String M0122727 = "M0122727";

    public static final String I0122736 = "I0122736";

    public static final String I0122737 = "I0122737";

    public static final String I0122738 = "I0122738";

    public static final String M0001101 = "M0001101";

    public static final String M0001102 = "M0001102";

    public static final String M0122737 = "M0122737";

    public static final String M0122740 = "M0122740";

    public static final String I0122740 = "I0122740";

    public static final String I0122707 = "I0122707";

    public static final String I0122708 = "I0122708";

    public static final String I0122728 = "I0122728";

    public static final String I0122729 = "I0122729";

    public static final String I0122730 = "I0122730";

    public static final String I0122731 = "I0122731";

    public static final String I0122706 = "I0122706";

    /**メッセージＩＤエリア終了 */

    /**画面ＩＤエリア開始 */
    public static final String SCREEN_ID_RDM000C010 = "RDM000C010";
    public static final String SCREEN_ID_NC001 = "NC001";
    public static final String SCREEN_ID_NC101 = "NC101";
    public static final String SCREEN_ID_NC202_2 = "NC202_2";
    /**画面ＩＤエリア終了 */

    /**登録完了画面フラグ */
    public static final String NC101_FINISH_FLG = "NC101Finish";

    /**登録完了画面値 */
    public static final String NC101_FINISH_VALUE = "1";

    /**部門ランク */
    public enum BumonRank {
        全社(1), 支店(2), 営業所(3), チーム(4);
        private int value;
        private BumonRank(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    /**コード情報コード名 : 医師／薬剤師区分 */
    public static final String CODE_NAME_DOC_TYPE = "DOC_TYPE";
    /**コード情報コード名 : 施設分類 */
    public static final String CODE_NAME_INS_CLASS = "INS_CLASS";
    /**コード情報コード名 : 施設種別 */
    public static final String CODE_NAME_INS_TYPE = "INS_TYPE";
    /**コード情報コード名 : 取引区分 */
    public static final String CODE_NAME_TRADE_TYPE = "TRADE_TYPE";
    /**コード情報コード名 : 卸色区分 */
    public static final String CODE_NAME_WS_TYPE = "WS_TYPE";
    /**コード情報コード名 : 本部一括購入 */
    public static final String CODE_NAME_BASKET_PURCHASE = "BASKET_PURCHASE";
    /**コード情報コード名 : 大学細分類 */
    public static final String CODE_NAME_UNIV_SUBDIV = "UNIV_SUBDIV";
    /**コード情報コード名 : 容量別実績把握病院区分 */
    public static final String CODE_NAME_CAPA_TYPE = "CAPA_TYPE";
    /**コード情報コード名 : 老人福祉法関連分類情報 */
    public static final String CODE_NAME_WELFARE_LIST = "WELFARE_LIST";
    /**コード情報コード名 : 実績把握区分情報 */
    public static final String CODE_NAME_RESULT_LIST = "RESULT_LIST";
    /**コード情報コード名 : 病院設備情報 */
    public static final String CODE_NAME_EQUIP_LIST = "EQUIP_LIST";
    /**コード情報コード名 : Ｔ先 */
    public static final String CODE_NAME_MARKET01 = "MARKET01";
    /**コード情報コード名 : 市場規模情報 */
    public static final String CODE_NAME_MARKET_LIST = "MARKET_LIST";
    /**コード情報コード名 : 医療法関連分類情報 */
    public static final String CODE_NAME_MEDICAL_LIST = "MEDICAL_LIST";
    /**コード情報コード名 : 特別な機能情報 */
    public static final String CODE_NAME_SPFUNC_LIST = "SPFUNC_LIST";
    /**コード情報コード名 : 救命救急センター */
    public static final String CODE_NAME_SPFUNC03 = "SPFUNC03";
    /**コード情報コード名 : 医療連携関係情報 */
    public static final String CODE_NAME_TIEUP_LIST = "TIEUP_LIST";
    /**コード情報コード名 : ユーザーコード */
    public static final String CODE_NAME_USERCD_LIST = "USERCD_LIST";
    /**コード情報コード名 :　診療報酬情報 */
    public static final String CODE_NAME_REWARD_LIST = "REWARD_LIST";
    /**コード情報コード名 :　短期滞在手術基本料 */
    public static final String CODE_NAME_REWARD21 = "REWARD21";
    /**コード情報コード名 :　看護配置（有床診療所） */
    public static final String CODE_NAME_REWARD27 = "REWARD27";
    /**コード情報コード名 :　老人入院基本料 */
    public static final String CODE_NAME_REWARD29 = "REWARD29";
    /**コード情報コード名 : 対象区分 */
    public static final String CODE_NAME_HO_INS_TYPE = "HO_INS_TYPE";
    /**コード情報コード名 : ワクチン対象区分 */
    public static final String CODE_NAME_VAC_INS_TYPE = "VAC_INS_TYPE";
    /**コード情報コード名 : ワクチン定訪先区分 */
    public static final String CODE_NAME_VAC_VISIT_TYPE = "VAC_VISIT_TYPE";
    /**コード情報コード名 : 性別 */
    public static final String CODE_NAME_MF = "MF";
    /**コード情報コード名 : 出身地 */
    public static final String CODE_NAME_HOME_TOWN = "HOME_TOWN";
    /**コード情報コード名 : 勤務形態 */
    public static final String CODE_NAME_JOB_FORM = "JOB_FORM";
    /**コード情報コード名 : 薬審メンバー区分 */
    public static final String CODE_NAME_DCC = "DCC";
    /**コード情報コード名 : 所属役職 */
    public static final String CODE_NAME_POSITION_CODE = "POSITION_CODE";
    /**コード情報コード名 : 分類区分 */
    public static final String CODE_NAME_CLASS_CATEGORY = "CLASS_CATEGORY";
    /**コード情報コード名 : 削除区分 */
    public static final String CODE_NAME_DEL_KBN = "DEL_KBN";
    /**コード情報コード名 : 削除フラグ */
    public static final String CODE_NAME_DEL_FLG = "DEL_FLG";
    /**コード情報コード名 : 施設区分 */
    public static final String CODE_NAME_PHARM_TYPE = "PHARM_TYPE";
    /**コード情報コード名 : 復活理由 */
    public static final String CODE_NAME_HCO_RST_REASON = "HCO_RST_REASON";
    /**コード情報コード名 : 削除理由 */
    public static final String CODE_NAME_HCO_DEL_REASON = "HCO_DEL_REASON";
    /**コード情報コード名 : 医師復活理由 */
    public static final String CODE_NAME_HCP_RST_REASON = "HCP_RST_REASON";
    /**コード情報コード名 : 医師削除理由 */
    public static final String CODE_NAME_HCP_DEL_REASON = "HCP_DEL_REASON";
    /**コード情報コード名 : 医師属性*/
    public static final String CODE_NAME_DOC_ATTRIBUTE = "DOC_ATTRIBUTE";

    /**コード情報コード値１ : 異動先施設不明用ダミー施設 */
    public static final String CODE_VALUE_DUMMY_HCO_9 = "959000000";
    public static final String CODE_VALUENM_DUMMY_HCO_9 = "異動先施設不明";
    /**コード情報コード値１ : 異動先施設不明用未登録所属部科 */
    public static final String CODE_VALUE_DUMMY_DEPT_CODE = "9999";
    /** 大学判定用 **/
    public static final String HCO_HO_INS_TYPE_1 = "1";
    public static final String HCO_INS_CLASS_01 = "01";

    /**パラメタ情報パラメタ名 : 医師メニュースイッチ */
    public static final String PARAM_NAME_MN_DOC = "MN_DOC";
    /**パラメタ情報パラメタ名 : 医師勤務先メニュースイッチ */
    public static final String PARAM_NAME_MN_KMU = "MN_KMU";
    /**パラメタ情報パラメタ名 : 検索時の上限件数 */
    public static final String PARAM_NAME_MAX_ROWNUM = "MAX_ROWNUM";
    /**パラメタ情報パラメタ名 : 1画面内の表示件数　デフォルト値 */
    public static final String PARAM_NAME_PAGE_ROWNUM = "PAGE_ROWNUM";
    /**パラメタ情報パラメタ名 : 1画面内の表示件数　所属部科選択ポップアップ */
    public static final String PARAM_NAME_NC204_ROWNUM = "NC204_ROWNUM";
    /**パラメタ情報パラメタ名 : 1画面内の表示件数　医師検索ポップアップ */
    public static final String PARAM_NAME_NC209_ROWNUM = "NC209_ROWNUM";

    /** MDMシステムトップメニューボタン押下 : 戻るためのDTOセッション格納キー */
    public static final String NC001_RETURN_DTO_KEY = "NC001_RETURN_DTO_KEY";

    /** メッセージコード */
    public static final String E001 = "E001"; // 画面遷移で問題がありました。もう一度メニューから操作をやり直して下さい。
    public static final String E002 = "E002"; // 利用時間外です。利用時間内に利用してください。
    public static final String E003 = "E003"; // 既に他のユーザーによってデータが処理されています。
    public static final String E004 = "E004"; // システムエラーが発生しました。もう一度メニューから操作をやり直して下さい。
    public static final String E005 = "E005"; // 重複登録を検知しました。
    public static final String E006 = "E006"; // 重複申請を検知しました。
    public static final String E007 = "E007"; // ULT接続保留が発生しました。
    public static final String E008 = "E008"; // FB回答で重複を検知しました。
    public static final String E009 = "E009"; // FB回答で問題を検知しました。
    public static final String E010 = "E010"; // 想定外のFB回答を検知しました。
    public static final String E011 = "E011"; // 親子整合性の問題を検知しました。
    public static final String E012 = "E012"; // グルーピング整合性の問題を検知しました。
    public static final String E013 = "E013"; // 実績整合性の問題を検知しました。
    public static final String E014 = "E014"; // データ整合性の問題を検知しました。
    public static final String E015 = "E015"; // 担当外の申請を検知しました。
    public static final String E016 = "E016"; // 長期承認待ちの申請を検知しました。
    public static final String E017 = "E017"; // 管轄外の申請を検知しました。
    public static final String E018 = "E018"; // MDM保留しました。
    public static final String I001 = "I001"; // 該当データがありません。
    public static final String I002 = "I002"; // 申請が完了しました。
    public static final String I003 = "I003"; // 承認が完了しました。
    public static final String I004 = "I004"; // 却下が完了しました。
    public static final String I005 = "I005"; // 保存が完了しました。
    public static final String I006 = "I006"; // （遷移元）画面へ戻ります。よろしいですか？（入力内容は破棄されます）
    public static final String I007 = "I007"; // 申請データを破棄します。よろしいですか？
    public static final String I008 = "I008"; // ステータスを審査済みに変更しました。
    public static final String I009 = "I009"; // 申請データを却下します。よろしいですか？
    public static final String I010 = "I010"; // 廃業・死亡の申請がされています。よろしいですか？
    public static final String I011 = "I011"; // 勤務先追加の申請がされています。よろしいですか？
    public static final String I012 = "I012"; // 申請データを承認します。よろしいですか？
    public static final String W001 = "W001"; // 検索条件を入力してください。
    public static final String W002 = "W002"; // 検索結果が表示上限を超えています。検索条件を絞って再検索してください。
    public static final String W003 = "W003"; // 終了日は開始日以降を選択してください。
    public static final String W004 = "W004"; // 必須項目にデータを入力してください。（項目名）
    public static final String W005 = "W005"; // 申請理由がその他の場合、申請コメントを入力してください。
    public static final String W006 = "W006"; // 適用日は営業日を指定してください。
    public static final String W007 = "W007"; // 適用日は翌営業日以降を指定してください。
    public static final String W008 = "W008"; // 重複する申請が行われています。（項目名）
    public static final String W009 = "W009"; // 最大文字数を超えています。（項目名）
    public static final String W010 = "W010"; // 所属医師、または、申請中の医師が存在します。
    public static final String W011 = "W011"; // 登録されている施設固定コードを入力してください。
    public static final String W012 = "W012"; // 「施設に既存の部科」「所属部科」のどちらかだけ入力してください。
    public static final String W013 = "W013"; // 入力文字種が不正です。（項目名）
    public static final String W014 = "W014"; // 半角で入力してください。（項目名）
    public static final String W015 = "W015"; // 全角で入力してください。（項目名）
    public static final String W016 = "W016"; // 正しい書式で入力してください。（項目名）
    public static final String W017 = "W017"; // 医療モールを新規作成する場合は「00-0000-0000」と入力してください。電話番号(代表)
    public static final String W018 = "W018"; // 入力可能範囲外です。（項目名）
    public static final String W019 = "W019"; // 既に削除済み、または削除申請されている施設です。（項目名）
    public static final String W020 = "W020"; // 接続対象のULT施設が削除されています。
    public static final String W021 = "W021"; // 申請する領域が重複しています。
    public static final String W022 = "W022"; // 有効な年月日を入力してください。（項目名）
    public static final String W023 = "W023"; // 階級区分の範囲とベッド数計が一致するよう入力して下さい。
    public static final String W024 = "W024"; // 親施設に医療モールを選択してください。
    public static final String W025 = "W025"; // 年月日、または年月を入力してください。（項目名）
    public static final String W026 = "W026"; // 却下の場合はコメントを入力してください。
    public static final String W027 = "W027"; // 所属部科を選択する場合は施設も選択してください。
    public static final String W028 = "W028"; // 下記のいずれかが登録してください。- 生年月日(年月日のすべて指定)- 出身校- 卒年
    public static final String W029 = "W029"; // 医師／薬剤師区分に医師を設定する場合は役職を指定してください。
    public static final String W030 = "W030"; // 勤務先が0件になるため申請できません。
    public static final String W031 = "W031"; // 勤務先が大学附属病院の場合、大学職位を入力してください。
    public static final String W032 = "W032"; // 既に勤務先が異動申請されているため申請できません。
    public static final String W033 = "W033"; // 担当可能な地域の郵便番号を選択してください。
    public static final String W034 = "W034"; // 領域に対して担当者は1名のみ設定してください。
    public static final String W035 = "W035"; // 子施設が存在します。
    public static final String W036 = "W036"; // 過去実績が存在します。
    public static final String W037 = "W037"; // 通常勤務先施設数が2以上のため申請できません。
    public static final String W038 = "W038"; // 医師免許返納・死亡の申請されているため申請できません。
    public static final String W039 = "W039"; // 医療機関以外の施設から医療機関以外の施設への申請はできません。
    public static final String W040 = "W040"; // 廃業・死亡状態で、申請できません。
    public static final String W041 = "W041"; // 申請中の施設が存在しているため申請できません。
    public static final String W042 = "W042"; // 既に勤務先情報が更新されているため申請できません。
    public static final String W043 = "W043"; // 医師免許返納・死亡の申請されているため申請できません。（施設名）（医師名）
    public static final String W044 = "W044"; // 医師勤務先の異動、削除申請がされているため申請できません。（施設名）（医師名）
    public static final String W045 = "W045"; // 勤務先情報が変更されていません。
    public static final String W046 = "W046"; // 承認する施設が未選択です。
    public static final String W047 = "W047"; // 同一名称の所属学会が設定されています。所属学会の編集で名称を変更するか、戻るボタンで本画面を閉じてから再度申請を行ってください。
    public static final String W048 = "W048"; // 同一の公的機関が設定されています。公的機関の編集で公的機関を変更するか、戻るボタンで本画面を閉じてから再度申請を行ってください。
    public static final String W049 = "W049"; // 医師の勤務先がすべて自動で削除されます。よろしいですか？
    public static final String W050 = "W050"; // 親施設の追加申請ができない状態です。
    public static final String W051 = "W051"; // 親施設の変更申請ができない状態です。
    public static final String W052 = "W052"; // 親施設の削除申請ができない状態です。
    public static final String W053 = "W053"; // 既に削除申請されている施設です。
    public static final String W054 = "W054"; // エリア階層の組織を選択してください。
    public static final String W055 = "W055"; // 医師情報の更新申請ができない状態です。
    public static final String W056 = "W056"; // 勤務先が2件以上存在するため申請できません。
    public static final String W057 = "W057"; // 医療機関外へ異動されている医師は削除できません。
    public static final String W058 = "W058"; // 医師は異動が予定されています。
    public static final String W059 = "W059"; // 同一の施設が重複先に指定されています。
}
