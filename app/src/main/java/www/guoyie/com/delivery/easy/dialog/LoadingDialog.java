package www.guoyie.com.delivery.easy.dialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import www.guoyie.com.delivery.easy.R;

public class LoadingDialog extends Dialog {
    public Context context;

    public LoadingDialog(Context context) {
        super(context, R.style.alert_dialog);
        this.context = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.setWindowAnimations(R.style.DialogWindowStyle);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
    }
}