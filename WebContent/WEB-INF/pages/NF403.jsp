<%--
/**
 * <pre>
 *  施設来期項目一括申請のJSP
 * </pre>
 * @since 1.0
 * @version $Revision:
 * @author
 * @see jp.co.takeda.maps.command.jgikanren.jkrinsmrchange.JkrInsMrChangeViewFrontCommand
 */
 --%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="java.util.Enumeration"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="jp.co.takeda.rdm.util.AppMethods"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>


<%@ page
  language="java"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"
%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>NF403_施設来期項目一括申請</title>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <link href="css/common2.css" rel="Stylesheet" type="text/css" />
    <link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>

    <script type="text/javascript" src="js/jkrSosStatus.js"></script>
    <script type="text/javascript" src="js/catTkCityCombo.js"></script>
    <script type="text/javascript" src="js/imtInsInputCategores.js"></script>
    <script type="text/javascript" src="js/jgiKanren.js"></script>
    <script type="text/javascript" src="js/catSosJgiExpand.js"></script>
    <script type="text/javascript" src="js/jkrMenu.js"></script>
    <script>
    function comSetFormWindowInfo(){
    	comClickFlgInit();

    	onLoadMakeBox();
    }

    var sosSubScreenSize = "left=0, top=0, width=600, height=600";
 	// 組織選択ボタン
    function sosPopBtn(){
    	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
		// NC201_組織検索ポップアップを開く
		window.open("","sosPopWindow",sosSubScreenSize);
		document.fm1.screenId.value = "NC201";
		document.fm1.functionId.value="Init";
		document.fm1.target="sosPopWindow";

		document.fm1.selectFlgPop.value="1";

		document.fm1.callBack.value = "callBackSosPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
    }

 	// 組織検索ポップアップから値受け取り
    function callBackSosPop(bumonRank, sosCd,
	  		  bumonSeiName, brCode, distCode, upSosCode, upBumonRank, upBrCode, upDistCode){

    	if(bumonRank != null && bumonRank != "3"){
    		window.alert("エリア階層の組織を選択してください");
    		return false;
    	}

    	document.fm1.bumonRank.value = bumonRank;
		document.fm1.sosCd.value = sosCd;
		document.fm1.sosNm.value = bumonSeiName;
		document.fm1.brCode.value = brCode;
		document.fm1.distCode.value = distCode;
		document.fm1.upSosCd.value = upSosCode;

		if(bumonRank == null || bumonRank == "3"){
			document.getElementById("tantoButton").disabled = false;
		} else if(bumonRank == "2"){
			document.getElementById("tantoButton").disabled = true;
			tantoClearBtn();
		}
 	}

 	// 担当者選択ボタン
    function tantoPopBtn(){
    	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
		// NC202_担当者検索ポップアップ画面を表示
    	window.open("","tantoPopWindow",tantoSubScreenSize);
		document.fm1.screenId.value = "NC202";
		document.fm1.functionId.value="Init";
		document.fm1.target="tantoPopWindow";

		document.fm1.sosCdPop.value = document.fm1.sosCd.value;
		document.fm1.bumonRankPop.value = document.fm1.bumonRank.value;
		document.fm1.upSosCdPop.value = document.fm1.upSosCd.value;

		document.fm1.selectFlgPop.value="1";
		document.fm1.callBack.value="callBackTantoPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
    }

	// 担当者検索ポップアップから値受け取り
    function callBackTantoPop(sosCd, bumonSeiName, jgiNo, jgiName, trtCd, brCode,
    							distCode, trtGrpCd, trtNm, mrCat){
		document.fm1.sosCd.value = sosCd;
		document.fm1.bumonRyakuName.value = bumonSeiName;
		document.fm1.jgiNo.value = jgiNo;
		document.fm1.jgiNm.value = jgiName;
		document.fm1.trtCd.value = trtCd;
		document.fm1.trtNm.value = trtNm;
		document.fm1.mrCat.value = mrCat;
		document.fm1.brCode.value = brCode;
		document.fm1.distCode.value = distCode;
    }

	// 施設選択ボタン
    function insPopBtn(){
    	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
		// NC203_施設検索ポップアップ画面を表示
		window.open("","insPopWindow",insSubScreenSize);
		document.fm1.screenId.value = "NC203";
		document.fm1.functionId.value="Init";
		document.fm1.target="insPopWindow";

		document.fm1.viewKbn.value = "0";
		document.fm1.callBack.value = "callBackInsPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();
    }

	// 施設ポップアップから施設受け取り
    function callBackInsPop(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType, insClass){

    	document.fm1.insNo.value = insNo;
    	document.fm1.insNm.value = insAbbrName;

    }

	// 組織Clearボタン
    function sosClearBtn(){
		document.fm1.sosCd.value = "";
		document.fm1.sosNm.value = "";
		document.fm1.bumonRyakuName.value = "";
		document.fm1.jgiNo.value = "";
		document.fm1.jgiNm.value = "";
		document.fm1.trtCd.value = "";
		document.fm1.trtNm.value = "";
		document.fm1.mrCat.value = "";
		document.fm1.brCode.value = "";
		document.fm1.distCode.value = "";
		document.fm1.bumonRank.value = "";
		document.fm1.upSosCd.value = "";
	}

 	// 担当者Clearボタン
    function tantoClearBtn(){
		document.fm1.bumonRyakuName.value = "";
		document.fm1.jgiNo.value = "";
		document.fm1.jgiNm.value = "";
		document.fm1.trtCd.value = "";
		document.fm1.trtNm.value = "";
		document.fm1.mrCat.value = "";
		document.fm1.brCode.value = "";
		document.fm1.distCode.value = "";
	}

 	// 施設Clearボタン
    function insClearBtn(){
		document.fm1.insNo.value = "";
		document.fm1.insNm.value = "";
		document.fm1.insKanjSrch.value = "";
	}

 	// Clearボタン
    function clearBtn(){
		document.fm1.sosCd.value = "";
		document.fm1.sosNm.value = "";
		document.fm1.bumonRyakuName.value = "";
		document.fm1.jgiNo.value = "";
		document.fm1.jgiNm.value = "";
		document.fm1.trtCd.value = "";
		document.fm1.trtNm.value = "";
		document.fm1.mrCat.value = "";
		document.fm1.brCode.value = "";
		document.fm1.distCode.value = "";
		document.fm1.bumonRank.value = "";
		document.fm1.upSosCd.value = "";

		document.fm1.insNm.value = "";

		document.fm1.insNo.value = "";
		document.fm1.ultInsNo.value = "";
		document.fm1.insKanjSrch.value = "";
		document.fm1.shisetsuNmSrch.value = "";
		document.fm1.insClass.value = "";
		document.fm1.insType.value = "";
		document.fm1.hoInsType.value = "";
		document.fm1.ultDif.value = "";
	}

	// 画面遷移処理
    function gotoNext(screenId,functionId){
   		document.fm1.target="";
  	 	fm1.screenId.value=screenId;
  	  	fm1.functionId.value=functionId;
  	  	comSubmitForAnyWarp(fm1);
  	}

 	var nf401Tab;
 	// 申請歴ボタン
    function histBtn(insNo){
    	if(!comChkClickFlg(COM_CLICK_ALERT)){return false;}
 		var tmpIns = fm1.insNo.value;

 		fm1.insNo.value = insNo;

 		if(nf401Tab && !nf401Tab.closed){
 			nf401Tab.close();
 		}

 		nf401Tab = window.open("","NF401Tab");
		document.fm1.target="NF401Tab";


  		fm1.screenId.value="NF102";
	  	fm1.functionId.value="Init";
	  	comSubmitForAnyWarp(fm1);
	  	comClickFlgInit();

	  	fm1.insNo.value = tmpIns;
	}

 	// ページボタン
    function pageBtn( pageCntCur ){
		//現在ページ番号変更（遷移）
		document.fm1.pageCntCur.value = pageCntCur;
		document.fm1.target="";
		document.fm1.screenId.value	= "NF401";
		document.fm1.functionId.value = "Search";
		// 検索イベント呼び出し
		comSubmitForAnyWarp(fm1);
	}

 	// 申請チェックボックス
 	function reqChk(chk, index){
 		let key = "hcoBlkReqDataList["+index+"].reqChk";
 		let reqFlg = document.getElementsByName(key)[0];

		if(chk.checked == true){
			reqFlg.value = "1";
		} else {
			reqFlg.value = "0";
		}
 	}

 	// 一括申請ボタン
 	function reqBtn(){
		document.fm1.screenId.value="NF403";
		document.fm1.functionId.value="Request";

		var i = 0;
    	var pharmType = "hcoBlkReqDataList["+i+"].nextPharmType";
 		var pharmTypeBox = document.getElementsByName(pharmType)[0];
 		var pharmTypeNmKey = "hcoBlkReqDataList["+i+"].nextPharmTypeNm";
 		var pharmTypeNm = document.getElementsByName(pharmTypeNmKey)[0];
    	var insRank = "hcoBlkReqDataList["+i+"].nextInsRank";
 		var insRankBox = document.getElementsByName(insRank)[0];
 		var insRankNmKey = "hcoBlkReqDataList["+i+"].nextInsRankNm";
 		var insRankNm = document.getElementsByName(insRankNmKey)[0];
    	var regVisType = "hcoBlkReqDataList["+i+"].nextRegVisType";
 		var regVisTypeBox = document.getElementsByName(regVisType)[0];
 		var regVisTypeNmKey = "hcoBlkReqDataList["+i+"].nextRegVisTypeNm";
 		var regVisTypeNm = document.getElementsByName(regVisTypeNmKey)[0];
    	var impHosType = "hcoBlkReqDataList["+i+"].nextImpHosType";
 		var impHosTypeBox = document.getElementsByName(impHosType)[0];
 		var impHosTypeNmKey = "hcoBlkReqDataList["+i+"].nextImpHosTypeNm";
 		var impHosTypeNm = document.getElementsByName(impHosTypeNmKey)[0];
 		var hoInsType = "hcoBlkReqDataList["+i+"].nextHoInsType";
 		var hoInsTypeBox = document.getElementsByName(hoInsType)[0];
 		var hoInsTypeNmKey = "hcoBlkReqDataList["+i+"].nextHoInsTypeNm";
 		var hoInsTypeNm = document.getElementsByName(hoInsTypeNmKey)[0];
 		var manageCd = "hcoBlkReqDataList["+i+"].nextManageCd";
 		var manageCdBox = document.getElementsByName(manageCd)[0];
 		var manageNmKey = "hcoBlkReqDataList["+i+"].nextManageNm";
 		var manageNm = document.getElementsByName(manageNmKey)[0];
 		var vacInsType = "hcoBlkReqDataList["+i+"].nextVacInsType";
 		var vacInsTypeBox = document.getElementsByName(vacInsType)[0];
 		var vacInsTypeNmKey = "hcoBlkReqDataList["+i+"].nextVacInsTypeNm";
 		var vacInsTypeNm = document.getElementsByName(vacInsTypeNmKey)[0];
 		var vacVisitType = "hcoBlkReqDataList["+i+"].nextVacVisitType";
 		var vacVisitTypeBox = document.getElementsByName(vacVisitType)[0];
 		var vacVisitTypeNmKey = "hcoBlkReqDataList["+i+"].nextVacVisitTypeNm";
 		var vacVisitTypeNm = document.getElementsByName(vacVisitTypeNmKey)[0];
 		var reqChkKey = "hcoBlkReqDataList["+i+"].reqChk";
 		var reqChk = document.getElementsByName(reqChkKey)[0];

 		while(pharmTypeBox != undefined){

 			if(reqChk.value == "1"){
				pharmTypeNm.value = pharmTypeBox.options[pharmTypeBox.selectedIndex].textContent;
				insRankNm.value = insRankBox.options[insRankBox.selectedIndex].textContent;
				regVisTypeNm.value = regVisTypeBox.options[regVisTypeBox.selectedIndex].textContent;
				impHosTypeNm.value = impHosTypeBox.options[impHosTypeBox.selectedIndex].textContent;
				hoInsTypeNm.value = hoInsTypeBox.options[hoInsTypeBox.selectedIndex].textContent;
				manageNm.value = manageCdBox.options[manageCdBox.selectedIndex].textContent;
				vacInsTypeNm.value = vacInsTypeBox.options[vacInsTypeBox.selectedIndex].textContent;
				vacVisitTypeNm.value = vacVisitTypeBox.options[vacVisitTypeBox.selectedIndex].textContent;
 			}

			i++;
			pharmType = "hcoBlkReqDataList["+i+"].nextPharmType";
	 		pharmTypeBox = document.getElementsByName(pharmType)[0];
	 		pharmTypeNmKey = "hcoBlkReqDataList["+i+"].nextPharmTypeNm";
	 		pharmTypeNm = document.getElementsByName(pharmTypeNmKey)[0];
	    	insRank = "hcoBlkReqDataList["+i+"].nextInsRank";
	 		insRankBox = document.getElementsByName(insRank)[0];
	 		insRankNmKey = "hcoBlkReqDataList["+i+"].nextInsRankNm";
	 		insRankNm = document.getElementsByName(insRankNmKey)[0];
	    	regVisType = "hcoBlkReqDataList["+i+"].nextRegVisType";
	 		regVisTypeBox = document.getElementsByName(regVisType)[0];
	 		regVisTypeNmKey = "hcoBlkReqDataList["+i+"].nextRegVisTypeNm";
	 		regVisTypeNm = document.getElementsByName(regVisTypeNmKey)[0];
	    	impHosType = "hcoBlkReqDataList["+i+"].nextImpHosType";
	 		impHosTypeBox = document.getElementsByName(impHosType)[0];
	 		impHosTypeNmKey = "hcoBlkReqDataList["+i+"].nextImpHosTypeNm";
	 		impHosTypeNm = document.getElementsByName(impHosTypeNmKey)[0];
	 		hoInsType = "hcoBlkReqDataList["+i+"].nextHoInsType";
	 		hoInsTypeBox = document.getElementsByName(hoInsType)[0];
	 		hoInsTypeNmKey = "hcoBlkReqDataList["+i+"].nextHoInsTypeNm";
	 		hoInsTypeNm = document.getElementsByName(hoInsTypeNmKey)[0];
	 		manageCd = "hcoBlkReqDataList["+i+"].nextManageCd";
	 		manageCdBox = document.getElementsByName(manageCd)[0];
	 		manageNmKey = "hcoBlkReqDataList["+i+"].nextManageNm";
	 		manageNm = document.getElementsByName(manageNmKey)[0];
	 		vacInsType = "hcoBlkReqDataList["+i+"].nextVacInsType";
	 		vacInsTypeBox = document.getElementsByName(vacInsType)[0];
	 		vacInsTypeNmKey = "hcoBlkReqDataList["+i+"].nextVacInsTypeNm";
	 		vacInsTypeNm = document.getElementsByName(vacInsTypeNmKey)[0];
	 		vacVisitType = "hcoBlkReqDataList["+i+"].nextVacVisitType";
	 		vacVisitTypeBox = document.getElementsByName(vacVisitType)[0];
	 		vacVisitTypeNmKey = "hcoBlkReqDataList["+i+"].nextVacVisitTypeNm";
	 		vacVisitTypeNm = document.getElementsByName(vacVisitTypeNmKey)[0];
	 		reqChkKey = "hcoBlkReqDataList["+i+"].reqChk";
	 		reqChk = document.getElementsByName(reqChkKey)[0];
 		}

		comSubmitForAnyWarp(fm1);

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
    	} else {
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
    		box.options[37].hidden = true;
    		box.options[38].hidden = true;
    		box.options[39].hidden = true;
    		box.options[40].hidden = true;
    		box.options[41].hidden = true;
    		box.options[42].hidden = true;
    		box.options[43].hidden = true;
    		box.options[44].hidden = true;
    		box.options[45].hidden = true;
    		box.options[46].hidden = true;
    		box.options[47].hidden = true;
    		box.options[48].hidden = true;
    		box.options[49].hidden = true;
    		box.options[50].hidden = true;
    		box.options[51].hidden = true;
    		box.options[52].hidden = true;
    		box.options[53].hidden = true;
    		box.options[54].hidden = true;
    		box.options[55].hidden = true;
    		box.options[56].hidden = true;
    		box.options[57].hidden = true;
    		box.options[58].hidden = true;
    		box.options[59].hidden = true;
    	}
    	return box;
    }

    function onLoadMakeBox(){
    	var i = 0;
    	var insTypeKey = "hcoBlkReqDataList["+i+"].insType";
    	var insType = document.getElementsByName(insTypeKey)[0];
    	var tmpPharmTypeKey = "hcoBlkReqDataList["+i+"].tmpPharmType";
    	var tmpPharmType = document.getElementsByName(tmpPharmTypeKey)[0];
    	var pharmType = "hcoBlkReqDataList["+i+"].nextPharmType";
 		var pharmTypeBox = document.getElementsByName(pharmType)[0];
 		var tmpInsRankKey = "hcoBlkReqDataList["+i+"].tmpInsRank";
    	var tmpInsRank = document.getElementsByName(tmpInsRankKey)[0];
    	var insRank = "hcoBlkReqDataList["+i+"].nextInsRank";
 		var insRankBox = document.getElementsByName(insRank)[0];
 		var tmpRegVisTypeKey = "hcoBlkReqDataList["+i+"].tmpRegVisType";
    	var tmpRegVisType = document.getElementsByName(tmpRegVisTypeKey)[0];
    	var regVisType = "hcoBlkReqDataList["+i+"].nextRegVisType";
 		var regVisTypeBox = document.getElementsByName(regVisType)[0];
 		var tmpImpHosTypeKey = "hcoBlkReqDataList["+i+"].tmpImpHosType";
    	var tmpImpHosType = document.getElementsByName(tmpImpHosTypeKey)[0];
    	var impHosType = "hcoBlkReqDataList["+i+"].nextImpHosType";
 		var impHosTypeBox = document.getElementsByName(impHosType)[0];
 		var hoInsType = "hcoBlkReqDataList["+i+"].nextHoInsType";
 		var hoInsTypeBox = document.getElementsByName(hoInsType)[0];
 		var hoInsTypeValueKey = "hcoBlkReqDataList["+i+"].nextHoInsTypeValue";
 		var hoInsTypeValue = document.getElementsByName(hoInsTypeValueKey)[0];
 		var tmpManageCdKey = "hcoBlkReqDataList["+i+"].tmpManageCd";
    	var tmpManageCd = document.getElementsByName(tmpManageCdKey)[0];
 		var manageCd = "hcoBlkReqDataList["+i+"].nextManageCd";
 		var manageCdBox = document.getElementsByName(manageCd)[0];

 		var vacInsType = "hcoBlkReqDataList["+i+"].nextVacInsType";
 		var vacInsTypeBox = document.getElementsByName(vacInsType)[0];
 		var vacVisitType = "hcoBlkReqDataList["+i+"].nextVacVisitType";
 		var vacVisitTypeBox = document.getElementsByName(vacVisitType)[0];

 		while(pharmTypeBox != undefined){
 			if(insType.value == "04" || insType.value == "05" || insType.value == "07"){
 	 			pharmTypeBox.disabled = true;
 	   			insRankBox.disabled = true;
 	   			regVisTypeBox.disabled = true;
 	   			impHosTypeBox.disabled = true;
 	   			manageCdBox.disabled = true;
 	   			tmpPharmType.value = "";
 	   			tmpInsRank.value = "";
 	   			tmpRegVisType.value = "";
 	   			tmpImpHosType.value = "";
 	   			tmpManageCd.value = "";
 	 		} else {
 				if(tmpPharmType.value != ""){
 					if(tmpInsRank.value == ""){
 						regVisTypeBox.disabled = true;
 		   		   		impHosTypeBox.disabled = true;
 		   		   		manageCdBox.disabled = true;
 			   			tmpRegVisType.value = "";
 			   			tmpImpHosType.value = "";
 			   			tmpManageCd.value = "";
 					}
 				} else {
 					insRankBox.disabled.value = true;
 					regVisTypeBox.disabled.value = true;
 	   		   		impHosTypeBox.disabled.value = true;
 	   		   		manageCdBox.disabled.value = true;
 		   			tmpInsRank.value = "";
 		   			tmpRegVisType.value = "";
 		   			tmpImpHosType.value = "";
 		   			tmpManageCd.value = "";
 				}
 	 		}

 			// 施設区分
 			makePharmTypeBox(pharmTypeBox, insType.value);
 			pharmTypeBox.value = tmpPharmType.value;

 			// 階級区分
			makeInsRankBox(insRankBox, insType.value, pharmTypeBox.value);
 			insRankBox.value = tmpInsRank.value;

 			// 定訪先区分
 			makeRegVisTypeBox(regVisTypeBox, insType.value, pharmTypeBox.value, insRankBox.value);
 			regVisTypeBox.value = tmpRegVisType.value;

 			// 重点病院区分
 			makeImpHosTypeBox(impHosTypeBox, insType.value, pharmTypeBox.value, insRankBox.value);
 			impHosTypeBox.value = tmpImpHosType.value;

 			// 対象区分
 			setHoInsType(hoInsTypeBox, insRankBox.value);
 			hoInsTypeValue = hoInsTypeBox.value;
 			hoInsTypeBox.disabled = true;

	 		// 経営主体
 			makeManageCdBox(manageCdBox, insRankBox.value);
 			manageCdBox.value = tmpManageCd.value;

	 		if(insType.value != "08"){
	 			vacInsTypeBox.disabled = true;
	 			vacVisitTypeBox.disabled = true;
	 		}

	 		if(document.fm1.btnEnableFlg.value != "1"){
	 			pharmTypeBox.disabled = true;
	 			insRankBox.disabled = true;
	 			regVisTypeBox.disabled = true;
	 			impHosTypeBox.disabled = true;
	 			vacInsTypeBox.disabled = true;
	 			vacVisitTypeBox.disabled = true;
	 		}

			i++;
			insTypeKey = "hcoBlkReqDataList["+i+"].insType";
	    	insType = document.getElementsByName(insTypeKey)[0];
	    	tmpPharmTypeKey = "hcoBlkReqDataList["+i+"].tmpPharmType";
	    	tmpPharmType = document.getElementsByName(tmpPharmTypeKey)[0];
			pharmType = "hcoBlkReqDataList["+i+"].nextPharmType";
	 		pharmTypeBox = document.getElementsByName(pharmType)[0];
	 		tmpInsRankKey = "hcoBlkReqDataList["+i+"].tmpInsRank";
	    	tmpInsRank = document.getElementsByName(tmpInsRankKey)[0];
	    	insRank = "hcoBlkReqDataList["+i+"].nextInsRank";
	 		insRankBox = document.getElementsByName(insRank)[0];
	 		tmpRegVisTypeKey = "hcoBlkReqDataList["+i+"].tmpRegVisType";
	    	tmpRegVisType = document.getElementsByName(tmpRegVisTypeKey)[0];
	    	regVisType = "hcoBlkReqDataList["+i+"].nextRegVisType";
	 		regVisTypeBox = document.getElementsByName(regVisType)[0];
	 		tmpImpHosTypeKey = "hcoBlkReqDataList["+i+"].tmpImpHosType";
	    	tmpImpHosType = document.getElementsByName(tmpImpHosTypeKey)[0];
	    	impHosType = "hcoBlkReqDataList["+i+"].nextImpHosType";
	 		impHosTypeBox = document.getElementsByName(impHosType)[0];
	 		hoInsType = "hcoBlkReqDataList["+i+"].nextHoInsType";
	 		hoInsTypeBox = document.getElementsByName(hoInsType)[0];
	 		vacInsType = "hcoBlkReqDataList["+i+"].nextVacInsType";
	 		vacInsTypeBox = document.getElementsByName(vacInsType)[0];
	 		vacVisitType = "hcoBlkReqDataList["+i+"].nextVacVisitType";
	 		vacVisitTypeBox = document.getElementsByName(vacVisitType)[0];
	 		manageCd = "hcoBlkReqDataList["+i+"].nextManageCd";
	 		manageCdBox = document.getElementsByName(manageCd)[0];
 		}
    }

	// セレクトボックスの設定
    function changeBox(changeItem, index){
    	var insTypeKey = "hcoBlkReqDataList["+index+"].insType";
    	var insType = document.getElementsByName(insTypeKey)[0];
    	var pharmType = "hcoBlkReqDataList["+index+"].nextPharmType";
 		var pharmTypeBox = document.getElementsByName(pharmType)[0];
    	var insRank = "hcoBlkReqDataList["+index+"].nextInsRank";
 		var insRankBox = document.getElementsByName(insRank)[0];
    	var regVisType = "hcoBlkReqDataList["+index+"].nextRegVisType";
 		var regVisTypeBox = document.getElementsByName(regVisType)[0];
    	var impHosType = "hcoBlkReqDataList["+index+"].nextImpHosType";
 		var impHosTypeBox = document.getElementsByName(impHosType)[0];
 		var hoInsType = "hcoBlkReqDataList["+index+"].nextHoInsType";
 		var hoInsTypeBox = document.getElementsByName(hoInsType)[0];
 		var hoInsTypeValueKey = "hcoBlkReqDataList["+index+"].nextHoInsTypeValue";
 		var hoInsTypeValue = document.getElementsByName(hoInsTypeValueKey)[0];
 		var manageCd = "hcoBlkReqDataList["+index+"].nextManageCd";
 		var manageCdBox = document.getElementsByName(manageCd)[0];

 		if(changeItem == "1"){
			// 施設区分変更
			// 階級区分
			makeInsRankBox(insRankBox, insType.value, pharmTypeBox.value);
			insRankBox.value = "";

			// 定訪先区分
			makeRegVisTypeBox(regVisTypeBox, insType.value, pharmTypeBox.value, insRankBox.value);
			regVisTypeBox.value = "";

			// 重点病院区分
			makeImpHosTypeBox(impHosTypeBox, insType.value, pharmTypeBox.value, insRankBox.value);
			impHosTypeBox.value = "";

			// 対象区分
			hoInsTypeBox.value = "";
			hoInsTypeValue = "";

			// 経営主体
			makeManageCdBox(manageCdBox, insRankBox.value);
			manageCdBox.value = "";

 		} else if(changeItem == "2"){
			// 階級区分変更
			// 定訪先区分
			makeRegVisTypeBox(regVisTypeBox, insType.value, pharmTypeBox.value, insRankBox.value);
			regVisTypeBox.value = "";

			// 重点病院区分
			makeImpHosTypeBox(impHosTypeBox, insType.value, pharmTypeBox.value, insRankBox.value);
			impHosTypeBox.value = "";

			// 対象区分
			setHoInsType(hoInsTypeBox, insRankBox.value);
			hoInsTypeValue = hoInsTypeBox.value;

			// 経営主体
			makeManageCdBox(manageCdBox, insRankBox.value);
			manageCdBox.value = "";
 		}
	}

	// 対象区分値設定
	function setHoInsType(hoInsType, insRank){
		if(insRank == "01" ||insRank == "02"){
			hoInsType.value = "1";
		} else if(insRank == "03" || insRank == "04" || insRank == "05" || insRank == "06"
			 || insRank == "07" || insRank == "08"){
			hoInsType.value = "2";
		} else if(insRank == "09" || insRank == "10" || insRank == "11" || insRank == "12"
			 || insRank == "13" || insRank == "14"|| insRank == "15" || insRank == "16"
			 || insRank == "17" || insRank == "20"){
			hoInsType.value = "3";
		} else if(insRank == "00" || insRank == "18" || insRank == "19"){
			hoInsType.value = "4";
		} else {
			hoInsType.value = "";
		}
	}

	// 病床数再計算
	function calcBedCnt(index){
		var bedsTot = 0;
		var medBedsTot = 0;

		var bedCnt01Key = "hcoBlkReqDataList["+index+"].nextBedCnt01";
    	var bedCnt01Value = document.getElementsByName(bedCnt01Key)[0];
    	var bedCnt03Key = "hcoBlkReqDataList["+index+"].nextBedCnt03";
    	var bedCnt03Value = document.getElementsByName(bedCnt03Key)[0];
    	var bedCnt04Key = "hcoBlkReqDataList["+index+"].nextBedCnt04";
    	var bedCnt04Value = document.getElementsByName(bedCnt04Key)[0];
    	var bedCnt05Key = "hcoBlkReqDataList["+index+"].nextBedCnt05";
    	var bedCnt05Value = document.getElementsByName(bedCnt05Key)[0];
    	var bedCnt07Key = "hcoBlkReqDataList["+index+"].nextBedCnt07";
    	var bedCnt07Value = document.getElementsByName(bedCnt07Key)[0];
    	var bedCnt02Key = "hcoBlkReqDataList["+index+"].nextBedCnt02";
    	var bedCnt02Value = document.getElementsByName(bedCnt02Key)[0];
    	var bedsTotKey = "hcoBlkReqDataList["+index+"].nextBedsTot";
    	var bedsTotValue = document.getElementsByName(bedsTotKey)[0];
    	var medBedsTotKey = "hcoBlkReqDataList["+index+"].nextMedBedsTot";
    	var medBedsTotValue = document.getElementsByName(medBedsTotKey)[0];

    	// 一般
		if(bedCnt01Value.value != "" && comChkNum(bedCnt01Value.value)) {
			bedsTot += parseInt(bedCnt01Value.value);
			medBedsTot += parseInt(bedCnt01Value.value);
		}

		// 精神
		if(bedCnt03Value.value != "" && comChkNum(bedCnt03Value.value)) {
			bedsTot += parseInt(bedCnt03Value.value);
			medBedsTot += parseInt(bedCnt03Value.value);
		}

		// 結核
		if(bedCnt04Value.value != "" && comChkNum(bedCnt04Value.value)) {
			bedsTot += parseInt(bedCnt04Value.value);
			medBedsTot += parseInt(bedCnt04Value.value);
		}

		// 感染症
		if(bedCnt05Value.value != "" && comChkNum(bedCnt05Value.value)) {
			bedsTot += parseInt(bedCnt05Value.value);
			medBedsTot += parseInt(bedCnt05Value.value);
		}

		// 療養
		if(bedCnt07Value.value != "" && comChkNum(bedCnt07Value.value)) {
			bedsTot += parseInt(bedCnt07Value.value);
		}

		// 医療療養
		if(bedCnt02Value.value != "" && comChkNum(bedCnt02Value.value)) {
			medBedsTot += parseInt(bedCnt02Value.value);
		}

		bedsTotValue.value = bedsTot;
		medBedsTotValue.value = medBedsTot;
	}

