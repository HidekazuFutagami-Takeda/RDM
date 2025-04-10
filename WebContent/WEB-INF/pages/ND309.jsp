<%--
/**
 * <pre>
 *  医師検索のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author SBS 内海
 * @see
 */
--%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND001DTO"%>
<%@page import="jp.co.takeda.rdm.dto.ND102DTO"%>
<%@page import="jp.co.takeda.rdm.dto.ND309DTO"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java"
	import="jp.co.takeda.rdm.util.AppConstant,java.util.ArrayList,java.math.BigDecimal,java.lang.String"
	session="true" buffer="8kb" autoFlush="true" isThreadSafe="true"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>ND309_医療機関以外への異動 - 申請内容確認</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link href="css/common2.css" rel="Stylesheet" type="text/css" />
<link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="js/jkrSosStatus.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<%-- 040C共通のjs --%>
<script type="text/javascript" src="js/ND309.js"></script>
<script type="text/javascript" src="js/catTkCityCombo.js"></script>
<script type="text/javascript" src="js/imtInsInputCategores.js"></script>
<script type="text/javascript" src="js/jgiKanren.js"></script>
<script type="text/javascript" src="js/rdmCatSosExpand.js"></script>
<script type="text/javascript" src="js/jkrMenu.js"></script>
<script>
	var msgContent = ""; //確認メッセージ
    var req0 = "0"
	var req1 = "1"
	destructMsg = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';

	/** 申請ボタン、却下ボタンが押された場合の処理　　
	入力　0 申請ボタン　1　却下ボタン
	結果　0　申請処理　1 却下処理 */
	function setFuncId(button) {
		//２度押し対策フラグ初期化
		comClickFlgInit();

		var reqSts = document.getElementById('reqSts')
		var mrAdminFlg = document.getElementById('mrAdminFlg')

		/** 申請ボタンが押された場合 */
		if(button == 0) {
			/** 申請ステータスが保存済み,承認待ち、ULT承認待ちの場合の場合、申請出来る */
			if(reqSts.value == 01 || reqSts.value == 03 || reqSts.value == 13) {


				document.fm1.funcId.value = req0;

				document.fm1.screenId.value="ND309";
				document.fm1.functionId.value="Register";
			    comSubmitForAnyWarp(fm1);
			}

		/** 却下ボタンが押された場合 */
		}else if(button == 1) {
			/** 申請ステータスが承認待ち、ULT承認待ちの場合、却下出来る */
	        if((reqSts.value == 03 || reqSts.value == 13) && (mrAdminFlg.value == 1)) {
	        	msgContent = '<s:property value="#session.UserInfoKey.msgMap.I009.msgData" />';
	        	window.confirm(msgContent)
				document.fm1.funcId.value = req1;
				document.fm1.screenId.value = "ND309";
				document.fm1.functionId.value = "Register";
				comSubmitForAnyWarp(fm1);
	    	}
		}
	}

		// 戻るボタン
		function backBtn(){
			//２度押し対策フラグ初期化
			comClickFlgInit();

			//if(window.confirm(destructMsg.replace("（遷移元）", '医療機関以外への異動'))){
				// NF211_施設紐付け新規に遷移
				document.fm1.screenId.value="ND102";
				document.fm1.functionId.value="Init";

				comSubmitForAnyWarp(fm1);
		    //}
		}
</script>
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();"onLoad="JavaScript:comSetFormWindowInfo();">

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
	<s:form name="fm1" theme="simple" onSubmit="JavaScript:return false;">
		<s:hidden name="screenId" value="ND309" />
		<s:hidden name="functionId" value="Register" />
		<s:hidden id="pageFlag" name="pageFlag" />
		<s:hidden id="mrAdminFlg" name="mrAdminFlg" />


		<s:hidden name="preScreenId" id="preScreenId" />
		<s:hidden name="nd102PreScreenId"/>
		<s:hidden name="reqYmdhms" />
		<s:hidden name="reqBrCode" />
		<s:hidden name="reqDistCode" />
		<s:hidden name="updShaYmd" />
		<s:hidden name="postInsNo" />
		<s:hidden name="postUltInsNo" />
		<s:hidden name="postDeptCode" />
		<s:hidden name="postDeptKn" />
		<s:hidden name="preInsNo" />
		<s:hidden name="preUltInsNo" />
		<s:hidden name="preDeptCode" />
		<s:hidden name="preDeptKn" />
		<s:hidden name="preTitleCode" />
		<s:hidden name="preJobForm" />
		<s:hidden name="preDcc" />
		<s:hidden name="preUnivPosCode" />
		<s:hidden name="ultDocNo" />
		<s:hidden name="aprComment" />
		<s:hidden name="docNo" />
		<s:hidden name="insNo" />
		<s:hidden name="reqId" />
		<s:hidden name="today" id="today" value="" />
		<s:hidden name="preHoInsType" />
		<s:hidden name="postHoInsType" />


		<s:hidden name="reqShz" />
		<s:hidden name="reqStsNm" />
		<s:hidden name="reqJgiName" />
		<s:hidden name="docKanj" />
		<s:hidden name="preInsAbbrName" />
		<s:hidden name="preDeptKj" />
		<s:hidden name="titlePreTitleKj" />
		<s:hidden name="kmuPreCodeKanj" />
		<s:hidden name="yakushinPreCodeKanj" />
		<s:hidden name="univPreTitleKj" />
		<s:hidden name="dispTekiyoYmd" />
		<s:hidden name="trnKbn" />
		<s:hidden name="reqFlg" />
		<s:hidden name="inputFlg" />
		<s:hidden name="reqCommentFlg" />
		<s:hidden name="movemedEditFlg" />
		<s:hidden name="reqChl" />
		<s:hidden name="reqSts" id="reqSts"/>
		<s:hidden name="funcId" id="funcId" value=""/>

		<s:hidden name="postDeptKj"/>
		<s:hidden name="titlePostTitleKj"/>
		<s:hidden name="kmuPostCodeKanj"/>
		<s:hidden name="yakushinPostCodeKanj"/>
		<s:hidden name="univPostTitleKj"/>
		<s:hidden name="dispTekiyoYmd"/>
        <s:hidden name="reqComment"/>
		<s:hidden name="reqDestBtnFlg"/>

		<s:hidden name="tempReqBtnFlg" id="tempReqBtnFlg" value="0" />
		<s:hidden name="reqBtnFlg" id="reqBtnFlg" value="0" />

