/*
 * $Id: jkrSosStatus.js,v 1.1 2014/09/01 04:19:14 caoxj Exp $
 *******************************************************************************
 *   共通jspを含めてformが増減した場合はline427のiの値を調整すること(上から何個目のformという形の為)
 * YYYY/MM/DD 改訂者名：[フィールド名｜メソッド名]：[リビジョン番号]
 *   [改訂内容]
 *******************************************************************************
 */
/**
 * <pre>
 *  担当変更状況のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author caoxj
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var JMR_APPLICATION_ID = "JMR";
var msgContent = "";

function monthChange(i,selectedIdx) {
  var len = document.getElementsByName("jkrSosStatusData["+i+"].execDd")[0].options.length;
  for (var n = len-1; n >= 0 ; n--) {
    document.getElementsByName("jkrSosStatusData["+i+"].execDd")[0].options.remove(n);
  }

  if (selectedIdx == 0){
    var startDay = Number(document.getElementsByName("execDdComboStart")[0].value);
    var endDay = Number(document.getElementsByName("execDdComboEnd")[0].value);
    for(var j = startDay; j <= endDay; j++){
      var varItem = null;
      var val = "";
      if (j < 10){
        val = "0" + j;
      }else{
        val = "" + j;
      }
      varItem = new Option(val, val);
      document.getElementsByName("jkrSosStatusData["+i+"].execDd")[0].options.add(varItem);
    }
    document.getElementsByName("jkrSosStatusData["+i+"].execYy")[0].value = parseInt(document.getElementsByName("execYyFirst")[0].value);
  }else{
    var varItem = new Option("01", "01");
    document.getElementsByName("jkrSosStatusData["+i+"].execDd")[0].options.add(varItem);
    if (document.getElementsByName("jkrSosStatusData["+i+"].execMm")[0].value == "01" || document.getElementsByName("jkrSosStatusData["+i+"].execMm")[0].value == "1")
    document.getElementsByName("jkrSosStatusData["+i+"].execYy")[0].value = parseInt(document.getElementsByName("execYyFirst")[0].value) + 1;
  }
}

/**
 * <pre>
 *  メッセージIDを定義
 * 　当画面で使用するメッセージを設定
 * </pre>
 */
var registerMsg = "";
var cheakTimeMsg = "";
var execdateUpMsg = "";
var clearMsg = "";
var commitMsg = "";
var cancelMsg = "";
var chackdateMsg = "";

/**
 * <pre>
 *  担当変更状況の条件フラグ
 * </pre>
 */
var jokenFlg = "";
/**
 * <pre>
 *  検索前のチェック
 * 入力チェックを行います。
 * </pre>
 * @return boolean true:OK false:エラー
 */
function jmrChkBeforeSearch(joken){
    if (document.fm1.tekiyoYmdUpdateFlg.value == "1"){
        //適用日変更有無チェック
        checkChange();

        if(!(jkrDestructChack())){
            return false;
        }
    }
  return true;
}

/**
 * <pre>
 *  規定値に戻す
 * 規定値に戻す(リンク)押下時に呼ばれます。
 * </pre>
 */
function defaultValue(){
  document.fm1.selectSosCd1.value=document.fm1.defSosCd.value;
  document.fm1.sosName1.value=document.fm1.defSosName.value;
}

/**
 * <pre>
 *  更新系ボタン押下処理
 *  ・フォーム[i]項目をFm0に設定する
 *  ・ボタン種類でアラート内容を振分け
 * </pre>
 */
function setValueFm0(i, buttonNo, jokenFlg){
    document.fm1.selectIndex.value = i;

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

    if(buttonNo == 1 && jokenFlg == "A"){
        var execDate = makeExecDate(i);
        if(comChkDate(execDate)){
        }else {
            alert(chackdateMsg);
            return false;
        }
    } else if(buttonNo != 1 &&  document.fm1.tekiyoYmdUpdateFlg.value == "1"){

        //適用日変更有無チェック
        checkChange();

        if(!jkrDestructChack()){
            return false;
        }
    }

    if (confirm(msgContent)){
       if(buttonNo == 1){
           document.fm1.update_search.click();
       }
       if(buttonNo == 2){
           document.fm1.setClear_search.click();
       }
       if(buttonNo == 3){
           document.fm1.check_search.click();
       }
       if(buttonNo == 4){
           document.fm1.confirm_search.click();
       }
       if(buttonNo == 5){
           document.fm1.release_search.click();
       }
       COM_Click_flg = false;
    }
}

/**
 * <pre>
 *  適用日作成処理
 * </pre>
 */
function makeExecDate(i){
  var vYear = document.getElementsByName("jkrSosStatusData["+i+"].execYy")[0].value;
  var vMonth = document.getElementsByName("jkrSosStatusData["+i+"].execMm")[0].value;
  var vDay = document.getElementsByName("jkrSosStatusData["+i+"].execDd")[0].value;

  if(vMonth.length == 1){
        vMonth = ("0" + vMonth);
    }

    if(vDay.length == 1){
        vDay = ("0" + vDay);
    }
    var execDate = vYear + vMonth + vDay;
    return execDate;
}

/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jmrSearch(jokenFlg){
  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  if(jmrChkBeforeSearch(jokenFlg)){
    //検索組織コード
      document.fm1.submit_search.click();
      COM_Click_flg = false;
  }
}

