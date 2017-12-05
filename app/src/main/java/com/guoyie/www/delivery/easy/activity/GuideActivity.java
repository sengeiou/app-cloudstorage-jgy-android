package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;

public class GuideActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
      ActivityGuideBinding binding =  DataBindingUtil.setContentView(this,getLayoutId());

    }
}
