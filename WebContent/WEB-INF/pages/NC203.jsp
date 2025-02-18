<%--
/**
 * <pre>
 * 施設選択ポップアップ
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author BHH 張
 */
--%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="jp.co.takeda.rdm.dto.NC203DTO"%>
<%@page import="java.util.Enumeration"%>
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
<%
String title = (String)request.getAttribute("title");
String execDate = (String)request.getAttribute("execDate");
ValueStack stack = (ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
NC203DTO dto = new NC203DTO();
if (stack.peek() instanceof NC203DTO) {
   dto = (NC203DTO)stack.peek();
}
%>
<%
//検索条件の制御-----------------------------------------------------------
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<title><%= "施設選択" %></title>
	<!--
	###################################################################
	CSSとJSは、common.css,jsとpopup.css,アプリケーション名.jsのみを
	入れること
	###################################################################
	-->
	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/popup.css" rel="Stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/pdfReportList.js"></script>
    <script type="text/javascript" src="js/catShisetsu.js"></script>
	<script type="text/javascript" src="js/catInstitution.js"></script>
	<!--<script type="text/javascript" src="js/JKR050C000.js"></script>　-->
	<script type="text/javascript" src="js/NC203.js"></script>
	<script type="text/javascript" src="js/jgiKanren.js"></script>
	<script type="text/javascript" src="js/jkrMenu.js"></script>
	<script>
	function comSetFormWindowInfo(){

    	comClickFlgInit();

    }
    </script>
	<style>
	/*テーブル幅可変*/
		TD.comTableTitle{
			resize : horizontal;
			overflow : hidden;
			}
		.actionTh {
          position: sticky;
          top: 0;
          background-color:#fff;
        }
        #jkrCityNameCd option {
			display: none;
			}
	</style>
	<%
	// ソート順状態制御用
	String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
	//String sortCondition = null;
	%>
</head>

