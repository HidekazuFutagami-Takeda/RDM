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
var gCseViewFromWin = null;    // 組織従業員選択(組織・担当(現))
var gCseViewToWin = null;      // 組織従業員選択(組織・担当(新))
var gCtcViewWin = null;        // JIS府県武田市区郡選択
var gIiiViewWin=null;          // 施設固定コード複数入力
var gCpcViewWin=null;          // 品目選択開始
var gCseViewChgWin=null;       // 組織従業員選択(変更担当者)
var gCseViewToJgiWin=null;     // 組織従業員選択(新担当者)
var gCseViewSosWin=null;       // 組織従業員選択(組織)
/**
 * <pre>
 *  全メッセージ格納用配列
 * 当画面で使用する全メッセージが格納されます。
 * </pre>
 */
var gMsg = new Array();

function NM011Seni() {
	var val1 = fm1.reqFlg.value;

	if(val1 == "1"){
	if (!jkrDestructChack()) return false;
	COM_Click_flg = true;
	var tmpReq = fm1.reqId.value;
	var reqIdcell = fm1.reqId.value;
	var nm101Tab;

	fm1.reqId.value=reqIdcell;

	fm1.serchReqId.value=reqIdcell;


	if(nm101Tab && !nm101Tab.closed){
		nm101Tab.close();
	}

	nc001Tab = window.open("","NM101Tab");
	document.fm1.target="NM101Tab";
	//fm1.jokenFlg.value='0'
	fm1.screenId.value='NC011';
	fm1.functionId.value="Search";
	comSubmitForAnyWarp(fm1);
	comClickFlgInit();
	}
}
/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function rdmSearch(reqId) {

	if (!jkrDestructChack()) return false;
	var reqIdcell = fm1.reqId.value;


	fm1.reqId.value=reqId;
	fm1.reqId.value=reqIdcell;
	fm1.reqFlg.value="2";

	document.fm1.target = "";
      document.fm1.screenId.value	= "NM101";
      document.fm1.functionId.value = 'Search';


    //選択された組織情報格納（表示押下前→表示押下後）
//    setTopChangedSos();
//
//    //20150202 HISOL Suzuki 本番課題No.25対応 ADD START
//    //選択された組織情報格納（ポップアップ用）
//    setSearchSosCdPop();
    //20150202 HISOL Suzuki 本番課題No.25対応 ADD END

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);


}

function rdmRegister() {

	if (!jkrDestructChack()) return false;

      //document.fm1.jkrSosNtyPri.disabled = false;
      //document.fm1.inHisYmdhmsFrom.disabled = false;
      //document.fm1.inHisYmdhmsTo.disabled = false;

	document.fm1.target = "";
      document.fm1.screenId.value	= "NM101";
      document.fm1.functionId.value = 'Register';



    //選択された組織情報格納（表示押下前→表示押下後）
//    setTopChangedSos();
//
//    //20150202 HISOL Suzuki 本番課題No.25対応 ADD START
//    //選択された組織情報格納（ポップアップ用）
//    setSearchSosCdPop();
    //20150202 HISOL Suzuki 本番課題No.25対応 ADD END

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);

}

function NM011Sort(sortCondition) {
	if (!jkrDestructChack()) return false;

	  //ソート区分設定
	  document.fm1.sortCondition.value = sortCondition;
    document.fm1.screenId.value	= "NM011";
    document.fm1.functionId.value = 'Sort';

  comSubmitForAnyWarp(fm1);
}


/**
 * <pre>
 *  ページ切替え
 * ページ切替えリンク押下時に呼ばれます。
 * </pre>
 */
function NM011Page( pageCntCur ){
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = pageCntCur;
  document.fm1.screenId.value	= "NM011";
  document.fm1.functionId.value = 'Page';
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}
function popClear(){
	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	document.fm1.bumonRank.value = "";
	document.fm1.sosCd.value = "";
	document.fm1.bumonRyakuName.value = "";
	document.fm1.brCode.value = "";
	document.fm1.distCode.value = "";
}

