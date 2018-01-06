package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.StoreFilterContract;
import com.guoyie.www.delivery.easy.entity.GoodsNameBean;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.entity.StoreTypeBean;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2017/12/25
 */

public class StoreFilterModel implements StoreFilterContract.Model {
    @Override
    public Observable<StoreNumberBean> getStoreNumber(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getStoreNumber(params)
                .compose(RxUtil.<StoreNumberBean>rxSchedulerHelper());
    }

    @Override
    public Observable<GoodsNameBean> getGoodsName(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getStoreName(params)
                .compose(RxUtil.<GoodsNameBean>rxSchedulerHelper());
    }

    @Override
    public Observable<StoreTypeBean> getStoreType(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getStoreType(params)
                .compose(RxUtil.<StoreTypeBean>rxSchedulerHelper());
    }
}
