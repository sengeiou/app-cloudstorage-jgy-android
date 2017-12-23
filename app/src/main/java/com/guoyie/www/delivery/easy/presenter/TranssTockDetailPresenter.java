package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.TranssTockDetailContract;
import com.guoyie.www.delivery.easy.entity.TransstockDetailData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/23
 */
public class TranssTockDetailPresenter extends TranssTockDetailContract.Presenter{

    @Override
    public void requstTransstockDetailData(String params) {
        Subscription subscribe = mModel.getTransstockDetailData(params).subscribe(new RxSubscriber<TransstockDetailData>(mContext,true) {
            @Override
            protected void _onNext(TransstockDetailData transstockDetailData) {
                mView.returnTransstockDetailData(transstockDetailData);

            }

            @Override
            protected void _onError(String message) {
              mView.error(message);
            }
        });

        mRxManage.add(subscribe);
    }
}


