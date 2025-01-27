<%--
/**
 * <pre>
 *  従業員関連【共通】更新警告メッセージ表示のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author 日立　花
 */
--%>
<%@page import="jp.co.takeda.jkr.common.LoginInfo"%>
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
<%-- データ更新中メッセージ表示 開始 --%>
  <table border="0" cellPadding="0" cellSpacing="0" align="center" style="width:100%;margin-top:3pt;">
  <tbody>
  <tr>
    <td align="center">
      <s:if test="#session.UserInfoKey.timeDataFlg == 1">
      <font color="red">
        <b><nobr>18:00よりデータ更新処理を行いますので、作業を終了してください。</nobr></b>
      </font>
      </s:if>
    </td>
  </tr>
  </tbody>
  </table>
<%-- データ更新中メッセージ表示 終了 --%>
