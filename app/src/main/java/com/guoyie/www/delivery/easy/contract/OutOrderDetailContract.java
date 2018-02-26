package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.OuterOrderDetailData;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/22
 */
public interface OutOrderDetailContract {

    interface Model extends BaseModel {

        Observable<OuterOrderDetailData> getOuterDetailData(String params);
        Observable<BaseResponse> getOuterDetailUpdate(String params);
        Observable<BaseResponse>getHandleOuter(String params);

    }


    interface View extends BaseView {
        void returnOuterDetailData(OuterOrderDetailData data);
        void returnOuterDetailUpdate(BaseResponse data);
        void returnOuterHandle(BaseResponse data);
        void error(String msg);
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        abstract public void requstOuterDetailData(String params);
        abstract public void requstOuterDetailUpdate(String params);
        public abstract void requstouterHandle(String params);
    }


}

