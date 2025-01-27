<%--
/**
 * <pre>
 * トップメニューのインクルード部分です。
 * 各アプリケーションでインクルードして利用します。
 * インクルードは静的埋め込み方式とします。
 * 例&lt;%@ include file="/menu/mnuTop00.jsp" %&gt;
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author 日立　花
 */
--%>
<%@ page
  language="java"
  import="java.util.*,java.text.*,jp.co.takeda.rdm.util.AppConstant,jp.co.takeda.jkr.common.MainMenuData"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String menuUsrAge = request.getHeader("user-agent");
boolean menuIPadFlg = false;

if( menuUsrAge.indexOf("iPad") >= 0 ){
  menuIPadFlg = false;
}
%>
<s:set id="menuIPadFlg" value="#request.getHeader('user-agent').indexOf('iPad') < 0"/>
<%
  boolean vistaFlg2 = false;
  boolean menuIPadFlg2 = false;
  String usrAgeTop00 = request.getHeader("User-Agent");
  if(usrAgeTop00.indexOf("Windows NT 6.0") >= 0){
    vistaFlg2 = true;
  }
  if( usrAgeTop00.indexOf("iPad") >= 0 ){
    menuIPadFlg2 = true;
  }
%>
<s:set id="vistaFlg2" value="#request.getHeader('user-agent').indexOf('Windows NT 6.0') >= 0"/>
<s:set id="menuIPadFlg2" value="#request.getHeader('user-agent').indexOf('iPad') >= 0"/>

<link href="css/mainMenu.css" type="text/css" rel="Stylesheet">
<script type="text/javascript" src="js/mainMenubase.js"></script>
<script type="text/javascript" src="js/mainMenusystem.js"></script>
<script type="text/javascript" src="js/mainMenuwrite.js"></script>
<script type="text/javascript">
  createScriptData();
</script>
<script type="text/javascript" src="js/ajax.js"></script>


<%-- 単独でも実行できるように直接javascriptとフォームを埋め込む --%>
<script type="text/javascript">
function mnuTopGo(screenId,functionId){

  document._fmTopMenu.windowName.value = self.name;
  if(window.opener!=null){
    document._fmTopMenu.openerName.value = window.opener.name;
  }
  document._fmTopMenu.screenId.value = screenId;
  document._fmTopMenu.functionId.value = functionId;

  if((screenId == "Academy" && functionId == "ViewInit")
    || (screenId == "EDetailing" && functionId == "Menu")
  ){
    document._fmTopMenu.action = getNewServerActionUrl();
  } else if ((screenId == "Menu" && functionId == "ViewInit")
  ){
    document._fmTopMenu.action = getNewServerActionUrl();
  }

  document._fmTopMenu.submit();
}
function mnuSioriGo(screenId,functionId,InitFlg){

  document._fmTopSiori.screenId.value = screenId;
  document._fmTopSiori.functionId.value = functionId;
  document._fmTopSiori._kdcInit.value = InitFlg;
  document._fmTopSiori.submit();
}


function mnuLinkOpenBlank(screenName){
  var prm="width="+screen.availWidth+",height="+screen.availHeight+",top=0,left=0,menubar=yes,toolbar=yes,location=yes,directories=yes,status=yes,scrollbars=yes,resizable=yes";
  window.open(screenName,"_blank",prm);
}


function mnuMainGo(screenId,functionId){

  mainMenuFmMainMenu();

  if(document._fmMainMenu){
    document._fmMainMenu.windowName.value = self.name;

    if(window.opener!=null){
      document._fmMainMenu.openerName.value = window.opener.name;
    }

    document._fmMainMenu.screenId.value = screenId;
    document._fmMainMenu.functionId.value = functionId;
    document._fmMainMenu.submit();
  }else if(document.all._fmMainMenu){
    document.all._fmMainMenu.windowName.value = self.name;

    if(window.opener!=null){
      document.all._fmMainMenu.openerName.value = window.opener.name;
    }

    document.all._fmMainMenu.screenId.value = screenId;
    document.all._fmMainMenu.functionId.value = functionId;
    document.all._fmMainMenu.submit();
  }
}


