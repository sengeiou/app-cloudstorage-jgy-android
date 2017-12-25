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
 * 储罐筛选，商品名
 */

public class GoodsNameBean extends BaseResponse{

    /**
     * code : 200
     * msg : 获取条件成功
     * data : [{"goods_name":"我企鹅体验完全统一"},{"goods_name":"羧酸"},{"goods_name":"辛醇"},{"goods_name":"纯苯"},{"goods_name":"混合芳烃"},{"goods_name":"石脑油"},{"goods_name":"烧碱（氢氧化钠）"},{"goods_name":"二甘醇(恒阳)"},{"goods_name":"异丁醇"},{"goods_name":"柴油(国五)"},{"goods_name":"聚氨酯橡胶"},{"goods_name":"甲苯"},{"goods_name":"溶剂二甲苯"},{"goods_name":"丁二烯"},{"goods_name":"纯碱（碳酸钠）"},{"goods_name":"氢溴酸2"},{"goods_name":"乙二醇乙醚醋酸酯"},{"goods_name":"草酸"},{"goods_name":"有机化工"}]
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
         * goods_name : 我企鹅体验完全统一
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
