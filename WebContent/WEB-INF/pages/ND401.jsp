<%--
/**
 * <pre>
 *  医師勤務先情報一括更新のJSP
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
	<title>ND401_医師勤務先情報一括更新</title>

	<link href="WebContent/css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
	<link href="css/popup.css" rel="Stylesheet" type="text/css" />
	<link href="css/catDeptsCombo.css" rel="Stylesheet" type="text/css" />
	<link href="css/common.css" rel="Stylesheet" type="text/css" />
	<link href="css/jkrMenu.css" rel="Stylesheet" type="text/css" />
	<script>
    function comSetFormWindowInfo(){
    	comClickFlgInit();

    	// ★ボタン、←ボタン制御
    	var i = 0;
    	var henkouBtn = document.getElementsByName("cseHenkouBtn")[i];
    	var backBtn = document.getElementsByName("cseBackBtn")[i];
    	while(henkouBtn != undefined){
    		var deptBtnFlg = "kmuIkkatsuDataList[" + i + "].deptBtnFlg";
    	    if(document.getElementsByName(deptBtnFlg)[0].value == "1"){
    	    	//★へ変更ボタン非表示
    	    	henkouBtn.style.display = 'none';
    	    	//戻すボタン表示
    	    	backBtn.style.display = 'block';
    	    } else {
    	    	//★へ変更ボタン表示
    	    	henkouBtn.style.display = 'block';

    	    	//戻すボタン非表示
    	    	backBtn.style.display = 'none';
    	    }

    		i++;
    		henkouBtn = document.getElementsByName("cseHenkouBtn")[i];
    		backBtn = document.getElementsByName("cseBackBtn")[i];
    	}
    }
    </script>
	<script type="text/javascript" src="js/ND401.js"></script>
	<script type="text/javascript" src="js/catTkCityCombo.js"></script>
    <script type="text/javascript" src="js/imtInsInputCategores.js"></script>
    <script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/rdmCatSosExpand.js"></script>
    <script type="text/javascript" src="js/catDeptsComboRDM.js"></script>
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
			max-height: 370px;
			width: 1100px;
			overflow: auto;
			-webkit-overflow-scrolling: touch;
		}

		/*検索結果テーブル*/
		.kensakuDate table {
			border-collapse: collapse;
		  border-spacing: 0;
		  width: 100%;
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
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">
<%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />


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
<%-- input用フォーム 開始 --%>
  <s:form name="fm1" theme="simple">
	<%-- 常に配列にするためにダミーを配置 --%>
    <s:hidden name="callBack" />
	<s:hidden name="sortId" />
	<s:hidden name="jokenSetCd" />
	<s:hidden name="kensakuReqBrCode" />
	<s:hidden name="kensakuDistCode" />
	<s:hidden name="kensakuBrCode" />
	<s:hidden name="kensakuTrtCd" />
    <s:hidden name="kensakuSosCd" />
    <s:hidden name="kensakuUpSosCd" />
    <s:hidden name="kensakuBumonRank" />
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
      <s:hidden name="screenId" value="ND401" />
      <s:hidden name="functionId"/>
      <s:hidden name="buttonFlg" />
      <s:hidden name="gamenId"/>
      <s:hidden id="pageFlag" name="pageFlag" />
      <s:hidden name="listName" />
      <s:hidden name="poprowno" />
      <s:hidden name="poptrtno" />
	  <s:hidden name="backScreenId" value="ND401"/>

      <s:hidden name="mrJgiNo" />
      <s:hidden name="mrBrCode" />
      <s:hidden name="mrDistCode" />
      <s:hidden name="mrTrtCd" />

      <s:hidden name="cdcCheckedCodes" />
	　　<s:hidden name="paramInsNo" />

      <s:hidden name="kensakuTantouDistCode" />
      <s:hidden name="kensakuSTantouBrCode" />
      <s:hidden name="kensakuShinseiDistCode" />
      <s:hidden name="kensakuShinseiBrCode" />
      <s:hidden name="kensakuDeptCode" />
      <s:hidden name="clearUpdMstFrom" />
      <s:hidden name="clearUpdMstTo" />

      <s:hidden name="deptCodeHenkou" />
      <s:hidden name="deptKnHenkou" />
      <s:hidden name="kmuIkkatsuData" />

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

      <s:hidden name="loginJokenSetCd"/>
     <s:hidden name="loginJgiNo"/>
     <s:hidden name="loginNm"/>
     <s:hidden name="loginShzNm"/>
     <s:hidden name="loginTrtCd"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>
     <s:hidden name="reqBtnFlg" />

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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="医師勤務先情報一括更新"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>
<%-- ポータルタイトル 終了 --%>

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

		<%-- 検索部 開始 --%>
     	<table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
     	<s:form action="NF501Search" theme="simple" name="fm1" >
	        <tr>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>組織
	      <s:if test='%{loginJokenSetCd == "JKN0850"}'>
		          		<input id="sosButton1" class="comButton" type="button" value="選択" onClick="henkouSos();" />
		          	</s:if>
		          	<s:else>
		          		<input id="sosButton1" class="comButton" type="button" value="選択" onClick="" disabled />
		          	</s:else>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:textfield id="KensakuSosName" name="kensakuSosName" size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true" />
		          		<s:if test='%{loginJokenSetCd == "JKN0850"}'>
		          			&nbsp;<a href="#" class="comMiniLink" onClick="sosClear();return false;">Clear</a>
		          		</s:if>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>担当者
	      <s:if test='%{loginJokenSetCd == "JKN0850"}'>
		         		<input id="sosButton1" class="comButton" type="button" value="選択" onClick="henkouTanto();" />
					</s:if>
					<s:else>
						<input id="sosButton1" class="comButton" type="button" value="選択" onClick="" disabled />
					</s:else>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:textfield id="kensakuJgiName" name="kensakuJgiName"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  />
		          		<s:if test='%{loginJokenSetCd == "JKN0850"}'>
			          		&nbsp;<a href="#" class="comMiniLink" onClick="tantoClear();return false;">Clear</a>
			          	</s:if>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>所属部科
	      	<input id="sosButton1" class="comButton" type="button" value="選択" onClick="hekouShozoku(1);" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:textfield id="kensakuDeptKj" name="kensakuDeptKj" size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true" />
         		&nbsp;
        		<a href="#" class="comMiniLink" onClick="deptClear();return false;">Clear</a>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>施設名</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:textfield id="kensakuInsKanj"  name="kensakuInsKanj" size="20" maxlength="128" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>施設固定C</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:textfield id="kensakuInsNo"  name="kensakuInsNo" size="20" maxlength="128" />
	      </nobr></td>
	      <td class="comFormTableItem">&nbsp;</td>
	      <td class="comFormTableItem">&nbsp;</td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医師名</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:textfield id="kensakuDocKanj"  name="kensakuDocKanj" size="20" maxlength="128" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>医師固定C</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:textfield id="kensakuDocNo"  name="kensakuDocNo" size="20" maxlength="128" />
	      </nobr></td>
	      <td class="comFormTableItem" colspan="2">
	      <nobr>
	      	<input type="button" name="search" value="検索" onclick="jimSearch();">
	      	<input type="button" value="クリア" class="comMiniLink" onclick="clearAll()">
	      </nobr>
	      </td>
      </tr>
       </s:form>
	</table>
		<%-- 検索部 終了 --%>
		<hr>
		<s:if test="searchType == 1 ">
			<div style="display: flex; justify-content: flex-end;">
				<div style="margin-right: 40px;">
					<input id="sosButton1" class="comButton" type="button" value="★選択" onClick="hekouShozoku(2);" />

		          		<s:textfield id="deptKjHenkou" name="deptKjHenkou"  size="40" maxlength="40" cssStyle="width: 176px;" cssClass="mediumGray" readonly="true"  />
		          		&nbsp;<a href="" class="comMiniLink" onClick="deptKjHenkouClear();return false;">Clear</a>
				</div>
			</div>
		</s:if>

	<%-- ページ情報 --%>
	<CENTER>
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

	    <%-- 項目 --%>
	    <s:if test="searchType == 1 ">

	    	<div class="kensakuDate">
	    	<table class="comTableTitle" id="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none;">
	    		<thead>
		        <tr>
		            <td class="comTableTitle" id="1" style="width:146pt;"><nobr>施設固定C</nobr></td>
		            <td class="comTableTitle" id="2" style="width:146pt;"><nobr>施設名</nobr></td>
		            <td class="comTableTitle" id="3" style="width:146pt;"><nobr>医師固定C</nobr></td>
		            <td class="comTableTitle" id="5" style="width:146pt;"><nobr>医師名</nobr></td>
		            <td class="comTableTitle" id="6" style="width:146pt;"><nobr>役職（変更前）</nobr></td>
		            <td class="comTableTitle" id="7" style="width:146pt;"><nobr>役職（変更後）</nobr></td>
		            <td class="comTableTitle" id="8" style="width:146pt;"><nobr>所属部科（変更前）</nobr></td>
		            <td colspan="3" class="comTableTitle" id="8" style="width:146pt;"><nobr>所属部科（変更後）</nobr></td>
		        </tr>
		        </thead>
			    <%-- 内容 --%>
			    <tbody>
			    <s:iterator value="kmuIkkatsuDataList" status="status" var="rowBean">
			        <tr>

						<!-- 施設固定C -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.insNo == null || #rowBean.insNo == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<s:hidden name="kmuIkkatsuDataList[%{#status.index}].insNo" />
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].insNo" />
				            </s:else>
						</td>

						<!-- 施設名 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.insAbbrName == null || #rowBean.insAbbrName == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
								<s:hidden name="kmuIkkatsuDataList[%{#status.index}].insAbbrName" />
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].insAbbrName" />
				            </s:else>
						</td>

						<!-- 医師固定C -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.docNo == null || #rowBean.docNo == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].docNo" />
		            			<s:hidden name="kmuIkkatsuDataList[%{#status.index}].docNo" />
				            </s:else>
						</td>

						<!-- 医師名 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.docKanj == null || #rowBean.docKanj == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].docKanj" />
		            			<s:hidden name="kmuIkkatsuDataList[%{#status.index}].docKanj" />
				            </s:else>
						</td>

						<!-- 役職（変更前） -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.preTitleKj == null || #rowBean.preTitleKj == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].preTitleKj" />
		            			<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preTitleKj" />
				            </s:else>
						</td>

						<!-- 役職（変更後） -->
						<td class="comTableItem" id=""  >
							<s:select id="kensakuHoInsType" name="kmuIkkatsuDataList[%{#status.index}].postTitleCode" cssStyle="width:80pt" list ="titleMap" />
						</td>

						<!--所属部科（変更前）   -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.preDeptKanji == null || #rowBean.preDeptKanji == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].preDeptKanji" />
		            			<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preDeptKanji" />
				            </s:else>
						</td>

						<!-- 所属部科（変更後） -->
						<td><input type="button" name="cseHenkouBtn" value="★" onclick="cseHenkouViewND401(this, '<s:property value="%{#status.index}"/>');" disabled/></td>
						<td><input type="button" name="cseBackBtn" value="←" onclick="deptBack(this, '<s:property value="%{#status.index}"/>');" style="display:none;"></td>
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.postDeptKanji == null || #rowBean.postDeptKanji == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].postDeptKanji" />
				            </s:else>
						</td>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].postDeptKanji" />
						<!-- ULT施設コード　隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].ultInsNo" />
						<!-- ULT医師コード　隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].ultDocNo" />
						<!--役職コード（変更前） 　隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preTitleCode" />
						<!-- 所属部科カナ（変更前）　隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preDeptKana" />
						<!-- 所属部科カナ（変更後） 隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].postDeptKana" />
						<!-- 所属部科コード（変更前） 隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preDeptCode" />
						<!-- 所属部科コード（変更後）　隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].postDeptCode" />
						<!-- 勤務形態(変更前) 隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].jobForm" />
						<!-- 大学職位コード 隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].univPosCode" />
						<!-- 薬審メンバー区分(変更前) 隠し項目 -->
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].dcc" />
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].deptBtnFlg" />
			        </tr>

			    </s:iterator>
			    </tbody>
				</table>

			    </div>
	    </s:if>

         <div style="display: flex; justify-content: space-between;">
       		<div style="margin-top: 3%;margin-left: 10%;">
       			<input type="button" value="戻る" onclick="window.close();" />
       		</div>

       		<div style="margin-top: 3%;margin-right: 10%;">
       			<s:if test="searchType == 1 ">
       				<s:if test="reqBtnFlg == 1 ">
       					<input type="button" value="申請画面へ" onclick="goND403();"  />
       				</s:if>
       				<s:else>
       					<input type="button" value="申請画面へ" onclick="" disabled />
       				</s:else>
       			</s:if>
         </div>
    </table>



	</CENTER>

	<%-- メイン部 一覧 終了 --%>

	<%-- チェック済み表示欄 終了 --%>
	<%--ヘッダー部　開始 --%>





	</table>

	 </tr>
          </tbody>
          </table>
  </s:form>

  </td>
    </tr>
    </table>
<%-- input用フォーム 終了 --%>
</tbody>
</td>
</tr>
</table>

<jsp:include page="common/jkrBottom.jsp" flush="true" />
<%-- input用フォーム 終了 --%>
</body>
</html>