<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設新規作成"></td>
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
		<%--エラーメッセージ表示エリア --%>
		<table width="100%">
   		<tr>
             <td align="center">
               <jsp:include page="common/rdmMsg.jsp">
               <jsp:param name="" value="" />
               </jsp:include>
             </td>
         </tr>
      </table>

		<%--申請内容表示エリア --%>
		<table class="comPortalTable" align="center">
			<tbody>
				<tr>
					<td>申請情報</td>
					<td>申請ID</td>
					<td><s:label key="reqId" /></td>
				</tr>
				<tr>
					<td></td>
					<td>申請者所属</td>
					<td><s:label key="reqShz" /></td>
					<td>申請ステータス</td>
					<td><s:label key="reqStsNm" /></td>
				</tr>
				<tr>
					<td></td>
					<td>申請者氏名</td>
					<td><s:label key="reqJgiName" /></td>
					<td>申請日時</td>
					<td><s:label key="reqYmdhms" /></td>
				</tr>
				<tr style="border_top: 4px solid #fff;">
					<td>変更前</td>
				</tr>
				<tr>
					<td></td>
					<td>医師・コメディカル名</td>
					<td><s:label key="docKanj" /></td>
				</tr>
				<tr>
					<td></td>
					<td>所属施設</td>
					<td><s:label key="preInsAbbrName" /></td>
					<td>所属部科</td>
					<td><s:label key="preDeptKj" /></td>
				</tr>
				<tr>
					<td></td>
					<td>役職</td>
					<td><s:label key="titlePreTitleKj" /></td>
					<td>勤務形態</td>
					<td><s:label key="kmuPreCodeKanj" /></td>
				</tr>
				<tr>
					<td></td>
					<td>薬審メンバー区分</td>
					<td><s:label key="yakushinPreCodeKanj" /></td>
					<td>大学職位</td>
					<td><s:label key="univPreTitleKj" /></td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
					    異動区分
					</td>
				    <td>
				        <s:label key="postTrnKbn" />
				    </td>
				</tr>
				<tr>
				    <td></td>
					<td>適用日</td>
					<td><s:label key="dispTekiyoYmd" /></td>
				</tr>
				<tr>
				    <td></td>
					<td>申請コメント</td>
					<td><s:label key="reqComment" /></td>
				</tr>
			<s:if test="mrAdminFlg == '1' && (reqSts == '03' || reqSts == '13') ">
				<tr>
				    <td></td>
					<td>承認・却下コメント</td>
					<td>
					    <s:textarea label="aprComment" name="reqComment" style="width: 60vw; resize: none;" maxlength="100" rows="3"/>
					</td>
				</tr>
			</s:if>
			</tbody>
		</table>
		<table class="comPortalTable"
			style="margin-top: 3pt; margin-bottom: 1pt;" align="center">
			<tr>
				<td align="left"><input class="comButton" type="button"
					name="button1" id="button6" value="戻る" onClick="backBtn();"/></td>
				<td align="right">
					<s:if test="Nd309RejectFlg == 1 && Nd309RejectActiveFlg == 1">
					    <input class="comButton" type="button" name="button1" id="button1" value="却下" onClick="setFuncId(1);"/>
			    	</s:if>
			    	<s:elseif test="Nd309RejectFlg == 1 && Nd309RejectActiveFlg == 0">
			    	    <input class="comButton" type="button" name="button1" id="button1" value="却下" disabled/>
			    	</s:elseif>
			    	<s:else>
			    	</s:else>

					<s:if test="Nd309AppdFlg == 1 && Nd309AppdActiveFlg == 1">
					    <input class="comButton" type="button" name="button2" id="button2" value="申請" onClick="setFuncId(0);"/>
			    	</s:if>
			    	<s:elseif test="Nd309AppdFlg == 1 && Nd309AppdActiveFlg == 0">
			    	    <input class="comButton" type="button" name="button2" id="button2" value="申請" disabled/>
			    	</s:elseif>
			    	<s:else>
			    	</s:else>
			    </td>
			</tr>
		</table>
		</td>
		</tr>
		</tbody>
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
