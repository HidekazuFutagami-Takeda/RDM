<%--
/**
 * <pre>
 *  所属部科選択ポップアップのJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author SBS  稲田
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.dto.NC204DTO"%>
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
	<title>NC204_所属部科選択ポップアップ</title>
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
</head>
<script type="text/javascript">

</script>
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
    <s:hidden id="paramInsNo" name="paramInsNo"/>


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
    <s:url id="searchurl" action="NC204Search"/>
    <s:submit name="submit_search" value="検索イベント" onclick="this.form.action='%{searchurl}'; this.form.submit();return false;" cssStyle="display:none" />
    <s:url id="pageurl" action="NC204Page"/>
    <s:submit name="page_search" value="改ページイベント" onclick="this.form.action='%{pageurl}'; this.form.submit();return false;" cssStyle="display:none" />

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

	<CENTER>


	<table>
		<tr height="40">
		    <td style="width:100pt;"><nobr>施設固定C   <s:property value="paramInsNo"/></nobr></td>
            <td style="width:100pt;"><nobr>施設略式漢字名    <s:label name="insAbbrName"  key="insAbbrName"/></nobr></td>
            <td style="width:10pt;"><s:checkbox name="allCheck" tabIndex="-1"/></td>
            <td style="width:100pt;"><nobr>全所属部科から検索</nobr></td>
		</tr>
	</table>
	<table align="left" style="position:relative;left:35px">
		<tr>
        <td>
            <nobr><s:textfield name="searchInput" align="left"  size="40" maxlength="40" type="search" onsubmit="return false;"/></nobr>
            <s:submit value="検索" name="検索" onclick="this.form.action='%{inSearchInput}';  this.form.submit();return false;" onkeypress="if(event.keyCode==13){event.returnValue=false}" />
            <br> ※部分一致で検索されます。</br><%-- 検索ボタン --%>
        </td>
		</tr>
	</table>

	 <table class="pupReferenceDetail" align="center" style="border-style:solid;width:350pt;">
    </table>
<%-- 検索部 終了 --%>
<%-- ページ情報 --%>
    <!-- 「更新」リンク表示フラグ 1:表示 0:非表示 -->
   <jsp:include page="common/popPage.jsp" >
      <jsp:param name="showPagerFlg" value="0" />
      <jsp:param name="pagerSize" value="300" />
    </jsp:include>

    <table >
	<tr class="comTableTitle" >
	<td class="comTableTitle" align="left" style="width:400px; text-align: left;  border:none;">所属部科名</td>
	</tr>
</table>
	<div id="osirase" align="center"  style="background-color:#ffffff; width:417px; height:300px; overflow-y:scroll; border-width:1px; border-style:solid;">
    <table  align="center" border:none; cellpadding="2" cellspacing="0" style="width:300pt;">
    <%-- 項目 --%>

    <%-- 内容 --%>

    <s:iterator value="catDeptsComboDataList" status="status" var="rowBean">
	 <tr>
		        <td class="comTableItem" style="width:100px; border:none;">


                	<input type="button" value="" class="cseJgiSelectButton"
              			onclick="dcaReturnRDM('<s:property value="#rowBean.deptCode"/>',
						           		 	　  '<s:property value="#rowBean.DeptKj" />',
						           		 	  '<s:property value="#rowBean.DeptKn"/>');">

		  			  <s:hidden name="catDeptsComboDataList[%{#status.index}].deptCode" />
		  			  <s:label name="catDeptsComboDataList[%{#status.index}].DeptKj"  key="catDeptsComboDataList[%{#status.index}].DeptKj" />
		  			  <s:hidden name="catDeptsComboDataList[%{#status.index}].DeptKn" />


                       </td>
                </tr>
    </s:iterator>
    </table>
    </div>
	</CENTER>
<%-- メイン部 一覧 終了 --%>
<!--  <hr class="comSplit" /> -->
<%-- 後制御部 --%>
    <table class="comPortalControlTable comPortalControlTablePopup" align="center" style="width:300pt;" >
        <tr>
        <td width="100%"></td>
             <td class="comPortalControlItem">
            <%--    <nobr style="position: fixed; bottom: 20; left: 20;width: 100%; text-align: left;">  --%>
                <input type="button" value="閉じる" OnClick="cdcClose();">
                </nobr>
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
