package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2018/1/8
 */
public class BannerData extends BaseResponse {
    private List<Banner> data;

    public List<Banner> getData() {
        return data;
    }

    public void setData(List<Banner> data) {
        this.data = data;
    }
}
