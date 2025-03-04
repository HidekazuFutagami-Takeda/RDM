<%--
/**
 * <pre>
 *  施設来期情報更新のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.3 $
 * @author
 * @see
 */
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppConstant,java.util.ArrayList,java.math.BigDecimal"
  import="jp.co.takeda.rdm.util.RdmConstantsData"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"

%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String regEnabedFlg = StringUtils.nvl((String)request.getAttribute("regEnabedFlg"), "");
//20180406 HISOL ISHIDA START
String sosSelFlg = StringUtils.nvl((String)request.getAttribute("sosSelFlg"), "");
//20180406 HISOL ISHIDA END
String strRegDisabled = "";
//20180406 HISOL ISHIDA START
//if (!"1".equals(regEnabedFlg)) {
if ((!"1".equals(regEnabedFlg)) || ("1".equals(sosSelFlg))){
//20180406 HISOL ISHIDA END
    strRegDisabled = "disabled";
}
%>
<%-- オブジェクト読み込み --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <title>NF101_施設来期情報更新</title>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
  <link href="css/common2.css" rel="Stylesheet" type="text/css" />
  <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
  <script type="text/javascript" src="js/common.js"></script>
  <script type="text/javascript" src="js/jgiKanren.js"></script>
  <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
  <script type="text/javascript" src="js/catHcpSoc.js"></script>
  <script type="text/javascript" src="js/catHcpPub.js"></script>
    <script>

	comClickFlgInit();

    // 初期表示処理
    function onLoadFunc(){
    	changeBox("4");
    	// 対象区分表示
    	document.fm1.nextHoInsTypeView.value = document.fm1.nextHoInsType.options[document.fm1.nextHoInsType.selectedIndex].textContent;
    	// 編集不可設定
		onLoadEditSet();

		// カラーフラグ設定
		onLoadColorSet();
    }

    function onLoadEditSet(){
		editFlg = document.fm1.editApprFlg.value;
		insType = document.fm1.insType.value;

		if(editFlg == "0") {
			// 施設区分
			document.fm1.pharmTypeView.value = document.fm1.nextPharmType.options[document.fm1.nextPharmType.selectedIndex].textContent;
			document.fm1.nextPharmType.hidden = "true";

			// 階級区分
			document.fm1.insRankView.value = document.fm1.nextInsRank.options[document.fm1.nextInsRank.selectedIndex].textContent;
			document.fm1.nextInsRank.hidden = "true";

			// 定訪先区分
			document.fm1.regVisTypeView.value = document.fm1.nextRegVisType.options[document.fm1.nextRegVisType.selectedIndex].textContent;
			document.fm1.nextRegVisType.hidden = "true";

			// 重点病院区分
			document.fm1.impHosTypeView.value = document.fm1.nextImpHosType.options[document.fm1.nextImpHosType.selectedIndex].textContent;
			document.fm1.nextImpHosType.hidden = "true";

			// 経営主体
			document.fm1.manageCdView.value = document.fm1.nextManageCd.options[document.fm1.nextManageCd.selectedIndex].textContent;
			document.fm1.nextManageCd.hidden = "true";

			// ワクチン対象区分
			document.fm1.vacInsTypeView.value = document.fm1.nextVacInsType.options[document.fm1.nextVacInsType.selectedIndex].textContent;
			document.fm1.nextVacInsType.hidden = "true";

			// ワクチン定訪先区分
			document.fm1.vacVisitTypeView.value = document.fm1.nextVacVisitType.options[document.fm1.nextVacVisitType.selectedIndex].textContent;
			document.fm1.nextVacVisitType.hidden = "true";

			if(insType =="01" || insType == "02"){
				// 病床数
				document.fm1.nextBedCntBase.readOnly = true;
				document.fm1.nextBedCnt04.readOnly = true;
				document.fm1.nextBedCnt01.readOnly = true;
				document.fm1.nextBedCnt05.readOnly = true;
				document.fm1.nextBedCnt03.readOnly = true;
				document.fm1.nextBedCnt07.readOnly = true;
				document.fm1.nextBedCnt02.readOnly = true;
				document.fm1.nextBedCnt06.readOnly = true;
				document.fm1.nextBedsTot.readOnly = true;
				document.fm1.nextMedBedsTot.readOnly = true;
			}

		} else {
			document.fm1.pharmTypeView.hidden = "true";
			document.fm1.insRankView.hidden = "true";
			document.fm1.regVisTypeView.hidden = "true";
			document.fm1.impHosTypeView.hidden = "true";
			document.fm1.manageCdView.hidden = "true";
			document.fm1.vacInsTypeView.hidden = "true";
			document.fm1.vacVisitTypeView.hidden = "true";
		}
    }

    function onLoadColorSet(){
		// 黄色設定
		if(document.fm1.pharmTypeFlg.value == "1"){
			document.fm1.nextPharmType.className = "comTableSelectYellow";
		}
		if(document.fm1.insRankFlg.value == "1"){
			document.fm1.nextInsRank.className = "comTableSelectYellow";
		}
		if(document.fm1.regVisTypeFlg.value == "1"){
			document.fm1.nextRegVisType.className = "comTableSelectYellow";
		}
		if(document.fm1.impHosTypeFlg.value == "1"){
			document.fm1.nextImpHosType.className = "comTableSelectYellow";
		}
		if(document.fm1.manageCdFlg.value == "1"){
			document.fm1.nextManageCd.className = "comTableSelectYellow";
		}
		if(document.fm1.bedCntBaseFlg.value == "1"){
			document.fm1.nextBedCntBase.className = "comTableInputYellow";
		}
		if(document.fm1.bedCnt04Flg.value == "1"){
			document.fm1.nextBedCnt04.className = "comTableInputYellow";
		}
		if(document.fm1.bedCnt01Flg.value == "1"){
			document.fm1.nextBedCnt01.className = "comTableInputYellow";
		}
		if(document.fm1.bedCnt05Flg.value == "1"){
			document.fm1.nextBedCnt05.className = "comTableInputYellow";
		}
		if(document.fm1.bedCnt03Flg.value == "1"){
			document.fm1.nextBedCnt03.className = "comTableInputYellow";
		}
		if(document.fm1.bedCnt07Flg.value == "1"){
			document.fm1.nextBedCnt07.className = "comTableInputYellow";
		}
		if(document.fm1.bedCnt02Flg.value == "1"){
			document.fm1.nextBedCnt02.className = "comTableInputYellow";
		}
		if(document.fm1.bedCnt06Flg.value == "1"){
			document.fm1.nextBedCnt06.className = "comTableInputYellow";
		}
		if(document.fm1.bedsTotFlg.value == "1"){
			document.fm1.nextBedsTot.className = "comTableInputYellow";
		} else {
			document.fm1.nextBedsTot.style = "background-color:#D4D0C8; text-align:right;"
		}
		if(document.fm1.medBedsTotFlg.value == "1"){
			document.fm1.nextMedBedsTot.className = "comTableInputYellow";
		} else {
			document.fm1.nextMedBedsTot.style = "background-color:#D4D0C8; text-align:right;"
		}
    }

	// selectOption作成
	function makeOption(value, text){
		const option1 = document.createElement('option');
    	option1.value = value;
    	option1.textContent = text;
    	return option1;
	}

	// selectを空にする
    function removeBox(box){
    	if (box.hasChildNodes()) {
			while (box.childNodes.length > 0) {
				box.removeChild(box.firstChild);
			}
		}
    }

    // 施設区分セレクトボックス設定
    function makePharmTypeBox(box, insType){
    	removeBox(box);

    	const option0 = makeOption("","--なし--");
    	const option1 = makeOption("01","01:U(大学)");
		const option2 = makeOption("02","02:H(病院)");
		const option3 = makeOption("03","03:C(診療所)");
		const option4 = makeOption("04","04:P(開業医)");
		const option5 = makeOption("05","05:T(精神)");
		const option6 = makeOption("06","06:B(調剤薬局)");
		const option7 = makeOption("07","07:Y(ワクチン施設)");
		const option8 = makeOption("08","08:W(二次店)");
		const option9 = makeOption("09","09:Z(その他雑)");

		box.appendChild(option0);
		if(insType == "01"){
			box.appendChild(option1);
	    	box.appendChild(option2);
	    	box.appendChild(option3);
	    	box.appendChild(option4);
	    	box.appendChild(option5);
		} else if(insType == "02"){
			box.appendChild(option2);
	    	box.appendChild(option3);
	    	box.appendChild(option4);
		} else if(insType == "03"){
			box.appendChild(option6);
		} else if(insType == "06"){
			box.appendChild(option3);
	    	box.appendChild(option4);
		} else if(insType == "08"){
			box.appendChild(option7);
		} else if(insType == "09"){
			box.appendChild(option8);
	    	box.appendChild(option9);
		} else if(insType == "10"){
			box.appendChild(option4);
		}

    	return box;
    }

    // 階級区分セレクトボックス設定
    function makeInsRankBox(box, insType, pharmType){
    	removeBox(box);

    	const option0 = makeOption("","--なし--");
    	const option1 = makeOption("01","01:国公立大学医学部附属病院");
    	const option2 = makeOption("02","02:私立大学医学部附属病院");
    	const option3 = makeOption("03","03:国公立大学の分院");
    	const option4 = makeOption("04","04:私立大学の分院");
    	const option5 = makeOption("05","05:歯科大学本院");
    	const option6 = makeOption("06","06:歯科大学分院");
    	const option7 = makeOption("07","07:100床以上の国公立病院");
    	const option8 = makeOption("08","08:200床以上の私立病院");
    	const option9 = makeOption("09","09:20床以上99床以下の国公立病院");
    	const option10 = makeOption("10","10:20床以上199床以下の私立病院");
    	const option11 = makeOption("11","11:1床以上19床以下の診療所");
    	const option12 = makeOption("12","12:無床の診療所");
    	const option13 = makeOption("13","13:歯科施設");
    	const option14 = makeOption("14","14:1床以上19床以下の個人立の開業医");
    	const option15 = makeOption("15","15:無床の開業医");
    	const option16 = makeOption("16","16:精神");
    	const option17 = makeOption("17","17:B調剤薬局");
    	const option18 = makeOption("18","18:二次店");
    	const option19 = makeOption("19","19:特二次店");
    	const option20 = makeOption("20","20:医療モール");
    	const option21 = makeOption("00","00:該当なし");

		box.appendChild(option0);
    	if(insType == "01" && pharmType == "01"){
			box.appendChild(option1);
	    	box.appendChild(option2);
	    	box.appendChild(option3);
	    	box.appendChild(option4);
	    	box.appendChild(option5);
	    	box.appendChild(option6);
    	} else if(insType == "01" && pharmType == "02"){
			box.appendChild(option7);
	    	box.appendChild(option8);
	    	box.appendChild(option9);
	    	box.appendChild(option10);
    	} else if(insType == "01" && pharmType == "03"){
			box.appendChild(option11);
	    	box.appendChild(option12);
    	} else if(insType == "01" && pharmType == "04"){
			box.appendChild(option13);
	    	box.appendChild(option14);
	    	box.appendChild(option15);
    	} else if(insType == "01" && pharmType == "05"){
			box.appendChild(option16);
    	} else if(insType == "02" && pharmType == "02"){
	    	box.appendChild(option9);
	    	box.appendChild(option10);
    	} else if(insType == "02" && pharmType == "03"){
	    	box.appendChild(option11);
	    	box.appendChild(option12);
    	} else if(insType == "02" && pharmType == "04"){
			box.appendChild(option13);
	    	box.appendChild(option14);
	    	box.appendChild(option15);
    	} else if(insType == "03" && pharmType == "06"){
	    	box.appendChild(option17);
    	} else if(insType == "06" && pharmType == "03"){
			box.appendChild(option11);
	    	box.appendChild(option12);
    	} else if(insType == "06" && pharmType == "04"){
			box.appendChild(option13);
	    	box.appendChild(option14);
	    	box.appendChild(option15);
    	} else if(insType == "08" && pharmType == "07"){
			box.appendChild(option21);
    	} else if(insType == "09" && pharmType == "08"){
	    	box.appendChild(option18);
	    	box.appendChild(option19);
    	} else if(insType == "09" && pharmType == "09"){
	    	box.appendChild(option21);
    	} else if(insType == "10" && pharmType == "04"){
	    	box.appendChild(option20);
    	}

    	return box;
    }

    // 定訪先区分セレクトボックス設定
    function makeRegVisTypeBox(box, insType, pharmType, insRank){
    	removeBox(box);

    	const option0 = makeOption("","--なし--");
    	const option1 = makeOption("1","1:定訪先");
    	const option2 = makeOption("2","2:その他先");
    	const option3 = makeOption("0","0:該当なし");

		box.appendChild(option0);
    	if((insType == "01" && pharmType == "01" && (insRank == "01" || insRank == "02" || insRank == "03"
    			|| insRank == "04" || insRank == "05" || insRank == "06"))
    		|| (insType == "01" && pharmType == "02" && (insRank == "07" || insRank == "08"))){
	    	box.appendChild(option1);
    	} else if((insType == "01" && pharmType == "02" && (insRank == "09" || insRank == "10"))
    			|| (insType == "01" && pharmType == "03" && (insRank == "11" || insRank == "12"))
 				|| (insType == "01" && pharmType == "04" && (insRank == "13" || insRank == "14" || insRank == "15"))
 				|| (insType == "01" && pharmType == "05" && insRank == "16")
 				|| (insType == "02" && pharmType == "02" && (insRank == "09" || insRank == "10"))
 				|| (insType == "02" && pharmType == "03" && (insRank == "11" || insRank == "12"))
 				|| (insType == "02" && pharmType == "04" && (insRank == "13" || insRank == "14" || insRank == "15"))
 				|| (insType == "03" && pharmType == "06" && insRank == "17")
 				|| (insType == "06" && pharmType == "03" && (insRank == "11" || insRank == "12"))
 				|| (insType == "06" && pharmType == "04" && (insRank == "13" || insRank == "14" || insRank == "15"))){
	    	box.appendChild(option1);
	    	box.appendChild(option2);
    	} else if((insType == "08" && pharmType == "07" && insRank == "00")
    			|| (insType == "09" && pharmType == "08" && insRank == "19")
    			|| (insType == "09" && pharmType == "09" && insRank == "00")){
    		box.appendChild(option3);
    	} else if(insType == "10" && pharmType == "04" && insRank == "20"){
    		box.appendChild(option1);
    	}

    	return box;
    }

    //  重点病院区分セレクトボックス設定
    function makeImpHosTypeBox(box, insType, pharmType, insRank){
    	removeBox(box);

    	const option0 = makeOption("","--なし--");
    	const option1 = makeOption("1","1:H1");
    	const option2 = makeOption("2","2:H2");
    	const option3 = makeOption("0","0:該当なし");

		box.appendChild(option0);
    	if(insType == "01" && pharmType == "01" && (insRank == "01" || insRank == "02")){
	    	box.appendChild(option3);
    	} else if((insType == "01" && pharmType == "01" && (insRank == "03" || insRank == "04" || insRank == "05" || insRank == "06"))
    			|| (insType == "01" && pharmType == "02" && (insRank == "07" || insRank == "08"))){
	    	box.appendChild(option1);
	    	box.appendChild(option2);
    	} else if((insType == "01" && pharmType == "02" && (insRank == "09" || insRank == "10"))
    			|| (insType == "01" && pharmType == "03" && (insRank == "11" || insRank == "12"))
    			|| (insType == "01" && pharmType == "04" && (insRank == "13" || insRank == "14" || insRank == "15"))
    			|| (insType == "01" && pharmType == "05" && insRank == "16")
    			|| (insType == "02" && pharmType == "02" && (insRank == "09" || insRank == "10"))
    			|| (insType == "02" && pharmType == "03" && (insRank == "11" || insRank == "12"))
    			|| (insType == "02" && pharmType == "04" && (insRank == "13" || insRank == "14" || insRank == "15"))
    			|| (insType == "03" && pharmType == "06" && insRank == "17")
    			|| (insType == "03" && pharmType == "03" && (insRank == "11" || insRank == "12"))
    			|| (insType == "06" && pharmType == "04" && (insRank == "13" || insRank == "14" || insRank == "15"))
    			|| (insType == "08" && pharmType == "07" && insRank == "00")
    			|| (insType == "09" && pharmType == "08" && (insRank == "18" || insRank == "19"))
    			|| (insType == "09" && pharmType == "09" && insRank == "00")
    			|| (insType == "10" && pharmType == "04" && insRank == "20")){
    		box.appendChild(option3);
    	}

    	return box;
    }

    // 経営主体セレクトボックス設定
    function makeManageCdBox(box, insRank){
    	removeBox(box);

    	const option0 = makeOption("","--なし--");
    	const option1 = makeOption("001" ,"001:厚生労働省");
    	const option2 = makeOption("002" ,"002:文部科学省");
    	const option3 = makeOption("003" ,"003:財務省");
    	const option4 = makeOption("004" ,"004:総務省");
    	const option5 = makeOption("005" ,"005:警察庁");
    	const option6 = makeOption("006" ,"006:防衛省");
    	const option7 = makeOption("007" ,"007:独立行政法人国立病院機構");
    	const option8 = makeOption("008" ,"008:国立高度専門医療研究センター");
    	const option9 = makeOption("009" ,"009:その他の国");
    	const option10 = makeOption("010" ,"010:その他の独立行政法人");
    	const option11 = makeOption("011" ,"011:労働福祉事業団");
    	const option12 = makeOption("012" ,"012:国立大学法人");
    	const option13 = makeOption("013" ,"013:独立行政法人労働者健康安全機構");
    	const option14 = makeOption("014" ,"014:独立行政法人地域医療機能推進機構");
    	const option15 = makeOption("015" ,"015:都立");
    	const option16 = makeOption("016" ,"016:道立");
    	const option17 = makeOption("017" ,"017:府立");
    	const option18 = makeOption("018" ,"018:県立");
    	const option19 = makeOption("019" ,"019:市立");
    	const option20 = makeOption("020" ,"020:区立");
    	const option21 = makeOption("021" ,"021:町立");
    	const option22 = makeOption("022" ,"022:村立");
    	const option23 = makeOption("023" ,"023:一部事務組合");
    	const option24 = makeOption("024" ,"024:地方独立行政法人");
    	const option25 = makeOption("025" ,"025:地方公共団体");
    	const option26 = makeOption("026" ,"026:済生会");
    	const option27 = makeOption("027" ,"027:厚生連－全国厚生農業協同組合");
    	const option28 = makeOption("028" ,"028:日本赤十字社");
    	const option29 = makeOption("029" ,"029:北海道社会事業協会");
    	const option30 = makeOption("030" ,"030:国民健康保険団体連合会");
    	const option31 = makeOption("031" ,"031:国民健康保険組合");
    	const option32 = makeOption("032" ,"032:全国社会保険協会連合会");
    	const option33 = makeOption("033" ,"033:健康保険組合・連合会");
    	const option34 = makeOption("034" ,"034:船員保険組合");
    	const option35 = makeOption("035" ,"035:厚生団");
    	const option36 = makeOption("036" ,"036:共済組合・連合会");
    	const option37 = makeOption("037" ,"037:生活協同組合・連合会");
    	const option38 = makeOption("038" ,"038:その他の社会保険関係");
    	const option39 = makeOption("039" ,"039:その他の組合運営のもの");
    	const option40 = makeOption("040" ,"040:医療法人");
    	const option41 = makeOption("041" ,"041:学校法人");
    	const option42 = makeOption("042" ,"042:財団法人");
    	const option43 = makeOption("043" ,"043:社団法人");
    	const option44 = makeOption("044" ,"044:社会福祉法人");
    	const option45 = makeOption("045" ,"045:公益法人");
    	const option46 = makeOption("046" ,"046:宗教法人");
    	const option47 = makeOption("047" ,"047:その他の法人");
    	const option48 = makeOption("048" ,"048:ＪＲ");
    	const option49 = makeOption("049" ,"049:日本電信電話（株）");
    	const option50 = makeOption("050" ,"050:日本たばこ産業（株）");
    	const option51 = makeOption("051" ,"051:日本郵政株式会社");
    	const option52 = makeOption("052" ,"052:医療福祉生協");
    	const option53 = makeOption("053" ,"053:医師会");
    	const option54 = makeOption("054" ,"054:会社・事務所");
    	const option55 = makeOption("055" ,"055:個人");
    	const option56 = makeOption("056" ,"056:歯科医師会");
    	const option57 = makeOption("057" ,"057:薬剤師会");
    	const option58 = makeOption("058" ,"058:その他の団体");
    	const option59 = makeOption("059" ,"059:農業協同組合（厚生連を除く）");

    	box.appendChild(option0);
    	if(insRank == "01" || insRank == "03"){
	    	box.appendChild(option1);
	    	box.appendChild(option2);
	    	box.appendChild(option3);
	    	box.appendChild(option4);
	    	box.appendChild(option5);
	    	box.appendChild(option6);
	    	box.appendChild(option7);
	    	box.appendChild(option9);
	    	box.appendChild(option10);
	    	box.appendChild(option11);
	    	box.appendChild(option12);
	    	box.appendChild(option13);
	    	box.appendChild(option14);
	    	box.appendChild(option15);
	    	box.appendChild(option16);
	    	box.appendChild(option17);
	    	box.appendChild(option18);
	    	box.appendChild(option19);
	    	box.appendChild(option20);
	    	box.appendChild(option21);
	    	box.appendChild(option22);
	    	box.appendChild(option23);
	    	box.appendChild(option24);
	    	box.appendChild(option25);
	    	box.appendChild(option26);
	    	box.appendChild(option27);
	    	box.appendChild(option28);
	    	box.appendChild(option29);
	    	box.appendChild(option30);
	    	box.appendChild(option31);
	    	box.appendChild(option32);
	    	box.appendChild(option33);
	    	box.appendChild(option34);
	    	box.appendChild(option35);
	    	box.appendChild(option36);
	    	box.appendChild(option38);
	    	box.appendChild(option39);
	    	box.appendChild(option48);
	    	box.appendChild(option49);
	    	box.appendChild(option50);
	    	box.appendChild(option51);
    	} else if(insRank == "02" || insRank == "04" || insRank == "08" || insRank == "10"){
	    	box.appendChild(option37);
	    	box.appendChild(option40);
	    	box.appendChild(option41);
	    	box.appendChild(option42);
	    	box.appendChild(option43);
	    	box.appendChild(option44);
	    	box.appendChild(option45);
	    	box.appendChild(option46);
	    	box.appendChild(option47);
	    	box.appendChild(option52);
	    	box.appendChild(option53);
	    	box.appendChild(option54);
	    	box.appendChild(option55);
	    	box.appendChild(option56);
	    	box.appendChild(option57);
	    	box.appendChild(option58);
	    	box.appendChild(option59);
    	} else if(insRank == "05" || insRank == "06" || insRank == "16" || insRank == "17"
    			 || insRank == "18" || insRank == "19" || insRank == "20" || insRank == "00"){
    		box.appendChild(option1);
    		box.appendChild(option2);
    		box.appendChild(option3);
    		box.appendChild(option4);
    		box.appendChild(option5);
    		box.appendChild(option6);
    		box.appendChild(option7);
    		box.appendChild(option9);
    		box.appendChild(option10);
    		box.appendChild(option11);
    		box.appendChild(option12);
    		box.appendChild(option13);
    		box.appendChild(option14);
    		box.appendChild(option15);
    		box.appendChild(option16);
    		box.appendChild(option17);
    		box.appendChild(option18);
    		box.appendChild(option19);
    		box.appendChild(option20);
    		box.appendChild(option21);
    		box.appendChild(option22);
    		box.appendChild(option23);
    		box.appendChild(option24);
    		box.appendChild(option25);
    		box.appendChild(option26);
    		box.appendChild(option27);
    		box.appendChild(option28);
    		box.appendChild(option29);
    		box.appendChild(option30);
    		box.appendChild(option31);
    		box.appendChild(option32);
    		box.appendChild(option33);
    		box.appendChild(option34);
    		box.appendChild(option35);
    		box.appendChild(option36);
    		box.appendChild(option37);
    		box.appendChild(option38);
    		box.appendChild(option39);
    		box.appendChild(option40);
    		box.appendChild(option41);
    		box.appendChild(option42);
    		box.appendChild(option43);
    		box.appendChild(option44);
    		box.appendChild(option45);
    		box.appendChild(option46);
    		box.appendChild(option47);
    		box.appendChild(option48);
    		box.appendChild(option49);
    		box.appendChild(option50);
    		box.appendChild(option51);
    		box.appendChild(option52);
    		box.appendChild(option53);
    		box.appendChild(option54);
    		box.appendChild(option55);
    		box.appendChild(option56);
    		box.appendChild(option57);
    		box.appendChild(option58);
    		box.appendChild(option59);
    	} else if(insRank == "07" || insRank == "09"){
    		box.appendChild(option1);
    		box.appendChild(option2);
    		box.appendChild(option3);
    		box.appendChild(option4);
    		box.appendChild(option5);
    		box.appendChild(option6);
    		box.appendChild(option7);
    		box.appendChild(option8);
    		box.appendChild(option9);
    		box.appendChild(option10);
    		box.appendChild(option11);
    		box.appendChild(option12);
    		box.appendChild(option13);
    		box.appendChild(option14);
    		box.appendChild(option15);
    		box.appendChild(option16);
    		box.appendChild(option17);
    		box.appendChild(option18);
    		box.appendChild(option19);
    		box.appendChild(option20);
    		box.appendChild(option21);
    		box.appendChild(option22);
    		box.appendChild(option23);
    		box.appendChild(option24);
    		box.appendChild(option25);
    		box.appendChild(option26);
    		box.appendChild(option27);
    		box.appendChild(option28);
    		box.appendChild(option29);
    		box.appendChild(option30);
    		box.appendChild(option31);
    		box.appendChild(option32);
    		box.appendChild(option33);
    		box.appendChild(option34);
    		box.appendChild(option35);
    		box.appendChild(option36);
    		box.appendChild(option38);
    		box.appendChild(option39);
    		box.appendChild(option48);
    		box.appendChild(option49);
    		box.appendChild(option50);
    		box.appendChild(option51);
    	} else if(insRank == "11" || insRank == "12"){
    		box.appendChild(option1);
    		box.appendChild(option2);
    		box.appendChild(option3);
    		box.appendChild(option4);
    		box.appendChild(option5);
    		box.appendChild(option6);
    		box.appendChild(option7);
    		box.appendChild(option8);
    		box.appendChild(option9);
    		box.appendChild(option10);
    		box.appendChild(option11);
    		box.appendChild(option12);
    		box.appendChild(option13);
    		box.appendChild(option14);
    		box.appendChild(option15);
    		box.appendChild(option16);
    		box.appendChild(option17);
    		box.appendChild(option18);
    		box.appendChild(option19);
    		box.appendChild(option20);
    		box.appendChild(option21);
    		box.appendChild(option22);
    		box.appendChild(option23);
    		box.appendChild(option24);
    		box.appendChild(option25);
    		box.appendChild(option26);
    		box.appendChild(option27);
    		box.appendChild(option28);
    		box.appendChild(option29);
    		box.appendChild(option30);
    		box.appendChild(option31);
    		box.appendChild(option32);
    		box.appendChild(option33);
    		box.appendChild(option34);
    		box.appendChild(option35);
    		box.appendChild(option36);
    		box.appendChild(option37);
    		box.appendChild(option38);
    		box.appendChild(option39);
    		box.appendChild(option40);
    		box.appendChild(option41);
    		box.appendChild(option42);
    		box.appendChild(option43);
    		box.appendChild(option44);
    		box.appendChild(option45);
    		box.appendChild(option46);
    		box.appendChild(option47);
    		box.appendChild(option48);
    		box.appendChild(option49);
    		box.appendChild(option50);
    		box.appendChild(option51);
    		box.appendChild(option52);
    		box.appendChild(option53);
    		box.appendChild(option54);
    		box.appendChild(option55);
    		box.appendChild(option56);
    		box.appendChild(option57);
    		box.appendChild(option58);
    		box.appendChild(option59);
    	} else if(insRank == "13" || insRank == "14" || insRank == "15"){
    		box.appendChild(option14);
    		box.appendChild(option23);
    		box.appendChild(option24);
    		box.appendChild(option26);
    		box.appendChild(option40);
    		box.appendChild(option41);
    		box.appendChild(option43);
    		box.appendChild(option44);
    		box.appendChild(option45);
    		box.appendChild(option54);
    		box.appendChild(option55);
    	}

    	return box;
    }

    // セレクトボックスの設定
    function changeBox(changeItem){
    	// 施設区分
    	if(changeItem == "4"){
        	var box = document.fm1.nextPharmType;
        	box = makePharmTypeBox(box,document.fm1.insType.value);
        	box.value = document.fm1.tmpPharmType.value;
    	}

    	// 階級区分
    	if(changeItem == "2"){
        	var box = document.fm1.nextInsRank;
        	box = makeInsRankBox(box,document.fm1.insType.value, document.fm1.nextPharmType.value);
        	box.value = "";
    	} else if(changeItem == "4"){
        	var box = document.fm1.nextInsRank;
        	box = makeInsRankBox(box,document.fm1.insType.value, document.fm1.nextPharmType.value);
        	box.value = document.fm1.tmpInsRank.value;
    	}

    	// 定訪先区分
    	if(changeItem == "2" || changeItem == "3"){
        	var box = document.fm1.nextRegVisType;
        	box = makeRegVisTypeBox(box,document.fm1.insType.value, document.fm1.nextPharmType.value, document.fm1.nextInsRank.value);
        	box.value = "";
    	} else if(changeItem == "4"){
        	var box = document.fm1.nextRegVisType;
        	box = makeRegVisTypeBox(box,document.fm1.insType.value, document.fm1.nextPharmType.value, document.fm1.nextInsRank.value);
        	box.value = document.fm1.tmpRegVisType.value;
    	}

    	//  重点病院区分
    	if(changeItem == "2" || changeItem == "3"){
        	var box = document.fm1.nextImpHosType;
        	box = makeImpHosTypeBox(box,document.fm1.insType.value, document.fm1.nextPharmType.value, document.fm1.nextInsRank.value);
        	box.value = "";
    	} else if(changeItem == "4"){
        	var box = document.fm1.nextImpHosType;
        	box = makeImpHosTypeBox(box,document.fm1.insType.value, document.fm1.nextPharmType.value, document.fm1.nextInsRank.value);
        	box.value = document.fm1.tmpImpHosType.value;
    	}

    	// 経営主体
    	if(changeItem == "2" || changeItem == "3"){
        	var box = document.fm1.nextManageCd;
        	box = makeManageCdBox(box,document.fm1.nextInsRank.value);
        	box.value = "";
    	} else if(changeItem == "4"){
        	var box = document.fm1.nextManageCd;
        	box = makeManageCdBox(box,document.fm1.nextInsRank.value);
        	box.value = document.fm1.tmpManageCd.value;
    	}

    	setHoInsType();
    }

	// 対象区分値設定
	function setHoInsType(){
		const insRank = document.fm1.nextInsRank.value;

		if(insRank == "01" ||insRank == "02"){
			document.fm1.nextHoInsType.value = "1";
		} else if(insRank == "03" || insRank == "04" || insRank == "05" || insRank == "06"
			 || insRank == "07" || insRank == "08"){
			document.fm1.nextHoInsType.value = "2";
		} else if(insRank == "09" || insRank == "10" || insRank == "11" || insRank == "12"
			 || insRank == "13" || insRank == "14"|| insRank == "15" || insRank == "16"
			 || insRank == "17" || insRank == "20"){
			document.fm1.nextHoInsType.value = "3";
		} else if(insRank == "00" || insRank == "18" || insRank == "19"){
			document.fm1.nextHoInsType.value = "4";
		} else {
			document.fm1.nextHoInsType.value = "";
		}

		document.fm1.nextHoInsTypeView.value = document.fm1.nextHoInsType.options[document.fm1.nextHoInsType.selectedIndex].textContent;
	}

	// 病床数再計算
	function calcBedCnt(){
		var bedsTot = 0;
		var medBedsTot = 0;

		// 一般
		if(document.fm1.nextBedCnt01.value != "" && comChkNum(document.fm1.nextBedCnt01.value)) {
			bedsTot += parseInt(document.fm1.nextBedCnt01.value);
			medBedsTot += parseInt(document.fm1.nextBedCnt01.value);
		}

		// 精神
		if(document.fm1.nextBedCnt03.value != "" && comChkNum(document.fm1.nextBedCnt03.value)) {
			bedsTot += parseInt(document.fm1.nextBedCnt03.value);
			medBedsTot += parseInt(document.fm1.nextBedCnt03.value);
		}

		// 結核
		if(document.fm1.nextBedCnt04.value != "" && comChkNum(document.fm1.nextBedCnt04.value)) {
			bedsTot += parseInt(document.fm1.nextBedCnt04.value);
			medBedsTot += parseInt(document.fm1.nextBedCnt04.value);
		}

		// 感染症
		if(document.fm1.nextBedCnt05.value != "" && comChkNum(document.fm1.nextBedCnt05.value)) {
			bedsTot += parseInt(document.fm1.nextBedCnt05.value);
			medBedsTot += parseInt(document.fm1.nextBedCnt05.value);
		}

		// 療養
		if(document.fm1.nextBedCnt07.value != "" && comChkNum(document.fm1.nextBedCnt07.value)) {
			bedsTot += parseInt(document.fm1.nextBedCnt07.value);
		}

		// 医療療養
		if(document.fm1.nextBedCnt02.value != "" && comChkNum(document.fm1.nextBedCnt02.value)) {
			medBedsTot += parseInt(document.fm1.nextBedCnt02.value);
		}

		document.fm1.nextBedsTot.value = bedsTot;
		document.fm1.nextMedBedsTot.value = medBedsTot;
	}

	// 戻るボタン
	function backBtn(){
		document.fm1.target="";
		const preScreenId = document.fm1.preScreenId.value;
		if(preScreenId == "NF001"){
			if(window.confirm("施設検索画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
				window.close();
			}
		} else if(preScreenId == "NC011"){
			if(window.confirm("申請一覧画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
				window.close();
			}
		}
	}

	// 申請破棄ボタン
	function reqCancelBtn(){
		document.fm1.target="";
		if(window.confirm("申請データを破棄します。よろしいですか？")){
			// 申請データを破棄（＝物理的に削除）し、遷移元画面へ遷移する（本画面のタブを閉じる）
			// 申請IDで対象を絞り込み申請管理、施設_申請管理を削除

			document.fm1.screenId.value="NF101";
			document.fm1.functionId.value="Cancel";

			comSubmitForAnyWarp(fm1);
		}
	}

	// 一時保存ボタン、申請画面へ、承認・却下画面へボタン
	function submitBtn(funcId){
		document.fm1.funcId.value = funcId;
		document.fm1.screenId.value="NF101";

		document.fm1.nextPharmTypeNm.value = document.fm1.nextPharmType.options[document.fm1.nextPharmType.selectedIndex].textContent;
		document.fm1.nextInsRankNm.value = document.fm1.nextInsRank.options[document.fm1.nextInsRank.selectedIndex].textContent;
		document.fm1.nextRegVisTypeNm.value = document.fm1.nextRegVisType.options[document.fm1.nextRegVisType.selectedIndex].textContent;
		document.fm1.nextImpHosTypeNm.value = document.fm1.nextImpHosType.options[document.fm1.nextImpHosType.selectedIndex].textContent;
		document.fm1.nextHoInsTypeNm.value = document.fm1.nextHoInsType.options[document.fm1.nextHoInsType.selectedIndex].textContent;
		document.fm1.nextManageNm.value = document.fm1.nextManageCd.options[document.fm1.nextManageCd.selectedIndex].textContent;
		document.fm1.nextVacInsTypeNm.value = document.fm1.nextVacInsType.options[document.fm1.nextVacInsType.selectedIndex].textContent;
		document.fm1.nextVacVisitTypeNm.value = document.fm1.nextVacVisitType.options[document.fm1.nextVacVisitType.selectedIndex].textContent;

		if(funcId == "0") {
			// 一時保存
			document.fm1.screenId.value="NF101";
			document.fm1.functionId.value="Register";
		} else {
			// 申請画面へ、承認・却下画面へ
			document.fm1.screenId.value="NF309";
			document.fm1.functionId.value="Init";
		}

		document.fm1.target="";
		comSubmitForAnyWarp(fm1);
	}

	// 審査完了ボタン
	function shnCompBtn(){

		document.fm1.screenId.value="NF101";
		document.fm1.functionId.value="ShnComp";

		document.fm1.target="";
		comSubmitForAnyWarp(fm1);

	}

	var nf101Tab;
 	// 申請歴ボタン
    function histBtn(){
 		if(nf101Tab && !nf101Tab.closed){
 			nf101Tab.close();
 		}

 		nf101Tab = window.open("","NF101Tab");
		document.fm1.target="NF101Tab";

  		fm1.screenId.value="NF102";
	  	fm1.functionId.value="Init";
	  	comSubmitForAnyWarp(fm1);
	  	comClickFlgInit();
	}

    </script>
</head>

<body class="comPage" onUnload="JavaScript:jmsUnLoad();" onLoad="JavaScript:onLoadFunc();">
  <form class="comHidden" name="fm0" action="<%= request.getContextPath() %>/servlet/control" method="post">
    <input type="text" name="screenId"           value="" />
    <input type="text" name="functionId"         value="" />
    <input type="text" name="windowName"         value="" />
    <input type="text" name="openerName"         value="" />
    <input type="text" name="infoId1"            value="" />
    <input type="text" name="systemId1"          value="" />
    <input type="text" name="backScreenId1"      value="JkrMrChange" />
    <input type="text" name="backFunctionId1"    value="" />
    <input type="text" name="backScreenName1"    value="" />
    <input type="text" name="backParamName1"     value="" />
    <input type="text" name="backParamValue1"    value="" />
    <input type="text" name="backParamName2"     value="" />
    <input type="text" name="backParamValue2"    value="" />
    <input type="text" name="fromScreenId1"      value="" />
    <input type="text" name="fromFunctionId1"    value="" />
    <input type="text" name="kensakuChar1"       value="" />
    <input type="text" name="kensakuAndOr1"      value="" />
    <input type="text" name="pageNextBackFlag1"  value="" />
    <input type="text" name="sortFieldNo1"       value="" />
    <input type="text" name="sortFLG1"           value="" />
    <input type="text" name="startRecordNo1"     value="" />
    <input type="text" name="pageLines1"         value="" />
    <input type="hidden" name="endRecordNo1"	value="" />
    <input type="text" name="no1"                value="1" />

    <%-- フレーム対応で発生したPOST用 引数1:frame(フレーム対応),以外(何もしない) 引数２:オブジェクトの型 --%>

    <%-- 組織・従業員選択ポップアップ用 --%>
    <input type="hidden" name="selectFlg"			value="" />
    <input type="hidden" name="topSosCd"			value="" />
    <input type="hidden" name="initSosCd"			value="" />
    <input type="hidden" name="openBumonRank"		value="" />
    <input type="hidden" name="objData"				value="" />
    <input type="hidden" name="dspSelPtn"			value="" />
    <input type="hidden" name="dspSelSos"			value="" />
    <input type="hidden" name="sosLevelType"		value="" />
    <input type="hidden" name="dispJgiKb"			value="" />
    <input type="hidden" name="shokushuCd"			value="" />
    <input type="hidden" name="shokuseiCd"			value="" />
    <input type="hidden" name="noDispJgiKb"			value="" />
    <input type="hidden" name="noShokushuCd"		value="" />
    <input type="hidden" name="noShokuseiCd"		value="" />
    <input type="hidden" name="insNo1"				value="" />
    <input type="hidden" name="dspClrBtn1"			value="" /><%-- クリアボタン表示フラグ  --%>
    <input type="hidden" name="openJgiFlg"			value="" />
    <input type="text" name="sosSelFlg1"	value="" />

    <input type="checkbox" name="delCheck" />
    <input type="checkbox" name="hurikaeMr" />
    <input type="checkbox" name="shokiHurikaeMr" />

    <%-- 組織・従業員選択ポップアップの表示判断の条件 取得パラメータ：（MR種類・業務種類）--%>
    <input type="hidden" name="mrCat"				value=""	/>
    <input type="hidden" name="registCat"			value=""	/>

    <%-- 登録：排他処理用データ--%>
    <input type="hidden" name="ExUpDate"			value=""	/>

    <input type="text" name="userAuth1"		value="" />
    <input type="text" name="jpjJgiNo1"		value="" />
    <input type="text" name="sosCd1"		value="" />
    <input type="text" name="sosName1"		value="" />
    <input type="text" name="mrCat1"		value="" />
    <input type="text" name="registCat1"	value="" />
    <input type="text" name="jgiKb1"		value="" />
    <input type="text" name="selectedSosName1"	value="" />
    <input type="text" name="selectedSosCd1"	value="" />
    <input type="text" name="jgiJoken1"		value="" />
    <input type="text" name="sosName1"		value="" />
    <input type="text" name="wkCat1"		value="" />
    <input type="hidden" name="searchToSosCd1"		value="" />
    <input type="hidden" name="searchToSosName1"	value="" />
    <input type="hidden" name="shokikaSosName1"	value="" />
    <input type="hidden" name="shokikaSosCd1"	value="" />

    <input type="hidden" name="selectedPlanSosName1"		value="<bean:print name="menudata" property="selectedSosName"/>" />

    <%-- 登録前の最終総行数 --%>
    <input type="hidden" name="allUltCount1"	value="" />
    <%-- 登録前の追加の総行数 --%>
    <input type="hidden" name="addUltCount1"	value="" />

    <%--追加用　MR種類--%>
    <input type="hidden" name="takeMrCat"	value="" />

  </form>

  <%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>

<table border="0" class="comPortalTable" align="center" style="width:98%;">
  <tr>
    <td>
      <s:form name="fm1" theme="simple">
  <%-- ページャパラメータ --%>
  <s:hidden name="orderKbn" />
    <s:hidden name="pageCntAll" />
    <s:hidden name="pageCntCur" />
    <s:hidden name="pageCntBase" />
    <s:hidden name="lineCntStart" />
    <s:hidden name="lineCntEnd" />
    <s:hidden name="lineCntAll1" />
    <%-- 画面用パラメータ --%>
    <s:hidden name="backScreenId" value="NF101" />
     <s:hidden name="preScreenId"/>
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
     <s:hidden name="loginJokenSetCd"/>
     <s:hidden name="loginJgiNo"/>
     <s:hidden name="loginNm"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>
     <s:hidden name="loginShzNm"/>
     <s:hidden name="loginTrtCd"/>
     <s:hidden name="shnFlg"/>
     <s:hidden name="funcId"/>

    <s:hidden name="defaultSosCd"/>
    <s:hidden name="defaultSosName"/>
    <s:hidden name="defaultBumonRank"/>
    <s:hidden name="defaultMrCat"/>
    <s:hidden name="searchBumonRank"/>
    <s:hidden name="maxUpDate"/>
    <s:hidden name="sosCdFixFlg"/>
    <s:hidden name="sosCdFix"/>
    <s:hidden name="sosNameFix"/>
    <s:hidden name="showFlg"/>
    <s:hidden name="showDocChgFlg"/>
    <s:hidden name="sosSelFlg"/>
    <s:hidden name="sosRyakuName"/>

	<s:hidden name="reqChl"/>
	<s:hidden name="insType"/>
	<s:hidden name="editApprFlg"/>
	<s:hidden name="pharmTypeFlg"/>
	<s:hidden name="insRankFlg"/>
	<s:hidden name="regVisTypeFlg"/>
	<s:hidden name="impHosTypeFlg"/>
	<s:hidden name="manageCdFlg"/>
	<s:hidden name="vacInsTypeFlg"/>
	<s:hidden name="vacVisitTypeFlg"/>
	<s:hidden name="bedCntBaseFlg"/>
	<s:hidden name="bedCnt04Flg"/>
	<s:hidden name="bedCnt01Flg"/>
	<s:hidden name="bedCnt05Flg"/>
	<s:hidden name="bedCnt03Flg"/>
	<s:hidden name="bedCnt07Flg"/>
	<s:hidden name="bedCnt02Flg"/>
	<s:hidden name="bedCnt06Flg"/>
	<s:hidden name="bedsTotFlg"/>
	<s:hidden name="medBedsTotFlg"/>

	<s:hidden name="nextPharmTypeNm"/>
	<s:hidden name="nextInsRankNm"/>
	<s:hidden name="nextRegVisTypeNm"/>
	<s:hidden name="nextImpHosTypeNm"/>
	<s:hidden name="nextHoInsTypeNm"/>
	<s:hidden name="nextManageNm"/>
	<s:hidden name="nextVacInsTypeNm"/>
	<s:hidden name="nextVacVisitTypeNm"/>

	<input type="hidden" name="tmpPharmType" value="<s:property value="%{nextPharmType}"/>" />
    <input type="hidden" name="tmpInsRank" value="<s:property value="%{nextInsRank}"/>" />
    <input type="hidden" name="tmpRegVisType" value="<s:property value="%{nextRegVisType}"/>" />
    <input type="hidden" name="tmpImpHosType" value="<s:property value="%{nextImpHosType}"/>" />
    <input type="hidden" name="tmpManageCd" value="<s:property value="%{nextManageCd}"/>" />

    <%-- トップメニューからの共通パラメータ --%>
    <s:hidden name="trtGrpCd"/>
    <s:hidden name="selectedBumonRank"/>
    <s:hidden name="sosCd"/>
    <s:hidden name="sosName"/>
    <s:hidden name="selectedSosCd"/>
    <s:hidden name="selectedSosNm"/>
    <s:hidden name="selectedSosCd2" />
    <s:hidden name="selectedSosNm2" />
    <s:hidden name="selectedSosCd3" />
    <s:hidden name="selectedSosNm3" />
    <s:hidden name="selectedJgiJoken"/>
    <s:hidden name="jokenSetCd"/>
    <s:hidden name="sosCdHairetu"/>
    <s:hidden name="wkCat"/>
    <s:hidden name="searchFromSosCdPop"/>  <!--現組織コード(ポップアップ用) -->
    <s:hidden name="searchToSosCdPop"/>    <!--新組織コード(ポップアップ用) -->
    <s:hidden id="selectedTekiyoYmd" name="selectedTekiyoYmd"/>
    <%-- 組織ポップアップ用パラメータ --%>
    <input type="hidden" name="selectFlgPop"           value="" />
  <input type="hidden" name="initSosCdPop"           value="" />
  <input type="hidden" name="sosKbnPop"              value="" />
  <input type="hidden" name="sknnFlgPop"             value="" />
  <input type="hidden" name="insFlgPop"              value="" />
  <input type="hidden" name="topMenuFlgPop"          value="" />
  <input type="hidden" name="authorityPop"           value="" />
  <input type="hidden" name="bumonRankTopPop"        value="" />
  <input type="hidden" name="bumonRankBtmPop"        value="" />
  <input type="hidden" name="topSosCdPop"            value="" />
  <input type="hidden" name="defTblFlgPop"           value="" />
  <input type="hidden" name="actSosListPop"          value="<s:property value="%{sosCdHairetu}"/>" />
  <input type="hidden" name="shokushuFlgPop"         value="" />
  <input type="hidden" name="ztTntFlgPop"            value="" />
  <input type="hidden" name="jokenSetCdPop"          value="" />
  <input type="hidden" name="menuTrtGrpCdPop"        value="" />
  <input type="hidden" name="menuSosCdPop"           value="" />
  <input type="hidden" name="selectableBumonrankPop" value="" />
  <input type="hidden" name="insNoPop"               value="" />
  <input type="hidden" name="trtCdPop"               value="" />
  <input type="hidden" name="sosCdFromPop"           value="" />
  <input type="hidden" name="krJgiNoDispFlgPop"      value="" />
  <input type="hidden" name="sosCdToPop"             value="" />
  <input type="hidden" name="trtTntFlgPop"           value="" />

  <!-- 選択された組織情報格納（表示押下前） -->
  <s:hidden name="topChgSosCd" value=""/>
  <s:hidden name="topChgSosNm" value=""/>
  <s:hidden name="topChgSosCd2" value=""/>
  <s:hidden name="topChgSosNm2" value=""/>
  <s:hidden name="topChgSosCd3" value=""/>
  <s:hidden name="topChgSosNm3" value=""/>
  <!-- 選択された組織情報格納（表示押下後） -->
  <s:hidden name="topChangedSosCd" />
  <s:hidden name="topChangedSosNm" />
  <s:hidden name="topChangedSosCd2" />
  <s:hidden name="topChangedSosNm2" />
  <s:hidden name="topChangedSosCd3" />
  <s:hidden name="topChangedSosNm3" />

  <s:hidden name="title" />

<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設来期情報更新"></td>
        <td class="comPortalTitle"><nobr><s:property value='title'/></nobr></td>
        <td class="comPortalTitleRight"><nobr></nobr></td>
    </tr>
    </tbody>
    </table>
<%-- ポータルタイトル 終了 --%>
<%-- ポータルボディー 開始 --%>
    <table class="comPortalBody">
    <tbody>
      <tr>
        <td>

	<table id="formTable00" border="0" cellpadding="2" cellspacing="0" width="600px">
		<tbody>
		<s:if test="msgStr != null">
			<tr>
				<td>
					<nobr>
					<s:property value="msgStr.replaceAll('\\n', '<br />')" escape="false"/>
					</nobr>
				</td>
			</tr>
		</s:if>
		</tbody>
	</table>

  <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--申請情報--%>
        <%--申請情報のHIDDEN項目--%>
        <s:hidden name="reqId"/>
        <s:hidden name="reqJgiNo"/>
        <s:hidden name="reqJgiName"/>
        <s:hidden name="reqBrCd"/>
        <s:hidden name="reqDistCd"/>
        <s:hidden name="reqShzNm"/>
        <s:hidden name="reqStsCd"/>
        <s:hidden name="reqStsNm"/>
        <s:hidden name="reqYmdhms"/>
        <s:hidden name="shnJgiNo"/>
        <s:hidden name="aprJgiNo"/>
        <s:hidden name="updShaYmd"/>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>申請情報</nobr></td>
	      <td class="comFormTableItem"><nobr>申請ID</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqId"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>申請者所属</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqShzNm"/></nobr></td>
	      <td class="comFormTableItem"><nobr>申請ステータス</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqStsNm"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>申請者氏名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqJgiName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>申請日時</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqYmdhms"/></nobr></td>
	  </tr>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示　申請者には非表示 -->
	  <s:if test='%{reqStsCd != null && reqStsCd != "" && !(reqStsCd == "01" || reqStsCd == "11" || reqStsCd == "03" || reqStsCd == "13") }'>
		<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	      <tr>
		      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		      <td class="comFormTableItem"><nobr>審査者</nobr></td>
		      <td class="comFormTableItem"><nobr><s:label key="shnShaName"/></nobr></td>
		      <td class="comFormTableItem"><nobr>審査日時</nobr></td>
		      <td class="comFormTableItem"><nobr><s:label key="shnYmdhms"/></nobr></td>
		  </tr>
	  </s:if>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示 -->
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>承認者</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="aprShaName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>承認日時</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="aprYmdhms"/></nobr></td>
	  </tr>
	  </s:if>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable02" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--施設情報--%>
		<td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>施設情報</nobr></td>
	      <td class="comFormTableItem"><nobr>施設固定コード</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insNo"/><s:hidden name="insNo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>ULT施設コード</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="ultInsNo"/><s:hidden name="ultInsNo"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>施設略式漢字名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insAbbrName"/><s:hidden name="insAbbrName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>ULT施設名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="shisetsuNmRyaku"/><s:hidden name="shisetsuNmRyaku"/></nobr></td>
      </tr>
  </table>
  <br/>
    <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
  	<tr>
        <%--見出し--%>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>当期項目情報</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>ULT項目情報</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>来期項目情報</nobr></td>
	　　</tr>
  </table>

  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
    <tr>
        <%--基本情報--%>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>基本情報</nobr></td>
	<tr>
		<td class="comFormTableItem">施設区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="pharmType" /><s:hidden name="pharmType" /></td>
	   	<td class="comFormTableItemNf012"><s:label key="shisetsuKbn" /><s:hidden name="shisetsuKbn" /></td>
	   	<td class="comFormTableItemNf012"><s:select id="nextPharmType" name="nextPharmType" cssStyle="width:120pt" list ="pharmTypeCombo" onchange="changeBox('2')" />
	   	<s:textfield id="pharmTypeView" name="pharmTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr>
		<td class="comFormTableItem">階級区分</td>
		<td class="comFormTableItemNf012"><s:label key="insRank" /><s:hidden name="insRank" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextInsRank" name="nextInsRank" cssStyle="width:120pt" list ="insRankCombo" onchange="changeBox('3'); setHoInsType();" />
	   	<s:textfield id="insRankView" name="insRankView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr>
		<td class="comFormTableItem">定訪先区分</td>
		<td class="comFormTableItemNf012"><s:label key="regVisType" /><s:hidden name="regVisType" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextRegVisType" name="nextRegVisType" cssStyle="width:120pt" list ="regVisTypeCombo"/>
	   	<s:textfield id="regVisTypeView" name="regVisTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr>
		<td class="comFormTableItem">重点病院区分</td>
		<td class="comFormTableItemNf012"><s:label key="impHosType" /><s:hidden name="impHosType" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextImpHosType" name="nextImpHosType" cssStyle="width:120pt" list ="impHosTypeCombo"/>
	   	<s:textfield id="impHosTypeView" name="impHosTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr>
		<td class="comFormTableItem">対象区分</td>
		<td class="comFormTableItemNf012"><s:label key="hoInsType" /><s:hidden name="hoInsType" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012">
	   		<s:select id="nextHoInsType" name="nextHoInsType" cssStyle="width:120pt" list ="hoInsTypeCombo"  hidden="true"/>
	   		<s:textfield id="nextHoInsTypeView" name="nextHoInsTypeView" cssStyle="width:120pt; background-color:#D4D0C8" readonly="true" />
	   	</td>
	</tr>
	<tr>
		<td class="comFormTableItem">経営主体</td>
		<td class="comFormTableItemNf012"><s:label key="manageCd" /><s:hidden name="manageCd" /></td>
	   	<td class="comFormTableItemNf012"><s:label key="keieitaiNm" /><s:hidden name="keieitaiNm" /></td>
	   	<td class="comFormTableItemNf012"><s:select id="nextManageCd" name="nextManageCd" cssStyle="width:120pt" list ="manageCdCombo"/>
	   	<s:textfield id="manageCdView" name="manageCdView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr <s:if test="insType != '08'">style="visibility:collapse"</s:if>>
		<td class="comFormTableItem">ワクチン対象区分</td>
		<td class="comFormTableItemNf012"><s:label key="vacInsType" /><s:hidden name="vacInsType" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextVacInsType" name="nextVacInsType" cssStyle="width:120pt" list ="vacInsTypeCombo"/>
	   	<s:textfield id="vacInsTypeView" name="vacInsTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr <s:if test="insType != '08'">style="visibility:collapse"</s:if>>
		<td class="comFormTableItem">ワクチン定訪先区分</td>
		<td class="comFormTableItemNf012"><s:label key="vacVisitType" /><s:hidden name="vacVisitType" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextVacVisitType" name="nextVacVisitType" cssStyle="width:120pt" list ="vacVisitTypeCombo"/>
	   	<s:textfield id="vacVisitTypeView" name="vacVisitTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
  </table>
  	<s:if test="insType == '01' || insType == '02'">
	<br/>
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable05" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--病床数情報--%>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">病床数情報</td>
		<td class="comFormTableItem">&nbsp;</td>
		<td class="comFormTableItem">&nbsp;</td>
		<td class="comFormTableItem">&nbsp;</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">基準</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCntBase" /><s:hidden name="bedCntBase"/></td>
	   	<td class="comFormTableItemNf012"><s:label key="ultBedCntBase" /><s:hidden name="ultBedCntBase"/></td>
	   	<td class="comFormTableItemNf012"><s:textfield name="nextBedCntBase" size="4" maxlength="4" style="text-align:right;" /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">結核</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt04" /><s:hidden name="bedCnt04"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt04" /><s:hidden name="ultBedCnt04"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextBedCnt04" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">一般</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt01" /><s:hidden name="bedCnt01"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt01" /><s:hidden name="ultBedCnt01"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextBedCnt01" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">感染症</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt05" /><s:hidden name="bedCnt05"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt05" /><s:hidden name="ultBedCnt05"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextBedCnt05" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">精神</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt03" /><s:hidden name="bedCnt03"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt03" /><s:hidden name="ultBedCnt03"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextBedCnt03" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">療養</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt07" /><s:hidden name="bedCnt07"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt07" /><s:hidden name="ultBedCnt07"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextBedCnt07" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">医療療養</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt02" /><s:hidden name="bedCnt02"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt02" /><s:hidden name="ultBedCnt02"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextBedCnt02" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">介護療養</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedCnt06" /><s:hidden name="bedCnt06"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedCnt06" /><s:hidden name="ultBedCnt06"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextBedCnt06" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ベッド数計</td>
	   	<td class="comFormTableItemNf012"><s:label key="bedsTot" /><s:hidden name="bedsTot"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultBedsTot" /><s:hidden name="ultBedsTot"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextBedsTot" size="4" maxlength="4" style="text-align:right;" readonly="true" /></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">医療ベッド数計</td>
	   	<td class="comFormTableItemNf012"><s:label key="medBedsTot" /><s:hidden name="medBedsTot"/></td>
		<td class="comFormTableItemNf012"><s:label key="ultMedBedsTot" /><s:hidden name="ultMedBedsTot"/></td>
		<td class="comFormTableItemNf012"><s:textfield name="nextMedBedsTot" size="4" maxlength="4" style="text-align:right;" readonly="true" /></td>
	</tr>
	</table>
	</s:if>

  <%--コメント類 --%>
  <table id="formTable06" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--コメント--%>
        <td style="width: 650px; height: 0px; border-width: 0px;"></td>
      </tr>
        <tr>
	      <td class="comFormTableItem"><nobr>申請コメント</nobr></td>
      </tr>
        <tr>
	      <td class="comFormTableItem">
	      <nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      	<s:textarea name="reqComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;"/>
		  	</s:if>
		  	<s:else>
		  		<s:textarea name="reqComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;" readonly="true"/>
		  	</s:else>
		  </nobr></td>
		  <td class="comFormTableItem">
		  	<input class="comButton" type="button" name="button" value="申請歴" onClick="histBtn(); JavaScript:return false;" />
		  </td>
      </tr>
      <s:if test='%{loginJokenSetCd == "JKN0813"}'>
      <tr>
	      <td class="comFormTableItem"><nobr>審査・承認メモ</nobr></td>
      </tr>
      <tr>
      	<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && editApprFlg == "1"}'>
	      <td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;"/></nobr></td>
      	</s:if>
      	<s:else>
      		<td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px; background-color:#D4D0C8" readonly="true"/></nobr></td>
      	</s:else>
      </tr>
      </s:if>
  </table>

  <%--ボタン類 --%>
  <table id="formTable07" border="0" class="comPortalTable" align="center" style="width:98%;">
      <tr>
        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 10%; height: 0px; border-width: 0px;"></td>
        <td style="width: 38%; height: 0px; border-width: 0px;"></td>
      </tr>
		<tr>
	      <td class="comFormTableItem">
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="JavaScript:backBtn();return false;" />
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{reqStsCd == "01"}'>
	                <input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;" />
				</s:if>
				<s:else>
					<input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;" disabled />
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(reqStsCd != null && reqStsCd != "" && reqStsCd != "01" && reqStsCd != "03" && reqStsCd != "13")}'>
	                <input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" disabled/>
	            </s:if>
	            <s:else>
	            	<input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" />
	           	</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0813"}'>
					<s:if test='%{shnFlg == "1" || loginJgiNo == reqJgiNo}'>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" onClick="JavaScript:shnCompBtn();return false;"  disabled/>
					</s:if>
					<s:else>
		                <input class="comButton" type="button"name="buttonF3" value="審査完了" onClick="JavaScript:shnCompBtn();return false;" />
					</s:else>
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
               <nobr>
				<s:if test='%{(reqStsCd == null || reqStsCd == "" || reqStsCd == "01")}'>
		                <input class="comButton" type="button"name="buttonF3" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;"/>
				</s:if>
				<s:elseif test='%{(reqStsCd == "03" || reqStsCd == "13")}'>
					<s:if test='%{(loginJokenSetCd == "JKN0813")}'>
		                <input class="comButton" type="button"name="buttonF3" value="承認・却下画面へ" onClick="submitBtn('2');JavaScript:return false;" />
					</s:if>
					<s:else>
						<input class="comButton" type="button"name="buttonF3" value="承認・却下画面へ" onClick="submitBtn('2');JavaScript:return false;" disabled />
					</s:else>
				</s:elseif>
				<s:else>
	                &nbsp;
				</s:else>
                </nobr>
	      </td>
	  </tr>
  </table>
<%-- SUBMIT用パラメータ 終了 --%>
	</td>
	</tr>
    </tbody>
    </table>
<%-- ポータルボディー 終了 --%>
    </s:form>
  </table>

  <jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>
