/**
 * <pre>
 *  施設・領域別担当変更のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author BHH 趙
 */

/**
 * ポップアップ用ウィンドウオブジェクト
 */
var gCsoViewWin = null;        // 検索条件 組織POPUP用
var gCtaViewWin = null;        // 検索条件 担当POPUP用
var gCseViewFromWin = null;    // 組織従業員選択(組織・担当(現))
var gCseViewToWin = null;      // 組織従業員選択(組織・担当(新))
var gCtcViewWin = null;        // JIS府県武田市区郡選択
var gIiiViewWin=null;          // 施設固定コード複数入力
var gCpcViewWin=null;          // 品目選択開始
var gCseViewChgWin=null;       // 組織従業員選択(変更担当者)
var gCseViewToJgiWin=null;     // 組織従業員選択(新担当者)
var gCseViewSosWin=null;       // 組織従業員選択(組織)

var tmpCallback = null;
var tmpTarget = null;

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

	if(document.fm1.jokenSetCd.value != 0){
		// 管理者権限のみ組織担当者をクリア
		document.fm1.tantoBumonRank.value = "";
		document.fm1.tantoSosName.value = "";
		document.fm1.tantoSosCd.value = "";
		document.fm1.tantoUpSosCd.value = "";
		document.fm1.kensakuSTantouBrCode.value = "";
		document.fm1.kensakuTantouDistCode.value = "";
		document.fm1.kensakuShinseiBumonRank.value = "";
		document.fm1.reqSosName.value = "";
		document.fm1.kensakuShinseiSosCd.value = "";
		document.fm1.kensakuShinseiBrCode.value = "";
		document.fm1.kensakuShinseiDistCode.value = "";
		document.fm1.kensakuJgiNo.value = "";
		document.fm1.jgiName.value = "";
	}

	var kensakuInsKanj = document.getElementById("kensakuInsKanj");
	kensakuInsKanj.value = '';

	var kensakuInsKana = document.getElementById("kensakuInsKana");
	kensakuInsKana.value = '';

	var kensakuReqJgiName = document.getElementById("kensakuReqJgiName");
	kensakuReqJgiName.value = '';

	var kensakuInsNo = document.getElementById("kensakuInsNo");
	kensakuInsNo.value = '';

	var kensakuUltInsNo = document.getElementById("kensakuUltInsNo");
	kensakuUltInsNo.value = '';

	var kensakuManageCd = document.getElementById("kensakuManageCd");
	kensakuManageCd.value = '';

	var kensakuHoInsType = document.getElementById("kensakuHoInsType");
	kensakuHoInsType.value = '';

	var kensakuInsSbt = document.getElementById("kensakuInsSbt");
	kensakuInsSbt.value = '';

	var pharmType = document.getElementById("kensakuPharmType");
	pharmType.value = '';

	var kensakuInsPhone = document.getElementById("kensakuInsPhone");
	kensakuInsPhone.value = '';

	var kensakuInsPcode = document.getElementById("kensakuInsPcode");
	kensakuInsPcode.value = '';

	var jkrSosAddrCd = document.getElementById("jkrSosAddrCd");
	jkrSosAddrCd.value = '';

	var jkrCityNameCd = document.getElementById("jkrCityNameCd");
	jkrCityNameCd.value = '';

	var kensakuInsAddr = document.getElementById("kensakuInsAddr");
	kensakuInsAddr.value = '';

	var updMstTo = document.getElementById("updMstTo");
	updMstTo.value = document.fm1.clearUpdMstTo.value;

	var updMstFrom = document.getElementById("updMstFrom");
	updMstFrom.value = document.fm1.clearUpdMstFrom.value;

	var selectListChange = document.getElementById("selectListChange");
	selectListChange.value = '0';

	//エラーメッセージエリア非表示
	var errorArea = document.getElementById('formTable00');
	errorArea.style.display = 'none';


}


/**
 * <pre>
 *  表示・非表示
 * (ボタン)押下時に呼ばれます。
 * </pre>
 */