function mnuMainGo3(screenId,functionId){

  mainMenuFmMainMenu3();

  if(document._fmMainMenu3){
    document._fmMainMenu3.windowName.value = self.name;

    if(window.opener!=null){
      document._fmMainMenu3.openerName.value = window.opener.name;
    }

    document._fmMainMenu3.screenId.value = screenId;
    document._fmMainMenu3.functionId.value = functionId;
    document._fmMainMenu3.action = getNewServerActionUrl();
    document._fmMainMenu3.submit();
  }else if(document.all._fmMainMenu3){
    document.all._fmMainMenu3.windowName.value = self.name;

    if(window.opener!=null){
      document.all._fmMainMenu3.openerName.value = window.opener.name;
    }

    document.all._fmMainMenu3.screenId.value = screenId;
    document.all._fmMainMenu3.functionId.value = functionId;
    document.all._fmMainMenu3.action = getNewServerActionUrl();
    document.all._fmMainMenu3.submit();
  }
}


function mnuDccGo(){

  mainMenuFmDccMenu();

  if(document._fmDccMenu){
    document._fmDccMenu.target = "_main";
    document._fmDccMenu.action = "https://www.inforesta.com/loginSp.php";
    document._fmDccMenu.submit();
  }else if(document.all._fmDccMenu){
    document.all._fmDccMenu.target = "_main";
    document.all._fmDccMenu.action = "https://www.inforesta.com/loginSp.php";
    document.all._fmDccMenu.submit();
  }
}


function mnuSasGo(){

  mainMenuFmSasMenu();

  var fmSasMenuFlg = true; // true:本番 false：テスト

  w = window.open("","saswin1","width=1000,height=690,resizable=no,status=no,toolbar=no,scrollbars=yes,titlebar=no,top=5,left=5");

  if(document._fmSasMenu){
    document._fmSasMenu.target = "saswin1";

    if(fmSasMenuFlg){
      //本番環境
      document._fmSasMenu.action = "https://www13.ylp.co.jp/takeda/login.cfm";
    }else{
      //テスト環境用URL
      document._fmSasMenu.action = "https://www6.ylp.co.jp/takeda_demo/login.cfm";
    }

    document._fmSasMenu.submit();
  }else if(document.all._fmSasMenu){
    document.all._fmSasMenu.target = "saswin1";

    if(fmSasMenuFlg){
      //本番環境
      document.all._fmSasMenu.action = "https://www13.ylp.co.jp/takeda/login.cfm";
    }else{
      //テスト環境用URL
      document.all._fmSasMenu.action = "https://www6.ylp.co.jp/takeda_demo/login.cfm";
    }

    document.all._fmSasMenu.submit();
  }
}

function mnuPmsGo(){

  mainMenuFmPmsMenu();

  w=window.open("","pmswin1","scrollbars=yes,resizable=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,left=0,top=0,width=1016,height=714");

  if(document._fmPmsMenu){
    document._fmPmsMenu.target = "pmswin1";
    document._fmPmsMenu.HnTarget.value = window.name;
    document._fmPmsMenu.action = "https://tkd.postmawatch.jp/pmw/ComnW0110.do";
    document._fmPmsMenu.submit();
  }else if(document.all._fmPmsMenu){
    document.all._fmPmsMenu.target = "pmswin1";
    document.all._fmPmsMenu.HnTarget.value = window.name;
    document.all._fmPmsMenu.action = "https://tkd.postmawatch.jp/pmw/ComnW0110.do";
    document.all._fmPmsMenu.submit();
  }
}

</script>

<script Language="VBScript">
Function RunExe()
  Dim objFS, objFile
  Dim newfile
  newfile = "c:\Iryo\V_PMS\test.vbs"
  Dim shell
  Dim IEShell

  Set objFS = CreateObject("Scripting.FileSystemObject")

  If objFS.FileExists(newfile) = True Then
    objFS.DeleteFile newfile
  End If

  objFS.CreateTextFile newfile,False
  Set objFile = objFS.OpenTextFile("c:\Iryo\V_PMS\test.vbs",8)

  objFile.WriteLine "Option Explicit"
  objFile.WriteLine "Const cnsBook = ""PMS_JBK08.xlsm"""
  objFile.WriteLine "Const xlAutoOpen = 1"
  objFile.WriteLine "Dim objExcelApp, objWbk, strPath"
  objFile.WriteLine "strPath = ""C:\Iryo\V_PMS\"""
  objFile.WriteLine "Set objExcelApp = CreateObject(""Excel.Application"")"
  objFile.WriteLine "Set objWbk = objExcelApp.Workbooks.Open(strPath & cnsBook, False, False)"
  objFile.WriteLine "objExcelApp.Visible = True"
  objFile.WriteLine "objExcelApp.Visible = True"
  objFile.WriteLine "Set objWbk = Nothing"
  objFile.WriteLine "Set objExcelApp = Nothing"
  objFile.Close

  Set shell = CreateObject("WScript.Shell")
  Call Shell.run ("c:\Iryo\V_PMS\test.vbs")'VBスクリプトを実行します
  Set IEShell = CreateObject("Shell.Application")
  IEShell.MinimizeAll
