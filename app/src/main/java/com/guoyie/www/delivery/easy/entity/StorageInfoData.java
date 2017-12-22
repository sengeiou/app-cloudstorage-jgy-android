package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/21
 */
public class StorageInfoData extends BaseResponse {

    private StorageInfo data;

    public StorageInfo getData() {
        return data;
    }

    public void setData(StorageInfo data) {
        this.data = data;
    }
}
