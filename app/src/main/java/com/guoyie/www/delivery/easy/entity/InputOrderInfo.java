package com.guoyie.www.delivery.easy.entity;

import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/20
 */
public class InputOrderInfo {


    /**
     * _url : /index.php/
     * vendor_no : YC0000000015
     * status : 2
     * advance_searchtxt :
     * instock_customer_no :
     * real_insock_no :
     * goods_id :
     * shop_company_id :
     * instock_type :
     * create_at_start :
     * create_at_end :
     * isdel :
     * pageCurrent : 1
     * pageSize : 10
     * totalRow : 8
     * list : [{"id":"12","instock_no":"I201712207673","instock_customer_no":"65656","instock_source":"2","instock_type":"1","create_name":"wangjing","vendor_no":"YC0000000015","vendor_name":"新版","shop_order_id":null,"shop_order_no":null,"shop_batch_id":null,"shop_contract":"","shop_company_id":"11931","shop_company_name":"王敬测试公司","shop_delivery_method":null,"contact":"15156875945","contact_name":"王敬","instock_date":"2017-12-22","instock_real_date":null,"isdel":"0","ca_number":"CA201712200832","ca_viewpath":"https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220162538&transaction_id=CA2017122008321821&msg_digest=RkM1QzI0NTk2OTM3ODY5NkM0QTNEOUU1RTE5ODhENDgzOEFBQ0M4Qw==","ca_confirm_number":null,"ca_confirm_viewpath":null,"real_instock_type":"1","real_insock_no":null,"real_contract_no":null,"real_contact":"18015993809","real_contact_name":"测试","real_remark":null,"status":"2","isold":"0","remark":"入库单备注入库单备注入库单备注入库单备注入库11111单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注","create_at":"2017-12-20 16:25:08","update_at":"2017-12-20 16:25:12","finish_at":null,"goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","order_qty":"100.000","goods_nature":"内贸转出口"},{"id":"11","instock_no":"I201712208111","instock_customer_no":"2017123155535655","instock_source":"2","instock_type":"1","create_name":"wangjing","vendor_no":"YC0000000015","vendor_name":"新版","shop_order_id":null,"shop_order_no":null,"shop_batch_id":null,"shop_contract":"","shop_company_id":"11931","shop_company_name":"王敬测试公司","shop_delivery_method":null,"contact":"15156875945","contact_name":"王敬","instock_date":"2017-12-25","instock_real_date":null,"isdel":"0","ca_number":"CA201712200715","ca_viewpath":"https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220155236&transaction_id=CA2017122007151774&msg_digest=RTE5QkI5OEFGQ0Y2RDk1REMyM0JEREM1QkI2Q0ZEQUE1NzY1NEVERg==","ca_confirm_number":null,"ca_confirm_viewpath":null,"real_instock_type":"1","real_insock_no":null,"real_contract_no":null,"real_contact":"18015993809","real_contact_name":"测试","real_remark":null,"status":"2","isold":"0","remark":"","create_at":"2017-12-20 15:52:07","update_at":"2017-12-20 15:52:10","finish_at":null,"goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","order_qty":"123.000","goods_nature":"保税"},{"id":"10","instock_no":"I201712207829","instock_customer_no":"6666","instock_source":"2","instock_type":"2","create_name":"wangjing","vendor_no":"YC0000000015","vendor_name":"新版","shop_order_id":null,"shop_order_no":null,"shop_batch_id":null,"shop_contract":"","shop_company_id":"11931","shop_company_name":"王敬测试公司","shop_delivery_method":null,"contact":"15156875945","contact_name":"王敬","instock_date":"2017-12-22","instock_real_date":null,"isdel":"0","ca_number":"CA201712202600","ca_viewpath":"https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220155155&transaction_id=CA2017122026001773&msg_digest=QjU2MkU0MTZBQzlBRUMzRURBRjE1OUFFMDI1NkJEQTNGRkRBMjUzQQ==","ca_confirm_number":null,"ca_confirm_viewpath":null,"real_instock_type":"2","real_insock_no":null,"real_contract_no":null,"real_contact":"18015993809","real_contact_name":"测试","real_remark":null,"status":"2","isold":"0","remark":"","create_at":"2017-12-20 15:51:25","update_at":"2017-12-20 15:51:29","finish_at":null,"goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","order_qty":"123.000","goods_nature":"内贸内销"},{"id":"8","instock_no":"I201712203070","instock_customer_no":"789","instock_source":"2","instock_type":"2","create_name":"wangjing","vendor_no":"YC0000000015","vendor_name":"新版","shop_order_id":null,"shop_order_no":null,"shop_batch_id":null,"shop_contract":"","shop_company_id":"11931","shop_company_name":"王敬测试公司","shop_delivery_method":null,"contact":"15156875945","contact_name":"王敬","instock_date":"2017-12-28","instock_real_date":null,"isdel":"0","ca_number":"CA201712204806","ca_viewpath":"https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220154817&transaction_id=CA2017122048061771&msg_digest=NzdDRTQxQTIwMTcwN0ZFQTZFNUY5ODQ3NjBEQjg0QUE1OTM3QzY1MA==","ca_confirm_number":null,"ca_confirm_viewpath":null,"real_instock_type":"2","real_insock_no":null,"real_contract_no":null,"real_contact":"18015993809","real_contact_name":"测试","real_remark":null,"status":"2","isold":"0","remark":"","create_at":"2017-12-20 15:47:47","update_at":"2017-12-20 15:47:51","finish_at":null,"goods_id":"23","goods_name":"氢溴酸2","goods_unit":"吨","order_qty":"888.000","goods_nature":"内贸转出口"},{"id":"7","instock_no":"I201712209600","instock_customer_no":"888888","instock_source":"2","instock_type":"2","create_name":"wangjing","vendor_no":"YC0000000015","vendor_name":"新版","shop_order_id":null,"shop_order_no":null,"shop_batch_id":null,"shop_contract":"","shop_company_id":"11931","shop_company_name":"王敬测试公司","shop_delivery_method":null,"contact":"15156875945","contact_name":"王敬","instock_date":"2017-12-26","instock_real_date":null,"isdel":"0","ca_number":"CA201712203454","ca_viewpath":"https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220154704&transaction_id=CA2017122034541770&msg_digest=NUQ0NkMxMDJGRkE2QzRGOTlDREM4QzFFQTY1MUExODVCNjQwRkE4NQ==","ca_confirm_number":null,"ca_confirm_viewpath":null,"real_instock_type":"2","real_insock_no":null,"real_contract_no":null,"real_contact":"18015993809","real_contact_name":"测试","real_remark":null,"status":"2","isold":"0","remark":"","create_at":"2017-12-20 15:46:34","update_at":"2017-12-20 15:46:38","finish_at":null,"goods_id":"41","goods_name":"溶剂二甲苯","goods_unit":"吨","order_qty":"888.000","goods_nature":"内贸转出口"},{"id":"6","instock_no":"I201712209780","instock_customer_no":"2017103155535655","instock_source":"2","instock_type":"1","create_name":"wangjing","vendor_no":"YC0000000015","vendor_name":"新版","shop_order_id":null,"shop_order_no":null,"shop_batch_id":null,"shop_contract":"","shop_company_id":"11931","shop_company_name":"王敬测试公司","shop_delivery_method":null,"contact":"15156875945","contact_name":"王敬","instock_date":"2017-12-29","instock_real_date":null,"isdel":"0","ca_number":"CA201712204992","ca_viewpath":"https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220154619&transaction_id=CA2017122049921769&msg_digest=MzJBMjZGNTdDNDhFODdCMjc4RENBODhDMDY5MzNENDk2Qzc1OEZFMA==","ca_confirm_number":null,"ca_confirm_viewpath":null,"real_instock_type":"1","real_insock_no":null,"real_contract_no":null,"real_contact":"18015993809","real_contact_name":"测试","real_remark":null,"status":"2","isold":"0","remark":"","create_at":"2017-12-20 15:45:49","update_at":"2017-12-20 15:45:53","finish_at":null,"goods_id":"38","goods_name":"有机化工","goods_unit":"吨","order_qty":"123.000","goods_nature":"内贸内销"},{"id":"5","instock_no":"I201712209825","instock_customer_no":"44444","instock_source":"2","instock_type":"2","create_name":"wangjing","vendor_no":"YC0000000015","vendor_name":"新版","shop_order_id":null,"shop_order_no":null,"shop_batch_id":null,"shop_contract":"","shop_company_id":"11931","shop_company_name":"王敬测试公司","shop_delivery_method":null,"contact":"15156875945","contact_name":"王敬","instock_date":"2017-12-28","instock_real_date":null,"isdel":"0","ca_number":"CA201712203716","ca_viewpath":"https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220154512&transaction_id=CA2017122037161768&msg_digest=RUVFNEU3NDg0NzQ2MURCMTZCODgzNEMyRTk4MzdFRUQwRjJBMzhBQQ==","ca_confirm_number":null,"ca_confirm_viewpath":null,"real_instock_type":"2","real_insock_no":null,"real_contract_no":null,"real_contact":"18015993809","real_contact_name":"测试","real_remark":null,"status":"2","isold":"0","remark":"","create_at":"2017-12-20 15:44:37","update_at":"2017-12-20 15:44:46","finish_at":null,"goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","order_qty":"123.000","goods_nature":"内贸内销"},{"id":"4","instock_no":"I201712206104","instock_customer_no":"666","instock_source":"2","instock_type":"1","create_name":"wangjing","vendor_no":"YC0000000015","vendor_name":"新版","shop_order_id":null,"shop_order_no":null,"shop_batch_id":null,"shop_contract":"","shop_company_id":"11931","shop_company_name":"王敬测试公司","shop_delivery_method":null,"contact":"15156875945","contact_name":"王敬","instock_date":"2017-12-24","instock_real_date":null,"isdel":"0","ca_number":"CA201712204609","ca_viewpath":"https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220154315&transaction_id=CA2017122046091767&msg_digest=QUM1NTRGMEM0NjE0MEIzNDQxRkJCNjk4ODcxMTExMTY2RUUwRTg4NQ==","ca_confirm_number":null,"ca_confirm_viewpath":null,"real_instock_type":"1","real_insock_no":null,"real_contract_no":null,"real_contact":"18015993809","real_contact_name":"测试","real_remark":null,"status":"2","isold":"0","remark":"","create_at":"2017-12-20 15:42:45","update_at":"2017-12-20 15:42:49","finish_at":null,"goods_id":"34","goods_name":"甲苯","goods_unit":"吨","order_qty":"456.000","goods_nature":"内贸内销"}]
     * totalPage : 1
     * count_2 : 8
     * count_3 : 1
     * count_4 : 1
     * count_5 : 5
     */

