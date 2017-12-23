package com.guoyie.www.delivery.easy.entity;

import com.google.gson.annotations.SerializedName;
import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.util.List;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2017/12/23
 */

public class CapacityGoodsNameBean extends BaseResponse{

    /**
     * code : 200
     * data : [{"goods_name":"甲苯"},{"goods_name":"我企鹅体验完全统一"},{"goods_name":"烧碱（氢氧化钠）"},{"goods_name":"有机化工"},{"goods_name":"二甘醇(恒阳)"},{"goods_name":"醋酸"}]
     */

    @SerializedName("code")
    private String codeX;
    private List<DataBean> data;

    public String getCodeX() {
        return codeX;
    }

    public void setCodeX(String codeX) {
        this.codeX = codeX;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goods_name : 甲苯
         */

        private String goods_name;

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }
    }
}
