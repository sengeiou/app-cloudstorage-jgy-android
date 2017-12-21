package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/21
 */
public class InputOrderDetailData extends BaseResponse {
    private InputOrderDetail data;

    public InputOrderDetail getData() {
        return data;
    }

    public void setData(InputOrderDetail data) {
        this.data = data;
    }
}
