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
var ND011_APPLICATION_ID = "ND011";
var msgContent = ""; //確認メッセージ
var gChsViewWin = null;        // 所属学会POPUP用
var gChpViewWin = null;        // 公的機関POPUP用
var gCdcViewWin = null;        // 出身所属部科/勤務先情報 所属部科POPUP用
var gCseViewWin = null;        // 勤務先情報 施設POPUP用
//var gCsdViewWin = null;        // 勤務先情報 所属部科POPUP用

/**
 * ポップアップ選択行ID
 */
var gChsViewSelId		= null;
var gChpViewSelId		= null;
var gCdcViewSelId		= null; // 出身所属部科/勤務先情報 所属部科判定用
///**
// * <pre>
// *  詳細 => 一覧
// * 一覧へ戻る(リンク)押下時に呼ばれます。
// * </pre>
// */
//function nd011View(screenId){
//  document.fm0.screenId.value=screenId;
//  document.fm0.functionId.value="View";
//  comSubmit(fm0);
//}

/**
 * <pre>
 * clear(リンク)押下時に呼ばれます。
 *@param name クリア項目名
 * </pre>
 */
function nd011Clear( name ) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 出身所属部科
  if ( name == 'homeDept' ) {
    document.fm1.homeDeptCd.value = "";
    document.fm1.homeDeptNm.value = "";
    // 勤務先情報 施設
  } else if ( name == 'skIns' ) {
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
function nd011Register(buttonFlg){
	// 確認メッセージ表示
	if (buttonFlg == '2' || buttonFlg == '4'){
		if (confirm(msgContent)){
		} else {
			mstContent = "";
			return false;
		}
	}

  document.fm1.buttonFlg.value = buttonFlg;
  document.fm1.screenId.value = 'ND011';
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

/**
 * 所属学会編集画面を呼び出します。
 *@param newupdFlg	呼び出し元オブジェクト
 *@param indexNo	選択行番号
 */
function tmpChsView(newupdFlg,indexNo){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 全てのポップアップを閉じる
  hcpClosePopUp(gChsViewWin, "gChsViewWin");
  gChsViewSelId = indexNo;
  // パラメータの設定
  if (newupdFlg == "0") {//新規
    document.fm1.hcpSocietyDataChgFlg.value = "0";

    document.fm1.positionCodePop.value = "";
    document.fm1.advisingDoctorCdPop.value = "";
    document.fm1.certifyingPhysicianCdPop.value = "";
    document.fm1.medicalSocietyNmPop.value = "";
    document.fm1.admissionYYYYPop.value = "";
    document.fm1.admissionMMPop.value = "";
    document.fm1.admissionDDPop.value = "";
    document.fm1.quitYYYYPop.value = "";
    document.fm1.quitMMPop.value = "";
    document.fm1.quitDDPop.value = "";
    document.fm1.societyPosiStYYYYPop.value = "";
    document.fm1.societyPosiStMMPop.value = "";
    document.fm1.societyPosiStDDPop.value = "";
    document.fm1.societyPosiEdYYYYPop.value = "";
    document.fm1.societyPosiEdMMPop.value = "";
    document.fm1.societyPosiEdDDPop.value = "";
    document.fm1.coachingAcquisiYYYYPop.value = "";
    document.fm1.coachingAcquisiMMPop.value = "";
    document.fm1.coachingAcquisiDDPop.value = "";
    document.fm1.coachingStYYYYPop.value = "";
    document.fm1.coachingStMMPop.value = "";
    document.fm1.coachingStDDPop.value = "";
    document.fm1.coachingEdYYYYPop.value = "";
    document.fm1.coachingEdMMPop.value = "";
    document.fm1.coachingEdDDPop.value = "";
    document.fm1.certifyStYYYYPop.value = "";
    document.fm1.certifyStMMPop.value = "";
    document.fm1.certifyStDDPop.value = "";
    document.fm1.certifyEdYYYYPop.value = "";
    document.fm1.certifyEdMMPop.value = "";
    document.fm1.certifyEdDDPop.value = "";

  } else {//更新
    document.fm1.hcpSocietyDataChgFlg.value = "1";
    var positionCode = "hcpSocietyDataList[" + indexNo + "].positionCode";
    var positionCodeValue = document.getElementsByName(positionCode)[0].value;
    document.fm1.positionCodePop.value = positionCodeValue;

    var advisingDoctorCd = "hcpSocietyDataList[" + indexNo + "].advisingDoctorCd";
    var advisingDoctorCdValue = document.getElementsByName(advisingDoctorCd)[0].value;
    document.fm1.advisingDoctorCdPop.value = advisingDoctorCdValue;

    var certifyingPhysicianCd = "hcpSocietyDataList[" + indexNo + "].certifyingPhysicianCd";
    var certifyingPhysicianCdValue = document.getElementsByName(certifyingPhysicianCd)[0].value;
    document.fm1.certifyingPhysicianCdPop.value = certifyingPhysicianCdValue;

    var medicalSocietyNm = "hcpSocietyDataList[" + indexNo + "].medicalSocietyNm";
    var medicalSocietyNmValue = document.getElementsByName(medicalSocietyNm)[0].value;
    document.fm1.medicalSocietyNmPop.value = medicalSocietyNmValue;

    var admissionYYYY = "hcpSocietyDataList[" + indexNo + "].admissionYYYY";
    var admissionYYYYValue = document.getElementsByName(admissionYYYY)[0].value;
    document.fm1.admissionYYYYPop.value = admissionYYYYValue;
    var admissionMM = "hcpSocietyDataList[" + indexNo + "].admissionMM";
    var admissionMMValue = document.getElementsByName(admissionMM)[0].value;
    document.fm1.admissionMMPop.value = admissionMMValue;
    var admissionDD = "hcpSocietyDataList[" + indexNo + "].admissionDD";
    var admissionDDValue = document.getElementsByName(admissionDD)[0].value;
    document.fm1.admissionDDPop.value = admissionDDValue;

    var quitYYYY = "hcpSocietyDataList[" + indexNo + "].quitYYYY";
    var quitYYYYValue = document.getElementsByName(quitYYYY)[0].value;
    document.fm1.quitYYYYPop.value = quitYYYYValue;
    var quitMM = "hcpSocietyDataList[" + indexNo + "].quitMM";
    var quitMMValue = document.getElementsByName(quitMM)[0].value;
    document.fm1.quitMMPop.value = quitMMValue;
    var quitDD = "hcpSocietyDataList[" + indexNo + "].quitDD";
    var quitDDValue = document.getElementsByName(quitDD)[0].value;
    document.fm1.quitDDPop.value = quitDDValue;

    var societyPosiStYYYY = "hcpSocietyDataList[" + indexNo + "].societyPosiStYYYY";
    var societyPosiStYYYYValue = document.getElementsByName(societyPosiStYYYY)[0].value;
    document.fm1.societyPosiStYYYYPop.value = societyPosiStYYYYValue;
    var societyPosiStMM = "hcpSocietyDataList[" + indexNo + "].societyPosiStMM";
    var societyPosiStMMValue = document.getElementsByName(societyPosiStMM)[0].value;
    document.fm1.societyPosiStMMPop.value = societyPosiStMMValue;
    var societyPosiStDD = "hcpSocietyDataList[" + indexNo + "].societyPosiStDD";
    var societyPosiStDDValue = document.getElementsByName(societyPosiStDD)[0].value;
    document.fm1.societyPosiStDDPop.value = societyPosiStDDValue;
    var societyPosiEdYYYY = "hcpSocietyDataList[" + indexNo + "].societyPosiEdYYYY";
    var societyPosiEdYYYYValue = document.getElementsByName(societyPosiEdYYYY)[0].value;
    document.fm1.societyPosiEdYYYYPop.value = societyPosiEdYYYYValue;
    var societyPosiEdMM = "hcpSocietyDataList[" + indexNo + "].societyPosiEdMM";
    var societyPosiEdMMValue = document.getElementsByName(societyPosiEdMM)[0].value;
    document.fm1.societyPosiEdMMPop.value = societyPosiEdMMValue;
    var societyPosiEdDD = "hcpSocietyDataList[" + indexNo + "].societyPosiEdDD";
    var societyPosiEdDDValue = document.getElementsByName(societyPosiEdDD)[0].value;
    document.fm1.societyPosiEdDDPop.value = societyPosiEdDDValue;

    var coachingAcquisiYYYY = "hcpSocietyDataList[" + indexNo + "].coachingAcquisiYYYY";
    var coachingAcquisiYYYYValue = document.getElementsByName(coachingAcquisiYYYY)[0].value;
    document.fm1.coachingAcquisiYYYYPop.value = coachingAcquisiYYYYValue;
    var coachingAcquisiMM = "hcpSocietyDataList[" + indexNo + "].coachingAcquisiMM";
    var coachingAcquisiMMValue = document.getElementsByName(coachingAcquisiMM)[0].value;
    document.fm1.coachingAcquisiMMPop.value = coachingAcquisiMMValue;
    var coachingAcquisiDD = "hcpSocietyDataList[" + indexNo + "].coachingAcquisiDD";
    var coachingAcquisiDDValue = document.getElementsByName(coachingAcquisiDD)[0].value;
    document.fm1.coachingAcquisiDDPop.value = coachingAcquisiDDValue;

    var coachingStYYYY = "hcpSocietyDataList[" + indexNo + "].coachingStYYYY";
    var coachingStYYYYValue = document.getElementsByName(coachingStYYYY)[0].value;
    document.fm1.coachingStYYYYPop.value = coachingStYYYYValue;
    var coachingStMM = "hcpSocietyDataList[" + indexNo + "].coachingStMM";
    var coachingStMMValue = document.getElementsByName(coachingStMM)[0].value;
    document.fm1.coachingStMMPop.value = coachingStMMValue;
    var coachingStDD = "hcpSocietyDataList[" + indexNo + "].coachingStDD";
    var coachingStDDValue = document.getElementsByName(coachingStDD)[0].value;
    document.fm1.coachingStDDPop.value = coachingStDDValue;
    var coachingEdYYYY = "hcpSocietyDataList[" + indexNo + "].coachingEdYYYY";
    var coachingEdYYYYValue = document.getElementsByName(coachingEdYYYY)[0].value;
    document.fm1.coachingEdYYYYPop.value = coachingEdYYYYValue;
    var coachingEdMM = "hcpSocietyDataList[" + indexNo + "].coachingEdMM";
    var coachingEdMMValue = document.getElementsByName(coachingEdMM)[0].value;
    document.fm1.coachingEdMMPop.value = coachingEdMMValue;
    var coachingEdDD = "hcpSocietyDataList[" + indexNo + "].coachingEdDD";
    var coachingEdDDValue = document.getElementsByName(coachingEdDD)[0].value;
    document.fm1.coachingEdDDPop.value = coachingEdDDValue;

    var certifyStYYYY = "hcpSocietyDataList[" + indexNo + "].certifyStYYYY";
    var certifyStYYYYValue = document.getElementsByName(certifyStYYYY)[0].value;
    document.fm1.certifyStYYYYPop.value = certifyStYYYYValue;
    var certifyStMM = "hcpSocietyDataList[" + indexNo + "].certifyStMM";
    var certifyStMMValue = document.getElementsByName(certifyStMM)[0].value;
    document.fm1.certifyStMMPop.value = certifyStMMValue;
    var certifyStDD = "hcpSocietyDataList[" + indexNo + "].certifyStDD";
    var certifyStDDValue = document.getElementsByName(certifyStDD)[0].value;
    document.fm1.certifyStDDPop.value = certifyStDDValue;
    var certifyEdYYYY = "hcpSocietyDataList[" + indexNo + "].certifyEdYYYY";
    var certifyEdYYYYValue = document.getElementsByName(certifyEdYYYY)[0].value;
    document.fm1.certifyEdYYYYPop.value = certifyEdYYYYValue;
    var certifyEdMM = "hcpSocietyDataList[" + indexNo + "].certifyEdMM";
    var certifyEdMMValue = document.getElementsByName(certifyEdMM)[0].value;
    document.fm1.certifyEdMMPop.value = certifyEdMMValue;
    var certifyEdDD = "hcpSocietyDataList[" + indexNo + "].certifyEdDD";
    var certifyEdDDValue = document.getElementsByName(certifyEdDD)[0].value;
    document.fm1.certifyEdDDPop.value = certifyEdDDValue;

  }

  gChsViewWin = chsView(gChsViewWin,"tmpCallBackChsView","gChsViewWin");
  return(true);
}

/**
 * <pre>
 * 所属学会　コールバック関数。
 * </pre>
 */
function tmpCallBackChsView(hcpSocietyDataChgFlg,medicalSocietyNm
		,positionCodePop,positionNamePop,advisingDoctorCdPop,advisingDoctorNmPop,certifyingPhysicianCdPop,certifyingPhysicianNmPop
		,admissionYYYYPop,admissionMMPop,admissionDDPop,quitYYYYPop,quitMMPop,quitDDPop
		,societyPosiStYYYYPop,societyPosiStMMPop,societyPosiStDDPop,societyPosiEdYYYYPop,societyPosiEdMMPop,societyPosiEdDDPop
		,coachingAcquisiYYYYPop,coachingAcquisiMMPop,coachingAcquisiDDPop
		,coachingStYYYYPop,coachingStMMPop,coachingStDDPop,coachingEdYYYYPop,coachingEdMMPop,coachingEdDDPop
		,certifyStYYYYPop,certifyStMMPop,certifyStDDPop,certifyEdYYYYPop,certifyEdMMPop,certifyEdDDPop
){
	if(hcpSocietyDataChgFlg == "0"){
		CallBackToNewHcpSocRow(medicalSocietyNm
				,positionCodePop,positionNamePop,advisingDoctorCdPop,advisingDoctorNmPop,certifyingPhysicianCdPop,certifyingPhysicianNmPop
				,admissionYYYYPop,admissionMMPop,admissionDDPop,quitYYYYPop,quitMMPop,quitDDPop
				,societyPosiStYYYYPop,societyPosiStMMPop,societyPosiStDDPop,societyPosiEdYYYYPop,societyPosiEdMMPop,societyPosiEdDDPop
				,coachingAcquisiYYYYPop,coachingAcquisiMMPop,coachingAcquisiDDPop
				,coachingStYYYYPop,coachingStMMPop,coachingStDDPop,coachingEdYYYYPop,coachingEdMMPop,coachingEdDDPop
				,certifyStYYYYPop,certifyStMMPop,certifyStDDPop,certifyEdYYYYPop,certifyEdMMPop,certifyEdDDPop
		);
	}else{
		CallBackToUpdHcpSocRow(gChsViewSelId,medicalSocietyNm
				,positionCodePop,positionNamePop,advisingDoctorCdPop,advisingDoctorNmPop,certifyingPhysicianCdPop,certifyingPhysicianNmPop
				,admissionYYYYPop,admissionMMPop,admissionDDPop,quitYYYYPop,quitMMPop,quitDDPop
				,societyPosiStYYYYPop,societyPosiStMMPop,societyPosiStDDPop,societyPosiEdYYYYPop,societyPosiEdMMPop,societyPosiEdDDPop
				,coachingAcquisiYYYYPop,coachingAcquisiMMPop,coachingAcquisiDDPop
				,coachingStYYYYPop,coachingStMMPop,coachingStDDPop,coachingEdYYYYPop,coachingEdMMPop,coachingEdDDPop
				,certifyStYYYYPop,certifyStMMPop,certifyStDDPop,certifyEdYYYYPop,certifyEdMMPop,certifyEdDDPop
		);
	}
}

/**
 * 所属学会編集画面(編集)からの戻り。
 *@param POPUPで設定された値
 *@param indexNo	選択行番号
 */
function CallBackToUpdHcpSocRow(indexNo,medicalSocietyNmPop
		,positionCodePop,positionNamePop,advisingDoctorCdPop,advisingDoctorNmPop,certifyingPhysicianCdPop,certifyingPhysicianNmPop
		,admissionYYYYPop,admissionMMPop,admissionDDPop,quitYYYYPop,quitMMPop,quitDDPop
		,societyPosiStYYYYPop,societyPosiStMMPop,societyPosiStDDPop,societyPosiEdYYYYPop,societyPosiEdMMPop,societyPosiEdDDPop
		,coachingAcquisiYYYYPop,coachingAcquisiMMPop,coachingAcquisiDDPop
		,coachingStYYYYPop,coachingStMMPop,coachingStDDPop,coachingEdYYYYPop,coachingEdMMPop,coachingEdDDPop
		,certifyStYYYYPop,certifyStMMPop,certifyStDDPop,certifyEdYYYYPop,certifyEdMMPop,certifyEdDDPop
){
//	var medicalSocietyNm = "hcpSocietyDataList[" + indexNo + "].medicalSocietyNm";
//	document.getElementsByName(medicalSocietyNm)[0].value = medicalSocietyNmPop;
	var positionCode = "hcpSocietyDataList[" + indexNo + "].positionCode";
	document.getElementsByName(positionCode)[0].value = positionCodePop;
	var positionName = "hcpSocietyDataList[" + indexNo + "].positionName";
	document.getElementsByName(positionName)[0].value = positionNamePop;
    var advisingDoctorCd = "hcpSocietyDataList[" + indexNo + "].advisingDoctorCd";
    document.getElementsByName(advisingDoctorCd)[0].value = advisingDoctorCdPop;
    var advisingDoctorNm = "hcpSocietyDataList[" + indexNo + "].advisingDoctorNm";
    document.getElementsByName(advisingDoctorNm)[0].value = advisingDoctorNmPop;
    var certifyingPhysicianCd = "hcpSocietyDataList[" + indexNo + "].certifyingPhysicianCd";
    document.getElementsByName(certifyingPhysicianCd)[0].value = certifyingPhysicianCdPop;
    var certifyingPhysicianNm = "hcpSocietyDataList[" + indexNo + "].certifyingPhysicianNm";
    document.getElementsByName(certifyingPhysicianNm)[0].value = certifyingPhysicianNmPop;

    var admissionYYYY = "hcpSocietyDataList[" + indexNo + "].admissionYYYY";
    document.getElementsByName(admissionYYYY)[0].value = admissionYYYYPop;
    var admissionMM = "hcpSocietyDataList[" + indexNo + "].admissionMM";
    document.getElementsByName(admissionMM)[0].value = admissionMMPop;
    var admissionDD = "hcpSocietyDataList[" + indexNo + "].admissionDD";
    document.getElementsByName(admissionDD)[0].value = admissionDDPop;
    var admissionYMD = "hcpSocietyDataList[" + indexNo + "].admissionYMD";
    var admissionYMDPop = "";
    if(admissionYYYYPop != null && admissionYYYYPop != ""){admissionYMDPop += admissionYYYYPop;}
    if(admissionMMPop != null && admissionMMPop != ""){admissionYMDPop += ("/" + admissionMMPop);}
    if(admissionDDPop != null && admissionDDPop != ""){admissionYMDPop += ("/" + admissionDDPop);}
    document.getElementsByName(admissionYMD)[0].value = admissionYMDPop;

    var quitYYYY = "hcpSocietyDataList[" + indexNo + "].quitYYYY";
    document.getElementsByName(quitYYYY)[0].value = quitYYYYPop;
    var quitMM = "hcpSocietyDataList[" + indexNo + "].quitMM";
    document.getElementsByName(quitMM)[0].value = quitMMPop;
    var quitDD = "hcpSocietyDataList[" + indexNo + "].quitDD";
    document.getElementsByName(quitDD)[0].value = quitDDPop;
    var quitYMD = "hcpSocietyDataList[" + indexNo + "].quitYMD";
    var quitYMDPop = "";
    if(quitYYYYPop != null && quitYYYYPop != ""){quitYMDPop += quitYYYYPop;}
    if(quitMMPop != null && quitMMPop != ""){quitYMDPop += ("/" + quitMMPop);}
    if(quitDDPop != null && quitDDPop != ""){quitYMDPop += ("/" + quitDDPop);}
    document.getElementsByName(quitYMD)[0].value = quitYMDPop;

    var societyPosiStYYYY = "hcpSocietyDataList[" + indexNo + "].societyPosiStYYYY";
    document.getElementsByName(societyPosiStYYYY)[0].value = societyPosiStYYYYPop;
    var societyPosiStMM = "hcpSocietyDataList[" + indexNo + "].societyPosiStMM";
    document.getElementsByName(societyPosiStMM)[0].value = societyPosiStMMPop;
    var societyPosiStDD = "hcpSocietyDataList[" + indexNo + "].societyPosiStDD";
    document.getElementsByName(societyPosiStDD)[0].value = societyPosiStDDPop;
    var societyPosiStYMD = "hcpSocietyDataList[" + indexNo + "].societyPosiStYMD";
    var societyPosiStYMDPop = "";
    if(societyPosiStYYYYPop != null && societyPosiStYYYYPop != ""){societyPosiStYMDPop += societyPosiStYYYYPop;}
    if(societyPosiStMMPop != null && societyPosiStMMPop != ""){societyPosiStYMDPop += ("/" + societyPosiStMMPop);}
    if(societyPosiStDDPop != null && societyPosiStDDPop != ""){societyPosiStYMDPop += ("/" + societyPosiStDDPop);}
    document.getElementsByName(societyPosiStYMD)[0].value = societyPosiStYMDPop;
    var societyPosiEdYYYY = "hcpSocietyDataList[" + indexNo + "].societyPosiEdYYYY";
    document.getElementsByName(societyPosiEdYYYY)[0].value = societyPosiEdYYYYPop;
    var societyPosiEdMM = "hcpSocietyDataList[" + indexNo + "].societyPosiEdMM";
    document.getElementsByName(societyPosiEdMM)[0].value = societyPosiEdMMPop;
    var societyPosiEdDD = "hcpSocietyDataList[" + indexNo + "].societyPosiEdDD";
    document.getElementsByName(societyPosiEdDD)[0].value = societyPosiEdDDPop;
    var societyPosiEdYMD = "hcpSocietyDataList[" + indexNo + "].societyPosiEdYMD";
    var societyPosiEdYMDPop = "";
    if(societyPosiEdYYYYPop != null && societyPosiEdYYYYPop != ""){societyPosiEdYMDPop += societyPosiEdYYYYPop;}
    if(societyPosiEdMMPop != null && societyPosiEdMMPop != ""){societyPosiEdYMDPop += ("/" + societyPosiEdMMPop);}
    if(societyPosiEdDDPop != null && societyPosiEdDDPop != ""){societyPosiEdYMDPop += ("/" + societyPosiEdDDPop);}
    document.getElementsByName(societyPosiEdYMD)[0].value = societyPosiEdYMDPop;

    var coachingAcquisiYYYY = "hcpSocietyDataList[" + indexNo + "].coachingAcquisiYYYY";
    document.getElementsByName(coachingAcquisiYYYY)[0].value = coachingAcquisiYYYYPop;
    var coachingAcquisiMM = "hcpSocietyDataList[" + indexNo + "].coachingAcquisiMM";
    document.getElementsByName(coachingAcquisiMM)[0].value = coachingAcquisiMMPop;
    var coachingAcquisiDD = "hcpSocietyDataList[" + indexNo + "].coachingAcquisiDD";
    document.getElementsByName(coachingAcquisiDD)[0].value = coachingAcquisiDDPop;
    var coachingAcquisiYMD = "hcpSocietyDataList[" + indexNo + "].coachingAcquisiYMD";
    var coachingAcquisiYMDPop = "";
    if(coachingAcquisiYYYYPop != null && coachingAcquisiYYYYPop != ""){coachingAcquisiYMDPop += coachingAcquisiYYYYPop;}
    if(coachingAcquisiMMPop != null && coachingAcquisiMMPop != ""){coachingAcquisiYMDPop += ("/" + coachingAcquisiMMPop);}
    if(coachingAcquisiDDPop != null && coachingAcquisiDDPop != ""){coachingAcquisiYMDPop += ("/" + coachingAcquisiDDPop);}
    document.getElementsByName(coachingAcquisiYMD)[0].value = coachingAcquisiYMDPop;

    var coachingStYYYY = "hcpSocietyDataList[" + indexNo + "].coachingStYYYY";
    document.getElementsByName(coachingStYYYY)[0].value = coachingStYYYYPop;
    var coachingStMM = "hcpSocietyDataList[" + indexNo + "].coachingStMM";
    document.getElementsByName(coachingStMM)[0].value = coachingStMMPop;
    var coachingStDD = "hcpSocietyDataList[" + indexNo + "].coachingStDD";
    document.getElementsByName(coachingStDD)[0].value = coachingStDDPop;
    var coachingStYMD = "hcpSocietyDataList[" + indexNo + "].coachingStYMD";
    var coachingStYMDPop = "";
    if(coachingStYYYYPop != null && coachingStYYYYPop != ""){coachingStYMDPop += coachingStYYYYPop;}
    if(coachingStMMPop != null && coachingStMMPop != ""){coachingStYMDPop += ("/" + coachingStMMPop);}
    if(coachingStDDPop != null && coachingStDDPop != ""){coachingStYMDPop += ("/" + coachingStDDPop);}
    document.getElementsByName(coachingStYMD)[0].value = coachingStYMDPop;

    var coachingEdYYYY = "hcpSocietyDataList[" + indexNo + "].coachingEdYYYY";
    document.getElementsByName(coachingEdYYYY)[0].value = coachingEdYYYYPop;
    var coachingEdMM = "hcpSocietyDataList[" + indexNo + "].coachingEdMM";
    document.getElementsByName(coachingEdMM)[0].value = coachingEdMMPop;
    var coachingEdDD = "hcpSocietyDataList[" + indexNo + "].coachingEdDD";
    document.getElementsByName(coachingEdDD)[0].value = coachingEdDDPop;
    var coachingEdYMD = "hcpSocietyDataList[" + indexNo + "].coachingEdYMD";
    var coachingEdYMDPop = "";
    if(coachingEdYYYYPop != null && coachingEdYYYYPop != ""){coachingEdYMDPop += coachingEdYYYYPop;}
    if(coachingEdMMPop != null && coachingEdMMPop != ""){coachingEdYMDPop += ("/" + coachingEdMMPop);}
    if(coachingEdDDPop != null && coachingEdDDPop != ""){coachingEdYMDPop += ("/" + coachingEdDDPop);}
    document.getElementsByName(coachingEdYMD)[0].value = coachingEdYMDPop;

    var certifyStYYYY = "hcpSocietyDataList[" + indexNo + "].certifyStYYYY";
    document.getElementsByName(certifyStYYYY)[0].value = certifyStYYYYPop;
    var certifyStMM = "hcpSocietyDataList[" + indexNo + "].certifyStMM";
    document.getElementsByName(certifyStMM)[0].value = certifyStMMPop;
    var certifyStDD = "hcpSocietyDataList[" + indexNo + "].certifyStDD";
    document.getElementsByName(certifyStDD)[0].value = certifyStDDPop;
    var certifyStYMD = "hcpSocietyDataList[" + indexNo + "].certifyStYMD";
    var certifyStYMDPop = "";
    if(certifyStYYYYPop != null && certifyStYYYYPop != ""){certifyStYMDPop += certifyStYYYYPop;}
    if(certifyStMMPop != null && certifyStMMPop != ""){certifyStYMDPop += ("/" + certifyStMMPop);}
    if(certifyStDDPop != null && certifyStDDPop != ""){certifyStYMDPop += ("/" + certifyStDDPop);}
    document.getElementsByName(certifyStYMD)[0].value = certifyStYMDPop;
    var certifyEdYYYY = "hcpSocietyDataList[" + indexNo + "].certifyEdYYYY";
    document.getElementsByName(certifyEdYYYY)[0].value = certifyEdYYYYPop;
    var certifyEdMM = "hcpSocietyDataList[" + indexNo + "].certifyEdMM";
    document.getElementsByName(certifyEdMM)[0].value = certifyEdMMPop;
    var certifyEdDD = "hcpSocietyDataList[" + indexNo + "].certifyEdDD";
    document.getElementsByName(certifyEdDD)[0].value = certifyEdDDPop;
    var certifyEdYMD = "hcpSocietyDataList[" + indexNo + "].certifyEdYMD";
    var certifyEdYMDPop = "";
    if(certifyEdYYYYPop != null && certifyEdYYYYPop != ""){certifyEdYMDPop += certifyEdYYYYPop;}
    if(certifyEdMMPop != null && certifyEdMMPop != ""){certifyEdYMDPop += ("/" + certifyEdMMPop);}
    if(certifyEdDDPop != null && certifyEdDDPop != ""){certifyEdYMDPop += ("/" + certifyEdDDPop);}
    document.getElementsByName(certifyEdYMD)[0].value = certifyEdYMDPop;

}

/**
 * 所属学会編集画面(新規)からの戻り。
 *@param POPUPで設定された値
 */
function CallBackToNewHcpSocRow(medicalSocietyNm
		,positionCode,positionName,advisingDoctorCd,advisingDoctorNm,certifyingPhysicianCd,certifyingPhysicianNm
		,admissionYYYY,admissionMM,admissionDD,quitYYYY,quitMM,quitDD
		,societyPosiStYYYY,societyPosiStMM,societyPosiStDD,societyPosiEdYYYY,societyPosiEdMM,societyPosiEdDD
		,coachingAcquisiYYYY,coachingAcquisiMM,coachingAcquisiDD
		,coachingStYYYY,coachingStMM,coachingStDD,coachingEdYYYY,coachingEdMM,coachingEdDD
		,certifyStYYYY,certifyStMM,certifyStDD,certifyEdYYYY,certifyEdMM,certifyEdDD
){
	let hcpSocTable = document.getElementById("formTable05");
	let hcpSocRow = Number(hcpSocTable.rows.length)-1;

    var admissionYMDPop = "";
    if(admissionYYYY != null && admissionYYYY != ""){admissionYMDPop += admissionYYYY;}
    if(admissionMM != null && admissionMM != ""){admissionYMDPop += ("/" + admissionMM);}
    if(admissionDD != null && admissionDD != ""){admissionYMDPop += ("/" + admissionDD);}
    let admissionYMD = admissionYMDPop;
    var quitYMDPop = "";
    if(quitYYYY != null && quitYYYY != ""){quitYMDPop += quitYYYY;}
    if(quitMM != null && quitMM != ""){quitYMDPop += ("/" + quitMM);}
    if(quitDD != null && quitDD != ""){quitYMDPop += ("/" + quitDD);}
    let quitYMD = quitYMDPop;
    var societyPosiStYMDPop = "";
    if(societyPosiStYYYY != null && societyPosiStYYYY != ""){societyPosiStYMDPop += societyPosiStYYYY;}
    if(societyPosiStMM != null && societyPosiStMM != ""){societyPosiStYMDPop += ("/" + societyPosiStMM);}
    if(societyPosiStDD != null && societyPosiStDD != ""){societyPosiStYMDPop += ("/" + societyPosiStDD);}
    let societyPosiStYMD = societyPosiStYMDPop;
    var societyPosiEdYMDPop = "";
    if(societyPosiEdYYYY != null && societyPosiEdYYYY != ""){societyPosiEdYMDPop += societyPosiEdYYYY;}
    if(societyPosiEdMM != null && societyPosiEdMM != ""){societyPosiEdYMDPop += ("/" + societyPosiEdMM);}
    if(societyPosiEdDD != null && societyPosiEdDD != ""){societyPosiEdYMDPop += ("/" + societyPosiEdDD);}
    let societyPosiEdYMD = societyPosiEdYMDPop;
    var coachingAcquisiYMDPop = "";
    if(coachingAcquisiYYYY != null && coachingAcquisiYYYY != ""){coachingAcquisiYMDPop += coachingAcquisiYYYY;}
    if(coachingAcquisiMM != null && coachingAcquisiMM != ""){coachingAcquisiYMDPop += ("/" + coachingAcquisiMM);}
    if(coachingAcquisiDD != null && coachingAcquisiDD != ""){coachingAcquisiYMDPop += ("/" + coachingAcquisiDD);}
    let coachingAcquisiYMD = coachingAcquisiYMDPop;
    var coachingStYMDPop = "";
    if(coachingStYYYY != null && coachingStYYYY != ""){coachingStYMDPop += coachingStYYYY;}
    if(coachingStMM != null && coachingStMM != ""){coachingStYMDPop += ("/" + coachingStMM);}
    if(coachingStDD != null && coachingStDD != ""){coachingStYMDPop += ("/" + coachingStDD);}
    let coachingStYMD = coachingStYMDPop;
    var coachingEdYMDPop = "";
    if(coachingEdYYYY != null && coachingEdYYYY != ""){coachingEdYMDPop += coachingEdYYYY;}
    if(coachingEdMM != null && coachingEdMM != ""){coachingEdYMDPop += ("/" + coachingEdMM);}
    if(coachingEdDD != null && coachingEdDD != ""){coachingEdYMDPop += ("/" + coachingEdDD);}
    let coachingEdYMD = coachingEdYMDPop;
    var certifyStYMDPop = "";
    if(certifyStYYYY != null && certifyStYYYY != ""){certifyStYMDPop += certifyStYYYY;}
    if(certifyStMM != null && certifyStMM != ""){certifyStYMDPop += ("/" + certifyStMM);}
    if(certifyStDD != null && certifyStDD != ""){certifyStYMDPop += ("/" + certifyStDD);}
    let certifyStYMD = certifyStYMDPop;
    var certifyEdYMDPop = "";
    if(certifyEdYYYY != null && certifyEdYYYY != ""){certifyEdYMDPop += certifyEdYYYY;}
    if(certifyEdMM != null && certifyEdMM != ""){certifyEdYMDPop += ("/" + certifyEdMM);}
    if(certifyEdDD != null && certifyEdDD != ""){certifyEdYMDPop += ("/" + certifyEdDD);}
    let certifyEdYMD = certifyEdYMDPop;

	let positionCodeInp = document.createElement("input");
	let advisingDoctorCdInp = document.createElement("input");
	let certifyingPhysicianCdInp = document.createElement("input");
	let medicalSocietyNmInp = document.createElement("input");
	let admissionYYYYInp = document.createElement("input");
	let admissionMMInp = document.createElement("input");
	let admissionDDInp = document.createElement("input");
	let admissionYMDInp = document.createElement("input");
	let quitYYYYInp = document.createElement("input");
	let quitMMInp = document.createElement("input");
	let quitDDInp = document.createElement("input");
	let quitYMDInp = document.createElement("input");
	let positionNameInp = document.createElement("input");
	let societyPosiStYYYYInp = document.createElement("input");
	let societyPosiStMMInp = document.createElement("input");
	let societyPosiStDDInp = document.createElement("input");
	let societyPosiStYMDInp = document.createElement("input");
	let societyPosiEdYYYYInp = document.createElement("input");
	let societyPosiEdMMInp = document.createElement("input");
	let societyPosiEdDDInp = document.createElement("input");
	let societyPosiEdYMDInp = document.createElement("input");
	let coachingAcquisiYYYYInp = document.createElement("input");
	let coachingAcquisiMMInp = document.createElement("input");
	let coachingAcquisiDDInp = document.createElement("input");
	let coachingAcquisiYMDInp = document.createElement("input");
	let advisingDoctorNmInp = document.createElement("input");
	let certifyingPhysicianNmInp = document.createElement("input");
	let coachingStYYYYInp = document.createElement("input");
	let coachingStMMInp = document.createElement("input");
	let coachingStDDInp = document.createElement("input");
	let coachingStYMDInp = document.createElement("input");
	let coachingEdYYYYInp = document.createElement("input");
	let coachingEdMMInp = document.createElement("input");
	let coachingEdDDInp = document.createElement("input");
	let coachingEdYMDInp = document.createElement("input");
	let certifyStYYYYInp = document.createElement("input");
	let certifyStMMInp = document.createElement("input");
	let certifyStDDInp = document.createElement("input");
	let certifyStYMDInp = document.createElement("input");
	let certifyEdYYYYInp = document.createElement("input");
	let certifyEdMMInp = document.createElement("input");
	let certifyEdDDInp = document.createElement("input");
	let certifyEdYMDInp = document.createElement("input");

	positionCodeInp.setAttribute("type", "hidden");
	advisingDoctorCdInp.setAttribute("type", "hidden");
	certifyingPhysicianCdInp.setAttribute("type", "hidden");
	medicalSocietyNmInp.setAttribute("type", "hidden");
	admissionYYYYInp.setAttribute("type", "hidden");
	admissionMMInp.setAttribute("type", "hidden");
	admissionDDInp.setAttribute("type", "hidden");
	admissionYMDInp.setAttribute("type", "text");
	quitYYYYInp.setAttribute("type", "hidden");
	quitMMInp.setAttribute("type", "hidden");
	quitDDInp.setAttribute("type", "hidden");
	quitYMDInp.setAttribute("type", "text");
	positionNameInp.setAttribute("type", "text");
	societyPosiStYYYYInp.setAttribute("type", "hidden");
	societyPosiStMMInp.setAttribute("type", "hidden");
	societyPosiStDDInp.setAttribute("type", "hidden");
	societyPosiStYMDInp.setAttribute("type", "text");
	societyPosiEdYYYYInp.setAttribute("type", "hidden");
	societyPosiEdMMInp.setAttribute("type", "hidden");
	societyPosiEdDDInp.setAttribute("type", "hidden");
	societyPosiEdYMDInp.setAttribute("type", "text");
	coachingAcquisiYYYYInp.setAttribute("type", "hidden");
	coachingAcquisiMMInp.setAttribute("type", "hidden");
	coachingAcquisiDDInp.setAttribute("type", "hidden");
	coachingAcquisiYMDInp.setAttribute("type", "text");
	advisingDoctorNmInp.setAttribute("type", "text");
	certifyingPhysicianNmInp.setAttribute("type", "text");
	coachingStYYYYInp.setAttribute("type", "hidden");
	coachingStMMInp.setAttribute("type", "hidden");
	coachingStDDInp.setAttribute("type", "hidden");
	coachingStYMDInp.setAttribute("type", "text");
	coachingEdYYYYInp.setAttribute("type", "hidden");
	coachingEdMMInp.setAttribute("type", "hidden");
	coachingEdDDInp.setAttribute("type", "hidden");
	coachingEdYMDInp.setAttribute("type", "text");
	certifyStYYYYInp.setAttribute("type", "hidden");
	certifyStMMInp.setAttribute("type", "hidden");
	certifyStDDInp.setAttribute("type", "hidden");
	certifyStYMDInp.setAttribute("type", "text");
	certifyEdYYYYInp.setAttribute("type", "hidden");
	certifyEdMMInp.setAttribute("type", "hidden");
	certifyEdDDInp.setAttribute("type", "hidden");
	certifyEdYMDInp.setAttribute("type", "text");

	positionCodeInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].positionCode");
	advisingDoctorCdInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].advisingDoctorCd");
	certifyingPhysicianCdInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyingPhysicianCd");
	medicalSocietyNmInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].medicalSocietyNm");
	admissionYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].admissionYYYY");
	admissionMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].admissionMM");
	admissionDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].admissionDD");
	admissionYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].admissionYMD");
	quitYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].quitYYYY");
	quitMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].quitMM");
	quitDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].quitDD");
	quitYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].quitYMD");
	positionNameInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].positionName");
	societyPosiStYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].societyPosiStYYYY");
	societyPosiStMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].societyPosiStMM");
	societyPosiStDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].societyPosiStDD");
	societyPosiStYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].societyPosiStYMD");
	societyPosiEdYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].societyPosiEdYYYY");
	societyPosiEdMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].societyPosiEdMM");
	societyPosiEdDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].societyPosiEdDD");
	societyPosiEdYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].societyPosiEdYMD");
	coachingAcquisiYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingAcquisiYYYY");
	coachingAcquisiMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingAcquisiMM");
	coachingAcquisiDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingAcquisiDD");
	coachingAcquisiYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingAcquisiYMD");
	advisingDoctorNmInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].advisingDoctorNm");
	certifyingPhysicianNmInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyingPhysicianNm");
	coachingStYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingStYYYY");
	coachingStMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingStMM");
	coachingStDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingStDD");
	coachingStYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingStYMD");
	coachingEdYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingEdYYYY");
	coachingEdMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingEdMM");
	coachingEdDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingEdDD");
	coachingEdYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].coachingEdYMD");
	certifyStYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyStYYYY");
	certifyStMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyStMM");
	certifyStDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyStDD");
	certifyStYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyStYMD");
	certifyEdYYYYInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyEdYYYY");
	certifyEdMMInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyEdMM");
	certifyEdDDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyEdDD");
	certifyEdYMDInp.setAttribute("name", "hcpSocietyDataList["+hcpSocRow+"].certifyEdYMD");

	positionCodeInp.setAttribute("value", positionCode);
	advisingDoctorCdInp.setAttribute("value", advisingDoctorCd);
	certifyingPhysicianCdInp.setAttribute("value", certifyingPhysicianCd);
	medicalSocietyNmInp.setAttribute("value", medicalSocietyNm);
	admissionYYYYInp.setAttribute("value", admissionYYYY);
	admissionMMInp.setAttribute("value", admissionMM);
	admissionDDInp.setAttribute("value", admissionDD);
	admissionYMDInp.setAttribute("value", admissionYMD);
	quitYYYYInp.setAttribute("value", quitYYYY);
	quitMMInp.setAttribute("value", quitMM);
	quitDDInp.setAttribute("value", quitDD);
	quitYMDInp.setAttribute("value", quitYMD);
	positionNameInp.setAttribute("value", positionName);
	societyPosiStYYYYInp.setAttribute("value", societyPosiStYYYY);
	societyPosiStMMInp.setAttribute("value", societyPosiStMM);
	societyPosiStDDInp.setAttribute("value", societyPosiStDD);
	societyPosiStYMDInp.setAttribute("value", societyPosiStYMD);
	societyPosiEdYYYYInp.setAttribute("value", societyPosiEdYYYY);
	societyPosiEdMMInp.setAttribute("value", societyPosiEdMM);
	societyPosiEdDDInp.setAttribute("value", societyPosiEdDD);
	societyPosiEdYMDInp.setAttribute("value", societyPosiEdYMD);
	coachingAcquisiYYYYInp.setAttribute("value", coachingAcquisiYYYY);
	coachingAcquisiMMInp.setAttribute("value", coachingAcquisiMM);
	coachingAcquisiDDInp.setAttribute("value", coachingAcquisiDD);
	coachingAcquisiYMDInp.setAttribute("value", coachingAcquisiYMD);
	advisingDoctorNmInp.setAttribute("value", advisingDoctorNm);
	certifyingPhysicianNmInp.setAttribute("value", certifyingPhysicianNm);
	coachingStYYYYInp.setAttribute("value", coachingStYYYY);
	coachingStMMInp.setAttribute("value", coachingStMM);
	coachingStDDInp.setAttribute("value", coachingStDD);
	coachingStYMDInp.setAttribute("value", coachingStYMD);
	coachingEdYYYYInp.setAttribute("value", coachingEdYYYY);
	coachingEdMMInp.setAttribute("value", coachingEdMM);
	coachingEdDDInp.setAttribute("value", coachingEdDD);
	coachingEdYMDInp.setAttribute("value", coachingEdYMD);
	certifyStYYYYInp.setAttribute("value", certifyStYYYY);
	certifyStMMInp.setAttribute("value", certifyStMM);
	certifyStDDInp.setAttribute("value", certifyStDD);
	certifyStYMDInp.setAttribute("value", certifyStYMD);
	certifyEdYYYYInp.setAttribute("value", certifyEdYYYY);
	certifyEdMMInp.setAttribute("value", certifyEdMM);
	certifyEdDDInp.setAttribute("value", certifyEdDD);
	certifyEdYMDInp.setAttribute("value", certifyEdYMD);

	admissionYMDInp.setAttribute("readonly", "readonly");
	quitYMDInp.setAttribute("readonly", "readonly");
	positionNameInp.setAttribute("readonly", "readonly");
	societyPosiStYMDInp.setAttribute("readonly", "readonly");
	societyPosiEdYMDInp.setAttribute("readonly", "readonly");
	coachingAcquisiYMDInp.setAttribute("readonly", "readonly");
	advisingDoctorNmInp.setAttribute("readonly", "readonly");
	certifyingPhysicianNmInp.setAttribute("readonly", "readonly");
	coachingStYMDInp.setAttribute("readonly", "readonly");
	coachingEdYMDInp.setAttribute("readonly", "readonly");
	certifyStYMDInp.setAttribute("readonly", "readonly");
	certifyEdYMDInp.setAttribute("readonly", "readonly");

	admissionYMDInp.setAttribute("style", "border: none;");
	quitYMDInp.setAttribute("style", "border: none;");
	positionNameInp.setAttribute("style", "border: none;");
	societyPosiStYMDInp.setAttribute("style", "border: none;");
	societyPosiEdYMDInp.setAttribute("style", "border: none;");
	coachingAcquisiYMDInp.setAttribute("style", "border: none;");
	advisingDoctorNmInp.setAttribute("style", "border: none;");
	certifyingPhysicianNmInp.setAttribute("style", "border: none;");
	coachingStYMDInp.setAttribute("style", "border: none;");
	coachingEdYMDInp.setAttribute("style", "border: none;");
	certifyStYMDInp.setAttribute("style", "border: none;");
	certifyEdYMDInp.setAttribute("style", "border: none;");

	let tr = document.createElement("tr");
	let td0 = document.createElement("td");
	let td1 = document.createElement("td");
	let td2 = document.createElement("td");
	let td3 = document.createElement("td");
	let td4 = document.createElement("td");
	let td5 = document.createElement("td");
	let td6 = document.createElement("td");
	let td7 = document.createElement("td");
	let td8 = document.createElement("td");
	let td9 = document.createElement("td");
	let td10 = document.createElement("td");
	let td11 = document.createElement("td");
	let td12 = document.createElement("td");
	let td13 = document.createElement("td");
	let a = document.createElement("a");
	let image = document.createElement("img");

	//tr下にhidden定義を入れる
	tr.appendChild(positionCodeInp);
	tr.appendChild(advisingDoctorCdInp);
	tr.appendChild(certifyingPhysicianCdInp);
	tr.appendChild(medicalSocietyNmInp);
	tr.appendChild(admissionYYYYInp);
	tr.appendChild(admissionMMInp);
	tr.appendChild(admissionDDInp);
	tr.appendChild(quitYYYYInp);
	tr.appendChild(quitMMInp);
	tr.appendChild(quitDDInp);
	tr.appendChild(societyPosiStYYYYInp);
	tr.appendChild(societyPosiStMMInp);
	tr.appendChild(societyPosiStDDInp);
	tr.appendChild(societyPosiEdYYYYInp);
	tr.appendChild(societyPosiEdMMInp);
	tr.appendChild(societyPosiEdDDInp);
	tr.appendChild(coachingAcquisiYYYYInp);
	tr.appendChild(coachingAcquisiMMInp);
	tr.appendChild(coachingAcquisiDDInp);
	tr.appendChild(coachingStYYYYInp);
	tr.appendChild(coachingStMMInp);
	tr.appendChild(coachingStDDInp);
	tr.appendChild(coachingEdYYYYInp);
	tr.appendChild(coachingEdMMInp);
	tr.appendChild(coachingEdDDInp);
	tr.appendChild(certifyStYYYYInp);
	tr.appendChild(certifyStMMInp);
	tr.appendChild(certifyStDDInp);
	tr.appendChild(certifyEdYYYYInp);
	tr.appendChild(certifyEdMMInp);
	tr.appendChild(certifyEdDDInp);

	//新規の返りなので絶対に編集できる
	a.className = "comMiniLink";
	a.setAttribute("href", "");
	const js = "JavaScript:tmpChsView('1','"+hcpSocRow+"');return false;";
	a.setAttribute("onclick", js);
	image.setAttribute("border", "0");
	image.setAttribute("src", "img/button_update.gif");
	a.appendChild(image);
	td0.appendChild(a);
	tr.appendChild(td0);

	let text1 = document.createTextNode(medicalSocietyNm);
	td1.appendChild(text1);
	tr.appendChild(td1);

	td2.appendChild(admissionYMDInp);
	tr.appendChild(td2);

	td3.appendChild(quitYMDInp);
	tr.appendChild(td3);

	td4.appendChild(positionNameInp);
	tr.appendChild(td4);

	td5.appendChild(societyPosiStYMDInp);
	tr.appendChild(td5);

	td6.appendChild(societyPosiEdYMDInp);
	tr.appendChild(td6);

	td7.appendChild(coachingAcquisiYMDInp);
	tr.appendChild(td7);

	td8.appendChild(advisingDoctorNmInp);
	tr.appendChild(td8);

	td9.appendChild(certifyingPhysicianNmInp);
	tr.appendChild(td9);

	td10.appendChild(coachingStYMDInp);
	tr.appendChild(td10);

	td11.appendChild(coachingEdYMDInp);
	tr.appendChild(td11);

	td12.appendChild(certifyStYMDInp);
	tr.appendChild(td12);

	td13.appendChild(certifyEdYMDInp);
	tr.appendChild(td13);

	hcpSocTable.appendChild(tr);

	return false;
}

