package com.guoyie.www.delivery.easy.activity;



import android.content.Intent;
import android.databinding.DataBindingUtil;


import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityLoadingBinding;
import com.guoyie.www.delivery.easy.download.SpUtils;
import com.guoyie.www.delivery.easy.toast.T;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


public class LoadingActivity extends BaseActivity {

    private ActivityLoadingBinding mBinding;


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
        if (isGuide){
            skipMain(MainActivity.class);
        }else {
            skipGuide(GuideActivity.class);
        }


    }

    private void skipGuide(final Class<GuideActivity> guideActivityClass) {
        //执行淡入淡出动画
        Observable.timer(2000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).
                subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        startActivity(new Intent(LoadingActivity.this, guideActivityClass));
                        overridePendingTransition(R.anim.enter, R.anim.exit);
                        finish();
                    }
                });
    }

    private void skipMain(final Class<MainActivity> mainActivityClass) {
        //执行淡入淡出动画
        Observable.timer(2000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).
                subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        startActivity(new Intent(LoadingActivity.this, mainActivityClass));
                        overridePendingTransition(R.anim.enter, R.anim.exit);
                        finish();
                    }
                });
    }




}