function rdmCler(){
	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

	document.fm1.inHisYmdhmsFrom.value = "";
	document.fm1.inHisYmdhmsTo.value = "";
	document.fm1.ntySubject.value = "";
	document.fm1.ntyPri.value = "";
	document.fm1.dataDupCheck.checked = false;
	document.fm1.ultRnkCheck.checked = false;
	document.fm1.fbResCheck.checked = false;
	document.fm1.consCheck.checked = false;
	document.fm1.othersCheck.checked = false;
	document.fm1.unconCheck.checked = false;
	document.fm1.ubderCheck.checked = false;
	document.fm1.resolvCheck.checked = false;
	document.fm1.onlyCheck.checked = false;

	document.fm1.dataDupCheck.disabled = false;
		document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.ultRnkCheck.disabled = false;
		document.fm1.ultRnkCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.fbResCheck.disabled = false;
		document.fm1.fbResCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.consCheck.disabled = false;
		document.fm1.consCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.othersCheck.disabled = false;
		document.fm1.othersCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.unconCheck.disabled = false;
		document.fm1.unconCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.ubderCheck.disabled = false;
		document.fm1.ubderCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.resolvCheck.disabled = false;
		document.fm1.resolvCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.dataDupCheck.disabled = false;
		document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.inHisYmdhmsFrom.disabled = false;
		document.fm1.inHisYmdhmsFrom.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.inHisYmdhmsTo.disabled = false;
		document.fm1.inHisYmdhmsTo.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.jkrSosNtySubject.disabled = false;
		document.fm1.jkrSosNtySubject.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.jkrSosNtyPri.disabled = false;
		document.fm1.jkrSosNtyPri.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.getElementById('jkrSosNtySubject').options[1].hidden=false;
		document.getElementById('jkrSosNtySubject').options[2].hidden=false;
		document.getElementById('jkrSosNtySubject').options[3].hidden=false;
		document.getElementById('jkrSosNtySubject').options[4].hidden=false;
		document.getElementById('jkrSosNtySubject').options[5].hidden=false;
		document.getElementById('jkrSosNtySubject').options[6].hidden=false;
		document.getElementById('jkrSosNtySubject').options[7].hidden=false;
		document.getElementById('jkrSosNtySubject').options[8].hidden=false;
		document.getElementById('jkrSosNtySubject').options[9].hidden=false;
		document.getElementById('jkrSosNtySubject').options[10].hidden=false;
		document.getElementById('jkrSosNtySubject').options[11].hidden=false;
		document.getElementById('jkrSosNtySubject').options[12].hidden=false;
		document.getElementById('jkrSosNtySubject').options[13].hidden=false;

		document.getElementById('jkrSosNtyPri').options[1].hidden=false;
		document.getElementById('jkrSosNtyPri').options[2].hidden=false;
		document.getElementById('jkrSosNtyPri').options[3].hidden=false;


}
function gotoNext(screenId,functionId){
	  //getParam();
	  fm1.screenId.value=screenId;
	  fm1.functionId.value=functionId;
	  comSubmitForAnyWarp(fm1);
	}



/**
 * <pre>
 *  検索
 * 連携種別選択時に呼ばれます。
 * </pre>
 */

function sosReqSbt(){

 	 //申請チャネル
      document.getElementById("jkrSosReqChlMap").value = "";
      //document.getElementById("jkrSosReqChlMap").value = null; //nullにしなければならない場合はこれ。
}


