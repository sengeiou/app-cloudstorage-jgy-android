package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.RegisterContract;
import com.guoyie.www.delivery.easy.entity.RegisterData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2017/12/20
 */

public class RegisterModel implements RegisterContract.Model {
    @Override
    public Observable<RegisterData> getRegister(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY).getRegister(params)
               .compose(RxUtil.<RegisterData>rxSchedulerHelper());
    }
}
