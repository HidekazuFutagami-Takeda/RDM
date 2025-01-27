/**
 * <pre>
 *  施設・特定品目別担当変更のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author BHH 趙
 */

/**
 * <pre>
 *  組織の表示／非表示の切り替え
 * 組織(リンク)押下時に呼ばれます。
 * </pre>
 * @param dspFlg 表示フラグ(0:非表示, 1:表示)
 * @param prodIdx 領域インデクス(１０まで) * 
 */
function dspSosName020(dspFlg, prodIdx){
  if (document.fm1.lineCntAll.value == "0") {
    return false;
  }
  var tblWidth = Number(document.fm1.widthTbl.value);

  var sosNameWidth = 200;
  // 現組織展開しない
  if(dspFlg == 0){
    dsp1 = "block";
    dsp2 = "none";
    //組織
    dspTableCtrl("titleFromSosHeader" + prodIdx,dsp2);
    dspTableCtrl("dataFromSosHeader" + prodIdx,dsp2);
    dspTableCtrl("titleFromJgiHeader" + prodIdx,dsp2);
    dspTableCtrl("titleFromSosJgiHeader" + prodIdx,dsp1);
    document.getElementById("titleFromHeader" + prodIdx).colSpan=
      (Number(document.getElementById("titleFromHeader" + prodIdx).colSpan) - 1) + "";
    document.getElementById("titleHeader" + prodIdx).colSpan=
            (Number(document.getElementById("titleHeader" + prodIdx).colSpan) - 1) + "";
    tblWidth = tblWidth - sosNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  // 現組織展開する
  } else if(dspFlg == 1){
    dsp1 = "none";
    dsp2 = "block";
    //組織
    dspTableCtrl("titleFromSosHeader" + prodIdx,dsp2);
    dspTableCtrl("dataFromSosHeader" + prodIdx,dsp2);
    dspTableCtrl("titleFromJgiHeader" + prodIdx,dsp2);
    dspTableCtrl("titleFromSosJgiHeader" + prodIdx,dsp1);
    document.getElementById("titleFromHeader" + prodIdx).colSpan=
      (Number(document.getElementById("titleFromHeader" + prodIdx).colSpan) + 1) + "";
    document.getElementById("titleHeader" + prodIdx).colSpan=
            (Number(document.getElementById("titleHeader" + prodIdx).colSpan) + 1) + "";
    tblWidth = tblWidth + sosNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  // 新組織展開しない
  } if(dspFlg == 2){
    dsp1 = "none";
    dsp2 = "block";
    //組織
    dspTableCtrl("titleToSosHeader" + prodIdx,dsp2);
    dspTableCtrl("dataToSosHeader" + prodIdx,dsp2);
    dspTableCtrl("titleToJgiHeader" + prodIdx,dsp2);
    dspTableCtrl("titleToSosJgiHeader" + prodIdx,dsp1);
    document.getElementById("titleToHeader" + prodIdx).colSpan=
      (Number(document.getElementById("titleToHeader" + prodIdx).colSpan) + 1) + "";
    document.getElementById("titleHeader" + prodIdx).colSpan=
            (Number(document.getElementById("titleHeader" + prodIdx).colSpan) + 1) + "";
    tblWidth = tblWidth + sosNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  } else if(dspFlg == 3){
    dsp1 = "block";
    dsp2 = "none";
    dspTableCtrl("titleToSosHeader" + prodIdx,dsp2);
    dspTableCtrl("dataToSosHeader" + prodIdx,dsp2);
    dspTableCtrl("titleToJgiHeader" + prodIdx,dsp2);
    dspTableCtrl("titleToSosJgiHeader" + prodIdx,dsp1);
    document.getElementById("titleToHeader" + prodIdx).colSpan=
      (Number(document.getElementById("titleToHeader" + prodIdx).colSpan) - 1) + "";
    document.getElementById("titleHeader" + prodIdx).colSpan=
            (Number(document.getElementById("titleHeader" + prodIdx).colSpan) - 1) + "";
    tblWidth = tblWidth - sosNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  }
  document.fm1.widthTbl.value = tblWidth + "";
}

// 現担当領域コンボボックス再設定
function resetTrtCdCombo(prodCode) {
  var selectItem = document.getElementById("searchFromTrtCd");
  // コンボボックス内容をクリアする
  var i, j;
  for (i = selectItem.length - 1; i >= 0; i--) {
    selectItem.options.remove(i);
  }
  var codes = prodCode.split(",");
  var resultList = [];
  
  // コンボボックス内容追加する
  // 空白行
  var opt=document.createElement("OPTION");
  opt.value="";
  opt.text="全て";
  selectItem.options.add(opt);
  opt.selected=false;
  
  var flg = "0";
  for (i = 0; i < document.fm1.prodTrtList.length; i++) {
    var prodTrt = document.fm1.prodTrtList[i].value.split(",");
    flg = "0";
    if (codes.length < 0) {
      flg = "1";
    } else {
      for (j = 0; j < codes.length; j++) {
        if (codes[j] == prodTrt[0]) {
          flg = "1";
          break;
        }
      }
    }
    if (flg == "1") {
      for (j = 0; j < resultList.length; j++) {
        if (resultList[j] == prodTrt[1]) {
          flg = "0";
          break;
        }
      }
    }
    
    if (flg == "1") {
      opt=document.createElement("OPTION");
      opt.value=prodTrt[1];
      opt.text=prodTrt[2];
      selectItem.options.add(opt);
      opt.selected=false;
      resultList[selectItem.length - 1] = prodTrt[1];
    }
  }
}

function toTrtCdChange(rowIndex, prodIdx) {
  var trtCdBef = document.getElementsByName("chgInsProdList["+rowIndex+"].toTrtCdBef" + prodIdx)[0].value;
  var trtCd = document.getElementsByName("chgInsProdList["+rowIndex+"].toTrtCd" + prodIdx)[0].value;
  var changeFlg = "0";
  if (trtCdBef != trtCd) {
    changeFlg = "1";
  }
  document.getElementsByName("chgInsProdList["+rowIndex+"].changeFlg" + prodIdx)[0].value = changeFlg;
  if (changeFlg == "1") {
    jkrMrChaker = 1;
    return false;
  }
  checkProdChange();
}

/**
 * 作業途中のデータ有無を判定する。
 */
function checkProdChange(){
  jkrMrChaker = 0;
  var changeFlgId = "";
  var changeFlg = "";
  var maxRow = document.fm1.lineCntEnd.value - document.fm1.lineCntStart.value;
  var maxCol = document.fm1.prodCount.value;
  for(var rowno=0; rowno<=maxRow && maxRow>=0; rowno++) {
    for(var prodno=1; prodno <= maxCol && maxCol >= 1; prodno++) {
      changeFlgId = "chgInsProdList[" + rowno + "].changeFlg" + prodno;
      changeFlg = document.getElementsByName(changeFlgId)[0].value;
      if (changeFlg == "1") {
        jkrMrChaker = 1;
        return false;
      }
    }
  }
  return false;
}

