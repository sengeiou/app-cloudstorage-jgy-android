package com.guoyie.www.delivery.easy.entity;

import com.google.gson.annotations.SerializedName;
import com.guoyie.www.delivery.easy.base.BaseResponse;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2017/12/22
 */

public class StoreDetailBean extends BaseResponse {

    /**
     * code : 200
     * data : {"id":"11","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"5201","jar_type":"内贸罐","goods_id":"45","goods_name":"二甘醇(恒阳)","stock":"100000.000","jar_material":"碳钢","unit":"吨","remark":"","create_at":"2017-12-20 16:43:11","update_at":"2017-12-20 16:43:11"}
     */

    @SerializedName("code")
    private String codeX;
    private DataBean data;

    public String getCodeX() {
        return codeX;
    }

    public void setCodeX(String codeX) {
        this.codeX = codeX;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 11
         * vendor_no : YC0000000015
         * vendor_name : 新版
         * jar_no : 5201
         * jar_type : 内贸罐
         * goods_id : 45
         * goods_name : 二甘醇(恒阳)
         * stock : 100000.000
         * jar_material : 碳钢
         * unit : 吨
         * remark :
         * create_at : 2017-12-20 16:43:11
         * update_at : 2017-12-20 16:43:11
         */

        private String id;
        private String vendor_no;
        private String vendor_name;
        private String jar_no;
        private String jar_type;
        private String goods_id;
        private String goods_name;
        private String stock;
        private String jar_material;
        private String unit;
        private String remark;
        private String create_at;
        private String update_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getJar_no() {
            return jar_no;
        }

        public void setJar_no(String jar_no) {
            this.jar_no = jar_no;
        }

        public String getJar_type() {
            return jar_type;
        }

        public void setJar_type(String jar_type) {
            this.jar_type = jar_type;
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

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getJar_material() {
            return jar_material;
        }

        public void setJar_material(String jar_material) {
            this.jar_material = jar_material;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
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
}
