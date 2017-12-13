package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityLoadingBinding;
import com.guoyie.www.delivery.easy.download.SpUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


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
        Boolean isGuide = sp.getBoolean("isGuide", true);
         isGuide=true;
        if (isGuide){
            skip(MainActivity.class);
        }else {
            skip(GuideActivity.class);
        }


        skip(MainActivity.class);
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