/**
 * <pre>
 *  検索
 * 申請チャネル選択時に呼ばれます。
 * </pre>
 */
 function sosAddrChange() {

 	//連携種別
 	 var val2 = document.getElementById("jkrSosReqSbtMap");
 	 //選択された申請チャネル
      var val1 = document.getElementById("jkrSosReqChlMap").value;

      for (i = 0; i < val2.length; i++) {
     	 //表示
     	 val2.options[i].style.display = "block";

     	 var val2Cd = val2[i].value;
     	 //市区町村コードの頭2つ切り取る
     	 var val1cut = val1.toString().substr( 0, 1);
     	 if (val2Cd != val1cut) {
     		 val2.value = val1cut;
          }

      }
 }


 /**
  * 種別選択時に呼ばれます。
  * 施設・医師の片方のみ入力できる状態にする処理
  *
  * @returns
  */
 function sosSbt(){

	 var val1 = document.getElementById("onlyCheck").checked;

     if (val1 == true) {

			document.fm1.dataDupCheck.disabled = true;
			document.fm1.dataDupCheck.checked = false;
			document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.ultRnkCheck.disabled = true;
			document.fm1.ultRnkCheck.checked = false;
			document.fm1.ultRnkCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.fbResCheck.disabled = true;
			document.fm1.fbResCheck.checked = false;
			document.fm1.fbResCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.consCheck.disabled = true;
			document.fm1.consCheck.checked = false;
			document.fm1.consCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.othersCheck.disabled = true;
			document.fm1.othersCheck.checked = false;
			document.fm1.othersCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.unconCheck.disabled = true;
			document.fm1.unconCheck.checked = false;
			document.fm1.unconCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.ubderCheck.disabled = true;
			document.fm1.ubderCheck.checked = false;
			document.fm1.ubderCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.resolvCheck.disabled = true;
			document.fm1.resolvCheck.checked = false;
			document.fm1.resolvCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.dataDupCheck.disabled = true;
			document.fm1.dataDupCheck.checked = false;
			document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.jkrSosNtySubject.disabled = true;
			document.fm1.jkrSosNtySubject.value = "";
			document.fm1.jkrSosNtySubject.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.jkrSosNtyPri.disabled = true;
			//document.fm1.jkrSosNtyPri.value = "3";
			document.fm1.jkrSosNtyPri.style.backgroundColor = JKR_BG_COLOR_DISABLED;

			//document.fm1.inHisYmdhmsFrom.value = document.fm1.knYmdhmsFrom.value;
			//document.fm1.inHisYmdhmsTo.value = document.fm1.knYmdhmsTo.value;
			document.fm1.inHisYmdhmsFrom.disabled = true;
			document.fm1.inHisYmdhmsFrom.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.inHisYmdhmsTo.disabled = true;
			document.fm1.inHisYmdhmsTo.style.backgroundColor = JKR_BG_COLOR_DISABLED;

 		document.getElementById('jkrSosNtySubject').options[1].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[2].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[3].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[4].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[5].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[6].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[7].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[8].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[9].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[10].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[11].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[12].hidden=true;
 		document.getElementById('jkrSosNtySubject').options[13].hidden=true;

 		document.getElementById('jkrSosNtyPri').options[1].hidden=true;
 		document.getElementById('jkrSosNtyPri').options[2].hidden=true;
 		document.getElementById('jkrSosNtyPri').options[3].hidden=true;

     } else {

 		document.fm1.dataDupCheck.disabled = false;
 		document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.ultRnkCheck.disabled = false;
			document.fm1.ultRnkCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.fbResCheck.disabled = false;
			document.fm1.fbResCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.consCheck.disabled = false;
			document.fm1.consCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.othersCheck.disabled = false;
			document.fm1.othersCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.unconCheck.disabled = false;
			document.fm1.unconCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.ubderCheck.disabled = false;
			document.fm1.ubderCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.resolvCheck.disabled = false;
			document.fm1.resolvCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.dataDupCheck.disabled = false;
			document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.inHisYmdhmsFrom.disabled = false;
			document.fm1.inHisYmdhmsFrom.style.backgroundColor = JKR_BG_COLOR_NORMAL;
			document.fm1.inHisYmdhmsTo.disabled = false;
			document.fm1.inHisYmdhmsTo.style.backgroundColor = JKR_BG_COLOR_NORMAL;
 		document.fm1.jkrSosNtySubject.disabled = false;
 		document.fm1.jkrSosNtySubject.style.backgroundColor = JKR_BG_COLOR_NORMAL;
 		document.fm1.jkrSosNtyPri.disabled = false;
 		document.fm1.jkrSosNtyPri.style.backgroundColor = JKR_BG_COLOR_NORMAL;
 		document.getElementById('jkrSosNtySubject').options[1].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[2].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[3].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[4].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[5].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[6].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[7].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[8].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[9].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[10].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[11].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[12].hidden=false;
 		document.getElementById('jkrSosNtySubject').options[13].hidden=false;

 		document.getElementById('jkrSosNtyPri').options[1].hidden=false;
 		document.getElementById('jkrSosNtyPri').options[2].hidden=false;
 		document.getElementById('jkrSosNtyPri').options[3].hidden=false;

     }

	 if(val1 == ''){
			document.fm1.insNo.disabled = true;
		    document.fm1.insNo.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.insKanjiSrch.disabled = true;
			document.fm1.insKanjiSrch.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.insClass.disabled = true;
			document.fm1.insClass.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.insSbt.disabled = true;
			document.fm1.insSbt.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.hoInsType.disabled = true;
			document.fm1.hoInsType.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.docNo.disabled = true;
			document.fm1.docNo.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.docKanj.disabled = true;
			document.fm1.docKanj.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.docType.disabled = true;
			document.fm1.docType.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.fm1.jobForm.disabled = true;
			document.fm1.jobForm.style.backgroundColor = JKR_BG_COLOR_DISABLED;
			document.getElementById('jkrSosReqTypeMap').options[1].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[2].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[3].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[4].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[5].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[6].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[7].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[8].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[9].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[10].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[11].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[12].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[13].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[14].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[15].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[16].hidden=false;

	 }

	 if(val1 == '0'){
		document.fm1.docNo.value = "";
		document.fm1.docNo.disabled = true;
	    document.fm1.docNo.style.backgroundColor = JKR_BG_COLOR_DISABLED;
		document.fm1.docKanj.value = "";
		document.fm1.docKanj.disabled = true;
		document.fm1.docKanj.style.backgroundColor = JKR_BG_COLOR_DISABLED;
		document.fm1.docType.value = "";
		document.fm1.docType.disabled = true;
		document.fm1.docType.style.backgroundColor = JKR_BG_COLOR_DISABLED;
		document.fm1.jobForm.value = "";
		document.fm1.jobForm.disabled = true;
		document.fm1.jobForm.style.backgroundColor = JKR_BG_COLOR_DISABLED;

		document.fm1.insNo.disabled = false;
		document.fm1.insNo.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.insKanjiSrch.disabled = false;
		document.fm1.insKanjiSrch.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.insClass.disabled = false;
		document.fm1.insClass.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.insSbt.disabled = false;
		document.fm1.insSbt.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.hoInsType.disabled = false;
		document.fm1.hoInsType.style.backgroundColor = JKR_BG_COLOR_NORMAL;

		document.getElementById('jkrSosReqTypeMap').options[9].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[10].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[11].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[12].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[13].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[14].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[15].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[16].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[1].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[2].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[3].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[4].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[5].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[6].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[7].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[8].hidden=false;
	 }
	 if(val1 == '1'){
		document.fm1.insNo.value = "";
		document.fm1.insNo.disabled = true;
		document.fm1.insNo.style.backgroundColor = JKR_BG_COLOR_DISABLED;
		document.fm1.insKanjiSrch.value = "";
		document.fm1.insKanjiSrch.disabled = true;
		document.fm1.insKanjiSrch.style.backgroundColor = JKR_BG_COLOR_DISABLED;
		document.fm1.insClass.value = "";
		document.fm1.insClass.disabled = true;
		document.fm1.insClass.style.backgroundColor = JKR_BG_COLOR_DISABLED;
		document.fm1.insSbt.value = "";
		document.fm1.insSbt.disabled = true;
		document.fm1.insSbt.style.backgroundColor = JKR_BG_COLOR_DISABLED;
		document.fm1.hoInsType.value = "";
		document.fm1.hoInsType.disabled = true;
		document.fm1.hoInsType.style.backgroundColor = JKR_BG_COLOR_DISABLED;

		document.fm1.docNo.disabled = false;
		document.fm1.docNo.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.docKanj.disabled = false;
		document.fm1.docKanj.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.docType.disabled = false;
		document.fm1.docType.style.backgroundColor = JKR_BG_COLOR_NORMAL;
		document.fm1.jobForm.disabled = false;
		document.fm1.jobForm.style.backgroundColor = JKR_BG_COLOR_NORMAL;

		document.getElementById('jkrSosReqTypeMap').options[1].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[2].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[3].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[4].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[5].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[6].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[7].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[8].hidden=true;

		document.getElementById('jkrSosReqTypeMap').options[9].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[10].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[11].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[12].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[13].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[14].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[15].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[16].hidden=false;
	 }
 	 //申請チャネル
      document.getElementById("jkrSosReqChlMap").value = "";
      //document.getElementById("jkrSosReqChlMap").value = null; //nullにしなければならない場合はこれ。
 }
 //コンテキスト メニューあり




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
//	      document.fm1.functionId.value = 'Init';
	//  }
	    // 検索イベント呼び出し
	    comSubmitForAnyWarp(fm1);
	  //}
	}

