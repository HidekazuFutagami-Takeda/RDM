/**
 * <pre>
 *  所属部課・領域別担当変更のJavaScript
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author BHH 張
 */

/**
 * <pre>
 *  組織の表示／非表示の切り替え
 * 組織(リンク)押下時に呼ばれます。
 * </pre>
 * @param dspFlg 表示フラグ(0:非表示, 1:表示)
 * @param prodIdx 領域インデクス(１０まで) * 
 * @param tntDelDispFlg 担当外す表示フラグ 0表示しない、１表示 
 */
function dspSosName010(dspFlg, trtIdx, tntDelDispFlg){
    if (document.fm1.lineCntAll.value == "0") {
        return false;
      }
    
  var tblWidth = Number(document.fm1.widthTbl.value);
  var sosNameWidth = 200;
  var jgiNameWidth = 130;
//  alert("dspFlg = " + dspFlg);
  // 現組織展開しない
  if(dspFlg == 0){
    dsp1 = "block";
    dsp2 = "none";
    //組織
    dspTableCtrl("titleFromSosHeader" + trtIdx,dsp2);
    dspTableCtrl("dataFromSosHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromJgiHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromSosJgiHeader" + trtIdx,dsp1);
    document.getElementById("titleFromHeader" + trtIdx).colSpan=
      (Number(document.getElementById("titleFromHeader" + trtIdx).colSpan) - 1) + "";
    document.getElementById("titleHeader" + trtIdx).colSpan=
            (Number(document.getElementById("titleHeader" + trtIdx).colSpan) - 1) + "";
    tblWidth = tblWidth - sosNameWidth;
    document.getElementById("fromSosDisFlg" + trtIdx).value = "0";
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  // 現組織展開する
  } else if(dspFlg == 1){
    dsp1 = "none";
    dsp2 = "block";
    //組織
    dspTableCtrl("titleFromSosHeader" + trtIdx,dsp2);
    dspTableCtrl("dataFromSosHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromJgiHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromSosJgiHeader" + trtIdx,dsp1);
    document.getElementById("titleFromHeader" + trtIdx).colSpan=
      (Number(document.getElementById("titleFromHeader" + trtIdx).colSpan) + 1) + "";
    document.getElementById("titleHeader" + trtIdx).colSpan=
            (Number(document.getElementById("titleHeader" + trtIdx).colSpan) + 1) + "";
    tblWidth = tblWidth + sosNameWidth;
    document.getElementById("fromSosDisFlg" + trtIdx).value = "1";
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  // 新組織展開しない
  } if(dspFlg == 2){
    dsp1 = "none";
    dsp2 = "block";
    //組織
    dspTableCtrl("titleToSosHeader" + trtIdx,dsp2);
    dspTableCtrl("dataToSosHeader" + trtIdx,dsp2);
    dspTableCtrl("titleToJgiHeader" + trtIdx,dsp2);
    dspTableCtrl("titleToSosJgiHeader" + trtIdx,dsp1);
    document.getElementById("titleFromToHeader" + trtIdx).colSpan=
      (Number(document.getElementById("titleFromToHeader" + trtIdx).colSpan)) + 1;
    document.getElementById("titleToHeader" + trtIdx).colSpan=
      (Number(document.getElementById("titleToHeader" + trtIdx).colSpan)) + 1;
    document.getElementById("titleHeader" + trtIdx).colSpan=
            (Number(document.getElementById("titleHeader" + trtIdx).colSpan) + 1) + "";
    tblWidth = tblWidth + sosNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  } else if(dspFlg == 3){
    dsp1 = "block";
    dsp2 = "none";
    dspTableCtrl("titleToSosHeader" + trtIdx,dsp2);
    dspTableCtrl("dataToSosHeader" + trtIdx,dsp2);
    dspTableCtrl("titleToJgiHeader" + trtIdx,dsp2);
    dspTableCtrl("titleToSosJgiHeader" + trtIdx,dsp1);
    document.getElementById("titleFromToHeader" + trtIdx).colSpan=
      (Number(document.getElementById("titleFromToHeader" + trtIdx).colSpan)) - 1;
    document.getElementById("titleToHeader" + trtIdx).colSpan=
      (Number(document.getElementById("titleToHeader" + trtIdx).colSpan)) - 1;
    document.getElementById("titleHeader" + trtIdx).colSpan=
            (Number(document.getElementById("titleHeader" + trtIdx).colSpan) - 1) + "";
    tblWidth = tblWidth - sosNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
  
  } else if(dspFlg == 5){
    dsp1 = "none";
    dsp2 = "block";
    dspTableCtrl("titleFromHeader" + trtIdx,dsp2);
    dspTableCtrl("titleToHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromSosJgiHeader" + trtIdx,dsp2);
    dspTableCtrl("dataFromJgiHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromToHeader" + trtIdx,dsp1);
    document.getElementById("titleFromHeader" + trtIdx).colSpan="1";
    document.getElementById("titleFromSosJgiHeader" + trtIdx).colSpan="1";
    document.getElementById("titleHeader" + trtIdx).colSpan=
            (Number(document.getElementById("titleHeader" + trtIdx).colSpan) + 1) + "";
    tblWidth = tblWidth + jgiNameWidth;
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
    document.getElementById("fromSosDisFlg" + trtIdx).value = "";
  } else if(dspFlg == 6){
    dsp1 = "block";
    dsp2 = "none";
    dspTableCtrl("titleFromHeader" + trtIdx,dsp2);
    dspTableCtrl("titleToHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromToHeader" + trtIdx,dsp1);
    dspTableCtrl("titleFromSosHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromJgiHeader" + trtIdx,dsp2);
    dspTableCtrl("titleFromSosJgiHeader" + trtIdx,dsp2);
    dspTableCtrl("dataFromSosHeader" + trtIdx,dsp2);
    dspTableCtrl("dataFromJgiHeader" + trtIdx,dsp2);
    
    if (document.getElementById("fromSosDisFlg" + trtIdx).value == "1") {
      tblWidth = tblWidth - jgiNameWidth - sosNameWidth;
      document.getElementById("titleHeader" + trtIdx).colSpan=
              (Number(document.getElementById("titleHeader" + trtIdx).colSpan) - 2) + "";
    } else {
      tblWidth = tblWidth - jgiNameWidth;
      document.getElementById("titleHeader" + trtIdx).colSpan=
              (Number(document.getElementById("titleHeader" + trtIdx).colSpan) - 1) + "";
    }
    document.getElementById("meisai_head_right").style.width = tblWidth + "px";
    document.getElementById("meisai_right").style.width = tblWidth + "px";
    document.getElementById("fromSosDisFlg" + trtIdx).value = "";
  }
  
  document.fm1.widthTbl.value = tblWidth + "";
}
