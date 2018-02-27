package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.AppVersionBean;

import rx.Observable;

/**
 * author：江滔
 * project：cloudstorage
 * package：com.guoyie.www.delivery.easy.contract
 * email：1649369473@qq.com
 * data：2018/2/27
 */

public interface AboutContract {
    interface Model extends BaseModel{
        Observable<AppVersionBean> getAppVersion(String params);
    }

    interface View extends BaseView{
        void returnVersion(AppVersionBean appVersionBean);
        void error(String msg);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void requestVersion(String params);
    }
}
