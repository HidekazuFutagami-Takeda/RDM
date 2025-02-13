/**
 * <pre>
 * 医師勤務先追加のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author SBS  千葉
 */

/**
 * ポップアップ用ウィンドウオブジェクト
 */
var gCseViewFromWin = null;    // 組織従業員選択(組織・担当(現))
var gCseViewToWin = null;      // 組織従業員選択(組織・担当(新))
var gCtcViewWin = null;        // JIS府県武田市区郡選択
var gIiiViewWin=null;          // 施設固定コード複数入力
var gCpcViewWin=null;          // 品目選択開始
var gCseViewChgWin=null;       // 組織従業員選択(変更担当者)
var gCseViewToJgiWin=null;     // 組織従業員選択(新担当者)
var gCseViewSosWin=null;       // 組織従業員選択(組織)

/**
 * <pre>
 *  全メッセージ格納用配列
 * 当画面で使用する全メッセージが格納されます。
 * </pre>
 */
var gMsg = new Array();

/**
 * <pre>
 *  画面のロード時の処理
 * 画面のロード時の処理を記述します。
 * @param msg1～5 全メッセージ
 * <pre>
 */
function jimViewLoad(msg1,msg2,msg3,msg4,msg5, msg6){

  gMsg[0] = msg1;  // 『「組織・担当(現)」及び「組織・担当(新)」が設定されていません。どちらかの指定が必須となります。』
  gMsg[1] = msg2;  // 『施設名(全角カナ)には全角カナ文字又は全角英数字(大文字)以外は入力できません。』
  gMsg[2] = msg3;  // 『「展開方法」が設定されていません。 』
  gMsg[3] = msg4;  // 『新担当者を設定してください。』
  gMsg[4] = msg5;  // 『変更内容が破棄されます。よろしいですか？』
  gMsg[5] = msg6;  // 『登録します。よろしいですか？』

  // 変更内容破棄確認メッセージの設定
  destructMsg = gMsg[4];  // 『変更内容が破棄されます。よろしいですか？』

  if (document.fm1.gamenId.value == "JKR040C010") {
    setAllChgBtnStatus010("chgInsTrtList");
  } else if (document.fm1.gamenId.value == "JKR040C020") {

  } else if (document.fm1.gamenId.value == "JKR040C030") {
    setAllChgBtnStatus("chgInsCityList");
  } else if (document.fm1.gamenId.value == "JKR040C040") {
    setAllChgBtnStatus010("chgInsTrtList");
  }
}

/**
 * 画面のリロードやアンロードの際の処理を記述します。
 * ポップアップ画面を使用するときは使用する分を全てクリアします。
 */
function jimUnLoad(){

  jimViewClear(8);
}



/**
 * <pre>
 *  一時保存ボタン押下後に呼ばれます
 * エラーチェック　保存処理
 * </pre>
 */
function reqSave() {

	//一時保存　押下済み
	document.fm1.saveButtonFlg.value = "1";

	document.fm1.screenId.value	= "ND103";

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

	document.fm1.screenId.value	= "ND103";

	document.fm1.functionId.value = "Init";
	// 検索イベント呼び出し
	comSubmitForAnyWarp(fm1);

}

/**
* 親ウインドウから呼び出す画面表示関数
* @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
* @param callBack コールバック関数の名前をStringで受け取ります。
* @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
*           このエリアはUnLoad処理でクリアします。
* @param clearProc 呼び出し元のクリア処理名をStringで受け取ります。
* @return 呼び出したwindowオブジェクトを返します。
*/
function cseViewND013(td,w, callBack, winVarName, clearProc){

	if(typeof(w)=='string'){
	  w=null;
	}else{
	  //フォーカスをあてる処理と２度押し対策を共通関数化
	  if(!comPopupPreCheck(w, winVarName)){
	    return(w);
	  }
	}
	//ウインドウの体裁(幅や高さなど)はここで指定します。
	w = window.open (
	  "",
	  comCreateWindowName(CSE_APPLICATION_ID),
	  "width=500,height=570,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no"
	);

	cseParentClearProc	= clearProc;

	ix1 = 0;
	jokenName = new Array();	//パラメタの名前を1次元配列で指定
	joken = new Array();		//パラメタの値を2次元配列で指定

	//選択された行の施設固定C（隠し項目）を取り出す
	var span = td.parentNode;
	var td = span.parentNode;
	var tr = td.parentNode
	var insNoKakusiLabel = tr.lastElementChild;
	var insNoKakusiVal = insNoKakusiLabel.textContent;
	const insNoKakusi = insNoKakusiVal.replace(/[^0-9]/g, '');

	jokenName[ix1] = "insNoKakusi";
	joken[ix1++] = new Array(insNoKakusi);

	document.fm1.insNoKakusi.value	= insNoKakusi;

	/*条件有り呼び出しパターン*/
	comPostPopup(w,"NC208Init",CSE_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);
	//comPostPopup(w,"JKR100C010Init.action",CSE_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);
	/*
	 *
	 **/

	w.focus();
	return(w);
}





