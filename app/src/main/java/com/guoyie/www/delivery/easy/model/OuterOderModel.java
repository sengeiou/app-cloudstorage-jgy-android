package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.OutOrderContract;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class OuterOderModel implements OutOrderContract.Model {
    @Override
    public Observable<OuterOrderInfoData> getOuterOrderData(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getOuterOrderData(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
