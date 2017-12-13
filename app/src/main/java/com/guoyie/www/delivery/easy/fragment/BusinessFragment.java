package com.guoyie.www.delivery.easy.fragment;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.activity.InfoOrderActivity;
import com.guoyie.www.delivery.easy.activity.InterOrderActivity;
import com.guoyie.www.delivery.easy.activity.TransTormorderActivity;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseFragment;
import com.guoyie.www.delivery.easy.databinding.FcBusinessBinding;
import com.guoyie.www.delivery.easy.entity.BannerModel;

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
public class BusinessFragment extends BaseFragment implements View.OnClickListener {

    private ImageView         mLeft_back;
    private TextView          mTv_title;
    private FcBusinessBinding binding;

    @Override
    protected int getLayoutResource() {
        return R.layout.fc_business;

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

        binding = DataBindingUtil.bind(rootView);
        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mLeft_back.setVisibility(View.GONE);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("我的业务");



        initBanner();
        initBottom();



    }

    private void initBanner() {

        binding.banner.setDelegate(new BGABanner.Delegate<CardView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, CardView itemView, String model, int position) {
                Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
            }
        });
        binding.banner.setAdapter(new BGABanner.Adapter<CardView, String>() {
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
                binding.banner.setData(R.layout.item_fresco, bannerModel.imgs, null);
            }

            @Override
            public void onFailure(Call<BannerModel> call, Throwable t) {
                Toast.makeText(GApp.getInstance(), "网络数据加载失败", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initBottom() {
     //设置下面的四个按钮的点击事件
         binding.llInorder.setOnClickListener(this);
         binding.llOutorder.setOnClickListener(this);
         binding.llTransformorder.setOnClickListener(this);
         binding.llInfoorder.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_inorder:
                startAct(InterOrderActivity.class);
                break;
            case R.id.ll_outorder:
               startAct(InterOrderActivity.class);
                break;
            case R.id.ll_transformorder:
                startAct(TransTormorderActivity.class);
                break;
                case R.id.ll_infoorder:
                 startAct(InfoOrderActivity.class);
                break;

        }


    }
}