/**
 * <pre>
 *  ソート
 * ソートリンク押下時に呼ばれます。
 * </pre>
 */
function jimSort(sortCondition){
	  // 変更内容破棄確認チェック
	  if (!jkrDestructChack()) return false;

	  //現在ページ番号変更（遷移）
	  //document.fm1.pageCntCur.value = 1;

	  //ソート区分設定
	  document.fm1.sortCondition.value = sortCondition;

	  //document.fm1.screenId.value	= document.fm1.gamenId.value;
	  document.fm1.screenId.value	= "NM011";
	  document.fm1.functionId.value = 'Sort';

	  // 検索イベント呼び出し
	  comSubmitForAnyWarp(fm1);  --フォームの中のfm1の値がすべて入っている
	}


/**
 * <pre>
 * 施設固定Ｃ　コールバック関数。
 * </pre>
 */
function tmpCallBackInsView(insNo) {
  // チェック済みを初期化
  if (insNo != null && insNo != "" ) {
    //表示用の項目に値を設定します。
    document.fm1.searchInsNo.value = insNo;
    document.fm1.joinInsNo.value = insNo;

    //関連項目をクリアし、入力付加にする
    document.fm1.searchInsName.disabled = true;  //施設名（漢字）
    document.fm1.searchInsName.value = "";
    document.fm1.searchInsName.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    document.fm1.dispInsKana.disabled = true;  //施設名（全角カナ）
    document.fm1.dispInsKana.value = "";
    document.fm1.dispInsKana.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    document.fm1.searchHoInsType.disabled = true;  //対象区分
    document.fm1.searchHoInsType.value = "0";
    if (document.fm1.trtGrpCd.value == '003') {
      document.fm1.searchVacVisitType.disabled = true;  //ワクチン区分
      document.fm1.searchVacVisitType.value ="0";
    } else {
      document.fm1.searchPharmType.disabled = true;  //施設区分
      document.fm1.searchPharmType.value ="0";
    }
    document.fm1.bCtcView.disabled = true; //ＪＩＳ府県武田市区郡
    document.fm1.dispAddrNamePrefCity.value	="";
  }
}


