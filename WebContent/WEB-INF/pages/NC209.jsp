<%--
/**
 * <pre>
 * 医師検索ポップアップ
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author
 */
--%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="jp.co.takeda.rdm.dto.NC209DTO"%>
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
// String title = (String)request.getAttribute("title");
// String execDate = (String)request.getAttribute("execDate");
// ValueStack stack = (ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
// NC209DTO dto = new NC209DTO();
// if (stack.peek() instanceof NC209DTO) {
//    dto = (NC209DTO)stack.peek();
// }
%>
<%
//検索条件の制御-----------------------------------------------------------
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<title><%= "NC209_医師検索ポップアップ" %></title>
	<!--
	###################################################################
	CSSとJSは、common.css,jsとpopup.css,アプリケーション名.jsのみを
	入れること
	###################################################################
	-->
	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/popup.css" rel="Stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/catShisetsu.js"></script>
    <script type="text/javascript" src="js/catDeptsComboRDM.js"></script>
	<script type="text/javascript" src="js/catDoctor.js"></script>
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
        .tkdDoc TH:first-child {
          position: sticky;
          left: 0;
          z-index:100;
        }
	</style>
	<%
	// ソート順状態制御用
	String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
	//String sortCondition = null;
	%>
</head>

<body class="comPage" onUnload="JavaScript:cdrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="医師検索ポップアップ"></td>
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
	<s:hidden name="screenId" value="NC209" />
	<s:hidden name="gamenId" value="NC209" />
	<s:hidden name="functionId"/>
    <s:hidden name="orderKbn" />
    <s:hidden id="pageFlg"  name="pageFlg" />
    <s:hidden name="pageCntAll" />
    <s:hidden name="pageCntCur" />
    <s:hidden name="pageCntBase" />
    <s:hidden name="lineCntStart" />
    <s:hidden name="lineCntEnd" />
    <s:hidden name="lineCntAll1" />
    <s:hidden name="maxPageCnt" />
    <s:hidden name="pageRowNum" />
    <s:hidden name="orderKbn" />
    <s:hidden name="callBack" />
    <s:hidden name="backScreenId" />
    <s:hidden name="winVarName" />
    <s:hidden name="sortCondition" />
    <s:hidden name="title" />
    <s:hidden name="viewKbn" />
    <s:hidden name="loginJokenSetCd"/>
    <s:hidden name="loginJgiNo"/>
    <s:hidden name="loginBrCd"/>
    <s:hidden name="loginDistCd"/>
    <s:hidden name="trtCd"/>
    <%-- 所属部科ポップアップ用パラメータ --%>
    <input type="hidden" name="cdcCheckedCodes" value="" />
    <input type="hidden" name="paramInsNo" value="" />

           <%-- 組織検索ポップアップ用 --%>
  			<input type="hidden" name="selectFlgPop"           value="" />
  			<input type="hidden" name="initSosCdPop"           value="" />
  			<input type="hidden" name="trtCdPop"               value="" />
  			<input type="hidden" name="trtCdPop"               value="" />
  			<s:hidden id="brCode" name="brCode"/>
  			<s:hidden id="distCode" name="distCode"/>
  			<s:hidden id="upSosCode" name="upSosCode"/>
  			<s:hidden name="upBumonRank" id="upBumonRank" />
  			<s:hidden name="upBrCode" id="upBrCode" />
  			<s:hidden name="upDistCode" id="upDistCode" />
			<s:hidden id="sosCdPop" name="sosCdPop"/>
			<s:hidden id="upSosCdPop" name="upSosCdPop"/>
			<s:hidden id="bumonRankPop" name="bumonRankPop" value=""/>
			<s:hidden id="sosCd" name="sosCd"/>
			<s:hidden id="upSosCd" name="upSosCd"/>
			<s:hidden id="bumonRank" name="bumonRank"/>
			<s:hidden id="bumonRyakuName" name="bumonRyakuName"/>
			<s:hidden id="jgiNo" name="jgiNo"/>

     <s:url id="searchurl" action="NC209Search"/>
    <s:submit name="submit_search" value="検索イベント" onclick="this.form.action='%{searchurl}'; this.form.submit();return false;" cssStyle="display:none" />
    <s:url id="sorturl" action="NC209Sort"/>
    <s:submit name="sort_search" value="ソートイベント" onclick="this.form.action='%{sorturl}'; this.form.submit();return false;" cssStyle="display:none" />
    <s:url id="pageurl" action="NC209Page"/>
    <s:submit name="page_search" value="改ページイベント" onclick="this.form.action='%{pageurl}'; this.form.submit();return false;" cssStyle="display:none" />

	<s:iterator value="docData" status="status" var="rowBean">
	   <s:hidden name="docNo" />
	   <s:hidden name="docKanj" />
	</s:iterator>

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
		<!-- 前制御部 開始 -->
		<table <s:if test='viewKbn == 2'>class="pupReferenceDetailBlue"</s:if><s:else>class="pupReferenceDetail"</s:else> align="center" style="width:500pt;">
		<tbody>
          　　　　　　　<tr>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>氏名漢字(全角)</nobr></td>
              <td></td>
              <td><s:textfield name="searchDocName" size="30" maxlength="30" type="search" style="width:100pt;"/></td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>氏名カナ(半角カナ)</nobr></td>
              <td></td>
              <td><s:textfield name="searchDocKana" size="30" maxlength="30" type="search" style="width:100pt;"/></td>
              <td></td>
              <s:if test='mrAdminFlg == "0"'>
                  <td class="comTableSearchItem" style="width:50pt;  color:lightgray;"><nobr>医師／薬剤師区分</nobr></td>
                  <td></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                      <select disabled Style="width:100pt"></select>
                  </td>
              </s:if>
              <s:else>
                  <td class="comTableSearchItem" style="width:50pt;"><nobr>医師／薬剤師区分</nobr></td>
                  <td></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                      <s:select id="searchDocType" name="searchDocType" cssStyle="width:100pt" list ="searchDocTypeCombo"/>
                  </td>
              </s:else>
            </tr>
                      　　<tr>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>医師固定C</nobr></td>
              <td></td>
              <td><s:textfield name="searchDocNo" size="30" maxlength="30" type="search" style="width:100pt;"/></td>
              <td></td>
              <s:if test='mrAdminFlg == "0"'>
                  <td class="comTableSearchItem" style="width:50pt; color:lightgray;"><nobr>医師属性</nobr></td>
                  <td></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                      <select disabled Style="width:100pt"></select>
                  </td>
              </s:if>
              <s:else>
                  <td class="comTableSearchItem" style="width:50pt;"><nobr>医師属性</nobr></td>
                  <td></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                      <s:select id="searchDocAttribute" name="searchDocAttribute" cssStyle="width:100pt" list ="searchDocAttributeCombo"/>
                  </td>
              </s:else>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
                      　　<tr>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>出身校</nobr></td>
              <td></td>
              <td class="comPortalControlItem" style="text-align:left;">
                  <s:select id="searchMedSch" name="searchMedSch" cssStyle="width:100pt" list ="searchMedSchCombo"/>
              </td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>卒年(西暦)</nobr></td>
              <td></td>
              <td class="comPortalControlItem" style="text-align:left;">
                  <s:select id="searchGradYear" name="searchGradYear" cssStyle="width:100pt" list ="searchGradYearCombo"/>
              </td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>出身医局校</nobr></td>
              <td></td>
              <td class="comPortalControlItem" style="text-align:left;">
                  <s:select id="searchHUniv" name="searchHUniv" cssStyle="width:100pt" list ="searchHUnivCombo"/>
              </td>
            </tr>
            <tr>
              <td class="comTableSearchItem" style="width:50pt;">組織</td>
                  <td align="right"><input class="comButton" type="button" value="選択" onClick="soshikiPopBtn();" /></td>
                  <td class="comPortalControlItem">
                         <s:textfield name="searchSosNm" size="24" maxlength="24" cssClass="mediumGray" readonly="true"/>
						<s:hidden name="searchSosCd" id="searchSosCd"/>
       					<s:hidden name="searchSosRank" id="searchSosRank"/>
                  </td>
                  <td><a href="#" class="comMiniLink" onclick="cdrClear('searchSos');return false;">clear</a>&nbsp;</td>
                  <td class="comTableSearchItem" style="width:50pt;"><nobr>担当者</nobr></td>
                  <td align="right"><input class="comButton" type="button" value="選択" onClick="tantoPopBtn();" /></td>
                  <td class="comPortalControlItem">
                       <s:textfield name="searchTantoNm" size="24" maxlength="24" cssClass="mediumGray" readonly="true"/>
       					<s:hidden name="searchTantoCd" id="searchTantoCd"/>
                   </td>
                   <td><a href="#" class="comMiniLink" onclick="cdrClear('searchTanto');return false;">clear</a>&nbsp;</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="comTableSearchItem"><nobr>施設固定C</nobr></td>
              <td></td>
              <td class="comPortalControlItem">
                  <s:textfield name="searchInsNo" size="30" maxlength="30" type="search" style="width:100pt;"/>
              </td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>施設名</nobr></td>
              <td align="right">
              	<input class="comButton" type="button" name="button3" value="選択" onClick="JavaScript:tmpCseView();return false;" />
              </td>
              <td class="comPortalControlItem">
		        <s:textfield name="searchInsNm" id="searchInsNm" size="20" maxlength="40" cssClass="mediumGray" readonly="true"/>
              </td>
              <td ><a href="#" class="comMiniLink" onclick="cdrClear('searchIns');return false;">clear</a>&nbsp;
              </td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>所属部科</nobr></td>
              <td align="right">
              	<input class="comButton" type="button"name="button3" value="選択" onClick="JavaScript:tmpCdcView();return false;" />
              </td>
              <td class="comPortalControlItem">
                   <s:textfield name="searchDeptNm" id="searchDeptNm" size="20" maxlength="40" cssClass="mediumGray" readonly="true"/>
		                <s:hidden name="searchDeptCd" id="searchDeptCd"/>
              </td>
              <td style="width:50pt; text-align:left;"><a href="#" class="comMiniLink" onclick="cdrClear('searchDept');return false;" style="float:none;">clear</a>&nbsp;</td>
            </tr>
            <tr>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td align="right" colspan="2">
                <input type="button" name="search" value="検索" onclick="cdrSearch();">&nbsp;
                <input type="button" name="search" value="クリア" onclick="cdrClearAll();">
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
String docKanaAscClass = "comTableNoSort";
String docKanaDescClass = "comTableNoSort";
String docKanjAscClass = "comTableNoSort";
String docKanjDescClass = "comTableNoSort";
String docNoAscClass = "comTableNoSort";
String docNoDescClass = "comTableNoSort";

