package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityGuideBinding;


public class GuideActivity extends BaseActivity {


    private ActivityGuideBinding mBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());

    }
}
