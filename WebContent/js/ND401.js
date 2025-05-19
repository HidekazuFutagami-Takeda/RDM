/**
 * <pre>
 *  医師勤務先情報一括更新のJavaScript
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
 * 画面のリロードやアンロードの際の処理を記述します。
 * ポップアップ画面を使用するときは使用する分を全てクリアします。
 */
function jimUnLoad(){

  jimViewClear(8);
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
 *  全メッセージ格納用配列
 * 当画面で使用する全メッセージが格納されます。
 * </pre>
 */
var gMsg = new Array();


/**
 * 画面のリロードやアンロードの際の処理を記述します。
 * ポップアップ画面を使用するときは使用する分を全てクリアします。
 */
function jimUnLoad(){

  jimViewClear(8);
}

/**
 * ポップアップ画面のクリアを行います。
 */
function jimViewClear(number){

  var popObj = new Array();
  popObj[0] = gCseViewFromWin;
  popObj[1] = gCseViewToWin;
  popObj[2] = gCseViewChgWin;
  popObj[3] = gCseViewSosWin;
  popObj[4] = gCseViewToJgiWin;
  popObj[5] = gCpcViewWin;
  popObj[6] = gCtcViewWin;
  popObj[7] = gIiiViewWin;
  for(var i = 0; i< popObj.length; i++){
    if(popObj[i] != null){
      try{
        popObj[i].close();
      }catch(err){
        //エラー時は何も表示しない。
        alert(err.message);
      }
      popObj[i] = null;
    }
  }
}

/**
 * <pre>
 *  組織クリア
 * 組織(clear)押下時に呼ばれます。
 * </pre>
 */
function sosClear() {
	document.fm1.kensakuSosCd.value = "";
	document.fm1.kensakuSosName.value = "";
	document.fm1.kensakuBrCode.value = "";
	document.fm1.kensakuDistCode.value = "";
	document.fm1.kensakuUpSosCd.value = "";
	document.fm1.kensakuBumonRank.value = "";

	document.fm1.kensakuJgiNo.value = "";
	document.fm1.kensakuJgiName.value = "";
	document.fm1.kensakuTrtCd.value = "";
	document.fm1.kensakuBrCode.value = "";
	document.fm1.kensakuDistCode.value = "";
}

/**
 * <pre>
 *  担当者クリア
 * 担当者(clear)押下時に呼ばれます。
 * </pre>
 */
function tantoClear() {
	document.fm1.kensakuJgiNo.value = "";
	document.fm1.kensakuJgiName.value = "";
	document.fm1.kensakuTrtCd.value = "";
}

/**
 * <pre>
 *  所属部科クリア
 * 所属部科(clear)押下時に呼ばれます。
 * </pre>
 */
function deptClear() {

	var kensakuDeptKj = document.getElementById("kensakuDeptKj");
	kensakuDeptKj.value = '';
	document.fm1.kensakuDeptCode.value = '';
}

/**
 * <pre>
 *  所属部科クリア
 * ★選択 所属部科(clear)押下時に呼ばれます。
 * </pre>
 */
function deptKjHenkouClear() {

	document.fm1.deptCodeHenkou.value = "";
	document.fm1.deptKjHenkou.value = "";
	document.fm1.deptKnHenkou.value = "";

	// ★ボタン非活性
	var i = 0;
	var henkouBtn = document.getElementsByName("cseHenkouBtn")[i];
	while(henkouBtn != undefined){
		henkouBtn.disabled = true;

		i++;
		henkouBtn = document.getElementsByName("cseHenkouBtn")[i];
	}
}

/**
 * 検索条件のクリアを行います。
 */
function clearAll(){

	var kensakuInsKanj = document.getElementById("kensakuInsKanj");
	kensakuInsKanj.value = '';
	var kensakuInsNo = document.getElementById("kensakuInsNo");
	kensakuInsNo.value = '';
	var kensakuDocKanj = document.getElementById("kensakuDocKanj");
	kensakuDocKanj.value = '';
	var kensakuDocNo = document.getElementById("kensakuDocNo");
	kensakuDocNo.value = '';
	var kensakuDeptKj = document.getElementById("kensakuDeptKj");
	kensakuDeptKj.value = '';

	if(document.fm1.loginJokenSetCd.value == "JKN0850") {
		document.fm1.kensakuSosCd.value = '';
		document.fm1.kensakuSosName.value = '';
		document.fm1.kensakuJgiNo.value = '';
		document.fm1.kensakuJgiName.value = '';
		document.fm1.kensakuBrCode.value = '';
		document.fm1.kensakuDistCode.value = '';
		document.fm1.kensakuUpSosCd.value = '';
		document.fm1.kensakuBumonRank.value = '';

	}

}

/**
 * 戻すボタン押下時に呼ばれます
 */
function deptBack(Backbutton, indexNo){

	var td = Backbutton.parentNode;
	var tr = td.parentNode;

	//所属部科　カナ名
	var preDeptKana = "kmuIkkatsuDataList[" + indexNo + "].preDeptKana";
    var preDeptKanaValue = document.getElementsByName(preDeptKana)[0].value;

    var postDeptKanaBack = "kmuIkkatsuDataList[" + indexNo + "].postDeptKana";
    var postDeptKanaValueBack = document.getElementsByName(postDeptKanaBack)[0];

	//var deptKn = tr.children[15];
	//deptKn.textContent = preDeptKanaValue;
	postDeptKanaValueBack.value = preDeptKanaValue;

	//所属部科コード
	var preDeptCode = "kmuIkkatsuDataList[" + indexNo + "].preDeptCode";
    var preDeptCodeValue = document.getElementsByName(preDeptCode)[0].value;

    var postDeptCodeBack = "kmuIkkatsuDataList[" + indexNo + "].postDeptCode";
    var postDeptCodeValueBack = document.getElementsByName(postDeptCodeBack)[0];

	//var deptCd = tr.children[17];
	//deptCd.textContent = preDeptCodeValue;
	postDeptCodeValueBack.value = preDeptCodeValue;

	//所属部科　漢字名
	var preDeptKanji = "kmuIkkatsuDataList[" + indexNo + "].preDeptKanji";
    var preDeptKanjiKanjiValue = document.getElementsByName(preDeptKanji)[0].value;

    var postDeptKanjiBack = "kmuIkkatsuDataList[" + indexNo + "].postDeptKanji";
    var postDeptKanjiValueBack = document.getElementsByName(postDeptKanjiBack)[0];

	var deptKj = tr.children[9];
	deptKj.textContent = preDeptKanjiKanjiValue;
	postDeptKanjiValueBack.value = preDeptKanjiKanjiValue;

	//★へ変更ボタン表示
	var henkou = tr.children[7];
	var henkouButton = henkou.children[0];
	henkouButton.style.display = 'block';

	//戻すボタン非表示
	var back = tr.children[8];
	var backDept = back.children[0];
	backDept.style.display = 'none';

	//所属部科ボタンフラグ
	var deptBtnFlg = "kmuIkkatsuDataList[" + indexNo + "].deptBtnFlg";
    document.getElementsByName(deptBtnFlg)[0].value = "0";
}


/**
 * ★へ変更ボタン押下後に呼ばれます。
 */
function cseHenkouViewND401(button, indexNo){

	var td = button.parentNode;
	var tr = td.parentNode;

	//所属部科　漢字名
	var postDeptKanji = "kmuIkkatsuDataList[" + indexNo + "].postDeptKanji";
    var postDeptKanjiValue = document.getElementsByName(postDeptKanji)[0];

	var deptKj = tr.children[9]
	deptKj.textContent = document.fm1.deptKjHenkou.value;
	postDeptKanjiValue.value = document.fm1.deptKjHenkou.value;

	//所属部科　カナ名
	var postDeptKana = "kmuIkkatsuDataList[" + indexNo + "].postDeptKana";
    var postDeptKanaValue = document.getElementsByName(postDeptKana)[0];

	//var deptKn = tr.children[15]
	//deptKn.textContent = document.fm1.deptKnHenkou.value;
	postDeptKanaValue.value = document.fm1.deptKnHenkou.value;

	//所属部科コード
	var postDeptCode = "kmuIkkatsuDataList[" + indexNo + "].postDeptCode";
    var postDeptCodeValue = document.getElementsByName(postDeptCode)[0];

	//var deptCd = tr.children[17]
	//deptCd.textContent = document.fm1.deptCodeHenkou.value;
	postDeptCodeValue.value = document.fm1.deptCodeHenkou.value;
	//★へ変更ボタン非表示
	var henkou = tr.children[7];
	var henkouButton = henkou.children[0];
	henkouButton.style.display = 'none';
	//戻すボタン表示
	var back = tr.children[8];
	var backDept = back.children[0];
	backDept.style.display = 'block';

	//所属部科ボタンフラグ
	var deptBtnFlg = "kmuIkkatsuDataList[" + indexNo + "].deptBtnFlg";
    document.getElementsByName(deptBtnFlg)[0].value = "1";
}

/**
* 所属部科POPUP画面を呼び出します。
* 1:選択ボタン
* 2:★選択ボタン
*/
function hekouShozoku(index){

	// 2度押し対策
	  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	// 全てのポップアップを閉じる
	  hcpClosePopUp(gChsViewWin, "gChsViewWin");

	  if (index == 1) {
		  document.fm1.paramInsNo.value = document.getElementById("kensakuInsNo").value;
		  gChsViewWin = chsViewND401(gChsViewWin,"tmpCallBackKensakuShozokuViewHenkou","gChsViewWin");
	  }
	  else {
		  document.fm1.paramInsNo.value = document.getElementById("kensakuInsNo").value;
		  gChsViewWin = chsViewND401(gCdcViewWin,"tmpCallBackShozokuViewHenkou","gChsViewWin");
	  }

	  return(true);
}

/**
 * 所属部科ポップアップ
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function chsViewND401(w,callBack,winVarName){

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
  var checkedCodes = document.fm1.chsCheckedCodes;
  var jokenName = [];
  var joken = [];
//  for (var i = 0; i < checkedCodes.length; i++) {
//    jokenName[jokenName.length] = "cdcCheckedCodes";
//    joken[joken.length] = new Array(checkedCodes[i].value);
//  }
  jokenName[jokenName.length] = "paramInsNo";
  joken[joken.length] = new Array(document.fm1.paramInsNo.value);

  jokenName[jokenName.length] = "backScreenId";
  joken[joken.length] = new Array(document.fm1.backScreenId.value);

  comPostPopup(w,"NC204Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
}

/**
 * <pre>
 * 選択ボタン
 * 出身所属部科POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackKensakuShozokuViewHenkou(deptCode,DeptKj,DeptKn){

	document.fm1.kensakuDeptKj.value = DeptKj;
	document.fm1.kensakuDeptCode.value = deptCode;
}

/**
 * <pre>
 * ★選択ボタン
 * 出身所属部科POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShozokuViewHenkou(deptCode,DeptKj,DeptKn){
//gCdcViewSelId 0:出身所属部科,1:勤務先情報 所属部科
	document.fm1.deptCodeHenkou.value = deptCode;
	document.fm1.deptKjHenkou.value = DeptKj;
	document.fm1.deptKnHenkou.value = DeptKn;

	// ★ボタン活性
	var i = 0;
	var henkouBtn = document.getElementsByName("cseHenkouBtn")[i];
	while(henkouBtn != undefined){
		henkouBtn.disabled = false;

		i++;
		henkouBtn = document.getElementsByName("cseHenkouBtn")[i];
	}
}

/**
* 組織POPUP画面を呼び出します。
*/
function henkouSos(index){

	// 2度押し対策
	  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	// 全てのポップアップを閉じる
	  hcpClosePopUp(gCseViewWin, "gCseViewWin");

	  gCseViewWin = cseViewND401(gCseViewWin,"tmpCallBackKensakuSos","gCseViewWin");

	  return(true);
}

/**
 * 組織ポップアップ
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function cseViewND401(w,callBack,winVarName){

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
  var checkedCodes = document.fm1.CseCheckedCodes;
  var jokenName = [];
  var joken = [];
//  for (var i = 0; i < checkedCodes.length; i++) {
//    jokenName[jokenName.length] = "CseCheckedCodes";
//    joken[joken.length] = new Array(checkedCodes[i].value);
//  }
  //jokenName[jokenName.length] = "paramInsNo";
  //joken[joken.length] = new Array(document.fm1.paramInsNo.value);

  jokenName[jokenName.length] = "selectFlgPop";
  joken[joken.length] = new Array("1");
  jokenName[jokenName.length] = "backScreenId";
  joken[joken.length] = new Array(document.fm1.backScreenId.value);

  comPostPopup(w,"NC201Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
}

/**
 * <pre>
 * 選択ボタン
 * 組織POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackKensakuSos(bumonRank, sosCd,
		  bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){

	document.fm1.kensakuSosCd.value = sosCd;
	document.fm1.kensakuSosName.value = bumonSeiName;
	document.fm1.kensakuBrCode.value = brCode;
	document.fm1.kensakuDistCode.value = distCode;
	document.fm1.kensakuUpSosCd.value = upSosCode;
	document.fm1.kensakuBumonRank.value = bumonRank;
}

/**
* 担当者POPUP画面を呼び出します。
*/
function henkouTanto(index){

	// 2度押し対策
	  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	// 全てのポップアップを閉じる
	  hcpClosePopUp(gCdcViewWin, "gCdcViewWin");

	  gCdcViewWin = cdcViewND401(gCdcViewWin,"tmpCallBackKensakuTanto","gCdcViewWin");

	  return(true);
}

/**
 * 担当者ポップアップ
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function cdcViewND401(w,callBack,winVarName){

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
  var checkedCodes = document.fm1.CdcCheckedCodes;
  var jokenName = [];
  var joken = [];
//  for (var i = 0; i < checkedCodes.length; i++) {
//    jokenName[jokenName.length] = "CseCheckedCodes";
//    joken[joken.length] = new Array(checkedCodes[i].value);
//  }
  //jokenName[jokenName.length] = "paramInsNo";
  //joken[joken.length] = new Array(document.fm1.paramInsNo.value);

  jokenName[jokenName.length] = "sosCdPop";
  joken[joken.length] = new Array(document.fm1.kensakuSosCd.value);
  jokenName[jokenName.length] = "bumonRankPop";
  joken[joken.length] = new Array(document.fm1.kensakuBumonRank.value);
  jokenName[jokenName.length] = "upSosCdPop";
  joken[joken.length] = new Array(document.fm1.kensakuUpSosCd.value);
  jokenName[jokenName.length] = "selectFlgPop";
  joken[joken.length] = new Array("1");
  jokenName[jokenName.length] = "backScreenId";
  joken[joken.length] = new Array(document.fm1.backScreenId.value);

  comPostPopup(w,"NC202Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

  w.focus();
  return(w);
}

/**
 * <pre>
 * 選択ボタン
 * 担当者POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackKensakuTanto(sosCd, bumonSeiName, jgiNo, jgiName, trtCd, brCode,
		distCode, trtGrpCd, trtNm, mrCat, bumonRank, upSosCode){

	document.fm1.kensakuJgiNo.value = jgiNo;
	document.fm1.kensakuJgiName.value = jgiName;
	document.fm1.kensakuTrtCd.value = trtCd;
	document.fm1.kensakuBrCode.value = brCode;
	document.fm1.kensakuDistCode.value = distCode;
	document.fm1.kensakuSosCd.value = sosCd;
	document.fm1.kensakuSosName.value = bumonSeiName;
	document.fm1.kensakuBumonRank.value = bumonRank;
	document.fm1.kensakuUpSosCd.value = upSosCode;
}

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
 *  申請画面遷移
 * 申請画面へ(ボタン)押下時に呼ばれます。
 * </pre>
 */
function goND403() {

    document.fm1.functionId.value = "Init"
	document.fm1.screenId.value	= "ND403";

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jimSearch() {
	//現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    document.fm1.sortId.value = "0";

    document.fm1.functionId.value = "Search"
	document.fm1.screenId.value	= "ND401";

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);

}


