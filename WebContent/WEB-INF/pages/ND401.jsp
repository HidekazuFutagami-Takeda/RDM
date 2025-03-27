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
	<title>NF501_施設変更履歴</title>

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
    }
    </script>
	<script type="text/javascript" src="js/ND401.js"></script>
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
			width: 1400px;
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
	  <s:hidden name="backScreenId" />

      <s:hidden name="mrJgiNo" />
      <s:hidden name="mrBrCode" />
      <s:hidden name="mrDistCode" />
      <s:hidden name="mrTrtCd" />

      <s:hidden name="kensakuTantouDistCode" />
      <s:hidden name="kensakuSTantouBrCode" />
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


<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設新規作成"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>
<%-- ポータルタイトル 終了 --%>
		<!-- エラー表示部  開始 -->
		<center>
		<table id="formTable00" border="0" cellpadding="2" cellspacing="0" width="600px">
			<tbody>
				<s:if test="msgStr != null">
					<tr>
						<td style="height: 80px; text-align: center;">
							<nobr style="color: red; font-size: 15px;">
								<s:property value="msgStr.replaceAll('\\n', '<br />')" escape="false"/>
							</nobr>
						</td>
					</tr>
				</s:if>
			</tbody>
		</table>
		<center/>
		<!-- エラー表示部  終了 -->

		<script>

		</script>
		<center/>
		<!-- エラー表示部  終了 -->
		<script>
		const jgiNameUser = document.getElementById('jgiNameUser');
		jgiNameUser.disabled = true;

		const sosNameUser = document.getElementById('sosNameUser');
		sosNameUser.disabled = true;

		const kensakuReqDistUser = document.getElementById('kensakuReqDistUser');
		kensakuReqDistUser.disabled = true;

		const kensakuReqJgiNameUser = document.getElementById('kensakuReqJgiNameUser');
		kensakuReqJgiNameUser.disabled = true;
		</script>

		<%-- 検索部 開始 --%>
     	<table class="pupList" style="border-collapse: separate; margin-top:3pt; background-color: white;">

     	<s:form action="NF501Search" theme="simple" name="fm1" >
	        <tr>
	        	 <%-- 組織  --%>
		          	<td class="comTableSearchItem" style="width:50pt;">
		          		<nobr>組織 </nobr>
		          	</td>
		          	<td style="width: 35px;">
		          		<input id="sosButton1" class="comButton" type="button" value="選択" onClick="" />
		          	</td>
		          	<td>
		          		<s:textfield id="jgiName" name="jgiName" size="40" maxlength="40" cssStyle="width: 176px; background-color:#D4D0C8;" readonly="true" />
		          		&nbsp;<a href="" class="comMiniLink" onClick=";return false;">clear</a>
		          	</td>

	            <%-- 担当者 --%>
		          	<td class="comTableSearchItem" style="width:50pt;">
		         	 	<nobr>担当者</nobr>
		         	</td>
		         	<td style="width: 35px;"><input id="sosButton1" class="comButton" type="button" value="選択" onClick="" /></td>
		          	<td>
		          		<s:textfield id="sosNameUser" name="sosName"  size="40" maxlength="40" cssStyle="background-color:#D4D0C8; width: 176px;" readonly="true"  />
		          		<span>clear</span>
		          	</td>

	             <%-- 所属部科 --%>
		          	<td class="comTableSearchItem" style="width:50pt;">
		          		<nobr>所属部科 </nobr>
		          	</td>

		          	<td style="width: 35px;">
		          		<input id="sosButton1" class="comButton" type="button" value="選択" onClick="" />
		          	</td>
		          	<td>
		          		<s:textfield id="jgiName" name="jgiName" size="40" maxlength="40" cssStyle="width: 176px; background-color:#D4D0C8;" readonly="true" />
		          		&nbsp;<a href="" class="comMiniLink" onClick=";return false;">clear</a>
		          	</td>

		          	<td>
		          		<%-- 表示リセット --%>
	               		 <input type="button" value="クリア" class="comMiniLink" onclick="clearText()">
		          	</td>
	        </tr>

	        <tr>
	           <%-- 施設名 --%>
	            <td class="comTableSearchItem" style="width:50pt;">
	            	<nobr>施設名 </nobr>
	            </td>
	            <td><nobr></nobr></td>
	            <td><s:textfield id="kensakuInsKanj"  name="kensakuInsKanj" size="20" maxlength="128" /></td>
	           <%-- 施設固定C --%>
	            <td class="comTableSearchItem" style="width:50pt;">
	            	<nobr>施設固定C </nobr>
	            </td>
	            <td><nobr></nobr></td>
	            <td><s:textfield id="kensakuInsNo"  name="kensakuInsNo" size="20" maxlength="128" /></td>

	            <td></td>
	            <td></td>
	            <td></td>
	            <td>
	            	<!-- 検索ボタン -->
	                <input type="button" name="search" value="検索" onclick="jimSearch();">
	            </td>
	        </tr>

	        <tr>
	           <%-- 医師名 --%>
	            <td class="comTableSearchItem" style="width:50pt;">
	            	<nobr>医師名</nobr>
	            </td>
	            <td><nobr></nobr></td>
	            <td><s:textfield id="kensakuDocKanj"  name="kensakuDocKanj" size="20" maxlength="128" /></td>
	           <%-- 医師固定C --%>
	            <td class="comTableSearchItem" style="width:50pt;">
	            	<nobr>医師固定C </nobr>
	            </td>
	            <td><nobr></nobr></td>
	            <td><s:textfield id="kensakuDocNo"  name="kensakuDocNo" size="20" maxlength="128" /></td>

	            <td></td>
	            <td></td>
	            <td></td>
	        </tr>
	        <tr>
	           <%-- 医師名 --%>
	            <td class="comTableSearchItem" style="border-bottom: 2px solid #000;">
	            </td>
	            <td style="border-bottom: 2px solid #000;"></td>
	            <td style="border-bottom: 2px solid #000;"></td>
	            <td class="comTableSearchItem" style="border-bottom: 2px solid #000;">
	            </td>
	            <td style="border-bottom: 2px solid #000;"></td>
	            <td style="border-bottom: 2px solid #000;"></td>
	            <td style="border-bottom: 2px solid #000;"></td>
	            <td style="border-bottom: 2px solid #000;"></td>
	            <td style="border-bottom: 2px solid #000;"></td>
	        </tr>

	        </s:form>
	        <s:if test="searchType == 1 ">
	        <tr>
	            <td></td>
	            <td></td>
	            <td></td>
	            <td></td>
	            <td></td>
	            <td></td>
	            <%-- ★選択 --%>
	          	<td></td>
	         	<td style="width: 35px;"><input id="sosButton1" class="comButton" type="button" value="★選択" onClick="hekouShozoku();" /></td>
	          	<td>
	          		<s:textfield id="" name=""  size="40" maxlength="40" cssStyle="background-color:#D4D0C8; width: 176px;" readonly="true"  />
	          		<span>clear</span>
	          	</td>
	        </tr>
	        </s:if>


	    </table>
	<%-- 検索部 終了 --%>


	<%-- ページ情報 --%>
	<CENTER>
		 <%-- ページャー表示 開始 --%>
                 <!-- 改ページ -->
                 <s:if test="searchType == 1 ">
                  <table width="95%" style="text-align: center;" >
                      <tbody>
                      <tr>
                          <td>
                            <!-- 前頁リンク -->
                            <s:if test="pageCntCur > 1">
                            <nobr>
                                <a class="comMiniLink" href = "" onClick="pltPage(<s:property value="pageCntCur-1"/>);return false;">
                                &lt;&lt; 前
                                </a>&nbsp;
                            </nobr>
                            </s:if>

                            <!-- ページ基準の前頁リンク -->
                            <s:if test="pageCntBase > 1">
                              <a class="comMiniLink"  href="" style="" onClick="pltPage(<s:property value="pageCntBase-1"/>);return false;">
                              <nobr>～<s:property value="pageCntBase-1"/></nobr></a>
                            </s:if>

                            <!-- 各ページリンク作成 -->
                            <s:if test="pageCntAll > 1">
                              <s:iterator value="{'0',1,'2','3','4','5','6','7','8','9'}" var="pageIndex" status="status">
                                <s:set var="pageCntCurTemp" value="#status.index + pageCntBase" />
                                <s:if test="#pageCntCurTemp <= pageCntAll">
                                  <s:if test="#pageCntCurTemp != pageCntCur">
                                    <a  class="comMiniLink"  href="" style="" onClick="pltPage(<s:property value="#pageCntCurTemp"/>);return false;">
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
                                <a  class="comMiniLink"  href="" style="" onClick="pltPage(<s:property value="#pageCntCurTemp-1"/>);return false;">
                                <nobr><s:property value="pageCntBase + 10"/>～</nobr></a>
                            </s:if>

                            <!-- 次頁  -->
                            <s:if test="pageCntCur < pageCntAll">
                              <nobr>&nbsp;
                                <a class="comMiniLink" href = "" onClick="pltPage(<s:property value="pageCntCur+1"/>);return false;">
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
                 </s:if>
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
					<td></td>
					<td></td>
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
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].insNo" />
				            </s:else>
						</td>

						<!-- 施設名 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.insAbbrName == null || #rowBean.insAbbrName == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
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
				            </s:else>
						</td>

						<!-- 医師名 -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.docKanj == null || #rowBean.docKanj == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].docKanj" />
				            </s:else>
						</td>

						<!-- 役職（変更前） -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.preTitleKj == null || #rowBean.preTitleKj == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].preTitleKj" />
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
				            </s:else>
						</td>

						<!-- 所属部科（変更後） -->
						<td><input type="button" name="search" value="★へ変更" onclick=""></td>
						<td><input type="button" name="search" value="戻す" onclick=""></td>
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.postDeptKanji == null || #rowBean.postDeptKanji == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
		            			<s:label key="kmuIkkatsuDataList[%{#status.index}].postDeptKanji" />
				            </s:else>
						</td>

			        </tr>

			    </s:iterator>
			    </tbody>
				</table>

			    </div>
	    </s:if>
    </table>



	</CENTER>

	<%-- メイン部 一覧 終了 --%>

	<%-- チェック済み表示欄 終了 --%>
    <hr class="comSplit" />
	<%--ヘッダー部　開始 --%>
	<table>
		<!-- 検索ボタン -->
		<td>
			<input type="button" value="戻る" onclick="" />
		</td>

	</table>

	 </tr>
          </tbody>
          </table>
  </s:form>

  </td>
    </tr>
    </table>
<%-- input用フォーム 終了 --%>
<jsp:include page="common/jkrBottom.jsp" flush="true" />
<%-- input用フォーム 終了 --%>
</body>
</html>
