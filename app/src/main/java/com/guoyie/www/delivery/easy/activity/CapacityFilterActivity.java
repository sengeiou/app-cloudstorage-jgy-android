package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.FilterAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityCapacityFilterBinding;
import com.guoyie.www.delivery.easy.widget.recyclerview.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CapacityFilterActivity extends BaseActivity implements View.OnClickListener {

    private ActivityCapacityFilterBinding mBinding;
    private TextView mTV_title;
    private ImageView mIv_back;
    private RecyclerView mRvGoodsName;
    private RecyclerView mRvStoreNumber;
    private FilterAdapter mFilterAdapter1;
    private FilterAdapter mFilterAdapter3;

    public TextView currentGoodNameTextView;    //当前被选中的商品名
    public TextView currentStoreNumberView;    //当前被选中的储罐编号

    @Override
    public int getLayoutId() {
        return R.layout.activity_capacity_filter;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        mTV_title = (TextView) getView(R.id.tv_title);
        mIv_back = (ImageView) getView(R.id.left_back);
        mTV_title.setText("库容筛选");

        mIv_back.setOnClickListener(this);
        mBinding.btReset.setOnClickListener(this);
        mBinding.btSure.setOnClickListener(this);

        initRecyclerView();
        initData();
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
//---------------------------------------------------------------------------
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
//----------------------------------------------------------------------------
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

    private void initRecyclerView() {
        mRvGoodsName = mBinding.rvGoodsName;
        mRvStoreNumber = mBinding.rvStoreNumber;
        mRvGoodsName.setLayoutManager(new GridLayoutManager(this,3));
        mRvStoreNumber.setLayoutManager(new GridLayoutManager(this,3));

        SpaceItemDecoration itemDecoration = new SpaceItemDecoration(54,42,54,42);
        mRvGoodsName.addItemDecoration(itemDecoration);
        mRvStoreNumber.addItemDecoration(itemDecoration);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.bt_sure:
                // TODO: 2017/12/23 确定选择，筛选结果
                break;
            case R.id.bt_reset:
                if (currentGoodNameTextView!=null)
                    currentGoodNameTextView.setSelected(false);
                if (currentStoreNumberView!=null)
                    currentStoreNumberView.setSelected(false);
        }
    }
}
