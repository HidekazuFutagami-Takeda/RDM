<%--
/**
 * <pre>
 *  従業員関連メニュー一覧のJSP
 * </pre>
 * @since 1.0
 * @author 日立　花
 */
--%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppMethods,
      jp.co.takeda.rdm.util.RdmConstantsData,
      jp.co.takeda.jkr.util.JkrConstantsData"
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
<title>施設・医師担当変更</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link href="css/common.css" rel="Stylesheet" type="text/css" />
<link href="css/jkrMenu.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="js/jkrMenu.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/catSosJgiExpand.js"></script>
<script type="text/javascript" src="js/jgiKanren.js"></script>
<script>

  function openMenu(menuId) {
    var menuBox = document.getElementById("menuBox" + menuId);
    var menuBody = document.getElementById("menuBody" + menuId);
    var menuHead = document.getElementById("menuHead" + menuId);
    var menuIcon = document.getElementById("menuIcon" + menuId);

    if (menuBody.style.display == "none") {
      if (menuId == "01") {
        menuBox.style.width = "900px";
      } else if (menuId == "02") {
        menuBox.style.width = "900px";
      } else if (menuId == "03") {
        menuBox.style.width = "900px";
      }
      menuHead.style.display = "none";
      menuBody.style.display = "inline";
      menuIcon.innerHTML = "－";
    } else {
      menuBox.style.width = "900px";
      menuHead.style.display = "inline";
      menuBody.style.display = "none";
      menuIcon.innerHTML = "＋";
    }
  }



/**
 * <pre>
 * 支店用ラジオボタン変更中フラグ
 * </pre>
 */
var is_radio_clicked = false;

var is_same_clicked = false;
/**
 * <pre>
 * ラジオボタンを変更する
 * </pre>
 * onChange()に呼ばれます
 *
 */
function changeRadioSiten(){
  //既にチェックされたが、再度クリックした場合
  if (is_same_clicked) {
    return false;
  }

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  if (is_radio_clicked) {
    alert("既に処理を開始しています。");
    return false;
  } else {
    is_radio_clicked = true;
  }

  <%//支店権限%>
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_SITEN}"><!-- JKN0160 -->
    if(fm1.elements["catsel"][0].checked){//施設にチェック
      searchButton.style.display = "inline";
      fm1.selectedSosCd.value ="";
      sosTekiyou1.style.visibility ="hidden";
      sosTekiyou2.style.visibility ="hidden";
      sosTekiyou3.style.visibility ="hidden";
      osirase.style.visibility ="hidden";
      <s:if test="jkrSosStsTableData != null">
        menuBox01.style.visibility ="hidden";
        menuBox02.style.visibility ="hidden";
        menuBox03.style.visibility ="hidden";
        menuBox04.style.visibility ="hidden";
        menuBox05.style.visibility ="hidden";
      </s:if>
      //sosButtonArea1.style.display ="inline";
      fm1.selectedSosName.value="";
      <%//新組織表示権限がある場合%>
      <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
        fm1.selectedPlanSosName.value="";
      </s:if>

      //「(組織)選択ボタン」「(組織（新）)選択ボタン」を活性とする
      setSentaBtnStatus(false);
      if (document.fm1.ShowBtn) {
        document.fm1.ShowBtn.disabled = false;
      }

      is_radio_clicked = false;
    }
    else if(fm1.elements["catsel"][1].checked){//支店にチェック
      fm1.selectedSosCd.value ="";
      searchButton.style.display = "none";
      sosTekiyou1.style.display ="inline";
      sosTekiyou2.style.display ="inline";
      sosTekiyou3.style.display ="inline";
      osirase.style.display ="inline";

      <s:if test="jkrSosStsTableData != null">
      menuBox01.style.display ="inline";
      menuBox02.style.display ="inline";
      menuBox03.style.display ="inline";
      menuBox04.style.display ="inline";
      menuBox05.style.display ="inline";
      </s:if>
      //sosButtonArea1.style.visibility ="hidden";
      fm1.selectedSosName.value='<s:property value="sosName" />';
      // 新組織対応
      <%//新組織表示権限がある場合%>
      <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
        fm1.selectedPlanSosName.value="";
      </s:if>
      // 新組織対応
      // 支店権限者が支店権限のMR種類を選択時に、指定したMR種類で再検索を行うよう対応
      fm1.trtGrpCd.value = fm1.sitenPldn.value;

      //ログインユーザ（代行ユーザ含む）が所属する組織の全データの中でステータスが「’６０’（適用完了）もしくは、’６1'（適用時エラー）」の適用日が一つでも存在する場合
      <s:if test="%{sosSelectDisableFlg == 1}">
        //「(組織)選択ボタン」「(組織（新）)選択ボタン」を非活性とする
        setSentaBtnStatus(true);
        if (document.fm1.ShowBtn) {
          document.fm1.ShowBtn.disabled = true;
        }
        is_radio_clicked = false;
      </s:if>
      <s:else>
        getParam();
        fm1.screenId.value='RDM000C010';
        fm1.functionId.value='Init';
        comSubmitForAnyWarp(fm1);
      </s:else>

    }
    else if(fm1.elements["catsel"][2].checked){//営業所にチェック
      searchButton.style.display = "inline";
      fm1.selectedSosCd.value ="";
      sosTekiyou1.style.visibility ="hidden";
      sosTekiyou2.style.visibility ="hidden";
      sosTekiyou3.style.visibility ="hidden";
      osirase.style.visibility ="hidden";
      <s:if test="jkrSosStsTableData != null">
        menuBox01.style.visibility ="hidden";
        menuBox02.style.visibility ="hidden";
        menuBox03.style.visibility ="hidden";
        menuBox04.style.visibility ="hidden";
        menuBox05.style.visibility ="hidden";
      </s:if>
      //sosButtonArea1.style.display ="inline";
      fm1.selectedSosName.value="";
      // 新組織対応
      <%//新組織表示権限がある場合%>
      <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
        fm1.selectedPlanSosName.value="";
      </s:if>

      //「(組織)選択ボタン」「(組織（新）)選択ボタン」を活性とする
      setSentaBtnStatus(false);
      if (document.fm1.ShowBtn) {
        document.fm1.ShowBtn.disabled = false;
      }

      // 新組織対応
      is_radio_clicked = false;
    }

  </s:if>
  //ポップアップ画面のwindowオブジェクト保管用
  if (gCseViewWin) {
    //組織選択POP画面が既に開いてるなら閉じる
    gCseViewWin.close();
  }
}


/**
 * <pre>
 * ラジオボタンを変更する
 * </pre>
 * onChange()に呼ばれます
 *
 */
function changeRadio(){

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  document.fm1.ShowBtn.disabled = false;

  <%//営業所権限除く%>
  <s:if test="%{jokenSetCd != @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_EIGYOU}"><!-- not equal JKN0159 -->
      fm1.selectedSosCd.value="";
      fm1.selectedSosName.value="";
      <%//新組織表示権限がある場合%>
      <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
        fm1.selectedPlanSosName.value="";
      </s:if>
  </s:if>


      sosTekiyou1.style.visibility ="hidden";
      sosTekiyou2.style.visibility ="hidden";
      sosTekiyou3.style.visibility ="hidden";
      osirase.style.visibility ="hidden";
      <s:if test="jkrSosStsTableData != null">
        menuBox01.style.visibility ="hidden";
        menuBox02.style.visibility ="hidden";
        menuBox03.style.visibility ="hidden";
        menuBox04.style.visibility ="hidden";
        menuBox05.style.visibility ="hidden";
      </s:if>

  //ポップアップ画面のwindowオブジェクト保管用
  if (gCseViewWin) {
    //組織選択POP画面が既に開いてるなら閉じる
    gCseViewWin.close();
  }
}


/**
 * <pre>
 * 初期表示時に表示する箇所を指定
 * </pre>
 * onload時に呼ばれます
 *
 */
function jmnViewInit(){

  <%//本部権限%>
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_HONBU_COMMIT || jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_HONBU_NOCOMMIT}"><!-- JKN0163,JKN0162 -->
    <%//初期時%>
    <s:if test="%{#session.UserInfoKey.functionId == 'Init'}">
      sosTekiyou1.style.visibility ="hidden";
      sosTekiyou2.style.visibility ="hidden";
      sosTekiyou3.style.visibility ="hidden";
      osirase.style.visibility ="hidden";
      <s:if test="jkrSosStsTableData != null">
        menuBox01.style.visibility ="hidden";
        menuBox02.style.visibility ="hidden";
        menuBox03.style.visibility ="hidden";
        menuBox04.style.visibility ="hidden";
        menuBox05.style.visibility ="hidden";
      </s:if>
    </s:if>
  </s:if>

  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_VACCINE}"><!-- JKN0161 -->
  <%//ワクチンG権限%>
    <%//初期時%>
    <s:if test="%{#session.UserInfoKey.functionId == 'Init'}">
      sosTekiyou1.style.visibility ="hidden";
      sosTekiyou2.style.visibility ="hidden";
      sosTekiyou3.style.visibility ="hidden";
      osirase.style.visibility ="hidden";
      <s:if test="jkrSosStsTableData != null">
        menuBox01.style.visibility ="hidden";
        menuBox02.style.visibility ="hidden";
        menuBox03.style.visibility ="hidden";
        menuBox04.style.visibility ="hidden";
        menuBox05.style.visibility ="hidden";
      </s:if>
    </s:if>
  </s:if>

  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_SITEN}"><!-- JKN0160 -->
  <%//支店権限%>
    <%//初期時%>
    <s:if test="%{#session.UserInfoKey.functionId == 'Init'}">
      searchButton.style.display = "none";
    </s:if>
  </s:if>

  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START
  <%//ONC営業部スタッフ権限%>
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_ONC}"><!-- JKN0349 -->
    <%//初期時%>
    <s:if test="%{#session.UserInfoKey.functionId == 'Init'}">
      sosTekiyou1.style.visibility ="hidden";
      sosTekiyou2.style.visibility ="hidden";
      sosTekiyou3.style.visibility ="hidden";
      osirase.style.visibility ="hidden";
      <s:if test="jkrSosStsTableData != null">
        menuBox01.style.visibility ="hidden";
        menuBox02.style.visibility ="hidden";
        menuBox03.style.visibility ="hidden";
        menuBox04.style.visibility ="hidden";
        menuBox05.style.visibility ="hidden";
      </s:if>
    </s:if>
  </s:if>
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END

  <%//新組織表示権限がある場合%>
  <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">

    <s:if test="%{(sosSelFlg == 0 && (selectedSosName == null || selectedSosName == '') || (sosSelFlg == 1 && (selectedPlanSosName == null || selectedPlanSosName == '')}">
    <%//現組織選択時 又は新組織選択時%>
      <%//初期時以外%>
      <s:if test="%{#session.UserInfoKey.functionId != 'Init'}">
        sosTekiyou1.style.visibility ="hidden";
        sosTekiyou2.style.visibility ="hidden";
        sosTekiyou3.style.visibility ="hidden";
        osirase.style.visibility ="hidden";
        if(document.getElementById('menuBox01')){
          menuBox01.style.visibility ="hidden";
          menuBox02.style.visibility ="hidden";
          menuBox03.style.visibility ="hidden";
          menuBox04.style.visibility ="hidden";
          menuBox05.style.visibility ="hidden";
        }
      </s:if>
    </s:if>

  </s:if>
  <s:else>
  <%//新組織表示権限がない場合%>
    <s:if test="%{selectedSosName == null || selectedSosName == '')}">
      <%//初期時以外%>
      <s:if test="%{#session.UserInfoKey.functionId != 'Init'}">
        sosTekiyou1.style.visibility ="hidden";
        sosTekiyou2.style.visibility ="hidden";
        sosTekiyou3.style.visibility ="hidden";
        osirase.style.visibility ="hidden";
        if(document.getElementById('menuBox01')){
          menuBox01.style.visibility ="hidden";
          menuBox02.style.visibility ="hidden";
          menuBox03.style.visibility ="hidden";
          menuBox04.style.visibility ="hidden";
          menuBox05.style.visibility ="hidden";
        }
      </s:if>
    </s:if>
  </s:else>

  //営業MR権限かつ権限組織なし
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@JKR_JKN_EIGYOU && pageCntAll == 0 && (sosCdHairetu == null || sosCdHairetu == '')}"><!-- JKN0159 -->
      sosButtonArea1.style.display ="none";
  </s:if>
}



/**
 * <pre>
 * 次画面に遷移
 * </pre>
 */
function gotoNext(screenId,functionId){
  getParam();
  fm1.screenId.value=screenId;
  fm1.functionId.value=functionId;
  comSubmitForAnyWarp(fm1);
}

 /**
  * <pre>
  * CSVダウンロード処理
  * </pre>
  */
 function downloadCsv(screenId,functionId){
   getParam();
   fm1.screenId.value=screenId;
   fm1.functionId.value=functionId;
   try{
     fm1.action = fm1.screenId.value + fm1.functionId.value + ".action"
     fm1.submit();
   }catch(e){
     if (e.number == -2147024891) {
       alert('添付ファイルに正しいファイルパス・ファイル名を指定して下さい。');
       COM_Click_flg = true;
     }
   }
 }


