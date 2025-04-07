<%--
/**
 * <pre>
 *  従業員関連【共通】ページャー表示のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author 日立　花
 */
--%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppConstant"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  errorPage="error/comError.jsp"
  isErrorPage="false"
  contentType="text/html;charset=UTF-8"
%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- ページャー表示 開始 --%>
       <!-- 改ページ -->
        <table width="80%" >
            <tbody>
            <tr align="right">
                <td>
                  <!-- 前頁リンク -->
                  <s:if test="pageCntCur > 1">
                  <nobr>
                      <a class="comMiniLink" href = "" onClick="pltPage(<s:property value="pageCntCur-1"/>);return false;">
                      &lt;&lt; 前
                      </a>&nbsp;
                  </nobr>
                  </s:if>

                  <!-- ページ基準の前頁リンク -->
                  <s:if test="pageCntBase > 1">
                    <a class="comMiniLink"  href="" style="" onClick="pltPage(<s:property value="pageCntBase-1"/>);return false;">
                    <nobr>～<s:property value="pageCntBase-1"/></nobr></a>
                  </s:if>

                  <!-- 各ページリンク作成 -->
                  <s:if test="pageCntAll > 1">
                    <s:iterator value="{'0','1','2','3','4','5','6','7','8','9'}" var="pageIndex" status="status">
                      <s:set var="pageCntCurTemp" value="#status.index + pageCntBase" />
                      <s:if test="#pageCntCurTemp <= pageCntAll">
                        <s:if test="#pageCntCurTemp != pageCntCur">
                          <a  class="comMiniLink"  href="" style="" onClick="pltPage(<s:property value="#pageCntCurTemp"/>);return false;">
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
                      <a  class="comMiniLink"  href="" style="" onClick="pltPage(<s:property value="#pageCntCurTemp-1"/>);return false;">
                      <nobr><s:property value="pageCntBase + 10"/>～</nobr></a>
                  </s:if>

                  <!-- 次頁  -->
                  <s:if test="pageCntCur < pageCntAll">
                    <nobr>&nbsp;
                      <a class="comMiniLink" href = "" onClick="pltPage(<s:property value="pageCntCur+1"/>);return false;">
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
<%-- ページャー表示 終了 --%>
