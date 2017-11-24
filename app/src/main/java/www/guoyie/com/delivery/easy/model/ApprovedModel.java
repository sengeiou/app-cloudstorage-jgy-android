package www.guoyie.com.delivery.easy.model;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import www.guoyie.com.delivery.easy.api.ApiManager;
import www.guoyie.com.delivery.easy.api.HostType;
import www.guoyie.com.delivery.easy.contract.ApprovedContract;

/**
 * author：柯军
 * project：CloudManager
 * package：com.chinayie.cloudmanager.model
 * email：774169396@qq.com
 * data：2017/7/24
 *
 */
public class ApprovedModel  implements ApprovedContract.Model{
    @Override
    public Observable<Object> getApprovedData(String params) {
        return ApiManager.getService(HostType.HTTP_ORDINARY).getHomePageList(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
