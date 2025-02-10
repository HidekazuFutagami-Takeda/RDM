/**
* クリックワンス関連クラス
*/
var Clickonce = {
	/**
	* クリックワンス配布サイトURL
	*/
	url: "http://intjinji.takeda.co.jp/ClickOnceSite/Opera.application",
	
	/**
	* 人事ポータルのクリックワンスURL取得
	* @return	{object}	href要素
	*/
	setHumanResourcePortalLink: function(targetTag) {
		if(targetTag.href.indexOf("?secret=") == -1) {
			var items = [];
			
			items.push(
				Clickonce.url + (
					document.cookie.length > 0
					? "?secret=" + encodeURIComponent(base64.encode(document.cookie, 1))
					+ "&owner=" + encodeURIComponent(base64.encode(document.location.hostname, 1))
					: ""
				)
			);
			var tokens = targetTag.href.split("?");
			if(tokens.length == 2) {
				items.push(tokens[1]);
			}
			targetTag.href = items.join("&");
		}
		
		var nowDate = new Date();		
		var nowYear = nowDate.getYear();
		var nowMonth = nowDate.getMonth() + 1;
		var nowDay =  nowDate.getDate();
		var nowWeek = nowDate.getDay();
		var nowHour = nowDate.getHours();
		var nowMinute = nowDate.getMinutes();
		var firstDate = new Date(nowYear, nowMonth -1, 1);
		var firstDayOfWeek = firstDate.getDay();		
		var firstSundayDay = 1 - firstDayOfWeek;
		if ( firstSundayDay <= 0 ) firstSundayDay += 7;
		var firstSunday = new Date(nowYear, nowMonth - 1, firstSundayDay);
		var fourthSunday = new Date(firstSunday.getYear(), firstSunday.getMonth(), firstSunday.getDate());
		fourthSunday.setTime(firstSunday.getTime() + (86400000 * 21));
		var fourthSundayDay = fourthSunday.getDate();
/* 2012/09/20 add start T.Yoshida B12-0146 */
		// 更新情報からのリンク対応
		if( targetTag.target == "_top" ){
			targetTag = window.top.location;
		}
/* 2012/09/20 add end T.Yoshida B12-0146 */

		if (
			( nowMonth == 5 ) && ( ( nowDay == 3 ) || ( nowDay == 4 ) || ( nowDay == 5 ) )
			||
			( nowMonth == 12 ) && ( nowDay == 31 )
			||
			( nowMonth == 1 ) && ( ( nowDay == 1 ) || ( nowDay == 2 ) || ( nowDay == 3 ) )
			)
		{
			targetTag.target = "_blank";
		}
		else
		{
			if ( nowDay == fourthSundayDay )
			{
				if ( ( nowHour >= 12 && nowHour <= 22 ) || ( nowHour == 23 && nowMinute <= 45 ) )
				{
					targetTag.target = "_self";
				}
				else
				{
					targetTag.target = "_blank";
				}
			}
			else
			{
				if ( ( nowHour >= 7 && nowHour <= 22 ) || ( nowHour == 23 && nowMinute <= 45 ) )
				{
					targetTag.target = "_self";
				}
				else
				{
					targetTag.target = "_blank";
				}
			}
		}
	}
}
