package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;

import io.reactivex.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/28
 */
public interface AddOrderDetailContract {

    interface Model extends BaseModel{
        //添加入库明细
        Observable<BaseResponse> getAddStockInter(String params);
        //添加出库明细
        Observable <BaseResponse> getAddStockOuter(String params);
        //获取储罐号
        Observable<StoreNumberBean> getStoreNumber(String params);

    }

    interface View extends BaseView{
        //加添入库明细
        void returnAddStcokInter(BaseResponse data);
        //添加出库明细
        void returnAddStcokOuter(BaseResponse data);
        //获取储罐号
        void returnStoreNumber(StoreNumberBean storeNumberBean);

        void error(String msg);
    }




    abstract class Presenter extends BasePresenter<View,Model>{
        //添加入库明细
        public abstract  void requstAddStcokInter(String params);
        //添加出库明细
        public abstract  void requstAddStcokOuter(String params);
        //获取储罐号
        public abstract void requestStoreNumber(String params);
    }

}