</script>
<style>
	.siz{
	width:2500px;
	}
	thead {
    position:Sticky;
    top:0;
    background-color: #fff;
    left: 2;
    }
</style>
</head>

  <%-- バナー部分をインクルード --%>
  <%-- サブシステムIDが３:(従業員関連)の時 --%>
  <jsp:include page="common/jkrTop.jsp" flush="true" />
  <br>
  <%-- 更新警告メッセージ表示をインクルード 開始 --%>
  <jsp:include page="common/jkrDispMsg.jsp" flush="true" />
  <%-- 更新警告メッセージ表示をインクルード 終了 --%>

<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();">
<%-- ポータルタイトル 開始 --%>
    <table class="comPortalTitle">
    <tbody>
    <tr>
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設来期項目一括申請"></td>
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

<table class="comPortalTable" align="center" style="width:95%;margin-top:0pt">
  <tbody>
  <tr/>
    <s:form name="fm0" theme="simple">
         <input type="hidden" name="endRecordNo1"   value=""  />
    </s:form>
    <s:form name="fm1" theme="simple" >
    <s:hidden name="screenId"  />
    <s:hidden name="functionId" />

    <s:hidden id="pageFlag" name="pageFlag" />

    <input type="hidden" name="windowName" value="" />
    <input type="hidden" name="openerName" value="" />

	<s:hidden name="loginJokenSetCd"/>
	<s:hidden name="loginJgiNo"/>
    <s:hidden name="loginNm"/>
    <s:hidden name="loginShzNm"/>
    <s:hidden name="loginTrtCd"/>
    <s:hidden name="loginBrCd"/>
    <s:hidden name="loginDistCd"/>
    <s:hidden name="backScreenId" value="NF403" />
    <s:hidden id="preScreenId" name="preScreenId"/>
	<s:hidden id="pageCntCur" name="pageCntCur"/>

	<s:hidden id="callBack" name="callBack" />
	<s:hidden id="viewKbn" name="viewKbn" />
	<s:hidden id="title" name="title" />
	<s:hidden id="srchFlg" name="srchFlg" />

	<s:hidden id="btnEnableFlg" name="btnEnableFlg" />
	<s:hidden id="srchSysDate" name="srchSysDate" />

	<s:hidden id="upSosCd" name="upSosCd"/>
	<s:hidden id="sosCdPop" name="sosCdPop"/>
	<s:hidden id="upSosCdPop" name="upSosCdPop"/>
	<s:hidden id="bumonRankPop" name="bumonRankPop"/>
	<s:hidden id="selectFlgPop" name="selectFlgPop"/>

	<s:hidden id="bumonRank" name="bumonRank"/>
	<s:hidden id="bumonRyakuName" name="bumonRyakuName"/>
    <s:hidden id="brCode" name="brCode"/>
	<s:hidden id="distCode" name="distCode"/>
	<s:hidden id="trtCd" name="trtCd"/>
	<s:hidden id="trtNm" name="trtNm"/>
	<s:hidden id="mrCat" name="mrCat"/>