    private String _url;
    private String         vendor_no;
    private String         status;
    private String         advance_searchtxt;
    private String         instock_customer_no;
    private String         real_insock_no;
    private String         goods_id;
    private String         shop_company_id;
    private String         instock_type;
    private String         create_at_start;
    private String         create_at_end;
    private String         isdel;
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

    public String getAdvance_searchtxt() {
        return advance_searchtxt;
    }

    public void setAdvance_searchtxt(String advance_searchtxt) {
        this.advance_searchtxt = advance_searchtxt;
    }

    public String getInstock_customer_no() {
        return instock_customer_no;
    }

    public void setInstock_customer_no(String instock_customer_no) {
        this.instock_customer_no = instock_customer_no;
    }

    public String getReal_insock_no() {
        return real_insock_no;
    }

    public void setReal_insock_no(String real_insock_no) {
        this.real_insock_no = real_insock_no;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getShop_company_id() {
        return shop_company_id;
    }

    public void setShop_company_id(String shop_company_id) {
        this.shop_company_id = shop_company_id;
    }

    public String getInstock_type() {
        return instock_type;
    }

    public void setInstock_type(String instock_type) {
        this.instock_type = instock_type;
    }

    public String getCreate_at_start() {
        return create_at_start;
    }

    public void setCreate_at_start(String create_at_start) {
        this.create_at_start = create_at_start;
    }

    public String getCreate_at_end() {
        return create_at_end;
    }

    public void setCreate_at_end(String create_at_end) {
        this.create_at_end = create_at_end;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
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
         * id : 12
         * instock_no : I201712207673
         * instock_customer_no : 65656
         * instock_source : 2
         * instock_type : 1
         * create_name : wangjing
         * vendor_no : YC0000000015
         * vendor_name : 新版
         * shop_order_id : null
         * shop_order_no : null
         * shop_batch_id : null
         * shop_contract :
         * shop_company_id : 11931
         * shop_company_name : 王敬测试公司
         * shop_delivery_method : null
         * contact : 15156875945
         * contact_name : 王敬
         * instock_date : 2017-12-22
         * instock_real_date : null
         * isdel : 0
         * ca_number : CA201712200832
         * ca_viewpath : https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220162538&transaction_id=CA2017122008321821&msg_digest=RkM1QzI0NTk2OTM3ODY5NkM0QTNEOUU1RTE5ODhENDgzOEFBQ0M4Qw==
         * ca_confirm_number : null
         * ca_confirm_viewpath : null
         * real_instock_type : 1
         * real_insock_no : null
         * real_contract_no : null
         * real_contact : 18015993809
         * real_contact_name : 测试
         * real_remark : null
         * status : 2
         * isold : 0
         * remark : 入库单备注入库单备注入库单备注入库单备注入库11111单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注入库单备注
         * create_at : 2017-12-20 16:25:08
         * update_at : 2017-12-20 16:25:12
         * finish_at : null
         * goods_id : 1
         * goods_name : 乙二醇乙醚醋酸酯
         * goods_unit : 吨
         * order_qty : 100.000
         * goods_nature : 内贸转出口
         */

        private String id;
        private String instock_no;
        private String instock_customer_no;
        private String instock_source;
        private String instock_type;
        private String create_name;
        private String vendor_no;
        private String vendor_name;
        private Object shop_order_id;
        private Object shop_order_no;
        private Object shop_batch_id;
        private String shop_contract;
        private String shop_company_id;
        private String shop_company_name;
        private Object shop_delivery_method;
        private String contact;
        private String contact_name;
        private String instock_date;
        private Object instock_real_date;
        private String isdel;
        private String ca_number;
        private String ca_viewpath;
        private Object ca_confirm_number;
        private Object ca_confirm_viewpath;
        private String real_instock_type;
        private Object real_insock_no;
        private Object real_contract_no;
        private String real_contact;
        private String real_contact_name;
        private Object real_remark;
        private int status;
        private String isold;
        private String remark;
        private String create_at;
        private String update_at;
        private Object finish_at;
        private String goods_id;
        private String goods_name;
        private String goods_unit;
        private String order_qty;
        private String goods_nature;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInstock_no() {
            return instock_no;
        }

        public void setInstock_no(String instock_no) {
            this.instock_no = instock_no;
        }

        public String getInstock_customer_no() {
            return instock_customer_no;
        }

        public void setInstock_customer_no(String instock_customer_no) {
            this.instock_customer_no = instock_customer_no;
        }

        public String getInstock_source() {
            return instock_source;
        }

        public void setInstock_source(String instock_source) {
            this.instock_source = instock_source;
        }

        public String getInstock_type() {
            return instock_type;
        }

        public void setInstock_type(String instock_type) {
            this.instock_type = instock_type;
        }

        public String getCreate_name() {
            return create_name;
        }

        public void setCreate_name(String create_name) {
            this.create_name = create_name;
        }

        public String getVendor_no() {
            return vendor_no;
        }

        public void setVendor_no(String vendor_no) {
            this.vendor_no = vendor_no;
        }

        public String getVendor_name() {
            return vendor_name;
        }

        public void setVendor_name(String vendor_name) {
            this.vendor_name = vendor_name;
        }

        public Object getShop_order_id() {
            return shop_order_id;
        }

        public void setShop_order_id(Object shop_order_id) {
            this.shop_order_id = shop_order_id;
        }

        public Object getShop_order_no() {
            return shop_order_no;
        }

        public void setShop_order_no(Object shop_order_no) {
            this.shop_order_no = shop_order_no;
        }

        public Object getShop_batch_id() {
            return shop_batch_id;
        }

        public void setShop_batch_id(Object shop_batch_id) {
            this.shop_batch_id = shop_batch_id;
        }

        public String getShop_contract() {
            return shop_contract;
        }

        public void setShop_contract(String shop_contract) {
            this.shop_contract = shop_contract;
        }

        public String getShop_company_id() {
            return shop_company_id;
        }

        public void setShop_company_id(String shop_company_id) {
            this.shop_company_id = shop_company_id;
        }

        public String getShop_company_name() {
            return shop_company_name;
        }

        public void setShop_company_name(String shop_company_name) {
            this.shop_company_name = shop_company_name;
        }

        public Object getShop_delivery_method() {
            return shop_delivery_method;
        }

        public void setShop_delivery_method(Object shop_delivery_method) {
            this.shop_delivery_method = shop_delivery_method;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getContact_name() {
            return contact_name;
        }

        public void setContact_name(String contact_name) {
            this.contact_name = contact_name;
        }

        public String getInstock_date() {
            return instock_date;
        }

        public void setInstock_date(String instock_date) {
            this.instock_date = instock_date;
        }

        public Object getInstock_real_date() {
            return instock_real_date;
        }

        public void setInstock_real_date(Object instock_real_date) {
            this.instock_real_date = instock_real_date;
        }

        public String getIsdel() {
            return isdel;
        }

        public void setIsdel(String isdel) {
            this.isdel = isdel;
        }

        public String getCa_number() {
            return ca_number;
        }

        public void setCa_number(String ca_number) {
            this.ca_number = ca_number;
        }

        public String getCa_viewpath() {
            return ca_viewpath;
        }

        public void setCa_viewpath(String ca_viewpath) {
            this.ca_viewpath = ca_viewpath;
        }

        public Object getCa_confirm_number() {
            return ca_confirm_number;
        }

        public void setCa_confirm_number(Object ca_confirm_number) {
            this.ca_confirm_number = ca_confirm_number;
        }

        public Object getCa_confirm_viewpath() {
            return ca_confirm_viewpath;
        }

        public void setCa_confirm_viewpath(Object ca_confirm_viewpath) {
            this.ca_confirm_viewpath = ca_confirm_viewpath;
        }

        public String getReal_instock_type() {
            return real_instock_type;
        }

        public void setReal_instock_type(String real_instock_type) {
            this.real_instock_type = real_instock_type;
        }

        public Object getReal_insock_no() {
            return real_insock_no;
        }

        public void setReal_insock_no(Object real_insock_no) {
            this.real_insock_no = real_insock_no;
        }

        public Object getReal_contract_no() {
            return real_contract_no;
        }

        public void setReal_contract_no(Object real_contract_no) {
            this.real_contract_no = real_contract_no;
        }

        public String getReal_contact() {
            return real_contact;
        }

        public void setReal_contact(String real_contact) {
            this.real_contact = real_contact;
        }

        public String getReal_contact_name() {
            return real_contact_name;
        }

        public void setReal_contact_name(String real_contact_name) {
            this.real_contact_name = real_contact_name;
        }

        public Object getReal_remark() {
            return real_remark;
        }

        public void setReal_remark(Object real_remark) {
            this.real_remark = real_remark;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getIsold() {
            return isold;
        }

        public void setIsold(String isold) {
            this.isold = isold;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public String getUpdate_at() {
            return update_at;
        }

        public void setUpdate_at(String update_at) {
            this.update_at = update_at;
        }

        public Object getFinish_at() {
            return finish_at;
        }

        public void setFinish_at(Object finish_at) {
            this.finish_at = finish_at;
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
    }
}
