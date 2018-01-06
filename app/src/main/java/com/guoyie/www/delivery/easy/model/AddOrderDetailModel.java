package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.AddOrderDetailContract;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.rx.RxSchedulers;

import io.reactivex.Observable;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/28
 */
public class AddOrderDetailModel implements AddOrderDetailContract.Model {
    @Override
    public Observable<BaseResponse> getAddStockInter(String params) {
        /*return  ApiManager.getService(HostType.HTTP_ORDINARY).getAddInter(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());*/
       //  return Api.getDefaultService().queryHot(page).map(new RxFunc<List<HotBean>>()).compose(RxSchedulers.<List<HotBean>>io_main());
       return ApiManager.getService(HostType.HTTP_ORDINARY).getAddInter(params).compose(RxSchedulers.<BaseResponse>io_main());

    }

    @Override
    public Observable<BaseResponse> getAddStockOuter(String params) {
      /*  return ApiManager.getService(HostType.HTTP_ORDINARY).getAddOuter(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());*/
      return  ApiManager.getService(HostType.HTTP_ORDINARY).getAddOuter(params).compose(RxSchedulers.<BaseResponse>io_main());
    }

    @Override
    public Observable<StoreNumberBean> getStoreNumber(String params) {

        return  ApiManager.getService(HostType.HTTP_ORDINARY).getStoreNumber(params).compose(RxSchedulers.<StoreNumberBean>io_main());

    }
}
