package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;

/**
 * author：柯军
 * project：CloudManager
 * package：com.chinayie.cloudmanager.contract
 * email：774169396@qq.com
 * data：2017/7/24
 */


   public  interface  ApprovedContract {
    interface  Model extends BaseModel {
        rx.Observable<Object> getApprovedData(String params);
    }


    interface  View extends BaseView {
        void returnApporvedData(Object data);
        void err_or(String msg);
    }


    abstract class Presenster extends BasePresenter<View,Model> {
        public abstract void requstApprovedData(String params );
    }
}
