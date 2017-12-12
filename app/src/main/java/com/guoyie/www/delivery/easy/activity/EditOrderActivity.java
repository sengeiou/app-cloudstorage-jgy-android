package com.guoyie.www.delivery.easy.activity;

import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityEditorderBinding;
import com.guoyie.www.delivery.easy.util.DebugUtil;
import com.guoyie.www.delivery.easy.util.PopOneHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/8
 */
public class EditOrderActivity extends BaseActivity implements View.OnClickListener, PopOneHelper.OnClickOkListener,EasyPermissions.PermissionCallbacks, BGASortableNinePhotoLayout.Delegate {
    private ImageView mLeft_back;
    private TextView  mTv_title;
    ActivityEditorderBinding binding;
    private PopOneHelper oneHelper;
    List<String> goods = new ArrayList<>();

    private static final int PRC_PHOTO_PICKER = 1;

    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;

    private static final String EXTRA_MOMENT = "EXTRA_MOMENT";

    @Override
    public int getLayoutId() {
        return R.layout.activity_editorder;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        binding = DataBindingUtil.setContentView(this, getLayoutId());
        mLeft_back = (ImageView) getView(R.id.left_back);

        mLeft_back.setOnClickListener(this);
        binding.llIntertype.setOnClickListener(this);
        //图片选择的逻辑
        binding.snplMomentAddPhotos.setOnClickListener(this);

        binding.tvCommit.setOnClickListener(this);

        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("编辑入库确认单");

        goods.add("进口");
        goods.add("一般");
        goods.add("去口");
        goods.add("走势");
        goods.add("好货");
        goods.add("垃圾");

        binding.snplMomentAddPhotos.setDelegate(this);


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
                // TODO: 2017/12/12 这里处理图片提交的问题
                ArrayList<String> data = binding.snplMomentAddPhotos.getData();
                for (int i = 0; i < data.size(); i++) {
                    DebugUtil.debug(data.get(i));
                }


                break;


        }
    }

    @Override
    public void onClickOk(String birthday, int position) {
        binding.tvIntertype.setText(birthday);





    }



    @AfterPermissionGranted(PRC_PHOTO_PICKER)
    private void choicePhotoWrapper() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话就没有拍照功能
            File takePhotoDir = new File(Environment.getExternalStorageDirectory(), "BGAPhotoPickerTakePhoto");

            Intent photoPickerIntent = new BGAPhotoPickerActivity.IntentBuilder(this)
                    .cameraFileDir(takePhotoDir) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                    .maxChooseCount(binding.snplMomentAddPhotos.getMaxItemCount() - binding.snplMomentAddPhotos.getItemCount()) // 图片选择张数的最大值
                    .selectedPhotos(null) // 当前已选中的图片路径集合
                    .pauseOnScroll(false) // 滚动列表时是否暂停加载图片
                    .build();
            startActivityForResult(photoPickerIntent, RC_CHOOSE_PHOTO);
        } else {
            EasyPermissions.requestPermissions(this, "图片选择需要以下权限:\n\n1.访问设备上的照片\n\n2.拍照", PRC_PHOTO_PICKER, perms);
        }
    }



    @Override
    public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
        choicePhotoWrapper();
    }

    @Override
    public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        binding.snplMomentAddPhotos.removeItem(position);
    }

    @Override
    public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(this)
                .previewPhotos(models) // 当前预览的图片路径集合
                .selectedPhotos(models) // 当前已选中的图片路径集合
                .maxChooseCount(binding.snplMomentAddPhotos.getMaxItemCount()) // 图片选择张数的最大值
                .currentPosition(position) // 当前预览图片的索引
                .isFromTakePhoto(false) // 是否是拍完照后跳转过来
                .build();
        startActivityForResult(photoPickerPreviewIntent, RC_PHOTO_PREVIEW);
    }

    @Override
    public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {
        Toast.makeText(this, "排序发生变化", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (requestCode == PRC_PHOTO_PICKER) {
            Toast.makeText(this, "您拒绝了「图片选择」所需要的相关权限!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RC_CHOOSE_PHOTO) {
            binding.snplMomentAddPhotos.addMoreData(BGAPhotoPickerActivity.getSelectedPhotos(data));
        } else if (requestCode == RC_PHOTO_PREVIEW) {
            binding.snplMomentAddPhotos.setData(BGAPhotoPickerPreviewActivity.getSelectedPhotos(data));
        }
    }

}