package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.InterOrderContract;
import com.guoyie.www.delivery.easy.entity.OrderInfoData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/20
 */
public class InputOrderPresenter extends InterOrderContract.Presenter {
    @Override
    public void requstInputOrderData(String params) {
        Subscription subscribe = mModel.getInputData(params).subscribe(new RxSubscriber<OrderInfoData>(mContext,true) {
            @Override
            protected void _onNext(OrderInfoData orderInfoData) {
                  mView.returnInputOrderData(orderInfoData);
            }

            @Override
            protected void _onError(String message) {
                 mView.err_or(message);
            }
        });
        mRxManage.add(subscribe);
    }

}
