/*
 * $Id: mainMenubase.js,v 1.2 2013/09/09 04:28:19 yoshida Exp $
 *******************************************************************************
 * <改訂履歴>
 * 2010/05/08 大西　孝育：all：1.4
 *   B10-0130 レイアウト変更の為
 * 2010/07/01 大西　孝育：all：1.9
 *   B10-0246 サブメニュー削除の為
 * 2010/09/08 大西　孝育：all：1.18
 *   B10-0247 メニューDB化対応
 * 2010/09/29 大西　孝育：all：1.25
 *   B10-0345 Home&Naviリニューアル本番化
 * 2010/10/05 大西　孝育：all：1.26
 *   B10-0345 画面レイアウト表示速度向上対応
 * 2010/11/15 大西　孝育：all：1.27
 *   B10-0414 QV画像リンク先DB化対応
 * 2011/03/28 大西　孝育：all：1.28
 *   J11-0013 iPadレイアウト変更対応 レイアウト切替処理追加
 * 2011/04/08 大西　孝育：all：1.30
 *   J11-0013 iPadレイアウト変更対応
 * 2012/05/11 吉田　享平：all：1.31
 *   B12-0088 Windows7ワイド対応
 * 2012/06/05 吉田　貴子：all：1.32
 *   J12-0006 Step2対応
 * 2012/05/25 村上　範彰：all：1.34
 *   J12-0006  トップメニュ_品目別遂行率
 * 2012/06/13 小田　郁恵：all：1.35
 *   J12-0006 Topメニュー施設検索
 * 2012/06/05 吉田　貴子：all：1.36
 *   J12-0006 Step2対応
 * 2012/08/01 吉田　貴子：all：1.38
 *   B12-0146 Step2対応 Top画面レイアウト変更
 * 2012/08/01 吉田　貴子：all：1.2
 *   B13-0147 メニュー管理パラメータ追加
 * 2014/08/26 吉田　貴子：all：1.13
 *   J14-0008 メニューレイアウト変更
 * YYYY/MM/DD 改訂者名：[フィールド名｜メソッド名]：[リビジョン番号]
 *   [改訂番号] [改訂内容]
 *******************************************************************************
 * <既知のバグ情報>
 * YYYY/MM/DD バグ発見者名：[メソッド名]：[リビジョン番号]
 *   [バグ内容]
 */
 
var IE4 = false;	// Internet Explorer 4,5,6
var NN4 = false;	// Netscape 4
var NN6 = false;	// Netscape 6,7
var OP6 = false;	// Opera 6,7

// 特有のオブジェクトを取得してバージョン確認
objOp6 = (navigator.userAgent.indexOf("Opera",0) != -1)?1:0;
objIEorNn6 = document.getElementById;
objIE4 = document.all;
objNn4 = document.layers;

if( 	 objOp6		){	OP6 = true;	}
else if( objIE4		){	IE4 = true;	}
else if( objIEorNn6	){	NN6 = true;	}
else if( objNn4		){	NN4 = true;	}


var menuCnt = 0;
var menuImgTag = '<img src="img/menuLinkIcon1.png" style="margin-top:3px;">';
var menuImgTag2 = '<img src="img/menuLinkIcon5.png" style="margin-top:3px;">';
var menuImgData = 'img/menuLinkIcon2.png';
var menuStrOsver = "";
var mainMenuTop = 0;
var mainMenuLeft = 0;
var menuJgiNo = "";
var menuActStat = "";
var menuActorJgiNo = "";
var menuPostJgiNo = "";
var menuUserID = "";
var menuDccJgiNo = "";
var menuDccPass = "";
var menuSasJgiNo = "";
var menuSasPass = "";
var menuPmsJgiNo = "";
var menuPmsPass1 = "";
var menuPmsPass2 = "";

var menuDispType = "";
var menuDivHeiht = 0;
var mainSubMenuTop = 0;

var menuScreenId = "";
var menuFunctionId = "";
var postJgiNo = "";
var menuUserIDLow = "";
var menuUserIDUpp = "";
var defltPopUpSize = 200;
var htmlStr = "";

//画像タグ
var imgTag = '<img align="absMiddle" border="0" src="img/expactns.gif">' + "&nbsp;";


//送信フォーム
//ブラウザ画面をformタグで上書いく
var mainMenuRequest = "http://inteig01.takeda.co.jp/maps";

function mainMenuFmMainMenu(){
  
  //フォームが存在しない場合、送信フォームを作成する
  if(!document._fmMainMenu && !document.all._fmMainMenu){
    
    var fmMainMenuObj = document.createElement('form');
    fmMainMenuObj.id = "_fmMainMenu";
    fmMainMenuObj.method = "POST";
    fmMainMenuObj.action = mainMenuRequest + "/servlet/control";
    fmMainMenuObj.style.visibility = "hidden";
    fmMainMenuObj.style.position = "absolute";
    
    appFormData(fmMainMenuObj,"text","screenId","");
    appFormData(fmMainMenuObj,"text","functionId","");
    appFormData(fmMainMenuObj,"text","windowName","");
    appFormData(fmMainMenuObj,"text","openerName","");
    
//		alert(fmMainMenuObj)
    document.body.appendChild(fmMainMenuObj);
  }
}


//メニューヘッダー
function hedStr(){
  var str = "";

  if (getNavigatorMemuIpad()){
    str += '<div id="mainMenu" class="mainMenuScroll" style="overflow-y:hidden;width:168px;position:absolute;top:' + mainMenuTop + 'px;left:' + mainMenuLeft + 'px;z-index:2000;display:' + menuDispType + '">';
  }else{
    str += '<div id="mainMenu" class="mainMenuScroll" style="overflow-y:scroll;height:' + menuDivHeiht + 'px;width:170px;position:absolute;top:' + mainMenuTop + 'px;left:' + mainMenuLeft + 'px;z-index:2000;display:' + menuDispType + '">';
  }
  
  str += '<table border="0" cellspacing="0" cellpadding="0" style="width:150px;table-layout:fixed;word-break:break-all;">';
  str += '<tbody>';
  
  if (getNavigatorMemuIpad()){
    str += '<tr style="display:;">';
    str += '<td width="20" style="font-size:0px;">&nbsp;</td><td width="140" style="font-size:0px;">&nbsp;</td>';
  }else{
    str += '<tr style="display:none;">';
    str += '<td width="20">&nbsp;</td><td width="125">&nbsp;</td>';
  }
  
  str += '</tr>';
  str += '<tr><td nowrap colspan="2" class="mainMenuHead">メインメニュー</td></tr>';
  
  return str;
}


//メニューヘッダー
// Add Start K.Yoshida J12-0006 H&Nトップメニューレイアウト改訂
function hedStrTop(){
  var str = "";

  if (getNavigatorMemuIpad()){
    str += '<div id="mainMenu" class="mainMenuScroll" style="overflow-y:hidden;width:168px;position:absolute;top:' + mainMenuTop + 'px;left:' + mainMenuLeft + 'px;z-index:2000;display:' + menuDispType + '">';
  }else{
    str += '<div id="mainMenu" class="mainMenuScroll" style="overflow-y:scroll;height:' + menuDivHeiht + 'px;width:170px;position:absolute;top:0px;left:2px;z-index:2000;display:' + menuDispType + '">';
  }
  
  str += '<table border="0" cellspacing="0" cellpadding="0" style="width:150px;table-layout:fixed;word-break:break-all;">';
  str += '<tbody>';
  
  if (getNavigatorMemuIpad()){
    str += '<tr style="display:;">';
    str += '<td width="20" style="font-size:0px;">&nbsp;</td><td width="140" style="font-size:0px;">&nbsp;</td>';
  }else{
    str += '<tr style="display:none;">';
    str += '<td width="20">&nbsp;</td><td width="125">&nbsp;</td>';
  }
  
  str += '</tr>';
  str += '<tr><td nowrap colspan="2" class="mainMenuHead">メインメニュー</td></tr>';
  
  return str;
}
// Add End   K.Yoshida J12-0006 H&Nトップメニューレイアウト改訂


//メニューフッター
function hutStr(){
  var str = "";
  
  str += '</table>';
  str += '</div>';
  /*
  str += '</td>';
  str += '</tr>';
  str += '</tbody>';
  str += '</table>';
  */
  
  return str;
}


