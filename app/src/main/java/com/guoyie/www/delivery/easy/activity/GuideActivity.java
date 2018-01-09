package com.guoyie.www.delivery.easy.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityGuideBinding;
import com.guoyie.www.delivery.easy.download.SpUtils;

import java.util.ArrayList;

import cn.bingoogolapple.bgabanner.BGABannerUtil;




public class GuideActivity extends BaseActivity {

    public static final String IS_GUIDE = "isGuide";  //引导页标记，true表示执行过引导页，false反之
    private ActivityGuideBinding mBinding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initPresenter() {

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        //沉浸式状态栏
        initStatusBar(true);
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());

        final ArrayList<View> views = new ArrayList<>();

        views.add(BGABannerUtil.getItemImageView(this,R.mipmap.guide01));
        views.add(BGABannerUtil.getItemImageView(this,R.mipmap.guide02));
        views.add(BGABannerUtil.getItemImageView(this,R.mipmap.guide03));

        //隐藏圆点指示器
        mBinding.bgaGuide.hideGuide();
        mBinding.bgaGuide.setData(views);
        //滑动状态监听，判断是否该显示“去登陆”按钮
        mBinding.bgaGuide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==views.size()-1){
                    mBinding.btGotologin.setVisibility(View.VISIBLE);
                }else {
                    mBinding.btGotologin.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //跳转到登录页面
    public void goToLogin(View view) {
        //设置引导页标记
        SpUtils sp = SpUtils.getInstance(this);
        sp.putBoolean(IS_GUIDE,true);

        startAct(LoginActivity.class);
        finish();
    }
}
