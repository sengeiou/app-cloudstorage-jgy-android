package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.StoreCapacityManagerContract;
import com.guoyie.www.delivery.easy.entity.StoreCapacityListBean;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：1649369473@qq.com
 * data：2017/12/22
 */

public class StoreCapacityPresenter extends StoreCapacityManagerContract.Presenter{
    @Override
    public void requestStoreCapacityList(String params) {
        Subscription subscribe = mModel.getStoreCapacity(params).subscribe(new RxSubscriber<StoreCapacityListBean>(mContext,true) {
            @Override
            protected void _onNext(StoreCapacityListBean storeCapacityListBean) {
                mView.returnStoreCapacityList(storeCapacityListBean);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });
    }
}
