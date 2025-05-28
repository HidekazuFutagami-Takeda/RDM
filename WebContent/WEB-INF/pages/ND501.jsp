<%--
/**
 * <pre>
 * ND501_医師変更履歴のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author SBS  千葉
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND501DTO"%>
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
	<title>ND501_医師変更履歴</title>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<link href="WebContent/css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
	<script>
    function comSetFormWindowInfo(){
    	comClickFlgInit();
    }
    </script>
	<script type="text/javascript" src="js/ND501.js"></script>
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
			position:sticky;left: 89pt;z-index:3;
		}
		#left4 {
			position:sticky;left: 155pt;z-index:3;
		}



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
<%
// ソート順状態制御用
String sortCondition = StringUtils.nvl((String)request.getAttribute("sortId"), "");
//String sortCondition = null;
%>

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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="医師変更履歴"></td>
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
      <s:hidden name="insNo" />
      <s:hidden name="insAbbrName" />

      <s:hidden name="mrJgiNo" />
      <s:hidden name="mrBrCode" />
      <s:hidden name="mrDistCode" />
      <s:hidden name="mrTrtCd" />

      <s:hidden name="kensakuTantouSosCd" />
      <s:hidden name="kensakuTantouDistCode" />
      <s:hidden name="kensakuSTantouBrCode" />
      <s:hidden name="kensakuShinseiSosCd" />
      <s:hidden name="kensakuShinseiDistCode" />
      <s:hidden name="kensakuShinseiBrCode" />
      <s:hidden name="kensakuJgiNo" />
      <s:hidden name="clearUpdMstFrom" />
      <s:hidden name="clearUpdMstTo" />

		<s:hidden name="bumonRank" />
		<s:hidden name="upSosCd" />

      <s:hidden name="sortCondition1" />
      <s:hidden name="sortCondition2" />
      <s:hidden name="screenId" value="ND501" />
      <s:hidden name="functionId"/>
      <s:hidden name="buttonFlg" />
      <s:hidden name="gamenId"/>
      <s:hidden id="pageFlag" name="pageFlag" />
      <s:hidden name="listName" />
      <s:hidden name="poprowno" />
      <s:hidden name="poptrtno" />
      <s:hidden name="loginJokenSetCd"/>
      <s:hidden name="backScreenId" value="ND501"/>

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

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

	<tr>
		<%-- 氏名漢字(全角) --%>
		<td class="pupControlItem"><nobr>氏名漢字(全角)</nobr>
		</td>
		<td>
			<s:textfield name="kensakuDocKanj" id="kensakuDocKanj" size="20" maxlength="128" />
		</td>
		<%-- 氏名カナ(半角カナ) --%>
		<td class="pupControlItem"><nobr>氏名カナ(半角カナ)</nobr>
		</td>
		<td>
			<s:textfield id="kensakuDocKana" name="kensakuDocKana" size="20" maxlength="128" />
		</td>
		<%-- 医師／薬剤師区分 --%>
		<td class="pupControlItem"><nobr>医師／薬剤師区分</nobr>
		</td>
		<td>
			<s:select id="kensakuDocType" name="kensakuDocType" cssStyle="width:80pt" list ="docTypeMap" />
		</td>
	</tr>
	<tr>
		<%-- 医師固定C --%>
		<td class="pupControlItem"><nobr>医師固定C</nobr>
		</td>
		<td>
			<s:textfield id="kensakuDocNo" name="kensakuDocNo" size="20" maxlength="128" />
		</td>
		<%-- ULT医師コード --%>
		<td class="pupControlItem"><nobr>ULT医師コード</nobr>
		</td>
		<td>
			<s:textfield id="kensakuUltDocNo"  name="kensakuUltDocNo" size="20" maxlength="128" />
		</td>
		<%-- 医師属性 --%>
		<td class="pupControlItem"><nobr>医師属性</nobr>
		</td>
		<td>
			<s:select id="kensakuDocAttribute" name="kensakuDocAttribute" cssStyle="width:80pt" list ="docAttributeMap" />
		</td>
	</tr>
	<tr>
		<%-- 出身校 --%>
		<td class="pupControlItem"><nobr>出身校</nobr>
		</td>
		<td>
			<s:select id="kensakuMedSch" name="kensakuMedSch" cssStyle="width:80pt" list ="medSchMap" />
		</td>
		<%-- 卒年(西暦) --%>
		<td class="pupControlItem"><nobr>卒年(西暦)</nobr>
		</td>
		<td>
			<s:select id="kensakuGradYear" name="kensakuGradYear" cssStyle="width:80pt" list ="gradYearMap" />
		</td>
		<%-- 出身医局校 --%>
		<td class="pupControlItem"><nobr>出身医局校</nobr>
		</td>
		<td>
			<s:select id="kensakuHuniv" name="kensakuHuniv" cssStyle="width:80pt" list ="hunivMap" />
		</td>
	</tr>
	<tr>
		<%-- 担当者組織 --%>
		<td class="pupControlItem"><nobr>担当者組織
<%-- 			<s:if test="%{jokenSetCd == 1}"> --%>
				<input id="sosButton1" class="comButton" type="button" value="選択" onClick="sosNamePop();" />
<%-- 			</s:if> --%>
<%-- 			<s:else> --%>
<!-- 				<input id="sosButton1" class="comButton" type="button" value="選択"   disabled /> -->
<%-- 			</s:else> --%>
		</nobr></td>
		<td>
<%-- 			<s:if test="%{jokenSetCd == 1}"> --%>
				<s:textfield id="sosName" name="sosName" size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true" />
          		<a href="#" class="comMiniLink" onClick="sosNameClear();">Clear</a>
<%-- 			</s:if> --%>
<%-- 			<s:else> --%>
<%-- 				<s:textfield id="" name="sosName" size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true" /> --%>
<!--           		<a href="#" class="comMiniLink" onClick="return false;">Clear</a> -->
<%-- 			</s:else> --%>
		</td>
		<%-- 担当者 --%>
		<td class="pupControlItem"><nobr>担当者
<%-- 			<s:if test="%{jokenSetCd == 1}"> --%>
				<input id="sosButton1" class="comButton" type="button" value="選択" onClick="jgiNamePop();" />
<%-- 			</s:if> --%>
<%-- 			<s:else> --%>
<!-- 				<input id="sosButton1" class="comButton" type="button" value="選択" onClick=""  disabled/> -->
<%-- 			</s:else> --%>
		</nobr></td>
		<td>
<%-- 			<s:if test="%{jokenSetCd == 1}"> --%>
				<s:textfield id="jgiName" name="jgiName"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  />
          		<a href="#" class="comMiniLink" onClick="jgiNameClear();">Clear</a>
<%-- 			</s:if> --%>
<%-- 			<s:else> --%>
<%-- 				<s:textfield id="" name="jgiName"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  /> --%>
<!--           		<a href="#" class="comMiniLink" onClick="return false;">Clear</a> -->
<%-- 			</s:else> --%>
		</td>
		<%-- 申請者組織 --%>
		<td class="pupControlItem"><nobr>申請者組織
<%-- 			<s:if test="%{jokenSetCd == 1}"> --%>
				<input id="sosButton1" class="comButton" type="button" value="選択" onclick="shinseiSosNamePop();" />
<%-- 			</s:if> --%>
<%-- 			<s:else> --%>
<!-- 				<input id="sosButton1" class="comButton" type="button" value="選択" disabled /> -->
<%-- 			</s:else> --%>
		</nobr></td>
		<td>
<%-- 			<s:if test="%{jokenSetCd == 1}"> --%>
				<s:textfield id="kensakuReqShz" name="kensakuReqShz"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  />
	          	<a href="#" class="comMiniLink" onClick="ReqShzClear();">Clear</a>
<%-- 			</s:if> --%>
<%-- 			<s:else> --%>
<%-- 				<s:textfield id="" name="kensakuReqShz"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  /> --%>
<!--          		<a href="#" class="comMiniLink" onClick="return false;">Clear</a> -->
<%-- 			</s:else> --%>
		</td>
	</tr>
	<tr>
		<%-- 施設固定C --%>
		<td class="pupControlItem"><nobr>施設固定C</nobr>
		</td>
		<td>
			<s:textfield id="kensakuInsNo" name="kensakuInsNo" size="20" maxlength="128"/>
		</td>
		<%-- 施設名 --%>
		<td class="pupControlItem"><nobr>施設名
		<input id="sosButton1" class="comButton" type="button" value="選択" onclick="tmpCseView()" />
		</nobr></td>
		<td>
			<s:textfield id="kensakuInsKanj" name="kensakuInsKanj"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  />
        	<a href="#" class="comMiniLink" onClick="insKanjClear();">Clear</a>
		</td>
		<%-- 申請者 --%>
		<td class="pupControlItem"><nobr>申請者</nobr></td>
		<td>
<%-- 			<s:if test="%{jokenSetCd == 1}"> --%>
				<s:textfield id="kensakuReqJgiName" name="kensakuReqJgiName" size="20" maxlength="128" />
<%-- 			</s:if> --%>
<%-- 			<s:else> --%>
<%-- 				<s:textfield id="" name="kensakuReqJgiName" size="20" maxlength="128" cssClass="mediumGray" readonly="true"/> --%>
<%-- 			</s:else> --%>
		</td>
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
		<td align="right" colspan=6>
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
  String docKanaAscClass = "comTableNoSort";
  String docKanaDescClass = "comTableNoSort";
  String docKanjAscClass = "comTableNoSort";
  String docKanjDescClass = "comTableNoSort";

  if ("1".equals(sortCondition)) {
	  docKanaDescClass = "comTableSort";
  } else if ("2".equals(sortCondition)) {
	  docKanjAscClass = "comTableSort";
  } else if ("3".equals(sortCondition)) {
	  docKanjDescClass = "comTableSort";
  }
%>

	    <%-- 項目 --%>
	    <s:if test="searchType == 1 ">
	    	<!-- 医師基本情報　検索結果 -->
	    	<s:if test="selectListChange == 0 ">

	    	<div class="kensakuDate">
	    	<table class="comTableTitle" id="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none;">
	    		<thead>
		        <tr>
		            <td class="comTableTitle" id="left1" style="min-width:63px;">
		            	<nobr>
		            		更新日
		            	</nobr>
		            	<span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaAscClass %>" href="" onclick="jimSort(0);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaDescClass %>" href="" onclick="jimSort(1);return false;">▼</a>
		            </td>
		            <td class="comTableTitle" id="left2" style="width:146pt;"><nobr>医師固定C</nobr></td>
		            <td class="comTableTitle" id="left3" style="width:146pt;"><nobr>医師／薬剤師区分</nobr></td>
		        　　　　　　　 <td class="comTableTitle" id="left4" style="min-width:100pt;"><nobr>氏名（漢字）</nobr></td>
		       		 <!-- ここから全画面 -->
		            <td class="comTableTitle" id="" style="min-width:80pt;"><nobr>氏名（カナ）</nobr></td>
		            <td class="comTableTitle" id="" style="width:146pt;"><nobr>氏名（漢字）姓</nobr></td>
					<td class="comTableTitle" id="" style="width:146pt;"><nobr>氏名（漢字）名</nobr></td>
		            <td class="comTableTitle" id="" style="width:146pt;"><nobr>氏名（カナ）姓</nobr></td>
		            <td class="comTableTitle" id="" style="width:146pt;"><nobr>氏名（カナ）名</nobr></td>
		            <td class="comTableTitle" id="" style="width:146pt;"><nobr>氏名（漢字）旧姓</nobr></td>
		            <td class="comTableTitle" id="" style="width:146pt;"><nobr>氏名（カナ）旧姓</nobr></td>
		            <td class="comTableTitle" id="" style="width:146pt;"><nobr>改姓日</nobr></td>
		            <td class="comTableTitle" id="" style="width:146pt;"><nobr>生年月日</nobr></td>
		            <td class="comTableTitle" id="" style="width:146pt;"><nobr>性別区分</nobr></td>
		            <td class="comTableTitle" id="1" style="width:146pt;"><nobr>出身地</nobr></td>
		            <td class="comTableTitle" id="2" style="min-width:60pt;"><nobr>出身校</nobr></td>
		            <td class="comTableTitle" id="3" style="min-width:60pt;"><nobr>卒年</nobr></td>
		            <td class="comTableTitle" id="5" style="min-width:60pt;"><nobr>出身所属</nobr></td>
		            <td class="comTableTitle" id="6" style="min-width:60pt;"><nobr>出身医局校</nobr></td>
		            <td class="comTableTitle" id="7" style="min-width:60pt;"><nobr>臨床研修年</nobr></td>
		            <td class="comTableTitle" id="8" style="min-width:60pt;"><nobr>専門臓器</nobr></td>
		            <td class="comTableTitle" id="8" style="min-width:60pt;"><nobr>専門詳細</nobr></td>
		            <td class="comTableTitle" id="9" style="min-width:60pt;"><nobr>専門追加情報</nobr></td>
		            <td class="comTableTitle" id="10" style="min-width:60pt;"><nobr>申請者所属</nobr></td>
		            <td class="comTableTitle" id="11" style="min-width:50pt;"><nobr>申請者氏名</nobr></td>
		            <td class="comTableTitle" id="12" style="min-width:60pt;"><nobr>承認者所属</nobr></td>
		            <td class="comTableTitle" id="13" style="min-width:50pt;"><nobr>承認者氏名</nobr></td>
		            <td class="comTableTitle" id="14" style="min-width:60pt;"><nobr>申請チャネル</nobr></td>
		            <td class="comTableTitle" id="15" style="min-width:80pt;">
		            	<nobr>申請ID</nobr>
		            	<a  href="" onclick="jimSort(2);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a  href="" onclick="jimSort(3);return false;">▼</a>
		            </td>
		            <!-- ここまで -->

		        </tr>
		        </thead>
			    <%-- 内容 --%>
			    <tbody>
			    <s:iterator value="hcpUpdHstDataList" status="status" var="rowBean">
			        <tr>
			        	<!-- 更新日 -->
						<td class="comTableItem" id="left1" style="z-index:2;" >
							<s:if test="%{#rowBean.updMstYmd == null || #rowBean.updMstYmd == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcpUpdHstDataList[%{#status.index}].updMstYmd" />
				            </s:else>
						</td>
						<!-- 医師固定C -->
						<td class="comTableItem" id="left2" style="z-index:2;" >
							<s:if test="%{#rowBean.docNo == null || #rowBean.docNo == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcpUpdHstDataList[%{#status.index}].docNo" />
				            </s:else>
						</td>
						<!-- 医師／薬剤師区分 -->
						<td class="comTableItem" id="left3" style="z-index:2;" >
							<s:if test="%{#rowBean.docType == null || #rowBean.docType == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.docTypeUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docType" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docType" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 氏名（漢字） -->
						<td class="comTableItem" id="left4" style="z-index:2;" >
							<s:if test="%{#rowBean.docKanj == null || #rowBean.docKanj == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.docKanjUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanj" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanj" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- ここから全画面 -->

						<!-- 氏名（カナ） -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.docKana == null || #rowBean.docKana == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.docKanaUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKana" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKana" />
				            	</s:else>
				            </s:else>
						</td>
						<!--氏名（漢字）姓 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.docKanjSei == null || #rowBean.docKanjSei == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.docKanjSeiUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanjSei" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanjSei" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 氏名（漢字）名 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.docKanjMei == null || #rowBean.docKanjMei == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.docKanjMeiUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanjMei" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].docKanjMei" />
				            	</s:else>
				            </s:else>
						</td>

						<!-- 氏名（カナ）姓 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.docKanaSei == null || #rowBean.docKanaSei == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.docKanaSeiUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanaSei" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].docKanaSei" />
				            	</s:else>
				            </s:else>
						</td>

						<!-- 氏名（カナ）名 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.docKanaMei == null || #rowBean.docKanaMei == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.docKanaMeiUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanaMei" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].docKanaMei" />
				            	</s:else>
				            </s:else>
						</td>
						<!--氏名（漢字）旧姓 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.oldKanjSei == null || #rowBean.oldKanjSei == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.oldKanjSeiUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].oldKanjSei" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].oldKanjSei" />
				            	</s:else>
				            </s:else>
						</td>

						<!-- 氏名（カナ）旧姓 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.oldKanaSei == null || #rowBean.oldKanaSei == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.oldKanaSeiUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].oldKanaSei" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].oldKanaSei" />
				            	</s:else>

				            </s:else>
						</td>

						<!-- 改姓日 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.newNameStYmd == null || #rowBean.newNameStYmd == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.newNameStYmdUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].newNameStYmd" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].newNameStYmd" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 生年月日 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.dobYmd == null || #rowBean.dobYmd == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.dobYmdUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].dobYmd" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].dobYmd" />
				            	</s:else>
				            </s:else>
						</td>

						<!-- 性別区分 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.sex == null || #rowBean.sex == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.sexUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].sex" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].sex" />
				            	</s:else>
				            </s:else>
						</td>

						<!-- 出身地 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.homeTown == null || #rowBean.homeTown == ''}">
								<!-- 値なし -->
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.homeTownUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].homeTown" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].homeTown" />
				            	</s:else>
				            </s:else>
						</td>

						<!-- 出身校 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.medSch == null || #rowBean.medSch == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.medSchUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].medSch" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].medSch" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 卒年 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.gradYear == null || #rowBean.gradYear == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.gradYearUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].gradYear" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].gradYear" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 出身所属コード -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.ssnDeptCode == null || #rowBean.ssnDeptCode == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.ssnDeptCodeUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].ssnDeptCode" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].ssnDeptCode" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 出身医局校コード -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.huniv == null || #rowBean.huniv == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.hunivUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].huniv" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].huniv" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 臨床研修年 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.emplYear == null || #rowBean.emplYear == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.emplYearUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].emplYear" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].emplYear" />
				            	</s:else>
				            </s:else>
						</td>
						<!--専門臓器  -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.spLiver == null || #rowBean.spLiver == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.spLiverUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].spLiver" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].spLiver" />
				            	</s:else>
				            </s:else>
						</td>

						<!-- 専門詳細 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.spDisease == null || #rowBean.spDisease == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.spDiseaseUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].spDisease" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].spDisease" />
				            	</s:else>
				            </s:else>
						</td>

						<!--専門追加情報  -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.spCom == null || #rowBean.spCom == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<!-- 更新がある場合 -->
				            	<s:if test="%{#rowBean.spComUpdFlg == 1 && #rowBean.delFlgUpdFlg != 'N'}">
				            		<s:label key="hcpUpdHstDataList[%{#status.index}].spCom" style="color:red;"/>
				            	</s:if>
				            	<!-- 更新がない場合 -->
				            	<s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].spCom" />
				            	</s:else>
				            </s:else>
						</td>
						<!-- 申請者所属 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.reqShz == null || #rowBean.reqShz == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcpUpdHstDataList[%{#status.index}].reqShz" />
				            </s:else>
						</td>
						<!-- 申請者氏名 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.reqJgiName == null || #rowBean.reqJgiName == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcpUpdHstDataList[%{#status.index}].reqJgiName" />
				            </s:else>
						</td>
						<!-- 承認者所属 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.aprShz == null || #rowBean.aprShz == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcpUpdHstDataList[%{#status.index}].aprShz" />
				            </s:else>
						</td>
						<!-- 承認者氏名 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.aprShaId == null || #rowBean.aprShaId == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcpUpdHstDataList[%{#status.index}].aprShaId" />
				            </s:else>
						</td>
						<!-- 申請チャネル -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.reqChl == null || #rowBean.reqChl == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcpUpdHstDataList[%{#status.index}].reqChl" />
				            </s:else>
						</td>
						<!-- 申請ID-->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.reqId == null || #rowBean.reqId == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:label key="hcpUpdHstDataList[%{#status.index}].reqId" />
				            </s:else>
						</td>
			        </tr>

			    </s:iterator>
			    </tbody>
				</table>
			    </div>
	    	</s:if>

	    	<s:if test="selectListChange == 1">
	    		<!-- 勤務先情報　検索結果 -->
		    	<div style="height: 370px; width: 1100px; overflow: scroll;">
		    	<table class="comTableTitle" id="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border-collapse: collapse; border: 0px none;">
		    		<tr>
			            <td colspan="4" style="width:146pt;　border-top:hidden;"></td>


			            <td colspan="6" style="width:146pt;">変更後情報</td>


			            <td colspan="6" style="width:146pt;">変更前情報</td>


			            <td colspan="6" style="width:146pt;　border:hidden;"></td>

			        </tr>
		    		<tr>
			            <td class="comTableTitle" id="left1" style="min-width:63px;">
			            	<nobr>更新日</nobr>
			            	<a class="<%=docKanaAscClass %>" href="" onclick="jimSort(0);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaDescClass %>" href="" onclick="jimSort(1);return false;">▼</a>
			            </td>
			            <td class="comTableTitle" id="left2" style="width:146pt;"><nobr>医師固定C</nobr></td>
			            <td class="comTableTitle" id="left3" style="width:146pt;"><nobr>氏名（漢字）</nobr></td>
			        　　　　　　　 <td class="comTableTitle" style="min-width:80pt;"><nobr>申請区分</nobr></td>

			            <td class="comTableTitle" style="min-width:80pt;"><nobr>勤務先_施設</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>勤務形態</nobr></td>
						<td class="comTableTitle" style="min-width:60pt;"><nobr>所属部科</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>役職</nobr></td>
			           　　　　　　<td class="comTableTitle" style="min-width:60pt;"><nobr>大学職位</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>薬審メンバー区分</nobr></td>

			            <td class="comTableTitle" style="min-width:80pt;"><nobr>勤務先_施設</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>勤務形態</nobr></td>
						<td class="comTableTitle" style="min-width:60pt;"><nobr>所属部科</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>役職</nobr></td>
			           　　　　　　<td class="comTableTitle" style="min-width:60pt;"><nobr>大学職位</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>薬審メンバー区分</nobr></td>

			            <td class="comTableTitle" style="min-width:60pt;"><nobr>申請者所属</nobr></td>
			            <td class="comTableTitle" style="min-width:50pt;"><nobr>申請者氏名</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>承認者所属</nobr></td>
			            <td class="comTableTitle" style="min-width:50pt;"><nobr>承認者氏名</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>申請チャネル</nobr></td>
			            <td class="comTableTitle" style="min-width:80pt;"><nobr>申請ID</nobr></td>
			        </tr>
			        <s:iterator value="hcpUpdHstDataList" status="status" var="rowBean">
				        <tr>
				        	<!-- 更新日 -->
							<td class="comTableItem" id="left1" style="z-index:2;" >
								<s:if test="%{#rowBean.updMstYmd == null || #rowBean.updMstYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].updMstYmd" />
					            </s:else>
							</td>
							<!-- 医師固定C -->
							<td class="comTableItem" id="left2" style="z-index:2;" >
								<s:if test="%{#rowBean.docNo == null || #rowBean.docNo == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].docNo" />
					            </s:else>
							</td>
							<!-- 氏名（漢字） -->
							<td class="comTableItem" id="left3" style="z-index:2;" >
								<s:if test="%{#rowBean.docKanj == null || #rowBean.docKanj == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
					            	<s:label key="hcpUpdHstDataList[%{#status.index}].docKanj" />
					            </s:else>
							</td>
							<!-- 申請区分-->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqType == null || #rowBean.reqType == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqType" />
					            </s:else>
							</td>

							<!-- 勤務先_施設 変更後情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.insNoSk == null || #rowBean.insNoSk == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.insNoSkUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].insNoSk" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].insNoSk" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 勤務形態 変更後情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.jobFormAf == null || #rowBean.jobFormAf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.jobFormAfUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].jobFormAf" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].jobFormAf" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 所属部科 変更後情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.deptKanjiAf == null || #rowBean.deptKanjiAf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.deptKanjiAfUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].deptKanjiAf" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].deptKanjiAf" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 役職 変更後情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.titleCodeAf == null || #rowBean.titleCodeAf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.titleCodeAfUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].titleCodeAf" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].titleCodeAf" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 大学職位 変更後情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.univPosCodeAf == null || #rowBean.univPosCodeAf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.univPosCodeAfUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].univPosCodeAf" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].univPosCodeAf" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 薬審メンバー区分 変更後情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.dccTypeAf == null || #rowBean.dccTypeAf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.dccTypeAfUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].dccTypeAf" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].dccTypeAf" />
					            	</s:else>
					            </s:else>
							</td>

							<!-- 勤務先_施設  変更前情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.insNoMt == null || #rowBean.insNoMt == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
									<s:label key="hcpUpdHstDataList[%{#status.index}].insNoMt" />
					            </s:else>
							</td>
							<!-- 勤務形態  変更前情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.jobFormBf == null || #rowBean.jobFormBf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
									<s:label key="hcpUpdHstDataList[%{#status.index}].jobFormBf" />
					            </s:else>
							</td>
							<!-- 所属部科  変更前情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.deptKanjiBf == null || #rowBean.deptKanjiBf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
									<s:label key="hcpUpdHstDataList[%{#status.index}].deptKanjiBf" />
					            </s:else>
							</td>
							<!-- 役職  変更前情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.titleCodeBf == null || #rowBean.titleCodeBf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
									<s:label key="hcpUpdHstDataList[%{#status.index}].titleCodeBf" />
					            </s:else>
							</td>
							<!-- 大学職位  変更前情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.univPosCodeBf == null || #rowBean.univPosCodeBf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
									<s:label key="hcpUpdHstDataList[%{#status.index}].univPosCodeBf" />
					            </s:else>
							</td>
							<!-- 薬審メンバー区分  変更前情報 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.dccTypeBf == null || #rowBean.dccTypeBf == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
									<s:label key="hcpUpdHstDataList[%{#status.index}].dccTypeBf" />
					            </s:else>
							</td>

							<!-- 申請者所属 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqShz == null || #rowBean.reqShz == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqShz" />
					            </s:else>
							</td>
							<!-- 申請者氏名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqJgiName == null || #rowBean.reqJgiName == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqJgiName" />
					            </s:else>
							</td>
							<!-- 承認者所属 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.aprShz == null || #rowBean.aprShz == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].aprShz" />
					            </s:else>
							</td>
							<!-- 承認者氏名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.aprShaId == null || #rowBean.aprShaId == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].aprShaId" />
					            </s:else>
							</td>
							<!-- 申請チャネル -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqChl == null || #rowBean.reqChl == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqChl" />
					            </s:else>
							</td>
							<!-- 申請ID -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqId == null || #rowBean.reqId == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqId" />
					            </s:else>
							</td>
				        </tr>
				    </s:iterator>
				  </table>
				</div>
	    	</s:if>


	    	<s:if test="selectListChange == 2">
	    		<!-- 所属学会　検索結果 -->
		    	<div style="height: 370px; width: 1100px; overflow: scroll;">
		    	<table class="comTableTitle" id="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none;">
		    		<tr>
			            <td class="comTableTitle" id="left1" style="min-width:63px;">
			            	<nobr>更新日</nobr>
			            	<a class="<%=docKanaAscClass %>" href="" onclick="jimSort(0);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaDescClass %>" href="" onclick="jimSort(1);return false;">▼</a>
			            </td>
			            <td class="comTableTitle" id="left2" style="width:146pt;"><nobr>医師固定C</nobr></td>
			            <td class="comTableTitle" id="left3" style="min-width:80pt;"><nobr>氏名（漢字）</nobr></td>
			        　　　　　　　 <td class="comTableTitle" style="min-width:60pt;"><nobr>所属学会名称</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>入会年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>脱会年月日</nobr></td>
						<td class="comTableTitle" style="min-width:60pt;"><nobr>所属役職</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>役職開始年月日</nobr></td>
			           　　　　　　<td class="comTableTitle" style="min-width:60pt;"><nobr>役職終了年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>指導医取得年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>指導医開始年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>指導医終了年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>認定医開始年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>認定医終了年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>所属学会指導医区分</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>所属学会認定医区分</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>申請者所属</nobr></td>
			            <td class="comTableTitle" style="min-width:50pt;"><nobr>申請者氏名</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>承認者所属</nobr></td>
			            <td class="comTableTitle" style="min-width:50pt;"><nobr>承認者氏名</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>申請チャネル</nobr></td>
			            <td class="comTableTitle" style="min-width:80pt;">
			            	<nobr>申請ID</nobr>
			            	<a class="<%=docKanjAscClass %>" href="" onclick="jimSort(2);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanjDescClass %>" href="" onclick="jimSort(3);return false;">▼</a>
			            </td>

			        </tr>
			        <s:iterator value="hcpUpdHstDataList" status="status" var="rowBean">
				        <tr>
				        	<!-- 更新日 -->
							<td class="comTableItem" id="left1" style="z-index:2;" >
								<s:if test="%{#rowBean.updMstYmd == null || #rowBean.updMstYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].updMstYmd" />
					            </s:else>
							</td>
							<!-- 医師固定C -->
							<td class="comTableItem" id="left2" style="z-index:2;" >
								<s:if test="%{#rowBean.docNo == null || #rowBean.docNo == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].docNo" />
					            </s:else>
							</td>
							<!-- 氏名（漢字） -->
							<td class="comTableItem" id="left3" style="z-index:2;" >
								<s:if test="%{#rowBean.docKanj == null || #rowBean.docKanj == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
					            	<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.docKanjUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanj" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanj" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 所属学会名称-->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.medicalSocietyNm == null || #rowBean.medicalSocietyNm == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.medicalSocietyNmUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].medicalSocietyNm" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].medicalSocietyNm" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 入会年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.admissionYmd == null || #rowBean.admissionYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.admissionYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].admissionYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].admissionYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!--脱会年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.quitYmd == null || #rowBean.quitYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.quitYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].quitYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].quitYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 所属役職 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.positionCode == null || #rowBean.positionCode == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.positionCodeUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].positionCode" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].positionCode" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 役職開始年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.societyPosiStYmd == null || #rowBean.societyPosiStYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.societyPosiStYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].societyPosiStYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].societyPosiStYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 役職終了年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.societyPosiEdYmd == null || #rowBean.societyPosiEdYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.societyPosiEdYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].societyPosiEdYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].societyPosiEdYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 指導医取得年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.coachingAcquisiYmd == null || #rowBean.coachingAcquisiYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.coachingAcquisiYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].coachingAcquisiYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].coachingAcquisiYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 指導医開始年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.coachinStYmd == null || #rowBean.coachinStYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.coachinStYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].coachinStYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].coachinStYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 指導医終了年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.coachinEdYmd == null || #rowBean.coachinEdYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.coachingEdYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].coachinEdYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].coachinEdYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 認定医開始年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.certifyStYmd == null || #rowBean.certifyStYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.certifyStYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].certifyStYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].certifyStYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 認定医終了年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.certifyEdYmd == null || #rowBean.certifyEdYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.certifyEdYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].certifyEdYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].certifyEdYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 所属学会指導医区分 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.advisingDoctor == null || #rowBean.advisingDoctor == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.advisingDoctorUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].advisingDoctor" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].advisingDoctor" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 所属学会認定医区分 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.certifyingPhysician == null || #rowBean.certifyingPhysician == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.certifyingPhysicianUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].certifyingPhysician" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].certifyingPhysician" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 申請者所属 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqShz == null || #rowBean.reqShz == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqShz" />
					            </s:else>
							</td>
							<!-- 申請者氏名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqJgiName == null || #rowBean.reqJgiName == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqJgiName" />
					            </s:else>
							</td>
							<!-- 承認者所属 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.aprShz == null || #rowBean.aprShz == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].aprShz" />
					            </s:else>
							</td>
							<!-- 承認者氏名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.aprShaId == null || #rowBean.aprShaId == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].aprShaId" />
					            </s:else>
							</td>
							<!-- 申請チャネル -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqChl == null || #rowBean.reqChl == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqChl" />
					            </s:else>
							</td>
							<!-- 申請ID -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqId == null || #rowBean.reqId == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqId" />
					            </s:else>
							</td>
				        </tr>
				    </s:iterator>
				  </table>
				</div>
	    	</s:if>

	    	<s:if test="selectListChange == 3">
	    		<!-- 公的機関　検索結果 -->
		    	<div style="height: 370px; width: 1100px; overflow: scroll;">
		    	<table class="comTableTitle" id="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none;">
		    		<tr>
			            <td class="comTableTitle" id="left1" style="min-width:63px;">
			            	<nobr>更新日</nobr>
			            	<a class="<%=docKanaAscClass %>" href="" onclick="jimSort(0);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaDescClass %>" href="" onclick="jimSort(1);return false;">▼</a>
			            </td>
			            <td class="comTableTitle" id="left2" style="width:146pt;"><nobr>医師固定C</nobr></td>
			            <td class="comTableTitle" id="left3" style="min-width:80pt;"><nobr>氏名（漢字）</nobr></td>
			        　　　　　　　 <td class="comTableTitle" style="min-width:60pt;"><nobr>分類区分</nobr></td>
			            <td class="comTableTitle" style="min-width:120pt;"><nobr>公的機関</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>公的機関開始年月日</nobr></td>
						<td class="comTableTitle" style="min-width:60pt;"><nobr>公的機関終了年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>公的機関役職</nobr></td>
			           　　　　　　<td class="comTableTitle" style="min-width:60pt;"><nobr>公的機関役職開始年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>公的機関役職終了年月日</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>申請者所属</nobr></td>
			            <td class="comTableTitle" style="min-width:50pt;"><nobr>申請者氏名</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>承認者所属</nobr></td>
			            <td class="comTableTitle" style="min-width:50pt;"><nobr>承認者氏名</nobr></td>
			            <td class="comTableTitle" style="min-width:60pt;"><nobr>申請チャネル</nobr></td>
			            <td class="comTableTitle" style="min-width:80pt;">
			            	<nobr>申請ID</nobr>
			            	<a class="<%=docKanjAscClass %>" href="" onclick="jimSort(2);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanjDescClass %>" href="" onclick="jimSort(3);return false;">▼</a>
			            </td>

			        </tr>
			        <s:iterator value="hcpUpdHstDataList" status="status" var="rowBean">
				        <tr>
				        	<!-- 更新日 -->
							<td class="comTableItem" id="left1" style="z-index:2;" >
								<s:if test="%{#rowBean.updMstYmd == null || #rowBean.updMstYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].updMstYmd" />
					            </s:else>
							</td>
							<!-- 医師固定C -->
							<td class="comTableItem" id="left2" style="z-index:2;" >
								<s:if test="%{#rowBean.docNo == null || #rowBean.docNo == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].docNo" />
					            </s:else>
							</td>
							<!-- 氏名（漢字） -->
							<td class="comTableItem" id="left3" style="z-index:2;" >
								<s:if test="%{#rowBean.docKanj == null || #rowBean.docKanj == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
					            	<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.docKanjUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanj" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].docKanj" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 分類区分 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.classCateGory == null || #rowBean.classCateGory == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.classCateGoryUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].classCateGory" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].classCateGory" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 公的機関 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.pubInstitution == null || #rowBean.pubInstitution == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.pubInstitutionUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstitution" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstitution" />
					            	</s:else>
					            </s:else>
							</td>
							<!--公的機関開始年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.pubInstStYmd == null || #rowBean.pubInstStYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.pubInstStYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstStYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstStYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 公的機関終了年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.pubInstEdYmd == null || #rowBean.pubInstEdYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.pubInstEdYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstEdYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstEdYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 公的機関役職 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.pubInstPosition == null || #rowBean.pubInstPosition == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.pubInstPositionUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstPosition" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstPosition" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 公的機関役職開始年月日-->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.pubInstposStYmd == null || #rowBean.pubInstposStYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.pubInstposStYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstposStYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstposStYmd" />
					            	</s:else>
					            </s:else>
							</td>
							<!-- 公的機関役職終了年月日 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.pubInstposEdYmd == null || #rowBean.pubInstposEdYmd == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<!-- 更新がある場合 -->
					            	<s:if test="%{#rowBean.pubInstposEdYmdUpdFlg == 1}">
					            		<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstposEdYmd" style="color:red;"/>
					            	</s:if>
					            	<!-- 更新がない場合 -->
					            	<s:else>
										<s:label key="hcpUpdHstDataList[%{#status.index}].pubInstposEdYmd" />
					            	</s:else>
					            </s:else>
							</td>

							<!-- 申請者所属 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqShz == null || #rowBean.reqShz == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqShz" />
					            </s:else>
							</td>
							<!-- 申請者氏名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqJgiName == null || #rowBean.reqJgiName == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqJgiName" />
					            </s:else>
							</td>
							<!-- 承認者所属 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.aprShz == null || #rowBean.aprShz == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].aprShz" />
					            </s:else>
							</td>
							<!-- 承認者氏名 -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.aprShaId == null || #rowBean.aprShaId == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].aprShaId" />
					            </s:else>
							</td>
							<!-- 申請チャネル -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqChl == null || #rowBean.reqChl == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqChl" />
					            </s:else>
							</td>
							<!-- 申請ID -->
							<td class="comTableItem" id="left"  >
								<s:if test="%{#rowBean.reqId == null || #rowBean.reqId == ''}">
					            	<nobr>&nbsp;</nobr>
					            </s:if>
					            <s:else>
									<s:label key="hcpUpdHstDataList[%{#status.index}].reqId" />
					            </s:else>
							</td>
				        </tr>
				    </s:iterator>
				  </table>
				</div>
	    	</s:if>

	    </s:if>
    </table>

	<table>
		<tr>
		<!-- 検索ボタン -->
		<td>
			<input type="button" value="戻る" onclick="window.close();" />
		</td>
		</tr>
	</table>
	<script>
	//戻るボタン押下
	function NC001Page(){

		document.fm1.screenId.value	= "NC001";
	    document.fm1.functionId.value = "Init"

	 	comSubmitForAnyWarp(fm1);

	}
	</script>
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
