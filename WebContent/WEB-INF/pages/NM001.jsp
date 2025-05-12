<%--
/**
 * <pre>
 *  施設・領域別担当変更のJSP
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



<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppMethods,
      jp.co.takeda.rdm.util.RdmConstantsData"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  isErrorPage="false"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="dateFormat0" value="%{new java.text.SimpleDateFormat('yyyy年M月d日')}" />
<s:set name="dateFormat1" value="%{new java.text.SimpleDateFormat('dd')}" />
<s:set name="dateFormat2" value="%{new java.text.SimpleDateFormat('yyyy/MM/dd HH:mm:ss')}" />
<s:set name="dateFormat3" value="%{new java.text.SimpleDateFormat('yyyy/MM/dd')}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>NM001_申請サマリ</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>


    <script type="text/javascript" src="js/NM001.js"></script>
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/JKR040C010.js"></script>
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
    <script>
        // 5分（300,000ミリ秒）ごとにページをリロードする
        setInterval(function() {
            location.reload();
        }, 300000); // 300,000ミリ秒 = 5分
    </script>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
    	  const table = document.getElementById('myTable');
    	  const rows = table.getElementsByTagName('tr');

    	  for (let i = 0; i < rows.length; i++) {
    	    const cells = rows[i].getElementsByTagName('td');
    	    for (let j = 0; j < cells.length; j++) {
    	      const cellValue = parseInt(cells[j].innerText, 10);

    	      if (cellValue < 20) {
    	        cells[j].style.backgroundColor = 'lightgreen';
    	      } else if (cellValue < 40) {
    	        cells[j].style.backgroundColor = 'lightblue';
    	      } else {
    	        cells[j].style.backgroundColor = 'lightcoral';
    	      }
    	    }
    	  }
    	});
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
        left: 1;
        }
    th {
    	background-color: #ffffff;
    	border: 1px solid black;
        height:2px;
    }
    thead {
        position:Sticky;
        top:0;
        background-color: #fff;
        }
    </style>
    <style>
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

       }
       TD.comTableTitleMini		/* テーブル形式のタイトル項目 */
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
          TD.tkdUlt:first-child {
         position: sticky;
         left: 1;
         z-index:100;
       }

        .tkdUlt TD:first-child {
         position: sticky;
         left: 1;
         z-index:100;
       }
	    .testlayout {
	    }

		.siz{
		width:2000px;

		}
	</style>
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();changeCellColors();">


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
    <input type="hidden" name="serchReqType"           value="" />

    <input type="hidden" name="windowName" value="" />
    <input type="hidden" name="openerName" value="" />

	<s:hidden id="mrAdminCd" name="mrAdminCd"/>
    <s:hidden id="mrAdminFlg" name="mrAdminFlg"/>
    <s:hidden id="preScreenId" name="preScreenId"/>


	<s:hidden id="jgiNo" name="jgiNo"/>
    <s:hidden id="jgiName" name="jgiName"/>


	<s:hidden id="reqJgiNo" name="reqJgiNo"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="knYmdhmsFrom" name="knYmdhmsFrom"/>
	<s:hidden id="knYmdhmsTo" name="knYmdhmsTo"/>

	<s:hidden id="sortCondition" name="sortCondition" value ="1"/>

	<s:hidden name="inreqYmdhmsFrom"/>
	<s:hidden name="inreqYmdhmsTo"/>
	<s:hidden name="reqType" />
	<s:hidden name="reqChl"/>
	<s:hidden name="reqSts"/>
	<s:hidden name="aDdrCodePref"/>

	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="sosCd" name="sosCd"/>
<!--  <s:hidden id="bumonRyakuName" name="bumonRyakuName"/>  申請者所属-->
	<s:hidden name="title" />
	<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="申請サマリ"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>
<%-- ポータルタイトル 終了 --%>
<%-- ポータルボディー 開始 --%>
<table class="comPortalBody">
	<tbody>
		<tr align="left"><td>
			<table width="100%">
   		<tr>
             <td align="center">
               <jsp:include page="common/rdmMsg.jsp">
               <jsp:param name="" value="" />
               </jsp:include>
             </td>
         </tr>
      </table>
