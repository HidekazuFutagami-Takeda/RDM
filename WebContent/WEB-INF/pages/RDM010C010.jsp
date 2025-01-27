<%--
/**
 * <pre>
 *  仮従業員登録画面一覧のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author BHH 張
 * @see jp.co.takeda.maps.command.jgikanren.jkrprovjgi.JkrProvJgiViewFrontCommand
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.jkr.dto.JKR090C010DTO"%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppConstant,java.util.ArrayList,java.math.BigDecimal"
  import="jp.co.takeda.jkr.util.JkrConstantsData"
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
  <title>従業員の確認・仮登録</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jkrProvJgi.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/jkrProvJgi.js"></script>
  <script type="text/javascript" src="js/jgiKanren.js"></script>
  <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
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
    </script>
</head>

<body style="overflow:hidden" class="comPage" onLoad="comSetFormWindowName('JPJ');jpjViewLoad('<s:property value="#session.UserInfoKey.msgMap.M0122702.msgData" />','<s:property value="#session.UserInfoKey.msgMap.M0122723.msgData" />','<s:property value="#session.UserInfoKey.msgMap.W0122770.msgData" />','<s:property value="%{jkrMrCatData.size()}"/>','<s:property value="%{sosCdFixFlg}" />','<s:property value="%{haitaErrFlg}" />','<s:property value="#session.UserInfoKey.msgMap.M0001102.msgData" />');">
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
    <s:hidden name="backScreenId" value="JKR010C010" />
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
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

    <s:iterator value="jkrMrCatData" status="status" var="rowBean">
      <s:hidden name="jkrMrCatData[%{#status.index}].mrCat"/>
      <s:hidden name="jkrMrCatData[%{#status.index}].mrCatName"/>
      <s:hidden name="jkrMrCatData[%{#status.index}].shokushuCd"/>
      <s:hidden name="jkrMrCatData[%{#status.index}].shokushuName"/>
      <s:hidden name="jkrMrCatData[%{#status.index}].maxRnbn"/>
    </s:iterator>


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
    <!-- 20150212 HISOL Suzuki 本番課題No.25対応 ADD START -->
    <s:hidden name="searchFromSosCdPop"/>  <!--現組織コード(ポップアップ用) -->
    <s:hidden name="searchToSosCdPop"/>    <!--新組織コード(ポップアップ用) -->
    <!-- 20150212 HISOL Suzuki 本番課題No.25対応 ADD END -->
    <!-- 20180206 HISOL Kawamoto JKR-C-005 ADD START -->
    <s:hidden id="selectedTekiyoYmd" name="selectedTekiyoYmd"/>
    <!-- 20180206 HISOL Kawamoto JKR-C-005 ADD END -->
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
  <!-- 20150212 HISOL Suzuki 本番課題No.25対応 ADD START -->
  <input type="hidden" name="sosCdToPop"             value="" />
  <input type="hidden" name="trtTntFlgPop"           value="" />
  <!-- 20150212 HISOL Suzuki 本番課題No.25対応 ADD END -->

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

  <span style="visibility:hidden;position:absolute;">
  <table id="formTableOff">
    <s:iterator value="jkrProvJgiData" status="status" var="rowBean">
      <tr>
        <%--登録データ取得項目--%>
        <%--明細データ保持用のHIDDEN項目--%>
        <s:hidden name="jkrProvJgiData[%{#status.index}].tennyu"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].viewSosName"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].jgiName"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].sosCd"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].jgiKb"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].jgiNo"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].moveFlg"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].shokushuCd"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].shokushuName"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].mrCat"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].setCd"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].cntFlg"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].toSosCd"/>
        <s:hidden name="jkrProvJgiData[%{#status.index}].toMrNo"/>
        <s:if test="%{#rowBean.jgiKb == 7}">
          <s:hidden name="jkrProvJgiData[%{#status.index}].tantoNashiOld" value="false"/>
        </s:if>
        <s:else>
          <s:if test="%{selectedJgiJoken == 'JKN0163' || selectedJgiJoken == 'JKN0162'}">
            <s:if test="%{#rowBean.setCd == 1}">
              <s:hidden name="jkrProvJgiData[%{#status.index}].tantoNashiOld" value="true"/>
            </s:if>
            <s:else>
              <s:hidden name="jkrProvJgiData[%{#status.index}].tantoNashiOld" value="false"/>
            </s:else>
          </s:if>
          <s:else>
            <s:if test="%{#rowBean.setCd == 1}">
              <s:hidden name="jkrProvJgiData[%{#status.index}].tantoNashiOld" value="true"/>
            </s:if>
            <s:else>
              <s:hidden name="jkrProvJgiData[%{#status.index}].tantoNashiOld" value="false"/>
            </s:else>
          </s:else>
        </s:else>
        <!--20150331 期末期首 本番障害対応 HISOL鈴木 ADD STRAT-->
        <s:hidden name="jkrProvJgiData[%{#status.index}].tlFlg"/>
        <!--20150331 期末期首 本番障害対応 HISOL鈴木 ADD END-->
      </tr>
    </s:iterator>
  </table>
  </span>
<%-- SUBMIT用パラメータ 終了 --%>
      <table class="comPortalTitle">
        <tr>
          <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設別担当変更"></td>
          <td class="comPortalTitle"><nobr>従業員の確認・仮登録</nobr></td>
          <td class="comPortalTitleRight"><nobr></nobr></td>
        </tr>
      </table>
      <table class="comPortalBody">
        <tr>
          <td>
            <table border=0 cellPadding=0 cellSpacing=0>
              <tr>
                <td class="comTabBgText"><nobr></nobr></td>
                <td width="100%"></td>
                <td class="comPortalControlItem" >
                  <nobr>
                  <span id="linkChgAll">
                    <a class="comLink" href="" onclick="jpjChgLink(0);return false;">担当引継ぎへ</a>
                    &nbsp;
                    <a class="comLink" href="" onclick="jpjChgLink(1);return false;">施設別・地区別（施設）担当変更へ </a>
                    <span id="linkChgDoc">
                    &nbsp;
                    <a class="comLink" href="" onclick="jpjChgLink(2);return false;">複数担当先施設の医師担当変更の処理へ </a>
                    </span>
                  </span>
                  &nbsp;
                  </nobr>
                </td>
              </tr>
            </table>
            <table border="0" cellPadding=0 cellSpacing=0 class="TabForegroundColor" width="100%">
              <tr><td style="background-color:#336699;height:2pt;"></td></tr>
            </table>
            <table class="comPortalControlTable" style="margin-top:3pt;margin-bottom:1pt;">
              <tr>
                <td class="comTableSearchItem" style="width:30pt;">
                  <nobr>組織</nobr>
                </td>
                <td class="comPortalControlItem">
                  <nobr>
                  <s:if test="%{showFlg == 1}">
                    <input class="comButton" type="button" style="" name="bSosJgiFrom" value="選択" onclick="jpjCseView('gCseViewSelectWin','','','');"/>
                  </s:if>
                    <s:textfield name="searchSosName" size="50" maxlength="50" style="background-color:#D4D0C8" readonly="true" />
                    <s:hidden name="searchSosCd" />

                  <s:if test="%{showFlg == 1}">
                    <%-- 既定値に戻す --%>
                    <a class="comMiniLink" href ="#" onclick="jpjFromCseViewDef();return false;">既定値に戻す</a>
                    <%-- クリア --%>
                    <a href="#" class="comMiniLink" onclick="jpjClear();return false;">clear</a>
                  </s:if>
                  </nobr>
                </td>
                                <td class="comPortalControlItem" colspan="2" style="text-align:left; width:600px;">
                                    <nobr>
                  <s:if test="%{showFlg == 1}">
                                        <input type="button" name="search" value="表示" onClick="jpjSearch();">
                                        &nbsp; <a href="" class="comMiniLink" onClick="jpjViewInit();return false;">表示リセット</a>
                                    </s:if>
                                    </nobr>
                                </td>
              </tr>
            </table>
            <table width="100%" style="margin-top:3pt;margin-bottom:1pt;">
              <tr>
                <%-- MR種類 --%>
                <td class="comTableSearchItem" style="width:160pt;"  rowspan="2">
                    <table width="110%" style="border-style:solid;border-width:1px">
                        <tr>
                            <td class="comPortalControlItem">
                                                <nobr>従業員追加</nobr>
                                            </td>
                                        </tr>
                        <tr>
                            <td class="comPortalControlItem" style="text-align:right;">
                                <nobr>MR種類</nobr>
                                <s:if test="%{jkrMrCatData.size() > 1}">
                                  <s:if test="%{showFlg == 1}">
                                    <s:select style="width:100px" name="searchMrCat" list="jkrMrCatData" listKey="mrCat" listValue="mrCatName" headerKey="" headerValue="" />
                                  </s:if>
                                  <s:else>
                                    <s:select style="width:100px" name="searchMrCat" list="jkrMrCatData" listKey="mrCat" listValue="mrCatName" headerKey="" headerValue=""/>
                                  </s:else>
                                </s:if>
                                <s:else>
                                  <s:if test="%{jkrMrCatData.size() == 1}">
                                    <s:textfield size="20" name="searchMrCatName" value="%{jkrMrCatData.get(0).mrCatName}" style="background-color:#D4D0C8" readonly="true"/>
                                    <s:hidden name="searchMrCat" value="%{jkrMrCatData.get(0).mrCat}" />
                                  </s:if>
                                  <s:else>
                                    <s:textfield size="20" name="searchMrCatName" value="" style="background-color:#D4D0C8" readonly="true"/>
                                    <s:hidden name="searchMrCat" value="" />
                                  </s:else>
                                </s:else>
                                <s:if test="%{searchBumonRank == 3}">
                                                  <span id="jgiAdd"><input type="button"  class="comButton" value="追加" OnClick="jpjAddCseView('gCseView SelectWin','<s:property value="%{searchSosCd}"/>','<s:property value="%{searchSosCd}"/>','<s:property value="%{jkrProvJgiData.size()}"/>');"></span>
                                                </s:if>
                                                <s:else>
                                                  <span id="jgiAdd"><input type="button"  class="comButton" value="追加" OnClick="jpjaddOff(1,'<s:property value="%{jkrProvJgiData.size()}"/>', '<s:property value="%{searchSosCd}"/>', '<s:property value="%{sosRyakuName}"/>' );"></span>
                                                </s:else>

                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                </td>
                                <td class="comPortalControlItem" colspan="2" style="text-align:right;width:600px;">
                <s:if test="lineCntAll > 0">
                                    <span id="register"><input type="button"  class="comButton" value="登録する" <%=strRegDisabled %> OnClick="JavaScript:jpjRegistCheckIt('<s:property value="#session.UserInfoKey.msgMap.M0122701.msgData" />');"></span>
                </s:if>
                <s:else>
                  <span id="register"><input type="button"  class="comButton" value="登録する" disabled></span>
                </s:else>
                                </td>
              </tr>
                            <tr>
                            <td>
                            </td>

                            <td style="text-align:left;width:200px;" >
                               <%-- <font color="blue"> <nobr>担当先なしを変更する場合は業務センターへ連絡してください。</nobr></font> --%>
                               <font color="blue"> <nobr>担当先なしを変更する場合はＣＢＣ業務Ｇへ連絡してください。</nobr></font>
                            </td>
                            <td style="text-align:right;padding-top:8px;padding-right:10px;width:200px;">
                                    <nobr>
                                        <jsp:include page="common/jkrPage.jsp">
                                          <jsp:param name="showtReloadFlg" value="0" />
                                        </jsp:include>
                                    </nobr>
                            </td>
                            </tr>
            </table>
<!-- 一覧表示 START -->
            <table class="comPortalControlTable" style="margin-top:3pt;margin-bottom:1pt;"border="0">
              <tr>
                <td valign="top" align="left" style="padding-left:5px;">
                  <table cellpadding="2" cellspacing="0" border="0" >
                  <tbody>
                    <tr>
                      <td valign="top" style="padding:0pt;margin:0pt;">
                        <div id="insHeaderOff" style="width:966px;overflow:hidden;position:relative;">
                          <table cellpadding="2" cellspacing="0" border="0"style="table-layout:fixed;">
                          <tbody>
                            <tr>
                              <!-- レイアウト用 -->
                              <td style="width: 60px;height:0px;border-width:0px;"></td>
                              <td style="width: 60px;height:0px;border-width:0px;"></td>
                              <td style="width:380px;height:0px;border-width:0px;" ></td>
                              <td style="width:290px;height:0px;border-width:0px;" ></td>
                              <td style="width: 80px;height:0px;border-width:0px;"></td>
                              <td style="width: 80px;height:0px;border-width:0px;"></td>
                            </tr>
                            <tr>
                              <!-- タイトル -->
                              <td class="comTableTitle">削除</td>
                              <td class="comTableTitle">転入</td>
                              <td class="comTableTitle" ><nobr>組織名<a class="comTableNoSort" href="#" OnClick="JavaScript:pltSort('2')">▲</a>
                <span style="font-size:1pt;"> </span> <a class="comTableSort" href="#" OnClick="JavaScript:pltSort('3')">▼</a>
                              </nobr></td>

                              <td class="comTableTitle" ><nobr>従業員名<a class="comTableNoSort" href="#" OnClick="JavaScript:pltSort('4')">▲</a>
                <span style="font-size:1pt;"> </span> <a class="comTableSort" href="#" OnClick="JavaScript:pltSort('5')">▼</a>
                              </nobr></td>
                              <td class="comTableTitle"><nobr>担当先なし</nobr></td>
                              <td class="comTableTitle"><nobr>職種</nobr></td>
                            </tr>
                          </tbody>
                          </table>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                  </table>
                </td>
              </tr>
              <tr>
                <td valign="top" align="left" style="padding-left:5px;padding-top:0px;">
                  <table cellpadding="0" cellspacing="0" border="0">
                    <!-- ダミーでスクロール調整基準用の行 -->
                    <tr>
                      <td>
                        <div id="insTitleOff" style="height:000px;overflow:hidden;position:relative;">
                          <table cellpadding="0" cellspacing="0" border="0">
                            <tr>
                              <td></td>
                            </tr>
                          </tbody>
                          </table>
                        </div>
                      </td>
                      <!-- スクロールバーの設定 -->
                      <td valign="top"  style = "padding:0pt;margin:0pt;">
                        <div id="insTableDataOff" style="width:966px;height:250px;overflow:auto;overflow-x:hidden;" onscroll="javascript:jpjOffSyncScrolling()" >
                            <table cellpadding="2" cellspacing="0" border="0"style="table-layout:fixed;" id="Table2">
                            <tbody>
                              <tr>
                                <td style="width: 60px;height:0px;border-width:0px;"></td>
                                <td style="width: 60px;height:0px;border-width:0px;"></td>
                                 <td style="width:380px;height:0px;border-width:0px;"></td>
                                 <td style="width:290px;height:0px;border-width:0px;"></td>
                                <td style="width: 80px;height:0px;border-width:0px;"></td>
                                <td style="width: 80px;height:0px;border-width:0px;"></td>
                              </tr>
                              <s:iterator value="jkrProvJgiData" status="status" var="rowBean">

                              <%--表示行　異動フラグ = '1'(医営本転入) or '3'(医営本内異動)の場合 転入--%>
                              <s:if test="%{#rowBean.moveFlg == 1 || #rowBean.moveFlg == 3}">
                                                                    <tr>
                                                                        <td class="comTableItem" style="background-color:#AFEEEE" id="center" ><span id="delCheckID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].delCheck" disabled="true" /></span></td>
                                                                        <td class="comTableItem" style="background-color:#AFEEEE" id="center" ><s:label key="jkrProvJgiData[%{#status.index}].tennyu" /></td>
                                                                        <td class="comTableItem" style="background-color:#AFEEEE" id="left" ><s:label key="jkrProvJgiData[%{#status.index}].viewSosName" /></td>
                                                                        <td class="comTableItem" style="background-color:#AFEEEE" id="left" ><s:label key="jkrProvJgiData[%{#status.index}].jgiName" /></td>
                                                                        <%--本部権限--%>

                                                                        <s:if test="%{selectedJgiJoken == 'JKN0163' || selectedJgiJoken == 'JKN0162'}">
                                                                            <s:if test="%{#rowBean.setCd == 1}">
                                                                                <td class="comTableItem" style="background-color:#AFEEEE" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" OnClick="JavaScript:jpjTantouCheck('%{#session.UserInfoKey.msgMap.M0122726.msgData}', '%{#rowBean.cntFlg}',this,'%{#status.index}');" checked="true" /></span></td>
                                                                            </s:if>
                                                                          <s:else>
                                                                             <td class="comTableItem" style="background-color:#AFEEEE" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" OnClick="JavaScript:jpjTantouCheck('%{#session.UserInfoKey.msgMap.M0122726.msgData}', '%{#rowBean.cntFlg}',this,'%{#status.index}');" /></span></td>
                                                                          </s:else>
                                                                        </s:if>
                                                                        <s:else>
                                                                            <s:if test="%{#rowBean.setCd == 1}">
                                                                                <td class="comTableItem" style="background-color:#AFEEEE" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" disabled="true" checked="true" /></span></td>
                                                                            </s:if>
                                                                            <s:else>
                                                                                <td class="comTableItem" style="background-color:#AFEEEE" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" disabled="true" /></span></td>
                                                                            </s:else>
                                                                        </s:else>
                                                                        <td class="comTableItem" style="background-color:#AFEEEE" id="center" ><s:label key="jkrProvJgiData[%{#status.index}].shokushuName" /></td>
                                                                    </tr>
                              </s:if>
                              <s:else>
                                     <%--表示行　仮従業員--%>
                                <s:if test="%{#rowBean.jgiKb == 7}">
                                    <tr>
                                                                        <td class="comTableItem" style="background-color:#FFFF66" id="center" ><span id="delCheckID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].delCheck" onclick="jpjDelTantouCheck('%{#session.UserInfoKey.msgMap.M0122725.msgData}', '%{#rowBean.cntFlg}',this);" /></span></td>
                                                                        <td class="comTableItem" style="background-color:#FFFF66" id="center" ><s:label key="jkrProvJgiData[%{#status.index}].tennyu" /></td>
                                                                        <td class="comTableItem" style="background-color:#FFFF66" id="left" ><s:label key="jkrProvJgiData[%{#status.index}].viewSosName" /></td>
                                                                        <td class="comTableItem" style="background-color:#FFFF66" id="left" ><div><span style="width:100px"><s:label key="jkrProvJgiData[%{#status.index}].jgiName" /></span><span>&nbsp&nbsp→&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' class='comlink' onclick="jgiCseView('gCseViewToJgiWin','<s:property value="%{searchSosCd}"/>','<s:property value="%{#status.index}"/>');" id="mrName<s:property value="%{#status.index}"/>">振替担当者</a>&nbsp;&nbsp;<a href='#' class='comMiniLink' onclick='jpjJgiNoClear(<s:property value="%{#status.index}"/>);return false;' id="clear<s:property value="%{#status.index}"/>"></a></span></div></td>
                                                                        <td class="comTableItem" style="background-color:#FFFF66" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" disabled="true" /></span></td>
                                                                        <td class="comTableItem" style="background-color:#FFFF66" id="center" ><s:label key="jkrProvJgiData[%{#status.index}].shokushuName" /></td>
                                                                    </tr>
                                                              </s:if>
                                  <s:else>
                                       <%--表示行　通常ＭＲ--%>
                                                                    <tr>
                                                                        <td class="comTableItem" id="center" ><span id="delCheckID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].delCheck" disabled="true" /></span></td>
                                                                        <td class="comTableItem" id="center" >&nbsp;</td>
                                                                        <td class="comTableItem" id="left" ><s:label key="jkrProvJgiData[%{#status.index}].viewSosName" /></td>
                                                                        <td class="comTableItem" id="left" ><s:label key="jkrProvJgiData[%{#status.index}].jgiName" /></td>
                                                                        <%--本部権限--%>

                                                                        <s:if test="%{selectedJgiJoken == 'JKN0163' || selectedJgiJoken == 'JKN0162'}">
                                                                            <s:if test="%{#rowBean.setCd == 1}">
                                                                                <td class="comTableItem" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" OnClick="JavaScript:jpjTantouCheck('%{#session.UserInfoKey.msgMap.M0122726.msgData}', '%{#rowBean.cntFlg}',this,'%{#status.index}');" checked="true" /></span></td>
                                                                            </s:if>
                                                                          <s:else>
                                                                             <td class="comTableItem" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" OnClick="JavaScript:jpjTantouCheck('%{#session.UserInfoKey.msgMap.M0122726.msgData}', '%{#rowBean.cntFlg}',this,'%{#status.index}');" /></span></td>
                                                                          </s:else>
                                                                        </s:if>
                                                                        <s:else>
                                                                            <s:if test="%{#rowBean.setCd == 1}">
                                                                                <td class="comTableItem" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" disabled="true" checked="true" /></span></td>
                                                                            </s:if>
                                                                            <s:else>
                                                                                <td class="comTableItem" id="center" ><span id="hurikeID<s:property value="%{#status.index}"/>"><s:checkbox name="jkrProvJgiData[%{#status.index}].tantoNashi" disabled="true" /></span></td>
                                                                            </s:else>
                                                                        </s:else>
                                                                        <td class="comTableItem" id="center" ><s:label key="jkrProvJgiData[%{#status.index}].shokushuName" /></td>
                                                                    </tr>
                                  </s:else>
                              </s:else>
                              </s:iterator>
                            </tbody>
                            </table>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
<!-- 一覧表示 END -->
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
