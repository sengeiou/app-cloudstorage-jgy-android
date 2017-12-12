package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/12
 */
public class GetTime extends BaseResponse{
    private long data;

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }
}
