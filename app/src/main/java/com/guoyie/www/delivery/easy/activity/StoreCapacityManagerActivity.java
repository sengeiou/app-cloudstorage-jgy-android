package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
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
        mTv_title.setText("库容管理");
        mTV_right.setText("筛选");

        mRecyclerView = mBinding.nrecycler;
        initRecyclerView();

        mLeft_back.setOnClickListener(this);
        mTV_right.setOnClickListener(this);
    }

    private void initRecyclerView() {

//        mStoreCapacityList = new ArrayList<>();

//        for (int i = 0;i < 10;i++){
//            mStoreCapacityList.add(new StoreCapacityListBean());
//        }


        mAdapter = new StoreCapacityManagerAdapter(this);

        mAdapter.setOnItemClickListener(this);
        mBinding.swipeRefresh.setOnRefreshListener(this);
        mBinding.nrecycler.setOnLoadMoreListener(this);
        mBinding.nrecycler.setLoadMoreEnable(true);
        mBinding.nrecycler.setAdapter(mAdapter);
        mBinding.nrecycler.setErrorMessage("暂无消息提醒");

        mUserInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if (mUserInfoData !=null){
            String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.CAPACITY_MANAGER + "&pageSize=" + pageSize + "&pageCurrent=" + pageCurrent
                    + "&vendor_no=" + mUserInfoData.getData().getInfo().getVendor_no());
            mPresenter.requestStoreCapacityList(params);
        }else {
            showToast("null");
            return;
        }

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
            mAdapter.setData(mStoreCapacityList);
        }else {
            showToast("网络错误");
        }
    }

    @Override
    public void error() {

    }
}
