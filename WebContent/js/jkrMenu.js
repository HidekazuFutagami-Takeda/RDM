/*
 * $Id: jkrMenu.js,v 1.1 2013/04/16 04:19:18 murakami Exp $
 *******************************************************************************
 * <改訂履歴>
 * 2006/04/19 片山 真二：all：1.0
 *   新規作成
 * YYYY/MM/DD 改訂者名：[フィールド名｜メソッド名]：[リビジョン番号]
 *   [改訂内容]
 *******************************************************************************
 * <既知のバグ情報>
 * YYYY/MM/DD バグ発見者名：[メソッド名]：[リビジョン番号]
 *   [バグ内容]
 */

/**
 * <pre>
 *  従業員関連メニューのJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author 片山 真二
 */

/**
 * <pre>
 *  アプリケーションIDを定義
 * window名等に利用します。
 * </pre>
 */
var JMN_APPLICATION_ID = "JMN";


/**
 * <pre>
 *  画面のロード時の処理
 * 画面のロード時の処理を記述します。
 * <pre>
 */
function jmnViewLoad(){

    var objid=document.getElementById('BlinkArea');
    if(objid != null){
        setInterval ( 'blink()',700 ) ; // 0.7秒間隔で繰返し実行します
        setTimer();
    }
}

/**
 * <pre>
 *  チェック処理中の文字列点滅用変数
 * <pre>
 */
var VorH = "visible" ;

/**
 * <pre>
 *  チェック処理中の文字列点滅
 * <pre>
 */
function blink(){
    if ( VorH == "visible" ) {
        document.getElementById('BlinkArea').style.visibility='hidden';
        VorH = "hidden" ;
    }
    else {
        document.getElementById('BlinkArea').style.visibility='visible';
        VorH = "visible" ;
    }
}

/**
 * <pre>
 * チェック中のデータが存在する場合、
 * 10秒以上、マウスの操作が行われなければ画面を更新する。
 * <pre>
 */
maxSec = 10;		//　指定ページにジャンプするまでの秒数
count  = 0;
function resetTimer()
{
  count = 0;
}
function setTimer()
{
  count++;
  if (count > maxSec) {
    var objid=document.getElementById('BlinkArea');
    if(objid != null && menuBox02.style.visibility != "hidden"){
      document.fm1.screenId.value = 'JKR000C010';
      document.fm1.functionId.value = 'View';
      comSubmitForAnyWarp(document.fm1);
    }
  }
  setTimeout("setTimer()",1000);
}

/**
 * <pre>
 * 担当変更リンク
 * 選択されたラジオボタンでメッセージ、施設展開フラグを指定する。
 * </pre>
 */
