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
<%@page import="jp.co.takeda.rdm.dto.ND307DTO"%>
<%@page import="jp.co.takeda.rdm.dto.ND101DTO"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="java.util.Enumeration"%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppConstant,java.util.ArrayList,java.math.BigDecimal,java.lang.String"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"

%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>ND101_医療機関への異動</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link href="css/common2.css" rel="Stylesheet" type="text/css" />
<link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/catDeptsComboRDM.js"></script>
<script type="text/javascript" src="js/catShisetsu.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/ND101.js"></script>
<script type="text/javascript" src="js/jgiKanren.js"></script>
<script>
var msgContent = ""; //確認メッセージ

function submitBtn(funcId) {
	document.fm1.tempButtonExecuted.value = "0";
	document.fm1.reqBtnFlg.value = "0";
	if (funcId == 0) {
		document.fm1.tempButtonExecuted.value = "1";
		/*msgContent = '<s:property value="#session.UserInfoKey.msgMap.I013.msgData" />';
		if (window.confirm(msgContent)) {
		} else {
			return false;
		}*/
		// 一時保存
		document.fm1.buttonFlg.value = "0";
		document.fm1.screenId.value = "ND101";
		document.fm1.functionId.value = "Register";
	} else if (funcId == 1) {
		document.fm1.reqBtnFlg.value = "1";
		/*msgContent = '<s:property value="#session.UserInfoKey.msgMap.I015.msgData" />';
		if (window.confirm(msgContent)) {*/
			  document.fm1.buttonFlg.value = "1";
			  document.fm1.screenId.value = 'ND101';
			  document.fm1.functionId.value = 'Register';
		/*} else {
			return false;
		}*/
		// 申請画面へ
// 		document.fm1.screenId.value = "ND307";
// 		document.fm1.functionId.value = "Init";
//		nd101Register("1");
	} else if (funcId == 2) {//承認・却下として確認画面へ遷移
		document.fm1.reqBtnFlg.value = "2";
		msgContent = '<s:property value="#session.UserInfoKey.msgMap.I012.msgData" />';
		if (window.confirm(msgContent)) {
			  document.fm1.buttonFlg.value = "3";
			  document.fm1.screenId.value = 'ND101';
			  document.fm1.functionId.value = 'Register';
		} else {
			return false;
		}
		// 申請画面へ
// 		document.fm1.screenId.value = "ND307";
// 		document.fm1.functionId.value = "Init";
//		nd101Register("3");
	}
	comSubmitForAnyWarp(fm1);
}

function comSetFormWindowInfo() {
	comClickFlgInit();

	if(document.fm1.postHoInsType.value == "1" && document.fm1.postInsClass.value == "01"
			&& document.fm1.inputFlg.value == 1){
    	// 大学病院の場合大学職位を活性
    	document.getElementById("postUnivPosCode").disabled = false;
    } else {
    	// 大学職位を非活性
    	document.getElementById("postUnivPosCode").disabled = true;
    	document.getElementById("postUnivPosCode").value = "";
    }

    if(document.fm1.postInsNo.value != null && document.fm1.postInsNo.value != ""){
    	document.getElementById("deptBtn").disabled = false;
    } else {
    	document.getElementById("deptBtn").disabled = true;
    }

	var alertFlg = document.fm1.alertMsgStr.value;
	var alertFlg2 = document.fm1.alertMsgStr2.value;
	if(!alertFlg) {
		if(alertFlg2) {
			if (window.confirm(alertFlg2)) {
				document.fm1.alertIgnore.value = 1;
			} else {
				return false;
			}
		}
	}else {
		alert(alertFlg);
	}
}

// 申請破棄ボタン
function reqCancelBtn() {
	document.fm1.target = "";
	msgContent = '<s:property value="#session.UserInfoKey.msgMap.I007.msgData" />';
	if (window.confirm(msgContent)) {
	} else {
		return false;
	}
	// 申請データを破棄（＝物理的に削除）し、遷移元画面へ遷移する（本画面のタブを閉じる）
	// 申請IDで対象を絞り込み申請管理、勤務先_申請管理を削除

	document.fm1.screenId.value = "ND101";
	document.fm1.functionId.value = "Cancel";
	comSubmitForAnyWarp(fm1);
}

