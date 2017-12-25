package com.guoyie.www.delivery.easy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/21
 */
public class InputOrderDetail implements Serializable {


    /**
     * id : 1
     * instock_no : I201712149608
     * instock_customer_no : 3123
     * instock_source : 2
     * instock_type : 1
     * create_name : HelloKitty
     * vendor_no : YC0000000015
     * vendor_name : 新版
     * shop_order_id : null
     * shop_order_no : null
     * shop_batch_id : null
     * shop_contract :
     * shop_company_id : 11898
     * shop_company_name : HelloKitty
     * shop_delivery_method : null
     * contact : 15221489148
     * contact_name : Kitty
     * instock_date : 2017-12-14
     * instock_real_date : null
     * isdel : 0
     * ca_number : CA201712144386
     * ca_viewpath : https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171214114743&transaction_id=CA2017121443861758&msg_digest=MEIwQjU1NEMwMkRBNkNEMjdFMzZFM0E2ODI0QUUzQzE0QUE1NEFBQg==
     * ca_confirm_number : CA201712144815
     * ca_confirm_viewpath : https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171214115346&transaction_id=CA2017121448151759&msg_digest=NEUzRjk2RkRBRTlBOEZERTE1MEQwOTBENzU3NzcwQkFCNkE0REMyNw==
     * real_instock_type : 1
     * real_insock_no : null
     * real_contract_no : null
     * real_contact : 18015993809
     * real_contact_name : 测试
     * real_remark : 111
     * status : 5
     * isold : 0
     * remark : 3123
     * create_at : 2017-12-14 11:47:09
     * update_at : 2017-12-14 11:52:41
     * finish_at : 2017-12-14 11:53:21
     * goods_id : 1
     * goods_name : 乙二醇乙醚醋酸酯
     * goods_unit : 吨
     * order_qty : 33.000
     * real_qty : 66.000
     * goods_nature : 一般进口
     * car : []
     * ship : []
     * log : [{"id":"1","instock_id":"1","instock_detail_no":"23123","instock_date":"2017-12-14","goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","goods_nature":"一般进口","stock_qty":"33.000","number":"333","jar_no":"adasd2312","remark":"33","create_at":"2017-12-14 11:53:06","update_at":"2017-12-14 11:53:06"},{"id":"2","instock_id":"1","instock_detail_no":"23123","instock_date":"2017-12-14","goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","goods_nature":"一般进口","stock_qty":"33.000","number":"333","jar_no":"adasd2312","remark":"33","create_at":"2017-12-14 11:53:08","update_at":"2017-12-14 11:53:08"}]
     */

    private String id;
    private String        instock_no;
    private String        instock_customer_no;
    private int        instock_source;
    private String        instock_type;
    private String        create_name;
    private String        vendor_no;
    private String        vendor_name;
    private Object        shop_order_id;
    private String        shop_order_no;
    private Object        shop_batch_id;
    private String        shop_contract;
    private String        shop_company_id;
    private String        shop_company_name;
    private Object        shop_delivery_method;
    private String        contact;
    private String        contact_name;
    private String        instock_date;
    private Object        instock_real_date;
    private String        isdel;
    private String        ca_number;
    private String        ca_viewpath;
    private String        ca_confirm_number;
    private String        ca_confirm_viewpath;
    private String        real_instock_type;
    private Object        real_insock_no;
    private Object        real_contract_no;
    private String        real_contact;
    private String        real_contact_name;
    private String        real_remark;
    private int        status;
    private String        isold;
    private String        remark;
    private String        create_at;
    private String        update_at;
    private String        finish_at;
    private String        goods_id;
    private String        goods_name;
    private String        goods_unit;
    private String        order_qty;
    private String        real_qty;
    private String        goods_nature;
    private List<CarBean>       car;
    private List<ShipBean>       ship;
    private List<LogBean> log;

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

    public int getInstock_source() {
        return instock_source;
    }

