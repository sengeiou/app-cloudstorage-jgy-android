package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.InputOrderInfoData;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/20
 */
public interface InterOrderContract {

    interface  Model extends BaseModel {
        Observable<InputOrderInfoData> getInputData(String params);



    }


    interface  View extends BaseView{
        void returnInputOrderData(InputOrderInfoData data);


        void err_or(String data);
    }


    abstract  class Presenter extends BasePresenter<View,Model>{
        abstract public  void requstInputOrderData(String params);


    }
}
