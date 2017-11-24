package www.guoyie.com.delivery.easy.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * author：柯军
 * project：FocusEditText
 * package：com.luck.focusedittext
 * email：774169396@qq.com
 * data：2017/4/11
 */

@SuppressLint("AppCompatCustomView")
public class FocusEditText extends EditText implements SoftKeyBoardListener.OnSoftKeyBoardChangeListener {
    public FocusEditText(Context context) {
        super(context);
        init();
    }

    public FocusEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        Activity activity = (Activity) getContext();
        SoftKeyBoardListener.setListener(activity, this);
    }

    @Override
    public void keyBoardShow(int height) {

    }

    @Override
    public void keyBoardHide(int height) {
        this.clearFocus();
    }

}
