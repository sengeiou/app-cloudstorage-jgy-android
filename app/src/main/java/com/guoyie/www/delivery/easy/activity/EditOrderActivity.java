package com.guoyie.www.delivery.easy.activity;

import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.FullyGridLayoutManager;
import com.guoyie.www.delivery.easy.adapter.GridImageAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.EditOrderContract;
import com.guoyie.www.delivery.easy.databinding.ActivityEditorderBinding;
import com.guoyie.www.delivery.easy.entity.InputOrderDetail;
import com.guoyie.www.delivery.easy.entity.OuterOrderDetail;
import com.guoyie.www.delivery.easy.model.EditOrderModel;
import com.guoyie.www.delivery.easy.presenter.EditOrderPresenter;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.util.PopOneHelper;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/8
 */
public class EditOrderActivity extends BaseActivity<EditOrderPresenter,EditOrderModel> implements View.OnClickListener, PopOneHelper.OnClickOkListener, EditOrderContract.View {
    private ImageView mLeft_back;
    private TextView  mTv_title;
    ActivityEditorderBinding binding;
    private PopOneHelper oneHelper;
    List<String> goods = new ArrayList<>();

    private List<LocalMedia> selectList = new ArrayList<>();
    private RecyclerView     recyclerView;
    private GridImageAdapter adapter;
   // private int maxSelectNum = 9;
    private int              mType;
    private InputOrderDetail mInputOrderDetail;
    private OuterOrderDetail mOuterOrderDetail;

    @Override
    public int getLayoutId() {
        return R.layout.activity_editorder;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {

        binding = DataBindingUtil.setContentView(this, getLayoutId());
        mLeft_back =  getView(R.id.left_back);
        recyclerView =  findViewById(R.id.recycler);

        mLeft_back.setOnClickListener(this);
        binding.llIntertype.setOnClickListener(this);
        binding.tvCommit.setOnClickListener(this);
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
    //    mTv_title.setText("编辑入库确认单");

        initRecycleView();

    }

    private void initData(int type) {
        switch (type){
            case 1:
                //出事入库单的逻辑
                mTv_title.setText("编辑入库确认单");//标题
                binding.goodsName.setText(mInputOrderDetail.getGoods_name());//商品名称
                binding.instockType.setText(mInputOrderDetail.getInstock_type()==1?"车入库":"船入库");//入库类型
                binding.contactName.setText(mInputOrderDetail.getContact_name());//仓库联系人
                binding.contact.setText(mInputOrderDetail.getContact());//仓库联系方式
                //初始化选择器的数据
                goods.add("车入库");
                goods.add("船入库");
                break;

            case 2:
                //出事入库单的逻辑
                mTv_title.setText("编辑出库确认单");//标题
                binding.goodsName.setText(mOuterOrderDetail.getGoods_name());//商品名称
                binding.instockType.setText(mOuterOrderDetail.getOutstock_type()==1?"车出库":"船出库");//入库类型
                binding.contactName.setText(mOuterOrderDetail.getContact_name());//仓库联系人
                binding.contact.setText(mOuterOrderDetail.getContact());//仓库联系方式
                //初始化选择器的数据
                goods.add("车出库");
                goods.add("船出库");
                break;
        }


    }

    private void initRecycleView() {

        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(10000);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (selectList.size() > 0) {
                    LocalMedia media = selectList.get(position);
                    String pictureType = media.getPictureType();
                    int mediaType = PictureMimeType.pictureToVideo(pictureType);
                    switch (mediaType) {
                        case 1:
                            // 预览图片 可自定长按保存路径
                            //PictureSelector.create(MainActivity.this).externalPicturePreview(position, "/custom_file", selectList);
                            PictureSelector.create(EditOrderActivity.this).externalPicturePreview(position, selectList);
                            break;
                    }
                }
            }
        });

        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureFileUtils.deleteCacheDirFile(EditOrderActivity.this);
                } else {
                    Toast.makeText(EditOrderActivity.this,
                            getString(R.string.picture_jurisdiction), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });

    }


    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
                // 进入相册 以下是例子：不需要的api可以不写
                PictureSelector.create(EditOrderActivity.this)
                        .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                        .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                        .maxSelectNum(100000)// 最大图片选择数量
                        .minSelectNum(1)// 最小选择数量
                        .imageSpanCount(4)// 每行显示个数
                        .selectionMode(PictureConfig.MAX_COMPRESS_SIZE )// 多选 or 单选
                        .previewImage(true)// 是否可预览图片
                        .isCamera(true)// 是否显示拍照按钮
                        .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                        .compress(true)// 是否压缩
                        .synOrAsy(true)//同步true或异步false 压缩 默认同步
                        .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                        .selectionMedia(selectList)// 是否传入已选图片
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code

        }

    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    for (LocalMedia media : selectList) {
                        Log.i("图片-----》", media.getPath());
                        Log.i("图片--》", media.getCompressPath());
                     //   File file=new File(media.getCompressPath());
                       // RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
                      //  mPresenter.requstreturneditLoadobj(requestBody);

                       // Map<String , RequestBody> params=new HashMap<>();
                       // params.put(params)


                    }
                    adapter.setList(selectList);
                    adapter.notifyDataSetChanged();
                    break;

            }
        }
    }

    @Override
    public void onClick(View view) {

        oneHelper = new PopOneHelper(this);
        oneHelper.setOnClickOkListener(this);
        switch (view.getId()) {
            case R.id.left_back:
                finish();
                break;
            case R.id.ll_intertype:
                oneHelper.setListData(goods);
                oneHelper.show(view);
                break;

            case R.id.tv_commit:

                break;


        }
    }

    @Override
    public void onClickOk(String birthday, int position) {
        binding.instockType.setText(birthday);
    }

    @Override
    public void returneditinterstock(BaseResponse data) {

    }

    @Override
    public void returneditouterstock(BaseResponse data) {

    }

    @Override
    public void returneditLoadobj(BaseResponse data) {

    }

    @Override
    public void eeror(String msg) {

    }
}

