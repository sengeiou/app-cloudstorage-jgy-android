package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityLoginBinding;
import com.guoyie.www.delivery.easy.util.InputUtils;
import com.guoyie.www.delivery.easy.widget.CustomEditText;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_NORMAL;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private ActivityLoginBinding mBinding;
    private CustomEditText mEtUsername;
    private CustomEditText mEtPassword;
    private Button mBtLogin;
    private Button mLogin;


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());

        mEtUsername = mBinding.etUsername;
        mEtPassword = mBinding.etPassword;
        mBtLogin = mBinding.btLogin;
        mLogin = mBinding.btLogin;

        mEtUsername.addTextChangedListener(mUserNameWatcher);
        mEtPassword.addTextChangedListener(mPassWordWatcher);

        mEtPassword.setDrawableRightClickListenner(mDrawableRightClickListenner);

        mLogin.setOnClickListener(this);
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
                // TODO: 2017/12/6 判断是否有账号，有就登录，否则申请入驻
                startAct(MainActivity.class);
        }
    }
}