function gotoHenkoGamen(joken){

getParam();

    document.fm1.functionId.value="Init";
    if(fm1.elements["mod"][0].checked){//現在担当者の全ての施設・医師を別の担当者へ変更する
      document.fm1.screenId.value="JKR030C010";
      document.fm1.msgId.value="";
    }
    if(fm1.elements["mod"][1].checked){//営業所の市区郡別に担当者を変更する（営業所はP対象のみ）
      document.fm1.screenId.value="JKR040C030";
      document.fm1.caseKbn.value="1";
      document.fm1.msgId.value="";
      document.fm1.searchInsChg.value="0";	// 全て
      document.fm1.hoInsType.value="3";	// 対象区分に「P」を初期表示
    }
    if(fm1.elements["mod"][2].checked){//現担当者の一部の市区郡を別の担当者へ変更する。
      document.fm1.screenId.value="JKR040C030";
      document.fm1.caseKbn.value="2";
      document.fm1.searchInsChg.value="0";	// 担当先区分：全て
      document.fm1.msgId.value="M0122711"; //担当(現)で、現担当者を選択して下さい
      document.fm1.hoInsType.value="";	// 対象区分に空白を初期表示
    }
    if(fm1.elements["mod"][3].checked){//現担当者の一部の施設を別の担当者へ変更する
      document.fm1.screenId.value="JKR040C010";
      document.fm1.caseKbn.value="3";
      document.fm1.searchInsChg.value="0";	// 担当先区分：全て
      document.fm1.msgId.value="M0122711"; //担当(現)で、現担当者を選択して下さい
      document.fm1.hoInsType.value="";	// 対象区分に空白を初期表示
    }
    if(fm1.elements["mod"][4].checked){//単独先施設を複数担当先へ変更する
      document.fm1.screenId.value="JKR040C010";
      document.fm1.caseKbn.value="4";
      document.fm1.searchInsChg.value="1";	// 担当先区分：単独先
      document.fm1.msgId.value="M0122712"; //単独先から複数担当先へ変更する施設を入力し、表示ボタンをクリックして下さい
      document.fm1.hoInsType.value="";	// 対象区分に空白を初期表示
    }
    if(fm1.elements["mod"][5].checked){//複数担当施設を単独先施設へ変更する
      document.fm1.screenId.value="JKR040C010";
      document.fm1.caseKbn.value="5";
      document.fm1.msgId.value="M0122721"; //表示ボタンをクリックして下さい
      document.fm1.searchInsChg.value="2";	// 「複数担当先」を初期表示
      document.fm1.hoInsType.value="";	// 対象区分に空白を初期表示
    }
    if(fm1.elements["mod"][6].checked){//複数担当施設の主担当を変更する
      document.fm1.screenId.value="JKR040C010";
      document.fm1.caseKbn.value="6";
      document.fm1.msgId.value="M0122721"; //表示ボタンをクリックして下さい
      document.fm1.searchInsChg.value="2";	// 「複数担当先」を初期表示
      document.fm1.hoInsType.value="";	// 対象区分に空白を初期表示
    }
    if(fm1.elements["mod"][7].checked){//複数担当施設の副担当を変更する（副担当の増員・減員を含む）
      document.fm1.screenId.value="JKR040C010";
      document.fm1.caseKbn.value="7";
      document.fm1.msgId.value="M0122721"; //表示ボタンをクリックして下さい
      document.fm1.searchInsChg.value="2";	// 「複数担当先」を初期表示
      document.fm1.hoInsType.value="";	// 対象区分に空白を初期表示
    }
    if(fm1.elements["mod"][8].checked){//複数担当施設内の医師の担当を変更する
      document.fm1.screenId.value="JKR050C010";
      document.fm1.msgId.value="M0122727";
    }
    if(fm1.elements["mod"][9].checked){//複数担当施設内の所属部科の担当を変更する
      document.fm1.screenId.value="JKR050C020";
      document.fm1.msgId.value="M0122727";
    }

    comSubmitForAnyWarp(fm1);
}


/**
 * 選択画面を呼び出します。
 */
function tmpView(){
  gCseViewWin = cseView(gCseViewWin,"tmpCallBackCseView","gCseViewWin");
}

/**
 * <pre>
 * ポップアップのコールバック関数です。(単一選択、動的ポップアップ:Servlet処理有り)
 * 受け取った値を好きなように編集します。
 * 外勤では表示用の項目に値を設定し、submit用のformにキーとなる情報を保存します。
 * </pre>
 */
function tmpCallBackCseView(
  sosCd, sosName,
  jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
  bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6
){
  document.fm1.initSosCd.value = sosCd;	// パラメータ用

  // 以下戻り値
  document.fm1.sosCd.value   = sosCd;
  document.fm1.sosName.value = sosName;
  document.fm1.jgiNo.value   = jgiNo;
  document.fm1.jgiName.value = jgiName;
  document.fm1.bumonSeiName1.value = bumonSeiName1;
  document.fm1.bumonSeiName2.value = bumonSeiName2;
  document.fm1.bumonSeiName3.value = bumonSeiName3;
  document.fm1.bumonSeiName4.value = bumonSeiName4;
  document.fm1.bumonSeiName5.value = bumonSeiName5;
  document.fm1.bumonSeiName6.value = bumonSeiName6;
  document.fm1.sosCd1.value = sosCd1;
  document.fm1.sosCd2.value = sosCd2;
  document.fm1.sosCd3.value = sosCd3;
  document.fm1.sosCd4.value = sosCd4;
  document.fm1.sosCd5.value = sosCd5;
  document.fm1.sosCd6.value = sosCd6;
}

//add start S.Yamamoto 2008/06/03 新組織対応
/**
 * <pre>
 *  clear
 *   clear(リンク)押下時に呼ばれます。
 * </pre>
 */
