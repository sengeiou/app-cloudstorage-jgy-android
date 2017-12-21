package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.StoreManagerContract;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：1649369473@qq.com
 * data：2017/12/21
 */

public class StoreManagerPresenter extends StoreManagerContract.Presenter{

    @Override
    public void requestStoreManagerList(String params) {
        Subscription subscribe = mModel.getStoreManagerList(params).subscribe(new RxSubscriber<StoreManagerListBean>(mContext,true) {
            @Override
            protected void _onNext(StoreManagerListBean storeManagerListBean) {
                mView.returnStoreManagerList(storeManagerListBean);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });

        mRxManage.add(subscribe);
    }
}
