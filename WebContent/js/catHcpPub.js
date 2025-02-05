/**
 * <pre>
 *	公的機関POPUPのJavaScript
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
var CHP_APPLICATION_ID = "CHP";

/**
 * スクリーンID
 */
var CHP_SCREEN_ID		= "CatHcpPub";

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *			 このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function chpView(w,callBack,winVarName){

	//フォーカスをあてる処理と２度押し対策を共通関数化
	//戻り値がtrueならポップアップ処理を継続 falseならwindowオブジェクトを戻します。
	if(!comPopupPreCheck(w,winVarName)){
		return(w);
	}

	//windowに名前を付ける。(現在日時を付加して)
	var winName = comCreateWindowName(CHP_APPLICATION_ID);

	//ウインドウの体裁(幅や高さなど)はここで指定します。
	w = window.open ("",winName,"width=900,height=220,resizable=no,status=no,toolbar=no,scrollbars=yes,titlebar=no");

	uri = "NC207Init.action";		//oc4jのmapsアプリを利用してhtmlのテストドライバを利用する場合

	  ix1 = 0;
	  jokenName = new Array();	//パラメタの名前を1次元配列で指定
	  joken = new Array();		//パラメタの値を2次元配列で指定

	  jokenName[ix1] = "hcpPublicDataChgFlg";
	  joken[ix1++] = new Array(document.fm1.hcpPublicDataChgFlg.value);
	  jokenName[ix1] = "classCategoryCdPop";
	  joken[ix1++] = new Array(document.fm1.classCategoryCdPop.value);
	  jokenName[ix1] = "classCategoryNmPop";
	  joken[ix1++] = new Array(document.fm1.classCategoryNmPop.value);
	  jokenName[ix1] = "pubInstitutionCdPop";
	  joken[ix1++] = new Array(document.fm1.pubInstitutionCdPop.value);
	  jokenName[ix1] = "pubInstitutionNmPop";
	  joken[ix1++] = new Array(document.fm1.pubInstitutionNmPop.value);
	  jokenName[ix1] = "pubInstPositionCdPop";
	  joken[ix1++] = new Array(document.fm1.pubInstPositionCdPop.value);
	  jokenName[ix1] = "pubInstPositionNmPop";
	  joken[ix1++] = new Array(document.fm1.pubInstPositionNmPop.value);

	  jokenName[ix1] = "pubInstStYYYYPop";
	  joken[ix1++] = new Array(document.fm1.pubInstStYYYYPop.value);
	  jokenName[ix1] = "pubInstStMMPop";
	  joken[ix1++] = new Array(document.fm1.pubInstStMMPop.value);
	  jokenName[ix1] = "pubInstStDDPop";
	  joken[ix1++] = new Array(document.fm1.pubInstStDDPop.value);
	  jokenName[ix1] = "pubInstEdYYYYPop";
	  joken[ix1++] = new Array(document.fm1.pubInstEdYYYYPop.value);
	  jokenName[ix1] = "pubInstEdMMPop";
	  joken[ix1++] = new Array(document.fm1.pubInstEdMMPop.value);
	  jokenName[ix1] = "pubInstEdDDPop";
	  joken[ix1++] = new Array(document.fm1.pubInstEdDDPop.value);
	  jokenName[ix1] = "pubInstposStYYYYPop";
	  joken[ix1++] = new Array(document.fm1.pubInstposStYYYYPop.value);
	  jokenName[ix1] = "pubInstposStMMPop";
	  joken[ix1++] = new Array(document.fm1.pubInstposStMMPop.value);
	  jokenName[ix1] = "pubInstposStDDPop";
	  joken[ix1++] = new Array(document.fm1.pubInstposStDDPop.value);
	  jokenName[ix1] = "pubInstposEdYYYYPop";
	  joken[ix1++] = new Array(document.fm1.pubInstposEdYYYYPop.value);
	  jokenName[ix1] = "pubInstposEdMMPop";
	  joken[ix1++] = new Array(document.fm1.pubInstposEdMMPop.value);
	  jokenName[ix1] = "pubInstposEdDDPop";
	  joken[ix1++] = new Array(document.fm1.pubInstposEdDDPop.value);

	/*条件有り呼び出しパターン*/
	comPostPopup(w,uri,CHP_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);

	w.focus();

	return(w);
}

