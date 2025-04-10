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
<%@page import="jp.co.takeda.rdm.dto.ND309DTO"%>
<%@page import="jp.co.takeda.rdm.dto.ND102DTO"%>
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
<title>ND102_医療機関以外への異動</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link href="css/common2.css" rel="Stylesheet" type="text/css" />
<link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="js/jkrSosStatus.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/catDeptsComboRDM.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/ND011.js"></script>
<script type="text/javascript" src="js/ND102.js"></script>
<script type="text/javascript" src="js/catTkCityCombo.js"></script>
<script type="text/javascript" src="js/imtInsInputCategores.js"></script>
<script type="text/javascript" src="js/jgiKanren.js"></script>
<script type="text/javascript" src="js/rdmCatSosExpand.js"></script>
<script type="text/javascript" src="js/jkrMenu.js"></script>
<script type="text/javascript" src="js/catShisetsu.js"></script>
<script>
var msgContent = ""; //確認メッセージ

function submitBtn(funcId) {
	document.fm1.tempButtonExecuted.value = "0";
	document.fm1.reqBtnFlg.value = "0";
	if (funcId == 0) {
		document.fm1.tempButtonExecuted.value = "1";
		msgContent = '<s:property value="#session.UserInfoKey.msgMap.I013.msgData" />';
		if (window.confirm(msgContent)) {
		} else {
			return false;
		}
		// 一時保存
		document.fm1.screenId.value = "ND102";
		document.fm1.functionId.value = "Register";
	} else if (funcId == 1) {
		document.fm1.reqBtnFlg.value = "1";
		msgContent = '<s:property value="#session.UserInfoKey.msgMap.I015.msgData" />';
		if (window.confirm(msgContent)) {
		} else {
			return false;
		}
		// 申請画面へ
		document.fm1.screenId.value = "ND309";
		document.fm1.functionId.value = "Init";
	}
	comSubmitForAnyWarp(fm1);
}
function comSetFormWindowInfo() {
	comClickFlgInit();
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

	document.fm1.screenId.value = "ND102";
	document.fm1.functionId.value = "Cancel";
	comSubmitForAnyWarp(fm1);
}

