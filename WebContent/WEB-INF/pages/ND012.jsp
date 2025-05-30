<%--
/**
 * <pre>
 *  医師情報更新のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND301DTO"%>
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
  <title>ND012_医師情報更新</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <link href="css/reqDisplay.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/jgiKanren.js"></script>
  <script type="text/javascript" src="js/catHcpSoc.js"></script>
  <script type="text/javascript" src="js/catHcpPub.js"></script>
  <script type="text/javascript" src="js/catDeptsComboRDM.js"></script>
  <script type="text/javascript" src="js/ND012.js"></script>
    <script>
    destructMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';
    function backFnc(backKbn){
    	if(backKbn == '0')	{
	    	if(window.confirm(destructMsg.replace("（遷移元）", '医師検索'))){
				//モック
// 	    		document.fm1.screenId.value="ND001";
// 	    		document.fm1.functionId.value="Init";
//   				comSubmitForAnyWarp(fm1);
				//この画面（タブ）を閉じる
				window.close();
				//元タブにフォーカス
	    	}
    	}
    	if(backKbn == '1')	{
	    	if(window.confirm(destructMsg.replace("（遷移元）", '申請一覧'))){
				//モック
// 	    		document.fm1.screenId.value="NC011";
// 	    		document.fm1.functionId.value="Init";
//   				comSubmitForAnyWarp(fm1);
				//この画面（タブ）を閉じる
				window.close();
				//元タブにフォーカス
	    	}
    	}
    	if(backKbn == '2')	{
	    	if(window.confirm("画面を閉じます。よろしいですか？")){
				//モック
// 	    		document.fm1.screenId.value="NC001";
// 	    		document.fm1.functionId.value="Init";
//   				comSubmitForAnyWarp(fm1);
				//この画面（タブ）を閉じる
				window.close();
				//元タブにフォーカス
	    	}
    	}
    }
    var nd012Tab;
    function gotoND013(){
        //gotoMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';
    	//if(window.confirm(gotoMsg.replace("（遷移元）", '医師勤務先情報更新'))){
    		document.fm1.screenId.value="ND013";
    		document.fm1.functionId.value="Init";
    		document.fm1.paramDocNo.value=document.fm1.tkdDocNo.value;

    		nd012Tab = window.open("","ND012Tab");
    		document.fm1.target="ND012Tab";

			comSubmitForAnyWarp(fm1);

			comClickFlgInit();
			document.fm1.target="";
    	//}
    }
    function register(kbn){
      //区分 0:一時保存,1:申請（一時保存チェック高),2:審査,3:承認（チェック高),4:申請破棄
      //確定ボタン
//      if (kbn == '0'){//I013	申請データを保存します。よろしいですか？
//        msgContent = '<s:property value="#session.UserInfoKey.msgMap.I013.msgData" />';
//      }
//      if (kbn == '1'){//I015	申請します。よろしいですか？
//        msgContent = '<s:property value="#session.UserInfoKey.msgMap.I015.msgData" />';
//      }
      if (kbn == '2'){//I014	ステータスを審査済みに変更します。よろしいですか？
          msgContent = '<s:property value="#session.UserInfoKey.msgMap.I014.msgData" />';
      }
//       if (kbn == '3'){//I012	申請データを承認します。よろしいですか？
//           msgContent = '<s:property value="#session.UserInfoKey.msgMap.I012.msgData" />';
//       }
      if (kbn == '4'){//I007	申請データを破棄します。よろしいですか？
          msgContent = '<s:property value="#session.UserInfoKey.msgMap.I007.msgData" />';
      }
      nd012Register(kbn);
    }


    function comSetFormWindowInfo(){
        comSetFormWindowName('ND012');
//         if (document.fm1.msgId.value == "M0001102"){
//           alert('<s:property value="#session.UserInfoKey.msgMap.M0001102.msgData" />');
//           return false;
//         }
//         if (document.fm1.msgId.value == "M0001101"){
//           alert('<s:property value="#session.UserInfoKey.msgMap.M0001101.msgData" />');
//           return false;
//         }
// 		const returnFlg = document.fm1.buttonFlg.value;
// 		if(returnFlg == "8"){//削除完了時画面を閉じろ
// // 			window.close();ではjsで開いた画面しか無理
// 		}
        return false;
      }
    </script>
    <style>
	/*テーブル幅可変*/
		TD.comTableTitle{
			resize : horizontal;
			overflow : hidden;
			}
	</style>
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
    <s:hidden name="backScreenId" value="ND011" />
     <s:hidden name="preScreenId"/>
     <s:hidden name="screenId" value="" />
     <s:hidden name="functionId"/>
     <s:hidden name="loginJokenSetCd"/>
     <s:hidden name="loginJgiNo"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>
     <s:hidden name="shnFlg"/>
     <s:hidden name="msgId" value="%{msgId}"/>

    <%-- 所属部科ポップアップ用パラメータ --%>
    <input type="hidden" name="cdcCheckedCodes" value="" />
    <input type="hidden" name="paramInsNo" value="" />

    <%-- 所属学会ポップアップ用パラメータ --%>
    <input type="hidden" name="hcpSocietyDataChgFlg" value="" />
    <input type="hidden" name="positionCodePop" value="" />
	<input type="hidden" name="advisingDoctorCdPop" value="" />
	<input type="hidden" name="certifyingPhysicianCdPop" value="" />
	<input type="hidden" name="medicalSocietyNmPop" value="" />
	<input type="hidden" name="admissionYYYYPop" value="" />
	<input type="hidden" name="admissionMMPop" value="" />
	<input type="hidden" name="admissionDDPop" value="" />
	<input type="hidden" name="quitYYYYPop" value="" />
	<input type="hidden" name="quitMMPop" value="" />
	<input type="hidden" name="quitDDPop" value="" />
	<input type="hidden" name="positionNamePop" value="" />
	<input type="hidden" name="societyPosiStYYYYPop" value="" />
	<input type="hidden" name="societyPosiStMMPop" value="" />
	<input type="hidden" name="societyPosiStDDPop" value="" />
	<input type="hidden" name="societyPosiEdYYYYPop" value="" />
	<input type="hidden" name="societyPosiEdMMPop" value="" />
	<input type="hidden" name="societyPosiEdDDPop" value="" />
	<input type="hidden" name="coachingAcquisiYYYYPop" value="" />
	<input type="hidden" name="coachingAcquisiMMPop" value="" />
	<input type="hidden" name="coachingAcquisiDDPop" value="" />
	<input type="hidden" name="advisingDoctorNmPop" value="" />
	<input type="hidden" name="certifyingPhysicianNmPop" value="" />
	<input type="hidden" name="coachingStYYYYPop" value="" />
	<input type="hidden" name="coachingStMMPop" value="" />
	<input type="hidden" name="coachingStDDPop" value="" />
	<input type="hidden" name="coachingEdYYYYPop" value="" />
	<input type="hidden" name="coachingEdMMPop" value="" />
	<input type="hidden" name="coachingEdDDPop" value="" />
	<input type="hidden" name="certifyStYYYYPop" value="" />
	<input type="hidden" name="certifyStMMPop" value="" />
	<input type="hidden" name="certifyStDDPop" value="" />
	<input type="hidden" name="certifyEdYYYYPop" value="" />
	<input type="hidden" name="certifyEdMMPop" value="" />
	<input type="hidden" name="certifyEdDDPop" value="" />
	<%-- 公的機関ポップアップ用パラメータ --%>
	<input type="hidden" name="hcpPublicDataChgFlg" value="" />
    <input type="hidden" name="classCategoryCdPop" value="" />
    <input type="hidden" name="pubInstitutionCdPop" value="" />
    <input type="hidden" name="pubInstPositionCdPop" value="" />
    <input type="hidden" name="classCategoryNmPop" value="" />
    <input type="hidden" name="pubInstitutionNmPop" value="" />
    <input type="hidden" name="pubInstStYYYYPop" value="" />
    <input type="hidden" name="pubInstStMMPop" value="" />
    <input type="hidden" name="pubInstStDDPop" value="" />
    <input type="hidden" name="pubInstEdYYYYPop" value="" />
    <input type="hidden" name="pubInstEdMMPop" value="" />
    <input type="hidden" name="pubInstEdDDPop" value="" />
    <input type="hidden" name="pubInstPositionNmPop" value="" />
    <input type="hidden" name="pubInstposStYYYYPop" value="" />
    <input type="hidden" name="pubInstposStMMPop" value="" />
    <input type="hidden" name="pubInstposStDDPop" value="" />
    <input type="hidden" name="pubInstposEdYYYYPop" value="" />
    <input type="hidden" name="pubInstposEdMMPop" value="" />
    <input type="hidden" name="pubInstposEdDDPop" value="" />