if ("1".equals(sortCondition)) {
	  docKanaDescClass = "comTableSort";
} else if ("2".equals(sortCondition)) {
	  docKanjAscClass = "comTableSort";
} else if ("3".equals(sortCondition)) {
	  docKanjDescClass = "comTableSort";
} else if ("4".equals(sortCondition)) {
	  docNoAscClass = "comTableSort";
} else if ("5".equals(sortCondition)) {
	  docNoDescClass = "comTableSort";
} else {
	docKanaAscClass = "comTableSort";
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
                  <table class="tkdDoc" border=1 cellpadding=2 cellspacing=0 style="width:1240px;">
                    <tr style="position: sticky; top:0; left:0;">
                            <td class="comTableTitle" style="width:8pt;"><nobr>選択</nobr></td>
                            <td class="comTableTitle" style="width:110px;">氏名漢字
                            <s:if test=' !(hcpDataList== null || hcpDataList.size() <= 0)'>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanjAscClass %>" href="" onclick="cdrSort(2);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanjDescClass %>" href="" onclick="cdrSort(3);return false;">▼</a>
                            </s:if>
                            </td>
                            <td class="comTableTitle" style="width:110px;">氏名カナ
                            <s:if test=' !(hcpDataList== null || hcpDataList.size() <= 0)'>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaAscClass %>" href="" onclick="cdrSort(0);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaDescClass %>" href="" onclick="cdrSort(1);return false;">▼</a>
                            </s:if>
                            </td>
                            <td class="comTableTitle" style="width:110px;">医師固定C
                            <s:if test=' !(hcpDataList== null || hcpDataList.size() <= 0)'>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docNoAscClass %>" href="" onclick="cdrSort(4);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docNoDescClass %>" href="" onclick="cdrSort(5);return false;">▼</a>
                            </s:if>
                            </td>
                            <td class="comTableTitle"><nobr>生年月日</nobr></td>
                            <td class="comTableTitle"><nobr>出身校</nobr></td>
                            <td class="comTableTitle"><nobr>卒年</nobr></td>
                            <td class="comTableTitle"><nobr>出身医局校</nobr></td>
                            <td class="comTableTitle"><nobr>医師／薬剤師区分</nobr></td>
                            <td class="comTableTitle"><nobr>施設略式漢字名（所属部科名：役職名）</nobr></td>
                            <td class="comTableTitle" style="width:20px;"><nobr>旧姓</nobr></td>
                        </tr>
             <s:iterator value="hcpDataList" status="status" var="rowBean">
                  <tr>
					<td class="pupButton" style="height:90%;" >
					<input class="pupButton" type="button" value="" OnClick="csdSelectDoc(
					'<s:property value="#rowBean.docNo" />',
					'<s:property value="#rowBean.docKanj" />'
					);"></input></td>

                                  <td class="comTableItem" style="width:110px; height:18px;"><nobr><s:property value="#rowBean.docKanj"/></nobr></td>
                                  <td class="comTableItem" style="width:110px"><nobr><s:property value="#rowBean.docKana"/></nobr></td>
                                  <td class="comTableItem" style="width:110px"><nobr><s:property value="#rowBean.docNo"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.dob"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.univKj"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.grdaYear"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.ikyokuKj"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.docKbn"/></nobr></td>
                                  <td class="comTableItem"><s:property value="#rowBean.insName.replaceAll('\\n', '<br />')" escape="false"/></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.oldKanjSei"/></nobr></td>
                                  <!-- <td class="comTableItem"><nobr>横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列</nobr></nobr></td> -->
                              </tr>
                            </s:iterator>
                      </tbody>
                  </table>
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
				<td class="comPortalControlItem"><input type="button" name="bCancel" value="閉じる" OnClick="cdrClose();"></td>
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
