package com.guoyie.www.delivery.easy.rx;

import android.content.Context;

import com.apkfuns.logutils.LogUtils;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.dialog.LoadingDialog;
import com.guoyie.www.delivery.easy.util.NetWorkUtils;

import rx.Subscriber;

public abstract class RxSubscriber<T> extends Subscriber<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog = true;
    private LoadingDialog dialog;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = true;
    }

    public RxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
    }

    public RxSubscriber(Context context) {
        this(context, GApp.getInstance().getString(R.string.loading), true);
    }

    public RxSubscriber(Context context, boolean showDialog) {
        this(context, GApp.getInstance().getString(R.string.loading), showDialog);
    }

    public RxSubscriber(Context context, String msg) {
        this(context, msg, true);
    }

    public RxSubscriber(Context context, int valuesId) {
        this(context, GApp.getInstance().getString(valuesId), true);
    }

    @Override
    public void onCompleted() {
        if (showDialog) {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (showDialog) {
            try {
                if (dialog == null) {
                    dialog = new LoadingDialog(mContext);
                }
                dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {


        LogUtils.d("Throwable::::"+e.toString());


        if (showDialog) {
            //  LoadingDialog.cancelDialogForLoading();
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(GApp.getInstance())) {
            _onError(GApp.getInstance().getString(R.string.no_net));
        }
        //服务器
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        }
        //其它
        else {
            _onError(GApp.getInstance().getString(R.string.net_error));
        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);



}
