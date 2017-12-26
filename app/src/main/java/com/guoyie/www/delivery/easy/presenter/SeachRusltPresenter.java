package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.SeachRustrlContracat;
import com.guoyie.www.delivery.easy.entity.InputOrderInfoData;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.entity.TransstockData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/26
 */
public class SeachRusltPresenter extends SeachRustrlContracat.Presenter {
    @Override
    public void requstInputOrderData(String params) {
        Subscription subscribe = mModel.getInputData(params).subscribe(new RxSubscriber<InputOrderInfoData>(mContext,true) {
            @Override
            protected void _onNext(InputOrderInfoData orderInfoData) {
                mView.returnInputOrderData(orderInfoData);
            }

            @Override
            protected void _onError(String message) {
                mView.err_or(message);
            }
        });
        mRxManage.add(subscribe);
    }

    @Override
    public void requstOutorderData(String params) {

        Subscription subscribe = mModel.getOuterOrderData(params).subscribe(new RxSubscriber<OuterOrderInfoData>(mContext,true) {
            @Override
            protected void _onNext(OuterOrderInfoData data) {
                mView.returnOuterOrderData(data);

            }

            @Override
            protected void _onError(String message) {
                mView.err_or(message);

            }
        });

        mRxManage.add(subscribe);



    }

    @Override
    public void requstTranssTockData(String params) {
        Subscription subscribe = mModel.getTranssTockData(params).subscribe(new RxSubscriber<TransstockData>(mContext, true) {
            @Override
            protected void _onNext(TransstockData transstockData) {
                mView.returnTranssTockData(transstockData);

            }

            @Override
            protected void _onError(String message) {
                mView.err_or(message);

            }
        });
        mRxManage.add(subscribe);



    }

    @Override
    public void requstStorageData(String params) {
        Subscription subscribe = mModel.getStorageData(params).subscribe(new RxSubscriber<StorageData>(mContext, true) {
            @Override
            protected void _onNext(StorageData storageData) {
                mView.returnStoreAgeData(storageData);
            }

            @Override
            protected void _onError(String message) {
                mView.err_or(message);

            }
        });
        mRxManage.add(subscribe);

    }


}
