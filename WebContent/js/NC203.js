/**
* <pre>
*  検索
* 都道府県選択時に呼ばれます。
* </pre>
*/
	function sosAddrChange() {

		//市区町村配列
		 var val2 = document.getElementById("jkrCityNameCd");
		 val2.value = '';
		 //選択されたっ都道府県のCD
	     var val1 = document.getElementById("jkrSosAddrCd").value;

	     for (i = 0; i < val2.length; i++) {
	    	 //表示
	    	 val2.options[i].style.display = "block";
	    	 var val2Cd = val2[i].value;
	    	 if(val2Cd != ""){
		    	 //市区町村コードの頭2つ切り取る
		    	 var val2cut = val2Cd.toString().substr( 0, 2);
		    	 if (val1 != val2cut) {
		    		 val2.options[i];
		    		 val2.options[i].style.display = "none";
		         }
	    	 }
	    }
	}

	function addrCodeCityChange(){
    	document.fm1.tmpAddrCodeCity.value = document.fm1.kensakuAddrCodeCity.value;
    }

     function jimSort(sortCondition){
    	  // 変更内容破棄確認チェック
    	  if (!jkrDestructChack()) return false;
          var log
          log = 1 + 1;
    	  //現在ページ番号変更（遷移）
    	  document.fm1.pageCntCur.value = 1;

    	  //ソート区分設定
    	  document.fm1.sortCondition.value = sortCondition;

    	  document.fm1.screenId.value	= document.fm1.gamenId.value;
    	  document.fm1.functionId.value = 'Sort';

    	  document.fm1.submit_search.click();
    	}

		/**
		* <pre>
		*  クリア
		* 全項目展開>>(リンク)押下時に呼ばれます。
		* </pre>
*/
		function clearText() {
			var preScreenId = document.fm1.backScreenId.value;

			if(preScreenId != "ND011" && preScreenId != "ND014" && preScreenId != "ND101"
				&& preScreenId != "ND103" && preScreenId != "ND501" && preScreenId != "NF011"
					&& preScreenId != "NF012" && preScreenId != "NF211" && preScreenId != "NF212"
						&& preScreenId != "NF401" && preScreenId != "NF403") {
				var haiinKbn = document.getElementById("haiinKbn");
				haiinKbn.value = '';

				var delFlg = document.getElementById("delFlg");
				delFlg.value = '';
			}

			var insKanjiSrch = document.getElementById("insKanjiSrch");
			insKanjiSrch.value = '';

			var insKanaSrch = document.getElementById("insKanaSrch");
			insKanaSrch.value = '';

			var insNoSrch = document.getElementById("insNoSrch");
			insNoSrch.value = '';

			if(document.fm1.viewKbn.value == '1'){
				var ultNo = document.getElementById("ultNo");
				ultNo.value = '';
			}

			var hcoKeieitai = document.getElementById("hcoKeieitai");
			hcoKeieitai.value = '';

			var hoInsType = document.getElementById("hoInsType");
			hoInsType.value = '';

			if(document.fm1.insSbtEditFlg.value == '1'){
				var insType = document.getElementById("insType");
				insType.value = '';
			}

			var pharmType = document.getElementById("pharmType");
			pharmType.value = '';

			var phone1 = document.getElementById("phone1");
			phone1.value = '';

			var insPcode = document.getElementById("insPcode");
			insPcode.value = '';

			if(preScreenId != "NF011" && preScreenId != "NF211" && preScreenId != "NF212"){
				var koshisetsuCheck = document.getElementById("koshisetsuCheck");
				koshisetsuCheck.checked = false;
			}

			var jkrSosAddrCd = document.getElementById("jkrSosAddrCd");
			jkrSosAddrCd.value = '';

			var jkrCityNameCd = document.getElementById("jkrCityNameCd");
			jkrCityNameCd.value = '';

			var address = document.getElementById("address");
			address.value = '';

		}

	/**
	 * 申請中の施設を対象
	 * @returns
	 */
	function reqChk(){
		var req = document.getElementById("reqCheck").checked;

		if(req){
			// 申請中の施設を対象チェックONの場合
			document.fm1.haiinKbn.readonly = true;
			document.fm1.haiinKbn.className = "reqChkOn";
			document.fm1.haiinKbn.tabIndex = "-1";
			document.fm1.kensakuDelFlg.readonly = true;
			document.fm1.kensakuDelFlg.className = "reqChkOn";
			document.fm1.kensakuDelFlg.tabIndex = "-1";
			document.fm1.insNoSrch.readonly = true;
			document.fm1.insNoSrch.className = "reqChkOn";
			document.fm1.insNoSrch.tabIndex = "-1";
			document.fm1.hcoKeieitai.readonly = true;
			document.fm1.hcoKeieitai.className = "reqChkOn";
			document.fm1.hcoKeieitai.tabIndex = "-1";
			document.fm1.hoInsType.readonly = true;
			document.fm1.hoInsType.className = "reqChkOn";
			document.fm1.hoInsType.tabIndex = "-1";
			document.fm1.insType.readonly = true;
			document.fm1.insType.className = "reqChkOn";
			document.fm1.insType.tabIndex = "-1";
			document.fm1.pharmType.readonly = true;
			document.fm1.pharmType.className = "reqChkOn";
			document.fm1.pharmType.tabIndex = "-1";
			document.fm1.phone1.readonly = true;
			document.fm1.phone1.className = "reqChkOn";
			document.fm1.phone1.tabIndex = "-1";
			document.fm1.insPcode.readonly = true;
			document.fm1.insPcode.className = "reqChkOn";
			document.fm1.insPcode.tabIndex = "-1";
			document.fm1.jkrSosAddrCd.readonly = true;
			document.fm1.jkrSosAddrCd.className = "reqChkOn";
			document.fm1.jkrSosAddrCd.tabIndex = "-1";
			document.fm1.jkrCityNameCd.readonly = true;
			document.fm1.jkrCityNameCd.className = "reqChkOn";
			document.fm1.jkrCityNameCd.tabIndex = "-1";
			document.fm1.address.readonly = true;
			document.fm1.address.className = "reqChkOn";
			document.fm1.address.tabIndex = "-1";
			document.fm1.searchReqId.readonly = false;
			document.fm1.searchReqId.className = "";
			document.fm1.searchReqId.tabIndex = "";

		} else {
			// 申請中の施設を対象チェックOFFの場合
			document.fm1.haiinKbn.readonly = false;
			document.fm1.haiinKbn.className = "";
			document.fm1.haiinKbn.tabIndex = "";
			document.fm1.kensakuDelFlg.readonly = false;
			document.fm1.kensakuDelFlg.className = "";
			document.fm1.kensakuDelFlg.tabIndex = "";
			document.fm1.insNoSrch.readonly = false;
			document.fm1.insNoSrch.className = "";
			document.fm1.insNoSrch.tabIndex = "";
			document.fm1.hcoKeieitai.readonly = false;
			document.fm1.hcoKeieitai.className = "";
			document.fm1.hcoKeieitai.tabIndex = "";
			document.fm1.hoInsType.readonly = false;
			document.fm1.hoInsType.className = "";
			document.fm1.hoInsType.tabIndex = "";
			document.fm1.insType.readonly = false;
			document.fm1.insType.className = "";
			document.fm1.insType.tabIndex = "";
			document.fm1.pharmType.readonly = false;
			document.fm1.pharmType.className = "";
			document.fm1.pharmType.tabIndex = "";
			document.fm1.phone1.readonly = false;
			document.fm1.phone1.className = "";
			document.fm1.phone1.tabIndex = "";
			document.fm1.insPcode.readonly = false;
			document.fm1.insPcode.className = "";
			document.fm1.insPcode.tabIndex = "";
			document.fm1.jkrSosAddrCd.readonly = false;
			document.fm1.jkrSosAddrCd.className = "";
			document.fm1.jkrSosAddrCd.tabIndex = "";
			document.fm1.jkrCityNameCd.readonly = false;
			document.fm1.jkrCityNameCd.className = "";
			document.fm1.jkrCityNameCd.tabIndex = "";
			document.fm1.address.readonly = false;
			document.fm1.address.className = "";
			document.fm1.address.tabIndex = "";
			document.fm1.searchReqId.readonly = true;
			document.fm1.searchReqId.className = "reqChkOn";
			document.fm1.searchReqId.tabIndex = "-1";
		}
	}


