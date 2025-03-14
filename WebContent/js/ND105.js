/**
 * <pre>
 *  医師削除画面のJavaScript
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
var ND105_APPLICATION_ID = "ND105";
var msgContent = ""; //確認メッセージ

var gCdrViewWin = null;        // 医師検索POPUP用

///**
// * <pre>
// *  詳細 => 一覧
// * 一覧へ戻る(リンク)押下時に呼ばれます。
// * </pre>
// */
//function nd105View(screenId){
//  document.fm0.screenId.value=screenId;
//  document.fm0.functionId.value="View";
//  comSubmit(fm0);
//}

/**
 * <pre>
 * 削除理由変更時に呼ばれます。
 *@param
 * </pre>
 */
function changeBox(){
	const delReason = document.fm1.delReason.value;
	if(delReason == "02"){//重複医師
		document.getElementById("dupHr").style.visibility = "visible";
		document.getElementById("formTable08").style.visibility = "visible";
	} else {
		document.getElementById("dupHr").style.visibility = "hidden";
		document.getElementById("formTable08").style.visibility = "hidden";
	    document.fm1.dupDocNo.value = "";
	    document.fm1.dupDocNm.value = "";
	}
}

/**
 * <pre>
 * clear(リンク)押下時に呼ばれます。
 *@param name クリア項目名
 * </pre>
 */
function nd105Clear( name ) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 出身所属部科
  if ( name == 'dupDoc' ) {
    document.fm1.dupDocNo.value = "";
    document.fm1.dupDocNm.value = "";
  }
}

/**
 * <pre>
 *  登録、更新、削除処理
 * DB操作処理時に呼ばれます。
 * </pre>
 */
function nd105Register(buttonFlg){
  // 確認メッセージ表示
  if (confirm(msgContent)){
  } else {
    return false;
  }

  document.fm1.buttonFlg.value = buttonFlg;
  document.fm1.screenId.value = 'ND105';
  document.fm1.functionId.value = 'Register';

  //イベント呼び出し
  comSubmitForAnyWarp(fm1);
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

	  // 医師検索ポップアップ
	  if(gCdrViewWin != null && targetWinName != "gCdrViewWin"){
		  gCdrViewWin.close();
		  gCdrViewWin = null;
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
  if(typeof(gCdrViewWin) == 'string') return false;     // 医師検索ポップアップ

  // 全ウィンドウが正常ならばtrue
  return true;
}


/**
 * 施設検索POPUP画面を呼び出します。
 *
 */
function tmpCdrView(){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 全てのポップアップを閉じる
  hcpClosePopUp(gCdrViewWin, "gCdrViewWin");

 // パラメータの設定
  //document.fm1.backScreenId.value = "ND105";
  gCdrViewWin = cdrView(gCdrViewWin,"tmpCallBackDoctorView","gCdrViewWin");
  return(true);
}

/**
 * <pre>
 * 施設検索POPUP　コールバック関数。
 * </pre>
 */
function tmpCallBackDoctorView(docNo,docKanj){
    document.fm1.dupDocNo.value = docNo;
    document.fm1.dupDocNm.value = docKanj;

}