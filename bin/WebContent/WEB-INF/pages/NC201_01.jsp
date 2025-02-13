<%--
/**
 * <pre>
 *  組織検索ポップアップのJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author SBS 内海
 * @see
 */
--%>
<!--  <%@page import="jp.co.takeda.rdm.dto.NC201DTO"%>-->
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
  <title>組織検索ポップアップ</title>
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
    <s:hidden name="bumonSeiName" />

  <%-- 組織ポップアップ用パラメータ  --%>
  <s:hidden name="selectFlgPop"           />
  <s:hidden name="initSosCdPop"           />
  <s:hidden name="SosCdPop"           />
  <s:hidden name="bumonRankPop"           />
  <s:hidden name="trtCdPop"           />


  <%-- 初期表示組織 --%>
  <input type="hidden" name="initSosCd" value="dummy">
  <input type="hidden" name="initBumonRank" value="dummy">
  <s:iterator value="sosInitSosData" status="status" var="rowBean">
  <%-- 上位組織はリストの下にあるので、後ろから取得するべき --%>
  <input type="hidden" name="initSosCd" value="<s:property value="#rowBean.sosCd"/>">
  <input type="hidden" name="initBumonRank" value="<s:property value="#rowBean.bumonRank"/>">
  </s:iterator>

  <%-- 従業員選択取得フェッチサイズ（デフォルト値用） --%>
  <s:hidden name="jgiFetchSizeDefault" />

  <%-- 選択フラグ --%>
  <s:hidden name="selectFlgPop" />

  <%-- 連続選択フラグ --%>
  <s:hidden name="conSelFlg" />

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
  <s:iterator value="sosInitData" status="status" var="rowBean">
    <%-- 20210208 FSZ Chrome対応 UPD START --%>
    <%--<div name="layout" style="padding-top:8px">--%>
    <div id="layout" name="layout" style="padding-top:8px">
    <%-- 20210208 FSZ Chrome対応 UPD END --%>
      <nobr>
        <%-- 三角画像 --%>
        <%-- 組織名リンクと同じ条件で表示 --%>
        <s:if test="%{(selectFlgPop == 1 )}">
          <img
            src="img/right.gif"
            name="img<s:property value="#rowBean.sosCd"/>"
            onclick="rcseCallAjax('<s:property value="#rowBean.sosCd"/>', '<s:property value="#rowBean.bumonRank"/>', '<s:property value="#rowBean.trtCd"/>'); return false;"
          >
        </s:if>

        <%-- 組織名 --%>
        <s:if test="%{(selectFlgPop == 1 )}">
          <a
            href=""
            name="focus<s:property value="#rowBean.sosCd"/>"
            class="comLink"
            onclick="rcseCallAjax('<s:property value="#rowBean.sosCd"/>', '<s:property value="#rowBean.bumonRank"/>'); return false;"
          ><s:property value="#rowBean.bumonSeiName"/></a>
        </s:if>
        <s:else>
          <s:property value="#rowBean.bumonSeiName"/>
        </s:else>

      </nobr>
      <br>
      <%-- 子組織の配置空間 --%>
      <div style="display:none" class="resultDiv" id="<s:property value="#rowBean.sosCd"/>"></div>
    </div>
  </s:iterator>
  </div>
  </div>
  </table>


  <%-- スクロールバー 終了 --%>


  </div>
  <hr class="comSplit">
  <table class="comPortalControlTable comPortalControlTablePopup" align="center">
    <tr>
      <td width="100%"></td>
      <td id="controlButton" class="comPortalControlItem">
        <input type="button" value="閉じる" OnClick="cseClose();">
      </td>
    </tr>
  </table>

  </td></tr>
  </table>

<%-- ポータルボディー 終了 --%>
  </form>
<%-- input用フォーム 終了 --%>
</body>
</html>
