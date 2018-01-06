package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.InterOrderContract;
import com.guoyie.www.delivery.easy.entity.InputOrderInfoData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/20
 */
public class InputOrderModel implements InterOrderContract.Model {
    @Override
    public  Observable <InputOrderInfoData> getInputData(String params) {
         /*return   ApiManager.getService(HostType.HTTP_ORDINARY).getInputOrderData(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());*/
      //  return ApiManager.getService(HostType.HTTP_ORDINARY).getAddInter(params).compose(RxSchedulers.<BaseResponse>io_main());
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getInputOrderData(params).compose(RxUtil.<InputOrderInfoData>rxSchedulerHelper());

    }

}
