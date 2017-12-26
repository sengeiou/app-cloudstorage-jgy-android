package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.InterOrderDetailContract;
import com.guoyie.www.delivery.easy.entity.InputOrderDetailData;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/21
 */
public  class InputOrderDetaliPresenter extends InterOrderDetailContract.Presenter {
    @Override
    public void requstInterOrderDetail(String params) {
        Subscription subscribe = mModel.getIODetailData(params).subscribe(new RxSubscriber<InputOrderDetailData>(mContext, true) {
            @Override
            protected void _onNext(InputOrderDetailData data) {
                mView.returnInterOrderDetailData(data);

            }

            @Override
            protected void _onError(String message) {
                mView.error(message);
            }
        });

        mRxManage.add(subscribe);

    }

    @Override
    public void requstInterOrderUpdate(String params) {
        Subscription subscribe = mModel.getInterOrderUpdate(params).subscribe(new RxSubscriber<BaseResponse>(mContext,true) {
            @Override
            protected void _onNext(BaseResponse baseResponse) {
                mView.retrunInterOrderDetailUpdate(baseResponse);
            }

            @Override
            protected void _onError(String message) {
                mView.error(message);

            }
        });
        mRxManage.add(subscribe);
    }


}
