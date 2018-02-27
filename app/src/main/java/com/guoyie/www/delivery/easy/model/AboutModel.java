package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.AboutContract;
import com.guoyie.www.delivery.easy.entity.AppVersionBean;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：江滔
 * project：cloudstorage
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2018/2/27
 */

public class AboutModel implements AboutContract.Model {
    @Override
    public Observable<AppVersionBean> getAppVersion(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY)
                .getAppVersion(params)
                .compose(RxUtil.<AppVersionBean>rxSchedulerHelper());
    }
}
