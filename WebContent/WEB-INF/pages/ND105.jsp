<%--
/**
 * <pre>
 *  医師削除のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND315DTO"%>
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
  <title>ND105_医師削除</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <link href="css/reqDisplay.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/jgiKanren.js"></script>
  <script type="text/javascript" src="js/catDoctor.js"></script>
  <script type="text/javascript" src="js/ND105.js"></script>
    <script>
    destructMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';
    function backFnc(backKbn){
    	if(backKbn == '0')	{
	    	if(window.confirm(destructMsg.replace("（遷移元）", '医師勤務先情報更新'))){
				//モック
// 	    		document.fm1.screenId.value="ND013";
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
      if (kbn == '3'){//I012	申請データを承認します。よろしいですか？
          msgContent = '<s:property value="#session.UserInfoKey.msgMap.I012.msgData" />';
      }
      if (kbn == '4'){//I007	申請データを破棄します。よろしいですか？
          msgContent = '<s:property value="#session.UserInfoKey.msgMap.I007.msgData" />';
      }
      nd105Register(kbn);
    }


    function comSetFormWindowInfo(){
        changeBox();
        comSetFormWindowName('ND105');
// 		const returnFlg = document.fm1.buttonFlg.value;
// 		if(returnFlg == "8"){//削除完了時画面を閉じろ
// // 			window.close();ではjsで開いた画面しか無理
// 		}
        return false;
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
    <s:hidden name="backScreenId" value="ND105" />
     <s:hidden name="preScreenId"/>
     <s:hidden name="screenId" value="" />
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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="医師削除"></td>
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
	      <td class="comFormTableItem"><nobr>削除理由<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      <s:select id="delReason" name="delReason" cssStyle="width:100pt" list ="delReasonCombo" onchange='changeBox()'/>
			</s:if>
			<s:else>
		      <s:select id="delReason" name="delReason" cssStyle="width:100pt" list ="delReasonCombo" disabled="true"/>
			</s:else>
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  </table>
  <br/>
  <hr class="comTitle"  id="dupHr" style="margin-top:2px;width:75%"/><br/>
      <table id="formTable08" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--重複情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
<s:if test='%{editApprFlg == "1"}'>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>重複医師コード<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem">
                <nobr>
		                <input class="comButton" type="button"name="button2" value="選択" onClick="JavaScript:tmpCdrView();return false;" />
		                <s:textfield name="dupDocNo" id="dupDocNo" size="20" maxlength="40" cssClass="mediumGray"/>
		                <a class="comMiniLink" href ="" onClick="JavaScript:nd105Clear('dupDoc');return false;">Clear</a>
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>医師・コメディカル名</font></nobr></td>
	      <td class="comFormTableItem">
                <nobr>
		                <s:textfield name="dupDocNm" id="dupDocNm" size="20" maxlength="40" cssClass="mediumGray"/>
                </nobr>
	      </td>
	 </tr>
</s:if>
<s:else>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>重複医師コード<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem">
                <nobr>
		                <input class="comButton" type="button"name="button2" value="選択" disabled />
		                <s:textfield name="dupDocNo" id="dupDocNo" size="20" maxlength="40" cssClass="mediumGray"/>
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>医師・コメディカル名</font></nobr></td>
	      <td class="comFormTableItem">
                <nobr>
		                <s:textfield name="dupDocNm" id="dupDocNm" size="20" maxlength="40" cssClass="mediumGray"/>
                </nobr>
	      </td>
	 </tr>
</s:else>
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
	      		<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" cssClass="mediumGray" readonly="true"/></nobr></td>
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
                <s:if test='%{preScreenId == "ND013"}'>
                	<input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backFnc('0');return false;" />
				</s:if>
				<s:if test='%{preScreenId == "NC011"}'>
					<input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backFnc('1');return false;" />
				</s:if>
				<s:if test='%{preScreenId != "ND013" && preScreenId != "NC011"}'>
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
