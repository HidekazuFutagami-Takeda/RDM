/**
 * <pre>
 *  所属部科複数選択のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author BHH 張
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var CDC_APPLICATION_ID = "CDC";

/**
 * スクリーンID
 */
var CDC_SCREEN_ID = "CatDeptsCombo";


/**
 * <pre>
 *  デバッグ用関数
 * gCdcDebug = true でデバッグします。
 * </pre>
 */
var gCdcDebug = false;
function cdcDebug(str){
  if(gCdcDebug) alert(str);
  return(true);
}

/**
 * 親ウインドウから呼び出す画面表示関数
 * @param w 今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack コールバック関数の名前をStringで受け取ります。
 * @param winVarName windowの名前を保存するエリアの名前をStringで受け取ります。
 *           このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function cdcView(w,callBack,winVarName){

  //****************************************************************
  // ポップアップ起動中にウィンドウが閉じられると
  // windowオブジェクトがString型に変換されてしまう場合があるため
  // 型変換された場合はNULLをセットして初期化する
  //****************************************************************
  if(typeof(w) == 'string') {
    w = null;
  } else {
    if(!comPopupPreCheck(w, winVarName)){
      return(w);
    }
  }

  w = window.open ("",comCreateWindowName(CDC_APPLICATION_ID),"width=610,height=500,resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no");

  // パラメタの設定
  var checkedCodes = document.fm1.cdcCheckedCodes;
  var jokenName = [];
  var joken = [];
  for (var i = 0; i < checkedCodes.length; i++) {
    jokenName[jokenName.length] = "cdcCheckedCodes";
    joken[joken.length] = new Array(checkedCodes[i].value);
  }
  jokenName[jokenName.length] = "paramInsNo";
  //joken[joken.length] = new Array(document.fm1.insNo070.value);
  joken[joken.length] = new Array(document.fm1.paramInsNo.value);
  jokenName[jokenName.length] = "backScreenId";
  joken[joken.length] = new Array(document.fm1.backScreenId.value);

  /*条件有り呼び出しパターン    ここを変更*/
  if(callBack = "tmpCallBackShozokuViewRDM"){
	  comPostPopup(w,"NC204Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);
	  w.focus();
	  return(w);
  }
  if(callBack = "tmpCallBackPostViewRDM"){
	  comPostPopup(w,"NC205Init.action",CDC_SCREEN_ID,COM_FUNC_VIEWINIT,callBack,winVarName,jokenName,joken,false);
	  w.focus();
	  return(w);
  }

}

/**
 * 起動時の処理を記述します。
 */
function cdcLoad(){

  //２度押し対策フラグ初期化
  comClickFlgInit();

  // セッションから取得したチェック済み都道府県・市区郡を画面に反映する。
  var checkedList = cdcDecodeCodeData( document.fm1.cdcCheckedCodes );
  var checkers = document.fm1.checkers;
  var deptCode = document.fm1.deptCode;
  for (var i = 0; i < checkedList.length; i++) {
    for (var j = 0; j < deptCode.length; j++) {
      if (checkedList[i].deptCode == deptCode[j].value) {
        checkers[j].checked = true;
      }
    }
  }
  // 表示欄に現在のチェック済みを表示
  //cdcCheckedDisplay();

  cdcSetCheckedItem();
  //document.fm1.kensakuKana.focus();
}

/**
 * 値を親ウインドウに返しウインドウを閉じます。
 * 値は、親のコールバック関数に引数として渡す方式とします。
 * @param index form内実データのインデックスを受け取ります。
 */
function cdcReturn(index){
  //ボタン２度押し対策を、なるべく早いタイミングで行います。
  if(!comChkSubmit(COM_CLICK_ALERT))return(false);
  // チェック済リストの取得。
  var resultList = cdcCreateCheckedList();
  //１件選択パターンの場合は、渡したい値をそのままコールバック関数に渡すことにする。
  eval("window.opener." + document.fm1.callBack.value + "(resultList, cdcEncodeCodeData(resultList))");
  cdcClose();
  return(true);
}

