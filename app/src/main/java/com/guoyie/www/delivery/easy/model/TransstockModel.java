package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.TranssTockContract;
import com.guoyie.www.delivery.easy.entity.TransstockData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/23
 */
public class TransstockModel implements TranssTockContract.Model {
    @Override
    public Observable<TransstockData> getTranssTockData(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getTransstockListData(params)
                .compose(RxUtil.<TransstockData>rxSchedulerHelper());
    }
}
