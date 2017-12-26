package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.SeachRustrlContracat;
import com.guoyie.www.delivery.easy.entity.InputOrderInfoData;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.entity.TransstockData;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/26
 */
public class SeachRusltModel implements SeachRustrlContracat.Model {
    @Override
    public  Observable <InputOrderInfoData> getInputData(String params) {
        return   ApiManager.getService(HostType.HTTP_ORDINARY).getInputOrderData(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<OuterOrderInfoData> getOuterOrderData(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getOuterOrderData(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<TransstockData> getTranssTockData(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getTransstockListData(params)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<StorageData> getStorageData(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getStorageData(params)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
