package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.CapacityFilterGoodsNameContract;
import com.guoyie.www.delivery.easy.entity.CapacityGoodsNameBean;
import com.guoyie.www.delivery.easy.entity.CapacityStoreNumberBean;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2017/12/23
 */

public class CapacityGoodsNameModel implements CapacityFilterGoodsNameContract.Model {

    //获取商品名
    @Override
    public Observable<CapacityGoodsNameBean> getCapacityGoodsName(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getCapacityGoodsNameList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //获取储罐号
    @Override
    public Observable<CapacityStoreNumberBean> getStoreNumber(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getCapacityStoreNumber(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
