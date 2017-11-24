package www.guoyie.com.delivery.easy.contract;

/**
 * author：柯军
 * project：CloudManager
 * package：com.chinayie.cloudmanager.contract
 * email：774169396@qq.com
 * data：2017/7/24
 */


import rx.Observable;
import www.guoyie.com.delivery.easy.base.BaseModel;
import www.guoyie.com.delivery.easy.base.BasePresenter;
import www.guoyie.com.delivery.easy.base.BaseView;

public  interface  ApprovedContract {
    interface  Model extends BaseModel {
        Observable<Object> getApprovedData(String params);
    }


    interface  View extends BaseView {
        void returnApporvedData(Object data);
        void err_or(String msg);
    }


    abstract class Presenster extends BasePresenter<View,Model> {
        public abstract void requstApprovedData(String params );
    }
}
