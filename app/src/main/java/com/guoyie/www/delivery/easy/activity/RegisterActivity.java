package com.guoyie.www.delivery.easy.activity;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityRegisterBinding;
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

        mEtCompanyname.addTextChangedListener(mTextWatcher);
        mEtContacts.addTextChangedListener(mTextWatcher);
        mEtContactway.addTextChangedListener(mTextWatcher);
        mEtTelephone.addTextChangedListener(mTextWatcher);
        mEtQq.addTextChangedListener(mTextWatcher);
        mEtEmail.addTextChangedListener(mTextWatcher);

        mBtCommit.setOnClickListener(this);



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
        // TODO: 2017/12/7 弹框提示

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setView(getLayoutInflater().inflate(R.layout.commit_dialog,null));
//        builder.create().show();
    }
}
