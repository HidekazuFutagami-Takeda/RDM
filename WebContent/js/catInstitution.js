/**
 * <pre>
 *	施設選択のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author BHH 張
 */

/**
 * <pre>
 *	アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var CII_APPLICATION_ID = "CII";

/**
 * スクリーンID
 */
var CII_SCREEN_ID		= "CatInstitution";

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *			 このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function ciiView(w,callBack,winVarName){

	//フォーカスをあてる処理と２度押し対策を共通関数化
	//戻り値がtrueならポップアップ処理を継続 falseならwindowオブジェクトを戻します。
	if(!comPopupPreCheck(w,winVarName)){
		return(w);
	}

	//windowに名前を付ける。(現在日時を付加して)
	var winName = comCreateWindowName(CII_APPLICATION_ID);

	//ウインドウの体裁(幅や高さなど)はここで指定します。
	w = window.open ("",winName,"width=755,height=600,resizable=no,status=no,toolbar=no,scrollbars=yes,titlebar=no");

	uri = "JKR100C060Init.action";		//oc4jのmapsアプリを利用してhtmlのテストドライバを利用する場合

	jokenName = new Array(3);
	joken = new Array(3);
	jokenName[0] = "sosCd";
	jokenName[1] = "jgiNo";
	jokenName[2] = "trtGrpCd";
	joken[0] = new Array(document.fm1.sosCdC060.value);
	joken[1] = new Array(document.fm1.jgiNoC060.value);
	joken[2] = new Array(document.fm1.trtGrpCd.value);
	/*条件有り呼び出しパターン*/
	comPostPopup(w,uri,CII_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

	w.focus();

	return(w);
}

/**
 * 起動時の処理を記述します。
 */
function ciiLoad(){

	//２度押し対策フラグ初期化
	comClickFlgInit();
	document.fm1.insKanjiSrch.focus();
}

/**
 * 値を親ウインドウに返しウインドウを閉じます。
 * 値は、親のコールバック関数に引数として渡す方式とします。
 * @param index form内実データのインデックスを受け取ります。
 */
function ciiReturn(index){
	//ボタン２度押し対策を、なるべく早いタイミングで行います。
	if(!comChkSubmit(COM_CLICK_ALERT))return(false);

	var insNo			= "";
	var insAbbrName		= "";
	var addrCodePref	= "";
	var tkCityCd	= "";

	//fmDataよりindexに該当するデータを探し出します。
	//配列の場合とそうでない場合を対応する必要有り
	if(document.fm1.insNo.length){
		//配列の場合
		insNo			= document.fm1.insNo[index].value;
		insAbbrName		= document.fm1.insAbbrName[index].value;
		addrCodePref	= document.fm1.addrCodePref[index].value;
		tkCityCd		= document.fm1.tkCityCd[index].value;
	}
	else{
		//１件しかないときの処理
		insNo			= document.fm1.insNo.value;
		insAbbrName		= document.fm1.insAbbrName.value;
		addrCodePref	= document.fm1.addrCodePref.value;
		tkCityCd		= document.fm1.tkCityCd.value;
	}
	//１件選択パターンの場合は、渡したい値をそのままコールバック関数に渡すことにする。
	eval("window.opener." + document.fm1.callBack.value + "(insNo,insAbbrName,addrCodePref,tkCityCd)");

	ciiClose();
	return(true);
}

/**
 * ciiReturnで、このウインドウを閉じるときに呼び出されます。
 * 単にウインドウを閉じます。
 */
function ciiClose(){
	window.close();
}

function ciiUnLoad(){
	try{
		eval("window.opener." + document.fm0.winVarName.value + "=null");
	}catch(err){
	}
}

/**
 * <pre>
 *	検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function ciiSearch(){

//	var checkSingle = "";
//	var checkKanji = "";
//	var checkNumber = "";
//	var kanaMess = "";      //カナチェック用エラーメッセージ保存変数
//	var kanjiMess = "";     //漢字チェック用エラーメッセージ保存変数
//	var numberMess = "";    //数値チェック用エラーメッセージ保存変数
//	var errMess= "";        //表示用エラーメッセージ
//	var newLineKanji = "";  //改行コード
//	var newLineKana = "";   //改行コード


	//施設検索用漢字名の入力チェック(記号文字数20)
//	checkKanji = document.fm1.insKanjiSrch.value;
//	if(checkKanji != ""){
//		kanjiMess = ciiChkNoSign(checkKanji);
//		if(kanjiMess != ""){
//			newLineKanji = "\n";
//		}
//	}

	//施設検索用カナ名の入力チェック(半角文字数20)
	//全角カナの入力チェック(全角文字数10)
//	checkSingle = document.fm1.insKanaSrch.value;
//	if(checkSingle != ""){
//		kanaMess = comChkFullSizeChar(checkSingle,'施設名(半角カナ)','20');
//		if(kanaMess != ""){
//			newLineKana = "\n";
//		}
//	}

	//施設検索用施設固定コードの入力チェック(数値文字数14)
//	checkNumber = document.fm1.insNoSrch.value;
//	if(checkNumber != ""){
//		numberMess = ciiChkNumValue(checkNumber);
//		if(numberMess != ""){
//			newLineNum = "\n";
//		}
//	}

//	if((kanjiMess != "") || (kanaMess != "") || (numberMess != "")){
//		errMess = kanjiMess + newLineKanji + kanaMess + newLineKana + numberMess;
//		alert(errMess);
//		if(kanjiMess != ""){
//		    document.fm1.insKanjiSrch.focus();
//		}else if(kanaMess != ""){
//		    document.fm1.insKanaSrch.focus();
//		}else if(numberMess != ""){
//		    document.fm1.insNoSrch.focus();
//		}
//		return false;
//	}

	//ボタン２度押し対策をなるべく早くやる(実際のSubmitのときではなく)
	if(!comChkSubmit(COM_CLICK_ALERT))return(false);

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;

    // 検索イベント呼び出し
    document.fm1.submit_search.click();
}

/**
 * <pre>
 *	表示リセット
 * 表示リセット(リンク)押下時に呼ばれます。
 * </pre>
 */
function ciiReset(){
	//画面初期化する
    document.fm1.pageCntCur.value = 1;

    // 検索イベント呼び出し
    document.fm1.reset_search.click();
}

/**
 * 検索文字列の使用不可文字
 * @param str 入力された検索文字列
 * @return mess エラーメッセージ
 */
function ciiChkNumValue(str){
	var mess = "";
	var flg = 0;
	for ( vCnt = 0; vCnt < str.length; vCnt++ ){
		vCode = str.charCodeAt(vCnt);
		if(!((vCode >= 0x30) && (vCode <= 0x39))){
			break;
		}
		flg++;
	}

	if((flg != str.length) && (str.length > 14)){
		mess += "施設固定コードには半角数字以外は入力できません。\n";
		mess += "施設固定コードの制限字数を越えています。";
	}else if(flg != str.length){
		mess += "施設固定コードには半角数字以外は入力できません。";
	}else if(flg > 14){
		mess += "施設固定コードの制限字数を越えています。";
	}
	return mess;
}

/**
 * 検索文字列の使用不可文字
 * @param str 入力された検索文字列
 * @return mess エラーメッセージ
 */
function ciiChkNoSign(str){
	var mess = "";
	var flg = 0;
	for ( vCnt = 0; vCnt < str.length; vCnt++ ){
		vCode = str.charCodeAt(vCnt);

		if (
			vCode == 0x21 || // !
			vCode == 0x24 || // $
			vCode == 0x25 || // % 検索可能だがパターンマッチを行う為指定
			vCode == 0x26 || // &
			vCode == 0x27 || // '
			vCode == 0x28 || // (
			vCode == 0x29 || // )
			vCode == 0x2a || // *
			vCode == 0x2c || // ,
			vCode == 0x2d || // -
			vCode == 0x3b || // ;
			vCode == 0x3d || // =
			vCode == 0x3e || // >
			vCode == 0x3f || // ?
			vCode == 0x5b || // [
			vCode == 0x5d || // ]
			vCode == 0x5f || // _ 検索可能だがパターンマッチを行う為指定
			vCode == 0x7b || // {
			vCode == 0x7c || // |
			vCode == 0x7d || // }
			vCode == 0x7e	 // ~
			)
		{
			break;
		}
		flg++;
	}
	if((flg != str.length) && (str.length > 40)){
		mess += "施設名(漢字)には半角記号は入力できません。\n";
		mess += "施設名(漢字)の制限字数を越えています。";
	}else if(flg != str.length){
		mess += "施設名(漢字)には半角記号は入力できません。";
	}else if(flg > 40){
		mess += "施設名(漢字)の制限字数を越えています。";
	}
	return mess;
}