function clearValue(name){

  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
// modify start 2008/07/31 M.Hoshino
//alert(name);
//    //組織
//    if(name == "fix") {
//	    document.fm1.selectedSosName.value="";
//	    document.fm1.selectedSosCd.value="";
//
//    //組織（新）
//    } else if(name == "plan") {
//	    document.fm1.selectedPlanSosName.value="";
//	    document.fm1.selectedSosCd.value="";
//	}

  var i;
  for(i = 0; i < document.fm1.catsel.length; i ++){
    if(document.fm1.catsel[i].checked){
      changeRadio();
      break;
    }
  }
// modify  end  2008/07/31 M.Hoshino
}

/**
 * <pre>
 *  支店権限組織選択ボタン
 *   支店権限組織選択ボタン押下時に呼ばれます。
 * </pre>
 */
function branchSosSel(name){

  //支店権限者が支店業務を選択の場合
  if(document.fm1.elements["catsel"][1].checked){

    //現組織選択ボタンを押下時
    if(name == "fix" && fm1.selectedSosName.value == ""){
      document.fm1.selectedSosName.value = document.fm1.selectedPlanSosName.value;
      document.fm1.sosSelFlg.value = "0";//新現組織フラグ(現組織：0、新組織：1)
      document.fm1.selectedPlanSosName.value = "";
    //新組織選択ボタンを押下時
    }else if(name == "plan" && fm1.selectedPlanSosName.value == ""){
      document.fm1.selectedPlanSosName.value = document.fm1.selectedSosName.value;
      document.fm1.sosSelFlg.value = "1";//新現組織フラグ(現組織：0、新組織：1)
      document.fm1.selectedSosName.value = "";
    }
    jmnView();
  }else{
    //	document.fm1.searchButton.style.display = "inline";
    //現組織選択ボタンを押下時
    if(name == "fix" && fm1.selectedSosName.value == ""){
      document.fm1.sosSelFlg.value = "0";//新現組織フラグ(現組織：0、新組織：1)
      setSentakuParam();
    //新組織選択ボタンを押下時
    }else if(name == "plan"){
      document.fm1.sosSelFlg.value = "1";//新現組織フラグ(現組織：0、新組織：1)
      setSentakuParamPlan();
    }
    jmnSearchSosCd();
  }
  return false;
}
//add end S.Yamamoto 2008/06/03 新組織対応

////////////////////////////////////////////////////
/**
 * ポップアップ画面のwindowオブジェクト保管用です。
 */
var gCseViewWin=null;

/**
 * 選択画面を呼び出します。
 * TODO 20250205　呼び出すjspに移し替える予定
 */
function jmnSearchSosCd(){

  // 2度押し対策
  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
  // 選択フラグ「1：組織」
  document.fm1.selectFlg.value	 = "1";

  gCseViewWin = cseView(gCseViewWin,"rGenJmnCallBackCseView","gCseViewWin");
  return false;
}

function nc202JmnSearchSosCd(){
	  // 2度押し対策
	  if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
	  // 選択フラグ「1：組織」
	  document.fm1.selectFlg.value	 = "1";

	  gCseViewWin = nc202CseView(gCseViewWin,"rNc202CseViewGenJmnCallBackCseView","gCseViewWin");
	  return false;
	}


/**
 * <pre>
 * ポップアップのコールバック関数です。(単一選択、動的ポップアップ:Servlet処理有り)
 * 受け取った値を好きなように編集します。
 * 外勤では表示用の項目に値を設定し、submit用のformにキーとなる情報を保存します。
 * </pre>
 */
