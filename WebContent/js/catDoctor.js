/**
 * <pre>
 *	医師選択のJavaScript
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
var CDR_APPLICATION_ID = "CDR";

var gCsoViewWin = null;        // 検索条件 組織POPUP用
var gCtaViewWin = null;        // 検索条件 担当POPUP用
var gCdcViewWin = null;        // 検索条件 所属部科POPUP用
var gCseViewWin = null;        // 検索条件 施設POPUP用

/**
 * スクリーンID
 */
var CDR_SCREEN_ID		= "CatDoctor";

var tmpCallback = null;
var tmpTarget = null;

/**
 * <pre>
 * clear(リンク)押下時に呼ばれます。
 *@param name クリア項目名
 * </pre>
 */
function cdrClear( name ) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  if ( name == 'searchSos' ) {
	  // 検索条件 組織
	  document.fm1.searchSosCd.value = "";
	  document.fm1.searchSosNm.value = "";
	  document.fm1.searchSosRank.value = "";
	  document.fm1.searchTantoCd.value = "";
	  document.fm1.searchTantoNm.value = "";
  } else if ( name == 'searchTanto' ) {
	  // 検索条件 担当者
	  document.fm1.searchTantoCd.value = "";
	  document.fm1.searchTantoNm.value = "";
  } else if ( name == 'searchIns' ) {
	  // 検索条件 施設
	  document.fm1.searchInsNo.value = "";
	  document.fm1.searchInsNm.value = "";
  } else if ( name == 'searchDept' ) {
	  // 検索条件 所属部科
	  document.fm1.searchDeptCd.value = "";
	  document.fm1.searchDeptNm.value = "";
  }
}

/**
 * <pre>
 * clear(リンク)押下時に呼ばれます。
 *@param name クリア項目名
 * </pre>
 */
function cdrClearAll() {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	  document.fm1.searchDocName.value = "";
	  document.fm1.searchDocKana.value = "";
	  document.fm1.searchDocType.value = "";
	  document.fm1.searchDocNo.value = "";
	  document.fm1.searchDocAttribute.value = "";
	  document.fm1.searchMedSch.value = "";
	  document.fm1.searchGradYear.value = "";
	  document.fm1.searchHUniv.value = "";
	  // 検索条件 組織
	  document.fm1.searchSosCd.value = "";
	  document.fm1.searchSosNm.value = "";
	  document.fm1.searchSosRank.value = "";
	  document.fm1.searchTantoCd.value = "";
	  document.fm1.searchTantoNm.value = "";
	  // 検索条件 担当者
	  document.fm1.searchTantoCd.value = "";
	  document.fm1.searchTantoNm.value = "";
	  // 検索条件 施設
	  document.fm1.searchInsNo.value = "";
	  document.fm1.searchInsNm.value = "";
	  // 検索条件 所属部科
	  document.fm1.searchDeptCd.value = "";
	  document.fm1.searchDeptNm.value = "";
}

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

	  // 検索条件 組織ポップアップ
	  if(gCsoViewWin != null && targetWinName != "gCsoViewWin"){
		  gCsoViewWin.close();
		  gCsoViewWin = null;
	  }
	  // 検索条件 担当ポップアップ
	  if(gCtaViewWin != null && targetWinName != "gCtaViewWin"){
		  gCtaViewWin.close();
		  gCtaViewWin = null;
	  }
	  // 検索条件 所属部科ポップアップ
	  if(gCdcViewWin != null && targetWinName != "gCdcViewWin"){
		  gCdcViewWin.close();
		  gCdcViewWin = null;
	  }
	  // 検索条件 施設ポップアップ
	  if(gCseViewWin != null && targetWinName != "gCseViewWin"){
		  gCseViewWin.close();
		  gCseViewWin = null;
	  }

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
  if(typeof(gCsoViewWin) == 'string') return false;     // 検索条件 組織ポップアップ
  if(typeof(gCtaViewWin) == 'string') return false;     // 検索条件 担当ポップアップ
  if(typeof(gCdcViewWin) == 'string') return false;     // 検索条件 所属部科ポップアップ
  if(typeof(gCseViewWin) == 'string') return false;     // 検索条件 施設ポップアップ
  // 全ウィンドウが正常ならばtrue
  return true;
}


