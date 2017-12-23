package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.TranssTockContract;
import com.guoyie.www.delivery.easy.entity.TransstockData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/23
 */
public class TranssTockPresenter extends TranssTockContract.Presenter {
    @Override
    public void requstTranssTockData(String params) {
        Subscription subscribe = mModel.getTranssTockData(params).subscribe(new RxSubscriber<TransstockData>(mContext, true) {
            @Override
            protected void _onNext(TransstockData transstockData) {
                mView.returnTranssTockData(transstockData);

            }

            @Override
            protected void _onError(String message) {
                mView.error(message);

            }
        });
        mRxManage.add(subscribe);
    }
}
