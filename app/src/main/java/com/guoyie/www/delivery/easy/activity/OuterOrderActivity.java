package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.OuterListAdapter;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.OutOrderContract;
import com.guoyie.www.delivery.easy.databinding.ActivityOuterorderBinding;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfo;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;
import com.guoyie.www.delivery.easy.entity.TabEntity;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.OuterOderModel;
import com.guoyie.www.delivery.easy.presenter.OuterOrderPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.util.Tools;
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
public class OuterOrderActivity extends BaseActivity<OuterOrderPresenter,OuterOderModel> implements View.OnClickListener, OuterListAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, NRecyclerView.OnLoadMoreListener, OutOrderContract.View {
    private ImageView                 mLeft_back;
    private TextView                  mTv_title;
    private ActivityOuterorderBinding binding;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String                     tabTitles[]  = new String[]{"全部", "待审核","未通过","出库中","已完成"};
    private ImageView mIv_search;
    private boolean IS_MORE=false;
    //处理五情况来记录的type，和每页的情况判断情况
    private List<OuterOrderInfo.ListBean> list1;//网络获取数据保存,全部的数据
    private List<OuterOrderInfo.ListBean> list2;//网络获取数据保存,待审核的数据
    private List<OuterOrderInfo.ListBean> list3;//网络获取数据保存,待审核的数据
    private List<OuterOrderInfo.ListBean> list4;//网络获取数据保存,待审核的数据
    private List<OuterOrderInfo.ListBean> list5;//网络获取数据保存,待审核的数据
    private int type = 1;//1是未读，2是已读
    private int page1 = 1, page2 = 1,page3 = 1,page4 = 1,page5= 1;//全部, 待审核(3),未通过,入库中(3),"已完成
    private OuterListAdapter adapter;
    private UserInfoData     mUserInfo;
    private String keywords="";

    @Override
    public int getLayoutId() {
        return R.layout.activity_outerorder;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        //处理左侧的箭头
        mLeft_back =  getView(R.id.left_back);
        mLeft_back.setOnClickListener(this);
        mTv_title = getView(R.id.tv_title);
        mTv_title.setText("出库单管理");
        mIv_search = getView(R.id.iv_search);
        mIv_search.setVisibility(View.VISIBLE);
        mIv_search.setOnClickListener(this);

        //取得用户的信息
        mUserInfo = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        keywords = getIntent().getStringExtra(Constant.KEYS_WORD);
        //处理搜索的逻辑
        if (!Tools.isNull(keywords)){
            mTv_title.setText("搜索结果");
            mIv_search.setVisibility(View.GONE);
            binding.tabLayout.setVisibility(View.GONE);
        }else {
            keywords="";
        }

        initTab();
        initRecycleView();
      //  onRefresh();

    }

    private void initRecycleView() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();

        adapter = new OuterListAdapter(mContext);
        adapter.setOnItemClickListener(this);
        binding.swipeRefresh.setOnRefreshListener(this);
        binding.nrecycler.setOnLoadMoreListener(this);
        binding.nrecycler.setLoadMoreEnable(true);
        binding.nrecycler.setAdapter(adapter);


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
    //加载数据的
    private void loadData(int type, int page) {
        //status （1.待填写,2.待仓储审核,3.仓审驳回,4.出库执行中,5.已完成,6.已取消）removestatus=true
        String removestatus="";
        String status="";
        switch (type){
            case 1:
                removestatus="true";
                break;
            case 2:
                status="2";
                break;
            case 3:
                status="3";
                break;
            case 4:
                status="4";
                break;
            case 5:
                status="5";
                break;
        }

        String params1 = HttpUtils.OUTER_ORDER_LIST + "&vendor_no=" + mUserInfo.getData().getInfo().getVendor_no()
                + "&pageCurrent=" + page + "&pageSize=" + 10 + "&keyword1s=" + keywords;
        String  params="";
        if (type!=1){
            params= BlowfishTools.encrypt(HttpUtils.key,params1+ "&status=" + status);
        }else {
            params=BlowfishTools.encrypt(HttpUtils.key,params1+ "&removestatus=" + removestatus);
        }
        mPresenter.requstOutorderData(params);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.iv_search:
                //传递搜索时候 的标志
                Bundle bundle=new Bundle();
                bundle.putInt(Constant.SEACH_ID,2);
                startAct(SeachActivity.class,bundle);
                break;
        }

    }

    @Override
    public void onItemClick(View itemView, int position) {
        OuterOrderInfo.ListBean item = adapter.getItem(position);
        if (item!=null){
            Bundle bundle=new Bundle();
            bundle.putString(Constant.OUTER_ORDER_ID,item.getId());
            startAct(OuterDetailActivity.class,bundle);
        }

    }

    @Override
    public void onRefresh() {
        IS_MORE=false;
        page1 = 1;
        page2 = 1;
        page3 = 1;
        page4 = 1;
        page5 = 1;
        switch (type){
            case 1:
                list1.clear();
                break;
            case 2:
                list2.clear();
                break;
            case 3:
                list3.clear();
                break;
            case 4:
                list4.clear();
                break;
            case 5:
                list5.clear();
                break;
        }

        loadData(type, 1);
        binding.swipeRefresh.setRefreshing(true);
    }

    @Override
    public void onLoadMore() {
        IS_MORE=true;
        int page=0;
        switch (type){
            case 1:
                page=page1;
                break;
            case 2:
                page=page2;
                break;
            case 3:
                page=page3;
                break;
            case 4:
                page=page4;
                break;
            case 5:
                page=page5;
                break;
        }

        loadData(type, page);
    }



    //返回更多数据的地方
    @Override
    public void returnOuterOrderData(OuterOrderInfoData data) {
        if (data.isOk()) {
            List<OuterOrderInfo.ListBean> list = data.getData().getList();
            switch (type) {
                case 1:
                    list1.addAll(list);
                    adapter.setData(list1);
                    if (list.size()>0)
                        page1++;
                    break;

                case 2:
                    list2.addAll(list);
                    adapter.setData(list2);
                    if (list.size()>0)
                        page2++;
                    break;
                case 3:
                    list3.addAll(list);
                    adapter.setData(list3);
                    if (list.size()>0)
                        page3++;
                    break;
                case 4:
                    list4.addAll(list);
                    adapter.setData(list4);
                    if (list.size()>0)
                        page4++;
                    break;
                case 5:
                    list5.addAll(list);
                    adapter.setData(list5);
                    if (list.size()>0)
                        page5++;
                    break;
            }
            //处理导航上数据问题
            binding.tabLayout.getTitleView(1).setText("待审核(" + data.getData().getCount_2() + ")");
            binding.tabLayout.getTitleView(3).setText("出库中(" + data.getData().getCount_4() + ")");

            if (IS_MORE) {
                binding.nrecycler.stopLoadMore();
            } else{

                binding.swipeRefresh.setRefreshing(false);
            }


            binding.nrecycler.setErrorMessage("暂无相关出库单");

        }
    }

    @Override
    public void error(String msg) {
        binding.swipeRefresh.setRefreshing(false);
        binding.nrecycler.setErrorMessage(msg);
        showToast(msg);
    }


    @Override
    protected void onResume() {
        super.onResume();
        onRefresh();//刷新数据
    }
}