<%-- ポータルボディー 開始 --%>
	<table class="pupBodyTable" align="center">
	<tr><td>
<%-- 検索部 開始 --%>

	<tr>
		<%-- 組織 --%>
		<td class="pupControlItem"><nobr>&nbsp;組織</nobr>
		   <nobr>
		   <input class="comButton" type="button" name="button1" value="選択" onClick="JavaScript:sosPopBtn(); return false;" />
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="sosNm" style="background-color:#D4D0C8" readonly="true" />
			<s:hidden key="sosCd" />
			<a href ="#" onClick="sosClearBtn();return false;">Clear</a>
		</td>
		<%-- 担当者 --%>
		<td class="pupControlItem"><nobr>&nbsp;担当者</nobr>
		   <nobr>
		   <s:if test="bumonRank == '2'">
		   	<input class="comButton" type="button" id="tantoButton" name="button2" value="選択" onClick="JavaScript:tantoPopBtn(); return false;" disabled />
		   </s:if>
		   <s:else>
		   	<input class="comButton" type="button" id="tantoButton" name="button2" value="選択" onClick="JavaScript:tantoPopBtn(); return false;" />
		   </s:else>
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="jgiNm" style="background-color:#D4D0C8" readonly="true" />
			<s:hidden key="jgiNo" />
			<a href ="#" onClick="tantoClearBtn();return false;">Clear</a>
		</td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 施設 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設</nobr>
		   <nobr>
		   <input class="comButton" type="button" name="button1" value="選択" onClick="JavaScript:insPopBtn(); return false;" />
		   </nobr>
		</td>
		<td>
			<s:textfield size="20" maxlength="40" name="insNm" style="background-color:#D4D0C8" readonly="true" />
			<a href ="#" onClick="insClearBtn();return false;">Clear</a>
		</td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 施設固定C --%>
		<td class="pupControlItem"><nobr>&nbsp;施設固定C</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="insNo" />
		</td>
		<%-- ULT施設コード --%>
		<td class="pupControlItem"><nobr>&nbsp;ULT施設コード</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="ultInsNo" />
		</td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 施設略式漢字名 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設略式漢字名</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="insKanjSrch" />
		</td>
		<%-- ULT施設名 --%>
		<td class="pupControlItem"><nobr>&nbsp;ULT施設名</nobr></td>
		<td>
			<s:textfield size="20" maxlength="40" name="shisetsuNmSrch" />
		</td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 施設分類 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設分類</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="insClass" name="insClass" cssStyle="width:80pt" list ="insClassCombo" />
	    </td>
	    <%-- 施設種別 --%>
		<td class="pupControlItem"><nobr>&nbsp;施設種別</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="insType" name="insType" cssStyle="width:80pt" list ="insTypeCombo" />
	    </td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<%-- 対象区分 --%>
		<td class="pupControlItem"><nobr>&nbsp;対象区分</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="hoInsType" name="hoInsType" cssStyle="width:80pt" list ="hoInsTypeCombo" />
	    </td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	    <%-- ULT差分 --%>
		<td class="pupControlItem"><nobr>&nbsp;ULT差分</nobr></td>
        <td class="comTableSearchItem">
			<s:select id="ultDif" name="ultDif" cssStyle="width:80pt" list ="ultDifCombo" />
	    </td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	    <td class="pupControlItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td class="pupControlItem"><nobr>&nbsp;</nobr></td>
		<td>
			<input type="button" name="クリア" value="クリア" onclick="clearBtn();return false;" />
			<input type="button" value="検索" name="検索" onclick="gotoNext('NF403','Search')"/>
		</td>
	</tr>

