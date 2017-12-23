package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.entity.StoreCapacityListBean;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;
import com.guoyie.www.delivery.easy.widget.recyclerview.NAdapter;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerViewHolder;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：774169396@qq.com
 * data：2017/12/7
 */
public class StoreCapacityManagerAdapter extends NAdapter<StoreCapacityListBean.DataBean.ListBean> {
    public StoreCapacityManagerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.store_capacity_manager_item;
    }

    @Override
    protected void onBindData(final NRecyclerViewHolder holder, StoreCapacityListBean.DataBean.ListBean s, final int position) {
        TextView storeNumber = holder.itemView.findViewById(R.id.tv_store_number_value);//储罐号
        TextView emptyCapacity = holder.itemView.findViewById(R.id.tv_goods_name_value);//空容数量
        TextView goodsName = holder.itemView.findViewById(R.id.tv_store_type);//商品名

        storeNumber.setText(s.getStock_no());
        emptyCapacity.setText(s.getGoods_empty_volume());
        goodsName.setText(s.getGoods_name());

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
