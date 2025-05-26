<%--
/**
 * <pre>
 *  施設変更履歴のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author SBS  千葉
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.NF501DTO"%>
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
	<title>NF501_施設変更履歴</title>

	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
	<script>
    function comSetFormWindowInfo(){
    	comClickFlgInit();
    }
    </script>
	<script type="text/javascript" src="js/NF501.js"></script>
	<script type="text/javascript" src="js/catTkCityCombo.js"></script>
    <script type="text/javascript" src="js/imtInsInputCategores.js"></script>
    <script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/rdmCatSosExpand.js"></script>
    <script type="text/javascript" src="js/jkrMenu.js"></script>
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>

    <!-- css -->
    <style>
    	a {
    		color: inherit;
    	}

		a:hover{
			opacity:0.5;
			transition:0.3s;
			cursor: pointer;
		}
    	TABLE {
		    FONT-SIZE: 8pt;
		}
		/*テーブル幅可変*/
		.comTableTitle .comTableTitle{
			resize : horizontal;
			overflow : hidden;
			}

		/*検索結果テーブルを囲むdiv名*/
		.kensakuDate {
			height: 370px;
			width: 1200px;
			overflow: auto;
			-webkit-overflow-scrolling: touch;
		}

		/*検索結果テーブル*/
		.kensakuDate table {
			border-collapse: collapse;
		  border-spacing: 0;
		  width: 100%;
		}

		/*検索結果テーブル_固定する列*/
		#left1 {
			position:sticky;
			left: 0;
			z-index:3;
		}
		#left2 {
			position:sticky;left: 50pt;z-index:3;
		}
		#left3 {
			position:sticky;left: 116pt;z-index:3;
		}
		#left4 {
			position:sticky;left: 168pt;z-index:3;
		}
		#left5 {
			position:sticky;left: 203pt;z-index:3;
		}
/*		#left6 {
			position:sticky;left: 245pt;z-index:3;
		}
		#left7 {
			position:sticky;left: 305pt;z-index:3;
		}
		#left8 {
			position:sticky;left: 342pt;z-index:3;
		}
		#left9 {
			position:sticky;left: 410pt;z-index:3;
		}
		#left10 {
			position:sticky;left: 451pt;z-index:3;
		}
		#left11{
			position:sticky;left: 491pt;z-index:3;
		}
		#left12 {
			position:sticky;left: 583pt;z-index:3;
		}
		#left13 {
			position:sticky;left: 675pt;z-index:3;
		}
		#left14 {
			position:sticky;left: 720pt;z-index:3;
		}*/


		/*検索結果テーブルタイトル項目*/
    	TD.comTableTitle {
			border-color: #f5f5f5;
		   color: #000000;
		   /* background-color: #e0e0d4; */
		   /* background-color: #cccccc; */
		   background-color: #e8b5a2;
		   text-align: center;
		   border-style: solid;
		   border-top-width: 0px;
		   border-left-width: 1px;
		   border-right-width: 1px;
		   border-bottom-width: 1px;
		   font-size: 8pt;
		   top: 0;
		   left: 0;
		   position: sticky;
			}



			/* 検索結果テーブルデータ項目 */
			TD.comTableItem {
				color: #000000;
			    text-align: left;
			    border-style: solid;
			    border-top-width: 0px;
			    border-left-width: 1px;
			    border-right-width: 1px;
			    border-bottom-width: 1px;
			    font-size: 8pt;
			    border-color: #f5f5f5;
			    width:146pt;
			}

			/*全画面モード*/
			#showAll {
				display: none;
			}

			.comTableSearchItem {

			}

			#jkrCityNameCd option {
			display: none;
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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設変更履歴"></td>
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
  <s:form name="fm1" theme="simple">
	<%-- 常に配列にするためにダミーを配置 --%>
    <s:hidden name="callBack" />
	<s:hidden name="sortId" />
	<s:hidden name="jokenSetCd" />
	<s:hidden name="kensakuReqBrCode" />
	<s:hidden name="kensakuDistCode" />
	<s:hidden name="kensakuBrCode" />
	<s:hidden name="kensakuTrtCd" />
    <s:hidden name="kensakuJgiNo" />
    <s:hidden name="kensakuReqDistCode" />
    <s:hidden name="searchType" />
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
      <s:hidden name="title" />
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
      <s:hidden name="backScreenId" value="NF501" />

      <s:hidden name="mrJgiNo" />
      <s:hidden name="mrBrCode" />
      <s:hidden name="mrDistCode" />
      <s:hidden name="mrTrtCd" />

      <s:hidden name="bumonRankPop" />
      <s:hidden name="selectFlgPop" />
      <s:hidden name="sosCdPop" />
      <s:hidden name="bumonRankPop" />
      <s:hidden name="upSosCdPop" />

      <s:hidden name="tantoBumonRank" />
      <s:hidden name="tantoSosCd" />
      <s:hidden name="tantoUpSosCd" />
      <s:hidden name="kensakuTantouDistCode" />
      <s:hidden name="kensakuSTantouBrCode" />

		<s:hidden name="kensakuShinseiBumonRank" />
	  <s:hidden name="kensakuShinseiSosCd" />
      <s:hidden name="kensakuShinseiDistCode" />
      <s:hidden name="kensakuShinseiBrCode" />

      <s:hidden name="clearUpdMstFrom" />
      <s:hidden name="clearUpdMstTo" />

      <%-- トップメニューから --%>
      <s:hidden name="trtGrpCd" />
      <s:hidden name="selectedJgiJoken" />
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

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

	<tr>
		<%-- 担当者組織 --%>
		<td class="pupControlItem"><nobr>担当者組織
