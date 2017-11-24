package www.guoyie.com.delivery.easy.util;

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
    //从首页传到详情页的数据
    public static String HOMEITEM_ID="HOMEITEM_ID";
    //从消息列表页传到合同详情页的合同id
    public static String CONTRACT_ID="CONTRACT_ID";
    //从消息列表页传到合同详情页的合同subject
    public static String CONTRACT_SUBJECT="CONTRACT_SUBJECT";
    //合同是否审核
    public static String CONTRACT_ISAUDIT="CONTRACT_ISAUDIT";
    //从审批列表拿到数据中的参数
    public static String APPROVED_DATA="APPROVED_DATA";
    //从未审批列表处理的数据
    public static String UN_APPROVED_DATA="UN_APPROVED_DATA";




}
