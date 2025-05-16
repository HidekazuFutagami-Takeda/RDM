<%--
/**
 * <pre>
 * メニュー時間外用(正式版)の汎用画面JSPです。
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author
 */
--%>
<%@page import="jp.co.takeda.rdm.common.AuthorizationServiceData"%>
<%@page import="jp.co.takeda.rdm.common.BaseInfoHolder"%>
<%@ page
  language="java"
  import="java.util.*,java.text.*"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  errorPage="error/comError.jsp"
  isErrorPage="false"
  info="comRelInvalidLogin"
  contentType="text/html;charset=UTF-8"
%>
<%@ page import="jp.co.takeda.rdm.common.LoginInfo" %>
<%
	String directExecType = null;
  String returnUrl      = null;
  if (session != null && session.getAttribute(BaseInfoHolder.USERINFO_KEY) != null) {
    LoginInfo loginInfo = (LoginInfo)session.getAttribute(BaseInfoHolder.USERINFO_KEY);
    directExecType = loginInfo.getDirectExecType();
    returnUrl      = loginInfo.getReturnUrl();
  }
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	AuthorizationServiceData authorizationServiceData = (AuthorizationServiceData)request.getAttribute("AuthorizationServiceData");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <title>メニュー時間外</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="<%= request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
<%@ include file="mapsJsInclude00.jsp" %>
</head>
<body class="comPage">
  <div id="menu">
  <jsp:include page="../menu/mnuTop02.jsp" flush="true" />
  </div>

  <table width="80%" align="center" border="0">
  <tbody>
    <%-- インラインフレームの場合は空行を入れる --%>
    <script type="text/javascript">
    if(window.parent.frames.length <= 0){
      document.write('			<tr height="30pt"><td>&nbsp;</td></tr>');
    }
    </script>
    <tr>
      <td class="comRegionHeaderColor" width="100%">
        <table class="comPortalBody" bgcolor="#FFFFFF" border="0">
        <tbody>
          <tr>
            <td style="padding:20px 80px 0px 80px;">
              <table border="0" align="center">
                <tr>
                  <td><img border="0" src="<%= request.getContextPath() %>/img/ani_109.gif">&nbsp;&nbsp;</td>
                  <td nowrap style="color:#336699;font-weight:bold;">このメニュー(機能)は利用時間外です。</td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td style="padding:15px 80px 0px 80px;">
              <table border="0" align="center">
                <tr>
                  <td style="font-size:8pt;padding-left:20px;" colspan="3">
                    現在このメニュー(機能)は利用可能時間外のため、利用できません。<br/>
                    利用可能時間に再度アクセスして下さい。
                  </td>
                </tr>
                <tr><td colspan="3">&nbsp;</td></tr>
                <tr>
                  <td width="10%"></td>
                  <td width="10%" style="font-size:8pt;">
                    <nobr>メニュー名：</nobr>
                  </td>
                  <td align="left" style="font-size:8pt;">
                    <nobr><s:property value="#request.AuthorizationServiceData.scrnName"/></nobr>
                  </td>
                </tr>
                <tr>
                  <td></td>
                  <td style="font-size:8pt;">
                    <nobr>メニューご利用可能時間：</nobr>
                  </td>
                  <td align="left" style="font-size:8pt;">
                    <nobr><s:property value="#request.AuthorizationServiceData.startTime"/>～<s:property value="#request.AuthorizationServiceData.endTime"/></nobr>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td align="center" style="padding-top:15px;padding-bottom:15px;">
<%
  if (directExecType == null || directExecType.equalsIgnoreCase("")) {
%>
              <!-- <a href="#" OnClick="_errorClose();return(false);">ホームへ</a> -->
              <input class="comButton" type="button" style="margin-left:10pt;" name="close" value="閉じる" OnClick="window.close();" />
<%
  } else if (directExecType.equalsIgnoreCase("2")) {
%>
              <input class="comButton" type="button" style="margin-left:10pt;" name="close" value="閉じる" OnClick="window.close();" />
<%
  } else if (directExecType.equalsIgnoreCase("1")) {
%>
              <a class="comBannerSecondaryLink" href="<%= returnUrl %>" target="_top"><font class="comBannerSecondaryLink"><%= "呼び出し元へ" %></font></a>&nbsp;
<%
  }
%>
            </td>
          </tr>
        </tbody>
        </table>
      </td>
    </tr>
  </tbody>
  </table>
  <script type="text/javascript">
    /**
     * <pre>
     * エラー発生時にメニューヘッダーの有無を場合によって切り替えます。
     *   無し：インラインフレーム、ポップアップの場合。
     *   有り：それ以外の場合。
     * </pre>
     */
    if(window.parent.frames.length > 0){
      document.all.item("menu").style.visibility = "hidden";
      document.all.item("menu").style.position = "absolute";
      document.all.item("menu").style.width = "80%";
    } else if(opener!=null){
      document.all.item("menu").style.visibility = "hidden";
      document.all.item("menu").style.position = "absolute";
      document.all.item("menu").style.width = "80%";
    }
  </script>
</body>
</html>