function showAll() {
	document.getElementById('allShow1').style.display = '';
	document.getElementById('allShow2').style.display = '';
	document.getElementById('allShow3').style.display = '';
	document.getElementById('allShow4').style.display = '';
	document.getElementById('allShow5').style.display = '';
	document.getElementById('allShow6').style.display = '';
	document.getElementById('allShow7').style.display = '';
	document.getElementById('allShow8').style.display = '';
	document.getElementById('allShow9').style.display = '';
	document.getElementById('allShow10').style.display = '';
	document.getElementById('allShow11').style.display = '';
	document.getElementById('allShow12').style.display = '';
	document.getElementById('allShow13').style.display = '';
	document.getElementById('allShow14').style.display = '';
	document.getElementById('allShow15').style.display = '';
	document.getElementById('allShow16').style.display = '';
	document.getElementById('allShow17').style.display = '';
	document.getElementById('allShow18').style.display = '';
	document.getElementById('allShow19').style.display = '';
	document.getElementById('allShow20').style.display = '';
	document.getElementById('allShow21').style.display = '';
	document.getElementById('allShow22').style.display = '';
	document.getElementById('allShow23').style.display = '';
	document.getElementById('allShow24').style.display = '';
	document.getElementById('allShow25').style.display = '';
	document.getElementById('allShow26').style.display = '';
	document.getElementById('allShow27').style.display = '';
	document.getElementById('allShow28').style.display = '';
	document.getElementById('allShow29').style.display = '';
	document.getElementById('allShow30').style.display = '';
	document.getElementById('allShow31').style.display = '';
	document.getElementById('allShow32').style.display = '';

	var i=0;
	while (document.getElementsByName('allShowCont1')[i] != undefined){
		document.getElementsByName('allShowCont1')[i].style.display = '';
		document.getElementsByName('allShowCont2')[i].style.display = '';
		document.getElementsByName('allShowCont3')[i].style.display = '';
		document.getElementsByName('allShowCont4')[i].style.display = '';
		document.getElementsByName('allShowCont5')[i].style.display = '';
		document.getElementsByName('allShowCont6')[i].style.display = '';
		document.getElementsByName('allShowCont7')[i].style.display = '';
		document.getElementsByName('allShowCont8')[i].style.display = '';
		document.getElementsByName('allShowCont9')[i].style.display = '';
		document.getElementsByName('allShowCont10')[i].style.display = '';
		document.getElementsByName('allShowCont11')[i].style.display = '';
		document.getElementsByName('allShowCont12')[i].style.display = '';
		document.getElementsByName('allShowCont13')[i].style.display = '';
		document.getElementsByName('allShowCont14')[i].style.display = '';
		document.getElementsByName('allShowCont15')[i].style.display = '';
		document.getElementsByName('allShowCont16')[i].style.display = '';
		document.getElementsByName('allShowCont17')[i].style.display = '';
		document.getElementsByName('allShowCont18')[i].style.display = '';
		document.getElementsByName('allShowCont19')[i].style.display = '';
		document.getElementsByName('allShowCont20')[i].style.display = '';
		document.getElementsByName('allShowCont21')[i].style.display = '';
		document.getElementsByName('allShowCont22')[i].style.display = '';
		document.getElementsByName('allShowCont23')[i].style.display = '';
		document.getElementsByName('allShowCont24')[i].style.display = '';
		document.getElementsByName('allShowCont25')[i].style.display = '';
		document.getElementsByName('allShowCont26')[i].style.display = '';
		document.getElementsByName('allShowCont27')[i].style.display = '';
		document.getElementsByName('allShowCont28')[i].style.display = '';
		document.getElementsByName('allShowCont29')[i].style.display = '';
		document.getElementsByName('allShowCont30')[i].style.display = '';
		document.getElementsByName('allShowCont31')[i].style.display = '';
		document.getElementsByName('allShowCont32')[i].style.display = '';

		i++
	}

	document.getElementById('allShowButton').style.display = 'none';
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
    document.fm1.sortId.value = "0";

    document.fm1.screenId.value = "NF501";
    document.fm1.functionId.value = "Search";

    document.fm1.selectListChange.value = document.fm1.selectListChange.value;

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);

}

/**
 * <pre>
 *  昇順
 * ▲(ボタン)押下時に呼ばれます。
 * </pre>
 */
function orderUp() {
  // 変更内容破棄確認チェック

  if (!jkrDestructChack()) return false;
  // 検索前チェック
  if(jimChkBeforeSearch()) {
    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 0;
    document.fm1.sortCondition1.value = "";
    document.fm1.sortCondition2.value = "";
    //ソートId定義
    document.fm1.sortId.value = 0;

    // エラー一覧
    if (document.fm1.gamenId.value == "NF501") {
      document.fm1.screenId.value	= "NF501";
    }
    document.fm1.functionId.value = "Search"
    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  }
}

/**
 * <pre>
 *  降順
 * ▼押下時に呼ばれます。
 * </pre>
 */
function orderDown() {
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  // 検索前チェック
  if(jimChkBeforeSearch()) {
    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 0;
    document.fm1.sortCondition1.value = "";
    document.fm1.sortCondition2.value = "";
    //ソートId定義
    document.fm1.sortId.value = 1;

    // エラー一覧
    if (document.fm1.gamenId.value == "NF501") {
      document.fm1.screenId.value	= "NF501";
    }
    document.fm1.functionId.value = "Search"
    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  }
}


/**
 * <pre>
 *  検索
 * 都道府県選択時に呼ばれます。
 * </pre>
 */
