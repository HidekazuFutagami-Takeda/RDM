/**
 * <pre>
 *  組織従業員展開選択のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author SBS 内海
 */

/**
 *  アプリケーションIDを定義
 */
var RCSE_APPLICATION_ID = "RCSE";

/**
 * スクリーンID
 */
var RCSE_SCREEN_ID = "RdmCatSosExpand";

/**
 * タイトル(組織選択)
 */
var CSE_TITLE_SOS = "組織選択";

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @param clearProc 呼び出し元のクリア処理名をStringで受け取ります。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function cseView(w, callBack, winVarName, clearProc){
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
    comCreateWindowName(RCSE_APPLICATION_ID),
    "width=500,height=570,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no"
  );

  cseParentClearProc	= clearProc;

  ix1 = 0;
  jokenName = new Array();	//パラメタの名前を1次元配列で指定
  joken = new Array();		//パラメタの値を2次元配列で指定

  jokenName[ix1] = "selectFlgPop";
  joken[ix1++] = new Array(document.fm1.selectFlgPop.value);
  jokenName[ix1] = "initSosCdPop";
  joken[ix1++] = new Array(document.fm1.initSosCdPop.value);
  jokenName[ix1] = "trtCdPop";
  joken[ix1++] = new Array(document.fm1.trtCdPop.value);

  /*条件有り呼び出しパターン*/
  comPostPopup(w,"NC201Init.action",RCSE_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
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
function nc202CseView(w, callBack, winVarName, clearProc){
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
    comCreateWindowName(RCSE_APPLICATION_ID),
    "width=500,height=570,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no"
  );

  cseParentClearProc	= clearProc;

  ix1 = 0;
  jokenName = new Array();	//パラメタの名前を1次元配列で指定
  joken = new Array();		//パラメタの値を2次元配列で指定

  jokenName[ix1] = "selectFlgPop";
  joken[ix1++] = new Array(document.fm1.selectFlgPop.value);
  jokenName[ix1] = "initSosCdPop";
  joken[ix1++] = new Array(document.fm1.initSosCdPop.value);
  jokenName[ix1] = "trtCdPop";
  joken[ix1++] = new Array(document.fm1.trtCdPop.value);
  jokenName[ix1] = "initSosCdPop";
  joken[ix1++] = new Array(document.fm1.initSosCdPop.value);
  jokenName[ix1] = "addrCodePrefPop";
  joken[ix1++] = new Array(document.fm1.addrCodePrefPop.value);
  jokenName[ix1] = "tkCityCdPop";
  joken[ix1++] = new Array(document.fm1.tkCityCdPop.value);
  jokenName[ix1] = "sosCdPop";
  joken[ix1++] = new Array(document.fm1.sosCdPop.value);
  jokenName[ix1] = "upSosCdPop";
  joken[ix1++] = new Array(document.fm1.upSosCdPop.value);

  /*条件有り呼び出しパターン*/
  comPostPopup(w,"NC202Init.action",RCSE_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
}


/**
 * 起動時の処理を記述します。
 *
 * g_switch_ajax 1の場合は手動展開、2の場合は自動展開
 */

var g_switch_ajax;
function cseLoad(selectFlg){
  //２度押し対策フラグ初期化
  comClickFlgInit();
  // 選択フラグにより、タイトルを設定
  //cseSetTitle();

  g_switch_ajax = selectFlg;

  // 初期組織を展開
  AjaxStatus.init();
  if (document.fm1.initSosCd) {
     g_initSosCd = document.fm1.initSosCd;
  }
  if (document.fm1.initBumonRank) {
     g_initBumonRank = document.fm1.initBumonRank;
  }
  g_selectFlg = selectFlg;

  //選択内容の復元処理
  if (g_initSosCd.length) {
    g_initLoopCount = 0;
    initAjaxAction();
  }
}

/**
 * 初期組織を展開する。
 */
var g_initSosCd = {};
var g_initBumonRank = {};
var g_initLoopCount = 0;
function initAjaxAction() {

  // 展開終了時はフォーカスを当てて関数を終了する。
  if (g_initLoopCount >= g_initSosCd.length) {
    initAjaxFocus();
    return;
  }
  // ダミーは無視する。
  if (g_initSosCd[g_initLoopCount].value == "dummy") {
    g_initLoopCount++;
  }
  // 通信中でなければ非同期通信を実行する。
  if (AjaxStatus.toBusy()) {
    rcseCallAjax(
      g_initSosCd[g_initLoopCount].value,
      g_initBumonRank[g_initLoopCount].value,
      true
    );
    g_initLoopCount++;
  }
  setTimeout("initAjaxAction()", 50);

}
function initAjaxFocus() {

  var selectFlg = g_selectFlg;

  // 自動展開を中止した場合はフォーカスする場所がないので終了
  if (null == document.getElementById(g_resultDivId)) {
    return;
  }else{
    // 組織選択の場合
    if (selectFlg == '1') {

      // 初期通信が終了した段階でフォーカス移動を行う。
      if (document.getElementById(g_resultDivId).name == "connected"
      ||	document.getElementById(g_resultDivId).name == "failed") {

        var name="button" + g_resultDivId;
        if (document.getElementById(name)) {
          document.getElementById(name).focus();
        } else {
          document.location.href = "#focus" + g_resultDivId;
        }
        return;
      }

    // 従業員選択・組織従業員選択の場合
    } else {
      // 初期通信が終了した段階でフォーカス移動を行う。
      if (document.getElementById(g_resultDivId).name == "connected"
      ||	document.getElementById(g_resultDivId).name == "failed") {
        document.location.href = "#focus" + g_resultDivId;
        return;
      }
    }
  }
  setTimeout("initAjaxFocus()", 50);
}

/**
 * cseReturnで、このウインドウを閉じるときに呼び出されます。
 * 単にウインドウを閉じます。
 */
function cseClose(){
  window.close();
}

/**
 * 終了時の処理を記述します。
 */
function cseUnLoad(){
  try{
    eval("window.opener." + document.fm0.winVarName.value + "=null");
  }catch(e){
  }
}

/**
 * 組織選択ボタン押下
 */
function rCseSelectSos(bumonRank, sosCd,
		  bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode
) {
  eval(
		  "window.opener." + document.fm1.callBack.value + "(bumonRank, sosCd, "
        + "bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode)"
  );
      cseClose();
}

/**
 * 従業員選択ボタン押下
 */
function rCseSelectJgi(sosCd,bumonSeiName,
		  jgiNo, jgiName, trtCd, brCode, distCode, trtGrpCd, trtNm, mrCat
) {
  eval(
		  "window.opener." + document.fm1.callBack.value + "(sosCd,bumonSeiName, "
        + "jgiNo, jgiName, trtCd, brCode, distCode, trtGrpCd, trtNm, mrCat)"
  );
      cseClose();
}

/*
 * グローバル変数
 * （グローバル変数の命名は「g_」始まりで統一する）
 */
var g_resultDivId = "";
var g_bumonRank = "";
var g_searchUpSosCd = "";
var g_selectFlg = "";

/**
 * Ajaxコール関数：組織・従業員検索
 */
function rcseCallAjax(searchUpSosCd, bumonRank, batchCall) {

  // 画面からのコールの場合
  if (arguments.length == 2) {
    // 二度押し防止設定
    if (!AjaxStatus.toBusy()) {
      alert("読み込み中です。");
      return;
    }
  } else if (arguments.length == 3) {
    // 関数からのコールの場合
  } else {
    alert("引数が足りません。");
  }

  // グローバル変数にパラメータを設定。
  g_resultDivId   = searchUpSosCd;
  g_bumonRank     = bumonRank;
  g_searchUpSosCd = searchUpSosCd;

  // 自動展開の際、展開したい組織が表示対象でない場合は自動展開を中止する
  if (arguments.length == 3) {
    if (null == document.getElementById(g_resultDivId)) {
      g_initLoopCount = g_initSosCd.length;
      // 二度押し防止解除
      AjaxStatus.toIdle();
      return;
    }
  }

  // 既にデータを取得済みの場合はAjax通信を行わず挙動を決める。
  if (document.getElementById(g_resultDivId).name == "connected") {

    // 開いている場合は閉じる。
    if (document.getElementById(g_resultDivId).style.display == "block" && !batchCall) {
      cseChangeIcon("right.gif", "img" + g_resultDivId);
      document.getElementById(g_resultDivId).style.display = "none";
    // 閉じている場合は開く。
    } else {
      cseChangeIcon("down.gif", "img" + g_resultDivId);
      document.getElementById(g_resultDivId).style.display = "block";
    }
    // 二度押し防止解除
    AjaxStatus.toIdle();
    return;
  }

  // アイコン変更。
  cseChangeIcon("ajaxblue.gif", "img" + g_resultDivId);

  // Ajax開始。
  var ajax = new Ajax();
  ajax.setUrl("NC202AjaxJgi");

  ajax.setParameter("sosCdPop",	g_searchUpSosCd);
  ajax.setParameter("bumonRankPop",	g_bumonRank);
  //ajax.setParameter("jgiFetchSize1" ,		document.fm1.jgiFetchSizeDefault.value);  // 従業員選択取得フェッチサイズ
  //ajax.setParameter("no1"           ,		"1");
  ajax.setCallback ("cseCallBackAjax");
  ajax.send();

}

/**
 * Ajaxコール関数：組織・従業員検索
 */
function rcseCallAjaxJgi(searchUpSosCd, bumonRank, batchCall) {

  // 画面からのコールの場合
  if (arguments.length == 2) {
    // 二度押し防止設定
    if (!AjaxStatus.toBusy()) {
      alert("読み込み中です。");
      return;
    }
  } else if (arguments.length == 3) {
    // 関数からのコールの場合
  } else {
    alert("引数が足りません。");
  }

  // グローバル変数にパラメータを設定。
  g_resultDivId   = searchUpSosCd;
  g_bumonRank     = bumonRank;
  g_searchUpSosCd = searchUpSosCd;

  // 自動展開の際、展開したい組織が表示対象でない場合は自動展開を中止する
  if (arguments.length == 3) {
    if (null == document.getElementById(g_resultDivId)) {
      g_initLoopCount = g_initSosCd.length;
      // 二度押し防止解除
      AjaxStatus.toIdle();
      return;
    }
  }

  // 既にデータを取得済みの場合はAjax通信を行わず挙動を決める。
  if (document.getElementById(g_resultDivId).name == "connected") {

    // 開いている場合は閉じる。
    if (document.getElementById(g_resultDivId).style.display == "block" && !batchCall) {
      cseChangeIcon("right.gif", "img" + g_resultDivId);
      document.getElementById(g_resultDivId).style.display = "none";
    // 閉じている場合は開く。
    } else {
      cseChangeIcon("down.gif", "img" + g_resultDivId);
      document.getElementById(g_resultDivId).style.display = "block";
    }
    // 二度押し防止解除
    AjaxStatus.toIdle();
    return;
  }

  // アイコン変更。
  cseChangeIcon("ajaxblue.gif", "img" + g_resultDivId);

  // Ajax開始。
  var ajax = new Ajax();
  ajax.setUrl("NC202AjaxJgi");

  ajax.setParameter("sosCdPop",	g_searchUpSosCd);
  ajax.setParameter("bumonRankPop",	g_bumonRank);
  //ajax.setParameter("jgiFetchSize1" ,		document.fm1.jgiFetchSizeDefault.value);  // 従業員選択取得フェッチサイズ
  //ajax.setParameter("no1"           ,		"1");

  //展開方法　1の場合、手動展開　2の場合、自動展開
  if(g_switch_ajax = '1') {
	  ajax.setCallback ("cseCallBackAjax");
  }else {
	  ajax.setCallback ("rcseCallBackAjax");
  }

  ajax.send();

}


/**
 * Ajaxコールバック関数：組織・従業員検索
 */
function cseCallBackAjax(response) {

  var resultDiv = document.getElementById(g_resultDivId);

  // 結果が取得できなかった場合。
  if (cseTrim(response).length == "") {

    resultDiv.name = "failed";
    cseChangeIcon("right.gif", "img" + g_resultDivId);
    AjaxStatus.toIdle();	// 二度押し防止解除
    return;
  }
  // アイコン変更。
  cseChangeIcon("down.gif", "img" + g_resultDivId);

  // 結果をdiv空間に表示。
  resultDiv.innerHTML = response;
  resultDiv.style.paddingLeft = cseGetPaddingLeft();
  resultDiv.style.borderColor = cseGetBorderColor();
  resultDiv.style.display = "block";
  resultDiv.name = "connected";

  // 二度押し防止解除
//	AjaxStatus.toIdle();
  setTimeout("AjaxStatus.toIdle()",500);

}

/**
 * Ajaxコール関数：従業員追加検索
 */
function cseMoreJgi(searchUpSosCd, jgiFetchSize) {

  // 二度押し防止設定
  if (!AjaxStatus.toBusy()) {
    alert("読み込み中です。");
    return;
  }

  // グローバル変数にパラメータを設定。
  g_searchUpSosCd = searchUpSosCd;

  // アイコン変更。
  cseChangeIcon("ajaxblue.gif", "imgJgi" + g_searchUpSosCd);

  // Ajax開始。
  var ajax = new Ajax();
  ajax.setUrl(document.fm0.action);
  ajax.setParameter("screenId"      , "CatSosJgiExpand");
  ajax.setParameter("functionId"    , "AjaxJgi");
  ajax.setParameter("searchUpSosCd1", g_searchUpSosCd);  // 上位標準組織背番号C（検索用）
  ajax.setParameter("jgiFetchSize1" , jgiFetchSize);     // 従業員選択取得フェッチサイズ
  ajax.setParameter("no1"           , "1");
  ajax.setCallback ("cseCallBackMoreJgi");
  ajax.send();
}

/**
 * Ajaxコールバック関数：従業員追加検索
 */
function cseCallBackMoreJgi(response) {

  // 追加検索した従業員を設定。
  document.getElementById("moreJgi" + g_searchUpSosCd).innerHTML = response;

  // 二度押し防止解除
  AjaxStatus.toIdle();
}

/**
 * アイコンを変更。
 */
function cseChangeIcon(gifName, imgName) {
  var allDiv = document.getElementById("all");
  var imgs = allDiv.getElementsByTagName("img");
  for (var i = 0; i < imgs.length; i++) {
    if (imgs[i].name == imgName){
      imgs[i].src = "img/" + gifName;
      break;
    }
  }
}

/**
 * 左パディングを部門ランクから判定して返す。
 */
function cseGetPaddingLeft() {
  var padding = "";
  switch (g_bumonRank) {
  case "0":
    padding = "0";
    break;
  case "1":
    padding = "20";
    break;
  case "2":
    padding = "20";
    break;
  case "3":
    padding = "20";
    break;
  case "4":
    padding = "20";
    break;
  case "5":
    padding = "20";
    break;
  default:
    padding = "0";
  }
  return padding + "px";
}

/**
 * 枠の色を部門ランクから判定して返す。
 */
function cseGetBorderColor() {
  var color = "";
  switch (g_bumonRank) {
  case "0":
    color = "FFF";
    break;
  case "1":
    color = "EEE";
    break;
  case "2":
    color = "DDD";
    break;
  case "3":
    color = "CCC";
    break;
  case "4":
    color = "BBB";
    break;
  case "5":
    color = "AAA";
    break;
  default:
    color = "FFF";
  }
  return "#" + color;
}

/**
 * 全てたたむ
 */
function cseAllClose() {
  var allDiv = document.getElementById("all");
  // 表示を閉じる。
  var childDivs = allDiv.getElementsByTagName("div");
  for (var i = 0; i < childDivs.length; i++) {
  	/* 20210208 FSZ Chrome対応 UPD START */
    //if (childDivs[i].name != "layout") {
    if (childDivs[i].id != "layout") {
	/* 20210208 FSZ Chrome対応 UPD END */

      childDivs[i].style.display = "none";
    }
  }
  // アイコンを右三角に変更。
  var imgs = allDiv.getElementsByTagName("img");
  for (var i = 0; i < imgs.length; i++) {
    imgs[i].src = "img/right.gif";
  }
  // フォーカスを上部に戻す。
  document.getElementById("all").focus();
}

/**
 * スペースや改行をトリミングする。
 */
function cseTrim(target) {
    return target.replace(/^\s+|\s+$/g, "");
}

///**
// * 選択フラグによってタイトル表示を変更します。
// */
//function cseSetTitle() {
//  var title = "";
//
//  title = RCSE_TITLE_SOS;
//
//  document.getElementById("title").innerHTML = title;
//}

/**
 * 呼び出し元のClear処理を実行し、画面を閉じます。
 */
function cseParentClear() {
  eval("window.opener." + document.fm1.parentClearProc.value + " ");

  window.close();
}