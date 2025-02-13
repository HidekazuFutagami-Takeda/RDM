/**
 * <pre>
 *  JIS府県武田市区郡複数選択のJavaScript
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
var CTC_APPLICATION_ID = "CTC";

/**
 * スクリーンID
 */
var CTC_SCREEN_ID = "CatTkCityCombo";


/**
 * <pre>
 *  デバッグ用関数
 * gCtcDebug = true でデバッグします。
 * </pre>
 */
var gCtcDebug = false;
function ctcDebug(str){
	if(gCtcDebug) alert(str);
	return(true);
}

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function ctcView(w, callBack, winVarName){

	//****************************************************************
	// ポップアップ起動中にウィンドウが閉じられると
	// windowオブジェクトがString型に変換されてしまう場合があるため
	// 型変換された場合はNULLをセットして初期化する
	//****************************************************************
	if(typeof(w) == 'string') {
		w = null;
	} else {
		if(!comPopupPreCheck(w,winVarName)) return(w);
	}

	// ウインドウ生成
	w = window.open (
		"",
		comCreateWindowName(CTC_APPLICATION_ID),
		"width=530,height=660,resizable=no,status=no,toolbar=no,scrollbars=yes,titlebar=no"
	);

	// パラメタの設定
	var checkedCodes = document.fm1.checkedCodes;
	var jokenName = [];
	var joken = [];
	
	for (var i = 0; i < checkedCodes.length; i++) {
		jokenName[jokenName.length] = "checkedCodes";
		joken[joken.length] = new Array(checkedCodes[i].value);
	}

	jokenName[jokenName.length] = "sosCd";
	jokenName[jokenName.length] = "jgiNo";
	jokenName[jokenName.length] = "trtGrpCd";
	
	joken[joken.length] = new Array(document.fm1.sosCdC040.value);
	joken[joken.length] = new Array(document.fm1.jgiNoC040.value);
	joken[joken.length] = new Array(document.fm1.trtGrpCd.value);

	// 条件有り呼び出しパターン
	comPostPopup(w,"JKR100C040Init.action",CTC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);
	w.focus();

	return(w);
}

/**
 * 起動時の処理
 */
function ctcLoad(){

	comClickFlgInit();	// ２度押し対策フラグ初期化

	//ウインドウの名前と親ウインドウの名前をサブミットエリアに保存する。
	// セッションから取得したチェック済み都道府県・市区郡を画面に反映する。
	var checkedList = ctcDecodeCodeData( document.fm1.checkedCodes );
	var fmDataAddrCodes   = document.fm1.addrCodePref;
	var fm1AddrCodes      = document.fm1.addrCodePrefChk;
	var fmDataTkCityCodes = document.fm1.tkCityCd;
	var fm1TkCityCodes    = document.fm1.tkCityCdChk;
	for (var i = 0; i < checkedList.length; i++) {
		// 都道府県
		if (checkedList[i].tkCityCd == "") {
			for (var j = 0; j < fmDataAddrCodes.length; j++) {
				if (checkedList[i].addrCodePref == fmDataAddrCodes[j].value) {
					fm1AddrCodes[j].checked = true;
				}
			}
		// 市区郡
		} else {
			for (var j = 0; j < fmDataTkCityCodes.length; j++) {
				if (
					checkedList[i].addrCodePref == document.fm1.selectedAddrCodePref.value
				 && checkedList[i].tkCityCd == fmDataTkCityCodes[j].value
				) {
					fm1TkCityCodes[j].checked = true;
				}
			}
		}
	}
}

/**
 * 終了時の処理
 */
function ctcUnLoad(){
	try{
		eval("window.opener." + document.fm0.winVarName.value + "=null");
	}catch(err){
	}
}

/**
 * チェックボックスクリック時
 */
function ctcCheckMaxSize(inputObject) {
	var checkedList = ctcSortCode( ctcToUnique(ctcCreateCheckedList()) );
	// チェック済み数のチェック
	if (checkedList.length > 10) {
		inputObject.checked = false;
		var msg = "10個までしか選択できません。"
		alert(msg);
	}
}

/**
 * 都道府県市区郡の名称とコードを保持する
 * オブジェクトクラス
 */