/**
 * 公的機関編集画面を呼び出します。
 *@param newupdFlg	呼び出し元オブジェクト
 *@param indexNo	選択行番号
 */
function tmpChpView(newupdFlg,indexNo){

// 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 全てのポップアップを閉じる
  hcpClosePopUp(gChpViewWin, "gChpViewWin");
  gChpViewSelId = indexNo;
  // パラメータの設定
  if (newupdFlg == "0") {//新規
    document.fm1.hcpPublicDataChgFlg.value = "0";
    document.fm1.classCategoryCdPop.value = "";
    document.fm1.pubInstitutionCdPop.value = "";
    document.fm1.pubInstitutionNmPop.value = "";
    document.fm1.pubInstPositionCdPop.value = "";
    document.fm1.pubInstStYYYYPop.value = "";
    document.fm1.pubInstStMMPop.value = "";
    document.fm1.pubInstStDDPop.value = "";
    document.fm1.pubInstEdYYYYPop.value = "";
    document.fm1.pubInstEdMMPop.value = "";
    document.fm1.pubInstEdDDPop.value = "";
    document.fm1.pubInstposStYYYYPop.value = "";
    document.fm1.pubInstposStMMPop.value = "";
    document.fm1.pubInstposStDDPop.value = "";
    document.fm1.pubInstposEdYYYYPop.value = "";
    document.fm1.pubInstposEdMMPop.value = "";
    document.fm1.pubInstposEdDDPop.value = "";
  } else {//更新
    document.fm1.hcpPublicDataChgFlg.value = "1";

    var classCategoryCd = "hcpPublicDataList[" + indexNo + "].classCategoryCd";
    var classCategoryCdValue = document.getElementsByName(classCategoryCd)[0].value;
    document.fm1.classCategoryCdPop.value = classCategoryCdValue;

    var pubInstitutionCd = "hcpPublicDataList[" + indexNo + "].pubInstitutionCd";
    var pubInstitutionCdValue = document.getElementsByName(pubInstitutionCd)[0].value;
    document.fm1.pubInstitutionCdPop.value = pubInstitutionCdValue;

    var pubInstitutionNm = "hcpPublicDataList[" + indexNo + "].pubInstitutionNm";
    var pubInstitutionNmValue = document.getElementsByName(pubInstitutionNm)[0].value;
    document.fm1.pubInstitutionNmPop.value = pubInstitutionNmValue;

    var pubInstPositionCd = "hcpPublicDataList[" + indexNo + "].pubInstPositionCd";
    var pubInstPositionCdValue = document.getElementsByName(pubInstPositionCd)[0].value;
    document.fm1.pubInstPositionCdPop.value = pubInstPositionCdValue;

    var pubInstStYYYY = "hcpPublicDataList[" + indexNo + "].pubInstStYYYY";
    var pubInstStYYYYValue = document.getElementsByName(pubInstStYYYY)[0].value;
    document.fm1.pubInstStYYYYPop.value = pubInstStYYYYValue;
    var pubInstStMM = "hcpPublicDataList[" + indexNo + "].pubInstStMM";
    var pubInstStMMValue = document.getElementsByName(pubInstStMM)[0].value;
    document.fm1.pubInstStMMPop.value = pubInstStMMValue;
    var pubInstStDD = "hcpPublicDataList[" + indexNo + "].pubInstStDD";
    var pubInstStDDValue = document.getElementsByName(pubInstStDD)[0].value;
    document.fm1.pubInstStDDPop.value = pubInstStDDValue;

    var pubInstEdYYYY = "hcpPublicDataList[" + indexNo + "].pubInstEdYYYY";
    var pubInstEdYYYYValue = document.getElementsByName(pubInstEdYYYY)[0].value;
    document.fm1.pubInstEdYYYYPop.value = pubInstEdYYYYValue;
    var pubInstEdMM = "hcpPublicDataList[" + indexNo + "].pubInstEdMM";
    var pubInstEdMMValue = document.getElementsByName(pubInstEdMM)[0].value;
    document.fm1.pubInstEdMMPop.value = pubInstEdMMValue;
    var pubInstEdDD = "hcpPublicDataList[" + indexNo + "].pubInstEdDD";
    var pubInstEdDDValue = document.getElementsByName(pubInstEdDD)[0].value;
    document.fm1.pubInstEdDDPop.value = pubInstEdDDValue;

    var pubInstposStYYYY = "hcpPublicDataList[" + indexNo + "].pubInstposStYYYY";
    var pubInstposStYYYYValue = document.getElementsByName(pubInstposStYYYY)[0].value;
    document.fm1.pubInstposStYYYYPop.value = pubInstposStYYYYValue;
    var pubInstposStMM = "hcpPublicDataList[" + indexNo + "].pubInstposStMM";
    var pubInstposStMMValue = document.getElementsByName(pubInstposStMM)[0].value;
    document.fm1.pubInstposStMMPop.value = pubInstposStMMValue;
    var pubInstposStDD = "hcpPublicDataList[" + indexNo + "].pubInstposStDD";
    var pubInstposStDDValue = document.getElementsByName(pubInstposStDD)[0].value;
    document.fm1.pubInstposStDDPop.value = pubInstposStDDValue;
    var pubInstposEdYYYY = "hcpPublicDataList[" + indexNo + "].pubInstposEdYYYY";
    var pubInstposEdYYYYValue = document.getElementsByName(pubInstposEdYYYY)[0].value;
    document.fm1.pubInstposEdYYYYPop.value = pubInstposEdYYYYValue;
    var pubInstposEdMM = "hcpPublicDataList[" + indexNo + "].pubInstposEdMM";
    var pubInstposEdMMValue = document.getElementsByName(pubInstposEdMM)[0].value;
    document.fm1.pubInstposEdMMPop.value = pubInstposEdMMValue;
    var pubInstposEdDD = "hcpPublicDataList[" + indexNo + "].pubInstposEdDD";
    var pubInstposEdDDValue = document.getElementsByName(pubInstposEdDD)[0].value;
    document.fm1.pubInstposEdDDPop.value = pubInstposEdDDValue;
  }

  gChpViewWin = chpView(gChpViewWin,"tmpCallBackChpView","gChpViewWin");
  return(true);
}

