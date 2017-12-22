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
import com.guoyie.www.delivery.easy.adapter.StoreManagerAdapter;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseFragment;
import com.guoyie.www.delivery.easy.databinding.FcStorehouseBinding;
import com.guoyie.www.delivery.easy.entity.BannerModel;
import com.guoyie.www.delivery.easy.widget.recyclerview.NRecyclerView;

import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.fragment
 * email：774169396@qq.com
 * data：2017/12/4
 * 我的业务的fragment
 */
public class StoreHouseFragment extends BaseFragment implements View.OnClickListener {
    private ImageView           mLeft_back;
    private TextView            mTv_title;
    private FcStorehouseBinding mBinding;
    private TextView mTV_right;
    private RelativeLayout mRlStoreManager;
    private RelativeLayout mRlStoreCapacityManager;

    @Override
    protected int getLayoutResource() {
        return R.layout.fc_storehouse;
    }

    @Override
    public void initPresenter() {

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

        initBanner();
    }

    private void initBanner() {
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

        GApp.getInstance().getEngine().fetchItemsWithItemCount(3).enqueue(new Callback<BannerModel>() {
            @Override
            public void onResponse(Call<BannerModel> call, Response<BannerModel> response) {
                BannerModel bannerModel = response.body();
                //                mContentBanner.setData(R.layout.item_fresco, bannerModel.imgs, bannerModel.tips);
                mBinding.banner.setData(R.layout.item_fresco, bannerModel.imgs, null);
            }

            @Override
            public void onFailure(Call<BannerModel> call, Throwable t) {
                Toast.makeText(GApp.getInstance(), "网络数据加载失败", Toast.LENGTH_SHORT).show();
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
        }
    }
}
