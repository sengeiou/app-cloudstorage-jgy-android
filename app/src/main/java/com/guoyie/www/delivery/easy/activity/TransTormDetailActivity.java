package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.TranssTockDetailContract;
import com.guoyie.www.delivery.easy.databinding.ActivityTranstomrdetalBinding;
import com.guoyie.www.delivery.easy.entity.TransstockDetail;
import com.guoyie.www.delivery.easy.entity.TransstockDetailData;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.TransstockDetailModel;
import com.guoyie.www.delivery.easy.presenter.TranssTockDetailPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;

import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/13
 */
public class TransTormDetailActivity extends BaseActivity<TranssTockDetailPresenter,TransstockDetailModel> implements View.OnClickListener, TranssTockDetailContract.View {
    private ImageView                  mLeft_back;
    private TextView                   mTv_title;
    private ActivityTranstomrdetalBinding binding;
    private UserInfoData mUserInfo;
    private TransstockDetail mDetail;

    @Override
    public int getLayoutId() {
        return R.layout.activity_transtomrdetal;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {

         binding= DataBindingUtil.setContentView(this,getLayoutId());

        mLeft_back = getView(R.id.left_back);
        binding.tvRefused.setOnClickListener(this);
        binding.tvAgree.setOnClickListener(this);
        mLeft_back.setOnClickListener(this);
        mTv_title = getView(R.id.tv_title);
        mTv_title.setText("货转单详情");
        //从上个页面传回来的数据
        mUserInfo = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        String id = getIntent().getStringExtra(Constant.TRANSSTOCK_ID);
        loadData(id);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.tv_refused:

                break;
            case R.id.tv_agree:
                break;

            case R.id.ll_ca_viewpath:
                if (mDetail!=null){
                    String ca_viewpath = mDetail.getCa_viewpath();
                    Bundle bundle=new Bundle();
                    bundle.putString(Constant.TRANSSTOCK_CA_ID,ca_viewpath);
                    startAct(CAActivity.class,bundle);
                }


                break;

        }



    }

    @Override
    public void returnTransstockDetailData(TransstockDetailData data) {
        if (data.isOk()){
            if (data.getData()!=null){
                mDetail = data.getData();
                initData(mDetail);
            }
        }

    }

    private void initData(TransstockDetail data) {
        String status=null;
        switch (data.getStatus()){
            case 4:
                status="待仓储审核";//待仓储审核
                binding.llAgreeRefused.setVisibility(View.VISIBLE);
                break;
            case 5:
                status="未通过";//未通过
                break;
            case 6:
                status="已完成";//已完成
                break;
        }
       binding.status.setText(status);//设置状态
       binding.createAt.setText(data.getCreate_at());//创建时间
        binding.transstockCustomerNo.setText(data.getTransstock_customer_no());//货转单号
        binding.shopSaleCompanyName.setText(data.getShop_sale_company_name());//转让方
        binding.saleContactName.setText(data.getSale_contact_name());//企业联系人
        binding.saleContact.setText(data.getSale_contact());// 联系方式
        binding.shopBuyCompanyName.setText(data.getShop_buy_company_name());//受让方
        binding.buyContactName.setText(data.getBuy_contact_name());//企业联系人
        binding.buyContact.setText(data.getBuy_contact());//联系方式
        //处理货转货物明细的集合
        initArray(data.getGoods());
        //处理货转单详细信息
        binding.buyFreeday.setText(data.getBuy_freeday()+"天");//免仓期
        binding.tvRmark.setText(data.getRemark());//备注
        //处理CA的点击后的数据
        binding.llCaViewpath.setOnClickListener(this);

    }

    private void initArray(List<TransstockDetail.GoodsBean> goods) {
        for (int i = 0; i < goods.size(); i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.goods_item, null, false);
            TextView  goods_name=  view.findViewById(R.id.goods_name);
            TextView  goods_nature=  view.findViewById(R.id.goods_nature);
            TextView  remark=  view.findViewById(R.id.remark);
            TransstockDetail.GoodsBean data = goods.get(i);
            goods_name.setText(data.getGoods_name()+" | "+data.getTrans_qty()+data.getGoods_unit());//品名
            goods_nature.setText(data.getGoods_nature());//货物的性质
            remark.setText("备注："+data.getRemark());//备注
            binding.gridLayout.addView(view);
        }
    }

    @Override
    public void error(String data) {

    }
    //请求数据的地方
    private void loadData(String id) {
        String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.TRANSSTOCK_DETAIL + "&id=" + id+ "&vendor_no=" + mUserInfo.getData().getInfo().getVendor_no());
        mPresenter.requstTransstockDetailData(params);

    }
}
