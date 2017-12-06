package com.guoyie.www.delivery.easy.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.widget
 * email：1649369473@qq.com
 * data：2017/12/6
 *
 * 自定义的可以实现drawableleft和drawableright的点击监听
 */

public class CustomEditText extends AppCompatEditText{
    private DrawableLeftClickListenner mDrawableLeftClickListenner;
    private DrawableRightClickListenner mDrawableRightClickListenner;

    public void setDrawableLeftClickListenner(DrawableLeftClickListenner drawableLeftClickListenner) {
        mDrawableLeftClickListenner = drawableLeftClickListenner;
    }

    public void setDrawableRightClickListenner(DrawableRightClickListenner drawableRightClickListenner) {
        mDrawableRightClickListenner = drawableRightClickListenner;
    }

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface DrawableLeftClickListenner{
        void onDrawableLeftClickListenner(View view);
    }

    public interface DrawableRightClickListenner{
        void onDrawableRightClickListenner(View view);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mDrawableLeftClickListenner != null) {
                    Drawable drawableLeft = getCompoundDrawables()[0];  //左上右下分别是0,1,2,3
                    if (drawableLeft != null && event.getRawX() >= (getRight() - drawableLeft.getBounds().width())) {
                        mDrawableLeftClickListenner.onDrawableLeftClickListenner(this);
                        return true;

                    }

                }

                if (mDrawableRightClickListenner != null) {
                    Drawable drawableRight = getCompoundDrawables()[2];  //左上右下分别是0,1,2,3
                    if (drawableRight != null && event.getRawX() >= (getRight() - drawableRight.getBounds().width())) {
                        mDrawableRightClickListenner.onDrawableRightClickListenner(this);
                        return true;
                    }

                }
        }
        return super.onTouchEvent(event);
    }
}
