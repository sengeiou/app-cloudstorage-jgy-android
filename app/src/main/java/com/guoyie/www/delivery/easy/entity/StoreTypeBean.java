package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.util.List;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2017/12/25
 *
 * 储罐筛选，储罐性质
 */

public class StoreTypeBean extends BaseResponse{

    /**
     * code : 200
     * msg : 获取条件成功
     * data : [{"jar_material":"3333"},{"jar_material":"123123"},{"jar_material":"123"},{"jar_material":"pvc"},{"jar_material":"555"},{"jar_material":"666"},{"jar_material":"碳钢"},{"jar_material":"碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢碳钢"},{"jar_material":"12321"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * jar_material : 3333
         */

        private String jar_material;

        public String getJar_material() {
            return jar_material;
        }

        public void setJar_material(String jar_material) {
            this.jar_material = jar_material;
        }
    }
}
