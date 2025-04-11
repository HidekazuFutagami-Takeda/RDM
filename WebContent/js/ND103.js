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

var msgContent = ""; //確認メッセージ
var gChsViewWin = null;        // 所属学会POPUP用
var gChpViewWin = null;        // 公的機関POPUP用
var gCdcViewWin = null;        // 出身所属部科/勤務先情報 所属部科POPUP用
var gCseViewWin = null;        // 勤務先情報 施設POPUP用


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
 *  全メッセージ格納用配列
 * 当画面で使用する全メッセージが格納されます。
 * </pre>
 */
var gMsg = new Array();
function tmpCdcView(){

	// 2度押し対策
	  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	  // 全てのポップアップを閉じる
	  hcpClosePopUp(gCdcViewWin, "gCdcViewWin");

	 // パラメータの設定
	  //document.fm1.cdcCheckedCodes.value = "";
	  document.fm1.paramInsNo.value = document.fm1.insNoSk.value;
	  document.fm1.insAbbrName.value = document.fm1.insAbbrName.value;


	  document.fm1.backScreenId.value = "ND103";
	  gCdcViewWin = cdcView(gCdcViewWin,"tmpCallBackShozokuViewRDM","gCdcViewWin");
	  return(true);
	}

function tmpCallBackShozokuViewRDM(deptCode,DeptKj,DeptKn){
	document.fm1.deptCodeAf.value = deptCode;
	document.fm1.deptKj.value = DeptKj;
}


/**
 * 所属部科POPUP画面を呼び出します。
 *
 */
//function tmpCdcView(){

// 2度押し対策
  //if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 全てのポップアップを閉じる
  //hcpClosePopUp(gCdcViewWin, "gCdcViewWin");


  //document.fm1.callBack.value = "ND103";
 //gCdcViewWin = cdcView(gCdcViewWin,"tmpCallBackShozokuViewRDM","gCdcViewWin");
  //return(true);
//}

/**
 * <pre>
 * 出身所属部科POPUP　コールバック関数。
 * </pre>
 */
//function tmpCallBackShozokuViewRDM(deptCode,DeptKj,DeptKn){
//gCdcViewSelId 0:出身所属部科,1:勤務先情報 所属部科
	//document.fm1.deptCodeAf.value = deptCode;
	//document.fm1.deptKj.value = DeptKj;
	//document.fm1.deptKn.value = DeptKn;
//}

/**
 * <pre>
 * 施設検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShisetsuView(insAbbrName,insNo){
    document.fm1.searchInsNo.value = insNo;
    document.fm1.searchInsNm.value = insAbbrName;
//    document.fm1.searchInsHoInsType.value = hoInsType;
//    document.fm1.searchInsInsClass.value = insClass;

}
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
 *  施設　クリアボタン押下後に呼ばれます
 *  クリア機能
 * </pre>
 */
function sosClear() {

	//施設固定C,施設名削除
	document.fm1.insAbbrName.value = "";
	document.fm1.insNoSk.value	= "";

}

/**
 * <pre>
 *  所属部科　クリアボタン押下後に呼ばれます
 * 　クリア機能
 * </pre>
 */
function deptClear() {

	document.fm1.deptCodeAf.value = "";
	document.fm1.deptKn.value	= "";
	document.fm1.deptKj.value = "";


}

/**
 * <pre>
 *  ポップアップウィンドウオブジェクトチェック関数
 * </pre>
 *  ポップアップ起動中にウィンドウが閉じられた時に
 *  ウィンドウオブジェクトがstring型に変更される場合があるため、
 *  ウィンドウオブジェクトの型をチェックしてJSエラーを回避します。
 *
 * @return true：正常,false：異常
 */
function hcpCheckPopUp() {

  // 本画面で使用する全ポップアップウィンドウオブジェクトを対象にチェック
  if(typeof(gChsViewWin) == 'string') return false;     // 所属学会編集ポップアップ
  if(typeof(gChpViewWin) == 'string') return false;     // 公的機関編集ポップアップ
  if(typeof(gCdcViewWin) == 'string') return false;     // 出身所属部科ポップアップ
  if(typeof(gCseViewWin) == 'string') return false;     // 勤務先情報 施設ポップアップ
//  if(typeof(gCsdViewWin) == 'string') return false;     // 勤務先情報 所属部科ポップアップ
  // 全ウィンドウが正常ならばtrue
  return true;
}

////////////////////////////////////////////////////
/**
 * <pre>
 *  全てのポップアップを閉じます。
 * </pre>
 * @param targetWin 	対象ウィンドウオブジェクト
 * @param targetWinName	対象ウィンドウ名称
 */
function hcpClosePopUp(targetWin,targetWinName){
  if(hcpCheckPopUp()){
	  // 対象ポップアップが存在すればフォーカスを当てる
	  if(targetWin != null){
		  targetWin.focus();
	  }

	  // 所属学会編集ポップアップ
	  if(gChsViewWin != null && targetWinName != "gChsViewWin"){
		  gChsViewWin.close();
		  gChsViewWin = null;
	  }
	  // 公的機関編集ポップアップ
	  if(gChpViewWin != null && targetWinName != "gChpViewWin"){
		  gChpViewWin.close();
		  gChpViewWin = null;
	  }
	  // 出身所属部科ポップアップ
	  if(gCdcViewWin != null && targetWinName != "gCdcViewWin"){
		  gCdcViewWin.close();
		  gCdcViewWin = null;
	  }
	  // 勤務先情報 施設ポップアップ
	  if(gCseViewWin != null && targetWinName != "gCseViewWin"){
		  gCseViewWin.close();
		  gCseViewWin = null;
	  }
//	  // 勤務先情報 所属部科ポップアップ
//	  if(gCsdViewWin != null && targetWinName != "gCsdViewWin"){
//		  gCsdViewWin.close();
//		  gCsdViewWin = null;
//	  }
  }
}