//戻るボタン
function backBtn(){
	document.fm1.target="";
	const preScreenId = document.fm1.preScreenId.value;
	if(preScreenId == "NM011"){
		if(window.confirm("通知一覧画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
			window.close();
			document.fm1.screenId.value = preScreenId;
			document.fm1.functionId.value="Init";

			comSubmitForAnyWarp(fm1);
		}
	} else if(preScreenId == "NM101"){
		if(window.confirm("通知一覧画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
			window.close();
			document.fm1.screenId.value = preScreenId;
			document.fm1.functionId.value="Init";

			comSubmitForAnyWarp(fm1);
		}
	}
}
function jimClear( name ) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 組織･担当(現)
  if ( name == 'fromSosJgi' ) {
    document.fm1.dispFromSosJgiName.value = "";
    document.fm1.searchFromSosCd.value = "";
    document.fm1.searchFromSosName.value = "";
    document.fm1.searchFromJgiNo.value = "";
    document.fm1.searchFromJgiName.value = "";
    document.fm1.sosCdC040.value = "";
    document.fm1.jgiNoC040.value = "";
    document.fm1.searchFromSosCd2.value = "";
    document.fm1.searchFromSosNm2.value = "";
    document.fm1.searchFromSosCd3.value = "";
    document.fm1.searchFromSosCd4.value = "";
    dispRngCtl("0");
    // 組織･担当(新)
  } else if ( name == 'toSosJgi' ) {
    document.fm1.dispToSosJgiName.value = "";
    document.fm1.searchToSosCd.value = "";
    document.fm1.searchToSosName.value = "";
    document.fm1.searchToJgiNo.value = "";;
    document.fm1.searchToJgiName.value = "";
    document.fm1.searchToSosCd3.value = "";

  // JIS府県武田市区郡
  } else if ( name == 'tkCity' ) {
    document.fm1.dispAddrNamePrefCity.value = "";
    document.fm1.searchAddrCodePref.value = "";
    document.fm1.searchTkCityCd.value = "";
    document.fm1.JISFk.value = "";
    //チェック済みのJIS府県・武田市区郡を消去
    document.getElementById('checkedJisCodes').innerHTML="";
  // 施設固定CD複数入力対応
  // 施設固定CD
  } else if ( name == 'searchInsNo' ) {
    document.fm1.searchInsNo.value = "";  //施設固定CD
    document.fm1.joinInsNo.value = "";
    if(document.fm1.bSearchInsNo.disabled == false){
      //関連項目を入力可にする
      document.fm1.searchInsName.disabled = false;  //施設名（漢字）
      document.fm1.searchInsName.style.backgroundColor = JKR_BG_COLOR_NORMAL;
      document.fm1.dispInsKana.disabled = false;  //施設名（全角カナ）
      document.fm1.dispInsKana.style.backgroundColor = JKR_BG_COLOR_NORMAL;
      document.fm1.searchHoInsType.disabled = false;  //対象区分
      if (document.fm1.trtGrpCd.value == '003') {
        document.fm1.searchVacVisitType.disabled = false;  //ワクチン区分
      } else {
        document.fm1.searchPharmType.disabled = false;  //施設区分
      }
      document.fm1.bCtcView.disabled = false;  //ＪＩＳ府県武田市区郡
    }
  } else if (name == "changeJgi") {
      document.fm1.changeJgiName.value = "";   //新担当者_テキスト
      document.fm1.changeJgiNo.value = "";     //新担当者_従業員番号番号
      document.fm1.changeSosCd.value = "";     //新担当者_組織コード
      document.fm1.changeSosName.value = "";   //新担当者_組織名称
      document.fm1.changeSosCdDist.value = ""; //新担当者_新組織コード(所属営業所)
      if (document.fm1.gamenId.value == "JKR040C010") {
        setAllChgBtnStatus010("chgInsTrtList");
      } else if (document.fm1.gamenId.value == "JKR040C020") {
      } else if (document.fm1.gamenId.value == "JKR040C030") {
        setAllChgBtnStatus("chgInsCityList");
      } else if (document.fm1.gamenId.value == "NM011") {
        setAllChgBtnStatus010("chgInsTrtList");
      }
  } else if (name == 'chgAddSos') {
    document.fm1.chgAddSosName.value = "";  // 従業員名称(表示用)
    document.fm1.chgAddSosCd.value = "";    // 検索用組織コード
  }
}
/**
 * <pre>
 *  検索前のチェック
 * 入力チェックを行います。
 * </pre>
 * @return true:エラーなし false:エラーあり
 */
function jimChkBeforeSearch(){

  // エラーメッセージ
  var errMsg = "";
  var msg = "";
  // 組織・担当(現)と組織・担当(現)のどちらか一方が入力されているかチェック
  if ( document.fm1.dispFromSosJgiName.value == ""
    && document.fm1.dispToSosJgiName.value == "" ) {
    //『「組織・担当(現)」及び「組織・担当(新)」が設定されていません。\nどちらかの指定が必須となります。』
    errMsg += (gMsg[0] + "\n");
    document.fm1.dispFromSosJgiName.focus();
  }
  //施設名(全角カナ)の入力チェック(全角カナ文字数20)
  var insKana = document.fm1.dispInsKana.value;
  if (insKana != "") {
    msg = comChkFullSizeChar(insKana,'施設名(全角カナ)',20);
    if (msg != "") {
      errMsg += ( gMsg[1] + "\n");
      document.fm1.dispInsKana.focus();
    }
  }
  if (document.fm1.searchDeveWay.value == "") {
    errMsg += (gMsg[2] + "\n");
    document.fm1.searchDeveWay.focus();
  }
  // エラーメッセージの表示
  if (errMsg != "") {
    alert(errMsg);
    return false;
  }
  return true;
}



/**
 * <pre>
 * 領域の新担当者の戻るボタン押下時に呼ばれます。
 * </pre>
 * @param listName リスト名称
 * @param rowNo 行番号
 * @param trtNo 領域番号
 */
function jimResetFromMrTrt(listName, rowNo, trtNo) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 新担当MRNO(HIDDEN用)
  var toJgiNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var fromJgiNoId = listName + "[" + rowNo + "].fromMrNo" + trtNo;
  document.getElementsByName(toJgiNoId)[0].value = document.getElementsByName(fromJgiNoId)[0].value;
  // 新担当MR名称(表示用)
  var toJgiNameId = listName + "[" + rowNo + "].toJgiName" + trtNo;
  var fromJgiNameId = listName + "[" + rowNo + "].fromJgiName" + trtNo;
  var toJgiName = document.getElementsByName(fromJgiNameId)[0].value;
  var toMrNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var toMrNo = document.getElementsByName(toMrNoId)[0].value;
  if (toMrNo == "") {
    toJgiName = "担当者選択";
  }
  document.getElementsByName(toJgiNameId)[0].value = toJgiName;
  // 新組織コード(HIDDEN用)
  var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
  var fromSosCdId = listName + "[" + rowNo + "].fromSosCd" + trtNo;
  document.getElementsByName(toSosCdId)[0].value = document.getElementsByName(fromSosCdId)[0].value;
  // 新組織名称(HIDDEN用)
  var toSosNameId = listName + "[" + rowNo + "].toSosName" + trtNo;
  //20150303 ST-B-367対応 HISOL鈴木 MOD START
  //var fromSosNameId = listName + "[" + rowNo + "].fromSosName" + trtNo;
  var fromSosNameId = listName + "[" + rowNo + "].toSosNameBef" + trtNo;
  //20150303 ST-B-367対応 HISOL鈴木 MOD END
  document.getElementsByName(toSosNameId)[0].value = document.getElementsByName(fromSosNameId)[0].value;
  // 新組織コード(所属営業所)(HIDDEN用)
  var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist" + trtNo;
  var summarySosCdId = listName + "[" + rowNo + "].summarySosCd" + trtNo;
  document.getElementsByName(toSosCdDistId)[0].value = document.getElementsByName(summarySosCdId)[0].value;
  // 画面表示用
  if (trtNo != "") {
    var spanToSosNameDispId = listName + "[" + rowNo + "].spanToSosName" + trtNo;
    //2014/12/16 戻すボタン押下で「担当者選択」となる場合、組織名もクリア
    if (toMrNo == "") {
        document.getElementById(spanToSosNameDispId).innerText = "";
    }else{
        document.getElementById(spanToSosNameDispId).innerText = document.getElementsByName(fromSosNameId)[0].value;
    }
  }
  var spanToJigiNameDispId = listName + "[" + rowNo + "].spanToJgiName" + trtNo;
  document.getElementById(spanToJigiNameDispId).innerText = toJgiName;

  //20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
  // 現担当者がダミー(従業員区分 = "8")の場合、changeFlgを"9"(副担追加データ一括削除対象)にしておく。
  // ※現担当がダミーユーザの行において一度「元に戻す」をしたら副担追加データを削除するため。
  // 現担当者従業員区分
  var fromJgiKbId = listName + "[" + rowNo + "].fromJgiKb" + trtNo;
  var fromJgiKb = document.getElementsByName(fromJgiKbId)[0].value;
  // 背景色ランク
  var bgColorRnkId = listName + "[" + rowNo + "].bgColorRnk" + trtNo;
  var bgColorRnk = document.getElementsByName(bgColorRnkId)[0].value;
  // 担当変更フラグ
  var changeFlgId = listName + "[" + rowNo + "].changeFlg" + trtNo;
  if (fromJgiKb == "8" && bgColorRnk != ""){
    document.getElementsByName(changeFlgId)[0].value = "9";
  }
  //20150402 期末期首課題対応No.227 HISOL鈴木 ADD END

  // 変更情報チェック
  jimCheckChangeInfo(listName, rowNo, trtNo);
  // 新担当と現担当が同じかどうかをチェック
  jimChkMrNo(listName, rowNo, trtNo);
}

