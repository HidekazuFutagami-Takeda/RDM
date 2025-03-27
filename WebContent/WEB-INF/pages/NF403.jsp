<%--
/**
 * <pre>
 *  施設来期項目一括申請のJSP
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>NF403_施設来期項目一括申請</title>
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
    }

    var sosSubScreenSize = "left=0, top=0, width=600, height=600";
 	// 組織選択ボタン
    function sosPopBtn(){
    	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
		// NC201_組織検索ポップアップを開く
		window.open("","sosPopWindow",sosSubScreenSize);
		document.fm1.screenId.value = "NC201";
		document.fm1.functionId.value="Init";
		document.fm1.target="sosPopWindow";

		document.fm1.selectFlgPop.value="1";

		document.fm1.callBack.value = "callBackSosPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
    }

 	// 組織検索ポップアップから値受け取り
    function callBackSosPop(bumonRank, sosCd,
	  		  bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){

    	if(bumonRank != null && bumonRank != "3"){
    		window.alert("エリア階層の組織を選択してください");
    		return false;
    	}

    	document.fm1.bumonRank.value = bumonRank;
		document.fm1.sosCd.value = sosCd;
		document.fm1.sosNm.value = bumonSeiName;
		document.fm1.brCode.value = brCode;
		document.fm1.distCode.value = distCode;
		document.fm1.upSosCd.value = upSosCode;

		if(bumonRank == null || bumonRank == "3"){
			document.getElementById("tantoButton").disabled = false;
		} else if(bumonRank == "2"){
			document.getElementById("tantoButton").disabled = true;
			tantoClearBtn();
		}
 	}

 	// 担当者選択ボタン
    function tantoPopBtn(){
    	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
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

	// 施設選択ボタン
    function insPopBtn(){
    	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
		// NC203_施設検索ポップアップ画面を表示
		window.open("","insPopWindow",insSubScreenSize);
		document.fm1.screenId.value = "NC203";
		document.fm1.functionId.value="Init";
		document.fm1.target="insPopWindow";

		document.fm1.viewKbn.value = "0";
		document.fm1.callBack.value = "callBackInsPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
    }

	// 施設ポップアップから施設受け取り
    function callBackInsPop(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType, insClass){

    	document.fm1.insNo.value = insNo;
    	document.fm1.insNm.value = insAbbrName;

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

 	// 施設Clearボタン
    function insClearBtn(){
		document.fm1.insNo.value = "";
		document.fm1.insNm.value = "";
		document.fm1.insKanjSrch.value = "";
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

		document.fm1.insNm.value = "";

		document.fm1.insNo.value = "";
		document.fm1.ultInsNo.value = "";
		document.fm1.insKanjSrch.value = "";
		document.fm1.shisetsuNmSrch.value = "";
		document.fm1.insClass.value = "";
		document.fm1.insType.value = "";
		document.fm1.hoInsType.value = "";

		document.fm1.shnFlgChk.checked = false;
	}

	// 画面遷移処理
    function gotoNext(screenId,functionId){
   		document.fm1.target="";
  	 	fm1.screenId.value=screenId;
  	  	fm1.functionId.value=functionId;
  	  	comSubmitForAnyWarp(fm1);
  	}

 	var nf401Tab;
 	// 申請歴ボタン
    function histBtn(insNo){
    	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
 		var tmpIns = fm1.insNo.value;

 		fm1.insNo.value = insNo;

 		if(nf401Tab && !nf401Tab.closed){
 			nf401Tab.close();
 		}

 		nf401Tab = window.open("","NF401Tab");
		document.fm1.target="NF401Tab";


  		fm1.screenId.value="NF102";
	  	fm1.functionId.value="Init";
	  	comSubmitForAnyWarp(fm1);
	  	comClickFlgInit();

	  	fm1.insNo.value = tmpIns;
	}

 	// ページボタン
    function pageBtn( pageCntCur ){
		//現在ページ番号変更（遷移）
		document.fm1.pageCntCur.value = pageCntCur;
		document.fm1.target="";
		document.fm1.screenId.value	= "NF401";
		document.fm1.functionId.value = "Search";
		// 検索イベント呼び出し
		comSubmitForAnyWarp(fm1);
	}

 	// 承認チェックボックス
 	function apprChk(chk, index){
 		let key = "hcoBlkReqDataList["+index+"].apprChk";
 		let apprFlg = document.getElementsByName(key)[0];

		if(chk.checked == true){
			apprFlg.value = "1";
		} else {
			apprFlg.value = "0";
		}
 	}

 	// 一括承認ボタン
 	function apprBtn(){
		let chkFlg = false;

 		let i = 0;
 		let key = "hcoBlkReqDataList["+i+"].apprChk";
 		let apprFlg = document.getElementsByName(key)[0];

 		while(apprFlg != undefined){
			if(apprFlg.value == "1"){
				chkFlg = true;
				break;
			}

			i++;
			key = "hcoBlkReqDataList["+i+"].apprChk";
	 		apprFlg = document.getElementsByName(key)[0];
 		}

 		if(!chkFlg){
 			// ・隠し項目．承認対象フラグ＝'1'の行が0件の場合、（W046）「承認する施設が未選択です。」エラーメッセージをポップアップで表示
 			window.alert("承認する施設が未選択です。");
 			return false;
 		}

 		if(window.confirm("申請データを承認します。よろしいですか？")){
			// ・隠し項目．承認対象フラグ＝'1'の行が1件以上の場合、（I012）「申請データを承認します。よろしいですか？」確認メッセージをポップアップで表示

			i = 0;
			key = "hcoBlkReqDataList["+i+"].aprComment";
			let aprComment = document.getElementsByName(key)[0];
			let strCom = document.getElementsByName("aprComment")[i];

			while(aprComment != undefined && strCom != undefined){
				aprComment.value = strCom.value;

				i++;
				key = "hcoBlkReqDataList["+i+"].aprComment";
				aprComment = document.getElementsByName(key)[0];
				strCom = document.getElementsByName("aprComment")[i];
			}

 			document.fm1.screenId.value="NF401";
			document.fm1.functionId.value="Approve";

			comSubmitForAnyWarp(fm1);
 		}
 	}

 	// 却下ボタン
 	function rejBtn(insNo, index){
 		document.fm1.rejectInsNo.value = insNo;
		var aprComment = document.getElementsByName("aprComment")[index].value;
 		document.fm1.rejectComment.value = aprComment;

 		if(aprComment.trim() == ""){
 			window.alert("却下の場合はコメントを入力してください。");
 			return false;
 		}

 		if(window.confirm("申請データを却下します。よろしいですか？")){
 			document.fm1.screenId.value="NF401";
			document.fm1.functionId.value="Reject";

			comSubmitForAnyWarp(fm1);
 		}
 	}

</script>
<style>
	.siz{
	width:2500px;
	}
	thead {
    position:Sticky;
    top:0;
    background-color: #fff;
    left: 2;
    }
</style>
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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設来期項目一括承認"></td>
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
    <s:hidden name="backScreenId" value="NF403" />
    <s:hidden id="preScreenId" name="preScreenId"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="callBack" name="callBack" />
	<s:hidden id="viewKbn" name="viewKbn" />
	<s:hidden id="title" name="title" />
	<s:hidden id="srchFlg" name="srchFlg" />

	<s:hidden id="btnEnableFlg" name="btnEnableFlg" />
	<s:hidden id="srchSysDate" name="srchSysDate" />

	<s:hidden id="upSosCd" name="upSosCd"/>
	<s:hidden id="sosCdPop" name="sosCdPop"/>
	<s:hidden id="upSosCdPop" name="upSosCdPop"/>
	<s:hidden id="bumonRankPop" name="bumonRankPop"/>
	<s:hidden id="selectFlgPop" name="selectFlgPop"/>

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
		   	<input class="comButton" type="button" id="tantoButton" name="button2" value="選択" onClick="JavaScript:tantoPopBtn(); return false;" disabled />
		   </s:if>
		   <s:else>
		   	<input class="comButton" type="button" id="tantoButton" name="button2" value="選択" onClick="JavaScript:tantoPopBtn(); return false;" />
		   </s:else>
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="jgiNm" style="background-color:#D4D0C8" readonly="true" />
			<s:hidden key="jgiNo" />
			<a href ="#" onClick="tantoClearBtn();return false;">Clear</a>
		</td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 施設 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設</nobr>
		   <nobr>
		   <input class="comButton" type="button" name="button1" value="選択" onClick="JavaScript:insPopBtn(); return false;" />
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="insNm" style="background-color:#D4D0C8" readonly="true" />
			<a href ="#" onClick="insClearBtn();return false;">Clear</a>
		</td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
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
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 施設略式漢字名 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設略式漢字名</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="insKanjSrch" />
		</td>
		<%-- ULT施設名 --%>
		<td class="pupControlItem"><nobr>&nbsp;ULT施設名</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="shisetsuNmSrch" />
		</td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 施設分類 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設分類</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="insClass" name="insClass" cssStyle="width:80pt" list ="insClassCombo" />
	    </td>
	    <%-- 施設種別 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設種別</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="insType" name="insType" cssStyle="width:80pt" list ="insTypeCombo" />
	    </td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 対象区分 --%>
		<td class="pupControlItem"><nobr>&nbsp;対象区分</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="hoInsType" name="hoInsType" cssStyle="width:80pt" list ="hoInsTypeCombo" />
	    </td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	    <%-- ULT差分 --%>
		<td class="pupControlItem"><nobr>&nbsp;ULT差分</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="ultDif" name="ultDif" cssStyle="width:80pt" list ="ultDifCombo" />
	    </td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td>
			<input type="button" name="クリア" value="クリア" onclick="clearBtn();return false;" />
			<input type="button" value="検索" name="検索" onclick="gotoNext('NF403','Search')"/>
		</td>
	</tr>

<%-- ページャー表示 開始 --%>
          <s:if test='pageFlag == "1" '>
          </s:if>
		<s:else>
          	<table width="80%">
          		<tr>
                    <td align="right">
                      <jsp:include page="common/rdmPage.jsp">
                      <jsp:param name="" value="" />
                      </jsp:include>
                    </td>
                </tr>
             </table>
          </s:else>
          <%-- ページャー表示 終了 --%>

   <s:if test='pageFlag == "1" '>
          <!-- なにも表示しない -->
      </s:if>
   <s:else>
    <div style="max-height:270px;width:1200px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
<table class="siz">
	<thead style="z-index:3;">
	<tr>
	    <td class="comFormTableItem" colSpan="3"><%-- スクロールバー用のテーブルクラスにすること --%>

	<%-- ヘッダー行 --%>
	<tr class="comTableTitle" style="position: sticky; top:0; left:0;">
		<td class="comTableTitle" style="width:50px" rowspan=2>申請</td>
		<td class="comTableTitle" style="width:80px;">施設固定C</td>
		<td class="comTableTitle" style="width:50px" rowspan=2>期</td>
		<td class="comTableTitle" style="width:130px" colspan=8>施設情報</td>
		<td class="comTableTitle" colspan=10>病床数情報</td>
		<td class="comTableTitle" style="width:50px" rowspan=2>ULT<br>差分</td>
		<td class="comTableTitle" style="width:70px" rowspan=2>申請コメント</td>
	</tr>
	<tr class="comTableTitle" style="position: sticky; top:20; left:0;">
		<td class="comTableTitle">施設略式漢字名</td>
		<td class="comTableTitle">施設区分</td>
		<td class="comTableTitle">階級区分</td>
		<td class="comTableTitle">定訪先区分</td>
		<td class="comTableTitle">重点病院区分</td>
		<td class="comTableTitle">対象区分</td>
		<td class="comTableTitle">経営主体</td>
		<td class="comTableTitle">ワクチン対象区分</td>
		<td class="comTableTitle">ワクチン定訪先区分</td>
		<td class="comTableTitle" style="width:40px">基準</td>
		<td class="comTableTitle" style="width:40px">結核</td>
		<td class="comTableTitle" style="width:40px">一般</td>
		<td class="comTableTitle" style="width:40px">感染症</td>
		<td class="comTableTitle" style="width:40px">精神</td>
		<td class="comTableTitle" style="width:40px">療養</td>
		<td class="comTableTitle" style="width:60px">医療療養</td>
		<td class="comTableTitle" style="width:60px">介護医療</td>
		<td class="comTableTitle" style="width:60px">ベッド数計</td>
		<td class="comTableTitle" style="width:70px">医療ベッド数計</td>
	</tr>
	</thead>

    <%-- 内容 --%>

	<s:iterator value="hcoBlkReqDataList" status="status" var="rowBean">
		<tr style="min-height:30px;">
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].reqChk"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insNo"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].pharmType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insRank"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].regVisType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].impHosType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].hoInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].manageNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacVisitType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCntBase"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt04"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt01"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt05"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt03"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt07"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt02"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt06"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].medBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultDif"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].reqComment"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insAbbrName"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].shisetsuKbn"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].keieitai"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCntBase"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt04"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt01"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt05"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt03"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt07"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultMedBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextPharmType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextInsRank"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextRegVisType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextImpHosType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextHoInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextManageNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextVacInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextVacVisitType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCntBase"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt04"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt01"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt05"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt03"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt07"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt02"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedCnt06"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextMedBedsTot"/>

			<td class="comTableItem" rowspan=3 style="text-align:center;">
				<s:if test='#rowBean.waitAppFlg == "1"'>
					<input type="checkbox" name="apprChkBox" onChange="JavaScript:apprChk(this,'<s:property value="%{#status.index}"/>'); return false;" />
				</s:if>
			</td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insNo" /></td>
	        <td class="comTableItem">当期</td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].pharmType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insRank" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].regVisType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].impHosType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].hoInsType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].manageNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].vacInsType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].vacVisitType" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCntBase" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt04" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt01" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt05" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt03" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt07" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt02" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt06" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedsTot" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].medBedsTot" /></td>
	        <td class="comTableItem" style="text-align:center" rowspan=3><s:label key="hcoBlkReqDataList[%{#status.index}].ultDif" /></td>
	        <td class="comTableItem" rowspan=3><s:label key="hcoBlkReqDataList[%{#status.index}].reqComment" /></td>
		</tr>
		<tr>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insAbbrName" /></td>
	        <td class="comTableItem">ULT</td>
	        <td class="comTableItemNF401"><s:label key="hcoBlkReqDataList[%{#status.index}].shisetsuKbn" /></td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401"><s:label key="hcoBlkReqDataList[%{#status.index}].keieitai" /></td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>

	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCntBase" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt04" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt01" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt05" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt03" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt07" /></td>
	        <td class="comTableItemNF401" style="text-align:right">&nbsp;</td>
	        <td class="comTableItemNF401" style="text-align:right">&nbsp;</td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedsTot" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultMedBedsTot" /></td>
		</tr>
		<tr style="min-height:30px;">
	        <td class="comTableItem">
	        	<input type="button" value="申請歴" onclick="histBtn('<s:property value="#rowBean.insNo"/>');return false;" />
	        </td>
	        <td class="comTableItem">来期</td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].nextPharmType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].nextInsRank" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].nextRegVisType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].nextImpHosType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].nextHoInsType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].nextManageNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].nextVacInsType" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].nextVacVisitType" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCntBase" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt04" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt01" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt05" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt03" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt07" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt02" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedCnt06" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextBedsTot" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].nextMedBedsTot" /></td>
		</tr>
	</s:iterator>
    </table>
</div>
</s:else>
    </td>
    </tr>
            <tr>
	      <td class="comFormTableItem">
	      <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:98%;">
	      <tr>
	        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 16%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 17%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 17%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
	      </tr>
			<tr>
	      		<td>
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="window.close();" />
                </nobr>
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>
               <nobr>
               	<s:if test='%{btnEnableFlg == "1"}'>
					<input class="comButton" type="button"name="buttonF3" value="一括申請" onClick="apprBtn();JavaScript:return false;" />
				</s:if>
				<s:else>
					&nbsp;
               	</s:else>
               </nobr>
               </td>
           </tr>
         </table>
	      </td>
	  </tr>
  </table>
     	</td>
    </tr>


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