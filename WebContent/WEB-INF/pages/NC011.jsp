<%--
/**
 * <pre>
 *  施設・領域別担当変更のJSP
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
<!--<%@page import="jp.co.takeda.rdm.dto.JKR040C010DTO"%>
<%@page import="jp.co.takeda.rdm.dto.ChgInsTrtList"%>
<%@page import="jp.co.takeda.rdm.dto.ChgInsTrtTrtList"%>-->
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
    <title>施設別・地区別（施設）担当変更</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <%-- 040C共通のjs --%>
    <!-- <script type="text/javascript" src="js/JKR040C000.js"></script>-->

    <script type="text/javascript" src="js/NC011.js"></script>
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
<%


// ソート順状態制御用
String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
//String sortCondition = null;
%>
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">




<table class="comPortalControlTable" style="margin-top:3pt;margin-bottom:1pt;" border="0"></table>
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
<table class="comPortalTable" align="center" style="width:95%;margin-top:0pt">
  <tbody>
  <tr/>
    <s:form name="fm0" theme="simple">
         <input type="hidden" name="endRecordNo1"   value=""  />
    </s:form>
    <s:form name="fm1" theme="simple" >
    <s:hidden name="screenId"  />
    <s:hidden name="functionId" />
    <input type="hidden" name="windowName" value="" />
    <input type="hidden" name="openerName" value="" />

	<s:hidden id="mrAdminCd" name="mrAdminCd"/>
    <s:hidden id="mrAdminFlg" name="mrAdminFlg"/>

	<s:hidden id="jgiNo" name="jgiNo"/>
    <s:hidden id="jgiName" name="jgiName"/>


	<s:hidden id="reqJgiNo" name="reqJgiNo"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="knYmdhmsFrom" name="knYmdhmsFrom"/>
	<s:hidden id="knYmdhmsTo" name="knYmdhmsTo"/>

<!--  	<s:hidden id="reqId" name="reqId"/>
	<s:hidden id="reqType" name="reqType"/>-->

	<s:hidden id="sortCondition" name="sortCondition" />

    <s:hidden id="reqBrCode" name="reqBrCode"/><!-- 申請者所属リージョン -->
	<s:hidden id="reqDistCode" name="reqDistCode"/><!-- 申請者所属エリア -->

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

	<CENTER>
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
<table>
<%
  // ソート表示状態制御
  String reqIdAscClass = "comTableNoSort";
  String reqIdDescClass = "comTableNoSort";
  String reqYmdhmsAscClass = "comTableNoSort";
  String reqYmdhmsDescClass = "comTableNoSort";
  String reqSbtAscClass = "comTableNoSort";
  String reqSbtDescClass = "comTableNoSort";
  String reqTypeAscClass = "comTableNoSort";
  String reqTypeDescClass = "comTableNoSort";
  String reqStsAscClass = "comTableNoSort";
  String reqStsDescClass = "comTableNoSort";
  String sbtAscClass = "comTableNoSort";
  String sbtDescClass = "comTableNoSort";
  String reqJgiNameAscClass = "comTableNoSort";
  String reqJgiNameDescClass = "comTableNoSort";
  if ("1".equals(sortCondition)) {
	  reqIdDescClass = "comTableSort";
  } else if ("2".equals(sortCondition)) {
	  reqYmdhmsAscClass = "comTableSort";
  } else if ("3".equals(sortCondition)) {
	  reqYmdhmsDescClass = "comTableSort";
  } else if ("4".equals(sortCondition)) {
	  reqSbtAscClass = "comTableSort";
  } else if ("5".equals(sortCondition)) {
	  reqSbtDescClass = "comTableSort";
  } else if ("6".equals(sortCondition)) {
	  reqTypeAscClass = "comTableSort";
  } else if ("7".equals(sortCondition)) {
	  reqTypeDescClass = "comTableSort";
  } else if ("8".equals(sortCondition)) {
	  reqStsAscClass = "comTableSort";
  } else if ("9".equals(sortCondition)) {
	  reqStsDescClass = "comTableSort";
  } else if ("10".equals(sortCondition)) {
	  sbtAscClass = "comTableSort";
  } else if ("11".equals(sortCondition)) {
	  sbtDescClass = "comTableSort";
  } else if ("12".equals(sortCondition)) {
	  reqJgiNameAscClass = "comTableSort";
  } else if ("13".equals(sortCondition)) {
	  reqJgiNameDescClass = "comTableSort";
  }
%>
	<tr>

				<%-- 都道府県--%>
		    <td class="pupControlItem"><nobr>&nbsp;都道府県</nobr></td>
            <td class="comTableSearchItem">
			<s:select id="jkrSosAddrCd" name="aDdrCodePref" cssStyle="width:80pt" list ="jkrSosAddrMap" />


		    </td>
				<%-- 種別 --%>
			<td class="pupControlItem"><nobr>&nbsp;種別</nobr></td>
            <td class="comTableSearchItem">
            <span onchange="sosSbt(); return false;">
			<s:select id="jkrSosSbtMap" name="sbt" cssStyle="width:80pt" list ="jkrSosSbtMap" />
			</span>
		    </td>
	</tr>
	<tr>
						<%-- 申請者所属 --%>
			<td class="pupControlItem"><nobr>&nbsp;申請者所属</nobr></td>
				<td>
				<nobr><s:submit value="選択" name="選択" onclick="this.form.action='%{inSearchInput}';  this.form.submit();return false;" onkeypress="if(event.keyCode==13){event.returnValue=false}" />
					<s:textfield size="20" maxlength="40" name="reqShz" STYLE="ime-mode:active" /></nobr>
				</td>
							<%-- 施設固定C --%>
			<td class="pupControlItem"><nobr>&nbsp;施設固定C</nobr></td>
				<td>
					<s:textfield size="20" maxlength="14" name="insNo" style="ime-mode:inactive;" />
				</td>
					<%--医師固定C --%>
			<td class="pupControlItem"><nobr>&nbsp;医師固定C</nobr></td>
				<td>
					<s:textfield size="20" maxlength="14" name="docNo" style="ime-mode:inactive;" />
				</td>
	</tr>
	<tr>	<%-- 申請者 --%>
			<s:if test='mrAdminFlg == "0"'>
			<td class="pupControlItem"><nobr>&nbsp;申請者</nobr></td>
				<td>

					 <s:textfield readonly="true" Style="width:100pt" name="jgiName" cssStyle="background-color:#D4D0C8;"/>
				</td>
				</s:if>
			<s:if test='mrAdminFlg == "1"'>
			<td class="pupControlItem"><nobr>&nbsp;申請者</nobr></td>
				<td>
					<s:textfield size="20" maxlength="40" name="reqJgiName" STYLE="ime-mode:active" />
				</td>
				</s:if>


					<%-- 施設名(全角) --%>
			<td class="pupControlItem"><nobr>&nbsp;施設名(全角)※</nobr></td>
				<td>
					<s:textfield size="20" maxlength="40" name="insKanjiSrch" STYLE="ime-mode:active" />
				</td>
						<%-- 医師名(全角) --%>
			<td class="pupControlItem"><nobr>&nbsp;医師名(全角)</nobr></td>
				<td>
					<s:textfield size="20" maxlength="14" name="docKanj" style="ime-mode:inactive;" />
				</td>
	</tr>
	<tr>
						<%-- 申請日: 操作日-1カ月、操作日 --%>
			<td class="pupControlItem"><nobr>&nbsp;申請日</nobr></td>
				<td>
				<input type="date" name ="reqYmdhmsFrom"id="inreqYmdhmsFrom" value="${inreqYmdhmsFrom}" pattern="yyyy-MM-dd" />　～　
				<input type="date" name ="reqYmdhmsTo"  id="inreqYmdhmsTo" value="${inreqYmdhmsTo}" pattern="yyyy-MM-dd" />

				</td>
					　　<%-- 施設分類 --%>
			<td class="pupControlItem"><nobr>&nbsp;施設分類</nobr></td>
	            <td class="comTableSearchItem">
					<s:select id="jkrSosReqStsMap" name="insClass" cssStyle="width:80pt" list ="jkrSosInsClassMap" />
			    </td>
				<%-- 医師／薬剤師区分 --%>
			<td class="pupControlItem"><nobr>&nbsp;医師／薬剤師区分</nobr></td>
	            <td class="comTableSearchItem">
					<s:select id="jkrSosReqStsMap" name="docType" cssStyle="width:80pt" list ="jkrSosDocTypeMap" />
			    </td>
	</tr>

	<tr>
						<%--連携種別 --%>
			<td class="pupControlItem"><nobr>&nbsp;連携種別</nobr></td>
            <td class="comTableSearchItem">
            <span onchange="sosReqSbt(); return false;">
				<s:select id="jkrSosReqSbtMap" name="reqSbt" cssStyle="width:80pt" list ="jkrSosReqSbtMap" />
				</span>
		    </td>





						<%-- 施設種別 --%>
			<td class="pupControlItem"><nobr>&nbsp;施設種別</nobr></td>
	            <td class="comTableSearchItem">
					<s:select id="jkrSosReqStsMap" name="insSbt" cssStyle="width:80pt" list ="jkrSosInsSbtMap" />
			    </td>
				<%-- 勤務形態 --%>
			<td class="pupControlItem"><nobr>&nbsp;勤務形態 </nobr></td>
	            <td class="comTableSearchItem">
					<s:select id="jkrSosReqStsMap" name="jobForm" cssStyle="width:80pt" list ="JkrSosJobFormMap" />
			    </td>
	</tr>
	<tr>
						<%-- 申請区分 --%>
			<td class="pupControlItem"><nobr>&nbsp;申請区分</nobr></td>
            <td class="comTableSearchItem">
			<s:select id="jkrSosReqTypeMap" name="reqType" cssStyle="width:80pt" list ="jkrSosReqTypeMap" />
		    </td>
						<%-- 対象区分 --%>
			<td class="pupControlItem"><nobr>&nbsp;対象区分</nobr></td>
	            <td class="comTableSearchItem">
				<s:select id="jkrSosReqStsMap" name="hoInsType" cssStyle="width:80pt" list ="jkrSosHoInsTypeMap" />
			    </td>
	</tr>
	<tr>
						<%-- 申請ステータス --%>
			<td class="pupControlItem"><nobr>&nbsp;申請ステータス</nobr></td>
	            <td class="comTableSearchItem">
					<s:select id="jkrSosReqStsMap" name="reqSts" cssStyle="width:80pt" list ="jkrSosReqStsMap" />
			    </td>
	</tr>
	<tr>
						<%-- 申請ID --%>
			<td class="pupControlItem"><nobr>&nbsp;申請ID</nobr></td>
				<td>
					<s:textfield size="20" maxlength="40" name="reqId" STYLE="ime-mode:active" />
				</td>
						<%-- 申請コメント --%>
			<td class="pupControlItem"><nobr>&nbsp;申請コメント</nobr></td>
				<td>
					<s:textfield size="20" maxlength="14" name="reqComment" style="ime-mode:inactive;" />
				</td>
				<%-- 承認・却下コメント --%>
			<td class="pupControlItem"><nobr>&nbsp;承認・却下コメント</nobr></td>
				<td>
					<s:textfield size="20" maxlength="40" name="aprComment" STYLE="ime-mode:active" />
				</td>
	</tr>
	<tr>
				<!-- 申請チャネル -->
				<s:if test='mrAdminFlg == "0"'>
				</s:if>
				<s:if test='mrAdminFlg == "1"'>
				<td class="pupControlItem"><nobr>&nbsp;申請チャネル</nobr></td>
	            <td class="comTableSearchItem">
	            <span onchange="sosAddrChange(); return false;">
					<s:select id="jkrSosReqChlMap" name="reqChl" cssStyle="width:80pt" list ="jkrSosReqChlMap" />
			    </span>
			    </td>
				</s:if>
	</tr>


</table>
<%-- ページャー表示 開始 --%>
                 <!-- 改ページ -->
                  <table width="95%" >
                      <tbody>
                      <tr align="right">
                          <td>
                            <!-- 前頁リンク -->
                            <s:if test="pageCntCur > 1">
                            <nobr>
                                <a class="comMiniLink" href = "" onClick="NC011Page(<s:property value="pageCntCur-1"/>);return false;">
                                &lt;&lt; 前
                                </a>&nbsp;
                            </nobr>
                            </s:if>

                            <!-- ページ基準の前頁リンク -->
                            <s:if test="pageCntBase > 1">
                              <a class="comMiniLink"  href="" style="" onClick="NC011Page(<s:property value="pageCntBase-1"/>);return false;">
                              <nobr>～<s:property value="pageCntBase-1"/></nobr></a>
                            </s:if>

                            <!-- 各ページリンク作成 -->
                            <s:if test="pageCntAll > 1">
                              <s:iterator value="{'0','1','2','3','4','5','6','7','8','9'}" var="pageIndex" status="status">
                                <s:set var="pageCntCurTemp" value="#status.index + pageCntBase" />
                                <s:if test="#pageCntCurTemp <= pageCntAll">
                                  <s:if test="#pageCntCurTemp != pageCntCur">
                                    <a  class="comMiniLink"  href="" style="" onClick="NC011Page(<s:property value="#pageCntCurTemp"/>);return false;">
                                    <nobr><s:property value="#pageCntCurTemp"/></nobr></a>
                                  </s:if>
                                  <s:else>
                                    <!-- 現在ページはリンクではない -->
                                    <a  class="comMiniLink"  style="text-decoration:none;">
                                    <nobr><s:property value="#pageCntCurTemp"/></nobr></a>
                                  </s:else>
                                </s:if>
                              </s:iterator>
                            </s:if>
                            <!-- 次のグループ -->
                            <s:if test="(#pageCntBase + 10) <= pageCntAll">
                                &nbsp;
                                <a  class="comMiniLink"  href="" style="" onClick="NC011Page(<s:property value="#pageCntCurTemp-1"/>);return false;">
                                <nobr><s:property value="pageCntBase + 10"/>～</nobr></a>
                            </s:if>

                            <!-- 次頁  -->
                            <s:if test="pageCntCur < pageCntAll">
                              <nobr>&nbsp;
                                <a class="comMiniLink" href = "" onClick="NC011Page(<s:property value="pageCntCur+1"/>);return false;">
                                  次&gt;&gt;
                                </a>
                              </nobr>
                            </s:if>

                                 <nobr>
                            <s:if test="lineCntAll > 0">
                              &nbsp;&nbsp;
                              <s:property value="lineCntAll"/>件中
                              <s:property value="lineCntStart"/>～<s:property value="lineCntEnd"/>件
                            </s:if>
                            <s:else>
                              &nbsp;0件
                            </s:else>
                            </nobr>
                          </td>
                      </tr>
                      </tbody>
                  </table>
          <%-- ページャー表示 終了 --%>
<table>
<tr>
<td>
   <input type="button" name="search" value="検索" onclick="rdmSearch();">
   </td>
   <td>
   <input type="button" name="クリア" value="クリア" onclick="rdmCler();" /></td>
   </tr>
   </table>
<a href="yourTargetPage.jsp?param=${yourValue}">${yourValue}ああああ</a>

 	<div id="osirase" align="center"  style="background-color:#ffffff; height:300px; overflow-y:scroll; border-width:1px; border-style:solid;">
  <table  align="center" style="width:2100px; cellpadding="2" cellspacing="0" border="0"  >
    <%-- 項目 --%>
	<tr class="comTableTitle">
		<td class="comTableTitle" style="width:90px; border:none;">申請ID
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqIdAscClass %>" href="" onclick="NC011Sort(0);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqIdDescClass %>" href="" onclick="NC011Sort(1);return false;">▼</a>
		</td>

		<td class="comTableTitle" style="width:90px; border:none;">申請日時
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqYmdhmsAscClass %>" href="" onclick="NC011Sort(2);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqYmdhmsDescClass %>" href="" onclick="NC011Sort(3);return false;">▼</a>
		</td>
		<td class="comTableTitle" style="width:50px; border:none;">連携種別
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqSbtAscClass %>" href="" onclick="NC011Sort(4);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqSbtDescClass %>" href="" onclick="NC011Sort(5);return false;">▼</a>
		</td>
		<td class="comTableTitle" style="width:40px; border:none;">申請区分
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqTypeAscClass %>" href="" onclick="NC011Sort(6);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqTypeDescClass %>" href="" onclick="NC011Sort(7);return false;">▼</a>
		</td>
	<td class="comTableTitle" style="width:70px; border:none;">申請ステータス
		 <span style="font-size: 1pt;"> </span>
	     <a class="<%=reqStsAscClass %>" href="" onclick="NC011Sort(8);return false;">▲</a>
	     <span style="font-size: 1pt;"> </span>
	     <a class="<%=reqStsDescClass %>" href="" onclick="NC011Sort(9);return false;">▼</a>
	</td>
	<td class="comTableTitle" style="width:30px; border:none;">種別
		 <span style="font-size: 1pt;"> </span>
	     <a class="<%=sbtAscClass %>" href="" onclick="NC011Sort(10);return false;">▲</a>
	     <span style="font-size: 1pt;"> </span>
	     <a class="<%=sbtDescClass %>" href="" onclick="NC011Sort(11);return false;">▼</a>
	</td>
	<td class="comTableTitle" style="width:80px; border:none;">施設／医師固定C</td>
	<td class="comTableTitle" style="width:80px; border:none;">施設／医師名</td>
	<td class="comTableTitle" style="width:70px; border:none;">申請者
		 <span style="font-size: 1pt;"> </span>
	     <a class="<%=reqJgiNameAscClass %>" href="" onclick="NC011Sort(12);return false;">▲</a>
	     <span style="font-size: 1pt;"> </span>
	     <a class="<%=reqJgiNameDescClass %>" href="" onclick="NC011Sort(13);return false;">▼</a>
	</td>
	<td class="comTableTitle" style="width:80px; border:none;">申請者所属</td>
    <td class="comTableTitle" style="width:80px; border:none;">申請コメント</td>
    <s:if test='mrAdminFlg == "1"'>
    <td class="comTableTitle" style="width:30px; border:none;">審査</td>
    <td class="comTableTitle" style="width:80px; border:none;">審査日時</td>
    <td class="comTableTitle" style="width:80px; border:none;">審査者</td>
    </s:if>
	<td class="comTableTitle" style="width:80px; border:none;">承認日時</td>
	<td class="comTableTitle" style="width:80px; border:none;">承認者</td>
	<td class="comTableTitle" style="width:80px; border:none;">審査・承認メモ</td>
	<td class="comTableTitle" style="width:80px; border:none;">承認・却下コメント</td>
	<s:if test='mrAdminFlg == "1"'>
	<td class="comTableTitle" style="width:30px; border:none;">FB申請要否</td>
    <td class="comTableTitle" style="width:80px; border:none;">FB回答</td>
    <td class="comTableTitle" style="width:30px; border:none;">FB処理区分</td>
    </s:if>
	</tr>
    <%-- 内容 --%>

    <s:iterator value="catSnseiComboDataList" status="status" var="rowBean">
	 <tr>
		  <td class="comTableItem" style="width:100px;">

		                               <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'"
                                        onClick="NC011Seni('<s:property  value="reqType" />');return false;">
                                           <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
                                                 <s:label  name="catSnseiComboDataList[%{#status.index}].reqId"  key="catSnseiComboDataList[%{#status.index}].reqId" />
                                              </acronym>

                                      </a>
		  </td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].reqYmdhmsTo"  key="catSnseiComboDataList[%{#status.index}].reqYmdhmsTo" /></td>
          <td class="comTableItem" style="width:10px; "><s:label  name="catSnseiComboDataList[%{#status.index}].reqSbt"  key="catSnseiComboDataList[%{#status.index}].reqSbt" /></td>
          <td class="comTableItem" style="width:10px; "><s:label  name="catSnseiComboDataList[%{#status.index}].reqType"  key="catSnseiComboDataList[%{#status.index}].reqType" /></td>
          <td class="comTableItem" style="width:10px; "><s:label  name="catSnseiComboDataList[%{#status.index}].reqSts"  key="catSnseiComboDataList[%{#status.index}].reqSts" /></td>
          <td class="comTableItem" style="width:65px; "><s:label  name="catSnseiComboDataList[%{#status.index}].sbt"  key="catSnseiComboDataList[%{#status.index}].sbt"/></td>
          <td class="comTableItem" style="width:65px; "><s:label  name="catSnseiComboDataList[%{#status.index}].insNo"  key="catSnseiComboDataList[%{#status.index}].insNo" /></td>
          <td class="comTableItem" style="width:300px;"><s:label  name="catSnseiComboDataList[%{#status.index}].insFormalName"  key="catSnseiComboDataList[%{#status.index}].insFormalName" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].reqJgiName"  key="catSnseiComboDataList[%{#status.index}].reqJgiName" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].reqShz"  key="catSnseiComboDataList[%{#status.index}].reqShz" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].reqComment"  key="catSnseiComboDataList[%{#status.index}].reqComment" /></td>
          <s:if test='mrAdminFlg == "1"'>
          <td class="comTableItem" style="width:300px;"><s:label  name="catSnseiComboDataList[%{#status.index}].shnFlg"  key="catSnseiComboDataList[%{#status.index}].shnFlg" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].shnYmdhms"  key="catSnseiComboDataList[%{#status.index}].shnYmdhms" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].shnShaId"  key="catSnseiComboDataList[%{#status.index}].shnShaId" /></td>
          </s:if>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].aPR_YMDHMS"  key="catSnseiComboDataList[%{#status.index}].aPR_YMDHMS" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].aPR_SHA_ID"  key="catSnseiComboDataList[%{#status.index}].aPR_SHA_ID" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].aPR_MEMO"  key="catSnseiComboDataList[%{#status.index}].aPR_MEMO" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].aprComment"  key="catSnseiComboDataList[%{#status.index}].aprComment" /></td>
      <s:if test='mrAdminFlg == "1"'>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].fbReqFlg"  key="catSnseiComboDataList[%{#status.index}].fbReqFlg" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].fbAnsId"  key="catSnseiComboDataList[%{#status.index}].fbAnsId" /></td>
          <td class="comTableItem" style="width:50px; "><s:label  name="catSnseiComboDataList[%{#status.index}].fbPrcType"  key="catSnseiComboDataList[%{#status.index}].fbPrcType" /></td>
      </s:if>
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
                <input type="button" value="戻る" OnClick="cdcClose();">
            </td>
        </tr>
    </table>
	</td></tr>
	</table>
</s:form>
    </tbody>
    </table>
<%-- ポータルボディー 終了 --%>
   <input type="hidden" name="dummy" value="dummy" />

<%-- メイン部 一覧 終了 --%>
<%-- ポータル大枠 終了 --%>

</body>
</html>
