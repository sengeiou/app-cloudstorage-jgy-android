package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.OutOrderDetailContract;
import com.guoyie.www.delivery.easy.entity.OuterOrderDetailData;
import com.guoyie.www.delivery.easy.rx.RxSchedulers;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class OuterOderDetailModel implements OutOrderDetailContract.Model {
    @Override
    public Observable<OuterOrderDetailData> getOuterDetailData(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getOuterOrderDetaliData(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<BaseResponse> getOuterDetailUpdate(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getInputOrderDetaliUpdate(params)
                .compose(RxSchedulers.<BaseResponse>io_main());

    }

    @Override
    public Observable<BaseResponse> getHandleOuter(String params) {

        return ApiManager.getService(HostType.HTTP_ORDINARY).getOrderHandle(params).compose(RxSchedulers.<BaseResponse>io_main());
    }

}
