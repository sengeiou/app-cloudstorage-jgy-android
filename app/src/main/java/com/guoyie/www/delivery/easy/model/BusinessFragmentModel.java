package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.BusinessFragmentContract;
import com.guoyie.www.delivery.easy.entity.BannerData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2018/1/8
 */
public class BusinessFragmentModel implements BusinessFragmentContract.Model {
    @Override
    public Observable<BannerData> getBanner(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getBanner(params).compose(RxUtil.<BannerData>rxSchedulerHelper());

    }
}