<%-- 		   	<s:if test="%{jokenSetCd == 0}"> --%>
<!-- 		   		<input id="sosButton1" class="comButton" type="button" value="選択" disabled /> -->
<%-- 		   	</s:if> --%>
<%-- 		   	<s:else> --%>
		   		<input id="sosButton1" class="comButton" type="button" value="選択" onClick="soshikiPopBtn(1);" />
<%-- 		   	</s:else> --%>
		   </nobr>
		</td>
		<td>
<%-- 			<s:if test="%{jokenSetCd == 0}"> --%>
<%-- 				<s:textfield id="tantoSosName" name="tantoSosName" size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true" /> --%>
<!-- 		          	&nbsp;<a href="#" class="comMiniLink" onClick="return false;">Clear</a> -->
<%-- 			</s:if> --%>
<%-- 			<s:else> --%>
				<s:textfield id="tantoSosName" name="tantoSosName" size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true" />
	          		&nbsp;<a href="#" class="comMiniLink" onClick="tantoSosClear();return false;">Clear</a>
<%-- 			</s:else> --%>
		</td>
		<%-- 担当者 --%>
		<td class="pupControlItem"><nobr>担当者
<%-- 		   <s:if test="%{jokenSetCd == 0}"> --%>
<!-- 				<input id="sosButton1" class="comButton" type="button" value="選択" disabled /> -->
<%-- 		   </s:if> --%>
<%-- 		   <s:else> --%>
		   		<input id="sosButton1" class="comButton" type="button" value="選択" onClick="tantoPopBtn();" />
<%-- 		   </s:else> --%>
		   </nobr>
		</td>
		<td>
<%-- 			<s:if test="%{jokenSetCd == 0}"> --%>
<%-- 				<s:textfield id="jgiName" name="jgiName"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  /> --%>
<!-- 	          		&nbsp;<a href="#" class="comMiniLink" onClick="return false;">Clear</a> -->
<%-- 		   </s:if> --%>
<%-- 		   <s:else> --%>
		   		<s:textfield id="jgiName" name="jgiName"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  />
	          		&nbsp;<a href="#" class="comMiniLink" onClick="tantoClear();return false;">Clear</a>
<%-- 		   </s:else> --%>
		</td>
		<%-- 申請者組織 --%>
		<td class="pupControlItem"><nobr>申請者組織
<%-- 		   <s:if test="%{jokenSetCd == 0}"> --%>
<!-- 				<input id="sosButton1" class="comButton" type="button" value="選択" disabled /> -->
<%-- 		   </s:if> --%>
<%-- 		   <s:else> --%>
		   		<input id="sosButton1" class="comButton" type="button" value="選択" onClick="soshikiPopBtn(2);" />
<%-- 		   </s:else> --%>
		   </nobr>
		</td>
		<td>
<%-- 			<s:if test="%{jokenSetCd == 0}"> --%>
<%-- 				<s:textfield id="reqSosName" name="reqSosName" size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true" /> --%>
<!-- 	          		&nbsp;<a href="#" class="comMiniLink" onClick="return false;">Clear</a> -->
<%-- 		   </s:if> --%>
<%-- 		   <s:else> --%>
		   		<s:textfield id="reqSosName" name="reqSosName" size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true" />
		          		&nbsp;<a href="#" class="comMiniLink" onClick="reqSosClear();return false;">Clear</a>
<%-- 		   </s:else> --%>
		</td>
	</tr>
	<tr>
		<%-- 施設名(全角) --%>
		<td class="pupControlItem"><nobr>施設名(全角)</nobr>
		</td>
		<td>
			<s:textfield name="kensakuInsKanj" id="kensakuInsKanj" size="20" maxlength="128" />
		</td>
		<%-- 施設カナ(半角カナ) --%>
		<td class="pupControlItem"><nobr>施設カナ(半角カナ)</nobr>
		</td>
		<td>
			<s:textfield id="kensakuInsKana" name="kensakuInsKana" size="20" maxlength="128" />
		</td>
		<%-- 申請者 --%>
		<td class="pupControlItem"><nobr>申請者</nobr>
		</td>
		<td>
<%-- 			<s:if test="%{jokenSetCd == 0}"> --%>
<%-- 				<s:textfield id="kensakuReqJgiNameUser" name="kensakuReqJgiName" size="20" maxlength="128"  /> --%>
<%-- 		   </s:if> --%>
<%-- 		   <s:else> --%>
		   	<s:textfield id="kensakuReqJgiName" name="kensakuReqJgiName" size="20" maxlength="128" />
