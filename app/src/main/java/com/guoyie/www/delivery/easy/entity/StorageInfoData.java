package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.util.ArrayList;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/21
 */
public class StorageInfoData extends BaseResponse {

    private ArrayList<StorageInfo>data;

    public ArrayList<StorageInfo> getData() {
        return data;
    }

    public void setData(ArrayList<StorageInfo> data) {
        this.data = data;
    }
}
