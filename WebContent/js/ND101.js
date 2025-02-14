/**
 * <pre>
 *  ND101医療機関への異動のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author BHH 趙
 */


var msgContent = ""; //確認メッセージ

function submitBtn(funcId) {

	if (funcId == "0") {
		document.fm1.tempReqBtnFlg.value = "1";
		msgContent = '<s:property value="#session.UserInfoKey.msgMap.I013.msgData" />';
		// 一時保存
		document.fm1.screenId.value = "ND101";
		document.fm1.functionId.value = "Register";
	} else if (funcId == "1") {
		document.fm1.reqBtnFlg.value = "1";
		msgContent = '<s:property value="#session.UserInfoKey.msgMap.I015.msgData" />';
		// 申請画面へ
		document.fm1.screenId.value = "ND307";
		document.fm1.functionId.value = "Init";
	}
	msgContent ='テスト';
	if (window.confirm(msgContent)) {
	} else {
		return false;
	}
	comSubmitForAnyWarp(fm1);
}
function comSetFormWindowInfo() {
	comClickFlgInit();
}

// 申請破棄ボタン
function reqCancelBtn() {
	document.fm1.target = "";
	msgContent = '<s:property value="#session.UserInfoKey.msgMap.I007.msgData" />';
	// 申請データを破棄（＝物理的に削除）し、遷移元画面へ遷移する（本画面のタブを閉じる）
	// 申請IDで対象を絞り込み申請管理、勤務先_申請管理を削除

	document.fm1.screenId.value = "ND101";
	document.fm1.functionId.value = "Cancel";
	msgContent ='テスト';
	if (window.confirm(msgContent)) {
	} else {
		return false;
	}
	comSubmitForAnyWarp(fm1);
}

// 戻るボタン
function backBtn() {
	document.fm1.target = "";
	msgContent = '<s:property value="#session.UserInfoKey.msgMap.I007.msgData" />';
	if (window.confirm(msgContent)) {
	} else {
		return false;
	}
	if(document.fm1.screenId.value == 'NC011'){
		document.fm1.screenId.value = "NC011";
		document.fm1.functionId.value = "init";

		comSubmitForAnyWarp(fm1);
	}else if(document.fm1.screenId.value == 'ND013'){
		document.fm1.screenId.value = "ND013";
		document.fm1.functionId.value = "init";
		comSubmitForAnyWarp(fm1);
	}
}

/**
 * 所属部科POPUP画面を呼び出します。
 *
 */
function tmpCdcView(index){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  //index 0:出身所属部科,1:勤務先情報 所属部科
  gCdcCsdViewSelId = index;
  // 全てのポップアップを閉じる
  hcpClosePopUp(gCdcViewWin, "gCdcViewWin");

 // パラメータの設定
  if(gCdcCsdViewSelId == "0") {
     document.fm1.cdcCheckedCodes.value = "";
     document.fm1.paramInsNo.value = "";
  } else if (gCdcCsdViewSelId == "1") {
     document.fm1.cdcCheckedCodes.value = "";
     document.fm1.paramInsNo.value = document.fm1.skInsNo.value;
  } else {//ここにはこない
  }
  document.fm1.backScreenId.value = "ND101";
  gCdcViewWin = cdcView(gCdcViewWin,"tmpCallBackShozokuViewRDM","gCdcViewWin");
  return(true);
}
