/**
 * <pre>
 *  従業員関連共通のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var JKR_APPLICATION_ID = "JKR";
var RDM_APPLICATION_ID = "RDM";

/**
 * <pre>
 *  背景色(標準)
 * 入力可能なテキストボックスの背景色に使用します。
 * </pre>
 */
var JKR_BG_COLOR_NORMAL = "#FFFFFF";
var RDM_BG_COLOR_NORMAL = "#FFFFFF";

/**
 * <pre>
 *  背景色(入力不可)
 * 入力不可のテキストボックスの背景色に使用します。
 * </pre>
 */
var JKR_BG_COLOR_DISABLED = "#a1a4ac";
var RDM_BG_COLOR_DISABLED = "#a1a4ac";

/**
 * <pre>
 *  メニューパラメータ用定数
 * </pre>
 */

// 条件設定 : 適用日設定可能本部権限
var JKR_JKN_HONBU_COMMIT	= "JKN0163";
// 条件設定 : 適用日設定不可能本部権限
var JKR_JKN_HONBU_NOCOMMIT	= "JKN0162";
// 条件設定 : ワクチンG権限
var JKR_JKN_VACCINE			= "JKN0161";
// 条件設定 : 支店権限
var JKR_JKN_SITEN			= "JKN0160";
// 条件設定 : 営業所権限
var JKR_JKN_EIGYOU			= "JKN0159";
// 条件設定 : MR権限
var JKR_JKN_MR				= "JKN0164";

// 業務種類 : 本部権限
var JKR_BUS_TYPE_HONBU		= "1";
// 業務種類 : 支店権限(代行）
var JKR_BUS_TYPE_SITEN		= "2";
// 業務種類 : 営業所権限(代行）
var JKR_BUS_TYPE_EIGYOU		= "3";
// 業務種類 : 施設の担当組織変更
var JKR_BUS_TYPE_INS_CHG	= "4";
// 業務種類 : 仮従業員登録確認
var JKR_BUS_TYPE_MR_REG		= "5";
// 業務種類 : 変更状況確認
var JKR_BUS_TYPE_STS_CNF	= "6";

// MR種類 : 営業所MR
var JKR_MRCAT_EIGYOU		= "01";
// MR種類 : ﾜｸﾁﾝMR
var JKR_MRCAT_VAC			= "02";
// MR種類 : EMR
var JKR_MRCAT_EMR			= "04";
// MR種類 : LMR
var JKR_MRCAT_LMR			= "05";
// MR種類 : SC
var JKR_MRCAT_SC			= "06";
// 医薬組織変更・期末期首対応（従業員関連）
//MR種類 : CVMMR
var JKR_MRCAT_CVM		= "08";
//MR種類 : RSMR
var JKR_MRCAT_RS		= "09";
//MR種類 : ONCMR
var JKR_MRCAT_ONC		= "05";
// 医薬組織変更・期末期首対応（従業員関連）


/**
 * <pre>
 *  帳票作成依頼ポップアップ用定数
 * </pre>
 */

// MR種類
var JKR_MR_CAT_BUS_MR		= "営業所MR";
var JKR_MR_CAT_VAC_MR		= "ワクチンMR";
var JKR_MR_CAT_EMR			= "EMR";
var JKR_MR_CAT_LMR			= "LMR";

// 担当先
var JKR_INS_CHG_ALL			= "全て";
var JKR_INS_CHG_SINGLE		= "単独先";
var JKR_INS_CHG_MULTI		= "複数担当先";

// 対象区分
var JKR_HO_INS_TYPE_ALL		= "全て";
var JKR_HO_INS_TYPE_U		= "U";
var JKR_HO_INS_TYPE_H		= "H";
var JKR_HO_INS_TYPE_UH		= "UH";
var JKR_HO_INS_TYPE_P		= "P";
var JKR_HO_INS_TYPE_ZATU	= "雑";

// 施設区分
var JKR_PHARM_TYPE_ALL		= "全て";
var JKR_PHARM_TYPE_HON		= "本院";
var JKR_PHARM_TYPE_B		= "B調";
var JKR_PHARM_TYPE_MALL		= "モール";

// 施設展開
var JKR_INS_DEVE_DO			= "する";
var JKR_INS_DEVE_NOT		= "しない";

// 変更情報
var JKR_CHG_PRES_ALL		= "全て";
var JKR_CHG_PRES_NASI		= "変更なし";
var JKR_CHG_PRES_ARI		= "変更あり";



/**
 * <pre>
 *  デバッグ用関数
 * gJkrDebug = true でデバッグします。
 * </pre>
 */
