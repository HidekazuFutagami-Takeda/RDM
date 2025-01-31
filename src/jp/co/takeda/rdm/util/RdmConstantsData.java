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
    public static final String RDM_JKN_HONBU_COMMIT = "JKN0163";

	//TODO 二神　JKN0163を正しく設定する
    /**条件設定 : MDM管理者権限 */
	//TODO二神　MDM管理者：JKN0813  全MR：JKN0023
    public static final String RDM_JKN_ADMIN = "JKN0163";

    /**条件設定 : 全MR権限 */
    public static final String RDM_JKN_MR = "JKN0023";

    /**MR権限/管理者権限判定 : MDM管理者権限 */
    public static final String RDM_JKN_ADMIN_FLG = "0";

    /**MR権限/管理者権限判定 : 全MR権限 */
    public static final String RDM_JKN_MR_FLG = "1";

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
    public static final String RDM_JKN_MR = "JKN0164";













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
    /**コード情報コード名 : 老人短期入所施設 */
    public static final String CODE_NAME_WELFARE02 = "WELFARE02";
    /**コード情報コード名 : その他(老人福祉法関連分類情報) */
    public static final String CODE_NAME_WELFARE08 = "WELFARE08";
    /**コード情報コード名 : En-T ARB ('18.11) */
    public static final String CODE_NAME_RESULT01 = "RESULT01";
    /**コード情報コード名 : En-T DPP4 ('18.11) */
    public static final String CODE_NAME_RESULT02 = "RESULT02";
    /**コード情報コード名 : En-T ω3 ('18.11) */
    public static final String CODE_NAME_RESULT03 = "RESULT03";
    /**コード情報コード名 : En-T PPI ('18.11) */
    public static final String CODE_NAME_RESULT04 = "RESULT04";
    /**コード情報コード名 : En-T 睡眠 ('18.11) */
    public static final String CODE_NAME_RESULT05 = "RESULT05";
    /**コード情報コード名 : En-T アルツハイマー ('18.11) */
    public static final String CODE_NAME_RESULT06 = "RESULT06";
    /**コード情報コード名 : En-T 骨粗鬆症 ('18.11) */
    public static final String CODE_NAME_RESULT07 = "RESULT07";
    /**コード情報コード名 : REMターゲット */
    public static final String CODE_NAME_RESULT08 = "RESULT08";
    /**コード情報コード名 : BLP未獲得市場区分 */
    public static final String CODE_NAME_RESULT09 = "RESULT09";
    /**コード情報コード名 : 整形育成先 */
    public static final String CODE_NAME_RESULT10 = "RESULT10";
    /**コード情報コード名 : TKP・MSコールUP */
    public static final String CODE_NAME_RESULT11 = "RESULT11";
    /**コード情報コード名 : ALC Core1・2('19.10) */
    public static final String CODE_NAME_RESULT12 = "RESULT12";
    /**コード情報コード名 : ENT Tier1-4('19.4) */
    public static final String CODE_NAME_RESULT13 = "RESULT13";
    /**コード情報コード名 : JIA厚労省施設 */
    public static final String CODE_NAME_RESULT14 = "RESULT14";
    /**コード情報コード名 : 注力先('18.12) */
    public static final String CODE_NAME_RESULT15 = "RESULT15";
    /**コード情報コード名 : ENBターゲット先('19.4) */
    public static final String CODE_NAME_RESULT16 = "RESULT16";
    /**コード情報コード名 : 骨G */
    public static final String CODE_NAME_RESULT17 = "RESULT17";
    /**コード情報コード名 : ナテグリニド繁用先 */
    public static final String CODE_NAME_RESULT18 = "RESULT18";
    /**コード情報コード名 : GLUターゲット先 */
    public static final String CODE_NAME_RESULT19 = "RESULT19";
    /**コード情報コード名 : 骨G2 */
    public static final String CODE_NAME_RESULT20 = "RESULT20";
    /**コード情報コード名 : （Ｕ：未使用） */
    public static final String CODE_NAME_RESULT21 = "RESULT21";
    /**コード情報コード名 : ＤＯＩＴ３ */
    public static final String CODE_NAME_RESULT22 = "RESULT22";
    /**コード情報コード名 : ＰＣＩ３００ */
    public static final String CODE_NAME_RESULT23 = "RESULT23";
    /**コード情報コード名 : ＪＤＥｓＡＲＴ */
    public static final String CODE_NAME_RESULT24 = "RESULT24";
    /**コード情報コード名 : （Ｙ：未使用） */
    public static final String CODE_NAME_RESULT25 = "RESULT25";
    /**コード情報コード名 : ＴＡＰ先 */
    public static final String CODE_NAME_RESULT26 = "RESULT26";
    /**コード情報コード名 : ＱＯＬ２００５ＴＫＰ */
    public static final String CODE_NAME_RESULT27 = "RESULT27";
    /**コード情報コード名 : ＴＫＰ未獲得市場区分 */
    public static final String CODE_NAME_RESULT28 = "RESULT28";
    /**コード情報コード名 : ＡＣＴ未獲得市場区分 */
    public static final String CODE_NAME_RESULT29 = "RESULT29";
    /**コード情報コード名 : （４：未使用） */
    public static final String CODE_NAME_RESULT30 = "RESULT30";
    /**コード情報コード名 : 旧ＬＭＲ */
    public static final String CODE_NAME_RESULT31 = "RESULT31";
    /**コード情報コード名 : （６：未使用） */
    public static final String CODE_NAME_RESULT32 = "RESULT32";
    /**コード情報コード名 : ＬＥＵ乳癌 */
    public static final String CODE_NAME_RESULT33 = "RESULT33";
    /**コード情報コード名 : ＯＮＣ担当区分 */
    public static final String CODE_NAME_RESULT34 = "RESULT34";
    /**コード情報コード名 : ＲＰＬ（ＣＶＭ）担当区分 */
    public static final String CODE_NAME_RESULT35 = "RESULT35";
    /**コード情報コード名 : （１０：未使用） */
    public static final String CODE_NAME_RESULT36 = "RESULT36";
    /**コード情報コード名 : 内視鏡 */
    public static final String CODE_NAME_EQUIP01 = "EQUIP01";
    /**コード情報コード名 : 骨量測定器 */
    public static final String CODE_NAME_EQUIP02 = "EQUIP02";
    /**コード情報コード名 : ICD */
    public static final String CODE_NAME_EQUIP03 = "EQUIP03";
    /**コード情報コード名 : CCU */
    public static final String CODE_NAME_EQUIP07 = "EQUIP07";
    /**コード情報コード名 : NCU */
    public static final String CODE_NAME_EQUIP09 = "EQUIP09";
    /**コード情報コード名 : Ｔ先 */
    public static final String CODE_NAME_MARKET01 = "MARKET01";
    /**コード情報コード名 : 酸抑制剤 */
    public static final String CODE_NAME_MARKET02 = "MARKET02";
    /**コード情報コード名 : 高脂血症 */
    public static final String CODE_NAME_MARKET03 = "MARKET03";
    /**コード情報コード名 : 高血圧 */
    public static final String CODE_NAME_MARKET04 = "MARKET04";
    /**コード情報コード名 : 糖尿病 */
    public static final String CODE_NAME_MARKET06 = "MARKET06";
    /**コード情報コード名 : 骨粗鬆症 */
    public static final String CODE_NAME_MARKET07 = "MARKET07";
    /**コード情報コード名 : CVMターゲット */
    public static final String CODE_NAME_MARKET09 = "MARKET09";
    /**コード情報コード名 : 社会医療法人 */
    public static final String CODE_NAME_MEDICAL12 = "MEDICAL12";
    /**コード情報コード名 : 入院包括化実施病院 */
    public static final String CODE_NAME_SPFUNC01 = "SPFUNC01";
    /**コード情報コード名 : 救命救急センター */
    public static final String CODE_NAME_SPFUNC03 = "SPFUNC03";
    /**コード情報コード名 : 大学院大学 */
    public static final String CODE_NAME_SPFUNC04 = "SPFUNC04";
    /**コード情報コード名 : がん連携パス */
    public static final String CODE_NAME_TIEUP10 = "TIEUP10";
    /**コード情報コード名 : 心疾患連携パス */
    public static final String CODE_NAME_TIEUP11 = "TIEUP11";
    /**コード情報コード名 : 糖尿病連携パス */
    public static final String CODE_NAME_TIEUP12 = "TIEUP12";
    /**コード情報コード名 : （Ａ：未使用） */
    public static final String CODE_NAME_USERCD0001 = "USERCD0001";
    /**コード情報コード名 : ＶＣＴ・Ｖ先 */
    public static final String CODE_NAME_USERCD0002 = "USERCD0002";
    /**コード情報コード名 : （Ｃ：未使用） */
    public static final String CODE_NAME_USERCD0003 = "USERCD0003";
    /**コード情報コード名 : NEXアーリーアダプタ */
    public static final String CODE_NAME_USERCD0004 = "USERCD0004";
    /**コード情報コード名 : （Ｅ：未使用） */
    public static final String CODE_NAME_USERCD0005 = "USERCD0005";
    /**コード情報コード名 : テルモ・コプロ */
    public static final String CODE_NAME_USERCD0006 = "USERCD0006";
    /**コード情報コード名 : （Ｇ：未使用） */
    public static final String CODE_NAME_USERCD0007 = "USERCD0007";
    /**コード情報コード名 : リュープリン・コプロ１２／１０ */
    public static final String CODE_NAME_USERCD0008 = "USERCD0008";
    /**コード情報コード名 : アクトス・コプロ */
    public static final String CODE_NAME_USERCD0009 = "USERCD0009";
    /**コード情報コード名 : ベネット・コプロ */
    public static final String CODE_NAME_USERCD0010 = "USERCD0010";
    /**コード情報コード名 : グルファスト */
    public static final String CODE_NAME_USERCD0011 = "USERCD0011";
    /**コード情報コード名 : リュープリンコプロ０８／１０ */
    public static final String CODE_NAME_USERCD0012 = "USERCD0012";
    /**コード情報コード名 : （Ｍ：未使用） */
    public static final String CODE_NAME_USERCD0013 = "USERCD0013";
    /**コード情報コード名 : COP活動先 */
    public static final String CODE_NAME_USERCD0014 = "USERCD0014";
    /**コード情報コード名 : ω3製剤市場 */
    public static final String CODE_NAME_USERCD0015 = "USERCD0015";
    /**コード情報コード名 : TCB RW在籍施設 */
    public static final String CODE_NAME_USERCD0016 = "USERCD0016";
    /**コード情報コード名 : DPP4アーリーアダプタ */
    public static final String CODE_NAME_USERCD0017 = "USERCD0017";
    /**コード情報コード名 : DPP4阻害薬('16.2) */
    public static final String CODE_NAME_USERCD0018 = "USERCD0018";
    /**コード情報コード名 : DPP4阻害薬市場 */
    public static final String CODE_NAME_USERCD0019 = "USERCD0019";
    /**コード情報コード名 : ARB/CCB配合剤市場 */
    public static final String CODE_NAME_USERCD0020 = "USERCD0020";
    /**コード情報コード名 : 抗潰瘍(ＰＰＩ)市場 */
    public static final String CODE_NAME_USERCD0021 = "USERCD0021";
    /**コード情報コード名 : 骨粗鬆症市場 */
    public static final String CODE_NAME_USERCD0022 = "USERCD0022";
    /**コード情報コード名 : 睡眠市場 */
    public static final String CODE_NAME_USERCD0023 = "USERCD0023";
    /**コード情報コード名 : Ｘ雑・災害 */
    public static final String CODE_NAME_USERCD0024 = "USERCD0024";
    /**コード情報コード名 : アルツハイマー市場 */
    public static final String CODE_NAME_USERCD0025 = "USERCD0025";
    /**コード情報コード名 : ARB総市場 */
    public static final String CODE_NAME_USERCD0026 = "USERCD0026";
    /**コード情報コード名 : 施設責任者 */
    public static final String CODE_NAME_USERCD0027 = "USERCD0027";
    /**コード情報コード名 : タケプロン・コプロ */
    public static final String CODE_NAME_USERCD0028 = "USERCD0028";
    /**コード情報コード名 : 抗潰瘍(PPI)市場('16.6) */
    public static final String CODE_NAME_USERCD0029 = "USERCD0029";
    /**コード情報コード名 : （４：未使用） */
    public static final String CODE_NAME_USERCD0030 = "USERCD0030";
    /**コード情報コード名 : インフル・セオリア */
    public static final String CODE_NAME_USERCD0031 = "USERCD0031";
    /**コード情報コード名 : インフル・あすか */
    public static final String CODE_NAME_USERCD0032 = "USERCD0032";
    /**コード情報コード名 : マーケティングＧ・Ｔ */
    public static final String CODE_NAME_USERCD0033 = "USERCD0033";
    /**コード情報コード名 : （８：未使用） */
    public static final String CODE_NAME_USERCD0034 = "USERCD0034";
    /**コード情報コード名 : セルタッチ・ベネット */
    public static final String CODE_NAME_USERCD0035 = "USERCD0035";
    /**コード情報コード名 : （１０：未使用） */
    public static final String CODE_NAME_USERCD0036 = "USERCD0036";
    /**コード情報コード名 :　入院診療計画 */
    public static final String CODE_NAME_REWARD04 = "REWARD04";
    /**コード情報コード名 :　院内感染防止対策 */
    public static final String CODE_NAME_REWARD05 = "REWARD05";
    /**コード情報コード名 :　地域連携小児夜間・休日診療料1 */
    public static final String CODE_NAME_REWARD08 = "REWARD08";
    /**コード情報コード名 :　小児入院医療管理料 */
    public static final String CODE_NAME_REWARD09 = "REWARD09";
    /**コード情報コード名 :　緩和ケア診療加算 */
    public static final String CODE_NAME_REWARD18 = "REWARD18";
    /**コード情報コード名 :　短期滞在手術基本料 */
    public static final String CODE_NAME_REWARD21 = "REWARD21";
    /**コード情報コード名 :　在宅患者訪問診療料又は在総診 */
    public static final String CODE_NAME_REWARD23 = "REWARD23";
    /**コード情報コード名 :　生活習慣病指導管理料 */
    public static final String CODE_NAME_REWARD25 = "REWARD25";
    /**コード情報コード名 :　慢性疼痛疾患管理料 */
    public static final String CODE_NAME_REWARD26 = "REWARD26";
    /**コード情報コード名 :　看護配置（有床診療所） */
    public static final String CODE_NAME_REWARD27 = "REWARD27";
    /**コード情報コード名 :　老人入院基本料 */
    public static final String CODE_NAME_REWARD29 = "REWARD29";
    /**コード情報コード名 :　地域連携時間外診療(有無) */
    public static final String CODE_NAME_REWARD35 = "REWARD35";
    /**コード情報コード名 :　地域連携診療計画管理料 */
    public static final String CODE_NAME_REWARD36 = "REWARD36";
    /**コード情報コード名 :　地域連携診療計画退院時指導料 */
    public static final String CODE_NAME_REWARD37 = "REWARD37";
    /**コード情報コード名 :　病理診断料 */
    public static final String CODE_NAME_REWARD44 = "REWARD44";
    /**コード情報コード名 :　急性期入院加算 */
    public static final String CODE_NAME_REWARD16 = "REWARD16";
    /**コード情報コード名 :　急性期特定入院加算 */
    public static final String CODE_NAME_REWARD17 = "REWARD17";
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
    public static final String W007 = "W007"; // 適用日は翌営業日以降を指定してくだ項目名さい。
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

}
