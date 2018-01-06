package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.AddOrderDetailContract;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

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

        /*

          //依次检查disk、network
        String key = "lo";
        Observable<CommodityData> fromNetWork = ApiManager.getService(HostType.HTTP_ORDINARY).getCommodityList(params).compose(RxUtil.<CommodityData>rxCacheBeanHelper(key));
        Observable observable = Observable.concat(RxUtil.rxCreateDiskObservable(key, CommodityData.class), fromNetWork).map(new Func1() {
            @Override
            public Object call(Object data) {
                return data;
            }
        });
        return observable;
         */
        /*return  ApiManager.getService(HostType.HTTP_ORDINARY).getAddInter(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());*/
       //  return Api.getDefaultService().queryHot(page).map(new RxFunc<List<HotBean>>()).compose(RxSchedulers.<List<HotBean>>io_main());
       return ApiManager.getService(HostType.HTTP_ORDINARY).getAddInter(params).compose(RxUtil.<BaseResponse>rxSchedulerHelper());

    }

    @Override
    public Observable<BaseResponse> getAddStockOuter(String params) {
      /*  return ApiManager.getService(HostType.HTTP_ORDINARY).getAddOuter(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());*/
      return  ApiManager.getService(HostType.HTTP_ORDINARY).getAddOuter(params).compose(RxUtil.<BaseResponse>rxSchedulerHelper());
    }

    @Override
    public Observable<StoreNumberBean> getStoreNumber(String params) {

        return  ApiManager.getService(HostType.HTTP_ORDINARY).getStoreNumber(params).compose(RxUtil.<StoreNumberBean>rxSchedulerHelper());

    }
}
