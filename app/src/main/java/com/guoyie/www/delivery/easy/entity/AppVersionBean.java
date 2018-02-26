package com.guoyie.www.delivery.easy.entity;

/**
 * author：江滔
 * project：cloudstorage
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2018/2/26
 */

public class AppVersionBean {

    /**
     * data : {"id":"16","title":"交割易","content":"V1.0","varsion":"1","appname":"交割易","url":"http://www.chinayie.com/Android_App/guoyie.apk","package_name":"com.guoyie.www.gyapp","version_number":"1.0.0","compel":"0","status":"1","type":"1","created_at":"2018-02-26 10:14:07","updated_at":"2018-02-26 10:14:10","app_type":"2"}
     * code : 200
     * msg : 获取版本号成功
     */

    private DataBean data;
    private String code;
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * id : 16
         * title : 交割易
         * content : V1.0
         * varsion : 1
         * appname : 交割易
         * url : http://www.chinayie.com/Android_App/guoyie.apk
         * package_name : com.guoyie.www.gyapp
         * version_number : 1.0.0
         * compel : 0
         * status : 1
         * type : 1
         * created_at : 2018-02-26 10:14:07
         * updated_at : 2018-02-26 10:14:10
         * app_type : 2
         */

        private String id;
        private String title;
        private String content;
        private String varsion;
        private String appname;
        private String url;
        private String package_name;
        private String version_number;
        private String compel;
        private String status;
        private String type;
        private String created_at;
        private String updated_at;
        private String app_type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getVarsion() {
            return varsion;
        }

        public void setVarsion(String varsion) {
            this.varsion = varsion;
        }

        public String getAppname() {
            return appname;
        }

        public void setAppname(String appname) {
            this.appname = appname;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getVersion_number() {
            return version_number;
        }

        public void setVersion_number(String version_number) {
            this.version_number = version_number;
        }

        public String getCompel() {
            return compel;
        }

        public void setCompel(String compel) {
            this.compel = compel;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getApp_type() {
            return app_type;
        }

        public void setApp_type(String app_type) {
            this.app_type = app_type;
        }
    }
}
