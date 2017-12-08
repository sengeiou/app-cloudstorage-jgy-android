package com.guoyie.www.delivery.easy.activity;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityRegisterBinding;
import com.guoyie.www.delivery.easy.dialog.CustomDialog;
import com.guoyie.www.delivery.easy.toast.TPrompt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private ActivityRegisterBinding mBinding;
    private EditText mEtCompanyname;
    private EditText mEtContacts;
    private EditText mEtContactway;
    private EditText mEtTelephone;
    private EditText mEtQq;
    private EditText mEtEmail;
    private Button mBtCommit;
    private TextView mToolbarcancel;
    private TextView mToolbarcommit;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());

        mEtCompanyname = mBinding.etCompanyname;
        mEtContacts = mBinding.etContacts;
        mEtContactway = mBinding.etContactway;
        mEtTelephone = mBinding.etTelephone;
        mEtQq = mBinding.etQq;
        mEtEmail = mBinding.etEmail;
        mBtCommit = mBinding.btCommit;
        mToolbarcancel = mBinding.tvToolbarcancel;
        mToolbarcommit = mBinding.tvToolbarcommit;

        mEtCompanyname.addTextChangedListener(mTextWatcher);
        mEtContacts.addTextChangedListener(mTextWatcher);
        mEtContactway.addTextChangedListener(mTextWatcher);
        mEtTelephone.addTextChangedListener(mTextWatcher);
        mEtQq.addTextChangedListener(mTextWatcher);
        mEtEmail.addTextChangedListener(mTextWatcher);

        mBtCommit.setOnClickListener(this);
        mToolbarcommit.setOnClickListener(this);
        mToolbarcancel.setOnClickListener(this);



    }

    TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String companyName = mEtCompanyname.getText().toString().trim();
            String contacts = mEtCompanyname.getText().toString().trim();
            String mobilePhone = mEtContactway.getText().toString().trim();
            String telephone = mEtTelephone.getText().toString().trim();
            String qq = mEtQq.getText().toString().trim();
            String email = mEtEmail.getText().toString().trim();




            if (companyName.length()>100){
                new TPrompt(RegisterActivity.this).showToast("企业名称在100字符以内");
            }
            if (contacts.length()>50){
                new TPrompt(RegisterActivity.this).showToast("联系人名称在50字符以内");
            }
            if (mobilePhone.length()>11){
                new TPrompt(RegisterActivity.this).showToast("请输入11位手机号");
            }
            if (telephone.length()>20){
                new TPrompt(RegisterActivity.this).showToast("固定电话号码在20字符以内");
            }
            if (qq.length()>20){
                new TPrompt(RegisterActivity.this).showToast("QQ号在20字符以内");
            }
            if (email.length()>100){
                new TPrompt(RegisterActivity.this).showToast("邮箱长度在100字符以内");
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_commit:
                String telephone = mEtTelephone.getText().toString().trim();
                //正则匹配判断固定电话格式
                if (!TextUtils.isEmpty(telephone)){
                    String regex = "\\d{3}-\\d{3}-\\d{4}";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(telephone);
                    boolean b = matcher.find();
                    if (!b){
                        new TPrompt(RegisterActivity.this).showToast("请输入此格式号码 021-666-6666");
                    }
                }

                String companyName = mEtCompanyname.getText().toString().trim();
                String contacts = mEtCompanyname.getText().toString().trim();
                String mobilePhone = mEtContactway.getText().toString().trim();
                String qq = mEtQq.getText().toString().trim();
                String email = mEtEmail.getText().toString().trim();

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View view = LayoutInflater.from(this).inflate(R.layout.commit_dialog, null);
                builder.setView(view);
                final AlertDialog alertDialog = builder.create();
                //设置弹框布局参数
                Window window = alertDialog.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                TextView tvCompany = view.findViewById(R.id.tv_companyname);
                TextView tvContacts = view.findViewById(R.id.tv_contacts_value);
                TextView tvContactWay = view.findViewById(R.id.tv_contactway_value);
                TextView tvTelephone = view.findViewById(R.id.tv_telephone_value);
                TextView tvQQ = view.findViewById(R.id.tv_qq_value);
                TextView tvEmail = view.findViewById(R.id.tv_email_value);
                TextView tvCancel = view.findViewById(R.id.tv_cancel);
                TextView tvSure = view.findViewById(R.id.tv_sure);

                tvCompany.setText(companyName);
                tvContacts.setText(contacts);
                tvContactWay.setText(mobilePhone);
                tvTelephone.setText(telephone);
                tvQQ.setText(qq);
                tvEmail.setText(email);

                tvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                tvSure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: 2017/12/8 提交入驻信息
                    }
                });
                alertDialog.show();
                break;
            case R.id.tv_toolbarcancel:
                finish();
                break;
            case R.id.tv_toolbarcommit:
                // TODO: 2017/12/8  提交入驻信息
        }

    }

}
