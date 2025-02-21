package jp.co.takeda.rdm.common.filter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.service.CommonControlService;
import jp.co.takeda.rdm.util.AppConstant;

/**
 * <pre>
 * クラス名：AccessControlSession
 *
 * 機能概要：開発用でHttpヘッダから情報を取得できないため、Sessionを変わりに用いる処理をイメージした認証処理クラス
 *
 * 機能詳細：
 *
 * 注意事項：開発・検証環境で使用（web.xmlの中で切り替える）
 * </pre>
 *
 * @author 日立
 * @version Ver00-01
 */
public class AccessControlSession implements Filter {

    /**
     * ServletContext
     * @generated
     */
    private ServletContext servletContext = null;

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(AccessControlSession.class);

    /**
     * ユーザ情報をThreadLocalに設定する。<br>
     * @param request ServletRequest
     * @param response ServletResponse
     * @param filterChain FilterChain
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     * @generated
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {


        // Sessionの取得
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if(session == null){
            //セッションの新規生成
            session = ((HttpServletRequest) request).getSession(true);
        }


//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 ADD_START
        String hold_userId = ""; // ユーザID
        ((HttpServletRequest) request).setCharacterEncoding("UTF-8");
      //  String accessToken = ((HttpServletRequest) request).getParameter("access_token");
        boolean isLoginError = false;
        // アクセストークンが取得できた場合
      //  if(accessToken != null) {
          if((String)request.getParameter("code") != null) {
	        try {
			    /**
			    String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL215dGFrZWRhLnNoYXJlcG9pbnRvbmxpbmUuY29tIiwic3ViIjoiYjBlODAwOWYwYzEzZmQ1NDJkNTFhNGY5Y2QwNmM4YjVVVWRTTlRZek13PT18YjBlODAwOWYwYzEzZmQ1NDJkNTFhNGY5Y2QwNmM4YjVNVEl6TkRVMiIsIm5iZiI6MTU4NzMzNzYxNiwiZXhwIjoxNTg3MzQxMjE2LCJpYXQiOjE1ODczMzc2MTYsImp0aSI6Imhic293c3JpIiwidHlwIjoiaHR0cHM6Ly9teXRha2VkYS5zaGFyZXBvaW50b25saW5lLmNvbS9obm4ifQ.MGJDlbb7OsliqJ4NmUN310eDGot0YLME02fI919WlYn8yIG2sz3sCXQWDWESdvgZZa9fzI7BUHZpT8fludujp7CaefuOkOBfF38R0dWcKwL6yk9onfEoGqCbbsJtsFbRt6BJwIOURME90QxrPQDBIdMHf2YBzN2tEHZRtW2uyBwGs57382tKPBAWdcH0VZdZR0g8nFimxcOJlhsNzlmlBE7ONDR9iVXUQm7MkzvCCVgCNygTavAcqa1T0jXtL7N9ttjvAhXGeDFkYe-YbToq0qPnOD9AELO8PbNTV1RprQKrVSgjJBrvb37rSA46DmbxlwFj1IpmlqZZ6TQhXF9GcQ";
			    FileInputStream fis = new FileInputStream("C:\\eclipse\\workspace\\demo\\src\\main\\java\\com\\example\\demo\\sample.pem");
			    BufferedInputStream bis = new BufferedInputStream(fis);

			    // get the public key
			    CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
			    Certificate certificate = certificateFactory.generateCertificate(bis);
			    PublicKey publicKey = certificate.getPublicKey();

		    	JwtParser parser = Jwts.parser().setSigningKey(publicKey);
		    	Jws<Claims> parseClaimsJws = parser.parseClaimsJws(token);

		    	Claims jwsBody = parseClaimsJws.getBody();
				// iat (Issuad At) JWT発行日時取得
				java.util.Date iat = jwsBody.getIssuedAt();
				// sub (Subject) 取得
				String sub = jwsBody.getSubject();
				// iss (Issuer) JWT発行者取得
				String iss = jwsBody.getIssuer();
		    	**/

// テストコード Start
			    //String param1 = "b0e8009f0c13fd542d51a4f9cd06c8b5Yzg4MzAwMw==";
			    //String param2 = accessToken.split("miyake")[1];
			    //long param3 = Long.parseLong(accessToken.split("miyake")[2])*1000;
	        	String param1 = (String)request.getParameter("code");
	            Long param3 = Long.parseLong((String)request.getParameter("loginday"))*1000;
	            String param2 = (String)request.getParameter("username");

	            Charset charset = StandardCharsets.UTF_8;
	            String sub = Base64.getEncoder().encodeToString(param1.getBytes(charset));
                sub = "b0e8009f0c13fd542d51a4f9cd06c8b5" + sub;


				// iat (Issuad At) JWT発行日時取得
				Date iat = new Date(param3);
				iat.setTime(param3);
				// sub (Subject) 取得
				//String sub = param1;
				// iss (Issuer) JWT発行者取得
				String iss = param2;
// テストコード End

