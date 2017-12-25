package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.CapacityFilterContract;
import com.guoyie.www.delivery.easy.entity.CapacityGoodsNameBean;
import com.guoyie.www.delivery.easy.entity.CapacityStoreNumberBean;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：1649369473@qq.com
 * data：2017/12/23
 */

public class CapacityFilterPresenter extends CapacityFilterContract.Presenter{

    //请求商品名
    @Override
    public void requestCapacityGoodsName(String params) {
        Subscription subscribe = mModel.getCapacityGoodsName(params).subscribe(new RxSubscriber<CapacityGoodsNameBean>(mContext, true) {
            @Override
            protected void _onNext(CapacityGoodsNameBean capacityGoodsNameBean) {
                mView.returnCapacityGoodsName(capacityGoodsNameBean);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });

        mRxManage.add(subscribe);
    }
    //请求储罐号
    @Override
    public void requestStoreNumber(String params) {
        Subscription subscribe = mModel.getStoreNumber(params).subscribe(new RxSubscriber<CapacityStoreNumberBean>(mContext,true) {
            @Override
            protected void _onNext(CapacityStoreNumberBean capacityStoreNumberBean) {
                mView.returnStoreNumber(capacityStoreNumberBean);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });
        mRxManage.add(subscribe);
    }
}
