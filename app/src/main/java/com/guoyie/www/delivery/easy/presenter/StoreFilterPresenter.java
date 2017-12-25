package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.contract.StoreFilterContract;
import com.guoyie.www.delivery.easy.entity.GoodsNameBean;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.entity.StoreTypeBean;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.model
 * email：1649369473@qq.com
 * data：2017/12/25
 */

public class StoreFilterPresenter extends StoreFilterContract.Presenter {
    //获取储罐号
    @Override
    public void requestStoreNumber(String params) {
        Subscription subscribe = mModel.getStoreNumber(params).subscribe(new RxSubscriber<StoreNumberBean>(mContext, true) {
            @Override
            protected void _onNext(StoreNumberBean storeNumberBean) {
                mView.returnStoreNumber(storeNumberBean);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });
        mRxManage.add(subscribe);
    }
    //获取商品名
    @Override
    public void requestGoodsName(String params) {
        Subscription subscribe = mModel.getGoodsName(params).subscribe(new RxSubscriber<GoodsNameBean>(mContext, true) {
            @Override
            protected void _onNext(GoodsNameBean goodsNameBean) {
                mView.returnGoodsName(goodsNameBean);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });
        mRxManage.add(subscribe);
    }
    //获取储罐类型
    @Override
    public void requestStoreType(String params) {
        Subscription subscribe = mModel.getStoreType(params).subscribe(new RxSubscriber<StoreTypeBean>(mContext, true) {
            @Override
            protected void _onNext(StoreTypeBean storeTypeBean) {
                mView.returnStoreType(storeTypeBean);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });
        mRxManage.add(subscribe);
    }
}
