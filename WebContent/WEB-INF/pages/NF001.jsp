<%--
/**
 * <pre>
 *  施設検索のJSP
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author
 * @see jp.co.takeda.maps.command.jgikanren.jkrinsmrchange.JkrInsMrChangeViewFrontCommand
 */
 --%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="java.util.Enumeration"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="jp.co.takeda.rdm.util.AppMethods"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>


<%@ page
  language="java"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
//String title = (String)request.getAttribute("title");
//String execDate = (String)request.getAttribute("execDate");
//ValueStack stack = (ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
//JKR040C010DTO dto = new JKR040C010DTO();
//if (stack.peek() instanceof JKR040C010DTO) {
//  dto = (JKR040C010DTO)stack.peek();
//}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>NF001_施設検索</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>

    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/catTkCityCombo.js"></script>
    <script type="text/javascript" src="js/imtInsInputCategores.js"></script>
    <script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
    <script type="text/javascript" src="js/jkrMenu.js"></script>
    <script>
	    function comSetFormWindowInfo(){
	    	comClickFlgInit();

	    	sosAddrChange();

	    	document.fm1.addrCodeCity.value = document.fm1.tmpAddrCodeCity.value;
	    }

	    // TODO サイズ調整
	    var sosSubScreenSize = "left=0, top=0, width=1100, height=800";
	 	// 組織選択ボタン
	    function sosPopBtn(){
			// NC201_組織検索ポップアップを開く
			window.open("","sosPopWindow",sosSubScreenSize);
			document.fm1.screenId.value = "NC201";
			document.fm1.functionId.value="Init";
			document.fm1.target="sosPopWindow";

			document.fm1.callBack.value = "callBackSosPop";

			comSubmitForAnyWarp(fm1);
	    }

	 	// 組織検索ポップアップから値受け取り
	 	// TODO
	    function callBackSosPop(sosCd, sosNm){
			document.fm1.sosCd.value = sosCd;
			document.fm1.sosNm.value = sosNm;
	 	}

	 	// 担当者選択ボタン
	    function tantoPopBtn(){
			// NC202_担当者検索ポップアップ画面を表示
	    	window.open("","tantoPopWindow",tantoSubScreenSize);
			document.fm1.screenId.value = "NC202";
			document.fm1.functionId.value="Init";
			document.fm1.target="tantoPopWindow";

			document.fm1.sosCdPop.value = document.fm1.sosCd.value;
			document.fm1.bumonRankPop.value = document.fm1.bumonRank.value;
			document.fm1.upSosCdPop.value = document.fm1.upSosCd.value;

			document.fm1.selectFlgPop.value="1";
			document.fm1.callBack.value="callBackTantoPop";

			comSubmitForAnyWarp(fm1);
			comClickFlgInit();
	    }

		// 担当者検索ポップアップから値受け取り
	    function callBackTantoPop(sosCd, bumonSeiName, jgiNo, jgiName, trtCd, brCode,
	    							distCode, trtGrpCd, trtNm, mrCat){
			document.fm1.sosCd.value = sosCd;
			document.fm1.bumonRyakuName.value = bumonSeiName;
			document.fm1.jgiNo.value = jgiNo;
			document.fm1.jgiNm.value = jgiName;
			document.fm1.trtCd.value = trtCd;
			document.fm1.trtNm.value = trtNm;
			document.fm1.mrCat.value = mrCat;
			document.fm1.brCode.value = brCode;
			document.fm1.distCode.value = distCode;
	    }

		// 組織Clearボタン
	    function sosClearBtn(){
			document.fm1.sosCd.value = "";
			document.fm1.sosNm.value = "";
			document.fm1.bumonRyakuName.value = "";
			document.fm1.jgiNo.value = "";
			document.fm1.jgiNm.value = "";
			document.fm1.trtCd.value = "";
			document.fm1.trtNm.value = "";
			document.fm1.mrCat.value = "";
			document.fm1.brCode.value = "";
			document.fm1.distCode.value = "";
			document.fm1.bumonRank.value = "";
			document.fm1.upSosCd.value = "";
		}

	 	// 担当者Clearボタン
	    function tantoClearBtn(){
			document.fm1.bumonRyakuName.value = "";
			document.fm1.jgiNo.value = "";
			document.fm1.jgiNm.value = "";
			document.fm1.trtCd.value = "";
			document.fm1.trtNm.value = "";
			document.fm1.mrCat.value = "";
			document.fm1.brCode.value = "";
			document.fm1.distCode.value = "";
		}

	 	// Clearボタン
	    function clearBtn(){
			document.fm1.sosCd.value = "";
			document.fm1.sosNm.value = "";
			document.fm1.bumonRyakuName.value = "";
			document.fm1.jgiNo.value = "";
			document.fm1.jgiNm.value = "";
			document.fm1.trtCd.value = "";
			document.fm1.trtNm.value = "";
			document.fm1.mrCat.value = "";
			document.fm1.brCode.value = "";
			document.fm1.distCode.value = "";
			document.fm1.bumonRank.value = "";
			document.fm1.upSosCd.value = "";

			document.fm1.delKbn.value = "";
			document.fm1.insKanjSrch.value = "";
			document.fm1.insKanaSrch.value = "";
			document.fm1.delFlg.value = "";
			document.fm1.insNo.value = "";
			document.fm1.ultInsNo.value = "";
			document.fm1.keieitai.value = "";
			document.fm1.hoInsType.value = "";
			document.fm1.insType.value = "";
			document.fm1.pharmType.value = "";
			document.fm1.insPhoneSrch.value = "";
			document.fm1.insPcode.value = "";
			document.fm1.addrCodePref.value = "";
			document.fm1.addrCodeCity.value = "";
			document.fm1.tmpAddrCodeCity.value = "";
			document.fm1.insAddrSrch.value = "";
		}

	 	// 画面遷移処理
	    function gotoNext(screenId,functionId){
	   		document.fm1.target="";
	  	 	fm1.screenId.value=screenId;
	  	  	fm1.functionId.value=functionId;
	  	  	comSubmitForAnyWarp(fm1);
	  	}

	 	var nf001Tab;
	 	// アクションボタン
	    function actBtn(screenId, insNo, tkdTrtKbn){
	 		var tmpIns = fm1.insNo.value;
	 		// 新規
	 		if(screenId == "NF011"){
	 			fm1.ultInsCd.value = insNo;
	 		} else {
	 			fm1.insNo.value = insNo;
	 		}
			fm1.tkdTrtKbn.value = tkdTrtKbn;

	 		if(nf001Tab && !nf001Tab.closed){
	 			nf001Tab.close();
	 		}

	 		nf001Tab = window.open("","NF001Tab");
			document.fm1.target="NF001Tab";


	  		fm1.screenId.value=screenId;
		  	fm1.functionId.value="Init";
		  	comSubmitForAnyWarp(fm1);
		  	comClickFlgInit();

		  	fm1.insNo.value = tmpIns;
		}

		 // 新規作成ボタン
	    function newBtn(){
	    	var tmpIns = fm1.insNo.value;
	    	fm1.insNo.value = "";

	    	document.fm1.target="";
		 	fm1.screenId.value="NF011";
		  	fm1.functionId.value="Init";

			if(nf001Tab && !nf001Tab.closed){
	 			nf001Tab.close();
	 		}

	 		nf001Tab = window.open("","NF001Tab");
			document.fm1.target="NF001Tab";
	  	  	comSubmitForAnyWarp(fm1);
	  	  	comClickFlgInit();

		  	fm1.insNo.value = tmpIns;
		}

	 	// ソートボタン
	    function sortBtn(sortCondition) {
			//ソート区分設定
	    	document.fm1.sortCondition.value = sortCondition;
	    	document.fm1.target="";
	        document.fm1.screenId.value	= "NF001";
	        document.fm1.functionId.value = "Search";

	      comSubmitForAnyWarp(fm1);
	    }

	 	// ページボタン
	    function pageBtn( pageCntCur ){
			//現在ページ番号変更（遷移）
			document.fm1.pageCntCur.value = pageCntCur;
			document.fm1.target="";
			document.fm1.screenId.value	= "NF001";
			document.fm1.functionId.value = "Search";
			// 検索イベント呼び出し
			comSubmitForAnyWarp(fm1);
    	}

	    function sosAddrChange() {
			//市区町村配列
			var val2 = document.getElementById("addrCodeCity");
			val2.value = '';
			//選択された都道府県のCD
			var val1 = document.getElementById("addrCodePref").value;

			for (i = 0; i < val2.length; i++) {
				//表示
				val2.options[i].style.display = "block";
				var val2Cd = val2[i].value;
				if(val2Cd != ""){
					//市区町村コードの頭2つ切り取る
					var val2cut = val2Cd.toString().substr(0, 2);
					if (val1 != val2cut) {
						val2.options[i];
						val2.options[i].style.display = "none";
					}
				}
			}
    	}

	    function addrCodeCityChange(){
	    	document.fm1.tmpAddrCodeCity.value = document.fm1.addrCodeCity.value;
	    }
    </script>
