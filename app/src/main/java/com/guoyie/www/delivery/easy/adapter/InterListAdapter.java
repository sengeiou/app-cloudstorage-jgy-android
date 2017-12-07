package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.view.View;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.widget.recyclerview.NAdapter;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerViewHolder;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：774169396@qq.com
 * data：2017/12/7
 */
public class InterListAdapter extends NAdapter<String> {
    public InterListAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.interorder_item;
    }

    @Override
    protected void onBindData(final NRecyclerViewHolder holder, String s, final int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(holder.itemView,position);
                }
            }
        });

    }



    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }


    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}