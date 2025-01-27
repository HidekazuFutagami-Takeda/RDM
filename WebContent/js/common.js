/**
 * <pre>
 * JavaScript共通関数
 * </pre>
 * @since 1.0
 * @version $Revision: 1.4 $
 * @author 
 */
//値チェック用
var COM_CHECK_NULL = "1";
var COM_CHECK_SINGLEBYTE = "2";
var COM_CHECK_NUMAPLHA = "3";
var COM_CHECK_DOUBLEBYTE = "4";
var COM_CHECK_NUMCAPALPHA = "5";
var COM_CHECK_NUMVALUE = "6";
var COM_CHECK_NUM = "7";
var COM_CHECK_DATE = "8";
var COM_CHECK_CHECKBOX = "9";
var COM_CHECK_LENGTH = "10";
var COM_CHECK_MAIL_ADDR = "11";
var COM_CHECK_NO_SIGN = "12";
var COM_CHECK_DECIMAL = "13";
var COM_CHECK_OVER = "14";
// add start K.Fujii 2003/02/23
var COM_CHECK_UNDER = "15";
// add end   K.Fujii 2003/02/23
var COM_CHECK_MAXBYTE = "16";

//ボタン２度押し対策用
var COM_CLICK_NOALERT = 0;	//メッセージを抑止します。
var COM_CLICK_ALERT   = 1;	//既に処理を開始しています。
var COM_CLICK_CONFIRM = 2;	//既に処理を開始しています。よろしいですか？

/**
 * アプリケーションIDを定義
 * window名等に利用します。
 */
var COM_APPLICATION_ID = "COM";

/**
 * ファンクションID
 */
var COM_FUNC_VIEWINIT	= "ViewInit";
var COM_FUNC_VIEW	  = "View";
var COM_FUNC_SEARCH 	= "Search";
var COM_FUNC_PAGENEXT	= "PageNext";
var COM_FUNC_PAGEBACK	= "PageBack";
var COM_FUNC_SORTASC	= "SortAsc";
var COM_FUNC_SORTASC1	= "SortAsc1";
var COM_FUNC_SORTASC2	= "SortAsc2";
var COM_FUNC_SORTASC3	= "SortAsc3";
var COM_FUNC_SORTASC4	= "SortAsc4";
var COM_FUNC_SORTASC5	= "SortAsc5";
var COM_FUNC_SORTASC6	= "SortAsc6";
var COM_FUNC_SORTDESC	= "SortDesc";
var COM_FUNC_SORTDESC1	  = "SortDesc1";
var COM_FUNC_SORTDESC2	  = "SortDesc2";
var COM_FUNC_SORTDESC3	  = "SortDesc3";
var COM_FUNC_SORTDESC4	  = "SortDesc4";
var COM_FUNC_SORTDESC5	  = "SortDesc5";
var COM_FUNC_SORTDESC6	  = "SortDesc6";
var COM_FUNC_REGISTERINIT = "RegisterInit";
var COM_FUNC_REGISTERDRAW = "RegisterDraw";
var COM_FUNC_REGISTER	= "Register";
var COM_FUNC_MODIFYINIT   = "ModifyInit";
var COM_FUNC_MODIFYDRAW   = "ModifyDraw";
var COM_FUNC_MODIFY 	= "Modify";
var COM_FUNC_ERASE		= "Erase";
var COM_FUNC_REFER		= "Refer";
var COM_FUNC_CONFIRM	= "Confirm";
var COM_FUNC_SEND	  = "Send";
var COM_FUNC_DOWNLOAD	= "DownLoad";

/**
 * リンク情報
 */
//M.Matsumoto 2003/07/28 Update Start
//var COM_HOMELINK   = "/pls/portal30/portal30.home";
var COM_HOMELINK   = "http://inteig01.takeda.co.jp/maps/servlet/control?screenId=Menu&functionId=ViewInit";
//M.Matsumoto 2003/07/28 Update End

/**
 * トップ画面 画面ＩＤおよび機能ＩＤ情報
 */
//M.Matsumoto 2003/08/04 Add Start
var COM_TOP_SCREENID     = "Menu";
var COM_TOP_FUNCTIONID   = "ViewInit";
//M.Matsumoto 2003/08/04 Add End

/**
 * 通信維持用
 * 10分間隔(600000)＊45回　セッションを１晩（１０時間）維持します
 */

//繰り返し回数
var COM_INTERVAL_CNT = 45;

//本番用実行間隔 １０分
var COM_INTERVAL_TIME = 600000;
//テスト用実行間隔 １分
//var COM_INTERVAL_TIME = 60000;
//var COM_INTERVAL_TIME = 5000;

var COM_INTERVALID = "";

//add start 2008/07/31 サーバ移行新旧サーバURL取得関数追加
/**
 * 旧サーバURL取得
 * @return 旧サーバURL
 */
function getOldServerActionUrl(){
  return "http://intiei01.takeda.co.jp/maps/servlet/control"
}
/**
 * 新サーバURL取得
 * @return 新サーバURL
 */
function getNewServerActionUrl(){
  return "http://inteig01.takeda.co.jp/maps/servlet/control"
}
//add end   2008/07/31 サーバ移行新旧サーバURL取得関数追加


/**
 * デバッグ用関数
 */
var gComDebug = false;
function comDebug(str){
  if(gComDebug) alert(str);
  return(true);
}

//add start 2009/03/09 H.Uchida oracle文字化け回避対応
/**
 * oracle文字化け回避文字列変換
 * 全角チェック時に利用する
 */
function replaceCode(argChkObj){
  //MINUS SIGN			>> FULLWIDTH TILDE
  argChkObj.value = argChkObj.value.split(String.fromCharCode(0x2212)).join(String.fromCharCode(0xff0d));
  //WAVE DASH				>> FULLWIDTH TILDE
  argChkObj.value = argChkObj.value.split(String.fromCharCode(0x301c)).join(String.fromCharCode(0xff5e));
  //DOUBLE VERTICAL LINE	>> PARALLEL TO
  argChkObj.value = argChkObj.value.split(String.fromCharCode(0x2016)).join(String.fromCharCode(0x2225));
  //CENT SIGN				>> FULLWIDTH CENT SIGN
  argChkObj.value = argChkObj.value.split(String.fromCharCode(0x00a2)).join(String.fromCharCode(0xffe0));
  //POUND SIGN			>> FULLWIDTH POUND SIGN
  argChkObj.value = argChkObj.value.split(String.fromCharCode(0x00a3)).join(String.fromCharCode(0xffe1));
  //NOT SIGN				>> FULLWIDTH NOT SIGN
  argChkObj.value = argChkObj.value.split(String.fromCharCode(0x00ac)).join(String.fromCharCode(0xffe2));
}
//add end 2009/03/09  oracle文字化け回避対応

/////////////////////////////////////////////////////////////////////////
// チェック済みチェック<br><br>
// オブジェクトがチェックされているかチェックする<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param objnum－(i) オブジェクトの数
// @return 論理型 チェックされている:true チェックされていない:false
/////////////////////////////////////////////////////////////////////////
function comChkChecked(item,obj,objnum) {
  var checkOk = false;

  //オブジェクトが１つしかないとき
  if (objnum == 1 ) {
    if (obj.checked) {
      checkOk = true;
    }
  } else {
    for(i=0; i< obj.length; i++){
      if (obj[i].checked) {
        checkOk = true;
        break;
      }
    }
  }
  if (!checkOk) {
    alert(item + ":  チェックされていません")
  }
  return checkOk;
}

/////////////////////////////////////////////////////////////////////////
// バイト数チェック<br><br>
// 入力された桁数を求めて、最大桁数以内かをチェックする。<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param max－(i) Maxバイト数
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkMaxByte(item,obj,max,fram){
  var toCheck = obj.value;
  var len=0;
  var i,a,b,c;
  //入力桁数算出
  if( navigator.appName.charAt(0) == "N" ) {
  // Netscape用処理
       return true;
    }
  else {
  // InternetExproler、その他用処理
    for (i=0; i<toCheck.length; i++) {
      a=escape(toCheck.charAt(i));
      b=a.charAt(1);
      if (b=="u") {
        c=a.substring(2,6);
// alert(c);
        if (! (c.toLowerCase() >= "ff60" && c.toLowerCase() <= "ff9f")) {  //半角カナ
          len++
        }
      }
      len++;
// alert(len);
    }
  }
  //最大桁数チェック
  if (len>max) {

    alert(item + ":  入力できる桁数は" + max + "桁です");
    fram.focus(); obj.focus();
    return false;
  }
  return true;
}

/////////////////////////////////////////////////////////////////////////
// 日付項目チェック<br><br>
// 日付項目の妥当性をチェックする<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkDateYMD(item,obj,fram){
  var j;
  var toCheck = obj.value;
  var isNum = true;
  var isSpace = true; 			//未入力を　true:チェックしない　false:チェックする
  var limitMinyyyy = 1970;		//４桁の場合の過去の年の制限
  var limitMaxyyyy = 2050;		//４桁の場合の未来の年の制限
  var limit2000 = 70; 			//２桁の場合の1900年代と2000年代の境目
  var SEPARATOR = "/" ;			//年月日を区切るセパレータ

  //まづ変換
  comChkDateEdit(obj)

  //未入力チェック
  if ((toCheck == null) || (toCheck == "")) {
    if (isSpace ) {
      return true;
    }
    else {
      alert(item + ":   値を入力してください");
      fram.focus(); obj.focus();
      return false;
    }
  }

  var strArray = new Array(4);
  strArray = comdivDateYMD(item,obj,fram);
  if (strArray[3] == "") {
    return false;
  }

  //年のチェック
  var yyyy = parseInt(strArray[0],10);
  if (strArray[0].length == 0) {
    alert(item + ":   年を設定してください");
    fram.focus(); obj.focus();
    return false;
  }
  if (strArray[0].length >= 4) {
    if ((limitMinyyyy > yyyy) || (limitMaxyyyy < yyyy)) {
      alert(item + ":   " +  limitMinyyyy + "以上、または" + limitMaxyyyy + "以下を設定してください");
      fram.focus(); obj.focus();
      return false;
    }
    var leapyyyy = yyyy;
  }
  if (strArray[0].length == 3) {
    if (yyyy > limit2000) {
      alert(item + ":   年の設定が不正です");
      fram.focus(); obj.focus();
      return false;
    }
    else {
      var leapyyyy = yyyy + 2000;
    }
  }
  if (strArray[0].length == 2) {
    if (yyyy < limit2000) {
      var leapyyyy = yyyy + 2000;
    }
    else {
      var leapyyyy = yyyy + 1900;
    }
  }
  if (strArray[0].length == 1) {
    var leapyyyy = yyyy + 2000;
  }

  //月の妥当性チェック
  var mm = parseInt(strArray[1],10);
  if (strArray[1].length == 0) {
    alert(item + ":   月を設定してください");
    fram.focus(); obj.focus();
    return false;
  }
  if ((mm < 1) || (mm > 12)) {
    alert(item + ":  月の設定が誤っています");
    fram.focus(); obj.focus();
    return false;
  }

  //日の妥当性チェック
  var dd = parseInt(strArray[2],10);
  if (strArray[2].length == 0) {
    alert(item + ":   日を設定してください");
    fram.focus(); obj.focus();
    return false;
  }
  if (dd == 0) {
    alert(item + ":   日の設定が誤っています");
    fram.focus(); obj.focus();
    return false;
  }
  if (mm == 2) {
    if (leapyyyy % 4 == 0 && leapyyyy % 100 != 0 || leapyyyy % 400 == 0) {
      if ( dd > 29) {
        alert(item + ":  日の設定が誤っています");
        fram.focus(); obj.focus();
        return false;
      }
    }
    else {
      if ( dd > 28) {
        alert(item + ":  日の設定が誤っています");
        fram.focus(); obj.focus();
        return false;
      }
    }
  }
  else {
    if (( mm == 4) ||
      ( mm == 6) ||
      ( mm == 9) ||
      ( mm == 11)) {
      if (dd > 30 ) {
        alert(item + ":  日の設定が誤っています");
        fram.focus(); obj.focus();
        return false;
      }
    }
    if (( mm == 1) ||
      ( mm == 3) ||
      ( mm == 5) ||
      ( mm == 7) ||
      ( mm == 8) ||
      ( mm == 10) ||
      ( mm == 12)) {
      if (dd > 31) {
        alert(item + ":  日の設定が誤っています");
        fram.focus(); obj.focus();
        return false;
      }
    }
  }
  if(!comformatDateYMD(item,obj)) {
    return false;
  }
  return true;
}

/////////////////////////////////////////////////////////////////////////
// 日付項目チェック（年月）<br><br>
// 日付項目の妥当性をチェックする（年月）<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkDateYM(item,obj,fram){
  var toCheck = obj.value;
  var toCheckRtn = obj.value;
  var isNum = true;
  var isSpace = true; 	   //未入力を　true:チェックしない　false:チェックする
  var limitMinyyyy = 1970;   //４桁の場合の過去の年の制限
  var limitMaxyyyy = 2050;   //４桁の場合の未来の年の制限
  var limit2000 = 70; 	   //２桁の場合の1900年代と2000年代の境目
  var SEPARATOR = "/" ;	   //年月日を区切るセパレータ

  //未入力チェック
  if ((toCheck == null) || (toCheck == "")) {
    if (isSpace) {
      return true;
    }
    else {
      alert(item + ":   値を入力してください");
      fram.focus(); obj.focus();
      return false;
    }
  }

  var strArray = new Array(3);
  strArray = comdivDateYM(item,obj,fram);
  if (strArray[2] == "") {
    return false;
  }
  //年のチェック
  var yyyy = parseInt(strArray[0],10);
  if (strArray[0].length == 0) {
    alert(item + ":   年を設定してください");
    fram.focus(); obj.focus();
    return false;
  }
  if (strArray[0].length >= 4) {
    if ((limitMinyyyy > yyyy) || (limitMaxyyyy < yyyy)) {
      alert(item + ":   " +  limitMinyyyy + "以上、または" + limitMaxyyyy + "以下を設定してください");
      fram.focus(); obj.focus();
      return false;
    }
    var leapyyyy = yyyy;
  }
  if (strArray[0].length == 3) {
    if (yyyy > limit2000) {
      alert(item + ":   年の設定が不正です");
      fram.focus(); obj.focus();
      return false;
    }
    else {
      var leapyyyy = yyyy + 2000;
    }
  }
  if (strArray[0].length == 2) {
    if (yyyy < limit2000) {
      var leapyyyy = yyyy + 2000;
    }
    else {
      var leapyyyy = yyyy + 1900;
    }
  }
  if (strArray[0].length == 1) {
    var leapyyyy = yyyy + 2000;
  }

  //月の妥当性チェック
  var mm = parseInt(strArray[1],10);
  if (strArray[1].length == 0) {
    alert(item + ":   月を設定してください");
    fram.focus(); obj.focus();
    return false;
  }
  if ((mm < 1) || (mm > 12)) {
    alert(item + ":  月の設定が誤っています");
    fram.focus(); obj.focus();
    return false;
  }
  if(!comformatDateYM(item,obj)) {
    return false;
  }
  return true;
}

/////////////////////////////////////////////////////////////////////////
// 日付項目大小チェック（年月日）<br><br>
// 日付項目の大小チェックを行う。（年月日）<br>
//
// @param fromitem－(i) FROM項目名称
// @param fromobj －(i) FROMINPUTタグのオブジェクト
// @param toitem  －(i) TO項目名称
// @param toobj   －(i) TOINPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkFromToYMD(fromitem,fromobj,toitem,toobj,fram){
  var toCheck = fromobj.value;
  var toCheck1 = toobj.value;
  var SEPARATOR = "/";	//年月日を区切るセパレータ

  //TOが未入力の場合、チェックしない。
  if ((toCheck1 == "") || (toCheck1 == null)){
    return true;
  }
  var strArray = new Array(4);
  strArray = comdivDateYMD(fromitem,fromobj,fram);
  if (strArray[3] == "") {
    return false;
  }
  var strArray1 = new Array(4);
  strArray1 = comdivDateYMD(toitem,toobj,fram);
  if (strArray1[3] == "") {
    return false;
  }

  //年の大小チェック
  var yyyy = parseInt(strArray[0],10);
  var yyyy1 = parseInt(strArray1[0],10);
  if (yyyy > yyyy1) {
    alert(toitem + ":  日付の大小関係に誤りがあります");
    fram.focus(); toobj.focus();
    return false;
  }
  if (yyyy < yyyy1) {
    return true;
  }

  //月の大小チェック
  var mm = parseInt(strArray[1],10);
  var mm1 = parseInt(strArray1[1],10);
  if (mm > mm1)  {
    alert(toitem + ":  日付の大小関係に誤りがあります");
    fram.focus(); toobj.focus();
    return false;
  }
  if (mm < mm1) {
    return true;
  }

  //日の大小チェック
  var dd = parseInt(strArray[2],10);
  var dd1 = parseInt(strArray1[2],10);
  if (dd > dd1)  {
    alert(toitem + ":  日付の大小関係に誤りがあります");
    fram.focus(); toobj.focus();
    return false;
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// 日付項目大小チェック（年月）<br><br>
// 日付項目の大小チェックする（年月）<br>
//
// @param fromitem－(i) FROM項目名称
// @param fromobj －(i) FROMINPUTタグのオブジェクト
// @param toitem  －(i) TO項目名称
// @param toobj   －(i) TOINPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkFromToYM(fromitem,fromobj,toitem,toobj,fram){
  var toCheck = fromobj.value;
  var toCheck1 = toobj.value;
  var SEPARATOR = "/" ;	 //年月日を区切るセパレータ
  //TOが未入力の場合、チェックしない。
  if ((toCheck1 == "") || (toCheck1 == null)){
    return true;
  }
  var strArray = new Array(3);
  strArray = comdivDateYM(fromitem,fromobj,fram);
  if (strArray[2] == "") {
    return false;
  }
  var strArray1 = new Array(3);
  strArray1 = comdivDateYM(toitem,toobj,fram);
  if (strArray1[2] == "") {
    return false;
  }
  //年のチェック
  var yyyy = parseInt(strArray[0],10);
  var yyyy1 = parseInt(strArray1[0],10);
  if (yyyy > yyyy1) {
    alert(toitem + ":  日付の大小関係に誤りがあります");
    fram.focus(); toobj.focus();
    return false;
  }
  if (yyyy < yyyy1) {
    return true;
  }
  //月のチェック
  var mm = parseInt(strArray[1],10);
  var mm1 = parseInt(strArray1[1],10);
  if (mm > mm1)  {
    alert(toitem + ":  日付の大小関係に誤りがあります");
    fram.focus(); toobj.focus();
    return false;
  }
  return true;
}

