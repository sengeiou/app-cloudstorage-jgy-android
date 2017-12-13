package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityInfoorederdetailBinding;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/13
 */
class InfoOrderDetailActivity  extends BaseActivity implements View.OnClickListener {
    private ImageView                     mLeft_back;
    private TextView                      mTv_title;
    private ActivityInfoorederdetailBinding binding;
    @Override
    public int getLayoutId() {
        return R.layout.activity_infoorederdetail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        binding= DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back = (ImageView) getView(R.id.left_back);
        mLeft_back = (ImageView) getView(R.id.left_back);
        mLeft_back.setOnClickListener(this);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("意向单详情");
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
