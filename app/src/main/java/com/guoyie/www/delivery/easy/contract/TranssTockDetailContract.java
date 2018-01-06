package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.TransstockDetailData;

import rx.Observable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/23
 */
public interface TranssTockDetailContract {

    interface Model extends BaseModel{
        Observable <TransstockDetailData>getTransstockDetailData(String params);
      Observable<BaseResponse> getTranssUpdate(String params);
    }

    interface View extends BaseView{
        void returnTransstockDetailData(TransstockDetailData data);
        void returnTransstockUpdate(BaseResponse data);
        void error(String data);
    }



    abstract class Presenter extends BasePresenter<View,Model>{
        abstract public void requstTransstockDetailData(String params);
        abstract public void requstTransstockUpdata(String params);
    }


}
