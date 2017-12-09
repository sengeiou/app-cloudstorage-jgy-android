package com.guoyie.www.delivery.easy.entity;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2017/12/9
 *
 *储罐管理的实体类
 */

public class StoreManagerBean {
    private String storeNumber;
    private String goodsName;
    private String weight;
    private String type;

    public StoreManagerBean(String storeNumber, String goodsName, String weight, String type) {
        this.storeNumber = storeNumber;
        this.goodsName = goodsName;
        this.weight = weight;
        this.type = type;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
