package com.guoyie.www.delivery.easy.fragment;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.activity.UserBasicInfoActivity;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseFragment;
import com.guoyie.www.delivery.easy.databinding.FcUsercenterBinding;
import com.guoyie.www.delivery.easy.entity.UserInfo;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.MyImageView;

import java.io.Serializable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.fragment
 * email：774169396@qq.com
 * data：2017/12/4
 * 我的业务的fragment
 */
public class UserCenterFragment extends BaseFragment implements View.OnClickListener {
    private ImageView           mLeft_back;
    private TextView            mTv_title;
    private FcUsercenterBinding mBinding;
    private MyImageView mIcon;
    private RelativeLayout mLlAbout;

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

        mIcon = mBinding.uerIcon;
        mLlAbout = mBinding.llAbout;

        UserInfoData userInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if(userInfoData!=null){
            UserInfo data = userInfoData.getData();
            Glide.with(this).load(data.getAvatar()).into(mBinding.uerIcon);
            mBinding.tvUser.setText(data.getLoginname());
            mBinding.tvServiceName.setText(data.getInfo().getVendor_name());
            int type = data.getType();
            String serviceDescription = "管理员";
            if (type==0){
                serviceDescription = "普通";
            }
            if (type==1){
                serviceDescription = "管理员";
            }
            mBinding.tvServiceDescription.setText(serviceDescription);
        }
        mIcon.setOnClickListener(this);
        mLlAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.uer_icon:
                startAct(UserBasicInfoActivity.class);
                break;
            case R.id.ll_about:
                Toast.makeText(getContext(),"收款方靠觉得你放假",Toast.LENGTH_SHORT).show();
        }
    }
}
