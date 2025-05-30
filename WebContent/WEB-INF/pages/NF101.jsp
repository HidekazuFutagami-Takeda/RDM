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
    	onLoadChangeBox();
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
		if(document.fm1.insType.value == "01" || document.fm1.insType.value == "02"){
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
				document.fm1.nextBedsTot.style = "text-align:right;"
				document.fm1.nextBedsTot.className = "mediumGray";
			}
			if(document.fm1.medBedsTotFlg.value == "1"){
				document.fm1.nextMedBedsTot.className = "comTableInputYellow";
			} else {
				document.fm1.nextMedBedsTot.style = "text-align:right;"
				document.fm1.nextMedBedsTot.className = "mediumGray";
			}
		}
    }

	// 初期表示時のセレクトボックスの設定
    function onLoadChangeBox(){
   		var insType = document.fm1.insType.value;
   		var pharmType = document.fm1.pharmType.value;
   		var insRank = document.fm1.insRank.value;
   		var tmpPharmType = document.fm1.tmpPharmType.value;
   		var tmpInsRank = document.fm1.tmpInsRank.value;
   		var tmpRegVisType = document.fm1.tmpRegVisType.value;
   		var tmpImpHosType = document.fm1.tmpImpHosType.value;
   		var tmpManageCd = document.fm1.tmpManageCd.value;

   		var pharmTypeBox = document.fm1.nextPharmType;
   		var insRankBox = document.fm1.nextInsRank;
   		var regVisTypeBox = document.fm1.nextRegVisType;
   		var impHosTypeBox = document.fm1.nextImpHosType;
   		var manageCdBox = document.fm1.nextManageCd;

 		pharmTypeBox = makePharmTypeBox(pharmTypeBox,insType);
 		insRankBox = makeInsRankBox(insRankBox, insType, tmpPharmType);
 		regVisTypeBox = makeRegVisTypeBox(regVisTypeBox,insType, tmpPharmType, tmpInsRank);
 		impHosTypeBox = makeImpHosTypeBox(impHosTypeBox,insType, tmpPharmType, tmpInsRank);
 		manageCdBox = makeManageCdBox(manageCdBox, tmpInsRank);

 		if(insType == "04" || insType == "05" || insType == "07"){
 			document.getElementById("nextPharmType").disabled = true;
   			document.getElementById("nextInsRank").disabled = true;
   			document.getElementById("nextRegVisType").disabled = true;
   			document.getElementById("nextImpHosType").disabled = true;
   			document.getElementById("nextManageCd").disabled = true;
   			tmpPharmType = "";
   			tmpInsRank = "";
   			tmpRegVisType = "";
   			tmpImpHosType = "";
   			tmpManageCd = "";
 		} else {
			if(tmpPharmType != ""){
				if(tmpInsRank == ""){
					document.getElementById("nextRegVisType").disabled = true;
	   		   		document.getElementById("nextImpHosType").disabled = true;
	   		   		document.getElementById("nextManageCd").disabled = true;
		   			tmpRegVisType = "";
		   			tmpImpHosType = "";
		   			tmpManageCd = "";
				}
			} else {
				document.getElementById("nextInsRank").disabled = true;
				document.getElementById("nextRegVisType").disabled = true;
   		   		document.getElementById("nextImpHosType").disabled = true;
   		   		document.getElementById("nextManageCd").disabled = true;
	   			tmpInsRank = "";
	   			tmpRegVisType = "";
	   			tmpImpHosType = "";
	   			tmpManageCd = "";
			}
 		}

  		document.fm1.nextPharmType.value = tmpPharmType;
  		document.fm1.nextInsRank.value = tmpInsRank;
  		document.fm1.nextRegVisType.value = tmpRegVisType;
  		document.fm1.nextImpHosType.value = tmpImpHosType;
  		document.fm1.nextManageCd.value = tmpManageCd;

  		if(document.fm1.nextPharmType.selectedIndex == -1){
  			document.fm1.nextPharmType.value = "";
  		}
  		if(document.fm1.nextInsRank.selectedIndex == -1){
  			document.fm1.nextInsRank.value = "";
  		}
  		if(document.fm1.nextRegVisType.selectedIndex == -1){
  			document.fm1.nextRegVisType.value = "";
  		}
  		if(document.fm1.nextImpHosType.selectedIndex == -1){
  			document.fm1.nextImpHosType.value = "";
  		}
  		if(document.fm1.nextManageCd.selectedIndex == -1){
  			document.fm1.nextManageCd.value = "";
  		}

  		setHoInsType();
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
		if(insType == "01"){
	    	box.options[1].hidden = false;
	    	box.options[2].hidden = false;
	    	box.options[3].hidden = false;
	    	box.options[4].hidden = false;
	    	box.options[5].hidden = false;
	    	box.options[6].hidden = true;
	    	box.options[7].hidden = true;
	    	box.options[8].hidden = true;
	    	box.options[9].hidden = true;

		} else if(insType == "02"){
	    	box.options[1].hidden = true;
	    	box.options[2].hidden = false;
	    	box.options[3].hidden = false;
	    	box.options[4].hidden = false;
	    	box.options[5].hidden = true;
	    	box.options[6].hidden = true;
	    	box.options[7].hidden = true;
	    	box.options[8].hidden = true;
	    	box.options[9].hidden = true;

		} else if(insType == "03"){
			box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = true;
	    	box.options[4].hidden = true;
	    	box.options[5].hidden = true;
	    	box.options[6].hidden = false;
	    	box.options[7].hidden = true;
	    	box.options[8].hidden = true;
	    	box.options[9].hidden = true;

		} else if(insType == "06"){
	    	box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = false;
	    	box.options[4].hidden = false;
	    	box.options[5].hidden = true;
	    	box.options[6].hidden = true;
	    	box.options[7].hidden = true;
	    	box.options[8].hidden = true;
	    	box.options[9].hidden = true;

		} else if(insType == "08"){
			box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = true;
	    	box.options[4].hidden = true;
	    	box.options[5].hidden = true;
	    	box.options[6].hidden = true;
	    	box.options[7].hidden = false;
	    	box.options[8].hidden = true;
	    	box.options[9].hidden = true;

		} else if(insType == "09"){
	    	box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = true;
	    	box.options[4].hidden = true;
	    	box.options[5].hidden = true;
	    	box.options[6].hidden = true;
	    	box.options[7].hidden = true;
	    	box.options[8].hidden = false;
	    	box.options[9].hidden = false;

		} else if(insType == "10"){
			box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = true;
	    	box.options[4].hidden = false;
	    	box.options[5].hidden = true;
	    	box.options[6].hidden = true;
	    	box.options[7].hidden = true;
	    	box.options[8].hidden = true;
	    	box.options[9].hidden = true;
		}

		box.value = "";
    	return box;
    }

    // 階級区分セレクトボックス設定
    function makeInsRankBox(box, insType, pharmType){
    	if(insType == "01" && pharmType == "01"){
	    	box.options[1].hidden = false;
	    	box.options[2].hidden = false;
	    	box.options[3].hidden = false;
	    	box.options[4].hidden = false;
	    	box.options[5].hidden = false;
	    	box.options[6].hidden = false;
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

    	} else if(insType == "01" && pharmType == "02"){
	    	box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = true;
	    	box.options[4].hidden = true;
	    	box.options[5].hidden = true;
	    	box.options[6].hidden = true;
	    	box.options[7].hidden = false;
	    	box.options[8].hidden = false;
	    	box.options[9].hidden = false;
	    	box.options[10].hidden = false;
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

    	} else if(insType == "01" && pharmType == "03"){
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
	    	box.options[11].hidden = false;
	    	box.options[12].hidden = false;
	    	box.options[13].hidden = true;
	    	box.options[14].hidden = true;
	    	box.options[15].hidden = true;
	    	box.options[16].hidden = true;
	    	box.options[17].hidden = true;
	    	box.options[18].hidden = true;
	    	box.options[19].hidden = true;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "01" && pharmType == "04"){
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
	    	box.options[13].hidden = false;
	    	box.options[14].hidden = false;
	    	box.options[15].hidden = false;
	    	box.options[16].hidden = true;
	    	box.options[17].hidden = true;
	    	box.options[18].hidden = true;
	    	box.options[19].hidden = true;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "01" && pharmType == "05"){
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
	    	box.options[16].hidden = false;
	    	box.options[17].hidden = true;
	    	box.options[18].hidden = true;
	    	box.options[19].hidden = true;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "02" && pharmType == "02"){
	    	box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = true;
	    	box.options[4].hidden = true;
	    	box.options[5].hidden = true;
	    	box.options[6].hidden = true;
	    	box.options[7].hidden = true;
	    	box.options[8].hidden = true;
	    	box.options[9].hidden = false;
	    	box.options[10].hidden = false;
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

    	} else if(insType == "02" && pharmType == "03"){
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
	    	box.options[11].hidden = false;
	    	box.options[12].hidden = false;
	    	box.options[13].hidden = true;
	    	box.options[14].hidden = true;
	    	box.options[15].hidden = true;
	    	box.options[16].hidden = true;
	    	box.options[17].hidden = true;
	    	box.options[18].hidden = true;
	    	box.options[19].hidden = true;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "02" && pharmType == "04"){
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
	    	box.options[13].hidden = false;
	    	box.options[14].hidden = false;
	    	box.options[15].hidden = false;
	    	box.options[16].hidden = true;
	    	box.options[17].hidden = true;
	    	box.options[18].hidden = true;
	    	box.options[19].hidden = true;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "03" && pharmType == "06"){
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
	    	box.options[17].hidden = false;
	    	box.options[18].hidden = true;
	    	box.options[19].hidden = true;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "06" && pharmType == "03"){
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
	    	box.options[11].hidden = false;
	    	box.options[12].hidden = false;
	    	box.options[13].hidden = true;
	    	box.options[14].hidden = true;
	    	box.options[15].hidden = true;
	    	box.options[16].hidden = true;
	    	box.options[17].hidden = true;
	    	box.options[18].hidden = true;
	    	box.options[19].hidden = true;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "06" && pharmType == "04"){
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
	    	box.options[13].hidden = false;
	    	box.options[14].hidden = false;
	    	box.options[15].hidden = false;
	    	box.options[16].hidden = true;
	    	box.options[17].hidden = true;
	    	box.options[18].hidden = true;
	    	box.options[19].hidden = true;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "08" && pharmType == "07"){
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
	    	box.options[21].hidden = false;

    	} else if(insType == "09" && pharmType == "08"){
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
	    	box.options[18].hidden = false;
	    	box.options[19].hidden = false;
	    	box.options[20].hidden = true;
	    	box.options[21].hidden = true;

    	} else if(insType == "09" && pharmType == "09"){
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
	    	box.options[21].hidden = false;

    	} else if(insType == "10" && pharmType == "04"){
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
	    	box.options[20].hidden = false;
	    	box.options[21].hidden = true;
    	}

    	box.value = "";
    	return box;
    }

    // 定訪先区分セレクトボックス設定
    function makeRegVisTypeBox(box, insType, pharmType, insRank){
    	if((insType == "01" && pharmType == "01" && (insRank == "01" || insRank == "02" || insRank == "03"
			|| insRank == "04" || insRank == "05" || insRank == "06"))
			|| (insType == "01" && pharmType == "02" && (insRank == "07" || insRank == "08"))){
	    	box.options[1].hidden = false;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = true;
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
	    	box.options[1].hidden = false;
	    	box.options[2].hidden = false;
	    	box.options[3].hidden = true;
		} else if((insType == "08" && pharmType == "07" && insRank == "00")
				|| (insType == "09" && pharmType == "08" && insRank == "18")
				|| (insType == "09" && pharmType == "08" && insRank == "19")
				|| (insType == "09" && pharmType == "09" && insRank == "00")){
			box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = false;
		} else if(insType == "10" && pharmType == "04" && insRank == "20"){
			box.options[1].hidden = false;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = true;
		}

		box.value = "";
		return box;
    }

    //  重点病院区分セレクトボックス設定
    function makeImpHosTypeBox(box, insType, pharmType, insRank){
    	if(insType == "01" && pharmType == "01" && (insRank == "01" || insRank == "02")){
	    	box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = false;
    	} else if((insType == "01" && pharmType == "01" && (insRank == "03" || insRank == "04" || insRank == "05" || insRank == "06"))
    			|| (insType == "01" && pharmType == "02" && (insRank == "07" || insRank == "08"))){
	    	box.options[1].hidden = false;
	    	box.options[2].hidden = false;
	    	box.options[3].hidden = true;
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
    		box.options[1].hidden = true;
	    	box.options[2].hidden = true;
	    	box.options[3].hidden = false;
    	}

    	box.value = "";
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
    	// 施設区分を変更
    	if(changeItem == "1"){
			if(document.fm1.nextPharmType.value == ""){
	    		document.getElementById("nextInsRank").disabled = true;
			} else {
				document.getElementById("nextInsRank").disabled = false;
			}
   			document.getElementById("nextRegVisType").disabled = true;
   			document.getElementById("nextImpHosType").disabled = true;
   			document.getElementById("nextManageCd").disabled = true;

        	var insRankBox = document.fm1.nextInsRank;
        	insRankBox = makeInsRankBox(insRankBox,document.fm1.insType.value, document.fm1.nextPharmType.value);
        	insRankBox.value = "";
        	var regVisBox = document.fm1.nextRegVisType;
        	regVisBox = makeRegVisTypeBox(regVisBox,document.fm1.insType.value, document.fm1.nextPharmType.value, document.fm1.nextInsRank.value);
        	regVisBox.value = "";
        	var impHosBox = document.fm1.nextImpHosType;
        	impHosBox = makeImpHosTypeBox(impHosBox,document.fm1.insType.value, document.fm1.nextPharmType.value, document.fm1.nextInsRank.value);
        	impHosBox.value = "";
        	var manageBox = document.fm1.nextManageCd;
        	manageBox = makeManageCdBox(manageBox,document.fm1.nextInsRank.value);
        	manageBox.value = "";
    	} else if(changeItem == "2"){
			// 階級区分を変更
			if(document.fm1.nextInsRank.value == ""){
	   			document.getElementById("nextRegVisType").disabled = true;
	   			document.getElementById("nextImpHosType").disabled = true;
	   			document.getElementById("nextManageCd").disabled = true;
			} else {
				document.getElementById("nextRegVisType").disabled = false;
	   			document.getElementById("nextImpHosType").disabled = false;
	   			document.getElementById("nextManageCd").disabled = false;
			}

        	var regVisBox = document.fm1.nextRegVisType;
        	regVisBox = makeRegVisTypeBox(regVisBox,document.fm1.insType.value, document.fm1.nextPharmType.value, document.fm1.nextInsRank.value);
        	regVisBox.value = "";
        	var impHosBox = document.fm1.nextImpHosType;
        	impHosBox = makeImpHosTypeBox(impHosBox,document.fm1.insType.value, document.fm1.nextPharmType.value, document.fm1.nextInsRank.value);
        	impHosBox.value = "";
        	var manageBox = document.fm1.nextManageCd;
        	manageBox = makeManageCdBox(manageBox,document.fm1.nextInsRank.value);
        	manageBox.value = "";
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
		} else {
			window.close();
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
	   	<td class="comFormTableItemNf012"><s:label key="pharmTypeNm" /><s:hidden name="pharmType" /><s:hidden name="pharmTypeNm" /></td>
	   	<td class="comFormTableItemNf012"><s:label key="shisetsuKbn" /><s:hidden name="shisetsuKbn" /></td>
	   	<td class="comFormTableItemNf012"><s:select id="nextPharmType" name="nextPharmType" cssStyle="width:120pt" list ="pharmTypeCombo" onchange="changeBox('1')" />
	   	<s:textfield id="pharmTypeView" name="pharmTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr>
		<td class="comFormTableItem">階級区分</td>
		<td class="comFormTableItemNf012"><s:label key="insRankNm" /><s:hidden name="insRank" /><s:hidden name="insRankNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextInsRank" name="nextInsRank" cssStyle="width:120pt" list ="insRankCombo" onchange="changeBox('2'); setHoInsType();" />
	   	<s:textfield id="insRankView" name="insRankView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr>
		<td class="comFormTableItem">定訪先区分</td>
		<td class="comFormTableItemNf012"><s:label key="regVisTypeNm" /><s:hidden name="regVisType" /><s:hidden name="regVisTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextRegVisType" name="nextRegVisType" cssStyle="width:120pt" list ="regVisTypeCombo"/>
	   	<s:textfield id="regVisTypeView" name="regVisTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr>
		<td class="comFormTableItem">重点病院区分</td>
		<td class="comFormTableItemNf012"><s:label key="impHosTypeNm" /><s:hidden name="impHosType" /><s:hidden name="impHosTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextImpHosType" name="nextImpHosType" cssStyle="width:120pt" list ="impHosTypeCombo"/>
	   	<s:textfield id="impHosTypeView" name="impHosTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr>
		<td class="comFormTableItem">対象区分</td>
		<td class="comFormTableItemNf012"><s:label key="hoInsTypeNm" /><s:hidden name="hoInsType" /><s:hidden name="hoInsTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012">
	   		<s:select id="nextHoInsType" name="nextHoInsType" cssStyle="width:120pt" list ="hoInsTypeCombo"  hidden="true"/>
	   		<s:textfield id="nextHoInsTypeView" name="nextHoInsTypeView" cssStyle="width:120pt;" cssClass="mediumGray" readonly="true" />
	   	</td>
	</tr>
	<tr>
		<td class="comFormTableItem">経営主体</td>
		<td class="comFormTableItemNf012"><s:label key="manageNm" /><s:hidden name="manageCd" /><s:hidden name="manageNm" /></td>
	   	<td class="comFormTableItemNf012"><s:label key="keieitaiNm" /><s:hidden name="keieitaiNm" /></td>
	   	<td class="comFormTableItemNf012"><s:select id="nextManageCd" name="nextManageCd" cssStyle="width:120pt" list ="manageCdCombo"/>
	   	<s:textfield id="manageCdView" name="manageCdView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr <s:if test="insType != '08'">style="visibility:collapse"</s:if>>
		<td class="comFormTableItem">ワクチン対象区分</td>
		<td class="comFormTableItemNf012"><s:label key="vacInsTypeNm" /><s:hidden name="vacInsType" /><s:hidden name="vacInsTypeNm" /></td>
	   	<td class="comFormTableItemNf012">&nbsp;</td>
	   	<td class="comFormTableItemNf012"><s:select id="nextVacInsType" name="nextVacInsType" cssStyle="width:120pt" list ="vacInsTypeCombo"/>
	   	<s:textfield id="vacInsTypeView" name="vacInsTypeView" cssStyle="width:120pt" readonly="true" /></td>
	</tr>
	<tr <s:if test="insType != '08'">style="visibility:collapse"</s:if>>
		<td class="comFormTableItem">ワクチン定訪先区分</td>
		<td class="comFormTableItemNf012"><s:label key="vacVisitTypeNm" /><s:hidden name="vacVisitType" /><s:hidden name="vacVisitTypeNm" /></td>
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
	      	<s:if test='%{editApprFlg == "1" && (reqStsCd == null || reqStsCd == "" || reqStsCd == "01" || reqStsCd == "11")}'>
		      	<s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/>
		  	</s:if>
		  	<s:else>
		  		<s:textarea name="reqComment"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" readonly="true"/>
		  	</s:else>
		  </nobr></td>
		  <td class="comFormTableItem">
		  	<input class="comButton" type="button" name="button" value="申請歴" onClick="histBtn(); JavaScript:return false;" />
		  </td>
      </tr>
      <s:if test='%{loginJokenSetCd == "JKN0850"}'>
      <tr>
	      <td class="comFormTableItem"><nobr>審査・承認メモ</nobr></td>
      </tr>
      <tr>
      	<s:if test='%{(reqStsCd == "03" || reqStsCd == "13") && editApprFlg == "1"}'>
	      <td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;"/></nobr></td>
      	</s:if>
      	<s:else>
      		<td class="comFormTableItem"><nobr><s:textarea name="aprMemo"  cols="50" rows="3" maxlength="100" style="width: 650px; height: 80px;" cssClass="mediumGray" readonly="true"/></nobr></td>
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
				<s:if test='%{(loginJgiNo == reqJgiNo && (reqStsCd == "01" || reqStsCd == "11")) || (loginJokenSetCd == "JKN0850" && (reqStsCd == "11" || reqStsCd == "13"))}'>
	                <input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;" />
				</s:if>
				<s:else>
					<input class="comButton" type="button"name="buttonF2" value="申請破棄" onClick="JavaScript:reqCancelBtn();return false;" disabled />
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
