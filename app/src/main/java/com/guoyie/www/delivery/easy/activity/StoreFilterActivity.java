package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.FilterAdapter;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.StoreFilterContract;
import com.guoyie.www.delivery.easy.databinding.ActivityFilterBinding;
import com.guoyie.www.delivery.easy.entity.GoodsNameBean;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.entity.StoreTypeBean;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.StoreFilterModel;
import com.guoyie.www.delivery.easy.presenter.StoreFilterPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.recyclerview.SpaceItemDecoration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StoreFilterActivity extends BaseActivity<StoreFilterPresenter,StoreFilterModel> implements View.OnClickListener, StoreFilterContract.View {

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
    private UserInfoData mUserInfoData;

    private  List<GoodsNameBean.DataBean> DataBeanList1 = new ArrayList<>();//商品名数据源
    private  List<StoreTypeBean.DataBean> DataBeanList2 = new ArrayList<>();//储罐性质数据源
    private  List<StoreNumberBean.DataBean> DataBeanList3 = new ArrayList<>();//储罐号数据源


    @Override
    public int getLayoutId() {
        return R.layout.activity_filter;
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
        mTV_title.setText("储罐筛选");
        mIv_back.setOnClickListener(this);
        mBtReset = mBinding.btReset;
        mBtSure = mBinding.btSure;

        mBtReset.setOnClickListener(this);
        mBtSure.setOnClickListener(this);

        mUserInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if (mUserInfoData!=null){
            //请求储罐号
            String params1 = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.STORE_FILTER +
                    "&vendor_no=" + mUserInfoData.getData().getInfo().getVendor_no()+
            "&type=jar_no");
            mPresenter.requestStoreNumber(params1);
            //请求商品名
            String params2 = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.STORE_FILTER +
                    "&vendor_no=" + mUserInfoData.getData().getInfo().getVendor_no()+
                    "&type=goods_name");
            mPresenter.requestGoodsName(params2);
            //请求储罐性质
            String params3 = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.STORE_FILTER +
                    "&vendor_no=" + mUserInfoData.getData().getInfo().getVendor_no()+
                    "&type=jar_material");
            mPresenter.requestStoreType(params3);
        }
        initRecyclerView();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.bt_sure:
                // 跳转到FilterResultActivity，确定选择，筛选结果
                String goodsName;
                String storeNumber;
                String storeType;
                if (currentGoodNameTextView==null&&currentStoreNumberView==null&&currentStoreClassTextView==null){
                    showToast("请选择筛选条件");
                    return;
                }
                //带上筛选条件
                if (currentGoodNameTextView == null){
                    goodsName = "";
                }{
                    goodsName = currentGoodNameTextView.getText().toString().trim(); //商品名
                }
                if (currentStoreNumberView == null){
                    storeNumber = "";
                }else {
                    storeNumber = currentStoreNumberView.getText().toString().trim(); //储罐号
                }
                if (currentStoreClassTextView == null){
                    storeType = "";
                }else {
                    storeType = currentStoreClassTextView.getText().toString().trim(); //储罐类型
                }
                Bundle bundle = new Bundle();
                bundle.putString(Constant.GOODS_NAME,goodsName);
                bundle.putString(Constant.STORE_NUMBER,storeNumber);
                bundle.putString(Constant.STORE_TYPE,storeType);
                startAct(FilterResultActivity.class,bundle);
                break;
            case R.id.bt_reset:
                if (currentGoodNameTextView!=null){
                    currentGoodNameTextView.setSelected(false);
                    currentGoodNameTextView = null;
                }
                if (currentStoreNumberView!=null){
                    currentStoreNumberView.setSelected(false);
                    currentStoreNumberView = null;
                }
                if (currentStoreClassTextView!=null){
                    currentStoreClassTextView.setSelected(false);
                    currentStoreClassTextView = null;
                }

        }
    }