//サブシステム用メニューリンク表示処理
var mainMenuScrollsize = 10;
var mainMenuScrollId = "";
// add start 2011/03/29 T.Oonisi J11-0013 iPadレイアウト変更対応
var mainMenuHeight = 0;
// add end   2011/03/29 T.Oonisi J11-0013 iPadレイアウト変更対応

//表示制御
function dispMainMenu(){
  if(document.all.mainMenu.style.display == ""){
    document.all.mainMenu.style.display = "none";
  }else{
    document.all.mainMenu.style.display = "";
    mainMenuScrollsize = 10;
    
    // add start 2011/03/29 T.Oonisi J11-0013 iPadレイアウト変更対応
    if(getNavigatorMemuIphone){
      if(mainMenuHeight == 0){
        menuDivHeiht = document.all.mainMenu.offsetHeight;
        mainMenuHeight = menuDivHeiht;
      }
    }
    // add end   2011/03/29 T.Oonisi J11-0013 iPadレイアウト変更対応
    
    scrollDisp();
  }
}

//表示用タイマー処理
//0.001秒毎に50pxずつ表示領域を広げる
function scrollDisp(){
  
  //タイマークリア
  if(mainMenuScrollId != ""){
    clearTimeout(mainMenuScrollId);
  }
  
  //50pxづつ加算
  mainMenuScrollsize += 50;
  
  //オブジェクトサイズ以上の場合
  if(mainMenuScrollsize > menuDivHeiht){
    
    //オブジェクトサイズを設定
    document.all.mainMenu.style.height = menuDivHeiht;
    
    //タイマークリア
    if(mainMenuScrollId != ""){
      clearTimeout(mainMenuScrollId);
    }
  }else{
    
    //オブジェクトサイズを設定
    document.all.mainMenu.style.height = mainMenuScrollsize;
    
    //タイマー再設定
    mainMenuScrollId = setTimeout("scrollDisp()",1);
  }
}


//フォームの子属性追加詳細処理
function appFormData(formObj,dataType,dataName,dataValue){
  
  var formItem = document.createElement("input");
  formItem.type = dataType;
  formItem.id = dataName;
  formItem.name = dataName;
  formItem.value = dataValue;
  formObj.appendChild(formItem);
  
}


//外部ファイルチェック処理
//画面上ですでに呼ばれているファイルは書き込を行わない
function createScriptData(){
  document.open();

  var scriptData = document.getElementsByTagName("script");
  
  var commonFlg = true;
  var commonReg = "common.js";
  var prototypeFlg = true;
  var prototypeReg = "prototype.js";
  var clickonceFlg = true;
  var clickonceReg = "clickonce.js";
  var base64Flg = true;
  var base64Reg = "base64.js";
  
  for(var i = 0 ; i < scriptData.length ; i++){
    
    var str = scriptData[i].src
    str = str.toLowerCase();
    
    if(str.indexOf(commonReg) >= 0){
      commonFlg = false;
    }
    
    if(str.indexOf(prototypeReg) >= 0){
      prototypeFlg = false;
    }

    if(str.indexOf(clickonceReg) >= 0){
      clickonceFlg = false;
    }

    if(str.indexOf(base64Reg) >= 0){
      base64Flg = false;
    }
  }
  
  if(commonFlg){
    document.write('<script type="text/javascript" src="js/common.js"></sc' + 'ript>');
  }
  
  if(prototypeFlg){
    document.write('<script type="text/javascript" src="js/prototype.js"></sc' + 'ript>');
  }
  
  if(clickonceFlg){
    document.write('<script type="text/javascript" src="js/clickonce.js"></sc' + 'ript>');
  }
  
  if(base64Flg){
    document.write('<script type="text/javascript" src="js/base64.js"></sc' + 'ript>');
  }
  
  document.close();
  
}


// add start 2010/09/08 T.Oonisi B10-0247 メニューDB化対応
//メインメニュー表示初期設定
function menuLinkInit(argsScreenId,argsFunctionId){
  
  if(argsScreenId == "Menu" && argsFunctionId == "MenuViewInit"){
    mainMenuTop = 64;
    mainMenuLeft = 2;
/* 2012/06/05 modify start T.Yoshida J12-0006 Step2対応 
    menuDispType = "";
 */
    menuDispType = "none";
/* 2012/06/05 modify end T.Yoshida J12-0006 Step2対応  */ 
    //modify start 2010/09/29 T.Oonisi B10-0345 Home&Naviリニューアル本番化
    //menuDivHeiht = 555;
    // Mod start 2012/05/11 K.Yoshida B12-0088 Win7ワイド対応
    if(getNavigatorMemuVista()){ 
      menuDivHeiht = 530;
    }else{
      menuDivHeiht = 711;
    }
    // Mod end   2012/05/11 K.Yoshida B12-0088 Win7ワイド対応
    //modify end   2010/09/29 T.Oonisi B10-0345 Home&Naviリニューアル本番化
    mainSubMenuTop = 7;
  }else if(argsScreenId == "MapsHome" || (argsScreenId == "KeepDocument" && (argsFunctionId == "ViewInit" || argsFunctionId == "View" || argsFunctionId == "Page" || argsFunctionId == "Search" || argsFunctionId == "Sort")) ){
    mainMenuTop = 64;
    mainMenuLeft = 2;
    menuDispType = "none";
    menuDivHeiht = 555;
    mainSubMenuTop = 0;
  }else{
    mainMenuTop = 40;
    mainMenuLeft = 2;
    menuDispType = "none";
    //modify start 2010/09/29 T.Oonisi B10-0345 Home&Naviリニューアル本番化
    //menuDivHeiht = 520;
    // Mod start 2012/06/22 K.Yoshida B12-0088 Win7ワイド対応
//		menuDivHeiht = 510;
    menuDivHeiht = 691;
    // Mod end   2012/06/22 K.Yoshida B12-0088 Win7ワイド対応
    //modify end   2010/09/29 T.Oonisi B10-0345 Home&Naviリニューアル本番化
    mainSubMenuTop = 52;
  }
  
}

