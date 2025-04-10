<%--
/**
 * <pre>
 *  医師勤務先情報更新のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author SBS  千葉
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND013DTO"%>
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
	<title>ND013_医師勤務先情報更新</title>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<link href="WebContent/css/common2.css" rel="Stylesheet" type="text/css" />
	<link href="css/popup.css" rel="Stylesheet" type="text/css" />
	<link href="css/catDeptsCombo.css" rel="Stylesheet" type="text/css" />
	<link href="css/common.css" rel="Stylesheet" type="text/css" />
	<link href="css/jkrMenu.css" rel="Stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jkrMenu.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/ND013.js"></script>
	<script type="text/javascript" src="js/catSosJgiExpand.js"></script>
	<script type="text/javascript" src="js/jgiKanren.js"></script>
	<script>
    function comSetFormWindowInfo(){
    	comClickFlgInit();
    	if(document.fm1.tabFlg != null){
    	const tabFlg = document.fm1.tabFlg.value;
    	const docNo = document.fm1.paramDocNo.value;
    	document.fm1.tabFlg.value = "X";
	 		if(tabFlg == "1"){//エラーなしなので遷移
	 			actBtn('ND103', docNo);
	 		}
	 		if(tabFlg == "2"){//エラーなしなので遷移
	 			actBtn('ND105', docNo);
	 		}
	 		if(tabFlg == "3"){//エラーなしなので遷移
	 			actBtn('ND104', docNo);
	 		}
	 		if(tabFlg == "4"){//エラーなしなので遷移
	 			document.fm1.movemedEditFlg.value = "1";
	 			actBtn('ND101', docNo);
	 		}
	 		if(tabFlg == "5"){//エラーなしなので遷移
	 			document.fm1.movemedEditFlg.value = "0";
	 			actBtn('ND101', docNo);
	 		}
	 		if(tabFlg == "6"){//エラーなしなので遷移
	 			actBtn('ND102', docNo);
	 		}
    	}
    }

 	var nd013Tab;
 	// アクションボタン
    function actBtn(screenId, docNo){
 		var tmpDoc = fm1.docNo.value;
		if(screenId == "ND105"){
			fm1.tkdDocNo.value = docNo;
		}else{
	 		fm1.paramDocNo.value = docNo;
	 		if(fm1.insNoKakusi != null){
	 			fm1.insNo.value = fm1.insNoKakusi.value;
	 			fm1.paramInsNo.value = fm1.insNoKakusi.value;
	 		}else{//勤務先追加
	 			fm1.insNo.value = "";
	 		}
		}

 		if(nd013Tab && !nd013Tab.closed){
 			nd013Tab.close();
 		}

 		nf001Tab = window.open("","ND013Tab");
		document.fm1.target="ND013Tab";

  		fm1.screenId.value=screenId;
	  	fm1.functionId.value="Init";
	  	comSubmitForAnyWarp(fm1);
	  	comClickFlgInit();
	}
    function backPage(){
	    if(window.confirm("画面を閉じます。よろしいですか？")){
			//この画面（タブ）を閉じる
			window.close();
	    }
    }
    </script>
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
		.comTableSearchItem {
			width: 20%;
			height: 55px;
		}

		TD.comTableTitle			/* テーブル形式のタイトル項目 */
			{
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
			}

			TD.comTableItem {
				color: #000000;
			    border-style: solid;
			    border-top-width: 0px;
			    border-left-width: 1px;
			    border-right-width: 1px;
			    border-bottom-width: 1px;
			    font-size: 8pt;
			    border-color: #f5f5f5;
			}


    </style>
