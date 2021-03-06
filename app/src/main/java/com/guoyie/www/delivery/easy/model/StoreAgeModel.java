package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.StoreAgeContract;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class StoreAgeModel implements StoreAgeContract.Model {
    @Override
    public Observable<StorageData> getStorageData(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getStorageData(params)
               .compose(RxUtil.<StorageData>rxSchedulerHelper());

    }
}
