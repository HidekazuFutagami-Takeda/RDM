var menuWiteImg = '<img src="img/menuLinkIcon1.png" style="margin-bottom:2px;">';

// 《メインメニュー》
// Write NavigationBar
function writeNaviBarStart(intNumber){
  
/*
  document.write( "<DIV id=\"NaviBar" + intNumber + "\">");
  document.write( "<TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><TBODY><TR>");
*/
  var str = "";
  str += "<DIV id=\"NaviBar" + intNumber + "\">";
  str += "<TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><TBODY><TR>";
  
  return str;
}

function writeNaviMenu(intNumber, strViewName, strLinkHref,boldFlg,newFlg){
  
/*
  document.write("<TD nowrap id=\"NaviMenuTD" + intNumber + "\" class=\"NaviMenu\">");
  document.write("<A  class=\"NaviMenu\" id=\"NaviMenuLink" + intNumber + "\">" + strViewName + "</A>");
  document.write("</TD>");
*/

  var str = "";
  str += '<TD id="NaviMenuTD' + intNumber + '" class="NaviMenu">';
  str += boldCheck('<A  class="NaviMenu" id="NaviMenuLink' + intNumber + '">' + strViewName + '</A>',boldFlg) + createNewImg(newFlg);
  str += '</TD>';
  
  return str;
}

function writeNaviBarEnd(){
  /*
  document.write("</TR></TBODY></TABLE></DIV>");
  */
  
  return "</TR></TBODY></TABLE></DIV>";
}


// 《サブメニュー》
// Write NavigationMenu
function writeMenuBlockStart(intNumber){
  
  /*
  document.write("<DIV class=\"MenuBlock\" id=\"MenuBlockDIV" + intNumber + "\">");
  document.write( "<TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=200><TBODY>");
  */
  
  var str = "";
  
  // modify start 2011/03/28 T.Oonisi J11-0013 iPadレイアウト変更対応
  //str += "<DIV class=\"subMenuBlock\" id=\"MenuBlockDIV" + intNumber + "\">";
  if(getNavigatorMemuIpad()){
    str += "<DIV>";
  }else{
    str += "<DIV class=\"subMenuBlock\" id=\"MenuBlockDIV" + intNumber + "\">";
  }
  // modify end   2011/03/28 T.Oonisi J11-0013 iPadレイアウト変更対応
  
  str += "<TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"margin-right:12px;\"><TBODY>";
  
  return str;
}

//共通部品化した為不必要
function writeMenuItem(strViewName, strLinkHref1, strLinkHref2,boldFlg,newFlg){
  /*
  document.write("<TR><TD nowrap><DIV class=\"MenuItem\">");
  document.write(" □ <A href=\"" + "\" class=\"MenuItem\" OnClick=\"mnuMainGo('" + strLinkHref1 + "','" + strLinkHref2 + "');return false;\"" + ">" + strViewName + "</A>");
  document.write("</DIV></TD></TR>");
  */
//alert(strViewName+" "+strLinkHref1+" "+strLinkHref2);

  var str = "";
  str += "<TR  style=\"height:16px;padding-top:0px;padding-bottom:0px;\"><TD nowrap valign=\"middle\" style=\"padding-left:0px;padding-top:0px;padding-bottom:0px;\"><DIV class=\"MenuItem\">";
  str += " " + menuWiteImg +  " <A href=\"" + "\" class=\"MenuItem\" OnClick=\"mnuMainGo('" + strLinkHref1 + "','" + strLinkHref2 + "');return false;\"" + ">" + boldCheck(strViewName,boldFlg) + "</A>" + createNewImg(newFlg);
  str += "</DIV></TD></TR>";
  
  return str;
}

//共通部品化した為不必要
function writeMenuItem2(strViewName, strLinkHref1,strLinkHref2,boldFlg,newFlg){

/*
  document.write("<TR><TD nowrap><DIV class=\"MenuItem\"> □ <A ");

  if(strLinkHref1 != "" && strLinkHref1 != null){
    document.write("href=\"" + strLinkHref1 + "\"");
  }else{
    document.write("style=\"cursor:hand;\"");
  }


  if(strLinkHref2 != "" && strLinkHref2 != null)
    document.write(" target=\"" + strLinkHref2 + "\"");

  document.write(" class=\"MenuItem\" >" + strViewName + "</A></DIV></TD></TR>");
*/

  var str = "";
  str += "<TR  style=\"height:16px;padding-top:0px;padding-bottom:0px;\"><TD nowrap valign=\"middle\" style=\"padding-left:0px;padding-top:0px;padding-bottom:0px;\"><DIV class=\"MenuItem\"> " + menuWiteImg +  " <A ";
  
  if(strLinkHref1 != "" && strLinkHref1 != null){
    str += "href=\"" + strLinkHref1 + "\"";
  }else{
    str += "style=\"cursor:hand;\"";
  }
  
  if(strLinkHref2 != "" && strLinkHref2 != null)
    str += " target=\"" + strLinkHref2 + "\"";
    
    
  str += " class=\"MenuItem\" >" + boldCheck(strViewName,boldFlg) + "</A>" + createNewImg(newFlg) + "</DIV></TD></TR>";
  
  return str;
  
}