/**
 * cdcReturnで、このウインドウを閉じるときに呼び出されます。
 * 単にウインドウを閉じます。
 */
function cdcClose(){
  window.close();
}

function cdcUnLoad(){
  try{
    eval("window.opener." + document.fm0.winVarName.value + "=null");
  }catch(err){
  }
}

/**
 * <pre>
 *  検索前のチェック
 * 入力チェックを行います。
 * </pre>
 * @return boolean true:OK false:エラー
 */
function cdcChkBeforeSearch(){

  var checkSingle = "";
  var checkKanji = "";
  var kanaMess = "";      //カナチェック用エラーメッセージ保存変数
  var kanjiMess = "";     //漢字チェック用エラーメッセージ保存変数
  var errMess= "";        //表示用エラーメッセージ
  var newLineKanji = "";  //改行コード
  var newLineKana = "";   //改行コード

  //漢字名の入力チェック(記号文字数20)
  checkKanji = document.fm1.kensakuKanj.value;
  if(checkKanji != ""){
    kanjiMess = cdcChkNoSign(checkKanji);
    if(kanjiMess != ""){
      newLineKanji = "\n";
    }
  }

  //全角カナの入力チェック(全角文字数10)
  checkSingle = document.fm1.kensakuKana.value;
  if(checkSingle != ""){
    kanaMess = comChkFullSizeChar(checkSingle,'全角カナ：','10');
    if(kanaMess != ""){
      newLineKana = "\n";
    }
  }


  if((kanjiMess != "") || (kanaMess != "")) {
    errMess = kanjiMess + newLineKanji + kanaMess + newLineKana;
    alert(errMess);
    if(kanjiMess != ""){
        document.fm1.kensakuKanj.focus();
    }else if(kanaMess != ""){
        document.fm1.kensakuKana.focus();
    }
    return false;
  }

  return true;
}

/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function cdcSearch(){

  if(cdcChkBeforeSearch()){
    //ボタン２度押し対策を、なるべく早いタイミングで行います。
    if(!comChkSubmit(COM_CLICK_ALERT))return(false);

      //現在ページ番号変更（遷移）
      document.fm1.pageCntCur.value = 1;

      // 検索イベント呼び出し
      document.fm1.submit_search.click();
  }
}

/**
 * 検索ボタンクリック時
 */
function deptSearch(){

	//ボタン２度押し対策をなるべく早くやる(実際のSubmitのときではなく)
	if(!comChkSubmit(COM_CLICK_ALERT))return(false);

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;

    // 検索イベント呼び出し
    document.fm1.submit_search.click();
}

/**
 * チェックボックスクリック時
 */
function rCdcCheckMaxSize(inputObject) {
  var checkedList = cdcCreateCheckedList();
  // チェック済み数のチェック
}

/**
 * 表示欄に現在のチェック済みを表示
 */
function cdcCheckedDisplay() {
  var checkedList = cdcCreateCheckedList();
  var preDisplay = document.getElementById("preDisplay");
  preDisplay.innerHTML = ""; // 初期化
  for (var i = 0; i < checkedList.length; i++) {
    preDisplay.innerHTML += cdcDecodeDecimal(checkedList[i].kanjName);
    if (i < checkedList.length - 1) {
      preDisplay.innerHTML += ",";
    }
  }
  document.fm1.display.value = preDisplay.innerText;
}

/**
 * 所属部科の名称とコードを保持する
 * オブジェクトクラス
 */
function CdcCodeData() {
  this.deptCode = "";
  this.kanaName = "";
  this.kanjName = "";
}

/**
 * 10進数の参照文字列に変換できるように数値化だけしておく。
 * 既に変換済みの場合は処理を行わない。
 * ※親画面からポップアップにマルチバイトを渡すと文字化けするため、
 *   チェック済みを記憶する際には一貫して参照文字を利用する。
 *
 * @param  targetText 対象文字列
 * @return {String}数値変換された文字列
 */
