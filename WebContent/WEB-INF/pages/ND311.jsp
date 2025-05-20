<%--
/**
 * <pre>
 *  医師勤務先追加 - 申請内容確認のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author SBS  千葉
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND311DTO"%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppConstant,java.util.ArrayList,java.math.BigDecimal"
  import="jp.co.takeda.rdm.util.RdmConstantsData"
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
	<title>ND311_医師勤務先追加 - 申請内容確認</title>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<link href="WebContent/css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/popup.css" rel="Stylesheet" type="text/css" />
	<link href="css/catDeptsCombo.css" rel="Stylesheet" type="text/css" />
	<link href="css/common.css" rel="Stylesheet" type="text/css" />
	<link href="css/jkrMenu.css" rel="Stylesheet" type="text/css" />
	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jkrMenu.js"></script>
	<script type="text/javascript" src="js/ND103.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/catSosJgiExpand.js"></script>
	<script type="text/javascript" src="js/jgiKanren.js"></script>
</head>
<body class="comPage">

<%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>

<%-- submit用フォーム 開始 　まるっといらないかもって話がある--%>
	<form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
		<%--
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

			チェック済みを記憶するために<div>タグの空間にhidden属性の
			inputをJavaScriptで動的に配置する。

		<input type="hidden" name="cdcCheckedCodes1" value="dummy">
		<input type="hidden" name="cdcCheckedCodes1" value="dummy">
		<input type="text" name="dummy"             value="dummy" />
		--%>
	</form>
<%-- submit用フォーム 終了 --%>

<table border="0" class="comPortalTable" align="center" style="width:98%;">
  <tr>
    <td>
<%-- input用フォーム 開始 --%>
  <s:form name="fm1" theme="simple">
	<%-- 常に配列にするためにダミーを配置 --%>
    <s:hidden name="callBack" />
    <s:hidden name="msgStr" />
    <s:hidden name="dialog" />
    <s:hidden name="buttonFlg" />
    <s:hidden name="insNoKakusi" />
	<s:hidden name="errorCheckFlg" />
	<s:hidden name="errorBool" />
	<s:hidden name="jokenSetCd" />

	<s:hidden name="title" />
	<s:hidden name="reqShz" />
	<s:hidden name="reqChl" />
	<s:hidden name="paramReqId" />
	<s:hidden name="reqId" />
	<s:hidden name="reqSts" />
	<s:hidden name="jgiName" />
	<s:hidden name="reqYmdhms" />
	<s:hidden name="reqJgiNo" />
	<s:hidden name="brCode" />
	<s:hidden name="reqDistCode" />
	<s:hidden name="reqStsCd" />
	<s:hidden name="updShaYmd" />
	<s:hidden name="docKanj" />
	<s:hidden name="paramDocNo" />
	<s:hidden name="docNo" />
	<s:hidden name="urlDocNo" />
	<s:hidden name="processFlg" />
	<s:hidden name="backScreenId" value="ND311" />
	<s:hidden name="preScreenId" />

	<s:hidden name="tekiyoYmd" />
	<s:hidden name="insNoSk" />
	<s:hidden name="ultInsNo" />
	<s:hidden name="deptKn" />
	<s:hidden name="saveButtonFlg" />
	<s:hidden name="shnFlg"/>
	<s:hidden name="shnCompButtonFlg" />
	<s:hidden name="editApprFlg" />
	<s:hidden name="paramInsNo" />
	<s:hidden name="insAbbrName" />
	<s:hidden name="deptCodeAf" />
	<s:hidden name="deptKj" />
	<s:hidden name="titleCodeAf" />
	<s:hidden name="titleCodeName" />
	<s:hidden name="univPosCodeAf" />
	<s:hidden name="univPosCodeAfName" />
	<s:hidden name="jobFormAf" />
	<s:hidden name="jobFormAfName" />
	<s:hidden name="dccTypeAf" />
	<s:hidden name="dccTypeAfName" />
	<s:hidden name="formTekiyoYmd" />

	<s:hidden name="loginJokenSetCd" />
	<s:hidden name="loginJgiNo"/>
     <s:hidden name="loginNm"/>
     <s:hidden name="loginShzNm"/>
     <s:hidden name="loginTrtCd"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>

    <s:hidden name="pageCntAll" />
      <s:hidden name="pageCntCur" />
      <s:hidden name="pageCntBase" />
      <s:hidden name="lineCntStart" />
      <s:hidden name="lineCntEnd" />
      <s:hidden name="lineCntAll" />
      <s:hidden name="endTermFlg" />
      <s:hidden name="insDispRngFlg" />
      <s:hidden name="docChgLinkFlg" />
      <s:hidden name="insSkninDispFlg" />
      <s:hidden name="insSkninUpFlg" />
      <s:hidden name="dispRng" />
      <s:hidden name="newTekiyoYmd" />
      <s:hidden name="newSosCd" />
      <s:hidden name="regEnabedFlg" />
      <s:hidden name="sortCondition1" />
      <s:hidden name="sortCondition2" />
      <s:hidden name="screenId" value="NF501" />
      <s:hidden name="functionId"/>
      <s:hidden name="buttonFlg" />
      <s:hidden name="gamenId"/>
      <s:hidden id="pageFlag" name="pageFlag" />
      <s:hidden name="listName" />
      <s:hidden name="poprowno" />
      <s:hidden name="poptrtno" />

      <%-- トップメニューから --%>
      <s:hidden name="trtGrpCd" />
      <s:hidden name="selectedJgiJoken" />
      <s:hidden name="jokenSetCd" />
      <s:hidden name="sosCdHairetu" />
      <s:hidden name="sosCd" />
      <s:hidden name="selectedSosCd" />
      <s:hidden name="selectedSosNm" />
      <s:hidden id="selectedSosCd2" name="selectedSosCd2" />
      <s:hidden name="selectedSosNm2" />
      <s:hidden id="selectedSosCd3" name="selectedSosCd3" />
      <s:hidden name="selectedSosNm3" />
      <s:hidden name="selectedSosCd4" />
      <s:hidden name="selectedInsDispRngFlg" />
      <s:hidden name="sosSelFlg" />
      <s:hidden name="jgiNo" />
      <s:hidden name="wkCat" />
      <s:hidden name="caseKbn" />
      <s:hidden name="hoInsType" />
      <s:hidden name="searchInsChg" />
      <s:hidden name="msgId" />
    <div id="cdcCheckedCodesDiv" style="display:none">
    <s:iterator value="cdcCheckedCodes" var="code">
        <s:if test="%{#code == 'dummy'}">
        </s:if>
        <s:else>
            <s:hidden name="cdcCheckedCodes" value="%{code}" />
        </s:else>
    </s:iterator>
    </div>
    <s:url id="searchurl" action="NF501Search"/>
    <s:submit name="submit_search" value="検索イベント" onclick="this.form.action='%{searchurl}'; this.form.submit();return false;" cssStyle="display:none" />
    <s:url id="pageurl" action="NF501Page"/>
    <s:submit name="page_search" value="改ページイベント" onclick="this.form.action='%{pageurl}'; this.form.submit();return false;" cssStyle="display:none" />

<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="医師勤務先追加"></td>
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

   	<table width="100%">
   		<tr>
             <td align="center">
               <jsp:include page="common/rdmMsg.jsp">
               <jsp:param name="" value="" />
               </jsp:include>
             </td>
         </tr>
      </table>

  <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--申請情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>申請情報</nobr></td>
	      <td class="comFormTableItem"><nobr>申請ID</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:if test="%{paramReqId == null}">
          		-
          	</s:if>
          	<s:else>
          		<s:property value="paramReqId" />
         	</s:else>
			</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>申請者所属</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="reqShz" /></nobr></td>
	      <td class="comFormTableItem"><nobr>申請ステータス</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="reqSts"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>申請者氏名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="jgiName" /></nobr></td>
	      <td class="comFormTableItem"><nobr>申請日時</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="reqYmdhms"/></nobr></td>
	  </tr>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable02" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医師・コメディカル名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="docKanj"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>施設名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="insAbbrName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>所属部科</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="deptKj"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>役職</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="titleCodeName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>大学職位</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:if test='%{univPosCodeAfName != null || univPosCodeAfName !="" }'>
           	 	<s:property value="univPosCodeAfName"/>
           	</s:if>
           	<s:else>
				-
           	</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>勤務形態</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="jobFormAfName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>薬審メンバー区分</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:if test='%{dccTypeAfName != null || dccTypeAfName !="" }'>
           	 	<s:property value="dccTypeAfName"/>
           	</s:if>
           	<s:else>
				-
           	</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>適用日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:property value="formTekiyoYmd"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  </table>
  <%--コメント類 --%>
  <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--コメント--%>
        <td style="width: 650px; height: 0px; border-width: 0px;"></td>
      </tr>
        <tr>
	      <td class="comFormTableItem"><nobr>申請コメント</nobr></td>
      </tr>
        <tr>
	    	<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" readonly="true" /></nobr></td>
      </tr>
	<s:if test='%{(reqStsCd == "03" || reqStsCd == "13")}'>
	      <tr>
		      <td class="comFormTableItem"><nobr>承認・却下コメント（※申請者への伝達事項）</nobr></td>
	      </tr>
	      <tr>
		      <td class="comFormTableItem"><nobr>
		      <s:textarea name="aprComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/>
		      </nobr></td>
	      </tr>
      </s:if>
  </table>

  <%--ボタン類 --%>
  <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:98%;">
      <tr>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 38%; height: 0px; border-width: 0px;"></td>
      </tr>
		<tr>
	      <td class="comFormTableItem">
               <nobr>
                <input type="button" value="戻る" onclick="backPage()" />
               </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>
                <s:if test='%{reqStsCd == 03 }'>
					<s:if test='%{actionEdit == "1"}'>
	                	<input type="button" value="却下" onclick="ND311Cancel()" />
	                </s:if>
	                <s:if test='%{actionEdit == "0"}'>
	                	<input type="button" value="却下" onclick="ND311Cancel()" disabled/>
	                </s:if>
				</s:if>
				<s:if test='%{reqStsCd == 13 }'>
	                <s:if test='%{actionEdit == "1"}'>
	                	<input type="button" value="却下" onclick="ND311Cancel()" />
	                </s:if>
	                <s:if test='%{actionEdit == "0"}'>
	                	<input type="button" value="却下" onclick="ND311Cancel()" disabled/>
	                </s:if>
				</s:if>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
	      <nobr>&nbsp;</nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
					&nbsp;
                </nobr>
	      </td>
	      <td class="comFormTableItem">
               <nobr>
			   <s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11"}'>
					<s:if test='%{actionEdit == "1"}'>
	                	<input type="button" value="申請" onclick="ND311Page()" />
	                </s:if>
	                <s:if test='%{actionEdit == "0"}'>
	                	<input type="button" value="申請" onclick="ND311Page" disabled/>
	                </s:if>
				</s:if>
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>
                <s:if test='%{reqStsCd == 03 }'>
					<s:if test='%{actionEdit == "1"}'>
						<s:checkbox name="fbReqFlg" tabIndex="-1" /><label for="fbReqFlg">アルトマークへの情報連携</label>
	                	<input type="button" value="承認" onclick="ND311Approval()" />
	                </s:if>
	                <s:if test='%{actionEdit == "0"}'>
	                <s:checkbox name="fbReqFlg"  tabIndex="-1" disabled="true" /><label for="fbReqFlg">アルトマークへの情報連携</label>
	                	<input type="button" value="承認" onclick="" disabled/>
	                </s:if>
				</s:if>
				<s:else>
				<s:hidden name="fbReqFlg"/>
				</s:else>
				<s:if test='%{reqStsCd == 13 }'>
	                <s:if test='%{actionEdit == "1"}'>
	                	<input type="button" value="承認" onclick="ND311Approval()" />
	                </s:if>
	                <s:if test='%{actionEdit == "0"}'>
	                	<input type="button" value="承認" onclick="" disabled/>
	                </s:if>
				</s:if>
                </nobr>
	      </td>
	  </tr>
  </table>
<%-- SUBMIT用パラメータ 終了 --%>

    </td>
	</tr>
    </tbody>
    </table>


	<script>
	//戻るボタン
	function backPage() {

		destructMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';
		//if(window.confirm(destructMsg.replace("（遷移元）", '医師勤務先追加'))){

				document.fm1.screenId.value="ND103";
				document.fm1.functionId.value="Init";

				comSubmitForAnyWarp(fm1);

		//}

	}
	// 却下ボタン
	function ND311Cancel(){

		document.fm1.screenId.value="ND311";
		document.fm1.functionId.value="Register";
		document.fm1.processFlg.value="1";

		comSubmitForAnyWarp(fm1);

	}

	// 申請ボタン
	function ND311Page(){

			document.fm1.screenId.value="ND311";
			document.fm1.functionId.value="Register";
			document.fm1.processFlg.value="0";

			comSubmitForAnyWarp(fm1);

	}

	// 承認ボタン
	function ND311Approval(){

		document.fm1.screenId.value="ND311";
		document.fm1.functionId.value="Register";
		document.fm1.processFlg.value="2";

		comSubmitForAnyWarp(fm1);

	}
	</script>
	<%--フッター部　終了 --%>


	<%-- ポータルボディー 終了 --%>
  </s:form>
  </table>
<%-- input用フォーム 終了 --%>
<jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