function CtcCodeData() {
	this.addrCodePref = "";    // JIS府県コード
	this.addrNamePref = "";    // JIS府県名
	this.tkCityCd     = "";    // 武田市区郡コード
	this.tkCityName   = "";    // 武田市区郡名
}

/**
 *  検索（都道府県アンカークリック）
 */
function ctcSearch(paramAddrCodePref){

	if(!comChkSubmit(COM_CLICK_ALERT))return(false);	//ボタン２度押し対策

	// チェック済の都道府県・市区郡を、Sevlet送信用に「,」区切りに
	// エンコードした状態の文字列配列で取得する。
	var checkedList = ctcEncodeCodeData( ctcCreateCheckedList() );

	// チェック済みのコードを送信フォームにhidden属性でタグ追加する。
	document.getElementById("checkedCodesDiv").innerHTML = "";
	for (var i = 0; i < checkedList.length; i++) {
		document.getElementById("checkedCodesDiv").innerHTML += ""
			+ "<input type='hidden' name='checkedCodes' value='"
			+ checkedList[i]
			+ "'>";
	}
	
	document.fm1.selectedAddrCodePref.value = paramAddrCodePref;	// クリックされたJIS府県
	// 検索イベント呼び出し
    document.fm1.submit_search.click();
}

/**
 * チェック済みを記憶するためにServlet送信用の
 * 文字列を作成する。
 *
 * @param targetList 「new CtcCodeData()」で作成されるオブジェクト配列
 * @return {Array} 結果配列
 */
