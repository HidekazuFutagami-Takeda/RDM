<%--
/**
 * <pre>
 * 従業員関連共通インクルードTOP用JSPです。
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author 日立　花
 */
--%>
<%@ page
  language="java"
  import="java.util.*,java.text.*"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  isErrorPage="false"
  info="jkrTop"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 共通トップメニュー読み込み -->
<%@ include file="../menu/mnuTop00.jsp" %>
<s:set name="dateFormat" value="%{new java.text.SimpleDateFormat('yyyy年MM月dd日(E)')}" />

<s:if test="%{#session.NC001_RETURN_DTO_KEY == null}">
  <s:set id="TOP_FUNCTIONID" value="'Init'"/>
</s:if>
<s:else>
  <s:set id="TOP_FUNCTIONID" value="'View'"/>
</s:else>
<!-- セカンダリリンク 開始 -->
<% if(mainMenu != null){ %>
    <% if("S0110403".equals(mainMenu.getMenuCode()) || "S0110405".equals(mainMenu.getMenuCode())){ %>
<table border="0" cellpadding="0" cellspacing="0" width="100%" style="margin-top:10px;">
<tbody>
  <tr>
    <td align="left">&nbsp;</td>
    <td align="right" colSpan="2">
      <a class="comBannerSecondaryLink" style="margin-left:3pt;margin-right:3pt;" href="" onClick="JavaScript:document._fmTopMenu.action='<%= request.getContextPath() %>/servlet/control';JavaScript:jkrMenuLink('<s:property value="%{#TOP_FUNCTIONID}"/>');return false;">
      メニュー画面へ
      </a>
      <a class="comBannerSecondaryLink" href="" OnClick="jkrHomeLink();return false;"><font class="comBannerSecondaryLink">ホームへ</font></a>&nbsp;
    </td>
  </tr>
  </tbody>
</table>
    <% } %>
  <% } %>

<!--
  <% if(mainMenu != null){ %>
    <% if(!"S0110403".equals(mainMenu.getMenuCode()) && !"S0110405".equals(mainMenu.getMenuCode())){ %>
    <tr style="display: none;">
      <td colspan="2">
        <img src="img/menuCallIcon.png" alt="メインメニュー" onclick="dispMainMenu();">
      </td>
    </tr>
    <% } %>
  <% } %>
</tbody>
</table>
 -->
<!-- セカンダリリンク 終了 -->






