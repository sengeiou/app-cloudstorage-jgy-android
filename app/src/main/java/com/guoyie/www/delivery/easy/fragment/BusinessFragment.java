package com.guoyie.www.delivery.easy.fragment;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.drawee.view.SimpleDraweeView;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.activity.InfoOrderActivity;
import com.guoyie.www.delivery.easy.activity.InterOrderActivity;
import com.guoyie.www.delivery.easy.activity.OuterOrderActivity;
import com.guoyie.www.delivery.easy.activity.TransTormorderActivity;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseFragment;
import com.guoyie.www.delivery.easy.contract.BusinessFragmentContract;
import com.guoyie.www.delivery.easy.databinding.FcBusinessBinding;
import com.guoyie.www.delivery.easy.entity.AppVersionBean;
import com.guoyie.www.delivery.easy.entity.Banner;
import com.guoyie.www.delivery.easy.entity.BannerData;
import com.guoyie.www.delivery.easy.entity.UserInfo;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.BusinessFragmentModel;
import com.guoyie.www.delivery.easy.presenter.BusinessFragmentPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.fragment
 * email：774169396@qq.com
 * data：2017/12/4
 * 我的业务的fragment
 */
public class BusinessFragment extends BaseFragment<BusinessFragmentPresenter,BusinessFragmentModel> implements View.OnClickListener, BusinessFragmentContract.View {

    private ImageView         mLeft_back;
    private TextView          mTv_title;
    private FcBusinessBinding binding;
    private List<String> imgs=new ArrayList<>();
    private DownloadManager mDownloadManager;
    private long updateId;
    private Dialog progressDialog;
    private ProgressBar progressBar;
    private TextView mPrecent;

