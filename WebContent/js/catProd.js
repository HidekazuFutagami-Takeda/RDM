/**
 * <pre>
 *  品目複数選択のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author BHH 張
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var CPC_APPLICATION_ID = "CPC";

/**
 * スクリーンID
 */
var CPC_SCREEN_ID = "CatProd";

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function cpcView(w,callBack,winVarName){

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
	
	w = window.open ("",comCreateWindowName(CPC_APPLICATION_ID),"width=530,height=660,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no");

	// パラメタの設定
	var checkedCodes = document.fm1.cpcCheckedCodes;
	var jokenName = [];
	var joken = [];
	for (var i = 0; i < checkedCodes.length; i++) {
		jokenName[jokenName.length] = "cpcCheckedCodes";
		joken[joken.length] = new Array(checkedCodes[i].value);
	}
	jokenName[jokenName.length] = "trtGrpCd";
	joken[joken.length] = new Array(document.fm1.trtGrpCd.value);

	comPostPopup(w,"JKR100C050Init.action",CPC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);
	
	w.focus();
	return(w);
}

/**
 * 起動時の処理を記述します。
 */
function cpcLoad(){

	//２度押し対策フラグ初期化
	comClickFlgInit();

	// セッションから取得したチェック済み都道府県・市区郡を画面に反映する。
	var checkedList = cpcDecodeCodeData( document.fm1.cpcCheckedCodes );
	var checkers = document.fm1.checkers;
	var prodCode = document.fm1.prodCode;
	for (var i = 0; i < checkedList.length; i++) {
		for (var j = 0; j < prodCode.length; j++) {
			if (checkedList[i].prodCode == prodCode[j].value) {
				checkers[j].checked = true;
			}
		}
	}
	
	//cpcSetCheckedItem();
}

/**
 * 値を親ウインドウに返しウインドウを閉じます。
 * 値は、親のコールバック関数に引数として渡す方式とします。
 * @param index form内実データのインデックスを受け取ります。
 */
function cpcReturn(index){
	//ボタン２度押し対策を、なるべく早いタイミングで行います。
	if(!comChkSubmit(COM_CLICK_ALERT))return(false);
	// チェック済リストの取得。
	var resultList = cpcCreateCheckedList();
	//１件選択パターンの場合は、渡したい値をそのままコールバック関数に渡すことにする。
	eval("window.opener." + document.fm1.callBack.value + "(resultList, cpcEncodeCodeData(resultList))");
	cpcClose();
	return(true);
}

/**
 * cpcReturnで、このウインドウを閉じるときに呼び出されます。
 * 単にウインドウを閉じます。
 */
function cpcClose(){
	window.close();
}

function cpcUnLoad(){
	try{
		eval("window.opener." + document.fm0.winVarName.value + "=null");
	}catch(err){
	}
}

/**
 * 品目の名称とコードを保持する
 * オブジェクトクラス
 */
function CpcCodeData() {
	this.prodCode = "";
	this.prodName = "";
}

/**
 * 10進数の参照文字列に変換できるように数値化だけしておく。
 * 既に変換済みの場合は処理を行わない。
 * ※親画面からポップアップにマルチバイトを渡すと文字化けするため、
 *   チェック済みを記憶する際には一貫して参照文字を利用する。
 *
 * @param  targetText 対象文字列
 * @return {String}数値変換された文字列
 */
function cpcEncodeDecimal(targetText){
	var resultText = "";
	if (targetText != "" && targetText.indexOf("[") == -1) {
		for (var i = 0; i < targetText.length; i++) {
			 resultText += ("["+(targetText.charCodeAt(i))+"]");
		}
	} else {
		resultText = targetText;
	}
	return resultText;
}

/**
 * cpcEncodeDecimal関数によって置き換えられた文字列を
 * 完全な参照文字列にする。
 *
 * @param  s 対象文字列
 * @return {String}参照文字列に変換された文字列
 */
function cpcDecodeDecimal(s) {
	while (s.indexOf("[") != -1) {
		 s = s.replace("[", "&#");
	}
	while (s.indexOf("]") != -1) {
		s = s.replace("]", ";");
	}
	return s;
}

/**
 * チェック済みを記憶するためにServlet送信用の
 * 文字列を作成する。
 *
 * @param targetList 「new CpcCodeData()」で作成されるオブジェクト配列
 * @return {Array} 結果配列
 */
