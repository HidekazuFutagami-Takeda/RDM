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


/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function rdmCheck(reqId,reqType) {

	if (!jkrDestructChack()) return false;

	var reqIdcell = fm1.reqId.value;
	var reqIdcell2 = fm1.reqId.value;


	fm1.reqId.value=reqId;
	if(reqType == '施設新規作成'){
	fm1.reqTypeCell.value='01';
	}
	if(reqType == '施設情報更新'){
		fm1.reqTypeCell.value='02';
		}
	if(reqType == '施設削除'){
		fm1.reqTypeCell.value='03';
		}
	if(reqType == '施設復活'){
		fm1.reqTypeCell.value='04';
		}
	if(reqType == '施設紐付け新規'){
		fm1.reqTypeCell.value='11';
		}
	if(reqType == '施設紐付け変更'){
		fm1.reqTypeCell.value='12';
		}
	if(reqType == '施設紐付け削除'){
		fm1.reqTypeCell.value='13';
		}
	if(reqType == '施設来期用項目更新'){
		fm1.reqTypeCell.value='21';
		}
	if(reqType == '医師新規作成'){
		fm1.reqTypeCell.value='31';
		}
	if(reqType == '医師情報更新'){
		fm1.reqTypeCell.value='32';
		}
	if(reqType == '医師削除'){
		fm1.reqTypeCell.value='33';
		}
	if(reqType == '医師復活'){
		fm1.reqTypeCell.value='34';
		}
	if(reqType == '医師勤務先追加'){
		fm1.reqTypeCell.value='41';
		}
	if(reqType == '医療機関への異動'){
		fm1.reqTypeCell.value='42';
		}
	if(reqType == '医療機関以外への異動'){
		fm1.reqTypeCell.value='43';
		}
	if(reqType == '医師勤務先削除'){
		fm1.reqTypeCell.value='44';
		}
	if(reqType == '勤務先情報更新'){
		fm1.reqTypeCell.value='51';
		}

	fm1.reqFlg.value="2";

	document.fm1.target = "";
      document.fm1.screenId.value	= "NC011";
      document.fm1.functionId.value = 'Check';
      bumonRyakuName = document.fm1.bumonRyakuName.value;

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
    fm1.reqId.value=reqIdcell;
}



function rdmSearch() {

	if (!jkrDestructChack()) return false;
	var reqIdcell = fm1.reqId.value;
	var reqIdcell2 = fm1.reqId.value;
	fm1.reqFlg.value="2";
	  document.fm1.target = "";
	  document.fm1.reqFlg.value = "0";
      document.fm1.screenId.value	= "NC011";

      document.fm1.functionId.value = 'Search';
      //document.fm1.bumonRyakuName.value = bumonRyakuName;

    //選択された組織情報格納（表示押下前→表示押下後）
//    setTopChangedSos();
//
//    //20150202 HISOL Suzuki 本番課題No.25対応 ADD START
//    //選択された組織情報格納（ポップアップ用）
//    setSearchSosCdPop();
    //20150202 HISOL Suzuki 本番課題No.25対応 ADD END

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
    fm1.reqId.value=reqIdcell;

}

// 住所候補ボタン
function addrPopBtn(){

	// NC205_住所候補ポップアップ画面を表示
	window.open("","addrPopWindow",addrSubScreenSize);
	document.fm1.screenId.value = "NC201";
	document.fm1.functionId.value="Init";
	document.fm1.target="addrPopWindow";

	document.fm1.callBack.value="callBackAddrPop";

	comSubmitForAnyWarp(fm1);
	comClickFlgInit();
}
function NC011Sort(sortCondition) {
	if (!jkrDestructChack()) return false;

	  //ソート区分設定
    document.fm1.sortCondition.value = sortCondition;
	document.fm1.target = "";
	fm1.reqFlg.value="2";
    document.fm1.screenId.value	= "NC011";
    document.fm1.functionId.value = 'Sort';

  comSubmitForAnyWarp(fm1);
}


/**
 * <pre>
 *  ページ切替え
 * ページ切替えリンク押下時に呼ばれます。
 * </pre>
 */