/**
 * 所属部科POPUP画面を呼び出します。
 *
 */
function tmpCdcView(){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 全てのポップアップを閉じる
  hcpClosePopUp(gCdcViewWin, "gCdcViewWin");

 // パラメータの設定
  document.fm1.cdcCheckedCodes.value = "";
  document.fm1.paramInsNo.value = document.fm1.searchInsNo.value;

  document.fm1.backScreenId.value = "NC209";
  gCdcViewWin = cdcView(gCdcViewWin,"tmpCallBackShozokuViewRDM","gCdcViewWin");
  return(true);
}

/**
 * <pre>
 * 出身所属部科POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShozokuViewRDM(deptCode,DeptKj,DeptKn){
	document.fm1.searchDeptCd.value = deptCode;
	document.fm1.searchDeptNm.value = DeptKj;
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
  document.fm1.backScreenId.value = "NC209";
  gCseViewWin = cseView(gCseViewWin,"tmpCallBackShisetsuView","gCseViewWin");
  return(true);
}

/**
 * <pre>
 * 施設検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShisetsuView(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType,insClass){
    document.fm1.searchInsNo.value = insNo;
    document.fm1.searchInsNm.value = insAbbrName;
//    document.fm1.searchInsHoInsType.value = hoInsType;
//    document.fm1.searchInsInsClass.value = insClass;

}


// 担当者選択ボタン
function tantoPopBtn(){
	  // 全てのポップアップを閉じる
	  hcpClosePopUp(gCtaViewWin, "gCtaViewWin");
		// NC202_担当者検索ポップアップ画面を表示
		window.open("","gCtaViewWin",tantoSubScreenSize);
		document.fm1.screenId.value = "NC202";
		document.fm1.functionId.value="Init";
		if(tmpTarget == null){
			tmpTarget = document.fm1.target;
		}
		document.fm1.target="gCtaViewWin";

		document.fm1.sosCdPop.value = document.fm1.searchSosCd.value;
		document.fm1.bumonRankPop.value = document.fm1.searchSosRank.value;
		document.fm1.upSosCdPop.value = document.fm1.upSosCd.value;

		document.fm1.selectFlgPop.value="1";
		if(tmpCallback == null){
			tmpCallback = document.fm1.callBack.value;
		}
		document.fm1.callBack.value="callBackTantoPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
}

function soshikiPopBtn(){
	  hcpClosePopUp(gCsoViewWin, "gCsoViewWin");
	// NC201_担当者検索ポップアップ画面を表示
	window.open("","gCsoViewWin",tantoSubScreenSize);
	document.fm1.screenId.value = "NC201";
	document.fm1.functionId.value="Init";
	if(tmpTarget == null){
		tmpTarget = document.fm1.target;
	}
	document.fm1.target="gCsoViewWin";

	document.fm1.bumonRankPop.value="1";
	document.fm1.selectFlgPop.value="1";
	if(tmpCallback == null){
		tmpCallback = document.fm1.callBack.value;
	}
	document.fm1.callBack.value = "callBackSoshikiPop";

	comSubmitForAnyWarp(fm1);
	comClickFlgInit();
}

// 担当者検索ポップアップから値受け取り
function callBackTantoPop(sosCd, bumonSeiName, jgiNo, jgiName, trtCd, brCode,
							distCode, trtGrpCd, trtNm, mrCat){
	document.fm1.searchSosCd.value = sosCd;
	document.fm1.searchSosNm.value = bumonSeiName;
	document.fm1.searchTantoCd.value = jgiNo;
	document.fm1.searchTantoNm.value = jgiName;
	document.fm1.searchSosRank.value = "3";
	document.fm1.brCode.value = brCode;
	document.fm1.distCode.value = distCode;
	document.fm1.callBack.value = tmpCallback;
	document.fm1.target = tmpTarget;
}

function callBackSoshikiPop(bumonRank, sosCd, bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){
		document.fm1.bumonRank.value    = bumonRank;
		document.fm1.searchSosRank.value    = bumonRank;
		document.fm1.searchSosNm.value = bumonSeiName;
		document.fm1.sosCd.value        = sosCd;
		document.fm1.searchSosCd.value        = sosCd;
		document.fm1.brCode.value       = brCode;
		document.fm1.distCode.value     = distCode;
		document.fm1.upSosCode.value    = upSosCode;
		document.fm1.upBumonRank.value  = upBumonRank;
		document.fm1.upBrCode.value     = upBrCode;
		document.fm1.upDistCode.value   = upDistCode;
		document.fm1.callBack.value = tmpCallback;
		document.fm1.target = tmpTarget;
}
/////////////////////////////////////////////////

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *			 このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function cdrView(w,callBack,winVarName){

	//フォーカスをあてる処理と２度押し対策を共通関数化
	//戻り値がtrueならポップアップ処理を継続 falseならwindowオブジェクトを戻します。
	if(!comPopupPreCheck(w,winVarName)){
		return(w);
	}

	//windowに名前を付ける。(現在日時を付加して)
	var winName = comCreateWindowName(CDR_APPLICATION_ID);

	//ウインドウの体裁(幅や高さなど)はここで指定します。
	w = window.open ("",winName,"width=1000,height=600,resizable=no,status=no,toolbar=no,scrollbars=yes,titlebar=no");

	uri = "NC209Init.action";		//oc4jのmapsアプリを利用してhtmlのテストドライバを利用する場合

	  ix1 = 0;
	  jokenName = new Array();	//パラメタの名前を1次元配列で指定
	  joken = new Array();		//パラメタの値を2次元配列で指定

	/*条件有り呼び出しパターン*/
	comPostPopup(w,uri,CDR_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

	w.focus();

	return(w);
}

