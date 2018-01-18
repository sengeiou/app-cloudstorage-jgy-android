package com.guoyie.www.delivery.easy.activity;

import android.app.AlertDialog;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.RegisterContract;
import com.guoyie.www.delivery.easy.databinding.ActivityRegisterBinding;
import com.guoyie.www.delivery.easy.dialog.CustomDialog;
import com.guoyie.www.delivery.easy.entity.RegisterData;
import com.guoyie.www.delivery.easy.model.RegisterModel;
import com.guoyie.www.delivery.easy.presenter.RegisterPresenter;
import com.guoyie.www.delivery.easy.toast.TPrompt;
import com.guoyie.www.delivery.easy.util.BlowfishTools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 服务商入驻
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter,RegisterModel> implements View.OnClickListener,RegisterContract.View {


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
        mPresenter.attachVM(this,mModel);
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
        //焦点监听
        mEtTelephone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String telephone = mEtTelephone.getText().toString().trim();
                if (!TextUtils.isEmpty(telephone)){
                    String regex1 = "^[0][1-9]{2,3}-[0-9]{5,10}$"; //带区号的固定电话
                    String regex2 = "^[1-9]{1}[0-9]{5,8}$"; //验证不带区号的固定电话

                    Pattern pattern1 = Pattern.compile(regex1);
                    Matcher matcher1 = pattern1.matcher(telephone);
                    Pattern pattern2 = Pattern.compile(regex2);
                    Matcher matcher2 = pattern2.matcher(telephone);
                    boolean b1 = matcher1.find();
                    boolean b2 = matcher2.find();
                    if (!b1&&!b2){
                        new TPrompt(RegisterActivity.this).showToast("请输入正确的固定电话");
                    }
                }
            }
        });

        mEtContactway.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String mobilePhone = mEtContactway.getText().toString().trim();
                if (!TextUtils.isEmpty(mobilePhone)){
                    String regex = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(mobilePhone);
                    boolean b = matcher.find();
                    if (!b){
                        new TPrompt(RegisterActivity.this).showToast("请输入正确的11位手机号码");
                    }

                }
            }
        });
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

            String companyName = mEtCompanyname.getText().toString().trim();
            String contacts = mEtContacts.getText().toString().trim();
            String mobilePhone = mEtContactway.getText().toString().trim();
            boolean canCommit = !TextUtils.isEmpty(companyName)&&!TextUtils.isEmpty(contacts)&&!TextUtils.isEmpty(mobilePhone);

            mBtCommit.setEnabled(canCommit);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_commit:
                commit();
                break;
            case R.id.tv_toolbarcancel:
                finish();
                break;
            case R.id.tv_toolbarcommit:
                String company = mEtCompanyname.getText().toString().trim();
                String contact = mEtContacts.getText().toString().trim();
                String mobile = mEtContactway.getText().toString().trim();

                boolean cannotCommit = TextUtils.isEmpty(company)||TextUtils.isEmpty(contact)||TextUtils.isEmpty(mobile);

                if (cannotCommit){
                    Toast.makeText(this,"请注意，红色星号处为必填项！",Toast.LENGTH_SHORT).show();
                    return;
                }

                commit();
        }

    }

    /**
     *
     * 提交入库信息
     */
    private void commit() {
        String telephone = mEtTelephone.getText().toString().trim();
        //正则匹配判断固定电话格式
        if (!TextUtils.isEmpty(telephone)){
            //String regex = "\\d{3,4}-\\d{7,8}";
            String regex1 = "^[0][1-9]{2,3}-[0-9]{5,10}$"; //带区号的固定电话
            String regex2 = "^[1-9]{1}[0-9]{5,8}$"; //验证不带区号的固定电话

            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(telephone);
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(telephone);
            boolean b1 = matcher1.find();
            boolean b2 = matcher2.find();
            if (!b1&&!b2){
                new TPrompt(RegisterActivity.this).showToast("请输入正确的固定电话");
            }
        }

        String companyName = mEtCompanyname.getText().toString().trim();
        String contacts = mEtContacts.getText().toString().trim();
        String mobilePhone = mEtContactway.getText().toString().trim();
        String qq = mEtQq.getText().toString().trim();
        String email = mEtEmail.getText().toString().trim();

        final CustomDialog dialog = new CustomDialog(mContext, GApp.screenWidth * 3 / 4,
                GApp.screenHeight *8/15 , R.layout.commit_dialog, R.style.Theme_dialog);

        TextView tvCompany = dialog.findViewById(R.id.tv_companyname);
        TextView tvContacts = dialog.findViewById(R.id.tv_contacts_value);
        TextView tvContactWay = dialog.findViewById(R.id.tv_contactway_value);
        TextView tvTelephone = dialog.findViewById(R.id.tv_telephone_value);
        TextView tvQQ = dialog.findViewById(R.id.tv_qq_value);
        TextView tvEmail = dialog.findViewById(R.id.tv_email_value);
        TextView tvCancel = dialog.findViewById(R.id.tv_cancel);
        TextView tvSure = dialog.findViewById(R.id.tv_sure);

        tvCompany.setText(companyName);
        tvContacts.setText(contacts);
        tvContactWay.setText(mobilePhone);
        tvTelephone.setText(telephone);
        tvQQ.setText(qq);
        tvEmail.setText(email);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 提交入驻信息
                String telephone = mEtTelephone.getText().toString().trim();
                String companyName = mEtCompanyname.getText().toString().trim();
                String contacts = mEtContacts.getText().toString().trim();
                String mobilePhone = mEtContactway.getText().toString().trim();
                String qq = mEtQq.getText().toString().trim();
                String email = mEtEmail.getText().toString().trim();

                String parms = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.RE_GISTER+"&vendor_name="+companyName+
                        "&vendor_mobile="+telephone+"&vendor_contract_name="+contacts+"&vendor_contract="+mobilePhone+
                        "&vendor_qq="+qq+"&vendor_email="+email+"&status=" +1+"&vendor_source="+1+"&vendor_type="+1);
                mPresenter.requestRegister(parms);
            }
        });
        dialog.show();
    }

    @Override
    public void returnRegisterData(RegisterData data) {

        if (data.isOk()){
            showToast("服务商已入驻，等待后台处理");
            finish();
        }else {
            showToast("请检查提交信息");
        }
    }

    @Override
    public void error(String msg) {
        showToast(msg);
    }
}
