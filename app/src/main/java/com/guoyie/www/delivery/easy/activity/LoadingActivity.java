package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityLoadingBinding;
import com.guoyie.www.delivery.easy.download.SpUtils;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.retrofit.RxBus;
import com.guoyie.www.delivery.easy.util.Constant;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import static com.guoyie.www.delivery.easy.api.HttpUtils.OUT_LOGIN;
import static com.guoyie.www.delivery.easy.api.HttpUtils.USER_INFO;


public class LoadingActivity extends BaseActivity {

    private ActivityLoadingBinding mBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_loading;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        //判断是否进入过引导页，查看过引导页则直接进入主页
        SpUtils sp = SpUtils.getInstance(this);
        Boolean isGuide = sp.getBoolean("isGuide", false);
      //  Boolean isGuide = true;
        if (isGuide){
            //判断是否已经登录过，如果登录过直接进入MainActivity,否则LoginActivity
//            String userInfo = sp.getString(USER_INFO, OUT_LOGIN);  //退出登录时将值设为OUT_LOGIN即可实现退出登录
            UserInfoData userInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
            if (userInfoData!=null){
                skip(MainActivity.class);
                return;
            }
            skip(LoginActivity.class);
        }else {
            skip(GuideActivity.class);
        }
    }

    private void skip(final Class<? extends BaseActivity> activityClass) {
        //执行淡入淡出动画
        Observable.timer(2000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).
                subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        startActivity(new Intent(LoadingActivity.this, activityClass));
                        overridePendingTransition(R.anim.enter, R.anim.exit);
                        finish();
                    }
                });
    }

}
