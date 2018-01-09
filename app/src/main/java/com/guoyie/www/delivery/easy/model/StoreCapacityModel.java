package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.StoreCapacityManagerContract;
import com.guoyie.www.delivery.easy.entity.StoreCapacityListBean;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;


/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2017/12/22
 */

public class StoreCapacityModel implements StoreCapacityManagerContract.Model{
    @Override
    public Observable<StoreCapacityListBean> getStoreCapacity(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY).getStoreCapacityList(params)
                .compose(RxUtil.<StoreCapacityListBean>rxSchedulerHelper());
    }
}