<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設検索"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>
<%-- ポータルタイトル 終了 --%>
<%-- ポータルボディー 開始 --%>
<table class="comPortalBody" <s:if test='viewKbn == 2'>style="background-color: #D7EEFF;"</s:if>>
	<tbody>
	<tr>
	<td>

	<%-- 施設選択 開始 --%>

	<!-- ポータル枠 開始 -->
	<table <s:if test='viewKbn == 2'>class="pupBodyTableBlue"</s:if><s:else>class="pupBodyTable"</s:else> align="center">
	<tbody>
	<s:form name="fm1" theme="simple" onSubmit="JavaScript:return false;"><!-- フォームfm1開始 -->
	<s:hidden name="screenId" value="NC203" />
	<s:hidden name="gamenId" value="NC203" />
	<s:hidden name="functionId"/>
    <s:hidden name="sosName" />
    <s:hidden name="jgiName" />
    <s:hidden name="orderKbn" />
    <s:hidden id="pageFlg"  name="pageFlg" />
    <s:hidden name="pageCntAll" />
    <s:hidden name="pageCntCur" />
    <s:hidden name="pageCntBase" />
    <s:hidden name="lineCntStart" />
    <s:hidden name="lineCntEnd" />
    <s:hidden name="lineCntAll1" />
    <s:hidden name="sosCd" />
    <s:hidden name="jgiNo" />
    <s:hidden name="trtGrpCd" />
    <s:hidden name="callBack" />
    <s:hidden name="winVarName" />
    <s:hidden name="sortCondition" />
    <s:hidden name="title" />
    <s:hidden name="viewKbn" />
     <s:url id="searchurl" action="NC203Search"/>
    <s:submit name="submit_search" value="検索イベント" onclick="this.form.action='%{searchurl}'; this.form.submit();return false;" cssStyle="display:none" />
    <s:url id="sorturl" action="NC203Sort"/>
    <s:submit name="sort_search" value="ソートイベント" onclick="this.form.action='%{sorturl}'; this.form.submit();return false;" cssStyle="display:none" />
    <s:url id="pageurl" action="NC203Page"/>
    <s:submit name="page_search" value="改ページイベント" onclick="this.form.action='%{pageurl}'; this.form.submit();return false;" cssStyle="display:none" />

	<s:iterator value="insData" status="status" var="rowBean">
	   <s:hidden name="insNo" />
	   <s:hidden name="insAbbrName" />
	   <s:hidden name="addrCodePref" />
	   <s:hidden name="tkCityCd" />
	</s:iterator>

	<tr><td>
	<table id="formTable00" border="0" cellpadding="2" cellspacing="0" width="600px">
		<tbody>
		<s:if test="msgStr != null">
		<tr>
		<td>
		<nobr>
		<s:property value="msgStr.replaceAll('\\n', '<br />')" escape="false"/>
		</nobr>
		</td>
		</tr>
		</s:if>
		</tbody>
	</table>
		<!-- 前制御部 開始 -->
		<table <s:if test='viewKbn == 2'>class="pupReferenceDetailBlue"</s:if><s:else>class="pupReferenceDetail"</s:else> align="center" style="width:500pt;">
		<tbody>
			<tr>
				<%-- 組織 --%>
				<td class="pupControlItem"><nobr>&nbsp;組織</nobr></td>
				<td>
				<s:property value="sosName" />
				</td>
				<%-- 担当者 --%>
				<td class="pupControlItem"><nobr>&nbsp;担当者</nobr></td>
				<td>
				<s:property value="jgiName" />
				</td>
				<%-- 廃院区分 --%>
				<td class="pupControlItem"><nobr>&nbsp;廃院区分</nobr></td>
				<td>
					<s:select id="haiinKbn" name="kensakuHaiinKbn" cssStyle="width:80pt" list ="haiinKbnMap" />
				</td>

			</tr>
			<tr>
				<%-- 施設名(全角) --%>
				<td class="pupControlItem"><nobr>&nbsp;施設名(全角)※</nobr></td>
				<td>
					<s:textfield id="insKanjiSrch" size="20" maxlength="40" name="insKanjiSrch" STYLE="ime-mode:active" />
				</td>
				<%-- 施設名(半角カナ) --%>
				<td class="pupControlItem"><nobr>&nbsp;施設名(半角カナ)※</nobr></td>
				<td>
					<s:textfield id="insKanaSrch" size="20" maxlength="14" name="insKanaSrch" style="ime-mode:inactive;" />
				</td>
				<%-- 削除フラグ --%>
				<td class="pupControlItem"><nobr>&nbsp;削除フラグ</nobr></td>
				<td>
					<s:select id="delFlg" name="kensakuDelFlg" cssStyle="width:80pt" list ="delFlgMap" />
				</td>
			</tr>
			<tr>
				<%-- 施設固定コード --%>
				<td class="pupControlItem"><nobr>&nbsp;施設固定コード</nobr></td>
				<td>
					<s:textfield id="insNoSrch" size="20" maxlength="20" name="insNoSrch" STYLE="ime-mode:active" />
				</td>
				<s:if test="viewKbn == 0">
					<%-- ULTコード --%>
					<td class="pupControlItem"><nobr>&nbsp;ULTコード</nobr></td>
					<td>
						<s:textfield id="ultNo" size="20" maxlength="14" name="ultNo" style="ime-mode:inactive;" />
					</td>
				</s:if>
				<s:else>
					<%-- ULTコードなし --%>
					<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
					<td>&nbsp;</td>
				</s:else>
				<%-- 経営主体 --%>
				<td class="pupControlItem"><nobr>&nbsp;経営主体</nobr></td>
				<td>
					<s:select id="hcoKeieitai" name="kensakuManageCd" cssStyle="width:80pt" list ="hcoKeieitaiMap" />
				</td>

			</tr>
			<tr>
				<%-- 対象区分 --%>
				<td class="pupControlItem"><nobr>&nbsp;対象区分</nobr></td>
				<td>
                    <s:select id="hoInsType" name="kensakuHoInsType" cssStyle="width:80pt" list ="hoInsTypeMap" />
				</td>

				<%-- 施設種別 --%>
				<td class="pupControlItem"><nobr>&nbsp;施設種別</nobr></td>
				<td>
					<s:select id="insType" name="kensakuInsSbt" cssStyle="width:80pt" list ="insTypeMap" />
				</td>
				<%-- 施設区分 --%>
				<td class="pupControlItem"><nobr>&nbsp;施設区分</nobr></td>
				<td>
					<s:select id="pharmType" name="pharmType" cssStyle="width:80pt" list ="pharmTypeMap" />
				</td>
			</tr>

			<tr>
				<%-- 電話番号(半角) --%>
				<td class="pupControlItem"><nobr>&nbsp;電話番号(半角)</nobr></td>
				<td>
 					<s:textfield id="phone1" size="20" maxlength="14" name="phone1" style="ime-mode:inactive;" />
				</td>

				<%-- 郵便番号(半角) --%>
				<td class="pupControlItem"><nobr>&nbsp;郵便番号(半角)</nobr></td>
				<td>
					<s:textfield id="insPcode" size="20" maxlength="14" name="insPcode" style="ime-mode:inactive;" />
				</td>

				<td>
					<s:if test="winVarName == 'NF011' || winVarName == 'NF211' || winVarName == 'NF212'">
					<input type="checkbox" id="koshisetsuCheck" align="right" name="koshisetsuCheck" checked disabled />
					<s:hidden name="koshisetsuCheck" value="true" />
					</s:if>
					<s:else>
					<s:checkbox id="koshisetsuCheck" align="right" name="koshisetsuCheck" tabIndex="-1" value="false" />
					</s:else>
				</td><td><nobr><label for="koshisetsuCheck">子施設を除く</label></nobr></td>

			</tr>

			<tr>
				<%-- 都道府県 --%>
				<td class="comTableSearchItem">
				<nobr>&nbsp;都道府県 </nobr>
				</td>
				<td>
				<span onchange="sosAddrChange(); return false;">
				<s:select class="jkrSosAddrCd" id="jkrSosAddrCd" name="kensakuAddrCodePref" cssStyle="width:80pt" list ="jkrSosAddrMap" />
			 	</span>
			 	</td>

				<%-- JIS市区町村 --%>
				<td class="comTableSearchItem">
				<nobr>&nbsp;JIS市区町村 </nobr>
				</td>
				<td><s:select class="jkrCityNameCd" id="jkrCityNameCd" name="kensakuAddrCodeCity" cssStyle="width:80pt" list ="mapCityName" /></td>

			</tr>
			<tr>
				<%-- 住所 --%>
				<td class="pupControlItem"><nobr>&nbsp;住所</nobr></td>
				<td  colspan="3">
  					<s:textfield id="address" size="50" maxlength="150" name="address" style="ime-mode:inactive;" />
				</td>

				<td>
					<input type="button" name="btnS0" value="検索" OnClick="ciiSearch();return false;">
                </td>
                <td>
                    <input type="button" align="left" value="クリア" class="comMiniLink" onclick="clearText()">
				</td>
			</tr>
		</tbody>
		</table>
		<!-- 前制御部 終了 -->

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

		<!-- 一覧部 開始 -->
