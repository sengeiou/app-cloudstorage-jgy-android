package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
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
public class StoreManagerAdapter extends NAdapter<StoreManagerListBean.DataBean.ListBean> {
    public StoreManagerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.store_manager_item;
    }

    @Override
    protected void onBindData(final NRecyclerViewHolder holder, StoreManagerListBean.DataBean.ListBean s, final int position) {
        TextView storeNumber = holder.itemView.findViewById(R.id.tv_store_number_value);
        TextView goodsName = holder.itemView.findViewById(R.id.tv_goods_name_value);
        TextView weight = holder.itemView.findViewById(R.id.tv_weight);
        TextView storeType = holder.itemView.findViewById(R.id.tv_store_type);

        storeNumber.setText(s.getJar_no());//储罐号
        goodsName.setText(s.getGoods_name());//商品名
        weight.setText(s.getUnit());//储罐重量
        storeType.setText(s.getJar_type());//储罐类型

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
