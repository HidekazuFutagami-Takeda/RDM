<%--
/**
 * <pre>
 *  施設来期情報更新 - 申請歴のJSP
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>NF102_施設来期情報更新 - 申請歴</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>

    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/catTkCityCombo.js"></script>
    <script type="text/javascript" src="js/imtInsInputCategores.js"></script>
    <script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
    <script type="text/javascript" src="js/jkrMenu.js"></script>
    <script>
	    function comSetFormWindowInfo(){
	    	comClickFlgInit();
	    }

		// ソートボタン
	    function sortBtn(sortCondition) {
			//ソート区分設定
	    	document.fm1.sortCondition.value = sortCondition;
	    	document.fm1.target="";
	        document.fm1.screenId.value	= "NF102";
	        document.fm1.functionId.value = "Init";

	      comSubmitForAnyWarp(fm1);
	    }
    </script>
<%
// ソート順状態制御用
String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
%>
</head>

  <%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>

<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設来期情報更新 - 申請歴"></td>
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

    <s:hidden id="pageFlag" name="pageFlag" />

    <input type="hidden" name="windowName" value="" />
    <input type="hidden" name="openerName" value="" />

	<s:hidden name="loginJokenSetCd"/>
	<s:hidden name="loginJgiNo"/>
    <s:hidden name="loginNm"/>
    <s:hidden name="loginShzNm"/>
    <s:hidden name="loginTrtCd"/>
    <s:hidden name="loginBrCd"/>
    <s:hidden name="loginDistCd"/>
    <s:hidden name="backScreenId" value="NF102" />
    <s:hidden id="preScreenId" name="preScreenId"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>
	<s:hidden id="sortCondition" name="sortCondition" />

	<s:hidden id="callBack" name="callBack" />
	<s:hidden id="title" name="title" />

	<s:hidden id="upSosCd" name="upSosCd"/>
	<s:hidden id="sosCdPop" name="sosCdPop"/>
	<s:hidden id="upSosCdPop" name="upSosCdPop"/>
	<s:hidden id="bumonRankPop" name="bumonRankPop"/>
	<s:hidden id="selectFlgPop" name="selectFlgPop"/>

	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="bumonRyakuName" name="bumonRyakuName"/>
    <s:hidden id="brCode" name="brCode"/>
	<s:hidden id="distCode" name="distCode"/>
	<s:hidden id="trtCd" name="trtCd"/>
	<s:hidden id="trtNm" name="trtNm"/>
	<s:hidden id="mrCat" name="mrCat"/>

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

<%
  // ソート表示状態制御
  String reqYmdhmsAscClass = "comTableNoSort";
  String reqYmdhmsDescClass = "comTableNoSort";
  if ("1".equals(sortCondition)) {
	  reqYmdhmsDescClass = "comTableSort";
  } else {
	  reqYmdhmsAscClass = "comTableSort";
  }
%>

  <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--施設情報--%>
		<td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr></nobr></td>
	      <td class="comFormTableItem"><nobr>施設固定C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insNo"/><s:hidden name="insNo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>ULT施設C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="ultInsNo"/><s:hidden name="ultInsNo"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>施設略式漢字名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insAbbrName"/><s:hidden name="insAbbrName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>ULT施設名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="shisetsuNmRyaku"/><s:hidden name="shisetsuNmRyaku"/></nobr></td>
      </tr>
  </table>

<div style="max-height:270px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
<table>
	<tr>
	    <td class="comFormTableItem" colSpan="3"><%-- スクロールバー用のテーブルクラスにすること --%>

	<%-- ヘッダー行 --%>
	<tr class="comTableTitle" style="position: sticky; top:0; left:0;">
		<td style="background-color:#FFFFFF;" colspan=2>&nbsp;</td>
		<td class="comTableTitle" colspan=8>施設情報</td>
		<td class="comTableTitle" colspan=10>病床数情報</td>
		<td class="comTableTitle" style="width:80px;" rowspan=2>申請コメント</td>
		<td class="comTableTitle" style="width:80px;" rowspan=2>申請ID</td>
		<td class="comTableTitle" style="width:80px;" rowspan=2>申請者</td>
		<td class="comTableTitle" style="width:80px;" rowspan=2>申請者所属</td>
	</tr>
	<tr class="comTableTitle" style="position: sticky; top:16; left:0;">
		<td class="comTableTitle" style="width:80px;">申請ステータス</td>
		<td class="comTableTitle" style="width:80px;">申請日時
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqYmdhmsAscClass %>" href="" onclick="sortBtn(0);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqYmdhmsDescClass %>" href="" onclick="sortBtn(1);return false;">▼</a>
		</td>
		<td class="comTableTitle" style="width:80px;">施設区分</td>
		<td class="comTableTitle" style="width:80px;">階級区分</td>
		<td class="comTableTitle" style="width:80px;">定訪先区分</td>
		<td class="comTableTitle" style="width:80px;">重点病院区分</td>
		<td class="comTableTitle" style="width:80px;">対象区分</td>
		<td class="comTableTitle" style="width:80px;">経営主体</td>
		<td class="comTableTitle" style="width:80px;">ワクチン対象区分</td>
		<td class="comTableTitle" style="width:90px;">ワクチン定訪先区分</td>
		<td class="comTableTitle" style="width:80px;">基準</td>
		<td class="comTableTitle" style="width:80px;">結核</td>
		<td class="comTableTitle" style="width:80px;">一般</td>
		<td class="comTableTitle" style="width:80px;">感染症</td>
		<td class="comTableTitle" style="width:80px;">精神</td>
		<td class="comTableTitle" style="width:80px;">療養</td>
		<td class="comTableTitle" style="width:80px;">医療療養</td>
		<td class="comTableTitle" style="width:80px;">介護医療</td>
		<td class="comTableTitle" style="width:80px;">ベッド数計</td>
		<td class="comTableTitle" style="width:80px;">医療ベッド数計</td>
	</tr>

    <%-- 内容 --%>

	<s:iterator value="hcoNxtReqDataList" status="status" var="rowBean">
		<tr style="min-height:30px;">
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].reqStsNm" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].reqYmdhms" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].pharmType" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].insRank" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].regVisType" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].impHosType" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].hoInsType" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].manageNm" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].vacInsType" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].vacVisitType" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedCntBase" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedCnt04" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedCnt01" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedCnt05" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedCnt03" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedCnt07" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedCnt02" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedCnt06" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].bedsTot" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].medBedsTot" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].reqComment" /></td>
	        <td class="comTableItem">
		        <a href ="#" onClick="return false;">
		        <s:label key="hcoNxtReqDataList[%{#status.index}].reqId" />
		        </a>
	        </td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].reqJgiName" /></td>
	        <td class="comTableItem"><s:label key="hcoNxtReqDataList[%{#status.index}].reqShzNm" /></td>
		</tr>
	</s:iterator>
    </table>
</div>

    </td>
    </tr>
            <tr>
        	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="window.close();" />
                </nobr>
	      </td>

<%-- メイン部 一覧 終了  --%>
<%-- 後制御部 --%>

	</table>

    </tbody>
    </table>
    </s:form>
    </table>
<%-- ポータルボディー 終了 --%>


<%-- メイン部 一覧 終了 --%>
<%-- ポータル大枠 終了 --%>
	<jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>