function genJmnCallBackCseView(
  sosCd, sosName,
  jgiNo, jgiName, bumonSeiName1, bumonSeiName2, bumonSeiName3, bumonSeiName4,
  bumonSeiName5, bumonSeiName6, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6,
  brCode,distSeq,distCode,teamCode,sosTaikeiCd,bumonRank,
  bumonRyakuName, bumonRyakuName1, bumonRyakuName2, bumonRyakuName3,
bumonRyakuName4, bumonRyakuName5, bumonRyakuName6 , selectedInsDispRngFlg, selectedSosTkyFlg){
  document.fm1.initSosCd.value = sosCd;	// パラメータ用

  //組織区分(現組織)
  if (document.fm1.sosKbnPop.value == "1") {
    document.fm1.objData.value  = "1";// 対象データ区分「1：現組織」
    document.fm1.sosSelFlg.value = "0";//新現組織フラグ(現組織：0、新組織：1)

  //組織区分(新組織)
  } else if (document.fm1.sosKbnPop.value == "2") {
    document.fm1.objData.value  = "2";// 対象データ区分「2：新（予定）組織」
    document.fm1.sosSelFlg.value = "1";//新現組織フラグ(現組織：0、新組織：1)
  }

  // 以下戻り値
  // 組織従業員名称(表示用)
  var disp="";
  if (bumonSeiName2 != null && bumonSeiName2 != "") disp +=bumonSeiName2;
  if (bumonSeiName3 != null && bumonSeiName3 != "") disp += " " + bumonSeiName3;
  if (bumonSeiName4 != null && bumonSeiName4 != "") disp += " " + bumonSeiName4;
  if (jgiName != null && jgiName != "") disp += " " + jgiName;

  //現組織
  if (document.fm1.sosSelFlg.value == 0){
    document.fm1.selectedSosName.value = disp;
    if (document.fm1.selectedPlanSosName) {
        document.fm1.selectedPlanSosName.value = "";
    }

  //新組織
  }else{
    document.fm1.selectedSosName.value = "";
    if (document.fm1.selectedPlanSosName) {
      document.fm1.selectedPlanSosName.value = disp;
    }
  }

  // 検索用組織コード
  document.fm1.selectedSosCd.value = sosCd;

  document.fm1.popupSelectSosCd.value = sosCd;

  //支店コード、名称
  document.fm1.selectedSosCd2.value = sosCd2;
  document.fm1.selectedSosNm2.value = bumonSeiName2;

  //営業所コード、名称
  document.fm1.selectedSosCd3.value = sosCd3;
  document.fm1.selectedSosNm3.value = bumonSeiName3;

  sosTekiyou1.style.visibility ="hidden";
  sosTekiyou2.style.visibility ="hidden";
  sosTekiyou3.style.visibility ="hidden";
  osirase.style.display ="none";

  if(document.getElementById('menuBox01')){
    menuBox01.style.visibility ="hidden";
    menuBox02.style.visibility ="hidden";
    menuBox03.style.visibility ="hidden";
    menuBox04.style.visibility ="hidden";
    menuBox05.style.visibility ="hidden";
  }

  document.fm1.selectedBumonRank.value = getBumonRank(sosCd, sosCd1, sosCd2, sosCd3, sosCd4, sosCd5, sosCd6);
  document.fm1.selectedInsDispRngFlg.value = selectedInsDispRngFlg;
  document.fm1.selectedSosTkyFlg.value = selectedSosTkyFlg;

  //「担当変更状況」テーブルにおいて、選択組織の全データの中で、
  //ステータスが「’６０’（適用完了）もしくは、’６1'（適用時エラー）」の適用日が一つでも存在する場合、「表示ボタン」を非活性にする。
  if (selectedSosTkyFlg == '1') {
    document.fm1.ShowBtn.disabled = true;
  } else {
    document.fm1.ShowBtn.disabled = false;
  }
}

/**
 * <pre>
 * ポップアップのコールバック関数です。(単一選択、動的ポップアップ:Servlet処理有り)
 * 受け取った値を好きなように編集します。
 * 外勤では表示用の項目に値を設定し、submit用のformにキーとなる情報を保存します。
 * </pre>
 */
function rGenJmnCallBackCseView(
  bumonRank, sosCd,
  bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){
	document.fm1.bumonRank.value    = bumonRank;
	document.fm1.bumonSeiName.value = bumonSeiName;
	document.fm1.sosCd.value        = sosCd;
	document.fm1.brCode.value       = brCode;
	document.fm1.distCode.value     = distCode;
	document.fm1.upSosCode.value    = upSosCode;
	document.fm1.upBumonRank.value  = upBumonRank;
	document.fm1.upBrCode.value     = upBrCode;
	document.fm1.upDistCode.value   = upDistCode;
}

function rNc202CseViewGenJmnCallBackCseView(
	sosCd,bumonSeiName,
	jgiNo, jgiName, trtCd, brCode, distCode,trtGrpCd,trtNm,mrCat){
	document.fm1.sosCd.value        = sosCd;
	document.fm1.bumonRyakuName.value = bumonSeiName;
	document.fm1.jgiNo.value        = jgiNo;
	document.fm1.jgiName.value      = jgiName;
	document.fm1.sosCd.value        = trtCd
	document.fm1.brCode.value       = brCode;
	document.fm1.distCode.value     = distCode;
	document.fm1.trtGrpCd.value     = trtGrpCd;
	document.fm1.trtNm.value        = trtNm;
	document.fm1.mrCat.value        = mrCat;
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

////////////////////////////////////////////////////