				// JWT発行日時 + 10分
				Calendar calIat = Calendar.getInstance();
				calIat.setTime(iat);
				calIat.add(Calendar.MINUTE, 10);

				// 現在時刻取得
				Calendar calNow = Calendar.getInstance();

				// JWT期限切れチェック
				if (calIat.compareTo(calNow) < 0) {
					System.out.println("× Issuad At Error : " + iat);
		            log.info("ログイン処理＝＝＝＝＝＝Issuad Atエラー:" + iat);
		            isLoginError = true;
				}

				// JWT発行者チェック
				if (!"CTSTAKEDA".equals(iss)) {
		            log.info("ログイン処理＝＝＝＝＝＝Issuerエラー:" + iss);
		            isLoginError = true;
				}

				// subjectを|で分割
				String[] subList = sub.split("\\|");

				// userId
				String strEncodeUserIdMask = subList[0];

				// userIdの先頭32文字を除去
				String strEncodeUserId = strEncodeUserIdMask.substring(32);

				// userIdをBase64デコード
				byte[] byteUserId = Base64.getDecoder().decode(strEncodeUserId);
				hold_userId = StringUtils.newStringUtf8(byteUserId);

		        Cookie ckUserId = new Cookie("X_USER", hold_userId);
		        ckUserId.setPath("/");
		        ((HttpServletResponse) response).addCookie(ckUserId);

		    } catch (Exception e) {
		    	e.printStackTrace();
	            isLoginError = true;
		    }
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 ADD_END

//2018.12.27 HISOL Hirakawa ユーザIDをCookieから取得する方式に変更 ADD_START
	    } else{

//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 DEL_START
//	        //Cookieの値を格納する変数
//	        String hold_employeeNumber = new String();   //従業員番号（チェック用）
//	        String hold_verifier       = new String();   //認証用ハッシュ値
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 DEL_END

	        // クッキー情報からユーザID/従業員番号/認証用ハッシュ値を取得
	        Cookie[] ckie1 = ((HttpServletRequest) request).getCookies();

	        if(ckie1 != null){
	            for(int ci = 0;ci<ckie1.length;ci++){
	                //ユーザID取得
	                if(ckie1[ci].getName().equalsIgnoreCase("X_USER") ){
	                	hold_userId = ckie1[ci].getValue();
	                }
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 DEL_START
//	                //従業員番号（チェック用）取得
//	                if(ckie1[ci].getName().equalsIgnoreCase("employeeNumber") ){
//	                	hold_employeeNumber = ckie1[ci].getValue();
//	                }
//	                //認証用ハッシュ値取得
//	                if(ckie1[ci].getName().equalsIgnoreCase("verifier") ){
//	                	hold_verifier = ckie1[ci].getValue();
//	                }
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 DEL_END

	            }
	        }

//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 DEL_START
//	        //チェック用のハッシュ値を生成（※参考例そのまま使用して作成）
//	        StringBuilder check_val =new StringBuilder();                   //ハッシュ値格納
//	        String text = "takeda" + hold_userId + hold_employeeNumber;     //ハッシュ生成の対象値
//	        byte[] cipher_byte;                                             //ワーク変数
//	        try{
//	                MessageDigest md = MessageDigest.getInstance("SHA-256");
//	                md.update(text.getBytes());
//	                cipher_byte = md.digest();
//	                StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
//	                for(byte b: cipher_byte) {
//	                        sb.append(String.format("%02x", b&0xff) );
//	                }
//	                check_val =sb;
//	        } catch (Exception e) {
//	                e.printStackTrace();
//	        }
//
//	        //ハッシュ値で認証チェック（要件に大文字・小文字の話がなかったので無視）
//	        if(!hold_verifier.equalsIgnoreCase(check_val.toString()) )
//	        {
//	           //エラー時は認証エラー画面にスロー
//	           throw new LoginAuthException("認証エラー");
//	        }
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 DEL_END
//2018.12.27 HISOL Hirakawa ユーザIDをCookieから取得する方式に変更 ADD_END
        }