/**
 * 起動時の処理を記述します。
 */
function chpLoad(){

	//２度押し対策フラグ初期化
	comClickFlgInit();
	//1:適用OKの戻り、0:それ以外
	const returnFlg = document.fm1.returnFlg.value;
	//0:新規、1：更新
	const editFlg = document.fm1.hcpPublicDataChgFlg.value;
	if(returnFlg == "1"){
		chpReturn()
	}else{
		if(editFlg == "0"){
			document.fm1.classCategoryCdPop.focus();
		}else{
			document.fm1.classCategoryCdPop.focus();
		}
		changeBox(0);
	}
}

// セレクトボックスの設定
function changeBox(changeItem){
	if(changeItem == "0" || changeItem == "1"){
		//2-1 公的機関
		const pubInstitutionCdPop = document.fm1.pubInstitutionCdPop.value;
		if(pubInstitutionCdPop != ""){
			document.fm1.pubInstStYYYYPop.disabled = false;
			document.fm1.pubInstStMMPop.disabled = false;
			document.fm1.pubInstStDDPop.disabled = false;
		}else{
			document.fm1.pubInstStYYYYPop.value = "";
			document.fm1.pubInstStYYYYPop.disabled = true;
			document.fm1.pubInstStMMPop.value = "";
			document.fm1.pubInstStMMPop.disabled = true;
			document.fm1.pubInstStDDPop.value = "";
			document.fm1.pubInstStDDPop.disabled = true;
			document.fm1.pubInstEdYYYYPop.value = "";
			document.fm1.pubInstEdYYYYPop.disabled = true;
			document.fm1.pubInstEdMMPop.value = "";
			document.fm1.pubInstEdMMPop.disabled = true;
			document.fm1.pubInstEdDDPop.value = "";
			document.fm1.pubInstEdDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "2"){
		//2-2 公的機関開始年月日
		const pubInstStYYYYPop = document.fm1.pubInstStYYYYPop.value;
		const pubInstStMMPop = document.fm1.pubInstStMMPop.value;
		const pubInstStDDPop = document.fm1.pubInstStDDPop.value;
		if(pubInstStYYYYPop != "" && pubInstStMMPop != "" && pubInstStDDPop != ""){
			document.fm1.pubInstEdYYYYPop.disabled = false;
			document.fm1.pubInstEdMMPop.disabled = false;
			document.fm1.pubInstEdDDPop.disabled = false;
		}else{
			document.fm1.pubInstEdYYYYPop.value = "";
			document.fm1.pubInstEdYYYYPop.disabled = true;
			document.fm1.pubInstEdMMPop.value = "";
			document.fm1.pubInstEdMMPop.disabled = true;
			document.fm1.pubInstEdDDPop.value = "";
			document.fm1.pubInstEdDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "3"){
		//2-3 公的機関役職
		const pubInstPositionCdPop = document.fm1.pubInstPositionCdPop.value;
		if(pubInstPositionCdPop != ""){
			document.fm1.pubInstposStYYYYPop.disabled = false;
			document.fm1.pubInstposStMMPop.disabled = false;
			document.fm1.pubInstposStDDPop.disabled = false;
		}else{
			document.fm1.pubInstposStYYYYPop.value = "";
			document.fm1.pubInstposStYYYYPop.disabled = true;
			document.fm1.pubInstposStMMPop.value = "";
			document.fm1.pubInstposStMMPop.disabled = true;
			document.fm1.pubInstposStDDPop.value = "";
			document.fm1.pubInstposStDDPop.disabled = true;
			document.fm1.pubInstposEdYYYYPop.value = "";
			document.fm1.pubInstposEdYYYYPop.disabled = true;
			document.fm1.pubInstposEdMMPop.value = "";
			document.fm1.pubInstposEdMMPop.disabled = true;
			document.fm1.pubInstposEdDDPop.value = "";
			document.fm1.pubInstposEdDDPop.disabled = true;
		}
	}
	if(changeItem == "0" || changeItem == "4"){
	    //2-4 公的機関役職開始年月日
		const pubInstposStYYYYPop = document.fm1.pubInstposStYYYYPop.value;
		const pubInstposStMMPop = document.fm1.pubInstposStMMPop.value;
		const pubInstposStDDPop = document.fm1.pubInstposStDDPop.value;
		if(pubInstposStYYYYPop != "" && pubInstposStMMPop != "" && pubInstposStDDPop != ""){
			document.fm1.pubInstposEdYYYYPop.disabled = false;
			document.fm1.pubInstposEdMMPop.disabled = false;
			document.fm1.pubInstposEdDDPop.disabled = false;
		}else{
			document.fm1.pubInstposEdYYYYPop.value = "";
			document.fm1.pubInstposEdYYYYPop.disabled = true;
			document.fm1.pubInstposEdMMPop.value = "";
			document.fm1.pubInstposEdMMPop.disabled = true;
			document.fm1.pubInstposEdDDPop.value = "";
			document.fm1.pubInstposEdDDPop.disabled = true;
		}
	}
}

/**
 * <pre>
 *  適用処理
 * DB操作処理時に呼ばれます。
 * </pre>
 */
function chpRegister(){
  // 確認メッセージ表示
  if (confirm("適用します。よろしいですか？")){
  } else {
    return false;
  }

  document.fm1.screenId.value = 'NC207';
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
function chpReturn(){
	//ボタン２度押し対策を、なるべく早いタイミングで行います。
	if(!comChkSubmit(COM_CLICK_ALERT))return(false);
	var hcpPublicDataChgFlg = document.fm1.hcpPublicDataChgFlg.value;
    var classCategoryCd = document.fm1.classCategoryCdPop.value;
    var classCategoryNm = document.fm1.classCategoryNmPop.value;
    var pubInstitutionCd = document.fm1.pubInstitutionCdPop.value;
    var pubInstitutionNm = document.fm1.pubInstitutionNmPop.value;
    var pubInstPositionCd = document.fm1.pubInstPositionCdPop.value;
    var pubInstPositionNm = document.fm1.pubInstPositionNmPop.value;
    var pubInstStYYYY = document.fm1.pubInstStYYYYPop.value;
    var pubInstStMM = document.fm1.pubInstStMMPop.value;
    var pubInstStDD = document.fm1.pubInstStDDPop.value;
    var pubInstEdYYYY = document.fm1.pubInstEdYYYYPop.value;
    var pubInstEdMM = document.fm1.pubInstEdMMPop.value;
    var pubInstEdDD = document.fm1.pubInstEdDDPop.value;
    var pubInstposStYYYY = document.fm1.pubInstposStYYYYPop.value;
    var pubInstposStMM = document.fm1.pubInstposStMMPop.value;
    var pubInstposStDD = document.fm1.pubInstposStDDPop.value;
    var pubInstposEdYYYY = document.fm1.pubInstposEdYYYYPop.value;
    var pubInstposEdMM = document.fm1.pubInstposEdMMPop.value;
    var pubInstposEdDD = document.fm1.pubInstposEdDDPop.value;

	//１件選択パターンの場合は、渡したい値をそのままコールバック関数に渡すことにする。
	eval("window.opener." + document.fm1.callBack.value + "(hcpPublicDataChgFlg,classCategoryCd,classCategoryNm,pubInstitutionCd,pubInstitutionNm,pubInstPositionCd,pubInstPositionNm,pubInstStYYYY,pubInstStMM,pubInstStDD,pubInstEdYYYY,pubInstEdMM,pubInstEdDD,pubInstposStYYYY,pubInstposStMM,pubInstposStDD,pubInstposEdYYYY,pubInstposEdMM,pubInstposEdDD)");

	chpClose();
	return(true);
}

/**
 * このウインドウを閉じるときに呼び出されます。
 * 単にウインドウを閉じます。
 */
function chpClose(){
	window.close();
}

function chpUnLoad(){
	try{
		eval("window.opener." + document.fm0.winVarName.value + "=null");
	}catch(err){
	}
}
