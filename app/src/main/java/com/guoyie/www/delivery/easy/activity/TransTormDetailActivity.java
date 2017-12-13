package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityTranstomrdetalBinding;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/13
 */
public class TransTormDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView                  mLeft_back;
    private TextView                   mTv_title;
    private ActivityTranstomrdetalBinding binding;
    @Override
    public int getLayoutId() {
        return R.layout.activity_transtomrdetal;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

         binding= DataBindingUtil.setContentView(this,getLayoutId());

        mLeft_back = (ImageView) getView(R.id.left_back);
        binding.tvRefused.setOnClickListener(this);
        binding.tvAgree.setOnClickListener(this);
        mLeft_back.setOnClickListener(this);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("货转单详情");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.tv_refused:
                //调到编辑详情页面

                break;
            case R.id.tv_agree:
                //调到订单编辑页面

                break;

        }



    }
}
