<%--
/**
 * <pre>
 *  医師勤務先情報一括更新 - 申請内容確認のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author SBS  千葉
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND401DTO"%>
<%@page import="jp.co.takeda.rdm.dto.ND403DTO"%>
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
	<title>ND403_医師勤務先情報一括更新 - 申請内容確認</title>

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

	// 戻るボタン
	function backBtn(){
		//２度押し対策フラグ初期化
		comClickFlgInit();

		var destructMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';
		if(window.confirm(destructMsg.replace("（遷移元）", '医師勤務先情報一括更新'))){
			// ND401_医師勤務先情報一括更新に遷移
			document.fm1.screenId.value="ND401";
			document.fm1.functionId.value="Search";

			comSubmitForAnyWarp(fm1);
	    }
	}

	// 画面遷移処理
    function gotoNext(screenId,functionId){
   		document.fm1.target="";
  	 	fm1.screenId.value=screenId;
  	  	fm1.functionId.value=functionId;
  	  	comSubmitForAnyWarp(fm1);
  	}

	/**
	 * <pre>
	 *  申請画面遷移
	 * 申請画面へ(ボタン)押下時に呼ばれます。
	 * </pre>
	 */
	function goNC101() {
		//現在ページ番号変更（遷移）
	    document.fm1.pageCntCur.value = 1;

	    document.fm1.functionId.value = "Register"
		document.fm1.screenId.value	= "ND403";

	    // 検索イベント呼び出し
	    comSubmitForAnyWarp(fm1);
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
      <s:hidden name="clearUpdMstFrom" />
      <s:hidden name="clearUpdMstTo" />

      <s:hidden name="kensakuSosCd" />
      <s:hidden name="kensakuSosName" />
      <s:hidden name="kensakuUpSosCd" />
      <s:hidden name="kensakuBumonRank" />
      <s:hidden name="kensakuJgiName" />
      <s:hidden name="kensakuDeptKj" />
      <s:hidden name="kensakuDeptCode" />
      <s:hidden name="kensakuInsKanj" />
      <s:hidden name="kensakuInsNo" />
      <s:hidden name="kensakuDocKanj" />
      <s:hidden name="kensakuDocNo" />
      <s:hidden name="loginJokenSetCd" />

	<s:hidden name="reqBtnFlg" />
      <s:hidden name="deptCodeHenkou" />
      <s:hidden name="deptKnHenkou" />

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
		<center/>
		<!-- エラー表示部  終了 -->

	    	<div style="max-height:300px;width:1250px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
	    	<table class="comTableTitle" id="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none; margin-top:3pt;margin-bottom:1pt;">
	    		<thead>
		        <tr>
		            <td class="comTableTitle" id="1" style="width:146pt;"rowspan=2><nobr>施設固定C</nobr></td>
		            <td class="comTableTitle" id="2" style="width:146pt;"rowspan=2><nobr>施設名</nobr></td>
		            <td class="comTableTitle" id="3" style="width:146pt;"rowspan=2><nobr>医師固定C</nobr></td>
		            <td class="comTableTitle" id="4" style="width:146pt;"rowspan=2><nobr>医師名</nobr></td>
		            <td class="comTableTitle" id="5" style="width:146pt;"colspan=2><nobr>役職</nobr></td>
		            <td class="comTableTitle" id="6" style="width:146pt;"colspan=2><nobr>所属部科</nobr></td>
		        </tr>
		        <tr>
		            <td class="comTableTitle" id="7" style="width:146pt; top: 18;"><nobr>役職（変更前）</nobr></td>
		            <td class="comTableTitle" id="8" style="width:146pt; top: 18;"><nobr>役職（変更後）</nobr></td>
		            <td class="comTableTitle" id="9" style="width:146pt; top: 18;"><nobr>所属部科（変更前）</nobr></td>
		            <td class="comTableTitle" id="10" style="width:146pt; top: 18;"><nobr>所属部科（変更後）</nobr></td>
		        </tr>
		        </thead>
			    <%-- 内容 --%>
			    <tbody>
			    <s:iterator value="kmuIkkatsuDataList" status="status" var="rowBean">
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].insNo"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].insAbbrName"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].docNo"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].docKanj"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preTitleKj"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].postTitleKj"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preDeptKanji"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].postDeptKanji"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preTitleCode"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].postTitleCode"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preDeptCode"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].postDeptCode"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].preDeptKana"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].postDeptKana"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].jobForm"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].univPosCode"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].dcc"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].ultInsNo"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].ultDocNo"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].sortNum1"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].sortNum2"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].sortNum3"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].sortNum"/>
							<s:hidden name="kmuIkkatsuDataList[%{#status.index}].updShaYmd"/>
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
				            	<s:if test="%{#rowBean.preTitleKj != #rowBean.postTitleKj}">
		            				<s:label key="kmuIkkatsuDataList[%{#status.index}].preTitleKj" />
		            			</s:if>
		            			<s:else>
		            				<nobr>&nbsp;</nobr>
		            			</s:else>
				            </s:else>
						</td>

						<!-- 役職（変更後） -->
						<td class="comTableItem" id=""  >
				            	<s:if test="%{#rowBean.preTitleKj != #rowBean.postTitleKj}">
		            				<font color="red"><s:label key="kmuIkkatsuDataList[%{#status.index}].postTitleKj" /></font>
		            			</s:if>
		            			<s:else>
		            				<nobr>&nbsp;</nobr>
		            			</s:else>
						</td>

						<!--所属部科（変更前）   -->
						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.preDeptKanji == null || #rowBean.preDeptKanji == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<s:if test="%{#rowBean.preDeptKanji != #rowBean.postDeptKanji}">
		            				<s:label key="kmuIkkatsuDataList[%{#status.index}].preDeptKanji" />
		            			</s:if>
		            			<s:else>
		            				<nobr>&nbsp;</nobr>
		            			</s:else>
				            </s:else>
						</td>

						<!-- 所属部科（変更後） -->

						<td class="comTableItem" id=""  >
							<s:if test="%{#rowBean.postDeptKanji == null || #rowBean.postDeptKanji == ''}">
				            	<nobr>&nbsp;</nobr>
				            </s:if>
				            <s:else>
				            	<s:if test="%{#rowBean.preDeptKanji != #rowBean.postDeptKanji}">
		            				<font color="red"><s:label key="kmuIkkatsuDataList[%{#status.index}].postDeptKanji" /></font>
		            			</s:if>
		            			<s:else>
		            				<nobr>&nbsp;</nobr>
		            			</s:else>
				            </s:else>
						</td>
						<!-- ULT施設コード　隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].ultInsNo" />
						</td>
						<!-- ULT医師コード　隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].ultDocNo" />
						</td>
						<!--役職コード（変更前） 　隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}]." />
						</td>
						<!-- 役職コード（変更後）　隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}]." />
						</td>
						<!-- 所属部科カナ（変更前）　隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].preDeptKana" />
						</td>
						<!-- 所属部科カナ（変更後） 隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].postDeptKana" />
						</td>
						<!-- 所属部科コード（変更前） 隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].preDeptCode" />
						</td>
						<!-- 所属部科コード（変更後）　隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].postDeptCode" />
						</td>
						<!-- 勤務形態(変更前) 隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].jobForm" />
						</td>
						<!-- 大学職位コード 隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].univPosCode" />
						</td>
						<!-- 薬審メンバー区分(変更前) 隠し項目 -->
						<td style="display:none;">
							<s:label key="kmuIkkatsuDataList[%{#status.index}].dcc" />
						</td>
			        </tr>

			    </s:iterator>
			    </tbody>
				</table>

			    </div>

          <table class="comPortalTable" align="center">
              <tr>
                  <td>申請コメント</td>
              </tr>
          </table>
          <table class="comPortalTable" align="center">
              <tr>
                  <td>
                          <s:textarea label="ReqComment" name="reqComment" style="width: 60vw; resize: none;" maxlength="100" rows="3"/>
                  </td>
              </tr>
          </table>

         <div style="display: flex; justify-content: space-between;">
       		<div style="margin-top: 3%;margin-left: 10%;">
       			<input type="button" value="戻る" onclick="backBtn();" />
       		</div>

       		<div style="margin-top: 3%;margin-right: 10%;">
       			<s:if test="reqBtnFlg == 1 ">
       				<input type="button" value="申請" onclick="goNC101();"  />
       			</s:if>
       			<s:else>
       				<input type="button" value="申請" onclick="" disabled />
       			</s:else>
       		</div>
         </div>
  </s:form>

  </td>
    </tr>
    </table>
<%-- input用フォーム 終了 --%>
<jsp:include page="common/jkrBottom.jsp" flush="true" />
<%-- input用フォーム 終了 --%>
</body>
</html>