// 戻るボタン
function backBtn() {
	document.fm1.target = "";
	msgContent = '<s:property value="#session.UserInfoKey.msgMap.I006.msgData" />';

	if(document.fm1.nd102PreScreenId.value == 'NC011'){

		if (window.confirm(msgContent.replace("（遷移元）", '申請一覧'))) {
		} else {
			return false;
		}

		document.fm1.screenId.value = "NC011";
		document.fm1.functionId.value = "init";

		comSubmitForAnyWarp(fm1);
	}else if(document.fm1.nd102PreScreenId.value == 'ND013'){

		if (window.confirm(msgContent.replace("（遷移元）", '医師勤務先情報更新'))) {
		} else {
			return false;
		}

		document.fm1.screenId.value = "ND013";
		document.fm1.functionId.value = "init";
		comSubmitForAnyWarp(fm1);
	}
}
</script>
<style>
table {
	border-collapse:collapse;
	border-spacing: 0 3;
}
.keisen{
    border-top: solid;
    border-width : 1px;
    height: 10px;
}
</style>
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
          <s:hidden name="backScreenId" value="ND102" />


          <s:hidden name="screenId" value="ND102"/>
          <s:hidden name="functionId" value="Register"/>
          <s:hidden id="pageFlag" name="pageFlag" />
          <s:hidden id="mrAdminFlg" name="mrAdminFlg" />

          <s:hidden name="preScreenId"/>
          <s:hidden name="nd102PreScreenId"/>
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
          <s:hidden name="postHoInsType"/>
          <s:hidden name="univPostTitleKj"/>


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

		  <s:hidden name="preInsClass"/>
		  <s:hidden name="postInsClass"/>

		  <s:hidden name="trnKbnCombo"/>

		  <s:hidden name="title"/>
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

		<table class="comPortalTable" align="center">
              <tr>
                  <td>申請情報</td>
                  <td>申請ID</td>
                  <td><s:label key="reqId"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>申請者所属</td>
                  <td><s:label key="reqShz"/></td>
                  <td>申請ステータス</td>
                  <td><s:label key="reqStsNm"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>申請者氏名</td>
                  <td><s:label key="reqJgiName"/></td>
                  <td>申請日時</td>
                  <td><s:label key="reqYmdhms"/></td>
              </tr>
              <tr>
                  <td style="height: 10px;"></td>
                  <td style="height: 10px;"></td>
                  <td style="height: 10px;"></td>
                  <td style="height: 10px;"></td>
                  <td style="height: 10px;"></td>
              </tr>
              <tr>
                  <td class="keisen"></td>
                  <td class="keisen"></td>
                  <td class="keisen"></td>
                  <td class="keisen"></td>
                  <td class="keisen"></td>
              </tr>
              <tr>
                  <td></td>
                  <td>医師・コメディカル名</td>
                  <td><s:label key="docKanj"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>所属施設</td>
                  <td><s:label key="preInsAbbrName"/></td>
                  <td>所属部科</td>
                  <td><s:label key="preDeptKj"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>役職</td>
                  <td><s:label key="titlePreTitleKj"/></td>
                  <td>勤務形態</td>
                  <td><s:label key="kmuPreCodeKanj"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>薬審メンバー区分</td>
                  <td><s:label key="yakushinPreCodeKanj"/></td>
                  <td>大学職位</td>
                  <td><s:label key="univPreTitleKj"/></td>
              </tr>
	              <tr>
	                  <s:if test='inputFlg == 1'>
	                      <td>
	                      </td>
	                      <td>異動区分<span style="color: red;">*</span></td>
	                      <td class="comPortalControlItem" style="text-align:left;">
	                          <s:select id="trnKbnCd" name="trnKbnCd" cssStyle="width:100pt" list ="trnKbnCombo"/>
	                      </td>
	                  </s:if>
	                  <s:elseif test="inputFlg == 0">
	                  	  <td>
	                      </td>
	                      <td>異動区分<span style="color: red;">*</span></td>
	                      <td>
                              <select disabled style="width:100pt">
                                  <option><s:label key="postTrnKbn"/></option>
                              </select>
                          </td>
                      </s:elseif>
	              </tr>
            <tr>
                  <td></td>
                  <td>適用日</td>
                  <td>
                      <s:if test='inputFlg == 1'>
                          <input id="tekiyoYmd" type="date" name="selectDay" value="${dispTekiyoYmd}" pattern="yyyy-MM-dd" style="width:100pt"/>
                      </s:if>
                      <s:if test='inputFlg == 0'>
                          <input type="date" name="selectDay" value="${dispTekiyoYmd}" pattern="yyyy-MM-dd" style="width:100pt" tabindex="-1" disabled />
                      </s:if>
                  </td>
              </tr>
          </table>
          <table class="comPortalTable" align="center">
              <tr>
                  <td>申請コメント</td>
              </tr>
          </table>
          <table class="comPortalTable" align="center">
              <tr>
                  <td>
                      <s:if test='reqCommentFlg == 1'>
                          <s:textarea label="ReqComment" name="reqComment" style="width: 60vw; resize: none;" rows="3" maxlength="100"/>
                      </s:if>
                      <s:elseif test='reqCommentFlg == 0'>
                          <s:textarea label="ReqComment" name="reqComment" style="width: 60vw; resize: none;" cssClass="mediumGray" rows="3" maxlength="100" readonly="true"/>
                      </s:elseif>
                  </td>
              </tr>
          </table>
          <s:if test='reqSts == "02" || reqSts == "04" || reqSts == "12" || reqSts == "14" ||'>
	          <table class="comPortalTable" align="center">
	              <tr>
	                  <td>承認・却下コメント</td>
	              </tr>
	          </table>
	          <table class="comPortalTable" align="center">
	              <tr>
	                  <td>
	                          <s:textarea label="aprComment" name="aprComment" style="width: 60vw; resize: none;" cssClass="mediumGray" rows="3" readonly="true"/>
	                  </td>
	              </tr>
	          </table>
           </s:if>
          <table class="comPortalTable" style="margin-top:3pt;margin-bottom:1pt; "align="center">
              <tr>
                  <td><input class="comButton" type="button" name="button1" id="button1" value="戻る" onClick="JavaScript:backBtn();return false;"/></td>
              <s:if test='reqDestBtnFlg == 1'>
                  <td align="right"><input class="comButton" type="button" name="button2" id="button2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;"/></td>
              </s:if>
              <s:elseif test='reqDestBtnFlg == 0'>
                  <td align="right"><input class="comButton" type="button" name="button3" id="button3" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;"disabled/></td>
              </s:elseif>
              <s:if test='tempReqBtnFlg == 1'>
                  <td><input class="comButton" type="button" name="button4" id="button4" value="一時保存" onClick="JavaScript:submitBtn('0');return false;"/></td>
              </s:if>
              <s:elseif test='tempReqBtnFlg == 0'>
                  <td><input class="comButton" type="button" name="button5" id="button5" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" disabled/></td>
              </s:elseif>
              <s:if test='reqBtnFlg == 1&& reqBtnActiveFlg == 1' >
                  <td align="right"><input class="comButton" type="button" name="button6" id="button6" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;"/></td>
              </s:if>
              <s:elseif test='reqBtnFlg == 1&& reqBtnActiveFlg == 0'>
                  <td align="right"><input class="comButton" type="button" name="button6" id="button6" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;" disabled/></td>
              </s:elseif>
              <s:else>
                  <td align="right" style="width:130px"></td>
              </s:else>
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