<!-- ボタン制御用 -->
    <s:hidden name="buttonFlg" />
    <s:hidden name="title" />
   	<s:hidden name="paramDocNo" />
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="医師情報更新"></td>
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
        <s:hidden name="tkdDocNo"/>
        <s:hidden name="tkdDocNm"/>
        <s:hidden name="tkdDocKana"/>
        <s:hidden name="mstDocType"/>
        <s:hidden name="mstDocTypeNm"/>
        <s:hidden name="mstSexCd"/>
        <s:hidden name="mstSexNm"/>
        <s:hidden name="mstDocKanjiSei"/>
        <s:hidden name="mstDocKanjiMei"/>
        <s:hidden name="mstDocKanaSei"/>
        <s:hidden name="mstDocKanaMei"/>
        <s:hidden name="mstOldKanjSei"/>
        <s:hidden name="mstOldKanaSei"/>
        <s:hidden name="mstNewNameStYear"/>
        <s:hidden name="mstNewNameStMonth"/>
        <s:hidden name="mstNewNameStDay"/>
        <s:hidden name="mstDobYear"/>
        <s:hidden name="mstDobMonth"/>
        <s:hidden name="mstDobDay"/>
        <s:hidden name="mstHomeTownCd"/>
        <s:hidden name="mstHomeTownNm"/>
        <s:hidden name="mstMedSchoolCd"/>
        <s:hidden name="mstMedSchoolNm"/>
        <s:hidden name="mstGradYear"/>
        <s:hidden name="mstEmplYear"/>
        <s:hidden name="mstHomeUnivCd"/>
        <s:hidden name="mstHomeUnivNm"/>
        <s:hidden name="mstHomeDeptCd"/>
        <s:hidden name="mstHomeDeptNm"/>
        <s:hidden name="mstSpLiverCd"/>
        <s:hidden name="mstSpLiverNm"/>
        <s:hidden name="mstSpDiseaseCd"/>
        <s:hidden name="mstSpDiseaseNm"/>
        <s:hidden name="mstSpCom"/>
        <s:hidden name="reqChl"/>
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
        <%--ULT医師情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>基本情報</nobr></td>
	      <td class="comFormTableItem"><nobr>医師固定C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="tkdDocNo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>武田医師名(漢字)</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="tkdDocNm"/></nobr></td>
	      <td class="comFormTableItem"><nobr>武田医師名(半角カナ)</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="tkdDocKana"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
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
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItemNd012Head"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItemNd012Head"><nobr>変更前</nobr></td>
	      <td class="comFormTableItemNd012Head"><nobr>変更後</nobr></td>
      </tr>
      <tr>
      	<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>医師／薬剤師区分</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstDocTypeNm"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	      		<s:select id="docType" name="docType" cssStyle="width:80pt" list ="docTypeCombo"/>
	      	</s:if>
	      	<s:else>
				<s:select id="docType" name="docType" cssStyle="width:80pt" list ="docTypeCombo" disabled="true"/>
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>性別</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstSexNm"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	     		<s:select id="sexCd" name="sexCd" cssStyle="width:80pt" list ="sexCdCombo"/>
	      	</s:if>
	      	<s:else>
				<s:select id="sexCd" name="sexCd" cssStyle="width:80pt" list ="sexCdCombo" disabled="true"/>
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>医師名(漢字)姓</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstDocKanjiSei"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	      		<s:textfield name="docKanjiSei" size="15" maxlength="5" />
	      	</s:if>
	      	<s:else>
	      		<s:textfield name="docKanjiSei" size="15" maxlength="5" readonly="true" />
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>医師名(漢字)名</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstDocKanjiMei"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	      		<s:textfield name="docKanjiMei" size="15" maxlength="5" />
	      	</s:if>
	      	<s:else>
	      		<s:textfield name="docKanjiMei" size="15" maxlength="5" readonly="true" />
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>医師名(半角カナ)姓</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstDocKanaSei"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	      		<s:textfield name="docKanaSei" size="15" maxlength="10" />
	      	</s:if>
	      	<s:else>
	      		<s:textfield name="docKanaSei" size="15" maxlength="10" readonly="true" />
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>医師名(半角カナ)名</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstDocKanaMei"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
			      <s:textfield name="docKanaMei" size="15" maxlength="10" />
	      	</s:if>
	      	<s:else>
	      		<s:textfield name="docKanaMei" size="15" maxlength="10" readonly="true" />
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
      	<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>旧姓(漢字)姓</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstOldKanjSei"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	      <s:textfield name="oldKanjSei" size="15" maxlength="5" />
	      	</s:if>
	      	<s:else>
	      		<s:textfield name="oldKanjSei" size="15" maxlength="5" readonly="true" />
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>旧姓(半角カナ)姓</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstOldKanaSei"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
			      <s:textfield name="oldKanaSei" size="15" maxlength="10" />
			</s:if>
	      	<s:else>
			      <s:textfield name="oldKanaSei" size="15" maxlength="10" readonly="true" />
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>改姓日</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstNewNameStYear"/>年<s:label key="mstNewNameStMonth"/>月<s:label key="mstNewNameStDay"/>日</nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
			    <s:select id="newNameStYear" name="newNameStYear" cssStyle="width:40pt" list ="newNameStYearCombo"/>年<s:select id="newNameStMonth" name="newNameStMonth" cssStyle="width:30pt" list ="newNameStMonthCombo"/>月<s:select id="newNameStDay" name="newNameStDay" cssStyle="width:30pt" list ="newNameStDayCombo"/>日
			</s:if>
	      	<s:else>
			    <s:select id="newNameStYear" name="newNameStYear" cssStyle="width:40pt" list ="newNameStYearCombo" disabled="true"/>年<s:select id="newNameStMonth" name="newNameStMonth" cssStyle="width:30pt" list ="newNameStMonthCombo" disabled="true"/>月<s:select id="newNameStDay" name="newNameStDay" cssStyle="width:30pt" list ="newNameStDayCombo" disabled="true"/>日
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
      	<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>生年月日</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstDobYear"/>年<s:label key="mstDobMonth"/>月<s:label key="mstDobDay"/>日</nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      <s:select id="dobYear" name="dobYear" cssStyle="width:40pt" list ="dobYearCombo"/>年<s:select id="dobMonth" name="dobMonth" cssStyle="width:30pt" list ="dobMonthCombo"/>月<s:select id="dobDay" name="dobDay" cssStyle="width:30pt" list ="dobDayCombo"/>日
			</s:if>
			<s:else>
		      <s:select id="dobYear" name="dobYear" cssStyle="width:40pt" list ="dobYearCombo" disabled="true"/>年<s:select id="dobMonth" name="dobMonth" cssStyle="width:30pt" list ="dobMonthCombo" disabled="true"/>月<s:select id="dobDay" name="dobDay" cssStyle="width:30pt" list ="dobDayCombo" disabled="true"/>日
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>出身地</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstHomeTownNm"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      <s:select id="homeTownCd" name="homeTownCd" cssStyle="width:80pt" list ="homeTownCdCombo"/>
			</s:if>
			<s:else>
		      <s:select id="homeTownCd" name="homeTownCd" cssStyle="width:80pt" list ="homeTownCdCombo" disabled="true"/>
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>出身校</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstMedSchoolNm"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      <s:select id="medSchoolCd" name="medSchoolCd" cssStyle="width:100pt" list ="medSchoolCdCombo"/>
			</s:if>
			<s:else>
		      <s:select id="medSchoolCd" name="medSchoolCd" cssStyle="width:100pt" list ="medSchoolCdCombo" disabled="true"/>
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>卒年（西暦）</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstGradYear"/>年</nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      <s:select id="gradYear" name="gradYear" cssStyle="width:40pt" list ="gradYearCombo"/>年
			</s:if>
			<s:else>
		      <s:select id="gradYear" name="gradYear" cssStyle="width:40pt" list ="gradYearCombo" disabled="true"/>年
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>出身医局校</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstHomeUnivNm"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      <s:select id="homeUnivCd" name="homeUnivCd" cssStyle="width:100pt" list ="homeUnivCdCombo"/>
			</s:if>
			<s:else>
		      <s:select id="homeUnivCd" name="homeUnivCd" cssStyle="width:100pt" list ="homeUnivCdCombo" disabled="true"/>
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>臨床研修年（西暦）</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstEmplYear"/>年</nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      <s:select id="emplYear" name="emplYear" cssStyle="width:40pt" list ="emplYearCombo"/>年
			</s:if>
			<s:else>
		      <s:select id="emplYear" name="emplYear" cssStyle="width:40pt" list ="emplYearCombo" disabled="true"/>年
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
      	<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItemNd012Border"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>出身所属部科</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstHomeDeptNm"/></nobr></td>
	      <td class="comFormTableItemNd012">
                <nobr>
	      			<s:if test='%{editApprFlg == "1"}'>
		                <input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:tmpCdcView('0');return false;" />
		                <s:textfield name="homeDeptNm" id="homeDeptNm" size="20" maxlength="150" cssClass="mediumGray"/>
		                <s:hidden name="homeDeptCd" id="homeDeptCd"/>
		                <a class="comMiniLink" href ="" onClick="JavaScript:nd012Clear('homeDept');return false;">Clear</a>
					</s:if>
					<s:else>
		                <input class="comButton" type="button"name="button1" value="選択"  disabled />
		                <s:textfield name="homeDeptNm" id="homeDeptNm" size="20" maxlength="150" cssClass="mediumGray" disabled="true"/>
		                <s:hidden name="homeDeptCd" id="homeDeptCd"/>
					</s:else>
                </nobr>
	      </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>専門臓器</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstSpLiverNm"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	      		<s:select id="spLiverCd" name="spLiverCd" cssStyle="width:100pt" list ="spLiverCdCombo"/>
			</s:if>
			<s:else>
	      		<s:select id="spLiverCd" name="spLiverCd" cssStyle="width:100pt" list ="spLiverCdCombo" disabled="true"/>
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>専門詳細</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstSpDiseaseNm"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	      		<s:select id="spDiseaseCd" name="spDiseaseCd" cssStyle="width:100pt" list ="spDiseaseCdCombo"/>
			</s:if>
			<s:else>
	      		<s:select id="spDiseaseCd" name="spDiseaseCd" cssStyle="width:100pt" list ="spDiseaseCdCombo" disabled="true"/>
			</s:else>
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>専門追加情報</nobr></td>
	      <td class="comFormTableItemNd012"><nobr><s:label key="mstSpCom"/></nobr></td>
	      <td class="comFormTableItemNd012"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
	      		<s:textfield name="spCom" size="20" maxlength="300" />
			</s:if>
			<s:else>
				<s:textfield name="spCom" size="20" maxlength="300" readonly="true" />
			</s:else>
	      </nobr></td>
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
	      <td class="comFormTableItem">
                <nobr>
	      			<s:if test='%{editApprFlg == "1"}'>
              		  	<input class="comButton" type="button" name="button2" value="新規作成" onClick="tmpChsView('0', '0');return false;" />
					</s:if>
					<s:else>
             		  	<input class="comButton" type="button" name="button2" value="新規作成"  disabled />
					</s:else>
                </nobr>
	      </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><%-- スクロールバー用のテーブルクラスにすること --%>
              <div id="societyHeader" style="margin:0;width:800px;overflow-y:hidden;overflow-x:auto;position:relative;">
			  <table id="formTable05">
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
					<s:hidden name="hcpSocietyDataList[%{#status.index}].updFlg"/>
			        <td><%-- アクションボタン --%>
