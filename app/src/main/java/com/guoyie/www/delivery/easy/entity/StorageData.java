package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/21
 */
public class StorageData extends BaseResponse {

    private Storage data;

    public Storage getData() {
        return data;
    }

    public void setData(Storage data) {
        this.data = data;
    }
}
