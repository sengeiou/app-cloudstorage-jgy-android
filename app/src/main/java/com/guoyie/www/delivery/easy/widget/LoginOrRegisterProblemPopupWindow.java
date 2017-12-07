package com.guoyie.www.delivery.easy.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.guoyie.www.delivery.easy.R;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.widget
 * email：1649369473@qq.com
 * data：2017/12/7
 */

public class LoginOrRegisterProblemPopupWindow extends PopupWindow implements View.OnClickListener {
    private final Button mBtPhone;
    private final Button mBtCancel;
    private Activity mActivity;
    private OnClickListener mOnClickListener;

    public LoginOrRegisterProblemPopupWindow(Activity mActivity,OnClickListener onClickListener,View view) {
        super(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mBtPhone = view.findViewById(R.id.bt_phone);
        mBtCancel = view.findViewById(R.id.bt_cancel);
        this.mActivity = mActivity;
        mOnClickListener = onClickListener;
        mBtPhone.setOnClickListener(this);
        mBtCancel.setOnClickListener(this);
        setBackgroundDrawable(new BitmapDrawable());
    }

    public void show(){
        showAtLocation(mActivity.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_phone:
                mOnClickListener.call();
                break;
            case R.id.bt_cancel:
                mOnClickListener.cancel();
                break;
        }

    }

    public interface OnClickListener{
        void call();
        void cancel();
    }
}