/////////////////////////////////////////////////////////////////////////
// 郵便番号チェック<br><br>
// 文字列が郵便番号として適切かチェック<br>
//
// @param string－(i) 文字列
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkPostcode( item, obj ,fram ){
  var ret;

  //未入力チェック
  if ((obj.value == null) || (obj.value == "")) {
    return true;
  }

  // IEの場合
  if(navigator.appName == "Microsoft Internet Explorer"){
    ret = comChkPostcode_IE(obj.value);
  // Netscapeの場合
  }else{
    ret = comChkPostcode_NC(obj.value);
  }

  if(ret==false){
    alert(item + ":   郵便番号が間違っています");
    fram.focus(); obj.focus();
    return false;
  }

  if (!comChkMaxByte(item,obj,8,fram)) {
    return false;
  }
  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＩＥ用郵便番号チェック<br><br>
// 文字列が郵便番号として適切かチェック<br>
//
// @param string－(i) 文字列
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkPostcode_IE( String ){
  var i;
  var Letter;

  for( i = 0; i < String.length; i++ ){
    Letter = String.charAt(i);
    if(i == 3) {
      if(Letter!="-"){
        return false;
      }
    } else {
      if(Letter < "0" || Letter > "9"){
        return false;
      }
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用郵便番号チェック<br><br>
// 文字列が郵便番号として適切かチェック<br>
//
// @param string－(i) 文字列
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkPostcode_NC( String ){
  var i;
  var Letter;

  for( i = 0; i < String.length; i++ ){
    Letter = comKcharAt(String, i);
    if(i == 3) {
      if(Letter!="-"){
        return false;
      }
    } else {
      if(Letter < "0" || Letter > "9"){
        return false;
      }
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// 電話番号チェック<br><br>
// 文字列が電話番号として適切かチェック<br>
//
// @param string－(i) 文字列
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkTelNo( item, obj ,fram ){
  var ret;

  //未入力チェック
  if ((obj.value == null) || (obj.value == "")) {
    return true;
  }

  // IEの場合
  if(navigator.appName == "Microsoft Internet Explorer"){
    ret = comChkTelNo_IE(obj.value);
  // Netscapeの場合
  }else{
    ret = comChkTelNo_NC(obj.value);
  }

  if(ret==false){
    alert(item + ":   電話番号が間違っています");
    fram.focus(); obj.focus();
    return false;
  }

  if (!comChkMaxByte(item,obj,14,fram)) {
    return false;
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＩＥ用電話番号チェック<br><br>
// 文字列が電話番号として適切かチェック<br>
//
// @param string－(i) 文字列
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkTelNo_IE( String ){
  var i;
  var Letter;

  if (String.charAt(0) != "0")
    return false;
  for( i = 1; i < String.length; i++ ){
    Letter = String.charAt(i);
    if((Letter!="-") && (Letter < "0" || Letter > "9")){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用電話番号チェック<br><br>
// 文字列が電話番号として適切かチェック<br>
//
// @param string－(i) 文字列
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkTelNo_NC( String ){
  var i;
  var Letter;

  if (comKcharAt(String, 0) != "0")
    return false;
  for( i=1; i < String.length; i++ ){
    Letter = comKcharAt(String, i);
    if((Letter!="-") && (Letter < "0" || Letter > "9")){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// 半角カナ文字チェック<br><br>
// objの値の妥当性をチェックする<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 半角カナ無し:true 半角カナ有り:false
/////////////////////////////////////////////////////////////////////////
function comChkKana( item, obj ,fram ){
  var ret;

  // IEの場合
  if(navigator.appName == "Microsoft Internet Explorer"){
    ret = comChkKana_IE(obj.value);
  // Netscapeの場合
  }else{
    ret = comChkKana_NC(obj.value);
  }

  if(ret==false){
    alert(item + ":   半角カナは入力できません");
    fram.focus(); obj.focus();
    return false;
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＩＥ用半角カナ文字判定<br><br>
// 文字列の中の半角カナ文字を探す<br>
//
// @param string－(i) 文字列
// @return 論理型 半角カナ無し:true 半角カナ有り:false
/////////////////////////////////////////////////////////////////////////
function comChkKana_IE( String ){
  var i;
  var Letter;

  for( i = 0; i < String.length; i++ ){
    Letter = String.charAt(i);
    if(Letter >= "｡" && Letter <= "ﾟ"){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用半角カナ文字判定<br><br>
// 文字列の中の半角カナ文字を探す<br>
//
// @param string－(i) 文字列
// @return 論理型 半角カナ無し:true 半角カナ有り:false
/////////////////////////////////////////////////////////////////////////
function comChkKana_NC( String ){
  var i;
  var Letter;

  for( i=0; i < String.length; i++ ){
    Letter = comKcharAt(String, i);
    if(Letter >= "｡" && Letter <= "ﾟ"){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// 英数のみチェック<br><br>
// objの値の妥当性をチェックする<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkENNOMI( item, obj ,fram ){
  var ret;

  //未入力チェック
  if ((obj.value == null) || (obj.value == "")) {
    return true;
  }

  // IEの場合
  if(navigator.appName == "Microsoft Internet Explorer"){
    ret = comChkENNOMI_IE(obj.value);
  // Netscapeの場合
  }else{
    ret = comChkENNOMI_NC(obj.value);
  }

  if(ret==false){
    alert(item + ":   英数以外は入力できません");
    fram.focus(); obj.focus();
    return false;
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＩＥ用英数判定<br><br>
// 文字列の中に英数大文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkENNOMI_IE( String ){
  var i;
  var Letter;

  for( i = 0; i < String.length; i++ ){
    Letter = String.charAt(i);
    if((Letter < "A" || Letter > "Z") && (Letter < "0" || Letter > "9") && (Letter < "a" || Letter > "z")){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用英数判定<br><br>
// 文字列の中に英数大文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkENNOMI_NC( String ){
  var i;
  var Letter;

  for( i=0; i < String.length; i++ ){
    Letter = comKcharAt(String, i);
    if((Letter < "A" || Letter > "Z") && (Letter < "0" || Letter > "9") && (Letter < "a" || Letter > "z")){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＥＤＩ可能文字チェック<br><br>
// 文字列の中にＥＤＩ使用不可文字がないか調べる<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkEDI(item,obj,fram){
  if(comChkZen(obj.value)==false){
    alert(item + ":  英数小文字、全角文字は入力できません");
    fram.focus(); obj.focus();
    return false;
  }
  if(comChkDAI(obj.value)==false){
    alert(item + ":  英数小文字、全角文字は入力できません");
    fram.focus(); obj.focus();
    return false;
  }
  return true;
}

/////////////////////////////////////////////////////////////////////////
// 英数大文字不可チェック<br><br>
// 文字列の中に英数大文字がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkDAI(str){

  var i;
  var Letter;

  for( i = 0; i < str.length; i++ ){
    Letter = str.charAt(i);
    if(Letter >= "a" && Letter <= "z"){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ２バイト文字不可チェック<br><br>
// 文字列の中に２バイト文字がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 ２バイト文字無し:true ２バイト文字有り:false
/////////////////////////////////////////////////////////////////////////
function comChkZen(str){

  var i;
  var moji;
  var len;
  var re;
  var ver;

  len = comStrLen(str);

  if (navigator.appName == "Microsoft Internet Explorer") {
    for (i = 0; i < len; i++) {
      moji = comGetCharAt(str, i);
      if ((moji < "　" && moji != '\n' && moji != '\r') == false) {
        return false;
      }
    }
  } else {
    ver = navigator.appVersion;
    re = new RegExp("4.7","i");
    if(ver.search(re) == -1){
      for (i = 0; i < len; i++) {
        moji = comGetCharAt(str, i);
        if (((moji < "　" || moji.length == 1) && moji != '\n' && moji != '\r') == false) {
          return false;
        }
      }
    }else{
      for (i = 0; i < len; i++) {
        moji = comGetCharAt(str, i);
        if ((moji < "　" && moji != '\n' && moji != '\r') == false) {
          return false;
        }
      }
    }
  }
  return true;
}
function comStrLen(str){
  var i;
  var len;
  var moji;
  var xmoji;
  var i;
  if (navigator.appName == "Microsoft Internet Explorer") {
    return (str.length);
  } else {
    len = 0;
      for (i = 0; i < str.length; i++) {
        moji = escape(str.charAt(i));
        xmoji = eval("0x" + moji.charAt(1));
        if ((xmoji == 8) || (xmoji == 9) || (xmoji == 14) || (xmoji == 15)) {
          i++;
        }
        len++;
      }
    return (len);
  }
}
function comGetCharAt(str, pos){
  var i;
  var len;
  var moji;
  var emoji;
  var xmoji;

  if (navigator.appName == "Microsoft Internet Explorer") {
    return (str.charAt(pos));
  } else {
    len = 0;
    for (i = 0; i < str.length; i++) {
      moji = str.charAt(i);
      emoji = escape(moji);
      xmoji = eval("0x" + emoji.charAt(1));
      if ((xmoji == 8) || (xmoji == 9) || (xmoji == 14) || (xmoji == 15)) {
        moji = moji + str.charAt(i + 1);
        i++;
      }
      if (pos == len) {
        break;
      }
      len++;
    }
    return (moji);
  }
}

/////////////////////////////////////////////////////////////////////////
// 英数大文字チェック<br><br>
// objの値の妥当性をチェックする<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUDAI( item, obj ,fram ){
  var ret;

  //未入力チェック
  if ((obj.value == null) || (obj.value == "")) {
    return true;
  }

  // IEの場合
  if(navigator.appName == "Microsoft Internet Explorer"){
    ret = comChkEISUUDAI_IE(obj.value);
  // Netscapeの場合
  }else{
    ret = comChkEISUUDAI_NC(obj.value);
  }

  if(ret==false){
    alert(item + ":   英数大文字記号以外は入力できません");
    fram.focus(); obj.focus();
    return false;
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＩＥ用英数大文字判定<br><br>
// 文字列の中に英数大文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUDAI_IE( String ){
  var i;
  var Letter;

  for( i = 0; i < String.length; i++ ){
    Letter = String.charAt(i);
    if	  ((Letter < "A" || Letter > "Z")
       &&  (Letter < "0" || Letter > "9")
       && ((Letter == "!") || (Letter == '"') || (Letter == "#") || (Letter == "$") || (Letter == "%")
      || (Letter == "&") || (Letter == "'") || (Letter == "(") || (Letter == ")") || (Letter == "*")
      || (Letter == "+") || (Letter == ",") || (Letter == "-") || (Letter == ".") || (Letter == "/")
      || (Letter == ":") || (Letter == ";") || (Letter == "<") || (Letter == "=") || (Letter == ">")
      || (Letter == "?") || (Letter == "@") || (Letter == "[") || (Letter == "~") || (Letter == "]")
      || (Letter == "^") || (Letter == "_") || (Letter == "`") || (Letter == "{") || (Letter == "|")
      || (Letter == "}") || (Letter == "\\") || (Letter == " ")) == false){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用英数大文字判定<br><br>
// 文字列の中に英数大文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUDAI_NC( String ){
  var i;
  var Letter;

  for( i=0; i < String.length; i++ ){
    Letter = comKcharAt(String, i);
    if	  ((Letter < "A" || Letter > "Z")
       &&  (Letter < "0" || Letter > "9")
       && ((Letter == "!") || (Letter == '"') || (Letter == "#") || (Letter == "$") || (Letter == "%")
      || (Letter == "&") || (Letter == "'") || (Letter == "(") || (Letter == ")") || (Letter == "*")
      || (Letter == "+") || (Letter == ",") || (Letter == "-") || (Letter == ".") || (Letter == "/")
      || (Letter == ":") || (Letter == ";") || (Letter == "<") || (Letter == "=") || (Letter == ">")
      || (Letter == "?") || (Letter == "@") || (Letter == "[") || (Letter == "~") || (Letter == "]")
      || (Letter == "^") || (Letter == "_") || (Letter == "`") || (Letter == "{") || (Letter == "|")
      || (Letter == "}") || (Letter == "\\") || (Letter == " ")) == false){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// 英数大文字チェック（記号不可）<br><br>
// objの値の妥当性をチェックする<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUDAI2( item, obj ,fram ){
  var ret;

  //未入力チェック
  if ((obj.value == null) || (obj.value == "")) {
    return true;
  }

  // IEの場合
  if(navigator.appName == "Microsoft Internet Explorer"){
    ret = comChkEISUUDAI2_IE(obj.value);
  // Netscapeの場合
  }else{
    ret = comChkEISUUDAI2_NC(obj.value);
  }

  if(ret==false){
    alert(item + ":   英数大文字以外は入力できません");
    fram.focus(); obj.focus();
    return false;
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＩＥ用英数大文字判定（記号不可）<br><br>
// 文字列の中に英数大文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUDAI2_IE( String ){
  var i;
  var Letter;

  for( i = 0; i < String.length; i++ ){
    Letter = String.charAt(i);
    if	(((Letter >= "A" && Letter <= "Z") || (Letter >= "0" && Letter <= "9"))  == false){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用英数大文字判定（記号不可）<br><br>
// 文字列の中に英数大文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数大文字:true 英数大文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUDAI2_NC( String ){
  var i;
  var Letter;

  for( i=0; i < String.length; i++ ){
    Letter = comKcharAt(String, i);
    if	(((Letter >= "A" && Letter <= "Z") || (Letter >= "0" && Letter <= "9"))  == false){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// 英数小文字チェック<br><br>
// objの値の妥当性をチェックする<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 英数小文字:true 英数小文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUSHOU( item, obj ,fram ){
  var ret;

  //未入力チェック
  if ((obj.value == null) || (obj.value == "")) {
    return true;
  }

  // IEの場合
  if(navigator.appName == "Microsoft Internet Explorer"){
    ret = comChkEISUUSHOU_IE(obj.value);
  // Netscapeの場合
  }else{
    ret = comChkEISUUSHOU_NC(obj.value);
  }

  if(ret==false){
    alert(item + ":   英数小文字記号以外は入力できません");
    fram.focus(); obj.focus();
    return false;
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＩＥ用英数小文字判定<br><br>
// 文字列の中に英数小文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数小文字:true 英数小文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUSHOU_IE( String ){
  var i;
  var Letter;

  for( i = 0; i < String.length; i++ ){
    Letter = String.charAt(i);
    if	  ((Letter < "a" || Letter > "z")
       &&  (Letter < "0" || Letter > "9")
       && ((Letter == "!") || (Letter == '"') || (Letter == "#") || (Letter == "$") || (Letter == "%")
      || (Letter == "&") || (Letter == "'") || (Letter == "(") || (Letter == ")") || (Letter == "*")
      || (Letter == "+") || (Letter == ",") || (Letter == "-") || (Letter == ".") || (Letter == "/")
      || (Letter == ":") || (Letter == ";") || (Letter == "<") || (Letter == "=") || (Letter == ">")
      || (Letter == "?") || (Letter == "@") || (Letter == "[") || (Letter == "~") || (Letter == "]")
      || (Letter == "^") || (Letter == "_") || (Letter == "`") || (Letter == "{") || (Letter == "|")
      || (Letter == "}") || (Letter == "\\") || (Letter == " ")) == false){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用英数小文字判定<br><br>
// 文字列の中に英数小文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数小文字:true 英数小文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUSHOU_NC( String ){
  var i;
  var Letter;

  for( i=0; i < String.length; i++ ){
    Letter = comKcharAt(String, i);
    if	  ((Letter < "a" || Letter > "z")
       &&  (Letter < "0" || Letter > "9")
       && ((Letter == "!") || (Letter == '"') || (Letter == "#") || (Letter == "$") || (Letter == "%")
      || (Letter == "&") || (Letter == "'") || (Letter == "(") || (Letter == ")") || (Letter == "*")
      || (Letter == "+") || (Letter == ",") || (Letter == "-") || (Letter == ".") || (Letter == "/")
      || (Letter == ":") || (Letter == ";") || (Letter == "<") || (Letter == "=") || (Letter == ">")
      || (Letter == "?") || (Letter == "@") || (Letter == "[") || (Letter == "~") || (Letter == "]")
      || (Letter == "^") || (Letter == "_") || (Letter == "`") || (Letter == "{") || (Letter == "|")
      || (Letter == "}") || (Letter == "\\") || (Letter == " ")) == false){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// 英数小文字チェック（記号不可）<br><br>
// objの値の妥当性をチェックする<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 英数小文字:true 英数小文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUSHOU2( item, obj ,fram ){
  var ret;

  //未入力チェック
  if ((obj.value == null) || (obj.value == "")) {
    return true;
  }

  // IEの場合
  if(navigator.appName == "Microsoft Internet Explorer"){
    ret = comChkEISUUSHOU2_IE(obj.value);
  // Netscapeの場合
  }else{
    ret = comChkEISUUSHOU2_NC(obj.value);
  }

  if(ret==false){
    alert(item + ":   英数小文字以外は入力できません");
    fram.focus(); obj.focus();
    return false;
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＩＥ用英数小文字判定（記号不可）<br><br>
// 文字列の中に英数小文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数小文字:true 英数小文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUSHOU2_IE( String ){
  var i;
  var Letter;

  for( i = 0; i < String.length; i++ ){
    Letter = String.charAt(i);
    if	(((Letter >= "A" && Letter <= "Z") || (Letter >= "0" && Letter <= "9"))  == false){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用英数小文字判定（記号不可）<br><br>
// 文字列の中に英数小文字以外がないか調べる<br>
//
// @param string－(i) 文字列
// @return 論理型 英数小文字:true 英数小文字以外有り:false
/////////////////////////////////////////////////////////////////////////
function comChkEISUUSHOU2_NC( String ){
  var i;
  var Letter;

  for( i=0; i < String.length; i++ ){
    Letter = comKcharAt(String, i);
    if	(((Letter >= "A" && Letter <= "Z") || (Letter >= "0" && Letter <= "9"))  == false){
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// 日付のフォーマット（年月日）<br><br>
// 日付項目をフォーマットする(YYYY/MM/DD)<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comformatDateYMD(item,obj,fram) {
  var toCheck = obj.value;
  var SEPARATOR = "/";	//年月日を区切るセパレータ

  var strArray = new Array(4);
  strArray = comdivDateYMD(item,obj,fram);
  if (strArray[3] == "") {
    return false;
  }
  var yyyy = parseInt(strArray[0],10);
  var mm = parseInt(strArray[1],10);
  var dd = parseInt(strArray[2],10);
  if (yyyy < 100) {
    if (yyyy < 70) {
      if (yyyy < 10) {
//				if (yyyy != "0000") {
          yyyy = "200" + yyyy;
//				}
      }
      else {
        yyyy = "20" + yyyy;
      }
    }
    else {
      if (yyyy < 10) {
        yyyy = "190" + yyyy;
      }
      else {
        yyyy = "19" + yyyy;
      }
    }
  }
  if (mm < 10) {
      mm = "0" + mm;
  }
  if (dd < 10) {
      dd = "0" + dd;
  }
  if (yyyy == 0) {
    obj.value = "0000" + SEPARATOR + mm + SEPARATOR + dd;
  }
  else {
    obj.value = yyyy + SEPARATOR + mm + SEPARATOR + dd;
  }
  return true;
}

/////////////////////////////////////////////////////////////////////////
// 日付のフォーマット（年月）<br><br>
// 日付項目をフォーマットする。(YYYY/MM)<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comformatDateYM(item,obj,fram) {
  var toCheck = obj.value;
  var SEPARATOR = "/";	//年月を区切るセパレータ
  var strArray = new Array(3);
  strArray = comdivDateYM(item,obj,fram);
  if (strArray[2] == "") {
    return false;
  }
  var yyyy = parseInt(strArray[0],10);
  var mm = parseInt(strArray[1],10);
  if (yyyy < 100) {
    if (yyyy < 70) {
      if (yyyy < 10) {
        yyyy = "200" + yyyy;
      }
      else {
        yyyy = "20" + yyyy;
      }
    }
    else {
      if (yyyy < 10) {
        yyyy = "190" + yyyy;
      }
      else {
        yyyy = "19" + yyyy;
      }
    }
  }
  if (mm < 10) {
      mm = "0" + mm;
  }
    obj.value = yyyy + SEPARATOR + mm;
    return true;
}

/////////////////////////////////////////////////////////////////////////
// 日付のフォーマット（年）<br><br>
// 日付項目をフォーマットする。(YYYY)<br>
//
// @param obj－(i) INPUTタグのオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comformatDateY(obj) {
  var toCheck = obj.value;
  if ((isNaN(toCheck.substr(0,1)) == false) && (isNaN(toCheck.substr(1,1)) == false) &&
    (isNaN(toCheck.substr(2,1)) == false) && (isNaN(toCheck.substr(3,1)) == false)
    && toCheck.substr(0,1) != " " && toCheck.substr(1,1) != " "
    && toCheck.substr(2,1) != " " && toCheck.substr(3,1) != " "){
    if (toCheck.length == 2 ) {
      var yyyy= parseInt(toCheck,10);
      if (yyyy > 70) {
        yyyy = "19" + obj.value;
      }else{
        yyyy = "20" + obj.value;
      }
      obj.value = yyyy;
      return true;
    }
    return true;
  }
  return false;
}

/////////////////////////////////////////////////////////////////////////
// 年月日分割<br><br>
// 年月日分割を行う。（年月日）<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 分割された年月日
/////////////////////////////////////////////////////////////////////////
function comdivDateYMD(item,obj,fram){
  var toCheck = obj.value;
  var isNum = true;
  var SEPARATOR = "/" ;			//年月日を区切るセパレータ
  var j;

  var strArray = new Array(4);
  strArray[0] = "";
  strArray[1] = "";
  strArray[2] = "";
  strArray[3] = "";		   //チェックフラグ

  //数値及びセパレータチェック
  var sepaCnt = 0;
  for (j = 0; j < toCheck.length; j++) {
    if ((toCheck.substring(j,j+1) < "0") ||
      (toCheck.substring(j,j+1) > "9")) {
      if ( toCheck.substring(j,j+1) == SEPARATOR) {
        sepaCnt++;
      }
      else {
        isNum = false;
      }
    }
  }

  if (!isNum) {
    alert(item + ":  日付の部分は数値で入力してください");
    fram.focus(); obj.focus();
    return strArray;
  }
  if (sepaCnt != 2 && sepaCnt != 0) {
    alert(item + ":   形式が誤っています");
    fram.focus(); obj.focus();
    return strArray;
  }

  if (sepaCnt == 2) {
    strArray = toCheck.split(SEPARATOR);
    if (strArray.length == 2) {
      strArray[2] = "";
    }
    strArray[3] = "1";		 //チェックフラグ
  }
  else {
    if (toCheck.length == 8) {
      strArray[0] = toCheck.substring(0,4);
      strArray[1] = toCheck.substring(4,6);
      strArray[2] = toCheck.substring(6,8);
      strArray[3] = "1";	 //チェックフラグ
    }
    else {
      alert(item + ":   形式が誤っています");
      fram.focus(); obj.focus();
      return strArray;
    }
  }

  return strArray;
}

/////////////////////////////////////////////////////////////////////////
// 年月分割<br><br>
// 年月分割を行う。（年月）<br>
//
// @param item－(i) 項目名称
// @param obj－(i) INPUTタグのオブジェクト
// @param fram－(i) フレームオブジェクト
// @return 分割された年月日
/////////////////////////////////////////////////////////////////////////
function comdivDateYM(item,obj,fram){
  var toCheck = obj.value;
  var isNum = true;
  var SEPARATOR = "/" ;			//年月日を区切るセパレータ
  var j;

  var strArray = new Array(3);
  strArray[0] = "";
  strArray[1] = "";
  strArray[2] = "";		   //チェックフラグ

  //数値及びセパレータチェック
  var sepaCnt = 0;
  for (j = 0; j < toCheck.length; j++) {
    if ((toCheck.substring(j,j+1) < "0") ||
      (toCheck.substring(j,j+1) > "9")) {
      if ( toCheck.substring(j,j+1) == SEPARATOR) {
        sepaCnt++;
      }
      else {
        isNum = false;
      }
    }
  }

  if (!isNum) {
    alert(item + ":  日付の部分は数値で入力してください");
    fram.focus(); obj.focus();
    return strArray;
  }
  if (sepaCnt != 1 && sepaCnt != 0) {
    alert(item + ":   形式が誤っています");
    fram.focus(); obj.focus();
    return strArray;
  }

  if (sepaCnt == 1) {
    strArray = toCheck.split(SEPARATOR);
    if (strArray.length == 1) {
      strArray[1] = "";
    }
    strArray[2] = "1";			//チェックフラグ
  }
  else {
    if (toCheck.length == 6) {
      strArray[0] = toCheck.substring(0,4);
      strArray[1] = toCheck.substring(4,6);
      strArray[2] = "1";			//チェックフラグ
    }
    else if (toCheck.length == 4) {
      strArray[0] = toCheck.substring(0,2);
      if (strArray[0] < "70") {
        strArray[0] = "20" + strArray[0];
      }
      else {
        strArray[0] = "19" + strArray[0];
      }
      strArray[1] = toCheck.substring(2,4);
      strArray[2] = "1";			//チェックフラグ
    }
    else {
      alert(item + ":   形式が誤っています");
      fram.focus(); obj.focus();
      return strArray;
    }
  }

  return strArray;
}

/////////////////////////////////////////////////////////////////////////
// 日付項目スラッシュ編集<br><br>
// 日付項目の妥当性をチェックする<br>
//
// @param obj－(i) INPUTタグのオブジェクト
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comChkDateEdit(obj){
  var toCheck = obj.value;
  var isNum = true;
  var SEPARATOR = "/" ;			//年月日を区切るセパレータ
  var j;

  //数値及びセパレータチェック
  var sepaCnt = 0;
  for (j = 0; j < toCheck.length; j++) {
    if ((toCheck.substring(j,j+1) < "0") ||
      (toCheck.substring(j,j+1) > "9")) {
      if ( toCheck.substring(j,j+1) == SEPARATOR) {
        sepaCnt++;
      }
      else {
        isNum = false;
      }
    }
  }

  //数値以外あり
  if (!isNum) {
    return false;
  }
  //セパレータの数間違い
  if (sepaCnt != 2 && sepaCnt != 0) {
    return false;
  }

  //セパレータ２つ
  if (sepaCnt == 2) {
    if (toCheck.length == 8) {
      var strArray = toCheck.split(SEPARATOR);

      // yy/mm/dd形式のものは、yyyy/mm/dd形式に変換
      if (strArray[0].length == 2 && strArray[1].length == 2 && strArray[2].length == 2) {
        if (strArray[0] < "70") {
          strArray[0] = "20" + strArray[0];
        }
        else {
          strArray[0] = "19" + strArray[0];
        }
        obj.value = strArray[0] + SEPARATOR + strArray[1] + SEPARATOR + strArray[2];

        return true;
      }
      // セパレータの区切り方、間違い
      else {
      return false;
      }
    }
    //１０桁はそのまま
    else if (toCheck.length == 10) {
      return true;
    }
    //桁間違い
    else {
      return false;
    }
  }
  //セパレータなし
  else {
    //６桁は前２文字を西暦下２桁として、スラッシュ編集
    if (toCheck.length == 6) {
      var strArray = new Array(3);
      strArray[0] = toCheck.substring(0,2);
      strArray[1] = toCheck.substring(2,4);
      strArray[2] = toCheck.substring(4,6);
      if (strArray[0] < "70") {
        strArray[0] = "20" + strArray[0];
      }
      else {
        strArray[0] = "19" + strArray[0];
      }
      obj.value = strArray[0] + SEPARATOR + strArray[1] + SEPARATOR + strArray[2];

      return true;
    }
    //８桁はyyyy/mm/dd形式に編集
    else if (toCheck.length == 8) {
      var strArray = new Array(3);
      strArray[0] = toCheck.substring(0,4);
      strArray[1] = toCheck.substring(4,6);
      strArray[2] = toCheck.substring(6,8);
      obj.value = strArray[0] + SEPARATOR + strArray[1] + SEPARATOR + strArray[2];

      return true;
    }
    //桁間違い
    else {
      return false;
    }
  }

  return true;
}

/////////////////////////////////////////////////////////////////////////
// サブ画面呼び出し
//
// @param url－(i) ＵＲＬ
// @param strText－(i) ブラウザへの引数
// @return 論理型 正常:true エラー:false
/////////////////////////////////////////////////////////////////////////
function comCallWindow(name,url,strText,wid,hit){
  var w01;
  if (wid==0 && hit==0){
    w01 = window.open(url ,name, "scrollbars=yes,toolbar=no,resizable=yes,hotkeys=no");
  }else{
    w01 = window.open(url ,name, "width=wid,height=hit,scrollbars=yes,toolbar=no,resizable=yes,hotkeys=no");
  }
//	  w01.focus();
  return true;
}

/////////////////////////////////////////////////////////////////////////
// 値設定<br><br>
// オブジェクトの値を設定する<br>
//
// @param obj－(i) INPUTタグのオブジェクト
// @param setvalue－(i) 設定する値
/////////////////////////////////////////////////////////////////////////
function comSetValue(obj,setvalue) {
  obj.value = setvalue;
}

/////////////////////////////////////////////////////////////////////////
// ＮＣ用指定文字取得
//
// @param string－(i) 文字列
// @param position－(i) 指定位置
// @return 演算結果
/////////////////////////////////////////////////////////////////////////
function comKcharAt( String, Position ){
  var Length;
  var i;
  var CutString;
  var Letter, LetterBin;

  Length = 0;
  for( i = 0; i < String.length; i++ ){
    CutString = String.charAt(i);
    Letter = escape( CutString );
    LetterBin = eval( "0x" + Letter.charAt(1) );
    if( (LetterBin == 8) || (LetterBin == 9) || (LetterBin == 14) || (LetterBin == 15) ){
      CutString = CutString + String.charAt( i + 1 );
      i++;
    }
    if( Position == Length ){
      break;
    }
    Length++;
  }

  return CutString;
}

/**
 * <pre>
 * GETメソッドで受け取ったパラメタを名前指定で取得します。
 * </pre>
 * @author 日立
 * @param param パラメタの名前を指定します。
 * @return String - 取得した文字列を戻します。
 * @since 1.0
 */
function comGetParameter(param){
  /* URLから変数の取得 */
  // search :"?KEY=CGI"
  var value1 = "";
  var search = window.location.search;
  comDebug("search=["+search+"]");
  //exp = new RegExp("^[?&]"+param+"=([\w%\+*])");
  //CGIパラメタ部分を正規表現で取得します。(複数あったら1つ目を取ります。)
  //[]内の-ハイフンは最後にするべし
  //また、本来はURLデコードが必要だが...
  //gフラグを複数ヒットしたものを配列で返す。iフラグは大文字小文字を区別しない。mフラグはマルチラインを検索
  //exp = new RegExp("[?&]([a-zA-Z0-9.*_+%-]+)=([a-zA-Z0-9.*_+%-]*)","g");
  exp = new RegExp("[?&]"+param+"=([a-zA-Z0-9.*_+%-]*)"); //gフラグはやめ取り敢えず１つだけとる
  var ret = search.match(exp);
  if(ret != null){
  comDebug("length=["+ret.length+"]");
  comDebug("ret=["+ret+"]");
  value1 = RegExp.$1;   //パラメタの値を取得
  comDebug("value1=["+value1+"]");
  //var value2 = RegExp.$2;
  //comDebug("value2=["+value2+"]");
  //var value3 = unescape(value1);  //URLdecodeは無理unicodeとSJIS変換をする必要あり(AppletでURLdecoderを使う?)
  //comDebug("value3=["+value3+"]");
  }
  else{
  comDebug("ないよ ret=["+ret+"]");
  }
  return value1;
}
/**
 * <pre>
 * ドキュメントのパス名を取得します。
 * Popup画面呼び出し時にServletのパス名を取得するのに利用します。
 * </pre>
 */
function comGetLocationPath(w){
  // protocol :"http:"
  // host   :"www.yyy.zzz:8000"
  // hostname :"www.yyy.zzz"
  // port   :"8000"
  // pathname :"/maps/servlet/control"
  // search :"?KEY=CGI"
  // hash   :"#XYZ"
  return( w.location.protocol + "//" + w.location.host + w.location.pathname );
}
/**
 * <pre>
 * ドキュメントルート呼び出し用の文字列を取得します。
 * "http://localhost:8080"といった文字列です。最後に"/"はつけません。
 * </pre>
 */
function comGetRootLocation(w){
  // protocol :"http:"
  // host   :"www.yyy.zzz:8000"
  // hostname :"www.yyy.zzz"
  // port   :"8000"
  // pathname :"/maps/servlet/control"
  // search :"?KEY=CGI"
  // hash   :"#XYZ"
  return( w.location.protocol + "//" + w.location.host );
}
/**
 * <pre>
 * アプリケーションコンテキストのドキュメントルート呼び出し用の文字列を取得します。
 * "http://localhost:8080/maps"といった文字列です。最後に"/"はつけません。
 * 静的Popup画面呼び出し時にドキュメントのパス名を取得するのに利用します。
 * </pre>
 */
function comGetApplicationLocation(w){
  // protocol :"http:"
  // host   :"www.yyy.zzz:8000"
  // hostname :"www.yyy.zzz"
  // port   :"8000"
  // pathname :"/maps/servlet/control"
  // search :"?KEY=CGI"
  // hash   :"#XYZ"
  var appContext = w.location.pathname.match(/^\/[A-Za-z0-9]+/);
  return( w.location.protocol + "//" + w.location.host + appContext );
}
/**
 * <pre>
 * 指定された値がUri形式かどうかを判定します。
 * 文字列の先頭がhttp://、https://、ftp://、telnet://、file://、ldap://で以降に一文字以上
 * 文字があればOKとします。
 * "javascirpt:"は取り敢えず対象外
 * </pre>
 * @param uri チェックしたい文字列を指定します。
 * @return boolean - チェック結果を返します。true:URI形式 false:URI形式でない
 */
function comChkUri(uri){
  if(uri.match(/^(http|https|ftp|telnet|file|ldap):\/\/[\w\/]+/)	){
  return(true);
  }
  return(false);
}

/**
 * <pre>
 * Popup画面を開く際に指定されたメソッド(Get|Post)で処理をリクエストします。
 * メソッドはcomPostPopup,comGetPopupのラッパ関数で処理します。
 * </pre>
 * @param method リクエスト時のメソッドを受け取ります。
 * @param w Popup画面のwindowオブジェクトを受け取ります。
 * @param uri Popup画面のuriを指定します。nullや""を指定した場合は親ウインドウのpathを使用します。
 * @param screenId Popup画面のscreenIdを指定します。
 * @param functionId Popup画面のfunctionIdを指定します。
 * @param callBack1 親画面のcallBack関数を指定します。
 * @param winVarName1 親画面で保持する子画面オブジェクト管理変数の名前を指定します。
 * @param jokenName Popup画面を起動する際の条件となるパラメタの名前を1次元配列で指定します。
 * @param joken パラメタの値を2次元配列で指定します。
 * @param bSoeji パラメタの名前に1からの連番を付けるかどうかをbooleanで指定します。
 *		  true:連番を付ける false:連番を付けない
 *		  連番を付けた場合は、Servlet側でgetParameter("abc1")で取得する。
 *		  連番を付けない場合は、getParameterValues("abc")でString[]で取得する。
 * @author 日立
 * @since 1.0
 */
function comPostPopup(w,uri,screenId,functionId,callBack,winVarName,jokenName,joken,bSoeji){
  //POSTメソッドを指定します。
  comOpenPopup("POST",w,uri,screenId,functionId,callBack,winVarName,jokenName,joken,bSoeji);
}
function comGetPopup(w,uri,screenId,functionId,callBack,winVarName,jokenName,joken,bSoeji){
  //GETメソッドを指定します。
  comOpenPopup("GET",w,uri,screenId,functionId,callBack,winVarName,jokenName,joken,bSoeji);
}
function comOpenPopup(method,w,uri,screenId,functionId,callBack,winVarName,jokenName,joken,bSoeji){
  if(bSoeji == null){
  bSoeji = true;
  }

  //※注意※
  //formが画面に表示されますが、リリース時にはstyle="visibility:hidden"を利用するよう変更します。
  //class="comHidden"はcommon.cssを読み込まないので利用しません。
  //また、下のalertもリリース時にはコメントする必要があります。
  var metaTag = "";

  metaTag = "<meta content=\"text/html;charset=UTF-8\" http-equiv=\"Content-Type\" />";

  var writeStr =""
  //+ "<html>"
  + metaTag
  + "<form style=\"visibility:hidden\" name=\"fm0\" action=\"" + uri + "\" method=\""+method+"\">"
  + "screenId :<input type=\"text\" name=\"screenId\" value=\"" + screenId + "\"></input><br/>"
  + "functionId :<input type=\"text\" name=\"functionId\" value=\"" + functionId + "\"></input><br/>"
  + "windowName :<input type=\"text\" name=\"windowName\" value=\"" + w.name + "\"></input><br/>"
  + "openerName :<input type=\"text\" name=\"openerName\" value=\"" + w.opener.name + "\"></input><br/>"
  + "callBack :<input type=\"text\" name=\"callBack\" value=\"" + callBack + "\"></input><br/>"
  + "winVarName :<input type=\"text\" name=\"winVarName\" value=\"" + winVarName + "\"></input><br/>";

  //検索条件などが存在する場合は、配列を展開してinputタグを生成する。
  //その際、name属性は、joken1,joken2,joken3...となる。
  var soeji = "";
  var charset = "";
  charset = " document.charset='UTF-8';";
  if(jokenName != null){
    for(i=0;i<jokenName.length;i++){
      for(j=0;j<joken[i].length;j++){
      if(bSoeji)	soeji = j + 1;
      writeStr += jokenName[i] + soeji + ":<input type=\"text\" name=\"" + jokenName[i] + soeji + "\" value=\"" + joken[i][j] + "\"></input><br/>";
      }
    }
  }
  writeStr +=""
  //★alert(writeStr);
  + "comDummy :<input type=\"hidden\" name=\"comDummy\" value=\"\"></input><br/>"
  + "</form>"
  + "<script language=\"javascript\">"
  + charset
  + " document.fm0.submit();"
  + "</script>";


  w.document.open();
  w.document.write(writeStr);
}

//add start 2008/12/18 T.Saino Vista対応
/**
 * <pre>
 * OSの情報を取得します。
 * </pre>
 */
function getOSVersion() {
  var str_agent      = navigator.userAgent;
  var str_apname     = str_agent.substr(0, str_agent.indexOf('/'));
  str_agent      = str_agent.substr(str_agent.indexOf('/') + 1);
  var str_apver      = str_agent.substr(0, str_agent.indexOf('('));
  str_agent      = str_agent.substr(str_agent.indexOf('(') + 1);
  var str_compatible = str_agent.substr(0, str_agent.indexOf(';'));
  str_agent      = str_agent.substr(str_agent.indexOf(';') + 1);
  var str_ver        = str_agent.substr(0, str_agent.indexOf(';'));
  str_agent      = str_agent.substr(str_agent.indexOf(';') + 1);
  var str_osver = str_agent;
  if (str_agent.indexOf(';') > 0) {
    str_osver = str_agent.substr(0, str_agent.indexOf(';'));
  }
  return str_osver;
}
//add end 2008/12/18 T.Saino Vista対応

/**
 * <pre>
 * オブジェクトのvisibility属性を変更しオブジェクトを表示します。
 * 例)	<img src="a.gif" OnMouseOver="comVShow('aaa')" />
 *	  <span id="aaa">表示非表示</span>
 *	  <img class="comComment" src="./img/pubviews.gif" onMouseOver="this.id='hover';comVShow('cmt5');" onMouseOut="comVHide('cmt5');"></img>
 *	  <div class="comComment" id="cmt5">
 *		<ul class="comComment">
 *		  <li class="comComment">
 *			<nobr>了解しました。</nobr>
 *		  </li>
 *		</ul>
 *	  </div>
 * </pre>
 * @param id オブジェクトのidを受け取ります。
 * @author 日立
 * @since 1.0
 */
function comVShow(id) {
  if (document.all) {
  document.all.item(id).style.visibility = "visible";
  }
  if (document.layers) {
  document.layers[id].visibility = "show";
  }
}
/**
 * <pre>
 * オブジェクトのvisibility属性を変更しオブジェクトを非表示にします。
 * </pre>
 * @param id オブジェクトのidを受け取ります。
 * @author 日立
 * @since 1.0
 */
function comVHide(id) {
  if (document.all) {
  document.all.item(id).style.visibility = "hidden";
  }
  if (document.layers) {
  document.layers[id].visibility = "hide";
  }
}
/**
 * <pre>
 * 現在日付をyyyymmddhhmissmsの形式で戻します。
 * ie4以上(getFullYearが)
 * </pre>
 * @return String - 現在日付時刻のyyyymmddhhmissms文字列
 * @author 日立
 * @since 1.0
 */
function comGetFullDateString() {
  date = new Date();
  var yyyy  = date.getFullYear();
  var mm	  = date.getMonth()+1;
  var dd	  = date.getDate();
  var hh	  = date.getHours();
  var mi	  = date.getMinutes();
  var ss	  = date.getSeconds();
  var ms	  = date.getMilliseconds();
  if(mm < 10) mm = "0" + mm;
  if(dd < 10) dd = "0" + dd;
  if(hh < 10) hh = "0" + hh;
  if(mi < 10) mi = "0" + mi;
  if(ss < 10) ss = "0" + ss;
  if(ms < 10) ms = "00" + ms;
  else if(ms < 100) ms = "0" + ms;
  return ""+yyyy+mm+dd+hh+mi+ss+ms;
  //alert("FullDate=[" + dateString + "]");
}
/**
 * <pre>
 * windowの名前を付けます。(ユニークになるように現在日時を付加します。)
 * 戻り値でwindow名を戻しますが、実際には指定されたwindowに名前を付けてしまいます。
 * windowの名前はservlet側でsessionに格納するオブジェクトの頭にに自動的に付加されます。
 * window名の規則  _+アプリケーションID(大文字)+現在日時
 * この関数は、あらゆるドキュメントのOnLoadイベントで使用します。
 * ※iframe等フレームの場合はどうなるか要検証
 * </pre>
 * @param win 名前を付けるwindowオブジェクトを指定します。
 * @param prefix 名前の先頭文字を指定します。(通常はアプリケーションID3桁 ex:IDR:大文字)
 * @return String - windowの名前
 * @author 日立
 * @since 1.0
 */
function comSetWindowName(win,prefix) {
  if(win == null) return;
  //ウィンドウに名前がついていない場合だけ名前をつける。
  //１回名前を付けたらsessionをその名前とsessionクッキーで判別するため
//Modify start 2009/04/28 M.Terui
  try{
    if(win.name == "" || win.name == null){
    win.name = comCreateWindowName(prefix);
    }
    return win.name;
  }catch(e){
    //アクセスが拒否されましたのエラーが出たら何もしない。
    if(e.number != -2147024891){
      throw e;
    }
  }
//Modify end 2009/04/28 M.Terui
}
/**
 * <pre>
 * windowの名前を生成します。
 * </pre>
 * @see comSetWindowName(win,prefix)
 * @param prefix 名前の先頭文字を指定します。(通常はアプリケーションID3桁 ex:IDR:大文字)
 * @return String - windowの名前
 * @author 日立
 * @since 1.0
 */
function comCreateWindowName(prefix) {
  return "_" + prefix.toUpperCase() + comGetFullDateString();
}
/********************************************************************/
/*	処理名　　　：　入力チェック関数				*/
/*	パラメータ　：　制御配列、対象オブジェクト配列			*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　エラーメッセージ				*/
/*	　　　　　　：　（正常時はNULL）				*/
/********************************************************************/
function comChkValue(argArrayInfo,argArrayObj){
  var splited_string;
  var item_string;
  var mesg = "";

  for (var i = 0; i < argArrayInfo.length; i++){
    item_string = argArrayInfo[i];
    splited_string = item_string.split(";");
    for (var j = 1; j < splited_string.length; j++){
      if (splited_string[j] == ""){
      break;
      }
      splited_string_sub = splited_string[j].split("/");
      if (splited_string_sub[0] == COM_CHECK_NULL){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkNull(argArrayObj[i].value)){
          if (mesg == ""){
            mesg = splited_string[0] + "は必須項目です";
            if (argArrayObj[i].type != "hidden"){
              argArrayObj[i].focus();
            }
          }
          else{
            mesg = mesg + "\n" + splited_string[0] + "は必須項目です";
          }
          }
        }
//add start 2007/02/08 M.Hoshino
        // selectbox対応
        else if( argArrayObj[i].type == "select-one" ){
          // 選択されているインデックスの取得
          var n = argArrayObj[i].selectedIndex;
          if (!comChkNull(argArrayObj[i].options[n].text) ||
            !comChkNull(argArrayObj[i].options[n].value)
          ){
            if (mesg == ""){
              mesg = splited_string[0] + "は必須項目です";
              argArrayObj[i].focus();
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "は必須項目です";
            }
          }
        }
//add end 2007/02/08 M.Hoshino
      }
      else if (splited_string_sub[0] == COM_CHECK_SINGLEBYTE){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkSingleByte(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "に全角入力はできません";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "に全角入力はできません";
            }
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_NUMAPLHA){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkNumAlpha(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "には半角英数字しか入力できません";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "には半角英数字しか入力できません";
            }
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_DOUBLEBYTE){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkDoubleByte(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "に半角入力はできません";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "に半角入力はできません";
            }
          }

          //add 2009/03/09 H.Uchida oracle文字化け回避対応
          replaceCode(argArrayObj[i]);

        }
      }
      else if (splited_string_sub[0] == COM_CHECK_NUMCAPALPHA){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkNumCapalpha(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "は数字、または大文字英字のみ入力可能です";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "は数字、または大文字英字のみ入力可能です";
            }
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_NUMVALUE){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkNumValue(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "は数値として妥当ではありません";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "は数値として妥当ではありません";
            }
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_NUM){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkNum(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "は数字のみ入力可能です";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "は数字のみ入力可能です";
            }
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_DATE){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkDate(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "は日付として妥当ではありません";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "は日付として妥当ではありません";
            }
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_CHECKBOX){
        if (!comChkChkBox(argArrayObj[i])){
          if (mesg == ""){
            mesg = splited_string[0] + "のうち１つ以上選択して下さい";
          }
          else{
            mesg = mesg + "\n" + splited_string[0] + "のうち１つ以上選択して下さい";
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_LENGTH){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          var len_num = comChkLength(argArrayObj[i],splited_string_sub[1]);
          if (len_num){
            if (mesg == ""){
//							mesg = splited_string[0] + "は" + len_num + "バイト以内で入力して下さい";
              mesg = splited_string[0] + "の制限字数を越えています";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "の制限字数を越えています";
//							mesg = mesg + "\n" + splited_string[0] + "は" + len_num + "バイト以内で入力して下さい";
            }
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_MAIL_ADDR){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "hidden"){
          if (!comChkMailAddress(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "はメールアドレスとして不正です";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "はメールアドレスとして不正です";
            }
          }
        }
      }
      else if (splited_string_sub[0] == COM_CHECK_NO_SIGN){
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if (!comChkNoSign(argArrayObj[i].value)){
            if (mesg == ""){
              mesg = splited_string[0] + "には記号は入力できません";
              if (argArrayObj[i].type != "hidden"){
                argArrayObj[i].focus();
              }
            }
            else{
              mesg = mesg + "\n" + splited_string[0] + "には記号は入力できません";
            }
          }
        }
      }else if (splited_string_sub[0] == COM_CHECK_DECIMAL) {
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "hidden"){
          if(!comChkDecimal(argArrayObj[i].value,splited_string_sub[1])){
            if (mesg == ""){
              mesg = splited_string[0] + "の値が不正です。";
              if (argArrayObj[i].type != "hidden") {
                argArrayObj[i].focus();
              }
            }else{
              mesg = mesg + "\n" + splited_string[0] + "の値が不正です。";
            }
          }
        }
      }else if (splited_string_sub[0] == COM_CHECK_OVER) {
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "hidden"){
          if(!comChkOver(argArrayObj[i].value,splited_string_sub[1])){
            if (mesg == ""){
              mesg = splited_string[0] + "の値が不正です。";
              if (argArrayObj[i].type != "hidden") {
                argArrayObj[i].focus();
              }
            }else{
              mesg = mesg + "\n" + splited_string[0] + "の値が不正です。";
            }
          }
        }
      // add start K.Fujii 2003/02/23
      }else if (splited_string_sub[0] == COM_CHECK_UNDER) {
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "hidden"){
          if(!comChkUnder(argArrayObj[i].value,splited_string_sub[1])){
            if (mesg == ""){
              mesg = splited_string[0] + "の値が不正です。";
              if (argArrayObj[i].type != "hidden") {
                argArrayObj[i].focus();
              }
            }else{
              mesg = mesg + "\n" + splited_string[0] + "の値が不正です。";
            }
          }
        }
      // add end   K.Fujii 2003/02/23
      }else if (splited_string_sub[0] == COM_CHECK_MAXBYTE) {
        if (argArrayObj[i].type == "text" || argArrayObj[i].type == "textarea" || argArrayObj[i].type == "hidden"){
          if(!comChkMaxCharByte(argArrayObj[i].value,splited_string_sub[1])){
            if (mesg == ""){
//modify start	Y.Yamada 2004/2/16
              mesg = splited_string[0] +  "は" + splited_string_sub[1] + "文字（半角）以内で入力して下さい";
//							mesg = splited_string[0] +  "は" + splited_string_sub[1] + "バイト以内で入力して下さい";
//modify end	Y.Yamada 2004/2/16
              if (argArrayObj[i].type != "hidden") {
                argArrayObj[i].focus();
              }
            }else{
//modify start	Y.Yamada 2004/2/16
              mesg = mesg + "\n" + splited_string[0] +  "は" + splited_string_sub[1] + "文字（半角）以内で入力して下さい";
//							mesg = mesg + "\n" + splited_string[0] +  "は" + splited_string_sub[1] + "バイト以内で入力して下さい";
//modify end	Y.Yamada 2004/2/16
            }
          }
        }
      }
    }
  }
  return mesg;
}

/********************************************************************/
/*	処理名　　　：　必須チェック関数				*/
/*	パラメータ　：　フィールドのvalue				*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - NULL以外				*/
/*	　　　　　　：　false - NULL				  */
/********************************************************************/
function comChkNull(val){
  for (i = 0; i < val.length; i++){
    if (val.substr(i,1) != " " && val.substr(i,1) != "　"){
      break;
    }
  }

  if (i ==  val.length){
    return false;
  }
  if (val == ""){
    return false;
  }
  return true;
}

/********************************************************************/
/*	処理名　　　：　半角チェック関数				*/
/*	パラメータ　：　フィールドのvalue				*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - 全角文字なし			  */
/*	　　　　　　：　false - 全角文字あり			  */
/********************************************************************/
function comChkSingleByte(str){
  if (str == ""){
    return true;
  }
  for ( var vCnt = 0; vCnt < str.length; vCnt++ ){
    var vCode = str.charCodeAt(vCnt);
    if( (vCode < 0x20) || (vCode > 0xff9f) ||
       ((vCode > 0x7e) && (vCode < 0xff61))){
      return false;
    }
  }
  return true;
}

/********************************************************************/
/*	処理名　　　：　半角英数字チェック関数				*/
/*	パラメータ　：　フィールドのvalue				*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - 半角英数字以外なし			  */
/*	　　　　　　：　false - 半角英数字以外あり			  */
/********************************************************************/
function comChkNumAlpha(str){
  if (str == ""){
    return true;
  }
  for ( var vCnt = 0; vCnt < str.length; vCnt++ ){
    var vCode = str.charCodeAt(vCnt);
    if(!(((vCode >= 0x41) && (vCode <= 0x5a)) ||
      ((vCode >= 0x61) && (vCode <= 0x7a)) ||
      ((vCode >= 0x30) && (vCode <= 0x39)))){
      return false;
    }
  }
  return true;
}

/********************************************************************/
/*	処理名　　　：　全角チェック関数				*/
/*	パラメータ　：　フィールドのvalue				*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - 全角以外の文字なし			  */
/*	　　　　　　：　false - 全角以外の文字あり			  */
/********************************************************************/
function comChkDoubleByte(str){
  if (str == ""){
    return true;
  }
  for ( var vCnt = 0; vCnt < str.length; vCnt++ ){
    var vCode = str.charCodeAt(vCnt);
//		if(((vCode >= 0x20) && (vCode <= 0x7e)) ||	-- 制御文字（0x00～0x20,0x7f）もチェック対象に追加 2009/03/09 H.Uchida
    if(((vCode >= 0x00) && (vCode <= 0x7f)) ||
       ((vCode >= 0xff61) && (vCode <= 0xff9f))){
      return false;
    }
  }
  return true;
}

/********************************************************************/
/*	処理名　　　：　数字・英大文字チェック関数			  */
/*	パラメータ　：　フィールドのvalue				*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - 数字・英大文字以外の文字なし	  */
/*	　　　　　　：　false - 数字・英大文字以外の文字あり	  */
/********************************************************************/
function comChkNumCapalpha(str){
  if (str == ""){
    return true;
  }
  for ( vCnt = 0; vCnt < str.length; vCnt++ ){
    vCode = str.charCodeAt(vCnt);
    if(!(((vCode >= 0x30) && (vCode <= 0x39))||
       ((vCode >= 0x41) && (vCode <= 0x5a)))){
      return false;
    }
  }
  return true;
}

/********************************************************************/
/*	処理名　　　：　数値チェック関数				*/
/*	パラメータ　：　フィールドのvalue				*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - 不適切な数値なし			*/
/*	　　　　　　：　false - 不適切な数値あり			*/
/*	注意　　　　：　数値としての妥当性（マイナス、カンマ含む）を  */
/*	　　　　　　：　評価するので、数字かどうかをチェックするには  */
/*	　　　　　　：　comChkNumを使用すること 			*/
/********************************************************************/
function comChkNumValue(str){
  if (str == ""){
    return true;
  }
  for ( vCnt = 0; vCnt < str.length; vCnt++ ){
    vCode = str.charCodeAt(vCnt);
    if(!(((vCode >= 0x30) && (vCode <= 0x39))||
       (vCode == 0x2c)||
       (vCode == 0x2d)||
       (vCode == 0x2e))){
      return false;
    }
  }
  if ( str.search("-") != -1 ){
  /* マイナス符号は先頭以外は不可とする */
  if ( str.substr(0,1) != "-" ){
    return false;
  }
  var vWkstr1 = str.substr(1);
  }
  else{
  var vWkstr1 = str;
  }
  /* 小数点がある場合、整数部と小数部をともにチェック */
  if ( vWkstr1.search("\\.") != -1 ){
  var vWkstr2 = vWkstr1.split(".");
  /* 小数点が２つ以上ある場合はエラー */
  if ( vWkstr2.length > 2 ){
    return false;
  }
  var vWkstr3 = vWkstr2[0];
  /* 整数部がNULLならエラー */
  if ( vWkstr3 == "" ){
    return false;
  }
  var vWkstr4 = vWkstr2[1];
  /* 整数部に数字以外があればエラー */
  if ( vWkstr4 == "" ){
    return false;
  }
  if ( vWkstr4.search("[^0-9]") != -1 ){
    return false;
  }
  }
  else{
  var vWkstr3 = vWkstr1;
  }
  /* カンマがある場合、その位置の妥当性をチェック */
  if ( vWkstr3.search(",") != -1 ){
  vWkstr2 = vWkstr3.split(",");
  if ( vWkstr2[0].length < 1 ){
    return false;
  }
  if ( vWkstr2[0].length > 3 ){
    return false;
  }
  var vCnt = 0;
  for ( vCnt = 1; vCnt < vWkstr2.length; vCnt++ ){
    if ( vWkstr2[vCnt].length != 3 ){
      return false;
    }
  }
  }
  return true;
}

/********************************************************************/
/*	処理名　　　：　数字チェック関数				*/
/*	パラメータ　：　フィールドのvalue				*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - 数字以外の文字なし			  */
/*	　　　　　　：　false - 数字以外の文字あり			  */
/********************************************************************/
function comChkNum(str){
  if (str == ""){
    return true;
  }
  for ( vCnt = 0; vCnt < str.length; vCnt++ ){
    vCode = str.charCodeAt(vCnt);
    if(!((vCode >= 0x30) && (vCode <= 0x39))){
      return false;
    }
  }
  return true;
}

/********************************************************************/
/*	処理名　　　：　日付チェック関数				*/
/*	パラメータ　：　フィールドのvalue				*/
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - 不適切な日付なし			*/
/*	　　　　　　：　false - 不適切な日付あり			*/
/********************************************************************/
function comChkDate(str){
  if (str == ""){
    return true;
  }
  /* フォーマットは編集なしかスラッシュ編集しか認めない */
  for ( vCnt = 0; vCnt < str.length; vCnt++ ){
    vCode = str.charCodeAt(vCnt);
    if(!(((vCode >= 0x30) && (vCode <= 0x39)) ||
       (vCode == 0x2f))){
      return false;
    }
  }
  var vYear = "";
  var vMonth = "";
  var vDay = "";
  var vOrgDate = str.split("/");
  /* フォーマットが編集なしかスラッシュ編集以外の場合はエラー */
  if ( vOrgDate.length != 1 && vOrgDate.length != 3 ){
    return false;
  }
  if ( vOrgDate.length == 1 && str.length != 6 && str.length != 8){
    return false;
  }
  /* スラッシュ編集での年部または編集なしのデータを取得 */
  var vWkbuff = vOrgDate[0];
  /* 編集なし(YYYYMMDD)とみなし年月日を取得 */
  if ( vWkbuff.length == 8 ){
    vYear = vWkbuff.substr(0,4);
    vMonth = vWkbuff.substr(4,2);
    vDay = vWkbuff.substr(6,2);
  }
  /* 編集なし(YYMMDD)とみなし年月日を取得 */
  else if ( vWkbuff.length == 6 ){
    if ( vWkbuff.substr(0,2) > "50" ){
      vYear = "19" + vWkbuff.substr(0,2);
    }
    else{
      vYear = "20" + vWkbuff.substr(0,2);
    }
    vMonth = vWkbuff.substr(2,2);
    vDay = vWkbuff.substr(4,2);
  }
  /* スラッシュ編集(YYYY/MM/DD)とみなし年月日を取得 */
  else if ( vWkbuff.length == 4 ){
  vYear = vWkbuff;
  vWkbuff = vOrgDate[1];
  if ( vWkbuff.length != 2 ){
    return false;
  }
  vMonth = vWkbuff;
  vWkbuff = vOrgDate[2];
  if ( vWkbuff.length != 2 ){
    return false;
  }
  vDay = vWkbuff;
  }
  /* スラッシュ編集(YY/MM/DD)とみなし年月日を取得 */
  else if ( vWkbuff.length == 2 ){
  if ( vWkbuff > "50" ){
    vYear = "19" + vWkbuff;
  }
  else{
    vYear = "20" + vWkbuff;
  }
  vWkbuff = vOrgDate[1];
  if ( vWkbuff.length != 2 ){
    return false;
  }
  vMonth = vWkbuff;
  vWkbuff = vOrgDate[2];
  if ( vWkbuff.length != 2 ){
    return false;
  }
    vDay = vWkbuff;
  }
  else{
    return false;
  }
  /* 月のチェック */
  if ( vMonth > "12" || vMonth < "01" ){
    return false;
  }
  /* 日付（大の月）のチェック */
  if ( vMonth == "01" || vMonth == "03" || vMonth == "05" || vMonth == "07" || vMonth == "08" || vMonth == "10" || vMonth == "12" ){
    if ( vDay < "01" || vDay > "31" ){
      return false;
    }
  }
  else if ( vMonth != "02" ){
  /* 日付（小の月）のチェック */
    if ( vDay < "01" || vDay > "30" ){
      return false;
    }
  }
  else{
    /* 日付（２月）のチェック */
    var vUru = "";
    if ( parseInt(vYear) % 4 == 0 ){
      if ( parseInt(vYear) % 100 == 0 ){
        if ( parseInt(vYear) % 400 == 0 ){
          vUru = "1";
        }
      }
      else{
        vUru = "1";
      }
    }
    if ( vUru == "1" ){
      if ( vDay < "01" || vDay > "29" ){
      return false;
      }
    }
    else{
      if ( vDay < "01" || vDay > "28" ){
        return false;
      }
    }
  }
  return true;
}

/********************************************************************/
/*	処理名　　　：　チェックボックス選択チェック関数		*/
/*	パラメータ　：　チェックボックスオブジェクト		  */
/*	作成者　　　：　玉城(2001.11.07)				*/
/*	戻り値　　　：　true  - １つ以上checkedである		  */
/*	　　　　　　：　false - checkedが存在しない 		  */
/*	注意　　　　：　当関数は複数のチェックボックスが同名で定義されて*/
/*	　　　　　　：　いる事を前提に作成されている		  */
/********************************************************************/
function comChkChkBox(obj){
  for ( vCnt = 0; vCnt < obj.length; vCnt++ ){
    if (obj[vCnt].checked){
      return true;
    }
  }
  return false;
}
/********************************************************************/
/*	処理名　　　：　レングスチェック関数			  */
/*	パラメータ　：　TEXTまたはTEXTAREAオブジェクト			*/
/*	　　　　　　：　許可する最大レングス(TEXTAREAの場合のみ）	*/
/*	作成者　　　：　玉城(2001.11.10)				*/
/*	戻り値　　　：　0  - 属性で指定されているレングス以下の入力   */
/*	　　　　　　：　0以外の数値 - MAXLENGTHの値 		  */
/********************************************************************/
function comChkLength(obj,num_length){
  var str = obj.value;
  if (obj.type == "text"){
    if (obj.maxLength > 1000000){
      return 0;
    }
    else if (str.length > obj.maxLength){
      return obj.maxLength;
    }
  }
  else{
    if (comJlStrLen(str) > num_length){
      return num_length;
    }
  }
  return 0;
}
/********************************************************************/
/*	処理名　　　：　レングス判定関数				*/
/*	パラメータ　：　文字列						*/
/*	作成者　　　：　玉城(2001.11.10)				*/
/*	戻り値　　　：　INパラメータのバイト数				*/
/********************************************************************/
function comJlStrLen(str) {
   len = 0;
   str = escape(str);
   for (i = 0; i < str.length; i++, len++) {
    if (str.charAt(i) == "%") {
     if (str.charAt(++i) == "u") {
      i += 3;
      len++;
     }
     i++;
    }
   }
   return len;
}
/********************************************************************/
/*	処理名　　　：　メールアドレスチェック関数			  */
/*	パラメータ　：　文字列						*/
/*	作成者　　　：　玉城(2001.11.10)				*/
/*	戻り値　　　：　true  - メールアドレスとして適切な文字列	*/
/*	　　　　　　：　false - メールアドレスとして不適切な文字列	  */
/********************************************************************/
function comChkMailAddress(str)
{
  check = /.+@.+\..+/;
  if (!str.match(check)){
    return false;
  }
  return true;
}
/********************************************************************/
/*	処理名　　　：　記号なしチェック関数								*/
/*	パラメータ　：　文字列											*/
/*	作成者　　　：　玉城(2001.11.10)								*/
/*	修正者　　　：　坂井(2002.02.06) 使用しない記号を指定				*/
/*	戻り値　　　：　true  - 記号なし								*/
/*	　　　　　　：　false - 記号あり								*/
/********************************************************************/
function comChkNoSign(str)
{
  if (str == ""){
    return true;
  }
  for ( vCnt = 0; vCnt < str.length; vCnt++ ){
    vCode = str.charCodeAt(vCnt);

/* comment-out 2002/2/6 N.Sakai

    if(!(((vCode >= 0x41) && (vCode <= 0x5a)) ||
      ((vCode >= 0x61) && (vCode <= 0x7a)) ||
      ((vCode >= 0x30) && (vCode <= 0x39)))){
      if(((vCode >= 0x20) && (vCode <= 0x7e)) ||
         ((vCode >= 0xff61) && (vCode <= 0xff9f))){
        if (str.substr(vCnt,1) != " "){
        if (str.substr(vCnt,1) < "ｱ" || str.substr(vCnt,1) > "ﾝ") {
          if (str.substr(vCnt,1) != "ﾞ" && str.substr(vCnt,1) != "ﾟ") {
              return false;
          }
        }
        }
      }
    }

*/

// add start 2002/2/6 N.Sakai
    if (
      vCode == 0x22 || // " add 2004/01/27 チェック対象に含める
      vCode == 0x5c || // \ add 2004/01/27 チェック対象に含める
      vCode == 0x21 || // !
      vCode == 0x24 || // $
      vCode == 0x25 || // % 検索可能だがパターンマッチを行う為指定
      vCode == 0x26 || // &
      vCode == 0x27 || // '
      vCode == 0x28 || // (
      vCode == 0x29 || // )
      vCode == 0x2a || // *
      vCode == 0x2c || // ,
      vCode == 0x2d || // -
      vCode == 0x3b || // ;
      vCode == 0x3d || // =
      vCode == 0x3e || // >
      vCode == 0x3f || // ?
      vCode == 0x5b || // [
      vCode == 0x5d || // ]
      vCode == 0x5f || // _ 検索可能だがパターンマッチを行う為指定
      vCode == 0x7b || // {
      vCode == 0x7c || // |
      vCode == 0x7d || // }
      vCode == 0x7e	 // ~
      )
    {
      return false;
    }
// add end 2002/2/6 N.Sakai

  }
  return true;
}
/********************************************************************/
/*	処理名　　　：　小数点値のチェック関数							*/
/*	パラメータ　：　							  					*/
/*	作成者　　　：　T.AKYIAMA(2002.04.16)			   				*/
/*	修正者　　　：　												*/
/*	戻り値　　　：　true  - 適切									*/
/*	　　　　　　：　false - 不適切									*/
/********************************************************************/
function comChkDecimal(value,decimal_point){
  // 数値および小数のチェックを行ってから実処理を行う
  if(comChkNumValue(value)){
    // 整数部値長を取得
    var dec = decimal_point.substring(0,decimal_point.indexOf(",",0));
    // 小数部値長を取得
    var decimal = decimal_point.substring(decimal_point.indexOf(",",0) + 1,decimal_point.length);

    var sep = value.indexOf(".",0);
    // 小数点がない場合はチェック無し
    if(sep != -1){
      var valueDec = value.substring(0,sep);
      var valueDecimal = value.substring(sep + 1,value.length);

      if(valueDec.length > dec.length || valueDecimal.length > decimal.length){
        return false;
      }
    }else{
      if(value.length > dec.length){
        return false;
      }
    }

    return true;
  }else{
    return false;
  }
}
/********************************************************************/
/*	処理名　　　：　指定した値より大きいかどうかのチェック関数		*/
/*	パラメータ　：　							  					*/
/*	作成者　　　：　T.AKYIAMA(2002.04.19)			   				*/
/*	修正者　　　：　												*/
/*	戻り値　　　：　true  - 適切									*/
/*	　　　　　　：　false - 不適切									*/
/********************************************************************/
function comChkOver(value,size){
  if(value != ""){
    if(parseInt(value,10) <= parseInt(size,10)){
      return true;
    }else{
      return false;
    }
  }else{
    return true;
  }
}

// add start K.Fujii 2003/02/23
/********************************************************************/
/*	処理名　　　：　指定した値より小さいかどうかのチェック関数		*/
/*	パラメータ　：　							  					*/
/*	作成者　　　：　K.FUJII (2003.02.23)			   				*/
/*	修正者　　　：　												*/
/*	戻り値　　　：　true  - 適切									*/
/*	　　　　　　：　false - 不適切									*/
/********************************************************************/
function comChkUnder(value,size){
  if(value != ""){
    if(parseInt(value,10) >= parseInt(size,10)){
      return true;
    }else{
      return false;
    }
  }else{
    return true;
  }
}
// add end   K.Fujii 2003/02/23

/********************************************************************/
/*	処理名　　　：　最大バイト数チェック関数						*/
/*	パラメータ　：　							  					*/
/*	作成者　　　：　Y.Yamada(2003.11.10)			   				*/
/*	修正者　　　：　												*/
/*	戻り値　　　：　true  - 適切									*/
/*	　　　　　　：　false - 不適切									*/
/********************************************************************/
function comChkMaxCharByte(value,size){
  var toCheck = value;
  var len=0;
  var i,a,b,c;
//alert("ＭＡＸＢＹＴＥちぇっく");
  //入力桁数算出
  if( navigator.appName.charAt(0) == "N" ) {
  // Netscape用処理
       return true;
    }
  else {
  // InternetExproler、その他用処理
    for (i=0; i<toCheck.length; i++) {
      if(toCheck.substr(i,1)=='\n' || toCheck.substr(i,1)=='\r'){
        len++;
      }else if(comChkDoubleByte(toCheck.substr(i,1))){
        len+=2;
      }else{
        len++;
      }
//alert(len);
/*
      a=escape(toCheck.charAt(i));
      b=a.charAt(1);
      if (b=="u") {
        c=a.substring(2,6);
//alert(c);
        if (! (c.toLowerCase() >= "ff60" && c.toLowerCase() <= "ff9f")) {  //半角カナ
          len++;
        }
      }
      len++;
//alert(len);
*/
    }
  }
  //最大桁数チェック
  if (len>size) {

    return false;
  }
  return true;
}

/**
 * <pre>
 * マッチング処理の読み込み等で利用します。
 * フォーム内の項目を読み込んで値を返します。
 * 指定した配列のindexの値を返します。
 * 注)
 * numをtrueか省略(null)すると
 * マッチングの比較の際に数値として判定したいので、
 * 値-0を戻します。(これをしないと文字として判定される場合があります。
 * </pre>
 * @param item フォーム内の要素を指定します。 document.fmSubmit.item("ocNo")等で取得した値です。
 * @param index 取得したい要素のindexを指定します。１つしかない場合は0以下を指定すると取得できます。
 * @param num 取得した値を数値として返すかどうかを指定します。true:数値とします。(-0をします。) false:そのまま返します。
 *		  指定しなければtrueと見なします。
 * @since 1.0
 */
function comReadFormItem(item,index,num){
  var value = null;
  var bNum = false;
  if(num == null || num == true){
  bNum = true;
  }

  if(item){
  //配列の場合
  if(item.length){
    if(index < item.length){  //配列を超えた場合はnullを戻します。
    comDebug("comReadFormItem 配列 value[" + index + "]=["+item[index].value+"]");
    if(bNum)  value = item[index].value - 0;
    else	value = item[index].value;
    }
  }
  else{ //1行の場合
    if(index <= 0){ //1行目を読み込むとき要するにindex==0のときだけ読みます。
    comDebug("comReadFormItem １行 value=["+item.value+"]");
    if(bNum)  value = item.value - 0;
    else	value = item.value;
    }
  }
  }
  comDebug("comReadFormItem Return Value=["+value+"]");
  return(value);
}
/**
 * <pre>
 * マッチング処理の読み込み等で利用します。
 * 配列から指定したインデックスに該当する値を取得します。
 * 存在しないインデックスを指定した場合は、nullを返します。
 * </pre>
 * @param list 配列を指定します。 new Array()で作成したような値です。
 * @param index 取得したい要素のindexを指定します。１つしかない場合は0以下を指定すると取得できます。
 * @param num 取得した値を数値として返すかどうかを指定します。true:数値とします。(-0をします。) false:そのまま返します。
 *		  指定しなければtrueと見なします。
 * @since 1.0
 */
function comReadArray(list,index,num){
  var value = null;
  var bNum = false;
  if(num == null || num == true){
  bNum = true;
  }

  if(index < list.length){
  if(bNum)  value = list[index] - 0;
  else	value = list[index];
  }
  comDebug("comReadArray value=["+value+"]");
  return(value);
}
/**
 * <pre>
 * 複数選択ポップアップでテーブル形式のフォームと表示エリアの削除に利用します。
// add start 2011/03/17 K.Takahama J11-0013：iPad対応
 * ★★------非推奨メソッド------★★
 * 当メソッドではなく、comPopupDeleteRowForSafari()を使用すること。
 * 当メソッドはIEでしか正常動作しないため、
 * safari及びMobileSafariを考慮したcomPopupDeleteRowForSafari()を使用してください。
 * 既存で使用していて、影響がない箇所は残しますが、
 * 新規実装で当メソッドは使用しないようお願いします。
 * ★★--------------------------★★
// add end   2011/03/17 K.Takahama J11-0013：iPad対応
 * </pre>
 * @param fmObj フォーム側のオブジェクトを受け取ります。
 * @param dpObj 表示側のオブジェクトを受け取ります。
 * @param ckObj 表示側の削除チェックボックスのオブジェクトを受け取ります。
 * @param startRow テーブルの開始行番号を受け取ります。
 *		  タイトルがある場合は1になります。ない場合は0になります。指定がない場合は1とします。
 * @return boolean true:成功
 */
function comPopupDeleteRow(fmObj,dpObj,ckObj,startRow){
  if(startRow == null){
  startRow = 1; //初期値は1
  }

  //deleteRowするとrows.lengthも変わるので終了条件にlengthを入れておくこと。
  //各テーブルの１行目(添字0)にタイトルを持っているのでi=1からはじめる。
  comDebug("fmObj.rows.length=["+fmObj.rows.length+"]");
  for(var i=startRow;i<fmObj.rows.length;i++){
  if(ckObj.length){	//配列の場合
    if(ckObj[i-1].checked){
    comDebug("配列 行を削除します。i=[" + i + "]");
    fmObj.deleteRow(i);
    dpObj.deleteRow(i);
    i--;  //インデックスを調整
    }
  }
  else{		  //１件しかない場合
    if(ckObj.checked){
    comDebug("１行のみ 行を削除します。i=[" + i + "]");
    fmObj.deleteRow(i);
    dpObj.deleteRow(i);
    i--;  //インデックスを調整
    }
  }
  }
  return(true);
}
// add start 2011/03/17 K.Takahama J11-0013：iPad対応
/**
 * <pre>
 * 複数選択ポップアップでテーブル形式のフォームと表示エリアの削除に利用します。
 * （safari及びMobileSafari対応）
 * </pre>
 * safari対応
 * @param fmObj フォーム側のオブジェクトを受け取ります。
 * @param dpObj 表示側のオブジェクトを受け取ります。
 * @param ckObj 表示側の削除チェックボックスのオブジェクトを受け取ります。
 * @return boolean true:成功
 * </pre>
 */
function comPopupDeleteRowForSafari(fmObj,dpObj,ckObj){	
  if(ckObj.length){
    for(var i = fmObj.rows.length-1 ; i > 0 ; i--){
      
      if(ckObj[i-1].checked){
        comDebug("配列 行を削除します。i=[" + i + "]");
        fmObj.deleteRow(i);
        dpObj.deleteRow(i);
      }
    }
  }else{
    comDebug("１行のみ 行を削除します。i=[" + i + "]");
    fmObj.deleteRow(1);
    dpObj.deleteRow(1);
  }
  return(true);
}
// add end   2011/03/17 K.Takahama J11-0013：iPad対応
/**
 * <pre>
 * 複数選択ポップアップでフォームエリアの値とポップアップからの戻りの値をマッチングし、重複行を省略します。
 * </pre>
 * @param fmItem フォーム側のキーとなる項目オブジェクトを受け取ります。ex)document.fmSubmit.item("ocNo")で取得できる値です。
 * @param noList ポップアップで受け取ったキーの配列を受け取ります。
 * @param nmList ポップアップで受け取った名称の配列を受け取ります。
 * @param fmInsert フォームエリアに行を追加するときの関数オブジェクトを受け取ります。
 * @param dpInsert 表示エリアに行を追加するときの関数オブジェクトを受け取ります。
 * @param fmStartRow フォームエリアに行を追加するときの開始行番号を受け取ります。タイトルがある場合は1を指定します。ない場合は0を指定します。
 * @param dpStartRow 表示エリアに行を追加するときの開始行番号を受け取ります。タイトルがある場合は1を指定します。ない場合は0を指定します。
 * @param nmList ポップアップで受け取った名称の配列を受け取ります。
 * @param num キーを数値として比較を行うかどうかを指定します。true:数値として比較 false:そのまま比較 省略するとtrueです。
 */
function comPopupSimpleMatching(fmItem,noList,nmList,fmInsert,dpInsert,fmStartRow,dpStartRow,num){
  comDebug("start comPopupSimpleMatching fmItem=["+ fmItem + "] noList=["+noList+"] nmList="+nmList+"] fmInsert=[" + fmInsert + "] dpInsert=[" + dpInsert + "] fmStartRow=[" + fmStartRow + "] dpStartRow=[" + dpStartRow + "] num=[" + num + "]");

  //数値として比較するかどうかのフラグを設定します。
  var bNum = false;
  if(num==null || num==true){
  bNum = true;  //指定しなければtrue:数値比較(-0をします。)
  }

  //フォーム内のキー配列を読み込むサブルーチン
  function fmRead(index){
  return comReadFormItem(fmItem,index,bNum);
  }
  //パラメタを読み込むサブルーチン
  function pmRead(index){
  return comReadArray(noList,index,bNum);
  }
  //注)
  //マッチングの比較の際に数値として判定したいので、
  //値-0をした値をもらいます。(これをしないと文字として判定される場合があります。

  //フォーム読み込み
  var fmIndex = 0;
  var fmValue = fmRead(fmIndex);

  //パラメタ読み込み
  var pmIndex = 0;
  var pmValue = pmRead(pmIndex);

  //マッチング処理
  //while(fmValue!=null || pmValue!=null){  //実際のマッチングの場合
  while(pmValue!=null){ //今回はパラメタが無くなれば終了して良い
  if(fmValue==null || (pmValue!=null && fmValue > pmValue)){
    //フォーム側が大きい値の場合はパラメタ値を挿入します。
    comDebug("フォーム側が大きい値の場合はパラメタ値を挿入します。(nullはHIGH_VALUEの意) fmValue=["+fmValue+"] pmValue=["+pmValue+"]");

    //フォームエリア、表示エリアの追加関数を呼び出します。(これらは各アプリで定義します。)
    //fmIndexには、0から数えた値となるので、表にタイトル等がある場合は、fmStartRow,dpStartRowで開始行番号を指定して調整します。
    fmInsert(fmIndex+fmStartRow,pmValue,nmList[pmIndex]);
    dpInsert(fmIndex+dpStartRow,pmValue,nmList[pmIndex]);
    //パラメタを挿入するとフォームのインデックスが１つずれます。
    fmIndex ++; //インデックスがずれるのを補正

    //パラメタ読み込み
    pmValue = pmRead(++pmIndex);
  }
  else if(pmValue==null || (fmValue!=null && fmValue < pmValue)){
    //フォーム側が小さい値の場合は何もしません。
    comDebug("フォーム側が小さい値の場合は何もしません。(nullはHIGH_VALUEの意) fmValue=["+fmValue+"] pmValue=["+pmValue+"]");

    //フォーム読み込み
    fmValue = fmRead(++fmIndex);
  }
  else{
    //等しい値の場合も何もしません。
    comDebug("等しい値の場合も何もしません。(nullはHIGH_VALUEの意) fmValue=["+fmValue+"] pmValue=["+pmValue+"]");

    //パラメタもフォームも読み込み
    fmValue = fmRead(++fmIndex);
    pmValue = pmRead(++pmIndex);
  }
  }

  comDebug("end comPopupSimpleMatching fmItem=["+ fmItem + "] noList=["+noList+"] nmList="+nmList+"] fmInsert=[" + fmInsert + "] dpInsert=[" + dpInsert + "] fmStartRow=[" + fmStartRow + "] dpStartRow=[" + dpStartRow + "] num=[" + num + "]");
  return(true);
}
/**
 * <pre>
 * テーブルの内容を削除します。
 * startRowとendRowを省略すると、全行削除します。
 * comTableDelete(obj);とした場合やcomTableDelete(obj,null,null);とした場合、また、comTableDelete(obj,0,-1);も同じです。
 * @param tblObj 削除するテーブルを受け取ります。document.all("tableId")等で取得した値です。
 * @param startRow 削除を開始する行番号を受け取ります。0を指定すると最初から削除します。
 * @param endRow 削除を終了する行番号を受け取ります。 -1を指定すると最下行まで削除します。
 * @param int - 削除した行数を返します。
 * </pre>
 */
function comTableDelete(tblObj,startRow,endRow){
  var count = 0;
  if(tblObj != null){
  if(startRow==null || startRow < 0){
    startRow = 0;
  }
  if(endRow==null || endRow < 0){
    endRow = tblObj.rows.length-1;
  }
  //後から削除(前からだと行が詰まるのでややこしいので)
  for(var i=endRow;i>=startRow;i--){
    tblObj.deleteRow(i);
    count ++;
  }
  }
  return(count);
}
/**
 * <pre>
 * オブジェクトの表示非表示を切り替えます。
 * この関数の場合は、positionを操作して見かけ上完全に無い状態にします。
 * 表示の場合は、元の位置に戻ります。
 * </pre>
 * @param name オブジェクトの名前を指定します。
 * @param v true:表示します。false:非表示にします。
 */
function  comChgShow(name,v){
  var vis = "hidden";
  var pos = "absolute";
  if(v){
  vis = "visible";
  pos = "static";
  }
  document.all(name).style.visibility = vis;
  document.all(name).style.position = pos;
}
/**
 * <pre>
 * ラジオボタンで選択されている値を取得します。
 * </pre>
 * @param obj ラジオボタンオブジェクトを受け取ります。ex)document.form1.docType
 * @return value 選択されている値を戻します。選択されていない場合はnullを戻します。
 */
function comGetRadioValue(obj){
  var value = null;
  //配列かそうでないかを判定
  if(obj.length){
  for(i=0;i<obj.length;i++){
    if(obj[i].checked){
    //alert(obj[i].value);
    value = obj[i].value;
    }
  }
  }
  else{
  if(obj.checked){
    //alert(obj.value);
    value = obj.value;
  }
  }
  return value;
}
/**
 * <pre>
 * ドロップダウンリストで選択されている値を取得します。(1つ選択のみ対応)
 * </pre>
 * @param obj SELECTタグオブジェクトを受け取ります。ex)document.form1.month
 * @return value 選択されている値を戻します。
 */
function comGetSelectValue(obj){
  return obj.options[obj.selectedIndex].value;
}
/**
 * <pre>
 * 右側空白削除処理
 * </pre>
 * @param s 文字列を指定します。
 * @return value 右側空白を削除した文字列を戻します。
 */
function comRtrim(s){
  if(s==null) return null;
  var r = s.match(/(.*[^ 　\t]+)[ 　\t]*$/);
  if(r==null) return "";
  return RegExp.$1;
}
// ADD K.Takenaka 2001/11/16
/**
 * <pre>
 * 二度押し制御フラグ
 * </pre>
 */
var COM_Click_flg = false;

/**
 * <pre>
 * 二度押し制御フラグ初期化
 * 例）<body OnLoad=comClickFlgInit()>
 * </pre>
 * @param
 * @return
 */
function comClickFlgInit(){
  COM_Click_flg = true;
}
/**
 * <pre>
 * 二度押し制御　Submit
 * </pre>
 * @param exe_form submitしたいformを指定します
 * @return submit成功:true,submit失敗:false
 */
function comSubmit(exe_form){
  if( COM_Click_flg == false ){
  alert("既に処理を開始しています。");
  return false;
  }
  COM_Click_flg = false;
  
  //modify start T.Oonisi J11-0010:TS依頼書システム(開発以降) 添付ファイルJSエラー回避
  try{
    exe_form.submit();
  }catch(e){
    if (e.number == -2147024891) {
      alert('添付ファイルに正しいファイルパス・ファイル名を指定して下さい。');
      COM_Click_flg = true;
      return false;
    }
  }
  //modify end   T.Oonisi J11-0010:TS依頼書システム(開発以降) 添付ファイルJSエラー回避

  return true;
}

/**
 * <pre>
 * 二度押し制御　Submit(anyWarp専用)
 * </pre>
 * @param exe_form submitしたいformを指定します
 * @return submit成功:true,submit失敗:false
 */
function comSubmitForAnyWarp(exe_form){
  if( COM_Click_flg == false ){
    alert("既に処理を開始しています。");
    return false;
  }
  COM_Click_flg = false;
  
  try{
    exe_form.action = exe_form.screenId.value + exe_form.functionId.value + ".action"
    exe_form.submit();
  }catch(e){
    if (e.number == -2147024891) {
      alert('添付ファイルに正しいファイルパス・ファイル名を指定して下さい。');
      COM_Click_flg = true;
      return false;
    }
  }

  return true;
}

/**
 * <pre>
 * 二度押し制御　Submit
 * 二度押し制御の不要なリンクに利用します。
 * </pre>
 * @param exe_form submitしたいformを指定します
 * @return submit成功:true,submit失敗:false
 */
function comFreeSubmit(exe_form){
  COM_Click_flg = true;
  exe_form.submit();
  return true;
}
/**
 * <pre>
 * 二度押し制御 Submit
 * formに限らずにフラグのチェックを行うときに利用します。
 * 処理できないときは、メッセージを出力します。
 * </pre>
 * @param type 処理中の場合の振る舞いを指定します。以下の種類を指定できます。
 *		  COM_CLICK_NOALERT :メッセージを抑止します。
 *		  COM_CLICK_ALERT :既に処理を開始しています。
 *		  COM_CLICK_CONFIRM :既に処理を開始しています。よろしいですか？
 * @return 処理可能:true 処理不可能:false
 */
function comChkSubmit(type){
  if( COM_Click_flg == false ){
  if(type == COM_CLICK_CONFIRM){
    if(!confirm("既に処理を開始しています。よろしいですか？")){
    return false;
    }
  }
  else{
    if(type != COM_CLICK_NOALERT){
    alert("既に処理を開始しています。");
    }
    return false;
  }
  }
  COM_Click_flg = false;
  return true;
}
//add start 2006/12/14 M.Hoshino ２度押しチェック関数
/**
 * <pre>
 * 二度押しチェック
 * フラグのチェックを行うときに利用します。
 * フラグがたっているときは、メッセージを出力します。
 * </pre>
 * @param type 処理中の場合の振る舞いを指定します。以下の種類を指定できます。
 *		  COM_CLICK_NOALERT :メッセージを抑止します。
 *		  COM_CLICK_ALERT :既に処理を開始しています。
 *		  COM_CLICK_CONFIRM :既に処理を開始しています。よろしいですか？
 * @return 処理可能:true 処理不可能:false
 */
function comChkClickFlg(type){
  if( COM_Click_flg == false ){
  if(type == COM_CLICK_CONFIRM){
    if(!confirm("既に処理を開始しています。よろしいですか？")){
    return false;
    }
  }
  else{
    if(type != COM_CLICK_NOALERT){
    alert("既に処理を開始しています。");
    }
    return false;
  }
  }
  return true;
}
//add end 2006/12/14 M.Hoshino ２度押しチェック関数
/**
 * <pre>
 * ポップアップを開く際に既にwindowが開いていたらそのwindowにフォーカスをあてる処理と
 * リンクをwindowを開く前に２度押されたときの対応をします。
 * フォーカス処理は、引数で渡されたwindowオブジェクトがnullでなければ、それにフォーカスを
 * あてます。
 * ２度押し対策は、winVarNameの指し示す変数に文字列を設定することによって、
 * ２度目は、文字が入っていたら起動しないようにします。
 * winVarNameが指し示す変数内には、実際にwindowが開いたときには子windowオブジェクトが
 * 入るため、それ以降はフォーカスの処理でさばくことになります。
 * </pre>
 * @param w 子windowオブジェクトを受け取ります。
 * @param winVarName 親画面で子windowオブジェクトを保存しておく変数の名前を受け取ります。(String)
 * @return boolean 実際のポップアップ処理を継続する場合はtrue、focusをあてたり2度押しの場合はfalse
 */
function comPopupPreCheck(w,winVarName){
  //子windowが既に開いていた場合は、フォーカスをあてます。
  //これによって、子画面が後に隠れた場合にも上に子画面を持ってこれます。
  if(w != null){
  //ポップアップ画面でエラーが発生した場合はwinVar変数がクリアがされないためエラーが発生します。
  //エラーが発生した場合は、画面を立ち上げます。
  // try catch は 現在のバージョンでは完全にサポートされていないので使用しないようにする。
  //try{
    if(!w.closed){
      w.focus();
      return(false);
    }
  //}catch(err){
  //}
  }

  //２度押し対応(windowが開いたらwinVarNameが表す変数内には子windowオブジェクトが入る。)
  //windowが開いたあとは、上のif(w != null) w.focus();でフォーカスをあてる処理になるため
  //ここにはこない
  if( eval(winVarName) != null ){
    // modify start 2011/06/22 T.Oonisi J11-0014 くすり相談録追加課題対応 複数起動を想定していないのでnullチェック追加
    //	if(w.closed){
    //		return true;
    //	}
    if(w != null){
      if(w.closed){
        return true;
      }
    //nullの場合は２度押し制御が不必要なのでtrueで返す
    }else{
      return true;
    }
    // modify end   2011/06/22 T.Oonisi J11-0014 くすり相談録追加課題対応 複数起動を想定していないのでnullチェック追加
    return(false);
  }
  eval(winVarName + "='DBLCLICK'");

  //処理継続
  return(true);
}
/**
 * <pre>
 * 数値フォーマット処理
 * 指定したパターン("000000000"など)に数値をフォーマットして戻します。
 * </pre>
 * @param num 数値を指定します。
 * @param pattern フォーマットパターンを指定します。(現状は"0000"の形式のみ)
 * @return value ゼロを埋めた文字列を戻します。
 */
function comDecimalFormat(num,pattern){
  if(num==null || num=="")  return "";
  if(pattern==null) pattern="00000";

  //ゼロの数を数えます。
  var len = pattern.length;
  //数値を一旦文字にします。
  var str = ""+num;

  //マイナス値の場合は頭分を引く
  if(num < 0) str = str.substring(1);

  //パターンの方が短ければ、そのままリターン
  var strLen = str.length;
  if(strLen >= len) return str;

  //ゼロ埋め文字数を計算してゼロ文字を生成
  var zeroLen = len - strLen;
  var zero = "";
  for(i=0;i<zeroLen;i++)	zero += "0";

  //ゼロを埋めてリターン
  str = zero + str;
  if(num < 0) str = "-" + str;

  return str;
}
/**
 * <pre>
 * ポータルホームへ戻ります。
 * </pre>
 */
function comPortalHome(){
   window.location.href = COM_HOMELINK;
}
function comErrorClose(){
  if(window.parent.frames.length > 0){
    parent.location.href = COM_HOMELINK;
  }else{
    if (opener == null){
      self.location.href = COM_HOMELINK;
    }else{
      opener.location.href = COM_HOMELINK;
      self.window.close();
      opener.focus();
    }
  }
}

/**
 * <pre>
 * エラー発生時にメニューヘッダーの有無を場合によって切り替えます。
 *	 無し：インラインフレーム、ポップアップの場合。
 *	 有り：それ以外の場合。
 * </pre>
 */
function comMenuLoad(){
  if(window.parent.frames.length > 0){
    comVHide('menu');
    document.all.item("menu").style.position = "absolute";
    document.all.item("menu").style.width = "80%";
  } else if(opener!=null){
    comVHide('menu');
    document.all.item("menu").style.position = "absolute";
    document.all.item("menu").style.width = "80%";
  }
}

/**
 * <pre>
 * ドキュメント内のすべてのFORMのWINDOWNAME,OPENERNAMEをセットします。
 * </pre>
 */
function comSetFormWindowName(APPID){
  //２度押し対策フラグ初期化
  comClickFlgInit();

  // ウインドウの名前と親ウインドウの名前をサブミットエリアに保存する。
  var winName = comSetWindowName(self,APPID)
  var openerName = "";

  // ドキュメントがポップアップの時、オープナー名を取得
  if(opener!=null){
    // IE :unkown  Safari :undefined
    if(typeof opener.name != "unknown"  && typeof opener.name != "undefined" ){	//J13-0006 【TPM】既存システム対応　ポップアップ起動時「閉じる」ボタンのみを表示
      openerName = document.fmControl.openerName.value = opener.name;
    }																			//J13-0006 【TPM】既存システム対応　ポップアップ起動時「閉じる」ボタンのみを表示
  }
  // 複数フォームも対応
  for(var i = 0;i < document.forms.length;i++){
    if(document.forms[i].windowName != null) document.forms[i].windowName.value = winName;
    if(document.forms[i].openerName != null) document.forms[i].openerName.value = openerName;
  }
}
/**
 * <pre>
 * ドキュメント内のすべてのFORMのWINDOWNAME,OPENERNAMEをセットします。
 * iframeの内部版
 * iframe内部ではparentのwindow名をwindowNameとして処理を行います。
 * 現状使用することはないがframe内部のwindow名はopenerNameに入れておく。
 * </pre>
 */
function comSetFormIframeWindowName(APPID){
  //２度押し対策フラグ初期化
  comClickFlgInit();

  // ウインドウの名前と親ウインドウの名前をサブミットエリアに保存する。
  var winName = "";
  var openerName = "";

  // ドキュメントがインラインフレームの時、親ウインドウの名前を設定
  if(parent!=null){
    var winName = comSetWindowName(parent,APPID);
  }
  openerName = comSetWindowName(self,APPID);

  // 複数フォームも対応
  for(var i = 0;i < document.forms.length;i++){
    if(document.forms[i].windowName != null) document.forms[i].windowName.value = winName;
    if(document.forms[i].openerName != null) document.forms[i].openerName.value = openerName;
  }
}
// add 2001-12-12 K.Takenaka
/**
 * <pre>
 * しおり確認から戻る
 * </pre>
 */
function comBookMarkCompBack(submitForm,backScreenId,backFunctionId){

  //保存文書はポータルなのでポータルホームへ戻る(暫定)
  //このままでは、初期検索になってしまうので対処要
  //あと、ファンクションIDもちゃんと受渡しすべし
  if(backScreenId == "KeepDocument"){
// M.Matsumoto 2003/07/25 Update Start
  // KeepDocumentへ遷移する場合
//		comPortalHome();
    submitForm.screenId.value='MapsHome';
    submitForm.functionId.value='BookMarkTab';
    comSubmit(submitForm);
// M.Matsumoto 2003/07/25 Update End
    return;
  }

  submitForm.screenId.value = backScreenId;
  submitForm.functionId.value = backFunctionId;
  comSubmit(submitForm);
}
/**
 * <pre>
 * しおり削除する
 * </pre>
 * @param submitForm 			submitするFormを指定します。
 * @param infoId 					情報IDを指定します。
 * @param systemId 				システム情報IDを指定します。
 * @param backScreenId 		戻り先画面IDを指定します。
 * @param backFunctionId 	戻り先機能IDを指定します。
 * @param bookMarkMsg 		確認画面に出力するメッセージを指定します。
 */
function comBookMarkErase(submitForm,
                          infoId,systemId,
                          backScreenId,backFunctionId,
                          bookMarkMsg){
//alert("infoId ["+infoId+"] systemId ["+systemId+"] ");


  submitForm.screenId.value = "BookMark";
  submitForm.functionId.value = "Erase";
  submitForm.infoId1.value = infoId;
  submitForm.systemId1.value = systemId;
  submitForm.backScreenId1.value = backScreenId;
  submitForm.backFunctionId1.value = backFunctionId;
  submitForm.bookMarkMsg1.value = bookMarkMsg;
  submitForm.prtCom1.value = "";
  if (confirm("削除しますか？")){
    comSubmit(submitForm);
  }
}
/**
 * <pre>
 * 複数選択ポップアップでフォームエリアの値とポップアップからの戻りの値をマッチングし、重複行を省略します。
 * </pre>
 * @param fmItem フォーム側のキーとなる項目オブジェクトを受け取ります。ex)document.fmSubmit.item("ocNo")で取得できる値です。
 * @param noList ポップアップで受け取ったキーの配列を受け取ります。
 * @param nmList ポップアップで受け取った名称の配列を受け取ります。
 * @param fmInsert フォームエリアに行を追加するときの関数オブジェクトを受け取ります。
 * @param dpInsert 表示エリアに行を追加するときの関数オブジェクトを受け取ります。
 * @param fmStartRow フォームエリアに行を追加するときの開始行番号を受け取ります。タイトルがある場合は1を指定します。ない場合は0を指定します。
 * @param dpStartRow 表示エリアに行を追加するときの開始行番号を受け取ります。タイトルがある場合は1を指定します。ない場合は0を指定します。
 * @param nmList ポップアップで受け取った名称の配列を受け取ります。
 * @param num キーを数値として比較を行うかどうかを指定します。true:数値として比較 false:そのまま比較 省略するとtrueです。
 */

function comPopupSimpleMatchingNotSort(fmItem,noList,nmList,fmInsert,dpInsert,fmStartRow,dpStartRow,num){
  comDebug("start comPopupSimpleMatchingNotSort fmItem=["+ fmItem + "] noList=["+noList+"] nmList="+nmList+"] fmInsert=[" + fmInsert + "] dpInsert=[" + dpInsert + "] fmStartRow=[" + fmStartRow + "] dpStartRow=[" + dpStartRow + "] num=[" + num + "]");

  //数値として比較するかどうかのフラグを設定します。
  var bNum = false;
  if(num==null || num==true){
    bNum = true;  //指定しなければtrue:数値比較(-0をします。)
  }

  //フォーム内のキー配列を読み込むサブルーチン
  function fmRead(index){
    return comReadFormItem(fmItem,index,bNum);
  }

  //パラメタを読み込むサブルーチン
  function pmRead(index){
    return comReadArray(noList,index,bNum);
  }

  //注)
  //マッチングの比較の際に数値として判定したいので、
  //値-0をした値をもらいます。(これをしないと文字として判定される場合があります。

  //フォーム読み込み
  var fmIndex = 0;
  var fmValue = fmRead(fmIndex);

  //パラメタ読み込み
  var pmIndex = 0;
  var pmValue = pmRead(pmIndex);

  //マッチング処理
  var machFlg = false;

  //while(fmValue!=null || pmValue!=null){  //実際のマッチングの場合
  while(pmValue!=null){ //今回はパラメタが無くなれば終了して良い

    var brakFlg = false;
    while(brakFlg == false ){
      if ( fmValue == pmValue ) {
        machFlg = true;
        brakFlg = true;
      } else if (fmValue == null) {
          brakFlg = true;
      } else {
        fmValue = fmRead(++fmIndex);
      }
    }

    if(machFlg==false){

      //フォーム側が大きい値の場合はパラメタ値を挿入します。
      comDebug("フォーム側が大きい値の場合はパラメタ値を挿入します。(nullはHIGH_VALUEの意) fmValue=["+fmValue+"] pmValue=["+pmValue+"]");

      //フォームエリア、表示エリアの追加関数を呼び出します。(これらは各アプリで定義します。)
      //fmIndexには、0から数えた値となるので、表にタイトル等がある場合は、fmStartRow,dpStartRowで開始行番号を指定して調整します。
      fmInsert(fmIndex+fmStartRow,pmValue,nmList[pmIndex]);
      dpInsert(fmIndex+dpStartRow,pmValue,nmList[pmIndex]);

      //パラメタもフォームも読み込み
      fmIndex = 0;
      fmValue = fmRead(fmIndex);
      pmValue = pmRead(++pmIndex);

    }
    else{

      //等しい値の場合も何もしません。
      comDebug("等しい値の場合も何もしません。(nullはHIGH_VALUEの意) fmValue=["+fmValue+"] pmValue=["+pmValue+"]");

      //パラメタもフォームも読み込み
      machFlg = false;
      fmIndex = 0;
      fmValue = fmRead(fmIndex);
      pmValue = pmRead(++pmIndex);

    }

  }



  comDebug("end comPopupSimpleMatchingNotSort fmItem=["+ fmItem + "] noList=["+noList+"] nmList="+nmList+"] fmInsert=[" + fmInsert + "] dpInsert=[" + dpInsert + "] fmStartRow=[" + fmStartRow + "] dpStartRow=[" + dpStartRow + "] num=[" + num + "]");

  return(true);

}




/**
 * <pre>
 * 辞書使用メッセージ
 * </pre>
 * @return 		論理型 検索する:true 検索しない:false
 */
function comDicMsg(){
  return confirm("検索に時間がかかる恐れがあります");
}

/**
 * <pre>
 * 開始レコード番号を計算し、フォームに設定します。
 * また、次ページ前ページフラグもフォームに設定します。
 * フォームには必ず、pageNextBackFlag1とstartRecordNo1がなければいけません。
 * </pre>
 * @param formObj フォームオブジェクト
 * @param pgflg ページフラグ(1:次ページ、1以外:前ページ)
 * @return なし
 */
function comSetStartNo(formObj,pgflg){
  if(pgflg == 1){
    //開始行番号を計算します。次
    var startRows = formObj.startRecordNo1.value;
    var pageLines = formObj.pageLines1.value;
    var temp_row = parseInt(startRows) + parseInt(pageLines);
  } else {
    //開始行番号を計算します。前
    var startRows = formObj.startRecordNo1.value;
    var pageLines = formObj.pageLines1.value;
    var temp_row = parseInt(startRows) - parseInt(pageLines);
    if(temp_row < 1)	temp_row = 1;
  }
  formObj.pageNextBackFlag1.value = pgflg;
  formObj.startRecordNo1.value = temp_row;
}

/**
 * <pre>
 * 文字列の最後から指定した位置までの文字列を抜き出す
 * </pre>
 * @param  n   フォームオブジェクト
 * @return value 抜き出した文字列
 */
function comSubStrTurn(str,n){

  var strCount = str.length - 0;
  n = n  - 0;

  var startNo = strCount - n;

  var value = str.substr(startNo, strCount);

  return value;
}

//一覧画面から新規登録画面へ遷移する
/**
 * <pre>
 *	指定の画面ID、機能IDで次画面に遷移する
 * しおり一覧(KeepDocument)に遷移する場合はポータルホームを呼び出す
 * </pre>
 * @param fmSubmit サブミットフォーム
 * @param screenId 画面ID
 * @param functionId 機能ID
 */
function comNextScreen(fmSubmit, screenId, functionId) {

//add start 2008/07/11 S.Sakamoto サーバリプレース対応
//alert("screenId = " + screenId);
//alert("functionId = " + functionId);
  if (
       (screenId == "BookMark"     && functionId == "RegisterInit") 
    || (screenId == "BookMark"     && functionId == "Erase") 
    || (screenId == "KeepDocument" && functionId == "View") 
  ){

/* J11-0013 modify start 2011/04/05 K.Adachi */
//		fmSubmit.action=getNewServerActionUrl();
    
    //アクセス端末をチェック
    if ((!comIsIPhoneClient()) && (!comIsIPadClient)) {
      // 「iPhone」「iPad」以外の場合
      
      // 遷移先Actionを変更
      fmSubmit.action = getNewServerActionUrl();
      
    }

/* J11-0013 modify end 2011/04/05 K.Adachi */
  }
//add end   2008/07/11 S.Sakamoto サーバリプレース対応
// K.Takenaka 2002.01.17 ＭＯＮＪＵ 文献複写依頼の為
  if (screenId == "KeepDocument" && functionId == "View") {
//	if (screenId == "KeepDocument") {
// M.Matsumoto 2003/07/25 Update Start
  // KeepDocumentへ遷移する場合
//		comPortalHome();
    fmSubmit.screenId.value='MapsHome';
    fmSubmit.functionId.value='BookMarkTab';
    comSubmit(fmSubmit);
// M.Matsumoto 2003/07/25 Update End
    return;
  }

  fmSubmit.screenId.value=screenId;
  fmSubmit.functionId.value=functionId;
  fmSubmit.target="_self";
  comSubmit(fmSubmit);
}

/**
 * <pre>
 *	確認メッセージで確認後、次画面遷移関数(comNextScreen)を呼び出す
 * </pre>
 * @param fmSubmit サブミットフォーム
 * @param screenId 画面ID
 * @param functionId 機能ID
 * @param msg 確認メッセージ
 */
function comNextScreenCallCheck(fmSubmit, screenId, functionId, msg) {
  if (confirm(msg)) {
    comNextScreen(fmSubmit, screenId, functionId);
  }
}

/**
 * <pre>
 *	指定のサブミットフォームで前画面に遷移する
 * 既に画面ID、機能IDが指定されいなければならない
 * しおり一覧(KeepDocument)に遷移する場合はポータルホームを呼び出す
 * </pre>
 * @param fmSubmit サブミットフォーム
 */
function comReturn(fmSubmit) {

  if (fmSubmit.screenId.value == "KeepDocument" && fmSubmit.functionId.value == "View") {
  // KeepDocumentへ遷移する場合
// M.Matsumoto 2003/07/25 Update Start
//		comPortalHome();
    fmSubmit.screenId.value='MapsHome';
    fmSubmit.functionId.value='BookMarkTab';
    comSubmit(fmSubmit);
// M.Matsumoto 2003/07/25 Update End
    return;
  }

  fmSubmit.target="_self";
  comSubmit(fmSubmit);
}

/**
 * <pre>
 * 画面入力共通
 *
 * 入力画面、変更画面の入力時に一定間隔でダミーのＪＳＰをＧＥＴして
 * 通信を維持します。
 * 9分間隔(5400000)＊6回　セッションタイムアウトまでの一時間を維持します
 * </pre>
 */
function comIntervalResponse() {

  COM_INTERVALID = setInterval('comIntervalResponseRun();',COM_INTERVAL_TIME)

}
function comIntervalResponseRun() {

  if (COM_INTERVAL_CNT == 0){
    clearTimeout(COM_INTERVALID);
  }else{
    var imgObj = new Image();
    //ＪＳＰを指定する場合は回線の維持とセッションが延長されます
// modify 2008/02/27 デンドライトからの接続のため絶対パス指定に変更
//		imgObj.src = "../common/mapsIntervalResponse.jsp";
    imgObj.src = "http://inteig01.takeda.co.jp/maps/common/mapsIntervalResponse.jsp";
    //gifを指定する場合は回線のみ維持されます
    //imgObj.src = "../img/del01.gif";
    COM_INTERVAL_CNT--
  }

}

/**
 * <pre>
 * ポータルホームへ戻ります。ポータル機能廃止版
 * トップ画面への画面ＩＤと機能ＩＤをＪＳＰで
 * 指定したフォームからＰＯＳＴします。
 * 画面ＩＤと機能ＩＤは当ＪＳ上部で指定してください。
 * 画面ＩＤ：COM_TOP_SCREENID
 * 機能ＩＤ：COM_TOP_FUNCTIONID
 * </pre>
 */
// M.Matsumoto 2003/08/04 Add Start
function comReturnHome(fmSubmit)
{
  fmSubmit.screenId.value   = COM_TOP_SCREENID;
  fmSubmit.functionId.value = COM_TOP_FUNCTIONID;
  fmSubmit.submit();
}
// M.Matsumoto 2003/08/04 Add End

// add start Y.Iki 2004/09/07
/**
 * <pre>
 * 二度押し制御　Submit(HTMLFrameアプリ用)
 * </pre>
 * @param exe_form submitしたいformを指定します
 * @return submit成功:true,submit失敗:false
 */
function comFrameSubmit(exe_form){
  if( top.COM_Click_flg == false ){
  alert("既に処理を開始しています。");
  return false;
  }
  top.COM_Click_flg = false;
  exe_form.submit();
  return true;
}

/**
 * <pre>
 *	確認メッセージで確認後、次画面遷移関数(comFrameNextScreen)を呼び出す(HTMLFrameアプリ用)
 * </pre>
 * @param fmSubmit サブミットフォーム
 * @param screenId 画面ID
 * @param functionId 機能ID
 * @param msg 確認メッセージ
 */
function comFrameNextScreenCallCheck(fmSubmit, screenId, functionId, msg) {
  if (confirm(msg)) {
    comFrameNextScreen(fmSubmit, screenId, functionId);
  }
}

/**
 * <pre>
 *	指定の画面ID、機能IDで次画面に遷移する(HTMLFrameアプリ用)
 * </pre>
 * @param fmSubmit サブミットフォーム
 * @param screenId 画面ID
 * @param functionId 機能ID
 */
function comFrameNextScreen(fmSubmit, screenId, functionId) {

  if (screenId == "KeepDocument" && functionId == "View") {
    fmSubmit.screenId.value='MapsHome';
    fmSubmit.functionId.value='BookMarkTab';
    comSubmit(fmSubmit);
    return;
  }
  fmSubmit.screenId.value=screenId;
  fmSubmit.functionId.value=functionId;
  comFrameSubmit(fmSubmit);
}

/**
 * <pre>
 * ドキュメント内のすべてのFORMのWINDOWNAME,OPENERNAMEをセットします。(HTMLFrameアプリ用)
 * </pre>
 */
function comFrameSetFormWindowName(APPID){
  //２度押し対策フラグ初期化
  comFrameClickFlgInit();

  // ウインドウの名前と親ウインドウの名前をサブミットエリアに保存する。
  var winName = comSetWindowName(self,APPID)
  var openerName = "";

  // ドキュメントがポップアップの時、オープナー名を取得
  if(opener!=null){
    openerName = document.fmControl.openerName.value = opener.name;
  }
  // 複数フォームも対応
  for(var i = 0;i < document.forms.length;i++){
    if(document.forms[i].windowName != null) document.forms[i].windowName.value = winName;
    if(document.forms[i].openerName != null) document.forms[i].openerName.value = openerName;
  }
}

/**
 * <pre>
 * 二度押し制御フラグ初期化(HTMLFrameアプリ用)
 * 例）<body OnLoad=comFrameClickFlgInit()>
 * </pre>
 * @param
 * @return
 */
function comFrameClickFlgInit(){
  top.COM_Click_flg = true;
}
// add end Y.Iki 2004/09/07

//add start 2005/12/14 D.Masuda
/**
 * <pre>
 *	対象の画像ファイルの縦横サイズを、指定したサイズ以下に縮小して表示する
 *	bodyタグのonloadにて実行すること
 * </pre>
 * @param maxHeight 許可する最大のheight
 * @param maxWidth  許可する最大のwidth
 * @param formName  フォーム名
 * @param imageName 対象のimgタグのname
 */
function comImageSizeReduction(maxHeight, maxWidth, formName, imageName, isBorder){

  //イメージオブジェクト生成
  var image = new Image();
  //imgタグのオブジェクトを取得
  image = eval("document." + formName + "." + imageName);

  //サイズ変更（widthが優先されます）
  if(image.width > maxWidth){
    image.width = maxWidth;

  }else if(image.height > maxHeight){
    image.height = maxHeight;
  }

  if(isBorder == true){
    image.border = 1;
  }
}
//add end 2005/12/14 D.Masuda

//add start 2006/04/19 A.Iida
/**
 * <pre>
 *	検索文字列の全角カナ文字を半角ｶﾅ文字に変換します。
 *	全角小文字(ァィゥェォャュョッ)は半角大文字(ｱｲｳｴｵﾔﾕﾖﾂ)に変換します。
 *	全角文字「ー」は半角文字「-」に変換します。
 * </pre>
 * @param str 検索文字列
 */
function comChgFormatKana(str) {

  // 半角カナ文字
  var halfChar = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎﾊﾋﾌﾍﾎｱｲｳｴｵﾔﾕﾖﾂﾞﾟｰ ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!#$&()=ｰ~^|{[`@+;*:}]?/>.<";
  // 全角カナ文字
  var fullChar = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポァィゥェォャュョッ゛゜ー　ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ１２３４５６７８９０！＃＄＆（）＝－～＾｜｛［'＠＋；＊：］｝？／＞．＜";
  // 変換後の文字列
  var rtnStr = "";

  for (i=0; i<str.length; i++) {
    c = str.charAt(i);
    n = fullChar.indexOf(c,0);
    if (n >= 0) c = halfChar.charAt(n);
    rtnStr += c;
  }
  return rtnStr;
}
//add  end  2006/04/19 A.Iida

//add start 2006/06/08 A.Iida
/**
 * 全角カナ文字の入力チェック
 * 全角カナ文字のみ入力可能な項目の入力チェックをします。
 * @param str 入力された検索文字列
 * @param name 入力項目名
 * @param size 入力サイズ
 * @return mess エラーメッセージ
 */
function comChkFullSizeChar(str,name,size){
  var stringKana = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポァィゥェォャュョッ゛゜ー　ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ１２３４５６７８９０！＃＄＆（）＝－～＾｜｛［’＠＋；＊：］｝？／＞．＜";
  var flg = 0;
  var mess = "";
  for(var i=0; i<str.length; i++){
    var checkInput = str.charAt(i);
    for (var j=0; j<stringKana.length; j++){
      if(checkInput == stringKana.charAt(j)){
        flg++;
        break;
      }
    }
  }

  if((flg != str.length) && (str.length > size)){
    mess += name + "には全角カナ文字又は全角英数字(大文字)以外は入力できません。\n";
    mess += name + "の制限字数を越えています。";
  }else if(flg != str.length){
    mess += name + "には全角カナ文字又は全角英数字(大文字)以外は入力できません。";
  }else if(flg > size){
    mess += name + "の制限字数を越えています。";
  }
  return mess;
}
//add  end  2006/06/08 A.Iida


// Add Start	2006/12/04 Yo.Nakamura
/**
 * 全角カナ文字の成型(濁音・半濁音のみ)
 * 　全角カナ文字(濁音・半濁音のみ)を半角カナ文字(濁音・半濁音のみ)
 * 　に成型する。
 * @param str 入力された検索文字列
 * @param name 入力項目名
 * @param size 入力サイズ
 * @return mess エラーメッセージ
 */
function comCastDakuKana(str){
  // 半角カナ文字(濁音・半濁音)
  var halfDakuChar = "ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾊﾋﾌﾍﾎﾊﾋﾌﾍﾎ";
  // 全角カナ文字(濁音・半濁音)
  var fullDakuChar = "ガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポ";
  // 変換後の文字列
  var rtnStr = "";

  for (i=0; i<str.length; i++) {
    c = str.charAt(i);
    n = fullDakuChar.indexOf(c,0);
    if (n >= 0 && n <= 19) {
      c = halfDakuChar.charAt(n) + "ﾞ";		// [ガ～ボ]を[ｶ～ﾎ]ﾞにする
      rtnStr += c;
    } else if (n > 19) {
      c = halfDakuChar.charAt(n) + "ﾟ";		// [パ～ポ]を[ﾊ～ﾎ]ﾟにする
      rtnStr += c;
    } else if (n == -1) {
      rtnStr += c;
    }
  }
  return rtnStr;
}

/**
 * 全角カナ文字の成型(促音・拗音のみ)
 * 　全角カナ文字(促音・拗音のみ)を半角カナ文字(促音・拗音のみ)
 * 　に成型する。
 * @param str 入力された検索文字列
 * @param name 入力項目名
 * @param size 入力サイズ
 * @return mess エラーメッセージ
 */
function comCastSmallKana(str){
  // 半角カナ文字(促音・拗音)
  var halfSmallChar = "ｧｨｩｪｫｬｭｮｯ";
  // 全角カナ文字(促音・拗音)
  var fullSmallChar = "ァィゥェォャュョッ";
  // 変換後の文字列
  var rtnStr = "";

  for (i=0; i<str.length; i++) {
    c = str.charAt(i);
    n = fullSmallChar.indexOf(c,0);
    if (n >= 0) {
      c = halfSmallChar.charAt(n);
      rtnStr += c;
    } else {
      rtnStr += c;
    }
  }
  return rtnStr;
}

/**
 * 全角カナ文字の成型(清音・英数字)
 * 　全角カナ文字(清音・英数字)を半角カナ文字(清音・英数字)
 * 　に成型する。
 * @param str 入力された検索文字列
 * @param name 入力項目名
 * @param size 入力サイズ
 * @return mess エラーメッセージ
 */
function comCastKana(str){
  // 半角カナ文字(清音・英数字)
  var halfChar = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝｰ ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!#$&()=-~^|{[`@+;*:}]?/>.<･";
  // 全角カナ文字(清音・英数字)
  var fullChar = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンー　ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ１２３４５６７８９０！＃＄＆（）＝－～＾｜｛［'＠＋；＊：］｝？／＞．＜・";
  // 変換後の文字列
  var rtnStr = "";

  for (i=0; i<str.length; i++) {
    c = str.charAt(i);
    n = fullChar.indexOf(c,0);
    if (n >= 0) c = halfChar.charAt(n);
    rtnStr += c;
  }
  return rtnStr;
}
// Add End		2006/12/04 Yo.Nakamura


/* J11-0013 add start 2011/04/05 K.Adachi */

/**
 * 『iPhone』端末か評価します。.
 * 
 * @param なし
 * @return [true：iPhone端末, false：iPhone端末以外]
 */
function comIsIPhoneClient() {
  return comIsExistUserAgent("iPhone");
}

/**
 * 『iPad』端末か評価します。.
 * 
 * @param なし
 * @return [true：iPad端末, false：iPad端末以外]
 */
function comIsIPadClient(){
  return comIsExistUserAgent("iPad");
}

/**
 * ユーザーエージェント情報の存在チェックを行います。.
 * 
 * @param userAgentName ユーザーエージェント名
 * @return [true：存在する, false：存在しない]
 */
function comIsExistUserAgent(userAgentName){
  
  var navi = navigator.userAgent;
  
  if (navi.indexOf(userAgentName) >= 0) {
    return true;
  } else {
    return false;
  }
}