/**
 * <pre>
 * 担当変更（topリンク／【５】担当変更の確定処理）に遷移
 * </pre>
 */
function gotoTantoHenkoLink(linkType){
  getParam();
//  fm1.screenId.value = "JKR020C010";
  fm1.screenId.value = "NF012";
  fm1.functionId.value = "Init";
//  fm1.reqId.value = "241225-000001";
  fm1.reqId.value = "241002-000011";
  if (linkType == 1) {
    fm1.wkCat.value ='<%=RdmConstantsData.BUS_TYPE_STS_CNF%>';
    fm1.selectedJgiJoken.value = fm1.jokenSetCd.value;
  }
  //リンクタイプ　1：topリンク　2：【５】担当変更の確定処
  if (linkType == 1) {
    fm1.tekiyoYmdUpdateFlg.value = fm1.tekiyoYmdUpdateFlg1.value;
  } else if (linkType == 2) {
    fm1.tekiyoYmdUpdateFlg.value = fm1.tekiyoYmdUpdateFlg2.value;
  }
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 * 次画面に遷移
 * </pre>
 *gotoNext()から呼び出される
 */
function getParam(){
var joken = getJokenSet();

  if(fm1.catsel!=undefined){
    var i;
    for(i=0;i<fm1.catsel.length;i++){
      if(fm1.catsel[i].checked){
        fm1.wkCat.value =fm1.catsel[i].value;
      }
    }
  }else{
    fm1.wkCat.value ='<%=RdmConstantsData.BUS_TYPE_EIGYOU%>';
  }


  if(joken==1) {//本部権限
    getMrCat(1);
  }
  if(joken==2){ //ワクチンG権限%>
    getMrCat(2);
  }
  if(joken==3){ //支店権限%>
    getMrCat(3);
  }
  if(joken==4){ //営業MR権限%>
    getMrCat(4);
  }
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START
  if(joken==5){ //ONC営業部スタッフ権限%>
    getMrCat(5);
  }
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END

  //選択され組織名称設定
  //新現組織フラグ(現組織：0、新組織：1)
  if (fm1.sosSelFlg.value == "0") {
    fm1.selectedSosNm.value =fm1.selectedSosName.value;
  } else {
    fm1.selectedSosNm.value =fm1.selectedPlanSosName.value;
  }

  //業務権限の設定
  if (joken==1) {//本部権限
    //支店代行
    if (fm1.wkCat.value =='<%=RdmConstantsData.BUS_TYPE_SITEN%>') {
      fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_SITEN%>';

    //営業所代行
    } else if (fm1.wkCat.value =='<%=RdmConstantsData.BUS_TYPE_EIGYOU%>') {
      //20150224 HISOL Suzuki 期末期首 組織変更対応 UPD START
      //fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_EIGYOU%>';
      if(fm1.catsel!=undefined){
        if(fm1.eigyouPldn!=undefined){
          if(fm1.eigyouPldn.type=="hidden"){
              //20180119 HISOL Kawamoto JKR-C-005 MOD START
              ////「ＯＮＣ」選択の場合
              //if(fm1.eigyouPldn.value == '<%=RdmConstantsData.TRT_GRP_CD_004%>') {
              //  fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_ONC%>';
              ////「営業所」選択の場合
              //}else{
              //  fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_EIGYOU%>';
              //}
              //「営業所」選択の場合
              if(fm1.eigyouPldn.value == '<%=RdmConstantsData.TRT_GRP_CD_001%>') {
                fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_EIGYOU%>';
              //「ONC or SPC」選択の場合
              }else{
                fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_ONC%>';
              }
              //20180119 HISOL Kawamoto JKR-C-005 MOD END
          }else{
            //20180119 HISOL Kawamoto JKR-C-005 MOD START
            ////「ＯＮＣ」選択の場合
            //if(fm1.eigyouPldn.options[fm1.eigyouPldn.selectedIndex].value == '<%=JkrConstantsData.TRT_GRP_CD_004%>') {
            //  fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_ONC%>';
            ////「営業所」選択の場合
            //}else{
            //  fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_EIGYOU%>';
            //}
            //「営業所」選択の場合
            if(fm1.eigyouPldn.options[fm1.eigyouPldn.selectedIndex].value == '<%=JkrConstantsData.TRT_GRP_CD_001%>') {
              fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_EIGYOU%>';
            //「ONC or SPC」選択の場合
            }else{
              fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_ONC%>';
            }
            //20180119 HISOL Kawamoto JKR-C-005 MOD END
         }
        }
      }
      //20150224 HISOL Suzuki 期末期首 組織変更対応 UPD END
    } else {
      fm1.selectedJgiJoken.value = fm1.jokenSetCd.value;
    }
  }
  if (joken==2) { //ワクチンG権限%>
    fm1.selectedJgiJoken.value = fm1.jokenSetCd.value;
  }
  if (joken==3) { //支店権限%>
    //営業所代行
    if (fm1.wkCat.value =='<%=JkrConstantsData.BUS_TYPE_EIGYOU%>') {
      fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_EIGYOU%>';

    } else {
      fm1.selectedJgiJoken.value = fm1.jokenSetCd.value;
    }
  }
  if (joken==4) { //営業MR権限%>
    fm1.selectedJgiJoken.value = fm1.jokenSetCd.value;
  }
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START
  if(joken==5){ //ONC営業部スタッフ権限%>
    //営業所代行
    if (fm1.wkCat.value =='<%=JkrConstantsData.BUS_TYPE_EIGYOU%>') {
      fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_ONC%>';

    //支店業務（施設の営業所間移動）
    } else {
//      fm1.selectedJgiJoken.value = fm1.jokenSetCd.value;
      fm1.selectedJgiJoken.value = '<%=RdmConstantsData.RDM_JKN_SITEN%>';
    }
  }
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END

}
/**
 * <pre>
 * MR種類WK種類を決定する
 * </pre>
 * gotoNext()に呼ばれます
 *
 *【説明】
 *
 *条件区分を引数とする
 *条件分岐：
 *１．権限を確認。
 *２．選択された業務種類（選択されたチェックボックス）を確認。
 *３．選択された業務種類でMR種類が存在するかを確認。
 *４．選択された業務種類がtext表示か否かを確認（例fm1.honbuPldn.type=="hidden"）
 */
function getMrCat(jokenKbn){
  if(jokenKbn==1){//本部権限
    if(fm1.catsel!=undefined){
      if(fm1.elements["catsel"][0].checked){
        if(fm1.honbuPldn!=undefined){
          if(fm1.honbuPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.honbuPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.honbuPldn.options[fm1.honbuPldn.selectedIndex].value;
          }
        }
      }else if(fm1.elements["catsel"][1].checked){
        if(fm1.sisetuPldn!=undefined){
          if(fm1.sisetuPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.sisetuPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.sisetuPldn.options[fm1.sisetuPldn.selectedIndex].value;
          }
        }
      }else if(fm1.elements["catsel"][2].checked){
        if(fm1.sitenPldn!=undefined){
          if(fm1.sitenPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.sitenPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.sitenPldn.options[fm1.sitenPldn.selectedIndex].value;
          }
        }
      }else if(fm1.elements["catsel"][3].checked){
        if(fm1.eigyouPldn!=undefined){
          if(fm1.eigyouPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.eigyouPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.eigyouPldn.options[fm1.eigyouPldn.selectedIndex].value;
          }
        }
      }
    }
  }
  if(jokenKbn==2){//本部権限(ワクチン)
    if(fm1.catsel!=undefined){
      if(fm1.elements["catsel"][0].checked){
        if(fm1.honbuPldn!=undefined){
          if(fm1.honbuPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.honbuPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.honbuPldn.options[fm1.honbuPldn.selectedIndex].value;
          }
        }
      }else if(fm1.elements["catsel"][1].checked){
        if(fm1.sisetuPldn!=undefined){
          if(fm1.sisetuPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.sisetuPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.sisetuPldn.options[fm1.sisetuPldn.selectedIndex].value;
          }
        }
      }
    }
  }
  if(jokenKbn==3){//支店権限
    if(fm1.catsel!=undefined){
      if(fm1.elements["catsel"][0].checked){
        if(fm1.sisetuPldn!=undefined){
          if(fm1.sisetuPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.sisetuPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.sisetuPldn.options[fm1.sisetuPldn.selectedIndex].value;
          }
        }
      }else if(fm1.elements["catsel"][1].checked){
        if(fm1.sitenPldn!=undefined){
          if(fm1.sitenPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.sitenPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.sitenPldn.options[fm1.sitenPldn.selectedIndex].value;
          }
        }
      }else if(fm1.elements["catsel"][2].checked){
        if(fm1.eigyouPldn!=undefined){
          if(fm1.eigyouPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.eigyouPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.eigyouPldn.options[fm1.eigyouPldn.selectedIndex].value;
          }
        }
      }
    }
  }
  if(jokenKbn==4){//営業所権限
    fm1.trtGrpCd.value= fm1.eigyouPldn.value;
  }
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START
  if(jokenKbn==5){//ONC営業部スタッフ権限
    if(fm1.catsel!=undefined){
      if(fm1.elements["catsel"][0].checked){
        if(fm1.sisetuPldn!=undefined){
          if(fm1.sisetuPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.sisetuPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.sisetuPldn.options[fm1.sisetuPldn.selectedIndex].value;
          }
        }
      }else if(fm1.elements["catsel"][1].checked){
        if(fm1.eigyouPldn!=undefined){
          if(fm1.eigyouPldn.type=="hidden"){
            fm1.trtGrpCd.value= fm1.eigyouPldn.value;
          }else{
            fm1.trtGrpCd.value= fm1.eigyouPldn.options[fm1.eigyouPldn.selectedIndex].value;
          }
        }
      }
    }
  }
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END
}

/**
 * <pre>
 * 権限分岐決定
 * </pre>
 * 1:本部権限
 * 2:本部（ワクチン権限）
 * 3:支店権限
 * 4:営業所権限
 *
 */
function getJokenSet(){
  <%//本部権限%>
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_HONBU_COMMIT || jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_HONBU_NOCOMMIT}"><!-- JKN0163,JKN0162 -->
    return "1";
  </s:if>

  <%//ワクチンG権限%>
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_VACCINE}"><!-- JKN0161 -->
    return "2";
  </s:if>

  <%//支店権限%>
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_SITEN}"><!-- JKN0160 -->
    return "3";
  </s:if>

  <%//営業MR権限%>
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_EIGYOU}"><!-- JKN0159 -->
    return "4";
  </s:if>

  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START
  <%//ONC営業部スタッフ権限%>
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_ONC}"><!-- JKN0349 -->
    return "5";
  </s:if>
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END
}

/**
 * <pre>
 * 選択パラメータ決定(現組織)
 * </pre>
 */
function setSentakuParam(){
  setSentakuParamNew(1);
}

/**
 * <pre>
 * 選択パラメータ決定(新組織)
 * </pre>
 *
 */
function setSentakuParamPlan(){
  setSentakuParamNew(2);
}

/**
 * <pre>
 * 選択パラメータ決定
 * </pre>
 *
 */
