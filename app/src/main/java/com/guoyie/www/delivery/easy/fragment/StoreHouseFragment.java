package com.guoyie.www.delivery.easy.fragment;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.activity.StoreCapacityManagerActivity;
import com.guoyie.www.delivery.easy.activity.StoreManagerActivity;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.base.BaseFragment;
import com.guoyie.www.delivery.easy.contract.BusinessFragmentContract;
import com.guoyie.www.delivery.easy.databinding.FcStorehouseBinding;
import com.guoyie.www.delivery.easy.entity.Banner;
import com.guoyie.www.delivery.easy.entity.BannerData;
import com.guoyie.www.delivery.easy.model.BusinessFragmentModel;
import com.guoyie.www.delivery.easy.presenter.BusinessFragmentPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.fragment
 * email：774169396@qq.com
 * data：2017/12/4
 * 我的业务的fragment
 */
public class StoreHouseFragment extends BaseFragment<BusinessFragmentPresenter,BusinessFragmentModel> implements View.OnClickListener, BusinessFragmentContract.View {
    private ImageView           mLeft_back;
    private TextView            mTv_title;
    private FcStorehouseBinding mBinding;
    private TextView mTV_right;
    private RelativeLayout mRlStoreManager;
    private RelativeLayout mRlStoreCapacityManager;
    private List<String> imgs =new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fc_storehouse;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    protected void initView() {
        mBinding = DataBindingUtil.bind(rootView);
        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mLeft_back.setVisibility(View.GONE);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTV_right = (TextView) getView(R.id.tv_right);
        mTV_right.setVisibility(View.GONE);
        mTv_title.setText("我的仓储");

        mRlStoreManager = mBinding.rlStoreManager;
        mRlStoreCapacityManager = mBinding.rlStoreCapacityManager;

        mRlStoreManager.setOnClickListener(this);
        mRlStoreCapacityManager.setOnClickListener(this);
        mBinding.rlStorePandianManager.setOnClickListener(this);
        mBinding.rlClientStoreManager.setOnClickListener(this);
        mBinding.rlDetailTable.setOnClickListener(this);

        initBanner();
    }

    private void initBanner() {
        //请求轮播图
        String params= BlowfishTools.encrypt(HttpUtils.key,HttpUtils.GET_BANNER);
        mPresenter.requstBanner(params);
        mBinding.banner.setDelegate(new BGABanner.Delegate<CardView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, CardView itemView, String model, int position) {
                Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
            }
        });
        mBinding.banner.setAdapter(new BGABanner.Adapter<CardView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, CardView itemView, String model, int position) {
                SimpleDraweeView simpleDraweeView = itemView.findViewById(R.id.sdv_item_fresco_content);
                simpleDraweeView.setImageURI(Uri.parse(model));
            }
        });



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_store_manager:
                startAct(StoreManagerActivity.class);
                break;
            case R.id.rl_store_capacity_manager:
                startAct(StoreCapacityManagerActivity.class);
                break;
            case R.id.rl_store_pandian_manager:
                showToast("攻城狮正在开发中，敬请期待!");
                break;
            case R.id.rl_client_store_manager:
                showToast("攻城狮正在开发中，敬请期待!");
                break;
            case R.id.rl_detail_table:
                showToast("攻城狮正在开发中，敬请期待!");
                break;
        }
    }

    @Override
    public void returnBanner(BannerData data) {
        if (data.isOk()){
            List<Banner> banners = data.getData();
            for (Banner banner : banners) {
                imgs.add(banner.getAdpic());
            }
            mBinding.banner.setData(R.layout.item_fresco, imgs, null);
        }
    }

    @Override
    public void error(String data) {

    }
}