// 1:旧メニュー リンク作成  2:旧メニューポップアップのリンク作成  4:mnuOutSide01.jsp
//フォーム送信用オンクリックタグ作成処理
function createFormDate(menuFlg,menuName,boldFlg,newFlg,linkUrl,targetType,formType,formName,paramName1,paramType1,paramName2,paramType2,paramName3,paramType3,paramName4,paramType4,paramName5,paramType5,free_param_name1,free_param1,free_param_name2,free_param2,free_param_name3,free_param3,free_param_name4,free_param4,free_param_name5,free_param5){
  
  var str = "";
  
  var paramData = "";
    
  if(menuFlg == "1"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;">';
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
  }else if(menuFlg == "2"){
    if(getNavigatorMemuIpad()){
      str += '<tr style="padding-top:0px;padding-bottom:0px;"><td nowrap style="padding-left:0px;padding-top:0px;padding-bottom:0px;width:145px;word-break:break-all;"><div class="MenuItem"">';
    }else{
      str += '<tr style="padding-top:0px;padding-bottom:0px;"><td nowrap style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><div class="MenuItem" style="word-break:break-all;">';
    }

/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
  }else if(menuFlg == "5"){
// 2014/08/26 modify start T.Yoshida J14-0008 
//		str += '<tr style="padding-top:0px;padding-bottom:0px;">';
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
// 2014/08/26 modify end T.Yoshida J14-0008 
/* 2012/07/20 modify start T.Yoshida B12-0146 
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
 */
// 2014/06/17 del start T.Yoshida J14-0008 
//		str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag2 + '</td>';
// 2014/06/17 del end T.Yoshida J14-0008 
/* 2012/07/20 modify end T.Yoshida B12-0146  */ 
/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */
  }
  
  if(formType == "1"){
    paramData = "submitForm('" + linkUrl + "','" + targetType + "','" + formType + "','" + formName + "','" + paramName1 + "','" + paramType1 + "','" + paramName2 + "','" + paramType2 + "','" + paramName3 + "','" + paramType3 + "','" + paramName4 + "','" + paramType4 + "','" + paramName5 + "','" + paramType5 + "','" + free_param_name1 + "','" + free_param1 + "','" + free_param_name2 + "','" + free_param2 + "','" + free_param_name3 + "','" + free_param3 + "','" + free_param_name4 + "','" + free_param4 + "','" + free_param_name5 + "','" + free_param5 + "')";
    
    if(menuFlg == "1"){
      str += '<td style="width:125px;" nowrap><a href="" class="comMenuLink" OnClick="' + paramData + ';return false;">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
    }else if(menuFlg == "2"){
      str += ' ' + menuWiteImg +  ' <a href="" class="MenuItem" OnClick="' + paramData + ';return false;">' + boldCheck(menuName,boldFlg) + "</a>" + createNewImg(newFlg);
    }else if(menuFlg == "4"){
      str += '<a href="" class="comBigMenuTitle" OnClick="' + paramData + ';return false;">' + imgTag + menuName + "</a>" + createNewImg2(newFlg);
/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
    }else if(menuFlg == "5"){
// 2014/06/17 modify start T.Yoshida J14-0008 
//			str += '<td style="width:155px;" nowrap><a href="" class="linkMenuItem" OnClick="' + paramData + ';return false;">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
      str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '><a href="" class="linkMenuItem" OnClick="' + paramData + ';return false;">' + boldCheck(menuName,boldFlg) + createNewImg(newFlg) + '</a></td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */

    }else{
      str += '<a href="" class="comTopMenuLink" OnClick="' + paramData + ';return false;">' + menuName + "</a>";
    }
  }else{
    var paraNames = new Array(paramName1,paramName2,paramName3,paramName4,paramName5,free_param_name1,free_param_name2,free_param_name3,free_param_name4,free_param_name5);
    var paramTypes = new Array(paramType1,paramType2,paramType3,paramType4,paramType5,free_param1,free_param2,free_param3,free_param4,free_param5);
    var pramStr = "";
    
    for(var i = 0 ; i < paraNames.length ; i++){
      
      if(paraNames[i] != ""){
        if(pramStr == ""){
          pramStr += "?" + paraNames[i] + "=" + setParamType(paramTypes[i]);
        }else{
          pramStr += "&" + paraNames[i] + "=" + setParamType(paramTypes[i]);
        }
      }
    }
    
    if(menuFlg == "1"){
      if(targetType == ""){
        str += '<td style="width:125px;" nowrap style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><a href="' + linkUrl + pramStr + '" class="comMenuLink">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
      }else{
        str += '<td style="width:125px;" nowrap style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><a href="' + linkUrl + pramStr + '" class="comMenuLink" target="' + targetType + '">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
      }
    }else if(menuFlg == "2"){
      if(targetType == ""){
        str += ' ' + menuWiteImg + ' <a href="' + linkUrl + pramStr + '" class="MenuItem" >' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) ;
      }else{
        str += ' ' + menuWiteImg + ' <a href="' + linkUrl + pramStr + '" target="' + targetType + '" class="MenuItem" >' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) ;
      }
    }else if(menuFlg == "4"){
      if(targetType == ""){
        str += '<a href="' + linkUrl + pramStr + '" class="comBigMenuTitle" >';
      }else{
        str += '<a href="' + linkUrl + pramStr + '" target="' + targetType + '" class="comBigMenuTitle" >';
      }
      
      str += imgTag + menuName + '</a>' + createNewImg2(newFlg);

/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
    }else if(menuFlg == "5"){
      if(targetType == ""){
// 2014/06/17 modify start T.Yoshida J14-0008 
//				str += '<td style="width:155px;" nowrap style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><a href="' + linkUrl + pramStr + '" class="linkMenuItem">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
        str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '><a href="' + linkUrl + pramStr + '" class="linkMenuItem">' + boldCheck(menuName,boldFlg) + createNewImg(newFlg) + '</a></td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
      }else{
// 2014/06/17 modify start T.Yoshida J14-0008 
//				str += '<td style="width:155px;" nowrap style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><a href="' + linkUrl + pramStr + '" class="linkMenuItem" target="' + targetType + '">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
        str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '><a href="' + linkUrl + pramStr + '" class="linkMenuItem" target="' + targetType + '">' + boldCheck(menuName,boldFlg) + createNewImg(newFlg) + '</a></td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
      }
      str += '</tr>';

/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */
    }else{
      if(targetType == ""){
        str += '<a href="' + linkUrl + pramStr + '" class="comTopMenuLink" >' + menuName + '</a>';
      }else{
        str += '<a href="' + linkUrl + pramStr + '" target="' + targetType + '" class="comTopMenuLink" >' + menuName + '</a>';
      }
    }
  }
  
  if(menuFlg == "0"){
    str += '</tr>';
  }else if(menuFlg == "0"){
    str += '</div></td></tr>';
  }
    
  return str;
}


//送信フォーム作成処理
//引数を元にフォームを作成して送信を行う
function submitForm(linkUrl,targetType,formType,formName,paramName1,paramType1,paramName2,paramType2,paramName3,paramType3,paramName4,paramType4,paramName5,paramType5,free_param_name1,free_param1,free_param_name2,free_param2,free_param_name3,free_param3,free_param_name4,free_param4,free_param_name5,free_param5){
  
    var formData;
    var methodType = "POST";
    var name = formName + "Submit";
    var formObj = eval("document.all." + name);
    
    if(formType == "0"){
      methodType = "GET";
    }
      
    if(!formObj){
      
      formData = document.createElement('form');
      formData.id = name;
      formData.method = methodType;
      formData.action = linkUrl;
      
      if(targetType != ""){
        formData.target = targetType;
      }
      
      formData.style.visibility = "hidden";
      formData.style.position = "absolute";
      
      var paraNames = new Array(paramName1,paramName2,paramName3,paramName4,paramName5,free_param_name1,free_param_name2,free_param_name3,free_param_name4,free_param_name5);
      var paramTypes = new Array(paramType1,paramType2,paramType3,paramType4,paramType5,free_param1,free_param2,free_param3,free_param4,free_param5);
      
      //配列の数だけフォームの子属性を追加する
      for(var i = 0 ; i< paraNames.length ; i++){
        if(paraNames[i] != ""){
          appFormData(formData,"hidden",paraNames[i],setParamType(paramTypes[i]));
        }
      }
      
      //表示されている画面にフォームを追加する
      document.body.appendChild(formData);
    }
    
    
    //ターゲットタイプがデフォルト属性の場合又は空白の場合は別ウィンドを起動させない
    if(targetType != "" && targetType.toLowerCase() != "_blank" && targetType.toLowerCase() != "_top" && targetType.toLowerCase() != "_self"){
      w = window.open("",targetType,"width=1000,height=690,resizable=no,status=no,toolbar=no,scrollbars=yes,titlebar=no,top=5,left=5");
    }
    
    formObj = eval("document.all." + name);
    formObj.submit();
}


//送信フォームパラメータ変換処理
//送信タイプが指定されている場合、該当する従業員番号及びパスワードを返す
function setParamType(type){
  
  var str = "";
  
  if(type == "00"){
    str = menuJgiNo;		//00：ログイン従業員番号(代行含む)
  }else if(type == "01"){
    str = menuPostJgiNo;	//01：画面従業員番号
  }else if(type == "02"){
    str = menuUserIDLow;	//02：ユーザID（LOWER）
  }else if(type == "03"){
    str = menuUserIDUpp;	//03：ユーザID（UPPER）
  }else if(type == "11"){
    str = menuPmsJgiNo;		//11：pmsJgiNo
  }else if(type == "12"){
    str = menuPmsPass1;		//12：pmsPass1
  }else if(type == "13"){
    str = menuPmsPass2;		//13：pmsPass2
  }else if(type == "21"){
    str = menuSasJgiNo;		//21：sasJgiNo
  }else if(type == "22"){
    str = menuSasPass;		//22：sasPass
  }else if(type == "31"){
    str = menuDccJgiNo;		//31：dccJgiNo
  }else if(type == "32"){
    str = menuDccPass;		//32：dccPass
/* 2013/09/03 add start T.Yoshida B13-0147 */
  }else if(type == "33" || type == "34"){
    // 画面初期表示時の受付日
    var nowDate = new Date();

    var nowYear = nowDate.getYear();
    var nowMonth = (nowDate.getMonth() < 9 ? "0" : "") + (nowDate.getMonth() + 1);
    var nowDate = (nowDate.getDate() < 10 ? "0" : "") + nowDate.getDate();
    if( type == "33" ){
      str = nowYear+"/"+nowMonth+"/"+nowDate;		//33：yyyy/mm/dd
    }else{
      str = nowYear+nowMonth+nowDate;		//34：yyyymmdd
    }
/* 2013/09/03 add end T.Yoshida B13-0147 */
  }else{
    str = type;
  }
  
  return str;
  
}


