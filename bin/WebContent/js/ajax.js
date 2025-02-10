/**
 * Ajaxオブジェクト
 * 
 * [使用例]
 * // 通信開始
 * var ajax = new Ajax();
 * ajax.setUrl(document.fm0.action);
 * ajax.setCallback(ここに記述した関数がコールバックされます);
 * ajax.setParameter("ScreenId"  , "foo");
 * ajax.setParameter("FunctionId", "foo");
 * ajax.setParameter("FooParam"  , "foo");
 * ajax.setParameter("no1"       , "1");
 * ajax.send();
 *
 * // コールバック
 * function foo(response) {
 *     // 任意処理
 * }
 */
var Ajax = function() {

  return {

    /**
     * コールバック関数
     * (private)
     * 
     * 第一引数にresponseTextを受け取る関数を作成して
     * 関数名をsetCallbackメソッドで設定します。
     */
    callback: "",

    /**
     * 送信先URL
     * (private)
     */
    url: "",

    /**
     * パラメータ配列
     * (private)
     */
    parameters: [],
    
    // add start 2010/03/03 T.Oonisi J10-0002 登録画面用処理追加
    /**
     * 送信文字タイプ
     * (private)
    */
    charset: "",
    
    /**
     * 文字タイプの設定
     * 
     * @param {String} charName 文字タイプ
     */
    setCharset: function(charName){
      var str = "; charset=";
      
      if(charName != ""){
        this.charset = str + charName;
      }
    },
    
    /**
     * コールバックフラグ
     * (private)
    */
    isCallback: true,
    
    
    /**
     * コールバックフラグの設定
     * 
     * @param {int} flg フラグタイプ
     */
    setCallbackFlg: function(flg){
      
      //引数あり
      if(flg == 0){
        this.isCallback = true;
      //引数なし
      }else{
        this.isCallback = false;
      }
    },
    // add end   2010/03/03 T.Oonisi J10-0002 登録画面用処理追加

    /**
     * コールバック関数の設定
     * 
     * @param {String} callback コールバック用の関数名
     */
    setCallback: function(callback) {
      this.callback = callback;
    },

    setUrl: function(url) {
      this.url = url;
    },

    /**
     * 送信パラメータの設定
     * 
     * @param {String} k キー値
     * @param {String} v 設定値
     */
    setParameter: function(k, v) {
      this.parameters[k] = v;
    },

    /**
     * 非同期通信を開始
     */
    send: function() {
      this.setParameter("dummy", "dummy");	// ダミーを設定しておく。
      var conn = this.getConnection();
      if (!conn) {
        alert("XMLHttpRequest Error");
        return;
      }
      var readyStateChangeHandler = this.readyStateChangeHandler;
      var callback = this.callback;
      var isCallback = this.isCallback;
      conn.onreadystatechange = function() {
        readyStateChangeHandler(conn, callback,isCallback);
      };
      conn.open("POST", this.url, "true");
      //conn.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      conn.setRequestHeader("Content-Type", "application/x-www-form-urlencoded" + this.charset);
      conn.send(this.createPostData());
      this.parameters = [];
    },

    /**
     * リクエストオブジェクトの取得
     * (private)
     * 
     * @return {Object} conn HTTPコネクション
     */
    getConnection: function() {
      var conn;
      if (window.XMLHttpRequest) {             // Mozilla, Firefox, Safari, IE7
        conn = new XMLHttpRequest();
      } else if (window.ActiveXObject) {       // IE5, IE6
        try {
          conn = new ActiveXObject("Msxml2.XMLHTTP");    // MSXML3
        } catch(e) {
          conn = new ActiveXObject("Microsoft.XMLHTTP"); // MSXML2まで
        }
      } else {
        conn = null;
      }
      return conn;
    },

    /**
     * POST送信データの生成
     * (private)
     * 
     * @return {String} POST送信用のパラメータデータ
     */
    createPostData: function() {
      var postData = [];
      for (var k in this.parameters) {
          postData.push(k + "=" + encodeURIComponent(this.parameters[k]));
      }
      return postData.join("&");
    },

    /**
     * コールバック関数の呼び出し
     * (private)
     * 
     * @param {Object} conn     HTTPコネクション
     * @param {String} callback コールバック関数名
     */
    readyStateChangeHandler: function(conn, callback,isCallback) {
      if (conn.readyState == 4) {
        if (conn.status == 200) {
          // modify start 2010/03/03 T.Oonisi J10-0002 登録画面用処理追加
          //eval( callback + "(conn.responseText);" );
          //参照用
          if(isCallback){
            eval( callback + "(conn.responseText);" );
          //登録用
          }else{
            //今回は時間がなかったのでこれで解決
            var str = conn.getResponseHeader("Content-Location");
            eval( callback + "(str);" );
          }
          // modify end   2010/03/03 T.Oonisi J10-0002 登録画面用処理追加
        }
      }
    }
  };
}

/**
 * Ajax二度押し防止管理クラス
 * 
 * [使用例]
 * // 二度押し防止設定
 * if (!AjaxStatus.toBusy()) return;
 *
 * // 二度押し防止解除
 * AjaxStatus.toIdle();
 */
var AjaxStatus = {

  /** ステータス */
  status: false,

  /** 初期状態に戻す */
  init: function() {
    this.status = false;
  },

  /**
   * 使用中にする
   *
   * @return {Boolean} true=Ajax通信が可能、false=Ajax通信中
   */
  toBusy: function() {
    if (this.status) {
      return false;
    } else {
      this.status = true;
      return true;
    }
  },

  /**
   * 開放する
   */
  toIdle: function() {
    this.status = false;
  }
}
