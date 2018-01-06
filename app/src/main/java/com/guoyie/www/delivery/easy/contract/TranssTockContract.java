package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.TransstockData;

import io.reactivex.Observable;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/23
 */
public interface TranssTockContract {

    interface Model extends BaseModel{
        Observable<TransstockData> getTranssTockData(String params);
    }

    interface View extends BaseView{
        void returnTranssTockData(TransstockData data);
        void error(String msg);
    }



    abstract class Presenter extends BasePresenter<View,Model>{
        abstract public void requstTranssTockData(String params);
    }


}
