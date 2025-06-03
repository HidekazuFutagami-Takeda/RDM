/**
 * <pre>
 *  医師変更履歴のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author SBS　千葉
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


//初期設定
//window.onload = function(){
//
//	COM_Click_flg = true;
//
//	comClickFlgInit();
//
//}





/**
 * <pre>
 *  ページ切替え
 * ページ切替えリンク押下時に呼ばれます。
 * </pre>
 */
function pltPage( pageCntCur ){
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = pageCntCur;

  document.fm1.functionId.value = 'Page';
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  クリア
 * 担当者(クリア)押下時に呼ばれます。
 * </pre>
 */
function jgiNameClear() {

	var jgiName = document.getElementById("jgiName");
	jgiName.value = '';
	//document.fm1.kensakuShinseiBrCode.value = 'kensakuJgiNo';
	document.fm1.kensakuJgiNo.value = '';

}

/**
 * <pre>
 *  クリア
 * 施設(クリア)押下時に呼ばれます。
 * </pre>
 */
function insKanjClear() {

	var kensakuInsKanj = document.getElementById("kensakuInsKanj");
	kensakuInsKanj.value = '';
	var kensakuInsNo = document.getElementById("kensakuInsNo");
	kensakuInsNo.value = '';

}

/**
 * <pre>
 *  クリア
 * 申請者組織(クリア)押下時に呼ばれます。
 * </pre>
 */
function ReqShzClear() {

	var kensakuReqShz = document.getElementById("kensakuReqShz");
	kensakuReqShz.value = '';
	document.fm1.kensakuShinseiBrCode.value = '';
	document.fm1.kensakuShinseiDistCode.value = '';

}

/**
 * <pre>
 *  クリア
 * 担当者組織(クリア)押下時に呼ばれます。
 * </pre>
 */
function sosNameClear() {

	var sosName = document.getElementById("sosName");
	sosName.value = '';
	document.fm1.kensakuSTantouBrCode.value = '';
	document.fm1.kensakuTantouDistCode.value = '';

}

/**
 * <pre>
 *  全クリア
 * (クリア)押下時に呼ばれます。
 * </pre>
 */
function clearText() {

	var kensakuInsNo = document.getElementById("kensakuInsNo");
	kensakuInsNo.value = '';

	var kensakuInsKanj = document.getElementById("kensakuInsKanj");
	kensakuInsKanj.value = '';

	var kensakuDocKanj = document.getElementById("kensakuDocKanj");
	kensakuDocKanj.value = '';

	var kensakuDocKana = document.getElementById("kensakuDocKana");
	kensakuDocKana.value = '';

	var kensakuDocType = document.getElementById("kensakuDocType");
	kensakuDocType.value = '';

	var kensakuDocNo = document.getElementById("kensakuDocNo");
	kensakuDocNo.value = '';

	var kensakuUltDocNo = document.getElementById("kensakuUltDocNo");
	kensakuUltDocNo.value = '';

	var kensakuDocAttribute = document.getElementById("kensakuDocAttribute");
	kensakuDocAttribute.value = '';

	var kensakuMedSch = document.getElementById("kensakuMedSch");
	kensakuMedSch.value = '';

	var kensakuGradYear = document.getElementById("kensakuGradYear");

	kensakuGradYear.value = '';

	var kensakuHuniv = document.getElementById("kensakuHuniv");
	kensakuHuniv.value = '';

	var sosName = document.getElementById("sosName");
	sosName.value = '';
	var jgiName = document.getElementById("jgiName");
	jgiName.value = '';
	var kensakuReqShz = document.getElementById("kensakuReqShz");
	kensakuReqShz.value = '';
	var kensakuReqJgiName = document.getElementById("kensakuReqJgiName");
	kensakuReqJgiName.value = '';

	var updMstFrom = document.getElementById("updMstFrom");
	updMstFrom.value = document.fm1.clearUpdMstFrom.value;

	var updMstTo = document.getElementById("updMstTo");
	updMstTo.value = document.fm1.clearUpdMstTo.value;

	document.fm1.kensakuJgiNo.value = '';
	document.fm1.kensakuShinseiBrCode.value = '';
	document.fm1.kensakuShinseiDistCode.value = '';
	document.fm1.kensakuSTantouBrCode.value = '';
	document.fm1.kensakuTantouDistCode.value = '';

	var selectListChange = document.getElementById("selectListChange");
	selectListChange.value = '0';


	//エラーメッセージエリア非表示
	var errorArea = document.getElementById('formTable00');
	errorArea.style.display = 'none';


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

/**
 * <pre>
 *  表示・非表示
 * (ボタン)押下時に呼ばれます。
 * </pre>
 */
const show = () => {
  var ele = document.getElementById('showAll');

  if (ele.style.display == 'none') {
   ele.style.display = 'block';
  } else {
    ele.style.display = 'none';
  }
};

/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jimSearch() {

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    document.fm1.sortCondition1.value = "";
    document.fm1.sortCondition2.value = "";
    document.fm1.sortId.value = "0";

    document.fm1.functionId.value = "Search"

    document.fm1.selectListChange.value = document.fm1.selectListChange.value;

    // 検索イベント呼び出し
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
  document.fm1.callBack.value = "tmpCallBackShisetsuView";
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

  w = window.open ("",comCreateWindowName(CDC_APPLICATION_ID),"width=1105,height=580,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no");

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
 * <pre>
// * 施設検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShisetsuView(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType, insClass){

    document.fm1.insNo.value = insNo;
    document.fm1.kensakuInsNo.value = document.fm1.insNo.value;

    document.fm1.insAbbrName.value = insFormalName;
    document.fm1.kensakuInsKanj.value = document.fm1.insAbbrName.value;
}


/**
 * 担当者検索POPUP画面を呼び出します。
 *
 */
function jgiNamePop(){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 全てのポップアップを閉じる
  hcpClosePopUp(gCseViewWin, "gCseViewWin");

 // パラメータの設定
  document.fm1.backScreenId.value = "ND501";
  gCseViewWin = jgiNamePopView(gCseViewWin,"tmpCallBackJgiNameView","gCseViewWin");
  return(true);
}

/**
 * 担当者
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function jgiNamePopView(w,callBack,winVarName){

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
//  for (var i = 0; i < checkedCodes.length; i++) {
//    jokenName[jokenName.length] = "cdcCheckedCodes";
//    joken[joken.length] = new Array(checkedCodes[i].value);
//  }


  jokenName[jokenName.length] = "backScreenId";
  joken[joken.length] = new Array(document.fm1.backScreenId.value);
  jokenName[jokenName.length] = "loginJokenSetCd";
  joken[joken.length] = new Array(document.fm1.loginJokenSetCd.value);
  jokenName[jokenName.length] = "selectFlgPop";
  joken[joken.length] = new Array("1");
  jokenName[jokenName.length] = "bumonRankPop";
  joken[joken.length] = new Array(document.fm1.bumonRank.value);
  jokenName[jokenName.length] = "sosCdPop";
  joken[joken.length] = new Array(document.fm1.kensakuTantouSosCd.value);
  jokenName[jokenName.length] = "sosCd";
  joken[joken.length] = new Array(document.fm1.kensakuTantouSosCd.value);
  jokenName[jokenName.length] = "upSosCdPop";
  joken[joken.length] = new Array(document.fm1.upSosCd.value);

  comPostPopup(w,"NC202Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
}

/**
 * <pre>
// * 担当者　検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackJgiNameView(sosCd, bumonSeiName, jgiNo, jgiName, trtCd, brCode,
		distCode, trtGrpCd, trtNm, mrCat, bumonRank, upSosCode){

    document.fm1.kensakuJgiNo.value = jgiNo;
    document.fm1.jgiName.value = jgiName;
}

/**
 * 担当者組織検索POPUP画面を呼び出します。
 *
 */
function sosNamePop(){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 全てのポップアップを閉じる
  hcpClosePopUp(gCseViewWin, "gCseViewWin");

 // パラメータの設定
  document.fm1.backScreenId.value = "ND501";
  gCseViewWin = sosNamePopView(gCseViewWin,"tmpCallBackSosNameView","gCseViewWin");
  return(true);
}

/**
 * 申請者組織検索POPUP画面を呼び出します。
 *
 */
function shinseiSosNamePop(){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 全てのポップアップを閉じる
  hcpClosePopUp(gCseViewWin, "gCseViewWin");

 // パラメータの設定
  document.fm1.backScreenId.value = "ND501";
  gCseViewWin = sosNamePopView(gCseViewWin,"tmpCallBackShinseiSosNameView","gCseViewWin");
  return(true);
}

/**
 * 担当者組織
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function sosNamePopView(w,callBack,winVarName){

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
//  for (var i = 0; i < checkedCodes.length; i++) {
//    jokenName[jokenName.length] = "cdcCheckedCodes";
//    joken[joken.length] = new Array(checkedCodes[i].value);
//  }


  jokenName[jokenName.length] = "backScreenId";
  joken[joken.length] = new Array(document.fm1.backScreenId.value);
  jokenName[jokenName.length] = "loginJokenSetCd";
  joken[joken.length] = new Array(document.fm1.loginJokenSetCd.value);
  jokenName[jokenName.length] = "selectFlgPop";
  joken[joken.length] = new Array("1");

  comPostPopup(w,"NC201Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
}

/**
 * <pre>
// * 担当者組織　検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackSosNameView(bumonRank, sosCd,
		  bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){

    document.fm1.kensakuTantouSosCd.value = sosCd;
    document.fm1.insAbbrName.value = bumonSeiName;
    document.fm1.sosName.value = bumonSeiName;
    document.fm1.kensakuSTantouBrCode.value = brCode;
    document.fm1.kensakuTantouDistCode.value = distCode;
    document.fm1.bumonRank.value = bumonRank;
    document.fm1.upSosCd.value = upSosCode;
}

/**
 * <pre>
// * 申請者組織　検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShinseiSosNameView(bumonRank, sosCd,
		  bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){

    document.fm1.kensakuShinseiSosCd.value = sosCd;
    document.fm1.kensakuReqShz.value = bumonSeiName;
    document.fm1.kensakuShinseiBrCode.value = brCode;
    document.fm1.kensakuShinseiDistCode.value = distCode;
}

/**
 * <pre>
 *  ソート
 * ソート(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jimSort(sortCondition) {
  // 変更内容破棄確認チェック

    //ソートId定義
    document.fm1.sortId.value = sortCondition;

    document.fm1.functionId.value = "Search"
    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);

}




