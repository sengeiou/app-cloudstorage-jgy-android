package com.guoyie.www.delivery.easy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/23
 */
public class Transstock implements Serializable{

    /**
     * _url : /index.php/
     * vendor_no : YC0000000015
     * status : 4
     * from : usercenter
     * transstock_customer_no_ :
     * vendor_transstock_like_ :
     * shop_sale_company_id :
     * shop_buy_company_id :
     * start_time :
     * end_time :
     * pageSize : 10
     * pageCurrent : 1
     * totalRow : 14
     * list : [{"id":"15","transstock_no":"T201712205407","transstock_customer_no":"CWCWCWCWCWCWCWCW","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 17:03:39","transstock_source":"2","status":"4","goods_name":"异丙醇"},{"id":"13","transstock_no":"T201712209640","transstock_customer_no":"665656","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:29:07","transstock_source":"2","status":"4","goods_name":"乙二醇乙醚醋酸酯"},{"id":"12","transstock_no":"T201712208438","transstock_customer_no":"2017122015485327","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:11:27","transstock_source":"2","status":"4","goods_name":"正丁醇"},{"id":"11","transstock_no":"T201712205948","transstock_customer_no":"520","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:10:50","transstock_source":"2","status":"4","goods_name":"沥青"},{"id":"10","transstock_no":"T201712208100","transstock_customer_no":"1314","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:10:11","transstock_source":"2","status":"4","goods_name":"有机化工"},{"id":"9","transstock_no":"T201712207146","transstock_customer_no":"888888","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:09:31","transstock_source":"2","status":"4","goods_name":"烧碱（氢氧化钠）"},{"id":"8","transstock_no":"T201712208195","transstock_customer_no":"66666","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:08:11","transstock_source":"2","status":"4","goods_name":"草酸"},{"id":"7","transstock_no":"T201712206271","transstock_customer_no":"98796454545","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:07:11","transstock_source":"2","status":"4","goods_name":"烧碱（氢氧化钠）"},{"id":"6","transstock_no":"T201712208921","transstock_customer_no":"5555","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:06:35","transstock_source":"2","status":"4","goods_name":"辛醇"},{"id":"5","transstock_no":"T201712206648","transstock_customer_no":"88888","vendor_name":"新版","shop_sale_company_id":"11931","shop_sale_company_name":"王敬测试公司","shop_buy_company_name":"分批交割测试有限公司","create_at":"2017-12-20 16:05:53","transstock_source":"2","status":"4","goods_name":"氢溴酸2"}]
     * totalPage : 2
     */

    private String           _url;
    private String         vendor_no;
    private String         status;
    private String         from;
    private String         transstock_customer_no_;
    private String         vendor_transstock_like_;
    private String         shop_sale_company_id;
    private String         shop_buy_company_id;
    private String         start_time;
    private String         end_time;
    private String         pageSize;
    private String         pageCurrent;
    private String         totalRow;
    private int            totalPage;
    private List<ListBean> list;
    private String   unauditedCount;

    public String getUnauditedCount() {
        return unauditedCount;
    }

    public void setUnauditedCount(String unauditedCount) {
        this.unauditedCount = unauditedCount;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public String getVendor_no() {
        return vendor_no;
    }

    public void setVendor_no(String vendor_no) {
        this.vendor_no = vendor_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTransstock_customer_no_() {
        return transstock_customer_no_;
    }

    public void setTransstock_customer_no_(String transstock_customer_no_) {
        this.transstock_customer_no_ = transstock_customer_no_;
    }

    public String getVendor_transstock_like_() {
        return vendor_transstock_like_;
    }

    public void setVendor_transstock_like_(String vendor_transstock_like_) {
        this.vendor_transstock_like_ = vendor_transstock_like_;
    }

    public String getShop_sale_company_id() {
        return shop_sale_company_id;
    }

    public void setShop_sale_company_id(String shop_sale_company_id) {
        this.shop_sale_company_id = shop_sale_company_id;
    }

    public String getShop_buy_company_id() {
        return shop_buy_company_id;
    }

    public void setShop_buy_company_id(String shop_buy_company_id) {
        this.shop_buy_company_id = shop_buy_company_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(String pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public String getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(String totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 15
         * transstock_no : T201712205407
         * transstock_customer_no : CWCWCWCWCWCWCWCW
         * vendor_name : 新版
         * shop_sale_company_id : 11931
         * shop_sale_company_name : 王敬测试公司
         * shop_buy_company_name : 分批交割测试有限公司
         * create_at : 2017-12-20 17:03:39
         * transstock_source : 2
         * status : 4
         * goods_name : 异丙醇
         */

        private String id;
        private String transstock_no;
        private String transstock_customer_no;
        private String vendor_name;
        private String shop_sale_company_id;
        private String shop_sale_company_name;
        private String shop_buy_company_name;
        private String create_at;
        private String transstock_source;
        private int status;
        private String goods_name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTransstock_no() {
            return transstock_no;
        }

        public void setTransstock_no(String transstock_no) {
            this.transstock_no = transstock_no;
        }

        public String getTransstock_customer_no() {
            return transstock_customer_no;
        }

        public void setTransstock_customer_no(String transstock_customer_no) {
            this.transstock_customer_no = transstock_customer_no;
        }

        public String getVendor_name() {
            return vendor_name;
        }

        public void setVendor_name(String vendor_name) {
            this.vendor_name = vendor_name;
        }

        public String getShop_sale_company_id() {
            return shop_sale_company_id;
        }

        public void setShop_sale_company_id(String shop_sale_company_id) {
            this.shop_sale_company_id = shop_sale_company_id;
        }

        public String getShop_sale_company_name() {
            return shop_sale_company_name;
        }

        public void setShop_sale_company_name(String shop_sale_company_name) {
            this.shop_sale_company_name = shop_sale_company_name;
        }

        public String getShop_buy_company_name() {
            return shop_buy_company_name;
        }

        public void setShop_buy_company_name(String shop_buy_company_name) {
            this.shop_buy_company_name = shop_buy_company_name;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public String getTransstock_source() {
            return transstock_source;
        }

        public void setTransstock_source(String transstock_source) {
            this.transstock_source = transstock_source;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }
    }
}