function setSentakuParamNew(sosKbnPop){

  //現組織
  if (sosKbnPop == 1) {
    //fm1.objData.value  = "1";// 対象データ区分「1：現組織」
    //fm1.sosSelFlg.value = "0";//新現組織フラグ(現組織：0、新組織：1)
    document.fm1.sosKbnPop.value = "1"; //組織区分

  //新組織
  } else {
    //fm1.objData.value  = "2";// 対象データ区分「2：新（予定）組織」
    //fm1.sosSelFlg.value = "1";//新現組織フラグ(現組織：0、新組織：1)
    document.fm1.sosKbnPop.value = "2"; //組織区分
  }

  var joken=getJokenSet();
  var IEHON="01050";//医営本
  //チェックボックス、ラジオボタンの項目を設定
  getParam();

  //営業MR権限かつ権限組織あり
  <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_EIGYOU && (sosCdHairetu != null && sosCdHairetu != '')}"><!-- JKN0159 -->
    document.fm1.bumonRankTopPop.value = "2";  //部門ランク(最上位)
    document.fm1.bumonRankBtmPop.value = "3";  //部門ランク(最下位)
    document.fm1.topSosCdPop.value     = document.fm1.jgiActUpSosCd.value;  //最上位組織コード
    document.fm1.defTblFlgPop.value    = "0";  //定義テーブル使用フラグ

    document.fm1.jokenSetCdPop.value             = document.fm1.jokenSetCd.value; //条件セットコード
    document.fm1.menuTrtGrpCdPop.value           = ""; //選択領域グループ(メニュー)
    document.fm1.selectableBumonrankPop.value    = "3";  //選択可能部門ランク

    //営業所権限
    if (joken == 4) {
      //ユーザ所属営業所の上位組織（支店)の組織コード
      fm1.initSosCdPop.value    = fm1.jgiActUpSosCd.value;//初期表示組織
    }
  </s:if>
  <s:else>
    document.fm1.bumonRankTopPop.value = "";  //部門ランク(最上位)
    document.fm1.bumonRankBtmPop.value = "";  //部門ランク(最下位)
    document.fm1.topSosCdPop.value     = "";  //最上位組織コード
    document.fm1.defTblFlgPop.value    = "1"; //定義テーブル使用フラグ"

    document.fm1.jokenSetCdPop.value             = document.fm1.jokenSetCd.value; //条件セットコード
    document.fm1.menuTrtGrpCdPop.value           = document.fm1.trtGrpCd.value; //選択領域グループ(メニュー)
    document.fm1.selectableBumonrankPop.value    = "";  //選択可能部門ランク

    //本部権限 OR ワクチン権限
    if (joken == 1 || joken == 2) {
      /*業務区分 : 本部権限 */
      if (fm1.wkCat.value == '<%=JkrConstantsData.BUS_TYPE_HONBU%>') {
        fm1.initSosCdPop.value = IEHON;//初期表示組織

      /*業務区分 : 支店権限(代行） */
      } else if (fm1.wkCat.value == '<%=JkrConstantsData.BUS_TYPE_SITEN%>') {
        fm1.initSosCdPop.value  = IEHON;//初期表示組織

      /*業務区分 : 営業所権限(代行） */
      } else if (fm1.wkCat.value == '<%=JkrConstantsData.BUS_TYPE_EIGYOU%>') {
          if(fm1.selectedSosCd.value != "") {
            fm1.initSosCdPop.value  =  fm1.selectedSosCd.value;
          } else{
            fm1.initSosCdPop.value  = IEHON;//初期表示組織
          }
      /*業務区分 : 施設の担当組織変更 */
      } else if (fm1.wkCat.value == '<%=JkrConstantsData.BUS_TYPE_INS_CHG%>') {
        fm1.initSosCdPop.value    = IEHON;//初期表示組織
      }

    //支店権限
    } else if (joken == 3) {
      fm1.initSosCdPop.value    = fm1.sosCd.value;//初期表示組織
    //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START
    //ONC営業部スタッフ権限
    } else if (joken == 5) {
      /*業務区分 : 営業所権限(代行） */
      if (fm1.wkCat.value == '<%=JkrConstantsData.BUS_TYPE_EIGYOU%>') {
        if(fm1.selectedSosCd.value != "") {
          fm1.initSosCdPop.value  =  fm1.selectedSosCd.value;
        } else{
          fm1.initSosCdPop.value = fm1.sosCd.value;//初期表示組織
          //fm1.initSosCdPop.value  = IEHON;//初期表示組織
        }
      /*業務区分 : 施設の担当組織変更 */
      } else if (fm1.wkCat.value == '<%=JkrConstantsData.BUS_TYPE_INS_CHG%>') {
        fm1.initSosCdPop.value = fm1.sosCd.value;//初期表示組織
      }
    //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END
    }
  </s:else>
}


/**
 * <pre>
 *  詳細 => 一覧
 * 一覧へ戻る(リンク)押下時に呼ばれます。
 * </pre>
 */
function jmnView(){

getParam();
  var msg       =   '<s:property value="#session.UserInfoKey.msgMap.M0122723.msgData" />';
  var msg2  =   '<s:property value="#session.UserInfoKey.msgMap.M0122724.msgData" />';
  //新組織対応
  if(fm1.sosText!=undefined && fm1.sosText.value=="" && fm1.planSosText!=undefined && fm1.planSosText.value=="" ){
    alert(msg);
    return false;
  }
  document.fm1.screenId.value="JKR000C010";
  document.fm1.functionId.value="Search";
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 * ポップアップに遷移
 * </pre>
 */
  function execConfirm(execId) {
    // 2度押し対策
    if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
    if (execId == "check") {
      if(confirm('<s:property value="%{@jp.co.takeda.rdm.util.StringUtils@toMS932(#session.UserInfoKey.msgMap.M0122704.msgData)}"/>')){
        getParam();
        document.fm1.screenId.value="JKR000C010";
        document.fm1.functionId.value="Check";
        comSubmitForAnyWarp(fm1);
      }
    } else if (execId == "pdf") {

      //2014/12/19 条件設定を追加 参照する変数をjokenSetCd→selectedJgiJokenに変更
      <s:if test="%{trtGrpCd == @jp.co.takeda.jkr.util.JkrConstantsData@TRT_GRP_CD_003}">
        if (!(document.fm1.report4.checked || document.fm1.report5.checked || document.fm1.report6.checked)){

          //メッセージマスタの修正タイミングがあるまでべた書き。
          alert("作成したいリストを選択して下さい");

        } else if(confirm('<s:property value="#session.UserInfoKey.msgMap.M0122705.msgData" />')){
          getParam();
          document.fm1.screenId.value="JKR000C010";
          document.fm1.functionId.value="Listout";

          comSubmitForAnyWarp(fm1);
        }
      </s:if>
      <s:else>
        <%-- ワクチンMR対応(ワクチンMR用PDF追加) --%>
        if (!(document.fm1.report2.checked || document.fm1.report3.checked || document.fm1.report4.checked)){

          //メッセージマスタの修正タイミングがあるまでべた書き。
          alert("作成したいリストを選択して下さい");

        } else if(confirm('<s:property value="#session.UserInfoKey.msgMap.M0122705.msgData" />')){
          getParam();
          document.fm1.screenId.value="JKR000C010";
          document.fm1.functionId.value="Listout";

          comSubmitForAnyWarp(fm1);
        }
      </s:else>
    //ＵＨ施設一覧
    } else if (execId == "pdf1") {
        var msg = "";
        getParam();
        document.fm1.caseKbn.value='0'; //ケース区分
        document.fm1.searchInsChg.value="";    // 担当先区分：空白
        //対象区分で「'12'(UH)」が選択されている状態とする。
        document.fm1.hoInsType.value="12";   // 対象区分に「UH」を初期表示
        document.fm1.screenId.value="JKR040C010";
        document.fm1.functionId.value="Init";
        comSubmitForAnyWarp(fm1);

    //Ｐ担当者別市区郡別施設一覧
    } else if (execId == "pdf2") {
      var msg = "";
      getParam();
      document.fm1.caseKbn.value='0'; //ケース区分
      document.fm1.searchInsChg.value="";    // 担当先区分：空白
      //対象区分で「'3'(P)」が選択されている状態とする
      document.fm1.hoInsType.value="3"; // 対象区分に「P」を初期表示
      document.fm1.screenId.value="JKR040C010";
      document.fm1.functionId.value="Init";
      comSubmitForAnyWarp(fm1);

    //複数担当先所属部科別担当者別医師一覧
    } else if (execId == "pdf3") {
      var msg = "";
      getParam();
      //対象区分で「'3'(P)」が選択されている状態とする
      document.fm1.screenId.value="JKR050C010";
      document.fm1.functionId.value="Init";
      comSubmitForAnyWarp(fm1);
    } else {
      var msg = "";
      var lochtml = "";
    }
    return false;
  }


/**
 * <pre>
 * 営MRか判断し、表示非表示を決定
 * </pre>
 */
function checkeiMr(){
  //医師別担当変更関連項目表示フラグ
  <s:if test="%{docChgLinkFlg == 1}" >
    ishi.style.display ="inline";
    ishiRadio.style.display ="inline";
    ishiPdf1.style.display ="inline";
    ishiPdf2.style.display ="inline";
  </s:if>
  <s:else>
    ishi.style.visibility ="hidden"; //複数td
    ishiRadio.style.visibility ="hidden";//複数radio
    ishiPdf1.style.visibility ="hidden";//複数担当先所属部科別担当者別医師数,
    ishiPdf2.style.visibility ="hidden";//LINK 複数担当先所属部科別担当者別医師一覧
  </s:else>

  //ワクチンの場合
  //2014/12/19 条件設定を追加 参照する変数をjokenSetCd→selectedJgiJokenに変更
  <s:if test="%{trtGrpCd == @jp.co.takeda.jkr.util.JkrConstantsData@TRT_GRP_CD_003}">
    ishiPdf3.style.display ="none";//Ｐ担当者別市区郡軒数
    ishiPdf4.style.display ="inline";//担当者別重点先施設一覧,担当者別市区郡軒数(ワクチン)
    ishiPdf5.style.display ="none";//link ALL
  </s:if>
  <s:else>
    ishiPdf3.style.display ="inline";
    ishiPdf4.style.display ="none";
    ishiPdf5.style.display ="inline";
  </s:else>
}

/**
 * <pre>
 * 画面表示時のメッセージ表示処理
 * </pre>
 */
function showInit() {

  //ログインユーザ（代行ユーザ含む）が所属する組織の全データの中でステータスが「’６０’（適用完了）もしくは、’６1'（適用時エラー）」の適用日が一つでも存在する場合
  <s:if test="%{sosSelectDisableFlg == 1}">

    //支店の場合のみ、組織選択ボタンを非活性にする（営業所の場合はログイン組織以外の組織が選べるため、非活性にしない）
    <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_SITEN}">
    //「(組織)選択ボタン」「(組織（新）)選択ボタン」を非活性とする
    setSentaBtnStatus(true);
    </s:if>
    if (document.fm1.ShowBtn) {
      document.fm1.ShowBtn.disabled = true;
    }
  </s:if>

  //エラーメッセージを表示させる
  <s:if test="hasActionErrors()">
    var msg = '';
    <s:iterator value="actionErrors">
      msg = msg + '<s:property escape="false"/>' + '\n';
    </s:iterator>
    alert(msg);
  </s:if>

}

/**
 * <pre>
 * 「(組織)選択ボタン」「(組織（新）)選択ボタン」を活性・非活性とする
 * </pre>
 */
function setSentaBtnStatus(isDisabled) {
    if (document.fm1.butSel) {
      document.fm1.butSel.disabled = isDisabled;
    }
    if (document.fm1.butSel && document.fm1.butSel[0]) {
      document.fm1.butSel[0].disabled = isDisabled;
    }
    if (document.fm1.butSel && document.fm1.butSel[1]) {
      document.fm1.butSel[1].disabled = isDisabled;
    }
}

</script>
<body class="comPage" onLoad="jmnViewInit();comSetFormWindowName('JMN');jmnViewLoad();checkeiMr();showInit();"  onmousemove="resetTimer();">

<%-- submit用フォーム 開始 --%>
  <form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
    <input type="text" name="screenId"  value="" />
    <input type="text" name="functionId"    value="" />
    <input type="text" name="windowName"    value="" />
    <input type="text" name="openerName"    value="" />
    <input type="text" name="systemId1" value="" />
    <input type="text" name="backScreenId1" value="JKR000C010" />
    <input type="text" name="backFunctionId1"   value="" />
    <input type="text" name="backScreenName1"   value="" />
    <input type="text" name="backParamName1"    value="" />
    <input type="text" name="backParamValue1"   value="" />
    <input type="text" name="backParamName2"    value="" />
    <input type="text" name="backParamValue2"   value="" />
    <input type="text" name="fromScreenId1" value="" />
    <input type="text" name="fromFunctionId1"   value="" />

    <input type="text" name="jgiActUpSosCd"    value="<s:property value="jgiActUpSosCd"/>" />
    <input type="text" name="sosCdHairetu" value="<s:property value="sosCdHairetu"/>" />
    <s:hidden name="planSosCdHairetu"/>
    <input type="text" name="jgiActUmuFlg" value="<s:property value="jgiActUmuFlg"/>" />

    <input type="text" name="msgId1"    value="" />
    <input type="text" name="sosCd"    value="<s:property value="sosCd"/>"/>
    <input type="text" name="sosName1"  value="<s:property value="sosName"/>" />
    <input type="text" name="selectedSosCd"    value="" />
    <input type="text" name="selectedSosName"  value="" />
    <input type="text" name="wkCat"    value="" />
    <input type="text" name="dispSosName1"  value="" />
    <input type="text" name="jokenSetCd" value="<s:property value="jokenSetCd"/>" />
    <input type="text" name="insDevFlg1"    value="0" />
    <input type="text" name="docDevFlg1"    value="0" />
    <input type="text" name="report2"  value="" />
    <input type="text" name="report3"  value="" />
    <input type="text" name="report4"  value="" />
    <input type="text" name="report5"  value="" />
    <input type="text" name="report6"  value="" />
    <input type="text" name="subSystemId1"  value="3" />
    <input type="text" name="hoInsType1"    value="0" />
    <input type="text" name="searchInsChg1" value="0" />
    <input type="text" name="bumonRank"    value="<s:property value="bumonRank" />" />
    <input type="text" name="sosSelFlg"    value="<s:property value="sosSelFlg" />" />
    <input type="text" name="selectedPlanSosName"  value="" />
    <input type="hidden" name="gateFlg"           value="1" />

    <input type="text" name="selectFlg" value="" />
    <input type="text" name="topSosCd"  value="" />
    <input type="text" name="initSosCd" value="" />
    <input type="text" name="openBumonRank" value="" />
    <input type="text" name="objData"   value="" />
    <input type="text" name="dspSelPtn" value="" />
    <input type="text" name="dspSelSos" value="" />
    <input type="text" name="sosLevelType"  value="" />
    <input type="text" name="dispJgiKb" value="" />
    <input type="text" name="shokushuCd"    value="" />
    <input type="text" name="shokuseiCd"    value="" />
    <input type="text" name="noDispJgiKb"   value="" />
    <input type="text" name="noShokushuCd"  value="" />
    <input type="text" name="noShokuseiCd"  value="" />
    <input type="text" name="insNo1"    value="" />
    <input type="text" name="popupSelectSosCd"  value="" />

    <input type="text" name="no1"                value="1" />
    <%-- フレーム対応で発生したPOST用 引数1:frame(フレーム対応),以外(何もしない) 引数２:オブジェクトの型 --%>
    <%= AppMethods.getFramPostValue("normal","text") %>
    <input type="text" name="dummy"           value="dummy" />

    <input type="text" name="msgM0122704"    value="<s:property value="#session.UserInfoKey.msgMap.M0122704.msgData" />" />
    <input type="text" name="msgM0122705"    value="<s:property value="#session.UserInfoKey.msgMap.M0122705.msgData" />" />
    <input type="text" name="msgM0122723"    value="<s:property value="#session.UserInfoKey.msgMap.M0122723.msgData" />" />
    <input type="text" name="msgM0122724"    value="<s:property value="#session.UserInfoKey.msgMap.M0122724.msgData" />" />

  </form>
