package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.MainContract;
import com.guoyie.www.delivery.easy.entity.GetTime;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/12
 */
public class MainModel implements MainContract.Model {
    @Override
    public Observable<GetTime> getTime(String params) {
        return   ApiManager.getService(HostType.HTTP_ORDINARY).getTime(params).compose(RxUtil.<GetTime>rxSchedulerHelper());
    }
}
