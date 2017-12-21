package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityUserBasicInfoBinding;
import com.guoyie.www.delivery.easy.entity.UserInfo;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.util.Constant;

import java.io.Serializable;

public class UserBasicInfoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView           mLeft_back;
    private TextView            mTv_title;
    private ActivityUserBasicInfoBinding mBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_basic_info;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("基本信息");

        UserInfoData userInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if (userInfoData!=null){
            UserInfo userInfo = userInfoData.getData();
            Glide.with(this).load(userInfo.getAvatar()).into(mBinding.uerIcon);
            mBinding.tvAccountName.setText(userInfo.getLoginname());
            mBinding.tvUserName.setText(userInfo.getRealname());
            mBinding.tvMobilephone.setText(userInfo.getMobile());
            //mBinding.tvTelephone.setText(userInfo.);
            mBinding.tvServiceName.setText(userInfo.getInfo().getVendor_name());
        }
        mLeft_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_back:
                finish();
                break;
        }
    }
}
