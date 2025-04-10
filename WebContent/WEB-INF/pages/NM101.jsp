<%--
/**
 * <pre>
 *  通知一覧のJSP
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author
 * @see jp.co.takeda.maps.command.jgikanren.jkrinsmrchange.JkrInsMrChangeViewFrontCommand
 */
 --%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="java.util.Enumeration"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="jp.co.takeda.rdm.util.AppMethods"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>


<%@ page
  language="java"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
//String title = (String)request.getAttribute("title");
//String execDate = (String)request.getAttribute("execDate");
//ValueStack stack = (ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
//JKR040C010DTO dto = new JKR040C010DTO();
//if (stack.peek() instanceof JKR040C010DTO) {
//  dto = (JKR040C010DTO)stack.peek();
//}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>NM101_通知内容詳細</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <%-- 040C共通のjs --%>
    <!-- <script type="text/javascript" src="js/JKR040C000.js"></script>-->

    <script type="text/javascript" src="js/NM101.js"></script>
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/JKR040C010.js"></script>
    <!--<script type="text/javascript" src="js/RDMNC011.js"></script>-->
    <script type="text/javascript" src="js/catTkCityCombo.js"></script>
    <script type="text/javascript" src="js/imtInsInputCategores.js"></script>
    <script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
    <script type="text/javascript" src="js/jkrMenu.js"></script>
    <script>
    function comSetFormWindowInfo(){
    	comClickFlgInit();
    }
    </script>
     <script>
        function handleCheckboxChange(checkbox) {
            if (checkbox.checked) {

    			document.fm1.dataDupCheck.disabled = true;
    			document.fm1.dataDupCheck.checked = false;
    			document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.ultRnkCheck.disabled = true;
    			document.fm1.ultRnkCheck.checked = false;
    			document.fm1.ultRnkCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.fbResCheck.disabled = true;
    			document.fm1.fbResCheck.checked = false;
    			document.fm1.fbResCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.consCheck.disabled = true;
    			document.fm1.consCheck.checked = false;
    			document.fm1.consCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.othersCheck.disabled = true;
    			document.fm1.othersCheck.checked = false;
    			document.fm1.othersCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.unconCheck.disabled = true;
    			document.fm1.unconCheck.checked = false;
    			document.fm1.unconCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.ubderCheck.disabled = true;
    			document.fm1.ubderCheck.checked = false;
    			document.fm1.ubderCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.resolvCheck.disabled = true;
    			document.fm1.resolvCheck.checked = false;
    			document.fm1.resolvCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.dataDupCheck.disabled = true;
    			document.fm1.dataDupCheck.checked = false;
    			document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.jkrSosNtySubject.disabled = true;
    			document.fm1.jkrSosNtySubject.value = "";
    			document.fm1.jkrSosNtySubject.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.jkrSosNtyPri.disabled = true;
    			//document.getElementById("jkrSosNtyPri").readOnly = true;

    			document.fm1.jkrSosNtyPri.value = "3";
    			document.fm1.jkrSosNtyPri.style.backgroundColor = JKR_BG_COLOR_DISABLED;

    			document.fm1.inHisYmdhmsFrom.value = document.fm1.knYmdhmsFrom.value;
    			document.fm1.inHisYmdhmsTo.value = document.fm1.knYmdhmsTo.value;
    			document.fm1.inHisYmdhmsFrom.disabled = true;
    			//document.getElementById("inHisYmdhmsFrom").readOnly = true;
    			document.fm1.inHisYmdhmsFrom.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    			document.fm1.inHisYmdhmsTo.disabled = true;
    			//document.getElementById("inHisYmdhmsTo").readOnly = true;
    			document.fm1.inHisYmdhmsTo.style.backgroundColor = JKR_BG_COLOR_DISABLED;

        		document.getElementById('jkrSosNtySubject').options[1].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[2].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[3].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[4].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[5].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[6].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[7].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[8].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[9].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[10].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[11].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[12].hidden=true;
        		document.getElementById('jkrSosNtySubject').options[13].hidden=true;

        		document.getElementById('jkrSosNtyPri').options[1].hidden=true;
        		document.getElementById('jkrSosNtyPri').options[2].hidden=true;
        		document.getElementById('jkrSosNtyPri').options[3].hidden=true;

            } else {

        		document.fm1.dataDupCheck.disabled = false;
        		document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.ultRnkCheck.disabled = false;
    			document.fm1.ultRnkCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.fbResCheck.disabled = false;
    			document.fm1.fbResCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.consCheck.disabled = false;
    			document.fm1.consCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.othersCheck.disabled = false;
    			document.fm1.othersCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.unconCheck.disabled = false;
    			document.fm1.unconCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.ubderCheck.disabled = false;
    			document.fm1.ubderCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.resolvCheck.disabled = false;
    			document.fm1.resolvCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.dataDupCheck.disabled = false;
    			document.fm1.dataDupCheck.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.inHisYmdhmsFrom.disabled = false;
    			document.fm1.inHisYmdhmsFrom.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    			document.fm1.inHisYmdhmsTo.disabled = false;
    			document.fm1.inHisYmdhmsTo.style.backgroundColor = JKR_BG_COLOR_NORMAL;
        		document.fm1.jkrSosNtySubject.disabled = false;
        		document.fm1.jkrSosNtySubject.style.backgroundColor = JKR_BG_COLOR_NORMAL;
        		document.fm1.jkrSosNtyPri.disabled = false;
        		document.fm1.jkrSosNtyPri.style.backgroundColor = JKR_BG_COLOR_NORMAL;
        		document.getElementById('jkrSosNtySubject').options[1].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[2].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[3].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[4].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[5].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[6].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[7].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[8].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[9].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[10].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[11].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[12].hidden=false;
        		document.getElementById('jkrSosNtySubject').options[13].hidden=false;

        		document.getElementById('jkrSosNtyPri').options[1].hidden=false;
        		document.getElementById('jkrSosNtyPri').options[2].hidden=false;
        		document.getElementById('jkrSosNtyPri').options[3].hidden=false;

            }
        }
    </script>
        <style>
    .parent {
        display:flex;
        align-items:cener;
        gap:0;
    }
    thead {
        position:Sticky;
        top:0;
        background-color: #fff;
        left: 2;
        }
    th {
    	background-color: #ffffff;
    	border: 1px solid black;
        height:2px;
    }
    </style>
    <style>
   TABLE.comPortalTable{
    width:900px;
    }
   TABLE.comPortalTable2{
    width:1400px;
    style="align:center"
    }
	    .testlayout {
	    }
		.siz{
		width:1700px;
		}
	TH.comTableTitle			/* テーブル形式のタイトル項目 */
       {
         color : #000000;
         background-color: #e0e0d4;
       /*	background-color: #cccccc;*/
         background-color: #e8b5a2;

         border-style: solid;
         border-top-width : 1px;
         border-left-width : 1px;
         border-right-width : 1px;
         border-bottom-width : 1px;
                   /*テーブル幅可変*/
	      resize : horizontal;
		  overflow : hidden;
		  font-weight:normal;
       }
       	TD.comTableTitle			/* テーブル形式のタイトル項目 */
       {
         color : #000000;
         background-color: #e0e0d4;
       /*	background-color: #cccccc;*/
         background-color: #e8b5a2;

         border-style: solid;
         border-top-width : 1px;
         border-left-width : 1px;
         border-right-width : 1px;
         border-bottom-width : 1px;
                   /*テーブル幅可変*/
	      resize : horizontal;
		  overflow : hidden;
		  font-weight:normal;
       }
       TD.tkdUlt:nth-child(1) {
         position: sticky;
         left: 0;
         z-index:100;
       }
       TD.tkdUlt:nth-child(2) {
         position: sticky;
         left: 109;
         z-index:100;
       }
       TD.tkdUlt:nth-child(3) {
         position: sticky;
         left: 259;
         z-index:100;
       }
	</style>