// 戻るボタン
function backBtn() {
	document.fm1.target = "";
	msgContent = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';

	if(document.fm1.nd101PreScreenId.value == 'NC011'){

		if (window.confirm(msgContent.replace("（遷移元）", '申請一覧'))) {
			window.close();
		} else {
			return false;
		}

// 		document.fm1.screenId.value = "NC011";
// 		document.fm1.functionId.value = "init";

// 		comSubmitForAnyWarp(fm1);
	}else if(document.fm1.nd101PreScreenId.value == 'ND013'){

		if (window.confirm(msgContent.replace("（遷移元）", '医師勤務先情報更新'))) {
			window.close();
		} else {
			return false;
		}

// 		document.fm1.screenId.value = "ND013";
// 		document.fm1.functionId.value = "init";
// 		comSubmitForAnyWarp(fm1);
	}else{
		if(window.confirm("画面を閉じます。よろしいですか？")){
			//この画面（タブ）を閉じる
			window.close();
    	}
	}
}
// 審査完了ボタン
function shnCompBtn(){

	document.fm1.screenId.value="ND101";
	document.fm1.functionId.value="ShnComp";

	document.fm1.target="";
	comSubmitForAnyWarp(fm1);

}
</script>
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();"/>

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

    <s:form name="fm1" theme="simple" onSubmit="JavaScript:return false;" >

          <%-- 所属部科ポップアップ用パラメータ --%>
          <input type="hidden" name="cdcCheckedCodes" value="" />
          <input type="hidden" name="paramInsNo" value="" />
          <%-- 画面用パラメータ --%>
          <s:hidden name="backScreenId" value="ND101" />


          <s:hidden name="screenId" value="ND101"/>
          <s:hidden name="functionId" value="Register"/>
          <s:hidden id="pageFlag" name="pageFlag" />
          <s:hidden id="mrAdminFlg" name="mrAdminFlg" />

          <s:hidden name="preScreenId"/>
          <s:hidden name="nd101PreScreenId"/>
          <s:hidden name="reqYmdhms"/>
          <s:hidden name="reqBrCode"/>
          <s:hidden name="reqDistCode"/>
          <s:hidden name="updShaYmd"/>
          <s:hidden name="postInsNo"/>
          <s:hidden name="postUltInsNo"/>
          <s:hidden name="postDeptCode"/>
          <s:hidden name="postDeptKn"/>
          <s:hidden name="preInsNo"/>
          <s:hidden name="preUltInsNo"/>
          <s:hidden name="preDeptCode"/>
          <s:hidden name="preDeptKn"/>
          <s:hidden name="preTitleCode"/>
          <s:hidden name="preJobForm"/>
          <s:hidden name="preDcc"/>
          <s:hidden name="preUnivPosCode"/>
          <s:hidden name="ultDocNo"/>
          <s:hidden name="aprComment"/>
          <s:hidden name="docNo"/>
          <s:hidden name="insNo"/>
          <s:hidden name="reqId"/>
          <s:hidden name="today" id="today" value=""/>
          <s:hidden name="preHoInsType"/>
          <s:hidden name="preInsClass"/>
          <s:hidden name="postHoInsType"/>
          <s:hidden name="postInsClass"/>
          <s:hidden name="univPostTitleKj"/>
<!-- ボタン制御用 -->
    <s:hidden name="buttonFlg" />


          <s:hidden name="reqShz"/>
          <s:hidden name="reqStsNm"/>
          <s:hidden name="reqJgiName"/>
          <s:hidden name="docKanj"/>
          <s:hidden name="preInsAbbrName"/>
          <s:hidden name="preDeptKj"/>
          <s:hidden name="titlePreTitleKj"/>
          <s:hidden name="kmuPreCodeKanj"/>
          <s:hidden name="yakushinPreCodeKanj"/>
          <s:hidden name="univPreTitleKj"/>
          <s:hidden name="tekiyoDay"/>
          <s:hidden name="trnKbn"/>
          <s:hidden name="reqFlg"/>

          <s:hidden name="reqType"/>
          <s:hidden name="inputFlg"/>
          <s:hidden name="reqCommentFlg"/>
          <s:hidden name="movemedEditFlg"/>
          <s:hidden name="tempButtonExecuted"/>


          <s:hidden name="reqDestBtnFlg"/>
          <s:hidden name="tempReqBtnFlg" id="tempReqBtnFlg"/>
          <s:hidden name="reqBtnFlg" id="reqBtnFlg"/>
          <s:hidden name="reqBtnActiveFlg" id="reqBtnActiveFlg"/>

          <s:hidden name="alertMsgStr"/>
          <s:hidden name="alertMsgStr2"/>
          <s:hidden name="alertIgnore"/>

          <s:hidden name="reqSts"/>
