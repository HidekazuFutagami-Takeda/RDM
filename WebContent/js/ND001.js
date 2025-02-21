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


  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
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
function jimSort(sortCondition){
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;

  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = 1;

  //ソート区分設定
  document.fm1.sortCondition.value = sortCondition;

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
  if ( name == 'Sos' ) {
	document.fm1.bumonSeiName.value = "";
  }
}

function jimClearAll(mrAdminFlg) {
	  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	  //作成中

	  document.fm1.searchDocName.value = "";
	  document.fm1.searchDocKana.value = "";
	  document.fm1.searchDocNo.value = "";
	  document.fm1.searchDcfIshiCd.value = "";

	  document.fm1.searchMedSch.value = "";
	  document.fm1.searchGradYear.value = "";
	  document.fm1.searchHUniv.value = "";
	  document.fm1.searchSetsuzoku.value = "";
	  document.fm1.searchInsNo.value = "";

	  if(mrAdminFlg.value == "1") {
		  document.fm1.searchDocType.value = "";
		  document.fm1.searchDocAttribute.value = "";
		  document.fm1.bumonSeiName.value = "";
		  document.fm1.jgiName.value = "";
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

//***************************************************************************//
//*						共通イベント関数									*//
//***************************************************************************//

/**
* <pre>
*  全メッセージ格納用配列
* 当画面で使用する全メッセージが格納されます。
* </pre>
*/
var gMsg = new Array();


/**
* <pre>
*  組織名の表示／非表示の切り替え
* 組織(リンク)押下時に呼ばれます。
* </pre>
* @param dspFlg 表示フラグ(0:非表示, 1:表示)
* @param sosFlg 制御組織フラグ(1:現担当組織, 2:新担当組織)
* @param trtIdx 領域ンデクス(１０まで) *
*/
function dspSosName(dspFlg, sosFlg, trtIdx){

if(dspFlg == 1){
  dsp1 = "none";
  dsp2 = "block";
} else {
  dsp1 = "block";
  dsp2 = "none";
}


//alert(sosFlg);
if(sosFlg == 1){
  //現担当組織
  dspTableCtrlData("titleFromSosName" + trtIdx	,dsp2);
  dspTableCtrlData("titleFromSosNameLink"+ trtIdx	,dsp1);
  dspTableCtrlData("titleFromJgiName"+ trtIdx	,dsp2);

  dspTableCtrlData("dataFromSosName" + trtIdx	,dsp2);

}else{

  //dspTableCtrlData("titleToSosNameLinkb"+ trtIdx	,dsp1);

    //新担当組織
    dspTableCtrlData("titleToSosName" + trtIdx	,dsp2);

    dspTableCtrlData("dataToSosName" + trtIdx	,dsp2);

    dspTableCtrlData("titleToSosNameLink"+ trtIdx	,dsp1);

    dspTableCtrlData("titleToJgiName"+ trtIdx	,dsp2);

}

if(document.getElementById("titleFromSosNameLink" + trtIdx).style.display == "block"
  || document.getElementById("titleFromJgiName" + trtIdx).style.display == "block"){

  dspTableCtrlData("dataFromSosNameLink"+ trtIdx	,"block");
}else{
  dspTableCtrlData("dataFromSosNameLink"+ trtIdx	,"none");
}


if(document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"
  || document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){

  dspTableCtrlData("dataToSosNameLink"+ trtIdx	,"block");
}else{

  dspTableCtrlData("dataToSosNameLink"+ trtIdx	,"none");
}


if(document.getElementsByName("dataToSosNameLink" + trtIdx)[0].style.display == "block"){
  dspTableCtrlData("btnToSosName"+ trtIdx	,"block");
  dspTableCtrlData("btnToSosNameb"+ trtIdx,"block");
}else{
  dspTableCtrlData("btnToSosName"+ trtIdx	,"none");
  dspTableCtrlData("btnToSosNameb"+ trtIdx,"none");
}

dspTableTitleWidthCtrl(trtIdx);
dspTableDataWidthCtrl(trtIdx);


}

/**
* <pre>
*  従業員の表示／非表示の切り替え
* 従業員(リンク)押下時に呼ばれます。
* </pre>
* @param dspFlg 表示フラグ(0:非表示, 1:表示)
* @param trtIdx 領域インデクス(１０まで) *
*/
function dspJgiName(dspFlg, trtIdx){
if(dspFlg == 1){
  dsp1 = "none";
  dsp2 = "block";
  //現担当Title
  dspTableCtrlData("titleFromHeader" + trtIdx	,dsp2);
  dspTableCtrlData("titleFromHeaderLink"+ trtIdx	,dsp1);
  dspTableCtrlData("titleToHeader"+ trtIdx	,dsp2);

  //現担当組織名称
  dspTableCtrlData("titleFromSosName" + trtIdx	,dsp1);
  dspTableCtrlData("titleFromSosNameLink"+ trtIdx	,dsp2);
  dspTableCtrlData("titleFromJgiName"+ trtIdx	,dsp1);

  dspTableCtrlData("dataFromSosName" + trtIdx	,dsp1);
  dspTableCtrlData("dataFromSosNameLink"+ trtIdx	,dsp2);

} else {
  dsp1 = "block";
  dsp2 = "none";
  //現担当Title
  dspTableCtrlData("titleFromHeader" + trtIdx	,dsp2);
  dspTableCtrlData("titleFromHeaderLink"+ trtIdx	,dsp1);
  dspTableCtrlData("titleToHeader"+ trtIdx	,dsp2);

  //現担当組織名称
  dspTableCtrlData("titleFromSosName" + trtIdx	,dsp2);
  dspTableCtrlData("titleFromSosNameLink"+ trtIdx	,dsp2);
  dspTableCtrlData("titleFromJgiName"+ trtIdx	,dsp2);

  dspTableCtrlData("dataFromSosName" + trtIdx	,dsp2);
  dspTableCtrlData("dataFromSosNameLink"+ trtIdx	,dsp2);
}



//if(document.getElementById("titleFromHeader" + trtIdx).style.display == "block"
//   || document.getElementById("titleFromSosName" + trtIdx).style.display == "block"
//   || document.getElementById("titleFromSosNameLink" + trtIdx).style.display == "block"
//   || document.getElementById("titleFromJgiName" + trtIdx).style.display == "block"){
//  //新担当組織
//  dspTableCtrlData("titleToSosName" + trtIdx	,"block");
//  dspTableCtrlData("dataToSosName" + trtIdx	,"block");
//
//  dspTableCtrlData("titleToJgiName"+ trtIdx	,"block");
//
//  dspTableCtrlData("titleToSosNameLink"+ trtIdx	,"none");
//}
//else{
//  //新担当組織
//  dspTableCtrlData("titleToSosName" + trtIdx	,"none");
//  dspTableCtrlData("dataToSosName" + trtIdx	,"none");
//
//  dspTableCtrlData("titleToJgiName"+ trtIdx	,"none");
//  dspTableCtrlData("titleToSosNameLink"+ trtIdx	,"block");
//}
//
//
//
//if(document.getElementById("titleFromSosNameLink" + trtIdx).style.display == "block"
//  || document.getElementById("titleFromJgiName" + trtIdx).style.display == "block"){
//
//  dspTableCtrlData("dataFromSosNameLink"+ trtIdx	,"block");
//}else{
//  dspTableCtrlData("dataFromSosNameLink"+ trtIdx	,"none");
//}
//
//
//if(document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"
//  || document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){
//
//  dspTableCtrlData("dataToSosNameLink"+ trtIdx	,"block");
//}else{
//
//  dspTableCtrlData("dataToSosNameLink"+ trtIdx	,"none");
//}
//
//if(document.getElementsByName("dataToSosNameLink" + trtIdx)[0].style.display == "block" ){
//  dspTableCtrlData("btnToSosName"+ trtIdx	,"block");
//  dspTableCtrlData("btnToSosNameb"+ trtIdx,"block");
//}else{
//  dspTableCtrlData("btnToSosName"+ trtIdx	,"none");
//  dspTableCtrlData("btnToSosNameb"+ trtIdx,"none");
//}

dspTableTitleWidthCtrl(trtIdx);
dspTableDataWidthCtrl(trtIdx);

}

function dspTableTitleWidthCtrl(trtIdx){
var temp1 = 0;
var temp2 = 0;
var sum = 0;

if(document.getElementById("titleFromSosNameLink" + trtIdx).style.display == "block"){

  document.getElementById("titleFromSosNameLink" + trtIdx).colSpan = "30";
  temp1 = 30;

}else if(document.getElementById("titleFromSosName" + trtIdx).style.display == "block" && document.getElementById("titleFromJgiName" + trtIdx).style.display == "block"){

  document.getElementById("titleFromSosName" + trtIdx).colSpan = "25";
  document.getElementById("titleFromJgiName" + trtIdx).colSpan = "25";
  temp1 = 50;
}

if(document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"){

  document.getElementById("titleToSosNameLink" + trtIdx).colSpan = "50";
  temp2 = 50;

}else if(document.getElementById("titleToSosName" + trtIdx).style.display == "block" && document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){
  document.getElementById("titleToSosName" + trtIdx).colSpan = "20";
  document.getElementById("titleToJgiName" + trtIdx).colSpan = "50";
  temp2 = 70;

}

if(document.getElementById("titleFromHeaderLink" + trtIdx).style.display == "block"){

  sum = 20 + temp1 + temp2;
  document.getElementById("titleFromHeaderLink" + trtIdx).colSpan = sum + "";

}
else{

  document.getElementById("titleFromHeader" + trtIdx).colSpan = temp1 + "";
  sum = 20 + temp2;
  document.getElementById("titleToHeader" + trtIdx).colSpan = sum + "";
}
//alert("sum =" + sum);
sum = 20 + temp1 + temp2;
document.getElementById("titleTrtName" + trtIdx).colSpan = sum +"";

if( document.getElementById("titleFromSosName" + trtIdx).style.display == "block"
  && document.getElementById("titleFromJgiName" + trtIdx).style.display == "block"
    && document.getElementById("titleToSosName" + trtIdx).style.display == "block"
  && document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){

  document.getElementById("titleTrtName" + trtIdx).style.width = "650px";

}else if(document.getElementById("titleFromSosName" + trtIdx).style.display == "block"
       && document.getElementById("titleFromJgiName" + trtIdx).style.display == "block"
       && document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"){

  document.getElementById("titleTrtName" + trtIdx).style.width = "500px";

}else if(document.getElementById("titleFromSosNameLink" + trtIdx).style.display == "block"
       && document.getElementById("titleToSosName" + trtIdx).style.display == "block"
       && document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){
  document.getElementById("titleTrtName" + trtIdx).style.width = "500px";

}else if(document.getElementById("titleFromSosNameLink" + trtIdx).style.display == "block"
       && document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"){

  document.getElementById("titleTrtName" + trtIdx).style.width = "450px";

}else if(document.getElementById("titleToSosName" + trtIdx).style.display == "block"
         && document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){

  document.getElementById("titleTrtName" + trtIdx).style.width = "400px";

}else if(document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"){

  document.getElementById("titleTrtName" + trtIdx).style.width = "350px";
}
}

function dspTableDataWidthCtrl(trtIdx){

if( document.getElementById("titleFromSosName" + trtIdx).style.display == "block"
  && document.getElementById("titleFromJgiName" + trtIdx).style.display == "block"
    && document.getElementById("titleToSosName" + trtIdx).style.display == "block"
  && document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){

  dspTableDataCtrl("dataFromSosName" + trtIdx, "110");
  dspTableDataCtrl("dataFromSosNameLink" + trtIdx, "110");
  dspTableDataCtrl("dataToSosName" + trtIdx, "90");
  dspTableDataCtrl("dataToSosNameLink" + trtIdx, "120");

}else if(document.getElementById("titleFromSosName" + trtIdx).style.display == "block"
       && document.getElementById("titleFromJgiName" + trtIdx).style.display == "block"
       && document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"){

  dspTableDataCtrl("dataFromSosName" + trtIdx, "95");
  dspTableDataCtrl("dataFromSosNameLink" + trtIdx, "100");
  dspTableDataCtrl("dataToSosNameLink" + trtIdx, "100");

}else if(document.getElementById("titleFromSosNameLink" + trtIdx).style.display == "block"
       && document.getElementById("titleToSosName" + trtIdx).style.display == "block"
       && document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){

  dspTableDataCtrl("dataFromSosNameLink" + trtIdx, "120");
  dspTableDataCtrl("dataToSosName" + trtIdx, "75");
  dspTableDataCtrl("dataToSosNameLink" + trtIdx, "100");

}else if(document.getElementById("titleFromSosNameLink" + trtIdx).style.display == "block"
       && document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"){

  dspTableDataCtrl("dataFromSosNameLink" + trtIdx, "130");
  dspTableDataCtrl("dataToSosNameLink" + trtIdx, "115");

}else if(document.getElementById("titleToSosName" + trtIdx).style.display == "block"
         && document.getElementById("titleToJgiName" + trtIdx).style.display == "block"){

  dspTableDataCtrl("dataToSosName" + trtIdx, "80");
  dspTableDataCtrl("dataToSosNameLink" + trtIdx, "120");

}else if(document.getElementById("titleToSosNameLink" + trtIdx).style.display == "block"){

  dspTableDataCtrl("dataToSosNameLink" + trtIdx, "140px");
}
}

function dspTableDataCtrl(id, width){

var elementLst = document.getElementsByName(id);
for(var i = 0; i < elementLst.length; i++){
  elementLst[i].style.width = width;
}
}


function dspTableCtrlData(id, dspFlg){
document.getElementById(id).style.display = dspFlg;

var elementLst = document.getElementsByName(id);
for(var i = 0; i < elementLst.length; i++){
  elementLst[i].style.display = dspFlg;
}
}

function dspTableCtrlDataWidth(id, widthSize){
if(document.getElementById(id).firstChild){
  document.getElementById(id).style.width = widthSize;
}
}

//***************************************************************************//
//*						ポップアップイベント関数							*//
//***************************************************************************//

/**
* ポップアップ用ウィンドウオブジェクト
*/
var gCseViewChgWin		= null;		// 組織従業員選択(変更担当者)
var gCseViewSosWin		= null;		// 組織従業員選択(組織名(担当追加用))
var gCseViewToJgiWin	= null;		// 組織従業員選択(新担当者)
var gIcrReferViewWin	= null;		// [施設責任者].[従業員名]

/**
* ポップアップ選択行ID
*/
var gCseViewSelId		= null;


/**
* 組織・従業員選択画面へのパラメータを設定します。
*@param winName 呼び出し元項目名
*/
function jimSetParamCseViewData( winName ){


// 組織名
  if(winName == "gCseViewSosWin"){
    document.fm1.selectFlgPop.value = "1"; // 選択区分

    document.fm1.initSosCdPop.value = document.fm1.searchFromSosCd.value;  // 初期表示組織

    document.fm1.sosKbnPop.value = "1";  // 組織区分

    document.fm1.sknnFlgPop.value = "0";  // 施設責任者フラグ
    document.fm1.insFlgPop.value = "0";  // 施設担当者フラグ
    document.fm1.topMenuFlgPop.value = "0";  // トップメニューフラグ
    document.fm1.authorityPop.value = "";  // 権限
    document.fm1.bumonRankTopPop.value = "2";  // 部門ランク(最上位)
    document.fm1.bumonRankBtmPop.value = "4";  // 部門ランク(最下位)
    document.fm1.topSosCdPop.value = document.fm1.searchFromSosCd.value;  // 最上位組織コード
    document.fm1.defTblFlgPop.value = "0";  // 定義テーブル使用フラグ
    document.fm1.actSosListPop.value = document.fm1.sosCdHairetu.value;  // 代行組織リスト
    document.fm1.shokushuFlgPop.value = "0";  // 職種指定フラグ

    document.fm1.ztTntFlgPop.value = "0";  // 雑担当者表示フラグ

    document.fm1.jokenSetCdPop.value = "";  // 条件セットコード
    document.fm1.menuTrtGrpCdPop.value = "";  // 選択領域グループ(メニュー)
    document.fm1.menuSosCdPop.value = "";  // 選択組織(メニュー)
    document.fm1.selectableBumonrankPop.value = "2";  // 選択可能部門ランク
    document.fm1.insNoPop.value = "";  // 施設固定コード
    document.fm1.trtCdPop.value = "";  // 領域コード

    document.fm1.sosCdFromPop.value = "";  // 現組織コード

  // 20150202 HISOL Suzuki 本番課題No.25対応 ADD START
    document.fm1.sosCdToPop.value = "";  // 新組織コード
    document.fm1.trtTntFlgPop.value = 0; // 領域担当者フラグ
  // 20150202 HISOL Suzuki 本番課題No.25対応 ADD END
  }
  // 変更担当者
  if(winName == "gCseViewChgWin"){
     document.fm1.selectFlgPop.value = "2"; // 選択区分
      if (document.fm1.searchToSosCd.value != null && document.fm1.searchToSosCd.value != "") {
          document.fm1.initSosCdPop.value = document.fm1.searchToSosCd.value;  // 初期表示組織
        } else {
          document.fm1.initSosCdPop.value = document.fm1.selectedSosCd.value;  // 初期表示組織
      }

    document.fm1.sosKbnPop.value = "2";  // 組織区分

    document.fm1.sknnFlgPop.value = "0";  // 施設責任者フラグ
    document.fm1.insFlgPop.value = "0";  // 施設担当者フラグ
    document.fm1.topMenuFlgPop.value = "0";  // トップメニューフラグ
    document.fm1.authorityPop.value = "1";  // 権限
    document.fm1.bumonRankTopPop.value = "";  // 部門ランク(最上位)
    document.fm1.bumonRankBtmPop.value = "";  // 部門ランク(最下位)
    document.fm1.topSosCdPop.value = "";  // 最上位組織コード
    document.fm1.defTblFlgPop.value = "1";  // 定義テーブル使用フラグ
    document.fm1.actSosListPop.value = document.fm1.sosCdHairetu.value;  // 代行組織リスト
    document.fm1.shokushuFlgPop.value = "1";  // 職種指定フラグ

    document.fm1.ztTntFlgPop.value = "0";  // 雑担当者表示フラグ

    document.fm1.jokenSetCdPop.value = document.fm1.selectedJgiJoken.value;;  // 条件セットコード
    document.fm1.menuTrtGrpCdPop.value = document.fm1.trtGrpCd.value;  // 選択領域グループ(メニュー)
    document.fm1.menuSosCdPop.value = "";  // 選択組織(メニュー)
    document.fm1.selectableBumonrankPop.value = "";  // 選択可能部門ランク
    document.fm1.insNoPop.value = "";  // 施設固定コード
    document.fm1.trtCdPop.value = "";  // 領域コード

    // 20150202 HISOL Suzuki 本番課題No.25対応 MOD START
    //document.fm1.sosCdFromPop.value = document.fm1.searchFromSosCd.value;  // 現組織コード
    document.fm1.sosCdFromPop.value = document.fm1.searchFromSosCdPop.value;  // 現組織コード

    document.fm1.sosCdToPop.value = document.fm1.searchToSosCdPop.value;  // 新組織コード
    document.fm1.trtTntFlgPop.value = 1; // 領域担当者フラグ
  // 20150202 HISOL Suzuki 本番課題No.25対応 ADD END
}
  //組織・従業員選択画面を呼び出します。(一覧項目用)
  if(winName == "gCseViewToJgiWin"){

      document.fm1.selectFlgPop.value = "2"; // 選択区分

      //var tempSearchToSosCd = document.getElementById("chgInsTrtList["+gCseViewSelId+"].toSosCd").value;
      var tempSearchToSosCd = document.getElementById("chgInsTrtList["+gCseViewSelId+"].toSosCd"+tempJ).value;

      //var tempSearchSummarySosCd = document.getElementById("chgInsTrtList["+gCseViewSelId+"].summarySosCd").value;
      var tempSearchSummarySosCd = document.getElementById("chgInsTrtList["+gCseViewSelId+"].summarySosCd"+tempJ).value;

      if (tempSearchToSosCd != null && tempSearchToSosCd != "") {

          document.fm1.initSosCdPop.value = tempSearchToSosCd;  // 初期表示組織
      } else if(tempSearchSummarySosCd != null && tempSearchSummarySosCd != "") {

        document.fm1.initSosCdPop.value = tempSearchSummarySosCd;  // 初期表示組織
      } else {

          document.fm1.initSosCdPop.value = document.fm1.selectedSosCd.value;  // 初期表示組織
      }

    document.fm1.sosKbnPop.value = "2";  // 組織区分

    document.fm1.sknnFlgPop.value = "0";  // 施設責任者フラグ
    document.fm1.insFlgPop.value = "0";  // 施設担当者フラグ
    document.fm1.topMenuFlgPop.value = "0";  // トップメニューフラグ
    document.fm1.authorityPop.value = "1";  // 権限
    document.fm1.bumonRankTopPop.value = "";  // 部門ランク(最上位)
    document.fm1.bumonRankBtmPop.value = "";  // 部門ランク(最下位)
    document.fm1.topSosCdPop.value = "";  // 最上位組織コード
    document.fm1.defTblFlgPop.value = "1";  // 定義テーブル使用フラグ
    document.fm1.actSosListPop.value = document.fm1.sosCdHairetu.value;  // 代行組織リスト
    document.fm1.shokushuFlgPop.value = "1";  // 職種指定フラグ

    document.fm1.ztTntFlgPop.value = "0";  // 雑担当者表示フラグ

    document.fm1.jokenSetCdPop.value = document.fm1.selectedJgiJoken.value;;  // 条件セットコード

    document.fm1.menuTrtGrpCdPop.value = document.fm1.trtGrpCd.value;  // 選択領域グループ(メニュー)
    document.fm1.menuSosCdPop.value = "";  // 選択組織(メニュー)
    document.fm1.selectableBumonrankPop.value = "";  // 選択可能部門ランク
    document.fm1.insNoPop.value = "";  // 施設固定コード
  // 20150202 HISOL Suzuki 本番課題No.25対応 MOD START
    //document.fm1.trtCdPop.value = "";  // 領域コード
    document.fm1.trtCdPop.value = document.getElementById("chgInsTrtList["+gCseViewSelId+"].trtCd"+tempJ).value;  // 領域コード
  // 20150202 HISOL Suzuki 本番課題No.25対応 MOD END

    //document.fm1.sosCdFromPop.value = document.getElementById("chgInsTrtList["+gCseViewSelId+"].fromSosCd").value;  // 現組織コード
  // 20150202 HISOL Suzuki 本番課題No.25対応 MOD START
    //document.fm1.sosCdFromPop.value = document.getElementById("chgInsTrtList["+gCseViewSelId+"].fromSosCd"+tempJ).value;  // 現組織コード
    document.fm1.sosCdFromPop.value = document.fm1.searchFromSosCdPop.value;  // 現組織コード
    document.fm1.sosCdToPop.value = document.fm1.searchToSosCdPop.value;  // 新組織コード
    document.fm1.trtTntFlgPop.value = 1; // 領域担当者フラグ
  // 20150202 HISOL Suzuki 本番課題No.25対応 MOD END
  }
  //[施設責任者].[従業員名]リンク
  if(winName == "gIcrReferViewWin"){
      document.fm1.selectFlgPop.value = "2"; // 選択区分


//      var toSosCdDistId = "chgInsTrtList["
//                        + gCseViewSelId + "].toSosCdDist";
      var toSosCdId = "chgInsTrtList["
                      + gCseViewSelId + "].toSosCd";
      //alert(toSosCdDistId);
      var summarySosCdId = "chgInsTrtList["
                           + gCseViewSelId + "].summarySosCd";

//      var toSosCdDist = document.getElementsByName(toSosCdDistId)[0].value;
      var toSosCd = document.getElementsByName(toSosCdId)[0].value;
      var summarySosCd = document.getElementsByName(summarySosCdId)[0].value;
//      if (toSosCdDist != null && toSosCdDist != "") {
//          document.fm1.initSosCdPop.value = toSosCdDist;
      if (toSosCd != null && toSosCd != "") {
          document.fm1.initSosCdPop.value = toSosCd;
      } else if (summarySosCd != null && summarySosCd != "") {
        document.fm1.initSosCdPop.value = summarySosCd;
      } else {
        document.fm1.initSosCdPop.value = document.fm1.selectedSosCd.value;
      }

    document.fm1.sosKbnPop.value = "2";  // 組織区分

    document.fm1.sknnFlgPop.value = "1";  // 施設責任者フラグ
    document.fm1.insFlgPop.value = "0";  // 施設担当者フラグ
    document.fm1.topMenuFlgPop.value = "0";  // トップメニューフラグ
    document.fm1.authorityPop.value = "1";  // 権限
    document.fm1.bumonRankTopPop.value = "";  // 部門ランク(最上位)
    document.fm1.bumonRankBtmPop.value = "";  // 部門ランク(最下位)
    document.fm1.topSosCdPop.value = "";  // 最上位組織コード
    document.fm1.defTblFlgPop.value = "1";  // 定義テーブル使用フラグ
    document.fm1.actSosListPop.value = document.fm1.sosCdHairetu.value;  // 代行組織リスト
    document.fm1.shokushuFlgPop.value = "1";  // 職種指定フラグ

    document.fm1.ztTntFlgPop.value = "0";  // 雑担当者表示フラグ

    document.fm1.jokenSetCdPop.value = document.fm1.selectedJgiJoken.value;;  // 条件セットコード

    document.fm1.menuTrtGrpCdPop.value = document.fm1.trtGrpCd.value;  // 選択領域グループ(メニュー)
    document.fm1.menuSosCdPop.value = "";  // 選択組織(メニュー)
    document.fm1.selectableBumonrankPop.value = "";  // 選択可能部門ランク
    document.fm1.insNoPop.value = "";  // 施設固定コード
    document.fm1.trtCdPop.value = "";  // 領域コード

    // 20150202 HISOL Suzuki 本番課題No.25対応 MOD START
    //document.fm1.sosCdFromPop.value = document.getElementById("chgInsTrtList["+gCseViewSelId+"].fromSosCd").value;
    document.fm1.sosCdFromPop.value = document.fm1.searchFromSosCdPop.value;  // 現組織コード
    document.fm1.sosCdToPop.value = document.fm1.searchToSosCdPop.value;  // 新組織コード
    document.fm1.trtTntFlgPop.value = 1; // 領域担当者フラグ
  // 20150202 HISOL Suzuki 本番課題No.25対応 MOD END
  }
}


var tempJ = 0;
/**
* 組織・従業員選択画面を呼び出します。(一覧項目用)
*@param obj	呼び出し元オブジェクト
*@param index	選択行番号
*/
function jimCseViewDetailData(i,j){

//add 2006/12/14 M.Hoshino 2度押し対策
if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

// 全てのポップアップを閉じる
jimClosePopUp(gCseViewToJgiWin, "gCseViewToJgiWin");

gCseViewSelId = i;
tempJ = j;

// パラメータの設定
jimSetParamCseViewData("gCseViewToJgiWin");


gCseViewSosWin = cseView(gCseViewToJgiWin,"jimCallBackToJgiCseView1","gCseViewToJgiWin","jimClear1('changeJgi')");
}


/**
* <pre>
* 組織・従業員選択ポップアップのコールバック関数。
* 一覧項目の「新担当者」のリンク押下時にばれます。
* ポップアップで選択した値をフォームに設定します。
* </pre>
*/
function jimCallBackToJgiCseView1(
sosCd, sosName,
jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
 ,brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6
){
var listName="chgInsTrtList";
var rowNo =gCseViewSelId;
var trtNo =tempJ;
if ( jgiName != null && jgiName != "") {
    // 新担当MR名称(表示用)
    //var toJgiNameId = "toJgiNameData" + trtNo;
  var toJgiNameId = "toJgiNameData" + rowNo + trtNo;
    //document.getElementsByName(toJgiNameId)[rowNo].innerHTML = "<a class=\"comBannerSecondaryLink\" href=\"\" onclick=\"JavaScript:jimReplaceInsToMr("+rowNo+");\">" + jgiName + "</a>";
  document.getElementById(toJgiNameId).innerHTML = "<a class=\"comLink\" id=\"toJgiNameLink"+rowNo + trtNo+"\" href=\"#\" onclick=\"JavaScript:jimCseViewDetailData("+rowNo+","+trtNo+");\">" + jgiName + "</a>";

    // 新担当MR名称(HIDDEN用)
    var idViewToJgiName = listName + "[" + rowNo + "].toJgiName" + trtNo;
    document.getElementById(idViewToJgiName).value=jgiName;

    // 新担当MRNO(HIDDEN用)
    var toJgiNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
    document.getElementsByName(toJgiNoId)[0].value = jgiNo;
    // 新組織コード(HIDDEN用)
    var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
    document.getElementsByName(toSosCdId)[0].value = sosCd;
    // 新組織名称(HIDDEN用)
    var toSosNameId = listName + "[" + rowNo + "].toSosName" + trtNo;
    document.getElementsByName(toSosNameId)[0].value = bumonRyakuName1 + bumonRyakuName2 + bumonRyakuName3 + bumonRyakuName4;
    var spanToSosNameId = "spanToSosName" + rowNo + trtNo;
    document.getElementById(spanToSosNameId).innerHTML = bumonRyakuName1 + bumonRyakuName2 + bumonRyakuName3 + bumonRyakuName4;

    // 新組織コード(所属営業所)(HIDDEN用)
    var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist" + trtNo;
    document.getElementsByName(toSosCdDistId)[0].value = sosCd3;

    // 変更情報チェック & 新担当と現担当が同じかどうかをチェック
    jimChkMrNoData(listName, rowNo, trtNo);

    setTantoHazusuStatus010(listName, rowNo, trtNo);

    //2014/12/16
    if (document.fm1.backScreenId && document.fm1.backScreenId.value == "JKR040C010") {
      //副担当ボタン制御
      setSubAllBtnStatus010(listName);
    }

  // 変更担当者指定無しの場合はアラート表示
  } else {
    alert(gMsg[3]);
  }

}

//施設用
var tempIndex = 0;

var jkrHnPopUp;
/**
* 外部参照施設基本詳細画面を呼び出します。
* @param index 選択行番号
*/
function jimIcrRefer(index){
if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 全てのポップアップを閉じる
  jimClosePopUp(gCseViewChgWin, "gCseViewChgWin");

  //パラメータ設定
  //施設固定コード
  var tempInsCd = document.getElementsByName("chgInsTrtList["+index+"].insNo")[0].value;
  document.getElementById("fm2_insNo").value = tempInsCd;
  //施設分類コード
  var tempInsClass = document.getElementsByName("chgInsTrtList["+index+"].insCLass")[0].value;
  document.getElementById("fm2_insClass").value = tempInsClass;
  //ログインユーザの組織コード(固定設定となる)
  //var tempSelectedSosCd = document.getElementById("fm2_loginSosCd")[0].value;
  //document.getElementById("fm2_loginSosCd").value = tempSelectedSosCd;

  if (jkrHnPopUp != null) {
      try {
          jkrHnPopUp.close();
      } catch (err) {
      }
  }

  jkrHnPopUp = window.open("","jkrHnPopUpWin",
                      "width=930,height=660,resizable=yes,status=no,toolbar=no,scrollbars=yes,titlebar=no");

  document.fm2.target = "jkrHnPopUpWin";
  document.fm2.submit();

  tempIndex=index;

  return false;
}

/**
* <pre>
* 施設・従業員選択ポップアップのコールバック関数。
* 検索項目の「変更担当者」の選択ボタン押下時に呼ばれます。
* ポップアップで選択した値をフォームに設定します。
* </pre>
*/
function jimCallBackDispInsNameCseView(
sosCd, sosName,
jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
 ,brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6
){

if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

// 変更担当者欄に指定しているMRを新担当に置き換える
if ( jgiName != null && jgiName != "") {
  var rowNo = tempIndex;
  var listName="chgInsTrtList";
    // 新担当MR名称(表示用)
    var idViewToJgiName = "viewToJgiName" + rowNo;
    document.getElementById(idViewToJgiName).innerHTML = "<a class=\"comLink\" href=\"#\" onclick=\"JavaScript:jimReplaceInsToMr("+rowNo+");\">" + jgiName + "</a>";

    // 新担当MR名称(HIDDEN用)
    var idViewToJgiName = listName + "[" + rowNo + "].toJgiName";
    document.getElementById(idViewToJgiName).value=jgiName;

    // 新担当MRNO(HIDDEN用)
    var toJgiNoId = listName + "[" + rowNo + "].toMrNo";
    document.getElementsByName(toJgiNoId)[0].value = jgiNo;
    // 新組織コード(HIDDEN用)
    var toSosCdId = listName + "[" + rowNo + "].toSosCd";
    document.getElementsByName(toSosCdId)[0].value = sosCd;
    // 新組織名称(HIDDEN用)
    var toSosNameId = listName + "[" + rowNo + "].toSosName";
    document.getElementsByName(toSosNameId)[0].value = bumonRyakuName2 + bumonRyakuName3 + bumonRyakuName4;

    // 新組織コード(所属営業所)(HIDDEN用)
    var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist";
    document.getElementsByName(toSosCdDistId)[0].value = sosCd3;;

    // 変更情報チェック & 新担当と現担当が同じかどうかをチェック
    jimChkMrNoRow(listName, rowNo);

  // 変更担当者指定無しの場合はアラート表示
  } else {
    alert(gMsg[3]);
  }
}


//***************************************************************************//
//*						一覧イベント関数									*//
//***************************************************************************//


/**
* <pre>
* 行追加施設格納
* </pre>
*/
var gAddRowInsNoAry = new Array();

/**
* <pre>
* 追加用カウンター(副担追加用)
* </pre>
*/
var gChgRowCounter = 0;

/**
* <pre>
* 追加された行番号が格納された配列(副担追加用)
* </pre>
*/
var gAddRowSubNoAry = new Array();

/**
* <pre>
* 削除された行番号が格納された配列
* </pre>
*/
var gDelRowAry = new Array();

/**
* <pre>
* 吹き出しメッセージ
* </pre>
*/
var CHG_BTN_MSG = "新担当者を上部の「★選択」ボタンより選択";	// 「変更」ボタン
var SET_BTN_MSG = "新担当者を上部の「★選択」ボタンより選択";	// 「設定」ボタン
var RES_BTN_MSG = "現担当へ戻す";		// 「戻す」ボタン
var DEL_BTN_MSG = "選択行を削除";		// 「削除」ボタン

/**
* <pre>
* ボタン名称
* </pre>
*/
var CHG_BTN_NAME = "★へ変更";	// 「★へ変更」ボタン
var SET_BTN_NAME = "★を設定";	// 「★を設定」ボタン
var RES_BTN_NAME = "戻す";		// 「戻す」ボタン
var DEL_BTN_NAME = "解除";		// 「解除」ボタン

/**
* <pre>
* 副担を外す(チェックボックス)押下時に呼ばれます。
* </pre>
* @param index 行番号
* @param 領域 行番号
* @param Main or Sub
*/
function jimChkDelTan(i, j, mainsub) {

//add 2006/12/14 M.Hoshino 2度押し対策
if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

// 取得する値のIDをそれぞれ取得
var listName = "chgInsTrtList";
//	var idViewDelTan	= "viewDelTan"		+ index;	// 「副担を外す」チェックボックス(0:未ﾁｪｯｸ状態、1:ﾁｪｯｸ済み状態)
var idReplaceToMr	= "replaceTo"	+ i	+ j;	// 変更ボタン
var idResetToMr = "resetTo" + i + j;              // 戻す・解除ボタン
var idDelTan		= "chkDelTan" + mainsub + i + j;;	// 副担を外す」変更前の値delTan
var idToMrLink		= "uToMr"			+ j;	// 新担当者リンク
//var idViewToJgiName	= "toJgiNameData"	+ j;	// 新担当名
var idViewToJgiName	= "toJgiNameData" + i	+ j;	// 新担当名
var idLinkFlg		= listName + "[" + i + "].linkFlg" + j;	// 新担当者リンク表示可否フラグ(0:非表示、1:表示)
var idViewToMrNo	= listName + "[" + i + "].toMrNo" + j;	// 新担当MRNO
var idViewToSosCd	=listName + "[" + i + "].toSosCd"	+j;		// 新担当SosCd
var idMainMr		= listName + "[" + i + "].mainMr";	// 主副担当区分
var idAddButton		= i;						// 副担を追加ボタン
var bAddSub = "bAddSub";

// 上記IDから各値を取得
//	var viewDelTan		= document.getElementById(idViewDelTan).firstChild;
var delTan			= document.getElementById(idDelTan);
var replaceToMrLst		= document.getElementById(idReplaceToMr);
var resetToMrLst		= document.getElementById(idResetToMr);


var toMrLinkLst		= document.getElementsByName(idToMrLink);
var toMrLink = toMrLinkLst[i];
//var viewToJgiNameLst	= document.getElementsByName(idViewToJgiName);
var viewToJgiName	= document.getElementById(idViewToJgiName);
var viewToMrNo		= document.getElementsByName(idViewToMrNo)[0].value;
var linkFlg			= document.getElementsByName(idLinkFlg)[0].value;
var mainMr			= document.getElementById(idMainMr).value;
var addButton		= "";
var addFlg			= false;
//if (document.getElementById(idAddButton).hasChildNodes()) {
//  addButton		= document.getElementById(idAddButton).firstChild;
//  addFlg			= true;
//}

//	var mrCat			= document.fm1.searchMrCat1.value;

// チェックが外れた(元々ﾁｪｯｸ済み状態だった)時は、新担当者リンク・「変更」ボタン・「副担を追加」ボタンを押下可にする
if ( delTan.value == 1 ) {

  delTan.setAttribute('value', '0');
  document.getElementsByName(listName + "[" + i + "].delTan" + j)[0].value = "0";

  // 「副担を追加」ボタンを押下可に設定(主担当を担当解除した場合のみ)
//	if (mainMr == '0' && addFlg && mrCat == JKR_MRCAT_EIGYOU) addButton.disabled = false;
  //if (mainMr == '0' && addFlg) addButton.disabled = false;
  if (document.getElementsByName(bAddSub)[i] != null) {
  document.getElementsByName(bAddSub)[i].style.display = "block";
  }

  // リンク表示可能(担当解除されていた行も含む)の場合は、リンクを貼付
  if ( linkFlg == '1' || viewToMrNo == '0') {
    // リンクの設定
    //toMrLink.innerHTML = "<a class=\"comLink\" href=\"#\" onclick=\"jimCseViewDetailData("+i+",'" + j + "');\">" + toMrLink.innerHTML + "</a>";
    viewToJgiName.innerHTML = "<a class=\"comLink\" id=\"toJgiNameLink" + i + j + "\" href=\"\" onclick=\"jimCseViewDetailData('"+i+"','" + j + "');return false;\">" + viewToJgiName.innerHTML + "</a>";
    toMrLink.innerHTML = "<span id=\"toJgiNameData" + i + j +"\" name=\"toJgiName" + i + j +"\" > "+ viewToJgiName.innerHTML + "</span>";
    if(replaceToMrLst != null){
         var replaceToMr		= replaceToMrLst.firstChild;
         if (replaceToMr.type == "button") {
         // ボタンの設定
         replaceToMr.style.display = "block";
         }
    }
    if(resetToMrLst != null){
        var resetToMr		= resetToMrLst.firstChild;
        // ボタンの設定
        if (resetToMr.type == "button") {
        resetToMr.style.display = "block";
        }
    }

  // リンク表示不可能の場合は、リンクを貼付しない
  } else {
    // リンクの設定
    //toMrLink.innerHTML = "<span id=\"toJgiNameData" + i + j +"\" name=\"toJgiName" + i + j +"\" > " + toMrLink.innerHTML + "</span>";

      if(replaceToMrLst != null){
           var replaceToMr		= replaceToMrLst.firstChild;
         if (replaceToMr.type == "button") {
         // ボタンの設定
         replaceToMr.style.display = "none";
         }
    }
    if(resetToMrLst != null){
        var resetToMr		= resetToMrLst.firstChild;
        if (resetToMr.type == "button") {
        // ボタンの設定
        resetToMr.style.display = "none";
        }
    }

  }

  document.getElementsByName(idViewToMrNo)[0].value = document.getElementsByName(listName + "[" + i + "].fromMrNo" + j)[0].value;
  document.getElementsByName(idViewToSosCd)[0].value = document.getElementsByName(listName + "[" + i + "].fromSosCd" + j)[0].value;

// チェックがついた(元々未ﾁｪｯｸ状態だった)時は、新担当者のリンクと変更ボタン・「副担を追加」ボタンを押下不可にする
} else {

  // リンクの設定
  //toMrLink.innerHTML = "<span id=\"toJgiName"+ j +"\" name=\"toJgiName" + j +"\" > "+ viewToJgiName.innerHTML + "</span>";

  // 新担当者名リンク外す
var viewToJgiNameHtml = viewToJgiName.innerHTML;
  // リンクタグが入っている場合、リンクタグの内容を取得します。
 if (viewToJgiNameHtml.indexOf("toJgiNameLink", 1) > 0) {
   viewToJgiNameHtml = document.getElementById("toJgiNameLink" + i + j).innerHTML;
 }
  toMrLink.innerHTML = "<span id=\"toJgiNameData" + i + j +"\" name=\"toJgiName" + i + j +"\" > "+ viewToJgiNameHtml + "</span>";
  // ★へ変更ボタン　非表示
  if(replaceToMrLst != null){
      var replaceToMr		= replaceToMrLst.firstChild;

    if (replaceToMr.type == "button") {
    // ボタンの設定
    replaceToMr.style.display = "none";
    }
  }
  // 戻すバタン　非表示
  if(resetToMrLst != null){
      var resetToMr		= resetToMrLst.firstChild;
      if (resetToMr.type == "button") {
      // ボタンの設定
      resetToMr.style.display = "none";
      }
  }
  // 新担当者ＮＯ 0設定
  document.getElementsByName(idViewToMrNo)[0].value = "0";
  // 新組織コード ""設定
  document.getElementsByName(idViewToSosCd)[0].value = "";

  // 「副担を追加」ボタンを押下不可に設定(主担当を担当解除した場合のみ)
  //if (mainMr == '0' && addFlg) addButton.disabled = true;
  if (document.getElementsByName(bAddSub)[i] != null) {
      document.getElementsByName(bAddSub)[i].style.display = "none";
  }
  // 副担を外す
  delTan.setAttribute('value', '1');
  document.getElementsByName(listName + "[" + i + "].delTan" + j)[0].value = "1";
}

//document.getElementsByName(listName + "[" + i + "].toJgiChgFlg" + j)[0].value = "1";

// 変更情報チェック
jimCheckChangeInfo(i,j);
}

/**
* <pre>
* 新担当の変更ボタン押下時に呼ばれます。
* </pre>
* @param index 行番号
*/
function jimReplaceToMr(listName, rowNo) {

//add 2006/12/14 M.Hoshino 2度押し対策
if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

//変更担当者
var changeJgiName = document.fm1.changeJgiName.value;
var changeJgiNo = document.fm1.changeJgiNo.value;
var changeSosCd = document.fm1.changeSosCd.value;
var changeSosName = document.fm1.changeSosName.value;
var changeSosCdDist = document.getElementById("changeSosCdDist").value;

// 変更担当者欄に指定しているMRを新担当に置き換える
if ( changeJgiName != null && changeJgiName != "") {
  // 新担当MR名称(表示用)
  var idViewToJgiName = "viewToJgiName" + rowNo;

  document.getElementById(idViewToJgiName).innerHTML = "<a  href=\"#\" onclick=\"JavaScript:jimReplaceInsToMr("+rowNo+");\">" + changeJgiName + "</a>";

  // 新担当MR名称(HIDDEN用)
  var toJgiNameId = listName + "[" + rowNo + "].toJgiName";
  document.getElementsByName(toJgiNameId)[0].value = changeJgiName;

  // 新担当MRNO(HIDDEN用)
  var toJgiNoId = listName + "[" + rowNo + "].toMrNo";
  document.getElementsByName(toJgiNoId)[0].value = changeJgiNo;
  // 新組織コード(HIDDEN用)
  var toSosCdId = listName + "[" + rowNo + "].toSosCd";
  document.getElementsByName(toSosCdId)[0].value = changeSosCd;
  // 新組織名称(HIDDEN用)
  var toSosNameId = listName + "[" + rowNo + "].toSosName";
  document.getElementsByName(toSosNameId)[0].value = changeSosName;
  // 新組織コード(所属営業所)(HIDDEN用)
  var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist";
  document.getElementsByName(toSosCdDistId)[0].value = changeSosCdDist;
  // 画面表示用
//  var spanToJigiNameDispId = listName + "[" + rowNo + "].spanToJgiName";
//  alert(spanToJigiNameDispId);
//  document.getElementById(spanToJigiNameDispId).innerText = changeJgiName;
  // ★へ変更の名称を変更
//   alert(1);
  var replaceId	= "replaceToMr" + rowNo;
  document.getElementById(replaceId).innerHTML	= "<acronym title=\"" + CHG_BTN_MSG + "\">"
  + "<INPUT type=\"button\" id=\"bChangeChg"+rowNo+"\"  value=\"" + CHG_BTN_NAME + "\" onclick=\"jimReplaceToMr('chgInsTrtList'," + rowNo + ");\">"
  + "</acronym>";
  setChgBtnStatus010(listName, rowNo, "");
  // 変更情報チェック & 新担当と現担当が同じかどうかをチェック
  jimChkMrNoRow(listName, rowNo);

// 変更担当者指定無しの場合はアラート表示
} else {
  alert(gMsg[3]);
}
}

/**
* <pre>
* 新担当の戻すボタン押下時に呼ばれます。
* 現担当者に戻します。
* </pre>
* @param index 行番号
*/
function jimResetFromMr(listName,rowNo) {

//add 2006/12/14 M.Hoshino 2度押し対策
if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

var changeFlgId = listName + "[" + rowNo + "].insChgFlg";
document.getElementById(changeFlgId).value = "1";

//新担当MRNO(HIDDEN用)
var toJgiNoId = listName + "[" + rowNo + "].toMrNo";
var fromJgiNoId = "fromMrNo"+rowNo;
document.getElementsByName(toJgiNoId)[0].value = document.getElementById(fromJgiNoId).value;
// 新担当MR名称(表示用)
var toJgiNameId = "viewToJgiName" + rowNo;
var fromJgiNameId = listName + "[" + rowNo + "].fromJgiName";
var toJgiName = document.getElementsByName(fromJgiNameId)[0].value;
var toMrNoId = listName + "[" + rowNo + "].toMrNo";
var toMrNo = document.getElementsByName(toMrNoId)[0].value;
if (toMrNo == "" || toMrNo == "0") {
  toJgiName = "担当者選択";
}
document.getElementById(toJgiNameId).innerHTML =  "<a  href=\"#\" onclick=\"JavaScript:jimReplaceInsToMr("+rowNo+");\">" + toJgiName + "</a>";

var toJgiNameHidId = listName + "[" + rowNo + "].toJgiName";
document.getElementsByName(toJgiNameHidId)[0].value = toJgiName;
// 新組織コード(HIDDEN用)
var toSosCdId = listName + "[" + rowNo + "].toSosCd";
var fromSosCdId = "fromSosCd" + rowNo;
document.getElementsByName(toSosCdId)[0].value = document.getElementsByName(fromSosCdId)[0].value;
// 新組織名称(HIDDEN用)
var toSosNameId = listName + "[" + rowNo + "].toSosName";
//20150303 ST-B-367対応 HISOL鈴木 MOD START
//var fromSosNameId = "fromSosName" + rowNo;
var fromSosNameId = listName + "[" + rowNo + "].toSosNameBef";
//20150303 ST-B-367対応 HISOL鈴木 MOD END
document.getElementsByName(toSosNameId)[0].value = document.getElementsByName(fromSosNameId)[0].value;
// 新組織コード(所属営業所)(HIDDEN用)
var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist";
var summarySosCdId = "chgInsTrtList["+rowNo+"].summarySosCd";
document.getElementsByName(toSosCdDistId)[0].value = document.getElementsByName(summarySosCdId)[0].value;
// 画面表示用
//var spanToJigiNameDispId = listName + "[" + rowNo + "].spanToJgiName";
//document.getElementById(spanToJigiNameDispId).innerText = toJgiName;
// 変更情報チェック
jimChkMrNoRow(listName, rowNo);

}

/**
* <pre>
* 新担当者の設定時に呼ばれます。
* 新担当と現担当が同じであれば変更ボタンを非表示にします。
* @param index 行番号
* </pre>
*/
function jimChkMrNoRow(listName, rowNo) {

  // 2度押し対策
if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

//変更前新担当MRNO
var toMrNoBefId = "toMrNo"+rowNo;
var toMrNoBef = document.getElementById(toMrNoBefId).value;

// 変更後新担当MRNO
var toMrNoId = listName + "[" + rowNo + "].toMrNo";
var toMrNo = document.getElementById(toMrNoId).value;

// 変更前新組織コード
var toSosCdBefId = "toSosCd" + rowNo;
var toSosCdBef	= document.getElementById(toSosCdBefId).value;

// 変更後新組織コード
var toSosCdId = listName + "[" + rowNo + "].toSosCd";
var toSosCd = document.getElementById(toSosCdId).value;

// 担当変更フラグ
var changeFlgId = listName + "[" + rowNo + "].insChgFlg";

if (Number(toMrNoBef) != Number(toMrNo) || toSosCdBef != toSosCd ) {
  document.getElementById(changeFlgId).value = "1";

  jkrMrChaker = 1;

} else {
  document.getElementById(changeFlgId).value = "0";

  // 作業途中のデータ有無を判定する。
  checkChangeData(listName);
}

//新担当と現担当が同じかどうかをチェック
//現担当MRNO
var fromMrNoId = "fromMrNo"+ rowNo;
var fromMrNo = document.getElementById(fromMrNoId).value;

// 変更後新担当MRNO
var toMrNoId = listName + "[" + rowNo + "].toMrNo";
var toMrNo = document.getElementById(toMrNoId).value;

// 現組織コード
var fromSosCdId = "fromSosCd" + rowNo;
var fromSosCd	= document.getElementById(fromSosCdId).value;

// 変更後新組織コード
var toSosCdId = listName + "[" + rowNo + "].toSosCd";
var toSosCd = document.getElementById(toSosCdId).value;

var btnRtnId = "delRow" + rowNo;
// var fromInOutId = listName + "[" + rowNo + "].fromInout";
// var toInOutId = listName + "[" + rowNo + "].spanInout";
 var toInOutId = "toSpanInout" + rowNo;
//var strEnabed = "";
//if (document.fm1.regEnabedFlg.value != "1") {
//  strEnabed = "disabled";
//}
var linkFlgId = listName + "[" + rowNo + "].linkFlg";
var linkFlg = document.getElementById(linkFlgId).value;
if (linkFlg == "1") {
  if (Number(fromMrNo) == Number(toMrNo) && fromSosCd == toSosCd ) {
    document.getElementById(btnRtnId).innerHTML = "&nbsp;";
    //新 転入出に現 転入出を設定
   // document.getElementById(toInOutId).innerHTML = document.getElementById(fromInOutId).innerHTML;
    document.getElementById(toInOutId).innerHTML = "";
  } else if (Number(fromMrNo) != 0) {
      document.getElementById(btnRtnId).innerHTML = "<acronym title=\"現担当へ戻す\">"
          + "<INPUT type=\"button\" name=\"bReset\" value=\"戻す\" "
          + " onclick=\"jimResetFromMr('" + listName
          + "', " + rowNo + ");\"></acronym>";
     // document.getElementById(toInOutId).innerHTML = "";
       document.getElementById(toInOutId).innerHTML = "";
  } else {
    document.getElementById(btnRtnId).innerHTML = "<acronym title=\"担当なしへ戻す\">"
            + "<INPUT type=\"button\" name=\"bReset\" value=\"解除\" "
            + " onclick=\"jimResetFromMr('" + listName
            + "', " + rowNo +  ");\"></acronym>";
   // document.getElementById(toInOutId).innerHTML = "";
    document.getElementById(toInOutId).innerHTML = "";
  }
}
// ★へ変更の名称を変更
if (Number(toMrNo) == 0) {
  var replaceId	= "replaceToMr" + rowNo;
  document.getElementById(replaceId).innerHTML= "<acronym title=\"" + SET_BTN_MSG + "\">"
  + "<INPUT type=\"button\" id=\"bChangeChg\"" + rowNo + " name=\"bChange\" value=\"" + SET_BTN_NAME + "\" onclick=\"jimReplaceToMr('chgInsTrtList'," + rowNo + ");\">"
  + "</acronym>";
  setChgBtnStatus010(listName, rowNo, "");
}

}

/**
* <pre>
* 画面の情報が変更されたかどうかを判定します。
* 変更されている場合、jkrMrChakerに「1:変更あり」を設定します。
* </pre>
* @param index 選択行番号
*/
function jimCheckChangeInfo(i,j) {

var id = "";
var listName = "chgInsTrtList";

// 変更前新担当MRNO
id = "dataToMrNo1" + j;
var defaultToMrNo	= document.getElementsByName(id)[i].getAttribute('value');

// 変更後新担当MRNO
id = listName + "[" + i + "].toMrNo" + j;
var toMrNo			= document.getElementsByName(id)[0].getAttribute('value');

// 変更前新組織コード
id = "dataToSosCd1" + j;
var beforeToSosCd	= document.getElementsByName(id)[i].getAttribute('value');

// 変更後新組織コード
id = listName + "[" + i + "].toSosCd" + j;
var toSosCd	        = document.getElementsByName(id)[0].getAttribute('value');

// 変更前担当解除
id = listName + "[" + i + "].delTanOld" + j;
var defaultDelTan	= document.getElementsByName(id)[0].getAttribute('value');

// 変更後担当解除
id = listName + "[" + i + "].delTan" + j;
var delTan		= document.getElementsByName(id)[0].getAttribute('value');

id = listName + "[" + i + "].toJgiChgFlg" + j;

if (defaultToMrNo != toMrNo || beforeToSosCd != toSosCd ) {
  jkrMrChaker = 1;
  document.getElementsByName(id)[0].value = "1";
  return false;
} else {
  document.getElementsByName(id)[0].value = "0";
}
// 副担を外す(担当を外す)の変更チェック
if (defaultDelTan != delTan) {
  jkrMrChaker = 1;
  document.getElementsByName(id)[0].value = "1";
  return false;
} else {
  document.getElementsByName(id)[0].value = "0";
}
}


/**
* 行追加
*/
function jimAddRowNew(obj, rowIndex) {

  document.fm1.screenId.value	= document.fm1.gamenId.value;
  document.fm1.functionId.value = 'InsertRow';
  document.fm1.insertRowNo.value = rowIndex;
  document.fm1.jkrMrChaker.value = jkrMrChaker;
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);

}

/**
 * <pre>
 * 新担当の変更ボタン押下時に呼ばれます。
 * </pre>
 * @param index 行番号
 */
function jimReplaceToMrData(listName, rowNo, trtNo) {

//add 2006/12/14 M.Hoshino 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // 変更担当者
  var changeJgiName = document.fm1.changeJgiName.value;
  var changeJgiNo = document.fm1.changeJgiNo.value;
  var changeSosCd = document.fm1.changeSosCd.value;
  var changeSosName = document.fm1.changeSosName.value;
  var changeSosCdDist = document.getElementById("changeSosCdDist").value;

  // 変更担当者欄に指定しているMRを新担当に置き換える
  if ( changeJgiName != null && changeJgiName != "") {
    // 新担当MR名称(表示用)
//    var toJgiNameId = "toJgiNameData" + trtNo;
    var toJgiNameId = "toJgiNameData" + rowNo + trtNo;
//    document.getElementsByName(toJgiNameId)[rowNo].innerHTML = "<a  href=\"\" onclick=\"JavaScript:jimReplaceInsToMr("+rowNo+");\">" + changeJgiName + "</a>";
    document.getElementById(toJgiNameId).innerHTML = "<a class=\"comLink\" id=\"toJgiNameLink"+rowNo + trtNo+"\" href=\"#\" onclick=\"JavaScript:jimCseViewDetailData("+rowNo+","+trtNo+");\">" + changeJgiName + "</a>";

    // 新担当MR名称(HIDDEN用)
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

    var spanToSosNameId = "spanToSosName" + rowNo + trtNo;
    document.getElementById(spanToSosNameId).innerHTML = changeSosName;

    // 新組織コード(所属営業所)(HIDDEN用)
    var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist" + trtNo;
    document.getElementsByName(toSosCdDistId)[0].value = changeSosCdDist;
    // 画面表示用
//    var spanToJigiNameDispId = listName + "[" + rowNo + "].spanToJgiName" + trtNo;
//    alert(spanToJigiNameDispId);
//    document.getElementById(spanToJigiNameDispId).innerText = changeJgiName;
    // ★へ変更の名称を変更
    var replaceId	= "dataReplaceToMr" + trtNo;
    document.getElementsByName(replaceId)[rowNo].innerHTML	= "<acronym title=\"" + CHG_BTN_MSG + "\">"
    +"<span id=\"replaceTo" + rowNo+trtNo+"\" name=\"replaceTo" + rowNo+trtNo+"\">"
    + "<INPUT type=\"button\" id=\"bChange\"" + rowNo + trtNo + " name=\"bChange" + rowNo + trtNo + "\" value=\"" + CHG_BTN_NAME + "\" onclick=\"jimReplaceToMrData('chgInsTrtList'," + rowNo +","+trtNo+ ");\">"
    + "</span></acronym>";
    setChgBtnStatus010(listName, rowNo, trtNo);
    // 変更情報チェック & 新担当と現担当が同じかどうかをチェック
    jimChkMrNoData(listName, rowNo, trtNo);

    setTantoHazusuStatus010(listName, rowNo, trtNo);

    //2014/12/16
    if (document.fm1.backScreenId && document.fm1.backScreenId.value == "JKR040C010") {
      //副担当ボタン制御
      setSubAllBtnStatus010(listName);
    }

  // 変更担当者指定無しの場合はアラート表示
  } else {
    alert(gMsg[3]);
  }

}


/**
 * <pre>
 * 新担当の戻すボタン押下時に呼ばれます。
 * 現担当者に戻します。
 * </pre>
 * @param index 行番号
 */
function jimResetFromMrData(listName, rowNo, trtNo) {

//add 2006/12/14 M.Hoshino 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

// 担当変更フラグ
  var changeFlgId = listName + "[" + rowNo + "].toJgiChgFlg" + trtNo;
  document.getElementsByName(changeFlgId)[0].value = "1";

// 新担当MRNO(HIDDEN用)
  var toJgiNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var toJgiNameHidId = listName + "[" + rowNo + "].toJgiName" + trtNo;
  var fromJgiNoId = "dataFromMrNo1" + trtNo;
  document.getElementsByName(toJgiNoId)[0].value = document.getElementsByName(fromJgiNoId)[rowNo].value;
  // 新担当MR名称(表示用)
  //var toJgiNameId = "toJgiNameData" + trtNo;
  var toJgiNameId = "toJgiNameData" + rowNo + trtNo;
  var fromJgiNameId = "dataFromJgiName1" + trtNo;
  var toJgiName = document.getElementsByName(fromJgiNameId)[rowNo].value;

  var toMrNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var toMrNo = document.getElementsByName(toMrNoId)[0].value;

  if (toMrNo == "" || toMrNo == "0") {
    toJgiName = "担当者選択";
  }

  document.getElementsByName(toJgiNameHidId)[0].value = toJgiName;

  //document.getElementsByName(toJgiNameId)[rowNo].innerHTML =  "<a  href=\"\" onclick=\"JavaScript:jimCseViewDetailData("+rowNo+","+trtNo+");\">" + toJgiName + "</a>";;
  document.getElementById(toJgiNameId).innerHTML =  "<a class=\"comLink\" id=\"toJgiNameLink"+rowNo + trtNo+"\" href=\"#\" onclick=\"JavaScript:jimCseViewDetailData("+rowNo+","+trtNo+");\">" + toJgiName + "</a>";

  // 新組織コード(HIDDEN用)
  var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
  var fromSosCdId = "dataFromSosCd1" + trtNo;
  document.getElementsByName(toSosCdId)[0].value = document.getElementsByName(fromSosCdId)[rowNo].value;
  // 新組織名称(HIDDEN用)
  var toSosNameId = listName + "[" + rowNo + "].toSosName" + trtNo;
  //20150303 ST-B-367対応 HISOL鈴木 MOD START
  //var fromSosNameId = "dataFromSosName1" + trtNo;
  //document.getElementsByName(toSosNameId)[0].value = document.getElementsByName(fromSosNameId)[rowNo].value;
  var fromSosNameId = listName + "[" + rowNo + "].toSosNameBef" + trtNo;
  document.getElementsByName(toSosNameId)[0].value = document.getElementsByName(fromSosNameId)[0].value;
  //20150303 ST-B-367対応 HISOL鈴木 MOD END
  var spanToSosNameId = "spanToSosName" + rowNo + trtNo;
  //2014/12/16 戻すボタン押下で「担当者選択」となる場合、組織名もクリア
  if (toMrNo == "" || toMrNo == "0") {
      document.getElementById(spanToSosNameId).innerHTML = "";
  }else{
      //20150303 ST-B-367対応 HISOL鈴木 MOD START
      //document.getElementById(spanToSosNameId).innerHTML = document.getElementsByName(fromSosNameId)[rowNo].value;
      document.getElementById(spanToSosNameId).innerHTML = document.getElementsByName(fromSosNameId)[0].value;
      //20150303 ST-B-367対応 HISOL鈴木 MOD END
  }

  // 新組織コード(所属営業所)(HIDDEN用)
  var toSosCdDistId = listName + "[" + rowNo + "].toSosCdDist" + trtNo;
  var summarySosCdId = listName + "[" + rowNo + "].summarySosCd" + trtNo;
  document.getElementsByName(toSosCdDistId)[0].value = document.getElementsByName(summarySosCdId)[0].value;
  // 画面表示用
//  var spanToJigiNameDispId = listName + "[" + rowNo + "].spanToJgiName" + trtNo;
//  document.getElementById(spanToJigiNameDispId).innerText = toJgiName;

  // 変更情報チェック  & 新担当と現担当が同じかどうかをチェック
  jimChkMrNoData(listName, rowNo, trtNo);

  if (document.getElementsByName("chgInsTrtList["+ rowNo +"].RowKbn")[0].value == "1"){
      document.getElementsByName(changeFlgId)[0].value = "0";
  }else{
//2015/01/26 HISOL Suzuki DEL START
      //document.getElementsByName(changeFlgId)[0].value = "1";
//2015/01/26 HISOL Suzuki DEL END
  }
  //20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
  //従業員区分
  var toJgiKbId = listName + "[" + rowNo + "].toJgiKb" + trtNo;
  var fromJgiKbId = listName + "[" + rowNo + "].fromJgiKb" + trtNo;
  document.getElementsByName(toJgiKbId)[0].value = document.getElementsByName(fromJgiKbId)[0].value;
  //20150402 期末期首課題対応No.227 HISOL鈴木 ADD END

  setTantoHazusuStatus010(listName, rowNo, trtNo);

//20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
// 現担当がダミーＭＲの場合、副担追加行も同時に削除する
  var fromJgiKbId = listName + "[" + rowNo + "].fromJgiKb" + trtNo;
  var fromJgiKb = document.getElementsByName(fromJgiKbId)[0].value;  // 現担当者の従業員区分
  if(fromJgiKb == "8"){ // 現担当がダミーＭＲの場合
      // 施設コードを取得
      var insNoMainId = listName + "[" + rowNo + "].insNo";
      var insNoMain = document.getElementsByName(insNoMainId)[0].value;
      // 一覧の最終行を取得
      var maxRow = 0;
      if (document.fm1.chgInsTrtListCnt) {
          maxRow = document.fm1.chgInsTrtListCnt.value - 1;
      }else{
          maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
      }
      // 同施設の副担追加行に対して繰り返す
      for(var rowNoSub = Number(rowNo) + 1; rowNoSub <= maxRow; rowNoSub++) {
          // 施設コードを取得
          var insNoSubId = listName + "[" + rowNoSub + "].insNo";
          var insNoSub = document.getElementsByName(insNoSubId)[0].value;
          if(insNoSub != insNoMain){
              break; //施設が変わったらループ終了
          }else{
              // 新担当MRNO(HIDDEN用)
              var toJgiNoSubId = listName + "[" + rowNoSub + "].toMrNo" + trtNo;
              var fromJgiNoSubId = listName + "[" + rowNoSub + "].fromMrNo" + trtNo;
              document.getElementsByName(toJgiNoSubId)[0].value = document.getElementsByName(fromJgiNoSubId)[0].value;
              // 新担当MR名称(表示用)
              var toJgiNameSubId = "toJgiNameData" + rowNoSub + trtNo;
              var fromJgiNameSubId = listName + "[" + rowNoSub + "].fromJgiName" + trtNo;
              var toJgiNameSub = document.getElementsByName(fromJgiNameSubId)[0].value;
              var toMrNoSubId = listName + "[" + rowNoSub + "].toMrNo" + trtNo;
              var toMrNoSub = document.getElementsByName(toMrNoSubId)[0].value;
              if (toMrNoSub == "" || toMrNoSub == "0") {
                  toJgiNameSub = "担当者選択";
              }
              var toJgiNameHidSubId = listName + "[" + rowNoSub + "].toJgiName" + trtNo;
              document.getElementsByName(toJgiNameHidSubId)[0].value = toJgiNameSub;

              document.getElementById(toJgiNameSubId).innerHTML = toJgiNameSub; //リンクにしない

              // 新組織コード(HIDDEN用)
              var toSosCdSubId = listName + "[" + rowNoSub + "].toSosCd" + trtNo;
              var fromSosCdSubId = listName + "[" + rowNoSub + "].fromSosCd" + trtNo;
              document.getElementsByName(toSosCdSubId)[0].value = document.getElementsByName(fromSosCdSubId)[0].value;
              // 新組織名称(HIDDEN用)
              var toSosNameSubId = listName + "[" + rowNoSub + "].toSosName" + trtNo;
              var fromSosNameSubId = listName + "[" + rowNoSub + "].toSosNameBef" + trtNo;
              document.getElementsByName(toSosNameSubId)[0].value = document.getElementsByName(fromSosNameSubId)[0].value;
              var spanToSosNameId = "spanToSosName" + rowNoSub + trtNo;
              //戻すボタン押下で「担当者選択」となる場合、組織名もクリア
              if (toMrNoSub == "" || toMrNoSub == "0") {
                  document.getElementById(spanToSosNameId).innerHTML = "";
              }else{
                  document.getElementById(spanToSosNameId).innerHTML = document.getElementsByName(fromSosNameSubId)[0].value;
              }

              // 新組織コード(所属営業所)(HIDDEN用)
              var toSosCdDistSubId = listName + "[" + rowNoSub + "].toSosCdDist" + trtNo;
              var summarySosCdSubId = listName + "[" + rowNoSub + "].summarySosCd" + trtNo;
              document.getElementsByName(toSosCdDistSubId)[0].value = document.getElementsByName(summarySosCdSubId)[0].value;

              // 変更情報チェック  & 新担当と現担当が同じかどうかをチェック
              jimChkMrNoData(listName, rowNoSub, trtNo);

              setTantoHazusuStatus010(listName, rowNoSub, trtNo);

              // ★へ変更ボタン非表示
              var replaceToMrId = "replaceTo" + rowNoSub + trtNo;
              var replaceToMrLst = document.getElementById(replaceToMrId);
              if(replaceToMrLst != null){
                  var replaceToMr = replaceToMrLst.firstChild;
                  if (replaceToMr.type == "button") {
                      // ボタンの設定
                      replaceToMr.style.display = "none";
                  }
              }
              // 担当変更データＩＤを取得
              var changeIdId = listName + "[" + rowNoSub + "].id" + trtNo;
              var changeId = document.getElementsByName(changeIdId)[0].value;
              // 担当変更フラグ
              var changeFlgSubId = listName + "[" + rowNoSub + "].toJgiChgFlg" + trtNo;
              if(changeId == null || changeId == ""){
                  document.getElementsByName(changeFlgSubId)[0].value = "0";
              }else{
                  if(rowNoSub == maxRow){
                      //最終行の場合は"9"(変更あり かつ 副担追加行のページ跨り削除)を設定
                      document.getElementsByName(changeFlgSubId)[0].value = "9";
                  }else{
                      document.getElementsByName(changeFlgSubId)[0].value = "1";
                  }
              }
          }
      }
  }
//20150402 期末期首課題対応No.227 HISOL鈴木 ADD END

  //2014/12/16
  if (document.fm1.backScreenId && document.fm1.backScreenId.value == "JKR040C010") {
    //副担当ボタン制御
    setSubAllBtnStatus010(listName);
  }
}


/**
 * <pre>
 * （領域 ）
 * 新担当者の設定時に呼ばれます。
 * 新担当と現担当が同じであれば変更ボタンを非表示にします。
 * @param index 行番号
 * </pre>
 */
function jimChkMrNoData(listName, rowNo, trtNo) {

    // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

// 変更前新担当MRNO
  var toMrNoBefId = "dataToMrNo1" + trtNo;
  var toMrNoBef = document.getElementsByName(toMrNoBefId)[rowNo].value;

  // 変更後新担当MRNO
  var toMrNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var toMrNo = document.getElementsByName(toMrNoId)[0].value;

  // 変更前新組織コード
  var toSosCdBefId = "dataToSosCd1" + trtNo;
  var toSosCdBef	= document.getElementsByName(toSosCdBefId)[rowNo].value;

  // 変更後新組織コード
  var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
  var toSosCd = document.getElementsByName(toSosCdId)[0].value;

  // 担当変更フラグ
  var changeFlgId = listName + "[" + rowNo + "].toJgiChgFlg" + trtNo;
  if (Number(toMrNoBef) != Number(toMrNo) || toSosCdBef != toSosCd ) {
    document.getElementsByName(changeFlgId)[0].value = "1";

    jkrMrChaker = 1;

  } else {
    document.getElementsByName(changeFlgId)[0].value = "0";
    // 作業途中のデータ有無を判定する。
    checkChangeData(listName);
  }

  //新担当と現担当が同じかどうかをチェック
  // 現担当MRNO
  var fromMrNoId = "dataFromMrNo1" + trtNo;
  var fromMrNo = document.getElementsByName(fromMrNoId)[rowNo].value;

  // 変更後新担当MRNO
  var toMrNoId = listName + "[" + rowNo + "].toMrNo" + trtNo;
  var toMrNo = document.getElementsByName(toMrNoId)[0].value;

  // 現組織コード
  var fromSosCdId = listName + "[" + rowNo + "].fromSosCd" + trtNo;
  var fromSosCd	= document.getElementsByName(fromSosCdId)[0].value;

  // 変更後新組織コード
  var toSosCdId = listName + "[" + rowNo + "].toSosCd" + trtNo;
  var toSosCd = document.getElementsByName(toSosCdId)[0].value;

  var btnRtnId = "dataDelRow" + trtNo;
//  var fromInOutId = listName + "[" + rowNo + "].fromInout" + trtNo;
//  var toInOutId = listName + "[" + rowNo + "].spanInout" + trtNo;
  var toInOutId = "spanInout" + rowNo + trtNo;
//  var strEnabed = "";
//  if (document.fm1.regEnabedFlg.value != "1") {
//    strEnabed = "disabled";
//  }
  var linkFlgId = listName + "[" + rowNo + "].linkFlg" + trtNo;
  var linkFlg = document.getElementsByName(linkFlgId)[0].value;

  if (linkFlg == "1") {

    if (Number(fromMrNo) == Number(toMrNo) && fromSosCd == toSosCd ) {

      document.getElementsByName(btnRtnId)[rowNo].innerHTML = "&nbsp;";

      document.getElementsByName(listName + "[" + rowNo + "].cancleButtonSts" + trtNo)[0].value = 1;
      //新 転入出に現 転入出を設定
     // document.getElementById(toInOutId).innerHTML = document.getElementById(fromInOutId).innerHTML;
       document.getElementById(toInOutId).innerHTML = "";
    } else if (Number(fromMrNo) != 0) {
      //alert(666)
        //副担追加の行ではない場合（現従業員がある）(従業員POP選択イベント＆「★」ボタン押下）
        document.getElementsByName(btnRtnId)[rowNo].innerHTML = "<acronym title=\"現担当へ戻す\">"
            + "<span id=\"resetTo" + rowNo + trtNo + "\" name=\"resetTo" + rowNo + "\">"
            + "<INPUT type=\"button\" id=\"bBckSubTrt" + rowNo + trtNo + "\" name=\"bReset\" value=\"戻す\" "
            + " onclick=\"jimResetFromMrData('" + listName
            + "', " + rowNo + ", " + trtNo + ");\"></span></acronym>";
       // document.getElementById(toInOutId).innerHTML = "";
         document.getElementById(toInOutId).innerHTML = "";
    } else {
    //alert(555)
      //副担追加の場合(従業員POP選択イベント＆「★」ボタン押下）
      document.getElementsByName(btnRtnId)[rowNo].innerHTML = "<acronym title=\"担当なしへ戻す\">"
              + "<span id=\"resetTo" + rowNo + trtNo + "\" name=\"resetTo" + rowNo + "\">"
              + "<INPUT type=\"button\" id=\"bBckSubTrt" + rowNo + trtNo + "\" name=\"bReset\" value=\"解除\" "
              + " onclick=\"jimResetFromMrData('" + listName
              + "', " + rowNo + ", " + trtNo + ");\"></span></acronym>";

      document.getElementsByName(listName + "[" + rowNo + "].cancleButtonSts" + trtNo)[0].value = 0;

      //document.getElementById(toInOutId).innerHTML = "";
      document.getElementById(toInOutId).innerHTML = "";

      //★ボタン名称の変更
      var bChangeBtTemp = document.getElementById("bChange" + rowNo + trtNo);
      if (bChangeBtTemp) {
        bChangeBtTemp.value = CHG_BTN_NAME;
      }
    }
  }
  // ★へ変更の名称を変更
  if (Number(toMrNo) == 0) {
    var replaceId	= "dataReplaceToMr" + trtNo;
    //alert(777)
      //副担追加の場合(「解除」ボタン押下）
      document.getElementsByName(replaceId)[rowNo].innerHTML= "<acronym title=\"" + SET_BTN_MSG + "\">"
      +"<span id=\"replaceTo" + rowNo+trtNo+"\" name=\"replaceTo" + rowNo+trtNo+"\">"
      +"<INPUT type=\"button\" id=\"bChange" + rowNo + trtNo + "\" name=\"bChange\"" + rowNo + trtNo + " value=\"" + SET_BTN_NAME + "\" onclick=\"jimReplaceToMrData('chgInsTrtList'," + rowNo +","+trtNo+ ");\">"
      + "</span></acronym>";
      setChgBtnStatus010(listName, rowNo, trtNo);
  }
}


function tscrollData( target, own ){
  //send scroll event (meisai to header and record-header)
  if( target == undefined || own == undefined ) {
    ht = document.getElementById('HeaderTable');
    mt = document.getElementById('MeisaiTable');
    if( ht != null ) {
      ht.scrollLeft = mt.scrollLeft;
    }
  }else{
    ht = document.getElementById(target+'-'+'HeaderTable');
    hmt = document.getElementById(target+'-'+'MeisaiTable');
    mt = document.getElementById(   own+'-'+'MeisaiTable');
    rt = document.getElementById(   own+'-'+'RecordTable');
    kt = document.getElementById(   own+'-'+'MeisaiTable1');
    if( mt != null ) {
      if( hmt != null ) {
        hmt.scrollLeft = mt.scrollLeft;
      }
      if( ht != null ) {
        ht.scrollLeft = mt.scrollLeft;
      }
      if( rt != null ) {
        rt.scrollTop = kt.scrollTop;
        mt.scrollTop = kt.scrollTop;
      }
    }
  }
}


function jimChgSosStatus(){

   var insName = document.getElementById("chgAddInsName").value;

   if(insName == 0){
     document.getElementById("bSelectIns").disabled = true;

   }else{
     document.getElementById("bSelectIns").disabled = false;

   }
   document.getElementById("chgAddInsNo").value=insName;
  }


/**
 * <pre>
 * 新担当の変更ボタン押下時に呼ばれます。（施設責任者）
 * </pre>
 * @param index 行番号
 */
function jimReplaceInsToMr(index) {
if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
// 全てのポップアップを閉じる
jimClosePopUp(gCseViewChgWin, "gCseViewChgWin");
gCseViewSelId = index;
// パラメータの設定
jimSetParamCseViewData("gIcrReferViewWin");

// ポップアップをコール
gCseViewChgWin = cseView(gCseViewChgWin,"jimCallBackDispInsNameCseView","gCseViewChgWin");

tempIndex = index;

return false;
}


/**
 * 作業途中のデータ有無を判定する。
 */
function checkChangeData(listName){
  jkrMrChaker = 0;
  var changeFlgId = "";
  var changeFlg = "";
  var maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  var maxCol = document.fm1.trtCount.value;
  var flag = false;
  for(var rowno=0; rowno<= maxRow && maxRow > 0; rowno++) {
    if (document.fm1.insSkninDispFlg.value == "1") {
      insChgFlgId = listName + "[" + rowno + "].insChgFlg";
      insChgFlg = document.getElementsByName(insChgFlgId)[0].value;
      if (insChgFlg == "1") {
        jkrMrChaker = 1;
        flag = true;
      }
    }

    for(var trtno=1; trtno < maxCol && maxCol > 0; trtno++) {
      changeFlgId = listName + "[" + rowno + "].toJgiChgFlg" + trtno;
      changeFlg = document.getElementsByName(changeFlgId)[0].value;
      if (changeFlg == "1") {
          jkrMrChaker = 1;
          flag = true;
        }
    }
  }
  return flag;
}

/**
 * <pre>
 *  組織の表示／非表示の切り替え
 * 組織(リンク)押下時に呼ばれます。
 * </pre>
 * @param dspFlg 表示フラグ(0:非表示, 1:表示)
 * @param trtIdx 領域インデクス(１０まで) *
 * @param mode 呼出しモード(0:初期表示 1:施設別担当変更 2:施設別担当変更エラー)
 */
function dspSosNameNew(dspFlg, trtIdx, mode){
  //alert(dspFlg);
  if (document.fm1.lineCntAll.value == "0") {
    return false;
  }
  var tblWidth = Number(document.getElementById("widthTbl").value);
  var sosNameWidth = 200;
  var jgiNameWidth = 130;
  if (0 == mode) {
    // 初期表示の場合桁の幅を計算しない
      sosNameWidth = 0;
      jgiNameWidth = 0;
  }

  // 現組織展開しない
  if(dspFlg == 0){
    dsp1 = "block";
    dsp2 = "none";
    //組織
    dspTableCtrl("titleFromSosName" + trtIdx,dsp2);
    dspTableCtrl("dataFromSosName" + trtIdx,dsp2);
    dspTableCtrl("titleFromJgiName" + trtIdx,dsp2);
    dspTableCtrl("titleFromSosNameLink" + trtIdx,dsp1);
    document.getElementById("titleFromHeader" + trtIdx).colSpan=
      (Number(document.getElementById("titleFromHeader" + trtIdx).colSpan) - 1) + "";
    document.getElementById("titleTrtName" + trtIdx).colSpan=
            (Number(document.getElementById("titleTrtName" + trtIdx).colSpan) - 1) + "";
    tblWidth = tblWidth - sosNameWidth;
    document.getElementById("fromSosDisFlg" + trtIdx).value = "0";
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  // 現組織展開する
  } else if(dspFlg == 1){
    dsp1 = "none";
    dsp2 = "block";
    //組織
    dspTableCtrl("titleFromSosName" + trtIdx,dsp2);
    dspTableCtrl("dataFromSosName" + trtIdx,dsp2);
    dspTableCtrl("titleFromJgiName" + trtIdx,dsp2);
    dspTableCtrl("titleFromSosNameLink" + trtIdx,dsp1);
    document.getElementById("titleFromHeader" + trtIdx).colSpan=
      (Number(document.getElementById("titleFromHeader" + trtIdx).colSpan) + 1) + "";
    document.getElementById("titleTrtName" + trtIdx).colSpan=
            (Number(document.getElementById("titleTrtName" + trtIdx).colSpan) + 1) + "";
    tblWidth = tblWidth + sosNameWidth;
    document.getElementById("fromSosDisFlg" + trtIdx).value = "1";
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  // 新組織展開しない
  } if(dspFlg == 2){
    //alert("新組織展開");
    dsp1 = "none";
    dsp2 = "block";
    //組織
    dspTableCtrl("titleToSosName" + trtIdx,dsp2);
    dspTableCtrl("dataToSosName" + trtIdx,dsp2);
    dspTableCtrl("titleToJgiName" + trtIdx,dsp2);
    dspTableCtrl("titleToSosNameLink" + trtIdx,dsp1);
    document.getElementById("titleFromHeaderLink" + trtIdx).colSpan=
        (Number(document.getElementById("titleFromHeaderLink" + trtIdx).colSpan) + 1) + "";
    document.getElementById("titleToHeader" + trtIdx).colSpan=
        (Number(document.getElementById("titleToHeader" + trtIdx).colSpan)) + 1;
    document.getElementById("titleTrtName" + trtIdx).colSpan=
            (Number(document.getElementById("titleTrtName" + trtIdx).colSpan) + 1) + "";
    tblWidth = tblWidth + sosNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  } else if(dspFlg == 3){
      //alert("新組織閉じる");
    dsp1 = "block";
    dsp2 = "none";
    dspTableCtrl("titleToSosName" + trtIdx,dsp2);
    dspTableCtrl("dataToSosName" + trtIdx,dsp2);
    dspTableCtrl("titleToJgiName" + trtIdx,dsp2);
    dspTableCtrl("titleToSosNameLink" + trtIdx,dsp1);
    document.getElementById("titleFromHeaderLink" + trtIdx).colSpan=
        (Number(document.getElementById("titleFromHeaderLink" + trtIdx).colSpan) - 1) + "";
    document.getElementById("titleToHeader" + trtIdx).colSpan=
        (Number(document.getElementById("titleToHeader" + trtIdx).colSpan)) - 1;
    document.getElementById("titleTrtName" + trtIdx).colSpan=
            (Number(document.getElementById("titleTrtName" + trtIdx).colSpan) - 1) + "";
    tblWidth = tblWidth - sosNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  } else if(dspFlg == 5){
    //alert("現担当展開");
    dsp1 = "none";
    dsp2 = "block";
    dspTableCtrl("titleFromHeader" + trtIdx,dsp2);
    dspTableCtrl("titleToHeader" + trtIdx,dsp2);
    document.getElementById("titleFromSosNameLink" + trtIdx);
    dspTableCtrl("titleFromSosNameLink" + trtIdx,dsp2);
    dspTableCtrl("dataFromSosNameLink" + trtIdx,dsp2); //現従業員
    dspTableCtrl("titleFromHeaderLink" + trtIdx,dsp1);
    document.getElementById("titleFromHeader" + trtIdx).colSpan="1";
    document.getElementById("titleFromSosNameLink" + trtIdx).colSpan="1";
    document.getElementById("titleTrtName" + trtIdx).colSpan=
            (Number(document.getElementById("titleTrtName" + trtIdx).colSpan) + 1) + "";
    tblWidth = tblWidth + jgiNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
    document.getElementById("fromSosDisFlg" + trtIdx).value = "";
  } else if(dspFlg == 6){
    //alert("現担当閉じる");
    dsp1 = "block";
    dsp2 = "none";
    dspTableCtrl("titleFromHeader" + trtIdx,dsp2);
    dspTableCtrl("titleToHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromHeaderLink" + trtIdx,dsp1);

    dspTableCtrl("titleFromSosName" + trtIdx,dsp2);
    dspTableCtrl("titleFromJgiName" + trtIdx,dsp2);
    dspTableCtrl("titleFromSosNameLink" + trtIdx,dsp2);
    dspTableCtrl("dataFromSosName" + trtIdx,dsp2);
    dspTableCtrl("dataFromSosNameLink" + trtIdx,dsp2);
    if (document.getElementById("fromSosDisFlg" + trtIdx).value == "1") {
      tblWidth = tblWidth - jgiNameWidth - sosNameWidth;
      document.getElementById("titleTrtName" + trtIdx).colSpan=
              (Number(document.getElementById("titleTrtName" + trtIdx).colSpan) - 2) + "";
    } else {
      tblWidth = tblWidth - jgiNameWidth;
      document.getElementById("titleTrtName" + trtIdx).colSpan=
              (Number(document.getElementById("titleTrtName" + trtIdx).colSpan) - 1) + "";
    }
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
    document.getElementById("fromSosDisFlg" + trtIdx).value = "";
  }
  document.getElementById("widthTbl").value = tblWidth + "";
}

/**
 * ★へ変更ボタン活性非活性を設定する。
 */
function setAllChgBtnStatus010(listName){
  //var maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  var maxRow = 0;
  if (document.fm1.chgInsTrtListCnt) {
    maxRow = document.fm1.chgInsTrtListCnt.value;
  } else {
    maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  }
  var maxCol = document.fm1.trtCount.value;
  // 施設責任者
  for(var rowno=0; rowno<= maxRow && maxRow >= 0; rowno++) {
    setChgBtnStatus010(listName, rowno, "");
  }

  // 領域毎
  for(var trtno=1; trtno <= maxCol && maxCol >= 1; trtno++) {
    for(var rowno=0; rowno<= maxRow && maxRow >= 0; rowno++) {
      setChgBtnStatus010(listName, rowno, trtno);
    }
  }
}

function setChgBtnStatus010(listName, rowno, trtno){
  var chgBtnId = "";
  var statusId = "";
  var statusVal = "";
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

  if (trtno == "") {
      chgBtnId = "bChangeChg" + rowno + trtno;
  } else {
      chgBtnId = "bChange" + rowno + trtno;
  }
  if (document.getElementById(chgBtnId) == null) {
      return;
  } else {
  }
  //新担当未選択の場合、非活性
  if (document.fm1.changeJgiNo.value == "") {
    document.getElementById(chgBtnId).disabled = true;
  } else {
    statusId = listName + "[" + rowno + "].status" + trtno;
    statusVal = document.getElementsByName(statusId)[0].value;
    // ステタース30あるいは50以上の場合、非活性
    if (statusVal == "30" || statusVal >= "50") {
        document.getElementById(chgBtnId).disabled = true;
    } else {
        document.getElementById(chgBtnId).disabled = false;
    }
  }
}

/**
 * 副担ボタン活性非活性を設定する。
 */
function setSubAllBtnStatus010(listName){
  //2014/12/17 副担追加を行う画面では追加後の行数を考慮する
  //var maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  var maxRow = 0;
  if (document.fm1.chgInsTrtListCnt) {
      maxRow = document.fm1.chgInsTrtListCnt.value;
  }else{
      maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  }
  var maxCol = document.fm1.trtCount.value;
  var subTntAddBtnDis = document.fm1.subTntAddBtnDis.value;
  // 全行
  for(var rowno=0; rowno<= maxRow && maxRow >= 0; rowno++) {
    // 副担当ボタンある
    if (document.getElementsByName("bAddSub")[rowno] != null) {
      if (subTntAddBtnDis == "1") {
        document.getElementsByName("bAddSub")[rowno].disabled = true;
      } else {
        var disableFlg = 0; //ディフォルト非活性
        if(document.getElementById("statusFlg").value == "0"){
          //ステータスが「30:チェック中」又は「50:確定」以降の場合は非活性
          disableFlg = "0";
        }else{
          for(var trtno=1; trtno <= maxCol && maxCol >= 1; trtno++) {
            var authorityId = listName + "[" + rowno + "].authority" + trtno;
            var authority = document.getElementsByName(authorityId)[0].value;
            if (authority == "1") {
              var toJgiNameDataId = "toJgiNameData" + rowno + trtno;
              var toJgiNameDataHtml = document.getElementById(toJgiNameDataId).innerHTML;
              //20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
              var fromJgiKbId = listName + "[" + rowno + "].fromJgiKb" + trtno;
              var fromJgiKb = document.getElementsByName(fromJgiKbId)[0].value;
              var toJgiKbId = listName + "[" + rowno + "].toJgiKb" + trtno;
              var toJgiKb = document.getElementsByName(toJgiKbId)[0].value;
              if (fromJgiKb == "8" && toJgiKb == "8") { //現担当者、新担当者ともにダミーユーザの場合は非活性
                  // 非活性値保持
              } else {
              //20150402 期末期首課題対応No.227 HISOL鈴木 ADD END
              //20150402 期末期首課題対応No.227 HISOL鈴木 UPD START
              //if (toJgiNameDataHtml.indexOf("担当者選択") > 0) {
              if (toJgiNameDataHtml.indexOf("担当者選択") >= 0) {
              //20150402 期末期首課題対応No.227 HISOL鈴木 UPD END
                // 非活性値保持
              } else {
                disableFlg = "1";
              }
              //20150402 期末期首課題対応No.227 HISOL鈴木 ADD START
              }
              //20150402 期末期首課題対応No.227 HISOL鈴木 ADD END
            } else {
              //更新権限なし領域判断対象外
            }
          }
        }
        if (disableFlg == "0") {
          document.getElementsByName("bAddSub")[rowno].disabled = true;
        }else{
          document.getElementsByName("bAddSub")[rowno].disabled = false;
        }
      }
    }
  }
}

/**
 * 全担当外す・副担当外すチェックボックス活性非活性を設定する。
 */
function setAllTantoHazusuStatus010(listName){
  //2014/12/17 副担追加を行う画面では追加後の行数を考慮する
  //var maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  var maxRow = 0;
  if (document.fm1.chgInsTrtListCnt) {
      maxRow = document.fm1.chgInsTrtListCnt.value;
  }else{
      maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  }
  var maxCol = document.fm1.trtCount.value;
  // 領域毎
  for(var trtno=1; trtno <= maxCol && maxCol >= 1; trtno++) {
    for(var rowno=0; rowno<= maxRow && maxRow >= 0; rowno++) {
      setTantoHazusuStatus010(listName, rowno, trtno);
    }
  }
}

/**
 * セル別担当外す・副担当外すチェックボックス活性非活性を設定する。
 */
function setTantoHazusuStatus010(listName, rowno, trtno){
  setTantoHazusu(listName, rowno, trtno);
  setSubTantoHazusu(listName, rowno, trtno);
}

/**
 * セル別担当外すチェックボックス活性非活性を設定する。
 */
function setTantoHazusu(listName, rowno, trtno){
  //
    var flg1 = "0";
    var flg2 = "0";
    var flg3 = "0";
    var flg4 = "0";
    var flg5 = "0";
    var flg6 = "0";
    var flg7 = "0";
    var flg8 = "0";
    var flg9 = "0";
    //(1)
    var mainMrId = listName + "[" + rowno + "].mainMr";    // コントロール取得できない場合、終了
    if (document.getElementsByName(mainMrId)[0] == null) {
        return;
     }
    var mainMr = document.getElementsByName(mainMrId)[0].value;
    if (mainMr == "0") {
      flg1 = "1";
    }

    //(2)
    var tantHzsSetFlgId = listName + "[" + rowno + "].tantHzsSetFlg" + trtno;
    var tantHzsSetFlg = document.getElementsByName(tantHzsSetFlgId)[0].value;
    if (tantHzsSetFlg == "1") {
      flg2 = "1";
    }

    //(3)
    var fromMrNoId = listName + "[" + rowno + "].fromMrNo" + trtno;
    var fromMrNo = document.getElementsByName(fromMrNoId)[0].value;
    if (fromMrNo != "" && fromMrNo != "0") {
      flg3 = "1";
    }

    //(4)
    var tntMrCntId = listName + "[" + rowno + "].tntMrCnt" + trtno;
    var tntMrCnt = document.getElementsByName(tntMrCntId)[0].value;
    //2014/12/04 主担当行の場合は、副担当がいても担当外すチェックは活性の条件とする。
    //if (tntMrCnt != "") {
    if (mainMr != "0" && tntMrCnt != "") {
      if (Number(tntMrCnt) <= "1") {
        flg4 = "1";
      }
    } else {
      flg4 = "1";
    }

    //(5)
    var bBckSubTrtId = "bBckSubTrt" + rowno + trtno;
    var bBckSubTrt = document.getElementById(bBckSubTrtId);
    // 戻すボタンがある
    if (bBckSubTrt != null) {
      if (bBckSubTrt.style.display == "none") {
        flg5 = "1";
      }
    } else {
      flg5 = "1";
    }

    //(6)
    var authorityId = listName + "[" + rowno + "].authority" + trtno;
    var authority = document.getElementsByName(authorityId)[0].value;
    if (authority == "1") {
      flg6 = "1";
    }

    //(7)
    flg7 = "1";
    //(8)
    flg8 = "1";

    //(9)
    var statusId = listName + "[" + rowno + "].status" + trtno;
    var statusVal = document.getElementsByName(statusId)[0].value;
    if (statusVal == "30" || statusVal >= "50") {
    } else {
      flg9 = "1";
    }

    var idDelTan = "chkDelTanMain" + rowno + trtno;
    var delTan	= document.getElementById(idDelTan);
    if (delTan == null) {
      return;
    }
    //alert("tntMrCnt"+ tntMrCnt + ":" +flg1+flg2+flg3+flg4+flg5+flg6+flg7+flg8+flg9);
    //上記の条件をすべて満たす場合、活性
    if (flg1 == "1" && flg2 == "1" && flg3 == "1" && flg4 == "1"
      && flg5 == "1" && flg6 == "1" && flg7 == "1" && flg8 == "1" && flg9 == "1") {
      delTan.disabled = false;
    } else {
      delTan.disabled = true;
    }
}
/**
 * セル別副担当外すチェックボックス活性非活性を設定する。
 */
function setSubTantoHazusu(listName, rowno, trtno){
  // (1)「一覧項目_区分」の値が ’副’(副担当行)であること
  // (2)副担追加行（現担当ＭＲ番号が"0"もしくはＮＵＬＬ(現担当なし)）ではないこと
  // (3)該当行の「領域－現担当者の職種」および「領域－新担当者の職種」の組み合わせが、領域・職種関連定義テーブルに存在すること
  // (4)領域・領域関連定義テーブルにおいて、 「施設副担当設定フラグ」が’1’(可能)の領域であること
  // (5)該当施設・領域に「一覧項目_新担当_従業員_戻す」ボタンが表示されていないこと
  // (6)選択組織が、対象の領域について更新権限を持つこと
  // (7)組織（新）が選択対象の組織(※)であること
  // (8)組織（現）を選択している場合、組織（現）のステータスがチェック中(30)もしくは確定以降(50以上)ではないこと

  var flg1 = "0";
  var flg2 = "0";
  var flg3 = "0";
  var flg4 = "0";
  var flg5 = "0";
  var flg6 = "0";
  var flg7 = "0";
  var flg8 = "0";
  //(1)
  var mainMrId = listName + "[" + rowno + "].mainMr";    // コントロール取得できない場合、終了
  if (document.getElementsByName(mainMrId)[0] == null) {
      return;
   }
  var mainMr = document.getElementsByName(mainMrId)[0].value;
  if (mainMr == "1") {
    flg1 = "1";
  }
  //(2)
  var fromMrNoId = listName + "[" + rowno + "].fromMrNo" + trtno;
  var fromMrNo = document.getElementsByName(fromMrNoId)[0].value;
  if (fromMrNo != "" && fromMrNo != "0") {
    flg2 = "1";
  }

  //(3)
  flg3 = "1";

  //(4)
  var maxCol = document.fm1.trtCount.value;
  var insSubTantSetFlg = "0";
  var trtCdId = listName + "[" + rowno + "].trtCd" + trtno;
  var trtCd = document.getElementsByName(trtCdId)[0].value;
  for(var index=0; index < maxCol && maxCol >= 1; index++) {
    var trtTrtCdId = "ChgInsTrtTrtList" + "[" + index + "].trtCd";
    var trtTrtCd = document.getElementsByName(trtTrtCdId)[0].value;
    if (trtCd == trtTrtCd) {
      var insSubTantSetFlgId = "ChgInsTrtTrtList" + "[" + index + "].insSubTantSetFlg";
      insSubTantSetFlg = document.getElementsByName(insSubTantSetFlgId)[0].value;
      break;
    }
  }
  if (insSubTantSetFlg == "1") {
    flg4 = "1";
  }

  //(5)
  var bBckSubTrtId = "bBckSubTrt" + rowno + trtno;
  var bBckSubTrt = document.getElementById(bBckSubTrtId);
  // 戻すボタンがある
  if (bBckSubTrt != null) {
    if (bBckSubTrt.style.display == "none") {
      flg5 = "1";
    }
  } else {
    flg5 = "1";
  }

  //(6)
  var authorityId = listName + "[" + rowno + "].authority" + trtno;
  var authority = document.getElementsByName(authorityId)[0].value;
  if (authority == "1") {
    flg6 = "1";
  }

  //(7)
  flg7 = "1";

  //(8)
  var statusId = listName + "[" + rowno + "].status" + trtno;
  var statusVal = document.getElementsByName(statusId)[0].value;
  if (statusVal == "30" || statusVal >= "50") {
  } else {
    flg8 = "1";
  }

  var idDelTan = "chkDelTanSub" + rowno + trtno;
  var delTan	= document.getElementById(idDelTan);
  if (delTan == null) {
    return;
  }
  //alert(flg1+flg2+flg3+flg4+flg5+flg6+flg7+flg8);
  //上記の条件をすべて満たす場合、活性
  if (flg1 == "1" && flg2 == "1" && flg3 == "1" && flg4 == "1"
    && flg5 == "1" && flg6 == "1" && flg7 == "1" && flg8 == "1") {
    delTan.disabled = false;
  } else {
    delTan.disabled = true;
  }
}