<%
// ソート順状態制御用
String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
%>
</head>

  <%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>

<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設検索"></td>
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

<table class="comPortalTable" align="center" style="width:95%;margin-top:0pt">
  <tbody>
  <tr/>
    <s:form name="fm0" theme="simple">
         <input type="hidden" name="endRecordNo1"   value=""  />
    </s:form>
    <s:form name="fm1" theme="simple" >
    <s:hidden name="screenId"  />
    <s:hidden name="functionId" />

    <s:hidden id="pageFlag" name="pageFlag" />

    <input type="hidden" name="windowName" value="" />
    <input type="hidden" name="openerName" value="" />

	<s:hidden name="loginJokenSetCd"/>
	<s:hidden name="loginJgiNo"/>
    <s:hidden name="loginNm"/>
    <s:hidden name="loginShzNm"/>
    <s:hidden name="loginTrtCd"/>
    <s:hidden name="loginBrCd"/>
    <s:hidden name="loginDistCd"/>
    <s:hidden name="backScreenId" value="NF001" />
    <s:hidden id="preScreenId" name="preScreenId"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>
	<s:hidden id="sortCondition" name="sortCondition" />

	<s:hidden id="callBack" name="callBack" />
	<s:hidden id="title" name="title" />
	<s:hidden id="srchFlg" name="srchFlg" />

	<s:hidden id="upSosCd" name="upSosCd"/>
	<s:hidden id="sosCdPop" name="sosCdPop"/>
	<s:hidden id="upSosCdPop" name="upSosCdPop"/>
	<s:hidden id="bumonRankPop" name="bumonRankPop"/>
	<s:hidden id="selectFlgPop" name="selectFlgPop"/>

	<s:hidden id="ultInsCd" name="ultInsCd"/>
	<s:hidden id="tkdTrtKbn" name="tkdTrtKbn"/>

	<s:hidden id="tmpAddrCodeCity" name="tmpAddrCodeCity" />

	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="bumonRyakuName" name="bumonRyakuName"/>
    <s:hidden id="brCode" name="brCode"/>
	<s:hidden id="distCode" name="distCode"/>
	<s:hidden id="trtCd" name="trtCd"/>
	<s:hidden id="trtNm" name="trtNm"/>
	<s:hidden id="mrCat" name="mrCat"/>

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

