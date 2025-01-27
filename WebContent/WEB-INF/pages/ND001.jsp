<%--
/**
 * <pre>
 *  メニュー一覧のJSP
 * </pre>
 * @since 1.0
 * @author 日立　花
 */
--%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppMethods,
      jp.co.takeda.rdm.util.RdmConstantsData,
      jp.co.takeda.rdm.util.JkrConstantsData"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  isErrorPage="false"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="dateFormat0" value="%{new java.text.SimpleDateFormat('yyyy年M月d日')}" />
<s:set name="dateFormat1" value="%{new java.text.SimpleDateFormat('dd')}" />
<s:set name="dateFormat2" value="%{new java.text.SimpleDateFormat('yyyy/MM/dd HH:mm:ss')}" />
<s:set name="dateFormat3" value="%{new java.text.SimpleDateFormat('yyyy/MM/dd')}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>メニュー</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link href="css/jkrMenu.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="js/jkrMenu.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/catSosJgiExpand.js"></script>
<script type="text/javascript" src="js/jgiKanren.js"></script>
<script>

/**
 * <pre>
 * 次画面に遷移
 * </pre>
 */
function gotoNext(screenId,functionId){
  fm1.screenId.value=screenId;
  fm1.functionId.value=functionId;
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  詳細 => 一覧
 * 一覧へ戻る(リンク)押下時に呼ばれます。
 * </pre>
 */
function jmnView(){

  var msg       =   '<s:property value="#session.UserInfoKey.msgMap.M0122723.msgData" />';
  var msg2  =   '<s:property value="#session.UserInfoKey.msgMap.M0122724.msgData" />';
  //新組織対応
  if(fm1.sosText!=undefined && fm1.sosText.value=="" && fm1.planSosText!=undefined && fm1.planSosText.value=="" ){
    alert(msg);
    return false;
  }
  document.fm1.screenId.value="ND001";
  document.fm1.functionId.value="Search";
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 * 画面表示時のメッセージ表示処理
 * </pre>
 */
function shwoInit() {

  //エラーメッセージを表示させる
  <s:if test="hasActionErrors()">
    var msg = '';
    <s:iterator value="actionErrors">
      msg = msg + '<s:property escape="false"/>' + '\n';
    </s:iterator>
    alert(msg);
  </s:if>

}

</script>
<body class="comPage" onLoad="comSetFormWindowName('JMN');jmnViewLoad();showInit();"  onmousemove="resetTimer();">

  <%-- バナー部分をインクルード 開始 --%>
  <jsp:include page="menu/mnuTop02.jsp" flush="true" />
  <%-- バナー部分をインクルード 終了 --%>

  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>


<table border="0" class="comPortalTable" align="center" style="width:98%;">
<!-- メニュータイトル -->
  <tr>
    <td class="comTitle">
      <table border="0" cellPadding="12" cellSpacing="0" align="center">
        <tr>
          <td align="center" valign="bottom">
            <a class="comBigMenuTitle"><font color="#ffffff" size="5"><b>メニュー</b></font></a>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <s:form name="fm1" theme="simple" >
        <s:hidden name="screenId"/>
        <s:hidden name="functionId"/>
        <s:hidden name="backScreenId" value="ND001" />
        <s:hidden name="menuMnIktFac"/>
        <s:hidden name="menuMnIktDoc"/>
        <s:hidden name="menuMnNtFac"/>
        <s:hidden name="jokenSetCd"/>

<!-- 業務選択エリア -->

          <table align="center" border="0" id="jobsel" width="80%">
            <tr>
              <td align="center">
                <label>医師施設登録・変更</label>
              </td>
            </tr>
          </table>

          <!-- 管理者権限 or MR権限 -->
          <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_ADMIN || jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_MR}">
            <table align="center" border="0" id="jobsel" width="880px">
              <!-- 医師・コメディカル情報 -->
              <s:if test="%{menuMnIktDoc == 1}">
              <tr>
                <td style="width:230px">
                 <label>医師・コメディカル情報</label>
                </td>
              　　　　　　　　　 <td style="width:200px">
                 <a href="" class="contentsTitle" onclick="gotoNext('ND001','Init'); return false;">新規登録・更新・削除</a>
              　　　　　　　　　</td>
                 <td style="width:450px">
                 <label>医師の異動（勤務施設の変更）もここから申請可能です。</label>
                </td>
              </tr>
              <tr>
                <td></td>
              　　　　　　　　　<td>
                 <a href="" class="contentsTitle" onclick="gotoNext('ND401','Init'); return false;">医師一括更新</a>
              　　　　　　　　　</td>
                <td>
                  <label>医師の一括更新を申請できます。</label>
                </td>
              </tr>
              <tr>
                <td></td>
              　　　　　　　　　<td>
                 <a href="" class="contentsTitle" onclick="gotoNext('ND501','Init'); return false;">医師情報・更新履歴</a>
              　　　　　　　　　</td>
                <td>
                  <label>過去の医師情報・変更履歴を参照できます。</label>
                </td>
              </tr>
              <tr>
                <td colSpan="3">
                  <hr class="comSplit" style="width:100%" id="jobselbar">
                </td>
              </tr>
              </s:if>

              <!-- 施設情報 -->
              <s:if test="%{menuMnIktFac == 1}">
              <tr>
                <td style="width:230px">
                 <label>施設情報</label>
                </td>
              　　　　　　　　　<td style="width:200px">
                 <a href="" class="contentsTitle" onclick="gotoNext('NF001','Init'); return false;">新規登録・更新・削除</a>
              　　　　　　　　　</td>
                <td style="width:450px">
                <label>施設の作成・更新・削除などが申請できます。</label>
                </td>
              </tr>
              <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_ADMIN}">
                <s:if test="%{menuMnNtFac == 1}">
                  <tr>
                    <td></td>
                  　　　　　　　　　<td>
                     <a href="" class="contentsTitle" onclick="gotoNext('NF403','Init'); return false;">来期用項目一括申請</a>
                  　　　　　　　　　</td>
                    <td>
                     <label>ULT下書きから施設来期用項目の一括で申請できます。</label>
                    </td>
                  </tr>
                  <tr>
                    <td></td>
                  　　　　　　　　　<td>
                     <a href="" class="contentsTitle" onclick="gotoNext('NF401','Init'); return false;">来期用項目一括更新</a>
                  　　　　　　　　　</td>
                    <td>
                      <label>施設来期用項目の一括更新を申請できます。</label>
                    </td>
                  </tr>
                </s:if>
              </s:if>
              <tr>
                <td></td>
              　　　　　　　　　<td>
                 <a href="" class="contentsTitle" onclick="gotoNext('NF501','Init'); return false;">施設情報・更新履歴</a>
              　　　　　　　　　</td>
                <td>
                  <label>施設の変更履歴を参照できます。</label>
                </td>
              </tr>
              <tr>
                <td colSpan="3">
                  <hr class="comSplit" style="width:100%" id="jobselbar">
                </td>
              </tr>
              </s:if>

              <!-- 申請内容確認 -->
              <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_ADMIN}">
                <tr>
                  <td style="width:230px">
                   <label>申請内容確認</label>
                  </td>
                　　　　　　　　　<td style="width:200px">
                   <a href="" class="contentsTitle" onclick="gotoNext('NM001','Init'); return false;">申請サマリ</a>
                　　　　　　　　　</td>
                  <td style="width:450px">
                  <label>エリア毎の要確認・要承認件数などを確認できます。</label>
                  </td>
                </tr>
                <tr>
                  <td></td>
                　　　　　　　　　<td>
                   <a href="" class="contentsTitle" onclick="gotoNext('NC011','Init'); return false;">申請一覧</a>
                　　　　　　　　　</td>
                  <td>
                   <label>申請案件・承認待ち案件の状況・詳細を確認できます。</label>
                  </td>
                </tr>
                <tr>
                  <td></td>
                　　　　　　　　　<td>
                   <a href="" class="contentsTitle" onclick="gotoNext('NM011','Init'); return false;">通知一覧</a>
                　　　　　　　　　</td>
                  <td>
                    <label>内容確認が必要な通知を一覧で確認できます。</label>
                  </td>
                </tr>
                <tr>
                  <td colSpan="3">
                    <hr class="comSplit" style="width:100%" id="jobselbar">
                  </td>
                </tr>
              </s:if>

              <s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_MR}">
                <tr>
                  <td style="width:230px">
                   <label>申請内容確認</label>
                  </td>
                　　　　　　　　　<td>
                   <a href="" class="contentsTitle" onclick="gotoNext('NC011','Init'); return false;">申請一覧</a>
                　　　　　　　　　</td>
                  <td>
                   <label>申請案件・承認待ち案件の状況・詳細を確認できます。</label>
                  </td>
                </tr>
                <tr>
                  <td colSpan="3">
                    <hr class="comSplit" style="width:100%" id="jobselbar">
                  </td>
                </tr>
              </s:elseif>

            </table>
          </s:if>

          <s:else>
          //上記以外はありえない。（エラー画面遷移）
          </s:else>

<!-- 業務選択エリア -->

<!-- 後で消すここから -->

          <table align="center" border="0" id="jobsel" width="81%">
              <tr>
                <td>
                 <label>testNC</label>
                </td>
              　　　　　　　　　<td>
                 <a href=""  onclick="gotoNext('JKR040C010','Init'); return false;">JKR040C010</a>
              　　　　　　　　　</td>
              </tr>
          </table>
<!-- 後で消すここまで -->



      </s:form>
      <div id="resultTmp" style="display:none;"></div>
    </td>
  </tr>
</table>
</body>
</html>