    public void setInstock_source(int instock_source) {
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

    public String getShop_order_no() {
        return shop_order_no;
    }

    public void setShop_order_no(String shop_order_no) {
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

    public String getCa_confirm_number() {
        return ca_confirm_number;
    }

    public void setCa_confirm_number(String ca_confirm_number) {
        this.ca_confirm_number = ca_confirm_number;
    }

    public String getCa_confirm_viewpath() {
        return ca_confirm_viewpath;
    }

    public void setCa_confirm_viewpath(String ca_confirm_viewpath) {
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

    public String getReal_remark() {
        return real_remark;
    }

    public void setReal_remark(String real_remark) {
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

    public String getFinish_at() {
        return finish_at;
    }

    public void setFinish_at(String finish_at) {
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

    public String getReal_qty() {
        return real_qty;
    }

    public void setReal_qty(String real_qty) {
        this.real_qty = real_qty;
    }

    public String getGoods_nature() {
        return goods_nature;
    }

    public void setGoods_nature(String goods_nature) {
        this.goods_nature = goods_nature;
    }

    public List<CarBean> getCar() {
        return car;
    }

    public void setCar(List<CarBean> car) {
        this.car = car;
    }

    public List<ShipBean> getShip() {
        return ship;
    }

    public void setShip(List<ShipBean> ship) {
        this.ship = ship;
    }

    public List<LogBean> getLog() {
        return log;
    }

    public void setLog(List<LogBean> log) {
        this.log = log;
    }

    public static class LogBean {
        /**
         * id : 1
         * instock_id : 1
         * instock_detail_no : 23123
         * instock_date : 2017-12-14
         * goods_id : 1
         * goods_name : 乙二醇乙醚醋酸酯
         * goods_unit : 吨
         * goods_nature : 一般进口
         * stock_qty : 33.000
         * number : 333
         * jar_no : adasd2312
         * remark : 33
         * create_at : 2017-12-14 11:53:06
         * update_at : 2017-12-14 11:53:06
         */

        private String id;
        private String instock_id;
        private String instock_detail_no;
        private String instock_date;
        private String goods_id;
        private String goods_name;
        private String goods_unit;
        private String goods_nature;
        private String stock_qty;
        private String number;
        private String jar_no;
        private String remark;
        private String create_at;
        private String update_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInstock_id() {
            return instock_id;
        }

        public void setInstock_id(String instock_id) {
            this.instock_id = instock_id;
        }

        public String getInstock_detail_no() {
            return instock_detail_no;
        }

        public void setInstock_detail_no(String instock_detail_no) {
            this.instock_detail_no = instock_detail_no;
        }

        public String getInstock_date() {
            return instock_date;
        }

        public void setInstock_date(String instock_date) {
            this.instock_date = instock_date;
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

        public String getGoods_nature() {
            return goods_nature;
        }

        public void setGoods_nature(String goods_nature) {
            this.goods_nature = goods_nature;
        }

        public String getStock_qty() {
            return stock_qty;
        }

        public void setStock_qty(String stock_qty) {
            this.stock_qty = stock_qty;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getJar_no() {
            return jar_no;
        }

        public void setJar_no(String jar_no) {
            this.jar_no = jar_no;
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
    }

    public static class CarBean {


        /**
         * id : 1
         * instock_id : 6
         * carname : 张三
         * mobilephone : 18745874587
         * idcard : 310
         * carid : 沪A12345
         * carmarks : -
         * create_at : 2017-12-20 15:45:53
         */

        private String id;
        private String instock_id;
        private String carname;
        private String mobilephone;
        private String idcard;
        private String carid;
        private String carmarks;
        private String create_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInstock_id() {
            return instock_id;
        }

        public void setInstock_id(String instock_id) {
            this.instock_id = instock_id;
        }

        public String getCarname() {
            return carname;
        }

        public void setCarname(String carname) {
            this.carname = carname;
        }

        public String getMobilephone() {
            return mobilephone;
        }

        public void setMobilephone(String mobilephone) {
            this.mobilephone = mobilephone;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getCarid() {
            return carid;
        }

        public void setCarid(String carid) {
            this.carid = carid;
        }

        public String getCarmarks() {
            return carmarks;
        }

        public void setCarmarks(String carmarks) {
            this.carmarks = carmarks;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }
    }



    public static class ShipBean {


        /**
         * id : 1
         * instock_id : 5
         * shipname : 海伦号
         * shipno : 654
         * captain : 杰克
         * shipcontact : 12345678
         * shipmark : -
         * created_at : 2017-12-20 15:44:46
         */

        private String id;
        private String instock_id;
        private String shipname;
        private String shipno;
        private String captain;
        private String shipcontact;
        private String shipmark;
        private String created_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInstock_id() {
            return instock_id;
        }

        public void setInstock_id(String instock_id) {
            this.instock_id = instock_id;
        }

        public String getShipname() {
            return shipname;
        }

        public void setShipname(String shipname) {
            this.shipname = shipname;
        }

        public String getShipno() {
            return shipno;
        }

        public void setShipno(String shipno) {
            this.shipno = shipno;
        }

        public String getCaptain() {
            return captain;
        }

        public void setCaptain(String captain) {
            this.captain = captain;
        }

        public String getShipcontact() {
            return shipcontact;
        }

        public void setShipcontact(String shipcontact) {
            this.shipcontact = shipcontact;
        }

        public String getShipmark() {
            return shipmark;
        }

        public void setShipmark(String shipmark) {
            this.shipmark = shipmark;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }

}
