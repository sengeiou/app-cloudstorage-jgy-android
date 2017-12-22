package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.StoreDetailContract;
import com.guoyie.www.delivery.easy.entity.StoreDetailBean;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2017/12/22
 */

public class StoreDetailModel implements StoreDetailContract.Model {
    @Override
    public Observable<StoreDetailBean> getStoreDetail(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY).getStoreDetail(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
