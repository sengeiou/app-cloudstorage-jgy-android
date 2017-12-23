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
public class TransstockDetail implements Serializable{


    /**
     * id : 1
     * transstock_no : T201712169215
     * shop_order_no : null
     * shop_order_id : null
     * transstock_customer_no : 113123123
     * transstock_source : 2
     * vendor_no : YC0000000015
     * vendor_name : 新版
     * shop_sale_company_id : 11898
     * shop_sale_company_name : HelloKitty
     * sale_contact : 15221489148
     * sale_contact_name : Kitty
     * shop_buy_company_id : 664
     * shop_buy_company_name : 上海国烨跨境电子商务有限公司
     * buy_contact : 13917064564
     * buy_contact_name : sdas
     * buy_freeday : 3
     * create_name : Kitty
     * ca_viewpath : https://testapi.fadada.com:8443/api//viewdocs.action?app_id=400141&send_app_id=null&v=2.0×tamp=20171216143922&transaction_id=CA2017121622241762&msg_digest=OEY1NTVBRjAxQTc4ODM4RTBFMEJGMDcxQTc4MzlERjA4Qzk3OUUyOQ==
     * status : 4
     * isdel : 0
     * remark : 3
     * create_at : 2017-12-16 14:39:20
     * finish_at : null
     * goods : [{"id":"1","transstock_goods_no":null,"goods_id":"1","goods_name":"乙二醇乙醚醋酸酯","goods_unit":"吨","trans_qty":"33.000","srock_qty":null,"goods_nature":"一般进口","remark":"3"}]
     */

    private String           id;
    private String          transstock_no;
    private Object          shop_order_no;
    private Object          shop_order_id;
    private String          transstock_customer_no;
    private String          transstock_source;
    private String          vendor_no;
    private String          vendor_name;
    private String          shop_sale_company_id;
    private String          shop_sale_company_name;
    private String          sale_contact;
    private String          sale_contact_name;
    private String          shop_buy_company_id;
    private String          shop_buy_company_name;
    private String          buy_contact;
    private String          buy_contact_name;
    private String          buy_freeday;
    private String          create_name;
    private String          ca_viewpath;
    private int          status;
    private String          isdel;
    private String          remark;
    private String          create_at;
    private Object          finish_at;
    private List<GoodsBean> goods;

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

    public Object getShop_order_no() {
        return shop_order_no;
    }

    public void setShop_order_no(Object shop_order_no) {
        this.shop_order_no = shop_order_no;
    }

    public Object getShop_order_id() {
        return shop_order_id;
    }

    public void setShop_order_id(Object shop_order_id) {
        this.shop_order_id = shop_order_id;
    }

    public String getTransstock_customer_no() {
        return transstock_customer_no;
    }

    public void setTransstock_customer_no(String transstock_customer_no) {
        this.transstock_customer_no = transstock_customer_no;
    }

    public String getTransstock_source() {
        return transstock_source;
    }

    public void setTransstock_source(String transstock_source) {
        this.transstock_source = transstock_source;
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

    public String getSale_contact() {
        return sale_contact;
    }

    public void setSale_contact(String sale_contact) {
        this.sale_contact = sale_contact;
    }

    public String getSale_contact_name() {
        return sale_contact_name;
    }

    public void setSale_contact_name(String sale_contact_name) {
        this.sale_contact_name = sale_contact_name;
    }

    public String getShop_buy_company_id() {
        return shop_buy_company_id;
    }

    public void setShop_buy_company_id(String shop_buy_company_id) {
        this.shop_buy_company_id = shop_buy_company_id;
    }

    public String getShop_buy_company_name() {
        return shop_buy_company_name;
    }

    public void setShop_buy_company_name(String shop_buy_company_name) {
        this.shop_buy_company_name = shop_buy_company_name;
    }

    public String getBuy_contact() {
        return buy_contact;
    }

    public void setBuy_contact(String buy_contact) {
        this.buy_contact = buy_contact;
    }

    public String getBuy_contact_name() {
        return buy_contact_name;
    }

    public void setBuy_contact_name(String buy_contact_name) {
        this.buy_contact_name = buy_contact_name;
    }

    public String getBuy_freeday() {
        return buy_freeday;
    }

    public void setBuy_freeday(String buy_freeday) {
        this.buy_freeday = buy_freeday;
    }

    public String getCreate_name() {
        return create_name;
    }

    public void setCreate_name(String create_name) {
        this.create_name = create_name;
    }

    public String getCa_viewpath() {
        return ca_viewpath;
    }

    public void setCa_viewpath(String ca_viewpath) {
        this.ca_viewpath = ca_viewpath;
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

    public Object getFinish_at() {
        return finish_at;
    }

    public void setFinish_at(Object finish_at) {
        this.finish_at = finish_at;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * id : 1
         * transstock_goods_no : null
         * goods_id : 1
         * goods_name : 乙二醇乙醚醋酸酯
         * goods_unit : 吨
         * trans_qty : 33.000
         * srock_qty : null
         * goods_nature : 一般进口
         * remark : 3
         */

        private String id;
        private Object transstock_goods_no;
        private String goods_id;
        private String goods_name;
        private String goods_unit;
        private String trans_qty;
        private Object srock_qty;
        private String goods_nature;
        private String remark;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getTransstock_goods_no() {
            return transstock_goods_no;
        }

        public void setTransstock_goods_no(Object transstock_goods_no) {
            this.transstock_goods_no = transstock_goods_no;
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

        public String getTrans_qty() {
            return trans_qty;
        }

        public void setTrans_qty(String trans_qty) {
            this.trans_qty = trans_qty;
        }

        public Object getSrock_qty() {
            return srock_qty;
        }

        public void setSrock_qty(Object srock_qty) {
            this.srock_qty = srock_qty;
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