var gJkrDebug = false;
function jkrDebug(str){
  if(gJkrDebug) alert(str);
  return(true);
}

/**
 * <pre>
 *  画面のロード時の処理
 * ・画面のロード時の処理を記述します。
 * ・ウィンドウの名前を付けます。
 * <pre>
 */
function jkrViewLoad(){
}

/**
 * メインテーブル(<DIV>~</DIV>)のスクロールにあわせて
 * 見出しテーブル/アイテムテーブルをスクロールさせる関数
 *
 */
function jkrSyncScrolling(){
  document.all.jkrTitle.scrollTop = document.all.jkrTableData.scrollTop;
  document.all.jkrHeader.scrollLeft = document.all.jkrTableData.scrollLeft;
}

/**
 * <pre>
 *  メッセージIDを定義
 * 　変更内容の破棄確認メッセージを設定
 * </pre>
 */
var destructMsg = "";

/**
 * <pre>
 * 変更内容の破棄確認処理
 * 　他ページへ遷移する際に一覧内容が変更されている場合
 * 　確認ダイアログを表示する。
 * <pre>
 */
var jkrMrChaker = 0;
function jkrDestructChack(){

  var delChangeFlg = true;

  // 二度押しの場合はチェック不要(二度押し制御を優先)
  if (COM_Click_flg) {
    if(jkrMrChaker != 0){
      delChangeFlg = confirm(destructMsg);
    }
  }
   return delChangeFlg;
}

/**
 * <pre>
 * 『外勤担当者変更メニューへ』
 * 　リンク押下時の処理
 * <pre>
 */
function jkrMenuLink(functionId){
  if(jkrDestructChack()){
    //comNextScreen(document._fmTopMenu,'JkrMenu','View');
    if( COM_Click_flg == false ){
      alert("既に処理を開始しています。");
      return false;
    }
    COM_Click_flg = false;

    //フォームが存在しない場合、送信フォームを作成する
    if(!document._fmMainJkr && !document.all._fmMainJkr){

      var fmMainMenuObj = document.createElement('form');
      fmMainMenuObj.id = "_fmMainJkr";
      fmMainMenuObj.method = "POST";
      fmMainMenuObj.action = "NC001" + functionId + ".action";
      fmMainMenuObj.style.visibility = "hidden";
      fmMainMenuObj.style.position = "absolute";

      appFormData(fmMainMenuObj,"text","screenId","");
      appFormData(fmMainMenuObj,"text","functionId","");
      appFormData(fmMainMenuObj,"text","windowName","");
      appFormData(fmMainMenuObj,"text","openerName","");

      //各画面で変えられた組織を保持しトップメニューへ表示させる
      if (document.getElementById("topChangedSosCd")) {
        appFormData(fmMainMenuObj,"text", "topChangedSosCd",  document.getElementById("topChangedSosCd").value);
        appFormData(fmMainMenuObj,"text", "topChangedSosNm",  document.getElementById("topChangedSosNm").value);
        appFormData(fmMainMenuObj,"text", "topChangedSosCd2", document.getElementById("topChangedSosCd2").value);
        appFormData(fmMainMenuObj,"text", "topChangedSosNm2", document.getElementById("topChangedSosNm2").value);
        appFormData(fmMainMenuObj,"text", "topChangedSosCd3", document.getElementById("topChangedSosCd3").value);
        appFormData(fmMainMenuObj,"text", "topChangedSosNm3", document.getElementById("topChangedSosNm3").value);
      }

      document.body.appendChild(fmMainMenuObj);
      fmMainMenuObj.submit();
    }
    //location.href="RDM000C010View";
  }
   return false;
}

/**
 * <pre>
 * 『ホームへ』
 * 　リンク押下時の処理
 * <pre>
 */
function jkrHomeLink(){
  if(jkrDestructChack()){
    mnuTopGo('Menu','ViewInit');
  }
   return false;
}

/**
 * <pre>
 * 『担当引継ぎ・施設別・医師別へ』
 * 　リンク押下時の処理
 * <pre>
 */
function jkrComLink(screenId,backScreenId,soscd,sosName,mrcat){
  if(jkrDestructChack()){
    if(backScreenId != ""){
      document.fm0.backScreenId1.value = backScreenId;
    }
    if(soscd != ""){
      document.fm0.selectedSosCd1.value = soscd;
    }
    if(sosName != ""){
      document.fm0.selectedSosName1.value = sosName;
    }
    if(mrcat != ""){
      document.fm0.mrCat1.value = mrcat;
    }
    comNextScreen(document.fm0,screenId,'ViewInit');
  }
   return false;
}