<%-- submit用フォーム 終了 --%>


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
            <!-- <a class="comBigMenuTitle"><font color="#808000" size="5"><b>施設・医師担当変更</b></font></a> -->
            <a class="comBigMenuTitle"><font color="#ffffff" size="5"><b>施設・医師担当変更</b></font></a>
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
        <s:hidden name="backScreenId" value="JKR000C010" />

        <s:hidden name="jgiActUpSosCd"/>
        <s:hidden name="sosCdHairetu"/>
        <s:hidden name="planSosCdHairetu"/>
        <s:hidden name="jgiActUmuFlg"/>
        <s:hidden name="msgId"/>
        <s:hidden name="sosCd"/>
        <s:hidden name="sosName"/>
        <s:hidden name="wkCat"/>
        <s:hidden name="trtGrpCd"/>
        <s:hidden name="dispSosName1"/>
        <s:hidden name="jokenSetCd"/>
        <s:hidden name="insDevFlg1"/>
        <s:hidden name="docDevFlg1"/>
        <s:hidden name="subSystemId"/>
        <s:hidden name="caseKbn"/>
        <s:hidden name="hoInsType"/>
        <s:hidden name="searchInsChg"/>
        <s:hidden name="bumonRank"/>
        <s:hidden name="sosSelFlg"/>

        <s:hidden name="selectFlg"/>
        <s:hidden name="topSosCd"/>
        <input type="hidden" name="initSosCd" value='<s:property value="selectedSosCd" />' />
        <s:hidden name="openBumonRank"/>
        <s:hidden name="objData"/>
        <s:hidden name="dspSelPtn"/>
        <s:hidden name="dspSelSos"/>
        <s:hidden name="sosLevelType"/>
        <s:hidden name="dispJgiKb"/>
        <s:hidden name="shokushuCd"/>
        <s:hidden name="shokuseiCd"/>
        <s:hidden name="noDispJgiKb"/>
        <s:hidden name="noShokushuCd"/>
        <s:hidden name="noShokuseiCd"/>
        <s:hidden name="insNo"/>
        <s:hidden name="popupSelectSosCd"/>
        <s:hidden name="tekiyoYmdUpdateFlg"/>
        <s:hidden name="tekiyoYmdUpdateFlg1"/>
        <s:hidden name="tekiyoYmdUpdateFlg2"/>

        <s:hidden name="docChgLinkFlg"/>

        <s:hidden name="selectedSosNm"/>
        <s:hidden name="selectedBumonRank"/>
        <s:hidden name="selectedJgiJoken"/>
        <s:hidden name="gateFlg" value="1"/>
        <s:hidden name="tekiyoYmd" value="%{#dateFormat3.format(jkrSosStsTableData.tekiyoYmd)}"/>
        <!-- 20180207 HISOL Kawamoto JKR-C-005 ADD START -->
        <s:hidden name="selectedTekiyoYmd" value="%{#dateFormat3.format(jkrSosStsTableData.tekiyoYmd)}"/>
        <!-- 20180207 HISOL Kawamoto JKR-C-005 ADD END -->
        <s:hidden name="selectedInsDispRngFlg"/>
        <s:hidden name="selectedSosTkyFlg"/>

        <!-- 組織選択のパラメータ設定START -->
        <input type="hidden" name="selectFlgPop" value="1" />    <!-- 選択区分:1（：組織選択） -->
        <input type="hidden" name="initSosCdPop" value="" />    <!-- 初期表示組織 -->
        <input type="hidden" name="sosKbnPop" value="" />       <!-- 組織区分 -->
        <input type="hidden" name="sknnFlgPop" value="0" />      <!-- "施設責任者フラグ" -->
        <input type="hidden" name="insFlgPop" value="0" />       <!-- "施設担当者フラグ" -->
        <input type="hidden" name="topMenuFlgPop" value="1" />   <!-- "トップメニューフラグ" -->
        <input type="hidden" name="authorityPop" value="" />    <!-- 権限 -->
        <input type="hidden" name="bumonRankTopPop" value="" />   <!-- 部門ランク(最上位) -->
        <input type="hidden" name="bumonRankBtmPop" value="" />    <!-- 部門ランク(最下位) -->
        <input type="hidden" name="topSosCdPop" value="" />    <!-- 最上位組織コード -->
        <input type="hidden" name="defTblFlgPop" value="" />    <!-- "定義テーブル使用フラグ" -->
        <input type="hidden" name="actSosListPop" value="<s:property value="sosCdHairetu" />" />    <!-- 代行組織リスト -->
        <input type="hidden" name="shokushuFlgPop" value="0" />    <!-- "職種指定フラグ" -->
        <input type="hidden" name="ztTntFlgPop" value="0" />    <!-- "雑担当者表示フラグ" -->
        <input type="hidden" name="jokenSetCdPop" value="" />    <!-- 条件セットコード -->
        <input type="hidden" name="menuTrtGrpCdPop" value="" />    <!-- "選択領域グループ(メニュー)" -->
        <input type="hidden" name="menuSosCdPop" value="" />    <!-- "選択組織(メニュー)" -->
        <input type="hidden" name="selectableBumonrankPop" value="" />    <!-- "選択可能部門ランク" -->
        <input type="hidden" name="insNoPop" value="" />    <!-- 施設固定コード -->
        <input type="hidden" name="trtCdPop" value="" />    <!-- 領域コード -->
        <input type="hidden" name="sosCdFromPop" value="" />    <!-- 現組織コード -->
        <input type="hidden" name="krJgiNoDispFlgPop" value="" />    <!-- 仮従業員非表示フラグ -->
        <!-- 20150202 HISOL Suzuki 本番課題No.25対応 ADD START -->
        <input type="hidden" name="sosCdToPop" value="" />    <!-- 新組織コード -->
        <input type="hidden" name="trtTntFlgPop" value="" />  <!-- 領域担当者フラグ -->
        <s:hidden name="searchFromSosCdPop"/>    <!-- 現組織コード(ポップアップ用) -->
        <s:hidden name="searchToSosCdPop"/>      <!-- 新組織コード(ポップアップ用) -->
        <!-- 20150202 HISOL Suzuki 本番課題No.25対応 ADD END -->
        <!-- 組織選択のパラメータ設定END -->

        <!-- 組織選択時の支店コード、名称格納 -->
        <s:hidden name="selectedSosCd2"/>
        <s:hidden name="selectedSosNm2"/>
        <!-- 組織選択時の営業所コード、名称格納 -->
        <s:hidden name="selectedSosCd3"/>
        <s:hidden name="selectedSosNm3"/>

        <!-- (各画面で変えられた)選択された組織情報格納（表示押下後） -->
        <s:hidden name="topChangedSosCd"  value=""/>
        <s:hidden name="topChangedSosNm"  value=""/>
        <s:hidden name="topChangedSosCd2" value=""/>
        <s:hidden name="topChangedSosNm2" value=""/>
        <s:hidden name="topChangedSosCd3" value=""/>
        <s:hidden name="topChangedSosNm3" value=""/>

<!-- 医師新規登録モック -->
        <s:hidden name="reqId"/>
        <s:hidden name="ultDocCd"/>