//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 ADD_START
        // ログインエラー発生時は処理を行わない
        if(!isLoginError) {
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 ADD_END
        	//本番の場合は不要
	        String urlName = ((HttpServletRequest) request).getRequestURI();
	        if (urlName.contains("NC001Init") || urlName.contains("NC011Init")) {
	            log.info("ログイン処理＝＝＝＝＝＝RequestURI:" + ((HttpServletRequest) request).getRequestURI());

            //本番環境
            //ログインユーザID
//2018.12.27 HISOL Hirakawa ユーザIDをCookieから取得する方式に変更 MOD_START
//            String userId = (String)((HttpServletRequest) request).getHeader("X_USER");
	            String userId = hold_userId;
//2018.12.27 HISOL Hirakawa ユーザIDをCookieから取得する方式に変更 MOD_END
            //ログインユーザの従業員番号
//20150107 HISOL Suzuki HttpHeaderの情報ではなくDBから従業員番号を取得する MOD START
//            String emplyeeNumber = (String)((HttpServletRequest) request).getHeader("EMPLOYEENUMBER");
	            ServletContext context = this.servletContext;
	            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
	            CommonControlService commonControlService = (CommonControlService)wac.getBean("commonControlService");
	            String emplyeeNumber = String.valueOf(commonControlService.getJgiNo(userId));

//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 ADD_START
		        Cookie ckEmplyeeNumber = new Cookie("employeeNumber", emplyeeNumber);
		        ckEmplyeeNumber.setPath("/");
		        ((HttpServletResponse) response).addCookie(ckEmplyeeNumber);
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 ADD_END

//20150107 HISOL Suzuki MOD END
//            if (userId == null || userId.trim().length() == 0 || emplyeeNumber == null || emplyeeNumber.trim().length() == 0) {
//                throw new ServletException("ログインユーザIDの受け渡しエラー!");
//            }

	            // Sessionに保持しているユーザ情報を取得する
	            LoginInfo loginInfo = (LoginInfo) session.getAttribute(BaseInfoHolder.USERINFO_KEY);

	            //全画面から認証されたユーザIDを取得した場合
	            if (userId != null && userId.trim().length() != 0) {

	                // 初めて遷移した場合（ユーザ情報がセッションに格納されない）
	                if (loginInfo == null) {
	                    loginInfo = new LoginInfo();
	                    loginInfo.setUserId(userId);
	                    loginInfo.setJgiNo(Integer.parseInt(emplyeeNumber));
	                    loginInfo.setJgiNameGetFlag(false);
	                    //メニュー情報をクリアする
	                    session.removeAttribute(AppConstant.SESKEY_MENU_DATA);


	                //ログインユーザが変わった場合
	                } else if (!userId.equals(loginInfo.getUserId())) {
	                    loginInfo = new LoginInfo();
	                    loginInfo.setUserId(userId);
	                    loginInfo.setJgiNo(Integer.parseInt(emplyeeNumber));
	                    loginInfo.setJgiNameGetFlag(false);
	                    //メニュー情報をクリアする
	                    session.removeAttribute(AppConstant.SESKEY_MENU_DATA);


	                } else {
	                    //ログインユーザが変わらないので、何もしない
	                }

	            } else if (loginInfo == null) {
	                //throw new LoginAuthException("not login.");
	                //エラーとなるはず
	                //ここで何も処理せず、後の「LoginAuthInterceptor」でチェックするから
	            }

	            if (loginInfo != null) {
	                //セッションIDの格納
	                loginInfo.setSessionId(session.getId());
	                //ユーザ情報管理
	                session.setAttribute(BaseInfoHolder.USERINFO_KEY, loginInfo);


	                // 代行業務対応の為クッキー情報から従業員番号を取得
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 UPD_START
	    	        Cookie ckActJgino = new Cookie("CookieActJgino", emplyeeNumber);
	    	        ckActJgino.setPath("/");
	    	        ((HttpServletResponse) response).addCookie(ckActJgino);
//                Cookie[] ckie = ((HttpServletRequest) request).getCookies();

	    	        String actJgiNo = emplyeeNumber;
//                if(ckie != null){
//                    for(int ci = 0;ci<ckie.length;ci++){
//
//                        if(ckie[ci].getName().equalsIgnoreCase("CookieActJgino") ){
//                            // 代行業務対応の為
//                            actJgiNo = ckie[ci].getValue();
//                        }
//                    }
//                }
//2020.05.04 Hitachi Hagimoto ユーザIDをアクセストークンから取得する方式に変更 UPD_END

	                //代行された従業員番号が存在する場合
	                if (actJgiNo != null && actJgiNo.trim().length() > 0 && !actJgiNo.equals(emplyeeNumber)) {

	                    //未代行 または　（代行中　＆　代行された従業員が異なる）
	                    if (!loginInfo.isActing() || (loginInfo.isActing() && actJgiNo != String.valueOf(loginInfo.getJgiNo()))) {
	                        //代行開始
	                        loginInfo.actOn(Integer.parseInt(actJgiNo), "", "");
	                        loginInfo.setJgiNameGetFlag(false);
	                        //メニュー情報をクリアする
	                        session.removeAttribute(AppConstant.SESKEY_MENU_DATA);
	                    }

	                } else {
	                    //代行中
	                    if (loginInfo.isActing()) {
	                        //代行終了
	                        loginInfo.actOff();
	                        //メニュー情報をクリアする
	                        session.removeAttribute(AppConstant.SESKEY_MENU_DATA);
	                    }
	                }
	            }
	        }
        }

        try {
            // 後続の処理実行
            filterChain.doFilter(request, response);
        } finally {
            BaseInfoHolder.clearUserInfo();
        }
    }

    /**
     * 初期処理。<br>
     * ServletContextを属性に設定する。
     *
     * @param filterConfig FilterConfig
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     * @generated
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
    }

    /**
     * 終了処理。<br>
     *
     * @see javax.servlet.Filter#destroy()
     * @generated
     */
    public void destroy() {
        servletContext = null;
    }
}
