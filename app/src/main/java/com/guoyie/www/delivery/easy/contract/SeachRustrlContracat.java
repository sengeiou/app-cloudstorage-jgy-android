package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.InputOrderInfoData;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.entity.TransstockData;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/26
 */
public interface SeachRustrlContracat {
    interface  Model extends BaseModel {
        //入库数据
        Observable<InputOrderInfoData> getInputData(String params);
        //出库数据
        Observable<OuterOrderInfoData> getOuterOrderData(String params);
        //货转数据
        Observable <TransstockData>getTranssTockData(String params);
        //意向单
        Observable<StorageData> getStorageData(String params);



    }


    interface  View extends BaseView {
        //入库数据
        void returnInputOrderData(InputOrderInfoData data);
        //出库数据
        void returnOuterOrderData(OuterOrderInfoData data);
        //货转数据
        void returnTranssTockData(TransstockData data);
        //意向单
        void returnStoreAgeData(StorageData data);


        void err_or(String data);
    }


    abstract  class Presenter extends BasePresenter<View,Model> {
        //入库数据
        abstract public  void requstInputOrderData(String params);
        //出库数据
        abstract public void requstOutorderData(String params);
        //货转数据
        abstract public void requstTranssTockData(String params);
        //意向单
        public abstract void requstStorageData(String params);


    }


}
