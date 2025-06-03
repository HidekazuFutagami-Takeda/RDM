<%--
/**
 * <pre>
 *  施設削除のJSP
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
  <title>NF013_施設削除</title>
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

    // 廃院日、削除区分表示設定
    function delView(){
    	const delKbn = document.fm1.delKbn.value;
    	if(delKbn == "" || delKbn == "0"){
    		document.getElementById("delYmdTr").style.visibility = "collapse";
    		document.getElementById("delReasonTr").style.visibility = "collapse";
    	} else {
    		document.getElementById("delYmdTr").style.visibility = "visible";
    		document.getElementById("delReasonTr").style.visibility = "visible";
    	}
    }

	// 重複施設表示設定
    function dupView(){
    	const delKbn = document.fm1.delKbn.value;
    	const delReason = document.fm1.delReason.value;
    	if(delKbn != "" && delKbn != "0" && delReason == "03"){
    		document.getElementById("formTable03").style.visibility = "visible";
    	} else {
    		document.getElementById("formTable03").style.visibility = "collapse";
    	}
    }

    // 初期表示処理
    function onLoadFunc(){
    	// 編集不可設定
		onLoadEditSet();

    	delView();
    	dupView();
    }

    function onLoadEditSet(){
		editFlg = document.fm1.editApprFlg.value;

		if(editFlg == "0") {
			// 削除区分
			document.fm1.delKbnView.value = document.fm1.delKbn.options[document.fm1.delKbn.selectedIndex].textContent;
			document.fm1.delKbn.hidden = "true";
			// 削除理由
			document.fm1.delReasonView.value = document.fm1.delReason.options[document.fm1.delReason.selectedIndex].textContent;
			document.fm1.delReason.hidden = "true";

		} else {
			document.fm1.delKbnView.hidden = "true";
			document.fm1.delReasonView.hidden = "true";
		}
    }

    // 施設選択ボタン
    function insPopBtn(){
		// NC203_施設検索ポップアップ画面を表示
		window.open("","insPopWindow",insSubScreenSize);
		document.fm1.screenId.value = "NC203";
		document.fm1.functionId.value="Init";
		document.fm1.target="insPopWindow";

		const pCode = document.fm1.insPcode.value;
		document.fm1.insPcode.value = "";

		document.fm1.callBack.value = "callBackInsPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();

		document.fm1.insPcode.value = pCode;
    }

	// 施設ポップアップから重複施設受け取り
    function callBackInsPop(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType, insClass){

    	document.fm1.dupInsNo.value = insNo;
    	document.fm1.dupInsAbbrName.value = insAbbrName;
    	document.fm1.dupInsAddr.value = insAddr;

    }

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
		}
	}

	// 申請破棄ボタン
	function reqCancelBtn(){
		document.fm1.target="";
		if(window.confirm("申請データを破棄します。よろしいですか？")){
		// 申請データを破棄（＝物理的に削除）し、遷移元画面へ遷移する（本画面のタブを閉じる）
		// 申請IDで対象を絞り込み申請管理、施設_申請管理、施設_領域担当者ワークを削除

			document.fm1.screenId.value="NF013";
			document.fm1.functionId.value="Cancel";

			comSubmitForAnyWarp(fm1);
		}
	}

	// 一時保存ボタン、申請画面へ、承認・却下画面へボタン
	function submitBtn(funcId){
		document.fm1.funcId.value = funcId;
		document.fm1.screenId.value="NF013";

		if(funcId == "0") {
			// 一時保存
			document.fm1.screenId.value="NF013";
			document.fm1.functionId.value="Register";
		} else {
			// 申請、承認・却下
			document.fm1.screenId.value="NF305";
			document.fm1.functionId.value="Init";

			document.fm1.delKbnNm.value = document.fm1.delKbn.options[document.fm1.delKbn.selectedIndex].textContent;
			document.fm1.delReasonNm.value = document.fm1.delReason.options[document.fm1.delReason.selectedIndex].textContent;
		}

		document.fm1.target="";
		comSubmitForAnyWarp(fm1);
	}

	// 審査完了ボタン
	function shnCompBtn(){

		document.fm1.screenId.value="NF013";
		document.fm1.functionId.value="ShnComp";

		document.fm1.target="";
		comSubmitForAnyWarp(fm1);

	}

    </script>
</head>

<body class="comPage" onUnload="JavaScript:jmsUnLoad();" onLoad="JavaScript:onLoadFunc();">
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
    <s:hidden name="backScreenId" value="NF013" />
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

	<s:hidden name="insFormalName" />
	<s:hidden name="editApprFlg"/>

	<s:hidden name="delKbnNm" />
	<s:hidden name="delReasonNm" />
	<s:hidden name="preDelKbn"/>

	<s:hidden name="addrCodePrefPop"/>
	<s:hidden name="tkCityCdPop"/>

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

  <s:hidden name="postCode" />
  <s:hidden name="kensakuInsSbt" />
  <s:hidden name="koshisetsuCheck" />
  <s:hidden name="callBack" />

  <s:hidden name="title" />

<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設削除"></td>
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

   	<table width="100%">
   		<tr>
             <td align="center">
               <jsp:include page="common/rdmMsg.jsp">
               <jsp:param name="" value="" />
               </jsp:include>
             </td>
         </tr>
      </table>

  <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--申請情報--%>
        <%--申請情報のHIDDEN項目--%>
        <s:hidden name="reqId"/>
        <s:hidden name="reqChl"/>
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
        <s:hidden name="ultInsNo"/>
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
		<s:if test='%{loginJgiNo != reqJgiNo }'>
	      <tr>
		      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		      <td class="comFormTableItem"><nobr>審査者氏名</nobr></td>
		      <td class="comFormTableItem"><nobr><s:label key="shnShaName"/></nobr></td>
		      <td class="comFormTableItem"><nobr>審査日時</nobr></td>
		      <td class="comFormTableItem"><nobr><s:label key="shnYmdhms"/></nobr></td>
		  </tr>
	  </s:if>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示 -->
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>承認者氏名</nobr></td>
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
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>施設固定コード</nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
				<s:label key="insNo" /><s:hidden name="insNo" />
			</nobr>
		  </td>
	      <td class="comFormTableItem"><nobr>施設略式漢字名</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      		<s:label key="insAbbrName" /><s:hidden name="insAbbrName" />
			</nobr>
		</td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>郵便番号</nobr></td>
	      <td class="comFormTableItem">
	      	<s:label key="insPcode" /><s:hidden name="insPcode" />
		  </td>
		  <td class="comFormTableItem" colspan=2 rowspan=2>
			<table>
				<tr>
					<td class="comFormTableItem"><nobr>医師数</nobr></td>
					<td class="comFormTableItem"><nobr>勤務中:<s:label key="docCount" /><s:hidden name="docCount" /></nobr></td>
					<td class="comFormTableItem"><nobr>施設数</nobr></td>
					<td class="comFormTableItem"><nobr>当期子施設:<s:label key="insCount" /><s:hidden name="insCount" /></nobr></td>
				</tr>
				<tr>
					<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
					<td class="comFormTableItem"><nobr>申請中:<s:label key="reqDocCount" /><s:hidden name="reqDocCount" /></nobr></td>
					<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
					<td class="comFormTableItem"><nobr>来期子施設:<s:label key="nextInsCount" /><s:hidden name="nextInsCount" /></nobr></td>
				</tr>
				<tr>
					<td class="comFormTableItem"><nobr>過去実績</nobr></td>
					<td class="comFormTableItem"><nobr><s:label key="jskValue" /><s:hidden name="jskValue" /></nobr></td>
					<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
					<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
				</tr>
			</table>
		  </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>施設住所</nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
				<s:label key="insAddr" /><s:hidden name="insAddr" />
			</nobr>
		  </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>削除区分<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
				<s:select id="delKbn" name="delKbn" cssStyle="width:150pt" list ="delKbnCombo" onchange="delView();dupView();" />
				<s:textfield id="delKbnView" name="delKbnView" cssStyle="width:150pt" readonly="true" />
			</nobr>
		  </td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr id="delYmdTr">
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>廃院日<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem" colspan=3>
	      	<nobr>
	      		<s:if test="editApprFlg == 1">
					<s:textfield type="date" name="delYmd" />　※日付不明の場合は1日を指定してください。
				</s:if>
				<s:else>
					<s:textfield type="date" name="delYmd" readonly="true" />　※日付不明の場合は1日を指定してください。
				</s:else>
			</nobr>
		  </td>
      </tr>
      <tr id="delReasonTr">
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>削除理由<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
				<s:select id="delReason" name="delReason" cssStyle="width:150pt" list ="delReasonCombo" onchange="dupView();" />
				<s:textfield id="delReasonView" name="delReasonView" cssStyle="width:150pt" readonly="true" />
			</nobr>
		  </td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 30px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
  	    <td class="comFormTableItem"><nobr>重複施設コード<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
	    		<s:if test="editApprFlg == 1">
	    			<input class="comButton" type="button"name="button2" value="選択" onClick="JavaScript:insPopBtn();return false;" />
	    		</s:if>
	    		<s:else>
	    			<input class="comButton" type="button"name="button2" value="選択" disabled />
	    		</s:else>
    		</nobr>
   		</td>
   		<td class="comFormTableItem"><nobr>
   			<s:textfield name="dupInsNo" cssClass="mediumGray" readonly="true" />
   			<s:if test="editApprFlg == 1">
				<a class="comMiniLink" href="#" onClick="JavaScript:document.fm1.dupInsNo.value='';document.fm1.dupInsAbbrName.value='';document.fm1.dupInsAddr.value='';return false;">Clear</a>
			</s:if>
		</nobr></td>
   		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
  	    <td class="comFormTableItem"><nobr>施設略式漢字名</nobr></td>
   		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
				<s:textfield name="dupInsAbbrName" cssClass="mediumGray" readonly="true" />
    		</nobr>
   		</td>
   		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
  	    <td class="comFormTableItem"><nobr>施設住所</nobr></td>
   		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem" colspan=2>
	    	<nobr>
				<s:textfield name="dupInsAddr" size="40" cssClass="mediumGray" readonly="true" />
    		</nobr>
   		</td>
      </tr>
  　　　</table>

  <%--コメント類 --%>
  <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--コメント--%>
        <td style="width: 650px; height: 0px; border-width: 0px;"></td>
      </tr>
        <tr>
	      <td class="comFormTableItem"><nobr>申請コメント</nobr></td>
      </tr>
        <tr>
	      <s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11"}'>
	      <td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/></nobr></td>
		</s:if>
		<s:else>
			<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" readonly="true"/></nobr></td>
		</s:else>
      </tr>
      <s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
      <tr>
	      <td class="comFormTableItem"><nobr>審査・承認メモ</nobr></td>
      </tr>
      <tr>
      	<s:if test='%{reqStsCd == "03" || reqStsCd == "13"}'>
	      <td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/></nobr></td>
      	</s:if>
      	<s:else>
      		<td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" readonly="true"/></nobr></td>
      	</s:else>
      </tr>
      </s:if>
  </table>

  <%--ボタン類 --%>
  <table id="formTable05" border="0" class="comPortalTable" align="center" style="width:98%;">
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
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(loginJgiNo == reqJgiNo && (reqStsCd == "01" || reqStsCd == "11")) || (loginJokenSetCd == "JKN0850" && (reqStsCd == "11" || reqStsCd == "13"))}'>
	                <input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;" />
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
					<s:if test='%{loginJgiNo == reqJgiNo && (reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11")}'>
		            	<input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" />
		            </s:if>
		            <s:elseif test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
						<input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" />
		            </s:elseif>
		            <s:elseif test='%{loginJgiNo == reqJgiNo}'>
		                <input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" disabled/>
		           	</s:elseif>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
					<s:if test='%{shnFlg == "1" || loginJgiNo == reqJgiNo}'>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" onClick="JavaScript:shnCompBtn();return false;"  disabled/>
					</s:if>
					<s:else>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" onClick="JavaScript:shnCompBtn();return false;" />
					</s:else>
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
               <nobr>
				<s:if test='%{(reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11")}'>
		                <input class="comButton" type="button"name="buttonF3" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;"/>
				</s:if>
				<s:elseif test='%{(reqStsCd == "03" || reqStsCd == "13")}'>
					<s:if test='%{(loginJokenSetCd == "JKN0850")}'>
		                <input class="comButton" type="button"name="buttonF3" value="承認・却下画面へ" onClick="submitBtn('2');JavaScript:return false;" />
					</s:if>
					<s:else>
						<input class="comButton" type="button"name="buttonF3" value="承認・却下画面へ" onClick="submitBtn('2');JavaScript:return false;" disabled />
					</s:else>
				</s:elseif>
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
