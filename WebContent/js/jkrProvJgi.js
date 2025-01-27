/**
 * <pre>
 *  仮従業員登録画面のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author BHH 張
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var JPJ_APPLICATION_ID = "JPJ";
/**
 * <pre>
 *  デバッグ用関数
 * gJpjDebug = true でデバッグします。
 * </pre>
 */
var gJpjDebug = false;
function jpjDebug(str){
  if(gJpjDebug) alert(str);
  return(true);
}
var destructMsg = "";
var sosCdNotSelectMsg = "";
var mrCatNotSelectMsg = "";
var mrCatListCount = 0;

/**
 * <pre>
 *  画面のロード時の処理
 * 画面のロード時の処理を記述します。
 * <pre>
 */
function jpjViewLoad(destruct,sosCdNotSelect,mrCatNotSelect,mrCatCount,sosFixFlg,haitaErrFlg,haitaMsg){
  destructMsg = destruct;
  sosCdNotSelectMsg = sosCdNotSelect;
  mrCatNotSelectMsg = mrCatNotSelect;
  mrCatListCount = mrCatCount;
  jpjDispChgLink();
  
  //　排他エラー
  if (haitaErrFlg == 1) {
    alert(haitaMsg);
  }
}
/**
 * <pre>
 *  担当変更画面のリンクの表示切替を行います。
 * <pre>
 */
function jpjDispChgLink() {

  // 担当変更画面への全リンク
  var linkAll = document.getElementById('linkChgAll');
  // 「複数担当先施設の医師担当変更の処理へ」のリンク
  var linkChgDoc = document.getElementById('linkChgDoc');
  
  // 組織コード確定フラグ
  var sosCdFixFlg = document.fm1.sosCdFixFlg.value;
  // 「複数担当先施設の医師担当変更の処理へ」のリンクフラグ
  var showDocChgFlg = document.fm1.showDocChgFlg.value;
  //alert(sosCdFixFlg);
  //alert(showDocChgFlg);
  //20150318 期末期首課題対応No.50 HISOL鈴木 UPD START
  //if (sosCdFixFlg == 1) {
  //20150318 期末期首課題対応No.50 HISOL鈴木 UPD END
    linkAll.style.display = "inline";		// 表示
    if (showDocChgFlg == 1) {
      linkChgDoc.style.display = "inline";		// 表示
    } else {
      linkChgDoc.style.display = "none";		// 非表示
    }
  //20150318 期末期首課題対応No.50 HISOL鈴木 UPD START
  //} else {
  //  linkAll.style.display = "none";		// 非表示
  //}
  //20150318 期末期首課題対応No.50 HISOL鈴木 UPD END
}

/**
 * <pre>
 *  担当変更リンク押下時の処理
 * 「担当引継ぎへ」「施設別・地区別（施設）担当変更へ 」
 * 「複数担当先施設の医師担当変更の処理へ」のリンク押下時に呼ばれます。
 * </pre>
 */
function jpjChgLink(linkNo){

  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;

  switch(linkNo){
  //「担当引継ぎへ」
  case 0:
    document.fm1.screenId.value		="JKR030C010";
    break;
  //「施設別・地区別（施設）担当変更へ 」
  case 1:
    document.fm1.screenId.value		= "JKR040C010";
    break;
  //「複数担当先施設の医師担当変更の処理へ」
  case 2:
    document.fm1.screenId.value		= "JKR050C010";
    break;
  }
  document.fm1.functionId.value='Init';
  // メニューパラメータを全て渡す
  //document.fm1.selectedSosCd.value	= document.fm1.sosCdFix.value;
  //document.fm1.selectedSosNm.value	= document.fm1.sosNameFix.value;
  if (document.fm1.topChangedSosCd.value != "") {
    document.fm1.selectedSosCd.value  = document.fm1.topChangedSosCd.value;
    document.fm1.selectedSosNm.value  = document.fm1.topChangedSosNm.value;
    document.fm1.selectedSosCd2.value = document.fm1.topChangedSosCd2.value;
    document.fm1.selectedSosNm2.value = document.fm1.topChangedSosNm2.value;
    document.fm1.selectedSosCd3.value = document.fm1.topChangedSosCd3.value;
    document.fm1.selectedSosNm3.value = document.fm1.topChangedSosNm3.value;
  }
  
    comSubmitForAnyWarp(document.fm1);
    
}

var jkrMrChaker = 0;

/**
 * <pre>
 *  検索
 * 検索(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jpjSearch(){
  if(jkrDestructChack()){

    //現在ページ番号変更（遷移）
      document.fm1.pageCntCur.value = 1;
      //ソート区分設定
      document.fm1.orderKbn.value="1";
      document.fm1.screenId.value	= "JKR010C010";
      document.fm1.functionId.value = 'Search';
      
    if(document.fm1.searchSosCd.value == ''){
      alert(sosCdNotSelectMsg);
      return false;
    }
    
    //各画面で変えられた組織を保持しトップメニューへ表示させる
    setTopChangedSos();

    //20150202 HISOL Suzuki 本番課題No.25対応 ADD START
    //選択された組織情報格納（ポップアップ用）
    if (document.getElementById("searchFromSosCdPop") && document.getElementById("searchToSosCdPop")) {
      //選択された組織情報格納
      if (document.fm1.searchSosCd.value == "") {
        if(document.fm1.sosSelFlg.value == "0"){
            document.getElementById("searchFromSosCdPop").value = document.fm1.searchSosCd.value;
            document.getElementById("searchToSosCdPop").value = "";
        }else{
            document.getElementById("searchFromSosCdPop").value = "";
            document.getElementById("searchToSosCdPop").value = document.fm1.searchSosCd.value;
        }
      }
    }
    //20150202 HISOL Suzuki 本番課題No.25対応 ADD END

    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  }
}

/**
 * <pre>
 *  検索前のチェック
 * 入力チェックを行います。
 * </pre>
 * @return boolean true:OK false:エラー
 */