function sosAddrChange() {

	//市区町村配列
	 var cityName = document.getElementById("jkrCityNameCd");
	 //選択されたっ都道府県value
     var val1 = document.getElementById("jkrSosAddrCd").value;

     //市区町村プルダウンをクリア
     cityName.value = '';

     //市区町村配列を取り出す
     for (i = 0; i < cityName.length; i++) {
    	 //表示
    	 cityName.options[i].style.display = "block";

    	 var cityNameCd = cityName[i].value;
    	 //市区町村コードの頭2つ切り取る
    	 var cityNamecut = cityNameCd.toString().substr( 0, 2);
    	 //市区町村valueと選択された都道府県valueが紐づかないものを非表示
    	 if (val1 != cityNamecut) {
    		 cityName.options[i];
    		 cityName.options[i].style.display = "none";
         }

     }


}

/**
 * <pre>
 *  エラー一覧
 * エラー(タブ)押下時に呼ばれます。
 * </pre>
 */
function jimGotoErr() {
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;

  //タブを変えた時、現、新組織の両方がクリアされたなら、組織を既定値に戻す
  if ( document.fm1.dispFromSosJgiName.value == ""
      && document.fm1.dispToSosJgiName.value == "" ) {
    //既定値に戻す場合の組織情報のリセット
    if (document.fm1.sosSelFlg.value == "0") {
      jimFromCseViewDef();
    } else if (document.fm1.sosSelFlg.value == "1") {
      jimToCseViewDef();
    }
    //表示リセット時の組織リセット
    resetTopChangedSos();
  } else {
    //選択された組織情報格納（表示押下前→表示押下後）
    setTopChangedSos();
  }

  //20150202 HISOL Suzuki 本番課題No.25対応 ADD START
  //選択された組織情報格納（ポップアップ用）
  setSearchSosCdPop();
  //20150202 HISOL Suzuki 本番課題No.25対応 ADD END

  // 検索前チェック
  //if(jimChkBeforeSearch()) {

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    document.fm1.sortCondition1.value = "";
    document.fm1.sortCondition2.value = "";

    // エラー一覧
    document.fm1.screenId.value	= "JKR040C040";
    document.fm1.gamenId.value	= "JKR040C040";
//  if(document.fm1.pageFlag.value == "0"){
    //検索済状態
      document.fm1.functionId.value = 'Search';
//  }else if(document.fm1.pageFlag.value == "1"){
    //検索されていない状態
//      document.fm1.functionId.value = 'Init';
//  }
    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  //}
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
  // 全ウィンドウが正常ならばtrue
  return true;
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
  }
}

//組織選択ボタン
function soshikiPopBtn(func){
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

	if(func == 1){
		document.fm1.callBack.value = "callBackTantoSoshikiPop";
	} else {
		document.fm1.callBack.value = "callBackReqSoshikiPop";
	}

	comSubmitForAnyWarp(fm1);
	comClickFlgInit();
}

//組織検索ポップアップから値受け取り
function callBackTantoSoshikiPop(bumonRank, sosCd, bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){
		document.fm1.tantoBumonRank.value    = bumonRank;
		document.fm1.tantoSosName.value = bumonSeiName;
		document.fm1.tantoSosCd.value        = sosCd;
		document.fm1.tantoUpSosCd.value        = upSosCode;
		document.fm1.kensakuSTantouBrCode.value       = brCode;
		document.fm1.kensakuTantouDistCode.value     = distCode;
		document.fm1.target = tmpTarget;
}

//組織検索ポップアップから値受け取り
function callBackReqSoshikiPop(bumonRank, sosCd, bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){
		document.fm1.kensakuShinseiBumonRank.value    = bumonRank;
		document.fm1.reqSosName.value = bumonSeiName;
		document.fm1.kensakuShinseiSosCd.value        = sosCd;
		document.fm1.kensakuShinseiBrCode.value       = brCode;
		document.fm1.kensakuShinseiDistCode.value     = distCode;
		document.fm1.target = tmpTarget;
}

//担当者選択ボタン
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

		document.fm1.sosCdPop.value = document.fm1.tantoSosCd.value;
		document.fm1.bumonRankPop.value = document.fm1.tantoBumonRank.value;
		document.fm1.upSosCdPop.value = document.fm1.tantoUpSosCd.value;

		document.fm1.selectFlgPop.value="1";
		document.fm1.callBack.value="callBackTantoPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
}

//担当者検索ポップアップから値受け取り
function callBackTantoPop(sosCd, bumonSeiName, jgiNo, jgiName, trtCd, brCode,
							distCode, trtGrpCd, trtNm, mrCat){
		document.fm1.tantoSosCd.value = sosCd;
		document.fm1.tantoSosName.value = bumonSeiName;
		document.fm1.kensakuJgiNo.value = jgiNo;
		document.fm1.kensakuSTantouBrCode.value       = brCode;
		document.fm1.kensakuTantouDistCode.value = distCode;
		document.fm1.jgiName.value = jgiName;
		document.fm1.target = tmpTarget;
}