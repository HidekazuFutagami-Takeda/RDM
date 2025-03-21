<%--
/**
 * <pre>
 *  領域別担当者一覧ポップアップのJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author SBS  千葉
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.NC208DTO"%>
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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<title>NC208_領域別担当者一覧ポップアップ</title>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<script type="text/javascript" src="js/catDeptsCombo.js"></script>
    <!-- css -->
    <style>
    	a {
    		color: inherit;
    	}

		a:hover{
			opacity:0.5;
			transition:0.3s;
			cursor: pointer;
		}
    	TABLE {
		    FONT-SIZE: 8pt;
		}
		/*テーブル幅可変*/
		.comTableTitle .comTableTitle{
			resize : horizontal;
			overflow : hidden;
			}

    	TD.comTableTitle			/* テーブル形式のタイトル項目 */
			{
			border-color: #f5f5f5;
		   color: #000000;
		   /* background-color: #e0e0d4; */
		   /* background-color: #cccccc; */
		   background-color: #e8b5a2;
		   text-align: center;
		   border-style: solid;
		   border-top-width: 0px;
		   border-left-width: 1px;
		   border-right-width: 1px;
		   border-bottom-width: 1px;
		   font-size: 8pt;
			}

			TD.comTableItem {
				color: #000000;
			    text-align: left;
			    border-style: solid;
			    border-top-width: 0px;
			    border-left-width: 1px;
			    border-right-width: 1px;
			    border-bottom-width: 1px;
			    font-size: 8pt;
			    border-color: #f5f5f5;
			}
    </style>
</head>
<body class="comPage">


<%-- submit用フォーム 開始 　まるっといらないかもって話がある--%>
	<form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
		<%--
		<input type="text" name="screenId"          value="" />
		<input type="text" name="functionId"        value="" />
		<input type="text" name="windowName"        value="" />
		<input type="text" name="openerName"        value="" />
		<input type="text" name="callBack"          value="" />
		<input type="text" name="winVarName"        value="" />
		<input type="text" name="fromScreenId1"     value="" />
		<input type="text" name="fromFunctionId1"   value="" />
		<input type="text" name="kensakuKana1"      value="" />
		<input type="text" name="kensakuKanj1"      value="" />
		<input type="text" name="pageNextBackFlag1" value="" />
		<input type="text" name="startRecordNo1"    value="" />
		<input type="text" name="pageLines1"        value="" />
		<input type="text" name="no1"               value="1" />

			チェック済みを記憶するために<div>タグの空間にhidden属性の
			inputをJavaScriptで動的に配置する。

		<input type="hidden" name="cdcCheckedCodes1" value="dummy">
		<input type="hidden" name="cdcCheckedCodes1" value="dummy">
		<input type="text" name="dummy"             value="dummy" />
		--%>
	</form>
<%-- submit用フォーム 終了 --%>
<%-- input用フォーム 開始 --%>
  <s:form name="fm1" theme="simple">
	<%-- 常に配列にするためにダミーを配置 --%>
    <s:hidden name="callBack" />
    <s:hidden name="insNo" />
    <s:hidden name="insAbbrName" />
    <s:hidden name="winVarName" />
    <s:hidden name="paramInsNo" />
    <s:hidden name="pageCntAll" />
    <s:hidden name="pageCntCur" />
    <s:hidden name="pageCntBase" />
    <s:hidden name="lineCntStart" />
    <s:hidden name="lineCntEnd" />
    <s:hidden name="lineCntAll1" />
    <s:hidden name="checkers" value="dummy" /><%-- チェックボックス --%>
    <s:hidden name="deptCode" value="dummy" />
    <s:hidden name="kanaName" value="dummy" />
    <s:hidden name="kanjName" value="dummy" />
    <s:hidden name="cdcCheckedCodes" value="dummy" />
    <s:hidden name="cdcCheckedCodes" value="dummy" />
    <div id="cdcCheckedCodesDiv" style="display:none">
    <s:iterator value="cdcCheckedCodes" var="code">
        <s:if test="%{#code == 'dummy'}">
        </s:if>
        <s:else>
            <s:hidden name="cdcCheckedCodes" value="%{code}" />
        </s:else>
    </s:iterator>
    </div>
    <s:url id="searchurl" action="RDMNC204Search"/>
    <s:submit name="submit_search" value="検索イベント" onclick="this.form.action='%{searchurl}'; this.form.submit();return false;" cssStyle="display:none" />
    <s:url id="pageurl" action="RDMNC204Page"/>
    <s:submit name="page_search" value="改ページイベント" onclick="this.form.action='%{pageurl}'; this.form.submit();return false;" cssStyle="display:none" />

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

	<CENTER>

     	<table class="pupReferenceDetail" align="center" style="width: 600px;">
	        <tr>
	            <%-- 施設固定C --%>
		          <td class="comTableSearchItem">
		          	<nobr>施設固定C </nobr><s:property value="insNo" />
		          </td>
	            <%-- 施設略式漢字名 --%>
	            <td class="comTableSearchItem">
	            	<nobr>施設略式漢字名 </nobr><s:property value="insAbbrName" />
	            </td>

	        </tr>
	    </table>

	<script>
		document.addEventListener("DOMContentLoaded", function(){
			const emailLinks = document.querySelectorAll(".email-link");

			emailLinks.forEach(link => {
				link.addEventListener("click", function(event) {
					event.preventDefault();
					const email = this.querySelector(".email").textContent;
					openMailer(email);
				});
			});
		});

		function openMailer(email) {
			const subject = encodeURIComponent("お問い合わせ");
			const body = encodeURIComponent("本文サンプル");
			const mailtolink = 'mailto:${email}?subject=${subject}&body=${body}';
			window.location.href = mailtoLink;
		}


	</script>



