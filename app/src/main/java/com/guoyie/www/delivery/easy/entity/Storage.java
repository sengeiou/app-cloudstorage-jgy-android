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
public class Storage implements Serializable {


    /**
     * _url : /index.php/
     * status :
     * inquiry_no :
     * goods_name :
     * vendor_no : YC0000000015
     * province_code :
     * city_code :
     * vendor_province_code : 120000
     * vendor_city_code : 120100
     * area_code :
     * create_at_start :
     * create_at_end :
     * contract_type :
     * goods_id :
     * pageCurrent : 1
     * pageSize : 10
     * totalRow : 11
     * list : [{"id":"15","inquiry_no":"I201712204408","company_id":"11931","company_name":"王敬测试公司","company_contact":"15156875945","company_contact_name":"王敬","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120105","area_name":"河北区","goods_name":"醋酸","goods_num":"123.000","goods_unit":"吨","contract_type":"1","remark":"","status":"1","create_at":"2017-12-20 15:28:39","update_at":null,"create_name":"王敬"},{"id":"14","inquiry_no":"I201712205785","company_id":"11931","company_name":"王敬测试公司","company_contact":"15156875945","company_contact_name":"王敬","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120104","area_name":"南开区","goods_name":"丁二烯","goods_num":"366.000","goods_unit":"吨","contract_type":"1","remark":"","status":"1","create_at":"2017-12-20 15:28:08","update_at":null,"create_name":"王敬"},{"id":"13","inquiry_no":"I201712208165","company_id":"11931","company_name":"王敬测试公司","company_contact":"15156875945","company_contact_name":"王敬","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120101","area_name":"和平区","goods_name":"纯苯","goods_num":"222.000","goods_unit":"吨","contract_type":"1","remark":"","status":"1","create_at":"2017-12-20 15:27:50","update_at":null,"create_name":"王敬"},{"id":"12","inquiry_no":"I201712202185","company_id":"11931","company_name":"王敬测试公司","company_contact":"15156875945","company_contact_name":"王敬","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120101","area_name":"和平区","goods_name":"异丙醇","goods_num":"444.000","goods_unit":"吨","contract_type":"1","remark":"","status":"1","create_at":"2017-12-20 15:27:35","update_at":null,"create_name":"王敬"},{"id":"11","inquiry_no":"I201712203211","company_id":"11931","company_name":"王敬测试公司","company_contact":"15156875945","company_contact_name":"王敬","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120101","area_name":"和平区","goods_name":"辛醇","goods_num":"555.000","goods_unit":"吨","contract_type":"2","remark":"","status":"1","create_at":"2017-12-20 15:22:29","update_at":null,"create_name":"王敬"},{"id":"10","inquiry_no":"I201712204702","company_id":"11931","company_name":"王敬测试公司","company_contact":"15156875945","company_contact_name":"王敬","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120101","area_name":"和平区","goods_name":"异丁醇","goods_num":"888.000","goods_unit":"吨","contract_type":"2","remark":"","status":"1","create_at":"2017-12-20 15:22:06","update_at":null,"create_name":"王敬"},{"id":"9","inquiry_no":"I201712206649","company_id":"11931","company_name":"王敬测试公司","company_contact":"15156875945","company_contact_name":"王敬","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120102","area_name":"河东区","goods_name":"异丙醇","goods_num":"666.000","goods_unit":"吨","contract_type":"2","remark":"","status":"1","create_at":"2017-12-20 15:21:47","update_at":null,"create_name":"王敬"},{"id":"8","inquiry_no":"I201712205471","company_id":"11931","company_name":"王敬测试公司","company_contact":"15156875945","company_contact_name":"王敬","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120102","area_name":"河东区","goods_name":"氢溴酸2","goods_num":"1000.000","goods_unit":"吨","contract_type":"1","remark":"","status":"1","create_at":"2017-12-20 15:21:21","update_at":null,"create_name":"王敬"},{"id":"7","inquiry_no":"I201712137750","company_id":"11898","company_name":"HelloKitty","company_contact":"15221489148","company_contact_name":"Kitty","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120104","area_name":"南开区","goods_name":"异丁醇","goods_num":"222.000","goods_unit":"立方米","contract_type":"2","remark":"222","status":"-1","create_at":"2017-12-13 14:50:07","update_at":null,"create_name":"Kitty"},{"id":"6","inquiry_no":"I201712138020","company_id":"11898","company_name":"HelloKitty","company_contact":"15221489148","company_contact_name":"Kitty","vendor_id":null,"vendor_name":null,"province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":"120101","area_name":"和平区","goods_name":"溶剂二甲苯","goods_num":"2.000","goods_unit":"千克","contract_type":"2","remark":"222","status":"1","create_at":"2017-12-13 14:49:48","update_at":null,"create_name":"Kitty"}]
     * totalPage : 2
     */

