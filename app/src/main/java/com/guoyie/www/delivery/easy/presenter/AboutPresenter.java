package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.AboutContract;
import com.guoyie.www.delivery.easy.entity.AppVersionBean;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：江滔
 * project：cloudstorage
 * package：com.guoyie.www.delivery.easy.presenter
 * email：1649369473@qq.com
 * data：2018/2/27
 */

public class AboutPresenter extends AboutContract.Presenter {
    @Override
    public void requestVersion(String params) {
        Subscription subscribe = mModel.getAppVersion(params)
                .subscribe(new RxSubscriber<AppVersionBean>(mContext, true) {
                    @Override
                    protected void _onNext(AppVersionBean appVersionBean) {
                        mView.returnVersion(appVersionBean);
                    }

                    @Override
                    protected void _onError(String message) {
                        mView.error(message);
                    }
                });

        mRxManage.add(subscribe);
    }
}