function NC011Page( pageCntCur ){
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  //現在ページ番号変更（遷移）
  document.fm1.target = "";
  fm1.reqFlg.value="2";
  document.fm1.pageCntCur.value = pageCntCur;
  document.fm1.screenId.value	= "NC011";
  document.fm1.functionId.value = 'Page';
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}
function popClear(){
	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	document.fm1.target = "";
	document.fm1.bumonRank.value = "";
	document.fm1.sosCd.value = "";
	document.fm1.bumonRyakuName.value = "";
	document.fm1.reqJgiName.value = "";
	reqJgiName = "";
	document.fm1.brCode.value = "";
	document.fm1.distCode.value = "";
}

function popClearDisabled(){

}

function rdmCler(){
	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	document.fm1.target = "";
	document.fm1.aDdrCodePref.value = "";
	document.fm1.sbt.value = "";
	//document.fm1.bumonRyakuName.value = "";
if(document.fm1.jokenFlg.value == 1){
	document.fm1.reqJgiName.value = "";
	reqJgiName = "";
}
	document.fm1.insNo.value = "";
	document.fm1.docNo.value = "";

	document.fm1.insKanjiSrch.value = "";
	document.fm1.docKanj.value = "";
	//document.fm1.inreqYmdhmsFrom.value = document.fm1.knYmdhmsFrom.value;
	//document.fm1.inreqYmdhmsTo.value = document.fm1.knYmdhmsTo.value;
	document.fm1.inreqYmdhmsFrom.value ="";
	document.fm1.inreqYmdhmsTo.value = "";
	document.fm1.insClass.value = "";
	document.fm1.docType.value = "";
	document.fm1.reqSbt.value = "";
	document.fm1.insSbt.value = "";
	document.fm1.jobForm.value = "";
	document.fm1.serchReqType.value = "";
	document.fm1.hoInsType.value = "";
	document.fm1.reqSts.value = "";
	document.fm1.serchReqId.value = "";
	document.fm1.reqComment.value = "";
	document.fm1.aprComment.value = "";
	document.fm1.reqChl.value = "";

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
	document.getElementById('jkrSosReqTypeMap').options[17].hidden=false;
	document.getElementById('jkrSosReqTypeMap').options[18].hidden=false;



}
function gotoNext(screenId,functionId){
	  //getParam();
	  fm1.screenId.value=screenId;
	  fm1.functionId.value=functionId;
	  comSubmitForAnyWarp(fm1);
	}

function reqBtn(screenId, insNo){
	var tmpIns = fm1.insNo.value;
	var nc011Tab;
	// 新規
	//if(screenId == "NF011"){
		//fm1.ultInsCd.value = insNo;
	//} else {
		//fm1.insNo.value = insNo;
	//}

	if(nc011Tab && !nc011Tab.closed){
		nc011Tab.close();
	}

	nf001Tab = window.open("","NC011Tab");
	document.fm1.target="NC011Tab";

	fm1.screenId.value=screenId;
	fm1.functionId.value="Init";
	comSubmitForAnyWarp(fm1);
	comClickFlgInit();

	fm1.insNo.value = tmpIns;
}

