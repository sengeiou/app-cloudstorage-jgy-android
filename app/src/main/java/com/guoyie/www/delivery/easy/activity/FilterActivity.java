package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.FilterAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityFilterBinding;
import com.guoyie.www.delivery.easy.widget.RecycleViewDivider;
import com.guoyie.www.delivery.easy.widget.recyclerview.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterActivity extends BaseActivity implements View.OnClickListener {

    private ActivityFilterBinding mBinding;
    private TextView mTV_title;
    private ImageView mIv_back;
    private RecyclerView mRvGoodsName;
    private RecyclerView mRvStoreClass;
    private RecyclerView mRvStoreNumber;

    @Override
    public int getLayoutId() {
        return R.layout.activity_filter;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        mTV_title = (TextView) getView(R.id.tv_title);
        mIv_back = (ImageView) getView(R.id.left_back);
        mTV_title.setText("储罐筛选");
        mIv_back.setOnClickListener(this);

        initRecyclerView();
        initData();
    }

    private void initRecyclerView() {
        mRvGoodsName = mBinding.rvGoodsName;
        mRvStoreClass = mBinding.rvStoreClass;
        mRvStoreNumber = mBinding.rvStoreNumber;

        mRvGoodsName.setLayoutManager(new GridLayoutManager(this,3));
        mRvStoreClass.setLayoutManager(new GridLayoutManager(this,3));
        mRvStoreNumber.setLayoutManager(new GridLayoutManager(this,3));
        SpaceItemDecoration itemDecoration = new SpaceItemDecoration(42,42,42,42);
        //new RecycleViewDivider(this,)
        mRvGoodsName.addItemDecoration(itemDecoration);
    }

    private void initData() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0;i<6;i++){
            strings.add("AAA"+i);
        }
        FilterAdapter filterAdapter = new FilterAdapter(strings);
        mRvGoodsName.setAdapter(filterAdapter);

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
