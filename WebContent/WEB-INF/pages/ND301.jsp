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

<%-- オブジェクト読み込み --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <title>ND301_医師新規作成 - 申請内容確認</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
    <script>
    destructMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';
    function backFnc(reqId){
    	//if(window.confirm(destructMsg.replace("（遷移元）", '医師新規作成'))){
    		document.fm1.screenId.value="ND011";
			document.fm1.functionId.value="Init";
			document.fm1.reqId.value=reqId;
			document.fm1.preScreenId.value="ND301";
			comSubmitForAnyWarp(fm1);
    	//}
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
    	comClickFlgInit();
      }
    </script>
</head>

<body class="comPage" onLoad="JavaScript:comSetFormWindowInfo();">
  <form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
    <input type="text" name="screenId"           value="" />
    <input type="text" name="functionId"         value="" />
    <input type="text" name="windowName"         value="" />
    <input type="text" name="openerName"         value="" />
  </form>

  <%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/rdmTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/rdmDispMsg.jsp" flush="true" />
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
     <s:hidden name="preScreenId"/>
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
     <s:hidden name="loginJokenSetCd"/>
     <s:hidden name="loginJgiNo"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>
     <s:hidden name="shnFlg"/>
     <s:hidden name="msgId" value="%{msgId}"/>

<!-- ボタン制御用 -->
    <s:hidden name="buttonFlg" />
    	<s:hidden name="title" />
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="医師新規作成 - 申請内容確認"></td>
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
			  <s:hidden name="docType"/><s:hidden name="docTypeNm"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>性別</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="sexNm"/>
			  <s:hidden name="sexCd"/><s:hidden name="sexNm"/>
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
		      <s:label key="homeTownNm"/>
			  <s:hidden name="homeTownCd"/><s:hidden name="homeTownNm"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>出身校</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="medSchoolNm"/>
			  <s:hidden name="medSchoolCd"/><s:hidden name="medSchoolNm"/>
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
			  <s:hidden name="homeUnivCd"/><s:hidden name="homeUnivNm"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>出身所属部科</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="homeDeptNm"/>
			  <s:hidden name="homeDeptCd"/><s:hidden name="homeDeptNm"/>
          </nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>専門臓器</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="spLiverNm"/>
			  <s:hidden name="spLiverCd"/><s:hidden name="spLiverNm"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>専門詳細</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="spDiseaseNm"/>
			  <s:hidden name="spDiseaseCd"/><s:hidden name="spDiseaseNm"/>
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
              <div id="rdmHeader" style="margin:0;width:800px;overflow-y:hidden;overflow-x:auto;position:relative;">
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
			  <s:hidden name="skInsNo"/><s:hidden name="skInsNm"/>
		      <s:hidden name="skInsHoInsType"/><s:hidden name="skInsInsClass"/>
          </nobr></td>
	      <td class="comFormTableItem"><nobr>大学職位</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skUnivPosNm"/>
			  <s:hidden name="skUnivPosCd"/><s:hidden name="skUnivPosNm"/>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>所属部科</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skDeptNm"/>
			  <s:hidden name="skDeptCd"/><s:hidden name="skDeptNm"/>
          </nobr></td>
	      <td class="comFormTableItem"><nobr>役職</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skTitleNm"/>
			  <s:hidden name="skTitleCd"/><s:hidden name="skTitleNm"/>
          </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>勤務形態</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skJobFormNm"/>
			  <s:hidden name="skJobForm"/><s:hidden name="skJobFormNm"/>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>薬審メンバー区分</nobr></td>
	      <td class="comFormTableItem"><nobr>
		      <s:label key="skDcctypeNm"/>
			  <s:hidden name="skDcctype"/><s:hidden name="skDcctypeNm"/>
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
	     	<s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01"}'>
		    	<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" /></nobr></td>
	      	</s:if>
	      	<s:else>
	      		<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" cssClass="mediumGray" readonly="true"/></nobr></td>
	      	</s:else>
      </tr>
	<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
	      <tr>
		      <td class="comFormTableItem"><nobr>承認・却下コメント（※申請者への伝達事項）</nobr></td>
	      </tr>
	      <tr>
		      <td class="comFormTableItem"><nobr>
		      <s:textarea name="aprComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/>
		      <s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="display:none;"/>
		      </nobr></td>
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
                <s:if test='%{loginJokenSetCd == "JKN0850" && (reqStsCd == "03" || reqStsCd == "13")}'>
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
	      <nobr>&nbsp;</nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
                <s:if test='%{loginJokenSetCd == "JKN0850" && (reqStsCd == "03" || reqStsCd == "13")}'>
                	<s:if test='%{btnEnableFlg == "1"}'>
                		<s:if test='%{reqStsCd == "03"}'>
	               			<s:checkbox name="fbReqFlg" tabIndex="-1" /><label for="fbReqFlg">アルトマークへの情報連携</label>
	               		</s:if>
	                	<input class="comButton" type="button"name="buttonF3" value="承認" onClick="register('1');return false;" />
	                </s:if>
	                <s:else>
						<s:if test='%{reqStsCd == "03"}'>
							<s:checkbox name="fbReqFlg"  tabIndex="-1" disabled="true" /><label for="fbReqFlg">アルトマークへの情報連携</label>
						</s:if>
	                	<input class="comButton" type="button"name="buttonF3" value="承認" disabled />
	                </s:else>
                </s:if>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
               <nobr>
			   <s:if test='%{reqStsCd == null || reqStsCd == "" ||  reqStsCd == "01"}'>
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

    </td>
	</tr>
    </tbody>
    </table>
            </s:form>
  </table>
  <jsp:include page="common/rdmBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
