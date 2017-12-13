package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.FilterAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityFilterBinding;
import com.guoyie.www.delivery.easy.widget.recyclerview.SpaceItemDecoration;

import java.util.ArrayList;

public class FilterActivity extends BaseActivity implements View.OnClickListener {

    private ActivityFilterBinding mBinding;
    private TextView mTV_title;
    private ImageView mIv_back;
    private RecyclerView mRvGoodsName;
    private RecyclerView mRvStoreClass;
    private RecyclerView mRvStoreNumber;
    private Button mBtReset;
    private Button mBtSure;
    private FilterAdapter mFilterAdapter1;
    private FilterAdapter mFilterAdapter2;
    private FilterAdapter mFilterAdapter3;

    public TextView currentGoodNameTextView;    //当前被选中的商品名
    public TextView currentStoreClassTextView;    //当前被选中的储罐类型
    public TextView currentStoreNumberView;    //当前被选中的储罐编号

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
        mBtReset = mBinding.btReset;
        mBtSure = mBinding.btSure;

        mBtReset.setOnClickListener(this);
        mBtSure.setOnClickListener(this);

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
        SpaceItemDecoration itemDecoration = new SpaceItemDecoration(54,42,54,42);

        mRvGoodsName.addItemDecoration(itemDecoration);
        mRvStoreClass.addItemDecoration(itemDecoration);
        mRvStoreNumber.addItemDecoration(itemDecoration);

    }

    private void initData() {
        ArrayList<String> strings1 = new ArrayList<>();
        for (int i = 0;i<10;i++){
            strings1.add("AAA"+i);
        }
        mFilterAdapter1 = new FilterAdapter(strings1);
        mRvGoodsName.setAdapter(mFilterAdapter1);

        ArrayList<String> strings2 = new ArrayList<>();
        for (int i = 0;i<10;i++){
            strings2.add("AAA"+i);
        }
        mFilterAdapter2 = new FilterAdapter(strings2);
        mRvStoreClass.setAdapter(mFilterAdapter2);

        ArrayList<String> strings3 = new ArrayList<>();
        for (int i = 0;i<10;i++){
            strings3.add("AAA"+i);
        }
        mFilterAdapter3 = new FilterAdapter(strings3);
        mRvStoreNumber.setAdapter(mFilterAdapter3);

        //条目点击
        mFilterAdapter1.setOnItemClickListener(new FilterAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v) {
                TextView tv = (TextView) v;
                if (currentGoodNameTextView!=null){
                    currentGoodNameTextView.setSelected(false);
                }
                currentGoodNameTextView = tv;
                currentGoodNameTextView.setSelected(true);

            }
        });

        mFilterAdapter2.setOnItemClickListener(new FilterAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v) {
                TextView tv = (TextView) v;
                if (currentStoreClassTextView!=null){
                    currentStoreClassTextView.setSelected(false);
                }
                currentStoreClassTextView = tv;
                currentStoreClassTextView.setSelected(true);
            }
        });

        mFilterAdapter3.setOnItemClickListener(new FilterAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v) {
                TextView tv = (TextView) v;
                if (currentStoreNumberView!=null){
                    currentStoreNumberView.setSelected(false);
                }
                currentStoreNumberView = tv;
                currentStoreNumberView.setSelected(true);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.bt_sure:
                // TODO: 2017/12/13 确定选择，筛选结果
                break;
            case R.id.bt_reset:
                currentGoodNameTextView.setSelected(false);
                currentStoreNumberView.setSelected(false);
                currentStoreClassTextView.setSelected(false);
        }
    }
}
