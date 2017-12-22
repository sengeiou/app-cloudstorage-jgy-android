package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.OutOrderContract;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class OuterOrderPresenter extends OutOrderContract.Presenter {
    @Override
    public void requstOutorderData(String params) {
        Subscription subscribe = mModel.getOuterOrderData(params).subscribe(new RxSubscriber<OuterOrderInfoData>(mContext,true) {
            @Override
            protected void _onNext(OuterOrderInfoData data) {
                mView.returnOuterOrderData(data);

            }

            @Override
            protected void _onError(String message) {
                mView.error(message);

            }
        });

        mRxManage.add(subscribe);
    }
}
