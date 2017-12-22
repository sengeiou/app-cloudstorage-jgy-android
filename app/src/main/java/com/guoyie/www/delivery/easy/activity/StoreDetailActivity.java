package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityStoreDetailBinding;
import com.guoyie.www.delivery.easy.util.Constant;

public class StoreDetailActivity extends BaseActivity implements View.OnClickListener {


    private ActivityStoreDetailBinding mBinding;
    private TextView mTv_title;
    private ImageView mIv_back;

    @Override
    public int getLayoutId() {
        return R.layout.activity_store_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());

        mTv_title = (TextView) getView(R.id.tv_title);
        mIv_back = (ImageView) getView(R.id.left_back);
        mTv_title.setText("储罐详情");
        mIv_back.setImageResource(R.mipmap.left_arrow);

        Intent intent = getIntent();
        int storeId = intent.getIntExtra(Constant.STORE_ID, -1);


        mIv_back.setOnClickListener(this);

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
