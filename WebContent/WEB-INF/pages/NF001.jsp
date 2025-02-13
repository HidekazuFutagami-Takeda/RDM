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
	    }

	    function searchBtn() {

			document.fm1.screenId.value	= "NF001";
	        document.fm1.functionId.value = 'Search';

	        // 検索イベント呼び出し
	        comSubmitForAnyWarp(fm1);

	    }
    </script>
<%


// ソート順状態制御用
String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
//String sortCondition = null;
%>
</head>
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

    <s:hidden id="preScreenId" name="preScreenId"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>
	<s:hidden id="sortCondition" name="sortCondition" />

	<s:hidden id="bumonRank" name="bumonRank"/>
<!--  <s:hidden id="bumonRyakuName" name="bumonRyakuName"/>  申請者所属-->
    <s:hidden id="brCode" name="brCode"/><!-- 申請者所属リージョン -->
	<s:hidden id="distCode" name="distCode"/><!-- 申請者所属エリア -->

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>


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
<table>
<%
  // ソート表示状態制御
  String reqIdAscClass = "comTableNoSort";
  String reqIdDescClass = "comTableNoSort";
  String reqYmdhmsAscClass = "comTableNoSort";
  String reqYmdhmsDescClass = "comTableNoSort";
  String reqSbtAscClass = "comTableNoSort";
  String reqSbtDescClass = "comTableNoSort";
  String reqTypeAscClass = "comTableNoSort";
  String reqTypeDescClass = "comTableNoSort";
  String reqStsAscClass = "comTableNoSort";
  String reqStsDescClass = "comTableNoSort";
  String sbtAscClass = "comTableNoSort";
  String sbtDescClass = "comTableNoSort";
  String reqJgiNameAscClass = "comTableNoSort";
  String reqJgiNameDescClass = "comTableNoSort";
  if ("1".equals(sortCondition)) {
	  reqIdDescClass = "comTableSort";
  } else if ("2".equals(sortCondition)) {
	  reqYmdhmsAscClass = "comTableSort";
  } else if ("3".equals(sortCondition)) {
	  reqYmdhmsDescClass = "comTableSort";
  } else if ("4".equals(sortCondition)) {
	  reqSbtAscClass = "comTableSort";
  } else if ("5".equals(sortCondition)) {
	  reqSbtDescClass = "comTableSort";
  } else if ("6".equals(sortCondition)) {
	  reqTypeAscClass = "comTableSort";
  } else if ("7".equals(sortCondition)) {
	  reqTypeDescClass = "comTableSort";
  } else if ("8".equals(sortCondition)) {
	  reqStsAscClass = "comTableSort";
  } else if ("9".equals(sortCondition)) {
	  reqStsDescClass = "comTableSort";
  } else if ("10".equals(sortCondition)) {
	  sbtAscClass = "comTableSort";
  } else if ("11".equals(sortCondition)) {
	  sbtDescClass = "comTableSort";
  } else if ("12".equals(sortCondition)) {
	  reqJgiNameAscClass = "comTableSort";
  } else if ("13".equals(sortCondition)) {
	  reqJgiNameDescClass = "comTableSort";
  }
