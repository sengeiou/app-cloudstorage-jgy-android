package com.guoyie.www.delivery.easy.model;


import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.ApprovedContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



/**
 * author：柯军
 * project：CloudManager
 * package：com.chinayie.cloudmanager.model
 * email：774169396@qq.com
 * data：2017/11/24
 *
 */
public class ApprovedModel  implements ApprovedContract.Model{
    @Override
    public Observable<Object> getApprovedData(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY).getHomePageList(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
