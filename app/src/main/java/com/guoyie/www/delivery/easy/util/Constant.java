package com.guoyie.www.delivery.easy.util;

/**
 * @author luck.
 * @date 16/8/5.
 */
public class Constant {

    public static String BASE_PATH = FileUtils.createRootPath(AppUtils.getAppContext()) + "/cloudManager/";
    public static String PATH_DATA = FileUtils.createRootPath(AppUtils.getAppContext()) + "/cache";

    // SD卡写入权限 Flag
    public static final int WRITE_EXTERNAL_STORAGE = 0x01;


    public static boolean DEBUG = true;
   //用户信息缓存
    public static String USER_INFO_CACHE="USER_INFO_CACHE";
    //从入库的单点击传入详情的key
    public static String INPUT_ORDER_ID="INPUT_ORDER_ID";
    //从储罐列表传入储罐详情的储罐id的key
    public static final String STORE_ID = "STORE_ID";





}
