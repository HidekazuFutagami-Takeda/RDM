/**
 * <pre>
 *  施設固定コード複数入力のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author BHH 張
 */

/**
 * <pre>
 * アプリケーションIDを定義window名等に利用します。
 * </pre>
 */
var III_APPLICATION_ID = "III";

/**
 * スクリーンID
 */
var III_SCREEN_ID = "ImtInsInputCategores";
/** ***************************************************************** */
/* メッセージ文 管理部 */
/** ***************************************************************** */
var MSG_NUMBER = "には半角数字以外は入力できません。";
/** ***************************************************************** */



/**
 * 親ウインドウから呼び出す画面表示関数
 * 
 * @param w
 *            今から呼び出すwindowオブジェクトを受け取ります。既に存在した場合はフォーカスをあてるだけです。
 * @param callBack
 *            コールバック関数の名前をStringで受け取ります。
 * @param winVarName
 *            windowの名前を保存するエリアの名前をStringで受け取ります。 このエリアはUnLoad処理でクリアします。
 * @return 呼び出したwindowオブジェクトを返します。
 */
function iiiView(w, callBack, winVarName) {

  // フォーカスをあてる処理と２度押し対策を共通関数化
  // 戻り値がtrueならポップアップ処理を継続 falseならwindowオブジェクトを戻します。
  if (!comPopupPreCheck(w, winVarName)) {
    return (w);
  }

  // windowに名前を付ける。(現在日時を付加して)
  var winName = comCreateWindowName(III_APPLICATION_ID);

  var heightSize = eval(200 + 15 * 30);
  w = window.open("", winName, "width=400,height=" + heightSize
      + ",resizable=no,status=no,toolbar=no,scrollbars=no,titlebar=no");

  uri = "JKR100C090Init.action";

  // 検索条件などがある場合はパラメタの名前と値を生成して指定する。
  // パラメタの名前を1次元配列で指定
  jokenName = new Array(2);
  jokenName[0] = "rowCnt";
  jokenName[1] = "joinInsNo";
  //20150305 HON-B-28対応 HISOL鈴木 ADD START
  jokenName[2] = "sosSelFlg";
  jokenName[3] = "sosCd";
  //20150305 HON-B-28対応 HISOL鈴木 ADD END
  // パラメタの値を2次元配列で指定
  joken = new Array(2);
  joken[0] = new Array("15"); // 行数
  joken[1] = new Array(document.fm1.joinInsNo.value); // 固定コード
  //20150305 HON-B-28対応 HISOL鈴木 ADD START
  joken[2] = new Array(document.fm1.sosSelFlgC090.value);
  joken[3] = new Array(document.fm1.sosCdC090.value);
  //20150305 HON-B-28対応 HISOL鈴木 ADD END
  /* 条件有り呼び出しパターン */
  comPostPopup(w, uri, III_SCREEN_ID, COM_FUNC_REGISTERINIT, callBack,
      winVarName, jokenName, joken, false);
  w.focus();

  return (w);
}

/**
 * 起動時の処理を記述します。
 */
function iiiLoad(functionId) {

  //２度押し対策フラグ初期化
  comClickFlgInit();
  if (functionId == "Init") {
    //初期化の場合、親画面の医師固定コードで設定
    var insNoString = document.fm1.joinInsNo.value;
    var insNoList = insNoString.split(",");
    for (var i = 0; i < insNoList.length; i++) {
      var insNoName = "imtInsInputCategoresData[" + i + "].insNo";
      document.getElementsByName(insNoName)[0].value = insNoList[i];
    }
  }
  var insNoName = "imtInsInputCategoresData[0].insNo";
  document.getElementsByName(insNoName)[0].focus();
}

/**
 * 値を親ウインドウに返しウインドウを閉じます。 値は、親のコールバック関数に引数として渡す方式とします。
 * 
 * @param index
 *            form内実データのインデックスを受け取ります。
 */
