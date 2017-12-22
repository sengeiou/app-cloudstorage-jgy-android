package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.StoreAgeContract;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class StorAgePresenter extends StoreAgeContract.Presenter {
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
