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
public class OuterOrderDetail implements Serializable {


    /**
     * id : 12
     * outstock_no : O201712204423
     * outstock_customer_no : 55656
     * outstock_source : 2
     * outstock_type : 1
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
     * outstock_date : 2017-12-22
     * outstock_real_date : null
     * create_name : 王敬测试公司
     * ca_number : CA201712204115
     * ca_viewpath : https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171220162810&transaction_id=CA2017122041151822&msg_digest=MDQwMDJCOTcyRTU0QzY0RkIwMzMwOTM2RjMxMjYwOTgxRTFBOTg0MQ==
     * ca_confirm_number : null
     * ca_confirm_viewpath : null
     * real_outstock_type : 1
     * real_outsock_no : null
     * real_contact : 18015993809
     * real_contact_name : 测试
     * real_remark : null
     * status : 2
     * isdel : 0
     * isold : null
     * remark : 商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注商品明细备注
     * create_at : 2017-12-20 16:27:40
     * update_at : 2017-12-20 16:27:40
     * finish_at : null
     * goods_id : 62
     * goods_name : 草酸
     * goods_unit : 吨
     * order_qty : 100.000
     * real_qty : null
     * goods_nature : 内贸转出口
     * car : [{"id":"6","outstock_id":"12","carname":"123123","mobilephone":"12321","idcard":"123123","carid":"沪12312","carmarks":"车辆信息备注车辆信息备注车辆信息备注车辆信息备注车辆信息备注车辆信息备注车辆信息备注车辆信息备注车辆信息备注车辆信息备注车辆信息备注","create_at":"2017-12-20 16:27:44"}]
     * ship : []
     * log : []
     */

    private String id;
    private String        outstock_no;
    private String        outstock_customer_no;
    private int        outstock_source;
    private int        outstock_type;
    private String        vendor_no;
    private String        vendor_name;
    private String        shop_order_id;
    private String        shop_order_no;
    private String        shop_batch_id;
    private String        shop_contract;
    private String        shop_company_id;
    private String        shop_company_name;
    private String        shop_delivery_method;
    private String        contact;
    private String        contact_name;
    private String        outstock_date;
    private String        outstock_real_date;
    private String        create_name;
    private String        ca_number;
    private String        ca_viewpath;
    private String        ca_confirm_number;
    private String        ca_confirm_viewpath;
    private String        real_outstock_type;
    private String        real_outsock_no;
    private String        real_contact;
    private String        real_contact_name;
    private String        real_remark;
    private int        status;
    private String        isdel;
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
    private List<CarBean> car;
    private List<ShipBean>       ship;
    private List<LogBean> log;
    private List<FileBean> file;
    private String goods_remark;

    public String getGoods_remark() {
        return goods_remark;
    }

    public void setGoods_remark(String goods_remark) {
        this.goods_remark = goods_remark;
    }

    public List<FileBean> getFile() {
        return file;
    }

    public void setFile(List<FileBean> file) {
        this.file = file;
    }

    public boolean isIs_ca() {
        return is_ca;
    }

    public void setIs_ca(boolean is_ca) {
        this.is_ca = is_ca;
    }

    private boolean is_ca;

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

    public int getOutstock_source() {
        return outstock_source;
    }

    public void setOutstock_source(int outstock_source) {
        this.outstock_source = outstock_source;
    }

    public int getOutstock_type() {
        return outstock_type;
    }

    public void setOutstock_type(int outstock_type) {
        this.outstock_type = outstock_type;
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

    public String getShop_order_id() {
        return shop_order_id;
    }

    public void setShop_order_id(String shop_order_id) {
        this.shop_order_id = shop_order_id;
    }

    public String getShop_order_no() {
        return shop_order_no;
    }

    public void setShop_order_no(String shop_order_no) {
        this.shop_order_no = shop_order_no;
    }

    public String getShop_batch_id() {
        return shop_batch_id;
    }

    public void setShop_batch_id(String shop_batch_id) {
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

    public String getShop_delivery_method() {
        return shop_delivery_method;
    }

    public void setShop_delivery_method(String shop_delivery_method) {
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

    public String getOutstock_date() {
        return outstock_date;
    }

    public void setOutstock_date(String outstock_date) {
        this.outstock_date = outstock_date;
    }

    public String getOutstock_real_date() {
        return outstock_real_date;
    }

    public void setOutstock_real_date(String outstock_real_date) {
        this.outstock_real_date = outstock_real_date;
    }

    public String getCreate_name() {
        return create_name;
    }

    public void setCreate_name(String create_name) {
        this.create_name = create_name;
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

    public String getReal_outstock_type() {
        return real_outstock_type;
    }

    public void setReal_outstock_type(String real_outstock_type) {
        this.real_outstock_type = real_outstock_type;
    }

    public String getReal_outsock_no() {
        return real_outsock_no;
    }

    public void setReal_outsock_no(String real_outsock_no) {
        this.real_outsock_no = real_outsock_no;
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

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
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

    public static class LogBean implements Serializable {

        /**
         * id : 1
         * outstock_id : 1
         * outstock_detail_no : 213
         * outstock_date : 2017-12-14
         * goods_id : 1
         * goods_name : 乙二醇乙醚醋酸酯
         * goods_unit : 吨
         * goods_nature : 一般进口
         * lose_qty : 33.000
         * stock_qty : 33.000
         * number : 33
         * jar_no : adasd2312
         * remark : 33
         * create_at : 2017-12-14 13:06:53
         * update_at : 2017-12-14 13:06:53
         */

        private String id;
        private String outstock_id;
        private String outstock_detail_no;
        private String outstock_date;
        private String goods_id;
        private String goods_name;
        private String goods_unit;
        private String goods_nature;
        private String lose_qty;
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

        public String getOutstock_id() {
            return outstock_id;
        }

        public void setOutstock_id(String outstock_id) {
            this.outstock_id = outstock_id;
        }

        public String getOutstock_detail_no() {
            return outstock_detail_no;
        }

        public void setOutstock_detail_no(String outstock_detail_no) {
            this.outstock_detail_no = outstock_detail_no;
        }

        public String getOutstock_date() {
            return outstock_date;
        }

        public void setOutstock_date(String outstock_date) {
            this.outstock_date = outstock_date;
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

        public String getLose_qty() {
            return lose_qty;
        }

        public void setLose_qty(String lose_qty) {
            this.lose_qty = lose_qty;
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

    public static class CarBean implements Serializable  {


        /**
         * id : 1
         * outstock_id : 3
         * carname : 张三
         * mobilephone : 18745584587
         * idcard : 3666222
         * carid : 京A23424
         * carmarks : -
         * create_at : 2017-12-20 15:54:04
         */

        private String id;
        private String outstock_id;
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

        public String getOutstock_id() {
            return outstock_id;
        }

        public void setOutstock_id(String outstock_id) {
            this.outstock_id = outstock_id;
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



    public static class ShipBean  implements Serializable  {


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

    public static class FileBean implements Serializable {


        /**
         * id : 2
         * type : 实际入库
         * type_id : 1
         * addr : http://pic.chinayie.com/vendorFile/20171227/name5a4307f0033ef.jpg
         * status : 1
         * create_at : 2017-12-27 10:39:24
         * update_at : 2017-12-27 10:39:24
         */

        private String id;
        private String type;
        private String type_id;
        private String addr;
        private String status;
        private String create_at;
        private String update_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

}
