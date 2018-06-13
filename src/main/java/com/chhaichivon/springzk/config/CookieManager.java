package com.chhaichivon.springzk.config;

import org.zkoss.zk.ui.Executions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: chhai.chivon on 6/5/2018.
 */
public class CookieManager {

    public static String EMPTY_COOKIE = "";
    public static String APP_USER_ID = "APP_USER_ID";
    public static String APP_USER_PWD = "APP_USER_PWD";

    public static void setCookie(String key , String value){
        HttpServletResponse response = (HttpServletResponse) Executions.getCurrent().getNativeResponse();
        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(60*60); //1 hour
        //cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static String getCookie(String name) {
        try {
            Cookie[] cookies = ((HttpServletRequest) Executions.getCurrent().getNativeRequest()).getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(name)) {
                        return cookie.getValue();
                    }
                }
            }
        }
        catch(Exception ex) {
            return EMPTY_COOKIE;
        }

        return EMPTY_COOKIE;
    }

    public static void removeCookie(){
        CookieManager.setCookie(APP_USER_ID,EMPTY_COOKIE);
        CookieManager.setCookie(APP_USER_PWD,EMPTY_COOKIE);
    }
}
