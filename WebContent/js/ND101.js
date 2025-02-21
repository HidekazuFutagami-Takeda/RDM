/**
 * <pre>
 *  ND101医療機関への異動のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author BHH 趙
 */


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
	 	 document.fm1.paramInsNo.value = document.fm1.preInsNo.value;
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