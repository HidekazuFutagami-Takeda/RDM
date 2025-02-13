<%--
/**
 * <pre>
 * メインメニューのインクルード部分です。
 * 各アプリケーションでインクルードして利用します。
 * インクルードは静的埋め込み方式とします。
 * 例&lt;%@ include file="/menu/mnuTop00.jsp" %&gt;
 * </pre>
 * @author 日立
 */
--%>
<%@ page
  language="java"
  import="java.util.*,java.text.*,
      jp.co.takeda.rdm.util.AppConstant,
      jp.co.takeda.rdm.common.MainMenuData"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="iCatNum" value="0"/>
<s:set var="iSubCatNum" value="0"/>
<s:set var="iGrpNo" value="0"/>
<script type="text/javascript">
  var countA = 0;
</script>


<script type=text/javascript>
  menuLinkInit2();
</script>

<!-- メニューデータをセッションから取得 -->
<!-- メインメニュー配列数だけループする -->
<s:iterator value="#session.mainMenuData.mainManuList" var="main2" status="status">
  <s:if test="#main2.freeFlg1 == null || #main2.freeFlg1 == ''">
  <!-- 外行コードを変換する-->
  <s:set id="strName" value="#main2.menuName.replaceAll('\r\n', '<br />').replaceAll('\n', '<br />')"/>
    <%------------------------------------%>
    <%-- メインカテゴリー作成処理を行う --%>
    <%------------------------------------%>
    <s:if test="#main2.catNo > 0 && #main2.subCatNo == 0 && #main2.listNo == 0">

      <s:set var="iCatNum" value="#iCatNum + 1"/>
      <s:set var="iSubCatNum" value="0"/>

        <s:if test="#iCatNum > 1">
          <script type="text/javascript">
          subCatStr += writeEndList();
          subCatStr += writeEndSubCategory();
          </script>
        </s:if>

        <script type="text/javascript">
        mainCatStr += writeMainCategory('<s:property value="#main2.catNo"/>', '<s:property value="#strName" escapeHtml="false"/>');
        subCatStr += writeStartSubCategory('<s:property value="#main2.catNo"/>');
        </script>
    </s:if>

    <s:elseif test="#main2.subCatNo > 0 && #main2.listNo == 0">
    <%------------------------------------%>
    <%-- サブカテゴリー作成処理を行う   --%>
    <%------------------------------------%>

      <s:set var="iSubCatNum" value="#iSubCatNum + 1"/>
      <s:set var="iGrpNo" value="-1"/>

        <%-- サブカテゴリーが２つ以上 --%>
        <s:if test="#iSubCatNum > 1">
          <script type="text/javascript">
          subCatStr += writeEndList();
          </script>
        </s:if>

        <script type="text/javascript">
        subCatStr += writeSubCategory('<s:property value="#main2.catNo"/>', '<s:property value="#main2.subCatNo"/>', '<s:property value="#strName" escapeHtml="false"/>');
        </script>
    </s:elseif>

    <s:elseif test="#main2.subCatNo > 0 && #main2.listNo > 0">
    <%------------------------------------%>
    <%-- リスト作成処理を行う           --%>
    <%------------------------------------%>

      <s:if test="#iSubCatNum == 0">
        <script type="text/javascript">
        subCatStr += writeSubCategory('0', '0', '');

        </script>
        <s:set var="iSubCatNum" value="#iSubCatNum + 1"/>
        <s:set var="iGrpNo" value="-1"/>
      </s:if>


      <s:if test="#iGrpNo == -1">
        <s:set var="iGrpNo" value="#main2.grpNo"/>
      </s:if>
      <s:elseif test="#iGrpNo != #main2.grpNo">
        <s:set var="iGrpNo" value="#main2.grpNo"/>
        <script type="text/javascript">
        subCatStr += '<tr><td><hr style="height:1pt;" /></td></tr>';
        </script>
      </s:elseif>

      <s:if test="#main2.mntKb == 2">
        <%-- 非活性リンク用 --%>
        <script type="text/javascript">
        subCatStr += createDummyLinkTag('5','<s:property value="#strName" escapeHtml="false"/>');
        </script>
      </s:if>

      <s:elseif test="#main2.formType != '' && #main2.formType != null">
        <%-- フォーム起動用 --%>
        <script type="text/javascript">
        subCatStr += createFormDate("5",'<s:property value="#strName" escapeHtml="false"/>','<s:property value="#main2.boldFlg"/>','<s:property value="#main2.newFlg"/>','<s:property value="#main2.linkUrl"/>','<s:property value="#main2.targetType"/>','<s:property value="#main2.formType"/>','<s:property value="#main2.formName"/>','<s:property value="#main2.paramName1"/>','<s:property value="#main2.paramType1"/>','<s:property value="#main2.paramName2"/>','<s:property value="#main2.paramType2"/>','<s:property value="#main2.paramName3"/>','<s:property value="#main2.paramType3"/>','<s:property value="#main2.paramName4"/>','<s:property value="#main2.paramType4"/>','<s:property value="#main2.paramName5"/>','<s:property value="#main2.paramType5"/>','<s:property value="#main2.freeParamName1"/>','<s:property value="#main2.freeParam1"/>','<s:property value="#main2.freeParamName2"/>','<s:property value="#main2.freeParam2"/>','<s:property value="#main2.freeParamName3"/>','<s:property value="#main2.freeParam3"/>','<s:property value="#main2.freeParamName4"/>','<s:property value="#main2.freeParam4"/>','<s:property value="#main2.freeParamName5"/>','<s:property value="#main2.freeParam5"/>');
        </script>
      </s:elseif>

      <s:elseif test="#main2.scrnId == '' || #main2.scrnId == null">
        <%-- リンク用 --%>

        <s:set id="subLinkUrl2" value="(#main2.linkUrl != null && #main2.linkUrl != '') ? #main2.linkUrl : ''"/>
        <script type="text/javascript">
        <%-- 通常リンクかチェックする --%>
        if(linkUrlCheck("<s:property value="#subLinkUrl2"/>")){
          <%-- 通常リンク用 --%>
          subCatStr += createLinkTag('5','<s:property value="#strName" escapeHtml="false"/>',"<s:property value="#subLinkUrl2"/>",'<s:property value="#main2.targetType"/>','<s:property value="#main2.boldFlg"/>','<s:property value="#main2.newFlg"/>');
        }else if(checkOpera("<s:property value="#subLinkUrl2"/>")){
          subCatStr += createOpera("5","<s:property value="#subLinkUrl2"/>",'<s:property value="#main2.boldFlg"/>','<s:property value="#main2.newFlg"/>');
        }else{
          <%-- オンクリックパラメータ用 --%>
          subCatStr += createOnClick('5','<s:property value="#strName" escapeHtml="false"/>',"<s:property value="#subLinkUrl2"/>",'<s:property value="#main2.boldFlg"/>','<s:property value="#main2.newFlg"/>');
        }
        </script>
      </s:elseif>

      <s:else>
        <%-- オンクリック用 --%>
        <script type="text/javascript">
        subCatStr += createLinkMov('5','<s:property value="#strName" escapeHtml="false"/>','<s:property value="#main2.scrnId"/>','<s:property value="#main2.funcId"/>','<s:property value="#main2.boldFlg"/>','<s:property value="#main2.newFlg"/>');
        </script>
      </s:else>
    </s:elseif>

  </s:if>
</s:iterator>

<s:if test="#iCatNum > 0">
  <script type="text/javascript">
  subCatStr += writeEndList();
  subCatStr += writeEndSubCategory();
  </script>
</s:if>

<div style="z-index: 1000; position: absolute;top:38px;left:108px;" id="menuCat" ></div>

<div style="z-index: 1000; position: absolute" id="menuSubCat"></div>

<script type=text/javascript>
  document.all.menuCat.innerHTML = mainCatStr + '</tr></tbody></table>';
  document.all.menuSubCat.innerHTML = subCatStr;

  setSubCatSize();
</script>

