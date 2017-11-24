package www.guoyie.com.delivery.easy.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import www.guoyie.com.delivery.easy.R;


/**
 * Created by necer on 2016/11/28.
 */

public class SwipeRefreshLayoutt extends SwipeRefreshLayout {
    public SwipeRefreshLayoutt(Context context) {
        super(context);
        initUI();
    }

    public SwipeRefreshLayoutt(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUI();
    }

    private void initUI() {
        setSize(SwipeRefreshLayout.DEFAULT);
        setColorSchemeResources(R.color.app_color_blue);
    }


}
