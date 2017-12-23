package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
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

        Observable<OuterOrderDetailData> getOuterDetailrData(String params);
    }


    interface View extends BaseView {
        void returnOuterDetailrData(OuterOrderDetailData data);
        void error(String msg);
    }


    abstract class Presenter extends BasePresenter<View, Model> {

        abstract public void requstOuterDetailrData(String params);
    }


}

