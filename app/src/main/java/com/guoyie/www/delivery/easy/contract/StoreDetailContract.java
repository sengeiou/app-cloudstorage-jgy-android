package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.StoreDetailBean;

import io.reactivex.Observable;


/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：1649369473@qq.com
 * data：2017/12/22
 */

public interface StoreDetailContract {
    interface Model extends BaseModel {
        Observable<StoreDetailBean> getStoreDetail(String params);
    }

    interface View extends BaseView {
        void returnStoreDetail(StoreDetailBean storeDetailBean);
        void error(String msg);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void requestStoreDetail(String params);
    }
}