function NC011Seni() {
	if (!jkrDestructChack()) return false;
	document.fm1.target = "";
	var val1 = fm1.reqFlg.value;
	COM_Click_flg = true;
	if(val1 != "1"){
		//fm1.reqId.value = "";
	}
	if(val1 == "1"){
	var reqIdcell = fm1.reqIdCell.value;

	var reqTypecell = fm1.reqTypeCell.value;

	var tmpReq = fm1.reqId.value;
	var tmpType = fm1.reqType.value;
	var nc011Tab;

	fm1.reqId.value=reqIdcell;
	fm1.reqType.value=reqTypecell;



	  //申請区分遷移先設定
//	if(reqType == "01"){
//		alert("NF011_施設新規作成に遷移します")
//		gotoNext('NF011','Init');
//	}
//	if(reqType == "02"){
//		alert("NF012_施設情報更新に遷移します")
//		gotoNext('NF012','Init');
//	}
//	if(reqType == "03"){
//		alert("NF013_施設削除に遷移します")
//		gotoNext('NF013','Init');
//	}
//	if(reqType == "04"){
//		alert("NF014_施設復活に遷移します")
//		gotoNext('NF014','Init');
//	}
//	if(reqType == "11"){
//		alert("NF211_施設紐づけ作成に遷移します")
//		gotoNext('NF211','Init');
//	}
//	if(reqType == "12"){
//		alert("NF212_親施設の変更に遷移します")
//		gotoNext('NF212','Init');
//	}
//	if(reqType == "13"){
//		alert("NF213_施設紐づけの削除に遷移します")
//		gotoNext('NF213','Init');
//	}
//	if(reqType == "21"){
//		alert("NF101_施設来期情報更新に遷移します")
//		gotoNext('NF101','Init');
//	}
//	if(reqType == "31"){
//		alert("ND011_医師新規作成に遷移します")
//		gotoNext('ND011','Init');
//	}
//	if(reqType == "32"){
//		alert("ND012_医師情報更新に遷移します")
//		gotoNext('ND012','Init');
//	}
//	if(reqType == "33"){
//		alert("ND105_医師削除に遷移します")
//		gotoNext('ND015','Init');
//	}
//	if(reqType == "34"){
//		alert("ND014_医師復活に遷移します")
//		gotoNext('ND014','Init');
//	}
//	if(reqType == "41"){
//		alert("ND103_医師勤務先追加に遷移します")
//		//gotoNext('ND113','Init');
//		gotoNext('ND103','Init');
//	}
//	if(reqType == "42"){
//		alert("ND101_医療機関への異動に遷移します")
//		gotoNext('ND101','Init');
//	}
//	if(reqType == "43"){
//		alert("ND102_医療機関以外への異動に遷移します")
//		gotoNext('ND102','Init');
//	}
//	if(reqType == "44"){
//		alert("ND104_医師勤務先削除に遷移します")
//		gotoNext('ND104','Init');
//	}
//	if(reqType == "51"){
//		alert("ND013_勤務先情報更新に遷移します")
//		gotoNext('ND014','Init');
//	}
	if(reqTypecell == "01"){
		//alert("NF011_施設新規作成に遷移します")

		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF011';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";

		//fm1.insNo.value = tmpIns;

		//gotoNext('NF011','Init');
	}
	if(reqTypecell == "施設新規作成"){
		//alert("NF011_施設新規作成に遷移します")

		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF011';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();

		//fm1.insNo.value = tmpIns;

		//gotoNext('NF011','Init');
	}
	if(reqTypecell == "02"){
		//alert("NF012_施設情報更新に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF012';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "施設情報更新"){
		//alert("NF012_施設情報更新に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF012';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
	}
	if(reqTypecell == "03"){
		//alert("NF013_施設削除に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF013';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "施設削除"){
		//alert("NF013_施設削除に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF013';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
	}
	if(reqTypecell == "04"){
		//alert("NF014_施設復活に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF014';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "施設復活"){
		//alert("NF014_施設復活に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF014';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
	}
	if(reqTypecell == "11"){
		//alert("NF211_施設紐づけ作成に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF211';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "施設紐付け新規"){
		//alert("NF211_施設紐づけ作成に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF211';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "12"){
		//alert("NF212_親施設の変更に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF212';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "施設紐付け変更"){
		//alert("NF212_親施設の変更に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF212';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "13"){
		//alert("NF213_施設紐づけの削除に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF213';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "施設紐付け削除"){
		//alert("NF213_施設紐づけの削除に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF213';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "21"){
		//alert("NF101_施設来期情報更新に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF101';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "施設来期用項目更新"){
		//alert("NF101_施設来期情報更新に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='NF101';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "31"){
		//alert("ND011_医師新規作成に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND011';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "医師新規作成"){
		//alert("ND011_医師新規作成に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND011';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "32"){
		//alert("ND012_医師情報更新に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND012';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "医師情報更新"){
		//alert("ND012_医師情報更新に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND012';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "33"){
		//alert("ND105_医師削除に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND105';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "医師削除"){
		//alert("ND105_医師削除に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND105';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "34"){
		//alert("ND014_医師復活に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND014';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "医師復活"){
		//alert("ND014_医師復活に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND014';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "41"){
		//alert("ND103_医師勤務先追加に遷移します")
		//gotoNext('ND113','Init');
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND103';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "医師勤務先追加"){
		//alert("ND103_医師勤務先追加に遷移します")
		//gotoNext('ND113','Init');
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND103';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "42"){
		//alert("ND101_医療機関への異動に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND101';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "医療機関への異動"){
		//alert("ND101_医療機関への異動に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND101';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "43"){
		//alert("ND102_医療機関以外への異動に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND102';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "医療機関以外への異動"){
		//alert("ND102_医療機関以外への異動に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND102';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "44"){
		//alert("ND104_医師勤務先削除に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND104';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "医師勤務先削除"){
		//alert("ND104_医師勤務先削除に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND104';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "51"){
		//alert("ND013_勤務先情報更新に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND013';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	if(reqTypecell == "勤務先情報更新"){
		//alert("ND013_勤務先情報更新に遷移します")
		if(nc011Tab && !nc011Tab.closed){
			nc011Tab.close();
		}

		nc001Tab = window.open("","NC011Tab");
		document.fm1.target="NC011Tab";

		fm1.screenId.value='ND013';
		fm1.functionId.value="Init";
		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
		//fm1.reqId.value="";
	}
	//fm1.reqId.value="";
	fm1.reqId.value = tmpReq;
	fm1.reqType.value = tmpType;
	}

	//fm1.reqId.value = "";
	//fm1.reqId.value=reqIdcell;

}


