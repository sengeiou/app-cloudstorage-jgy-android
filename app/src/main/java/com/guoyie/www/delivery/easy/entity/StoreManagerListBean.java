package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.util.List;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2017/12/21
 */

public class StoreManagerListBean extends BaseResponse{

    /**
     * code : 200
     * msg : 储罐列表
     * data : {"_url":"/index.php/","vendor_no":"YC0000000015","jar_no":"","goods_name":"","jar_material":"","pageSize":"9","pageCurrent":"1","orders":"update_at desc","totalRow":"9","list":[{"id":"11","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"5201","jar_type":"内贸罐","goods_id":"45","goods_name":"二甘醇(恒阳)","stock":"100000.000","jar_material":"碳钢","unit":"吨","remark":"","create_at":"2017-12-20 16:43:11","update_at":"2017-12-20 16:43:11"},{"id":"10","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"93950","jar_type":"内贸罐","goods_id":"88","goods_name":"烧碱（氢氧化钠）","stock":"2000.000","jar_material":"碳钢","unit":"吨","remark":"","create_at":"2017-12-20 16:21:58","update_at":"2017-12-20 16:21:58"},{"id":"9","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"520","jar_type":"外贸罐","goods_id":"165","goods_name":"石脑油","stock":"6000.000","jar_material":"123","unit":"千克","remark":"","create_at":"2017-12-20 16:19:22","update_at":"2017-12-20 16:19:22"},{"id":"8","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"555","jar_type":"外贸罐","goods_id":"148","goods_name":"混合芳烃","stock":"900.000","jar_material":"666","unit":"立方米","remark":"","create_at":"2017-12-20 16:18:29","update_at":"2017-12-20 16:18:29"},{"id":"7","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"123","jar_type":"保税罐","goods_id":"44","goods_name":"纯苯","stock":"3000.000","jar_material":"555","unit":"吨","remark":"","create_at":"2017-12-20 16:17:59","update_at":"2017-12-20 16:17:59"},{"id":"6","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"777","jar_type":"外贸罐","goods_id":"54","goods_name":"辛醇","stock":"2000.000","jar_material":"pvc","unit":"吨","remark":"","create_at":"2017-12-20 16:17:42","update_at":"2017-12-20 16:17:42"},{"id":"5","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"888","jar_type":"内贸罐","goods_id":"63","goods_name":"羧酸","stock":"1000.000","jar_material":"123","unit":"吨","remark":"","create_at":"2017-12-20 16:16:10","update_at":"2017-12-20 16:16:10"},{"id":"4","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"666","jar_type":"内贸罐","goods_id":"34","goods_name":"甲苯","stock":"6000.000","jar_material":"pvc","unit":"吨","remark":"","create_at":"2017-12-20 16:15:43","update_at":"2017-12-20 16:15:43"},{"id":"3","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"adasd2312","jar_type":"外贸罐","goods_id":"2","goods_name":"我企鹅体验完全统一","stock":"111.000","jar_material":"3333","unit":"吨","remark":"","create_at":"2017-12-14 10:13:54","update_at":"2017-12-14 10:13:54"}],"totalPage":1}
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
         * jar_no :
         * goods_name :
         * jar_material :
         * pageSize : 9             *
         * pageCurrent : 1          *
         * orders : update_at desc
         * totalRow : 9
         * list : [{"id":"11","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"5201","jar_type":"内贸罐","goods_id":"45","goods_name":"二甘醇(恒阳)","stock":"100000.000","jar_material":"碳钢","unit":"吨","remark":"","create_at":"2017-12-20 16:43:11","update_at":"2017-12-20 16:43:11"},{"id":"10","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"93950","jar_type":"内贸罐","goods_id":"88","goods_name":"烧碱（氢氧化钠）","stock":"2000.000","jar_material":"碳钢","unit":"吨","remark":"","create_at":"2017-12-20 16:21:58","update_at":"2017-12-20 16:21:58"},{"id":"9","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"520","jar_type":"外贸罐","goods_id":"165","goods_name":"石脑油","stock":"6000.000","jar_material":"123","unit":"千克","remark":"","create_at":"2017-12-20 16:19:22","update_at":"2017-12-20 16:19:22"},{"id":"8","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"555","jar_type":"外贸罐","goods_id":"148","goods_name":"混合芳烃","stock":"900.000","jar_material":"666","unit":"立方米","remark":"","create_at":"2017-12-20 16:18:29","update_at":"2017-12-20 16:18:29"},{"id":"7","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"123","jar_type":"保税罐","goods_id":"44","goods_name":"纯苯","stock":"3000.000","jar_material":"555","unit":"吨","remark":"","create_at":"2017-12-20 16:17:59","update_at":"2017-12-20 16:17:59"},{"id":"6","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"777","jar_type":"外贸罐","goods_id":"54","goods_name":"辛醇","stock":"2000.000","jar_material":"pvc","unit":"吨","remark":"","create_at":"2017-12-20 16:17:42","update_at":"2017-12-20 16:17:42"},{"id":"5","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"888","jar_type":"内贸罐","goods_id":"63","goods_name":"羧酸","stock":"1000.000","jar_material":"123","unit":"吨","remark":"","create_at":"2017-12-20 16:16:10","update_at":"2017-12-20 16:16:10"},{"id":"4","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"666","jar_type":"内贸罐","goods_id":"34","goods_name":"甲苯","stock":"6000.000","jar_material":"pvc","unit":"吨","remark":"","create_at":"2017-12-20 16:15:43","update_at":"2017-12-20 16:15:43"},{"id":"3","vendor_no":"YC0000000015","vendor_name":"新版","jar_no":"adasd2312","jar_type":"外贸罐","goods_id":"2","goods_name":"我企鹅体验完全统一","stock":"111.000","jar_material":"3333","unit":"吨","remark":"","create_at":"2017-12-14 10:13:54","update_at":"2017-12-14 10:13:54"}]
         * totalPage : 1
         */

        private String _url;
        private String vendor_no;
        private String jar_no;
        private String goods_name;
        private String jar_material;
        private String pageSize;
        private String pageCurrent;
        private String orders;
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

        public String getJar_no() {
            return jar_no;
        }

        public void setJar_no(String jar_no) {
            this.jar_no = jar_no;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getJar_material() {
            return jar_material;
        }

        public void setJar_material(String jar_material) {
            this.jar_material = jar_material;
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

        public String getOrders() {
            return orders;
        }

        public void setOrders(String orders) {
            this.orders = orders;
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
             * id : 11
             * vendor_no : YC0000000015      *
             * vendor_name : 新版
             * jar_no : 5201                  *
             * jar_type : 内贸罐
             * goods_id : 45
             * goods_name : 二甘醇(恒阳)         *
             * stock : 100000.000
             * jar_material : 碳钢              *
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
}
