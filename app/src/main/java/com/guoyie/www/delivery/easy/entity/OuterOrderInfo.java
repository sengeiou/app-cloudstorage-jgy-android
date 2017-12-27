package com.guoyie.www.delivery.easy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class OuterOrderInfo implements Serializable {


    /**
     * _url : /index.php/
     * vendor_no : YC0000000015
     * status :
     * keyword1s :
     * outstock_customer_no :
     * real_outsock_no :
     * goods_id :
     * shop_company_name :
     * outstock_type :
     * removestatus :
     * outstock_source :
     * start_time :
     * end_time :
     * pageCurrent : 1
     * pageSize : 10
     * totalRow : 13
     * list : [{"id":"13","outstock_no":"O201712255722","outstock_customer_no":"81","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"1","create_at":"2017-12-25 11:02:29","outstock_source":"2","status":"5","outstock_id":"13","goods_id":"513","goods_name":"硫酸","goods_unit":"吨","order_qty":"2.000","goods_nature":"内贸内销","remark":"备注"},{"id":"12","outstock_no":"O201712204423","outstock_customer_no":"55656","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"1","create_at":"2017-12-20 16:27:40","outstock_source":"2","status":"4","outstock_id":"12","goods_id":"62","goods_name":"草酸","goods_unit":"吨","order_qty":"100.000","goods_nature":"内贸转出口","remark":"商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注"},{"id":"11","outstock_no":"O201712206210","outstock_customer_no":"1314","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"1","create_at":"2017-12-20 16:00:13","outstock_source":"2","status":"2","outstock_id":"11","goods_id":"63","goods_name":"羧酸","goods_unit":"吨","order_qty":"520.000","goods_nature":"内贸转出口","remark":""},{"id":"10","outstock_no":"O201712202393","outstock_customer_no":"675758","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"2","create_at":"2017-12-20 15:59:45","outstock_source":"2","status":"2","outstock_id":"10","goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","order_qty":"123.000","goods_nature":"保税","remark":""},{"id":"9","outstock_no":"O201712201892","outstock_customer_no":"1213","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"1","create_at":"2017-12-20 15:59:18","outstock_source":"2","status":"2","outstock_id":"9","goods_id":"58","goods_name":"丁二烯","goods_unit":"吨","order_qty":"123.000","goods_nature":"一般进口","remark":""},{"id":"8","outstock_no":"O201712208672","outstock_customer_no":"89898","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"2","create_at":"2017-12-20 15:58:32","outstock_source":"2","status":"2","outstock_id":"8","goods_id":"23","goods_name":"氢溴酸2","goods_unit":"吨","order_qty":"666.000","goods_nature":"一般进口","remark":""},{"id":"7","outstock_no":"O201712206795","outstock_customer_no":"4564656","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"1","create_at":"2017-12-20 15:57:20","outstock_source":"2","status":"2","outstock_id":"7","goods_id":"41","goods_name":"溶剂二甲苯","goods_unit":"吨","order_qty":"444.000","goods_nature":"一般进口","remark":""},{"id":"6","outstock_no":"O201712207746","outstock_customer_no":"56456456456","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"1","create_at":"2017-12-20 15:56:06","outstock_source":"2","status":"2","outstock_id":"6","goods_id":"41","goods_name":"溶剂二甲苯","goods_unit":"吨","order_qty":"666.000","goods_nature":"内贸转出口","remark":""},{"id":"5","outstock_no":"O201712205165","outstock_customer_no":"8888","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"2","create_at":"2017-12-20 15:55:31","outstock_source":"2","status":"2","outstock_id":"5","goods_id":"38","goods_name":"有机化工","goods_unit":"吨","order_qty":"666.000","goods_nature":"内贸内销","remark":""},{"id":"4","outstock_no":"O201712208073","outstock_customer_no":"65656","real_outsock_no":null,"vendor_name":"新版","shop_company_name":"王敬测试公司","outstock_type":"2","create_at":"2017-12-20 15:54:31","outstock_source":"2","status":"2","outstock_id":"4","goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","order_qty":"123.000","goods_nature":"一般进口","remark":""}]
     * totalPage : 2
     * count_2 : 9
     * count_3 : 1
     * count_4 : 1
     * count_5 : 2
     */

    private String _url;
    private String         vendor_no;
    private String         status;
    private String         keyword1s;
    private String         outstock_customer_no;
    private String         real_outsock_no;
    private String         goods_id;
    private String         shop_company_name;
    private String         outstock_type;
    private String         removestatus;
    private String         outstock_source;
    private String         start_time;
    private String         end_time;
    private String         pageCurrent;
    private String         pageSize;
    private String         totalRow;
    private int            totalPage;
    private String         count_2;
    private String         count_3;
    private String         count_4;
    private String         count_5;
    private List<ListBean> list;

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

    public String getKeyword1s() {
        return keyword1s;
    }

    public void setKeyword1s(String keyword1s) {
        this.keyword1s = keyword1s;
    }

    public String getOutstock_customer_no() {
        return outstock_customer_no;
    }

    public void setOutstock_customer_no(String outstock_customer_no) {
        this.outstock_customer_no = outstock_customer_no;
    }

    public String getReal_outsock_no() {
        return real_outsock_no;
    }

    public void setReal_outsock_no(String real_outsock_no) {
        this.real_outsock_no = real_outsock_no;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getShop_company_name() {
        return shop_company_name;
    }

    public void setShop_company_name(String shop_company_name) {
        this.shop_company_name = shop_company_name;
    }

    public String getOutstock_type() {
        return outstock_type;
    }

    public void setOutstock_type(String outstock_type) {
        this.outstock_type = outstock_type;
    }

    public String getRemovestatus() {
        return removestatus;
    }

    public void setRemovestatus(String removestatus) {
        this.removestatus = removestatus;
    }

    public String getOutstock_source() {
        return outstock_source;
    }

    public void setOutstock_source(String outstock_source) {
        this.outstock_source = outstock_source;
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

    public String getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(String pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
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

    public String getCount_2() {
        return count_2;
    }

    public void setCount_2(String count_2) {
        this.count_2 = count_2;
    }

    public String getCount_3() {
        return count_3;
    }

    public void setCount_3(String count_3) {
        this.count_3 = count_3;
    }

    public String getCount_4() {
        return count_4;
    }

    public void setCount_4(String count_4) {
        this.count_4 = count_4;
    }

    public String getCount_5() {
        return count_5;
    }

    public void setCount_5(String count_5) {
        this.count_5 = count_5;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 13
         * outstock_no : O201712255722
         * outstock_customer_no : 81
         * real_outsock_no : null
         * vendor_name : 新版
         * shop_company_name : 王敬测试公司
         * outstock_type : 1
         * create_at : 2017-12-25 11:02:29
         * outstock_source : 2
         * status : 5
         * outstock_id : 13
         * goods_id : 513
         * goods_name : 硫酸
         * goods_unit : 吨
         * order_qty : 2.000
         * goods_nature : 内贸内销
         * remark : 备注
         */

        private String id;
        private String outstock_no;
        private String outstock_customer_no;
        private Object real_outsock_no;
        private String vendor_name;
        private String shop_company_name;
        private String outstock_type;
        private String create_at;
        private String outstock_source;
        private int status;
        private String outstock_id;
        private String goods_id;
        private String goods_name;
        private String goods_unit;
        private String order_qty;
        private String goods_nature;
        private String remark;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOutstock_no() {
            return outstock_no;
        }

        public void setOutstock_no(String outstock_no) {
            this.outstock_no = outstock_no;
        }

        public String getOutstock_customer_no() {
            return outstock_customer_no;
        }

        public void setOutstock_customer_no(String outstock_customer_no) {
            this.outstock_customer_no = outstock_customer_no;
        }

        public Object getReal_outsock_no() {
            return real_outsock_no;
        }

        public void setReal_outsock_no(Object real_outsock_no) {
            this.real_outsock_no = real_outsock_no;
        }

        public String getVendor_name() {
            return vendor_name;
        }

        public void setVendor_name(String vendor_name) {
            this.vendor_name = vendor_name;
        }

        public String getShop_company_name() {
            return shop_company_name;
        }

        public void setShop_company_name(String shop_company_name) {
            this.shop_company_name = shop_company_name;
        }

        public String getOutstock_type() {
            return outstock_type;
        }

        public void setOutstock_type(String outstock_type) {
            this.outstock_type = outstock_type;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public String getOutstock_source() {
            return outstock_source;
        }

        public void setOutstock_source(String outstock_source) {
            this.outstock_source = outstock_source;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getOutstock_id() {
            return outstock_id;
        }

        public void setOutstock_id(String outstock_id) {
            this.outstock_id = outstock_id;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_unit() {
            return goods_unit;
        }

        public void setGoods_unit(String goods_unit) {
            this.goods_unit = goods_unit;
        }

        public String getOrder_qty() {
            return order_qty;
        }

        public void setOrder_qty(String order_qty) {
            this.order_qty = order_qty;
        }

        public String getGoods_nature() {
            return goods_nature;
        }

        public void setGoods_nature(String goods_nature) {
            this.goods_nature = goods_nature;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
