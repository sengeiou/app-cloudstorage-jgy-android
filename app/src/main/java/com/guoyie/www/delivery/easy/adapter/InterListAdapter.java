package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.entity.InputOrderInfo;
import com.guoyie.www.delivery.easy.widget.recyclerview.NAdapter;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerViewHolder;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：774169396@qq.com
 * data：2017/12/7
 */
public class InterListAdapter extends NAdapter<InputOrderInfo.ListBean> {

    public InterListAdapter(Context context) {
        super(context);

    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.interorder_item;
    }

    @Override
    protected void onBindData(final NRecyclerViewHolder holder, InputOrderInfo.ListBean data, final int position) {
        TextView goods_name = holder.getView(R.id.goods_name);
        TextView instock_customer_no = holder.getView(R.id.instock_customer_no);
        TextView instock_date = holder.getView(R.id.instock_date);
        TextView shop_company_name = holder.getView(R.id.shop_company_name);
        TextView tv_status = holder.getView(R.id.tv_status);

        //设置数据的啊
        goods_name.setText(data.getGoods_name()+" | "+data.getOrder_qty()+data.getGoods_unit());//品名
        instock_customer_no.setText("入库单号       "+data.getInstock_customer_no());//入库单号
        instock_date.setText("预计入库时间        "+data.getInstock_date());//预计入库时间
        shop_company_name.setText("企业名称     "+data.getShop_company_name());//企业名称
        String status=null;
        //status 状态：1.待编辑，2.待审核，3.未通过，4.入库中，5.已完成，6.已结束
        switch (data.getStatus()){
            case 1:
                status="待编辑";
                break;
            case 2:
                status="待审核";
                break;
            case 3:
                status="未通过";
                break;
            case 4:
                status="入库中";
                break;
            case 5:
                status="已完成";
                break;
            case 6:
                status="已结束";
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