/**
 * トップメニューに戻った場合のため、変更された組織を保存する
 */
function changeSosCdForTopMenu(sosKbn, bumonRank, sosCd2, sosCd3, sosCd4,bumonSeiName2, bumonSeiName3, bumonSeiName4) {

  //従業員仮登録の場合、現・新組織
  if (sosKbn == 0) {

  //現組織
  } else if (sosKbn == 1 && document.fm1.sosSelFlg.value == "0") {
    //alert("現組織変更：");
  //新組織
  } else if (sosKbn == 2 && document.fm1.sosSelFlg.value == "1") {
    //alert("新組織変更：");
  } else {
    //alert("新現組織変更、トップメニューへ反映なし");
    return;
  }

  //alert("bumonRank == " + bumonRank);
  //alert("sosCd2 3 == " + sosCd2 + ":::" + sosCd3);
  //部門ランク（支店）
  if (bumonRank == "2") {
    //選択された組織情報格納（表示押下前）
    document.getElementById("topChgSosCd").value = sosCd2;
    document.getElementById("topChgSosNm").value = bumonSeiName2;

    //営業所ORチームOR従業員
  } else if (bumonRank == null || bumonRank == "" || bumonRank == "3" || bumonRank == "4") {
    //選択された組織情報格納（表示押下前）
    document.getElementById("topChgSosCd").value = sosCd3;
    document.getElementById("topChgSosNm").value = bumonSeiName2 + " " + bumonSeiName3;
  }

  //選択された組織情報格納（表示押下前）
  document.getElementById("topChgSosCd2").value = sosCd2;
  document.getElementById("topChgSosNm2").value = bumonSeiName2;
  document.getElementById("topChgSosCd3").value = sosCd2;
  document.getElementById("topChgSosNm3").value = bumonSeiName2;
}

/**
 * 各画面で変えられた組織を保持しトップメニューへ表示させる
 */
function setTopChangedSos() {
    if (!document.getElementById("topChgSosCd") || !document.getElementById("topChangedSosCd")) {
      return;
    }

    //選択された組織情報格納（表示押下前→表示押下後）
    if (document.getElementById("topChgSosCd").value != "") {
      document.getElementById("topChangedSosCd").value = document.getElementById("topChgSosCd").value;
    }
    if (document.getElementById("topChgSosNm").value != "") {
      document.getElementById("topChangedSosNm").value = document.getElementById("topChgSosNm").value;
    }
    if (document.getElementById("topChgSosCd2").value != "") {
      document.getElementById("topChangedSosCd2").value = document.getElementById("topChgSosCd2").value;
    }
    if (document.getElementById("topChgSosNm2").value != "") {
      document.getElementById("topChangedSosNm2").value = document.getElementById("topChgSosNm2").value;
    }
    if (document.getElementById("topChgSosCd3").value != "") {
      document.getElementById("topChangedSosCd3").value = document.getElementById("topChgSosCd3").value;
    }
    if (document.getElementById("topChgSosNm3").value != "") {
      document.getElementById("topChangedSosNm3").value = document.getElementById("topChgSosNm3").value;
    }
    document.getElementById("topChgSosCd").value = "";
    document.getElementById("topChgSosNm").value = "";
    document.getElementById("topChgSosCd2").value = "";
    document.getElementById("topChgSosNm2").value = "";
    document.getElementById("topChgSosCd3").value = "";
    document.getElementById("topChgSosNm3").value = "";
}

/**
 * 既定値に戻す場合の組織情報のリセット
 */
function clearTopChangedSos() {

    if (!document.getElementById("topChangedSosCd") || !document.fm1.selectedSosCd) {
        return;
      }

    //選択された組織情報格納（トップメニューで選択された状態に戻す）
    document.getElementById("topChgSosCd").value  = document.fm1.selectedSosCd.value;
    document.getElementById("topChgSosNm").value  = document.fm1.selectedSosNm.value;
    document.getElementById("topChgSosCd2").value = document.fm1.selectedSosCd2.value;
    document.getElementById("topChgSosNm2").value = document.fm1.selectedSosNm2.value;
    document.getElementById("topChgSosCd3").value = document.fm1.selectedSosCd3.value;
    document.getElementById("topChgSosNm3").value = "";
}

/**
 * 表示リセット時の組織リセット
 */
