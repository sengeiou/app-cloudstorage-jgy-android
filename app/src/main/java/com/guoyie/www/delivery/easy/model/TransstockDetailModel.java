package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.TranssTockDetailContract;
import com.guoyie.www.delivery.easy.entity.TransstockDetailData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/23
 */
public class TransstockDetailModel implements TranssTockDetailContract.Model {


    @Override
    public Observable<TransstockDetailData> getTransstockDetailData(String params) {

        return   ApiManager.getService(HostType.HTTP_ORDINARY).getTransstockDetailData(params).compose(RxUtil.<TransstockDetailData>rxSchedulerHelper());
    }

    @Override
    public Observable<BaseResponse> getTranssUpdate(String params) {
        return   ApiManager.getService(HostType.HTTP_ORDINARY).getTransstockUpdate(params)
                 .compose(RxUtil.<BaseResponse>rxSchedulerHelper());
    }
}

