<%--
/**
 * <pre>
 *  施設情報更新 - 申請内容確認のJSP
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
  <title>NF303_施設情報更新 - 申請内容確認</title>
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

    function backBtn(){
    	if(window.confirm("施設情報更新画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
    		// NF011_施設新規作成に遷移
    		document.fm1.screenId.value="NF012";
			document.fm1.functionId.value="Init";

			comSubmitForAnyWarp(fm1);
    	}
    }

    function rejectBtn(){
    	if(window.confirm("申請データを却下します。よろしいですか？")){
    		// エラーチェック後に、DB登録定義(申請管理)シートの通り申請管理を更新する
			// NC011_申請一覧へ遷移する
    		document.fm1.screenId.value="NF303";
			document.fm1.functionId.value="Register";
			document.fm1.funcId.value = "3";

			comSubmitForAnyWarp(fm1);
    	}
    }

    function reqApprBtn(funcId){
    	// エラーチェック後に、DB登録定義(申請管理)シートの通り申請管理を更新する
    	// NC101_完了画面へ遷移する
    	// funcId 1申請 2承認
   		document.fm1.screenId.value="NF303";
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
    <s:hidden name="backScreenId" value="NF303" />
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
	<s:hidden name="insNo"/>
	<s:hidden name="insClass"/>
	<s:hidden name="insSbt"/>
	<s:hidden name="btnEnableFlg"/>

	<%-- 変更前値保持 --%>
	<s:hidden name="insAbbrName"/>
	<s:hidden name="insKana"/>
	<s:hidden name="insFormalName"/>
	<s:hidden name="tradeType"/>
	<s:hidden name="preInsAbbrName"/>
	<s:hidden name="preInsKana"/>
	<s:hidden name="preInsFormalName"/>
	<s:hidden name="preTradeType"/>
	<s:hidden name="preInsOpenYear"/>
	<s:hidden name="preInsOpenMonth"/>
	<s:hidden name="preInsOpenDay"/>
	<s:hidden name="insOpenYear"/>
	<s:hidden name="insOpenMonth"/>
	<s:hidden name="insOpenDay"/>
	<s:hidden name="preWsType"/>
	<s:hidden name="preBasketPurchase"/>
	<s:hidden name="preUnivSudiv"/>
	<s:hidden name="preCapaType"/>
	<s:hidden name="preUltInsCd"/>
	<s:hidden name="ultInsCd"/>
	<s:hidden name="preShisetsuNmRyaku"/>
	<s:hidden name="preShisetsuNm"/>
	<s:hidden name="shisetsuNmRyaku"/>
	<s:hidden name="shisetsuNm"/>
	<s:hidden name="preInsPcode"/>
	<s:hidden name="insPcode"/>
	<s:hidden name="addrCodePref"/>
	<s:hidden name="preAddrCodePref"/>
	<s:hidden name="preAddrCodePrefName"/>
	<s:hidden name="addrCodePrefName"/>
	<s:hidden name="addrCodeCity"/>
	<s:hidden name="preAddrCodeCity"/>
	<s:hidden name="preAddrCodeCityName"/>
	<s:hidden name="addrCodeCityName"/>
	<s:hidden name="preInsAddrDt"/>
	<s:hidden name="insAddrDt"/>
	<s:hidden name="preInsAddr"/>
	<s:hidden name="preInsAddrKana"/>
	<s:hidden name="preTkCityCd"/>
	<s:hidden name="tkCityName"/>
	<s:hidden name="preInsPhone1"/>
	<s:hidden name="preInsFax1"/>
	<s:hidden name="preInsPhone2"/>
	<s:hidden name="preInsFax2"/>
	<s:hidden name="insPhone1"/>
	<s:hidden name="insFax1"/>
	<s:hidden name="insPhone2"/>
	<s:hidden name="insFax2"/>
	<s:hidden name="preInsUrl"/>
	<s:hidden name="preInsUrlYmd"/>
	<s:hidden name="insUrl"/>
	<s:hidden name="insUrlYmd"/>
	<s:hidden name="preFree0001"/>
	<s:hidden name="preFree0002"/>
	<s:hidden name="preFree0003"/>
	<s:hidden name="preFree0004"/>
	<s:hidden name="preFree0005"/>
	<s:hidden name="preFree0006"/>
	<s:hidden name="preFree0007"/>
	<s:hidden name="preFree0008"/>
	<s:hidden name="preFree0009"/>
	<s:hidden name="preFree0010"/>
	<s:hidden name="preFree0011"/>
	<s:hidden name="preFree0012"/>
	<s:hidden name="preFree0013"/>
	<s:hidden name="preFree0014"/>
	<s:hidden name="preFree0015"/>
	<s:hidden name="free0001"/>
	<s:hidden name="free0002"/>
	<s:hidden name="free0003"/>
	<s:hidden name="free0004"/>
	<s:hidden name="free0005"/>
	<s:hidden name="free0006"/>
	<s:hidden name="free0007"/>
	<s:hidden name="free0008"/>
	<s:hidden name="free0009"/>
	<s:hidden name="free0010"/>
	<s:hidden name="free0011"/>
	<s:hidden name="free0012"/>
	<s:hidden name="free0013"/>
	<s:hidden name="free0014"/>
	<s:hidden name="free0015"/>
	<s:hidden name="preWelfare02"/>
	<s:hidden name="preWelfare08"/>
	<s:hidden name="preResult01"/>
	<s:hidden name="preResult02"/>
	<s:hidden name="preResult03"/>
	<s:hidden name="preResult04"/>
	<s:hidden name="preResult05"/>
	<s:hidden name="preResult06"/>
	<s:hidden name="preResult07"/>
	<s:hidden name="preResult08"/>
	<s:hidden name="preResult09"/>
	<s:hidden name="preResult10"/>
	<s:hidden name="preResult11"/>
	<s:hidden name="preResult12"/>
	<s:hidden name="preResult13"/>
	<s:hidden name="preResult14"/>
	<s:hidden name="preResult15"/>
	<s:hidden name="preResult16"/>
	<s:hidden name="preResult17"/>
	<s:hidden name="preResult18"/>
	<s:hidden name="preResult19"/>
	<s:hidden name="preResult20"/>
	<s:hidden name="preResult21"/>
	<s:hidden name="preResult22"/>
	<s:hidden name="preResult23"/>
	<s:hidden name="preResult24"/>
	<s:hidden name="preResult25"/>
	<s:hidden name="preResult26"/>
	<s:hidden name="preResult27"/>
	<s:hidden name="preResult28"/>
	<s:hidden name="preResult29"/>
	<s:hidden name="preResult30"/>
	<s:hidden name="preResult31"/>
	<s:hidden name="preResult32"/>
	<s:hidden name="preResult33"/>
	<s:hidden name="preResult34"/>
	<s:hidden name="preResult35"/>
	<s:hidden name="preResult36"/>
	<s:hidden name="preEquip01"/>
	<s:hidden name="preEquip02"/>
	<s:hidden name="preEquip03"/>
	<s:hidden name="preEquip07"/>
	<s:hidden name="preEquip09"/>
	<s:hidden name="preMarket01"/>
	<s:hidden name="preMarket02"/>
	<s:hidden name="preMarket03"/>
	<s:hidden name="preMarket04"/>
	<s:hidden name="preMarket06"/>
	<s:hidden name="preMarket07"/>
	<s:hidden name="preMarket09"/>
	<s:hidden name="preMedical12"/>
	<s:hidden name="preSpfunc01"/>
	<s:hidden name="preSpfunc03"/>
	<s:hidden name="preSpfunc04"/>
	<s:hidden name="preTieup10"/>
	<s:hidden name="preTieup11"/>
	<s:hidden name="preTieup12"/>
	<s:hidden name="preUsercd0001"/>
	<s:hidden name="preUsercd0002"/>
	<s:hidden name="preUsercd0003"/>
	<s:hidden name="preUsercd0004"/>
	<s:hidden name="preUsercd0005"/>
	<s:hidden name="preUsercd0006"/>
	<s:hidden name="preUsercd0007"/>
	<s:hidden name="preUsercd0008"/>
	<s:hidden name="preUsercd0009"/>
	<s:hidden name="preUsercd0010"/>
	<s:hidden name="preUsercd0011"/>
	<s:hidden name="preUsercd0012"/>
	<s:hidden name="preUsercd0013"/>
	<s:hidden name="preUsercd0014"/>
	<s:hidden name="preUsercd0015"/>
	<s:hidden name="preUsercd0016"/>
	<s:hidden name="preUsercd0017"/>
	<s:hidden name="preUsercd0018"/>
	<s:hidden name="preUsercd0019"/>
	<s:hidden name="preUsercd0020"/>
	<s:hidden name="preUsercd0021"/>
	<s:hidden name="preUsercd0022"/>
	<s:hidden name="preUsercd0023"/>
	<s:hidden name="preUsercd0024"/>
	<s:hidden name="preUsercd0025"/>
	<s:hidden name="preUsercd0026"/>
	<s:hidden name="preUsercd0027"/>
	<s:hidden name="preUsercd0028"/>
	<s:hidden name="preUsercd0029"/>
	<s:hidden name="preUsercd0030"/>
	<s:hidden name="preUsercd0031"/>
	<s:hidden name="preUsercd0032"/>
	<s:hidden name="preUsercd0033"/>
	<s:hidden name="preUsercd0034"/>
	<s:hidden name="preUsercd0035"/>
	<s:hidden name="preUsercd0036"/>
	<s:hidden name="preUsercd0101"/>
	<s:hidden name="preUsercd0102"/>
	<s:hidden name="preUsercd0103"/>
	<s:hidden name="preUsercd0104"/>
	<s:hidden name="preUsercd0105"/>
	<s:hidden name="preUsercd0106"/>
	<s:hidden name="preUsercd0107"/>
	<s:hidden name="preUsercd0108"/>
	<s:hidden name="preUsercd0109"/>
	<s:hidden name="preUsercd0201"/>
	<s:hidden name="preUsercd0202"/>
	<s:hidden name="preUsercd0203"/>
	<s:hidden name="preUsercd0204"/>
	<s:hidden name="preUsercd0205"/>
	<s:hidden name="preUsercd0206"/>
	<s:hidden name="preReward04"/>
	<s:hidden name="preReward05"/>
	<s:hidden name="preReward08"/>
	<s:hidden name="preReward09"/>
	<s:hidden name="preReward16"/>
	<s:hidden name="preReward17"/>
	<s:hidden name="preReward18"/>
	<s:hidden name="preReward21"/>
	<s:hidden name="preReward23"/>
	<s:hidden name="preReward25"/>
	<s:hidden name="preReward26"/>
	<s:hidden name="preReward27"/>
	<s:hidden name="preReward29"/>
	<s:hidden name="preReward35"/>
	<s:hidden name="preReward36"/>
	<s:hidden name="preReward37"/>
	<s:hidden name="preReward44"/>
	<s:hidden name="preTradeTypeNm"/>
	<s:hidden name="tradeTypeNm"/>
	<s:hidden name="prePharmType"/>
	<s:hidden name="prePharmTypeNm"/>
	<s:hidden name="pharmType"/>
	<s:hidden name="pharmTypeNm"/>
	<s:hidden name="preInsRank"/>
	<s:hidden name="preInsRankNm"/>
	<s:hidden name="insRank"/>
	<s:hidden name="insRankNm"/>
	<s:hidden name="preRegVisType"/>
	<s:hidden name="preRegVisTypeNm"/>
	<s:hidden name="regVisType"/>
	<s:hidden name="regVisTypeNm"/>
	<s:hidden name="preManageCd"/>
	<s:hidden name="preManageNm"/>
	<s:hidden name="manageCd"/>
	<s:hidden name="manageNm"/>
	<s:hidden name="preWsTypeNm"/>
	<s:hidden name="preBasketPurchaseNm"/>
	<s:hidden name="wsTypeNm"/>
	<s:hidden name="basketPurchaseNm"/>
	<s:hidden name="preUnivSubdiv"/>
	<s:hidden name="preUnivSubdivNm"/>
	<s:hidden name="preCapaTypeNm"/>
	<s:hidden name="univSubdiv"/>
	<s:hidden name="univSubdivNm"/>
	<s:hidden name="capaType"/>
	<s:hidden name="capaTypeNm"/>
	<s:hidden name="bedCntBase"/>
	<s:hidden name="bedCnt01"/>
	<s:hidden name="bedCnt02"/>
	<s:hidden name="bedCnt03"/>
	<s:hidden name="bedCnt04"/>
	<s:hidden name="bedCnt05"/>
	<s:hidden name="bedCnt06"/>
	<s:hidden name="bedCnt07"/>
	<s:hidden name="bedsTot"/>
	<s:hidden name="medBedsTot"/>
	<s:hidden name="ultBedCnt01"/>
	<s:hidden name="ultBedCnt03"/>
	<s:hidden name="ultBedCnt04"/>
	<s:hidden name="ultBedCnt05"/>
	<s:hidden name="ultBedCnt07"/>
	<s:hidden name="ultBedsTot"/>
	<s:hidden name="nextBedCntBase"/>
	<s:hidden name="nextBedCnt01"/>
	<s:hidden name="nextBedCnt02"/>
	<s:hidden name="nextBedCnt03"/>
	<s:hidden name="nextBedCnt04"/>
	<s:hidden name="nextBedCnt05"/>
	<s:hidden name="nextBedCnt06"/>
	<s:hidden name="nextBedCnt07"/>
	<s:hidden name="nextBedsTot"/>
	<s:hidden name="nextMedBedsTot"/>
	<s:hidden name="preTkCityName"/>
	<s:hidden name="preWelfare02Nm"/>
	<s:hidden name="preWelfare08Nm"/>
	<s:hidden name="preResult01Nm"/>
	<s:hidden name="preResult02Nm"/>
	<s:hidden name="preResult03Nm"/>
	<s:hidden name="preResult04Nm"/>
	<s:hidden name="preResult05Nm"/>
	<s:hidden name="preResult06Nm"/>
	<s:hidden name="preResult07Nm"/>
	<s:hidden name="preResult08Nm"/>
	<s:hidden name="preResult09Nm"/>
	<s:hidden name="preResult10Nm"/>
	<s:hidden name="preResult11Nm"/>
	<s:hidden name="preResult12Nm"/>
	<s:hidden name="preResult13Nm"/>
	<s:hidden name="preResult14Nm"/>
	<s:hidden name="preResult15Nm"/>
	<s:hidden name="preResult16Nm"/>
	<s:hidden name="preResult17Nm"/>
	<s:hidden name="preResult18Nm"/>
	<s:hidden name="preResult19Nm"/>
	<s:hidden name="preResult20Nm"/>
	<s:hidden name="preResult21Nm"/>
	<s:hidden name="preResult22Nm"/>
	<s:hidden name="preResult23Nm"/>
	<s:hidden name="preResult24Nm"/>
	<s:hidden name="preResult25Nm"/>
	<s:hidden name="preResult26Nm"/>
	<s:hidden name="preResult27Nm"/>
	<s:hidden name="preResult28Nm"/>
	<s:hidden name="preResult29Nm"/>
	<s:hidden name="preResult30Nm"/>
	<s:hidden name="preResult31Nm"/>
	<s:hidden name="preResult32Nm"/>
	<s:hidden name="preResult33Nm"/>
	<s:hidden name="preResult34Nm"/>
	<s:hidden name="preResult35Nm"/>
	<s:hidden name="preResult36Nm"/>
	<s:hidden name="preEquip01Nm"/>
	<s:hidden name="preEquip02Nm"/>
	<s:hidden name="preEquip03Nm"/>
	<s:hidden name="preEquip07Nm"/>
	<s:hidden name="preEquip09Nm"/>
	<s:hidden name="preMarket01Nm"/>
	<s:hidden name="preMarket02Nm"/>
	<s:hidden name="preMarket03Nm"/>
	<s:hidden name="preMarket04Nm"/>
	<s:hidden name="preMarket06Nm"/>
	<s:hidden name="preMarket07Nm"/>
	<s:hidden name="preMarket09Nm"/>
	<s:hidden name="preMedical12Nm"/>
	<s:hidden name="preSpfunc01Nm"/>
	<s:hidden name="preSpfunc03Nm"/>
	<s:hidden name="preSpfunc04Nm"/>
	<s:hidden name="preTieup10Nm"/>
	<s:hidden name="preTieup11Nm"/>
	<s:hidden name="preTieup12Nm"/>
	<s:hidden name="preUsercd0001Nm"/>
	<s:hidden name="preUsercd0002Nm"/>
	<s:hidden name="preUsercd0003Nm"/>
	<s:hidden name="preUsercd0004Nm"/>
	<s:hidden name="preUsercd0005Nm"/>
	<s:hidden name="preUsercd0006Nm"/>
	<s:hidden name="preUsercd0007Nm"/>
	<s:hidden name="preUsercd0008Nm"/>
	<s:hidden name="preUsercd0009Nm"/>
	<s:hidden name="preUsercd0010Nm"/>
	<s:hidden name="preUsercd0011Nm"/>
	<s:hidden name="preUsercd0012Nm"/>
	<s:hidden name="preUsercd0013Nm"/>
	<s:hidden name="preUsercd0014Nm"/>
	<s:hidden name="preUsercd0015Nm"/>
	<s:hidden name="preUsercd0016Nm"/>
	<s:hidden name="preUsercd0017Nm"/>
	<s:hidden name="preUsercd0018Nm"/>
	<s:hidden name="preUsercd0019Nm"/>
	<s:hidden name="preUsercd0020Nm"/>
	<s:hidden name="preUsercd0021Nm"/>
	<s:hidden name="preUsercd0022Nm"/>
	<s:hidden name="preUsercd0023Nm"/>
	<s:hidden name="preUsercd0024Nm"/>
	<s:hidden name="preUsercd0025Nm"/>
	<s:hidden name="preUsercd0026Nm"/>
	<s:hidden name="preUsercd0027Nm"/>
	<s:hidden name="preUsercd0028Nm"/>
	<s:hidden name="preUsercd0029Nm"/>
	<s:hidden name="preUsercd0030Nm"/>
	<s:hidden name="preUsercd0031Nm"/>
	<s:hidden name="preUsercd0032Nm"/>
	<s:hidden name="preUsercd0033Nm"/>
	<s:hidden name="preUsercd0034Nm"/>
	<s:hidden name="preUsercd0035Nm"/>
	<s:hidden name="preUsercd0036Nm"/>
	<s:hidden name="preReward04Nm"/>
	<s:hidden name="preReward05Nm"/>
	<s:hidden name="preReward08Nm"/>
	<s:hidden name="preReward09Nm"/>
	<s:hidden name="preReward16Nm"/>
	<s:hidden name="preReward17Nm"/>
	<s:hidden name="preReward18Nm"/>
	<s:hidden name="preReward21Nm"/>
	<s:hidden name="preReward23Nm"/>
	<s:hidden name="preReward25Nm"/>
	<s:hidden name="preReward26Nm"/>
	<s:hidden name="preReward27Nm"/>
	<s:hidden name="preReward29Nm"/>
	<s:hidden name="preReward35Nm"/>
	<s:hidden name="preReward36Nm"/>
	<s:hidden name="preReward37Nm"/>
	<s:hidden name="preReward44Nm"/>
	<s:hidden name="welfare02Nm"/>
	<s:hidden name="welfare08Nm"/>
	<s:hidden name="result01Nm"/>
	<s:hidden name="result02Nm"/>
	<s:hidden name="result03Nm"/>
	<s:hidden name="result04Nm"/>
	<s:hidden name="result05Nm"/>
	<s:hidden name="result06Nm"/>
	<s:hidden name="result07Nm"/>
	<s:hidden name="result08Nm"/>
	<s:hidden name="result09Nm"/>
	<s:hidden name="result10Nm"/>
	<s:hidden name="result11Nm"/>
	<s:hidden name="result12Nm"/>
	<s:hidden name="result13Nm"/>
	<s:hidden name="result14Nm"/>
	<s:hidden name="result15Nm"/>
	<s:hidden name="result16Nm"/>
	<s:hidden name="result17Nm"/>
	<s:hidden name="result18Nm"/>
	<s:hidden name="result19Nm"/>
	<s:hidden name="result20Nm"/>
	<s:hidden name="result21Nm"/>
	<s:hidden name="result22Nm"/>
	<s:hidden name="result23Nm"/>
	<s:hidden name="result24Nm"/>
	<s:hidden name="result25Nm"/>
	<s:hidden name="result26Nm"/>
	<s:hidden name="result27Nm"/>
	<s:hidden name="result28Nm"/>
	<s:hidden name="result29Nm"/>
	<s:hidden name="result30Nm"/>
	<s:hidden name="result31Nm"/>
	<s:hidden name="result32Nm"/>
	<s:hidden name="result33Nm"/>
	<s:hidden name="result34Nm"/>
	<s:hidden name="result35Nm"/>
	<s:hidden name="result36Nm"/>
	<s:hidden name="equip01Nm"/>
	<s:hidden name="equip02Nm"/>
	<s:hidden name="equip03Nm"/>
	<s:hidden name="equip07Nm"/>
	<s:hidden name="equip09Nm"/>
	<s:hidden name="market01Nm"/>
	<s:hidden name="market02Nm"/>
	<s:hidden name="market03Nm"/>
	<s:hidden name="market04Nm"/>
	<s:hidden name="market06Nm"/>
	<s:hidden name="market07Nm"/>
	<s:hidden name="market09Nm"/>
	<s:hidden name="medical12Nm"/>
	<s:hidden name="spfunc01Nm"/>
	<s:hidden name="spfunc03Nm"/>
	<s:hidden name="spfunc04Nm"/>
	<s:hidden name="tieup10Nm"/>
	<s:hidden name="tieup11Nm"/>
	<s:hidden name="tieup12Nm"/>
	<s:hidden name="usercd0001Nm"/>
	<s:hidden name="usercd0002Nm"/>
	<s:hidden name="usercd0003Nm"/>
	<s:hidden name="usercd0004Nm"/>
	<s:hidden name="usercd0005Nm"/>
	<s:hidden name="usercd0006Nm"/>
	<s:hidden name="usercd0007Nm"/>
	<s:hidden name="usercd0008Nm"/>
	<s:hidden name="usercd0009Nm"/>
	<s:hidden name="usercd0010Nm"/>
	<s:hidden name="usercd0011Nm"/>
	<s:hidden name="usercd0012Nm"/>
	<s:hidden name="usercd0013Nm"/>
	<s:hidden name="usercd0014Nm"/>
	<s:hidden name="usercd0015Nm"/>
	<s:hidden name="usercd0016Nm"/>
	<s:hidden name="usercd0017Nm"/>
	<s:hidden name="usercd0018Nm"/>
	<s:hidden name="usercd0019Nm"/>
	<s:hidden name="usercd0020Nm"/>
	<s:hidden name="usercd0021Nm"/>
	<s:hidden name="usercd0022Nm"/>
	<s:hidden name="usercd0023Nm"/>
	<s:hidden name="usercd0024Nm"/>
	<s:hidden name="usercd0025Nm"/>
	<s:hidden name="usercd0026Nm"/>
	<s:hidden name="usercd0027Nm"/>
	<s:hidden name="usercd0028Nm"/>
	<s:hidden name="usercd0029Nm"/>
	<s:hidden name="usercd0030Nm"/>
	<s:hidden name="usercd0031Nm"/>
	<s:hidden name="usercd0032Nm"/>
	<s:hidden name="usercd0033Nm"/>
	<s:hidden name="usercd0034Nm"/>
	<s:hidden name="usercd0035Nm"/>
	<s:hidden name="usercd0036Nm"/>
	<s:hidden name="reward04Nm"/>
	<s:hidden name="reward05Nm"/>
	<s:hidden name="reward08Nm"/>
	<s:hidden name="reward09Nm"/>
	<s:hidden name="reward16Nm"/>
	<s:hidden name="reward17Nm"/>
	<s:hidden name="reward18Nm"/>
	<s:hidden name="reward21Nm"/>
	<s:hidden name="reward23Nm"/>
	<s:hidden name="reward25Nm"/>
	<s:hidden name="reward26Nm"/>
	<s:hidden name="reward27Nm"/>
	<s:hidden name="reward29Nm"/>
	<s:hidden name="reward35Nm"/>
	<s:hidden name="reward36Nm"/>
	<s:hidden name="reward37Nm"/>
	<s:hidden name="reward44Nm"/>
	<s:hidden name="welfare02"/>
	<s:hidden name="welfare08"/>
	<s:hidden name="result01"/>
	<s:hidden name="result02"/>
	<s:hidden name="result03"/>
	<s:hidden name="result04"/>
	<s:hidden name="result05"/>
	<s:hidden name="result06"/>
	<s:hidden name="result07"/>
	<s:hidden name="result08"/>
	<s:hidden name="result09"/>
	<s:hidden name="result10"/>
	<s:hidden name="result11"/>
	<s:hidden name="result12"/>
	<s:hidden name="result13"/>
	<s:hidden name="result14"/>
	<s:hidden name="result15"/>
	<s:hidden name="result16"/>
	<s:hidden name="result17"/>
	<s:hidden name="result18"/>
	<s:hidden name="result19"/>
	<s:hidden name="result20"/>
	<s:hidden name="result21"/>
	<s:hidden name="result22"/>
	<s:hidden name="result23"/>
	<s:hidden name="result24"/>
	<s:hidden name="result25"/>
	<s:hidden name="result26"/>
	<s:hidden name="result27"/>
	<s:hidden name="result28"/>
	<s:hidden name="result29"/>
	<s:hidden name="result30"/>
	<s:hidden name="result31"/>
	<s:hidden name="result32"/>
	<s:hidden name="result33"/>
	<s:hidden name="result34"/>
	<s:hidden name="result35"/>
	<s:hidden name="result36"/>
	<s:hidden name="equip01"/>
	<s:hidden name="equip02"/>
	<s:hidden name="equip03"/>
	<s:hidden name="equip07"/>
	<s:hidden name="equip09"/>
	<s:hidden name="market01"/>
	<s:hidden name="market02"/>
	<s:hidden name="market03"/>
	<s:hidden name="market04"/>
	<s:hidden name="market06"/>
	<s:hidden name="market07"/>
	<s:hidden name="market09"/>
	<s:hidden name="medical12"/>
	<s:hidden name="spfunc01"/>
	<s:hidden name="spfunc03"/>
	<s:hidden name="spfunc04"/>
	<s:hidden name="tieup10"/>
	<s:hidden name="tieup11"/>
	<s:hidden name="tieup12"/>
	<s:hidden name="usercd0001"/>
	<s:hidden name="usercd0002"/>
	<s:hidden name="usercd0003"/>
	<s:hidden name="usercd0004"/>
	<s:hidden name="usercd0005"/>
	<s:hidden name="usercd0006"/>
	<s:hidden name="usercd0007"/>
	<s:hidden name="usercd0008"/>
	<s:hidden name="usercd0009"/>
	<s:hidden name="usercd0010"/>
	<s:hidden name="usercd0011"/>
	<s:hidden name="usercd0012"/>
	<s:hidden name="usercd0013"/>
	<s:hidden name="usercd0014"/>
	<s:hidden name="usercd0015"/>
	<s:hidden name="usercd0016"/>
	<s:hidden name="usercd0017"/>
	<s:hidden name="usercd0018"/>
	<s:hidden name="usercd0019"/>
	<s:hidden name="usercd0020"/>
	<s:hidden name="usercd0021"/>
	<s:hidden name="usercd0022"/>
	<s:hidden name="usercd0023"/>
	<s:hidden name="usercd0024"/>
	<s:hidden name="usercd0025"/>
	<s:hidden name="usercd0026"/>
	<s:hidden name="usercd0027"/>
	<s:hidden name="usercd0028"/>
	<s:hidden name="usercd0029"/>
	<s:hidden name="usercd0030"/>
	<s:hidden name="usercd0031"/>
	<s:hidden name="usercd0032"/>
	<s:hidden name="usercd0033"/>
	<s:hidden name="usercd0034"/>
	<s:hidden name="usercd0035"/>
	<s:hidden name="usercd0036"/>
	<s:hidden name="usercd0101"/>
	<s:hidden name="usercd0102"/>
	<s:hidden name="usercd0103"/>
	<s:hidden name="usercd0104"/>
	<s:hidden name="usercd0105"/>
	<s:hidden name="usercd0106"/>
	<s:hidden name="usercd0107"/>
	<s:hidden name="usercd0108"/>
	<s:hidden name="usercd0109"/>
	<s:hidden name="usercd0201"/>
	<s:hidden name="usercd0202"/>
	<s:hidden name="usercd0203"/>
	<s:hidden name="usercd0204"/>
	<s:hidden name="usercd0205"/>
	<s:hidden name="usercd0206"/>
	<s:hidden name="reward04"/>
	<s:hidden name="reward05"/>
	<s:hidden name="reward08"/>
	<s:hidden name="reward09"/>
	<s:hidden name="reward16"/>
	<s:hidden name="reward17"/>
	<s:hidden name="reward18"/>
	<s:hidden name="reward21"/>
	<s:hidden name="reward23"/>
	<s:hidden name="reward25"/>
	<s:hidden name="reward26"/>
	<s:hidden name="reward27"/>
	<s:hidden name="reward29"/>
	<s:hidden name="reward35"/>
	<s:hidden name="reward36"/>
	<s:hidden name="reward37"/>
	<s:hidden name="reward44"/>

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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設情報更新 - 申請内容確認"></td>
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
	      <td class="comFormTableItem"><nobr>施設固定C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insNo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  </table>
  <br/>
    <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
  	<tr>
        <%--変更前後見出し--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>変更前</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>変更後</nobr></td>
	　　</tr>
  </table>

  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
    <tr>
        <%--基本情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>基本情報</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">施設略式漢字名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsAbbrName" /></td>
		<td class="comFormTableItemNf012"><font color="red"><s:label key="insAbbrName" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">施設カナ名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsKana" /></td>
		<td class="comFormTableItemNf012"><font color="red"><s:label key="insKana" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">施設正式漢字名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsFormalName" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="insFormalName" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">取引区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTradeType" />：<s:label key="preTradeTypeNm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="tradeTypeNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">開業年月日</td>
	   	<td class="comFormTableItemNf012">
	   		<nobr>
	   			<s:label key="preInsOpenYear"/>
	      		年
	      		<s:label key="preInsOpenMonth"/>
	      		月
	      		<s:if test='%{preInsOpenDay != null && preInsOpenDay != ""}'>
	      		<s:label key="preInsOpenDay"/>
	      		日
	      		</s:if>
	   		</nobr>
	   	</td>
		<td class="comFormTableItemNf012">
			<nobr><font color="red">
			<s:if test='%{(insOpenYear != null && insOpenYear != "") || (insOpenMonth != null && insOpenMonth != "") || (insOpenDay != null && insOpenDay != "")}'>
	      		<s:label key="insOpenYear"/>
	      		年
	      		<s:label key="insOpenMonth"/>
	      		月
	      		<s:label key="insOpenDay"/>
	      		日
	      	</s:if>
	      	<s:else>
	      		&nbsp;
	      	</s:else>
      		</font></nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">施設区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="prePharmType" />：<s:label key="prePharmTypeNm" /></td>
		<td class="comFormTableItemNf012"><font color="dodgerblue">（来期）<s:label key="pharmType" />：<s:label key="pharmTypeNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">階級区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsRank" />：<s:label key="preInsRankNm" /></td>
		<td class="comFormTableItemNf012"><font color="dodgerblue">（来期）<s:label key="insRank" />：<s:label key="insRankNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">定訪先区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preRegVisType" />：<s:label key="preRegVisTypeNm" /></td>
		<td class="comFormTableItemNf012"><font color="dodgerblue">（来期）<s:label key="regVisType" />：<s:label key="regVisTypeNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">経営主体</td>
	   	<td class="comFormTableItemNf012"><s:label key="preManageCd" />：<s:label key="preManageNm" /></td>
		<td class="comFormTableItemNf012"><font color="dodgerblue">（来期）<s:label key="manageCd" />：<s:label key="manageNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">卸色区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preWsTypeNm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="wsTypeNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">本部一括購入</td>
	   	<td class="comFormTableItemNf012"><s:label key="preBasketPurchaseNm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="basketPurchaseNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">大学細分類</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUnivSubdivNm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="univSubdivNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">容量別実績把握病院区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preCapaTypeNm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="capaTypeNm" /></font></td>
	</tr>
  </table>
	<br/>
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable05" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--ULT施設情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ULT施設情報</td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ULT施設コード</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUltInsCd" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="ultInsCd" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ULT施設略名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preShisetsuNmRyaku" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="shisetsuNmRyaku" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ULT施設名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preShisetsuNm" /></td>
		<td class="comFormTableItemNf012"><font color="red"><s:label key="shisetsuNm" /></font></td>
	</tr>
	</table>
	<br/>
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable06" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--病床数情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 26%; height: 0px; border-width: 0px;"></td>
        <td style="width: 27%; height: 0px; border-width: 0px;"></td>
        <td style="width: 27%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">病床数情報</td>
		<td class="comFormTableItem" style="text-align : center;"><nobr>現状</nobr></td>
		<td class="comFormTableItem" style="text-align : center;"><nobr>アルトマーク病床数情報</nobr></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><nobr>（来期）病床数情報</nobr></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">基準</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCntBase" /></td>
		<td class="comFormTableItem" style="text-align : center;">&nbsp;</td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCntBase" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">結核</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt04" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt04" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt04" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">一般</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt01" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt01" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt01" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">感染症</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt05" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt05" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt05" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">精神</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt03" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt03" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt03" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">療養</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt07" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt07" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt07" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">医療療養</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt02" /></td>
		<td class="comFormTableItem" style="text-align : center;">&nbsp;</td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt02" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">介護療養</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt06" /></td>
		<td class="comFormTableItem" style="text-align : center;">&nbsp;</td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt06" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ベッド数計</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedsTot" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedsTot" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedsTot" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">医療ベッド数計</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="medBedsTot" /></td>
		<td class="comFormTableItem" style="text-align : center;">&nbsp;</td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextMedBedsTot" /></font></td>
	</tr>
	</table>
	<br/>
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable07" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--住所詳細--%>
        <s:hidden name="insAddr"/>
        <s:hidden name="insAddrKana"/>
        <%--TODO valueを子画面から取得する --%>
        <s:hidden name="addrCodePrefKana" />
        <s:hidden name="addrCodeCityKana" />
        <s:hidden name="addrDtKana" />

        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">住所詳細</td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">郵便番号</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsPcode" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="insPcode" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">JIS県名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preAddrCodePrefName" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="addrCodePrefName" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">JIS市区町村名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preAddrCodeCityName" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="addrCodeCityName" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">町名地番</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsAddrDt" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="insAddrDt" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">武田市区郡名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTkCityName" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="tkCityName" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">電話番号(代表)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsPhone1" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="insPhone1" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">電話番号(薬局/DI室)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsPhone2" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="insPhone2" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">FAX番号(代表)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsFax1" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="insFax1" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">FAX番号(薬局/DI室)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsFax2" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="insFax2" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ホームページアドレス(変更前)</td>
	   	<td class="comFormTableItemNf012" colSpan="2">
	   		<nobr>
	   		<s:label key="preInsUrl" />
	   		</nobr>
	   	</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">　　　　　　　　　　　　(変更後)</td>
	   	<td class="comFormTableItemNf012" colSpan="2">
	   		<nobr>
	   		<font color="red"><s:label key="insUrl" /></font>
	   		</nobr>
	   	</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ホームページアドレス更新日</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsUrlYmd" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="insUrlYmd" /></font></td>
	</tr>
	</table>
	<br/>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table08ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable08" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--フリー項目区分情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>フリー項目区分情報</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">DM先(TKP-LDA)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0001" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0001" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">LEUあすか</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0002" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0002" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">DM先(TKP-NSAID)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0003" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0003" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">（O：未使用）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0015" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0015" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">TRIアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0008" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0008" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">TRIアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0009" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0009" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">REMアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0004" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0004" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">REMアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0005" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0005" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ENBアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0006" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0006" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ENBアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0007" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0007" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">XELアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0010" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0010" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">XELアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0011" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0011" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ROZアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0013" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0013" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ROZアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0014" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0014" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">振替先1310</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0012" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="free0012" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table09ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable09" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--老人福祉法関連分類情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>老人福祉法関連分類情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">老人短期入所施設</td>
	   	<td class="comFormTableItemNf012"><s:label key="preWelfare02Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="welfare02Nm" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">その他</td>
	   	<td class="comFormTableItemNf012"><s:label key="preWelfare08Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="welfare08Nm" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table10ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable10" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--実績把握区分情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>実績把握区分情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T ARB ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult01Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result01Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T DPP4 ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult02Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result02Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T ω3 ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult03Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result03Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T PPI ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult04Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result04Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T 睡眠 ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult05Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result05Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T アルツハイマー ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult06Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result06Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T 骨粗鬆症 ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult07Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result07Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">REMターゲット</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult08Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result08Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">BLP未獲得市場区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult09Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result09Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">整形育成先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult10Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result10Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">TKP・MSコールUP</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult11Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result11Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ALC Core1・2('19.10)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult12Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result12Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ENT Tier1-4('19.4)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult13Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result13Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">JIA厚労省施設</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult14Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result14Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">注力先('18.12)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult15Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result15Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ENBターゲット先('19.4)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult16Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result16Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨G</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult17Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result17Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ナテグリニド繁用先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult18Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result18Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">GLUターゲット先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult19Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result19Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨G2</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult20Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result20Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(U:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult21Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result21Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">DOIT3</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult22Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result22Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">PCI300</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult23Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result23Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">JDEsART</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult24Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result24Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(Y:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult25Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result25Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">TAP先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult26Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result26Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">QOL2005TKP</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult27Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result27Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">TKP未獲得市場区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult28Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result28Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ACT未獲得市場区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult29Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result29Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(4:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult30Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result30Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">旧LMR</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult31Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result31Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(6:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult32Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result32Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">LEU乳癌</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult33Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result33Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ONC担当区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult34Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result34Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">RPL(CVM)担当区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult35Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result35Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(10:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult36Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="result36Nm" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{insClass == "01"}'>
	<s:hidden id="table11ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable11" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--病院設備情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>病院設備情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">内視鏡</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip01Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="equip01Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨量測定器</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip02Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="equip02Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ICD</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip03Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="equip03Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">CCU</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip07Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="equip07Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">NCU</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip09Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="equip09Nm" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023" && insClass == "01"}'>
	<s:hidden id="table12ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable12" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--市場規模情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>市場規模情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">T先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket01Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="market01Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">酸抑制剤</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket02Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="market02Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">高脂血症</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket03Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="market03Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">高血圧</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket04Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="market04Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">糖尿病</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket06Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="market06Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨粗鬆症</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket07Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="market07Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">CVMターゲット</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket09Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="market09Nm" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table13ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable13" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--医療法関連分類情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>医療法関連分類情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">社会医療法人</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMedical12Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="medical12Nm" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{insClass == "01"}'>
	<s:hidden id="table14ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable14" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--特別な機能情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>特別な機能情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">入院包括化実施病院</td>
	   	<td class="comFormTableItemNf012"><s:label key="preSpfunc01Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="spfunc01Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">救命救急センター</td>
	   	<td class="comFormTableItemNf012"><s:label key="preSpfunc03Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="spfunc03Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">大学院大学</td>
	   	<td class="comFormTableItemNf012"><s:label key="preSpfunc04Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="spfunc04Nm" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{insClass == "01"}'>
	<s:hidden id="table15ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable15" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--医療連携関連情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>医療連携関連情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">がん連携パス</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTieup10Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="tieup10Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">心疾患連携パス</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTieup11Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="tieup11Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">糖尿病連携パス</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTieup12Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="tieup12Nm" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table16ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable16" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--ユーザーコード情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>ユーザーコード情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(A:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0001Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0001Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">VCT・V先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0002Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0002Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(C:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0003Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0003Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">NEXアーリーアダプタ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0004Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0004Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>(E:未使用)</nobr></td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0005Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0005Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">テルモ・コプロ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0006Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0006Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(G:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0007Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0007Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">リュープリン・コプロ12/10</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0008Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0008Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">アクトス・コプロ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0009Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0009Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ベネット・コプロ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0010Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0010Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">グルファスト</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0011Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0011Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">リュープリンコプロ08/10</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0012Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0012Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(M:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0013Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0013Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">COP活動先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0014Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0014Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ω3製剤市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0015Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0015Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">TCB RW在籍施設</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0016Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0016Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">DPP4アーリーアダプタ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0017Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0017Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">DPP4阻害薬('16.2)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0018Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0018Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">DPP4阻害薬市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0019Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0019Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ARB/CCB配合剤市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0020Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0020Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">抗潰瘍(PPI)市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0021Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0021Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨粗鬆症市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0022Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0022Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>睡眠市場</nobr></td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0023Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0023Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">X雑・災害</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0024Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0024Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">アルツハイマー市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0025Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0025Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ARB総市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0026Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0026Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">施設責任者</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0027Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0027Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">タケプロン・コプロ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0028Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0028Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">抗潰瘍(PPI)市場('16.6)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0029Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0029Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(4:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0030Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0030Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">インフル・セオリア</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0031Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0031Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">インフル・あすか</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0032Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0032Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">マーケティングG・T</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0033Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0033Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(8:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0034Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0034Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">セルタッチ・ベネット</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0035Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0035Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(10:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0036Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0036Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">A(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0101" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0101" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">B(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0102" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0102" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">C(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0103" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0103" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">D(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0104" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0104" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">E(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0105" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0105" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">F(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0106" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0106" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">G(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0107" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0107" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">H(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0108" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0108" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">I(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0109" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0109" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">A(営業所)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0201" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0201" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">LEUターゲット先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0202" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0202" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">C(営業所)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0203" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0203" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">次期院長ターゲット先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0204" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0204" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">E(営業所)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0205" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0205" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">F:なんでもフォロー表</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0206" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="usercd0206" /></font></td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023" && insClass == "01"}'>
	<s:hidden id="table17ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable17" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--診療報酬情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem"><nobr>診療報酬情報</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">入院診療計画</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward04Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward04Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">院内感染防止対策</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward05Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward05Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">地域連携小児夜間・休日診療料1</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward08Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward08Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">小児入院医療管理料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward09Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward09Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">緩和ケア診療加算</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward18Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward18Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">短期滞在手術基本料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward21Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward21Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">在宅患者訪問診療料又は在総診</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward23Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward23Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">生活習慣病指導管理料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward25Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward25Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">慢性疼痛疾患管理料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward26Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward26Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">看護配置(有床診療所)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward27Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward27Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">老人入院基本料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward29Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward29Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">地域連携時間外診療(有無)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward35Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward35Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">地域連携診療計画管理料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward36Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward36Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">地域連携診療計画退院時指導料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward37Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward37Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">病理診断料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward44Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward44Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">急性期入院加算</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward16Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward16Nm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">急性期特定入院加算</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward17Nm" /></td>
	   	<td class="comFormTableItemNf012"><font color="red"><s:label key="reward17Nm" /></font></td>
	</tr>
	</table>
	</s:if>


  <%--コメント類 --%>
  <table id="formTable18" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--コメント--%>
        <td style="width: 650px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>申請コメント</nobr></td>
      </tr>
      <tr>
      	<s:if test='%{reqStsCd == "01"}'>
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
  <table id="formTable19" border="0" class="comPortalTable" align="center" style="width:98%;">
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
