package com.guoyie.www.delivery.easy.model;

import com.guoyie.www.delivery.easy.api.ApiManager;
import com.guoyie.www.delivery.easy.api.HostType;
import com.guoyie.www.delivery.easy.contract.LoginContract;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.rx.RxUtil;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：774169396@qq.com
 * data：2017/12/20
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<UserInfoData> getLoginData(String parms) {
        return    ApiManager.getService(HostType.HTTP_ORDINARY).getLogin(parms).compose(RxUtil.<UserInfoData>rxSchedulerHelper());

    }
}
