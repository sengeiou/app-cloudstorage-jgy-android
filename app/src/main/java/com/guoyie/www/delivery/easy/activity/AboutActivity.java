package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityAboutBinding;

public class AboutActivity extends BaseActivity implements View.OnClickListener {
    private ActivityAboutBinding mBinding;
    private ImageView leftBack;
    private TextView title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        mBinding = DataBindingUtil.setContentView(this,getLayoutId());
        //处理左侧的箭头
        leftBack = (ImageView) getView(R.id.left_back);
        title = (TextView) getView(R.id.tv_title);
        title.setText("关于交割易");

        leftBack.setOnClickListener(this);
        // TODO: 2018/1/8  获取版本号，点击检查更新
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
