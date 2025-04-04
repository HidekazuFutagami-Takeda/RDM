<%--
/**
 * <pre>
 *  施設来期項目一括申請 - 申請内容確認のJSP
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
    <title>NF405_施設来期項目一括申請 - 申請内容確認</title>
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

 	// 申請ボタン
 	function reqBtn(){
		document.fm1.screenId.value="NF405";
		document.fm1.functionId.value="Register";

		comSubmitForAnyWarp(fm1);
 	}

	// 戻るボタン
 	function backBtn(){
		if(window.confirm("施設来期項目一括申請画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
			document.fm1.screenId.value="NF403";
			document.fm1.functionId.value="Search";

			comSubmitForAnyWarp(fm1);
		}
 	}

</script>
<style>
	.siz{
	width:2500px;
	}
	thead {
    position:Sticky;
    top:0;
    background-color: #fff;
    left: 2;
    }
</style>
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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設来期項目一括申請 - 申請内容確認"></td>
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
    <s:hidden name="backScreenId" value="NF405" />
    <s:hidden id="preScreenId" name="preScreenId"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="title" name="title" />

	<s:hidden id="sosCd" name="sosCd"/>
	<s:hidden id="sosNm" name="sosNm"/>
	<s:hidden id="upSosCd" name="upSosCd"/>
	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="bumonRyakuName" name="bumonRyakuName"/>
    <s:hidden id="brCode" name="brCode"/>
	<s:hidden id="distCode" name="distCode"/>
	<s:hidden id="trtCd" name="trtCd"/>
	<s:hidden id="trtNm" name="trtNm"/>
	<s:hidden id="mrCat" name="mrCat"/>

	<s:hidden id="jgiNo" name="jgiNo"/>
	<s:hidden id="jgiNm" name="jgiNm"/>

	<s:hidden id="insNo" name="insNo"/>
	<s:hidden id="insNm" name="insNm"/>
	<s:hidden id="ultInsNo" name="ultInsNo"/>
	<s:hidden id="insKanjSrch" name="insKanjSrch"/>
	<s:hidden id="shisetsuNmSrch" name="shisetsuNmSrch"/>
	<s:hidden id="insClass" name="insClass"/>
	<s:hidden id="insType" name="insType"/>
	<s:hidden id="hoInsType" name="hoInsType"/>
	<s:hidden id="ultDif" name="ultDif"/>

	<s:hidden id="btnEnableFlg" name="btnEnableFlg"/>

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>

    <div style="max-height:450px;width:1200px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
<table class="siz">
	<thead style="z-index:3;">
	<tr>
	    <td class="comFormTableItem" colSpan="3"><%-- スクロールバー用のテーブルクラスにすること --%>

	<%-- ヘッダー行 --%>
	<tr class="comTableTitle" style="position: sticky; top:0; left:0;">
		<td class="comTableTitle" style="width:110px;">施設固定C</td>
		<td class="comTableTitle" style="width:50px" rowspan=2>期</td>
		<td class="comTableTitle" style="width:130px" colspan=8>施設情報</td>
		<td class="comTableTitle" colspan=10>病床数情報</td>
		<td class="comTableTitle" style="width:70px" rowspan=2>申請コメント</td>
	</tr>
	<tr class="comTableTitle" style="position: sticky; top:20; left:0;">
		<td class="comTableTitle">施設略式漢字名</td>
		<td class="comTableTitle">施設区分</td>
		<td class="comTableTitle">階級区分</td>
		<td class="comTableTitle">定訪先区分</td>
		<td class="comTableTitle">重点病院区分</td>
		<td class="comTableTitle">対象区分</td>
		<td class="comTableTitle">経営主体</td>
		<td class="comTableTitle">ワクチン対象区分</td>
		<td class="comTableTitle">ワクチン定訪先区分</td>
		<td class="comTableTitle" style="width:40px">基準</td>
		<td class="comTableTitle" style="width:40px">結核</td>
		<td class="comTableTitle" style="width:40px">一般</td>
		<td class="comTableTitle" style="width:40px">感染症</td>
		<td class="comTableTitle" style="width:40px">精神</td>
		<td class="comTableTitle" style="width:40px">療養</td>
		<td class="comTableTitle" style="width:60px">医療療養</td>
		<td class="comTableTitle" style="width:60px">介護医療</td>
		<td class="comTableTitle" style="width:60px">ベッド数計</td>
		<td class="comTableTitle" style="width:70px">医療ベッド数計</td>
	</tr>
	</thead>

    <%-- 内容 --%>

	<s:iterator value="hcoBlkReqDataList" status="status" var="rowBean">
		<tr style="min-height:30px;">
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insNo"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].pharmType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insRank"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].regVisType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].impHosType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].hoInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].manageCd"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacVisitType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].pharmTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insRankNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].regVisTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].impHosTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].hoInsTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].manageNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacInsTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacVisitTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCntBase"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt04"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt01"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt05"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt03"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt07"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt02"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt06"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].medBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultDif"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].reqComment"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insAbbrName"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].shisetsuKbn"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].keieitai"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCntBase"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt04"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt01"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt05"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt03"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt07"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultMedBedsTot"/>

			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpPharmType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpInsRank"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpRegVisType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpImpHosType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpManageCd"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextHoInsTypeValue"/>

			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextPharmType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextInsRank"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextRegVisType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextImpHosType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextHoInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextManageCd"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextVacInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextVacVisitType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextPharmTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextInsRankNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextRegVisTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextImpHosTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextHoInsTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextManageNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextVacInsTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextVacVisitTypeNm"/>

			<s:hidden name="hcoBlkReqDataList[%{#status.index}].pharmTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insRankFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].regVisTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].impHosTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].hoInsTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].manageCdFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacInsTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacVisitTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCntBaseFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt04Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt01Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt05Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt03Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt07Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt02Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt06Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedsTotFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].medBedsTotFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].updShaYmd"/>

			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCntBase"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt04"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt01"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt05"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt03"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt07"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt02"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt06"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextMedBedsTot"/>

	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insNo" /></td>
	        <td class="comTableItem">当期</td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].pharmTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insRankNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].regVisTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].impHosTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].hoInsTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].manageNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].vacInsTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].vacVisitTypeNm" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCntBase" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt04" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt01" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt05" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt03" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt07" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt02" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt06" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedsTot" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].medBedsTot" /></td>
	        <td class="comTableItem" rowspan=3>
	        	<s:label key="hcoBlkReqDataList[%{#status.index}].reqComment" />
	        </td>
		</tr>
		<tr>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insAbbrName" /></td>
	        <td class="comTableItem">ULT</td>
	        <td class="comTableItemNF401"><s:label key="hcoBlkReqDataList[%{#status.index}].shisetsuKbn" /></td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401"><s:label key="hcoBlkReqDataList[%{#status.index}].keieitai" /></td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>

	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCntBase" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt04" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt01" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt05" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt03" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt07" /></td>
	        <td class="comTableItemNF401" style="text-align:right">&nbsp;</td>
	        <td class="comTableItemNF401" style="text-align:right">&nbsp;</td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedsTot" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultMedBedsTot" /></td>
		</tr>
		<tr style="min-height:30px;">
	        <td class="comTableItem">&nbsp;</td>
	        <td class="comTableItem">来期</td>
	        <td class="comTableItem">
	        	<s:if test="#rowBean.pharmType == #rowBean.nextPharmType">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextPharmTypeNm"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextPharmTypeNm"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem">
				<s:if test="#rowBean.insRank == #rowBean.nextInsRank">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextInsRankNm"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextInsRankNm"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem">
				<s:if test="#rowBean.regVisType == #rowBean.nextRegVisType">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextRegVisTypeNm"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextRegVisTypeNm"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem">
		        <s:if test="#rowBean.impHosType == #rowBean.nextImpHosType">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextImpHosTypeNm"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextImpHosTypeNm"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem">
		        <s:if test="#rowBean.hoInsType == #rowBean.nextHoInsType">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextHoInsTypeNm"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextHoInsTypeNm"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem">
		        <s:if test="#rowBean.manageCd == #rowBean.nextManageCd">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextManageNm"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextManageNm"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem">
	        	<s:if test="#rowBean.vacInsType == #rowBean.nextVacInsType">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextVacInsTypeNm"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextVacInsTypeNm"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem">
		       	<s:if test="#rowBean.vacVisitType == #rowBean.nextVacVisitType">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextVacVisitTypeNm"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextVacVisitTypeNm"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedCntBase == #rowBean.nextBedCntBase">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCntBase"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCntBase"/></font>
	        	</s:else>
        	</td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedCnt04 == #rowBean.nextBedCnt04">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt04"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt04"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedCnt01 == #rowBean.nextBedCnt01">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt01"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt01"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedCnt05 == #rowBean.nextBedCnt05">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt05"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt05"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedCnt03 == #rowBean.nextBedCnt03">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt03"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt03"/></font>
	        	</s:else>
	       	</td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedCnt07 == #rowBean.nextBedCnt07">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt07"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt07"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedCnt02 == #rowBean.nextBedCnt02">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt02"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt02"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedCnt06 == #rowBean.nextBedCnt06">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt06"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt06"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedsTot == #rowBean.nextBedsTot">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextBedsTot"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedsTot"/></font>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.medBedsTot == #rowBean.nextMedBedsTot">
	        		<s:label key="hcoBlkReqDataList[%{#status.index}].nextMedBedsTot"/>
	        	</s:if>
	        	<s:else>
	        		<font color="red"><s:label key="hcoBlkReqDataList[%{#status.index}].nextMedBedsTot"/></font>
	        	</s:else>
	        </td>
		</tr>
	</s:iterator>
    </table>
</div>
    </td>
    </tr>
            <tr>
	      <td class="comFormTableItem">
	      <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:98%;">
	      <tr>
	        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 16%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 17%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 17%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
	      </tr>
			<tr>
	      		<td>
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="backBtn();" />
                </nobr>
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>
               <nobr>
               	<s:if test='%{btnEnableFlg == "1"}'>
					<input class="comButton" type="button"name="buttonF3" value="申請" onClick="reqBtn();JavaScript:return false;" />
				</s:if>
				<s:else>
					<input class="comButton" type="button"name="buttonF3" value="申請" onClick="" disabled />
               	</s:else>
               </nobr>
               </td>
           </tr>
         </table>
	      </td>
	  </tr>
  </table>
     	</td>
    </tr>


<%-- メイン部 一覧 終了    key="catDeptsComboDataList[%{#status.index}].addrNameArea" --%>
<!--  <hr class="comSplit" /> -->
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