function resetTopChangedSos() {

    if (!document.getElementById("topChangedSosCd") || !document.fm1.selectedSosCd) {
        return;
      }

    //選択された組織情報格納（トップメニューで選択された状態に戻す）
    document.getElementById("topChangedSosCd").value  = document.fm1.selectedSosCd.value;
    document.getElementById("topChangedSosNm").value  = document.fm1.selectedSosNm.value;
    document.getElementById("topChangedSosCd2").value = document.fm1.selectedSosCd2.value;
    document.getElementById("topChangedSosNm2").value = document.fm1.selectedSosNm2.value;
    document.getElementById("topChangedSosCd3").value = document.fm1.selectedSosCd3.value;
    document.getElementById("topChangedSosNm3").value = "";

    document.getElementById("topChgSosCd").value  = "";
    document.getElementById("topChgSosNm").value  = "";
    document.getElementById("topChgSosCd2").value = "";
    document.getElementById("topChgSosNm2").value = "";
    document.getElementById("topChgSosCd3").value = "";
    document.getElementById("topChgSosNm3").value = "";
}

// 20150202 HISOL Suzuki 本番課題No.25対応 ADD START
/**
 * 組織従業員選択ポップアップで使用する組織情報を更新する
 */
function setSearchSosCdPop() {
    if (!document.getElementById("searchFromSosCdPop") || !document.getElementById("searchToSosCdPop")) {
      return;
    }

    //選択された組織情報格納
    if (document.getElementById("searchFromSosCd").value != "") {
      document.getElementById("searchFromSosCdPop").value = document.getElementById("searchFromSosCd").value;
      document.getElementById("searchToSosCdPop").value = "";
    } else if (document.getElementById("searchToSosCd").value != "") {
      document.getElementById("searchFromSosCdPop").value = "";
      document.getElementById("searchToSosCdPop").value = document.getElementById("searchToSosCd").value;
    }
}
//20150202 HISOL Suzuki 本番課題No.25対応 ADD END
/**
 * <pre>
 * 変更内容の破棄確認処理
 * 　他ページへ遷移する際に一覧内容が変更されている場合
 * 　確認ダイアログを表示する。
 * <pre>
 */
var rdmMrChaker = 0;
function rdmDestructChack(){

  var delChangeFlg = true;

  // 二度押しの場合はチェック不要(二度押し制御を優先)
  if (COM_Click_flg) {
    if(rdmMrChaker != 0){
      delChangeFlg = confirm(destructMsg);
    }
  }
   return delChangeFlg;
}

/**
 * <pre>
 * 『外勤担当者変更メニューへ』
 * 　リンク押下時の処理
 * <pre>
 */
function rdmMenuLink(functionId){
  if(rdmDestructChack()){
    //comNextScreen(document._fmTopMenu,'RdmMenu','View');
    if( COM_Click_flg == false ){
      alert("既に処理を開始しています。");
      return false;
    }
    COM_Click_flg = false;

    //フォームが存在しない場合、送信フォームを作成する
    if(!document._fmMainRdm && !document.all._fmMainRdm){

      var fmMainMenuObj = document.createElement('form');
      fmMainMenuObj.id = "_fmMainRdm";
      fmMainMenuObj.method = "POST";
      fmMainMenuObj.action = "NC001" + functionId + ".action";
      fmMainMenuObj.style.visibility = "hidden";
      fmMainMenuObj.style.position = "absolute";

      appFormData(fmMainMenuObj,"text","screenId","");
      appFormData(fmMainMenuObj,"text","functionId","");
      appFormData(fmMainMenuObj,"text","windowName","");
      appFormData(fmMainMenuObj,"text","openerName","");

      //各画面で変えられた組織を保持しトップメニューへ表示させる
//      if (document.getElementById("topChangedSosCd")) {
//        appFormData(fmMainMenuObj,"text", "topChangedSosCd",  document.getElementById("topChangedSosCd").value);
//        appFormData(fmMainMenuObj,"text", "topChangedSosNm",  document.getElementById("topChangedSosNm").value);
//        appFormData(fmMainMenuObj,"text", "topChangedSosCd2", document.getElementById("topChangedSosCd2").value);
//        appFormData(fmMainMenuObj,"text", "topChangedSosNm2", document.getElementById("topChangedSosNm2").value);
//        appFormData(fmMainMenuObj,"text", "topChangedSosCd3", document.getElementById("topChangedSosCd3").value);
//        appFormData(fmMainMenuObj,"text", "topChangedSosNm3", document.getElementById("topChangedSosNm3").value);
//      }

      document.body.appendChild(fmMainMenuObj);
      fmMainMenuObj.submit();
    }
    //location.href="RDM000C010View";
  }
   return false;
}

/**
 * <pre>
 * 『ホームへ』
 * 　リンク押下時の処理
 * <pre>
 */
function rdmHomeLink(){
  if(rdmDestructChack()){
    mnuTopGo('Menu','ViewInit');
  }
   return false;
}