<%
  // ソート表示状態制御
  String insNoAscClass = "comTableNoSort";
  String insNoDescClass = "comTableNoSort";
  String insAbbrNameAscClass = "comTableNoSort";
  String insAbbrNameDescClass = "comTableNoSort";
  String insAddrAscClass = "comTableNoSort";
  String insAddrDescClass = "comTableNoSort";
  String shisetsuNmRyakuAscClass = "comTableNoSort";
  String shisetsuNmRyakuDescClass = "comTableNoSort";
  String addressAscClass = "comTableNoSort";
  String addressDescClass = "comTableNoSort";
  if ("1".equals(sortCondition)) {
	  insNoDescClass = "comTableSort";
  } else if ("2".equals(sortCondition)) {
	  insAbbrNameAscClass = "comTableSort";
  } else if ("3".equals(sortCondition)) {
	  insAbbrNameDescClass = "comTableSort";
  } else if ("4".equals(sortCondition)) {
	  insAddrAscClass = "comTableSort";
  } else if ("5".equals(sortCondition)) {
	  insAddrDescClass = "comTableSort";
  } else if ("6".equals(sortCondition)) {
	  shisetsuNmRyakuAscClass = "comTableSort";
  } else if ("7".equals(sortCondition)) {
	  shisetsuNmRyakuDescClass = "comTableSort";
  } else if ("8".equals(sortCondition)) {
	  addressAscClass = "comTableSort";
  } else if ("9".equals(sortCondition)) {
	  addressDescClass = "comTableSort";
  } else {
	  insNoAscClass = "comTableSort";
  }