//ダミーリンク作成処理
// 1:旧メニュー リンク作成  2:トップメニュー   3:旧メニューポップアップのリンク作成  4:mnuOutSide01.jsp
function createDummyLinkTag(dispKb,menuName){
  var str = "";
  
  //メインメニュー
  if(dispKb == "1"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
    str += '	<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
    str += '	<td style="width:125px;" nowrap style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><A style="cursor:hand; color: #CCCCCC;" class="MenuItem" Id="noLink" >' + menuName + '</A></td>';
    str += '</tr>';
    
  //トップメニュー
  }else if(dispKb == "2"){
    str += '<a style="cursor:hand; color: #CCCCCC;" class="comTopMenuLink" Id="noLink" >' + menuName + '</A>&nbsp;';
  
  //サブメニュー
  }else if(dispKb == "3"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;">';
    
    if(getNavigatorMemuIpad()){ 
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;width:145px;word-break:break-all;">';
      str += '<div class="MenuItem"> ' + menuWiteImg;
    }else{
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">';
      str += '<div class="MenuItem"> ' + menuWiteImg;
    }
    
    str += ' <a style="cursor:hand; color: #CCCCCC;" class="MenuItem" Id="noLink">' + menuName + '</a>';
    str += '</div></td></tr>';
    
  //医薬営業本部以外
  }else if(dispKb == "4"){
    str += '<a style="cursor:hand; color: #CCCCCC;" class="comBigMenuTitle" Id="noLink" >' + imgTag + menuName + '</a>';

/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
  //新メニュー
  }else if(dispKb == "5"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
/* 2012/07/20 modify start T.Yoshida B12-0146 
    str += '	<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
 */
// 2014/06/17 del start T.Yoshida J14-0008 
//		str += '	<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag2 + '</td>';
// 2014/06/17 del end T.Yoshida J14-0008 
/* 2012/07/20 modify end T.Yoshida B12-0146  */ 
    str += '	<td style="width:155px;" nowrap style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><A style="cursor:hand; color: #CCCCCC;" class="MenuItem2" Id="noLink" >' + menuName + '</A></td>';
    str += '</tr>';

/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */
  }
  
  return str;
}


//リンクタグ作成処理
// 1:旧メニュー リンク作成  2:トップメニュー   3:旧メニューポップアップのリンク作成  4:mnuOutSide01.jsp
function createLinkTag(dispKb,menuName,linkUrl,targetType,boldFlg,newFlg){
  var str = "";
  
  //メインメニュー
  if(dispKb == "1"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
    
    if(targetType == ""){
      str += '<td style="width:130px;" nowrap style="padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;"><a href="' + linkUrl + '" class="comMenuLink">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
    }else{
      str += '<td style="width:125px;" nowrap style="padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;"><a href="' + linkUrl + '" class="comMenuLink" target="' + targetType + '">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
    }
    
    str += '</tr>';
    
  //トップメニュー
  }else if(dispKb == "2"){
    if(targetType == ""){
      str += '<a href="' + linkUrl + '" class="comTopMenuLink">' + menuName + '</a>&nbsp;';
    }else{
      str += '<a href="' + linkUrl + '" class="comTopMenuLink" target="' + targetType + '">' + menuName + '</a>&nbsp;';
    }
    
  //サブメニュー
  }else if(dispKb == "3"){
    str += '<tr style="16px;padding-top:0px;padding-bottom:0px;">';
    
    if(getNavigatorMemuIpad()){
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;width:145px;word-break:break-all;">';
      str += '<div class="MenuItem"> ' + menuWiteImg;
    }else{
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">';
      str += '<div class="MenuItem"> ' + menuWiteImg;
    }
    
    if(targetType == ""){
      str += ' <a href="' + linkUrl + '" class="MenuItem">';
    }else{
      str += ' <a href="' + linkUrl + '" target="' + targetType + '" class="MenuItem">';
    }
      
    str += boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg);
    str += '</div></td></tr>';
    
  //医薬営業本部以外
  }else if(dispKb == "4"){
    if(targetType == ""){
      str += '<a class="comBigMenuTitle" href="' + linkUrl + '">';
    }else{
      str += '<a class="comBigMenuTitle"href="' + linkUrl + '" target="' + targetType + '">';
    }
    
    str += imgTag + menuName + '</a>' + createNewImg2(newFlg);

/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
  //新メニュー
  }else if(dispKb == "5"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
/* 2012/07/20 modify start T.Yoshida B12-0146 
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
 */
// 2014/06/17 del start T.Yoshida J14-0008 
//		str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag2 + '</td>';
// 2014/06/17 del end T.Yoshida J14-0008 
/* 2012/07/20 modify end T.Yoshida B12-0146  */ 
    
    if(targetType == ""){
// 2014/06/17 modify start T.Yoshida J14-0008 
//			str += '<td style="width:160px;" nowrap style="padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;"><a href="' + linkUrl + '" class="linkMenuItem">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
      str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '><a href="' + linkUrl + '" class="linkMenuItem">' + boldCheck(menuName,boldFlg) + createNewImg(newFlg) + '</a></td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
    }else{
// 2014/06/17 modify start T.Yoshida J14-0008 
//			str += '<td style="width:155px;" nowrap style="padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;"><a href="' + linkUrl + '" class="linkMenuItem" target="' + targetType + '">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
      str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '><a href="' + linkUrl + '" class="linkMenuItem" target="' + targetType + '">' + boldCheck(menuName,boldFlg) + createNewImg(newFlg) + '</a></td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
    }
    
    str += '</tr>';
/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */
  }
  
  return str;
}


//スクリーンID移動用
// 1:旧メニュー リンク作成  2:トップメニュー   3:旧メニューポップアップのリンク作成  4:mnuOutSide01.jsp
function createLinkMov(dispKb,menuName,scrnId,funcId,boldFlg,newFlg){
  var str = "";
  
  //メインメニュー
  if(dispKb == "1"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
    
    if(menuName == "検索"){
      str += '<td style="width:125px;" nowrap style="padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;"><IMG class="comPortalIcon" src="img/find.gif" alt="検索"><a href="" class="comMenuLink" OnClick="mnuMainGo(\'' + scrnId + '\',\'' + funcId + '\');return false;">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
      
    }else{
      str += '<td style="width:125px;" nowrap style="padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;"><a href="" class="comMenuLink" OnClick="mnuMainGo(\'' + scrnId + '\',\'' + funcId + '\');return false;">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
    }
    
    str += '</tr>';
  
  //トップメニュー
  }else if(dispKb == "2"){
    str += '<a href="" class="comTopMenuLink" OnClick="mnuMainGo(\'' + scrnId + '\',\'' + funcId + '\');return false;">' + menuName + '</a>&nbsp;';
  
  //サブメニュー
  }else if(dispKb == "3"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;">';
    
    if(getNavigatorMemuIpad()){
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;width:145px;word-break:break-all;">';
      str += '<div class="MenuItem"> ' + menuWiteImg;
    }else{
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">';
      str += '<div class="MenuItem"> ' + menuWiteImg;
    }
    
    str += ' <a href="" class="MenuItem" OnClick="mnuMainGo(\'' + scrnId + '\',\'' + funcId + '\');return false;">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg);
    str += '</div></td></tr>';
  
  //医薬営業本部以外
  }else if(dispKb == "4"){
    str += '<a class="comBigMenuTitle" href="" OnClick="mnuOutSideGo(\'' + scrnId + '\',\'' + funcId + '\');return false;">' + imgTag + menuName + '</a>' + createNewImg2(newFlg);

/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
  //新メニュー
  }else if(dispKb == "5"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
/* 2012/07/20 modify start T.Yoshida B12-0146 
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
 */
// 2014/06/17 del start T.Yoshida J14-0008 
//		str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag2 + '</td>';
// 2014/06/17 del end T.Yoshida J14-0008 
/* 2012/07/20 modify end T.Yoshida B12-0146  */ 
    
    if(menuName == "検索"){
// 2014/06/17 modify start T.Yoshida J14-0008 
//			str += '<td style="width:155px;" nowrap style="padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;"><IMG class="comPortalIcon" src="img/find.gif" alt="検索"><a href="" class="linkMenuItem" OnClick="mnuMainGo(\'' + scrnId + '\',\'' + funcId + '\');return false;">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
      str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '><a href="" class="linkMenuItem" OnClick="mnuMainGo(\'' + scrnId + '\',\'' + funcId + '\');return false;"><IMG class="comSrchIcon" src="img/find.gif" alt="検索">' + boldCheck(menuName,boldFlg) + createNewImg(newFlg) + '</a></td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
      
    }else{
// 2014/06/17 modify start T.Yoshida J14-0008 
//			str += '<td style="width:155px;" nowrap style="padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;"><a href="" class="linkMenuItem" OnClick="mnuMainGo(\'' + scrnId + '\',\'' + funcId + '\');return false;">' + boldCheck(menuName,boldFlg) + '</a>' + createNewImg(newFlg) + '</td>';
      str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '><a href="" class="linkMenuItem" OnClick="mnuMainGo(\'' + scrnId + '\',\'' + funcId + '\');return false;">' + boldCheck(menuName,boldFlg) + createNewImg(newFlg) + '</a></td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
    }
    
    str += '</tr>';
/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */

  }
  
  return str;
}

