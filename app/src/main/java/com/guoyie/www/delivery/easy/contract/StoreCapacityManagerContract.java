package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.StoreCapacityListBean;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;

import rx.Observable;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：1649369473@qq.com
 * data：2017/12/22
 */

public interface StoreCapacityManagerContract {
    interface Model extends BaseModel {
        Observable<StoreCapacityListBean> getStoreCapacity(String params);
    }

    interface View extends BaseView {
        void returnStoreCapacityList(StoreCapacityListBean storeCapacityListBean);
        void error(String msg);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void requestStoreCapacityList(String params);
    }
}
