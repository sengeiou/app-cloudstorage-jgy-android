package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.GetTime;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/12
 */
public interface MainContract {

    interface Model extends BaseModel {

       Observable<GetTime> getTime(String params);
    }



    interface  View extends BaseView{
         void returnTime(GetTime time);
         void error(String msg);

     }


    abstract class Presenster extends BasePresenter<View,Model> {
        public abstract void requstTime(String params );
    }

}
