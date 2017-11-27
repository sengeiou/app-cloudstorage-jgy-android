package com.guoyie.www.delivery.easy.toast;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.guoyie.www.delivery.easy.R;


/**
 * author：柯军
 * project：New_GuoYieAndroid
 * package：com.guoyie.www.gyapp.toast
 * email：774169396@qq.com
 * data：16/12/16
 */
public class TPrompt extends Toast {
    private Context mContext;
    private TextView chapterNameTV;

    public TPrompt(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    protected void initView() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.book_reading_toast, null);
        chapterNameTV = (TextView) view.findViewById(R.id.chapterName);
        setGravity(Gravity.CENTER, 0, 0);
        setDuration(Toast.LENGTH_SHORT);
        setView(view);
    }

    /**
     * 文字提示
     *
     * @param msg
     */
    public void showToast(String msg) {
        if (chapterNameTV != null) {
            show();
            chapterNameTV.setText(msg);
        }
    }

}
