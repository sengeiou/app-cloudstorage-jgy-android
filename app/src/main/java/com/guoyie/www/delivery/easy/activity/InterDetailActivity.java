package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.InterOrderDetailContract;
import com.guoyie.www.delivery.easy.databinding.ActivityInterdetailBinding;
import com.guoyie.www.delivery.easy.dialog.CustomDialog;
import com.guoyie.www.delivery.easy.entity.InputOrderDetail;
import com.guoyie.www.delivery.easy.entity.InputOrderDetailData;
import com.guoyie.www.delivery.easy.model.InputorderDetaliModel;
import com.guoyie.www.delivery.easy.presenter.InputOrderDetaliPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.util.DebugUtil;
import com.guoyie.www.delivery.easy.util.Tools;

import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/7
 */
public class InterDetailActivity extends BaseActivity<InputOrderDetaliPresenter,InputorderDetaliModel> implements View.OnClickListener, InterOrderDetailContract.View {
    private ImageView mLeft_back;
    private TextView  mTv_title;
    private ActivityInterdetailBinding binding;
    private InputOrderDetail mDetail;
    private String mId;
    private TextView mTv_right;

    @Override
    public int getLayoutId() {
        return R.layout.activity_interdetail;
    }


    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back =  getView(R.id.left_back);
        binding.tvRefused.setOnClickListener(this);
        binding.tvAgree.setOnClickListener(this);
        mLeft_back.setOnClickListener(this);
        binding.llInterRefusedAgree.setVisibility(View.GONE);
        mTv_title =  getView(R.id.tv_title);
        mTv_right = getView(R.id.tv_right);
        mTv_right.setOnClickListener(this);//完成入库的按钮
        mTv_right.setText("完成入库");
        mTv_title.setText("入库单详情");
        //从上个页面传回来的数据
        mId = getIntent().getStringExtra(Constant.INPUT_ORDER_ID);
    //    loadData(id);

    }

    private void loadData(String id) {
        String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.INTER_ORDER_DETAIL + "&id=" + id);
        mPresenter.requstInterOrderDetail(params);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.tv_refused:
            //调到编辑详情页面status 4:审核通过 3:审核不通过
                String refused = binding.tvRefused.getText().toString().trim();
            if (refused.equals("拒绝")){
                showUpdateDialog(3,"提示","确定拒绝本条入库单？",false);
            }else {
                if (mDetail!=null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constant.STOCK_TYPE,1);
                    bundle.putSerializable(Constant.INPUT_EDIT_ORDER, mDetail);
                    startAct(EditOrderActivity.class,bundle);
                }

            }
                break;
            case R.id.tv_agree:
                //调到订单编辑页面

                //调到编辑详情页面status 4:审核通过 3:审核不通过
                String agree = binding.tvAgree.getText().toString().trim();
                if (agree.equals("通过")){
                    showUpdateDialog(4,"提示","确定同意本条入库单？",false);
                }else {
                    //处理从详情页传回来数据
                    if (mDetail!=null) {

                        Bundle bundle = new Bundle();
                        bundle.putInt(Constant.STOCK_TYPE,1);
                        bundle.putSerializable(Constant.INPUT_EDIT_ORDER, mDetail);
                        startAct(AddOrderDetailActivity.class,bundle);
                    }
                }

                break;

            case R.id.ll_ca_viewpath://CA的跳转
                    String ca_viewpath = mDetail.getCa_viewpath();
                    if (!Tools.isNull(ca_viewpath)) {
                        Bundle bundle = new Bundle();
                        bundle.putString(Constant.TRANSSTOCK_CA_ID, ca_viewpath);
                        startAct(CAActivity.class, bundle);
                    }else {
                        showToast("附件地址不存在");

            }
                 break;

            case R.id.ll_ca_confirm_viewpath://确定CA的跳转
                    String ca_confirm_viewpath = mDetail.getCa_confirm_viewpath();
                if (!Tools.isNull(ca_confirm_viewpath)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(Constant.TRANSSTOCK_CA_ID, ca_confirm_viewpath);
                    startAct(CAActivity.class, bundle);
                }else {
                    showToast("附件地址不存在");
                }

                break;


            case R.id.tv_right:
                showUpdateDialog(0,"是否确认完成入库?", "确认完成后，该订单为已完成\n" +"内容不可更改。",true);
                break;

        }



    }



    private void showUpdateDialog(final int status, String title, String message, final boolean isok) {
        final CustomDialog dialog = new CustomDialog(mContext, GApp.screenWidth * 3 / 4,
                GApp.screenHeight / 4, R.layout.wind_base_dialog_xml, R.style.Theme_dialog);
        Button btn_cancel =  dialog.findViewById(R.id.btn_cancel);
        Button btn_commit =  dialog.findViewById(R.id.btn_commit);
        TextView tv_title = dialog.findViewById(R.id.tv_title);
        TextView tv_content =  dialog.findViewById(R.id.tv_content);
        tv_title.setText(title);
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

               if (isok){//完成入库的接口
                   String params1 = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.INTER_OUTER_HANDLE + "&id=" + mDetail.getId() + "&type=入库"
                   +"&real_qty="+(mDetail.getReal_qty()==null?0:mDetail.getReal_qty())+"&shop_company_id="+mDetail.getShop_company_id());
                   String encrypt = BlowfishTools.decrypt(HttpUtils.key, params1);
                   DebugUtil.debug("heheh"+encrypt);
                   mPresenter.requstInterHandle(params1);

               }else {
                   //走审核通过的接口的逻辑
                   String params2 = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.INTER_ORDER_UPDATE + "&id=" + mDetail.getId() + "&status=" + status);
                   String encrypt = BlowfishTools.decrypt(HttpUtils.key, params2);
                   DebugUtil.debug("heheh"+encrypt);
                   mPresenter.requstInterOrderUpdate(params2);
               }

                dialog.dismiss();




            }

        });
        dialog.show();
    }

    @Override
    public void returnInterOrderDetailData(InputOrderDetailData data) {
       //进行数据处理
        if (data.isOk()){
            mDetail = data.getData();
            if (mDetail !=null){
                initData(mDetail);
            }
        }

    }

    @Override
    public void retrunInterOrderDetailUpdate(BaseResponse data) {
        if (data.isOk()){
            showToast(data.getMsg());
            finish();
        }

    }

    @Override
    public void returnInterHandle(BaseResponse data) {
        //返回处理完成入库的数据
        if (data.isOk()){
            showToast(data.getMsg());
            finish();
        }else{
            showToast(data.getMsg());
        }



    }

    private void initData(InputOrderDetail data) {
        //处理大概信息的数据
        String status=null;
        //status 状态：1.待编辑，2.待审核，3.未通过，4.入库中，5.已完成，6.已结束
        switch (data.getStatus()){
            case 1:
                status="待编辑";
                break;
            case 2:
                status="待审核";
                binding.llInterRefusedAgree.setVisibility(View.VISIBLE);//出现通过和拒绝的按钮
                binding.tvComfigOrder.setVisibility(View.GONE);//在待审核和未完成的时候不显示入库确定单
                binding.llComfigOrder.setVisibility(View.GONE);//在待审核和未完成的时候不显示入库确定单
                break;
            case 3:
                status="未通过";
                binding.tvComfigOrder.setVisibility(View.GONE);//在待审核和未完成的时候不显示入库确定单
                binding.llComfigOrder.setVisibility(View.GONE);//在待审核和未完成的时候不显示入库确定单
                break;
            case 4:
                status="入库中";
                binding.llInterRefusedAgree.setVisibility(View.VISIBLE);//出现通过和拒绝的按钮
                binding.tvRefused.setText("编辑入库确认单");
                binding.tvAgree.setText("添加入库明细");
                break;
            case 5:
                status="已完成";
                //设置个完成时间的字段
                binding.llFinishAt.setVisibility(View.VISIBLE);
                binding.finishAt.setText(data.getFinish_at());//完成时间
                break;
            case 6:
                status="已结束";
                break;
        }

        binding.status.setText(status);//设置状态
        binding.instockDate.setText(data.getInstock_date());//预计入库时间
        binding.instockCustomerNo.setText(data.getInstock_customer_no());//入库单号
        String instock_source="";
        switch (data.getInstock_source()){
            case 1:
                instock_source="交易平台";
                break;
            case 2:
                instock_source="自主生成";
                break;
        }

        binding.instockSource.setText(instock_source);//订单来源
        binding.contactName.setText(data.getContact_name());//企业联系人
        binding.contact.setText(data.getContact());//联系方式
        binding.shopCompanyName.setText(data.getShop_company_name());//企业名称

        //商品明细的数据
        binding.goodsName.setText(data.getGoods_name()+" | "+data.getOrder_qty()+data.getGoods_unit());//品名
        binding.goodsNature.setText(data.getGoods_nature());//货物的性质
        binding.remark.setText("备注："+data.getGoods_remark());//备注

        //入库单详细信息
        binding.shopOrderNo.setText(data.getShop_order_no());//交易平台订单号
        binding.createAt.setText(data.getCreate_at());//创建时间
        binding.llCaViewpath.setOnClickListener(this);//设置查看附件的点击事件
        binding.tvRemark.setText(data.getRemark());//备注
        //处理车辆明细的数据
        initcars(data.getCar());
        //处理车辆明细的数据
        initShips(data.getShip());
        //入库确认单的数据
        binding.instockType.setText(data.getInstock_type()==1?"车入库":"船入库");//入库的方式
        binding.realQty.setText(Tools.isNull(data.getReal_qty())?"0":data.getReal_qty());//入库数量
        binding.realContactName.setText(data.getReal_contact_name());//仓库联系人
        binding.tvGoodsName.setText(data.getGoods_name());//品名
        binding.contactNum.setText(data.getReal_contact());
        binding.llCaConfirmViewpath.setOnClickListener(this);
        binding.realReamk.setText(data.getReal_remark());//实际备注

        //入库明细的处理
        initLogs(data.getLog());






    }

    private void initLogs(List<InputOrderDetail.LogBean> log) {
        if (log.size()>0){
            if (mDetail.getStatus()==4){
                mTv_right.setVisibility(View.VISIBLE);//让完成入库的按钮可见
            }

            binding.gridLayoutLogs.removeAllViews();

            for (int i = 0; i < log.size(); i++) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.logs_items, null, false);
                TextView goods_name = view.findViewById(R.id.goods_name);//丙乙烯 | 1000.00吨
                TextView goods_nature = view.findViewById(R.id.goods_nature);//内贸内销
                TextView instock_detail_no = view.findViewById(R.id.instock_detail_no);//入库单号
                TextView jar_no = view.findViewById(R.id.jar_no);//进货罐号
                TextView number = view.findViewById(R.id.number);//车编号|船编号
                TextView instock_date = view.findViewById(R.id.instock_date);//入库时间
                TextView remark = view.findViewById(R.id.tv_remark);//备注
                InputOrderDetail.LogBean logBean = log.get(i);

                goods_name.setText(logBean.getGoods_name() + " | " + logBean.getStock_qty() + logBean.getGoods_unit());//品名
                goods_nature.setText(logBean.getGoods_nature());//货物的性质
                instock_detail_no.setText(logBean.getInstock_detail_no());//
                jar_no.setText(logBean.getJar_no());//
                number.setText(logBean.getNumber());//
                instock_date.setText(logBean.getInstock_date());//
                remark.setText(logBean.getRemark());//
                binding.gridLayoutLogs.addView(view);
                View line = LayoutInflater.from(mContext).inflate(R.layout.line, null, false);
                if (i!= log.size() - 1) {
                    binding.gridLayoutLogs.addView(line);
                }
            }
        }else {
            binding.tvTitleLogs.setVisibility(View.GONE);//没有数据让头部剧再见
        }


    }

    private void initShips(List<InputOrderDetail.ShipBean> ship) {
        if (ship.size()>0){
            binding.gridLayoutShip.removeAllViews();
            for (int i = 0; i < ship.size(); i++) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.ships_item, null, false);
                TextView  shipno=view.findViewById(R.id.shipno);//船编号
                TextView  captain=view.findViewById(R.id.captain);//船长
                TextView  shipname=view.findViewById(R.id.shipname);//船名
                TextView  shipcontact=view.findViewById(R.id.shipcontact);//联系方式
                TextView  remark=view.findViewById(R.id.remark);//备注
                InputOrderDetail.ShipBean shipBean = ship.get(i);
                shipno.setText(shipBean.getShipno());//船编号
                captain.setText(shipBean.getCaptain());//船长
                shipname.setText(shipBean.getShipname());//船名
                shipcontact.setText(shipBean.getShipcontact());//联系方式
                remark.setText(shipBean.getShipmark());//备注
                binding.gridLayoutShip.addView(view);
                View line = LayoutInflater.from(mContext).inflate(R.layout.line, null, false);
                if (i!= ship.size() - 1) {
                    binding.gridLayoutShip.addView(line);
                }
            }


        }else {
            binding.tvTitleShip.setVisibility(View.GONE);//没有数据让头部剧再见
        }


    }

    private void initcars(List<InputOrderDetail.CarBean> car) {
        if (car.size()>0){
            binding.gridLayoutCar.removeAllViews();
            for (int i = 0; i < car.size(); i++) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.cars_item, null, false);
                TextView  carid=view.findViewById(R.id.carid);//车牌号
                TextView  carname=view.findViewById(R.id.carname);//司机姓名
                TextView  mobilephone=view.findViewById(R.id.mobilephone);//联系方式
                TextView  idcard=view.findViewById(R.id.idcard);//身份证号
                TextView  remark=view.findViewById(R.id.remark);//备注
                InputOrderDetail.CarBean carBean = car.get(i);
                carid.setText(carBean.getCarid());//车牌号
                carname.setText(carBean.getCarname());//司机姓名
                mobilephone.setText(carBean.getMobilephone());//联系方式
                idcard.setText(carBean.getIdcard());//身份证号
                remark.setText(carBean.getCarmarks());//备注
                binding.gridLayoutCar.addView(view);
                View line = LayoutInflater.from(mContext).inflate(R.layout.line, null, false);
                if (i!= car.size() - 1) {
                    binding.gridLayoutCar.addView(line);
                }
            }

        }else {
            binding.tvTitleCar.setVisibility(View.GONE);//没有数据让头部剧再见
        }

    }

    @Override
    public void error(String msg) {
        showToast(msg);

    }


    @Override
    protected void onResume() {
        super.onResume();
        loadData(mId);
    }
}
