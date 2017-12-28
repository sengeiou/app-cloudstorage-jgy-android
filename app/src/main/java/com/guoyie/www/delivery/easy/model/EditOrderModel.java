package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.EditOrderContract;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/28
 */
public class EditOrderModel implements EditOrderContract.Model {
    @Override
    public Observable<BaseResponse> editinterstock(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getEditInter(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<BaseResponse> editouterstock(String params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).getEditOuter(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<BaseResponse> editLoadobj(Map<String,RequestBody> params) {
        return  ApiManager.getService(HostType.HTTP_ORDINARY).upLoadFile(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
