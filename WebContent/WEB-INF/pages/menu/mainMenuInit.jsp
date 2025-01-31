<%--
/*
 *******************************************************************************
 */
/**
 * <pre>
 * トップメニューのインクルード部分です。
 * 各アプリケーションでインクルードして利用します。
 * インクルードは静的埋め込み方式とします。
 * 例&lt;%@ include file="/menu/mnuTop00.jsp" %&gt;
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author
 */
--%>
<%@page import="jp.co.takeda.rdm.common.BaseInfoHolder"%>
<%@page import="jp.co.takeda.rdm.common.LoginInfo"%>
<%@ page
  language="java"
  import="java.util.*,java.text.*,jp.co.takeda.rdm.util.AppConstant,jp.co.takeda.rdm.common.MainMenuData"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set id="portletIdFlg" value='#request.getParameter("_portlet_id") != null'/>
<s:set id="renderModeFlg" value='#request.getParameter("_render_mode") != null'/>
<s:set id="loginInfoFlg" value='#session != null && #session.UserInfoKey != null'/>
<%
  boolean portletIdFlg = false;

  boolean renderModeFlg = false;
  boolean loginInfoFlg = false;

  if(request.getParameter("_portlet_id") != null){
    portletIdFlg = true;
  }

  if(request.getParameter("_render_mode") != null){
    renderModeFlg = true;
  }

  //if(session != null && session.getAttribute("_loginInfo") != null){
  if(session != null && session.getAttribute(BaseInfoHolder.USERINFO_KEY) != null){
    loginInfoFlg = true;
  }

  boolean outSideFlg = false;

  String serverPath = AppConstant.HOMEPAGE_URL;

  String actScreenId = "";
  String actFunctionId = "";

  String userId = "";
  String directExecType = "";
  String returnUrl      = "";
%>
<s:set id="serverPath" value="%{@jp.co.takeda.rdm.util.AppConstant@HOMEPAGE_URL}"/>
<s:set id="loginData" value="#session.UserInfoKey"/>
<s:set id="mainMenu" value="#session.mainMenuData"/>

<s:set id="outSideFlg" value="#loginInfoFlg && (#loginData.screenId == 'AdminDocCopy'.|| loginData.getScreenId() == 'TkServiceDocCopy')"/>
<% if(loginInfoFlg){ %>
  <%
  LoginInfo loginData = (LoginInfo)request.getSession().getAttribute(BaseInfoHolder.USERINFO_KEY);
  %>

  <%
    outSideFlg = (!"AdminDocCopy".equals(loginData.getScreenId()) &&
           !"TkServiceDocCopy".equals(loginData.getScreenId()))? false: false;

    actScreenId = loginData.getScreenId();
    actFunctionId = loginData.getFunctionId();
    userId = loginData.getUserId();
    directExecType	= loginData.getDirectExecType();	// J13-0006 2013/6/21 uchida add
    returnUrl		= loginData.getReturnUrl();			// J13-0006 2013/6/21 uchida add

    actScreenId = "";
    actFunctionId = "";

    directExecType = "";
    returnUrl      = "";

  %>
<% } %>

<%
  MainMenuData mainMenu = null;

  String pmsJgiNo = "";
  String pmsPass1 = "";
  String pmsPass2 = "";
  String sasJgiNo = "";
  String sasPass = "";
  String dccJgiNo = "";
  String dccPass  = "";
  int s = 0;

  if(session.getAttribute(AppConstant.SESKEY_MENU_DATA) != null){
    mainMenu = (MainMenuData)session.getAttribute(AppConstant.SESKEY_MENU_DATA);


    dccJgiNo = mainMenu.getSasJgiNo() != null ? mainMenu.getSasJgiNo().toString() : "";
    dccPass = mainMenu.getSasPass() != null ? mainMenu.getSasPass().toString() : "";
    sasJgiNo = mainMenu.getSasJgiNo() != null ? mainMenu.getSasJgiNo().toString() : "";
    sasJgiNo = "0000000" + sasJgiNo;
    s = sasJgiNo.length() - 7;
    sasJgiNo = sasJgiNo.substring(s);
    sasJgiNo = !sasJgiNo.equals("") ? ("C" + sasJgiNo).substring(0, 7) : "";
    sasPass = mainMenu.getSasPass() != null ? mainMenu.getSasPass().toString() : "";
    pmsJgiNo = mainMenu.getSasJgiNo() != null ? mainMenu.getSasJgiNo().toString() : "";
    pmsPass1 = mainMenu.getPmsPass1() != null ? mainMenu.getPmsPass1().toString() : "";
    pmsPass2 = mainMenu.getPmsPass2() != null ? mainMenu.getPmsPass2().toString() : "";

%>
  <script type="text/javascript">
    //actFlg
    postJgiNo = "<%= mainMenu.getActorJgiNo() %>";
    menuJgiNo = "<%= mainMenu.getJgiNo() %>";							//00：ログイン従業員番号(代行含む)
    menuPostJgiNo = "<%= mainMenu.getActorJgiNo() %>";					//01：画面従業員番号
    menuUserIDLow = "<%= userId.toLowerCase() %>";						//02：ユーザID（LOWER）
    menuUserIDUpp = "<%= userId.toUpperCase() %>";						//03：ユーザID（UPPER）
    menuPmsJgiNo = "<%= pmsJgiNo %>";									//11：pmsJgiNo
    menuPmsPass1 = "<%= pmsPass1 %>";									//12：pmsPass1
    menuPmsPass2 = "<%= pmsPass2 %>";									//13：pmsPass2
    menuSasJgiNo = "<%= sasJgiNo %>";									//21：sasJgiNo
    menuSasPass = "<%= sasPass %>";										//22：sasPass
    menuDccJgiNo = "<%= dccJgiNo %>";									//31：dccJgiNo
    menuDccPass = "<%= dccPass %>";										//32：dccPass
    menuScreenId = "<%= actScreenId %>";
    menuFunctionId = "<%= actFunctionId %>";

  <% if(!"S0110403".equals(mainMenu.getMenuCode()) && !"S0110405".equals(mainMenu.getMenuCode())){ %>
      menuLinkInit(menuScreenId,menuFunctionId);
  <% } %>

  </script>
<form style="visibility:hidden;position:absolute;" name="_menuInitForm" method="POST">
  <input type="text" name="postJgiNo"  value="<%= mainMenu.getActorJgiNo() %>"></input>
  <input type="text" name="menuJgiNo"   value="<%= mainMenu.getJgiNo() %>"></input>
  <input type="text" name="menuPostJgiNo"   value="<%= mainMenu.getActorJgiNo() %>"></input>
  <input type="text" name="menuUserIDLow"  value="<%= userId.toLowerCase() %>"></input>
  <input type="text" name="menuUserIDUpp"   value="<%= userId.toUpperCase() %>"></input>
  <input type="text" name="menuPmsJgiNo"  value="<%= pmsJgiNo %>"></input>
  <input type="text" name="menuPmsPass1"   value="<%= pmsPass1 %>"></input>
  <input type="text" name="menuPmsPass2"  value="<%= pmsPass2 %>"></input>
  <input type="text" name="menuSasJgiNo"   value="<%= sasJgiNo %>"></input>
  <input type="text" name="menuSasPass"   value="<%= sasPass %>"></input>
  <input type="text" name="menuDccJgiNo"  value="<%= dccJgiNo %>"></input>
  <input type="text" name="menuDccPass"  value="<%= dccPass %>"></input>
</form>
<% } %>
