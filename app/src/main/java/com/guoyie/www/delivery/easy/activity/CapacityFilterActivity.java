package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.FilterAdapter;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.CapacityFilterContract;
import com.guoyie.www.delivery.easy.databinding.ActivityCapacityFilterBinding;
import com.guoyie.www.delivery.easy.entity.CapacityGoodsNameBean;
import com.guoyie.www.delivery.easy.entity.CapacityStoreNumberBean;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.CapacityFilterModel;
import com.guoyie.www.delivery.easy.presenter.CapacityFilterPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.recyclerview.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CapacityFilterActivity extends BaseActivity<CapacityFilterPresenter,CapacityFilterModel> implements View.OnClickListener, CapacityFilterContract.View {

    private ActivityCapacityFilterBinding mBinding;
    private TextView mTV_title;
    private ImageView mIv_back;
    private RecyclerView mRvGoodsName;
    private RecyclerView mRvStoreNumber;
    private FilterAdapter mFilterAdapter1;
    private FilterAdapter mFilterAdapter3;

    public TextView currentGoodNameTextView;    //当前被选中的商品名
    public TextView currentStoreNumberView;    //当前被选中的储罐编号
    private UserInfoData mUserInfoData;
    private List<CapacityGoodsNameBean.DataBean> mDataBeanList1 = new ArrayList<>();  //商品名数据源
    private List<CapacityStoreNumberBean.DataBean> mDataBeanList3 = new ArrayList<>();  //储罐号数据源

    @Override
    public int getLayoutId() {
        return R.layout.activity_capacity_filter;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);
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

        mUserInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if (mUserInfoData!=null){
            String parms = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.CAPACITY_FILTER_GOODS_NAME+"&vendor_no="
                    +mUserInfoData.getData().getInfo().getVendor_no());
            mPresenter.requestCapacityGoodsName(parms);

            String parms1 = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.CAPACITY_FILTER_STORE_NUMBER+"&vendor_no="
                    +mUserInfoData.getData().getInfo().getVendor_no());
            mPresenter.requestStoreNumber(parms1);
        }
        initRecyclerView();
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

    //返回商品名
    @Override
    public void returnCapacityGoodsName(CapacityGoodsNameBean capacityGoodsNameBean) {
        if (capacityGoodsNameBean.isOk()){
            mDataBeanList1.addAll(capacityGoodsNameBean.getData());

            final List<CapacityGoodsNameBean.DataBean> moreList1 = new ArrayList<>();
            moreList1.addAll(mDataBeanList1);
            CapacityGoodsNameBean.DataBean dataBeanMore = new CapacityGoodsNameBean.DataBean();
            dataBeanMore.setGoods_name("收起更多");
            moreList1.add(dataBeanMore);

            final List<CapacityGoodsNameBean.DataBean> lessList1 = new ArrayList<>();
            if (mDataBeanList1.size()>=4){  //避免索引越界
                lessList1.addAll(mDataBeanList1.subList(0,4));
                CapacityGoodsNameBean.DataBean dataBeanLess = new CapacityGoodsNameBean.DataBean();
                dataBeanLess.setGoods_name("更多选项");
                lessList1.add(dataBeanLess);
            }
            mFilterAdapter1 = new FilterAdapter();
            if (moreList1.size()>4){

                mFilterAdapter1.setStringList(lessList1);
            }else {
                mFilterAdapter1.setStringList(mDataBeanList1);
            }
            mRvGoodsName.setAdapter(mFilterAdapter1);
//---------------------------------------------------------------------------

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

        }else {
            showToast("网络错误");
        }
    }
    //返回储罐号
    @Override
    public void returnStoreNumber(CapacityStoreNumberBean capacityStoreNumberBean) {
        if (capacityStoreNumberBean.isOk()){

            mDataBeanList3.addAll(capacityStoreNumberBean.getData());
            final List<CapacityStoreNumberBean.DataBean> moreList3 = new ArrayList<>();
            moreList3.addAll(mDataBeanList3);
            CapacityStoreNumberBean.DataBean dataBeanMore = new CapacityStoreNumberBean.DataBean();
            dataBeanMore.setStock_no("收起更多");
            moreList3.add(dataBeanMore);

            final List<CapacityStoreNumberBean.DataBean> lessList3 = new ArrayList<>();
            if (mDataBeanList3.size()>=4){  //避免索引越界
                lessList3.addAll(mDataBeanList3.subList(0,4));
                CapacityStoreNumberBean.DataBean dataBeanLess = new CapacityStoreNumberBean.DataBean();
                dataBeanLess.setStock_no("更多选项");
                lessList3.add(dataBeanLess);
            }
            mFilterAdapter3 = new FilterAdapter();
            if (mDataBeanList3.size()>4){

                mFilterAdapter3.setStringList(lessList3);
            }else {
                mFilterAdapter3.setStringList(mDataBeanList3);
            }
            mRvStoreNumber.setAdapter(mFilterAdapter3);

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
        } else {
            showToast("网络错误");
        }
    }

    @Override
    public void error(String msg) {
        showToast(msg);
    }
}