/**
 * <pre>
 *  検索
 * 連携種別選択時に呼ばれます。
 * </pre>
 */

function sosReqSbt(){
	document.fm1.target = "";
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
	 document.fm1.target = "";
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

 function reqDisable(){
	 document.fm1.target = "";
	  // 変更内容破棄確認チェック
	 document.fm1.bumonRyakuName.style.backgroundColor = JKR_BG_COLOR_DISABLED;
	 document.fm1.reqjgiName.style.backgroundColor = JKR_BG_COLOR_DISABLED;
	}


 /**
  * 種別選択時に呼ばれます。
  * 施設・医師の片方のみ入力できる状態にする処理
  *
  * @returns
  */
 function sosSbt(){
	 document.fm1.target = "";
	 var val1 = document.getElementById("jkrSosSbtMap").value;

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
			document.getElementById('jkrSosReqTypeMap').options[17].hidden=false;
			document.getElementById('jkrSosReqTypeMap').options[18].hidden=false;

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


		document.getElementById('jkrSosReqTypeMap').options[10].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[11].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[12].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[13].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[14].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[15].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[16].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[17].hidden=true;
		document.getElementById('jkrSosReqTypeMap').options[18].hidden=true;

		document.getElementById('jkrSosReqTypeMap').options[1].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[2].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[3].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[4].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[5].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[6].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[7].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[8].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[9].hidden=false;
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
		document.getElementById('jkrSosReqTypeMap').options[9].hidden=true;

		document.getElementById('jkrSosReqTypeMap').options[10].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[11].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[12].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[13].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[14].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[15].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[16].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[17].hidden=false;
		document.getElementById('jkrSosReqTypeMap').options[18].hidden=false;
	 }
 	 //申請チャネル
      //document.getElementById("jkrSosReqChlMap").value = "";
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
	document.fm1.target = "";
	  // 変更内容破棄確認チェック
	  if (!jkrDestructChack()) return false;

	  //現在ページ番号変更（遷移）
	  //document.fm1.pageCntCur.value = 1;

	  //ソート区分設定
	  document.fm1.sortCondition.value = sortCondition;

	  //document.fm1.screenId.value	= document.fm1.gamenId.value;
	  document.fm1.screenId.value	= "NC011";
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
	if(preScreenId == "NC001"){
		if(window.confirm("メニュー画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
			document.fm1.screenId.value = preScreenId;
			document.fm1.functionId.value="Init";

			comSubmitForAnyWarp(fm1);
		}
	} else if(preScreenId == "NM001"){
		//if(window.confirm("申請サマリ画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
			document.fm1.screenId.value = preScreenId;
			document.fm1.functionId.value="Init";

			comSubmitForAnyWarp(fm1);
		//}
	}else if(preScreenId == "NM101"){
		if(window.confirm("画面を閉じます。よろしいですか？（入力内容は破棄されます。）")){
			window.close();
		}
	}else if(preScreenId == "NM011"){
		if(window.confirm("画面を閉じます。よろしいですか？（入力内容は破棄されます。）")){
			window.close();
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
      } else if (document.fm1.gamenId.value == "NC011") {
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