<s:hidden name="reqChl"/>
<s:hidden name="loginJokenSetCd"/>
<s:hidden name="loginJgiNo"/>
<s:hidden name="shnFlg"/>
<s:hidden name="reqJgiNo"/>
<s:hidden name="title" />
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
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 90px; height: 0px; border-width: 0px;"></td>
        <td style="width: 185px; height: 0px; border-width: 0px;"></td>
        <td style="width: 90px; height: 0px; border-width: 0px;"></td>
        <td style="width: 185px; height: 0px; border-width: 0px;"></td>
      </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>申請情報</nobr></td>
                  <td class="comFormTableItem"><nobr>申請ID</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="reqId"/></nobr></td>
              </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>申請者所属</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="reqShz"/></nobr></td>
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
	  <s:if test='%{reqSts != null && reqSts != "" && !(reqSts == "01" || reqSts == "11" || reqSts == "03" || reqSts == "13") }'>
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
        <td style="width: 90px; height: 0px; border-width: 0px;"></td>
        <td style="width: 185px; height: 0px; border-width: 0px;"></td>
        <td style="width: 90px; height: 0px; border-width: 0px;"></td>
        <td style="width: 185px; height: 0px; border-width: 0px;"></td>
      </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>変更前</nobr></td>
              </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>医師・コメディカル名</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="docKanj"/></nobr></td>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
              </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>所属施設</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="preInsAbbrName"/></nobr></td>
                  <td class="comFormTableItem"><nobr>所属部科</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="preDeptKj"/></nobr></td>
              </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>役職</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="titlePreTitleKj"/></nobr></td>
                  <td class="comFormTableItem"><nobr>勤務形態</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="kmuPreCodeKanj"/></nobr></td>
              </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>薬審メンバー区分</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="yakushinPreCodeKanj"/></nobr></td>
                  <td class="comFormTableItem"><nobr>大学職位</nobr></td>
                  <td class="comFormTableItem"><nobr><s:label key="univPreTitleKj"/></nobr></td>
              </tr>
          <s:if test='(reqType == "42" || movemedEditFlg == "0")'>
              <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>異動区分</nobr></td>
                  <td class="comFormTableItem"><nobr>医療機関</nobr></td>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
              </tr>
          </s:if>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%;">
