package www.guoyie.com.delivery.easy.util;

import android.content.Context;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by zhuodao on 2016/9/5.
 */
public class InputUtils {

    /**
     * 显示软键盘
     */
    public static void popupSoftInput(final Context context, final EditText et_input) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(et_input, 0);
            }
        }, 10);
    }

    /**
     * 隐藏软键盘
     */
    public static void hideSoftInput (Context context, EditText et_input) {
        InputMethodManager im = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(et_input.getWindowToken(), 0);
    }
}