/**
 * <pre>
 * 公的機関　コールバック関数。
 * </pre>
 */
function tmpCallBackChpView(hcpPublicDataChgFlg,classCategoryCdPop,classCategoryNmPop,pubInstitutionCdPop,pubInstitutionNmPop,pubInstPositionCdPop,pubInstPositionNmPop
		,pubInstStYYYYPop,pubInstStMMPop,pubInstStDDPop,pubInstEdYYYYPop,pubInstEdMMPop,pubInstEdDDPop
		,pubInstposStYYYYPop,pubInstposStMMPop,pubInstposStDDPop,pubInstposEdYYYYPop,pubInstposEdMMPop,pubInstposEdDDPop
){
	if(hcpPublicDataChgFlg == "0"){
		CallBackToNewHcpPubRow(classCategoryCdPop,classCategoryNmPop,pubInstitutionCdPop,pubInstitutionNmPop,pubInstPositionCdPop,pubInstPositionNmPop
				,pubInstStYYYYPop,pubInstStMMPop,pubInstStDDPop,pubInstEdYYYYPop,pubInstEdMMPop,pubInstEdDDPop
				,pubInstposStYYYYPop,pubInstposStMMPop,pubInstposStDDPop,pubInstposEdYYYYPop,pubInstposEdMMPop,pubInstposEdDDPop
		);
	}else{
		CallBackToUpdHcpPubRow(gChpViewSelId,classCategoryCdPop,classCategoryNmPop,pubInstitutionCdPop,pubInstitutionNmPop,pubInstPositionCdPop,pubInstPositionNmPop
				,pubInstStYYYYPop,pubInstStMMPop,pubInstStDDPop,pubInstEdYYYYPop,pubInstEdMMPop,pubInstEdDDPop
				,pubInstposStYYYYPop,pubInstposStMMPop,pubInstposStDDPop,pubInstposEdYYYYPop,pubInstposEdMMPop,pubInstposEdDDPop
		);
	}
}