    private String _url;
    private String         status;
    private String         inquiry_no;
    private String         goods_name;
    private String         vendor_no;
    private String         province_code;
    private String         city_code;
    private String         vendor_province_code;
    private String         vendor_city_code;
    private String         area_code;
    private String         create_at_start;
    private String         create_at_end;
    private String         contract_type;
    private String         goods_id;
    private String         pageCurrent;
    private String         pageSize;
    private String         totalRow;
    private int            totalPage;
    private List<ListBean> list;

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInquiry_no() {
        return inquiry_no;
    }

    public void setInquiry_no(String inquiry_no) {
        this.inquiry_no = inquiry_no;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getVendor_no() {
        return vendor_no;
    }

    public void setVendor_no(String vendor_no) {
        this.vendor_no = vendor_no;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getVendor_province_code() {
        return vendor_province_code;
    }

    public void setVendor_province_code(String vendor_province_code) {
        this.vendor_province_code = vendor_province_code;
    }

    public String getVendor_city_code() {
        return vendor_city_code;
    }

    public void setVendor_city_code(String vendor_city_code) {
        this.vendor_city_code = vendor_city_code;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
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

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
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

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 15
         * inquiry_no : I201712204408
         * company_id : 11931
         * company_name : 王敬测试公司
         * company_contact : 15156875945
         * company_contact_name : 王敬
         * vendor_id : null
         * vendor_name : null
         * province_code : 120000
         * province_name : 天津市
         * city_code : 120100
         * city_name : 天津市
         * area_code : 120105
         * area_name : 河北区
         * goods_name : 醋酸
         * goods_num : 123.000
         * goods_unit : 吨
         * contract_type : 1
         * remark :
         * status : 1
         * create_at : 2017-12-20 15:28:39
         * update_at : null
         * create_name : 王敬
         */

        private String id;
        private String inquiry_no;
        private String company_id;
        private String company_name;
        private String company_contact;
        private String company_contact_name;
        private Object vendor_id;
        private Object vendor_name;
        private String province_code;
        private String province_name;
        private String city_code;
        private String city_name;
        private String area_code;
        private String area_name;
        private String goods_name;
        private String goods_num;
        private String goods_unit;
        private String contract_type;
        private String remark;
        private int status;
        private String create_at;
        private Object update_at;
        private String create_name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInquiry_no() {
            return inquiry_no;
        }

        public void setInquiry_no(String inquiry_no) {
            this.inquiry_no = inquiry_no;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCompany_contact() {
            return company_contact;
        }

        public void setCompany_contact(String company_contact) {
            this.company_contact = company_contact;
        }

        public String getCompany_contact_name() {
            return company_contact_name;
        }

        public void setCompany_contact_name(String company_contact_name) {
            this.company_contact_name = company_contact_name;
        }

        public Object getVendor_id() {
            return vendor_id;
        }

        public void setVendor_id(Object vendor_id) {
            this.vendor_id = vendor_id;
        }

        public Object getVendor_name() {
            return vendor_name;
        }

        public void setVendor_name(Object vendor_name) {
            this.vendor_name = vendor_name;
        }

        public String getProvince_code() {
            return province_code;
        }

        public void setProvince_code(String province_code) {
            this.province_code = province_code;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getArea_code() {
            return area_code;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
        }

        public String getGoods_unit() {
            return goods_unit;
        }

        public void setGoods_unit(String goods_unit) {
            this.goods_unit = goods_unit;
        }

        public String getContract_type() {
            return contract_type;
        }

        public void setContract_type(String contract_type) {
            this.contract_type = contract_type;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public Object getUpdate_at() {
            return update_at;
        }

        public void setUpdate_at(Object update_at) {
            this.update_at = update_at;
        }

        public String getCreate_name() {
            return create_name;
        }

        public void setCreate_name(String create_name) {
            this.create_name = create_name;
        }
    }
}