<%-- 		   </s:else> --%>
		</td>
	</tr>
	<tr>
		<%-- 施設固定C --%>
		<td class="pupControlItem"><nobr>施設固定C</nobr>
		</td>
		<td>
			<s:textfield id="kensakuInsNo" name="kensakuInsNo" size="20" maxlength="128" />
		</td>
		<%-- ULTコード --%>
		<td class="pupControlItem"><nobr>ULTコード</nobr>
		</td>
		<td>
			<s:textfield id="kensakuUltInsNo"  name="kensakuUltInsNo" size="20" maxlength="128" />
		</td>
		<%-- 経営主体 --%>
		<td class="pupControlItem"><nobr>経営主体</nobr>
		</td>
		<td>
			<s:select id="kensakuManageCd" name="kensakuManageCd" cssStyle="width:80pt" list ="hcoKeieitaiMap" />
		</td>
	</tr>
	<tr>
		<%-- 対象区分 --%>
		<td class="pupControlItem"><nobr>対象区分</nobr>
		</td>
		<td>
			<s:select id="kensakuHoInsType" name="kensakuHoInsType" cssStyle="width:80pt" list ="hoInsTypeMap" />
		</td>
		<%-- 施設種別 --%>
		<td class="pupControlItem"><nobr>施設種別</nobr>
		</td>
		<td>
			<s:select id="kensakuInsSbt" name="kensakuInsSbt" cssStyle="width:80pt" list ="insSbtMap" />
		</td>
		<%-- 施設区分 --%>
		<td class="pupControlItem"><nobr>施設区分</nobr>
		</td>
		<td>
			<s:select id="kensakuPharmType" name="kensakuPharmType" cssStyle="width:80pt" list ="pharmTypeMap" />
		</td>
	</tr>
	<tr>
		<%-- 電話番号(半角) --%>
		<td class="pupControlItem"><nobr>電話番号(半角)</nobr>
		</td>
		<td>
			<s:textfield id="kensakuInsPhone" name="kensakuInsPhone" size="20" maxlength="128"  />
		</td>
		<%-- 郵便番号(半角) --%>
		<td class="pupControlItem"><nobr>郵便番号(半角)</nobr>
		</td>
		<td>
			<s:textfield id="kensakuInsPcode" name="kensakuInsPcode" size="20" maxlength="128" />
		</td>
		<td class="pupControlItem">&nbsp;</td>
		<td class="pupControlItem">&nbsp;</td>
	</tr>
	<tr>
		<%-- 都道府県 --%>
		<td class="pupControlItem"><nobr>都道府県</nobr>
		</td>
		<td>
			<span onchange="sosAddrChange(); return false;">
				<s:select class="jkrSosAddrCd" id="jkrSosAddrCd" name="kensakuAddrCodePref" cssStyle="width:80pt" list ="jkrSosAddrMap" />
			</span>
		</td>
		<%-- JIS市区町村 --%>
		<td class="pupControlItem"><nobr>JIS市区町村</nobr>
		</td>
		<td>
			<s:select class="jkrCityNameCd" id="jkrCityNameCd" name="kensakuAddrCodeCity" cssStyle="width:80pt" list ="jkrCityNameMap" />
		</td>
		<td class="pupControlItem">&nbsp;</td>
		<td class="pupControlItem">&nbsp;</td>
	</tr>
	<tr>
		<%-- 住所(全角) --%>
	    <td class="pupControlItem"><nobr>住所(全角)</nobr></td>
        <td class="comTableSearchItem" colspan=3>
			<s:textfield id="kensakuInsAddr" name="kensakuInsAddr" size="20" maxlength="128" style="width:500px;"/>
	    </td>
	    <td class="pupControlItem">&nbsp;</td>
	    <td class="pupControlItem">&nbsp;</td>
	</tr>
	<tr>
		<%-- 更新日 --%>
	    <td class="pupControlItem"><nobr>更新日</nobr></td>
        <td class="comTableSearchItem" colspan=3>
			<input type="date" name="kensakuUpdMstFrom" id="updMstFrom" value="${updMstFrom}" pattern="yyyy-MM-dd" />
	          	<span>　～　</span>
          	<input type="date" name="kensakuUpdMstTo" id="updMstTo" value="${updMstTo}" pattern="yyyy-MM-dd" />
	    </td>
	    <td class="pupControlItem">&nbsp;</td>
	    <td class="pupControlItem">&nbsp;</td>
	</tr>
	<tr>
		<td align="center" colspan=6>
			<!-- 検索ボタン -->
			<input type="button" name="search" value="検索" onclick="jimSearch();">
			&nbsp;
			<%-- 表示リセット --%>
			<input type="button" value="クリア" class="comMiniLink" onclick="clearText()">
			&nbsp;
			<!-- リスト切り替え -->
			リスト切替
			&nbsp;
			<s:select id="selectListChange" name="selectListChange" list ="selectListChangeMap" />
		</td>
	</tr>

<%-- ページャー表示 開始 --%>
          <s:if test='pageFlag == "1" '>
          </s:if>
		<s:else>
          	<table width="80%">
          		<tr>
                    <td align="right">
                      <jsp:include page="common/rdmPage.jsp">
                      <jsp:param name="" value="" />
                      </jsp:include>
                    </td>
                </tr>
             </table>
          </s:else>
          <%-- ページャー表示 終了 --%>

