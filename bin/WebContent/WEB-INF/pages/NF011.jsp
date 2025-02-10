<%--
/**
 * <pre>
 *  施設新規作成のJSP
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
  <title>NF011_施設新規作成</title>
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

    	const option0 = makeOption("","--選択してください--");
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

    	const option0 = makeOption("","--選択してください--");
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

    	const option0 = makeOption("","--選択してください--");
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

    	const option0 = makeOption("","--選択してください--");
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
    // TODO M_RDM_HCO_KEIEITAIから取得か保留中
    function makeManageCdBox(box, insRank){
    	removeBox(box);

    	const option0 = makeOption("","--選択してください--");
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
    	if(changeItem == "1" || changeItem == "4"){
        	var box = document.fm1.pharmType;
        	box = makePharmTypeBox(box,document.fm1.insType.value);
        	if(changeItem != "4"){
        		box.value = "";
        	} else{
        		box.value = document.fm1.tmpPharmType.value;
        	}
    	}

    	// 階級区分
    	if(changeItem == "1" || changeItem == "2" || changeItem == "4"){
        	var box = document.fm1.insRank;
        	box = makeInsRankBox(box,document.fm1.insType.value, document.fm1.pharmType.value);
        	if(changeItem != "4"){
        		box.value = "";
        	} else{
        		box.value = document.fm1.tmpInsRank.value;
        	}
    	}

    	// 定訪先区分
    	if(changeItem == "1" || changeItem == "2" || changeItem == "3" || changeItem == "4"){
        	var box = document.fm1.regVisType;
        	box = makeRegVisTypeBox(box,document.fm1.insType.value, document.fm1.pharmType.value, document.fm1.insRank.value);
        	if(changeItem != "4"){
        		box.value = "";
        	} else{
        		box.value = document.fm1.tmpRegVisType.value;
        	}
    	}

    	//  重点病院区分
    	if(changeItem == "1" || changeItem == "2" || changeItem == "3" || changeItem == "4"){
        	var box = document.fm1.impHosType;
        	box = makeImpHosTypeBox(box,document.fm1.insType.value, document.fm1.pharmType.value, document.fm1.insRank.value);
        	if(changeItem != "4"){
        		box.value = "";
        	} else{
        		box.value = document.fm1.tmpImpHosType.value;
        	}
    	}

    	// 経営主体
    	if(changeItem == "3" || changeItem == "4"){
        	var box = document.fm1.manageCd;
        	box = makeManageCdBox(box,document.fm1.insRank.value);
        	if(changeItem != "4"){
        		box.value = "";
        	} else{
        		box.value = document.fm1.tmpManageCd.value;
        	}
    	}
    }

    // 親施設表示設定
    function mainInsView(){
    	const insType = document.fm1.insType.value;
    	if(insType == "02" || insType == "04" || insType == "05" || insType == "07"){
    		document.getElementById("mainInsTr").style.visibility = "visible";
    	} else {
    		document.getElementById("mainInsTr").style.visibility = "hidden";
    		document.fm1.mainInsCd.value = "";
    		document.fm1.mainInsNm.value = "";
    	}
    }

	// ワクチン情報表示設定
    function vacView(){
    	const insType = document.fm1.insType.value;
    	if(insType == "08"){
    		document.getElementById("vacHr").style.visibility = "visible";
    		document.getElementById("formTable09").style.visibility = "visible";
    	} else {
    		document.getElementById("vacHr").style.visibility = "hidden";
    		document.getElementById("formTable09").style.visibility = "hidden";
    		document.fm1.vacInsType.value = "";
    		document.fm1.vacVisitType.value = "";
    	}
    }

	// 担当者情報表示設定
    function trtView(){
    	const mainInsCd = document.fm1.mainInsCd.value;
    	if(mainInsCd == ""){
    		document.getElementById("trtHr").style.visibility = "visible";
    		document.getElementById("formTable10").style.visibility = "visible";
    	} else {
    		document.getElementById("trtHr").style.visibility = "hidden";
    		document.getElementById("formTable10").style.visibility = "hidden";
    	}
    }

	// 病床数表示設定
	function bedCntView(){
		const insType = document.fm1.insType.value;

		if(insType == "01" || insType == "02"){
    		document.getElementById("bedCntTr").style.visibility = "visible";
    		document.getElementById("formTable08").style.visibility = "visible";

    		// 活性
    		document.fm1.bedCntBase.readOnly = false;
    		document.fm1.bedCnt01.readOnly = false;
    		document.fm1.bedCnt02.readOnly = false;
    		document.fm1.bedCnt03.readOnly = false;
    		document.fm1.bedCnt04.readOnly = false;
    		document.fm1.bedCnt05.readOnly = false;
    		document.fm1.bedCnt06.readOnly = false;
    		document.fm1.bedCnt07.readOnly = false;
    		document.fm1.bedCntBase.style = "";
    		document.fm1.bedCnt01.style = "";
    		document.fm1.bedCnt02.style = "";
    		document.fm1.bedCnt03.style = "";
    		document.fm1.bedCnt04.style = "";
    		document.fm1.bedCnt05.style = "";
    		document.fm1.bedCnt06.style = "";
    		document.fm1.bedCnt07.style = "";

    	}else if(insType == "03" || insType == "06" || insType == "08"
    				|| insType == "09" || insType == "10"){
    		document.getElementById("bedCntTr").style.visibility = "hidden";
    		document.getElementById("formTable08").style.visibility = "hidden";

    		// 非活性
    		document.fm1.bedCntBase.readOnly = true;
    		document.fm1.bedCnt01.readOnly = true;
    		document.fm1.bedCnt02.readOnly = true;
    		document.fm1.bedCnt03.readOnly = true;
    		document.fm1.bedCnt04.readOnly = true;
    		document.fm1.bedCnt05.readOnly = true;
    		document.fm1.bedCnt06.readOnly = true;
    		document.fm1.bedCnt07.readOnly = true;

    		document.fm1.bedCntBase.value = "";
    		document.fm1.bedCnt01.value = "";
    		document.fm1.bedCnt02.value = "";
    		document.fm1.bedCnt03.value = "";
    		document.fm1.bedCnt04.value = "";
    		document.fm1.bedCnt05.value = "";
    		document.fm1.bedCnt06.value = "";
    		document.fm1.bedCnt07.value = "";
    		document.fm1.bedsTot.value = "";
    		document.fm1.medBedsTot.value = "";
    	} else if(insType == "04" || insType == "05" || insType == "07"){
    		document.getElementById("bedCntTr").style.visibility = "visible";
    		document.getElementById("formTable08").style.visibility = "visible";

    		// 非活性
    		document.fm1.bedCntBase.readOnly = true;
    		document.fm1.bedCnt01.readOnly = true;
    		document.fm1.bedCnt02.readOnly = true;
    		document.fm1.bedCnt03.readOnly = true;
    		document.fm1.bedCnt04.readOnly = true;
    		document.fm1.bedCnt05.readOnly = true;
    		document.fm1.bedCnt06.readOnly = true;
    		document.fm1.bedCnt07.readOnly = true;
    		document.fm1.bedCntBase.style = "background-color:#D4D0C8";
    		document.fm1.bedCnt01.style = "background-color:#D4D0C8";
    		document.fm1.bedCnt02.style = "background-color:#D4D0C8";
    		document.fm1.bedCnt03.style = "background-color:#D4D0C8";
    		document.fm1.bedCnt04.style = "background-color:#D4D0C8";
    		document.fm1.bedCnt05.style = "background-color:#D4D0C8";
    		document.fm1.bedCnt06.style = "background-color:#D4D0C8";
    		document.fm1.bedCnt07.style = "background-color:#D4D0C8";

    		document.fm1.bedCntBase.value = "0";
    		document.fm1.bedCnt01.value = "0";
    		document.fm1.bedCnt02.value = "0";
    		document.fm1.bedCnt03.value = "0";
    		document.fm1.bedCnt04.value = "0";
    		document.fm1.bedCnt05.value = "0";
    		document.fm1.bedCnt06.value = "0";
    		document.fm1.bedCnt07.value = "0";
    		document.fm1.bedsTot.value = "0";
    		document.fm1.medBedsTot.value = "0";
    	}

		// 入所定員情報
		if(insType == "06" || insType == "07"){
			document.getElementById("entcapaNumTr").style.visibility = "visible";
		} else {
			document.getElementById("entcapaNumTr").style.visibility = "hidden";
			document.fm1.entcapaNum.value = "";
		}
	}

	// 病床数再計算
	function calcBedCnt(){
		var bedsTot = 0;
		var medBedsTot = 0;

		// 一般
		if(document.fm1.bedCnt01.value != "" && comChkNum(document.fm1.bedCnt01.value)) {
			bedsTot += parseInt(document.fm1.bedCnt01.value);
			medBedsTot += parseInt(document.fm1.bedCnt01.value);
		}

		// 精神
		if(document.fm1.bedCnt03.value != "" && comChkNum(document.fm1.bedCnt03.value)) {
			bedsTot += parseInt(document.fm1.bedCnt03.value);
			medBedsTot += parseInt(document.fm1.bedCnt03.value);
		}

		// 結核
		if(document.fm1.bedCnt04.value != "" && comChkNum(document.fm1.bedCnt04.value)) {
			bedsTot += parseInt(document.fm1.bedCnt04.value);
			medBedsTot += parseInt(document.fm1.bedCnt04.value);
		}

		// 感染症
		if(document.fm1.bedCnt05.value != "" && comChkNum(document.fm1.bedCnt05.value)) {
			bedsTot += parseInt(document.fm1.bedCnt05.value);
			medBedsTot += parseInt(document.fm1.bedCnt05.value);
		}

		// 療養
		if(document.fm1.bedCnt07.value != "" && comChkNum(document.fm1.bedCnt07.value)) {
			bedsTot += parseInt(document.fm1.bedCnt07.value);
		}

		// 医療療養
		if(document.fm1.bedCnt02.value != "" && comChkNum(document.fm1.bedCnt02.value)) {
			medBedsTot += parseInt(document.fm1.bedCnt02.value);
		}

		document.fm1.bedsTot.value = bedsTot;
		document.fm1.medBedsTot.value = medBedsTot;
	}

	// 対象区分値設定
	function setHoInsType(){
		const insRank = document.fm1.insRank.value;

		if(insRank == "01" ||insRank == "02"){
			document.fm1.hoInsType.value = "1";
		} else if(insRank == "03" || insRank == "04" || insRank == "05" || insRank == "06"
			 || insRank == "07" || insRank == "08"){
			document.fm1.hoInsType.value = "2";
		} else if(insRank == "09" || insRank == "10" || insRank == "11" || insRank == "12"
			 || insRank == "13" || insRank == "14"|| insRank == "15" || insRank == "16"
			 || insRank == "17" || insRank == "20"){
			document.fm1.hoInsType.value = "3";
		} else if(insRank == "00" || insRank == "18" || insRank == "19"){
			document.fm1.hoInsType.value = "4";
		} else {
			document.fm1.hoInsType.value = "";
		}

		document.fm1.hoInsTypeView.value = document.fm1.hoInsType.options[document.fm1.hoInsType.selectedIndex].textContent;
	}

    // 初期表示処理
    function onLoadFunc(){
    	changeBox("4");
    	mainInsView();
    	vacView();
    	trtView();
    	bedCntView();

    	// 編集不可設定
		onLoadEditSet();
    	// 対象区分表示
    	document.fm1.hoInsTypeView.value = document.fm1.hoInsType.options[document.fm1.hoInsType.selectedIndex].textContent;
    }

    function onLoadEditSet(){
		editFlg = document.fm1.editApprFlg.value;

		if(editFlg == "0") {
			// 施設種別
			document.fm1.insTypeView.value = document.fm1.insType.options[document.fm1.insType.selectedIndex].textContent;
			document.fm1.insType.hidden = "true";

			// 取引区分
			document.fm1.tradeTypeView.value = document.fm1.tradeType.options[document.fm1.tradeType.selectedIndex].textContent;
			document.fm1.tradeType.hidden = "true";

			// 開業年月日
			document.fm1.insOpenYearView.value = document.fm1.insOpenYear.options[document.fm1.insOpenYear.selectedIndex].textContent;
			document.fm1.insOpenYear.hidden = "true";
			document.fm1.insOpenMonthView.value = document.fm1.insOpenMonth.options[document.fm1.insOpenMonth.selectedIndex].textContent;
			document.fm1.insOpenMonth.hidden = "true";
			document.fm1.insOpenDayView.value = document.fm1.insOpenDay.options[document.fm1.insOpenDay.selectedIndex].textContent;
			document.fm1.insOpenDay.hidden = "true";

			// 施設区分
			document.fm1.pharmTypeView.value = document.fm1.pharmType.options[document.fm1.pharmType.selectedIndex].textContent;
			document.fm1.pharmType.hidden = "true";

			// 階級区分
			document.fm1.insRankView.value = document.fm1.insRank.options[document.fm1.insRank.selectedIndex].textContent;
			document.fm1.insRank.hidden = "true";

			// 定訪先区分
			document.fm1.regVisTypeView.value = document.fm1.regVisType.options[document.fm1.regVisType.selectedIndex].textContent;
			document.fm1.regVisType.hidden = "true";

			// 重点病院区分
			document.fm1.impHosTypeView.value = document.fm1.impHosType.options[document.fm1.impHosType.selectedIndex].textContent;
			document.fm1.impHosType.hidden = "true";

			// 大学細分類
			document.fm1.univSubdivView.value = document.fm1.univSubdiv.options[document.fm1.univSubdiv.selectedIndex].textContent;
			document.fm1.univSubdiv.hidden = "true";

			// 経営主体
			document.fm1.manageCdView.value = document.fm1.manageCd.options[document.fm1.manageCd.selectedIndex].textContent;
			document.fm1.manageCd.hidden = "true";

			// 病床数情報
			document.fm1.bedCntBase.readOnly = true;
    		document.fm1.bedCnt01.readOnly = true;
    		document.fm1.bedCnt02.readOnly = true;
    		document.fm1.bedCnt03.readOnly = true;
    		document.fm1.bedCnt04.readOnly = true;
    		document.fm1.bedCnt05.readOnly = true;
    		document.fm1.bedCnt06.readOnly = true;
    		document.fm1.bedCnt07.readOnly = true;

			// ワクチン対象区分
			document.fm1.vacInsTypeView.value = document.fm1.vacInsType.options[document.fm1.vacInsType.selectedIndex].textContent;
			document.fm1.vacInsType.hidden = "true";

			// ワクチン定訪先区分
			document.fm1.vacVisitTypeView.value = document.fm1.vacVisitType.options[document.fm1.vacVisitType.selectedIndex].textContent;
			document.fm1.vacVisitType.hidden = "true";

		} else {
			document.fm1.insTypeView.hidden = "true";
			document.fm1.tradeTypeView.hidden = "true";
			document.fm1.insOpenYearView.hidden = "true";
			document.fm1.insOpenMonthView.hidden = "true";
			document.fm1.insOpenDayView.hidden = "true";
			document.fm1.pharmTypeView.hidden = "true";
			document.fm1.insRankView.hidden = "true";
			document.fm1.regVisTypeView.hidden = "true";
			document.fm1.impHosTypeView.hidden = "true";
			document.fm1.univSubdivView.hidden = "true";
			document.fm1.manageCdView.hidden = "true";
			document.fm1.vacInsTypeView.hidden = "true";
			document.fm1.vacVisitTypeView.hidden = "true";
		}
    }

    // 親施設選択ボタン
    function mainInsPopBtn(){
		// NC203_施設検索ポップアップ画面を表示
		window.open("","insPopWindow",insSubScreenSize);
		document.fm1.screenId.value = "NC203";
		document.fm1.functionId.value="Init";
		document.fm1.target="insPopWindow";

		const pCode = document.fm1.insPcode.value;
		document.fm1.insPcode.value = "";
		const pharmType = document.fm1.pharmType.value;
		document.fm1.pharmType.value = "";

		if(document.fm1.insType.value == "02" || document.fm1.insType.value == "05") {
			document.fm1.kensakuInsSbt.value = "10";
		} else {
			document.fm1.kensakuInsSbt.value = "";
		}

		document.fm1.koshisetsuCheck.value = "1";
		document.fm1.callBack.value = "callBackMainInsPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();

		document.fm1.insPcode.value = pCode;
		document.fm1.pharmType.value = pharmType;
    }

	// 施設ポップアップから親施設受け取り
    function callBackMainInsPop(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address){

    	document.fm1.mainInsCd.value = insNo;
    	document.fm1.mainInsNm.value = insAbbrName;

    }

	// 数値とﾊｲﾌﾝのみかチェック
	function chkNumhyph(String){
		var i;
		var Letter;

		for( i = 0; i < String.length; i++ ){
			Letter = String.charAt(i);
			if((Letter!="-") && (Letter.search("[^0-9０-９]") != -1)){
				return false;
			}
		}
		return true;
	}

	// 住所候補ボタン
	function addrPopBtn(){
		const pCode = document.fm1.insPcode.value;
		if(pCode == ""){
		// 郵便番号が未入力の場合
			window.alert("必須項目にデータを入力してください。（郵便番号）");
			return false;
		} else if(pCode.length <= 6 || pCode.length >= 9){
			// 郵便番号が６文字以下または９文字以上の場合
			window.alert("最大文字数を超えています。（郵便番号）");
			return false;
		} else if(!chkNumhyph(pCode)){
			// 郵便番号に数字、ハイフン　以外の文字がある場合
			window.alert("入力文字種が不正です。（郵便番号）");
			return false;
		} else if(!comChkSingleByte(pCode)){
			// 郵便番号に全角文字が含まれている場合
			window.alert("半角で入力してください。（郵便番号）");
			return false;
		} else if((pCode.length == 8 && !comChkPostcode_IE(pCode))
					|| (pCode.length == 7 && !comChkNum(pCode))){
			// 郵便番号が３桁数字ー４桁数字　の書式以外の場合
			window.alert("正しい書式で入力してください。（郵便番号）");
			return false;
		}

		document.fm1.postCode.value = pCode.replace("-","");

		// NC205_住所候補ポップアップ画面を表示
		window.open("","addrPopWindow",addrSubScreenSize);
		document.fm1.screenId.value = "NC205";
		document.fm1.functionId.value="Init";
		document.fm1.target="addrPopWindow";

		document.fm1.callBack.value="callBackAddrPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
	}

	// 住所候補ポップアップから値受け取り
	function callBackAddrPop(addrNamePref,addrNameCity,addrNameArea,postCode,addrCodePref,addrCodeCity,
								tkPrefCd,tkCityCd,tkCityName,addrKanaPref,addrKanaCity,addrKanaArea){

		document.fm1.addrCodePrefName.value = addrNamePref;
		document.fm1.addrCodePref.value = addrCodePref;
		document.fm1.addrCodeCityName.value = addrNameCity;
		document.fm1.addrCodeCity.value = addrCodeCity;
		document.fm1.insAddrDt.value = addrNameArea;

		document.fm1.tkCityName.value = tkCityName;
		document.fm1.tkCityCd.value = tkCityCd;

		document.fm1.addrCodePrefKana.value = addrKanaPref;
		document.fm1.addrCodeCityKana.value = addrKanaCity;
		document.fm1.addrDtKana.value = addrKanaArea;
	}

	// 担当者検索ボタン
    function trtPopBtn(){
		// NC202_担当者検索ポップアップ画面を表示
    	window.open("","tantoPopWindow",tantoSubScreenSize);
		document.fm1.screenId.value = "NC202";
		document.fm1.functionId.value="Init";
		document.fm1.target="tantoPopWindow";

		document.fm1.selectFlgPop.value="1";
		document.fm1.callBack.value="callBackTantoPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
    }

	// 担当者行の追加処理
    function callBackTantoPop(sosCd, bumonSeiName, inJgiNo, inJgiName, inTrtCd, brCode, distCode, inTrtGrpCd, inTrtNm, inMrCat){

		let trtTable = document.getElementById("formTable11");
		let trtRow = Number(trtTable.rows.length)-1;

		// 子画面から取得した値を設定する
		let trtCd = inTrtCd;
		let trtNm = inTrtNm;
        let jgiNo = inJgiNo;
        let jgiNm = inJgiName;
        let trtGrpCd = inTrtGrpCd;
        let mrCat = inMrCat;

		let trtCdInp = document.createElement("input");
		let jgiNoInp = document.createElement("input");
		let trtGrpInp = document.createElement("input");
		let mrCatInp = document.createElement("input");
		let delFlgInp = document.createElement("input");

		trtCdInp.setAttribute("type", "hidden");
		jgiNoInp.setAttribute("type", "hidden");
		trtGrpInp.setAttribute("type", "hidden");
		mrCatInp.setAttribute("type", "hidden");
		delFlgInp.setAttribute("type", "hidden");

		trtCdInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].trtCd");
		jgiNoInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].jgiNo");
		trtGrpInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].trtGrpCd");
		mrCatInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].mrCat");
		delFlgInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].deleteFlg");

		trtCdInp.setAttribute("value", trtCd);
		jgiNoInp.setAttribute("value", jgiNo);
		trtGrpInp.setAttribute("value", trtGrpCd);
		mrCatInp.setAttribute("value", mrCat);
		delFlgInp.setAttribute("value", "0");

		let tr = document.createElement("tr");
		let td1 = document.createElement("td");
		let td2 = document.createElement("td");
		let td3 = document.createElement("td");
		let a = document.createElement("a");
		let image = document.createElement("img");

		tr.appendChild(trtCdInp);
		tr.appendChild(jgiNoInp);
		tr.appendChild(trtGrpInp);
		tr.appendChild(mrCatInp);
		tr.appendChild(delFlgInp);

		a.className = "comMiniLink";
		a.setAttribute("href", "#");
		const js = "JavaScript:delTrtRow("+trtRow+");return false;";
		a.setAttribute("onclick", js);
		image.setAttribute("border", "0");
		image.setAttribute("src", "img/button_delete.gif");
		a.appendChild(image);
		td1.appendChild(a);
		tr.appendChild(td1);

		let text1 = document.createTextNode(trtNm);
		td2.appendChild(text1);
		tr.appendChild(td2);
		let text2 = document.createTextNode(jgiNm);
		td3.appendChild(text2);
		tr.appendChild(td3);

		trtTable.appendChild(tr);

		return false;
   	}

	// 担当者行の削除ボタン
	function delTrtRow(index){
		// 対象の行を削除する
		let i = Number(index)+1;
		let trtTable = document.getElementById("formTable11");
		let trtTr = trtTable.rows[i];
		trtTr.style.visibility = "collapse";

		let key = "hcoJkrDataList["+index+"].deleteFlg";
		let delFlg = document.getElementsByName(key)[0];

		delFlg.value = "1";

		return false;
	}

	// 戻るボタン
	function backBtn(){
		document.fm1.target="";
		const preScreenId = document.fm1.preScreenId.value;
		if(preScreenId == "NF001"){
			if(window.confirm("施設検索画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
				document.fm1.screenId.value = preScreenId;
				document.fm1.functionId.value="Init";

				comSubmitForAnyWarp(fm1);
			}
		} else if(preScreenId == "NC011"){
			if(window.confirm("申請一覧画面へ戻ります。よろしいですか？（入力内容は破棄されます。）")){
				document.fm1.screenId.value = preScreenId;
				document.fm1.functionId.value="Init";

				comSubmitForAnyWarp(fm1);
			}
		}
	}

	// 申請破棄ボタン
	function reqCancelBtn(){
		document.fm1.target="";
		if(window.confirm("申請データを破棄します。よろしいですか？")){
		// 申請データを破棄（＝物理的に削除）し、遷移元画面へ遷移する（本画面のタブを閉じる）
		// 申請IDで対象を絞り込み申請管理、施設_申請管理、施設_領域担当者ワークを削除

			document.fm1.screenId.value="NF011";
			document.fm1.functionId.value="Cancel";

			comSubmitForAnyWarp(fm1);
		}
	}

	// 一時保存ボタン、申請画面へ、承認・却下画面へボタン
	function submitBtn(funcId){
		document.fm1.insAddr.value = document.fm1.addrCodePrefName.value + document.fm1.addrCodeCityName.value
										+ document.fm1.insAddrDt.value;
		document.fm1.insAddrKana.value = document.fm1.addrCodePrefKana.value + document.fm1.addrCodeCityKana.value
										+ document.fm1.addrDtKana.value;

		document.fm1.funcId.value = funcId;
		document.fm1.screenId.value="NF011";

		if(funcId == "0") {
			// 一時保存
			document.fm1.screenId.value="NF011";
			document.fm1.functionId.value="Register";
		} else if(funcId == "2") {
			// 承認・却下
			document.fm1.screenId.value="NF301";
			document.fm1.functionId.value="ApprRej";
		} else {
			// 申請
			document.fm1.screenId.value="NF301";
			document.fm1.functionId.value="Init";
		}

		document.fm1.target="";
		comSubmitForAnyWarp(fm1);
	}

	// 審査完了ボタン
	function shnCompBtn(){

		document.fm1.screenId.value="NF011";
		document.fm1.functionId.value="ShnComp";

		document.fm1.target="";
		comSubmitForAnyWarp(fm1);

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
    <s:hidden name="backScreenId" value="NF011" />
     <s:hidden name="preScreenId"/>
     <s:hidden name="screenId"/>
     <s:hidden name="functionId"/>
     <s:hidden name="loginJokenSetCd"/>
     <s:hidden name="loginJgiNo"/>
     <s:hidden name="loginNm"/>
     <s:hidden name="loginBrCd"/>
     <s:hidden name="loginDistCd"/>
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

	<s:hidden name="ultInsCd"/>
	<s:hidden name="ultInsNm"/>
	<s:hidden name="editApprFlg"/>

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

  <s:hidden name="postCode" />
  <s:hidden name="kensakuInsSbt" />
  <s:hidden name="koshisetsuCheck" />
  <s:hidden name="callBack" />

  <s:hidden name="title" />

<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設新規作成"></td>
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
	      <td class="comFormTableItem"><nobr>申請者所属部署</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqShzNm"/></nobr></td>
	      <td class="comFormTableItem"><nobr>申請ステータス</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqStsNm"/></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>申請者</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqJgiName"/></nobr></td>
	      <td class="comFormTableItem"><nobr>申請日時</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="reqYmdhms"/></nobr></td>
	  </tr>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示　申請者には非表示 -->
	  <s:if test='%{reqStsCd != null && reqStsCd != "" && !(reqStsCd == "01" || reqStsCd == "11" || reqStsCd == "03" || reqStsCd == "13") }'>
		<s:if test='%{loginJgiNo != reqJgiNo }'>
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
        <%--ULT施設情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>ULT施設情報</nobr></td>
	      <td class="comFormTableItem"><nobr>ULT施設C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="ultInsCd"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>ULT施設名</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="ultInsNm"/></nobr></td>
      </tr>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--施設種別情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 30px; height: 0px; border-width: 0px;"></td>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 100px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>施設種別情報</nobr></td>
	      <td class="comFormTableItem"><nobr>施設種別<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
	      		<s:select id="insType" name="insType" cssStyle="width:120pt" list ="insTypeCombo" onchange='changeBox("1"); mainInsView(); vacView(); bedCntView();'/>
	      		<s:textfield id="insTypeView" name="insTypeView" cssStyle="width:120pt" readonly="true" />
      		</nobr>
      	　　</td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	　　</tr>
	  <tr id="mainInsTr">
	  	  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>親施設<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem">
                <nobr>
                <s:if test='%{editApprFlg == "1"}'>
                	<input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:mainInsPopBtn(); return false;" />
                </s:if>
                <s:else>
                	<input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:mainInsPopBtn(); return false;" disabled />
                </s:else>
                </nobr>
          </td>
          <td class="comFormTableItem">
          	    <nobr>
                <s:textfield name="mainInsNm" id="mainInsNm" size="20" maxlength="150" style="background-color:#D4D0C8" readonly="true" />
                <s:hidden name="mainInsCd" id="mainInsCd" onchange='trtView();'/>
                <a class="comMiniLink" href="#" onClick="JavaScript:document.fm1.mainInsCd.value='';document.fm1.mainInsNm.value='';return false;">Clear</a>
                </nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--基本情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>基本情報</nobr></td>
	      <td class="comFormTableItem"><nobr>施設略式漢字名(全角)<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
	      		<s:if test='%{editApprFlg == "1"}'>
			      	<s:textfield name="insAbbrName" size="30" maxlength="60" />
				</s:if>
				<s:else>
					<s:textfield name="insAbbrName" size="30" maxlength="60" readonly="true" />
				</s:else>
			</nobr>
		  </td>
	      <td class="comFormTableItem"><nobr>施設カナ名(半角カナ)<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
				<s:textfield name="insKana" size="30" maxlength="45" />
			</s:if>
			<s:else>
				<s:textfield name="insKana" size="30" maxlength="45" readonly="true" />
			</s:else>
			</nobr>
		</td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>施設正式漢字名(全角)<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem" colSpan="3">
	      	<nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
		      	<s:textfield name="insFormalName" size="60" maxlength="240" />
		      </s:if>
		      <s:else>
		      	<s:textfield name="insFormalName" size="60" maxlength="240" readonly="true" />
		      </s:else>
		     </nobr>
		   </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>施設契約用漢字名(全角)<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem" colSpan="3">
	      	<nobr>
				<s:if test='%{editApprFlg == "1"}'>
			      	<s:textfield name="insContName" size="60" maxlength="240" />
		      	</s:if>
		      	<s:else>
		      		<s:textfield name="insContName" size="60" maxlength="240" readonly="true" />
		      	</s:else>
			</nobr>
		</td>
	  </tr>
	  <tr>
	  	  <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>取引区分<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="tradeType" name="tradeType" cssStyle="width:120pt" list ="tradeTypeCombo"/>
	      	<s:textfield id="tradeTypeView" name="tradeTypeView" cssStyle="width:120pt" readonly="true" />
	      	</nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>開業年月日</nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
	      		<s:select id="insOpenYear" name="insOpenYear" cssStyle="width:40pt" list ="insOpenYearCombo"/>
	      		<s:textfield id="insOpenYearView" name="insOpenYearView" cssStyle="width:40pt" readonly="true" />
	      		年
	      		<s:select id="insOpenMonth" name="insOpenMonth" cssStyle="width:30pt" list ="insOpenMonthCombo"/>
	      		<s:textfield id="insOpenMonthView" name="insOpenMonthView" cssStyle="width:40pt" readonly="true" />
	      		月
	      		<s:select id="insOpenDay" name="insOpenDay" cssStyle="width:30pt" list ="insOpenDayCombo"/>
	      		<s:textfield id="insOpenDayView" name="insOpenDayView" cssStyle="width:40pt" readonly="true" />
	      		日
      		</nobr>
	       </td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  </table>
  <br/>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable05" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--住所詳細--%>
        <s:hidden name="insAddr"/>
        <s:hidden name="insAddrKana"/>
        <%--TODO valueを子画面から取得する --%>
        <s:hidden name="addrCodePrefKana" />
        <s:hidden name="addrCodeCityKana" />
        <s:hidden name="addrDtKana" />

        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>住所詳細</nobr></td>
  	    <td class="comFormTableItem"><nobr>郵便番号<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
	    		<s:if test='%{editApprFlg == "1"}'>
		    		<s:textfield name="insPcode" size="15" maxlength="8" />
		    		<input class="comButton" type="button"name="button2" value="住所候補" onClick="JavaScript:addrPopBtn();return false;" />
				</s:if>
				<s:else>
					<s:textfield name="insPcode" size="15" maxlength="8" readonly="true" />
		    		<input class="comButton" type="button"name="button2" value="住所候補" onClick="JavaScript:addrPopBtn();return false;" disabled />
				</s:else>
    		</nobr>
   		</td>
   		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
   		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem"><nobr>JIS府県<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
	    		<s:textfield name="addrCodePrefName" size="15" maxlength="15" style="background-color:#D4D0C8" readonly="true" />
	    		<s:hidden name="addrCodePref" id="addrCodePref"/>
	    	</nobr>
	    </td>
	    <td class="comFormTableItem"><nobr>JIS市区町村<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
	    		<s:textfield name="addrCodeCityName" size="15" style="background-color:#D4D0C8" readonly="true" />
	    		<s:hidden name="addrCodeCity" id="addrCodeCity"/>
	    	</nobr>
	    </td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem"><nobr>町名地番(全角)<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem" colSpan="3">
	    	<nobr>
		    	<s:if test='%{editApprFlg == "1"}'>
			    	<s:textfield name="insAddrDt" size="60" maxlength="300" />
			    </s:if>
			    <s:else>
			    	<s:textfield name="insAddrDt" size="60" maxlength="300" readonly="true" />
			    </s:else>
	    	</nobr>
    	</td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem"><nobr>武田市区群<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
	    		<s:textfield name="tkCityName" size="15" style="background-color:#D4D0C8" readonly="true" />
	    		<s:hidden name="tkCityCd" id="tkCityCd"/>
	    	</nobr>
	    </td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem"><nobr>電話番号(代表)(ﾊｲﾌﾝあり)<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem"><nobr>
	    	<s:if test='%{editApprFlg == "1"}'>
		    	<s:textfield name="insPhone1" size="15" maxlength="13" />
		    </s:if>
		    <s:else>
		    	<s:textfield name="insPhone1" size="15" maxlength="13" readonly="true" />
		    </s:else>
		   </nobr>
		</td>
	    <td class="comFormTableItem"><nobr>FAX番号(代表)(ﾊｲﾌﾝあり)</nobr></td>
	    <td class="comFormTableItem"><nobr>
	    	<s:if test='%{editApprFlg == "1"}'>
		    	<s:textfield name="insFax1" size="15" maxlength="13" />
		    </s:if>
		    <s:else>
		    	<s:textfield name="insFax1" size="15" maxlength="13" readonly="true" />
		    </s:else>
		    </nobr>
		</td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem"><nobr>電話番号(薬局/DI室)(ﾊｲﾌﾝあり)</nobr></td>
	    <td class="comFormTableItem"><nobr>
	    	<s:if test='%{editApprFlg == "1"}'>
			    <s:textfield name="insPhone2" size="15" maxlength="13" />
			</s:if>
			<s:else>
				<s:textfield name="insPhone2" size="15" maxlength="13" readonly="true" />
			</s:else>
	    	</nobr>
	    </td>
	    <td class="comFormTableItem"><nobr>FAX番号(薬局/DI室)(ﾊｲﾌﾝあり)</nobr></td>
	    <td class="comFormTableItem"><nobr>
	    	<s:if test='%{editApprFlg == "1"}'>
		    	<s:textfield name="insFax2" size="15" maxlength="13" />
		    </s:if>
		    <s:else>
		    	<s:textfield name="insFax2" size="15" maxlength="13" readonly="true" />
		    </s:else>
    		</nobr>
    	</td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
  	    <td class="comFormTableItem"><nobr>ホームページアドレス</nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
	    		<s:if test='%{editApprFlg == "1"}'>
		    		<s:textarea name="insUrl" maxlength="150" />
		    	</s:if>
		    	<s:else>
		    		<s:textarea name="insUrl" maxlength="150" readonly="true" />
		    	</s:else>
	    		<input class="comButton" type="button"name="button2" value="表示" onClick="JavaScript:window.open(document.fm1.insUrl.value, '_blank');return false;" />
    		</nobr>
   		</td>
   		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
   		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
      <tr>
  	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem"><nobr>ホームページアドレス更新日</nobr></td>
	    <td class="comFormTableItem"><nobr>
	    	<s:if test='%{editApprFlg == "1"}'>
	    		<s:textfield type="date" name="insUrlYmd" />
	    	</s:if>
	    	<s:else>
	    		<s:textfield type="date" name="insUrlYmd" readonly="true" />
	    	</s:else>
	    	</nobr>
    	</td>
	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	    <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  　　　</table>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>

    <input type="hidden" name="tmpPharmType" value="<s:property value="%{pharmType}"/>" />
    <input type="hidden" name="tmpInsRank" value="<s:property value="%{insRank}"/>" />
    <input type="hidden" name="tmpRegVisType" value="<s:property value="%{regVisType}"/>" />
    <input type="hidden" name="tmpImpHosType" value="<s:property value="%{impHosType}"/>" />
    <table id="formTable06" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--区分情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>区分情報</nobr></td>
	      <td class="comFormTableItem"><nobr>施設区分<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="pharmType" name="pharmType" cssStyle="width:120pt" list ="pharmTypeCombo" onchange='changeBox("2")'/>
	      	<s:textfield id="pharmTypeView" name="pharmTypeView" cssStyle="width:120pt" readonly="true" />
	      	</nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>階級区分<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="insRank" name="insRank" cssStyle="width:120pt" list ="insRankCombo" onchange='changeBox("3"); setHoInsType();'/>
	      	<s:textfield id="insRankView" name="insRankView" cssStyle="width:120pt" readonly="true" />
	      	</nobr>
	      </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>定訪先区分<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="regVisType" name="regVisType" cssStyle="width:120pt" list ="regVisTypeCombo"/>
	      	<s:textfield id="regVisTypeView" name="regVisTypeView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>重点病院区分<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="impHosType" name="impHosType" cssStyle="width:120pt" list ="impHosTypeCombo"/>
	      	<s:textfield id="impHosTypeView" name="impHosTypeView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>大学細分類</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="univSubdiv" name="univSubdiv" cssStyle="width:120pt" list ="univSubdivCombo"/>
	      	<s:textfield id="univSubdivView" name="univSubdivView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>対象区分</nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
	      		<s:select id="hoInsType" name="hoInsType" cssStyle="width:120pt; background-color:#D4D0C8" list ="hoInsTypeCombo" hidden="true" />
	      		<s:textfield id="hoInsTypeView" name="hoInsTypeView" cssStyle="width:120pt; background-color:#D4D0C8" readonly="true" />
	      	</nobr>
	      </td>
      </tr>
  　</table>
  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  	<input type="hidden" name="tmpManageCd" value="<s:property value="%{manageCd}"/>" />
    <table id="formTable07" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--経営主体--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>経営主体</nobr></td>
	      <td class="comFormTableItem"><nobr>経営主体<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="manageCd" name="manageCd" cssStyle="width:120pt" list ="manageCdCombo"/>
	      	<s:textfield id="manageCdView" name="manageCdView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
          <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
          <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  　</table>
  <hr class="comTitle" id="bedCntTr" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable08" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--病床数情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>病床数情報</nobr></td>
	      <td class="comFormTableItem"><nobr>基準<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCntBase" size="4" maxlength="4" /></nobr></td>
	      <td class="comFormTableItem"><nobr>結核<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt04" size="4" maxlength="4" onchange='javascript:calcBedCnt();' /></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>一般<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt01" size="4" maxlength="4" onchange='javascript:calcBedCnt();' /></nobr></td>
	      <td class="comFormTableItem"><nobr>感染症<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt05" size="4" maxlength="4" onchange='javascript:calcBedCnt();' /></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>精神<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt03" size="4" maxlength="4" onchange='javascript:calcBedCnt();' /></nobr></td>
	      <td class="comFormTableItem"><nobr>療養<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt07" size="4" maxlength="4" onchange='javascript:calcBedCnt();' /></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医療療養<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt02" size="4" maxlength="4" onchange='javascript:calcBedCnt();' /></nobr></td>
	      <td class="comFormTableItem"><nobr>介護療養<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt06" size="4" maxlength="4" /></nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>ベッド数計</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedsTot" size="4" maxlength="4" style="background-color:#D4D0C8" readonly="true" /></nobr></td>
	      <td class="comFormTableItem"><nobr>医療ベッド数計</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="medBedsTot" size="4" maxlength="4" style="background-color:#D4D0C8" readonly="true" /></nobr></td>
      </tr>
      <tr id="entcapaNumTr">
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>入所定員情報</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="entcapaNum" size="4" maxlength="4" /></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  　</table>
  <hr class="comTitle" id="vacHr" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable09" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--ワクチン情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>ワクチン情報</nobr></td>
	      <td class="comFormTableItem"><nobr>ワクチン対象区分</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="vacInsType" name="vacInsType" cssStyle="width:80pt" list ="vacInsTypeCombo"/>
	      	<s:textfield id="vacInsTypeView" name="vacInsTypeView" cssStyle="width:80pt" readonly="true" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>ワクチン定訪先区分</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="vacVisitType" name="vacVisitType" cssStyle="width:80pt" list ="vacVisitTypeCombo"/>
	      	<s:textfield id="vacVisitTypeView" name="vacVisitTypeView" cssStyle="width:80pt" readonly="true" />
	      </nobr></td>
      </tr>
  　</table>
  <hr class="comTitle" id="trtHr" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable10" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--担当者情報--%>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>担当者情報</nobr></td>
	      <td class="comFormTableItem"><nobr>領域</nobr></td>
	      <td class="comFormTableItem">
	    	<nobr>
	    		<s:select id="trtCd" name="trtCd" cssStyle="width:80pt" list ="trtCdCombo"/>
	    		<s:if test='%{editApprFlg == "1"}'>
		    		<input class="comButton" type="button"name="button2" value="担当者検索" onClick="JavaScript:trtPopBtn();return false;" />
	    		</s:if>
	    		<s:else>
	    			<input class="comButton" type="button"name="button2" value="担当者検索" onClick="JavaScript:trtPopBtn();return false;" disabled />
	    		</s:else>
    		</nobr>
   		　　</td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem" colSpan="3"><%-- スクロールバー用のテーブルクラスにすること --%>
              <div id="jkrHeader" style="margin:0;width:800px;overflow-y:hidden;overflow-x:auto;position:relative;resize:horizontal;">
			  <table class="comCustomTable" id="formTable11">
				<tr>
				  <%-- ヘッダ行 --%>
			      <td class="comTableTitle" width="20px"><nobr>&nbsp;</nobr></td>
			      <td class="comTableTitle" width="50px"><nobr>領域</nobr></td>
			      <td class="comTableTitle" width="50px"><nobr>担当者</nobr></td>
			    </tr>
			    <s:iterator value="hcoJkrDataList" status="status" var="rowBean">
			      <tr>
			        <%--領域担当者データ取得項目--%>
			        <%--領域担当者データ保持用のHIDDEN項目--%>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].trtCd"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].jgiNo"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].trtGrpCd"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].mrCat"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].deleteFlg"/>

			        <td><%-- アクションボタン --%>
			        <s:if test='%{editApprFlg=="1" && (reqStsCd == "" || reqStsCd == "01" || reqStsCd == "03" || reqStsCd == "13")}'>
			          <nobr>
		                <a class="comMiniLink" href="#" onClick="JavaScript:delTrtRow('<s:property value="%{#status.index}"/>'); return false;" >
		                  <img border="0" src="img/button_delete.gif">
		                </a>
		              </nobr>
			        </s:if>
			        <s:else>
						<nobr>&nbsp;</nobr>
			        </s:else>
					</td>
					<td><nobr><s:label key="hcoJkrDataList[%{#status.index}].trtNm"/></nobr></td>
					<td><nobr><s:label key="hcoJkrDataList[%{#status.index}].jgiNm"/></nobr></td>
			      </tr>
			    </s:iterator>
			  </table>
			  </div>
	      </td>
      </tr>
  　</table>

  <%--コメント類 --%>
  <table id="formTable09" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--コメント--%>
        <td style="width: 650px; height: 0px; border-width: 0px;"></td>
      </tr>
        <tr>
	      <td class="comFormTableItem"><nobr>申請コメント</nobr></td>
      </tr>
        <tr>
	      <td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;"/></nobr></td>
      </tr>
      <s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0813"}'>
      <tr>
	      <td class="comFormTableItem"><nobr>審査・承認メモ</nobr></td>
      </tr>
      <tr>
      	<s:if test='%{reqStsCd == "03" || reqStsCd == "13"}'>
	      <td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;"/></nobr></td>
      	</s:if>
      	<s:else>
      		<td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="300" style="width: 650px; height: 80px;" readonly="true"/></nobr></td>
      	</s:else>
      </tr>
      </s:if>
  </table>

  <%--ボタン類 --%>
  <table id="formTable10" border="0" class="comPortalTable" align="center" style="width:98%;">
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
				<s:if test='%{loginJgiNo == reqJgiNo && reqStsCd == "01"}'>
	                <input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;" />
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{loginJgiNo == reqJgiNo}'>
					<s:if test='%{(reqStsCd != null && reqStsCd != "" && reqStsCd != "01" && reqStsCd != "03" && reqStsCd != "13")}'>
		                <input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" disabled/>
		            </s:if>
		            <s:else>
		            	<input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" />
		           	</s:else>
				</s:if>
				<s:else>
					&nbsp;
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
