<%--
/**
 * <pre>
 *  通知一覧のJSP
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
    <title>NM011_通知一覧</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <%-- 040C共通のjs --%>
    <!-- <script type="text/javascript" src="js/JKR040C000.js"></script>-->

    <script type="text/javascript" src="js/NM011.js"></script>
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/JKR040C010.js"></script>
    <!--<script type="text/javascript" src="js/RDMNC011.js"></script>-->
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
        <style>
    .parent {
        display:flex;
        align-items:cener;
        gap:0;
    }
    thead {
        position:Sticky;
        top:0;
        background-color: #fff;
        left: 2;
        }
    th {
    	background-color: #ffffff;
    	border: 1px solid black;
        height:2px;
    }
    </style>
    <style>
	    .testlayout {
	    }
		.siz{
		width:1500px;
		}
	TH.comTableTitle			/* テーブル形式のタイトル項目 */
       {
         color : #000000;
         background-color: #e0e0d4;
       /*	background-color: #cccccc;*/
         background-color: #e8b5a2;

         border-style: solid;
         border-top-width : 1px;
         border-left-width : 1px;
         border-right-width : 1px;
         border-bottom-width : 1px;
                   /*テーブル幅可変*/
	      resize : horizontal;
		  overflow : hidden;
		  font-weight:normal;
       }
       	TD.comTableTitle			/* テーブル形式のタイトル項目 */
       {
         color : #000000;
         background-color: #e0e0d4;
       /*	background-color: #cccccc;*/
         background-color: #e8b5a2;

         border-style: solid;
         border-top-width : 1px;
         border-left-width : 1px;
         border-right-width : 1px;
         border-bottom-width : 1px;
                   /*テーブル幅可変*/
	      resize : horizontal;
		  overflow : hidden;
		  font-weight:normal;
       }
       TD.tkdUlt:nth-child(1) {
         position: sticky;
         left: 0;
         z-index:100;
       }
       TD.tkdUlt:nth-child(2) {
         position: sticky;
         left: 109;
         z-index:100;
       }
       TD.tkdUlt:nth-child(3) {
         position: sticky;
         left: 259;
         z-index:100;
       }
	</style>
<%
// ソート順状態制御用
String sortCondition = StringUtils.nvl((String)request.getAttribute("sortCondition"), "");
//String sortCondition = null;
%>
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
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo(); sosSbt();">

  <%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>


 <table class="comPortalTable" align="center" style="width:98%;">
   <tr>
	<td>
    <s:form name="fm1" theme="simple" >
    <s:hidden name="screenId"  />
    <s:hidden name="functionId" />

    <s:hidden id="pageFlag" name="pageFlag" />

    <input type="hidden" name="windowName" value="" />
    <input type="hidden" name="openerName" value="" />

	<s:hidden id="mrAdminCd" name="mrAdminCd"/>
    <s:hidden id="mrAdminFlg" name="mrAdminFlg"/>
    <s:hidden id="preScreenId" name="preScreenId"/>


	<s:hidden id="jgiNo" name="jgiNo"/>
    <s:hidden id="jgiName" name="jgiName"/>
    <s:hidden id="reqJgiName"/>

	<s:hidden id="reqJgiNo" name="reqJgiNo"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="knYmdhmsFrom" name="knYmdhmsFrom"/>
	<s:hidden id="knYmdhmsTo" name="knYmdhmsTo"/>

<!--  	<s:hidden id="reqId" name="reqId"/>
	<s:hidden id="reqType" name="reqType"/>-->

	<s:hidden id="sortCondition" name="sortCondition" />
	<s:hidden name="title" />
	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="sosCd" name="sosCd"/>
<!--  <s:hidden id="bumonRyakuName" name="bumonRyakuName"/>  申請者所属-->
    <s:hidden id="brCode" name="brCode"/><!-- 申請者所属リージョン -->
	<s:hidden id="distCode" name="distCode"/><!-- 申請者所属エリア -->
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="通知一覧"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>

