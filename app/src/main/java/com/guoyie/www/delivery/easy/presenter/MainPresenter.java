package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.MainContract;
import com.guoyie.www.delivery.easy.entity.GetTime;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/12
 */
public class MainPresenter extends MainContract.Presenster{
    @Override
    public void requstTime(String params) {

        Subscription subscribe = mModel.getTime(params).subscribe(new RxSubscriber<GetTime>(mContext, false) {
            @Override
            protected void _onNext(GetTime time) {
                mView.returnTime(time);

            }

            @Override
            protected void _onError(String message) {
                mView.error(message);

            }
        });


        mRxManage.add(subscribe);
    }
}
