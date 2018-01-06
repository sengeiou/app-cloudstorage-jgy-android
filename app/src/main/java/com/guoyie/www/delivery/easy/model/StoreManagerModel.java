package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.StoreManagerContract;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2017/12/21
 */

public class StoreManagerModel implements StoreManagerContract.Model {
    @Override
    public Observable<StoreManagerListBean> getStoreManagerList(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getStoreManagerList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