function iiiReturn() {
  var insNo = ctcCreateInsNoString();
  // １件選択パターンの場合は、渡したい値をそのままコールバック関数に渡すことにする。
  eval("window.opener." + document.fm1.callBack.value + "(insNo)");

  iiiClose();
  return (true);
}

/**
 * iiiReturnで、このウインドウを閉じるときに呼び出されます。 単にウインドウを閉じます。
 */
function iiiClose() {
  window.close();
}

function iiiUnLoad() {
  /*
   * 呼び出し元のwindow保存エリア(jsファイル内でvar gInrViewWin=nullをしている変数)をクリア
   * これをしないと２回目呼び出したときにiiiView()でw.focus()がエラーになる。
   */
  try {
    eval("window.opener." + document.fm1.winVarName.value + "=null");
  } catch (err) {
  }
}

/**
 * <pre>
 *  確定前のチェック
 * 入力チェックを行います。
 * チェックパターンは施設固定コードの
 * 桁数(9),文字タイプ(半角数値)
 * </pre>
 * 
 * @return boolean true:OK false:エラー
 */
function iiiChkBeforeSearch() {
  var mesg = ""; // エラーメッセージ(共通チェック)
  var i;
  var rowCnt = eval(document.fm1.rowCnt.value); // 処理件数取得

  for (i = 0; i < rowCnt; i++) {
    var checkboxName = "imtInsInputCategoresData[" + i + "].checkbox";
    var docNoName = "imtInsInputCategoresData[" + i + "].insNo";

    if ((!document.getElementsByName(checkboxName)[0].checked)
        && (document.getElementsByName(docNoName)[0].value != "")) {
      // 半角数字
      if (!imtChkNumValue(document.getElementsByName(docNoName)[0].value)) {
        if (mesg == "") {
          mesg = "施設固定コード(" + eval(i + 1) + "行目)" + MSG_NUMBER;
          document.getElementsByName(docNoName)[0].focus();
        } else {
          mesg = mesg + "\n" + "施設固定コード(" + eval(i + 1) + "行目)"
              + MSG_NUMBER;
        }
      }
    }
  }
  if (mesg != "") {

    alert(mesg);

    return false;
  }

  return true;
}

/**
 * <pre>
 * 確定
 * 確定(ボタン)押下時に呼ばれます。
 * </pre>
 */
function iiiSearch() {
//	document.fm1.joinInsNo.value = "";
  // ボタン２度押し対策を、なるべく早いタイミングで行います。
  // if(!comChkSubmit(COM_CLICK_ALERT))return(false);

  if (iiiChkBeforeSearch()) {
    document.fm1.submit_register.click();
  }
}

/** ***************************************************************** */
/** ***************************************************************** */
/** ***************************************************************** */
/** * 処理名 ： 半角数字チェック ** */
/** * パラメータ ： エラーチェック対象文字列 ** */
/** * 作成者 ： 植田 雄至 ** */
/** * 作成日 ： 02/10/11 ** */
/** * 戻り値 ： true or false ** */
/** ***************************************************************** */
/** ***************************************************************** */
/** ***************************************************************** */
function imtChkNumValue(str) {

  if (str == "") {
    return true;
  }
  for (vCnt = 0; vCnt < str.length; vCnt++) {
    vCode = str.charCodeAt(vCnt);
    if (!((vCode >= 0x30) && (vCode <= 0x39))) {
      return false;
    }
  }
  return true;

}

function ctcCreateInsNoString() {

   var insNoString = "";

  var i;
  var rowCnt = eval(document.fm1.rowCnt.value);  //処理件数取得

  for(i = 0;i < rowCnt;i++){
    var checkboxName = "imtInsInputCategoresData[" + i + "].checkbox";
    var insNoName = "imtInsInputCategoresData[" + i + "].insNo";
    
    if((!document.getElementsByName(checkboxName)[0].checked) && (document.getElementsByName(insNoName)[0].value != "")){
      if (insNoString == "") {
        insNoString = "" + document.getElementsByName(insNoName)[0].value;
      } else {
        insNoString = insNoString + "," + document.getElementsByName(insNoName)[0].value;
      }
    }
  }

   return insNoString;
 }