function pddingTopCheck(px,newFlg){
  
  var str="";
  
  if(newFlg == 1){
    str = "padding-top:3px;"
  }else{
    str = "padding-top:" + px + "px;"
  }
  
  return str;
}

function pddingTopCheck2(newFlg){
  
  var str="";
  
  if(newFlg == 1){
// 2014/08/22 modify start T.Yoshida J14-0008 
//		str = ' style="padding-top:3px;"'
    str = ' style="padding-top:5px;"'
// 2014/08/22 modify end T.Yoshida J14-0008 
  }else{
    str = ""
  }
  
  return str;
}

//オンクリックURL処理
//URLリンクパラメータがオンクリック用の場合
// 1:旧メニュー リンク作成  2:トップメニュー   3:旧メニューポップアップのリンク作成  4:mnuOutSide01.jsp
function createOnClick(dispKb,menuName,linkUrl,boldFlg,newFlg){
  var str = "";
  
  //メインメニュー
  if(dispKb == "1"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink"  style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
    str += "<td style=\"width:125px;\" nowrap style=\"padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;\"><a href=\"\" class=\"comMenuLink\" OnClick=\"" + linkUrl + "return false;\">" + boldCheck(menuName,boldFlg) + "</a>" + createNewImg(newFlg) + "</td>";
    str += '</tr>';
  
  //トップメニュー
  }else if(dispKb == "2"){
    str += "<a href=\"\" class=\"comTopMenuLink\"  OnClick=\"" + funcCheck(linkUrl) + "return false;\">" + menuName + "</a>&nbsp;";
  
  //サブメニュー
  }else if(dispKb == "3"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;">';
    
    if(getNavigatorMemuIpad()){
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;width:145px;word-break:break-all;">';
      str += '<div class="MenuItem"> ' + menuWiteImg;
    }else{
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">';
      str += '<div class="MenuItem"> ' + menuWiteImg;
    }
    
    str += " <a href=\"\" class=\"MenuItem\" OnClick=\"" + funcCheck(linkUrl) + "return false;\">" + boldCheck(menuName,boldFlg) + "</a>" + createNewImg(newFlg);
    str += "</div></td></tr>";
    
  //医薬営業本部
  }else if(dispKb == "4"){
    str += '<a class="comBigMenuTitle" href="" OnClick="' + funcCheck(linkUrl) + 'return false;">' + imgTag + menuName + '</a>' + createNewImg2(newFlg);


/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
  //サブメニュー
  }else if(dispKb == "5"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
/* 2012/07/20 modify start T.Yoshida B12-0146 
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink"  style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag + '</td>';
 */
// 2014/06/17 del start T.Yoshida J14-0008 
//		str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink"  style="padding-left:0px;padding-top:0px;padding-bottom:0px;">' + menuImgTag2 + '</td>';
// 2014/06/17 del end T.Yoshida J14-0008 
/* 2012/07/20 modify end T.Yoshida B12-0146  */ 
// 2014/06/17 modify start T.Yoshida J14-0008 
//		str += "<td style=\"width:155px;\" nowrap style=\"padding-left:0px;' + pddingTopCheck(0,newFlg) + 'padding-bottom:0px;\"><a href=\"\" class=\"linkMenuItem\" OnClick=\"" + linkUrl + "return false;\">" + boldCheck(menuName,boldFlg) + "</a>" + createNewImg(newFlg) + "</td>";
    str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '><a href="" class="linkMenuItem" OnClick="' + linkUrl + 'return false;">' + boldCheck(menuName,boldFlg) + createNewImg(newFlg) + '</a></td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
    str += '</tr>';

/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */
  }
  
  return str;
}


//セミコロンチェック処理
//URLがファンクションで登録されている場合、値の最後にセミコロンが付いているかチェックする
//セミコロンがない場合はjavascriptエラー回避の為、文字の最後にセミコロンを付加する
function funcCheck(str){
  
  if(str.lastIndexOf(";") < 0){
    return str + ";";
  }else{
    return str;
  }
}


//装飾チェック処理
//フラグが立っている場合は<B>で囲う
function boldCheck(strData,boldFlg){
  
  if(boldFlg == 1){
    return '<b>' + strData + '</b>';
  }else{
    return strData;
  }
}


//画像タグ作成処理
function createNewImg(newFlg){
  
  if(newFlg == 1){
// 2014/06/17 modify start T.Yoshida J14-0008 
//		return '<img src="img/mnuNEW.gif" width="22" height="13" alt="New">';
    return '<img src="img/mnuNEW.gif" width="22" height="13" alt="New" style="border-style:none;">';
// 2014/06/17 modify end T.Yoshida J14-0008 
  }else{
    return "";
  }
  
}

//画像タグ作成処理
function createNewImg2(newFlg){
  
  if(newFlg == 1){
    return '<img src="img/mnuNEW.gif" width="22" height="13" alt="New" style="margin-bottom:4px;">';
  }else{
    return "";
  }
  
}


//URLリンクチェック処理
//URLがリンク処理かチェックする
function linkUrlCheck(linkUrl){
  
  //正規表現
  var reg1 = ":\+";
  var reg2 = ":/";
  var reg3 = "http";
  
  //http始まりかチェックする
  if(linkUrl.substring(0,4).match(reg3)){
    return true;
  //2文字目から3文字目の文字が「:\」又は「:/」かチェックする
  }else if(linkUrl.substring(1,3).match(reg1) || linkUrl.substring(1,3).match(reg2)){
    return true;
  //上記以外
  }else{
    return false;
  }
}


//OPERAファンクションチェック
//URLに「writeMenuOpr」が含まれているかチェックする
function checkOpera(linkUrl){
  var reg = "writeMenuOpr";
  
  if(linkUrl.match(reg)){
    return true;
  }else{
    return false;
  }
}

