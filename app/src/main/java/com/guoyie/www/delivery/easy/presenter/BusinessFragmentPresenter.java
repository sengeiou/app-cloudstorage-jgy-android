package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.BusinessFragmentContract;
import com.guoyie.www.delivery.easy.entity.BannerData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2018/1/8
 */
public class BusinessFragmentPresenter extends BusinessFragmentContract.Presenter {
    @Override
    public void requstBanner(String params) {
        Subscription subscribe = mModel.getBanner(params).subscribe(new RxSubscriber<BannerData>(mContext, true) {
            @Override
            protected void _onNext(BannerData data) {
                mView.returnBanner(data);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });
        mRxManage.add(subscribe);

    }
}