function ctcEncodeCodeData(targetList) {
	var resultList = [];
	for (var i = 0; i < targetList.length; i++) {
		resultList[resultList.length] = ""
			+ targetList[i].addrCodePref + ","
			+ ctcEncodeDecimal( targetList[i].addrNamePref ) + ","
			+ targetList[i].tkCityCd + ","
			+ ctcEncodeDecimal( targetList[i].tkCityName );
	}
	return resultList;
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
function ctcEncodeDecimal(targetText){
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
 * ctcEncodeDecimal関数によって置き換えられた文字列を
 * 完全な参照文字列にする。
 *
 * @param  s 対象文字列
 * @return {String}参照文字列に変換された文字列
 */
function ctcDecodeDecimal(s) {
	while (s.indexOf("[") != -1) {
		 s = s.replace("[", "&#");
	}
	while (s.indexOf("]") != -1) {
		s = s.replace("]", ";");
	}
	return s;
}

/**
 * Sevletから取得したチェック済みをJavaScriptで
 * 使用できるように、オブジェクト配列に変換する。
 *
 * @param  targetList コードと名称を「,」区切りで整形した<input>フォーム配列
 * @return {Array} 結果配列
 */
function ctcDecodeCodeData(targetList) {
	var resultList = [];
	for (var i = 0; i < targetList.length; i++) {
		// ダミーは対象外とする。
		if (targetList[i].value != "dummy") {
			var codes = targetList[i].value.split(",");
			var codeData = new CtcCodeData();
			codeData.addrCodePref = codes[0];
			codeData.addrNamePref = codes[1];
			codeData.tkCityCd     = codes[2];
			codeData.tkCityName   = codes[3];
			resultList[resultList.length] = codeData;
		}
	}
	return resultList;
}

/**
 * 選択して閉じる
 *
 * チェックした都道府県と市区郡をまとめて
 * オブジェクトとして配列に設定してから
 * ポップアップを閉じる。
 */
function ctcSelectClose() {

	// チェック済の都道府県・市区郡をオブジェクト配列で取得する。
	var checkedList = ctcCreateCheckedList();
	// コードで一意にしてから昇順でソートする。
	var resultList = ctcSortCode( ctcToUnique(checkedList) );
	// コールバック関数に結果リストを渡してポップアップを閉じる。
	eval("window.opener." + document.fm1.callBack.value + "( resultList, ctcEncodeCodeData(resultList) )");
	ctcClose();
}

/**
 * 画面でチェックされている都道府県と市区郡の
 * オブジェクト配列を作成する。
 *
 * @return {Array} チェック済み都道府県・市区郡オブジェクト配列
 */
function ctcCreateCheckedList() {

	var checkedList = [];

	// 都道府県
	// 府県checkbox項目
	var addrCodePrefChk = document.fm1.addrCodePrefChk;
	if (addrCodePrefChk.length) {
		for (var i = 0; i < addrCodePrefChk.length; i++) {
			if (addrCodePrefChk[i].checked) {
				var codeData = new CtcCodeData();
				codeData.addrCodePref = document.fm1.addrCodePref[i].value;
				codeData.addrNamePref = document.fm1.addrNamePref[i].value;
				codeData.tkCityCd     = "";
				codeData.tkCityName   = "";
				checkedList[checkedList.length] = codeData;
			}
		}
	}

	// 市区郡
	// 市区郡checkbox項目
	var tkCityCdChk = document.fm1.tkCityCdChk;
	if (tkCityCdChk.length) {
		for (var i = 0; i < tkCityCdChk.length; i++) {
			if (tkCityCdChk[i].checked) {
				var codeData = new CtcCodeData();
				codeData.addrCodePref = document.fm1.selectedAddrCodePref.value;
				codeData.addrNamePref = "";
				codeData.tkCityCd     = document.fm1.tkCityCd[i].value;
				codeData.tkCityName   = document.fm1.tkCityName[i].value;
				checkedList[checkedList.length] = codeData;
			}
		}
	}

	// 遷移前に選択した市区郡
	var checkedCodes = ctcDecodeCodeData( document.fm1.checkedCodes );
	for (var i = 0; i < checkedCodes.length; i++) {
		// 都道府県と選択中の市区郡は、画面でのチェックを
		// 優先するために、ここでは対象外とする。
		if (
		   checkedCodes[i] != "dummy"
		&& checkedCodes[i].tkCityCd != ""
		&& checkedCodes[i].addrCodePref != document.fm1.selectedAddrCodePref.value)
		{
			checkedList[checkedList.length] = checkedCodes[i];
		}
	}
	return checkedList;
}

/**
 * addrCodePrefとtkCityCdで昇順にソートする。
 * :example
 *     [0] = 青森県(02)
 *     [1] = 北海道(01)
 *     [2] = 岩手県(03)
 *     [3] = 青森県(02)-弘前市(002)
 *   ↓
 *     [0] = 北海道(01)
 *     [1] = 青森県(02)
 *     [2] = 青森県(02)-弘前市(002)
 *     [3] = 岩手県(03)
 *
 * @param  targetList 「new CtcCodeData()」で作成されるオブジェクト配列
 * @return {Array} 結果配列
 */
function ctcSortCode(targetList) {
	var tmp = "";
	var sortedCodeList = [];
	for (var i = 0; i < targetList.length; i++) {
		sortedCodeList[sortedCodeList.length] = ctcCreateCodeString(targetList[i]);
	}
	sortedCodeList.sort();

	var resultList = [];
	for (var i = 0; i < sortedCodeList.length; i++) {
		for (var j = 0; j < targetList.length; j++) {
			if (sortedCodeList[i] == ctcCreateCodeString(targetList[j])) {
				resultList[resultList.length] = targetList[j];
			}
		}
	}
	return resultList;
}

/**
 * addrCodePrefとtkCityCdの組み合わせで一意にする。
 * 
 * @param  targetList 「new CtcCodeData()」で作成されるオブジェクト配列
 * @return {Array} 結果配列
 */
function ctcToUnique(targetList) {
	var resultList = [];
	for (var i = 0; i < targetList.length; i++) {
		var unique = true;
		for (var j = 0; j < resultList.length; j++) {
			if (ctcCreateCodeString(targetList[i]) == ctcCreateCodeString(resultList[j])) {
				unique = false;
				break;
			}
		}
		if (unique) {
			resultList[resultList.length] = targetList[i];
		}
	} //alert(resultList.length);
	return resultList;
}

/**
 * addrCodePrefとtkCityCdを組み合わせた文字列を作成する。
 *
 * @param  codeData 「new CtcCodeData()」で作成されるオブジェクト
 * @return {String} 結合されたコード
 */
function ctcCreateCodeString(codeData) {
	var res = "";
	res = codeData.addrCodePref;
	// tkCityCdが存在しない場合は、"000"の埋め込みを行い桁数を合わせる。
	res += (codeData.tkCityCd == "") ? "000" : codeData.tkCityCd;
	return res;
}

/**
 * ウインドウを閉じる。
 */
function ctcClose(){
	window.close();
}
