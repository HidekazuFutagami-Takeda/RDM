<%--
/**
 * <pre>
 *  担当者検索ポップアップのJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author SBS 内海
 * @see
 */
--%>
<%@page import="jp.co.takeda.rdm.dto.NC202DTO"%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppConstant,java.util.ArrayList,java.math.BigDecimal,java.lang.String"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"

%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <title>担当者検索ポップアップ</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/popup.css" rel="Stylesheet" type="text/css" />
  <link href="css/catSosJgiExpand.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript" src="js/rdmCatSosExpand.js"></script>
</head>
<body class="comPage" onLoad="cseLoad('<s:property value="selectFlgPop"/>');" OnUnLoad="cseUnLoad();">
<%-- submit用フォーム 開始 --%>
  <form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
    <input type="text" name="screenId"           value="" />
    <input type="text" name="functionId"         value="" />
    <input type="text" name="windowName"         value="" />
    <input type="text" name="openerName"         value="" />
    <input type="text" name="callBack"           value="" />
    <input type="text" name="winVarName"         value="" />
    <input type="text" name="no1"                value="1" />
    <input type="text" name="dspClrBtn1"         value="" />
    <input type="text" name="dspOutMark1"        value="" />
    <input type="text" name="parentClearProc1"   value="" />
    <input type="text" name="dummy"              value="dummy" />
  </form>
<%-- submit用フォーム 終了 --%>
<%-- input用フォーム 開始 --%>
  <form name="fm1" onSubmit="JavaScript:return false;" >
    <s:hidden name="callBack" />
    <s:hidden name="winVarName" />
    <s:hidden name="bumonRyakuName" />
    <s:hidden name="bumonRankPop"/>
    <s:hidden name="sosCdPop"/>
    <s:hidden name="upSosCdPop"/>
    <s:hidden name="bumonRankPop"/>
<%-- ポータルボディー 開始 --%>
  <table class="pupBodyTable" align="center" cellspacing="0" cellpadding="0">
  <tr>
  <td class="cseBody">
  <table><tr><td class="cseTitle"><nobr><div id="title"></div></nobr></td></tr></table>
 	<%-- <table　style="text-align:center"><tr><td class="cseTitle"><nobr><div id="title"></div></nobr></td></tr></table> --%>

  <%-- スクロールバー 開始 --%>
  <div class="scroll">
  <table align="center" >
  <tr><td>
  <div id="all" class="cseView">
  <%-- 組織 --%>
  <s:iterator value="jgiInitData" status="status" var="rowBean">
    <div id="layout" name="layout" style="padding-top:8px">
    <%-- 20210208 FSZ Chrome対応 UPD END --%>
      <nobr>
        <%-- 三角画像 --%>
        <%-- 組織名リンクと同じ条件で表示 --%>
        <s:if test="%{(selectFlgPop == 1 )}">
          <img
            src="img/right.gif"
            name="img<s:property value="#rowBean.sosCd"/>"
            onclick="rcseCallAjaxJgi('<s:property value="#rowBean.sosCd"/>', '<s:property value="#rowBean.bumonRank"/>'); return false;"
          >
        </s:if>

        <%-- 組織名 --%>
        <s:if test="%{(selectFlgPop == 1 )}">
          <a
            href=""
            name="focus<s:property value="#rowBean.sosCd"/>"
            class="comLink"
            onclick="rcseCallAjaxJgi('<s:property value="#rowBean.sosCd"/>', '<s:property value="#rowBean.bumonRank"/>'); return false;"
          ><s:property value="#rowBean.bumonRyakuName"/></a>
        </s:if>
        <s:else>
          <s:property value="#rowBean.bumonRyakuName"/>
        </s:else>

      </nobr>
      <br>
      <%-- 子組織の配置空間 --%>
      <div style="display:none" class="resultDiv" id="<s:property value="#rowBean.sosCd"/>"></div>
    </div>
  </s:iterator>
  </div>


  </table>
  </div>
   </td></tr>
  </table>


  <%-- スクロールバー 終了 --%>

  <hr class="comSplit">
  <table style="margin:0; width:100vw; table-layout:fixed;" align="center">
    <tr>
      <td id="controlButton" class="comPortalControlItem" align="left">
        <input type="button" value="閉じる" OnClick="cseClose();">
      </td>
      <td id="controlButton" class="comPortalControlItem" align="center">
        <input type="button" value="全てたたむ" OnClick="cseAllClose();">
      </td>
      <td></td>
    </tr>
  </table>


<%-- ポータルボディー 終了 --%>
  </form>
<%-- input用フォーム 終了 --%>
</body>
</html>