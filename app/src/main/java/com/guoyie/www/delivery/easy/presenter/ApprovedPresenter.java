package com.guoyie.www.delivery.easy.presenter;


import com.guoyie.www.delivery.easy.contract.ApprovedContract;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * package：com.chinayie.cloudmanager.presenter
 * email：774169396@qq.com
 * data：2017/11/24
 */
public class ApprovedPresenter extends ApprovedContract.Presenster {
    @Override
    public void requstApprovedData(String params) {

        Subscription subscribe = mModel.getApprovedData(params).subscribe(new RxSubscriber<Object>(mContext) {
            @Override
            protected void _onNext(Object data) {
                mView.returnApporvedData(data);
            }

            @Override
            protected void _onError(String message) {
                mView.err_or(message);
            }
        });

        mRxManage.add(subscribe);

    }


}