//OPERA実行処理
//文字列で受け取ったデータをファンクションとして実行させる
// 1:旧メニュー リンク作成 2:旧メニューポップアップのリンク作成  3:トップメニュー  4:mnuOutSide01.jsp
function createOpera(dispFlg,funcData,boldFlg,newFlg){
  
  var str = "";
  var func = eval(funcData);
  
  var css = "";
  
  if(dispFlg == "1"){
    css = "comMenuLink";
  }else if(dispFlg == "2"){
    css = "MenuItem";
  }else if(dispFlg == "3"){
    css = "comTopMenuLink";
  }else if(dispFlg == "4"){
    css = "comBigMenuTitle";

/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
  }else if(dispFlg == "5"){
// 2014/08/22 modify start T.Yoshida J14-0008 
//		css = "comMenuLink2";
    css = "linkMenuItem";
// 2014/08/22 modify end T.Yoshida J14-0008 
/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */
  }
  
/*　funcのリターン値の詳細
  arr[arrlength] = strViewName;
  arr[arrlength] = strLinkHref1;
  arr[arrlength] = strLinkHref2;
  arr[arrlength] = strLinkHref3;
  arr[arrlength] = strLinkHref4;
*/

  var atag = "<a ";
  
  if(func[1] != "" && func[1] != null){
    atag += 'href="' + func[1] + '"';
  }else{
    atag += 'style="cursor:hand;"';
  }
  
  if(func[2] != "" && func[2] != null){
    atag += ' target="' + func[2] + '"';
  }
  
  if(func[3] != "" && func[3] != null){
    atag += " onfocus=\"" + func[3] + "\"";
  }
  
  if(func[4] != "" && func[4] != null){
    atag += " onmouseover=\"" + func[4] + "\"";
  }
  
  if(dispFlg == "4"){
    atag += ' class="' + css + '">' + imgTag + boldCheck(func[0],boldFlg) + '</a>' + createNewImg2(newFlg);
// 2014/06/17 add start T.Yoshida J14-0008 
  }else if(dispFlg == "5"){
    atag += ' class="' + css + '">' + boldCheck(func[0],boldFlg) + createNewImg(newFlg) + '</a>';
// 2014/06/17 add end T.Yoshida J14-0008 
  }else{
    atag += ' class="' + css + '">' + boldCheck(func[0],boldFlg) + '</a>' + createNewImg(newFlg);
  }
  
  if(dispFlg == "1"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><img src="img/menuLinkIcon1.png" style="margin-top:3px;"></td>';
    str += "<td style=\"width:130px;padding-left:0px;padding-top:0px;padding-bottom:0px;word-break:break-all;\" nowrap>"+ atag + "</td>";
    str += '</tr>';

    return str;
  }else if(dispFlg == "2"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;">';

    if(getNavigatorMemuIpad()){
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;width:145px;word-break:break-all;">';
    }else{
      str += '<td nowrap valign="top" style="padding-left:0px;padding-top:0px;padding-bottom:0px;">';
    }
    
    str += '<div class="MenuItem"> ' + menuWiteImg;
    str += " " + atag;
    str += "</div></td></tr>";
    
    return str;
  }else if(dispFlg == "3"){
    return '<div style="margin-bottom:3px;">' + atag + '&nbsp;</div>';
  }else if(dispFlg == "4"){
    return atag;

/* 2012/06/01 add start T.Yoshida J12-0006 Step2対応 */
  }else if(dispFlg == "5"){
    str += '<tr style="padding-top:0px;padding-bottom:0px;vertical-align:top;">';
/* 2012/07/20 modify start T.Yoshida B12-0146 
    str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><img src="img/menuLinkIcon1.png" style="margin-top:3px;"></td>';
 */
// 2014/06/17 del start T.Yoshida J14-0008 
//		str += '<td nowrap align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><img src="img/menuLinkIcon5.png" style="margin-top:3px;"></td>';
// 2014/06/17 del end T.Yoshida J14-0008 
/* 2012/07/20 modify end T.Yoshida B12-0146  */ 
//		str += "<td style=\"width:160px;padding-left:0px;padding-top:0px;padding-bottom:0px;word-break:break-all;\" nowrap>"+ atag + "</td>";
    str += '<td class="linkMenuTd" ' + pddingTopCheck2(newFlg) + '>'+ atag + '</td>';
// 2014/06/17 modify end T.Yoshida J14-0008 
    str += '</tr>';

    return str;

/* 2012/06/01 add end T.Yoshida J12-0006 Step2対応 */
  }
}


//ToDo用ポップアップ制御処理
function onDisp(flg){
  if(document.all.ToDoMenuBlock){
    if(flg == 0){
      //エレメント取得
      var elm = document.getElementById("ToDoPop");
      
      //画面表示上のオブジェクトの位置
      
      document.all.ToDoMenuBlock.style.posLeft = elm.offsetParent.offsetLeft+15;
      document.all.ToDoMenuBlock.style.posTop = elm.offsetParent.offsetTop+10;
      
      //画面表示にする
      document.all.ToDoMenuBlock.style.display = "";
    }else{
      //画面非表示にする
      document.all.ToDoMenuBlock.style.display = "none";
    }
  }
}

//58分(3480秒)経過後に非同期通信を行う
var ajaxTime = 3480;					//秒
var menuAjaxTime = "";
  ajaxTime += (ajaxTime * 1000);		//ミリ秒

//タイマータスク処理
//Session再作成用
function menuReSession(){
  
  //設定値
  var formData;
  var methodType = "POST";
  var name = "menuAjaxForm";
  
  //指定名のオブジェクトを取得
  var formObj = eval("document.all." + name);
    
  //オブジェクトが存在するかチェックする
  //存在しない場合のみ下記の処理を行う
  if(!formObj){
    
    //フォームオブジェクトを作成
    formData = document.createElement('form');
    formData.id = name;
    formData.name = name;
    formData.method = methodType;
    formData.action = "http://inteig01.takeda.co.jp/maps/servlet/control";
    formData.style.visibility = "hidden";
    formData.style.position = "absolute";
    
    //フォーム子属性設定
    var paraNames = new Array("screenId","functionId","no1","dummy");
    var paramTypes = new Array("Menu","MenuViewAjax","1","dummy");
    
    //フォーム子属性追加処理
    for(var i = 0 ; i< paraNames.length ; i++){
      if(paraNames[i] != ""){
        appFormData(formData,"hidden",paraNames[i],paramTypes[i]);
      }
    }
    
    //上記で作成したオブジェクトを画面に反映
    document.body.appendChild(formData);
  }
  
  // Ajax開始。
  var ajax = new Ajax();
  ajax.setUrl(document.all.menuAjaxForm.action);
  ajax.setCallbackFlg(1);
  ajax.setCharset("UTF-8");
  
  //フォームエレメント取得
  var obj = document.forms[name];
  
  //フォームのエレメントの数だけループする
  for(var i = 0 ; i < obj.elements.length ; i++){
    //name属性がある場合のみ
    if(obj.elements[i].name){
      ajax.setParameter(obj.elements[i].name,obj.elements[i].value);
    }
  }
  
  ajax.setCallback("menuAjaxToIdle")
  ajax.send();

}

//コールバック
//非同期通信終了時にコールされる
function menuAjaxToIdle(str){
  // 二度押し防止解除
  AjaxStatus.toIdle();
  
  if(menuAjaxTime != ""){
    //タイマー削除
    clearTimeout(menuAjaxTime);
    //タイマー再設定
    menuAjaxTime = setTimeout("menuReSession()",ajaxTime);
  }
}
// add end   2010/09/08 T.Oonisi B10-0247 メニューDB化対応

// add start 2010/10/05 T.Oonisi B10-0345 画面レイアウト表示速度向上対応
//参照設定ファンクション
//トップメニューで使用しているIFRAMEとQV画像の参照リンクを設定する
//画面レイアウト表示速度向上の為
function setIframeSrc(conPath,qvImgPath){
  //個人スケジュール
  if(document.all.bscShare){
    document.all.bscShare.src = conPath + '/servlet/control?screenId=BusinessCalendar&functionId=ShareView&windowName=' + comSetWindowName(self,'BSC');
  }
  
  //NaviBoard
  if(document.all.nvbShare){
    document.all.nvbShare.src = conPath + '/servlet/control?screenId=NaviBoard&functionId=ShareViewInit&windowName=' + comSetWindowName(self,'NVB');
  }
  
  //Attention
  if(document.all.attShare){
    document.all.attShare.src = conPath + '/servlet/control?screenId=Attention&functionId=ShareViewInit&windowName=' + comSetWindowName(self,'ATT');
  }
  
/* 2012/05/17 add start T.Yoshida J12-0006 Step2対応 */
  //Oshirase
  if(document.all.oshShare){
    document.all.oshShare.src = conPath + '/servlet/control?screenId=Oshirase&functionId=ViewInit&windowName=' + comSetWindowName(self,'OSH');
  }
/* 2012/05/17 add end T.Yoshida J12-0006 Step2対応 */

  // mod start 2012/05/25 N.Murakami J12-0006  トップメニュ_品目別遂行率
  //品目別遂行率
  if(document.all.nntShare){
    document.all.nntShare.src = conPath + '/servlet/control?screenId=NjoNaviTopComp&functionId=ShareViewInit&windowName=' + comSetWindowName(self,'NNT');
  }

  // B10-0146 2012/8/10 uchida mod start
  // add start 2012/06/13 I.Oda J12-0006  Topメニュー施設検索
  //施設検索
//	if(document.all.imtShare){
//		document.all.imtShare.src = conPath + '/servlet/control?screenId=ImtTopMnuSearch&functionId=ViewInit&windowName=' + comSetWindowName(self,'IMT');
//	}
  //Topメニュー検索
  if(document.all.menuTopSearchShare){
    if ((document._fmMenuTopSearchIframe.allSearchInitFlg.value == "0"
    &&   document._fmMenuTopSearchIframe.imtInitFlg.value       == "0"
    &&   document._fmMenuTopSearchIframe.dmcInitFlg.value       == "0")
    ||   document._fmMenuTopSearchIframe.actJgiNo.value != document._fmMenuTopSearchIframe.actJgiNoPre.value) {
      document.all.menuTopSearchShare.src = conPath + '/servlet/control?screenId=MnuTopSearch&functionId=ViewInit&windowName=' + comSetWindowName(self,'MNU');
    } else {
      document.all.menuTopSearchShare.src = conPath + '/servlet/control?screenId=MnuTopSearch&functionId=Draw&windowName=' + comSetWindowName(self,'MNU');
    }
  }
  // add end 2012/06/13 I.Oda J12-0006  Topメニュー施設検索
  // B10-0146 2012/8/10 uchida mod end

  //qv画像が表示可能な場合のみ設定する
  //if(document.all.qvImg){
  //	document.all.qvImg.src = qvImgPath
  //}
  // mod end   2012/05/25 N.Murakami J12-0006  トップメニュ_品目別遂行率
}
// add end   2010/10/05 T.Oonisi B10-0345 画面レイアウト表示速度向上対応


