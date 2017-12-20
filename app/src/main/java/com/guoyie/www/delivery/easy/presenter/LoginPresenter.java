package com.guoyie.www.delivery.easy.presenter;

import android.content.Context;
import android.content.Intent;

import com.guoyie.www.delivery.easy.activity.MainActivity;
import com.guoyie.www.delivery.easy.contract.LoginContract;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/20
 */
public class LoginPresenter extends LoginContract.Presenter {
    @Override
    public void requestLoginData(String parms) {
        Subscription subscribe = mModel.getLoginData(parms).subscribe(new RxSubscriber<UserInfoData>(mContext, true) {
            @Override
            protected void _onNext(UserInfoData userInfoData) {
                    mView.returnInfoData(userInfoData);

            }

            @Override
            protected void _onError(String message) {
                mView.eeror(message);

            }
        });


        mRxManage.add(subscribe);
    }
}
