package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityCapacityDetailBinding;
import com.guoyie.www.delivery.easy.entity.StoreCapacityListBean;


public class CapacityDetailActivity extends BaseActivity implements View.OnClickListener {

    private ActivityCapacityDetailBinding mBinding;
    private ImageView mLeft_back;
    private TextView mTv_title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_capacity_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());

        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("库容详情");
        mLeft_back.setOnClickListener(this);

        Intent intent = getIntent();
        StoreCapacityListBean.DataBean.ListBean listBean = (StoreCapacityListBean.DataBean.ListBean) intent.getSerializableExtra(StoreCapacityManagerActivity.LIST_BEAN);

        mBinding.tvStoreNumber.setText(listBean.getStock_no());
        mBinding.tvGoodsName.setText(listBean.getGoods_name());
        mBinding.tvEmptyCapacity.setText(listBean.getGoods_empty_volume()+listBean.getGoods_unit());
        mBinding.tvStoreCapacity.setText(listBean.getGoods_stock()+listBean.getGoods_unit());
        mBinding.tvStorePrice.setText(listBean.getGoods_storage_price());
        mBinding.tvCapacityType.setText(listBean.getGoods_nature());
        mBinding.tvPs.setText(listBean.getRemark());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_back:
                finish();
                break;
        }
    }
}
