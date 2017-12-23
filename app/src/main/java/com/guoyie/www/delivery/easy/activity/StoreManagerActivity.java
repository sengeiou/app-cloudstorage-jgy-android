package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.StoreManagerAdapter;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.StoreManagerContract;
import com.guoyie.www.delivery.easy.databinding.ActivityStoreManagerBinding;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.StoreManagerModel;
import com.guoyie.www.delivery.easy.presenter.StoreManagerPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerView;

import java.util.List;

import static com.guoyie.www.delivery.easy.util.Constant.STORE_ID;

/**
 * 储罐管理的Activity
 */
public class StoreManagerActivity extends BaseActivity<StoreManagerPresenter,StoreManagerModel> implements View.OnClickListener, StoreManagerAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, NRecyclerView.OnLoadMoreListener ,StoreManagerContract.View{
    private ImageView mLeft_back;
    private TextView mTv_title;
    private TextView mTV_right;

    private NRecyclerView mRecyclerView;
    private List<StoreManagerListBean.DataBean.ListBean> mStoreManagerList;
    private StoreManagerAdapter mAdapter;
    private ActivityStoreManagerBinding mBinding;
    private int pageSize = 9;
    private int pageCurrent = 1;
    private UserInfoData mUserInfoData;

    @Override
    public int getLayoutId() {
        return R.layout.activity_store_manager;
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
        mTv_title.setText("储罐管理");
        mTV_right.setText("筛选");

        mRecyclerView = mBinding.nrecycler;
        initRecycleView();

        mTV_right.setOnClickListener(this);
        mLeft_back.setOnClickListener(this);
    }

    private void initRecycleView() {
        mAdapter = new StoreManagerAdapter(this);
        mAdapter.setOnItemClickListener(this);
        mBinding.swipeRefresh.setOnRefreshListener(this);
        mBinding.nrecycler.setOnLoadMoreListener(this);
        mBinding.nrecycler.setLoadMoreEnable(true);
        mBinding.nrecycler.setAdapter(mAdapter);
        mBinding.nrecycler.setErrorMessage("暂无储罐信息");

        mUserInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if (mUserInfoData !=null){
            String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.STORE_MANAGER_LIST + "&pageSize=" + pageSize + "&pageCurrent=" + pageCurrent
                    + "&vendor_no=" + mUserInfoData.getData().getInfo().getVendor_no());
            mPresenter.requestStoreManagerList(params);
        }else {
            showToast("null");
            return;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_right:
                startAct(StoreFilterActivity.class);
                break;
            case R.id.left_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(View itemView, int position) {
        //startAct(StoreDetailActivity.class);
        Intent intent = new Intent(this, StoreDetailActivity.class);
        intent.putExtra(STORE_ID,mAdapter.getList().get(position).getId());
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        mBinding.swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onLoadMore() {
        pageCurrent++;
        showToast(pageCurrent+"");
        String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.STORE_MANAGER_LIST + "&pageSize=" + pageSize + "&pageCurrent=" + pageCurrent
                + "&vendor_no=" + mUserInfoData.getData().getInfo().getVendor_no());
        mPresenter.requestStoreManagerList(params);
    }

    @Override
    public void returnStoreManagerList(StoreManagerListBean storeManagerListBean) {
        if (!storeManagerListBean.isOk()){
            showToast("网络错误");
            return;
        }
        mStoreManagerList = storeManagerListBean.getData().getList();
        if(pageCurrent == 1){
            mAdapter.setData(mStoreManagerList);
        }else {
            mAdapter.addData(mStoreManagerList);
            //mRecyclerView.stopLoadMore();
        }
    }

    @Override
    public void error(String msg) {
        showToast(msg);
    }
}
