<%--
 * <pre>
 *  担当者検索ポップアップのAjaxレスポンス
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author SBS 内海
 * @see
 */
--%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppConstant,java.util.ArrayList,java.math.BigDecimal,java.lang.String"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"

%>
<%@ taglib prefix="s" uri="/struts-tags"%>

    <s:if test="%{(jgiFlg == 0 )}">
      <%-- 組織 --%>
      <s:iterator value="jgiData" status="status" var="rowBean">
        <div id="layout" name="layout" style="padding-top:8px">
          <nobr>
            <s:if test="%{(selectFlgPop == 1 )}">
              <img
                src="img/right.gif"
                name="img<s:property value="#rowBean.sosCd"/>"
                onclick="rcseCallAjaxJgi('<s:property value="#rowBean.sosCd"/>', '<s:property value="#rowBean.bumonRank"/>', '<s:property value="#rowBean.trtCd"/>'); return false;"
              >
            </s:if>

            <%-- 組織名 --%>
            <s:if test="%{(selectFlgPop == 1 && #rowBean.bumonRank < 5 && #rowBean.bumonRank != 4)}">
              <a
                href=""
                name="focus<s:property value="#rowBean.sosCd"/>"
                class="comLink"
                onclick="rcseCallAjaxJgi('<s:property value="#rowBean.sosCd"/>', '<s:property value="#rowBean.bumonRank"/>'); return false;"
              ><s:property value="#rowBean.bumonRyakuName"/></a>
            </s:if>
            <s:else>
              <s:property value="#rowBeanJgi.jgiNo"/>
            </s:else>
          </nobr>
          <br>
          <%-- 子組織・子従業員の配置空間 --%>
          <div style="display:none" class="resultDiv" id="<s:property value="#rowBean.sosCd"/>"></div>

        </div>
      </s:iterator>
  </s:if>
  <s:if test="%{(jgiFlg == 1 )}">
        <%-- 従業員 --%>
      <s:iterator value="jgiData" status="status" var="rowBeanJgi">
        <div id="layout" name="layout" style="padding-top:8px">
          <nobr>
            <%-- 従業員名 --%>
             <s:if test="%{(selectFlgPop == 1)}">
                  <input
                      type="button"
                      value=""
                      class="cseJgiSelectButton"
                      onclick="rCseSelectJgi(
                          '<s:property value="#rowBeanJgi.sosCd"/>',
                          '<s:property value="#rowBeanJgi.bumonRyakuName"/>',
                          '<s:property value="#rowBeanJgi.jgiNo"/>',
                          '<s:property value="#rowBeanJgi.jgiName"/>',
                          '<s:property value="#rowBeanJgi.trtCd"/>',
                          '<s:property value="#rowBeanJgi.brCode"/>',
                          '<s:property value="#rowBeanJgi.distCode"/>',
                          '<s:property value="#rowBeanJgi.trtGrpCd"/>',
                          '<s:property value="#rowBeanJgi.trtNm"/>',
                          '<s:property value="#rowBeanJgi.mrCat"/>'
                      );"
                  >
                <%-- 従業員名 --%>
                <s:property value="#rowBeanJgi.jgiName"/>
             </s:if>
          </nobr>
        </div>
      </s:iterator>
  </s:if>