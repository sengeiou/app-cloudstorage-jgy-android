package www.guoyie.com.delivery.easy.presenter;


import rx.Subscription;
import www.guoyie.com.delivery.easy.contract.ApprovedContract;
import www.guoyie.com.delivery.easy.rx.RxSubscriber;

/**
 * author：柯军
 * project：CloudManager
 * package：com.chinayie.cloudmanager.presenter
 * email：774169396@qq.com
 * data：2017/7/24
 */
public class ApprovedPresenter extends ApprovedContract.Presenster {
    @Override
    public void requstApprovedData(String params) {

        Subscription subscribe = mModel.getApprovedData(params).subscribe(new RxSubscriber<Object>(mContext) {
            @Override
            protected void _onNext(Object data) {
                mView.returnApporvedData(data);
            }

            @Override
            protected void _onError(String message) {
                mView.err_or(message);
            }
        });

        mRxManage.add(subscribe);

    }


}
