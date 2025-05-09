/**
 * <pre>
 *  医師新規登録画面のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var ND014_APPLICATION_ID = "ND014";
var msgContent = ""; //確認メッセージ
var gCdcViewWin = null;        // 勤務先情報 所属部科POPUP用
var gCseViewWin = null;        // 勤務先情報 施設POPUP用

/**
 * <pre>
 * clear(リンク)押下時に呼ばれます。
 *@param name クリア項目名
 * </pre>
 */
function nd014Clear( name ) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 勤務先情報 施設
  if ( name == 'skIns' ) {
    document.fm1.skInsNo.value = "";
    document.fm1.skInsNm.value = "";
    document.fm1.skInsHoInsType.value = "";
    document.fm1.skInsInsClass.value = "";
  // 勤務先情報 所属部科
  } else if ( name == 'skDept' ) {
    document.fm1.skDeptCd.value = "";
    document.fm1.skDeptNm.value = "";
  }
}

/**
 * <pre>
 *  登録、更新、削除処理
 * DB操作処理時に呼ばれます。
 * </pre>
 */
function nd014Register(buttonFlg){
  // 確認メッセージ表示
	if (buttonFlg == '2' || buttonFlg == '4'){
	  if (confirm(msgContent)){
	  } else {
	    return false;
	  }
  }

  document.fm1.buttonFlg.value = buttonFlg;
  document.fm1.screenId.value = 'ND014';
  document.fm1.functionId.value = 'Register';

  //イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  異動先施設不明チェックによる活性非活性切り替え
 * </pre>
 */
function skCheck(obj){

  if(obj.checked == true){
    //勤務先不明 ON
    document.fm1.skInsNo.value = "959000000";
    document.fm1.skInsNm.value = "異動先施設不明";
    document.fm1.skInsHoInsType.value = "";
    document.fm1.skInsInsClass.value = "";
    document.fm1.skDeptCd.value = "9999";
    document.fm1.skDeptNm.value = "未登録";
    document.fm1.skUnivPosCd.value = "";
    document.fm1.skTitleCd.value = "";
    document.fm1.skJobForm.value = "";
    document.fm1.skDcctype.value = "";
    document.fm1.skUnivPosCd.disabled = true;
    document.fm1.skTitleCd.disabled = true;
    document.fm1.skJobForm.disabled = true;
    document.fm1.skDcctype.disabled = true;
    document.fm1.button2.disabled = true;
    document.fm1.button3.disabled = true;
  }else{
    //勤務先不明 OFF
    document.fm1.skInsNo.value = "";
    document.fm1.skInsNm.value = "";
    document.fm1.skInsHoInsType.value = "";
    document.fm1.skInsInsClass.value = "";
    document.fm1.skDeptCd.value = "";
    document.fm1.skDeptNm.value = "";
    document.fm1.skUnivPosCd.disabled = false;
    document.fm1.skTitleCd.disabled = false;
    document.fm1.skJobForm.disabled = false;
    document.fm1.skDcctype.disabled = false;
    document.fm1.button2.disabled = false;
    document.fm1.button3.disabled = false;
  }

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
function tmpCdcView(){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 全てのポップアップを閉じる
  hcpClosePopUp(gCdcViewWin, "gCdcViewWin");

 // パラメータの設定
  document.fm1.cdcCheckedCodes.value = "";
  document.fm1.paramInsNo.value = document.fm1.skInsNo.value;

  document.fm1.backScreenId.value = "ND014";
  gCdcViewWin = cdcView(gCdcViewWin,"tmpCallBackShozokuViewRDM","gCdcViewWin");
  return(true);
}

/**
 * <pre>
 * 出身所属部科POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShozokuViewRDM(deptCode,DeptKj,DeptKn){
	document.fm1.skDeptCd.value = deptCode;
	document.fm1.skDeptNm.value = DeptKj;
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
  document.fm1.backScreenId.value = "ND014";
  gCseViewWin = cseView(gCseViewWin,"tmpCallBackShisetsuView","gCseViewWin");
  return(true);
}

/**
 * <pre>
 * 施設検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackShisetsuView(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType,insClass){
    document.fm1.skInsNo.value = insNo;
    document.fm1.skInsNm.value = insAbbrName;
    document.fm1.skInsHoInsType.value = hoInsType;
    document.fm1.skInsInsClass.value = insClass;

}