    @Override
    protected int getLayoutResource() {
        return R.layout.fc_business;

    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);
    }

    @Override
    protected void initView() {

        binding = DataBindingUtil.bind(rootView);
        //处理左侧的箭头
        mLeft_back = getView(R.id.left_back);
        mLeft_back.setVisibility(View.GONE);
        mTv_title =  getView(R.id.tv_title);
        mTv_title.setText("我的业务");
        //检查更新
        String params= BlowfishTools.encrypt(HttpUtils.key,HttpUtils.GET_APPVERSION+"&type=1");
        mPresenter.requestAppVersion(params);
        initBanner();
        initIcon();
        initBottom();

    }

    private void initIcon() {
        UserInfoData userInfoData = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if(userInfoData!=null){
            UserInfo data = userInfoData.getData();

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.error(R.drawable.icon);
            Glide.with(this)
                    .load(data.getAvatar())
                    .apply(requestOptions)
                    .into(binding.imageview);

            binding.tvCompanyname.setText(data.getInfo().getVendor_name());//公司名称
            int type = data.getType();
            String serviceDescription = "管理员";
            if (type==0){
                serviceDescription = "普通";
            }
            if (type==1){
                serviceDescription = "管理员";
            }
            binding.tvUserName.setText(data.getLoginname()+" | "+serviceDescription);//用户名和身份
        }
    }

    private void initBanner() {
        //请求轮播图
        String params= BlowfishTools.encrypt(HttpUtils.key,HttpUtils.GET_BANNER);
        mPresenter.requstBanner(params);

      ///  binding.banner.setData(R.mipmap.guide01,R.mipmap.guide02,R.mipmap.guide03);

        binding.banner.setDelegate(new BGABanner.Delegate<CardView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, CardView itemView, String model, int position) {
            //    Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
            }
        });
        binding.banner.setAdapter(new BGABanner.Adapter<CardView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, CardView itemView, String model, int position) {
                SimpleDraweeView simpleDraweeView = itemView.findViewById(R.id.sdv_item_fresco_content);
                simpleDraweeView.setImageURI(Uri.parse(model));
            }
        });

    }


    private void initBottom() {
     //设置下面的四个按钮的点击事件
         binding.llInorder.setOnClickListener(this);
         binding.llOutorder.setOnClickListener(this);
         binding.llTransformorder.setOnClickListener(this);
         binding.llInfoorder.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_inorder:
                startAct(InterOrderActivity.class);
                break;
            case R.id.ll_outorder:
               startAct(OuterOrderActivity.class);
                break;
            case R.id.ll_transformorder:
                startAct(TransTormorderActivity.class);
                break;
                case R.id.ll_infoorder:
                 startAct(InfoOrderActivity.class);
                break;

        }


    }

    @Override
    public void returnBanner(BannerData data) {
        if (data.isOk()){
            List<Banner> banners = data.getData();
            for (Banner banner : banners) {
                imgs.add(banner.getAdpic());
            }
         binding.banner.setData(R.layout.item_fresco, imgs, null);
        }else {//没有数据了
            showToast(data.getMsg());
        }

    }
    /*
    * 检查更新
    *
    * */
    @Override
    public void returnAppVersion(AppVersionBean appVersionBean) {
        if (appVersionBean!=null&&appVersionBean.isOk()){
            final AppVersionBean.DataBean data = appVersionBean.getData();
            PackageManager packageManager = getContext().getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.guoyie.www.delivery.easy", 0);
                if (Integer.parseInt(data.getVarsion().trim())>packageInfo.versionCode){
                    if (data.getCompel().trim().equals("1")){ //强制用户必须更新
                        new AlertDialog.Builder(getContext())
                                .setTitle("版本更新")
                                .setMessage(data.getContent())
                                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        updateApp(data,dialog);
                                    }
                                })
                                .setCancelable(false)
                                .create().show();
                    }else {
                        new AlertDialog.Builder(getContext())
                                .setTitle("版本更新")
                                .setMessage(data.getContent())
                                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        updateApp(data,dialog);
                                    }
                                })
                                .setNegativeButton("暂不更新", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .create().show();
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
    /*
    * 开启更新
    *
    * */
    private void updateApp(AppVersionBean.DataBean data, DialogInterface dialog) {
        mDownloadManager = (DownloadManager) getContext().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(data.getUrl().trim()));
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE | DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle("下载");
        request.setDescription("apk正在下载");
        //设置保存目录  /storage/emulated/0/Android/包名/files/Download
        request.setDestinationInExternalFilesDir(getContext(), Environment.DIRECTORY_DOWNLOADS,"jiaogeyi.apk");
        updateId = mDownloadManager.enqueue(request);
        //注册内容观察者，实时显示进度
        MyContentObserver downloadChangeObserver = new MyContentObserver(null);
        getContext().getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, downloadChangeObserver);
        //广播监听下载完成，开启安装
        completeListener(updateId);
        //弹出一个新的dialog显示下载进度，先隐藏前一个dialog
        dialog.dismiss();
        progressDialog = new Dialog(getContext(),R.style.Theme_AppCompat_Dialog_Alert);
        View view = getLayoutInflater().inflate(R.layout.progress_dialog, null);
        progressBar = view.findViewById(R.id.pb);
        mPrecent = view.findViewById(R.id.tv_precent);
        progressDialog.setContentView(view);
        progressDialog.show();


    }

    private void completeListener(final long updateId) {
        IntentFilter intentFilter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                long longExtra = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                if (updateId == longExtra){
                    Intent install = new Intent(Intent.ACTION_VIEW);
                    File apkFile =getContext().getExternalFilesDir("DownLoad/jiaogeyi.apk");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                        install.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        Uri uriForFile = FileProvider.getUriForFile(context, "com.guoyie.www.delivery.easy.fileprovider", apkFile);
                        install.setDataAndType(uriForFile,"application/vnd.android.package-archive");
                    }else {
                        install.setDataAndType(Uri.fromFile(apkFile),"application/vnd.android.package-archive");
                    }

                    install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(install);
                }
            }
        };
        getContext().registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    public void error(String data) {
        showToast(data);
    }

    /*
    * 自定义内容观察者，实时返回apk下载进度
    *
    * */
    class MyContentObserver extends ContentObserver {

        public MyContentObserver(Handler handler) {
            super(handler);
        }


        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public void onChange(boolean selfChange) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(updateId);
            DownloadManager dManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
            final Cursor cursor = dManager.query(query);
            if (cursor != null && cursor.moveToFirst()) {
                final int totalColumn = cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES);
                final int currentColumn = cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR);
                int totalSize = cursor.getInt(totalColumn);
                int currentSize = cursor.getInt(currentColumn);
                float percent = (float) currentSize / (float) totalSize;
                float progress = (float) Math.floor(percent * 100);
                mPrecent.setText(progress+"%");
                progressBar.setProgress((int) progress,true);
                if (progress == 100)
                    progressDialog.dismiss();
            }
        }

    }
}