</head>
<body class="comPage onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">


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
    <s:hidden name="msgStr" />
    <s:hidden name="dialog" />
    <s:hidden name="insNoKakusi" />
	<s:hidden name="errorCheckFlg" />
	<s:hidden name="errorBool" />
	<s:hidden name="tabFlg" />
	<s:hidden name="jokenSetCd" />
	<s:hidden name="docKanj" />
	<s:hidden name="docKana" />
	<s:hidden name="docNo" />
	<s:hidden name="paramDocNo" />
	<s:hidden name="tkdDocNo"/>
	<s:hidden name="insNo"/>
	<s:hidden name="paramInsNo" />
	<s:hidden name="movemedEditFlg"/>
	<s:hidden name="docType" />
    <s:hidden name="ultKanj" />
    <s:hidden name="ultKana" />
    <s:hidden name="delFlg" />
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
      <s:hidden name="screenId" value="ND013" />
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
      <s:hidden name="dummyHcoCount" />
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

		<!-- エラー表示部  開始 -->
		<table width="100%">
   		<tr>
             <td align="center">
               <jsp:include page="common/rdmMsg.jsp">
               <jsp:param name="" value="" />
               </jsp:include>
             </td>
         </tr>
      </table>
		<!-- エラー表示部  終了 -->
		<script>

		</script>

		<%-- 検索部 開始 --%>
     	<table class="pupList" style="margin-top:3pt;margin-bottom:1pt; background-color: white; width: 50%;">

	        <tr>
	            <%-- 武田医師名（漢字） --%>
		          <td class="comTableSearchItem" >
		          	<nobr>武田医師名（漢字）  </nobr>
		          </td>
		          <td ><s:property value="docKanj" /></td>

				<td class="comTableSearchItem" ></td>

	            <%-- 武田医師名（ｶﾅ） --%>
	            <td class="comTableSearchItem" >
	            	<nobr>武田医師名（ｶﾅ） </nobr>
	            </td>
	            <td style="width:100pt;"><s:property value="docKana"/></td>
	        </tr>
	        <tr>
	            <%-- 医師固定C --%>
		          <td class="comTableSearchItem" >
		          	<nobr>医師固定C </nobr>
		          </td>
		          <td ><s:property value="docNo" /></td>

		          <td class="comTableSearchItem" ></td>

	            <%-- 医師薬剤師区分 --%>
	            <td class="comTableSearchItem" >
	            	<nobr>医師薬剤師区分  </nobr>
	            </td>
	            <td><s:property value="docType"/></td>
	        </tr>
	        <tr>
	            <%-- ULT医師名（漢字） --%>
		          <td class="comTableSearchItem">
		          	<nobr>ULT医師名（漢字）  </nobr>
		          </td>
		          <td><s:property value="ultKanj"/></td>

		          <td class="comTableSearchItem" ></td>

	            <%-- ULT医師名（ｶﾅ） --%>
	            <td class="comTableSearchItem">
	            	<nobr>ULT医師名（ｶﾅ） </nobr>
	            </td>
	            <td><s:property value="ultKana" /></td>
	        </tr>
	        <tr>
	            <td><!-- 勤務先追加ボタン -->
	            	<s:if test="%{kinmuCount >= 2}">
	            		<!-- 表示 -->
	            		<s:if test="%{ishiNewKinmu != 0}">
	            			<!-- 活性 -->
	            			<input type="button" value="勤務先追加" onclick="errorCheck('1')">
	            		</s:if>
	            		<s:else>
	            			<!-- 非活性 -->
	            			<input type="button" value="勤務先追加" style="background-color: gray;" >
	            		</s:else>

		            </s:if>
		            <s:else>
		            	<!-- 非表示 -->
						<nobr>&nbsp;</nobr>
		            </s:else>

	            </td>
	        	<td></td>
	        	<td><!-- 医師の廃業・死亡ボタン -->
	        		<s:if test="%{ishiHaigyou != 0}">
	            			<!-- 活性 -->
	            			<input type="button" value="医師の廃業・死亡" onclick="errorCheck('2')">
	            		</s:if>
	            		<s:else>
	            			<!-- 非活性 -->
	            			<input type="button" value="医師の廃業・死亡" style="background-color: gray;">
	            		</s:else>
	        	</td>
	        	<td></td>
	        </tr>

	    </table>
	<%-- 検索部 終了 --%>

	<%-- ページ情報 --%>



	<CENTER>


	   	<div style="margin-top: 2%; height: 370px; width: 1100px;">


	   	  <table class="comTableTitle" id="comTableTitle" style=" border: none !important;text-align: center;" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none;">
	   		<tr>
	   			<td style="border: none !important;" colspan="4"></td>
	            <td style="border: none !important; width:146pt; text-align: left;"><nobr>勤務先一覧</nobr></td>
	            <td style="border: none !important;width:146pt;"><nobr></nobr></td>
	            <td style="border: none !important;width:200pt;"><nobr></nobr></td>
	        　　             <td style="border: none !important;width:200pt;"><nobr></nobr></td>
	            <td style="border: none !important;width:146pt;"><nobr></nobr></td>
	            <td style="border: none !important;width:146pt;"><nobr></nobr></td>
				<td style="border: none !important;width:146pt;"><nobr></nobr></td>
	            <td style="border: none !important;width:146pt;"><nobr></nobr></td>
	        </tr>
	   		<tr>
	   			<td class="comTableTitle" style="border: 0px none; background-color:white;" colspan="4">アクション</td>
	            <td class="comTableTitle" style="width:146pt;"><nobr>施設略式漢字名</nobr></td>
	            <td class="comTableTitle" style="width:146pt;"><nobr>対象区分</nobr></td>
	            <td class="comTableTitle" style="width:200pt;"><nobr>施設住所</nobr></td>
	        　　             <td class="comTableTitle" style="width:200pt;"><nobr>所属部科</nobr></td>
	            <td class="comTableTitle" style="width:146pt;"><nobr>役職</nobr></td>
	            <td class="comTableTitle" style="width:146pt;"><nobr>勤務形態</nobr></td>
				<td class="comTableTitle" style="width:146pt;"><nobr>大学職位</nobr></td>
	            <td class="comTableTitle" style="width:146pt;"><nobr>担当者(領域：所属)</nobr></td>
	        </tr>
	        <s:iterator value="hcpWorkData" status="status" var="rowBean">
		        <tr>
		        	<!-- アクションボタン -->
		        	<td class="comTableItem" id="left" style="width: 30px;">

		        		<!-- 医師勤務先削除 -->
		        		<!-- アクション削除が'1'かつ実勤務先判定がNULLではない勤務先情報の件数が2件以上の場合、表示 -->
						<s:if test="%{#rowBean.actionDel == 1 && dummyHcoCount >= 2}">
							<!-- 申請Aが'1'かつ申請Bが'1'の場合 活性 -->
		        			<s:if test="%{#rowBean.reqA == 1}">
			        			<s:if test="%{#rowBean.reqB == 1}">
			        				<!-- 活性 -->
			        				<span>
			        					<img src="img/button_delete.gif" onclick="errorCheckAction('3', this)" />
			        					<s:hidden name="hcpWorkData[%{#status.index}].insNoKakusi"/>
			        				</span>
			        			</s:if>
			        		</s:if>
		        			<s:else>
		        				<!-- 非活性 -->
		        				<span><img src="img/button_delete_off.gif"></span>
		        			</s:else>
		        		</s:if>
		        		<s:else>
		        			<nobr>&nbsp;</nobr>
		        		</s:else>
					</td>
					<td class="comTableItem" id="left" style="width: 30px;">
		        		<!-- 勤務先情報更新-->
		        		<!-- アクション編集が'1'かつ実勤務先判定がNULLではない勤務先情報の件数が2件以上の場合　表示 -->
		        		<!--アクション編集が'1'の場合,勤務先情報の件数が1件で隠し項目．実勤務先判定がNULLの場合 表示
		        		|| (#rowBean.actionEdit == 1　&& #rowBean.kinmuCount == 1 && #rowBean.dummyHco == null) -->
		        		<s:if test="%{#rowBean.actionEdit == 1}">
		        		<s:if test="%{dummyHcoCount >= 2}">
		        			<s:if test="%{#rowBean.reqA == 1}">
		        				<span><img src="img/button_update.gif" onclick="errorCheckAction('4', this)"></span>
		        			</s:if>
		        			<s:else>
		        				<span><img src="img/button_update_off.gif"></span>
		        			</s:else>
		        		</s:if>
		        		</s:if>
		        		<s:else>
		        			<nobr>&nbsp;</nobr>
		        		</s:else>
					</td>
					<td class="comTableItem" id="left" style="width: 30px;">
		        		<!-- 医療機関へ異動 -->
		        		<!-- アクション編集が'1'の場合　表示 -->
		        		<s:if test="%{#rowBean.actionEdit == 1}">
		        			<!-- 申請Aが'1'かつ申請Bが'1'の場合 活性 -->
		        			<s:if test="%{#rowBean.reqA == 1}">
		        				<s:if test="%{#rowBean.reqB == 1}">
		        					<span><img src="img/button_movemed.gif" onclick="errorCheckAction('5', this)"></span>
		        				</s:if>
		        			</s:if>
		        			<s:else>
		        				<span><img src="img/button_movemed_off.gif"></span>
		        			</s:else>
		        		</s:if>
		        		<s:else>
		        			<nobr>&nbsp;</nobr>
		        		</s:else>
					</td>
					<td class="comTableItem" id="left" style="width: 30px;">
		        		<!-- 医療機関外へ異動 -->
		        		<s:if test="%{#rowBean.actionEdit == 1 && #rowBean.kinmuCount == 1}">
	        			<!-- アクション編集が'1'かつ勤務先情報の件数が1件の場合　表示 -->
		        			<s:if test="%{#rowBean.reqA == 1}">
		        				<s:if test="%{#rowBean.reqB == 1}">
		        					<span><img src="img/button_moveoutmed.gif" onclick="errorCheckAction('6', this)"></span>
		        				</s:if>
		        			</s:if>

		        			<s:else>
		        			<!-- その他 -->
		        				<span><img src="img/button_moveoutmed_off.gif"></span>
		        			</s:else>
		        		</s:if>
		        		<s:else>
		        			<nobr>&nbsp;</nobr>
		        		</s:else>
					</td>

		        	<!-- 施設略式漢字名 -->
					<td class="comTableItem" id="left"  >
						<s:if test="%{#rowBean.insAbbrName == null || #rowBean.insAbbrName == ''}">
			            	<nobr>&nbsp;</nobr>
			            </s:if>
			            <s:else>
							<s:label key="hcpWorkData[%{#status.index}].insAbbrName" />
			            </s:else>
					</td>
					<!-- 対象区分 -->
					<td class="comTableItem" id="left"  >
						<s:if test="%{#rowBean.hoInsType == null || #rowBean.hoInsType == ''}">
			            	<nobr>&nbsp;</nobr>
			            </s:if>
			            <s:else>
							<s:label key="hcpWorkData[%{#status.index}].hoInsType" />
			            </s:else>
					</td>
					<!-- 施設住所 -->
					<td class="comTableItem" id="left"  >
						<s:if test="%{#rowBean.insAddr == null || #rowBean.insAddr == ''}">
			            	<nobr>&nbsp;</nobr>
			            </s:if>
			            <s:else>
							<s:label key="hcpWorkData[%{#status.index}].insAddr" />
			            </s:else>
					</td>
					<!-- 所属部科 -->
					<td class="comTableItem" id="left"  >
						<s:if test="%{#rowBean.deptKj == null || #rowBean.deptKj == ''}">
			            	<nobr>&nbsp;</nobr>
			            </s:if>
			            <s:else>
							<s:label key="hcpWorkData[%{#status.index}].deptKj" />
			            </s:else>
					</td>
					<!-- 役職 -->
					<td class="comTableItem" id="left"  >
						<s:if test="%{#rowBean.TitleKj == null || #rowBean.TitleKj == ''}">
			            	<nobr>&nbsp;</nobr>
			            </s:if>
			            <s:else>
							<s:label key="hcpWorkData[%{#status.index}].TitleKj" />
			            </s:else>
					</td>
					<!-- 勤務形態 -->
					<td class="comTableItem" id="left"  >
						<s:if test="%{#rowBean.jobForm == null || #rowBean.jobForm == ''}">
			            	<nobr>&nbsp;</nobr>
			            </s:if>
			            <s:else>
							<s:label key="hcpWorkData[%{#status.index}].jobForm" />
			            </s:else>
					</td>
					<!--大学職位 -->
					<td class="comTableItem" id="left"  >
						<s:if test="%{#rowBean.univTitle == null || #rowBean.univTitle == ''}">
			            	<nobr>&nbsp;</nobr>
			            </s:if>
			            <s:else>
						    <s:label key="hcpWorkData[%{#status.index}].univTitle" />
			            </s:else>
					</td>
					<!-- 担当者(領域：所属) -->
					<td class="comTableItem" id="left"  >
						<input type="button" value=" 施設担当者" onclick="cseViewND013(this);">
					</td>
					<!-- 施設固定C　隠し項目 -->
					<td style="display:none;">
						<s:label key="hcpWorkData[%{#status.index}].insNoKakusi" />
					</td>

		        </tr>
		    </s:iterator>
		  </table>
		</div>

    </table>



	</CENTER>

	<%-- メイン部 一覧 終了 --%>

	<%-- チェック済み表示欄 終了 --%>
    <hr class="comSplit" />
	<%--ヘッダー部　開始 --%>
	<table>

		<td>
			<input type="button" value="戻る" onclick="backPage();" />
		</td>

	</table>

	<%--ヘッダー部　終了 --%>

	<%-- ポータルボディー 終了 --%>
  </s:form>
<%-- input用フォーム 終了 --%>
</body>
</html>