%>
	<tr>
		<%-- 組織 --%>
		<td class="pupControlItem"><nobr>&nbsp;組織</nobr>
		   <nobr>
		   <input class="comButton" type="button" name="button1" value="選択" onClick="JavaScript:sosPopBtn(); return false;" />
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="sosNm" style="background-color:#D4D0C8" readonly="true" />
			<s:hidden key="sosCd" />
			<a href ="#" onClick="sosClearBtn();return false;">Clear</a>
		</td>
		<%-- 担当者 --%>
		<td class="pupControlItem"><nobr>&nbsp;担当者</nobr>
		   <nobr>
		   <s:if test="bumonRank == '2'">
		   	<input class="comButton" type="button" name="button2" value="選択" onClick="JavaScript:tantoPopBtn(); return false;" disabled />
		   </s:if>
		   <s:else>
		   	<input class="comButton" type="button" name="button2" value="選択" onClick="JavaScript:tantoPopBtn(); return false;" />
		   </s:else>
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="jgiNm" style="background-color:#D4D0C8" readonly="true" />
			<s:hidden key="jgiNo" />
			<a href ="#" onClick="tantoClearBtn();return false;">Clear</a>
		</td>
		<%-- 廃院区分 --%>
		<td class="pupControlItem"><nobr>&nbsp;廃院区分</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="delKbn" name="delKbn" cssStyle="width:80pt" list ="delKbnCombo" />
	    </td>
	</tr>
	<tr>
		<%-- 施設名(全角) --%>
		<td class="pupControlItem"><nobr>&nbsp;施設名(全角)※</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="insKanjSrch" />
		</td>
		<%-- 施設名(半角カナ) --%>
		<td class="pupControlItem"><nobr>&nbsp;施設名(半角カナ)※</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="insKanaSrch" />
		</td>
		<%-- 削除フラグ --%>
		<td class="pupControlItem"><nobr>&nbsp;削除フラグ</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="delFlg" name="delFlg" cssStyle="width:80pt" list ="delFlgCombo" />
	    </td>
	</tr>
	<tr>
		<%-- 施設固定C --%>
		<td class="pupControlItem"><nobr>&nbsp;施設固定C</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="insNo" />
		</td>
		<%-- ULT施設コード --%>
		<td class="pupControlItem"><nobr>&nbsp;ULT施設コード</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="ultInsNo" />
		</td>
		<%-- 経営主体 --%>
		<td class="pupControlItem"><nobr>&nbsp;経営主体</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="keieitai" name="keieitai" cssStyle="width:80pt" list ="keieitaiCombo" />
	    </td>
	</tr>
	<tr>
		<%-- 対象区分 --%>
		<td class="pupControlItem"><nobr>&nbsp;対象区分</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="hoInsType" name="hoInsType" cssStyle="width:80pt" list ="hoInsTypeCombo" />
	    </td>
	    <%-- 施設種別 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設種別</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="insType" name="insType" cssStyle="width:80pt" list ="insTypeCombo" />
	    </td>
	    <%-- 施設区分 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設区分</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="pharmType" name="pharmType" cssStyle="width:80pt" list ="pharmTypeCombo" />
	    </td>
	</tr>
	<tr>
		<%-- 電話番号(半角)※ --%>
		<td class="pupControlItem"><nobr>&nbsp;電話番号(半角)※</nobr></td>
        <td class="comTableSearchItem">
			<s:textfield size="20" maxlength="40" name="insPhoneSrch" />
	    </td>
	    <%-- 郵便番号(半角)※ --%>
		<td class="pupControlItem"><nobr>&nbsp;郵便番号(半角)※</nobr></td>
        <td class="comTableSearchItem">
			<s:textfield size="20" maxlength="40" name="insPcode" />
	    </td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
        <td class="comTableSearchItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 都道府県--%>
	    <td class="pupControlItem"><nobr>&nbsp;都道府県</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="addrCodePref" name="addrCodePref" cssStyle="width:80pt" list ="addrPrefCombo" onchange="sosAddrChange();addrCodeCityChange();" />
	    </td>
	    <%-- JIS市区町村名 --%>
	    <td class="pupControlItem"><nobr>&nbsp;JIS市区町村名</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="addrCodeCity" name="addrCodeCity" cssStyle="width:80pt" list ="addrCityCombo" onchange="addrCodeCityChange();" />
	    </td>
	    <%-- 新規作成 --%>
	    <td colspan=2><nobr>
		    <s:if test='srchFlg == "1" '>
	    		<input type="button" name="新規作成" value="新規作成" onclick="newBtn()" />
	    	</s:if>
	    	<s:else>
	    		<input type="button" name="新規作成" value="新規作成" onclick="newBtn()" disabled />
	    	</s:else>
			※新規作成の前に検索してください
		</nobr></td>
	</tr>
	<tr>
		<%-- 住所(全角) --%>
	    <td class="pupControlItem"><nobr>&nbsp;住所(全角)</nobr></td>
        <td class="comTableSearchItem" colspan=3>
			<s:textfield size="65" name="insAddrSrch" />
	    </td>
		<td colspan=2>
			<input type="button" value="検索" name="検索" onclick="gotoNext('NF001','Search')"/>
			<input type="button" name="クリア" value="クリア" onclick="clearBtn();return false;" />
		</td>
	</tr>
	<tr>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
        <td class="comTableSearchItem" colspan=3>
			※項目は、武田施設情報とアルトマーク施設情報を同時検索します。
	    </td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