function jpjChkBeforeSearch(){
  //制御配列
  argInfo = new Array();
  argInfo[0] = "検索文字列;"+COM_CHECK_NO_SIGN;

  //対象オブジェクト配列
  argObj = new Array();
  argObj[0] = document.fm1.kensakuChar;

  mesg = comChkValue(argInfo,argObj);
  if(mesg != ""){
    return false;
  }
  return true;
}

/**
 * メインテーブル(<DIV>~</DIV>)のスクロールにあわせて
 * 見出しテーブル/アイテムテーブルをスクロールさせる関数
 *
 */
function jpjSyncScrolling(){
  document.all.insTitle.scrollTop = document.all.insTableData.scrollTop;
  document.all.insHeader.scrollLeft = document.all.insTableData.scrollLeft;
}

/**
 * メインテーブル(<DIV>~</DIV>)のスクロールにあわせて
 * 見出しテーブル/アイテムテーブルをスクロールさせる関数
 *
 */
function jpjOffSyncScrolling(){
  document.all.insTitleOff.scrollTop = document.all.insTableDataOff.scrollTop;
  document.all.insHeaderOff.scrollLeft = document.all.insTableDataOff.scrollLeft;
}

/**
 * 組織・従業員選択用ウィンドウオブジェクト
 */
var gCseViewSelectWin	= null;		// 組織・担当(現)
var gCseViewToJgiWin	= null;		// 新担当者
var gCseViewAddJgiWin	= null;		// 仮従業員組織

/**
 * ポップアップ選択行番号
 */
var gCseViewRowNo		= 0;


var SELECT_FLG_SOS		= "1";		// 組織のみ

var SELECT_JGI_FLG_SOS		= "2";		// 従業員のみ

/**
 * <pre>
 * 組織従業員選択ポップアップ用の組織コード
 * </pre>
 */
var IEIHON_SOS_CD = "01050";	// 医薬営業本部
var MARKET_SOS_CD = "11848";	// マーケティング部
/**
 * <pre>
 * 前回選択したMR種類
 * </pre>
 */
var gSelectedMrCat = "";

/**
 * 組織・従業員選択画面を呼び出します。(検索項目用)
 *@param winName 呼び出し元項目名
 */
function jpjCseView( winName ){

  // 全てのポップアップを閉じる
  jpjClosePopUp(gCseViewSelectWin, "gCseViewSelectWin");
  document.fm1.selectFlgPop.value = "1"; //組織
  if (document.fm1.searchSosCd.value == "") {
    document.fm1.initSosCdPop.value = document.fm1.defaultSosCd.value;
  } else {
    document.fm1.initSosCdPop.value = document.fm1.searchSosCd.value;
  }
  document.fm1.sosKbnPop.value = "2"; // 新組織
  document.fm1.sknnFlgPop.value = "0";
  document.fm1.insFlgPop.value = "0";
  document.fm1.topMenuFlgPop.value = "0";
  document.fm1.authorityPop.value = "1";
  document.fm1.bumonRankTopPop.value = "";
//  document.fm1.bumonRankBtmPop.value = "";
  document.fm1.bumonRankBtmPop.value = "3";
  document.fm1.topSosCdPop.value = "";
  document.fm1.defTblFlgPop.value = "1";
  document.fm1.shokushuFlgPop.value = "0";
  document.fm1.ztTntFlgPop.value = "0";
  document.fm1.jokenSetCdPop.value = document.fm1.selectedJgiJoken.value;
  document.fm1.menuTrtGrpCdPop.value = document.fm1.trtGrpCd.value;
  document.fm1.menuSosCdPop.value = "";
  document.fm1.selectableBumonrankPop.value = "";
  document.fm1.insNoPop.value = "";
  document.fm1.trtCdPop.value = "";
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD START
  if(document.fm1.sosSelFlg.value == "0"){
      if (document.fm1.searchSosCd.value == "") {
          document.fm1.sosCdFromPop.value = document.fm1.defaultSosCd.value;
      } else {
          document.fm1.sosCdFromPop.value = document.fm1.searchSosCd.value;
      }
  }else{
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD END
      document.fm1.sosCdFromPop.value = "";
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD START
  }
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD END
  
  gCseViewSelectWin = cseView(gCseViewSelectWin,"jpjCallBackFromCseView","gCseViewSelectWin","");
}

/**
 * <pre>
 * 組織・従業員選択ポップアップのコールバック関数。
 * 検索項目の「組織・担当(現)」の選択ボタン押下時に呼ばれます。
 * ポップアップで選択した値をフォームに設定します。
 * </pre>
 */
