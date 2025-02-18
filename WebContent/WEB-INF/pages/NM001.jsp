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

<%@ taglib prefix="s" uri="/struts-tags"%>


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
        }
    th {
        height:10px;
    }
    </style>
    <style>
	    .testlayout {
	    }
	    .container {
		    resize : horizontal;
		    overflow : hidden;
		}
		.siz{
		width:3000px;

		}
	</style>
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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="申請一覧"></td>
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


	<s:hidden id="reqJgiNo" name="reqJgiNo"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="knYmdhmsFrom" name="knYmdhmsFrom"/>
	<s:hidden id="knYmdhmsTo" name="knYmdhmsTo"/>

<!--  	<s:hidden id="reqId" name="reqId"/>
	<s:hidden id="reqType" name="reqType"/>-->

	<s:hidden id="sortCondition" name="sortCondition" />

	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="sosCd" name="sosCd"/>
<!--  <s:hidden id="bumonRyakuName" name="bumonRyakuName"/>  申請者所属-->
    <s:hidden id="brCode" name="brCode"/><!-- 申請者所属リージョン -->
	<s:hidden id="distCode" name="distCode"/><!-- 申請者所属エリア -->

<%-- ポータルボディー 開始 --%>
<table class="pupBodyTable" >
<tr align="center"><td>
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


	</table>
	<table style="align:right;">
			<tr>
			   <td>
			   	   <input type="button" name="クリア" value="クリア" onclick="rdmCler();return false;" />
				   <input type="button" name="search" value="検索" onclick="rdmSearch();" style="width:160px;">
			   </td>
			</tr>
	</table>
          <s:if test='pageFlag == "1" '>
          <!-- なにも表示しない -->
      	  </s:if>
      	  <s:else>
              <div style="max-height:500px;width:1450px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
              <table class="siz">
              <%-- ヘッダー行 --%>
												<tr>
													<!-- style="resize : horizontal;overflow : hidden;   " -->

													<td class="comTableTitle container" width="120px"
														style="border: none;" id="styles">都道府県
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設新規-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設新規-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設新規-ULT申請待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設新規-ULT承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設更新-承認待ち-承認者
													</td>
												    <td class="comTableTitle container" width="180px"
														style="border: none;">施設更新-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設更新-ULT申請待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設更新-ULT承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設削除-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設削除-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設削除-ULT申請待ち-承認者
													</td>
												     <td class="comTableTitle container" width="180px"
														style="border: none;">施設削除-ULT承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">領域別親子紐づけ-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">領域別親子紐づけ-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設復活-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設復活-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師新規-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師新規-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師新規-ULT申請待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師新規-ULT承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師削除-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師削除-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師削除-ULT申請待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師削除-ULT承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師復活-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師復活-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師復活-ULT申請待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">医師復活-ULT承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設更新(来期)-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設更新(来期)-承認待ち-MR
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設更新(来期)-ULT申請待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">施設更新(来期)-ULT承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">武田親子紐づけ(来期)-承認待ち-承認者
													</td>
													<td class="comTableTitle container" width="180px"
														style="border: none;">武田親子紐づけ(来期)-承認待ち-MR
													</td>




												</tr>

												<%-- 内容 --%>
				<s:iterator value="NM001DTO" status="status" var="rowBean" >

			<s:if test='#rowBean.key == "R01"'>
				<tr>
			</s:if>
			<s:if test='#rowBean.key == "R01"'>
					　　　　<td class="comTableItem" ><s:label  key="#rowBean.addrNamePref" />
					    </td>
			</s:if>
					<s:if test="#rowBean.reqCountSsAd != null">
						 <td class="comTableItem">
						<s:hidden key="#rowBean.reqChl"  />
						<s:hidden key="#rowBean.addrCodePref"/>
						<s:hidden key="#rowBean.reqType"  />
						<s:hidden key="#rowBean.reqSts"  />
						 <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountSsAd" />
						          </acronym>

			             </a>
			             </td>
			             </s:if>
			             <s:elseif test="#rowBean.reqCountSsMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label  key="#rowBean.reqCountSsMr" />
						          </acronym>
			             </a>
			             </td>
			             </s:elseif>
			             <s:elseif test="#rowBean.reqCountSsUr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountSsUr" />
						          </acronym>
			             </a>
			             </td>
			             </s:elseif>
			             <s:elseif test="#rowBean.reqCountSsUs != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountSsUs" />
						          </acronym>
			             </a>
			             </td>
			             </s:elseif>
			             <s:elseif test="#rowBean.reqCountScAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountScAd" />
						          </acronym>
			             </a>
			             </td>
			             </s:elseif>
			             <s:elseif test="#rowBean.reqCountScMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountScMr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountScUr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label key="#rowBean.reqCountScUr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountScUs != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountScUs" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSdAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountSdAd" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSdMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountSdMr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSdUr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountSdUr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSdUs != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountSdUs" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountRnAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountRnAd" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountRnMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountRnMr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountShAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountShAd" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountShMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountShMr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDsAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountDsAd" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDsMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountDsMr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDsUr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountDsUr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDsUs != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label  key="#rowBean.reqCountDsUs" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDdAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountDdAd" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDdMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountDdMr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDdUr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label  key="#rowBean.reqCountDdUr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDdUs != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountDdUs" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDhAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountDhAd" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDhMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label  key="#rowBean.reqCountDhMr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDhUr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountDhUr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountDhUs != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountDhUs" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSuAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountSuAd" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSuMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountSuMr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSuUr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label  key="#rowBean.reqCountSuUr" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountSuUs != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label    key="#rowBean.reqCountSuUs" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountTsAd != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label  key="#rowBean.reqCountTsAd" />
						          </acronym>
			             </a>
			              </td>
			              </s:elseif>
			              <s:elseif test="#rowBean.reqCountTsMr != null">
			             <td>
			             <a class="comLink" href="#" onMouseOver="this.style.color='red'" onMouseOut="this.style.color='black'" onClick="NC011Seni();return false;">
						          <acronym title='<s:property value="%{#rowBean1.toMrNameAft}"/>'>
						            <s:label   key="#rowBean.reqCountTsMr" />
						          </acronym>
			             </a>
			             </td>
			             </s:elseif>
			<s:if test='#rowBean.key == "R16"'>

				</tr>

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
	</table>
	</s:form>
    </tbody>
    </table>
</table>
<%-- ポータルボディー 終了 --%>


<%-- メイン部 一覧 終了 --%>
<%-- ポータル大枠 終了 --%>
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
