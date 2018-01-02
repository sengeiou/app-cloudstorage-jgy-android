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
    //从出库的单点击传入详情的key
    public static String OUTER_ORDER_ID="OUTER_ORDER_ID";
    //意向单列表到详情的key
    public static String STORAGE_DETAIL_ID="STORAGE_DETAIL_ID";
    //从储罐列表传入储罐详情的储罐id的key
    public static final String STORE_ID = "STORE_ID";
    //货权转移的到详情页面的KEY
    public static final String TRANSSTOCK_ID = "TRANSSTOCK_ID";
    //从货权转移的CA数据
    public static final String TRANSSTOCK_CA_ID = "TRANSSTOCK_CA_ID";

    //筛选条件，商品名的key
    public static final String GOODS_NAME = "STORE_NAME";
    //筛选条件，储罐号的key
    public static final String STORE_NUMBER = "STORE_NUMBER";
    //筛选条件，储罐性质的key
    public static final String STORE_TYPE = "STORE_TYPE";
    //传递搜索的时候的key
    public static final String SEACH_ID = "SEACH_ID";
    //从搜索页面传到结果要页面的的id
    public static final String SEACHSULT_ID = "SEACHSULT_ID";
    //搜索传递的关键字
    public static final String KEYS_WORD = "KEYS_WORD";
    //入库编辑的数据
     public static String INPUT_EDIT_ORDER="INPUT_EDIT_ORDER";
     //入库类别
     public static String STOCK_TYPE="STOCK_TYPE";
     //添加的类型
     public static String OUTER_EDIT_ORDER="ADD_TYPE";
     //储罐名称的字段
     public static String ACHEA_STORE_NUMBER="ACHEA_STORE_NUMBER";
}
