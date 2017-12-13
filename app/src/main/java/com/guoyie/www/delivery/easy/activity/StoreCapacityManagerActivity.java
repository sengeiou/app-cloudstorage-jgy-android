package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.StoreCapacityManagerAdapter;
import com.guoyie.www.delivery.easy.adapter.StoreManagerAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityStoreCapacityManagerBinding;
import com.guoyie.www.delivery.easy.entity.StoreCapacityBean;
import com.guoyie.www.delivery.easy.entity.StoreManagerBean;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerView;

import java.util.ArrayList;

/**
 * 库容管理的Activity
 */
public class StoreCapacityManagerActivity extends BaseActivity implements StoreCapacityManagerAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, NRecyclerView.OnLoadMoreListener {
    private ImageView mLeft_back;
    private TextView mTv_title;
    private TextView mTV_right;

    private ActivityStoreCapacityManagerBinding mBinding;
    private NRecyclerView mRecyclerView;
    private ArrayList<StoreCapacityBean> mStoreCapacityList;
    private StoreCapacityManagerAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_store_capacity_manager;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTV_right = (TextView) getView(R.id.tv_right);
        mTv_title.setText("库容管理");
        mTV_right.setText("筛选");

        mRecyclerView = mBinding.nrecycler;

        initRecyclerView();
    }

    private void initRecyclerView() {

        mStoreCapacityList = new ArrayList<>();

        for (int i = 0;i < 10;i++){
            mStoreCapacityList.add(new StoreCapacityBean());
        }

        mAdapter = new StoreCapacityManagerAdapter(this);

        mAdapter.setData(mStoreCapacityList);
        mAdapter.setOnItemClickListener(this);
        mBinding.swipeRefresh.setOnRefreshListener(this);
        mBinding.nrecycler.setOnLoadMoreListener(this);
        mBinding.nrecycler.setLoadMoreEnable(true);
        mBinding.nrecycler.setAdapter(mAdapter);
        mBinding.nrecycler.setErrorMessage("暂无消息提醒");
    }

    @Override
    public void onItemClick(View itemView, int position) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}