<%-- 検索部 開始 --%>

	<table style="align:left;">


		<tr>
						<%-- 申請日: 操作日-1カ月、操作日 --%>

			<td class="pupControlItem"><nobr>&nbsp;申請日</nobr></td>

				<td>
					<input type="date" size="20" maxlength="40" name="reqYmdhmsFrom" id="inreqYmdhmsFrom" value="${reqYmdhmsFrom}" STYLE="ime-mode:active" pattern="yyyy-MM-dd"/>　～
				</td>
				<td>
					<input type="date" size="20" maxlength="40" name="reqYmdhmsTo" id="inreqYmdhmsTo" value="${reqYmdhmsTo}" STYLE="ime-mode:active" pattern="yyyy-MM-dd"/>
				</td>
		</tr>
		<tr>
			<td></td><td></td><td></td>
			   <td>
			   	   <input type="button" name="クリア" value="クリア" onclick="rdmCler();return false;" />
				   <input type="button" name="search" value="検索" onclick="rdmSearch();" >
			   </td>
		</tr>
	</table>

          <s:if test='pageFlag == "1" '>
          <!-- なにも表示しない -->
      	  </s:if>
      	  <s:else><!-- max-height:500px; div内スタイルから抜き取って最大幅の上限を撤廃、overflow-y:hiddenで縦スクロールを無効化 -->
              <div id="insTableDataOff" style=" max-height:500px; width:1450px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;"onscroll="javascript:jpjOffSyncScrolling()" >

              <table class="siz " id="dataTable" style="margin-top:3pt;margin-bottom:1pt;border-spacing: 0px;"border="0" >
              <thead style="z-index:3;">
              <%-- ヘッダー行 --%>
				<tr >
					<td rowspan="4" class="comTableTitle container tkdUlt" id="tkdUlt"width="180px"
						style="border-width:1px;border-color:#ffffff; resize : horizontal;overflow : hidden; font-weight:normal;" id="styles">都道府県
					</td>
				</tr>
					<tr><!-- 枠組み　大 -->
							<td colspan="4" class="comTableTitle container" width="150px"
							style="border-width:1px;border-color:#ffffff;" id="styles">施設新規</td>
							<td colspan="4" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">施設更新</td>
							<td colspan="4" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">施設削除</td>
							<td rowspan="2" colspan="2" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">領域別親子紐付け<br>(当期)<br>承認待ち</td>
							<td rowspan="2" colspan="2" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">施設復活<br><br>承認待ち</td>
							<td colspan="4" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">医師新規</td>
							<td colspan="4" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">医師削除</td>
							<td colspan="4" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">医師復活</td>
							<td colspan="4" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">施設更新来期</td>
							<td rowspan="2" colspan="2" class="comTableTitle container" width="100px"
							style="border-width:1px;border-color:#ffffff;" id="styles">武田親子紐づけ<br>(来期)<br>承認待ち</td>
					</tr>
						<tr>　<!-- 枠組み　中 -->
							<td colspan="2" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>承認待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>申請待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>承認待ち
							</td>
							<td colspan="2" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>承認待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>申請待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>承認待ち
							</td>
							<td colspan="2" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>承認待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>申請待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>ULT承認待ち
							</td>
							<td colspan="2" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>承認待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>申請待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>ULT承認待ち
							</td>
							<td colspan="2" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>承認待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>申請待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>承認待ち
							</td>
							<td colspan="2" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>承認待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>申請待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>承認待ち
							</td>
							<td colspan="2" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles"><br>承認待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>申請待ち
							</td>
							<td colspan="1" class="comTableTitle container" width="100px"
								style="border-width:1px;border-color:#ffffff;" id="styles">ULT<br>承認待ち
							</td>

						</tr>
						<tr><!-- 枠組み　小 -->
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
						    <td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
						     <td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;">承認者
							</td>
							<td class="comTableTitleMini container" width="180px"
								style="border-width:1px;border-color:#ffffff;background-Color:#f4d3c4;">MR
							</td>
						</tr>
					</thead>
												<%-- 内容 --%>
				<s:iterator value="NM001DTO" status="status" var="rowBean" >

			<s:if test='#rowBean.key == "R01"'>
				<tr>
			</s:if>
			<s:if test='#rowBean.key == "R01"'>
                        <td class="comTableItem tkdUlt" style="z-index:1;text-align: left;">
                        <s:label  key="#rowBean.addrNamePref" align="left"/>
                        <s:hidden name="#rowBean.addrCodePref"/>
					    </td>
			</s:if>
						<s:hidden name="#rowBean.reqChl"  />

						<s:hidden name="#rowBean.reqType"  />
						<s:hidden name="#rowBean.reqSts"  />
						<s:if test="#rowBean.reqCountSsAd != null">
							 <td class="comTableItem" style="text-align: center;">
							 <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni1('<s:property  value="#rowBean.reqType1" />', '<s:property value="#rowBean.reqChl1"/>', '<s:property value="#rowBean.reqSts1"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
							          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
							          	<s:if test="#rowBean.reqCountSsAd >= 150">
							            <s:label style="color : red;" key="#rowBean.reqCountSsAd" />
							            </s:if>
							            <s:else>
							            <s:label  key="#rowBean.reqCountSsAd" />
							            </s:else>
							          </acronym>
				             </a>
				             </td>
				        </s:if>
			             <s:elseif test="#rowBean.reqCountSsMr != null">
					             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
					             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni2('<s:property  value="#rowBean.reqType2" />', '<s:property value="#rowBean.reqChl2"/>', '<s:property value="#rowBean.reqSts2"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
								          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

								        <s:if test="#rowBean.reqCountSsMr >= 150">
							            <s:label style="color : red;" key="#rowBean.reqCountSsMr" />
							            </s:if>
							            <s:else>
							            <s:label class="labels" key="#rowBean.reqCountSsMr" />
							            </s:else>
								          </acronym>
					             </a>
					             </td>
			             </s:elseif>
			             <s:elseif test="#rowBean.reqCountSsUr != null">
				             <td class="comTableItem" style="text-align: center;">
				             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni3('<s:property  value="#rowBean.reqType3" />', '<s:property value="#rowBean.reqChl3"/>', '<s:property value="#rowBean.reqSts3"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
							          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

							            <s:if test="#rowBean.reqCountSsUr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSsUr" />
							            </s:if>
							            <s:else>
							            <s:label  class="labels"  key="#rowBean.reqCountSsUr" />
							            </s:else>
							          </acronym>
				             </a>
				             </td>
				             </s:elseif>
				             <s:elseif test="#rowBean.reqCountSsUs != null">
				             <td class="comTableItem" style="text-align: center;">
				             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni4('<s:property  value="#rowBean.reqType4" />', '<s:property value="#rowBean.reqChl4"/>', '<s:property value="#rowBean.reqSts4"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
							          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

							            <s:if test="#rowBean.reqCountSsUs >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSsUs" />
							            </s:if>
							            <s:else>
							            <s:label class="labels"  key="#rowBean.reqCountSsUs" />
							            </s:else>
							          </acronym>
				             </a>
				             </td>
			             </s:elseif>
			             <s:elseif test="#rowBean.reqCountScAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni5('<s:property  value="#rowBean.reqType5" />', '<s:property value="#rowBean.reqChl5"/>', '<s:property value="#rowBean.reqSts5"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountScAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountScAd" />
							            </s:if>
							            <s:else>
							            <s:label class="labels"   key="#rowBean.reqCountScAd" />
							            </s:else>
						          </acronym>
			             </a>
			             </td>
			             </s:elseif>
			             <s:elseif test="#rowBean.reqCountScMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni6('<s:property  value="#rowBean.reqType6" />', '<s:property value="#rowBean.reqChl6"/>', '<s:property value="#rowBean.reqSts6"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            	<s:if test="#rowBean.reqCountScMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountScMr" />
							            </s:if>
							            <s:else>
							            <s:label  style="background-Color:#f4d3c4;" class="labels" key="#rowBean.reqCountScMr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountScUr != null">
				             <td class="comTableItem" style="text-align: center;">
				             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni7('<s:property  value="#rowBean.reqType7" />', '<s:property value="#rowBean.reqChl7"/>', '<s:property value="#rowBean.reqSts7"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
							          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

							            	<s:if test="#rowBean.reqCountScUr >= 150">
								            <s:label style="color : red" key="#rowBean.reqCountScUr" />
								            </s:if>
								            <s:else>
								            <s:label  class="labels" key="#rowBean.reqCountScUr" />
								            </s:else>
							          </acronym>
				             </a>
				              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountScUs != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni8('<s:property  value="#rowBean.reqType8" />', '<s:property value="#rowBean.reqChl8"/>', '<s:property value="#rowBean.reqSts8"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            	<s:if test="#rowBean.reqCountScUs >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountScUs" />
							            </s:if>
							            <s:else>
							            <s:label  class="labels"  key="#rowBean.reqCountScUs" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSdAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni9('<s:property  value="#rowBean.reqType9" />', '<s:property value="#rowBean.reqChl9"/>', '<s:property value="#rowBean.reqSts9"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

										<s:if test="#rowBean.reqCountSdAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSdAd" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountSdAd" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSdMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni10('<s:property  value="#rowBean.reqType10" />', '<s:property value="#rowBean.reqChl10"/>', '<s:property value="#rowBean.reqSts10"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountSdMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSdMr" />
							            </s:if>
							            <s:else>
						           	    <s:label   class="labels" key="#rowBean.reqCountSdMr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSdUr != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni11('<s:property  value="#rowBean.reqType11" />', '<s:property value="#rowBean.reqChl11"/>', '<s:property value="#rowBean.reqSts11"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountSdUr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSdUr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountSdUr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSdUs != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni12('<s:property  value="#rowBean.reqType12" />', '<s:property value="#rowBean.reqChl12"/>', '<s:property value="#rowBean.reqSts12"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountSdUs >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSdUs" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountSdUs" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountRnAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni13('<s:property  value="#rowBean.reqType13" />', '<s:property value="#rowBean.reqChl13"/>', '<s:property value="#rowBean.reqSts13"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountRnAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountRnAd" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountRnAd" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountRnMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni14('<s:property  value="#rowBean.reqType14" />', '<s:property value="#rowBean.reqChl14"/>', '<s:property value="#rowBean.reqSts14"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountRnMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountRnMr" />
							            </s:if>
							            <s:else>
							             <s:label   class="labels" key="#rowBean.reqCountRnMr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountShAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni15('<s:property  value="#rowBean.reqType15" />', '<s:property value="#rowBean.reqChl15"/>', '<s:property value="#rowBean.reqSts15"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						           		<s:if test="#rowBean.reqCountShAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountShAd" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountShAd" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountShMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni16('<s:property  value="#rowBean.reqType16" />', '<s:property value="#rowBean.reqChl16"/>', '<s:property value="#rowBean.reqSts16"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						                <s:if test="#rowBean.reqCountShMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountShMr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountShMr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDsAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni17('<s:property  value="#rowBean.reqType17" />', '<s:property value="#rowBean.reqChl17"/>', '<s:property value="#rowBean.reqSts17"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDsAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDsAd" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountDsAd" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDsMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni18('<s:property  value="#rowBean.reqType18" />', '<s:property value="#rowBean.reqChl18"/>', '<s:property value="#rowBean.reqSts18"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDsMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDsMr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountDsMr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDsUr != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni19('<s:property  value="#rowBean.reqType19" />', '<s:property value="#rowBean.reqChl19"/>', '<s:property value="#rowBean.reqSts19"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDsUr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDsUr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountDsUr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDsUs != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni20('<s:property  value="#rowBean.reqType20" />', '<s:property value="#rowBean.reqChl20"/>', '<s:property value="#rowBean.reqSts20"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						          	    <s:if test="#rowBean.reqCountDsUs >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDsUs" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountDsUs" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDdAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni21('<s:property  value="#rowBean.reqType21" />', '<s:property value="#rowBean.reqChl21"/>', '<s:property value="#rowBean.reqSts21"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDdAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDdAd" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountDdAd" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDdMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni22('<s:property  value="#rowBean.reqType22" />', '<s:property value="#rowBean.reqChl22"/>', '<s:property value="#rowBean.reqSts22"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDdMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDdMr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountDdMr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDdUr != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni23('<s:property  value="#rowBean.reqType23" />', '<s:property value="#rowBean.reqChl23"/>', '<s:property value="#rowBean.reqSts23"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDdUr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDdUr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountDdUr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDdUs != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni24('<s:property  value="#rowBean.reqType24" />', '<s:property value="#rowBean.reqChl24"/>', '<s:property value="#rowBean.reqSts24"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDdUs >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDdUs" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountDdUs" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDhAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni25('<s:property  value="#rowBean.reqType25" />', '<s:property value="#rowBean.reqChl25"/>', '<s:property value="#rowBean.reqSts25"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDhAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDhAd" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountDhAd" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDhMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni26('<s:property  value="#rowBean.reqType26" />', '<s:property value="#rowBean.reqChl26"/>', '<s:property value="#rowBean.reqSts26"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDhMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDhMr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountDhMr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDhUr != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni27('<s:property  value="#rowBean.reqType27" />', '<s:property value="#rowBean.reqChl27"/>', '<s:property value="#rowBean.reqSts27"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDhUr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDhUr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountDhUr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDhUs != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni28('<s:property  value="#rowBean.reqType28" />', '<s:property value="#rowBean.reqChl28"/>', '<s:property value="#rowBean.reqSts28"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountDhUs >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountDhUs" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountDhUs" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSuAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni29('<s:property  value="#rowBean.reqType29" />', '<s:property value="#rowBean.reqChl29"/>', '<s:property value="#rowBean.reqSts29"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountSuAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSuAd" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountSuAd" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSuMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni30('<s:property  value="#rowBean.reqType30" />', '<s:property value="#rowBean.reqChl30"/>', '<s:property value="#rowBean.reqSts30"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountSuMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSuMr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountSuMr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSuUr != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni31('<s:property  value="#rowBean.reqType31" />', '<s:property value="#rowBean.reqChl31"/>', '<s:property value="#rowBean.reqSts31"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountSuUr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSuUr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountSuUr" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSuUs != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni32('<s:property  value="#rowBean.reqType32" />', '<s:property value="#rowBean.reqChl32"/>', '<s:property value="#rowBean.reqSts32"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountSuUs >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountSuUs" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels"  key="#rowBean.reqCountSuUs" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountTsAd != null">
			             <td class="comTableItem" style="text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni33('<s:property  value="#rowBean.reqType33" />', '<s:property value="#rowBean.reqChl33"/>', '<s:property value="#rowBean.reqSts33"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountTsAd >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountTsAd" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountTsAd" />
							            </s:else>
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountTsMr != null">
			             <td class="comTableItem" style="background-Color:#f4d3c4;text-align: center;">
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni34('<s:property  value="#rowBean.reqType34" />', '<s:property value="#rowBean.reqChl34"/>', '<s:property value="#rowBean.reqSts34"/>', '<s:property value="#rowBean.addrCodePref"/>');return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>

						            	<s:if test="#rowBean.reqCountTsMr >= 150">
							            <s:label style="color : red" key="#rowBean.reqCountTsMr" />
							            </s:if>
							            <s:else>
							            <s:label   class="labels" key="#rowBean.reqCountTsMr" />
							            </s:else>
						          </acronym>
			             </a>
			             </td>
			             </s:elseif>
			<s:if test='#rowBean.key == "R16"'>



			</s:if>
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
