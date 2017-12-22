package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/20
 */
public class InputOrderInfoData extends BaseResponse {

    private InputOrderInfo data;

    public InputOrderInfo getData() {
        return data;
    }

    public void setData(InputOrderInfo data) {
        this.data = data;
    }
}
