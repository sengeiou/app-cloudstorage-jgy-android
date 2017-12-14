package com.guoyie.www.delivery.easy.activity;


import android.databinding.DataBindingUtil;
import android.support.v4.view.ViewPager;
import android.view.View;

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
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());

        final ArrayList<View> views = new ArrayList<>();

        views.add(BGABannerUtil.getItemImageView(this,R.mipmap.guide_1));
        views.add(BGABannerUtil.getItemImageView(this,R.mipmap.guide_2));
        views.add(BGABannerUtil.getItemImageView(this,R.mipmap.guide_3));

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
        sp.putBoolean(IS_GUIDE,false);

        startAct(LoginActivity.class);
        finish();
    }
}
