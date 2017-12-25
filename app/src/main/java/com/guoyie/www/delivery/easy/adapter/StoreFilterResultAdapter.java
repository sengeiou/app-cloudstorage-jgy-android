package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;
import com.guoyie.www.delivery.easy.widget.recyclerview.NAdapter;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerViewHolder;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：1649369473@qq.com
 * data：2017/12/25
 */

public class StoreFilterResultAdapter extends NAdapter<StoreManagerListBean.DataBean.ListBean>{
    public StoreFilterResultAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.store_manager_item;
    }

    @Override
    protected void onBindData(NRecyclerViewHolder holder, StoreManagerListBean.DataBean.ListBean listBean, int position) {

        TextView storeNumber = holder.itemView.findViewById(R.id.tv_store_number_value);
        TextView goodsName = holder.itemView.findViewById(R.id.tv_goods_name_value);
        TextView weight = holder.itemView.findViewById(R.id.tv_weight);
        TextView storeType = holder.itemView.findViewById(R.id.tv_store_type);

        storeNumber.setText(listBean.getJar_no());//储罐号
        goodsName.setText(listBean.getGoods_name());//商品名
        weight.setText(listBean.getUnit());//储罐重量
        storeType.setText(listBean.getJar_type());//储罐类型
    }

}
