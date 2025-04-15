<%--
/**
 * <pre>
 *  医師削除 - 申請内容確認のJSP
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
  <title>ND315_医師削除 - 申請内容確認</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
    <script>
    destructMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';
    function backFnc(reqId){
    	//if(window.confirm(destructMsg.replace("（遷移元）", '医師削除'))){
    		document.fm1.screenId.value="ND105";
			document.fm1.functionId.value="Init";
			document.fm1.reqId.value=reqId;
			document.fm1.preScreenId.value="ND315";
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
      nd315Register(kbn);
    }

    function nd315Register(buttonFlg){
   	  // 確認メッセージ表示
   	  if (confirm(msgContent)){
   	  } else {
   	    return false;
   	  }

   	  document.fm1.buttonFlg.value = buttonFlg;
   	  document.fm1.screenId.value = 'ND315';
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

    <%-- フレーム対応で発生したPOST用 引数1:frame(フレーム対応),以外(何もしない) 引数２:オブジェクトの型 --%>

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
    <s:hidden name="backScreenId" value="ND315" />
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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="医師削除 - 申請内容確認"></td>
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
        <s:hidden name="reqShzNm"/>
        <s:hidden name="reqStsNm"/>
        <s:hidden name="reqJgiName"/>
        <s:hidden name="reqYmdhms"/>
        <s:hidden name="shnShaName"/>
        <s:hidden name="shnYmdhms"/>
        <s:hidden name="aprShaName"/>
        <s:hidden name="aprYmdhms"/>
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
        <s:hidden name="docAttribute"/>
        <s:hidden name="docAttributeNm"/>
        <s:hidden name="docKanjiSei"/>
        <s:hidden name="docKanjiMei"/>
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
	      <td class="comFormTableItem"><nobr>承認者</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="aprShaName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>承認日時</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="aprYmdhms"/></nobr></td>
	  </tr>
	  </s:if>
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
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医師固定C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="tkdDocNo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>医師属性</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="docAttributeNm"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医師・コメディカル名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="tkdDocNm"/></nobr></td>
	      <td class="comFormTableItem"><nobr>医師・コメディカル名(フリガナ)</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="tkdDocKana"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>削除理由</nobr></td>
	      <td class="comFormTableItem"><nobr>
					      <s:label key="delReasonNm"/>
			  <s:hidden name="delReason"/><s:hidden name="delReasonNm"/>

	      </nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
<s:if test='%{delReason == "02"}'>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>重複医師コード</nobr></td>
	      <td class="comFormTableItem">
                <nobr>
                <s:label key="dupDocNo"/>
			  <s:hidden name="dupDocNo"/>
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>医師・コメディカル名</nobr></td>
	      <td class="comFormTableItem">
                <nobr>
                <s:label key="dupDocNm"/>
			  <s:hidden name="dupDocNm"/>
                </nobr>
	      </td>
	 </tr>
</s:if>
  </table>

  <br/>
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
	     	<s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01"||(loginJokenSetCd == "JKN0850" && reqStsCd == "11") }'>
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
<%--                 <s:if test='%{loginJokenSetCd == "JKN0850" && (reqStsCd == "03" || reqStsCd == "13") && reqChl == "2" && delReason == "02"}'> --%>
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
<%--                 <s:if test='%{loginJokenSetCd == "JKN0850" && (reqStsCd == "03" || reqStsCd == "13") && reqChl == "2" && delReason == "02" }'> --%>
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
			   <s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01"||(loginJokenSetCd == "JKN0850" && reqStsCd == "11") }'>
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