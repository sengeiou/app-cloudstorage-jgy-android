package com.guoyie.www.delivery.easy.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.activity.AboutActivity;
import com.guoyie.www.delivery.easy.activity.LoginActivity;
import com.guoyie.www.delivery.easy.activity.UserBasicInfoActivity;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseFragment;
import com.guoyie.www.delivery.easy.databinding.FcUsercenterBinding;
import com.guoyie.www.delivery.easy.dialog.CustomDialog;
import com.guoyie.www.delivery.easy.entity.UserInfo;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.MyImageView;

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
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.error(R.drawable.icon);
            Glide.with(this)
                    .load(data.getAvatar())
                    .apply(requestOptions)
                    .into(mIcon);
        }
        mIcon.setOnClickListener(this);//点击头像
        mLlAbout.setOnClickListener(this);//关于交割易
        mBinding.llContact.setOnClickListener(this);//联系客服
        mBinding.llLoginOut.setOnClickListener(this);//退出登录
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.uer_icon:  //点击头像
                startAct(UserBasicInfoActivity.class);
                break;
            case R.id.ll_about:  //关于交割易
                startAct(AboutActivity.class);
                break;
            case R.id.ll_contact: //联系客服
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + "400-072-7777");
                intent.setData(data);
                startActivity(intent);
                break;
            case R.id.ll_login_out: //退出登录

                final CustomDialog dialog = new CustomDialog(getContext(), GApp.screenWidth * 3 / 4, GApp.screenHeight / 4, R.layout.login_out_dialog_layout, R.style.Theme_dialog);
                dialog.show();
                TextView tvBack = dialog.findViewById(R.id.tv_back);
                TextView tvLoginout = dialog.findViewById(R.id.tv_login_out);
                tvBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                tvLoginout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            GApp.getInstance().deleteObject(Constant.USER_INFO_CACHE);
                            startAct(LoginActivity.class);
                            getActivity().finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });


        }
    }
}
