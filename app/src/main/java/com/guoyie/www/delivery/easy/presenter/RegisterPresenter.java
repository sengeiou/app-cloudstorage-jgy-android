package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.RegisterContract;
import com.guoyie.www.delivery.easy.entity.RegisterData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：1649369473@qq.com
 * data：2017/12/20
 */

public class RegisterPresenter extends RegisterContract.Presenter {
    @Override
    public void requestRegister(String params) {
        Subscription subscribe = mModel.getRegister(params).subscribe(new RxSubscriber<RegisterData>(mContext, true) {
            @Override
            protected void _onNext(RegisterData data) {
                mView.returnRegisterData(data);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });

        mRxManage.add(subscribe);
    }
}
