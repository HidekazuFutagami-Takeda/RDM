/**
 * <pre>
 *  施設・領域別担当変更のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author BHH 趙
 */

/**
 * ポップアップ用ウィンドウオブジェクト
 */
var gCseViewFromWin = null;    // 組織従業員選択(組織・担当(現))
var gCseViewToWin = null;      // 組織従業員選択(組織・担当(新))
var gCtcViewWin = null;        // JIS府県武田市区郡選択
var gIiiViewWin=null;          // 施設固定コード複数入力
var gCpcViewWin=null;          // 品目選択開始
var gCseViewChgWin=null;       // 組織従業員選択(変更担当者)
var gCseViewToJgiWin=null;     // 組織従業員選択(新担当者)
var gCseViewSosWin=null;       // 組織従業員選択(組織)
/**
 * <pre>
 *  全メッセージ格納用配列
 * 当画面で使用する全メッセージが格納されます。
 * </pre>
 */
var gMsg = new Array();

/**
 * <pre>
 *  画面のロード時の処理
 * 画面のロード時の処理を記述します。
 * @param msg1～5 全メッセージ
 * <pre>
 */
function jimViewLoad(msg1,msg2,msg3,msg4,msg5, msg6){

  gMsg[0] = msg1;  // 『「組織・担当(現)」及び「組織・担当(新)」が設定されていません。どちらかの指定が必須となります。』
  gMsg[1] = msg2;  // 『施設名(全角カナ)には全角カナ文字又は全角英数字(大文字)以外は入力できません。』
  gMsg[2] = msg3;  // 『「展開方法」が設定されていません。 』
  gMsg[3] = msg4;  // 『新担当者を設定してください。』
  gMsg[4] = msg5;  // 『変更内容が破棄されます。よろしいですか？』
  gMsg[5] = msg6;  // 『登録します。よろしいですか？』
  
  // 変更内容破棄確認メッセージの設定
  destructMsg = gMsg[4];  // 『変更内容が破棄されます。よろしいですか？』
  
  if (document.fm1.gamenId.value == "JKR040C010") {
    setAllChgBtnStatus010("chgInsTrtList");
  } else if (document.fm1.gamenId.value == "JKR040C020") {
    
  } else if (document.fm1.gamenId.value == "JKR040C030") {
    setAllChgBtnStatus("chgInsCityList");
  } else if (document.fm1.gamenId.value == "JKR040C040") {
    setAllChgBtnStatus010("chgInsTrtList");
  }
}

/**
 * 画面のリロードやアンロードの際の処理を記述します。
 * ポップアップ画面を使用するときは使用する分を全てクリアします。
 */
function jimUnLoad(){

  jimViewClear(8);
}

/**
 * ポップアップ画面のクリアを行います。
 */
function jimViewClear(number){

  var popObj = new Array();
  popObj[0] = gCseViewFromWin;
  popObj[1] = gCseViewToWin;
  popObj[2] = gCseViewChgWin;
  popObj[3] = gCseViewSosWin;
  popObj[4] = gCseViewToJgiWin;
  popObj[5] = gCpcViewWin;
  popObj[6] = gCtcViewWin;
  popObj[7] = gIiiViewWin;
  for(var i = 0; i< popObj.length; i++){
    if(popObj[i] != null){
      try{
        popObj[i].close();
      }catch(err){
        //エラー時は何も表示しない。
        alert(err.message);
      }
      popObj[i] = null;
    }
  }
}
/**
 * <pre>
 * 担当引継ぎへ
 * 担当引継ぎへ(リンク)押下時に呼ばれます。
 * </pre>
 */