<%-- 			        <s:if test="%{reqStsCd == '' || reqStsCd == '01' || reqStsCd == '03' || reqStsCd == '13'}"> --%>
					<s:if test='%{editApprFlg == "1"}'>
			          <nobr>
		                <a class="comMiniLink" href ="" onClick="JavaScript:tmpChsView('1','<s:property value="%{#status.index}"/>'); return false;" >
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
	      <td class="comFormTableItem">
                <nobr>
	     		 	<s:if test='%{editApprFlg == "1"}'>
                		<input class="comButton" type="button"name="button3" value="新規作成" onClick="tmpChpView('0','0');return false;" />
					</s:if>
					<s:else>
                		<input class="comButton" type="button"name="button3" value="新規作成"  disabled />
					</s:else>
                </nobr>
	      </td>
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
			        <s:hidden name="hcpPublicDataList[%{#status.index}].updFlg"/>

			        <td><%-- アクションボタン --%>
<%-- 			        <s:if test="%{reqStsCd == '' || reqStsCd == '01' || reqStsCd == '03' || reqStsCd == '13'}"> --%>
					<s:if test='%{editApprFlg == "1"}'>
						<nobr>
		                	<input class="comButton" type="image" name="buttonP<s:property value="%{#status.index}"/>" src="img/button_update.gif" onClick="JavaScript:tmpChpView('1','<s:property value="%{#status.index}"/>'); return false;" >
		             	</nobr>
			        </s:if>
			        <s:else>
						<nobr>&nbsp;</nobr>
			        </s:else>
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
	      <td align="center">
				<s:if test='%{btnEnableFlg == "0"}'>
		                <input class="comButton" type="button"name="button4" value="勤務先情報更新画面へ" disabled/>
		        </s:if>
				<s:else>
		                <input class="comButton" type="button"name="button4" value="勤務先情報更新画面へ" onClick="gotoND013();return false;" />
				</s:else>
		</td>
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
	     	<s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || (loginJokenSetCd == "JKN0850" && reqStsCd == "11") }'>
		    	<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" /></nobr></td>
	      	</s:if>
	      	<s:else>
	      		<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"  cssClass="mediumGray" readonly="true"/></nobr></td>
	      	</s:else>
      </tr>
	<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
	      <tr>
		      <td class="comFormTableItem"><nobr>審査・承認メモ</nobr></td>
	      </tr>
	      <tr>
		      <td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/></nobr></td>
	      </tr>
      </s:if>
<s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11" || reqStsCd == "03" || reqStsCd == "13"  }'>
</s:if>
<s:else>
		 <tr>
		      <td class="comFormTableItem"><nobr>承認・却下コメント</nobr></td>
	     </tr>
	     <tr>
		      <td class="comFormTableItem"><nobr><s:textarea name="aprComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" cssClass="mediumGray" readonly="true"/></nobr></td>
	      </tr>
</s:else>

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
                <s:if test='%{preScreenId == "ND001"}'>
                	<input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backFnc('0');return false;" />
				</s:if>
				<s:if test='%{preScreenId == "NC011"}'>
					<input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backFnc('1');return false;" />
				</s:if>
				<s:if test='%{preScreenId != "ND001" && preScreenId != "NC011"}'>
					<input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backFnc('2');return false;" />
				</s:if>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(loginJgiNo == reqJgiNo && reqStsCd == "01")||(loginJokenSetCd == "JKN0850" && (reqStsCd == "11" || reqStsCd == "13"))}'>
	                <input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="register('4');return false;" />
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{reqStsCd == null || reqStsCd == "" ||(loginJgiNo == reqJgiNo && reqStsCd == "01")||(loginJokenSetCd == "JKN0850" && reqStsCd == "11")}'>
	                <input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="register('0');return false;" />
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
					<s:if test='%{shnFlg == "1" || loginJgiNo == reqJgiNo}'>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" disabled/>
					</s:if>
					<s:else>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" onClick="register('2');return false;" />
					</s:else>
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
               <nobr>
			   <s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01" ||(loginJokenSetCd == "JKN0850" && reqStsCd == "11") }'>
		                <input class="comButton" type="button"name="buttonF4" value="申請画面へ" onClick="register('1');return false;" />
			   </s:if>
				<s:else>
				   <s:if test='%{reqStsCd != null && reqStsCd != "" && (reqStsCd == "03" || reqStsCd == "13") &&  loginJokenSetCd == "JKN0850"}'>
		                <input class="comButton" type="button"name="buttonF4" value="承認・却下画面へ" onClick="register('3');return false;" />
				   </s:if>
					<s:else>
						<s:if test='%{loginJokenSetCd == "JKN0850"}'>
			                <input class="comButton" type="button"name="buttonF4" value="承認・却下画面へ" disabled/>
						</s:if>
						<s:else>
			                <input class="comButton" type="button"name="buttonF4" value="申請画面へ" disabled/>
						</s:else>
					</s:else>
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
  </s:form>
  </table>

  <jsp:include page="common/rdmBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