function cpcEncodeCodeData(targetList) {
	var resultList = [];
	for (var i = 0; i < targetList.length; i++) {
		resultList[resultList.length] = ""
			+ targetList[i].prodCode + ","
			+ cpcEncodeDecimal( targetList[i].prodName );
	}
	return resultList;
}

/**
 * Sevletから取得したチェック済みをJavaScriptで
 * 使用できるように、オブジェクト配列に変換する。
 *
 * @param  targetList コードと名称を「,」区切りで整形した<input>フォーム配列
 * @return {Array} 結果配列
 */
function cpcDecodeCodeData(targetList) {
	var resultList = [];
	for (var i = 0; i < targetList.length; i++) {
		// ダミーは対象外とする。
		if (targetList[i].value != "dummy") {
			var codes = targetList[i].value.split(",");
			var codeData = new CpcCodeData();
			codeData.prodCode = codes[0];
			codeData.prodName = codes[1];
			resultList[resultList.length] = codeData;
		}
	}
	return resultList;
}

function cpcCreateCheckedList() {

	var checkers = document.fm1.checkers;
	var prodCode = document.fm1.prodCode;
	var prodName = document.fm1.prodName;

	// 遷移前に選択したチェック済みを取得する。
	var checkedList = cpcDecodeCodeData( document.fm1.cpcCheckedCodes );
	// 画面のチェック済みを取得する。
	for (var i = 0; i < checkers.length; i++) {
		// ダミーは無視する。
		if (checkers[i].value == "dummy") {
		// チェック済みはリストに追加する。
		} else if (checkers[i].checked) {
			var codeData = new CpcCodeData();
			codeData.prodCode = prodCode[i].value;
			codeData.prodName = prodName[i].value;
			checkedList[checkedList.length] = codeData;
		// チェックなしはダミーとする。
		} else {
			for (var j = 0; j < checkedList.length; j++) {
				if (prodCode[i].value == checkedList[j].prodCode) {
					checkedList[j] = "dummy";
				}
			}
		}
	}

	// ダミーを取り除く
	var resultList = [];
	for (var i = 0; i < checkedList.length; i++) {
		if (checkedList[i] != "dummy") {
			resultList[resultList.length] = checkedList[i];
		}
	}
	// prodCodeで一意にして、prodCodeの昇順ソートで返す。
	return cpcSortCode( cpcToUnique(resultList) );
}

/**
 * prodCodeで一意にする。
 * 
 * @param  targetList 「new CpcCodeData()」で作成されるオブジェクト配列
 * @return {Array} 結果配列
 */
function cpcToUnique(targetList) {
	var resultList = [];
	for (var i = 0; i < targetList.length; i++) {
		var unique = true;
		for (var j = 0; j < resultList.length; j++) {
			if (targetList[i].prodCode == resultList[j].prodCode) {
				unique = false;
				break;
			}
		}
		if (unique) {
			resultList[resultList.length] = targetList[i];
		}
	}
	return resultList;
}

/**
 * prodCodeで昇順にソートする。
 */
function cpcSortCode(targetList) {
	var sortedCodeList = [];
	for (var i = 0; i < targetList.length; i++) {
		sortedCodeList[sortedCodeList.length] = targetList[i].prodCode;
	}
	sortedCodeList.sort();

	var resultList = [];
	for (var i = 0; i < sortedCodeList.length; i++) {
		for (var j = 0; j < targetList.length; j++) {
			if (sortedCodeList[i] == targetList[j].prodCode) {
				resultList[resultList.length] = targetList[j];
			}
		}
	}
	return resultList;
}

function cpcSetCheckedItem() {

	var checkers = document.fm1.checkers;
	var prodCode = document.fm1.prodCode;

	// 遷移前に選択したチェック済みを取得する。
	var checkedList = cpcDecodeCodeData( document.fm1.cpcCheckedCodes );

	// 画面のチェック済みを取得する。
	for (var i = 0; i < checkers.length; i++) {
		// ダミーは無視する。
		for (var j = 0; j < checkedList.length; j++) {
			if (prodCode[i].value == checkedList[j].prodCode) {
				checkers[i].checked = "true";
			}	
		}
	}
}
