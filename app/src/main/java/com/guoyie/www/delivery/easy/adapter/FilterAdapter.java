package com.guoyie.www.delivery.easy.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.entity.CapacityGoodsNameBean;
import com.guoyie.www.delivery.easy.entity.CapacityStoreNumberBean;
import com.guoyie.www.delivery.easy.entity.GoodsNameBean;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.entity.StoreTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：1649369473@qq.com
 * data：2017/12/12
 */

public class FilterAdapter<E> extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder>{

    private List<E> mStringList = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    public void setStringList(List<E> stringList) {
        mStringList.clear();
        mStringList.addAll(stringList);
        notifyDataSetChanged();
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = (TextView) parent.inflate(parent.getContext(), R.layout.filter_item, null);
        return new FilterViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(FilterViewHolder holder, final int position) {

        if (mStringList.size() == 5 && position == mStringList.size()-1 ){   //当前的集合是lessList且是该集合最后一个元素，即“更多选项”时
            holder.mTextView.setTextColor(Color.parseColor("#497AF8"));
        }

        if (mStringList.size()>5 && position == mStringList.size()-1){  //当前的集合是moreList且是该集合最后一个元素，即“收起选项”时
            holder.mTextView.setTextColor(Color.parseColor("#497AF8"));

        }
        if (mStringList.size()>5 && position == 4){  //当前的集合是moreList且是该集合第5个元素时，颜色修改为默认形式，避免混乱
            holder.mTextView.setTextColor(Color.parseColor("#111111"));
        }
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v,position);
            }
        });

        //此处注意判断泛型类型
        E e = mStringList.get(position);
        if (e instanceof CapacityGoodsNameBean.DataBean){
            CapacityGoodsNameBean.DataBean e1 = (CapacityGoodsNameBean.DataBean) e;
            holder.mTextView.setText(e1.getGoods_name());
        }
        if (e instanceof CapacityStoreNumberBean.DataBean){
            CapacityStoreNumberBean.DataBean e1 = (CapacityStoreNumberBean.DataBean) e;
            holder.mTextView.setText(e1.getStock_no());
        }
        if (e instanceof GoodsNameBean.DataBean){
            GoodsNameBean.DataBean e1 = (GoodsNameBean.DataBean) e;
            holder.mTextView.setText(e1.getGoods_name());
        }
        if (e instanceof StoreTypeBean.DataBean){
            StoreTypeBean.DataBean e1 = (StoreTypeBean.DataBean) e;
            holder.mTextView.setText(e1.getJar_material());
        }
        if (e instanceof StoreNumberBean.DataBean){
            StoreNumberBean.DataBean e1 = (StoreNumberBean.DataBean) e;
            holder.mTextView.setText(e1.getJar_no());
        }

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
        void onItemClick(View v,int position);
    }

}