// add start 2010/11/15 T.Oonisi B10-0414 QV画像リンク先DB化対応
//ガジェット用リンクタグ作成ファンクション
function getGadgetHederLink(GadgetFlg,LinkName,MntKb,ScrnId,FuncId,LinkUrl,TargetType,FormType,FormName,ParamName1,ParamType1,ParamName2,ParamType2,ParamName3,ParamType3,ParamName4,ParamType4,ParamName5,ParamType5,FreeParamName1,FreeParam1,FreeParamName2,FreeParam2,FreeParamName3,FreeParam3,FreeParamName4,FreeParam4,FreeParamName5,FreeParam5){
  
  var str = "";
  
  //非活性時
  if(MntKb == 2){
    str = createGadgetDummyLinkTag(LinkName);
  //フォーム送信
  }else if(FormType != ""){
    str = createGadgetFormDate(GadgetFlg,LinkName,LinkUrl,TargetType,FormType,FormName,ParamName1,ParamType1,ParamName2,ParamType2,ParamName3,ParamType3,ParamName4,ParamType4,ParamName5,ParamType5,FreeParamName1,FreeParam1,FreeParamName2,FreeParam2,FreeParamName3,FreeParam3,FreeParamName4,FreeParam4,FreeParamName5,FreeParam5)
  //リンク
  }else if(ScrnId == ""){
    if(linkUrlCheck(LinkUrl)){
      str = createeGadgetLinkTag(GadgetFlg,LinkUrl,LinkName,TargetType);
    }else{
      str = createGadgetOnClick(GadgetFlg,LinkName,LinkUrl);
    }
  //オンクリック送信
  }else{
    str = createGadgetLinkMov(GadgetFlg,LinkName,ScrnId,FuncId);
  }
  
  return str;
}


//ダミーリンク作成処理
function createGadgetDummyLinkTag(LinkName){
  
  var str = "";
  
  str += '<a class="menuHeaderText" style="cursor:hand; color: #CCCCCC;" Id="noLink" >' + LinkName + '</a>';
  
  return str;
}


//リンクタグ作成処理
function createeGadgetLinkTag(GadgetFlg,LinkUrl,LinkName,TargetType){

  var str = "";
  
  if(TargetType == ""){
    if(GadgetFlg == 0){
      str += '<a href="' + LinkUrl + '" class="menuHeaderText"><font class="headerText">' + LinkName + '</font></a>';
    }else{
      str += '<a href="' + LinkUrl + '" class="menuHeaderText">';
    }
  }else{
    if(GadgetFlg == 0){
      str += '<a href="' + LinkUrl + '" class="menuHeaderText" target="' + TargetType + '"><font class="headerText">' + LinkName + '</font></a>';
    }else{
      str += '<a href="' + LinkUrl + '" class="menuHeaderText" target="' + TargetType + '">';
    }
  }
  
  return str;
}


//オンクリックURL処理
//URLリンクパラメータがオンクリック用の場合
function createGadgetOnClick(GadgetFlg,LinkName,LinkUrl){
  
  var str = "";
  
  if(GadgetFlg == 0){
    str += "<a href=\"\" class=\"menuHeaderText\" OnClick=\"" + funcCheck(LinkUrl) + "return false;\"><font class=\"headerText\">" + LinkName + "</font></a>";
  }else{
    str += "<a href=\"\" class=\"menuHeaderText\" OnClick=\"" + funcCheck(LinkUrl) + "return false;\">";
  }
  
  return str;
}

//スクリーンID移動用
function createGadgetLinkMov(GadgetFlg,LinkName,ScrnId,FuncId){
  
  var str = "";
  
  if(GadgetFlg == 0){
    str += '<a href="" class="menuHeaderText" OnClick="mnuMainGo(\'' + ScrnId + '\',\'' + FuncId + '\');return false;"><font class="headerText">' + LinkName + '</font></a>';
  }else{
    str += '<a href="" class="menuHeaderText" OnClick="mnuMainGo(\'' + ScrnId + '\',\'' + FuncId + '\');return false;">';
  }
  
  return str;
}


function createGadgetFormDate(GadgetFlg,LinkName,LinkUrl,TargetType,FormType,FormName,ParamName1,ParamType1,ParamName2,ParamType2,ParamName3,ParamType3,ParamName4,ParamType4,ParamName5,ParamType5,FreeParamName1,FreeParam1,FreeParamName2,FreeParam2,FreeParamName3,FreeParam3,FreeParamName4,FreeParam4,FreeParamName5,FreeParam5){
  var str = "";
  
  var paramData = "";
  
  if(FormType == "1"){
    paramData = "submitForm('" + LinkUrl + "','" + TargetType + "','" + FormType + "','" + FormName + "','" + ParamName1 + "','" + ParamType1 + "','" + ParamName2 + "','" + ParamType2 + "','" + ParamName3 + "','" + ParamType3 + "','" + ParamName4 + "','" + ParamType4 + "','" + ParamName5 + "','" + ParamType5 + "','" + FreeParamName1 + "','" + FreeParam1 + "','" + FreeParamName2 + "','" + FreeParam2 + "','" + FreeParamName3 + "','" + FreeParam3 + "','" + FreeParamName4 + "','" + FreeParam4 + "','" + FreeParamName5 + "','" + FreeParam5 + "')";
    
    if(GadgetFlg == 0){
      str += '<a href="" class="menuHeaderText" OnClick="' + paramData + ';return false;"><font class="headerText">' + LinkName + "</font></a>";
    }else{
      str += '<a href="" class="menuHeaderText" OnClick="' + paramData + ';return false;">';
    }
  }else{
    var paraNames = new Array(ParamName1,ParamName2,ParamName3,ParamName4,ParamName5,FreeParamName1,FreeParamName2,FreeParamName3,FreeParamName4,FreeParamName5);
    var paramTypes = new Array(ParamType1,ParamType2,ParamType3,ParamType4,ParamType5,FreeParam1,FreeParam2,FreeParam3,FreeParam4,FreeParam5);
    var pramStr = "";
    
    for(var i = 0 ; i < paraNames.length ; i++){
      
      if(paraNames[i] != ""){
        if(pramStr == ""){
          pramStr += "?" + paraNames[i] + "=" + setParamType(paramTypes[i]);
        }else{
          pramStr += "&" + paraNames[i] + "=" + setParamType(paramTypes[i]);
        }
      }
    }
    
    if(TargetType == ""){
      if(GadgetFlg == 0){
        str += '<a href="' + LinkUrl + pramStr + '" class="menuHeaderText" ><font class="headerText">' + LinkName + '</font></a>';
      }else{
        str += '<a href="' + LinkUrl + pramStr + '" class="menuHeaderText" >';
      }
    }else{
      if(GadgetFlg == 0){
        str += '<a href="' + LinkUrl + pramStr + '" target="' + TargetType + '" class="menuHeaderText" ><font class="headerText">' + LinkName + '</font></a>';
      }else{
        str += '<a href="' + LinkUrl + pramStr + '" target="' + TargetType + '" class="menuHeaderText" >';
      }
    }
  }
  
  return str;
}
// add end   2010/11/15 T.Oonisi B10-0414 QV画像リンク先DB化対応



