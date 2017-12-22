package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.entity.Storage;
import com.guoyie.www.delivery.easy.widget.recyclerview.NAdapter;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerViewHolder;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：774169396@qq.com
 * data：2017/12/7
 */
public class InfoOrderListAdapter extends NAdapter<Storage.ListBean> {
    public InfoOrderListAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.inforder_item;
    }

    @Override
    protected void onBindData(final NRecyclerViewHolder holder, Storage.ListBean data, final int position) {
        TextView goods_name = holder.getView(R.id.goods_name);
        TextView instock_customer_no = holder.getView(R.id.instock_customer_no);
        TextView instock_date = holder.getView(R.id.instock_date);
        TextView shop_company_name = holder.getView(R.id.shop_company_name);
        TextView tv_status = holder.getView(R.id.tv_status);

        //设置数据的啊
        goods_name.setText(data.getGoods_name()+" | "+data.getGoods_num()+data.getGoods_unit());//品名
        instock_customer_no.setText("询价单号       "+data.getInquiry_no());//入库单号
        instock_date.setText("创建时间        "+data.getCreate_at());//预计入库时间
        shop_company_name.setText("企业名称     "+data.getCompany_name());//企业名称
        String status=null;
        //status 状态：1.待编辑，2.待审核，3.未通过，4.入库中，5.已完成，6.已结束
        switch (data.getStatus()){
            case 1:
                status="进行中";
                break;
            case -1:
                status="已取消";
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
