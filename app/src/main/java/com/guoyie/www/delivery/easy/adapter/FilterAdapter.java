package com.guoyie.www.delivery.easy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;

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
    private OnItemClickListener mOnItemClickListener;
    public FilterAdapter(List<String> stringList) {
        mStringList = stringList;
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = (TextView) parent.inflate(parent.getContext(), R.layout.filter_item, null);

        return new FilterViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(FilterViewHolder holder, int position) {
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v);
            }
        });
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

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v);
    }

}
