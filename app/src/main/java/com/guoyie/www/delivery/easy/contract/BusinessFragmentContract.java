package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.AppVersionBean;
import com.guoyie.www.delivery.easy.entity.BannerData;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2018/1/8
 */
public interface BusinessFragmentContract {

    interface Model extends BaseModel{
        Observable <BannerData> getBanner(String params);

        Observable<AppVersionBean> getAppVersion(String params);
    }



    interface View extends BaseView{
        void returnBanner(BannerData data);

        void returnAppVersion(AppVersionBean appVersionBean);

        void error(String message);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void requstBanner(String params);

        public abstract void requestAppVersion(String params);

    }






}