End Function
</script>

<%-- 共通部品　メニューで使用する変数の初期設定を行う --%>
<%@ include file="mainMenuInit.jsp" %>
<s:set name="dateFormat" value="%{new java.text.SimpleDateFormat('yyyy年MM月dd日(E)')}" />
<%-- ログイン名の表示 開始 --%>
<nobr>
<s:set id="menuTempCheck1"  value="#loginInfoFlg && #loginData.screenId == 'Menu' && #loginData.functionId == 'MenuViewInit'"/>
<s:set id="menuTempCheck2"  value="#loginInfoFlg && #loginData.screenId == 'MapsHome'"/>
<s:set id="menuTempCheck31" value="#loginInfoFlg && #loginData.screenId == 'KeepDocument' && #loginData.functionId == 'ViewInit'"/>
<s:set id="menuTempCheck32" value="#loginInfoFlg && #loginData.screenId == 'KeepDocument' && #loginData.functionId == 'View'"/>
<s:set id="menuTempCheck33" value="#loginInfoFlg && #loginData.screenId == 'KeepDocument' && #loginData.functionId == 'Page'"/>
<s:set id="menuTempCheck34" value="#loginInfoFlg && #loginData.screenId == 'KeepDocument' && #loginData.functionId == 'Search'"/>
<s:set id="menuTempCheck35" value="#loginInfoFlg && #loginData.screenId == 'KeepDocument' && #loginData.functionId == 'Sort'"/>
<s:if test="!#loginInfoFlg || #loginData.directExecType == null || loginData.directExecType != '2'">
  <s:if test="!#portletIdFlg || !#renderModeFlg">
    <s:if test="#loginInfoFlg">
      <s:if test="#menuTempCheck1 || #menuTempCheck2 || #menuTempCheck31 || #menuTempCheck32 || #menuTempCheck33 || #menuTempCheck34 || #menuTempCheck35">
        <s:if test="!#vistaFlg2 && !#menuIPadFlg2">
          <span class="menuWelcomeWin7">
        </s:if>
        <s:else>
          <span class="menuWelcome">
        </s:else>
      </s:if>
      <s:else>
        <s:if test="!#vistaFlg2 && !#menuIPadFlg2">
          <span class="comWelcomeWin7" id="Welcome">
        </s:if>
        <s:else>
          <span class="comWelcome" id="Welcome">
        </s:else>
      </s:else>

      </span>
    </s:if>
    <s:else>
      <s:if test="!#vistaFlg2 && !#menuIPadFlg2">
        <span class="comWelcomeWin7" id="Welcome">
      </s:if>
      <s:else>
        <span class="comWelcome" id="Welcome">
      </s:else>
      ホームページ
    </span>
    </s:else>
  </s:if>
</nobr>
<%-- ログイン名の表示 終了 --%>
<s:if test="!#outSideFlg">
  <s:if test="#mainMenu != null && #mainMenu.menuCode != 'S0110403' && #mainMenu.menuCode != 'S0110405'">
  <%@ include file="mnuNewMainLinks.jsp" %>
  </s:if>
</s:if>


<s:if test="!#menuTempCheck1 && !#menuTempCheck2 && !#menuTempCheck31 && !#menuTempCheck32 && !#menuTempCheck33 && !#menuTempCheck34 && !#menuTempCheck35">
  <table border="0" cellpadding="0" cellspacing="0" height="30" width="100%">
  <tbody>
    <tr><td>

      <table background="<%= request.getContextPath() %>/img/pobtrans.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
      <tbody>
      <tr>
        <%-- タイトル画像とホームへのリンク 開始 --%>
        <td align="left" width="5%">
          <img alt="ホームへ" border="0" src="<%= request.getContextPath() %>/img/HomeNaviLogo.png">
        </td>
        <%-- タイトル画像とホームへのリンク 終了 --%>

        <%-- 右端ロゴ 開始 --%>
        <td align="right" width="5%">
          <table border="0" cellSpacing="0">
          <tbody>
            <tr><td align="middle" valign="bottom">
              <span class="comWelcome" id="Welcome">
                <s:property value="#session.UserInfoKey.jgiName"/>さん
              </span>
              <br />
              <font class="comBannerSecondaryText"><s:property value="%{#dateFormat.format(new java.util.Date())}" /></font></td></tr>
            <tr><td align="middle">&nbsp;</td></tr>
          </tbody></table>
        </td>
        <%-- 右端ロゴ 終了 --%>

      </tr>
      </tbody>
      </table>

    </td></tr>
  </tbody>
  </table>
