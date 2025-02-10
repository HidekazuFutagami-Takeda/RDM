<%--
/**
 * <pre>
 *  従業員関連【共通】POP画面ページャー表示のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author 日立　花
 */
--%>
<%@ page
  language="java"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  errorPage="error/comError.jsp"
  isErrorPage="false"
  contentType="text/html;charset=UTF-8"
  import="jp.co.takeda.rdm.common.LoginInfo,jp.co.takeda.rdm.common.BaseInfoHolder"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- オブジェクト読み込み --%>
<%
//ページャー初期表示要否フラグ 1:表示 0:非表示
String showPagerFlg  = request.getParameter("showPagerFlg");
if (showPagerFlg == null || showPagerFlg.trim().length() ==0) {
  showPagerFlg = "0";
}

//処理ファンクション取得
LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute(BaseInfoHolder.USERINFO_KEY);
String functionId = loginInfo.getFunctionId();

int showPager = 0;
if (("1").equals(showPagerFlg) || !"Init".equals(functionId)) {
	showPager = 1;
}

//ページャーサイズ指定（pt）
String pagerSize = request.getParameter("pagerSize");
if (pagerSize == null || pagerSize.trim().length() ==0) {
  pagerSize = "300";
}
%>
<%-- ページ情報 --%>
    <table class="pupControlTable" border="0" align="center" style="width:<%=pagerSize%>pt;margin-top:3pt;">
    <%//初期表示時以外は表示 start------------------------------------------%>
    <%if (showPager == 1) { %>
      <tbody>
        <tr>
          <td align="left"><nobr>
            <%= "検索結果" %>
            <s:property value="lineCntAll"/>件中&nbsp;&nbsp;
            <s:property value="lineCntStart"/>～<s:property value="lineCntEnd"/>件
          </nobr></td>
          <td align="right">
            <nobr>
              <!-- 前頁リンク -->
              <s:if test="pageCntCur > 1">
                <a class="comMiniLink" href = "" onClick="pltPage(<s:property value="pageCntCur-1"/>);return false;">
                &lt;&lt; 前
                </a>&nbsp;
              </s:if>
              <s:else>
                <a class="comMiniLink" style="text-decoration:none;">&lt;&lt; 前</a>
              </s:else>

              <!-- 次頁  -->
              <s:if test="pageCntCur < pageCntAll">
                <a class="comMiniLink" href = "" onClick="pltPage(<s:property value="pageCntCur+1"/>);return false;">
                  次&gt;&gt;
                </a>
              </s:if>
              <s:else>
                <a class="comMiniLink" style="text-decoration:none;">次 &gt;&gt;</a>
              </s:else>
            </nobr>
          </td>
        </tr>
      </tbody>
    <%//初期表示時以外は表示 end--------------------------------------------%>
    <%} %>
    </table>
