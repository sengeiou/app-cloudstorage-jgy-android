package com.guoyie.www.delivery.easy.api;
public class HttpUtils {
    public final static int READ_EXTERNAL_STORAGE = 0x01;
    public final static int CAMERA = 0x02;
    public final static int CALL_PHONE = 0x03;

    public final static int HTTP_RESULT_OK    = 200;
    public final static int HTTP_RESULT_ERROR = 0;
    public static final String USER_INFO      = "USER_INFO";

    public static String key                  = "chinayieapp";//app的秘钥
    //首页的列表的地址
    public static String HOMEPAGE_DATA        ="model=home&action=homepage";
    //获取服务器时间的接口
    public static final String GET_TIME          ="model=index&action=gettime";
    //登录的接口
    public static final String LOG_IN            ="model=login&action=login";
    //服务商入驻的接口
    public static final String RE_GISTER   ="model=vendor&action=index";

    //入库单列表的数据
    public static final String INTER_ORDER_LIST            ="model=warehouse&action=list";
    //入库单的详情的接口
    public static final String INTER_ORDER_DETAIL            ="model=warehouse&action=info";

}
