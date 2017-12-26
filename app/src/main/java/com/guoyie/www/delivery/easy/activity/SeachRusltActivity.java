package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.InfoOrderListAdapter;
import com.guoyie.www.delivery.easy.adapter.InterListAdapter;
import com.guoyie.www.delivery.easy.adapter.OuterListAdapter;
import com.guoyie.www.delivery.easy.adapter.TrantosListAdapter;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.SeachRustrlContracat;
import com.guoyie.www.delivery.easy.databinding.ActivitySeachrusltBinding;
import com.guoyie.www.delivery.easy.entity.InputOrderInfo;
import com.guoyie.www.delivery.easy.entity.InputOrderInfoData;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfo;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;
import com.guoyie.www.delivery.easy.entity.Storage;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.entity.Transstock;
import com.guoyie.www.delivery.easy.entity.TransstockData;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.SeachRusltModel;
import com.guoyie.www.delivery.easy.presenter.SeachRusltPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/12
 */
public class SeachRusltActivity extends BaseActivity<SeachRusltPresenter,SeachRusltModel> implements SeachRustrlContracat.View, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, NRecyclerView.OnLoadMoreListener, InterListAdapter.OnItemClickListener, OuterListAdapter.OnItemClickListener, TrantosListAdapter.OnItemClickListener, InfoOrderListAdapter.OnItemClickListener {

    private static  boolean IS_MORE = false;
    private ActivitySeachrusltBinding binding;
    private ImageView                          mLeft_back;
    private TextView                           mTv_title;
    private UserInfoData                       mUserInfo;
    private int                                page;
    private ArrayList<InputOrderInfo.ListBean> mList1;
    private ArrayList<OuterOrderInfo.ListBean> mList2;
    private ArrayList<Transstock.ListBean>     mList3;
    private ArrayList<Storage.ListBean>        mList4;
    private InterListAdapter                   adapter1;
    private OuterListAdapter                   adapter2;
    private TrantosListAdapter                 adapter3;
    private InfoOrderListAdapter               adapter4;
    private int type;
    private String keywords;

    @Override
    public int getLayoutId() {
        return R.layout.activity_seachruslt;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back =  getView(R.id.left_back);
        mLeft_back.setOnClickListener(this);
        mTv_title = getView(R.id.tv_title);
        mTv_title.setText("搜索结果");
        //拿到用户信息
        mUserInfo = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        //拿到需要的数据
        Intent intent = getIntent();
        type = intent.getIntExtra(Constant.SEACHSULT_ID, 0);
        keywords = intent.getStringExtra(Constant.KEYS_WORD);
        initRecycleView();
        //初始化数据
        onRefresh();


        loadData(page);


    }

