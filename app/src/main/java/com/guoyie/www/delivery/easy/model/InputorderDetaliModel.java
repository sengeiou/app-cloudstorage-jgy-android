package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.InterOrderDetailContract;
import com.guoyie.www.delivery.easy.entity.InputOrderDetailData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/21
 */
public class InputorderDetaliModel implements InterOrderDetailContract.Model {
    @Override
    public Observable<InputOrderDetailData> getIODetailData(String params) {
        return   ApiManager.getService(HostType.HTTP_ORDINARY).getInputOrderDetaliData(params)
                .compose(RxUtil.<InputOrderDetailData>rxSchedulerHelper());

    }

    @Override
    public Observable<BaseResponse> getInterOrderUpdate(String params) {
        return   ApiManager.getService(HostType.HTTP_ORDINARY).getInputOrderDetaliUpdate(params)
                 .compose(RxUtil.<BaseResponse>rxSchedulerHelper());

    }

    @Override
    public Observable<BaseResponse> getHandleInter(String params) {

        return   ApiManager.getService(HostType.HTTP_ORDINARY).getOrderHandle(params).compose(RxUtil.<BaseResponse>rxSchedulerHelper());
    }
}
