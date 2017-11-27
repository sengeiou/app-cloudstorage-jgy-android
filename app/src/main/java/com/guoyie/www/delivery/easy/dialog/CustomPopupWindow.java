package com.guoyie.www.delivery.easy.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * author：柯军
 * project：CloudManager
 * package：com.chinayie.cloudmanager.dialog
 * email：774169396@qq.com
 * data：2017/6/27
 */

public class CustomPopupWindow extends PopupWindow {

    public CustomPopupWindow(Context context, int layout, int width, int height) {
        super(context);
        View view = LayoutInflater.from(context).inflate(layout, null);
        this.setBackgroundDrawable(new ColorDrawable());
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setContentView(view);
        this.setWidth(width);
        this.setHeight(height);
        this.update();
    }

    public View getView() {
        return getContentView();
    }

    public void showDropDown(View anchor) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            setHeight(h);
        }

       showAsDropDown(anchor);
    }


    @Override
    public void showAsDropDown(View anchor) {

        super.showAsDropDown(anchor);
    }
}
