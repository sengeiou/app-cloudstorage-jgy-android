package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.io.Serializable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：774169396@qq.com
 * data：2017/12/20
 */
public class UserInfoData extends BaseResponse implements Serializable {

    private UserInfo data;

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }
}
