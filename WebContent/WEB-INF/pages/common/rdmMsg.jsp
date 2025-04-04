<%--
/**
 * <pre>
 *  従業員関連【共通】エラーメッセージ表示のJSP
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

<s:if test="msgStr != null">
	<table border="1" cellpadding="2" cellspacing="0" width="75%" style="background-color:gold;">
		<tbody>
			<tr>
				<td>
					<nobr>
					<font color=red>
					<s:property value="msgStr.replaceAll('\\n', '<br />')" escape="false"/>
					</font>
					</nobr>
				</td>
			</tr>
		</tbody>
	</table>
</s:if>