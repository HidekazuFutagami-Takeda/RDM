/*
 * $Id: jkrMrChange.js,v 1.1 2013/04/16 04:19:16 murakami Exp $
 *******************************************************************************
 * <改訂履歴>
 * 2006/06/07 星野 真理：all：1.0
 *   新規作成
 * 2006/12/14 星野 真理：all：1.49
 *   2度押し対策
 * 2007/07/11 森川 克己：(),mrChangeCheck(),resetMr()：1.91
 *   レイアウト変更による取得項目の追加
 * 2007/08/09 泉水 朝伸：all：1.14
 *   表示組織名変更対応
 * 2007/12/03 木田 博子：()：1.14
 *   出入マーク結合テスト障害対応（A0003）
 * 2007/12/10 木田 博子：(),resetMr()：1.15
 *   出入マーク結合テスト障害対応（A0007）
 * 2007/12/25 木田 博子：jmsCsvDownLoad()：1.16
 *   ワクチンMR対応
 * 2008/12/18 照井 雅史：all:1.16
 *   チェック処理画面起動対応
 * YYYY/MM/DD 改訂者名：[フィールド名｜メソッド名]：[リビジョン番号]
 *   [改訂内容]
 *******************************************************************************
 * <既知のバグ情報>
 * YYYY/MM/DD バグ発見者名：[メソッド名]：[リビジョン番号]
 *   [バグ内容]
 */
/**
 * <pre>
 *  担当引継ぎのJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author 星野 真理
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var JMS_APPLICATION_ID = "JMS";

/**
 * <pre>
 *  画面IDを定義
 * </pre>
 */
var JMS_SCREEN_ID = "JkrMrChange";

/**
 * <pre>
 *  デバッグ用関数
 * gJmsDebug = true でデバッグします。
 * </pre>
 */
var gJmsDebug = false;
function jmsDebug(str){
  if(gJmsDebug) alert(str);
  return(true);
}

/**
 * <pre>
 *  メッセージIDを定義
 * 　当画面で使用するメッセージを設定
 * </pre>
 */
var registerMsg = "";
var destructMsg = "";
var commitMsg = "";


/**
 * <pre>
 *  画面のロード時の処理
 * 画面のロード時の処理を記述します。
 * <pre>
 */
function jmsViewLoad(msg1,msg2,msg3){

  comSetWindowName(self,JMS_APPLICATION_ID);
  if(opener!=null){
  }

  //メッセージを設定
  registerMsg = msg1;
  destructMsg = msg2;
  commitMsg = msg3;

}


/**
 * <pre>
 *  検索前のチェック
 * 入力チェックを行います。
 * </pre>
 * @return boolean true:OK false:エラー
 */
function jmsChkBeforeSearch(){
  return true;
}

/**
 * <pre>
 *  並び替え
 * ソート(ボタン)押下時に呼ばれます。
 * </pre>
 * @param sortfield ソート対象項目
 * @param sortflg 昇順・降順のフラグ
 */