function cdcEncodeDecimal(targetText){
  var resultText = "";
  if (targetText != "" && targetText.indexOf("[") == -1) {
    for (var i = 0; i < targetText.length; i++) {
       resultText += ("["+(targetText.charCodeAt(i))+"]");
    }
  } else {
    resultText = targetText;
  }
  return resultText;
}

/**
 * cdcEncodeDecimal関数によって置き換えられた文字列を
 * 完全な参照文字列にする。
 *
 * @param  s 対象文字列
 * @return {String}参照文字列に変換された文字列
 */
function cdcDecodeDecimal(s) {
  while (s.indexOf("[") != -1) {
     s = s.replace("[", "&#");
  }
  while (s.indexOf("]") != -1) {
    s = s.replace("]", ";");
  }
  return s;
}

/**
 * チェック済みを記憶するためにServlet送信用の
 * 文字列を作成する。
 *
 * @param targetList 「new CdcCodeData()」で作成されるオブジェクト配列
 * @return {Array} 結果配列
 */
function cdcEncodeCodeData(targetList) {
  var resultList = [];
  for (var i = 0; i < targetList.length; i++) {
    resultList[resultList.length] = ""
      + targetList[i].deptCode + ","
      + cdcEncodeDecimal( targetList[i].kanaName ) + ","
      + cdcEncodeDecimal( targetList[i].kanjName );
  }
  return resultList;
}

/**
 * Sevletから取得したチェック済みをJavaScriptで
 * 使用できるように、オブジェクト配列に変換する。
 *
 * @param  targetList コードと名称を「,」区切りで整形した<input>フォーム配列
 * @return {Array} 結果配列
 */
function cdcDecodeCodeData(targetList) {
  var resultList = [];
  for (var i = 0; i < targetList.length; i++) {
    // ダミーは対象外とする。
    if (targetList[i].value != "dummy") {
      var codes = targetList[i].value.split(",");
      var codeData = new CdcCodeData();
      codeData.deptCode = codes[0];
      codeData.kanaName = codes[1];
      codeData.kanjName = codes[2];
      resultList[resultList.length] = codeData;
    }
  }
  return resultList;
}

function cdcCreateCheckedList() {

  var checkers = document.fm1.checkers;
  var deptCode = document.fm1.deptCode;
  var kanaName = document.fm1.kanaName;
  var kanjName = document.fm1.kanjName;

  // 遷移前に選択したチェック済みを取得する。
  var checkedList = cdcDecodeCodeData( document.fm1.cdcCheckedCodes );

  // 画面のチェック済みを取得する。
  for (var i = 0; i < checkers.length; i++) {
    // ダミーは無視する。
    if (checkers[i].value == "dummy") {
    // チェック済みはリストに追加する。
    } else if (checkers[i].checked) {
      var codeData = new CdcCodeData();
      codeData.deptCode = deptCode[i].value;
      codeData.kanaName = kanaName[i].value;
      codeData.kanjName = kanjName[i].value;
      checkedList[checkedList.length] = codeData;
    // チェックなしはダミーとする。
    } else {
      for (var j = 0; j < checkedList.length; j++) {
        if (deptCode[i].value == checkedList[j].deptCode) {
          checkedList[j] = "dummy";
        }
      }
    }
  }

  // ダミーを取り除く
  var resultList = [];
  for (var i = 0; i < checkedList.length; i++) {
    if (checkedList[i] != "dummy") {
      resultList[resultList.length] = checkedList[i];
    }
  }
  // deptCodeで一意にして、deptCodeの昇順ソートで返す。
  return cdcSortCode( cdcToUnique(resultList) );
}

/**
 * deptCodeで一意にする。
 *
 * @param  targetList 「new CdcCodeData()」で作成されるオブジェクト配列
 * @return {Array} 結果配列
 */
function cdcToUnique(targetList) {
  var resultList = [];
  for (var i = 0; i < targetList.length; i++) {
    var unique = true;
    for (var j = 0; j < resultList.length; j++) {
      if (targetList[i].deptCode == resultList[j].deptCode) {
        unique = false;
        break;
      }
    }
    if (unique) {
      resultList[resultList.length] = targetList[i];
    }
  }
  return resultList;
}

