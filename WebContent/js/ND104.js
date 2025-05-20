/**
 * <pre>
 * 医師勤務先追加のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author SBS  千葉
 */

///**
// * ポップアップ用ウィンドウオブジェクト
// */
//var gCseViewFromWin = null;    // 組織従業員選択(組織・担当(現))
//var gCseViewToWin = null;      // 組織従業員選択(組織・担当(新))
//var gCtcViewWin = null;        // JIS府県武田市区郡選択
//var gIiiViewWin=null;          // 施設固定コード複数入力
//var gCpcViewWin=null;          // 品目選択開始
//var gCseViewChgWin=null;       // 組織従業員選択(変更担当者)
//var gCseViewToJgiWin=null;     // 組織従業員選択(新担当者)
//var gCseViewSosWin=null;       // 組織従業員選択(組織)
//
//var msgContent = ""; //確認メッセージ
//var gChsViewWin = null;        // 所属学会POPUP用
//var gChpViewWin = null;        // 公的機関POPUP用
//var gCdcViewWin = null;        // 出身所属部科/勤務先情報 所属部科POPUP用
//var gCseViewWin = null;        // 勤務先情報 施設POPUP用
//
//
///**
// * <pre>
// *  アプリケーションIDを定義
// * window名等に利用します。
// * </pre>
// */
//var CDC_APPLICATION_ID = "CDC";
//
///**
// * スクリーンID
// */
//var CDC_SCREEN_ID = "CatDeptsCombo";
//
///**
// * <pre>
// *  全メッセージ格納用配列
// * 当画面で使用する全メッセージが格納されます。
// * </pre>
// */
//var gMsg = new Array();
//
///**
// * <pre>
// *  画面のロード時の処理
// * 画面のロード時の処理を記述します。
// * @param msg1～5 全メッセージ
// * <pre>
// */
//function jimViewLoad(msg1,msg2,msg3,msg4,msg5, msg6){
//
//  gMsg[0] = msg1;  // 『「組織・担当(現)」及び「組織・担当(新)」が設定されていません。どちらかの指定が必須となります。』
//  gMsg[1] = msg2;  // 『施設名(全角カナ)には全角カナ文字又は全角英数字(大文字)以外は入力できません。』
//  gMsg[2] = msg3;  // 『「展開方法」が設定されていません。 』
//  gMsg[3] = msg4;  // 『新担当者を設定してください。』
//  gMsg[4] = msg5;  // 『変更内容が破棄されます。よろしいですか？』
//  gMsg[5] = msg6;  // 『登録します。よろしいですか？』
//
//  // 変更内容破棄確認メッセージの設定
//  destructMsg = gMsg[4];  // 『変更内容が破棄されます。よろしいですか？』
//
//  if (document.fm1.gamenId.value == "JKR040C010") {
//    setAllChgBtnStatus010("chgInsTrtList");
//  } else if (document.fm1.gamenId.value == "JKR040C020") {
//
//  } else if (document.fm1.gamenId.value == "JKR040C030") {
//    setAllChgBtnStatus("chgInsCityList");
//  } else if (document.fm1.gamenId.value == "JKR040C040") {
//    setAllChgBtnStatus010("chgInsTrtList");
//  }
//}
//
///**
// * 画面のリロードやアンロードの際の処理を記述します。
// * ポップアップ画面を使用するときは使用する分を全てクリアします。
// */
//function jimUnLoad(){
//
//  jimViewClear(8);
//}


/**
 * <pre>
 *  一時保存ボタン押下後に呼ばれます
 * エラーチェック　保存処理
 * </pre>
 */
function reqND104Save() {

	//一時保存　押下済み
	document.fm1.saveButtonFlg.value = "1";

	document.fm1.msgStr.value = "";

	document.fm1.screenId.value	= "ND104";

	document.fm1.functionId.value = "Init";
	// 検索イベント呼び出し
	comSubmitForAnyWarp(fm1);

}

/**
 * <pre>
 *  申請破棄ボタン押下後に呼ばれます
 * エラーチェック　削除処理
 * </pre>
 */
function reqDel() {

	//一時保存　押下済み
	document.fm1.deleteButtonFlg.value = "1";

	document.fm1.msgStr.value = "";

	document.fm1.screenId.value	= "ND104";

	document.fm1.functionId.value = "Init";
	// 検索イベント呼び出し
	comSubmitForAnyWarp(fm1);

}


// 申請画面へボタン
function ND313Page(){

	document.fm1.msgStr.value = "";

	document.fm1.shinseiButtonFlg.value = "1";
	document.fm1.screenId.value	= "ND313";
	document.fm1.functionId.value = "Init";

 	comSubmitForAnyWarp(fm1);

}

/**
 * <pre>
 *  審査完了ボタン押下後に呼ばれます
 * エラーチェック　保存処理
 * </pre>
 */
function shnCompBtn() {

	//審査完了　押下済み
	document.fm1.shnCompButtonFlg.value = "1";
	document.fm1.screenId.value	= "ND104";
	document.fm1.functionId.value = "Init";
	//イベント呼び出し
	comSubmitForAnyWarp(fm1);

}


//初期設定
window.onload = function(){

	comClickFlgInit();
	//ダイアログメッセージ定義
	var dialog = document.fm1.dialog.value;
	//エラーメッセージ
    var msgStr = document.fm1.msgStr.value;

	if (dialog != "") {
		if (window.confirm(dialog)) {//OK押下の場合

			//ND311_医師勤務先追加 - 申請内容確認
			document.fm1.screenId.value	= "ND313";
		    document.fm1.functionId.value = "Init"

			comSubmitForAnyWarp(fm1);

	     }
		 //Cancel押下の場合
		 return false;
	}
	return false;
}