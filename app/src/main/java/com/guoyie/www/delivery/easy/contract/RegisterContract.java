package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.RegisterData;

import io.reactivex.Observable;


/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：1649369473@qq.com
 * data：2017/12/20
 */

public interface RegisterContract {
    interface Model extends BaseModel {
        Observable<RegisterData> getRegister(String params);
    }

    interface View extends BaseView {
        void returnRegisterData(RegisterData data);
        void error(String msg);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void requestRegister(String params);
    }
}
