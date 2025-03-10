<%--
/**
 * <pre>
 *  施設来期情報更新 - 申請内容確認のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
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
<%
String regEnabedFlg = StringUtils.nvl((String)request.getAttribute("regEnabedFlg"), "");
//20180406 HISOL ISHIDA START
String sosSelFlg = StringUtils.nvl((String)request.getAttribute("sosSelFlg"), "");
//20180406 HISOL ISHIDA END
String strRegDisabled = "";
//20180406 HISOL ISHIDA START
//if (!"1".equals(regEnabedFlg)) {
if ((!"1".equals(regEnabedFlg)) || ("1".equals(sosSelFlg))){
//20180406 HISOL ISHIDA END
    strRegDisabled = "disabled";
}
%>
<%-- オブジェクト読み込み --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <title>NF309_施設来期情報更新 - 申請内容確認</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/jgiKanren.js"></script>
  <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
  <script type="text/javascript" src="js/catHcpSoc.js"></script>
  <script type="text/javascript" src="js/catHcpPub.js"></script>
    <script>

	comClickFlgInit();

	// 戻るボタン
    function backBtn(){
    	document.fm1.target="";
		const preScreenId = document.fm1.preScreenId.value;
		if(preScreenId == "NF001"){
			if(window.confirm("施設検索画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
				window.close();
			}
		} else if(preScreenId == "NC011"){
			if(window.confirm("申請一覧画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
				window.close();
			}
		} else {
			window.close();
		}
    }

    // 却下ボタン
    function rejectBtn(){
    	if(window.confirm("申請データを却下します。よろしいですか？")){
    		// エラーチェック後に、DB登録定義(申請管理)シートの通り申請管理を更新する
			// NC011_申請一覧へ遷移する
    		document.fm1.screenId.value="NF309";
			document.fm1.functionId.value="Register";
			document.fm1.funcId.value = "3";

			comSubmitForAnyWarp(fm1);
    	}
    }

   	// funcId 1申請 2承認
    function reqApprBtn(funcId){
   		document.fm1.screenId.value="NF309";
		document.fm1.functionId.value="Register";
		document.fm1.funcId.value = funcId;

		comSubmitForAnyWarp(fm1);
    }

    </script>
</head>

<body class="comPage" onUnload="JavaScript:jmsUnLoad();" >
  <form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
    <input type="text" name="screenId"           value="" />
    <input type="text" name="functionId"         value="" />
    <input type="text" name="windowName"         value="" />
    <input type="text" name="openerName"         value="" />
    <input type="text" name="infoId1"            value="" />
    <input type="text" name="systemId1"          value="" />
    <input type="text" name="backScreenId1"      value="JkrMrChange" />
    <input type="text" name="backFunctionId1"    value="" />
    <input type="text" name="backScreenName1"    value="" />
    <input type="text" name="backParamName1"     value="" />
    <input type="text" name="backParamValue1"    value="" />
    <input type="text" name="backParamName2"     value="" />
    <input type="text" name="backParamValue2"    value="" />
    <input type="text" name="fromScreenId1"      value="" />
    <input type="text" name="fromFunctionId1"    value="" />
    <input type="text" name="kensakuChar1"       value="" />
    <input type="text" name="kensakuAndOr1"      value="" />
    <input type="text" name="pageNextBackFlag1"  value="" />
    <input type="text" name="sortFieldNo1"       value="" />
    <input type="text" name="sortFLG1"           value="" />
    <input type="text" name="startRecordNo1"     value="" />
    <input type="text" name="pageLines1"         value="" />
    <input type="hidden" name="endRecordNo1"	value="" />
    <input type="text" name="no1"                value="1" />

    <%-- フレーム対応で発生したPOST用 引数1:frame(フレーム対応),以外(何もしない) 引数２:オブジェクトの型 --%>

    <%-- 組織・従業員選択ポップアップ用 --%>
    <input type="hidden" name="selectFlg"			value="" />
    <input type="hidden" name="topSosCd"			value="" />
    <input type="hidden" name="initSosCd"			value="" />
    <input type="hidden" name="openBumonRank"		value="" />
    <input type="hidden" name="objData"				value="" />
    <input type="hidden" name="dspSelPtn"			value="" />
    <input type="hidden" name="dspSelSos"			value="" />
    <input type="hidden" name="sosLevelType"		value="" />
    <input type="hidden" name="dispJgiKb"			value="" />
    <input type="hidden" name="shokushuCd"			value="" />
    <input type="hidden" name="shokuseiCd"			value="" />
    <input type="hidden" name="noDispJgiKb"			value="" />
    <input type="hidden" name="noShokushuCd"		value="" />
    <input type="hidden" name="noShokuseiCd"		value="" />
    <input type="hidden" name="insNo1"				value="" />
    <input type="hidden" name="dspClrBtn1"			value="" /><%-- クリアボタン表示フラグ  --%>
    <input type="hidden" name="openJgiFlg"			value="" />
    <input type="text" name="sosSelFlg1"	value="" />

    <input type="checkbox" name="delCheck" />
    <input type="checkbox" name="hurikaeMr" />
    <input type="checkbox" name="shokiHurikaeMr" />

    <%-- 組織・従業員選択ポップアップの表示判断の条件 取得パラメータ：（MR種類・業務種類）--%>
    <input type="hidden" name="mrCat"				value=""	/>
    <input type="hidden" name="registCat"			value=""	/>

    <%-- 登録：排他処理用データ--%>
    <input type="hidden" name="ExUpDate"			value=""	/>

    <input type="text" name="userAuth1"		value="" />
    <input type="text" name="jpjJgiNo1"		value="" />
    <input type="text" name="sosCd1"		value="" />
    <input type="text" name="sosName1"		value="" />
    <input type="text" name="mrCat1"		value="" />
    <input type="text" name="registCat1"	value="" />
    <input type="text" name="jgiKb1"		value="" />
    <input type="text" name="selectedSosName1"	value="" />
    <input type="text" name="selectedSosCd1"	value="" />
    <input type="text" name="jgiJoken1"		value="" />
    <input type="text" name="sosName1"		value="" />
    <input type="text" name="wkCat1"		value="" />
    <input type="hidden" name="searchToSosCd1"		value="" />
    <input type="hidden" name="searchToSosName1"	value="" />
    <input type="hidden" name="shokikaSosName1"	value="" />
    <input type="hidden" name="shokikaSosCd1"	value="" />

    <input type="hidden" name="selectedPlanSosName1"		value="<bean:print name="menudata" property="selectedSosName"/>" />

    <%-- 登録前の最終総行数 --%>
    <input type="hidden" name="allUltCount1"	value="" />
    <%-- 登録前の追加の総行数 --%>
    <input type="hidden" name="addUltCount1"	value="" />

    <%--追加用　MR種類--%>
    <input type="hidden" name="takeMrCat"	value="" />

  </form>

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
      <s:form name="fm1" theme="simple">
  <%-- ページャパラメータ --%>
  <s:hidden name="orderKbn" />
    <s:hidden name="pageCntAll" />
    <s:hidden name="pageCntCur" />
    <s:hidden name="pageCntBase" />
    <s:hidden name="lineCntStart" />
    <s:hidden name="lineCntEnd" />
    <s:hidden name="lineCntAll1" />
    <%-- 画面用パラメータ --%>
    <s:hidden name="backScreenId" value="NF309" />
     <s:hidden name="preScreenId"/>
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
     <s:hidden name="loginJokenSetCd"/>
     <s:hidden name="loginJgiNo"/>
     <s:hidden name="loginNm"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>
     <s:hidden name="loginShzNm"/>
     <s:hidden name="loginTrtCd"/>
     <s:hidden name="shnFlg"/>
     <s:hidden name="funcId"/>

    <s:hidden name="defaultSosCd"/>
    <s:hidden name="defaultSosName"/>
    <s:hidden name="defaultBumonRank"/>
    <s:hidden name="defaultMrCat"/>
    <s:hidden name="searchBumonRank"/>
    <s:hidden name="maxUpDate"/>
    <s:hidden name="sosCdFixFlg"/>
    <s:hidden name="sosCdFix"/>
    <s:hidden name="sosNameFix"/>
    <s:hidden name="showFlg"/>
    <s:hidden name="showDocChgFlg"/>
    <s:hidden name="sosSelFlg"/>
    <s:hidden name="sosRyakuName"/>

	<s:hidden name="reqChl"/>
	<s:hidden name="insType"/>
	<s:hidden name="editApprFlg"/>
	<s:hidden name="pharmTypeFlg"/>
	<s:hidden name="insRankFlg"/>
	<s:hidden name="regVisTypeFlg"/>
	<s:hidden name="impHosTypeFlg"/>
	<s:hidden name="manageCdFlg"/>
	<s:hidden name="vacInsTypeFlg"/>
	<s:hidden name="vacVisitTypeFlg"/>
	<s:hidden name="bedCntBaseFlg"/>
	<s:hidden name="bedCnt04Flg"/>
	<s:hidden name="bedCnt01Flg"/>
	<s:hidden name="bedCnt05Flg"/>
	<s:hidden name="bedCnt03Flg"/>
	<s:hidden name="bedCnt07Flg"/>
	<s:hidden name="bedCnt02Flg"/>
	<s:hidden name="bedCnt06Flg"/>
	<s:hidden name="bedsTotFlg"/>
	<s:hidden name="medBedsTotFlg"/>

	<s:hidden name="btnEnableFlg"/>

	<input type="hidden" name="tmpPharmType" value="<s:property value="%{nextPharmType}"/>" />
    <input type="hidden" name="tmpInsRank" value="<s:property value="%{nextInsRank}"/>" />
    <input type="hidden" name="tmpRegVisType" value="<s:property value="%{nextRegVisType}"/>" />
    <input type="hidden" name="tmpImpHosType" value="<s:property value="%{nextImpHosType}"/>" />
    <input type="hidden" name="tmpManageCd" value="<s:property value="%{nextManageCd}"/>" />

    <%-- トップメニューからの共通パラメータ --%>
    <s:hidden name="trtGrpCd"/>
    <s:hidden name="selectedBumonRank"/>
    <s:hidden name="sosCd"/>
    <s:hidden name="sosName"/>
    <s:hidden name="selectedSosCd"/>
    <s:hidden name="selectedSosNm"/>
    <s:hidden name="selectedSosCd2" />
    <s:hidden name="selectedSosNm2" />
    <s:hidden name="selectedSosCd3" />
    <s:hidden name="selectedSosNm3" />
    <s:hidden name="selectedJgiJoken"/>
    <s:hidden name="jokenSetCd"/>
    <s:hidden name="sosCdHairetu"/>
    <s:hidden name="wkCat"/>
    <s:hidden name="searchFromSosCdPop"/>  <!--現組織コード(ポップアップ用) -->
    <s:hidden name="searchToSosCdPop"/>    <!--新組織コード(ポップアップ用) -->
    <s:hidden id="selectedTekiyoYmd" name="selectedTekiyoYmd"/>
    <%-- 組織ポップアップ用パラメータ --%>
    <input type="hidden" name="selectFlgPop"           value="" />
  <input type="hidden" name="initSosCdPop"           value="" />
  <input type="hidden" name="sosKbnPop"              value="" />
  <input type="hidden" name="sknnFlgPop"             value="" />
  <input type="hidden" name="insFlgPop"              value="" />
  <input type="hidden" name="topMenuFlgPop"          value="" />
  <input type="hidden" name="authorityPop"           value="" />
  <input type="hidden" name="bumonRankTopPop"        value="" />
  <input type="hidden" name="bumonRankBtmPop"        value="" />
  <input type="hidden" name="topSosCdPop"            value="" />
  <input type="hidden" name="defTblFlgPop"           value="" />
  <input type="hidden" name="actSosListPop"          value="<s:property value="%{sosCdHairetu}"/>" />
  <input type="hidden" name="shokushuFlgPop"         value="" />
  <input type="hidden" name="ztTntFlgPop"            value="" />
  <input type="hidden" name="jokenSetCdPop"          value="" />
  <input type="hidden" name="menuTrtGrpCdPop"        value="" />
  <input type="hidden" name="menuSosCdPop"           value="" />
  <input type="hidden" name="selectableBumonrankPop" value="" />
  <input type="hidden" name="insNoPop"               value="" />
  <input type="hidden" name="trtCdPop"               value="" />
  <input type="hidden" name="sosCdFromPop"           value="" />
  <input type="hidden" name="krJgiNoDispFlgPop"      value="" />
  <input type="hidden" name="sosCdToPop"             value="" />
  <input type="hidden" name="trtTntFlgPop"           value="" />

  <!-- 選択された組織情報格納（表示押下前） -->
  <s:hidden name="topChgSosCd" value=""/>
  <s:hidden name="topChgSosNm" value=""/>
  <s:hidden name="topChgSosCd2" value=""/>
  <s:hidden name="topChgSosNm2" value=""/>
  <s:hidden name="topChgSosCd3" value=""/>
  <s:hidden name="topChgSosNm3" value=""/>
  <!-- 選択された組織情報格納（表示押下後） -->
  <s:hidden name="topChangedSosCd" />
  <s:hidden name="topChangedSosNm" />
  <s:hidden name="topChangedSosCd2" />
  <s:hidden name="topChangedSosNm2" />
  <s:hidden name="topChangedSosCd3" />
  <s:hidden name="topChangedSosNm3" />

  <s:hidden name="title" />

<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設来期情報更新 - 申請内容確認"></td>
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

  <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--申請情報--%>
        <%--申請情報のHIDDEN項目--%>
        <s:hidden name="reqId"/>
        <s:hidden name="reqJgiNo"/>
        <s:hidden name="reqJgiName"/>
        <s:hidden name="reqBrCd"/>
        <s:hidden name="reqDistCd"/>
        <s:hidden name="reqShzNm"/>
        <s:hidden name="reqStsCd"/>
        <s:hidden name="reqStsNm"/>
        <s:hidden name="reqYmdhms"/>
        <s:hidden name="shnJgiNo"/>
        <s:hidden name="aprJgiNo"/>
        <s:hidden name="updShaYmd"/>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>申請情報</nobr></td>
	      <td class="comFormTableItem"><nobr>申請ID</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqId"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>申請者所属</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqShzNm"/></nobr></td>
	      <td class="comFormTableItem"><nobr>申請ステータス</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqStsNm"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>申請者氏名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqJgiName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>申請日時</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqYmdhms"/></nobr></td>
	  </tr>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示　申請者には非表示 -->
	  <s:if test='%{reqStsCd != null && reqStsCd != "" && !(reqStsCd == "01" || reqStsCd == "11" || reqStsCd == "03" || reqStsCd == "13") }'>
		<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	      <tr>
		      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		      <td class="comFormTableItem"><nobr>審査者</nobr></td>
		      <td class="comFormTableItem"><nobr><s:label key="shnShaName"/></nobr></td>
		      <td class="comFormTableItem"><nobr>審査日時</nobr></td>
		      <td class="comFormTableItem"><nobr><s:label key="shnYmdhms"/></nobr></td>
		  </tr>
	  </s:if>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示 -->
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>承認者</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="aprShaName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>承認日時</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="aprYmdhms"/></nobr></td>
	  </tr>
	  </s:if>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable02" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--施設情報--%>
		<td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>施設情報</nobr></td>
	      <td class="comFormTableItem"><nobr>施設固定コード</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insNo"/><s:hidden name="insNo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>ULT施設コード</nobr></td>
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
  <br/>
    <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
  	<tr>
        <%--見出し--%>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>当期項目情報</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>ULT項目情報</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>来期項目情報</nobr></td>
	　　</tr>
  </table>

  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
    <tr>
        <%--基本情報--%>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>基本情報</nobr></td>
	<tr>
		<td class="comFormTableItem">施設区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="pharmTypeNm" /><s:hidden name="pharmType" /><s:hidden name="pharmTypeNm" /></td>
	   	<td class="comFormTableItemNf012"><s:label key="shisetsuKbn" /><s:hidden name="shisetsuKbn" /></td>
	   	<td class="comFormTableItemNf012">
	   	<s:if test="pharmType == nextPharmType">
	   		<s:label key="nextPharmTypeNm" />
	   	</s:if>
	   	<s:else>
	   		<font color="red"><s:label key="nextPharmTypeNm" /></font>
	   	</s:else>
	   		<s:hidden key="nextPharmType" /><s:hidden name="nextPharmTypeNm" />
	   	</td>
	</tr>
	<tr>
		<td class="comFormTableItem">階級区分</td>
		<td class="comFormTableItemNf012"><s:label key="insRankNm" /><s:hidden name="insRank" /><s:hidden name="insRankNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012">
	   	<s:if test="insRank == nextInsRank">
		   	<s:label key="nextInsRankNm" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextInsRankNm" /></font>
		</s:else>
		   	<s:hidden key="nextInsRank" /><s:hidden name="nextInsRankNm" />
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">定訪先区分</td>
		<td class="comFormTableItemNf012"><s:label key="regVisTypeNm" /><s:hidden name="regVisType" /><s:hidden name="regVisTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012">
		<s:if test="regVisType == nextRegVisType">
		   	<s:label key="nextRegVisTypeNm" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextRegVisTypeNm" /></font>
		</s:else>
		<s:hidden key="nextRegVisType" /><s:hidden name="nextRegVisTypeNm" />
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">重点病院区分</td>
		<td class="comFormTableItemNf012"><s:label key="impHosTypeNm" /><s:hidden name="impHosType" /><s:hidden name="impHosTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012">
   		<s:if test="impHosType == nextImpHosType">
		   	<s:label key="nextImpHosTypeNm" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextImpHosTypeNm" /></font>
		</s:else>
	   		<s:hidden key="nextImpHosType" /><s:hidden name="nextImpHosTypeNm" />
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">対象区分</td>
		<td class="comFormTableItemNf012"><s:label key="hoInsTypeNm" /><s:hidden name="hoInsType" /><s:hidden name="hoInsTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012">
	   	<s:if test="hoInsType == nextHoInsType">
		   	<s:label key="nextHoInsTypeNm" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextHoInsTypeNm" /></font>
		</s:else>
	   		<s:hidden key="nextHoInsType" /><s:hidden name="nextHoInsTypeNm" />
	   	</td>
	</tr>
	<tr>
		<td class="comFormTableItem">経営主体</td>
		<td class="comFormTableItemNf012"><s:label key="manageNm" /><s:hidden name="manageCd" /><s:hidden name="manageNm" /></td>
	   	<td class="comFormTableItemNf012"><s:label key="keieitaiNm" /><s:hidden name="keieitaiNm" /></td>
	   	<td class="comFormTableItemNf012">
	   	<s:if test="manageCd == nextManageCd">
		   	<s:label key="nextManageNm" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextManageNm" /></font>
		</s:else>
	   	<s:hidden key="nextManageCd" /><s:hidden name="nextManageNm" />
	   	</td>
	</tr>
	<tr <s:if test="insType != '08'">style="visibility:collapse"</s:if>>
		<td class="comFormTableItem">ワクチン対象区分</td>
		<td class="comFormTableItemNf012"><s:label key="vacInsTypeNm" /><s:hidden name="vacInsType" /><s:hidden name="vacInsTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012">
		<s:if test="vacInsType == nextVacInsType">
		   	<s:label key="nextVacInsTypeNm" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextVacInsTypeNm" /></font>
		</s:else>
		<s:hidden key="nextVacInsType" /><s:hidden name="nextVacInsTypeNm" />
		</td>
	</tr>
	<tr <s:if test="insType != '08'">style="visibility:collapse"</s:if>>
		<td class="comFormTableItem">ワクチン定訪先区分</td>
		<td class="comFormTableItemNf012"><s:label key="vacVisitTypeNm" /><s:hidden name="vacVisitType" /><s:hidden name="vacVisitTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012">
	   	<s:if test="vacVisitType == nextVacVisitType">
		   	<s:label key="nextVacVisitTypeNm" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextVacVisitTypeNm" /></font>
		</s:else>
	   	<s:hidden key="nextVacVisitType" /><s:hidden name="nextVacVisitTypeNm" />
	   	</td>
	</tr>
  </table>
  	<s:if test="insType == '01' || insType == '02'">
	<br/>
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable05" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--病床数情報--%>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">病床数情報</td>
		<td class="comFormTableItem">&nbsp;</td>
		<td class="comFormTableItem">&nbsp;</td>
		<td class="comFormTableItem">&nbsp;</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">基準</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCntBase" /><s:hidden name="bedCntBase"/></td>
	   	<td class="comFormTableItemNf012"><s:label key="ultBedCntBase" /><s:hidden name="ultBedCntBase"/></td>
	   	<td class="comFormTableItemNf012">
	   	<s:if test="bedCntBase == nextBedCntBase">
		   	<s:label key="nextBedCntBase" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedCntBase" /></font>
		</s:else>
	   	<s:hidden name="nextBedCntBase"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">結核</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt04" /><s:hidden name="bedCnt04"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt04" /><s:hidden name="ultBedCnt04"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="bedCnt04 == nextBedCnt04">
		   	<s:label key="nextBedCnt04" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedCnt04" /></font>
		</s:else>
		<s:hidden name="nextBedCnt04"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">一般</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt01" /><s:hidden name="bedCnt01"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt01" /><s:hidden name="ultBedCnt01"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="bedCnt01 == nextBedCnt01">
		   	<s:label key="nextBedCnt01" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedCnt01" /></font>
		</s:else>
		<s:hidden name="nextBedCnt01"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">感染症</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt05" /><s:hidden name="bedCnt05"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt05" /><s:hidden name="ultBedCnt05"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="bedCnt05 == nextBedCnt05">
		   	<s:label key="nextBedCnt05" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedCnt05" /></font>
		</s:else>
		<s:hidden name="nextBedCnt05"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">精神</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt03" /><s:hidden name="bedCnt03"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt03" /><s:hidden name="ultBedCnt03"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="bedCnt03 == nextBedCnt03">
		   	<s:label key="nextBedCnt03" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedCnt03" /></font>
		</s:else>
		<s:hidden name="nextBedCnt03"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">療養</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt07" /><s:hidden name="bedCnt07"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt07" /><s:hidden name="ultBedCnt07"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="bedCnt07 == nextBedCnt07">
		   	<s:label key="nextBedCnt07" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedCnt07" /></font>
		</s:else>
		<s:hidden name="nextBedCnt07"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">医療療養</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt02" /><s:hidden name="bedCnt02"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt02" /><s:hidden name="ultBedCnt02"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="bedCnt02 == nextBedCnt02">
		   	<s:label key="nextBedCnt02" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedCnt02" /></font>
		</s:else>
		<s:hidden name="nextBedCnt02"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">介護療養</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt06" /><s:hidden name="bedCnt06"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt06" /><s:hidden name="ultBedCnt06"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="bedCnt06 == nextBedCnt06">
		   	<s:label key="nextBedCnt06" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedCnt06" /></font>
		</s:else>
		<s:hidden name="nextBedCnt06"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ベッド数計</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedsTot" /><s:hidden name="bedsTot"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedsTot" /><s:hidden name="ultBedsTot"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="bedsTot == nextBedsTot">
		   	<s:label key="nextBedsTot" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextBedsTot" /></font>
		</s:else>
		<s:hidden name="nextBedsTot"/></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">医療ベッド数計</td>
	   	<td class="comFormTableItemNf012"><s:label key="medBedsTot" /><s:hidden name="medBedsTot"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultMedBedsTot" /><s:hidden name="ultMedBedsTot"/></td>
		<td class="comFormTableItemNf012">
		<s:if test="medBedsTot == nextMedBedsTot">
		   	<s:label key="nextMedBedsTot" />
		</s:if>
		<s:else>
			<font color="red"><s:label key="nextMedBedsTot" /></font>
		</s:else>
		<s:hidden name="nextMedBedsTot"/></td>
	</tr>
	</table>
	</s:if>

  <%--コメント類 --%>
  <table id="formTable06" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--コメント--%>
        <td style="width: 650px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>申請コメント</nobr></td>
      </tr>
      <tr>
      	<s:if test='%{reqStsCd == ""　|| reqStsCd == "01"}'>
	    	<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;" /></nobr></td>
      	</s:if>
      	<s:else>
      		<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px; background-color:#D4D0C8" readonly="true"/></nobr></td>
      	</s:else>
      </tr>
      <s:if test='%{loginJokenSetCd == "JKN0850"}'>
	      <tr>
		      <td class="comFormTableItem"><nobr>承認・却下コメント（※申請者への伝達事項）</nobr></td>
	      </tr>
	      <tr>
	      	<s:if test='%{reqStsCd == "03" || reqStsCd == "13"}'>
		      <td class="comFormTableItem"><nobr><s:textarea name="aprComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;"/></nobr></td>
	      	</s:if>
	      	<s:else>
	      		<td class="comFormTableItem"><nobr><s:textarea name="aprComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px; background-color:#D4D0C8" readonly="true"/></nobr></td>
	      	</s:else>
	      </tr>
      </s:if>
  </table>

  <%--ボタン類 --%>
  <table id="formTable07" border="0" class="comPortalTable" align="center" style="width:98%;">
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
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backBtn();return false;" />
                <s:if test='%{loginJokenSetCd == "JKN0850" && (reqStsCd == "03" || reqStsCd == "13")}'>
                	<s:if test='%{btnEnableFlg == "1"}'>
	                	<input class="comButton" type="button"name="buttonF2" value="却下" onClick="JavaScript:rejectBtn();return false;" />
	                </s:if>
	                <s:else>
	                	<input class="comButton" type="button"name="buttonF2" value="却下" onClick="JavaScript:rejectBtn();return false;" disabled />
	                </s:else>
                </s:if>
                </nobr>
	      </td>
	      <td class="comFormTableItem">&nbsp;</td>
	      <td class="comFormTableItem">&nbsp;</td>
	      <td class="comFormTableItem">&nbsp;</td>
	      <td class="comFormTableItem">
               <nobr>
               	<s:if test='%{loginJokenSetCd == "JKN0850" && (reqStsCd == "03" || reqStsCd == "13")}'>
               		<s:if test='%{btnEnableFlg == "1"}'>
	               		<s:if test='%{reqStsCd == "03"}'>
	               			<input type="checkbox" id="fbReqFlg" name="fbReqFlg" /><label for="fbReqFlg">アルトマークへの情報連携</label>
	               		</s:if>
						<input class="comButton" type="button"name="buttonF3" value="承認" onClick="reqApprBtn('2');JavaScript:return false;" />
					</s:if>
					<s:else>
						<s:if test='%{reqStsCd == "03"}'>
							<input type="checkbox" id="fbReqFlg" name="fbReqFlg" readonly="true" /><label for="fbReqFlg">アルトマークへの情報連携</label>
						</s:if>
						<input class="comButton" type="button"name="buttonF3" value="承認" onClick="reqApprBtn('2');JavaScript:return false;" disabled />
					</s:else>
				</s:if>
				<s:else>
					&nbsp;
               	</s:else>
               	<s:if test='%{reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11"}'>
               		<s:if test='%{btnEnableFlg == "1"}'>
						<input class="comButton" type="button"name="buttonF3" value="申請" onClick="reqApprBtn('1');JavaScript:return false;" />
					</s:if>
					<s:else>
						<input class="comButton" type="button"name="buttonF3" value="申請" onClick="reqApprBtn('1');JavaScript:return false;" disabled />
					</s:else>
				</s:if>
				<s:else>
					&nbsp;
               	</s:else>
               </nobr>
	      </td>
	  </tr>
  </table>
<%-- SUBMIT用パラメータ 終了 --%>
	</td>
	</tr>
    </tbody>
    </table>
<%-- ポータルボディー 終了 --%>
    </s:form>
  </table>

  <jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
