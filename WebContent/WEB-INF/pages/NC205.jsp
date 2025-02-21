<%--
/**
 * <pre>
 *  住所候補ポップアップのJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author SBS  稲田
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.dto.NC205DTO"%>
<%@page
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
	<title>NC205_住所候補ポップアップ</title>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/popup.css" rel="Stylesheet" type="text/css" />
	<link href="css/catDeptsCombo.css" rel="Stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/dmcDocInputCategoriesRDM.js"></script>
	<script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/pdfReportList.js"></script>
    <script type="text/javascript" src="js/catDeptsComboRDM.js"></script>
    <script type="text/javascript" src="js/dmcDocInputCategoriesRDM.js"></script>
    <script type="text/javascript" src="js/jkrMenu.js"></script>
    <script type="text/javascript" src="js/JKR050C000.js"></script>

  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/popup.css" rel="Stylesheet" type="text/css" />
  <link href="css/catSosJgiExpand.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/JKR050C000.js"></script>
    <script type="text/javascript" src="js/JKR050C010.js"></script>
    <script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
    <script type="text/javascript" src="js/catInstitution.js"></script>
    <script type="text/javascript" src="js/catDeptsCombo.js"></script>
    <script type="text/javascript" src="js/dmcDocInputCategories.js"></script>

    <%--<style>
    /*テーブル幅可変*/
		TD.comTableTitle{
			resize : horizontal;
			overflow : hidden;
			}
    </style> --%>
</head>
<body class="comPage" onLoad="cdcLoad();" OnUnLoad="cdcUnLoad();">
<%-- submit用フォーム 開始 　まるっといらないかもって話がある--%>
	<form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
		<input type="text" name="screenId"          value="" />
		<input type="text" name="functionId"        value="" />
		<input type="text" name="windowName"        value="" />
		<input type="text" name="openerName"        value="" />
		<input type="text" name="callBack"          value="" />
		<input type="text" name="winVarName"        value="" />
		<input type="text" name="fromScreenId1"     value="" />
		<input type="text" name="fromFunctionId1"   value="" />
		<input type="text" name="kensakuKana1"      value="" />
		<input type="text" name="kensakuKanj1"      value="" />
		<input type="text" name="pageNextBackFlag1" value="" />
		<input type="text" name="startRecordNo1"    value="" />
		<input type="text" name="pageLines1"        value="" />
		<input type="text" name="no1"               value="1" />
		<input type="text" name="preDisplay"        value="" />

		<%--
			チェック済みを記憶するために<div>タグの空間にhidden属性の
			inputをJavaScriptで動的に配置する。
		--%>
		<input type="hidden" name="cdcCheckedCodes1" value="dummy">
		<input type="hidden" name="cdcCheckedCodes1" value="dummy">
		<input type="text" name="dummy"             value="dummy" />
	</form>
<%-- submit用フォーム 終了 --%>
<%-- input用フォーム 開始 --%>
  <s:form name="fm1" theme="simple">
	<%-- 常に配列にするためにダミーを配置    DTOからjspに値を受け取っている部分 --%>
    <s:hidden name="callBack" />
    <s:hidden name="winVarName" />

	<s:hidden id="backScreenId" name ="backScreenId"/>
	<s:hidden id="preScreenId" name ="preScreenId"/>
    <s:hidden id="postCode" name="postCode"/>

    <s:hidden name="pageCntAll" />
    <s:hidden name="pageCntCur" />
    <s:hidden name="pageCntBase" />
    <s:hidden name="lineCntStart" />
    <s:hidden name="lineCntEnd" />
    <s:hidden name="lineCntAll1" />
    <s:hidden name="checkers" value="dummy" /><%-- チェックボックス --%>
    <s:hidden name="deptCode" value="dummy" />
    <s:hidden name="kanaName" value="dummy" />
    <s:hidden name="kanjName" value="dummy" />
