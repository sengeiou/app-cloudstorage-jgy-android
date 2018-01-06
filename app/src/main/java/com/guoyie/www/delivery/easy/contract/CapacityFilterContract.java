package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.CapacityGoodsNameBean;
import com.guoyie.www.delivery.easy.entity.CapacityStoreNumberBean;

import io.reactivex.Observable;


/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：1649369473@qq.com
 * data：2017/12/23
 */

public interface CapacityFilterContract {
    interface Model extends BaseModel {
        //获取商品名
        Observable<CapacityGoodsNameBean> getCapacityGoodsName(String params);
        //获取储罐号
        Observable<CapacityStoreNumberBean> getStoreNumber(String params);
    }


    interface View extends BaseView {
        //获取返回储罐名
        void returnCapacityGoodsName(CapacityGoodsNameBean capacityGoodsNameBean);
        //返回储罐号
        void returnStoreNumber(CapacityStoreNumberBean capacityStoreNumberBean);
        void error(String msg);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        //请求储罐名
        public abstract void requestCapacityGoodsName(String params);
        //请求储罐号
        public abstract void requestStoreNumber(String params);
    }
}
