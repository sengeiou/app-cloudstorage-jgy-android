package www.guoyie.com.delivery.easy.receiver;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import www.guoyie.com.delivery.easy.download.ApkUpdateUtils;
import www.guoyie.com.delivery.easy.download.SpUtils;
/**
 * Created by 闫彬彬 on 2017/7/27.
 */

public class InstallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
            long downloadId = SpUtils.getInstance(context).getLong(ApkUpdateUtils.KEY_DOWNLOAD_ID, -1L);
            long downLoadId1 = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -2);

            if (downloadId == downLoadId1) {
                DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(downloadId);
                Intent intent1 = new Intent();
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.setDataAndType(uriForDownloadedFile, "application/vnd.android.package-archive");
                context.startActivity(intent1);
            }
        }
    }
}


