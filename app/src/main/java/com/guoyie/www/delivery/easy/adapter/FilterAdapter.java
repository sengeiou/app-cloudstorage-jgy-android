package com.guoyie.www.delivery.easy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：1649369473@qq.com
 * data：2017/12/12
 */

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder>{

    private List<String> mStringList;

    public FilterAdapter(List<String> stringList) {
        mStringList = stringList;
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FilterViewHolder(new TextView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(FilterViewHolder holder, int position) {
        holder.mTextView.setText(mStringList.get(position));

    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    static class FilterViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public FilterViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
