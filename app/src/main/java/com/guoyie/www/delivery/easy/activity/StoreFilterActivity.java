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
import java.util.List;

public class StoreFilterActivity extends BaseActivity implements View.OnClickListener {

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
        final ArrayList<String> strings1 = new ArrayList<>();//数据源
        for (int i = 0;i<6;i++){
            strings1.add("AAA"+i);
        }
        final List<String> moreList1 = new ArrayList<>();
        moreList1.addAll(strings1);
        moreList1.add("收起更多");

        final List<String> lessList1 = new ArrayList<>();
        if (strings1.size()>=4){  //避免索引越界
            lessList1.addAll(strings1.subList(0,4));
            lessList1.add("更多选项");
        }
        mFilterAdapter1 = new FilterAdapter();
        if (strings1.size()>4){

            mFilterAdapter1.setStringList(lessList1);
        }else {
            mFilterAdapter1.setStringList(strings1);
        }
        mRvGoodsName.setAdapter(mFilterAdapter1);
//---------------------------------------------------------------
        ArrayList<String> strings2 = new ArrayList<>();
        for (int i = 0;i<5;i++){
            strings2.add("AAA"+i);
        }
        final List<String> moreList2 = new ArrayList<>();
        moreList2.addAll(strings2);
        moreList2.add("收起更多");

        final List<String> lessList2 = new ArrayList<>();
        if (strings2.size()>=4){  //避免索引越界
            lessList2.addAll(strings2.subList(0,4));
            lessList2.add("更多选项");
        }
        mFilterAdapter2 = new FilterAdapter();
        if (strings2.size()>4){

            mFilterAdapter2.setStringList(lessList2);
        }else {
            mFilterAdapter2.setStringList(strings2);
        }
        mRvStoreClass.setAdapter(mFilterAdapter2);
//------------------------------------------------------------
        ArrayList<String> strings3 = new ArrayList<>();
        for (int i = 0;i<4;i++){
            strings3.add("AAA"+i);
        }
        final List<String> moreList3 = new ArrayList<>();
        moreList3.addAll(strings3);
        moreList3.add("收起更多");

        final List<String> lessList3 = new ArrayList<>();
        if (strings3.size()>=4){  //避免索引越界
            lessList3.addAll(strings3.subList(0,4));
            lessList3.add("更多选项");
        }
        mFilterAdapter3 = new FilterAdapter();
        if (strings3.size()>4){

            mFilterAdapter3.setStringList(lessList3);
        }else {
            mFilterAdapter3.setStringList(strings3);
        }
        mRvStoreNumber.setAdapter(mFilterAdapter3);


        //条目点击
        mFilterAdapter1.setOnItemClickListener(new FilterAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v,int position) {
                int itemCount = mFilterAdapter1.getItemCount();
                //如果适配器当前的集合是moreList，则点击第5个item的时候将其设为currentGoodNameTextView，并将选中状态设为true
                if (itemCount == moreList1.size()){
                    if (position == 4){
                        if (currentGoodNameTextView!=null){
                            currentGoodNameTextView.setSelected(false);
                        }
                        currentGoodNameTextView = (TextView) v;
                        currentGoodNameTextView.setSelected(true);
                        return;
                    }
                }
                if (position == 4){
                    //strings1.remove(4);
                    mFilterAdapter1.setStringList(moreList1);
                    //切换集合的时候将当前被点击的位置处的Item设为未选中状态，并将currentGoodNameTextView重置为空
                    if (currentGoodNameTextView!=null){
                        currentGoodNameTextView.setSelected(false);
                        currentGoodNameTextView = null;
                    }
                    return;
                }
                if (position == moreList1.size()-1){
                    mFilterAdapter1.setStringList(lessList1);
                    //v.setSelected(false);
                    if (currentGoodNameTextView!=null){
                        currentGoodNameTextView.setSelected(false);
                        currentGoodNameTextView = null;
                    }
                    return;
                }
                TextView tv = (TextView) v;
                if (currentGoodNameTextView!=null){
                    currentGoodNameTextView.setSelected(false);
                }
                currentGoodNameTextView = tv;
                currentGoodNameTextView.setSelected(true);

            }
        });
//-----------------------------------------------------------------------------------------------
        mFilterAdapter2.setOnItemClickListener(new FilterAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v,int position) {
                int itemCount = mFilterAdapter2.getItemCount();
                //如果适配器当前的集合是moreList，则点击第5个item的时候将其设为currentGoodNameTextView，并将选中状态设为true
                if (itemCount == moreList2.size()){
                    if (position == 4){
                        if (currentStoreClassTextView!=null){
                            currentStoreClassTextView.setSelected(false);
                        }
                        currentStoreClassTextView = (TextView) v;
                        currentStoreClassTextView.setSelected(true);
                        return;
                    }
                }

                if (position == 4){
                    //strings1.remove(4);
                    mFilterAdapter2.setStringList(moreList2);
                    //切换集合的时候将当前被点击的位置处的Item设为未选中状态，并将currentGoodNameTextView重置为空
                    if (currentStoreClassTextView!=null){
                        currentStoreClassTextView.setSelected(false);
                        currentStoreClassTextView = null;
                    }
                    return;
                }

                if (position == moreList2.size()-1){
                    mFilterAdapter2.setStringList(lessList2);
                    //v.setSelected(false);
                    if (currentStoreClassTextView!=null){
                        currentStoreClassTextView.setSelected(false);
                        currentStoreClassTextView = null;
                    }
                    return;
                }

                TextView tv = (TextView) v;
                if (currentStoreClassTextView!=null){
                    currentStoreClassTextView.setSelected(false);
                }
                currentStoreClassTextView = tv;
                currentStoreClassTextView.setSelected(true);
            }
        });
//---------------------------------------------------------------------------------------------
        mFilterAdapter3.setOnItemClickListener(new FilterAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v,int position) {
                int itemCount = mFilterAdapter3.getItemCount();
                //如果适配器当前的集合是moreList，则点击第5个item的时候将其设为currentGoodNameTextView，并将选中状态设为true
                if (itemCount == moreList3.size()){
                    if (position == 4){
                        if (currentStoreNumberView!=null){
                            currentStoreNumberView.setSelected(false);
                        }
                        currentStoreNumberView = (TextView) v;
                        currentStoreNumberView.setSelected(true);
                        return;
                    }
                }

                if (position == 4){
                    //strings1.remove(4);
                    mFilterAdapter3.setStringList(moreList3);
                    //切换集合的时候将当前被点击的位置处的Item设为未选中状态，并将currentGoodNameTextView重置为空
                    if (currentStoreNumberView!=null){
                        currentStoreNumberView.setSelected(false);
                        currentStoreNumberView = null;
                    }
                    return;
                }

                if (position == moreList3.size()-1){
                    mFilterAdapter3.setStringList(lessList3);
                    //v.setSelected(false);
                    if (currentStoreNumberView!=null){
                        currentStoreNumberView.setSelected(false);
                        currentStoreNumberView = null;
                    }
                    return;
                }

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
                if (currentGoodNameTextView!=null)
                    currentGoodNameTextView.setSelected(false);
                if (currentStoreNumberView!=null)
                    currentStoreNumberView.setSelected(false);
                if (currentStoreClassTextView!=null)
                    currentStoreClassTextView.setSelected(false);
        }
    }
}