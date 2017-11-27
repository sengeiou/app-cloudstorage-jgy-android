package com.guoyie.www.delivery.easy.util;

/**
 * author：柯军
 * project：New_GuoYieAndroid
 * package：com.guoyie.www.gyapp.util
 * email：774169396@qq.com
 * data：16/10/30
 */
public class MarvelService {
    public static final String KEY = "ttouch2016";
    public static final String TIME = "time";
    public static final String TOKEN = "token";
    public static final String AUTH_TOKEN = "authToken";

    /**
     * 当前时间
     *
     * @return
     */
    public static String getTime() {
        return String.valueOf(System.currentTimeMillis()).substring(0, 10);
    }

    /**
     * 请求token
     *
     * @return
     */
    public static String getToken() {
        return MD5Utils.Md5(getTime() + KEY);
    }

    public static String getAuthToken() {
        return "";
    }
}
