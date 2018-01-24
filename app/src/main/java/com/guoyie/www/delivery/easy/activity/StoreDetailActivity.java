package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.StoreDetailContract;
import com.guoyie.www.delivery.easy.databinding.ActivityStoreDetailBinding;
import com.guoyie.www.delivery.easy.entity.StoreDetailBean;
import com.guoyie.www.delivery.easy.model.StoreDetailModel;
import com.guoyie.www.delivery.easy.presenter.StoreDetailPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;

public class StoreDetailActivity extends BaseActivity<StoreDetailPresenter,StoreDetailModel> implements View.OnClickListener,StoreDetailContract.View{


    private ActivityStoreDetailBinding mBinding;
    private TextView mTv_title;
    private ImageView mIv_back;

    @Override
    public int getLayoutId() {
        return R.layout.activity_store_detail;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);
    }

    @Override
    public void initView() {
        mBinding = DataBindingUtil.setContentView(this,getLayoutId());

        mTv_title = (TextView) getView(R.id.tv_title);
        mIv_back = (ImageView) getView(R.id.left_back);
        mTv_title.setText("储罐详情");
        mIv_back.setImageResource(R.mipmap.left_arrow);

        Intent intent = getIntent();
        String storeId = intent.getStringExtra(Constant.STORE_ID);
        String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.STORE_DETAIL + "&varchar="+storeId );
        mPresenter.requestStoreDetail(params);

        mIv_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_back:
                finish();
                break;

        }
    }

    @Override
    public void returnStoreDetail(StoreDetailBean storeDetailBean) {
        if (storeDetailBean.isOk()){
            mBinding.tvStoreNumber.setText(storeDetailBean.getData().getJar_no());//储罐号
            mBinding.tvGoodsName.setText(storeDetailBean.getData().getGoods_name());//商品名
            mBinding.tvStoreCapacity.setText(storeDetailBean.getData().getStock()+"吨");//罐容
            mBinding.tvStoreType.setText(storeDetailBean.getData().getJar_type());//储罐性质
            mBinding.tvStoreMaterial.setText(storeDetailBean.getData().getJar_material());//储罐材质
        }else {
            showToast(storeDetailBean.getMsg());
        }
    }

    @Override
    public void error(String msg) {
        showToast(msg);
    }
}