/**
 * 公的機関編集画面(編集)からの戻り。
 *@param POPUPで設定された値
 *@param indexNo	選択行番号
 */
function CallBackToUpdHcpPubRow(indexNo,classCategoryCdPop,classCategoryNmPop,pubInstitutionCdPop,pubInstitutionNmPop,pubInstPositionCdPop,pubInstPositionNmPop
		,pubInstStYYYYPop,pubInstStMMPop,pubInstStDDPop,pubInstEdYYYYPop,pubInstEdMMPop,pubInstEdDDPop
		,pubInstposStYYYYPop,pubInstposStMMPop,pubInstposStDDPop,pubInstposEdYYYYPop,pubInstposEdMMPop,pubInstposEdDDPop
){
	var classCategoryCd = "hcpPublicDataList[" + indexNo + "].classCategoryCd";
	document.getElementsByName(classCategoryCd)[0].value = classCategoryCdPop;
	var classCategoryNm = "hcpPublicDataList[" + indexNo + "].classCategoryNm";
	document.getElementsByName(classCategoryNm)[0].value = classCategoryNmPop;
//    var pubInstitutionCd = "hcpPublicDataList[" + indexNo + "].pubInstitutionCd";
//    document.getElementsByName(pubInstitutionCd)[0].value = pubInstitutionCdPop;
//    var pubInstitutionNm = "hcpPublicDataList[" + indexNo + "].pubInstitutionNm";
//    document.getElementsByName(pubInstitutionNm)[0].value = pubInstitutionNmPop;
    var pubInstPositionCd = "hcpPublicDataList[" + indexNo + "].pubInstPositionCd";
    document.getElementsByName(pubInstPositionCd)[0].value = pubInstPositionCdPop;
    var pubInstPositionNm = "hcpPublicDataList[" + indexNo + "].pubInstPositionNm";
    document.getElementsByName(pubInstPositionNm)[0].value = pubInstPositionNmPop;

    var pubInstStYYYY = "hcpPublicDataList[" + indexNo + "].pubInstStYYYY";
    document.getElementsByName(pubInstStYYYY)[0].value = pubInstStYYYYPop;
    var pubInstStMM = "hcpPublicDataList[" + indexNo + "].pubInstStMM";
    document.getElementsByName(pubInstStMM)[0].value = pubInstStMMPop;
    var pubInstStDD = "hcpPublicDataList[" + indexNo + "].pubInstStDD";
    document.getElementsByName(pubInstStDD)[0].value = pubInstStDDPop;
    var pubInstStYMD = "hcpPublicDataList[" + indexNo + "].pubInstStYMD";
    var pubInstStYMDPop = "";
    if(pubInstStYYYYPop != null && pubInstStYYYYPop != ""){pubInstStYMDPop += pubInstStYYYYPop;}
    if(pubInstStMMPop != null && pubInstStMMPop != ""){pubInstStYMDPop += ("/" + pubInstStMMPop);}
    if(pubInstStDDPop != null && pubInstStDDPop != ""){pubInstStYMDPop += ("/" + pubInstStDDPop);}
    document.getElementsByName(pubInstStYMD)[0].value = pubInstStYMDPop;

    var pubInstEdYYYY = "hcpPublicDataList[" + indexNo + "].pubInstEdYYYY";
    document.getElementsByName(pubInstEdYYYY)[0].value = pubInstEdYYYYPop;
    var pubInstEdMM = "hcpPublicDataList[" + indexNo + "].pubInstEdMM";
    document.getElementsByName(pubInstEdMM)[0].value = pubInstEdMMPop;
    var pubInstEdDD = "hcpPublicDataList[" + indexNo + "].pubInstEdDD";
    document.getElementsByName(pubInstEdDD)[0].value = pubInstEdDDPop;
    var pubInstEdYMD = "hcpPublicDataList[" + indexNo + "].pubInstEdYMD";
    var pubInstEdYMDPop = "";
    if(pubInstEdYYYYPop != null && pubInstEdYYYYPop != ""){pubInstEdYMDPop += pubInstEdYYYYPop;}
    if(pubInstEdMMPop != null && pubInstEdMMPop != ""){pubInstEdYMDPop += ("/" + pubInstEdMMPop);}
    if(pubInstEdDDPop != null && pubInstEdDDPop != ""){pubInstEdYMDPop += ("/" + pubInstEdDDPop);}
    document.getElementsByName(pubInstEdYMD)[0].value = pubInstEdYMDPop;

    var pubInstposStYYYY = "hcpPublicDataList[" + indexNo + "].pubInstposStYYYY";
    document.getElementsByName(pubInstposStYYYY)[0].value = pubInstposStYYYYPop;
    var pubInstposStMM = "hcpPublicDataList[" + indexNo + "].pubInstposStMM";
    document.getElementsByName(pubInstposStMM)[0].value = pubInstposStMMPop;
    var pubInstposStDD = "hcpPublicDataList[" + indexNo + "].pubInstposStDD";
    document.getElementsByName(pubInstposStDD)[0].value = pubInstposStDDPop;
    var pubInstposStYMD = "hcpPublicDataList[" + indexNo + "].pubInstposStYMD";
    var pubInstposStYMDPop = "";
    if(pubInstposStYYYYPop != null && pubInstposStYYYYPop != ""){pubInstposStYMDPop += pubInstposStYYYYPop;}
    if(pubInstposStMMPop != null && pubInstposStMMPop != ""){pubInstposStYMDPop += ("/" + pubInstposStMMPop);}
    if(pubInstposStDDPop != null && pubInstposStDDPop != ""){pubInstposStYMDPop += ("/" + pubInstposStDDPop);}
    document.getElementsByName(pubInstposStYMD)[0].value = pubInstposStYMDPop;

    var pubInstposEdYYYY = "hcpPublicDataList[" + indexNo + "].pubInstposEdYYYY";
    document.getElementsByName(pubInstposEdYYYY)[0].value = pubInstposEdYYYYPop;
    var pubInstposEdMM = "hcpPublicDataList[" + indexNo + "].pubInstposEdMM";
    document.getElementsByName(pubInstposEdMM)[0].value = pubInstposEdMMPop;
    var pubInstposEdDD = "hcpPublicDataList[" + indexNo + "].pubInstposEdDD";
    document.getElementsByName(pubInstposEdDD)[0].value = pubInstposEdDDPop;
    var pubInstposEdYMD = "hcpPublicDataList[" + indexNo + "].pubInstposEdYMD";
    var pubInstposEdYMDPop = "";
    if(pubInstposEdYYYYPop != null && pubInstposEdYYYYPop != ""){pubInstposEdYMDPop += pubInstposEdYYYYPop;}
    if(pubInstposEdMMPop != null && pubInstposEdMMPop != ""){pubInstposEdYMDPop += ("/" + pubInstposEdMMPop);}
    if(pubInstposEdDDPop != null && pubInstposEdDDPop != ""){pubInstposEdYMDPop += ("/" + pubInstposEdDDPop);}
    document.getElementsByName(pubInstposEdYMD)[0].value = pubInstposEdYMDPop;

}