</s:if>
<s:elseif test="!#menuTempCheck1">
  <s:if test="#menuIPadFlg">
  <table border="0" cellpadding="0" cellspacing="0" width="104%" height="35">
  </s:if>
  <s:else>
  <table border="0" cellpadding="0" cellspacing="0" width="100%" height="35">
  </s:else>
    <tr>
      <s:if test="#menuIPadFlg">
        <td class="lineBgLogIpad" rowspan="2" width="216">
      </s:if>
      <s:else>
      <td class="lineBgLog" rowspan="2" width="216">
      </s:else>
        <a href='<s:property value="#serverPath" />/maps/servlet/control?screenId=Menu&functionId=ViewInit' target="_top" ><img src="../img/mainHomeNaviLogo.gif" border="0" alt="ホームへ"></a>
      </td>
      <td height="18">
        &nbsp;
      </td>
      <td width="223">
        <span class="comWelcome" id="Welcome">
          <s:property value="#session.UserInfoKey.jgiName"/>さん
        </span>
        <br />
        <font class="comBannerSecondaryText"><s:property value="%{#dateFormat.format(new java.util.Date())}" /></font>
      </td>
    </tr>
    <tr>
      <td class="lineBg bgAlpha" colspan="2">
        &nbsp;
      </td>
    </tr>
    <tr style="display: none;">
      <td align="center" height="25">
        <img src="../img/menuCallIcon.png" alt="メインメニュー">
      </td>
      <td height="5" colspan="2"></td>
    </tr>
  </table>
</s:elseif>
<s:else>
  <table border="0" cellpadding="0" cellspacing="0" width="100%" height="35">
    <tr>
      <s:if test="#menuIPadFlg">
        <td class="lineBgLogIpad" rowspan="2" width="216">
      </s:if>
      <s:else>
        <td class="lineBgLog" rowspan="2" width="216">
      </s:else>
        <a href='<s:property value="#serverPath" />/maps/servlet/control?screenId=Menu&functionId=ViewInit' target="_top" ><img src="../img/mainHomeNaviLogo.gif" border="0" alt="ホームへ"></a>
      </td>
      <td height="18">
        &nbsp;
      </td>
      <td width="223">
        <span class="comWelcome" id="Welcome">
          <s:property value="#session.UserInfoKey.jgiName"/>さん
        </span>
        <br />
        <font class="comBannerSecondaryText"><s:property value="%{#dateFormat.format(new java.util.Date())}" /></font>
      </td>
    </tr>
    <tr>
      <td class="lineBg bgAlpha" colspan="2">
        &nbsp;
      </td>
    </tr>
    <tr style="display: none;">
      <td align="left">
        <img src="../img/menuCallIcon.png" alt="メインメニュー" >
      </td>
      <td height="5" colspan="2"></td>
    </tr>
  </table>
</s:else>

<%-- メインメニューのセッションがあり且つメニューコードが「S0110403」(医営本外) 以外かチェックする --%>
<s:if test="#mainMenu != null && #mainMenu.menuCode != 'S0110403' && #mainMenu.menuCode != 'S0110405'">
  <%-- 共通部品　メインメニュー作成 --%>
  <%@ include file="../menu/mnuMainLinks.jsp" %>
</s:if>

<%-- このページは、OC4J単独とポートレットの両方からインクルードされるためrequest.getContextPath()/servlet/controlにします。 --%>
<form style="visibility:hidden;position:absolute;" name="_fmTopMenu" action='<s:property value="#serverPath" />/maps/servlet/control' method="POST">
  <input type="hidden" name="screenId" value=""></input>
  <input type="hidden" name="functionId" value=""></input>
  <input type="hidden" name="windowName" value=""></input>
  <input type="hidden" name="openerName" value=""></input>
</form>
<%-- しおりトップリンク対応 --%>
<form style="visibility:hidden;position:absolute;" name="_fmTopSiori" action=<s:property value="#serverPath" />/maps/servlet/control' method="POST">
  <input type="hidden" name="screenId" value=""></input>
  <input type="hidden" name="functionId" value=""></input>
  <input type="hidden" name="windowName" value=""></input>
  <input type="hidden" name="openerName" value=""></input>
  <input type="hidden" name="_kdcInit" value=""></input>
</form>
</s:if>
