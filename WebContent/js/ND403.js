/**
 * <pre>
 *  医師勤務先情報一括更新のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author BHH 趙
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

function clearAll(){

	var kensakuInsKanj = document.getElementById("kensakuInsKanj");
	kensakuInsKanj.value = '';
	var kensakuInsNo = document.getElementById("kensakuInsNo");
	kensakuInsNo.value = '';
	var kensakuDocKanj = document.getElementById("kensakuDocKanj");
	kensakuDocKanj.value = '';
	var kensakuDocNo = document.getElementById("kensakuDocNo");
	kensakuDocNo.value = '';
	var kensakuDeptCode = document.getElementById("kensakuDeptCode");
	kensakuDeptCode.value = '';
	var kensakuSosCd = document.getElementById("kensakuSosCd");
	kensakuSosCd.value = '';
	var kensakuBrCode = document.getElementById("kensakuBrCode");
	kensakuBrCode.value = '';
	var kensakuDistCode = document.getElementById("kensakuDistCode");
	kensakuDistCode.value = '';
	var kensakuJgiNo = document.getElementById("kensakuJgiNo");
	kensakuJgiNo.value = '';
}

function deptBack(Backbutton){

	var td = Backbutton.parentNode;
	var tr = td.parentNode;

	//所属部科　漢字名
	var deptKj = tr.children[9];
	var deptKjAFLabel = tr.children[6];
	var deptKjAF = deptKjAFLabel.children[0];
	deptKj.textContent = deptKjAF.textContent;

	//所属部科　カナ名
	var deptKn = tr.children[15];
	var deptKnAFLabel = tr.children[14];
	var deptKnAF = deptKnAFLabel.children[0];
	deptKn.textContent = deptKnAF.textContent;

	//所属部科コード
	var deptCd = tr.children[17];
	var deptCdAfLabel = tr.children[16];
	var deptCdAf = deptCdAfLabel.children[0];
	deptCd.textContent = deptCdAf.textContent;

	//★へ変更ボタン表示
	var henkou = tr.children[7];
	var henkouButton = henkou.children[0];
	henkouButton.style.display = 'block';

	//戻すボタン非表示
	var back = tr.children[8];
	var backDept = back.children[0];
	backDept.style.display = 'none'
}


function cseViewND401(button){

	var td = button.parentNode;
	var tr = td.parentNode;

	//所属部科　漢字名
	var deptKj = tr.children[9]
	deptKj.textContent = document.fm1.deptKjHenkou.value;
	//所属部科　カナ名
	var deptKn = tr.children[15]
	deptKn.textContent = document.fm1.deptKnHenkou.value;
	//所属部科コード
	var deptCd = tr.children[17]
	deptCd.textContent = document.fm1.deptCodeHenkou.value;
	//★へ変更ボタン非表示
	var henkou = tr.children[7];
	var henkouButton = henkou.children[0];
	henkouButton.style.display = 'none';
	//戻すボタン表示
	var back = tr.children[8];
	var backDept = back.children[0];
	backDept.style.display = 'block'
}

/**
* 所属部科POPUP画面を呼び出します。
*
*/
function hekouShozoku(){

	// 2度押し対策
	  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	// 全てのポップアップを閉じる
	  hcpClosePopUp(gCdcViewWin, "gCdcViewWin");

	  document.fm1.paramInsNo.value = document.getElementById("kensakuInsNo").value;

	  gCdcViewWin = cdcViewND401(gCdcViewWin,"tmpCallBackShozokuViewHenkou","gCdcViewWin");
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
  var checkedCodes = document.fm1.cdcCheckedCodes;
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
 * 出身所属部科POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShozokuViewHenkou(deptCode,DeptKj,DeptKn){
//gCdcViewSelId 0:出身所属部科,1:勤務先情報 所属部科
	document.fm1.deptCodeHenkou.value = deptCode;
	document.fm1.deptKjHenkou.value = DeptKj;
	document.fm1.deptKnHenkou.value = DeptKn;
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
 *  クリア
 * 全項目展開>>(リンク)押下時に呼ばれます。
 * </pre>
 */
function clearText() {

	var kensakuInsNo = document.getElementById("kensakuInsNo");
	kensakuInsNo.value = '';

}

/**
 * <pre>
 *  申請画面遷移
 * 申請画面へ(ボタン)押下時に呼ばれます。
 * </pre>
 */
function goNC101() {
	//現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;

    document.fm1.functionId.value = "Register"
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
