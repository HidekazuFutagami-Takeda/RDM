<%--
 * <pre>
 *  組織検索ポップアップのAjaxレスポンス
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author SBS 内海
 * @see
 */
--%>
<%@page import="jp.co.takeda.rdm.dto.NC201DTO"%>
<%@ page
  language="java"
  import="jp.co.takeda.jkr.util.AppConstant,java.util.ArrayList,java.math.BigDecimal,java.lang.String"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"

%>
<%@ taglib prefix="s" uri="/struts-tags"%>

  <%-- 組織 --%>
  <s:iterator value="sosData" status="status" var="rowBean">
    <div id="layout" name="layout" style="padding-top:8px">
      <nobr>
        <s:if test="%{selectFlgPop != 2}">
          <s:if test="%{(selectFlgPop == 1 && #rowBean.bumonRank < 4)}">
            <%-- 選択ボタン --%>
            <input
              type="button"
              value=""
              class="cseSosSelectButton"
              onclick="rCseSelectSos(
                          '<s:property value="#rowBean.bumonRank"/>',
                          '<s:property value="#rowBean.sosCd"/>',
                          '<s:property value="#rowBean.bumonSeiName"/>',
                          '<s:property value="#rowBean.brCode"/>',
                          '<s:property value="#rowBean.distCode"/>',
                          '<s:property value="#rowBean.upSosCode"/>',
                          '<s:property value="#rowBean.upBumonRank"/>',
                          '<s:property value="#rowBean.upBrCode"/>',
                          '<s:property value="#rowBean.upDistCode"/>'
                          );"
            >
          </s:if>
        </s:if>

        <%-- 組織名 --%>
        <s:if test="%{(selectFlgPop == 1 && #rowBean.bumonRank < 4 && #rowBean.bumonRank != 3)}">
          <a
            href=""
            name="focus<s:property value="#rowBean.sosCd"/>"
            class="comLink"
            onclick="rcseCallAjax('<s:property value="#rowBean.sosCd"/>', '<s:property value="#rowBean.bumonRank"/>'); return false;"
          ><s:property value="#rowBean.bumonSeiName"/></a>
        </s:if>
        <s:else>
          <s:property value="#rowBean.bumonSeiName"/>
        </s:else>
      </nobr>
      <br>
      <%-- 子組織・子従業員の配置空間 --%>
      <div style="display:none" class="resultDiv" id="<s:property value="#rowBean.sosCd"/>"></div>
    </div>
  </s:iterator>
