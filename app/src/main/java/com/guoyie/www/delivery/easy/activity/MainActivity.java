package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentTransaction;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityMainBinding;
import com.guoyie.www.delivery.easy.entity.TabEntity;
import com.guoyie.www.delivery.easy.fragment.BusinessFragment;
import com.guoyie.www.delivery.easy.fragment.StoreHouseFragment;
import com.guoyie.www.delivery.easy.fragment.UserCenterFragment;

import java.util.ArrayList;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：www.guoyie.com.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/11/27 
 */

public class MainActivity extends BaseActivity {
    private String[]  mTitles = {"我的业务", "我的仓储", "用户中心"};
    private int[]  mIconUnselectIds = {R.mipmap.home,  R.mipmap.comment, R.mipmap.user};
    private int[]  mIconSelectIds   = {R.mipmap.home_passed,  R.mipmap.comment_press, R.mipmap.user_pressed};
    private ArrayList<CustomTabEntity> mTabEntities     = new ArrayList<>();
    private ActivityMainBinding mMainBinding;
    private BusinessFragment bsinessFragment;//我的业务的fragment
    private StoreHouseFragment houseFragment;//我的仓储
    private UserCenterFragment userFragment;//用户中心
    private int currentTabIndex=0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mMainBinding = DataBindingUtil.setContentView(this, getLayoutId());
        initTab();
        switchTo(0);
    }


    private void switchTo(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (bsinessFragment != null) {
            fragmentTransaction.hide(bsinessFragment);
        }

        if (houseFragment != null) {
            fragmentTransaction.hide(houseFragment);
        }
        if (userFragment != null) {
            fragmentTransaction.hide(userFragment);
        }

        switch (position) {
            case 0:
                if (bsinessFragment == null) {
                    bsinessFragment = new BusinessFragment();
                    fragmentTransaction.add(R.id.fl_body, bsinessFragment);
                }
                fragmentTransaction.show(bsinessFragment);

                break;
            case 1:
                if (houseFragment == null) {
                   houseFragment = new StoreHouseFragment();
                    fragmentTransaction.add(R.id.fl_body, houseFragment);
                }
                fragmentTransaction.show(houseFragment);
                break;
            case 2:
                if (userFragment == null) {
                    userFragment = new UserCenterFragment();
                    fragmentTransaction.add(R.id.fl_body, userFragment);
                }
                fragmentTransaction.show(userFragment);

                break;
        }



        //切换的的动画
        obtainFragmentTransaction(position ,fragmentTransaction);
        fragmentTransaction.commit();
        mMainBinding.tabLayout.setCurrentTab(position);
        //让当前的位置来记录下来
        currentTabIndex=position;
    }

    private void obtainFragmentTransaction(int index ,FragmentTransaction ft) {
        // 设置切换动画,如果当前项不是选中项就启动动画切换
        if (index > currentTabIndex) {
            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
        } else {
            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
        }
    }



    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mMainBinding.tabLayout.setTabData(mTabEntities);
        mMainBinding.tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switchTo(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }
}
