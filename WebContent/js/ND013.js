/**
 * <pre>
 *  医師勤務先情報更新のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author SBS  千葉
 */



/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var CDC_APPLICATION_ID = "CDC";

/**
 * スクリーンID
 */
var CDC_SCREEN_ID = "CatDeptsCombo";


/**
 * <pre>
 *  勤務先追加、医師の廃業・死亡ボタン押下時に呼ばれます。
 * エラーチェック
 * </pre>
 */
function errorCheck(checkFlg) {
	if(checkFlg == "2"){//医師の廃業・死亡ボタン
		document.fm1.tkdDocNo.value = document.fm1.paramDocNo.value;
	}
	//エラーチェックフラグ定義
	document.fm1.errorCheckFlg.value = checkFlg;

	document.fm1.screenId.value	= "ND013";

	document.fm1.functionId.value = "Init";
	// 検索イベント呼び出し
	comSubmitForAnyWarp(fm1);

}

/**
 * <pre>
 *  アクションボタン押下時に呼ばれます。
 * エラーチェック
 * </pre>
 */
function errorCheckAction(checkFlg, td) {

	//エラーチェックフラグ定義
	document.fm1.errorCheckFlg.value = checkFlg;

	// 選択された行の施設固定C（隠し項目）を取り出す
	var span = td.parentNode;
	var td = span.parentNode;
	var tr = td.parentNode
	var insNoKakusiLabel = tr.lastElementChild;
	var insNoKakusiVal = insNoKakusiLabel.textContent;
	const insNoKakusi = insNoKakusiVal.replace(/[^0-9]/g, '');

	document.fm1.insNoKakusi.value	= insNoKakusi;

	document.fm1.screenId.value	= "ND013";

	document.fm1.functionId.value = "Init";

	document.fm1.buttonFlg.value = "1"
	// 検索イベント呼び出し
	comSubmitForAnyWarp(fm1);

}


/**
 * <pre>
 *  戻るボタン押下時に呼ばれます。
 *  画面遷移
 * </pre>
 */
function backPage() {

}

//初期設定
window.onload = function(){

	//ダイアログメッセージ定義
	var dialog = document.fm1.dialog.value;
	//エラーチェックフラグ定義
    var errorCheckFlg = document.fm1.errorCheckFlg.value;
    //エラーメッセージ
    var msgStr = document.fm1.msgStr.value;

	//エラーチェックが行われている場合
	if (document.fm1.errorCheckFlg.value != "0") {

	}

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
function cseViewND013(insNoKakusi, w, callBack, winVarName, clearProc){

	  //****************************************************************
	  // ポップアップ起動中にウィンドウが閉じられると
	  // windowオブジェクトがString型に変換されてしまう場合があるため
	  // 型変換された場合はNULLをセットして初期化する
	  //****************************************************************
	  if(typeof(w) == 'string') {
	    w = null;
	  } else {
	    if(!comPopupPreCheck(w, winVarName)){
	      return(w);
	    }
	  }

	  w = window.open ("",comCreateWindowName(CDC_APPLICATION_ID),"width=1120,height=630,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no");

	cseParentClearProc	= clearProc;

	ix1 = 0;
	jokenName = new Array();	//パラメタの名前を1次元配列で指定
	joken = new Array();		//パラメタの値を2次元配列で指定

	//選択された行の施設固定C（隠し項目）を取り出す
//	var span = td.parentNode;
//	var td = span.parentNode;
//	var tr = td.parentNode;
//	var insNoKakusiLabel = tr.lastElementChild;
//	var insNoKakusiVal = insNoKakusiLabel.textContent;
//	const insNoKakusi = insNoKakusiVal.replace(/[^0-9]/g, '');

	jokenName[ix1] = "insNoKakusi";
	joken[ix1++] = new Array(insNoKakusi);

	document.fm1.insNoKakusi.value	= insNoKakusi;

	/*条件有り呼び出しパターン*/
	comPostPopup(w,"NC208Init",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);
	//comPostPopup(w,"JKR100C010Init.action",CSE_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);
	/*
	 *
	 **/

	w.focus();
	return(w);

}