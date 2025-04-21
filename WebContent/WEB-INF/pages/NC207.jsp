<%--
/**
 * <pre>
 * 公的機関編集ポップアップ
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.dto.NC207DTO"%>
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
//検索条件の制御-----------------------------------------------------------
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<title><%= "NC207_公的機関編集ポップアップ" %></title>
	<!--
	###################################################################
	CSSとJSは、common.css,jsとpopup.css,アプリケーション名.jsのみを
	入れること
	###################################################################
	-->
	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/popup.css" rel="Stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/catHcpPub.js"></script>
	</head>
<body OnLoad="chpLoad();" OnUnLoad="chpUnLoad();">

	<form class="comHidden" name="fm0" action="" method="POST">
		<input type="text" name="screenId"			value="">
		<input type="text" name="functionId"			value="">
		<input type="text" name="windowName"			value="">
		<input type="text" name="openerName"			value="">
		<input type="text" name="callBack"			value="">
		<input type="text" name="winVarName"			value="">

	</form>

	<form class="comHidden" name="fmData" action="">
	</form>

	<%-- 施設選択 開始 --%>

<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="公的機関編集"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>
<%-- ポータルタイトル 終了 --%>
<%-- ポータルボディー 開始 --%>
    <table class="comPortalBody">
    <tbody>
      <tr>
        <td>

	<!-- ポータル枠 開始 -->
	<table class="pupBodyTable" align="center">
	<tbody>
	<s:form name="fm1" theme="simple"><!-- フォームfm1開始 -->
 	<s:hidden name="hcpPublicDataChgFlg"/>
 	<s:hidden name="returnFlg"/>
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
    <s:hidden name="callBack" />
    <s:hidden name="title" />
    <s:hidden name="winVarName" />
	<s:hidden name="classCategoryNmPop"/>
	<s:hidden name="pubInstitutionNmPop"/>
	<s:hidden name="pubInstPositionNmPop"/>

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
  </td></tr>
  <tr><td>
		<!-- 前制御部 開始 -->
    <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:80%;">
      <tr>
        <%--基本情報--%>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>分類区分<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="classCategoryCdPop" name="classCategoryCdPop" cssStyle="width:80pt" list ="classCategoryCdCombo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>公的機関<font color="red" size="3">*</font></nobr></td>
<s:if test='%{hcpPublicDataChgFlg == "0"}'>
	      <td class="comFormTableItem"><nobr><s:select id="pubInstitutionCdPop" name="pubInstitutionCdPop" cssStyle="width:80pt" list ="pubInstitutionCdCombo" onchange='changeBox("1")'/></nobr></td>
</s:if>
<s:else>
	      <td class="comFormTableItem"><nobr><s:label key="pubInstitutionNmPop"/></nobr>
	      <s:hidden name="pubInstitutionCdPop"/>
	      </td>
</s:else>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>公的機関開始年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="pubInstStYYYYPop" name="pubInstStYYYYPop" cssStyle="width:40pt" list ="pubInstStYYYYCombo" onchange='changeBox("2")'/>年<s:select id="pubInstStMMPop" name="pubInstStMMPop" cssStyle="width:30pt" list ="pubInstStMMCombo" onchange='changeBox("2")'/>月<s:select id="pubInstStDDPop" name="pubInstStDDPop" cssStyle="width:30pt" list ="pubInstStDDCombo" onchange='changeBox("2")'/>日</nobr></td>
	      <td class="comFormTableItem"><nobr>公的機関終了年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="pubInstEdYYYYPop" name="pubInstEdYYYYPop" cssStyle="width:40pt" list ="pubInstEdYYYYCombo"/>年<s:select id="pubInstEdMMPop" name="pubInstEdMMPop" cssStyle="width:30pt" list ="pubInstEdMMCombo"/>月<s:select id="pubInstEdDDPop" name="pubInstEdDDPop" cssStyle="width:30pt" list ="pubInstEdDDCombo"/>日</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>公的機関役職</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="pubInstPositionCdPop" name="pubInstPositionCdPop" cssStyle="width:80pt" list ="pubInstPositionCdCombo" onchange='changeBox("3")'/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>公的機関役職開始年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="pubInstposStYYYYPop" name="pubInstposStYYYYPop" cssStyle="width:40pt" list ="pubInstposStYYYYCombo" onchange='changeBox("4")'/>年<s:select id="pubInstposStMMPop" name="pubInstposStMMPop" cssStyle="width:30pt" list ="pubInstposStMMCombo" onchange='changeBox("4")'/>月<s:select id="pubInstposStDDPop" name="pubInstposStDDPop" cssStyle="width:30pt" list ="pubInstposStDDCombo" onchange='changeBox("4")'/>日</nobr></td>
	      <td class="comFormTableItem"><nobr>公的機関役職終了年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="pubInstposEdYYYYPop" name="pubInstposEdYYYYPop" cssStyle="width:40pt" list ="pubInstposEdYYYYCombo"/>年<s:select id="pubInstposEdMMPop" name="pubInstposEdMMPop" cssStyle="width:30pt" list ="pubInstposEdMMCombo"/>月<s:select id="pubInstposEdDDPop" name="pubInstposEdDDPop" cssStyle="width:30pt" list ="pubInstposEdDDCombo"/>日</nobr></td>
      </tr>
  </table>
		</td></tr>
		<!-- 前制御部 終了 -->
		<tr><td>
		<!-- 後制御部 開始 -->
		<table class="comPortalControlTable comPortalControlTablePopup" align="center" style="width:440pt;">
		<tbody>
			<tr>
				<td class="comPortalControlItem"><input type="button" name="bCancel" value="戻る" OnClick="chpClose();"></td>
				<td width="85%"></td>
				<td class="comPortalControlItem">
				<s:if test='%{hcpPublicDataChgFlg == "0"}'>
				<!-- 新規 -->
					<input type="button" name="bRegister" value="適用" onClick="chpRegister('0');return false;" />
				</s:if>
				<s:else>
				<!-- 更新 -->
					<input type="button" name="bRegister" value="適用" onClick="chpRegister('1');return false;" />
				</s:else>
				</td>
			</tr>
		</tbody>
		</table>
		<!-- 後制御部 終了 -->

	</td></tr>

	</s:form>	<!-- フォームfm1終了 -->
	</tbody>
	</table>
	<!-- ポータル枠 終了 -->
	<!-- 施設選択 終了 -->

	</td>
	</tr>
	</tbody>
	</table>

</body>
</html>