/**
 * 公的機関編集画面(新規)からの戻り。
 *@param POPUPで設定された値
 */
function CallBackToNewHcpPubRow(classCategoryCd,classCategoryNm,pubInstitutionCd,pubInstitutionNm,pubInstPositionCd,pubInstPositionNm
		,pubInstStYYYY,pubInstStMM,pubInstStDD,pubInstEdYYYY,pubInstEdMM,pubInstEdDD
		,pubInstposStYYYY,pubInstposStMM,pubInstposStDD,pubInstposEdYYYY,pubInstposEdMM,pubInstposEdDD
){
	let hcpPubTable = document.getElementById("formTable07");
	let hcpPubRow = Number(hcpPubTable.rows.length)-1;

    var pubInstStYMDPop = "";
    if(pubInstStYYYY != null && pubInstStYYYY != ""){pubInstStYMDPop += pubInstStYYYY;}
    if(pubInstStMM != null && pubInstStMM != ""){pubInstStYMDPop += ("/" + pubInstStMM);}
    if(pubInstStDD != null && pubInstStDD != ""){pubInstStYMDPop += ("/" + pubInstStDD);}
    let pubInstStYMD = pubInstStYMDPop;
    var pubInstEdYMDPop = "";
    if(pubInstEdYYYY != null && pubInstEdYYYY != ""){pubInstEdYMDPop += pubInstEdYYYY;}
    if(pubInstEdMM != null && pubInstEdMM != ""){pubInstEdYMDPop += ("/" + pubInstEdMM);}
    if(pubInstEdDD != null && pubInstEdDD != ""){pubInstEdYMDPop += ("/" + pubInstEdDD);}
    let pubInstEdYMD = pubInstEdYMDPop;
    var pubInstposStYMDPop = "";
    if(pubInstposStYYYY != null && pubInstposStYYYY != ""){pubInstposStYMDPop += pubInstposStYYYY;}
    if(pubInstposStMM != null && pubInstposStMM != ""){pubInstposStYMDPop += ("/" + pubInstposStMM);}
    if(pubInstposStDD != null && pubInstposStDD != ""){pubInstposStYMDPop += ("/" + pubInstposStDD);}
    let pubInstposStYMD = pubInstposStYMDPop;
    var pubInstposEdYMDPop = "";
    if(pubInstposEdYYYY != null && pubInstposEdYYYY != ""){pubInstposEdYMDPop += pubInstposEdYYYY;}
    if(pubInstposEdMM != null && pubInstposEdMM != ""){pubInstposEdYMDPop += ("/" + pubInstposEdMM);}
    if(pubInstposEdDD != null && pubInstposEdDD != ""){pubInstposEdYMDPop += ("/" + pubInstposEdDD);}
    let pubInstposEdYMD = pubInstposEdYMDPop;

	let classCategoryCdInp = document.createElement("input");
	let classCategoryNmInp = document.createElement("input");
	let pubInstitutionCdInp = document.createElement("input");
	let pubInstitutionNmInp = document.createElement("input");
	let pubInstPositionCdInp = document.createElement("input");
	let pubInstPositionNmInp = document.createElement("input");
	let pubInstStYYYYInp = document.createElement("input");
	let pubInstStMMInp = document.createElement("input");
	let pubInstStDDInp = document.createElement("input");
	let pubInstStYMDInp = document.createElement("input");
	let pubInstEdYYYYInp = document.createElement("input");
	let pubInstEdMMInp = document.createElement("input");
	let pubInstEdDDInp = document.createElement("input");
	let pubInstEdYMDInp = document.createElement("input");
	let pubInstposStYYYYInp = document.createElement("input");
	let pubInstposStMMInp = document.createElement("input");
	let pubInstposStDDInp = document.createElement("input");
	let pubInstposStYMDInp = document.createElement("input");
	let pubInstposEdYYYYInp = document.createElement("input");
	let pubInstposEdMMInp = document.createElement("input");
	let pubInstposEdDDInp = document.createElement("input");
	let pubInstposEdYMDInp = document.createElement("input");

	classCategoryCdInp.setAttribute("type", "hidden");
	classCategoryNmInp.setAttribute("type", "text");
	pubInstitutionCdInp.setAttribute("type", "hidden");
	pubInstitutionNmInp.setAttribute("type", "hidden");
	pubInstPositionCdInp.setAttribute("type", "hidden");
	pubInstPositionNmInp.setAttribute("type", "text");
	pubInstStYYYYInp.setAttribute("type", "hidden");
	pubInstStMMInp.setAttribute("type", "hidden");
	pubInstStDDInp.setAttribute("type", "hidden");
	pubInstStYMDInp.setAttribute("type", "text");
	pubInstEdYYYYInp.setAttribute("type", "hidden");
	pubInstEdMMInp.setAttribute("type", "hidden");
	pubInstEdDDInp.setAttribute("type", "hidden");
	pubInstEdYMDInp.setAttribute("type", "text");
	pubInstposStYYYYInp.setAttribute("type", "hidden");
	pubInstposStMMInp.setAttribute("type", "hidden");
	pubInstposStDDInp.setAttribute("type", "hidden");
	pubInstposStYMDInp.setAttribute("type", "text");
	pubInstposEdYYYYInp.setAttribute("type", "hidden");
	pubInstposEdMMInp.setAttribute("type", "hidden");
	pubInstposEdDDInp.setAttribute("type", "hidden");
	pubInstposEdYMDInp.setAttribute("type", "text");

	classCategoryCdInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].classCategoryCd");
	classCategoryNmInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].classCategoryNm");
	pubInstitutionCdInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstitutionCd");
	pubInstitutionNmInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstitutionNm");
	pubInstPositionCdInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstPositionCd");
	pubInstPositionNmInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstPositionNm");
	pubInstStYYYYInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstStYYYY");
	pubInstStMMInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstStMM");
	pubInstStDDInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstStDD");
	pubInstStYMDInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstStYMD");
	pubInstEdYYYYInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstEdYYYY");
	pubInstEdMMInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstEdMM");
	pubInstEdDDInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstEdDD");
	pubInstEdYMDInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstEdYMD");
	pubInstposStYYYYInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstposStYYYY");
	pubInstposStMMInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstposStMM");
	pubInstposStDDInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstposStDD");
	pubInstposStYMDInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstposStYMD");
	pubInstposEdYYYYInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstposEdYYYY");
	pubInstposEdMMInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstposEdMM");
	pubInstposEdDDInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstposEdDD");
	pubInstposEdYMDInp.setAttribute("name", "hcpPublicDataList["+hcpPubRow+"].pubInstposEdYMD");

	classCategoryCdInp.setAttribute("value", classCategoryCd);
	classCategoryNmInp.setAttribute("value", classCategoryNm);
	pubInstitutionCdInp.setAttribute("value", pubInstitutionCd);
	pubInstitutionNmInp.setAttribute("value", pubInstitutionNm);
	pubInstPositionCdInp.setAttribute("value", pubInstPositionCd);
	pubInstPositionNmInp.setAttribute("value", pubInstPositionNm);
	pubInstStYYYYInp.setAttribute("value", pubInstStYYYY);
	pubInstStMMInp.setAttribute("value", pubInstStMM);
	pubInstStDDInp.setAttribute("value", pubInstStDD);
	pubInstStYMDInp.setAttribute("value", pubInstStYMD);
	pubInstEdYYYYInp.setAttribute("value", pubInstEdYYYY);
	pubInstEdMMInp.setAttribute("value", pubInstEdMM);
	pubInstEdDDInp.setAttribute("value", pubInstEdDD);
	pubInstEdYMDInp.setAttribute("value", pubInstEdYMD);
	pubInstposStYYYYInp.setAttribute("value", pubInstposStYYYY);
	pubInstposStMMInp.setAttribute("value", pubInstposStMM);
	pubInstposStDDInp.setAttribute("value", pubInstposStDD);
	pubInstposStYMDInp.setAttribute("value", pubInstposStYMD);
	pubInstposEdYYYYInp.setAttribute("value", pubInstposEdYYYY);
	pubInstposEdMMInp.setAttribute("value", pubInstposEdMM);
	pubInstposEdDDInp.setAttribute("value", pubInstposEdDD);
	pubInstposEdYMDInp.setAttribute("value", pubInstposEdYMD);

	classCategoryNmInp.setAttribute("readonly", "readonly");
