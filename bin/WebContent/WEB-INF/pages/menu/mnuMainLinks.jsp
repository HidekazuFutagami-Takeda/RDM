<%--
/**
 * <pre>
 * メインメニューのインクルード部分です。
 * 各アプリケーションでインクルードして利用します。
 * インクルードは静的埋め込み方式とします。
 * 例&lt;%@ include file="/menu/mnuTop00.jsp" %&gt;
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
  contentType="text/html;charset=UTF-8"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<%-- メニュー画面かチェックする --%>
<s:if test="actScreenId == 'Menu' && actFunctionId == 'MenuViewInit'">
  <div id="menuData" style="position:absolute;z-index:1000"></div>
<%-- 上記以外は全てサブシステムと判断する --%>
</s:if>
<s:else>
  <div id="menuData" style="position:absolute;z-index:1000"></div>
</s:else>

<%-- グループ配列数だけループする --%>
<s:iterator value="#session.mainMenuData.groupList" var="menuList" status="status">
  <%-- メインメニュー配列数だけループする --%>
  <s:iterator value="#menuList" var="main">
  
    <%-- サブメニューフラグが「１」の場合はポップアップ作成処理を行う --%>
    <s:if test="#main.subMenuFlg == 1">
      <%-- 非活性リンクかチェックする --%>
      <s:if test="#main.mntKb == 2">
        <%-- 非活性リンク用 --%>
        <script type="text/javascript">
        htmlStr += createDummyLinkTag('1','<s:property value="#main.menuName"/>');
        </script>
        
      <%-- 上記以外 --%>
      </s:if>
      <s:else>
        
        <script type="text/javascript">
        var pop = "";
        pop += '<tr style="padding-top:0px;padding-bottom:0px;">';
        pop += '<td align="right" valign="top" class="mainMenuItem" id="onLink" style="padding-left:0px;padding-top:0px;padding-bottom:0px;"><img src="' + menuImgData + '" name="imgMenuBlockDIV' + menuCnt + '" style="margin-top:3px;"></td>';
        pop += '<td' + pddingTopCheck2('<s:property value="#main.newFlg"/>') + '>';
        pop += writeNaviBarStart(menuCnt);
        pop += writeNaviMenu(menuCnt, '<s:property value="#main.menuName"/>', "index.html",'<s:property value="#main.boldFlg"/>','<s:property value="#main.newFlg"/>');
        pop += writeNaviBarEnd();
        
        pop += writeMenuBlockStart(menuCnt);
        </script>
        <%--サブメニュー処理--%>
        <s:iterator value="#main.subManuList" id="sub">
          <s:if test="#sub.mntKb == 2">
            <%-- 非活性リンク用 --%>
            <script type="text/javascript">
            pop += createDummyLinkTag('3','<s:property value="#sub.menuName"/>');
            </script>
          </s:if>
          <s:elseif test="#sub.formType != null && #sub.formType != ''">
            <%-- フォーム起動用 --%>
            <script type="text/javascript">
            pop += createFormDate("2",'<s:property value="#sub.menuName"/>','<s:property value="#sub.boldFlg"/>','<s:property value="#sub.newFlg"/>','<s:property value="#sub.linkUrl"/>','<s:property value="#sub.targetType"/>','<s:property value="#sub.formType"/>','<s:property value="#sub.formName"/>','<s:property value="#sub.paramName1"/>','<s:property value="#sub.paramType1"/>','<s:property value="#sub.paramName2"/>','<s:property value="#sub.paramType2"/>','<s:property value="#sub.paramName3"/>','<s:property value="#sub.paramType3"/>','<s:property value="#sub.paramName4"/>','<s:property value="#sub.paramType4"/>','<s:property value="#sub.paramName5"/>','<s:property value="#sub.paramType5"/>','<s:property value="#sub.freeParamName1"/>','<s:property value="#sub.freeParam1"/>','<s:property value="#sub.freeParamName2"/>','<s:property value="#sub.freeParam2"/>','<s:property value="#sub.freeParamName3"/>','<s:property value="#sub.freeParam3"/>','<s:property value="#sub.freeParamName4"/>','<s:property value="#sub.freeParam4"/>','<s:property value="#sub.freeParamName5"/>','<s:property value="#sub.freeParam5"/>');
            </script>
          </s:elseif>
          <s:elseif test="#sub.scrnId == null || #sub.scrnId == ''">
            <%-- リンク用 --%>
            <s:set id="subLinkUrl" value="#sub.linkUrl != null ? #sub.linkUrl : ''"/>
            
            <script type="text/javascript">
            <%-- 通常リンクかチェックする --%>
            if(linkUrlCheck("<s:property value="#subLinkUrl"/>")){
              <%-- 通常リンク用 --%>
              pop += createLinkTag('3','<s:property value="#sub.menuName"/>',"<s:property value="#subLinkUrl"/>","<s:property value="#sub.targetType"/>","<s:property value="#sub.boldFlg"/>","<s:property value="#sub.newFlg"/>");
            }else if(checkOpera("<s:property value="#subLinkUrl"/>")){
              pop += createOpera("2","<s:property value="#subLinkUrl"/>","<s:property value="#sub.boldFlg"/>","<s:property value="#sub.newFlg"/>");
            }else{
              <%-- オンクリックパラメータ用 --%>
              pop += createOnClick('3','<s:property value="#sub.menuName"/>',"<s:property value="#subLinkUrl"/>","<s:property value="#sub.boldFlg"/>","<s:property value="#sub.newFlg"/>");
            }
            </script>
          </s:elseif>
          <s:else>
            <%-- オンクリック用 --%>
            <script type="text/javascript">
            pop += createLinkMov('3','<s:property value="#sub.menuName"/>',"<s:property value="#sub.scrnId"/>","<s:property value="#sub.funcId"/>","<s:property value="#sub.boldFlg"/>","<s:property value="#sub.newFlg"/>");
            </script>
          </s:else>
        </s:iterator>
        
        <script type="text/javascript">
        pop += writeMenuBlockEnd();
        
        startNaviMenu( "NaviBar" + menuCnt, "NaviMenuTD", "NaviMenu", "NaviMenuLink", "MenuBlockDIV", "MenuItem");
        
        pop += '</td></tr>';
        
        menuCnt++;
        
        htmlStr += pop;
        </script>
      </s:else>
      
    <%--上記以外はリンク作成処理を行う--%>
    </s:if>
    <s:else>
    
      <s:if test="#main.mntKb == 2">
        <%-- 非活性リンク用 --%>
        <script type="text/javascript">
        htmlStr += createDummyLinkTag("1",'<s:property value="#main.menuName"/>');
        </script>
      </s:if>
      
      <s:elseif test="#main.formType != null && #main.formType != ''">
        <%-- フォーム起動用 --%>
        <script type="text/javascript">
        htmlStr += createFormDate("1",'<s:property value="#main.menuName"/>','<s:property value="#main.boldFlg"/>','<s:property value="#main.newFlg"/>','<s:property value="#main.linkUrl"/>','<s:property value="#main.targetType"/>','<s:property value="#main.formType"/>','<s:property value="#main.formName"/>','<s:property value="#main.paramName1"/>','<s:property value="#main.paramType1"/>','<s:property value="#main.paramName2"/>','<s:property value="#main.paramType2"/>','<s:property value="#main.paramName3"/>','<s:property value="#main.paramType3"/>','<s:property value="#main.paramName4"/>','<s:property value="#main.paramType4"/>','<s:property value="#main.paramName5"/>','<s:property value="#main.paramType5"/>','<s:property value="#main.freeParamName1"/>','<s:property value="#main.freeParam1"/>','<s:property value="#main.freeParamName2"/>','<s:property value="#main.freeParam2"/>','<s:property value="#main.freeParamName3"/>','<s:property value="#main.freeParam3"/>','<s:property value="#main.freeParamName4"/>','<s:property value="#main.freeParam4"/>','<s:property value="#main.freeParamName5"/>','<s:property value="#main.freeParam5"/>');
        </script>
      </s:elseif>
      
      <s:elseif test="#main.scrnId == null || #main.scrnId == ''">
        <%-- リンク用 --%>
        <s:set id="mainLinkUrl" value="#main.linkUrl != null ? #main.linkUrl : ''"/>
        
        <script type="text/javascript">
        if(linkUrlCheck("<s:property value="#mainLinkUrl"/>")){
          htmlStr += createLinkTag("1",'<s:property value="#main.menuName"/>',"<s:property value="#mainLinkUrl"/>",'<s:property value="#main.targetType"/>','<s:property value="#main.boldFlg"/>','<s:property value="#main.newFlg"/>');
        }else if(checkOpera("<s:property value="#mainLinkUrl"/>")){
          htmlStr += createOpera("1","<s:property value="#mainLinkUrl"/>",'<s:property value="#main.boldFlg"/>','<s:property value="#main.newFlg"/>');
        }else{
          htmlStr += createOnClick("1",'<s:property value="#main.menuName"/>',"<s:property value="#mainLinkUrl"/>",'<s:property value="#main.boldFlg"/>','<s:property value="#main.newFlg"/>');
        }
        </script>
      </s:elseif>
      
      <s:else>
        <%-- オンクリック用 --%>
        <script type="text/javascript">
        htmlStr += createLinkMov("1",'<s:property value="#main.menuName"/>','<s:property value="#main.scrnId"/>','<s:property value="#main.funcId"/>','<s:property value="#main.boldFlg"/>','<s:property value="#main.newFlg"/>');
        </script>
      </s:else>
    </s:else>
  </s:iterator>
  
  <s:if test="%{#groupList.size() -1 > #status.index">
          <%-- グループ切り分け用ライン --%>
          <script type="text/javascript">
          htmlStr += '<tr><td colspan="2"><hr style="height:1pt;" /></td></tr>';
          </script>
  </s:if>
</s:iterator>

<script type="text/javascript">
  var innerHTMLData = "";
</script>
  <%-- メニュー画面かチェックする --%>
  <s:if test="actScreenId == 'Menu' && actFunctionId == 'MenuViewInit'">
    <script type="text/javascript">
      innerHTMLData += hedStrTop();
    </script>
  </s:if>
  <s:else>
    <script type="text/javascript">
      innerHTMLData += hedStr();
    </script>
  </s:else>
<script type="text/javascript">
  innerHTMLData += htmlStr;
  innerHTMLData += hutStr();
  
  document.all.menuData.innerHTML = innerHTMLData;

  //サブメニューポップアップサイズ再定義
  //サブメニューのポップアップのサイズがwidth=200未満の場合は
  //デフォルトサイズとして「200」を設定する
  //上記以外は書き出し時の表示サイズとする
  
  //サブメニューの数だけループする
  for (var i = 0 ; i < menuCnt ; i++){
    //オブジェクトが存在するかチェックする
    if(eval("document.all.MenuBlockDIV" + i)){
      //オブジェクトを設定
      var obj = eval("document.all.MenuBlockDIV" + i);
      
      //画面表示出力表示サイズが「200」未満かチェックする
      if(obj.offsetWidth < 200){
        //デフォルトサイズ指定
        obj.style.width = defltPopUpSize;
      }
    }
  }
</script>

<script type="text/javascript">
  menuAjaxTime = setTimeout("menuReSession()",ajaxTime);
</script>