function gotoJKR030C010() {

  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  if (document.fm1.gamenId.value == "JKR040C040") {
    document.fm1.screenId.value	= "JKR030C020";  
  } else {
    document.fm1.screenId.value	= "JKR030C010";
  }
  document.fm1.functionId.value = 'Init';
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 * 複数担当先施設の医師担当変更の処理へ
 * 複数担当先施設の医師担当変更の処理へ(リンク)押下時に呼ばれます。
 * </pre>
 */
function gotoJKR050C010() {

  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  if (document.fm1.gamenId.value == "JKR040C040") {
    document.fm1.screenId.value	= "JKR050C030";
    document.fm1.functionId.value = 'Search';
  } else {
    document.fm1.screenId.value	= "JKR050C010";
    document.fm1.functionId.value = 'Init';
  }
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jimSearch() {
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  // 検索前チェック
  if(jimChkBeforeSearch()) {
    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    document.fm1.sortCondition1.value = "";
    document.fm1.sortCondition2.value = "";
    // エラー一覧
    if (document.fm1.gamenId.value == "JKR040C040") {
      document.fm1.screenId.value	= "JKR040C040";
      document.fm1.functionId.value = 'Search';
    } else {
      // 施設・領域別担当変更
      if (document.fm1.searchDeveWay.value == "0") {
        document.fm1.screenId.value	= "JKR040C010";
        document.fm1.functionId.value = 'Search';
      // 施設・特定品目別担当変更
      } else if (document.fm1.searchDeveWay.value == "1") {
        document.fm1.screenId.value	= "JKR040C030";
        document.fm1.functionId.value = 'Search';
      // 市区郡・領域別担当変更
      } else {
        document.fm1.screenId.value	= "JKR040C020";
        document.fm1.functionId.value = 'Search';
      }
    }
    
    //選択された組織情報格納（表示押下前→表示押下後）
    setTopChangedSos();
    
    //20150202 HISOL Suzuki 本番課題No.25対応 ADD START
    //選択された組織情報格納（ポップアップ用）
    setSearchSosCdPop();
    //20150202 HISOL Suzuki 本番課題No.25対応 ADD END

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  }
}

/**
 * <pre>
 *  エラー一覧
 * エラー(タブ)押下時に呼ばれます。
 * </pre>
 */
function jimGotoErr() {
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  
  //タブを変えた時、現、新組織の両方がクリアされたなら、組織を既定値に戻す
  if ( document.fm1.dispFromSosJgiName.value == "" 
      && document.fm1.dispToSosJgiName.value == "" ) {
    //既定値に戻す場合の組織情報のリセット
    if (document.fm1.sosSelFlg.value == "0") {
      jimFromCseViewDef();
    } else if (document.fm1.sosSelFlg.value == "1") {
      jimToCseViewDef();
    }
    //表示リセット時の組織リセット
    resetTopChangedSos();
  } else {
    //選択された組織情報格納（表示押下前→表示押下後）
    setTopChangedSos();
  }
  
  //20150202 HISOL Suzuki 本番課題No.25対応 ADD START
  //選択された組織情報格納（ポップアップ用）
  setSearchSosCdPop();
  //20150202 HISOL Suzuki 本番課題No.25対応 ADD END

  // 検索前チェック
  //if(jimChkBeforeSearch()) {

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    document.fm1.sortCondition1.value = "";
    document.fm1.sortCondition2.value = "";
    
    // エラー一覧
    document.fm1.screenId.value	= "JKR040C040";
    document.fm1.gamenId.value	= "JKR040C040";
//  if(document.fm1.pageFlag.value == "0"){
    //検索済状態
      document.fm1.functionId.value = 'Search';
//  }else if(document.fm1.pageFlag.value == "1"){
    //検索されていない状態
//      document.fm1.functionId.value = 'Init';
//  }
    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  //}
}

/**
 * <pre>
 *  エラー一覧から040C010また040C030に戻す
 * エラー(タブ)押下時に呼ばれます。
 * </pre>
 */
function jimBackFromErr() {
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  
  //タブを変えた時、現、新組織の両方がクリアされたなら、組織を既定値に戻す
  if ( document.fm1.dispFromSosJgiName.value == "" 
      && document.fm1.dispToSosJgiName.value == "" ) {
    //既定値に戻す場合の組織情報のリセット
    if (document.fm1.sosSelFlg.value == "0") {
      jimFromCseViewDef();
    } else if (document.fm1.sosSelFlg.value == "1") {
      jimToCseViewDef();
    }
    //表示リセット時の組織リセット
    resetTopChangedSos();
  } else {
    //選択された組織情報格納（表示押下前→表示押下後）
    setTopChangedSos();
  }
  
  //20150202 HISOL Suzuki 本番課題No.25対応 ADD START
  //選択された組織情報格納（ポップアップ用）
  setSearchSosCdPop();
  //20150202 HISOL Suzuki 本番課題No.25対応 ADD END

  // 検索前チェック
  //if(jimChkBeforeSearch()) {

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    document.fm1.sortCondition1.value = "";
    document.fm1.sortCondition2.value = "";
    

    // 担当者変更画面へ戻す
    if (document.fm1.fromGamenId.value == "") {
      document.fm1.fromGamenId.value = "JKR040C010";
    }
    document.fm1.screenId.value	= document.fm1.fromGamenId.value;
    
    //if(document.fm1.pageFlag.value == "1"){
    //  document.fm1.functionId.value = 'Init';
    //} else {
      document.fm1.functionId.value = 'Search';
    //}
    document.fm1.gamenId.value	= document.fm1.fromGamenId.value;
    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  //}
}

/**
 * <pre>
 *  検索前のチェック
 * 入力チェックを行います。
 * </pre>
 * @return true:エラーなし false:エラーあり
 */
function jimChkBeforeSearch(){

  // エラーメッセージ
  var errMsg = "";
  var msg = "";
  // 組織・担当(現)と組織・担当(現)のどちらか一方が入力されているかチェック
  if ( document.fm1.dispFromSosJgiName.value == "" 
    && document.fm1.dispToSosJgiName.value == "" ) {
    //『「組織・担当(現)」及び「組織・担当(新)」が設定されていません。\nどちらかの指定が必須となります。』
    errMsg += (gMsg[0] + "\n");
    document.fm1.dispFromSosJgiName.focus();
  }
  //施設名(全角カナ)の入力チェック(全角カナ文字数20)
  var insKana = document.fm1.dispInsKana.value;
  if (insKana != "") {
    msg = comChkFullSizeChar(insKana,'施設名(全角カナ)',20);
    if (msg != "") {
      errMsg += ( gMsg[1] + "\n");
      document.fm1.dispInsKana.focus();
    }
  }
  if (document.fm1.searchDeveWay.value == "") {
    errMsg += (gMsg[2] + "\n");
    document.fm1.searchDeveWay.focus();
  }
  // エラーメッセージの表示
  if (errMsg != "") {
    alert(errMsg);
    return false;
  }
  return true;
}


/**
 * <pre>
 *  縦スクロールコントロール
 * </pre>
 */
function tscroll2(own ){
  //send scroll event (record-header to meisai)
  if (own == undefined ) {
    rt = document.getElementById('RecordTable');
    mt = document.getElementById('MeisaiTable');
  } else {
    mt = document.getElementById(   own+'-'+'MeisaiTable');
    rt = document.getElementById(   own+'-'+'RecordTable');
  }

  if( rt != null && mt != null) {
    mt.scrollTop = rt.scrollTop;
  }
}

/**
 * <pre>
 *  横スクロール設定
 * </pre>
 */
function tscroll2Meisai(own, own2){
  var target = own;
  if( own2 != undefined ) {
    target = own2;
  }
  var mt = document.getElementById(target+'-'+'MeisaiTable');
  var ht = document.getElementById(own   +'-'+'HeaderTable');
  
  if( ht != null && mt != null ) {
    mt.scrollLeft = ht.scrollLeft;
  }
}

/**
 * <pre>
 *  明細テーブルのスクロールよりほかのコントロールを設定
 * </pre>
 */
function tscroll( target, own ){
  if( target == undefined || own == undefined ) {
    ht = document.getElementById('HeaderTable');
    mt = document.getElementById('MeisaiTable');
    if( ht != null ) {
      ht.scrollLeft = mt.scrollLeft;
    }
  } else {
    ht = document.getElementById(target+'-'+'HeaderTable');
    hmt = document.getElementById(target+'-'+'MeisaiTable');
    mt = document.getElementById(   own+'-'+'MeisaiTable');
    rt = document.getElementById(   own+'-'+'RecordTable');
    if( mt != null ) {
      if( hmt != null ) {
        hmt.scrollLeft = mt.scrollLeft;
      }
      if( ht != null ) {
        ht.scrollLeft = mt.scrollLeft;
      }
      if( rt != null ) {
        rt.scrollTop = mt.scrollTop;
      }
    }
  }
}

/**
 * <pre>
 *  表示リセット
 * 表示リセット(リンク)押下時に呼ばれます。
 * </pre>
 */
function jimViewInit(){
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;

  document.fm1.screenId.value	= document.fm1.gamenId.value;
  document.fm1.functionId.value = 'ViewInit';
  
  //表示リセット時の組織リセット
  resetTopChangedSos();
  
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
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = pageCntCur;

  document.fm1.screenId.value	= document.fm1.gamenId.value;
  document.fm1.functionId.value = 'Page';
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  ソート
 * ソートリンク押下時に呼ばれます。
 * </pre>
 */
function jimSort( sortCondition2, sortCondition1 ){
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = 1;

  //ソート区分設定
  document.fm1.sortCondition1.value = sortCondition1;
  document.fm1.sortCondition2.value = sortCondition2;

  document.fm1.screenId.value	= document.fm1.gamenId.value;
  document.fm1.functionId.value = 'Sort';

  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  登録処理
 * </pre>
 */
function jimRegister(buttonFlg){

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
    
  if (buttonFlg == "0") {
    if (confirm(gMsg[5])){
    } else {
      return false;
    }
  }
  
  document.fm1.buttonFlg.value = buttonFlg;
  if (document.fm1.gamenId.value == "JKR040C010" && buttonFlg == "0") {
      document.fm1.jkrMrChaker.value = jkrMrChaker;
      document.fm1.buttonFlg.value = "1";
  }
//20150401 期末期首課題対応No.225 HISOL鈴木 ADD START
  if (document.fm1.gamenId.value == "JKR040C040" && buttonFlg == "0") {
      document.fm1.buttonFlg.value = "1";
  }
//20150401 期末期首課題対応No.225 HISOL鈴木 ADD END

  document.fm1.msgId.value = "";
  // 登録するイベント呼び出し
  document.fm1.screenId.value	= document.fm1.gamenId.value;
  document.fm1.functionId.value = 'Register';

  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  アンロード時の処理
 *  ポップアップなどの画面を閉じる処理を行う。
 * </pre>
 */
function pltViewUnLoad(){
  //現状は何もしない
}

/**
 * <pre>
 *  CSV出力処理
 * </pre>
 */
function jimCsvDownLoad(){
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  document.fm1.btTkyFlg.value = "0";
  document.fm1.screenId.value	= document.fm1.gamenId.value;
  if(document.fm1.screenId.value == "JKR040C010"  || document.fm1.screenId.value == "JKR040C040"){
    document.fm1.functionId.value = 'Download';
  }else{
    document.fm1.functionId.value = 'CsvDownload';
  }
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

/**
 * <pre>
 *  別適用日の担当変更状況処理
 * </pre>
 */
function jimOtherCsvDownLoad(){
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  document.fm1.btTkyFlg.value = "1";
  document.fm1.screenId.value	= document.fm1.gamenId.value;
  document.fm1.functionId.value = 'OtherTekiyoChg';
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

/**
 * <pre>
 * 一覧列の表示非表示をコントロール
 * </pre>
 */
function dspTableCtrl(id, dspFlg){
  document.getElementById(id).style.display = dspFlg;
  var elementLst = document.getElementsByName(id);
  for(var i = 0; i < elementLst.length; i++){
    elementLst[i].style.display = dspFlg;
  }
}

/**
 * <pre>
 * JIS府県市区郡　選択ボタン押下
 * </pre>
 */
function tmpCtcView(){
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  jimClosePopUp(gCtcViewWin, "gCtcViewWin");
  //20150326 期末期首課題対応No.98 HISOL鈴木 ADD START
  if(document.getElementById("searchFromSosCd").value != null
      && document.getElementById("searchFromSosCd").value != ""){
      document.getElementById("sosCdC040").value = document.getElementById("searchFromSosCd").value;
      document.getElementById("jgiNoC040").value = document.getElementById("searchFromJgiNo").value;
  } else {
      document.getElementById("sosCdC040").value = document.getElementById("searchToSosCd").value;
      document.getElementById("jgiNoC040").value = document.getElementById("searchToJgiNo").value;
  }
  //20150326 期末期首課題対応No.98 HISOL鈴木 ADD END
  gCtcViewWin=ctcView(gCtcViewWin,"tmpCallBackCtcView","gCtcViewWin");
  return(true);
}

/**
 * <pre>
 * JIS府県市区郡　コールバック関数。
 * </pre>
 */
function tmpCallBackCtcView(codeDataList, encodedList) {

  // チェック済みを初期化
  document.getElementById("JISFk").value = "";
  document.fm1.dispAddrNamePrefCity.value = "";
  // 戻り値からチェック済みフォームを追加する。
  document.getElementById("checkedJisCodes").innerHTML = "";

  for (var i = 0; i < encodedList.length; i++) {
    document.getElementById("checkedJisCodes").innerHTML
        += "<input type='hidden' name='checkedCodes' value='" + encodedList[i] + "'>";
  }

  // 表示用の文字列を生成
  var s = "";
  for (var i = 0; i < codeDataList.length; i++) {
    if (codeDataList[i].tkCityCd == "") {
      s += ctcDecodeDecimal( codeDataList[i].addrNamePref );
    } else {
      s += ctcDecodeDecimal( codeDataList[i].tkCityName );
    }
    if (i < codeDataList.length - 1) {
      s += ",";
    }
  }

  // 一度HTMLに記述しないと参照文字列から実体文字列に変換されないため。
  document.getElementById("resultTmp").innerHTML = s;
  document.getElementById("JISFk").value = document.getElementById("resultTmp").innerText;
  document.fm1.dispAddrNamePrefCity.value = document.getElementById("resultTmp").innerText;

  // Hidden用に各戻り値を設定
  var tkCityCd = "";
  var addrCodePref = "";
  // JIS府県コード
  for (var i = 0; i < codeDataList.length; i++) {
    if (codeDataList[i].tkCityCd == "") {
      if (i > 0) {
        addrCodePref += ",";
      }
      addrCodePref += ctcDecodeDecimal( codeDataList[i].addrCodePref );
    }

  }
  // 武田市区郡コード(JIS府県コード(2桁)＋武田市区郡コード(3桁))
  for (var i = 0; i < codeDataList.length; i++) {
    if (codeDataList[i].tkCityCd != "") {
      if (tkCityCd.length > 0) {
        tkCityCd += ",";
      }
      tkCityCd += ctcDecodeDecimal( codeDataList[i].addrCodePref + codeDataList[i].tkCityCd );
    }
  }
  document.fm1.searchTkCityCd.value = tkCityCd;
  document.fm1.searchAddrCodePref.value = addrCodePref;
}

/**
 * <pre>
 * 施設固定Ｃ　選択ボタン押下
 * </pre>
 */
function tmpinsView(){
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  jimClosePopUp(gIiiViewWin, "gIiiViewWin");
  //20150305 HON-B-28対応 HISOL鈴木 ADD START
  //組織・担当（現）が選択されている場合
  if (document.fm1.searchFromSosCd.value != null && document.fm1.searchFromSosCd.value != "") {
      document.fm1.sosSelFlgC090.value = "0";
      document.fm1.sosCdC090.value = document.fm1.searchFromSosCd.value;
  //組織・担当（新）が選択されている場合
  } else if(document.fm1.searchToSosCd.value != null && document.fm1.searchToSosCd.value != "") {
      document.fm1.sosSelFlgC090.value = "1";
      document.fm1.sosCdC090.value = document.fm1.searchToSosCd.value;
  //組織が選択されていない場合はトップでの選択状態を使用
  } else {
      document.fm1.sosSelFlgC090.value = document.fm1.sosSelFlg.value;
      document.fm1.sosCdC090.value = document.fm1.selectedSosCd.value;
  }
  //20150305 HON-B-28対応 HISOL鈴木 ADD END
  gIiiViewWin = iiiView(gIiiViewWin,"tmpCallBackInsView","gIiiViewWin");
  return(true);
}

/**
 * <pre>
 * 施設固定Ｃ　コールバック関数。
 * </pre>
 */
function tmpCallBackInsView(insNo) {
  // チェック済みを初期化
  if (insNo != null && insNo != "" ) {
    //表示用の項目に値を設定します。
    document.fm1.searchInsNo.value = insNo;
    document.fm1.joinInsNo.value = insNo;

    //関連項目をクリアし、入力付加にする
    document.fm1.searchInsName.disabled = true;  //施設名（漢字）
    document.fm1.searchInsName.value = "";
    document.fm1.searchInsName.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    document.fm1.dispInsKana.disabled = true;  //施設名（全角カナ）
    document.fm1.dispInsKana.value = "";
    document.fm1.dispInsKana.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    document.fm1.searchHoInsType.disabled = true;  //対象区分
    document.fm1.searchHoInsType.value = "0";
    if (document.fm1.trtGrpCd.value == '003') {
      document.fm1.searchVacVisitType.disabled = true;  //ワクチン区分
      document.fm1.searchVacVisitType.value ="0";
    } else {
      document.fm1.searchPharmType.disabled = true;  //施設区分
      document.fm1.searchPharmType.value ="0";
    }
    document.fm1.bCtcView.disabled = true; //ＪＩＳ府県武田市区郡
    document.fm1.dispAddrNamePrefCity.value	="";
  }
}

/**
 * <pre>
 * 組織・担当(現)既定値に戻す
 * 組織従業員名称(組織・担当(現))を既定値に戻します。
 * </pre>
 */
function jimFromCseViewDef(){

  // メニューパタメータの値を表示・検索用項目にコピー
  document.fm1.dispFromSosJgiName.value = document.fm1.selectedSosNm.value; // 表示用組織従業員名称
  document.fm1.searchFromSosName.value = document.fm1.selectedSosNm.value;  // 検索用組織名称
  document.fm1.searchFromSosCd.value = document.fm1.selectedSosCd.value;    // 検索用組織コード
  document.fm1.searchFromSosCd2.value = document.fm1.selectedSosCd2.value;  // 検索条件_現組織支店コード
  document.fm1.searchFromSosNm2.value = document.fm1.selectedSosNm2.value;  // 検索条件_現組織支店名称
  document.fm1.searchFromSosCd3.value = document.fm1.selectedSosCd3.value;  // 検索用組織の組織コード３
  document.fm1.searchFromSosCd4.value = document.fm1.selectedSosCd4.value;  // 検索用組織の組織コード４
  document.fm1.insDispRngFlg.value = document.fm1.selectedInsDispRngFlg.value;  // 施設表示範囲設定フラグ
  document.fm1.sosCdC040.value = document.fm1.selectedSosCd.value;
  document.fm1.jgiNoC040.value = "";
  dispRngCtl(document.fm1.insDispRngFlg.value);
  document.fm1.searchFromJgiNo.value = "";   // 検索用現担当MRNO
  document.fm1.searchFromJgiName.value = ""; // 検索用現担当従業員名称

  // 組織･従業員選択画面用項目を初期化
  jimInitCseViewParam();
  
  if (document.fm1.sosSelFlg.value == "0") {
    //既定値に戻す場合の組織情報のリセット
    clearTopChangedSos();
  }
}

/**
 * <pre>
 * 組織・担当(新)既定値に戻す
 * 組織従業員名称(組織・担当(新))を既定値に戻します。
 * </pre>
 */
function jimToCseViewDef(){

  // メニューパタメータの値を表示・検索用項目にコピー
  document.fm1.dispToSosJgiName.value = document.fm1.selectedSosNm.value;  // 表示用組織従業員名称
  document.fm1.searchToSosName.value = document.fm1.selectedSosNm.value;   // 検索条件_新組織名称
  document.fm1.searchToSosCd.value = document.fm1.selectedSosCd.value;     // 検索条件_新組織コード
  document.fm1.searchToSosCd3.value = document.fm1.selectedSosCd3.value;   // 検索条件_新組織コード(営業所）
  document.fm1.searchToJgiNo.value = "";    // 検索条件_新現担当MRNO
  document.fm1.searchToJgiName.value = "";  // 検索条件_新担当従業員名称
  // 組織･従業員選択画面用項目を初期化
  jimInitCseViewParam();
  
  if (document.fm1.sosSelFlg.value == "1") {
    //既定値に戻す場合の組織情報のリセット
    clearTopChangedSos();
  }
}

/**
 * <pre>
 * 組織･従業員選択に必要な値を初期化します。
 * </pre>
 */
function jimInitCseViewParam() {
  document.fm1.selectFlgPop.value = ""; // 選択区分
  document.fm1.initSosCdPop.value = "";  // 初期表示組織
  document.fm1.sosKbnPop.value = "";  // 組織区分
  document.fm1.sknnFlgPop.value = "";  // 施設責任者フラグ
  document.fm1.insFlgPop.value = "";  // 施設担当者フラグ
  document.fm1.topMenuFlgPop.value = "";  // トップメニューフラグ
  document.fm1.authorityPop.value = "";  // 権限
  document.fm1.bumonRankTopPop.value = "";  // 部門ランク(最上位)
  document.fm1.bumonRankBtmPop.value = "";  // 部門ランク(最下位)
  document.fm1.topSosCdPop.value = "";  // 最上位組織コード
  document.fm1.defTblFlgPop.value = "";  // 定義テーブル使用フラグ
  document.fm1.actSosListPop.value = "";  // 代行組織リスト
  document.fm1.shokushuFlgPop.value = "";  // 職種指定フラグ
  document.fm1.ztTntFlgPop.value = "";  // 雑担当者表示フラグ
  document.fm1.jokenSetCdPop.value = "";  // 条件セットコード
  document.fm1.menuTrtGrpCdPop.value = "";  // 選択領域グループ(メニュー)
  document.fm1.menuSosCdPop.value = "";  // 選択組織(メニュー)
  document.fm1.selectableBumonrankPop.value = "";  // 選択可能部門ランク
  document.fm1.insNoPop.value = "";  // 施設固定コード
  document.fm1.trtCdPop.value = "";  // 領域コード
  document.fm1.sosCdFromPop.value = "";  // 現組織コード
//20150202 HISOL Suzuki 本番課題No.25対応 ADD START
  document.fm1.sosCdToPop.value = "";  // 新組織コード
  document.fm1.trtTntFlgPop.value = "";  // 領域担当者フラグ
//20150202 HISOL Suzuki 本番課題No.25対応 ADD END
  }

/**
 * <pre>
 * 品目　選択ボタン押下
 * </pre>
 */
function tmpCpcView(){
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  jimClosePopUp(gCpcViewWin, "gCpcViewWin");
  gCpcViewWin=cpcView(gCpcViewWin,"tmpCallBackCpcView","gCpcViewWin");
  return(true);
}

/**
 * <pre>
 * 品目　コールバック関数。
 * </pre>
 */
function tmpCallBackCpcView(codeDataList, encodedList){

  // チェック済みを初期化
  document.getElementById("Prod").value = "";
  document.getElementById("searchProdName").value = "";
  document.getElementById("checkedProdCodes").innerHTML = "";
  // 戻り値からチェック済みフォームを追加する。
  for (var i = 0; i < encodedList.length; i++) {
    document.getElementById("checkedProdCodes").innerHTML
        += "<input type='hidden' name='cpcCheckedCodes' value='" + encodedList[i] + "'>";
  }

  // 表示用の文字列を生成
  var s = "";
  var sCode = "";
  for (var i = 0; i < codeDataList.length; i++) {
    s += cpcDecodeDecimal( codeDataList[i].prodName );
    sCode += cpcDecodeDecimal( codeDataList[i].prodCode );
    if (i < codeDataList.length - 1) {
      s += ",";
      sCode += ",";
    }
  }

  // 一度HTMLに記述しないと参照文字列から実体文字列に変換されないため。
  document.getElementById("resultTmp").innerHTML = s;
  document.getElementById("Prod").value = document.getElementById("resultTmp").innerText;
  document.getElementById("searchProdName").value = document.getElementById("resultTmp").innerText;
  document.getElementById("resultTmp").innerHTML = sCode;
  document.getElementById("searchProdCode").value = document.getElementById("resultTmp").innerText;
  resetTrtCdCombo(sCode);
}

/**
 * <pre>
 *  全てのポップアップを閉じます。
 * </pre>
 * @param targetWin 	対象ウィンドウオブジェクト
 * @param targetWinName	対象ウィンドウ名称
 */
function jimClosePopUp(targetWin,targetWinName){

  if(jimCheckPopUp()){

    // 対象ポップアップが存在すればフォーカスを当てる
    if(targetWin != null){
      targetWin.focus();
    }
    // 組織・従業員選択(組織・担当(現))
    if(gCseViewFromWin != null && targetWinName != "gCseViewFromWin"){
      gCseViewFromWin.close();
      gCseViewFromWin = null;
    }

  // 組織・従業員選択(組織・担当(新))
    if(gCseViewToWin != null && targetWinName != "gCseViewToWin"){
      gCseViewToWin.close();
      gCseViewToWin = null;
    }

    // 組織従業員選択(変更担当者)
    if(gCseViewChgWin != null && targetWinName != "gCseViewChgWin"){
      gCseViewChgWin.close();
      gCseViewChgWin = null;
    }
    // 組織・従業員選択(新担当者)
    if(gCseViewToJgiWin != null && targetWinName != "gCseViewToJgiWin"){
      gCseViewToJgiWin.close();
      gCseViewToJgiWin = null;
    }

    // 組織・従業員選択(組織)
    if(gCseViewSosWin != null && targetWinName != "gCseViewSosWin"){
      gCseViewSosWin.close();
      gCseViewSosWin = null;
    }

    // JIS府県武田市区郡選択
    if(gCtcViewWin != null && targetWinName != "gCtcViewWin"){
      gCtcViewWin.close();
      gCtcViewWin = null;
    }
    
    // 施設固定CD複数入力画面
    if(gIiiViewWin != null && targetWinName != "gIiiViewWin"){
      gIiiViewWin.close();
      gIiiViewWin = null;
    }
  
    // 品目選択画面
    if(gCpcViewWin != null && targetWinName != "gCpcViewWin"){
      gCpcViewWin.close();
      gCpcViewWin = null;
    }
  }
}

/**
 * <pre>
 *  ポップアップウィンドウオブジェクトチェック関数
 * </pre>
 *  ポップアップ起動中にウィンドウが閉じられた時に
 *  ウィンドウオブジェクトがstring型に変更される場合があるため、
 *  ウィンドウオブジェクトの型をチェックしてJSエラーを回避します。
 *
 * @return true：正常,false：異常
 */
function jimCheckPopUp() {

  // 本画面で使用する全ポップアップウィンドウオブジェクトを対象にチェック
  if(typeof(gCseViewFromWin) =='string') return false;  // 組織・従業員選択(組織・担当(現))
  if(typeof(gCseViewToWin) =='string') return false;    // 組織・従業員選択(組織・担当(新))
  if(typeof(gCseViewChgWin) =='string') return false;   // 組織従業員選択(変更担当者)
  if(typeof(gCtcViewWin) =='string') return false;      // JIS府県武田市区郡選択
  if(typeof(gCseViewToJgiWin) =='string') return false; // 従業員選択(新担当者)
  if(typeof(gCseViewSosWin) =='string') return false;   // 従業員選択(組織)
  if(typeof(gIiiViewWin) =='string') return false;      // 施設固定CD複数入力画面
  if(typeof(gCpcViewWin) == 'string') return false;     // 品目選択
  // 全ウィンドウが正常ならばtrue
  return true;
}

/**
 * 組織・従業員選択画面を呼び出します。(検索項目用)
 *@param winName 呼び出し元項目名
 */
function jimCseView( winName ){

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 組織･担当(現)
  if ( winName == 'gCseViewFromWin' ) {
    // 全てのポップアップを閉じる
    jimClosePopUp(gCseViewFromWin, "gCseViewFromWin");

    // パラメータの設定
    jimSetParamCseView("gCseViewFromWin");

    // ポップアップをコール
    gCseViewFromWin = cseView(gCseViewFromWin,"jimCallBackFromCseView","gCseViewFromWin","jimClear('fromSosJgi')");

  // 組織･担当(新)
  } else if( winName == 'gCseViewToWin' ) {

    // 全てのポップアップを閉じる
    jimClosePopUp(gCseViewToWin, "gCseViewToWin");

    // パラメータの設定
    jimSetParamCseView("gCseViewToWin");

    // ポップアップをコール
    gCseViewToWin = cseView(gCseViewToWin,"jimCallBackToCseView","gCseViewToWin","jimClear('toSosJgi')");
  
  // 組織従業員選択(変更担当者)
  } else if( winName == 'gCseViewChgWin' ) {

    // 全てのポップアップを閉じる
    jimClosePopUp(gCseViewChgWin, "gCseViewChgWin");

    // パラメータの設定
    jimSetParamCseView("gCseViewChgWin");

    // ポップアップをコール
    gCseViewChgWin = cseView(gCseViewChgWin,"jimCallBackChgCseView","gCseViewChgWin","jimClear('changeJgi')");
  
  // 組織従業員選択(変更担当者)
  } else if( winName == 'gCseViewSosWin' ) {

    // 全てのポップアップを閉じる
    jimClosePopUp(gCseViewSosWin, "gCseViewSosWin");

    // パラメータの設定
    jimSetParamCseView("gCseViewSosWin");

    // ポップアップをコール
    gCseViewSosWin = cseView(gCseViewSosWin,"jimCallBackSosCseView","gCseViewSosWin","jimClear('chgAddSos')");
  }
}

/**
 * <pre>
 * 新担当者のリンク押下時に呼ばれます。
 * </pre>
 * @param listName リスト名称
 * @param rowNo 行番号
 * @param trtNo 領域番号
 */
function jimCseViewDetail(listName, rowNo, trtNo) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  document.fm1.listName.value = listName;
  document.fm1.poprowno.value = rowNo;
  document.fm1.poptrtno.value = trtNo;

  // 全てのポップアップを閉じる
  jimClosePopUp(gCseViewToJgiWin, "gCseViewToJgiWin");

  // パラメータの設定
  jimSetParamCseView("gCseViewToJgiWin");
  // ポップアップをコール
  gCseViewToJgiWin = cseView(gCseViewToJgiWin,"jimCallBackToJgiCseView","gCseViewToJgiWin","jimClear('changeJgi')");
}

/**
 * <pre>
 * 組織・従業員選択ポップアップのコールバック関数。
 * 一覧項目の「新担当者」のリンク押下時にばれます。
 * ポップアップで選択した値をフォームに設定します。
 * </pre>
 */
function jimCallBackToJgiCseView(
    sosCd, sosName,
    jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
    bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6,
    brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
    bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6,
    insDispRngFlg, sosTkyFlg
){
  var toSosCdId = document.fm1.listName.value + "[" 
              + document.fm1.poprowno.value + "].toSosCd"
              + document.fm1.poptrtno.value;
  var toSosNameId = document.fm1.listName.value + "[" 
              + document.fm1.poprowno.value + "].toSosName"
              + document.fm1.poptrtno.value;
  var toSosCdDistId = document.fm1.listName.value + "[" 
            + document.fm1.poprowno.value + "].toSosCdDist"
            + document.fm1.poptrtno.value;
  var toMrNoId = document.fm1.listName.value + "[" 
            + document.fm1.poprowno.value + "].toMrNo"
            + document.fm1.poptrtno.value;
  var toJgiNameId = document.fm1.listName.value + "[" 
            + document.fm1.poprowno.value + "].toJgiName"
            + document.fm1.poptrtno.value;
  document.getElementsByName(toSosCdId)[0].value = sosCd;
  document.getElementsByName(toSosNameId)[0].value = bumonRyakuName1
          + bumonRyakuName2
          + bumonRyakuName3
          + bumonRyakuName4;
  document.getElementsByName(toSosCdDistId)[0].value = sosCd3;
  document.getElementsByName(toMrNoId)[0].value = jgiNo;
  document.getElementsByName(toJgiNameId)[0].value = jgiName;
  // 画面表示用
  if (document.fm1.poptrtno.value != "") {
    var spanToSosNameDispId = document.fm1.listName.value + "[" 
              + document.fm1.poprowno.value + "].spanToSosName" 
              + document.fm1.poptrtno.value;
    document.getElementById(spanToSosNameDispId).innerText = document.getElementsByName(toSosNameId)[0].value;
  }
  var spanToJigiNameDispId = document.fm1.listName.value + "[" 
              + document.fm1.poprowno.value + "].spanToJgiName"
              + document.fm1.poptrtno.value;
  document.getElementById(spanToJigiNameDispId).innerText = jgiName;
  
  // 変更情報チェック
  jimCheckChangeInfo(document.fm1.listName.value, 
                     document.fm1.poprowno.value, 
                     document.fm1.poptrtno.value);

  // 新担当と現担当が同じかどうかをチェック
  jimChkMrNo(document.fm1.listName.value, 
             document.fm1.poprowno.value, 
             document.fm1.poptrtno.value);
}

/**
 * <pre>
 * 新担当者の設定時に呼ばれます。
 * 新担当と現担当が同じであれば変更ボタンを非表示にします。
 * </pre>
 * @param listName リスト名称
 * @param rowNo 行番号
 * @param trtNo 領域番号
 */
function jimChkMrNo(listName, rowNo, trtNo) {

  // 現担当MRNO
  var fromMrNoId = listName + "[" + rowNo + "].fromMrNo" + trtNo;
  var fromMrNo = document.getElementsByName(fromMrNoId)[0].value;

  // 変更後新担当MRNO
  var toMrNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var toMrNo = document.getElementsByName(toMrNoId)[0].value;

  // 現組織コード
  var fromSosCdId = listName + "[" + rowNo + "].fromSosCd" + trtNo;
  var fromSosCd	= document.getElementsByName(fromSosCdId)[0].value;

  // 変更後新組織コード
  var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
  var toSosCd = document.getElementsByName(toSosCdId)[0].value;

  //20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
  // 主副担当区分
  var mainMrId = listName + "[" + rowNo + "].mainMr";
  var mainMr = document.getElementsByName(mainMrId)[0].value;
  //20150402 期末期首課題対応No.227 HISOL鈴木 ADD END

  var btnRtnId = listName + "[" + rowNo + "].spanRtn" + trtNo;
  var fromInOutId = listName + "[" + rowNo + "].fromInout" + trtNo;
  var toInOutId = listName + "[" + rowNo + "].spanInout" + trtNo;
  var strEnabed = "";
  if (document.fm1.regEnabedFlg.value != "1") {
    strEnabed = "disabled";
  }
  var linkFlgId = listName + "[" + rowNo + "].linkFlg" + trtNo;
  var linkFlg = document.getElementsByName(linkFlgId)[0].value;
  if (linkFlg == "1") {
    if (Number(fromMrNo) == Number(toMrNo) && fromSosCd == toSosCd ) {
      document.getElementById(btnRtnId).innerHTML = "&nbsp;";
      //新 転入出に現 転入出を設定
      document.getElementById(toInOutId).innerHTML = document.getElementById(fromInOutId).innerHTML;
    } else if (Number(fromMrNo) != 0) {
      document.getElementById(btnRtnId).innerHTML = "<acronym title=\"現担当へ戻す\">"
            + "<INPUT type=\"button\" name=\"bReset\" value=\"戻す\" " + strEnabed
            + " onclick=\"jimResetFromMrTrt('" + listName
            + "', " + rowNo + ", '" + trtNo + "');\"></acronym>";
      document.getElementById(toInOutId).innerHTML = "&nbsp;";
    } else {
      //20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
      // 市区郡別画面の場合、副担追加行は「解除」させない
      if("chgInsCityList" != listName || mainMr == "0"){
      //20150402 期末期首課題対応No.227 HISOL鈴木 ADD END
        document.getElementById(btnRtnId).innerHTML = "<acronym title=\"担当なしへ戻す\">"
                + "<INPUT type=\"button\" name=\"bReset\" value=\"解除\" " + strEnabed
                + " onclick=\"jimResetFromMrTrt('" + listName
                + "', " + rowNo + ", '" + trtNo + "');\"></acronym>";
        document.getElementById(toInOutId).innerHTML = "&nbsp;";
      //20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
      }
      //20150402 期末期首課題対応No.227 HISOL鈴木 ADD END
    }
  }
  // ★へ変更の名称を変更
  if (Number(toMrNo) == 0) {
    var chgBtnId = listName + "[" + rowNo + "].chgBtn" + trtNo;
    document.getElementById(chgBtnId).value = "★を設定";
  }
}

/**
 * <pre>
 * 画面の情報が変更されたかどうかを判定します。
 * 変更されている場合、jkrMrChakerに「1:変更あり」を設定します。
 * </pre>
 * @param listName リスト名称
 * @param rowNo 行番号
 * @param trtNo 領域番号
 */
function jimCheckChangeInfo(listName, rowNo, trtNo) {

  // 変更前新担当MRNO
  var toMrNoBefId = listName + "[" + rowNo + "].toMrNoBef" + trtNo;
  var toMrNoBef = document.getElementsByName(toMrNoBefId)[0].value;

  // 変更後新担当MRNO
  var toMrNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var toMrNo = document.getElementsByName(toMrNoId)[0].value;

  // 変更前新組織コード
  var toSosCdBefId = listName + "[" + rowNo + "].toSosCdBef" + trtNo;
  var toSosCdBef	= document.getElementsByName(toSosCdBefId)[0].value;

  // 変更後新組織コード
  var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
  var toSosCd = document.getElementsByName(toSosCdId)[0].value;

  // 担当変更フラグ
  var changeFlgId = listName + "[" + rowNo + "].changeFlg" + trtNo;

  if (Number(toMrNoBef) != Number(toMrNo) || toSosCdBef != toSosCd ) {
    //20150402 期末期首課題対応No.227 HISOL鈴木 UPD START
    // 既に"9"(副担追加データ一括削除対象)が設定されている場合はそのままにする
    //document.getElementsByName(changeFlgId)[0].value = "1";
    if(document.getElementsByName(changeFlgId)[0].value == null || document.getElementsByName(changeFlgId)[0].value != "9"){
        document.getElementsByName(changeFlgId)[0].value = "1";
    }
    //20150402 期末期首課題対応No.227 HISOL鈴木 UPD END
    jkrMrChaker = 1;
    return false;
  } else {
    document.getElementsByName(changeFlgId)[0].value = "0";
  }
  
  // 作業途中のデータ有無を判定する。
  checkChange(listName);
}

/**
 * 作業途中のデータ有無を判定する。
 */
function checkChange(listName){
  jkrMrChaker = 0;
  var changeFlgId = "";
  var changeFlg = "";
  var maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  var maxCol = document.fm1.trtCount.value;
  for(var rowno=0; rowno<=maxRow && maxRow>=0; rowno++) {
    if (document.fm1.insSkninDispFlg.value == "1") {
      changeFlgId = listName + "[" + rowno + "].changeFlg";
      changeFlg = document.getElementsByName(changeFlgId)[0].value;
      if (changeFlg == "1") {
        jkrMrChaker = 1;
        return true;
      }
    }
      
    for(var trtno=1; trtno<=maxCol && maxCol>=1; trtno++) {
      changeFlgId = listName + "[" + rowno + "].changeFlg" + trtno;
      changeFlg = document.getElementsByName(changeFlgId)[0].value;
      //20150402 期末期首課題対応No.227 HISOL鈴木 UPD START
      //if (changeFlg == "1") {
      if (changeFlg == "1" || changeFlg == "9") {
      //20150402 期末期首課題対応No.227 HISOL鈴木 UPD END
          jkrMrChaker = 1;
          return true;
        }
    }
  }
  return false;
}

/**
 * <pre>
 * 組織・従業員選択ポップアップのコールバック関数。
 * 検索項目の「組織・担当(現)」の選択ボタン押下時に呼ばれます。
 * ポップアップで選択した値をフォームに設定します。
 * </pre>
 */
function jimCallBackFromCseView(
    sosCd, sosName,
    jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
    bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6,
    brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
    bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6,
    insDispRngFlg, sosTkyFlg
){
  
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  var disp = bumonSeiName2
           + ((bumonSeiName3 != "")?" ":"") + bumonSeiName3
           + ((bumonSeiName4 != "")?" ":"") + bumonSeiName4
           + ((bumonSeiName5 != "")?" ":"") + bumonSeiName5
           + ((bumonSeiName6 != "")?" ":"") + bumonSeiName6
           + ((jgiName != "")?" ":"") + jgiName;
  document.fm1.dispFromSosJgiName.value = disp;

  // 検索用現組織コード
  document.fm1.searchFromSosCd.value = sosCd;

  // 検索用用現組織名称
  document.fm1.searchFromSosName.value = bumonSeiName2
                                       + ((bumonSeiName3 != "")?" ":"") + bumonSeiName3
                                       + ((bumonSeiName4 != "")?" ":"") + bumonSeiName4
                                       + ((bumonSeiName5 != "")?" ":"") + bumonSeiName5
                                       + ((bumonSeiName6 != "")?" ":"") + bumonSeiName6;

  // 検索用従業員番号
  document.fm1.searchFromJgiNo.value = jgiNo;
  // 検索用従業員名
  document.fm1.searchFromJgiName.value = jgiName;
  // 施設表示範囲設定フラグ
  document.fm1.insDispRngFlg.value = insDispRngFlg;
  // 検索条件_現組織支店コード
  document.fm1.searchFromSosCd2.value = sosCd2;
  // 検索条件_現組織支店名称
  document.fm1.searchFromSosNm2.value = bumonSeiName2;
  // 検索条件_現組織の組織コード３
  document.fm1.searchFromSosCd3.value = sosCd3;
  // 検索条件_現組織の組織コード４
  document.fm1.searchFromSosCd4.value = sosCd4;
  // 施設表示範囲、検索_組織テキスト設定
  dispRngCtl(insDispRngFlg);
  // 武田市区郡POPパラメータ設定
  document.fm1.sosCdC040.value = sosCd;
  document.fm1.jgiNoC040.value = jgiNo;
  
  //トップメニューに戻った場合のため、変更された組織を保存する
  changeSosCdForTopMenu(1, bumonRank, sosCd2, sosCd3, sosCd4,bumonSeiName2, bumonSeiName3, bumonSeiName4);
}

/**
 * <pre>
 * 施設表示範囲フラグより、施設表示範囲の表示非表示をコントロールする
 * </pre>
 */
function dispRngCtl(insDispRngFlg) {
  // 初期化ページの場合、施設表示範囲を表示しないので、
  // リターンする
  if (document.fm1.pageFlag.value == "1") {
    return false;
  }
  //2014/12/10 施設表示範囲と組織のリスト選択はエラー画面では表示無し。
  if (document.fm1.gamenId.value != "JKR040C040") {
    document.fm1.insScope.value = "0";
    document.fm1.chgAddSosCd.value = "";
    document.fm1.chgAddSosName.value = "";
    if (insDispRngFlg == "1") {
      if (document.fm1.gamenId.value != "JKR040C020") {
        document.fm1.bSelectSos.disabled = true;
        document.getElementById("chgAddTable").style.display = "block";
      }
    } else {
      if (document.fm1.gamenId.value != "JKR040C020") {
        document.fm1.bSelectSos.disabled = true;
        document.getElementById("chgAddTable").style.display = "none";
      }
    }
  }
}

/**
 * <pre>
 * 施設表示範囲を変更するときに呼ばれます。
 * </pre>
 */
function changeInsScope() {
  if (document.fm1.insScope.value == "0") {
    document.fm1.bSelectSos.disabled = true;
    document.fm1.chgAddSosCd.value = "";
    document.fm1.chgAddSosName.value = "";
  } else {
    document.fm1.bSelectSos.disabled = false;
    document.fm1.chgAddSosCd.value = document.fm1.searchFromSosCd2.value;
    document.fm1.chgAddSosName.value = document.fm1.searchFromSosNm2.value;
  }
  return false;
}

/**
 * <pre>
 * 組織・従業員選択ポップアップのコールバック関数。
 * 検索項目の「組織・担当(新)」の選択ボタン押下時に呼ばれます。
 * ポップアップで選択した値をフォームに設定します。
 * </pre>
 */
function jimCallBackToCseView(
    sosCd, sosName,
    jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
    bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6,
    brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
    bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6,
    insDispRngFlg, sosTkyFlg
){
  
  // 組織従業員名称(表示用)
  var disp = bumonSeiName2
           + ((bumonSeiName3 != "")?" ":"") + bumonSeiName3
           + ((bumonSeiName4 != "")?" ":"") + bumonSeiName4
           + ((bumonSeiName5 != "")?" ":"") + bumonSeiName5
           + ((bumonSeiName6 != "")?" ":"") + bumonSeiName6
           + ((jgiName != "")?" ":"") + jgiName;

  document.fm1.dispToSosJgiName.value = disp;
  // 検索用新組織コード
  document.fm1.searchToSosCd.value = sosCd;
  // 検索条件_新組織コード(営業所）
  document.fm1.searchToSosCd3.value = sosCd3;
  // 検索用新組織名称
  document.fm1.searchToSosName.value = bumonSeiName2
                                     + ((bumonSeiName3 != "")?" ":"") + bumonSeiName3
                                     + ((bumonSeiName4 != "")?" ":"") + bumonSeiName4
                                     + ((bumonSeiName5 != "")?" ":"") + bumonSeiName5
                                     + ((bumonSeiName6 != "")?" ":"") + bumonSeiName6;
  // 検索用新従業員番号
  document.fm1.searchToJgiNo.value = jgiNo;
  // 検索用新従業員名
  document.fm1.searchToJgiName.value = jgiName;

  //トップメニューに戻った場合のため、変更された組織を保存する
  changeSosCdForTopMenu(2, bumonRank, sosCd2, sosCd3, sosCd4,bumonSeiName2, bumonSeiName3, bumonSeiName4);

}

/**
 * <pre>
 * 組織・従業員選択ポップアップのコールバック関数。
 * 検索項目の「組織名」の選択ボタン押下時に呼ばれます。
 * ポップアップで選択した値をフォームに設定します。
 * </pre>
 */
function jimCallBackSosCseView(
    sosCd, sosName,
    jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
    bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6,
    brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
    bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6,
    insDispRngFlg, sosTkyFlg
){
  var disp	=	bumonSeiName2
        + ((bumonSeiName3 != "")?" ":"") + bumonSeiName3
        + ((bumonSeiName4 != "")?" ":"") + bumonSeiName4
        + ((bumonSeiName5 != "")?" ":"") + bumonSeiName5
        + ((bumonSeiName6 != "")?" ":"") + bumonSeiName6;

  // 従業員名称(表示用)
  document.fm1.chgAddSosName.value	= disp;
  // 検索用組織コード
  document.fm1.chgAddSosCd.value = sosCd;
  

}

/**
 * <pre>
 * 組織・従業員選択ポップアップのコールバック関数。
 * 検索項目の「新担当者」の選択ボタン押下時に呼ばれます。
 * ポップアップで選択した値をフォームに設定します。
 * </pre>
 */
function jimCallBackChgCseView(
    sosCd, sosName,
    jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
    bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6,
    brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
    bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6,
    insDispRngFlg, sosTkyFlg
){
  
  // 新担当者
  document.fm1.changeJgiName.value = jgiName;
  // 新担当者_従業員番号番号
  document.fm1.changeJgiNo.value = jgiNo;
  // 新担当者_組織コード
  document.fm1.changeSosCd.value = sosCd;
  // 新担当者_組織名称
  document.fm1.changeSosName.value = bumonRyakuName1
                      + bumonRyakuName2
                      + bumonRyakuName3
                      + bumonRyakuName4;
  // 新担当者_新組織コード(所属営業所)
  document.fm1.changeSosCdDist.value = sosCd3;
  
  if (document.fm1.gamenId.value == "JKR040C010") {
    setAllChgBtnStatus010("chgInsTrtList");
  } else if (document.fm1.gamenId.value == "JKR040C020") {
  } else if (document.fm1.gamenId.value == "JKR040C030") {
    setAllChgBtnStatus("chgInsCityList");
  } else if (document.fm1.gamenId.value == "JKR040C040") {
    setAllChgBtnStatus010("chgInsTrtList");
  }
  
}

/**
 * <pre>
 * clear(リンク)押下時に呼ばれます。
 *@param name クリア項目名
 * </pre>
 */
function jimClear( name ) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 組織･担当(現)
  if ( name == 'fromSosJgi' ) {
    document.fm1.dispFromSosJgiName.value = "";
    document.fm1.searchFromSosCd.value = "";
    document.fm1.searchFromSosName.value = "";
    document.fm1.searchFromJgiNo.value = "";
    document.fm1.searchFromJgiName.value = "";
    document.fm1.sosCdC040.value = "";
    document.fm1.jgiNoC040.value = "";
    document.fm1.searchFromSosCd2.value = "";
    document.fm1.searchFromSosNm2.value = "";
    document.fm1.searchFromSosCd3.value = "";
    document.fm1.searchFromSosCd4.value = "";
    dispRngCtl("0");
    // 組織･担当(新)
  } else if ( name == 'toSosJgi' ) {
    document.fm1.dispToSosJgiName.value = "";
    document.fm1.searchToSosCd.value = "";
    document.fm1.searchToSosName.value = "";
    document.fm1.searchToJgiNo.value = "";;
    document.fm1.searchToJgiName.value = "";
    document.fm1.searchToSosCd3.value = "";

  // JIS府県武田市区郡
  } else if ( name == 'tkCity' ) {
    document.fm1.dispAddrNamePrefCity.value = "";
    document.fm1.searchAddrCodePref.value = "";
    document.fm1.searchTkCityCd.value = "";
    document.fm1.JISFk.value = "";
    //チェック済みのJIS府県・武田市区郡を消去
    document.getElementById('checkedJisCodes').innerHTML="";
  // 施設固定CD複数入力対応
  // 施設固定CD
  } else if ( name == 'searchInsNo' ) {
    document.fm1.searchInsNo.value = "";  //施設固定CD
    document.fm1.joinInsNo.value = "";
    if(document.fm1.bSearchInsNo.disabled == false){
      //関連項目を入力可にする
      document.fm1.searchInsName.disabled = false;  //施設名（漢字）
      document.fm1.searchInsName.style.backgroundColor = JKR_BG_COLOR_NORMAL;
      document.fm1.dispInsKana.disabled = false;  //施設名（全角カナ）
      document.fm1.dispInsKana.style.backgroundColor = JKR_BG_COLOR_NORMAL;
      document.fm1.searchHoInsType.disabled = false;  //対象区分
      if (document.fm1.trtGrpCd.value == '003') {
        document.fm1.searchVacVisitType.disabled = false;  //ワクチン区分
      } else {
        document.fm1.searchPharmType.disabled = false;  //施設区分
      }
      document.fm1.bCtcView.disabled = false;  //ＪＩＳ府県武田市区郡
    }
  } else if (name == "changeJgi") {
      document.fm1.changeJgiName.value = "";   //新担当者_テキスト
      document.fm1.changeJgiNo.value = "";     //新担当者_従業員番号番号
      document.fm1.changeSosCd.value = "";     //新担当者_組織コード
      document.fm1.changeSosName.value = "";   //新担当者_組織名称
      document.fm1.changeSosCdDist.value = ""; //新担当者_新組織コード(所属営業所)
      if (document.fm1.gamenId.value == "JKR040C010") {
        setAllChgBtnStatus010("chgInsTrtList");
      } else if (document.fm1.gamenId.value == "JKR040C020") {
      } else if (document.fm1.gamenId.value == "JKR040C030") {
        setAllChgBtnStatus("chgInsCityList");
      } else if (document.fm1.gamenId.value == "JKR040C040") {
        setAllChgBtnStatus010("chgInsTrtList");
      }
  } else if (name == 'chgAddSos') {
    document.fm1.chgAddSosName.value = "";  // 従業員名称(表示用)
    document.fm1.chgAddSosCd.value = "";    // 検索用組織コード
  }
}

/**
 * 組織・従業員選択画面へのパラメータを設定します。
 *@param winName 呼び出し元項目名
 */
function jimSetParamCseView( winName ){

  // 組織・担当(現)・組織・担当(新)
  if (winName == "gCseViewFromWin" 
    || winName == "gCseViewToWin") {
    document.fm1.selectFlgPop.value = "3"; // 選択区分(組織・従業員選択)
  } else if (winName == "gCseViewSosWin") {
    document.fm1.selectFlgPop.value = "1"; // 選択区分(組織)
  } else {
    document.fm1.selectFlgPop.value = "2"; // 選択区分(従業員選択)
  }
  //  組織・担当(現)
  if (winName == "gCseViewFromWin") {
    if (document.fm1.searchFromSosCd.value != null && document.fm1.searchFromSosCd.value != "") {
      document.fm1.initSosCdPop.value = document.fm1.searchFromSosCd.value;  // 初期表示組織
    } else {
      document.fm1.initSosCdPop.value = document.fm1.selectedSosCd.value;  // 初期表示組織
    }
  // 組織・担当(新)
  } else if(winName == "gCseViewToWin" || winName == "gCseViewChgWin"){
    if (document.fm1.searchToSosCd.value != null && document.fm1.searchToSosCd.value != "") {
      document.fm1.initSosCdPop.value = document.fm1.searchToSosCd.value;  // 初期表示組織
    } else {
      document.fm1.initSosCdPop.value = document.fm1.selectedSosCd.value;  // 初期表示組織
    }
  // 組織
  } else if(winName == "gCseViewSosWin"){
    document.fm1.initSosCdPop.value = document.fm1.searchFromSosCd2.value;
  } else {
//    var toSosCdDistId = document.fm1.listName.value + "[" 
//        + document.fm1.poprowno.value + "].toSosCdDist"
//        + document.fm1.poptrtno.value;
    var toSosCdId = document.fm1.listName.value + "[" 
                    + document.fm1.poprowno.value + "].toSosCd"
                    + document.fm1.poptrtno.value;
    var summarySosCdId = document.fm1.listName.value + "[" 
                         + document.fm1.poprowno.value + "].summarySosCd"
                         + document.fm1.poptrtno.value;
//    var toSosCdDist = document.getElementsByName(toSosCdDistId)[0].value;
    var toSosCd = document.getElementsByName(toSosCdId)[0].value;
    var summarySosCd = document.getElementsByName(summarySosCdId)[0].value;
//    if (toSosCdDist != null && toSosCdDist != "") {
//        document.fm1.initSosCdPop.value = toSosCdDist;
    if (toSosCd != null && toSosCd != "") {
        document.fm1.initSosCdPop.value = toSosCd;
    } else if (summarySosCd != null && summarySosCd != "") {
      document.fm1.initSosCdPop.value = summarySosCd;
    } else {
      document.fm1.initSosCdPop.value = document.fm1.selectedSosCd.value;
    }
  }
  if (winName == "gCseViewFromWin" || winName == "gCseViewSosWin") {
    document.fm1.sosKbnPop.value = "1";  // 組織区分
  } else {
    document.fm1.sosKbnPop.value = "2";  // 組織区分
  }
  if (winName == "gCseViewToJgiWin" && document.fm1.poptrtno.value == "") {
    document.fm1.sknnFlgPop.value = "1";  // 施設責任者フラグ
  } else {
    document.fm1.sknnFlgPop.value = "0";  // 施設責任者フラグ
  }
  document.fm1.insFlgPop.value = "0";  // 施設担当者フラグ
  document.fm1.topMenuFlgPop.value = "0";  // トップメニューフラグ
  if (winName == "gCseViewFromWin" 
      || winName == "gCseViewToWin"
      || winName == "gCseViewSosWin") {
    document.fm1.authorityPop.value = "";  // 権限
  } else {
    document.fm1.authorityPop.value = "1";  // 権限
  }
  if (winName == "gCseViewSosWin") {
    document.fm1.bumonRankTopPop.value = "2";  // 部門ランク(最上位)
    document.fm1.bumonRankBtmPop.value = "4";  // 部門ランク(最下位)
    document.fm1.topSosCdPop.value = document.fm1.searchFromSosCd2.value;  // 最上位組織コード
    document.fm1.defTblFlgPop.value = "0";  // 定義テーブル使用フラグ
    document.fm1.actSosListPop.value = document.fm1.sosCdHairetu.value;  // 代行組織リスト
    document.fm1.shokushuFlgPop.value = "0";  // 職種指定フラグ
  } else {
    document.fm1.bumonRankTopPop.value = "";  // 部門ランク(最上位)
    document.fm1.bumonRankBtmPop.value = "";  // 部門ランク(最下位)
    document.fm1.topSosCdPop.value = "";  // 最上位組織コード
    document.fm1.defTblFlgPop.value = "1";  // 定義テーブル使用フラグ
    document.fm1.actSosListPop.value = document.fm1.sosCdHairetu.value;  // 代行組織リスト
    document.fm1.shokushuFlgPop.value = "1";  // 職種指定フラグ
  } 
  if (winName == "gCseViewFromWin") {
    document.fm1.ztTntFlgPop.value = "1";  // 雑担当者表示フラグ
  } else {
    document.fm1.ztTntFlgPop.value = "0";  // 雑担当者表示フラグ
  }
  if (winName == "gCseViewSosWin") {
    document.fm1.jokenSetCdPop.value = document.fm1.selectedJgiJoken.value;  // 条件セットコード
    document.fm1.menuTrtGrpCdPop.value = "";  // 選択領域グループ(メニュー)
    document.fm1.menuSosCdPop.value = "";  // 選択組織(メニュー)
    document.fm1.selectableBumonrankPop.value = "2";  // 選択可能部門ランク
    document.fm1.insNoPop.value = "";  // 施設固定コード
    document.fm1.trtCdPop.value = "";  // 領域コード
  } else {
    document.fm1.jokenSetCdPop.value = document.fm1.selectedJgiJoken.value;  // 条件セットコード
    document.fm1.menuTrtGrpCdPop.value = document.fm1.trtGrpCd.value;  // 選択領域グループ(メニュー)
    document.fm1.menuSosCdPop.value = "";  // 選択組織(メニュー)
    document.fm1.selectableBumonrankPop.value = "";  // 選択可能部門ランク
    document.fm1.insNoPop.value = "";  // 施設固定コード
    document.fm1.trtCdPop.value = "";  // 領域コード
  }
  if (winName == "gCseViewFromWin" 
    || winName == "gCseViewSosWin") {
    document.fm1.sosCdFromPop.value = "";  // 現組織コード
  // 20150202 HISOL Suzuki 本番課題No.25対応 MOD START
  //} else {
  } else if(winName == "gCseViewToWin"){
    document.fm1.sosCdFromPop.value = document.fm1.searchFromSosCd.value;  // 現組織コード
  } else {
    // 一覧の従業員選択リンクでは表示ボタン押下時点の選択組織を使用する
    document.fm1.sosCdFromPop.value = document.fm1.searchFromSosCdPop.value;  // 現組織コード
  // 20150202 HISOL Suzuki 本番課題No.25対応 MOD END
  }

// 20150202 HISOL Suzuki 本番課題No.25対応 ADD START
  //if ((winName == "gCseViewToJgiWin" && document.fm1.poptrtno.value != "")
  if (winName == "gCseViewToJgiWin"
        || winName == "gCseViewChgWin") {
      document.fm1.sosCdToPop.value = document.fm1.searchToSosCdPop.value;  // 新組織コード
      document.fm1.trtTntFlgPop.value = 1; // 領域担当者フラグ

      if (winName == "gCseViewToJgiWin" && document.fm1.poptrtno.value != "") {
          var trtCdId = document.fm1.listName.value + "[" 
                        + document.fm1.poprowno.value + "].trtCd"
                        + document.fm1.poptrtno.value;
          var trtCd = document.getElementsByName(trtCdId)[0].value;
          document.fm1.trtCdPop.value = trtCd;  // 領域コード
      }
  } else {
      document.fm1.sosCdToPop.value = "";  // 新組織コード
      document.fm1.trtTntFlgPop.value = 0; // 領域担当者フラグ
      document.fm1.trtCdPop.value = "";    // 領域コード
  }
// 20150202 HISOL Suzuki 本番課題No.25対応 ADD END
}

/**
 * <pre>
 * 領域の新担当者の変更ボタン押下時に呼ばれます。
 * </pre>
 * @param listName リスト名称
 * @param rowNo 行番号
 * @param trtNo 領域番号
 */
function jimReplaceToMrTrt(listName, rowNo, trtNo) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 変更担当者
  var changeJgiName = document.fm1.changeJgiName.value;
  var changeJgiNo = document.fm1.changeJgiNo.value;
  var changeSosCd = document.fm1.changeSosCd.value;
  var changeSosName = document.fm1.changeSosName.value;
  var changeSosCdDist = document.fm1.changeSosCdDist.value;

  // 変更担当者欄に指定しているMRを新担当に置き換える
  if ( changeJgiName != null && changeJgiName != "") {
    // 新担当MR名称(表示用)
    var toJgiNameId = listName + "[" + rowNo + "].toJgiName" + trtNo;
    document.getElementsByName(toJgiNameId)[0].value = changeJgiName;
    // 新担当MRNO(HIDDEN用)
    var toJgiNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
    document.getElementsByName(toJgiNoId)[0].value = changeJgiNo;
    // 新組織コード(HIDDEN用)
    var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
    document.getElementsByName(toSosCdId)[0].value = changeSosCd;
    // 新組織名称(HIDDEN用)
    var toSosNameId = listName + "[" + rowNo + "].toSosName" + trtNo;
    document.getElementsByName(toSosNameId)[0].value = changeSosName;
    // 新組織コード(所属営業所)(HIDDEN用)
    var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist" + trtNo;
    document.getElementsByName(toSosCdDistId)[0].value = changeSosCdDist;
    // 画面表示用
    if (trtNo != "") {
      var spanToSosNameDispId = listName + "[" + rowNo + "].spanToSosName" + trtNo;
      document.getElementById(spanToSosNameDispId).innerText = changeSosName;
    }
    var spanToJigiNameDispId = listName + "[" + rowNo + "].spanToJgiName" + trtNo;
    document.getElementById(spanToJigiNameDispId).innerText = changeJgiName;
    // ★へ変更の名称を変更
    var chgBtnId = listName + "[" + rowNo + "].chgBtn" + trtNo;
    document.getElementById(chgBtnId).value = "★へ変更";
    // 変更情報チェック
    jimCheckChangeInfo(listName, rowNo, trtNo);

    // 新担当と現担当が同じかどうかをチェック
    jimChkMrNo(listName, rowNo, trtNo);
    
  // 変更担当者指定無しの場合はアラート表示
  } else {
    alert(gMsg[3]);
  }
}

/**
 * <pre>
 * 領域の新担当者の戻るボタン押下時に呼ばれます。
 * </pre>
 * @param listName リスト名称
 * @param rowNo 行番号
 * @param trtNo 領域番号
 */
function jimResetFromMrTrt(listName, rowNo, trtNo) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 新担当MRNO(HIDDEN用)
  var toJgiNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var fromJgiNoId = listName + "[" + rowNo + "].fromMrNo" + trtNo;
  document.getElementsByName(toJgiNoId)[0].value = document.getElementsByName(fromJgiNoId)[0].value;
  // 新担当MR名称(表示用)
  var toJgiNameId = listName + "[" + rowNo + "].toJgiName" + trtNo;
  var fromJgiNameId = listName + "[" + rowNo + "].fromJgiName" + trtNo;
  var toJgiName = document.getElementsByName(fromJgiNameId)[0].value;
  var toMrNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var toMrNo = document.getElementsByName(toMrNoId)[0].value;
  if (toMrNo == "") {
    toJgiName = "担当者選択";
  }
  document.getElementsByName(toJgiNameId)[0].value = toJgiName;
  // 新組織コード(HIDDEN用)
  var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
  var fromSosCdId = listName + "[" + rowNo + "].fromSosCd" + trtNo;
  document.getElementsByName(toSosCdId)[0].value = document.getElementsByName(fromSosCdId)[0].value;
  // 新組織名称(HIDDEN用)
  var toSosNameId = listName + "[" + rowNo + "].toSosName" + trtNo;
  //20150303 ST-B-367対応 HISOL鈴木 MOD START
  //var fromSosNameId = listName + "[" + rowNo + "].fromSosName" + trtNo;
  var fromSosNameId = listName + "[" + rowNo + "].toSosNameBef" + trtNo;
  //20150303 ST-B-367対応 HISOL鈴木 MOD END
  document.getElementsByName(toSosNameId)[0].value = document.getElementsByName(fromSosNameId)[0].value;
  // 新組織コード(所属営業所)(HIDDEN用)
  var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist" + trtNo;
  var summarySosCdId = listName + "[" + rowNo + "].summarySosCd" + trtNo;
  document.getElementsByName(toSosCdDistId)[0].value = document.getElementsByName(summarySosCdId)[0].value;
  // 画面表示用
  if (trtNo != "") {
    var spanToSosNameDispId = listName + "[" + rowNo + "].spanToSosName" + trtNo;
    //2014/12/16 戻すボタン押下で「担当者選択」となる場合、組織名もクリア
    if (toMrNo == "") {
        document.getElementById(spanToSosNameDispId).innerText = "";
    }else{
        document.getElementById(spanToSosNameDispId).innerText = document.getElementsByName(fromSosNameId)[0].value;
    }
  }
  var spanToJigiNameDispId = listName + "[" + rowNo + "].spanToJgiName" + trtNo;
  document.getElementById(spanToJigiNameDispId).innerText = toJgiName;
  
  //20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
  // 現担当者がダミー(従業員区分 = "8")の場合、changeFlgを"9"(副担追加データ一括削除対象)にしておく。
  // ※現担当がダミーユーザの行において一度「元に戻す」をしたら副担追加データを削除するため。
  // 現担当者従業員区分
  var fromJgiKbId = listName + "[" + rowNo + "].fromJgiKb" + trtNo;
  var fromJgiKb = document.getElementsByName(fromJgiKbId)[0].value;
  // 背景色ランク
  var bgColorRnkId = listName + "[" + rowNo + "].bgColorRnk" + trtNo;
  var bgColorRnk = document.getElementsByName(bgColorRnkId)[0].value;
  // 担当変更フラグ
  var changeFlgId = listName + "[" + rowNo + "].changeFlg" + trtNo;
  if (fromJgiKb == "8" && bgColorRnk != ""){
    document.getElementsByName(changeFlgId)[0].value = "9";
  }
  //20150402 期末期首課題対応No.227 HISOL鈴木 ADD END

  // 変更情報チェック
  jimCheckChangeInfo(listName, rowNo, trtNo);
  // 新担当と現担当が同じかどうかをチェック
  jimChkMrNo(listName, rowNo, trtNo);
}

/**
 * <pre>
 * 展開方法の内容変更時に呼ばれます。
 * </pre>
 */
function jimChgDeveWay() {
  // 市区郡・領域別
  if (document.fm1.searchDeveWay.value == "1") {
    //関連項目をクリアし、入力付加にする
    document.fm1.insChg.disabled = true;  //担当先
    document.fm1.insChg.value = "0";
    document.fm1.searchInsName.disabled = true;  //施設名（漢字）
    document.fm1.searchInsName.value = "";
    document.fm1.searchInsName.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    document.fm1.dispInsKana.disabled = true;  //施設名（全角カナ）
    document.fm1.dispInsKana.value = "";
    document.fm1.dispInsKana.style.backgroundColor = JKR_BG_COLOR_DISABLED;
    document.fm1.bSearchInsNo.disabled = true;  // 施設固定C
    document.fm1.searchInsNo.value = "";  //施設固定CD
    document.fm1.joinInsNo.value = "";
    document.fm1.searchHoInsType.disabled = false;  //対象区分
    if (document.fm1.trtGrpCd.value == '003') {
      document.fm1.searchVacVisitType.disabled = true;  //ワクチン区分
      document.fm1.searchVacVisitType.value ="0";
    } else {
      document.fm1.searchPharmType.disabled = true;  //施設区分
      document.fm1.searchPharmType.value ="0";
    }
    document.fm1.bCtcView.disabled = false;  //ＪＩＳ府県武田市区郡
  } else {
    document.fm1.insChg.disabled = false;  //担当先
    document.fm1.bSearchInsNo.disabled = false;  //施設固定C
    document.fm1.searchInsName.disabled = false;  //施設名（漢字）
    document.fm1.searchInsName.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    document.fm1.dispInsKana.disabled = false;  //施設名（全角カナ）
    document.fm1.dispInsKana.style.backgroundColor = JKR_BG_COLOR_NORMAL;
    document.fm1.searchHoInsType.disabled = false;  //対象区分
    if (document.fm1.trtGrpCd.value == '003') {
      document.fm1.searchVacVisitType.disabled = false;  //ワクチン区分
    } else {
      document.fm1.searchPharmType.disabled = false;  //施設区分
    }
  }
}

/**
 * ★へ変更ボタン活性非活性を設定する。
 */
function setAllChgBtnStatus(listName){
  var maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  var maxCol = document.fm1.trtCount.value;

  // 施設責任者
  for(var rowno=0; rowno<= maxRow && maxRow >= 0; rowno++) {	
      setChgBtnStatus(listName, rowno, "");
  }

  // 領域毎
  for(var trtno=1; trtno <= maxCol && maxCol >= 1; trtno++) {
    for(var rowno=0; rowno<= maxRow && maxRow >= 0; rowno++) {	
      setChgBtnStatus(listName, rowno, trtno);
    }
  }
}

function setChgBtnStatus(listName, rowno, trtno){
  var chgBtnId = "";
  var statusId = "";
  var status = "";
  var linkFlgId = "";
  var linkFlg = "";
  linkFlgId = listName + "[" + rowno + "].linkFlg" + trtno;
  if (document.getElementsByName(linkFlgId)[0] == null) {
    return;
  } else {
  }
  linkFlg = document.getElementsByName(linkFlgId)[0].value;
  
  // 更新権限がなければ、設定しない。
  if (linkFlg != "1") {
    return;
  }
  
  chgBtnId = listName + "[" + rowno + "].chgBtn" + trtno;
  if (document.getElementsByName(chgBtnId)[0] == null) {
    return;
  } else {
  }
  //新担当未選択の場合、非活性
  if (document.fm1.changeJgiNo.value == "") {
    document.getElementsByName(chgBtnId)[0].disabled = true;
  } else {
    statusId = listName + "[" + rowno + "].status" + trtno;
    status = document.getElementsByName(statusId)[0].value;
    // ステタース30あるいは50以上の場合、非活性
    if (status == "30" || status >= "50") {
      document.getElementsByName(chgBtnId)[0].disabled = true;
    } else {
      document.getElementsByName(chgBtnId)[0].disabled = false;
    }
  }
}
