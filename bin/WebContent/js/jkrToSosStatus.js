/**
 * <pre>
 *  担当変更状況（新組織）のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author BHH 曹
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var JTS_APPLICATION_ID = "JTS";
var msgContent = ""; //確認メッセージ

/**
 * <pre>
 *  デバッグ用関数
 * gJtsDebug = true でデバッグします。
 * </pre>
 */
var gJtsDebug = false;
function jtsDebug(str){
  if(gJtsDebug) alert(str);
  return(true);
}

/**
 * <pre>
 *  画面のロード時の処理
 * 画面のロード時の処理を記述します。
 * <pre>
 */
function jtsViewLoad(){

}


/**
 * <pre>
 *  詳細 => 一覧
 * 一覧へ戻る(リンク)押下時に呼ばれます。
 * </pre>
 */
function jtsView(){
  document.fm0.screenId.value="JkrToSosStatus";
  document.fm0.functionId.value="View";
  comSubmit(fm0);
}

/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jtsSearch(){
  if(jtsChkBeforeSearch()){
    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    document.fm1.screenId.value = 'JKR020C020';
    document.fm1.functionId.value = 'Search';

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  }
}

/**
 * <pre>
 *  検索前のチェック
 * 入力チェックを行います。
 * </pre>
 */
function jtsChkBeforeSearch(){
  return true;
}

/**
 * <pre>
 *  確認・取消
 * 確認・取消押下時に呼ばれます。
 * </pre>
 */
function jtsRegister(selFlg,i){
  // 確認メッセージ表示
  if (confirm(msgContent)){
  } else {
    return false;
  }
  
  // 処理行う行目のindex
  document.fm1.targetIndex.value = i;
  document.fm1.screenId.value = 'JKR020C020';
  if(selFlg == "0"){
    document.fm1.functionId.value = 'Register';
  }else{
    document.fm1.functionId.value = 'Cancel';
  }
  //イベント呼び出し
  comSubmitForAnyWarp(fm1);
}



/**
 * <pre>
 *  表示リセット
 * 表示リセット(リンク)押下時に呼ばれます。
 * </pre>
 */
function jtsViewInit(){
    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    document.fm1.screenId.value = 'JKR020C020';
    document.fm1.functionId.value = 'Reset';

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  ページ切替え
 * ページ切替えリンク押下時に呼ばれます。
 * </pre>
 */
function pltPage( pageCntCur ){
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = pageCntCur;
  document.fm1.screenId.value = 'JKR020C020';
  document.fm1.functionId.value = 'Page';
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  規定値に戻す
 * 規定値に戻す(リンク)押下時に呼ばれます。
 * </pre>
 */
function defaultValue(){

  document.fm1.searchBumonRank.value = document.fm1.defaultBumonRank.value;
  document.fm1.searchSosCd.value = document.fm1.defaultSosCd.value;
  document.fm1.searchSosName.value = document.fm1.defaultSosName.value;

}

/**
 * <pre>
 * CSV出力
 * 　検索結果をCSV形式でダウンロードする。
 * <pre>
 */

function jmsCsvDownLoad(){
  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  document.fm1.screenId.value = 'JKR020C020';
  document.fm1.functionId.value = 'Download';
  try{
    fm1.action = fm1.screenId.value + fm1.functionId.value + ".action";
    fm1.submit();
  }catch(e){
    if (e.number == -2147024891) {
      alert('添付ファイルに正しいファイルパス・ファイル名を指定して下さい。');
      COM_Click_flg = true;
    }
  }
}

////////////////////////////////////////////////////
/**
 * ポップアップ画面のwindowオブジェクト保管用です。
 */
var jtsViewWin=null;


/**
 * 選択画面を呼び出します。
 */
function jtsPopView(jokenFlg){
  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  var selectedJgiJoken = document.fm1.selectedJgiJoken.value;
  var searchSosName = document.fm1.searchSosName.value;
  if (searchSosName == "") {
    // ユーザ権限：本部orワクチンの場合
    if (selectedJgiJoken == "JKN0163" || selectedJgiJoken == "JKN0162" || selectedJgiJoken == "JKN0161") {
      document.fm1.initSosCdPop.value = "01050";
    }
    // ユーザ権限：支店の場合
    if (selectedJgiJoken == "JKN0160") {
      document.fm1.initSosCdPop.value = document.fm1.sosCd.value;
    } 
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
  document.fm1.bumonRankBtmPop.value = 3;

  jtsViewWin = cseView(jtsViewWin,"jtsCallBackCseView","jtsViewWin");
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
function jtsCallBackCseView(
  sosCd, sosName,
  jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
  bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
){

  // 以下戻り値
  document.fm1.searchSosCd.value   = sosCd;
  document.fm1.searchSosName.value	=	bumonSeiName2
                + ((bumonSeiName3 != "")?" ":"") + bumonSeiName3
                + ((bumonSeiName4 != "")?" ":"") + bumonSeiName4
                + ((bumonSeiName5 != "")?" ":"") + bumonSeiName5
                + ((bumonSeiName6 != "")?" ":"") + bumonSeiName6;


    //従業員ポップアップの初期表示組織を、選択組織に変更する
  document.fm1.initSosCdPop.value = sosCd;

  document.fm1.searchBumonRank.value = getBumonRank(sosCd, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6);
}

/**
 * <pre>
 *  組織コード1～6から部門ランクを取得します
 * </pre>
 * @return 部門ランク
 */
function getBumonRank(sosCd, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6) {
  var bumonRank = "";

  // 部門ランク設定
  if (sosCd == sosCd1) {
    bumonRank = "1";
  } else if (sosCd == sosCd2) {
    bumonRank = "2";
  } else if (sosCd == sosCd3) {
    bumonRank = "3";
  } else if (sosCd == sosCd4) {
    bumonRank = "4";
  } else if (sosCd == sosCd5) {
    bumonRank = "5";
  } else if (sosCd == sosCd6) {
    bumonRank = "6";
  }

  return bumonRank;
}

/**
 * 画面のリロードやアンロードの際の処理を記述します。
 * ポップアップ画面を使用するときは使用する分を全てクリアします。
 */
function jtsUnLoad(){

  jtsViewClear();
}

/**
 * ポップアップ画面のクリアを行います。
 */
function jtsViewClear(){
  if(jtsViewWin != null && typeof(jtsViewWin) !='string'){
    try{
      jtsViewWin.close();
    }catch(err){
      //エラー時は何も表示しない。
    }
    jtsViewWin = null;
  }
}

////////////////////////////////////////////////////