//	pubInstitutionNmInp.setAttribute("readonly", "readonly");
	pubInstPositionNmInp.setAttribute("readonly", "readonly");
	pubInstStYMDInp.setAttribute("readonly", "readonly");
	pubInstEdYMDInp.setAttribute("readonly", "readonly");
	pubInstposStYMDInp.setAttribute("readonly", "readonly");
	pubInstposEdYMDInp.setAttribute("readonly", "readonly");

	classCategoryNmInp.setAttribute("style", "border: none;");
//	pubInstitutionNmInp.setAttribute("style", "border: none;");
	pubInstPositionNmInp.setAttribute("style", "border: none;");
	pubInstStYMDInp.setAttribute("style", "border: none;");
	pubInstEdYMDInp.setAttribute("style", "border: none;");
	pubInstposStYMDInp.setAttribute("style", "border: none;");
	pubInstposEdYMDInp.setAttribute("style", "border: none;");

	let tr = document.createElement("tr");
	let td0 = document.createElement("td");
	let td1 = document.createElement("td");
	let td2 = document.createElement("td");
	let td3 = document.createElement("td");
	let td4 = document.createElement("td");
	let td5 = document.createElement("td");
	let td6 = document.createElement("td");
	let td7 = document.createElement("td");
	let a = document.createElement("a");
	let image = document.createElement("img");

	//tr下にhidden定義を入れる
	tr.appendChild(classCategoryCdInp);
	tr.appendChild(pubInstitutionCdInp);
	tr.appendChild(pubInstPositionCdInp);
	tr.appendChild(pubInstitutionNmInp);
	tr.appendChild(pubInstStYYYYInp);
	tr.appendChild(pubInstStMMInp);
	tr.appendChild(pubInstStDDInp);
	tr.appendChild(pubInstEdYYYYInp);
	tr.appendChild(pubInstEdMMInp);
	tr.appendChild(pubInstEdDDInp);
	tr.appendChild(pubInstposStYYYYInp);
	tr.appendChild(pubInstposStMMInp);
	tr.appendChild(pubInstposStDDInp);
	tr.appendChild(pubInstposEdYYYYInp);
	tr.appendChild(pubInstposEdMMInp);
	tr.appendChild(pubInstposEdDDInp);


	//新規の返りなので絶対に編集できる
	a.className = "comMiniLink";
	a.setAttribute("href", "");
	const js = "JavaScript:tmpChpView('1','"+hcpPubRow+"');return false;";
	a.setAttribute("onclick", js);
	image.setAttribute("border", "0");
	image.setAttribute("src", "img/button_update.gif");
	a.appendChild(image);
	td0.appendChild(a);
	tr.appendChild(td0);

	td1.appendChild(classCategoryNmInp);
	tr.appendChild(td1);

	let text2 = document.createTextNode(pubInstitutionNm);
	td2.appendChild(text2);
	tr.appendChild(td2);

	td3.appendChild(pubInstStYMDInp);
	tr.appendChild(td3);

	td4.appendChild(pubInstEdYMDInp);
	tr.appendChild(td4);

	td5.appendChild(pubInstPositionNmInp);
	tr.appendChild(td5);

	td6.appendChild(pubInstposStYMDInp);
	tr.appendChild(td6);

	td7.appendChild(pubInstposEdYMDInp);
	tr.appendChild(td7);

	hcpPubTable.appendChild(tr);

	return false;
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
  document.fm1.backScreenId.value = "ND011";
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
  if(gCdcCsdViewSelId == "0") {
    document.fm1.homeDeptCd.value = deptCode;
    document.fm1.homeDeptNm.value = DeptKj;
  } else if(gCdcCsdViewSelId == "1") {
    document.fm1.skDeptCd.value = deptCode;
    document.fm1.skDeptNm.value = DeptKj;
  } else{//ここにはこない
  }
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
  document.fm1.backScreenId.value = "ND011";
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
    document.fm1.skInsNm.value = insFormalName;
    document.fm1.skInsHoInsType.value = hoInsType;
    document.fm1.skInsInsClass.value = insClass;

}