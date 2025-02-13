<%--
/**
 * <pre>
 *  医師新規作成のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.NC101DTO"%>
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
  <title>ND011_医師新規作成</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/jgiKanren.js"></script>
  <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
  <script type="text/javascript" src="js/catHcpSoc.js"></script>
  <script type="text/javascript" src="js/catHcpPub.js"></script>
    <script>
    function register(kbn, index){
      //確定ボタン
      if (kbn == '0'){
        msgContent = '<s:property value="#session.UserInfoKey.msgMap.M0122729.msgData" />';
      } else {
        msgContent = '<s:property value="#session.UserInfoKey.msgMap.M0122730.msgData" />';
      }
       jtsRegister(kbn, index);
    }


    function comSetFormWindowInfo(){
        comSetFormWindowName('ND011');
        if (document.fm1.msgId.value == "M0001102"){
          alert('<s:property value="#session.UserInfoKey.msgMap.M0001102.msgData" />');
          return false;
        }
        if (document.fm1.msgId.value == "M0001101"){
          alert('<s:property value="#session.UserInfoKey.msgMap.M0001101.msgData" />');
          return false;
        }
      }
    </script>
</head>

<body class="comPage" onUnload="JavaScript:jmsUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">
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
    <s:hidden name="backScreenId" value="ND011" />
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
     <s:hidden name="loginJokenSetCd"/>
     <s:hidden name="loginJgiNo"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>
     <s:hidden name="shnFlg"/>


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

  <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--申請情報--%>
        <%--申請情報のHIDDEN項目--%>
        <s:hidden name="reqJgiNo"/>
        <s:hidden name="reqBrCd"/>
        <s:hidden name="reqDistCd"/>
        <s:hidden name="reqStsCd"/>
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
	      <td class="comFormTableItem"><nobr>申請者所属部署</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqShzNm"/></nobr></td>
	      <td class="comFormTableItem"><nobr>申請ステータス</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqStsNm"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>申請者</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqJgiName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>申請日時</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqYmdhms"/></nobr></td>
	  </tr>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示　申請者には非表示 -->
	  <s:if test='%{reqStsCd != null && reqStsCd != "" && !(reqStsCd == "01" || reqStsCd == "11" || reqStsCd == "03" || reqStsCd == "13") }'>
		<s:if test='%{loginJgiNo != reqJgiNo }'>
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
        <%--ULT医師情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>ULT医師情報</nobr></td>
	      <td class="comFormTableItem"><nobr>ULT医師C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="ultDocCd"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>ULT医師名(漢字)</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="ultDocNm"/></nobr></td>
	      <td class="comFormTableItem"><nobr>ULT医師名(半角カナ)</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="ultDocKana"/></nobr></td>
      </tr>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--基本情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>基本情報</nobr></td>
	      <td class="comFormTableItem"><nobr>医師／薬剤師区分<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="docType" name="docType" cssStyle="width:80pt" list ="docTypeCombo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>性別<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="sexCd" name="sexCd" cssStyle="width:80pt" list ="sexCdCombo"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医師名(漢字)姓<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="docKanjiSei" size="15" maxlength="15" /></nobr></td>
	      <td class="comFormTableItem"><nobr>医師名(漢字)名<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="docKanjiMei" size="15" maxlength="15" /></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医師名(半角カナ)姓<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="docKanaSei" size="15" maxlength="15" /></nobr></td>
	      <td class="comFormTableItem"><nobr>医師名(半角カナ)名<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="docKanaMei" size="15" maxlength="15" /></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>旧姓(漢字)姓</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="oldKanjSei" size="15" maxlength="15" /></nobr></td>
	      <td class="comFormTableItem"><nobr>改姓日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="newNameStYear" name="newNameStYear" cssStyle="width:40pt" list ="newNameStYearCombo"/>年<s:select id="newNameStMonth" name="newNameStMonth" cssStyle="width:30pt" list ="newNameStMonthCombo"/>月<s:select id="newNameStDay" name="newNameStDay" cssStyle="width:30pt" list ="newNameStDayCombo"/>日</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>旧姓(半角カナ)姓</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="oldKanaSei" size="15" maxlength="15" /></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>生年月日</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="dobYear" name="dobYear" cssStyle="width:40pt" list ="dobYearCombo"/>年<s:select id="dobMonth" name="dobMonth" cssStyle="width:30pt" list ="dobMonthCombo"/>月<s:select id="dobDay" name="dobDay" cssStyle="width:30pt" list ="dobDayCombo"/>日</nobr></td>
	      <td class="comFormTableItem"><nobr>出身地</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="homeTownCd" name="homeTownCd" cssStyle="width:80pt" list ="homeTownCdCombo"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>出身校</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="medSchoolCd" name="medSchoolCd" cssStyle="width:100pt" list ="medSchoolCdCombo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>卒年（西暦）</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="gradYear" name="gradYear" cssStyle="width:40pt" list ="gradYearCombo"/>年</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>臨床研修年（西暦）</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="emplYear" name="emplYear" cssStyle="width:40pt" list ="emplYearCombo"/>年</nobr></td>
	      <td class="comFormTableItem"><nobr>出身医局校</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="homeUnivCd" name="homeUnivCd" cssStyle="width:100pt" list ="homeUnivCdCombo"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>出身所属部科</nobr></td>
	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:jmrPopView();return false;" />
                <s:textfield name="homeDeptNm" id="homeDeptNm" size="20" maxlength="150" style="background-color:#D4D0C8"/>
                <s:hidden name="homeDeptCd" id="homeDeptCd"/>
                <a class="comMiniLink" href ="" onClick="JavaScript:defaultValue();return false;">Clear</a>
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>専門臓器</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="spLiverCd" name="spLiverCd" cssStyle="width:100pt" list ="spLiverCdCombo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>専門詳細</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="spDiseaseCd" name="spDiseaseCd" cssStyle="width:100pt" list ="spDiseaseCdCombo"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>専門追加情報</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="spComCd" size="20" maxlength="150" /></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--所属学会--%>
        <%--所属学会のHIDDEN項目--%>
        <s:hidden name="beforeHcpSocietyDataList"/>
        <s:hidden name="hcpSocietyDataChgFlg"/>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 800px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>所属学会</nobr></td>
	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="button2" value="新規作成" onClick="JavaScript:hcpSocPopup('','0');return false;" />
                </nobr>
	      </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><%-- スクロールバー用のテーブルクラスにすること --%>
              <div id="societyHeader" style="margin:0;width:800px;overflow-y:hidden;overflow-x:auto;position:relative;resize:horizontal;">
			  <table class="comCustomTable" id="formTable05">
				<tr>
			        <%-- ヘッダ行 --%>
			      <td class="comTableTitle" width="20px"><nobr>&nbsp;</nobr></td>
			      <td class="comTableTitle" width="100px"><nobr>所属学会名</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>入会年月日</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>退会年月日</nobr></td>
			      <td class="comTableTitle" width="100px"><nobr>所属役職</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>役職開始年月日</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>役職終了年月日</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>指導医取得年月日</nobr></td>
			      <td class="comTableTitle" width="20px"><nobr>所属学会指導医区分</nobr></td>
			      <td class="comTableTitle" width="20px"><nobr>所属学会認定医区分</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>指導医開始年月日</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>指導医終了年月日</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>認定医開始年月日</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>認定医終了年月日</nobr></td>
				</tr>
			    <s:iterator value="hcpSocietyDataList" status="status" var="rowBean">
			      <tr>
			        <%--所属学会データ取得項目--%>
			        <%--所属学会データ保持用のHIDDEN項目--%>
			        <s:hidden name="hcpSocietyDataList[%{#status.index}].positionCode"/>
			        <s:hidden name="hcpSocietyDataList[%{#status.index}].advisingDoctorCd"/>
			        <s:hidden name="hcpSocietyDataList[%{#status.index}].certifyingPhysicianCd"/>

			        <td><%-- アクションボタン --%>
			        <s:if test="%{reqStsCd == '' || reqStsCd == '01' || reqStsCd == '03' || reqStsCd == '13'}">
			          <nobr>
		                <a class="comMiniLink" href ="" onClick="JavaScript:hcpSocPopup('<s:property value="%{#status.index}"/>','1');return false;" >
		                  <img border="0" src="img/button_update.gif">
		                </a>
		              </nobr>
			        </s:if>
			        <s:else>
						<nobr>&nbsp;</nobr>
			        </s:else>
					</td>
					<td><nobr><s:label key="hcpSocietyDataList[%{#status.index}].medicalSocietyNm"/></nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.admissionYYYY == null || #rowBean.admissionYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].admissionYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.admissionMM == null || #rowBean.admissionMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].admissionMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.admissionDD == null || #rowBean.admissionDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].admissionDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.quitYYYY == null || #rowBean.quitYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].quitYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.quitMM == null || #rowBean.quitMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].quitMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.quitDD == null || #rowBean.quitDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].quitDD"/>
						</s:else>
					</nobr></td>
					<td><nobr><s:label key="hcpSocietyDataList[%{#status.index}].positionName"/></nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.societyPosiStYYYY == null || #rowBean.societyPosiStYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].societyPosiStYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.societyPosiStMM == null || #rowBean.societyPosiStMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].societyPosiStMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.societyPosiStDD == null || #rowBean.societyPosiStDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].societyPosiStDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.societyPosiEdYYYY == null || #rowBean.societyPosiEdYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].societyPosiEdYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.societyPosiEdMM == null || #rowBean.societyPosiEdMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].societyPosiEdMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.societyPosiEdDD == null || #rowBean.societyPosiEdDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].societyPosiEdDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.coachingAcquisiYYYY == null || #rowBean.coachingAcquisiYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingAcquisiYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.coachingAcquisiMM == null || #rowBean.coachingAcquisiMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingAcquisiMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.coachingAcquisiDD == null || #rowBean.coachingAcquisiDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingAcquisiDD"/>
						</s:else>
					</nobr></td>
					<td><nobr><s:label key="hcpSocietyDataList[%{#status.index}].advisingDoctorNm"/></nobr></td>
					<td><nobr><s:label key="hcpSocietyDataList[%{#status.index}].certifyingPhysicianNm"/></nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.coachingStYYYY == null || #rowBean.coachingStYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingStYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.coachingStMM == null || #rowBean.coachingStMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingStMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.coachingStDD == null || #rowBean.coachingStDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingStDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.coachingEdYYYY == null || #rowBean.coachingEdYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingEdYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.coachingEdMM == null || #rowBean.coachingEdMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingEdMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.coachingEdDD == null || #rowBean.coachingEdDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].coachingEdDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.certifyStYYYY == null || #rowBean.certifyStYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].certifyStYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.certifyStMM == null || #rowBean.certifyStMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].certifyStMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.certifyStDD == null || #rowBean.certifyStDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].certifyStDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.certifyEdYYYY == null || #rowBean.certifyEdYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].certifyEdYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.certifyEdMM == null || #rowBean.certifyEdMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].certifyEdMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.certifyEdDD == null || #rowBean.certifyEdDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpSocietyDataList[%{#status.index}].certifyEdDD"/>
						</s:else>
					</nobr></td>
			      </tr>
			    </s:iterator>
			  </table>
			  </div>
	      </td>
      </tr>
  </table>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable06" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--公的機関--%>
        <%--公的機関のHIDDEN項目--%>
        <s:hidden name="beforeHcpPublicDataList"/>
        <s:hidden name="hcpPublicDataChgFlg"/>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 800px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>公的機関</nobr></td>
	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="button3" value="新規作成" onClick="JavaScript:hcpPubPopup('','0');return false;" />
                </nobr>
	      </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><%-- スクロールバー用のテーブルクラスにすること --%>
              <div id="jkrHeader" style="margin:0;width:800px;overflow-y:hidden;overflow-x:auto;position:relative;">
			  <table id="formTable07">
				<tr>
			        <%-- ヘッダ行 --%>
			      <td class="comTableTitle" width="20px"><nobr>&nbsp;</nobr></td>
			      <td class="comTableTitle" width="100px"><nobr>分類区分</nobr></td>
			      <td class="comTableTitle" width="100px"><nobr>公的機関</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>公的機関開始年月日</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>公的機関終了年月日</nobr></td>
			      <td class="comTableTitle" width="100px"><nobr>公的機関役職</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>公的機関役職開始年月日</nobr></td>
			      <td class="comTableTitle" width="30px"><nobr>公的機関役職終了年月日</nobr></td>
				</tr>
			    <s:iterator value="hcpPublicDataList" status="status" var="rowBean">
			      <tr>
			        <%--公的機関データ取得項目--%>
			        <%--公的機関データ保持用のHIDDEN項目--%>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].classCategoryCd"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstitutionCd"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstPositionCd"/>

			        <td><%-- アクションボタン --%>
			        <s:if test="%{reqStsCd == '' || reqStsCd == '01' || reqStsCd == '03' || reqStsCd == '13'}">
			          <nobr>
		                <a class="comMiniLink" href ="" onClick="JavaScript:hcpPubPopup('<s:property value="%{#status.index}"/>','1');return false;" >
		                  <img border="0" src="img/button_update.gif">
		                </a>
		              </nobr>
			        </s:if>
			        <s:else>
						<nobr>&nbsp;</nobr>
			        </s:else>
					</td>
					<td><nobr><s:label key="hcpPublicDataList[%{#status.index}].classCategoryNm"/></nobr></td>
					<td><nobr><s:label key="hcpPublicDataList[%{#status.index}].pubInstitutionNm"/></nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.pubInstStYYYY == null || #rowBean.pubInstStYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstStYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.pubInstStMM == null || #rowBean.pubInstStMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstStMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.pubInstStDD == null || #rowBean.pubInstStDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstStDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.pubInstEdYYYY == null || #rowBean.pubInstEdYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstEdYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.pubInstEdMM == null || #rowBean.pubInstEdMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstEdMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.pubInstEdDD == null || #rowBean.pubInstEdDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstEdDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.pubInstPositionNm == null || #rowBean.pubInstPositionNm == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstPositionNm"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.pubInstposStYYYY == null || #rowBean.pubInstposStYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstposStYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.pubInstposStMM == null || #rowBean.pubInstposStMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstposStMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.pubInstposStDD == null || #rowBean.pubInstposStDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstposStDD"/>
						</s:else>
					</nobr></td>
					<td><nobr>
						<s:if test="%{(#rowBean.pubInstposEdYYYY == null || #rowBean.pubInstposEdYYYY == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstposEdYYYY"/>/
						</s:else>
						<s:if test="%{(#rowBean.pubInstposEdMM == null || #rowBean.pubInstposEdMM == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstposEdMM"/>/
						</s:else>
						<s:if test="%{(#rowBean.pubInstposEdDD == null || #rowBean.pubInstposEdDD == '')}">
						  &nbsp;
	                    </s:if>
	                    <s:else>
							<s:label key="hcpPublicDataList[%{#status.index}].pubInstposEdDD"/>
						</s:else>
					</nobr></td>
			      </tr>
			    </s:iterator>
			  </table>
			  </div>
	      </td>
      </tr>
  </table>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
      <table id="formTable08" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--勤務先情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>勤務先情報</nobr></td>
	      <td class="comFormTableItem"><nobr>施設<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="button2" value="選択" onClick="JavaScript:jmrPopView();return false;" />
                <s:textfield name="skInsNm" id="skInsNm" size="20" maxlength="40" style="background-color:#D4D0C8"/>
                <s:hidden name="skInsNo" id="skInsNo"/>
                <a class="comMiniLink" href ="" onClick="JavaScript:defaultValue();return false;">Clear</a>
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>大学職位</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="skUnivPosCd" name="skUnivPosCd" cssStyle="width:80pt" list ="skUnivPosCdCombo"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>所属部科<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="button3" value="選択" onClick="JavaScript:jmrPopView();return false;" />
                <s:textfield name="skDeptNm" id="skDeptNm" size="20" maxlength="40" style="background-color:#D4D0C8"/>
                <s:hidden name="skDeptCd" id="skDeptCd"/>
                <a class="comMiniLink" href ="" onClick="JavaScript:defaultValue();return false;">Clear</a>
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>役職<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="skTitleCd" name="skTitleCd" cssStyle="width:80pt" list ="skTitleCdCombo"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>勤務形態</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="skJobFrom" name="skJobFrom" cssStyle="width:80pt" list ="skJobFromCombo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>薬審メンバー区分</nobr></td>
	      <td class="comFormTableItem"><nobr><s:select id="skDcctype" name="skDcctype" cssStyle="width:80pt" list ="skDcctypeCombo"/></nobr></td>
      </tr>
  </table>
  <%--コメント類 --%>
  <table id="formTable09" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--コメント--%>
        <td style="width: 650px; height: 0px; border-width: 0px;"></td>
      </tr>
        <tr>
	      <td class="comFormTableItem"><nobr>申請コメント</nobr></td>
      </tr>
        <tr>
	      <td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="150" style="width: 650px; height: 80px;"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>審査・承認メモ</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="150" style="width: 650px; height: 80px;"/></nobr></td>
      </tr>
  </table>

  <%--ボタン類 --%>
  <table id="formTable10" border="0" class="comPortalTable" align="center" style="width:98%;">
      <tr>
        <%--勤務先情報--%>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 38%; height: 0px; border-width: 0px;"></td>
      </tr>
		<tr>
	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:hcpSocPopup('','0');return false;" />
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{loginJgiNo == reqJgiNo && reqStsCd == "01"}'>
	                <input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="JavaScript:hcpSocPopup('','0');return false;" />
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{loginJgiNo == reqJgiNo && reqStsCd == "01"}'>
	                <input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:hcpSocPopup('','0');return false;" />
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0813"}'>
					<s:if test='%{shnFlg == "1" || loginJgiNo == reqJgiNo}'>
					</s:if>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" onClick="JavaScript:hcpSocPopup('','0');return false;"  disabled/>
					<s:else>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" onClick="JavaScript:hcpSocPopup('','0');return false;" />
					</s:else>
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
               <nobr>
			   <s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01" }'>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" onClick="JavaScript:hcpSocPopup('','0');return false;"  disabled/>
			   </s:if>
				<s:else>
				   <s:if test='%{reqStsCd != null && reqStsCd != "" && !(reqStsCd == "01" || reqStsCd == "11" || reqStsCd == "03" || reqStsCd == "13") }'>
				   </s:if>
					<s:else>
						&nbsp;
					</s:else>
				</s:else>
                </nobr>
	      </td>
	  </tr>
  </table>
<%-- SUBMIT用パラメータ 終了 --%>

            </s:form>
  </table>
  <jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
