package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.entity.Transstock;
import com.guoyie.www.delivery.easy.widget.recyclerview.NAdapter;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerViewHolder;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：774169396@qq.com
 * data：2017/12/7
 */
public class TrantosListAdapter extends NAdapter<Transstock.ListBean> {
    public TrantosListAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.trantos_item;
    }

    @Override
    protected void onBindData(final NRecyclerViewHolder holder, Transstock.ListBean data, final int position) {

        TextView goods_name = holder.getView(R.id.goods_name);
        TextView instock_customer_no = holder.getView(R.id.instock_customer_no);
        TextView instock_date = holder.getView(R.id.instock_date);
        TextView shop_company_name = holder.getView(R.id.shop_company_name);
        TextView tv_status = holder.getView(R.id.tv_status);

        //设置数据的啊
        goods_name.setText(data.getGoods_name());//品名
        instock_customer_no.setText("货转指令号       "+data.getTransstock_no());//入库单号
        instock_date.setText("创建时间        "+data.getCreate_at());//预计入库时间
        shop_company_name.setText("企业名称     "+data.getShop_sale_company_name());//企业名称
        String status=null;
        switch (data.getStatus()){
            case 4:
                status="待仓储审核";//待仓储审核
                break;
            case 5:
                status="未通过";//未通过
                break;
            case 6:
                status="已完成";//已完成
                break;

        }
        tv_status.setText(status);//设置状态



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
