package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseView;
import com.guoyie.www.delivery.easy.entity.UserInfoData;

import io.reactivex.Observable;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/20
 */
public interface  LoginContract {

     interface  Model extends BaseModel {
         Observable<UserInfoData> getLoginData(String parms);
     }

     interface  View extends BaseView{
         void returnInfoData(UserInfoData data);
         void  eeror(String msg);
     }


     abstract  class Presenter extends BasePresenter<View,Model>{

         public abstract void requestLoginData(String parms);

     }

}
