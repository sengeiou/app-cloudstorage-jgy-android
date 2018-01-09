package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.CapacityFilterContract;
import com.guoyie.www.delivery.easy.entity.CapacityGoodsNameBean;
import com.guoyie.www.delivery.easy.entity.CapacityStoreNumberBean;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;


/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2017/12/23
 */

public class CapacityFilterModel implements CapacityFilterContract.Model {

    //获取商品名
    @Override
    public Observable<CapacityGoodsNameBean> getCapacityGoodsName(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getCapacityGoodsNameList(params)
                .compose(RxUtil.<CapacityGoodsNameBean>rxSchedulerHelper());
    }

    //获取储罐号
    @Override
    public Observable<CapacityStoreNumberBean> getStoreNumber(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getCapacityStoreNumber(params)
                 .compose(RxUtil.<CapacityStoreNumberBean>rxSchedulerHelper());
    }


}
