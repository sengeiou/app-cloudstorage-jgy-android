package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.StoreFilterResultAdapter;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.StoreManagerContract;
import com.guoyie.www.delivery.easy.databinding.ActivityFilterResultBinding;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.StoreManagerModel;
import com.guoyie.www.delivery.easy.presenter.StoreManagerPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.SwipeRefreshLayoutt;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FilterResultActivity extends BaseActivity<StoreManagerPresenter,StoreManagerModel> implements StoreManagerContract.View {

    private ActivityFilterResultBinding mBinding;
    private ImageView mLeft_back;
    private TextView mTv_title;
    private TextView mTV_right;
    private NRecyclerView mRecyclerView;
    private SwipeRefreshLayoutt mSwipeRefresh;
    private StoreFilterResultAdapter mAdapter;
    private UserInfoData mUserInfoData;
    private int pageSize = 9;
    private int pageCurrent = 1;
    private List<StoreManagerListBean.DataBean.ListBean> mList;  //筛选结果数据集合

    @Override
    public int getLayoutId() {
        return R.layout.activity_filter_result;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);
    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back = (ImageView) getView(R.id.left_back);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTV_right = (TextView) getView(R.id.tv_right);
        mTv_title.setText("筛选结果");
        mTV_right.setVisibility(View.GONE);

        mRecyclerView = mBinding.nrecycler;
        mSwipeRefresh = mBinding.swipeRefresh;
        mRecyclerView.setLoadMoreEnable(true);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String goodsName = bundle.getString(Constant.GOODS_NAME); //储罐名
        String storeNumber = bundle.getString(Constant.STORE_NUMBER); //储罐号
        String storeType = bundle.getString(Constant.STORE_TYPE); //储罐类型

        mUserInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if (mUserInfoData != null){
            String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.STORE_MANAGER_LIST + "&pageSize=" + pageSize + "&pageCurrent=" + pageCurrent
                    + "&vendor_no=" + mUserInfoData.getData().getInfo().getVendor_no()+"&jar_no="+storeNumber+"&goods_name="+goodsName+"&\n" +
                    "jar_material="+storeType);
            mPresenter.requestStoreManagerList(params);
        }else {
            showToast(null);
        }

        initRecyclerView();
    }

    private void initRecyclerView() {
        mAdapter = new StoreFilterResultAdapter(this);
//        ArrayList<StoreManagerListBean.DataBean.ListBean> beansList = new ArrayList<>();
//        for (int i = 0;i<5;i++){
//            StoreManagerListBean.DataBean.ListBean listBean = new StoreManagerListBean.DataBean.ListBean();
//            listBean.setGoods_name("炸弹"+i);
//            beansList.add(listBean);
//        }
//        mAdapter.setData(beansList);
        mRecyclerView.setAdapter(mAdapter);

    }
    //返回筛选后的数据
    @Override
    public void returnStoreManagerList(StoreManagerListBean storeManagerListBean) {
        if (storeManagerListBean.isOk()){
            mList = storeManagerListBean.getData().getList();
            mAdapter.addData(mList);
        }else {
            showToast("网络错误");
        }
    }

    @Override
    public void error(String msg) {

    }
}