//共通部品化した為不必要
//add start 2008/10/17 T.Saino Vista対応
/**
 * <pre>
 * wirteMenuItem2を使用して
 * 「ウィンドウは、表示中の Web ページにより閉じられようとしています。」
 * が表示される場合は、こちらを使用してください。
 * 処理内容自体は、wirteMenuItem2 と同じです。
 * </pre>
 */
 function writeMenuItem4(strViewName, strLinkHref1) {

/*
  document.write("<TR><TD nowrap><DIV class=\"MenuItem\"> □ <A ");

  if(strLinkHref1 != "" && strLinkHref1 != null){
    document.write("href=\"#\" onClick=\"window.open('" + strLinkHref1 + "');\"");
  }else{
    document.write("style=\"cursor:hand;\"");
  }

  document.write(" class=\"MenuItem\" >" + strViewName + "</A></DIV></TD></TR>");
*/
  
  var str = "";
  str += "<TR style=\"height:16px;padding-top:0px;padding-bottom:0px;\"><TD nowrap valign=\"middle\" style=\"padding-left:0px;padding-top:0px;padding-bottom:0px;\"><DIV class=\"MenuItem\"> " + menuWiteImg +  " <A ";

  if(strLinkHref1 != "" && strLinkHref1 != null){
    str += "href=\"#\" onClick=\"window.open('" + strLinkHref1 + "');\"";
  }else{
    str += "style=\"cursor:hand;\"";
  }

  str += " class=\"MenuItem\" >" + strViewName + "</A></DIV></TD></TR>";

  return str;
}
//add end 2008/10/17 T.Saino

//共通部品化した為不必要
// add start 2008/08/11 t.tamura サーバリプレース
// 新サーバへの遷移（メニューが旧サーバ、遷移先が新サーバである場合に使用）
function writeMenuItem3(strViewName, strLinkHref1, strLinkHref2){
  /*
  document.write("<TR><TD nowrap><DIV class=\"MenuItem\">");
  document.write(" □ <A href=\"" + "\" class=\"MenuItem\" OnClick=\"mnuMainGo3('" + strLinkHref1 + "','" + strLinkHref2 + "');return false;\"" + ">" + strViewName + "</A>");
  document.write("</DIV></TD></TR>");
  */
//alert(strViewName+" "+strLinkHref1+" "+strLinkHref2);

  var str = "";
  
  str += "<TR  style=\"height:16px;padding-top:0px;padding-bottom:0px;\"><TD nowrap valign=\"middle\" style=\"padding-left:0px;padding-top:0px;padding-bottom:0px;\"><DIV class=\"MenuItem\">";
  str += " " + menuWiteImg +  " <A href=\"" + "\" class=\"MenuItem\" OnClick=\"mnuMainGo3('" + strLinkHref1 + "','" + strLinkHref2 + "');return false;\"" + ">" + strViewName + "</A>";
  str += "</DIV></TD></TR>";
  
  return str;
}
// add end 2008/08/11 t.tamura


function writeMenuBlockEnd(){
  /*
  document.write("</TBODY></TABLE></DIV>");
  */
  
  return "</TBODY></TABLE></DIV>";
}

