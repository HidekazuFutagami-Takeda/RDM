<%--
/**
 * <pre>
 *  親子紐付け一覧のJSP
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
    <title>NF201_親子紐付け一覧</title>
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

    </script>

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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="親子紐付け一覧"></td>
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
    <s:hidden name="backScreenId" value="NF201" />
    <s:hidden id="preScreenId" name="preScreenId"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="title" name="title" />

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

  <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--施設情報--%>
		<td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr></nobr></td>
	      <td class="comFormTableItem"><nobr>施設固定C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insNo"/><s:hidden name="insNo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>施設略式漢字名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insAbbrName"/><s:hidden name="insAbbrName"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>住所</nobr></td>
	      <td class="comFormTableItem" colspan=3><nobr><s:label key="insAddr"/><s:hidden name="insAddr"/></nobr></td>
      </tr>
  </table>

	<table id="formTable02" border="0" class="comPortalTable" align="center" style="width:98%;">
    	<tr>
        	<td style="width: 30%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 38%; height: 0px; border-width: 0px;"></td>
    	</tr>
		<tr>
	    	<td class="comFormTableItem"></td>
	    	<td class="comFormTableItem"></td>
	    	<td class="comFormTableItem">
            	<nobr>
	                <input class="comButton" type="button"name="buttonF3" value="追加" onClick="JavaScript;return false;" />
                </nobr>
	      	</td>
	      	<td class="comFormTableItem"></td>
	      	<td class="comFormTableItem"></td>
		</tr>
	</table>

<%-- 当期親施設一覧 --%>
<div id="jkrHeader" style="margin:0;width:800px;overflow-y:hidden;overflow-x:auto;position:relative;resize:horizontal;">
	<table class="comCustomTable" id="formTable03">
		<tr>
			<td>&nbsp;</td>
			<td colspan=6>当期<br>親施設一覧</td>
		</tr>
		<tr>
			<%-- ヘッダ行 --%>
			<td width="20px"><nobr>アクション</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>領域</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>品目グループ</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>施設略式漢字名</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>対象区分</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>住所</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>担当者</nobr></td>
		</tr>
 	<s:iterator value="hcoOyakoDataList" status="status" var="rowBean">
		<tr>
		<%--当期親施設データ取得項目--%>
			<td><%-- アクションボタン --%>
				<nobr>
				<a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF012','<s:property value="#rowBean.trtCd"/>');" >
   		            <img border="0" src="img/button_update.gif">
                </a>
				<a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF012','<s:property value="#rowBean.trtCd"/>');" >
					<img border="0" src="img/button_delete.gif">
				</a>
				</nobr>
			</td>
			<td><nobr><s:label key="hcoOyakoDataList[%{#status.index}].trtNm"/></nobr></td>
			<td><nobr><s:label key="hcoOyakoDataList[%{#status.index}].hinGNm"/></nobr></td>
			<td><nobr><s:label key="hcoOyakoDataList[%{#status.index}].insAbbrName"/></nobr></td>
			<td><nobr><s:label key="hcoOyakoDataList[%{#status.index}].hoInsType"/></nobr></td>
			<td><nobr><s:label key="hcoOyakoDataList[%{#status.index}].insAddr"/></nobr></td>
			<td><nobr><s:label key="hcoOyakoDataList[%{#status.index}].jgiName"/></nobr></td>
		</tr>
	</s:iterator>
	</table>
</div>

<%-- 来期親施設一覧 --%>
<div id="jkrHeader" style="margin:0;width:800px;overflow-y:hidden;overflow-x:auto;position:relative;resize:horizontal;">
	<table class="comCustomTable" id="formTable03">
		<tr>
			<td>&nbsp;</td>
			<td colspan=4>来期<br>親施設一覧</td>
		</tr>
		<tr>
			<%-- ヘッダ行 --%>
			<td width="20px"><nobr>適用日</nobr></td>
			<td width="20px"><nobr>アクション</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>領域</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>品目グループ</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>施設略式漢字名</nobr></td>
			<td class="comTableTitle" width="50px"><nobr>住所</nobr></td>
		</tr>
 	<s:iterator value="hcoOyakoNextDataList" status="status" var="rowBean">
		<tr>
		<%--来期親施設データ取得項目--%>
			<td><nobr><s:label key="hcoOyakoNextDataList[%{#status.index}].tekiyoYmd"/></nobr></td>
			<td><%-- アクション --%>
				<nobr>
				<a class="comMiniLink" href="#" onClick="JavaScript:actBtn('NF012','<s:property value="#rowBean.trtCd"/>');" >
					変更
                </a>
				</nobr>
			</td>
			<td><nobr><s:label key="hcoOyakoNextDataList[%{#status.index}].trtNm"/></nobr></td>
			<td><nobr><s:label key="hcoOyakoNextDataList[%{#status.index}].hinGNm"/></nobr></td>
			<td><nobr><s:label key="hcoOyakoNextDataList[%{#status.index}].insAbbrName"/></nobr></td>
			<td><nobr><s:label key="hcoOyakoNextDataList[%{#status.index}].insAddr"/></nobr></td>
		</tr>
	</s:iterator>
	</table>
</div>


    </td>
    </tr>
	<tr>
		<td class="comFormTableItem">
			<nobr>
	    	<input class="comButton" type="button"name="buttonF1" value="戻る" onClick="window.close();" />
	        </nobr>
		</td>
	</tr>

<%-- メイン部 一覧 終了  --%>
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