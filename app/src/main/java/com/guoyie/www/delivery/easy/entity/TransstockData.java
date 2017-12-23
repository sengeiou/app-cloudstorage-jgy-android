package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/23
 */
public class TransstockData extends BaseResponse {
    private Transstock data;

    public Transstock getData() {
        return data;
    }

    public void setData(Transstock data) {
        this.data = data;
    }
}