<tr>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 90px; height: 0px; border-width: 0px;"></td>
        <td style="width: 185px; height: 0px; border-width: 0px;"></td>
        <td style="width: 90px; height: 0px; border-width: 0px;"></td>
        <td style="width: 185px; height: 0px; border-width: 0px;"></td>
      </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>変更後</nobr></td>
              </tr>
              <s:if test='(reqType == "42" || movemedEditFlg == "0")'>
                  <s:if test='inputFlg == 1'>
	              <tr>
	                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	                  <td class="comFormTableItem"><nobr>異動先施設<span style="color: red;">*</span></nobr></td>
	                  <td class="comFormTableItem">
	                      <nobr>
							<input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:tmpCseView();return false;" /><s:textfield name="postInsAbbrName" size="17" maxlength="17" cssClass="mediumGray" readonly="true"/><a href="#" class="comMiniLink" onclick="jimClear('abbrName')">Clear</a>&nbsp;
	                      </nobr>
	                  </td>
	              </tr>
	              <tr>
	                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	                  <td class="comFormTableItem"><nobr>異動先所属部科<span style="color: red;">*</span></nobr></td>
	                  <td class="comFormTableItem">
	                      <nobr>
	                           <input class="comButton" type="button" id="deptBtn" name="button1" value="選択" onClick="JavaScript:tmpCdcView('0');return false;"/><s:textfield name="postDeptKj" size="17" maxlength="17" cssClass="mediumGray" readonly="true"/><a href="#" class="comMiniLink" onclick="jimClear('shozokubukaName')" >Clear</a>&nbsp;
	                      </nobr>
	                  </td>
	              </tr>
	              <tr>
	                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	                  <td class="comFormTableItem"><nobr>※施設を先に選択してください</nobr></td>
	              </tr>
	              </s:if>
                  <s:else>
	              <tr>
	                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	                  <td class="comFormTableItem"><nobr>異動先施設<span style="color: red;">*</span></nobr></td>
	                  <td class="comFormTableItem">
	                      <nobr>
	                          <input class="comButton" type="button"name="button1" value="選択" disabled/><s:textfield name="postInsAbbrName" size="17" maxlength="17" cssClass="mediumGray" readonly="true"/><a class="comMiniLink" style="color:lightgray;">clear</a>&nbsp;
	                      </nobr>
	                  </td>
	              </tr>
	              <tr>
	                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	                  <td class="comFormTableItem"><nobr>異動先所属部科<span style="color: red;">*</span></nobr></td>
	                  <td class="comFormTableItem">
	                      <nobr>
	                           <input class="comButton" type="button"name="button1" value="選択" disabled/><s:textfield name="postDeptKj" size="17" maxlength="17" cssClass="mediumGray" readonly="true"/><a class="comMiniLink" style="color:lightgray">clear</a>&nbsp;
	                      </nobr>
	                  </td>
	              </tr>
	              </s:else>
              </s:if>
              <s:else>
	              <tr>
	                  <s:if test='inputFlg == 1'>
	                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	                  <td class="comFormTableItem"><nobr>所属部科<span style="color: red;">*</span></nobr></td>
	                  <td class="comFormTableItem"><nobr>
	                               <input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:tmpCdcView('0');return false;" />
	                               <s:textfield name="postDeptKj" size="17" maxlength="17" cssClass="mediumGray" readonly="true"/><a class="comMiniLink" onclick="jimClear('shozokubukaName')">clear</a>&nbsp;
	                  </nobr></td>
	                  </s:if>
	                  <s:else>
	                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	                  <td class="comFormTableItem"><nobr>所属部科<span style="color: red;">*</span></nobr></td>
	                  <td class="comFormTableItem"><nobr>
	                               <input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:tmpCdcView('0');return false;" disabled/>
	                               <s:textfield name="postDeptKj" size="17" maxlength="17" cssClass="mediumGray" readonly="true"/><a class="comMiniLink" style="color:lightgray;">clear</a>&nbsp;
	                  </nobr></td>
	                  </s:else>
                                    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                                    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	              </tr>
              </s:else>
              <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>役職<span style="color: red;">*</span></nobr></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                  <s:if test='inputFlg == 1'>
                      <s:select id="postTitleCode" name="postTitleCode" cssStyle="width:100pt" list ="yakushokuCombo"/>
                  </s:if>
                  <s:elseif test="inputFlg == 0">
                      <select disabled style="width:100pt">
                          <option><s:label key="titlePostTitleKj"/></option>
                      </select>
                  </s:elseif>
                  </td>
                  <td class="comFormTableItem"><nobr>勤務形態</nobr></td>
                  <td class="comPortalControlItem" style="text-align:left;">
					<s:if test='inputFlg == 1'>
						<s:select id="postJobForm" name="postJobForm" cssStyle="width:100pt" list="jobFormCombo" />
					</s:if>
					<s:elseif test="inputFlg == 0">
                      <select disabled style="width:100pt">
                          <option><s:label key="kmuPostCodeKanj"/></option>
                      </select>
					</s:elseif>
				</td>
              </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>薬審メンバー区分</nobr></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                  <s:if test='inputFlg == 1'>
                      <s:select id="postDcc" name="postDcc" cssStyle="width:100pt" list ="dccCombo"/>
                  </s:if>
                  <s:elseif test="inputFlg == 0">
                      <select disabled style="width:100pt">
                          <option><s:label key="yakushinPostCodeKanj"/></option>
                      </select>
                  </s:elseif>
                  </td>
			      <td class="comFormTableItem"><nobr>大学職位</nobr></td>
			      <td class="comPortalControlItem" style="text-align: left;">
			      <s:if test='inputFlg == 1'>
					  <s:select id="postUnivPosCode" name="postUnivPosCode"
						  cssStyle="width:100pt" list="digakuShokuiCombo" />
				  </s:if>
				  <s:else>
					  <select disabled style="width: 100pt">
						  <option><s:label key="univPostTitleKj" /></option>
					  </select>
				  </s:else>
				  </td>
		    </tr>
            <tr>
                  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                  <td class="comFormTableItem"><nobr>適用日</nobr></td>
                  <td class="comFormTableItem"><nobr>
                      <s:if test='inputFlg == 1'>
                          <input id="tekiyoYmd" type="date" name="selectDay" value="${dispTekiyoYmd}" pattern="yyyy-MM-dd" style="width:100pt"/>
                      </s:if>
                      <s:if test='inputFlg == 0'>
                          <input type="date" name="selectDay" value="${dispTekiyoYmd}" pattern="yyyy-MM-dd" style="width:100pt" tabindex="-1" disabled />
                      </s:if>
                  </nobr></td>
                                    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
                                    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
              </tr>
          </table>
  <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:75%;">
              <tr>
                  <td class="comFormTableItem"><nobr>申請コメント</nobr></td>
              </tr>
              <tr>
                  <td class="comFormTableItem"><nobr>
                      <s:if test='reqCommentFlg == 1'>
                          <s:textarea label="ReqComment" name="reqComment" style="width: 60vw; resize: none;" rows="3" maxlength="100"/>
                      </s:if>
                      <s:elseif test='reqCommentFlg == 0'>
                          <s:textarea label="ReqComment" name="reqComment" style="width: 60vw; resize: none;" cssClass="mediumGray" rows="3" readonly="true"/>
                      </s:elseif>
                 </nobr></td>
              </tr>
          </table>

          	<s:if test='%{(reqSts == "03" || reqSts == "13") && loginJokenSetCd == "JKN0850"}'>
  <table id="formTable05" border="0" class="comPortalTable" align="center" style="width:75%;">
	      <tr>
		      <td class="comFormTableItem"><nobr>審査・承認メモ</nobr></td>
	      </tr>
	      <tr>
		      <td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/></nobr></td>
	      </tr>
          </table>
      </s:if>

