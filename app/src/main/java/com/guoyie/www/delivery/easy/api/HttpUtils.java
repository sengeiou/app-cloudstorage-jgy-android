package com.guoyie.www.delivery.easy.api;
public class HttpUtils {
    public final static int READ_EXTERNAL_STORAGE = 0x01;
    public final static int CAMERA = 0x02;
    public final static int CALL_PHONE = 0x03;

    public final static int HTTP_RESULT_OK    = 200;
    public final static int HTTP_RESULT_ERROR = 0;
    public static final String USER_INFO      = "USER_INFO"; //用户名和密码 以userName+"&"+passWord格式缓存
    public static final String OUT_LOGIN      = "OUT_LOGIN";


    public static String key  = "chinayieapp";//app的秘钥
    //获取服务器时间的接口
    public static final String GET_TIME ="model=index&action=gettime";
    //登录的接口
    public static final String LOG_IN="model=login&action=login";
    //服务商入驻的接口
    public static final String RE_GISTER="model=vendor&action=index";

    /*======================入库单接口===============================*/
    //入库单列表的数据
    public static final String INTER_ORDER_LIST="model=warehouse&action=list";
    //入库单的详情的接口
    public static final String INTER_ORDER_DETAIL="model=warehouse&action=info";
    //入库单的审核的接口的接口
    public static final String INTER_ORDER_UPDATE="model=warehouse&action=update";
    //入库单的添加入库明细的接口
    public static final String INTER_ORDER_ADDSTOCK="model=warehouse&action=addstock";
    //出入库单的编辑入库确认单的接口
    public static final String INTER_OUTER_HANDLE="model=warehouse&action=handle";
    //完成入库的接口
    public static final String INTER_ORDER_UPINSTOCK="model=warehouse&action=upinstock";
     /*======================出库单接口===============================*/
    //出库单列表的数据
    public static final String OUTER_ORDER_LIST="model=outstock&action=list";
    //出库单的详情的接口
    public static final String OUTER_ORDER_UPDATE="model=outstock&action=update";
    //出库单审核的接口
    public static final String OUTER_ORDER_DETAIL="model=outstock&action=info";
    //出库单的添加入库明细的接口
    public static final String OUTER_ORDER_ADDSTOCK="model=outstock&action=addstock";
    //出库单的编辑入库确认单的接口
    public static final String OUTER_ORDER_UPOUTSTOCK="model=outstock&action=upoutstock";

    //上传文件的接口model=warehouse&action=uploadobj（POST 请求）
    public static final String UPLOAD_OBJ="model=warehouse&action=uploadobj";

    /*======================货转单接口===============================*/
    //货权转移的列表的接口
    public static final String TRANSSTOCK_LSIT = "model=transstock&action=list";
    //货权转移的详情的接口的接口
    public static final String TRANSSTOCK_DETAIL = "model=transstock&action=detail";
    //货权转移通过或者不同过得接口
    public static final String TRANSSTOCK_UPDATE = "model=transstock&action=update";
    /*======================意向单单接口===============================*/
    //意向单列表的数据接口
    public static final String INFO_STORAGE ="model=subscribe&action=storage";
    //意向单详情的数据接口
    public static final String INFO_STORAGE_DETALI ="model=subscribe&action=storageinfo";



    //获取储罐管理列表数据的接口
    public static final String STORE_MANAGER_LIST ="model=stock&action=jarlist";

    //储罐详情的接口
    public static final String STORE_DETAIL = "model=stock&action=jarinfo";
    //库容管理列表的接口
    public static final String CAPACITY_MANAGER = "model=stock&action=stocklist";
    //库容筛选获取商品名的接口
    public static final String CAPACITY_FILTER_GOODS_NAME = "model=stock&action=searchgoodsname";
    //库容筛选获取储罐号的接口
    public static final String CAPACITY_FILTER_STORE_NUMBER = "model=stock&action=searchstockno";
    //储罐筛选，获取储罐号，商品名，储罐性质的接口
    public static final String STORE_FILTER = "model=stock&action=distinctlist";

}
