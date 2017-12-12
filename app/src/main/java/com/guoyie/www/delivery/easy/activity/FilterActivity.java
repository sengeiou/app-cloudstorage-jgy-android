package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.FilterListAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityFilterBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterActivity extends BaseActivity implements View.OnClickListener {

    private ActivityFilterBinding mBinding;
    private TextView mTV_title;
    private ImageView mIv_back;
    private ExpandableListView mExpandableListView;

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
        mExpandableListView = mBinding.elvList;
        mTV_title.setText("储罐筛选");
        mIv_back.setOnClickListener(this);

        initData();
    }

    private void initData() {


        ArrayList<String> group1 = new ArrayList<>();
        TextView textView = new TextView(this);

        group1.add("第一组大儿子");
        group1.add("第一组二儿子");
        group1.add("第一组三儿子");
        ArrayList<String> group2 = new ArrayList<>();
        group2.add("第二组大儿子");
        group2.add("第二组大儿子");
        group2.add("第二组大儿子");
        HashMap<String, List<String>> groupList = new HashMap<>();
        groupList.put("第一组",group1);
        groupList.put("第二组",group2);
        FilterListAdapter filterListAdapter = new FilterListAdapter(this, groupList);
        mExpandableListView.setAdapter(filterListAdapter);

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