<%
// ソート順状態制御用
String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
//String sortCondition = null;
%>
	 <%
	  // ソート表示状態制御
	  String ntyIdAscClass = "comTableNoSort";
	  String ntyIdDescClass = "comTableNoSort";
	  String hisYmdhmsAscClass = "comTableNoSort";
	  String hisYmdhmsDescClass = "comTableNoSort";

	  if ("1".equals(sortCondition)) {
		  ntyIdDescClass = "comTableSort";
	  } else if ("2".equals(sortCondition)) {
		  hisYmdhmsAscClass = "comTableSort";
	  } else if ("3".equals(sortCondition)) {
		  hisYmdhmsDescClass = "comTableSort";
	  }
	%>
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript: NM011Seni();comSetFormWindowInfo();">

  <%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>


 <table class="comPortalTable" align="center" style="width:98%;">
   <tr>
	<td>
    <s:form name="fm1" theme="simple" >
    <s:hidden name="screenId"  />
    <s:hidden name="functionId" />

    <s:hidden id="pageFlag" name="pageFlag" />
    <s:hidden id="jokenFlg" name="jokenFlg" />

    <input type="hidden" name="windowName" value="" />
    <input type="hidden" name="openerName" value="" />

	<s:hidden id="mrAdminCd" name="mrAdminCd"/>
    <s:hidden id="mrAdminFlg" name="mrAdminFlg"/>
    <s:hidden id="preScreenId" name="preScreenId"/>

	<s:hidden name="reqFlg" />
	<s:hidden name="ntyId" />
	<s:hidden id="jgiNo" name="jgiNo"/>
    <s:hidden id="jgiName" name="jgiName"/>
    <s:hidden id="reqJgiName"/>

	<s:hidden id="reqJgiNo" name="reqJgiNo"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="knYmdhmsFrom" name="knYmdhmsFrom"/>
	<s:hidden id="knYmdhmsTo" name="knYmdhmsTo"/>

