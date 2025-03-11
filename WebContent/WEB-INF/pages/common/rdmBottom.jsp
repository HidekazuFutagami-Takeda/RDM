<%--
/**
 * <pre>
 * 共通インクルードボトム用JSPです。
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author
 */
--%>
<%@ page
  language="java"
  import="java.util.*,java.text.*"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  isErrorPage="false"
  info="rdmBottom"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
  function mnuBottomGo(screenId,functionId){
    document.fmX.windowName.value = self.name;
    if(window.opener!=null){
      document.fmX.openerName.value = window.opener.name;
    }
    document.fmX.screenId.value = screenId;
    document.fmX.functionId.value = functionId;
    document.fmX.submit();
  }
</script>
<form style="visibility:hidden;position:absolute;" name="fmX" action="<%= request.getContextPath() %>/servlet/control" method="POST">
  <input type="hidden" name="screenId" value=""></input>
  <input type="hidden" name="functionId" value=""></input>
  <input type="hidden" name="windowName" value=""></input>
  <input type="hidden" name="openerName" value=""></input>
</form>
<s:if test="%{#session.NC001_RETURN_DTO_KEY == null}">
  <s:set id="TOP_FUNCTIONID" value="'Init'"/>
</s:if>
<s:else>
  <s:set id="TOP_FUNCTIONID" value="'View'"/>
</s:else>
<!-- セカンダリリンク 開始 -->
<!-- <table border="0" cellpadding="0" cellspacing="0" width="100%"> -->
<!-- <tbody> -->
<!--   <tr> -->
<!--     <td align="right"> -->
<%--       <a class="comBannerSecondaryLink" style="margin-left:3pt;margin-right:3pt;" href="" onClick="JavaScript:rdmMenuLink('<s:property value="%{#TOP_FUNCTIONID}"/>');return false;"> --%>
<!--       トップメニューへ -->
<!--       </a> -->
<!--       <a class="comBannerSecondaryLink" href="" OnClick="rdmHomeLink();return false;"><font class="comBannerSecondaryLink">ホームへ</font></a>&nbsp; -->
<!--     </td> -->
<!--   </tr> -->
<!-- </tbody> -->
<!-- </table> -->
<!-- セカンダリリンク 終了 -->