<%-- ポータルタイトル 終了 --%>
<%-- ポータルボディー 開始 --%>

	<table class="comPortalBody" style="align:cener;">
		<tbody>
      	<tr align="center">
       	<td>
				<%-- 検索部 開始 --%>
			<table id="formTable00" border="0" cellpadding="2" cellspacing="0" width="600px" >
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
	<table style="align:cener;">
		<tr>
					<%-- 通知分類--%>
			    <td class="pupControlItem" ><nobr>&nbsp;通知分類</nobr></td>
	            <td class="comTableSearchItem">
				<s:select id="jkrSosAddrCd" name="aDdrCodePref" cssStyle="width:80pt" list ="jkrSosAddrMap" />
			    </td>
		</tr>
		<tr>
						<%-- 通知件名 --%>
			<td class="pupControlItem"><nobr>&nbsp;通知件名</nobr><!-- ReqShz,bumonRyakuName --></td>
	            <td class="comTableSearchItem">
				<s:select id="jkrSosNtySubject" name="ntySubject" cssStyle="width:80pt" list ="jkrSosNtySubject" />
			    </td>
		</tr>
		<tr>	<%-- ステータス --%>
			<td class="pupControlItem"><nobr>&nbsp;ステータス</nobr></td>
				<td>
					 <s:textfield size="20" maxlength="40" name="insKanjiSrch" STYLE="ime-mode:active" />
				</td>
		</tr>
		<tr>
							<%-- 優先度 --%>
			<td class="pupControlItem"><nobr>&nbsp;優先度</nobr></td>
	            <td class="comTableSearchItem">
				<s:select id="jkrSosNtyPri" name="ntyPri" cssStyle="width:80pt" list ="jkrSosNtyPri" />
			    </td>
		</tr>
		<tr>
			<td class="pupControlItem"><nobr>&nbsp;申請日</nobr></td>
				<td>
				<input type="date" name ="hisYmdhmsFrom"id="inHisYmdhmsFrom" value="${inhisYmdhmsFrom}" pattern="yyyy-MM-dd" />　～　
				<input type="date" name ="hisYmdhmsTo"  id="inHisYmdhmsTo" value="${inhisYmdhmsTo}" pattern="yyyy-MM-dd" />
			</td>
		</tr>
		<tr>
			   <td>
				   <input type="button" name="search" value="検索" onclick="rdmSearch();">
				   <input type="button" name="クリア" value="クリア" onclick="rdmCler();return false;" />
			   </td>
		</tr>
	</table>
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
                                <a class="comMiniLink" href = "" onClick="NM011Page(<s:property value="pageCntCur-1"/>);return false;">
                                &lt;&lt; 前
                                </a>&nbsp;
                            </nobr>
                            </s:if>

                            <!-- ページ基準の前頁リンク -->
                            <s:if test="pageCntBase > 1">
                              <a class="comMiniLink"  href="" style="" onClick="NM011Page(<s:property value="pageCntBase-1"/>);return false;">
                              <nobr>～<s:property value="pageCntBase-1"/></nobr></a>
                            </s:if>

                            <!-- 各ページリンク作成 -->
                            <s:if test="pageCntAll > 1">
                              <s:iterator value="{'0','1','2','3','4','5','6','7','8','9'}" var="pageIndex" status="status">
                                <s:set var="pageCntCurTemp" value="#status.index + pageCntBase" />
                                <s:if test="#pageCntCurTemp <= pageCntAll">
                                  <s:if test="#pageCntCurTemp != pageCntCur">
                                    <a  class="comMiniLink"  href="" style="" onClick="NM011Page(<s:property value="#pageCntCurTemp"/>);return false;">
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
                                <a  class="comMiniLink"  href="" style="" onClick="NM011Page(<s:property value="#pageCntCurTemp-1"/>);return false;">
                                <nobr><s:property value="pageCntBase + 10"/>～</nobr></a>
                            </s:if>

                            <!-- 次頁  -->
                            <s:if test="pageCntCur < pageCntAll">
                              <nobr>&nbsp;
                                <a class="comMiniLink" href = "" onClick="NM011Page(<s:property value="pageCntCur+1"/>);return false;">
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
          <s:if test='pageFlag == "1" '>
          <!-- なにも表示しない -->
      	  </s:if>
      	  <s:else>
              <div style="max-height:300px;width:1450px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
              <table class="siz">
              		<thead style="z-index:3;">
              <%-- ヘッダー行 --%>
												<tr>
													<!-- style="resize : horizontal;overflow : hidden;   " -->

													<td rowspan="4" class="comTableTitle container tkdUlt" width="120px"
														style="border: none;z-index:3;" id="styles">通知ID <span
														style="font-size: 1pt;"> </span> <a
														class="<%=reqIdAscClass%>" href=""
														onclick="NC011Sort(0);return false;">▲</a> <span
														style="font-size: 1pt;"> </span> <a
														class="<%=reqIdDescClass%>" href=""
														onclick="NC011Sort(1);return false;">▼</a>
													</td>
													<td rowspan="4" class="comTableTitle container tkdUlt" width="180px"
														style="border: none;">発生日時 <span
														style="font-size: 1pt;"> </span> <a
														class="<%=reqYmdhmsAscClass%>" href=""
														onclick="NC011Sort(2);return false;">▲</a> <span
														style="font-size: 1pt;"> </span> <a
														class="<%=reqYmdhmsDescClass%>" href=""
														onclick="NC011Sort(3);return false;">▼</a>
													</td>
													<td rowspan="4" class="comTableTitle container tkdUlt" width="120px"
														style="border: none;">通知分類
													</td>
													<td class="comTableTitle container"
														style="width: 140px; border: none;">通知件名
													</td>
													<td class="comTableTitle container"
														style="width: 500px; border: none;">通知内容</td>
													<td class="comTableTitle container"
														style="width: 500px; border: none;">通知メモ</td>											</td>
													<td class="comTableTitle container"
														style="width: 90px; border: none;">通知ステータス</td>
													<td class="comTableTitle container"
														style="width: 80px; border: none;">通知優先度</td>
													<td class="comTableTitle container"
														style="width: 180px; border: none;">最終更新日時</td>
												</tr>
								</thead>
												<%-- 内容 --%>
				<s:iterator value="catTuuchiComboDataList" status="status" var="rowBean">
					<tr>
						 <td class="comTableItem tkdUlt"style="z-index:2;">
						  <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni('<s:property  value="ntyId" />','<s:property  value="reqId" />');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label  name="catTuuchiComboDataList[%{#status.index}].ntyId"  key="catTuuchiComboDataList[%{#status.index}].ntyId" />
						            <s:hidden  name="catTuuchiComboDataList[%{#status.index}].ntyId"  key="catTuuchiComboDataList[%{#status.index}].ntyId" />
						          </acronym>
			              </a>
				  		 </td>
				  		 <td class="comTableItem tkdUlt" style="z-index:2;"><s:label  name="catTuuchiComboDataList[%{#status.index}].hisYmdhmsTo"  key="catTuuchiComboDataList[%{#status.index}].hisYmdhmsTo" /></td>
				         <td class="comTableItem tkdUlt" style="z-index:2;"><s:label  name="catTuuchiComboDataList[%{#status.index}].ntyBri"  key="catTuuchiComboDataList[%{#status.index}].ntyBri" /></td>
				         <td class="comTableItem" ><s:label  name="catTuuchiComboDataList[%{#status.index}].ntySubject"  key="catTuuchiComboDataList[%{#status.index}].ntySubject" /></td>
				         <td class="comTableItem" ><s:label  name="catTuuchiComboDataList[%{#status.index}].ntyData.replaceAll('\\n', '<br />')"  key="catTuuchiComboDataList[%{#status.index}].ntyData.replaceAll('\\n', '<br />')" /></td>
				         <td class="comTableItem" ><s:label  name="catTuuchiComboDataList[%{#status.index}].ntyMemo"  key="catTuuchiComboDataList[%{#status.index}].ntyMemo"/></td>
				         <td class="comTableItem" ><s:label  name="catTuuchiComboDataList[%{#status.index}].ntySts"  key="catTuuchiComboDataList[%{#status.index}].ntySts" /></td>
				         <td class="comTableItem" ><s:label  name="catTuuchiComboDataList[%{#status.index}].ntyPri"  key="catTuuchiComboDataList[%{#status.index}].ntyPri" /></td>
				         <td class="comTableItem" ><s:label  name="catTuuchiComboDataList[%{#status.index}].ssUpdYmdhms"  key="catTuuchiComboDataList[%{#status.index}].ssUpdYmdhms" /></td>
					</tr>
				</s:iterator>

				</table>
				</div>
	 	 		 </s:else>

			<table>
												<tr>
													<td class="comFormTableItem"><nobr>
															<input class="comButton" type="button" name="buttonF1"
																value="戻る" onClick="JavaScript:backBtn();return false;" />
														</nobr></td>
												</tr>
			</table>

									<%-- メイン部 一覧 終了    key="catDeptsComboDataList[%{#status.index}].addrNameArea" --%>
						  <!--  <hr class="comSplit" /> -->
						  <%-- 後制御部 --%>
						            </td>
          </tr>
          </tbody>
          </table>
	</s:form>
	    </td>
    </tr>
  </table>

<%-- ポータルボディー 終了 --%>


<%-- メイン部 一覧 終了 --%>
<%-- ポータル大枠 終了 --%>
<jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
