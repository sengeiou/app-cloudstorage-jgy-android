package com.guoyie.www.delivery.easy.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {


    /**
     * id : 1
     * avatar :
     * quarters_id : 2
     * vendor_id : 15
     * loginname : sss
     * password : $2y$10$Md46FIZvUsckrv0C8RtjQuFWBl6OqPeck3CP/odwQO5SzKIvaHGyC
     * mobile : 13695698868
     * email : 10236598@qq.com
     * realname : 凯哥3
     * remark : 33333123
     * type : 1
     * state : 1
     * create_at : 2017-12-08 14:22:45
     * update_at : 2017-12-08 14:22:45
     * info : {"id":"15","vendor_type":"1","vendor_wms_hostaddress":null,"vendor_order_no":"JM0000000015","vendor_source":"0","province_code":"120000","province_name":"天津市","city_code":"120100","city_name":"天津市","area_code":null,"area_name":null,"vendor_no":"YC0000000015","vendor_name":"新版","vendor_address":null,"vendor_mobile":"021-41343143","vendor_level":"2","vendor_contract":"18015993809","vendor_contract_name":"测试","vendor_email":"7342745@qq.com","vendor_qq":"","vendor_logo":"","vendor_description":"2311","vendor_csdesc":"","vendor_jar_num":"11","vendor_volume":"11.000","vendor_wharf":"1.000","masterbusinessids":",28,79,","masterbusiness":"塑料 无机化工","superproductids":",79,","storagetype_id":"5","storagenature_id":null,"seal_customer_id":"807C4D10A353BCA9","staff_pre_id":"0","staff_pre_name":null,"staff_follow_id":null,"staff_follow_name":null,"staff_business_id":null,"staff_business_name":null,"shop_name":"新版","shop_level":"1","state":"1","status":"2","create_at":"2017-12-08 11:02:09","update_at":"2017-12-13 10:22:28","finish_at":null}
     */

    private int id;
    private String   avatar;
    private int   quarters_id;
    private int   vendor_id;
    private String   loginname;
    private String   password;
    private String   mobile;
    private String   email;
    private String   realname;
    private String   remark;
    private int   type;
    private String   state;
    private String   create_at;
    private String   update_at;
    private InfoBean info;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getQuarters_id() {
        return quarters_id;
    }

    public void setQuarters_id(int quarters_id) {
        this.quarters_id = quarters_id;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean implements Serializable {
        /**
         * id : 15
         * vendor_type : 1
         * vendor_wms_hostaddress : null
         * vendor_order_no : JM0000000015
         * vendor_source : 0
         * province_code : 120000
         * province_name : 天津市
         * city_code : 120100
         * city_name : 天津市
         * area_code : null
         * area_name : null
         * vendor_no : YC0000000015
         * vendor_name : 新版
         * vendor_address : null
         * vendor_mobile : 021-41343143
         * vendor_level : 2
         * vendor_contract : 18015993809
         * vendor_contract_name : 测试
         * vendor_email : 7342745@qq.com
         * vendor_qq :
         * vendor_logo :
         * vendor_description : 2311
         * vendor_csdesc :
         * vendor_jar_num : 11
         * vendor_volume : 11.000
         * vendor_wharf : 1.000
         * masterbusinessids : ,28,79,
         * masterbusiness : 塑料 无机化工
         * superproductids : ,79,
         * storagetype_id : 5
         * storagenature_id : null
         * seal_customer_id : 807C4D10A353BCA9
         * staff_pre_id : 0
         * staff_pre_name : null
         * staff_follow_id : null
         * staff_follow_name : null
         * staff_business_id : null
         * staff_business_name : null
         * shop_name : 新版
         * shop_level : 1
         * state : 1
         * status : 2
         * create_at : 2017-12-08 11:02:09
         * update_at : 2017-12-13 10:22:28
         * finish_at : null
         */

        private String id;
        private String vendor_type;
        private Object vendor_wms_hostaddress;
        private String vendor_order_no;
        private String vendor_source;
        private String province_code;
        private String province_name;
        private String city_code;
        private String city_name;
        private Object area_code;
        private Object area_name;
        private String vendor_no;
        private String vendor_name;
        private Object vendor_address;
        private String vendor_mobile;
        private String vendor_level;
        private String vendor_contract;
        private String vendor_contract_name;
        private String vendor_email;
        private String vendor_qq;
        private String vendor_logo;
        private String vendor_description;
        private String vendor_csdesc;
        private String vendor_jar_num;
        private String vendor_volume;
        private String vendor_wharf;
        private String masterbusinessids;
        private String masterbusiness;
        private String superproductids;
        private String storagetype_id;
        private Object storagenature_id;
        private String seal_customer_id;
        private String staff_pre_id;
        private Object staff_pre_name;
        private Object staff_follow_id;
        private Object staff_follow_name;
        private Object staff_business_id;
        private Object staff_business_name;
        private String shop_name;
        private String shop_level;
        private String state;
        private String status;
        private String create_at;
        private String update_at;
        private Object finish_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVendor_type() {
            return vendor_type;
        }

        public void setVendor_type(String vendor_type) {
            this.vendor_type = vendor_type;
        }

        public Object getVendor_wms_hostaddress() {
            return vendor_wms_hostaddress;
        }

        public void setVendor_wms_hostaddress(Object vendor_wms_hostaddress) {
            this.vendor_wms_hostaddress = vendor_wms_hostaddress;
        }

        public String getVendor_order_no() {
            return vendor_order_no;
        }

        public void setVendor_order_no(String vendor_order_no) {
            this.vendor_order_no = vendor_order_no;
        }

        public String getVendor_source() {
            return vendor_source;
        }

        public void setVendor_source(String vendor_source) {
            this.vendor_source = vendor_source;
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

        public Object getArea_code() {
            return area_code;
        }

        public void setArea_code(Object area_code) {
            this.area_code = area_code;
        }

        public Object getArea_name() {
            return area_name;
        }

        public void setArea_name(Object area_name) {
            this.area_name = area_name;
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

        public Object getVendor_address() {
            return vendor_address;
        }

        public void setVendor_address(Object vendor_address) {
            this.vendor_address = vendor_address;
        }

        public String getVendor_mobile() {
            return vendor_mobile;
        }

        public void setVendor_mobile(String vendor_mobile) {
            this.vendor_mobile = vendor_mobile;
        }

        public String getVendor_level() {
            return vendor_level;
        }

        public void setVendor_level(String vendor_level) {
            this.vendor_level = vendor_level;
        }

        public String getVendor_contract() {
            return vendor_contract;
        }

        public void setVendor_contract(String vendor_contract) {
            this.vendor_contract = vendor_contract;
        }

        public String getVendor_contract_name() {
            return vendor_contract_name;
        }

        public void setVendor_contract_name(String vendor_contract_name) {
            this.vendor_contract_name = vendor_contract_name;
        }

        public String getVendor_email() {
            return vendor_email;
        }

        public void setVendor_email(String vendor_email) {
            this.vendor_email = vendor_email;
        }

        public String getVendor_qq() {
            return vendor_qq;
        }

        public void setVendor_qq(String vendor_qq) {
            this.vendor_qq = vendor_qq;
        }

        public String getVendor_logo() {
            return vendor_logo;
        }

        public void setVendor_logo(String vendor_logo) {
            this.vendor_logo = vendor_logo;
        }

        public String getVendor_description() {
            return vendor_description;
        }

        public void setVendor_description(String vendor_description) {
            this.vendor_description = vendor_description;
        }

        public String getVendor_csdesc() {
            return vendor_csdesc;
        }

        public void setVendor_csdesc(String vendor_csdesc) {
            this.vendor_csdesc = vendor_csdesc;
        }

        public String getVendor_jar_num() {
            return vendor_jar_num;
        }

        public void setVendor_jar_num(String vendor_jar_num) {
            this.vendor_jar_num = vendor_jar_num;
        }

        public String getVendor_volume() {
            return vendor_volume;
        }

        public void setVendor_volume(String vendor_volume) {
            this.vendor_volume = vendor_volume;
        }

        public String getVendor_wharf() {
            return vendor_wharf;
        }

        public void setVendor_wharf(String vendor_wharf) {
            this.vendor_wharf = vendor_wharf;
        }

        public String getMasterbusinessids() {
            return masterbusinessids;
        }

        public void setMasterbusinessids(String masterbusinessids) {
            this.masterbusinessids = masterbusinessids;
        }

        public String getMasterbusiness() {
            return masterbusiness;
        }

        public void setMasterbusiness(String masterbusiness) {
            this.masterbusiness = masterbusiness;
        }

        public String getSuperproductids() {
            return superproductids;
        }

        public void setSuperproductids(String superproductids) {
            this.superproductids = superproductids;
        }

        public String getStoragetype_id() {
            return storagetype_id;
        }

        public void setStoragetype_id(String storagetype_id) {
            this.storagetype_id = storagetype_id;
        }

        public Object getStoragenature_id() {
            return storagenature_id;
        }

        public void setStoragenature_id(Object storagenature_id) {
            this.storagenature_id = storagenature_id;
        }

        public String getSeal_customer_id() {
            return seal_customer_id;
        }

        public void setSeal_customer_id(String seal_customer_id) {
            this.seal_customer_id = seal_customer_id;
        }

        public String getStaff_pre_id() {
            return staff_pre_id;
        }

        public void setStaff_pre_id(String staff_pre_id) {
            this.staff_pre_id = staff_pre_id;
        }

        public Object getStaff_pre_name() {
            return staff_pre_name;
        }

        public void setStaff_pre_name(Object staff_pre_name) {
            this.staff_pre_name = staff_pre_name;
        }

        public Object getStaff_follow_id() {
            return staff_follow_id;
        }

        public void setStaff_follow_id(Object staff_follow_id) {
            this.staff_follow_id = staff_follow_id;
        }

        public Object getStaff_follow_name() {
            return staff_follow_name;
        }

        public void setStaff_follow_name(Object staff_follow_name) {
            this.staff_follow_name = staff_follow_name;
        }

        public Object getStaff_business_id() {
            return staff_business_id;
        }

        public void setStaff_business_id(Object staff_business_id) {
            this.staff_business_id = staff_business_id;
        }

        public Object getStaff_business_name() {
            return staff_business_name;
        }

        public void setStaff_business_name(Object staff_business_name) {
            this.staff_business_name = staff_business_name;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getShop_level() {
            return shop_level;
        }

        public void setShop_level(String shop_level) {
            this.shop_level = shop_level;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
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

        public Object getFinish_at() {
            return finish_at;
        }

        public void setFinish_at(Object finish_at) {
            this.finish_at = finish_at;
        }
    }
}
