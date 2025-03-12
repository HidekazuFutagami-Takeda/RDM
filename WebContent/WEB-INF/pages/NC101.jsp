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
<title>NC101_完了</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link href="css/common2.css" rel="Stylesheet" type="text/css" />
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

// 閉じるボタン
function backBtn(){
	document.fm1.target="";
	const preScreenId = document.fm1.preScreenId.value;
	window.close();
}
</script>

</head>

<body class="comPage" onLoad="JavaScript:comSetFormWindowName('JLC');">

  <%-- バナー部分をインクルード 開始 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <%-- バナー部分をインクルード 終了 --%>

  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>

<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="完了"></td>
        <td class="comPortalTitle"><nobr>NC101_完了</nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>
<%-- ポータルタイトル 終了 --%>

<table border="0" class="comPortalTable" align="center" style="width:98%;">
  <tr>
    <td>
      <s:form name="fm1" theme="simple" >
      <s:hidden name="NC101Finish" value="1" />
      <s:hidden name="backScreenId" value="NC101" />
      <s:hidden name="preScreenId"/>

      <table>
        <tr>
          <td class="comPortalTitleIcon"></td>
          <td><nobr><s:property value="title"/></nobr></td>
          <td class="comPortalTitleRight"><nobr></nobr></td>
        </tr>
      </table>
      <table>
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

  <%--ボタン類 --%>
  <table id="formTable19" border="0" class="comPortalTable" align="center" style="width:98%;">
      <tr>
        <td style="width: 100%; height: 0px; border-width: 0px;"></td>
      </tr>
		<tr>
	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="閉じる" onClick="JavaScript:backBtn();return false;" />
                </nobr>
	      </td>
	  </tr>
  </table>

<%-- ボトム部分をインクルード 開始 --%>
   <jsp:include page="common/jkrBottom.jsp" flush="true" />
<%-- ボトム部分をインクルード 終了 --%>
</body>
</html>
