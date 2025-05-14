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
<%--     <script type="text/javascript" src="js/jkrMenu.js"></script> --%>
</head>
<style>
        TD.comTableTitle{			/* テーブル形式のタイトル項目 */
         border-style: solid;
         border-top-width : 0px;
         border-left-width : 1px;
         border-right-width : 1px;
         border-bottom-width : 1px;
         border-color: brack;
         /*テーブル幅可変*/
	     resize : horizontal;
		 overflow : hidden;
		 font-weight:normal;
       }
        TD.comTableTitle2{			/* テーブル形式のタイトル項目 */
         color : #000000;
         background-color: #ffffff;
         border-style: solid;
         border-top-width : 1px;
         border-left-width : 1px;
         border-right-width : 1px;
         border-bottom-width : 1px;
       }
        TD.comTableItem{			/* テーブル形式のタイトル項目 */
         border-style: solid;
         border-top-width : 0px;
         border-left-width : 1px;
         border-right-width : 1px;
         border-bottom-width : 1px;
         border-color: brack;
       }
</style>
<body class="comPage" onLoad="cdcLoad();" OnUnLoad="cdcUnLoad();">
<%-- submit用フォーム 開始 --%>
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
    <s:hidden name="maxPageCnt" />
    <s:hidden name="pageRowNum" />

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
		<table width="100%">
   		    <tr>
                <td align="center">
                    <jsp:include page="common/rdmMsg.jsp">
                        <jsp:param name="" value="" />
                    </jsp:include>
                </td>
            </tr>
        </table>
<%-- 検索部 開始 --%>

	<CENTER>


	<table>
		<tr height="40">
		    <td style="width:100pt;"><nobr>施設固定C   <s:property value="paramInsNo"/></nobr></td>
            <td style="width:100pt;"><nobr>施設略式漢字名    <s:label name="insAbbrName"  key="insAbbrName"/></nobr></td>
            <td style="width:10pt;"><s:checkbox id="allCheck" name="allCheck" tabIndex="-1"/></td>
            <td style="width:100pt;"><nobr><label for="allCheck">全所属部科から検索</label></nobr></td>
		</tr>
	</table>
	<table align="left" style="position:relative;left:35px">
		<tr>
		    <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <nobr><s:textfield name="searchInput" align="left"  size="60" maxlength="60" type="search" onsubmit="return false;"/></nobr>
                <s:submit value="検索" name="検索" onclick="deptSearch();"/>
                <br> ※部分一致で検索されます。<%-- 検索ボタン --%>
            </td>
		</tr>
	</table>

	<table class="pupReferenceDetail" align="center" style="border-style:solid;width:350pt;">
    </table>
<%-- 検索部 終了 --%>
<%-- ページ情報 --%>
    <!-- 「更新」リンク表示フラグ 1:表示 0:非表示 -->
          <s:if test='pageFlg == "1" '>
          </s:if>
          <s:else>
              <table width="95%" >
		          <tr>
                  <%-- ページャー表示 開始 --%>
                      <s:if test='pageFlg == "1" '>
                      </s:if>
                      <s:else>
                          <td align="right">
                              <jsp:include page="common/rdmPage.jsp">
                                  <jsp:param name="" value="" />
                              </jsp:include>
                          </td>
                      </s:else>
                      <%-- ページャー表示 終了 --%>
                  </tr>
              </table>
          </s:else>
          <s:if test='pageFlg == "1" '>
          </s:if>
          <s:else>
              <div align="center" style="max-height:270px;width:415px;overflow-y:scroll; overflow-x:none; border-width:1px; scrollbar-width: auto; ">
                  <table align="center" border="0" cellpadding="2" cellspacing="0" style="width:300pt; position: sticky; top:0; left:0;scrollbar-width: auto;">
	                  <tr style="position: sticky; top:0; left:0; scrollbar-width: auto;" >
	                      <td class="comTableTitle2 " style="border:none; width:20pt; position: sticky;"><nobr>選択</nobr>
	                      </td>
	                      <td class="comTableTitle " style="width:80pt; "><nobr>所属部科コード</nobr>
	                      </td>
	                      <td class="comTableTitle" style="width:200pt; border-right-width : 2px;"><nobr>所属部科名</nobr>
	                      </td>
	                  </tr>
	                  <s:iterator value="catDeptsComboDataList" status="status" var="rowBean">
	                      <tr>
		                      <td class="comTableItem " style="width:20px; border:none;">
                	              <input type="button" value="" style="width:20px;" class="cseJgiSelectButton"
              		                     onclick="dcaReturnRDM('<s:property value="#rowBean.deptCode"/>',
                                                               '<s:property value="#rowBean.DeptKj" />',
                                                               '<s:property value="#rowBean.DeptKn"/>');">
                              </td>
                              <td class="comTableItem" style="width:60pt;">
                                  <s:label name="catDeptsComboDataList[%{#status.index}].deptCode"  key="catDeptsComboDataList[%{#status.index}].deptCode" />
                              </td>
		  			          <td class="comTableItem" style="width:150pt;border-right-width : 2px;">
		  			              <s:label name="catDeptsComboDataList[%{#status.index}].DeptKj"  key="catDeptsComboDataList[%{#status.index}].DeptKj" />
		  			              <s:hidden name="catDeptsComboDataList[%{#status.index}].deptCode" />
		  			              <s:hidden name="catDeptsComboDataList[%{#status.index}].DeptKn" />
		  			          </td>
                          </tr>
                      </s:iterator>
	              </table>
              </div>
          </s:else>
	</CENTER>
<%-- メイン部 一覧 終了 --%>

<%-- 後制御部 --%>
    <table class="comPortalControlTable comPortalControlTablePopup" style="margin-top:3pt;margin-bottom:1pt; width:300pt;"align="center">
          <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td>
                  <input type="button"  align="left"  value="閉じる" OnClick="cdcClose();">
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