/**
 * <pre>
 *  一時保存ボタン押下後に呼ばれます
 * エラーチェック　保存処理
 * </pre>
 */
function reqND103Save() {

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


// 申請画面へボタン
function ND311Page(){

	//ND311_医師勤務先追加 - 申請内容確認
	document.fm1.screenId.value	= "ND311";
    document.fm1.functionId.value = "Init";

 	comSubmitForAnyWarp(fm1);

}




/**
 * 施設検索POPUP画面を呼び出します。
 *
 */
function tmpCseView(){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 全てのポップアップを閉じる
  hcpClosePopUp(gCseViewWin, "gCseViewWin");

 // パラメータの設定
  document.fm1.backScreenId.value = "ND103";
  gCseViewWin = cseAbbrView(gCseViewWin,"tmpCallBackShisetsuView","gCseViewWin");
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
function cseAbbrView(w,callBack,winVarName){

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

  w = window.open ("",comCreateWindowName(CDC_APPLICATION_ID),"width=1100,height=800,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no");

  // パラメタの設定
  var checkedCodes = document.fm1.cdcCheckedCodes;
  var jokenName = [];
  var joken = [];
//  for (var i = 0; i < checkedCodes.length; i++) {
//    jokenName[jokenName.length] = "cdcCheckedCodes";
//    joken[joken.length] = new Array(checkedCodes[i].value);
//  }


  jokenName[jokenName.length] = "backScreenId";
  joken[joken.length] = new Array(document.fm1.backScreenId.value);
  jokenName[jokenName.length] = "loginJokenSetCd";
  joken[joken.length] = new Array(document.fm1.loginJokenSetCd.value);

  comPostPopup(w,"NC203Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
}


/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function cdcView(w,callBack,winVarName){

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

  w = window.open ("",comCreateWindowName(CDC_APPLICATION_ID),"width=530,height=660,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no");

  // パラメタの設定
  var checkedCodes = document.fm1.cdcCheckedCodes;
  var jokenName = [];
  var joken = [];
  //var jokenName = document.fm1.insAbbrName.value;
  //var joken = document.fm1.insNoSk.value;
//  for (var i = 0; i < checkedCodes.length; i++) {
//    jokenName[jokenName.length] = "cdcCheckedCodes";
//    joken[joken.length] = new Array(checkedCodes[i].value);
//  }
  jokenName[jokenName.length] = "paramInsNo";
  joken[joken.length] = new Array(document.fm1.paramInsNo.value);

  jokenName[jokenName.length] = "backScreenId";
  joken[joken.length] = new Array(document.fm1.backScreenId.value);

//  jokenName[jokenName.length] = "callBack";
//  joken[joken.length] = new Array(document.fm1.callBack.value);



  comPostPopup(w,"NC204Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
}

/**
 * <pre>
 * 施設検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShisetsuView(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType,insClass){

    document.fm1.insNoSk.value = insNo;
    document.fm1.insAbbrName.value = insAbbrName;
    document.fm1.insClass.value = insClass;
    document.fm1.hoInsType.value = hoInsType;

}



function jimClear(name) {
	if (!comChkClickFlg(COM_CLICK_ALERT)) {
		return false;
	}
	if (name == 'abbrName') {
		document.fm1.postInsAbbrName.value = "";
		document.fm1.postInsNo.value = "";
		document.fm1.postUltInsNo.value = "";
		document.fm1.postHoInsType.value = "";
	}
	if (name == 'shozokubukaName') {
		document.fm1.postDeptKj.value = "";
		document.fm1.postDeptCode.value = "";
		document.fm1.postDeptKn.value = "";
	}
}


/**
 * <pre>
 *  全てのポップアップを閉じます。
 * </pre>
 * @param targetWin 	対象ウィンドウオブジェクト
 * @param targetWinName	対象ウィンドウ名称
 */
function nd101ClosePopUp(targetWin,targetWinName){

  if(hcpCheckPopUp()){

    // 対象ポップアップが存在すればフォーカスを当てる
    if(targetWin != null){
      targetWin.focus();
    }


    // NC203_施設検索ポップアップ
    if(gChpViewWin != null && targetWinName != "gCseViewWin"){
      gChpViewWin.close();
      gChpViewWin = null;
    }
    // NC204_所属部科選択ポップアップ
    if(gChsViewWin != null && targetWinName != "gCdcViewWin"){
      gChsViewWin.close();
      gChsViewWin = null;
    }


  }
}

//初期設定
window.onload = function(){

	comClickFlgInit();
	//ダイアログメッセージ定義
	var dialog = document.fm1.dialog.value;
	//エラーメッセージ
    var msgStr = document.fm1.msgStr.value;

//	if (msgStr != "") {
//		document.fm1.screenId.value	= "ND103";
//	    document.fm1.functionId.value = "Init"
//
//		comSubmitForAnyWarp(fm1);
//	}
//	if (dialog != "") {
//		if (window.confirm(dialog)) {//OK押下の場合
//
//			//ND311_医師勤務先追加 - 申請内容確認
//			document.fm1.screenId.value	= "ND311";
//		    document.fm1.functionId.value = "Init"
//
//			comSubmitForAnyWarp(fm1);
//
//	     }
//		 //Cancel押下の場合
//		 return false;
//	}
	return false;
}








