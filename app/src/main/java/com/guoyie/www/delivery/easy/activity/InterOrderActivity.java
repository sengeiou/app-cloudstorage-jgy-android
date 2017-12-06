package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityInterorderBinding;
import com.guoyie.www.delivery.easy.entity.TabEntity;

import java.util.ArrayList;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/6
 */
public class InterOrderActivity extends BaseActivity implements View.OnClickListener {
    private ImageView                 mLeft_back;
    private TextView                  mTv_title;
    private ActivityInterorderBinding binding;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String                     tabTitles[]  = new String[]{"全部", "待审核(3)","未通过","入库中(3)","已完成"};
    private ImageView mIv_search;

    @Override
    public int getLayoutId() {
        return R.layout.activity_interorder;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mLeft_back.setOnClickListener(this);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("入库单管理");
        mIv_search = (ImageView) getView(R.id.iv_search);
        mIv_search.setVisibility(View.VISIBLE);
        mIv_search.setOnClickListener(this);
        initTab();
    }



    private void initTab() {
        for (int i = 0; i < tabTitles.length; i++) {
            mTabEntities.add(new TabEntity(tabTitles[i], 0, 0));
        }
        binding.tabLayout.setTabData(mTabEntities);

        //点击监听
        binding.tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.iv_search:
                break;
        }

    }
}
