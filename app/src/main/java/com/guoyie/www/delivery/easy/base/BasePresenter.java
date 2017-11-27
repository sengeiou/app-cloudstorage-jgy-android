package com.guoyie.www.delivery.easy.base;

import android.content.Context;

import com.guoyie.www.delivery.easy.retrofit.RxManager;


/**
 * des:基类presenter
 */
public abstract class BasePresenter<T, E> {
    public Context mContext;
    public E mModel;
    public T mView;
    public RxManager mRxManage = new RxManager();

    public void attachVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart() {

    }

    public void onDestroy() {
        mRxManage.clear();
    }
}
