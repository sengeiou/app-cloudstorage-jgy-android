package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.StoreCapacityManagerAdapter;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.StoreCapacityManagerContract;
import com.guoyie.www.delivery.easy.databinding.ActivityStoreCapacityManagerBinding;
import com.guoyie.www.delivery.easy.entity.StoreCapacityListBean;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.StoreCapacityModel;
import com.guoyie.www.delivery.easy.presenter.StoreCapacityPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerView;

import java.io.Serializable;
import java.util.List;

/**
 * 库容管理的Activity
 */
public class StoreCapacityManagerActivity extends BaseActivity<StoreCapacityPresenter,StoreCapacityModel> implements StoreCapacityManagerAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, NRecyclerView.OnLoadMoreListener, View.OnClickListener, StoreCapacityManagerContract.View {
    public static final String LIST_BEAN = "listbean";
    private ImageView mLeft_back;
    private TextView mTv_title;
    private TextView mTV_right;

    private ActivityStoreCapacityManagerBinding mBinding;
    private NRecyclerView mRecyclerView;
    private List<StoreCapacityListBean.DataBean.ListBean> mStoreCapacityList;
    private StoreCapacityManagerAdapter mAdapter;
    private int pageSize = 9;
    private int pageCurrent = 1;
    private UserInfoData mUserInfoData;
    private String mGoodsName;
    private String mStoreNumber;

    @Override
    public int getLayoutId() {
        return R.layout.activity_store_capacity_manager;
    }

    @Override
    public void initPresenter() {
       mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTV_right = (TextView) getView(R.id.tv_right);
        mTV_right.setVisibility(View.VISIBLE);
        mTv_title.setText("库容管理");
        mTV_right.setText("筛选");

        mRecyclerView = mBinding.nrecycler;
        initRecyclerView();

        mLeft_back.setOnClickListener(this);
        mTV_right.setOnClickListener(this);
    }

    private void initRecyclerView() {

        mAdapter = new StoreCapacityManagerAdapter(this);

        mAdapter.setOnItemClickListener(this);
        mBinding.swipeRefresh.setOnRefreshListener(this);
        mBinding.nrecycler.setOnLoadMoreListener(this);
        mBinding.nrecycler.setLoadMoreEnable(true);
        mBinding.nrecycler.setAdapter(mAdapter);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){   //此时进入的是筛选结果列表
            //储罐名
            mGoodsName = bundle.getString(Constant.GOODS_NAME);
            //储罐号
            mStoreNumber = bundle.getString(Constant.STORE_NUMBER);

            mTV_right.setVisibility(View.GONE); //隐藏标题栏右侧"筛选"
            mBinding.swipeRefresh.setEnabled(false);//下拉刷新不可用

        }else {
            mGoodsName = "";
            mStoreNumber = "";
        }

        mUserInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if (mUserInfoData !=null){
            loadData();
        }else {
            showToast("null");
            return;
        }

    }

    private void loadData() {
        String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.CAPACITY_MANAGER + "&pageSize=" + pageSize + "&pageCurrent=" + pageCurrent
                + "&vendor_no=" + mUserInfoData.getData().getInfo().getVendor_no()+"&goods_name="+mGoodsName+"&stock_no="+mStoreNumber);
        mPresenter.requestStoreCapacityList(params);
    }

    @Override
    public void onItemClick(View itemView, int position) {
        StoreCapacityListBean.DataBean.ListBean item = mAdapter.getItem(position);
        Intent intent = new Intent(this, CapacityDetailActivity.class);
        intent.putExtra(LIST_BEAN, item);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        pageCurrent = 1;
        loadData();

    }

    @Override
    public void onLoadMore() {
        pageCurrent++;
        loadData();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.tv_right:
                startAct(CapacityFilterActivity.class);
                break;

        }
    }

    @Override
    public void returnStoreCapacityList(StoreCapacityListBean storeCapacityListBean) {

        if (storeCapacityListBean.isOk()){
            mStoreCapacityList = storeCapacityListBean.getData().getList();
            if(pageCurrent == 1){
                mAdapter.setData(mStoreCapacityList);
            }else {
                mAdapter.addData(mStoreCapacityList);
            }
        }else {
            showToast("网络错误");
        }
        mBinding.nrecycler.stopLoadMore();
        mBinding.swipeRefresh.setRefreshing(false);
    }

    @Override
    public void error(String msg) {
        mBinding.nrecycler.setErrorMessage("暂无消息提醒");
    }
}
