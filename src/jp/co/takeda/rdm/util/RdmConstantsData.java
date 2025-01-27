package jp.co.takeda.rdm.util;

/**
 * <pre>
 *  従業員関連コンスタントクラス
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author 日立　花
 */
public class RdmConstantsData {

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














    /***条件設定 : 適用日設定可能本部権限 */
    public static final String RDM_JKN_HONBU_COMMIT = "JKN0163";

    /***条件設定 : 適用日設定不可本部権限 */
    public static final String RDM_JKN_HONBU_NOCOMMIT = "JKN0162";

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


    /** 担当変更システムトップメニュー[リスト作成依頼]ボタン押下 : 戻るためのDTOセッション格納キー */
    public static final String NC001_RETURN_DTO_KEY = "NC001_RETURN_DTO_KEY";


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
    public static final String SCREEN_ID_JKR010C010 = "JKR010C010";
    public static final String SCREEN_ID_JKR020C010 = "JKR020C010";
    public static final String SCREEN_ID_JKR030C010 = "JKR030C010";
    public static final String SCREEN_ID_JKR030C020 = "JKR030C020";
    public static final String SCREEN_ID_JKR040C010 = "JKR040C010";
    public static final String SCREEN_ID_JKR040C020 = "JKR040C020";
    public static final String SCREEN_ID_JKR040C030 = "JKR040C030";
    public static final String SCREEN_ID_JKR040C040 = "JKR040C040";
    public static final String SCREEN_ID_JKR050C010 = "JKR050C010";
    public static final String SCREEN_ID_JKR050C020 = "JKR050C020";
    public static final String SCREEN_ID_JKR050C030 = "JKR050C030";
    public static final String SCREEN_ID_JKR100C010 = "JKR100C010";
    public static final String SCREEN_ID_JKR100C020 = "JKR100C020";
    public static final String SCREEN_ID_JKR100C040 = "JKR100C040";
    public static final String SCREEN_ID_JKR100C050 = "JKR100C050";
    public static final String SCREEN_ID_JKR100C060 = "JKR100C060";
    public static final String SCREEN_ID_JKR100C070 = "JKR100C070";
    public static final String SCREEN_ID_JKR100C090 = "JKR100C090";
    public static final String SCREEN_ID_JKR100C100 = "JKR100C100";
    public static final String SCREEN_ID_JKR090C010 = "JKR090C010";
    public static final String SCREEN_ID_JKR090C020 = "JKR090C020";
    /**画面ＩＤエリア終了 */

    /**登録完了画面フラグ */
    public static final String JKR090C020_FINISH_FLG = "JKR090C020Finish";

    /**登録完了画面値 */
    public static final String JKR090C020_FINISH_VALUE = "1";

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
}
