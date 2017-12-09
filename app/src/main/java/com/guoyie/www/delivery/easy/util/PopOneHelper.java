package com.guoyie.www.delivery.easy.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.loopview.LoopView;
import com.guoyie.www.delivery.easy.loopview.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;


public class PopOneHelper {
    private Context     context;
    private View        view;
    private PopupWindow pop;
    private List<String> listData = new ArrayList<>();
    private LoopView          loopView;
    private OnClickOkListener onClickOkListener;
    private String            selectText;
    private int position = 0;

    public PopOneHelper(Context context) {
        this.context = context;
        view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.picker_one_birth, null);
        pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        initPop();
        initView();
    }

    /**
     * 设置数据源
     *
     * @param listData
     */
    public void setListData(List<String> listData) {
        this.listData = listData;
        loopView.setItems(listData);
        if (listData.size() > 0) {
            selectText = listData.get(0);
        }
    }

    private void initView() {
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
        Button btnOk = (Button) view.findViewById(R.id.btnOK);

        loopView = (LoopView) view.findViewById(R.id.loopView1);
        loopView.setNotLoop();
        loopView.setDividerColor(ContextCompat.getColor(context, R.color.transparent));
        loopView.setCurrentPosition(0);
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                selectText = listData.get(index);
                position = index;
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickOkListener != null) {
                    onClickOkListener.onClickOk(selectText, position);
                }
                pop.dismiss();
            }
        });
    }


    private void initPop() {
        pop.setAnimationStyle(android.R.style.Animation_InputMethod);
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(new ColorDrawable());
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    /**
     * 显示
     *
     * @param view
     */
    public void show(View view) {
        pop.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    /**
     * 隐藏监听
     *
     * @param onDismissListener
     */
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        pop.setOnDismissListener(onDismissListener);
    }

    public void setOnClickOkListener(OnClickOkListener onClickOkListener) {
        this.onClickOkListener = onClickOkListener;
    }

    public interface OnClickOkListener {
         void onClickOk(String birthday, int position);
    }
}