<!--  	<s:hidden id="reqId" name="reqId"/>
	<s:hidden id="reqType" name="reqType"/>-->

	<s:hidden id="sortCondition" name="sortCondition" />
	<s:hidden name="title" />
	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="sosCd" name="sosCd"/>
<!--  <s:hidden id="bumonRyakuName" name="bumonRyakuName"/>  申請者所属-->
    <s:hidden id="brCode" name="brCode"/><!-- 申請者所属リージョン -->
	<s:hidden id="distCode" name="distCode"/><!-- 申請者所属エリア -->
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="通知一覧"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>

<%-- ポータルタイトル 終了 --%>
<%-- ポータルボディー 開始 --%>

	<table class="comPortalBody" style="align:cener;">
		<tbody>
      	<tr align="center">
       	<td>
				<%-- 検索部 開始 --%>
			<table width="100%">
   		<tr>
             <td align="center">
               <jsp:include page="common/rdmMsg.jsp">
               <jsp:param name="" value="" />
               </jsp:include>
             </td>
         </tr>
      </table>
	<table class="comPortalTable" style="align:left;">
		<tr style="align:left;">	<%-- 申請者 --%>
			<td class="comPortalTable"><nobr>通知ID</nobr></td>
		      <td class="comPortalTable"><nobr><s:label name="ntyId"/></nobr></td>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			 <td class="comPortalTable"><nobr>最終更新日</nobr></td>
		      <td class="comPortalTable"><nobr><s:label name="ssUpdYmdhms"/></nobr></td>
			</tr>
			<tr>	<%-- 申請者 --%>
			<td class="comPortalTable"><nobr>発生日</nobr></td>
		      <td class="comPortalTable"><nobr><s:label name="hisYmdhmsTo"/></nobr></td>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			 <td class="comPortalTable"><nobr>最終更新者</nobr></td>
		      <td class="comPortalTable"><nobr><s:label name="JgiName"/></nobr></td>
		</tr>
		<tr style="align:left;">	<%-- 申請者 --%>

							<%-- 優先度--%>
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td class="comPortalTable"><nobr>&nbsp;通知ステータス</nobr></td>
	            <td class="comPortalTable">
				<s:select id="jkrSosNtySts" name="ntySts" cssStyle="width:80pt" list ="jkrSosNtySts" />
			    </td>
		</tr>
		<tr style="align:left;">	<%-- 申請者 --%>
		<td class="comPortalTable"><nobr>通知分類</nobr></td>
	      <td class="comPortalTable"><nobr><s:label name="ntyBri"/></nobr></td>
		</tr>
		<tr style="align:left;">	<%-- 申請者 --%>
		<td class="comPortalTable"><nobr>通知件名</nobr></td>
	      <td class="comPortalTable"><nobr><s:label name="ntySubject"/></nobr></td>
		</tr>
		<tr style="align:left;">
		<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td class="pupControlItem"><nobr>&nbsp;申請ID検索</nobr><!-- ReqShz,bumonRyakuName -->
			</td>
				<td>
					<s:textfield size="20" maxlength="40" name="reqId" STYLE="ime-mode:active" />
					 <nobr><s:submit value="表示" name="表示" onclick="rdmSearch('reqId')"/>
			   		</nobr>
				</td>
		</tr>
	</table>
	<table class="comPortalTable" style="align:left;">
		<tr style="align:left;">	<%-- 申請者 --%>
		<td class="comPortalTable"><nobr>通知内容</nobr></td>
		</tr>
	</table>
	<div style="max-height:320px;border: 1px solid black;width:850px;overflow-y:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
	<table class="comPortalTable" style="align:left;">
	<tr style="align:left;">
		      <td class="comPortalTable"><s:property  value="ntyData.replaceAll('\\n', '<br/>')" escape="false" /><br></td><br>
	</tr>
	</table>
	<!--	  <td class="comPortalTable"><s:property  value="ntyData2.replaceAll('\\n', '<br/>')" escape="false" /><br></td>
		      <td class="comPortalTable"><s:property  value="ntyData3.replaceAll('\\n', '<br/>')" escape="false" /><br></td>
		      <td class="comPortalTable"><s:property  value="ntyData4.replaceAll('\\n', '<br/>')" escape="false" /><br></td>
		      <td class="comPortalTable"><s:property  value="ntyData5.replaceAll('\\n', '<br/>')" escape="false" /><br></td>
	  -->
		</div>
	<table class="comPortalTable" >
		<tr >	<%-- 申請者 --%>
		<td class="comPortalTable"><nobr>メモ</nobr></td>
		</tr>
	</table>
	<table>
      <tr>
	      <td ><nobr><s:textarea name="ntyMemo"  cols="50" rows="3" maxlength="250" style="width: 850px; height: 80px;" escape="false" /></nobr></td>
      </tr>
	</table>
	<!-- <div style="max-height:160px;width:1000px;overflow-y:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
	<table>
	<tr>
		      <td class="comPortalTable"><nobr><s:textarea name="ntyMemo.replaceAll('\\n', '<br/>')"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;" escape="false" /></nobr></td>

		     	      <td class="comPortalTable"><nobr><s:label name="ntyMemo"/></nobr></td>
		     	      <td class="comPortalTable"><nobr><s:property  value="ntyData.replaceAll('\\n', '<br/>')" escape="false" /></nobr></td>

	</tr>
	</table>
		</div> -->
			<table  class="comPortalTable" style="align:center">
						<tr>
							<td class="comFormTableItem"align="center"><nobr>
									<input class="comButton" type="button" name="buttonF1"
										value="戻る" onClick="JavaScript:backBtn();return false;" />
								</nobr></td>
								<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
								<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
								<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
								<td class="comFormTableItem"align="right"><nobr>

									<input class="comButton" type="button" name="buttonF1"
										value="保存" onClick="JavaScript:rdmRegister();return false;" />
								</nobr></td>
						</tr>
			</table>

									<%-- メイン部 一覧 終了    key="catDeptsComboDataList[%{#status.index}].addrNameArea" --%>
						  <!--  <hr class="comSplit" /> -->
						  <%-- 後制御部 --%>
						            </td>
          </tr>
          </tbody>
          </table>
	</s:form>
	    </td>
    </tr>
  </table>

<%-- ポータルボディー 終了 --%>


<%-- メイン部 一覧 終了 --%>
<%-- ポータル大枠 終了 --%>
<jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
