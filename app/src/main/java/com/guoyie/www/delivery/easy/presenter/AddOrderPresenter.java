package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.AddOrderDetailContract;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/28
 */
public class AddOrderPresenter extends AddOrderDetailContract.Presenter {
    @Override
    public void requstAddStcokInter(String params) {
        Subscription subscribe = mModel.getAddStockInter(params).subscribe(new RxSubscriber<BaseResponse>(mContext,true) {
            @Override
            protected void _onNext(BaseResponse baseResponse) {
                mView.returnAddStcokInter(baseResponse);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);

            }
        });
        mRxManage.add(subscribe);


    }

    @Override
    public void requstAddStcokOuter(String params) {
        Subscription subscribe = mModel.getAddStockOuter(params).subscribe(new RxSubscriber<BaseResponse>(mContext, true) {
            @Override
            protected void _onNext(BaseResponse baseResponse) {
                mView.returnAddStcokOuter(baseResponse);
            }

            @Override
            protected void _onError(String message) {
               mView.error(message);
            }
        });
        mRxManage.add(subscribe);

    }

    @Override
    public void requestStoreNumber(String params) {
        Subscription subscribe = mModel.getStoreNumber(params).subscribe(new RxSubscriber<StoreNumberBean>(mContext,true) {
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
}
