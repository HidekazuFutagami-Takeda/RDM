<%@ page
  language="java"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  isErrorPage="false"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title><s:property value="browerTitle"/></title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link href="css/jkrMenu.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="js/jkrMenu.js"></script>
<script type="text/javascript" src="js/jgiKanren.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
<!--
/*-----------------------------------------*/
TD.comMessage1       /* メッセージ１のCSS設定 */
{
  padding: 5pt 5pt 5pt 5pt; /* 上右下左 */
<s:if test="message1 != null && message1.color != null">
  color: <s:property value="message1.color" />;
</s:if>
<s:if test="message1 != null && message1.textAlign != null">
  text-align: <s:property value="message1.textAlign" />;
</s:if>
<s:else>
  text-align: center;
</s:else>
<s:if test="message1 != null && message1.fontSize != null">
  font-size: <s:property value="message1.fontSize" />pt;
</s:if>
<s:if test="message1 != null && message1.bold == 1">
  font-weight: bolder;
</s:if>
<s:if test="message1 != null && message1.italic == 1">
  font-style:oblique;
</s:if>
<s:if test="message1 != null && message1.underLine == 1">
  text-decoration: underline;
</s:if>
}

TD.comMessage3       /* メッセージ３のCSS設定 */
{
  padding: 5pt 5pt 5pt 5pt; /* 上右下左 */
<s:if test="message3 != null && message3.color != null">
  color: <s:property value="message3.color" />;
</s:if>
<s:if test="message3 != null && message3.textAlign != null">
  text-align: <s:property value="message3.textAlign" />;
</s:if>
<s:else>
  text-align: center;
</s:else>
<s:if test="message3 != null && message3.fontSize != null">
  font-size: <s:property value="message3.fontSize" />pt;
</s:if>
<s:if test="message3 != null && message3.bold == 1">
  font-weight: bolder;
</s:if>
<s:if test="message3 != null && message3.italic == 1">
  font-style:oblique;
</s:if>
<s:if test="message3 != null && message3.underLine == 1">
  text-decoration: underline;
</s:if>
}
-->
</style>
<script>

function returnButtonGo(action){
  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  COM_Click_flg = false;
  document.fm1.action = action + ".action";
  document.fm1.submit();
}
</script>
<body class="comPage" onLoad="JavaScript:comSetFormWindowName('JLC');">
<%-- submit用フォーム 開始 --%>
  <form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
    <input type="text" name="screenId"			value="" />
    <input type="text" name="functionId"		value="" />
    <input type="text" name="windowName"		value="" />
    <input type="text" name="openerName"		value="" />
    <input type="text" name="systemId1"			value="" />
    <input type="text" name="backScreenId1"		value="" />
    <input type="text" name="backFunctionId1"	value="" />
    <input type="text" name="backScreenName1"	value="" />
    <input type="text" name="backParamName1"	value="" />
    <input type="text" name="backParamValue1"	value="" />
    <input type="text" name="backParamName2"	value="" />
    <input type="text" name="backParamValue2"	value="" />
    <input type="text" name="fromScreenId1"		value="" />
    <input type="text" name="fromFunctionId1"	value="" />
    <input type="text" name="kensakuSosCd1"		value="" />
    <input type="text" name="pageNextBackFlag1"	value="" />
    <input type="text" name="sortFieldNo1"		value="" />
    <input type="text" name="sortFLG1"			value="" />
    <input type="text" name="sosCd1"			value="" />
    <input type="text" name="sosName1"			value="" />
    <input type="text" name="selectedSosCd1"	value="" />
    <input type="text" name="selectedSosName1"	value="" />
    <input type="text" name="wkCat1"			value="" />
    <input type="text" name="mrCat1"			value="" />
    <input type="text" name="dispSosName1"		value="" />
    <input type="text" name="jokenSetCd1"		value="" />
    <input type="text" name="insDevFlg"			value="" />
    <input type="text" name="msgId"				value="" />
    <input type="text" name="subSystemId"		value="3" />
    <input type="text" name="no1"				value="1" />
    <input type="text" name="dummy"				value="dummy" />
  </form>
<%-- submit用フォーム 終了 --%>

  <%-- バナー部分をインクルード 開始 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <%-- バナー部分をインクルード 終了 --%>

  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>
<table border="0" class="comPortalTable" align="center" style="width:98%;">
  <tr>
    <td>
      <s:form name="fm1" theme="simple" >
      <s:hidden name="NC101Finish" value="1" />
      <table class="comPortalTitle">
        <tr>
          <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt='<s:property value="title"/>'></td>
          <td class="comPortalTitle"><nobr><s:property value="title"/></nobr></td>
          <td class="comPortalTitleRight"><nobr></nobr></td>
        </tr>
      </table>
      <table class="comPortalBody">
<!-- 一覧表示処理 START-->
        <tr>
          <td valign="top" align="center" style="padding-left:5px;">
            <table border="0" cellpadding="2" cellspacing="0" width="600px">
              <tbody>
                <s:if test="message1 != null">
                <tr>
                  <td class="comMessage1" style="width:40%;">
                    <nobr>
                    <s:property value="message1.msgData" escape="false"/>
                    </nobr>
                  </td>
                </tr>
                </s:if>
                <s:if test="message2 != null && message2 != ''">
                <tr>
                  <td align="center">
                    <table>
                      <tr>
                        <td>
                          <s:property value="message2" escape="false"/>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
                </s:if>
                <!-- トップメニューからの遷移 -->
                <s:if test="%{#session.UserInfoKey.screenId == 'JKR000C010'}">

                </s:if>
                <s:if test="message3 != null">
                <tr>
                  <td class="comMessage3" style="width:40%;">
                  <br>
                    <nobr><s:property value="message3.msgData" escape="false"/></nobr>
                  </td>
                </tr>
                </s:if>
                <s:if test="message4 != null && message4 != ''">
                <tr>
                  <td align="center">
                    <table>
                      <tr>
                        <td>
                          <s:property value="message4" escape="false"/>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
                </s:if>

                <tr>
                  <td align="center">
                    <s:if test="returnLinkURL1 != null && returnLinkURL1 != ''">
                    <nobr>
                      <a href="" onClick="returnButtonGo('<s:property value="returnLinkURL1"/>');return false;"><b><s:property value="returnLinkNm1"/></b></a>
                    </nobr>
                    </s:if>
                    <s:if test="returnLinkURL2 != null && returnLinkURL2 != ''">
                    <nobr>&nbsp;
                      <a href="" onClick="returnButtonGo('<s:property value="returnLinkURL2"/>');return false;"><b><s:property value="returnLinkNm2"/></b></a>
                    </nobr>
                    </s:if>
                  </td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
<!-- 一覧表示処理 END-->
      </table>
      </s:form>
    </td>
  </tr>
</table>
<%-- ボトム部分をインクルード 開始 --%>
  <jsp:include page="common/jkrBottom.jsp" flush="true" />
<%-- ボトム部分をインクルード 終了 --%>
</body>
</html>