%>
	<tr>
		<%-- 組織 --%>
		<td class="pupControlItem"><nobr>&nbsp;組織</nobr>
		   <nobr><s:submit value="選択" name="選択" onclick="gotoNext('NC201','Init')"/>
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="sosNm" style="background-color:#D4D0C8" readonly="true" />
			<s:hidden key="sosCd" />
			<a href ="" onClick="popClear();return false;">Clear</a>
		</td>
		<%-- 担当者 --%>
		<td class="pupControlItem"><nobr>&nbsp;担当者</nobr>
		   <nobr><s:submit value="選択" name="選択" onclick="gotoNext('NC202','Init')"/>
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="jgiNm" style="background-color:#D4D0C8" readonly="true" />
			<s:hidden key="jgiNo" />
			<a href ="" onClick="popClear();return false;">Clear</a>
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
			<s:select id="addrCodePref" name="addrCodePref" cssStyle="width:80pt" list ="addrPrefCombo" />
	    </td>
	    <%-- JIS市区町村名 --%>
	    <td class="pupControlItem"><nobr>&nbsp;JIS市区町村名</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="addrCodeCity" name="addrCodeCity" cssStyle="width:80pt" list ="addrCityCombo" />
	    </td>
	    <%-- 新規作成 --%>
	    <td colspan=2><nobr>
	    	<s:submit value="新規作成" name="新規作成" onclick="gotoNext('NF011','Init')"/>
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
			<input type="button" name="search" value="検索" onclick="javaScript:searchBtn();">
			<input type="button" name="クリア" value="クリア" onclick="rdmCler();return false;" />
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
                                <a class="comMiniLink" href = "" onClick="NF001Page(<s:property value="pageCntCur-1"/>);return false;">
                                &lt;&lt; 前
                                </a>&nbsp;
                            </nobr>
                            </s:if>

                            <!-- ページ基準の前頁リンク -->
                            <s:if test="pageCntBase > 1">
                              <a class="comMiniLink"  href="" style="" onClick="NF001Page(<s:property value="pageCntBase-1"/>);return false;">
                              <nobr>～<s:property value="pageCntBase-1"/></nobr></a>
                            </s:if>

                            <!-- 各ページリンク作成 -->
                            <s:if test="pageCntAll > 1">
                              <s:iterator value="{'0','1','2','3','4','5','6','7','8','9'}" var="pageIndex" status="status">
                                <s:set var="pageCntCurTemp" value="#status.index + pageCntBase" />
                                <s:if test="#pageCntCurTemp <= pageCntAll">
                                  <s:if test="#pageCntCurTemp != pageCntCur">
                                    <a  class="comMiniLink"  href="" style="" onClick="NF001Page(<s:property value="#pageCntCurTemp"/>);return false;">
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
                                <a  class="comMiniLink"  href="" style="" onClick="NF001Page(<s:property value="#pageCntCurTemp-1"/>);return false;">
                                <nobr><s:property value="pageCntBase + 10"/>～</nobr></a>
                            </s:if>

                            <!-- 次頁  -->
                            <s:if test="pageCntCur < pageCntAll">
                              <nobr>&nbsp;
                                <a class="comMiniLink" href = "" onClick="NF001Page(<s:property value="pageCntCur+1"/>);return false;">
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
</table>
    <div style="max-height:400px;width:1200px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
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
		     <a class="<%=reqIdAscClass %>" href="" onclick="NF001Sort(2);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqIdDescClass %>" href="" onclick="NF001Sort(3);return false;">▼</a>
		</td>
		<td class="comTableTitleNF001W" style="width:160px;">施設正式漢字名</td>
		<td class="comTableTitleNF001W" style="width:80px;">施設固定C
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqSbtAscClass %>" href="" onclick="NF001Sort(0);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqSbtDescClass %>" href="" onclick="NF001Sort(1);return false;">▼</a>
		</td>
		<td class="comTableTitleNF001W" style="width:200px;">施設住所
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqTypeAscClass %>" href="" onclick="NF001Sort(4);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqTypeDescClass %>" href="" onclick="NF001Sort(5);return false;">▼</a>
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
		     <a class="<%=reqIdAscClass %>" href="" onclick="NF001Sort(6);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqIdDescClass %>" href="" onclick="NF001Sort(7);return false;">▼</a>
		</td>
		<td class="comTableTitleNF001">ULT施設名</td>
		<td class="comTableTitleNF001">ULT施設コード</td>
		<td class="comTableTitleNF001">ULT住所
			 <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqTypeAscClass %>" href="" onclick="NF001Sort(8);return false;">▲</a>
		     <span style="font-size: 1pt;"> </span>
		     <a class="<%=reqTypeDescClass %>" href="" onclick="NF001Sort(9);return false;">▼</a>
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
				<%-- アクションアイコン --%>
				<nobr>
					<%-- 新規作成 --%>
        	        <a class="comMiniLink" href="#" onClick="JavaScript:gotoNext('NF011','Init');" >
   		            <img border="0" src="img/button_insert.gif">
	                </a>
	                <%-- 編集 --%>
        	        <a class="comMiniLink" href="#" onClick="JavaScript:gotoNext('NF012','Init');" >
   		            <img border="0" src="img/button_update.gif">
	                </a>
	                <%-- 削除 --%>
        	        <a class="comMiniLink" href="#" onClick="JavaScript:gotoNext('NF013','Init');" >
   		            <img border="0" src="img/button_delete.gif">
	                </a>
	                <%-- 復活 --%>
        	        <a class="comMiniLink" href="#" onClick="JavaScript:gotoNext('NF014','Init');" >
   		            <img border="0" src="img/button_restoration.gif">
	                </a>
	            </nobr>
	            <br>
	            <nobr>
					<%-- 親子紐づけ --%>
        	        <a class="comMiniLink" href="#" onClick="JavaScript:gotoNext('NF201','Init');" >
   		            <img border="0" src="img/button_linkcurrent.gif">
	                </a>
	                <%-- 来期用項目更新 --%>
        	        <a class="comMiniLink" href="#" onClick="JavaScript:gotoNext('NF101','Init');" >
   		            <img border="0" src="img/button_updatenext.gif">
	                </a>
	                <%-- 親子紐付け（来期） --%>
        	        <a class="comMiniLink" href="#" onClick="JavaScript:gotoNext('NF202','Init');" >
   		            <img border="0" src="img/buttun_linknext.gif">
	                </a>
	            </nobr>
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
    </table>
            <tr>
        	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backBtn();return false;" />
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
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
