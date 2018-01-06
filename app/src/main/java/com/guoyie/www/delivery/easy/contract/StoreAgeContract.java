package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.StorageData;

import io.reactivex.Observable;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/22
 */
public interface StoreAgeContract {

    interface View extends BaseView{
        void returnStoreAgeData(StorageData data);
        void err_or(String msg);
    }

    interface Model extends BaseModel{
        Observable<StorageData> getStorageData(String params);
    }


    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void requstStorageData(String params);
    }
}
