<%--
/**
 * <pre>
 *  医師検索のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author SBS 内海
 * @see
 */
--%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND001DTO"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="java.util.Enumeration"%>
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
String title = (String)request.getAttribute("title");
String execDate = (String)request.getAttribute("execDate");
ValueStack stack = (ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
ND001DTO dto = new ND001DTO();
if (stack.peek() instanceof ND001DTO) {
   dto = (ND001DTO)stack.peek();
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>施設別・地区別（施設）担当変更</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <%-- 040C共通のjs --%>
    <script type="text/javascript" src="js/ND001.js"></script>
    <!--<script type="text/javascript" src="js/JKR040C000.js"></script> -->
    <!--<script type="text/javascript" src="js/JKR040C010.js"></script> -->
    <script type="text/javascript" src="js/catTkCityCombo.js"></script>
    <script type="text/javascript" src="js/imtInsInputCategores.js"></script>
    <script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/rdmCatSosExpand.js"></script>
    <script type="text/javascript" src="js/jkrMenu.js"></script>

    <script>

    function comSetFormWindowInfo(){
    	comClickFlgInit();
    }

    function testAlert(testData) {
    	alert(testData)
    }

    var test1 = "医師新規作成"
    var test2 = "医師情報更新"
    var test3 = "医師勤務先情報更新"
    var test4 = "医師復活"

    function gotoNext(screenId,functionId,docNo){
    	  fm1.docNo.value=docNo;
    	  fm1.screenId.value=screenId;
    	  fm1.functionId.value=functionId;
    	  comSubmitForAnyWarp(fm1);
    }

 	var nd001Tab;
 	// アクションボタン
    function actBtn(screenId, docNo){
 		var tmpDoc = fm1.docNo.value;
 		// 新規
 		if(screenId == "ND011"){
 			fm1.ultDocNo.value = docNo;
 		} else {
 			fm1.docNo.value = docNo;
 			fm1.tkdDocNo.value = docNo;
 		}

 		if(nd001Tab && !nd001Tab.closed){
 			nd001Tab.close();
 		}

 		nf001Tab = window.open("","ND001Tab");
		document.fm1.target="ND001Tab";

  		fm1.screenId.value=screenId;
	  	fm1.functionId.value="Init";
	  	comSubmitForAnyWarp(fm1);
	  	comClickFlgInit();

	  	fm1.docNo.value = tmpDoc;
	}

 // 担当者選択ボタン
    function tantoPopBtn(){
    		// NC202_担当者検索ポップアップ画面を表示
    		window.open("","tantoPopWindow",tantoSubScreenSize);
    		document.fm1.screenId.value = "NC202";
    		document.fm1.functionId.value="Init";
    		document.fm1.target="tantoPopWindow";

    		document.fm1.sosCdPop.value = document.fm1.sosCd.value;
    		document.fm1.bumonRankPop.value = document.fm1.bumonRank.value;
    		document.fm1.upSosCdPop.value = document.fm1.upSosCd.value;

    		document.fm1.selectFlgPop.value="1";
    		document.fm1.callBack.value="callBackTantoPop";

    		comSubmitForAnyWarp(fm1);
    		comClickFlgInit();
    }

	// 担当者検索ポップアップから値受け取り
    function callBackTantoPop(sosCd, bumonSeiName, jgiNo, jgiName, trtCd, brCode,
    							distCode, trtGrpCd, trtNm, mrCat){
		document.fm1.sosCd.value = sosCd;
		document.fm1.bumonRyakuName.value = bumonSeiName;
		document.fm1.jgiNo.value = jgiNo;
		document.fm1.jgiNm.value = jgiName;
		document.fm1.trtCd.value = trtCd;
		document.fm1.trtNm.value = trtNm;
		document.fm1.mrCat.value = mrCat;
		document.fm1.brCode.value = brCode;
		document.fm1.distCode.value = distCode;
    }
    </script>
    <style>
    .parent {
        display:flex;
        align-items:cener;
        gap:0;
    }
    thead {
        position:Sticky;
        top:0;
        background-color: #fff;
        }
    th {
        height:10px;
    }
    </style>
    <style>
	    .testDiv{
	        position: relative;
	    }
	    .testDiv:hover .hoverImg {
            display: inline;                /* インライン要素として表示 */
        }
        .hoverImg{
            display: none;
            position   : absolute;
        }
        .hoverImg:after{
            right: -12px;
            top: 30%;
            position: absolute;
        }

        TH.comTableTitle			/* テーブル形式のタイトル項目 */
        {
          color : #000000;
          background-color: #e0e0d4;
        /*	background-color: #cccccc;*/
          background-color: #e8b5a2;
          text-align : center;
          border-style: solid;
          border-top-width : 0px;
          border-left-width : 1px;
          border-right-width : 1px;
          border-bottom-width : 1px;
          font-size   : 8pt;
          /*テーブル幅可変*/
	      resize : horizontal;
		  overflow : hidden;
		  font-weight:normal;
        }
        .tkdUlt TH:first-child {
          position: sticky;
          left: 0;
          z-index:100;
        }
        .actionButton {
          position:Sticky;
          left: 0;
          border-style: solid;
          background-color:#fff;
          z-index:2;
        }
        .actionTh {
          position: sticky;
          top: 0;
          background-color:#fff;
        }
	</style>
<%
// ソート順状態制御用
String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
//String sortCondition = null;
%>
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">

  <%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>

<table border="0" class="comPortalTable" align="center" style="width:98%;">
  <tr>
    <td>
    <s:form name="fm1" theme="simple" onSubmit="JavaScript:return false;" >
          <s:hidden name="screenId" value="ND001"/>
          <s:hidden name="functionId" value="Search"/>
          <s:hidden name="gamenId" value="ND001"/>
          <s:hidden id="pageFlag" name="pageFlag" />
          <s:hidden id="mrAdminFlg" name="mrAdminFlg" />
          <s:hidden name="pageCntAll" />
          <s:hidden name="pageCntCur" />
          <s:hidden name="pageCntBase" />
          <s:hidden name="lineCntStart" />
          <s:hidden name="lineCntEnd" />
          <s:hidden name="lineCntAll" />
          <s:hidden name="selectFlg"/>
          <s:hidden name="sortCondition" />

		  <s:hidden name="backScreenId" value="ND001" />
    	  <s:hidden id="preScreenId" name="preScreenId" value="ND001"/>

          <s:hidden name="docNo" id="docNo"/>
          <s:hidden name="ultDocNo" id="ultDocNo"/>
          <s:hidden name="tkdDocNo" id="tkdDocNo"/>

           <%-- 組織検索ポップアップ用 --%>
              <input type="hidden" name="selectFlgPop"           value="" />
  			　　<input type="hidden" name="initSosCdPop"           value="" />
  			　　<input type="hidden" name="trtCdPop"               value="" />
  			<s:hidden id="callBack" name="callBack" />


	<s:hidden id="sosCdPop" name="sosCdPop"/>
	<s:hidden id="upSosCdPop" name="upSosCdPop"/>
	<s:hidden id="bumonRankPop" name="bumonRankPop"/>
	<s:hidden id="sosCd" name="sosCd"/>
	<s:hidden id="upSosCd" name="upSosCd"/>
	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="bumonRyakuName" name="bumonRyakuName"/>
	<s:hidden id="jgiNo" name="jgiNo"/>
	<s:hidden id="jgiName" name="jgiName"/>

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
<%-- 検索部 開始 --%>
          <table class="comPortalControlTable" style="margin-top:3pt;margin-bottom:1pt; width:800pt;"align="center">
          <tbody>
          　　　　　　　<tr>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>氏名漢字(全角)※</nobr></td>
              <td></td>
              <td><s:textfield name="searchDocName" size="30" maxlength="30" type="search" style="width:100pt;"/></td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>氏名カナ(半角カナ)※</nobr></td>
              <td></td>
              <td><s:textfield name="searchDocKana" size="30" maxlength="30" type="search" style="width:100pt;"/></td>
              <td></td>
              <s:if test='mrAdminFlg == "0"'>
                  <td class="comTableSearchItem" style="width:50pt;  color:lightgray;"><nobr>医師／薬剤師区分</nobr></td>
                  <td></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                      <select disabled Style="width:100pt"></select>
                  </td>
              </s:if>
              <s:else>
                  <td class="comTableSearchItem" style="width:50pt;"><nobr>医師／薬剤師区分</nobr></td>
                  <td></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                      <s:select id="searchDocType" name="searchDocType" cssStyle="width:100pt" list ="searchDocTypeCombo"/>
                  </td>
              </s:else>
              <td></td>
              <td></td>
            </tr>
                      　　<tr>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>医師固定C</nobr></td>
              <td></td>
              <td><s:textfield name="searchDocNo" size="30" maxlength="30" type="search" style="width:100pt;"/></td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>ULT医師コード</nobr></td>
              <td></td>
              <td><s:textfield name="searchDcfIshiCd" size="30" maxlength="30" type="search" style="width:100pt;"/></td>
              <td></td>
              <s:if test='mrAdminFlg == "0"'>
                  <td class="comTableSearchItem" style="width:50pt; color:lightgray;"><nobr>医師属性</nobr></td>
                  <td></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                      <select disabled Style="width:100pt"></select>
                  </td>
              </s:if>
              <s:else>
                  <td class="comTableSearchItem" style="width:50pt;"><nobr>医師属性</nobr></td>
                  <td></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                      <s:select id="searchDocAttribute" name="searchDocAttribute" cssStyle="width:100pt" list ="searchDocAttributeCombo"/>
                  </td>
              </s:else>
              <td></td>
              <td></td>
            </tr>
                      　　<tr>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>出身校</nobr></td>
              <td></td>
              <td class="comPortalControlItem" style="text-align:left;">
                  <s:select id="searchMedSch" name="searchMedSch" cssStyle="width:100pt" list ="searchMedSchCombo"/>
              </td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>卒年(西暦)</nobr></td>
              <td></td>
              <td class="comPortalControlItem" style="text-align:left;">
                  <s:select id="searchGradYear" name="searchGradYear" cssStyle="width:100pt" list ="searchGradYearCombo"/>
              </td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>出身医局校</nobr></td>
              <td></td>
              <td class="comPortalControlItem" style="text-align:left;">
                  <s:select id="searchHUniv" name="searchHUniv" cssStyle="width:100pt" list ="searchHUnivCombo"/>
              </td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>ULT接続</nobr></td>
              <td></td>
              <td class="comPortalControlItem" style="text-align:left;">
                  <s:select id="searchSetsuzoku" name="searchSetsuzoku" cssStyle="width:100pt" list ="searchSetsuzokuCombo"/>
              </td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="comTableSearchItem" style="width:50pt;">組織</td>
              <s:if test='mrAdminFlg == "0"'>
                  <td align="right"><input class="comButton" type="button" value="選択" onClick="" disabled/></td>
                  <td class="comPortalControlItem">
                         <s:textfield name="bumonSeiName" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/>
                  </td>
                  <td><a class="comMiniLink" onclick="" style="color:lightgray">clear</a>&nbsp;</td>
              </s:if>
              <s:else>
                  <td align="right"><input class="comButton" type="button" value="選択" onClick="jmnSearchSosCd();" /></td>
                  <td class="comPortalControlItem">
                         <s:textfield name="bumonSeiName" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/>
                  </td>
                  <td><a href="#" class="comMiniLink" onclick="jimClear('Sos');return false;">clear</a>&nbsp;</td>
              </s:else>
              <s:if test='mrAdminFlg == "0"'>
                  <td class="comTableSearchItem" style="width:50pt;"><nobr>担当者</nobr></td>
                  <td align="right"><input class="comButton" type="button" value="選択" onClick="" disabled/></td>
                  <td class="comPortalControlItem">
                       <s:textfield name="jgiName" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/>
                   </td>
                   <td><a class="comMiniLink" onclick="" style="color:lightgray">clear</a>&nbsp;</td>
              </s:if>
              <s:else>
                  <td class="comTableSearchItem" style="width:50pt;"><nobr>担当者</nobr></td>
                  <td align="right"><input class="comButton" type="button" value="選択" onClick="tantoPopBtn();" /></td>
                  <td class="comPortalControlItem">
                       <s:textfield name="" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/>
                   </td>
                   <td><a href="#" class="comMiniLink" onclick="jimClear('Sos');return false;">clear</a>&nbsp;</td>
              </s:else>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="comTableSearchItem"><nobr>施設固定C</nobr></td>
              <td></td>
              <td class="comPortalControlItem">
                  <s:textfield name="searchInsNo" size="30" maxlength="30" type="search" style="width:100pt;"/>
              </td>
              <td></td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>施設名</nobr></td>
              <td align="right"><input class="comButton" type="button" value="選択" onClick="jmnSearchSosCd();" /></td>
              <td class="comPortalControlItem">
                   <s:textfield name="" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/>
              </td>
              <td ><a href="#" class="comMiniLink" onclick="jimClear('Sos');return false;" align="left">clear</a>&nbsp;</td>
              <td class="comTableSearchItem" style="width:50pt;"><nobr>所属部科</nobr></td>
              <td align="right"><input class="comButton" type="button" value="選択" onClick="jmnSearchSosCd();" /></td>
              <td class="comPortalControlItem">
                   <s:textfield name="" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/>
              </td>
              <td style="width:50pt; text-align:left;"><a href="#" class="comMiniLink" onclick="jimClear('Sos');return false;" style="float:none;">clear</a>&nbsp;</td>
            </tr>
            <tr>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;" colspan=3><p>※項目は、武田情報とアルトマーク情報を同時検索します。</p></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td align="left"colspan="3">
              <s:if test='pageFlag == "1" '>
                <input type="button" name="search" value="新規作成" onclick="" disabled>&nbsp;※新規作成の前に検索してください
                <%--<input type="hidden"> --%>
              </s:if>
              <s:else>
                <input type="button" name="search" value="新規作成" onclick="testAlert(test1);">&nbsp;※新規作成の前に検索してください
              </s:else>
              </td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
            </tr>
            <tr>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td class="comTableSearchItem" style="width:50pt;"></td>
              <td align="right" colspan="2">
                <input type="button" name="search" value="検索" onclick="jimSearch();">&nbsp;
                <input type="button" name="search" value="クリア" onclick="jimClearAll(mrAdminFlg);">
              </td>
            </tr>
            </tbody>
          </table>
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
          <%-- データ部表示 開始 --%>
<%
  // ソート表示状態制御
  String docKanaAscClass = "comTableNoSort";
  String docKanaDescClass = "comTableNoSort";
  String docKanjAscClass = "comTableNoSort";
  String docKanjDescClass = "comTableNoSort";
  String docNoAscClass = "comTableNoSort";
  String docNoDescClass = "comTableNoSort";
  String ishiNmAscClass = "comTableNoSort";
  String ishiNmDescClass = "comTableNoSort";
  String ishiNmKanaAscClass = "comTableNoSort";
  String ishiNmKanaDescClass = "comTableNoSort";
  if ("1".equals(sortCondition)) {
	  docKanaDescClass = "comTableSort";
  } else if ("2".equals(sortCondition)) {
	  docKanjAscClass = "comTableSort";
  } else if ("3".equals(sortCondition)) {
	  docKanjDescClass = "comTableSort";
  } else if ("4".equals(sortCondition)) {
	  docNoAscClass = "comTableSort";
  } else if ("5".equals(sortCondition)) {
	  docNoDescClass = "comTableSort";
  } else if ("6".equals(sortCondition)) {
	  ishiNmAscClass = "comTableSort";
  } else if ("7".equals(sortCondition)) {
	  ishiNmDescClass = "comTableSort";
  } else if ("8".equals(sortCondition)) {
	  ishiNmKanaAscClass = "comTableSort";
  } else if ("9".equals(sortCondition)) {
	  ishiNmKanaDescClass = "comTableSort";
  }
%>
          <s:if test='pageFlag == "1" '>
          <!-- なにも表示しない -->
          </s:if>
          <s:else>
              <div style="max-height:300px;width:1250px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
                  <table class="tkdUlt" =border=1 cellpadding=2 cellspacing=0 style="width:1240px;">
                    <thead style="z-index:3">
                        <tr>
                            <th class="actionTh"></th>
                            <th class="comTableTitle" style="width:110px;">氏名漢字
                            <s:if test=' !(hcpDataList== null || hcpDataList.size() <= 0)'>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanjAscClass %>" href="" onclick="jimSort(2);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanjDescClass %>" href="" onclick="jimSort(3);return false;">▼</a>
                            </s:if>
                            </th>
                            <th class="comTableTitle" style="width:110px;">氏名カナ
                            <s:if test=' !(hcpDataList== null || hcpDataList.size() <= 0)'>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaAscClass %>" href="" onclick="jimSort(0);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docKanaDescClass %>" href="" onclick="jimSort(1);return false;">▼</a>
                            </s:if>
                            </th>
                            <th class="comTableTitle" style="width:110px;">医師固定C
                            <s:if test=' !(hcpDataList== null || hcpDataList.size() <= 0)'>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docNoAscClass %>" href="" onclick="jimSort(4);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=docNoDescClass %>" href="" onclick="jimSort(5);return false;">▼</a>
                            </s:if>
                            </th>
                            <th class="comTableTitle"><nobr>生年月日</nobr></th>
                            <th class="comTableTitle"><nobr>出身校</nobr></th>
                            <th class="comTableTitle"><nobr>卒年</nobr></th>
                            <th class="comTableTitle"><nobr>出身医局校</nobr></th>
                            <th class="comTableTitle"><nobr>医師／薬剤師区分</nobr></th>
                            <th class="comTableTitle"><nobr>施設略式漢字名（所属部科名：役職名）</nobr></th>
                            <th class="comTableTitle" style="width:20px;"><nobr>旧姓</nobr></th>
                        </tr>
                        <tr>
                            <th class="actionTh">アクション</th>
                            <th class="comTableTitle">ULT医師名漢字
                            <s:if test=' !(hcpDataList== null || hcpDataList.size() <= 0)'>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=ishiNmAscClass %>" href="" onclick="jimSort(6);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=ishiNmDescClass %>" href="" onclick="jimSort(7);return false;">▼</a>
                            </s:if>
                            </th>
                            <th class="comTableTitle">ULT医師名カナ
                            <s:if test=' !(hcpDataList== null || hcpDataList.size() <= 0)'>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=ishiNmKanaAscClass %>" href="" onclick="jimSort(8);return false;">▲</a>
                                <span style="font-size: 1pt;"> </span>
                                <a class="<%=ishiNmKanaDescClass %>" href="" onclick="jimSort(9);return false;">▼</a>
                            </s:if>
                            </th>
                            <th class="comTableTitle"><nobr>ULT医師コード</nobr></th>
                            <th class="comTableTitle"><nobr>ULT生年月日</nobr></th>
                            <th class="comTableTitle"><nobr>ULT出身校</nobr></th>
                            <th class="comTableTitle"><nobr>ULT卒年</nobr></th>
                            <th class="comTableTitle"><nobr></nobr></th>
                            <th class="comTableTitle"><nobr></nobr></th>
                            <th class="comTableTitle"><nobr>ULT施設名略名（所属部科名：役職名）</nobr></th>
                            <th class="comTableTitle"><nobr></nobr></th>
                        </tr>
                    </thead>
                     <tbody style="z-index:2">
                            <s:iterator value="hcpDataList" status="status" var="rowBean">
                              <tr>

                                  <td class="actionButton" style="height:90%; width:90px;" rowspan="2">
                                  <div class="testDiv">
                                      <table>
                                      <tbody>
                                      <tr>
                                      <td style="width:18px;">
                                      <s:if test='#rowBean.gamenShinkiFlg == "1"'>
                                          <img
                                            src="img/button_insert.gif"
                                            name="a"
                                            onclick="JavaScript:actBtn('ND011','<s:property value="#rowBean.dcfIshiCd"/>');"
                                          >
                                      </s:if>
                                      <s:else>
                                      </s:else>
                                      </td>
                                      <td style="width:18px;">
                                      <s:if test='#rowBean.gamenKoushinFlg == "1"'>
                                          <img
                                            src="img/button_update.gif"
                                            name="b"
                                            onclick="JavaScript:actBtn('ND012','<s:property value="#rowBean.docNo"/>');"
                                          >
                                      </s:if>
                                      <s:else>
                                      </s:else>
                                      </td>
                                      <td style="width:18px;">
                                      <s:if test='#rowBean.gamenKinmuKoushinFlg == "1"'>
                                          <img
                                            src="img/button_movemed.gif"
                                            name="c"
                                            onClick="JavaScript:actBtn('ND013','<s:property value="#rowBean.docNo"/>');"
                                          >
                                      </s:if>
                                      <s:else>
                                      </s:else>
                                      </td>
                                      <td style="width:18px;">
                                      <s:if test='#rowBean.gamenFukkatsuFlg == "1"'>
                                          <img
                                            src="img/button_restoration.gif"
                                            name="d"
                                            onClick="JavaScript:actBtn('ND014','<s:property value="#rowBean.docNo"/>');"
                                          >
                                      </s:if>
                                      <s:else>
                                      </s:else>
                                      <td>
                                          <img
                                            class="hoverImg"
                                            src="img/toolTip.gif"
                                          >
                                      </td>
                                      </tr>
                                      </tbody>
                                      </table>
                                  </div>
        						  </td>

                                  <td class="comTableItem" style="width:110px; height:18px;"><nobr><s:property value="#rowBean.docKanj"/></nobr></td>
                                  <td class="comTableItem" style="width:110px"><nobr><s:property value="#rowBean.docKana"/></nobr></td>
                                  <td class="comTableItem" style="width:110px"><nobr><s:property value="#rowBean.docNo"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.dob"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.univKj"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.grdaYear"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.ikyokuKj"/></nobr></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.docKbn"/></nobr></td>
                                  <td class="comTableItem"><s:property value="#rowBean.insName.replaceAll('\\n', '<br />')" escape="false"/></td>
                                  <td class="comTableItem"><nobr><s:property value="#rowBean.oldKanjSei"/></nobr></td>
                                  <!-- <td class="comTableItem"><nobr>横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列横スクロールバー用に長文の文字列</nobr></nobr></td> -->
                              </tr>
                              <tr style="min-height:18px;">
                                  <td class="comTableItem" style="background-color:#e0ffff; height:18px;"><nobr><s:property value="#rowBean.ishiNm"/></nobr></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"><nobr><s:property value="#rowBean.ishiNmKana"/></nobr></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"><nobr><s:property value="#rowBean.dcfIshiCd"/></nobr></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"><nobr><s:property value="#rowBean.ultDob"/></nobr></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"><nobr><s:property value="#rowBean.ultUnivKj"/></nobr></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"><nobr><s:property value="#rowBean.sotsunenSr"/></nobr></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"><s:property value="#rowBean.ultInsName.replaceAll('\\n', '<br />')" escape="false"/></td>
                                  <td class="comTableItem" style="background-color:#e0ffff"></td>

                              </tr>
                            </s:iterator>
                      </tbody>
                  </table>
              </div>
          </s:else>
          <div>
              <table class="comPortalControlTable" style="margin-top:3pt;margin-bottom:1pt; width:800pt;"align="center">
                  <tr>
                      <td>
                          <input class="comButton" type="button" name="bSosJgiFrom" value="戻る"/>
                      </td>
                  </tr>
              </table>
          </div>
          <%-- データ部表示 終了 --%>
          </td>
          </tr>
          </tbody>
          </table>
    </s:form>
    </td>
    </tr>
    </table>
      <jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
