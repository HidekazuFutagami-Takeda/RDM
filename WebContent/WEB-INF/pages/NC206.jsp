<%--
/**
 * <pre>
 * 所属学会編集ポップアップ
 * </pre>
 * @since 1.0
 * @version $Revision: 1.2 $
 * @author
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.dto.NC206DTO"%>
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
	<title><%= "NC206_所属学会編集ポップアップ" %></title>
	<!--
	###################################################################
	CSSとJSは、common.css,jsとpopup.css,アプリケーション名.jsのみを
	入れること
	###################################################################
	-->
	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/popup.css" rel="Stylesheet" type="text/css" />
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/catHcpSoc.js"></script>
	</head>
<body OnLoad="chsLoad();" OnUnLoad="chsUnLoad();">

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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="所属学会編集"></td>
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
 	<s:hidden name="hcpSocietyDataChgFlg"/>
 	<s:hidden name="returnFlg"/>
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
    <s:hidden name="callBack" />
    <s:hidden name="title" />
    <s:hidden name="winVarName" />
	<s:hidden name="positionNamePop"/>
	<s:hidden name="advisingDoctorNmPop"/>
	<s:hidden name="certifyingPhysicianNmPop"/>

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
	      <td class="comFormTableItem"><nobr>所属学会名<font color="red" size="3">*</font></nobr></td>
<s:if test='%{hcpSocietyDataChgFlg == "0"}'>
	      <td class="comFormTableItem"><nobr><s:textfield name="medicalSocietyNmPop" size="15" maxlength="33" /></nobr></td>
</s:if>
<s:else>
	      <td class="comFormTableItem"><nobr><s:label key="medicalSocietyNmPop"/></nobr>
	      <s:hidden name="medicalSocietyNmPop"/>
	      </td>
</s:else>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>入会年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="admissionYYYYPop" name="admissionYYYYPop" cssStyle="width:40pt" list ="admissionYYYYCombo" onchange='changeBox("1")'/>年<s:select id="admissionMMPop" name="admissionMMPop" cssStyle="width:30pt" list ="admissionMMCombo" onchange='changeBox("1")'/>月<s:select id="admissionDDPop" name="admissionDDPop" cssStyle="width:30pt" list ="admissionDDCombo" onchange='changeBox("1")'/>日</nobr></td>
	      <td class="comFormTableItem"><nobr>退会年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="quitYYYYPop" name="quitYYYYPop" cssStyle="width:40pt" list ="quitYYYYCombo"/>年<s:select id="quitMMPop" name="quitMMPop" cssStyle="width:30pt" list ="quitMMCombo"/>月<s:select id="quitDDPop" name="quitDDPop" cssStyle="width:30pt" list ="quitDDCombo"/>日</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>所属役職</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="positionCodePop" name="positionCodePop" cssStyle="width:80pt" list ="positionCodeCombo" onchange='changeBox("2")'/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>役職開始年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="societyPosiStYYYYPop" name="societyPosiStYYYYPop" cssStyle="width:40pt" list ="societyPosiStYYYYCombo" onchange='changeBox("3")'/>年<s:select id="societyPosiStMMPop" name="societyPosiStMMPop" cssStyle="width:30pt" list ="societyPosiStMMCombo" onchange='changeBox("3")'/>月<s:select id="societyPosiStDDPop" name="societyPosiStDDPop" cssStyle="width:30pt" list ="societyPosiStDDCombo" onchange='changeBox("3")'/>日</nobr></td>
	      <td class="comFormTableItem"><nobr>役職終了年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="societyPosiEdYYYYPop" name="societyPosiEdYYYYPop" cssStyle="width:40pt" list ="societyPosiEdYYYYCombo"/>年<s:select id="societyPosiEdMMPop" name="societyPosiEdMMPop" cssStyle="width:30pt" list ="societyPosiEdMMCombo"/>月<s:select id="societyPosiEdDDPop" name="societyPosiEdDDPop" cssStyle="width:30pt" list ="societyPosiEdDDCombo"/>日</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>指導医取得年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="coachingAcquisiYYYYPop" name="coachingAcquisiYYYYPop" cssStyle="width:40pt" list ="coachingAcquisiYYYYCombo"/>年<s:select id="coachingAcquisiMMPop" name="coachingAcquisiMMPop" cssStyle="width:30pt" list ="coachingAcquisiMMCombo"/>月<s:select id="coachingAcquisiDDPop" name="coachingAcquisiDDPop" cssStyle="width:30pt" list ="coachingAcquisiDDCombo"/>日</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>所属学会指導医区分</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="advisingDoctorCdPop" name="advisingDoctorCdPop" cssStyle="width:80pt" list ="advisingDoctorCdCombo" onchange='changeBox("4")'/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>指導医開始年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="coachingStYYYYPop" name="coachingStYYYYPop" cssStyle="width:40pt" list ="coachingStYYYYCombo" onchange='changeBox("5")'/>年<s:select id="coachingStMMPop" name="coachingStMMPop" cssStyle="width:30pt" list ="coachingStMMCombo" onchange='changeBox("5")'/>月<s:select id="coachingStDDPop" name="coachingStDDPop" cssStyle="width:30pt" list ="coachingStDDCombo" onchange='changeBox("5")'/>日</nobr></td>
	      <td class="comFormTableItem"><nobr>指導医終了年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="coachingEdYYYYPop" name="coachingEdYYYYPop" cssStyle="width:40pt" list ="coachingEdYYYYCombo"/>年<s:select id="coachingEdMMPop" name="coachingEdMMPop" cssStyle="width:30pt" list ="coachingEdMMCombo"/>月<s:select id="coachingEdDDPop" name="coachingEdDDPop" cssStyle="width:30pt" list ="coachingEdDDCombo"/>日</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>所属学会認定医区分</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="certifyingPhysicianCdPop" name="certifyingPhysicianCdPop" cssStyle="width:80pt" list ="certifyingPhysicianCdCombo" onchange='changeBox("6")'/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>認定医開始年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="certifyStYYYYPop" name="certifyStYYYYPop" cssStyle="width:40pt" list ="certifyStYYYYCombo" onchange='changeBox("7")'/>年<s:select id="certifyStMMPop" name="certifyStMMPop" cssStyle="width:30pt" list ="certifyStMMCombo" onchange='changeBox("7")'/>月<s:select id="certifyStDDPop" name="certifyStDDPop" cssStyle="width:30pt" list ="certifyStDDCombo" onchange='changeBox("7")'/>日</nobr></td>
	      <td class="comFormTableItem"><nobr>認定医終了年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="certifyEdYYYYPop" name="certifyEdYYYYPop" cssStyle="width:40pt" list ="certifyEdYYYYCombo"/>年<s:select id="certifyEdMMPop" name="certifyEdMMPop" cssStyle="width:30pt" list ="certifyEdMMCombo"/>月<s:select id="certifyEdDDPop" name="certifyEdDDPop" cssStyle="width:30pt" list ="certifyEdDDCombo"/>日</nobr></td>
      </tr>
  </table>
		</td></tr>
		<!-- 前制御部 終了 -->
		<tr><td>
		<!-- 後制御部 開始 -->
		<table class="comPortalControlTable comPortalControlTablePopup" align="center" style="width:440pt;">
		<tbody>
			<tr>
				<td class="comPortalControlItem"><input type="button" name="bCancel" value="戻る" OnClick="chsClose();"></td>
				<td width="85%"></td>
				<td class="comPortalControlItem">
				<s:if test='%{hcpSocietyDataChgFlg == "0"}'>
				<!-- 新規 -->
					<input type="button" name="bRegister" value="適用" onClick="chsRegister('0');return false;" />
				</s:if>
				<s:else>
				<!-- 更新 -->
					<input type="button" name="bRegister" value="適用" onClick="chsRegister('1');return false;" />
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
