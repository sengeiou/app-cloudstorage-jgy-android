package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.StoreAgeDetaliContract;
import com.guoyie.www.delivery.easy.entity.StorageInfoData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class StoreAgeDetailModel implements StoreAgeDetaliContract.Model{
    @Override
    public Observable<StorageInfoData> getStorageDetailData(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getStorageInfoData(params)
                .compose(RxUtil.<StorageInfoData>rxSchedulerHelper());
    }

}