/**
 * ポップアップ画面のwindowオブジェクト保管用です。
 */
var jmrViewWin=null;


/**
 * 選択画面を呼び出します。
 */
function jmrPopView(){
  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  jmrViewClear();

  var selectedJgiJoken = document.fm1.selectedJgiJoken.value;
  var searchSosName = document.fm1.sosName1.value;
  if (searchSosName == "") {
    // ユーザ権限：本部orワクチンの場合
    if (selectedJgiJoken == "JKN0163" || selectedJgiJoken == "JKN0162" || selectedJgiJoken == "JKN0161") {
      document.fm1.initSosCdPop.value = "01050";
    }
    // ユーザ権限：支店の場合
    if (selectedJgiJoken == "JKN0160") {
      document.fm1.initSosCdPop.value = document.fm1.sosCd.value;
    }
    //20180118 HISOL Kawamoto JKR-C-005 MOD START
    //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START
    //// ユーザ権限：ONC営業部スタッフの場合
    //if (selectedJgiJoken == "JKN0349") {
    // ユーザ権限：従業員関連・営業部Ｓの場合
    if (selectedJgiJoken == "JKN0501") {
    //20180118 HISOL Kawamoto JKR-C-005 MOD END
      document.fm1.initSosCdPop.value = document.fm1.sosCd.value;
    }
    //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END
  }else{
    document.fm1.initSosCdPop.value=document.fm1.selectSosCd1.value;
  }
  // ユーザ権限：本部orワクチンの場合
  if (selectedJgiJoken == "JKN0163" || selectedJgiJoken == "JKN0162" || selectedJgiJoken == "JKN0161") {
    document.fm1.bumonRankTopPop.value = 1;
    document.fm1.topSosCdPop.value = "01050";

  }
  // ユーザ権限：支店の場合
  if (selectedJgiJoken == "JKN0160") {
    document.fm1.bumonRankTopPop.value = 2;
    document.fm1.topSosCdPop.value = document.fm1.sosCd.value;
  }
//20180118 HISOL Kawamoto JKR-C-005 MOD START
//20150224 HISOL Suzuki 期末期首 組織変更対応 ADD START
  //// ユーザ権限：ONC営業部スタッフの場合
  //if (selectedJgiJoken == "JKN0349") {
  // ユーザ権限：従業員関連・営業部Ｓの場合
  if (selectedJgiJoken == "JKN0501") {
//20180118 HISOL Kawamoto JKR-C-005 MOD END
    document.fm1.bumonRankTopPop.value = 2;
    document.fm1.topSosCdPop.value = document.fm1.sosCd.value;
  }
  //20150224 HISOL Suzuki 期末期首 組織変更対応 ADD END
  document.fm1.bumonRankBtmPop.value = 3;

  jmrViewWin = cseView(jmrViewWin,"jmrCallBackCseView","jmrViewWin");
    return(true);
}

/**
 * <pre>
 * ポップアップのコールバック関数です。(単一選択、動的ポップアップ:Servlet処理有り)
 * 受け取った値を好きなように編集します。
 * 外勤では表示用の項目に値を設定し、submit用のformにキーとなる情報を保存します。
 * </pre>
 * @param
 * @param
 */
function jmrCallBackCseView(
  sosCd, sosName,
  jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
  bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
){

  // 以下戻り値
  document.fm1.selectSosCd1.value   = sosCd;
  document.fm1.sosName1.value	=	bumonSeiName2
                + ((bumonSeiName3 != "")?" ":"") + bumonSeiName3
                + ((bumonSeiName4 != "")?" ":"") + bumonSeiName4
                + ((bumonSeiName5 != "")?" ":"") + bumonSeiName5
                + ((bumonSeiName6 != "")?" ":"") + bumonSeiName6;
}
/**
 * 画面のリロードやアンロードの際の処理を記述します。
 * ポップアップ画面を使用するときは使用する分を全てクリアします。
 */
function jmrUnLoad(){

  jmrViewClear();
}

/**
 * ポップアップ画面のクリアを行います。
 */
function jmrViewClear(){
  if(jmrViewWin != null && typeof(jmrViewWin) !='string'){
    try{
      jmrViewWin.close();
    }catch(err){
      //エラー時は何も表示しない。
    }
    jmrViewWin = null;
  }
}

/**
 * 適用日が変更されている場合フラグを立てます。
 */
function checkChange(){
    jkrMrChaker = 0;
    if (document.fm1.tekiyoYmdUpdateFlg.value != "1")
    {
        return jkrMrChaker;
    }
    var max;

    max = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value + 1;

    if (document.fm1.lineCntEnd.value == 0){
      max = 0;
    }
    var changeDate;
    for(var i=0; i< max && max > 0; i++){
        changeDate = makeExecDate(i);
        if(changeDate != document.getElementsByName("jkrSosStatusData["+i+"].execDate")[0].value.replace(/\//g,"")){
            jkrMrChaker = 1;
            break;
        }
    }
    return jkrMrChaker;
}

/**
 * <pre>
 *  新組織の担当変更状況
 * 新組織の担当変更状況(リンク)押下時に呼ばれます。
 * </pre>
 */
function jkrToSosStatusLink(){
  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  //適用日変更有無チェック
    checkChange();

    if(!(jkrDestructChack())){
        return false;
    }
    document.fm1.newSos_move.click();
    COM_Click_flg = false;
}
