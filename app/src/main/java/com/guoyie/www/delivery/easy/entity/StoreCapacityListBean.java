package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.util.List;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2017/12/22
 */

public class StoreCapacityListBean extends BaseResponse{

    /**
     * code : 200
     * msg : 库容列表
     * data : {"_url":"/index.php/","vendor_no":"YC0000000015","pageSize":"9","pageCurrent":"1","totalRow":"6","totalPage":1,"list":[{"id":"7","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"5555","city_code":"120100","goods_id":"38","province_name":"天津市","area_code":"","goods_name":"有机化工","goods_nature":"内贸内销","goods_unit":"吨","goods_stock":"5000.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"2500.000","goods_storage_price":"98.000","remark":"","create_at":"2017-12-22 15:27:07","update_at":"2017-12-22 15:27:07"},{"id":"12","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"888","city_code":"120100","goods_id":"61","province_name":"天津市","area_code":"","goods_name":"醋酸","goods_nature":"一般进口","goods_unit":"吨","goods_stock":"2000.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"1000.000","goods_storage_price":"90.000","remark":"","create_at":"2017-12-22 15:26:09","update_at":"2017-12-22 15:26:09"},{"id":"4","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"520","city_code":"120100","goods_id":"34","province_name":"天津市","area_code":"","goods_name":"甲苯","goods_nature":"一般进口","goods_unit":"吨","goods_stock":"800.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"300.000","goods_storage_price":"100.000","remark":"","create_at":"2017-12-22 15:25:24","update_at":"2017-12-22 15:25:24"},{"id":"8","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"1314","city_code":"120100","goods_id":"45","province_name":"天津市","area_code":"","goods_name":"二甘醇(恒阳)","goods_nature":"内贸内销","goods_unit":"吨","goods_stock":"600.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"1400.000","goods_storage_price":"100.000","remark":"","create_at":"2017-12-22 15:23:30","update_at":"2017-12-22 15:23:30"},{"id":"5","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"93950","city_code":"120100","goods_id":"88","province_name":"天津市","area_code":"","goods_name":"烧碱（氢氧化钠）","goods_nature":"内贸内销","goods_unit":"吨","goods_stock":"2000.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"2000.000","goods_storage_price":"50.000","remark":"29191919581952","create_at":"2017-12-20 16:22:55","update_at":"2017-12-20 16:22:55"},{"id":"3","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"adasd2312","city_code":"120100","goods_id":"2","province_name":"天津市","area_code":"","goods_name":"我企鹅体验完全统一","goods_nature":"内贸转出口","goods_unit":"吨","goods_stock":"3.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"3.000","goods_storage_price":"3.000","remark":"","create_at":"2017-12-14 11:39:40","update_at":"2017-12-14 11:39:40"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _url : /index.php/
         * vendor_no : YC0000000015
         * pageSize : 9
         * pageCurrent : 1
         * totalRow : 6
         * totalPage : 1
         * list : [{"id":"7","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"5555","city_code":"120100","goods_id":"38","province_name":"天津市","area_code":"","goods_name":"有机化工","goods_nature":"内贸内销","goods_unit":"吨","goods_stock":"5000.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"2500.000","goods_storage_price":"98.000","remark":"","create_at":"2017-12-22 15:27:07","update_at":"2017-12-22 15:27:07"},{"id":"12","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"888","city_code":"120100","goods_id":"61","province_name":"天津市","area_code":"","goods_name":"醋酸","goods_nature":"一般进口","goods_unit":"吨","goods_stock":"2000.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"1000.000","goods_storage_price":"90.000","remark":"","create_at":"2017-12-22 15:26:09","update_at":"2017-12-22 15:26:09"},{"id":"4","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"520","city_code":"120100","goods_id":"34","province_name":"天津市","area_code":"","goods_name":"甲苯","goods_nature":"一般进口","goods_unit":"吨","goods_stock":"800.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"300.000","goods_storage_price":"100.000","remark":"","create_at":"2017-12-22 15:25:24","update_at":"2017-12-22 15:25:24"},{"id":"8","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"1314","city_code":"120100","goods_id":"45","province_name":"天津市","area_code":"","goods_name":"二甘醇(恒阳)","goods_nature":"内贸内销","goods_unit":"吨","goods_stock":"600.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"1400.000","goods_storage_price":"100.000","remark":"","create_at":"2017-12-22 15:23:30","update_at":"2017-12-22 15:23:30"},{"id":"5","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"93950","city_code":"120100","goods_id":"88","province_name":"天津市","area_code":"","goods_name":"烧碱（氢氧化钠）","goods_nature":"内贸内销","goods_unit":"吨","goods_stock":"2000.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"2000.000","goods_storage_price":"50.000","remark":"29191919581952","create_at":"2017-12-20 16:22:55","update_at":"2017-12-20 16:22:55"},{"id":"3","vendor_no":"YC0000000015","vendor_name":"新版","province_code":"120000","city_name":"天津市","area_name":"","stock_no":"adasd2312","city_code":"120100","goods_id":"2","province_name":"天津市","area_code":"","goods_name":"我企鹅体验完全统一","goods_nature":"内贸转出口","goods_unit":"吨","goods_stock":"3.000","goods_check_stock":"0.000","goods_audit_stock":"0.000","goods_empty_volume":"3.000","goods_storage_price":"3.000","remark":"","create_at":"2017-12-14 11:39:40","update_at":"2017-12-14 11:39:40"}]
         */

