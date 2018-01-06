package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.GoodsNameBean;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.entity.StoreTypeBean;

import io.reactivex.Observable;


/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：1649369473@qq.com
 * data：2017/12/25
 */

public interface StoreFilterContract {
    interface Model extends BaseModel {
        //获取储罐号
        Observable<StoreNumberBean> getStoreNumber(String params);
        //获取商品名
        Observable<GoodsNameBean> getGoodsName(String params);
        //获取储罐性质
        Observable<StoreTypeBean> getStoreType(String params);

    }

    interface View extends BaseView {
        void returnStoreNumber(StoreNumberBean storeNumberBean);

        void returnGoodsName(GoodsNameBean goodsNameBean);

        void returnStoreType(StoreTypeBean storeTypeBean);

        void error(String msg);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void requestStoreNumber(String params);

        public abstract void requestGoodsName(String params);

        public abstract void requestStoreType(String params);
    }
}