    private void loadData(int page) {
        switch (type){
            case 1:
                String input = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.INTER_ORDER_LIST + "&vendor_no=" + mUserInfo.getData().getInfo().getVendor_no() + "&advance_searchtxt=" + keywords
                        + "&pageCurrent=" + page + "&pageSize=" + 10);
                mPresenter.requstInputOrderData(input);

                break;
            case 2:
                String outer = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.OUTER_ORDER_LIST + "&vendor_no=" + mUserInfo.getData().getInfo().getVendor_no() + "&advance_searchtxt=" + keywords
                        + "&pageCurrent=" + page + "&pageSize=" + 10 );
                mPresenter.requstOutorderData(outer);
                break;
            case 3:
                String trans = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.TRANSSTOCK_LSIT + "&vendor_no=" + mUserInfo.getData().getInfo().getVendor_no() +
                         "&pageCurrent=" + page + "&pageSize=" + 10+"&from=usercenter");
                mPresenter.requstTranssTockData(trans);
                break;
            case 4: String params= BlowfishTools.encrypt(HttpUtils.key,HttpUtils.INFO_STORAGE+"&vendor_no="+mUserInfo.getData().getInfo().getVendor_no()
                    +"&vendor_province_code="+mUserInfo.getData().getInfo().getProvince_code()+"&vendor_city_code="+mUserInfo.getData().getInfo().getCity_code()
                    + "&goods_name=" + keywords + "&pageCurrent=" + page + "&pageSize=" + 10  );
                mPresenter.requstStorageData(params);

                break;
        }
    }

    private void initRecycleView() {
        mList1 = new ArrayList<>();
        mList2 = new ArrayList<>();
        mList3 = new ArrayList<>();
        mList4 = new ArrayList<>();
        switch (type){
            case 1:
                if (adapter1==null)
                adapter1=new InterListAdapter(mContext);
                binding.nrecycler.setAdapter(adapter1);
                adapter1.setOnItemClickListener(this);
                break;


            case 2:
                if (adapter2==null)
                    adapter2=new OuterListAdapter(mContext);
                  binding.nrecycler.setAdapter(adapter2);
                  adapter2.setOnItemClickListener(this);
                break;
            case 3:
                if (adapter3==null)
                    adapter3=new TrantosListAdapter(mContext);
                binding.nrecycler.setAdapter(adapter3);
                adapter3.setOnItemClickListener(this);
                break;

            case 4:
                if (adapter4==null)
                    adapter4=new InfoOrderListAdapter(mContext);
                binding.nrecycler.setAdapter(adapter4);
                adapter4.setOnItemClickListener(this);
                break;
        }
        binding.swipeRefresh.setOnRefreshListener(this);
        binding.nrecycler.setOnLoadMoreListener(this);
        binding.nrecycler.setLoadMoreEnable(true);
        binding.nrecycler.setErrorMessage("暂无相关信息");
    }

    //入库列表的数据
    @Override
    public void returnInputOrderData(InputOrderInfoData data) {
        if (data.isOk()){
            List<InputOrderInfo.ListBean> list = data.getData().getList();
            mList1.addAll(list);
            adapter1.setData(mList1);
            if (list.size()>0)
                page++;


            if (IS_MORE) {
                binding.nrecycler.stopLoadMore();
            } else{

                binding.swipeRefresh.setRefreshing(false);
            }
        }



    }
     //出库列表的数据
    @Override
    public void returnOuterOrderData(OuterOrderInfoData data) {
        if (data.isOk()){
            List<OuterOrderInfo.ListBean> list = data.getData().getList();
            mList2.addAll(list);
            adapter2.setData(mList2);
            if (list.size()>0)
                page++;



            if (IS_MORE) {
                binding.nrecycler.stopLoadMore();
            } else{

                binding.swipeRefresh.setRefreshing(false);
            }
        }

    }
      //货转移的数据
    @Override
    public void returnTranssTockData(TransstockData data) {
        if (data.isOk()){
            List<Transstock.ListBean> list = data.getData().getList();
            mList3.addAll(list);
            adapter3.setData(mList3);
            if (list.size()>0)
                page++;



            if (IS_MORE) {
                binding.nrecycler.stopLoadMore();
            } else{

                binding.swipeRefresh.setRefreshing(false);
            }
        }

    }
    //意向单数据
    @Override
    public void returnStoreAgeData(StorageData data) {
        if (data.isOk()){
            List<Storage.ListBean> list = data.getData().getList();
            mList4.addAll(list);
            adapter4.setData(mList4);
            if (list.size()>0)
                page++;



            if (IS_MORE) {
                binding.nrecycler.stopLoadMore();
            } else{

                binding.swipeRefresh.setRefreshing(false);
            }
        }

    }

    @Override
    public void err_or(String data) {
        showToast(data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_back:
                finish();
                break;

        }
    }

    @Override
    public void onRefresh() {
        mList1.clear();
        mList2.clear();
        mList3.clear();
        mList4.clear();
        page=1;
        loadData(page);


    }

    @Override
    public void onLoadMore() {
        IS_MORE=true;
        loadData(page);

    }

    @Override
    public void onItemClick(View itemView, int position) {

    }
}