// add S.hosokawa 2003/7/11 卸暫定システム対応
// add start 2009/4/21 M.kumazawa method修正
function mnuPageChange(url,jgiNo){
/*
  document.write("<form style=\"visibility:hidden;position:absolute;\" name=\"fmIntiei02\" action=\"" + url + "\" method=\"POST\">");
//	document.write("<form style=\"visibility:hidden;position:absolute;\" name=\"fmIntiei02\" action=" + url + " method=\"GET\">")
  document.write("<input type=\"hidden\" name=\"jgiNo\" value=\"" + jgiNo + "\"></input>");
  document.write("</form>");
  document.write("<input type=\"hidden\" name=\"dummy\" value=\"\"></input>");
  document.fmIntiei02.submit();
*/
  
  mainMenuFmIntiei02();
  
  if(document.fmIntiei02){
    document.fmIntiei02.action = url;
    document.fmIntiei02.jgiNo.value = jgiNo;
    // delete start 2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    //appendForm(document.fmIntiei02);
    // delete end   2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    document.fmIntiei02.submit();
  }else if(document.all.fmIntiei02){
    document.all.fmIntiei02.action = url;
    document.all.fmIntiei02.jgiNo.value = jgiNo;
    // delete start 2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    //appendForm(document.all.fmIntiei02);
    // delete end   2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    document.all.fmIntiei02.submit();
  }

  
}
// add end 2009/4/21 M.kumazawa  method修正
// add start 2008/11/05 t.fukushima 特薬システム及びMTC遷移時に従業員番号送信
function mnuMTCGo(daikoJgiNo, jgiNo){
  
  mainMenuFmMTC1();
  
  if(document._fmMTC1){
    document._fmMTC1.windowName.value = self.name;
    if(window.opener!=null){
      document._fmMTC1.openerName.value = window.opener.name;
    }
    document._fmMTC1.DAIKO_JGI_NO.value = daikoJgiNo;
    document._fmMTC1.JGI_NO.value = jgiNo;
    document._fmMTC1.action = "http://inteig01.takeda.co.jp/MTC/sxstart.do";
    // delete start 2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    //appendForm(document._fmMTC1);
    // delete end   2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    document._fmMTC1.submit();
  }else if(document.all._fmMTC1){
    document.all._fmMTC1.windowName.value = self.name;
    if(window.opener!=null){
      document.all._fmMTC1.openerName.value = window.opener.name;
    }
    document.all._fmMTC1.DAIKO_JGI_NO.value = daikoJgiNo;
    document.all._fmMTC1.JGI_NO.value = jgiNo;
    document.all._fmMTC1.action = "http://inteig01.takeda.co.jp/MTC/sxstart.do";
    // delete start 2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    //appendForm(document.all._fmMTC1);
    // delete end   2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    document.all._fmMTC1.submit();
  }
  
  
}
// modify start 2008/12/10 H.Kawasaki windowサイズ変更対応
function mnuTokuyakuSysGo(jgiNo){
  
  /*
  window.open("","win1","width=1018,height=670,resizable=no,status=yes,toolbar=no,scrollbars=yes,titlebar=no,top=5,left=0");
  document._fmTokuyaku1.windowName.value = self.name;
  if(window.opener!=null){
    document._fmTokuyaku1.openerName.value = window.opener.name;
  }
  document._fmTokuyaku1.JGI_NO.value = jgiNo;
  document._fmTokuyaku1.action = "http://inteig01.takeda.co.jp/SDM/sxstart.do";
  document._fmTokuyaku1.submit();
  */
  
  mainMenuFmTokuyaku1();
  
  window.open("","win1","width=1018,height=670,resizable=no,status=yes,toolbar=no,scrollbars=yes,titlebar=no,top=5,left=0");

  //画面にFORMが存在している場合
  if(document._fmTokuyaku1){
    document._fmTokuyaku1.windowName.value = self.name;
    
    if(window.opener!=null){
      document._fmTokuyaku1.openerName.value = window.opener.name;
    }
    
    document._fmTokuyaku1.JGI_NO.value = jgiNo;
    document._fmTokuyaku1.action = "http://inteig01.takeda.co.jp/SDM/sxstart.do";
    // delete start 2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    //appendForm(document._fmTokuyaku1);
    // delete end   2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    document._fmTokuyaku1.submit();
  
  //画面にフォームが存在していない場合
  }else if(document.all._fmTokuyaku1){
    document.all._fmTokuyaku1.windowName.value = self.name;
    
    if(window.opener!=null){
      document.all._fmTokuyaku1.openerName.value = window.opener.name;
    }
    
    document.all._fmTokuyaku1.JGI_NO.value = jgiNo;
    document.all._fmTokuyaku1.action = "http://inteig01.takeda.co.jp/SDM/sxstart.do";
    // delete start 2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    //appendForm(document.all._fmTokuyaku1);
    // delete end   2010/07/01 T.Oonisi B10-0246 他社連携用処理削除の為
    document.all._fmTokuyaku1.submit();
  }
}
// modify end 2008/12/10 H.Kawasaki windowサイズ変更対応
function writeMenuItemTokuyaku1(strViewName, strLinkHref1,strLinkHref2, jgiNo){
  /*
  document.write("<TR><TD nowrap><DIV class=\"MenuItem\"> □ <A ");
  if(strLinkHref1 != "" && strLinkHref1 != null){
    document.write("href=\"" + strLinkHref1 + "\"");
  }else{
    document.write("style=\"cursor:hand;\"");
  }

  if(strLinkHref2 != "" && strLinkHref2 != null) {
    document.write(" target=\"" + strLinkHref2 + "\"");
  }
  document.write(" onClick=\"mnuTokuyakuGo('" + jgiNo + "');return false;\"");
  document.write(" class=\"MenuItem\" >" + strViewName + "</A></DIV></TD></TR>");
  */
  
  var str = "";
  
  str += "<TR><TD nowrap><DIV class=\"MenuItem\"> " + menuWiteImg +  " <A ";
  
  if(strLinkHref1 != "" && strLinkHref1 != null){
    str += "href=\"" + strLinkHref1 + "\"";
  }else{
    str += "style=\"cursor:hand;\"";
  }

  if(strLinkHref2 != "" && strLinkHref2 != null) {
    str += " target=\"" + strLinkHref2 + "\"";
  }
  
  str += " onClick=\"mnuTokuyakuSysGo('" + jgiNo + "');return false;\"";
  str += " class=\"MenuItem\" >" + strViewName + "</A></DIV></TD></TR>";
  
  return str;
}
// add end   2008/11/05 t.fukushima 特薬システム及びMTC遷移時に従業員番号送信


