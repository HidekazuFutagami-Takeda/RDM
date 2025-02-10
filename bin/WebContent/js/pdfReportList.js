/**
 * <pre>
 *  PDF帳票一覧のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author 日立　花
 */

/**
 * <pre>
 *  検索
 * 検索ボタン押下時に呼ばれます。
 * </pre>
 */
function pltSearch(){

    //廃棄確認メッセージ
    if (typeof(checkChange) == "function") {
    	var rtn = checkChange();
        if (rtn == true || rtn == 1) {
        	if (!confirm("変更内容が破棄されます。よろしいですか？")){
        		return false;
        	}
        }
    }

  if( pltDateCheck() ){
    
    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
      
    //ソート区分設定
    document.fm1.orderKbn.value="2";
    
    // 検索イベント呼び出し
    document.fm1.submit_search.click();
  }
  return false;
}

/**
 * <pre>
 *  表示リセット
 * 表示リセットボタン押下時に呼ばれます。
 * </pre>
 */
function pltClear(){
  document.fm1.conditionStrTitle.value="";
  return false;
}

/**
 * <pre>
 *  リロード
 * 更新リンク押下時に呼ばれます。
 * </pre>
 */
function pltReload(){
    if( top.COM_Click_flg == false ){
        alert("既に処理を開始しています。");
        return false;
    }

    //廃棄確認メッセージ
    if (typeof(checkChange) == "function") {
    	var rtn = checkChange();
        if (rtn == true || rtn == 1) {
        	if (!confirm("変更内容が破棄されます。よろしいですか？")){
        		return false;
        	}
        }
    }

    top.COM_Click_flg = false;

    //現在ページ番号を変更せずに再検索を行う
    //更新イベント呼び出し
    document.fm1.reload_search.click();
}

/**
 * <pre>
 *  ページ切替え
 * ページ切替えリンク押下時に呼ばれます。
 * </pre>
 */
function pltPage( pageCntCur ){
    if( top.COM_Click_flg == false ){
        alert("既に処理を開始しています。");
        return false;
    }

    //廃棄確認メッセージ
    if (typeof(checkChange) == "function") {
    	var rtn = checkChange();
        if (rtn == true || rtn == 1) {
        	if (!confirm("変更内容が破棄されます。よろしいですか？")){
        		return false;
        	}
        }
    }

    top.COM_Click_flg = false;

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = pageCntCur;
    
    // 検索イベント呼び出し
    document.fm1.page_search.click();
}

/**
 * <pre>
 *  ソート
 * ソートリンク押下時に呼ばれます。
 * </pre>
 */
function pltSort( orderKbn ){
    if( top.COM_Click_flg == false ){
        alert("既に処理を開始しています。");
        return false;
    }
    
    top.COM_Click_flg = false;
    

    //廃棄確認メッセージ
    if (typeof(checkChange) == "function") {
    	var rtn = checkChange();
        if (rtn == true || rtn == 1) {
        	if (!confirm("変更内容が破棄されます。よろしいですか？")){
        		return false;
        	}
        }
    }

    //現在ページ番号変更（遷移）
    document.fm1.pageCntCur.value = 1;
    
    //ソート区分設定
    document.fm1.orderKbn.value = orderKbn;
    
    // 検索イベント呼び出し
    document.fm1.sort_search.click();
}

/**
 * <pre>
 *  PDF読み込み
 * 依頼IDリンク押下時に呼ばれます。
 * </pre>
 */
function pltPdf( requestId ){
    //選択された依頼ID
    document.fm1.selectedRequestId.value = requestId;
    // ダウンロードイベント呼び出し
    document.fm1.download_search.click();
}

/**
 * <pre>
 *  検索前のチェック
 *  入力チェックを行います。
 * </pre>
 * @return boolean true:OK false:エラー
 */
function pltDateCheck(){
  // エラーメッセージ
  var mesg   = "";

  // 期間をチェック用に編集
  var sDate = document.fm1.conditionYearStart.value + "/" +
        document.fm1.conditionMonthStart.value + "/" +
        document.fm1.conditionDateStart.value;

  var eDate = document.fm1.conditionYearEnd.value + "/" +
        document.fm1.conditionMonthEnd.value + "/" +
        document.fm1.conditionDateEnd.value;

    // 共通関数を呼び出す
  if( !(sDate=="----/--/--") ){
    if( !(comChkDate(sDate)) ){
      mesg += "依頼期間選択(開始)：不適切な年月日です。\n適切な年月日を入力するか、条件に含めない場合には\n「年・月・日」の全てに「-」を選択してください。\n";
    }
  }

    // 共通関数を呼び出す
  if( !(eDate=="----/--/--") ){
    if( !(comChkDate(eDate)) ){
      mesg += "依頼期間選択(終了)：不適切な年月日です。\n適切な年月日を入力するか、条件に含めない場合には\n「年・月・日」の全てに「-」を選択してください。\n";
    }
  }

  // 開始と終了が逆転していないかのチェック
  if( !(sDate=="----/--/--") && !(eDate=="----/--/--") ){
    if( sDate > eDate ){
        mesg += "依頼期間選択：不適切な年月日です。\n終了日は開始日より後でなくてはなりません。\n";
    }
  }

  // mesg が空でない場合、入力エラー
  if( mesg != "" ){
    alert( mesg );
    return false;
  }

  return true;
}

//add start 2003/09/30 E.Moromichi 遷移時にjsエラーになるため追加
/**
 * <pre>
 *  アンロード時の処理
 *  ポップアップなどの画面を閉じる処理を行う。
 * </pre>
 */
function pltViewUnLoad(){
  //現状は何もしない
}
//add end 2003/09/30 E.Moromichi 遷移時にjsエラーになるため追加