<s:if test='%{reqSts == null || reqSts == "" || reqSts == "01" || reqSts == "11" || reqSts == "03" || reqSts == "13"  }'>
</s:if>
<s:else>
  <table id="formTable06" border="0" class="comPortalTable" align="center" style="width:75%;">
	              <tr>
	                  <td class="comFormTableItem"><nobr>承認・却下コメント</nobr></td>
	              </tr>
	              <tr>
	                  <td class="comFormTableItem"><nobr>
	                          <s:textarea label="aprComment" name="aprComment" style="width: 60vw; resize: none;" cssClass="mediumGray" rows="3" readonly="true"/>
	                  </nobr></td>
	              </tr>
	          </table>
           </s:else>
  <table id="formTable10" border="0" class="comPortalTable" align="center" style="width:98%;">
              <tr>
                  <td class="comFormTableItem"><nobr><input class="comButton" type="button" name="button1" id="button1" value="戻る" onClick="JavaScript:backBtn();return false;"/></nobr></td>
              <s:if test='reqDestBtnFlg == 1'>
                  <td align="right"><input class="comButton" type="button" name="button2" id="button2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;"/></td>
              </s:if>
              <s:elseif test='reqDestBtnFlg == 0'>
                  <td align="right"><input class="comButton" type="button" name="button3" id="button3" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;"disabled/></td>
              </s:elseif>
          <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(reqSts == "03" || reqSts == "13") && loginJokenSetCd == "JKN0850"}'>
					<s:if test='%{shnFlg == "1" || loginJgiNo == reqJgiNo}'>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" disabled/>
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
              <s:if test='tempReqBtnFlg == 1'>
                  <td class="comFormTableItem"><nobr><input class="comButton" type="button" name="button4" id="button4" value="一時保存" onClick="JavaScript:submitBtn('0');return false;"/></nobr></td>
              </s:if>
              <s:elseif test='tempReqBtnFlg == 0'>
                  <td class="comFormTableItem"><nobr><input class="comButton" type="button" name="button5" id="button5" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" disabled/></nobr></td>
              </s:elseif>
<%--               <s:if test='reqBtnFlg == 1&& reqBtnActiveFlg == 1' > --%>
<!--                   <td align="right"><input class="comButton" type="button" name="button6" id="button6" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;"/></td> -->
<%--               </s:if> --%>
<%--               <s:elseif test='reqBtnFlg == 1&& reqBtnActiveFlg == 0'> --%>
<!--                   <td align="right"><input class="comButton" type="button" name="button6" id="button6" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;" disabled/></td> -->
<%--               </s:elseif> --%>
<%--               <s:else> --%>
<!--                   <td align="right" style="width:130px"></td> -->
<%--               </s:else> --%>
	      <td class="comFormTableItem">
               <nobr>
				<s:if test='%{(reqSts == null || reqSts == "" || reqSts == "01" || (loginJokenSetCd == "JKN0850" && reqSts == "11") )}'>
		                <input class="comButton" type="button"name="buttonF3" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;"/>
				</s:if>
				<s:elseif test='%{(reqSts == "03" || reqSts == "13")}'>
					<s:if test='%{(loginJokenSetCd == "JKN0850")}'>
		                <input class="comButton" type="button"name="buttonF3" value="承認・却下画面へ" onClick="submitBtn('2');JavaScript:return false;" />
					</s:if>
					<s:else>
						<input class="comButton" type="button"name="buttonF3" value="承認・却下画面へ"  disabled />
					</s:else>
				</s:elseif>
				<s:else>
	                &nbsp;
				</s:else>
                </nobr>
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