function jmsSort(sortfield,sortflg){

  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  document.fm1.sortFieldNo.value = sortfield;
  document.fm1.sortFLG.value = sortflg;

  document.fm1.functionId.value = 'Sort';

  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  登録
 *  登録(ボタン)押下時に呼ばれます。
 * </pre>
 */
var msgContent;
function jmsRegister(flg){
  if(flg == 0){
    if (!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  }

  if (flg == 1 || confirm(msgContent)){
    document.fm1.functionId.value = 'Register';
    comSubmitForAnyWarp(fm1);
  }
}



/**
 * <pre>
 *  タブ
 * タブ(リンク)押下時に呼ばれます。
 * </pre>
 */
function jmsTabInit(tabno){
  if(jkrDestructChack()){
    switch(tabno){
      case 0:
        document.fm1.actionMtKbn.value = '0';
        document.fm1.functionId.value = 'Init';
        document.fm1.screenId.value	= "JKR030C010";
        comSubmitForAnyWarp(fm1);
        break;
      case 1:
        document.fm1.actionMtKbn.value = '0';
        document.fm1.screenId.value	= "JKR030C020";
        document.fm1.functionId.value = 'Init';
        comSubmitForAnyWarp(fm1);
        break;
      }
  }
}

////////////// ポップアップ ////////////////////////

/**
 * 新担当者リンクのindexオブジェクト保管用です。
 */
var jgiIndex=null;

/**
 * 新担当者リンクの現担当者オブジェクト保管用です。
 */
var fromjgiIndex=null;

/**
 * 新担当者リンクの現担当者組織オブジェクト保管用です。
 */
var fromsosIndex=null;

/**
 * ポップアップ画面のwindowオブジェクト保管用です。
 */
var jmsSelectJgiWin=null;

/**
 * <pre>
 * 従業員選択POP画面を呼び出します。
 * <pre>
 */
function jmsSelectJgi(index,fromNo,fromSos){

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  jgiIndex = index;
  fromjgiIndex = fromNo;
  fromsosIndex = fromSos;

//  document.fm1.initSosCdPop.value = fromSos;
  var summarySosCd = document.getElementsByName("jkrMrChangeData["+jgiIndex+"].summarySosCd")[0].value;
  var toSosCd = document.getElementsByName("jkrMrChangeData["+jgiIndex+"].toSosCd")[0].value;
  var toSosCdAft = document.getElementsByName("jkrMrChangeData["+jgiIndex+"].toSosCdAft")[0].value;
  if (toSosCdAft != null && toSosCdAft != "") {
    document.fm1.initSosCdPop.value = toSosCdAft;
  } else if (toSosCd != null && toSosCd != "") {
    document.fm1.initSosCdPop.value = toSosCd;
  } else if (summarySosCd != null && summarySosCd != "") {
      document.fm1.initSosCdPop.value = summarySosCd;
  } else {
    document.fm1.initSosCdPop.value = document.fm1.selectedSosCd.value;
  }
//20150202 HISOL Suzuki 本番課題No.25対応 ADD START
  document.fm1.sosCdFromPop.value = document.fm1.searchFromSosCdPop.value;  // 現組織コード
  document.fm1.sosCdToPop.value = document.fm1.searchToSosCdPop.value;  // 新組織コード
  document.fm1.trtTntFlgPop.value = 1; // 領域担当者フラグ
//20150202 HISOL Suzuki 本番課題No.25対応 ADD END
  jmsSelectJgiWin = cseView(jmsSelectJgiWin,"jmsCallBackJgi","jmsSelectJgiWin");

  return(true);
}

/**
 * <pre>
 * 新担当者リンクのポップアップのコールバック関数です。
 * (単一選択、動的ポップアップ:Servlet処理有り)
 * 受け取った値を好きなように編集します。
 * </pre>
 * @param
 * @param
 */
function jmsCallBackJgi(
  sosCd, sosName,
  jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
  bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
  ,brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank
  , bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6
){
  document.fm1.toMrName.value   = jgiName;
  document.fm1.toMrNo.value   = jgiNo;
  document.fm1.toSosCd.value = sosCd;

  var str1 = "changeMr" + jgiIndex;
  var str4 = "newInOut" + jgiIndex;
  var str6 = "changeSosName" + jgiIndex;

  var iBumonRank = 0;
  if(sosCd6 == '00000')	iBumonRank = 5;
  if(sosCd5 == '00000')	iBumonRank = 4;
  if(sosCd4 == '00000')	iBumonRank = 3;
  if(sosCd3 == '00000')	iBumonRank = 2;
  if(sosCd2 == '00000')	iBumonRank = 1;
  if (iBumonRank=='4') {
    document.fm1.toSosName.value = bumonRyakuName3+bumonRyakuName4;
    document.getElementById(str6).innerHTML = bumonRyakuName3+bumonRyakuName4;
  } else {
    document.fm1.toSosName.value = bumonRyakuName;
    document.getElementById(str6).innerHTML = bumonRyakuName;
  }
  document.getElementById(str4).innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;";
  document.getElementById(str1).innerHTML = jgiName;

  if ('00000' == sosCd3){
    document.getElementsByName("jkrMrChangeData["+jgiIndex+"].toSosCdDist")[0].value = sosCd;
  }else{
    document.getElementsByName("jkrMrChangeData["+jgiIndex+"].toSosCdDist")[0].value = sosCd3;
  }
  // ポップアップ呼び出し時に保管しておいた行No・現担当者No・現組織CDを使って
  // 新担当者を設定する。
  changeMr(jgiIndex,fromjgiIndex,fromsosIndex);

  document.fm1.toMrName.value   = "";
  document.fm1.toMrNo.value   = "";
  document.fm1.toSosCd.value = "";
  document.fm1.toSosName.value = "";

  //従業員ポップアップの初期表示組織を、選択組織に変更する
  document.fm1.initSosCdPop.value = sosCd;

  return false;
}

/**
 * ポップアップ画面のクリアを行います。
 */
function jmsViewClear(){

  if(jmsSelectJgiWin != null && typeof(jmsSelectJgiWin) !='string'){
    try{
      jmsSelectJgiWin.close();
    }catch(err){
      //エラー時は何も表示しない。
    }
    jmsSelectJgiWin = null;
  }
}
////////////// ポップアップ ここまで////////////////////////

/**
 * <pre>
 *  新担当MRの変更
 * 　新担当リンク押下時に呼ばれます。
 * </pre>
 */
function changeMr(i,fromMrNo,fromSosCd){

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  var str1 = "changeMr" + i;
  var str2 = "resetMrButton" + i;
  var str3 = "newInOut" + i;
  var str4 = "changeSosName" + i;

  //新担当者として選択されたMRが現担当者と同じだった場合は、
  //戻すボタン押下と同様の処理を行う
    if(fromMrNo == document.fm1.toMrNo.value
        && fromSosCd == document.fm1.toSosCd.value){
      resetMr(i);
    }else{
      //新担当者を変更担当者に置き換え
      document.getElementById(str1).innerHTML = "<acronym title='"+ document.fm1.toMrName.value + "'>" + document.fm1.toMrName.value + "</acronym>";
      document.getElementById(str3).innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
      document.getElementById(str4).innerHTML = "<acronym title='"+ document.fm1.toSosName.value + "'>" + document.fm1.toSosName.value + "</acronym>";

      document.getElementsByName("jkrMrChangeData["+i+"].toMrNameAft")[0].value = document.fm1.toMrName.value;
      document.getElementsByName("jkrMrChangeData["+i+"].toSosNameAft")[0].value = document.fm1.toSosName.value;
      document.getElementsByName("jkrMrChangeData["+i+"].toSosCdAft")[0].value = document.fm1.toSosCd.value;
      document.getElementsByName("jkrMrChangeData["+i+"].toMrNoAft")[0].value = document.fm1.toMrNo.value;

      if (document.getElementsByName("jkrMrChangeData["+i+"].fromSosCd")[0].value == document.fm1.toSosCd.value
          && document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value == document.fm1.toMrNo.value){
        document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value = "0";
      }else//現担当＝新担当の場合、担当変更フラグを[1]に設定（INSERTデータ）
      //20180218 HISOL Kawamoto JKR-C-005 MOD START
      //表示的には現組織≠新組織だが、処理的には同じ組織の場合にINSERT処理になるよう条件を追加
      //if(document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toMrNo")[0].value
      if((document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toMrNo")[0].value
      //20150323 期末期首課題No.78対応 HISOL鈴木 UPD START INSERTの条件に背景色を追加
      //    && document.getElementsByName("jkrMrChangeData["+i+"].fromSosCd")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toSosCd")[0].value){
          && document.getElementsByName("jkrMrChangeData["+i+"].fromSosCd")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toSosCd")[0].value
          && (document.getElementsByName("jkrMrChangeData["+i+"].bgColor")[0].value == null
      //         || document.getElementsByName("jkrMrChangeData["+i+"].bgColor")[0].value == "")){
               || document.getElementsByName("jkrMrChangeData["+i+"].bgColor")[0].value == ""))
        || ((document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toMrNo")[0].value
              && document.getElementsByName("jkrMrChangeData["+i+"].fromSosCd")[0].value != document.getElementsByName("jkrMrChangeData["+i+"].toSosCd")[0].value
                  && document.getElementsByName("jkrMrChangeData["+i+"].toSosCd")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toSosCdAft")[0].value)
                      && (document.getElementsByName("jkrMrChangeData["+i+"].bgColor")[0].value == null
                            || document.getElementsByName("jkrMrChangeData["+i+"].bgColor")[0].value == ""))	){
      //20150323 期末期首課題No.78対応 HISOL鈴木 UPD END
      //20180218 HISOL Kawamoto JKR-C-005 MOD END
        document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value = "1";
      //現担当！＝新担当の場合、担当変更フラグを[2]に設定（UPDATEデータ）
      }else{
        //20150402 期末期首課題対応No.227 HISOL鈴木 UPD START
        // 設定済みのtatoHkFlg＝"3"(DELETE)の場合は、tatoHkFlg＝"9"(副担追加データ一括削除対象)としておく。
        // ※現担当がダミーユーザの行において一度「元に戻す」をしたら副担追加データを削除するため。
        // ※既に"9"の場合も変更しない。
        //document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value = "2";
        if(document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value == "3"
            || document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value == "9"){
            document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value = "9";
        }else{
            document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value = "2";
        }
        //20150402 期末期首課題対応No.227 HISOL鈴木 UPD END
      }
      //戻すボタンを表示
      var mes = "";
      if ((document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value != 0
          //20150303 ST-B-367対応 HISOL鈴木 MOD START
          //&& document.getElementsByName("jkrMrChangeData["+i+"].toMrNoAft")[0].value !=
          //  document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value)
          && (document.getElementsByName("jkrMrChangeData["+i+"].toMrNoAft")[0].value != document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value
               || document.getElementsByName("jkrMrChangeData["+i+"].toSosCdAft")[0].value != document.getElementsByName("jkrMrChangeData["+i+"].fromSosCd")[0].value))
          //20150303 ST-B-367対応 HISOL鈴木 MOD END
        || document.getElementsByName("jkrMrChangeData["+i+"].toInOut")[0].value == "4"){
            mes = "<acronym title='現担当へ戻す'>";
            mes = mes + "<INPUT type='button' name='modosu1' style='width:80px' value='現担当へ戻す' onClick='JavaScript:resetMr(";
            mes = mes + i + "); return false;'";
            if (document.getElementsByName("jkrMrChangeData[" + i + "].linkFlg")[0].value != "1"
              || document.fm1.lineCntAll.value == 0
              || document.fm1.regButtomFlg.value == "1") {
              mes = mes + " disabled='disabled'";
            }
            mes = mes + "/></acronym>";
            document.getElementsByName("jkrMrChangeData["+i+"].btnShowFlg")[0].value = 1;
      }else{
        document.getElementsByName("jkrMrChangeData["+i+"].btnShowFlg")[0].value = 0;
      }

      document.getElementById(str2).innerHTML = mes;
      //新担当者の変更チェックを行う
      mrChangeCheck(i);
    }
}

/**
 * <pre>
 *  戻すボタン
 * 　戻すボタン押下時に呼ばれます。
 * </pre>
 */
function resetMr(i){
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  var str1 = "changeMr" + i;
  var str2 = "resetMrButton" + i;
  var str3 = "fixMr" + i;
  var str4 = "newInOut" + i;
  var str5 = "fromInOut" + i;
  var str6 = "changeSosName" + i;
  var str7 = "fromSosName" + i;

  //新担当者を現担当者に置き換え
  document.getElementById(str1).innerHTML = document.getElementById(str3).innerHTML;
  document.getElementById(str4).innerHTML = document.getElementById(str5).innerHTML;
  //20150303 ST-B-367対応 HISOL鈴木 MOD START
  //document.getElementById(str6).innerHTML = document.getElementById(str7).innerHTML;
  document.getElementById(str6).innerHTML = "<acronym title='"+ document.getElementsByName("jkrMrChangeData["+i+"].toSosNameBef")[0].value + "'>"
                                             + document.getElementsByName("jkrMrChangeData["+i+"].toSosNameBef")[0].value + "</acronym>";
  //20150303 ST-B-367対応 HISOL鈴木 MOD END

  document.getElementsByName("jkrMrChangeData["+i+"].toInout")[0].value = "";

  document.getElementsByName("jkrMrChangeData["+i+"].toMrNameAft")[0].value = document.getElementsByName("jkrMrChangeData["+i+"].fromMrName")[0].value;
  //20150303 ST-B-367対応 HISOL鈴木 MOD START
  //document.getElementsByName("jkrMrChangeData["+i+"].toSosNameAft")[0].value = document.getElementsByName("jkrMrChangeData["+i+"].fromSosName")[0].value;
  document.getElementsByName("jkrMrChangeData["+i+"].toSosNameAft")[0].value = document.getElementsByName("jkrMrChangeData["+i+"].toSosNameBef")[0].value;
  //20150303 ST-B-367対応 HISOL鈴木 MOD END

  document.getElementsByName("jkrMrChangeData["+i+"].toSosCdDist")[0].value = document.getElementsByName("jkrMrChangeData["+i+"].summarySosCd")[0].value;
  document.getElementsByName("jkrMrChangeData["+i+"].toSosCdAft")[0].value = document.getElementsByName("jkrMrChangeData["+i+"].fromSosCd")[0].value;
  document.getElementsByName("jkrMrChangeData["+i+"].toMrNoAft")[0].value = document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value;

  if (document.getElementsByName("jkrMrChangeData["+i+"].fromSosCd")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toSosCd")[0].value
      && document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toMrNo")[0].value){
    document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value = "0";
//  }else if (document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value != document.getElementsByName("jkrMrChangeData["+i+"].toMrNo")[0].value){
  }else if (document.getElementsByName("jkrMrChangeData["+i+"].fromMrNo")[0].value != document.getElementsByName("jkrMrChangeData["+i+"].toMrNo")[0].value
        || document.getElementsByName("jkrMrChangeData["+i+"].fromSosCd")[0].value != document.getElementsByName("jkrMrChangeData["+i+"].toSosCd")[0].value){
    document.getElementsByName("jkrMrChangeData["+i+"].tatoHkFlg")[0].value = "3";
  }
  if ("00000" == document.getElementsByName("jkrMrChangeData["+i+"].summarySosCd")[0].value){
      document.getElementsByName("jkrMrChangeData["+i+"].toSosCdDist")[0].value = document.getElementsByName("jkrMrChangeData["+i+"].toSosCdAft")[0].value;
  }
  else{
      document.getElementsByName("jkrMrChangeData["+i+"].toSosCdDist")[0].value = document.getElementsByName("jkrMrChangeData["+i+"].summarySosCd")[0].value;
  }

  //戻すボタンを非表示btnShowFlg
  document.getElementsByName("jkrMrChangeData["+i+"].btnShowFlg")[0].value = 0;
  document.getElementById(str2).innerHTML = "&nbsp&nbsp&nbsp&nbsp";

  //新担当者の変更チェックを行う
  mrChangeCheck(i);
}

/**
 * <pre>
 * 新担当者の変更有無チェック
 * 　担当変更の有無をチェックし、変更があった場合
 * 　変更フラグを立てておく。
 * <pre>
 */
var changeArray ;
function mrChangeCheck(i){
  jkrMrChaker = 0;
  if (document.getElementsByName("jkrMrChangeData["+i+"].toSosCdAft")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toSosCd")[0].value
      && document.getElementsByName("jkrMrChangeData["+i+"].toMrNoAft")[0].value == document.getElementsByName("jkrMrChangeData["+i+"].toMrNo")[0].value){
      changeArray[i] = 0;
  }else{
      changeArray[i] = 1;
  }

  if (changeArray.join("") > 0){
      jkrMrChaker = 1;
  }
}

/**
 * 画面のリロードやアンロードの際の処理を記述します。
 * ポップアップ画面を使用するときは使用する分を全てクリアします。
 */
function jmsUnLoad(){

  jmsViewClear();

}

/**
 * <pre>
 * CSV出力
 * 　検索結果をCSV形式でダウンロードする。
 * <pre>
 */
function jmsCsvDownLoad(logicName,downLdKbn){
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  document.fm1.downLoadKbn.value=downLdKbn;

  try{
      fm1.action = fm1.screenId.value + "DownLoad.action";
      fm1.submit();
    }catch(e){
      if (e.number == -2147024891) {
        alert('添付ファイルに正しいファイルパス・ファイル名を指定して下さい。');
        COM_Click_flg = true;
      }
    }
}

function jkrComLink1(screendId)
{
    if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
    if(jkrDestructChack()){
      document.fm1.screenId.value	= screendId;
      if (screendId == "JKR040C040" || screendId == "JKR050C030") {
        document.fm1.functionId.value = 'Search';
      } else {
        document.fm1.functionId.value = 'Init';
      }
      comSubmitForAnyWarp(fm1);
    }
}

/**
 * <pre>
 *  ページ切替え
 * ページ切替えリンク押下時に呼ばれます。
 * </pre>
 */
function pltPage( pageCntCur ){
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = pageCntCur;

  document.fm1.functionId.value = 'Page';
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}