<!--<s:hidden name="DeptKj" value="dummy" />
 	<s:hidden name="allCheck" value="dummy" /> -->
    <s:hidden name="cdcCheckedCodes" value="dummy" />
    <s:hidden name="cdcCheckedCodes" value="dummy" />
    <div id="cdcCheckedCodesDiv" style="display:none">
    <s:iterator value="cdcCheckedCodes" var="code">
        <s:if test="%{#code == 'dummy'}">
        </s:if>
        <s:else>
            <s:hidden name="cdcCheckedCodes" value="%{code}" />
        </s:else>
    </s:iterator>
    </div>
    <s:url id="searchurl" action="NC205Search"/>
    <s:submit name="submit_search" value="検索イベント" onclick="this.form.action='%{searchurl}'; this.form.submit();return false;" cssStyle="display:none" />
    <s:url id="pageurl" action="NC205Page"/>
    <s:submit name="page_search" value="改ページイベント" onclick="this.form.action='%{pageurl}'; this.form.submit();return false;" cssStyle="display:none" />

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

	<CENTER>

	<br>
	<table style="width:50pt;"><nobr>住所候補</nobr>
	<br>
		<tr fontSize="8">
		<br>
            <td style="width:160pt;"><nobr>郵便番号 :    </nobr><td style="width:16pt;"><nobr><s:property value="postCode"/></nobr></td>
		</tr>
	</table>
	<br>
<%-- 検索部 終了 --%>
<%-- ページ情報 --%>
    <!-- 「更新」リンク表示フラグ 1:表示 0:非表示 -->
   <jsp:include page="common/popPage.jsp" >
      <jsp:param name="showPagerFlg" value="0" />
      <jsp:param name="pagerSize" value="30" />
    </jsp:include>

<table >
	<tr class="comTableTitle">
	<td class="comTableTitle" style="width:80px; border:none;">都道府県</td>
	<td class="comTableTitle" style="width:100px; border:none;">市区町村</td>
	<td class="comTableTitle" style="width:230px; border:none;">大字・町域名</td>
	</tr>
</table>
<div id="osirase" style="background-color:#ffffff; width:417px; height:100px; overflow-y:scroll; border-width:1px; border-style:solid;">
    <table  align="center" border:none; cellpadding="2" cellspacing="0" style="width:300pt;">

    <s:iterator value="catDeptsComboDataList" status="status" var="rowBean">
	 <tr>
	   <td class="comTableItem" style="width:80px; border:none;">

                	<input type="button" value="" class="cseJgiSelectButton"
              		onclick="postReturnRDM('<s:property value="#rowBean.addrNamePref"/>',
						           		  '<s:property value="#rowBean.addrNameCity" />',
						           		  '<s:property value="#rowBean.addrNameArea" />',
						           		  '<s:property value="#rowBean.postCode" />',
						           		  '<s:property value="#rowBean.addrCodePref" />',
						           		  '<s:property value="#rowBean.addrCodeCity" />',
						           		  '<s:property value="#rowBean.tkPrefCd" />',
						           		  '<s:property value="#rowBean.tkCityCd" />',
						           		  '<s:property value="#rowBean.tkCityName" />',
						           		  '<s:property value="#rowBean.addrKanaPref" />',
						           		  '<s:property value="#rowBean.addrKanaCity" />',
						           		  '<s:property value="#rowBean.addrKanaArea"/>');">

		  			  <s:label  name="catDeptsComboDataList[%{#status.index}].addrNamePref"  key="catDeptsComboDataList[%{#status.index}].addrNamePref" />
		  			  <s:hidden name="catDeptsComboDataList[%{#status.index}].addrNameCity"  />
		  			  <s:hidden name="catDeptsComboDataList[%{#status.index}].addrNameArea"  />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].postCode" />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].addrCodePref" />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].addrCodeCity" />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].tkPrefCd" />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].tkCityCd" />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].tkCityName" />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].addrKanaPref" />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].addrKanaCity" />
					  <s:hidden name="catDeptsComboDataList[%{#status.index}].addrKanaArea" />
                       </td>
                <td style="width:100px; border:none;">
                <s:label name="catDeptsComboDataList[%{#status.index}].addrNameCity"  key="catDeptsComboDataList[%{#status.index}].addrNameCity" />
                </td>
                <td style="width:200px; border:none;">
				<s:property value="addrNameArea" />
                </td>
                </tr>
	</s:iterator>
    </table>
    </div>
	</CENTER>
<%-- メイン部 一覧 終了    key="catDeptsComboDataList[%{#status.index}].addrNameArea" --%>
<!--  <hr class="comSplit" /> -->
<%-- 後制御部 --%>
    <table class="comPortalControlTable comPortalControlTablePopup" align="center" style="width:300pt;" >
        <tr>
        <td width="100%"></td>
             <td class="comPortalControlItem">
            <%--    <nobr style="position: fixed; bottom: 20; left: 20;width: 100%; text-align: left;">  --%>
                <input type="button" value="閉じる" OnClick="cdcClose();">

            </td>
        </tr>
    </table>
	</td></tr>
	</table>
<%-- ポータルボディー 終了 --%>
  </s:form>
<%-- input用フォーム 終了 --%>
</body>
</html>
