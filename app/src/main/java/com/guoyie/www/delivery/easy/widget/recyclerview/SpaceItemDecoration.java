package com.guoyie.www.delivery.easy.widget.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.widget.recyclerview
 * email：1649369473@qq.com
 * data：2017/12/12
 *
 * 添加RecyclerViewItem之间的间隔
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int leftSpace;
    private int topSpace;
    private int rightSpace;
    private int bottomSpace;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.bottom = bottomSpace;
        if (parent.getChildAdapterPosition(view)%3==0){  //最左边的item不要marginleft
            outRect.left = 0;
            outRect.right = leftSpace;
        }
        if (parent.getChildAdapterPosition(view)%3==2){  //最右边的item不要marginright
            outRect.right = 0;
            outRect.left = leftSpace;
        }
        if (parent.getChildAdapterPosition(view) <=2){   //最上边一行需要margintop
            outRect.top = topSpace;
        }
        if (parent.getChildAdapterPosition(view)%3==1){  //中间的item既需要marginleft又需要marginright
            outRect.left = leftSpace/2;
            outRect.right = rightSpace/2;
        }
    }

    public SpaceItemDecoration(int leftSpace, int topSpace, int rightSpace, int bottomSpace) {
        this.leftSpace = leftSpace;
        this.topSpace = topSpace;
        this.rightSpace = rightSpace;
        this.bottomSpace = bottomSpace;
    }
}