function jpjCallBackFromCseView(
  sosCd, sosName,
  jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
  bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
  ,brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank
){
  var showName	=	bumonSeiName2
          + ((bumonSeiName3 != "")?" ":"") + bumonSeiName3
          + ((bumonSeiName4 != "")?" ":"") + bumonSeiName4
          + ((bumonSeiName5 != "")?" ":"") + bumonSeiName5
          + ((bumonSeiName6 != "")?" ":"") + bumonSeiName6;
  // 表示用組織名
  document.fm1.searchSosName.value = showName;
  // 検索用組織コード
  document.fm1.searchSosCd.value = sosCd;
  document.fm1.searchBumonRank.value = bumonRank;

  //トップメニューに戻った場合のため、変更された組織を保存する
  changeSosCdForTopMenu(0, bumonRank, sosCd2, sosCd3, sosCd4,bumonSeiName2, bumonSeiName3, bumonSeiName4);
}

/**
 * <pre>
 * 組織従業員選択ポップアップの先頭組織コード取得関数
 * 検索項目のMR種類に応じて表示する先頭組織を変更します。
 * </pre>
 *@param joken 表示条件
 *@return topSosCd 先頭組織コード
 */
function jpjGetTopSosCd(joken) {

  // MR種類
  var mrCat		= document.fm1.searchMrCat.value;
  // 先頭組織コード(戻り値)
  var topSosCd	= "";

  // 本部から選択する場合は、全組織から任意に組織選択できるようにする
  if (joken == 'F') {
    if ( topSosCd == "" ) topSosCd = IEIHON_SOS_CD;

  // 支店権限者かつ施設の営業所間移動(営業所MRの担当変更)の場合は
  // 自支店内の組織を選択可能に設定
  } else if (joken == 'A') {
    topSosCd = document.fm0.sosCd1.value;

  // 本部以外の場合は、検索項目のMR種類で絞る
  } else {
    // 営業所MR
    if (mrCat == JKR_MRCAT_EIGYOU) {
      topSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    // ワクチンMR
    } else if (mrCat == JKR_MRCAT_VAC) {
      topSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    // EMR
    } else if (mrCat == JKR_MRCAT_EMR) {
      //topSosCd = MARKET_SOS_CD;	// マーケティング部
      topSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    // LMR
    } else if (mrCat == JKR_MRCAT_LMR) {
      topSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    // その他の専門MRの場合 (※今後、MR種類に専門MR以外が追加された場合は別途対応が必要になります) writed by A.Iida 2007/02/16
    } else {
      topSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    }
  }

  return topSosCd;
}

/**
 * <pre>
 * 組織従業員選択ポップアップの初期組織コード取得関数
 * 検索項目のMR種類に応じて表示する初期組織を変更します。
 * </pre>
 *@param joken 表示条件
 *@return initSosCd 初期組織コード
 */
function jpjGetInitSosCd(joken) {

  // MR種類
  var mrCat		= document.fm1.searchMrCat.value;
  // 先頭組織コード(戻り値)
  var initSosCd	= document.fm0.initSosCd.value;

  // 本部から選択する場合は、全組織から任意に組織選択できるようにする
  if (joken == 'F') {
    if ( initSosCd == "" ) initSosCd = IEIHON_SOS_CD;

  // 支店権限者かつ施設の営業所間移動(営業所MRの担当変更)の場合は
  // 自支店内の組織を選択可能に設定
  } else if (joken == 'A') {
    initSosCd = document.fm0.sosCd1.value;

  // 本部以外の場合は、検索項目のMR種類で絞る
  } else {

    // 営業所MR
    if (mrCat == JKR_MRCAT_EIGYOU && initSosCd == "") {
      initSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    // ワクチンMR
    } else if (mrCat == JKR_MRCAT_VAC && initSosCd == "") {
      initSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    // EMR
    } else if (mrCat == JKR_MRCAT_EMR && initSosCd == "") {
      initSosCd = MARKET_SOS_CD;	// マーケティング部
    // LMR
    } else if (mrCat == JKR_MRCAT_LMR && initSosCd == "") {
      initSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    // その他の専門MRの場合 (※今後、MR種類に専門MR以外が追加された場合は別途対応が必要になります) writed by A.Iida 2007/02/16
    } else {
      initSosCd = IEIHON_SOS_CD;	// 医薬営業本部
    }

  }

  return initSosCd;
}



/**
 * <pre>
 * 既定値に戻す
 * 組織従業員名称(組織・担当(現))を既定値に戻します。
 * </pre>
 */
function jpjFromCseViewDef(){
  // 検索用
  document.fm1.searchSosCd.value = document.fm1.defaultSosCd.value;
  document.fm1.searchSosName.value = document.fm1.defaultSosName.value;
  document.fm1.searchBumonRank.value = document.fm1.defaultBumonRank.value;
  
  //既定値に戻す場合の組織情報のリセット
  clearTopChangedSos();
}

/**
 * <pre>
 *  全てのポップアップを閉じます。
 * </pre>
 */
