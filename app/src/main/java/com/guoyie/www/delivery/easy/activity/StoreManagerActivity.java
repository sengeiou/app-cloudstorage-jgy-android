package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.StoreManagerAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityStoreManagerBinding;
import com.guoyie.www.delivery.easy.entity.StoreManagerBean;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 储罐管理的Activity
 */
public class StoreManagerActivity extends BaseActivity implements View.OnClickListener, StoreManagerAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, NRecyclerView.OnLoadMoreListener {
    private ImageView mLeft_back;
    private TextView mTv_title;
    private TextView mTV_right;

    private NRecyclerView mRecyclerView;
    private List<StoreManagerBean> mStoreManagerList;
    private StoreManagerAdapter mAdapter;
    private ActivityStoreManagerBinding mBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_store_manager;
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
        mTv_title.setText("储罐管理");
        mTV_right.setText("筛选");

        mRecyclerView = mBinding.nrecycler;
        initRecycleView();

        mTV_right.setOnClickListener(this);
        mLeft_back.setOnClickListener(this);
    }

    private void initRecycleView() {
        mStoreManagerList = new ArrayList<>();

        for (int i = 0;i < 10;i++){
            mStoreManagerList.add(new StoreManagerBean("4155411441","原子弹","1000吨","偷来的"));
        }

        mAdapter = new StoreManagerAdapter(this);

        mAdapter.setData(mStoreManagerList);
        mAdapter.setOnItemClickListener(this);
        mBinding.swipeRefresh.setOnRefreshListener(this);
        mBinding.nrecycler.setOnLoadMoreListener(this);
        mBinding.nrecycler.setLoadMoreEnable(true);
        mBinding.nrecycler.setAdapter(mAdapter);
        mBinding.nrecycler.setErrorMessage("暂无消息提醒");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_right:
                startAct(FilterActivity.class);
                break;
            case R.id.left_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(View itemView, int position) {
        startAct(StoreDetailActivity.class);
    }

    @Override
    public void onRefresh() {
        mBinding.swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onLoadMore() {
        mBinding.nrecycler.stopLoadMore();
    }
}