<!-- 業務選択エリア -->
          <!-- 営業所権限 -->
          <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_EIGYOU}"><!-- JKN0159 -->
            <s:if test="%{eigyouPldnList.size() == 1}">
              <s:textfield name="eigyouPldnName" value="%{eigyouPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" cssStyle="display:none;" />
              <s:hidden name="eigyouPldn" value="%{eigyouPldnList.get(0).trtGrpCd}"/>
            </s:if>
            <s:else>
              <s:select name="eigyouPldn" list="eigyouPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='changeRadio();'/>
            </s:else>
          </s:if>

          <!-- 支店権限 -->
          <s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_SITEN}">
          <!-- 支店権限 -->
            <table align="center" border="0" id="jobsel" width="81%">
              <tr>
                <td width="20%">&nbsp;
                </td>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_INS_CHG}">
                  <td width="40%" colspan="2"><input type="radio" name="catsel" onfocus="if (this.checked) is_same_clicked = true; else is_same_clicked = false;" onclick="changeRadioSiten()" id="catsel"  value="<%=JkrConstantsData.BUS_TYPE_INS_CHG%>" checked>支店業務：施設の営業所間移動(
                </s:if>
                <s:else>
                  <td width="40%" colspan="2"><input type="radio" name="catsel" onfocus="if (this.checked) is_same_clicked = true; else is_same_clicked = false;" onclick="changeRadioSiten()" id="catsel"  value="<%=JkrConstantsData.BUS_TYPE_INS_CHG%>">支店業務：施設の営業所間移動(
                </s:else>
                  <label>
                    <nobr>
                      <s:if test="%{sisetuPldnList.size() == 1}">
                        <s:textfield name="sisetuPldnName" value="%{sisetuPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="sisetuPldn" value="%{sisetuPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select id="sisetuPldn" list="sisetuPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][0].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>の担当変更)
                </td>
              </tr>
              <tr>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_SITEN || wkCat == ''}">
                  <td width="20%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) is_same_clicked = true; else is_same_clicked = false;" onclick="changeRadioSiten()" value="<%=JkrConstantsData.BUS_TYPE_SITEN%>" checked>支店業務(
                </s:if>
                <s:else>
                  <td width="20%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) is_same_clicked = true; else is_same_clicked = false;" onclick="changeRadioSiten()" value="<%=JkrConstantsData.BUS_TYPE_SITEN%>">支店業務(
                </s:else>
                  <label>
                    <nobr>
                      <%-- 支店権限者が支店権限のセレクトボックスを変更時は、指定されたMR種類を元に再表示を行う。 --%>
                      <s:if test="%{sitenPldnList.size() == 1}">
                        <s:textfield name="sitenPldnName" value="%{sitenPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="sitenPldn" value="%{sitenPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <%-- 20180227 HISOL Kawamoto JKR-C-005 MOD START --%>
                        <%-- s:select name="sitenPldn" list="sitenPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][1].checked){changeRadio();};'/ --%>
                        <s:select name="sitenPldn" list="sitenPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][1].checked){changeRadioSiten();};'/>
                        <%-- 20180227 HISOL Kawamoto JKR-C-005 MOD END --%>
                      </s:else>
                    </nobr>
                  </label>の担当変更)
                </td>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_EIGYOU}">
                  <td width="25%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) is_same_clicked = true; else is_same_clicked = false;" onclick="changeRadioSiten()" value="<%=JkrConstantsData.BUS_TYPE_EIGYOU%>" checked>営業所代行(
                </s:if>
                <s:else>
                  <td width="25%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) is_same_clicked = true; else is_same_clicked = false;" onclick="changeRadioSiten()" value="<%=JkrConstantsData.BUS_TYPE_EIGYOU%>">営業所代行(
                </s:else>
                  <label>
                    <nobr>
                      <s:if test="%{eigyouPldnList.size() == 1}">
                        <s:textfield name="eigyouPldnName" value="%{eigyouPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="eigyouPldn" value="%{eigyouPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select name="eigyouPldn" list="eigyouPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][2].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>の担当変更)
                </td>
                <td width="15%">&nbsp;&nbsp;
                <a href="" onclick="gotoTantoHenkoLink(1); return false;">
                変更・確定状況を確認するrdm1
                </a>
                </td>
              </tr>
            </table>
          </s:elseif>


          <!-- 本部権限（マーケ部） -->
          <s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_HONBU_COMMIT || jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_HONBU_NOCOMMIT}">
            <!-- 本部権限 -->
            <table align="center" border="0" id="jobsel" width="81%">
              <tr>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_HONBU || wkCat == ''}">
                  <td width="23%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_HONBU%>" checked>本部業務(
                </s:if>
                <s:else>
                  <td width="23%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_HONBU%>" >本部業務(
                </s:else>
                  <label>
                    <nobr>
                      <s:if test="%{honbuPldnList.size() == 1}">
                        <s:textfield name="honbuPldnName" value="%{honbuPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="honbuPldn" value="%{honbuPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select name="honbuPldn" list="honbuPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][0].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>の担当変更)
                </td>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_INS_CHG}">
                  <td width="30%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_INS_CHG%>" checked>本部業務(施設の支店･営業所間移動
                </s:if>
                <s:else>
                  <td width="30%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_INS_CHG%>">本部業務(施設の支店･営業所間移動
                </s:else>

                  <label>
                    <nobr>
                      <s:if test="%{sisetuPldnList.size() == 1}">
                        <s:textfield name="sisetuPldnName" value="%{sisetuPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="sisetuPldn" value="%{sisetuPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select name="sisetuPldn" list="sisetuPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][1].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>)
                </td>
                <td width="17%">&nbsp;&nbsp;
                </td>
              </tr>
              <tr>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_SITEN}">
                  <td width="20%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_SITEN%>" checked>支店代行(
                </s:if>
                <s:else>
                  <td width="20%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_SITEN%>">支店代行(
                </s:else>
                  <label>
                    <nobr>
                      <s:if test="%{sitenPldnList.size() == 1}">
                        <s:textfield name="sitenPldnName" value="%{sitenPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="sitenPldn" value="%{sitenPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select name="sitenPldn" list="sitenPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][2].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>の担当変更)
                </td>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_EIGYOU}">
                  <td width="25%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_EIGYOU%>" checked >営業所代行(
                </s:if>
                <s:else>
                  <td width="25%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_EIGYOU%>" >営業所代行(
                </s:else>
                  <label>
                    <nobr>
                      <s:if test="%{eigyouPldnList.size() == 1}">
                        <s:textfield name="eigyouPldnName" value="%{eigyouPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="eigyouPldn" value="%{eigyouPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select name="eigyouPldn" list="eigyouPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][3].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>
                の担当変更)
                </td>
                <td width="15%">&nbsp;&nbsp;
                <a href=""  value="<%=JkrConstantsData.BUS_TYPE_STS_CNF%>" onclick="gotoTantoHenkoLink(1); return false;">
                変更・確定状況を確認するrdm2
                </a>
                </td>
              </tr>
            </table>
          </s:elseif>

          <!-- 本部権限（ワクチンG） -->
          <s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_VACCINE}">
            <!-- ワクチンG権限 -->
            <table align="center" border="0" id="jobsel" width="81%">
              <tr>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_HONBU || wkCat == ''}">
                  <td width="20%">
                    <input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_HONBU%>" checked>本部業務(
                </s:if>
                <s:else>
                  <td width="20%">
                    <input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_HONBU%>" >本部業務(
                </s:else>

                  <label>
                    <nobr>
                      <s:if test="%{honbuPldnList.size() == 1}">
                        <s:textfield name="honbuPldnName" value="%{honbuPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="honbuPldn" value="%{honbuPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select name="honbuPldn" list="honbuPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][0].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>の担当変更)
                </td>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_INS_CHG}">
                  <td width="25%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_INS_CHG%>" checked>施設の担当組織変更(
                </s:if>
                <s:else>
                  <td width="25%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_INS_CHG%>" >施設の担当組織変更(
                </s:else>

                  <label>
                    <nobr>
                      <s:if test="%{sisetuPldnList.size() == 1}">
                        <s:textfield name="sisetuPldnName" value="%{sisetuPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="sisetuPldn" value="%{sisetuPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select name="sisetuPldn" list="sisetuPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][1].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>の担当変更)
                </td>
                <td width="15%">&nbsp;&nbsp;
                <a href="" name="catsel" id="catsel" onclick="gotoTantoHenkoLink(1); return false;">
                変更・確定状況を確認するrdm3
                </a>
                </td>
              </tr>
            </table>
          </s:elseif>

          <!-- 20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START -->
          <!-- ONC営業部スタッフ権限 -->
          <s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_ONC}">
            <table align="center" border="0" id="jobsel" width="81%">
              <tr>
                <td width="20%">&nbsp;
                </td>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_INS_CHG || wkCat == ''}">
                  <td width="40%" colspan="2"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_INS_CHG%>" checked>支店業務：施設の営業所間移動(
                </s:if>
                <s:else>
                  <td width="40%" colspan="2"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_INS_CHG%>">支店業務：施設の営業所間移動(
                </s:else>
                  <label>
                    <nobr>
                      <s:if test="%{sisetuPldnList.size() == 1}">
                        <s:textfield name="sisetuPldnName" value="%{sisetuPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="sisetuPldn" value="%{sisetuPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select id="sisetuPldn" list="sisetuPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][0].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>の担当変更)
                </td>
              </tr>
              <tr>
                <td width="20%">&nbsp;
                </td>
                <s:if test="%{wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_EIGYOU}">
                  <td width="25%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_EIGYOU%>" checked >営業所代行(
                </s:if>
                <s:else>
                  <td width="25%"><input type="radio" name="catsel" id="catsel" onfocus="if (this.checked) return false; changeRadio()" value="<%=JkrConstantsData.BUS_TYPE_EIGYOU%>" >営業所代行(
                </s:else>
                  <label>
                    <nobr>
                      <s:if test="%{eigyouPldnList.size() == 1}">
                        <s:textfield name="eigyouPldnName" value="%{eigyouPldnList.get(0).trtGrpNm}" cssClass="menuSelect" readonly="true" />
                        <s:hidden name="eigyouPldn" value="%{eigyouPldnList.get(0).trtGrpCd}"/>
                      </s:if>
                      <s:else>
                        <s:select name="eigyouPldn" list="eigyouPldnList" listKey="trtGrpCd" listValue="trtGrpNm" cssClass="menuSelect" onchange='if(fm1.elements["catsel"][3].checked){changeRadio();};'/>
                      </s:else>
                    </nobr>
                  </label>
                の担当変更)
                </td>
                <td width="15%">&nbsp;&nbsp;
                <a href=""  value="<%=JkrConstantsData.BUS_TYPE_STS_CNF%>" onclick="gotoTantoHenkoLink(1); return false;">
                変更・確定状況を確認するrdm4
                </a>
                </td>
              </tr>
            </table>
          </s:elseif>
          <!-- 20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END -->

          <s:else>
          //上記以外はありえない。（エラー画面遷移）
          </s:else>
          <hr class="comSplit" style="width:900px" id="jobselbar">



<!-- 業務選択エリア -->

<!-- 組織選択エリア -->
          <!-- 営業所権限 -->
          <s:if test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_EIGYOU}">
          <!-- 営業所権限 -->
            <table border="0" cellPadding="2" cellSpacing="0" width="520" align="center" id="sossel" >
              <tr>
                <td>
                  <table border="0">
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td style="width:50px"><nobr>組織&nbsp;</nobr></td>
                      <td style="width:250px">
                        <nobr>
                        <span id="sosButtonArea1">
                        <%-- 営業所権限(代行権限あり・なし)による組織従業員ポップアップ起動制御 --%>
                        <s:if test="sosCdHairetu != null && sosCdHairetu != ''">
                          <input id="sosButton1" class="comButton" type="button" name="butSel" value="選択" onClick="setSentakuParam();return jmnSearchSosCd();" />
                        </s:if>
                        </span>
                          <s:textfield id="sosText" name="selectedSosName" size="40" maxlength="40" cssStyle="background-color:#D4D0C8" readonly="true" />
                          <s:hidden id="selectedSosCd" name="selectedSosCd" />
                        </nobr>
                      </td>
                      <td id="sosBack" style="width:35px">&nbsp;</td>
                    </tr>

                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <s:if test="jkrSosStsTableData != null">
                      <td id="sosTekiyou1"><nobr>適用日</nobr></td>
                      <td id="sosTekiyou2">
                      <nobr>
                        <s:property value="%{#dateFormat0.format(jkrSosStsTableData.tekiyoYmd)}" />
                        <s:if test="%{#dateFormat1.format(jkrSosStsTableData.tekiyoYmd) != '01'}">
                        <font color="red"><b>※適用日が当月です。</b></font>
                        </s:if>
                      </nobr>
                      </td>
                      </s:if>
                      <s:else>
                      <td id="sosTekiyou1"></td>
                      <td id="sosTekiyou2"></td>
                      </s:else>
                      <td id="searchButton" align="left">
                      <%-- 2014年4月医薬組織変更・期末期首対応（従業員関連）--%>
                      <%//代行権限あり or ＯＮＣＧＭではない%>
                      <s:if test="(sosCdHairetu != null && sosCdHairetu != '')">
                        <input type="button" name="ShowBtn" value="表示" onClick="jmnView();return false;">
                      </s:if>
                      </td>
                    </tr>

                    <s:if test="jkrSosStsTableData != null && jkrSosStsTableData.btTekiyoChgFlg != 0">
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td id="sosTekiyou3" colspan="3">
                        <nobr><font color="red">別適用日の担当変更状況（CSV出力）</font>
                        <s:if test="jkrSosStsTableData.btTekiyoChgFlg == 1 || jkrSosStsTableData.btTekiyoChgFlg == 3">
                        &nbsp;
                        <a href="" onClick="downloadCsv('JKR000C010','DownloadInsTrtCsv'); return false;">
                          <b><i>施設・領域別</i></b>
                        </a>
                        </s:if>
                        <s:if test="jkrSosStsTableData.btTekiyoChgFlg == 2 || jkrSosStsTableData.btTekiyoChgFlg == 3">
                        &nbsp;
                        <a href="" onClick="downloadCsv('JKR000C010','DownloadDocTrtCsv'); return false;">
                          <b><i>医師・領域別</i></b>
                        </a>
                        </s:if>
                        </nobr>
                      </td>
                    </tr>
                    </s:if>

                  </table>

                  <s:if test="jkrSosStsTableData != null">
                  <div id="osirase" style="background-color:#faebd7; width:520px; height:90px; overflow-y:scroll; border-width:1px; border-style:solid; border-color:#808080;">
                  <table style="width:100%;" border="0">
                    <tr>
                      <td>
                      <s:if test="jkrSosStsTableData != null">
                        <s:property value="%{@jp.co.takeda.rdm.util.StringUtils@toMS932(jkrSosStsTableData.infData)}" escape="false"/>
                      </s:if>
                      </td>
                    </tr>
                  </table>
                  </div>
                  </s:if>
                  <s:else>
                  <div id="osirase"></div>
                  </s:else>
                </td>
              </tr>
            </table>
          </s:if>

          <!-- 支店権限 -->
          <s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_SITEN}">
          <!-- 支店権限 -->
            <table border="0" cellPadding="2" cellSpacing="0" width="520" align="center" id="sossel" >
              <tr>
                <td>
                  <table>
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td style="width:50px"><nobr>組織&nbsp;</nobr></td>
                      <td style="width:40px" id="sosButtonArea1">
                          <input id="sosButton" class="comButton" type="button" name="butSel" value="選択" onClick="setSentakuParam();return branchSosSel('fix');" />
                      </td>
                      <td style="width:210px" >
                          <s:textfield id="sosText" name="selectedSosName" size="40" maxlength="40" cssStyle="background-color:#D4D0C8" readonly="true"/>
                          <s:hidden id="selectedSosCd" name="selectedSosCd" />
                      </td>
                      <td id="sosBack" style="width:35px">&nbsp;</td>
                    </tr>

                    <!-- 新組織表示権限（新組織コード）を持っている場合 -->
                    <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td style="width:50px"><nobr>組織（新）</nobr></td>
                      <td style="width:40px" id="sosButtonAreaPlan">
                          <input id="sosButtonPlan" class="comButton" type="button" name="butSel" value="選択" onClick="setSentakuParamPlan();return branchSosSel('plan');" />
                      </td>
                      <td style="width:210px" >
                          <s:textfield id="planSosText" name="selectedPlanSosName" size="40" maxlength="40" cssStyle="background-color:#D4D0C8" readonly="true" />
                      </td>
                      <td id="sosBack" style="width:35px">&nbsp;</td>
                    </tr>
                    </s:if>
                    <s:else>
                    <tr>
                      <td style="width:65px"></td>
                      <td style="width:50px"></td>
                      <td style="width:40px" id="sosButtonAreaPlan"></td>
                      <td style="width:210px">
                        <s:hidden id="planSosText" name="selectedPlanSosName" maxlength="40" cssStyle="background-color:#D4D0C8" />
                      </td>
                    </tr>
                    </s:else>
                    <tr >
                      <td style="width:65px">&nbsp;</td>
                      <s:if test="jkrSosStsTableData != null">
                      <td id="sosTekiyou1"><nobr>適用日</nobr></td>
                      <td id="sosTekiyou2" colspan="2">
                      <nobr>
                        <s:property value="%{#dateFormat0.format(jkrSosStsTableData.tekiyoYmd)}" />
                        <s:if test="%{#dateFormat1.format(jkrSosStsTableData.tekiyoYmd) != '01'}">
                        <font color="red"><b>※適用日が当月です。</b></font>
                        </s:if>
                      </nobr>
                      </td>
                      </s:if>
                      <s:else>
                      <td id="sosTekiyou1"></td>
                      <td id="sosTekiyou2" colspan="2"></td>
                      </s:else>

                      <s:if test="%{#session.UserInfoKey.functionId != 'Init' && (wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_INS_CHG || wkCat == @jp.co.takeda.jkr.util.JkrConstantsData@BUS_TYPE_EIGYOU)}">
                      <td id="searchButton" align="left" >
                        <input type="button" name="ShowBtn" value="表示" onClick="jmnView();return false;">
                      </td>
                      </s:if>
                      <s:else>
                      <td id="searchButton" align="left" style="display:none;">
                        <input type="button" name="ShowBtn" value="表示" onClick="jmnView();return false;">
                      </td>
                      </s:else>
                    </tr>

                    <s:if test="jkrSosStsTableData != null && jkrSosStsTableData.btTekiyoChgFlg != 0">
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td id="sosTekiyou3" colspan="3">
                        <nobr><font color="red">別適用日の担当変更状況（CSV出力）</font>
                        <s:if test="jkrSosStsTableData.btTekiyoChgFlg == 1 || jkrSosStsTableData.btTekiyoChgFlg == 3">
                        &nbsp;
                        <a href="" onClick="downloadCsv('JKR000C010','DownloadInsTrtCsv'); return false;">
                          <b><i>施設・領域別</i></b>
                        </a>
                        </s:if>
                        <s:if test="jkrSosStsTableData.btTekiyoChgFlg == 2 || jkrSosStsTableData.btTekiyoChgFlg == 3">
                        &nbsp;
                        <a href="" onClick="downloadCsv('JKR000C010','DownloadDocTrtCsv'); return false;">
                          <b><i>医師・領域別</i></b>
                        </a>
                        </s:if>
                        </nobr>
                      </td>
                    </tr>
                    </s:if>
                  </table>

                  <% //新組織表示権限（新組織コード）を持っている場合%>
                  <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
                  <table>
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td>
                      <font color="red">
                        ＜注意＞<br>
                        　新組織の【変更内容チェック】を実施する場合は、関連する組織で、<br>
                        　現在担当変更の作業中でないことを確認して下さい。
                      </font>
                      <td>
                    </tr>
                  </table>
                  </s:if>

                  <s:if test="jkrSosStsTableData != null">
                  <div id="osirase" style="background-color:#faebd7; width:520px; height:90px; overflow-y:scroll; border-width:1px; border-style:solid; border-color:#808080;">
                  <table style="width:100%;" border="0">
                    <tr>
                      <td>
                        <s:property value="%{@jp.co.takeda.rdm.util.StringUtils@toMS932(jkrSosStsTableData.infData)}" escape="false"/>
                      </td>
                    </tr>
                  </table>
                  </div>
                  </s:if>
                  <s:else>
                  <div id="osirase"></div>
                  </s:else>

                </td>
              </tr>
            </table>
          </s:elseif>

          <!-- 本部権限（マーケ部） -->
          <s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_HONBU_COMMIT || jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_HONBU_NOCOMMIT}">
          <!-- 本部権限 -->
            <table border="0" cellPadding="2" cellSpacing="0" width="520" align="center" id="sossel" >
              <tr>
                <td>
                  <table>
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td style="width:50px"><nobr>組織&nbsp;</nobr></td>
                      <td style="width:250px">
                        <nobr>
                          <input id="sosButton" class="comButton" type="button" name="butSel" value="選択" onClick="setSentakuParam();return jmnSearchSosCd();" />
                          <s:textfield id="sosText" name="selectedSosName" size="40" maxlength="40" cssStyle="background-color:#D4D0C8" readonly="true" />
                          <s:hidden id="selectedSosCd" name="selectedSosCd" />
                        </nobr>
                      </td>
                      <td>
                        <nobr>
                          &nbsp;<a href="" class="comMiniLink" onClick="javascript:clearValue('fix');return false;">clear</a>
                        </nobr>
                      </td>
                      <td id="sosBack" style="width:35px">&nbsp;</td>
                    </tr>

                    <% //新組織表示権限（新組織コード）を持っている場合%>
                    <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td style="width:50px"><nobr>組織（新）</nobr></td>
                      <td style="width:250px">
                        <nobr>
                          <input id="sosButtonPlan" class="comButton" type="button" name="butSel" value="選択" onClick="setSentakuParamPlan();return jmnSearchSosCd();" />
                          <s:textfield id="planSosText" name="selectedPlanSosName" size="40" maxlength="40" cssStyle="background-color:#D4D0C8" readonly="true" />
                        </nobr>
                      </td>
                      <td>
                        <nobr>
                          &nbsp;<a href="" class="comMiniLink" onClick="javascript:clearValue('plan');return false;">clear</a>
                          </nobr>
                      </td>
                      <td id="sosBack" style="width:35px">&nbsp;</td>
                    </tr>
                    </s:if>
                    <s:else>
                    <tr>
                      <td style="width:65px"></td>
                      <td style="width:50px"></td>
                      <td style="width:40px" id="sosButtonAreaPlan"></td>
                      <td style="width:210px">
                        <s:hidden id="planSosText" name="selectedPlanSosName" maxlength="40" cssStyle="background-color:#D4D0C8" />
                      </td>
                    </tr>
                    </s:else>

                    <tr >
                      <td style="width:65px">&nbsp;</td>
                      <!-- （本部権限（マーケ部）かつViewInitの場合）非表示-->
                      <s:if test="jkrSosStsTableData != null">
                      <td id="sosTekiyou1"><nobr>適用日</nobr></td>
                      <td id="sosTekiyou2">
                      <nobr>
                        <s:property value="%{#dateFormat0.format(jkrSosStsTableData.tekiyoYmd)}" />
                        <s:if test="%{#dateFormat1.format(jkrSosStsTableData.tekiyoYmd) != '01'}">
                        <font color="red"><b>※適用日が当月です。</b></font>
                        </s:if>
                      </nobr>
                      </td>
                      </s:if>
                      <s:else>
                      <td id="sosTekiyou1"></td>
                      <td id="sosTekiyou2"></td>
                      </s:else>

                      <td id="searchButton" align="right">
                        <input type="button" name="ShowBtn" value="表示" onClick="jmnView();return false;">
                      </td>
                    </tr>

                    <s:if test="jkrSosStsTableData != null && jkrSosStsTableData.btTekiyoChgFlg != 0">
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td id="sosTekiyou3" colspan="3">
                        <nobr><font color="red">別適用日の担当変更状況（CSV出力）</font>
                        <s:if test="jkrSosStsTableData.btTekiyoChgFlg == 1 || jkrSosStsTableData.btTekiyoChgFlg == 3">
                        &nbsp;
                        <a href="" onClick="downloadCsv('JKR000C010','DownloadInsTrtCsv'); return false;">
                          <b><i>施設・領域別</i></b>
                        </a>
                        </s:if>
                        <s:if test="jkrSosStsTableData.btTekiyoChgFlg == 2 || jkrSosStsTableData.btTekiyoChgFlg == 3">
                        &nbsp;
                        <a href="" onClick="downloadCsv('JKR000C010','DownloadDocTrtCsv'); return false;">
                          <b><i>医師・領域別</i></b>
                        </a>
                        </s:if>
                        </nobr>
                      </td>
                    </tr>
                    </s:if>
                  </table>

                  <% //新組織表示権限（新組織コード）を持っている場合%>
                  <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
                  <table>
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td>
                      <font color="red">
                        ＜注意＞<br>
                        　新組織の【変更内容チェック】を実施する場合は、関連する組織で、<br>
                        　現在担当変更の作業中でないことを確認して下さい。
                      </font>
                      <td>
                    </tr>
                  </table>
                  </s:if>

                  <s:if test="jkrSosStsTableData != null">
                  <div id="osirase" style="background-color:#faebd7; width:520px; height:90px; overflow-y:scroll; border-width:1px; border-style:solid; border-color:#808080;">
                  <table style="width:100%;" border="0">
                    <tr>
                      <td>
                        <s:property value="%{@jp.co.takeda.rdm.util.StringUtils@toMS932(jkrSosStsTableData.infData)}" escape="false"/>
                      </td>
                    </tr>
                  </table>
                  </div>
                  </s:if>
                  <s:else>
                  <div id="osirase"></div>
                  </s:else>

                </td>
              </tr>
            </table>
          </s:elseif>


          <!-- 20150224 HISOL Suzuki 期末期首 組織変更対応 UPD START -->
          <!-- -- 本部権限（ワクチンG） -- -->
          <!-- s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_VACCINE}" -- JKN0161 -- -->
          <!-- -- ワクチンG権限 -- -->
          <!-- 本部権限（ワクチンG） および ONC営業部スタッフ権限 -->
          <s:elseif test="%{jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_VACCINE || jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_ONC}"><!-- JKN0161、JKN0349 -->
          <!-- 20150224 HISOL Suzuki 期末期首 組織変更対応 UPD END -->
            <table border="0" cellPadding="2" cellSpacing="0" width="520" align="center" id="sossel" >
              <tr>
                <td>
                  <table>
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td style="width:50px"><nobr>組織&nbsp;</nobr></td>
                      <td style="width:250px">
                        <nobr>
                          <input id="sosButton" class="comButton" type="button" name="butSel" value="選択" onClick="setSentakuParam();return jmnSearchSosCd();" />
                          <s:textfield id="sosText" name="selectedSosName" size="40" maxlength="40" cssStyle="background-color:#D4D0C8" readonly="true"/>
                          <s:hidden id="selectedSosCd" name="selectedSosCd" />
                        </nobr>
                      </td>
                      <td>
                        <nobr>
                          &nbsp;<a href="" class="comMiniLink" onClick="javascript:clearValue('fix');return false;">clear</a>
                        </nobr>
                      </td>
                      <td id="sosBack" style="width:35px">&nbsp;</td>
                    </tr>

                    <!-- //新組織表示権限（新組織コード）を持っている場合 -->
                    <s:if test="planSosCdHairetu != null && planSosCdHairetu != ''">
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td style="width:60px"><nobr>組織（新）</nobr></td>
                      <td style="width:250px">
                        <nobr>
                          <input id="sosButtonPlan" class="comButton" type="button" name="butSel" value="選択" onClick="setSentakuParamPlan();return jmnSearchSosCd();" />
                          <s:textfield id="planSosText" name="selectedPlanSosName" size="40" maxlength="40" cssStyle="background-color:#D4D0C8" readonly="true" />
                        </nobr>
                      </td>
                      <td>
                        <nobr>
                        &nbsp;<a href="" class="comMiniLink" onClick="javascript:clearValue('plan');return false;">clear</a>
                        </nobr>
                      </td>
                      <td id="sosBack" style="width:35px">&nbsp;</td>
                    </tr>
                    </s:if>
                    <s:else>
                    <tr>
                      <td style="width:65px;"></td>
                      <td style="width:50px"></td>
                      <td style="width:40px" id="sosButtonAreaPlan"></td>
                      <td style="width:210px">
                        <s:hidden id="planSosText" name="selectedPlanSosName" maxlength="40" cssStyle="background-color:#D4D0C8" />
                      </td>
                      <td></td>
                    </tr>
                    </s:else>

                    <tr >
                      <td style="width:65px">&nbsp;</td>
                      <!--// （本部権限（ワクチン）かつViewInitの場合）非表示-->
                      <s:if test="jkrSosStsTableData != null">
                      <td id="sosTekiyou1"><nobr>適用日</nobr></td>
                      <td id="sosTekiyou2">
                      <nobr>
                        <s:property value="%{#dateFormat0.format(jkrSosStsTableData.tekiyoYmd)}" />
                        <s:if test="%{#dateFormat1.format(jkrSosStsTableData.tekiyoYmd) != '01'}">
                        <font color="red"><b>※適用日が当月です。</b></font>
                        </s:if>
                      </nobr>
                      </td>
                      </s:if>
                      <s:else>
                      <td id="sosTekiyou1"></td>
                      <td id="sosTekiyou2"></td>
                      </s:else>

                      <td id="searchButton" align="left">
                        <input type="button" name="ShowBtn" value="表示" onClick="jmnView();return false;">
                      </td>
                    </tr>

                    <s:if test="jkrSosStsTableData != null && jkrSosStsTableData.btTekiyoChgFlg != 0">
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td id="sosTekiyou3" colspan="3">
                        <nobr><font color="red">別適用日の担当変更状況（CSV出力）</font>
                        <s:if test="jkrSosStsTableData.btTekiyoChgFlg == 1 || jkrSosStsTableData.btTekiyoChgFlg == 3">
                        &nbsp;
                        <a href="" onClick="downloadCsv('JKR000C010','DownloadInsTrtCsv'); return false;">
                          <b><i>施設・領域別</i></b>
                        </a>
                        </s:if>
                        <s:if test="jkrSosStsTableData.btTekiyoChgFlg == 2 || jkrSosStsTableData.btTekiyoChgFlg == 3">
                        &nbsp;
                        <a href="" onClick="downloadCsv('JKR000C010','DownloadDocTrtCsv'); return false;">
                          <b><i>医師・領域別</i></b>
                        </a>
                        </s:if>
                        </nobr>
                      </td>
                    </tr>
                    </s:if>
                  </table>

                  <%-- 新組織対応 --%>
                  <%-- //新組織表示権限（新組織コード）を持っている場合--%>
                  <s:if test="%{planSosCdHairetu != null && planSosCdHairetu != ''}">
                  <table>
                    <tr>
                      <td style="width:65px">&nbsp;</td>
                      <td>
                      <font color="red">
                        ＜注意＞<br>
                        　新組織の【変更内容チェック】を実施する場合は、関連する組織で、<br>
                        　現在担当変更の作業中でないことを確認して下さい。
                      </font>
                      <td>
                    </tr>
                  </table>
                  </s:if>
                  <%-- 新組織対応 --%>

                  <!-- （本部権限（ワクチン）かつViewInitの場合）非表示-->
                  <s:if test="jkrSosStsTableData != null">
                  <div id="osirase" style="background-color:#faebd7; width:520px; height:90px; overflow-y:scroll; border-width:1px; border-style:solid; border-color:#808080;">
                  <table style="width:100%;" border="0">
                    <tr>
                      <td>
                      <s:if test="jkrSosStsTableData != null">
                        <s:property value="%{@jp.co.takeda.rdm.util.StringUtils@toMS932(jkrSosStsTableData.infData)}" escape="false"/>
                      </s:if>
                      </td>
                    </tr>
                  </table>
                  </div>
                  </s:if>
                  <s:else>
                  <div id="osirase"></div>
                  </s:else>

                </td>
              </tr>
            </table>
          </s:elseif>

          <s:else>
          //上記以外はありえない。（エラー画面遷移）
          </s:else>


        <hr class="comSplit" style="width:900px">



    <s:if test="jkrSosStsTableData != null">
    <%//SOS_STSテーブルに組織コードが無ければ以下表示しない。%>
<!-- 処理エリア -->
<!-- 【１】 -->
        <table id="menuBox01" border="0" cellPadding="2" cellSpacing="0" style="width:900px" align="center">
          <tr>
            <td style="width:20px; text-align:left">
              <a href="" id="menuIcon01" class="titleIcon" onclick="openMenu('01'); return false;">＋</a>
            </td>
            <td style="border-width:0px 0px 2px 0px; border-style:solid; border-color:#808000;">
              <a href="" class="titleLink" onclick="openMenu('01'); return false;">
              【１】担当変更の処理
              </a>
            </td>
          </tr>
          <tr id="menuHead01" style="display:inline;">
            <td>&nbsp;</td>
            <td class="titleLeter">
              施設の担当及び複数担当先の医師の担当変更を入力します。<br>
              【５】の確定処理を実施するまでは、変更入力が可能です。<br>
              　　　現在の部署のＭＲ間、転入者を伴うＭＲ間での担当変更を行います。
            </td>
          </tr>
          <tr id="menuBody01" style="display:none;">
            <td>&nbsp;</td>
            <td>
              <table>
                <tr>
                  <td class="contentsBox" style="width:430px;">
                    <a href="" class="contentsTitle" onclick="gotoNext('JKR010C010','Init'); return false;">従業員の確認・仮登録を行います</a>
                    <div class="contentsLetter" style="padding-left:10px">
                      異動・退職・転入者の確認をします。<br>
                      適用日付の従業員情報が表示されるのは、通常23日前後です。<br>
                      転入者が画面に表示される前（通常23日前後）に<br>
                      作業を開始する場合は、転入者の仮登録が必要です。
                    </div>
                  </td>
                  <td>&nbsp;</td>
                  <td class="contentsBox" style="width:360px">
                    <a href="" class="contentsTitle" onclick="gotoNext('JKR010C010','Init'); return false;">仮登録従業員を転入者へ接続（振替）します</a>
                    <div class="contentsLetter" style="padding-left:10px">
                      仮登録をした従業員が存在しているときには、<br>
                      適用日付の従業員情報が表示（通常23日前後）以降、<br>
                      転入者へ接続（振替）作業が必要です。
                    </div>
                  </td>
                </tr>
              </table>
              <table>
                <tr>
                  <td style="padding-left:160px">
                    <img src="img/downarrow.gif">
                  </td>
                  <td style="padding-left:110px;">
                    <img src="img/doublearrow.gif">
                  </td>
                </tr>
              </table>
              <div style="width:97%; height:250px; border-width:1px; border-style:solid; border-color:#808080;">
              <table>
                <tr>
                  <td style="width:100%; padding:5px 0px 18px 60px; font-size:16px; font-weight:bold;">
                    施設及び複数担当先の医師の担当変更を入力します。<br>
                    『担当変更のケース別に変更画面を表示します』からもご利用ください。
                  </td>
                </tr>
              </table>
              <table>
                <tr>
                  <td style="width:300px; border-width:1px;, border-style:solid; border-color:#808080; text-align:center;">
                    <table>
                      <tr>
                        <td class="contentsHeader" style="width:210px; top:-15px; position:relative;">
                          直接 変更画面から変更します
                        </td>
                      </tr>
                    </table>
                    <table style="top:-10px; position:relative;">
                      <tr>
                        <td class="contentsBox" style="width:250px">
                          <a href="" onclick="gotoNext('JKR030C010','Init'); return false;" class="contentsTitle">担当引継ぎ</a>
                          <div class="contentsLetter">
                            <%-- 営業所MRの場合 --%>
                            <s:set id="mrCatCheck2" value="jokenSetCd == @jp.co.takeda.rdm.util.RdmConstantsData@RDM_JKN_EIGYOU"/><!-- 営業所権限JKN0159 -->
                            <s:if test="#mrCatCheck2">
                              現担当者から転入者または<br>
                              営業所内の担当者へ施設・医師<br>
                              の担当を全て引き継ぐ場合
                            </s:if>
                            <%-- 専門MR(営業所MR以外)の場合 --%>
                            <s:else>
                              現担当者から転入者または<br>
                              組織内の担当者へ施設<br>
                              の担当を全て引き継ぐ場合
                            </s:else>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td class="contentsBox">
                          <a href="" class="contentsTitle" onclick="gotoNext('JKR040C010','Init'); document.fm1.caseKbn.value='0';document.fm1.searchInsChg.value='';document.fm1.hoInsType.value=''; return false;">施設別・地区別（施設）担当変更</a>
                          <div class="contentsLetter">
                            地区別または施設別に担当変更<br>
                            を行います。<s:property value="#ishiExitMes"/><br>
                            　単独先の担当変更<br>
                            　単独先⇔複数担当先<br>
                            　複数担当先の担当変更
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td id="ishi" class="contentsBox">
                          <a href="" class="contentsTitle" onclick="gotoNext('JKR050C010','Init'); return false;">複数担当先施設の<br><span style="padding-left:40px;">医師担当変更の処理</span></a>
                          <div class="contentsLetter">
                            複数担当先の医師の担当変更<br>
                            　・所属部科別担当変更<br>
                            　・所属部科内の医師の担当変更<br>
                            　・医師の担当変更
                          </div>
                        </td>
                      </tr>
                    </table>
                  </td>
                  <td style="width:20px;">&nbsp;</td>
                  <td style="width:530px; text-align:center; vertical-align:top;">
                    <table style="padding-top:40px;">
                      <tr>
                        <td class="contentsHeader" style="width:350px;">
                          担当変更のケース別に変更画面を表示します
                        </td>
                      </tr>
                    </table>
                    <table>
                      <tr>
                        <td>
                          <fieldset style="width:530px; padding:5px 7px 10px 7px;">
                            <legend style="margin-bottom:5px;">どのような担当変更を行いますか？</legend>
                            <input id="mod01" type="radio" name="mod" checked>
                            <label for="mod01">現担当者の全ての施設・医師を別の担当者へ変更する</label><br>
                            <input id="mod02" type="radio" name="mod">
                            <label for="mod02">営業所の市区郡別に担当者を変更する（営業所はP対象のみ）</label><br>
                            <input id="mod03" type="radio" name="mod">
                            <label for="mod03">現担当者の一部の市区郡を別の担当者へ変更する。</label><br>
                            <input id="mod04" type="radio" name="mod">
                            <label for="mod04">現担当者の一部の施設を別の担当者へ変更する</label><br>
                            <input id="mod05" type="radio" name="mod">
                            <label for="mod05">単独先の施設を複数担当先へ変更する</label><br>
                            <input id="mod06" type="radio" name="mod">
                            <label for="mod06">複数担当先の施設を単独先へ変更する(医師も含む)</label><br>
                            <input id="mod07" type="radio" name="mod">
                            <label for="mod07">複数担当先の施設の主担当を変更する</label><br>
                            <input id="mod08" type="radio" name="mod">
                            <label for="mod08">複数担当先の施設の副担当を変更する（副担当の増員・減員を含む）</label><br>
                            <div id="ishiRadio">
                              <span style="border-color:blue; border-width:1px; border-top-style:dotted; border-bottom-style:dotted; width:100%; margin:2px 0px 1px 0px;">
                              <input id="mod09" type="radio" name="mod">
                              <label for="mod09">複数担当先の施設内の医師の担当を変更する</label><br>
                              <input id="mod10" type="radio" name="mod">
                              <label for="mod10">複数担当先の施設内の所属部科の担当を変更する</label>
                              </span><br>
                            </div>
                            <table  align="right"><tr><td><input type="button" value="変更画面へ" onclick="gotoHenkoGamen('<s:property value="jokenSetCd"/>'); return false;"></td></tr></table>
                            <br>
                            <table  align="center"><tr>

                            <td><a  href="jgikanrenHelp.html" target="_blank" >上記以外の担当変更を行う（操作説明画面を表示します）</a></td></tr></table>
                          </fieldset>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
              </div>
            </td>
          </tr>
        </table>
        <br>

<!-- 【２】 -->
        <s:if test="%{jkrSosStsTableData.status == @jp.co.takeda.jkr.util.JkrConstantsData@STS_CHECKING}"><!-- 30 -->
        <%//状況区分が『チェック中』の場合%>

          <table id="menuBox02" border="0" cellPadding="2" cellSpacing="0" style="width:900px;" align="center">
          <tr>
            <td style="width:20px; text-align:left">&nbsp;</td>
            <td style="border-width:0px 0px 2px 0px; border-style:solid; border-color:#808000;">
              <nobr>
              <font class="titleLinkNew">
              【２】担当変更入力後の確認
              </font>
              <input type="button" value="変更内容をチェック" style="width:80pt;" onClick="" disabled>
              <!-- 特別ロジック -->
              <s:if test="%{#dateFormat2.format(jkrSosStsTableData.checkDate) != '1970/01/01 09:00:00'}">
                最終ﾁｪｯｸ日時：<s:property value="%{#dateFormat2.format(jkrSosStsTableData.checkDate)}"/>
              </s:if>
              </nobr>
            </td>
          </tr>
          <tr id="menuHead02" style="display:inline;">
            <td>&nbsp;</td>
            <td class="titleLeter">
              【１】で入力している担当変更の内容にエラーが発生していないかを確認します。
            </td>
          </tr>
          <tr>
            <td style="width:20px; text-align:left">&nbsp;</td>
            <td  style="border-width:2px 2px 2px 2px; border-style:solid; border-color:red;">
              <table>
                <tr>
                  <td colspan="3"><span id="BlinkArea"><font color="red">只今変更内容をチェック中です。！！</font></span></td>
                </tr>
              </table>
            </td>
          </tr>
          </table>
          <div id="ishiErr"></div>
        </s:if>

        <s:elseif test="%{jkrSosStsTableData.status == @jp.co.takeda.jkr.util.JkrConstantsData@STS_COMMIT_NOERR || jkrSosStsTableData.status == @jp.co.takeda.jkr.util.JkrConstantsData@STS_COMMIT_ERR}"><!-- 60,61 -->
        <%//状況区分が『適用完了（エラーなし）』、『適用完了（エラーあり）』のどちらかの場合%>
          <table id="menuBox02" border="0" cellPadding="2" cellSpacing="0" style="width:900px;" align="center">
          <tr>
            <td style="width:20px; text-align:left">&nbsp;</td>
            <td style="border-width:0px 0px 2px 0px; border-style:solid; border-color:#808000;">
              <nobr>
              <font class="titleLinkNew">
              【２】担当変更入力後の確認
              </font>
              <input type="button" value="変更内容をチェック" style="width:80pt;" onClick="" disabled>
              <!-- 特別ロジック -->
              <s:if test="%{#dateFormat2.format(jkrSosStsTableData.checkDate) != '1970/01/01 09:00:00'}">
                最終ﾁｪｯｸ日時：<s:property value="%{#dateFormat2.format(jkrSosStsTableData.checkDate)}"/>
              </s:if>
              </nobr>
            </td>
          </tr>
          <tr id="menuHead02" style="display:inline;">
            <td>&nbsp;</td>
            <td class="titleLeter">
              【１】で入力している担当変更の内容にエラーが発生していないかを確認します。
            </td>
          </tr>
          <tr>
            <td style="width:20px; text-align:left">&nbsp;</td>
            <td  style="border-width:2px 2px 2px 2px; border-style:solid; border-color:red;">
              <table>
                <tr>
                  <td colspan="3"><font color="red">適用完了しました。！！</font></td>
                </tr>
              </table>
            </td>
          </tr>
          </table>
          <div id="ishiErr"></div>
        </s:elseif>

        <s:else>
        <%//状況区分が上記以外の場合%>
          <table id="menuBox02" border="0" cellPadding="2" cellSpacing="0" style="width:900px;" align="center">
          <tr>
            <td style="width:20px; text-align:left">&nbsp;</td>
            <td style="border-width:0px 0px 2px 0px; border-style:solid; border-color:#808000;">
              <nobr>
              <font class="titleLinkNew">
              【２】担当変更入力後の確認
              </font>
              <s:set id="statusCheck1" value="jkrSosStsTableData.status == @jp.co.takeda.jkr.util.JkrConstantsData@STS_IDO"/>
              <s:set id="statusCheck2" value="jkrSosStsTableData.status == @jp.co.takeda.jkr.util.JkrConstantsData@STS_CHANGING"/>
              <s:set id="statusCheck3" value="jkrSosStsTableData.status == @jp.co.takeda.jkr.util.JkrConstantsData@STS_CHK_NOERR"/>
              <s:set id="statusCheck4" value="jkrSosStsTableData.status == @jp.co.takeda.jkr.util.JkrConstantsData@STS_CHK_ERR"/>

              <s:set id="jgiStsCheck1" value="jkrSosStsTableData.jgiSts == @jp.co.takeda.jkr.util.JkrConstantsData@JGI_STS_APP"/>
              <s:set id="jgiStsCheck2" value="jkrSosStsTableData.jgiSts == @jp.co.takeda.jkr.util.JkrConstantsData@JGI_STS_NOIDO"/>

              <s:if test="(#statusCheck1 || #statusCheck2 || #statusCheck3 || #statusCheck4) && (#jgiStsCheck1 || #jgiStsCheck2)">
              <input type="button" value="変更内容をチェック" style="width:80pt;" onClick="execConfirm('check');" >
              </s:if>
              <s:else>
              <input type="button" value="変更内容をチェック" style="width:80pt;" onClick="" disabled>
              </s:else>
              <!-- 特別ロジック -->
              <s:if test="%{#dateFormat2.format(jkrSosStsTableData.checkDate) != '1970/01/01 09:00:00'}">
                最終ﾁｪｯｸ日時：<s:property value="%{#dateFormat2.format(jkrSosStsTableData.checkDate)}"/>
              </s:if>
              </nobr>
            </td>
          </tr>
          <tr id="menuHead02" style="display:inline;">
            <td>&nbsp;</td>
            <td class="titleLeter">
              【１】で入力している担当変更の内容にエラーが発生していないかを確認します。
            </td>
          </tr>

          <s:if test="%{jkrSosStsTableData.chgTntMrErrCnt != 0 || jkrSosStsTableData.chgMrInsTrtErrCnt != 0 || jkrSosStsTableData.chgMrInsDocTrtErrCnt != 0}">
          <tr>
            <td style="width:20px; text-align:left">&nbsp;</td>
            <td style="border-width:2px 2px 2px 2px; border-style:solid; border-color:red;">
              <table>
                <tr>
                  <td colspan="3"><font color="red">！エラーまたは確認する内容があります！</font></td>
                </tr>
                <s:if test="%{jkrSosStsTableData.chgTntMrErrCnt != 0}">
                <tr>
                  <td >
                    <a style="width:160px;" class="comLink" href="" onClick="gotoNext('JKR030C020','Init'); return false;">
                      担当引継ぎ　<s:property value="jkrSosStsTableData.chgTntMrErrCnt"/>件
                    </a>
                  </td>
                </s:if>

                <s:if test="%{jkrSosStsTableData.chgMrInsTrtErrCnt != 0}">
                  <td >
                    <a style="width:170px;" class="comLink" href="" onclick="gotoNext('JKR040C040','Search'); return false;">
                      施設別担当変更　<s:property value="jkrSosStsTableData.chgMrInsTrtErrCnt"/>件
                  </a></td>
                </s:if>

                  <td id="ishiErr">
                  <s:if test="%{jkrSosStsTableData.chgMrInsDocTrtErrCnt != 0}">
                    <a style="width:170px;" class="comLink" href="" onClick="gotoNext('JKR050C030','Search'); return false;">
                      医師別担当変更　<s:property value="jkrSosStsTableData.chgMrInsDocTrtErrCnt"/>件
                    </a>
                  </s:if>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          </s:if>
          <s:else>
            <div id="ishiErr"></div>
          </s:else>

          </table>
        </s:else>

          <br>
<!-- 【３】 -->
          <table id="menuBox03" border="0" cellPadding="2" cellSpacing="0" style="width:900px" align="center">
            <tr>
              <td style="width:20px; text-align:left">
                <a href="" id="menuIcon03" class="titleIcon" onclick="openMenu('03'); return false;">＋</a>
              </td>
              <td style="border-width:0px 0px 2px 0px; border-style:solid; border-color:#808000;">
                <a href="" class="titleLink" onclick="openMenu('03'); return false;;">
                【３】確認リストの作成依頼
                </a>
              </td>
            </tr>
            <tr id="menuHead03" style="display:inline;">
              <td>&nbsp;</td>
              <td class="titleLeter">
                【１】で入力している担当変更確認リストの出力、担当シミュレーションが行えます。<br>
                ※現状の担当リストや担当シミュレーションも行えます。
              </td>
            </tr>
            <tr id="menuBody03" style="display:none;">
              <td>&nbsp;</td>
              <td>
                <table>
                  <tr>
                    <td class="titleLeter">
                      担当変更入力後の確認リストの作成依頼を行います。<br>
                      必要な確認リストを依頼し、【４】帳票出力で依頼したいリストを出力して下さい。
                    </td>
                  </tr>
                </table>
                <table >
                  <tr>
                    <td bgcolor="#ffffac" style="border-width:1px;border-style:solid; border-color:#808080;">
                      依頼画面
                    </td>
                  </tr>
                </table>
                <table style="margin-top:10px;">
                  <tr>
                    <td style="width:400px; border-width:1px; border-style:solid; border-color:#808080; text-align:center;">
                      <table>
                        <tr>
                          <td class="contentsHeader" style="width:300px; top:-15px; position:relative;">
                            作成したい確認リストを選択して下さい
                          </td>
                        </tr>
                      </table>
                      <table style="top:-10px; position:relative;">
                        <tr>
                          <td class="contentsBox2" style="width:400px">
                            <div id="ishiPdf3">
                            <input type="checkbox" name="report2" id="report2" value="2">
                            <label for="report2">Ｐ担当者別市区郡軒数</label><br>
                            </div>

                            <!-- ワクチンの場合のみ表示する -->
                            <div id="ishiPdf4">
                            <input type="checkbox" name="report5" id="report5" value="5">
                            <label for="report5">担当者別重点先施設一覧</label><br>
                            <input type="checkbox" name="report6" id="report6" value="6">
                            <label for="report6">担当者別市区郡軒数</label><br>
                            </div>

                            <!-- 常に表示する項目 -->
                            <input type="checkbox" name="report4" id="report4" value="4">
                            <label for="report4">担当状況総括表</label><br>

                            <!-- 医師別担当変更関連項目表示フラグが１の場合 -->
                            <div id="ishiPdf1">
                            <input type="checkbox" name="report3" id="report3" value="3">
                            <label for="report3">複数担当先所属部科別担当者別医師数</label><br>
                            </div>

                            <div align="right"><input type="button" name="button1" value="リスト作成依頼" onClick="execConfirm('pdf');return false;"></div>
                          </td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
                <br>
                <table style="margin-top:10px;" border="0">
                  <tr>
                    <td id="ishiPdf5" style="width:530px; border-width:1px;, border-style:solid; border-color:#808080; text-align:center;">
                      <table>
                        <tr>
                          <td class="contentsHeader" style="width:480px; top:-15px; position:relative;">

                            以下のリストは、リンク先画面からCSVファイルを出力して下さい

                          </td>
                        </tr>
                      </table>
                      <table style="top:-10px; position:relative;">
                        <tr>
                          <td class="contentsBox2" style="width:400px">
                            <a href="" onClick="execConfirm('pdf1'); return false;">
                              ＵＨ施設一覧<br>
                            </a>
                            <a href="" onClick="execConfirm('pdf2'); return false;">
                              Ｐ担当者別市区郡別施設一覧<br>
                            </a>
                            <div id="ishiPdf2">
                            <a href="" onClick="execConfirm('pdf3'); return false;">
                              複数担当先所属部科別担当者別医師一覧<br>
                            </a>
                            </div>
                          </td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
          <br>
<!-- 【４】 -->
          <table id="menuBox04" border="0" cellPadding="2" cellSpacing="0" style="width:900px" align="center">
          <tr>
            <td style="width: 20px; text-align:left">&nbsp;</td>
            <td style="border-width:0px 0px 2px 0px; border-style:solid; border-color:#808000;">
              <a href="" class="titleLink" onclick="gotoNext('JKR090C010','Init'); return false;">
              【４】帳票出力
              </a>

            </td>
          </tr>
          <tr id="menuHead01" style="display:inline;">
            <td>&nbsp;</td>
            <td class="titleLeter">
              【３】確認リストの作成依頼でリクエストした帳票を出力します。
            </td>
          </tr>
          </table>
          <br>
<!-- 【５】 -->
          <table id="menuBox05" border="0" cellPadding="2" cellSpacing="0" style="width:900px" align="center">
          <!-- 新組織対応-->
          <s:if test="%{sosSelFlg == 0}">
          <tr>
            <td style="width:20px; text-align:left">&nbsp;</td>
            <td style="border-width:0px 0px 2px 0px; border-style:solid; border-color:#808000;">
              <a href="" class="titleLink" onclick="gotoTantoHenkoLink(2); return false;">
              【５】担当変更の確定処理
              </a>
            </td>
          </tr>
          </s:if>
          <s:elseif test="%{sosSelFlg == 1}">
          <tr>
            <td style="width:20px; text-align:left">&nbsp;</td>
            <td style="border-width:0px 0px 2px 0px; border-style:solid; border-color:#808000;">
              <span style="font-size:15px; font-weight:bold; color:#330000; text-decoration:none;">
              【５】担当変更の確定処理
              </span>
            </td>
          </tr>
          <tr>
            <td style="width:20px; text-align:left;">&nbsp;</td>
            <td class="titleLeter">
            <span style="font-size:16px; color:#FF00FF; font-weight:bold;">
              新組織の担当変更の確定処理はこちら
            </span>
            <a href="" style="text-decoration:underline; font-weight:bold;" onclick="gotoNext('JKR020C020','Init'); return false;">
              新組織の担当変更状況画面
            </a>
            </td>
          </tr>
          </s:elseif>
          <tr id="menuHead01" style="display:inline;">
            <td>&nbsp;</td>
            <td class="titleLeter">
              担当変更の入力・確認後、確定処理を行います。<br>
            </td>
          </tr>
          <tr id="menuHead01" style="display:inline;">
            <td>&nbsp;</td>
            <td class="titleLeter">
              通常月：実働月末日　 １５時まで<br>
              期末月：実働月末前日１５時まで<br>
            </td>
          </tr>
          <tr id="menuHead01" style="display:inline;">
            <td>&nbsp;</td>
            <td class="titleLeter">
              <%-- <span style="color:red;">※確定処理後に担当変更が発生した場合は、業務Ｃへ確定の解除を依頼して下さい。</span> --%>
              <span style="color:red;">※確定処理後に担当変更が発生した場合は、ＣＢＣ業務Ｇへ確定の解除を依頼して下さい。</span>
            </td>
          </tr>
          </table>

    </s:if>
    <s:else>
      <div id="ishi"></div>
      <div id="ishiRadio"></div>
      <div id="ishiErr"></div>
      <div id="ishiPdf3"></div>
      <div id="ishiPdf4"></div>
      <div id="ishiPdf1"></div>
      <div id="ishiPdf5"></div>
      <div id="ishiPdf2"></div>
    </s:else>

    <s:if test="jkrSosStsTableData == null || jkrSosStsTableData.btTekiyoChgFlg == 0">
    <table>
    <tr>
      <td id="sosTekiyou3" >
        &nbsp;
      </td>
    </tr>
    </table>
    </s:if>
      </s:form>
      <div id="resultTmp" style="display:none;"></div>
    </td>
  </tr>
</table>
</body>
</html>
