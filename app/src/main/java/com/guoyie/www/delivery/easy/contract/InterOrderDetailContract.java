package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.InputOrderDetailData;

import rx.Observable;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/21
 */
public interface InterOrderDetailContract  {
    interface Model extends BaseModel{
        Observable<InputOrderDetailData> getIODetailData(String params);
    }


    interface View extends BaseView{
        void returnInterOrderDetailData(InputOrderDetailData data);
        void error(String msg);
    }


    abstract class Presenter extends BasePresenter<View,Model>{
     public abstract    void  requstInterOrderDetail(String params);


    }

}