<%-- ページャー表示 開始 --%>
          <s:if test='pageFlag == "1" '>
          </s:if>
		<s:else>
          	<table width="80%">
          		<tr>
                    <td align="right">
                      <jsp:include page="common/rdmPage.jsp">
                      <jsp:param name="" value="" />
                      </jsp:include>
                    </td>
                </tr>
             </table>
          </s:else>
          <%-- ページャー表示 終了 --%>

   <s:if test='pageFlag == "1" '>
          <!-- なにも表示しない -->
      </s:if>
   <s:else>
    <div style="max-height:270px;width:1200px;overflow-y:scroll; overflow-x:scroll; border-width:1px; position: relative; top:0; margin:0 auto;">
<table class="siz">
	<thead style="z-index:3;">
	<tr>
	    <td class="comFormTableItem" colSpan="3"><%-- スクロールバー用のテーブルクラスにすること --%>

	<%-- ヘッダー行 --%>
	<tr class="comTableTitle" style="position: sticky; top:0; left:0;">
		<td class="comTableTitle" style="width:50px" rowspan=2>申請</td>
		<td class="comTableTitle" style="width:110px;">施設固定C</td>
		<td class="comTableTitle" style="width:50px" rowspan=2>期</td>
		<td class="comTableTitle" style="width:130px" colspan=8>施設情報</td>
		<td class="comTableTitle" colspan=10>病床数情報</td>
		<td class="comTableTitle" style="width:50px" rowspan=2>ULT<br>差分</td>
		<td class="comTableTitle" style="width:70px" rowspan=2>申請コメント</td>
	</tr>
	<tr class="comTableTitle" style="position: sticky; top:20; left:0;">
		<td class="comTableTitle">施設略式漢字名</td>
		<td class="comTableTitle">施設区分</td>
		<td class="comTableTitle">階級区分</td>
		<td class="comTableTitle">定訪先区分</td>
		<td class="comTableTitle">重点病院区分</td>
		<td class="comTableTitle">対象区分</td>
		<td class="comTableTitle">経営主体</td>
		<td class="comTableTitle">ワクチン対象区分</td>
		<td class="comTableTitle">ワクチン定訪先区分</td>
		<td class="comTableTitle" style="width:40px">基準</td>
		<td class="comTableTitle" style="width:40px">結核</td>
		<td class="comTableTitle" style="width:40px">一般</td>
		<td class="comTableTitle" style="width:40px">感染症</td>
		<td class="comTableTitle" style="width:40px">精神</td>
		<td class="comTableTitle" style="width:40px">療養</td>
		<td class="comTableTitle" style="width:60px">医療療養</td>
		<td class="comTableTitle" style="width:60px">介護医療</td>
		<td class="comTableTitle" style="width:60px">ベッド数計</td>
		<td class="comTableTitle" style="width:70px">医療ベッド数計</td>
	</tr>
	</thead>

    <%-- 内容 --%>

	<s:iterator value="hcoBlkReqDataList" status="status" var="rowBean">
		<tr style="min-height:30px;">
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].reqChk"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insNo"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].pharmType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insRank"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].regVisType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].impHosType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].hoInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].manageCd"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacInsType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacVisitType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].pharmTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insRankNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].regVisTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].impHosTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].hoInsTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].manageNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacInsTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacVisitTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCntBase"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt04"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt01"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt05"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt03"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt07"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt02"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt06"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].medBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultDif"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insAbbrName"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].shisetsuKbn"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].keieitai"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCntBase"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt04"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt01"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt05"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt03"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedCnt07"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultBedsTot"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].ultMedBedsTot"/>

			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpPharmType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpInsRank"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpRegVisType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpImpHosType"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].tmpManageCd"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextHoInsTypeValue"/>

			<s:hidden name="hcoBlkReqDataList[%{#status.index}].pharmTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].insRankFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].regVisTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].impHosTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].hoInsTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].manageCdFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacInsTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].vacVisitTypeFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCntBaseFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt04Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt01Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt05Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt03Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt07Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt02Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedCnt06Flg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].bedsTotFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].medBedsTotFlg"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].updShaYmd"/>

			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextPharmTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextInsRankNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextRegVisTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextImpHosTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextHoInsTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextManageNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextVacInsTypeNm"/>
			<s:hidden name="hcoBlkReqDataList[%{#status.index}].nextVacVisitTypeNm"/>

			<td class="comTableItem" rowspan=3 style="text-align:center;">
				<s:if test="btnEnableFlg == 1">
				<input type="checkbox" name="reqChkBox" onChange="JavaScript:reqChk(this,'<s:property value="%{#status.index}"/>'); return false;" />
				</s:if>
				<s:else>
				<input type="checkbox" name="reqChkBox" onChange="" disabled />
				</s:else>
			</td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insNo" /></td>
	        <td class="comTableItem">当期</td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].pharmTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insRankNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].regVisTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].impHosTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].hoInsTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].manageNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].vacInsTypeNm" /></td>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].vacVisitTypeNm" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCntBase" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt04" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt01" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt05" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt03" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt07" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt02" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedCnt06" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].bedsTot" /></td>
	        <td class="comTableItem" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].medBedsTot" /></td>
	        <td class="comTableItem" style="text-align:center" rowspan=3><s:label key="hcoBlkReqDataList[%{#status.index}].ultDif" /></td>
	        <td class="comTableItem" rowspan=3>
	        	<s:if test="btnEnableFlg == 1">
	        	<s:textarea name="hcoBlkReqDataList[%{#status.index}].reqComment" maxlength="300" style="resize:none" />
	        	</s:if>
	        	<s:else>
	        	<s:textarea name="hcoBlkReqDataList[%{#status.index}].reqComment" maxlength="300" style="resize:none" readonly="true" />
	        	</s:else>
	        </td>
		</tr>
		<tr>
	        <td class="comTableItem"><s:label key="hcoBlkReqDataList[%{#status.index}].insAbbrName" /></td>
	        <td class="comTableItem">ULT</td>
	        <td class="comTableItemNF401"><s:label key="hcoBlkReqDataList[%{#status.index}].shisetsuKbn" /></td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401"><s:label key="hcoBlkReqDataList[%{#status.index}].keieitai" /></td>
	        <td class="comTableItemNF401">&nbsp;</td>
	        <td class="comTableItemNF401">&nbsp;</td>

	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCntBase" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt04" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt01" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt05" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt03" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedCnt07" /></td>
	        <td class="comTableItemNF401" style="text-align:right">&nbsp;</td>
	        <td class="comTableItemNF401" style="text-align:right">&nbsp;</td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultBedsTot" /></td>
	        <td class="comTableItemNF401" style="text-align:right"><s:label key="hcoBlkReqDataList[%{#status.index}].ultMedBedsTot" /></td>
		</tr>
		<tr style="min-height:30px;">
	        <td class="comTableItem">
	        	<input type="button" value="申請歴" onclick="histBtn('<s:property value="#rowBean.insNo"/>');return false;" />
	        </td>
	        <td class="comTableItem">来期</td>
	        <td class="comTableItem">
	        <s:if test="#rowBean.pharmTypeFlg != 1">
	        	<s:select name="hcoBlkReqDataList[%{#status.index}].nextPharmType" cssStyle="width:120pt" list ="pharmTypeCombo" onChange="JavaScript:changeBox('1','%{#status.index}'); return false;" />
	        </s:if>
	        <s:else>
	        	<s:select cssClass="comTableSelectYellow" name="hcoBlkReqDataList[%{#status.index}].nextPharmType" cssStyle="width:120pt" list ="pharmTypeCombo" onChange="JavaScript:changeBox('1','%{#status.index}'); return false;" />
	        </s:else>
	        </td>
	        <td class="comTableItem">
	        <s:if test="#rowBean.insRankFlg != 1">
	        	<s:select name="hcoBlkReqDataList[%{#status.index}].nextInsRank" cssStyle="width:120pt" list ="insRankCombo" onChange="JavaScript:changeBox('2','%{#status.index}'); return false;" />
	        </s:if>
	        <s:else>
	        	<s:select cssClass="comTableSelectYellow" name="hcoBlkReqDataList[%{#status.index}].nextInsRank" cssStyle="width:120pt" list ="insRankCombo" onChange="JavaScript:changeBox('2','%{#status.index}'); return false;" />
	        </s:else>
	        </td>
	        <td class="comTableItem">
	        <s:if test="#rowBean.regVisTypeFlg != 1">
	        	<s:select name="hcoBlkReqDataList[%{#status.index}].nextRegVisType" cssStyle="width:120pt" list ="regVisTypeCombo" />
	        </s:if>
	        <s:else>
	        	<s:select cssClass="comTableSelectYellow" name="hcoBlkReqDataList[%{#status.index}].nextRegVisType" cssStyle="width:120pt" list ="regVisTypeCombo" />
	        </s:else>
	        </td>
	        <td class="comTableItem">
	        <s:if test="#rowBean.impHosTypeFlg != 1">
	        	<s:select name="hcoBlkReqDataList[%{#status.index}].nextImpHosType" cssStyle="width:120pt" list ="impHosTypeCombo" />
	        </s:if>
	        <s:else>
	        	<s:select cssClass="comTableSelectYellow" name="hcoBlkReqDataList[%{#status.index}].nextImpHosType" cssStyle="width:120pt" list ="impHosTypeCombo" />
	        </s:else>
	        </td>
	        <td class="comTableItem">
	        <s:if test="#rowBean.hoInsTypeFlg != 1">
	        	<s:select name="hcoBlkReqDataList[%{#status.index}].nextHoInsType" cssStyle="width:120pt" list ="hoInsTypeCombo" />
	        </s:if>
	        <s:else>
	        	<s:select cssClass="comTableSelectYellow" name="hcoBlkReqDataList[%{#status.index}].nextHoInsType" cssStyle="width:120pt" list ="hoInsTypeCombo" />
	        </s:else>
	        </td>
	        <td class="comTableItem">
	        <s:if test="#rowBean.manageCdFlg != 1">
	        	<s:select name="hcoBlkReqDataList[%{#status.index}].nextManageCd" cssStyle="width:120pt" list ="manageCdCombo" />
	        </s:if>
	        <s:else>
	        	<s:select cssClass="comTableSelectYellow" name="hcoBlkReqDataList[%{#status.index}].nextManageCd" cssStyle="width:120pt" list ="manageCdCombo" />
	        </s:else>
	        </td>
	        <td class="comTableItem">
	        <s:if test="#rowBean.vacInsTypeFlg != 1">
	        	<s:select name="hcoBlkReqDataList[%{#status.index}].nextVacInsType" cssStyle="width:120pt" list ="vacInsTypeCombo" />
	        </s:if>
	        <s:else>
	        	<s:select cssClass="comTableSelectYellow" name="hcoBlkReqDataList[%{#status.index}].nextVacInsType" cssStyle="width:120pt" list ="vacInsTypeCombo" />
	        </s:else>
	        </td>
	        <td class="comTableItem">
	       	<s:if test="#rowBean.vacVisitTypeFlg != 1">
	        	<s:select name="hcoBlkReqDataList[%{#status.index}].nextVacVisitType" cssStyle="width:120pt" list ="vacVisitTypeCombo" />
	        </s:if>
	        <s:else>
	        	<s:select cssClass="comTableSelectYellow" name="hcoBlkReqDataList[%{#status.index}].nextVacVisitType" cssStyle="width:120pt" list ="vacVisitTypeCombo" />
	        </s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="btnEnableFlg == 1 and (#rowBean.insType == '01' or #rowBean.insType == '02')">
	        		<s:if test="#rowBean.bedCntBaseFlg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCntBase" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCntBase" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:else>
	        	</s:if>
	        	<s:else>
	        		<s:if test="#rowBean.bedCntBaseFlg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCntBase" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCntBase" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
	        		</s:else>
	        	</s:else>
	        	</td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="btnEnableFlg == 1 and (#rowBean.insType == '01' or #rowBean.insType == '02')">
	        		<s:if test="#rowBean.bedCnt04Flg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt04" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt04" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:else>
	        	</s:if>
	        	<s:else>
	        		<s:if test="#rowBean.bedCnt04Flg != 1">
		        	<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt04" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:if>
		        	<s:else>
		        	<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt04" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:else>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="btnEnableFlg == 1 and (#rowBean.insType == '01' or #rowBean.insType == '02')">
	        	<s:if test="#rowBean.bedCnt01Flg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt01" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt01" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:else>
	        	</s:if>
	        	<s:else>
	        	<s:if test="#rowBean.bedCnt01Flg != 1">
		        	<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt01" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:if>
		        	<s:else>
		        	<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt01" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:else>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="btnEnableFlg == 1 and (#rowBean.insType == '01' or #rowBean.insType == '02')">
	        	<s:if test="#rowBean.bedCnt05Flg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt05" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt05" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:else>
	        	</s:if>
	        	<s:else>
	        	<s:if test="#rowBean.bedCnt05Flg != 1">
		        	<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt05" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:if>
		        	<s:else>
		        	<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt05" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:else>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="btnEnableFlg == 1 and (#rowBean.insType == '01' or #rowBean.insType == '02')">
	        	<s:if test="#rowBean.bedCnt03Flg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt03" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt03" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:else>
	        	</s:if>
	        	<s:else>
	        	<s:if test="#rowBean.bedCnt03Flg != 1">
		        	<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt03" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:if>
		        	<s:else>
		        	<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt03" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:else>
	        	</s:else>
	       	</td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="btnEnableFlg == 1 and (#rowBean.insType == '01' or #rowBean.insType == '02')">
	        	<s:if test="#rowBean.bedCnt07Flg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt07" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt07" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:else>
	        	</s:if>
	        	<s:else>
	        	<s:if test="#rowBean.bedCnt07Flg != 1">
		        	<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt07" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:if>
		        	<s:else>
		        	<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt07" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:else>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="btnEnableFlg == 1 and (#rowBean.insType == '01' or #rowBean.insType == '02')">
	        	<s:if test="#rowBean.bedCnt02Flg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt02" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt02" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:else>
	        	</s:if>
	        	<s:else>
	        	<s:if test="#rowBean.bedCnt02Flg != 1">
		        	<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt02" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:if>
		        	<s:else>
		        	<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt02" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:else>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="btnEnableFlg == 1 and (#rowBean.insType == '01' or #rowBean.insType == '02')">
	        	<s:if test="#rowBean.bedCnt06Flg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt06" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:if>
	        		<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt06" size="4" maxlength="4" style="text-align:right;" onChange="JavaScript:calcBedCnt('%{#status.index}'); return false;" />
	        		</s:else>
	        	</s:if>
	        	<s:else>
	        	<s:if test="#rowBean.bedCnt06Flg != 1">
		        	<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedCnt06" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:if>
		        	<s:else>
		        	<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedCnt06" size="4" maxlength="4" style="text-align:right;" readonly="true"/>
		        	</s:else>
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.bedsTotFlg != 1">
	        		<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextBedsTot" size="4" maxlength="4" style="text-align:right;" readonly="true" />
	        	</s:if>
	        	<s:else>
	        		<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextBedsTot" size="4" maxlength="4" style="text-align:right;" readonly="true" />
	        	</s:else>
	        </td>
	        <td class="comTableItem" style="text-align:right">
	        	<s:if test="#rowBean.medBedsTotFlg != 1">
		        	<s:textfield name="hcoBlkReqDataList[%{#status.index}].nextMedBedsTot" size="4" maxlength="4" style="text-align:right;" readonly="true" />
		        </s:if>
		        <s:else>
		        	<s:textfield cssClass="comTableInputYellow" name="hcoBlkReqDataList[%{#status.index}].nextMedBedsTot" size="4" maxlength="4" style="text-align:right;" readonly="true" />
		        </s:else>
	        </td>
		</tr>
	</s:iterator>
    </table>
</div>
</s:else>
    </td>
    </tr>
            <tr>
	      <td class="comFormTableItem">
	      <table id="formTable01" border="0" class="comPortalTable" align="center" style="width:98%;">
	      <tr>
	        <td style="width: 30%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 16%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 17%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 17%; height: 0px; border-width: 0px;"></td>
	        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
	      </tr>
			<tr>
	      		<td>
                <nobr>
                <input class="comButton" type="button"name="buttonF1" value="戻る" onClick="window.close();" />
                </nobr>
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>
               <nobr>
               	<s:if test='%{btnEnableFlg == "1"}'>
					<input class="comButton" type="button"name="buttonF3" value="一括申請" onClick="reqBtn();JavaScript:return false;" />
				</s:if>
				<s:else>
					&nbsp;
               	</s:else>
               </nobr>
               </td>
           </tr>
         </table>
	      </td>
	  </tr>
  </table>
     	</td>
    </tr>


<%-- メイン部 一覧 終了    key="catDeptsComboDataList[%{#status.index}].addrNameArea" --%>
<!--  <hr class="comSplit" /> -->
<%-- 後制御部 --%>

	</table>

    </tbody>
    </table>
    </s:form>
    </table>
<%-- ポータルボディー 終了 --%>


<%-- メイン部 一覧 終了 --%>
<%-- ポータル大枠 終了 --%>
	<jsp:include page="common/jkrBottom.jsp" flush="true" />
  <%-- ボトム部分をインクルード --%>
  <hr class="comTitle" />
</body>
</html>