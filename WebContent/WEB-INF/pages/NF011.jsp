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
    			|| (insType == "09" && pharmType == "08" && insRank == "18")
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
    			|| (insType == "06" && pharmType == "03" && (insRank == "11" || insRank == "12"))
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
    	if(insRank == "01" || insRank == "03"){
    		box.options[1].hidden = false;
    		box.options[2].hidden = false;
    		box.options[3].hidden = false;
    		box.options[4].hidden = false;
    		box.options[5].hidden = false;
    		box.options[6].hidden = false;
    		box.options[7].hidden = false;
    		box.options[8].hidden = true;
    		box.options[9].hidden = false;
    		box.options[10].hidden = false;
    		box.options[11].hidden = false;
    		box.options[12].hidden = false;
    		box.options[13].hidden = false;
    		box.options[14].hidden = false;
    		box.options[15].hidden = false;
    		box.options[16].hidden = false;
    		box.options[17].hidden = false;
    		box.options[18].hidden = false;
    		box.options[19].hidden = false;
    		box.options[20].hidden = false;
    		box.options[21].hidden = false;
    		box.options[22].hidden = false;
    		box.options[23].hidden = false;
    		box.options[24].hidden = false;
    		box.options[25].hidden = false;
    		box.options[26].hidden = false;
    		box.options[27].hidden = false;
    		box.options[28].hidden = false;
    		box.options[29].hidden = false;
    		box.options[30].hidden = false;
    		box.options[31].hidden = false;
    		box.options[32].hidden = false;
    		box.options[33].hidden = false;
    		box.options[34].hidden = false;
    		box.options[35].hidden = false;
    		box.options[36].hidden = false;
    		box.options[37].hidden = true;
    		box.options[38].hidden = false;
    		box.options[39].hidden = false;
    		box.options[40].hidden = true;
    		box.options[41].hidden = true;
    		box.options[42].hidden = true;
    		box.options[43].hidden = true;
    		box.options[44].hidden = true;
    		box.options[45].hidden = true;
    		box.options[46].hidden = true;
    		box.options[47].hidden = true;
    		box.options[48].hidden = false;
    		box.options[49].hidden = false;
    		box.options[50].hidden = false;
    		box.options[51].hidden = false;
    		box.options[52].hidden = true;
    		box.options[53].hidden = true;
    		box.options[54].hidden = true;
    		box.options[55].hidden = true;
    		box.options[56].hidden = true;
    		box.options[57].hidden = true;
    		box.options[58].hidden = true;
    		box.options[59].hidden = true;
    	} else if(insRank == "02" || insRank == "04") {
    		box.options[1].hidden = true;
    		box.options[2].hidden = true;
    		box.options[3].hidden = true;
    		box.options[4].hidden = true;
    		box.options[5].hidden = true;
    		box.options[6].hidden = true;
    		box.options[7].hidden = true;
    		box.options[8].hidden = true;
    		box.options[9].hidden = true;
    		box.options[10].hidden = true;
    		box.options[11].hidden = true;
    		box.options[12].hidden = true;
    		box.options[13].hidden = true;
    		box.options[14].hidden = true;
    		box.options[15].hidden = true;
    		box.options[16].hidden = true;
    		box.options[17].hidden = true;
    		box.options[18].hidden = true;
    		box.options[19].hidden = true;
    		box.options[20].hidden = true;
    		box.options[21].hidden = true;
    		box.options[22].hidden = true;
    		box.options[23].hidden = true;
    		box.options[24].hidden = true;
    		box.options[25].hidden = true;
    		box.options[26].hidden = true;
    		box.options[27].hidden = true;
    		box.options[28].hidden = true;
    		box.options[29].hidden = true;
    		box.options[30].hidden = true;
    		box.options[31].hidden = true;
    		box.options[32].hidden = true;
    		box.options[33].hidden = true;
    		box.options[34].hidden = true;
    		box.options[35].hidden = true;
    		box.options[36].hidden = true;
    		box.options[37].hidden = false;
    		box.options[38].hidden = true;
    		box.options[39].hidden = true;
    		box.options[40].hidden = false;
    		box.options[41].hidden = false;
    		box.options[42].hidden = false;
    		box.options[43].hidden = false;
    		box.options[44].hidden = false;
    		box.options[45].hidden = false;
    		box.options[46].hidden = false;
    		box.options[47].hidden = false;
    		box.options[48].hidden = true;
    		box.options[49].hidden = true;
    		box.options[50].hidden = true;
    		box.options[51].hidden = true;
    		box.options[52].hidden = false;
    		box.options[53].hidden = false;
    		box.options[54].hidden = false;
    		box.options[55].hidden = false;
    		box.options[56].hidden = false;
    		box.options[57].hidden = false;
    		box.options[58].hidden = false;
    		box.options[59].hidden = false;
    	} else if(insRank == "05" || insRank == "06" || insRank == "16" || insRank == "17"
    		 || insRank == "18" || insRank == "19" || insRank == "20" || insRank == "00"){
    		box.options[1].hidden = false;
    		box.options[2].hidden = false;
    		box.options[3].hidden = false;
    		box.options[4].hidden = false;
    		box.options[5].hidden = false;
    		box.options[6].hidden = false;
    		box.options[7].hidden = false;
    		box.options[8].hidden = true;
    		box.options[9].hidden = false;
    		box.options[10].hidden = false;
    		box.options[11].hidden = false;
    		box.options[12].hidden = false;
    		box.options[13].hidden = false;
    		box.options[14].hidden = false;
    		box.options[15].hidden = false;
    		box.options[16].hidden = false;
    		box.options[17].hidden = false;
    		box.options[18].hidden = false;
    		box.options[19].hidden = false;
    		box.options[20].hidden = false;
    		box.options[21].hidden = false;
    		box.options[22].hidden = false;
    		box.options[23].hidden = false;
    		box.options[24].hidden = false;
    		box.options[25].hidden = false;
    		box.options[26].hidden = false;
    		box.options[27].hidden = false;
    		box.options[28].hidden = false;
    		box.options[29].hidden = false;
    		box.options[30].hidden = false;
    		box.options[31].hidden = false;
    		box.options[32].hidden = false;
    		box.options[33].hidden = false;
    		box.options[34].hidden = false;
    		box.options[35].hidden = false;
    		box.options[36].hidden = false;
    		box.options[37].hidden = false;
    		box.options[38].hidden = false;
    		box.options[39].hidden = false;
    		box.options[40].hidden = false;
    		box.options[41].hidden = false;
    		box.options[42].hidden = false;
    		box.options[43].hidden = false;
    		box.options[44].hidden = false;
    		box.options[45].hidden = false;
    		box.options[46].hidden = false;
    		box.options[47].hidden = false;
    		box.options[48].hidden = false;
    		box.options[49].hidden = false;
    		box.options[50].hidden = false;
    		box.options[51].hidden = false;
    		box.options[52].hidden = false;
    		box.options[53].hidden = false;
    		box.options[54].hidden = false;
    		box.options[55].hidden = false;
    		box.options[56].hidden = false;
    		box.options[57].hidden = false;
    		box.options[58].hidden = false;
    		box.options[59].hidden = false;
    	} else if(insRank == "07" || insRank == "09"){
    		box.options[1].hidden = false;
    		box.options[2].hidden = false;
    		box.options[3].hidden = false;
    		box.options[4].hidden = false;
    		box.options[5].hidden = false;
    		box.options[6].hidden = false;
    		box.options[7].hidden = false;
    		box.options[8].hidden = false;
    		box.options[9].hidden = false;
    		box.options[10].hidden = false;
    		box.options[11].hidden = false;
    		box.options[12].hidden = false;
    		box.options[13].hidden = false;
    		box.options[14].hidden = false;
    		box.options[15].hidden = false;
    		box.options[16].hidden = false;
    		box.options[17].hidden = false;
    		box.options[18].hidden = false;
    		box.options[19].hidden = false;
    		box.options[20].hidden = false;
    		box.options[21].hidden = false;
    		box.options[22].hidden = false;
    		box.options[23].hidden = false;
    		box.options[24].hidden = false;
    		box.options[25].hidden = false;
    		box.options[26].hidden = false;
    		box.options[27].hidden = false;
    		box.options[28].hidden = false;
    		box.options[29].hidden = false;
    		box.options[30].hidden = false;
    		box.options[31].hidden = false;
    		box.options[32].hidden = false;
    		box.options[33].hidden = false;
    		box.options[34].hidden = false;
    		box.options[35].hidden = false;
    		box.options[36].hidden = false;
    		box.options[37].hidden = true;
    		box.options[38].hidden = false;
    		box.options[39].hidden = false;
    		box.options[40].hidden = true;
    		box.options[41].hidden = true;
    		box.options[42].hidden = true;
    		box.options[43].hidden = true;
    		box.options[44].hidden = true;
    		box.options[45].hidden = true;
    		box.options[46].hidden = true;
    		box.options[47].hidden = true;
    		box.options[48].hidden = false;
    		box.options[49].hidden = false;
    		box.options[50].hidden = false;
    		box.options[51].hidden = false;
    		box.options[52].hidden = true;
    		box.options[53].hidden = true;
    		box.options[54].hidden = true;
    		box.options[55].hidden = true;
    		box.options[56].hidden = true;
    		box.options[57].hidden = true;
    		box.options[58].hidden = true;
    		box.options[59].hidden = true;
    	} else if(insRank == "08" || insRank == "10"){
    		box.options[1].hidden = true;
    		box.options[2].hidden = true;
    		box.options[3].hidden = true;
    		box.options[4].hidden = true;
    		box.options[5].hidden = true;
    		box.options[6].hidden = true;
    		box.options[7].hidden = true;
    		box.options[8].hidden = true;
    		box.options[9].hidden = true;
    		box.options[10].hidden = true;
    		box.options[11].hidden = true;
    		box.options[12].hidden = true;
    		box.options[13].hidden = true;
    		box.options[14].hidden = true;
    		box.options[15].hidden = true;
    		box.options[16].hidden = true;
    		box.options[17].hidden = true;
    		box.options[18].hidden = true;
    		box.options[19].hidden = true;
    		box.options[20].hidden = true;
    		box.options[21].hidden = true;
    		box.options[22].hidden = true;
    		box.options[23].hidden = true;
    		box.options[24].hidden = true;
    		box.options[25].hidden = true;
    		box.options[26].hidden = true;
    		box.options[27].hidden = true;
    		box.options[28].hidden = true;
    		box.options[29].hidden = true;
    		box.options[30].hidden = true;
    		box.options[31].hidden = true;
    		box.options[32].hidden = true;
    		box.options[33].hidden = true;
    		box.options[34].hidden = true;
    		box.options[35].hidden = true;
    		box.options[36].hidden = true;
    		box.options[37].hidden = false;
    		box.options[38].hidden = true;
    		box.options[39].hidden = true;
    		box.options[40].hidden = false;
    		box.options[41].hidden = false;
    		box.options[42].hidden = false;
    		box.options[43].hidden = false;
    		box.options[44].hidden = false;
    		box.options[45].hidden = false;
    		box.options[46].hidden = false;
    		box.options[47].hidden = false;
    		box.options[48].hidden = true;
    		box.options[49].hidden = true;
    		box.options[50].hidden = true;
    		box.options[51].hidden = true;
    		box.options[52].hidden = false;
    		box.options[53].hidden = false;
    		box.options[54].hidden = false;
    		box.options[55].hidden = false;
    		box.options[56].hidden = false;
    		box.options[57].hidden = false;
    		box.options[58].hidden = false;
    		box.options[59].hidden = false;
    	} else if(insRank == "11" || insRank == "12"){
    		box.options[1].hidden = false;
    		box.options[2].hidden = false;
    		box.options[3].hidden = false;
    		box.options[4].hidden = false;
    		box.options[5].hidden = false;
    		box.options[6].hidden = false;
    		box.options[7].hidden = false;
    		box.options[8].hidden = false;
    		box.options[9].hidden = false;
    		box.options[10].hidden = false;
    		box.options[11].hidden = false;
    		box.options[12].hidden = false;
    		box.options[13].hidden = false;
    		box.options[14].hidden = false;
    		box.options[15].hidden = false;
    		box.options[16].hidden = false;
    		box.options[17].hidden = false;
    		box.options[18].hidden = false;
    		box.options[19].hidden = false;
    		box.options[20].hidden = false;
    		box.options[21].hidden = false;
    		box.options[22].hidden = false;
    		box.options[23].hidden = false;
    		box.options[24].hidden = false;
    		box.options[25].hidden = false;
    		box.options[26].hidden = false;
    		box.options[27].hidden = false;
    		box.options[28].hidden = false;
    		box.options[29].hidden = false;
    		box.options[30].hidden = false;
    		box.options[31].hidden = false;
    		box.options[32].hidden = false;
    		box.options[33].hidden = false;
    		box.options[34].hidden = false;
    		box.options[35].hidden = false;
    		box.options[36].hidden = false;
    		box.options[37].hidden = false;
    		box.options[38].hidden = false;
    		box.options[39].hidden = false;
    		box.options[40].hidden = false;
    		box.options[41].hidden = false;
    		box.options[42].hidden = false;
    		box.options[43].hidden = false;
    		box.options[44].hidden = false;
    		box.options[45].hidden = false;
    		box.options[46].hidden = false;
    		box.options[47].hidden = false;
    		box.options[48].hidden = false;
    		box.options[49].hidden = false;
    		box.options[50].hidden = false;
    		box.options[51].hidden = false;
    		box.options[52].hidden = false;
    		box.options[53].hidden = false;
    		box.options[54].hidden = false;
    		box.options[55].hidden = false;
    		box.options[56].hidden = false;
    		box.options[57].hidden = false;
    		box.options[58].hidden = false;
    		box.options[59].hidden = false;
    	} else if(insRank == "13" || insRank == "14" || insRank == "15"){
    		box.options[1].hidden = true;
    		box.options[2].hidden = true;
    		box.options[3].hidden = true;
    		box.options[4].hidden = true;
    		box.options[5].hidden = true;
    		box.options[6].hidden = true;
    		box.options[7].hidden = true;
    		box.options[8].hidden = true;
    		box.options[9].hidden = true;
    		box.options[10].hidden = true;
    		box.options[11].hidden = true;
    		box.options[12].hidden = true;
    		box.options[13].hidden = true;
    		box.options[14].hidden = false;
    		box.options[15].hidden = true;
    		box.options[16].hidden = true;
    		box.options[17].hidden = true;
    		box.options[18].hidden = true;
    		box.options[19].hidden = true;
    		box.options[20].hidden = true;
    		box.options[21].hidden = true;
    		box.options[22].hidden = true;
    		box.options[23].hidden = false;
    		box.options[24].hidden = false;
    		box.options[25].hidden = true;
    		box.options[26].hidden = false;
    		box.options[27].hidden = true;
    		box.options[28].hidden = true;
    		box.options[29].hidden = true;
    		box.options[30].hidden = true;
    		box.options[31].hidden = true;
    		box.options[32].hidden = true;
    		box.options[33].hidden = true;
    		box.options[34].hidden = true;
    		box.options[35].hidden = true;
    		box.options[36].hidden = true;
    		box.options[37].hidden = true;
    		box.options[38].hidden = true;
    		box.options[39].hidden = true;
    		box.options[40].hidden = false;
    		box.options[41].hidden = false;
    		box.options[42].hidden = true;
    		box.options[43].hidden = false;
    		box.options[44].hidden = false;
    		box.options[45].hidden = false;
    		box.options[46].hidden = true;
    		box.options[47].hidden = true;
    		box.options[48].hidden = true;
    		box.options[49].hidden = true;
    		box.options[50].hidden = true;
    		box.options[51].hidden = true;
    		box.options[52].hidden = true;
    		box.options[53].hidden = true;
    		box.options[54].hidden = false;
    		box.options[55].hidden = false;
    		box.options[56].hidden = true;
    		box.options[57].hidden = true;
    		box.options[58].hidden = true;
    		box.options[59].hidden = true;
    	}
    	return box;
    }

	// セレクトボックスの設定
    function changeBox(changeItem){
   		var insType = document.fm1.insType.value;
   		var pharmType = document.fm1.pharmType.value;
   		var insRank = document.fm1.insRank.value;
   		var regVisType = document.fm1.regVisType.value;
   		var impHosType = document.fm1.impHosType.value;
   		var univSubdiv = document.fm1.univSubdiv.value;
   		var manageCd = document.fm1.manageCd.value;

   		var pharmTypeBox = document.fm1.pharmType;
   		var insRankBox = document.fm1.insRank;
   		var regVisTypeBox = document.fm1.regVisType;
   		var impHosTypeBox = document.fm1.impHosType;
   		var univSubdivBox = document.fm1.univSubdiv;
   		var manageCdBox = document.fm1.manageCd;

    	if(changeItem == "1"){
	   		// 施設種別を変更
    		if(insType == ""){
    			document.getElementById("pharmType").disabled = true;
    			document.getElementById("insRank").disabled = true;
    			document.getElementById("regVisType").disabled = true;
    			document.getElementById("impHosType").disabled = true;
    			document.getElementById("manageCd").disabled = true;
    			document.fm1.univSubdiv.value = "";
    			document.getElementById("univSubdivTd01").style.visibility = "hidden";
    			document.getElementById("univSubdivTd02").style.visibility = "hidden";
    			document.getElementById("pharmTypeAst").hidden = false;
    			document.getElementById("insRankAst").hidden = false;
    			document.getElementById("regVisTypeAst").hidden = false;
    			document.getElementById("impHosTypeAst").hidden = false;
    			document.getElementById("manageCdAst").hidden = false;

    			bedCntView(2);
    		} else if(insType == "01"){
    			document.getElementById("pharmType").disabled = false;
    			document.getElementById("insRank").disabled = true;
    			document.getElementById("regVisType").disabled = true;
    			document.getElementById("impHosType").disabled = true;
    			document.getElementById("manageCd").disabled = true;
    			document.getElementById("univSubdivTd01").style.visibility = "visible";
    			document.getElementById("univSubdivTd02").style.visibility = "visible";
    			document.getElementById("univSubdiv").disabled = true;
    			document.getElementById("pharmTypeAst").hidden = false;
    			document.getElementById("insRankAst").hidden = false;
    			document.getElementById("regVisTypeAst").hidden = false;
    			document.getElementById("impHosTypeAst").hidden = false;
    			document.getElementById("manageCdAst").hidden = false;

    			bedCntView(2);
    		} else if(insType == "02"){
    			document.getElementById("pharmType").disabled = false;
    			document.getElementById("insRank").disabled = true;
    			document.getElementById("regVisType").disabled = true;
    			document.getElementById("impHosType").disabled = true;
    			document.getElementById("manageCd").disabled = true;
    			document.fm1.univSubdiv.value = "";
    			document.getElementById("univSubdivTd01").style.visibility = "hidden";
    			document.getElementById("univSubdivTd02").style.visibility = "hidden";
    			document.getElementById("pharmTypeAst").hidden = false;
    			document.getElementById("insRankAst").hidden = false;
    			document.getElementById("regVisTypeAst").hidden = false;
    			document.getElementById("impHosTypeAst").hidden = false;
    			document.getElementById("manageCdAst").hidden = false;

    			bedCntView(2);
    		} else if(insType == "03" || insType == "06" || insType == "08" || insType == "09" || insType == "10"){
    			document.getElementById("pharmType").disabled = false;
    			document.getElementById("insRank").disabled = true;
    			document.getElementById("regVisType").disabled = true;
    			document.getElementById("impHosType").disabled = true;
    			document.getElementById("manageCd").disabled = true;
    			document.fm1.univSubdiv.value = "";
    			document.getElementById("univSubdivTd01").style.visibility = "hidden";
    			document.getElementById("univSubdivTd02").style.visibility = "hidden";
    			document.getElementById("pharmTypeAst").hidden = false;
    			document.getElementById("insRankAst").hidden = false;
    			document.getElementById("regVisTypeAst").hidden = false;
    			document.getElementById("impHosTypeAst").hidden = false;
    			document.getElementById("manageCdAst").hidden = false;

    			bedCntView(0);
    		} else if(insType == "04" || insType == "05" || insType == "07"){
    			document.getElementById("pharmType").disabled = true;
    			document.getElementById("insRank").disabled = true;
    			document.getElementById("regVisType").disabled = true;
    			document.getElementById("impHosType").disabled = true;
    			document.getElementById("manageCd").disabled = true;
    			document.fm1.univSubdiv.value = "";
    			document.getElementById("univSubdivTd01").style.visibility = "hidden";
    			document.getElementById("univSubdivTd02").style.visibility = "hidden";
    			document.getElementById("pharmTypeAst").hidden = true;
    			document.getElementById("insRankAst").hidden = true;
    			document.getElementById("regVisTypeAst").hidden = true;
    			document.getElementById("impHosTypeAst").hidden = true;
    			document.getElementById("manageCdAst").hidden = true;

    			bedCntView(1);
    		}

    		pharmTypeBox = makePharmTypeBox(pharmTypeBox,insType);
			insRankBox = makeInsRankBox(insRankBox,insType, pharmType);
			regVisTypeBox = makeRegVisTypeBox(regVisTypeBox,insType, pharmType, insRank);
			impHosTypeBox = makeImpHosTypeBox(impHosTypeBox,insType, pharmType, insRank);
			manageCdBox = makeManageCdBox(manageCdBox,insRank);

        	pharmType = "";
       		insRank = "";
       		regVisType = "";
       		impHosType = "";
       		document.fm1.manageCd.value = "";
       		setHoInsType();

       		// 担当者選択
      		if(insType == "09"){
      			document.getElementById("trtButton").disabled = true;

      			// 担当者欄をクリア
				trtTantoClear();

      		} else {
      			document.getElementById("trtButton").disabled = false;
      		}

    	} else if(changeItem == "2"){
    		// 施設区分を変更
    		if(insType == "01" && pharmType == "01"){
    			document.getElementById("insRank").disabled = false;
    			document.getElementById("regVisType").disabled = true;
    			document.getElementById("impHosType").disabled = true;
    			document.getElementById("univSubdiv").disabled = false;
    			document.getElementById("manageCd").disabled = true;
    			document.getElementById("insRankAst").hidden = false;
    			document.getElementById("regVisTypeAst").hidden = false;
    			document.getElementById("impHosTypeAst").hidden = false;
    			document.getElementById("manageCdAst").hidden = false;

    		} else if(insType == "01" && pharmType != "01"){
    			document.getElementById("insRank").disabled = false;
    			document.getElementById("regVisType").disabled = true;
    			document.getElementById("impHosType").disabled = true;
    			document.getElementById("univSubdiv").disabled = true;
    			document.getElementById("manageCd").disabled = true;
    			document.getElementById("insRankAst").hidden = false;
    			document.getElementById("regVisTypeAst").hidden = false;
    			document.getElementById("impHosTypeAst").hidden = false;
    			document.getElementById("manageCdAst").hidden = false;

    		} else {
    			document.getElementById("insRank").disabled = false;
    			document.getElementById("regVisType").disabled = true;
    			document.getElementById("impHosType").disabled = true;
    			document.getElementById("univSubdiv").disabled = true;
    			document.getElementById("manageCd").disabled = true;
    		}

    		insRankBox = makeInsRankBox(insRankBox,insType, pharmType);
			regVisTypeBox = makeRegVisTypeBox(regVisTypeBox,insType, pharmType, insRank);
			impHosTypeBox = makeImpHosTypeBox(impHosTypeBox,insType, pharmType, insRank);
			manageCdBox = makeManageCdBox(manageCdBox,insRank);

       		insRank = "";
       		regVisType = "";
       		impHosType = "";
       		document.fm1.univSubdiv.value = "";
       		document.fm1.manageCd.value = "";
       		setHoInsType();

    	} else if(changeItem == "3"){
    		// 階級区分を変更
   			document.getElementById("regVisType").disabled = false;
   			document.getElementById("impHosType").disabled = false;
   			document.getElementById("manageCd").disabled = false;

	    	regVisTypeBox = makeRegVisTypeBox(regVisTypeBox,insType, pharmType, insRank);
			impHosTypeBox = makeImpHosTypeBox(impHosTypeBox,insType, pharmType, insRank);
			manageCdBox = makeManageCdBox(manageCdBox,insRank);

	   		regVisType = "";
	   		impHosType = "";
	   		manageCd = "";
	   		setHoInsType();

    	}
    }

	// 初期表示時のセレクトボックスの設定
    function onLoadChangeBox(){
   		var insType = document.fm1.insType.value;
   		var pharmType = document.fm1.tmpPharmType.value;
   		var insRank = document.fm1.tmpInsRank.value;
   		var regVisType = document.fm1.tmpRegVisType.value;
   		var impHosType = document.fm1.tmpImpHosType.value;
   		var manageCd = document.fm1.tmpManageCd.value;

   		var pharmTypeBox = document.fm1.pharmType;
   		var insRankBox = document.fm1.insRank;
   		var regVisTypeBox = document.fm1.regVisType;
   		var impHosTypeBox = document.fm1.impHosType;
   		var univSubdivBox = document.fm1.univSubdiv;
   		var manageCdBox = document.fm1.manageCd;

 		pharmTypeBox = makePharmTypeBox(pharmTypeBox,insType);
 		insRankBox = makeInsRankBox(insRankBox,insType, pharmType);
 		regVisTypeBox = makeRegVisTypeBox(regVisTypeBox,insType, pharmType, insRank);
 		impHosTypeBox = makeImpHosTypeBox(impHosTypeBox,insType, pharmType, insRank);
 		manageCdBox = makeManageCdBox(manageCdBox,insRank);

		document.fm1.pharmType.value = pharmType;
		document.fm1.insRank.value = insRank;
		document.fm1.regVisType.value = document.fm1.tmpRegVisType.value;
		document.fm1.impHosType.value = document.fm1.tmpImpHosType.value;
		document.fm1.manageCd.value = document.fm1.tmpManageCd.value;

  		if(insRank != ""){
   		   	if(insType == "01" && insRank != "01"){
   		   		document.getElementById("univSubdiv").disabled = true;
   		   	} else if(insType == "02"){
   			   	document.getElementById("univSubdivTd01").style.visibility = "hidden";
				document.getElementById("univSubdivTd02").style.visibility = "hidden";
   		   	} else if(insType != "01"){
	   		   	document.getElementById("univSubdivTd01").style.visibility = "hidden";
				document.getElementById("univSubdivTd02").style.visibility = "hidden";
				bedCntView(0);
   		   	}
   		} else if(pharmType != ""){
   		   	if(insType == "01" && pharmType == "01"){
   		   		document.getElementById("regVisType").disabled = true;
   		   		document.getElementById("impHosType").disabled = true;
   		   		document.getElementById("manageCd").disabled = true;
   			} else if(insType == "01" && pharmType != "01"){
   				document.getElementById("regVisType").disabled = true;
   		   		document.getElementById("impHosType").disabled = true;
   		   		document.getElementById("univSubdiv").disabled = true;
   		   		document.getElementById("manageCd").disabled = true;
   			} else if(insType == "02"){
   				document.getElementById("regVisType").disabled = true;
   		   		document.getElementById("impHosType").disabled = true;
   		   		document.getElementById("univSubdivTd01").style.visibility = "hidden";
				document.getElementById("univSubdivTd02").style.visibility = "hidden";
   		   		document.getElementById("manageCd").disabled = true;
   			} else {
   				document.getElementById("regVisType").disabled = true;
   		   		document.getElementById("impHosType").disabled = true;
   		   		document.getElementById("manageCd").disabled = true;
   		   		bedCntView(0);
   			}
   		} else if(insType == "01"){
   			document.getElementById("insRank").disabled = true;
   			document.getElementById("regVisType").disabled = true;
   			document.getElementById("impHosType").disabled = true;
   			document.getElementById("univSubdiv").disabled = true;
   			document.getElementById("manageCd").disabled = true;

   		} else if(insType == "02"){
   			document.getElementById("insRank").disabled = true;
   			document.getElementById("regVisType").disabled = true;
   			document.getElementById("impHosType").disabled = true;
   			document.getElementById("univSubdivTd01").style.visibility = "hidden";
			document.getElementById("univSubdivTd02").style.visibility = "hidden";
   			document.getElementById("manageCd").disabled = true;
   		} else if(insType == "03" || insType == "06" || insType == "08" || insType == "09" || insType == "10"){
   			document.getElementById("insRank").disabled = true;
   			document.getElementById("regVisType").disabled = true;
   			document.getElementById("impHosType").disabled = true;
   			document.getElementById("univSubdivTd01").style.visibility = "hidden";
			document.getElementById("univSubdivTd02").style.visibility = "hidden";
   			document.getElementById("manageCd").disabled = true;
   			bedCntView(0);
   		} else if(insType == "04" || insType == "05" || insType == "07"){
   			document.getElementById("pharmType").disabled = true;
   			document.getElementById("insRank").disabled = true;
   			document.getElementById("regVisType").disabled = true;
   			document.getElementById("impHosType").disabled = true;
   			document.getElementById("univSubdivTd01").style.visibility = "hidden";
			document.getElementById("univSubdivTd02").style.visibility = "hidden";
   			document.getElementById("manageCd").disabled = true;
   			document.getElementById("pharmTypeAst").hidden = true;
   			document.getElementById("insRankAst").hidden = true;
			document.getElementById("regVisTypeAst").hidden = true;
			document.getElementById("impHosTypeAst").hidden = true;
			document.getElementById("manageCdAst").hidden = true;
   			bedCntView(1);
   		} else {
   			document.getElementById("pharmType").disabled = true;
   			document.getElementById("insRank").disabled = true;
   			document.getElementById("regVisType").disabled = true;
   			document.getElementById("impHosType").disabled = true;
   			document.getElementById("univSubdivTd01").style.visibility = "hidden";
			document.getElementById("univSubdivTd02").style.visibility = "hidden";
   			document.getElementById("manageCd").disabled = true;
   		}

  		// 入所定員情報
  		if(insType != "06" && insType != "07"){
  			document.getElementById("entcapaNumTr").style.visibility = "collapse";
  		}

  		// 担当者選択
  		if(insType == "09"){
			document.getElementById("trtButton").disabled = true;
  		}
	}

	// 病床数表示設定
	// kbn 0:非表示、 1:非活性、2:活性
	function bedCntView(kbn){
		if(kbn == 0){
			// 病床数非表示
			if(document.fm1.insType.value == "06"){
				// 入所定員数表示
				document.getElementById("bedCntHr").style.visibility = "visible";
				document.getElementById("formTable08").style.visibility = "visible";
				document.getElementById("bedCntTr01").style.visibility = "visible";

				document.getElementById("bedCntTd01").style.visibility = "collapse";
				document.getElementById("bedCntTd02").style.visibility = "collapse";
				document.getElementById("bedCntTd03").style.visibility = "collapse";
				document.getElementById("bedCntTd04").style.visibility = "collapse";

				document.getElementById("bedCntTr02").style.visibility = "collapse";
				document.getElementById("bedCntTr03").style.visibility = "collapse";
				document.getElementById("bedCntTr04").style.visibility = "collapse";
				document.getElementById("bedCntTr05").style.visibility = "collapse";

				document.getElementById("entcapaNumTr").style.visibility = "visible";

				document.fm1.bedCntBase.value = "";
	    		document.fm1.bedCnt01.value = "";
	    		document.fm1.bedCnt02.value = "";
	    		document.fm1.bedCnt03.value = "";
	    		document.fm1.bedCnt04.value = "";
	    		document.fm1.bedCnt05.value = "";
	    		document.fm1.bedCnt06.value = "";
	    		document.fm1.bedCnt07.value = "";
	    		document.fm1.bedsTot.value = "0";
	    		document.fm1.medBedsTot.value = "0";

			} else {
				// 入所定員数非表示
				document.getElementById("bedCntHr").style.visibility = "collapse";
				document.getElementById("formTable08").style.visibility = "collapse";

				document.fm1.bedCntBase.value = "";
	    		document.fm1.bedCnt01.value = "";
	    		document.fm1.bedCnt02.value = "";
	    		document.fm1.bedCnt03.value = "";
	    		document.fm1.bedCnt04.value = "";
	    		document.fm1.bedCnt05.value = "";
	    		document.fm1.bedCnt06.value = "";
	    		document.fm1.bedCnt07.value = "";
	    		document.fm1.bedsTot.value = "0";
	    		document.fm1.medBedsTot.value = "0";
	    		document.fm1.entcapaNum.value = "";
			}
		} else if(kbn == 1){
			// 病床数非活性
			if(document.fm1.insType.value == "07"){
				// 入所定員数表示
				document.fm1.bedCntBase.style = "text-align:right;";
	    		document.fm1.bedCnt01.style = "text-align:right;";
	    		document.fm1.bedCnt02.style = "text-align:right;";
	    		document.fm1.bedCnt03.style = "text-align:right;";
	    		document.fm1.bedCnt04.style = "text-align:right;";
	    		document.fm1.bedCnt05.style = "text-align:right;";
	    		document.fm1.bedCnt06.style = "text-align:right;";
				document.fm1.bedCnt07.style = "text-align:right;";

				document.fm1.bedCntBase.className = "mediumGray";
	    		document.fm1.bedCnt01.className = "mediumGray";
	    		document.fm1.bedCnt02.className = "mediumGray";
	    		document.fm1.bedCnt03.className = "mediumGray";
	    		document.fm1.bedCnt04.className = "mediumGray";
	    		document.fm1.bedCnt05.className = "mediumGray";
	    		document.fm1.bedCnt06.className = "mediumGray";
				document.fm1.bedCnt07.className = "mediumGray";

				document.getElementById("bedCntHr").style.visibility = "visible";
				document.getElementById("formTable08").style.visibility = "visible";
				document.getElementById("bedCntTr01").style.visibility = "visible";

				document.getElementById("bedCntTd01").style.visibility = "visible";
				document.getElementById("bedCntTd02").style.visibility = "visible";
				document.getElementById("bedCntTd03").style.visibility = "visible";
				document.getElementById("bedCntTd04").style.visibility = "visible";

				document.getElementById("bedCntTr02").style.visibility = "visible";
				document.getElementById("bedCntTr03").style.visibility = "visible";
				document.getElementById("bedCntTr04").style.visibility = "visible";
				document.getElementById("bedCntTr05").style.visibility = "visible";

				document.fm1.bedCntBase.readOnly = true;
	    		document.fm1.bedCnt01.readOnly = true;
	    		document.fm1.bedCnt02.readOnly = true;
	    		document.fm1.bedCnt03.readOnly = true;
	    		document.fm1.bedCnt04.readOnly = true;
	    		document.fm1.bedCnt05.readOnly = true;
	    		document.fm1.bedCnt06.readOnly = true;
	    		document.fm1.bedCnt07.readOnly = true;

				document.getElementById("entcapaNumTr").style.visibility = "visible";

				document.fm1.bedCntBase.value = "";
	    		document.fm1.bedCnt01.value = "";
	    		document.fm1.bedCnt02.value = "";
	    		document.fm1.bedCnt03.value = "";
	    		document.fm1.bedCnt04.value = "";
	    		document.fm1.bedCnt05.value = "";
	    		document.fm1.bedCnt06.value = "";
	    		document.fm1.bedCnt07.value = "";
	    		document.fm1.bedsTot.value = "0";
	    		document.fm1.medBedsTot.value = "0";

			} else {
				// 入所定員数非表示
				document.fm1.bedCntBase.style = "text-align:right;";
	    		document.fm1.bedCnt01.style = "text-align:right;";
	    		document.fm1.bedCnt02.style = "text-align:right;";
	    		document.fm1.bedCnt03.style = "text-align:right;";
	    		document.fm1.bedCnt04.style = "text-align:right;";
	    		document.fm1.bedCnt05.style = "text-align:right;";
	    		document.fm1.bedCnt06.style = "text-align:right;";
				document.fm1.bedCnt07.style = "text-align:right;";

				document.fm1.bedCntBase.className = "mediumGray";
	    		document.fm1.bedCnt01.className = "mediumGray";
	    		document.fm1.bedCnt02.className = "mediumGray";
	    		document.fm1.bedCnt03.className = "mediumGray";
	    		document.fm1.bedCnt04.className = "mediumGray";
	    		document.fm1.bedCnt05.className = "mediumGray";
	    		document.fm1.bedCnt06.className = "mediumGray";
				document.fm1.bedCnt07.className = "mediumGray";

				document.getElementById("bedCntHr").style.visibility = "visible";
				document.getElementById("formTable08").style.visibility = "visible";
				document.getElementById("bedCntTr01").style.visibility = "visible";

				document.getElementById("bedCntTd01").style.visibility = "visible";
				document.getElementById("bedCntTd02").style.visibility = "visible";
				document.getElementById("bedCntTd03").style.visibility = "visible";
				document.getElementById("bedCntTd04").style.visibility = "visible";

				document.getElementById("bedCntTr02").style.visibility = "visible";
				document.getElementById("bedCntTr03").style.visibility = "visible";
				document.getElementById("bedCntTr04").style.visibility = "visible";
				document.getElementById("bedCntTr05").style.visibility = "visible";

				document.getElementById("bedCntBaseAst").hidden = true;
				document.getElementById("bedCnt04Ast").hidden = true;
				document.getElementById("bedCnt01Ast").hidden = true;
				document.getElementById("bedCnt05Ast").hidden = true;
				document.getElementById("bedCnt03Ast").hidden = true;
				document.getElementById("bedCnt07Ast").hidden = true;
				document.getElementById("bedCnt02Ast").hidden = true;
				document.getElementById("bedCnt06Ast").hidden = true;

				document.fm1.bedCntBase.readOnly = true;
	    		document.fm1.bedCnt01.readOnly = true;
	    		document.fm1.bedCnt02.readOnly = true;
	    		document.fm1.bedCnt03.readOnly = true;
	    		document.fm1.bedCnt04.readOnly = true;
	    		document.fm1.bedCnt05.readOnly = true;
	    		document.fm1.bedCnt06.readOnly = true;
	    		document.fm1.bedCnt07.readOnly = true;

				document.getElementById("entcapaNumTr").style.visibility = "collapse";

				document.fm1.bedCntBase.value = "";
	    		document.fm1.bedCnt01.value = "";
	    		document.fm1.bedCnt02.value = "";
	    		document.fm1.bedCnt03.value = "";
	    		document.fm1.bedCnt04.value = "";
	    		document.fm1.bedCnt05.value = "";
	    		document.fm1.bedCnt06.value = "";
	    		document.fm1.bedCnt07.value = "";
	    		document.fm1.bedsTot.value = "0";
	    		document.fm1.medBedsTot.value = "0";
	    		document.fm1.entcapaNum.value = "";
			}
		} else {
			// 活性
			document.fm1.bedCntBase.style = "text-align:right;";
	    	document.fm1.bedCnt01.style = "text-align:right;";
	    	document.fm1.bedCnt02.style = "text-align:right;";
	    	document.fm1.bedCnt03.style = "text-align:right;";
	    	document.fm1.bedCnt04.style = "text-align:right;";
	    	document.fm1.bedCnt05.style = "text-align:right;";
	    	document.fm1.bedCnt06.style = "text-align:right;";
			document.fm1.bedCnt07.style = "text-align:right;";

			document.fm1.bedCntBase.className = "";
    		document.fm1.bedCnt01.className = "";
    		document.fm1.bedCnt02.className = "";
    		document.fm1.bedCnt03.className = "";
    		document.fm1.bedCnt04.className = "";
    		document.fm1.bedCnt05.className = "";
    		document.fm1.bedCnt06.className = "";
			document.fm1.bedCnt07.className = "";

			document.getElementById("bedCntHr").style.visibility = "visible";
			document.getElementById("formTable08").style.visibility = "visible";
			document.getElementById("bedCntTr01").style.visibility = "visible";

			document.getElementById("bedCntTd01").style.visibility = "visible";
			document.getElementById("bedCntTd02").style.visibility = "visible";
			document.getElementById("bedCntTd03").style.visibility = "visible";
			document.getElementById("bedCntTd04").style.visibility = "visible";

			document.getElementById("bedCntTr02").style.visibility = "visible";
			document.getElementById("bedCntTr03").style.visibility = "visible";
			document.getElementById("bedCntTr04").style.visibility = "visible";
			document.getElementById("bedCntTr05").style.visibility = "visible";

			document.getElementById("bedCntBaseAst").hidden = false;
			document.getElementById("bedCnt04Ast").hidden = false;
			document.getElementById("bedCnt01Ast").hidden = false;
			document.getElementById("bedCnt05Ast").hidden = false;
			document.getElementById("bedCnt03Ast").hidden = false;
			document.getElementById("bedCnt07Ast").hidden = false;
			document.getElementById("bedCnt02Ast").hidden = false;
			document.getElementById("bedCnt06Ast").hidden = false;

			document.fm1.bedCntBase.readOnly = false;
    		document.fm1.bedCnt01.readOnly = false;
    		document.fm1.bedCnt02.readOnly = false;
    		document.fm1.bedCnt03.readOnly = false;
    		document.fm1.bedCnt04.readOnly = false;
    		document.fm1.bedCnt05.readOnly = false;
    		document.fm1.bedCnt06.readOnly = false;
    		document.fm1.bedCnt07.readOnly = false;

			document.getElementById("entcapaNumTr").style.visibility = "collapse";

    		document.fm1.entcapaNum.value = "";
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
    	const insType = document.fm1.insType.value;
    	if(insType == "02" || insType == "04" || insType == "05" || insType == "07"){
    		document.getElementById("trtHr").style.visibility = "hidden";
    		document.getElementById("formTable10").style.visibility = "hidden";
    		trtTantoClear();
    	} else {
    		document.getElementById("trtHr").style.visibility = "visible";
    		document.getElementById("formTable10").style.visibility = "visible";
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
    	onLoadChangeBox();
    	mainInsView();
    	vacView();
    	trtView();
    	changeUrl();

    	// 編集不可設定
		onLoadEditSet();
    	// 対象区分表示
    	document.fm1.hoInsTypeView.value = document.fm1.hoInsType.options[document.fm1.hoInsType.selectedIndex].textContent;

    }

    // url編集時
    function changeUrl(){
  		if(document.getElementById("insUrl").value.length == 0){
			document.getElementById("urlButton").disabled = true;
  		} else {
  			document.getElementById("urlButton").disabled = false;
  		}
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

		document.fm1.viewKbn.value = "0";
		document.fm1.callBack.value = "callBackMainInsPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();

		document.fm1.insPcode.value = pCode;
		document.fm1.pharmType.value = pharmType;
    }

	// 施設ポップアップから親施設受け取り
    function callBackMainInsPop(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType, insClass){

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
		} else if(pCode.length >= 9){
			// ９文字以上の場合
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
		} else if((pCode.length != 7 && pCode.length != 8) ||
				(pCode.length == 8 && !comChkPostcode_IE(pCode))
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

	// 住所候補取得項目のクリア
	function clearAddr(){

		document.fm1.addrCodePrefName.value = "";
		document.fm1.addrCodePref.value = "";
		document.fm1.addrCodeCityName.value = "";
		document.fm1.addrCodeCity.value = "";
		document.fm1.insAddrDt.value = "";

		document.fm1.tkCityName.value = "";
		document.fm1.tkCityCd.value = "";

		document.fm1.addrCodePrefKana.value = "";
		document.fm1.addrCodeCityKana.value = "";
		document.fm1.addrDtKana.value = "";
	}

	// 担当者検索ボタン
    function trtPopBtn(){
		// NC202_担当者検索ポップアップ画面を表示
    	window.open("","tantoPopWindow",tantoSubScreenSize);
		document.fm1.screenId.value = "NC202";
		document.fm1.functionId.value="Init";
		document.fm1.target="tantoPopWindow";

		document.fm1.trtCdPop.value = document.fm1.trtCd.value;
		document.fm1.addrCodePrefPop.value = document.fm1.addrCodePref.value;
		document.fm1.tkCityCdPop.value = document.fm1.tkCityCd.value;

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
		let trtNmInp = document.createElement("input");
		let jgiNmInp = document.createElement("input");
		let trtGrpInp = document.createElement("input");
		let mrCatInp = document.createElement("input");
		let delFlgInp = document.createElement("input");

		trtCdInp.setAttribute("type", "hidden");
		jgiNoInp.setAttribute("type", "hidden");
		trtNmInp.setAttribute("type", "hidden");
		jgiNmInp.setAttribute("type", "hidden");
		trtGrpInp.setAttribute("type", "hidden");
		mrCatInp.setAttribute("type", "hidden");
		delFlgInp.setAttribute("type", "hidden");

		trtCdInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].trtCd");
		jgiNoInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].jgiNo");
		trtNmInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].trtNm");
		jgiNmInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].jgiNm");
		trtGrpInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].trtGrpCd");
		mrCatInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].mrCat");
		delFlgInp.setAttribute("name", "hcoJkrDataList["+trtRow+"].deleteFlg");

		trtCdInp.setAttribute("value", trtCd);
		jgiNoInp.setAttribute("value", jgiNo);
		trtNmInp.setAttribute("value", trtNm);
		jgiNmInp.setAttribute("value", jgiNm);
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
		tr.appendChild(trtNmInp);
		tr.appendChild(jgiNmInp);
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

	// 担当者行の全削除処理
	function trtTantoClear(){
		var i = 0;
		var trtTable = document.getElementById("formTable11");
		var trtTr = trtTable.rows[i+1];

		while(trtTr != undefined){
			trtTr.style.visibility = "collapse";

			var key = "hcoJkrDataList["+i+"].deleteFlg";
			var delFlg = document.getElementsByName(key)[0];

			delFlg.value = "1";

			i++;
			trtTr = trtTable.rows[i+1];
		}

		return false;
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
		} else {
			// 申請、承認・却下
			document.fm1.screenId.value="NF301";
			document.fm1.functionId.value="Init";

			if(document.fm1.insType != undefined && document.fm1.insType.value != ""){
				document.fm1.insTypeNm.value = document.fm1.insType.options[document.fm1.insType.selectedIndex].textContent;
			}
			if(document.fm1.tradeType != undefined && document.fm1.tradeType.value != ""){
				document.fm1.tradeTypeNm.value = document.fm1.tradeType.options[document.fm1.tradeType.selectedIndex].textContent;
			}
			if(document.fm1.pharmType != undefined && document.fm1.pharmType.value != ""){
				document.fm1.pharmTypeNm.value = document.fm1.pharmType.options[document.fm1.pharmType.selectedIndex].textContent;
			}
			if(document.fm1.insRank != undefined && document.fm1.insRank.value != ""){
				document.fm1.insRankNm.value = document.fm1.insRank.options[document.fm1.insRank.selectedIndex].textContent;
			}
			if(document.fm1.regVisType != undefined && document.fm1.regVisType.value != ""){
				document.fm1.regVisTypeNm.value = document.fm1.regVisType.options[document.fm1.regVisType.selectedIndex].textContent;
			}
			if(document.fm1.impHosType != undefined && document.fm1.impHosType.value != ""){
				document.fm1.impHosTypeNm.value = document.fm1.impHosType.options[document.fm1.impHosType.selectedIndex].textContent;
			}
			if(document.fm1.univSubdiv != undefined && document.fm1.univSubdiv.value != ""){
				document.fm1.univSubdivNm.value = document.fm1.univSubdiv.options[document.fm1.univSubdiv.selectedIndex].textContent;
			}
			if(document.fm1.hoInsType != undefined && document.fm1.hoInsType.value != ""){
				document.fm1.hoInsTypeNm.value = document.fm1.hoInsType.options[document.fm1.hoInsType.selectedIndex].textContent;
			}
			if(document.fm1.manageCd != undefined && document.fm1.manageCd.value != ""){
				document.fm1.manageNm.value = document.fm1.manageCd.options[document.fm1.manageCd.selectedIndex].textContent;
			}
			if(document.fm1.vacInsType != undefined && document.fm1.vacInsType.value != ""){
				document.fm1.vacInsTypeNm.value = document.fm1.vacInsType.options[document.fm1.vacInsType.selectedIndex].textContent;
			}
			if(document.fm1.vacVisitType != undefined && document.fm1.vacVisitType.value != ""){
				document.fm1.vacVisitTypeNm.value = document.fm1.vacVisitType.options[document.fm1.vacVisitType.selectedIndex].textContent;
			}
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
     <s:hidden name="loginShzNm"/>
     <s:hidden name="loginTrtCd"/>
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

	<s:hidden name="insTypeNm"/>
	<s:hidden name="tradeTypeNm"/>
	<s:hidden name="pharmTypeNm"/>
	<s:hidden name="insRankNm"/>
	<s:hidden name="regVisTypeNm"/>
	<s:hidden name="impHosTypeNm"/>
	<s:hidden name="univSubdivNm"/>
	<s:hidden name="hoInsTypeNm"/>
	<s:hidden name="manageNm"/>
	<s:hidden name="vacInsTypeNm"/>
	<s:hidden name="vacVisitTypeNm"/>

	<s:hidden name="addrCodePrefPop"/>
	<s:hidden name="tkCityCdPop"/>
	<s:hidden name="winVarName" value="NF011" />
	<s:hidden name="viewKbn" />

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

   	<table width="100%">
   		<tr>
             <td align="center">
               <jsp:include page="common/rdmMsg.jsp">
               <jsp:param name="" value="" />
               </jsp:include>
             </td>
         </tr>
      </table>

  <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--申請情報--%>
        <%--申請情報のHIDDEN項目--%>
        <s:hidden name="reqId"/>
        <s:hidden name="reqChl"/>
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
		<s:if test='%{loginJgiNo != reqJgiNo }'>
	      <tr>
		      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		      <td class="comFormTableItem"><nobr>審査者氏名</nobr></td>
		      <td class="comFormTableItem"><nobr><s:label key="shnShaName"/></nobr></td>
		      <td class="comFormTableItem"><nobr>審査日時</nobr></td>
		      <td class="comFormTableItem"><nobr><s:label key="shnYmdhms"/></nobr></td>
		  </tr>
	  </s:if>
	  <!-- 申請ステータス＝保存済み、承認待ち、ULT申請待ち、ULT承認待ち　の際は非表示 -->
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>承認者氏名</nobr></td>
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
	      		<s:select id="insType" name="insType" cssStyle="width:120pt" list ="insTypeCombo" onchange='changeBox("1"); mainInsView(); vacView(); trtView();'/>
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
                <s:textfield name="mainInsNm" id="mainInsNm" size="20" maxlength="150" cssClass="mediumGray" readonly="true" />
                <s:hidden name="mainInsCd" id="mainInsCd"/>
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
			      	<s:textfield name="insAbbrName" size="30" maxlength="10" />
				</s:if>
				<s:else>
					<s:textfield name="insAbbrName" size="30" maxlength="10" readonly="true" />
				</s:else>
			</nobr>
		  </td>
	      <td class="comFormTableItem"><nobr>施設カナ名(半角カナ)<font color="red" size="3">*</font></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:if test='%{editApprFlg == "1"}'>
				<s:textfield name="insKana" size="30" maxlength="15" />
			</s:if>
			<s:else>
				<s:textfield name="insKana" size="30" maxlength="15" readonly="true" />
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
		      	<s:textfield name="insFormalName" size="60" maxlength="40" />
		      </s:if>
		      <s:else>
		      	<s:textfield name="insFormalName" size="60" maxlength="40" readonly="true" />
		      </s:else>
		     </nobr>
		   </td>
      </tr>
<!--       <tr>
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
 -->
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
		    		<s:textfield name="insPcode" size="15" maxlength="8" onChange="JavaScript:clearAddr();return false;" />
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
	    		<s:textfield name="addrCodePrefName" size="15" maxlength="15" cssClass="mediumGray" readonly="true" />
	    		<s:hidden name="addrCodePref" id="addrCodePref"/>
	    	</nobr>
	    </td>
	    <td class="comFormTableItem"><nobr>JIS市区町村<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
	    		<s:textfield name="addrCodeCityName" size="15" cssClass="mediumGray" readonly="true" />
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
	    <td class="comFormTableItem"><nobr>武田市区郡<font color="red" size="3">*</font></nobr></td>
	    <td class="comFormTableItem">
	    	<nobr>
	    		<s:textfield name="tkCityName" size="15" cssClass="mediumGray" readonly="true" />
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
		    		<s:textarea id="insUrl" name="insUrl" maxlength="150" style="resize:none" onchange="changeUrl();" />
		    	</s:if>
		    	<s:else>
		    		<s:textarea id="insUrl" name="insUrl" maxlength="150" readonly="true" style="resize:none" />
		    	</s:else>
	    		<input class="comButton" type="button" id="urlButton" name="button2" value="表示" onClick="JavaScript:window.open(document.fm1.insUrl.value, '_blank');return false;" />
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
	      <td class="comFormTableItem"><nobr>施設区分<label id="pharmTypeAst"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="pharmType" name="pharmType" cssStyle="width:120pt" list ="pharmTypeCombo" onchange='changeBox("2")'/>
	      	<s:textfield id="pharmTypeView" name="pharmTypeView" cssStyle="width:120pt" readonly="true" />
	      	</nobr>
	      </td>
	      <td class="comFormTableItem"><nobr>階級区分<label id="insRankAst"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="insRank" name="insRank" cssStyle="width:120pt" list ="insRankCombo" onchange='changeBox("3");'/>
	      	<s:textfield id="insRankView" name="insRankView" cssStyle="width:120pt" readonly="true" />
	      	</nobr>
	      </td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>定訪先区分<label id="regVisTypeAst"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="regVisType" name="regVisType" cssStyle="width:120pt" list ="regVisTypeCombo"/>
	      	<s:textfield id="regVisTypeView" name="regVisTypeView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>重点病院区分<label id="impHosTypeAst"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="impHosType" name="impHosType" cssStyle="width:120pt" list ="impHosTypeCombo"/>
	      	<s:textfield id="impHosTypeView" name="impHosTypeView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem" id="univSubdivTd01"><nobr>大学細分類</nobr></td>
	      <td class="comFormTableItem" id="univSubdivTd02"><nobr>
	      	<s:select id="univSubdiv" name="univSubdiv" cssStyle="width:120pt" list ="univSubdivCombo"/>
	      	<s:textfield id="univSubdivView" name="univSubdivView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>対象区分</nobr></td>
	      <td class="comFormTableItem">
	      	<nobr>
	      		<s:select id="hoInsType" name="hoInsType" cssStyle="width:120pt;" cssClass="mediumGray" list ="hoInsTypeCombo" hidden="true" />
	      		<s:textfield id="hoInsTypeView" name="hoInsTypeView" cssStyle="width:120pt;" cssClass="mediumGray" readonly="true" />
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
	      <td class="comFormTableItem"><nobr>経営主体<label id="manageCdAst"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="manageCd" name="manageCd" cssStyle="width:120pt" list ="manageCdCombo"/>
	      	<s:textfield id="manageCdView" name="manageCdView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
          <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
          <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  　</table>
  <hr class="comTitle" id="bedCntHr" style="margin-top:2px;width:75%"/><br/>
    <table id="formTable08" border="0" class="comPortalTable" align="center" style="width:75%;">
      <tr>
        <%--病床数情報--%>
        <td style="width: 50px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
        <td style="width: 70px; height: 0px; border-width: 0px;"></td>
        <td style="width: 220px; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr id="bedCntTr01">
	      <td class="comFormTableItem"><nobr>病床数情報</nobr></td>
	      <td class="comFormTableItem" id="bedCntTd01"><nobr>基準<label id="bedCntBaseAst"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem" id="bedCntTd02"><nobr><s:textfield name="bedCntBase" size="4" maxlength="4" style="text-align:right;" /></nobr></td>
	      <td class="comFormTableItem" id="bedCntTd03"><nobr>結核<label id="bedCnt04Ast"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem" id="bedCntTd04"><nobr><s:textfield name="bedCnt04" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></nobr></td>
      </tr>
      <tr id="bedCntTr02">
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>一般<label id="bedCnt01Ast"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt01" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></nobr></td>
	      <td class="comFormTableItem"><nobr>感染症<label id="bedCnt05Ast"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt05" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></nobr></td>
      </tr>
      <tr id="bedCntTr03">
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>精神<label id="bedCnt03Ast"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt03" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></nobr></td>
	      <td class="comFormTableItem"><nobr>療養<label id="bedCnt07Ast"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt07" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></nobr></td>
      </tr>
      <tr id="bedCntTr04">
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>医療療養<label id="bedCnt02Ast"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt02" size="4" maxlength="4" style="text-align:right;" onchange='javascript:calcBedCnt();' /></nobr></td>
	      <td class="comFormTableItem"><nobr>介護療養<label id="bedCnt06Ast"><font color="red" size="3">*</font></label></nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedCnt06" size="4" maxlength="4" style="text-align:right;" /></nobr></td>
      </tr>
      <tr id="bedCntTr05">
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>ベッド数計</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="bedsTot" size="4" maxlength="4" cssClass="mediumGray" style="text-align:right;" readonly="true" /></nobr></td>
	      <td class="comFormTableItem"><nobr>医療ベッド数計</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="medBedsTot" size="4" maxlength="4" cssClass="mediumGray" style="text-align:right;" readonly="true" /></nobr></td>
      </tr>
      <tr id="entcapaNumTr">
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>入所定員情報</nobr></td>
	      <td class="comFormTableItem"><nobr><s:textfield name="entcapaNum" size="4" maxlength="4" style="text-align:right;" /></nobr></td>
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
	      	<s:select id="vacInsType" name="vacInsType" cssStyle="width:120pt" list ="vacInsTypeCombo"/>
	      	<s:textfield id="vacInsTypeView" name="vacInsTypeView" cssStyle="width:120pt" readonly="true" />
	      </nobr></td>
	      <td class="comFormTableItem"><nobr>ワクチン定訪先区分</nobr></td>
	      <td class="comFormTableItem"><nobr>
	      	<s:select id="vacVisitType" name="vacVisitType" cssStyle="width:120pt" list ="vacVisitTypeCombo"/>
	      	<s:textfield id="vacVisitTypeView" name="vacVisitTypeView" cssStyle="width:120pt" readonly="true" />
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
		    		<input class="comButton" type="button" id="trtButton" name="button2" value="担当者検索" onClick="JavaScript:trtPopBtn();return false;" />
	    		</s:if>
	    		<s:else>
	    			<input class="comButton" type="button"　id="trtButton" name="button2" value="担当者検索" onClick="JavaScript:trtPopBtn();return false;" disabled />
	    		</s:else>
    		</nobr>
   		　　</td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem" colSpan="3"><%-- スクロールバー用のテーブルクラスにすること --%>
              <div id="jkrHeader" style="margin:0;width:800px;overflow-y:hidden;overflow-x:auto;position:relative;">
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
			        <s:hidden name="hcoJkrDataList[%{#status.index}].trtNm"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].jgiNo"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].jgiNm"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].trtGrpCd"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].mrCat"/>
			        <s:hidden name="hcoJkrDataList[%{#status.index}].deleteFlg"/>

			        <td><%-- アクションボタン --%>
			        <s:if test='%{editApprFlg=="1" && (reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "03" || reqStsCd == "13")}'>
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
        <s:if test='%{reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11"}'>
	      <td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/></nobr></td>
		</s:if>
		<s:else>
			<td class="comFormTableItem"><nobr><s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" readonly="true"/></nobr></td>
		</s:else>
      </tr>
      <s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
      <tr>
	      <td class="comFormTableItem"><nobr>審査・承認メモ</nobr></td>
      </tr>
      <tr>
      	<s:if test='%{reqStsCd == "03" || reqStsCd == "13"}'>
	      <td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/></nobr></td>
      	</s:if>
      	<s:else>
      		<td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" readonly="true"/></nobr></td>
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
				<s:if test='%{(loginJgiNo == reqJgiNo && (reqStsCd == "01" || reqStsCd == "11")) || (loginJokenSetCd == "JKN0850" && (reqStsCd == "11" || reqStsCd == "13"))}'>
	                <input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;" />
				</s:if>
				<s:else>
					&nbsp;
				</s:else>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
					<s:if test='%{loginJgiNo == reqJgiNo && (reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11")}'>
		            	<input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" />
		            </s:if>
		            <s:elseif test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
						<input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" />
		            </s:elseif>
		            <s:elseif test='%{loginJgiNo == reqJgiNo}'>
		                <input class="comButton" type="button"name="buttonF3" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" disabled/>
		           	</s:elseif>
                </nobr>
	      </td>
	      <td class="comFormTableItem">
                <nobr>
				<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && loginJokenSetCd == "JKN0850"}'>
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
				<s:if test='%{(reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11")}'>
		                <input class="comButton" type="button"name="buttonF3" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;"/>
				</s:if>
				<s:elseif test='%{(reqStsCd == "03" || reqStsCd == "13")}'>
					<s:if test='%{(loginJokenSetCd == "JKN0850")}'>
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
