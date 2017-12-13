package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.InterListAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityInterorderBinding;
import com.guoyie.www.delivery.easy.entity.TabEntity;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/6
 */
public class InterOrderActivity extends BaseActivity implements View.OnClickListener, InterListAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, NRecyclerView.OnLoadMoreListener {
    private ImageView                 mLeft_back;
    private TextView                  mTv_title;
    private ActivityInterorderBinding binding;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String                     tabTitles[]  = new String[]{"全部", "待审核(3)","未通过","入库中(3)","已完成"};
    private ImageView mIv_search;
    //处理五情况来记录的type，和每页的情况判断情况

    private List<String>  list1;//网络获取数据保存,全部的数据
    private List<String>  list2;//网络获取数据保存,待审核的数据
    private List<String>  list3;//网络获取数据保存,待审核的数据
    private List<String>  list4;//网络获取数据保存,待审核的数据
    private List<String>  list5;//网络获取数据保存,待审核的数据

    private int type = 1;//1是未读，2是已读

    private int page1 = 1, page2 = 1,page3 = 1,page4 = 1,page5= 1;//全部, 待审核(3),未通过,入库中(3),"已完成
    private InterListAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_interorder;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mLeft_back.setOnClickListener(this);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("入库单管理");
        mIv_search = (ImageView) getView(R.id.iv_search);
        mIv_search.setVisibility(View.VISIBLE);
        mIv_search.setOnClickListener(this);
        initTab();
        initRecycleView();

    }

    private void initRecycleView() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i+"");
            list2.add(i+"");
            list3.add(i+"");
            list4.add(i+"");
            list5.add(i+"");
        }

        adapter = new InterListAdapter(mContext);
        adapter.setData(list1);
        adapter.setOnItemClickListener(this);
        binding.swipeRefresh.setOnRefreshListener(this);
        binding.nrecycler.setOnLoadMoreListener(this);
        binding.nrecycler.setLoadMoreEnable(true);
        binding.nrecycler.setAdapter(adapter);
        binding.nrecycler.setErrorMessage("暂无消息提醒");

    }


    private void initTab() {
        for (int i = 0; i < tabTitles.length; i++) {
            mTabEntities.add(new TabEntity(tabTitles[i], 0, 0));
        }
        binding.tabLayout.setTabData(mTabEntities);

        //点击监听
        binding.tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                type=position+1;

                adapter.removeLoadMoreView();

                switch (type){
                    case 1:
                        if (list1.size()==0){
                            loadData(type,page1);
                        }else {
                             adapter.setData(list1);
                        }
                        break;
                    case 2:
                        if (list2.size()==0){
                            loadData(type,page2);
                        }else {
                            adapter.setData(list2);
                        }
                        break;
                    case 3:
                        if (list3.size()==0){
                            loadData(type,page3);
                        }else {
                            adapter.setData(list3);
                        }
                        break;
                    case 4:
                        if (list4.size()==0){
                            loadData(type,page4);
                        }else {
                            adapter.setData(list4);
                        }
                        break;
                    case 5:
                        if (list5.size()==0){
                            loadData(type,page5);
                        }else {
                            adapter.setData(list5);
                        }
                        break;
            }


            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void loadData(int type, int page1) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.iv_search:
                startAct(SeachActivity.class);
                break;
        }

    }

    @Override
    public void onItemClick(View itemView, int position) {

        startAct(InterDetailActivity.class);

    }

    @Override
    public void onRefresh() {
       binding.swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onLoadMore() {
     binding.nrecycler.stopLoadMore();
    }
}
