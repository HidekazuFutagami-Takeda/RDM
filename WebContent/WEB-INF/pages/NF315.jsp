<%--
/**
 * <pre>
 *  施設紐付け削除のJSP
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
  <title>NF315_施設紐付け削除 - 申請内容確認</title>
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
    	if(window.confirm("施設紐付け削除画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
    		// NF213_施設紐付け削除に遷移
    		document.fm1.screenId.value="NF213";
			document.fm1.functionId.value="Init";

			comSubmitForAnyWarp(fm1);
    	}
    }

    // 却下ボタン
    function rejectBtn(){
    	if(window.confirm("申請データを却下します。よろしいですか？")){
    		// エラーチェック後に、DB登録定義(申請管理)シートの通り申請管理を更新する
			// NC011_申請一覧へ遷移する
    		document.fm1.screenId.value="NF315";
			document.fm1.functionId.value="Register";
			document.fm1.funcId.value = "3";

			comSubmitForAnyWarp(fm1);
    	}
    }

    // 申請ボタン、承認ボタン
    function reqApprBtn(funcId){
    	// エラーチェック後に、DB登録定義(申請管理)シートの通り申請管理を更新する
    	// NC101_完了画面へ遷移する
    	// funcId 1申請 2承認
   		document.fm1.screenId.value="NF315";
		document.fm1.functionId.value="Register";
		document.fm1.funcId.value = funcId;

		comSubmitForAnyWarp(fm1);
    }

    </script>
</head>

<body class="comPage" onUnload="JavaScript:jmsUnLoad();">
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

<table id="formTable" border="0" class="comPortalTable" align="center" style="width:98%;">
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
    <s:hidden name="backScreenId" value="NF315" />
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
     <s:hidden name="tkdTrtKbn"/>

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
	<s:hidden name="trtCd"/>
	<s:hidden name="hinGCd"/>
	<s:hidden name="insSbt"/>
	<s:hidden name="btnEnableFlg"/>

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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設紐付け新規"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>
<%-- ポータルタイトル 終了 --%>
<%-- ポータルボディー 開始 --%>
    <table class="comPortalBody" <s:if test='tkdTrtKbn == "0"'>style="background-color: #D7EEFF;"</s:if>>
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

  <table id="formTable01" border="0" <s:if test='tkdTrtKbn == "0"'>class="comPortalTableBlue"</s:if><s:else>class="comPortalTable"</s:else> align="center" style="width:75%;">
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
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>申請情報</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>申請ID</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="reqId"/></nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>申請者所属部署</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="reqShzNm"/></nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>申請ステータス</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="reqStsNm"/></nobr></td>
      </tr>
      <tr>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>申請者</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="reqJgiName"/></nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>申請日時</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="reqYmdhms"/></nobr></td>
	  </tr>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示　申請者には非表示 -->
	  <s:if test='%{reqStsCd != null && reqStsCd != "" && !(reqStsCd == "01" || reqStsCd == "11" || reqStsCd == "03" || reqStsCd == "13") }'>
		<s:if test='%{loginJgiNo != reqJgiNo }'>
	      <tr>
		      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
		      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>審査者</nobr></td>
		      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="shnShaName"/></nobr></td>
		      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>審査日時</nobr></td>
		      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="shnYmdhms"/></nobr></td>
		  </tr>
	  </s:if>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示 -->
      <tr>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>承認者</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="aprShaName"/></nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>承認日時</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="aprYmdhms"/></nobr></td>
	  </tr>
	  </s:if>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable02" border="0" <s:if test='tkdTrtKbn == "0"'>class="comPortalTableBlue"</s:if><s:else>class="comPortalTable"</s:else> align="center" style="width:75%;">
      <tr>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>施設固定コード</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="insNo"/><s:hidden name="insNo"/></nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>施設略式漢字名</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="insAbbrName"/><s:hidden name="insAbbrName"/></nobr></td>
      </tr>
      <tr>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>住所</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="insAddr"/><s:hidden name="insAddr"/></nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>領域・品目グループ</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>
	      		<s:label key="trtPrdGrpNm" />
	      		<s:hidden name="trtPrdGrpNm" />
			</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>適用日</nobr></td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>
	      	<s:label key="tekiyoYmd" /><s:hidden name="tekiyoYmd" />
	      </nobr></td>
      </tr>
      <tr>
      	<s:hidden name="mainInsAddr" />
      	<s:hidden name="mainInsSbt"/>
	    <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>&nbsp;</nobr></td>
	    <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>親施設</nobr></td>
	    <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>
	    	<s:label key="mainInsCd" /><s:hidden name="mainInsCd" />
	    </nobr></td>
	    	<td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>施設略式漢字名</nobr></td>
	    	<td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:label key="mainInsNm" /><s:hidden name="mainInsNm" /></nobr></td>
      </tr>
      <s:if test='tkdTrtKbn == "1"'>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>親施設担当者</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insTanto" /><s:hidden name="insTanto" /></nobr></td>
      </tr>
      </s:if>
  　</table>

  <%--コメント類 --%>
  <table id="formTable03" border="0" <s:if test='tkdTrtKbn == "0"'>class="comPortalTableBlue"</s:if><s:else>class="comPortalTable"</s:else> align="center" style="width:75%;">
      <tr>
        <%--コメント--%>
        <td style="width: 650px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>申請コメント</nobr></td>
      </tr>
      <tr>
    	<td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px; background-color:#D4D0C8" readonly="true"/></nobr></td>
      </tr>
      <s:if test='%{loginJokenSetCd == "JKN0813"}'>
	      <tr>
		      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr>承認・却下コメント（※申請者への伝達事項）</nobr></td>
	      </tr>
	      <tr>
	      	<s:if test='%{reqStsCd == "03" || reqStsCd == "13"}'>
		      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:textarea name="aprComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;"/></nobr></td>
	      	</s:if>
	      	<s:else>
	      		<td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>><nobr><s:textarea name="aprComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px; background-color:#D4D0C8" readonly="true"/></nobr></td>
	      	</s:else>
	      </tr>
      </s:if>
  </table>

  <%--ボタン類 --%>
  <table id="formTable04" border="0" <s:if test='tkdTrtKbn == "0"'>class="comPortalTableBlue"</s:if><s:else>class="comPortalTable"</s:else> align="center" style="width:98%;">
      <tr>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 38%; height: 0px; border-width: 0px;"></td>
      </tr>
		<tr>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>>
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backBtn();return false;" />
                <s:if test='%{loginJokenSetCd == "JKN0813" && (reqStsCd == "03" || reqStsCd == "13")}'>
                	<s:if test='%{btnEnableFlg == "1"}'>
	                	<input class="comButton" type="button"name="buttonF2" value="却下" onClick="JavaScript:rejectBtn();return false;" />
	                </s:if>
	                <s:else>
	                	<input class="comButton" type="button"name="buttonF2" value="却下" onClick="JavaScript:rejectBtn();return false;" disabled />
	                </s:else>
                </s:if>
                </nobr>
	      </td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>>&nbsp;</td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>>&nbsp;</td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>>&nbsp;</td>
	      <td <s:if test='tkdTrtKbn == "0"'>class="comFormTableItemBlue"</s:if><s:else>class="comFormTableItem"</s:else>>
               <nobr>
               	<s:if test='%{loginJokenSetCd == "JKN0813" && (reqStsCd == "03" || reqStsCd == "13")}'>
               		<s:if test='%{btnEnableFlg == "1"}'>
						<input class="comButton" type="button"name="buttonF3" value="承認" onClick="reqApprBtn('2');JavaScript:return false;" />
					</s:if>
					<s:else>
						<input class="comButton" type="button"name="buttonF3" value="承認" onClick="reqApprBtn('2');JavaScript:return false;" disabled />
					</s:else>
				</s:if>
				<s:else>
					&nbsp;
               	</s:else>
               	<s:if test='%{reqStsCd == "01" || reqStsCd == "11"}'>
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