function jpjClosePopUp(targetWin,targetWinName){

  if(jpjCheckPopUp()){

    // 対象ポップアップが存在すればフォーカスを当てる
    if(targetWin != null){
      targetWin.focus();
    }

    // 組織選択
    if(gCseViewSelectWin != null && targetWinName != "gCseViewSelectWin"){
      gCseViewSelectWin.close();
      gCseViewSelectWin = null;
    }
    // 従業員選択
    if(gCseViewToJgiWin != null && targetWinName != "gCseViewToJgiWin"){
      gCseViewToJgiWin.close();
      gCseViewToJgiWin = null;
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
function jpjCheckPopUp() {

  // 本画面で使用する全ポップアップウィンドウオブジェクトを対象にチェック
  if(typeof(gCseViewSelectWin) =='string')	return false;	// 組織選択
  if(typeof(gCseViewToJgiWin) =='string')		return false;	// 従業員選択

  // 全ウィンドウが正常ならばtrue
  return true;
}

/**
 * <pre>
 * clear(リンク)押下時に呼ばれます。
 *@param name クリア項目名
 * </pre>
 */
function jpjClear() {

  // 組織･担当(現)
  document.fm1.searchSosName.value = "";
  document.fm1.searchSosCd.value = "";
  document.fm1.searchBumonRank.value = "";
}

var mrName = "";
var jgiMrCat = "";
var jgiSosCd = "";
var gIndex = 0;
var addCount = 0;
var tempCount = "0";

/**
 * <pre>
 * 仮従業員を一行追加時のレイアウト
 * </pre>
 */

function createTableObject(_tagId) {
  return {
    tagId: _tagId,
    size: 0,
    table: {},
    tbody: {},
    columnText: [],
    columnId: [],
    columnClass: [],
    columnBackgroundColor: [],
    setColumnText: function(k, v) {
      this.columnText[k] = v;
    },
    setColumnId: function(k, v) {
      this.columnId[k] = v;
    },
    setColumnClass: function(k, v) {
      this.columnClass[k] = v;
    },
    setColumnBackgroundColor: function(k, v) {
      this.columnBackgroundColor[k] = v;
    },
    addRow: function() {
      this.refresh();
      var trTag = document.createElement("tr");
      this.tbody.appendChild( this.createTrTag(trTag) );
      this.columnText = [];
      this.size++;
    },
    insertRow: function (inElem){
      this.refresh();
      var trs = this.tbody.childNodes;
      for (var i = 0; i < trs.length; i++) {
        if (trs[i].id == inElem.parentNode.parentNode.id) {
          var trTag = this.table.insertRow( i + 1 );
          this.createTrTag(trTag);
          break;
        }
      }
      this.columnText = [];
      this.size++;
    },
    deleteRow: function(inElem) {
      this.refresh();
      var inputId = inElem.parentNode.parentNode.id;
      var rows = this.tbody.childNodes;
      for (var i = 0; i < rows.length; i++) {
        if (rows[i].id == inputId) {
          this.table.deleteRow(i);
          break;
        }
      }
    },
    createTrTag: function(trTag) {
      for (var i = 0; i < this.columnText.length; i++) {
        var tdTag = document.createElement("td");
        tdTag.innerHTML = this.columnText[i];
        if (this.columnId[i]) {
          tdTag.id = this.columnId[i];
        }
        if (this.columnClass[i]) {
          tdTag.className = this.columnClass[i];
        }
        if (this.columnBackgroundColor[i]) {
          tdTag.style.backgroundColor = this.columnBackgroundColor[i];
        }
        trTag.appendChild(tdTag);
      }
      trTag.id = this.size;
      return trTag;
    },
    refresh: function () {
      this.table = document.getElementById(this.tagId);
      var tbodyElems = this.table.childNodes;
      this.tbody = tbodyElems[0];
    }

  }
}

/**
 * <pre>
 * スクロールバーの設定
 * </pre>
 */

function syncScrolling(){
  document.all.insTitle.scrollTop = document.all.insTableData.scrollTop;
  document.all.insHeader.scrollLeft = document.all.insTableData.scrollLeft;
}


/**
 * 従業員選択画面を呼び出します。(追加従業員選択用)
 *@param winName 呼び出し元項目名
 */
function jgiCseView(winName,jgiSosCd,index){
  // 全てのポップアップを閉じる
  jpjClosePopUp(gCseViewToJgiWin, "gCseViewToJgiWin");
  gIndex = index;
  document.fm1.selectFlgPop.value = "2"; //従業員
  var toSosCd = "jkrProvJgiData[" + index + "].toSosCd";
  var toSosCdValue = document.getElementsByName(toSosCd)[0].value; 
  
  var searchSosCd = document.fm1.searchSosCd.value;
  if (searchSosCd == "") {
  } else {
    jgiSosCd = searchSosCd;
  }
  
  if (toSosCdValue == "") {
    document.fm1.initSosCdPop.value = jgiSosCd;
  } else {
    document.fm1.initSosCdPop.value = toSosCdValue;
  }
  document.fm1.sosKbnPop.value = "2"; // 新組織
  document.fm1.sknnFlgPop.value = "0";
  document.fm1.insFlgPop.value = "0";
  document.fm1.topMenuFlgPop.value = "0";
  document.fm1.authorityPop.value = "1";
  document.fm1.bumonRankTopPop.value = "";
  document.fm1.bumonRankBtmPop.value = "";
  document.fm1.topSosCdPop.value = "";
  document.fm1.defTblFlgPop.value = "1";
  document.fm1.shokushuFlgPop.value = "1";
  document.fm1.ztTntFlgPop.value = "0";
  document.fm1.jokenSetCdPop.value = document.fm1.selectedJgiJoken.value;
  document.fm1.menuTrtGrpCdPop.value = document.fm1.trtGrpCd.value;
  document.fm1.menuSosCdPop.value = "";
  document.fm1.selectableBumonrankPop.value = "";
  document.fm1.insNoPop.value = "";
  document.fm1.trtCdPop.value = "";
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD START
  if(document.fm1.sosSelFlg.value == "0"){
      if (document.fm1.searchSosCd.value == "") {
          document.fm1.sosCdFromPop.value = document.fm1.defaultSosCd.value;
      } else {
          document.fm1.sosCdFromPop.value = document.fm1.searchSosCd.value;
      }
  }else{
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD END
      document.fm1.sosCdFromPop.value = "";
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD START
  }
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD END
  document.fm1.krJgiNoDispFlgPop.value = "1";
//20150202 HISOL Suzuki 本番課題No.25対応 ADD START
  document.fm1.sosCdToPop.value = document.fm1.searchToSosCdPop.value;  // 新組織コード
  document.fm1.trtTntFlgPop.value = 1; // 領域担当者フラグ
//20150202 HISOL Suzuki 本番課題No.25対応 ADD END
  
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  // ポップアップをコール
  gCseViewToJgiWin = cseView(gCseViewToJgiWin,"jpjCallBackToJgiCseView","gCseViewToJgiWin");
}

/**
 * <pre>
 * 組織・従業員選択ポップアップのコールバック関数。
 * 一覧項目の「新担当者」のリンク押下時に呼ばれます。
 * ポップアップで選択した値をフォームに設定します。
 * </pre>
 */
function jpjCallBackToJgiCseView(
  sosCd, sosName,
  jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
  bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
){
  // ポップアップ選択行番号の取得
  
  var index = gIndex;
  var id = "mrName" + index;
  var clearId = "clear"+ index;
  // 従業員名称
  document.getElementById(id).innerHTML = jgiName;

  //クリア（リンク）の有無
  document.getElementById(clearId).innerHTML = "clear";

  var toMrNo = "jkrProvJgiData[" + index + "].toMrNo";
  document.getElementsByName(toMrNo)[0].value = jgiNo;
  var toSosCd = "jkrProvJgiData[" + index + "].toSosCd";
  document.getElementsByName(toSosCd)[0].value = sosCd;
  
  jkrMrChaker++;
}


/**
 * <pre>
 * clear（リンク）押下時に呼ばれます。
 * 振替担当者（リンク）押下時のポップアップでの選択時
 * 設定された、従業員名、従業員番号をクリアします。
 * </pre>
 */

function jpjJgiNoClear(rowNo){

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}

  var dataCount = rowNo;
  var id = "mrName" + rowNo;
  var clearId = "clear"+ dataCount;

  // 従業員名称
  document.getElementById(id).innerHTML = "振替担当者";

  //クリア（リンク）の有無
  document.getElementById(clearId).innerHTML = "";

  var toMrNo = "jkrProvJgiData[" + rowNo + "].toMrNo";
  document.getElementsByName(toMrNo)[0].value = "";
  var toSosCd = "jkrProvJgiData[" + rowNo + "].toSosCd";
  document.getElementsByName(toSosCd)[0].value = "";
}

/**
 * <pre>
 *  * 新規登録(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jpjRegistCheckIt(registMsg){
  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  var admin = confirm(registMsg);

  if(admin){
    jpjRegister();
  }else{
    return false;
  }
}

/**
 * <pre>
 *  担当先なしにチェックされていた場合
 *  該当者に対して設定済みのデータの有無をチェックする
 * </pre>
 */
function jpjTantouCheck(msg,cntFlg,obj,index){

  var admin ="";
  var tantoNashiOld = "jkrProvJgiData[" + index + "].tantoNashiOld";
  var initStatus = document.getElementsByName(tantoNashiOld)[0].value;

  // 初期チェックオン（担当なし）、チェックオフに
  //if(initStatus == "false" && obj.checked == true){
  if(obj.checked == true){
    //一覧表示時に取得した担当件数（担当変更情報（担当ＭＲ）、担当変更情報（ＭＲ施設領域）、
    //担当変更情報（ＭＲ施設医師領域）、担当変更情報（施設責任者）
    //より、対象従業員をキーにそれぞれ取得）のいずれかが１件以上存在する場合、
    if(cntFlg == 1){
      admin = confirm(msg);
    }else{
      admin = 'true';
    }

  }else{
    jkrMrChaker++;
  }

  if(admin){
    obj.checked = true;
    jkrMrChaker++;
  }else{
    obj.checked = false;
  }
}

/**
 * <pre>
 *  担当先なしにチェックされていた場合
 *  該当者に対して設定済みのデータの有無をチェックする
 * </pre>
 */
function jpjDelTantouCheck(msg,cntFlg,obj){

  var admin ="";
  
  if(obj.checked == true){
    //新担当に設定されている従業員に、担当情報が設定されている場合
    if(cntFlg == 1){
      admin = confirm(msg);
    }else{
      admin = 'true';
    }

  }else{
    jkrMrChaker++;
  }

  if(admin){
    obj.checked = true;
    jkrMrChaker++;
  }else{
    obj.checked = false;
  }
}

/**
 * <pre>
 * 追加（ボタン）押下後、一行追加
 * </pre>
 */

function createTableObjectOff(_tagId) {
  return {
    tagId: _tagId,
    size: 0,
    table: {},
    tbody: {},
    columnText: [],
    columnId: [],
    columnClass: [],
    columnBackgroundColor: [],
    setColumnText: function(k, v) {
      this.columnText[k] = v;
    },
    setColumnId: function(k, v) {
      this.columnId[k] = v;
    },
    setColumnClass: function(k, v) {
      this.columnClass[k] = v;
    },
    setColumnBackgroundColor: function(k, v) {
      this.columnBackgroundColor[k] = v;
    },
    addRow: function() {
      this.refresh();
      var trTag = document.createElement("tr");
      this.tbody.appendChild( this.createTrTag(trTag) );
      this.columnText = [];
      this.size++;
    },
    insertRow: function (inElem){
      this.refresh();
      var trs = this.tbody.childNodes;
      for (var i = 0; i < trs.length; i++) {
        if (trs[i].id == inElem.parentNode.parentNode.id) {
          var trTag = this.table.insertRow( i + 1 );
          this.createTrTag(trTag);
          break;
        }
      }
      this.columnText = [];
      this.size++;
    },
    deleteRow: function(inElem) {
      this.refresh();
      var inputId = inElem.parentNode.parentNode.id;
      var rows = this.tbody.childNodes;
      for (var i = 0; i < rows.length; i++) {
        if (rows[i].id == inputId) {
          this.table.deleteRow(i);
          break;
        }
      }
    },
    createTrTag: function(trTag) {
      for (var i = 0; i < this.columnText.length; i++) {
        var tdTag = document.createElement("td");
        tdTag.innerHTML = this.columnText[i];
        if (this.columnId[i]) {
          tdTag.id = this.columnId[i];
        }
        if (this.columnClass[i]) {
          tdTag.className = this.columnClass[i];
        }
        if (this.columnBackgroundColor[i]) {
          tdTag.style.backgroundColor = this.columnBackgroundColor[i];
        }
        trTag.appendChild(tdTag);
      }
      trTag.id = this.size;
      return trTag;
    },
    refresh: function () {
      this.table = document.getElementById(this.tagId);
      var tbodyElems = this.table.childNodes;
      this.tbody = tbodyElems[0];
    }

  }
}
var tbOff = createTableObjectOff("Table2");
var hiddenTbOff = createTableObject("formTableOff");


/**
 * <pre>
 * 仮従業員を一行追加時のレイアウト
 * </pre>
 */
function jpjaddOff(kbn, hiddenCount, sosCd, sosName) {
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  
  if (kbn == 1) {
    if (checkMrCatSelect() == false) {
      return false;
    }
  }
  
  if (kbn == 2) {
    // 組織選択行追加  
    } else {
      var searchSosCd = document.fm1.searchSosCd.value;
//      var searchSosName = document.fm1.searchSosName.value;
      if (searchSosCd == "") {
      } else {
        sosCd = searchSosCd;
//        sosName = searchSosName;
      }
    } 

  var index = eval(Number(hiddenCount) + addCount);
  
  var mrCat = "";         // MR種類
  var mrCatName	= "";	// MR種類名
  var shokushuCd = "";         // 職種
  var shokushuName	= "";	// 職種名
  var maxRnbn = 0;        // 連番最大値

  if (mrCatListCount <= 1) {
    mrCat = document.fm1.searchMrCat.value;
    mrCatName	= document.fm1.searchMrCatName.value;
  } else {
    mrCatName	= document.fm1.searchMrCat.options[document.fm1.searchMrCat.selectedIndex].innerHTML;
    mrCat       = document.fm1.searchMrCat.options[document.fm1.searchMrCat.selectedIndex].value;
  }
  
  //該当MRの連番最大値取得
  for (var i = 0 ; i < mrCatListCount; i ++) {
    var mrCatItem = "jkrMrCatData[" + i + "].mrCat";
    var mrCatValue = document.getElementsByName(mrCatItem)[0].value;
    var maxRnbnItem = "jkrMrCatData[" + i + "].maxRnbn";
    var maxRnbnValue = document.getElementsByName(maxRnbnItem)[0].value;
    var shokushuCdItem = "jkrMrCatData[" + i + "].shokushuCd";
    var shokushuNameItem = "jkrMrCatData[" + i + "].shokushuName";
    
    if (mrCat == mrCatValue) {
      maxRnbn = maxRnbnValue;
      shokushuCd = document.getElementsByName(shokushuCdItem)[0].value;
      shokushuName = document.getElementsByName(shokushuNameItem)[0].value;
      //退避項目の値も＋１
      document.getElementsByName(maxRnbnItem)[0].value = Number(maxRnbn) + 1;
      break;
    }
  }
  maxRnbn = Number(maxRnbn) + 1;
  
  tbOff.setColumnText (0, '<span id="delCheckID' + index + '"><input type="checkbox" name="jkrProvJgiData[' + index + '].delCheck" value="true" id=JKR010C010Init_jkrProvJgiData_' + index + '__delCheck"/><input type="hidden" id="__checkbox_JKR010C010Init_jkrProvJgiData_' + index + '__delCheck" " name="__checkbox_jkrProvJgiData[' + index + '].delCheck" value="true" /></span>');
  tbOff.setColumnId   (0, "center");
  tbOff.setColumnClass(0, "comTableItem");
  tbOff.setColumnBackgroundColor(0, "#FFFF66");
  tbOff.setColumnText (1, "仮");
  tbOff.setColumnId   (1, "center");
  tbOff.setColumnClass(1, "comTableItem");
  tbOff.setColumnBackgroundColor(1, "#FFFF66");

  tbOff.setColumnText (2, sosName );
  tbOff.setColumnClass(2, "comTableItem");
  tbOff.setColumnBackgroundColor(2, "#FFFF66");
  tbOff.setColumnText (3, '<span style="width:100px">' + mrCatName + maxRnbn +"</span><span>&nbsp&nbsp→&nbsp;&nbsp;&nbsp;&nbsp;<span>振替担当者</span> ");
  tbOff.setColumnClass(3, "comTableItem");
  tbOff.setColumnBackgroundColor(3, "#FFFF66");
  tbOff.setColumnText (4, '<span id="hurikeID' + index + '"><input type="checkbox" name="jkrProvJgiData[' + index + '].tantoNashi" value="true" disabled="disabled" id=JKR010C010Init_jkrProvJgiData_' + index + '__tantoNashi"/><input type="hidden" id="__checkbox_JKR010C010Init_jkrProvJgiData_' + index + '__tantoNashi" " name="__checkbox_jkrProvJgiData[' + index + '].tantoNashi" value="true" disabled="disabled" /></span>');
  tbOff.setColumnId   (4, "center");
  tbOff.setColumnClass(4, "comTableItem");
  tbOff.setColumnBackgroundColor(4, "#FFFF66");

  tbOff.setColumnText (5, shokushuName);
  tbOff.setColumnId   (5, "center");
  tbOff.setColumnClass(5, "comTableItem");
  tbOff.setColumnBackgroundColor(5, "#FFFF66");

  tbOff.addRow();
  addCount++;
  
  
  hiddenTbOff.setColumnText (0, '<input type="hidden" name="jkrProvJgiData[' + index + '].tennyu" value="仮" id="JKR010C010Init_jkrProvJgiData_' + index + '__tennyu"/>');
  hiddenTbOff.setColumnText (1, '<input type="hidden" name="jkrProvJgiData[' + index + '].viewSosName" value="' + sosName + '" id="JKR010C010Init_jkrProvJgiData_' + index + '__viewSosName"/>');
  hiddenTbOff.setColumnText (2, '<input type="hidden" name="jkrProvJgiData[' + index + '].jgiName" value="' + mrCatName + maxRnbn + '" id="JKR010C010Init_jkrProvJgiData_' + index + '__jgiName"/>');
  hiddenTbOff.setColumnText (3, '<input type="hidden" name="jkrProvJgiData[' + index + '].sosCd" value="' + sosCd + '" id="JKR010C010Init_jkrProvJgiData_' + index + '__sosCd"/>');
  hiddenTbOff.setColumnText (4, '<input type="hidden" name="jkrProvJgiData[' + index + '].jgiKb" value="7" id="JKR010C010Init_jkrProvJgiData_' + index + '__jgiKb"/>');
  hiddenTbOff.setColumnText (5, '<input type="hidden" name="jkrProvJgiData[' + index + '].jgiNo" value="" id="JKR010C010Init_jkrProvJgiData_' + index + '__jgiNo"/>');
  hiddenTbOff.setColumnText (6, '<input type="hidden" name="jkrProvJgiData[' + index + '].moveFlg" value="" id="JKR010C010Init_jkrProvJgiData_' + index + '__moveFlg"/>');
  hiddenTbOff.setColumnText (7, '<input type="hidden" name="jkrProvJgiData[' + index + '].shokushuCd" value="' + shokushuCd + '" id="JKR010C010Init_jkrProvJgiData_' + index + '__shokushuCd"/>');
  hiddenTbOff.setColumnText (9, '<input type="hidden" name="jkrProvJgiData[' + index + '].shokushuName" value="' + shokushuName + '" id="JKR010C010Init_jkrProvJgiData_' + index + '__shokushuName"/>');
  hiddenTbOff.setColumnText (10, '<input type="hidden" name="jkrProvJgiData[' + index + '].mrCat" value="' + mrCat + '" id="JKR010C010Init_jkrProvJgiData_' + index + '__mrCat"/>');
  hiddenTbOff.setColumnText (11, '<input type="hidden" name="jkrProvJgiData[' + index + '].setCd" value="" id="JKR010C010Init_jkrProvJgiData_' + index + '__setCd"/>');
  hiddenTbOff.setColumnText (12, '<input type="hidden" name="jkrProvJgiData[' + index + '].cntFlg" value="" id="JKR010C010Init_jkrProvJgiData_' + index + '__cntFlg"/>');
  hiddenTbOff.setColumnText (13, '<input type="hidden" name="jkrProvJgiData[' + index + '].toSosCd" value="" id="JKR010C010Init_jkrProvJgiData_' + index + '__toSosCd"/>');
  hiddenTbOff.setColumnText (14, '<input type="hidden" name="jkrProvJgiData[' + index + '].toMrNo" value="" id="JKR010C010Init_jkrProvJgiData_' + index + '__toMrNo"/>');
  hiddenTbOff.setColumnText (15, '<input type="hidden" name="jkrProvJgiData[' + index + '].tantoNashiOld" value="false" id="JKR010C010Init_jkrProvJgiData_' + index + '__tantoNashiOld"/>');

  hiddenTbOff.addRow();
  jkrMrChaker++;
  var focusId = 'delCheckID'+index+'';
  document.getElementById(focusId).firstChild.focus()
}
/**
 * <pre>
 *  表示リセット
 * 表示リセット(リンク)押下時に呼ばれます。
 * </pre>
 */
function jpjViewInit(){
  if(jkrDestructChack()){
      document.fm1.screenId.value	= "JKR010C010";
      document.fm1.functionId.value = 'Init';

      //表示リセット時の組織リセット
      resetTopChangedSos();
      
    // 検索イベント呼び出し
    comSubmitForAnyWarp(fm1);
  }
}

/**
 * <pre>
 *  新規登録
 * 新規登録(ボタン)押下時に呼ばれます。
 * </pre>
 */
function jpjRegister(){

  document.fm1.screenId.value	= "JKR010C010";
    document.fm1.functionId.value = 'Register';

  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * 組織・従業員選択画面を呼び出します。(仮従業員追加用)
 *@param winName 呼び出し元項目名
 */
function jpjAddCseView( winName , initSosCd, defaultSoscd, hiddenCount){
  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  if (checkMrCatSelect() == false) {
    return;
  }
  
  var searchSosCd = document.fm1.searchSosCd.value;
  if (searchSosCd == "") {
  } else {
    initSosCd = searchSosCd;
    defaultSoscd = searchSosCd;
  }
  // 行追加の為の行数
  tempCount = hiddenCount;

  // 全てのポップアップを閉じる
  jpjClosePopUp(gCseViewToJgiWin, "gCseViewToJgiWin");

  document.fm1.selectFlgPop.value = "1"; //組織
  document.fm1.initSosCdPop.value = initSosCd;
  document.fm1.sosKbnPop.value = "2"; // 新組織
  document.fm1.sknnFlgPop.value = "0";
  document.fm1.insFlgPop.value = "0";
  document.fm1.topMenuFlgPop.value = "0";
  document.fm1.authorityPop.value = "";
  document.fm1.bumonRankTopPop.value = "3";
  document.fm1.bumonRankBtmPop.value = "4";
  document.fm1.topSosCdPop.value = defaultSoscd;
  document.fm1.defTblFlgPop.value = "0";
  document.fm1.shokushuFlgPop.value = "0";
  document.fm1.ztTntFlgPop.value = "0";
  document.fm1.jokenSetCdPop.value = document.fm1.selectedJgiJoken.value;
  document.fm1.menuTrtGrpCdPop.value = "";
  document.fm1.menuSosCdPop.value = "";
  document.fm1.selectableBumonrankPop.value = "3";
  document.fm1.insNoPop.value = "";
  document.fm1.trtCdPop.value = "";
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD START
  if(document.fm1.sosSelFlg.value == "0"){
      if (document.fm1.searchSosCd.value == "") {
          document.fm1.sosCdFromPop.value = document.fm1.defaultSosCd.value;
      } else {
          document.fm1.sosCdFromPop.value = document.fm1.searchSosCd.value;
      }
  }else{
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD END
      document.fm1.sosCdFromPop.value = "";
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD START
  }
//20150127 HISOL Suzuki ST-B-352対応(m_sos_mst_planの結合条件変更) ADD END
//20150202 HISOL Suzuki 本番課題No.25対応 ADD START
  document.fm1.sosCdToPop.value = document.fm1.searchToSosCdPop.value;  // 新組織コード
  document.fm1.trtTntFlgPop.value = 1; // 領域担当者フラグ
//20150202 HISOL Suzuki 本番課題No.25対応 ADD END
  gCseViewAddJgiWin = cseView(gCseViewAddJgiWin,"jpjAddCallBackFromCseView","gCseViewAddJgiWin","");
}

/**
 * <pre>
 * 組織・従業員選択ポップアップのコールバック関数。
 * 「仮従業員を追加する」ボタン押下時に呼ばれます。
 * ポップアップで選択した値をフォームに設定します。
 * </pre>
 */
function jpjAddCallBackFromCseView(
  sosCd, sosName,
  jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
  bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
   ,brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
  bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3, bumonRyakuName4, bumonRyakuName5, bumonRyakuName6
){

  var showName	=	bumonRyakuName2 + bumonRyakuName3 + bumonRyakuName4;

  // 一行レイアウト追加
  jpjaddOff(2, tempCount, sosCd, showName);

}

function checkMrCatSelect() {
  var mrCatName = ""; //MR種類
  if (mrCatListCount <= 1) {
    mrCatName	= document.fm1.searchMrCatName.value;
  } else {
    mrCatName	= document.fm1.searchMrCat.options[document.fm1.searchMrCat.selectedIndex].innerHTML;
  }
  if (mrCatName == '') {
    alert(mrCatNotSelectMsg);
    return false;
  }
  return true;
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

  document.fm1.functionId.value = 'JKR010C010Page';
  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}

/**
 * <pre>
 *  ソート
 * ソートリンク押下時に呼ばれます。
 * </pre>
 */
function pltSort( orderKbn ){
  // 変更内容破棄確認チェック
  if (!jkrDestructChack()) return false;
  
  //現在ページ番号変更（遷移）
  document.fm1.pageCntCur.value = 1;
  
  //ソート区分設定
  document.fm1.orderKbn.value = orderKbn;

  document.fm1.functionId.value = 'JKR010C010Sort';

  // 検索イベント呼び出し
  comSubmitForAnyWarp(fm1);
}
