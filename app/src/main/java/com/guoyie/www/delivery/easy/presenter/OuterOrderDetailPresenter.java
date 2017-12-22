package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.OutOrderDetailContract;
import com.guoyie.www.delivery.easy.entity.OuterOrderDetailData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class OuterOrderDetailPresenter extends OutOrderDetailContract.Presenter {

    @Override
    public void requstOuterDetailrData(String params) {
        Subscription subscribe = mModel.getOuterDetailrData(params).subscribe(new RxSubscriber<OuterOrderDetailData>(mContext,true) {
            @Override
            protected void _onNext(OuterOrderDetailData outerOrderDetailData) {
                mView.returnOuterDetailrData(outerOrderDetailData);

            }

            @Override
            protected void _onError(String message) {
                mView.error(message);

            }
        });

        mRxManage.add(subscribe);
    }
}