<%
  // ソート表示状態制御
  String insAbbrAscClass = "comTableNoSort";
  String insAbbrDescClass = "comTableNoSort";
  String insFormalAscClass = "comTableNoSort";
  String insFormalDescClass = "comTableNoSort";
  String ultAbbrAscClass = "comTableNoSort";
  String ultAbbrDescClass = "comTableNoSort";
  String insNoAscClass = "comTableNoSort";
  String insNoDescClass = "comTableNoSort";
  String insAdrsAscClass = "comTableNoSort";
  String insAdrsDescClass = "comTableNoSort";
  String ultAdrsAscClass = "comTableNoSort";
  String ultAdrsDescClass = "comTableNoSort";
  if ("1".equals(sortCondition)) {
	  insNoDescClass = "comTableSort";
  } else if ("2".equals(sortCondition)) {
	  insAbbrAscClass = "comTableSort";
  } else if ("3".equals(sortCondition)) {
	  insAbbrDescClass = "comTableSort";
  } else if ("4".equals(sortCondition)) {
	  insAdrsAscClass = "comTableSort";
  } else if ("5".equals(sortCondition)) {
	  insAdrsDescClass = "comTableSort";
  } else if ("6".equals(sortCondition)) {
	  ultAbbrAscClass = "comTableSort";
  } else if ("7".equals(sortCondition)) {
	  ultAbbrDescClass = "comTableSort";
  } else if ("8".equals(sortCondition)) {
	  ultAdrsAscClass = "comTableSort";
  } else if ("9".equals(sortCondition)) {
	  ultAdrsDescClass = "comTableSort";
  }