<%-- ページャー表示 開始 --%>
          <s:if test='pageFlag == "1" '>
          </s:if>
          <s:if test='pageFlag !="1"'>
                 <!-- 改ページ -->
                  <table width="95%" >
                      <tbody>
                      <tr align="right">
                          <td>
                            <!-- 前頁リンク -->
                            <s:if test="pageCntCur > 1">
                            <nobr>
                                <a class="comMiniLink" href = "" onClick="pageBtn(<s:property value="pageCntCur-1"/>);return false;">
                                &lt;&lt; 前
                                </a>&nbsp;
                            </nobr>
                            </s:if>

                            <!-- ページ基準の前頁リンク -->
                            <s:if test="pageCntBase > 1">
                              <a class="comMiniLink"  href="" style="" onClick="pageBtn(<s:property value="pageCntBase-1"/>);return false;">
                              <nobr>～<s:property value="pageCntBase-1"/></nobr></a>
                            </s:if>

                            <!-- 各ページリンク作成 -->
                            <s:if test="pageCntAll > 1">
                              <s:iterator value="{'0','1','2','3','4','5','6','7','8','9'}" var="pageIndex" status="status">
                                <s:set var="pageCntCurTemp" value="#status.index + pageCntBase" />
                                <s:if test="#pageCntCurTemp <= pageCntAll">
                                  <s:if test="#pageCntCurTemp != pageCntCur">
                                    <a  class="comMiniLink"  href="" style="" onClick="pageBtn(<s:property value="#pageCntCurTemp"/>);return false;">
                                    <nobr><s:property value="#pageCntCurTemp"/></nobr></a>
                                  </s:if>
                                  <s:else>
                                    <!-- 現在ページはリンクではない -->
                                    <a  class="comMiniLink"  style="text-decoration:none;">
                                    <nobr><s:property value="#pageCntCurTemp"/></nobr></a>
                                  </s:else>
                                </s:if>
                              </s:iterator>
                            </s:if>
                            <!-- 次のグループ -->
                            <s:if test="(#pageCntBase + 10) <= pageCntAll">
                                &nbsp;
                                <a  class="comMiniLink"  href="" style="" onClick="pageBtn(<s:property value="#pageCntCurTemp-1"/>);return false;">
                                <nobr><s:property value="pageCntBase + 10"/>～</nobr></a>
                            </s:if>

                            <!-- 次頁  -->
                            <s:if test="pageCntCur < pageCntAll">
                              <nobr>&nbsp;
                                <a class="comMiniLink" href = "" onClick="pageBtn(<s:property value="pageCntCur+1"/>);return false;">
                                  次&gt;&gt;
                                </a>
                              </nobr>
                            </s:if>

                                 <nobr>
                            <s:if test="lineCntAll > 0">
                              &nbsp;&nbsp;
                              <s:property value="lineCntAll"/>件中
                              <s:property value="lineCntStart"/>～<s:property value="lineCntEnd"/>件
                            </s:if>
                            <s:else>
                              &nbsp;0件
                            </s:else>
                            </nobr>
                          </td>
                      </tr>
                      </tbody>
                  </table>
                  </s:if>
          <%-- ページャー表示 終了 --%>

    <div style="max-height:270px;width:1200px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