// add start 2008/12/16 Yo.Nakamura 文献複写　武サ廃止対応
// 内部メニューのフォーマット対応
function writeMenuItemDcc(strViewName){
  
  /*
  document.write("<TR><TD nowrap><DIV class=\"MenuItem\">");
  document.write(" □ <A href=\"" + "\" class=\"MenuItem\" OnClick=\"mnuDccGo();return false;\"" + ">" + strViewName + "</A>");
  document.write("</DIV></TD></TR>");
  */
  
  var str = "";
  
  str += "<TR><TD nowrap><DIV class=\"MenuItem\">";
  str += " " + menuWiteImg +  " <A href=\"" + "\" class=\"MenuItem\" OnClick=\"mnuDccGo();return false;\"" + ">" + strViewName + "</A>";
  str += "</DIV></TD></TR>";
  
  return str;
}
// add end 2008/12/16 Yo.Nakamura 文献複写　武サ廃止対応

// add start 2009/07/23 H.Kawasaki B09-0300 OPERAリンク修正対応
function writeMenuOpr(strViewName, strLinkHref1,strLinkHref2,strLinkHref3,strLinkHref4){

/*
  document.write("<TR><TD nowrap><DIV class=\"MenuItem\"> □ <A ");

  if(strLinkHref1 != "" && strLinkHref1 != null){
    document.write("href=\"" + strLinkHref1 + "\"");
  }else{
    document.write("style=\"cursor:hand;\"");
  }

  if(strLinkHref2 != "" && strLinkHref2 != null)
    document.write(" target=\"" + strLinkHref2 + "\"");

  if(strLinkHref3 != "" && strLinkHref3 != null)
    document.write(" onfocus=\"" + strLinkHref3 + "\"");

  if(strLinkHref4 != "" && strLinkHref4 != null)
    document.write(" onmouseover=\"" + strLinkHref4 + "\"");

  document.write(" class=\"MenuItem\" >" + strViewName + "</A></DIV></TD></TR>");
*/


  var str = "";
  
  // modify start 2010/09/08 T.Oonisi B10-0247 メニューDB化対応
  /*
  str += "<TR><TD nowrap><DIV class=\"MenuItem\"> " + menuWiteImg +  " <A ";

  if(strLinkHref1 != "" && strLinkHref1 != null){
    str += "href=\"" + strLinkHref1 + "\"";
  }else{
    str += "style=\"cursor:hand;\"";
  }

  if(strLinkHref2 != "" && strLinkHref2 != null)
    str += " target=\"" + strLinkHref2 + "\"";

  if(strLinkHref3 != "" && strLinkHref3 != null)
    str += " onfocus=\"" + strLinkHref3 + "\"";

  if(strLinkHref4 != "" && strLinkHref4 != null)
    str += " onmouseover=\"" + strLinkHref4 + "\"";

  str += " class=\"MenuItem\" >" + strViewName + "</A></DIV></TD></TR>";
  */

  var arr = new Array();
  arr[arr.length] = strViewName;
  arr[arr.length] = strLinkHref1;
  arr[arr.length] = strLinkHref2;
  arr[arr.length] = strLinkHref3;
  arr[arr.length] = strLinkHref4;
  
  return arr;
  
  // modify end   2010/09/08 T.Oonisi B10-0247 メニューDB化対応
}
// add end 2009/07/23 H.Kawasaki B09-0300 OPERAリンク修正対応