<%-- 検索部 終了 --%>
<%-- ページ情報 --%>


    <table class="comTableTitle" align="center" border="1" cellpadding="2" cellspacing="0" style="border: 0px none;">
    <%-- 項目 --%>
        <tr>
            <td class="comTableTitle" style="width:300pt;"><nobr>領域</nobr></td>
            <td class="comTableTitle" style="width:146pt;"><nobr>所属</nobr></td>
            <td class="comTableTitle" style="width:146pt;"><nobr>担当者</nobr></td>
        　　　　　　　 <td class="comTableTitle" style="width:146pt;"><nobr>メールアドレス</nobr></td>
            <td class="comTableTitle" style="width:8pt;"><nobr>主／副</nobr></td>
        </tr>

    <%-- 内容 --%>
    <s:iterator value="insTrtDataList" status="status" var="rowBean">
        <tr>
        	<!-- 領域 -->
			<td class="comTableItem" id="left"  ><s:label key="insTrtDataList[%{#status.index}].trtNm" /></td>
			<!-- 所属 -->
			<td class="comTableItem" id="left"  >
				<s:if test="%{#rowBean.bumon == null || #rowBean.bumon == ''}">
	            	<nobr>&nbsp;</nobr>
	            </s:if>
	            <s:else>
					<s:label key="insTrtDataList[%{#status.index}].bumon" />
	            </s:else>
			</td>
			<!-- 担当者 -->
			<td class="comTableItem" id="left"  ><s:label key="insTrtDataList[%{#status.index}].jgiName" /></td>
			<!-- メールアドレス -->
			<td class="comTableItem" id="left"  >
				<s:if test="%{#rowBean.jgiMailAddress == null || #rowBean.jgiMailAddress == ''}">
	            	<nobr>&nbsp;</nobr>
	            </s:if>
	            <s:else>
	            	<a href="#" class="email-link">
	            		<span class="email">
	            			<s:label key="insTrtDataList[%{#status.index}].jgiMailAddress"/>
	            		</span>
					</a>
	            </s:else>
			</td>
			<!-- 主／副 -->
			<td class="comTableItem" id="left"  >
				<s:if test="%{#rowBean.value1Kanj == null || #rowBean.value1Kanj == ''}">
	            	<nobr>&nbsp;</nobr>
	            </s:if>
	            <s:else>
					<s:label id="address" key="insTrtDataList[%{#status.index}].value1Kanj" />
	            </s:else>
			</td>

        </tr>
    </s:iterator>
    </table>
	</CENTER>


<%-- メイン部 一覧 終了 --%>

<%-- チェック済み表示欄 終了 --%>
    <hr class="comSplit" />
<%-- 後制御部 --%>
    <table class="comPortalControlTable comPortalControlTablePopup" align="center" style="width:300pt;">
        <tr>
            <td width="100%"></td>
            <td class="comPortalControlItem">
                <nobr>
                <input type="button" value="閉じる" OnClick="cdcClose();">
                </nobr>
            </td>
        </tr>
    </table>
	</td></tr>
	</table>
<%-- ポータルボディー 終了 --%>
  </s:form>
<%-- input用フォーム 終了 --%>
</body>
</html>
