<%--
 * トップメニューです。
 * 各アプリケーションでインクルードして利用します。
 * インクルードは動的埋め込み方式とします。
 * 動的例)&lt;jsp:include page="../menu/mnuTop02.jsp" flush="true" /&gt;
 * 静的例)&lt;%@ include file="/menu/mnuTop02.jsp" %&gt;
 * </pre>
 * @since 1.0
 * @version $Revision: 1.4 $
 * @author 日立　花
 */
--%>
<%@page import="jp.co.takeda.jkr.common.MainMenuData"%>
<%@ page
  language="java"
  import="java.util.*,java.text.*"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  isErrorPage="false"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 共通トップメニュー読み込み -->
<%@ include file="mnuTop00.jsp" %>
<!-- セカンダリリンク 開始 -->
<s:set name="dateFormat" value="%{new java.text.SimpleDateFormat('yyyy年MM月dd日(E)')}" />
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody>
<s:if test="!#loginInfoFlg || #loginData.directExecType == null || loginData.directExecType != '2'">
  <tr>
    <td align="left">&nbsp;</td>
    <td align="right" colSpan="2">

<s:if test="#directExecType != '1' && returnUrl != null">
      <a href ="<%= returnUrl %>" target="_top" ><font class="comBannerSecondaryLink"><%= "呼び出し元へ" %></font></a>&nbsp;
</s:if>
<s:else>
      <a href ='<s:property value="#serverPath"/>/maps/servlet/control?screenId=Menu&functionId=ViewInit' target="_top" ><font class="comBannerSecondaryLink"><%= "ホームへ" %></font></a>&nbsp;
</s:else>

    </td>
  </tr>
  <s:if test="#mainMenu != null">
    <s:if test="#mainMenu.menuCode != 'S0110403' && #mainMenu.menuCode != 'S0110405'">
    <tr style="display: none;">
      <td colspan="2">
        <img src="img/menuCallIcon.png" alt="メインメニュー" onclick="dispMainMenu();">
      </td>
    </tr>
    </s:if>
  </s:if>
</s:if>
<s:else>
    <tr>
    <td align="Right">
      <input class="comButton" type="button" style="margin-left:10pt;　margin-top:3pt" name="close" value="閉じる" OnClick="window.close();" />
    </td>
    </tr>
</s:else>
</tbody>
</table>
<!-- セカンダリリンク 終了 -->