<%
	// ソート表示状態制御
	int sortCondition = (int)request.getAttribute("sortId");
	String updShaYmdAscClass = "comTableNoSort";
	String updShaYmdDescClass = "comTableNoSort";
	if (sortCondition == 0) {
		updShaYmdDescClass = "comTableSort";
	} else if (sortCondition == 1) {
		updShaYmdAscClass = "comTableSort";
	}
%>

	    <%-- 項目 --%>
	    <s:if test="searchType == 1 ">
	    	<!-- 施設一覧　検索結果 -->
	    	<s:if test="selectListChange == 0 ">
	    		<div style="width:1200px; text-align:right">
	    			<a id="allShowButton" onclick="showAll();">
		            		全項目展開>>
	            	</a>
                 </div>
	    	<div class="kensakuDate">
	    	<table class="comTableTitle" id="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none;">
	    		<thead>
		        <tr>
		            <td class="comTableTitle" id="left1" style="min-width:63px;">
		            	<nobr>
		            		更新日
		            	<a href="#" class="<%=updShaYmdAscClass %>" onclick="orderUp();"> ▲ </a>
		            	<a href="#" class="<%=updShaYmdDescClass %>" onclick="orderDown();"> ▼ </a>
		            	</nobr>

		            </td>
		            <td class="comTableTitle" id="left2" style="min-width:84px;"><nobr>申請ID</nobr></td>
		            <td class="comTableTitle" id="left3" style="width:146pt;"><nobr>施設固定コード</nobr></td>
		        　　　　　　　 <td class="comTableTitle" id="left4" style="width:146pt;"><nobr>対象区分</nobr></td>
		            <td class="comTableTitle" id="left5" style="width:146pt;"><nobr>施設略式漢字名</nobr></td>
		            <td class="comTableTitle" id="left6" style="width:146pt;"><nobr>施設正式漢字名</nobr></td>
					<td class="comTableTitle" id="left7" style="width:146pt;"><nobr>郵便番号</nobr></td>
		            <td class="comTableTitle" id="left8" style="width:146pt;"><nobr>施設住所（漢字）</nobr></td>
		            <td class="comTableTitle" id="left9" style="width:146pt;"><nobr>電話番号1</nobr></td>
		            <td class="comTableTitle" id="left10" style="width:146pt;"><nobr>FAX番号1</nobr></td>
		            <!-- <td class="comTableTitle" id="left11" style="width:146pt;"><nobr>（来期）項目変更フラグ</nobr></td>
		            <td class="comTableTitle" id="left12" style="width:146pt;"><nobr>その他項目の変更フラグ</nobr></td> -->
		            <td class="comTableTitle" id="left13" style="width:146pt;"><nobr>申請者氏名</nobr></td>
		            <td class="comTableTitle" id="left14" style="width:146pt;"><nobr>承認者氏名</nobr></td>
		            <!-- ここから全画面 -->
		            <td class="comTableTitle" id="allShow1" style="width:146pt; display: none;"><nobr>ULT施設コード</nobr></td>
		            <td class="comTableTitle" id="allShow2" style="width:146pt; display: none;"><nobr>ULT施設名称</nobr></td>
		            <!-- <td class="comTableTitle" id="allShow3" style="width:146pt; display: none;"><nobr>施設契約漢字名</nobr></td> -->
		            <td class="comTableTitle" id="allShow4" style="width:146pt; display: none;"><nobr>施設区分</nobr></td>
		            <td class="comTableTitle" id="allShow5" style="width:146pt; display: none;"><nobr>階級区分</nobr></td>
		            <td class="comTableTitle" id="allShow6" style="width:146pt; display: none;"><nobr>経営主体</nobr></td>
		            <td class="comTableTitle" id="allShow7" style="width:146pt; display: none;"><nobr>JIS府県</nobr></td>
		            <td class="comTableTitle" id="allShow8" style="width:146pt; display: none;"><nobr>JIS市区町村</nobr></td>
		            <td class="comTableTitle" id="allShow9" style="width:146pt; display: none;"><nobr>武田市区郡</nobr></td>
		            <td class="comTableTitle" id="allShow10" style="width:146pt; display: none;"><nobr>電話番号2</nobr></td>
		            <td class="comTableTitle" id="allShow11" style="width:146pt; display: none;"><nobr>FAX番号2</nobr></td>
		            <td class="comTableTitle" id="allShow12" style="width:146pt; display: none;"><nobr>ホームページアドレス</nobr></td>
		            <td class="comTableTitle" id="allShow13" style="width:146pt; display: none;"><nobr>ホームページアドレス最終更新日</nobr></td>
		            <td class="comTableTitle" id="allShow14" style="width:146pt; display: none;"><nobr>ワクチン対象区分(当期)</nobr></td>
		            <td class="comTableTitle" id="allShow15" style="width:146pt; display: none;"><nobr>ワクチン定訪先区分(当期)</nobr></td>
		            <td class="comTableTitle" id="allShow16" style="width:146pt; display: none;"><nobr>病床(基準)</nobr></td>
		            <td class="comTableTitle" id="allShow17" style="width:146pt; display: none;"><nobr>ベッド数計</nobr></td>
		            <td class="comTableTitle" id="allShow18" style="width:146pt; display: none;"><nobr>医療ベッド数計</nobr></td>
		            <td class="comTableTitle" id="allShow19" style="width:146pt; display: none;"><nobr>病床数(一般)</nobr></td>
		            <td class="comTableTitle" id="allShow20" style="width:146pt; display: none;"><nobr>病床数(医療療養)</nobr></td>
		            <td class="comTableTitle" id="allShow21" style="width:146pt; display: none;"><nobr>病床数(精神)</nobr></td>
		            <td class="comTableTitle" id="allShow22" style="width:146pt; display: none;"><nobr>病床数(結核)</nobr></td>
		            <td class="comTableTitle" id="allShow23" style="width:146pt; display: none;"><nobr>病床数(感染症)</nobr></td>
		            <td class="comTableTitle" id="allShow24" style="width:146pt; display: none;"><nobr>病床数(介護療養)</nobr></td>
		            <td class="comTableTitle" id="allShow25" style="width:146pt; display: none;"><nobr>病床数(療養)</nobr></td>
		            <td class="comTableTitle" id="allShow26" style="width:146pt; display: none;"><nobr>開業年</nobr></td>
		            <td class="comTableTitle" id="allShow27" style="width:146pt; display: none;"><nobr>開業月</nobr></td>
		            <td class="comTableTitle" id="allShow28" style="width:146pt; display: none;"><nobr>開業日</nobr></td>
		            <td class="comTableTitle" id="allShow29" style="width:146pt; display: none;"><nobr>診療科目</nobr></td>
		            <td class="comTableTitle" id="allShow30" style="width:146pt; display: none;"><nobr>申請者所属リージョン</nobr></td>
		            <td class="comTableTitle" id="allShow31" style="width:146pt; display: none;"><nobr>申請者所属エリア</nobr></td>
		            <td class="comTableTitle" id="allShow32" style="width:146pt; display: none;"><nobr>承認者所属</nobr></td>
		            <!-- ここまで -->

		        </tr>
		        </thead>
			    <%-- 内容 --%>
			    <tbody>
			    <s:iterator value="hcoUpdHstDataList" status="status" var="rowBean">
			        <tr>
			        	<!-- 更新 -->
						<td class="comTableItem" id="left1" style="z-index:2;" >
							<s:if test="%{#rowBean.updShaYmd == null || #rowBean.updShaYmd == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<nobr><s:label key="hcoUpdHstDataList[%{#status.index}].updShaYmd" /></nobr>
				            </s:else>
						</td>
						<!-- 申請ID -->
						<td class="comTableItem" id="left2" style="z-index:2;" >
							<s:if test="%{#rowBean.reqId == null || #rowBean.reqId == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<nobr><s:label key="hcoUpdHstDataList[%{#status.index}].reqId" /></nobr>
				            </s:else>
						</td>
						<!-- 施設固定コード -->
						<td class="comTableItem" id="left3" style="z-index:2;" >
							<s:if test="%{#rowBean.insNo == null || #rowBean.insNo == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<nobr><s:label key="hcoUpdHstDataList[%{#status.index}].insNo" /></nobr>
				            </s:else>
						</td>
						<!-- 対象区分 -->
						<td class="comTableItem" id="left4" style="z-index:2;" >
							<s:if test="%{#rowBean.hoInsType == null || #rowBean.hoInsType == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.hoInsTypeUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].hoInsType" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].hoInsType" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 施設略式漢字名 -->
						<td class="comTableItem" id="left5" style="z-index:2;" >
							<s:if test="%{#rowBean.insAbbrName == null || #rowBean.insAbbrName == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insAbbrNameUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insAbbrName" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insAbbrName" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 施設正式漢字名 -->
						<td class="comTableItem" id="left6"  >
							<s:if test="%{#rowBean.insFormalName == null || #rowBean.insFormalName == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insFormalNameUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insFormalName" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insFormalName" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 郵便番号 -->
						<td class="comTableItem" id="left7"  >
							<s:if test="%{#rowBean.insPcode == null || #rowBean.insPcode == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else><nobr>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insPcodeUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insPcode" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insPcode" />
				            	</s:else>
				            </nobr></s:else>
						</td>
						<!-- 施設住所（漢字） -->
						<td class="comTableItem" id="left8"  >
							<s:if test="%{#rowBean.insAddr == null || #rowBean.insAddr == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insAddrUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insAddr" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insAddr" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 電話番号1 -->
						<td class="comTableItem" id="left9"  >
							<s:if test="%{#rowBean.insPhone1 == null || #rowBean.insPhone1 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else><nobr>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insPhone1UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insPhone1" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insPhone1" />
				            	</s:else>
				            </nobr></s:else>
						</td>
						<!-- FAX番号1 -->
						<td class="comTableItem" id="left10"  >
							<s:if test="%{#rowBean.insFax1 == null || #rowBean.insFax1 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insFax1UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insFax1" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<nobr><s:label key="hcoUpdHstDataList[%{#status.index}].insFax1" /></nobr>
				            	</s:else>
				            </s:else>
						</td>
						<!-- （来期）項目変更フラグ -->
						<!-- <td class="comTableItem" id="left11"  >
							<s:if test="%{#rowBean.hcoNxt == null || #rowBean.hcoNxt == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcoUpdHstDataList[%{#status.index}].hcoNxt" style="color:red;"/>
				            </s:else>
						</td> -->
						<!-- その他項目の変更フラグ -->
						<!-- <td class="comTableItem" id="left12"  >
							<s:if test="%{#rowBean.otherChanges == null || #rowBean.otherChanges == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcoUpdHstDataList[%{#status.index}].otherChanges" />
				            </s:else>
						</td> -->
						<!-- 申請者氏名 -->
						<td class="comTableItem" id="left13"  >
							<s:if test="%{#rowBean.reqJgiName == null || #rowBean.reqJgiName == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<nobr><s:label key="hcoUpdHstDataList[%{#status.index}].reqJgiName" /></nobr>
				            </s:else>
						</td>
						<!-- 承認者氏名 -->
						<td class="comTableItem" id="left14"  >
							<s:if test="%{#rowBean.aprShaId == null || #rowBean.aprShaId == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<nobr><s:label key="hcoUpdHstDataList[%{#status.index}].aprShaId" /></nobr>
				            </s:else>
						</td>

						<!-- ここから全画面 -->
						<!-- ULT施設コード -->
						<td class="comTableItem" name="allShowCont1" style="display:none;" >
							<s:if test="%{#rowBean.ultInsNo == null || #rowBean.ultInsNo == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.ultInsNoUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].ultInsNo" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].ultInsNo" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- ULT施設名称 -->
						<td class="comTableItem" name="allShowCont2" style="display:none;" >
							<s:if test="%{#rowBean.shisetsuNmRyaku == null || #rowBean.shisetsuNmRyaku == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.ultInsNoUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].shisetsuNmRyaku" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].shisetsuNmRyaku" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 施設契約漢字名 -->
						<!-- <td class="comTableItem" name="allShowCont3" style="display:none;" >
							<s:if test="%{#rowBean.insContName == null || #rowBean.insContName == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else> -->
								<!-- 更新がある場合 -->
				            	<!-- <s:if test="%{#rowBean.insContNameUpdFlg == 1}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insContName" style="color:red;"/>
				            	</s:if> -->
				            	<!-- 更新がない場合 -->
				            	<!-- <s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insContName" />
				            	</s:else>
				            </s:else>
						</td> -->
						<!-- 施設区分 -->
						<td class="comTableItem" name="allShowCont4" style="display:none;" >
							<s:if test="%{#rowBean.pharmType == null || #rowBean.pharmType == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.pharmTypeUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].pharmType" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].pharmType" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 階級区分 -->
						<td class="comTableItem" name="allShowCont5" style="display:none;" >
							<s:if test="%{#rowBean.insRank == null || #rowBean.insRank == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insRankUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insRank" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insRank" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 経営主体 -->
						<td class="comTableItem" name="allShowCont6" style="display:none;" >
							<s:if test="%{#rowBean.manageCd == null || #rowBean.manageCd == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.manageCdUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].manageCd" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].manageCd" />
				            	</s:else>
				            </s:else>
						</td>
						<!--JIS府県名  -->
						<td class="comTableItem" name="allShowCont7" style="display:none;" >
							<s:if test="%{#rowBean.addrNamePref == null || #rowBean.addrNamePref == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.addrNamePrefUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].addrNamePref" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].addrNamePref" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- JIS市区町村名 -->
						<td class="comTableItem" name="allShowCont8" style="display:none;" >
							<s:if test="%{#rowBean.addrNameCity == null || #rowBean.addrNameCity == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.addrNameCityUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].addrNameCity" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].addrNameCity" />
				            	</s:else>
				            </s:else>
						</td>
						<!--武田市区郡名  -->
						<td class="comTableItem" name="allShowCont9" style="display:none;" >
							<s:if test="%{#rowBean.tkCityName == null || #rowBean.tkCityName == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.tkCityNameUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].tkCityName" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].tkCityName" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 電話番号2 -->
						<td class="comTableItem" name="allShowCont10" style="display:none;" >
							<s:if test="%{#rowBean.insPhone2 == null || #rowBean.insPhone2 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else><nobr>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insPhone2UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insPhone2" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insPhone2" />
				            	</s:else>
				            </nobr></s:else>
						</td>
						<!-- FAX番号2 -->
						<td class="comTableItem" name="allShowCont11" style="display:none;" >
							<s:if test="%{#rowBean.insFax2 == null || #rowBean.insFax2 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else><nobr>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insFax2UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insFax2" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insFax2" />
				            	</s:else>
				            </nobr></s:else>
						</td>
						<!-- ホームページアドレス -->
						<td class="comTableItem" name="allShowCont12" style="display:none;" >
							<s:if test="%{#rowBean.insUrl == null || #rowBean.insUrl == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else><nobr>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insUrlUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insUrl" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insUrl" />
				            	</s:else>
				            </nobr></s:else>
						</td>
						<!-- ホームページアドレス最終更新日 -->
						<td class="comTableItem" name="allShowCont13" style="display:none;" >
							<s:if test="%{#rowBean.insUrlYmd == null || #rowBean.insUrlYmd == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insUrlYmdUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insUrlYmd" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insUrlYmd" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- ワクチン対象区分(当期) -->
						<td class="comTableItem" name="allShowCont14" style="display:none;" >
							<s:if test="%{#rowBean.vacInsType == null || #rowBean.vacInsType == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.vacInsTypeUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].vacInsType" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].vacInsType" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- ワクチン定訪先区分(当期) -->
						<td class="comTableItem" name="allShowCont15" style="display:none;" >
							<s:if test="%{#rowBean.vacVisitType == null || #rowBean.vacVisitType == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.vacVisitTypeUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].vacVisitType" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].vacVisitType" />
				            	</s:else>
				            </s:else>

						</td>
						<!-- 病床(基準) -->
						<td class="comTableItem" name="allShowCont16" style="display:none;" >
							<s:if test="%{#rowBean.bedcntBase == null || #rowBean.bedcntBase == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedcntBaseUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedcntBase" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedcntBase" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- ベッド数計 -->
						<td class="comTableItem" name="allShowCont17" style="display:none;" >
							<s:if test="%{#rowBean.bedsTot == null || #rowBean.bedsTot == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedsTotUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedsTot" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedsTot" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 医療ベッド数計 -->
						<td class="comTableItem" name="allShowCont18" style="display:none;" >
							<s:if test="%{#rowBean.medBedsTot == null || #rowBean.medBedsTot == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.medBedsTotUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].medBedsTot" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].medBedsTot" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 病床数(一般)-->
						<td class="comTableItem" name="allShowCont19" style="display:none;" >
							<s:if test="%{#rowBean.bedcnt01 == null || #rowBean.bedcnt01 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedcnt01UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt01" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt01" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 病床数(医療療養) -->
						<td class="comTableItem" name="allShowCont20" style="display:none;" >
							<s:if test="%{#rowBean.bedcnt02 == null || #rowBean.bedcnt02 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedcnt02UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt02" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt02" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 病床数(精神) -->
						<td class="comTableItem" name="allShowCont21" style="display:none;" >
							<s:if test="%{#rowBean.bedcnt03 == null || #rowBean.bedcnt03 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedcnt03UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt03" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt03" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 病床数(結核) -->
						<td class="comTableItem" name="allShowCont22" style="display:none;" >
							<s:if test="%{#rowBean.bedcnt04 == null || #rowBean.bedcnt04 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedcnt04UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt04" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt04" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 病床数(感染症)-->
						<td class="comTableItem" name="allShowCont23" style="display:none;" >
							<s:if test="%{#rowBean.bedcnt05 == null || #rowBean.bedcnt05 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedcnt05UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt05" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt05" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 病床数(介護療養) -->
						<td class="comTableItem" name="allShowCont24" style="display:none;" >
							<s:if test="%{#rowBean.bedcnt06 == null || #rowBean.bedcnt06 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedcnt06UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt06" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt06" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 病床数(療養) -->
						<td class="comTableItem" name="allShowCont25" style="display:none;" >
							<s:if test="%{#rowBean.bedcnt07 == null || #rowBean.bedcnt07 == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.bedcnt07UpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt07" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].bedcnt07" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 開業年 -->
						<td class="comTableItem" name="allShowCont26" style="display:none;" >
							<s:if test="%{#rowBean.insOpenYear == null || #rowBean.insOpenYear == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insOpenYmdUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insOpenYear" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insOpenYear" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 開業月 -->
						<td class="comTableItem" name="allShowCont27" style="display:none;" >
							<s:if test="%{#rowBean.insOpenMonth == null || #rowBean.insOpenMonth == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.insOpenYmdUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
					            		<s:label key="hcoUpdHstDataList[%{#status.index}].insOpenMonth" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcoUpdHstDataList[%{#status.index}].insOpenMonth" />
					            	</s:else>
				            </s:else>
						</td>
						<!-- 開業日 -->
						<td class="comTableItem" name="allShowCont28" style="display:none;" >
							<s:if test="%{#rowBean.insOpenDay == null || #rowBean.insOpenDay == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.insOpenYmdUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].insOpenDay" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].insOpenDay" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 診療科目 -->
						<td class="comTableItem" name="allShowCont29" style="display:none;" >
							<s:if test="%{#rowBean.clitemList == null || #rowBean.clitemList == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.clitemListUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcoUpdHstDataList[%{#status.index}].clitemList" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcoUpdHstDataList[%{#status.index}].clitemList" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 申請者所属リージョン -->
						<td class="comTableItem" name="allShowCont30" style="display:none;" >
							<s:if test="%{#rowBean.reqBrCod == null || #rowBean.reqBrCod == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcoUpdHstDataList[%{#status.index}].reqBrCod" />
				            </s:else>
						</td>
						<!-- 申請者所属エリア -->
						<td class="comTableItem" name="allShowCont31" style="display:none;" >
							<s:if test="%{#rowBean.reqDistCode == null || #rowBean.reqDistCode == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcoUpdHstDataList[%{#status.index}].reqDistCode" />
				            </s:else>
						</td>
						<!-- 承認者所属 -->
						<td class="comTableItem" name="allShowCont32" style="display:none;" >
							<s:if test="%{#rowBean.aprShz == null || #rowBean.aprShz == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcoUpdHstDataList[%{#status.index}].aprShz" />
				            </s:else>
						</td>

			        </tr>

			    </s:iterator>
			    </tbody>
				</table>
			    </div>
	    	</s:if>

	    	<!-- 領域別担当者　検索結果 -->
	    	<s:if test="selectListChange == 1">
		    	<div style="height: 370px; width: 1100px; overflow: scroll;">
		    	<table class="comTableTitle" id="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none;">
		    		<tr>
			            <td class="comTableTitle" style="width:146pt;"><nobr>更新日</nobr></td>
			            <td class="comTableTitle" style="width:146pt;"><nobr>申請ID</nobr></td>
			            <td class="comTableTitle" style="width:146pt;"><nobr>施設固定コード</nobr></td>
			        　　　　　　　 <td class="comTableTitle" style="width:146pt;"><nobr>対象区分</nobr></td>
			            <td class="comTableTitle" style="width:146pt;"><nobr>施設略式漢字名</nobr></td>
			            <td class="comTableTitle" style="width:146pt;"><nobr>親施設コード</nobr></td>
						<td class="comTableTitle" style="width:146pt;"><nobr>親施設名</nobr></td>
			            <td class="comTableTitle" style="width:146pt;"><nobr>領域名（親子）</nobr></td>
			           　　　　　　<td class="comTableTitle" style="width:146pt;"><nobr>申請者所属</nobr></td>
			            <td class="comTableTitle" style="width:146pt;"><nobr>申請者氏名</nobr></td>
			            <td class="comTableTitle" style="width:146pt;"><nobr>承認者所属</nobr></td>
			            <td class="comTableTitle" style="width:146pt;"><nobr>承認者氏名</nobr></td>
			        </tr>
			        <s:iterator value="mainInsDataList" status="status" var="rowBean">
				        <tr>
				        	<!-- 更新 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.updShaYmd == null || #rowBean.updShaYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="mainInsDataList[%{#status.index}].updShaYmd" />
					            </s:else>
							</td>
							<!-- 申請ID -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqId == null || #rowBean.reqId == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="mainInsDataList[%{#status.index}].reqId" />
					            </s:else>
							</td>
							<!-- 施設固定コード -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.insNo == null || #rowBean.insNo == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="mainInsDataList[%{#status.index}].insNo" />
					            </s:else>
							</td>
							<!-- 対象区分 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.hoInsType == null || #rowBean.hoInsType == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.hoInsTypeUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
					            		<s:label key="mainInsDataList[%{#status.index}].hoInsType" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="mainInsDataList[%{#status.index}].hoInsType" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 施設略式漢字名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.insAbbrName == null || #rowBean.insAbbrName == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.insAbbrNameUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
					            		<s:label key="mainInsDataList[%{#status.index}].insAbbrName" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="mainInsDataList[%{#status.index}].insAbbrName" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 親施設コード -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.mainInsNo == null || #rowBean.mainInsNo == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.mainInsNoUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
					            		<s:label key="mainInsDataList[%{#status.index}].mainInsNo" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="mainInsDataList[%{#status.index}].mainInsNo" />
					            	</s:else>
					            </s:else>
							</td>
							<!--親施設名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.mainInsNm == null || #rowBean.mainInsNm == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.mainInsNmUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
					            		<s:label key="mainInsDataList[%{#status.index}].mainInsNm" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="mainInsDataList[%{#status.index}].mainInsNm" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 領域名（親子） -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.trtNm == null || #rowBean.trtNm == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="mainInsDataList[%{#status.index}].trtNm" />
					            </s:else>
							</td>
							<!-- 申請者所属 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqShz == null || #rowBean.reqShz == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="mainInsDataList[%{#status.index}].reqShz" />
					            </s:else>
							</td>
							<!-- 申請者氏名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqJgiName == null || #rowBean.reqJgiName == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="mainInsDataList[%{#status.index}].reqJgiName" />
					            </s:else>
							</td>
							<!-- 承認者所属 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.aprShz == null || #rowBean.aprShz == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="mainInsDataList[%{#status.index}].aprShz" />
					            </s:else>
							</td>
							<!-- 承認者氏名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.aprShaId == null || #rowBean.aprShaId == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="mainInsDataList[%{#status.index}].aprShaId" />
					            </s:else>
							</td>
				        </tr>
				    </s:iterator>
				  </table>
				</div>
	    	</s:if>

	    </s:if>
<%-- メイン部 一覧 終了    key="catDeptsComboDataList[%{#status.index}].addrNameArea" --%>
<!--  <hr class="comSplit" /> -->
<%-- 後制御部 --%>

    <hr class="comSplit" />
	<table>
		<tr>
		<!-- 検索ボタン -->
		<td>
			<input type="button" value="戻る" onclick="window.close();" />
		</td>
		</tr>
	</table>

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
