package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class OuterOrderDetailData extends BaseResponse{
    private OuterOrderDetail data;

    public OuterOrderDetail getData() {
        return data;
    }

    public void setData(OuterOrderDetail data) {
        this.data = data;
    }
}
