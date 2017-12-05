package com.guoyie.www.delivery.easy.fragment;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseFragment;
import com.guoyie.www.delivery.easy.databinding.FcUsercenterBinding;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.fragment
 * email：774169396@qq.com
 * data：2017/12/4
 * 我的业务的fragment
 */
public class UserCenterFragment extends BaseFragment {
    private ImageView           mLeft_back;
    private TextView            mTv_title;
    private FcUsercenterBinding mBinding;
    @Override
    protected int getLayoutResource() {
        return R.layout.fc_usercenter;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mBinding = DataBindingUtil.bind(rootView);
        //处理左侧的箭头
        mLeft_back = (ImageView) getView(R.id.left_back);
        mLeft_back.setVisibility(View.GONE);
        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("用户中心");
    }
}
