package com.guoyie.www.delivery.easy.contract;

import com.guoyie.www.delivery.easy.base.BaseModel;
import com.guoyie.www.delivery.easy.base.BasePresenter;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.base.BaseView;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.contract
 * email：774169396@qq.com
 * data：2017/12/28
 */
//用来处理编辑入库确认单
public interface EditOrderContract {

    interface Model extends BaseModel{
    //入库编辑
    Observable<BaseResponse> editinterstock(String params);
    //出库编辑
    Observable<BaseResponse>editouterstock(String params);
    //上传图片的接口
    Observable<BaseResponse>editLoadobj(Map<String,RequestBody> file);

    }


    interface View extends BaseView{
        //入库编辑
        void returneditinterstock(BaseResponse data);
        //出库编辑
        void returneditouterstock(BaseResponse data);
        //上传图片的接口
        void returneditLoadobj(BaseResponse data);
        void eeror(String msg);

    }



    abstract class Presenter extends BasePresenter<View,Model>{
        // //入库编辑
        abstract public void requsteditinterstock(String params);
        //出库编辑
        abstract public void requsteditouterstock(String params);
        //上传图片的接口
        abstract public void requstreturneditLoadobj(Map<String,RequestBody>  params);

    }

}
