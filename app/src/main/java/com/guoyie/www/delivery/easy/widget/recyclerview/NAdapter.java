package com.guoyie.www.delivery.easy.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by necer on 2017/3/14.
 */

public abstract class NAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> dataList;
    protected Context mContext;

    private View mHeaderView;
    private View mFooterView;


    protected static int ITEM_NOMAL = 100;
    protected static int ITEM_FOOT = 200;

    protected static int ITEM_HEADER = 300;

    public NAdapter(Context context) {
        mContext = context;
        dataList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_HEADER && mHeaderView != null) {
            return new HeadAndFootViewHolder(mHeaderView);
        } else if (viewType == ITEM_FOOT && mFooterView != null) {
            return new HeadAndFootViewHolder(mFooterView);
        } else {
            View contentView = LayoutInflater.from(mContext).inflate(getItemLayoutId(), parent, false);
            RecyclerView.ViewHolder viewHolder = new NRecyclerViewHolder(contentView);
            return viewHolder;
        }
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) != ITEM_HEADER && getItemViewType(position) != ITEM_FOOT) {
            onBindData((NRecyclerViewHolder) holder, dataList.get(position - (mHeaderView == null ? 0 : 1)), position);

            ViewGroup itemView = (ViewGroup) holder.itemView;
       /*     View onClickView = itemView;//通常情况下点击的view是holder.itemView，但是如果是侧滑SwipeMenuLayout的情况，点击的view是SwipeMenuLayout的第一个子view
            if (itemView instanceof SwipeMenuLayout) {
                onClickView = itemView.getChildAt(0);
            }
*/
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    LogUtils.d("onClickonClickonClickonClick");

                    *//*NRecyclerView.OnItemClickListener onClickItemListener = mRecyclerView.getOnClickItemListener();
                    if (onClickItemListener != null) {
                        int adapterPosition = holder.getAdapterPosition();
                        T t = dataList.get(adapterPosition - (mHeaderView == null ? 0 : 1));
                        onClickItemListener.onClickItem(mRecyclerView, t, adapterPosition);
                    }*//*
                }
            });*/
        }
    }

    @Override
    public int getItemCount() {

        int i = dataList.size() + (mHeaderView == null ? 0 : 1) + (mFooterView == null ? 0 : 1);
        return i;
    }

    //获得条目的bean
    public T getItem(int position) {
        return dataList.get(position);
    }

    public View getHeadView() {
        return mHeaderView;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0 && mHeaderView != null) {
            return ITEM_HEADER;
        } else if (position >= dataList.size() + (mHeaderView == null ? 0 : 1) && mFooterView != null) {
            return ITEM_FOOT;
        } else {
            return ITEM_NOMAL;
        }
    }

    public void addData(List<T> list) {
        dataList.addAll(dataList.size(), list);
        notifyDataSetChanged();
    }

    public void setData(List<T> list) {

      //  removeLoadMoreView();
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
      //  mRecyclerView.getLayoutManager().scrollToPosition(0);
    }

    public void clear() {
        removeLoadMoreView();
        dataList.clear();
        notifyDataSetChanged();
    }

    public void delItem(T t) {
        if (dataList.contains(t)) {
            dataList.remove(t);
            notifyDataSetChanged();
        }
    }

    public List<T> getList() {
        return dataList;
    }

    protected abstract int getItemLayoutId();

    protected abstract void onBindData(NRecyclerViewHolder holder, T t, int position);

    public void addHeaderView(View headView) {
        if (mHeaderView != null) {
            throw new RuntimeException("RecyclerView已经有headerView!");
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        headView.setLayoutParams(layoutParams);
        this.mHeaderView = headView;
        notifyDataSetChanged();
    }

    protected void addLoadMoreView(View footerView) {
        if (mFooterView != null) {
            throw new RuntimeException("RecyclerView已经有footerView!");
        }
        this.mFooterView = footerView;
        notifyDataSetChanged();
    }

    public boolean hasLoadMoreView() {
        return mFooterView == null ? false : true;
    }

    public void removeLoadMoreView() {
        mFooterView = null;
    }

    static class HeadAndFootViewHolder extends RecyclerView.ViewHolder {
        public HeadAndFootViewHolder(View itemView) {
            super(itemView);
        }
    }

}

