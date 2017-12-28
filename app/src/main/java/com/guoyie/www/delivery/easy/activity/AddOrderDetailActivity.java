package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.AddOrderDetailContract;
import com.guoyie.www.delivery.easy.databinding.ActivityEditorderdetailBinding;
import com.guoyie.www.delivery.easy.entity.InputOrderDetail;
import com.guoyie.www.delivery.easy.entity.OuterOrderDetail;
import com.guoyie.www.delivery.easy.model.AddOrderDetailModel;
import com.guoyie.www.delivery.easy.presenter.AddOrderPresenter;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.util.PopDateHelper;
import com.guoyie.www.delivery.easy.util.PopOneHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/8
 */
public class AddOrderDetailActivity extends BaseActivity<AddOrderPresenter,AddOrderDetailModel> implements View.OnClickListener, PopOneHelper.OnClickOkListener, PopDateHelper.OnClickOkListener, AddOrderDetailContract.View {
    private ImageView mLeft_back;
    private TextView  mTv_title;
    private ActivityEditorderdetailBinding binding;
    private PopOneHelper oneHelper;
    private PopDateHelper dateHelper;
    List<String>nums=new ArrayList<>();
    private int              mType;
    private InputOrderDetail mInputOrderDetail;
    private OuterOrderDetail mOuterOrderDetail;


    @Override
    public int getLayoutId() {
        return R.layout.activity_editorderdetail;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {

        binding = DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back =  getView(R.id.left_back);

        mLeft_back.setOnClickListener(this);
        binding.llIntertime.setOnClickListener(this);

        binding.llGoogsxingzhi.setOnClickListener(this);
        binding.llGuanNum.setOnClickListener(this);
        mTv_title =  getView(R.id.tv_title);


        //拿到点击时候的传递的type只
        Intent intent = getIntent();
        //type=1,是入库单处理的逻辑 2是出库单的逻辑
        mType = intent.getIntExtra(Constant.STOCK_TYPE, 0);
        switch (mType){
            case 1:
                mInputOrderDetail = (InputOrderDetail) intent.getSerializableExtra(Constant.INPUT_EDIT_ORDER);
                break;
            case 2:
                mOuterOrderDetail = (OuterOrderDetail) intent.getSerializableExtra(Constant.OUTER_EDIT_ORDER);
                break;
        }

        initData(mType);

    //    mTv_title.setText("添加入库明细单");

        nums.add("1号罐");
        nums.add("2号罐");
        nums.add("3号罐");
        nums.add("4号罐");

    }

    private void initData(int type) {
        switch (type){
            case 1://添加入库的逻辑
                mTv_title.setText("添加入库明细单");//标题
                binding.goodsName.setText(mInputOrderDetail.getGoods_name());//商品名臣
                binding.orderQty.setText(mInputOrderDetail.getOrder_qty()+mInputOrderDetail.getGoods_unit());//入库数量和单位
                binding.goodsNature.setText(mInputOrderDetail.getGoods_nature());//货物性质写死的
                break;
            case 2://添加出库明细
                mTv_title.setText("添加出库明细单");//标题
                binding.goodsName.setText(mOuterOrderDetail.getGoods_name());//商品名臣
                binding.orderQty.setText(mOuterOrderDetail.getOrder_qty()+mOuterOrderDetail.getGoods_unit());//入库数量和单位
                binding.tvTitleNum.setText("预约出库数量/单位");//预约数量的修改
                binding.tvStockTime.setText("出库时间");//出库时间
                binding.tvStockOrderNum.setText("出库单号");//出库单号
                binding.tvStockNum.setText("出库数量");

                break;
        }

    }

    @Override
    public void onClick(View view) {
        oneHelper = new PopOneHelper(this);
            dateHelper = new PopDateHelper(this);
            dateHelper.setObsolete(true);
        oneHelper.setOnClickOkListener(this);
        dateHelper.setOnClickOkListener(this);
        switch (view.getId()){
            case  R.id.left_back:
                finish();
                break;
            case R.id.ll_intertime:
                dateHelper.show(view);
                break;
            case R.id.ll_guan_num:
                oneHelper.setListData(nums);
                oneHelper.show(view);
                break;


        }

    }

    @Override
    public void onClickOk(String birthday, int position) {
              binding.tvGuannum.setText(birthday);

    }

    @Override
    public void onClickOk(String birthday) {
        binding.tvTime.setText(birthday);

    }

    @Override
    public void returnAddStcokInter(BaseResponse data) {

    }

    @Override
    public void returnAddStcokOuter(BaseResponse data) {

    }

    @Override
    public void error(String msg) {

    }
}
