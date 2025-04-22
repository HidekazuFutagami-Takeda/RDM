/**
 * <pre>
 *  ND101医療機関への異動のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author BHH 趙
 */

var gCdcViewWin = null;        // 勤務先情報 所属部科POPUP用
var gCseViewWin = null;        // 勤務先情報 施設POPUP用

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

	  // 勤務先情報 所属部科ポップアップ
	  if(gCdcViewWin != null && targetWinName != "gCdcViewWin"){
		  gCdcViewWin.close();
		  gCdcViewWin = null;
	  }
	  // 勤務先情報 施設ポップアップ
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
  if(typeof(gCdcViewWin) == 'string') return false;     // 勤務先情報 所属部科ポップアップ
  if(typeof(gCseViewWin) == 'string') return false;     // 勤務先情報 施設ポップアップ
  // 全ウィンドウが正常ならばtrue
  return true;
}

/**
 * 所属部科POPUP画面を呼び出します。
 *
 */
function tmpCdcView(index){

  var insNo;
// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  //index 0:出身所属部科,1:勤務先情報 所属部科
  gCdcCsdViewSelId = index;
  // 全てのポップアップを閉じる
  hcpClosePopUp(gCdcViewWin, "gCdcViewWin");

  // パラメータの設定
  //異動先施設が設定されていない場合は所属施設から施設固定コードを取得
  if (gCdcCsdViewSelId == "0") {
	 document.fm1.cdcCheckedCodes.value = "";
	 insNo = document.fm1.postInsNo.value;
	 document.fm1.paramInsNo.value = document.fm1.postInsNo.value;

	 if (!insNo) {
	 	 //document.fm1.paramInsNo.value = document.fm1.preInsNo.value;
	 }
  } else {//ここにはこない
  }
  document.fm1.backScreenId.value = "ND101";
  gCdcViewWin = cdcView(gCdcViewWin,"tmpCallBackShozokuViewRDM","gCdcViewWin");
  return(true);
}

/**
 * <pre>
 * 出身所属部科POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShozokuViewRDM(deptCode,DeptKj,DeptKn){
//gCdcViewSelId 0:出身所属部科,1:勤務先情報 所属部科
	document.fm1.postDeptCode.value = deptCode;
	document.fm1.postDeptKj.value = DeptKj;
	document.fm1.postDeptKn.value = DeptKn;
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
  document.fm1.backScreenId.value = "ND101";
  gCseViewWin = cseView(gCseViewWin,"tmpCallBackShisetsuView","gCseViewWin");
  return(true);
}

/**
 * <pre>
 * 施設検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShisetsuView(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType,insClass){
    document.fm1.postInsNo.value = insNo;
    document.fm1.postInsAbbrName.value = insAbbrName;
    document.fm1.postHoInsType.value = hoInsType;
    document.fm1.postInsClass.value = insClass;
    document.fm1.postUltInsNo.value = dcfShisetsuCd;

    if(hoInsType == "1" && insClass == "01" && document.fm1.inputFlg.value == 1){
    	// 大学病院の場合大学職位を活性
    	document.getElementById("postUnivPosCode").disabled = false;
    } else {
    	// 大学職位を非活性
    	document.getElementById("postUnivPosCode").disabled = true;
    	document.getElementById("postUnivPosCode").value = "";
    }

    if(insNo != null && insNo != ""){
    	document.getElementById("deptBtn").disabled = false;
    } else {
    	document.getElementById("deptBtn").disabled = true;
    }
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
    	document.getElementById("deptBtn").disabled = true;
	}
	if (name == 'shozokubukaName') {
		document.fm1.postDeptKj.value = "";
		document.fm1.postDeptCode.value = "";
		document.fm1.postDeptKn.value = "";
	}
}

/**
 * <pre>
 *  登録、更新、削除処理
 * DB操作処理時に呼ばれます。
 * </pre>
 */
function nd101Register(buttonFlg){
  // 確認メッセージ表示
//  if (confirm(msgContent)){
//  } else {
//    return false;
//  }

  document.fm1.buttonFlg.value = buttonFlg;
  document.fm1.screenId.value = 'ND101';
  document.fm1.functionId.value = 'Register';

  //イベント呼び出し
  comSubmitForAnyWarp(fm1);
}