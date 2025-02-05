/**
 * <pre>
 *	所属学会POPUPのJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author
 */

/**
 * <pre>
 *	アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var CHS_APPLICATION_ID = "CHS";

/**
 * スクリーンID
 */
var CHS_SCREEN_ID		= "CatHcpSoc";

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *			 このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function chsView(w,callBack,winVarName){

	//フォーカスをあてる処理と２度押し対策を共通関数化
	//戻り値がtrueならポップアップ処理を継続 falseならwindowオブジェクトを戻します。
	if(!comPopupPreCheck(w,winVarName)){
		return(w);
	}

	//windowに名前を付ける。(現在日時を付加して)
	var winName = comCreateWindowName(CHS_APPLICATION_ID);

	//ウインドウの体裁(幅や高さなど)はここで指定します。
	w = window.open ("",winName,"width=900,height=400,resizable=no,status=no,toolbar=no,scrollbars=yes,titlebar=no");

	uri = "NC206Init.action";		//oc4jのmapsアプリを利用してhtmlのテストドライバを利用する場合

	  ix1 = 0;
	  jokenName = new Array();	//パラメタの名前を1次元配列で指定
	  joken = new Array();		//パラメタの値を2次元配列で指定

	  jokenName[ix1] = "hcpSocietyDataChgFlg";
	  joken[ix1++] = new Array(document.fm1.hcpSocietyDataChgFlg.value);
	  jokenName[ix1] = "positionCodePop";
	  joken[ix1++] = new Array(document.fm1.positionCodePop.value);
	  jokenName[ix1] = "advisingDoctorCdPop";
	  joken[ix1++] = new Array(document.fm1.advisingDoctorCdPop.value);
	  jokenName[ix1] = "certifyingPhysicianCdPop";
	  joken[ix1++] = new Array(document.fm1.certifyingPhysicianCdPop.value);
	  jokenName[ix1] = "medicalSocietyNmPop";
	  joken[ix1++] = new Array(document.fm1.medicalSocietyNmPop.value);
	  jokenName[ix1] = "admissionYYYYPop";
	  joken[ix1++] = new Array(document.fm1.admissionYYYYPop.value);
	  jokenName[ix1] = "admissionMMPop";
	  joken[ix1++] = new Array(document.fm1.admissionMMPop.value);
	  jokenName[ix1] = "admissionDDPop";
	  joken[ix1++] = new Array(document.fm1.admissionDDPop.value);
	  jokenName[ix1] = "quitYYYYPop";
	  joken[ix1++] = new Array(document.fm1.quitYYYYPop.value);
	  jokenName[ix1] = "quitMMPop";
	  joken[ix1++] = new Array(document.fm1.quitMMPop.value);
	  jokenName[ix1] = "quitDDPop";
	  joken[ix1++] = new Array(document.fm1.quitDDPop.value);
	  jokenName[ix1] = "positionNamePop";
	  joken[ix1++] = new Array(document.fm1.positionNamePop.value);
	  jokenName[ix1] = "societyPosiStYYYYPop";
	  joken[ix1++] = new Array(document.fm1.societyPosiStYYYYPop.value);
	  jokenName[ix1] = "societyPosiStMMPop";
	  joken[ix1++] = new Array(document.fm1.societyPosiStMMPop.value);
	  jokenName[ix1] = "societyPosiStDDPop";
	  joken[ix1++] = new Array(document.fm1.societyPosiStDDPop.value);
	  jokenName[ix1] = "societyPosiEdYYYYPop";
	  joken[ix1++] = new Array(document.fm1.societyPosiEdYYYYPop.value);
	  jokenName[ix1] = "societyPosiEdMMPop";
	  joken[ix1++] = new Array(document.fm1.societyPosiEdMMPop.value);
	  jokenName[ix1] = "societyPosiEdDDPop";
	  joken[ix1++] = new Array(document.fm1.societyPosiEdDDPop.value);
	  jokenName[ix1] = "coachingAcquisiYYYYPop";
	  joken[ix1++] = new Array(document.fm1.coachingAcquisiYYYYPop.value);
	  jokenName[ix1] = "coachingAcquisiMMPop";
	  joken[ix1++] = new Array(document.fm1.coachingAcquisiMMPop.value);
	  jokenName[ix1] = "coachingAcquisiDDPop";
	  joken[ix1++] = new Array(document.fm1.coachingAcquisiDDPop.value);
	  jokenName[ix1] = "advisingDoctorNmPop";
	  joken[ix1++] = new Array(document.fm1.advisingDoctorNmPop.value);
	  jokenName[ix1] = "certifyingPhysicianNmPop";
	  joken[ix1++] = new Array(document.fm1.certifyingPhysicianNmPop.value);
	  jokenName[ix1] = "coachingStYYYYPop";
	  joken[ix1++] = new Array(document.fm1.coachingStYYYYPop.value);
	  jokenName[ix1] = "coachingStMMPop";
	  joken[ix1++] = new Array(document.fm1.coachingStMMPop.value);
	  jokenName[ix1] = "coachingStDDPop";
	  joken[ix1++] = new Array(document.fm1.coachingStDDPop.value);
	  jokenName[ix1] = "coachingEdYYYYPop";
	  joken[ix1++] = new Array(document.fm1.coachingEdYYYYPop.value);
	  jokenName[ix1] = "coachingEdMMPop";
	  joken[ix1++] = new Array(document.fm1.coachingEdMMPop.value);
	  jokenName[ix1] = "coachingEdDDPop";
	  joken[ix1++] = new Array(document.fm1.coachingEdDDPop.value);
	  jokenName[ix1] = "certifyStYYYYPop";
	  joken[ix1++] = new Array(document.fm1.certifyStYYYYPop.value);
	  jokenName[ix1] = "certifyStMMPop";
	  joken[ix1++] = new Array(document.fm1.certifyStMMPop.value);
	  jokenName[ix1] = "certifyStDDPop";
	  joken[ix1++] = new Array(document.fm1.certifyStDDPop.value);
	  jokenName[ix1] = "certifyEdYYYYPop";
	  joken[ix1++] = new Array(document.fm1.certifyEdYYYYPop.value);
	  jokenName[ix1] = "certifyEdMMPop";
	  joken[ix1++] = new Array(document.fm1.certifyEdMMPop.value);
	  jokenName[ix1] = "certifyEdDDPop";
	  joken[ix1++] = new Array(document.fm1.certifyEdDDPop.value);

	/*条件有り呼び出しパターン*/
	comPostPopup(w,uri,CHS_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

	w.focus();

	return(w);
}

/**
 * 起動時の処理を記述します。
 */
function chsLoad(){

	//２度押し対策フラグ初期化
	comClickFlgInit();
	//1:適用OKの戻り、0:それ以外
	const returnFlg = document.fm1.returnFlg.value;
	//0:新規、1：更新
	const editFlg = document.fm1.hcpSocietyDataChgFlg.value;
	if(returnFlg == "1"){
		chsReturn()
	}else{
		if(editFlg == "0"){
			document.fm1.medicalSocietyNmPop.focus();
		}else{
			document.fm1.admissionYYYYPop.focus();
		}
		changeBox(0);
	}
}

// セレクトボックスの設定
function changeBox(changeItem){
	if(changeItem == "0" || changeItem == "1"){
		//入会年月日
		const admissionYYYYPop = document.fm1.admissionYYYYPop.value;
		const admissionMMPop = document.fm1.admissionMMPop.value;
		const admissionDDPop = document.fm1.admissionDDPop.value;
		if(admissionYYYYPop != "" && admissionMMPop != "" && admissionDDPop != ""){
			document.fm1.quitYYYYPop.disabled = false;
			document.fm1.quitMMPop.disabled = false;
			document.fm1.quitDDPop.disabled = false;
		}else{
			document.fm1.quitYYYYPop.value = "";
			document.fm1.quitYYYYPop.disabled = true;
			document.fm1.quitMMPop.value = "";
			document.fm1.quitMMPop.disabled = true;
			document.fm1.quitDDPop.value = "";
			document.fm1.quitDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "2"){
		//所属役職
		const positionCodePop = document.fm1.positionCodePop.value;
		if(positionCodePop != ""){
			document.fm1.societyPosiStYYYYPop.disabled = false;
			document.fm1.societyPosiStMMPop.disabled = false;
			document.fm1.societyPosiStDDPop.disabled = false;
		}else{
			document.fm1.societyPosiStYYYYPop.value = "";
			document.fm1.societyPosiStYYYYPop.disabled = true;
			document.fm1.societyPosiStMMPop.value = "";
			document.fm1.societyPosiStMMPop.disabled = true;
			document.fm1.societyPosiStDDPop.value = "";
			document.fm1.societyPosiStDDPop.disabled = true;
			document.fm1.societyPosiEdYYYYPop.value = "";
			document.fm1.societyPosiEdYYYYPop.disabled = true;
			document.fm1.societyPosiEdMMPop.value = "";
			document.fm1.societyPosiEdMMPop.disabled = true;
			document.fm1.societyPosiEdDDPop.value = "";
			document.fm1.societyPosiEdDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "3"){
	    //役職開始年月日
		const societyPosiStYYYYPop = document.fm1.societyPosiStYYYYPop.value;
		const societyPosiStMMPop = document.fm1.societyPosiStMMPop.value;
		const societyPosiStDDPop = document.fm1.societyPosiStDDPop.value;
		if(societyPosiStYYYYPop != "" && societyPosiStMMPop != "" && societyPosiStDDPop != ""){
			document.fm1.societyPosiEdYYYYPop.disabled = false;
			document.fm1.societyPosiEdMMPop.disabled = false;
			document.fm1.societyPosiEdDDPop.disabled = false;
		}else{
			document.fm1.societyPosiEdYYYYPop.value = "";
			document.fm1.societyPosiEdYYYYPop.disabled = true;
			document.fm1.societyPosiEdMMPop.value = "";
			document.fm1.societyPosiEdMMPop.disabled = true;
			document.fm1.societyPosiEdDDPop.value = "";
			document.fm1.societyPosiEdDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "4"){
		//所属学会指導医区分
		const advisingDoctorCdPop = document.fm1.advisingDoctorCdPop.value;
		if(advisingDoctorCdPop == "1"){//○選択
			document.fm1.coachingStYYYYPop.disabled = false;
			document.fm1.coachingStMMPop.disabled = false;
			document.fm1.coachingStDDPop.disabled = false;
		}else{
			document.fm1.coachingStYYYYPop.value = "";
			document.fm1.coachingStYYYYPop.disabled = true;
			document.fm1.coachingStMMPop.value = "";
			document.fm1.coachingStMMPop.disabled = true;
			document.fm1.coachingStDDPop.value = "";
			document.fm1.coachingStDDPop.disabled = true;
			document.fm1.coachingEdYYYYPop.value = "";
			document.fm1.coachingEdYYYYPop.disabled = true;
			document.fm1.coachingEdMMPop.value = "";
			document.fm1.coachingEdMMPop.disabled = true;
			document.fm1.coachingEdDDPop.value = "";
			document.fm1.coachingEdDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "5"){
		//指導医開始年月日
		const coachingStYYYYPop = document.fm1.coachingStYYYYPop.value;
		const coachingStMMPop = document.fm1.coachingStMMPop.value;
		const coachingStDDPop = document.fm1.coachingStDDPop.value;
		if(coachingStYYYYPop != "" && coachingStMMPop != "" && coachingStDDPop != ""){
			document.fm1.coachingEdYYYYPop.disabled = false;
			document.fm1.coachingEdMMPop.disabled = false;
			document.fm1.coachingEdDDPop.disabled = false;
		}else{
			document.fm1.coachingEdYYYYPop.value = "";
			document.fm1.coachingEdYYYYPop.disabled = true;
			document.fm1.coachingEdMMPop.value = "";
			document.fm1.coachingEdMMPop.disabled = true;
			document.fm1.coachingEdDDPop.value = "";
			document.fm1.coachingEdDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "6"){
		//所属学会認定医区分
		const certifyingPhysicianCdPop = document.fm1.certifyingPhysicianCdPop.value;
		if(certifyingPhysicianCdPop == "1"){//○選択
			document.fm1.certifyStYYYYPop.disabled = false;
			document.fm1.certifyStMMPop.disabled = false;
			document.fm1.certifyStDDPop.disabled = false;
		}else{
			document.fm1.certifyStYYYYPop.value = "";
			document.fm1.certifyStYYYYPop.disabled = true;
			document.fm1.certifyStMMPop.value = "";
			document.fm1.certifyStMMPop.disabled = true;
			document.fm1.certifyStDDPop.value = "";
			document.fm1.certifyStDDPop.disabled = true;
			document.fm1.certifyEdYYYYPop.value = "";
			document.fm1.certifyEdYYYYPop.disabled = true;
			document.fm1.certifyEdMMPop.value = "";
			document.fm1.certifyEdMMPop.disabled = true;
			document.fm1.certifyEdDDPop.value = "";
			document.fm1.certifyEdDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "7"){
		//認定医開始年月日
		const certifyStYYYYPop = document.fm1.certifyStYYYYPop.value;
		const certifyStMMPop = document.fm1.certifyStMMPop.value;
		const certifyStDDPop = document.fm1.certifyStDDPop.value;
		if(certifyStYYYYPop != "" && certifyStMMPop != "" && certifyStDDPop != ""){
			document.fm1.certifyEdYYYYPop.disabled = false;
			document.fm1.certifyEdMMPop.disabled = false;
			document.fm1.certifyEdDDPop.disabled = false;
		}else{
			document.fm1.certifyEdYYYYPop.value = "";
			document.fm1.certifyEdYYYYPop.disabled = true;
			document.fm1.certifyEdMMPop.value = "";
			document.fm1.certifyEdMMPop.disabled = true;
			document.fm1.certifyEdDDPop.value = "";
			document.fm1.certifyEdDDPop.disabled = true;
		}
	}
}

/**
 * <pre>
 *  適用処理
 * DB操作処理時に呼ばれます。
 * </pre>
 */
function chsRegister(){
  // 確認メッセージ表示
  if (confirm("適用します。よろしいですか？")){
  } else {
    return false;
  }

  document.fm1.screenId.value = 'NC206';
  document.fm1.functionId.value = 'Register';
  document.fm1.returnFlg.value = "0";

  //イベント呼び出し
  comSubmitForAnyWarp(fm1);

}


/**
 * 値を親ウインドウに返しウインドウを閉じます。
 * 値は、親のコールバック関数に引数として渡す方式とします。
 * @param index form内実データのインデックスを受け取ります。
 */
function chsReturn(){
	//ボタン２度押し対策を、なるべく早いタイミングで行います。
	if(!comChkSubmit(COM_CLICK_ALERT))return(false);
	var hcpSocietyDataChgFlg = document.fm1.hcpSocietyDataChgFlg.value;
    var medicalSocietyNm = document.fm1.medicalSocietyNmPop.value;

    var positionCode = document.fm1.positionCodePop.value;
    var positionName = document.fm1.positionNamePop.value;
    var advisingDoctorCd = document.fm1.advisingDoctorCdPop.value;
    var advisingDoctorNm = document.fm1.advisingDoctorNmPop.value;
    var certifyingPhysicianCd = document.fm1.certifyingPhysicianCdPop.value;
    var certifyingPhysicianNm = document.fm1.certifyingPhysicianNmPop.value;
    var admissionYYYY = document.fm1.admissionYYYYPop.value;
    var admissionMM = document.fm1.admissionMMPop.value;
    var admissionDD = document.fm1.admissionDDPop.value;
    var quitYYYY = document.fm1.quitYYYYPop.value;
    var quitMM = document.fm1.quitMMPop.value;
    var quitDD = document.fm1.quitDDPop.value;
    var societyPosiStYYYY = document.fm1.societyPosiStYYYYPop.value;
    var societyPosiStMM = document.fm1.societyPosiStMMPop.value;
    var societyPosiStDD = document.fm1.societyPosiStDDPop.value;
    var societyPosiEdYYYY = document.fm1.societyPosiEdYYYYPop.value;
    var societyPosiEdMM = document.fm1.societyPosiEdMMPop.value;
    var societyPosiEdDD = document.fm1.societyPosiEdDDPop.value;
    var coachingAcquisiYYYY = document.fm1.coachingAcquisiYYYYPop.value;
    var coachingAcquisiMM = document.fm1.coachingAcquisiMMPop.value;
    var coachingAcquisiDD = document.fm1.coachingAcquisiDDPop.value;
    var coachingStYYYY = document.fm1.coachingStYYYYPop.value;
    var coachingStMM = document.fm1.coachingStMMPop.value;
    var coachingStDD = document.fm1.coachingStDDPop.value;
    var coachingEdYYYY = document.fm1.coachingEdYYYYPop.value;
    var coachingEdMM = document.fm1.coachingEdMMPop.value;
    var coachingEdDD = document.fm1.coachingEdDDPop.value;
    var certifyStYYYY = document.fm1.certifyStYYYYPop.value;
    var certifyStMM = document.fm1.certifyStMMPop.value;
    var certifyStDD = document.fm1.certifyStDDPop.value;
    var certifyEdYYYY = document.fm1.certifyEdYYYYPop.value;
    var certifyEdMM = document.fm1.certifyEdMMPop.value;
    var certifyEdDD = document.fm1.certifyEdDDPop.value;

	//１件選択パターンの場合は、渡したい値をそのままコールバック関数に渡すことにする。
	eval("window.opener." + document.fm1.callBack.value + "(hcpSocietyDataChgFlg,medicalSocietyNm,positionCode,positionName,advisingDoctorCd,advisingDoctorNm,certifyingPhysicianCd,certifyingPhysicianNm,admissionYYYY,admissionMM,admissionDD,quitYYYY,quitMM,quitDD,societyPosiStYYYY,societyPosiStMM,societyPosiStDD,societyPosiEdYYYY,societyPosiEdMM,societyPosiEdDD,coachingAcquisiYYYY,coachingAcquisiMM,coachingAcquisiDD,coachingStYYYY,coachingStMM,coachingStDD,coachingEdYYYY,coachingEdMM,coachingEdDD,certifyStYYYY,certifyStMM,certifyStDD,certifyEdYYYY,certifyEdMM,certifyEdDD)");

	chsClose();
	return(true);
}

/**
 * このウインドウを閉じるときに呼び出されます。
 * 単にウインドウを閉じます。
 */
function chsClose(){
	window.close();
}

function chsUnLoad(){
	try{
		eval("window.opener." + document.fm0.winVarName.value + "=null");
	}catch(err){
	}
}




