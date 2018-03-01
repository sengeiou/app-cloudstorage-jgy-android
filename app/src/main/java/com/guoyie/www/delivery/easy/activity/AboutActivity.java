package com.guoyie.www.delivery.easy.activity;

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
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.contract.AboutContract;
import com.guoyie.www.delivery.easy.databinding.ActivityAboutBinding;
import com.guoyie.www.delivery.easy.entity.AppVersionBean;
import com.guoyie.www.delivery.easy.model.AboutModel;
import com.guoyie.www.delivery.easy.presenter.AboutPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;

import java.io.File;

public class AboutActivity extends BaseActivity<AboutPresenter,AboutModel> implements View.OnClickListener,AboutContract.View{
    private ActivityAboutBinding mBinding;
    private ImageView leftBack;
    private TextView title;
    private int mVersionCode;
    private String mVersionName;
    private DownloadManager mDownloadManager;
    private long updateId;
    private Dialog progressDialog;
    private ProgressBar progressBar;
    private TextView mPrecent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);
    }

    @Override
    public void initView() {

        mBinding = DataBindingUtil.setContentView(this,getLayoutId());

        //处理左侧的箭头
        leftBack = (ImageView) getView(R.id.left_back);
        title = (TextView) getView(R.id.tv_title);
        title.setText("关于交割易");
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            mVersionCode = packageInfo.versionCode;
            mVersionName = packageInfo.versionName;
            mBinding.tvVersion.setText(mVersionName);
        } catch (PackageManager.NameNotFoundException
                e) {
            e.printStackTrace();
        }

        leftBack.setOnClickListener(this);
        //点击检查更新
        mBinding.tvCheckUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.tv_check_update:
                String params= BlowfishTools.encrypt(HttpUtils.key,HttpUtils.GET_APPVERSION+"&type=1");
                mPresenter.requestVersion(params);
                break;

        }
    }


    @Override
    public void returnVersion(AppVersionBean appVersionBean) {
        if (appVersionBean!=null&&appVersionBean.isOk()){
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo("com.guoyie.www.delivery.easy", 0);
                final AppVersionBean.DataBean data = appVersionBean.getData();
                if (data.getVarsion().trim().equals(packageInfo.versionCode+"")){
                    showToast("已是最新版本");
                }else {
                    new AlertDialog.Builder(this)
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
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private void updateApp(AppVersionBean.DataBean data, DialogInterface dialog) {
        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(data.getUrl().trim()));
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE | DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle("下载");
        request.setDescription("apk正在下载");
        //设置保存目录  /storage/emulated/0/Android/包名/files/Download
        request.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS,"jiaogeyi.apk");
        updateId = mDownloadManager.enqueue(request);
        //注册内容观察者，实时显示进度
        MyContentObserver downloadChangeObserver = new MyContentObserver(null);
        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, downloadChangeObserver);
        //广播监听下载完成，开启安装
        completeListener(updateId);
        //弹出一个新的dialog显示下载进度，先隐藏前一个dialog
        dialog.dismiss();
        progressDialog = new Dialog(this, R.style.Theme_AppCompat_Dialog_Alert);
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
                    File apkFile =getExternalFilesDir("DownLoad/jiaogeyi.apk");
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
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    public void error(String msg) {
        showToast(msg);
    }

    class MyContentObserver extends ContentObserver {

        public MyContentObserver(Handler handler) {
            super(handler);
        }

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public void onChange(boolean selfChange) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(updateId);
            DownloadManager dManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
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
