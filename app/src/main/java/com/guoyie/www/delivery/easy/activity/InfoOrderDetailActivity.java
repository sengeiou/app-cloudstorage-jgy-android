package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.StoreAgeDetaliContract;
import com.guoyie.www.delivery.easy.databinding.ActivityInfoorederdetailBinding;
import com.guoyie.www.delivery.easy.entity.StorageInfo;
import com.guoyie.www.delivery.easy.entity.StorageInfoData;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.StoreAgeDetailModel;
import com.guoyie.www.delivery.easy.presenter.StorAgeDetailPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/13
 */
class InfoOrderDetailActivity  extends BaseActivity<StorAgeDetailPresenter,StoreAgeDetailModel> implements View.OnClickListener, StoreAgeDetaliContract.View {
    private ImageView                     mLeft_back;
    private TextView                      mTv_title;
    private ActivityInfoorederdetailBinding binding;
    private UserInfoData mUserInfo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_infoorederdetail;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {
        binding= DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back = getView(R.id.left_back);
        mLeft_back = getView(R.id.left_back);
        mLeft_back.setOnClickListener(this);
        mTv_title =getView(R.id.tv_title);
        mTv_title.setText("意向单详情"); //从上个页面传回来的数据
        //取得用户的信息
        mUserInfo = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        String id = getIntent().getStringExtra(Constant.STORAGE_DETAIL_ID);
        loadData(id);

    }

    private void loadData(String id) {
        String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.INFO_STORAGE_DETALI + "&id=" + id+"&vendor_no="+mUserInfo.getData().getInfo().getVendor_no()
                +"&vendor_province_code="+mUserInfo.getData().getInfo().getProvince_code()+"&vendor_city_code="+mUserInfo.getData().getInfo().getCity_code());
        mPresenter.requstStorageDetailData(params);

    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void returnStoreAgeDetailData(StorageInfoData data) {
        if (data.isOk()){
            StorageInfo storageInfo = data.getData();
            if (storageInfo!=null){
                //进行数据初始化
                initData(storageInfo);
            }

        }

    }

    private void initData(StorageInfo info) {
        binding.tvGoodsName.setText(info.getGoods_name());//产品名称
        binding.tvGoodsNum.setText(info.getGoods_num()+info.getGoods_unit());//数量和单位
        String status=null;
        //status 状态：1.待编辑，2.待审核，3.未通过，4.入库中，5.已完成，6.已结束
        switch (info.getStatus()){
            case 1:
                status="进行中";
                break;
            case -1:
                status="已取消";
                break;
        }
        binding.tvState.setText(status);//设置状态


        String contract_type=null;
        //contract_type 合同类型:1.储罐-短约，2.储罐-长约，3.储罐-包罐容，4.储罐-包罐
        switch (info.getContract_type()){
            case 1:
                contract_type="短约";
                break;
            case 2:
                contract_type="长约";
                break;
            case 3:
                contract_type="包罐容";
                break;
            case 4:
                contract_type="包罐";
                break;
        }
        binding.tvContractType.setText(contract_type);//合同类型
        binding.tvCreateName1.setText(info.getVendor_name());//企业联系人
        binding.tvCompanyContact.setText(info.getCompany_contact());//联系方式
        binding.tvCompanyName.setText(info.getCompany_name());//企业名称
        binding.tvInquiryNo.setText(info.getInquiry_no());//意向单号

        binding.tvCreateName1.setText(info.getCreate_name());//创建账号
        binding.tvCreateAtStart.setText(info.getCreate_at());//创建时间
        binding.tvApplyArea.setText(info.getProvince_name()+info.getCity_name()+info.getArea_name());//区域
        binding.tvRemark.setText(info.getRemark());//备注信息







        /*
inquiry_no 询价单号goods_name 商品名称vendor_no 服务商编号province_code 省编号city_code 市编号
vendor_province_code 服务商省编号vendor_city_code 服务商市编号area_code 县/县级市
create_at_start 创建开始时间create_at_end 创建结束时间contract_type 合同类型:1.储罐-短约，2.储罐-长约，3.储罐-包罐容，4.储罐-包罐
goods_id 商品IDcreate_name 创建者名字(创建账号)company_id 货主(预约单发起者) 公司company_name 货主(预约单发起者) 公司
company_contact 联系方式vendor_name 服务商名称goods_num 商品数量goods_unit 单位remark 备注
status 询价单状态:   1 =>进行中, -1 =>已取消
         */

    }

    @Override
    public void err_or(String msg) {

    }
}
