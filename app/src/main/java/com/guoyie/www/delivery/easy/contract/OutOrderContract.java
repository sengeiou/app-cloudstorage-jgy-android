package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;

import io.reactivex.Observable;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/22
 */
public interface OutOrderContract {

    interface Model extends BaseModel {

        Observable<OuterOrderInfoData> getOuterOrderData(String params);
    }


    interface View extends BaseView {
        void returnOuterOrderData(OuterOrderInfoData data);
        void error(String msg);
    }


    abstract class Presenter extends BasePresenter<View, Model> {

        abstract public void requstOutorderData(String params);
    }


}

