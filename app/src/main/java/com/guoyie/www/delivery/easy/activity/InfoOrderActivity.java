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
import com.guoyie.www.delivery.easy.adapter.InfoOrderListAdapter;
import com.guoyie.www.delivery.easy.adapter.TrantosListAdapter;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.StoreAgeContract;
import com.guoyie.www.delivery.easy.databinding.ActivityInforederBinding;
import com.guoyie.www.delivery.easy.entity.Storage;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.entity.TabEntity;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.StoreAgeModel;
import com.guoyie.www.delivery.easy.presenter.StorAgePresenter;
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
public class InfoOrderActivity extends BaseActivity<StorAgePresenter,StoreAgeModel> implements View.OnClickListener, TrantosListAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, NRecyclerView.OnLoadMoreListener, InfoOrderListAdapter.OnItemClickListener, StoreAgeContract.View {
    private static  boolean IS_MORE = false;
    private ImageView mLeft_back;
    private TextView  mTv_title;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String                     tabTitles[]  = new String[]{"全部", "进行中","已结束"};
    private ImageView mIv_search;

    private int type = 1;//1是未读，2是已读

    private int page1 = 1, page2 = 1,page3 = 1;//全部, 进行中(3),已结束

    //处理五情况来记录的type，和每页的情况判断情况

    private List<Storage.ListBean>             list1;//网络获取数据保存,全部的数据
    private List<Storage.ListBean>             list2;//网络获取数据保存,待审核的数据
    private List<Storage.ListBean>             list3;//网络获取数据保存,待审核的数据

    private InfoOrderListAdapter     adapter;
    private ActivityInforederBinding binding;
    private UserInfoData mUserInfo;
    private String keywords="";

    @Override
    public int getLayoutId() {
        return R.layout.activity_inforeder;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);
    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        //处理左侧的箭头
        mLeft_back = getView(R.id.left_back);
        mLeft_back.setOnClickListener(this);
        mTv_title =  getView(R.id.tv_title);
        mTv_title.setText("意向单管理");
        mIv_search = getView(R.id.iv_search);
        mIv_search.setVisibility(View.VISIBLE);
        mIv_search.setOnClickListener(this);
        //取得用户的信息
        mUserInfo = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        keywords = getIntent().getStringExtra(Constant.KEYS_WORD);
        //  DebugUtil.debug("信息"+ mUserInfo.getData().getInfo().getVendor_no());
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
        //初始化数据
     //   onRefresh();


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


                }


            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void loadData(int type, int page) {
        String status="";
        switch (type){
            case 1:
                status="";
                break;
            case 2:
                status="1";
                break;
            case 3:
                status="-1";
                break;
        }

        String params= BlowfishTools.encrypt(HttpUtils.key,HttpUtils.INFO_STORAGE+"&vendor_no="+mUserInfo.getData().getInfo().getVendor_no()
                +"&vendor_province_code="+mUserInfo.getData().getInfo().getProvince_code()+"&vendor_city_code="+mUserInfo.getData().getInfo().getCity_code()
                + "&status=" + status + "&pageCurrent=" + page + "&pageSize=" + 10
                + "&goods_name=" + keywords);
            mPresenter.requstStorageData(params);

    }


    private void initRecycleView() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        adapter = new InfoOrderListAdapter(mContext);
        adapter.setOnItemClickListener(this);
        binding.swipeRefresh.setOnRefreshListener(this);
        binding.nrecycler.setOnLoadMoreListener(this);
        binding.nrecycler.setLoadMoreEnable(true);
        binding.nrecycler.setAdapter(adapter);



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
                bundle.putInt(Constant.SEACH_ID,4);
                startAct(SeachActivity.class,bundle);
                break;
        }

    }

    @Override
    public void onItemClick(View itemView, int position) {
        Storage.ListBean item = adapter.getItem(position);
        if (item!=null){
            Bundle bundle=new Bundle();
            bundle.putString(Constant.STORAGE_DETAIL_ID,item.getId());
            startAct(InfoOrderDetailActivity.class,bundle);
        }

    }

    @Override
    public void onRefresh() {


        IS_MORE=false;
        page1 = 1;
        page2 = 1;
        page3 = 1;
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

        }

        loadData(type, page);
    }



    @Override
    public void returnStoreAgeData(StorageData data) {
        if (data.isOk()){
            List<Storage.ListBean> list = data.getData().getList();
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

            }
            //处理导航上数据问题
            binding.tabLayout.getTitleView(1).setText("进行中(" + data.getData().getCount_1() + ")");
            if (IS_MORE) {
                binding.nrecycler.stopLoadMore();
            } else{
                binding.swipeRefresh.setRefreshing(false);
            }
            binding.nrecycler.setErrorMessage("暂无相关信息");
        }



        

    }

    @Override
    public void err_or(String msg) {
        //关闭下拉的进度条
        binding.swipeRefresh.setRefreshing(false);
        binding.nrecycler.setErrorMessage(msg);
        showToast(msg);
    }


    @Override
    protected void onResume() {
        super.onResume();
        onRefresh();
    }
}
