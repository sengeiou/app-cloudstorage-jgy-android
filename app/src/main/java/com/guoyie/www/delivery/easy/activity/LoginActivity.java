package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.LoginContract;
import com.guoyie.www.delivery.easy.databinding.ActivityLoginBinding;
import com.guoyie.www.delivery.easy.download.SpUtils;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.LoginModel;
import com.guoyie.www.delivery.easy.presenter.LoginPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.widget.CustomEditText;
import com.guoyie.www.delivery.easy.widget.LoginOrRegisterProblemPopupWindow;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_NORMAL;
import static com.guoyie.www.delivery.easy.api.HttpUtils.USER_INFO;

public class LoginActivity extends BaseActivity<LoginPresenter,LoginModel> implements View.OnClickListener, LoginContract.View {


    private static final int REQUSET_CODE = 1;//打电话权限请求码
    private ActivityLoginBinding mBinding;
    private CustomEditText mEtUsername;
    private CustomEditText mEtPassword;
    private Button mBtLogin;
    private Button mLogin;
    private Button mRegister;
    private TextView mTvProblem;
    private LoginOrRegisterProblemPopupWindow mProblemPopupWindow;


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());

        mEtUsername = mBinding.etUsername;
        mEtPassword = mBinding.etPassword;
        mBtLogin = mBinding.btLogin;
        mLogin = mBinding.btLogin;
        mRegister = mBinding.btRegister;
        mTvProblem = mBinding.tvProblem;

        mEtUsername.addTextChangedListener(mUserNameWatcher);
        mEtPassword.addTextChangedListener(mPassWordWatcher);

        mEtPassword.setDrawableRightClickListenner(mDrawableRightClickListenner);

        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mTvProblem.setOnClickListener(this);
    }

    private String mUserName;
    private String mPassWord;
    TextWatcher mUserNameWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() == 0) {
                mEtUsername.setCompoundDrawables(null, null, null, null);
                mBtLogin.setEnabled(false);
            }
            if (s.length() != 0 && s.length() <= 50) {
                Drawable success = getResources().getDrawable(R.mipmap.success);
                success.setBounds(0, 0, (int) success.getIntrinsicWidth(), (int) success.getIntrinsicHeight());
                mEtUsername.setCompoundDrawables(null, null, success, null);
            }
            if (s.length() > 50) {
                Drawable success = getResources().getDrawable(R.mipmap.error);
                success.setBounds(0, 0, (int) success.getIntrinsicWidth(), (int) success.getIntrinsicHeight());
                mEtUsername.setCompoundDrawables(null, null, success, null);
                mBtLogin.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            mUserName = mEtUsername.getText().toString().trim();

            btEnable();
        }
    };

    TextWatcher mPassWordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mPassWord = mEtPassword.getText().toString().trim();

            btEnable();
        }
    };

    //设置登录按钮可否点击
    private void btEnable() {
        if (mUserName != null && mPassWord != null) {
            boolean canLogin = mUserName.length() > 0 && mUserName.length() <= 50 && mPassWord.length() > 0 && mPassWord.length() <= 64;

            mBtLogin.setEnabled(canLogin);
        }
    }

    private boolean isOpen = false;
    CustomEditText.DrawableRightClickListenner mDrawableRightClickListenner = new CustomEditText.DrawableRightClickListenner() {
        @Override
        public void onDrawableRightClickListenner(View view) {
            //点击小眼睛失去焦点，隐藏软键盘
            mEtPassword.clearFocus();
            //mEtPassword.setFocusable(false);
            if (isOpen){      //设为密码
                Drawable close = getResources().getDrawable(R.mipmap.closeeyes);
                close.setBounds(0, 0, (int) close.getIntrinsicWidth(), (int) close.getIntrinsicHeight());
                mEtPassword.setCompoundDrawables(null, null, close, null);

                mEtPassword.setInputType(TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                isOpen = false;

            }else {   //设为明文
                Drawable see = getResources().getDrawable(R.mipmap.see);
                see.setBounds(0, 0, (int) see.getIntrinsicWidth(), (int) see.getIntrinsicHeight());
                mEtPassword.setCompoundDrawables(null, null, see, null);

                mEtPassword.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_NORMAL );
                isOpen = true;

            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                String userName = mEtUsername.getText().toString().trim();
                String passWord = mEtPassword.getText().toString().trim();
                String parms = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.LOG_IN+"&username="+userName+"&password="+passWord);
                mPresenter.requestLoginData(parms);
                break;
            case R.id.bt_register:
                startAct(RegisterActivity.class);
                break;
            case R.id.tv_problem:
                if (mProblemPopupWindow==null){
                    View view = getLayoutInflater().inflate(R.layout.lrp_popupwindow_layout, null);
                    mProblemPopupWindow = new LoginOrRegisterProblemPopupWindow(this,mOnClickListener,view);
                }
                if (mProblemPopupWindow.isShowing()){
                    mProblemPopupWindow.dismiss();
                }
                mProblemPopupWindow.show();

        }
    }

    LoginOrRegisterProblemPopupWindow.OnClickListener mOnClickListener = new LoginOrRegisterProblemPopupWindow.OnClickListener() {
        @Override
        public void call() {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri data = Uri.parse("tel:" + "13155833297");
            intent.setData(data);
            startActivity(intent);
        }

        @Override
        public void cancel() {
            mProblemPopupWindow.dismiss();
        }
    };

    @Override
    public void returnInfoData(UserInfoData data) {
        if (data.isOk()){
            //缓存用户信息
            GApp.getInstance().saveObject(data, Constant.USER_INFO_CACHE);
            //缓存用户名密码
            SpUtils spUtils = SpUtils.getInstance(this);
            String userName = mEtUsername.getText().toString().trim();
            String passWord = mEtPassword.getText().toString().trim();
            spUtils.putString(USER_INFO,userName+"&"+passWord);
            finish();
            startAct(MainActivity.class);

        }else {
            showToast("用户名或密码错误，请重新输入");
        }
    }

    @Override
    public void eeror(String msg) {
        showToast(msg);
    }
}
