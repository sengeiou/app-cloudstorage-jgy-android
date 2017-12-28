package com.guoyie.www.delivery.easy.presenter;

import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.EditOrderContract;
import com.guoyie.www.delivery.easy.rx.RxSubscriber;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Subscription;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.presenter
 * email：774169396@qq.com
 * data：2017/12/28
 */
public class EditOrderPresenter extends EditOrderContract.Presenter {
    @Override
    public void requsteditinterstock(String params) {
        Subscription subscribe = mModel.editinterstock(params).subscribe(new RxSubscriber<BaseResponse>(mContext,true) {
            @Override
            protected void _onNext(BaseResponse baseResponse) {
                mView.returneditinterstock(baseResponse);
            }

            @Override
            protected void _onError(String message) {
                mView.eeror(message);

            }
        });
         mRxManage.add(subscribe);
    }

    @Override
    public void requsteditouterstock(String params) {
        Subscription subscribe = mModel.editouterstock(params).subscribe(new RxSubscriber<BaseResponse>(mContext,true) {
            @Override
            protected void _onNext(BaseResponse baseResponse) {
                mView.returneditouterstock(baseResponse);
            }

            @Override
            protected void _onError(String message) {
                mView.eeror(message);
            }
        });
        mRxManage.add(subscribe);

    }

    @Override
    public void requstreturneditLoadobj(Map<String,RequestBody> params ) {
        Subscription subscribe = mModel.editLoadobj(params).subscribe(new RxSubscriber<BaseResponse>(mContext,true) {
            @Override
            protected void _onNext(BaseResponse baseResponse) {
                mView.returneditLoadobj(baseResponse);
            }

            @Override
            protected void _onError(String message) {
                mView.eeror(message);
            }
        });


        mRxManage.add(subscribe);

    }
}
