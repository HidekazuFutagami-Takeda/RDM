<%--
/**
 * <pre>
 *  施設情報更新のJSP
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
  <title>NF012_施設情報更新</title>
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

    	// 編集不可設定
		onLoadEditSet();

		insClass = document.fm1.insClass.value;
		knrFlg = "0";
		if(document.fm1.loginJokenSetCd.value == "JKN0813"){
			knrFlg = "1";
		}

    	// 初期表示は詳細を閉じる
    	if(knrFlg == "1"){
	    	// フリー項目区分
	    	chngTblView('08');
	    	// 老人福祉法関連分類情報
	    	chngTblView('09');
	    	// 実績把握区分
    		chngTblView('10');
    	}
    	if(insClass == "01"){
	    	// 病院設備
    		chngTblView('11');
    	}
    	if(knrFlg == "1"){
    		if(insClass == "01"){
	    		// 市場規模
    			chngTblView('12');
    		}
	    	// 医療法関連分類
    		chngTblView('13');
    	}
    	if(insClass == "01"){
	    	// 特別な機能情報
    		chngTblView('14');
    		// 医療連携関係
	    	chngTblView('15');
    	}
    	if(knrFlg == "1"){
	    	// ユーザーコード情報
    		chngTblView('16');
    		if(insClass == "01"){
	    		// 診療報酬
    			chngTblView('17');
    		}
    	}
    }

    function onLoadEditSet(){
		editFlg = document.fm1.editApprFlg.value;
		insClass = document.fm1.insClass.value;
		knrFlg = "0";
		if(document.fm1.loginJokenSetCd.value == "JKN0813"){
			knrFlg = "1";
		}

		if(editFlg == "0") {

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

			// 卸色区分
			document.fm1.wsTypeView.value = document.fm1.wsType.options[document.fm1.wsType.selectedIndex].textContent;
			document.fm1.wsType.hidden = "true";

			// 本部一括購入
			document.fm1.basketPurchaseView.value = document.fm1.basketPurchase.options[document.fm1.basketPurchase.selectedIndex].textContent;
			document.fm1.basketPurchase.hidden = "true";

			// 大学細分類
			document.fm1.univSubdivView.value = document.fm1.univSubdiv.options[document.fm1.univSubdiv.selectedIndex].textContent;
			document.fm1.univSubdiv.hidden = "true";

			// 容量別実績把握病院区分
			document.fm1.capaTypeView.value = document.fm1.capaType.options[document.fm1.capaType.selectedIndex].textContent;
			document.fm1.capaType.hidden = "true";

			if(knrFlg == "1"){
				// 老人福祉法関連分類情報
				document.fm1.welfare02View.value = document.fm1.welfare02.options[document.fm1.welfare02.selectedIndex].textContent;
				document.fm1.welfare02.hidden = "true";
				document.fm1.welfare08View.value = document.fm1.welfare08.options[document.fm1.welfare08.selectedIndex].textContent;
				document.fm1.welfare08.hidden = "true";

				// 実績把握区分情報
				document.fm1.result01View.value = document.fm1.result01.options[document.fm1.result01.selectedIndex].textContent;
				document.fm1.result01.hidden = "true";
				document.fm1.result02View.value = document.fm1.result02.options[document.fm1.result02.selectedIndex].textContent;
				document.fm1.result02.hidden = "true";
				document.fm1.result03View.value = document.fm1.result03.options[document.fm1.result03.selectedIndex].textContent;
				document.fm1.result03.hidden = "true";
				document.fm1.result04View.value = document.fm1.result04.options[document.fm1.result04.selectedIndex].textContent;
				document.fm1.result04.hidden = "true";
				document.fm1.result05View.value = document.fm1.result05.options[document.fm1.result05.selectedIndex].textContent;
				document.fm1.result05.hidden = "true";
				document.fm1.result06View.value = document.fm1.result06.options[document.fm1.result06.selectedIndex].textContent;
				document.fm1.result06.hidden = "true";
				document.fm1.result07View.value = document.fm1.result07.options[document.fm1.result07.selectedIndex].textContent;
				document.fm1.result07.hidden = "true";
				document.fm1.result08View.value = document.fm1.result08.options[document.fm1.result08.selectedIndex].textContent;
				document.fm1.result08.hidden = "true";
				document.fm1.result09View.value = document.fm1.result09.options[document.fm1.result09.selectedIndex].textContent;
				document.fm1.result09.hidden = "true";
				document.fm1.result10View.value = document.fm1.result10.options[document.fm1.result10.selectedIndex].textContent;
				document.fm1.result10.hidden = "true";
				document.fm1.result11View.value = document.fm1.result11.options[document.fm1.result11.selectedIndex].textContent;
				document.fm1.result11.hidden = "true";
				document.fm1.result12View.value = document.fm1.result12.options[document.fm1.result12.selectedIndex].textContent;
				document.fm1.result12.hidden = "true";
				document.fm1.result13View.value = document.fm1.result13.options[document.fm1.result13.selectedIndex].textContent;
				document.fm1.result13.hidden = "true";
				document.fm1.result14View.value = document.fm1.result14.options[document.fm1.result14.selectedIndex].textContent;
				document.fm1.result14.hidden = "true";
				document.fm1.result15View.value = document.fm1.result15.options[document.fm1.result15.selectedIndex].textContent;
				document.fm1.result15.hidden = "true";
				document.fm1.result16View.value = document.fm1.result16.options[document.fm1.result16.selectedIndex].textContent;
				document.fm1.result16.hidden = "true";
				document.fm1.result17View.value = document.fm1.result17.options[document.fm1.result17.selectedIndex].textContent;
				document.fm1.result17.hidden = "true";
				document.fm1.result18View.value = document.fm1.result18.options[document.fm1.result18.selectedIndex].textContent;
				document.fm1.result18.hidden = "true";
				document.fm1.result19View.value = document.fm1.result19.options[document.fm1.result19.selectedIndex].textContent;
				document.fm1.result19.hidden = "true";
				document.fm1.result20View.value = document.fm1.result20.options[document.fm1.result20.selectedIndex].textContent;
				document.fm1.result20.hidden = "true";
				document.fm1.result21View.value = document.fm1.result21.options[document.fm1.result21.selectedIndex].textContent;
				document.fm1.result21.hidden = "true";
				document.fm1.result22View.value = document.fm1.result22.options[document.fm1.result22.selectedIndex].textContent;
				document.fm1.result22.hidden = "true";
				document.fm1.result23View.value = document.fm1.result23.options[document.fm1.result23.selectedIndex].textContent;
				document.fm1.result23.hidden = "true";
				document.fm1.result24View.value = document.fm1.result24.options[document.fm1.result24.selectedIndex].textContent;
				document.fm1.result24.hidden = "true";
				document.fm1.result25View.value = document.fm1.result25.options[document.fm1.result25.selectedIndex].textContent;
				document.fm1.result25.hidden = "true";
				document.fm1.result26View.value = document.fm1.result26.options[document.fm1.result26.selectedIndex].textContent;
				document.fm1.result26.hidden = "true";
				document.fm1.result27View.value = document.fm1.result27.options[document.fm1.result27.selectedIndex].textContent;
				document.fm1.result27.hidden = "true";
				document.fm1.result28View.value = document.fm1.result28.options[document.fm1.result28.selectedIndex].textContent;
				document.fm1.result28.hidden = "true";
				document.fm1.result29View.value = document.fm1.result29.options[document.fm1.result29.selectedIndex].textContent;
				document.fm1.result29.hidden = "true";
				document.fm1.result30View.value = document.fm1.result30.options[document.fm1.result30.selectedIndex].textContent;
				document.fm1.result30.hidden = "true";
				document.fm1.result31View.value = document.fm1.result31.options[document.fm1.result31.selectedIndex].textContent;
				document.fm1.result31.hidden = "true";
				document.fm1.result32View.value = document.fm1.result32.options[document.fm1.result32.selectedIndex].textContent;
				document.fm1.result32.hidden = "true";
				document.fm1.result33View.value = document.fm1.result33.options[document.fm1.result33.selectedIndex].textContent;
				document.fm1.result33.hidden = "true";
				document.fm1.result34View.value = document.fm1.result34.options[document.fm1.result34.selectedIndex].textContent;
				document.fm1.result34.hidden = "true";
				document.fm1.result35View.value = document.fm1.result35.options[document.fm1.result35.selectedIndex].textContent;
				document.fm1.result35.hidden = "true";
				document.fm1.result36View.value = document.fm1.result36.options[document.fm1.result36.selectedIndex].textContent;
				document.fm1.result36.hidden = "true";
			}

			if(insClass == "01"){
				// 病院設備情報
				document.fm1.equip01View.value = document.fm1.equip01.options[document.fm1.equip01.selectedIndex].textContent;
				document.fm1.equip01.hidden = "true";
				document.fm1.equip02View.value = document.fm1.equip02.options[document.fm1.equip02.selectedIndex].textContent;
				document.fm1.equip02.hidden = "true";
				document.fm1.equip03View.value = document.fm1.equip03.options[document.fm1.equip03.selectedIndex].textContent;
				document.fm1.equip03.hidden = "true";
				document.fm1.equip07View.value = document.fm1.equip07.options[document.fm1.equip07.selectedIndex].textContent;
				document.fm1.equip07.hidden = "true";
				document.fm1.equip09View.value = document.fm1.equip09.options[document.fm1.equip09.selectedIndex].textContent;
				document.fm1.equip09.hidden = "true";
			}

			if(knrFlg == "1"){
				if(insClass == "01"){
					// 市場規模情報
					document.fm1.market01View.value = document.fm1.market01.options[document.fm1.market01.selectedIndex].textContent;
					document.fm1.market01.hidden = "true";
					document.fm1.market02View.value = document.fm1.market02.options[document.fm1.market02.selectedIndex].textContent;
					document.fm1.market02.hidden = "true";
					document.fm1.market03View.value = document.fm1.market03.options[document.fm1.market03.selectedIndex].textContent;
					document.fm1.market03.hidden = "true";
					document.fm1.market04View.value = document.fm1.market04.options[document.fm1.market04.selectedIndex].textContent;
					document.fm1.market04.hidden = "true";
					document.fm1.market06View.value = document.fm1.market06.options[document.fm1.market06.selectedIndex].textContent;
					document.fm1.market06.hidden = "true";
					document.fm1.market07View.value = document.fm1.market07.options[document.fm1.market07.selectedIndex].textContent;
					document.fm1.market07.hidden = "true";
					document.fm1.market09View.value = document.fm1.market09.options[document.fm1.market09.selectedIndex].textContent;
					document.fm1.market09.hidden = "true";
				}

				// 医療法関連分類情報
				document.fm1.medical12View.value = document.fm1.medical12.options[document.fm1.medical12.selectedIndex].textContent;
				document.fm1.medical12.hidden = "true";
			}

			if(insClass == "01"){
				// 特別な機能情報
				document.fm1.spfunc01View.value = document.fm1.spfunc01.options[document.fm1.spfunc01.selectedIndex].textContent;
				document.fm1.spfunc01.hidden = "true";
				document.fm1.spfunc03View.value = document.fm1.spfunc03.options[document.fm1.spfunc03.selectedIndex].textContent;
				document.fm1.spfunc03.hidden = "true";
				document.fm1.spfunc04View.value = document.fm1.spfunc04.options[document.fm1.spfunc04.selectedIndex].textContent;
				document.fm1.spfunc04.hidden = "true";

				// 医療連携関係情報
				document.fm1.tieup10View.value = document.fm1.tieup10.options[document.fm1.tieup10.selectedIndex].textContent;
				document.fm1.tieup10.hidden = "true";
				document.fm1.tieup11View.value = document.fm1.tieup11.options[document.fm1.tieup11.selectedIndex].textContent;
				document.fm1.tieup11.hidden = "true";
				document.fm1.tieup12View.value = document.fm1.tieup12.options[document.fm1.tieup12.selectedIndex].textContent;
				document.fm1.tieup12.hidden = "true";
			}

			if(knrFlg == "1"){
				// ユーザーコード情報
				document.fm1.usercd0001View.value = document.fm1.usercd0001.options[document.fm1.usercd0001.selectedIndex].textContent;
				document.fm1.usercd0001.hidden = "true";
				document.fm1.usercd0002View.value = document.fm1.usercd0002.options[document.fm1.usercd0002.selectedIndex].textContent;
				document.fm1.usercd0002.hidden = "true";
				document.fm1.usercd0003View.value = document.fm1.usercd0003.options[document.fm1.usercd0003.selectedIndex].textContent;
				document.fm1.usercd0003.hidden = "true";
				document.fm1.usercd0004View.value = document.fm1.usercd0004.options[document.fm1.usercd0004.selectedIndex].textContent;
				document.fm1.usercd0004.hidden = "true";
				document.fm1.usercd0005View.value = document.fm1.usercd0005.options[document.fm1.usercd0005.selectedIndex].textContent;
				document.fm1.usercd0005.hidden = "true";
				document.fm1.usercd0006View.value = document.fm1.usercd0006.options[document.fm1.usercd0006.selectedIndex].textContent;
				document.fm1.usercd0006.hidden = "true";
				document.fm1.usercd0007View.value = document.fm1.usercd0007.options[document.fm1.usercd0007.selectedIndex].textContent;
				document.fm1.usercd0007.hidden = "true";
				document.fm1.usercd0008View.value = document.fm1.usercd0008.options[document.fm1.usercd0008.selectedIndex].textContent;
				document.fm1.usercd0008.hidden = "true";
				document.fm1.usercd0009View.value = document.fm1.usercd0009.options[document.fm1.usercd0009.selectedIndex].textContent;
				document.fm1.usercd0009.hidden = "true";
				document.fm1.usercd0010View.value = document.fm1.usercd0010.options[document.fm1.usercd0010.selectedIndex].textContent;
				document.fm1.usercd0010.hidden = "true";
				document.fm1.usercd0011View.value = document.fm1.usercd0011.options[document.fm1.usercd0011.selectedIndex].textContent;
				document.fm1.usercd0011.hidden = "true";
				document.fm1.usercd0012View.value = document.fm1.usercd0012.options[document.fm1.usercd0012.selectedIndex].textContent;
				document.fm1.usercd0012.hidden = "true";
				document.fm1.usercd0013View.value = document.fm1.usercd0013.options[document.fm1.usercd0013.selectedIndex].textContent;
				document.fm1.usercd0013.hidden = "true";
				document.fm1.usercd0014View.value = document.fm1.usercd0014.options[document.fm1.usercd0014.selectedIndex].textContent;
				document.fm1.usercd0014.hidden = "true";
				document.fm1.usercd0015View.value = document.fm1.usercd0015.options[document.fm1.usercd0015.selectedIndex].textContent;
				document.fm1.usercd0015.hidden = "true";
				document.fm1.usercd0016View.value = document.fm1.usercd0016.options[document.fm1.usercd0016.selectedIndex].textContent;
				document.fm1.usercd0016.hidden = "true";
				document.fm1.usercd0017View.value = document.fm1.usercd0017.options[document.fm1.usercd0017.selectedIndex].textContent;
				document.fm1.usercd0017.hidden = "true";
				document.fm1.usercd0018View.value = document.fm1.usercd0018.options[document.fm1.usercd0018.selectedIndex].textContent;
				document.fm1.usercd0018.hidden = "true";
				document.fm1.usercd0019View.value = document.fm1.usercd0019.options[document.fm1.usercd0019.selectedIndex].textContent;
				document.fm1.usercd0019.hidden = "true";
				document.fm1.usercd0020View.value = document.fm1.usercd0020.options[document.fm1.usercd0020.selectedIndex].textContent;
				document.fm1.usercd0020.hidden = "true";
				document.fm1.usercd0021View.value = document.fm1.usercd0021.options[document.fm1.usercd0021.selectedIndex].textContent;
				document.fm1.usercd0021.hidden = "true";
				document.fm1.usercd0022View.value = document.fm1.usercd0022.options[document.fm1.usercd0022.selectedIndex].textContent;
				document.fm1.usercd0022.hidden = "true";
				document.fm1.usercd0023View.value = document.fm1.usercd0023.options[document.fm1.usercd0023.selectedIndex].textContent;
				document.fm1.usercd0023.hidden = "true";
				document.fm1.usercd0024View.value = document.fm1.usercd0024.options[document.fm1.usercd0024.selectedIndex].textContent;
				document.fm1.usercd0024.hidden = "true";
				document.fm1.usercd0025View.value = document.fm1.usercd0025.options[document.fm1.usercd0025.selectedIndex].textContent;
				document.fm1.usercd0025.hidden = "true";
				document.fm1.usercd0026View.value = document.fm1.usercd0026.options[document.fm1.usercd0026.selectedIndex].textContent;
				document.fm1.usercd0026.hidden = "true";
				document.fm1.usercd0027View.value = document.fm1.usercd0027.options[document.fm1.usercd0027.selectedIndex].textContent;
				document.fm1.usercd0027.hidden = "true";
				document.fm1.usercd0028View.value = document.fm1.usercd0028.options[document.fm1.usercd0028.selectedIndex].textContent;
				document.fm1.usercd0028.hidden = "true";
				document.fm1.usercd0029View.value = document.fm1.usercd0029.options[document.fm1.usercd0029.selectedIndex].textContent;
				document.fm1.usercd0029.hidden = "true";
				document.fm1.usercd0030View.value = document.fm1.usercd0030.options[document.fm1.usercd0030.selectedIndex].textContent;
				document.fm1.usercd0030.hidden = "true";
				document.fm1.usercd0031View.value = document.fm1.usercd0031.options[document.fm1.usercd0031.selectedIndex].textContent;
				document.fm1.usercd0031.hidden = "true";
				document.fm1.usercd0032View.value = document.fm1.usercd0032.options[document.fm1.usercd0032.selectedIndex].textContent;
				document.fm1.usercd0032.hidden = "true";
				document.fm1.usercd0033View.value = document.fm1.usercd0033.options[document.fm1.usercd0033.selectedIndex].textContent;
				document.fm1.usercd0033.hidden = "true";
				document.fm1.usercd0034View.value = document.fm1.usercd0034.options[document.fm1.usercd0034.selectedIndex].textContent;
				document.fm1.usercd0034.hidden = "true";
				document.fm1.usercd0035View.value = document.fm1.usercd0035.options[document.fm1.usercd0035.selectedIndex].textContent;
				document.fm1.usercd0035.hidden = "true";
				document.fm1.usercd0036View.value = document.fm1.usercd0036.options[document.fm1.usercd0036.selectedIndex].textContent;
				document.fm1.usercd0036.hidden = "true";

				if(insClass == "01"){
					// 診療報酬情報
					document.fm1.reward04View.value = document.fm1.reward04.options[document.fm1.reward04.selectedIndex].textContent;
					document.fm1.reward04.hidden = "true";
					document.fm1.reward05View.value = document.fm1.reward05.options[document.fm1.reward05.selectedIndex].textContent;
					document.fm1.reward05.hidden = "true";
					document.fm1.reward08View.value = document.fm1.reward08.options[document.fm1.reward08.selectedIndex].textContent;
					document.fm1.reward08.hidden = "true";
					document.fm1.reward09View.value = document.fm1.reward09.options[document.fm1.reward09.selectedIndex].textContent;
					document.fm1.reward09.hidden = "true";
					document.fm1.reward18View.value = document.fm1.reward18.options[document.fm1.reward18.selectedIndex].textContent;
					document.fm1.reward18.hidden = "true";
					document.fm1.reward21View.value = document.fm1.reward21.options[document.fm1.reward21.selectedIndex].textContent;
					document.fm1.reward21.hidden = "true";
					document.fm1.reward23View.value = document.fm1.reward23.options[document.fm1.reward23.selectedIndex].textContent;
					document.fm1.reward23.hidden = "true";
					document.fm1.reward25View.value = document.fm1.reward25.options[document.fm1.reward25.selectedIndex].textContent;
					document.fm1.reward25.hidden = "true";
					document.fm1.reward26View.value = document.fm1.reward26.options[document.fm1.reward26.selectedIndex].textContent;
					document.fm1.reward26.hidden = "true";
					document.fm1.reward27View.value = document.fm1.reward27.options[document.fm1.reward27.selectedIndex].textContent;
					document.fm1.reward27.hidden = "true";
					document.fm1.reward29View.value = document.fm1.reward29.options[document.fm1.reward29.selectedIndex].textContent;
					document.fm1.reward29.hidden = "true";
					document.fm1.reward35View.value = document.fm1.reward35.options[document.fm1.reward35.selectedIndex].textContent;
					document.fm1.reward35.hidden = "true";
					document.fm1.reward36View.value = document.fm1.reward36.options[document.fm1.reward36.selectedIndex].textContent;
					document.fm1.reward36.hidden = "true";
					document.fm1.reward37View.value = document.fm1.reward37.options[document.fm1.reward37.selectedIndex].textContent;
					document.fm1.reward37.hidden = "true";
					document.fm1.reward44View.value = document.fm1.reward44.options[document.fm1.reward44.selectedIndex].textContent;
					document.fm1.reward44.hidden = "true";
					document.fm1.reward16View.value = document.fm1.reward16.options[document.fm1.reward16.selectedIndex].textContent;
					document.fm1.reward16.hidden = "true";
					document.fm1.reward17View.value = document.fm1.reward17.options[document.fm1.reward17.selectedIndex].textContent;
					document.fm1.reward17.hidden = "true";
				}
			}

		} else {
			document.fm1.tradeTypeView.hidden = "true";
			document.fm1.insOpenYearView.hidden = "true";
			document.fm1.insOpenMonthView.hidden = "true";
			document.fm1.insOpenDayView.hidden = "true";
			document.fm1.wsTypeView.hidden = "true";
			document.fm1.basketPurchaseView.hidden = "true";
			document.fm1.univSubdivView.hidden = "true";
			document.fm1.capaTypeView.hidden = "true";

			if(knrFlg == "1"){
				document.fm1.welfare02View.hidden = "true";
				document.fm1.welfare08View.hidden = "true";
				document.fm1.result01View.hidden = "true";
				document.fm1.result02View.hidden = "true";
				document.fm1.result03View.hidden = "true";
				document.fm1.result04View.hidden = "true";
				document.fm1.result05View.hidden = "true";
				document.fm1.result06View.hidden = "true";
				document.fm1.result07View.hidden = "true";
				document.fm1.result08View.hidden = "true";
				document.fm1.result09View.hidden = "true";
				document.fm1.result10View.hidden = "true";
				document.fm1.result11View.hidden = "true";
				document.fm1.result12View.hidden = "true";
				document.fm1.result13View.hidden = "true";
				document.fm1.result14View.hidden = "true";
				document.fm1.result15View.hidden = "true";
				document.fm1.result16View.hidden = "true";
				document.fm1.result17View.hidden = "true";
				document.fm1.result18View.hidden = "true";
				document.fm1.result19View.hidden = "true";
				document.fm1.result20View.hidden = "true";
				document.fm1.result21View.hidden = "true";
				document.fm1.result22View.hidden = "true";
				document.fm1.result23View.hidden = "true";
				document.fm1.result24View.hidden = "true";
				document.fm1.result25View.hidden = "true";
				document.fm1.result26View.hidden = "true";
				document.fm1.result27View.hidden = "true";
				document.fm1.result28View.hidden = "true";
				document.fm1.result29View.hidden = "true";
				document.fm1.result30View.hidden = "true";
				document.fm1.result31View.hidden = "true";
				document.fm1.result32View.hidden = "true";
				document.fm1.result33View.hidden = "true";
				document.fm1.result34View.hidden = "true";
				document.fm1.result35View.hidden = "true";
				document.fm1.result36View.hidden = "true";
			}

			if(insClass == "01"){
				document.fm1.equip01View.hidden = "true";
				document.fm1.equip02View.hidden = "true";
				document.fm1.equip03View.hidden = "true";
				document.fm1.equip07View.hidden = "true";
				document.fm1.equip09View.hidden = "true";
			}

			if(knrFlg == "1"){
				if(insClass == "01"){
					document.fm1.market01View.hidden = "true";
					document.fm1.market02View.hidden = "true";
					document.fm1.market03View.hidden = "true";
					document.fm1.market04View.hidden = "true";
					document.fm1.market06View.hidden = "true";
					document.fm1.market07View.hidden = "true";
					document.fm1.market09View.hidden = "true";
				}
				document.fm1.medical12View.hidden = "true";
			}

			if(insClass == "01"){
				document.fm1.spfunc01View.hidden = "true";
				document.fm1.spfunc03View.hidden = "true";
				document.fm1.spfunc04View.hidden = "true";
				document.fm1.tieup10View.hidden = "true";
				document.fm1.tieup11View.hidden = "true";
				document.fm1.tieup12View.hidden = "true";
			}

			if(knrFlg == "1"){
				document.fm1.usercd0001View.hidden = "true";
				document.fm1.usercd0002View.hidden = "true";
				document.fm1.usercd0003View.hidden = "true";
				document.fm1.usercd0004View.hidden = "true";
				document.fm1.usercd0005View.hidden = "true";
				document.fm1.usercd0006View.hidden = "true";
				document.fm1.usercd0007View.hidden = "true";
				document.fm1.usercd0008View.hidden = "true";
				document.fm1.usercd0009View.hidden = "true";
				document.fm1.usercd0010View.hidden = "true";
				document.fm1.usercd0011View.hidden = "true";
				document.fm1.usercd0012View.hidden = "true";
				document.fm1.usercd0013View.hidden = "true";
				document.fm1.usercd0014View.hidden = "true";
				document.fm1.usercd0015View.hidden = "true";
				document.fm1.usercd0016View.hidden = "true";
				document.fm1.usercd0017View.hidden = "true";
				document.fm1.usercd0018View.hidden = "true";
				document.fm1.usercd0019View.hidden = "true";
				document.fm1.usercd0020View.hidden = "true";
				document.fm1.usercd0021View.hidden = "true";
				document.fm1.usercd0022View.hidden = "true";
				document.fm1.usercd0023View.hidden = "true";
				document.fm1.usercd0024View.hidden = "true";
				document.fm1.usercd0025View.hidden = "true";
				document.fm1.usercd0026View.hidden = "true";
				document.fm1.usercd0027View.hidden = "true";
				document.fm1.usercd0028View.hidden = "true";
				document.fm1.usercd0029View.hidden = "true";
				document.fm1.usercd0030View.hidden = "true";
				document.fm1.usercd0031View.hidden = "true";
				document.fm1.usercd0032View.hidden = "true";
				document.fm1.usercd0033View.hidden = "true";
				document.fm1.usercd0034View.hidden = "true";
				document.fm1.usercd0035View.hidden = "true";
				document.fm1.usercd0036View.hidden = "true";

				if(insClass == "01"){
					document.fm1.reward04View.hidden = "true";
					document.fm1.reward05View.hidden = "true";
					document.fm1.reward08View.hidden = "true";
					document.fm1.reward09View.hidden = "true";
					document.fm1.reward18View.hidden = "true";
					document.fm1.reward21View.hidden = "true";
					document.fm1.reward23View.hidden = "true";
					document.fm1.reward25View.hidden = "true";
					document.fm1.reward26View.hidden = "true";
					document.fm1.reward27View.hidden = "true";
					document.fm1.reward29View.hidden = "true";
					document.fm1.reward35View.hidden = "true";
					document.fm1.reward36View.hidden = "true";
					document.fm1.reward37View.hidden = "true";
					document.fm1.reward44View.hidden = "true";
					document.fm1.reward16View.hidden = "true";
					document.fm1.reward17View.hidden = "true";
				}
			}
		}
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

	// ULT施設選択ボタン
	function ultInsPopBtn(){
		// NC203_施設検索ポップアップ画面を表示
		window.open("","insPopWindow",insSubScreenSize);
		document.fm1.screenId.value = "NC203";
		document.fm1.functionId.value="Init";
		document.fm1.target="insPopWindow";

		const pCode = document.fm1.insPcode.value;
		document.fm1.insPcode.value = "";
		const pharmType = document.fm1.pharmType.value;
		document.fm1.pharmType.value = "";

		document.fm1.viewKbn.value = "1";
		document.fm1.callBack.value = "callBackUltInsPop";

		comSubmitForAnyWarp(fm1);
		comClickFlgInit();

		document.fm1.insPcode.value = pCode;
		document.fm1.pharmType.value = pharmType;
	}

	// 施設ポップアップからULT施設受け取り
    function callBackUltInsPop(insAbbrName,insFormalName,insNo,insAddr,shisetsuNmRyaku,shisetsuNm,dcfShisetsuCd,address,jgiName,insSbt,hoInsType, insClass){

    	document.fm1.ultInsCd.value = dcfShisetsuCd;
    	document.fm1.shisetsuNmRyaku.value = shisetsuNmRyaku;
    	document.fm1.shisetsuNm.value = shisetsuNm;

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
			// 申請IDで対象を絞り込み申請管理、施設_申請管理を削除

			document.fm1.screenId.value="NF012";
			document.fm1.functionId.value="Cancel";

			comSubmitForAnyWarp(fm1);
		}
	}

	// 一時保存ボタン、申請画面へ、承認・却下画面へボタン
	function submitBtn(funcId){

		document.fm1.preInsAddr.value = document.fm1.preAddrCodePrefName.value + document.fm1.preAddrCodeCityName.value
			+ document.fm1.preInsAddrDt.value;
		document.fm1.insAddr.value = document.fm1.addrCodePrefName.value + document.fm1.addrCodeCityName.value
										+ document.fm1.insAddrDt.value;
		document.fm1.insAddrKana.value = document.fm1.addrCodePrefKana.value + document.fm1.addrCodeCityKana.value
										+ document.fm1.addrDtKana.value;

		document.fm1.funcId.value = funcId;
		document.fm1.screenId.value="NF012";

		if(funcId == "0") {
			// 一時保存
			document.fm1.screenId.value="NF012";
			document.fm1.functionId.value="Register";
		} else if(funcId == "2") {
			// 承認・却下
			document.fm1.screenId.value="NF303";
			document.fm1.functionId.value="ApprRej";
		} else {
			// 申請画面へ
			document.fm1.screenId.value="NF303";
			document.fm1.functionId.value="Init";
		}

		document.fm1.target="";
		comSubmitForAnyWarp(fm1);
	}

	// 審査完了ボタン
	function shnCompBtn(){

		document.fm1.screenId.value="NF012";
		document.fm1.functionId.value="ShnComp";

		document.fm1.target="";
		comSubmitForAnyWarp(fm1);

	}

	// 項目表示・非表示切り替え
	function chngTblView(tblNum){
		const ViewFlgId = "table" + tblNum + "ViewFlg";
		const tableId = "formTable" + tblNum;

		var chngTable = document.getElementById(tableId);
		var chngRows = chngTable.rows;

		// 基本情報の表示・非表示切り替え
		if(document.getElementById(ViewFlgId).value == "1"){
			// 非表示にする
			for (i = 2, len = chngRows.length; i < len; i++) {
				chngRows[i].style.visibility = "collapse";
			}

			document.getElementById(ViewFlgId).value = "0";

		} else {
			// 表示にする
			for (i = 2, len = chngRows.length; i < len; i++) {
				chngRows[i].style.visibility = "visible";
			}

			document.getElementById(ViewFlgId).value = "1";
		}
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
    <s:hidden name="backScreenId" value="NF012" />
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

	<s:hidden name="postCode"/>
	<s:hidden name="callBack"/>
	<s:hidden name="viewKbn"/>
	<s:hidden name="winVarName" value="NF012" />

	<s:hidden name="insNo"/>
	<s:hidden name="insClass"/>
	<s:hidden name="insSbt"/>
	<s:hidden name="editApprFlg"/>

	<%-- 変更前値保持 --%>
	<s:hidden name="preInsAbbrName"/>
	<s:hidden name="preInsKana"/>
	<s:hidden name="preInsFormalName"/>
	<s:hidden name="preTradeType"/>
	<s:hidden name="preInsOpenYear"/>
	<s:hidden name="preInsOpenMonth"/>
	<s:hidden name="preInsOpenDay"/>
	<s:hidden name="preWsType"/>
	<s:hidden name="preBasketPurchase"/>
	<s:hidden name="preUnivSudiv"/>
	<s:hidden name="preCapaType"/>
	<s:hidden name="preUltInsCd"/>
	<s:hidden name="preShisetsuNmRyaku"/>
	<s:hidden name="preShisetsuNm"/>
	<s:hidden name="preInsPcode"/>
	<s:hidden name="preAddrCodePref"/>
	<s:hidden name="preAddrCodePrefName"/>
	<s:hidden name="preAddrCodeCity"/>
	<s:hidden name="preAddrCodeCityName"/>
	<s:hidden name="preInsAddrDt"/>
	<s:hidden name="preInsAddr"/>
	<s:hidden name="preInsAddrKana"/>
	<s:hidden name="preTkCityCd"/>
	<s:hidden name="preInsPhone1"/>
	<s:hidden name="preInsFax1"/>
	<s:hidden name="preInsPhone2"/>
	<s:hidden name="preInsFax2"/>
	<s:hidden name="preInsUrl"/>
	<s:hidden name="preInsUrlYmd"/>
	<s:hidden name="preFree0001"/>
	<s:hidden name="preFree0002"/>
	<s:hidden name="preFree0003"/>
	<s:hidden name="preFree0004"/>
	<s:hidden name="preFree0005"/>
	<s:hidden name="preFree0006"/>
	<s:hidden name="preFree0007"/>
	<s:hidden name="preFree0008"/>
	<s:hidden name="preFree0009"/>
	<s:hidden name="preFree0010"/>
	<s:hidden name="preFree0011"/>
	<s:hidden name="preFree0012"/>
	<s:hidden name="preFree0013"/>
	<s:hidden name="preFree0014"/>
	<s:hidden name="preFree0015"/>
	<s:hidden name="preWelfare02"/>
	<s:hidden name="preWelfare08"/>
	<s:hidden name="preResult01"/>
	<s:hidden name="preResult02"/>
	<s:hidden name="preResult03"/>
	<s:hidden name="preResult04"/>
	<s:hidden name="preResult05"/>
	<s:hidden name="preResult06"/>
	<s:hidden name="preResult07"/>
	<s:hidden name="preResult08"/>
	<s:hidden name="preResult09"/>
	<s:hidden name="preResult10"/>
	<s:hidden name="preResult11"/>
	<s:hidden name="preResult12"/>
	<s:hidden name="preResult13"/>
	<s:hidden name="preResult14"/>
	<s:hidden name="preResult15"/>
	<s:hidden name="preResult16"/>
	<s:hidden name="preResult17"/>
	<s:hidden name="preResult18"/>
	<s:hidden name="preResult19"/>
	<s:hidden name="preResult20"/>
	<s:hidden name="preResult21"/>
	<s:hidden name="preResult22"/>
	<s:hidden name="preResult23"/>
	<s:hidden name="preResult24"/>
	<s:hidden name="preResult25"/>
	<s:hidden name="preResult26"/>
	<s:hidden name="preResult27"/>
	<s:hidden name="preResult28"/>
	<s:hidden name="preResult30"/>
	<s:hidden name="preResult31"/>
	<s:hidden name="preResult32"/>
	<s:hidden name="preResult33"/>
	<s:hidden name="preResult34"/>
	<s:hidden name="preResult35"/>
	<s:hidden name="preResult36"/>
	<s:hidden name="preEquip01"/>
	<s:hidden name="preEquip02"/>
	<s:hidden name="preEquip03"/>
	<s:hidden name="preEquip07"/>
	<s:hidden name="preEquip09"/>
	<s:hidden name="preMarket01"/>
	<s:hidden name="preMarket02"/>
	<s:hidden name="preMarket03"/>
	<s:hidden name="preMarket04"/>
	<s:hidden name="preMarket06"/>
	<s:hidden name="preMarket07"/>
	<s:hidden name="preMarket09"/>
	<s:hidden name="preMedical12"/>
	<s:hidden name="preSpfunc01"/>
	<s:hidden name="preSpfunc03"/>
	<s:hidden name="preSpfunc04"/>
	<s:hidden name="preTieup10"/>
	<s:hidden name="preTieup11"/>
	<s:hidden name="preTieup12"/>
	<s:hidden name="preUsercd0001"/>
	<s:hidden name="preUsercd0002"/>
	<s:hidden name="preUsercd0003"/>
	<s:hidden name="preUsercd0004"/>
	<s:hidden name="preUsercd0005"/>
	<s:hidden name="preUsercd0006"/>
	<s:hidden name="preUsercd0007"/>
	<s:hidden name="preUsercd0008"/>
	<s:hidden name="preUsercd0009"/>
	<s:hidden name="preUsercd0010"/>
	<s:hidden name="preUsercd0011"/>
	<s:hidden name="preUsercd0012"/>
	<s:hidden name="preUsercd0013"/>
	<s:hidden name="preUsercd0014"/>
	<s:hidden name="preUsercd0015"/>
	<s:hidden name="preUsercd0016"/>
	<s:hidden name="preUsercd0017"/>
	<s:hidden name="preUsercd0018"/>
	<s:hidden name="preUsercd0019"/>
	<s:hidden name="preUsercd0020"/>
	<s:hidden name="preUsercd0021"/>
	<s:hidden name="preUsercd0022"/>
	<s:hidden name="preUsercd0023"/>
	<s:hidden name="preUsercd0024"/>
	<s:hidden name="preUsercd0025"/>
	<s:hidden name="preUsercd0026"/>
	<s:hidden name="preUsercd0027"/>
	<s:hidden name="preUsercd0028"/>
	<s:hidden name="preUsercd0029"/>
	<s:hidden name="preUsercd0030"/>
	<s:hidden name="preUsercd0031"/>
	<s:hidden name="preUsercd0032"/>
	<s:hidden name="preUsercd0033"/>
	<s:hidden name="preUsercd0034"/>
	<s:hidden name="preUsercd0035"/>
	<s:hidden name="preUsercd0036"/>
	<s:hidden name="preUsercd0101"/>
	<s:hidden name="preUsercd0102"/>
	<s:hidden name="preUsercd0103"/>
	<s:hidden name="preUsercd0104"/>
	<s:hidden name="preUsercd0105"/>
	<s:hidden name="preUsercd0106"/>
	<s:hidden name="preUsercd0107"/>
	<s:hidden name="preUsercd0108"/>
	<s:hidden name="preUsercd0109"/>
	<s:hidden name="preUsercd0201"/>
	<s:hidden name="preUsercd0202"/>
	<s:hidden name="preUsercd0203"/>
	<s:hidden name="preUsercd0204"/>
	<s:hidden name="preUsercd0205"/>
	<s:hidden name="preUsercd0206"/>
	<s:hidden name="preReward04"/>
	<s:hidden name="preReward05"/>
	<s:hidden name="preReward08"/>
	<s:hidden name="preReward09"/>
	<s:hidden name="preReward16"/>
	<s:hidden name="preReward17"/>
	<s:hidden name="preReward18"/>
	<s:hidden name="preReward21"/>
	<s:hidden name="preReward23"/>
	<s:hidden name="preReward25"/>
	<s:hidden name="preReward26"/>
	<s:hidden name="preReward27"/>
	<s:hidden name="preReward29"/>
	<s:hidden name="preReward35"/>
	<s:hidden name="preReward36"/>
	<s:hidden name="preReward37"/>
	<s:hidden name="preReward44"/>
	<s:hidden name="preTradeTypeNm"/>
	<s:hidden name="prePharmType"/>
	<s:hidden name="prePharmTypeNm"/>
	<s:hidden name="pharmType"/>
	<s:hidden name="pharmTypeNm"/>
	<s:hidden name="preInsRank"/>
	<s:hidden name="preInsRankNm"/>
	<s:hidden name="insRank"/>
	<s:hidden name="insRankNm"/>
	<s:hidden name="preRegVisType"/>
	<s:hidden name="preRegVisTypeNm"/>
	<s:hidden name="regVisType"/>
	<s:hidden name="regVisTypeNm"/>
	<s:hidden name="preManageCd"/>
	<s:hidden name="preManageNm"/>
	<s:hidden name="manageCd"/>
	<s:hidden name="manageNm"/>
	<s:hidden name="preWsTypeNm"/>
	<s:hidden name="preBasketPurchaseNm"/>
	<s:hidden name="preUnivSubdiv"/>
	<s:hidden name="preUnivSubdivNm"/>
	<s:hidden name="preCapaTypeNm"/>
	<s:hidden name="bedCntBase"/>
	<s:hidden name="bedCnt01"/>
	<s:hidden name="bedCnt02"/>
	<s:hidden name="bedCnt03"/>
	<s:hidden name="bedCnt04"/>
	<s:hidden name="bedCnt05"/>
	<s:hidden name="bedCnt06"/>
	<s:hidden name="bedCnt07"/>
	<s:hidden name="bedsTot"/>
	<s:hidden name="medBedsTot"/>
	<s:hidden name="ultBedCnt01"/>
	<s:hidden name="ultBedCnt03"/>
	<s:hidden name="ultBedCnt04"/>
	<s:hidden name="ultBedCnt05"/>
	<s:hidden name="ultBedCnt07"/>
	<s:hidden name="ultBedsTot"/>
	<s:hidden name="nextBedCntBase"/>
	<s:hidden name="nextBedCnt01"/>
	<s:hidden name="nextBedCnt02"/>
	<s:hidden name="nextBedCnt03"/>
	<s:hidden name="nextBedCnt04"/>
	<s:hidden name="nextBedCnt05"/>
	<s:hidden name="nextBedCnt06"/>
	<s:hidden name="nextBedCnt07"/>
	<s:hidden name="nextBedsTot"/>
	<s:hidden name="nextMedBedsTot"/>
	<s:hidden name="preTkCityName"/>
	<s:hidden name="preWelfare02Nm"/>
	<s:hidden name="preWelfare08Nm"/>
	<s:hidden name="preResult01Nm"/>
	<s:hidden name="preResult02Nm"/>
	<s:hidden name="preResult03Nm"/>
	<s:hidden name="preResult04Nm"/>
	<s:hidden name="preResult05Nm"/>
	<s:hidden name="preResult06Nm"/>
	<s:hidden name="preResult07Nm"/>
	<s:hidden name="preResult08Nm"/>
	<s:hidden name="preResult09Nm"/>
	<s:hidden name="preResult10Nm"/>
	<s:hidden name="preResult11Nm"/>
	<s:hidden name="preResult12Nm"/>
	<s:hidden name="preResult13Nm"/>
	<s:hidden name="preResult14Nm"/>
	<s:hidden name="preResult15Nm"/>
	<s:hidden name="preResult16Nm"/>
	<s:hidden name="preResult17Nm"/>
	<s:hidden name="preResult18Nm"/>
	<s:hidden name="preResult19Nm"/>
	<s:hidden name="preResult20Nm"/>
	<s:hidden name="preResult21Nm"/>
	<s:hidden name="preResult22Nm"/>
	<s:hidden name="preResult23Nm"/>
	<s:hidden name="preResult24Nm"/>
	<s:hidden name="preResult25Nm"/>
	<s:hidden name="preResult26Nm"/>
	<s:hidden name="preResult27Nm"/>
	<s:hidden name="preResult28Nm"/>
	<s:hidden name="preResult30Nm"/>
	<s:hidden name="preResult31Nm"/>
	<s:hidden name="preResult32Nm"/>
	<s:hidden name="preResult33Nm"/>
	<s:hidden name="preResult34Nm"/>
	<s:hidden name="preResult35Nm"/>
	<s:hidden name="preResult36Nm"/>
	<s:hidden name="preEquip01Nm"/>
	<s:hidden name="preEquip02Nm"/>
	<s:hidden name="preEquip03Nm"/>
	<s:hidden name="preEquip07Nm"/>
	<s:hidden name="preEquip09Nm"/>
	<s:hidden name="preMarket01Nm"/>
	<s:hidden name="preMarket02Nm"/>
	<s:hidden name="preMarket03Nm"/>
	<s:hidden name="preMarket04Nm"/>
	<s:hidden name="preMarket06Nm"/>
	<s:hidden name="preMarket07Nm"/>
	<s:hidden name="preMarket09Nm"/>
	<s:hidden name="preMedical12Nm"/>
	<s:hidden name="preSpfunc01Nm"/>
	<s:hidden name="preSpfunc03Nm"/>
	<s:hidden name="preSpfunc04Nm"/>
	<s:hidden name="preTieup10Nm"/>
	<s:hidden name="preTieup11Nm"/>
	<s:hidden name="preTieup12Nm"/>
	<s:hidden name="preUsercd0001Nm"/>
	<s:hidden name="preUsercd0002Nm"/>
	<s:hidden name="preUsercd0003Nm"/>
	<s:hidden name="preUsercd0004Nm"/>
	<s:hidden name="preUsercd0005Nm"/>
	<s:hidden name="preUsercd0006Nm"/>
	<s:hidden name="preUsercd0007Nm"/>
	<s:hidden name="preUsercd0008Nm"/>
	<s:hidden name="preUsercd0009Nm"/>
	<s:hidden name="preUsercd0010Nm"/>
	<s:hidden name="preUsercd0011Nm"/>
	<s:hidden name="preUsercd0012Nm"/>
	<s:hidden name="preUsercd0013Nm"/>
	<s:hidden name="preUsercd0014Nm"/>
	<s:hidden name="preUsercd0015Nm"/>
	<s:hidden name="preUsercd0016Nm"/>
	<s:hidden name="preUsercd0017Nm"/>
	<s:hidden name="preUsercd0018Nm"/>
	<s:hidden name="preUsercd0019Nm"/>
	<s:hidden name="preUsercd0020Nm"/>
	<s:hidden name="preUsercd0021Nm"/>
	<s:hidden name="preUsercd0022Nm"/>
	<s:hidden name="preUsercd0023Nm"/>
	<s:hidden name="preUsercd0024Nm"/>
	<s:hidden name="preUsercd0025Nm"/>
	<s:hidden name="preUsercd0026Nm"/>
	<s:hidden name="preUsercd0027Nm"/>
	<s:hidden name="preUsercd0028Nm"/>
	<s:hidden name="preUsercd0029Nm"/>
	<s:hidden name="preUsercd0030Nm"/>
	<s:hidden name="preUsercd0031Nm"/>
	<s:hidden name="preUsercd0032Nm"/>
	<s:hidden name="preUsercd0033Nm"/>
	<s:hidden name="preUsercd0034Nm"/>
	<s:hidden name="preUsercd0035Nm"/>
	<s:hidden name="preUsercd0036Nm"/>
	<s:hidden name="preReward04Nm"/>
	<s:hidden name="preReward05Nm"/>
	<s:hidden name="preReward08Nm"/>
	<s:hidden name="preReward09Nm"/>
	<s:hidden name="preReward16Nm"/>
	<s:hidden name="preReward17Nm"/>
	<s:hidden name="preReward18Nm"/>
	<s:hidden name="preReward21Nm"/>
	<s:hidden name="preReward23Nm"/>
	<s:hidden name="preReward25Nm"/>
	<s:hidden name="preReward26Nm"/>
	<s:hidden name="preReward27Nm"/>
	<s:hidden name="preReward29Nm"/>
	<s:hidden name="preReward35Nm"/>
	<s:hidden name="preReward36Nm"/>
	<s:hidden name="preReward37Nm"/>
	<s:hidden name="preReward44Nm"/>


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
        <td class="comPortalTitleIcon"><img class="comSmallIcon" src="img/mrinsdoc.gif" alt="施設情報更新"></td>
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
	      <td class="comFormTableItem"><nobr>施設固定C</nobr></td>
	      <td class="comFormTableItem"><nobr><s:label key="insNo"/></nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
      </tr>
  </table>
  <br/>
    <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable03" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
  	<tr>
        <%--変更前後見出し--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
      </tr>
      <tr>
	      <td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>変更前</nobr></td>
	      <td class="comFormTableItemNf012Head"><nobr>変更後</nobr></td>
	　　</tr>
  </table>

  <hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
  <table id="formTable04" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
    <tr>
        <%--基本情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>基本情報</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">施設略式漢字名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsAbbrName" /></td>
		<td class="comFormTableItemNf012"><nobr>
			<s:if test='%{editApprFlg == "1"}'>
				<s:textfield name="insAbbrName" size="30" maxlength="60" />　(全角)
			</s:if>
			<s:else>
				<s:textfield name="insAbbrName" size="30" maxlength="60" readonly="true" />　(全角)
			</s:else>
			</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">施設カナ名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsKana" /></td>
		<td class="comFormTableItemNf012"><nobr>
			<s:if test='%{editApprFlg == "1"}'>
				<s:textfield name="insKana" size="30" maxlength="45" />　(半角)
			</s:if>
			<s:else>
				<s:textfield name="insKana" size="30" maxlength="45" readonly="true" />　(半角)
			</s:else>
			</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">施設正式漢字名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsFormalName" /></td>
		<td class="comFormTableItemNf012"><nobr>
			<s:if test='%{editApprFlg == "1"}'>
				<s:textarea name="insFormalName" style="width:220px; height:40px; resize: none;" maxlength="240" />　(全角)
			</s:if>
			<s:else>
				<s:textarea name="insFormalName" style="width:220px; height:40px; resize: none;" maxlength="240" readonly="true" />　(全角)
			</s:else>
			</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">取引区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTradeType" />：<s:label key="preTradeTypeNm" /></td>
		<td class="comFormTableItemNf012">
		<nobr>
			<s:select id="tradeType" name="tradeType" cssStyle="width:120pt" list ="tradeTypeCombo"/>
			<s:textfield id="tradeTypeView" name="tradeTypeView" cssStyle="width:120pt" readonly="true" />
		</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">開業年月日</td>
	   	<td class="comFormTableItemNf012">
	   		<nobr>
	   			<s:label key="preInsOpenYear"/>
	      		年
	      		<s:label key="preInsOpenMonth"/>
	      		月
	      		<s:if test='%{preInsOpenDay != null && preInsOpenDay != ""}'>
	      		<s:label key="preInsOpenDay"/>
	      		日
	      		</s:if>
	   		</nobr>
	   	</td>
		<td class="comFormTableItemNf012">
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
	</tr>
	<tr>
		<td class="comFormTableItem">施設区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="prePharmType" />：<s:label key="prePharmTypeNm" /></td>
		<td class="comFormTableItemNf012"><font color="dodgerblue">（来期）<s:label key="pharmType" />：<s:label key="pharmTypeNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">階級区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsRank" />：<s:label key="preInsRankNm" /></td>
		<td class="comFormTableItemNf012"><font color="dodgerblue">（来期）<s:label key="insRank" />：<s:label key="insRankNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">定訪先区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preRegVisType" />：<s:label key="preRegVisTypeNm" /></td>
		<td class="comFormTableItemNf012"><font color="dodgerblue">（来期）<s:label key="regVisType" />：<s:label key="regVisTypeNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">経営主体</td>
	   	<td class="comFormTableItemNf012"><s:label key="preManageCd" />：<s:label key="preManageNm" /></td>
		<td class="comFormTableItemNf012"><font color="dodgerblue">（来期）<s:label key="manageCd" />：<s:label key="manageNm" /></font></td>
	</tr>
	<tr>
		<td class="comFormTableItem">卸色区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preWsTypeNm" /></td>
		<td class="comFormTableItemNf012"><nobr>
			<s:select id="wsType" name="wsType" cssStyle="width:120pt" list ="wsTypeCombo"/>
			<s:textfield id="wsTypeView" name="wsTypeView" cssStyle="width:120pt" readonly="true" />
		</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">本部一括購入</td>
	   	<td class="comFormTableItemNf012"><s:label key="preBasketPurchaseNm" /></td>
		<td class="comFormTableItemNf012"><nobr>
			<s:select id="basketPurchase" name="basketPurchase" cssStyle="width:120pt" list ="basketPurchaseCombo"/>
			<s:textfield id="basketPurchaseView" name="basketPurchaseView" cssStyle="width:120pt" readonly="true" />
		</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">大学細分類</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUnivSubdivNm" /></td>
		<td class="comFormTableItemNf012"><nobr>
			<s:select id="univSubdiv" name="univSubdiv" cssStyle="width:120pt" list ="univSubdivCombo"/>
			<s:textfield id="univSubdivView" name="univSubdivView" cssStyle="width:120pt" readonly="true" />
		</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">容量別実績把握病院区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preCapaTypeNm" /></td>
		<td class="comFormTableItemNf012"><nobr>
			<s:select id="capaType" name="capaType" cssStyle="width:120pt" list ="capaTypeCombo"/>
			<s:textfield id="capaTypeView" name="capaTypeView" cssStyle="width:120pt" readonly="true" />
		</nobr></td>
	</tr>
  </table>
	<br/>
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable05" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--ULT施設情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">ULT施設情報</td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ULT施設コード</td>
	   	<td class="comFormTableItemNf012"><s:label key="ultInsCd" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{loginJokenSetCd == "JKN0813"}'>
					<s:if test='%{editApprFlg == "1"}'>
						<input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:ultInsPopBtn(); return false;" />
                	</s:if>
                	<s:else>
                		<input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:ultInsPopBtn(); return false;" disabled />
                	</s:else>
                </s:if>
                <s:else>
                	<input class="comButton" type="button"name="button1" value="選択" onClick="JavaScript:ultInsPopBtn(); return false;" disabled />
                </s:else>
                <s:textfield name="ultInsCd" id="ultInsCd" size="20" style="background-color:#D4D0C8" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ULT施設略名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preShisetsuNmRyaku" /></td>
		<td class="comFormTableItemNf012"><nobr><s:textfield name="shisetsuNmRyaku" size="30" maxlength="60" style="background-color:#D4D0C8" readonly="true" /></nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ULT施設名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preShisetsuNm" /></td>
		<td class="comFormTableItemNf012"><nobr><s:textarea name="shisetsuNm" style="width:220px; height:40px; resize: none; background-color:#D4D0C8" readonly="true" />　</nobr></td>
	</tr>
	</table>
	<br/>
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable06" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--病床数情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 26%; height: 0px; border-width: 0px;"></td>
        <td style="width: 27%; height: 0px; border-width: 0px;"></td>
        <td style="width: 27%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">病床数情報</td>
		<td class="comFormTableItem" style="text-align : center;"><nobr>現状</nobr></td>
		<td class="comFormTableItem" style="text-align : center;"><nobr>アルトマーク病床数情報</nobr></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><nobr>（来期）病床数情報</nobr></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">基準</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCntBase" /></td>
		<td class="comFormTableItem" style="text-align : center;">&nbsp;</td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCntBase" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">結核</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt04" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt04" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt04" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">一般</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt01" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt01" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt01" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">感染症</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt05" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt05" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt05" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">精神</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt03" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt03" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt03" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">療養</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt07" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedCnt07" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt07" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">医療療養</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt02" /></td>
		<td class="comFormTableItem" style="text-align : center;">&nbsp;</td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt02" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">介護療養</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedCnt06" /></td>
		<td class="comFormTableItem" style="text-align : center;">&nbsp;</td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedCnt06" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ベッド数計</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="bedsTot" /></td>
		<td class="comFormTableItem" style="text-align : center;"><s:label key="ultBedsTot" /></td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextBedsTot" /></font></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">医療ベッド数計</td>
	   	<td class="comFormTableItemNf012" style="text-align : center;"><s:label key="medBedsTot" /></td>
		<td class="comFormTableItem" style="text-align : center;">&nbsp;</td>
		<td class="comFormTableItem" style="text-align : center;"><font color="dodgerblue"><s:label key="nextMedBedsTot" /></font></td>
	</tr>
	</table>
	<br/>
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable07" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--住所詳細--%>
        <s:hidden name="insAddr"/>
        <s:hidden name="insAddrKana"/>
        <s:hidden name="addrCodePrefKana" />
        <s:hidden name="addrCodeCityKana" />
        <s:hidden name="addrDtKana" />

        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">住所詳細</td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">郵便番号</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsPcode" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="insPcode" id="insPcode" size="20" />
					<input class="comButton" type="button"name="button1" value="住所候補" onClick="JavaScript:addrPopBtn(); return false;" />
				</s:if>
				<s:else>
	                <s:textfield name="insPcode" id="insPcode" size="20" readonly="true" />
					<input class="comButton" type="button"name="button1" value="住所候補" onClick="JavaScript:addrPopBtn(); return false;" disabled />
				</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">JIS県名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preAddrCodePrefName" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:textfield name="addrCodePrefName" id="addrCodePrefName" size="20" style="background-color:#D4D0C8" readonly="true" />
                <s:hidden name="addrCodePref" id="addrCodePref"/>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">JIS市区町村名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preAddrCodeCityName" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:textfield name="addrCodeCityName" id="addrCodeCityName" size="20" style="background-color:#D4D0C8" readonly="true" />
                <s:hidden name="addrCodeCity" id="addrCodeCity"/>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">町名地番</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsAddrDt" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="insAddrDt" id="insAddrDt" size="50" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="insAddrDt" id="insAddrDt" size="50" readonly="true" />
	            </s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">武田市区郡名</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTkCityName" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:textfield name="tkCityName" id="tkCityName" size="20" style="background-color:#D4D0C8" readonly="true" />
                <s:hidden name="tkCityCd" id="tkCityCd"/>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">電話番号(代表)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsPhone1" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="insPhone1" id="insPhone1" size="20" /> (ﾊｲﾌﾝあり)
	            </s:if>
	            <s:else>
	            	<s:textfield name="insPhone1" id="insPhone1" size="20" readonly="true" /> (ﾊｲﾌﾝあり)
	            </s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">電話番号(薬局/DI室)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsPhone2" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="insPhone2" id="insPhone2" size="20" /> (ﾊｲﾌﾝあり)
				</s:if>
				<s:else>
					<s:textfield name="insPhone2" id="insPhone2" size="20" readonly="true" /> (ﾊｲﾌﾝあり)
				</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">FAX番号(代表)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsFax1" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="insFax1" id="insFax1" size="20" /> (ﾊｲﾌﾝあり)
	            </s:if>
	            <s:else>
	            	<s:textfield name="insFax1" id="insFax1" size="20" readonly="true" /> (ﾊｲﾌﾝあり)
	            </s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">FAX番号(薬局/DI室)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsFax2" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="insFax2" id="insFax2" size="20" /> (ﾊｲﾌﾝあり)
	            </s:if>
	            <s:else>
	            	<s:textfield name="insFax2" id="insFax2" size="20" readonly="true" /> (ﾊｲﾌﾝあり)
	            </s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ホームページアドレス(変更前)</td>
	   	<td class="comFormTableItemNf012" colSpan="2">
	   		<nobr>
	   		<s:label key="preInsUrl" />
	   		<input class="comButton" type="button"name="button2" value="表示" onClick="JavaScript:window.open(document.fm1.preInsUrl.value, '_blank');return false;" />
	   		</nobr>
	   	</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">　　　　　　　　　　　　(変更後)</td>
	   	<td class="comFormTableItemNf012" colSpan="2">
	   		<nobr>
	   			<s:if test='%{editApprFlg == "1"}'>
			   		<s:textarea name="insUrl" style="width:500px; height:20px; resize: none;" />
			   	</s:if>
			   	<s:else>
			   		<s:textarea name="insUrl" style="width:500px; height:20px; resize: none;" readonly="true" />
			   	</s:else>
	   		</nobr>
	   	</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ホームページアドレス更新日</td>
	   	<td class="comFormTableItemNf012"><s:label key="preInsUrlYmd" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
                	<s:textfield type="date" name="insUrlYmd" id="insUrlYmd" size="20" />
                </s:if>
                <s:else>
                	<s:textfield type="date" name="insUrlYmd" id="insUrlYmd" size="20" readonly="true" />
                </s:else>
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table08ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable08" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--フリー項目区分情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
		<td class="comFormTableItem">
			<nobr>
				<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('08');return false;">フリー項目区分情報</a>
			</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">DM先(TKP-LDA)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0001" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0001" id="free0001" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0001" id="free0001" size="20" readonly="true" />
	            </s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">LEUあすか</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0002" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
                	<s:textfield name="free0002" id="free0002" size="20" />
                </s:if>
                <s:else>
                	<s:textfield name="free0002" id="free0002" size="20" readonly="true" />
                </s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">DM先(TKP-NSAID)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0003" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0003" id="free0003" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0003" id="free0003" size="20" readonly="true" />
	            </s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">（O：未使用）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0015" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0015" id="free0015" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0015" id="free0015" size="20" readonly="true" />
	            </s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">TRIアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0008" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0008" id="free0008" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0008" id="free0008" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">TRIアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0009" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0009" id="free0009" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0009" id="free0009" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">REMアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0004" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0004" id="free0004" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0004" id="free0004" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">REMアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0005" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0005" id="free0005" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0005" id="free0005" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ENBアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0006" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0006" id="free0006" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0006" id="free0006" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ENBアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0007" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0007" id="free0007" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0007" id="free0007" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">XELアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0010" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0010" id="free0010" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0010" id="free0010" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">XELアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0011" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0011" id="free0011" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0011" id="free0011" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ROZアロ登録（当期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0013" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0013" id="free0013" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0013" id="free0013" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">ROZアロ登録（来期）</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0014" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0014" id="free0014" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0014" id="free0014" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">振替先1310</td>
	   	<td class="comFormTableItemNf012"><s:label key="preFree0012" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="free0012" id="free0012" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="free0012" id="free0012" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table09ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable09" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--老人福祉法関連分類情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('09');return false;">老人福祉法関連分類情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">老人短期入所施設</td>
	   	<td class="comFormTableItemNf012"><s:label key="preWelfare02Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="welfare02" name="welfare02" cssStyle="width:120pt" list ="welfare02Combo"/>
                <s:textfield id="welfare02View" name="welfare02View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">その他</td>
	   	<td class="comFormTableItemNf012"><s:label key="preWelfare08Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="welfare08" name="welfare08" cssStyle="width:120pt" list ="welfare08Combo"/>
                <s:textfield id="welfare08View" name="welfare08View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table10ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable10" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--実績把握区分情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('10');return false;">実績把握区分情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T ARB ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult01Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result01" name="result01" cssStyle="width:120pt" list ="result01Combo"/>
                <s:textfield id="result01View" name="result01View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T DPP4 ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult02Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result02" name="result02" cssStyle="width:120pt" list ="result02Combo"/>
                <s:textfield id="result02View" name="result02View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T ω3 ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult03Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result03" name="result03" cssStyle="width:120pt" list ="result03Combo"/>
                <s:textfield id="result03View" name="result03View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T PPI ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult04Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result04" name="result04" cssStyle="width:120pt" list ="result04Combo"/>
                <s:textfield id="result04View" name="result04View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T 睡眠 ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult05Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result05" name="result05" cssStyle="width:120pt" list ="result05Combo"/>
                <s:textfield id="result05View" name="result05View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T アルツハイマー ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult06Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result06" name="result06" cssStyle="width:120pt" list ="result06Combo"/>
                <s:textfield id="result06View" name="result06View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">En-T 骨粗鬆症 ('18.11)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult07Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result07" name="result07" cssStyle="width:120pt" list ="result07Combo"/>
                <s:textfield id="result07View" name="result07View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">REMターゲット</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult08Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result08" name="result08" cssStyle="width:120pt" list ="result08Combo"/>
                <s:textfield id="result08View" name="result08View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">BLP未獲得市場区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult09Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result09" name="result09" cssStyle="width:120pt" list ="result09Combo"/>
                <s:textfield id="result09View" name="result09View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">整形育成先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult10Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result10" name="result10" cssStyle="width:120pt" list ="result10Combo"/>
                <s:textfield id="result10View" name="result10View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">TKP・MSコールUP</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult11Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result11" name="result11" cssStyle="width:120pt" list ="result11Combo"/>
                <s:textfield id="result1View" name="result11View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ALC Core1・2('19.10)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult12Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result12" name="result12" cssStyle="width:120pt" list ="result12Combo"/>
                <s:textfield id="result12View" name="result12View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ENT Tier1-4('19.4)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult13Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result13" name="result13" cssStyle="width:120pt" list ="result13Combo"/>
                <s:textfield id="result13View" name="result13View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">JIA厚労省施設</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult14Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result14" name="result14" cssStyle="width:120pt" list ="result14Combo"/>
                <s:textfield id="result14View" name="result14View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">注力先('18.12)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult15Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result15" name="result15" cssStyle="width:120pt" list ="result15Combo"/>
                <s:textfield id="result15View" name="result15View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ENBターゲット先('19.4)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult16Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result16" name="result16" cssStyle="width:120pt" list ="result16Combo"/>
                <s:textfield id="result16View" name="result16View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨G</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult17Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result17" name="result17" cssStyle="width:120pt" list ="result17Combo"/>
                <s:textfield id="result17View" name="result17View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ナテグリニド繁用先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult18Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result18" name="result18" cssStyle="width:120pt" list ="result18Combo"/>
                <s:textfield id="result18View" name="result18View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">GLUターゲット先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult19Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result19" name="result19" cssStyle="width:120pt" list ="result19Combo"/>
                <s:textfield id="result19View" name="result19View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨G2</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult20Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result20" name="result20" cssStyle="width:120pt" list ="result20Combo"/>
                <s:textfield id="result20View" name="result20View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(U:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult21Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result21" name="result21" cssStyle="width:120pt" list ="result21Combo"/>
                <s:textfield id="result21View" name="result21View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">DOIT3</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult22Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result22" name="result22" cssStyle="width:120pt" list ="result22Combo"/>
                <s:textfield id="result22View" name="result22View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">PCI300</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult23Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result23" name="result23" cssStyle="width:120pt" list ="result23Combo"/>
                <s:textfield id="result23View" name="result23View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">JDEsART</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult24Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result24" name="result24" cssStyle="width:120pt" list ="result24Combo"/>
                <s:textfield id="result24View" name="result24View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(Y:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult25Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result25" name="result25" cssStyle="width:120pt" list ="result25Combo"/>
                <s:textfield id="result25View" name="result25View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">TAP先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult26Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result26" name="result26" cssStyle="width:120pt" list ="result26Combo"/>
                <s:textfield id="result26View" name="result26View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">QOL2005TKP</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult27Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result27" name="result27" cssStyle="width:120pt" list ="result27Combo"/>
                <s:textfield id="result27View" name="result27View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">TKP未獲得市場区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult28Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result28" name="result28" cssStyle="width:120pt" list ="result28Combo"/>
                <s:textfield id="result28View" name="result28View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ACT未獲得市場区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult29Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result29" name="result29" cssStyle="width:120pt" list ="result29Combo"/>
                <s:textfield id="result29View" name="result29View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(4:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult30Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result30" name="result30" cssStyle="width:120pt" list ="result30Combo"/>
                <s:textfield id="result30View" name="result30View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">旧LMR</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult31Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result31" name="result31" cssStyle="width:120pt" list ="result31Combo"/>
                <s:textfield id="result31View" name="result31View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(6:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult32Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result32" name="result32" cssStyle="width:120pt" list ="result32Combo"/>
                <s:textfield id="result32View" name="result32View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">LEU乳癌</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult33Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result33" name="result33" cssStyle="width:120pt" list ="result33Combo"/>
                <s:textfield id="result33View" name="result33View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ONC担当区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult34Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result34" name="result34" cssStyle="width:120pt" list ="result34Combo"/>
                <s:textfield id="result34View" name="result34View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">RPL(CVM)担当区分</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult35Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result35" name="result35" cssStyle="width:120pt" list ="result35Combo"/>
                <s:textfield id="result35View" name="result35View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(10:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preResult36Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="result36" name="result36" cssStyle="width:120pt" list ="result36Combo"/>
                <s:textfield id="result36View" name="result36View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{insClass == "01"}'>
	<s:hidden id="table11ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable11" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--病院設備情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('11');return false;">病院設備情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">内視鏡</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip01Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="equip01" name="equip01" cssStyle="width:120pt" list ="equip01Combo"/>
                <s:textfield id="equip01View" name="equip01View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨量測定器</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip02Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="equip02" name="equip02" cssStyle="width:120pt" list ="equip02Combo"/>
                <s:textfield id="equip02View" name="equip02View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ICD</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip03Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="equip03" name="equip03" cssStyle="width:120pt" list ="equip03Combo"/>
                <s:textfield id="equip03View" name="equip03View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">CCU</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip07Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="equip07" name="equip07" cssStyle="width:120pt" list ="equip07Combo"/>
                <s:textfield id="equip07View" name="equip07View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">NCU</td>
	   	<td class="comFormTableItemNf012"><s:label key="preEquip09Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="equip09" name="equip09" cssStyle="width:120pt" list ="equip09Combo"/>
                <s:textfield id="equip09View" name="equip09View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023" && insClass == "01"}'>
	<s:hidden id="table12ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable12" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--市場規模情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('12');return false;">市場規模情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">T先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket01Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="market01" name="market01" cssStyle="width:120pt" list ="market01Combo"/>
                <s:textfield id="market01View" name="market01View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">酸抑制剤</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket02Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="market02" name="market02" cssStyle="width:120pt" list ="market02Combo"/>
                <s:textfield id="market02View" name="market02View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">高脂血症</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket03Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="market03" name="market03" cssStyle="width:120pt" list ="market03Combo"/>
                <s:textfield id="market03View" name="market03View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">高血圧</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket04Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="market04" name="market04" cssStyle="width:120pt" list ="market04Combo"/>
                <s:textfield id="market04View" name="market04View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">糖尿病</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket06Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="market06" name="market06" cssStyle="width:120pt" list ="market06Combo"/>
                <s:textfield id="market06View" name="market06View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨粗鬆症</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket07Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="market07" name="market07" cssStyle="width:120pt" list ="market07Combo"/>
                <s:textfield id="market07View" name="market07View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">CVMターゲット</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMarket09Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="market09" name="market09" cssStyle="width:120pt" list ="market09Combo"/>
                <s:textfield id="market09View" name="market09View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table13ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable13" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--医療法関連分類情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('13');return false;">医療法関連分類情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">社会医療法人</td>
	   	<td class="comFormTableItemNf012"><s:label key="preMedical12Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="medical12" name="medical12" cssStyle="width:120pt" list ="medical12Combo"/>
                <s:textfield id="medical12View" name="medical12View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{insClass == "01"}'>
	<s:hidden id="table14ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable14" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--特別な機能情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('14');return false;">特別な機能情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">入院包括化実施病院</td>
	   	<td class="comFormTableItemNf012"><s:label key="preSpfunc01Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="spfunc01" name="spfunc01" cssStyle="width:120pt" list ="spfunc01Combo"/>
                <s:textfield id="spfunc01View" name="sqfunc01View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">救命救急センター</td>
	   	<td class="comFormTableItemNf012"><s:label key="preSpfunc03Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="spfunc03" name="spfunc03" cssStyle="width:120pt" list ="spfunc03Combo"/>
                <s:textfield id="spfunc03View" name="sqfunc03View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">大学院大学</td>
	   	<td class="comFormTableItemNf012"><s:label key="preSpfunc04Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="spfunc04" name="spfunc04" cssStyle="width:120pt" list ="spfunc04Combo"/>
                <s:textfield id="spfunc04View" name="sqfunc04View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{insClass == "01"}'>
	<s:hidden id="table15ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable15" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--医療連携関連情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('15');return false;">医療連携関連情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">がん連携パス</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTieup10Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="tieup10" name="tieup10" cssStyle="width:120pt" list ="tieup10Combo"/>
                <s:textfield id="tieup10View" name="tieup10View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">心疾患連携パス</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTieup11Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="tieup11" name="tieup11" cssStyle="width:120pt" list ="tieup11Combo"/>
                <s:textfield id="tieup11View" name="tieup11View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">糖尿病連携パス</td>
	   	<td class="comFormTableItemNf012"><s:label key="preTieup12Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="tieup12" name="tieup12" cssStyle="width:120pt" list ="tieup12Combo"/>
                <s:textfield id="tieup12View" name="tieup12View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023"}'>
	<s:hidden id="table16ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable16" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--ユーザーコード情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('16');return false;">ユーザーコード情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">(A:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0001Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0001" name="usercd0001" cssStyle="width:120pt" list ="usercd0001Combo"/>
                <s:textfield id="usercd0001View" name="usercd0001View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">VCT・V先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0002Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0002" name="usercd0002" cssStyle="width:120pt" list ="usercd0002Combo"/>
                <s:textfield id="usercd0002View" name="usercd0002View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(C:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0003Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0003" name="usercd0003" cssStyle="width:120pt" list ="usercd0003Combo"/>
                <s:textfield id="usercd0003View" name="usercd0003View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">NEXアーリーアダプタ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0004Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0004" name="usercd0004" cssStyle="width:120pt" list ="usercd0004Combo"/>
                <s:textfield id="usercd0004View" name="usercd0004View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>(E:未使用)</nobr></td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0005Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0005" name="usercd0005" cssStyle="width:120pt" list ="usercd0005Combo"/>
                <s:textfield id="usercd0005View" name="usercd0005View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">テルモ・コプロ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0006Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0006" name="usercd0006" cssStyle="width:120pt" list ="usercd0006Combo"/>
                <s:textfield id="usercd0006View" name="usercd0006View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(G:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0007Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0007" name="usercd0007" cssStyle="width:120pt" list ="usercd0007Combo"/>
                <s:textfield id="usercd0007View" name="usercd0007View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">リュープリン・コプロ12/10</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0008Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0008" name="usercd0008" cssStyle="width:120pt" list ="usercd0008Combo"/>
                <s:textfield id="usercd0008View" name="usercd0008View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">アクトス・コプロ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0009Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0009" name="usercd0009" cssStyle="width:120pt" list ="usercd0009Combo"/>
                <s:textfield id="usercd0009View" name="usercd0009View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ベネット・コプロ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0010Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0010" name="usercd0010" cssStyle="width:120pt" list ="usercd0010Combo"/>
                <s:textfield id="usercd0010View" name="usercd0010View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">グルファスト</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0011Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0011" name="usercd0011" cssStyle="width:120pt" list ="usercd0011Combo"/>
                <s:textfield id="usercd0011View" name="usercd0011View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">リュープリンコプロ08/10</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0012Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0012" name="usercd0012" cssStyle="width:120pt" list ="usercd0012Combo"/>
                <s:textfield id="usercd0012View" name="usercd0012View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(M:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0013Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0013" name="usercd0013" cssStyle="width:120pt" list ="usercd0013Combo"/>
                <s:textfield id="usercd0013View" name="usercd0013View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">COP活動先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0014Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0014" name="usercd0014" cssStyle="width:120pt" list ="usercd0014Combo"/>
                <s:textfield id="usercd0014View" name="usercd0014View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ω3製剤市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0015Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0015" name="usercd0015" cssStyle="width:120pt" list ="usercd0015Combo"/>
                <s:textfield id="usercd0015View" name="usercd0015View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">TCB RW在籍施設</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0016Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0016" name="usercd0016" cssStyle="width:120pt" list ="usercd0016Combo"/>
                <s:textfield id="usercd0016View" name="usercd0016View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">DPP4アーリーアダプタ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0017Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0017" name="usercd0017" cssStyle="width:120pt" list ="usercd0017Combo"/>
                <s:textfield id="usercd0017View" name="usercd0017View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">DPP4阻害薬('16.2)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0018Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0018" name="usercd0018" cssStyle="width:120pt" list ="usercd0018Combo"/>
                <s:textfield id="usercd0018View" name="usercd0018View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">DPP4阻害薬市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0019Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0019" name="usercd0019" cssStyle="width:120pt" list ="usercd0019Combo"/>
                <s:textfield id="usercd0019View" name="usercd0019View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ARB/CCB配合剤市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0020Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0020" name="usercd0020" cssStyle="width:120pt" list ="usercd0020Combo"/>
                <s:textfield id="usercd0020View" name="usercd0020View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">抗潰瘍(PPI)市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0021Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0021" name="usercd0021" cssStyle="width:120pt" list ="usercd0021Combo"/>
                <s:textfield id="usercd0021View" name="usercd0021View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">骨粗鬆症市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0022Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0022" name="usercd0022" cssStyle="width:120pt" list ="usercd0022Combo"/>
                <s:textfield id="usercd0022View" name="usercd0022View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem"><nobr>睡眠市場</nobr></td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0023Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0023" name="usercd0023" cssStyle="width:120pt" list ="usercd0023Combo"/>
                <s:textfield id="usercd0023View" name="usercd0023View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">X雑・災害</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0024Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0024" name="usercd0024" cssStyle="width:120pt" list ="usercd0024Combo"/>
                <s:textfield id="usercd0024View" name="usercd0024View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">アルツハイマー市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0025Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0025" name="usercd0025" cssStyle="width:120pt" list ="usercd0025Combo"/>
                <s:textfield id="usercd0025View" name="usercd0025View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">ARB総市場</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0026Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0026" name="usercd0026" cssStyle="width:120pt" list ="usercd0026Combo"/>
                <s:textfield id="usercd0026View" name="usercd0026View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">施設責任者</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0027Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0027" name="usercd0027" cssStyle="width:120pt" list ="usercd0027Combo"/>
                <s:textfield id="usercd0027View" name="usercd0027View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">タケプロン・コプロ</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0028Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0028" name="usercd0028" cssStyle="width:120pt" list ="usercd0028Combo"/>
                <s:textfield id="usercd0028View" name="usercd0028View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">抗潰瘍(PPI)市場('16.6)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0029Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0029" name="usercd0029" cssStyle="width:120pt" list ="usercd0029Combo"/>
                <s:textfield id="usercd0029View" name="usercd0029View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(4:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0030Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0030" name="usercd0030" cssStyle="width:120pt" list ="usercd0030Combo"/>
                <s:textfield id="usercd0030View" name="usercd0030View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">インフル・セオリア</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0031Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0031" name="usercd0031" cssStyle="width:120pt" list ="usercd0031Combo"/>
                <s:textfield id="usercd0031View" name="usercd0031View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">インフル・あすか</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0032Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0032" name="usercd0032" cssStyle="width:120pt" list ="usercd0032Combo"/>
                <s:textfield id="usercd0032View" name="usercd0032View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">マーケティングG・T</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0033Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0033" name="usercd0033" cssStyle="width:120pt" list ="usercd0033Combo"/>
                <s:textfield id="usercd0033View" name="usercd0033View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(8:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0034Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0034" name="usercd0034" cssStyle="width:120pt" list ="usercd0034Combo"/>
                <s:textfield id="usercd0034View" name="usercd0034View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">セルタッチ・ベネット</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0035Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0035" name="usercd0035" cssStyle="width:120pt" list ="usercd0035Combo"/>
                <s:textfield id="usercd0035View" name="usercd0035View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">(10:未使用)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0036Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="usercd0036" name="usercd0036" cssStyle="width:120pt" list ="usercd0036Combo"/>
                <s:textfield id="usercd0036View" name="usercd0036View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">A(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0101" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
				<s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0101" id="usercd0101" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0101" id="usercd0101" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">B(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0102" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0102" id="usercd0102" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0102" id="usercd0102" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">C(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0103" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0103" id="usercd0103" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0103" id="usercd0103" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">D(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0104" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0104" id="usercd0104" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0104" id="usercd0104" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">E(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0105" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0105" id="usercd0105" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0105" id="usercd0105" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">F(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0106" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0106" id="usercd0106" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0106" id="usercd0106" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">G(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0107" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0107" id="usercd0107" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0107" id="usercd0107" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">H(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0108" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0108" id="usercd0108" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0108" id="usercd0108" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">I(支店)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0109" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0109" id="usercd0109" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0109" id="usercd0109" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">A(営業所)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0201" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0201" id="usercd0201" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0201" id="usercd0201" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">LEUターゲット先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0202" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0202" id="usercd0202" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0202" id="usercd0202" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">C(営業所)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0203" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0203" id="usercd0203" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0203" id="usercd0203" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">次期院長ターゲット先</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0204" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0204" id="usercd0204" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0204" id="usercd0204" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">E(営業所)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0205" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0205" id="usercd0205" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0205" id="usercd0205" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">F:なんでもフォロー表</td>
	   	<td class="comFormTableItemNf012"><s:label key="preUsercd0206" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:if test='%{editApprFlg == "1"}'>
	                <s:textfield name="usercd0206" id="usercd0206" size="20" />
	            </s:if>
	            <s:else>
	            	<s:textfield name="usercd0206" id="usercd0206" size="20" readonly="true" />
	           	</s:else>
            </nobr>
		</td>
	</tr>
	</table>
	<br/>
	</s:if>
	<s:if test='%{loginJokenSetCd != "JKN0023" && insClass == "01"}'>
	<s:hidden id="table17ViewFlg" value="1" />
	<hr class="comTitle" style="margin-top:2px;width:75%"/><br/>
	<table id="formTable17" border="0" class="comPortalTable" align="center" style="width:75%; table-layout:fixed;">
	<tr>
        <%--診療報酬情報--%>
        <td style="width: 20%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
        <td style="width: 40%; height: 0px; border-width: 0px;"></td>
	</tr>
	<tr>
	   	<td class="comFormTableItem">
	   		<nobr>
	   			<a class="comMiniLink" href="#" onClick="JavaScript:chngTblView('17');return false;">診療報酬情報</a>
	   		</nobr></td>
	   	<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
		<td class="comFormTableItem"><nobr>&nbsp;</nobr></td>
	</tr>
	<tr>
		<td class="comFormTableItem">入院診療計画</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward04Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward04" name="reward04" cssStyle="width:120pt" list ="reward04Combo"/>
                <s:textfield id="reward04View" name="reward04View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">院内感染防止対策</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward05Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward05" name="reward05" cssStyle="width:120pt" list ="reward05Combo"/>
                <s:textfield id="reward05View" name="reward05View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">地域連携小児夜間・休日診療料1</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward08Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward08" name="reward08" cssStyle="width:120pt" list ="reward08Combo"/>
                <s:textfield id="reward08View" name="reward08View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">小児入院医療管理料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward09Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward09" name="reward09" cssStyle="width:120pt" list ="reward09Combo"/>
                <s:textfield id="reward09View" name="reward09View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">緩和ケア診療加算</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward18Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward18" name="reward18" cssStyle="width:120pt" list ="reward18Combo"/>
                <s:textfield id="reward18View" name="reward18View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">短期滞在手術基本料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward21Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward21" name="reward21" cssStyle="width:120pt" list ="reward21Combo"/>
                <s:textfield id="reward21View" name="reward21View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">在宅患者訪問診療料又は在総診</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward23Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward23" name="reward23" cssStyle="width:120pt" list ="reward23Combo"/>
                <s:textfield id="reward23View" name="reward23View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">生活習慣病指導管理料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward25Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward25" name="reward25" cssStyle="width:120pt" list ="reward25Combo"/>
                <s:textfield id="reward25View" name="reward25View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">慢性疼痛疾患管理料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward26Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward26" name="reward26" cssStyle="width:120pt" list ="reward26Combo"/>
                <s:textfield id="reward26View" name="reward26View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">看護配置(有床診療所)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward27Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward27" name="reward27" cssStyle="width:120pt" list ="reward27Combo"/>
                <s:textfield id="reward27View" name="reward27View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">老人入院基本料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward29Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward29" name="reward29" cssStyle="width:120pt" list ="reward29Combo"/>
                <s:textfield id="reward29View" name="reward29View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">地域連携時間外診療(有無)</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward35Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward35" name="reward35" cssStyle="width:120pt" list ="reward35Combo"/>
                <s:textfield id="reward35View" name="reward35View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">地域連携診療計画管理料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward36Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward36" name="reward36" cssStyle="width:120pt" list ="reward36Combo"/>
                <s:textfield id="reward36View" name="reward36View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">地域連携診療計画退院時指導料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward37Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward37" name="reward37" cssStyle="width:120pt" list ="reward37Combo"/>
                <s:textfield id="reward37View" name="reward37View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">病理診断料</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward44Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward44" name="reward44" cssStyle="width:120pt" list ="reward44Combo"/>
                <s:textfield id="reward44View" name="reward44View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">急性期入院加算</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward16Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward16" name="reward16" cssStyle="width:120pt" list ="reward16Combo"/>
                <s:textfield id="reward16View" name="reward16View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	<tr>
		<td class="comFormTableItem">急性期特定入院加算</td>
	   	<td class="comFormTableItemNf012"><s:label key="preReward17Nm" /></td>
		<td class="comFormTableItemNf012">
			<nobr>
                <s:select id="reward17" name="reward17" cssStyle="width:120pt" list ="reward17Combo"/>
                <s:textfield id="reward17View" name="reward17View" cssStyle="width:120pt" readonly="true" />
            </nobr>
		</td>
	</tr>
	</table>
	</s:if>


  <%--コメント類 --%>
  <table id="formTable18" border="0" class="comPortalTable" align="center" style="width:75%;">
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
  <table id="formTable19" border="0" class="comPortalTable" align="center" style="width:98%;">
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