/**
 * deptCodeで昇順にソートする。
 */
function cdcSortCode(targetList) {
  var sortedCodeList = [];
  for (var i = 0; i < targetList.length; i++) {
    sortedCodeList[sortedCodeList.length] = targetList[i].deptCode;
  }
  sortedCodeList.sort();

  var resultList = [];
  for (var i = 0; i < sortedCodeList.length; i++) {
    for (var j = 0; j < targetList.length; j++) {
      if (sortedCodeList[i] == targetList[j].deptCode) {
        resultList[resultList.length] = targetList[j];
      }
    }
  }
  return resultList;
}

/**
 * 検索文字列の使用不可文字
 * @param str 入力された検索文字列
 * @return mess エラーメッセージ
 */
function cdcChkNoSign(str){
  var mess = "";
  var flg = 0;
  for ( vCnt = 0; vCnt < str.length; vCnt++ ){
    vCode = str.charCodeAt(vCnt);

    if (
      vCode == 0x21 || // !
      vCode == 0x22 || // "
      vCode == 0x23 || // #
      vCode == 0x24 || // $
      vCode == 0x25 || // % 検索可能だがパターンマッチを行う為指定
      vCode == 0x26 || // &
      vCode == 0x27 || // '
      vCode == 0x28 || // (
      vCode == 0x29 || // )
      vCode == 0x2a || // *
      vCode == 0x2c || // ,
      vCode == 0x2d || // -
      vCode == 0x3b || // ;
      vCode == 0x3d || // =
      vCode == 0x3e || // >
      vCode == 0x3f || // ?
      vCode == 0x5b || // [
      vCode == 0x5d || // ]
      vCode == 0x5f || // _ 検索可能だがパターンマッチを行う為指定
      vCode == 0x7b || // {
      vCode == 0x7c || // |
      vCode == 0x7d || // }
      vCode == 0x7e	 // ~

      )
    {
      break;
    }
    flg++;
  }

  if((flg != str.length) && (str.length > 40)){
    mess += "漢字：には半角記号は入力できません。\n";
    mess += "漢字：の制限字数を越えています。";
  }else if(flg != str.length){
    mess += "漢字：には半角記号は入力できません。";
  }else if(flg > 40){
    mess += "漢字：の制限字数を越えています。";
  }
  return mess;
}

/**
 * 検索文字列の使用不可文字除去
 * @param str 入力された検索文字列
 * @return mess エラーメッセージ
 */
function cdcChkSingleByte(str){
  var stringKana = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンァィゥェォャュョッ゛゜ｰ ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ１２３４５６７８９０！＃＄＆（）＝－～＾｜｛［'＠＋；＊：］｝？／＞．＜";
  var flg = 0;
  var mess = "";
  for(var i=0; i<str.length; i++){
    var checkInput = str.charAt(i);
    for (var j=0; j<stringKana.length; j++){
      if(checkInput == stringKana.charAt(j)){
        flg++;
        break;
      }
    }
  }
  if((flg != str.length) && (str.length > 20)){
    mess += "全角カナ：には全角カナ文字又は全角英数字(大文字)以外は入力できません。\n";
    mess += "全角カナ：の制限字数を越えています。";
  }else if(flg != str.length){
    mess += "全角カナ：には全角カナ文字又は全角英数字(大文字)以外は入力できません。";
  }else if(flg > 20){
    mess += "全角カナ：の制限字数を越えています。";
  }
  return mess;
}


function cdcSetCheckedItem() {

  var checkers = document.fm1.checkers;
  var deptCode = document.fm1.deptCode;

  // 遷移前に選択したチェック済みを取得する。
  var checkedList = cdcDecodeCodeData( document.fm1.cdcCheckedCodes );

  // 画面のチェック済みを取得する。
  for (var i = 0; i < checkers.length; i++) {
    // ダミーは無視する。
    for (var j = 0; j < checkedList.length; j++) {
      if (deptCode[i].value == checkedList[j].deptCode) {
        checkers[i].checked = "true";
      }
    }
  }
}
