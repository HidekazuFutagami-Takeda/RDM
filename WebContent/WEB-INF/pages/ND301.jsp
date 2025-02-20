<%--
/**
 * <pre>
 *  医師新規作成 - 申請内容確認のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND311DTO"%>
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
  <title>ND301_医師新規作成 - 申請内容確認</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/ND301.js"></script>
    <script>
    destructMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';
    function backFnc(reqId){
    	if(window.confirm(destructMsg.replace("（遷移元）", '医師新規作成'))){
    		document.fm1.screenId.value="ND011";
			document.fm1.functionId.value="Init";
			document.fm1.reqId.value=reqId;
			comSubmitForAnyWarp(fm1);
    	}
    }
    function register(kbn){
      //区分 0:申請,1:承認,2:却下
      //確定ボタン
      if (kbn == '0'){//I015	申請します。よろしいですか？
        msgContent = '<s:property value="#session.UserInfoKey.msgMap.I015.msgData" />';
      }
      if (kbn == '1'){//I012	申請データを承認します。よろしいですか？
          msgContent = '<s:property value="#session.UserInfoKey.msgMap.I012.msgData" />';
      }
      if (kbn == '2'){//I009	申請データを却下します。よろしいですか？
          msgContent = '<s:property value="#session.UserInfoKey.msgMap.I009.msgData" />';
      }
      nd301Register(kbn);
    }

    function nd301Register(buttonFlg){
   	  // 確認メッセージ表示
   	  if (confirm(msgContent)){
   	  } else {
   	    return false;
   	  }

   	  document.fm1.buttonFlg.value = buttonFlg;
   	  document.fm1.screenId.value = 'ND301';
   	  document.fm1.functionId.value = 'Register';

   	  //イベント呼び出し
   	  comSubmitForAnyWarp(fm1);
   	}

    function comSetFormWindowInfo(){
//         comSetFormWindowName('ND011');
//         if (document.fm1.msgId.value == "M0001102"){
//           alert('<s:property value="#session.UserInfoKey.msgMap.M0001102.msgData" />');
//           return false;
//         }
//         if (document.fm1.msgId.value == "M0001101"){
//           alert('<s:property value="#session.UserInfoKey.msgMap.M0001101.msgData" />');
//           return false;
//         }
//         return false;
      }
    </script>
</head>

<body class="comPage" onLoad="JavaScript:comSetFormWindowInfo();">
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

<%--     組織・従業員選択ポップアップ用 --%>
<!--     <input type="hidden" name="selectFlg"			value="" /> -->
<!--     <input type="hidden" name="topSosCd"			value="" /> -->
<!--     <input type="hidden" name="initSosCd"			value="" /> -->
<!--     <input type="hidden" name="openBumonRank"		value="" /> -->
<!--     <input type="hidden" name="objData"				value="" /> -->
<!--     <input type="hidden" name="dspSelPtn"			value="" /> -->
<!--     <input type="hidden" name="dspSelSos"			value="" /> -->
<!--     <input type="hidden" name="sosLevelType"		value="" /> -->
<!--     <input type="hidden" name="dispJgiKb"			value="" /> -->
<!--     <input type="hidden" name="shokushuCd"			value="" /> -->
<!--     <input type="hidden" name="shokuseiCd"			value="" /> -->
<!--     <input type="hidden" name="noDispJgiKb"			value="" /> -->
<!--     <input type="hidden" name="noShokushuCd"		value="" /> -->
<!--     <input type="hidden" name="noShokuseiCd"		value="" /> -->
<!--     <input type="hidden" name="insNo1"				value="" /> -->
<%--     <input type="hidden" name="dspClrBtn1"			value="" />クリアボタン表示フラグ  --%>
<!--     <input type="hidden" name="openJgiFlg"			value="" /> -->
<!--     <input type="text" name="sosSelFlg1"	value="" /> -->

<!--     <input type="checkbox" name="delCheck" /> -->
<!--     <input type="checkbox" name="hurikaeMr" /> -->
<!--     <input type="checkbox" name="shokiHurikaeMr" /> -->

<%--     組織・従業員選択ポップアップの表示判断の条件 取得パラメータ：（MR種類・業務種類） --%>
<!--     <input type="hidden" name="mrCat"				value=""	/> -->
<!--     <input type="hidden" name="registCat"			value=""	/> -->

<%--     登録：排他処理用データ --%>
<!--     <input type="hidden" name="ExUpDate"			value=""	/> -->

<!--     <input type="text" name="userAuth1"		value="" /> -->
<!--     <input type="text" name="jpjJgiNo1"		value="" /> -->
<!--     <input type="text" name="sosCd1"		value="" /> -->
<!--     <input type="text" name="sosName1"		value="" /> -->
<!--     <input type="text" name="mrCat1"		value="" /> -->
<!--     <input type="text" name="registCat1"	value="" /> -->
<!--     <input type="text" name="jgiKb1"		value="" /> -->
<!--     <input type="text" name="selectedSosName1"	value="" /> -->
<!--     <input type="text" name="selectedSosCd1"	value="" /> -->
<!--     <input type="text" name="jgiJoken1"		value="" /> -->
<!--     <input type="text" name="sosName1"		value="" /> -->
<!--     <input type="text" name="wkCat1"		value="" /> -->
<!--     <input type="hidden" name="searchToSosCd1"		value="" /> -->
<!--     <input type="hidden" name="searchToSosName1"	value="" /> -->
<!--     <input type="hidden" name="shokikaSosName1"	value="" /> -->
<!--     <input type="hidden" name="shokikaSosCd1"	value="" /> -->

<%--     <input type="hidden" name="selectedPlanSosName1"		value="<bean:print name="menudata" property="selectedSosName"/>" /> --%>

<%--     登録前の最終総行数 --%>
<!--     <input type="hidden" name="allUltCount1"	value="" /> -->
<%--     登録前の追加の総行数 --%>
<!--     <input type="hidden" name="addUltCount1"	value="" /> -->

<%--     追加用　MR種類 --%>
<!--     <input type="hidden" name="takeMrCat"	value="" /> -->

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
    <s:hidden name="backScreenId" value="ND301" />
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
     <s:hidden name="loginJokenSetCd"/>
     <s:hidden name="loginJgiNo"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>
     <s:hidden name="shnFlg"/>
     <s:hidden name="msgId" value="%{msgId}"/>

<%--     <s:hidden name="defaultSosCd"/> --%>
<%--     <s:hidden name="defaultSosName"/> --%>
<%--     <s:hidden name="defaultBumonRank"/> --%>
<%--     <s:hidden name="defaultMrCat"/> --%>
<%--     <s:hidden name="searchBumonRank"/> --%>
<%--     <s:hidden name="maxUpDate"/> --%>
<%--     <s:hidden name="sosCdFixFlg"/> --%>
<%--     <s:hidden name="sosCdFix"/> --%>
<%--     <s:hidden name="sosNameFix"/> --%>
<%--     <s:hidden name="showFlg"/> --%>
<%--     <s:hidden name="showDocChgFlg"/> --%>
<%--     <s:hidden name="sosSelFlg"/> --%>
<%--     <s:hidden name="sosRyakuName"/> --%>


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
<%--     組織ポップアップ用パラメータ --%>
<!--     <input type="hidden" name="selectFlgPop"           value="" /> -->
<!--   <input type="hidden" name="initSosCdPop"           value="" /> -->
<!--   <input type="hidden" name="sosKbnPop"              value="" /> -->
<!--   <input type="hidden" name="sknnFlgPop"             value="" /> -->
<!--   <input type="hidden" name="insFlgPop"              value="" /> -->
<!--   <input type="hidden" name="topMenuFlgPop"          value="" /> -->
<!--   <input type="hidden" name="authorityPop"           value="" /> -->
<!--   <input type="hidden" name="bumonRankTopPop"        value="" /> -->
<!--   <input type="hidden" name="bumonRankBtmPop"        value="" /> -->
<!--   <input type="hidden" name="topSosCdPop"            value="" /> -->
<!--   <input type="hidden" name="defTblFlgPop"           value="" /> -->
<%--   <input type="hidden" name="actSosListPop"          value="<s:property value="%{sosCdHairetu}"/>" /> --%>
<!--   <input type="hidden" name="shokushuFlgPop"         value="" /> -->
<!--   <input type="hidden" name="ztTntFlgPop"            value="" /> -->
<!--   <input type="hidden" name="jokenSetCdPop"          value="" /> -->
<!--   <input type="hidden" name="menuTrtGrpCdPop"        value="" /> -->
<!--   <input type="hidden" name="menuSosCdPop"           value="" /> -->
<!--   <input type="hidden" name="selectableBumonrankPop" value="" /> -->
<!--   <input type="hidden" name="insNoPop"               value="" /> -->
<!--   <input type="hidden" name="trtCdPop"               value="" /> -->
<!--   <input type="hidden" name="sosCdFromPop"           value="" /> -->
<!--   <input type="hidden" name="krJgiNoDispFlgPop"      value="" /> -->
<!--   <input type="hidden" name="sosCdToPop"             value="" /> -->
<!--   <input type="hidden" name="trtTntFlgPop"           value="" /> -->

<!--   <!-- 選択された組織情報格納（表示押下前） --> -->
<%--   <s:hidden name="topChgSosCd" value=""/> --%>
<%--   <s:hidden name="topChgSosNm" value=""/> --%>
<%--   <s:hidden name="topChgSosCd2" value=""/> --%>
<%--   <s:hidden name="topChgSosNm2" value=""/> --%>
<%--   <s:hidden name="topChgSosCd3" value=""/> --%>
<%--   <s:hidden name="topChgSosNm3" value=""/> --%>
<!--   <!-- 選択された組織情報格納（表示押下後） --> -->
<%--   <s:hidden name="topChangedSosCd" /> --%>
<%--   <s:hidden name="topChangedSosNm" /> --%>
<%--   <s:hidden name="topChangedSosCd2" /> --%>
<%--   <s:hidden name="topChangedSosNm2" /> --%>
<%--   <s:hidden name="topChangedSosCd3" /> --%>
<%--   <s:hidden name="topChangedSosNm3" /> --%>

<%--     所属学会ポップアップ用パラメータ --%>
<!--     <input type="hidden" name="hcpSocietyDataChgFlg" value="" /> -->
<!--     <input type="hidden" name="positionCodePop" value="" /> -->
<!-- 	<input type="hidden" name="advisingDoctorCdPop" value="" /> -->
<!-- 	<input type="hidden" name="certifyingPhysicianCdPop" value="" /> -->
<!-- 	<input type="hidden" name="medicalSocietyNmPop" value="" /> -->
<!-- 	<input type="hidden" name="admissionYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="admissionMMPop" value="" /> -->
<!-- 	<input type="hidden" name="admissionDDPop" value="" /> -->
<!-- 	<input type="hidden" name="quitYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="quitMMPop" value="" /> -->
<!-- 	<input type="hidden" name="quitDDPop" value="" /> -->
<!-- 	<input type="hidden" name="positionNamePop" value="" /> -->
<!-- 	<input type="hidden" name="societyPosiStYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="societyPosiStMMPop" value="" /> -->
<!-- 	<input type="hidden" name="societyPosiStDDPop" value="" /> -->
<!-- 	<input type="hidden" name="societyPosiEdYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="societyPosiEdMMPop" value="" /> -->
<!-- 	<input type="hidden" name="societyPosiEdDDPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingAcquisiYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingAcquisiMMPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingAcquisiDDPop" value="" /> -->
<!-- 	<input type="hidden" name="advisingDoctorNmPop" value="" /> -->
<!-- 	<input type="hidden" name="certifyingPhysicianNmPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingStYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingStMMPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingStDDPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingEdYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingEdMMPop" value="" /> -->
<!-- 	<input type="hidden" name="coachingEdDDPop" value="" /> -->
<!-- 	<input type="hidden" name="certifyStYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="certifyStMMPop" value="" /> -->
<!-- 	<input type="hidden" name="certifyStDDPop" value="" /> -->
<!-- 	<input type="hidden" name="certifyEdYYYYPop" value="" /> -->
<!-- 	<input type="hidden" name="certifyEdMMPop" value="" /> -->
<!-- 	<input type="hidden" name="certifyEdDDPop" value="" /> -->
<%-- 	<%-- 公的機関ポップアップ用パラメータ --%> --%>
<!-- 	<input type="hidden" name="hcpPublicDataChgFlg" value="" /> -->
<!--     <input type="hidden" name="classCategoryCdPop" value="" /> -->
<!--     <input type="hidden" name="pubInstitutionCdPop" value="" /> -->
<!--     <input type="hidden" name="pubInstPositionCdPop" value="" /> -->
<!--     <input type="hidden" name="classCategoryNmPop" value="" /> -->
<!--     <input type="hidden" name="pubInstitutionNmPop" value="" /> -->
<!--     <input type="hidden" name="pubInstStYYYYPop" value="" /> -->
<!--     <input type="hidden" name="pubInstStMMPop" value="" /> -->
<!--     <input type="hidden" name="pubInstStDDPop" value="" /> -->
<!--     <input type="hidden" name="pubInstEdYYYYPop" value="" /> -->
<!--     <input type="hidden" name="pubInstEdMMPop" value="" /> -->
<!--     <input type="hidden" name="pubInstEdDDPop" value="" /> -->
<!--     <input type="hidden" name="pubInstPositionNmPop" value="" /> -->
<!--     <input type="hidden" name="pubInstposStYYYYPop" value="" /> -->
<!--     <input type="hidden" name="pubInstposStMMPop" value="" /> -->
<!--     <input type="hidden" name="pubInstposStDDPop" value="" /> -->
<!--     <input type="hidden" name="pubInstposEdYYYYPop" value="" /> -->
<!--     <input type="hidden" name="pubInstposEdMMPop" value="" /> -->
<!--     <input type="hidden" name="pubInstposEdDDPop" value="" /> -->
<!-- ボタン制御用 -->
    <s:hidden name="buttonFlg" />
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
        <s:hidden name="ultDocNo"/>
        <s:hidden name="reqShzNm"/>
        <s:hidden name="reqStsNm"/>
        <s:hidden name="reqJgiName"/>
        <s:hidden name="reqYmdhms"/>
        <s:hidden name="shnShaName"/>
        <s:hidden name="shnYmdhms"/>
        <s:hidden name="aprShaName"/>
        <s:hidden name="aprYmdhms"/>
        <s:hidden name="ultDocNm"/>
        <s:hidden name="ultDocKana"/>
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
	      <td class="comFormTableItem"><nobr><s:label key="ultDocNo"/></nobr></td>
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
	      <td class="comFormTableItem"><nobr>医師／薬剤師区分</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="docTypeNm"/>
			  <s:hidden name="docType"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>性別</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="sexNm"/>
			  <s:hidden name="sexCd"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医師名(漢字)姓</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="docKanjiSei"/>
			  <s:hidden name="docKanjiSei"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>医師名(漢字)名</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="docKanjiMei"/>
			  <s:hidden name="docKanjiMei"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医師名(半角カナ)姓</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="docKanaSei"/>
			  <s:hidden name="docKanaSei"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>医師名(半角カナ)名</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="docKanaMei"/>
			  <s:hidden name="docKanaMei"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>旧姓(漢字)姓</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="oldKanjSei"/>
			  <s:hidden name="oldKanjSei"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>改姓日</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="newNameStYear"/>年<s:label key="newNameStMonth"/>月<s:label key="newNameStDay"/>日
			  <s:hidden name="newNameStYear"/><s:hidden name="newNameStMonth"/><s:hidden name="newNameStDay"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>旧姓(半角カナ)姓</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="oldKanaSei"/>
			  <s:hidden name="oldKanaSei"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>生年月日</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="dobYear"/>年<s:label key="dobMonth"/>月<s:label key="dobDay"/>日
			  <s:hidden name="dobYear"/><s:hidden name="dobMonth"/><s:hidden name="dobDay"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>出身地</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="homeTownCd"/>：<s:label key="homeTownNm"/>
			  <s:hidden name="homeTownCd"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>出身校</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="medSchoolNm"/>
			  <s:hidden name="medSchoolCd"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>卒年（西暦）</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="gradYear"/>年
			  <s:hidden name="gradYear"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>臨床研修年（西暦）</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="emplYear"/>年
			  <s:hidden name="emplYear"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>出身医局校</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="homeUnivNm"/>
			  <s:hidden name="homeUnivCd"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>出身所属部科</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="homeDeptNm"/>
			  <s:hidden name="homeDeptCd"/>
          </nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>専門臓器</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="spLiverNm"/>
			  <s:hidden name="spLiverCd"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>専門詳細</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="spDiseaseNm"/>
			  <s:hidden name="spDiseaseCd"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>専門追加情報</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="spCom"/>
			  <s:hidden name="spCom"/>
	      </nobr></td>
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
<!--         <s:hidden name="hcpSocietyDataList"/>-->
<!--        <s:hidden name="beforeHcpSocietyDataList"/>-->
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 800px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>所属学会</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
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
					<s:hidden name="hcpSocietyDataList[%{#status.index}].medicalSocietyNm"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].admissionYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].admissionMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].admissionDD"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].quitYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].quitMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].quitDD"/>
<%-- 		 			<s:hidden name="hcpSocietyDataList[%{#status.index}].positionName"/>  --%>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].societyPosiStYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].societyPosiStMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].societyPosiStDD"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].societyPosiEdYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].societyPosiEdMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].societyPosiEdDD"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingAcquisiYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingAcquisiMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingAcquisiDD"/>
<%-- 					<s:hidden name="hcpSocietyDataList[%{#status.index}].advisingDoctorNm"/> --%>
<%-- 					<s:hidden name="hcpSocietyDataList[%{#status.index}].certifyingPhysicianNm"/> --%>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingStYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingStMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingStDD"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingEdYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingEdMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].coachingEdDD"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].certifyStYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].certifyStMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].certifyStDD"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].certifyEdYYYY"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].certifyEdMM"/>
					<s:hidden name="hcpSocietyDataList[%{#status.index}].certifyEdDD"/>
			        <td><%-- アクションボタン --%>
						<nobr>&nbsp;</nobr>
					</td>
					<td><nobr><s:label key="hcpSocietyDataList[%{#status.index}].medicalSocietyNm"/></nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].admissionYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].quitYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr><s:textfield name="hcpSocietyDataList[%{#status.index}].positionName" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].societyPosiStYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].societyPosiEdYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].coachingAcquisiYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].advisingDoctorNm" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].certifyingPhysicianNm" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].coachingStYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].coachingEdYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].certifyStYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpSocietyDataList[%{#status.index}].certifyEdYMD" style="border: none;" readonly="true"/>
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
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 800px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>公的機関</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
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
<%-- 			        <s:hidden name="hcpPublicDataList[%{#status.index}].classCategoryNm"/> --%>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstitutionNm"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstStYYYY"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstStMM"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstStDD"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstEdYYYY"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstEdMM"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstEdDD"/>
<%-- 			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstPositionNm"/> --%>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstposStYYYY"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstposStMM"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstposStDD"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstposEdYYYY"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstposEdMM"/>
			        <s:hidden name="hcpPublicDataList[%{#status.index}].pubInstposEdDD"/>

			        <td><%-- アクションボタン --%>
						<nobr>&nbsp;</nobr>
					</td>
					<td><nobr>
						<s:textfield name="hcpPublicDataList[%{#status.index}].classCategoryNm" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr><s:label key="hcpPublicDataList[%{#status.index}].pubInstitutionNm"/></nobr></td>
					<td><nobr>
						<s:textfield name="hcpPublicDataList[%{#status.index}].pubInstStYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpPublicDataList[%{#status.index}].pubInstEdYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpPublicDataList[%{#status.index}].pubInstPositionNm" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpPublicDataList[%{#status.index}].pubInstposStYMD" style="border: none;" readonly="true"/>
					</nobr></td>
					<td><nobr>
						<s:textfield name="hcpPublicDataList[%{#status.index}].pubInstposEdYMD" style="border: none;" readonly="true"/>
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
	      <td class="comFormTableItem"><nobr>施設</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skInsNm"/>
			  <s:hidden name="skInsNo"/>
          </nobr></td>
	      <td class="comFormTableItem"><nobr>大学職位</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skUnivPosNm"/>
			  <s:hidden name="skUnivPosCd"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>所属部科</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skDeptNm"/>
			  <s:hidden name="skDeptCd"/>
          </nobr></td>
	      <td class="comFormTableItem"><nobr>役職</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skTitleNm"/>
			  <s:hidden name="skTitleCd"/>
          </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>勤務形態</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skJobFormNm"/>
			  <s:hidden name="skJobForm"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>薬審メンバー区分</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skDcctypeNm"/>
			  <s:hidden name="skDcctype"/>
	      </nobr></td>
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
	     	<s:if test='%{reqStsCd == "01"}'>
		    	<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;" /></nobr></td>
	      	</s:if>
	      	<s:else>
	      		<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px; background-color:#D4D0C8" readonly="true"/></nobr></td>
	      	</s:else>
      </tr>
	<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0813"}'>
	      <tr>
		      <td class="comFormTableItem"><nobr>承認・却下コメント（※申請者への伝達事項）</nobr></td>
	      </tr>
	      <tr>
		      <td class="comFormTableItem"><nobr><s:textarea name="aprComment"  cols="50" rows="3" maxlength="150" style="width: 650px; height: 80px;"/></nobr></td>
	      </tr>
      </s:if>
  </table>

  <%--ボタン類 --%>
  <table id="formTable10" border="0" class="comPortalTable" align="center" style="width:98%;">
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
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backFnc('<s:property value="reqId"/>');return false;" />
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>
                <s:if test='%{loginJokenSetCd == "JKN0813" && (reqStsCd == "03" || reqStsCd == "13")}'>
                	<s:if test='%{btnEnableFlg == "1"}'>
	                	<input class="comButton" type="button"name="buttonF2" value="却下" onClick="register('2');return false;" />
	                </s:if>
	                <s:else>
	                	<input class="comButton" type="button"name="buttonF2" value="却下" disabled />
	                </s:else>
                </s:if>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
					&nbsp;
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
                <s:if test='%{loginJokenSetCd == "JKN0813" && (reqStsCd == "03" || reqStsCd == "13")}'>
                	<s:if test='%{btnEnableFlg == "1"}'>
                		<s:if test='%{reqStsCd == "03"}'>
	               			<input type="checkbox" id="fbReqFlg" name="fbReqFlg" /><label for="fbReqFlg">アルトマークへの情報連携</label>
	               		</s:if>
	                	<input class="comButton" type="button"name="buttonF3" value="承認" onClick="register('1');return false;" />
	                </s:if>
	                <s:else>
						<s:if test='%{reqStsCd == "03"}'>
							<input type="checkbox" id="fbReqFlg" name="fbReqFlg" readonly="true" /><label for="fbReqFlg">アルトマークへの情報連携</label>
						</s:if>
	                	<input class="comButton" type="button"name="buttonF3" value="承認" disabled />
	                </s:else>
                </s:if>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
               <nobr>
			   <s:if test='%{ reqStsCd == "01" }'>
                	<s:if test='%{btnEnableFlg == "1"}'>
		                <input class="comButton" type="button"name="buttonF4" value="申請" onClick="register('0');return false;" />
	                </s:if>
					<s:else>
						<input class="comButton" type="button"name="buttonF4" value="申請" disabled/>
	                </s:else>
			   </s:if>
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
