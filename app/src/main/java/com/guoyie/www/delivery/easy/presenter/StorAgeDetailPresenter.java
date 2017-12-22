package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.StoreAgeDetaliContract;
import com.guoyie.www.delivery.easy.entity.StorageInfoData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/22
 */
public class StorAgeDetailPresenter extends StoreAgeDetaliContract.Presenter {

    @Override
    public void requstStorageDetailData(String params) {
        Subscription subscribe = mModel.getStorageDetailData(params).subscribe(new RxSubscriber<StorageInfoData>(mContext,true) {
            @Override
            protected void _onNext(StorageInfoData storageInfoData) {
                     mView.returnStoreAgeDetailData(storageInfoData);
            }

            @Override
            protected void _onError(String message) {
                mView.err_or(message);

            }
        });

        mRxManage.add(subscribe);
    }
}