/**
 * 起動時の処理を記述します。
 */
function cdrLoad(){

	//２度押し対策フラグ初期化
	comClickFlgInit();
	document.fm1.searchDocName.focus();
}

/**
 * 医師を選択ボタン押下
 */
function csdSelectDoc(docNo,docKanj) {
	if(!comChkSubmit(COM_CLICK_ALERT))return(false);
	if(tmpCallback != null){
		document.fm1.callBack.value = tmpCallback;
	}
  eval("window.opener." + document.fm1.callBack.value + "(docNo,docKanj)"
  );
      cdrClose();
}

/**
 * cdrReturnで、このウインドウを閉じるときに呼び出されます。
 * 単にウインドウを閉じます。
 */
function cdrClose(){
	window.close();
}

function cdrUnLoad(){
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
function cdrSearch(){

//	//ボタン２度押し対策をなるべく早くやる(実際のSubmitのときではなく)
//	if(!comChkSubmit(COM_CLICK_ALERT))return(false);

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
	if(tmpCallback != null){
		document.fm1.target = tmpTarget;
	}

    // 検索イベント呼び出し
    document.fm1.submit_search.click();
}

/**
 * <pre>
 *  ページ切替え
 * ページ切替えリンク押下時に呼ばれます。
 * </pre>
 */
function pltPage( pageCntCur ){
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = pageCntCur;
  document.fm1.screenId.value = "NC209";
  document.fm1.functionId.value = 'Page';
	if(tmpCallback != null){
		document.fm1.target = tmpTarget;
	}
	// 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  ソート
 * ソートリンク押下時に呼ばれます。
 * </pre>
 */
function cdrSort( sortCondition ){
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = 1;

  //ソート区分設定
  document.fm1.sortCondition.value = sortCondition;
  document.fm1.screenId.value = "NC209";
  document.fm1.functionId.value = 'Sort';
	if(tmpCallback != null){
		document.fm1.target = tmpTarget;
	}
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}



