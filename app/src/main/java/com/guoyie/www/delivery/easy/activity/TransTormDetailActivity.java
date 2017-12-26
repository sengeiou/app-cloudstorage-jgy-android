package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.TranssTockDetailContract;
import com.guoyie.www.delivery.easy.databinding.ActivityTranstomrdetalBinding;
import com.guoyie.www.delivery.easy.dialog.CustomDialog;
import com.guoyie.www.delivery.easy.entity.TransstockDetail;
import com.guoyie.www.delivery.easy.entity.TransstockDetailData;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.TransstockDetailModel;
import com.guoyie.www.delivery.easy.presenter.TranssTockDetailPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;

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
                //处理不通过的逻辑
               showUpdateDialog(5,"确定拒绝本条申请？","");

                break;
            case R.id.tv_agree:
                showUpdateDialog(5,"确定通过本条申请？",mDetail.getTrans_qty());
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



    private void showUpdateDialog(final int status, String message, final String trans_qty) {
        final CustomDialog dialog = new CustomDialog(mContext, GApp.screenWidth * 3 / 4,
                GApp.screenHeight / 4, R.layout.wind_base_dialog_xml, R.style.Theme_dialog);
        Button btn_cancel =  dialog.findViewById(R.id.btn_cancel);
        Button btn_commit =  dialog.findViewById(R.id.btn_commit);
        TextView tv_title = dialog.findViewById(R.id.tv_title);
        TextView tv_content =  dialog.findViewById(R.id.tv_content);
        tv_title.setText("提示");
        tv_content.setText(message);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //走请求网络的接口
                String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.TRANSSTOCK_UPDATE + "&id" + mDetail.getId() + "&status=" + status + "&read_num=" + trans_qty);
                mPresenter.requstTransstockUpdata(params);
                dialog.dismiss();
            }
        });
        dialog.show();
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

    @Override
    public void returnTransstockUpdate(BaseResponse data) {



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

        //处理货转单详细信息
        binding.buyFreeday.setText(data.getBuy_freeday()+"天");//免仓期
        binding.tvRmark.setText(data.getRemark());//备注
        //处理CA的点击后的数据
        binding.llCaViewpath.setOnClickListener(this);


        //处理
        binding.goodsName.setText(data.getGoods_name()+" | "+data.getTrans_qty()+data.getGoods_unit());//品名
        binding.goodsNature.setText(data.getGoods_nature());//货物的性质
        binding.remark.setText("备注："+data.getRemark());//备注

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
