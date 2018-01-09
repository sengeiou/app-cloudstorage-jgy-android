package com.guoyie.www.delivery.easy.fragment;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.activity.InfoOrderActivity;
import com.guoyie.www.delivery.easy.activity.InterOrderActivity;
import com.guoyie.www.delivery.easy.activity.OuterOrderActivity;
import com.guoyie.www.delivery.easy.activity.TransTormorderActivity;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseFragment;
import com.guoyie.www.delivery.easy.contract.BusinessFragmentContract;
import com.guoyie.www.delivery.easy.databinding.FcBusinessBinding;
import com.guoyie.www.delivery.easy.entity.Banner;
import com.guoyie.www.delivery.easy.entity.BannerData;
import com.guoyie.www.delivery.easy.entity.UserInfo;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.BusinessFragmentModel;
import com.guoyie.www.delivery.easy.presenter.BusinessFragmentPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;

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
public class BusinessFragment extends BaseFragment<BusinessFragmentPresenter,BusinessFragmentModel> implements View.OnClickListener, BusinessFragmentContract.View {

    private ImageView         mLeft_back;
    private TextView          mTv_title;
    private FcBusinessBinding binding;
    private List<String> imgs=new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fc_business;

    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    protected void initView() {

        binding = DataBindingUtil.bind(rootView);
        //处理左侧的箭头
        mLeft_back = getView(R.id.left_back);
        mLeft_back.setVisibility(View.GONE);
        mTv_title =  getView(R.id.tv_title);
        mTv_title.setText("我的业务");
        initBanner();
        initIcon();
        initBottom();



    }

    private void initIcon() {

        UserInfoData userInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if(userInfoData!=null){
            UserInfo data = userInfoData.getData();
           Glide.with(this)
                   .load(data.getAvatar())
                   .into(binding.imageview);//图像
            binding.tvCompanyname.setText(data.getInfo().getVendor_name());//公司名称


            int type = data.getType();
            String serviceDescription = "管理员";
            if (type==0){
                serviceDescription = "普通";
            }
            if (type==1){
                serviceDescription = "管理员";
            }
            binding.tvUserName.setText(data.getLoginname()+" | "+serviceDescription);//用户名和身份

        }
    }

    private void initBanner() {
        //请求轮播图
        String params= BlowfishTools.encrypt(HttpUtils.key,HttpUtils.GET_BANNER);
        mPresenter.requstBanner(params);

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
               startAct(OuterOrderActivity.class);
                break;
            case R.id.ll_transformorder:
                startAct(TransTormorderActivity.class);
                break;
                case R.id.ll_infoorder:
                 startAct(InfoOrderActivity.class);
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
          binding.banner.setData(R.layout.item_fresco, imgs, null);
        }else {//没有数据了
            showToast(data.getMsg());
        }

    }

    @Override
    public void error(String data) {
        showToast(data);

    }
}
