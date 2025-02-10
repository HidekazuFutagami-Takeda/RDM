/**
 * <pre>
 *  医師固定コード複数入力一覧のJavaScript
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
var DCA_APPLICATION_ID = "DCA";

/**
 * スクリーンID
 */
var DCA_SCREEN_ID		= "DmcDocInputCategories";

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function dcaRegister(w,callBack,winVarName){

	//フォーカスをあてる処理と２度押し対策を共通関数化
	//戻り値がtrueならポップアップ処理を継続 falseならwindowオブジェクトを戻します。
	if(!comPopupPreCheck(w,winVarName)){
		return(w);
	}

	//windowに名前を付ける。(現在日時を付加して)
	var winName = comCreateWindowName(DCA_APPLICATION_ID);

	var heightSize = eval(200 + 15 * 30);

	w = window.open ("",winName,"width=400,height=" + heightSize + ",resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no");


	uri = "JKR100C100Init.action";		//oc4jのmapsアプリを利用してhtmlのテストドライバを利用する場合

	//検索条件などがある場合はパラメタの名前と値を生成して指定する。
	//パラメタの名前を1次元配列で指定
	jokenName = new Array(2);
	jokenName[0] = "rowCnt";
	jokenName[1] = "joinDocNo";
	//パラメタの値を2次元配列で指定
	joken = new Array(2);
	joken[0] = new Array("15");		//行数
	joken[1] = new Array(document.fm1.joinDocNo.value);		//医師固定コード

	/*条件有り呼び出しパターン*/
	comPostPopup(w,uri,DCA_SCREEN_ID,COM_FUNC_REGISTERINIT,callBack,winVarName,jokenName,joken,false);

	w.focus();

	return(w);
}

/**
 * 起動時の処理を記述します。
 * @param functionId 処理イベント。
 */
function dcaLoad(functionId){

	//２度押し対策フラグ初期化
	comClickFlgInit();
	if (functionId == "Init") {
		//初期化の場合、親画面の医師固定コードで設定
		var docNoString = document.fm1.joinDocNo.value;
		var docNoList = docNoString.split(",");
		
		for (var i = 0; i < docNoList.length; i++) {
			var docNoName = "dmcDocInputCategoriesData[" + i + "].docNo";
			document.getElementsByName(docNoName)[0].value = docNoList[i];
		}
	}
	var docNoName = "dmcDocInputCategoriesData[0].docNo";
	document.getElementsByName(docNoName)[0].focus();
}

/**
 * 値を親ウインドウに返しウインドウを閉じます。
 * 値は、親のコールバック関数に引数として渡す方式とします。
 * @param index form内実データのインデックスを受け取ります。
 */
function dcaReturn(){
	var docNo = ctcCreateDocNoString();

	//１件選択パターンの場合は、渡したい値をそのままコールバック関数に渡すことにする。
	eval("window.opener." + document.fm1.callBack.value + "(docNo)");

	dcaClose();
	return(true);
}

/**
 * dcaReturnで、このウインドウを閉じるときに呼び出されます。
 * 単にウインドウを閉じます。
 */
function dcaClose(){
	window.close();
}

function dcaUnLoad(){

	//try catch finally構文はJScript Version 5以降 (IE5.0以降)
	//戻る操作の後にページが表示されなかった場合に、ランタイムエラーが発生するが、
	//それを出力しないようにする。(しかし他では絶対に使わない)
	try{
		eval("window.opener." + document.fm1.winVarName.value + "=null");
	}catch(err){
	}
}

/**
 * <pre>
 *  確定前のチェック
 * 入力チェックを行います。
 * チェックパターンは医師固定コードの
 * 桁数(6),文字タイプ(半角数値)
 * </pre>
 * @return boolean true:OK false:エラー
 */
function dcaChkBeforeSearch(){
	var mesg = "";  //エラーメッセージ(共通チェック)
	var i;
	var rowCnt = eval(document.fm1.rowCnt.value);  //処理件数取得

	for(i = 0;i < rowCnt;i++){
		var checkboxName = "dmcDocInputCategoriesData[" + i + "].checkbox";
		var docNoName = "dmcDocInputCategoriesData[" + i + "].docNo";
		
		if((!document.getElementsByName(checkboxName)[0].checked) && (document.getElementsByName(docNoName)[0].value != "")){
			// 半角数字
			if(!dcaChkNumValue(document.getElementsByName(docNoName)[0].value)){
				if(mesg == ""){
					mesg = "医師固定コード(" + eval(i+1) + "行目)" + MSG_NUMBER;
					document.getElementsByName(docNoName)[0].focus();
				}else{
					mesg = mesg + "\n" + "医師固定コード(" + eval(i+1) + "行目)" + MSG_NUMBER;
				}
			}
		}
	}
	if (mesg != "") {
		alert(mesg);
		return false;
	}
	

	return true;
}

/**
 * <pre>
 *  確定
 * 確定(ボタン)押下時に呼ばれます。
 * </pre>
 */
function dcaSearch(){

	//ボタン２度押し対策を、なるべく早いタイミングで行います。
	//if(!comChkSubmit(COM_CLICK_ALERT))return(false);

	if(dcaChkBeforeSearch()){
		document.fm1.submit_register.click();
	}
}


/********************************************************************/
/*	メッセージ文  管理部											*/
/********************************************************************/
var MSG_NUMBER 		= "には半角数字以外は入力できません。";
/********************************************************************/

/**
 * <pre>
 *  半角数字チェック
 *	パラメータ	：	エラーチェック対象文字列
 *	戻り値		：	true or false
 * </pre>
 */function dcaChkNumValue(str){

	if (str == ""){
		return true;
	}
	for ( vCnt = 0; vCnt < str.length; vCnt++ ){
		vCode = str.charCodeAt(vCnt);
		if(!((vCode >= 0x30) && (vCode <= 0x39))){
			return false;
		}
	}
	return true;
}
 
 /**
  * 画面で入力されている医師固定コードの
  * オブジェクト配列を作成する。
  *
  * @return 入力済み医師コード
  */
 function ctcCreateDocNoString() {

 	var docNoString = "";

	var i;
	var rowCnt = eval(document.fm1.rowCnt.value);  //処理件数取得

	for(i = 0;i < rowCnt;i++){
		var checkboxName = "dmcDocInputCategoriesData[" + i + "].checkbox";
		var docNoName = "dmcDocInputCategoriesData[" + i + "].docNo";
		
		if((!document.getElementsByName(checkboxName)[0].checked) && (document.getElementsByName(docNoName)[0].value != "")){
			if (docNoString == "") {
				docNoString = "" + document.getElementsByName(docNoName)[0].value;
			} else {
				docNoString = docNoString + "," + document.getElementsByName(docNoName)[0].value;
			}
		}
	}

 	return docNoString;
 }