        private String _url;
        private String vendor_no;
        private String pageSize;
        private String pageCurrent;
        private String totalRow;
        private int totalPage;
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
             * id : 7
             * vendor_no : YC0000000015
             * vendor_name : 新版
             * province_code : 120000
             * city_name : 天津市
             * area_name :
             * stock_no : 5555
             * city_code : 120100
             * goods_id : 38
             * province_name : 天津市
             * area_code :
             * goods_name : 有机化工
             * goods_nature : 内贸内销
             * goods_unit : 吨
             * goods_stock : 5000.000
             * goods_check_stock : 0.000
             * goods_audit_stock : 0.000
             * goods_empty_volume : 2500.000
             * goods_storage_price : 98.000
             * remark :
             * create_at : 2017-12-22 15:27:07
             * update_at : 2017-12-22 15:27:07
             */

            private String id;
            private String vendor_no;
            private String vendor_name;
            private String province_code;
            private String city_name;
            private String area_name;
            private String stock_no;
            private String city_code;
            private String goods_id;
            private String province_name;
            private String area_code;
            private String goods_name;
            private String goods_nature;
            private String goods_unit;
            private String goods_stock;
            private String goods_check_stock;
            private String goods_audit_stock;
            private String goods_empty_volume;
            private String goods_storage_price;
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

            public String getProvince_code() {
                return province_code;
            }

            public void setProvince_code(String province_code) {
                this.province_code = province_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public String getStock_no() {
                return stock_no;
            }

            public void setStock_no(String stock_no) {
                this.stock_no = stock_no;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getProvince_name() {
                return province_name;
            }

            public void setProvince_name(String province_name) {
                this.province_name = province_name;
            }

            public String getArea_code() {
                return area_code;
            }

            public void setArea_code(String area_code) {
                this.area_code = area_code;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_nature() {
                return goods_nature;
            }

            public void setGoods_nature(String goods_nature) {
                this.goods_nature = goods_nature;
            }

            public String getGoods_unit() {
                return goods_unit;
            }

            public void setGoods_unit(String goods_unit) {
                this.goods_unit = goods_unit;
            }

            public String getGoods_stock() {
                return goods_stock;
            }

            public void setGoods_stock(String goods_stock) {
                this.goods_stock = goods_stock;
            }

            public String getGoods_check_stock() {
                return goods_check_stock;
            }

            public void setGoods_check_stock(String goods_check_stock) {
                this.goods_check_stock = goods_check_stock;
            }

            public String getGoods_audit_stock() {
                return goods_audit_stock;
            }

            public void setGoods_audit_stock(String goods_audit_stock) {
                this.goods_audit_stock = goods_audit_stock;
            }

            public String getGoods_empty_volume() {
                return goods_empty_volume;
            }

            public void setGoods_empty_volume(String goods_empty_volume) {
                this.goods_empty_volume = goods_empty_volume;
            }

            public String getGoods_storage_price() {
                return goods_storage_price;
            }

            public void setGoods_storage_price(String goods_storage_price) {
                this.goods_storage_price = goods_storage_price;
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
}