<table>
   <s:if test='pageFlag == "1" '>
          <!-- なにも表示しない -->
      </s:if>
   <s:else>
	<tr>
	    <td class="comFormTableItem" colSpan="3"><%-- スクロールバー用のテーブルクラスにすること --%>

	<%-- ヘッダー行 --%>
	<tr class="comTableTitle" style="position: sticky; top:0; left:0;">
		<td style="background-color:#FFFFFF; width:100px;" >&nbsp;</td>
		<td class="comTableTitleNF001W" style="width:130px">施設略式漢字名
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=insAbbrNameAscClass %>" href="" onclick="sortBtn(2);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=insAbbrNameDescClass %>" href="" onclick="sortBtn(3);return false;">▼</a>
		</td>
		<td class="comTableTitleNF001W" style="width:160px;">施設正式漢字名</td>
		<td class="comTableTitleNF001W" style="width:80px;">施設固定C
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=insNoAscClass %>" href="" onclick="sortBtn(0);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=insNoDescClass %>" href="" onclick="sortBtn(1);return false;">▼</a>
		</td>
		<td class="comTableTitleNF001W" style="width:200px;">施設住所
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=insAddrAscClass %>" href="" onclick="sortBtn(4);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=insAddrDescClass %>" href="" onclick="sortBtn(5);return false;">▼</a>
		</td>
		<td class="comTableTitleNF001W" style="width:150px;">電話番号</td>
		<td class="comTableTitleNF001W" style="width:90px;">施設種別</td>
		<td class="comTableTitleNF001W" style="width:90px;">経営主体</td>
		<td class="comTableTitleNF001W" style="width:70px;">ベッド数</td>
	</tr>
	<tr class="comTableTitle" style="position: sticky; top:20; left:0;">
		<td class="comTableTitleNF001Act">アクション</td>
		<td class="comTableTitleNF001">ULT施設略名
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=shisetsuNmRyakuAscClass %>" href="" onclick="sortBtn(6);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=shisetsuNmRyakuDescClass %>" href="" onclick="sortBtn(7);return false;">▼</a>
		</td>
		<td class="comTableTitleNF001">ULT施設名</td>
		<td class="comTableTitleNF001">ULT施設コード</td>
		<td class="comTableTitleNF001">ULT住所
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=addressAscClass %>" href="" onclick="sortBtn(8);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=addressDescClass %>" href="" onclick="sortBtn(9);return false;">▼</a>
		</td>
		<td class="comTableTitleNF001">ULT電話番号</td>
		<td class="comTableTitleNF001">ULT施設区分</td>
		<td class="comTableTitleNF001">ULT経営主体</td>
		<td class="comTableTitleNF001">ULTベッド数</td>
	</tr>

    <%-- 内容 --%>

	<s:iterator value="hcoSearchDataList" status="status" var="rowBean">
		<tr style="min-height:30px;">
			<td class="comTableItem" rowspan=2>
				<table>
				<%-- アクションアイコン --%>
				<tr>
					<%-- 新規作成 --%>
					<td style="width:18px;">
					<s:if test="#rowBean.funcFlg1 == 1">
	        	        <a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF011','<s:property value="#rowBean.dcfShisetsuCd"/>','');" >
	   		            <img border="0" src="img/button_insert.gif">
		                </a>
	                </s:if>
	                </td>
	                <%-- 編集 --%>
	                <td style="width:18px;">
	                <s:if test="#rowBean.funcFlg2 == 1">
	        	        <a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF012','<s:property value="#rowBean.insNo"/>','');" >
	   		            <img border="0" src="img/button_update.gif">
		                </a>
	                </s:if>
	                </td>
	                <%-- 削除 --%>
	                <td style="width:18px;">
        	        <s:if test="#rowBean.funcFlg3 == 1">
	        	        <a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF013','<s:property value="#rowBean.insNo"/>','');" >
	   		            <img border="0" src="img/button_delete.gif">
		                </a>
		            </s:if>
		            </td>
	                <%-- 復活 --%>
	                <td style="width:18px;">
	                <s:if test="#rowBean.funcFlg4 == 1">
        	        	<a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF014','<s:property value="#rowBean.insNo"/>','');" >
   		            	<img border="0" src="img/button_restoration.gif">
	                	</a>
	                </s:if>
	                </td>
                </tr>
                <tr>
                	<td>
					<%-- 親子紐づけ --%>
					<s:if test="#rowBean.funcFlg5 == 1">
	        	        <a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF201','<s:property value="#rowBean.insNo"/>','1');" >
	   		            <img border="0" src="img/button_linkcurrent.gif">
		                </a>
	                </s:if>
	                </td>
	                <td>
	                <%-- 来期用項目更新 --%>
	                <s:if test="#rowBean.funcFlg6 == 1">
	        	        <a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF101','<s:property value="#rowBean.insNo"/>','');" >
	   		            <img border="0" src="img/button_updatenext.gif">
		                </a>
		            </s:if>
		            </td>
	                <td>
	                <%-- 親子紐付け（来期） --%>
	                <s:if test="#rowBean.funcFlg7 == 1">
	        	        <a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF201','<s:property value="#rowBean.insNo"/>','0');" >
	   		            <img border="0" src="img/buttun_linknext.gif">
		                </a>
		            </s:if>
		            </td>
	                <td></td>
	            </tr>
	            </table>
			</td>
	        <td class="comTableItem" style="height:30px;"><s:label key="hcoSearchDataList[%{#status.index}].insAbbrName" /></td>
	        <td class="comTableItem"><s:label key="hcoSearchDataList[%{#status.index}].insFormalName" /></td>
	        <td class="comTableItem"><s:label key="hcoSearchDataList[%{#status.index}].insNo" /></td>
	        <td class="comTableItem"><s:label key="hcoSearchDataList[%{#status.index}].insAddr" /></td>
	        <td class="comTableItem"><s:label key="hcoSearchDataList[%{#status.index}].insPhone1" /></td>
	        <td class="comTableItem"><s:label key="hcoSearchDataList[%{#status.index}].insType" /></td>
	        <td class="comTableItem"><s:label key="hcoSearchDataList[%{#status.index}].keieitaiKj" /></td>
	        <td class="comTableItem"><s:label key="hcoSearchDataList[%{#status.index}].bedsTot" /></td>
		</tr>
		<tr>
	        <td class="comTableItemNF001"><s:label key="HcoSearchDataList[%{#status.index}].shisetsuNmRyaku" /></td>
	        <td class="comTableItemNF001"><s:label key="hcoSearchDataList[%{#status.index}].shisetsuNm" /></td>
	        <td class="comTableItemNF001"><s:label key="hcoSearchDataList[%{#status.index}].dcfShisetsuCd" /></td>
	        <td class="comTableItemNF001"><s:label key="hcoSearchDataList[%{#status.index}].address" /></td>
	        <td class="comTableItemNF001"><s:label key="hcoSearchDataList[%{#status.index}].shisetsuTel" /></td>
	        <td class="comTableItemNF001"><s:label key="hcoSearchDataList[%{#status.index}].ultPharmType" /></td>
	        <td class="comTableItemNF001"><s:label key="hcoSearchDataList[%{#status.index}].ultKeieitaiKj" /></td>
	        <td class="comTableItemNF001"><s:label key="hcoSearchDataList[%{#status.index}].byoshoSu" /></td>
		</tr>
	</s:iterator>
    </table>
</div>
</s:else>

    </td>
    </tr>
            <tr>
        	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="window.close();" />
                </nobr>
	      </td>

<%-- メイン部 一覧 終了    key="catDeptsComboDataList[%{#status.index}].addrNameArea" --%>
<!--  <hr class="comSplit" /> -->
<%-- 後制御部 --%>

	</table>

    </tbody>
    </table>
    </s:form>
    </table>
<%-- ポータルボディー 終了 --%>


<%-- メイン部 一覧 終了 --%>
<%-- ポータル大枠 終了 --%>
	<jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>