// add start 2012/05/11 K.Yoshida B12-0088 Win7ワイド対応
function getNavigatorMemuVista(){
  return getNavigatorMemu("Windows NT 6.0");
}
// add end   2012/05/11 K.Yoshida B12-0088 Win7ワイド対応

// add start 2011/03/28 T.Oonisi J11-0013 iPadレイアウト変更対応
function getNavigatorMemuIphone(){
  return getNavigatorMemu("iPhone");
}

function getNavigatorMemuIpad(){
  return getNavigatorMemu("iPad");
}

function getNavigatorMemu(str){
  
  var navi = navigator.userAgent;
  
  if( navi.indexOf(str) >= 0 ){
    return true;
  }else{
    return false;
  }
}
// add end   2011/03/28 T.Oonisi J11-0013 iPadレイアウト変更対応


/* 2012/05/31 add start T.Yoshida J12-0006 Step2対応 */
var menuDispType2 = "none";
var menuDivHeiht2 = 0;
//サブシステム用メニューリンク表示処理
var CatCnt = 0;
var subCatCnt = 0;
var arrySubCatSize = new Array();
// 2014/08/22 modify start T.Yoshida J14-0008 
//var mainCatStr = "";
var mainCatStr = '<table border=0 cellspacing="0" cellpadding="0" style="table-layout:fixed"><tbody><tr>';
// 2014/08/22 modify end T.Yoshida J14-0008 
var subCatStr = "";


//表示制御
function dispMainCatMenu(iFlg){
  var height = 0;

  setMenuPosition(iFlg);
  document.all.item("mainCatMenu" + iFlg).style.display = "block";
/* 2012/07/10 add start T.Yoshida B12-0146 */
  document.all.item("mainCatTitle" + iFlg).className = "mainMenuButton2";
/* 2012/07/10 add end T.Yoshida B12-0146 */
}

function closeMainCatMenu(iFlg){
  document.all.item("mainCatMenu" + iFlg).style.display = "none";
/* 2012/07/10 add start T.Yoshida B12-0146 */
  document.all.item("mainCatTitle" + iFlg).className = "mainMenuButton";
/* 2012/07/10 add end T.Yoshida B12-0146 */

}

function setMenuPosition(iFlg){
  var rect;
  var width = 0;
  var docWidth = document.body.clientWidth; //ブラウザ横

  rect = document.all.item("mainCatTitle" + iFlg).getBoundingClientRect();
  iTop = rect.top + document.all.item("mainCatTitle" + iFlg).offsetHeight - 4 + document.body.scrollTop;
  width = parseInt(document.all.item("mainCatMenu" + iFlg).style.width);

  if( (docWidth - rect.left) < width && width < docWidth ){
    iLeft = docWidth - width - 10;
  }else{
    iLeft = rect.left + document.body.scrollLeft;
  }
  document.all.item("mainCatMenu" + iFlg).style.top = iTop;
  document.all.item("mainCatMenu" + iFlg).style.left = iLeft;
}


//メインメニュー表示初期設定
function menuLinkInit2(){
  
    menuDispType2 = "none";
}


function writeMainCategory(strCatNo, strViewName){
  var str = "";

  subCatCnt = 0;
  CatCnt = CatCnt + 1;
  var strMainCat = (CatCnt > 9 ? CatCnt : ("0"+CatCnt) );

// 2014/08/22 modify start T.Yoshida J14-0008 
//	str += '<input type="button" id="mainCatTitle' + strMainCat + '" class="mainMenuButton" value="'+strViewName+'"';
  str += '<td id="mainCatTitle' + strMainCat + '" class="mainMenuButton" ';
// 2014/08/22 modify end T.Yoshida J14-0008 
  str += ' onFocus="this.blur();return false;" OnMouseOver="dispMainCatMenu(\'' + strMainCat + '\');return false;" OnMouseOut="closeMainCatMenu(\'' + strMainCat + '\');return false;" > ';
// 2014/08/26 add start T.Yoshida J14-0008
  str += strViewName+'</td>';
// 2014/08/26 add end T.Yoshida J14-0008
  return str;
}

function writeStartSubCategory(strCatNo){
  var str = "";
  var iTop = 0;
  var iLeft = 2;
  var strMainCat = (CatCnt > 9 ? CatCnt : ("0"+CatCnt) );

  str += '<div id="mainCatMenu' + strMainCat + '" class="menuSubCategoryGrp" align="left"  style="overflow:auto;width:200px;position:absolute;top:' + iTop + 'px;left:' + iLeft + 'px;z-index:2000;display:' + menuDispType2 + ';" onFocus="this.blur();return false;" OnMouseOver="dispMainCatMenu(\'' + strMainCat + '\');return false;" OnMouseOut="closeMainCatMenu(\'' + strMainCat + '\');return false;" >';

  str += '	<table border="0" cellspacing="0" cellpadding="0" >';
  str += '		<tr valign="top">';

  return str;
}

function writeEndSubCategory(){
  var str = "";

  arrySubCatSize[CatCnt-1] = subCatCnt;

  str += '		</tr>';
  str += '	</table>';
  str += '</div>';
  return str;
}

function writeSubCategory(strCatNo, strSubCatNo, ViewName){
  var str = "";
  var strMainCat = (CatCnt > 9 ? CatCnt : ("0"+CatCnt) );

  subCatCnt = subCatCnt + 1;

  var strSubCat = (subCatCnt > 9 ? subCatCnt : ("0"+subCatCnt) );

  str += '			<td style="padding-left:10">';
// 2014/08/22 add start T.Yoshida J14-0008
  if( ViewName != "" ){
// 2014/08/22 add end T.Yoshida J14-0008
  str += '					<table align="top" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;word-break:break-all;margin-top:5">';
  str += '					<tbody>';
  str += '						<tr style="display:none;">';
/* 2012/07/10 modify start T.Yoshida B12-0146 
  str += '							<td width="180">&nbsp;</td>';
  str += '						</tr>';
  str += '						<tr><td nowrap class="mainMenuHead">' + ViewName + '</td></tr>';
 */
  str += '							<td width="30"></td>';
  str += '							<td width="150"></td>';
  str += '						</tr>';
  str += '						<tr height="18"><td class="subCategoryHead" style="margin-top:0px;padding-left:0px;padding-top:0px;padding-bottom:0px;"><img src="img/menuLinkIcon4.png"></td>';
  str += '							<td nowrap class="subCategoryHead" width="150">' + ViewName + '</td></tr>';
/* 2012/07/10 modify end T.Yoshida B12-0146 */ 
  str += '					</table>';
// 2014/08/22 add start T.Yoshida J14-0008
  }
// 2014/08/22 add end T.Yoshida J14-0008
  str += '				<div id="mainSubMenu' + strMainCat + strSubCat + '" class="menuSubCategory" style="overflow-y:auto;width:190px;z-index:4000;display:"">';
  str += '					<table align="top" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;word-break:break-all;">';
  str += '					<tbody>';
  str += '						<tr style="display:none;">';
// 2014/08/22 modify start T.Yoshida J14-0008 
//	str += '							<td width="20">&nbsp;</td>';
//	str += '							<td width="160">&nbsp;</td>';
  str += '							<td width="180">&nbsp;</td>';
// 2014/08/22 modify end T.Yoshida J14-0008 
  str += '						</tr>';

  return str;
}


function writeEndList(){
  var str = "";
  
  str += '					</table>';
  str += '				</div>';
  str += '			</td>';
  return str;
}

function setSubCatSize(){
  var childNode;
  var listno = 0;
  var strMainCat = "";
  var docWidth = document.body.clientWidth; //ブラウザ横
  var width = 0;

  for( var i = 0; i < arrySubCatSize.length; i++ ){
    strMainCat = ((i+1) > 9 ? (i+1) : ("0"+(i+1)) );
    width = arrySubCatSize[i]*190 + (arrySubCatSize[i]+1)*12;
    if( docWidth < width ){
      document.all.item("mainCatMenu" + strMainCat).style.width = docWidth - 50;
    }else{
      document.all.item("mainCatMenu" + strMainCat).style.width = width;
    }
  }
}

/* 2012/05/31 add end T.Yoshida J12-0006 Step2対応 */