//------------------------------------实现自视图接口的方法----------------------------------
    @Override
    public void returnStoreNumber(StoreNumberBean storeNumberBean) {

        if (storeNumberBean.isOk()){
            DataBeanList3.addAll(storeNumberBean.getData());
            final List<StoreNumberBean.DataBean> moreList3 = new ArrayList<>();
            moreList3.addAll(DataBeanList3);
            StoreNumberBean.DataBean dataBeanMore = new StoreNumberBean.DataBean();
            dataBeanMore.setJar_no("收起更多");
            moreList3.add(dataBeanMore);

            final List<StoreNumberBean.DataBean> lessList3 = new ArrayList<>();
            if (DataBeanList3.size()>=4){  //避免索引越界
                lessList3.addAll(DataBeanList3.subList(0,4));
                StoreNumberBean.DataBean dataBeanLess = new StoreNumberBean.DataBean();
                dataBeanLess.setJar_no("更多选项");
                lessList3.add(dataBeanLess);
            }
            mFilterAdapter3 = new FilterAdapter();
            if (DataBeanList3.size()>4){

                mFilterAdapter3.setStringList(lessList3);
            }else {
                mFilterAdapter3.setStringList(DataBeanList3);
            }
            mRvStoreNumber.setAdapter(mFilterAdapter3);

            //------------------------------------------------------------------
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
        }else {
            showToast("网络错误");
        }

    }

    @Override
    public void returnGoodsName(GoodsNameBean goodsNameBean) {

        if (goodsNameBean.isOk()){

            DataBeanList1.addAll(goodsNameBean.getData());
            final List<GoodsNameBean.DataBean> moreList1 = new ArrayList<>();
            moreList1.addAll(DataBeanList1);
            GoodsNameBean.DataBean dataBeanMore = new GoodsNameBean.DataBean();
            dataBeanMore.setGoods_name("收起更多");
            moreList1.add(dataBeanMore);

            final List<GoodsNameBean.DataBean> lessList1 = new ArrayList<>();
            if (DataBeanList1.size()>=4){  //避免索引越界
                lessList1.addAll(DataBeanList1.subList(0,4));
                GoodsNameBean.DataBean dataBeanLess = new GoodsNameBean.DataBean();
                dataBeanLess.setGoods_name("更多选项");
                lessList1.add(dataBeanLess);
            }
            mFilterAdapter1 = new FilterAdapter();
            if (DataBeanList1.size()>4){

                mFilterAdapter1.setStringList(lessList1);
            }else {
                mFilterAdapter1.setStringList(DataBeanList1);
            }
            mRvGoodsName.setAdapter(mFilterAdapter1);

        //-----------------------------------------------------------------------------
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

    @Override
    public void returnStoreType(StoreTypeBean storeTypeBean) {
        if (storeTypeBean.isOk()){

            DataBeanList2.addAll(storeTypeBean.getData());
            final List<StoreTypeBean.DataBean> moreList2 = new ArrayList<>();
            moreList2.addAll(DataBeanList2);
            StoreTypeBean.DataBean dataBeanMore = new StoreTypeBean.DataBean();
            dataBeanMore.setJar_material("收起更多");
            moreList2.add(dataBeanMore);

            final List<StoreTypeBean.DataBean> lessList2 = new ArrayList<>();
            if (DataBeanList2.size()>=4){  //避免索引越界
                lessList2.addAll(DataBeanList2.subList(0,4));
                StoreTypeBean.DataBean dataBeanLess = new StoreTypeBean.DataBean();
                dataBeanLess.setJar_material("更多选项");
                lessList2.add(dataBeanLess);
            }
            mFilterAdapter2 = new FilterAdapter();
            if (DataBeanList2.size()>4){

                mFilterAdapter2.setStringList(lessList2);
            }else {
                mFilterAdapter2.setStringList(DataBeanList2);
            }
            mRvStoreClass.setAdapter(mFilterAdapter2);

            //-----------------------------------------------------------------

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
        }else {
            showToast("网络错误");
        }

    }

    @Override
    public void error(String msg) {
        showToast(msg);
    }
}
