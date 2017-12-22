package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.StoreDetailContract;
import com.guoyie.www.delivery.easy.entity.StoreDetailBean;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：1649369473@qq.com
 * data：2017/12/22
 */

public class StoreDetailPresenter extends StoreDetailContract.Presenter {
    @Override
    public void requestStoreDetail(String params) {
        Subscription subscribe = mModel.getStoreDetail(params).subscribe(new RxSubscriber<StoreDetailBean>(mContext,true) {
            @Override
            protected void _onNext(StoreDetailBean storeDetailBean) {
                mView.returnStoreDetail(storeDetailBean);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });

        mRxManage.add(subscribe);
    }
}