%>

	<div style="max-height:270px;width:800px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
		<table>
		<tbody>
			<!-- ヘッダー -->
			<s:if test='pageFlg == "1"'>
			<!-- 何も表示しない -->
			</s:if>
			<s:else>


			<s:if test="viewKbn == 0">
			<!-- ULTあり一覧 -->
				<tr style="position: sticky; top:0; left:0;">
					<td class="actionTh" style="border:none" style="width:8pt"><nobr>&nbsp;</nobr></td>
					<td class="comTableTitle" style="width:105pt;"><nobr>施設略式漢字名
					<s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insAbbrAscClass %>" href="" onclick="jimSort(2);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insAbbrDescClass %>" href="" onclick="jimSort(3);return false;">▼</a>
	                </s:if>
	                </nobr></td>

	                <td class="comTableTitle" style="width:200pt;"><nobr>施設正式漢字名</nobr></td>

	                <td class="comTableTitle" style="width:50pt;"><nobr>施設固定C
	                				<s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insNoAscClass %>" href="" onclick="jimSort(0);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insNoDescClass %>" href="" onclick="jimSort(1);return false;">▼</a>
	                </s:if>
	                </nobr></td>
	                <td class="comTableTitle" style="width:250pt;"><nobr>施設住所
	                				<s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insAdrsAscClass %>" href="" onclick="jimSort(4);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insAdrsDescClass %>" href="" onclick="jimSort(5);return false;">▼</a>
	                </s:if>
	                </nobr></td>

	                <td class="comTableTitle" style="width:50pt;"><nobr>電話番号
	                </nobr></td>

	                <td class="comTableTitle" style="width:50pt;"><nobr>施設種別
	                </nobr></td>

	                <td class="comTableTitle" style="width:50pt;"><nobr>経営主体</nobr></td>

	                <td class="comTableTitle" style="width:5pt;"><nobr>ベッド数</nobr></td>
				</tr>
				<tr style="position: sticky; top:20; left:0;">
					<td class="actionTh" style="width:8pt;"><nobr>選択</nobr></td>
					<td class="comTableTitle" style="width:105pt;"><nobr>ULT施設略名
					<s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=ultAbbrAscClass %>" href="" onclick="jimSort(6);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=ultAbbrDescClass %>" href="" onclick="jimSort(7);return false;">▼</a>
	                </s:if>
	                </nobr></td>
	                <td class="comTableTitle" style="width:200pt;"><nobr>ULT施設名</nobr></td>

	                <td class="comTableTitle" style="width:50pt;"><nobr>ULTコード</nobr></td>
	                <td class="comTableTitle" style="width:250pt;"><nobr>ULT住所
					<s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=ultAdrsAscClass %>" href="" onclick="jimSort(8);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=ultAdrsDescClass %>" href="" onclick="jimSort(9);return false;">▼</a>
	                </s:if>
	                </nobr></td>
	                <td class="comTableTitle" style="width:50pt;"><nobr>ULT電話番号</nobr></td>

	                <td class="comTableTitle" style="width:50pt;"><nobr>ULT施設区分</nobr></td>

	                <td class="comTableTitle" style="width:50pt;"><nobr>ULT経営主体</nobr></td>

	                <td class="comTableTitle" style="width:5pt;"><nobr>ULTベッド数</nobr></td>
				</tr>
				<s:iterator value="insData" status="status" var="rowBean">
				<tr>
					<td class="pupButton" style="height:90%;" rowspan="2" >
					<input class="pupButton" type="button" value="" OnClick="cseSelectIns(
					'<s:property value="#rowBean.insAbbrName" />',
					'<s:property value="#rowBean.insFormalName" />',
					'<s:property value="#rowBean.insNo" />',
					'<s:property value="#rowBean.insAddr" />',
					'<s:property value="#rowBean.shisetsuNmRyaku" />',
					'<s:property value="#rowBean.shisetsuNm" />',
					'<s:property value="#rowBean.dcfShisetsuCd" />',
					'<s:property value="#rowBean.address" />',
					);"></input></td>
					<td class="comTableItem" id="left"><s:label key="insData[%{#status.index}].insAbbrName" /></td>
					<td class="comTableItem" id="left"><s:label key="insData[%{#status.index}].insFormalName" /></td>
					<td class="comTableItem" id="left"><s:label key="insData[%{#status.index}].insNo" /></td>
					<td class="comTableItem" id="left"><s:label key="insData[%{#status.index}].insAddr" /></td>
					<td class="comTableItem" id="left"><s:label key="insData[%{#status.index}].phone1" /></td>
					<td class="comTableItem" id="left"><s:label key="insData[%{#status.index}].insSbt" /></td>
					<td class="comTableItem" id="left"><s:label key="insData[%{#status.index}].manageCd" /></td>
					<td class="comTableItem" id="left"><s:label key="insData[%{#status.index}].bedsTot" /></td>
				</tr>
				<tr>
					<td class="comTableItem" id="left" style="background-color:#e0ffff"><s:label key="insData[%{#status.index}].shisetsuNmRyaku" /></td>
					<td class="comTableItem" id="left" style="background-color:#e0ffff"><s:label key="insData[%{#status.index}].shisetsuNm" /></td>
					<td class="comTableItem" id="left" style="background-color:#e0ffff"><s:label key="insData[%{#status.index}].dcfShisetsuCd" /></td>
					<td class="comTableItem" id="left" style="background-color:#e0ffff" style="width:500pt"><s:label key="insData[%{#status.index}].address" /></td>
					<td class="comTableItem" id="left" style="background-color:#e0ffff"><s:label key="insData[%{#status.index}].shisetsuTel" /></td>
					<td class="comTableItem" id="left" style="background-color:#e0ffff"><s:label key="insData[%{#status.index}].shisetsuKbn" /></td>
					<td class="comTableItem" id="left" style="background-color:#e0ffff"><s:label key="insData[%{#status.index}].keieitaiCd" /></td>
					<td class="comTableItem" id="left" style="background-color:#e0ffff"><s:label key="insData[%{#status.index}].byoshoSu" /></td>
				</tr>
	            </s:iterator>
			</s:if>
			<s:else>
			<!-- ULTなし一覧 -->
				<tr style="position: sticky; top:0; left:0;">
					<td style="border:none; width:8pt" <s:if test="viewKbn == 2">style="background-color:#D7EEFF;"</s:if><s:else>style="background-color:#FFFFFF;"</s:else>><nobr>選択</nobr></td>
					<td class="comTableTitle" style="width:50pt;"><nobr>施設固定C
             		<s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insNoAscClass %>" href="" onclick="jimSort(0);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insNoDescClass %>" href="" onclick="jimSort(1);return false;">▼</a>
	                </s:if>
	                </nobr></td>

					<td class="comTableTitle" style="width:105pt;"><nobr>施設略式漢字名
					<s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insAbbrAscClass %>" href="" onclick="jimSort(2);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insAbbrDescClass %>" href="" onclick="jimSort(3);return false;">▼</a>
	                </s:if>
	                </nobr></td>

	                <td class="comTableTitle" style="width:200pt;"><nobr>施設正式漢字名
	                <s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insFormalAscClass %>" href="" onclick="jimSort(2);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insFormalDescClass %>" href="" onclick="jimSort(3);return false;">▼</a>
	                </s:if>
	                </nobr></td>

	                <td class="comTableTitle" style="width:250pt;"><nobr>施設住所
	                				<s:if test=' !(insData == null || insData.size() <= 0)'>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insAdrsAscClass %>" href="" onclick="jimSort(4);return false;">▲</a>
	                       <span style="font-size: 1pt;"> </span>
	                       <a class="<%=insAdrsDescClass %>" href="" onclick="jimSort(5);return false;">▼</a>
	                </s:if>
	                </nobr></td>

	                <td class="comTableTitle" style="width:50pt;"><nobr>郵便番号
	                </nobr></td>
				</tr>

				<s:iterator value="insData" status="status" var="rowBean">
				<tr>
					<td <s:if test="viewKbn == 2">class="pupButtonBlue"</s:if><s:else>class="pupButton"</s:else> style="height:90%;">
					<input class="pupButton" type="button" value="" OnClick="cseSelectIns(
					'<s:property value="#rowBean.insAbbrName" />',
					'<s:property value="#rowBean.insFormalName" />',
					'<s:property value="#rowBean.insNo" />',
					'<s:property value="#rowBean.insAddr" />',
					'<s:property value="#rowBean.shisetsuNmRyaku" />',
					'<s:property value="#rowBean.shisetsuNm" />',
					'<s:property value="#rowBean.dcfShisetsuCd" />',
					'<s:property value="#rowBean.address" />',
					);"></input></td>
					<td <s:if test="viewKbn == 2">class="comTableItemBlue"</s:if><s:else>class="comTableItem"</s:else> id="left"><s:label key="insData[%{#status.index}].insNo" /></td>
					<td <s:if test="viewKbn == 2">class="comTableItemBlue"</s:if><s:else>class="comTableItem"</s:else> id="left"><s:label key="insData[%{#status.index}].insAbbrName" /></td>
					<td <s:if test="viewKbn == 2">class="comTableItemBlue"</s:if><s:else>class="comTableItem"</s:else> id="left"><s:label key="insData[%{#status.index}].insFormalName" /></td>
					<td <s:if test="viewKbn == 2">class="comTableItemBlue"</s:if><s:else>class="comTableItem"</s:else> id="left"><s:label key="insData[%{#status.index}].insAddr" /></td>
					<td <s:if test="viewKbn == 2">class="comTableItemBlue"</s:if><s:else>class="comTableItem"</s:else> id="left"><s:label key="insData[%{#status.index}].insPcode" /></td>
				</tr>
	            </s:iterator>
			</s:else>
           </s:else>
		</tbody>
		</table>
</div>
		<!-- 一覧部 終了 -->

		<!-- 後制御部 開始 -->
		<table <s:if test='viewKbn == 2'>class="comPortalControlTableBlue comPortalControlTablePopupBlue"</s:if><s:else>class="comPortalControlTable comPortalControlTablePopup"</s:else> align="center" style="width:440pt;">
		<tbody>
			<tr>
				<td width="100%"></td>
				<td class="comPortalControlItem"><input type="button" name="bCancel" value="閉じる" OnClick="ciiClose();"></td>
			</tr>
		</tbody>
		</table>
		<p><s:property value="test" /></p>
		<!-- 後制御部 終了 -->

	</td></tr>

	</s:form>	<!-- フォームfm1終了 -->
	</tbody>
	</table>
	<!-- ポータル枠 終了 -->
	</td>
	</tr>
	</tbody>
</table>

	<!-- 施設選択 終了 -->
</body>
</html>
