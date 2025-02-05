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
    	 //市区町村コードの頭2つ切り取る
    	 var val2cut = val2Cd.toString().substr( 0, 2);
    	 if (val1 != val2cut) {
    		 val2.options[i];
    		 val2.options[i].style.display = "none";
         }

     }
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
			var haiinKbn = document.getElementById("haiinKbn");
			haiinKbn.value = '';

			var insKanjiSrch = document.getElementById("insKanjiSrch");
			insKanjiSrch.value = '';

			var insKanaSrch = document.getElementById("insKanaSrch");
			insKanaSrch.value = '';

			var delFlg = document.getElementById("delFlg");
			delFlg.value = '';

			var insNoSrch = document.getElementById("insNoSrch");
			insNoSrch.value = '';

			var ultNo = document.getElementById("ultNo");
			ultNo.value = '';

			var hcoKeieitai = document.getElementById("hcoKeieitai");
			hcoKeieitai.value = '';

			var hoInsType = document.getElementById("hoInsType");
			hoInsType.value = '';

			var insType = document.getElementById("insType");
			insType.value = '';

			var pharmType = document.getElementById("pharmType");
			pharmType.value = '';

			var phone1 = document.getElementById("phone1");
			phone1.value = '';

			var insPcode = document.getElementById("insPcode");
			insPcode.value = '';

			var koshisetsuCheck = document.getElementById("koshisetsuCheck");
			koshisetsuCheck.checked = false;

			var jkrSosAddrCd = document.getElementById("jkrSosAddrCd");
			jkrSosAddrCd.value = '';

			var jkrCityNameCd = document.getElementById("jkrCityNameCd");
			jkrCityNameCd.value = '';

			var address = document.getElementById("address");
			address.value = '';

		}




